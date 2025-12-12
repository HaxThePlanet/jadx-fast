//! Expression generation - converts IR instructions to Java expressions
//!
//! This module turns IR instructions into Java source code expressions.
//! For example: `Binary { op: Add, left: v0, right: v1 }` -> `"a + b"`

use std::cell::RefCell;
use std::collections::HashMap;
use std::sync::Arc;

use jadx_ir::instructions::{
    BinaryOp, CastType, IfCondition, InsnArg, InsnType,
    InvokeKind, LiteralArg, RegisterArg, UnaryOp,
};
use jadx_ir::types::ArgType;

use crate::dex_info::DexInfoProvider;

/// Expression generation context
pub struct ExprGen {
    /// Variable names: (reg_num, ssa_version) -> name
    var_names: HashMap<(u16, u32), String>,
    /// Variable types (for casting decisions)
    var_types: HashMap<(u16, u32), ArgType>,
    /// String pool for const-string (local cache)
    strings: HashMap<u32, String>,
    /// Type names for type_idx (local cache)
    type_names: HashMap<u32, String>,
    /// Field info for field_idx (local cache)
    field_info: HashMap<u32, FieldInfo>,
    /// Method info for method_idx (local cache)
    method_info: HashMap<u32, MethodInfo>,
    /// Optional DEX info provider for lazy lookups
    pub dex_provider: Option<Arc<dyn DexInfoProvider>>,
}

/// Field information
#[derive(Clone)]
pub struct FieldInfo {
    /// Simple class name (e.g., "Log") for code generation
    pub class_name: String,
    /// Internal class type (e.g., "android/util/Log") for import collection
    pub class_type: String,
    pub field_name: String,
    pub field_type: ArgType,
}

/// Method information
#[derive(Clone)]
pub struct MethodInfo {
    /// Simple class name (e.g., "Log") for code generation
    pub class_name: String,
    /// Internal class type (e.g., "android/util/Log") for import collection
    pub class_type: String,
    pub method_name: String,
    pub return_type: ArgType,
    pub param_types: Vec<ArgType>,
}

// Thread-local pool of ExprGen instances for reuse across methods
// Reduces allocation overhead by reusing HashMap capacity
thread_local! {
    static EXPR_GEN_POOL: RefCell<Vec<ExprGen>> = RefCell::new(Vec::new());
}

impl ExprGen {
    /// Create a new expression generator
    pub fn new() -> Self {
        ExprGen {
            var_names: HashMap::new(),
            var_types: HashMap::new(),
            strings: HashMap::new(),
            type_names: HashMap::new(),
            field_info: HashMap::new(),
            method_info: HashMap::new(),
            dex_provider: None,
        }
    }

    /// Create a new expression generator with a DEX info provider for lazy lookups
    pub fn with_dex_provider(dex_provider: Arc<dyn DexInfoProvider>) -> Self {
        ExprGen {
            var_names: HashMap::new(),
            var_types: HashMap::new(),
            strings: HashMap::new(),
            type_names: HashMap::new(),
            field_info: HashMap::new(),
            method_info: HashMap::new(),
            dex_provider: Some(dex_provider),
        }
    }

    /// Set the DEX info provider for lazy lookups
    pub fn set_dex_provider(&mut self, provider: Arc<dyn DexInfoProvider>) {
        self.dex_provider = Some(provider);
    }

    /// Reset for reuse - SHRINKS HashMaps to prevent memory accumulation
    /// If a HashMap grew very large for one big method, we don't want to keep
    /// that capacity for small methods
    pub fn reset(&mut self) {
        // If HashMaps grew too large, replace them with fresh ones
        // This prevents memory accumulation across classes
        const MAX_POOLED_CAPACITY: usize = 1000;

        if self.var_names.capacity() > MAX_POOLED_CAPACITY {
            self.var_names = HashMap::new();
        } else {
            self.var_names.clear();
        }

        if self.var_types.capacity() > MAX_POOLED_CAPACITY {
            self.var_types = HashMap::new();
        } else {
            self.var_types.clear();
        }

        if self.strings.capacity() > MAX_POOLED_CAPACITY {
            self.strings = HashMap::new();
        } else {
            self.strings.clear();
        }

        if self.type_names.capacity() > MAX_POOLED_CAPACITY {
            self.type_names = HashMap::new();
        } else {
            self.type_names.clear();
        }

        if self.field_info.capacity() > MAX_POOLED_CAPACITY {
            self.field_info = HashMap::new();
        } else {
            self.field_info.clear();
        }

        if self.method_info.capacity() > MAX_POOLED_CAPACITY {
            self.method_info = HashMap::new();
        } else {
            self.method_info.clear();
        }

        self.dex_provider = None;
    }

    /// Get an ExprGen from the thread-local pool (or create new)
    pub fn from_pool() -> Self {
        EXPR_GEN_POOL.with(|pool| {
            pool.borrow_mut().pop().unwrap_or_else(|| ExprGen::new())
        })
    }

    /// Return an ExprGen to the thread-local pool for reuse
    pub fn return_to_pool(mut self) {
        self.reset();
        EXPR_GEN_POOL.with(|pool| {
            let mut p = pool.borrow_mut();
            // Limit pool size to avoid unbounded growth
            if p.len() < 16 {
                p.push(self);
            }
        });
    }

    /// Set variable name
    pub fn set_var_name(&mut self, reg: u16, version: u32, name: String) {
        self.var_names.insert((reg, version), name);
    }

    /// Set variable type
    pub fn set_var_type(&mut self, reg: u16, version: u32, ty: ArgType) {
        self.var_types.insert((reg, version), ty);
    }

    /// Set string constant
    pub fn set_string(&mut self, idx: u32, value: String) {
        self.strings.insert(idx, value);
    }

    /// Set type name
    pub fn set_type_name(&mut self, idx: u32, name: String) {
        self.type_names.insert(idx, name);
    }

    /// Set field info
    pub fn set_field_info(&mut self, idx: u32, info: FieldInfo) {
        self.field_info.insert(idx, info);
    }

    /// Set method info
    pub fn set_method_info(&mut self, idx: u32, info: MethodInfo) {
        self.method_info.insert(idx, info);
    }

    /// Get field info by index
    pub fn get_field_info(&self, idx: u32) -> Option<&FieldInfo> {
        self.field_info.get(&idx)
    }

    /// Get field name (just the name, not qualified)
    pub fn get_field_name(&self, idx: u32) -> Option<String> {
        self.field_info.get(&idx).map(|f| f.field_name.clone())
    }

    /// Get static field reference (Class.fieldName)
    pub fn get_static_field_ref(&self, idx: u32) -> Option<String> {
        self.get_field_value(idx).map(|f| format!("{}.{}", f.class_name, f.field_name))
    }

    /// Get variable name (or generate default)
    pub fn get_var_name(&self, reg: &RegisterArg) -> String {
        self.var_names
            .get(&(reg.reg_num, reg.ssa_version))
            .cloned()
            .unwrap_or_else(|| format!("v{}", reg.reg_num))
    }

    /// Get string by index (local cache first, then DEX provider)
    pub fn get_string_value(&self, idx: u32) -> Option<String> {
        self.strings.get(&idx).cloned()
            .or_else(|| self.dex_provider.as_ref().and_then(|p| p.get_string(idx)))
    }

    /// Get type name by index (local cache first, then DEX provider)
    pub fn get_type_value(&self, idx: u32) -> Option<String> {
        self.type_names.get(&idx).cloned()
            .or_else(|| self.dex_provider.as_ref().and_then(|p| p.get_type_name(idx)))
    }

    /// Get field info by index (local cache first, then DEX provider)
    pub fn get_field_value(&self, idx: u32) -> Option<FieldInfo> {
        self.field_info.get(&idx).cloned()
            .or_else(|| self.dex_provider.as_ref().and_then(|p| p.get_field(idx)))
    }

    /// Get method info by index (local cache first, then DEX provider)
    pub fn get_method_value(&self, idx: u32) -> Option<MethodInfo> {
        self.method_info.get(&idx).cloned()
            .or_else(|| self.dex_provider.as_ref().and_then(|p| p.get_method(idx)))
    }

    /// Generate expression for an instruction argument
    pub fn gen_arg(&self, arg: &InsnArg) -> String {
        match arg {
            InsnArg::Register(reg) => self.get_var_name(reg),
            InsnArg::Literal(lit) => self.gen_literal(lit),
            InsnArg::Type(idx) => self.get_type_value(*idx)
                .unwrap_or_else(|| format!("Type#{}", idx)),
            InsnArg::Field(idx) => format!("field#{}", idx),
            InsnArg::Method(idx) => format!("method#{}", idx),
            InsnArg::String(idx) => self.get_string_value(*idx)
                .map(|s| format!("\"{}\"", escape_string(&s)))
                .unwrap_or_else(|| format!("string#{}", idx)),
        }
    }

    /// Generate literal expression
    pub fn gen_literal(&self, lit: &LiteralArg) -> String {
        match lit {
            LiteralArg::Int(v) => {
                if *v >= i32::MIN as i64 && *v <= i32::MAX as i64 {
                    format!("{}", v)
                } else {
                    format!("{}L", v)
                }
            }
            LiteralArg::Float(v) => {
                if v.is_nan() {
                    "Float.NaN".to_string()
                } else if v.is_infinite() {
                    if *v > 0.0 { "Float.POSITIVE_INFINITY" } else { "Float.NEGATIVE_INFINITY" }.to_string()
                } else {
                    format!("{}f", v)
                }
            }
            LiteralArg::Double(v) => {
                if v.is_nan() {
                    "Double.NaN".to_string()
                } else if v.is_infinite() {
                    if *v > 0.0 { "Double.POSITIVE_INFINITY" } else { "Double.NEGATIVE_INFINITY" }.to_string()
                } else {
                    format!("{}d", v)
                }
            }
            LiteralArg::Null => "null".to_string(),
        }
    }

    /// Generate expression for instruction
    pub fn gen_insn(&self, insn: &InsnType) -> Option<String> {
        match insn {
            InsnType::Const { value, .. } => Some(self.gen_literal(value)),

            InsnType::ConstString { string_idx, .. } => {
                Some(self.get_string_value(*string_idx)
                    .map(|s| format!("\"{}\"", escape_string(&s)))
                    .unwrap_or_else(|| format!("string#{}", string_idx)))
            }

            InsnType::ConstClass { type_idx, .. } => {
                let name = self.get_type_value(*type_idx)
                    .unwrap_or_else(|| format!("Type#{}", type_idx));
                Some(format!("{}.class", name))
            }

            InsnType::Move { src, .. } => Some(self.gen_arg(src)),

            InsnType::NewInstance { type_idx, .. } => {
                let name = self.get_type_value(*type_idx)
                    .unwrap_or_else(|| format!("Type#{}", type_idx));
                Some(format!("new {}()", name))
            }

            InsnType::NewArray { size, type_idx, .. } => {
                let name = self.get_type_value(*type_idx)
                    .unwrap_or_else(|| format!("Type#{}", type_idx));
                let size_str = self.gen_arg(size);
                // Type is array type, get element type
                let elem_name = name.trim_start_matches('[').trim_start_matches('L').trim_end_matches(';');
                Some(format!("new {}[{}]", elem_name, size_str))
            }

            InsnType::FilledNewArray { type_idx, args, .. } => {
                let name = self.get_type_value(*type_idx)
                    .unwrap_or_else(|| format!("Type#{}", type_idx));
                let elem_name = name.trim_start_matches('[').trim_start_matches('L').trim_end_matches(';');
                let args_str: Vec<_> = args.iter().map(|a| self.gen_arg(a)).collect();
                Some(format!("new {}[] {{ {} }}", elem_name, args_str.join(", ")))
            }

            InsnType::ArrayLength { array, .. } => {
                Some(format!("{}.length", self.gen_arg(array)))
            }

            InsnType::ArrayGet { array, index, .. } => {
                Some(format!("{}[{}]", self.gen_arg(array), self.gen_arg(index)))
            }

            InsnType::InstanceOf { object, type_idx, .. } => {
                let name = self.get_type_value(*type_idx)
                    .unwrap_or_else(|| format!("Type#{}", type_idx));
                Some(format!("{} instanceof {}", self.gen_arg(object), name))
            }

            InsnType::InstanceGet { object, field_idx, .. } => {
                if let Some(info) = self.get_field_value(*field_idx) {
                    Some(format!("{}.{}", self.gen_arg(object), info.field_name))
                } else {
                    Some(format!("{}.field#{}", self.gen_arg(object), field_idx))
                }
            }

            InsnType::StaticGet { field_idx, .. } => {
                if let Some(info) = self.get_field_value(*field_idx) {
                    Some(format!("{}.{}", info.class_name, info.field_name))
                } else {
                    Some(format!("field#{}", field_idx))
                }
            }

            InsnType::Invoke { kind, method_idx, args } => {
                let args_str: Vec<_> = args.iter()
                    .skip(if matches!(kind, InvokeKind::Static) { 0 } else { 1 }) // Skip 'this' for non-static
                    .map(|a| self.gen_arg(a))
                    .collect();

                if let Some(info) = self.get_method_value(*method_idx) {
                    match kind {
                        InvokeKind::Static => {
                            Some(format!("{}.{}({})", info.class_name, info.method_name, args_str.join(", ")))
                        }
                        InvokeKind::Virtual | InvokeKind::Interface | InvokeKind::Direct => {
                            let receiver = args.first().map(|a| self.gen_arg(a)).unwrap_or_default();
                            // Handle constructor calls: this.<init>() -> super()
                            if info.method_name == "<init>" {
                                if receiver == "this" {
                                    // Constructor calling super constructor
                                    Some(format!("super({})", args_str.join(", ")))
                                } else {
                                    // new SomeClass() - this is typically handled by NewInstance
                                    Some(format!("new {}({})", info.class_name, args_str.join(", ")))
                                }
                            } else {
                                Some(format!("{}.{}({})", receiver, info.method_name, args_str.join(", ")))
                            }
                        }
                        InvokeKind::Super => {
                            if info.method_name == "<init>" {
                                Some(format!("super({})", args_str.join(", ")))
                            } else {
                                Some(format!("super.{}({})", info.method_name, args_str.join(", ")))
                            }
                        }
                        _ => Some(format!("method#{}({})", method_idx, args_str.join(", ")))
                    }
                } else {
                    Some(format!("method#{}({})", method_idx, args_str.join(", ")))
                }
            }

            InsnType::Unary { op, arg, .. } => {
                let arg_str = self.gen_arg(arg);
                Some(match op {
                    UnaryOp::Neg => format!("-{}", maybe_paren(&arg_str)),
                    UnaryOp::Not => format!("~{}", maybe_paren(&arg_str)),
                })
            }

            InsnType::Binary { op, left, right, .. } => {
                let left_str = self.gen_arg(left);
                let right_str = self.gen_arg(right);
                let op_str = binary_op_str(*op);
                Some(format!("{} {} {}", maybe_paren(&left_str), op_str, maybe_paren(&right_str)))
            }

            InsnType::Cast { cast_type, arg, .. } => {
                let arg_str = self.gen_arg(arg);
                let type_str = cast_type_str(*cast_type);
                Some(format!("({}){}", type_str, maybe_paren(&arg_str)))
            }

            InsnType::Compare { left, right, .. } => {
                // Compare returns int (-1, 0, 1), used for long/float/double comparisons
                let left_str = self.gen_arg(left);
                let right_str = self.gen_arg(right);
                Some(format!("compare({}, {})", left_str, right_str))
            }

            InsnType::CheckCast { object, type_idx } => {
                let name = self.get_type_value(*type_idx)
                    .unwrap_or_else(|| format!("Type#{}", type_idx));
                Some(format!("({}){}", name, self.gen_arg(object)))
            }

            _ => None, // Statements, not expressions
        }
    }

    /// Generate condition expression for If instruction
    pub fn gen_condition(&self, condition: IfCondition, left: &InsnArg, right: Option<&InsnArg>) -> String {
        let left_str = self.gen_arg(left);
        let op = condition_op_str(condition);

        if let Some(right) = right {
            format!("{} {} {}", left_str, op, self.gen_arg(right))
        } else {
            // Zero comparison
            format!("{} {} 0", left_str, op)
        }
    }
}

impl Default for ExprGen {
    fn default() -> Self {
        Self::new()
    }
}

/// Binary operation to string
fn binary_op_str(op: BinaryOp) -> &'static str {
    match op {
        BinaryOp::Add => "+",
        BinaryOp::Sub => "-",
        BinaryOp::Mul => "*",
        BinaryOp::Div => "/",
        BinaryOp::Rem => "%",
        BinaryOp::And => "&",
        BinaryOp::Or => "|",
        BinaryOp::Xor => "^",
        BinaryOp::Shl => "<<",
        BinaryOp::Shr => ">>",
        BinaryOp::Ushr => ">>>",
        BinaryOp::Rsub => "-", // Reverse subtraction handled specially
    }
}

/// Condition to comparison operator
fn condition_op_str(cond: IfCondition) -> &'static str {
    match cond {
        IfCondition::Eq => "==",
        IfCondition::Ne => "!=",
        IfCondition::Lt => "<",
        IfCondition::Ge => ">=",
        IfCondition::Gt => ">",
        IfCondition::Le => "<=",
    }
}

/// Cast type to Java type string
fn cast_type_str(cast: CastType) -> &'static str {
    match cast {
        CastType::IntToLong => "long",
        CastType::IntToFloat => "float",
        CastType::IntToDouble => "double",
        CastType::LongToInt => "int",
        CastType::LongToFloat => "float",
        CastType::LongToDouble => "double",
        CastType::FloatToInt => "int",
        CastType::FloatToLong => "long",
        CastType::FloatToDouble => "double",
        CastType::DoubleToInt => "int",
        CastType::DoubleToLong => "long",
        CastType::DoubleToFloat => "float",
        CastType::IntToByte => "byte",
        CastType::IntToChar => "char",
        CastType::IntToShort => "short",
    }
}

/// Wrap in parentheses if needed (for complex expressions)
fn maybe_paren(s: &str) -> String {
    if s.contains(' ') && !s.starts_with('(') {
        format!("({})", s)
    } else {
        s.to_string()
    }
}

/// Escape string for Java source
fn escape_string(s: &str) -> String {
    let mut result = String::with_capacity(s.len());
    for c in s.chars() {
        match c {
            '"' => result.push_str("\\\""),
            '\\' => result.push_str("\\\\"),
            '\n' => result.push_str("\\n"),
            '\r' => result.push_str("\\r"),
            '\t' => result.push_str("\\t"),
            c if c.is_control() => {
                result.push_str(&format!("\\u{:04x}", c as u32));
            }
            c => result.push(c),
        }
    }
    result
}

#[cfg(test)]
mod tests {
    use super::*;
    use jadx_ir::instructions::ArrayElemType;

    #[test]
    fn test_literal_gen() {
        let gen = ExprGen::new();
        assert_eq!(gen.gen_literal(&LiteralArg::Int(42)), "42");
        assert_eq!(gen.gen_literal(&LiteralArg::Int(5000000000)), "5000000000L");
        assert_eq!(gen.gen_literal(&LiteralArg::Null), "null");
    }

    #[test]
    fn test_var_name() {
        let mut gen = ExprGen::new();
        gen.set_var_name(0, 1, "myVar".to_string());

        let reg = RegisterArg::with_ssa(0, 1);
        assert_eq!(gen.get_var_name(&reg), "myVar");

        // Unknown var gets default name
        let reg2 = RegisterArg::with_ssa(5, 0);
        assert_eq!(gen.get_var_name(&reg2), "v5");
    }

    #[test]
    fn test_binary_op() {
        let gen = ExprGen::new();
        let insn = InsnType::Binary {
            dest: RegisterArg::new(0),
            op: BinaryOp::Add,
            left: InsnArg::reg(1),
            right: InsnArg::reg(2),
        };
        assert_eq!(gen.gen_insn(&insn), Some("v1 + v2".to_string()));
    }

    #[test]
    fn test_unary_op() {
        let gen = ExprGen::new();
        let insn = InsnType::Unary {
            dest: RegisterArg::new(0),
            op: UnaryOp::Neg,
            arg: InsnArg::reg(1),
        };
        assert_eq!(gen.gen_insn(&insn), Some("-v1".to_string()));
    }

    #[test]
    fn test_array_access() {
        let gen = ExprGen::new();
        let insn = InsnType::ArrayGet {
            dest: RegisterArg::new(0),
            array: InsnArg::reg(1),
            index: InsnArg::reg(2),
            elem_type: ArrayElemType::Int,
        };
        assert_eq!(gen.gen_insn(&insn), Some("v1[v2]".to_string()));
    }

    #[test]
    fn test_condition() {
        let gen = ExprGen::new();
        let cond = gen.gen_condition(
            IfCondition::Eq,
            &InsnArg::reg(0),
            Some(&InsnArg::reg(1))
        );
        assert_eq!(cond, "v0 == v1");
    }

    #[test]
    fn test_escape_string() {
        assert_eq!(escape_string("hello"), "hello");
        assert_eq!(escape_string("say \"hi\""), "say \\\"hi\\\"");
        assert_eq!(escape_string("line1\nline2"), "line1\\nline2");
    }
}
