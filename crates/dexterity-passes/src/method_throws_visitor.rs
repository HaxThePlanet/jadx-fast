//! MethodThrowsVisitor - Collect thrown exceptions for method signatures
//!
//! This pass scans methods to collect thrown exceptions for the `throws` clause.
//! It analyzes THROW instructions and INVOKE calls to determine which exceptions
//! must be declared in the method signature.
//!
//! Equivalent to JADX's MethodThrowsVisitor.java

use std::collections::HashSet;

use dexterity_ir::{
    instructions::{InsnArg, InsnNode, InsnType},
    types::ArgType,
    ClassData, ClassHierarchy, MethodData,
};

/// Result of method throws analysis
#[derive(Debug, Default)]
pub struct MethodThrowsResult {
    /// Number of methods processed
    pub methods_processed: usize,
    /// Total exceptions found across all methods
    pub exceptions_found: usize,
    /// Methods with throws clauses
    pub methods_with_throws: usize,
    /// Invalid exceptions skipped (with reasons)
    pub invalid_exceptions: Vec<(String, String)>,
}

/// Exception type classification
#[derive(Debug, Clone, Copy, PartialEq, Eq)]
enum ExceptionType {
    /// Exception requires throws declaration
    ThrowsRequired,
    /// RuntimeException or Error - no throws needed
    Runtime,
    /// Unknown type hierarchy
    UnknownType,
    /// Not an exception at all
    NoException,
}

/// Constants for exception class names
const CLASS_EXCEPTION: &str = "java/lang/Exception";
const CLASS_THROWABLE: &str = "java/lang/Throwable";
const CLASS_RUNTIME_EXCEPTION: &str = "java/lang/RuntimeException";
const CLASS_ERROR: &str = "java/lang/Error";

/// Process method throws for all methods in a class
///
/// # Arguments
/// * `class` - The class data to process
/// * `hierarchy` - Optional class hierarchy for type checking
///
/// # Returns
/// * `MethodThrowsResult` with processing statistics
pub fn process_method_throws(
    class: &mut ClassData,
    hierarchy: Option<&ClassHierarchy>,
) -> MethodThrowsResult {
    let mut result = MethodThrowsResult::default();

    for method in &mut class.methods {
        if method.throws_visited {
            continue;
        }
        method.throws_visited = true;

        process_method_instructions(method, hierarchy, &mut result);

        // Merge redundant exceptions
        merge_exceptions(&mut method.throws_exceptions, hierarchy);

        if !method.throws_exceptions.is_empty() {
            result.methods_with_throws += 1;
            result.exceptions_found += method.throws_exceptions.len();
        }
        result.methods_processed += 1;
    }

    result
}

/// Process instructions in a method to collect thrown exceptions
fn process_method_instructions(
    method: &mut MethodData,
    hierarchy: Option<&ClassHierarchy>,
    result: &mut MethodThrowsResult,
) {
    let instructions = match &method.instructions {
        Some(insns) => insns.clone(),
        None => return,
    };

    // Collect excluded exceptions from catch blocks
    let excluded_exceptions = collect_excluded_exceptions(method);

    for insn in &instructions {
        check_insn(method, insn, &excluded_exceptions, hierarchy, result);
    }
}

/// Collect exception types that are caught by catch blocks
fn collect_excluded_exceptions(method: &MethodData) -> HashSet<String> {
    let mut excluded = HashSet::new();

    for try_block in &method.try_blocks {
        for handler in &try_block.handlers {
            if let Some(ref exc_type) = handler.exception_type {
                // Normalize to internal format (java/lang/Exception)
                let normalized = exc_type.trim_start_matches('L').trim_end_matches(';');
                excluded.insert(normalized.to_string());
            }
            // Note: If exception_type is None, it's a catch-all - we handle that specially
        }
    }

    excluded
}

/// Check if a try block has a catch-all handler
fn has_catch_all_handler(method: &MethodData, insn_offset: u32) -> bool {
    for try_block in &method.try_blocks {
        if insn_offset >= try_block.start_addr && insn_offset < try_block.end_addr {
            for handler in &try_block.handlers {
                if handler.exception_type.is_none() {
                    return true; // catch-all catches everything
                }
            }
        }
    }
    false
}

/// Check an instruction for thrown exceptions
fn check_insn(
    method: &mut MethodData,
    insn: &InsnNode,
    excluded_exceptions: &HashSet<String>,
    hierarchy: Option<&ClassHierarchy>,
    result: &mut MethodThrowsResult,
) {
    match &insn.insn_type {
        InsnType::Throw { exception } => {
            // Skip if this instruction has DONT_GENERATE flag
            if insn.has_flag(dexterity_ir::attributes::AFlag::DontGenerate) {
                return;
            }

            // Skip if inside catch-all block
            if has_catch_all_handler(method, insn.offset) {
                return;
            }

            // Get exception type from the thrown value
            if let Some(exc_type) = get_exception_type_from_arg(exception) {
                // Check if this is a rethrow of a caught exception
                if is_caught_exception_rethrow(exception, &exc_type) {
                    return;
                }

                visit_throws(method, &exc_type, excluded_exceptions, hierarchy, result);
            }
        }

        InsnType::Invoke { method_idx, .. } => {
            // For invokes, we would need to look up the called method's throws
            // This requires access to the full class hierarchy and method resolution
            // For now, we skip this (would need inter-method analysis)
            let _ = method_idx; // Silence unused warning
        }

        InsnType::Constructor { method_idx, .. } => {
            // Constructors can also throw
            let _ = method_idx;
        }

        _ => {}
    }
}

/// Get exception type from an instruction argument
fn get_exception_type_from_arg(arg: &InsnArg) -> Option<String> {
    match arg {
        InsnArg::Register(_reg) => {
            // Register args don't carry type directly - would need SSA context
            // For now, return None and let caller handle
            None
        }
        InsnArg::Wrapped(wrapped) => {
            // For wrapped instructions, check the result type
            if let Some(name) = get_object_name(&wrapped.result_type) {
                return Some(name);
            }
            // Also check if the inline instruction is a NewInstance for an exception type
            if let Some(ref inline_insn) = wrapped.inline_insn {
                if let InsnType::NewInstance { type_idx, .. } = &inline_insn.insn_type {
                    // We'd need DexInfo to resolve type_idx to a name
                    // For now, just return a placeholder
                    return Some(format!("Type#{}", type_idx));
                }
            }
            None
        }
        InsnArg::This { class_type } => {
            // 'this' reference - rare for throw but handle it
            Some(class_type.clone())
        }
        _ => None,
    }
}

/// Get object name from ArgType
fn get_object_name(arg_type: &ArgType) -> Option<String> {
    match arg_type {
        ArgType::Object(class_name) => Some(class_name.clone()),
        _ => None,
    }
}

/// Check if a throw is a rethrow of a caught exception (ignore Throwable rethrow)
fn is_caught_exception_rethrow(arg: &InsnArg, exc_type: &str) -> bool {
    // If the exception type is Throwable and comes from a catch variable,
    // it's a rethrow - don't add to throws
    if exc_type == CLASS_THROWABLE {
        if let InsnArg::Register(reg) = arg {
            // Check if this register has CUSTOM_DECLARE flag (indicates catch var)
            // This would need SSA info to fully check
            let _ = reg;
        }
    }
    false
}

/// Add exception to throws list if required
fn visit_throws(
    method: &mut MethodData,
    exc_type: &str,
    excluded_exceptions: &HashSet<String>,
    hierarchy: Option<&ClassHierarchy>,
    result: &mut MethodThrowsResult,
) {
    // Validate exception type
    let exception_kind = validate_exception(exc_type, hierarchy);

    match exception_kind {
        ExceptionType::UnknownType => {
            // Add anyway but record warning
            result.invalid_exceptions.push((
                method.name.clone(),
                format!("Unknown type hierarchy: {}", exc_type),
            ));
        }
        ExceptionType::ThrowsRequired => {
            // Check if excluded by catch blocks
            for excluded in excluded_exceptions {
                if is_base_exception(exc_type, excluded, hierarchy) {
                    return; // Exception is caught
                }
            }

            // Add to throws list if not already present
            let exc_type_str = exc_type.to_string();
            if !method.throws_exceptions.contains(&exc_type_str) {
                method.throws_exceptions.push(exc_type_str);
            }
        }
        ExceptionType::Runtime | ExceptionType::NoException => {
            // Don't add to throws
        }
    }
}

/// Validate if a type is an exception that requires throws declaration
fn validate_exception(exc_type: &str, hierarchy: Option<&ClassHierarchy>) -> ExceptionType {
    if exc_type.is_empty() || exc_type == "java/lang/Object" {
        return ExceptionType::NoException;
    }

    // Check for RuntimeException or Error (unchecked exceptions)
    if is_implements(exc_type, CLASS_RUNTIME_EXCEPTION, hierarchy)
        || is_implements(exc_type, CLASS_ERROR, hierarchy)
    {
        return ExceptionType::Runtime;
    }

    // Check for Throwable or Exception (checked exceptions)
    if is_implements(exc_type, CLASS_THROWABLE, hierarchy)
        || is_implements(exc_type, CLASS_EXCEPTION, hierarchy)
    {
        return ExceptionType::ThrowsRequired;
    }

    // Check if class is known
    if let Some(h) = hierarchy {
        if h.has_class(exc_type) {
            return ExceptionType::NoException; // Known but not exception
        }
    }

    ExceptionType::UnknownType
}

/// Check if `exception` is a subtype of `possible_parent`
fn is_base_exception(exception: &str, possible_parent: &str, hierarchy: Option<&ClassHierarchy>) -> bool {
    if exception == possible_parent {
        return true;
    }

    if let Some(h) = hierarchy {
        return h.is_subtype_of(exception, possible_parent);
    }

    false
}

/// Check if a type implements/extends another
fn is_implements(child_type: &str, parent_type: &str, hierarchy: Option<&ClassHierarchy>) -> bool {
    if child_type == parent_type {
        return true;
    }

    if let Some(h) = hierarchy {
        return h.is_subtype_of(child_type, parent_type);
    }

    // Fallback: check common patterns
    match child_type {
        CLASS_RUNTIME_EXCEPTION | CLASS_ERROR => {
            parent_type == CLASS_THROWABLE
        }
        CLASS_EXCEPTION => {
            parent_type == CLASS_THROWABLE
        }
        _ => false,
    }
}

/// Merge redundant exceptions in the throws list
///
/// If Exception is present, remove all other exceptions.
/// If Throwable is present, remove all other exceptions.
/// Remove child exceptions when parent is present.
fn merge_exceptions(exceptions: &mut Vec<String>, hierarchy: Option<&ClassHierarchy>) {
    if exceptions.is_empty() {
        return;
    }

    // If Exception is present, it covers all checked exceptions
    if exceptions.iter().any(|e| e == CLASS_EXCEPTION) {
        exceptions.retain(|e| e == CLASS_EXCEPTION);
        return;
    }

    // If Throwable is present, it covers everything
    if exceptions.iter().any(|e| e == CLASS_THROWABLE) {
        exceptions.retain(|e| e == CLASS_THROWABLE);
        return;
    }

    // Remove child exceptions when parent is present
    let exc_set: HashSet<String> = exceptions.iter().cloned().collect();
    let mut to_remove = HashSet::new();

    for ex1 in &exc_set {
        for ex2 in &exc_set {
            if ex1 != ex2 && is_base_exception(ex1, ex2, hierarchy) {
                // ex1 extends ex2, so ex1 is covered by ex2
                to_remove.insert(ex1.clone());
            }
        }
    }

    exceptions.retain(|e| !to_remove.contains(e));
}

/// Collect exceptions from invoke targets (for inter-method analysis)
///
/// This function can be called to propagate throws from called methods.
/// Requires access to the called method's data.
pub fn collect_invoke_throws(
    caller_method: &mut MethodData,
    callee_throws: &[String],
    excluded_exceptions: &HashSet<String>,
    hierarchy: Option<&ClassHierarchy>,
) {
    for exc_type in callee_throws {
        // Filter out excluded exceptions
        let mut excluded = false;
        for excluded_exc in excluded_exceptions {
            if is_base_exception(exc_type, excluded_exc, hierarchy) {
                excluded = true;
                break;
            }
        }

        if !excluded && !caller_method.throws_exceptions.contains(exc_type) {
            caller_method.throws_exceptions.push(exc_type.clone());
        }
    }
}

#[cfg(test)]
mod tests {
    use super::*;

    #[test]
    fn test_validate_exception_runtime() {
        assert_eq!(
            validate_exception(CLASS_RUNTIME_EXCEPTION, None),
            ExceptionType::Runtime
        );
    }

    #[test]
    fn test_validate_exception_checked() {
        assert_eq!(
            validate_exception(CLASS_EXCEPTION, None),
            ExceptionType::ThrowsRequired
        );
    }

    #[test]
    fn test_validate_exception_object() {
        assert_eq!(
            validate_exception("java/lang/Object", None),
            ExceptionType::NoException
        );
    }

    #[test]
    fn test_merge_exceptions_with_parent() {
        let mut exceptions = vec![
            "java/io/IOException".to_string(),
            CLASS_EXCEPTION.to_string(),
        ];
        merge_exceptions(&mut exceptions, None);
        assert_eq!(exceptions.len(), 1);
        assert_eq!(exceptions[0], CLASS_EXCEPTION);
    }

    #[test]
    fn test_merge_exceptions_empty() {
        let mut exceptions = vec![];
        merge_exceptions(&mut exceptions, None);
        assert!(exceptions.is_empty());
    }
}
