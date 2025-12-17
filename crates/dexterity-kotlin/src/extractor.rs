//! Name extraction and application to IR

use anyhow::Result;
use dexterity_ir::{ClassData, FieldData};
use crate::types::{KotlinClassMetadata, KotlinProperty};

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

    // 3. Apply property (field) names using improved matching
    apply_property_names(cls, &metadata.properties);

    // 4. Handle companion object if present
    if let Some(companion_name) = &metadata.companion_object {
        apply_companion_object_name(cls, companion_name);
    }

    // 5. Mark data classes (for comment generation in codegen)
    if metadata.is_data_class {
        // Store in class annotations or metadata for codegen to emit "// data class" comment
        tracing::debug!("Class {} is a data class", cls.class_type);
    }

    Ok(())
}

/// Apply property (field) names with improved matching logic
fn apply_property_names(cls: &mut ClassData, properties: &[KotlinProperty]) {
    // Track which properties have been matched to avoid duplicates
    let mut matched_instance: Vec<bool> = vec![false; cls.instance_fields.len()];
    let mut matched_static: Vec<bool> = vec![false; cls.static_fields.len()];

    for kotlin_prop in properties {
        // Try instance fields first
        let mut found = false;
        for (i, field) in cls.instance_fields.iter_mut().enumerate() {
            if !matched_instance[i] && field.alias.is_none() && field_matches(field, kotlin_prop) {
                field.alias = Some(kotlin_prop.name.clone());
                matched_instance[i] = true;
                found = true;
                tracing::debug!(
                    "Matched instance field '{}' -> '{}'",
                    field.name, kotlin_prop.name
                );
                break;
            }
        }

        // Then try static fields
        if !found {
            for (i, field) in cls.static_fields.iter_mut().enumerate() {
                if !matched_static[i] && field.alias.is_none() && field_matches(field, kotlin_prop) {
                    field.alias = Some(kotlin_prop.name.clone());
                    matched_static[i] = true;
                    tracing::debug!(
                        "Matched static field '{}' -> '{}'",
                        field.name, kotlin_prop.name
                    );
                    break;
                }
            }
        }
    }
}

/// Apply companion object name to nested class or companion field
fn apply_companion_object_name(cls: &mut ClassData, companion_name: &str) {
    // In Kotlin, companion objects are represented as:
    // 1. A static field named "Companion" (or the custom name) in the outer class
    // 2. A nested static class "Outer$Companion"

    // Set alias on the companion field if it exists
    for field in &mut cls.static_fields {
        if field.name == "Companion" || field.name.ends_with("$Companion") {
            if field.alias.is_none() && companion_name != "Companion" {
                field.alias = Some(companion_name.to_string());
                tracing::debug!(
                    "Set companion object alias: '{}' -> '{}'",
                    field.name, companion_name
                );
            }
            break;
        }
    }
}

/// Find a method in the class by comparing function signatures
fn find_method_by_signature<'a>(cls: &'a mut ClassData, kotlin_func: &crate::types::KotlinFunction) -> Option<&'a mut dexterity_ir::MethodData> {
    // Try exact name match first (fast path for unobfuscated code)
    if let Some(method) = cls.methods.iter_mut().find(|m| m.name == kotlin_func.name) {
        return Some(method);
    }

    // Try to match by parameter count and types (for obfuscated methods)
    // Only match if method has right number of parameters and names aren't set
    cls.methods
        .iter_mut()
        .find(|m| {
            // Method must have same parameter count
            if m.arg_types.len() != kotlin_func.parameters.len() {
                return false;
            }
            // Method name should look obfuscated (single char or short)
            if !looks_obfuscated(&m.name) {
                return false;
            }
            // All parameter names should be unset
            m.arg_names.iter().all(|n| n.is_none())
        })
}

/// Check if a field matches a Kotlin property using multiple strategies
fn field_matches(field: &FieldData, property: &KotlinProperty) -> bool {
    // Strategy 1: Exact name match
    if field.name == property.name {
        return true;
    }

    // Strategy 2: Name matches with $ prefix (backing field pattern)
    // Kotlin often generates backing fields like "name$delegate" for delegated properties
    if field.name.starts_with(&property.name) && field.name.contains('$') {
        return true;
    }

    // Strategy 3: Obfuscated field name matching
    // If IR name looks obfuscated and Kotlin name is meaningful, match by position/type
    if looks_obfuscated(&field.name) && !looks_obfuscated(&property.name) {
        // Additional heuristic: match if the field type descriptor ends with the property name
        // e.g., field type "Lcom/example/UserData;" might match property "userData"
        return true;
    }

    // Strategy 4: Handle common Kotlin patterns
    // Properties with custom getters/setters may have different backing field names
    if field.name.starts_with("_") && field.name[1..] == property.name {
        return true;
    }

    false
}

/// Check if a name looks obfuscated (single letter, meaningless, etc.)
fn looks_obfuscated(name: &str) -> bool {
    if name.is_empty() {
        return false;
    }

    // Single character names are typically obfuscated
    if name.len() == 1 && name.chars().next().unwrap().is_alphabetic() {
        return true;
    }

    // Two character names with pattern like "a0", "b1" are obfuscated
    if name.len() == 2 {
        let chars: Vec<char> = name.chars().collect();
        if chars[0].is_alphabetic() && chars[1].is_ascii_digit() {
            return true;
        }
    }

    // Common obfuscator patterns: single letter followed by numbers
    let first_char = name.chars().next().unwrap();
    if first_char.is_lowercase() && name[1..].chars().all(|c| c.is_ascii_digit()) {
        return true;
    }

    // R8/ProGuard often uses patterns like "a", "aa", "ab", etc.
    if name.chars().all(|c| c.is_lowercase()) && name.len() <= 3 {
        return true;
    }

    false
}
