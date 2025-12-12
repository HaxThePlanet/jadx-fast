//! Instruction decoder

use crate::error::{DexError, Result};
use crate::insns::{DecodedInsn, InsnFormat, Opcode};

/// Decode a single instruction from bytecode
///
/// # Arguments
/// * `code` - The bytecode as 16-bit code units
/// * `offset` - Offset in code units where the instruction starts
pub fn decode_instruction(code: &[u16], offset: u32) -> Result<DecodedInsn> {
    let idx = offset as usize;
    if idx >= code.len() {
        return Err(DexError::UnexpectedEof {
            offset: idx * 2,
            needed: 2,
        });
    }

    let unit0 = code[idx];
    let opcode_byte = (unit0 & 0xFF) as u8;

    let opcode = Opcode::from_u8(opcode_byte).ok_or(DexError::InvalidOpcode(opcode_byte))?;

    let format = opcode.format();
    let mut insn = DecodedInsn::new(opcode, format, offset);

    // Decode based on format
    use InsnFormat::*;
    match format {
        Format10x => {
            // No operands
        }

        Format12x => {
            // vA, vB in upper byte
            insn.regs[0] = ((unit0 >> 8) & 0x0F) as u16;
            insn.regs[1] = ((unit0 >> 12) & 0x0F) as u16;
            insn.reg_count = 2;
        }

        Format11n => {
            // vA in bits 8-11, literal in bits 12-15 (sign-extended)
            insn.regs[0] = ((unit0 >> 8) & 0x0F) as u16;
            insn.reg_count = 1;
            let lit = ((unit0 as i16) >> 12) as i64;
            insn.literal = lit;
        }

        Format11x => {
            // vAA in bits 8-15
            insn.regs[0] = ((unit0 >> 8) & 0xFF) as u16;
            insn.reg_count = 1;
        }

        Format10t => {
            // Signed offset in bits 8-15
            let offset_byte = ((unit0 >> 8) & 0xFF) as i8;
            insn.target = offset_byte as i32;
        }

        Format20t => {
            // Signed 16-bit offset in unit1
            let unit1 = get_unit(code, idx + 1)?;
            insn.target = unit1 as i16 as i32;
        }

        Format22x => {
            // vAA, vBBBB
            insn.regs[0] = ((unit0 >> 8) & 0xFF) as u16;
            insn.regs[1] = get_unit(code, idx + 1)?;
            insn.reg_count = 2;
        }

        Format21t => {
            // vAA, +BBBB (register, branch offset)
            insn.regs[0] = ((unit0 >> 8) & 0xFF) as u16;
            insn.reg_count = 1;
            let unit1 = get_unit(code, idx + 1)?;
            insn.target = unit1 as i16 as i32;
        }

        Format21s => {
            // vAA, #+BBBB (register, signed literal)
            insn.regs[0] = ((unit0 >> 8) & 0xFF) as u16;
            insn.reg_count = 1;
            let unit1 = get_unit(code, idx + 1)?;
            insn.literal = unit1 as i16 as i64;
        }

        Format21h => {
            // vAA, #+BBBB0000 or #+BBBB000000000000
            insn.regs[0] = ((unit0 >> 8) & 0xFF) as u16;
            insn.reg_count = 1;
            let unit1 = get_unit(code, idx + 1)?;
            // For const/high16, shift by 16. For const-wide/high16, shift by 48.
            if matches!(opcode, Opcode::ConstHigh16) {
                insn.literal = ((unit1 as i32) << 16) as i64;
            } else {
                insn.literal = (unit1 as i64) << 48;
            }
        }

        Format21c => {
            // vAA, kind@BBBB
            insn.regs[0] = ((unit0 >> 8) & 0xFF) as u16;
            insn.reg_count = 1;
            insn.index = get_unit(code, idx + 1)? as u32;
        }

        Format23x => {
            // vAA, vBB, vCC
            insn.regs[0] = ((unit0 >> 8) & 0xFF) as u16;
            let unit1 = get_unit(code, idx + 1)?;
            insn.regs[1] = (unit1 & 0xFF) as u16;
            insn.regs[2] = ((unit1 >> 8) & 0xFF) as u16;
            insn.reg_count = 3;
        }

        Format22b => {
            // vAA, vBB, #+CC
            insn.regs[0] = ((unit0 >> 8) & 0xFF) as u16;
            let unit1 = get_unit(code, idx + 1)?;
            insn.regs[1] = (unit1 & 0xFF) as u16;
            insn.reg_count = 2;
            insn.literal = ((unit1 >> 8) as i8) as i64;
        }

        Format22t => {
            // vA, vB, +CCCC
            insn.regs[0] = ((unit0 >> 8) & 0x0F) as u16;
            insn.regs[1] = ((unit0 >> 12) & 0x0F) as u16;
            insn.reg_count = 2;
            let unit1 = get_unit(code, idx + 1)?;
            insn.target = unit1 as i16 as i32;
        }

        Format22s => {
            // vA, vB, #+CCCC
            insn.regs[0] = ((unit0 >> 8) & 0x0F) as u16;
            insn.regs[1] = ((unit0 >> 12) & 0x0F) as u16;
            insn.reg_count = 2;
            let unit1 = get_unit(code, idx + 1)?;
            insn.literal = unit1 as i16 as i64;
        }

        Format22c => {
            // vA, vB, kind@CCCC
            insn.regs[0] = ((unit0 >> 8) & 0x0F) as u16;
            insn.regs[1] = ((unit0 >> 12) & 0x0F) as u16;
            insn.reg_count = 2;
            insn.index = get_unit(code, idx + 1)? as u32;
        }

        Format30t => {
            // +AAAAAAAA (32-bit signed offset)
            let unit1 = get_unit(code, idx + 1)?;
            let unit2 = get_unit(code, idx + 2)?;
            insn.target = ((unit2 as u32) << 16 | unit1 as u32) as i32;
        }

        Format32x => {
            // vAAAA, vBBBB
            insn.regs[0] = get_unit(code, idx + 1)?;
            insn.regs[1] = get_unit(code, idx + 2)?;
            insn.reg_count = 2;
        }

        Format31i => {
            // vAA, #+BBBBBBBB
            insn.regs[0] = ((unit0 >> 8) & 0xFF) as u16;
            insn.reg_count = 1;
            let unit1 = get_unit(code, idx + 1)?;
            let unit2 = get_unit(code, idx + 2)?;
            insn.literal = ((unit2 as u32) << 16 | unit1 as u32) as i32 as i64;
        }

        Format31t => {
            // vAA, +BBBBBBBB (32-bit signed offset)
            insn.regs[0] = ((unit0 >> 8) & 0xFF) as u16;
            insn.reg_count = 1;
            let unit1 = get_unit(code, idx + 1)?;
            let unit2 = get_unit(code, idx + 2)?;
            insn.target = ((unit2 as u32) << 16 | unit1 as u32) as i32;
        }

        Format31c => {
            // vAA, string@BBBBBBBB
            insn.regs[0] = ((unit0 >> 8) & 0xFF) as u16;
            insn.reg_count = 1;
            let unit1 = get_unit(code, idx + 1)?;
            let unit2 = get_unit(code, idx + 2)?;
            insn.index = (unit2 as u32) << 16 | unit1 as u32;
        }

        Format35c => {
            // [A=count] op {vC, vD, vE, vF, vG}, kind@BBBB
            let count = ((unit0 >> 12) & 0x0F) as u8;
            insn.index = get_unit(code, idx + 1)? as u32;
            let unit2 = get_unit(code, idx + 2)?;

            insn.reg_count = count;
            if count > 0 {
                insn.regs[0] = (unit2 & 0x0F) as u16;
            }
            if count > 1 {
                insn.regs[1] = ((unit2 >> 4) & 0x0F) as u16;
            }
            if count > 2 {
                insn.regs[2] = ((unit2 >> 8) & 0x0F) as u16;
            }
            if count > 3 {
                insn.regs[3] = ((unit2 >> 12) & 0x0F) as u16;
            }
            if count > 4 {
                insn.regs[4] = ((unit0 >> 8) & 0x0F) as u16;
            }
        }

        Format3rc => {
            // op {vCCCC .. vNNNN}, kind@BBBB
            let count = ((unit0 >> 8) & 0xFF) as u8;
            insn.index = get_unit(code, idx + 1)? as u32;
            let start_reg = get_unit(code, idx + 2)?;

            insn.reg_count = count;
            insn.regs[0] = start_reg; // Store start register
            // For range, we store (start_reg, count) pattern
        }

        Format45cc => {
            // op {vC, vD, vE, vF, vG}, meth@BBBB, proto@HHHH
            let count = ((unit0 >> 12) & 0x0F) as u8;
            insn.index = get_unit(code, idx + 1)? as u32;
            let unit2 = get_unit(code, idx + 2)?;
            let _proto_idx = get_unit(code, idx + 3)?;

            insn.reg_count = count;
            if count > 0 {
                insn.regs[0] = (unit2 & 0x0F) as u16;
            }
            if count > 1 {
                insn.regs[1] = ((unit2 >> 4) & 0x0F) as u16;
            }
            if count > 2 {
                insn.regs[2] = ((unit2 >> 8) & 0x0F) as u16;
            }
            if count > 3 {
                insn.regs[3] = ((unit2 >> 12) & 0x0F) as u16;
            }
            if count > 4 {
                insn.regs[4] = ((unit0 >> 8) & 0x0F) as u16;
            }
        }

        Format4rcc => {
            // op {vCCCC .. vNNNN}, meth@BBBB, proto@HHHH
            let count = ((unit0 >> 8) & 0xFF) as u8;
            insn.index = get_unit(code, idx + 1)? as u32;
            let start_reg = get_unit(code, idx + 2)?;
            let _proto_idx = get_unit(code, idx + 3)?;

            insn.reg_count = count;
            insn.regs[0] = start_reg;
        }

        Format51l => {
            // vAA, #+BBBBBBBBBBBBBBBB
            insn.regs[0] = ((unit0 >> 8) & 0xFF) as u16;
            insn.reg_count = 1;
            let unit1 = get_unit(code, idx + 1)? as u64;
            let unit2 = get_unit(code, idx + 2)? as u64;
            let unit3 = get_unit(code, idx + 3)? as u64;
            let unit4 = get_unit(code, idx + 4)? as u64;
            insn.literal = (unit4 << 48 | unit3 << 32 | unit2 << 16 | unit1) as i64;
        }
    }

    Ok(insn)
}

#[inline]
fn get_unit(code: &[u16], idx: usize) -> Result<u16> {
    code.get(idx).copied().ok_or(DexError::UnexpectedEof {
        offset: idx * 2,
        needed: 2,
    })
}

/// Iterator over instructions in a code block
pub struct InsnIterator<'a> {
    code: &'a [u16],
    offset: u32,
}

impl<'a> InsnIterator<'a> {
    /// Create a new instruction iterator
    pub fn new(code: &'a [u16]) -> Self {
        InsnIterator { code, offset: 0 }
    }

    /// Get the current offset in code units
    pub fn offset(&self) -> u32 {
        self.offset
    }
}

impl<'a> Iterator for InsnIterator<'a> {
    type Item = Result<DecodedInsn>;

    fn next(&mut self) -> Option<Self::Item> {
        if self.offset as usize >= self.code.len() {
            return None;
        }

        match decode_instruction(self.code, self.offset) {
            Ok(insn) => {
                self.offset += insn.size as u32;
                Some(Ok(insn))
            }
            Err(e) => {
                // Move past this instruction to avoid infinite loop
                self.offset += 1;
                Some(Err(e))
            }
        }
    }
}

#[cfg(test)]
mod tests {
    use super::*;

    #[test]
    fn test_decode_nop() {
        let code = [0x0000u16]; // nop
        let insn = decode_instruction(&code, 0).unwrap();
        assert_eq!(insn.opcode, Opcode::Nop);
        assert_eq!(insn.size, 1);
    }

    #[test]
    fn test_decode_return_void() {
        let code = [0x000eu16]; // return-void
        let insn = decode_instruction(&code, 0).unwrap();
        assert_eq!(insn.opcode, Opcode::ReturnVoid);
    }

    #[test]
    fn test_decode_const4() {
        // const/4 v0, #1: opcode=0x12, vA=0, literal=1
        // Encoding: 0x12 | (vA << 8) | (lit << 12) = 0x12 | 0 | 0x1000 = 0x1012
        let code = [0x1012u16]; // const/4 v0, #1
        let insn = decode_instruction(&code, 0).unwrap();
        assert_eq!(insn.opcode, Opcode::Const4);
        assert_eq!(insn.regs[0], 0);
        assert_eq!(insn.literal, 1);
    }

    #[test]
    fn test_decode_const16() {
        // const/16 v0, #255: opcode=0x13, vAA=0, literal=255
        // Encoding: 0x13 | (vAA << 8), then 0x00FF
        let code = [0x0013u16, 0x00FFu16]; // const/16 v0, #255
        let insn = decode_instruction(&code, 0).unwrap();
        assert_eq!(insn.opcode, Opcode::Const16);
        assert_eq!(insn.regs[0], 0);
        assert_eq!(insn.literal, 255);
    }

    #[test]
    fn test_decode_goto() {
        let code = [0x0328u16]; // goto +3
        let insn = decode_instruction(&code, 0).unwrap();
        assert_eq!(insn.opcode, Opcode::Goto);
        assert_eq!(insn.target, 3);
    }

    #[test]
    fn test_insn_iterator() {
        let code = [0x0000u16, 0x000eu16]; // nop; return-void
        let insns: Vec<_> = InsnIterator::new(&code).collect();
        assert_eq!(insns.len(), 2);
        assert!(insns[0].is_ok());
        assert!(insns[1].is_ok());
    }
}
