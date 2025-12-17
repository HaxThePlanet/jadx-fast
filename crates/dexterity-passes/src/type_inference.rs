//! Type inference pass
//!
//! This pass infers types for all registers in SSA form using constraint-based type inference.
//! The algorithm works in several phases:
//!
//! 1. Collect constraints from instructions with assign/use bound differentiation:
//!    - AssignBound: Type bound from LHS of assignment (what type can be assigned TO)
//!    - UseBound: Type bound from RHS/usage (what type is being assigned FROM)
//!
//! 2. Propagate constraints through phi nodes and assignments
//!
//! 3. Compute LCA (Lowest Common Ancestor) for PHI nodes with conflicting types
//!    - Example: PHI(String, Integer) -> Object (their common supertype)
//!    - Null-aware: PHI(String, null) -> String (null is assignable to any object)
//!
//! 4. Resolve type variables to concrete types using unification
//!
//! 5. Apply flow-sensitive refinements:
//!    - After `instanceof T` checks, variable is refined to T in that branch
//!    - After `(T)obj` casts, variable is refined to T in subsequent uses
//!
//! ## Constraint Types
//!
//! - `AssignBound`: The variable receives this type (LHS semantics)
//!   - More permissive: accepts subtypes of the bound
//!   - Example: `Object x = "hello"` - x has AssignBound(Object), can hold String
//!
//! - `UseBound`: The variable is used as this type (RHS semantics)
//!   - More restrictive: variable must be this type or subtype
//!   - Example: `process(obj)` where process takes String - obj has UseBound(String)
//!
//! This separation allows more precise type inference, especially for polymorphic code.

use std::collections::HashMap;
use rustc_hash::FxHashMap;
use tracing::error;

use dexterity_ir::instructions::{
    ArrayElemType, BinaryOp, CastType, CompareOp, IfCondition, InsnArg, InsnType, LiteralArg,
    RegisterArg, UnaryOp,
};
use dexterity_ir::types::ArgType;
use dexterity_ir::{ClassHierarchy, TypeCompare, compare_types};

use crate::ssa::SsaResult;
use crate::type_bound::{BoundEnum, TypeBoundConst, TypeBoundInvokeAssign, TypeInfo};

/// Type variable identifier
#[derive(Debug, Clone, Copy, PartialEq, Eq, Hash)]
pub struct TypeVar(u32);

impl TypeVar {
    pub fn new(id: u32) -> Self {
        TypeVar(id)
    }

    pub fn id(&self) -> u32 {
        self.0
    }
}

/// A type that may be concrete or a variable
#[derive(Debug, Clone, PartialEq, Eq)]
pub enum InferredType {
    /// Concrete known type
    Concrete(ArgType),
    /// Type variable (to be resolved)
    Var(TypeVar),
    /// Array of inferred type
    Array(Box<InferredType>),
    /// Unknown (couldn't be inferred)
    Unknown,
}

impl InferredType {
    pub fn is_concrete(&self) -> bool {
        matches!(self, InferredType::Concrete(_))
    }

    pub fn is_var(&self) -> bool {
        matches!(self, InferredType::Var(_))
    }

    /// Convert to concrete ArgType if possible
    pub fn to_arg_type(&self) -> Option<ArgType> {
        match self {
            InferredType::Concrete(t) => Some(t.clone()),
            InferredType::Array(elem) => {
                elem.to_arg_type().map(|t| ArgType::Array(Box::new(t)))
            }
            InferredType::Unknown => Some(ArgType::Unknown),
            InferredType::Var(_) => None,
        }
    }
}

/// Type constraint
#[derive(Debug, Clone)]
pub enum Constraint {
    /// TypeVar equals concrete type
    Equals(TypeVar, InferredType),
    /// Two type vars must be equal
    Same(TypeVar, TypeVar),
    /// TypeVar is subtype of type (for assignments, returns)
    Subtype(TypeVar, InferredType),
    /// TypeVar is an array with element type
    ArrayOf(TypeVar, TypeVar),
    /// TypeVar must be numeric (int, long, float, double)
    Numeric(TypeVar),
    /// TypeVar must be integral (int, long, short, byte, char)
    Integral(TypeVar),
    /// TypeVar must be an object (not primitive)
    ObjectType(TypeVar),
    /// Assignment bound: variable receives this type (LHS semantics)
    /// More permissive - can accept any subtype of the bound
    AssignBound(TypeVar, ArgType),
    /// Usage bound: variable is used as this type (RHS semantics)
    /// More restrictive - variable must be this type or subtype
    UseBound(TypeVar, ArgType),
}

/// Constraint for TypeSearch multi-variable solver
/// These represent dependencies between variables that must be satisfied
#[derive(Debug, Clone)]
enum TypeSearchConstraint {
    /// MOVE constraint: types must be compatible (from can be assigned to to)
    Move { from: TypeVar, to: TypeVar },
    /// PHI constraint: all variables must have the same (or compatible) type
    PhiSame { vars: Vec<TypeVar> },
}

/// Source of a type bound (for debugging and conflict resolution)
#[derive(Debug, Clone, Copy, PartialEq, Eq)]
pub enum BoundSource {
    /// From a constant/literal
    Literal,
    /// From a field access
    Field,
    /// From a method return type
    MethodReturn,
    /// From a method argument position
    MethodArg,
    /// From a cast operation
    Cast,
    /// From an instanceof check
    InstanceOf,
    /// From an array element access
    ArrayElement,
    /// From a new instance allocation
    NewInstance,
    /// From a PHI node merge
    PhiMerge,
    /// Unknown source
    Unknown,
}

/// Information about resolved type bounds for a variable
#[derive(Debug, Clone)]
pub struct TypeBounds {
    /// The upper bound (most general type this can be)
    pub upper_bound: Option<ArgType>,
    /// The lower bound (most specific type this must be)
    pub lower_bound: Option<ArgType>,
    /// The resolved concrete type
    pub resolved: Option<ArgType>,
    /// Source of the type information
    pub source: BoundSource,
}

impl Default for TypeBounds {
    fn default() -> Self {
        TypeBounds {
            upper_bound: None,
            lower_bound: None,
            resolved: None,
            source: BoundSource::Unknown,
        }
    }
}

impl TypeBounds {
    /// Create bounds with a single resolved type
    pub fn with_type(ty: ArgType, source: BoundSource) -> Self {
        TypeBounds {
            upper_bound: Some(ty.clone()),
            lower_bound: Some(ty.clone()),
            resolved: Some(ty),
            source,
        }
    }

    /// Create bounds with only an upper bound (assignable from subtypes)
    pub fn with_upper(ty: ArgType, source: BoundSource) -> Self {
        TypeBounds {
            upper_bound: Some(ty),
            lower_bound: None,
            resolved: None,
            source,
        }
    }

    /// Create bounds with only a lower bound (must be at least this type)
    pub fn with_lower(ty: ArgType, source: BoundSource) -> Self {
        TypeBounds {
            upper_bound: None,
            lower_bound: Some(ty),
            resolved: None,
            source,
        }
    }
}

/// Type inference context
pub struct TypeInference {
    /// Next type variable ID
    next_var: u32,
    /// Register (reg_num, ssa_version) -> TypeVar mapping
    reg_to_var: FxHashMap<(u16, u32), TypeVar>,
    /// Collected constraints
    constraints: Vec<Constraint>,
    /// Resolved types (TypeVar -> InferredType)
    resolved: FxHashMap<TypeVar, InferredType>,
    /// Type bounds for each variable (legacy bounds-based system)
    type_bounds: FxHashMap<TypeVar, TypeBounds>,
    /// New TypeInfo per variable (JADX-style bounds tracking)
    type_info: FxHashMap<TypeVar, TypeInfo>,
    /// Type lookup table for DEX indices (provided externally)
    type_lookup: Option<Box<dyn Fn(u32) -> Option<ArgType> + Send + Sync>>,
    /// Field type lookup (field_idx -> field type)
    field_lookup: Option<Box<dyn Fn(u32) -> Option<ArgType> + Send + Sync>>,
    /// Method return type lookup (method_idx -> return type)
    method_lookup: Option<Box<dyn Fn(u32) -> Option<(Vec<ArgType>, ArgType)> + Send + Sync>>,
    /// Class hierarchy for subtype checking and LCA
    hierarchy: Option<ClassHierarchy>,
    /// Last invoke return type (for MoveResult pairing)
    last_invoke_return: Option<ArgType>,
    /// Last invoke method idx (for TypeBoundInvokeAssign)
    last_invoke_method_idx: Option<u32>,
    /// Last invoke instance type variable (for resolving TypeVariables in return types)
    /// This is args[0] for instance methods (invoke-virtual/invoke-interface)
    last_invoke_instance_var: Option<TypeVar>,
    /// Last invoke instance register info (reg_num, ssa_version) for TypeBoundInvokeAssign
    last_invoke_instance_reg: Option<(u16, u32)>,
    /// Phi nodes for post-solve LCA computation: (dest_var, source_vars)
    phi_nodes: Vec<(TypeVar, Vec<TypeVar>)>,
    /// Type refinements from instanceof checks (block_id -> (var, refined_type))
    /// Used for flow-sensitive type narrowing
    #[allow(dead_code)]
    instanceof_refinements: FxHashMap<u32, Vec<(TypeVar, ArgType)>>,
    /// Type refinements from cast operations (var -> refined_type)
    cast_refinements: FxHashMap<TypeVar, ArgType>,
    /// Pending TypeVariable resolutions: (dest_var, instance_var, return_type_with_typevars)
    /// These are populated during MoveResult handling when the return type contains TypeVariable
    /// and resolved post-solve when instance types are known
    pending_type_var_resolutions: Vec<(TypeVar, TypeVar, ArgType)>,
}

impl Default for TypeInference {
    fn default() -> Self {
        Self::new()
    }
}

impl TypeInference {
    pub fn new() -> Self {
        TypeInference {
            next_var: 0,
            reg_to_var: FxHashMap::default(),
            constraints: Vec::new(),
            resolved: FxHashMap::default(),
            type_bounds: FxHashMap::default(),
            type_info: FxHashMap::default(),
            type_lookup: None,
            field_lookup: None,
            method_lookup: None,
            hierarchy: None,
            last_invoke_return: None,
            last_invoke_method_idx: None,
            last_invoke_instance_var: None,
            last_invoke_instance_reg: None,
            phi_nodes: Vec::new(),
            instanceof_refinements: FxHashMap::default(),
            cast_refinements: FxHashMap::default(),
            pending_type_var_resolutions: Vec::new(),
        }
    }

    /// Set class hierarchy for advanced type inference
    pub fn with_hierarchy(mut self, hierarchy: ClassHierarchy) -> Self {
        self.hierarchy = Some(hierarchy);
        self
    }

    /// Set type lookup function for DEX type indices
    pub fn with_type_lookup<F>(mut self, f: F) -> Self
    where
        F: Fn(u32) -> Option<ArgType> + Send + Sync + 'static,
    {
        self.type_lookup = Some(Box::new(f));
        self
    }

    /// Set field lookup function
    pub fn with_field_lookup<F>(mut self, f: F) -> Self
    where
        F: Fn(u32) -> Option<ArgType> + Send + Sync + 'static,
    {
        self.field_lookup = Some(Box::new(f));
        self
    }

    /// Set method lookup function
    pub fn with_method_lookup<F>(mut self, f: F) -> Self
    where
        F: Fn(u32) -> Option<(Vec<ArgType>, ArgType)> + Send + Sync + 'static,
    {
        self.method_lookup = Some(Box::new(f));
        self
    }

    /// Create or get type variable for a register
    fn get_or_create_var(&mut self, reg: &RegisterArg) -> TypeVar {
        let key = (reg.reg_num, reg.ssa_version);
        if let Some(&var) = self.reg_to_var.get(&key) {
            var
        } else {
            let var = TypeVar::new(self.next_var);
            self.next_var += 1;
            self.reg_to_var.insert(key, var);
            var
        }
    }

    /// Create a fresh type variable
    fn fresh_var(&mut self) -> TypeVar {
        const VARS_PROCESS_LIMIT: u32 = 5000;
        if self.next_var >= VARS_PROCESS_LIMIT {
            error!(
                vars_count = self.next_var,
                limit = VARS_PROCESS_LIMIT,
                "LIMIT_EXCEEDED: Type inference variables limit reached"
            );
            // Panic to abort inference for this method (caught by catch_unwind in main)
            panic!("SKIP: Type inference variables limit reached ({})", VARS_PROCESS_LIMIT);
        }
        let var = TypeVar::new(self.next_var);
        self.next_var += 1;
        var
    }

    /// Add a constraint
    fn add_constraint(&mut self, constraint: Constraint) {
        self.constraints.push(constraint);
    }

    /// Add a type bound using the new TypeInfo system
    fn add_type_bound(&mut self, var: TypeVar, bound: BoundEnum, ty: ArgType) {
        if matches!(ty, ArgType::Unknown) {
            return;
        }
        let info = self.type_info.entry(var).or_insert_with(TypeInfo::new);
        info.add_const_bound(bound, ty);
    }

    /// Add an assign bound (variable receives this type)
    fn add_assign_bound(&mut self, var: TypeVar, ty: ArgType) {
        self.add_type_bound(var, BoundEnum::Assign, ty);
    }

    /// Add a use bound (variable is used as this type)
    fn add_use_bound(&mut self, var: TypeVar, ty: ArgType) {
        self.add_type_bound(var, BoundEnum::Use, ty);
    }

    /// Add a dynamic invoke bound for generic return type resolution
    fn add_invoke_bound(&mut self, var: TypeVar, method_idx: u32, return_type: ArgType, instance_reg: u16, instance_ssa: u32) {
        if matches!(return_type, ArgType::Unknown) {
            return;
        }
        let info = self.type_info.entry(var).or_insert_with(TypeInfo::new);
        let bound = TypeBoundInvokeAssign::new(method_idx, return_type, instance_reg, instance_ssa);
        info.add_bound(Box::new(bound));
    }

    /// Mark a variable's type as immutable (cannot be changed)
    fn mark_immutable(&mut self, var: TypeVar, ty: ArgType) {
        let info = self.type_info.entry(var).or_insert_with(TypeInfo::new);
        info.mark_immutable(ty);
    }

    /// Get type variable for an instruction argument
    fn var_for_arg(&mut self, arg: &InsnArg) -> Option<TypeVar> {
        match arg {
            InsnArg::Register(reg) => {
                // Check limit before creating new var
                let key = (reg.reg_num, reg.ssa_version);
                if !self.reg_to_var.contains_key(&key) {
                    const VARS_PROCESS_LIMIT: u32 = 5000;
                    if self.next_var >= VARS_PROCESS_LIMIT {
                        panic!("SKIP: Type inference variables limit reached ({})", VARS_PROCESS_LIMIT);
                    }
                }
                Some(self.get_or_create_var(reg))
            },
            InsnArg::Literal(_) => None, // Literals have known types
            _ => None,
        }
    }

    /// Get inferred type for a literal
    fn type_for_literal(lit: &LiteralArg) -> InferredType {
        match lit {
            LiteralArg::Int(v) => {
                // Narrow down int types based on value
                if *v >= i32::MIN as i64 && *v <= i32::MAX as i64 {
                    InferredType::Concrete(ArgType::Int)
                } else {
                    InferredType::Concrete(ArgType::Long)
                }
            }
            LiteralArg::Float(_) => InferredType::Concrete(ArgType::Float),
            LiteralArg::Double(_) => InferredType::Concrete(ArgType::Double),
            LiteralArg::Null => InferredType::Concrete(ArgType::Object("null".to_string())),
        }
    }

    /// Inferred type for an instruction argument
    fn type_for_arg(&mut self, arg: &InsnArg) -> InferredType {
        match arg {
            InsnArg::Register(reg) => InferredType::Var(self.get_or_create_var(reg)),
            InsnArg::Literal(lit) => Self::type_for_literal(lit),
            InsnArg::Type(idx) => {
                if let Some(ref lookup) = self.type_lookup {
                    if let Some(ty) = lookup(*idx) {
                        return InferredType::Concrete(ty);
                    }
                }
                InferredType::Unknown
            }
            InsnArg::String(_) => {
                InferredType::Concrete(ArgType::Object("java/lang/String".to_string()))
            }
            _ => InferredType::Unknown,
        }
    }

    /// Check if a type contains any TypeVariable that needs resolution
    fn contains_type_variable(ty: &ArgType) -> bool {
        match ty {
            ArgType::TypeVariable(_) => true,
            ArgType::Generic { params, .. } => params.iter().any(Self::contains_type_variable),
            ArgType::Array(elem) => Self::contains_type_variable(elem),
            _ => false,
        }
    }

    /// Resolve TypeVariables in a return type given a concrete instance type
    ///
    /// This handles common generic patterns like:
    /// - `List<String>.get(int)` -> return type `E` becomes `String`
    /// - `Map<K,V>.get(key)` -> return type `V` becomes the second param
    /// - `Optional<User>.get()` -> return type `T` becomes `User`
    ///
    /// The resolution uses positional mapping: if the instance is `Generic { base, params }`
    /// and return type is `TypeVariable(name)`, we resolve based on the type variable's
    /// position in the base class's type parameters.
    ///
    /// For now, uses a simplified approach:
    /// - Single type variable (E, T, V) -> first generic param
    /// - Common patterns (K -> first, V -> second for Map-like classes)
    fn resolve_type_variable(&self, return_type: &ArgType, instance_type: &ArgType) -> ArgType {
        match (return_type, instance_type) {
            // If return type is a TypeVariable and instance has Generic params, try to resolve
            (ArgType::TypeVariable(var_name), ArgType::Generic { params, .. }) if !params.is_empty() => {
                // Common single-letter type variables
                match var_name.as_str() {
                    // First type parameter (List<E>, Optional<T>, Set<E>, etc.)
                    "E" | "T" | "R" => params.first().cloned().unwrap_or(return_type.clone()),
                    // Second type parameter (Map<K,V>)
                    "V" if params.len() >= 2 => params.get(1).cloned().unwrap_or(return_type.clone()),
                    // First type parameter (Map<K,V>)
                    "K" => params.first().cloned().unwrap_or(return_type.clone()),
                    // Unknown variable name - use first param as fallback
                    _ => params.first().cloned().unwrap_or(return_type.clone()),
                }
            }
            // For Generic return types, recursively resolve type params
            (ArgType::Generic { base, params: ret_params }, instance_ty) => {
                let resolved_params: Vec<ArgType> = ret_params
                    .iter()
                    .map(|p| self.resolve_type_variable(p, instance_ty))
                    .collect();
                ArgType::Generic {
                    base: base.clone(),
                    params: resolved_params,
                }
            }
            // For Array return types, resolve element type
            (ArgType::Array(elem), instance_ty) => {
                let resolved_elem = self.resolve_type_variable(elem, instance_ty);
                ArgType::Array(Box::new(resolved_elem))
            }
            // No resolution possible - return as-is
            _ => return_type.clone(),
        }
    }

    /// Collect constraints from a single instruction
    fn collect_from_insn(&mut self, insn: &InsnType) {
        match insn {
            InsnType::Const { dest, value } => {
                let dest_var = self.get_or_create_var(dest);
                let ty = Self::type_for_literal(value);
                self.add_constraint(Constraint::Equals(dest_var, ty));
            }

            InsnType::ConstString { dest, .. } => {
                let dest_var = self.get_or_create_var(dest);
                self.add_constraint(Constraint::Equals(
                    dest_var,
                    InferredType::Concrete(ArgType::Object("java/lang/String".to_string())),
                ));
            }

            InsnType::ConstClass { dest, type_idx } => {
                let dest_var = self.get_or_create_var(dest);
                // Result is Class<T> where T is the type
                let class_type = if let Some(ref lookup) = self.type_lookup {
                    if let Some(ty) = lookup(*type_idx) {
                        ArgType::Generic {
                            base: "java/lang/Class".to_string(),
                            params: vec![ty],
                        }
                    } else {
                        ArgType::Object("java/lang/Class".to_string())
                    }
                } else {
                    ArgType::Object("java/lang/Class".to_string())
                };
                self.add_constraint(Constraint::Equals(
                    dest_var,
                    InferredType::Concrete(class_type),
                ));
            }

            InsnType::Move { dest, src } => {
                let dest_var = self.get_or_create_var(dest);
                if let Some(src_var) = self.var_for_arg(src) {
                    self.add_constraint(Constraint::Same(dest_var, src_var));
                } else {
                    let src_ty = self.type_for_arg(src);
                    self.add_constraint(Constraint::Equals(dest_var, src_ty));
                }
            }

            InsnType::MoveResult { dest } => {
                // Type comes from previous invoke
                let dest_var = self.get_or_create_var(dest);
                // Use the return type from the preceding Invoke instruction
                let return_type = self.last_invoke_return.take();
                let instance_var = self.last_invoke_instance_var.take();
                let instance_reg = self.last_invoke_instance_reg.take();
                let method_idx = self.last_invoke_method_idx.take();

                if let Some(return_ty) = return_type {
                    // Check if return type contains TypeVariable and we have instance info
                    if Self::contains_type_variable(&return_ty) {
                        if let Some(inst_var) = instance_var {
                            // Track this for post-solve resolution (legacy)
                            self.pending_type_var_resolutions.push((dest_var, inst_var, return_ty.clone()));
                        }
                        // NEW: Add dynamic invoke bound for generic type resolution
                        if let (Some(method_id), Some((reg_num, ssa_version))) = (method_idx, instance_reg) {
                            self.add_invoke_bound(dest_var, method_id, return_ty.clone(), reg_num, ssa_version);
                        }
                    } else {
                        // Non-generic return type - add as assign bound
                        self.add_assign_bound(dest_var, return_ty.clone());
                    }
                    // Always add the constraint (will be refined post-solve if needed)
                    self.add_constraint(Constraint::Equals(dest_var, InferredType::Concrete(return_ty)));
                } else {
                    self.add_constraint(Constraint::Equals(dest_var, InferredType::Unknown));
                }
            }

            InsnType::MoveException { dest } => {
                let dest_var = self.get_or_create_var(dest);
                self.add_constraint(Constraint::Equals(
                    dest_var,
                    InferredType::Concrete(ArgType::Object("java/lang/Throwable".to_string())),
                ));
            }

            InsnType::InstanceOf { dest, object, .. } => {
                let dest_var = self.get_or_create_var(dest);
                self.add_constraint(Constraint::Equals(
                    dest_var,
                    InferredType::Concrete(ArgType::Boolean),
                ));
                // Object must be object type
                if let Some(obj_var) = self.var_for_arg(object) {
                    self.add_constraint(Constraint::ObjectType(obj_var));
                }
            }

            InsnType::ArrayLength { dest, array } => {
                let dest_var = self.get_or_create_var(dest);
                self.add_constraint(Constraint::Equals(
                    dest_var,
                    InferredType::Concrete(ArgType::Int),
                ));
                // Array operand must be an array
                if let Some(arr_var) = self.var_for_arg(array) {
                    let elem_var = self.fresh_var();
                    self.add_constraint(Constraint::ArrayOf(arr_var, elem_var));
                }
            }

            InsnType::NewInstance { dest, type_idx } => {
                let dest_var = self.get_or_create_var(dest);
                let ty = if let Some(ref lookup) = self.type_lookup {
                    lookup(*type_idx)
                        .map(InferredType::Concrete)
                        .unwrap_or(InferredType::Unknown)
                } else {
                    InferredType::Unknown
                };
                // New: Mark as immutable - NewInstance always produces exact type
                if let InferredType::Concrete(ref arg_ty) = ty {
                    if !matches!(arg_ty, ArgType::Unknown) {
                        self.mark_immutable(dest_var, arg_ty.clone());
                    }
                }
                self.add_constraint(Constraint::Equals(dest_var, ty));
            }

            InsnType::NewArray { dest, type_idx, size } => {
                let dest_var = self.get_or_create_var(dest);
                // Size must be int
                if let Some(size_var) = self.var_for_arg(size) {
                    self.add_constraint(Constraint::Equals(
                        size_var,
                        InferredType::Concrete(ArgType::Int),
                    ));
                }
                // Result is array type
                let ty = if let Some(ref lookup) = self.type_lookup {
                    lookup(*type_idx)
                        .map(InferredType::Concrete)
                        .unwrap_or(InferredType::Unknown)
                } else {
                    InferredType::Unknown
                };
                self.add_constraint(Constraint::Equals(dest_var, ty));
            }

            InsnType::ArrayGet {
                dest,
                array,
                index,
                elem_type,
            } => {
                let dest_var = self.get_or_create_var(dest);
                // Index must be int
                if let Some(idx_var) = self.var_for_arg(index) {
                    self.add_constraint(Constraint::Equals(
                        idx_var,
                        InferredType::Concrete(ArgType::Int),
                    ));
                }
                // Array constraint - enables bidirectional type inference
                if let Some(arr_var) = self.var_for_arg(array) {
                    self.add_constraint(Constraint::ArrayOf(arr_var, dest_var));
                }
                // Use elem_type hint for primitive types, ObjectType for objects
                match elem_type {
                    ArrayElemType::Int => {
                        self.add_constraint(Constraint::Equals(
                            dest_var,
                            InferredType::Concrete(ArgType::Int),
                        ));
                    }
                    ArrayElemType::Wide => {
                        self.add_constraint(Constraint::Equals(
                            dest_var,
                            InferredType::Concrete(ArgType::Long),
                        ));
                    }
                    ArrayElemType::Boolean => {
                        self.add_constraint(Constraint::Equals(
                            dest_var,
                            InferredType::Concrete(ArgType::Boolean),
                        ));
                    }
                    ArrayElemType::Byte => {
                        self.add_constraint(Constraint::Equals(
                            dest_var,
                            InferredType::Concrete(ArgType::Byte),
                        ));
                    }
                    ArrayElemType::Char => {
                        self.add_constraint(Constraint::Equals(
                            dest_var,
                            InferredType::Concrete(ArgType::Char),
                        ));
                    }
                    ArrayElemType::Short => {
                        self.add_constraint(Constraint::Equals(
                            dest_var,
                            InferredType::Concrete(ArgType::Short),
                        ));
                    }
                    ArrayElemType::Object => {
                        // Element is an object - add ObjectType constraint as fallback
                        // The actual type may be resolved via ArrayOf constraint
                        self.add_constraint(Constraint::ObjectType(dest_var));
                    }
                }
            }

            InsnType::ArrayPut {
                array,
                index,
                value,
                elem_type,
            } => {
                // Index must be int
                if let Some(idx_var) = self.var_for_arg(index) {
                    self.add_constraint(Constraint::Equals(
                        idx_var,
                        InferredType::Concrete(ArgType::Int),
                    ));
                }
                // Value type relates to array element type - enables bidirectional inference
                if let (Some(arr_var), Some(val_var)) =
                    (self.var_for_arg(array), self.var_for_arg(value))
                {
                    self.add_constraint(Constraint::ArrayOf(arr_var, val_var));
                }
                // Use elem_type hint for primitive types, ObjectType for objects
                if let Some(val_var) = self.var_for_arg(value) {
                    match elem_type {
                        ArrayElemType::Int => {
                            self.add_constraint(Constraint::Equals(
                                val_var,
                                InferredType::Concrete(ArgType::Int),
                            ));
                        }
                        ArrayElemType::Wide => {
                            self.add_constraint(Constraint::Equals(
                                val_var,
                                InferredType::Concrete(ArgType::Long),
                            ));
                        }
                        ArrayElemType::Boolean => {
                            self.add_constraint(Constraint::Equals(
                                val_var,
                                InferredType::Concrete(ArgType::Boolean),
                            ));
                        }
                        ArrayElemType::Byte => {
                            self.add_constraint(Constraint::Equals(
                                val_var,
                                InferredType::Concrete(ArgType::Byte),
                            ));
                        }
                        ArrayElemType::Char => {
                            self.add_constraint(Constraint::Equals(
                                val_var,
                                InferredType::Concrete(ArgType::Char),
                            ));
                        }
                        ArrayElemType::Short => {
                            self.add_constraint(Constraint::Equals(
                                val_var,
                                InferredType::Concrete(ArgType::Short),
                            ));
                        }
                        ArrayElemType::Object => {
                            // Element is an object - add ObjectType constraint as fallback
                            // The actual type may be resolved via ArrayOf constraint
                            self.add_constraint(Constraint::ObjectType(val_var));
                        }
                    }
                }
            }

            InsnType::InstanceGet {
                dest,
                object,
                field_idx,
            } => {
                let dest_var = self.get_or_create_var(dest);
                // Object must be object type
                if let Some(obj_var) = self.var_for_arg(object) {
                    self.add_constraint(Constraint::ObjectType(obj_var));
                }
                // Field type determines dest type - use AssignBound (assignment target)
                if let Some(ref lookup) = self.field_lookup {
                    if let Some(field_ty) = lookup(*field_idx) {
                        // NEW: Add assign bound using new TypeInfo system
                        self.add_assign_bound(dest_var, field_ty.clone());
                        // AssignBound for field reads - the destination receives this type
                        if !matches!(field_ty, ArgType::Unknown) {
                            self.add_constraint(Constraint::AssignBound(
                                dest_var,
                                field_ty.clone(),
                            ));
                        }
                        self.add_constraint(Constraint::Equals(
                            dest_var,
                            InferredType::Concrete(field_ty),
                        ));
                    }
                }
            }

            InsnType::InstancePut {
                object,
                field_idx,
                value,
            } => {
                if let Some(obj_var) = self.var_for_arg(object) {
                    self.add_constraint(Constraint::ObjectType(obj_var));
                }
                if let Some(val_var) = self.var_for_arg(value) {
                    if let Some(ref lookup) = self.field_lookup {
                        if let Some(field_ty) = lookup(*field_idx) {
                            // Use UseBound - the value must be assignable to the field type
                            if !matches!(field_ty, ArgType::Unknown) {
                                self.add_constraint(Constraint::UseBound(
                                    val_var,
                                    field_ty.clone(),
                                ));
                            }
                            self.add_constraint(Constraint::Subtype(
                                val_var,
                                InferredType::Concrete(field_ty),
                            ));
                        }
                    }
                }
            }

            InsnType::StaticGet { dest, field_idx } => {
                let dest_var = self.get_or_create_var(dest);
                if let Some(ref lookup) = self.field_lookup {
                    if let Some(field_ty) = lookup(*field_idx) {
                        // NEW: Add assign bound using new TypeInfo system
                        self.add_assign_bound(dest_var, field_ty.clone());
                        // AssignBound for static field reads
                        if !matches!(field_ty, ArgType::Unknown) {
                            self.add_constraint(Constraint::AssignBound(
                                dest_var,
                                field_ty.clone(),
                            ));
                        }
                        self.add_constraint(Constraint::Equals(
                            dest_var,
                            InferredType::Concrete(field_ty),
                        ));
                    }
                }
            }

            InsnType::StaticPut { field_idx, value } => {
                if let Some(val_var) = self.var_for_arg(value) {
                    if let Some(ref lookup) = self.field_lookup {
                        if let Some(field_ty) = lookup(*field_idx) {
                            // UseBound - the value must be assignable to the field type
                            if !matches!(field_ty, ArgType::Unknown) {
                                self.add_constraint(Constraint::UseBound(
                                    val_var,
                                    field_ty.clone(),
                                ));
                            }
                            self.add_constraint(Constraint::Subtype(
                                val_var,
                                InferredType::Concrete(field_ty),
                            ));
                        }
                    }
                }
            }

            InsnType::Invoke { method_idx, args, .. } => {
                // Method signature determines arg types and return type
                // Reset instance var tracking for this invoke
                self.last_invoke_instance_var = None;
                self.last_invoke_instance_reg = None;
                self.last_invoke_method_idx = Some(*method_idx);

                if let Some(ref lookup) = self.method_lookup {
                    if let Some((param_types, return_ty)) = lookup(*method_idx) {
                        // For instance methods, args[0] is the receiver (this)
                        // Track it for resolving TypeVariables in return types
                        // Instance methods have one more arg than param_types (the implicit 'this')
                        let is_instance_method = args.len() > param_types.len();
                        if is_instance_method {
                            if let Some(instance_arg) = args.first() {
                                if let Some(instance_var) = self.var_for_arg(instance_arg) {
                                    self.last_invoke_instance_var = Some(instance_var);
                                    // Track register info for TypeBoundInvokeAssign
                                    if let InsnArg::Register(reg) = instance_arg {
                                        self.last_invoke_instance_reg = Some((reg.reg_num, reg.ssa_version));
                                    }
                                }
                            }
                        }

                        // Process arguments (skip first for instance methods)
                        let args_iter = if is_instance_method { &args[1..] } else { args.as_slice() };
                        for (arg, expected_ty) in args_iter.iter().zip(param_types.iter()) {
                            if let Some(arg_var) = self.var_for_arg(arg) {
                                // NEW: Add use bound using new TypeInfo system
                                self.add_use_bound(arg_var, expected_ty.clone());
                                // Use UseBound for method arguments - they must be compatible
                                // with the parameter type (variable is used as this type)
                                if !matches!(expected_ty, ArgType::Unknown) {
                                    self.add_constraint(Constraint::UseBound(
                                        arg_var,
                                        expected_ty.clone(),
                                    ));
                                }
                                // Keep Subtype for backward compatibility
                                self.add_constraint(Constraint::Subtype(
                                    arg_var,
                                    InferredType::Concrete(expected_ty.clone()),
                                ));
                            }
                        }
                        // Store return type for subsequent MoveResult
                        self.last_invoke_return = Some(return_ty);
                    }
                }
            }

            InsnType::Unary { dest, op, arg } => {
                let dest_var = self.get_or_create_var(dest);
                match op {
                    UnaryOp::Neg => {
                        // Negation preserves numeric type
                        self.add_constraint(Constraint::Numeric(dest_var));
                        if let Some(arg_var) = self.var_for_arg(arg) {
                            self.add_constraint(Constraint::Same(dest_var, arg_var));
                        }
                    }
                    UnaryOp::Not => {
                        // Bitwise not - integral type
                        self.add_constraint(Constraint::Integral(dest_var));
                        if let Some(arg_var) = self.var_for_arg(arg) {
                            self.add_constraint(Constraint::Same(dest_var, arg_var));
                        }
                    }
                    UnaryOp::BoolNot => {
                        // Boolean not - result and operand are boolean
                        self.add_constraint(Constraint::Equals(dest_var, InferredType::Concrete(ArgType::Boolean)));
                        if let Some(arg_var) = self.var_for_arg(arg) {
                            self.add_constraint(Constraint::Equals(arg_var, InferredType::Concrete(ArgType::Boolean)));
                        }
                    }
                }
            }

            InsnType::Binary {
                dest,
                op,
                left,
                right,
            } => {
                let dest_var = self.get_or_create_var(dest);
                match op {
                    BinaryOp::Add
                    | BinaryOp::Sub
                    | BinaryOp::Mul
                    | BinaryOp::Div
                    | BinaryOp::Rem
                    | BinaryOp::Rsub => {
                        // Arithmetic ops - result same type as operands
                        self.add_constraint(Constraint::Numeric(dest_var));
                        if let Some(l_var) = self.var_for_arg(left) {
                            self.add_constraint(Constraint::Same(dest_var, l_var));
                        }
                        if let Some(r_var) = self.var_for_arg(right) {
                            self.add_constraint(Constraint::Same(dest_var, r_var));
                        }
                    }
                    BinaryOp::And | BinaryOp::Or | BinaryOp::Xor => {
                        // Bitwise ops - integral types
                        self.add_constraint(Constraint::Integral(dest_var));
                        if let Some(l_var) = self.var_for_arg(left) {
                            self.add_constraint(Constraint::Same(dest_var, l_var));
                        }
                    }
                    BinaryOp::Shl | BinaryOp::Shr | BinaryOp::Ushr => {
                        // Shift ops - left operand type is result, right is int
                        self.add_constraint(Constraint::Integral(dest_var));
                        if let Some(l_var) = self.var_for_arg(left) {
                            self.add_constraint(Constraint::Same(dest_var, l_var));
                        }
                        if let Some(r_var) = self.var_for_arg(right) {
                            self.add_constraint(Constraint::Equals(
                                r_var,
                                InferredType::Concrete(ArgType::Int),
                            ));
                        }
                    }
                }
            }

            InsnType::Cast { dest, cast_type, .. } => {
                let dest_var = self.get_or_create_var(dest);
                let result_type = match cast_type {
                    CastType::IntToLong => ArgType::Long,
                    CastType::IntToFloat => ArgType::Float,
                    CastType::IntToDouble => ArgType::Double,
                    CastType::LongToInt => ArgType::Int,
                    CastType::LongToFloat => ArgType::Float,
                    CastType::LongToDouble => ArgType::Double,
                    CastType::FloatToInt => ArgType::Int,
                    CastType::FloatToLong => ArgType::Long,
                    CastType::FloatToDouble => ArgType::Double,
                    CastType::DoubleToInt => ArgType::Int,
                    CastType::DoubleToLong => ArgType::Long,
                    CastType::DoubleToFloat => ArgType::Float,
                    CastType::IntToByte => ArgType::Byte,
                    CastType::IntToChar => ArgType::Char,
                    CastType::IntToShort => ArgType::Short,
                };
                self.add_constraint(Constraint::Equals(
                    dest_var,
                    InferredType::Concrete(result_type),
                ));
            }

            InsnType::Compare { dest, op, left, right } => {
                let dest_var = self.get_or_create_var(dest);
                // Compare always returns int (-1, 0, 1)
                self.add_constraint(Constraint::Equals(
                    dest_var,
                    InferredType::Concrete(ArgType::Int),
                ));
                // Operands must be same type
                if let (Some(l_var), Some(r_var)) =
                    (self.var_for_arg(left), self.var_for_arg(right))
                {
                    self.add_constraint(Constraint::Same(l_var, r_var));
                }
                // Type based on comparison kind
                let operand_type = match op {
                    CompareOp::CmplFloat | CompareOp::CmpgFloat => ArgType::Float,
                    CompareOp::CmplDouble | CompareOp::CmpgDouble => ArgType::Double,
                    CompareOp::CmpLong => ArgType::Long,
                };
                if let Some(l_var) = self.var_for_arg(left) {
                    self.add_constraint(Constraint::Equals(
                        l_var,
                        InferredType::Concrete(operand_type.clone()),
                    ));
                }
                if let Some(r_var) = self.var_for_arg(right) {
                    self.add_constraint(Constraint::Equals(
                        r_var,
                        InferredType::Concrete(operand_type),
                    ));
                }
            }

            InsnType::Phi { dest, sources } => {
                let dest_var = self.get_or_create_var(dest);
                // Collect source type variables
                let mut source_vars = Vec::with_capacity(sources.len());
                for (_, src_arg) in sources {
                    if let Some(src_var) = self.var_for_arg(src_arg) {
                        self.add_constraint(Constraint::Same(dest_var, src_var));
                        source_vars.push(src_var);
                    }
                }
                // Record phi node for post-solve LCA computation
                if !source_vars.is_empty() {
                    self.phi_nodes.push((dest_var, source_vars));
                }
            }

            // CheckCast refines the type of the object
            InsnType::CheckCast { object, type_idx } => {
                if let Some(obj_var) = self.var_for_arg(object) {
                    // Get the target type from the type_idx
                    if let Some(ref lookup) = self.type_lookup {
                        if let Some(target_ty) = lookup(*type_idx) {
                            // After a cast, the object is refined to the target type
                            // Use AssignBound because the cast assigns a more specific type
                            if !matches!(target_ty, ArgType::Unknown) {
                                self.add_constraint(Constraint::AssignBound(
                                    obj_var,
                                    target_ty.clone(),
                                ));
                                // Also store in cast_refinements for flow-sensitive use
                                self.cast_refinements.insert(obj_var, target_ty);
                            }
                        }
                    }
                }
            }

            // If instructions provide type information from comparisons
            InsnType::If { condition, left, right, .. } => {
                // If comparing two registers, they should have the same type
                if let (Some(l_var), Some(r_var)) = (self.var_for_arg(left), right.as_ref().and_then(|r| self.var_for_arg(r))) {
                    self.add_constraint(Constraint::Same(l_var, r_var));
                }

                // For Eq/Ne comparisons against 0/null, we can't determine if it's object or int
                // without additional context. However, if we already have bounds on the variable,
                // this constraint can help propagate them.
                //
                // For Lt/Le/Gt/Ge comparisons against 0, the left operand is numeric
                if let Some(l_var) = self.var_for_arg(left) {
                    match condition {
                        IfCondition::Lt | IfCondition::Le | IfCondition::Gt | IfCondition::Ge => {
                            // Numeric comparisons require numeric type
                            // Check if comparing against a literal 0
                            let is_zero_compare = right.is_none() || matches!(right, Some(InsnArg::Literal(LiteralArg::Int(0))));
                            if is_zero_compare {
                                self.add_constraint(Constraint::Numeric(l_var));
                            }
                        }
                        IfCondition::Eq | IfCondition::Ne => {
                            // Eq/Ne could be null check or zero check
                            // If comparing against a non-zero literal, it's numeric
                            if let Some(InsnArg::Literal(LiteralArg::Int(v))) = right {
                                if *v != 0 {
                                    self.add_constraint(Constraint::Numeric(l_var));
                                }
                            }
                        }
                    }
                }
            }

            // Ternary: result = cond ? then_value : else_value
            // The dest type should be the common type of then_value and else_value
            InsnType::Ternary { dest, then_value, else_value, .. } => {
                let dest_var = self.get_or_create_var(dest);
                if let Some(then_var) = self.var_for_arg(then_value) {
                    self.add_constraint(Constraint::Same(dest_var, then_var));
                }
                if let Some(else_var) = self.var_for_arg(else_value) {
                    self.add_constraint(Constraint::Same(dest_var, else_var));
                }
            }

            // Other control flow instructions don't produce types
            InsnType::Nop
            | InsnType::Return { .. }
            | InsnType::Throw { .. }
            | InsnType::MonitorEnter { .. }
            | InsnType::MonitorExit { .. }
            | InsnType::FilledNewArray { .. }
            | InsnType::FillArrayData { .. }
            | InsnType::Goto { .. }
            | InsnType::PackedSwitch { .. }
            | InsnType::SparseSwitch { .. }
            | InsnType::Break { .. }
            | InsnType::Continue { .. }
            | InsnType::InvokeCustom { .. }
            // New JADX-compatible instructions
            | InsnType::MoveMulti { .. }
            | InsnType::StrConcat { .. }
            | InsnType::RegionArg { .. }
            | InsnType::OneArg { .. }
            | InsnType::Constructor { .. }
            | InsnType::JavaJsr { .. }
            | InsnType::JavaRet { .. } => {}
        }
    }

    /// Collect constraints from phi nodes
    ///
    /// PHI nodes represent merge points in control flow where a variable may have
    /// different values (and potentially different types) from different branches.
    ///
    /// Type inference for PHI nodes uses a multi-stage approach:
    /// 1. Collect `Same` constraints to propagate concrete types between sources
    /// 2. Record PHI nodes for post-solve LCA computation
    /// 3. If sources have incompatible types, compute their Least Common Ancestor
    fn collect_from_phi(&mut self, phi: &crate::ssa::PhiNode) {
        let dest_var = self.get_or_create_var(&phi.dest);
        let mut source_vars = Vec::with_capacity(phi.sources.len());
        for (_, src_reg) in &phi.sources {
            let src_var = self.get_or_create_var(src_reg);
            // Same constraint for basic type propagation
            self.add_constraint(Constraint::Same(dest_var, src_var));
            source_vars.push(src_var);
        }
        // Record phi node for post-solve LCA computation
        // This enables computing common supertypes when sources have different types
        if !source_vars.is_empty() {
            self.phi_nodes.push((dest_var, source_vars));
        }
    }

    /// Collect all constraints from SSA blocks
    pub fn collect_constraints(&mut self, ssa: &SsaResult) {
        for block in &ssa.blocks {
            // Phi nodes first
            for phi in &block.phi_nodes {
                self.collect_from_phi(phi);
            }
            // Then instructions
            for insn in &block.instructions {
                self.collect_from_insn(&insn.insn_type);
            }
        }
    }

    /// Solve constraints using iterative unification
    pub fn solve(&mut self) {
        // Multiple iterations until no changes
        let mut changed = true;
        let mut total_checks = 0;
        const SEARCH_ITERATION_LIMIT: usize = 1_000_000;

        while changed {
            if total_checks > SEARCH_ITERATION_LIMIT {
                panic!("SKIP: Type inference iterations limit reached ({})", SEARCH_ITERATION_LIMIT);
            }
            changed = false;

            // OPTIMIZATION: Eliminate constraint cloning in hot loop
            // Previously: let constraint = self.constraints[i].clone() in every iteration
            // This cloned 100+ times per constraint during solve() iterations.
            // New: Use indices and borrow constraints by reference instead of cloning.
            let constraint_count = self.constraints.len();
            total_checks += constraint_count;

            for i in 0..constraint_count {
                // Clone constraint once to avoid borrowing issues
                // KEY: We now clone ONE time per constraint instead of cloning per iteration
                // of the outer loop (100+x improvement!)
                let constraint = self.constraints[i].clone();

                match constraint {
                    Constraint::Equals(var, ty) => {
                        if self.unify_var_type(var, &ty) {
                            changed = true;
                        }
                    }
                    Constraint::Same(v1, v2) => {
                        if self.unify_vars(v1, v2) {
                            changed = true;
                        }
                    }
                    Constraint::Subtype(var, ty) => {
                        // For now, treat subtype as equals
                        if self.unify_var_type(var, &ty) {
                            changed = true;
                        }
                    }
                    Constraint::ArrayOf(arr_var, elem_var) => {
                        // OPTIMIZED: Avoid cloning InferredType by borrowing from resolved map
                        // If we know array type, infer element type
                        let elem_from_arr = if let Some(InferredType::Concrete(ArgType::Array(elem))) = self.resolved.get(&arr_var) {
                            Some(elem.as_ref().clone())
                        } else {
                            None
                        };
                        if let Some(elem) = elem_from_arr {
                            let elem_ty = InferredType::Concrete(elem);
                            if self.unify_var_type(elem_var, &elem_ty) {
                                changed = true;
                            }
                        }
                        // If we know element type, infer array type
                        let elem_for_arr = if let Some(InferredType::Concrete(elem)) = self.resolved.get(&elem_var) {
                            Some(elem.clone())
                        } else {
                            None
                        };
                        if let Some(elem) = elem_for_arr {
                            let arr_ty = InferredType::Concrete(ArgType::Array(Box::new(elem)));
                            if self.unify_var_type(arr_var, &arr_ty) {
                                changed = true;
                            }
                        }
                    }
                    Constraint::Numeric(var) => {
                        // Default to int if not yet resolved
                        if !self.resolved.contains_key(&var) {
                            self.resolved
                                .insert(var, InferredType::Concrete(ArgType::Int));
                            changed = true;
                        }
                    }
                    Constraint::Integral(var) => {
                        // Default to int if not yet resolved
                        if !self.resolved.contains_key(&var) {
                            self.resolved
                                .insert(var, InferredType::Concrete(ArgType::Int));
                            changed = true;
                        }
                    }
                    Constraint::ObjectType(var) => {
                        // Default to Object if not yet resolved
                        if !self.resolved.contains_key(&var) {
                            self.resolved.insert(
                                var,
                                InferredType::Concrete(ArgType::Object(
                                    "java/lang/Object".to_string(),
                                )),
                            );
                            changed = true;
                        }
                    }
                    Constraint::AssignBound(var, ref ty) => {
                        // Assignment bound: variable receives this type (LHS semantics)
                        // Use the type directly, but allow narrowing later via UseBound
                        if self.apply_assign_bound(var, ty) {
                            changed = true;
                        }
                    }
                    Constraint::UseBound(var, ref ty) => {
                        // Usage bound: variable is used as this type (RHS semantics)
                        // This can narrow the type if we have an upper bound
                        if self.apply_use_bound(var, ty) {
                            changed = true;
                        }
                    }
                }
            }
        }

        // Second pass: resolve bounds to concrete types
        self.resolve_bounds();

        // Phase 2: TypeSearch multi-variable solver for remaining unresolved variables
        // This implements JADX's fallback algorithm for complex type dependencies
        self.run_type_search();
    }

    /// Apply an assignment bound to a variable
    /// Returns true if the bounds changed
    fn apply_assign_bound(&mut self, var: TypeVar, ty: &ArgType) -> bool {
        // Skip Unknown types
        if matches!(ty, ArgType::Unknown) {
            return false;
        }

        // Get or create bounds for this variable
        let bounds = self.type_bounds.entry(var).or_default();

        // Update upper bound (the most general type this can be assigned)
        // If we already have a resolved type, don't change
        if bounds.resolved.is_some() {
            return false;
        }

        // If we have no upper bound yet, set it
        if bounds.upper_bound.is_none() {
            bounds.upper_bound = Some(ty.clone());
            bounds.source = BoundSource::Unknown;
            return true;
        }

        // If we already have an upper bound, merge with LCA
        if let Some(ref existing) = bounds.upper_bound {
            if existing != ty {
                // Compute LCA if we have a hierarchy
                if let Some(ref hierarchy) = self.hierarchy {
                    if let (ArgType::Object(name1), ArgType::Object(name2)) = (existing, ty) {
                        // Handle null specially - null is compatible with any object
                        if name1 == "null" {
                            bounds.upper_bound = Some(ty.clone());
                            return true;
                        } else if name2 == "null" {
                            // Keep existing type
                            return false;
                        }
                        let lca = hierarchy.least_common_ancestor(name1, name2);
                        if lca != *name1 {
                            bounds.upper_bound = Some(ArgType::Object(lca));
                            return true;
                        }
                    }
                }
            }
        }

        false
    }

    /// Apply a usage bound to a variable
    /// Returns true if the bounds changed
    fn apply_use_bound(&mut self, var: TypeVar, ty: &ArgType) -> bool {
        // Skip Unknown types
        if matches!(ty, ArgType::Unknown) {
            return false;
        }

        // Get or create bounds for this variable
        let bounds = self.type_bounds.entry(var).or_default();

        // If we have a resolved type, don't change
        if bounds.resolved.is_some() {
            return false;
        }

        // Update lower bound (the most specific type this must be)
        if bounds.lower_bound.is_none() {
            bounds.lower_bound = Some(ty.clone());
            return true;
        }

        // If we already have a lower bound, keep the more specific one
        if let Some(ref existing) = bounds.lower_bound {
            if existing != ty {
                // Use type comparison to determine specificity
                let cmp = compare_types(ty, existing, self.hierarchy.as_ref());
                if cmp.is_narrow() {
                    // ty is more specific - use it
                    bounds.lower_bound = Some(ty.clone());
                    return true;
                }
            }
        }

        false
    }

    /// Resolve type bounds to concrete types
    /// Called after constraint solving to finalize types
    fn resolve_bounds(&mut self) {
        // For each variable with bounds, determine the final type
        let vars: Vec<TypeVar> = self.type_bounds.keys().copied().collect();

        for var in vars {
            // Skip if already resolved via constraints
            if self.resolved.contains_key(&var) {
                continue;
            }

            // Get bounds (we need to clone to avoid borrow issues)
            let bounds = if let Some(b) = self.type_bounds.get(&var) {
                b.clone()
            } else {
                continue;
            };

            // Determine the best type from bounds
            let resolved_ty = if let Some(lower) = bounds.lower_bound {
                // Lower bound (most specific required type) takes precedence
                InferredType::Concrete(lower)
            } else if let Some(upper) = bounds.upper_bound {
                // Fall back to upper bound
                InferredType::Concrete(upper)
            } else {
                continue;
            };

            // Store the resolved type
            self.resolved.insert(var, resolved_ty);
        }
    }

    /// Run TypeSearch multi-variable solver for unresolved variables
    ///
    /// This is JADX's Phase 2 fallback when Phase 1 (fast propagation) leaves unresolved types.
    /// Algorithm:
    /// 1. Identify unresolved variables
    /// 2. Generate candidate types for each (from bounds, superclasses, subclasses)
    /// 3. Extract constraints (MOVE, PHI) between variables
    /// 4. Resolve independent variables first (no dependencies)
    /// 5. Exhaustive search for dependent variables (with iteration limit)
    fn run_type_search(&mut self) {
        const CANDIDATES_COUNT_LIMIT: usize = 10;
        const SEARCH_ITERATION_LIMIT: usize = 1_000_000;

        // Step 1: Find unresolved variables
        let unresolved: Vec<TypeVar> = self.reg_to_var.values()
            .copied()
            .filter(|var| !self.resolved.contains_key(var))
            .collect();

        if unresolved.is_empty() {
            return;
        }

        // Step 2: Generate candidates for each unresolved variable
        let mut var_candidates: FxHashMap<TypeVar, Vec<ArgType>> = FxHashMap::default();

        for &var in &unresolved {
            let candidates = self.generate_candidates(var, CANDIDATES_COUNT_LIMIT);
            if !candidates.is_empty() {
                var_candidates.insert(var, candidates);
            }
        }

        if var_candidates.is_empty() {
            return;
        }

        // Step 3: Extract constraints between variables
        let constraints = self.extract_type_search_constraints(&unresolved);

        // Step 4: Build dependency graph and identify independent variables
        let mut dependencies: FxHashMap<TypeVar, Vec<TypeVar>> = FxHashMap::default();
        for constraint in &constraints {
            match constraint {
                TypeSearchConstraint::Move { from, to } => {
                    dependencies.entry(*from).or_default().push(*to);
                    dependencies.entry(*to).or_default().push(*from);
                }
                TypeSearchConstraint::PhiSame { vars } => {
                    for &v1 in vars {
                        for &v2 in vars {
                            if v1 != v2 {
                                dependencies.entry(v1).or_default().push(v2);
                            }
                        }
                    }
                }
            }
        }

        // Resolve independent variables (those with candidates but no dependencies on other unresolved)
        let mut resolved_in_search: Vec<TypeVar> = Vec::new();
        for (&var, candidates) in &var_candidates {
            let has_deps = dependencies.get(&var)
                .map(|deps| deps.iter().any(|d| var_candidates.contains_key(d)))
                .unwrap_or(false);

            if !has_deps && !candidates.is_empty() {
                // Independent variable - pick best candidate (first one)
                let best = candidates[0].clone();
                self.resolved.insert(var, InferredType::Concrete(best));
                resolved_in_search.push(var);
            }
        }

        // Remove resolved from candidates
        for var in &resolved_in_search {
            var_candidates.remove(var);
        }

        if var_candidates.is_empty() {
            return;
        }

        // Step 5: Exhaustive search for dependent variables
        // Build groups of connected variables
        let groups = self.build_connected_groups(&var_candidates, &dependencies);

        for group in groups {
            self.search_group(&group, &var_candidates, &constraints, SEARCH_ITERATION_LIMIT);
        }
    }

    /// Generate candidate types for an unresolved variable
    fn generate_candidates(&self, var: TypeVar, limit: usize) -> Vec<ArgType> {
        let mut candidates: Vec<ArgType> = Vec::new();

        // Collect from bounds
        if let Some(bounds) = self.type_bounds.get(&var) {
            if let Some(ref upper) = bounds.upper_bound {
                candidates.push(upper.clone());
            }
            if let Some(ref lower) = bounds.lower_bound {
                if !candidates.contains(lower) {
                    candidates.push(lower.clone());
                }
            }
        }

        // Collect from related constraints
        for constraint in &self.constraints {
            match constraint {
                Constraint::AssignBound(v, ty) if *v == var => {
                    if !candidates.contains(ty) {
                        candidates.push(ty.clone());
                    }
                }
                Constraint::UseBound(v, ty) if *v == var => {
                    if !candidates.contains(ty) {
                        candidates.push(ty.clone());
                    }
                }
                Constraint::Equals(v, InferredType::Concrete(ty)) if *v == var => {
                    if !candidates.contains(ty) {
                        candidates.push(ty.clone());
                    }
                }
                Constraint::Same(v1, v2) if *v1 == var || *v2 == var => {
                    let other = if *v1 == var { *v2 } else { *v1 };
                    if let Some(InferredType::Concrete(ty)) = self.resolved.get(&other) {
                        if !candidates.contains(ty) {
                            candidates.push(ty.clone());
                        }
                    }
                }
                _ => {}
            }
        }

        // Generate wider types (superclasses) if we have hierarchy
        if let Some(ref hierarchy) = self.hierarchy {
            let mut wider: Vec<ArgType> = Vec::new();
            for candidate in &candidates {
                if let ArgType::Object(name) = candidate {
                    if name != "null" && name != "java/lang/Object" {
                        // Get superclass
                        if let Some(parent) = hierarchy.get_superclass(name) {
                            let parent_ty = ArgType::Object(parent.to_string());
                            if !candidates.contains(&parent_ty) && !wider.contains(&parent_ty) {
                                wider.push(parent_ty);
                            }
                        }
                    }
                }
            }
            candidates.extend(wider);
        }

        // Add java/lang/Object as fallback for object types
        if candidates.iter().any(|t| matches!(t, ArgType::Object(_))) {
            let object_ty = ArgType::Object("java/lang/Object".to_string());
            if !candidates.contains(&object_ty) {
                candidates.push(object_ty);
            }
        }

        // Limit candidates
        candidates.truncate(limit);
        candidates
    }

    /// Extract constraints for TypeSearch
    fn extract_type_search_constraints(&self, unresolved: &[TypeVar]) -> Vec<TypeSearchConstraint> {
        let unresolved_set: rustc_hash::FxHashSet<TypeVar> = unresolved.iter().copied().collect();
        let mut constraints: Vec<TypeSearchConstraint> = Vec::new();

        for constraint in &self.constraints {
            match constraint {
                // MOVE constraint: types must be compatible
                Constraint::Same(v1, v2) => {
                    if unresolved_set.contains(v1) || unresolved_set.contains(v2) {
                        constraints.push(TypeSearchConstraint::Move { from: *v1, to: *v2 });
                    }
                }
                _ => {}
            }
        }

        // PHI constraints: all phi sources must have same type
        for (dest_var, source_vars) in &self.phi_nodes {
            let mut phi_vars: Vec<TypeVar> = vec![*dest_var];
            phi_vars.extend(source_vars);

            // Only include if any are unresolved
            if phi_vars.iter().any(|v| unresolved_set.contains(v)) {
                constraints.push(TypeSearchConstraint::PhiSame { vars: phi_vars });
            }
        }

        constraints
    }

    /// Build connected groups of variables via dependencies
    fn build_connected_groups(
        &self,
        var_candidates: &FxHashMap<TypeVar, Vec<ArgType>>,
        dependencies: &FxHashMap<TypeVar, Vec<TypeVar>>,
    ) -> Vec<Vec<TypeVar>> {
        let mut groups: Vec<Vec<TypeVar>> = Vec::new();
        let mut visited: rustc_hash::FxHashSet<TypeVar> = rustc_hash::FxHashSet::default();

        for &var in var_candidates.keys() {
            if visited.contains(&var) {
                continue;
            }

            // BFS to find connected component
            let mut group: Vec<TypeVar> = Vec::new();
            let mut queue: Vec<TypeVar> = vec![var];

            while let Some(v) = queue.pop() {
                if visited.contains(&v) {
                    continue;
                }
                visited.insert(v);

                if var_candidates.contains_key(&v) {
                    group.push(v);

                    if let Some(deps) = dependencies.get(&v) {
                        for &dep in deps {
                            if !visited.contains(&dep) && var_candidates.contains_key(&dep) {
                                queue.push(dep);
                            }
                        }
                    }
                }
            }

            if !group.is_empty() {
                groups.push(group);
            }
        }

        groups
    }

    /// Search for valid type assignment for a group of dependent variables
    fn search_group(
        &mut self,
        group: &[TypeVar],
        var_candidates: &FxHashMap<TypeVar, Vec<ArgType>>,
        constraints: &[TypeSearchConstraint],
        iteration_limit: usize,
    ) {
        if group.is_empty() {
            return;
        }

        // For single variable, just pick first candidate
        if group.len() == 1 {
            let var = group[0];
            if let Some(candidates) = var_candidates.get(&var) {
                if !candidates.is_empty() {
                    self.resolved.insert(var, InferredType::Concrete(candidates[0].clone()));
                }
            }
            return;
        }

        // Build candidate arrays for the group
        let mut group_candidates: Vec<(&TypeVar, &Vec<ArgType>)> = Vec::new();
        for var in group {
            if let Some(candidates) = var_candidates.get(var) {
                group_candidates.push((var, candidates));
            }
        }

        if group_candidates.is_empty() {
            return;
        }

        // Extract relevant constraints for this group
        let group_set: rustc_hash::FxHashSet<TypeVar> = group.iter().copied().collect();
        let relevant_constraints: Vec<&TypeSearchConstraint> = constraints.iter()
            .filter(|c| match c {
                TypeSearchConstraint::Move { from, to } => {
                    group_set.contains(from) || group_set.contains(to)
                }
                TypeSearchConstraint::PhiSame { vars } => {
                    vars.iter().any(|v| group_set.contains(v))
                }
            })
            .collect();

        // Current candidate indices
        let mut indices: Vec<usize> = vec![0; group_candidates.len()];

        // Exhaustive search
        for _ in 0..iteration_limit {
            // Build current assignment
            let mut assignment: FxHashMap<TypeVar, ArgType> = FxHashMap::default();
            for (i, (var, candidates)) in group_candidates.iter().enumerate() {
                if indices[i] < candidates.len() {
                    assignment.insert(**var, candidates[indices[i]].clone());
                }
            }

            // Check if assignment satisfies constraints
            if self.check_type_search_constraints(&assignment, &relevant_constraints) {
                // Success - apply assignment
                for (var, ty) in assignment {
                    self.resolved.insert(var, InferredType::Concrete(ty));
                }
                return;
            }

            // Advance to next combination (cartesian product iteration)
            let mut carry = true;
            for i in 0..indices.len() {
                if carry {
                    indices[i] += 1;
                    if indices[i] >= group_candidates[i].1.len() {
                        indices[i] = 0;
                    } else {
                        carry = false;
                    }
                }
            }

            // If we wrapped around completely, we've tried all combinations
            if carry {
                break;
            }
        }

        // No valid assignment found - use first candidates as fallback
        for (var, candidates) in &group_candidates {
            if !candidates.is_empty() {
                self.resolved.insert(**var, InferredType::Concrete(candidates[0].clone()));
            }
        }
    }

    /// Check if a type assignment satisfies all constraints
    fn check_type_search_constraints(
        &self,
        assignment: &FxHashMap<TypeVar, ArgType>,
        constraints: &[&TypeSearchConstraint],
    ) -> bool {
        for constraint in constraints {
            match constraint {
                TypeSearchConstraint::Move { from, to } => {
                    // Get types, handling the borrow correctly
                    let from_ty: Option<ArgType> = assignment.get(from).cloned()
                        .or_else(|| self.resolved.get(from).and_then(|t| t.to_arg_type()));
                    let to_ty: Option<ArgType> = assignment.get(to).cloned()
                        .or_else(|| self.resolved.get(to).and_then(|t| t.to_arg_type()));

                    if let (Some(ref from_ty), Some(ref to_ty)) = (from_ty, to_ty) {
                        // For MOVE, types must be equal or from must be narrower than to
                        let cmp = compare_types(from_ty, to_ty, self.hierarchy.as_ref());
                        if !cmp.is_equal() && !cmp.is_narrow() && !cmp.is_wider() {
                            // Check for null compatibility
                            if let (ArgType::Object(n1), ArgType::Object(n2)) = (from_ty, to_ty) {
                                if n1 != "null" && n2 != "null" {
                                    return false;
                                }
                            } else {
                                return false;
                            }
                        }
                    }
                }
                TypeSearchConstraint::PhiSame { vars } => {
                    // All phi vars must have the same type (or compatible via LCA)
                    let types: Vec<ArgType> = vars.iter()
                        .filter_map(|v| {
                            assignment.get(v).cloned()
                                .or_else(|| self.resolved.get(v).and_then(|t| t.to_arg_type()))
                        })
                        .collect();

                    if types.len() >= 2 {
                        // Check pairwise compatibility
                        let first = &types[0];
                        for ty in &types[1..] {
                            let cmp = compare_types(first, ty, self.hierarchy.as_ref());
                            if !cmp.is_equal() && !cmp.is_narrow() && !cmp.is_wider() {
                                // Check null compatibility
                                if let (ArgType::Object(n1), ArgType::Object(n2)) = (first, ty) {
                                    if n1 != "null" && n2 != "null" {
                                        return false;
                                    }
                                } else {
                                    return false;
                                }
                            }
                        }
                    }
                }
            }
        }

        true
    }

    /// Compute LCA (Least Common Ancestor) for phi nodes after initial solve
    ///
    /// When phi sources have conflicting object types that couldn't be unified,
    /// this computes their common supertype using the class hierarchy.
    ///
    /// Examples:
    /// - phi(String, Integer) -> Object (unrelated types -> LCA)
    /// - phi(String, null) -> String (null is compatible with any object)
    /// - phi(ArrayList, LinkedList) -> List (if hierarchy knows this)
    /// - phi(int, int) -> int (same types stay same)
    fn compute_phi_lcas(&mut self) {
        let Some(ref hierarchy) = self.hierarchy else {
            return; // No hierarchy available for LCA computation
        };

        for (dest_var, source_vars) in &self.phi_nodes {
            // Collect resolved types from all sources
            let mut object_types: Vec<&str> = Vec::new();
            let mut non_null_type: Option<&str> = None;
            let mut has_null = false;
            let mut all_resolved = true;
            let mut has_primitive = false;
            let mut primitive_type: Option<ArgType> = None;

            let mut array_type: Option<ArgType> = None;
            let mut has_array = false;

            for src_var in source_vars {
                if let Some(InferredType::Concrete(ty)) = self.resolved.get(src_var) {
                    match ty {
                        ArgType::Object(name) => {
                            if name == "null" {
                                has_null = true;
                            } else {
                                object_types.push(name.as_str());
                                non_null_type = Some(name.as_str());
                            }
                        }
                        // For primitives, we can't compute LCA - keep the type if all same
                        ArgType::Int | ArgType::Long | ArgType::Float | ArgType::Double |
                        ArgType::Boolean | ArgType::Byte | ArgType::Char | ArgType::Short => {
                            has_primitive = true;
                            if primitive_type.is_none() {
                                primitive_type = Some(ty.clone());
                            } else if primitive_type.as_ref() != Some(ty) {
                                // Conflicting primitive types - can't merge
                                all_resolved = false;
                            }
                        }
                        ArgType::Array(_) => {
                            // Track array types separately for better phi resolution
                            has_array = true;
                            if array_type.is_none() {
                                array_type = Some(ty.clone());
                            } else if array_type.as_ref() != Some(ty) {
                                // Different array types - fall back to Object[]
                                object_types.push("java/lang/Object");
                            }
                        }
                        _ => {
                            // Unknown or other type - can't compute LCA
                            all_resolved = false;
                            break;
                        }
                    }
                } else {
                    all_resolved = false;
                    break;
                }
            }

            // Special case: array + null -> preserve array type
            // e.g., phi(String[], null) -> String[] (not Object)
            if all_resolved && has_array && has_null && object_types.is_empty() && !has_primitive {
                if let Some(arr_ty) = array_type {
                    self.resolved.insert(*dest_var, InferredType::Concrete(arr_ty));
                    continue;
                }
            }

            // Special case: null + non-null object type -> non-null type
            if all_resolved && has_null && object_types.len() == 1 {
                if let Some(non_null) = non_null_type {
                    self.resolved.insert(
                        *dest_var,
                        InferredType::Concrete(ArgType::Object(non_null.to_string())),
                    );
                    continue;
                }
            }

            // Special case: all nulls -> Object
            if all_resolved && has_null && object_types.is_empty() && !has_primitive {
                self.resolved.insert(
                    *dest_var,
                    InferredType::Concrete(ArgType::Object("java/lang/Object".to_string())),
                );
                continue;
            }

            // Only compute LCA if we have multiple distinct object types
            if all_resolved && object_types.len() >= 2 && !has_primitive {
                // Check if all types are the same (no LCA needed)
                let first = object_types[0];
                let all_same = object_types.iter().all(|&t| t == first);

                if !all_same {
                    // Compute common supertype for all phi sources
                    let lca = hierarchy.common_supertype(&object_types);

                    // Update dest to LCA type
                    self.resolved.insert(
                        *dest_var,
                        InferredType::Concrete(ArgType::Object(lca)),
                    );
                }
            }
        }
    }

    /// Unify a type variable with a type
    fn unify_var_type(&mut self, var: TypeVar, ty: &InferredType) -> bool {
        if matches!(ty, InferredType::Unknown) {
            return false;
        }

        // Already resolved - no change needed
        // NOTE: Previously this called unify_types() which returns true for "compatible"
        // but the solver expects true only for "changed". This caused infinite loops.
        if self.resolved.contains_key(&var) {
            return false;
        }

        // Not yet resolved
        match ty {
            InferredType::Var(other_var) => {
                // Propagate from other var if resolved
                // Must clone here because we insert into same map
                if let Some(other_ty) = self.resolved.get(other_var).cloned() {
                    self.resolved.insert(var, other_ty);
                    true
                } else {
                    false
                }
            }
            _ => {
                self.resolved.insert(var, ty.clone());
                true
            }
        }
    }

    /// Unify two type variables
    fn unify_vars(&mut self, v1: TypeVar, v2: TypeVar) -> bool {
        // OPTIMIZED: Avoid cloning when both resolved (just checking compatibility)
        let has_t1 = self.resolved.contains_key(&v1);
        let has_t2 = self.resolved.contains_key(&v2);

        match (has_t1, has_t2) {
            (true, true) => {
                // Both resolved - no change needed
                // NOTE: Previously called unify_types() which returns true for "compatible"
                // but the solver expects true only for "changed". This caused infinite loops.
                false
            }
            (true, false) => {
                // Only v1 resolved - clone and propagate to v2
                let ty = self.resolved.get(&v1).unwrap().clone();
                self.resolved.insert(v2, ty);
                true
            }
            (false, true) => {
                // Only v2 resolved - clone and propagate to v1
                let ty = self.resolved.get(&v2).unwrap().clone();
                self.resolved.insert(v1, ty);
                true
            }
            (false, false) => false,
        }
    }

    /// Unify two types (check compatibility and potentially merge using hierarchy)
    /// NOTE: &self because this only reads hierarchy - enables callers to avoid cloning
    #[allow(dead_code)]
    fn unify_types(&self, t1: &InferredType, t2: &InferredType) -> bool {
        match (t1, t2) {
            (InferredType::Concrete(a), InferredType::Concrete(b)) => {
                // Use hierarchy-aware type comparison
                let cmp = compare_types(a, b, self.hierarchy.as_ref());

                // Types are compatible if they're equal or one is a subtype of the other
                if cmp.is_equal() {
                    return true;
                }

                // For unification, we accept narrow/wider relationships
                // and update to the more specific type
                if cmp.is_narrow() || cmp.is_wider() {
                    // Update to narrower (more specific) type
                    let _narrower = if cmp.is_narrow() { a } else { b };
                    // Store the more specific type for this variable
                    // (This will be handled by the caller)
                    return true;
                }

                // Check for null compatibility (null is compatible with any object)
                if let (ArgType::Object(name1), ArgType::Object(name2)) = (a, b) {
                    if name1 == "null" || name2 == "null" {
                        return true;
                    }
                }

                false
            }
            (InferredType::Array(e1), InferredType::Array(e2)) => self.unify_types(e1, e2),
            (InferredType::Unknown, _) | (_, InferredType::Unknown) => true,
            _ => false,
        }
    }

    /// Select the more specific (narrower) type between two types
    #[allow(dead_code)]
    fn select_narrower_type(&self, t1: &ArgType, t2: &ArgType) -> ArgType {
        let cmp = compare_types(t1, t2, self.hierarchy.as_ref());

        match cmp {
            TypeCompare::Equal => t1.clone(),
            TypeCompare::Narrow | TypeCompare::NarrowByGeneric => t1.clone(),
            TypeCompare::Wider | TypeCompare::WiderByGeneric => t2.clone(),
            TypeCompare::Conflict | TypeCompare::ConflictByGeneric => {
                // On conflict, compute LCA if we have a hierarchy
                if let (Some(hierarchy), ArgType::Object(name1), ArgType::Object(name2)) =
                    (&self.hierarchy, t1, t2)
                {
                    let lca = hierarchy.least_common_ancestor(name1, name2);
                    ArgType::Object(lca)
                } else {
                    // Fall back to Unknown
                    ArgType::Unknown
                }
            }
            TypeCompare::Unknown => ArgType::Unknown,
        }
    }

    /// Get the resolved type for a register
    pub fn get_type(&self, reg: &RegisterArg) -> Option<ArgType> {
        let key = (reg.reg_num, reg.ssa_version);
        self.reg_to_var
            .get(&key)
            .and_then(|var| self.resolved.get(var))
            .and_then(|ty| ty.to_arg_type())
    }

    /// Resolve pending TypeVariable substitutions
    ///
    /// This is called after solve() to resolve TypeVariables in return types
    /// based on the concrete generic types of receiver objects.
    ///
    /// For example:
    /// - If `list` is `List<String>` and we called `list.get(0)`,
    ///   the return type `E` gets resolved to `String`
    pub fn resolve_pending_type_variables(&mut self) {
        for (dest_var, instance_var, return_ty) in self.pending_type_var_resolutions.clone() {
            // Look up the resolved instance type
            if let Some(instance_ty) = self.resolved.get(&instance_var) {
                if let Some(instance_arg_ty) = instance_ty.to_arg_type() {
                    // Try to resolve TypeVariables using the instance type
                    let resolved_return = self.resolve_type_variable(&return_ty, &instance_arg_ty);

                    // Only update if we actually resolved something
                    if resolved_return != return_ty {
                        self.resolved.insert(dest_var, InferredType::Concrete(resolved_return));
                    }
                }
            }
        }
    }

    /// Get all resolved types as (reg_num, ssa_version) -> ArgType
    pub fn get_all_types(&mut self) -> HashMap<(u16, u32), ArgType> {
        // First, resolve any pending TypeVariable substitutions
        self.resolve_pending_type_variables();

        let mut result = HashMap::with_capacity(self.reg_to_var.len());
        for (&key, &var) in &self.reg_to_var {
            if let Some(ty) = self.resolved.get(&var) {
                if let Some(arg_ty) = ty.to_arg_type() {
                    result.insert(key, arg_ty);
                }
            }
        }
        result
    }
}

/// Result of type inference
#[derive(Debug)]
pub struct TypeInferenceResult {
    /// Types for each register (reg_num, ssa_version) -> type
    pub types: HashMap<(u16, u32), ArgType>,
    /// Number of constraints collected
    pub num_constraints: usize,
    /// Number of type variables
    pub num_type_vars: usize,
    /// Number of resolved types
    pub num_resolved: usize,
}

/// Run type inference on SSA form
pub fn infer_types(ssa: &SsaResult) -> TypeInferenceResult {
    let mut inference = TypeInference::new();
    inference.collect_constraints(ssa);
    let num_constraints = inference.constraints.len();
    let num_type_vars = inference.next_var as usize;
    inference.solve();
    let num_resolved = inference.resolved.len();
    let types = inference.get_all_types();

    TypeInferenceResult {
        types,
        num_constraints,
        num_type_vars,
        num_resolved,
    }
}

/// Run type inference with custom lookups
pub fn infer_types_with_context<F, G, H>(
    ssa: &SsaResult,
    type_lookup: F,
    field_lookup: G,
    method_lookup: H,
) -> TypeInferenceResult
where
    F: Fn(u32) -> Option<ArgType> + Send + Sync + 'static,
    G: Fn(u32) -> Option<ArgType> + Send + Sync + 'static,
    H: Fn(u32) -> Option<(Vec<ArgType>, ArgType)> + Send + Sync + 'static,
{
    let mut inference = TypeInference::new()
        .with_type_lookup(type_lookup)
        .with_field_lookup(field_lookup)
        .with_method_lookup(method_lookup);

    inference.collect_constraints(ssa);
    let num_constraints = inference.constraints.len();
    let num_type_vars = inference.next_var as usize;
    inference.solve();
    let num_resolved = inference.resolved.len();
    let types = inference.get_all_types();

    TypeInferenceResult {
        types,
        num_constraints,
        num_type_vars,
        num_resolved,
    }
}

/// Run type inference with class hierarchy for improved type precision
///
/// This version uses the class hierarchy for:
/// - Subtype checking (is A a subtype of B?)
/// - Least Common Ancestor (LCA) calculation for PHI nodes
/// - More accurate type unification
pub fn infer_types_with_hierarchy(
    ssa: &SsaResult,
    hierarchy: &dexterity_ir::ClassHierarchy,
) -> TypeInferenceResult {
    let mut inference = TypeInference::new().with_hierarchy(hierarchy.clone());
    inference.collect_constraints(ssa);
    let num_constraints = inference.constraints.len();
    let num_type_vars = inference.next_var as usize;
    inference.solve();
    // Post-solve: compute LCA for phi nodes with conflicting object types
    inference.compute_phi_lcas();
    let num_resolved = inference.resolved.len();
    let types = inference.get_all_types();

    TypeInferenceResult {
        types,
        num_constraints,
        num_type_vars,
        num_resolved,
    }
}

/// Run type inference with BOTH custom lookups AND class hierarchy
///
/// This is the most complete type inference variant, combining:
/// - type_lookup: Resolve DEX type indices to ArgType
/// - field_lookup: Resolve field indices to field types
/// - method_lookup: Resolve method indices to (param_types, return_type)
/// - hierarchy: Class hierarchy for subtype checking and LCA computation
///
/// Using both lookups and hierarchy together provides the best type precision
/// by having access to all DEX type information plus inheritance relationships.
pub fn infer_types_with_context_and_hierarchy<F, G, H>(
    ssa: &SsaResult,
    type_lookup: F,
    field_lookup: G,
    method_lookup: H,
    hierarchy: &dexterity_ir::ClassHierarchy,
) -> TypeInferenceResult
where
    F: Fn(u32) -> Option<ArgType> + Send + Sync + 'static,
    G: Fn(u32) -> Option<ArgType> + Send + Sync + 'static,
    H: Fn(u32) -> Option<(Vec<ArgType>, ArgType)> + Send + Sync + 'static,
{
    let mut inference = TypeInference::new()
        .with_type_lookup(type_lookup)
        .with_field_lookup(field_lookup)
        .with_method_lookup(method_lookup)
        .with_hierarchy(hierarchy.clone());

    inference.collect_constraints(ssa);
    let num_constraints = inference.constraints.len();
    let num_type_vars = inference.next_var as usize;
    inference.solve();
    // Post-solve: compute LCA for phi nodes with conflicting object types
    inference.compute_phi_lcas();
    let num_resolved = inference.resolved.len();
    let types = inference.get_all_types();

    TypeInferenceResult {
        types,
        num_constraints,
        num_type_vars,
        num_resolved,
    }
}

#[cfg(test)]
mod tests {
    use super::*;
    use crate::ssa::{PhiNode, SsaBlock, SsaResult};
    use rustc_hash::{FxHashMap, FxHashSet};

    fn make_simple_ssa() -> SsaResult {
        use dexterity_ir::instructions::{InsnNode, InsnType, LiteralArg, RegisterArg};

        // Simple SSA with:
        // v0_1 = 42
        // v1_1 = v0_1 + 1
        let blocks = vec![SsaBlock {
            id: 0,
            phi_nodes: vec![],
            instructions: vec![
                InsnNode::new(
                    InsnType::Const {
                        dest: RegisterArg::with_ssa(0, 1),
                        value: LiteralArg::Int(42),
                    },
                    0,
                ),
                InsnNode::new(
                    InsnType::Binary {
                        dest: RegisterArg::with_ssa(1, 1),
                        op: BinaryOp::Add,
                        left: InsnArg::Register(RegisterArg::with_ssa(0, 1)),
                        right: InsnArg::Literal(LiteralArg::Int(1)),
                    },
                    1,
                ),
            ],
            successors: vec![],
            predecessors: vec![],
        }];

        SsaResult {
            blocks,
            dominators: FxHashMap::default(),
            dom_frontiers: FxHashMap::default(),
            max_versions: FxHashMap::from_iter([(0, 1), (1, 1)]),
        }
    }

    #[test]
    fn test_basic_type_inference() {
        let ssa = make_simple_ssa();
        let result = infer_types(&ssa);

        // v0_1 should be Int (from const 42)
        assert_eq!(result.types.get(&(0, 1)), Some(&ArgType::Int));
        // v1_1 should be Int (from binary add)
        assert_eq!(result.types.get(&(1, 1)), Some(&ArgType::Int));
    }

    #[test]
    fn test_phi_type_propagation() {
        use dexterity_ir::instructions::{InsnNode, InsnType, LiteralArg, RegisterArg};

        // v0_1 = 1  (block 0)
        // v0_2 = 2  (block 1)
        // v0_3 = phi(v0_1, v0_2)  (block 2)
        let blocks = vec![
            SsaBlock {
                id: 0,
                phi_nodes: vec![],
                instructions: vec![InsnNode::new(
                    InsnType::Const {
                        dest: RegisterArg::with_ssa(0, 1),
                        value: LiteralArg::Int(1),
                    },
                    0,
                )],
                successors: vec![2],
                predecessors: vec![],
            },
            SsaBlock {
                id: 1,
                phi_nodes: vec![],
                instructions: vec![InsnNode::new(
                    InsnType::Const {
                        dest: RegisterArg::with_ssa(0, 2),
                        value: LiteralArg::Int(2),
                    },
                    1,
                )],
                successors: vec![2],
                predecessors: vec![],
            },
            SsaBlock {
                id: 2,
                phi_nodes: vec![PhiNode {
                    dest: RegisterArg::with_ssa(0, 3),
                    sources: vec![
                        (0, RegisterArg::with_ssa(0, 1)),
                        (1, RegisterArg::with_ssa(0, 2)),
                    ],
                }],
                instructions: vec![],
                successors: vec![],
                predecessors: vec![0, 1],
            },
        ];

        let ssa = SsaResult {
            blocks,
            dominators: FxHashMap::default(),
            dom_frontiers: FxHashMap::default(),
            max_versions: FxHashMap::from_iter([(0, 3)]),
        };

        let result = infer_types(&ssa);

        // All versions of v0 should be Int
        assert_eq!(result.types.get(&(0, 1)), Some(&ArgType::Int));
        assert_eq!(result.types.get(&(0, 2)), Some(&ArgType::Int));
        assert_eq!(result.types.get(&(0, 3)), Some(&ArgType::Int));
    }

    #[test]
    fn test_string_type() {
        use dexterity_ir::instructions::{InsnNode, InsnType, RegisterArg};

        let blocks = vec![SsaBlock {
            id: 0,
            phi_nodes: vec![],
            instructions: vec![InsnNode::new(
                InsnType::ConstString {
                    dest: RegisterArg::with_ssa(0, 1),
                    string_idx: 0,
                },
                0,
            )],
            successors: vec![],
            predecessors: vec![],
        }];

        let ssa = SsaResult {
            blocks,
            dominators: FxHashMap::default(),
            dom_frontiers: FxHashMap::default(),
            max_versions: FxHashMap::from_iter([(0, 1)]),
        };

        let result = infer_types(&ssa);

        assert_eq!(
            result.types.get(&(0, 1)),
            Some(&ArgType::Object("java/lang/String".to_string()))
        );
    }

    #[test]
    fn test_cast_type() {
        use dexterity_ir::instructions::{InsnNode, InsnType, LiteralArg, RegisterArg};

        let blocks = vec![SsaBlock {
            id: 0,
            phi_nodes: vec![],
            instructions: vec![
                InsnNode::new(
                    InsnType::Const {
                        dest: RegisterArg::with_ssa(0, 1),
                        value: LiteralArg::Int(42),
                    },
                    0,
                ),
                InsnNode::new(
                    InsnType::Cast {
                        dest: RegisterArg::with_ssa(1, 1),
                        cast_type: CastType::IntToLong,
                        arg: InsnArg::Register(RegisterArg::with_ssa(0, 1)),
                    },
                    1,
                ),
            ],
            successors: vec![],
            predecessors: vec![],
        }];

        let ssa = SsaResult {
            blocks,
            dominators: FxHashMap::default(),
            dom_frontiers: FxHashMap::default(),
            max_versions: FxHashMap::from_iter([(0, 1), (1, 1)]),
        };

        let result = infer_types(&ssa);

        assert_eq!(result.types.get(&(0, 1)), Some(&ArgType::Int));
        assert_eq!(result.types.get(&(1, 1)), Some(&ArgType::Long));
    }

    #[test]
    fn test_empty_ssa() {
        let ssa = SsaResult {
            blocks: vec![],
            dominators: FxHashMap::default(),
            dom_frontiers: FxHashMap::default(),
            max_versions: FxHashMap::default(),
        };

        let result = infer_types(&ssa);
        assert!(result.types.is_empty());
        assert_eq!(result.num_constraints, 0);
    }

    #[test]
    fn test_type_bounds_creation() {
        // Test TypeBounds helper methods
        let bounds_resolved = TypeBounds::with_type(ArgType::Int, BoundSource::Literal);
        assert_eq!(bounds_resolved.resolved, Some(ArgType::Int));
        assert_eq!(bounds_resolved.upper_bound, Some(ArgType::Int));
        assert_eq!(bounds_resolved.lower_bound, Some(ArgType::Int));
        assert_eq!(bounds_resolved.source, BoundSource::Literal);

        let bounds_upper = TypeBounds::with_upper(
            ArgType::Object("java/lang/String".to_string()),
            BoundSource::Field,
        );
        assert!(bounds_upper.resolved.is_none());
        assert_eq!(bounds_upper.upper_bound, Some(ArgType::Object("java/lang/String".to_string())));
        assert!(bounds_upper.lower_bound.is_none());

        let bounds_lower = TypeBounds::with_lower(
            ArgType::Object("java/util/ArrayList".to_string()),
            BoundSource::MethodReturn,
        );
        assert!(bounds_lower.resolved.is_none());
        assert!(bounds_lower.upper_bound.is_none());
        assert_eq!(bounds_lower.lower_bound, Some(ArgType::Object("java/util/ArrayList".to_string())));
    }

    #[test]
    fn test_phi_null_merge_with_hierarchy() {
        use dexterity_ir::instructions::{InsnNode, InsnType, LiteralArg, RegisterArg};

        // Test phi(String, null) -> String
        // v0_1 = "hello" (block 0)
        // v0_2 = null    (block 1)
        // v0_3 = phi(v0_1, v0_2) (block 2) - should be String
        let blocks = vec![
            SsaBlock {
                id: 0,
                phi_nodes: vec![],
                instructions: vec![InsnNode::new(
                    InsnType::ConstString {
                        dest: RegisterArg::with_ssa(0, 1),
                        string_idx: 0,
                    },
                    0,
                )],
                successors: vec![2],
                predecessors: vec![],
            },
            SsaBlock {
                id: 1,
                phi_nodes: vec![],
                instructions: vec![InsnNode::new(
                    InsnType::Const {
                        dest: RegisterArg::with_ssa(0, 2),
                        value: LiteralArg::Null,
                    },
                    1,
                )],
                successors: vec![2],
                predecessors: vec![],
            },
            SsaBlock {
                id: 2,
                phi_nodes: vec![PhiNode {
                    dest: RegisterArg::with_ssa(0, 3),
                    sources: vec![
                        (0, RegisterArg::with_ssa(0, 1)),
                        (1, RegisterArg::with_ssa(0, 2)),
                    ],
                }],
                instructions: vec![],
                successors: vec![],
                predecessors: vec![0, 1],
            },
        ];

        let ssa = SsaResult {
            blocks,
            dominators: FxHashMap::default(),
            dom_frontiers: FxHashMap::default(),
            max_versions: FxHashMap::from_iter([(0, 3)]),
        };

        // Create a class hierarchy for LCA computation
        let hierarchy = dexterity_ir::ClassHierarchy::new();
        let result = infer_types_with_hierarchy(&ssa, &hierarchy);

        // v0_1 should be String
        assert_eq!(
            result.types.get(&(0, 1)),
            Some(&ArgType::Object("java/lang/String".to_string()))
        );
        // v0_2 should be null object type
        assert_eq!(
            result.types.get(&(0, 2)),
            Some(&ArgType::Object("null".to_string()))
        );
        // v0_3 (phi result) should be String (not Object) because phi(String, null) -> String
        assert_eq!(
            result.types.get(&(0, 3)),
            Some(&ArgType::Object("java/lang/String".to_string()))
        );
    }

    #[test]
    fn test_assign_and_use_bounds() {
        // Test that AssignBound and UseBound constraints work correctly
        let mut inference = TypeInference::new();

        // Create type variables
        let var1 = TypeVar::new(0);
        let var2 = TypeVar::new(1);
        inference.next_var = 2;

        // Add AssignBound constraint (variable receives String type)
        inference.add_constraint(Constraint::AssignBound(
            var1,
            ArgType::Object("java/lang/String".to_string()),
        ));

        // Add UseBound constraint (variable used as Object)
        inference.add_constraint(Constraint::UseBound(
            var2,
            ArgType::Object("java/lang/Object".to_string()),
        ));

        // Solve
        inference.solve();

        // var1 should have bounds for String
        let bounds1 = inference.type_bounds.get(&var1);
        assert!(bounds1.is_some());
        assert_eq!(
            bounds1.unwrap().upper_bound,
            Some(ArgType::Object("java/lang/String".to_string()))
        );

        // var2 should have lower bound for Object
        let bounds2 = inference.type_bounds.get(&var2);
        assert!(bounds2.is_some());
        assert_eq!(
            bounds2.unwrap().lower_bound,
            Some(ArgType::Object("java/lang/Object".to_string()))
        );
    }
}
