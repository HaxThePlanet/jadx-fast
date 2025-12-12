//! Expression generation - converts IR instructions to Java expressions
//!
//! This module turns IR instructions into Java source code expressions.
//! For example: `Binary { op: Add, left: v0, right: v1 }` -> `"a + b"`

use std::collections::HashMap;

use jadx_ir::instructions::{
    ArrayElemType, BinaryOp, CastType, CompareOp, IfCondition, InsnArg, InsnType,
    InvokeKind, LiteralArg, RegisterArg, UnaryOp,
};
use jadx_ir::types::ArgType;

use crate::type_gen::type_to_string;

/// Expression generation context
pub struct ExprGen {
    /// Variable names: (reg_num, ssa_version) -> name
    var_names: HashMap<(u16, u32), String>,
    /// Variable types (for casting decisions)
    var_types: HashMap<(u16, u32), ArgType>,
    /// String pool for const-string
    strings: HashMap<u32, String>,
    /// Type names for type_idx
    type_names: HashMap<u32, String>,
    /// Field info for field_idx
    field_info: HashMap<u32, FieldInfo>,
    /// Method info for method_idx
    method_info: HashMap<u32, MethodInfo>,
}

/// Field information
#[derive(Clone)]
pub struct FieldInfo {
    pub class_name: String,
    pub field_name: String,
    pub field_type: ArgType,
}

/// Method information
#[derive(Clone)]
pub struct MethodInfo {
    pub class_name: String,
    pub method_name: String,
    pub return_type: ArgType,
    pub param_types: Vec<ArgType>,
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
        }
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

    /// Get variable name (or generate default)
    pub fn get_var_name(&self, reg: &RegisterArg) -> String {
        self.var_names
            .get(&(reg.reg_num, reg.ssa_version))
            .cloned()
            .unwrap_or_else(|| format!("v{}", reg.reg_num))
    }

    /// Generate expression for an instruction argument
    pub fn gen_arg(&self, arg: &InsnArg) -> String {
        match arg {
            InsnArg::Register(reg) => self.get_var_name(reg),
            InsnArg::Literal(lit) => self.gen_literal(lit),
            InsnArg::Type(idx) => self.type_names.get(idx)
                .cloned()
                .unwrap_or_else(|| format!("Type#{}", idx)),
            InsnArg::Field(idx) => format!("field#{}", idx),
            InsnArg::Method(idx) => format!("method#{}", idx),
            InsnArg::String(idx) => self.strings.get(idx)
                .map(|s| format!("\"{}\"", escape_string(s)))
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
                Some(self.strings.get(string_idx)
                    .map(|s| format!("\"{}\"", escape_string(s)))
                    .unwrap_or_else(|| format!("string#{}", string_idx)))
            }

            InsnType::ConstClass { type_idx, .. } => {
                let name = self.type_names.get(type_idx)
                    .cloned()
                    .unwrap_or_else(|| format!("Type#{}", type_idx));
                Some(format!("{}.class", name))
            }

            InsnType::Move { src, .. } => Some(self.gen_arg(src)),

            InsnType::NewInstance { type_idx, .. } => {
                let name = self.type_names.get(type_idx)
                    .cloned()
                    .unwrap_or_else(|| format!("Type#{}", type_idx));
                Some(format!("new {}()", name))
            }

            InsnType::NewArray { size, type_idx, .. } => {
                let name = self.type_names.get(type_idx)
                    .cloned()
                    .unwrap_or_else(|| format!("Type#{}", type_idx));
                let size_str = self.gen_arg(size);
                // Type is array type, get element type
                let elem_name = name.trim_start_matches('[').trim_start_matches('L').trim_end_matches(';');
                Some(format!("new {}[{}]", elem_name, size_str))
            }

            InsnType::FilledNewArray { type_idx, args, .. } => {
                let name = self.type_names.get(type_idx)
                    .cloned()
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
                let name = self.type_names.get(type_idx)
                    .cloned()
                    .unwrap_or_else(|| format!("Type#{}", type_idx));
                Some(format!("{} instanceof {}", self.gen_arg(object), name))
            }

            InsnType::InstanceGet { object, field_idx, .. } => {
                if let Some(info) = self.field_info.get(field_idx) {
                    Some(format!("{}.{}", self.gen_arg(object), info.field_name))
                } else {
                    Some(format!("{}.field#{}", self.gen_arg(object), field_idx))
                }
            }

            InsnType::StaticGet { field_idx, .. } => {
                if let Some(info) = self.field_info.get(field_idx) {
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

                if let Some(info) = self.method_info.get(method_idx) {
                    match kind {
                        InvokeKind::Static => {
                            Some(format!("{}.{}({})", info.class_name, info.method_name, args_str.join(", ")))
                        }
                        InvokeKind::Virtual | InvokeKind::Interface | InvokeKind::Direct => {
                            let receiver = args.first().map(|a| self.gen_arg(a)).unwrap_or_default();
                            Some(format!("{}.{}({})", receiver, info.method_name, args_str.join(", ")))
                        }
                        InvokeKind::Super => {
                            Some(format!("super.{}({})", info.method_name, args_str.join(", ")))
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

            InsnType::Compare { op, left, right, .. } => {
                // Compare returns int, but we represent it as comparison
                let left_str = self.gen_arg(left);
                let right_str = self.gen_arg(right);
                Some(format!("compare({}, {})", left_str, right_str))
            }

            InsnType::CheckCast { object, type_idx } => {
                let name = self.type_names.get(type_idx)
                    .cloned()
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
