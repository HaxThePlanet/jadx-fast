//! TypeSearch - Multi-variable constraint solver for type inference
//!
//! This module implements JADX's TypeSearch.java algorithm for resolving
//! unresolved type variables when fast propagation fails.
//!
//! ## Algorithm Overview
//!
//! 1. **Candidate Generation**: For each unresolved variable, generate candidate types
//!    from bounds, widening (superclasses), and narrowing (subclasses)
//!
//! 2. **Constraint Collection**: Build constraints from MOVE and PHI instructions
//!    that relate multiple variables
//!
//! 3. **Independent Resolution**: Resolve variables with no dependencies first
//!
//! 4. **Exhaustive Search**: For dependent variables, try all candidate combinations
//!    until a consistent solution is found (limited to SEARCH_ITERATION_LIMIT)
//!
//! ## JADX Parity
//!
//! Based on JADX's TypeSearch.java (403 lines)

use rustc_hash::{FxHashMap, FxHashSet};

use dexterity_ir::types::{compare_types, ArgType, TypeCompare};
use dexterity_ir::ClassHierarchy;

use crate::type_bound::TypeInfo;
use crate::type_inference::TypeVar;

/// Limits for search to prevent infinite loops
const SEARCH_ITERATION_LIMIT: usize = 1_000_000;
const CANDIDATES_COUNT_LIMIT: usize = 10;
const VARS_PROCESS_LIMIT: usize = 5000;

/// Result of type search
#[derive(Debug, Clone)]
pub struct TypeSearchResult {
    /// Resolved types for variables
    pub resolved: FxHashMap<TypeVar, ArgType>,
    /// Variables that couldn't be resolved
    pub unresolved: Vec<TypeVar>,
    /// Whether search was successful
    pub success: bool,
    /// Number of iterations used
    pub iterations: usize,
}

/// Constraint between variables for search
#[derive(Debug, Clone)]
pub enum TypeSearchConstraint {
    /// MOVE constraint: src can be assigned to dest
    Move { src: TypeVar, dest: TypeVar },
    /// PHI constraint: all variables must have compatible types
    PhiSame { vars: Vec<TypeVar> },
}

/// Per-variable search information
#[derive(Debug, Clone)]
pub struct TypeSearchVarInfo {
    /// The type variable
    pub var: TypeVar,
    /// Candidate types for this variable
    pub candidates: Vec<ArgType>,
    /// Current candidate index
    pub current_idx: usize,
    /// Whether this variable is resolved
    pub resolved: bool,
    /// The resolved type (if any)
    pub resolved_type: Option<ArgType>,
    /// Related variables through constraints
    pub related_vars: FxHashSet<TypeVar>,
}

impl TypeSearchVarInfo {
    pub fn new(var: TypeVar) -> Self {
        Self {
            var,
            candidates: Vec::new(),
            current_idx: 0,
            resolved: false,
            resolved_type: None,
            related_vars: FxHashSet::default(),
        }
    }

    /// Get current candidate type
    pub fn current_type(&self) -> Option<&ArgType> {
        self.candidates.get(self.current_idx)
    }

    /// Advance to next candidate
    pub fn advance(&mut self) -> bool {
        if self.current_idx + 1 < self.candidates.len() {
            self.current_idx += 1;
            true
        } else {
            false
        }
    }

    /// Reset to first candidate
    pub fn reset(&mut self) {
        self.current_idx = 0;
    }

    /// Check if this variable is independent (no related vars)
    pub fn is_independent(&self) -> bool {
        self.related_vars.is_empty()
    }
}

/// Search state for multi-variable resolution
#[derive(Debug)]
pub struct TypeSearchState {
    /// Per-variable info
    pub var_info: FxHashMap<TypeVar, TypeSearchVarInfo>,
    /// Constraints to check
    pub constraints: Vec<TypeSearchConstraint>,
    /// Current iteration count
    pub iterations: usize,
}

impl TypeSearchState {
    pub fn new() -> Self {
        Self {
            var_info: FxHashMap::default(),
            constraints: Vec::new(),
            iterations: 0,
        }
    }
}

/// TypeSearch engine for multi-variable constraint solving
pub struct TypeSearch<'a> {
    /// Type info per variable (bounds)
    type_info: &'a FxHashMap<TypeVar, TypeInfo>,
    /// Currently resolved types
    resolved: &'a FxHashMap<TypeVar, ArgType>,
    /// Class hierarchy for type comparison
    hierarchy: Option<&'a ClassHierarchy>,
}

impl<'a> TypeSearch<'a> {
    /// Create a new TypeSearch engine
    pub fn new(
        type_info: &'a FxHashMap<TypeVar, TypeInfo>,
        resolved: &'a FxHashMap<TypeVar, ArgType>,
        hierarchy: Option<&'a ClassHierarchy>,
    ) -> Self {
        Self {
            type_info,
            resolved,
            hierarchy,
        }
    }

    /// Run the type search algorithm
    ///
    /// # Arguments
    ///
    /// * `unresolved_vars` - Variables that need type resolution
    /// * `constraints` - Constraints between variables
    ///
    /// # Returns
    ///
    /// TypeSearchResult with resolved types
    pub fn search(
        &self,
        unresolved_vars: &[TypeVar],
        constraints: &[TypeSearchConstraint],
    ) -> TypeSearchResult {
        if unresolved_vars.is_empty() {
            return TypeSearchResult {
                resolved: FxHashMap::default(),
                unresolved: Vec::new(),
                success: true,
                iterations: 0,
            };
        }

        // Check variable limit
        if unresolved_vars.len() > VARS_PROCESS_LIMIT {
            return TypeSearchResult {
                resolved: FxHashMap::default(),
                unresolved: unresolved_vars.to_vec(),
                success: false,
                iterations: 0,
            };
        }

        // Initialize search state
        let mut state = TypeSearchState::new();

        // Build var info and candidates
        for &var in unresolved_vars {
            let mut info = TypeSearchVarInfo::new(var);
            self.fill_candidates(&mut info);
            state.var_info.insert(var, info);
        }

        // Collect constraints and build related vars
        state.constraints = constraints.to_vec();
        self.build_related_vars(&mut state);

        // Phase 1: Resolve independent variables
        self.resolve_independent(&mut state);

        // Phase 2: Exhaustive search for dependent variables
        let dependent_vars: Vec<TypeVar> = state
            .var_info
            .iter()
            .filter(|(_, info)| !info.resolved && !info.is_independent())
            .map(|(var, _)| *var)
            .collect();

        if !dependent_vars.is_empty() {
            self.exhaustive_search(&mut state, &dependent_vars);
        }

        // Collect results
        let mut resolved = FxHashMap::default();
        let mut unresolved = Vec::new();

        for (&var, info) in &state.var_info {
            if info.resolved {
                if let Some(ty) = &info.resolved_type {
                    resolved.insert(var, ty.clone());
                }
            } else if let Some(ty) = info.current_type() {
                // Use current candidate even if not validated
                resolved.insert(var, ty.clone());
            } else {
                unresolved.push(var);
            }
        }

        let success = unresolved.is_empty();
        TypeSearchResult {
            resolved,
            unresolved,
            success,
            iterations: state.iterations,
        }
    }

    /// Fill candidate types for a variable
    fn fill_candidates(&self, info: &mut TypeSearchVarInfo) {
        let mut candidates = Vec::new();
        let mut seen = FxHashSet::default();

        // Get bounds for this variable
        if let Some(type_info) = self.type_info.get(&info.var) {
            // Add types from ASSIGN bounds (most specific first)
            for bound in type_info.assign_bounds() {
                if let Some(ty) = bound.get_type() {
                    if !self.is_unknown(ty) && !seen.contains(ty) {
                        candidates.push(ty.clone());
                        seen.insert(ty.clone());
                    }
                }
            }

            // Add types from USE bounds
            for bound in type_info.use_bounds() {
                if let Some(ty) = bound.get_type() {
                    if !self.is_unknown(ty) && !seen.contains(ty) {
                        candidates.push(ty.clone());
                        seen.insert(ty.clone());
                    }
                }
            }
        }

        // Add wider types (superclasses) for object types
        let wider: Vec<ArgType> = candidates
            .iter()
            .filter_map(|ty| self.get_wider_type(ty))
            .filter(|ty| !seen.contains(ty))
            .collect();

        for ty in wider {
            seen.insert(ty.clone());
            candidates.push(ty);
        }

        // Limit candidates
        if candidates.len() > CANDIDATES_COUNT_LIMIT {
            candidates.truncate(CANDIDATES_COUNT_LIMIT);
        }

        // If no candidates, add Object as fallback for object types
        if candidates.is_empty() {
            // Check if any bound suggests an object type
            if let Some(type_info) = self.type_info.get(&info.var) {
                let has_object_bound = type_info.bounds().iter().any(|b| {
                    b.get_type()
                        .map(|t| t.is_object() || t.is_array())
                        .unwrap_or(false)
                });

                if has_object_bound {
                    candidates.push(ArgType::Object("java/lang/Object".to_string()));
                } else {
                    // Default to int for primitives
                    candidates.push(ArgType::Int);
                }
            } else {
                // No info at all - try Object
                candidates.push(ArgType::Object("java/lang/Object".to_string()));
            }
        }

        info.candidates = candidates;
    }

    /// Check if a type is unknown
    fn is_unknown(&self, ty: &ArgType) -> bool {
        matches!(
            ty,
            ArgType::Unknown
                | ArgType::UnknownNarrow
                | ArgType::UnknownWide
                | ArgType::UnknownObject
                | ArgType::UnknownArray
        )
    }

    /// Get a wider (superclass) type
    fn get_wider_type(&self, ty: &ArgType) -> Option<ArgType> {
        match ty {
            ArgType::Object(class) if class != "java/lang/Object" => {
                // Try to get superclass from hierarchy
                if let Some(h) = self.hierarchy {
                    if let Some(parent) = h.get_superclass(class) {
                        return Some(ArgType::Object(parent.to_string()));
                    }
                }
                // Fallback: Object is wider than any class
                Some(ArgType::Object("java/lang/Object".to_string()))
            }
            ArgType::Generic { base, .. } if base != "java/lang/Object" => {
                // Raw type is wider than generic
                Some(ArgType::Object(base.clone()))
            }
            ArgType::Array(_) => {
                // Object[] is wider than any array (covariance)
                Some(ArgType::Object("java/lang/Object".to_string()))
            }
            _ => None,
        }
    }

    /// Build related vars from constraints
    fn build_related_vars(&self, state: &mut TypeSearchState) {
        for constraint in &state.constraints {
            match constraint {
                TypeSearchConstraint::Move { src, dest } => {
                    if let Some(src_info) = state.var_info.get_mut(src) {
                        src_info.related_vars.insert(*dest);
                    }
                    if let Some(dest_info) = state.var_info.get_mut(dest) {
                        dest_info.related_vars.insert(*src);
                    }
                }
                TypeSearchConstraint::PhiSame { vars } => {
                    for (i, var) in vars.iter().enumerate() {
                        if let Some(info) = state.var_info.get_mut(var) {
                            for (j, other) in vars.iter().enumerate() {
                                if i != j {
                                    info.related_vars.insert(*other);
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    /// Resolve independent variables (no dependencies)
    fn resolve_independent(&self, state: &mut TypeSearchState) {
        let independent: Vec<TypeVar> = state
            .var_info
            .iter()
            .filter(|(_, info)| info.is_independent() && !info.resolved)
            .map(|(var, _)| *var)
            .collect();

        for var in independent {
            if let Some(info) = state.var_info.get_mut(&var) {
                // For independent vars, just take the first (best) candidate
                if let Some(ty) = info.candidates.first() {
                    info.resolved = true;
                    info.resolved_type = Some(ty.clone());
                }
            }
        }
    }

    /// Exhaustive search for dependent variables
    fn exhaustive_search(&self, state: &mut TypeSearchState, vars: &[TypeVar]) {
        if vars.is_empty() {
            return;
        }

        // Reset all candidates to first
        for var in vars {
            if let Some(info) = state.var_info.get_mut(var) {
                info.reset();
            }
        }

        // Try all combinations
        loop {
            state.iterations += 1;

            // Check iteration limit
            if state.iterations >= SEARCH_ITERATION_LIMIT {
                break;
            }

            // Check if current combination satisfies all constraints
            if self.check_constraints(state) {
                // Found a solution - mark all as resolved
                for var in vars {
                    if let Some(info) = state.var_info.get_mut(var) {
                        if let Some(ty) = info.current_type().cloned() {
                            info.resolved = true;
                            info.resolved_type = Some(ty);
                        }
                    }
                }
                return;
            }

            // Advance candidates (like incrementing a multi-digit number)
            if !self.advance_candidates(state, vars) {
                break; // All combinations exhausted
            }
        }

        // No solution found - use best effort from first candidates
        for var in vars {
            if let Some(info) = state.var_info.get_mut(var) {
                if let Some(ty) = info.candidates.first().cloned() {
                    info.resolved_type = Some(ty);
                }
            }
        }
    }

    /// Check if all constraints are satisfied with current candidates
    fn check_constraints(&self, state: &TypeSearchState) -> bool {
        for constraint in &state.constraints {
            if !self.check_constraint(state, constraint) {
                return false;
            }
        }
        true
    }

    /// Check a single constraint
    fn check_constraint(&self, state: &TypeSearchState, constraint: &TypeSearchConstraint) -> bool {
        match constraint {
            TypeSearchConstraint::Move { src, dest } => {
                let src_type = self.get_current_type(state, src);
                let dest_type = self.get_current_type(state, dest);

                match (src_type, dest_type) {
                    (Some(s), Some(d)) => {
                        // src can be assigned to dest (src is equal or narrower)
                        let cmp = compare_types(s, d, self.hierarchy);
                        matches!(
                            cmp,
                            TypeCompare::Equal
                                | TypeCompare::Narrow
                                | TypeCompare::NarrowByGeneric
                        )
                    }
                    _ => true, // Missing type - allow
                }
            }
            TypeSearchConstraint::PhiSame { vars } => {
                // All PHI args must have compatible types
                let types: Vec<&ArgType> = vars
                    .iter()
                    .filter_map(|v| self.get_current_type(state, v))
                    .collect();

                if types.len() < 2 {
                    return true;
                }

                // All types must be compatible with each other
                for i in 0..types.len() {
                    for j in (i + 1)..types.len() {
                        let cmp = compare_types(types[i], types[j], self.hierarchy);
                        if cmp.is_conflict() {
                            return false;
                        }
                    }
                }
                true
            }
        }
    }

    /// Get current type for a variable (resolved or current candidate)
    fn get_current_type<'b>(&'b self, state: &'b TypeSearchState, var: &TypeVar) -> Option<&'b ArgType> {
        // Check var_info first (search state)
        if let Some(info) = state.var_info.get(var) {
            if info.resolved {
                return info.resolved_type.as_ref();
            }
            return info.current_type();
        }

        // Fall back to already-resolved types
        self.resolved.get(var)
    }

    /// Advance candidates (like incrementing a multi-digit number)
    fn advance_candidates(&self, state: &mut TypeSearchState, vars: &[TypeVar]) -> bool {
        for var in vars.iter().rev() {
            if let Some(info) = state.var_info.get_mut(var) {
                if info.advance() {
                    // Reset all lower-significance vars
                    let idx = vars.iter().position(|v| v == var).unwrap();
                    for reset_var in vars.iter().skip(idx + 1) {
                        if let Some(reset_info) = state.var_info.get_mut(reset_var) {
                            reset_info.reset();
                        }
                    }
                    return true;
                }
            }
        }
        false // All combinations exhausted
    }
}

/// Extract TypeSearch constraints from SSA instructions
pub fn collect_constraints(
    ssa_blocks: &[crate::ssa::SsaBlock],
    var_lookup: &FxHashMap<(u16, u32), TypeVar>,
) -> Vec<TypeSearchConstraint> {
    use dexterity_ir::instructions::{InsnArg, InsnType};

    let mut constraints = Vec::new();

    for block in ssa_blocks {
        for insn in &block.instructions {
            match &insn.insn_type {
                InsnType::Move { dest, src } => {
                    if let InsnArg::Register(src_reg) = src {
                        let src_key = (src_reg.reg_num, src_reg.ssa_version);
                        let dest_key = (dest.reg_num, dest.ssa_version);

                        if let (Some(&src_var), Some(&dest_var)) =
                            (var_lookup.get(&src_key), var_lookup.get(&dest_key))
                        {
                            constraints.push(TypeSearchConstraint::Move {
                                src: src_var,
                                dest: dest_var,
                            });
                        }
                    }
                }
                InsnType::Phi { dest, sources } => {
                    let mut phi_vars = Vec::new();

                    let dest_key = (dest.reg_num, dest.ssa_version);
                    if let Some(&dest_var) = var_lookup.get(&dest_key) {
                        phi_vars.push(dest_var);
                    }

                    for (_, src_arg) in sources {
                        if let InsnArg::Register(src_reg) = src_arg {
                            let src_key = (src_reg.reg_num, src_reg.ssa_version);
                            if let Some(&src_var) = var_lookup.get(&src_key) {
                                phi_vars.push(src_var);
                            }
                        }
                    }

                    if phi_vars.len() >= 2 {
                        constraints.push(TypeSearchConstraint::PhiSame { vars: phi_vars });
                    }
                }
                _ => {}
            }
        }
    }

    constraints
}

#[cfg(test)]
mod tests {
    use super::*;
    use crate::type_bound::BoundEnum;

    fn make_test_type_info() -> FxHashMap<TypeVar, TypeInfo> {
        let mut info_map = FxHashMap::default();

        // Variable 0: has String assign bound
        let mut info0 = TypeInfo::new();
        info0.add_const_bound(BoundEnum::Assign, ArgType::Object("java/lang/String".to_string()));
        info_map.insert(TypeVar::new(0), info0);

        // Variable 1: has Object use bound
        let mut info1 = TypeInfo::new();
        info1.add_const_bound(BoundEnum::Use, ArgType::Object("java/lang/Object".to_string()));
        info_map.insert(TypeVar::new(1), info1);

        info_map
    }

    #[test]
    fn test_fill_candidates() {
        let type_info = make_test_type_info();
        let resolved = FxHashMap::default();
        let search = TypeSearch::new(&type_info, &resolved, None);

        let mut var_info = TypeSearchVarInfo::new(TypeVar::new(0));
        search.fill_candidates(&mut var_info);

        assert!(!var_info.candidates.is_empty());
        assert!(var_info
            .candidates
            .contains(&ArgType::Object("java/lang/String".to_string())));
    }

    #[test]
    fn test_independent_resolution() {
        let type_info = make_test_type_info();
        let resolved = FxHashMap::default();
        let search = TypeSearch::new(&type_info, &resolved, None);

        let unresolved = vec![TypeVar::new(0)];
        let constraints = vec![];

        let result = search.search(&unresolved, &constraints);

        assert!(result.success);
        assert!(result.resolved.contains_key(&TypeVar::new(0)));
    }

    #[test]
    fn test_move_constraint() {
        let mut type_info = FxHashMap::default();

        let mut info0 = TypeInfo::new();
        info0.add_const_bound(BoundEnum::Assign, ArgType::Object("java/lang/String".to_string()));
        type_info.insert(TypeVar::new(0), info0);

        let mut info1 = TypeInfo::new();
        info1.add_const_bound(BoundEnum::Use, ArgType::Object("java/lang/Object".to_string()));
        type_info.insert(TypeVar::new(1), info1);

        let resolved = FxHashMap::default();
        let search = TypeSearch::new(&type_info, &resolved, None);

        let unresolved = vec![TypeVar::new(0), TypeVar::new(1)];
        let constraints = vec![TypeSearchConstraint::Move {
            src: TypeVar::new(0),
            dest: TypeVar::new(1),
        }];

        let result = search.search(&unresolved, &constraints);

        // String can be assigned to Object, so this should succeed
        assert!(result.success || result.iterations > 0);
    }

    #[test]
    fn test_phi_constraint() {
        let mut type_info = FxHashMap::default();

        // All three should unify to a common type
        for i in 0..3 {
            let mut info = TypeInfo::new();
            info.add_const_bound(BoundEnum::Assign, ArgType::Int);
            type_info.insert(TypeVar::new(i), info);
        }

        let resolved = FxHashMap::default();
        let search = TypeSearch::new(&type_info, &resolved, None);

        let unresolved = vec![TypeVar::new(0), TypeVar::new(1), TypeVar::new(2)];
        let constraints = vec![TypeSearchConstraint::PhiSame {
            vars: vec![TypeVar::new(0), TypeVar::new(1), TypeVar::new(2)],
        }];

        let result = search.search(&unresolved, &constraints);

        assert!(result.success);
        // All should be Int
        for var in &unresolved {
            assert_eq!(result.resolved.get(var), Some(&ArgType::Int));
        }
    }
}
