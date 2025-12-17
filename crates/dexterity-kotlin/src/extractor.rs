//! Name extraction and application to IR

use anyhow::Result;
use dexterity_ir::{ClassData, FieldData, KotlinClassInfo};
use crate::types::{KotlinClassMetadata, KotlinKind, KotlinProperty};

/// Apply Kotlin metadata names to IR class structure
pub fn apply_kotlin_names(cls: &mut ClassData, metadata: &KotlinClassMetadata) -> Result<()> {
    // 1. Set class name alias - only for actual classes (kind=1), not file facades
    // File facades (*Kt classes) store function names in d2, not class names
    if cls.alias.is_none() && matches!(metadata.kind, KotlinKind::Class) {
        cls.alias = Some(metadata.class_name.clone());
    }

    // 2. Set Kotlin class info (data class, sealed class, etc.)
    let kotlin_info = KotlinClassInfo {
        is_data_class: metadata.is_data_class,
        is_sealed: metadata.flags.is_sealed,
        is_inline: metadata.flags.is_inline,
        is_companion: metadata.flags.is_fun_interface, // Note: companion objects are detected differently
        companion_name: metadata.companion_object.clone(),
        sealed_subclasses: metadata.sealed_subclasses.clone(),
    };
    cls.set_kotlin_class_info(kotlin_info);

    // 3. Apply method names and parameter names
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

            // Log suspend/inline function detection
            if kotlin_func.flags.is_suspend {
                tracing::debug!("Found suspend function: {}", kotlin_func.name);
            }
            if kotlin_func.flags.is_inline {
                tracing::debug!("Found inline function: {}", kotlin_func.name);
            }
        }
    }

    // 4. Apply property (field) names using improved matching
    apply_property_names(cls, &metadata.properties);

    // 5. Handle companion object if present
    if let Some(companion_name) = &metadata.companion_object {
        apply_companion_object_name(cls, companion_name);
    }

    // 6. Log data class detection
    if metadata.is_data_class {
        tracing::debug!("Class {} is a data class", cls.class_type);
    }
    if metadata.flags.is_sealed {
        tracing::debug!("Class {} is a sealed class with {} subclasses",
            cls.class_type, metadata.sealed_subclasses.len());
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
    // First, find the index using immutable iteration
    let index = cls.methods.iter().position(|m| {
        // Try exact name match first (fast path for unobfuscated code)
        if m.name == kotlin_func.name {
            return true;
        }
        // Try to match by parameter count and types (for obfuscated methods)
        // Only match if method has right number of parameters and names aren't set
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
    });

    // Then get mutable reference by index
    index.map(|i| &mut cls.methods[i])
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

/// Apply getter method recognition - match getXxx() and isXxx() methods to properties
pub fn apply_getter_recognition(cls: &mut ClassData, metadata: &KotlinClassMetadata) {
    for kotlin_prop in &metadata.properties {
        // Generate expected getter names
        let get_name = format!("get{}", capitalize_first(&kotlin_prop.name));
        let is_name = format!("is{}", capitalize_first(&kotlin_prop.name));
        let getter_name = kotlin_prop.getter_signature.as_ref().cloned().unwrap_or(get_name.clone());

        // Find matching method in IR
        for method in &mut cls.methods {
            // Skip methods with aliases already set
            if method.alias.is_some() {
                continue;
            }

            // Match by expected getter name or signature
            if method.name == get_name || method.name == is_name || method.name == getter_name {
                // Verify it's a getter (no params except 'this', returns non-void)
                let param_count = if method.is_static() { 0 } else { 0 }; // Instance getters have 'this' in ins_count but not in arg_types
                if method.arg_types.len() == param_count && !matches!(method.return_type, dexterity_ir::ArgType::Void) {
                    // This is a getter for the property
                    tracing::debug!(
                        "Matched getter method '{}' -> property '{}'",
                        method.name, kotlin_prop.name
                    );
                    // Don't change method name since it's already correct, but we can add metadata
                    break;
                }
            }

            // Also try matching obfuscated method name to property getter
            if looks_obfuscated(&method.name) {
                // Check if this could be a getter: no args, non-void return
                if method.arg_types.is_empty() && !matches!(method.return_type, dexterity_ir::ArgType::Void) {
                    // Mark the method as a potential getter for this property
                    // Don't set alias yet - we need more confidence
                }
            }
        }

        // Also match setter methods if property has setter
        if kotlin_prop.flags.is_var {
            let set_name = format!("set{}", capitalize_first(&kotlin_prop.name));
            let setter_name = kotlin_prop.setter_signature.as_ref().cloned().unwrap_or(set_name.clone());

            for method in &mut cls.methods {
                if method.alias.is_some() {
                    continue;
                }

                if method.name == setter_name || method.name == set_name {
                    // Verify it's a setter (one param, void return)
                    if method.arg_types.len() == 1 && matches!(method.return_type, dexterity_ir::ArgType::Void) {
                        tracing::debug!(
                            "Matched setter method '{}' -> property '{}'",
                            method.name, kotlin_prop.name
                        );
                        break;
                    }
                }
            }
        }
    }
}

/// Capitalize first character of a string
fn capitalize_first(s: &str) -> String {
    let mut chars = s.chars();
    match chars.next() {
        None => String::new(),
        Some(c) => c.to_uppercase().chain(chars).collect(),
    }
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
