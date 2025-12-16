//! IR builder - converts DEX instructions to IR
//!
//! This module handles the conversion from Dalvik bytecode to our IR representation.

use crate::instructions::{
    ArrayElemType, BinaryOp, CastType, CompareOp, IfCondition, InsnArg, InsnNode, InsnType,
    InvokeKind, LiteralArg, RegisterArg, UnaryOp,
};

/// Convert a decoded DEX instruction to an IR instruction
pub fn build_ir_insn(
    opcode: u8,
    offset: u32,
    regs: &[u16; 5],
    reg_count: u8,
    literal: i64,
    index: u32,
    target: i32,
) -> Option<InsnNode> {
    let insn_type = match opcode {
        // NOP
        0x00 => InsnType::Nop,

        // MOVE variants
        0x01 | 0x04 | 0x07 => InsnType::Move {
            dest: RegisterArg::new(regs[0]),
            src: InsnArg::reg(regs[1]),
        },
        0x02 | 0x05 | 0x08 => InsnType::Move {
            dest: RegisterArg::new(regs[0]),
            src: InsnArg::reg(regs[1]),
        },
        0x03 | 0x06 | 0x09 => InsnType::Move {
            dest: RegisterArg::new(regs[0]),
            src: InsnArg::reg(regs[1]),
        },

        // MOVE-RESULT variants
        0x0a | 0x0b | 0x0c => InsnType::MoveResult {
            dest: RegisterArg::new(regs[0]),
        },

        // MOVE-EXCEPTION
        0x0d => InsnType::MoveException {
            dest: RegisterArg::new(regs[0]),
        },

        // RETURN variants
        0x0e => InsnType::Return { value: None },
        0x0f | 0x10 | 0x11 => InsnType::Return {
            value: Some(InsnArg::reg(regs[0])),
        },

        // CONST variants
        0x12 => InsnType::Const {
            dest: RegisterArg::new(regs[0]),
            value: LiteralArg::Int(literal),
        },
        0x13 => InsnType::Const {
            dest: RegisterArg::new(regs[0]),
            value: LiteralArg::Int(literal),
        },
        0x14 => InsnType::Const {
            dest: RegisterArg::new(regs[0]),
            value: LiteralArg::Int(literal),
        },
        0x15 => InsnType::Const {
            dest: RegisterArg::new(regs[0]),
            value: LiteralArg::Int(literal),
        },
        0x16 => InsnType::Const {
            dest: RegisterArg::new(regs[0]),
            value: LiteralArg::Int(literal),
        },
        0x17 => InsnType::Const {
            dest: RegisterArg::new(regs[0]),
            value: LiteralArg::Int(literal),
        },
        0x18 => InsnType::Const {
            dest: RegisterArg::new(regs[0]),
            value: LiteralArg::Int(literal),
        },
        0x19 => InsnType::Const {
            dest: RegisterArg::new(regs[0]),
            value: LiteralArg::Int(literal),
        },

        // CONST-STRING
        0x1a => InsnType::ConstString {
            dest: RegisterArg::new(regs[0]),
            string_idx: index,
        },
        0x1b => InsnType::ConstString {
            dest: RegisterArg::new(regs[0]),
            string_idx: index,
        },

        // CONST-CLASS
        0x1c => InsnType::ConstClass {
            dest: RegisterArg::new(regs[0]),
            type_idx: index,
        },

        // MONITOR-ENTER
        0x1d => InsnType::MonitorEnter {
            object: InsnArg::reg(regs[0]),
        },

        // MONITOR-EXIT
        0x1e => InsnType::MonitorExit {
            object: InsnArg::reg(regs[0]),
        },

        // CHECK-CAST
        0x1f => InsnType::CheckCast {
            object: InsnArg::reg(regs[0]),
            type_idx: index,
        },

        // INSTANCE-OF
        0x20 => InsnType::InstanceOf {
            dest: RegisterArg::new(regs[0]),
            object: InsnArg::reg(regs[1]),
            type_idx: index,
        },

        // ARRAY-LENGTH
        0x21 => InsnType::ArrayLength {
            dest: RegisterArg::new(regs[0]),
            array: InsnArg::reg(regs[1]),
        },

        // NEW-INSTANCE
        0x22 => InsnType::NewInstance {
            dest: RegisterArg::new(regs[0]),
            type_idx: index,
        },

        // NEW-ARRAY
        0x23 => InsnType::NewArray {
            dest: RegisterArg::new(regs[0]),
            size: InsnArg::reg(regs[1]),
            type_idx: index,
        },

        // FILLED-NEW-ARRAY
        0x24 => InsnType::FilledNewArray {
            dest: None,
            type_idx: index,
            args: build_invoke_args(regs, reg_count),
        },

        // FILLED-NEW-ARRAY/RANGE
        0x25 => InsnType::FilledNewArray {
            dest: None,
            type_idx: index,
            args: build_range_args(regs[0], reg_count),
        },

        // FILL-ARRAY-DATA
        0x26 => InsnType::FillArrayData {
            array: InsnArg::reg(regs[0]),
            payload_offset: target,
            element_width: 0,  // Will be filled by payload parsing
            data: Vec::new(),  // Will be filled by payload parsing
        },

        // THROW
        0x27 => InsnType::Throw {
            exception: InsnArg::reg(regs[0]),
        },

        // GOTO variants
        0x28 | 0x29 | 0x2a => InsnType::Goto {
            target: (offset as i32 + target) as u32,
        },

        // PACKED-SWITCH
        0x2b => InsnType::PackedSwitch {
            value: InsnArg::reg(regs[0]),
            payload_offset: target,
            first_key: 0,
            targets: Vec::new(),
        },

        // SPARSE-SWITCH
        0x2c => InsnType::SparseSwitch {
            value: InsnArg::reg(regs[0]),
            payload_offset: target,
            keys: Vec::new(),
            targets: Vec::new(),
        },

        // CMP variants
        0x2d => InsnType::Compare {
            dest: RegisterArg::new(regs[0]),
            op: CompareOp::CmplFloat,
            left: InsnArg::reg(regs[1]),
            right: InsnArg::reg(regs[2]),
        },
        0x2e => InsnType::Compare {
            dest: RegisterArg::new(regs[0]),
            op: CompareOp::CmpgFloat,
            left: InsnArg::reg(regs[1]),
            right: InsnArg::reg(regs[2]),
        },
        0x2f => InsnType::Compare {
            dest: RegisterArg::new(regs[0]),
            op: CompareOp::CmplDouble,
            left: InsnArg::reg(regs[1]),
            right: InsnArg::reg(regs[2]),
        },
        0x30 => InsnType::Compare {
            dest: RegisterArg::new(regs[0]),
            op: CompareOp::CmpgDouble,
            left: InsnArg::reg(regs[1]),
            right: InsnArg::reg(regs[2]),
        },
        0x31 => InsnType::Compare {
            dest: RegisterArg::new(regs[0]),
            op: CompareOp::CmpLong,
            left: InsnArg::reg(regs[1]),
            right: InsnArg::reg(regs[2]),
        },

        // IF-<cond> (two registers)
        0x32 => InsnType::If {
            condition: IfCondition::Eq,
            left: InsnArg::reg(regs[0]),
            right: Some(InsnArg::reg(regs[1])),
            target: (offset as i32 + target) as u32,
        },
        0x33 => InsnType::If {
            condition: IfCondition::Ne,
            left: InsnArg::reg(regs[0]),
            right: Some(InsnArg::reg(regs[1])),
            target: (offset as i32 + target) as u32,
        },
        0x34 => InsnType::If {
            condition: IfCondition::Lt,
            left: InsnArg::reg(regs[0]),
            right: Some(InsnArg::reg(regs[1])),
            target: (offset as i32 + target) as u32,
        },
        0x35 => InsnType::If {
            condition: IfCondition::Ge,
            left: InsnArg::reg(regs[0]),
            right: Some(InsnArg::reg(regs[1])),
            target: (offset as i32 + target) as u32,
        },
        0x36 => InsnType::If {
            condition: IfCondition::Gt,
            left: InsnArg::reg(regs[0]),
            right: Some(InsnArg::reg(regs[1])),
            target: (offset as i32 + target) as u32,
        },
        0x37 => InsnType::If {
            condition: IfCondition::Le,
            left: InsnArg::reg(regs[0]),
            right: Some(InsnArg::reg(regs[1])),
            target: (offset as i32 + target) as u32,
        },

        // IF-<cond>Z (single register, compare to zero)
        0x38 => InsnType::If {
            condition: IfCondition::Eq,
            left: InsnArg::reg(regs[0]),
            right: None,
            target: (offset as i32 + target) as u32,
        },
        0x39 => InsnType::If {
            condition: IfCondition::Ne,
            left: InsnArg::reg(regs[0]),
            right: None,
            target: (offset as i32 + target) as u32,
        },
        0x3a => InsnType::If {
            condition: IfCondition::Lt,
            left: InsnArg::reg(regs[0]),
            right: None,
            target: (offset as i32 + target) as u32,
        },
        0x3b => InsnType::If {
            condition: IfCondition::Ge,
            left: InsnArg::reg(regs[0]),
            right: None,
            target: (offset as i32 + target) as u32,
        },
        0x3c => InsnType::If {
            condition: IfCondition::Gt,
            left: InsnArg::reg(regs[0]),
            right: None,
            target: (offset as i32 + target) as u32,
        },
        0x3d => InsnType::If {
            condition: IfCondition::Le,
            left: InsnArg::reg(regs[0]),
            right: None,
            target: (offset as i32 + target) as u32,
        },

        // AGET variants
        0x44 => InsnType::ArrayGet {
            dest: RegisterArg::new(regs[0]),
            array: InsnArg::reg(regs[1]),
            index: InsnArg::reg(regs[2]),
            elem_type: ArrayElemType::Int,
        },
        0x45 => InsnType::ArrayGet {
            dest: RegisterArg::new(regs[0]),
            array: InsnArg::reg(regs[1]),
            index: InsnArg::reg(regs[2]),
            elem_type: ArrayElemType::Wide,
        },
        0x46 => InsnType::ArrayGet {
            dest: RegisterArg::new(regs[0]),
            array: InsnArg::reg(regs[1]),
            index: InsnArg::reg(regs[2]),
            elem_type: ArrayElemType::Object,
        },
        0x47 => InsnType::ArrayGet {
            dest: RegisterArg::new(regs[0]),
            array: InsnArg::reg(regs[1]),
            index: InsnArg::reg(regs[2]),
            elem_type: ArrayElemType::Boolean,
        },
        0x48 => InsnType::ArrayGet {
            dest: RegisterArg::new(regs[0]),
            array: InsnArg::reg(regs[1]),
            index: InsnArg::reg(regs[2]),
            elem_type: ArrayElemType::Byte,
        },
        0x49 => InsnType::ArrayGet {
            dest: RegisterArg::new(regs[0]),
            array: InsnArg::reg(regs[1]),
            index: InsnArg::reg(regs[2]),
            elem_type: ArrayElemType::Char,
        },
        0x4a => InsnType::ArrayGet {
            dest: RegisterArg::new(regs[0]),
            array: InsnArg::reg(regs[1]),
            index: InsnArg::reg(regs[2]),
            elem_type: ArrayElemType::Short,
        },

        // APUT variants
        0x4b => InsnType::ArrayPut {
            array: InsnArg::reg(regs[1]),
            index: InsnArg::reg(regs[2]),
            value: InsnArg::reg(regs[0]),
            elem_type: ArrayElemType::Int,
        },
        0x4c => InsnType::ArrayPut {
            array: InsnArg::reg(regs[1]),
            index: InsnArg::reg(regs[2]),
            value: InsnArg::reg(regs[0]),
            elem_type: ArrayElemType::Wide,
        },
        0x4d => InsnType::ArrayPut {
            array: InsnArg::reg(regs[1]),
            index: InsnArg::reg(regs[2]),
            value: InsnArg::reg(regs[0]),
            elem_type: ArrayElemType::Object,
        },
        0x4e => InsnType::ArrayPut {
            array: InsnArg::reg(regs[1]),
            index: InsnArg::reg(regs[2]),
            value: InsnArg::reg(regs[0]),
            elem_type: ArrayElemType::Boolean,
        },
        0x4f => InsnType::ArrayPut {
            array: InsnArg::reg(regs[1]),
            index: InsnArg::reg(regs[2]),
            value: InsnArg::reg(regs[0]),
            elem_type: ArrayElemType::Byte,
        },
        0x50 => InsnType::ArrayPut {
            array: InsnArg::reg(regs[1]),
            index: InsnArg::reg(regs[2]),
            value: InsnArg::reg(regs[0]),
            elem_type: ArrayElemType::Char,
        },
        0x51 => InsnType::ArrayPut {
            array: InsnArg::reg(regs[1]),
            index: InsnArg::reg(regs[2]),
            value: InsnArg::reg(regs[0]),
            elem_type: ArrayElemType::Short,
        },

        // IGET variants
        0x52..=0x58 => InsnType::InstanceGet {
            dest: RegisterArg::new(regs[0]),
            object: InsnArg::reg(regs[1]),
            field_idx: index,
        },

        // IPUT variants
        0x59..=0x5f => InsnType::InstancePut {
            object: InsnArg::reg(regs[1]),
            field_idx: index,
            value: InsnArg::reg(regs[0]),
        },

        // SGET variants
        0x60..=0x66 => InsnType::StaticGet {
            dest: RegisterArg::new(regs[0]),
            field_idx: index,
        },

        // SPUT variants
        0x67..=0x6d => InsnType::StaticPut {
            field_idx: index,
            value: InsnArg::reg(regs[0]),
        },

        // INVOKE variants
        0x6e => InsnType::Invoke {
            kind: InvokeKind::Virtual,
            method_idx: index,
            args: build_invoke_args(regs, reg_count),
        },
        0x6f => InsnType::Invoke {
            kind: InvokeKind::Super,
            method_idx: index,
            args: build_invoke_args(regs, reg_count),
        },
        0x70 => InsnType::Invoke {
            kind: InvokeKind::Direct,
            method_idx: index,
            args: build_invoke_args(regs, reg_count),
        },
        0x71 => InsnType::Invoke {
            kind: InvokeKind::Static,
            method_idx: index,
            args: build_invoke_args(regs, reg_count),
        },
        0x72 => InsnType::Invoke {
            kind: InvokeKind::Interface,
            method_idx: index,
            args: build_invoke_args(regs, reg_count),
        },

        // INVOKE/RANGE variants
        0x74 => InsnType::Invoke {
            kind: InvokeKind::Virtual,
            method_idx: index,
            args: build_range_args(regs[0], reg_count),
        },
        0x75 => InsnType::Invoke {
            kind: InvokeKind::Super,
            method_idx: index,
            args: build_range_args(regs[0], reg_count),
        },
        0x76 => InsnType::Invoke {
            kind: InvokeKind::Direct,
            method_idx: index,
            args: build_range_args(regs[0], reg_count),
        },
        0x77 => InsnType::Invoke {
            kind: InvokeKind::Static,
            method_idx: index,
            args: build_range_args(regs[0], reg_count),
        },
        0x78 => InsnType::Invoke {
            kind: InvokeKind::Interface,
            method_idx: index,
            args: build_range_args(regs[0], reg_count),
        },

        // Unary operations
        0x7b => InsnType::Unary {
            dest: RegisterArg::new(regs[0]),
            op: UnaryOp::Neg,
            arg: InsnArg::reg(regs[1]),
        },
        0x7c => InsnType::Unary {
            dest: RegisterArg::new(regs[0]),
            op: UnaryOp::Not,
            arg: InsnArg::reg(regs[1]),
        },
        0x7d => InsnType::Unary {
            dest: RegisterArg::new(regs[0]),
            op: UnaryOp::Neg,
            arg: InsnArg::reg(regs[1]),
        },
        0x7e => InsnType::Unary {
            dest: RegisterArg::new(regs[0]),
            op: UnaryOp::Not,
            arg: InsnArg::reg(regs[1]),
        },
        0x7f => InsnType::Unary {
            dest: RegisterArg::new(regs[0]),
            op: UnaryOp::Neg,
            arg: InsnArg::reg(regs[1]),
        },
        0x80 => InsnType::Unary {
            dest: RegisterArg::new(regs[0]),
            op: UnaryOp::Neg,
            arg: InsnArg::reg(regs[1]),
        },

        // Cast operations
        0x81 => InsnType::Cast {
            dest: RegisterArg::new(regs[0]),
            cast_type: CastType::IntToLong,
            arg: InsnArg::reg(regs[1]),
        },
        0x82 => InsnType::Cast {
            dest: RegisterArg::new(regs[0]),
            cast_type: CastType::IntToFloat,
            arg: InsnArg::reg(regs[1]),
        },
        0x83 => InsnType::Cast {
            dest: RegisterArg::new(regs[0]),
            cast_type: CastType::IntToDouble,
            arg: InsnArg::reg(regs[1]),
        },
        0x84 => InsnType::Cast {
            dest: RegisterArg::new(regs[0]),
            cast_type: CastType::LongToInt,
            arg: InsnArg::reg(regs[1]),
        },
        0x85 => InsnType::Cast {
            dest: RegisterArg::new(regs[0]),
            cast_type: CastType::LongToFloat,
            arg: InsnArg::reg(regs[1]),
        },
        0x86 => InsnType::Cast {
            dest: RegisterArg::new(regs[0]),
            cast_type: CastType::LongToDouble,
            arg: InsnArg::reg(regs[1]),
        },
        0x87 => InsnType::Cast {
            dest: RegisterArg::new(regs[0]),
            cast_type: CastType::FloatToInt,
            arg: InsnArg::reg(regs[1]),
        },
        0x88 => InsnType::Cast {
            dest: RegisterArg::new(regs[0]),
            cast_type: CastType::FloatToLong,
            arg: InsnArg::reg(regs[1]),
        },
        0x89 => InsnType::Cast {
            dest: RegisterArg::new(regs[0]),
            cast_type: CastType::FloatToDouble,
            arg: InsnArg::reg(regs[1]),
        },
        0x8a => InsnType::Cast {
            dest: RegisterArg::new(regs[0]),
            cast_type: CastType::DoubleToInt,
            arg: InsnArg::reg(regs[1]),
        },
        0x8b => InsnType::Cast {
            dest: RegisterArg::new(regs[0]),
            cast_type: CastType::DoubleToLong,
            arg: InsnArg::reg(regs[1]),
        },
        0x8c => InsnType::Cast {
            dest: RegisterArg::new(regs[0]),
            cast_type: CastType::DoubleToFloat,
            arg: InsnArg::reg(regs[1]),
        },
        0x8d => InsnType::Cast {
            dest: RegisterArg::new(regs[0]),
            cast_type: CastType::IntToByte,
            arg: InsnArg::reg(regs[1]),
        },
        0x8e => InsnType::Cast {
            dest: RegisterArg::new(regs[0]),
            cast_type: CastType::IntToChar,
            arg: InsnArg::reg(regs[1]),
        },
        0x8f => InsnType::Cast {
            dest: RegisterArg::new(regs[0]),
            cast_type: CastType::IntToShort,
            arg: InsnArg::reg(regs[1]),
        },

        // Binary operations (3 registers)
        0x90 => build_binary_3reg(regs, BinaryOp::Add),
        0x91 => build_binary_3reg(regs, BinaryOp::Sub),
        0x92 => build_binary_3reg(regs, BinaryOp::Mul),
        0x93 => build_binary_3reg(regs, BinaryOp::Div),
        0x94 => build_binary_3reg(regs, BinaryOp::Rem),
        0x95 => build_binary_3reg(regs, BinaryOp::And),
        0x96 => build_binary_3reg(regs, BinaryOp::Or),
        0x97 => build_binary_3reg(regs, BinaryOp::Xor),
        0x98 => build_binary_3reg(regs, BinaryOp::Shl),
        0x99 => build_binary_3reg(regs, BinaryOp::Shr),
        0x9a => build_binary_3reg(regs, BinaryOp::Ushr),

        // Long binary operations
        0x9b => build_binary_3reg(regs, BinaryOp::Add),
        0x9c => build_binary_3reg(regs, BinaryOp::Sub),
        0x9d => build_binary_3reg(regs, BinaryOp::Mul),
        0x9e => build_binary_3reg(regs, BinaryOp::Div),
        0x9f => build_binary_3reg(regs, BinaryOp::Rem),
        0xa0 => build_binary_3reg(regs, BinaryOp::And),
        0xa1 => build_binary_3reg(regs, BinaryOp::Or),
        0xa2 => build_binary_3reg(regs, BinaryOp::Xor),
        0xa3 => build_binary_3reg(regs, BinaryOp::Shl),
        0xa4 => build_binary_3reg(regs, BinaryOp::Shr),
        0xa5 => build_binary_3reg(regs, BinaryOp::Ushr),

        // Float binary operations
        0xa6 => build_binary_3reg(regs, BinaryOp::Add),
        0xa7 => build_binary_3reg(regs, BinaryOp::Sub),
        0xa8 => build_binary_3reg(regs, BinaryOp::Mul),
        0xa9 => build_binary_3reg(regs, BinaryOp::Div),
        0xaa => build_binary_3reg(regs, BinaryOp::Rem),

        // Double binary operations
        0xab => build_binary_3reg(regs, BinaryOp::Add),
        0xac => build_binary_3reg(regs, BinaryOp::Sub),
        0xad => build_binary_3reg(regs, BinaryOp::Mul),
        0xae => build_binary_3reg(regs, BinaryOp::Div),
        0xaf => build_binary_3reg(regs, BinaryOp::Rem),

        // Binary operations 2addr (dest = dest op src)
        0xb0..=0xba => build_binary_2addr(regs, int_binop(opcode - 0xb0)),
        0xbb..=0xc5 => build_binary_2addr(regs, long_binop(opcode - 0xbb)),
        0xc6..=0xca => build_binary_2addr(regs, float_binop(opcode - 0xc6)),
        0xcb..=0xcf => build_binary_2addr(regs, double_binop(opcode - 0xcb)),

        // Binary operations lit16
        0xd0 => build_binary_lit(regs, literal, BinaryOp::Add),
        0xd1 => build_binary_lit(regs, literal, BinaryOp::Rsub),
        0xd2 => build_binary_lit(regs, literal, BinaryOp::Mul),
        0xd3 => build_binary_lit(regs, literal, BinaryOp::Div),
        0xd4 => build_binary_lit(regs, literal, BinaryOp::Rem),
        0xd5 => build_binary_lit(regs, literal, BinaryOp::And),
        0xd6 => build_binary_lit(regs, literal, BinaryOp::Or),
        0xd7 => build_binary_lit(regs, literal, BinaryOp::Xor),

        // Binary operations lit8
        0xd8 => build_binary_lit(regs, literal, BinaryOp::Add),
        0xd9 => build_binary_lit(regs, literal, BinaryOp::Rsub),
        0xda => build_binary_lit(regs, literal, BinaryOp::Mul),
        0xdb => build_binary_lit(regs, literal, BinaryOp::Div),
        0xdc => build_binary_lit(regs, literal, BinaryOp::Rem),
        0xdd => build_binary_lit(regs, literal, BinaryOp::And),
        0xde => build_binary_lit(regs, literal, BinaryOp::Or),
        0xdf => build_binary_lit(regs, literal, BinaryOp::Xor),
        0xe0 => build_binary_lit(regs, literal, BinaryOp::Shl),
        0xe1 => build_binary_lit(regs, literal, BinaryOp::Shr),
        0xe2 => build_binary_lit(regs, literal, BinaryOp::Ushr),

        // DEX 038+ opcodes
        0xfa => InsnType::Invoke {
            kind: InvokeKind::Polymorphic,
            method_idx: index,
            args: build_invoke_args(regs, reg_count),
        },
        0xfb => InsnType::Invoke {
            kind: InvokeKind::Polymorphic,
            method_idx: index,
            args: build_range_args(regs[0], reg_count),
        },
        0xfc => InsnType::Invoke {
            kind: InvokeKind::Custom,
            method_idx: index,
            args: build_invoke_args(regs, reg_count),
        },
        0xfd => InsnType::Invoke {
            kind: InvokeKind::Custom,
            method_idx: index,
            args: build_range_args(regs[0], reg_count),
        },

        // const-method-handle and const-method-type
        0xfe | 0xff => InsnType::Const {
            dest: RegisterArg::new(regs[0]),
            value: LiteralArg::Int(index as i64),
        },

        // Unknown/unused opcodes
        _ => return None,
    };

    Some(InsnNode::new(insn_type, offset))
}

/// Build invoke arguments from register array
fn build_invoke_args(regs: &[u16; 5], count: u8) -> Vec<InsnArg> {
    // Clamp count to max 5 registers (protection against malformed DEX)
    let safe_count = (count as usize).min(5);
    regs[..safe_count]
        .iter()
        .map(|&r| InsnArg::reg(r))
        .collect()
}

/// Build range arguments (consecutive registers)
fn build_range_args(start: u16, count: u8) -> Vec<InsnArg> {
    (0..count as u16)
        .map(|i| InsnArg::reg(start + i))
        .collect()
}

/// Build binary instruction with 3 registers
fn build_binary_3reg(regs: &[u16; 5], op: BinaryOp) -> InsnType {
    InsnType::Binary {
        dest: RegisterArg::new(regs[0]),
        op,
        left: InsnArg::reg(regs[1]),
        right: InsnArg::reg(regs[2]),
    }
}

/// Build binary instruction with 2addr format
fn build_binary_2addr(regs: &[u16; 5], op: BinaryOp) -> InsnType {
    InsnType::Binary {
        dest: RegisterArg::new(regs[0]),
        op,
        left: InsnArg::reg(regs[0]),
        right: InsnArg::reg(regs[1]),
    }
}

/// Build binary instruction with literal
fn build_binary_lit(regs: &[u16; 5], literal: i64, op: BinaryOp) -> InsnType {
    InsnType::Binary {
        dest: RegisterArg::new(regs[0]),
        op,
        left: InsnArg::reg(regs[1]),
        right: InsnArg::lit(literal),
    }
}

/// Get int binary operation from offset
fn int_binop(offset: u8) -> BinaryOp {
    match offset {
        0 => BinaryOp::Add,
        1 => BinaryOp::Sub,
        2 => BinaryOp::Mul,
        3 => BinaryOp::Div,
        4 => BinaryOp::Rem,
        5 => BinaryOp::And,
        6 => BinaryOp::Or,
        7 => BinaryOp::Xor,
        8 => BinaryOp::Shl,
        9 => BinaryOp::Shr,
        10 => BinaryOp::Ushr,
        _ => BinaryOp::Add,
    }
}

/// Get long binary operation from offset
fn long_binop(offset: u8) -> BinaryOp {
    int_binop(offset)
}

/// Get float binary operation from offset
fn float_binop(offset: u8) -> BinaryOp {
    match offset {
        0 => BinaryOp::Add,
        1 => BinaryOp::Sub,
        2 => BinaryOp::Mul,
        3 => BinaryOp::Div,
        4 => BinaryOp::Rem,
        _ => BinaryOp::Add,
    }
}

/// Get double binary operation from offset
fn double_binop(offset: u8) -> BinaryOp {
    float_binop(offset)
}

#[cfg(test)]
mod tests {
    use super::*;

    #[test]
    fn test_build_nop() {
        let insn = build_ir_insn(0x00, 0, &[0; 5], 0, 0, 0, 0).unwrap();
        assert!(matches!(insn.insn_type, InsnType::Nop));
    }

    #[test]
    fn test_build_const() {
        let insn = build_ir_insn(0x12, 0, &[5, 0, 0, 0, 0], 1, 42, 0, 0).unwrap();
        match insn.insn_type {
            InsnType::Const { dest, value } => {
                assert_eq!(dest.reg_num, 5);
                assert!(matches!(value, LiteralArg::Int(42)));
            }
            _ => panic!("Expected Const"),
        }
    }

    #[test]
    fn test_build_invoke() {
        let insn = build_ir_insn(0x6e, 0, &[0, 1, 2, 0, 0], 3, 0, 100, 0).unwrap();
        match insn.insn_type {
            InsnType::Invoke {
                kind,
                method_idx,
                args,
            } => {
                assert_eq!(kind, InvokeKind::Virtual);
                assert_eq!(method_idx, 100);
                assert_eq!(args.len(), 3);
            }
            _ => panic!("Expected Invoke"),
        }
    }

    #[test]
    fn test_build_if() {
        let insn = build_ir_insn(0x32, 10, &[0, 1, 0, 0, 0], 2, 0, 0, 5).unwrap();
        match insn.insn_type {
            InsnType::If {
                condition, target, ..
            } => {
                assert_eq!(condition, IfCondition::Eq);
                assert_eq!(target, 15); // 10 + 5
            }
            _ => panic!("Expected If"),
        }
    }
}
