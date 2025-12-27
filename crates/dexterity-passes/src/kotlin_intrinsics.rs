//! Kotlin Intrinsics variable name extraction
//!
//! Extracts parameter names from Kotlin compiler-generated `Intrinsics.checkNotNullParameter()`
//! and similar method calls. This is a fallback when Kotlin metadata is unavailable.
//!
//! JADX Reference: jadx-core/src/main/java/jadx/core/dex/visitors/kotlin/ProcessKotlinInternals.java

use std::collections::HashMap;
use dexterity_ir::{MethodData, InsnNode};
use dexterity_ir::instructions::{InsnType, InsnArg};
use dexterity_ir::attributes::AFlag;

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
    /// P1.3 FIX: Map of field index to constant string value
    /// JADX Reference: ProcessKotlinInternals.java:164-172
    /// Used to revert SGET of inlined string constants back to their values
    pub field_constants: HashMap<u32, String>,
}

impl IntrinsicsContext {
    pub fn new() -> Self {
        Self {
            method_signatures: HashMap::new(),
            string_pool: HashMap::new(),
            field_constants: HashMap::new(),
        }
    }
}

impl Default for IntrinsicsContext {
    fn default() -> Self {
        Self::new()
    }
}

// ============================================================================
// JADX-Style Hide Intrinsics Option
// ============================================================================
// Cloned from JADX: ProcessKotlinInternals.java:63,76,134-136
// When enabled, marks Kotlin Intrinsics calls with DONT_GENERATE flag

/// Options for Kotlin intrinsics processing
/// JADX Reference: ProcessKotlinInternals.java:63,76
#[derive(Debug, Clone, Copy, Default)]
pub struct KotlinIntrinsicsOptions {
    /// Whether to hide (mark DONT_GENERATE) intrinsics calls after extracting names
    /// JADX Reference: ProcessKotlinInternals.java:76
    /// hideInsns = root.getArgs().getUseKotlinMethodsForVarNames() == UseKotlinMethodsForVarNames.APPLY_AND_HIDE
    pub hide_intrinsics: bool,
}

impl KotlinIntrinsicsOptions {
    /// Create with default settings (don't hide)
    pub fn new() -> Self {
        Self { hide_intrinsics: false }
    }

    /// Create with hide option enabled
    pub fn with_hide() -> Self {
        Self { hide_intrinsics: true }
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

/// Process Kotlin Intrinsics with options (including hide support)
/// JADX Reference: ProcessKotlinInternals.java:107-137
pub fn process_kotlin_intrinsics_with_options(
    method: &mut MethodData,
    ctx: &IntrinsicsContext,
    options: &KotlinIntrinsicsOptions,
) {
    // Early exit checks
    if method.instructions.is_none() || method.arg_types.is_empty() {
        return;
    }


    // First pass: collect information (immutable borrow)
    // JADX Reference: ProcessKotlinInternals.java:107-133
    let intrinsics_calls: Vec<(usize, usize, String)> = {
        let instructions = match &method.instructions {
            Some(insns) => insns,
            None => return,
        };

        if instructions.is_empty() {
            return;
        }

        // Compute first_param_reg and is_static once to avoid borrowing method later
        let first_param_reg = method.first_arg_reg();
        let is_static = method.is_static();

        let mut calls = Vec::new();
        let mut invoke_count = 0;
        let mut intrinsics_match_count = 0;
        for (insn_idx, insn) in instructions.iter().enumerate() {
            if let InsnType::Invoke { method_idx, args, .. } = &insn.insn_type {
                invoke_count += 1;
                // Check if this is a Kotlin Intrinsics call
                if let Some((class, name, _proto)) = ctx.method_signatures.get(method_idx) {
                    intrinsics_match_count += 1;
                    tracing::trace!("Found Intrinsics call: {}.{} with {} args", class, name, args.len());
                    if class == INTRINSICS_CLASS && is_intrinsics_check_method(name) {
                        // Try to extract parameter name
                        if args.len() >= 2 {
                            if let Some(param_name) = get_string_from_context_static(&args[1], insn_idx, instructions.as_slice(), ctx) {
                                if let InsnArg::Register(reg) = &args[0] {
                                    if let Some(idx) = compute_param_idx(reg.reg_num, first_param_reg, is_static) {
                                        calls.push((insn_idx, idx, param_name));
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        if intrinsics_match_count > 0 {
            tracing::debug!(
                "Method {} had {} invoke insns, {} matched Intrinsics, {} param names extracted",
                method.name, invoke_count, intrinsics_match_count, calls.len()
            );
        }
        calls
    };

    // Second pass: apply names and hide instructions (mutable borrow)
    // JADX Reference: ProcessKotlinInternals.java:134-136
    for (insn_idx, param_idx, param_name) in intrinsics_calls {
        let renamed = if param_idx < method.arg_names.len() && method.arg_names[param_idx].is_none() {
            if let Some(cleaned_name) = clean_kotlin_param_name(&param_name) {
                tracing::debug!(
                    "Kotlin Intrinsics: Extracted param[{}] name '{}' in method {}",
                    param_idx, cleaned_name, method.name
                );
                method.arg_names[param_idx] = Some(cleaned_name);
                true
            } else {
                false
            }
        } else {
            false
        };

        // JADX Reference: ProcessKotlinInternals.java:134-136
        // if (renamed && hideInsns) {
        //     insn.add(AFlag.DONT_GENERATE);
        // }
        if renamed && options.hide_intrinsics {
            if let Some(ref mut instructions) = method.instructions {
                if let Some(insn) = instructions.get_mut(insn_idx) {
                    insn.add_flag(AFlag::DontGenerate);
                    tracing::debug!(
                        "Hiding Kotlin Intrinsics call at offset {}",
                        insn.offset
                    );
                }
            }
        }
    }
}

/// Compute parameter index from register number
fn compute_param_idx(reg: u16, first_param_reg: u16, is_static: bool) -> Option<usize> {
    if reg < first_param_reg {
        return None;
    }
    let offset = reg - first_param_reg;
    if !is_static {
        if offset == 0 {
            return None;
        }
        return Some((offset - 1) as usize);
    }
    Some(offset as usize)
}

/// Static version of get_string_from_context (doesn't borrow method mutably)
/// P1.3 FIX: Also handles SGET of inlined string constants
/// JADX Reference: ProcessKotlinInternals.java:162-172
fn get_string_from_context_static(
    arg: &InsnArg,
    insn_idx: usize,
    instructions: &[InsnNode],
    ctx: &IntrinsicsContext,
) -> Option<String> {
    match arg {
        InsnArg::String(idx) => ctx.string_pool.get(&(*idx as u32)).cloned(),
        InsnArg::Register(reg) => {
            // Search backwards for const-string instruction that loads the parameter name
            for i in (0..insn_idx).rev() {
                // Pattern 1: const-string
                if let InsnType::ConstString { dest, string_idx } = &instructions[i].insn_type {
                    if dest.reg_num == reg.reg_num {
                        return ctx.string_pool.get(&(*string_idx as u32)).cloned();
                    }
                }
                // P1.3 FIX: Pattern 2: sget of inlined string constant
                // JADX Reference: ProcessKotlinInternals.java:164-172
                // if (insnType == InsnType.SGET) {
                //     // revert const field inline :(
                //     FieldInfo fieldInfo = (FieldInfo) ((IndexInsnNode) constInsn).getIndex();
                //     FieldNode fieldNode = mth.root().resolveField(fieldInfo);
                //     if (fieldNode != null) {
                //         String str = (String) fieldNode.get(JadxAttrType.CONSTANT_VALUE).getValue();
                //         ...
                //     }
                // }
                if let InsnType::StaticGet { dest, field_idx, .. } = &instructions[i].insn_type {
                    if dest.reg_num == reg.reg_num {
                        // Look up field's constant value
                        if let Some(const_str) = ctx.field_constants.get(field_idx) {
                            return Some(const_str.clone());
                        }
                    }
                }
            }
            None
        }
        _ => None,
    }
}

/// Static version of map_reg_to_param
fn map_reg_to_param_static(reg: u16, method: &MethodData) -> Option<usize> {
    let first_param_reg = method.first_arg_reg();
    if reg < first_param_reg {
        return None;
    }
    let offset = reg - first_param_reg;
    if !method.is_static() {
        if offset == 0 {
            return None;
        }
        return Some((offset - 1) as usize);
    }
    Some(offset as usize)
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
/// P1.3 FIX: Also handles SGET of inlined string constants
/// JADX Reference: ProcessKotlinInternals.java:162-172
fn get_string_from_context(
    arg: &InsnArg,
    insn_idx: usize,
    instructions: &[InsnNode],
    ctx: &IntrinsicsContext,
) -> Option<String> {
    match arg {
        InsnArg::String(idx) => ctx.string_pool.get(&(*idx as u32)).cloned(),
        InsnArg::Register(reg) => {
            // Find const-string or sget that loaded this register
            for i in (0..insn_idx).rev() {
                // Pattern 1: const-string
                if let InsnType::ConstString { dest, string_idx } = &instructions[i].insn_type {
                    if dest.reg_num == reg.reg_num {
                        return ctx.string_pool.get(&(*string_idx as u32)).cloned();
                    }
                }
                // P1.3 FIX: Pattern 2: sget of inlined string constant
                // JADX Reference: ProcessKotlinInternals.java:164-172
                if let InsnType::StaticGet { dest, field_idx, .. } = &instructions[i].insn_type {
                    if dest.reg_num == reg.reg_num {
                        if let Some(const_str) = ctx.field_constants.get(field_idx) {
                            return Some(const_str.clone());
                        }
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
