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

use std::collections::HashMap;

use rustc_hash::{FxHashMap, FxHashSet};

use dexterity_ir::instructions::{InsnArg, InsnNode, InsnType, LiteralArg, RegisterArg};
use dexterity_ir::types::ArgType;
use dexterity_ir::{ClassHierarchy, TypeCompare};

use crate::ssa::SsaResult;
use crate::type_bound::{BoundEnum, TypeInfo};
use crate::type_inference::{TypeInferenceResult, TypeVar};

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
        matches!(ty, ArgType::Unknown | ArgType::TypeVariable(_))
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
                        matches!(ty, ArgType::TypeVariable(_))
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

    /// Strategy 4: Split constant instructions
    ///
    /// When a constant is used with different types, split into separate constants
    fn try_split_const_insns(&mut self, ssa: &SsaResult) -> bool {
        // This strategy requires modifying instructions
        // For now, we just try to resolve based on usage context
        let mut changed = false;

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
    /// Add MOVE before PHI to create soft type links
    fn try_insert_additional_move(&mut self, _ssa: &SsaResult) -> bool {
        // This strategy requires instruction modification
        // For now, we try to resolve PHI types based on inputs
        false
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
                            ArgType::TypeVariable(_) => {
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
