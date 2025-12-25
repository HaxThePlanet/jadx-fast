//! Signature Processor Pass
//!
//! JADX Clone: jadx-core/src/main/java/jadx/core/dex/visitors/SignatureProcessor.java
//! Original Author: Skylot (skylot@gmail.com)
//! Clone Date: Dec 2025
//!
//! Processes dalvik.annotation.Signature annotations to extract and validate
//! generic type information for classes, fields, and methods.
//!
//! The core signature parsing is done during DEX loading (in converter.rs),
//! but this pass provides the validation logic from JADX:
//! - Validates parsed types against DEX types
//! - Fixes missing type parameter declarations
//! - Validates inner class type references
//! - Validates full class names

use std::collections::HashSet;

use dexterity_ir::types::ArgType;

/// Result of signature processing
#[derive(Debug, Default)]
pub struct SignatureProcessorResult {
    /// Number of class signatures processed
    pub class_signatures_processed: usize,
    /// Number of method signatures processed
    pub method_signatures_processed: usize,
    /// Number of field signatures processed
    pub field_signatures_processed: usize,
    /// Number of type parameters fixed (added missing declarations)
    pub type_params_fixed: usize,
    /// Number of invalid signatures rejected
    pub invalid_signatures: usize,
    /// Warnings encountered
    pub warnings: Vec<String>,
}

// Using TypeCompareResult from method_invoke module
use crate::method_invoke::TypeCompareResult;

/// Validate a parsed type against the expected DEX type.
///
/// JADX Reference: SignatureProcessor.java:258-267
pub fn validate_parsed_type(
    parsed_type: &ArgType,
    dex_type: &ArgType,
    compare_types: impl Fn(&ArgType, &ArgType) -> TypeCompareResult,
    validate_class_name: impl Fn(&str) -> bool,
) -> bool {
    let result = compare_types(parsed_type, dex_type);

    if result == TypeCompareResult::Unknown {
        // For unknown comparison with object types, validate the class name
        // JADX Reference: SignatureProcessor.java:260-265
        if let ArgType::Object(class_name) = parsed_type {
            if !validate_class_name(class_name) {
                // Ignore external invalid class names
                return false;
            }
        }
    }

    result != TypeCompareResult::Conflict
}

/// Validate a full class name is a valid Java identifier.
///
/// JADX Reference: SignatureProcessor.java:269-281
/// NameMapper.isValidFullIdentifier() and isValidIdentifier()
pub fn validate_full_class_name(full_name: &str) -> bool {
    if full_name.is_empty() {
        return false;
    }

    // Check if it's a valid identifier overall
    if !is_valid_identifier(full_name) {
        // Check each part separately for dotted names
        if full_name.contains('.') {
            for part in full_name.split('.') {
                if !is_valid_identifier_part(part) {
                    return false;
                }
            }
        } else {
            return false;
        }
    }

    true
}

/// Check if a string is a valid Java identifier.
fn is_valid_identifier(name: &str) -> bool {
    if name.is_empty() {
        return false;
    }

    let mut chars = name.chars();

    // First char must be valid start
    if let Some(first) = chars.next() {
        if !is_java_identifier_start(first) {
            return false;
        }
    }

    // Rest must be valid parts
    chars.all(is_java_identifier_part)
}

/// Check if a string is a valid Java identifier part (for dotted names).
fn is_valid_identifier_part(name: &str) -> bool {
    if name.is_empty() {
        return false;
    }

    let mut chars = name.chars();

    if let Some(first) = chars.next() {
        if !is_java_identifier_start(first) {
            return false;
        }
    }

    chars.all(is_java_identifier_part)
}

/// Check if character can start a Java identifier.
fn is_java_identifier_start(c: char) -> bool {
    c.is_alphabetic() || c == '_' || c == '$'
}

/// Check if character can be part of a Java identifier.
fn is_java_identifier_part(c: char) -> bool {
    c.is_alphanumeric() || c == '_' || c == '$'
}

/// Fix type parameter declarations by adding missing ones.
///
/// JADX Reference: SignatureProcessor.java:98-127
/// fixTypeParamDeclarations() adds missing type parameters from supertype
/// and interfaces to make the code compilable.
pub fn fix_type_param_declarations(
    existing_params: &[String],
    superclass: &ArgType,
    interfaces: &[ArgType],
    is_inner_class: bool,
    parent_type_params: &[String],
) -> Vec<String> {
    // Collect all type parameters used in superclass and interfaces
    // JADX Reference: SignatureProcessor.java:103-108
    let mut used_params = HashSet::new();
    collect_generic_types(superclass, &mut used_params);
    for iface in interfaces {
        collect_generic_types(iface, &mut used_params);
    }

    if used_params.is_empty() {
        return existing_params.to_vec();
    }

    // Remove known type parameters
    // JADX Reference: SignatureProcessor.java:109-118
    let mut known_params: HashSet<&str> = existing_params.iter().map(|s| s.as_str()).collect();

    if is_inner_class {
        // Inner classes inherit parent's type parameters
        // JADX Reference: SignatureProcessor.java:111-113
        for param in parent_type_params {
            known_params.insert(param);
        }
    }

    for known in &known_params {
        used_params.remove(*known);
    }

    if used_params.is_empty() {
        return existing_params.to_vec();
    }

    // Add missing type parameters
    // JADX Reference: SignatureProcessor.java:123-126
    let mut result = existing_params.to_vec();
    let mut missing: Vec<_> = used_params.into_iter().collect();
    missing.sort(); // Sorted for determinism
    result.extend(missing);

    result
}

/// Collect generic type names from a type.
///
/// JADX Reference: SignatureProcessor.java:129-134
/// addGenericType() visitor
fn collect_generic_types(arg_type: &ArgType, types: &mut HashSet<String>) {
    match arg_type {
        ArgType::TypeVariable { name, extend_types } => {
            types.insert(name.clone());
            for ext in extend_types {
                collect_generic_types(ext, types);
            }
        }
        ArgType::Generic { params, .. } => {
            for arg in params {
                collect_generic_types(arg, types);
            }
        }
        ArgType::Array(elem) => {
            collect_generic_types(elem, types);
        }
        ArgType::Wildcard { inner, .. } => {
            if let Some(b) = inner {
                collect_generic_types(b, types);
            }
        }
        ArgType::OuterGeneric { outer, inner } => {
            collect_generic_types(outer, types);
            collect_generic_types(inner, types);
        }
        _ => {}
    }
}

/// Validate inner type references.
///
/// JADX Reference: SignatureProcessor.java:283-331
/// validateInnerType() checks that inner classes are properly declared.
pub fn validate_inner_type<F>(
    arg_type: &ArgType,
    resolve_class: F,
) -> bool
where
    F: Fn(&str) -> Option<InnerClassInfo> + Copy,
{
    // Get outer/inner types from OuterGeneric
    let (outer_type, inner_type) = match arg_type {
        ArgType::OuterGeneric { outer, inner } => (outer.as_ref(), inner.as_ref()),
        _ => return true, // No inner type to validate
    };

    // Get outer type name
    let outer_name = match outer_type {
        ArgType::Object(name) => name.as_str(),
        ArgType::Generic { base, .. } => base.as_str(),
        _ => return true,
    };

    // Resolve outer class
    let outer_class = match resolve_class(outer_name) {
        Some(c) => c,
        None => return true, // Can't validate if class not found
    };

    // Get inner class name
    let inner_name = match inner_type {
        ArgType::Object(name) => name.as_str(),
        ArgType::Generic { base, .. } => base.as_str(),
        _ => return true,
    };

    // Check if inner class is declared in outer
    // JADX Reference: SignatureProcessor.java:311-318
    if !inner_name.contains('.') {
        // Short name - check in inner classes
        return outer_class.inner_class_names.iter()
            .any(|n| n == inner_name);
    }

    // Full name - resolve and check parent
    if let Some(inner_class) = resolve_class(inner_name) {
        if inner_class.parent_class != outer_name {
            // Inner class not properly nested - would need fixing
            return false;
        }
    }

    true
}

/// Information about a class for inner type validation.
#[derive(Debug, Clone)]
pub struct InnerClassInfo {
    /// Fully qualified class name
    pub class_name: String,
    /// Parent class name (if inner class)
    pub parent_class: String,
    /// Names of inner classes declared in this class
    pub inner_class_names: Vec<String>,
}

/// Process super type from signature.
///
/// JADX Reference: SignatureProcessor.java:61-68
/// processSuperType() validates that parsed supertype matches DEX supertype
pub fn process_super_type(
    parsed_type: &ArgType,
    dex_super_type: &ArgType,
    class_type: &ArgType,
    compare_types: impl Fn(&ArgType, &ArgType) -> TypeCompareResult,
) -> Result<ArgType, &'static str> {
    // Check that super class is not same as this class
    // JADX Reference: SignatureProcessor.java:63-65
    if types_same_object(parsed_type, class_type) {
        return Err("Super class equals this class");
    }

    // Use best type between parsed and DEX
    // JADX Reference: SignatureProcessor.java:67
    Ok(best_type(parsed_type, dex_super_type, compare_types))
}

/// Check if two types refer to same object (ignoring generics).
fn types_same_object(a: &ArgType, b: &ArgType) -> bool {
    let a_name = match a {
        ArgType::Object(n) => Some(n.as_str()),
        ArgType::Generic { base, .. } => Some(base.as_str()),
        _ => None,
    };
    let b_name = match b {
        ArgType::Object(n) => Some(n.as_str()),
        ArgType::Generic { base, .. } => Some(base.as_str()),
        _ => None,
    };
    a_name.is_some() && a_name == b_name
}

/// Return the better type (parsed if valid, otherwise dex type).
///
/// JADX Reference: SignatureProcessor.java:136-141
fn best_type(
    parsed: &ArgType,
    dex: &ArgType,
    compare: impl Fn(&ArgType, &ArgType) -> TypeCompareResult,
) -> ArgType {
    if validate_cls_type(parsed) {
        parsed.clone()
    } else {
        dex.clone()
    }
}

/// Validate that a type is a valid class type.
///
/// JADX Reference: SignatureProcessor.java:143-152
fn validate_cls_type(arg_type: &ArgType) -> bool {
    match arg_type {
        ArgType::Object(_) | ArgType::Generic { .. } => true,
        _ => false,
    }
}

/// Process interfaces from signature.
///
/// JADX Reference: SignatureProcessor.java:73-93
/// processInterfaces() merges parsed interfaces with DEX interfaces
pub fn process_interfaces(
    parsed_interfaces: &[ArgType],
    dex_interfaces: &[ArgType],
    compare_types: impl Fn(&ArgType, &ArgType) -> TypeCompareResult + Copy,
) -> Vec<ArgType> {
    if parsed_interfaces.is_empty() {
        return dex_interfaces.to_vec();
    }

    let mut result = Vec::with_capacity(dex_interfaces.len());
    let count = parsed_interfaces.len().min(dex_interfaces.len());

    // Merge parsed with DEX interfaces
    // JADX Reference: SignatureProcessor.java:82-88
    for (i, dex_iface) in dex_interfaces.iter().enumerate() {
        if i < count {
            result.push(best_type(&parsed_interfaces[i], dex_iface, &compare_types));
        } else {
            result.push(dex_iface.clone());
        }
    }

    result
}

/// Check method argument types from signature against DEX types.
///
/// JADX Reference: SignatureProcessor.java:227-256
pub fn check_method_arg_types(
    parsed_args: &[ArgType],
    dex_args: &[ArgType],
    is_enum_class: bool,
    is_constructor: bool,
    compare_types: impl Fn(&ArgType, &ArgType) -> TypeCompareResult,
) -> Option<Vec<ArgType>> {
    if parsed_args.len() != dex_args.len() {
        // Count mismatch
        // JADX Reference: SignatureProcessor.java:231-246
        if is_enum_class {
            // Ignore for enums
            return None;
        }

        if is_constructor && !dex_args.is_empty() && !parsed_args.is_empty() {
            // Try adding synthetic arg for outer class
            // JADX Reference: SignatureProcessor.java:236-242
            let mut new_args = parsed_args.to_vec();
            new_args.insert(0, dex_args[0].clone());
            if new_args.len() == dex_args.len() {
                return Some(new_args);
            }
        }

        return None;
    }

    // Validate each argument type
    // JADX Reference: SignatureProcessor.java:247-254
    for (i, parsed_arg) in parsed_args.iter().enumerate() {
        let result = compare_types(parsed_arg, &dex_args[i]);
        if result == TypeCompareResult::Conflict {
            return None;
        }
    }

    Some(parsed_args.to_vec())
}

#[cfg(test)]
mod tests {
    use super::*;

    #[test]
    fn test_result_default() {
        let result = SignatureProcessorResult::default();
        assert_eq!(result.class_signatures_processed, 0);
        assert_eq!(result.method_signatures_processed, 0);
        assert!(result.warnings.is_empty());
    }

    #[test]
    fn test_validate_full_class_name() {
        assert!(validate_full_class_name("java.lang.String"));
        assert!(validate_full_class_name("MyClass"));
        assert!(validate_full_class_name("com.example.MyClass$Inner"));
        assert!(!validate_full_class_name(""));
        assert!(!validate_full_class_name("123Invalid"));
    }

    #[test]
    fn test_is_java_identifier_start() {
        assert!(is_java_identifier_start('a'));
        assert!(is_java_identifier_start('A'));
        assert!(is_java_identifier_start('_'));
        assert!(is_java_identifier_start('$'));
        assert!(!is_java_identifier_start('1'));
        assert!(!is_java_identifier_start('-'));
    }

    #[test]
    fn test_is_java_identifier_part() {
        assert!(is_java_identifier_part('a'));
        assert!(is_java_identifier_part('Z'));
        assert!(is_java_identifier_part('5'));
        assert!(is_java_identifier_part('_'));
        assert!(!is_java_identifier_part('-'));
        assert!(!is_java_identifier_part('.'));
    }

    #[test]
    fn test_collect_generic_types() {
        let mut types = HashSet::new();

        let generic = ArgType::Generic {
            base: "java.util.List".to_string(),
            params: vec![
                ArgType::TypeVariable {
                    name: "T".to_string(),
                    extend_types: vec![],
                },
            ],
        };

        collect_generic_types(&generic, &mut types);
        assert!(types.contains("T"));
    }

    #[test]
    fn test_fix_type_param_declarations() {
        let existing = vec![];
        let superclass = ArgType::Generic {
            base: "Base".to_string(),
            params: vec![
                ArgType::TypeVariable {
                    name: "T".to_string(),
                    extend_types: vec![],
                },
            ],
        };

        let fixed = fix_type_param_declarations(
            &existing,
            &superclass,
            &[],
            false,
            &[],
        );

        assert!(fixed.contains(&"T".to_string()));
    }

    #[test]
    fn test_process_interfaces() {
        let parsed = vec![
            ArgType::Generic {
                base: "List".to_string(),
                params: vec![ArgType::TypeVariable {
                    name: "T".to_string(),
                    extend_types: vec![],
                }],
            },
        ];
        let dex = vec![ArgType::Object("List".to_string())];

        let result = process_interfaces(
            &parsed,
            &dex,
            |_, _| TypeCompareResult::Equal,
        );

        assert_eq!(result.len(), 1);
        // Should prefer parsed (has generics)
        assert!(matches!(&result[0], ArgType::Generic { .. }));
    }

    #[test]
    fn test_check_method_arg_types_match() {
        let parsed = vec![ArgType::Int, ArgType::Boolean];
        let dex = vec![ArgType::Int, ArgType::Boolean];

        let result = check_method_arg_types(
            &parsed,
            &dex,
            false,
            false,
            |_, _| TypeCompareResult::Equal,
        );

        assert!(result.is_some());
    }

    #[test]
    fn test_check_method_arg_types_mismatch() {
        let parsed = vec![ArgType::Int];
        let dex = vec![ArgType::Int, ArgType::Boolean];

        let result = check_method_arg_types(
            &parsed,
            &dex,
            false,
            false,
            |_, _| TypeCompareResult::Equal,
        );

        assert!(result.is_none());
    }
}
