//! Method code item parsing
//!
//! The code_item contains the actual bytecode for a method.

use crate::error::{DexError, Result};
use crate::reader::DexReader;
use crate::sections::{read_u16, read_u32};
use crate::utils::read_uleb128;

/// A method's code item containing bytecode and metadata
///
/// Structure:
/// - registers_size (u16): number of registers used
/// - ins_size (u16): number of words of incoming arguments
/// - outs_size (u16): number of words of outgoing arguments
/// - tries_size (u16): number of try_item entries
/// - debug_info_off (u32): offset to debug info (0 if none)
/// - insns_size (u32): size of instructions in 16-bit code units
/// - insns[insns_size] (u16[]): actual bytecode
/// - [padding] (u16): present if tries_size > 0 and insns_size is odd
/// - tries[tries_size] (try_item[]): exception handler ranges
/// - handlers (encoded_catch_handler_list): catch handlers
pub struct CodeItem<'a> {
    reader: &'a DexReader,
    /// Number of registers used by this code
    pub registers_size: u16,
    /// Number of words of incoming arguments
    pub ins_size: u16,
    /// Number of words of outgoing argument space
    pub outs_size: u16,
    /// Number of try_items
    pub tries_size: u16,
    /// Offset to debug info (0 if none)
    pub debug_info_off: u32,
    /// Offset to the instruction data within the DEX file
    insns_offset: usize,
    /// Size of instructions in 16-bit code units
    pub insns_size: u32,
    /// Try items (if any)
    tries_offset: usize,
}

impl<'a> CodeItem<'a> {
    /// Header size before instructions (in bytes)
    const HEADER_SIZE: usize = 16;

    /// Parse a code_item at the given offset
    pub fn parse(reader: &'a DexReader, offset: u32) -> Result<Self> {
        if offset == 0 {
            return Err(DexError::InvalidOffset {
                section: "code_item",
                offset: 0,
            });
        }

        let data = reader.data();
        let off = offset as usize;

        if off + Self::HEADER_SIZE > data.len() {
            return Err(DexError::UnexpectedEof {
                offset: off,
                needed: Self::HEADER_SIZE,
            });
        }

        let registers_size = read_u16(data, off);
        let ins_size = read_u16(data, off + 2);
        let outs_size = read_u16(data, off + 4);
        let tries_size = read_u16(data, off + 6);
        let debug_info_off = read_u32(data, off + 8);
        let insns_size = read_u32(data, off + 12);

        let insns_offset = off + Self::HEADER_SIZE;
        let insns_bytes = insns_size as usize * 2;

        if insns_offset + insns_bytes > data.len() {
            return Err(DexError::UnexpectedEof {
                offset: insns_offset,
                needed: insns_bytes,
            });
        }

        // Calculate tries offset (after instructions + optional padding)
        let tries_offset = if tries_size > 0 {
            let mut off = insns_offset + insns_bytes;
            // Padding to align to 4 bytes if insns_size is odd
            if insns_size % 2 != 0 {
                off += 2;
            }
            off
        } else {
            0
        };

        Ok(CodeItem {
            reader,
            registers_size,
            ins_size,
            outs_size,
            tries_size,
            debug_info_off,
            insns_offset,
            insns_size,
            tries_offset,
        })
    }

    /// Get the bytecode as 16-bit code units
    pub fn instructions(&self) -> &[u16] {
        let data = self.reader.data();
        let start = self.insns_offset;
        let end = start + (self.insns_size as usize * 2);

        // Safety: We verified bounds in parse()
        // Convert &[u8] to &[u16] - assumes little-endian alignment
        unsafe {
            std::slice::from_raw_parts(
                data[start..end].as_ptr() as *const u16,
                self.insns_size as usize,
            )
        }
    }

    /// Get try items (exception handler ranges)
    pub fn try_items(&self) -> Result<Vec<TryItem>> {
        if self.tries_size == 0 {
            return Ok(Vec::new());
        }

        let data = self.reader.data();
        let mut items = Vec::with_capacity(self.tries_size as usize);

        for i in 0..self.tries_size as usize {
            let off = self.tries_offset + (i * TryItem::SIZE);
            items.push(TryItem {
                start_addr: read_u32(data, off),
                insn_count: read_u16(data, off + 4),
                handler_off: read_u16(data, off + 6),
            });
        }

        Ok(items)
    }

    /// Get catch handlers for this code
    pub fn catch_handlers(&self) -> Result<Vec<CatchHandler>> {
        if self.tries_size == 0 {
            return Ok(Vec::new());
        }

        let data = self.reader.data();
        // Handlers come after try items
        let handlers_offset = self.tries_offset + (self.tries_size as usize * TryItem::SIZE);

        let (handler_count, mut pos) = read_uleb128(&data[handlers_offset..])?;
        pos += handlers_offset;

        let mut handlers = Vec::with_capacity(handler_count as usize);

        for _ in 0..handler_count {
            let (size, len) = read_sleb128(&data[pos..])?;
            pos += len;

            let has_catch_all = size <= 0;
            let pair_count = size.unsigned_abs() as usize;

            let mut pairs = Vec::with_capacity(pair_count);
            for _ in 0..pair_count {
                let (type_idx, len) = read_uleb128(&data[pos..])?;
                pos += len;
                let (addr, len) = read_uleb128(&data[pos..])?;
                pos += len;
                pairs.push(TypeAddrPair { type_idx, addr });
            }

            let catch_all_addr = if has_catch_all {
                let (addr, len) = read_uleb128(&data[pos..])?;
                pos += len;
                Some(addr)
            } else {
                None
            };

            handlers.push(CatchHandler {
                pairs,
                catch_all_addr,
            });
        }

        Ok(handlers)
    }

    /// Parse debug info to extract parameter names
    /// Returns (parameter_names, line_start) where parameter_names[i] is Some(string_idx) or None
    pub fn parse_debug_info(&self) -> Result<Option<DebugInfoItem>> {
        if self.debug_info_off == 0 {
            return Ok(None);
        }

        let data = self.reader.data();
        let off = self.debug_info_off as usize;

        if off >= data.len() {
            return Ok(None);
        }

        // Read line_start (uleb128)
        let (line_start, mut pos) = read_uleb128(&data[off..])?;
        pos += off;

        // Read parameters_size (uleb128)
        let (params_size, len) = read_uleb128(&data[pos..])?;
        pos += len;

        // Read parameter names (uleb128 string indices)
        // Value of 0 means NO_INDEX (no name for this parameter)
        let mut param_names = Vec::with_capacity(params_size as usize);
        for _ in 0..params_size {
            let (string_idx, len) = read_uleb128(&data[pos..])?;
            pos += len;
            // uleb128 encoded NO_INDEX is represented as 0 in the file
            // but the actual NO_INDEX value is 0xFFFFFFFF
            // Since uleb128 can't encode negative numbers directly,
            // the convention is: value 0 = NO_INDEX, value N = string_idx N-1
            // Actually, looking at AOSP docs: "NO_INDEX is encoded as 0"
            // So 0 means no name, and N>0 means string_idx = N-1
            let name_idx = if string_idx == 0 {
                None
            } else {
                Some(string_idx - 1)
            };
            param_names.push(name_idx);
        }

        Ok(Some(DebugInfoItem {
            line_start,
            param_names,
        }))
    }

    /// Get parameter names as strings (resolving string indices)
    pub fn get_parameter_names(&self) -> Result<Vec<Option<String>>> {
        let debug_info = self.parse_debug_info()?;

        match debug_info {
            Some(info) => {
                let mut names = Vec::with_capacity(info.param_names.len());
                for name_idx in info.param_names {
                    let name = match name_idx {
                        Some(idx) => self.reader.get_string(idx).ok().map(|s| (*s).to_string()),
                        None => None,
                    };
                    names.push(name);
                }
                Ok(names)
            }
            None => Ok(Vec::new()),
        }
    }
}

/// Parsed debug_info_item
#[derive(Debug, Clone)]
pub struct DebugInfoItem {
    /// Initial line number
    pub line_start: u32,
    /// Parameter name string indices (None = no name)
    pub param_names: Vec<Option<u32>>,
}

impl std::fmt::Debug for CodeItem<'_> {
    fn fmt(&self, f: &mut std::fmt::Formatter<'_>) -> std::fmt::Result {
        f.debug_struct("CodeItem")
            .field("registers_size", &self.registers_size)
            .field("ins_size", &self.ins_size)
            .field("outs_size", &self.outs_size)
            .field("tries_size", &self.tries_size)
            .field("insns_size", &self.insns_size)
            .finish()
    }
}

/// A try block range
#[derive(Debug, Clone)]
pub struct TryItem {
    /// Start address (code unit offset)
    pub start_addr: u32,
    /// Number of code units covered
    pub insn_count: u16,
    /// Offset into handler list
    pub handler_off: u16,
}

impl TryItem {
    const SIZE: usize = 8;

    /// End address (exclusive)
    pub fn end_addr(&self) -> u32 {
        self.start_addr + self.insn_count as u32
    }
}

/// A catch handler with type/address pairs
#[derive(Debug, Clone)]
pub struct CatchHandler {
    /// Type/address pairs for typed catches
    pub pairs: Vec<TypeAddrPair>,
    /// Address of catch-all handler (if any)
    pub catch_all_addr: Option<u32>,
}

/// A type index and handler address pair
#[derive(Debug, Clone)]
pub struct TypeAddrPair {
    /// Type index (into type_ids)
    pub type_idx: u32,
    /// Handler address (code unit offset)
    pub addr: u32,
}

/// Read a signed LEB128 value
fn read_sleb128(data: &[u8]) -> Result<(i32, usize)> {
    let mut result: i32 = 0;
    let mut shift = 0;
    let mut pos = 0;

    loop {
        if pos >= data.len() {
            return Err(DexError::UnexpectedEof {
                offset: pos,
                needed: 1,
            });
        }

        let byte = data[pos];
        pos += 1;

        result |= ((byte & 0x7f) as i32) << shift;
        shift += 7;

        if byte & 0x80 == 0 {
            // Sign extend if necessary
            if shift < 32 && (byte & 0x40) != 0 {
                result |= !0 << shift;
            }
            break;
        }

        if shift >= 35 {
            return Err(DexError::InvalidLeb128);
        }
    }

    Ok((result, pos))
}

#[cfg(test)]
mod tests {
    use super::*;

    #[test]
    fn test_sleb128() {
        // 0
        assert_eq!(read_sleb128(&[0x00]).unwrap(), (0, 1));
        // 1
        assert_eq!(read_sleb128(&[0x01]).unwrap(), (1, 1));
        // -1
        assert_eq!(read_sleb128(&[0x7f]).unwrap(), (-1, 1));
        // 127
        assert_eq!(read_sleb128(&[0xff, 0x00]).unwrap(), (127, 2));
        // -128
        assert_eq!(read_sleb128(&[0x80, 0x7f]).unwrap(), (-128, 2));
    }
}
