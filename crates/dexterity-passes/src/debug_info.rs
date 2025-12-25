//! Debug Info Visitors
//!
//! JADX Clone: jadx-core/src/main/java/jadx/core/dex/visitors/debuginfo/
//! - DebugInfoAttachVisitor.java (199 lines)
//! - DebugInfoApplyVisitor.java (243 lines)
//! Original Author: Skylot (skylot@gmail.com)
//! Clone Date: Dec 2025
//!
//! Two-phase debug info processing:
//! 1. **Attach phase** (before SSA): Attaches source line numbers and local variable
//!    debug info to instructions based on DEX debug_info_item.
//! 2. **Apply phase** (after SSA/type inference): Applies debug info to SSA variables,
//!    fixing types and names where possible.
//!
//! ## Debug Info Sources
//! - Source line mapping: offset -> line number
//! - Local variable info: register, start/end offset, name, type, signature

use std::collections::{HashMap, HashSet};

use dexterity_ir::attributes::AFlag;
use dexterity_ir::instructions::InsnNode;
use dexterity_ir::{DebugInfo, LocalVar};

/// Result of debug info attach phase
#[derive(Debug, Default)]
pub struct DebugInfoAttachResult {
    /// Number of source lines attached
    pub lines_attached: usize,
    /// Number of local vars attached
    pub local_vars_attached: usize,
    /// Method source line (from first instruction)
    pub method_source_line: Option<u32>,
    /// Warning if debug lines are unreliable
    pub lines_warning: Option<String>,
}

/// Result of debug info apply phase
#[derive(Debug, Default)]
pub struct DebugInfoApplyResult {
    /// Number of SSA vars with debug info applied
    pub vars_applied: usize,
    /// Number of phi instruction names fixed
    pub phi_names_fixed: usize,
    /// Number of return lines fixed
    pub return_lines_fixed: usize,
    /// Warnings encountered
    pub warnings: Vec<String>,
}

// ============================================================================
// DEBUG INFO ATTACH VISITOR
// ============================================================================

/// Attach debug info to instructions.
///
/// JADX Reference: DebugInfoAttachVisitor.java:36-47
pub fn attach_debug_info(
    instructions: &mut [InsnNode],
    debug_info: &DebugInfo,
) -> DebugInfoAttachResult {
    let mut result = DebugInfoAttachResult::default();

    // Attach source lines
    // JADX Reference: DebugInfoAttachVisitor.java:51
    attach_source_lines(instructions, &debug_info.line_numbers, &mut result);

    // Attach local var debug info
    // JADX Reference: DebugInfoAttachVisitor.java:52
    attach_local_var_debug_info(instructions, &debug_info.local_vars, &mut result);

    // Set method source line from first instruction
    // JADX Reference: DebugInfoAttachVisitor.java:53
    result.method_source_line = set_method_source_line(instructions);

    result
}

/// Attach source line numbers to instructions.
///
/// JADX Reference: DebugInfoAttachVisitor.java:56-77
fn attach_source_lines(
    instructions: &mut [InsnNode],
    line_numbers: &[(u32, u32)],
    result: &mut DebugInfoAttachResult,
) {
    if line_numbers.is_empty() {
        return;
    }

    // Build HashMap for O(1) lookups
    let source_lines: HashMap<u32, u32> = line_numbers.iter().copied().collect();

    // Attach line numbers to instructions
    // JADX Reference: DebugInfoAttachVisitor.java:60-70
    for insn in instructions.iter_mut() {
        if let Some(&line) = source_lines.get(&insn.offset) {
            insn.source_line = Some(line);
            result.lines_attached += 1;
        }
    }

    // Verify debug lines quality
    // JADX Reference: DebugInfoAttachVisitor.java:71-76
    if let Some(warning) = verify_debug_lines(&source_lines) {
        result.lines_warning = Some(warning);
    }
}

/// Verify debug line numbers for reliability.
///
/// JADX Reference: DebugInfoAttachVisitor.java:79-98
fn verify_debug_lines(source_lines: &HashMap<u32, u32>) -> Option<String> {
    if source_lines.is_empty() {
        return None;
    }

    // Search min line in method
    // JADX Reference: DebugInfoAttachVisitor.java:81-84
    let min_line = *source_lines.values().min().unwrap_or(&u32::MAX);
    if min_line < 3 {
        return Some(format!(
            "Lines numbers was adjusted: min line is {}",
            min_line
        ));
    }

    // Count repeating lines - max 3 allowed (can occur in indexed for loops)
    // JADX Reference: DebugInfoAttachVisitor.java:89-96
    let mut line_counts: HashMap<u32, usize> = HashMap::new();
    for &line in source_lines.values() {
        *line_counts.entry(line).or_insert(0) += 1;
    }

    let repeating_lines: Vec<_> = line_counts
        .iter()
        .filter(|(_, &count)| count > 3)
        .map(|(&line, &count)| (line, count))
        .collect();

    if !repeating_lines.is_empty() {
        return Some(format!("Repeating lines: {:?}", repeating_lines));
    }

    None
}

/// Attach local variable debug info to instructions.
///
/// JADX Reference: DebugInfoAttachVisitor.java:100-140
fn attach_local_var_debug_info(
    instructions: &mut [InsnNode],
    local_vars: &[LocalVar],
    result: &mut DebugInfoAttachResult,
) {
    if local_vars.is_empty() {
        return;
    }

    for var in local_vars {
        let reg_num = var.reg;
        let start = var.start_addr;
        let end = var.end_addr;

        // Handle method arguments (start <= 0 or is_parameter flag)
        // JADX Reference: DebugInfoAttachVisitor.java:111-121
        let effective_start = if var.is_parameter || start == u32::MAX { 0 } else { start };

        // Attach to instructions in range
        // JADX Reference: DebugInfoAttachVisitor.java:122-136
        for insn in instructions.iter_mut() {
            let offset = insn.offset;
            if offset >= effective_start && offset <= end {
                // Would attach RegDebugInfoAttr to matching register args
                // For now, just count
                result.local_vars_attached += 1;
            }
        }
    }
}

/// Set method source line from first instruction with a line.
///
/// JADX Reference: DebugInfoAttachVisitor.java:188-198
fn set_method_source_line(instructions: &[InsnNode]) -> Option<u32> {
    for insn in instructions {
        if let Some(line) = insn.source_line {
            if line > 0 {
                // Method line is one before first instruction line
                return Some(line.saturating_sub(1));
            }
        }
    }
    None
}

/// Parse variable type from debug info, expanding generic signatures.
///
/// JADX Reference: DebugInfoAttachVisitor.java:153-169
pub fn get_var_type(var: &LocalVar) -> String {
    // If signature is present, try to parse it for generics
    // JADX Reference: DebugInfoAttachVisitor.java:156-167
    if let Some(ref signature) = var.signature {
        // Would parse generic signature here
        // For now, just return the signature if present
        return signature.clone();
    }

    // Otherwise return the basic type
    var.type_desc.clone()
}

// ============================================================================
// DEBUG INFO APPLY VISITOR
// ============================================================================

/// SSA variable representation for debug info application
#[derive(Debug, Clone)]
pub struct SSAVarDebugInfo {
    /// SSA variable index
    pub ssa_index: u32,
    /// Register number
    pub reg_num: u16,
    /// Assigned instruction offset
    pub assign_offset: Option<u32>,
    /// Use instruction offsets
    pub use_offsets: Vec<u32>,
    /// Current name (if set)
    pub name: Option<String>,
    /// Current type descriptor
    pub type_desc: Option<String>,
}

/// Apply debug info to SSA variables after type inference.
///
/// JADX Reference: DebugInfoApplyVisitor.java:52-62
pub fn apply_debug_info(
    ssa_vars: &mut [SSAVarDebugInfo],
    debug_info: &DebugInfo,
) -> DebugInfoApplyResult {
    let mut result = DebugInfoApplyResult::default();

    // Apply debug info to each SSA var
    // JADX Reference: DebugInfoApplyVisitor.java:68
    for ssa_var in ssa_vars.iter_mut() {
        if search_and_apply_var_debug_info(ssa_var, &debug_info.local_vars) {
            result.vars_applied += 1;
        }
    }

    // Fix lines for return instructions would be done separately
    // JADX Reference: DebugInfoApplyVisitor.java:70

    // Fix names for phi instructions would be done separately
    // JADX Reference: DebugInfoApplyVisitor.java:71

    result
}

/// Search and apply debug info to an SSA variable.
///
/// JADX Reference: DebugInfoApplyVisitor.java:74-84
fn search_and_apply_var_debug_info(
    ssa_var: &mut SSAVarDebugInfo,
    local_vars: &[LocalVar],
) -> bool {
    // Try to find matching debug info by offset
    // JADX Reference: DebugInfoApplyVisitor.java:86-112
    search_debug_info_by_offset(ssa_var, local_vars)
}

/// Search for debug info by instruction offset range.
///
/// JADX Reference: DebugInfoApplyVisitor.java:86-112
fn search_debug_info_by_offset(
    ssa_var: &mut SSAVarDebugInfo,
    local_vars: &[LocalVar],
) -> bool {
    // Find offset range for this SSA var
    let start_offset = ssa_var.assign_offset.unwrap_or(0);
    let end_offset = ssa_var
        .use_offsets
        .iter()
        .max()
        .copied()
        .unwrap_or(start_offset);
    let reg_num = ssa_var.reg_num;

    // Search for matching local var debug info
    // JADX Reference: DebugInfoApplyVisitor.java:98-111
    for local_var in local_vars {
        if local_var.reg == reg_num {
            // Handle parameters specially (start_addr == u32::MAX means parameter)
            let var_start = if local_var.is_parameter || local_var.start_addr == u32::MAX {
                0
            } else {
                local_var.start_addr
            };
            let var_end = local_var.end_addr;

            // Check if offset ranges overlap
            if is_inside(start_offset, var_start, var_end)
                || is_inside(end_offset, var_start, var_end)
            {
                // Apply debug info
                // JADX Reference: DebugInfoApplyVisitor.java:106-107
                let var_type = get_var_type(local_var);
                return apply_var_debug_info(ssa_var, &var_type, &local_var.name);
            }
        }
    }

    false
}

/// Check if a value is inside a range (inclusive).
///
/// JADX Reference: DebugInfoApplyVisitor.java:114-116
fn is_inside(value: u32, start: u32, end: u32) -> bool {
    start <= value && value <= end
}

/// Apply debug info (type and name) to an SSA variable.
///
/// JADX Reference: DebugInfoApplyVisitor.java:136-148
fn apply_var_debug_info(ssa_var: &mut SSAVarDebugInfo, type_desc: &str, name: &str) -> bool {
    // Apply type if compatible (would check with type inference)
    // JADX Reference: DebugInfoApplyVisitor.java:137-143
    ssa_var.type_desc = Some(type_desc.to_string());

    // Apply name if valid
    // JADX Reference: DebugInfoApplyVisitor.java:144-146
    if is_valid_and_printable(name) {
        ssa_var.name = Some(name.to_string());
    }

    true
}

/// Check if a name is valid and printable.
///
/// JADX Reference: NameMapper.isValidAndPrintable
fn is_valid_and_printable(name: &str) -> bool {
    if name.is_empty() {
        return false;
    }

    // Check first character is valid identifier start
    let first_char = name.chars().next().unwrap();
    if !first_char.is_alphabetic() && first_char != '_' && first_char != '$' {
        return false;
    }

    // Check all characters are valid identifier chars and printable
    for c in name.chars() {
        if !c.is_alphanumeric() && c != '_' && c != '$' {
            return false;
        }
        // Check printable (not control characters)
        if c.is_control() {
            return false;
        }
    }

    true
}

/// Fix names for phi instructions (propagate names from args to result).
///
/// JADX Reference: DebugInfoApplyVisitor.java:183-197
pub fn fix_names_for_phi_insns(
    phi_insns: &mut [(u32, Vec<u32>)], // (result_ssa, arg_ssas)
    ssa_vars: &mut [SSAVarDebugInfo],
) -> usize {
    let mut fixed = 0;

    for (result_ssa, arg_ssas) in phi_insns {
        // Collect unique names from result and args
        // JADX Reference: DebugInfoApplyVisitor.java:186-188
        let mut names: HashSet<String> = HashSet::new();

        if let Some(result_var) = ssa_vars.iter().find(|v| v.ssa_index == *result_ssa) {
            if let Some(ref name) = result_var.name {
                names.insert(name.clone());
            }
        }

        for arg_ssa in arg_ssas.iter() {
            if let Some(arg_var) = ssa_vars.iter().find(|v| v.ssa_index == *arg_ssa) {
                if let Some(ref name) = arg_var.name {
                    names.insert(name.clone());
                }
            }
        }

        // If exactly one name, apply to all
        // JADX Reference: DebugInfoApplyVisitor.java:189-194
        if names.len() == 1 {
            let name = names.into_iter().next().unwrap();

            // Apply to result
            if let Some(result_var) = ssa_vars.iter_mut().find(|v| v.ssa_index == *result_ssa) {
                result_var.name = Some(name.clone());
            }

            // Apply to args
            for arg_ssa in arg_ssas.iter() {
                if let Some(arg_var) = ssa_vars.iter_mut().find(|v| v.ssa_index == *arg_ssa) {
                    arg_var.name = Some(name.clone());
                }
            }

            fixed += 1;
        }
    }

    fixed
}

/// Fix source lines for synthesized return instructions.
///
/// JADX Reference: DebugInfoApplyVisitor.java:153-181
pub fn fix_lines_for_return(
    orig_return_insn: Option<&InsnNode>,
    new_return_insns: &mut [InsnNode],
) -> usize {
    let orig_return = match orig_return_insn {
        Some(insn) if insn.has_flag(AFlag::OrigReturn) => insn,
        _ => return 0,
    };

    let mut fixed = 0;

    for ret_insn in new_return_insns.iter_mut() {
        if !ret_insn.has_flag(AFlag::OrigReturn) {
            // Copy source line from original return
            // JADX Reference: DebugInfoApplyVisitor.java:178
            ret_insn.source_line = orig_return.source_line;
            fixed += 1;
        }
    }

    fixed
}

/// Process MethodParameters attribute for parameter names.
///
/// JADX Reference: DebugInfoApplyVisitor.java:217-242
pub fn process_method_parameters(
    param_names: &[String],
    method_args: &mut [SSAVarDebugInfo],
) -> usize {
    let mut applied = 0;

    // Apply names from MethodParameters attribute
    // JADX Reference: DebugInfoApplyVisitor.java:228-237
    for (param_name, arg) in param_names.iter().zip(method_args.iter_mut()) {
        if is_valid_and_printable(param_name) {
            arg.name = Some(param_name.clone());
            applied += 1;
        }
    }

    applied
}

#[cfg(test)]
mod tests {
    use super::*;

    #[test]
    fn test_is_valid_and_printable() {
        assert!(is_valid_and_printable("foo"));
        assert!(is_valid_and_printable("_bar"));
        assert!(is_valid_and_printable("$baz"));
        assert!(is_valid_and_printable("camelCase123"));

        assert!(!is_valid_and_printable(""));
        assert!(!is_valid_and_printable("123invalid"));
        assert!(!is_valid_and_printable("has space"));
        assert!(!is_valid_and_printable("has-hyphen"));
    }

    #[test]
    fn test_is_inside() {
        assert!(is_inside(5, 0, 10));
        assert!(is_inside(0, 0, 10));
        assert!(is_inside(10, 0, 10));
        assert!(!is_inside(11, 0, 10));
    }

    #[test]
    fn test_verify_debug_lines_min_line() {
        let mut lines = HashMap::new();
        lines.insert(0, 1); // Line 1 is suspicious (< 3)

        let warning = verify_debug_lines(&lines);
        assert!(warning.is_some());
        assert!(warning.unwrap().contains("min line is 1"));
    }

    #[test]
    fn test_verify_debug_lines_repeating() {
        let mut lines = HashMap::new();
        lines.insert(0, 10);
        lines.insert(1, 10);
        lines.insert(2, 10);
        lines.insert(3, 10);
        lines.insert(4, 10); // 5 times > 3 allowed

        let warning = verify_debug_lines(&lines);
        assert!(warning.is_some());
        assert!(warning.unwrap().contains("Repeating"));
    }

    #[test]
    fn test_get_var_type_with_signature() {
        let var = LocalVar {
            name: "list".to_string(),
            type_desc: "Ljava/util/List;".to_string(),
            signature: Some("Ljava/util/List<Ljava/lang/String;>;".to_string()),
            reg: 0,
            start_addr: 0,
            end_addr: 100,
            is_parameter: false,
            is_end: false,
        };

        let var_type = get_var_type(&var);
        assert!(var_type.contains("List<"));
    }

    #[test]
    fn test_search_debug_info_by_offset() {
        let local_vars = vec![LocalVar {
            name: "counter".to_string(),
            type_desc: "I".to_string(),
            signature: None,
            reg: 0,
            start_addr: 10,
            end_addr: 50,
            is_parameter: false,
            is_end: false,
        }];

        let mut ssa_var = SSAVarDebugInfo {
            ssa_index: 0,
            reg_num: 0,
            assign_offset: Some(15),
            use_offsets: vec![20, 30],
            name: None,
            type_desc: None,
        };

        let applied = search_debug_info_by_offset(&mut ssa_var, &local_vars);
        assert!(applied);
        assert_eq!(ssa_var.name, Some("counter".to_string()));
        assert_eq!(ssa_var.type_desc, Some("I".to_string()));
    }
}
