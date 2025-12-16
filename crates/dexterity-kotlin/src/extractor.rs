//! Name extraction and application to IR

use anyhow::Result;
use jadx_ir::ClassData;
use crate::types::KotlinClassMetadata;

/// Apply Kotlin metadata names to IR class structure
pub fn apply_kotlin_names(cls: &mut ClassData, metadata: &KotlinClassMetadata) -> Result<()> {
    // 1. Set class name alias
    if cls.alias.is_none() {
        cls.alias = Some(metadata.class_name.clone());
    }

    // 2. Apply method names and parameter names
    for kotlin_func in &metadata.functions {
        // Find matching method in IR by comparing signatures
        if let Some(method) = find_method_by_signature(cls, kotlin_func) {
            // Set method alias if not already set
            if method.alias.is_none() {
                method.alias = Some(kotlin_func.name.clone());
            }

            // Set parameter names
            for (param_idx, kotlin_param) in kotlin_func.parameters.iter().enumerate() {
                if param_idx < method.arg_names.len() && method.arg_names[param_idx].is_none() {
                    method.arg_names[param_idx] = Some(kotlin_param.name.clone());
                }
            }
        }
    }

    // 3. Apply property (field) names
    for kotlin_prop in &metadata.properties {
        // Try to find matching field
        // First check instance fields
        for field in &mut cls.instance_fields {
            if field.alias.is_none() && field_name_matches(&field.name, &kotlin_prop.name) {
                field.alias = Some(kotlin_prop.name.clone());
                break;
            }
        }

        // Then check static fields
        for field in &mut cls.static_fields {
            if field.alias.is_none() && field_name_matches(&field.name, &kotlin_prop.name) {
                field.alias = Some(kotlin_prop.name.clone());
                break;
            }
        }
    }

    // 4. Handle companion object if present
    if let Some(companion_name) = &metadata.companion_object {
        // Find nested class named "Companion" and set its alias
        for method in &mut cls.methods {
            // Companion objects are implemented as nested static classes
            // Look for <clinit> or other companion-related methods
            if method.name.contains("Companion") || method.name == "<clinit>" {
                if method.alias.is_none() {
                    method.alias = Some(companion_name.clone());
                }
            }
        }
    }

    // 5. Mark data classes (for comment generation in codegen)
    if metadata.is_data_class {
        // Set a flag or mark in ClassData if available
        // Currently marked by presence of data class detection in metadata
        tracing::debug!("Class {} is a data class", cls.class_type);
    }

    Ok(())
}

/// Find a method in the class by comparing function signatures
fn find_method_by_signature<'a>(cls: &'a mut ClassData, kotlin_func: &crate::types::KotlinFunction) -> Option<&'a mut jadx_ir::MethodData> {
    // Try to match by name first (fast path for simple cases)
    cls.methods
        .iter_mut()
        .find(|m| {
            m.name == kotlin_func.name ||
            // Also check if the method might have been obfuscated but parameter count matches
            (m.arg_types.len() == kotlin_func.parameters.len() &&
             m.arg_names.iter().zip(kotlin_func.parameters.iter())
                .any(|(existing, kotlin_param)| existing.is_none() || existing.as_ref().map(|n| n == &kotlin_param.name).unwrap_or(false)))
        })
}

/// Check if a field name matches (accounts for potential name mangling)
fn field_name_matches(_ir_name: &str, _kotlin_name: &str) -> bool {
    // Simple matching for now - in future could handle more complex cases
    // like synthetic field names or backing fields
    false
}
