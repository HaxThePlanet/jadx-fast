//! Kotlin metadata parsing and processing for jadx-rust
//!
//! This crate provides support for parsing `@kotlin.Metadata` annotations
//! to extract original Kotlin names (classes, fields, methods, parameters)
//! for superior decompilation quality matching Java JADX output.

pub mod parser;
pub mod extractor;
pub mod types;
pub mod visitor;

// Re-exports
pub use visitor::KotlinAwareCondition;

// Re-export generated protobuf types
pub mod proto {
    include!(concat!(env!("OUT_DIR"), "/org.jetbrains.kotlin.metadata.rs"));
}

use anyhow::Result;
use jadx_ir::ClassData;

/// Process Kotlin metadata for a class, extracting and applying names
pub fn process_kotlin_metadata(cls: &mut ClassData) -> Result<()> {
    // Find @kotlin.Metadata annotation
    let metadata_annot = match parser::find_kotlin_metadata(&cls.annotations) {
        Some(a) => a,
        None => return Ok(()), // Not Kotlin code, skip silently
    };

    // Parse the annotation into structured form
    let kotlin_meta_annot = parser::parse_kotlin_metadata_annotation(metadata_annot)?;

    // Attempt to parse protobuf (d1 field)
    let kotlin_metadata = match parser::parse_d1_protobuf(&kotlin_meta_annot) {
        Ok(meta) => meta,
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

    Ok(())
}

#[cfg(test)]
mod tests {
    #[test]
    fn test_find_kotlin_metadata() {
        // Tested in parser module
    }
}
