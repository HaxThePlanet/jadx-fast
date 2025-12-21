//! Kotlin metadata parsing and processing for dexterity
//!
//! This crate provides support for parsing `@kotlin.Metadata` annotations
//! to extract original Kotlin names (classes, fields, methods, parameters)
//! for superior decompilation quality matching Java JADX output.

pub mod parser;
pub mod extractor;
pub mod types;
pub mod visitor;
pub mod tostring_parser;

// Re-exports
pub use visitor::KotlinAwareCondition;
pub use extractor::{apply_getter_recognition, apply_tostring_names};
pub use tostring_parser::TypeResolver;
pub use types::{KotlinClassMetadata, KotlinFunction, KotlinProperty, KotlinClassFlags, KotlinFunctionFlags, KotlinPropertyFlags, KotlinTypeParameter, KotlinVariance};

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
use dexterity_ir::ClassData;
use dexterity_ir::kotlin_metadata::get_class_alias;

/// Process Kotlin metadata for a class, extracting and applying names
///
/// If `dex` is provided, also applies toString() bytecode analysis as a fallback
/// for extracting field names when protobuf metadata is unavailable.
pub fn process_kotlin_metadata(cls: &mut ClassData, dex: Option<&DexReader>) -> Result<()> {

    // Attempt to extract class alias from Kotlin metadata (d2 array)
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

    // Apply getter/setter recognition
    extractor::apply_getter_recognition(cls, &kotlin_metadata);

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
