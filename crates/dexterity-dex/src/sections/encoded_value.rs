//! DEX encoded_value and encoded_array parsing
//!
//! Encoded values are used for static field initializers, annotation values, etc.
//! Format: type_byte where low 5 bits = type, high 3 bits = (size - 1) for variable types

use crate::consts::type_codes::*;
use crate::error::{DexError, Result};
use crate::utils::read_uleb128;

/// Visibility values for annotations
pub const VISIBILITY_BUILD: u8 = 0x00;
pub const VISIBILITY_RUNTIME: u8 = 0x01;
pub const VISIBILITY_SYSTEM: u8 = 0x02;

/// A parsed annotation from the DEX file
#[derive(Debug, Clone, PartialEq)]
pub struct EncodedAnnotation {
    /// Type index for the annotation class
    pub type_idx: u32,
    /// Name-value pairs
    pub elements: Vec<AnnotationElement>,
}

/// An annotation element (name-value pair)
#[derive(Debug, Clone, PartialEq)]
pub struct AnnotationElement {
    /// Name index (string_ids index)
    pub name_idx: u32,
    /// Element value
    pub value: EncodedValue,
}

/// A decoded value from DEX encoded_value format
#[derive(Debug, Clone, PartialEq)]
pub enum EncodedValue {
    /// Signed byte value
    Byte(i8),
    /// Signed 16-bit value
    Short(i16),
    /// Unsigned 16-bit char
    Char(u16),
    /// Signed 32-bit value
    Int(i32),
    /// Signed 64-bit value
    Long(i64),
    /// 32-bit float
    Float(f32),
    /// 64-bit double
    Double(f64),
    /// String index
    String(u32),
    /// Type index
    Type(u32),
    /// Field index
    Field(u32),
    /// Method index
    Method(u32),
    /// Enum field index
    Enum(u32),
    /// Array of values
    Array(Vec<EncodedValue>),
    /// Null reference
    Null,
    /// Boolean value
    Boolean(bool),
    /// Method type (proto index)
    MethodType(u32),
    /// Method handle index
    MethodHandle(u32),
    /// Nested annotation
    Annotation(EncodedAnnotation),
}

impl EncodedValue {
    /// Convert to a string representation for code generation
    pub fn to_literal(&self) -> String {
        match self {
            EncodedValue::Byte(v) => format!("(byte) {}", v),
            EncodedValue::Short(v) => format!("(short) {}", v),
            EncodedValue::Char(v) => {
                if *v >= 32 && *v < 127 {
                    format!("'{}'", char::from_u32(*v as u32).unwrap_or('?'))
                } else {
                    format!("'\\u{:04x}'", v)
                }
            }
            EncodedValue::Int(v) => v.to_string(),
            EncodedValue::Long(v) => format!("{}L", v),
            EncodedValue::Float(v) => {
                if v.is_nan() {
                    "Float.NaN".to_string()
                } else if *v == f32::INFINITY {
                    "Float.POSITIVE_INFINITY".to_string()
                } else if *v == f32::NEG_INFINITY {
                    "Float.NEGATIVE_INFINITY".to_string()
                } else {
                    format!("{}f", v)
                }
            }
            EncodedValue::Double(v) => {
                if v.is_nan() {
                    "Double.NaN".to_string()
                } else if *v == f64::INFINITY {
                    "Double.POSITIVE_INFINITY".to_string()
                } else if *v == f64::NEG_INFINITY {
                    "Double.NEGATIVE_INFINITY".to_string()
                } else {
                    format!("{}d", v)
                }
            }
            EncodedValue::String(idx) => format!("string#{}", idx), // Needs resolution
            EncodedValue::Type(idx) => format!("type#{}", idx),     // Needs resolution
            EncodedValue::Field(idx) => format!("field#{}", idx),   // Needs resolution
            EncodedValue::Method(idx) => format!("method#{}", idx), // Needs resolution
            EncodedValue::Enum(idx) => format!("enum#{}", idx),     // Needs resolution
            EncodedValue::Array(values) => {
                let items: Vec<_> = values.iter().map(|v| v.to_literal()).collect();
                format!("{{ {} }}", items.join(", "))
            }
            EncodedValue::Null => "null".to_string(),
            EncodedValue::Boolean(v) => v.to_string(),
            EncodedValue::MethodType(idx) => format!("methodtype#{}", idx),
            EncodedValue::MethodHandle(idx) => format!("methodhandle#{}", idx),
            EncodedValue::Annotation(ann) => {
                let elements: Vec<_> = ann.elements.iter()
                    .map(|e| format!("name#{}={}", e.name_idx, e.value.to_literal()))
                    .collect();
                format!("@type#{}({})", ann.type_idx, elements.join(", "))
            }
        }
    }
}

/// Parse an encoded_array_item (used for static field initializers)
/// Format: size (uleb128), followed by that many encoded_value items
pub fn parse_encoded_array(data: &[u8], offset: usize) -> Result<(Vec<EncodedValue>, usize)> {
    let mut pos = offset;

    // Read array size
    let (size, len) = read_uleb128(&data[pos..])?;
    pos += len;

    let mut values = Vec::with_capacity(size as usize);
    for _ in 0..size {
        let (value, len) = parse_encoded_value(data, pos)?;
        pos += len;
        values.push(value);
    }

    Ok((values, pos - offset))
}

/// Parse a single encoded_value
/// Returns the value and number of bytes consumed
pub fn parse_encoded_value(data: &[u8], offset: usize) -> Result<(EncodedValue, usize)> {
    if offset >= data.len() {
        return Err(DexError::UnexpectedEof {
            offset,
            needed: 1,
        });
    }

    let type_byte = data[offset];
    let value_type = type_byte & 0x1f;
    let value_arg = (type_byte >> 5) as usize; // size - 1 for variable types

    let mut pos = offset + 1;

    let value = match value_type {
        VALUE_BYTE => {
            let v = read_signed(data, pos, 1)?;
            pos += 1;
            EncodedValue::Byte(v as i8)
        }
        VALUE_SHORT => {
            let size = value_arg + 1;
            let v = read_signed(data, pos, size)?;
            pos += size;
            EncodedValue::Short(v as i16)
        }
        VALUE_CHAR => {
            let size = value_arg + 1;
            let v = read_unsigned(data, pos, size)?;
            pos += size;
            EncodedValue::Char(v as u16)
        }
        VALUE_INT => {
            let size = value_arg + 1;
            let v = read_signed(data, pos, size)?;
            pos += size;
            EncodedValue::Int(v as i32)
        }
        VALUE_LONG => {
            let size = value_arg + 1;
            let v = read_signed(data, pos, size)?;
            pos += size;
            EncodedValue::Long(v)
        }
        VALUE_FLOAT => {
            let size = value_arg + 1;
            let v = read_float(data, pos, size)?;
            pos += size;
            EncodedValue::Float(v)
        }
        VALUE_DOUBLE => {
            let size = value_arg + 1;
            let v = read_double(data, pos, size)?;
            pos += size;
            EncodedValue::Double(v)
        }
        VALUE_METHOD_TYPE => {
            let size = value_arg + 1;
            let v = read_unsigned(data, pos, size)?;
            pos += size;
            EncodedValue::MethodType(v as u32)
        }
        VALUE_METHOD_HANDLE => {
            let size = value_arg + 1;
            let v = read_unsigned(data, pos, size)?;
            pos += size;
            EncodedValue::MethodHandle(v as u32)
        }
        VALUE_STRING => {
            let size = value_arg + 1;
            let v = read_unsigned(data, pos, size)?;
            pos += size;
            EncodedValue::String(v as u32)
        }
        VALUE_TYPE => {
            let size = value_arg + 1;
            let v = read_unsigned(data, pos, size)?;
            pos += size;
            EncodedValue::Type(v as u32)
        }
        VALUE_FIELD => {
            let size = value_arg + 1;
            let v = read_unsigned(data, pos, size)?;
            pos += size;
            EncodedValue::Field(v as u32)
        }
        VALUE_METHOD => {
            let size = value_arg + 1;
            let v = read_unsigned(data, pos, size)?;
            pos += size;
            EncodedValue::Method(v as u32)
        }
        VALUE_ENUM => {
            let size = value_arg + 1;
            let v = read_unsigned(data, pos, size)?;
            pos += size;
            EncodedValue::Enum(v as u32)
        }
        VALUE_ARRAY => {
            let (values, len) = parse_encoded_array(data, pos)?;
            pos += len;
            EncodedValue::Array(values)
        }
        VALUE_ANNOTATION => {
            // Parse the nested annotation
            let (annotation, len) = parse_encoded_annotation(data, pos)?;
            pos += len;
            EncodedValue::Annotation(annotation)
        }
        VALUE_NULL => EncodedValue::Null,
        VALUE_BOOLEAN => EncodedValue::Boolean(value_arg != 0),
        _ => {
            return Err(DexError::Parse {
                offset,
                message: format!("unknown encoded_value type: 0x{:02x}", value_type),
            });
        }
    };

    Ok((value, pos - offset))
}

/// Read an unsigned integer of the given size (1-8 bytes), zero-extended
fn read_unsigned(data: &[u8], offset: usize, size: usize) -> Result<u64> {
    if offset + size > data.len() {
        return Err(DexError::UnexpectedEof {
            offset,
            needed: size,
        });
    }

    let mut value: u64 = 0;
    for i in 0..size {
        value |= (data[offset + i] as u64) << (i * 8);
    }
    Ok(value)
}

/// Read a signed integer of the given size (1-8 bytes), sign-extended
fn read_signed(data: &[u8], offset: usize, size: usize) -> Result<i64> {
    let unsigned = read_unsigned(data, offset, size)?;

    // Sign extend if the high bit is set
    let shift = 64 - (size * 8);
    Ok((unsigned as i64) << shift >> shift)
}

/// Read a float value (right-zero-extended to 4 bytes)
fn read_float(data: &[u8], offset: usize, size: usize) -> Result<f32> {
    if offset + size > data.len() {
        return Err(DexError::UnexpectedEof {
            offset,
            needed: size,
        });
    }

    let mut bytes = [0u8; 4];
    // Values are right-zero-extended, so put at high bytes
    let start = 4 - size;
    for i in 0..size {
        bytes[start + i] = data[offset + i];
    }
    Ok(f32::from_le_bytes(bytes))
}

/// Read a double value (right-zero-extended to 8 bytes)
fn read_double(data: &[u8], offset: usize, size: usize) -> Result<f64> {
    if offset + size > data.len() {
        return Err(DexError::UnexpectedEof {
            offset,
            needed: size,
        });
    }

    let mut bytes = [0u8; 8];
    // Values are right-zero-extended, so put at high bytes
    let start = 8 - size;
    for i in 0..size {
        bytes[start + i] = data[offset + i];
    }
    Ok(f64::from_le_bytes(bytes))
}

/// Parse an encoded_annotation
/// Returns the parsed annotation and number of bytes consumed
pub fn parse_encoded_annotation(data: &[u8], offset: usize) -> Result<(EncodedAnnotation, usize)> {
    let mut pos = offset;

    // type_idx
    let (type_idx, len) = read_uleb128(&data[pos..])?;
    pos += len;

    // size (number of elements)
    let (size, len) = read_uleb128(&data[pos..])?;
    pos += len;

    // Parse each annotation_element
    let mut elements = Vec::with_capacity(size as usize);
    for _ in 0..size {
        // name_idx
        let (name_idx, len) = read_uleb128(&data[pos..])?;
        pos += len;
        // value
        let (value, len) = parse_encoded_value(data, pos)?;
        pos += len;

        elements.push(AnnotationElement {
            name_idx: name_idx as u32,
            value,
        });
    }

    let annotation = EncodedAnnotation {
        type_idx: type_idx as u32,
        elements,
    };

    Ok((annotation, pos - offset))
}

/// An annotation item with visibility
#[derive(Debug, Clone, PartialEq)]
pub struct AnnotationItem {
    /// Visibility (build, runtime, system)
    pub visibility: u8,
    /// The annotation content
    pub annotation: EncodedAnnotation,
}

/// Parse an annotation_item (visibility + encoded_annotation)
pub fn parse_annotation_item(data: &[u8], offset: usize) -> Result<(AnnotationItem, usize)> {
    if offset >= data.len() {
        return Err(DexError::UnexpectedEof {
            offset,
            needed: 1,
        });
    }

    let visibility = data[offset];
    let (annotation, len) = parse_encoded_annotation(data, offset + 1)?;

    Ok((AnnotationItem { visibility, annotation }, 1 + len))
}

#[cfg(test)]
mod tests {
    use super::*;

    #[test]
    fn test_parse_int() {
        // VALUE_INT with value 42 (size 1 byte, value_arg = 0)
        let data = [0x04, 0x2a]; // type=INT, size=1, value=42
        let (value, len) = parse_encoded_value(&data, 0).unwrap();
        assert_eq!(len, 2);
        assert_eq!(value, EncodedValue::Int(42));
    }

    #[test]
    fn test_parse_null() {
        let data = [VALUE_NULL];
        let (value, len) = parse_encoded_value(&data, 0).unwrap();
        assert_eq!(len, 1);
        assert_eq!(value, EncodedValue::Null);
    }

    #[test]
    fn test_parse_boolean_true() {
        let data = [VALUE_BOOLEAN | (1 << 5)]; // value_arg = 1 means true
        let (value, len) = parse_encoded_value(&data, 0).unwrap();
        assert_eq!(len, 1);
        assert_eq!(value, EncodedValue::Boolean(true));
    }

    #[test]
    fn test_parse_boolean_false() {
        let data = [VALUE_BOOLEAN]; // value_arg = 0 means false
        let (value, len) = parse_encoded_value(&data, 0).unwrap();
        assert_eq!(len, 1);
        assert_eq!(value, EncodedValue::Boolean(false));
    }

    #[test]
    fn test_parse_string() {
        // VALUE_STRING with index 5 (size 1 byte)
        let data = [VALUE_STRING, 0x05];
        let (value, len) = parse_encoded_value(&data, 0).unwrap();
        assert_eq!(len, 2);
        assert_eq!(value, EncodedValue::String(5));
    }

    #[test]
    fn test_parse_array() {
        // Array with 2 integers: [1, 2]
        let data = [
            VALUE_ARRAY,
            0x02,       // size = 2
            0x04, 0x01, // int 1
            0x04, 0x02, // int 2
        ];
        let (value, len) = parse_encoded_value(&data, 0).unwrap();
        assert_eq!(len, 6);
        assert_eq!(
            value,
            EncodedValue::Array(vec![EncodedValue::Int(1), EncodedValue::Int(2)])
        );
    }

    #[test]
    fn test_parse_long() {
        // VALUE_LONG with value 0x123456789ABCDEF0 (8 bytes, value_arg = 7)
        let data = [
            0x06 | (7 << 5), // type=LONG, value_arg=7 (8 bytes)
            0xF0,
            0xDE,
            0xBC,
            0x9A,
            0x78,
            0x56,
            0x34,
            0x12,
        ];
        let (value, len) = parse_encoded_value(&data, 0).unwrap();
        assert_eq!(len, 9);
        assert_eq!(value, EncodedValue::Long(0x123456789ABCDEF0u64 as i64));
    }

    #[test]
    fn test_to_literal() {
        assert_eq!(EncodedValue::Int(42).to_literal(), "42");
        assert_eq!(EncodedValue::Long(100).to_literal(), "100L");
        assert_eq!(EncodedValue::Boolean(true).to_literal(), "true");
        assert_eq!(EncodedValue::Null.to_literal(), "null");
        assert_eq!(EncodedValue::Char(65).to_literal(), "'A'");
    }
}
