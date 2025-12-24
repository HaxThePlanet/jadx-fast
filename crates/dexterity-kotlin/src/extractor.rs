//! Name extraction and application to IR

use anyhow::Result;
use dexterity_dex::DexReader;
use dexterity_ir::{ClassData, FieldData, KotlinClassInfo, TypeParameter};
use dexterity_ir::instructions::InsnType;
use crate::types::{KotlinClassMetadata, KotlinKind, KotlinProperty};
use crate::tostring_parser::{self, TypeResolver};
use crate::KotlinProcessingOptions;

/// Apply Kotlin metadata names to IR class structure
pub fn apply_kotlin_names(cls: &mut ClassData, metadata: &KotlinClassMetadata) -> Result<()> {
    // 1. Set class name alias - only for actual classes (kind=1), not file facades
    // File facades (*Kt classes) store function names in d2, not class names
    // Extract simple name from Kotlin metadata (e.g., "com/foo/Bar" -> "Bar")
    if cls.alias.is_none() && matches!(metadata.kind, KotlinKind::Class) {
        let simple_name = metadata.class_name
            .rsplit('/')
            .next()
            .unwrap_or(&metadata.class_name);
        // For inner classes, get the part after $ (e.g., "Outer$Inner" -> "Inner")
        let simple_name = simple_name
            .rsplit('$')
            .next()
            .unwrap_or(simple_name);
        // Only set alias if it differs from the DEX simple name
        if simple_name != cls.simple_name() {
            cls.alias = Some(simple_name.to_string());
            // JADX Reference: RenameReasonAttr pattern
            cls.add_rename_reason("from kotlin metadata");
        }
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

    // 2.5. Apply type parameters with variance and bounds from Kotlin metadata
    // This overrides the Java signature parsing which doesn't have variance info
    if !metadata.type_parameters.is_empty() {
        use crate::parser::parse_kotlin_type_name;
        use dexterity_ir::ArgType;

        let type_params: Vec<TypeParameter> = metadata.type_parameters.iter().map(|ktp| {
            // Parse upper bounds from Kotlin type names to ArgType
            // Filter out implicit kotlin/Any -> java/lang/Object bounds (Java's default)
            let bounds: Vec<ArgType> = ktp.upper_bounds.iter()
                .map(|type_name| parse_kotlin_type_name(type_name))
                .filter(|t| !matches!(t, ArgType::Object(s) if s == "java/lang/Object"))
                .collect();

            TypeParameter {
                name: ktp.name.clone(),
                bounds,
                variance: ktp.variance.to_ir(),
                reified: ktp.reified,
            }
        }).collect();

        // Only update if we have type parameters from Kotlin metadata
        if !type_params.is_empty() {
            // Merge variance and bounds info into existing type parameters
            for (i, ktp) in type_params.iter().enumerate() {
                if i < cls.type_parameters.len() {
                    // If Kotlin has bounds, use them (more accurate than Java signatures)
                    if !ktp.bounds.is_empty() {
                        cls.type_parameters[i].bounds = ktp.bounds.clone();
                    }
                    // Otherwise keep Java signature bounds

                    // Always apply Kotlin-specific attributes
                    cls.type_parameters[i].variance = ktp.variance;
                    cls.type_parameters[i].reified = ktp.reified;

                    tracing::trace!(
                        "Applied Kotlin variance {:?} and {} bounds to type param {} in class {}",
                        ktp.variance, ktp.bounds.len(), cls.type_parameters[i].name, cls.class_type
                    );
                } else {
                    // New type parameter from Kotlin
                    cls.type_parameters.push(ktp.clone());
                }
            }
        }
    }

    // 3. Apply method names and parameter names
    for kotlin_func in &metadata.functions {
        // Find matching method in IR by comparing signatures
        if let Some(method) = find_method_by_signature(cls, kotlin_func) {
            // Set method alias if not already set
            if method.alias.is_none() {
                method.alias = Some(kotlin_func.name.clone());
                // JADX Reference: RenameReasonAttr pattern
                method.add_rename_reason("from kotlin metadata");
            }

            // Set parameter names
            for (param_idx, kotlin_param) in kotlin_func.parameters.iter().enumerate() {
                if param_idx < method.arg_names.len() && method.arg_names[param_idx].is_none() {
                    method.arg_names[param_idx] = Some(kotlin_param.name.clone());
                }
            }

            // Apply Kotlin function modifiers to IR
            if kotlin_func.flags.is_suspend {
                method.is_suspend = true;
                tracing::debug!("Applied suspend modifier to: {}", kotlin_func.name);
            }
            if kotlin_func.flags.is_inline {
                method.is_inline_function = true;
                tracing::debug!("Applied inline modifier to: {}", kotlin_func.name);
            }
            if kotlin_func.flags.is_infix {
                method.is_infix = true;
                tracing::debug!("Applied infix modifier to: {}", kotlin_func.name);
            }
            if kotlin_func.flags.is_operator {
                method.is_operator = true;
                tracing::debug!("Applied operator modifier to: {}", kotlin_func.name);
            }
            if kotlin_func.flags.is_tailrec {
                method.is_tailrec = true;
                tracing::debug!("Applied tailrec modifier to: {}", kotlin_func.name);
            }

            // Apply extension function receiver type
            if let Some(ref receiver) = kotlin_func.receiver_type {
                // Convert Kotlin type name to ArgType
                use dexterity_ir::ArgType;
                let arg_type = if receiver.starts_with('[') {
                    // Array type
                    ArgType::Array(Box::new(ArgType::Object(receiver.trim_start_matches('[').trim_start_matches('L').trim_end_matches(';').replace('/', ".").into())))
                } else if receiver.contains('/') || receiver.contains('.') {
                    // Object type
                    ArgType::Object(receiver.replace('/', ".").into())
                } else {
                    // Simple class name - treat as object
                    ArgType::Object(receiver.clone().into())
                };
                method.receiver_type = Some(arg_type);
                tracing::debug!("Applied receiver type {} to: {}", receiver, kotlin_func.name);
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

/// Apply Kotlin metadata names to IR with options
/// JADX Reference: KotlinMetadataDecompilePass.kt
///
/// This is the options-aware version of `apply_kotlin_names`.
pub fn apply_kotlin_names_with_options(
    cls: &mut ClassData,
    metadata: &KotlinClassMetadata,
    options: &KotlinProcessingOptions,
) -> Result<()> {
    // 1. Set class name alias - only for actual classes (kind=1), not file facades
    // Controlled by options.class_alias
    if options.class_alias && cls.alias.is_none() && matches!(metadata.kind, KotlinKind::Class) {
        let simple_name = metadata.class_name
            .rsplit('/')
            .next()
            .unwrap_or(&metadata.class_name);
        let simple_name = simple_name
            .rsplit('$')
            .next()
            .unwrap_or(simple_name);
        if simple_name != cls.simple_name() {
            cls.alias = Some(simple_name.to_string());
            cls.add_rename_reason("from kotlin metadata");
        }
    }

    // 2. Set Kotlin class info (data class, sealed class, etc.)
    // Controlled by options.data_class
    if options.data_class {
        let kotlin_info = KotlinClassInfo {
            is_data_class: metadata.is_data_class,
            is_sealed: metadata.flags.is_sealed,
            is_inline: metadata.flags.is_inline,
            is_companion: metadata.flags.is_fun_interface,
            companion_name: metadata.companion_object.clone(),
            sealed_subclasses: metadata.sealed_subclasses.clone(),
        };
        cls.set_kotlin_class_info(kotlin_info);
    }

    // 2.5. Apply type parameters with variance and bounds from Kotlin metadata
    // Always applied (affects type correctness)
    if !metadata.type_parameters.is_empty() {
        use crate::parser::parse_kotlin_type_name;
        use dexterity_ir::ArgType;

        let type_params: Vec<TypeParameter> = metadata.type_parameters.iter().map(|ktp| {
            let bounds: Vec<ArgType> = ktp.upper_bounds.iter()
                .map(|type_name| parse_kotlin_type_name(type_name))
                .filter(|t| !matches!(t, ArgType::Object(s) if s == "java/lang/Object"))
                .collect();

            TypeParameter {
                name: ktp.name.clone(),
                bounds,
                variance: ktp.variance.to_ir(),
                reified: ktp.reified,
            }
        }).collect();

        if !type_params.is_empty() {
            for (i, ktp) in type_params.iter().enumerate() {
                if i < cls.type_parameters.len() {
                    if !ktp.bounds.is_empty() {
                        cls.type_parameters[i].bounds = ktp.bounds.clone();
                    }
                    cls.type_parameters[i].variance = ktp.variance;
                    cls.type_parameters[i].reified = ktp.reified;
                } else {
                    cls.type_parameters.push(ktp.clone());
                }
            }
        }
    }

    // 3. Apply method names and parameter names
    // Controlled by options.method_args
    if options.method_args {
        for kotlin_func in &metadata.functions {
            if let Some(method) = find_method_by_signature(cls, kotlin_func) {
                if method.alias.is_none() {
                    method.alias = Some(kotlin_func.name.clone());
                    method.add_rename_reason("from kotlin metadata");
                }

                // Set parameter names
                for (param_idx, kotlin_param) in kotlin_func.parameters.iter().enumerate() {
                    if param_idx < method.arg_names.len() && method.arg_names[param_idx].is_none() {
                        method.arg_names[param_idx] = Some(kotlin_param.name.clone());
                    }
                }

                // Apply Kotlin function modifiers to IR (always applied)
                if kotlin_func.flags.is_suspend {
                    method.is_suspend = true;
                }
                if kotlin_func.flags.is_inline {
                    method.is_inline_function = true;
                }
                if kotlin_func.flags.is_infix {
                    method.is_infix = true;
                }
                if kotlin_func.flags.is_operator {
                    method.is_operator = true;
                }
                if kotlin_func.flags.is_tailrec {
                    method.is_tailrec = true;
                }

                // Apply extension function receiver type
                if let Some(ref receiver) = kotlin_func.receiver_type {
                    use dexterity_ir::ArgType;
                    let arg_type = if receiver.starts_with('[') {
                        ArgType::Array(Box::new(ArgType::Object(receiver.trim_start_matches('[').trim_start_matches('L').trim_end_matches(';').replace('/', ".").into())))
                    } else if receiver.contains('/') || receiver.contains('.') {
                        ArgType::Object(receiver.replace('/', ".").into())
                    } else {
                        ArgType::Object(receiver.clone().into())
                    };
                    method.receiver_type = Some(arg_type);
                }
            }
        }
    }

    // 4. Apply property (field) names using improved matching
    // Controlled by options.fields
    if options.fields {
        apply_property_names(cls, &metadata.properties);
    }

    // 5. Handle companion object if present
    // Controlled by options.companion
    if options.companion {
        if let Some(companion_name) = &metadata.companion_object {
            apply_companion_object_name(cls, companion_name);
        }
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
/// JADX Clone: jadx-plugins/jadx-kotlin-metadata/src/main/kotlin/jadx/plugins/kotlin/metadata/utils/KotlinMetadataUtils.kt:111-140
fn apply_property_names(cls: &mut ClassData, properties: &[KotlinProperty]) {
    // Debug: Log entry into this function for troubleshooting
    let debug_class = std::env::var("DEXTERITY_DEBUG_KOTLIN").is_ok()
        || cls.class_type.contains("Balloon")
        || cls.class_type.contains("a0");  // SegmentedByteString

    if debug_class {
        tracing::info!(
            "apply_property_names for {}: {} properties, {} instance fields, {} static fields",
            cls.class_type, properties.len(), cls.instance_fields.len(), cls.static_fields.len()
        );
        for (i, prop) in properties.iter().enumerate() {
            tracing::info!("  Property[{}]: name='{}', jvm_sig='{}'", i, prop.name, prop.jvm_field_signature);
        }
        for (i, field) in cls.instance_fields.iter().enumerate() {
            tracing::info!("  InstanceField[{}]: name='{}', type={}", i, field.name, field.field_type.to_descriptor());
        }
    }

    // Track which properties and fields have been matched
    let mut matched_props: Vec<bool> = vec![false; properties.len()];
    let mut matched_instance: Vec<bool> = vec![false; cls.instance_fields.len()];
    let mut matched_static: Vec<bool> = vec![false; cls.static_fields.len()];

    // === PASS 1: JVM signature matching (most reliable) ===
    // JADX Clone: KotlinMetadataUtils.kt uses fieldSignature for exact matching
    for (prop_idx, kotlin_prop) in properties.iter().enumerate() {
        if matched_props[prop_idx] {
            continue;
        }

        // Try instance fields first
        let mut found = false;
        for (i, field) in cls.instance_fields.iter_mut().enumerate() {
            if !matched_instance[i] && field.alias.is_none() && field_matches(field, kotlin_prop) {
                field.alias = Some(kotlin_prop.name.clone());
                field.add_rename_reason("from kotlin metadata");
                matched_instance[i] = true;
                matched_props[prop_idx] = true;
                found = true;
                tracing::debug!(
                    "Matched instance field '{}' -> '{}' (JVM sig)",
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
                    field.add_rename_reason("from kotlin metadata");
                    matched_static[i] = true;
                    matched_props[prop_idx] = true;
                    tracing::debug!(
                        "Matched static field '{}' -> '{}' (JVM sig)",
                        field.name, kotlin_prop.name
                    );
                    break;
                }
            }
        }
    }

    // === PASS 2: Index-based matching for remaining unmatched obfuscated fields ===
    // JADX Clone: When JVM signatures aren't available, JADX falls back to order-based matching
    // This is safe because Kotlin metadata preserves declaration order
    //
    // IMPORTANT: Only consider properties that likely have backing fields:
    // - Property name is not obfuscated (like "segments", "directory")
    // - Property has a backing field flag or has getter/setter that suggests a field
    // - Property name doesn't match common method names (hashCode, toString, equals, etc.)
    let unmatched_props: Vec<(usize, &KotlinProperty)> = properties.iter()
        .enumerate()
        .filter(|(i, p)| {
            !matched_props[*i]
                && !looks_obfuscated(&p.name)
                && is_likely_field_property(p)
        })
        .collect();

    let unmatched_instance: Vec<usize> = cls.instance_fields.iter()
        .enumerate()
        .filter(|(i, f)| !matched_instance[*i] && f.alias.is_none() && looks_obfuscated(&f.name))
        .map(|(i, _)| i)
        .collect();

    if debug_class {
        tracing::info!(
            "Pass 2: {} unmatched field props, {} unmatched obfuscated instance fields",
            unmatched_props.len(), unmatched_instance.len()
        );
        for (_, prop) in &unmatched_props {
            tracing::info!("  Unmatched prop: name='{}', jvm_sig='{}'", prop.name, prop.jvm_field_signature);
        }
    }

    // Match by index if counts align (order-preserving)
    for (match_idx, (prop_idx, prop)) in unmatched_props.iter().enumerate() {
        if match_idx < unmatched_instance.len() {
            let field_idx = unmatched_instance[match_idx];
            let field = &mut cls.instance_fields[field_idx];

            // Only match if types are compatible
            if types_compatible(&field.field_type.to_descriptor(), prop) {
                field.alias = Some(prop.name.clone());
                field.add_rename_reason("from kotlin metadata");
                matched_instance[field_idx] = true;
                matched_props[*prop_idx] = true;

                if debug_class {
                    tracing::info!(
                        "Matched instance field '{}' -> '{}' (index-based)",
                        field.name, prop.name
                    );
                }
            }
        }
    }

    // Same for static fields
    let unmatched_props: Vec<(usize, &KotlinProperty)> = properties.iter()
        .enumerate()
        .filter(|(i, p)| {
            !matched_props[*i]
                && !looks_obfuscated(&p.name)
                && is_likely_field_property(p)
        })
        .collect();

    let unmatched_static: Vec<usize> = cls.static_fields.iter()
        .enumerate()
        .filter(|(i, f)| !matched_static[*i] && f.alias.is_none() && looks_obfuscated(&f.name))
        .map(|(i, _)| i)
        .collect();

    for (match_idx, (prop_idx, prop)) in unmatched_props.iter().enumerate() {
        if match_idx < unmatched_static.len() {
            let field_idx = unmatched_static[match_idx];
            let field = &mut cls.static_fields[field_idx];

            if types_compatible(&field.field_type.to_descriptor(), prop) {
                field.alias = Some(prop.name.clone());
                field.add_rename_reason("from kotlin metadata");
                matched_static[field_idx] = true;
                matched_props[*prop_idx] = true;

                if debug_class {
                    tracing::info!(
                        "Matched static field '{}' -> '{}' (index-based)",
                        field.name, prop.name
                    );
                }
            }
        }
    }
}

/// Check if a Kotlin property likely represents a backing field
/// JADX Clone: Properties in Kotlin metadata can be either field-backed or computed
fn is_likely_field_property(property: &KotlinProperty) -> bool {
    // Common method names that are NOT field properties
    const METHOD_NAMES: &[&str] = &[
        "hashCode", "toString", "equals", "clone", "finalize",
        "getClass", "notify", "notifyAll", "wait",
        "compareTo", "iterator", "size", "isEmpty",
    ];

    // If the property name matches a common method, it's not a field property
    if METHOD_NAMES.contains(&property.name.as_str()) {
        return false;
    }

    // If property has backing field flag set, it's definitely a field property
    if property.flags.has_backing_field {
        return true;
    }

    // If property has a JVM field signature with a type, it's likely a field
    if property.jvm_field_signature.contains(':') {
        return true;
    }

    // If property name follows field naming conventions (lowercase start, no parens)
    let first_char = property.name.chars().next();
    if let Some(c) = first_char {
        if c.is_lowercase() && !property.name.contains('(') {
            return true;
        }
    }

    // Default: assume it's not a field property to be safe
    false
}

/// Check if a field type is compatible with a Kotlin property
/// Uses getter/setter signatures if available to verify type
fn types_compatible(field_type_desc: &str, property: &KotlinProperty) -> bool {
    // If we have a getter signature, extract return type and compare
    if let Some(ref getter_sig) = property.getter_signature {
        // Getter format: "getXxx()Lcom/example/Type;" or "getXxx()I"
        if let Some(ret_start) = getter_sig.rfind(')') {
            let return_type = &getter_sig[ret_start + 1..];
            if !return_type.is_empty() && return_type != field_type_desc {
                // Type mismatch - not compatible
                return false;
            }
        }
    }

    // If we have JVM field signature with type, compare
    if property.jvm_field_signature.contains(':') {
        if let Some(colon_pos) = property.jvm_field_signature.find(':') {
            let sig_type = &property.jvm_field_signature[colon_pos + 1..];
            if !sig_type.is_empty() && sig_type != field_type_desc {
                return false;
            }
        }
    }

    // No type info to compare, assume compatible
    true
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
                // JADX Reference: RenameReasonAttr pattern
                field.add_rename_reason("from kotlin metadata");
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

/// Check if a field matches a Kotlin property using JVM signature matching
///
/// JADX Clone Reference: jadx-plugins/jadx-kotlin-metadata/src/main/kotlin/jadx/plugins/kotlin/metadata/utils/
/// - KotlinMetadataUtils.kt:111-116 - mapFields() uses searchFieldByShortId(kmProperty.shortId)
/// - KmExt.kt:10 - inline val KmProperty.shortId: String? get() = fieldSignature?.toString()
/// - FieldInfo.java:68-70 - getShortId() returns "name:type_descriptor"
///
/// The key insight is that JADX matches by EXACT JVM field signature, not by heuristics.
fn field_matches(field: &FieldData, property: &KotlinProperty) -> bool {
    // Debug logging for Balloon fields
    let is_balloon = field.name == "C" || field.name == "context" || property.name == "context";

    // Strategy 1: JVM signature match (JADX approach - most reliable)
    // KmProperty.fieldSignature gives us "fieldName:Ljava/lang/Type;"
    // We build the same from FieldData and compare
    let jvm_sig = &property.jvm_field_signature;
    if !jvm_sig.is_empty() {
        // jvm_field_signature format: "name:Ltype;" or just "name" if no type info
        // Parse the field name part from the signature
        if let Some(colon_pos) = jvm_sig.find(':') {
            let sig_name = &jvm_sig[..colon_pos];
            let sig_type = &jvm_sig[colon_pos + 1..];

            if is_balloon {
                tracing::info!(
                    "field_matches: field.name='{}', field.type='{}', sig_name='{}', sig_type='{}', property.name='{}'",
                    field.name, field.field_type.to_descriptor(), sig_name, sig_type, property.name
                );
            }

            // Match by field name from signature
            if field.name == sig_name {
                // Verify type matches if we have type info
                let field_type_desc = field.field_type.to_descriptor();
                if sig_type == field_type_desc {
                    tracing::trace!(
                        "Field matched by JVM signature: '{}' == '{}'",
                        jvm_sig, format!("{}:{}", field.name, field_type_desc)
                    );
                    return true;
                }
                // Name matches but type differs - still match by name if obfuscated
                // This handles cases where type info in metadata might differ slightly
                if looks_obfuscated(&field.name) {
                    tracing::trace!(
                        "Field matched by JVM sig name only (type mismatch): {} vs {}",
                        sig_type, field_type_desc
                    );
                    return true;
                }
            }
        } else {
            // No colon - jvm_sig is just the field name
            if field.name == *jvm_sig {
                return true;
            }
        }
    }

    // Strategy 2: Exact name match (fast path for unobfuscated code)
    if field.name == property.name {
        return true;
    }

    // Strategy 3: Backing field pattern
    // Kotlin often generates backing fields like "name$delegate" for delegated properties
    if field.name.starts_with(&property.name) && field.name.contains('$') {
        return true;
    }

    // Strategy 4: Underscore prefix pattern
    // Properties with custom getters/setters may have backing field like "_name"
    if field.name.starts_with("_") && field.name.len() > 1 && field.name[1..] == property.name {
        return true;
    }

    // NO unconditional matching for obfuscated names!
    // This was the bug - we can't match by "looks obfuscated" alone because
    // multiple obfuscated fields would all match the first property in the list.
    // JADX uses signature matching, not heuristics.

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

/// TypeResolver implementation for DexReader
struct DexReaderResolver<'a> {
    reader: &'a DexReader,
}

impl<'a> TypeResolver for DexReaderResolver<'a> {
    fn get_type(&self, type_idx: u32) -> Option<String> {
        self.reader.get_type(type_idx).ok()
    }

    fn get_method(&self, method_idx: u32) -> Option<String> {
        // Get method and format as "ClassName.methodName"
        self.reader.get_method(method_idx).ok().and_then(|m| {
            let class_type = m.class_type().ok()?;
            let method_name = m.name().ok()?;
            Some(format!("{}.{}", class_type, method_name))
        })
    }

    fn get_string(&self, string_idx: u32) -> Option<String> {
        self.reader.get_string(string_idx).ok().map(|s| s.to_string())
    }
}

/// Apply toString() bytecode analysis to extract field names
///
/// This is a fallback mechanism for when protobuf metadata is missing or obfuscated.
/// Kotlin data classes generate predictable toString() methods that contain
/// original field names as string literals.
pub fn apply_tostring_names(cls: &mut ClassData, dex: &DexReader) -> Result<()> {
    // Only process data classes
    if !cls.is_data_class() {
        return Ok(());
    }

    // Find toString() method
    let tostring_method = match cls.methods.iter().find(|m| m.name == "toString" && m.arg_types.is_empty()) {
        Some(m) => m,
        None => return Ok(()), // No toString() method
    };

    // Get method instructions
    let instructions = match &tostring_method.instructions {
        Some(insns) => insns,
        None => return Ok(()), // No instructions (abstract/native)
    };

    // Parse the toString() method
    let resolver = DexReaderResolver { reader: dex };
    let result = match tostring_parser::parse_tostring(tostring_method, instructions, &resolver) {
        Some(r) => r,
        None => return Ok(()), // Parsing failed or no fields found
    };

    // Apply class alias if extracted and not already set
    if let Some(class_alias) = result.class_alias {
        if cls.alias.is_none() && !class_alias.is_empty() {
            tracing::debug!(
                "toString() extracted class alias: '{}' for {}",
                class_alias, cls.class_type
            );
            cls.alias = Some(class_alias);
            // JADX Reference: RenameReasonAttr pattern
            cls.add_rename_reason("from toString");
        }
    }

    // Apply field renames
    for (field_idx, alias) in result.field_renames {
        // The field_idx from InstanceGet is a DEX field index, we need to find
        // the corresponding field in our ClassData by matching the index
        // Since we don't have direct index mapping, we need to look it up
        if let Ok(field_id) = dex.get_field(field_idx) {
            let field_name = field_id.name().unwrap_or_default();

            // Find matching field in instance_fields
            for field in &mut cls.instance_fields {
                if field.name == field_name && field.alias.is_none() {
                    field.alias = Some(alias.clone());
                    // JADX Reference: RenameReasonAttr pattern
                    field.add_rename_reason("from toString");
                    tracing::debug!(
                        "toString() extracted field alias: '{}' -> '{}' in {}",
                        field_name, alias, cls.class_type
                    );
                    break;
                }
            }
        }
    }

    Ok(())
}

// ============================================================================
// JADX-Style Getter Recognition
// ============================================================================
// Cloned from JADX: jadx-plugins/jadx-kotlin-metadata/src/main/kotlin/jadx/plugins/kotlin/metadata/utils/KotlinUtils.kt
// JADX approach: For each instance field, find method where:
// - Return type matches field type
// - No arguments
// - Exactly 3 instructions
// - Has InstanceGet instruction pointing to the field

/// Find getter methods for fields using JADX's exact criteria
/// JADX Reference: KotlinUtils.kt:25-44
pub fn find_getters_jadx_style(cls: &mut ClassData) {
    // Collect field info first to avoid borrow issues
    let field_info: Vec<_> = cls.instance_fields.iter()
        .filter_map(|f| {
            f.dex_field_idx.map(|idx| (idx, f.field_type.clone(), f.display_name().to_string()))
        })
        .collect();

    for (field_idx, field_type, field_alias) in field_info {
        // Find a method that matches JADX's getter criteria
        // JADX Reference: KotlinUtils.kt:36-43
        if let Some(method_idx) = find_field_getter_method(cls, field_idx, &field_type) {
            // Generate getter alias: get{FieldAlias}
            // JADX Reference: KotlinUtils.kt:46-51
            let getter_alias = get_getter_alias(&field_alias);

            // Apply the alias
            if let Some(method) = cls.methods.get_mut(method_idx) {
                if method.alias.is_none() {
                    tracing::debug!(
                        "JADX-style getter match: method '{}' -> '{}' (field: {})",
                        method.name, getter_alias, field_alias
                    );
                    method.alias = Some(getter_alias);
                    // JADX Reference: RenameReasonAttr pattern
                    method.add_rename_reason("from getter");
                }
            }
        }
    }
}

/// Find a method that is a getter for the given field
/// JADX Reference: KotlinUtils.kt:36-43
/// Criteria:
/// - Return type matches field type
/// - No arguments (argTypes.isEmpty())
/// - Exactly 3 instructions (insnsCount == 3)
/// - Has InstanceGet instruction pointing to the field (sVars[1].assignInsn as? IndexInsnNode)?.index == field
fn find_field_getter_method(cls: &ClassData, field_idx: u32, field_type: &dexterity_ir::ArgType) -> Option<usize> {
    for (method_idx, method) in cls.methods.iter().enumerate() {
        // Skip static methods (getters are instance methods)
        if method.is_static() {
            continue;
        }

        // Criterion 1: Return type must match field type
        // JADX Reference: KotlinUtils.kt:38
        if &method.return_type != field_type {
            continue;
        }

        // Criterion 2: No arguments
        // JADX Reference: KotlinUtils.kt:39
        if !method.arg_types.is_empty() {
            continue;
        }

        // Criterion 3: Exactly 3 instructions
        // JADX Reference: KotlinUtils.kt:40
        let insn_count = match &method.instructions {
            Some(insns) => insns.len(),
            None => continue, // No instructions = not a getter
        };
        if insn_count != 3 {
            continue;
        }

        // Criterion 4: Has InstanceGet instruction pointing to our field
        // JADX Reference: KotlinUtils.kt:41-42
        // (it.sVars[1].assignInsn as? IndexInsnNode)?.index == field
        // In our IR: Check if any instruction is InstanceGet with matching field_idx
        if let Some(insns) = &method.instructions {
            let has_field_get = insns.iter().any(|insn| {
                matches!(&insn.insn_type, InsnType::InstanceGet { field_idx: idx, .. } if *idx == field_idx)
            });

            if has_field_get {
                return Some(method_idx);
            }
        }
    }

    None
}

/// Generate getter method alias from field alias
/// JADX Reference: KotlinUtils.kt:46-51
fn get_getter_alias(field_alias: &str) -> String {
    let capitalized = capitalize_first(field_alias);
    format!("get{}", capitalized)
}

// ============================================================================
// JADX-Style Default Method Recognition
// ============================================================================
// Cloned from JADX: jadx-plugins/jadx-kotlin-metadata/src/main/kotlin/jadx/plugins/kotlin/metadata/utils/KotlinUtils.kt
// For methods with default parameter values, Kotlin generates synthetic $default methods

// ============================================================================
// JADX-Style Companion Object Detection
// ============================================================================
// Cloned from JADX: jadx-plugins/jadx-kotlin-metadata/src/main/kotlin/jadx/plugins/kotlin/metadata/utils/KotlinMetadataUtils.kt
// Empty companion objects that are only used in <clinit> can be hidden

/// Result of companion analysis
/// JADX Reference: KotlinMetadataUtils.kt:118-141
pub struct CompanionAnalysis {
    /// Field name of the companion object
    pub field_name: String,
    /// Whether the companion should be hidden (only used in clinit and empty)
    pub should_hide: bool,
}

/// Analyze companion object for potential hiding
/// JADX Reference: KotlinMetadataUtils.kt:118-141
pub fn analyze_companion_for_hiding(cls: &ClassData, metadata: &KotlinClassMetadata) -> Option<CompanionAnalysis> {
    // Get companion object name from metadata
    // JADX Reference: KotlinMetadataUtils.kt:119
    let companion_name = metadata.companion_object.as_ref()?;

    // Find the companion field (static final public)
    // JADX Reference: KotlinMetadataUtils.kt:120-122
    let companion_field = cls.static_fields.iter().find(|f| {
        f.name == *companion_name
            && f.is_static()
            && f.is_final()
            && (f.access_flags & 0x0001) != 0 // public
    })?;

    // Check if field is only used in <clinit>
    // JADX Reference: KotlinMetadataUtils.kt:130
    // isOnlyInit = compField.useIn.size == 1 && compField.useIn[0].methodInfo.isClassInit
    let is_only_init = companion_field.use_in.len() == 1
        && companion_field.use_in.first()
            .map(|(_, method_name)| method_name == "<clinit>")
            .unwrap_or(false);

    // Check if companion class is empty (only constructors, no fields)
    // JADX Reference: KotlinMetadataUtils.kt:131
    // isEmpty = compCls.run { methods.all { it.isConstructor } && fields.isEmpty() }
    // We need to find the inner class and check it
    // For now, we'll just check based on the field's type
    let companion_type = match &companion_field.field_type {
        dexterity_ir::ArgType::Object(name) => Some(name.as_str()),
        _ => None,
    };

    // Check if we can find the companion inner class
    let is_empty = if let Some(comp_type) = companion_type {
        // Look for the inner class
        cls.inner_classes.iter().find(|inner| {
            inner.as_str() == comp_type
        }).is_some()
        // For full implementation, we'd need to load the inner class and check
        // if it has only constructors and no fields
        // For now, we'll be conservative and only hide if isOnlyInit is true
        && is_only_init
    } else {
        false
    };

    // JADX Reference: KotlinMetadataUtils.kt:133-136
    // hide = isOnlyInit && isEmpty
    let should_hide = is_only_init && is_empty;

    if should_hide {
        tracing::debug!(
            "Companion object '{}' can be hidden (only init: {}, empty: {})",
            companion_name, is_only_init, is_empty
        );
    }

    Some(CompanionAnalysis {
        field_name: companion_name.clone(),
        should_hide,
    })
}

// ============================================================================
// JADX Companion Object Naming Constants
// ============================================================================
// Cloned from JADX: jadx-plugins/jadx-kotlin-metadata/src/main/kotlin/jadx/plugins/kotlin/metadata/pass/KotlinMetadataDecompilePass.kt:137-138
/// Companion object field name (the static field holding the companion instance)
const COMPANION_FIELD: &str = "INSTANCE";
/// Companion object class name (the inner class)
const COMPANION_CLASS: &str = "Companion";

/// Rename companion object field and class
/// JADX Reference: KotlinMetadataDecompilePass.kt:71-88
pub fn rename_companion_jadx_style(cls: &mut ClassData, metadata: &KotlinClassMetadata) {
    // Get companion object name from metadata
    let companion_name = match &metadata.companion_object {
        Some(name) => name,
        None => return,
    };

    // Find and rename the companion field to "INSTANCE"
    // JADX Reference: KotlinMetadataDecompilePass.kt:74-77
    // JADX uses COMPANION_FIELD = "INSTANCE" for the field
    for field in &mut cls.static_fields {
        if field.name == *companion_name && field.alias.is_none() {
            // JADX Reference: KotlinMetadataDecompilePass.kt:76
            // field.rename(COMPANION_FIELD) where COMPANION_FIELD = "INSTANCE"
            field.alias = Some(COMPANION_FIELD.to_string());
            // JADX Reference: RenameReasonAttr pattern
            field.add_rename_reason("from kotlin metadata");
            tracing::debug!(
                "JADX-style companion field rename: '{}' -> '{}'",
                field.name, COMPANION_FIELD
            );
            break;
        }
    }

    // Note: Companion CLASS rename to "Companion" requires access to the inner class
    // JADX Reference: KotlinMetadataDecompilePass.kt:78-80
    // cls.rename(COMPANION_CLASS) where COMPANION_CLASS = "Companion"
    // This is handled separately in the class processing pipeline when inner classes
    // are processed - the inner class matching companion_name should be renamed to "Companion"
}

/// Find and rename default parameter methods
/// JADX Reference: KotlinUtils.kt:53-89
pub fn find_default_methods_jadx_style(cls: &mut ClassData) {
    // Collect matching methods and their potential original methods
    let class_name = cls.class_type.clone();
    let mut renames: Vec<(usize, String)> = Vec::new();

    for (method_idx, method) in cls.methods.iter().enumerate() {
        // Criteria for $default method:
        // JADX Reference: KotlinUtils.kt:55-62
        // 1. Static and synthetic
        if !method.is_static() || (method.access_flags & 0x1000) == 0 {
            continue;
        }

        // 2. Signature pattern:
        //    - First arg is the class type
        //    - Second-to-last arg is INT (bitmask for which params have defaults)
        //    - Last arg is Object (unused continuation parameter)
        let arg_count = method.arg_types.len();
        if arg_count < 4 {
            continue;
        }

        // First arg must be the class type
        let first_arg = &method.arg_types[0];
        if !matches!(first_arg, dexterity_ir::ArgType::Object(name) if name.as_str() == class_name) {
            continue;
        }

        // Second-to-last must be int
        let second_to_last = &method.arg_types[arg_count - 2];
        if !matches!(second_to_last, dexterity_ir::ArgType::Int) {
            continue;
        }

        // Last must be Object
        let last_arg = &method.arg_types[arg_count - 1];
        if !matches!(last_arg, dexterity_ir::ArgType::Object(name) if name.as_str() == "java/lang/Object") {
            continue;
        }

        // This looks like a $default method
        // Try to find the original method it corresponds to
        // The original method has the same name without $default suffix
        // and matches the parameter types (minus the bitmask and Object params)

        // Simple heuristic: look for a method with matching name pattern
        // Real JADX uses dominator analysis, but we'll use name matching
        if method.name.ends_with("$default") {
            let original_name = method.name.trim_end_matches("$default");
            // Find original method
            for orig_method in cls.methods.iter() {
                if orig_method.name == original_name && !orig_method.is_static() {
                    // Found potential original - rename $default method
                    let alias = format!("{}$default", orig_method.display_name());
                    tracing::debug!(
                        "JADX-style default method match: '{}' -> '{}'",
                        method.name, &alias
                    );
                    renames.push((method_idx, alias));
                    break;
                }
            }
        }
    }

    // Apply renames
    for (method_idx, alias) in renames {
        if let Some(method) = cls.methods.get_mut(method_idx) {
            if method.alias.is_none() {
                method.alias = Some(alias);
                // JADX Reference: RenameReasonAttr pattern
                method.add_rename_reason("from default method");
            }
        }
    }
}
