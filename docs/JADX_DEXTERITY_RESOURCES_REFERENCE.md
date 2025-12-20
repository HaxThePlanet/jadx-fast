# JADX Resources vs Dexterity Resources Reference

This document provides a comprehensive 1:1 mapping between JADX's Java-based resource parser and Dexterity's Rust-based `dexterity-resources` crate. Both implement Android's binary resource formats (AXML and ARSC).

---

## Architecture Overview

```
JADX (Java):
  resources.arsc → ResTableBinaryParser → ResContainer → XML files
  *.xml (binary) → BinaryXMLParser → BinaryXMLStrings → Formatted XML

Dexterity (Rust):
  resources.arsc → ArscParser → ResourceEntry[] → XML generation
  *.xml (binary) → AxmlParser → StringPool → Formatted XML
```

---

## Module/Class Mapping Table

| Component | JADX (Java) | Dexterity (Rust) |
|-----------|-------------|------------------|
| String Pool | `BinaryXMLStrings.java` | `string_pool.rs` |
| AXML Parser | `BinaryXMLParser.java` | `axml.rs` (`AxmlParser`) |
| ARSC Parser | `ResTableBinaryParser.java` | `arsc.rs` (`ArscParser`) |
| Resource Config | `EntryConfig.java` | `arsc.rs` (`ResConfig`) |
| Resource Entry | `ResourceEntry.java` | `arsc.rs` (`ResourceEntry`) |
| Value Types | `RawValue.java` | `arsc.rs` (`RawValue`) |
| Constants | (scattered) | `constants.rs` |
| Errors | (exceptions) | `error.rs` |
| Stream Reader | `ParserStream.java` | (inline in parsers) |
| Manifest Attrs | `ManifestAttributes.java` | `axml.rs` (static maps) |

---

## Chunk Types

### JADX Constants (scattered)

```java
// Various locations
public static final int RES_STRING_POOL_TYPE = 0x0001;
public static final int RES_TABLE_TYPE = 0x0002;
public static final int RES_XML_TYPE = 0x0003;
// XML chunks
public static final int RES_XML_START_NAMESPACE = 0x0100;
public static final int RES_XML_END_NAMESPACE = 0x0101;
public static final int RES_XML_START_ELEMENT = 0x0102;
public static final int RES_XML_END_ELEMENT = 0x0103;
public static final int RES_XML_CDATA = 0x0104;
public static final int RES_XML_RESOURCE_MAP = 0x0180;
// Table chunks
public static final int RES_TABLE_PACKAGE = 0x0200;
public static final int RES_TABLE_TYPE = 0x0201;
public static final int RES_TABLE_TYPE_SPEC = 0x0202;
```

### Dexterity Constants

```rust
// constants.rs

// Top-level chunks
pub const RES_NULL_TYPE: u16 = 0x0000;
pub const RES_STRING_POOL_TYPE: u16 = 0x0001;
pub const RES_TABLE_TYPE: u16 = 0x0002;
pub const RES_XML_TYPE: u16 = 0x0003;

// XML chunks
pub const RES_XML_START_NAMESPACE_TYPE: u16 = 0x0100;
pub const RES_XML_END_NAMESPACE_TYPE: u16 = 0x0101;
pub const RES_XML_START_ELEMENT_TYPE: u16 = 0x0102;
pub const RES_XML_END_ELEMENT_TYPE: u16 = 0x0103;
pub const RES_XML_CDATA_TYPE: u16 = 0x0104;
pub const RES_XML_RESOURCE_MAP_TYPE: u16 = 0x0180;

// Resource table chunks
pub const RES_TABLE_PACKAGE_TYPE: u16 = 0x0200;
pub const RES_TABLE_TYPE_TYPE: u16 = 0x0201;
pub const RES_TABLE_TYPE_SPEC_TYPE: u16 = 0x0202;
pub const RES_TABLE_TYPE_LIBRARY: u16 = 0x0203;
pub const RES_TABLE_TYPE_OVERLAY: u16 = 0x0204;
pub const RES_TABLE_TYPE_OVERLAY_POLICY: u16 = 0x0205;
pub const RES_TABLE_TYPE_STAGED_ALIAS: u16 = 0x0206;
```

---

## Value Types

### JADX Value Types

```java
// Various locations
public static final int TYPE_NULL = 0x00;
public static final int TYPE_REFERENCE = 0x01;
public static final int TYPE_ATTRIBUTE = 0x02;
public static final int TYPE_STRING = 0x03;
public static final int TYPE_FLOAT = 0x04;
public static final int TYPE_DIMENSION = 0x05;
public static final int TYPE_FRACTION = 0x06;
public static final int TYPE_INT_DEC = 0x10;
public static final int TYPE_INT_HEX = 0x11;
public static final int TYPE_INT_BOOLEAN = 0x12;
public static final int TYPE_INT_COLOR_ARGB8 = 0x1c;
public static final int TYPE_INT_COLOR_RGB8 = 0x1d;
public static final int TYPE_INT_COLOR_ARGB4 = 0x1e;
public static final int TYPE_INT_COLOR_RGB4 = 0x1f;
```

### Dexterity Value Types

```rust
// constants.rs
pub const TYPE_NULL: u8 = 0x00;
pub const TYPE_REFERENCE: u8 = 0x01;
pub const TYPE_ATTRIBUTE: u8 = 0x02;
pub const TYPE_STRING: u8 = 0x03;
pub const TYPE_FLOAT: u8 = 0x04;
pub const TYPE_DIMENSION: u8 = 0x05;
pub const TYPE_FRACTION: u8 = 0x06;
pub const TYPE_DYNAMIC_REFERENCE: u8 = 0x07;
pub const TYPE_DYNAMIC_ATTRIBUTE: u8 = 0x08;
pub const TYPE_INT_DEC: u8 = 0x10;
pub const TYPE_INT_HEX: u8 = 0x11;
pub const TYPE_INT_BOOLEAN: u8 = 0x12;
pub const TYPE_INT_COLOR_ARGB8: u8 = 0x1c;
pub const TYPE_INT_COLOR_RGB8: u8 = 0x1d;
pub const TYPE_INT_COLOR_ARGB4: u8 = 0x1e;
pub const TYPE_INT_COLOR_RGB4: u8 = 0x1f;
```

### Value Type Comparison Table

| Type | Value | JADX | Dexterity | Description |
|------|-------|------|-----------|-------------|
| Null | 0x00 | `TYPE_NULL` | `TYPE_NULL` | Undefined/empty |
| Reference | 0x01 | `TYPE_REFERENCE` | `TYPE_REFERENCE` | `@package:type/name` |
| Attribute | 0x02 | `TYPE_ATTRIBUTE` | `TYPE_ATTRIBUTE` | `?attr/name` |
| String | 0x03 | `TYPE_STRING` | `TYPE_STRING` | String pool index |
| Float | 0x04 | `TYPE_FLOAT` | `TYPE_FLOAT` | 32-bit IEEE 754 |
| Dimension | 0x05 | `TYPE_DIMENSION` | `TYPE_DIMENSION` | Value + unit (dp, sp, px) |
| Fraction | 0x06 | `TYPE_FRACTION` | `TYPE_FRACTION` | Percentage |
| Dynamic Ref | 0x07 | N/A | `TYPE_DYNAMIC_REFERENCE` | Runtime resource |
| Dynamic Attr | 0x08 | N/A | `TYPE_DYNAMIC_ATTRIBUTE` | Runtime attribute |
| Int Dec | 0x10 | `TYPE_INT_DEC` | `TYPE_INT_DEC` | Signed decimal |
| Int Hex | 0x11 | `TYPE_INT_HEX` | `TYPE_INT_HEX` | Unsigned hex |
| Boolean | 0x12 | `TYPE_INT_BOOLEAN` | `TYPE_INT_BOOLEAN` | 0=false, else=true |
| Color ARGB8 | 0x1C | `TYPE_INT_COLOR_ARGB8` | `TYPE_INT_COLOR_ARGB8` | `#AARRGGBB` |
| Color RGB8 | 0x1D | `TYPE_INT_COLOR_RGB8` | `TYPE_INT_COLOR_RGB8` | `#RRGGBB` |
| Color ARGB4 | 0x1E | `TYPE_INT_COLOR_ARGB4` | `TYPE_INT_COLOR_ARGB4` | `#ARGB` (4-bit) |
| Color RGB4 | 0x1F | `TYPE_INT_COLOR_RGB4` | `TYPE_INT_COLOR_RGB4` | `#RGB` (4-bit) |

---

## String Pool

### JADX BinaryXMLStrings

```java
// BinaryXMLStrings.java
public class BinaryXMLStrings {
    private final int count;
    private final int stringsOffset;
    private final int[] offsets;
    private final ByteBuffer buf;
    private final boolean isUtf8;
    private final Map<Integer, String> cache;

    public String get(int id) {
        // Check cache
        String cached = cache.get(id);
        if (cached != null) return cached;

        // Extract string
        String str = isUtf8
            ? extractString8(offsets[id])
            : extractString16(offsets[id]);

        cache.put(id, str);
        return str;
    }

    // UTF-8 extraction (with MUTF-8 length encoding)
    private String extractString8(int offset);

    // UTF-16LE extraction (null-terminated)
    private String extractString16(int offset);
}
```

### Dexterity StringPool

```rust
// string_pool.rs
pub struct StringPool {
    string_count: u32,
    strings_start: u32,
    buffer: Vec<u8>,              // Offsets + string data
    is_utf8: bool,
    cache: HashMap<u32, String>,  // Decoded string cache
}

impl StringPool {
    pub fn new(count: u32, start: u32, buffer: Vec<u8>, flags: u32) -> Self;

    pub fn len(&self) -> usize;
    pub fn is_empty(&self) -> bool;

    pub fn get(&mut self, id: u32) -> Option<String> {
        // Check cache
        if let Some(s) = self.cache.get(&id) {
            return Some(s.clone());
        }

        // Extract string
        let offset = self.read_offset(id)?;
        let s = if self.is_utf8 {
            self.extract_string8(offset)
        } else {
            self.extract_string16(offset)
        };

        self.cache.insert(id, s.clone());
        Some(s)
    }

    // Override for deobfuscation
    pub fn put(&mut self, id: u32, content: String);

    // UTF-8 with variable-length char count + 1-2 byte length
    fn extract_string8(&self, offset: usize) -> String;

    // UTF-16LE with SIMD-like batch processing
    fn extract_string16(&self, offset: usize) -> String;
}
```

### String Pool Flags

| Flag | Value | Description |
|------|-------|-------------|
| SORTED_FLAG | 0x0001 | Strings are sorted |
| UTF8_FLAG | 0x0100 | UTF-8 encoding (vs UTF-16LE) |

---

## AXML (Binary XML) Parser

### JADX BinaryXMLParser

```java
// BinaryXMLParser.java
public class BinaryXMLParser {
    private BinaryXMLStrings strings;
    private final Map<String, String> nsMap;     // URI -> prefix
    private int currentElementAttrCount;
    private XmlCodeWriter writer;

    public ICodeInfo parse(InputStream input) {
        // Validate header (type=0x0003, header_size=0x0008)
        // Parse string pool
        // Parse resource IDs
        // Process chunks in order
    }

    private void processChunk(int type) {
        switch (type) {
            case RES_XML_START_NAMESPACE:
                parseNamespace();
                break;
            case RES_XML_START_ELEMENT:
                parseStartElement();
                break;
            case RES_XML_END_ELEMENT:
                parseEndElement();
                break;
            case RES_XML_CDATA:
                parseCData();
                break;
        }
    }

    private void parseAttribute() {
        // namespace_idx, name_idx, raw_value_idx
        // value_size, res0, data_type, data
    }

    private String decodeValue(int type, int data);
}
```

### Dexterity AxmlParser

```rust
// axml.rs
pub struct AxmlParser {
    strings: StringPool,
    resource_ids: Vec<u32>,
    ns_map: HashMap<String, String>,          // URI -> prefix
    ns_generated: HashSet<String>,            // Auto-generated prefixes
    defined_namespaces: HashSet<String>,      // Already output
    current_tag: String,
    is_last_end: bool,
    is_one_line: bool,
    namespace_depth: u32,
    app_package_name: Option<String>,
    res_names: HashMap<u32, String>,          // From ARSC
    output: String,
    indent: usize,
    first_element: bool,
    attr_new_line: bool,
}

impl AxmlParser {
    pub fn new() -> Self;

    pub fn set_res_names(&mut self, names: HashMap<u32, String>);
    pub fn set_pretty_print(&mut self, enabled: bool);

    pub fn parse(&mut self, data: &[u8]) -> Result<String> {
        // Validate header
        // Parse string pool chunk
        // Parse resource ID map chunk
        // Process element chunks
    }

    fn parse_string_pool(&mut self, data: &[u8], pos: &mut usize) -> Result<()>;
    fn parse_resource_map(&mut self, data: &[u8], pos: &mut usize) -> Result<()>;
    fn parse_namespace_start(&mut self, data: &[u8], pos: &mut usize) -> Result<()>;
    fn parse_namespace_end(&mut self, data: &[u8], pos: &mut usize) -> Result<()>;
    fn parse_element_start(&mut self, data: &[u8], pos: &mut usize) -> Result<()>;
    fn parse_element_end(&mut self, data: &[u8], pos: &mut usize) -> Result<()>;
    fn parse_cdata(&mut self, data: &[u8], pos: &mut usize) -> Result<()>;

    fn parse_attribute(&mut self, data: &[u8], pos: &mut usize) -> Result<XmlAttribute>;
    fn decode_attribute_value(&self, data_type: u8, data: u32, name: &str) -> String;
    fn decode_reference(&self, data: u32) -> String;
    fn decode_enum_value(&self, name: &str, value: u32) -> Option<String>;
}
```

### AXML Chunk Structure

**XML Header:**
```
type: u16 (0x0003)
header_size: u16 (0x0008)
chunk_size: u32
```

**String Pool Chunk:**
```
type: u16 (0x0001)
header_size: u16
chunk_size: u32
string_count: u32
style_count: u32
flags: u32 (SORTED | UTF8)
strings_start: u32
styles_start: u32
offsets[string_count]: u32[]
string_data: bytes
```

**Resource ID Map Chunk:**
```
type: u16 (0x0180)
header_size: u16
chunk_size: u32
resource_ids[]: u32[]  // Parallel to string pool
```

**Namespace Start/End:**
```
type: u16 (0x0100 / 0x0101)
header_size: u16
chunk_size: u32
line_number: u32
comment: u32 (string index or -1)
prefix: u32 (string index)
uri: u32 (string index)
```

**Element Start:**
```
type: u16 (0x0102)
header_size: u16
chunk_size: u32
line_number: u32
comment: u32
namespace: u32 (string index or -1)
name: u32 (string index)
attribute_start: u16
attribute_size: u16
attribute_count: u16
id_index: u16
class_index: u16
style_index: u16
attributes[attribute_count]: Attribute
```

**Attribute:**
```
namespace: u32 (string index or -1)
name: u32 (string index)
raw_value: u32 (string index or -1)
size: u16
res0: u8 (always 0)
data_type: u8
data: u32
```

---

## ARSC (Resource Table) Parser

### JADX ResTableBinaryParser

```java
// ResTableBinaryParser.java
public class ResTableBinaryParser {
    private final ParserStream input;
    private BinaryXMLStrings strings;
    private ResourceStorage resStorage;

    public void decode(InputStream input) {
        // Read table header
        // Parse global string pool
        // Parse package chunks
    }

    private void decodePackage() {
        // Package header: id, name, type/key string offsets
        // Parse type string pool
        // Parse key string pool
        // Parse type specs
        // Parse type chunks with entries
    }

    private String decodeValue(int dataType, int data);
}
```

### Dexterity ArscParser

```rust
// arsc.rs
pub struct ArscParser {
    strings: StringPool,
    entries: Vec<ResourceEntry>,
    res_names: HashMap<u32, String>,
}

impl ArscParser {
    pub fn new() -> Self;

    pub fn parse(&mut self, data: &[u8]) -> Result<()> {
        // Validate RES_TABLE_TYPE (0x0002)
        // Parse global string pool
        // Iterate package chunks
        // Build resource name map
    }

    pub fn get_res_names(&self) -> &HashMap<u32, String>;
    pub fn get_entries(&self) -> &[ResourceEntry];

    // XML generation
    pub fn generate_strings_xml(&self) -> String;
    pub fn generate_colors_xml(&self) -> String;
    pub fn generate_drawables_xml(&self) -> String;
    pub fn generate_styles_xml(&self) -> String;
    pub fn generate_arrays_xml(&self) -> String;
    pub fn generate_plurals_xml(&self) -> String;
    pub fn generate_dimens_xml(&self) -> String;
    pub fn generate_integers_xml(&self) -> String;
    pub fn generate_bools_xml(&self) -> String;
    pub fn generate_public_xml(&self) -> String;
    pub fn generate_values_xml(&self) -> HashMap<String, String>;

    fn decode_value(&self, value: &RawValue) -> Option<String>;
}
```

### Resource Table Structure

**Table Header:**
```
type: u16 (0x0002)
header_size: u16
chunk_size: u32
package_count: u32
```

**Package Chunk:**
```
type: u16 (0x0200)
header_size: u16
chunk_size: u32
id: u32 (0x7F for app, 0x01 for android)
name: u16[128] (UTF-16LE package name)
type_strings_off: u32
last_public_type: u32
key_strings_off: u32
last_public_key: u32
type_id_offset: u32
```

**Type Spec Chunk:**
```
type: u16 (0x0202)
header_size: u16
chunk_size: u32
id: u8 (1-based type ID)
res0: u8
res1: u16
entry_count: u32
config_masks[entry_count]: u32[]
```

**Type Chunk:**
```
type: u16 (0x0201)
header_size: u16
chunk_size: u32
id: u8
flags: u8 (SPARSE=0x01, OFFSET16=0x02)
res1: u16
entry_count: u32
entries_start: u32
config: ResConfig
offsets[entry_count]: u32[] (or u16[] if OFFSET16)
entries[]: Entry[]
```

---

## Resource Configuration (ResConfig)

### JADX EntryConfig

```java
// EntryConfig.java
public class EntryConfig {
    // Network
    private int mcc, mnc;

    // Locale
    private char[] language, country;
    private char[] localeScript, localeVariant;

    // Display
    private int orientation;       // 0=any, 1=port, 2=land, 3=square
    private int touchscreen;       // 1=notouch, 2=stylus, 3=finger
    private int density;           // DPI: 120, 160, 240, 320, etc.

    // Input
    private int keyboard;          // 1=nokeys, 2=qwerty, 3=12key
    private int navigation;        // 1=nonav, 2=dpad, 3=trackball, 4=wheel
    private int inputFlags;

    // Screen
    private int screenWidth, screenHeight;
    private int sdkVersion;
    private int screenLayout;
    private int uiMode;
    private int smallestScreenWidthDp;
    private int screenWidthDp, screenHeightDp;
    private int screenLayout2;
    private int colorMode;

    public String getQualifiers();  // e.g., "en-rUS-hdpi-v21"
}
```

### Dexterity ResConfig

```rust
// arsc.rs
pub struct ResConfig {
    // Mobile/Network
    pub mcc: u16,
    pub mnc: u16,

    // Locale (2 chars each)
    pub language: [u8; 2],
    pub country: [u8; 2],

    // Display
    pub orientation: u8,        // 0=any, 1=port, 2=land, 3=square
    pub touchscreen: u8,        // 1=notouch, 2=stylus, 3=finger
    pub density: u16,           // DPI value

    // Input
    pub keyboard: u8,           // 1=nokeys, 2=qwerty, 3=12key
    pub navigation: u8,         // 1=nonav, 2=dpad, 3=trackball, 4=wheel
    pub input_flags: u8,

    // Screen dimensions
    pub screen_width: u16,
    pub screen_height: u16,

    // SDK Version
    pub sdk_version: u16,
    pub minor_version: u16,

    // Screen layout (API 4+)
    pub screen_layout: u8,
    pub ui_mode: u8,
    pub smallest_screen_width_dp: u16,

    // Screen dimensions in dp (API 13+)
    pub screen_width_dp: u16,
    pub screen_height_dp: u16,

    // Locale script/variant (BCP 47, API 21+)
    pub locale_script: [u8; 4],   // ISO 15924 script
    pub locale_variant: [u8; 8],  // BCP 47 variant

    // Screen layout 2 (API 26+)
    pub screen_layout2: u8,       // round (2 bits)

    // Color mode (API 26+)
    pub color_mode: u8,           // HDR + wide color gamut
}

impl ResConfig {
    pub fn parse(cursor: &mut Cursor<&[u8]>, config_size: usize) -> Result<Self>;
    pub fn to_qualifier_string(&self) -> String;
}
```

### Configuration Qualifier Generation

Both implementations generate Android-compatible folder qualifiers:

| Config Field | Qualifier Example |
|--------------|-------------------|
| mcc | `-mcc310` |
| mnc | `-mnc004` |
| language + country | `-en-rUS` |
| screen orientation | `-port`, `-land` |
| touchscreen | `-notouch`, `-finger` |
| density | `-ldpi`, `-mdpi`, `-hdpi`, `-xhdpi`, `-xxhdpi` |
| keyboard | `-nokeys`, `-qwerty`, `-12key` |
| navigation | `-nonav`, `-dpad`, `-trackball`, `-wheel` |
| screen size | `-small`, `-normal`, `-large`, `-xlarge` |
| screen aspect | `-long`, `-notlong` |
| ui mode | `-car`, `-desk`, `-television`, `-appliance`, `-watch`, `-vrheadset` |
| night mode | `-night`, `-notnight` |
| sdk version | `-v21` |
| screen width dp | `-w600dp` |
| screen height dp | `-h800dp` |
| smallest width | `-sw600dp` |
| round screen | `-round`, `-notround` |

---

## Resource Entry

### JADX ResourceEntry

```java
// ResourceEntry.java
public class ResourceEntry {
    private final int id;              // Full resource ID
    private final String packageName;
    private final String typeName;     // "string", "drawable", etc.
    private final String keyName;      // Entry name
    private final EntryConfig config;

    // Value storage
    private RawValue simpleValue;
    private ProtoValue protoValue;
    private List<NamedValue> namedValues;  // For styles/arrays
    private ResourceEntry parent;          // Style inheritance
}
```

### Dexterity ResourceEntry

```rust
// arsc.rs
pub struct ResourceEntry {
    pub id: u32,                       // 0xPPTTEEEE
    pub package_name: String,
    pub type_name: String,
    pub key_name: String,
    pub value: Option<RawValue>,       // Simple value
    pub bag_items: Option<Vec<BagItem>>,  // Complex items
    pub parent: Option<u32>,           // Parent resource ID
    pub config: String,                // Qualifier string
}

pub struct RawValue {
    pub data_type: u8,
    pub data: u32,
}

pub struct BagItem {
    pub name: u32,         // Attribute resource ID
    pub value: RawValue,
}
```

### Resource ID Format

```
Resource ID: 0xPPTTEEEE
  PP = Package ID (0x7F = app, 0x01 = android framework)
  TT = Type ID (1-based index into type string pool)
  EEEE = Entry ID (0-based index into entries)
```

### Entry Flags

| Flag | Value | Description |
|------|-------|-------------|
| FLAG_COMPLEX | 0x0001 | Complex entry (bag/style/array) |
| FLAG_PUBLIC | 0x0002 | Public resource |
| FLAG_WEAK | 0x0004 | Weak reference |
| FLAG_COMPACT | 0x0008 | Compact format (24-bit value) |

### Entry Layout

**Simple Entry:**
```
size: u16
flags: u16
key_idx: u32 (string pool index)
// Res_value
value_size: u16
res0: u8 (always 0)
data_type: u8
data: u32
```

**Complex Entry (FLAG_COMPLEX):**
```
size: u16
flags: u16
key_idx: u32
parent: u32 (parent resource ID for styles)
count: u32
entries[count]: (name: u32, value: Res_value)
```

---

## Dimension/Fraction Decoding

### Complex Value Format

```
32-bit value: [mantissa: 24 bits][radix: 2 bits][unit: 4 bits]
```

### Dimension Units

| Unit | Value | Description |
|------|-------|-------------|
| px | 0 | Pixels |
| dp/dip | 1 | Density-independent pixels |
| sp | 2 | Scale-independent pixels |
| pt | 3 | Points (1/72 inch) |
| in | 4 | Inches |
| mm | 5 | Millimeters |

### Fraction Units

| Unit | Value | Description |
|------|-------|-------------|
| % | 0 | Percentage of own size |
| %p | 1 | Percentage of parent size |

### Radix Multipliers

| Radix | Value | Multiplier |
|-------|-------|------------|
| 23p0 | 0 | 1.0 (integer) |
| 16p7 | 1 | 1/128 (7 fractional bits) |
| 8p15 | 2 | 1/32768 (15 fractional bits) |
| 0p23 | 3 | 1/8388608 (23 fractional bits) |

### JADX Dimension Decoding

```java
// ValuesParser.java
public static String decodeComplex(int rawValue, boolean fraction) {
    float value = (rawValue & 0xFFFFFF00) * RADIX_MULTS[(rawValue >> 4) & 0x3];
    int unitType = rawValue & 0xF;

    if (fraction) {
        return String.format("%.2f%s", value * 100, unitType == 0 ? "%" : "%p");
    } else {
        return String.format("%.2f%s", value, DIMENSION_UNITS[unitType]);
    }
}
```

### Dexterity Dimension Decoding

```rust
// constants.rs
pub fn decode_dimension(raw: u32) -> String {
    let mantissa = (raw & 0xFFFFFF00) as i32 >> 8;
    let radix = (raw >> 4) & 0x3;
    let unit = raw & 0xF;

    let multiplier = match radix {
        0 => 1.0,
        1 => 1.0 / 128.0,
        2 => 1.0 / 32768.0,
        3 => 1.0 / 8388608.0,
        _ => 1.0,
    };

    let value = mantissa as f64 * multiplier;
    let unit_str = match unit {
        0 => "px",
        1 => "dp",
        2 => "sp",
        3 => "pt",
        4 => "in",
        5 => "mm",
        _ => "px",
    };

    format!("{:.2}{}", value, unit_str)
}

pub fn decode_fraction(raw: u32) -> String {
    let mantissa = (raw & 0xFFFFFF00) as i32 >> 8;
    let radix = (raw >> 4) & 0x3;
    let unit = raw & 0xF;

    let multiplier = match radix {
        0 => 1.0,
        1 => 1.0 / 128.0,
        2 => 1.0 / 32768.0,
        3 => 1.0 / 8388608.0,
        _ => 1.0,
    };

    let value = mantissa as f64 * multiplier * 100.0;
    let unit_str = if unit == 0 { "%" } else { "%p" };

    format!("{:.2}{}", value, unit_str)
}
```

---

## Enum/Flag Attribute Mappings

Both JADX and Dexterity maintain mappings for common Android attributes:

### Layout Attributes

| Attribute | Value | Enum Name |
|-----------|-------|-----------|
| layout_width/-1 | -1 | match_parent |
| layout_width/-2 | -2 | wrap_content |
| visibility/0 | 0 | visible |
| visibility/4 | 4 | invisible |
| visibility/8 | 8 | gone |
| orientation/0 | 0 | horizontal |
| orientation/1 | 1 | vertical |

### Gravity Flags

| Flag | Value | Name |
|------|-------|------|
| 0x00000001 | 1 | top |
| 0x00000002 | 2 | bottom |
| 0x00000004 | 4 | left |
| 0x00000008 | 8 | right |
| 0x00000010 | 16 | center_vertical |
| 0x00000020 | 32 | fill_vertical |
| 0x00000040 | 64 | center_horizontal |
| 0x00000080 | 128 | fill_horizontal |
| 0x00000011 | 17 | center |
| 0x00000077 | 119 | fill |

### Screen Orientation Values

| Value | Name |
|-------|------|
| -1 | unspecified |
| 0 | landscape |
| 1 | portrait |
| 2 | user |
| 3 | behind |
| 4 | sensor |
| 5 | nosensor |
| 6 | sensorLandscape |
| 7 | sensorPortrait |
| 8 | reverseLandscape |
| 9 | reversePortrait |
| 10 | fullSensor |
| 11 | userLandscape |
| 12 | userPortrait |
| 13 | fullUser |
| 14 | locked |

### Launch Mode Values

| Value | Name |
|-------|------|
| 0 | standard |
| 1 | singleTop |
| 2 | singleTask |
| 3 | singleInstance |
| 4 | singleInstancePerTask |

### Config Changes Flags

| Flag | Value | Name |
|------|-------|------|
| 0x0001 | 1 | mcc |
| 0x0002 | 2 | mnc |
| 0x0004 | 4 | locale |
| 0x0008 | 8 | touchscreen |
| 0x0010 | 16 | keyboard |
| 0x0020 | 32 | keyboardHidden |
| 0x0040 | 64 | navigation |
| 0x0080 | 128 | orientation |
| 0x0100 | 256 | screenLayout |
| 0x0200 | 512 | uiMode |
| 0x0400 | 1024 | screenSize |
| 0x0800 | 2048 | smallestScreenSize |
| 0x1000 | 4096 | density |
| 0x2000 | 8192 | layoutDirection |
| 0x4000 | 16384 | colorMode |
| 0x8000 | 32768 | fontScale |

---

## Android Framework Resource ID Maps

Both implementations include extensive mappings for Android framework resources:

### Dexterity Android Attribute Map (~400+ entries)

```rust
// axml.rs - ANDROID_ATTR_MAP
static ANDROID_ATTR_MAP: HashMap<u32, &str> = {
    0x01010000 => "theme",
    0x01010001 => "label",
    0x01010002 => "icon",
    0x01010003 => "name",
    0x01010006 => "permission",
    // ... hundreds more
    0x010100f4 => "layout_width",
    0x010100f5 => "layout_height",
    0x01010129 => "text",
    0x0101014f => "textColor",
    0x01010150 => "textSize",
    // ...
};
```

### Dexterity Android Resource Map

```rust
// arsc.rs - ANDROID_RES_MAP
// Colors
0x0106000c => "android:color/white",
0x0106000d => "android:color/black",
0x01060012 => "android:color/transparent",

// Strings
0x01040000 => "android:string/cancel",
0x01040001 => "android:string/copy",
0x01040002 => "android:string/cut",
0x01040008 => "android:string/ok",
0x01040009 => "android:string/paste",

// Drawables
0x01080000 => "android:drawable/alert_dark_frame",
0x01080003 => "android:drawable/btn_default",

// Styles
0x01030000 => "android:style/Animation",
0x01030001 => "android:style/Animation.Activity",
0x010300e8 => "android:style/Theme",
0x010300f2 => "android:style/Theme.Light",

// IDs
0x01020001 => "android:id/button1",
0x01020002 => "android:id/button2",
0x01020004 => "android:id/checkbox",
0x01020006 => "android:id/content",
0x01020008 => "android:id/icon",
0x0102000a => "android:id/list",
```

---

## Error Handling

### JADX Errors (Exceptions)

```java
// Various exception types
public class JadxException extends Exception;
public class JadxRuntimeException extends RuntimeException;
// Specific parse errors thrown inline
```

### Dexterity ResourceError

```rust
// error.rs
#[derive(Debug, thiserror::Error)]
pub enum ResourceError {
    #[error("I/O error: {0}")]
    Io(#[from] std::io::Error),

    #[error("Invalid binary XML: {0}")]
    InvalidBinaryXml(String),

    #[error("Invalid string pool: {0}")]
    InvalidStringPool(String),

    #[error("Invalid ARSC: {0}")]
    InvalidArsc(String),

    #[error("Unexpected chunk type: {0:#06x}")]
    UnexpectedChunkType(u16),

    #[error("Invalid header size: expected {expected}, got {actual}")]
    InvalidHeaderSize { expected: u16, actual: u16 },

    #[error("Invalid chunk size: expected {expected}, got {actual}")]
    InvalidChunkSize { expected: u32, actual: u32 },

    #[error("String index {index} out of bounds (count: {count})")]
    StringIndexOutOfBounds { index: u32, count: u32 },

    #[error("Decode error at position {position}: {message}")]
    DecodeError { position: usize, message: String },

    #[error("UTF-8 error: {0}")]
    Utf8Error(#[from] std::string::FromUtf8Error),

    #[error("UTF-16 decode error")]
    Utf16Error,
}

pub type Result<T> = std::result::Result<T, ResourceError>;
```

---

## XML Generation

### Dexterity XML Generators

```rust
// arsc.rs - generates res/values/*.xml files

impl ArscParser {
    /// Generate strings.xml for a specific config
    pub fn generate_strings_xml(&self) -> String {
        // <?xml version="1.0" encoding="utf-8"?>
        // <resources>
        //   <string name="app_name">MyApp</string>
        // </resources>
    }

    /// Generate colors.xml
    pub fn generate_colors_xml(&self) -> String;

    /// Generate styles.xml with parent inheritance
    pub fn generate_styles_xml(&self) -> String {
        // <style name="AppTheme" parent="Theme.AppCompat">
        //   <item name="colorPrimary">@color/primary</item>
        // </style>
    }

    /// Generate arrays.xml (string-array, integer-array)
    pub fn generate_arrays_xml(&self) -> String;

    /// Generate plurals.xml with quantity items
    pub fn generate_plurals_xml(&self) -> String {
        // <plurals name="items">
        //   <item quantity="one">%d item</item>
        //   <item quantity="other">%d items</item>
        // </plurals>
    }

    /// Generate public.xml with all resource IDs
    pub fn generate_public_xml(&self) -> String {
        // <public type="string" name="app_name" id="0x7f040001" />
    }

    /// Generate all values files keyed by config qualifier
    pub fn generate_values_xml(&self) -> HashMap<String, String>;
}
```

### AXML Output

```rust
// axml.rs - generates formatted XML from binary

impl AxmlParser {
    pub fn parse(&mut self, data: &[u8]) -> Result<String> {
        // Output: <?xml version="1.0" encoding="utf-8"?>
        // Pretty-printed with 4-space indentation
        // Self-closing tags for empty elements
        // Namespace declarations on first use
        // XML entity escaping
    }
}
```

---

## File Locations

### JADX (Java)

```
jadx-fast/jadx-core/src/main/java/jadx/core/xmlgen/
├── BinaryXMLParser.java
├── BinaryXMLStrings.java
├── ParserStream.java
├── ResTableBinaryParser.java
├── ResContainer.java
├── ManifestAttributes.java
├── XmlGenUtils.java
└── entry/
    ├── EntryConfig.java
    ├── ResourceEntry.java
    ├── ValuesParser.java
    ├── RawValue.java
    └── ProtoValue.java
```

### Dexterity (Rust)

```
crates/dexterity-resources/src/
├── lib.rs           # Module exports
├── error.rs         # ResourceError enum
├── constants.rs     # Chunk types, value types, decoders
├── string_pool.rs   # StringPool (UTF-8/UTF-16)
├── axml.rs          # AxmlParser (~962 lines)
└── arsc.rs          # ArscParser (~1858 lines)
```

---

## Integration Pattern

```rust
// Typical usage: parse ARSC first to get resource names, then parse AXML

// 1. Parse resources.arsc
let mut arsc_parser = ArscParser::new();
arsc_parser.parse(&arsc_data)?;

// 2. Get resource ID -> name mapping
let res_names = arsc_parser.get_res_names().clone();

// 3. Parse AndroidManifest.xml with resource names
let mut axml_parser = AxmlParser::new();
axml_parser.set_res_names(res_names);
axml_parser.set_pretty_print(true);
let manifest_xml = axml_parser.parse(&manifest_data)?;

// 4. Generate values/ XML files
let values_files = arsc_parser.generate_values_xml();
```

---

## Recent Fixes (Dec 17, 2025)

Three critical fixes to resource processing now achieve **1:1 identical output** with JADX:

### Fix 1: Compact Complex Entry Detection

**Problem:** Bag item parsing failed for compact complex entries (styles with size==16).

**Root Cause:** The FLAG_COMPLEX flag alone was insufficient - JADX also checks `size==16` for compact complex entries.

**Solution:** Added dual check in `parse_entry()`:
```rust
// Note: JADX checks both FLAG_COMPLEX flag AND size==16 (compact complex entries)
let is_complex = (flags & FLAG_COMPLEX) != 0 || size_or_flags == 16;
```

**Impact:** Style items now correctly parsed as complex entries, resolving attribute name mismatches.

### Fix 2: Style Parent Name Resolution via ANDROID_RES_MAP

**Problem:** Android framework style parents showed raw hex IDs instead of names.

**Root Cause:** Parent style IDs from the Android framework (package ID 0x01) were not being resolved through `ANDROID_RES_MAP`.

**Solution:** Added ANDROID_RES_MAP lookup in `generate_styles_xml()`:
```rust
} else if (parent_id >> 24) == 0x01 {
    // Android framework style - try to resolve from ANDROID_RES_MAP
    if let Some(android_name) = ANDROID_RES_MAP.get(&parent_id) {
        xml.push_str(" parent=\"@android:");
        xml.push_str(android_name);
        xml.push('"');
    } else {
        xml.push_str(&format!(" parent=\"@android:style/0x{:08x}\"", parent_id));
    }
}
```

**Impact:** Style parents now show readable names like `@android:style/Widget.Button` instead of `@0x01030073`.

### Fix 3: Attribute Reference Formatting with android: Prefix

**Problem:** Android framework attributes in style items showed incorrect format.

**Root Cause:** TYPE_ATTRIBUTE values from Android framework weren't getting the `android:` prefix.

**Solution:** Enhanced `decode_value()` for TYPE_ATTRIBUTE:
```rust
TYPE_ATTRIBUTE => {
    if let Some(name) = self.res_names.get(&value.data) {
        Some(format!("?{}", name))
    } else if let Some(name) = ANDROID_RES_MAP.get(&value.data) {
        // Android framework attribute - add "android:" prefix
        Some(format!("?android:{}", name))
    } else if let Some(name) = ANDROID_ATTR_MAP.get(&value.data) {
        // Android framework attribute from attr map
        Some(format!("?android:attr/{}", name))
    } else {
        Some(format!("?0x{:08x}", value.data))
    }
}
```

**Impact:** Attribute references now correctly formatted with `?android:attr/...` prefix, matching JADX output.

### Verification

After these fixes, resource output is **1:1 identical** with JADX for:
- strings.xml
- styles.xml (including parent resolution)
- colors.xml
- arrays.xml
- public.xml
- AndroidManifest.xml

---

**Last Updated:** December 17, 2025
