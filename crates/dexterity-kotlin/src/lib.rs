//! Kotlin metadata parsing and processing for dexterity
//!
//! This crate provides support for parsing `@kotlin.Metadata` annotations
//! to extract original Kotlin names (classes, fields, methods, parameters)
//! for superior decompilation quality matching Java JADX output.
//!
//! Also supports `@kotlin.jvm.internal.SourceDebugExtension` (SMAP) for:
//! - Multifile classes (multiple .kt files compiled into one class)
//! - Inline functions (inlined code maps back to original function)
//! - Lambda source mapping

pub mod parser;
pub mod extractor;
pub mod types;
pub mod visitor;
pub mod tostring_parser;
pub mod smap_types;
pub mod smap_parser;

// Re-exports
pub use visitor::KotlinAwareCondition;
pub use extractor::{
    apply_getter_recognition, apply_tostring_names,
    find_getters_jadx_style, find_default_methods_jadx_style,
    analyze_companion_for_hiding, rename_companion_jadx_style,
    CompanionAnalysis,
};
pub use tostring_parser::TypeResolver;
pub use types::{KotlinClassMetadata, KotlinFunction, KotlinProperty, KotlinClassFlags, KotlinFunctionFlags, KotlinPropertyFlags, KotlinTypeParameter, KotlinVariance};
pub use smap_types::{SMAP, FileMapping, RangeMapping, SourcePosition, ClassAliasRename};
pub use smap_parser::parse_or_null as parse_smap;

// Re-export generated protobuf types
pub mod proto {
    include!(concat!(env!("OUT_DIR"), "/org.jetbrains.kotlin.metadata.rs"));
}

// JVM-specific Kotlin metadata protobuf types
pub mod jvm_proto {
    include!(concat!(env!("OUT_DIR"), "/org.jetbrains.kotlin.metadata.jvm.rs"));
}

use anyhow::Result;
use dexterity_dex::DexReader;
use dexterity_ir::{ClassData, Annotation, AnnotationValue};
use dexterity_ir::kotlin_metadata::get_class_alias;

/// SourceDebugExtension annotation type
/// JADX Reference: jadx-plugins/jadx-kotlin-source-debug-extension/src/main/kotlin/jadx/plugins/kotlin/smap/model/Constants.kt
const SOURCE_DEBUG_EXTENSION_ANNOTATION: &str = "kotlin/jvm/internal/SourceDebugExtension";

/// Find @kotlin.jvm.internal.SourceDebugExtension annotation
/// JADX Reference: jadx-plugins/jadx-kotlin-source-debug-extension/src/main/kotlin/jadx/plugins/kotlin/smap/utils/Extensions.kt:13-19
fn find_source_debug_extension(annotations: &[Annotation]) -> Option<&Annotation> {
    annotations.iter().find(|a| {
        a.annotation_type == SOURCE_DEBUG_EXTENSION_ANNOTATION
            || a.annotation_type.ends_with("/SourceDebugExtension")
            || a.annotation_type == "Lkotlin/jvm/internal/SourceDebugExtension;"
    })
}

/// Extract SMAP value from SourceDebugExtension annotation
/// JADX Reference: jadx-plugins/jadx-kotlin-source-debug-extension/src/main/kotlin/jadx/plugins/kotlin/smap/utils/Extensions.kt:15-17
fn get_smap_from_annotation(annot: &Annotation) -> Option<String> {
    // The annotation has a "value" element which is an array of strings
    for elem in &annot.elements {
        if elem.name == "value" {
            match &elem.value {
                AnnotationValue::Array(arr) => {
                    // Concatenate all strings in the array
                    let parts: Vec<String> = arr.iter()
                        .filter_map(|v| match v {
                            AnnotationValue::String(s) => Some(s.clone()),
                            _ => None,
                        })
                        .collect();
                    if !parts.is_empty() {
                        return Some(parts.join(""));
                    }
                }
                AnnotationValue::String(s) => {
                    return Some(s.clone());
                }
                _ => {}
            }
        }
    }
    None
}

/// Get class alias from SMAP (SourceDebugExtension)
/// JADX Reference: jadx-plugins/jadx-kotlin-source-debug-extension/src/main/kotlin/jadx/plugins/kotlin/smap/utils/KotlinSmapUtils.kt:17-39
fn get_class_alias_from_smap(smap: &smap_types::SMAP, cls: &ClassData) -> Option<smap_types::ClassAliasRename> {
    let first_file = smap.first_file()?;

    // Get the path and convert "/" to "."
    // JADX Reference: KotlinSmapUtils.kt:24
    let full_cls_name = first_file.path.replace('/', ".");

    // Trim and clean the name
    let full_cls_name = full_cls_name.trim();
    if full_cls_name.is_empty() {
        return None;
    }

    // Clean object name (remove L prefix and ; suffix if present)
    let full_cls_name = if full_cls_name.starts_with('L') && full_cls_name.ends_with(';') {
        &full_cls_name[1..full_cls_name.len() - 1]
    } else {
        full_cls_name
    };

    // Remove .kt extension if present
    let full_cls_name = full_cls_name.strip_suffix(".kt").unwrap_or(full_cls_name);

    // Split into package and name
    // JADX Reference: KotlinSmapUtils.kt:43-58
    let (pkg, name) = match full_cls_name.rfind('.') {
        Some(dot) => {
            (full_cls_name[..dot].to_string(), full_cls_name[dot + 1..].to_string())
        }
        None => {
            (String::new(), full_cls_name.to_string())
        }
    };

    // Validation checks
    // JADX Reference: KotlinSmapUtils.kt:59-63

    // Check if name is valid identifier
    if !is_valid_identifier(&name) {
        return None;
    }

    // Check if name contains $ (inner class marker)
    if name.contains('$') {
        return None;
    }

    // Check if package starts with "java."
    if pkg.starts_with("java.") {
        return None;
    }

    // Check if name matches original (no need to rename)
    let origin_name = cls.simple_name();
    if origin_name == name {
        return None;
    }

    // Check if package part count matches
    // JADX Reference: KotlinSmapUtils.kt:64
    let origin_pkg = cls.package().unwrap_or("");
    if count_pkg_parts(origin_pkg) != count_pkg_parts(&pkg) {
        return None;
    }

    Some(smap_types::ClassAliasRename::new(pkg, name))
}

/// Count package parts (number of segments separated by .)
/// JADX Reference: KotlinMetadataUtils.kt:77-90
fn count_pkg_parts(pkg: &str) -> usize {
    if pkg.is_empty() {
        return 0;
    }
    pkg.matches('.').count() + 1
}

/// Check if a string is a valid Java identifier
fn is_valid_identifier(name: &str) -> bool {
    if name.is_empty() {
        return false;
    }

    let mut chars = name.chars();
    if let Some(first) = chars.next() {
        // First character must be letter or underscore
        if !first.is_alphabetic() && first != '_' {
            return false;
        }
    }

    // Remaining characters must be alphanumeric or underscore
    chars.all(|c| c.is_alphanumeric() || c == '_')
}

/// Process Kotlin metadata for a class, extracting and applying names
///
/// If `dex` is provided, also applies toString() bytecode analysis as a fallback
/// for extracting field names when protobuf metadata is unavailable.
pub fn process_kotlin_metadata(cls: &mut ClassData, dex: Option<&DexReader>) -> Result<()> {

    // STEP 1: Try SourceDebugExtension (SMAP) first for class alias
    // This is higher priority than d2 array for multifile classes
    // JADX Reference: jadx-plugins/jadx-kotlin-source-debug-extension/src/main/kotlin/jadx/plugins/kotlin/smap/pass/KotlinSourceDebugExtensionPass.kt
    if cls.alias.is_none() {
        if let Some(sde_annot) = find_source_debug_extension(&cls.annotations) {
            if let Some(smap_str) = get_smap_from_annotation(sde_annot) {
                if let Some(smap) = smap_parser::parse_or_null(&smap_str) {
                    if let Some(alias_rename) = get_class_alias_from_smap(&smap, cls) {
                        tracing::debug!(
                            "SMAP extracted class alias for {}: {} (pkg: {})",
                            cls.class_type, alias_rename.name, alias_rename.pkg
                        );
                        cls.alias = Some(alias_rename.name);
                        if cls.pkg_alias.is_none() && !alias_rename.pkg.is_empty() {
                            cls.pkg_alias = Some(alias_rename.pkg);
                        }
                    }
                }
            }
        }
    }

    // STEP 2: Attempt to extract class alias from Kotlin metadata (d2 array)
    // This runs before protobuf parsing to ensure we have the correct class name
    // even if protobuf parsing fails or is incomplete.
    if let Some(alias_info) = get_class_alias(cls) {
        if cls.alias.is_none() {
            cls.alias = Some(alias_info.name);
        }
        if cls.pkg_alias.is_none() {
            cls.pkg_alias = Some(alias_info.pkg);
        }
    }

    // Find @kotlin.Metadata annotation
    let metadata_annot = match parser::find_kotlin_metadata(&cls.annotations) {
        Some(a) => {
            tracing::debug!("Found Kotlin metadata annotation in {}", cls.class_type);
            a
        }
        None => {
            // Not Kotlin code - log at debug level for debugging
            if !cls.annotations.is_empty() {
                tracing::debug!(
                    "No Kotlin metadata in {} (has {} annotations: {:?})",
                    cls.class_type,
                    cls.annotations.len(),
                    cls.annotations.iter().map(|a| &a.annotation_type).collect::<Vec<_>>()
                );
            }
            return Ok(());
        }
    };

    // Parse the annotation into structured form
    let kotlin_meta_annot = parser::parse_kotlin_metadata_annotation(metadata_annot)?;

    // Attempt to parse protobuf (d1 field)
    let kotlin_metadata = match parser::parse_d1_protobuf(&kotlin_meta_annot) {
        Ok(meta) => {
            tracing::debug!(
                "Parsed Kotlin metadata for {}: kind={:?}, is_data={}, functions={}",
                cls.class_type, meta.kind, meta.is_data_class, meta.functions.len()
            );
            meta
        }
        Err(e) => {
            tracing::debug!(
                "Failed to parse Kotlin metadata d1 for {}: {}",
                cls.class_type, e
            );
            // Fallback to d2 array
            match parser::parse_d2_fallback(&kotlin_meta_annot, cls) {
                Ok(_) => return Ok(()),
                Err(e) => {
                    tracing::debug!("Kotlin metadata d2 fallback also failed: {}", e);
                    return Ok(());
                }
            }
        }
    };

    // Extract and apply names to IR
    extractor::apply_kotlin_names(cls, &kotlin_metadata)?;

    // Apply getter/setter recognition (metadata-based)
    extractor::apply_getter_recognition(cls, &kotlin_metadata);

    // STEP 3: Apply JADX-style getter recognition (bytecode-based)
    // JADX Reference: KotlinUtils.kt:25-44
    // This uses exact instruction count and field matching like JADX
    extractor::find_getters_jadx_style(cls);

    // STEP 4: Apply JADX-style default method recognition
    // JADX Reference: KotlinUtils.kt:53-89
    // Renames synthetic $default methods to match original method alias
    extractor::find_default_methods_jadx_style(cls);

    // STEP 5: Apply JADX-style companion object renaming
    // JADX Reference: KotlinMetadataDecompilePass.kt:71-88
    // Renames companion field to "Companion" and detects empty companions for hiding
    extractor::rename_companion_jadx_style(cls, &kotlin_metadata);

    // Analyze companion for potential hiding
    // JADX Reference: KotlinMetadataUtils.kt:118-141
    if let Some(analysis) = extractor::analyze_companion_for_hiding(cls, &kotlin_metadata) {
        if analysis.should_hide {
            tracing::debug!(
                "Companion object '{}' in {} should be hidden",
                analysis.field_name, cls.class_type
            );
            // Note: To fully implement hiding, we would need to add DONT_GENERATE flags
            // to both the companion field and the companion inner class
        }
    }

    // Apply toString() bytecode analysis (fallback for obfuscated metadata)
    if let Some(dex_reader) = dex {
        extractor::apply_tostring_names(cls, dex_reader)?;
    }

    Ok(())
}

#[cfg(test)]
mod tests {
    #[test]
    fn test_find_kotlin_metadata() {
        // Tested in parser module
    }
}
