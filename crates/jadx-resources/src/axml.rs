//! Android Binary XML (AXML) parser
//!
//! Parses compiled Android XML files like AndroidManifest.xml and layout files.
//! Produces XML output compatible with Java JADX.

use std::collections::{HashMap, HashSet};
use std::io::{Cursor, Read, Seek, SeekFrom};

use byteorder::{LittleEndian, ReadBytesExt};

use crate::constants::*;
use crate::error::{ResourceError, Result};
use crate::string_pool::StringPool;

/// Android Resource ID map for common attributes
mod android_res {
    use std::collections::HashMap;
    use std::sync::LazyLock;

    /// Map of Android framework resource IDs to attribute names
    pub static ANDROID_RES_MAP: LazyLock<HashMap<u32, &'static str>> = LazyLock::new(|| {
        let mut m = HashMap::new();
        // Common Android attributes (subset - can be expanded)
        m.insert(0x0101000e, "attr/textSize");
        m.insert(0x0101000f, "attr/textColor");
        m.insert(0x01010001, "attr/label");
        m.insert(0x01010002, "attr/icon");
        m.insert(0x01010003, "attr/name");
        m.insert(0x01010010, "attr/enabled");
        m.insert(0x0101020c, "attr/minSdkVersion");
        m.insert(0x01010270, "attr/targetSdkVersion");
        m.insert(0x0101028e, "attr/maxSdkVersion");
        m.insert(0x0101021b, "attr/versionCode");
        m.insert(0x0101021c, "attr/versionName");
        m.insert(0x01010000, "attr/theme");
        m.insert(0x01010011, "attr/id");
        m.insert(0x01010024, "attr/layout_width");
        m.insert(0x01010025, "attr/layout_height");
        m.insert(0x01010026, "attr/layout_weight");
        m.insert(0x01010027, "attr/layout_gravity");
        m.insert(0x01010028, "attr/gravity");
        m.insert(0x0101029a, "attr/exported");
        m.insert(0x01010017, "attr/permission");
        m.insert(0x0101000a, "attr/configChanges");
        m.insert(0x0101001f, "attr/screenOrientation");
        m.insert(0x0101001e, "attr/launchMode");
        m.insert(0x01010018, "attr/readPermission");
        m.insert(0x01010019, "attr/writePermission");
        m.insert(0x01010275, "attr/process");
        m.insert(0x0101000b, "attr/allowBackup");
        m.insert(0x01010020, "attr/taskAffinity");
        m.insert(0x010102d3, "attr/hardwareAccelerated");
        m.insert(0x010103f2, "attr/supportsRtl");
        m.insert(0x01010006, "attr/authorities");
        m.insert(0x01010007, "attr/syncable");
        m.insert(0x01010008, "attr/multiprocess");
        m.insert(0x01010009, "attr/grantUriPermissions");
        m.insert(0x0101000c, "attr/initOrder");
        m.insert(0x0101000d, "attr/value");
        m.insert(0x01010012, "attr/text");
        m.insert(0x01010013, "attr/background");
        m.insert(0x01010014, "attr/foreground");
        m.insert(0x01010015, "attr/src");
        m.insert(0x01010016, "attr/data");
        m.insert(0x0101001a, "attr/sharedUserId");
        m.insert(0x0101001b, "attr/debuggable");
        m.insert(0x0101001c, "attr/persistent");
        m.insert(0x0101001d, "attr/windowSoftInputMode");
        m.insert(0x01010021, "attr/clearTaskOnLaunch");
        m.insert(0x01010022, "attr/stateNotNeeded");
        m.insert(0x01010023, "attr/excludeFromRecents");
        m.insert(0x010102ce, "attr/largeHeap");
        m.insert(0x0101035e, "attr/usesCleartextTraffic");
        m.insert(0x010104d8, "attr/networkSecurityConfig");
        m
    });

    /// Get resource name by ID
    pub fn get_res_name(id: u32) -> Option<&'static str> {
        ANDROID_RES_MAP.get(&id).copied()
    }
}

/// Binary XML parser
pub struct AxmlParser {
    /// String pool
    strings: StringPool,
    /// Resource ID map from the XML
    resource_ids: Vec<u32>,
    /// Namespace URI -> prefix mapping
    ns_map: HashMap<String, String>,
    /// Generated namespace prefixes
    ns_generated: HashSet<String>,
    /// Defined namespaces (already output)
    defined_namespaces: HashSet<String>,
    /// Current tag name
    current_tag: String,
    /// Whether last output was an end tag
    is_last_end: bool,
    /// Whether current element can be on one line
    is_one_line: bool,
    /// Namespace depth for tracking
    namespace_depth: u32,
    /// App package name from manifest
    app_package_name: Option<String>,
    /// Resource names map (from ARSC if available)
    res_names: HashMap<u32, String>,
    /// Output buffer
    output: String,
    /// Current indentation level
    indent: usize,
    /// Whether this is the first element
    first_element: bool,
    /// Whether to put attributes on new lines
    attr_new_line: bool,
}

impl AxmlParser {
    /// Create a new AXML parser
    pub fn new() -> Self {
        Self {
            strings: StringPool::empty(),
            resource_ids: Vec::new(),
            ns_map: HashMap::new(),
            ns_generated: HashSet::new(),
            defined_namespaces: HashSet::new(),
            current_tag: "ERROR".to_string(),
            is_last_end: true,
            is_one_line: true,
            namespace_depth: 0,
            app_package_name: None,
            res_names: HashMap::new(),
            output: String::new(),
            indent: 0,
            first_element: true,
            attr_new_line: true,
        }
    }

    /// Set resource names map (from ARSC parsing)
    pub fn set_res_names(&mut self, res_names: HashMap<u32, String>) {
        self.res_names = res_names;
    }

    /// Parse binary XML from bytes
    pub fn parse(&mut self, data: &[u8]) -> Result<String> {
        self.reset();

        let mut cursor = Cursor::new(data);

        // Check if this is binary XML
        if !self.is_binary_xml(&mut cursor)? {
            // Return as plain text
            return Ok(String::from_utf8_lossy(data).to_string());
        }

        // Write XML header
        self.output.push_str("<?xml version=\"1.0\" encoding=\"utf-8\"?>");

        // Read total size
        let size = cursor.read_u32::<LittleEndian>()?;

        // Decode chunks
        while cursor.position() < size as u64 {
            let chunk_type = cursor.read_u16::<LittleEndian>()?;

            match chunk_type {
                RES_NULL_TYPE => {
                    // Null chunk - do nothing
                }
                RES_STRING_POOL_TYPE => {
                    self.parse_string_pool(&mut cursor)?;
                }
                RES_XML_RESOURCE_MAP_TYPE => {
                    self.parse_resource_map(&mut cursor)?;
                }
                RES_XML_START_NAMESPACE_TYPE => {
                    self.parse_namespace_start(&mut cursor)?;
                }
                RES_XML_END_NAMESPACE_TYPE => {
                    self.parse_namespace_end(&mut cursor)?;
                }
                RES_XML_START_ELEMENT_TYPE => {
                    self.parse_element_start(&mut cursor)?;
                }
                RES_XML_END_ELEMENT_TYPE => {
                    self.parse_element_end(&mut cursor)?;
                }
                RES_XML_CDATA_TYPE => {
                    self.parse_cdata(&mut cursor)?;
                }
                _ => {
                    if self.namespace_depth == 0 {
                        // Skip padding at file end
                        break;
                    }
                    return Err(ResourceError::UnexpectedChunkType(chunk_type));
                }
            }
        }

        // Add trailing newline to match Java JADX output
        if !self.output.ends_with('\n') {
            self.output.push('\n');
        }

        Ok(self.output.clone())
    }

    /// Reset parser state for reuse
    fn reset(&mut self) {
        self.strings = StringPool::empty();
        self.resource_ids.clear();
        self.ns_map.clear();
        self.ns_generated.clear();
        self.defined_namespaces.clear();
        self.current_tag = "ERROR".to_string();
        self.is_last_end = true;
        self.is_one_line = true;
        self.namespace_depth = 0;
        self.app_package_name = None;
        self.output.clear();
        self.indent = 0;
        self.first_element = true;
    }

    /// Check if data is binary XML
    fn is_binary_xml(&self, cursor: &mut Cursor<&[u8]>) -> Result<bool> {
        cursor.seek(SeekFrom::Start(0))?;
        let _version = cursor.read_u16::<LittleEndian>()?;
        let header_size = cursor.read_u16::<LittleEndian>()?;

        // Binary XML has header size 0x0008
        Ok(header_size == 0x0008)
    }

    /// Parse string pool chunk
    fn parse_string_pool(&mut self, cursor: &mut Cursor<&[u8]>) -> Result<()> {
        let start = cursor.position() - 2; // -2 for type already read
        let _header_size = cursor.read_u16::<LittleEndian>()?;
        let chunk_size = cursor.read_u32::<LittleEndian>()?;

        let string_count = cursor.read_u32::<LittleEndian>()?;
        let _style_count = cursor.read_u32::<LittleEndian>()?;
        let flags = cursor.read_u32::<LittleEndian>()?;
        let strings_start = cursor.read_u32::<LittleEndian>()?;
        let _styles_start = cursor.read_u32::<LittleEndian>()?;

        // Calculate adjusted strings start relative to our buffer
        let header_consumed = cursor.position() - start;
        let adjusted_strings_start = strings_start as u64 - header_consumed;

        // Read remaining chunk data (offsets + strings)
        let remaining = chunk_size as u64 - (cursor.position() - start);
        let mut buffer = vec![0u8; remaining as usize];
        cursor.read_exact(&mut buffer)?;

        self.strings = StringPool::new(
            string_count,
            adjusted_strings_start as u32,
            buffer,
            flags,
        );

        Ok(())
    }

    /// Parse resource map chunk
    fn parse_resource_map(&mut self, cursor: &mut Cursor<&[u8]>) -> Result<()> {
        let header_size = cursor.read_u16::<LittleEndian>()?;
        if header_size != 0x08 {
            return Err(ResourceError::InvalidHeaderSize {
                expected: 0x08,
                actual: header_size as u32,
            });
        }

        let chunk_size = cursor.read_u32::<LittleEndian>()?;
        let count = (chunk_size - 8) / 4;

        self.resource_ids.clear();
        for _ in 0..count {
            self.resource_ids.push(cursor.read_u32::<LittleEndian>()?);
        }

        Ok(())
    }

    /// Parse namespace start chunk
    fn parse_namespace_start(&mut self, cursor: &mut Cursor<&[u8]>) -> Result<()> {
        let header_size = cursor.read_u16::<LittleEndian>()?;
        let _chunk_size = cursor.read_u32::<LittleEndian>()?;
        let _line_number = cursor.read_u32::<LittleEndian>()?;
        let _comment = cursor.read_u32::<LittleEndian>()?;
        let prefix_idx = cursor.read_u32::<LittleEndian>()?;
        let uri_idx = cursor.read_u32::<LittleEndian>()?;

        // Skip extra header bytes if any
        if header_size > 0x10 {
            cursor.seek(SeekFrom::Current((header_size - 0x10) as i64))?;
        }

        let uri = self.get_string(uri_idx);
        let prefix = self.get_string(prefix_idx);

        if !uri.is_empty() && !self.ns_map.values().any(|v| v == &prefix) {
            self.ns_map.entry(uri).or_insert(prefix);
        }

        self.namespace_depth += 1;
        Ok(())
    }

    /// Parse namespace end chunk
    fn parse_namespace_end(&mut self, cursor: &mut Cursor<&[u8]>) -> Result<()> {
        let header_size = cursor.read_u16::<LittleEndian>()?;
        let _chunk_size = cursor.read_u32::<LittleEndian>()?;
        let _line_number = cursor.read_u32::<LittleEndian>()?;
        let _comment = cursor.read_u32::<LittleEndian>()?;
        let _prefix_idx = cursor.read_u32::<LittleEndian>()?;
        let _uri_idx = cursor.read_u32::<LittleEndian>()?;

        if header_size > 0x10 {
            cursor.seek(SeekFrom::Current((header_size - 0x10) as i64))?;
        }

        self.namespace_depth -= 1;
        Ok(())
    }

    /// Parse element start chunk
    fn parse_element_start(&mut self, cursor: &mut Cursor<&[u8]>) -> Result<()> {
        if !self.first_element {
            self.indent += 1;
        } else {
            self.first_element = false;
        }

        let elem_header_size = cursor.read_u16::<LittleEndian>()?;
        if elem_header_size != 0x10 {
            return Err(ResourceError::InvalidHeaderSize {
                expected: 0x10,
                actual: elem_header_size as u32,
            });
        }

        let _chunk_size = cursor.read_u32::<LittleEndian>()?;
        let _line_number = cursor.read_u32::<LittleEndian>()?;
        let _comment = cursor.read_u32::<LittleEndian>()?;
        let _namespace_idx = cursor.read_i32::<LittleEndian>()?;
        let name_idx = cursor.read_u32::<LittleEndian>()?;

        // Close previous unclosed tag (means parent has child content)
        if !self.is_last_end && self.current_tag != "ERROR" {
            self.output.push('>');
            self.is_last_end = true;
        }

        self.is_one_line = true;
        self.is_last_end = false;
        self.current_tag = self.get_string(name_idx);

        // Start new line with element
        self.start_line();
        self.output.push('<');
        self.output.push_str(&self.current_tag);

        let _attr_start = cursor.read_u16::<LittleEndian>()?;
        let attr_size = cursor.read_u16::<LittleEndian>()?;
        let attr_count = cursor.read_u16::<LittleEndian>()?;
        let _id_index = cursor.read_u16::<LittleEndian>()?;
        let _class_index = cursor.read_u16::<LittleEndian>()?;
        let _style_index = cursor.read_u16::<LittleEndian>()?;

        // Output namespace declarations on manifest element or if we have new ones
        if self.current_tag == "manifest" || self.defined_namespaces.len() != self.ns_map.len() {
            for (uri, prefix) in &self.ns_map {
                if !self.defined_namespaces.contains(uri) {
                    self.defined_namespaces.insert(uri.clone());
                    self.output.push_str(" xmlns");
                    if !prefix.is_empty() {
                        self.output.push(':');
                        self.output.push_str(prefix);
                    }
                    self.output.push_str("=\"");
                    self.output.push_str(&escape_xml(uri));
                    self.output.push('"');
                }
            }
        }

        // Parse attributes
        let attr_new_line = attr_count != 1 && self.attr_new_line;
        let mut attr_cache: HashSet<String> = HashSet::new();

        for _ in 0..attr_count {
            self.parse_attribute(cursor, attr_size, attr_new_line, &mut attr_cache)?;
        }

        Ok(())
    }

    /// Parse a single attribute
    fn parse_attribute(
        &mut self,
        cursor: &mut Cursor<&[u8]>,
        attr_size: u16,
        new_line: bool,
        attr_cache: &mut HashSet<String>,
    ) -> Result<()> {
        let attr_ns_idx = cursor.read_i32::<LittleEndian>()?;
        let attr_name_idx = cursor.read_u32::<LittleEndian>()?;
        let _attr_raw_value = cursor.read_i32::<LittleEndian>()?;

        // Skip 3 bytes, read type
        cursor.seek(SeekFrom::Current(3))?;
        let attr_type = cursor.read_u8()?;
        let attr_data = cursor.read_i32::<LittleEndian>()?;

        // Skip extra attribute bytes
        if attr_size > 0x14 {
            cursor.seek(SeekFrom::Current((attr_size - 0x14) as i64))?;
        }

        // Get namespace prefix
        let ns_prefix = if attr_ns_idx != -1 {
            self.get_attribute_ns(attr_ns_idx as u32, new_line)
        } else {
            None
        };

        // Get attribute name
        let attr_name = self.get_attribute_name(attr_name_idx);
        let attr_full_name = if let Some(ref prefix) = ns_prefix {
            format!("{}:{}", prefix, attr_name)
        } else {
            attr_name.clone()
        };

        // Skip duplicates
        if attr_cache.contains(&attr_full_name) {
            return Ok(());
        }
        attr_cache.insert(attr_full_name.clone());

        // Output attribute
        if new_line {
            self.start_line();
            self.add_indent();
        } else {
            self.output.push(' ');
        }

        self.output.push_str(&attr_full_name);
        self.output.push_str("=\"");

        // Decode and output value (pass attribute name for enum decoding)
        let value = self.decode_attribute_value(attr_type, attr_data, &attr_name);

        // Memorize package name
        if self.current_tag == "manifest" && attr_full_name == "package" {
            self.app_package_name = Some(value.clone());
        }

        self.output.push_str(&escape_xml(&value));
        self.output.push('"');

        Ok(())
    }

    /// Get namespace prefix for an attribute
    fn get_attribute_ns(&mut self, ns_idx: u32, new_line: bool) -> Option<String> {
        let uri = self.get_string(ns_idx);
        if uri.is_empty() {
            if is_res_internal_id(ns_idx) {
                return None;
            }
            // Default to android namespace
            return Some(self.get_or_generate_ns(ANDROID_NS_URL, new_line));
        }

        if let Some(prefix) = self.ns_map.get(&uri) {
            return Some(prefix.clone());
        }

        Some(self.get_or_generate_ns(&uri, new_line))
    }

    /// Get or generate a namespace prefix
    fn get_or_generate_ns(&mut self, uri: &str, new_line: bool) -> String {
        if let Some(prefix) = self.ns_map.get(uri) {
            return prefix.clone();
        }

        let prefix = if uri == ANDROID_NS_URL {
            ANDROID_NS_PREFIX.to_string()
        } else {
            let mut i = 1;
            loop {
                let name = format!("ns{}", i);
                if !self.ns_generated.contains(&name) && !self.ns_map.values().any(|v| v == &name) {
                    self.ns_generated.insert(name.clone());
                    break name;
                }
                i += 1;
            }
        };

        self.ns_map.insert(uri.to_string(), prefix.clone());

        // Output xmlns declaration
        if new_line {
            self.start_line();
            self.add_indent();
        } else {
            self.output.push(' ');
        }
        self.output.push_str("xmlns:");
        self.output.push_str(&prefix);
        self.output.push_str("=\"");
        self.output.push_str(uri);
        self.output.push_str("\" ");

        prefix
    }

    /// Get attribute name, preferring string pool then Android resource map
    fn get_attribute_name(&mut self, idx: u32) -> String {
        // Try string pool first - usually has correct attribute names
        let s = self.get_string(idx);
        if !s.is_empty() {
            return s;
        }

        // Fall back to Android resource ID map if string pool is empty
        if (idx as usize) < self.resource_ids.len() {
            let res_id = self.resource_ids[idx as usize];
            if let Some(name) = android_res::get_res_name(res_id) {
                // Extract name after the slash
                if let Some(pos) = name.find('/') {
                    return name[pos + 1..].to_string();
                }
                return name.to_string();
            }
        }

        format!("NOT_FOUND_0x{:x}", idx)
    }

    /// Decode an attribute value based on type and attribute name
    fn decode_attribute_value(&mut self, attr_type: u8, data: i32, attr_name: &str) -> String {
        // First try to decode as an enum/flag value based on attribute name
        if let Some(enum_val) = decode_enum_value(attr_name, data) {
            return enum_val;
        }

        match attr_type {
            TYPE_NULL => "".to_string(),
            TYPE_STRING => self.get_string(data as u32),
            TYPE_INT_DEC => data.to_string(),
            TYPE_INT_HEX => format!("0x{:x}", data),
            TYPE_INT_BOOLEAN => if data == 0 { "false" } else { "true" }.to_string(),
            TYPE_FLOAT => {
                let f = f32::from_bits(data as u32);
                float_to_string(f as f64)
            }
            TYPE_INT_COLOR_ARGB8 => format!("#{:08x}", data),
            TYPE_INT_COLOR_RGB8 => format!("#{:06x}", data & 0xFFFFFF),
            TYPE_INT_COLOR_ARGB4 => format!("#{:04x}", data & 0xFFFF),
            TYPE_INT_COLOR_RGB4 => format!("#{:03x}", data & 0xFFF),
            TYPE_REFERENCE | TYPE_DYNAMIC_REFERENCE => {
                self.decode_reference(data as u32)
            }
            TYPE_ATTRIBUTE => {
                self.decode_attribute_ref(data as u32)
            }
            TYPE_DIMENSION => decode_dimension(data as u32),
            TYPE_FRACTION => decode_fraction(data as u32),
            _ => {
                // Unknown type - output hex
                format!("0x{:x}", data)
            }
        }
    }

    /// Decode a resource reference
    fn decode_reference(&self, data: u32) -> String {
        if let Some(name) = self.res_names.get(&data) {
            let prefix = if name.starts_with("id/") { "@+" } else { "@" };
            return format!("{}{}", prefix, name);
        }

        if let Some(name) = android_res::get_res_name(data) {
            return format!("@android:{}", name);
        }

        if data == 0 {
            "@null".to_string()
        } else {
            format!("0x{:x}", data)
        }
    }

    /// Decode an attribute reference
    fn decode_attribute_ref(&self, data: u32) -> String {
        if let Some(name) = self.res_names.get(&data) {
            return format!("?{}", name);
        }

        if let Some(name) = android_res::get_res_name(data) {
            return format!("?android:{}", name);
        }

        format!("?0x{:x}", data)
    }

    /// Parse element end chunk
    fn parse_element_end(&mut self, cursor: &mut Cursor<&[u8]>) -> Result<()> {
        let header_size = cursor.read_u16::<LittleEndian>()?;
        if header_size != 0x10 {
            return Err(ResourceError::InvalidHeaderSize {
                expected: 0x10,
                actual: header_size as u32,
            });
        }

        let _chunk_size = cursor.read_u32::<LittleEndian>()?;
        let _line_number = cursor.read_u32::<LittleEndian>()?;
        let _comment = cursor.read_u32::<LittleEndian>()?;
        let _namespace_idx = cursor.read_i32::<LittleEndian>()?;
        let name_idx = cursor.read_u32::<LittleEndian>()?;

        let elem_name = self.get_string(name_idx);

        if self.current_tag == elem_name && self.is_one_line && !self.is_last_end {
            // Self-closing tag (no content between start and end)
            self.output.push_str("/>");
        } else {
            // Has child content or CDATA - use closing tag
            if !self.is_last_end {
                self.output.push('>');
            }
            self.start_line();
            self.output.push_str("</");
            self.output.push_str(&elem_name);
            self.output.push('>');
        }

        self.is_last_end = true;
        if self.indent > 0 {
            self.indent -= 1;
        }

        Ok(())
    }

    /// Parse CDATA chunk
    fn parse_cdata(&mut self, cursor: &mut Cursor<&[u8]>) -> Result<()> {
        let header_size = cursor.read_u16::<LittleEndian>()?;
        if header_size != 0x10 {
            return Err(ResourceError::InvalidHeaderSize {
                expected: 0x10,
                actual: header_size as u32,
            });
        }

        let _chunk_size = cursor.read_u32::<LittleEndian>()?;
        let _line_number = cursor.read_u32::<LittleEndian>()?;
        cursor.seek(SeekFrom::Current(4))?; // skip comment

        let str_idx = cursor.read_u32::<LittleEndian>()?;
        let text = self.get_string(str_idx);

        if !self.is_last_end {
            self.is_last_end = true;
            self.output.push('>');
        }

        self.output.push_str(&escape_xml(&text));

        // Skip typed value
        let size = cursor.read_u16::<LittleEndian>()?;
        cursor.seek(SeekFrom::Current((size - 2) as i64))?;

        Ok(())
    }

    /// Get a string from the pool
    fn get_string(&mut self, idx: u32) -> String {
        self.strings.get(idx).unwrap_or_else(|| {
            format!("NOT_FOUND_STR_0x{:x}", idx)
        })
    }

    /// Start a new line with indentation (4 spaces per level to match Java JADX)
    fn start_line(&mut self) {
        self.output.push('\n');
        for _ in 0..self.indent {
            self.output.push_str("    ");
        }
    }

    /// Start a new line for content (marks element as having content)
    fn start_content_line(&mut self) {
        self.start_line();
        self.is_one_line = false;
    }

    /// Add one level of indentation (4 spaces to match Java JADX)
    fn add_indent(&mut self) {
        self.output.push_str("    ");
    }
}

impl Default for AxmlParser {
    fn default() -> Self {
        Self::new()
    }
}

/// Check if a resource ID is internal
fn is_res_internal_id(resid: u32) -> bool {
    (resid & 0xFFFF0000) != 0 && (resid & 0xFF0000) == 0
}

/// Escape special XML characters
fn escape_xml(s: &str) -> String {
    let mut result = String::with_capacity(s.len());
    for c in s.chars() {
        match c {
            '<' => result.push_str("&lt;"),
            '>' => result.push_str("&gt;"),
            '&' => result.push_str("&amp;"),
            '"' => result.push_str("&quot;"),
            '\'' => result.push_str("&apos;"),
            _ => result.push(c),
        }
    }
    result
}

/// Format a float value for XML output
fn float_to_string(value: f64) -> String {
    if value == value.floor() && !value.is_infinite() {
        format!("{}", value as i64)
    } else {
        // Remove trailing zeros
        let s = format!("{:.4}", value);
        s.trim_end_matches('0').trim_end_matches('.').to_string()
    }
}

/// Decode Android enum/flag attribute values
/// Returns Some(string) if the attribute has a known enum mapping
fn decode_enum_value(attr_name: &str, data: i32) -> Option<String> {
    match attr_name {
        // Layout dimensions
        "layout_width" | "layout_height" | "width" | "height" |
        "minWidth" | "minHeight" | "maxWidth" | "maxHeight" => {
            match data {
                -1 => Some("match_parent".to_string()),
                -2 => Some("wrap_content".to_string()),
                _ => None,
            }
        }
        // Orientation
        "orientation" => {
            match data {
                0 => Some("horizontal".to_string()),
                1 => Some("vertical".to_string()),
                _ => None,
            }
        }
        // Visibility
        "visibility" => {
            match data {
                0 => Some("visible".to_string()),
                1 => Some("invisible".to_string()),
                2 => Some("gone".to_string()),
                _ => None,
            }
        }
        // Fill type (for vector drawables)
        "fillType" => {
            match data {
                0 => Some("nonZero".to_string()),
                1 => Some("evenOdd".to_string()),
                _ => None,
            }
        }
        // Text alignment
        "textAlignment" => {
            match data {
                0 => Some("inherit".to_string()),
                1 => Some("gravity".to_string()),
                2 => Some("textStart".to_string()),
                3 => Some("textEnd".to_string()),
                4 => Some("center".to_string()),
                5 => Some("viewStart".to_string()),
                6 => Some("viewEnd".to_string()),
                _ => None,
            }
        }
        // Input type
        "inputType" => {
            // Common input types (flags can be combined)
            match data {
                0 => Some("none".to_string()),
                1 => Some("text".to_string()),
                2 => Some("textCapCharacters".to_string()),
                3 => Some("number".to_string()),
                4 => Some("phone".to_string()),
                _ => None,
            }
        }
        // Gravity (flags - return None for complex combos, let it show as int)
        "gravity" | "layout_gravity" => {
            // Only handle simple single-flag values
            match data {
                0 => None, // Usually means default, show as "0"
                0x01 => Some("top".to_string()),
                0x10 => Some("bottom".to_string()),
                0x03 => Some("left".to_string()),
                0x05 => Some("right".to_string()),
                0x11 => Some("center_vertical".to_string()),
                0x07 => Some("center_horizontal".to_string()),
                0x17 => Some("center".to_string()),
                0x30 => Some("fill_vertical".to_string()),
                0x70 => Some("fill_horizontal".to_string()),
                0x77 => Some("fill".to_string()),
                0x800003 => Some("start".to_string()),
                0x800005 => Some("end".to_string()),
                _ => None,
            }
        }
        // Scale type for ImageView
        "scaleType" => {
            match data {
                0 => Some("matrix".to_string()),
                1 => Some("fitXY".to_string()),
                2 => Some("fitStart".to_string()),
                3 => Some("fitCenter".to_string()),
                4 => Some("fitEnd".to_string()),
                5 => Some("center".to_string()),
                6 => Some("centerCrop".to_string()),
                7 => Some("centerInside".to_string()),
                _ => None,
            }
        }
        // Ellipsize
        "ellipsize" => {
            match data {
                0 => Some("none".to_string()),
                1 => Some("start".to_string()),
                2 => Some("middle".to_string()),
                3 => Some("end".to_string()),
                4 => Some("marquee".to_string()),
                _ => None,
            }
        }
        // AutoLink
        "autoLink" => {
            match data {
                0 => Some("none".to_string()),
                1 => Some("web".to_string()),
                2 => Some("email".to_string()),
                4 => Some("phone".to_string()),
                8 => Some("map".to_string()),
                15 => Some("all".to_string()),
                _ => None,
            }
        }
        _ => None,
    }
}

#[cfg(test)]
mod tests {
    use super::*;

    #[test]
    fn test_escape_xml() {
        assert_eq!(escape_xml("hello"), "hello");
        assert_eq!(escape_xml("<test>"), "&lt;test&gt;");
        assert_eq!(escape_xml("a&b"), "a&amp;b");
        assert_eq!(escape_xml("\"quoted\""), "&quot;quoted&quot;");
    }

    #[test]
    fn test_float_to_string() {
        assert_eq!(float_to_string(1.0), "1");
        assert_eq!(float_to_string(1.5), "1.5");
        assert_eq!(float_to_string(1.25), "1.25");
    }

    #[test]
    fn test_is_res_internal() {
        assert!(!is_res_internal_id(0x7f010001));
        assert!(is_res_internal_id(0x01000001));
    }
}
