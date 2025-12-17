//! Kotlin Intrinsics variable name extraction
//!
//! Extracts parameter names from Kotlin compiler-generated `Intrinsics.checkNotNullParameter()`
//! and similar method calls. This is a fallback when Kotlin metadata is unavailable.

use std::collections::HashMap;
use dexterity_ir::{MethodData, InsnNode};
use dexterity_ir::instructions::{InsnType, InsnArg};

/// Kotlin Intrinsics method signatures that contain parameter names
const INTRINSICS_CLASS: &str = "Lkotlin/jvm/internal/Intrinsics;";
const CHECK_NOT_NULL_PARAMETER: &str = "checkNotNullParameter";
const CHECK_NOT_NULL_EXPRESSION_VALUE: &str = "checkNotNullExpressionValue";
const CHECK_PARAMETER_IS_NOT_NULL: &str = "checkParameterIsNotNull";

/// Context for Kotlin intrinsics processing
pub struct IntrinsicsContext {
    /// Map of method index to method signature (class, name, proto)
    pub method_signatures: HashMap<u32, (String, String, String)>,
    /// Map of string index to string value
    pub string_pool: HashMap<u32, String>,
}

impl IntrinsicsContext {
    pub fn new() -> Self {
        Self {
            method_signatures: HashMap::new(),
            string_pool: HashMap::new(),
        }
    }
}

impl Default for IntrinsicsContext {
    fn default() -> Self {
        Self::new()
    }
}

/// Process Kotlin Intrinsics calls in a method to extract parameter names
/// This version works without full DEX context by looking for const-string patterns
pub fn process_kotlin_intrinsics(method: &mut MethodData) {
    // Early exit checks
    if method.instructions.is_none() || method.arg_types.is_empty() {
        return;
    }

    let instructions = method.get_instructions();
    if instructions.is_empty() {
        return;
    }

    // Build a map of register -> const-string value by scanning instructions
    let string_map = build_const_string_map(instructions);

    // Scan instructions for Intrinsics call patterns
    let mut param_names_found = Vec::new();

    for (insn_idx, insn) in instructions.iter().enumerate() {
        if let InsnType::Invoke { args, .. } = &insn.insn_type {
            // Check for Intrinsics method call pattern
            // The invoke should have 2 args: (object_to_check, parameter_name_string)
            if args.len() >= 2 {
                // Check if second argument is a string that looks like a parameter name
                if let Some(param_name) = get_string_arg(&args[1], &string_map, insn_idx, instructions) {
                    // Validate it looks like a parameter name (not an expression like "foo.bar()")
                    if looks_like_param_name(&param_name) {
                        // First argument is the parameter value (register)
                        if let InsnArg::Register(reg) = &args[0] {
                            // Map register to parameter index
                            if let Some(param_idx) = map_reg_to_param(reg.reg_num, method) {
                                param_names_found.push((param_idx, param_name));
                            }
                        }
                    }
                }
            }
        }
    }

    // Apply found parameter names
    for (param_idx, param_name) in param_names_found {
        if param_idx < method.arg_names.len() && method.arg_names[param_idx].is_none() {
            // Validate and transform the name
            if let Some(cleaned_name) = clean_kotlin_param_name(&param_name) {
                method.arg_names[param_idx] = Some(cleaned_name);
                tracing::debug!(
                    "Extracted parameter {} name from Intrinsics: {}",
                    param_idx,
                    &method.arg_names[param_idx].as_ref().unwrap()
                );
            }
        }
    }
}

/// Process Kotlin Intrinsics with full DEX context
pub fn process_kotlin_intrinsics_with_context(method: &mut MethodData, ctx: &IntrinsicsContext) {
    // Early exit checks
    if method.instructions.is_none() || method.arg_types.is_empty() {
        return;
    }

    let instructions = method.get_instructions();
    if instructions.is_empty() {
        return;
    }

    // Scan instructions for Intrinsics calls
    let mut param_names_found = Vec::new();

    for (insn_idx, insn) in instructions.iter().enumerate() {
        if let InsnType::Invoke { method_idx, args, .. } = &insn.insn_type {
            // Check if this is a Kotlin Intrinsics call
            if let Some((class, name, _proto)) = ctx.method_signatures.get(method_idx) {
                if class == INTRINSICS_CLASS && is_intrinsics_check_method(name) {
                    // Try to extract parameter name
                    if args.len() >= 2 {
                        if let Some(param_name) = get_string_from_context(&args[1], insn_idx, instructions, ctx) {
                            if let InsnArg::Register(reg) = &args[0] {
                                if let Some(param_idx) = map_reg_to_param(reg.reg_num, method) {
                                    param_names_found.push((param_idx, param_name));
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    // Apply found parameter names
    for (param_idx, param_name) in param_names_found {
        if param_idx < method.arg_names.len() && method.arg_names[param_idx].is_none() {
            if let Some(cleaned_name) = clean_kotlin_param_name(&param_name) {
                method.arg_names[param_idx] = Some(cleaned_name);
            }
        }
    }
}

/// Check if method name is a Kotlin Intrinsics check method
fn is_intrinsics_check_method(name: &str) -> bool {
    name == CHECK_NOT_NULL_PARAMETER
        || name == CHECK_NOT_NULL_EXPRESSION_VALUE
        || name == CHECK_PARAMETER_IS_NOT_NULL
}

/// Build a map of register -> string value from const-string instructions
fn build_const_string_map(instructions: &[InsnNode]) -> HashMap<u16, String> {
    let mut map = HashMap::new();

    for insn in instructions {
        if let InsnType::ConstString { dest, string_idx } = &insn.insn_type {
            // Store the string index as a placeholder - we'd need DEX context for actual value
            // For now, use a naming pattern that indicates this is from const-string
            map.insert(dest.reg_num, format!("__str_{}", string_idx));
        }
    }

    map
}

/// Get string value from an instruction argument
fn get_string_arg(
    arg: &InsnArg,
    string_map: &HashMap<u16, String>,
    insn_idx: usize,
    instructions: &[InsnNode],
) -> Option<String> {
    match arg {
        InsnArg::String(idx) => Some(format!("__str_{}", idx)),
        InsnArg::Register(reg) => {
            // First check our prebuilt map
            if let Some(s) = string_map.get(&reg.reg_num) {
                return Some(s.clone());
            }
            // Fall back to backwards scan
            find_const_string_for_reg(reg.reg_num, insn_idx, instructions)
        }
        _ => None,
    }
}

/// Get string from context with full DEX data
fn get_string_from_context(
    arg: &InsnArg,
    insn_idx: usize,
    instructions: &[InsnNode],
    ctx: &IntrinsicsContext,
) -> Option<String> {
    match arg {
        InsnArg::String(idx) => ctx.string_pool.get(&(*idx as u32)).cloned(),
        InsnArg::Register(reg) => {
            // Find const-string that loaded this register
            for i in (0..insn_idx).rev() {
                if let InsnType::ConstString { dest, string_idx } = &instructions[i].insn_type {
                    if dest.reg_num == reg.reg_num {
                        return ctx.string_pool.get(&(*string_idx as u32)).cloned();
                    }
                }
            }
            None
        }
        _ => None,
    }
}

/// Check if a string looks like a parameter name (vs. an expression message)
fn looks_like_param_name(s: &str) -> bool {
    // Skip expression-like strings
    if s.contains('.') || s.contains('(') || s.contains(' ') {
        return false;
    }
    // Must be a valid identifier
    if s.is_empty() || s.len() > 64 {
        return false;
    }
    // First char must be letter, underscore, or $
    let first = s.chars().next().unwrap();
    if !first.is_alphabetic() && first != '_' && first != '$' {
        return false;
    }
    true
}

/// Extract string literal from an instruction argument
/// Handles both direct const-string and indirect static field references
fn extract_string_from_arg(arg: &InsnArg, insn_idx: usize, instructions: &[InsnNode]) -> Option<String> {
    match arg {
        // Direct string constant
        InsnArg::String(string_idx) => {
            // In real implementation, would resolve string from DEX
            // For now, return placeholder
            Some(format!("param_{}", string_idx))
        }
        // String in a register - look backwards for const-string
        InsnArg::Register(reg) => find_const_string_for_reg(reg.reg_num, insn_idx, instructions),
        _ => None,
    }
}

/// Find a const-string instruction that loaded into the given register
fn find_const_string_for_reg(reg: u16, insn_idx: usize, instructions: &[InsnNode]) -> Option<String> {
    // Look backwards from current instruction
    for i in (0..insn_idx).rev() {
        let insn = &instructions[i];

        // Look for const-string instructions
        if let InsnType::ConstString { dest, string_idx } = &insn.insn_type {
            if dest.reg_num == reg {
                // Found the const-string that loaded into this register
                // In real implementation, would resolve string from DEX
                return Some(format!("param_{}", string_idx));
            }
        }

        // Also check for move instructions that might have copied the value
        if let InsnType::Move { dest, src } = &insn.insn_type {
            if dest.reg_num == reg {
                // Register was reassigned, check if source is the same register
                if let InsnArg::Register(src_reg) = src {
                    if src_reg.reg_num == reg {
                        return None; // Self-assignment, stop
                    }
                }
                // Continue looking backwards - register was reassigned
            }
        }
    }

    None
}

/// Map a register number to a parameter index
/// Accounts for 'this' register in instance methods
fn map_reg_to_param(reg: u16, method: &MethodData) -> Option<usize> {
    let first_param_reg = method.first_arg_reg();

    if reg < first_param_reg {
        return None; // Local variable, not parameter
    }

    // Calculate offset from first parameter register
    let offset = reg - first_param_reg;

    // Skip 'this' for instance methods
    if !method.is_static() {
        if offset == 0 {
            return None; // 'this' register
        }
        return Some((offset - 1) as usize);
    }

    Some(offset as usize)
}

/// Clean and validate Kotlin parameter name
/// Removes $ prefixes added by Kotlin compiler
fn clean_kotlin_param_name(name: &str) -> Option<String> {
    if name.is_empty() || name.len() > 64 {
        return None;
    }

    // Remove $ prefixes used by Kotlin
    let cleaned = if name.starts_with("$this$") {
        // Lambda receiver: $this$functionName → functionName
        name[6..].to_string()
    } else if name.starts_with("$receiver") {
        // Extension receiver: $receiver → receiver
        "receiver".to_string()
    } else if name.starts_with("$") {
        // Other $ prefixes: $name → name
        name[1..].to_string()
    } else {
        // No prefix, keep as-is
        name.to_string()
    };

    // Validate identifier
    if is_valid_identifier(&cleaned) {
        Some(cleaned)
    } else {
        None
    }
}

/// Check if a string is a valid Java identifier
fn is_valid_identifier(name: &str) -> bool {
    if name.is_empty() {
        return false;
    }

    let mut chars = name.chars();
    if let Some(first) = chars.next() {
        // First character must be letter or underscore
        if !first.is_alphabetic() && first != '_' {
            return false;
        }
    }

    // Remaining characters must be alphanumeric or underscore
    chars.all(|c| c.is_alphanumeric() || c == '_')
}

#[cfg(test)]
mod tests {
    use super::*;

    #[test]
    fn test_clean_kotlin_param_name() {
        assert_eq!(
            clean_kotlin_param_name("$this$map"),
            Some("map".to_string())
        );
        assert_eq!(
            clean_kotlin_param_name("$receiver"),
            Some("receiver".to_string())
        );
        assert_eq!(clean_kotlin_param_name("userName"), Some("userName".to_string()));
        assert_eq!(clean_kotlin_param_name(""), None);
        assert_eq!(clean_kotlin_param_name("123invalid"), None);
    }

    #[test]
    fn test_is_valid_identifier() {
        assert!(is_valid_identifier("valid_name"));
        assert!(is_valid_identifier("_private"));
        assert!(is_valid_identifier("CamelCase"));
        assert!(!is_valid_identifier("123invalid"));
        assert!(!is_valid_identifier(""));
        assert!(!is_valid_identifier("invalid-name"));
    }
}
