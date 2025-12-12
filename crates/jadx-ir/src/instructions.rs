//! IR instruction types
//!
//! This module defines the intermediate representation for Dalvik instructions.
//! Each IR instruction represents a single operation with typed arguments.

use crate::arena::ArenaId;
use crate::types::ArgType;

/// Instruction node ID
pub type InsnId = ArenaId<InsnNode>;

/// An IR instruction node
#[derive(Debug, Clone)]
pub struct InsnNode {
    /// Instruction type and operands
    pub insn_type: InsnType,
    /// Result type (if any)
    pub result_type: Option<ArgType>,
    /// Source line number (for debugging)
    pub source_line: Option<u32>,
    /// Original bytecode offset
    pub offset: u32,
}

impl InsnNode {
    /// Create a new instruction node
    pub fn new(insn_type: InsnType, offset: u32) -> Self {
        InsnNode {
            insn_type,
            result_type: None,
            source_line: None,
            offset,
        }
    }

    /// Set the result type
    pub fn with_result(mut self, result_type: ArgType) -> Self {
        self.result_type = Some(result_type);
        self
    }
}

/// IR instruction types
#[derive(Debug, Clone)]
pub enum InsnType {
    /// No operation
    Nop,

    /// Constant value: result = literal
    Const {
        dest: RegisterArg,
        value: LiteralArg,
    },

    /// Constant string: result = string_ref
    ConstString {
        dest: RegisterArg,
        string_idx: u32,
    },

    /// Constant class: result = class_ref
    ConstClass {
        dest: RegisterArg,
        type_idx: u32,
    },

    /// Move: dest = src
    Move {
        dest: RegisterArg,
        src: InsnArg,
    },

    /// Move result from previous invoke
    MoveResult {
        dest: RegisterArg,
    },

    /// Move exception to register
    MoveException {
        dest: RegisterArg,
    },

    /// Return from method
    Return {
        value: Option<InsnArg>,
    },

    /// Throw exception
    Throw {
        exception: InsnArg,
    },

    /// Monitor enter
    MonitorEnter {
        object: InsnArg,
    },

    /// Monitor exit
    MonitorExit {
        object: InsnArg,
    },

    /// Check cast
    CheckCast {
        object: InsnArg,
        type_idx: u32,
    },

    /// Instance of check: result = object instanceof type
    InstanceOf {
        dest: RegisterArg,
        object: InsnArg,
        type_idx: u32,
    },

    /// Array length: result = array.length
    ArrayLength {
        dest: RegisterArg,
        array: InsnArg,
    },

    /// New instance: result = new Type()
    NewInstance {
        dest: RegisterArg,
        type_idx: u32,
    },

    /// New array: result = new Type[size]
    NewArray {
        dest: RegisterArg,
        size: InsnArg,
        type_idx: u32,
    },

    /// Filled new array: result = new Type[] { args... }
    FilledNewArray {
        dest: Option<RegisterArg>,
        type_idx: u32,
        args: Vec<InsnArg>,
    },

    /// Fill array data (from payload)
    FillArrayData {
        array: InsnArg,
        payload_offset: i32,
    },

    /// Array get: result = array[index]
    ArrayGet {
        dest: RegisterArg,
        array: InsnArg,
        index: InsnArg,
        elem_type: ArrayElemType,
    },

    /// Array put: array[index] = value
    ArrayPut {
        array: InsnArg,
        index: InsnArg,
        value: InsnArg,
        elem_type: ArrayElemType,
    },

    /// Instance field get: result = object.field
    InstanceGet {
        dest: RegisterArg,
        object: InsnArg,
        field_idx: u32,
    },

    /// Instance field put: object.field = value
    InstancePut {
        object: InsnArg,
        field_idx: u32,
        value: InsnArg,
    },

    /// Static field get: result = Class.field
    StaticGet {
        dest: RegisterArg,
        field_idx: u32,
    },

    /// Static field put: Class.field = value
    StaticPut {
        field_idx: u32,
        value: InsnArg,
    },

    /// Method invocation
    Invoke {
        kind: InvokeKind,
        method_idx: u32,
        args: Vec<InsnArg>,
    },

    /// Unary operation: result = op(arg)
    Unary {
        dest: RegisterArg,
        op: UnaryOp,
        arg: InsnArg,
    },

    /// Binary operation: result = left op right
    Binary {
        dest: RegisterArg,
        op: BinaryOp,
        left: InsnArg,
        right: InsnArg,
    },

    /// Type conversion: result = (type)arg
    Cast {
        dest: RegisterArg,
        cast_type: CastType,
        arg: InsnArg,
    },

    /// Compare: result = cmp(left, right)
    Compare {
        dest: RegisterArg,
        op: CompareOp,
        left: InsnArg,
        right: InsnArg,
    },

    /// Conditional branch: if (cond) goto target
    If {
        condition: IfCondition,
        left: InsnArg,
        right: Option<InsnArg>, // None for *z variants
        target: u32,
    },

    /// Unconditional branch: goto target
    Goto {
        target: u32,
    },

    /// Packed switch
    PackedSwitch {
        value: InsnArg,
        payload_offset: i32,
    },

    /// Sparse switch
    SparseSwitch {
        value: InsnArg,
        payload_offset: i32,
    },

    /// Phi node (for SSA form)
    Phi {
        dest: RegisterArg,
        sources: Vec<(u32, InsnArg)>, // (block_id, value)
    },
}

/// Instruction argument
#[derive(Debug, Clone)]
pub enum InsnArg {
    /// Register reference
    Register(RegisterArg),
    /// Literal constant
    Literal(LiteralArg),
    /// Type reference
    Type(u32),
    /// Field reference
    Field(u32),
    /// Method reference
    Method(u32),
    /// String reference
    String(u32),
}

impl InsnArg {
    /// Create a register argument
    pub fn reg(reg: u16) -> Self {
        InsnArg::Register(RegisterArg::new(reg))
    }

    /// Create a literal argument
    pub fn lit(value: i64) -> Self {
        InsnArg::Literal(LiteralArg::Int(value))
    }
}

/// Register argument
#[derive(Debug, Clone, Copy, PartialEq, Eq, Hash)]
pub struct RegisterArg {
    /// Register number
    pub reg_num: u16,
    /// SSA version (for SSA form)
    pub ssa_version: u32,
}

impl RegisterArg {
    /// Create a new register argument
    pub fn new(reg_num: u16) -> Self {
        RegisterArg {
            reg_num,
            ssa_version: 0,
        }
    }

    /// Create with SSA version
    pub fn with_ssa(reg_num: u16, version: u32) -> Self {
        RegisterArg {
            reg_num,
            ssa_version: version,
        }
    }
}

/// Literal argument
#[derive(Debug, Clone)]
pub enum LiteralArg {
    /// Integer/long constant
    Int(i64),
    /// Float constant
    Float(f32),
    /// Double constant
    Double(f64),
    /// Null constant
    Null,
}

impl LiteralArg {
    /// Create from raw bits (for const-wide)
    pub fn from_bits_f32(bits: i32) -> Self {
        LiteralArg::Float(f32::from_bits(bits as u32))
    }

    /// Create from raw bits (for const-wide)
    pub fn from_bits_f64(bits: i64) -> Self {
        LiteralArg::Double(f64::from_bits(bits as u64))
    }
}

/// Array element type for array operations
#[derive(Debug, Clone, Copy, PartialEq, Eq)]
pub enum ArrayElemType {
    Int,
    Wide,
    Object,
    Boolean,
    Byte,
    Char,
    Short,
}

/// Method invocation kind
#[derive(Debug, Clone, Copy, PartialEq, Eq)]
pub enum InvokeKind {
    Virtual,
    Super,
    Direct,
    Static,
    Interface,
    Polymorphic,
    Custom,
}

/// Unary operation
#[derive(Debug, Clone, Copy, PartialEq, Eq)]
pub enum UnaryOp {
    Neg,
    Not,
}

/// Binary operation
#[derive(Debug, Clone, Copy, PartialEq, Eq)]
pub enum BinaryOp {
    Add,
    Sub,
    Mul,
    Div,
    Rem,
    And,
    Or,
    Xor,
    Shl,
    Shr,
    Ushr,
    Rsub,
}

/// Type conversion
#[derive(Debug, Clone, Copy, PartialEq, Eq)]
pub enum CastType {
    IntToLong,
    IntToFloat,
    IntToDouble,
    LongToInt,
    LongToFloat,
    LongToDouble,
    FloatToInt,
    FloatToLong,
    FloatToDouble,
    DoubleToInt,
    DoubleToLong,
    DoubleToFloat,
    IntToByte,
    IntToChar,
    IntToShort,
}

/// Comparison operation
#[derive(Debug, Clone, Copy, PartialEq, Eq)]
pub enum CompareOp {
    /// Compare floats, return -1 on NaN
    CmplFloat,
    /// Compare floats, return 1 on NaN
    CmpgFloat,
    /// Compare doubles, return -1 on NaN
    CmplDouble,
    /// Compare doubles, return 1 on NaN
    CmpgDouble,
    /// Compare longs
    CmpLong,
}

/// If condition
#[derive(Debug, Clone, Copy, PartialEq, Eq)]
pub enum IfCondition {
    Eq,
    Ne,
    Lt,
    Ge,
    Gt,
    Le,
}

#[cfg(test)]
mod tests {
    use super::*;

    #[test]
    fn test_insn_node_creation() {
        let insn = InsnNode::new(InsnType::Nop, 0);
        assert!(matches!(insn.insn_type, InsnType::Nop));
        assert_eq!(insn.offset, 0);
    }

    #[test]
    fn test_register_arg() {
        let reg = RegisterArg::new(5);
        assert_eq!(reg.reg_num, 5);
        assert_eq!(reg.ssa_version, 0);

        let ssa_reg = RegisterArg::with_ssa(5, 3);
        assert_eq!(ssa_reg.ssa_version, 3);
    }

    #[test]
    fn test_insn_arg() {
        let reg = InsnArg::reg(0);
        assert!(matches!(reg, InsnArg::Register(_)));

        let lit = InsnArg::lit(42);
        assert!(matches!(lit, InsnArg::Literal(LiteralArg::Int(42))));
    }
}
