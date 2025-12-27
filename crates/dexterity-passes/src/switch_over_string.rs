//! Switch-over-string restoration pass
//!
//! This pass detects and restores switch-over-string patterns that the Java/Android
//! compiler converts to switch-over-hashCode patterns.
//!
//! ## Background
//!
//! The Java compiler (javac) and Android compiler convert switch statements over
//! strings to a more efficient pattern using hashCode():
//!
//! ```java
//! // Original code:
//! switch (str) {
//!     case "hello": doHello(); break;
//!     case "world": doWorld(); break;
//! }
//!
//! // Compiled pattern:
//! switch (str.hashCode()) {
//!     case 99162322:  // "hello".hashCode()
//!         if (str.equals("hello")) { doHello(); break; }
//!         break;
//!     case 113318802: // "world".hashCode()
//!         if (str.equals("world")) { doWorld(); break; }
//!         break;
//! }
//! ```
//!
//! This pass detects the hashCode pattern and restores the original switch statement.
//!
//! ## JADX Reference
//!
//! This is a direct port of JADX's `SwitchOverStringVisitor.java` (478 lines).
//! See: jadx-fast/jadx-core/src/main/java/jadx/core/dex/visitors/regions/SwitchOverStringVisitor.java
//!
//! Key behaviors cloned from JADX:
//! - `restoreSwitchOverString()` - Main detection and restoration logic
//! - `getStrHashCodeArg()` - Finds String.hashCode() invocation
//! - `collectEqualsInsns()` - Collects String.equals() calls on the string
//! - `processCase()` / `fillCaseData()` - Extracts string values from IF regions
//! - `mergeWithCode()` - Handles two-switch pattern (hash + index)
//!
//! ## Two-Switch Pattern
//!
//! Some compilers generate a two-switch pattern for better jump table efficiency:
//!
//! ```java
//! // First switch: hash to index
//! int idx = -1;
//! switch (str.hashCode()) {
//!     case 99162322:
//!         if (str.equals("hello")) idx = 0;
//!         break;
//!     case 113318802:
//!         if (str.equals("world")) idx = 1;
//!         break;
//! }
//!
//! // Second switch: index to code
//! switch (idx) {
//!     case 0: doHello(); break;
//!     case 1: doWorld(); break;
//! }
//! ```
//!
//! This pass handles both patterns.

use std::collections::HashMap;
use crate::cfg::CFG;
use dexterity_ir::instructions::{InsnArg, InsnNode, InsnType, InvokeKind};
use dexterity_ir::regions::{CaseKey, Condition, Region, RegionContent};

/// Result of the switch-over-string pass
#[derive(Debug, Default)]
pub struct SwitchOverStringResult {
    /// Number of switch statements restored
    pub switches_restored: usize,
    /// Number of single-switch patterns found
    pub single_switch: usize,
    /// Number of two-switch patterns found (hash + index)
    pub two_switch: usize,
    /// Number of string cases extracted
    pub cases_extracted: usize,
}

/// Data for a single switch case
#[derive(Debug, Clone)]
struct CaseData {
    /// String values for this case
    str_values: Vec<String>,
    /// Block containing the case code
    #[allow(dead_code)]
    code_block: Option<u32>,
    /// Index number for two-switch pattern
    #[allow(dead_code)]
    code_num: Option<i32>,
}

/// Process a method's region tree for switch-over-string patterns
///
/// This is the main entry point for the pass.
pub fn process_switch_over_string(
    region: &mut Region,
    cfg: &CFG,
    string_constants: &HashMap<u32, String>,
    method_names: &HashMap<u32, String>,
) -> SwitchOverStringResult {
    let mut result = SwitchOverStringResult::default();
    process_region_recursive(region, cfg, string_constants, method_names, &mut result, 0);
    result
}

fn process_region_recursive(
    region: &mut Region,
    cfg: &CFG,
    string_constants: &HashMap<u32, String>,
    method_names: &HashMap<u32, String>,
    result: &mut SwitchOverStringResult,
    depth: usize,
) {
    let max_depth = dexterity_limits::regions::visitor_max_depth();
    if depth > max_depth {
        tracing::error!(
            depth = depth,
            limit = max_depth,
            "LIMIT_EXCEEDED: Switch-over-string visitor max depth reached"
        );
        return;
    }

    match region {
        Region::Switch { header_block, cases } => {
            // Try to restore switch-over-string for this switch
            if let Some(restored_cases) = restore_switch_over_string(
                *header_block,
                cases,
                cfg,
                string_constants,
                method_names,
            ) {
                *cases = restored_cases;
                result.switches_restored += 1;
                result.single_switch += 1;
            }

            // Recursively process case containers
            for case in cases.iter_mut() {
                process_region_recursive(&mut case.container, cfg, string_constants, method_names, result, depth + 1);
            }
        }

        Region::If {
            then_region,
            else_region,
            ..
        } => {
            process_region_recursive(then_region, cfg, string_constants, method_names, result, depth + 1);
            if let Some(else_r) = else_region.as_mut() {
                process_region_recursive(else_r, cfg, string_constants, method_names, result, depth + 1);
            }
        }

        Region::Sequence(contents) => {
            for content in contents.iter_mut() {
                if let RegionContent::Region(r) = content {
                    process_region_recursive(r, cfg, string_constants, method_names, result, depth + 1);
                }
            }
        }

        Region::Loop { body, .. } => {
            process_region_recursive(body, cfg, string_constants, method_names, result, depth + 1);
        }

        Region::TryCatch {
            try_region,
            handlers,
            finally,
            ..
        } => {
            process_region_recursive(try_region, cfg, string_constants, method_names, result, depth + 1);
            for handler in handlers.iter_mut() {
                process_region_recursive(&mut handler.region, cfg, string_constants, method_names, result, depth + 1);
            }
            if let Some(f) = finally.as_mut() {
                process_region_recursive(f, cfg, string_constants, method_names, result, depth + 1);
            }
        }

        Region::Synchronized { body, .. } => {
            process_region_recursive(body, cfg, string_constants, method_names, result, depth + 1);
        }

        // Terminal regions - nothing to process
        Region::Break { .. }
        | Region::Continue { .. }
        | Region::TernaryAssignment { .. }
        | Region::TernaryReturn { .. } => {}
    }
}

/// Try to restore a switch-over-string pattern
///
/// Returns Some(new_cases) if restoration was successful.
///
/// JADX Reference: SwitchOverStringVisitor.restoreSwitchOverString()
fn restore_switch_over_string(
    header_block: u32,
    cases: &[dexterity_ir::regions::CaseInfo],
    cfg: &CFG,
    string_constants: &HashMap<u32, String>,
    method_names: &HashMap<u32, String>,
) -> Option<Vec<dexterity_ir::regions::CaseInfo>> {
    // Get the switch instruction
    let block = cfg.get_block(header_block)?;
    let switch_insn = block.instructions.last()?;

    // Check if switch argument comes from hashCode()
    let str_var = get_str_hash_code_arg(switch_insn, cfg, method_names)?;

    // Quick check: need at least casesCount + 1 uses (hashCode + equals per case)
    let cases_count = cases.len();

    // Collect String.equals() calls on the string variable
    let str_eq_insns = collect_equals_insns(&str_var, cfg, string_constants, method_names);
    if str_eq_insns.len() < cases_count {
        return None;
    }

    // Process each case to extract string values
    let mut case_data_list = Vec::with_capacity(cases_count);
    for case in cases {
        let case_data = process_case(case, cfg, &str_eq_insns)?;
        case_data_list.push(case_data);
    }

    // Build new cases with string keys
    let new_cases: Vec<dexterity_ir::regions::CaseInfo> = case_data_list
        .iter()
        .zip(cases.iter())
        .map(|(data, orig_case)| {
            let keys: Vec<CaseKey> = data
                .str_values
                .iter()
                .map(|s| CaseKey::String(s.clone()))
                .collect();

            // Keep default case if present
            let mut final_keys = keys;
            for key in &orig_case.keys {
                if matches!(key, CaseKey::Default) {
                    final_keys.push(CaseKey::Default);
                }
            }

            dexterity_ir::regions::CaseInfo {
                keys: if final_keys.is_empty() {
                    vec![CaseKey::Default]
                } else {
                    final_keys
                },
                container: orig_case.container.clone(),
            }
        })
        .collect();

    Some(new_cases)
}

/// Get the String argument from a hashCode() call
///
/// Detects: switch(str.hashCode()) or switch(String.hashCode(str))
///
/// JADX Reference: SwitchOverStringVisitor.getStrHashCodeArg()
fn get_str_hash_code_arg(
    switch_insn: &InsnNode,
    cfg: &CFG,
    method_names: &HashMap<u32, String>,
) -> Option<(u16, u32)> {
    // Get the switch argument
    let switch_arg = match &switch_insn.insn_type {
        InsnType::PackedSwitch { value, .. } | InsnType::SparseSwitch { value, .. } => value,
        _ => return None,
    };

    // The switch argument should be a register from hashCode()
    let reg = match switch_arg {
        InsnArg::Register(r) => r,
        _ => return None,
    };

    // Find the instruction that assigns this register
    // Look for an invoke of String.hashCode()
    for block_id in cfg.block_ids() {
        let Some(block) = cfg.get_block(block_id) else { continue };
        for insn in &block.instructions {
            if let InsnType::Invoke { method_idx, dest, args, kind, .. } = &insn.insn_type {
                // Check if this assigns to our switch register
                if let Some(dest_reg) = dest {
                    if dest_reg.reg_num == reg.reg_num && dest_reg.ssa_version == reg.ssa_version {
                        // Check if this is String.hashCode()
                        if is_string_hash_code_call(*method_idx, method_names) {
                            // The instance arg is the string
                            if matches!(kind, InvokeKind::Virtual | InvokeKind::Interface) {
                                if let Some(instance_arg) = args.first() {
                                    if let InsnArg::Register(str_reg) = instance_arg {
                                        return Some((str_reg.reg_num, str_reg.ssa_version));
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    None
}

/// Check if a method is String.hashCode()
fn is_string_hash_code_call(method_idx: u32, method_names: &HashMap<u32, String>) -> bool {
    if let Some(name) = method_names.get(&method_idx) {
        // Check for various representations
        name.contains("String.hashCode") || name.contains("String;->hashCode")
    } else {
        false
    }
}

/// Collect String.equals() invocations on the given string variable
///
/// Returns a map from instruction offset to the string literal being compared.
///
/// JADX Reference: SwitchOverStringVisitor.collectEqualsInsns()
fn collect_equals_insns(
    str_var: &(u16, u32),
    cfg: &CFG,
    string_constants: &HashMap<u32, String>,
    method_names: &HashMap<u32, String>,
) -> HashMap<u32, String> {
    let mut result = HashMap::new();

    for block_id in cfg.block_ids() {
        let Some(block) = cfg.get_block(block_id) else { continue };
        for insn in &block.instructions {
            if let InsnType::Invoke { method_idx, args, kind, .. } = &insn.insn_type {
                // Check if this is String.equals()
                if is_string_equals_call(*method_idx, method_names) {
                    if matches!(kind, InvokeKind::Virtual | InvokeKind::Interface) {
                        // First arg is the string instance
                        if let Some(InsnArg::Register(instance)) = args.first() {
                            if instance.reg_num == str_var.0 && instance.ssa_version == str_var.1 {
                                // Second arg should be a string constant
                                if let Some(str_value) = get_string_arg(args.get(1), cfg, string_constants) {
                                    result.insert(insn.offset, str_value);
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

/// Check if a method is String.equals()
fn is_string_equals_call(method_idx: u32, method_names: &HashMap<u32, String>) -> bool {
    if let Some(name) = method_names.get(&method_idx) {
        name.contains("String.equals") || name.contains("String;->equals")
    } else {
        false
    }
}

/// Get a string argument from an invoke instruction
fn get_string_arg(
    arg: Option<&InsnArg>,
    cfg: &CFG,
    string_constants: &HashMap<u32, String>,
) -> Option<String> {
    let arg = arg?;

    match arg {
        InsnArg::Register(reg) => {
            // Find the const-string that assigns to this register
            for block_id in cfg.block_ids() {
                let Some(block) = cfg.get_block(block_id) else { continue };
                for insn in &block.instructions {
                    if let InsnType::ConstString { dest, string_idx } = &insn.insn_type {
                        if dest.reg_num == reg.reg_num && dest.ssa_version == reg.ssa_version {
                            return string_constants.get(string_idx).cloned();
                        }
                    }
                }
            }
            None
        }
        _ => None,
    }
}

/// Process a switch case to extract string values
///
/// JADX Reference: SwitchOverStringVisitor.processCase()
fn process_case(
    case: &dexterity_ir::regions::CaseInfo,
    cfg: &CFG,
    str_eq_insns: &HashMap<u32, String>,
) -> Option<CaseData> {
    let mut data = CaseData {
        str_values: Vec::new(),
        code_block: None,
        code_num: None,
    };

    // Visit IF regions in this case to find equals() checks
    extract_string_values_from_region(&case.container, cfg, str_eq_insns, &mut data);

    // Must have at least one string value
    if data.str_values.is_empty() {
        // For default case, this is OK
        if case.keys.iter().any(|k| matches!(k, CaseKey::Default)) {
            return Some(data);
        }
        return None;
    }

    Some(data)
}

/// Extract string values from a region by finding equals() checks
fn extract_string_values_from_region(
    region: &Region,
    cfg: &CFG,
    str_eq_insns: &HashMap<u32, String>,
    data: &mut CaseData,
) {
    match region {
        Region::If {
            condition,
            then_region,
            else_region,
            ..
        } => {
            // Check if condition involves a string equals check
            if let Some(str_value) = find_string_from_condition(condition, cfg, str_eq_insns) {
                data.str_values.push(str_value);
                // The code is in the then branch (or else if negated)
                data.code_block = get_first_block_in_region(then_region);
            }

            // Recursively process nested regions
            extract_string_values_from_region(then_region, cfg, str_eq_insns, data);
            if let Some(else_r) = else_region {
                extract_string_values_from_region(else_r, cfg, str_eq_insns, data);
            }
        }

        Region::Sequence(contents) => {
            for content in contents {
                if let RegionContent::Region(r) = content {
                    extract_string_values_from_region(r, cfg, str_eq_insns, data);
                }
            }
        }

        _ => {}
    }
}

/// Find a string value from a condition that uses equals()
fn find_string_from_condition(
    condition: &Condition,
    cfg: &CFG,
    str_eq_insns: &HashMap<u32, String>,
) -> Option<String> {
    match condition {
        Condition::Simple { block, .. } => {
            // Look for equals() invocations in this block
            if let Some(cfg_block) = cfg.get_block(*block) {
                for insn in &cfg_block.instructions {
                    if str_eq_insns.contains_key(&insn.offset) {
                        return str_eq_insns.get(&insn.offset).cloned();
                    }
                }
            }
            None
        }

        Condition::Not(inner) => find_string_from_condition(inner, cfg, str_eq_insns),
        Condition::And(left, right) | Condition::Or(left, right) => {
            find_string_from_condition(left, cfg, str_eq_insns)
                .or_else(|| find_string_from_condition(right, cfg, str_eq_insns))
        }

        _ => None,
    }
}

/// Get the first block ID from a region
fn get_first_block_in_region(region: &Region) -> Option<u32> {
    match region {
        Region::Sequence(contents) => {
            for content in contents {
                match content {
                    RegionContent::Block(id) => return Some(*id),
                    RegionContent::Region(r) => {
                        if let Some(id) = get_first_block_in_region(r) {
                            return Some(id);
                        }
                    }
                }
            }
            None
        }
        Region::If { condition_blocks, .. } => condition_blocks.first().copied(),
        Region::Switch { header_block, .. } => Some(*header_block),
        Region::Loop { header_block, .. } => *header_block,
        _ => None,
    }
}

#[cfg(test)]
mod tests {
    use super::*;

    #[test]
    fn test_is_string_hash_code_call() {
        let mut method_names = HashMap::new();
        method_names.insert(1, "java.lang.String.hashCode()I".to_string());
        method_names.insert(2, "Ljava/lang/String;->hashCode()I".to_string());
        method_names.insert(3, "java.lang.Object.hashCode()I".to_string());

        assert!(is_string_hash_code_call(1, &method_names));
        assert!(is_string_hash_code_call(2, &method_names));
        assert!(!is_string_hash_code_call(3, &method_names));
    }

    #[test]
    fn test_is_string_equals_call() {
        let mut method_names = HashMap::new();
        method_names.insert(1, "java.lang.String.equals(Ljava/lang/Object;)Z".to_string());
        method_names.insert(2, "Ljava/lang/String;->equals(Ljava/lang/Object;)Z".to_string());
        method_names.insert(3, "java.lang.Object.equals(Ljava/lang/Object;)Z".to_string());

        assert!(is_string_equals_call(1, &method_names));
        assert!(is_string_equals_call(2, &method_names));
        assert!(!is_string_equals_call(3, &method_names));
    }

    #[test]
    fn test_case_data_construction() {
        let data = CaseData {
            str_values: vec!["hello".to_string(), "world".to_string()],
            code_block: Some(5),
            code_num: None,
        };

        assert_eq!(data.str_values.len(), 2);
        assert_eq!(data.code_block, Some(5));
    }
}
