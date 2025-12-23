//! Rename validation and collision handling
//!
//! Ported from jadx-core/src/main/java/jadx/core/dex/visitors/rename/RenameVisitor.java
//!
//! This module provides validation functions to detect and fix:
//! - Duplicate field names within a class
//! - Method signature collisions
//! - Invalid class names (anonymous patterns, leading digits)
//! - Case-insensitive path collisions (for Windows filesystem support)

use std::collections::{HashSet, HashMap};

use dexterity_ir::ClassData;
use regex::Regex;
use lazy_static::lazy_static;

use crate::alias_provider::AliasProvider;
use crate::name_mapper::NameMapper;

lazy_static! {
    /// Pattern for anonymous class names (just digits like "1", "2", "123")
    static ref ANONYMOUS_CLASS_PATTERN: Regex = Regex::new(r"^\d+$").unwrap();
}

/// Constants matching JADX
pub mod consts {
    pub const ANONYMOUS_CLASS_PREFIX: &str = "AnonymousClass";
    pub const DEFAULT_PACKAGE_NAME: &str = "defpackage";
}

/// Fix class name if it's invalid
///
/// Returns:
/// - Some(fixed_name) if the name was fixed
/// - None if the name couldn't be fixed (needs complete rename)
pub fn fix_class_short_name(
    class_name: &str,
    rename_valid: bool,
    rename_printable: bool,
) -> Option<String> {
    if class_name.is_empty() {
        return None;
    }

    let mut result = class_name.to_string();

    // Handle anonymous classes (pure digit names like "1", "2")
    if rename_valid && ANONYMOUS_CLASS_PATTERN.is_match(class_name) {
        return Some(format!(
            "{}{}",
            consts::ANONYMOUS_CLASS_PREFIX,
            NameMapper::remove_invalid_chars_middle(class_name)
        ));
    }

    // Handle names starting with $ or digit
    if rename_valid {
        let first_char = class_name.chars().next().unwrap();
        if first_char == '$' || first_char.is_ascii_digit() {
            return Some(format!(
                "C{}",
                NameMapper::remove_invalid_chars_middle(class_name)
            ));
        }
    }

    // Remove non-printable characters if requested
    if rename_printable {
        result = NameMapper::remove_non_printable(&result);
    }

    if result.is_empty() {
        return None;
    }

    // Remove invalid characters if requested
    if rename_valid {
        result = NameMapper::remove_invalid_chars(&result, "C");
        if !NameMapper::is_valid_identifier(&result) {
            return Some(format!("C{}", result));
        }
    }

    Some(result)
}

/// Validate and fix field names within a class to ensure uniqueness
///
/// Returns the number of fields that were renamed
pub fn validate_fields<A: AliasProvider>(
    cls: &mut ClassData,
    alias_provider: &A,
    rename_valid: bool,
    rename_printable: bool,
) -> usize {
    let mut renamed_count = 0;
    let mut names_used: HashSet<String> = HashSet::new();

    // Process all fields (static and instance)
    let mut process_field = |field: &mut dexterity_ir::FieldData| {
        let field_name = field.alias.as_ref().unwrap_or(&field.name).clone();

        let mut needs_rename = false;

        // Check uniqueness
        if !names_used.insert(field_name.clone()) {
            needs_rename = true;
        }

        // Check validity
        if rename_valid && !NameMapper::is_valid_identifier(&field_name) {
            needs_rename = true;
        }

        // Check printability
        if rename_printable && !NameMapper::is_all_chars_printable(&field_name) {
            needs_rename = true;
        }

        if needs_rename && field.alias.is_none() {
            // Generate new alias using provider
            let new_alias = alias_provider.for_field(field);
            // Ensure new name is also unique
            let mut unique_alias = new_alias.clone();
            let mut counter = 2;
            while names_used.contains(&unique_alias) {
                unique_alias = format!("{}{}", new_alias, counter);
                counter += 1;
            }
            names_used.insert(unique_alias.clone());
            field.alias = Some(unique_alias);
            renamed_count += 1;
        }
    };

    for field in &mut cls.static_fields {
        process_field(field);
    }
    for field in &mut cls.instance_fields {
        process_field(field);
    }

    renamed_count
}

/// Validate and fix method names for signature collisions
///
/// Returns the number of methods that were renamed
pub fn validate_methods<A: AliasProvider>(
    cls: &mut ClassData,
    alias_provider: &A,
    rename_valid: bool,
    rename_printable: bool,
) -> usize {
    use crate::signature::method_proto_to_descriptor;

    let mut renamed_count = 0;

    // First pass: fix invalid/non-printable method names
    for method in &mut cls.methods {
        // Skip constructors
        if method.name == "<init>" || method.name == "<clinit>" {
            continue;
        }

        let method_name = method.alias.as_ref().unwrap_or(&method.name);

        let not_valid = rename_valid && !NameMapper::is_valid_identifier(method_name);
        let not_printable = rename_printable && !NameMapper::is_all_chars_printable(method_name);

        if (not_valid || not_printable) && method.alias.is_none() {
            let is_override = method.annotations.iter().any(|a| {
                a.annotation_type.ends_with("/Override")
            });
            method.alias = Some(alias_provider.for_method(method, is_override));
            renamed_count += 1;
        }
    }

    // Second pass: detect signature collisions
    if rename_valid {
        let mut signatures: HashMap<String, usize> = HashMap::new();

        // Build signature -> first index mapping
        for (i, method) in cls.methods.iter().enumerate() {
            if method.name == "<init>" || method.name == "<clinit>" {
                continue;
            }
            let name = method.alias.as_ref().unwrap_or(&method.name);
            let proto = method_proto_to_descriptor(&method.arg_types, &method.return_type);
            let signature = format!("{}{}", name, proto);
            signatures.entry(signature).or_insert(i);
        }

        // Check for collisions and rename duplicates
        let mut seen_signatures: HashSet<String> = HashSet::new();
        for method in &mut cls.methods {
            if method.name == "<init>" || method.name == "<clinit>" {
                continue;
            }
            let name = method.alias.as_ref().unwrap_or(&method.name);
            let proto = method_proto_to_descriptor(&method.arg_types, &method.return_type);
            let signature = format!("{}{}", name, proto);

            if !seen_signatures.insert(signature.clone()) && method.alias.is_none() {
                // Collision detected - rename this method
                let is_override = method.annotations.iter().any(|a| {
                    a.annotation_type.ends_with("/Override")
                });
                method.alias = Some(alias_provider.for_method(method, is_override));
                renamed_count += 1;
            }
        }
    }

    renamed_count
}

/// Check for case-insensitive class path collisions
///
/// Returns classes that need renaming due to case collisions
pub fn find_case_collisions(classes: &[ClassData]) -> Vec<usize> {
    let mut paths_lower: HashSet<String> = HashSet::new();
    let mut collisions: Vec<usize> = Vec::new();

    for (i, cls) in classes.iter().enumerate() {
        let path = cls.alias.as_ref().unwrap_or(&cls.class_type);
        let path_lower = path.to_lowercase();
        if !paths_lower.insert(path_lower) {
            collisions.push(i);
        }
    }

    collisions
}

/// Collect all root package names (first segment of package paths)
pub fn collect_root_packages(classes: &[ClassData]) -> HashSet<String> {
    let mut root_pkgs = HashSet::new();

    for cls in classes {
        let class_type = cls.class_type.trim_start_matches('L').trim_end_matches(';');
        if let Some(pos) = class_type.find('/') {
            root_pkgs.insert(class_type[..pos].to_string());
        }
    }

    root_pkgs
}

/// Rename fields that collide with root package names
pub fn fix_root_package_collisions<A: AliasProvider>(
    classes: &mut [ClassData],
    alias_provider: &A,
) -> usize {
    let root_pkgs = collect_root_packages(classes);
    let mut renamed_count = 0;

    for cls in classes {
        for field in cls.static_fields.iter_mut().chain(cls.instance_fields.iter_mut()) {
            let field_name = field.alias.as_ref().unwrap_or(&field.name);
            if root_pkgs.contains(field_name) && field.alias.is_none() {
                field.alias = Some(alias_provider.for_field(field));
                renamed_count += 1;
            }
        }
    }

    renamed_count
}

#[cfg(test)]
mod tests {
    use super::*;
    use crate::alias_provider::DeobfAliasProvider;
    use dexterity_ir::{ArgType, FieldData, MethodData};

    #[test]
    fn test_fix_class_short_name() {
        // Anonymous class name
        let result = fix_class_short_name("123", true, false);
        assert_eq!(result, Some("AnonymousClass123".to_string()));

        // Name starting with digit
        let result = fix_class_short_name("1Foo", true, false);
        assert_eq!(result, Some("C1Foo".to_string()));

        // Name starting with $ - $ is valid in Java identifiers, but we prefix with C
        // to ensure it's not a leading $ (which could cause issues with inner class references)
        let result = fix_class_short_name("$Foo", true, false);
        assert_eq!(result, Some("C$Foo".to_string()));

        // Valid name
        let result = fix_class_short_name("MyClass", true, false);
        assert_eq!(result, Some("MyClass".to_string()));

        // Empty name
        let result = fix_class_short_name("", true, false);
        assert!(result.is_none());
    }

    #[test]
    fn test_validate_fields_uniqueness() {
        let provider = DeobfAliasProvider::new(64);
        let mut cls = ClassData::new("Lcom/Test;".to_string(), 0);

        // Add two fields with the same name
        cls.static_fields.push(FieldData::new("value".to_string(), 0, ArgType::Int));
        cls.static_fields.push(FieldData::new("value".to_string(), 0, ArgType::Long));

        let renamed = validate_fields(&mut cls, &provider, true, false);

        // One should be renamed due to collision
        assert_eq!(renamed, 1);
        assert!(cls.static_fields[1].alias.is_some());
    }

    #[test]
    fn test_validate_methods_collision() {
        let provider = DeobfAliasProvider::new(64);
        let mut cls = ClassData::new("Lcom/Test;".to_string(), 0);

        // Add two methods with the same signature
        cls.methods.push(MethodData::new("doIt".to_string(), 0, ArgType::Void));
        cls.methods.push(MethodData::new("doIt".to_string(), 0, ArgType::Void));

        let renamed = validate_methods(&mut cls, &provider, true, false);

        // One should be renamed due to collision
        assert_eq!(renamed, 1);
        assert!(cls.methods[1].alias.is_some());
    }

    #[test]
    fn test_collect_root_packages() {
        let classes = vec![
            ClassData::new("Lcom/example/Foo;".to_string(), 0),
            ClassData::new("Lorg/test/Bar;".to_string(), 0),
            ClassData::new("Lcom/other/Baz;".to_string(), 0),
        ];

        let roots = collect_root_packages(&classes);

        assert!(roots.contains("com"));
        assert!(roots.contains("org"));
        assert_eq!(roots.len(), 2);
    }
}
