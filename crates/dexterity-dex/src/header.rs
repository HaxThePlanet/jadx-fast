//! DEX file header parsing
//!
//! The DEX header is a fixed 112-byte structure at the beginning of every DEX file.

use crate::consts::map_types;
use crate::error::{DexError, Result};
use crate::{ENDIAN_CONSTANT, DEX_MAGIC};

/// DEX file header (112 bytes)
#[derive(Debug, Clone)]
pub struct DexHeader {
    /// DEX version string (e.g., "035", "039")
    pub version: String,
    /// Adler32 checksum of file contents (excluding magic and this field)
    pub checksum: u32,
    /// SHA-1 signature (20 bytes)
    pub signature: [u8; 20],
    /// Total file size in bytes
    pub file_size: u32,
    /// Header size (should be 0x70 = 112)
    pub header_size: u32,
    /// Link section size
    pub link_size: u32,
    /// Link section offset
    pub link_off: u32,
    /// Map list offset
    pub map_off: u32,
    /// Number of strings in string_ids
    pub string_ids_size: u32,
    /// Offset to string_ids section
    pub string_ids_off: u32,
    /// Number of types in type_ids
    pub type_ids_size: u32,
    /// Offset to type_ids section
    pub type_ids_off: u32,
    /// Number of prototypes in proto_ids
    pub proto_ids_size: u32,
    /// Offset to proto_ids section
    pub proto_ids_off: u32,
    /// Number of fields in field_ids
    pub field_ids_size: u32,
    /// Offset to field_ids section
    pub field_ids_off: u32,
    /// Number of methods in method_ids
    pub method_ids_size: u32,
    /// Offset to method_ids section
    pub method_ids_off: u32,
    /// Number of class definitions
    pub class_defs_size: u32,
    /// Offset to class_defs section
    pub class_defs_off: u32,
    /// Size of data section
    pub data_size: u32,
    /// Offset to data section
    pub data_off: u32,

    // Additional offsets from map list
    /// Offset to call site items (DEX 038+)
    pub call_site_off: Option<u32>,
    /// Offset to method handle items (DEX 038+)
    pub method_handle_off: Option<u32>,
}

impl DexHeader {
    /// Parse a DEX header from raw bytes
    pub fn parse(data: &[u8]) -> Result<Self> {
        if data.len() < 112 {
            return Err(DexError::UnexpectedEof {
                offset: 0,
                needed: 112,
            });
        }

        // Check magic bytes
        if data[0..4] != DEX_MAGIC {
            return Err(DexError::InvalidMagic);
        }

        // Read version (3 bytes at offset 4)
        let version = String::from_utf8_lossy(&data[4..7]).to_string();

        // Skip newline at offset 7, read checksum at offset 8
        let checksum = u32::from_le_bytes([data[8], data[9], data[10], data[11]]);

        // Read signature (20 bytes at offset 12)
        let mut signature = [0u8; 20];
        signature.copy_from_slice(&data[12..32]);

        // Read remaining header fields
        let file_size = read_u32(data, 32);
        let header_size = read_u32(data, 36);
        let endian_tag = read_u32(data, 40);

        if endian_tag != ENDIAN_CONSTANT {
            return Err(DexError::InvalidEndian(endian_tag));
        }

        let link_size = read_u32(data, 44);
        let link_off = read_u32(data, 48);
        let map_off = read_u32(data, 52);
        let string_ids_size = read_u32(data, 56);
        let string_ids_off = read_u32(data, 60);
        let type_ids_size = read_u32(data, 64);
        let type_ids_off = read_u32(data, 68);
        let proto_ids_size = read_u32(data, 72);
        let proto_ids_off = read_u32(data, 76);
        let field_ids_size = read_u32(data, 80);
        let field_ids_off = read_u32(data, 84);
        let method_ids_size = read_u32(data, 88);
        let method_ids_off = read_u32(data, 92);
        let class_defs_size = read_u32(data, 96);
        let class_defs_off = read_u32(data, 100);
        let data_size = read_u32(data, 104);
        let data_off = read_u32(data, 108);

        // Parse map list for additional offsets
        let (call_site_off, method_handle_off) = if map_off > 0 {
            parse_map_list(data, map_off as usize)?
        } else {
            (None, None)
        };

        Ok(DexHeader {
            version,
            checksum,
            signature,
            file_size,
            header_size,
            link_size,
            link_off,
            map_off,
            string_ids_size,
            string_ids_off,
            type_ids_size,
            type_ids_off,
            proto_ids_size,
            proto_ids_off,
            field_ids_size,
            field_ids_off,
            method_ids_size,
            method_ids_off,
            class_defs_size,
            class_defs_off,
            data_size,
            data_off,
            call_site_off,
            method_handle_off,
        })
    }

    /// Check if this DEX file supports method handles (version 038+)
    pub fn supports_method_handles(&self) -> bool {
        matches!(self.version.as_str(), "038" | "039" | "040" | "041")
    }
}

/// Parse the map list to extract additional section offsets
fn parse_map_list(data: &[u8], offset: usize) -> Result<(Option<u32>, Option<u32>)> {
    if offset + 4 > data.len() {
        return Err(DexError::UnexpectedEof {
            offset,
            needed: 4,
        });
    }

    let size = read_u32(data, offset) as usize;
    let mut call_site_off = None;
    let mut method_handle_off = None;

    // Each map item is 12 bytes: type (2) + unused (2) + size (4) + offset (4)
    for i in 0..size {
        let item_offset = offset + 4 + (i * 12);
        if item_offset + 12 > data.len() {
            break;
        }

        let item_type = read_u16(data, item_offset);
        let item_off = read_u32(data, item_offset + 8);

        match item_type {
            map_types::TYPE_CALL_SITE_ID_ITEM => {
                call_site_off = Some(item_off);
            }
            map_types::TYPE_METHOD_HANDLE_ITEM => {
                method_handle_off = Some(item_off);
            }
            _ => {}
        }
    }

    Ok((call_site_off, method_handle_off))
}

#[inline]
fn read_u32(data: &[u8], offset: usize) -> u32 {
    u32::from_le_bytes([
        data[offset],
        data[offset + 1],
        data[offset + 2],
        data[offset + 3],
    ])
}

#[inline]
fn read_u16(data: &[u8], offset: usize) -> u16 {
    u16::from_le_bytes([data[offset], data[offset + 1]])
}

#[cfg(test)]
mod tests {
    use super::*;

    #[test]
    fn test_header_size() {
        // Minimum header size is 112 bytes
        let small_data = vec![0u8; 100];
        assert!(DexHeader::parse(&small_data).is_err());
    }

    #[test]
    fn test_invalid_magic() {
        let mut data = vec![0u8; 112];
        // Wrong magic
        data[0..4].copy_from_slice(&[0x00, 0x00, 0x00, 0x00]);
        assert!(matches!(
            DexHeader::parse(&data),
            Err(DexError::InvalidMagic)
        ));
    }
}
