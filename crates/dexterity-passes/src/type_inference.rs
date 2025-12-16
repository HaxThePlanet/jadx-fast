//! Type inference pass
//!
//! This pass infers types for all registers in SSA form using constraint-based type inference.
//! The algorithm works in three phases:
//! 1. Collect constraints from instructions (e.g., x = 5 implies x: int)
//! 2. Propagate constraints through phi nodes and assignments
//! 3. Resolve type variables to concrete types using unification

use std::collections::HashMap;
use rustc_hash::FxHashMap;

use dexterity_ir::instructions::{
    ArrayElemType, BinaryOp, CastType, CompareOp, InsnArg, InsnType, LiteralArg, RegisterArg,
    UnaryOp,
};
use dexterity_ir::types::ArgType;
use dexterity_ir::{ClassHierarchy, TypeCompare, compare_types};

use crate::ssa::SsaResult;

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
    /// Phi nodes for post-solve LCA computation: (dest_var, source_vars)
    phi_nodes: Vec<(TypeVar, Vec<TypeVar>)>,
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
            type_lookup: None,
            field_lookup: None,
            method_lookup: None,
            hierarchy: None,
            last_invoke_return: None,
            phi_nodes: Vec::new(),
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
                let return_type = self.last_invoke_return.take()
                    .map(InferredType::Concrete)
                    .unwrap_or(InferredType::Unknown);
                self.add_constraint(Constraint::Equals(dest_var, return_type));
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
                // Field type determines dest type
                if let Some(ref lookup) = self.field_lookup {
                    if let Some(field_ty) = lookup(*field_idx) {
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
                if let Some(ref lookup) = self.method_lookup {
                    if let Some((param_types, return_ty)) = lookup(*method_idx) {
                        for (arg, expected_ty) in args.iter().zip(param_types.iter()) {
                            if let Some(arg_var) = self.var_for_arg(arg) {
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

            // Control flow instructions don't produce types
            InsnType::Nop
            | InsnType::Return { .. }
            | InsnType::Throw { .. }
            | InsnType::MonitorEnter { .. }
            | InsnType::MonitorExit { .. }
            | InsnType::CheckCast { .. }
            | InsnType::FilledNewArray { .. }
            | InsnType::FillArrayData { .. }
            | InsnType::If { .. }
            | InsnType::Goto { .. }
            | InsnType::PackedSwitch { .. }
            | InsnType::SparseSwitch { .. }
            | InsnType::Break { .. }
            | InsnType::Continue { .. } => {}
        }
    }

    /// Collect constraints from phi nodes
    fn collect_from_phi(&mut self, phi: &crate::ssa::PhiNode) {
        let dest_var = self.get_or_create_var(&phi.dest);
        let mut source_vars = Vec::with_capacity(phi.sources.len());
        for (_, src_reg) in &phi.sources {
            let src_var = self.get_or_create_var(src_reg);
            self.add_constraint(Constraint::Same(dest_var, src_var));
            source_vars.push(src_var);
        }
        // Record phi node for post-solve LCA computation
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
                }
            }
        }
    }

    /// Compute LCA (Least Common Ancestor) for phi nodes after initial solve
    ///
    /// When phi sources have conflicting object types that couldn't be unified,
    /// this computes their common supertype using the class hierarchy.
    /// For example: phi(String, Integer) -> Object
    fn compute_phi_lcas(&mut self) {
        let Some(ref hierarchy) = self.hierarchy else {
            return; // No hierarchy available for LCA computation
        };

        for (dest_var, source_vars) in &self.phi_nodes {
            // Collect resolved types from all sources
            let mut object_types: Vec<&str> = Vec::new();
            let mut all_resolved = true;

            for src_var in source_vars {
                if let Some(InferredType::Concrete(ty)) = self.resolved.get(src_var) {
                    match ty {
                        ArgType::Object(name) => {
                            // Skip null - it's compatible with any object
                            if name != "null" {
                                object_types.push(name.as_str());
                            }
                        }
                        _ => {
                            // Non-object type - can't compute LCA
                            all_resolved = false;
                            break;
                        }
                    }
                } else {
                    all_resolved = false;
                    break;
                }
            }

            // Only compute LCA if we have multiple distinct object types
            if all_resolved && object_types.len() >= 2 {
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

    /// Get all resolved types as (reg_num, ssa_version) -> ArgType
    pub fn get_all_types(&self) -> HashMap<(u16, u32), ArgType> {
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
}
