//! Type fixing visitor for resolving unknown types
//!
//! This pass applies various heuristic strategies to fix unresolved types
//! after the main type inference pass. It mirrors JADX's FixTypesVisitor.
//!
//! ## Strategies (in order of application):
//!
//! 1. **RestoreTypeVarCasts** - Fix check casts to type variable extend types
//! 2. **InsertCasts** - Insert soft casts to help type inference
//! 3. **DeduceTypes** - Try best type from bounds, possible types, wider objects
//! 4. **SplitConstInsns** - Split constant instructions for better inference
//! 5. **FixIncompatiblePrimitives** - Handle boolean/int incompatibilities
//! 6. **ForceImmutableTypes** - Force immutable types when used in array access
//! 7. **InsertAdditionalMove** - Add MOVE instructions before PHI
//! 8. **RemoveGenerics** - Try raw types without generics as fallback
//!
//! Based on JADX's FixTypesVisitor.java (844 lines)


use rustc_hash::{FxHashMap, FxHashSet};

use dexterity_ir::attributes::AFlag;
use dexterity_ir::instructions::{InsnArg, InsnNode, InsnType, RegisterArg};
use dexterity_ir::ssa::SSAVarRef;
use dexterity_ir::types::ArgType;
use dexterity_ir::ClassHierarchy;

use crate::ssa::SsaResult;
use crate::type_bound::{BoundEnum, TypeInfo};
use crate::type_inference::{TypeInferenceResult, TypeVar};

/// Information about a move to be inserted for PHI
#[derive(Debug)]
struct PhiMoveInfo {
    /// Block index containing the PHI
    phi_block_idx: usize,
    /// PHI index within the block
    phi_idx: usize,
    /// Source index within the PHI
    src_idx: usize,
    /// Block index where the move should be inserted
    insert_block_idx: usize,
    /// Register number
    reg_num: u16,
    /// Original SSA version
    old_version: u32,
}

/// Check if an instruction type is a block separator (ends control flow)
///
/// JADX Reference: BlockSplitter.isSeparate()
fn is_block_separator(insn_type: &InsnType) -> bool {
    matches!(
        insn_type,
        InsnType::Goto { .. } | InsnType::If { .. } |
        InsnType::PackedSwitch { .. } | InsnType::SparseSwitch { .. } |
        InsnType::Return { .. } | InsnType::Throw { .. }
    )
}

/// Result of the fix types pass
#[derive(Debug, Default)]
pub struct FixTypesResult {
    /// Number of types fixed
    pub fixed_count: usize,
    /// Number of variables that remain unresolved
    pub unresolved_count: usize,
    /// Strategies that succeeded
    pub successful_strategies: Vec<String>,
    /// Whether all types are now resolved
    pub all_resolved: bool,
}

/// Type fixing strategy
#[derive(Debug, Clone, Copy, PartialEq, Eq)]
pub enum FixStrategy {
    /// Try to restore type variable casts
    RestoreTypeVarCasts,
    /// Insert soft casts to help inference
    InsertCasts,
    /// Deduce types from bounds
    DeduceTypes,
    /// Split constant instructions
    SplitConstInsns,
    /// Fix incompatible primitives (boolean/int)
    FixIncompatiblePrimitives,
    /// Force immutable types
    ForceImmutableTypes,
    /// Insert additional move instructions
    InsertAdditionalMove,
    /// Remove generics and try raw types
    RemoveGenerics,
}

impl FixStrategy {
    /// Get the name of this strategy
    pub fn name(&self) -> &'static str {
        match self {
            FixStrategy::RestoreTypeVarCasts => "RestoreTypeVarCasts",
            FixStrategy::InsertCasts => "InsertCasts",
            FixStrategy::DeduceTypes => "DeduceTypes",
            FixStrategy::SplitConstInsns => "SplitConstInsns",
            FixStrategy::FixIncompatiblePrimitives => "FixIncompatiblePrimitives",
            FixStrategy::ForceImmutableTypes => "ForceImmutableTypes",
            FixStrategy::InsertAdditionalMove => "InsertAdditionalMove",
            FixStrategy::RemoveGenerics => "RemoveGenerics",
        }
    }
}

/// All strategies in order of application
const ALL_STRATEGIES: &[FixStrategy] = &[
    FixStrategy::RestoreTypeVarCasts,
    FixStrategy::InsertCasts,
    FixStrategy::DeduceTypes,
    FixStrategy::SplitConstInsns,
    FixStrategy::FixIncompatiblePrimitives,
    FixStrategy::ForceImmutableTypes,
    FixStrategy::InsertAdditionalMove,
    FixStrategy::RemoveGenerics,
];

/// Type fixing context
pub struct FixTypes {
    /// Resolved types from inference
    resolved_types: FxHashMap<TypeVar, ArgType>,
    /// Type info per variable
    type_info: FxHashMap<TypeVar, TypeInfo>,
    /// Class hierarchy for type comparison
    hierarchy: Option<ClassHierarchy>,
    /// Variables marked as immutable
    immutable_vars: FxHashSet<TypeVar>,
    /// Strategies to try (default: all)
    strategies: Vec<FixStrategy>,
}

impl FixTypes {
    /// Create a new fix types pass
    pub fn new() -> Self {
        Self {
            resolved_types: FxHashMap::default(),
            type_info: FxHashMap::default(),
            hierarchy: None,
            immutable_vars: FxHashSet::default(),
            strategies: ALL_STRATEGIES.to_vec(),
        }
    }

    /// Set the resolved types from type inference
    pub fn with_resolved_types(mut self, types: FxHashMap<TypeVar, ArgType>) -> Self {
        self.resolved_types = types;
        self
    }

    /// Set the type info from type inference
    pub fn with_type_info(mut self, info: FxHashMap<TypeVar, TypeInfo>) -> Self {
        self.type_info = info;
        self
    }

    /// Set the class hierarchy
    pub fn with_hierarchy(mut self, hierarchy: ClassHierarchy) -> Self {
        self.hierarchy = Some(hierarchy);
        self
    }

    /// Set immutable variables
    pub fn with_immutable_vars(mut self, vars: FxHashSet<TypeVar>) -> Self {
        self.immutable_vars = vars;
        self
    }

    /// Set which strategies to try
    pub fn with_strategies(mut self, strategies: Vec<FixStrategy>) -> Self {
        self.strategies = strategies;
        self
    }

    /// Check if a type is considered unresolved
    fn is_unresolved(ty: &ArgType) -> bool {
        matches!(ty, ArgType::Unknown | ArgType::TypeVariable { .. })
    }

    /// Check if all types are resolved
    fn check_types(&self) -> bool {
        for (_var, ty) in &self.resolved_types {
            if Self::is_unresolved(ty) {
                return false;
            }
        }
        true
    }

    /// Count unresolved types
    fn count_unresolved(&self) -> usize {
        self.resolved_types
            .values()
            .filter(|ty| Self::is_unresolved(ty))
            .count()
    }

    /// Get unresolved variables
    fn get_unresolved_vars(&self) -> Vec<TypeVar> {
        self.resolved_types
            .iter()
            .filter(|(_, ty)| Self::is_unresolved(ty))
            .map(|(var, _)| *var)
            .collect()
    }

    /// Run the fix types pass
    pub fn run(&mut self, ssa: &SsaResult) -> FixTypesResult {
        let mut result = FixTypesResult::default();

        // Check if already resolved
        if self.check_types() {
            result.all_resolved = true;
            return result;
        }

        let initial_unresolved = self.count_unresolved();

        // Try each strategy in order
        for strategy in &self.strategies.clone() {
            let fixed = match strategy {
                FixStrategy::RestoreTypeVarCasts => self.try_restore_type_var_casts(ssa),
                FixStrategy::InsertCasts => self.try_insert_casts(ssa),
                FixStrategy::DeduceTypes => self.try_deduce_types(ssa),
                FixStrategy::SplitConstInsns => self.try_split_const_insns(ssa),
                FixStrategy::FixIncompatiblePrimitives => self.try_fix_incompatible_primitives(ssa),
                FixStrategy::ForceImmutableTypes => self.try_force_immutable_types(ssa),
                FixStrategy::InsertAdditionalMove => self.try_insert_additional_move(ssa),
                FixStrategy::RemoveGenerics => self.try_remove_generics(ssa),
            };

            if fixed {
                result.successful_strategies.push(strategy.name().to_string());
                if self.check_types() {
                    break;
                }
            }
        }

        let final_unresolved = self.count_unresolved();
        result.fixed_count = initial_unresolved.saturating_sub(final_unresolved);
        result.unresolved_count = final_unresolved;
        result.all_resolved = final_unresolved == 0;

        result
    }

    /// Strategy 1: Restore type variable casts
    ///
    /// Fix check casts to type var extend type:
    /// `<T extends Comparable> T var = (Comparable) obj;` => `T var = (T) obj;`
    fn try_restore_type_var_casts(&mut self, _ssa: &SsaResult) -> bool {
        let mut changed = false;

        for var in self.get_unresolved_vars() {
            if self.immutable_vars.contains(&var) {
                continue;
            }

            // Check if this var has type variable bounds
            if let Some(info) = self.type_info.get(&var) {
                let has_generic_bound = info.bounds().iter().any(|b| {
                    if let Some(ty) = b.get_type() {
                        matches!(ty, ArgType::TypeVariable { .. })
                    } else {
                        false
                    }
                });

                if has_generic_bound {
                    // Check for CheckCast bounds
                    let has_cast_bound = info.bounds().iter().any(|b| {
                        // Simplified check - in full impl we'd check for TypeBoundCheckCastAssign
                        b.bound_kind() == BoundEnum::Assign
                    });

                    if has_cast_bound {
                        // Try to select best type from bounds
                        if let Some(best) = self.select_best_type_from_bounds(&var) {
                            if !matches!(best, ArgType::Unknown) {
                                self.resolved_types.insert(var, best);
                                changed = true;
                            }
                        }
                    }
                }
            }
        }

        changed
    }

    /// Strategy 2: Insert casts to help type inference
    fn try_insert_casts(&mut self, _ssa: &SsaResult) -> bool {
        // In JADX this inserts actual CHECK_CAST instructions
        // For dexterity, we primarily update type bounds
        let mut changed = false;

        for var in self.get_unresolved_vars() {
            if self.immutable_vars.contains(&var) {
                continue;
            }

            if let Some(info) = self.type_info.get(&var) {
                // Look for a known object type bound we could use
                for bound in info.bounds() {
                    if let Some(ty) = bound.get_type() {
                        if ty.is_object() && !matches!(ty, ArgType::Unknown) {
                            // Apply this type
                            self.resolved_types.insert(var, ty.clone());
                            changed = true;
                            break;
                        }
                    }
                }
            }
        }

        changed
    }

    /// Strategy 3: Deduce types from bounds
    ///
    /// Try:
    /// 1. Best type from bounds
    /// 2. Possible primitive types
    /// 3. Wider object types
    fn try_deduce_types(&mut self, _ssa: &SsaResult) -> bool {
        let mut changed = false;

        for var in self.get_unresolved_vars() {
            if self.immutable_vars.contains(&var) {
                continue;
            }

            // Try best type from bounds
            if let Some(best) = self.select_best_type_from_bounds(&var) {
                if !matches!(best, ArgType::Unknown) {
                    self.resolved_types.insert(var, best);
                    changed = true;
                    continue;
                }
            }

            // Try possible primitive types
            if self.try_possible_primitives(&var) {
                changed = true;
                continue;
            }

            // Try wider object types
            if self.try_wider_objects(&var) {
                changed = true;
            }
        }

        changed
    }

    /// Strategy 4: Split constant instructions (splitByPhi)
    ///
    /// When a constant is used in multiple PHIs with different type requirements,
    /// each PHI can have its own type after the CONST instruction is duplicated.
    ///
    /// JADX Reference: FixTypesVisitor.trySplitConstInsns() and splitByPhi() lines 464-535
    ///
    /// NOTE: The actual instruction duplication is done by `crate::ssa::split_by_phi()`.
    /// This strategy handles the fallback type resolution when SSA cannot be modified,
    /// or resolves types for constants with multiple use types in a single PHI context.
    fn try_split_const_insns(&mut self, ssa: &SsaResult) -> bool {
        let mut changed = false;

        // Find constants used in multiple PHIs and try to resolve their types
        // based on PHI destination types. The actual instruction splitting is
        // done by crate::ssa::split_by_phi() which must be called with mutable SSA.
        let mut const_to_phis: FxHashMap<(u16, u32), Vec<(u32, &crate::ssa::PhiNode)>> = FxHashMap::default();

        for block in &ssa.blocks {
            for phi in &block.phi_nodes {
                for (_, src_reg) in &phi.sources {
                    // Check if this source is a constant
                    if self.is_const_assignment(ssa, src_reg) {
                        let key = (src_reg.reg_num, src_reg.ssa_version);
                        const_to_phis.entry(key)
                            .or_default()
                            .push((block.id, phi));
                    }
                }
            }
        }

        // For constants used in PHIs, try to resolve based on PHI context
        for ((reg_num, ssa_version), phi_refs) in const_to_phis {
            let var = TypeVar::new(ssa_version);

            // Skip if already resolved
            if let Some(ty) = self.resolved_types.get(&var) {
                if !matches!(ty, ArgType::Unknown) {
                    continue;
                }
            }

            // Collect type hints from each PHI's destination
            let mut type_hints: Vec<&ArgType> = Vec::new();
            for (_, phi) in &phi_refs {
                let dest_var = TypeVar::new(phi.dest.ssa_version);
                if let Some(ty) = self.resolved_types.get(&dest_var) {
                    if !matches!(ty, ArgType::Unknown) {
                        type_hints.push(ty);
                    }
                }
            }

            // If we have type hints, try to find common type
            if !type_hints.is_empty() {
                if let Some(common) = self.find_common_type(&type_hints) {
                    self.resolved_types.insert(var, common);
                    changed = true;
                    tracing::debug!(
                        "splitByPhi: Resolved r{}#{} used in {} PHIs to {:?}",
                        reg_num, ssa_version, phi_refs.len(), self.resolved_types.get(&var)
                    );
                }
            }
        }

        // Also handle single-PHI constants with multiple use types
        for var in self.get_unresolved_vars() {
            if let Some(info) = self.type_info.get(&var) {
                // Check if this looks like a constant with multiple use types
                let use_bounds: Vec<_> = info
                    .bounds()
                    .iter()
                    .filter(|b| b.bound_kind() == BoundEnum::Use)
                    .filter_map(|b| b.get_type())
                    .collect();

                if use_bounds.len() > 1 {
                    // Multiple use types - try to find a common type
                    if let Some(common) = self.find_common_type(&use_bounds) {
                        self.resolved_types.insert(var, common);
                        changed = true;
                    }
                }
            }
        }

        changed
    }

    /// Check if a register is assigned by a CONST instruction
    fn is_const_assignment(&self, ssa: &SsaResult, reg: &dexterity_ir::instructions::RegisterArg) -> bool {
        for block in &ssa.blocks {
            for insn in &block.instructions {
                // Check if this instruction assigns to the target register
                let dest_reg = match &insn.insn_type {
                    InsnType::Const { dest, .. } => Some(dest),
                    InsnType::ConstString { dest, .. } => Some(dest),
                    InsnType::ConstClass { dest, .. } => Some(dest),
                    _ => None,
                };

                if let Some(dest) = dest_reg {
                    if dest.reg_num == reg.reg_num && dest.ssa_version == reg.ssa_version {
                        return true; // It's a const instruction
                    }
                }
            }
        }
        false
    }

    /// Strategy 5: Fix incompatible primitives
    ///
    /// Handle boolean vs int type conflicts
    fn try_fix_incompatible_primitives(&mut self, _ssa: &SsaResult) -> bool {
        let mut changed = false;

        for var in self.get_unresolved_vars() {
            if let Some(info) = self.type_info.get(&var) {
                let mut has_boolean_assign = false;
                let mut has_numeric_use = false;

                for bound in info.bounds() {
                    if let Some(ty) = bound.get_type() {
                        match bound.bound_kind() {
                            BoundEnum::Assign => {
                                if matches!(ty, ArgType::Boolean) {
                                    has_boolean_assign = true;
                                }
                            }
                            BoundEnum::Use => {
                                if ty.is_primitive()
                                    && !matches!(ty, ArgType::Boolean)
                                    && ty.can_be_numeric()
                                {
                                    has_numeric_use = true;
                                }
                            }
                        }
                    }
                }

                // If assigned boolean but used as numeric, resolve to int
                if has_boolean_assign && has_numeric_use {
                    self.resolved_types.insert(var, ArgType::Int);
                    changed = true;
                }
            }
        }

        changed
    }

    /// Strategy 6: Force immutable types
    ///
    /// If a variable is marked immutable (e.g., method parameter), force its type
    fn try_force_immutable_types(&mut self, _ssa: &SsaResult) -> bool {
        let mut changed = false;

        for var in self.get_unresolved_vars() {
            if let Some(info) = self.type_info.get(&var) {
                if info.is_immutable() {
                    if let Some(imm_ty) = info.immutable_type() {
                        if !matches!(imm_ty, ArgType::Unknown) {
                            self.resolved_types.insert(var, imm_ty.clone());
                            changed = true;
                        }
                    }
                }
            }
        }

        changed
    }

    /// Strategy 7: Insert additional move instructions
    ///
    /// Add MOVE before PHI to create soft type links.
    /// This allows using different types in blocks merged by PHI.
    ///
    /// JADX Reference: FixTypesVisitor.tryInsertAdditionalMove() lines 537-559
    fn try_insert_additional_move(&mut self, ssa: &SsaResult) -> bool {
        // Count how many moves we would insert
        let mut total_moves = 0;

        for block in &ssa.blocks {
            for phi in &block.phi_nodes {
                // Check if all args have the same known type
                if self.phi_has_common_known_type(phi) {
                    continue;
                }

                // Count moves needed for this PHI
                let moves_needed = self.count_moves_for_phi(ssa, phi);
                total_moves += moves_needed;
            }
        }

        if total_moves == 0 {
            return false;
        }

        tracing::debug!("PHI type fix would insert {} moves", total_moves);

        // For now, we note that moves are needed but don't modify SSA
        // The actual instruction insertion requires mutable SSA access
        // which should be done at a higher level
        //
        // Instead, we try to fix types by using wider bounds
        self.try_fix_phi_types_via_bounds(ssa)
    }

    /// Check if a PHI has a common known type for all arguments
    ///
    /// Returns true if all PHI args have the same known type.
    /// This matches the JADX logic: `phiType != null && phiType.isTypeKnown()`
    ///
    /// JADX Reference: FixTypesVisitor.tryInsertAdditionalInsn() lines 566-569
    fn phi_has_common_known_type(&self, phi: &crate::ssa::PhiNode) -> bool {
        match self.get_common_type_for_phi_args(phi) {
            Some(ty) => ty.is_type_known(),
            None => false,
        }
    }

    /// Get the common type if all PHI arguments have the same type
    ///
    /// Returns Some(type) if all args have the same known type, None otherwise.
    /// This is the exact match for JADX's getCommonTypeForPhiArgs() behavior.
    ///
    /// JADX Reference: FixTypesVisitor.getCommonTypeForPhiArgs() lines 579-591
    fn get_common_type_for_phi_args(&self, phi: &crate::ssa::PhiNode) -> Option<ArgType> {
        if phi.sources.is_empty() {
            return None;
        }

        let mut phi_arg_type: Option<ArgType> = None;

        for (_, src_reg) in &phi.sources {
            let var = TypeVar::new(src_reg.ssa_version);
            let ty = match self.resolved_types.get(&var) {
                Some(t) => t.clone(),
                None => return None, // Unknown type
            };

            match &phi_arg_type {
                None => phi_arg_type = Some(ty),
                Some(prev) => {
                    if prev != &ty {
                        return None; // Different types
                    }
                }
            }
        }

        phi_arg_type
    }

    /// Count how many MOVE instructions would need to be inserted for a PHI
    ///
    /// JADX Reference: FixTypesVisitor.insertMovesForPhi() lines 593-622
    fn count_moves_for_phi(&self, ssa: &SsaResult, phi: &crate::ssa::PhiNode) -> usize {
        let mut count = 0;

        for (pred_block_id, src_reg) in &phi.sources {
            // Find the predecessor block
            let pred_block = match ssa.blocks.iter().find(|b| b.id == *pred_block_id) {
                Some(b) => b,
                None => continue,
            };

            // Check if we can insert in this block
            if !self.can_insert_in_block(pred_block) {
                continue;
            }

            // Skip if assigned by CONST (optimization)
            // Skip if assigned by MOVE with single use (optimization)
            if self.should_skip_move_for_var(ssa, src_reg) {
                continue;
            }

            count += 1;
        }

        count
    }

    /// Check if we can insert instructions in a block, returning the block index to use
    ///
    /// JADX Reference: FixTypesVisitor.checkBlockForInsnInsert() lines 641-655
    ///
    /// If the block ends with a separator instruction (goto, return, etc.),
    /// we try walking back to a predecessor block. Returns None if no suitable
    /// block can be found.
    fn check_block_for_insn_insert(&self, ssa: &SsaResult, block_idx: usize) -> Option<usize> {
        let block = &ssa.blocks[block_idx];

        // Check last instruction - can't insert after "separate" instructions
        // (GOTO, IF, SWITCH, RETURN, THROW)
        if let Some(last_insn) = block.instructions.last() {
            if is_block_separator(&last_insn.insn_type) {
                // Block ends with branch - try previous block by simple path
                // JADX: "try previous block by simple path" - only if exactly 1 predecessor
                if block.predecessors.len() == 1 {
                    let pred_id = block.predecessors[0];
                    // Find predecessor block index
                    if let Some(pred_idx) = ssa.blocks.iter().position(|b| b.id == pred_id) {
                        return self.check_block_for_insn_insert(ssa, pred_idx);
                    }
                }
                return None;
            }
        }

        Some(block_idx)
    }

    /// Legacy method for simple block check (used by count_moves_for_phi)
    fn can_insert_in_block(&self, block: &crate::ssa::SsaBlock) -> bool {
        if let Some(last_insn) = block.instructions.last() {
            if is_block_separator(&last_insn.insn_type) {
                return false;
            }
        }
        true
    }

    /// Check if we should skip inserting a MOVE for this variable
    ///
    /// Skip if:
    /// - Assigned by CONST instruction (type flexibility handled by splitByPhi)
    /// - Assigned by MOVE with only 1 use (redundant)
    fn should_skip_move_for_var(&self, ssa: &SsaResult, reg: &dexterity_ir::instructions::RegisterArg) -> bool {
        // Find the instruction that assigns this register
        for block in &ssa.blocks {
            for insn in &block.instructions {
                // Check if this instruction assigns to our target register
                let (is_const, is_move, dest) = match &insn.insn_type {
                    InsnType::Const { dest, .. } => (true, false, Some(dest)),
                    InsnType::ConstString { dest, .. } => (true, false, Some(dest)),
                    InsnType::ConstClass { dest, .. } => (true, false, Some(dest)),
                    InsnType::Move { dest, .. } => (false, true, Some(dest)),
                    // Other instructions that produce results
                    InsnType::Unary { dest, .. }
                    | InsnType::Binary { dest, .. }
                    | InsnType::InstanceOf { dest, .. }
                    | InsnType::ArrayLength { dest, .. }
                    | InsnType::NewInstance { dest, .. }
                    | InsnType::NewArray { dest, .. }
                    | InsnType::ArrayGet { dest, .. }
                    | InsnType::InstanceGet { dest, .. }
                    | InsnType::StaticGet { dest, .. }
                    | InsnType::Cast { dest, .. }
                    | InsnType::MoveResult { dest, .. }
                    | InsnType::MoveException { dest, .. }
                    | InsnType::Compare { dest, .. } => (false, false, Some(dest)),
                    _ => (false, false, None),
                };

                if let Some(dest) = dest {
                    if dest.reg_num == reg.reg_num && dest.ssa_version == reg.ssa_version {
                        // Found the assignment
                        if is_const {
                            return true; // Skip for CONST
                        }
                        if is_move {
                            // Check use count - would need SSA context for this
                            // For now, don't skip MOVE
                            return false;
                        }
                        return false;
                    }
                }
            }
        }

        false
    }

    /// Try to fix PHI types by widening bounds
    ///
    /// Since we can't easily modify SSA here, we try alternative fixes
    fn try_fix_phi_types_via_bounds(&mut self, _ssa: &SsaResult) -> bool {
        let mut changed = false;

        for var in self.get_unresolved_vars() {
            if let Some(info) = self.type_info.get(&var) {
                // Try to find a common type from all bounds
                let types: Vec<_> = info.bounds()
                    .iter()
                    .filter_map(|b| b.get_type())
                    .filter(|t| !matches!(t, ArgType::Unknown))
                    .collect();

                if !types.is_empty() {
                    if let Some(common) = self.find_common_type(&types) {
                        self.resolved_types.insert(var, common);
                        changed = true;
                    }
                }
            }
        }

        changed
    }

    /// Insert MOVE instructions for PHI nodes with incompatible types
    ///
    /// This is the main GAP-1 implementation - adds MOVE before PHI to create
    /// 'soft' type links, allowing different types in blocks merged by PHI.
    ///
    /// JADX Reference: FixTypesVisitor.insertMovesForPhi() lines 593-638
    ///
    /// Algorithm (matching JADX exactly):
    /// 1. For each PHI with incompatible argument types (different known types)
    /// 2. For each source argument:
    ///    - Find valid insertion block via checkBlockForInsnInsert()
    ///    - If ANY block is invalid, abort ALL moves for this PHI (return 0)
    ///    - Skip if assigned by CONST (handled by splitByPhi)
    ///    - Skip if assigned by MOVE with use_count == 1 (redundant)
    /// 3. Insert MOVE instruction at end of block:
    ///    - Create new SSA version: `new_var = old_var`
    ///    - Mark instruction as SYNTHETIC
    /// 4. Update PHI source to use new variable
    ///
    /// Returns the total number of moves inserted across all PHIs.
    pub fn insert_moves_for_phi(&mut self, ssa: &mut SsaResult) -> usize {
        let mut total_inserted = 0;

        // Collect all PHIs that need moves
        // We do this in two phases to avoid borrowing issues
        let phi_info: Vec<(usize, usize)> = ssa.blocks.iter().enumerate()
            .flat_map(|(block_idx, block)| {
                block.phi_nodes.iter().enumerate()
                    .filter(|(_, phi)| !self.phi_has_common_known_type(phi))
                    .map(move |(phi_idx, _)| (block_idx, phi_idx))
            })
            .collect();

        for (phi_block_idx, phi_idx) in phi_info {
            let inserted = self.insert_moves_for_single_phi(ssa, phi_block_idx, phi_idx);
            total_inserted += inserted;
        }

        if total_inserted > 0 {
            tracing::info!(
                "insertMovesForPhi: Inserted {} MOVE instructions for PHI type fixes",
                total_inserted
            );
        }

        total_inserted
    }

    /// Insert moves for a single PHI node
    ///
    /// JADX Reference: FixTypesVisitor.insertMovesForPhi() lines 593-622
    ///
    /// Returns the number of moves inserted (0 if any insertion would fail).
    fn insert_moves_for_single_phi(
        &mut self,
        ssa: &mut SsaResult,
        phi_block_idx: usize,
        phi_idx: usize,
    ) -> usize {
        // Phase 1: Check if all insertions are possible (JADX: apply=false)
        // JADX aborts ALL moves for a PHI if ANY single insertion fails
        let mut moves_to_insert: Vec<PhiMoveInfo> = Vec::new();

        {
            let phi = &ssa.blocks[phi_block_idx].phi_nodes[phi_idx];

            for (src_idx, (pred_block_id, src_reg)) in phi.sources.iter().enumerate() {
                // Find predecessor block index
                let pred_block_idx = match ssa.blocks.iter().position(|b| b.id == *pred_block_id) {
                    Some(idx) => idx,
                    None => continue,
                };

                // JADX: checkBlockForInsnInsert(startBlock)
                // If null, abort ALL moves for this PHI
                let insert_block_idx = match self.check_block_for_insn_insert(ssa, pred_block_idx) {
                    Some(idx) => idx,
                    None => {
                        tracing::debug!(
                            "insertMovesForPhi: Cannot insert in block {} for PHI, aborting all moves",
                            ssa.blocks[pred_block_idx].id
                        );
                        return 0; // Abort ALL moves for this PHI (JADX behavior)
                    }
                };

                // Check if we should skip this argument
                // JADX: Skip CONST and single-use MOVE
                let should_add = self.should_insert_move_for_phi_arg(ssa, src_reg);

                if should_add {
                    moves_to_insert.push(PhiMoveInfo {
                        phi_block_idx,
                        phi_idx,
                        src_idx,
                        insert_block_idx,
                        reg_num: src_reg.reg_num,
                        old_version: src_reg.ssa_version,
                    });
                }
            }
        }

        if moves_to_insert.is_empty() {
            return 0;
        }

        let count = moves_to_insert.len();

        // Phase 2: Apply the moves (JADX: apply=true)
        for info in moves_to_insert {
            self.insert_single_move(ssa, &info);
        }

        count
    }

    /// Check if we should insert a MOVE for this PHI argument
    ///
    /// JADX Reference: FixTypesVisitor.insertMovesForPhi() lines 604-613
    ///
    /// Returns false (skip) if:
    /// - Assigned by CONST instruction (type flexibility handled by splitByPhi)
    /// - Assigned by MOVE with use_count == 1 (redundant)
    fn should_insert_move_for_phi_arg(&self, ssa: &SsaResult, reg: &RegisterArg) -> bool {
        // Find the instruction that assigns this register
        for block in &ssa.blocks {
            for insn in &block.instructions {
                let (is_const, is_move, dest) = match &insn.insn_type {
                    InsnType::Const { dest, .. } => (true, false, Some(dest)),
                    InsnType::ConstString { dest, .. } => (true, false, Some(dest)),
                    InsnType::ConstClass { dest, .. } => (true, false, Some(dest)),
                    InsnType::Move { dest, .. } => (false, true, Some(dest)),
                    _ => (false, false, None),
                };

                if let Some(dest) = dest {
                    if dest.reg_num == reg.reg_num && dest.ssa_version == reg.ssa_version {
                        // Found the assignment instruction
                        if is_const {
                            // JADX: Skip CONST (handled by splitByPhi)
                            return false;
                        }
                        if is_move {
                            // JADX: Skip MOVE with use_count == 1
                            // Check use count in SSA context
                            let var_ref = SSAVarRef::new(reg.reg_num, reg.ssa_version);
                            if let Some(var) = ssa.ssa_context.get_var(var_ref) {
                                if var.use_count() == 1 {
                                    return false;
                                }
                            }
                        }
                        return true;
                    }
                }
            }
        }

        // If we can't find the assignment, default to inserting
        true
    }

    /// Insert a single MOVE instruction for a PHI argument
    ///
    /// JADX Reference: FixTypesVisitor.insertMove() lines 624-638
    fn insert_single_move(&mut self, ssa: &mut SsaResult, info: &PhiMoveInfo) {
        // Create new SSA version
        let new_version = {
            let max_ver = ssa.max_versions.entry(info.reg_num).or_insert(0);
            *max_ver += 1;
            *max_ver
        };

        // Create MOVE instruction: new_version = old_version
        // JADX: InsnNode moveInsn = new InsnNode(InsnType.MOVE, 1);
        //       moveInsn.setResult(resultArg);
        //       moveInsn.addArg(arg);
        //       moveInsn.add(AFlag.SYNTHETIC);
        let mut move_insn = InsnNode::new(
            InsnType::Move {
                dest: RegisterArg::with_ssa(info.reg_num, new_version),
                src: InsnArg::Register(RegisterArg::with_ssa(info.reg_num, info.old_version)),
            },
            0, // offset - synthetic instruction
        );
        move_insn.add_flag(AFlag::Synthetic);

        // JADX: blockNode.getInstructions().add(moveInsn);
        // Add at END of block (JADX behavior)
        ssa.blocks[info.insert_block_idx].instructions.push(move_insn);

        // JADX: phiInsn.replaceArg(reg, reg.duplicate(regNum, newSsaVar));
        // Update PHI source to use new version
        if let Some(phi) = ssa.blocks[info.phi_block_idx].phi_nodes.get_mut(info.phi_idx) {
            if let Some((_, ref mut src_reg)) = phi.sources.get_mut(info.src_idx) {
                src_reg.ssa_version = new_version;
            }
        }

        // Register the new SSA variable in context
        ssa.ssa_context.new_var_with_version(info.reg_num, new_version);

        // Update variable metadata
        let new_var_ref = SSAVarRef::new(info.reg_num, new_version);
        if let Some(var) = ssa.ssa_context.get_var_mut(new_var_ref) {
            // Track assignment instruction (approximate index)
            let insn_count = ssa.blocks[info.insert_block_idx].instructions.len();
            var.assign_insn_idx = Some((insn_count - 1) as u32);
        }

        tracing::debug!(
            "insertMove: r{}#{} -> r{}#{} in block {} for PHI in block {}",
            info.reg_num,
            info.old_version,
            info.reg_num,
            new_version,
            ssa.blocks[info.insert_block_idx].id,
            ssa.blocks[info.phi_block_idx].id
        );
    }

    /// Strategy 8: Remove generics and try raw types
    ///
    /// As a last resort, remove generic parameters and use raw types
    fn try_remove_generics(&mut self, _ssa: &SsaResult) -> bool {
        let mut changed = false;

        for var in self.get_unresolved_vars() {
            if self.immutable_vars.contains(&var) {
                continue;
            }

            if let Some(info) = self.type_info.get(&var) {
                // Find object types with generics or unresolved type variables
                for bound in info.bounds() {
                    if let Some(ty) = bound.get_type() {
                        match ty {
                            ArgType::Generic { base, .. } => {
                                // Use raw type without generics
                                let raw_type = ArgType::Object(base.clone());
                                self.resolved_types.insert(var, raw_type);
                                changed = true;
                                break;
                            }
                            ArgType::Object(_) => {
                                // Already a raw type, use it
                                self.resolved_types.insert(var, ty.clone());
                                changed = true;
                                break;
                            }
                            ArgType::TypeVariable { .. } => {
                                // Unresolved type variable - fall back to Object
                                // This handles cases where type inference couldn't resolve
                                // the type variable (e.g., missing generic context)
                                tracing::debug!(
                                    "Falling back to Object for unresolved TypeVariable: {:?}",
                                    ty
                                );
                                let fallback = ArgType::Object("java/lang/Object".to_string());
                                self.resolved_types.insert(var, fallback);
                                changed = true;
                                break;
                            }
                            _ => {}
                        }
                    }
                }
            }
        }

        changed
    }

    /// Select the best type from bounds for a variable
    fn select_best_type_from_bounds(&self, var: &TypeVar) -> Option<ArgType> {
        let info = self.type_info.get(var)?;
        let bounds = info.bounds();

        if bounds.is_empty() {
            return None;
        }

        // Collect all known types from bounds
        let types: Vec<_> = bounds
            .iter()
            .filter_map(|b| b.get_type())
            .filter(|ty| !matches!(ty, ArgType::Unknown))
            .collect();

        if types.is_empty() {
            return None;
        }

        // Find the "best" (most specific) type
        // Priority: concrete types > generic types > object
        let mut best: Option<&ArgType> = None;

        for ty in &types {
            if best.is_none() {
                best = Some(ty);
                continue;
            }

            let current_best = best.unwrap();

            // Prefer more specific types
            if self.is_more_specific(ty, current_best) {
                best = Some(ty);
            }
        }

        best.cloned()
    }

    /// Check if type A is more specific than type B
    fn is_more_specific(&self, a: &ArgType, b: &ArgType) -> bool {
        // Primitives are more specific than objects
        if a.is_primitive() && !b.is_primitive() {
            return true;
        }

        // Specific objects are more specific than Object
        if let (ArgType::Object(a_name), ArgType::Object(b_name)) = (a, b) {
            if b_name.as_str() == "java/lang/Object" && a_name.as_str() != "java/lang/Object" {
                return true;
            }
        }

        // Generic types are more specific than raw types
        if matches!(a, ArgType::Generic { .. }) && matches!(b, ArgType::Object(_)) {
            return true;
        }

        false
    }

    /// Try possible primitive types for a variable
    fn try_possible_primitives(&mut self, var: &TypeVar) -> bool {
        let info = match self.type_info.get(var) {
            Some(i) => i,
            None => return false,
        };

        // Check if bounds suggest a primitive
        for bound in info.bounds() {
            if let Some(ty) = bound.get_type() {
                if ty.is_primitive() && !matches!(ty, ArgType::Unknown) {
                    self.resolved_types.insert(*var, ty.clone());
                    return true;
                }
            }
        }

        false
    }

    /// Try wider object types (superclasses)
    fn try_wider_objects(&mut self, var: &TypeVar) -> bool {
        let hierarchy = match &self.hierarchy {
            Some(h) => h,
            None => return false,
        };

        let info = match self.type_info.get(var) {
            Some(i) => i,
            None => return false,
        };

        // Collect object types from bounds
        let obj_types: Vec<_> = info
            .bounds()
            .iter()
            .filter_map(|b| b.get_type())
            .filter_map(|ty| {
                if let ArgType::Object(name) = ty {
                    Some(name.to_string())
                } else {
                    None
                }
            })
            .collect();

        // Try superclasses
        for obj_type in &obj_types {
            if let Some(superclass) = hierarchy.get_superclass(obj_type) {
                let super_type = ArgType::Object(superclass.into());
                self.resolved_types.insert(*var, super_type);
                return true;
            }
        }

        false
    }

    /// Find a common type for multiple types
    fn find_common_type(&self, types: &[&ArgType]) -> Option<ArgType> {
        if types.is_empty() {
            return None;
        }

        if types.len() == 1 {
            return Some((*types[0]).clone());
        }

        // Check if all are primitives of the same kind
        let all_numeric = types.iter().all(|t| t.is_primitive() && t.can_be_numeric());
        if all_numeric {
            // Use int as common numeric type
            return Some(ArgType::Int);
        }

        // Check if all are objects
        let all_objects = types.iter().all(|t| t.is_object());
        if all_objects {
            // Try to find LCA with hierarchy
            if let Some(ref hierarchy) = self.hierarchy {
                let obj_names: Vec<_> = types
                    .iter()
                    .filter_map(|t| {
                        if let ArgType::Object(name) = t {
                            Some(name.to_string())
                        } else {
                            None
                        }
                    })
                    .collect();

                if obj_names.len() >= 2 {
                    let lca = hierarchy.least_common_ancestor(&obj_names[0], &obj_names[1]);
                    return Some(ArgType::Object(lca));
                }
            }

            // Fallback to Object
            return Some(ArgType::Object("java/lang/Object".into()));
        }

        None
    }

    /// Get the resolved types after fixing
    pub fn get_resolved_types(&self) -> &FxHashMap<TypeVar, ArgType> {
        &self.resolved_types
    }

    /// Take ownership of resolved types
    pub fn into_resolved_types(self) -> FxHashMap<TypeVar, ArgType> {
        self.resolved_types
    }
}

impl Default for FixTypes {
    fn default() -> Self {
        Self::new()
    }
}

/// Helper trait for ArgType to check if it can be numeric
trait ArgTypeExt {
    fn can_be_numeric(&self) -> bool;
    fn is_object(&self) -> bool;
    fn is_primitive(&self) -> bool;
}

impl ArgTypeExt for ArgType {
    fn can_be_numeric(&self) -> bool {
        matches!(
            self,
            ArgType::Int
                | ArgType::Long
                | ArgType::Float
                | ArgType::Double
                | ArgType::Byte
                | ArgType::Short
                | ArgType::Char
        )
    }

    fn is_object(&self) -> bool {
        matches!(self, ArgType::Object(_) | ArgType::Generic { .. } | ArgType::Array(_))
    }

    fn is_primitive(&self) -> bool {
        matches!(
            self,
            ArgType::Int
                | ArgType::Long
                | ArgType::Float
                | ArgType::Double
                | ArgType::Boolean
                | ArgType::Byte
                | ArgType::Short
                | ArgType::Char
                | ArgType::Void
        )
    }
}

/// Run the fix types pass on type inference result
pub fn fix_types(ssa: &SsaResult, inference_result: &TypeInferenceResult) -> FixTypesResult {
    let mut fixer = FixTypes::new();

    // Convert inference result types to our format
    for ((reg, version), ty) in &inference_result.types {
        let var = TypeVar::new(*version);
        fixer.resolved_types.insert(var, ty.clone());
    }

    fixer.run(ssa)
}

/// Run the fix types pass with full context
pub fn fix_types_with_context(
    ssa: &SsaResult,
    resolved_types: FxHashMap<TypeVar, ArgType>,
    type_info: FxHashMap<TypeVar, TypeInfo>,
    hierarchy: Option<ClassHierarchy>,
) -> FixTypesResult {
    let mut fixer = FixTypes::new()
        .with_resolved_types(resolved_types)
        .with_type_info(type_info);

    if let Some(h) = hierarchy {
        fixer = fixer.with_hierarchy(h);
    }

    fixer.run(ssa)
}

#[cfg(test)]
mod tests {
    use super::*;

    #[test]
    fn test_fix_types_new() {
        let fixer = FixTypes::new();
        assert!(fixer.resolved_types.is_empty());
        assert!(fixer.type_info.is_empty());
        assert_eq!(fixer.strategies.len(), ALL_STRATEGIES.len());
    }

    #[test]
    fn test_strategy_names() {
        assert_eq!(FixStrategy::DeduceTypes.name(), "DeduceTypes");
        assert_eq!(FixStrategy::RemoveGenerics.name(), "RemoveGenerics");
    }

    #[test]
    fn test_check_types_all_resolved() {
        let mut fixer = FixTypes::new();
        fixer.resolved_types.insert(TypeVar::new(0), ArgType::Int);
        fixer.resolved_types.insert(TypeVar::new(1), ArgType::Long);
        assert!(fixer.check_types());
    }

    #[test]
    fn test_check_types_has_unknown() {
        let mut fixer = FixTypes::new();
        fixer.resolved_types.insert(TypeVar::new(0), ArgType::Int);
        fixer.resolved_types.insert(TypeVar::new(1), ArgType::Unknown);
        assert!(!fixer.check_types());
    }

    #[test]
    fn test_count_unresolved() {
        let mut fixer = FixTypes::new();
        fixer.resolved_types.insert(TypeVar::new(0), ArgType::Int);
        fixer.resolved_types.insert(TypeVar::new(1), ArgType::Unknown);
        fixer.resolved_types.insert(TypeVar::new(2), ArgType::Unknown);
        assert_eq!(fixer.count_unresolved(), 2);
    }

    #[test]
    fn test_is_more_specific() {
        let fixer = FixTypes::new();

        // Primitive is more specific than object
        assert!(fixer.is_more_specific(&ArgType::Int, &ArgType::Object("java/lang/Object".into())));

        // Specific object is more specific than Object
        assert!(fixer.is_more_specific(
            &ArgType::Object("java/lang/String".into()),
            &ArgType::Object("java/lang/Object".into())
        ));
    }

    #[test]
    fn test_find_common_type_primitives() {
        let fixer = FixTypes::new();
        let types = vec![&ArgType::Int, &ArgType::Short];
        let common = fixer.find_common_type(&types);
        assert_eq!(common, Some(ArgType::Int));
    }

    #[test]
    fn test_find_common_type_objects() {
        let fixer = FixTypes::new();
        let str_type = ArgType::Object("java/lang/String".into());
        let list_type = ArgType::Object("java/util/List".into());
        let types = vec![&str_type, &list_type];
        let common = fixer.find_common_type(&types);
        // Without hierarchy, falls back to Object
        assert_eq!(common, Some(ArgType::Object("java/lang/Object".into())));
    }

    #[test]
    fn test_arg_type_ext() {
        assert!(ArgType::Int.can_be_numeric());
        assert!(ArgType::Long.can_be_numeric());
        assert!(!ArgType::Boolean.can_be_numeric());

        assert!(ArgType::Object("test".into()).is_object());
        assert!(!ArgType::Int.is_object());

        assert!(ArgType::Int.is_primitive());
        assert!(!ArgType::Object("test".into()).is_primitive());
    }
}
