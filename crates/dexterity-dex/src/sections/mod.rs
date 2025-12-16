//! DEX file sections
//!
//! This module contains parsers for the various sections of a DEX file.

mod class_def;
mod code_item;
mod encoded_value;
mod field_id;
mod method_id;
mod proto_id;

pub use class_def::{ClassData, ClassDef, EncodedField, EncodedMethod, FieldIterator, MethodIterator};
pub use code_item::{CatchHandler, CodeItem, TryItem, TypeAddrPair};
pub use encoded_value::{
    parse_annotation_item, parse_encoded_annotation, parse_encoded_array, parse_encoded_value,
    AnnotationElement, AnnotationItem, EncodedAnnotation, EncodedValue,
    VISIBILITY_BUILD, VISIBILITY_RUNTIME, VISIBILITY_SYSTEM,
};
pub use field_id::FieldId;
pub use method_id::MethodId;
pub use proto_id::ProtoId;

/// Helper to read a u32 from a byte slice
#[inline]
pub(crate) fn read_u32(data: &[u8], offset: usize) -> u32 {
    u32::from_le_bytes([
        data[offset],
        data[offset + 1],
        data[offset + 2],
        data[offset + 3],
    ])
}

/// Helper to read a u16 from a byte slice
#[inline]
pub(crate) fn read_u16(data: &[u8], offset: usize) -> u16 {
    u16::from_le_bytes([data[offset], data[offset + 1]])
}

/// Helper to read an i32 from a byte slice
#[inline]
#[allow(dead_code)]
pub(crate) fn read_i32(data: &[u8], offset: usize) -> i32 {
    i32::from_le_bytes([
        data[offset],
        data[offset + 1],
        data[offset + 2],
        data[offset + 3],
    ])
}
