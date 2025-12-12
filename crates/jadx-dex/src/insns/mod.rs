//! Dalvik instruction decoding
//!
//! This module provides types and functions for decoding Dalvik bytecode instructions.

mod decoder;
mod format;
mod opcode;

pub use decoder::{decode_instruction, InsnIterator};
pub use format::InsnFormat;
pub use opcode::Opcode;

/// A decoded Dalvik instruction
#[derive(Debug, Clone)]
pub struct DecodedInsn {
    /// The opcode
    pub opcode: Opcode,
    /// Instruction format
    pub format: InsnFormat,
    /// Offset in code units (2 bytes each)
    pub offset: u32,
    /// Size in code units
    pub size: u8,
    /// Register arguments (up to 5)
    pub regs: [u16; 5],
    /// Number of register arguments
    pub reg_count: u8,
    /// Literal value (for const instructions)
    pub literal: i64,
    /// Index into string/type/method/field table
    pub index: u32,
    /// Branch target offset (relative, in code units)
    pub target: i32,
}

impl DecodedInsn {
    /// Create a new decoded instruction
    pub fn new(opcode: Opcode, format: InsnFormat, offset: u32) -> Self {
        DecodedInsn {
            opcode,
            format,
            offset,
            size: format.size(),
            regs: [0; 5],
            reg_count: 0,
            literal: 0,
            index: 0,
            target: 0,
        }
    }

    /// Get register A (first register)
    pub fn reg_a(&self) -> u16 {
        self.regs[0]
    }

    /// Get register B (second register)
    pub fn reg_b(&self) -> u16 {
        self.regs[1]
    }

    /// Get register C (third register)
    pub fn reg_c(&self) -> u16 {
        self.regs[2]
    }

    /// Get register D (fourth register)
    pub fn reg_d(&self) -> u16 {
        self.regs[3]
    }

    /// Get register E (fifth register)
    pub fn reg_e(&self) -> u16 {
        self.regs[4]
    }

    /// Check if this is a branch instruction
    pub fn is_branch(&self) -> bool {
        matches!(
            self.opcode,
            Opcode::Goto
                | Opcode::Goto16
                | Opcode::Goto32
                | Opcode::IfEq
                | Opcode::IfNe
                | Opcode::IfLt
                | Opcode::IfGe
                | Opcode::IfGt
                | Opcode::IfLe
                | Opcode::IfEqz
                | Opcode::IfNez
                | Opcode::IfLtz
                | Opcode::IfGez
                | Opcode::IfGtz
                | Opcode::IfLez
                | Opcode::PackedSwitch
                | Opcode::SparseSwitch
        )
    }

    /// Check if this is a return instruction
    pub fn is_return(&self) -> bool {
        matches!(
            self.opcode,
            Opcode::ReturnVoid | Opcode::Return | Opcode::ReturnWide | Opcode::ReturnObject
        )
    }

    /// Check if this is a throw instruction
    pub fn is_throw(&self) -> bool {
        matches!(self.opcode, Opcode::Throw)
    }

    /// Check if this instruction ends a basic block
    pub fn ends_block(&self) -> bool {
        self.is_branch() || self.is_return() || self.is_throw()
    }

    /// Get the absolute target address for a branch
    pub fn branch_target(&self) -> u32 {
        (self.offset as i32 + self.target) as u32
    }
}
