//! Kotlin Intrinsics variable name extraction
//!
//! Extracts parameter names from Kotlin compiler-generated `Intrinsics.checkNotNullParameter()`
//! and similar method calls. This is a fallback when Kotlin metadata is unavailable.

use std::collections::HashSet;
use jadx_ir::{MethodData, InsnNode};
use jadx_ir::instructions::{InsnType, InsnArg};

/// Process Kotlin Intrinsics calls in a method to extract parameter names
pub fn process_kotlin_intrinsics(method: &mut MethodData) {
    // Early exit checks
    if method.instructions.is_none() || method.arg_types.is_empty() {
        return;
    }

    let instructions = method.get_instructions();
    if instructions.is_empty() {
        return;
    }

    // Find Intrinsics method indices to look for
    let intrinsics_methods = find_intrinsics_methods();
    if intrinsics_methods.is_empty() {
        return; // Intrinsics class not in this DEX
    }

    // Scan instructions for Intrinsics calls
    let mut param_names_found = Vec::new();

    for (insn_idx, insn) in instructions.iter().enumerate() {
        if let InsnType::Invoke { method_idx, args, .. } = &insn.insn_type {
            // Check if this is an Intrinsics call
            if !intrinsics_methods.contains(&method_idx) {
                continue;
            }

            // Try to extract parameter name from the call
            // Pattern: Intrinsics.checkNotNullParameter(register, "paramName")
            //          Intrinsics.checkNotNullParameter(register, "paramName", "className")
            if args.len() >= 2 {
                // Second argument should be the parameter name string
                if let Some(param_name) = extract_string_from_arg(&args[1], insn_idx, instructions) {
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

/// Find kotlin.jvm.internal.Intrinsics methods in DEX
/// Returns method indices of Intrinsics check methods
fn find_intrinsics_methods() -> HashSet<u32> {
    // Hardcoded method indices - in production this would query DEX
    // These are placeholder values; real implementation would search DEX
    // For now, we return an empty set (no Intrinsics methods to find)
    // The actual matching happens by signature in production
    HashSet::new()
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
