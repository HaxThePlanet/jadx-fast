//! Android Resource Table (ARSC) parser
//!
//! Parses resources.arsc files which contain compiled Android resources.
//! Provides resource ID to name mappings for use in XML decoding.

use std::collections::HashMap;
use std::io::{Cursor, Read, Seek, SeekFrom};

use byteorder::{LittleEndian, ReadBytesExt};

use crate::constants::*;
use crate::error::{ResourceError, Result};
use crate::string_pool::StringPool;

/// Raw value from resource table (type + data)
#[derive(Debug, Clone, Copy)]
pub struct RawValue {
    /// Value type (TYPE_STRING, TYPE_INT_DEC, TYPE_INT_COLOR_ARGB8, etc.)
    pub data_type: u8,
    /// Raw value data
    pub data: u32,
}

impl RawValue {
    /// Create a new raw value
    pub fn new(data_type: u8, data: u32) -> Self {
        Self { data_type, data }
    }
}

/// Resource entry information
#[derive(Debug, Clone)]
pub struct ResourceEntry {
    /// Resource ID (0xPPTTEEEE format)
    pub id: u32,
    /// Package name
    pub package_name: String,
    /// Type name (e.g., "drawable", "string", "layout")
    pub type_name: String,
    /// Entry name (e.g., "app_name", "ic_launcher")
    pub key_name: String,
    /// Simple value (for non-complex resources)
    pub value: Option<RawValue>,
    /// Configuration qualifier (e.g., "default", "hdpi", "v21")
    pub config: String,
}

impl ResourceEntry {
    /// Get the full resource name (type/name)
    pub fn full_name(&self) -> String {
        format!("{}/{}", self.type_name, self.key_name)
    }
}

/// Parsed resource table
pub struct ArscParser {
    /// Global string pool
    strings: StringPool,
    /// Parsed resource entries
    entries: Vec<ResourceEntry>,
    /// Resource ID to full name mapping
    res_names: HashMap<u32, String>,
}

impl ArscParser {
    /// Create a new ARSC parser
    pub fn new() -> Self {
        Self {
            strings: StringPool::empty(),
            entries: Vec::new(),
            res_names: HashMap::new(),
        }
    }

    /// Parse an ARSC file from bytes
    pub fn parse(&mut self, data: &[u8]) -> Result<()> {
        self.entries.clear();
        self.res_names.clear();

        let mut cursor = Cursor::new(data);

        // Read header
        let chunk_type = cursor.read_u16::<LittleEndian>()?;
        if chunk_type != RES_TABLE_TYPE {
            return Err(ResourceError::InvalidArsc(format!(
                "Expected RES_TABLE_TYPE (0x0002), got 0x{:04x}",
                chunk_type
            )));
        }

        let header_size = cursor.read_u16::<LittleEndian>()?;
        let chunk_size = cursor.read_u32::<LittleEndian>()?;
        let package_count = cursor.read_u32::<LittleEndian>()?;

        // Skip to end of header if needed
        if header_size > 12 {
            cursor.seek(SeekFrom::Current((header_size as i64) - 12))?;
        }

        // Parse global string pool
        let pool_type = cursor.read_u16::<LittleEndian>()?;
        if pool_type == RES_STRING_POOL_TYPE {
            self.parse_string_pool(&mut cursor)?;
        } else {
            return Err(ResourceError::InvalidArsc(
                "Expected string pool after header".to_string(),
            ));
        }

        // Parse packages
        for _ in 0..package_count {
            if cursor.position() >= chunk_size as u64 {
                break;
            }
            self.parse_package(&mut cursor)?;
        }

        Ok(())
    }

    /// Get the resource names map
    pub fn get_res_names(&self) -> HashMap<u32, String> {
        self.res_names.clone()
    }

    /// Get all parsed resource entries
    pub fn get_entries(&self) -> &[ResourceEntry] {
        &self.entries
    }

    /// Parse string pool chunk
    fn parse_string_pool(&mut self, cursor: &mut Cursor<&[u8]>) -> Result<()> {
        let start = cursor.position() - 2;
        let _header_size = cursor.read_u16::<LittleEndian>()?;
        let chunk_size = cursor.read_u32::<LittleEndian>()?;

        let string_count = cursor.read_u32::<LittleEndian>()?;
        let _style_count = cursor.read_u32::<LittleEndian>()?;
        let flags = cursor.read_u32::<LittleEndian>()?;
        let strings_start = cursor.read_u32::<LittleEndian>()?;
        let _styles_start = cursor.read_u32::<LittleEndian>()?;

        let header_consumed = cursor.position() - start;
        let adjusted_strings_start = strings_start as u64 - header_consumed;

        let remaining = chunk_size as u64 - (cursor.position() - start);
        let mut buffer = vec![0u8; remaining as usize];
        cursor.read_exact(&mut buffer)?;

        self.strings = StringPool::new(string_count, adjusted_strings_start as u32, buffer, flags);

        Ok(())
    }

    /// Parse a package chunk
    fn parse_package(&mut self, cursor: &mut Cursor<&[u8]>) -> Result<()> {
        let chunk_type = cursor.read_u16::<LittleEndian>()?;
        if chunk_type != RES_TABLE_PACKAGE_TYPE {
            // Skip unknown chunk
            let _header_size = cursor.read_u16::<LittleEndian>()?;
            let chunk_size = cursor.read_u32::<LittleEndian>()?;
            cursor.seek(SeekFrom::Current((chunk_size - 8) as i64))?;
            return Ok(());
        }

        let header_size = cursor.read_u16::<LittleEndian>()?;
        let chunk_size = cursor.read_u32::<LittleEndian>()?;
        let package_start = cursor.position() - 8;
        let package_end = package_start + chunk_size as u64;

        let package_id = cursor.read_u32::<LittleEndian>()?;

        // Read package name (256 bytes, UTF-16)
        let mut name_bytes = [0u8; 256];
        cursor.read_exact(&mut name_bytes)?;
        let package_name = decode_utf16_name(&name_bytes);

        let type_strings_offset = cursor.read_u32::<LittleEndian>()?;
        let _last_public_type = cursor.read_u32::<LittleEndian>()?;
        let key_strings_offset = cursor.read_u32::<LittleEndian>()?;
        let _last_public_key = cursor.read_u32::<LittleEndian>()?;

        // Skip to end of header
        cursor.seek(SeekFrom::Start(package_start + header_size as u64))?;

        // Parse type string pool
        let mut type_strings = StringPool::empty();
        if type_strings_offset != 0 {
            cursor.seek(SeekFrom::Start(package_start + type_strings_offset as u64))?;
            let pool_type = cursor.read_u16::<LittleEndian>()?;
            if pool_type == RES_STRING_POOL_TYPE {
                type_strings = self.parse_string_pool_inline(cursor)?;
            }
        }

        // Parse key string pool
        let mut key_strings = StringPool::empty();
        if key_strings_offset != 0 {
            cursor.seek(SeekFrom::Start(package_start + key_strings_offset as u64))?;
            let pool_type = cursor.read_u16::<LittleEndian>()?;
            if pool_type == RES_STRING_POOL_TYPE {
                key_strings = self.parse_string_pool_inline(cursor)?;
            }
        }

        // Parse type specs and types
        while cursor.position() < package_end {
            let pos = cursor.position();
            if pos + 8 > package_end {
                break;
            }

            let chunk_type = cursor.read_u16::<LittleEndian>()?;
            let chunk_header_size = cursor.read_u16::<LittleEndian>()?;
            let chunk_size = cursor.read_u32::<LittleEndian>()?;

            if chunk_size == 0 || pos + chunk_size as u64 > package_end {
                break;
            }

            match chunk_type {
                RES_TABLE_TYPE_SPEC_TYPE => {
                    // Type spec - skip for now, we just need the entries
                    cursor.seek(SeekFrom::Start(pos + chunk_size as u64))?;
                }
                RES_TABLE_TYPE_TYPE => {
                    // Actual resource type with entries
                    self.parse_type_chunk(
                        cursor,
                        pos,
                        chunk_header_size,
                        chunk_size,
                        package_id,
                        &package_name,
                        &mut type_strings,
                        &mut key_strings,
                    )?;
                }
                RES_TABLE_TYPE_LIBRARY | RES_TABLE_TYPE_OVERLAY |
                RES_TABLE_TYPE_OVERLAY_POLICY | RES_TABLE_TYPE_STAGED_ALIAS => {
                    // Skip these chunks
                    cursor.seek(SeekFrom::Start(pos + chunk_size as u64))?;
                }
                _ => {
                    // Unknown chunk, skip
                    cursor.seek(SeekFrom::Start(pos + chunk_size as u64))?;
                }
            }
        }

        Ok(())
    }

    /// Parse a string pool inline and return it
    fn parse_string_pool_inline(&self, cursor: &mut Cursor<&[u8]>) -> Result<StringPool> {
        let start = cursor.position() - 2;
        let _header_size = cursor.read_u16::<LittleEndian>()?;
        let chunk_size = cursor.read_u32::<LittleEndian>()?;

        let string_count = cursor.read_u32::<LittleEndian>()?;
        let _style_count = cursor.read_u32::<LittleEndian>()?;
        let flags = cursor.read_u32::<LittleEndian>()?;
        let strings_start = cursor.read_u32::<LittleEndian>()?;
        let _styles_start = cursor.read_u32::<LittleEndian>()?;

        let header_consumed = cursor.position() - start;
        let adjusted_strings_start = strings_start as u64 - header_consumed;

        let remaining = chunk_size as u64 - (cursor.position() - start);
        let mut buffer = vec![0u8; remaining as usize];
        cursor.read_exact(&mut buffer)?;

        Ok(StringPool::new(
            string_count,
            adjusted_strings_start as u32,
            buffer,
            flags,
        ))
    }

    /// Parse a type chunk with resource entries
    #[allow(clippy::too_many_arguments)]
    fn parse_type_chunk(
        &mut self,
        cursor: &mut Cursor<&[u8]>,
        chunk_start: u64,
        header_size: u16,
        chunk_size: u32,
        package_id: u32,
        package_name: &str,
        type_strings: &mut StringPool,
        key_strings: &mut StringPool,
    ) -> Result<()> {
        // Read type header
        let type_id = cursor.read_u8()?;
        let flags = cursor.read_u8()?;
        let _reserved = cursor.read_u16::<LittleEndian>()?;
        let entry_count = cursor.read_u32::<LittleEndian>()?;
        let entries_start = cursor.read_u32::<LittleEndian>()?;

        // Skip config
        cursor.seek(SeekFrom::Start(chunk_start + header_size as u64))?;

        // Get type name
        let type_name = type_strings
            .get((type_id - 1) as u32)
            .unwrap_or_else(|| format!("type{}", type_id));

        // Read entry offsets or sparse entries
        let is_sparse = (flags & FLAG_SPARSE) != 0;
        let is_offset16 = (flags & FLAG_OFFSET16) != 0;

        let data_start = chunk_start + entries_start as u64;

        // For now, use "default" as config - TODO: parse actual config
        let config = "default";

        if is_sparse {
            // Sparse entries
            let count = entry_count;
            for _ in 0..count {
                let idx = cursor.read_u16::<LittleEndian>()? as u32;
                let offset = if is_offset16 {
                    (cursor.read_u16::<LittleEndian>()? as u32) * 4
                } else {
                    cursor.read_u32::<LittleEndian>()?
                };

                if offset != NO_ENTRY {
                    self.parse_entry(
                        cursor,
                        data_start + offset as u64,
                        package_id,
                        type_id as u32,
                        idx,
                        package_name,
                        &type_name,
                        key_strings,
                        config,
                    )?;
                }
            }
        } else {
            // Dense entries
            let mut offsets = Vec::with_capacity(entry_count as usize);
            for _ in 0..entry_count {
                let offset = if is_offset16 {
                    let o = cursor.read_u16::<LittleEndian>()?;
                    if o == 0xFFFF {
                        NO_ENTRY
                    } else {
                        (o as u32) * 4
                    }
                } else {
                    cursor.read_u32::<LittleEndian>()?
                };
                offsets.push(offset);
            }

            for (idx, &offset) in offsets.iter().enumerate() {
                if offset != NO_ENTRY {
                    self.parse_entry(
                        cursor,
                        data_start + offset as u64,
                        package_id,
                        type_id as u32,
                        idx as u32,
                        package_name,
                        &type_name,
                        key_strings,
                        config,
                    )?;
                }
            }
        }

        // Seek to end of chunk
        cursor.seek(SeekFrom::Start(chunk_start + chunk_size as u64))?;

        Ok(())
    }

    /// Parse a single resource entry
    #[allow(clippy::too_many_arguments)]
    fn parse_entry(
        &mut self,
        cursor: &mut Cursor<&[u8]>,
        entry_pos: u64,
        package_id: u32,
        type_id: u32,
        entry_idx: u32,
        package_name: &str,
        type_name: &str,
        key_strings: &mut StringPool,
        config: &str,
    ) -> Result<()> {
        let saved_pos = cursor.position();
        cursor.seek(SeekFrom::Start(entry_pos))?;

        // Read entry header
        let size_or_flags = cursor.read_u16::<LittleEndian>()?;
        let flags = cursor.read_u16::<LittleEndian>()?;

        // Check for compact entry format
        let (key_idx, value) = if (flags & FLAG_COMPACT) != 0 {
            // Compact format: size_or_flags is actually the key index
            // Value follows directly: type (1 byte) + data (3 bytes packed)
            let data_type = cursor.read_u8()?;
            let data = cursor.read_u24::<LittleEndian>()?;
            (size_or_flags as u32, Some(RawValue::new(data_type, data)))
        } else {
            // Normal format
            let key = cursor.read_u32::<LittleEndian>()?;

            // Check if complex entry
            let is_complex = (flags & FLAG_COMPLEX) != 0;

            let value = if !is_complex {
                // Simple value: size (2) + res0 (1) + dataType (1) + data (4)
                let _value_size = cursor.read_u16::<LittleEndian>()?;
                let _res0 = cursor.read_u8()?;
                let data_type = cursor.read_u8()?;
                let data = cursor.read_u32::<LittleEndian>()?;
                Some(RawValue::new(data_type, data))
            } else {
                // Complex entry (bag/style) - skip for now
                None
            };

            (key, value)
        };

        // Get key name
        let key_name = key_strings
            .get(key_idx)
            .unwrap_or_else(|| format!("entry{}", entry_idx));

        // Build resource ID: 0xPPTTEEEE
        let res_id = (package_id << 24) | (type_id << 16) | entry_idx;

        // Add entry
        let entry = ResourceEntry {
            id: res_id,
            package_name: package_name.to_string(),
            type_name: type_name.to_string(),
            key_name: key_name.clone(),
            value,
            config: config.to_string(),
        };

        self.res_names.insert(res_id, entry.full_name());
        self.entries.push(entry);

        cursor.seek(SeekFrom::Start(saved_pos))?;
        Ok(())
    }

    /// Decode a value to its string representation
    pub fn decode_value(&mut self, value: &RawValue) -> Option<String> {
        match value.data_type {
            TYPE_NULL => None,
            TYPE_STRING => self.strings.get(value.data),
            TYPE_INT_DEC => Some(value.data.to_string()),
            TYPE_INT_HEX => Some(format!("0x{:x}", value.data)),
            TYPE_INT_BOOLEAN => Some(if value.data == 0 { "false" } else { "true" }.to_string()),
            TYPE_FLOAT => Some(format!("{}", f32::from_bits(value.data))),
            TYPE_INT_COLOR_ARGB8 => Some(format!("#{:08x}", value.data)),
            TYPE_INT_COLOR_RGB8 => Some(format!("#{:06x}", value.data & 0xFFFFFF)),
            TYPE_INT_COLOR_ARGB4 => Some(format!("#{:04x}", value.data & 0xFFFF)),
            TYPE_INT_COLOR_RGB4 => Some(format!("#{:03x}", value.data & 0xFFF)),
            TYPE_REFERENCE => {
                if value.data == 0 {
                    Some("@null".to_string())
                } else if let Some(name) = self.res_names.get(&value.data) {
                    Some(format!("@{}", name))
                } else {
                    Some(format!("@0x{:08x}", value.data))
                }
            }
            TYPE_ATTRIBUTE => {
                if let Some(name) = self.res_names.get(&value.data) {
                    Some(format!("?{}", name))
                } else {
                    Some(format!("?0x{:08x}", value.data))
                }
            }
            TYPE_DIMENSION => Some(decode_dimension(value.data)),
            TYPE_FRACTION => Some(decode_fraction(value.data)),
            _ => Some(format!("0x{:08x}", value.data)),
        }
    }

    /// Check if a value type is a color
    fn is_color_type(data_type: u8) -> bool {
        matches!(
            data_type,
            TYPE_INT_COLOR_ARGB8 | TYPE_INT_COLOR_RGB8 | TYPE_INT_COLOR_ARGB4 | TYPE_INT_COLOR_RGB4
        )
    }

    /// Generate strings.xml content
    pub fn generate_strings_xml(&mut self) -> String {
        let mut xml = String::from("<?xml version=\"1.0\" encoding=\"utf-8\"?>\n<resources>\n");

        // Collect string entries (default config only)
        let string_entries: Vec<_> = self
            .entries
            .iter()
            .filter(|e| e.type_name == "string" && e.config == "default")
            .cloned()
            .collect();

        for entry in string_entries {
            if let Some(ref value) = entry.value {
                if value.data_type == TYPE_STRING {
                    if let Some(decoded) = self.strings.get(value.data) {
                        let escaped = escape_xml_text(&decoded);
                        xml.push_str(&format!(
                            "    <string name=\"{}\">{}</string>\n",
                            entry.key_name, escaped
                        ));
                    }
                }
            }
        }

        xml.push_str("</resources>\n");
        xml
    }

    /// Generate colors.xml content
    pub fn generate_colors_xml(&mut self) -> String {
        let mut xml = String::from("<?xml version=\"1.0\" encoding=\"utf-8\"?>\n<resources>\n");

        // Collect color entries (default config only)
        let color_entries: Vec<_> = self
            .entries
            .iter()
            .filter(|e| e.type_name == "color" && e.config == "default")
            .cloned()
            .collect();

        for entry in color_entries {
            if let Some(ref value) = entry.value {
                if Self::is_color_type(value.data_type) {
                    if let Some(decoded) = self.decode_value(value) {
                        xml.push_str(&format!(
                            "    <color name=\"{}\">{}</color>\n",
                            entry.key_name, decoded
                        ));
                    }
                }
            }
        }

        xml.push_str("</resources>\n");
        xml
    }

    /// Generate drawables.xml content (for drawable references)
    pub fn generate_drawables_xml(&mut self) -> String {
        let mut xml = String::from("<?xml version=\"1.0\" encoding=\"utf-8\"?>\n<resources>\n");

        // Collect drawable entries that are references (default config only)
        let drawable_entries: Vec<_> = self
            .entries
            .iter()
            .filter(|e| {
                e.type_name == "drawable"
                    && e.config == "default"
                    && e.value
                        .as_ref()
                        .map(|v| v.data_type == TYPE_REFERENCE)
                        .unwrap_or(false)
            })
            .cloned()
            .collect();

        for entry in drawable_entries {
            if let Some(ref value) = entry.value {
                if let Some(decoded) = self.decode_value(value) {
                    xml.push_str(&format!(
                        "    <item type=\"drawable\" name=\"{}\">{}</item>\n",
                        entry.key_name, decoded
                    ));
                }
            }
        }

        xml.push_str("</resources>\n");
        xml
    }

    /// Generate public.xml content
    pub fn generate_public_xml(&self) -> String {
        let mut xml = String::from("<?xml version=\"1.0\" encoding=\"utf-8\"?>\n<resources>\n");

        // Sort entries by ID for consistent output
        let mut sorted_entries: Vec<_> = self
            .entries
            .iter()
            .filter(|e| e.config == "default")
            .collect();
        sorted_entries.sort_by_key(|e| e.id);

        // Track seen IDs to avoid duplicates
        let mut seen_ids = std::collections::HashSet::new();

        for entry in sorted_entries {
            if seen_ids.insert(entry.id) {
                xml.push_str(&format!(
                    "    <public type=\"{}\" name=\"{}\" id=\"0x{:08x}\" />\n",
                    entry.type_name, entry.key_name, entry.id
                ));
            }
        }

        xml.push_str("</resources>\n");
        xml
    }

    /// Generate all values XML files as a map of filename -> content
    pub fn generate_values_xml(&mut self) -> HashMap<String, String> {
        let mut files = HashMap::new();

        // Generate strings.xml
        let strings_xml = self.generate_strings_xml();
        if strings_xml.contains("<string") {
            files.insert("strings.xml".to_string(), strings_xml);
        }

        // Generate colors.xml
        let colors_xml = self.generate_colors_xml();
        if colors_xml.contains("<color") {
            files.insert("colors.xml".to_string(), colors_xml);
        }

        // Generate drawables.xml (even if empty, for consistency with JADX)
        let drawables_xml = self.generate_drawables_xml();
        files.insert("drawables.xml".to_string(), drawables_xml);

        // Generate public.xml
        let public_xml = self.generate_public_xml();
        files.insert("public.xml".to_string(), public_xml);

        files
    }
}

impl Default for ArscParser {
    fn default() -> Self {
        Self::new()
    }
}

/// Decode a UTF-16 encoded name from a fixed-size buffer
fn decode_utf16_name(bytes: &[u8]) -> String {
    let mut chars: Vec<u16> = Vec::new();
    for chunk in bytes.chunks_exact(2) {
        let c = u16::from_le_bytes([chunk[0], chunk[1]]);
        if c == 0 {
            break;
        }
        chars.push(c);
    }
    String::from_utf16_lossy(&chars)
}

/// Escape special XML characters in text content
fn escape_xml_text(s: &str) -> String {
    let mut result = String::with_capacity(s.len());
    for c in s.chars() {
        match c {
            '&' => result.push_str("&amp;"),
            '<' => result.push_str("&lt;"),
            '>' => result.push_str("&gt;"),
            '\'' => result.push_str("&apos;"),
            '"' => result.push_str("&quot;"),
            _ => result.push(c),
        }
    }
    result
}

#[cfg(test)]
mod tests {
    use super::*;

    #[test]
    fn test_decode_utf16_name() {
        // "com" in UTF-16LE
        let bytes = [b'c', 0, b'o', 0, b'm', 0, 0, 0];
        assert_eq!(decode_utf16_name(&bytes), "com");
    }

    #[test]
    fn test_resource_entry_full_name() {
        let entry = ResourceEntry {
            id: 0x7f010001,
            package_name: "com.example".to_string(),
            type_name: "string".to_string(),
            key_name: "app_name".to_string(),
            value: None,
            config: "default".to_string(),
        };
        assert_eq!(entry.full_name(), "string/app_name");
    }

    #[test]
    fn test_raw_value_decode() {
        let mut parser = ArscParser::new();

        // Test integer
        let int_val = RawValue::new(TYPE_INT_DEC, 42);
        assert_eq!(parser.decode_value(&int_val), Some("42".to_string()));

        // Test boolean
        let bool_val = RawValue::new(TYPE_INT_BOOLEAN, 1);
        assert_eq!(parser.decode_value(&bool_val), Some("true".to_string()));

        // Test color
        let color_val = RawValue::new(TYPE_INT_COLOR_ARGB8, 0xff000000);
        assert_eq!(parser.decode_value(&color_val), Some("#ff000000".to_string()));
    }
}
