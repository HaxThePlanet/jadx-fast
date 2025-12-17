//! Type bounds for type inference
//!
//! This module implements JADX's ITypeBound interface system for sophisticated
//! type inference. Type bounds are constraints on what types a variable can have.
//!
//! ## Bound Types
//!
//! - `Assign` bounds: From the LHS of assignment - what type can be assigned TO
//! - `Use` bounds: From usage context - what type is being used AS
//!
//! This distinction is critical for correct type inference:
//! - AssignBound(String) means "this variable receives a String"
//! - UseBound(CharSequence) means "this variable is used as CharSequence"
//!
//! The combination allows inferring that the variable is String (narrowest that satisfies both).

use std::fmt;

use dexterity_ir::instructions::RegisterArg;
use dexterity_ir::types::ArgType;
use dexterity_ir::ClassHierarchy;

use crate::type_inference::TypeVar;

/// Enum distinguishing assignment vs usage contexts (mirrors JADX's BoundEnum)
#[derive(Debug, Clone, Copy, PartialEq, Eq, Hash)]
pub enum BoundEnum {
    /// Variable receives this type (LHS of assignment)
    /// More permissive - can accept any subtype of the bound
    Assign,
    /// Variable is used as this type (RHS/argument)
    /// More restrictive - variable must be this type or subtype
    Use,
}

impl fmt::Display for BoundEnum {
    fn fmt(&self, f: &mut fmt::Formatter<'_>) -> fmt::Result {
        match self {
            BoundEnum::Assign => write!(f, "ASSIGN"),
            BoundEnum::Use => write!(f, "USE"),
        }
    }
}

/// Type bound interface (mirrors JADX's ITypeBound)
///
/// Type bounds represent constraints on what types a variable can have.
/// Different bound types have different semantics:
///
/// - Constant bounds always return the same type
/// - Dynamic bounds compute type based on context (e.g., generic type resolution)
pub trait TypeBound: fmt::Debug + Send + Sync {
    /// Get the bound kind (Assign or Use)
    fn bound_kind(&self) -> BoundEnum;

    /// Get the type for this bound
    /// Returns None if type cannot be determined yet
    fn get_type(&self) -> Option<&ArgType>;

    /// Get the associated register argument (if any)
    fn get_arg(&self) -> Option<&RegisterArg> {
        None
    }

    /// Check if this is a dynamic bound that can change based on context
    fn is_dynamic(&self) -> bool {
        false
    }

    /// Clone this bound into a boxed trait object
    fn clone_box(&self) -> Box<dyn TypeBound>;

    /// Check equality with another bound
    fn eq_bound(&self, other: &dyn TypeBound) -> bool;
}

/// Context for dynamic type bound resolution
#[derive(Debug)]
pub struct TypeUpdateContext<'a> {
    /// Current resolved types for type variables
    pub resolved_types: &'a std::collections::HashMap<TypeVar, ArgType>,
    /// Class hierarchy for type comparison
    pub hierarchy: Option<&'a ClassHierarchy>,
}

/// Dynamic type bound that can compute type based on context
pub trait TypeBoundDynamic: TypeBound {
    /// Get type with context information for dynamic resolution
    fn get_type_with_context(&self, ctx: &TypeUpdateContext<'_>) -> Option<ArgType>;
}

// ============================================================================
// TypeBoundConst - Simple constant type bound (JADX's TypeBoundConst)
// ============================================================================

/// Constant type bound (mirrors JADX's TypeBoundConst)
///
/// This is the most common bound type - a simple type constraint.
#[derive(Debug, Clone)]
pub struct TypeBoundConst {
    pub bound: BoundEnum,
    pub arg_type: ArgType,
    pub arg: Option<RegisterArg>,
}

impl TypeBoundConst {
    /// Create a new constant type bound
    pub fn new(bound: BoundEnum, arg_type: ArgType) -> Self {
        Self {
            bound,
            arg_type,
            arg: None,
        }
    }

    /// Create a new constant type bound with associated register
    pub fn with_arg(bound: BoundEnum, arg_type: ArgType, arg: RegisterArg) -> Self {
        Self {
            bound,
            arg_type,
            arg: Some(arg),
        }
    }

    /// Create an assign bound
    pub fn assign(arg_type: ArgType) -> Self {
        Self::new(BoundEnum::Assign, arg_type)
    }

    /// Create a use bound
    pub fn use_bound(arg_type: ArgType) -> Self {
        Self::new(BoundEnum::Use, arg_type)
    }
}

impl TypeBound for TypeBoundConst {
    fn bound_kind(&self) -> BoundEnum {
        self.bound
    }

    fn get_type(&self) -> Option<&ArgType> {
        Some(&self.arg_type)
    }

    fn get_arg(&self) -> Option<&RegisterArg> {
        self.arg.as_ref()
    }

    fn clone_box(&self) -> Box<dyn TypeBound> {
        Box::new(self.clone())
    }

    fn eq_bound(&self, other: &dyn TypeBound) -> bool {
        if let Some(other_const) = other.get_type() {
            self.bound == other.bound_kind() && &self.arg_type == other_const
        } else {
            false
        }
    }
}

impl fmt::Display for TypeBoundConst {
    fn fmt(&self, f: &mut fmt::Formatter<'_>) -> fmt::Result {
        write!(f, "{{{}: {:?}}}", self.bound, self.arg_type)
    }
}

// ============================================================================
// TypeBoundInvokeAssign - Dynamic bound for invoke return types with generics
// (JADX's TypeBoundInvokeAssign)
// ============================================================================

/// Dynamic bound for invoke return types with generics
///
/// This bound resolves generic return types based on the instance type.
/// For example, if we have `List<String>.get(int)`, the return type `E`
/// is resolved to `String` based on the instance type `List<String>`.
#[derive(Debug, Clone)]
pub struct TypeBoundInvokeAssign {
    /// Method index in DEX
    pub method_idx: u32,
    /// Generic return type (may contain TypeVariable)
    pub generic_return_type: ArgType,
    /// Instance argument register (for resolving TypeVariables)
    pub instance_reg: u16,
    pub instance_ssa: u32,
    /// Cached resolved type (for non-dynamic access)
    cached_type: Option<ArgType>,
}

impl TypeBoundInvokeAssign {
    pub fn new(
        method_idx: u32,
        generic_return_type: ArgType,
        instance_reg: u16,
        instance_ssa: u32,
    ) -> Self {
        Self {
            method_idx,
            generic_return_type,
            instance_reg,
            instance_ssa,
            cached_type: None,
        }
    }

    /// Resolve TypeVariable in return type based on instance type
    fn resolve_return_type(&self, instance_type: &ArgType) -> ArgType {
        match (&self.generic_return_type, instance_type) {
            // If return type is a TypeVariable and instance has Generic params, resolve
            (ArgType::TypeVariable(var_name), ArgType::Generic { params, .. })
                if !params.is_empty() =>
            {
                // Common single-letter type variables
                match var_name.as_str() {
                    // First type parameter (List<E>, Optional<T>, Set<E>, etc.)
                    "E" | "T" | "R" => params.first().cloned().unwrap_or(self.generic_return_type.clone()),
                    // Second type parameter (Map<K,V>)
                    "V" if params.len() >= 2 => {
                        params.get(1).cloned().unwrap_or(self.generic_return_type.clone())
                    }
                    // First type parameter (Map<K,V>)
                    "K" => params.first().cloned().unwrap_or(self.generic_return_type.clone()),
                    // Unknown variable name - use first param as fallback
                    _ => params.first().cloned().unwrap_or(self.generic_return_type.clone()),
                }
            }
            // For Generic return types, recursively resolve type params
            (ArgType::Generic { base, params: ret_params }, instance_ty) => {
                let resolved_params: Vec<ArgType> = ret_params
                    .iter()
                    .map(|p| {
                        if let ArgType::TypeVariable(_) = p {
                            self.resolve_single_type_var(p, instance_ty)
                        } else {
                            p.clone()
                        }
                    })
                    .collect();
                ArgType::Generic {
                    base: base.clone(),
                    params: resolved_params,
                }
            }
            // For Array return types, resolve element type
            (ArgType::Array(elem), instance_ty) => {
                let resolved_elem = self.resolve_single_type_var(elem, instance_ty);
                ArgType::Array(Box::new(resolved_elem))
            }
            // No resolution possible - return as-is
            _ => self.generic_return_type.clone(),
        }
    }

    fn resolve_single_type_var(&self, type_var: &ArgType, instance_type: &ArgType) -> ArgType {
        if let (ArgType::TypeVariable(var_name), ArgType::Generic { params, .. }) =
            (type_var, instance_type)
        {
            if !params.is_empty() {
                return match var_name.as_str() {
                    "E" | "T" | "R" => params.first().cloned().unwrap_or(type_var.clone()),
                    "V" if params.len() >= 2 => params.get(1).cloned().unwrap_or(type_var.clone()),
                    "K" => params.first().cloned().unwrap_or(type_var.clone()),
                    _ => params.first().cloned().unwrap_or(type_var.clone()),
                };
            }
        }
        type_var.clone()
    }
}

impl TypeBound for TypeBoundInvokeAssign {
    fn bound_kind(&self) -> BoundEnum {
        BoundEnum::Assign
    }

    fn get_type(&self) -> Option<&ArgType> {
        self.cached_type.as_ref().or(Some(&self.generic_return_type))
    }

    fn is_dynamic(&self) -> bool {
        true
    }

    fn clone_box(&self) -> Box<dyn TypeBound> {
        Box::new(self.clone())
    }

    fn eq_bound(&self, other: &dyn TypeBound) -> bool {
        // Dynamic bounds are unique per method call
        false
    }
}

impl TypeBoundDynamic for TypeBoundInvokeAssign {
    fn get_type_with_context(&self, ctx: &TypeUpdateContext<'_>) -> Option<ArgType> {
        // Look up the instance type
        let instance_var = TypeVar::new(self.instance_ssa);
        if let Some(instance_type) = ctx.resolved_types.get(&instance_var) {
            Some(self.resolve_return_type(instance_type))
        } else {
            Some(self.generic_return_type.clone())
        }
    }
}

// ============================================================================
// TypeBoundInvokeUse - Dynamic bound for invoke argument types
// (JADX's TypeBoundInvokeUse)
// ============================================================================

/// Dynamic bound for invoke argument types with generics
///
/// This bound constrains argument types based on the method signature
/// and instance type generics.
#[derive(Debug, Clone)]
pub struct TypeBoundInvokeUse {
    /// Method index in DEX
    pub method_idx: u32,
    /// Argument index (0-based, excluding instance for instance methods)
    pub arg_idx: usize,
    /// Generic argument type from method signature
    pub generic_arg_type: ArgType,
    /// Instance register (for resolving TypeVariables)
    pub instance_reg: Option<(u16, u32)>,
}

impl TypeBoundInvokeUse {
    pub fn new(
        method_idx: u32,
        arg_idx: usize,
        generic_arg_type: ArgType,
        instance_reg: Option<(u16, u32)>,
    ) -> Self {
        Self {
            method_idx,
            arg_idx,
            generic_arg_type,
            instance_reg,
        }
    }
}

impl TypeBound for TypeBoundInvokeUse {
    fn bound_kind(&self) -> BoundEnum {
        BoundEnum::Use
    }

    fn get_type(&self) -> Option<&ArgType> {
        Some(&self.generic_arg_type)
    }

    fn is_dynamic(&self) -> bool {
        // Only dynamic if we have generic type variables to resolve
        matches!(self.generic_arg_type, ArgType::TypeVariable(_))
            || matches!(&self.generic_arg_type, ArgType::Generic { params, .. } if params.iter().any(|p| matches!(p, ArgType::TypeVariable(_))))
    }

    fn clone_box(&self) -> Box<dyn TypeBound> {
        Box::new(self.clone())
    }

    fn eq_bound(&self, other: &dyn TypeBound) -> bool {
        false // Dynamic bounds are unique
    }
}

impl TypeBoundDynamic for TypeBoundInvokeUse {
    fn get_type_with_context(&self, ctx: &TypeUpdateContext<'_>) -> Option<ArgType> {
        // If we have an instance register, try to resolve type variables
        if let Some((reg, ssa)) = self.instance_reg {
            let instance_var = TypeVar::new(ssa);
            if let Some(instance_type) = ctx.resolved_types.get(&instance_var) {
                // Resolve type variables in the argument type
                if let ArgType::TypeVariable(var_name) = &self.generic_arg_type {
                    if let ArgType::Generic { params, .. } = instance_type {
                        return match var_name.as_str() {
                            "E" | "T" | "R" => params.first().cloned(),
                            "V" if params.len() >= 2 => params.get(1).cloned(),
                            "K" => params.first().cloned(),
                            _ => params.first().cloned(),
                        };
                    }
                }
            }
        }
        Some(self.generic_arg_type.clone())
    }
}

// ============================================================================
// TypeBoundFieldGetAssign - Dynamic bound for field access with generics
// (JADX's TypeBoundFieldGetAssign)
// ============================================================================

/// Dynamic bound for field access with generic types
///
/// This handles cases like `list.items` where `items` is `List<T>` and we need
/// to resolve `T` from the instance type.
#[derive(Debug, Clone)]
pub struct TypeBoundFieldGetAssign {
    /// Field index in DEX
    pub field_idx: u32,
    /// Initial type from field declaration (may contain TypeVariable)
    pub init_type: ArgType,
    /// Instance register for generic resolution
    pub instance_reg: Option<(u16, u32)>,
}

impl TypeBoundFieldGetAssign {
    pub fn new(field_idx: u32, init_type: ArgType, instance_reg: Option<(u16, u32)>) -> Self {
        Self {
            field_idx,
            init_type,
            instance_reg,
        }
    }
}

impl TypeBound for TypeBoundFieldGetAssign {
    fn bound_kind(&self) -> BoundEnum {
        BoundEnum::Assign
    }

    fn get_type(&self) -> Option<&ArgType> {
        Some(&self.init_type)
    }

    fn is_dynamic(&self) -> bool {
        matches!(self.init_type, ArgType::TypeVariable(_))
    }

    fn clone_box(&self) -> Box<dyn TypeBound> {
        Box::new(self.clone())
    }

    fn eq_bound(&self, other: &dyn TypeBound) -> bool {
        false
    }
}

impl TypeBoundDynamic for TypeBoundFieldGetAssign {
    fn get_type_with_context(&self, ctx: &TypeUpdateContext<'_>) -> Option<ArgType> {
        if let Some((reg, ssa)) = self.instance_reg {
            let instance_var = TypeVar::new(ssa);
            if let Some(instance_type) = ctx.resolved_types.get(&instance_var) {
                if let ArgType::TypeVariable(var_name) = &self.init_type {
                    if let ArgType::Generic { params, .. } = instance_type {
                        return match var_name.as_str() {
                            "E" | "T" | "R" => params.first().cloned(),
                            "V" if params.len() >= 2 => params.get(1).cloned(),
                            "K" => params.first().cloned(),
                            _ => params.first().cloned(),
                        };
                    }
                }
            }
        }
        Some(self.init_type.clone())
    }
}

// ============================================================================
// TypeBoundCheckCastAssign - Bound for CHECK_CAST instructions
// (JADX's TypeBoundCheckCastAssign)
// ============================================================================

/// Bound for CHECK_CAST instructions
///
/// CHECK_CAST can be "soft" (compiler-inserted without explicit source cast) or
/// "hard" (from explicit source cast). Soft casts may be ignored during inference.
#[derive(Debug, Clone)]
pub struct TypeBoundCheckCastAssign {
    /// Target type of the cast
    pub cast_type: ArgType,
    /// Whether this is a soft cast (compiler-inserted)
    pub soft_cast: bool,
}

impl TypeBoundCheckCastAssign {
    pub fn new(cast_type: ArgType, soft_cast: bool) -> Self {
        Self { cast_type, soft_cast }
    }

    pub fn hard(cast_type: ArgType) -> Self {
        Self::new(cast_type, false)
    }

    pub fn soft(cast_type: ArgType) -> Self {
        Self::new(cast_type, true)
    }
}

impl TypeBound for TypeBoundCheckCastAssign {
    fn bound_kind(&self) -> BoundEnum {
        BoundEnum::Assign
    }

    fn get_type(&self) -> Option<&ArgType> {
        Some(&self.cast_type)
    }

    fn clone_box(&self) -> Box<dyn TypeBound> {
        Box::new(self.clone())
    }

    fn eq_bound(&self, other: &dyn TypeBound) -> bool {
        if let Some(other_type) = other.get_type() {
            &self.cast_type == other_type && self.bound_kind() == other.bound_kind()
        } else {
            false
        }
    }
}

// ============================================================================
// TypeInfo - Per-variable type information (JADX's TypeInfo)
// ============================================================================

/// Type information for a single SSA variable
///
/// Collects all type bounds and tracks the resolved type.
#[derive(Debug, Default)]
pub struct TypeInfo {
    /// Collected type bounds
    bounds: Vec<Box<dyn TypeBound>>,
    /// Resolved/inferred type
    resolved_type: Option<ArgType>,
    /// Whether type is immutable (cannot be changed)
    immutable: bool,
    /// Immutable type if set
    immutable_type: Option<ArgType>,
}

impl TypeInfo {
    pub fn new() -> Self {
        Self::default()
    }

    /// Add a type bound
    pub fn add_bound(&mut self, bound: Box<dyn TypeBound>) {
        // Skip Unknown type bounds
        if let Some(ty) = bound.get_type() {
            if matches!(ty, ArgType::Unknown) {
                return;
            }
        }
        self.bounds.push(bound);
    }

    /// Add a constant type bound
    pub fn add_const_bound(&mut self, bound: BoundEnum, ty: ArgType) {
        if !matches!(ty, ArgType::Unknown) {
            self.bounds.push(Box::new(TypeBoundConst::new(bound, ty)));
        }
    }

    /// Get all bounds
    pub fn bounds(&self) -> &[Box<dyn TypeBound>] {
        &self.bounds
    }

    /// Get mutable bounds
    pub fn bounds_mut(&mut self) -> &mut Vec<Box<dyn TypeBound>> {
        &mut self.bounds
    }

    /// Clear all bounds
    pub fn clear_bounds(&mut self) {
        self.bounds.clear();
    }

    /// Merge bounds from another TypeInfo
    pub fn merge_bounds(&mut self, other: &TypeInfo) {
        for bound in &other.bounds {
            self.bounds.push(bound.clone_box());
        }
    }

    /// Get resolved type
    pub fn resolved_type(&self) -> Option<&ArgType> {
        self.resolved_type.as_ref()
    }

    /// Set resolved type
    pub fn set_resolved_type(&mut self, ty: ArgType) {
        self.resolved_type = Some(ty);
    }

    /// Check if type is immutable
    pub fn is_immutable(&self) -> bool {
        self.immutable
    }

    /// Get immutable type if set
    pub fn immutable_type(&self) -> Option<&ArgType> {
        self.immutable_type.as_ref()
    }

    /// Mark type as immutable
    pub fn mark_immutable(&mut self, ty: ArgType) {
        self.immutable = true;
        self.immutable_type = Some(ty.clone());
        self.resolved_type = Some(ty);
    }

    /// Get all assign bounds
    pub fn assign_bounds(&self) -> impl Iterator<Item = &dyn TypeBound> {
        self.bounds
            .iter()
            .filter(|b| b.bound_kind() == BoundEnum::Assign)
            .map(|b| b.as_ref())
    }

    /// Get all use bounds
    pub fn use_bounds(&self) -> impl Iterator<Item = &dyn TypeBound> {
        self.bounds
            .iter()
            .filter(|b| b.bound_kind() == BoundEnum::Use)
            .map(|b| b.as_ref())
    }
}

impl Clone for TypeInfo {
    fn clone(&self) -> Self {
        Self {
            bounds: self.bounds.iter().map(|b| b.clone_box()).collect(),
            resolved_type: self.resolved_type.clone(),
            immutable: self.immutable,
            immutable_type: self.immutable_type.clone(),
        }
    }
}

#[cfg(test)]
mod tests {
    use super::*;

    #[test]
    fn test_bound_const_assign() {
        let bound = TypeBoundConst::assign(ArgType::Int);
        assert_eq!(bound.bound_kind(), BoundEnum::Assign);
        assert_eq!(bound.get_type(), Some(&ArgType::Int));
        assert!(!bound.is_dynamic());
    }

    #[test]
    fn test_bound_const_use() {
        let bound = TypeBoundConst::use_bound(ArgType::Object("java/lang/String".to_string()));
        assert_eq!(bound.bound_kind(), BoundEnum::Use);
        assert!(!bound.is_dynamic());
    }

    #[test]
    fn test_type_info_bounds() {
        let mut info = TypeInfo::new();
        info.add_const_bound(BoundEnum::Assign, ArgType::Int);
        info.add_const_bound(BoundEnum::Use, ArgType::Long);

        assert_eq!(info.bounds().len(), 2);
        assert_eq!(info.assign_bounds().count(), 1);
        assert_eq!(info.use_bounds().count(), 1);
    }

    #[test]
    fn test_type_info_immutable() {
        let mut info = TypeInfo::new();
        assert!(!info.is_immutable());

        info.mark_immutable(ArgType::Int);
        assert!(info.is_immutable());
        assert_eq!(info.immutable_type(), Some(&ArgType::Int));
        assert_eq!(info.resolved_type(), Some(&ArgType::Int));
    }

    #[test]
    fn test_invoke_assign_resolve() {
        let bound = TypeBoundInvokeAssign::new(
            0,
            ArgType::TypeVariable("E".to_string()),
            0,
            1,
        );

        // Should resolve E to String when instance is List<String>
        let instance_type = ArgType::Generic {
            base: "java/util/List".to_string(),
            params: vec![ArgType::Object("java/lang/String".to_string())],
        };
        let resolved = bound.resolve_return_type(&instance_type);
        assert_eq!(resolved, ArgType::Object("java/lang/String".to_string()));
    }

    #[test]
    fn test_check_cast_bound() {
        let hard = TypeBoundCheckCastAssign::hard(ArgType::Object("java/lang/String".to_string()));
        let soft = TypeBoundCheckCastAssign::soft(ArgType::Object("java/lang/String".to_string()));

        assert!(!hard.soft_cast);
        assert!(soft.soft_cast);
        assert_eq!(hard.bound_kind(), BoundEnum::Assign);
    }
}
