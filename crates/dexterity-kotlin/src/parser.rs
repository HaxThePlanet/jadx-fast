//! Kotlin metadata annotation parsing

use anyhow::{anyhow, Result};
use dexterity_ir::{Annotation, AnnotationValue};
use prost::Message;
use crate::types::{
    KotlinClassMetadata, KotlinKind, KotlinFunction, KotlinParameter, KotlinProperty,
    KotlinClassFlags, KotlinFunctionFlags, KotlinPropertyFlags, KotlinTypeParameter, KotlinVariance,
};
use crate::proto;
use crate::jvm_proto;

// Class flag bit positions (from Kotlin metadata spec)
const CLASS_FLAG_HAS_ANNOTATIONS: i32 = 0x0001;
const CLASS_FLAG_VISIBILITY_MASK: i32 = 0x000E;    // bits 1-3
const CLASS_FLAG_MODALITY_MASK: i32 = 0x0030;      // bits 4-5
const CLASS_FLAG_KIND_MASK: i32 = 0x01C0;          // bits 6-8
const CLASS_FLAG_IS_INNER: i32 = 0x0200;           // bit 9
const CLASS_FLAG_IS_DATA: i32 = 0x0400;            // bit 10
const CLASS_FLAG_IS_EXTERNAL: i32 = 0x0800;        // bit 11
const CLASS_FLAG_IS_EXPECT: i32 = 0x1000;          // bit 12
const CLASS_FLAG_IS_INLINE: i32 = 0x2000;          // bit 13
const CLASS_FLAG_IS_FUN: i32 = 0x4000;             // bit 14 (fun interface)

// Function flag bit positions
const FUNC_FLAG_HAS_ANNOTATIONS: i32 = 0x0001;
const FUNC_FLAG_VISIBILITY_MASK: i32 = 0x000E;     // bits 1-3
const FUNC_FLAG_MODALITY_MASK: i32 = 0x0030;       // bits 4-5
const FUNC_FLAG_KIND_MASK: i32 = 0x00C0;           // bits 6-7
const FUNC_FLAG_IS_OPERATOR: i32 = 0x0100;         // bit 8
const FUNC_FLAG_IS_INFIX: i32 = 0x0200;            // bit 9
const FUNC_FLAG_IS_INLINE: i32 = 0x0400;           // bit 10
const FUNC_FLAG_IS_TAILREC: i32 = 0x0800;          // bit 11
const FUNC_FLAG_IS_EXTERNAL: i32 = 0x1000;         // bit 12
const FUNC_FLAG_IS_SUSPEND: i32 = 0x2000;          // bit 13

// Property flag bit positions
const PROP_FLAG_HAS_ANNOTATIONS: i32 = 0x0001;
const PROP_FLAG_VISIBILITY_MASK: i32 = 0x000E;     // bits 1-3
const PROP_FLAG_MODALITY_MASK: i32 = 0x0030;       // bits 4-5
const PROP_FLAG_KIND_MASK: i32 = 0x00C0;           // bits 6-7
const PROP_FLAG_IS_VAR: i32 = 0x0100;              // bit 8
const PROP_FLAG_HAS_GETTER: i32 = 0x0200;          // bit 9
const PROP_FLAG_HAS_SETTER: i32 = 0x0400;          // bit 10
const PROP_FLAG_IS_CONST: i32 = 0x0800;            // bit 11
const PROP_FLAG_IS_LATEINIT: i32 = 0x1000;         // bit 12
const PROP_FLAG_HAS_CONSTANT: i32 = 0x2000;        // bit 13
const PROP_FLAG_IS_EXTERNAL: i32 = 0x4000;         // bit 14
const PROP_FLAG_IS_DELEGATED: i32 = 0x8000;        // bit 15

// Value parameter flag bit positions
const PARAM_FLAG_DECLARES_DEFAULT: i32 = 0x0002;   // bit 1
const PARAM_FLAG_IS_CROSSINLINE: i32 = 0x0004;     // bit 2
const PARAM_FLAG_IS_NOINLINE: i32 = 0x0008;        // bit 3

pub fn find_kotlin_metadata(annotations: &[Annotation]) -> Option<&Annotation> {
    annotations.iter().find(|a| {
        a.annotation_type == "kotlin/Metadata" || a.annotation_type.ends_with("/Metadata")
    })
}

#[derive(Debug, Clone)]
pub struct KotlinMetadataAnnotation {
    pub kind: i32,
    pub metadata_version: Vec<i32>,
    pub data1: Vec<String>,
    pub data2: Vec<String>,
    pub extra_string: Option<String>,
    pub package_name: Option<String>,
    pub extra_int: i32,
}

pub fn parse_kotlin_metadata_annotation(annot: &Annotation) -> Result<KotlinMetadataAnnotation> {
    let mut result = KotlinMetadataAnnotation {
        kind: 1,
        metadata_version: vec![1, 8, 0],
        data1: vec![],
        data2: vec![],
        extra_string: None,
        package_name: None,
        extra_int: 0,
    };

    for elem in &annot.elements {
        match elem.name.as_str() {
            "k" => result.kind = extract_int(&elem.value)?,
            "mv" => result.metadata_version = extract_int_array(&elem.value)?,
            "d1" => result.data1 = extract_string_array(&elem.value)?,
            "d2" => result.data2 = extract_string_array(&elem.value)?,
            "xs" => result.extra_string = extract_string(&elem.value).ok(),
            "pn" => result.package_name = extract_string(&elem.value).ok(),
            "xi" => result.extra_int = extract_int(&elem.value)?,
            _ => {}
        }
    }

    Ok(result)
}

fn extract_int(value: &AnnotationValue) -> Result<i32> {
    match value {
        AnnotationValue::Int(i) => Ok(*i),
        _ => Err(anyhow!("Expected int value, got {:?}", value)),
    }
}

fn extract_int_array(value: &AnnotationValue) -> Result<Vec<i32>> {
    match value {
        AnnotationValue::Array(arr) => {
            arr.iter()
                .map(|v| match v {
                    AnnotationValue::Int(i) => Ok(*i),
                    _ => Err(anyhow!("Expected int in array")),
                })
                .collect()
        }
        _ => Err(anyhow!("Expected array value")),
    }
}

fn extract_string(value: &AnnotationValue) -> Result<String> {
    match value {
        AnnotationValue::String(s) => Ok(s.clone()),
        _ => Err(anyhow!("Expected string value")),
    }
}

fn extract_string_array(value: &AnnotationValue) -> Result<Vec<String>> {
    match value {
        AnnotationValue::Array(arr) => {
            arr.iter()
                .map(|v| match v {
                    AnnotationValue::String(s) => Ok(s.clone()),
                    _ => Err(anyhow!("Expected string in array")),
                })
                .collect()
        }
        _ => Err(anyhow!("Expected array value")),
    }
}

/// Parse class flags from raw protobuf flags
fn parse_class_flags(raw_flags: i32) -> KotlinClassFlags {
    KotlinClassFlags {
        is_data: raw_flags & CLASS_FLAG_IS_DATA != 0,
        is_sealed: ((raw_flags & CLASS_FLAG_MODALITY_MASK) >> 4) == 3, // SEALED = 3
        is_inline: raw_flags & CLASS_FLAG_IS_INLINE != 0,
        is_inner: raw_flags & CLASS_FLAG_IS_INNER != 0,
        is_external: raw_flags & CLASS_FLAG_IS_EXTERNAL != 0,
        is_expect: raw_flags & CLASS_FLAG_IS_EXPECT != 0,
        is_fun_interface: raw_flags & CLASS_FLAG_IS_FUN != 0,
    }
}

/// Parse function flags from raw protobuf flags
fn parse_function_flags(raw_flags: i32) -> KotlinFunctionFlags {
    KotlinFunctionFlags {
        is_suspend: raw_flags & FUNC_FLAG_IS_SUSPEND != 0,
        is_inline: raw_flags & FUNC_FLAG_IS_INLINE != 0,
        is_operator: raw_flags & FUNC_FLAG_IS_OPERATOR != 0,
        is_infix: raw_flags & FUNC_FLAG_IS_INFIX != 0,
        is_tailrec: raw_flags & FUNC_FLAG_IS_TAILREC != 0,
        is_external: raw_flags & FUNC_FLAG_IS_EXTERNAL != 0,
    }
}

/// Parse property flags from raw protobuf flags
fn parse_property_flags(raw_flags: i32) -> KotlinPropertyFlags {
    KotlinPropertyFlags {
        is_var: raw_flags & PROP_FLAG_IS_VAR != 0,
        is_const: raw_flags & PROP_FLAG_IS_CONST != 0,
        is_lateinit: raw_flags & PROP_FLAG_IS_LATEINIT != 0,
        is_delegated: raw_flags & PROP_FLAG_IS_DELEGATED != 0,
        has_backing_field: raw_flags & PROP_FLAG_HAS_CONSTANT != 0,
    }
}

/// Decode Kotlin BitEncoding format back to protobuf bytes
///
/// The d1 field in @kotlin.Metadata uses BitEncoding with two modes:
/// 1. UTF-8 mode (marker = '\0'): each char is directly a byte (drop the marker)
/// 2. 8-to-7 mode: complex bit manipulation (legacy, less common)
///
/// See: org.jetbrains.kotlin.metadata.jvm.deserialization.BitEncoding
fn bit_encoding_decode(data: &[String]) -> Result<Vec<u8>> {
    if data.is_empty() || data[0].is_empty() {
        return Ok(vec![]);
    }

    let first_char = data[0].chars().next().unwrap();

    // UTF-8 mode marker = '\0' (0x00)
    if first_char == '\0' {
        // UTF-8 mode: drop the marker and treat each remaining char as a byte
        return utf8_mode_decode(data);
    }

    // 8-to-7 mode marker = '\u0001' (legacy mode)
    const _8TO7_MODE_MARKER: char = '\u{0001}';
    if first_char == _8TO7_MODE_MARKER {
        // Has marker, decode with 7-to-8 bit expansion
        return decode_8to7_mode(data, true);
    }

    // No marker - assume 8-to-7 mode (very old format)
    decode_8to7_mode(data, false)
}

/// UTF-8 mode: each char is directly a byte (after dropping the '\0' marker)
fn utf8_mode_decode(data: &[String]) -> Result<Vec<u8>> {
    let mut bytes = Vec::new();
    let mut first_string = true;

    for s in data {
        let start_idx = if first_string {
            first_string = false;
            1 // Skip the '\0' marker in first string
        } else {
            0
        };

        for c in s.chars().skip(start_idx) {
            let byte = c as u32;
            if byte > 0xFF {
                return Err(anyhow!("Invalid BitEncoding UTF-8 char: U+{:04X}", byte));
            }
            bytes.push(byte as u8);
        }
    }
    Ok(bytes)
}

/// 8-to-7 mode: decode bytes where each char holds 7 bits
fn decode_8to7_mode(data: &[String], has_marker: bool) -> Result<Vec<u8>> {
    // First, combine all strings into bytes
    let mut input_bytes = Vec::new();

    for (i, s) in data.iter().enumerate() {
        let start_idx = if i == 0 && has_marker { 1 } else { 0 };
        for c in s.chars().skip(start_idx) {
            let byte = c as u32;
            if byte > 0xFF {
                return Err(anyhow!("Invalid BitEncoding 8to7 char: U+{:04X}", byte));
            }
            input_bytes.push(byte as u8);
        }
    }

    // Apply modulo byte correction (reverse of addModuloByte)
    add_modulo_byte(&mut input_bytes, 0x7f);

    // Decode 7-to-8: every 8 input bytes (7 bits each) become 7 output bytes (8 bits each)
    decode_7_to_8(&input_bytes)
}

/// Reverse the modulo byte transformation used in 8-to-7 encoding
fn add_modulo_byte(bytes: &mut [u8], modulus: u8) {
    let mut sum = 0u8;
    for i in 0..bytes.len() {
        let old = bytes[i];
        bytes[i] = (bytes[i].wrapping_add(sum)) % modulus;
        sum = sum.wrapping_add(old);
    }
}

/// Decode 7-to-8 bit encoding: expand 7-bit values to 8-bit bytes
fn decode_7_to_8(input: &[u8]) -> Result<Vec<u8>> {
    // Every 8 input bytes (56 bits = 8 * 7) produce 7 output bytes (56 bits = 7 * 8)
    let output_size = input.len() * 7 / 8;
    let mut output = vec![0u8; output_size];

    // Bit manipulation: extract 8 bits at a time from the 7-bit input stream
    let mut bit_offset = 0usize;

    for out_idx in 0..output_size {
        let byte_offset = bit_offset / 7;
        let bit_in_byte = bit_offset % 7;

        if byte_offset >= input.len() {
            break;
        }

        // Get the current byte and possibly the next one
        let current = input[byte_offset] as u16;
        let next = if byte_offset + 1 < input.len() {
            input[byte_offset + 1] as u16
        } else {
            0
        };

        // Combine and extract 8 bits
        let combined = (current << (7 - bit_in_byte)) | (next >> (bit_in_byte + 1));
        output[out_idx] = (combined >> (7 - bit_in_byte - 1)) as u8 & 0xFF;

        bit_offset += 8;
    }

    Ok(output)
}

/// Build string resolver from StringTableTypes + d2 array
///
/// The StringTableTypes message describes how to interpret d2 strings:
/// - `record`: describes each string entry (range, predefined, literal, operation)
/// - `range`: number of times to repeat this record (for consecutive identical entries)
/// - `predefined_index`: index into predefined Kotlin strings (common names)
/// - `string`: literal string value (overrides d2 lookup)
/// - `operation`: transformation to apply (INTERNAL_TO_CLASS_ID, DESC_TO_CLASS_ID)
fn build_string_resolver(
    types: &jvm_proto::StringTableTypes,
    d2: &[String],
) -> Result<Vec<String>> {
    let mut strings = Vec::new();
    let mut d2_idx = 0;

    for record in &types.record {
        let range = record.range.unwrap_or(1) as usize;

        for _ in 0..range {
            // Determine the base string: literal > predefined > d2
            // JADX Clone: StringTableTypes spec - predefined strings REPLACE d2 entries at the same
            // logical position, so d2_idx must ALWAYS advance (consumed even if replaced by predefined)
            let base_string = if let Some(ref literal) = record.string {
                // Literal string specified in the record (replaces d2 entry)
                d2_idx += 1; // Consume the d2 slot
                literal.clone()
            } else if let Some(predef_idx) = record.predefined_index {
                // Predefined Kotlin string (common names) - replaces d2 entry at same position
                d2_idx += 1; // Consume the d2 slot
                get_predefined_string(predef_idx as usize)
            } else if d2_idx < d2.len() {
                // Use next d2 string
                let s = d2[d2_idx].clone();
                d2_idx += 1;
                s
            } else {
                // d2 exhausted - shouldn't happen with valid metadata
                tracing::warn!("d2 index {} out of bounds (len={})", d2_idx, d2.len());
                String::new()
            };

            // Apply operation if specified
            let final_string = match record.operation() {
                jvm_proto::string_table_types::record::Operation::InternalToClassId => {
                    // Convert internal name: java/util/Map$Entry -> java/util/Map.Entry
                    base_string.replace('$', ".")
                }
                jvm_proto::string_table_types::record::Operation::DescToClassId => {
                    // Convert descriptor to class ID: Ljava/lang/String; -> java/lang/String
                    desc_to_class_id(&base_string)
                }
                _ => base_string,
            };

            strings.push(final_string);
        }
    }

    // If no records, fall back to using d2 directly
    if strings.is_empty() && !d2.is_empty() {
        return Ok(d2.to_vec());
    }

    Ok(strings)
}

/// Get predefined Kotlin string by index
/// These are common strings used in Kotlin metadata to save space
fn get_predefined_string(idx: usize) -> String {
    // Predefined strings from Kotlin metadata spec
    // See: kotlin/core/metadata/src/ProtoBuf.java PREDEFINED_STRINGS
    const PREDEFINED_STRINGS: &[&str] = &[
        "kotlin/Any",
        "kotlin/Nothing",
        "kotlin/Unit",
        "kotlin/Throwable",
        "kotlin/Annotation",
        "kotlin/CharSequence",
        "kotlin/String",
        "kotlin/Number",
        "kotlin/Byte",
        "kotlin/Short",
        "kotlin/Int",
        "kotlin/Long",
        "kotlin/Float",
        "kotlin/Double",
        "kotlin/Boolean",
        "kotlin/Char",
        "kotlin/Enum",
        "kotlin/Array",
        "kotlin/Cloneable",
        "kotlin/Comparable",
        "kotlin/collections/Iterable",
        "kotlin/collections/Collection",
        "kotlin/collections/List",
        "kotlin/collections/Set",
        "kotlin/collections/Map",
        "kotlin/collections/MutableIterable",
        "kotlin/collections/MutableCollection",
        "kotlin/collections/MutableList",
        "kotlin/collections/MutableSet",
        "kotlin/collections/MutableMap",
        "kotlin/collections/Iterator",
        "kotlin/collections/ListIterator",
        "kotlin/collections/MutableIterator",
        "kotlin/collections/MutableListIterator",
        "kotlin/collections/Map.Entry",
        "kotlin/collections/MutableMap.MutableEntry",
        "kotlin/Function",
        "kotlin/Function0",
        "kotlin/Function1",
        "kotlin/Function2",
        "kotlin/Function3",
        "kotlin/Function4",
        "kotlin/Function5",
        "kotlin/Function6",
        "kotlin/Function7",
        "kotlin/Function8",
        "kotlin/Function9",
        "kotlin/Function10",
        "kotlin/Function11",
        "kotlin/Function12",
        "kotlin/Function13",
        "kotlin/Function14",
        "kotlin/Function15",
        "kotlin/Function16",
        "kotlin/Function17",
        "kotlin/Function18",
        "kotlin/Function19",
        "kotlin/Function20",
        "kotlin/Function21",
        "kotlin/Function22",
        "kotlin/IntArray",
        "kotlin/LongArray",
        "kotlin/ShortArray",
        "kotlin/ByteArray",
        "kotlin/CharArray",
        "kotlin/BooleanArray",
        "kotlin/FloatArray",
        "kotlin/DoubleArray",
    ];

    PREDEFINED_STRINGS.get(idx).map(|s| s.to_string()).unwrap_or_else(|| {
        tracing::warn!("Unknown predefined string index: {}", idx);
        format!("predefined_{}", idx)
    })
}

/// Convert type descriptor to class ID
/// e.g., "Ljava/lang/String;" -> "java/lang/String"
fn desc_to_class_id(desc: &str) -> String {
    let trimmed = desc.trim();
    if trimmed.starts_with('L') && trimmed.ends_with(';') {
        trimmed[1..trimmed.len() - 1].to_string()
    } else {
        trimmed.to_string()
    }
}

/// Parse d1 protobuf field to extract Kotlin metadata
pub fn parse_d1_protobuf(annot: &KotlinMetadataAnnotation) -> Result<KotlinClassMetadata> {
    // d1 contains BitEncoding-encoded protobuf data (NOT base64!)
    if annot.data1.is_empty() {
        return Err(anyhow!("d1 field is empty"));
    }

    // Decode using BitEncoding (each char = one byte)
    let bytes = bit_encoding_decode(&annot.data1)?;

    // Parse based on kind
    // JADX Reference: KotlinClassMetadata.Kind values
    // 1 = Class, 2 = FileFacade, 3 = SyntheticClass
    // 4 = MultiFileClassFacade, 5 = MultiFileClassPart
    match annot.kind {
        1 => parse_class_metadata(&bytes, annot),  // Class
        2 => parse_package_metadata(&bytes, annot), // Package (file facade)
        3 => parse_synthetic_class_metadata(&bytes, annot), // Synthetic class (lambdas)
        4 => parse_multifile_class_facade(&bytes, annot), // P0.3: MultiFileClassFacade
        5 => parse_multifile_class_part(&bytes, annot), // P0.3: MultiFileClassPart
        _ => Err(anyhow!("Unsupported Kotlin metadata kind: {}", annot.kind)),
    }
}

/// Parse Class metadata (kind = 1)
fn parse_class_metadata(bytes: &[u8], annot: &KotlinMetadataAnnotation) -> Result<KotlinClassMetadata> {
    // The stream contains: StringTableTypes (length-delimited) + Class message
    // Use a mutable slice reference which implements Buf
    let mut remaining = bytes;

    // First, read StringTableTypes (describes how to interpret d2 strings)
    let string_table_types = jvm_proto::StringTableTypes::decode_length_delimited(&mut remaining)
        .map_err(|e| anyhow!("Failed to decode StringTableTypes: {}", e))?;

    // Build string resolver using StringTableTypes + d2 array
    let strings = build_string_resolver(&string_table_types, &annot.data2)?;

    // remaining now points to the Class message (after StringTableTypes was consumed)
    let proto_class = proto::Class::decode(remaining)
        .map_err(|e| anyhow!("Failed to decode Class: {}", e))?;

    // Extract class name
    let class_name = strings
        .get(proto_class.fq_name as usize)
        .ok_or_else(|| anyhow!("Invalid fq_name index: {}", proto_class.fq_name))?
        .clone();

    // Parse class flags
    let raw_flags = proto_class.flags.unwrap_or(6); // default: public final class
    let flags = parse_class_flags(raw_flags);
    let is_data_class = flags.is_data;

    if is_data_class {
        tracing::debug!("Parser detected data class: {} (flags=0x{:x})", class_name, raw_flags);
    }

    // Extract functions with flags
    let functions = proto_class
        .function
        .iter()
        .enumerate()
        .map(|(idx, f)| parse_function(f, &strings, idx as u32))
        .collect::<Result<Vec<_>>>()?;

    // Extract properties (fields) with flags
    let properties = proto_class
        .property
        .iter()
        .enumerate()
        .map(|(idx, p)| parse_property(p, &strings, idx as u32))
        .collect::<Result<Vec<_>>>()?;

    // Detect companion object
    let companion_object = proto_class
        .companion_object_name
        .and_then(|idx| strings.get(idx as usize).cloned());

    // Extract sealed subclasses
    let sealed_subclasses = proto_class
        .sealed_subclass_fq_name
        .iter()
        .filter_map(|&idx| strings.get(idx as usize).cloned())
        .collect();

    // Extract type parameters with variance
    let type_parameters = proto_class
        .type_parameter
        .iter()
        .map(|tp| parse_type_parameter(tp, &strings))
        .collect::<Result<Vec<_>>>()?;

    Ok(KotlinClassMetadata {
        kind: KotlinKind::Class,
        class_name,
        functions,
        properties,
        companion_object,
        is_data_class,
        flags,
        sealed_subclasses,
        type_parameters,
    })
}

/// Parse Package (file facade) metadata (kind = 2)
fn parse_package_metadata(bytes: &[u8], annot: &KotlinMetadataAnnotation) -> Result<KotlinClassMetadata> {
    // The stream contains: StringTableTypes (length-delimited) + Package message
    // Use a mutable slice reference which implements Buf
    let mut remaining = bytes;

    // First, read StringTableTypes (describes how to interpret d2 strings)
    let string_table_types = jvm_proto::StringTableTypes::decode_length_delimited(&mut remaining)
        .map_err(|e| anyhow!("Failed to decode StringTableTypes for package: {}", e))?;

    // Build string resolver using StringTableTypes + d2 array
    let strings = build_string_resolver(&string_table_types, &annot.data2)?;

    // remaining now points to the Package message (after StringTableTypes was consumed)
    let proto_pkg = proto::Package::decode(remaining)
        .map_err(|e| anyhow!("Failed to decode Package: {}", e))?;

    // For packages, extract top-level functions
    let functions = proto_pkg
        .function
        .iter()
        .enumerate()
        .map(|(idx, f)| parse_function(f, &strings, idx as u32))
        .collect::<Result<Vec<_>>>()?;

    // Extract top-level properties
    let properties = proto_pkg
        .property
        .iter()
        .enumerate()
        .map(|(idx, p)| parse_property(p, &strings, idx as u32))
        .collect::<Result<Vec<_>>>()?;

    Ok(KotlinClassMetadata {
        kind: KotlinKind::FileFacade,
        class_name: annot.package_name.clone().unwrap_or_default(),
        functions,
        properties,
        companion_object: None,
        is_data_class: false,
        flags: crate::types::KotlinClassFlags::default(),
        sealed_subclasses: vec![],
        type_parameters: vec![], // Package facades don't have type parameters
    })
}

/// Parse Synthetic class metadata (kind = 3, used for lambdas)
fn parse_synthetic_class_metadata(_bytes: &[u8], _annot: &KotlinMetadataAnnotation) -> Result<KotlinClassMetadata> {
    // Synthetic classes (lambdas) typically don't have names we can use
    // Return a minimal structure
    Ok(KotlinClassMetadata {
        kind: KotlinKind::SyntheticClass,
        class_name: "SyntheticLambda".to_string(),
        functions: vec![],
        properties: vec![],
        companion_object: None,
        is_data_class: false,
        flags: crate::types::KotlinClassFlags::default(),
        sealed_subclasses: vec![],
        type_parameters: vec![], // Synthetic classes don't have type parameters
    })
}

/// Parse MultiFileClassFacade metadata (kind = 4)
/// JADX Reference: kotlinx.metadata.jvm.KotlinClassMetadata.MultiFileClassFacade
///
/// This represents a facade class that combines multiple file-level declarations.
/// The d1 array contains the list of part class internal names.
/// Example: FileKt which combines Foo.kt and Bar.kt
///
/// P0.3 FIX: Adds support for multi-file class facades
fn parse_multifile_class_facade(bytes: &[u8], annot: &KotlinMetadataAnnotation) -> Result<KotlinClassMetadata> {
    // For MultiFileClassFacade, d1 contains StringTableTypes followed by a list of part class names
    // The facade class itself has no functions/properties - those are in the parts
    let mut remaining = bytes;

    // First, read StringTableTypes
    let string_table_types = jvm_proto::StringTableTypes::decode_length_delimited(&mut remaining)
        .map_err(|e| anyhow!("Failed to decode StringTableTypes for MultiFileClassFacade: {}", e))?;

    // Build string resolver
    let strings = build_string_resolver(&string_table_types, &annot.data2)?;

    // The facade class name comes from xs field (cross-module)
    let class_name = annot.extra_string.clone()
        .or_else(|| annot.package_name.clone())
        .unwrap_or_else(|| "MultiFileClassFacade".to_string());

    tracing::debug!(
        "Parsed MultiFileClassFacade: {} with {} part references in d2",
        class_name,
        strings.len()
    );

    // Return facade metadata - functions/properties are in the parts
    Ok(KotlinClassMetadata {
        kind: KotlinKind::MultiFileClassFacade,
        class_name,
        functions: vec![],
        properties: vec![],
        companion_object: None,
        is_data_class: false,
        flags: crate::types::KotlinClassFlags::default(),
        sealed_subclasses: strings, // Store part class names in sealed_subclasses field (repurposed)
        type_parameters: vec![],
    })
}

/// Parse MultiFileClassPart metadata (kind = 5)
/// JADX Reference: kotlinx.metadata.jvm.KotlinClassMetadata.MultiFileClassPart
///
/// This represents one part of a multi-file class. Contains Package-level
/// declarations plus reference to the facade class.
/// Example: FileKt__FooKt is a part of FileKt facade
///
/// P0.3 FIX: Adds support for multi-file class parts
fn parse_multifile_class_part(bytes: &[u8], annot: &KotlinMetadataAnnotation) -> Result<KotlinClassMetadata> {
    // For MultiFileClassPart, d1 contains StringTableTypes followed by Package message
    // Similar to FileFacade but with facade reference
    let mut remaining = bytes;

    // First, read StringTableTypes
    let string_table_types = jvm_proto::StringTableTypes::decode_length_delimited(&mut remaining)
        .map_err(|e| anyhow!("Failed to decode StringTableTypes for MultiFileClassPart: {}", e))?;

    // Build string resolver
    let strings = build_string_resolver(&string_table_types, &annot.data2)?;

    // Parse Package message (same as FileFacade)
    let proto_pkg = proto::Package::decode(remaining)
        .map_err(|e| anyhow!("Failed to decode Package for MultiFileClassPart: {}", e))?;

    // Extract top-level functions
    let functions = proto_pkg
        .function
        .iter()
        .enumerate()
        .map(|(idx, f)| parse_function(f, &strings, idx as u32))
        .collect::<Result<Vec<_>>>()?;

    // Extract top-level properties
    let properties = proto_pkg
        .property
        .iter()
        .enumerate()
        .map(|(idx, p)| parse_property(p, &strings, idx as u32))
        .collect::<Result<Vec<_>>>()?;

    // The class name comes from xs field or package name
    let class_name = annot.extra_string.clone()
        .or_else(|| annot.package_name.clone())
        .unwrap_or_else(|| "MultiFileClassPart".to_string());

    tracing::debug!(
        "Parsed MultiFileClassPart: {} with {} functions, {} properties",
        class_name,
        functions.len(),
        properties.len()
    );

    Ok(KotlinClassMetadata {
        kind: KotlinKind::MultiFileClassPart,
        class_name,
        functions,
        properties,
        companion_object: None,
        is_data_class: false,
        flags: crate::types::KotlinClassFlags::default(),
        sealed_subclasses: vec![],
        type_parameters: vec![],
    })
}

/// Parse a type parameter from proto
fn parse_type_parameter(tp: &proto::TypeParameter, strings: &[String]) -> Result<KotlinTypeParameter> {
    let name = strings
        .get(tp.name as usize)
        .ok_or_else(|| anyhow!("Invalid type parameter name index"))?
        .clone();

    // Extract variance - proto enum: IN=0, OUT=1, INV=2
    let variance = tp.variance
        .map(|v| KotlinVariance::from_proto(v as i32))
        .unwrap_or(KotlinVariance::Invariant);

    // Extract upper bounds (simplified - we just get the bound names)
    // In full implementation, we'd parse the Type message recursively
    let upper_bounds = tp.upper_bound_id
        .iter()
        .filter_map(|&idx| strings.get(idx as usize).cloned())
        .collect();

    Ok(KotlinTypeParameter {
        name,
        variance,
        reified: tp.reified.unwrap_or(false),
        upper_bounds,
    })
}

/// Map Kotlin stdlib types to their Java equivalents for type bounds
static KOTLIN_TO_JAVA_TYPES: &[(&str, &str)] = &[
    ("kotlin/Any", "java/lang/Object"),
    ("kotlin/String", "java/lang/String"),
    ("kotlin/CharSequence", "java/lang/CharSequence"),
    ("kotlin/Number", "java/lang/Number"),
    ("kotlin/Int", "java/lang/Integer"),
    ("kotlin/Long", "java/lang/Long"),
    ("kotlin/Float", "java/lang/Float"),
    ("kotlin/Double", "java/lang/Double"),
    ("kotlin/Boolean", "java/lang/Boolean"),
    ("kotlin/Byte", "java/lang/Byte"),
    ("kotlin/Short", "java/lang/Short"),
    ("kotlin/Char", "java/lang/Character"),
    ("kotlin/collections/List", "java/util/List"),
    ("kotlin/collections/Set", "java/util/Set"),
    ("kotlin/collections/Map", "java/util/Map"),
    ("kotlin/collections/Collection", "java/util/Collection"),
    ("kotlin/collections/Iterable", "java/lang/Iterable"),
    ("kotlin/collections/Iterator", "java/util/Iterator"),
    ("kotlin/collections/MutableList", "java/util/List"),
    ("kotlin/collections/MutableSet", "java/util/Set"),
    ("kotlin/collections/MutableMap", "java/util/Map"),
    ("kotlin/collections/MutableCollection", "java/util/Collection"),
    ("kotlin/Comparable", "java/lang/Comparable"),
    ("kotlin/Throwable", "java/lang/Throwable"),
    ("kotlin/Exception", "java/lang/Exception"),
    ("kotlin/Error", "java/lang/Error"),
    ("kotlin/Enum", "java/lang/Enum"),
    ("kotlin/Annotation", "java/lang/annotation/Annotation"),
];

/// Parse a Kotlin type name string into an ArgType
/// Handles: kotlin/Any, kotlin/Comparable<T>, T, arrays
pub fn parse_kotlin_type_name(type_name: &str) -> dexterity_ir::ArgType {
    use dexterity_ir::ArgType;

    let type_name = type_name.trim();
    if type_name.is_empty() {
        return ArgType::Object("java/lang/Object".to_string());
    }

    // 1. Check for exact Kotlin → Java type mappings
    for (kotlin, java) in KOTLIN_TO_JAVA_TYPES.iter() {
        if type_name == *kotlin {
            return ArgType::Object((*java).to_string());
        }
    }

    // 2. Handle parameterized types (contains '<')
    if let Some(open_idx) = type_name.find('<') {
        let base = &type_name[..open_idx];
        let close_idx = type_name.rfind('>').unwrap_or(type_name.len());
        let params_str = &type_name[open_idx + 1..close_idx];

        // Map base type
        let base_mapped = KOTLIN_TO_JAVA_TYPES.iter()
            .find(|(k, _)| *k == base)
            .map(|(_, j)| (*j).to_string())
            .unwrap_or_else(|| base.to_string());

        // Parse parameters - handle nested generics by tracking depth
        let params: Vec<ArgType> = split_type_params(params_str)
            .iter()
            .map(|s| parse_kotlin_type_name(s))
            .collect();

        return ArgType::Generic {
            base: base_mapped,
            params,
        };
    }

    // 3. Type variable (simple name without '/')
    if !type_name.contains('/') && !type_name.starts_with('[') {
        return ArgType::type_var(type_name);
    }

    // 4. Handle array types (starts with '[')
    if type_name.starts_with('[') {
        let element = parse_kotlin_type_name(&type_name[1..]);
        return ArgType::Array(Box::new(element));
    }

    // 5. Fallback: treat as Object type
    ArgType::Object(type_name.to_string())
}

/// Split type parameters respecting nested generics
/// e.g., "String, List<Int>" -> ["String", "List<Int>"]
fn split_type_params(params: &str) -> Vec<&str> {
    let mut result = Vec::new();
    let mut depth = 0;
    let mut start = 0;

    for (i, c) in params.char_indices() {
        match c {
            '<' => depth += 1,
            '>' => depth -= 1,
            ',' if depth == 0 => {
                let param = params[start..i].trim();
                if !param.is_empty() {
                    result.push(param);
                }
                start = i + 1;
            }
            _ => {}
        }
    }

    // Add the last parameter
    let last = params[start..].trim();
    if !last.is_empty() {
        result.push(last);
    }

    result
}

/// Build JVM method signature string from proto JvmMethodSignature
/// JADX Reference: KmExt.kt:8 - inline val KmFunction.shortId: String? get() = signature?.toString()
/// Format: "methodName(Ljava/lang/String;)V"
fn build_jvm_method_signature(
    sig: &crate::jvm_proto::JvmMethodSignature,
    strings: &[String],
) -> Option<String> {
    let name_idx = sig.name? as usize;
    let desc_idx = sig.desc? as usize;

    let name = strings.get(name_idx)?;
    let desc = strings.get(desc_idx)?;

    // JADX format: "name(params)return" e.g., "methodName(Ljava/lang/String;)V"
    Some(format!("{}{}", name, desc))
}

/// Build JVM field signature string from proto JvmFieldSignature
/// JADX Reference: KmExt.kt:9 - inline val KmProperty.shortId: String? get() = fieldSignature?.toString()
/// Format: "fieldName:Ljava/lang/String;"
fn build_jvm_field_signature(
    sig: &crate::jvm_proto::JvmFieldSignature,
    strings: &[String],
) -> Option<String> {
    let name_idx = sig.name? as usize;
    let desc_idx = sig.desc? as usize;

    let name = strings.get(name_idx)?;
    let desc = strings.get(desc_idx)?;

    // JADX format: "name:type" e.g., "myField:Ljava/lang/String;"
    Some(format!("{}:{}", name, desc))
}

fn parse_function(func: &proto::Function, strings: &[String], _idx: u32) -> Result<KotlinFunction> {
    let name = strings
        .get(func.name as usize)
        .ok_or_else(|| anyhow!("Invalid function name index"))?
        .clone();

    // Parse function flags
    let raw_flags = func.flags.unwrap_or(6); // default: public final function
    let flags = parse_function_flags(raw_flags);

    // Extract parameter names with their flags
    let mut parameters = Vec::new();
    for (idx, param) in func.value_parameter.iter().enumerate() {
        let param_name = strings
            .get(param.name as usize)
            .ok_or_else(|| anyhow!("Invalid parameter name index"))?
            .clone();
        let param_flags = param.flags.unwrap_or(0);
        parameters.push(KotlinParameter {
            name: param_name,
            index: idx,
            is_crossinline: param_flags & PARAM_FLAG_IS_CROSSINLINE != 0,
            is_noinline: param_flags & PARAM_FLAG_IS_NOINLINE != 0,
        });
    }

    // Build JVM signature for matching with MethodData
    // JADX Reference: KmExt.kt:8 - uses signature?.toString() for exact JVM signature
    // This is the CRITICAL fix for P0.1 - proper JVM signature extraction
    let jvm_signature = func.method_signature
        .as_ref()
        .and_then(|sig| build_jvm_method_signature(sig, strings))
        .unwrap_or_else(|| {
            // Fallback to simplified signature if JVM extension not present
            // This happens with older Kotlin metadata versions
            tracing::trace!("No JVM method signature for {}, using fallback", name);
            format!("{}()", name)
        });

    Ok(KotlinFunction {
        name,
        jvm_signature,
        parameters,
        flags,
        receiver_type: None,
    })
}

fn parse_property(prop: &proto::Property, strings: &[String], _idx: u32) -> Result<KotlinProperty> {
    let name = strings
        .get(prop.name as usize)
        .ok_or_else(|| anyhow!("Invalid property name index"))?
        .clone();

    // Parse property flags
    let raw_flags = prop.flags.unwrap_or(518); // default: public final property with getter
    let flags = parse_property_flags(raw_flags);

    // Check if property has getter/setter from flags
    let has_getter = raw_flags & PROP_FLAG_HAS_GETTER != 0;
    let has_setter = raw_flags & PROP_FLAG_HAS_SETTER != 0;

    // Extract JVM signatures from property_signature extension
    // JADX Reference: KmExt.kt:9 - uses fieldSignature, getterSignature, setterSignature
    // This is the CRITICAL fix for P0.1 - proper JVM signature extraction

    let (jvm_field_signature, getter_signature, setter_signature) = prop.property_signature
        .as_ref()
        .map(|sig| {
            // Extract field signature
            // For unobfuscated code, the Kotlin compiler often omits the field signature
            // (field message is present but empty). In this case, we fall back to the property name.
            let field_sig = sig.field.as_ref()
                .and_then(|f| build_jvm_field_signature(f, strings))
                .unwrap_or_else(|| name.clone());

            // Extract getter signature
            let getter_sig = sig.getter.as_ref()
                .and_then(|g| build_jvm_method_signature(g, strings));

            // Extract setter signature
            let setter_sig = sig.setter.as_ref()
                .and_then(|s| build_jvm_method_signature(s, strings));

            (field_sig, getter_sig, setter_sig)
        })
        .unwrap_or_else(|| {
            // Fallback to simplified signatures if JVM extension not present
            tracing::trace!("No JVM property signature for {}, using fallback", name);
            let field_sig = name.clone();
            let getter_sig = if has_getter {
                Some(format!("get{}()V", capitalize_first(&name)))
            } else {
                None
            };
            let setter_sig = if has_setter {
                Some(format!("set{}()V", capitalize_first(&name)))
            } else {
                None
            };
            (field_sig, getter_sig, setter_sig)
        });

    Ok(KotlinProperty {
        name: name.clone(),
        jvm_field_signature,
        getter_signature,
        setter_signature,
        flags,
    })
}

/// Capitalize the first character of a string (for getter/setter name generation)
fn capitalize_first(s: &str) -> String {
    let mut chars = s.chars();
    match chars.next() {
        None => String::new(),
        Some(c) => c.to_uppercase().chain(chars).collect(),
    }
}

/// Fallback parser using d2 array (toString format)
pub fn parse_d2_fallback(annot: &KotlinMetadataAnnotation, _cls: &mut dexterity_ir::ClassData) -> Result<()> {
    // d2 contains human-readable strings from toString()
    // This is a very limited fallback when protobuf parsing fails
    // Format varies but typically contains class name and field/method names
    if annot.data2.is_empty() {
        return Err(anyhow!("d2 field is empty"));
    }

    // For now, just verify d2 exists and is parseable
    // Full d2 parsing would require analyzing toString() output format
    tracing::debug!("Using d2 fallback with {} entries", annot.data2.len());
    Ok(())
}
