//! Android resource format constants
//!
//! Based on frameworks/base/libs/androidfw/include/androidfw/ResourceTypes.h (AOSP)

// Chunk types
pub const RES_NULL_TYPE: u16 = 0x0000;
pub const RES_STRING_POOL_TYPE: u16 = 0x0001;
pub const RES_TABLE_TYPE: u16 = 0x0002;
pub const RES_XML_TYPE: u16 = 0x0003;

// XML chunk types
pub const RES_XML_FIRST_CHUNK_TYPE: u16 = 0x0100;
pub const RES_XML_START_NAMESPACE_TYPE: u16 = 0x0100;
pub const RES_XML_END_NAMESPACE_TYPE: u16 = 0x0101;
pub const RES_XML_START_ELEMENT_TYPE: u16 = 0x0102;
pub const RES_XML_END_ELEMENT_TYPE: u16 = 0x0103;
pub const RES_XML_CDATA_TYPE: u16 = 0x0104;
pub const RES_XML_LAST_CHUNK_TYPE: u16 = 0x017f;
pub const RES_XML_RESOURCE_MAP_TYPE: u16 = 0x0180;

// Resource table chunk types
pub const RES_TABLE_PACKAGE_TYPE: u16 = 0x0200;
pub const RES_TABLE_TYPE_TYPE: u16 = 0x0201;
pub const RES_TABLE_TYPE_SPEC_TYPE: u16 = 0x0202;
pub const RES_TABLE_TYPE_LIBRARY: u16 = 0x0203;
pub const RES_TABLE_TYPE_OVERLAY: u16 = 0x0204;
pub const RES_TABLE_TYPE_OVERLAY_POLICY: u16 = 0x0205;
pub const RES_TABLE_TYPE_STAGED_ALIAS: u16 = 0x0206;

// Value types
pub const TYPE_NULL: u8 = 0x00;
pub const TYPE_REFERENCE: u8 = 0x01;
pub const TYPE_ATTRIBUTE: u8 = 0x02;
pub const TYPE_STRING: u8 = 0x03;
pub const TYPE_FLOAT: u8 = 0x04;
pub const TYPE_DIMENSION: u8 = 0x05;
pub const TYPE_FRACTION: u8 = 0x06;
pub const TYPE_DYNAMIC_REFERENCE: u8 = 0x07;
pub const TYPE_DYNAMIC_ATTRIBUTE: u8 = 0x08;
pub const TYPE_FIRST_INT: u8 = 0x10;
pub const TYPE_INT_DEC: u8 = 0x10;
pub const TYPE_INT_HEX: u8 = 0x11;
pub const TYPE_INT_BOOLEAN: u8 = 0x12;
pub const TYPE_FIRST_COLOR_INT: u8 = 0x1c;
pub const TYPE_INT_COLOR_ARGB8: u8 = 0x1c;
pub const TYPE_INT_COLOR_RGB8: u8 = 0x1d;
pub const TYPE_INT_COLOR_ARGB4: u8 = 0x1e;
pub const TYPE_INT_COLOR_RGB4: u8 = 0x1f;
pub const TYPE_LAST_COLOR_INT: u8 = 0x1f;
pub const TYPE_LAST_INT: u8 = 0x1f;

// Dimension/fraction constants
pub const COMPLEX_UNIT_SHIFT: u32 = 0;
pub const COMPLEX_UNIT_MASK: u32 = 0xf;
pub const COMPLEX_UNIT_PX: u32 = 0;
pub const COMPLEX_UNIT_DIP: u32 = 1;
pub const COMPLEX_UNIT_SP: u32 = 2;
pub const COMPLEX_UNIT_PT: u32 = 3;
pub const COMPLEX_UNIT_IN: u32 = 4;
pub const COMPLEX_UNIT_MM: u32 = 5;
pub const COMPLEX_UNIT_FRACTION: u32 = 0;
pub const COMPLEX_UNIT_FRACTION_PARENT: u32 = 1;

pub const COMPLEX_RADIX_SHIFT: u32 = 4;
pub const COMPLEX_RADIX_MASK: u32 = 0x3;
pub const COMPLEX_RADIX_23P0: u32 = 0;
pub const COMPLEX_RADIX_16P7: u32 = 1;
pub const COMPLEX_RADIX_8P15: u32 = 2;
pub const COMPLEX_RADIX_0P23: u32 = 3;

pub const COMPLEX_MANTISSA_SHIFT: u32 = 8;
pub const COMPLEX_MANTISSA_MASK: u32 = 0xffffff;

// String pool flags
pub const SORTED_FLAG: u32 = 1;
pub const UTF8_FLAG: u32 = 1 << 8;

// ResTable_type flags
pub const NO_ENTRY: u32 = 0xFFFFFFFF;
pub const FLAG_SPARSE: u8 = 0x01;
pub const FLAG_OFFSET16: u8 = 0x02;

// ResTable_entry flags
pub const FLAG_COMPLEX: u16 = 0x0001;
pub const FLAG_PUBLIC: u16 = 0x0002;
pub const FLAG_WEAK: u16 = 0x0004;
pub const FLAG_COMPACT: u16 = 0x0008;

// Android namespace
pub const ANDROID_NS_URL: &str = "http://schemas.android.com/apk/res/android";
pub const ANDROID_NS_PREFIX: &str = "android";

/// Dimension unit suffixes
pub const DIMENSION_UNITS: [&str; 6] = ["px", "dp", "sp", "pt", "in", "mm"];

/// Fraction unit suffixes
pub const FRACTION_UNITS: [&str; 2] = ["%", "%p"];

/// Radix multipliers for complex values (after extracting mantissa)
/// These convert the 24-bit signed mantissa to the actual value
pub const RADIX_MULTS: [f64; 4] = [
    1.0,              // 23p0: integer value
    1.0 / 128.0,      // 16p7: 7 fractional bits
    1.0 / 32768.0,    // 8p15: 15 fractional bits
    1.0 / 8388608.0,  // 0p23: 23 fractional bits
];

/// Decode a complex dimension value to a string
pub fn decode_dimension(data: u32) -> String {
    let unit = (data >> COMPLEX_UNIT_SHIFT) & COMPLEX_UNIT_MASK;
    let value = decode_complex_value(data);

    let unit_str = if (unit as usize) < DIMENSION_UNITS.len() {
        DIMENSION_UNITS[unit as usize]
    } else {
        "??"
    };

    format_float_value(value, unit_str)
}

/// Decode a complex fraction value to a string
pub fn decode_fraction(data: u32) -> String {
    let unit = (data >> COMPLEX_UNIT_SHIFT) & COMPLEX_UNIT_MASK;
    let value = decode_complex_value(data) * 100.0;

    let unit_str = if (unit as usize) < FRACTION_UNITS.len() {
        FRACTION_UNITS[unit as usize]
    } else {
        "??"
    };

    format_float_value(value, unit_str)
}

/// Decode a complex value (dimension or fraction)
/// Complex values have: [mantissa: 24 bits signed][radix: 2 bits][unit: 4 bits]
fn decode_complex_value(data: u32) -> f64 {
    let radix = (data >> COMPLEX_RADIX_SHIFT) & COMPLEX_RADIX_MASK;
    // Extract mantissa as signed 24-bit value
    let mantissa = (data as i32) >> COMPLEX_MANTISSA_SHIFT as i32;
    mantissa as f64 * RADIX_MULTS[radix as usize]
}

fn format_float_value(value: f64, suffix: &str) -> String {
    if value == value.floor() {
        format!("{}{}", value as i64, suffix)
    } else {
        // Format with 6 decimal places, trim trailing zeros
        let formatted = format!("{:.6}", value);
        let trimmed = formatted.trim_end_matches('0').trim_end_matches('.');
        format!("{}{}", trimmed, suffix)
    }
}
