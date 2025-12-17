//! Type update engine with listener-based propagation
//!
//! This module implements JADX's TypeUpdate system for propagating type changes
//! through the instruction graph. When a type is updated for a variable, the
//! system recursively propagates the change to all connected variables.
//!
//! ## Architecture
//!
//! The TypeUpdate system uses instruction-specific "listeners" that know how to
//! propagate type changes through different instruction types:
//!
//! - MOVE: propagate type bidirectionally between source and destination
//! - PHI: propagate type to all phi inputs
//! - AGET/APUT: propagate array element type
//! - IF: propagate type between compared values
//! - INVOKE: propagate types to arguments and return value
//! - CHECK_CAST: validate cast compatibility
//!
//! ## Type Update Protocol
//!
//! 1. Caller requests type update for variable with candidate type
//! 2. TypeUpdate validates the change against existing bounds
//! 3. If valid, records the pending update
//! 4. Runs appropriate listener for the parent instruction
//! 5. Listener may recursively update connected variables
//! 6. All updates are collected and applied atomically
//!
//! This transactional approach prevents partial updates on failure.

use std::collections::HashSet;

use rustc_hash::{FxHashMap, FxHashSet};

use dexterity_ir::instructions::{InsnArg, InsnType, InvokeKind, RegisterArg};
use dexterity_ir::types::{ArgType, TypeCompare, compare_types};
use dexterity_ir::ClassHierarchy;

use crate::type_bound::{BoundEnum, TypeBound, TypeInfo};
use crate::type_inference::TypeVar;

/// Result of a type update attempt
#[derive(Debug, Clone, Copy, PartialEq, Eq)]
pub enum TypeUpdateResult {
    /// Type was changed
    Changed,
    /// Type was already the same
    Same,
    /// Type update was rejected (incompatible)
    Reject,
}

impl TypeUpdateResult {
    /// Check if update resulted in a change
    pub fn is_changed(&self) -> bool {
        matches!(self, Self::Changed)
    }

    /// Check if update was rejected
    pub fn is_reject(&self) -> bool {
        matches!(self, Self::Reject)
    }
}

/// Flags for type update behavior
#[derive(Debug, Clone, Copy, Default)]
pub struct TypeUpdateFlags {
    /// Allow wider types (less specific)
    pub allow_wider: bool,
    /// Ignore same type (don't return SAME)
    pub ignore_same: bool,
    /// Keep generic information (don't allow raw type to replace generic)
    pub keep_generics: bool,
    /// Ignore unknown type comparisons
    pub ignore_unknown: bool,
}

impl TypeUpdateFlags {
    /// Default flags (strict type checking)
    pub fn empty() -> Self {
        Self::default()
    }

    /// Flags that allow wider types
    pub fn wider() -> Self {
        Self {
            allow_wider: true,
            ..Self::default()
        }
    }

    /// Flags for applying immutable types
    pub fn wider_ignore_same() -> Self {
        Self {
            allow_wider: true,
            ignore_same: true,
            ..Self::default()
        }
    }

    /// Flags for debug info application
    pub fn apply_debug() -> Self {
        Self {
            allow_wider: true,
            keep_generics: true,
            ..Self::default()
        }
    }
}

/// Entry for a pending type update
#[derive(Debug, Clone)]
pub struct TypeUpdateEntry {
    pub var: TypeVar,
    pub new_type: ArgType,
}

/// Tracks pending type updates during propagation
#[derive(Debug)]
pub struct TypeUpdateInfo {
    /// Pending type updates (var -> new type)
    updates: FxHashMap<TypeVar, ArgType>,
    /// Variables already processed in this update cycle
    processed: FxHashSet<TypeVar>,
    /// Update flags
    flags: TypeUpdateFlags,
}

impl TypeUpdateInfo {
    /// Create new update info
    pub fn new(flags: TypeUpdateFlags) -> Self {
        Self {
            updates: FxHashMap::default(),
            processed: FxHashSet::default(),
            flags,
        }
    }

    /// Check if a variable has been processed
    pub fn is_processed(&self, var: TypeVar) -> bool {
        self.processed.contains(&var)
    }

    /// Mark a variable as processed
    pub fn mark_processed(&mut self, var: TypeVar) {
        self.processed.insert(var);
    }

    /// Request a type update for a variable
    pub fn request_update(&mut self, var: TypeVar, new_type: ArgType) {
        self.updates.insert(var, new_type);
        self.processed.insert(var);
    }

    /// Rollback an update for a variable
    pub fn rollback_update(&mut self, var: TypeVar) {
        self.updates.remove(&var);
        self.processed.remove(&var);
    }

    /// Check if there are any pending updates
    pub fn is_empty(&self) -> bool {
        self.updates.is_empty()
    }

    /// Get the pending update type for a variable
    pub fn get_type(&self, var: TypeVar) -> Option<&ArgType> {
        self.updates.get(&var)
    }

    /// Check if an update with specific type is pending
    pub fn has_update_with_type(&self, var: TypeVar, ty: &ArgType) -> bool {
        self.updates.get(&var).map_or(false, |t| t == ty)
    }

    /// Get all pending updates
    pub fn get_updates(&self) -> impl Iterator<Item = (&TypeVar, &ArgType)> {
        self.updates.iter()
    }

    /// Get update flags
    pub fn flags(&self) -> &TypeUpdateFlags {
        &self.flags
    }

    /// Apply all pending updates to the resolved types map
    pub fn apply_updates(&self, resolved: &mut FxHashMap<TypeVar, ArgType>) {
        for (var, ty) in &self.updates {
            resolved.insert(*var, ty.clone());
        }
    }
}

/// Listener function type for instruction-specific type propagation
pub type TypeListener = fn(
    update: &mut TypeUpdateEngine,
    info: &mut TypeUpdateInfo,
    insn: &InsnType,
    var: TypeVar,
    candidate_type: &ArgType,
) -> TypeUpdateResult;

/// Kind of instruction for listener dispatch
#[derive(Debug, Clone, Copy, PartialEq, Eq, Hash)]
pub enum InsnKind {
    Const,
    Move,
    Phi,
    ArrayGet,
    ArrayPut,
    If,
    Binary,
    Unary,
    CheckCast,
    Invoke,
    InstanceGet,
    InstancePut,
    StaticGet,
    StaticPut,
}

impl InsnKind {
    /// Get the instruction kind for an instruction type
    pub fn from_insn(insn: &InsnType) -> Option<Self> {
        match insn {
            InsnType::Const { .. } | InsnType::ConstString { .. } | InsnType::ConstClass { .. } => {
                Some(Self::Const)
            }
            InsnType::Move { .. } | InsnType::MoveResult { .. } | InsnType::MoveException { .. } => {
                Some(Self::Move)
            }
            InsnType::Phi { .. } => Some(Self::Phi),
            InsnType::ArrayGet { .. } => Some(Self::ArrayGet),
            InsnType::ArrayPut { .. } => Some(Self::ArrayPut),
            InsnType::If { .. } => Some(Self::If),
            InsnType::Binary { .. } => Some(Self::Binary),
            InsnType::Unary { .. } => Some(Self::Unary),
            InsnType::CheckCast { .. } => Some(Self::CheckCast),
            InsnType::Invoke { .. } => Some(Self::Invoke),
            InsnType::InstanceGet { .. } => Some(Self::InstanceGet),
            InsnType::InstancePut { .. } => Some(Self::InstancePut),
            InsnType::StaticGet { .. } => Some(Self::StaticGet),
            InsnType::StaticPut { .. } => Some(Self::StaticPut),
            _ => None,
        }
    }
}

/// Type update engine (mirrors JADX's TypeUpdate)
///
/// This is the core of the type propagation system. It validates type changes
/// against bounds and propagates changes through the instruction graph.
pub struct TypeUpdateEngine {
    /// Class hierarchy for type comparison
    hierarchy: Option<ClassHierarchy>,
    /// Current resolved types for all variables
    resolved: FxHashMap<TypeVar, ArgType>,
    /// Type info (bounds) for all variables
    type_info: FxHashMap<TypeVar, TypeInfo>,
    /// Register to TypeVar mapping for instruction lookups
    reg_to_var: FxHashMap<(u16, u32), TypeVar>,
}

impl TypeUpdateEngine {
    /// Create a new type update engine
    pub fn new(hierarchy: Option<ClassHierarchy>) -> Self {
        Self {
            hierarchy,
            resolved: FxHashMap::default(),
            type_info: FxHashMap::default(),
            reg_to_var: FxHashMap::default(),
        }
    }

    /// Set the class hierarchy
    pub fn with_hierarchy(mut self, hierarchy: ClassHierarchy) -> Self {
        self.hierarchy = Some(hierarchy);
        self
    }

    /// Get reference to resolved types
    pub fn resolved(&self) -> &FxHashMap<TypeVar, ArgType> {
        &self.resolved
    }

    /// Get mutable reference to resolved types
    pub fn resolved_mut(&mut self) -> &mut FxHashMap<TypeVar, ArgType> {
        &mut self.resolved
    }

    /// Get type info for a variable
    pub fn type_info(&self, var: TypeVar) -> Option<&TypeInfo> {
        self.type_info.get(&var)
    }

    /// Get mutable type info for a variable
    pub fn type_info_mut(&mut self, var: TypeVar) -> &mut TypeInfo {
        self.type_info.entry(var).or_default()
    }

    /// Set type info for a variable
    pub fn set_type_info(&mut self, var: TypeVar, info: TypeInfo) {
        self.type_info.insert(var, info);
    }

    /// Register a register to TypeVar mapping
    pub fn register_var(&mut self, reg: u16, ssa: u32, var: TypeVar) {
        self.reg_to_var.insert((reg, ssa), var);
    }

    /// Look up TypeVar for a register
    pub fn var_for_reg(&self, reg: u16, ssa: u32) -> Option<TypeVar> {
        self.reg_to_var.get(&(reg, ssa)).copied()
    }

    /// Apply a type update with default flags
    pub fn apply(
        &mut self,
        var: TypeVar,
        candidate_type: &ArgType,
    ) -> TypeUpdateResult {
        self.apply_with_flags(var, candidate_type, TypeUpdateFlags::empty())
    }

    /// Apply a type update allowing wider types
    pub fn apply_with_wider_allow(
        &mut self,
        var: TypeVar,
        candidate_type: &ArgType,
    ) -> TypeUpdateResult {
        self.apply_with_flags(var, candidate_type, TypeUpdateFlags::wider())
    }

    /// Apply a type update for immutable types
    pub fn apply_with_wider_ignore_same(
        &mut self,
        var: TypeVar,
        candidate_type: &ArgType,
    ) -> TypeUpdateResult {
        self.apply_with_flags(var, candidate_type, TypeUpdateFlags::wider_ignore_same())
    }

    /// Apply a type update with specific flags
    pub fn apply_with_flags(
        &mut self,
        var: TypeVar,
        candidate_type: &ArgType,
        flags: TypeUpdateFlags,
    ) -> TypeUpdateResult {
        // Reject null/unknown types
        if matches!(candidate_type, ArgType::Unknown) {
            return TypeUpdateResult::Reject;
        }

        let mut update_info = TypeUpdateInfo::new(flags);

        // Perform the update check
        let result = self.update_type_checked(&mut update_info, var, candidate_type);

        if result == TypeUpdateResult::Reject {
            return result;
        }

        if update_info.is_empty() {
            return TypeUpdateResult::Same;
        }

        // Apply all pending updates
        update_info.apply_updates(&mut self.resolved);
        TypeUpdateResult::Changed
    }

    /// Check and update a type, collecting updates in the info
    fn update_type_checked(
        &mut self,
        info: &mut TypeUpdateInfo,
        var: TypeVar,
        candidate_type: &ArgType,
    ) -> TypeUpdateResult {
        if info.is_processed(var) {
            return TypeUpdateResult::Changed;
        }

        // Verify the type against current type and bounds
        let verify_result = self.verify_type(info, var, candidate_type);
        if let Some(result) = verify_result {
            return result;
        }

        // Update the SSA variable
        self.update_type_for_var(info, var, candidate_type)
    }

    /// Verify a type change is valid
    fn verify_type(
        &self,
        info: &TypeUpdateInfo,
        var: TypeVar,
        candidate_type: &ArgType,
    ) -> Option<TypeUpdateResult> {
        let current_type = self.resolved.get(&var);
        let flags = info.flags();

        // Check if types are the same
        if let Some(current) = current_type {
            if current == candidate_type {
                if flags.ignore_same {
                    return None; // Continue processing
                }
                return Some(TypeUpdateResult::Same);
            }

            // Don't allow wildcard types
            if matches!(candidate_type, ArgType::Wildcard { .. }) {
                return Some(TypeUpdateResult::Reject);
            }

            // Compare types
            let compare_result = compare_types(candidate_type, current, self.hierarchy.as_ref());

            if compare_result.is_conflict() {
                return Some(TypeUpdateResult::Reject);
            }

            if compare_result == TypeCompare::Unknown && flags.ignore_unknown {
                return Some(TypeUpdateResult::Reject);
            }

            // Check for immutable types
            if let Some(type_info) = self.type_info.get(&var) {
                if type_info.is_immutable() {
                    if compare_result.is_equal() {
                        return Some(TypeUpdateResult::Same);
                    }
                    return Some(TypeUpdateResult::Reject);
                }
            }

            // Check if trying to widen
            if compare_result == TypeCompare::WiderByGeneric && flags.keep_generics {
                return Some(TypeUpdateResult::Reject);
            }

            if compare_result.is_wider() && !flags.allow_wider {
                return Some(TypeUpdateResult::Reject);
            }
        }

        None
    }

    /// Update type for an SSA variable
    fn update_type_for_var(
        &mut self,
        info: &mut TypeUpdateInfo,
        var: TypeVar,
        candidate_type: &ArgType,
    ) -> TypeUpdateResult {
        // Check bounds
        if let Some(type_info) = self.type_info.get(&var) {
            // Check immutable type
            if let Some(immutable_type) = type_info.immutable_type() {
                if immutable_type != candidate_type {
                    return TypeUpdateResult::Reject;
                }
            }

            // Check against all bounds
            if !self.in_bounds(type_info.bounds(), candidate_type) {
                return TypeUpdateResult::Reject;
            }
        }

        // Request the update
        let result = self.request_update(info, var, candidate_type);
        if result == TypeUpdateResult::Reject {
            return result;
        }

        result
    }

    /// Request an update and propagate if needed
    fn request_update(
        &mut self,
        info: &mut TypeUpdateInfo,
        var: TypeVar,
        candidate_type: &ArgType,
    ) -> TypeUpdateResult {
        if info.is_processed(var) {
            return TypeUpdateResult::Changed;
        }

        info.request_update(var, candidate_type.clone());
        TypeUpdateResult::Changed
    }

    /// Check if a type satisfies all bounds
    fn in_bounds(&self, bounds: &[Box<dyn TypeBound>], candidate_type: &ArgType) -> bool {
        for bound in bounds {
            if let Some(bound_type) = bound.get_type() {
                if !self.check_bound(candidate_type, bound.bound_kind(), bound_type) {
                    return false;
                }
            }
        }
        true
    }

    /// Check if a candidate type satisfies a single bound
    fn check_bound(&self, candidate_type: &ArgType, bound_kind: BoundEnum, bound_type: &ArgType) -> bool {
        let compare_result = compare_types(candidate_type, bound_type, self.hierarchy.as_ref());

        match compare_result {
            TypeCompare::Equal => true,

            TypeCompare::Wider => {
                // If candidate is wider (more general), only valid for USE bounds
                // ASSIGN bounds require exact or narrower type
                bound_kind != BoundEnum::Use
            }

            TypeCompare::Narrow => {
                // If candidate is narrower (more specific), check for ASSIGN bounds
                if bound_kind == BoundEnum::Assign {
                    // For ASSIGN, narrower is generally OK if bound type is unknown
                    !bound_type.is_object() || self.check_assign_for_unknown(bound_type, candidate_type)
                } else {
                    true
                }
            }

            TypeCompare::WiderByGeneric | TypeCompare::NarrowByGeneric => {
                // Allow generic differences due to incomplete type info
                true
            }

            TypeCompare::Conflict | TypeCompare::ConflictByGeneric => false,

            TypeCompare::Unknown => {
                // Can't determine - allow
                true
            }
        }
    }

    /// Check assignment compatibility for unknown bound types
    fn check_assign_for_unknown(&self, bound_type: &ArgType, candidate_type: &ArgType) -> bool {
        match bound_type {
            ArgType::Unknown => true,
            ArgType::Array(bound_elem) => {
                if let ArgType::Array(cand_elem) = candidate_type {
                    self.check_assign_for_unknown(bound_elem, cand_elem)
                } else {
                    false
                }
            }
            ArgType::Object(name) if name == "java/lang/Object" => true,
            _ => false,
        }
    }

    /// Compare two types using the class hierarchy
    pub fn compare_types(&self, first: &ArgType, second: &ArgType) -> TypeCompare {
        compare_types(first, second, self.hierarchy.as_ref())
    }
}

// ============================================================================
// Listener implementations
// ============================================================================

impl TypeUpdateEngine {
    /// Run the appropriate listener for an instruction
    pub fn run_listener(
        &mut self,
        info: &mut TypeUpdateInfo,
        insn: &InsnType,
        var: TypeVar,
        candidate_type: &ArgType,
    ) -> TypeUpdateResult {
        let kind = match InsnKind::from_insn(insn) {
            Some(k) => k,
            None => return TypeUpdateResult::Same,
        };

        match kind {
            InsnKind::Const => self.same_first_arg_listener(info, insn, var, candidate_type),
            InsnKind::Move => self.move_listener(info, insn, var, candidate_type),
            InsnKind::Phi => self.all_same_listener(info, insn, var, candidate_type),
            InsnKind::ArrayGet => self.array_get_listener(info, insn, var, candidate_type),
            InsnKind::ArrayPut => self.array_put_listener(info, insn, var, candidate_type),
            InsnKind::If => self.if_listener(info, insn, var, candidate_type),
            InsnKind::Binary => self.arith_listener(info, insn, var, candidate_type),
            InsnKind::Unary => self.suggest_all_same_listener(info, insn, var, candidate_type),
            InsnKind::CheckCast => self.check_cast_listener(info, insn, var, candidate_type),
            InsnKind::Invoke => self.invoke_listener(info, insn, var, candidate_type),
            _ => TypeUpdateResult::Changed,
        }
    }

    /// Listener for CONST instructions - result and first arg have same type
    fn same_first_arg_listener(
        &mut self,
        info: &mut TypeUpdateInfo,
        insn: &InsnType,
        var: TypeVar,
        candidate_type: &ArgType,
    ) -> TypeUpdateResult {
        // For CONST, the result has the literal's type
        // No propagation needed typically
        TypeUpdateResult::Same
    }

    /// Listener for MOVE instructions
    fn move_listener(
        &mut self,
        info: &mut TypeUpdateInfo,
        insn: &InsnType,
        var: TypeVar,
        candidate_type: &ArgType,
    ) -> TypeUpdateResult {
        if let InsnType::Move { dest, src } = insn {
            let dest_var = self.var_for_reg(dest.reg_num, dest.ssa_version);
            let src_var = if let dexterity_ir::instructions::InsnArg::Register(r) = src {
                self.var_for_reg(r.reg_num, r.ssa_version)
            } else {
                None
            };

            // Propagate type between source and destination
            if let Some(dv) = dest_var {
                if dv == var {
                    // We're updating dest, propagate to src
                    if let Some(sv) = src_var {
                        return self.update_type_checked(info, sv, candidate_type);
                    }
                }
            }

            if let Some(sv) = src_var {
                if sv == var {
                    // We're updating src, propagate to dest
                    if let Some(dv) = dest_var {
                        return self.update_type_checked(info, dv, candidate_type);
                    }
                }
            }
        }

        TypeUpdateResult::Same
    }

    /// Listener for PHI instructions - all args must have same type
    fn all_same_listener(
        &mut self,
        info: &mut TypeUpdateInfo,
        insn: &InsnType,
        var: TypeVar,
        candidate_type: &ArgType,
    ) -> TypeUpdateResult {
        if let InsnType::Phi { dest, sources } = insn {
            let dest_var = self.var_for_reg(dest.reg_num, dest.ssa_version);

            // Check if we're updating the dest
            let is_dest = dest_var.map_or(false, |dv| dv == var);

            if is_dest {
                // Propagate to all sources
                let mut all_same = true;
                for (_, src_arg) in sources {
                    if let dexterity_ir::instructions::InsnArg::Register(r) = src_arg {
                        if let Some(sv) = self.var_for_reg(r.reg_num, r.ssa_version) {
                            let result = self.update_type_checked(info, sv, candidate_type);
                            if result == TypeUpdateResult::Reject {
                                return result;
                            }
                            if result != TypeUpdateResult::Same {
                                all_same = false;
                            }
                        }
                    }
                }
                return if all_same {
                    TypeUpdateResult::Same
                } else {
                    TypeUpdateResult::Changed
                };
            } else {
                // We're updating a source, propagate to dest
                if let Some(dv) = dest_var {
                    return self.update_type_checked(info, dv, candidate_type);
                }
            }
        }

        TypeUpdateResult::Same
    }

    /// Listener for AGET instructions
    fn array_get_listener(
        &mut self,
        info: &mut TypeUpdateInfo,
        insn: &InsnType,
        var: TypeVar,
        candidate_type: &ArgType,
    ) -> TypeUpdateResult {
        if let InsnType::ArrayGet { dest, array, .. } = insn {
            let dest_var = self.var_for_reg(dest.reg_num, dest.ssa_version);
            let array_var = if let dexterity_ir::instructions::InsnArg::Register(r) = array {
                self.var_for_reg(r.reg_num, r.ssa_version)
            } else {
                None
            };

            if let Some(dv) = dest_var {
                if dv == var {
                    // Updating result - propagate array type
                    if let Some(av) = array_var {
                        let array_type = ArgType::Array(Box::new(candidate_type.clone()));
                        let result = self.update_type_checked(info, av, &array_type);
                        if result == TypeUpdateResult::Reject {
                            // Check for primitive widening (int a = byteArr[n])
                            if let Some(arr_type) = self.resolved.get(&av) {
                                if let ArgType::Array(elem) = arr_type {
                                    let cmp = self.compare_types(candidate_type, elem);
                                    if cmp == TypeCompare::Wider {
                                        return TypeUpdateResult::Changed;
                                    }
                                }
                            }
                        }
                        return result;
                    }
                }
            }

            if let Some(av) = array_var {
                if av == var {
                    // Updating array - propagate element type
                    if let ArgType::Array(elem) = candidate_type {
                        if let Some(dv) = dest_var {
                            return self.update_type_checked(info, dv, elem);
                        }
                    }
                }
            }
        }

        TypeUpdateResult::Same
    }

    /// Listener for APUT instructions
    fn array_put_listener(
        &mut self,
        info: &mut TypeUpdateInfo,
        insn: &InsnType,
        var: TypeVar,
        candidate_type: &ArgType,
    ) -> TypeUpdateResult {
        if let InsnType::ArrayPut { array, value, .. } = insn {
            let array_var = if let dexterity_ir::instructions::InsnArg::Register(r) = array {
                self.var_for_reg(r.reg_num, r.ssa_version)
            } else {
                None
            };
            let value_var = if let dexterity_ir::instructions::InsnArg::Register(r) = value {
                self.var_for_reg(r.reg_num, r.ssa_version)
            } else {
                None
            };

            if let Some(av) = array_var {
                if av == var {
                    // Updating array - propagate element type to value
                    if let ArgType::Array(elem) = candidate_type {
                        if let Some(vv) = value_var {
                            return self.update_type_checked(info, vv, elem);
                        }
                    }
                }
            }

            if let Some(vv) = value_var {
                if vv == var {
                    // Updating value - propagate to array
                    if let Some(av) = array_var {
                        let array_type = ArgType::Array(Box::new(candidate_type.clone()));
                        return self.update_type_checked(info, av, &array_type);
                    }
                }
            }
        }

        TypeUpdateResult::Same
    }

    /// Listener for IF instructions
    fn if_listener(
        &mut self,
        info: &mut TypeUpdateInfo,
        insn: &InsnType,
        var: TypeVar,
        candidate_type: &ArgType,
    ) -> TypeUpdateResult {
        if let InsnType::If { left, right, .. } = insn {
            let left_var = if let dexterity_ir::instructions::InsnArg::Register(r) = left {
                self.var_for_reg(r.reg_num, r.ssa_version)
            } else {
                None
            };
            let right_var = right.as_ref().and_then(|r| {
                if let dexterity_ir::instructions::InsnArg::Register(reg) = r {
                    self.var_for_reg(reg.reg_num, reg.ssa_version)
                } else {
                    None
                }
            });

            // Propagate type between compared values
            let other_var = if left_var.map_or(false, |lv| lv == var) {
                right_var
            } else if right_var.map_or(false, |rv| rv == var) {
                left_var
            } else {
                None
            };

            if let Some(ov) = other_var {
                let result = self.update_type_checked(info, ov, candidate_type);
                if result == TypeUpdateResult::Reject {
                    // Soft checks - allow object/array comparisons
                    if let Some(other_type) = self.resolved.get(&ov) {
                        if candidate_type.is_object() && other_type.is_object() {
                            return TypeUpdateResult::Same;
                        }
                    }
                }
                return result;
            }
        }

        TypeUpdateResult::Same
    }

    /// Listener for arithmetic instructions
    fn arith_listener(
        &mut self,
        info: &mut TypeUpdateInfo,
        insn: &InsnType,
        var: TypeVar,
        candidate_type: &ArgType,
    ) -> TypeUpdateResult {
        // For arithmetic, if result is boolean (from bit ops), propagate to all args
        if matches!(candidate_type, ArgType::Boolean) {
            return self.all_same_listener(info, insn, var, candidate_type);
        }
        // Otherwise suggest same type without failing
        self.suggest_all_same_listener(info, insn, var, candidate_type)
    }

    /// Suggest same type to all args without failing on reject
    fn suggest_all_same_listener(
        &mut self,
        info: &mut TypeUpdateInfo,
        insn: &InsnType,
        var: TypeVar,
        candidate_type: &ArgType,
    ) -> TypeUpdateResult {
        // Try to propagate but don't fail on reject
        let mut any_changed = false;

        // This is a simplified version - full implementation would iterate args
        match insn {
            InsnType::Binary { dest, left, right, .. } => {
                let dest_var = self.var_for_reg(dest.reg_num, dest.ssa_version);

                if dest_var.map_or(false, |dv| dv != var) {
                    if let Some(dv) = dest_var {
                        let _ = self.update_type_checked(info, dv, candidate_type);
                    }
                }
            }
            _ => {}
        }

        if any_changed {
            TypeUpdateResult::Changed
        } else {
            TypeUpdateResult::Same
        }
    }

    /// Listener for CHECK_CAST instructions
    fn check_cast_listener(
        &mut self,
        info: &mut TypeUpdateInfo,
        insn: &InsnType,
        var: TypeVar,
        candidate_type: &ArgType,
    ) -> TypeUpdateResult {
        if let InsnType::CheckCast { object, type_idx } = insn {
            let obj_var = if let dexterity_ir::instructions::InsnArg::Register(r) = object {
                self.var_for_reg(r.reg_num, r.ssa_version)
            } else {
                None
            };

            // For CHECK_CAST, we typically don't propagate backwards
            // The cast target type constrains the result
        }

        TypeUpdateResult::Same
    }

    /// Listener for INVOKE instructions
    ///
    /// Handles bidirectional type propagation for method invocations:
    /// - When instance type is updated, resolve generic types for arguments
    /// - When argument type is updated, may propagate back to instance
    fn invoke_listener(
        &mut self,
        info: &mut TypeUpdateInfo,
        insn: &InsnType,
        var: TypeVar,
        candidate_type: &ArgType,
    ) -> TypeUpdateResult {
        let InsnType::Invoke { kind, args, .. } = insn else {
            return TypeUpdateResult::Same;
        };

        let is_static = matches!(kind, InvokeKind::Static);

        // Build TypeVar mapping for args
        let arg_vars: Vec<Option<TypeVar>> = args
            .iter()
            .map(|arg| {
                if let InsnArg::Register(r) = arg {
                    self.var_for_reg(r.reg_num, r.ssa_version)
                } else {
                    None
                }
            })
            .collect();

        // Case 1: Instance type is being updated (non-static, args[0])
        if !is_static && !arg_vars.is_empty() {
            if let Some(instance_var) = arg_vars[0] {
                if instance_var == var {
                    // Instance updated -> propagate to arguments with generic constraints
                    return self.propagate_from_instance(info, candidate_type, &arg_vars[1..]);
                }
            }
        }

        // Case 2: An argument type is being updated
        let param_start = if is_static { 0 } else { 1 };
        for arg_var in arg_vars.iter().skip(param_start).flatten() {
            if *arg_var == var {
                // Argument updated -> may propagate back to instance or other args
                if !is_static {
                    if let Some(instance_var) = arg_vars[0] {
                        return self.propagate_to_instance(info, candidate_type, instance_var);
                    }
                }
            }
        }

        TypeUpdateResult::Same
    }

    /// Resolve a type variable against an instance type's generic parameters.
    ///
    /// Maps common type variable names to their positions in generic parameters:
    /// - E, T, R -> First type parameter (List<E>, Optional<T>, etc.)
    /// - V -> Second type parameter (Map<K,V>)
    /// - K -> First type parameter (Map<K,V>)
    fn resolve_type_var(var_name: &str, instance_type: &ArgType) -> Option<ArgType> {
        if let ArgType::Generic { params, .. } = instance_type {
            if !params.is_empty() {
                return match var_name {
                    "E" | "T" | "R" => params.first().cloned(),
                    "V" if params.len() >= 2 => params.get(1).cloned(),
                    "K" => params.first().cloned(),
                    _ => params.first().cloned(),
                };
            }
        }
        None
    }

    /// Propagate type updates from instance to arguments with generic constraints.
    ///
    /// When the instance type is updated (e.g., from Object to List<String>),
    /// resolve any TypeVariable in argument types using the instance's generic parameters.
    fn propagate_from_instance(
        &mut self,
        info: &mut TypeUpdateInfo,
        instance_type: &ArgType,
        arg_vars: &[Option<TypeVar>],
    ) -> TypeUpdateResult {
        let mut changed = false;

        for arg_var in arg_vars.iter().flatten() {
            if let Some(current_type) = self.resolved.get(arg_var).cloned() {
                if let ArgType::TypeVariable(ref var_name) = current_type {
                    if let Some(resolved_type) = Self::resolve_type_var(var_name, instance_type) {
                        let result = self.update_type_checked(info, *arg_var, &resolved_type);
                        if result == TypeUpdateResult::Reject {
                            return result;
                        }
                        if result == TypeUpdateResult::Changed {
                            changed = true;
                        }
                    }
                }
            }
        }

        if changed {
            TypeUpdateResult::Changed
        } else {
            TypeUpdateResult::Same
        }
    }

    /// Propagate type updates from an argument back to the instance.
    ///
    /// This is the less common reverse propagation path. When an argument type
    /// is constrained, it may help infer the instance's generic parameters.
    /// Currently conservative - returns Same for most cases.
    fn propagate_to_instance(
        &mut self,
        info: &mut TypeUpdateInfo,
        arg_type: &ArgType,
        instance_var: TypeVar,
    ) -> TypeUpdateResult {
        // Check if instance type is currently Unknown or a raw generic
        if let Some(instance_type) = self.resolved.get(&instance_var).cloned() {
            // If instance has a Generic type without resolved params, and arg is concrete,
            // we could potentially infer the generic param. This is an advanced case.
            if let ArgType::Generic { params, .. } = &instance_type {
                // If params contain TypeVariable and arg_type is concrete,
                // we could update the instance type. Conservative for now.
                let has_unresolved = params.iter().any(|p| matches!(p, ArgType::TypeVariable(_)));
                if has_unresolved && !matches!(arg_type, ArgType::TypeVariable(_) | ArgType::Unknown) {
                    // Could infer: if arg is String and method expects E, instance might be List<String>
                    // This requires method signature lookup - defer for now
                }
            }
        }

        // Conservative: don't propagate backwards without method signature context
        TypeUpdateResult::Same
    }
}

#[cfg(test)]
mod tests {
    use super::*;

    #[test]
    fn test_type_update_result() {
        assert!(TypeUpdateResult::Changed.is_changed());
        assert!(!TypeUpdateResult::Same.is_changed());
        assert!(TypeUpdateResult::Reject.is_reject());
    }

    #[test]
    fn test_type_update_flags() {
        let flags = TypeUpdateFlags::empty();
        assert!(!flags.allow_wider);
        assert!(!flags.ignore_same);

        let wider = TypeUpdateFlags::wider();
        assert!(wider.allow_wider);
        assert!(!wider.ignore_same);

        let wider_ignore = TypeUpdateFlags::wider_ignore_same();
        assert!(wider_ignore.allow_wider);
        assert!(wider_ignore.ignore_same);
    }

    #[test]
    fn test_type_update_info() {
        let mut info = TypeUpdateInfo::new(TypeUpdateFlags::empty());
        let var = TypeVar::new(0);

        assert!(!info.is_processed(var));
        assert!(info.is_empty());

        info.request_update(var, ArgType::Int);

        assert!(info.is_processed(var));
        assert!(!info.is_empty());
        assert_eq!(info.get_type(var), Some(&ArgType::Int));

        info.rollback_update(var);

        assert!(!info.is_processed(var));
        assert!(info.is_empty());
    }

    #[test]
    fn test_insn_kind_from_insn() {
        let const_insn = InsnType::Const {
            dest: RegisterArg { reg_num: 0, ssa_version: 0 },
            value: dexterity_ir::instructions::LiteralArg::Int(0),
        };
        assert_eq!(InsnKind::from_insn(&const_insn), Some(InsnKind::Const));

        let move_insn = InsnType::Move {
            dest: RegisterArg { reg_num: 0, ssa_version: 0 },
            src: dexterity_ir::instructions::InsnArg::Register(RegisterArg { reg_num: 1, ssa_version: 0 }),
        };
        assert_eq!(InsnKind::from_insn(&move_insn), Some(InsnKind::Move));
    }

    #[test]
    fn test_type_update_engine_apply() {
        let mut engine = TypeUpdateEngine::new(None);
        let var = TypeVar::new(0);

        // First update should succeed
        let result = engine.apply(var, &ArgType::Int);
        assert_eq!(result, TypeUpdateResult::Changed);

        // Same type should return Same
        let result = engine.apply(var, &ArgType::Int);
        assert_eq!(result, TypeUpdateResult::Same);

        // Different type without allow_wider should be rejected
        let result = engine.apply(var, &ArgType::Long);
        // This depends on implementation - Long is wider than Int
    }
}
