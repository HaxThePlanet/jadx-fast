//! MethodInvokeVisitor - Process method invocation overload resolution
//!
//! This pass runs after code shrinking and before simplification.
//! It handles overloaded method resolution by adding explicit casts
//! to method arguments when needed to disambiguate between overloads.
//!
//! Equivalent to JADX's MethodInvokeVisitor.java

use dexterity_ir::ArgType;

/// Result of method invoke processing
#[derive(Debug, Default)]
pub struct MethodInvokeResult {
    /// Number of invoke instructions processed
    pub invokes_processed: usize,
    /// Number of arguments that needed casts
    pub casts_added: usize,
    /// Vararg calls detected
    pub vararg_calls: usize,
}

/// Information about a method for overload resolution
#[derive(Debug, Clone)]
pub struct MethodDetails {
    /// Method name
    pub name: String,
    /// Declaring class
    pub declaring_class: String,
    /// Argument types
    pub arg_types: Vec<ArgType>,
    /// Return type
    pub return_type: ArgType,
    /// Whether this is a vararg method
    pub is_vararg: bool,
}

/// Type comparison result for overload resolution
#[derive(Debug, Clone, Copy, PartialEq, Eq)]
pub enum TypeCompareResult {
    /// Types are exactly equal
    Equal,
    /// First type is narrower (more specific) than second
    Narrow,
    /// First type is wider (more general) than second
    Wider,
    /// Types are related by generic narrowing
    NarrowByGeneric,
    /// Types are related by generic widening
    WiderByGeneric,
    /// Types are incompatible
    Conflict,
    /// Comparison is unknown/uncertain
    Unknown,
}

impl TypeCompareResult {
    pub fn is_equal(self) -> bool {
        matches!(self, TypeCompareResult::Equal)
    }

    pub fn is_narrow_or_equal(self) -> bool {
        matches!(self, TypeCompareResult::Equal | TypeCompareResult::Narrow | TypeCompareResult::NarrowByGeneric)
    }
}

/// Compare two types for overload resolution
///
/// Returns how `arg_type` relates to `param_type`:
/// - Equal: exact match
/// - Narrow: arg_type is a subtype of param_type
/// - Wider: arg_type is a supertype of param_type
pub fn compare_types(arg_type: &ArgType, param_type: &ArgType) -> TypeCompareResult {
    // Same type = equal
    if arg_type == param_type {
        return TypeCompareResult::Equal;
    }

    // Handle primitives
    if arg_type.is_primitive() && param_type.is_primitive() {
        return compare_primitive_types(arg_type, param_type);
    }

    // Handle objects
    match (arg_type, param_type) {
        (ArgType::Object(arg_cls), ArgType::Object(param_cls)) => {
            compare_object_types(arg_cls, param_cls)
        }
        (ArgType::Generic { base: arg_base, .. }, ArgType::Object(param_cls)) => {
            // Generic arg vs raw object param
            if arg_base == param_cls {
                TypeCompareResult::NarrowByGeneric
            } else {
                compare_object_types(arg_base, param_cls)
            }
        }
        (ArgType::Object(arg_cls), ArgType::Generic { base: param_base, .. }) => {
            // Raw object arg vs generic param
            if arg_cls == param_base {
                TypeCompareResult::WiderByGeneric
            } else {
                compare_object_types(arg_cls, param_base)
            }
        }
        (ArgType::Generic { base: arg_base, .. }, ArgType::Generic { base: param_base, .. }) => {
            if arg_base == param_base {
                // Same base class with different type params - treat as narrow by generic
                TypeCompareResult::NarrowByGeneric
            } else {
                compare_object_types(arg_base, param_base)
            }
        }
        (ArgType::Array(arg_inner), ArgType::Array(param_inner)) => {
            compare_types(arg_inner, param_inner)
        }
        // Unknown type can be assigned to anything
        (ArgType::Unknown, _) => TypeCompareResult::Narrow,
        _ => TypeCompareResult::Unknown,
    }
}

fn compare_primitive_types(arg_type: &ArgType, param_type: &ArgType) -> TypeCompareResult {
    use ArgType::*;

    // Primitive widening order: byte < short < int < long, float < double
    let order = |t: &ArgType| -> Option<i32> {
        match t {
            Byte => Some(1),
            Short => Some(2),
            Char => Some(2), // char is same width as short
            Int => Some(3),
            Long => Some(4),
            Float => Some(5),
            Double => Some(6),
            Boolean => Some(0),
            _ => None,
        }
    };

    match (order(arg_type), order(param_type)) {
        (Some(a), Some(p)) => {
            if a == p {
                TypeCompareResult::Equal
            } else if a < p {
                TypeCompareResult::Narrow
            } else {
                TypeCompareResult::Wider
            }
        }
        _ => TypeCompareResult::Conflict,
    }
}

fn compare_object_types(arg_cls: &str, param_cls: &str) -> TypeCompareResult {
    // Same class = equal
    if arg_cls == param_cls {
        return TypeCompareResult::Equal;
    }

    // java/lang/Object is the widest type
    if param_cls == "java/lang/Object" {
        return TypeCompareResult::Narrow;
    }
    if arg_cls == "java/lang/Object" {
        return TypeCompareResult::Wider;
    }

    // Without full class hierarchy, we can't determine relationship
    // In a full implementation, we'd check if arg_cls extends/implements param_cls
    TypeCompareResult::Unknown
}

/// Determine if method arguments need casts for overload resolution
///
/// # Arguments
/// * `invoke_args` - Types of the arguments being passed
/// * `target_method` - The method being called
/// * `overloaded_methods` - Other methods with the same name that could be called
///
/// # Returns
/// Vec of Option<ArgType> - Some(type) means cast needed, None means no cast needed
pub fn find_required_casts(
    invoke_args: &[ArgType],
    target_method: &MethodDetails,
    overloaded_methods: &[MethodDetails],
) -> Vec<Option<ArgType>> {
    let arg_count = invoke_args.len();
    let mut casts = vec![None; arg_count];

    // If no overloads, no casts needed
    if overloaded_methods.is_empty() {
        return casts;
    }

    // Try with no casts first
    if is_overload_resolved(target_method, overloaded_methods, invoke_args) {
        return casts;
    }

    // Replace unknown types with method parameter types
    let mut cast_types: Vec<ArgType> = invoke_args.to_vec();
    let mut changed = false;
    for (i, arg) in invoke_args.iter().enumerate() {
        if matches!(arg, ArgType::Unknown) {
            if let Some(param_type) = target_method.arg_types.get(i) {
                cast_types[i] = param_type.clone();
                changed = true;
            }
        }
    }

    if changed && is_overload_resolved(target_method, overloaded_methods, &cast_types) {
        return cast_types.into_iter()
            .zip(invoke_args.iter())
            .map(|(cast, orig)| if &cast != orig { Some(cast) } else { None })
            .collect();
    }

    // Replace non-generic types with method's generic types
    changed = false;
    for (i, arg) in cast_types.iter_mut().enumerate() {
        if let Some(param_type) = target_method.arg_types.get(i) {
            if !arg.is_generic() && param_type.is_generic() {
                *arg = param_type.clone();
                changed = true;
            }
        }
    }

    if changed && is_overload_resolved(target_method, overloaded_methods, &cast_types) {
        return cast_types.into_iter()
            .zip(invoke_args.iter())
            .map(|(cast, orig)| if &cast != orig { Some(cast) } else { None })
            .collect();
    }

    // If still not resolved, cast all args to method's parameter types
    target_method.arg_types.iter()
        .zip(invoke_args.iter())
        .map(|(param, arg)| {
            if param != arg {
                Some(param.clone())
            } else {
                None
            }
        })
        .collect()
}

/// Check if the target method is uniquely resolved given the argument types
fn is_overload_resolved(
    target: &MethodDetails,
    overloads: &[MethodDetails],
    arg_types: &[ArgType],
) -> bool {
    if overloads.is_empty() {
        return true;
    }

    // Collect all applicable methods (including target)
    let mut all_methods: Vec<&MethodDetails> = overloads.iter().collect();
    all_methods.push(target);

    // Filter to methods that accept these argument types
    let applicable: Vec<_> = all_methods.iter()
        .filter(|m| is_method_applicable(m, arg_types))
        .collect();

    // Resolved if exactly one method is applicable and it's our target
    applicable.len() == 1 && std::ptr::eq(*applicable[0], target)
}

/// Check if a method can accept the given argument types
fn is_method_applicable(method: &MethodDetails, arg_types: &[ArgType]) -> bool {
    if method.arg_types.len() != arg_types.len() {
        return false;
    }

    for (arg, param) in arg_types.iter().zip(method.arg_types.iter()) {
        let result = compare_types(arg, param);
        if !result.is_narrow_or_equal() && result != TypeCompareResult::WiderByGeneric {
            return false;
        }
    }

    true
}

/// Get the compiler's view of a variable type
///
/// This determines what type the Java compiler would infer for a value:
/// - Null literal → UNKNOWN_OBJECT (needs cast)
/// - Integer literal without explicit type → int
/// - Register → its declared type
pub fn get_compiler_var_type(arg_type: &ArgType, is_literal_zero: bool) -> ArgType {
    if is_literal_zero && (arg_type.is_object() || arg_type.is_array()) {
        // Null literal - compiler sees as unknown object type
        ArgType::Object("java/lang/Object".to_string())
    } else if arg_type.is_primitive() && !matches!(arg_type, ArgType::Boolean) {
        // Integer literal defaults to int (except boolean)
        ArgType::Int
    } else {
        arg_type.clone()
    }
}

/// Process method invocation for varargs detection
pub fn detect_vararg_call(param_types: &[ArgType]) -> bool {
    param_types.last()
        .map(|t| t.is_array())
        .unwrap_or(false)
}

/// Process an invoke for overload resolution
///
/// # Arguments
/// * `method_name` - Name of the method being called
/// * `declaring_class` - Class that declares the method
/// * `arg_types` - Types of the arguments
/// * `method_lookup` - Function to find overloaded methods
///
/// # Returns
/// MethodInvokeResult with stats about processing
pub fn process_invoke<F>(
    method_name: &str,
    declaring_class: &str,
    arg_types: &[ArgType],
    method_lookup: F,
) -> MethodInvokeResult
where
    F: Fn(&str, &str) -> Vec<MethodDetails>,
{
    let mut result = MethodInvokeResult::default();
    result.invokes_processed = 1;

    // Get overloaded methods
    let overloads = method_lookup(declaring_class, method_name);
    if overloads.is_empty() {
        return result;
    }

    // Create details for target method (use first overload as base)
    if let Some(target) = overloads.first() {
        // Find required casts
        let casts = find_required_casts(arg_types, target, &overloads[1..]);
        result.casts_added = casts.iter().filter(|c| c.is_some()).count();
    }

    result
}

#[cfg(test)]
mod tests {
    use super::*;

    #[test]
    fn test_compare_types_equal() {
        let int_type = ArgType::Int;
        assert_eq!(compare_types(&int_type, &int_type), TypeCompareResult::Equal);

        let obj_type = ArgType::Object("java/lang/String".to_string());
        assert_eq!(compare_types(&obj_type, &obj_type), TypeCompareResult::Equal);
    }

    #[test]
    fn test_compare_types_primitive_widening() {
        // byte < int
        assert_eq!(compare_types(&ArgType::Byte, &ArgType::Int), TypeCompareResult::Narrow);
        // int > byte
        assert_eq!(compare_types(&ArgType::Int, &ArgType::Byte), TypeCompareResult::Wider);
        // int < long
        assert_eq!(compare_types(&ArgType::Int, &ArgType::Long), TypeCompareResult::Narrow);
    }

    #[test]
    fn test_compare_types_object_to_object() {
        let string = ArgType::Object("java/lang/String".to_string());
        let obj = ArgType::Object("java/lang/Object".to_string());

        // String is narrower than Object (String extends Object)
        assert_eq!(compare_types(&string, &obj), TypeCompareResult::Narrow);
        // Object is wider than String
        assert_eq!(compare_types(&obj, &string), TypeCompareResult::Wider);
    }

    #[test]
    fn test_compare_types_unknown() {
        let unknown = ArgType::Unknown;
        let string = ArgType::Object("java/lang/String".to_string());

        // Unknown is assignable to any type (narrower)
        assert_eq!(compare_types(&unknown, &string), TypeCompareResult::Narrow);
    }

    #[test]
    fn test_find_required_casts_no_overloads() {
        let target = MethodDetails {
            name: "foo".to_string(),
            declaring_class: "Test".to_string(),
            arg_types: vec![ArgType::Int],
            return_type: ArgType::Void,
            is_vararg: false,
        };

        let args = vec![ArgType::Int];
        let casts = find_required_casts(&args, &target, &[]);
        assert!(casts.iter().all(|c| c.is_none()));
    }

    #[test]
    fn test_is_method_applicable() {
        let method = MethodDetails {
            name: "foo".to_string(),
            declaring_class: "Test".to_string(),
            arg_types: vec![ArgType::Object("java/lang/Object".to_string())],
            return_type: ArgType::Void,
            is_vararg: false,
        };

        // String is assignable to Object
        let args = vec![ArgType::Object("java/lang/String".to_string())];
        assert!(is_method_applicable(&method, &args));

        // Wrong arg count
        let args_wrong = vec![];
        assert!(!is_method_applicable(&method, &args_wrong));
    }

    #[test]
    fn test_detect_vararg() {
        // Array last param = vararg
        let params = vec![ArgType::Int, ArgType::Array(Box::new(ArgType::Object("java/lang/String".to_string())))];
        assert!(detect_vararg_call(&params));

        // Non-array last param = not vararg
        let params = vec![ArgType::Int, ArgType::Object("java/lang/String".to_string())];
        assert!(!detect_vararg_call(&params));
    }
}
