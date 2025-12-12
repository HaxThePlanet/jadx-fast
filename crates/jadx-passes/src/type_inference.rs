//! Type inference pass
//!
//! This pass infers types for all registers in SSA form using constraint-based type inference.
//! The algorithm works in three phases:
//! 1. Collect constraints from instructions (e.g., x = 5 implies x: int)
//! 2. Propagate constraints through phi nodes and assignments
//! 3. Resolve type variables to concrete types using unification

use std::collections::HashMap;

use jadx_ir::instructions::{
    ArrayElemType, BinaryOp, CastType, CompareOp, InsnArg, InsnType, LiteralArg, RegisterArg,
    UnaryOp,
};
use jadx_ir::types::ArgType;

use crate::ssa::{SsaBlock, SsaResult};

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
    reg_to_var: HashMap<(u16, u32), TypeVar>,
    /// Collected constraints
    constraints: Vec<Constraint>,
    /// Resolved types (TypeVar -> InferredType)
    resolved: HashMap<TypeVar, InferredType>,
    /// Type lookup table for DEX indices (provided externally)
    type_lookup: Option<Box<dyn Fn(u32) -> Option<ArgType> + Send + Sync>>,
    /// Field type lookup (field_idx -> field type)
    field_lookup: Option<Box<dyn Fn(u32) -> Option<ArgType> + Send + Sync>>,
    /// Method return type lookup (method_idx -> return type)
    method_lookup: Option<Box<dyn Fn(u32) -> Option<(Vec<ArgType>, ArgType)> + Send + Sync>>,
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
            reg_to_var: HashMap::new(),
            constraints: Vec::new(),
            resolved: HashMap::new(),
            type_lookup: None,
            field_lookup: None,
            method_lookup: None,
        }
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
            InsnArg::Register(reg) => Some(self.get_or_create_var(reg)),
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
                // Type comes from previous invoke - handled separately
                let dest_var = self.get_or_create_var(dest);
                // Mark as needing resolution from invoke context
                self.add_constraint(Constraint::Equals(dest_var, InferredType::Unknown));
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
                // Array constraint
                if let Some(arr_var) = self.var_for_arg(array) {
                    self.add_constraint(Constraint::ArrayOf(arr_var, dest_var));
                }
                // Also use elem_type hint
                let hint = match elem_type {
                    ArrayElemType::Int => ArgType::Int,
                    ArrayElemType::Wide => ArgType::Long, // Could be double
                    ArrayElemType::Object => ArgType::Unknown,
                    ArrayElemType::Boolean => ArgType::Boolean,
                    ArrayElemType::Byte => ArgType::Byte,
                    ArrayElemType::Char => ArgType::Char,
                    ArrayElemType::Short => ArgType::Short,
                };
                if hint != ArgType::Unknown {
                    self.add_constraint(Constraint::Equals(
                        dest_var,
                        InferredType::Concrete(hint),
                    ));
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
                // Value type relates to array element type
                if let (Some(arr_var), Some(val_var)) =
                    (self.var_for_arg(array), self.var_for_arg(value))
                {
                    self.add_constraint(Constraint::ArrayOf(arr_var, val_var));
                }
                // Also use elem_type hint for value
                if let Some(val_var) = self.var_for_arg(value) {
                    let hint = match elem_type {
                        ArrayElemType::Int => ArgType::Int,
                        ArrayElemType::Wide => ArgType::Long,
                        ArrayElemType::Boolean => ArgType::Boolean,
                        ArrayElemType::Byte => ArgType::Byte,
                        ArrayElemType::Char => ArgType::Char,
                        ArrayElemType::Short => ArgType::Short,
                        ArrayElemType::Object => ArgType::Unknown,
                    };
                    if hint != ArgType::Unknown {
                        self.add_constraint(Constraint::Equals(
                            val_var,
                            InferredType::Concrete(hint),
                        ));
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
                // Method signature determines arg types
                if let Some(ref lookup) = self.method_lookup {
                    if let Some((param_types, _return_ty)) = lookup(*method_idx) {
                        for (arg, expected_ty) in args.iter().zip(param_types.iter()) {
                            if let Some(arg_var) = self.var_for_arg(arg) {
                                self.add_constraint(Constraint::Subtype(
                                    arg_var,
                                    InferredType::Concrete(expected_ty.clone()),
                                ));
                            }
                        }
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
                // All phi sources must have same type as dest
                for (_, src_reg) in sources {
                    let src_var = self.get_or_create_var(src_reg);
                    self.add_constraint(Constraint::Same(dest_var, src_var));
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
            | InsnType::SparseSwitch { .. } => {}
        }
    }

    /// Collect constraints from phi nodes
    fn collect_from_phi(&mut self, phi: &crate::ssa::PhiNode) {
        let dest_var = self.get_or_create_var(&phi.dest);
        for (_, src_reg) in &phi.sources {
            let src_var = self.get_or_create_var(src_reg);
            self.add_constraint(Constraint::Same(dest_var, src_var));
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
        let mut iterations = 0;
        const MAX_ITERATIONS: usize = 100;

        while changed && iterations < MAX_ITERATIONS {
            changed = false;
            iterations += 1;

            for constraint in self.constraints.clone() {
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
                        // If we know array type, infer element type
                        if let Some(arr_ty) = self.resolved.get(&arr_var).cloned() {
                            if let InferredType::Concrete(ArgType::Array(elem)) = arr_ty {
                                let elem_ty = InferredType::Concrete(*elem);
                                if self.unify_var_type(elem_var, &elem_ty) {
                                    changed = true;
                                }
                            }
                        }
                        // If we know element type, infer array type
                        if let Some(elem_ty) = self.resolved.get(&elem_var).cloned() {
                            if let InferredType::Concrete(elem) = elem_ty {
                                let arr_ty =
                                    InferredType::Concrete(ArgType::Array(Box::new(elem)));
                                if self.unify_var_type(arr_var, &arr_ty) {
                                    changed = true;
                                }
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

    /// Unify a type variable with a type
    fn unify_var_type(&mut self, var: TypeVar, ty: &InferredType) -> bool {
        if matches!(ty, InferredType::Unknown) {
            return false;
        }

        if let Some(existing) = self.resolved.get(&var).cloned() {
            // Already resolved - check compatibility
            self.unify_types(&existing, ty)
        } else {
            // Not yet resolved
            match ty {
                InferredType::Var(other_var) => {
                    // Propagate from other var if resolved
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
    }

    /// Unify two type variables
    fn unify_vars(&mut self, v1: TypeVar, v2: TypeVar) -> bool {
        let t1 = self.resolved.get(&v1).cloned();
        let t2 = self.resolved.get(&v2).cloned();

        match (t1, t2) {
            (Some(ty1), Some(ty2)) => self.unify_types(&ty1, &ty2),
            (Some(ty), None) => {
                self.resolved.insert(v2, ty);
                true
            }
            (None, Some(ty)) => {
                self.resolved.insert(v1, ty);
                true
            }
            (None, None) => false,
        }
    }

    /// Unify two types (check compatibility and potentially merge)
    fn unify_types(&mut self, t1: &InferredType, t2: &InferredType) -> bool {
        match (t1, t2) {
            (InferredType::Concrete(a), InferredType::Concrete(b)) => {
                // Types must be compatible
                a == b || Self::types_compatible(a, b)
            }
            (InferredType::Array(e1), InferredType::Array(e2)) => self.unify_types(e1, e2),
            (InferredType::Unknown, _) | (_, InferredType::Unknown) => true,
            _ => false,
        }
    }

    /// Check if two types are compatible for unification
    fn types_compatible(t1: &ArgType, t2: &ArgType) -> bool {
        match (t1, t2) {
            // Numeric widening
            (ArgType::Byte, ArgType::Int)
            | (ArgType::Short, ArgType::Int)
            | (ArgType::Char, ArgType::Int)
            | (ArgType::Int, ArgType::Byte)
            | (ArgType::Int, ArgType::Short)
            | (ArgType::Int, ArgType::Char) => true,
            // Object type compatibility (null compatible with any object)
            (ArgType::Object(a), ArgType::Object(b)) => a == "null" || b == "null" || a == b,
            // Array compatibility
            (ArgType::Array(e1), ArgType::Array(e2)) => Self::types_compatible(e1, e2),
            // Unknown is compatible with anything
            (ArgType::Unknown, _) | (_, ArgType::Unknown) => true,
            _ => false,
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
        let mut result = HashMap::new();
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

#[cfg(test)]
mod tests {
    use super::*;
    use crate::ssa::PhiNode;

    fn make_simple_ssa() -> SsaResult {
        use jadx_ir::instructions::{InsnNode, InsnType, LiteralArg, RegisterArg};

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
            dominators: HashMap::new(),
            dom_frontiers: HashMap::new(),
            max_versions: HashMap::from([(0, 1), (1, 1)]),
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
        use jadx_ir::instructions::{InsnNode, InsnType, LiteralArg, RegisterArg};

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
            dominators: HashMap::new(),
            dom_frontiers: HashMap::new(),
            max_versions: HashMap::from([(0, 3)]),
        };

        let result = infer_types(&ssa);

        // All versions of v0 should be Int
        assert_eq!(result.types.get(&(0, 1)), Some(&ArgType::Int));
        assert_eq!(result.types.get(&(0, 2)), Some(&ArgType::Int));
        assert_eq!(result.types.get(&(0, 3)), Some(&ArgType::Int));
    }

    #[test]
    fn test_string_type() {
        use jadx_ir::instructions::{InsnNode, InsnType, RegisterArg};

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
            dominators: HashMap::new(),
            dom_frontiers: HashMap::new(),
            max_versions: HashMap::from([(0, 1)]),
        };

        let result = infer_types(&ssa);

        assert_eq!(
            result.types.get(&(0, 1)),
            Some(&ArgType::Object("java/lang/String".to_string()))
        );
    }

    #[test]
    fn test_cast_type() {
        use jadx_ir::instructions::{InsnNode, InsnType, LiteralArg, RegisterArg};

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
            dominators: HashMap::new(),
            dom_frontiers: HashMap::new(),
            max_versions: HashMap::from([(0, 1), (1, 1)]),
        };

        let result = infer_types(&ssa);

        assert_eq!(result.types.get(&(0, 1)), Some(&ArgType::Int));
        assert_eq!(result.types.get(&(1, 1)), Some(&ArgType::Long));
    }

    #[test]
    fn test_empty_ssa() {
        let ssa = SsaResult {
            blocks: vec![],
            dominators: HashMap::new(),
            dom_frontiers: HashMap::new(),
            max_versions: HashMap::new(),
        };

        let result = infer_types(&ssa);
        assert!(result.types.is_empty());
        assert_eq!(result.num_constraints, 0);
    }
}
