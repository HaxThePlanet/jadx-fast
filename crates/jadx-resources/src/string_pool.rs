//! String pool parser for Android binary resources
//!
//! String pools are used in both AXML (binary XML) and ARSC (resource table) formats.
//! They support both UTF-8 and UTF-16 encoded strings.

use std::collections::HashMap;

use byteorder::{ByteOrder, LittleEndian};

use crate::constants::UTF8_FLAG;
use crate::error::{ResourceError, Result};

/// Placeholder for invalid/corrupted strings
pub const INVALID_STRING_PLACEHOLDER: &str = "⟨STRING_DECODE_ERROR⟩";

/// String pool from binary Android resources
#[derive(Debug)]
pub struct StringPool {
    /// Number of strings in the pool
    string_count: u32,
    /// Offset to actual string data from start of offsets array
    strings_start: u32,
    /// Raw buffer containing offsets and string data
    buffer: Vec<u8>,
    /// Whether strings are UTF-8 encoded (vs UTF-16)
    is_utf8: bool,
    /// Cache of decoded strings (includes overrides from deobfuscation)
    cache: HashMap<u32, String>,
}

#[allow(dead_code)]
impl StringPool {
    /// Create an empty string pool
    pub fn empty() -> Self {
        Self {
            string_count: 0,
            strings_start: 0,
            buffer: Vec::new(),
            is_utf8: false,
            cache: HashMap::new(),
        }
    }

    /// Create a new string pool from parsed data
    pub fn new(string_count: u32, strings_start: u32, buffer: Vec<u8>, flags: u32) -> Self {
        Self {
            string_count,
            strings_start,
            buffer,
            is_utf8: (flags & UTF8_FLAG) != 0,
            cache: HashMap::new(),
        }
    }

    /// Get the number of strings in the pool
    pub fn len(&self) -> usize {
        self.string_count as usize
    }

    /// Check if the pool is empty
    pub fn is_empty(&self) -> bool {
        self.string_count == 0
    }

    /// Get a string by index, returning None for invalid indices
    pub fn get(&mut self, id: u32) -> Option<String> {
        // Check cache first
        if let Some(cached) = self.cache.get(&id) {
            return Some(cached.clone());
        }

        // Validate index
        if id >= self.string_count {
            return None;
        }

        // Get offset from offsets array
        let offset_pos = (id * 4) as usize;
        if offset_pos + 4 > self.buffer.len() {
            return Some(INVALID_STRING_PLACEHOLDER.to_string());
        }

        let string_offset = LittleEndian::read_u32(&self.buffer[offset_pos..]) as usize;
        let absolute_offset = self.strings_start as usize + string_offset;

        // Extract string
        let result = if self.is_utf8 {
            self.extract_string8(absolute_offset)
        } else {
            self.extract_string16(absolute_offset)
        };

        // Cache the result
        self.cache.insert(id, result.clone());
        Some(result)
    }

    /// Override a string value (for deobfuscation)
    pub fn put(&mut self, id: u32, content: String) {
        self.cache.insert(id, content);
    }

    /// Extract a UTF-8 encoded string
    fn extract_string8(&self, offset: usize) -> String {
        if offset >= self.buffer.len() {
            return INVALID_STRING_PLACEHOLDER.to_string();
        }

        // Skip the character count (variable length encoded)
        let start = offset + self.skip_str_len8(offset);
        if start >= self.buffer.len() {
            return INVALID_STRING_PLACEHOLDER.to_string();
        }

        // Read byte length
        let mut len = self.buffer[start] as usize;
        let mut data_start = start + 1;

        if len == 0 {
            return String::new();
        }

        // Check for 2-byte length encoding
        if (len & 0x80) != 0 {
            if data_start >= self.buffer.len() {
                return INVALID_STRING_PLACEHOLDER.to_string();
            }
            len = ((len & 0x7F) << 8) | (self.buffer[data_start] as usize);
            data_start += 1;
        }

        // Extract bytes
        let end = data_start + len;
        if end > self.buffer.len() {
            return INVALID_STRING_PLACEHOLDER.to_string();
        }

        String::from_utf8_lossy(&self.buffer[data_start..end]).to_string()
    }

    /// Extract a UTF-16 encoded string
    fn extract_string16(&self, offset: usize) -> String {
        if offset + 2 >= self.buffer.len() {
            return INVALID_STRING_PLACEHOLDER.to_string();
        }

        // Skip length prefix
        let start = offset + self.skip_str_len16(offset);
        let mut end = start;

        // Read until null terminator (0x0000)
        while end + 1 < self.buffer.len() {
            if self.buffer[end] == 0 && self.buffer[end + 1] == 0 {
                break;
            }
            end += 2;
        }

        // Decode UTF-16LE
        let bytes = &self.buffer[start..end];
        let mut chars: Vec<u16> = Vec::with_capacity(bytes.len() / 2);
        for chunk in bytes.chunks_exact(2) {
            chars.push(LittleEndian::read_u16(chunk));
        }

        String::from_utf16_lossy(&chars)
    }

    /// Skip variable-length string length prefix for UTF-8
    fn skip_str_len8(&self, offset: usize) -> usize {
        if offset >= self.buffer.len() {
            return 0;
        }
        if (self.buffer[offset] & 0x80) == 0 {
            1
        } else {
            2
        }
    }

    /// Skip variable-length string length prefix for UTF-16
    fn skip_str_len16(&self, offset: usize) -> usize {
        if offset + 1 >= self.buffer.len() {
            return 0;
        }
        if (self.buffer[offset + 1] & 0x80) == 0 {
            2
        } else {
            4
        }
    }
}

/// Parse a string pool from a byte slice
///
/// # Arguments
/// * `data` - Byte slice starting after the chunk type (0x0001)
/// * `header_size` - Size of the header (typically 0x1c)
/// * `chunk_size` - Total size of the string pool chunk
///
/// # Returns
/// * Parsed StringPool and number of bytes consumed
#[allow(dead_code)]
pub fn parse_string_pool(data: &[u8], header_size: u16, chunk_size: u32) -> Result<(StringPool, usize)> {
    if data.len() < 20 {
        return Err(ResourceError::InvalidStringPool(
            "Buffer too small for string pool header".to_string(),
        ));
    }

    let string_count = LittleEndian::read_u32(&data[0..4]);
    let _style_count = LittleEndian::read_u32(&data[4..8]);
    let flags = LittleEndian::read_u32(&data[8..12]);
    let strings_start = LittleEndian::read_u32(&data[12..16]);
    let _styles_start = LittleEndian::read_u32(&data[16..20]);

    // Calculate actual start of string data relative to our buffer
    // Header is already consumed, so strings_start is relative to chunk start
    // We need to adjust for the part of the header we've already read
    let header_consumed = header_size as u32 - 4; // -4 because chunk type was already read
    let adjusted_strings_start = strings_start.saturating_sub(header_consumed);

    // Read the rest of the chunk (offsets array + string data)
    let remaining_size = chunk_size as usize - header_size as usize;
    if data.len() < 20 + remaining_size - 20 {
        // Adjust for header fields already read
        return Err(ResourceError::InvalidStringPool(
            "Buffer too small for string pool data".to_string(),
        ));
    }

    let buffer = data[20..(chunk_size as usize - 8)].to_vec(); // -8 for type+header_size+chunk_size

    Ok((
        StringPool::new(string_count, adjusted_strings_start - 20, buffer, flags),
        chunk_size as usize - 4, // -4 because type was already read
    ))
}

#[cfg(test)]
mod tests {
    use super::*;

    #[test]
    fn test_empty_pool() {
        let pool = StringPool::empty();
        assert!(pool.is_empty());
        assert_eq!(pool.len(), 0);
    }

    #[test]
    fn test_string_override() {
        let mut pool = StringPool::empty();
        pool.put(0, "test".to_string());
        assert_eq!(pool.cache.get(&0), Some(&"test".to_string()));
    }
}
