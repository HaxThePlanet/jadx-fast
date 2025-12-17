//! OverrideMethodVisitor - Mark override methods and revert type erasure
//!
//! This pass runs before type inference and rename visitors.
//! It traverses the class hierarchy to find which methods override parent methods,
//! marks them for @Override annotation, and fixes type erasure by restoring
//! generic type parameters from base methods.
//!
//! Equivalent to JADX's OverrideMethodVisitor.java

use std::collections::{HashMap, HashSet};

use dexterity_ir::{ArgType, ClassData, MethodData};

/// Information about overridden methods
#[derive(Debug, Clone)]
pub struct MethodOverrideAttr {
    /// List of methods that this method overrides (from parent classes/interfaces)
    pub override_list: Vec<OverriddenMethod>,
    /// The base method(s) at the end of the override chain
    pub base_methods: Vec<OverriddenMethod>,
    /// Whether the method should have @Override annotation
    pub should_annotate: bool,
    /// Whether renaming should be prevented (e.g., classpath method)
    pub dont_rename: bool,
}

/// Information about a method that is overridden
#[derive(Debug, Clone)]
pub struct OverriddenMethod {
    /// Class containing the method
    pub declaring_class: String,
    /// Method name
    pub name: String,
    /// Method signature (param types)
    pub arg_types: Vec<ArgType>,
    /// Method return type
    pub return_type: ArgType,
    /// Whether this is from classpath (external, not in APK)
    pub is_classpath: bool,
}

/// Result of override analysis for a class
#[derive(Debug, Default)]
pub struct OverrideAnalysisResult {
    /// Map from method name+signature to override info
    pub method_overrides: HashMap<String, MethodOverrideAttr>,
    /// Methods whose return types were fixed
    pub return_types_fixed: usize,
    /// Methods whose arg types were fixed
    pub arg_types_fixed: usize,
}

/// Super types data for a class
#[derive(Debug)]
pub struct SuperTypesData {
    /// Ordered list of super types (classes and interfaces)
    pub super_types: Vec<ArgType>,
    /// Set of "end" types - classes at the end of the hierarchy chain
    pub end_types: HashSet<String>,
}

/// Collect all super types for a class (superclass and interfaces)
///
/// # Arguments
/// * `class` - The class to analyze
/// * `class_lookup` - Function to resolve a class by its type descriptor
///
/// # Returns
/// SuperTypesData with ordered super types and end types, or None if class has no parents
pub fn collect_super_types<F>(class: &ClassData, class_lookup: F) -> Option<SuperTypesData>
where
    F: Fn(&str) -> Option<ClassData>,
{
    let mut super_types = Vec::new();
    let mut end_types = HashSet::new();
    let mut visited = HashSet::new();

    // Process superclass
    if let Some(superclass) = &class.superclass {
        if superclass != "java/lang/Object" {
            add_super_type(
                &ArgType::Object(superclass.clone()),
                &mut super_types,
                &mut end_types,
                &mut visited,
                &class_lookup,
            );
        }
    }

    // Process interfaces
    for iface in &class.interfaces {
        add_super_type(
            iface,
            &mut super_types,
            &mut end_types,
            &mut visited,
            &class_lookup,
        );
    }

    if super_types.is_empty() {
        return None;
    }

    // If no end types found, current class is the end
    if end_types.is_empty() {
        end_types.insert(class.class_type.clone());
    }

    Some(SuperTypesData { super_types, end_types })
}

fn add_super_type<F>(
    super_type: &ArgType,
    super_types: &mut Vec<ArgType>,
    end_types: &mut HashSet<String>,
    visited: &mut HashSet<String>,
    class_lookup: &F,
) -> bool
where
    F: Fn(&str) -> Option<ClassData>,
{
    // Get type name
    let type_name = match super_type {
        ArgType::Object(name) => name,
        ArgType::Generic { base, .. } => base,
        _ => return false,
    };

    // Skip java/lang/Object
    if type_name == "java/lang/Object" {
        return false;
    }

    // Prevent infinite loops
    if !visited.insert(type_name.clone()) {
        return false;
    }

    // Add to super types list
    super_types.push(super_type.clone());

    // Try to resolve the class
    if let Some(parent_class) = class_lookup(type_name) {
        let mut found_parents = false;

        // Process parent's superclass
        if let Some(superclass) = &parent_class.superclass {
            if superclass != "java/lang/Object" {
                if add_super_type(
                    &ArgType::Object(superclass.clone()),
                    super_types,
                    end_types,
                    visited,
                    class_lookup,
                ) {
                    found_parents = true;
                }
            }
        }

        // Process parent's interfaces
        for iface in &parent_class.interfaces {
            if add_super_type(iface, super_types, end_types, visited, class_lookup) {
                found_parents = true;
            }
        }

        if !found_parents {
            // No more parents - this is an end type
            end_types.insert(type_name.clone());
        }

        true
    } else {
        // Class not found - treat as end type
        end_types.insert(type_name.clone());
        true
    }
}

/// Find overridden methods for a method
///
/// # Arguments
/// * `method` - The method to check
/// * `super_data` - Super type information for the class
/// * `class_lookup` - Function to resolve classes
///
/// # Returns
/// MethodOverrideAttr if method overrides something, None otherwise
pub fn find_overridden_methods<F>(
    method: &MethodData,
    class: &ClassData,
    super_data: &SuperTypesData,
    class_lookup: F,
) -> Option<MethodOverrideAttr>
where
    F: Fn(&str) -> Option<ClassData>,
{
    // Skip constructors, static methods, and private methods
    if method.is_constructor() || method.is_class_init() ||
       method.is_static() || method.is_private() {
        return None;
    }

    let signature = make_method_signature(method);
    let mut override_list = Vec::new();
    let mut base_methods = Vec::new();
    let mut dont_rename = false;

    for super_type in &super_data.super_types {
        let super_class_name = match super_type {
            ArgType::Object(name) => name,
            ArgType::Generic { base, .. } => base,
            _ => continue,
        };

        if let Some(parent_class) = class_lookup(super_class_name) {
            // Search for matching method in parent
            if let Some(parent_method) = find_matching_method(&parent_class, method, &signature) {
                // Check visibility
                if is_method_visible(&parent_method, class, &parent_class) {
                    let overridden = OverriddenMethod {
                        declaring_class: parent_class.class_type.clone(),
                        name: parent_method.name.clone(),
                        arg_types: parent_method.arg_types.clone(),
                        return_type: parent_method.return_type.clone(),
                        is_classpath: false,
                    };
                    override_list.push(overridden.clone());

                    // Check if this is an end type (base method)
                    if super_data.end_types.contains(super_class_name) {
                        base_methods.push(overridden);
                    }
                }
            }
        } else {
            // Parent class not found (probably classpath)
            // Add as potential override (treat as classpath)
            dont_rename = true;
        }
    }

    if override_list.is_empty() {
        return None;
    }

    Some(MethodOverrideAttr {
        override_list,
        base_methods,
        should_annotate: true,
        dont_rename,
    })
}

/// Create a method signature string for matching (name + param types)
pub fn make_method_signature(method: &MethodData) -> String {
    let mut sig = method.name.clone();
    sig.push('(');
    for (i, arg) in method.arg_types.iter().enumerate() {
        if i > 0 {
            sig.push(',');
        }
        sig.push_str(&arg_type_to_descriptor(arg));
    }
    sig.push(')');
    sig
}

fn arg_type_to_descriptor(arg_type: &ArgType) -> String {
    match arg_type {
        ArgType::Void => "V".to_string(),
        ArgType::Boolean => "Z".to_string(),
        ArgType::Byte => "B".to_string(),
        ArgType::Short => "S".to_string(),
        ArgType::Char => "C".to_string(),
        ArgType::Int => "I".to_string(),
        ArgType::Long => "J".to_string(),
        ArgType::Float => "F".to_string(),
        ArgType::Double => "D".to_string(),
        ArgType::Object(name) => format!("L{};", name),
        ArgType::Array(inner) => format!("[{}", arg_type_to_descriptor(inner)),
        ArgType::Generic { base, .. } => format!("L{};", base),
        ArgType::TypeVariable(name) => format!("T{};", name),
        ArgType::Wildcard { .. } => "*".to_string(),
        ArgType::Unknown => "?".to_string(),
    }
}

/// Find a method in a class that matches the given signature
fn find_matching_method<'a>(
    parent_class: &'a ClassData,
    child_method: &MethodData,
    signature: &str,
) -> Option<&'a MethodData> {
    // First try exact match by full signature
    for method in &parent_class.methods {
        if !method.is_static() && make_method_signature(method) == *signature {
            return Some(method);
        }
    }

    // Then try matching by name and checking if return type is compatible
    let name = &child_method.name;
    for method in &parent_class.methods {
        if !method.is_static() && method.name == *name {
            let parent_sig = make_method_signature(method);
            // Check if signatures match up to return type
            if parent_sig.starts_with(&format!("{}(", name)) &&
               signature.starts_with(&format!("{}(", name)) {
                // Check if params match
                if signatures_compatible(&parent_sig, signature) {
                    return Some(method);
                }
            }
        }
    }

    None
}

fn signatures_compatible(parent_sig: &str, child_sig: &str) -> bool {
    // Extract parameter parts
    let parent_params = parent_sig.split('(').nth(1).and_then(|s| s.split(')').next());
    let child_params = child_sig.split('(').nth(1).and_then(|s| s.split(')').next());

    match (parent_params, child_params) {
        (Some(p), Some(c)) => p == c,
        _ => false,
    }
}

/// Check if a parent method is visible from the child class
fn is_method_visible(method: &MethodData, child_class: &ClassData, parent_class: &ClassData) -> bool {
    // Private methods are not visible
    if method.is_private() {
        return false;
    }

    // Public and protected are always visible
    if method.is_public() || method.is_protected() {
        return true;
    }

    // Package-private: check if same package
    let child_pkg = get_package(&child_class.class_type);
    let parent_pkg = get_package(&parent_class.class_type);
    child_pkg == parent_pkg
}

fn get_package(class_type: &str) -> &str {
    class_type.rsplit_once('/').map(|(pkg, _)| pkg).unwrap_or("")
}

/// Fix method return type based on base method
///
/// If the base method has a generic return type and the child's return type
/// is the type-erased version, update the child to use the generic type.
pub fn fix_method_return_type(
    method: &mut MethodData,
    base_method: &OverriddenMethod,
    super_data: &SuperTypesData,
) -> bool {
    if method.return_type == ArgType::Void {
        return false;
    }

    // If return types already match, nothing to do
    if method.return_type == base_method.return_type {
        return false;
    }

    // Check if base method has type variables that we can resolve
    if !base_method.return_type.contains_type_variable() {
        return false;
    }

    // Try to find a concrete type from super types
    for super_type in &super_data.super_types {
        if let ArgType::Generic { params, .. } = super_type {
            // If super type has generic params, we might be able to resolve
            if let Some(resolved) = try_resolve_type_var(&base_method.return_type, params) {
                if resolved != method.return_type && !resolved.contains_type_variable() {
                    method.return_type = resolved;
                    return true;
                }
            }
        }
    }

    false
}

/// Fix method argument types based on base method
pub fn fix_method_arg_types(
    method: &mut MethodData,
    base_method: &OverriddenMethod,
    super_data: &SuperTypesData,
) -> bool {
    if method.arg_types == base_method.arg_types {
        return false;
    }

    if method.arg_types.len() != base_method.arg_types.len() {
        return false;
    }

    let mut changed = false;
    let mut new_arg_types = method.arg_types.clone();

    for (i, (child_arg, base_arg)) in method.arg_types.iter()
        .zip(base_method.arg_types.iter())
        .enumerate()
    {
        if child_arg == base_arg {
            continue;
        }

        if !base_arg.contains_type_variable() {
            continue;
        }

        // Try to resolve from super types
        for super_type in &super_data.super_types {
            if let ArgType::Generic { params, .. } = super_type {
                if let Some(resolved) = try_resolve_type_var(base_arg, params) {
                    if resolved != *child_arg && !resolved.contains_type_variable() {
                        new_arg_types[i] = resolved;
                        changed = true;
                        break;
                    }
                }
            }
        }
    }

    if changed {
        method.arg_types = new_arg_types;
    }

    changed
}

fn try_resolve_type_var(type_with_var: &ArgType, type_params: &[ArgType]) -> Option<ArgType> {
    match type_with_var {
        ArgType::TypeVariable(name) => {
            // Simple heuristic: T -> first param, E -> second, etc.
            let index = match name.as_str() {
                "T" | "K" => 0,
                "E" | "V" => 1,
                "R" => 2,
                _ => return None,
            };
            type_params.get(index).cloned()
        }
        ArgType::Generic { base, params: inner_params } => {
            let mut resolved_params = Vec::new();
            let mut any_resolved = false;
            for param in inner_params {
                if let Some(resolved) = try_resolve_type_var(param, type_params) {
                    resolved_params.push(resolved);
                    any_resolved = true;
                } else {
                    resolved_params.push(param.clone());
                }
            }
            if any_resolved {
                Some(ArgType::Generic {
                    base: base.clone(),
                    params: resolved_params,
                })
            } else {
                None
            }
        }
        _ => None,
    }
}

/// Analyze all methods in a class for overrides
///
/// # Arguments
/// * `class` - The class to analyze
/// * `class_lookup` - Function to resolve classes by name
///
/// # Returns
/// Override analysis result with all override information
pub fn analyze_overrides<F>(class: &ClassData, class_lookup: F) -> OverrideAnalysisResult
where
    F: Fn(&str) -> Option<ClassData> + Clone,
{
    let mut result = OverrideAnalysisResult::default();

    // Collect super types
    let super_data = match collect_super_types(class, class_lookup.clone()) {
        Some(data) => data,
        None => return result,
    };

    // Analyze each method
    for method in &class.methods {
        if let Some(override_attr) = find_overridden_methods(method, class, &super_data, class_lookup.clone()) {
            let sig = make_method_signature(method);
            result.method_overrides.insert(sig, override_attr);
        }
    }

    result
}

/// Check if a method should have @Override annotation
pub fn should_add_override(method: &MethodData, override_info: Option<&MethodOverrideAttr>) -> bool {
    // Check explicit override info
    if let Some(info) = override_info {
        return info.should_annotate;
    }

    // Skip constructors, static, private
    if method.is_constructor() || method.is_class_init() ||
       method.is_static() || method.is_private() {
        return false;
    }

    // Heuristic: check common override method names
    let common_overrides = [
        "toString", "hashCode", "equals", "clone", "finalize",
        "compareTo", "compare", "run", "call", "apply", "accept",
        "get", "test", "onCreate", "onStart", "onResume", "onPause",
        "onStop", "onDestroy", "onClick", "onTouch",
    ];

    common_overrides.contains(&method.name.as_str())
}

#[cfg(test)]
mod tests {
    use super::*;

    #[test]
    fn test_make_method_signature() {
        let method = MethodData {
            name: "foo".to_string(),
            arg_types: vec![ArgType::Int, ArgType::Object("java/lang/String".to_string())],
            return_type: ArgType::Void,
            ..Default::default()
        };

        let sig = make_method_signature(&method);
        assert_eq!(sig, "foo(I,Ljava/lang/String;)");
    }

    #[test]
    fn test_get_package() {
        assert_eq!(get_package("com/example/MyClass"), "com/example");
        assert_eq!(get_package("MyClass"), "");
        assert_eq!(get_package("java/lang/String"), "java/lang");
    }

    #[test]
    fn test_should_add_override() {
        let method = MethodData {
            name: "toString".to_string(),
            access_flags: 0x0001, // public
            ..Default::default()
        };
        assert!(should_add_override(&method, None));

        let method_static = MethodData {
            name: "toString".to_string(),
            access_flags: 0x0009, // public static
            ..Default::default()
        };
        assert!(!should_add_override(&method_static, None));

        let method_private = MethodData {
            name: "toString".to_string(),
            access_flags: 0x0002, // private
            ..Default::default()
        };
        assert!(!should_add_override(&method_private, None));
    }

    #[test]
    fn test_arg_type_to_descriptor() {
        assert_eq!(arg_type_to_descriptor(&ArgType::Int), "I");
        assert_eq!(arg_type_to_descriptor(&ArgType::Long), "J");
        assert_eq!(arg_type_to_descriptor(&ArgType::Object("java/lang/String".to_string())), "Ljava/lang/String;");
        assert_eq!(arg_type_to_descriptor(&ArgType::Array(Box::new(ArgType::Int))), "[I");
    }

    #[test]
    fn test_signatures_compatible() {
        assert!(signatures_compatible("foo(I,Ljava/lang/String;)", "foo(I,Ljava/lang/String;)"));
        assert!(!signatures_compatible("foo(I)", "foo(J)"));
        assert!(!signatures_compatible("foo(I,I)", "foo(I)"));
    }
}
