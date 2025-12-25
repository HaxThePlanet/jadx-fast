//! SSA (Static Single Assignment) variable infrastructure
//!
//! This module provides SSA variable tracking that matches JADX's SSAVar system.
//! SSA form is critical for:
//! - Type inference (propagating types through def-use chains)
//! - Dead code elimination (finding unused variables)
//! - Copy propagation (inlining simple assignments)
//! - PHI node handling (merging values at control flow joins)

use std::collections::{HashMap, HashSet};
use crate::types::ArgType;

/// SSA variable representing a single definition of a register
///
/// In SSA form, each variable is assigned exactly once. Different assignments
/// to the same register get different versions (r0v0, r0v1, r0v2, etc.).
///
/// Matches JADX's `jadx.core.dex.instructions.args.SSAVar`
#[derive(Debug, Clone)]
pub struct SSAVar {
    /// Register number (from DEX bytecode)
    pub reg_num: u16,
    /// Version number (unique per register per definition)
    pub version: u32,
    /// Instruction index where this variable is assigned (definition)
    pub assign_insn_idx: Option<u32>,
    /// List of instruction indices that use this variable
    pub use_list: Vec<u32>,
    /// PHI instructions where this variable is used as an argument
    pub used_in_phi: Vec<u32>,
    /// Type information for this variable
    pub type_info: TypeInfo,
    /// Code variable (for variable naming after type inference)
    pub code_var: Option<CodeVarId>,
    /// Flags for this SSA variable
    pub flags: u64,
}

/// Code variable ID (groups SSA variables that represent the same source variable)
pub type CodeVarId = u32;

impl SSAVar {
    /// Create a new SSA variable
    pub fn new(reg_num: u16, version: u32) -> Self {
        SSAVar {
            reg_num,
            version,
            assign_insn_idx: None,
            use_list: Vec::new(),
            used_in_phi: Vec::new(),
            type_info: TypeInfo::new(),
            code_var: None,
            flags: 0,
        }
    }

    /// Create with assignment instruction
    pub fn with_assign(reg_num: u16, version: u32, assign_insn_idx: u32) -> Self {
        SSAVar {
            reg_num,
            version,
            assign_insn_idx: Some(assign_insn_idx),
            use_list: Vec::new(),
            used_in_phi: Vec::new(),
            type_info: TypeInfo::new(),
            code_var: None,
            flags: 0,
        }
    }

    /// Get the use count (number of places this variable is read)
    pub fn use_count(&self) -> usize {
        self.use_list.len()
    }

    /// Check if this variable is used in any PHI instruction
    pub fn is_used_in_phi(&self) -> bool {
        !self.used_in_phi.is_empty()
    }

    /// Check if this variable is assigned in a PHI instruction
    pub fn is_assigned_in_phi(&self) -> bool {
        // Will be checked by examining the instruction type
        self.flags & SSA_FLAG_PHI_ASSIGN != 0
    }

    /// Check if type is immutable (cannot be changed by type inference)
    pub fn is_type_immutable(&self) -> bool {
        self.flags & SSA_FLAG_IMMUTABLE_TYPE != 0
    }

    /// Mark type as immutable
    pub fn mark_type_immutable(&mut self) {
        self.flags |= SSA_FLAG_IMMUTABLE_TYPE;
    }

    /// Get immutable type if set
    pub fn get_immutable_type(&self) -> Option<&ArgType> {
        if self.is_type_immutable() {
            Some(&self.type_info.var_type)
        } else {
            None
        }
    }

    /// Set the type (respects immutability)
    pub fn set_type(&mut self, ty: ArgType) -> bool {
        if self.is_type_immutable() {
            return false;
        }
        self.type_info.var_type = ty;
        true
    }

    /// Force set type (ignores immutability)
    pub fn force_set_type(&mut self, ty: ArgType) {
        self.type_info.var_type = ty;
    }

    /// Add a use site
    pub fn add_use(&mut self, insn_idx: u32) {
        if !self.use_list.contains(&insn_idx) {
            self.use_list.push(insn_idx);
        }
    }

    /// Remove a use site
    pub fn remove_use(&mut self, insn_idx: u32) {
        self.use_list.retain(|&idx| idx != insn_idx);
    }

    /// Add PHI use
    pub fn add_phi_use(&mut self, phi_insn_idx: u32) {
        if !self.used_in_phi.contains(&phi_insn_idx) {
            self.used_in_phi.push(phi_insn_idx);
        }
    }

    /// Remove PHI use
    pub fn remove_phi_use(&mut self, phi_insn_idx: u32) {
        self.used_in_phi.retain(|&idx| idx != phi_insn_idx);
    }

    /// Get short string representation (e.g., "r0v1")
    pub fn short_string(&self) -> String {
        format!("r{}v{}", self.reg_num, self.version)
    }

    /// Returns the PHI instruction index if used in exactly one PHI, None otherwise.
    /// Used for copy propagation optimization (JADX parity: getOnlyOneUseInPhi).
    pub fn get_only_one_use_in_phi(&self) -> Option<u32> {
        if self.used_in_phi.len() == 1 {
            Some(self.used_in_phi[0])
        } else {
            None
        }
    }

    /// Reset type to Unknown (if not immutable) and clear code_var.
    /// Used before re-running type inference passes (JADX parity: resetTypeAndCodeVar).
    pub fn reset_type_and_code_var(&mut self) {
        if !self.is_type_immutable() {
            self.type_info.var_type = ArgType::Unknown;
        }
        self.type_info.bounds.clear();
        self.code_var = None;
    }

    /// Rebuild used_in_phi list by scanning use_list.
    /// Takes a closure to check if instruction at index is a PHI.
    /// (JADX parity: updateUsedInPhiList)
    pub fn update_used_in_phi_list<F>(&mut self, is_phi: F)
    where
        F: Fn(u32) -> bool,
    {
        self.used_in_phi.clear();
        for &insn_idx in &self.use_list {
            if is_phi(insn_idx) {
                self.used_in_phi.push(insn_idx);
            }
        }
    }

    // =========================================================================
    // JADX Parity: SSAVar additional methods
    // Cloned from: jadx-fast/jadx-core/src/main/java/jadx/core/dex/instructions/args/SSAVar.java
    // =========================================================================

    /// Get combined list of all PHI instructions (JADX: getPhiList)
    ///
    /// Returns a list containing:
    /// 1. The PHI instruction where this var is assigned (if assigned in PHI)
    /// 2. All PHI instructions where this var is used as an argument
    ///
    /// JADX Reference: SSAVar.java:186-202
    /// ```java
    /// public List<PhiInsn> getPhiList() {
    ///     InsnNode assignInsn = getAssign().getParentInsn();
    ///     if (assignInsn != null && assignInsn.getType() == InsnType.PHI) {
    ///         PhiInsn assignPhi = (PhiInsn) assignInsn;
    ///         if (usedInPhi == null) {
    ///             return Collections.singletonList(assignPhi);
    ///         }
    ///         List<PhiInsn> list = new ArrayList<>(1 + usedInPhi.size());
    ///         list.add(assignPhi);
    ///         list.addAll(usedInPhi);
    ///         return list;
    ///     }
    ///     if (usedInPhi == null) {
    ///         return Collections.emptyList();
    ///     }
    ///     return usedInPhi;
    /// }
    /// ```
    pub fn get_phi_list(&self) -> Vec<u32> {
        let mut result = Vec::new();

        // Add assign PHI if this var is assigned in a PHI
        if self.is_assigned_in_phi() {
            if let Some(assign_idx) = self.assign_insn_idx {
                result.push(assign_idx);
            }
        }

        // Add all PHIs where this var is used
        result.extend(&self.used_in_phi);

        result
    }

    /// Get detailed variable information for debugging (JADX: getDetailedVarInfo)
    ///
    /// Returns a string with register, version, names, and types.
    /// Used for debugging type inference issues.
    ///
    /// JADX Reference: SSAVar.java:262-309
    /// ```java
    /// public String getDetailedVarInfo(MethodNode mth) {
    ///     Set<ArgType> types = new HashSet<>();
    ///     Set<String> names = Collections.emptySet();
    ///     // ... collect types and names from uses ...
    ///     StringBuilder sb = new StringBuilder();
    ///     sb.append('r').append(regNum).append('v').append(version);
    ///     if (!names.isEmpty()) {
    ///         sb.append(", names: ").append(orderedNames);
    ///     }
    ///     if (!types.isEmpty()) {
    ///         sb.append(", types: ").append(orderedTypes);
    ///     }
    ///     return sb.toString();
    /// }
    /// ```
    pub fn get_detailed_var_info(&self) -> String {
        let mut sb = format!("r{}v{}", self.reg_num, self.version);

        // Add type info if known
        if !matches!(self.type_info.var_type, ArgType::Unknown) {
            sb.push_str(&format!(", type: {}", self.type_info.var_type.short_name()));
        }

        // Add flags info
        let mut flags_str = Vec::new();
        if self.is_type_immutable() {
            flags_str.push("immutable");
        }
        if self.is_assigned_in_phi() {
            flags_str.push("phi-assign");
        }
        if self.flags & SSA_FLAG_METHOD_ARG != 0 {
            flags_str.push("method-arg");
        }
        if self.flags & SSA_FLAG_THIS_ARG != 0 {
            flags_str.push("this");
        }

        if !flags_str.is_empty() {
            sb.push_str(&format!(", flags: [{}]", flags_str.join(", ")));
        }

        // Add use count
        sb.push_str(&format!(", uses: {}", self.use_list.len()));

        // Add PHI use count if any
        if !self.used_in_phi.is_empty() {
            sb.push_str(&format!(", phi-uses: {}", self.used_in_phi.len()));
        }

        sb
    }

    /// Check if this SSAVar is equal to another by identity (JADX: equals)
    ///
    /// JADX Reference: SSAVar.java:312-321
    /// ```java
    /// public boolean equals(Object o) {
    ///     if (this == o) return true;
    ///     if (!(o instanceof SSAVar)) return false;
    ///     SSAVar ssaVar = (SSAVar) o;
    ///     return regNum == ssaVar.regNum && version == ssaVar.version;
    /// }
    /// ```
    pub fn equals(&self, other: &SSAVar) -> bool {
        self.reg_num == other.reg_num && self.version == other.version
    }

    /// Get hashcode for SSAVar (JADX: hashCode)
    ///
    /// JADX Reference: SSAVar.java:324-326
    /// ```java
    /// public int hashCode() {
    ///     return 31 * regNum + version;
    /// }
    /// ```
    pub fn hash_code(&self) -> i32 {
        31 * (self.reg_num as i32) + (self.version as i32)
    }

    /// Compare SSAVars for ordering (JADX: compareTo)
    ///
    /// Compares first by register number, then by version.
    ///
    /// JADX Reference: SSAVar.java:329-331
    /// ```java
    /// public int compareTo(@NotNull SSAVar o) {
    ///     return SSA_VAR_COMPARATOR.compare(this, o);
    /// }
    /// ```
    pub fn compare_to(&self, other: &SSAVar) -> std::cmp::Ordering {
        match self.reg_num.cmp(&other.reg_num) {
            std::cmp::Ordering::Equal => self.version.cmp(&other.version),
            other => other,
        }
    }
}

// SSA variable flags (pub for use in other modules)
/// Type cannot be changed by inference
pub const SSA_FLAG_IMMUTABLE_TYPE: u64 = 1 << 0;
/// Assigned in a PHI node
pub const SSA_FLAG_PHI_ASSIGN: u64 = 1 << 1;
/// This is a method argument register
pub const SSA_FLAG_METHOD_ARG: u64 = 1 << 2;
/// This is the 'this' reference
pub const SSA_FLAG_THIS_ARG: u64 = 1 << 3;

/// Type information for SSA variables (matches JADX's TypeInfo)
///
/// This tracks both the current inferred type and the type bounds
/// that constrain what the type can be.
#[derive(Debug, Clone)]
pub struct TypeInfo {
    /// Current inferred type
    pub var_type: ArgType,
    /// Type bounds (constraints from assignments and uses)
    pub bounds: Vec<TypeBound>,
    /// Candidate types (possible types from inference)
    pub candidates: Vec<ArgType>,
}

impl TypeInfo {
    pub fn new() -> Self {
        TypeInfo {
            var_type: ArgType::Unknown,
            bounds: Vec::new(),
            candidates: Vec::new(),
        }
    }

    pub fn with_type(ty: ArgType) -> Self {
        TypeInfo {
            var_type: ty,
            bounds: Vec::new(),
            candidates: Vec::new(),
        }
    }

    /// Add a type bound
    pub fn add_bound(&mut self, bound: TypeBound) {
        self.bounds.push(bound);
    }

    /// Clear all bounds (for re-inference)
    pub fn clear_bounds(&mut self) {
        self.bounds.clear();
    }

    /// Check if the type is known (not Unknown)
    pub fn is_type_known(&self) -> bool {
        !matches!(self.var_type, ArgType::Unknown)
    }
}

impl Default for TypeInfo {
    fn default() -> Self {
        Self::new()
    }
}

/// Type bound - constraint on what a variable's type can be
///
/// Bounds are collected during type inference and then resolved
/// to find the most specific type that satisfies all bounds.
#[derive(Debug, Clone)]
pub enum TypeBound {
    /// Must be assignable to this type (e.g., assigned from this type)
    AssignFrom(ArgType),
    /// Must be assignable from this type (e.g., used as this type)
    AssignTo(ArgType),
    /// Must be exactly this type
    Exact(ArgType),
    /// Must be a subtype of this type
    Subtype(ArgType),
    /// Must be a supertype of this type
    Supertype(ArgType),
    /// From PHI node - must be compatible with all incoming types
    Phi(Vec<ArgType>),
}

/// Code variable - groups SSA variables that represent the same source variable
///
/// After SSA analysis, we need to merge SSA variables back into source-level
/// variables for code generation. CodeVar represents this merged variable.
///
/// Cloned from JADX: jadx-core/src/main/java/jadx/core/dex/instructions/args/CodeVar.java
#[derive(Debug, Clone)]
pub struct CodeVar {
    /// Unique ID
    pub id: CodeVarId,
    /// Variable name (from debug info or generated)
    /// JADX Reference: CodeVar.java:10
    pub name: Option<String>,
    /// Final resolved type (before type inference can be None)
    /// JADX Reference: CodeVar.java:11
    pub var_type: ArgType,
    /// SSA variables that belong to this code variable
    /// JADX Reference: CodeVar.java:12
    pub ssa_vars: Vec<SSAVarRef>,
    /// Is this a method parameter?
    pub is_param: bool,
    /// Is this the 'this' reference?
    /// JADX Reference: CodeVar.java:15
    pub is_this: bool,
    /// Is this variable declared (method args are pre-declared)?
    /// JADX Reference: CodeVar.java:16
    pub is_declared: bool,
    /// Is this a final variable (assigned once)?
    /// JADX Reference: CodeVar.java:14
    pub is_final: bool,
}

impl CodeVar {
    pub fn new(id: CodeVarId) -> Self {
        CodeVar {
            id,
            name: None,
            var_type: ArgType::Unknown,
            ssa_vars: Vec::new(),
            is_param: false,
            is_this: false,
            is_declared: false,
            is_final: false,
        }
    }

    pub fn with_name(id: CodeVarId, name: String) -> Self {
        CodeVar {
            id,
            name: Some(name),
            var_type: ArgType::Unknown,
            ssa_vars: Vec::new(),
            is_param: false,
            is_this: false,
            is_declared: false,
            is_final: false,
        }
    }

    /// Create CodeVar from a method argument (JADX: fromMthArg)
    ///
    /// JADX Reference: CodeVar.java:20-31
    /// ```java
    /// public static CodeVar fromMthArg(RegisterArg mthArg, boolean linkRegister) {
    ///     CodeVar var = new CodeVar();
    ///     var.setType(mthArg.getInitType());
    ///     var.setName(mthArg.getName());
    ///     var.setThis(mthArg.isThis());
    ///     var.setDeclared(true);
    ///     // ...
    /// }
    /// ```
    pub fn from_mth_arg(id: CodeVarId, name: Option<String>, var_type: ArgType, is_this: bool) -> Self {
        CodeVar {
            id,
            name,
            var_type,
            ssa_vars: Vec::new(),
            is_param: true,
            is_this,
            is_declared: true, // Method args are always pre-declared
            is_final: false,
        }
    }

    /// Merge flags from another CodeVar with OR operator (JADX: mergeFlagsFrom)
    ///
    /// JADX Reference: CodeVar.java:108-118
    /// ```java
    /// public void mergeFlagsFrom(CodeVar other) {
    ///     if (other.isDeclared()) { setDeclared(true); }
    ///     if (other.isThis()) { setThis(true); }
    ///     if (other.isFinal()) { setFinal(true); }
    /// }
    /// ```
    pub fn merge_flags_from(&mut self, other: &CodeVar) {
        if other.is_declared {
            self.is_declared = true;
        }
        if other.is_this {
            self.is_this = true;
        }
        if other.is_final {
            self.is_final = true;
        }
    }

    /// Add an SSA variable to this CodeVar (JADX: addSsaVar)
    ///
    /// JADX Reference: CodeVar.java:53-59
    pub fn add_ssa_var(&mut self, ssa_ref: SSAVarRef) {
        if !self.ssa_vars.contains(&ssa_ref) {
            self.ssa_vars.push(ssa_ref);
        }
    }

    /// Get any SSA variable (first one) for this CodeVar (JADX: getAnySsaVar)
    ///
    /// JADX Reference: CodeVar.java:66-70
    pub fn get_any_ssa_var(&self) -> Option<SSAVarRef> {
        self.ssa_vars.first().copied()
    }

    /// Get the display name (name or generated)
    pub fn display_name(&self) -> String {
        self.name.clone().unwrap_or_else(|| format!("var{}", self.id))
    }
}

/// Reference to an SSA variable (reg_num, version)
#[derive(Debug, Clone, Copy, PartialEq, Eq, Hash)]
pub struct SSAVarRef {
    pub reg_num: u16,
    pub version: u32,
}

impl SSAVarRef {
    pub fn new(reg_num: u16, version: u32) -> Self {
        SSAVarRef { reg_num, version }
    }
}

/// SSA context for a method - tracks all SSA variables and their relationships
#[derive(Debug, Clone, Default)]
pub struct SSAContext {
    /// All SSA variables, keyed by (reg_num, version)
    pub vars: HashMap<SSAVarRef, SSAVar>,
    /// Current version counter for each register
    pub version_counters: HashMap<u16, u32>,
    /// Code variables (groups of SSA vars representing source variables)
    pub code_vars: Vec<CodeVar>,
    /// Next code variable ID
    next_code_var_id: CodeVarId,

    // =========================================================================
    // JADX Parity: Parent instruction tracking (P0 - CRITICAL)
    // Clone of: jadx-fast/jadx-core/src/main/java/jadx/core/dex/instructions/args/InsnArg.java:27-28
    //
    // ```java
    // @Nullable("Null for method arguments")
    // protected InsnNode parentInsn;
    // ```
    //
    // Every instruction argument maintains a reference to its containing instruction.
    // This is used for:
    // 1. wrapInstruction() - Finding the parent to modify when inlining expressions
    // 2. Type propagation - Understanding context of variable usage
    // 3. SSA rebinding - Updating use-def chains after modifications
    // =========================================================================

    /// Maps (insn_idx, arg_position) -> parent instruction index
    /// Key: (instruction index, argument position within that instruction)
    /// Value: instruction index of the parent instruction
    ///
    /// Note: Method arguments have no parent (parentInsn is null in JADX)
    arg_parents: HashMap<(u32, u8), u32>,
}

impl SSAContext {
    pub fn new() -> Self {
        SSAContext {
            vars: HashMap::new(),
            version_counters: HashMap::new(),
            code_vars: Vec::new(),
            next_code_var_id: 0,
            arg_parents: HashMap::new(),
        }
    }

    /// Create a new SSA variable for a register (increments version)
    pub fn new_var(&mut self, reg_num: u16) -> SSAVarRef {
        let version = self.version_counters.entry(reg_num).or_insert(0);
        let var_ref = SSAVarRef::new(reg_num, *version);
        *version += 1;

        let var = SSAVar::new(reg_num, var_ref.version);
        self.vars.insert(var_ref, var);
        var_ref
    }

    /// Create a new SSA variable with a specific version
    pub fn new_var_with_version(&mut self, reg_num: u16, version: u32) -> SSAVarRef {
        let var_ref = SSAVarRef::new(reg_num, version);

        // Update version counter if needed
        let counter = self.version_counters.entry(reg_num).or_insert(0);
        if version >= *counter {
            *counter = version + 1;
        }

        let var = SSAVar::new(reg_num, version);
        self.vars.insert(var_ref, var);
        var_ref
    }

    /// Get an SSA variable
    pub fn get_var(&self, var_ref: SSAVarRef) -> Option<&SSAVar> {
        self.vars.get(&var_ref)
    }

    /// Get a mutable SSA variable
    pub fn get_var_mut(&mut self, var_ref: SSAVarRef) -> Option<&mut SSAVar> {
        self.vars.get_mut(&var_ref)
    }

    /// Get the current version for a register
    pub fn current_version(&self, reg_num: u16) -> u32 {
        self.version_counters.get(&reg_num).copied().unwrap_or(0).saturating_sub(1)
    }

    /// Create a new code variable
    pub fn new_code_var(&mut self) -> CodeVarId {
        let id = self.next_code_var_id;
        self.next_code_var_id += 1;
        self.code_vars.push(CodeVar::new(id));
        id
    }

    /// Create a new code variable with a name
    pub fn new_code_var_named(&mut self, name: String) -> CodeVarId {
        let id = self.next_code_var_id;
        self.next_code_var_id += 1;
        self.code_vars.push(CodeVar::with_name(id, name));
        id
    }

    /// Get a code variable
    pub fn get_code_var(&self, id: CodeVarId) -> Option<&CodeVar> {
        self.code_vars.get(id as usize)
    }

    /// Get a mutable code variable
    pub fn get_code_var_mut(&mut self, id: CodeVarId) -> Option<&mut CodeVar> {
        self.code_vars.get_mut(id as usize)
    }

    /// Link an SSA variable to a code variable
    pub fn link_to_code_var(&mut self, var_ref: SSAVarRef, code_var_id: CodeVarId) {
        if let Some(var) = self.vars.get_mut(&var_ref) {
            var.code_var = Some(code_var_id);
        }
        if let Some(code_var) = self.code_vars.get_mut(code_var_id as usize) {
            if !code_var.ssa_vars.contains(&var_ref) {
                code_var.ssa_vars.push(var_ref);
            }
        }
    }

    /// Get all SSA variables for a register (all versions)
    pub fn get_vars_for_reg(&self, reg_num: u16) -> Vec<&SSAVar> {
        self.vars.iter()
            .filter(|(k, _)| k.reg_num == reg_num)
            .map(|(_, v)| v)
            .collect()
    }

    /// Get all registers that have SSA variables
    pub fn get_all_registers(&self) -> HashSet<u16> {
        self.vars.keys().map(|k| k.reg_num).collect()
    }

    /// Get all SSA variables assigned in PHI nodes
    pub fn get_phi_assigned_vars(&self) -> Vec<SSAVarRef> {
        self.vars.iter()
            .filter(|(_, v)| v.is_assigned_in_phi())
            .map(|(k, _)| *k)
            .collect()
    }

    /// Mark an SSA variable as assigned in a PHI node
    pub fn mark_phi_assign(&mut self, var_ref: SSAVarRef) {
        if let Some(var) = self.vars.get_mut(&var_ref) {
            var.flags |= SSA_FLAG_PHI_ASSIGN;
        }
    }

    /// Remove an SSA variable (used when removing trivial PHI nodes)
    pub fn remove_var(&mut self, var_ref: SSAVarRef) -> Option<SSAVar> {
        self.vars.remove(&var_ref)
    }

    /// Replace all uses of one SSA variable with another
    /// Returns the number of replacements made
    pub fn replace_var_uses(&mut self, from: SSAVarRef, to: SSAVarRef) -> usize {
        let mut count = 0;

        // Get the use list from the source variable
        let use_list = if let Some(var) = self.vars.get(&from) {
            var.use_list.clone()
        } else {
            return 0;
        };

        let phi_list = if let Some(var) = self.vars.get(&from) {
            var.used_in_phi.clone()
        } else {
            Vec::new()
        };

        // Add uses to target variable
        if let Some(to_var) = self.vars.get_mut(&to) {
            for use_idx in &use_list {
                to_var.add_use(*use_idx);
                count += 1;
            }
            for phi_idx in &phi_list {
                to_var.add_phi_use(*phi_idx);
            }
        }

        // Clear uses from source variable
        if let Some(from_var) = self.vars.get_mut(&from) {
            from_var.use_list.clear();
            from_var.used_in_phi.clear();
        }

        count
    }

    // =========================================================================
    // JADX Name Management - 100% Parity
    // Cloned from: jadx-fast/jadx-core/src/main/java/jadx/core/dex/instructions/args/RegisterArg.java
    // =========================================================================

    /// Get the name of a variable (JADX: RegisterArg.getName via SSAVar.getCodeVar)
    ///
    /// Looks up the SSA variable, finds its CodeVar, and returns the name if set.
    ///
    /// JADX Reference: RegisterArg.java:90-95
    /// ```java
    /// public String getName() {
    ///     SSAVar sVar = getSVar();
    ///     if (sVar != null) {
    ///         CodeVar codeVar = sVar.getCodeVar();
    ///         if (codeVar != null) {
    ///             return codeVar.getName();
    ///         }
    ///     }
    ///     return null;
    /// }
    /// ```
    pub fn get_var_name(&self, reg_num: u16, ssa_version: u32) -> Option<&str> {
        let var_ref = SSAVarRef::new(reg_num, ssa_version);
        if let Some(var) = self.vars.get(&var_ref) {
            if let Some(code_var_id) = var.code_var {
                if let Some(code_var) = self.code_vars.get(code_var_id as usize) {
                    return code_var.name.as_deref();
                }
            }
        }
        None
    }

    /// Set the name of a variable (JADX: RegisterArg.setName via SSAVar.getCodeVar)
    ///
    /// Finds the SSA variable's CodeVar and sets its name.
    ///
    /// JADX Reference: RegisterArg.java:97-113
    /// ```java
    /// public void setName(String name) {
    ///     SSAVar sVar = getSVar();
    ///     if (sVar == null) {
    ///         return;
    ///     }
    ///     CodeVar codeVar = sVar.getCodeVar();
    ///     if (codeVar == null) {
    ///         codeVar = sVar.makeCodeVar();
    ///     }
    ///     codeVar.setName(name);
    /// }
    /// ```
    pub fn set_var_name(&mut self, reg_num: u16, ssa_version: u32, name: String) {
        let var_ref = SSAVarRef::new(reg_num, ssa_version);

        // Ensure the SSA variable has a code var
        let code_var_id = {
            if let Some(var) = self.vars.get(&var_ref) {
                if let Some(id) = var.code_var {
                    Some(id)
                } else {
                    None
                }
            } else {
                return;
            }
        };

        let code_var_id = match code_var_id {
            Some(id) => id,
            None => {
                // Create a new code var
                let id = self.new_code_var();
                if let Some(var) = self.vars.get_mut(&var_ref) {
                    var.code_var = Some(id);
                }
                id
            }
        };

        // Set the name
        if let Some(code_var) = self.code_vars.get_mut(code_var_id as usize) {
            code_var.name = Some(name);
        }
    }

    /// Set name if not already set (JADX: RegisterArg.setNameIfUnknown)
    ///
    /// Only sets the name if the variable doesn't already have one.
    /// Used during code generation for generated names.
    ///
    /// JADX Reference: RegisterArg.java:115-119
    /// ```java
    /// public void setNameIfUnknown(String name) {
    ///     if (getName() == null) {
    ///         setName(name);
    ///     }
    /// }
    /// ```
    pub fn set_var_name_if_unknown(&mut self, reg_num: u16, ssa_version: u32, name: String) {
        if self.get_var_name(reg_num, ssa_version).is_none() {
            self.set_var_name(reg_num, ssa_version, name);
        }
    }

    /// Check if two variables have the same name (JADX: RegisterArg.isNameEquals)
    ///
    /// JADX Reference: RegisterArg.java:121-127
    /// ```java
    /// public boolean isNameEquals(InsnArg other) {
    ///     if (other instanceof RegisterArg) {
    ///         String name = getName();
    ///         if (name != null) {
    ///             return name.equals(((RegisterArg) other).getName());
    ///         }
    ///     }
    ///     return false;
    /// }
    /// ```
    pub fn is_name_equals(
        &self,
        reg1: u16,
        ssa1: u32,
        reg2: u16,
        ssa2: u32,
    ) -> bool {
        let name1 = self.get_var_name(reg1, ssa1);
        let name2 = self.get_var_name(reg2, ssa2);
        match (name1, name2) {
            (Some(a), Some(b)) => a == b,
            _ => false,
        }
    }

    // =========================================================================
    // JADX Parity: SSA variable grouping check
    // Cloned from: jadx-fast/jadx-core/src/main/java/jadx/core/dex/instructions/args/RegisterArg.java:196-198
    // =========================================================================

    /// Check if SSA variable is linked to other SSA variables (JADX: isLinkedToOtherSsaVars)
    ///
    /// Returns true if this SSA variable is grouped with other SSA variables
    /// into the same source-level CodeVar.
    ///
    /// Used for variable declaration placement - only declare where first assigned
    /// if not linked to other SSA vars.
    ///
    /// JADX Reference: RegisterArg.java:196-198
    /// ```java
    /// public boolean isLinkedToOtherSsaVars() {
    ///     return getSVar().getCodeVar().getSsaVars().size() > 1;
    /// }
    /// ```
    pub fn is_linked_to_other_ssa_vars(&self, reg_num: u16, version: u32) -> bool {
        let var_ref = SSAVarRef::new(reg_num, version);
        if let Some(var) = self.vars.get(&var_ref) {
            if let Some(code_var_id) = var.code_var {
                if let Some(code_var) = self.code_vars.get(code_var_id as usize) {
                    return code_var.ssa_vars.len() > 1;
                }
            }
        }
        false
    }

    /// Check if two SSA variables share the same CodeVar (JADX: sameCodeVar)
    ///
    /// Returns true if both SSA variables belong to the same source-level variable.
    ///
    /// JADX Reference: RegisterArg.java:192-194
    /// ```java
    /// public boolean sameCodeVar(RegisterArg arg) {
    ///     return this.getSVar().getCodeVar() == arg.getSVar().getCodeVar();
    /// }
    /// ```
    pub fn same_code_var(&self, reg1: u16, ssa1: u32, reg2: u16, ssa2: u32) -> bool {
        let var_ref1 = SSAVarRef::new(reg1, ssa1);
        let var_ref2 = SSAVarRef::new(reg2, ssa2);

        let code_var1 = self.vars.get(&var_ref1).and_then(|v| v.code_var);
        let code_var2 = self.vars.get(&var_ref2).and_then(|v| v.code_var);

        match (code_var1, code_var2) {
            (Some(cv1), Some(cv2)) => cv1 == cv2,
            _ => false,
        }
    }

    // =========================================================================
    // JADX Parity: Parent Instruction Tracking (P0 - CRITICAL)
    // Clone of: jadx-fast/jadx-core/src/main/java/jadx/core/dex/instructions/args/InsnArg.java
    // =========================================================================

    /// Set the parent instruction for an argument (JADX: setParentInsn)
    ///
    /// Every instruction argument tracks which instruction contains it.
    /// This is used for expression inlining (wrapInstruction) and SSA rebinding.
    ///
    /// JADX Reference: InsnArg.java:54-56
    /// ```java
    /// public void setParentInsn(InsnNode parentInsn) {
    ///     this.parentInsn = parentInsn;
    /// }
    /// ```
    ///
    /// Parameters:
    /// - `insn_idx`: The instruction containing the argument
    /// - `arg_pos`: The argument position within the instruction (0-based)
    /// - `parent_insn_idx`: The parent instruction's index
    pub fn set_arg_parent(&mut self, insn_idx: u32, arg_pos: u8, parent_insn_idx: u32) {
        self.arg_parents.insert((insn_idx, arg_pos), parent_insn_idx);
    }

    /// Get the parent instruction for an argument (JADX: getParentInsn)
    ///
    /// Returns the instruction index that contains this argument, or None
    /// if this is a method argument (which has no parent).
    ///
    /// JADX Reference: InsnArg.java:50-52
    /// ```java
    /// @Nullable
    /// public InsnNode getParentInsn() {
    ///     return parentInsn;
    /// }
    /// ```
    pub fn get_arg_parent(&self, insn_idx: u32, arg_pos: u8) -> Option<u32> {
        self.arg_parents.get(&(insn_idx, arg_pos)).copied()
    }

    /// Remove parent tracking for an argument
    ///
    /// Used when arguments are removed or replaced.
    pub fn remove_arg_parent(&mut self, insn_idx: u32, arg_pos: u8) {
        self.arg_parents.remove(&(insn_idx, arg_pos));
    }

    /// Clear all parent tracking for an instruction
    ///
    /// Used when an instruction is removed.
    pub fn clear_insn_parents(&mut self, insn_idx: u32) {
        // Remove all entries where this instruction is referenced
        self.arg_parents.retain(|(idx, _), _| *idx != insn_idx);
    }

    /// Get argument index within parent instruction (JADX: getArgIndex)
    ///
    /// Searches for which argument position contains the given SSA variable.
    /// Returns the 0-based index or None if not found.
    ///
    /// JADX Reference: InsnArg.java:70-82
    /// ```java
    /// public static int getArgIndex(InsnNode parentInsn, InsnArg arg) {
    ///     int count = parentInsn.getArgsCount();
    ///     for (int i = 0; i < count; i++) {
    ///         if (parentInsn.getArg(i) == arg) {
    ///             return i;
    ///         }
    ///     }
    ///     return -1;
    /// }
    /// ```
    ///
    /// Note: This requires the instruction list to be passed in since we store
    /// indices, not instruction references.
    pub fn get_arg_index(&self, parent_insn_idx: u32, target_insn_idx: u32) -> Option<u8> {
        for (&(insn_idx, arg_pos), &parent) in &self.arg_parents {
            if parent == parent_insn_idx && insn_idx == target_insn_idx {
                return Some(arg_pos);
            }
        }
        None
    }

    /// Bulk set parent instructions for all args in an instruction
    ///
    /// This is a convenience method for use during IR construction.
    /// For an instruction at `insn_idx` with `arg_count` arguments,
    /// sets the parent to `insn_idx` for all argument positions.
    pub fn set_all_arg_parents(&mut self, insn_idx: u32, arg_count: u8) {
        for pos in 0..arg_count {
            self.arg_parents.insert((insn_idx, pos), insn_idx);
        }
    }
}

/// PHI node for explicit tracking and simplification
#[derive(Debug, Clone)]
pub struct PhiNode {
    /// Instruction index where this PHI is located
    pub insn_idx: u32,
    /// Destination SSA variable
    pub dest: SSAVarRef,
    /// Source (predecessor_block, ssa_var_ref) pairs
    pub sources: Vec<(u32, SSAVarRef)>,
}

impl PhiNode {
    pub fn new(insn_idx: u32, dest: SSAVarRef) -> Self {
        PhiNode {
            insn_idx,
            dest,
            sources: Vec::new(),
        }
    }

    /// Add a source to this PHI node
    pub fn add_source(&mut self, block_id: u32, var_ref: SSAVarRef) {
        self.sources.push((block_id, var_ref));
    }

    /// Check if this PHI is trivial (can be simplified)
    /// Returns Some(replacement_var) if trivial, None otherwise
    pub fn is_trivial(&self) -> Option<SSAVarRef> {
        if self.sources.is_empty() {
            return None;
        }

        // Single source - trivially simplifiable
        if self.sources.len() == 1 {
            return Some(self.sources[0].1);
        }

        // Check if all sources are the same
        let first_source = self.sources[0].1;
        if self.sources.iter().all(|(_, var)| *var == first_source) {
            return Some(first_source);
        }

        // Check if all sources point to the destination (self-referential PHI)
        // This can happen in loops where a variable is only defined by the PHI itself
        let non_self_sources: Vec<_> = self.sources.iter()
            .filter(|(_, var)| *var != self.dest)
            .collect();

        if non_self_sources.len() == 1 {
            return Some(non_self_sources[0].1);
        }

        // All sources are self-references - dead PHI
        if non_self_sources.is_empty() {
            return Some(self.sources[0].1); // Will be eliminated
        }

        // Check if all non-self sources are the same
        if !non_self_sources.is_empty() {
            let first_non_self = non_self_sources[0].1;
            if non_self_sources.iter().all(|(_, var)| *var == first_non_self) {
                return Some(first_non_self);
            }
        }

        None
    }

    /// Get the number of unique sources (excluding self-references)
    pub fn unique_source_count(&self) -> usize {
        let mut unique: HashSet<SSAVarRef> = HashSet::new();
        for (_, var) in &self.sources {
            if *var != self.dest {
                unique.insert(*var);
            }
        }
        unique.len()
    }
}

/// Result of PHI simplification
#[derive(Debug)]
pub struct PhiSimplifyResult {
    /// PHI nodes that were removed
    pub removed: Vec<u32>, // instruction indices
    /// Replacements made: (from_var, to_var)
    pub replacements: Vec<(SSAVarRef, SSAVarRef)>,
}

impl PhiSimplifyResult {
    pub fn new() -> Self {
        PhiSimplifyResult {
            removed: Vec::new(),
            replacements: Vec::new(),
        }
    }

    pub fn is_empty(&self) -> bool {
        self.removed.is_empty() && self.replacements.is_empty()
    }
}

impl Default for PhiSimplifyResult {
    fn default() -> Self {
        Self::new()
    }
}

/// Simplify a set of PHI nodes, removing trivial ones
/// Returns the simplification result with removals and replacements
pub fn simplify_phis(phi_nodes: &mut Vec<PhiNode>, ctx: &mut SSAContext) -> PhiSimplifyResult {
    let mut result = PhiSimplifyResult::new();
    let mut changed = true;

    // Iterate until no more changes (for chained trivial PHIs)
    while changed {
        changed = false;
        let mut to_remove = Vec::new();

        for (idx, phi) in phi_nodes.iter().enumerate() {
            if let Some(replacement) = phi.is_trivial() {
                to_remove.push(idx);
                result.removed.push(phi.insn_idx);
                result.replacements.push((phi.dest, replacement));

                // Replace uses of the PHI dest with the replacement
                ctx.replace_var_uses(phi.dest, replacement);
                changed = true;
            }
        }

        // Remove simplified PHIs (in reverse order to preserve indices)
        for idx in to_remove.into_iter().rev() {
            phi_nodes.remove(idx);
        }

        // Update remaining PHI sources to use replacements
        for (from, to) in &result.replacements {
            for phi in phi_nodes.iter_mut() {
                for (_, src_var) in phi.sources.iter_mut() {
                    if src_var == from {
                        *src_var = *to;
                    }
                }
            }
        }
    }

    result
}

#[cfg(test)]
mod tests {
    use super::*;

    #[test]
    fn test_ssa_var_creation() {
        let var = SSAVar::new(0, 1);
        assert_eq!(var.reg_num, 0);
        assert_eq!(var.version, 1);
        assert_eq!(var.short_string(), "r0v1");
    }

    #[test]
    fn test_ssa_var_use_list() {
        let mut var = SSAVar::new(0, 0);
        var.add_use(10);
        var.add_use(20);
        var.add_use(10); // Duplicate, should not be added

        assert_eq!(var.use_count(), 2);

        var.remove_use(10);
        assert_eq!(var.use_count(), 1);
    }

    #[test]
    fn test_ssa_context_new_var() {
        let mut ctx = SSAContext::new();

        let v0 = ctx.new_var(0);
        assert_eq!(v0.reg_num, 0);
        assert_eq!(v0.version, 0);

        let v1 = ctx.new_var(0);
        assert_eq!(v1.reg_num, 0);
        assert_eq!(v1.version, 1);

        let v2 = ctx.new_var(1);
        assert_eq!(v2.reg_num, 1);
        assert_eq!(v2.version, 0);
    }

    #[test]
    fn test_type_info() {
        let mut ti = TypeInfo::new();
        assert!(!ti.is_type_known());

        ti.var_type = ArgType::Int;
        assert!(ti.is_type_known());

        ti.add_bound(TypeBound::AssignFrom(ArgType::Byte));
        assert_eq!(ti.bounds.len(), 1);
    }

    #[test]
    fn test_code_var() {
        let mut ctx = SSAContext::new();

        let cv_id = ctx.new_code_var_named("myVar".to_string());
        let var_ref = ctx.new_var(0);
        ctx.link_to_code_var(var_ref, cv_id);

        let cv = ctx.get_code_var(cv_id).unwrap();
        assert_eq!(cv.name, Some("myVar".to_string()));
        assert_eq!(cv.ssa_vars.len(), 1);

        let var = ctx.get_var(var_ref).unwrap();
        assert_eq!(var.code_var, Some(cv_id));
    }

    #[test]
    fn test_phi_node_single_source() {
        // PHI with single source is trivial
        let dest = SSAVarRef::new(0, 1);
        let source = SSAVarRef::new(0, 0);
        let mut phi = PhiNode::new(0, dest);
        phi.add_source(1, source);

        assert_eq!(phi.is_trivial(), Some(source));
    }

    #[test]
    fn test_phi_node_all_same_sources() {
        // PHI where all sources are the same is trivial
        let dest = SSAVarRef::new(0, 2);
        let source = SSAVarRef::new(0, 0);
        let mut phi = PhiNode::new(0, dest);
        phi.add_source(1, source);
        phi.add_source(2, source);
        phi.add_source(3, source);

        assert_eq!(phi.is_trivial(), Some(source));
    }

    #[test]
    fn test_phi_node_different_sources() {
        // PHI with different sources is NOT trivial
        let dest = SSAVarRef::new(0, 2);
        let source1 = SSAVarRef::new(0, 0);
        let source2 = SSAVarRef::new(0, 1);
        let mut phi = PhiNode::new(0, dest);
        phi.add_source(1, source1);
        phi.add_source(2, source2);

        assert_eq!(phi.is_trivial(), None);
    }

    #[test]
    fn test_phi_node_self_referential() {
        // PHI with self-reference and one other source is trivial
        let dest = SSAVarRef::new(0, 1);
        let source = SSAVarRef::new(0, 0);
        let mut phi = PhiNode::new(0, dest);
        phi.add_source(1, source); // From entry block
        phi.add_source(2, dest);   // From loop back-edge (self-reference)

        assert_eq!(phi.is_trivial(), Some(source));
    }

    #[test]
    fn test_simplify_phis_single_trivial() {
        let mut ctx = SSAContext::new();
        let v0 = ctx.new_var(0); // r0v0
        let v1 = ctx.new_var(0); // r0v1

        let mut phi = PhiNode::new(10, v1);
        phi.add_source(1, v0);

        let mut phis = vec![phi];
        let result = simplify_phis(&mut phis, &mut ctx);

        assert_eq!(result.removed.len(), 1);
        assert_eq!(result.removed[0], 10);
        assert!(phis.is_empty());
    }

    #[test]
    fn test_simplify_phis_chained() {
        // Test that chained trivial PHIs are simplified
        // v0 -> PHI1 -> v1 -> PHI2 -> v2
        // Both should be simplified to just using v0
        let mut ctx = SSAContext::new();
        let v0 = ctx.new_var(0); // r0v0
        let v1 = ctx.new_var(0); // r0v1
        let v2 = ctx.new_var(0); // r0v2

        let mut phi1 = PhiNode::new(10, v1);
        phi1.add_source(1, v0);

        let mut phi2 = PhiNode::new(20, v2);
        phi2.add_source(2, v1);

        let mut phis = vec![phi1, phi2];
        let result = simplify_phis(&mut phis, &mut ctx);

        assert_eq!(result.removed.len(), 2);
        assert!(phis.is_empty());
    }

    #[test]
    fn test_phi_unique_source_count() {
        let dest = SSAVarRef::new(0, 3);
        let s1 = SSAVarRef::new(0, 0);
        let s2 = SSAVarRef::new(0, 1);
        let mut phi = PhiNode::new(0, dest);
        phi.add_source(1, s1);
        phi.add_source(2, s2);
        phi.add_source(3, dest); // Self-reference
        phi.add_source(4, s1);   // Duplicate

        assert_eq!(phi.unique_source_count(), 2); // s1 and s2
    }

    #[test]
    fn test_get_only_one_use_in_phi() {
        let mut var = SSAVar::new(0, 0);
        assert_eq!(var.get_only_one_use_in_phi(), None);

        var.add_phi_use(10);
        assert_eq!(var.get_only_one_use_in_phi(), Some(10));

        var.add_phi_use(20);
        assert_eq!(var.get_only_one_use_in_phi(), None);
    }

    #[test]
    fn test_reset_type_and_code_var() {
        let mut var = SSAVar::new(0, 0);
        var.type_info.var_type = ArgType::Int;
        var.type_info.add_bound(TypeBound::AssignFrom(ArgType::Byte));
        var.code_var = Some(42);

        var.reset_type_and_code_var();

        assert!(matches!(var.type_info.var_type, ArgType::Unknown));
        assert!(var.type_info.bounds.is_empty());
        assert_eq!(var.code_var, None);
    }

    #[test]
    fn test_reset_type_and_code_var_immutable() {
        let mut var = SSAVar::new(0, 0);
        var.type_info.var_type = ArgType::Int;
        var.mark_type_immutable();
        var.code_var = Some(42);

        var.reset_type_and_code_var();

        // Type should NOT change because it's immutable
        assert!(matches!(var.type_info.var_type, ArgType::Int));
        // But code_var and bounds should still be cleared
        assert!(var.type_info.bounds.is_empty());
        assert_eq!(var.code_var, None);
    }

    #[test]
    fn test_update_used_in_phi_list() {
        let mut var = SSAVar::new(0, 0);
        var.add_use(10);
        var.add_use(20);
        var.add_use(30);

        // Simulate: insn 10 and 30 are PHIs, 20 is not
        var.update_used_in_phi_list(|idx| idx == 10 || idx == 30);

        assert_eq!(var.used_in_phi.len(), 2);
        assert!(var.used_in_phi.contains(&10));
        assert!(var.used_in_phi.contains(&30));
        assert!(!var.used_in_phi.contains(&20));
    }

    // =========================================================================
    // JADX Parity Tests: SSA variable grouping
    // Tests for is_linked_to_other_ssa_vars and same_code_var methods
    // =========================================================================

    #[test]
    fn test_is_linked_to_other_ssa_vars_single() {
        let mut ctx = SSAContext::new();

        // Create a single SSA var linked to a CodeVar
        let v0 = ctx.new_var(0); // r0v0
        let cv_id = ctx.new_code_var();
        ctx.link_to_code_var(v0, cv_id);

        // Single SSA var should NOT be linked to others
        assert!(!ctx.is_linked_to_other_ssa_vars(v0.reg_num, v0.version));
    }

    #[test]
    fn test_is_linked_to_other_ssa_vars_multiple() {
        let mut ctx = SSAContext::new();

        // Create multiple SSA vars linked to the same CodeVar
        let v0 = ctx.new_var(0); // r0v0
        let v1 = ctx.new_var(0); // r0v1
        let cv_id = ctx.new_code_var();

        ctx.link_to_code_var(v0, cv_id);
        ctx.link_to_code_var(v1, cv_id);

        // Both should be linked to other SSA vars
        assert!(ctx.is_linked_to_other_ssa_vars(v0.reg_num, v0.version));
        assert!(ctx.is_linked_to_other_ssa_vars(v1.reg_num, v1.version));
    }

    #[test]
    fn test_is_linked_to_other_ssa_vars_no_code_var() {
        let mut ctx = SSAContext::new();

        // Create SSA var without a CodeVar
        let v0 = ctx.new_var(0);

        // No CodeVar means not linked
        assert!(!ctx.is_linked_to_other_ssa_vars(v0.reg_num, v0.version));
    }

    #[test]
    fn test_same_code_var_true() {
        let mut ctx = SSAContext::new();

        let v0 = ctx.new_var(0); // r0v0
        let v1 = ctx.new_var(0); // r0v1
        let cv_id = ctx.new_code_var();

        ctx.link_to_code_var(v0, cv_id);
        ctx.link_to_code_var(v1, cv_id);

        assert!(ctx.same_code_var(v0.reg_num, v0.version, v1.reg_num, v1.version));
    }

    #[test]
    fn test_same_code_var_false() {
        let mut ctx = SSAContext::new();

        let v0 = ctx.new_var(0); // r0v0
        let v1 = ctx.new_var(1); // r1v0

        let cv0 = ctx.new_code_var();
        let cv1 = ctx.new_code_var();

        ctx.link_to_code_var(v0, cv0);
        ctx.link_to_code_var(v1, cv1);

        // Different CodeVars
        assert!(!ctx.same_code_var(v0.reg_num, v0.version, v1.reg_num, v1.version));
    }

    #[test]
    fn test_same_code_var_no_code_var() {
        let mut ctx = SSAContext::new();

        let v0 = ctx.new_var(0);
        let v1 = ctx.new_var(1);

        // Neither has CodeVar
        assert!(!ctx.same_code_var(v0.reg_num, v0.version, v1.reg_num, v1.version));
    }
}
