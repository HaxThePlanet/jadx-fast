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
#[derive(Debug, Clone)]
pub struct CodeVar {
    /// Unique ID
    pub id: CodeVarId,
    /// Variable name (from debug info or generated)
    pub name: Option<String>,
    /// Final resolved type
    pub var_type: ArgType,
    /// SSA variables that belong to this code variable
    pub ssa_vars: Vec<SSAVarRef>,
    /// Is this a method parameter?
    pub is_param: bool,
    /// Is this the 'this' reference?
    pub is_this: bool,
    /// Is this a final variable (assigned once)?
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
            is_final: false,
        }
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
}

impl SSAContext {
    pub fn new() -> Self {
        SSAContext {
            vars: HashMap::new(),
            version_counters: HashMap::new(),
            code_vars: Vec::new(),
            next_code_var_id: 0,
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
}
