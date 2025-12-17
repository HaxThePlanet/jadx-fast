//! Kotlin metadata annotation parsing

use anyhow::{anyhow, Result};
use base64::Engine;
use dexterity_ir::{Annotation, AnnotationValue};
use prost::Message;
use crate::types::{
    KotlinClassMetadata, KotlinKind, KotlinFunction, KotlinParameter, KotlinProperty,
    KotlinClassFlags, KotlinFunctionFlags, KotlinPropertyFlags,
};
use crate::proto;

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

/// Parse d1 protobuf field to extract Kotlin metadata
pub fn parse_d1_protobuf(annot: &KotlinMetadataAnnotation) -> Result<KotlinClassMetadata> {
    // d1 contains base64-encoded protobuf data
    if annot.data1.is_empty() {
        return Err(anyhow!("d1 field is empty"));
    }

    // Join d1 strings (can span multiple parts)
    let encoded = annot.data1.join("");

    // Decode base64
    let engine = base64::engine::general_purpose::STANDARD;
    let bytes = engine.decode(&encoded)?;

    // Parse based on kind
    match annot.kind {
        1 => parse_class_metadata(&bytes, annot),  // Class
        2 => parse_package_metadata(&bytes, annot), // Package (file facade)
        3 => parse_synthetic_class_metadata(&bytes, annot), // Synthetic class (lambdas)
        _ => Err(anyhow!("Unsupported Kotlin metadata kind: {}", annot.kind)),
    }
}

/// Parse Class metadata (kind = 1)
fn parse_class_metadata(bytes: &[u8], annot: &KotlinMetadataAnnotation) -> Result<KotlinClassMetadata> {
    let proto_class = proto::Class::decode(bytes)?;

    // Build string table from d2 or get empty one
    let strings = build_string_table(&proto_class, annot)?;

    // Extract class name
    let class_name = strings
        .get(proto_class.fq_name as usize)
        .ok_or_else(|| anyhow!("Invalid fq_name index: {}", proto_class.fq_name))?
        .clone();

    // Parse class flags
    let raw_flags = proto_class.flags.unwrap_or(6); // default: public final class
    let flags = parse_class_flags(raw_flags);
    let is_data_class = flags.is_data;

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

    Ok(KotlinClassMetadata {
        kind: KotlinKind::Class,
        class_name,
        functions,
        properties,
        companion_object,
        is_data_class,
        flags,
        sealed_subclasses,
    })
}

/// Parse Package (file facade) metadata (kind = 2)
fn parse_package_metadata(bytes: &[u8], annot: &KotlinMetadataAnnotation) -> Result<KotlinClassMetadata> {
    let proto_pkg = proto::Package::decode(bytes)?;

    // Build string table from d2
    let strings = build_string_table_from_d2(annot)?;

    // For packages, extract top-level functions
    let functions = proto_pkg
        .function
        .iter()
        .enumerate()
        .map(|(idx, f)| parse_function(f, &strings, idx as u32))
        .collect::<Result<Vec<_>>>()?;

    Ok(KotlinClassMetadata {
        kind: KotlinKind::FileFacade,
        class_name: annot.package_name.clone().unwrap_or_default(),
        functions,
        properties: vec![],
        companion_object: None,
        is_data_class: false,
        flags: crate::types::KotlinClassFlags::default(),
        sealed_subclasses: vec![],
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
    })
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
    // This is a simplified version; full signature matching will be done in extractor
    let jvm_signature = format!("{}()", name);

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

    // JVM field signature - simplified
    let jvm_field_signature = name.clone();

    // Check if property has getter/setter
    let has_getter = raw_flags & PROP_FLAG_HAS_GETTER != 0;
    let has_setter = raw_flags & PROP_FLAG_HAS_SETTER != 0;

    Ok(KotlinProperty {
        name: name.clone(),
        jvm_field_signature,
        getter_signature: if has_getter { Some(format!("get{}", capitalize_first(&name))) } else { None },
        setter_signature: if has_setter { Some(format!("set{}", capitalize_first(&name))) } else { None },
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

fn build_string_table(_proto_class: &proto::Class, annot: &KotlinMetadataAnnotation) -> Result<Vec<String>> {
    // Use d2 array (fallback human-readable names from toString)
    // The actual string table in protobuf is typically empty or minimal
    // d2 contains the human-readable representation
    if !annot.data2.is_empty() {
        return Ok(annot.data2.clone());
    }

    Err(anyhow!("No string table (d2) found in metadata"))
}

fn build_string_table_from_d2(annot: &KotlinMetadataAnnotation) -> Result<Vec<String>> {
    if annot.data2.is_empty() {
        return Err(anyhow!("d2 field is empty"));
    }
    Ok(annot.data2.clone())
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
