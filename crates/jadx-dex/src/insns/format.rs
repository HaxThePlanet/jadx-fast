//! Dalvik instruction formats
//!
//! Each format defines how the instruction is encoded in bytecode.
//! Format names follow the pattern: FormatXXy where XX is size in 16-bit units
//! and y describes the types of arguments.

/// Instruction format
#[derive(Debug, Clone, Copy, PartialEq, Eq)]
pub enum InsnFormat {
    /// 10x: op (no registers, no arguments)
    Format10x,
    /// 12x: op vA, vB (4-bit registers)
    Format12x,
    /// 11n: op vA, #+B (4-bit register, 4-bit literal)
    Format11n,
    /// 11x: op vAA (8-bit register)
    Format11x,
    /// 10t: op +AA (8-bit branch offset)
    Format10t,
    /// 20t: op +AAAA (16-bit branch offset)
    Format20t,
    /// 22x: op vAA, vBBBB (8-bit + 16-bit registers)
    Format22x,
    /// 21t: op vAA, +BBBB (8-bit register, 16-bit branch)
    Format21t,
    /// 21s: op vAA, #+BBBB (8-bit register, 16-bit literal)
    Format21s,
    /// 21h: op vAA, #+BBBB0000[00000000] (high bits literal)
    Format21h,
    /// 21c: op vAA, kind@BBBB (8-bit register, 16-bit index)
    Format21c,
    /// 23x: op vAA, vBB, vCC (8-bit registers)
    Format23x,
    /// 22b: op vAA, vBB, #+CC (two 8-bit regs, 8-bit literal)
    Format22b,
    /// 22t: op vA, vB, +CCCC (4-bit regs, 16-bit branch)
    Format22t,
    /// 22s: op vA, vB, #+CCCC (4-bit regs, 16-bit literal)
    Format22s,
    /// 22c: op vA, vB, kind@CCCC (4-bit regs, 16-bit index)
    Format22c,
    /// 30t: op +AAAAAAAA (32-bit branch offset)
    Format30t,
    /// 32x: op vAAAA, vBBBB (two 16-bit registers)
    Format32x,
    /// 31i: op vAA, #+BBBBBBBB (8-bit reg, 32-bit literal)
    Format31i,
    /// 31t: op vAA, +BBBBBBBB (8-bit reg, 32-bit branch/offset)
    Format31t,
    /// 31c: op vAA, string@BBBBBBBB (8-bit reg, 32-bit string index)
    Format31c,
    /// 35c: [A=5] op {vC, vD, vE, vF, vG}, kind@BBBB
    Format35c,
    /// 3rc: op {vCCCC .. vNNNN}, kind@BBBB (range invoke)
    Format3rc,
    /// 45cc: op {vC, vD, vE, vF, vG}, meth@BBBB, proto@HHHH
    Format45cc,
    /// 4rcc: op {vCCCC .. vNNNN}, meth@BBBB, proto@HHHH
    Format4rcc,
    /// 51l: op vAA, #+BBBBBBBBBBBBBBBB (8-bit reg, 64-bit literal)
    Format51l,
}

impl InsnFormat {
    /// Size of the instruction in code units (16-bit units)
    pub fn size(self) -> u8 {
        use InsnFormat::*;
        match self {
            Format10x | Format12x | Format11n | Format11x | Format10t => 1,
            Format20t | Format22x | Format21t | Format21s | Format21h | Format21c | Format23x
            | Format22b | Format22t | Format22s | Format22c => 2,
            Format30t | Format32x | Format31i | Format31t | Format31c | Format35c | Format3rc => 3,
            Format45cc | Format4rcc => 4,
            Format51l => 5,
        }
    }
}
