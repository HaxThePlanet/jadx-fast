//! GenericTypesVisitor - Attach generic type info to constructors
//!
//! This pass runs after type inference and before code shrinking.
//! It attaches generic type information from variable types to constructor instructions,
//! enabling codegen to emit `new ArrayList<String>()` instead of raw `new ArrayList()`.
//!
//! Equivalent to JADX's GenericTypesVisitor.java

use std::collections::HashMap;

use dexterity_ir::{ArgType, ClassData};
use dexterity_ir::instructions::{InsnType, InsnArg, InvokeKind};

/// Result of generic types processing
#[derive(Debug, Default)]
pub struct GenericTypesResult {
    /// Number of constructors with generic info attached
    pub constructors_annotated: usize,
    /// Total constructors processed
    pub constructors_processed: usize,
}

/// Attach generic type information to constructor instructions
///
/// When a constructor's result variable has generic type parameters (e.g., `ArrayList<String>`),
/// this pass marks the constructor instruction so codegen can emit the type parameters.
///
/// # Arguments
/// * `class` - The class data containing methods to process
/// * `inferred_types` - Map of register -> inferred type from type inference
///
/// # Returns
/// A map from (method_idx, insn_idx) -> Vec<ArgType> for constructor generic types
pub fn attach_generic_types(
    class: &ClassData,
    inferred_types: &HashMap<(usize, u16), ArgType>,
) -> HashMap<(usize, usize), Vec<ArgType>> {
    let mut result = HashMap::new();

    for (method_idx, method) in class.methods.iter().enumerate() {
        // Skip abstract/native methods with no code
        if method.instructions.is_none() && method.insn_indices.is_empty() {
            continue;
        }

        // Get instructions either from direct storage or via indices
        let insns: Vec<_> = if let Some(ref insns) = method.instructions {
            insns.iter().collect()
        } else if !method.insn_indices.is_empty() {
            method.insn_indices.iter()
                .filter_map(|&idx| class.all_instructions.get(idx as usize))
                .collect()
        } else {
            continue;
        };

        for (insn_idx, insn) in insns.iter().enumerate() {
            // Only process constructor invocations (invoke-direct to <init>)
            if let InsnType::Invoke { kind, args, .. } = &insn.insn_type {
                // Check if this is a constructor call (Direct invoke, typically to <init>)
                if *kind != InvokeKind::Direct {
                    continue;
                }

                // Get first arg register (the receiver/result)
                if let Some(first_arg) = args.first() {
                    if let InsnArg::Register(reg_arg) = first_arg {
                        // Look up inferred type for this register
                        let key = (method_idx, reg_arg.reg_num);
                        if let Some(arg_type) = inferred_types.get(&key) {
                            // Check if type has generic parameters
                            if let Some(generic_types) = extract_generic_types(arg_type) {
                                if !generic_types.is_empty() {
                                    result.insert((method_idx, insn_idx), generic_types);
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    result
}

/// Extract generic type parameters from an ArgType
fn extract_generic_types(arg_type: &ArgType) -> Option<Vec<ArgType>> {
    match arg_type {
        ArgType::Generic { params, .. } => {
            if params.is_empty() {
                None
            } else {
                Some(params.clone())
            }
        }
        ArgType::Object(_) => None,
        ArgType::Array(inner) => extract_generic_types(inner),
        _ => None,
    }
}

/// Check if a class has generic type parameters
pub fn class_has_generics(class: &ClassData) -> bool {
    !class.type_parameters.is_empty()
}

/// Resolve generic types for a constructor call based on the result type
///
/// This is used at codegen time when we have the full type information
pub fn resolve_constructor_generics(
    result_type: &ArgType,
    constructor_class: &str,
    _class_data: Option<&ClassData>,
) -> Option<Vec<ArgType>> {
    // If result type has generics and matches the constructor class, use those
    match result_type {
        ArgType::Generic { base, params } => {
            // Check if base class matches constructor class
            let base_internal = base.replace('.', "/");
            if base_internal == constructor_class || base == constructor_class {
                if !params.is_empty() {
                    return Some(params.clone());
                }
            }
            None
        }
        _ => None,
    }
}

#[cfg(test)]
mod tests {
    use super::*;

    #[test]
    fn test_extract_generic_types() {
        // Simple object - no generics
        let simple = ArgType::Object("java/util/ArrayList".to_string());
        assert!(extract_generic_types(&simple).is_none());

        // Generic type with one parameter
        let generic = ArgType::Generic {
            base: "java/util/ArrayList".to_string(),
            params: vec![ArgType::Object("java/lang/String".to_string())],
        };
        let result = extract_generic_types(&generic).unwrap();
        assert_eq!(result.len(), 1);

        // Generic type with multiple parameters
        let map_generic = ArgType::Generic {
            base: "java/util/HashMap".to_string(),
            params: vec![
                ArgType::Object("java/lang/String".to_string()),
                ArgType::Object("java/lang/Integer".to_string()),
            ],
        };
        let result = extract_generic_types(&map_generic).unwrap();
        assert_eq!(result.len(), 2);
    }

    #[test]
    fn test_resolve_constructor_generics() {
        let result_type = ArgType::Generic {
            base: "java/util/ArrayList".to_string(),
            params: vec![ArgType::Object("java/lang/String".to_string())],
        };

        // Matching constructor class
        let generics = resolve_constructor_generics(&result_type, "java/util/ArrayList", None);
        assert!(generics.is_some());
        assert_eq!(generics.unwrap().len(), 1);

        // Non-matching constructor class
        let generics = resolve_constructor_generics(&result_type, "java/util/LinkedList", None);
        assert!(generics.is_none());
    }
}
