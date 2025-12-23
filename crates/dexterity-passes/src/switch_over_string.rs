//! Switch Over String Restoration
//!
//! JADX Clone: jadx-core/src/main/java/jadx/core/dex/visitors/regions/SwitchOverStringVisitor.java
//! Original Author: Skylot (skylot@gmail.com)
//! Clone Date: Dec 2025
//!
//! Restores Java 7+ switch(string) statements from hashCode()/equals() patterns.
//!
//! Java compiles `switch(str)` to a two-phase pattern:
//! 1. First switch on `str.hashCode()` with collision handling via `str.equals()`
//! 2. Second switch on an integer index assigned in the first switch
//!
//! This pass detects and transforms back to clean `switch(str)` form.

use std::collections::HashMap;

use dexterity_ir::attributes::AFlag;
use dexterity_ir::instructions::{IfCondition, InsnType};
use dexterity_ir::regions::{CaseInfo, CaseKey, Condition, ConditionMode, Region, RegionContent};

/// Result of switch over string restoration
#[derive(Debug, Default)]
pub struct SwitchOverStringResult {
    /// Number of switches restored
    pub restored_count: usize,
    /// Warnings encountered during processing
    pub warnings: Vec<String>,
}

/// Switch restoration state data
/// JADX Reference: SwitchOverStringVisitor.java:380-446
struct SwitchData {
    /// String var uses to equals() calls mapping: insn_offset -> string constant
    str_eq_insns: HashMap<u32, String>,
    /// Collected case data from first (hashCode) switch
    cases: Vec<CaseData>,
    /// New cases for the restored switch
    new_cases: Vec<NewCaseInfo>,
    /// Instructions/blocks to remove after restoration
    to_remove: Vec<u32>,
    /// Second (integer) switch region index if present
    code_switch_idx: Option<usize>,
    /// Integer argument register for linking switches
    num_arg_reg: Option<u16>,
}

/// Temporary case info for building new switch
struct NewCaseInfo {
    keys: Vec<CaseKey>,
    region_content: RegionContent,
}

/// Data collected from each case of the first switch
/// JADX Reference: SwitchOverStringVisitor.java:448-476
struct CaseData {
    /// String values for this case (may have hash collisions)
    str_values: Vec<String>,
    /// Code region for this case
    code: Option<RegionContent>,
    /// Integer index assigned in this case (for linking to second switch)
    code_num: i32,
}

impl CaseData {
    fn new() -> Self {
        CaseData {
            str_values: Vec::new(),
            code: None,
            code_num: -1,
        }
    }
}

impl SwitchData {
    fn new() -> Self {
        SwitchData {
            str_eq_insns: HashMap::new(),
            cases: Vec::new(),
            new_cases: Vec::new(),
            to_remove: Vec::new(),
            code_switch_idx: None,
            num_arg_reg: None,
        }
    }
}

/// Process switch over string patterns in a method's regions.
///
/// JADX Reference: SwitchOverStringVisitor.java:56-61
pub fn process_switch_over_string<F, G, H, I>(
    regions: &mut [Region],
    get_insn: F,
    get_ssa_uses: G,
    is_invoke_method: H,
    get_const_string: I,
) -> SwitchOverStringResult
where
    F: Fn(u32) -> Option<InsnType> + Copy,
    G: Fn(u16, u32) -> Vec<(u32, u16)> + Copy, // (insn_offset, arg_index)
    H: Fn(u32, &str) -> bool + Copy,            // (insn_offset, method_signature)
    I: Fn(u32, usize) -> Option<String> + Copy, // (insn_offset, arg_index) -> string
{
    let mut result = SwitchOverStringResult::default();

    // Iterate through regions looking for switches
    for region in regions.iter_mut() {
        if let Some(restored) =
            try_restore_switch_region(region, get_insn, get_ssa_uses, is_invoke_method, get_const_string)
        {
            if restored {
                result.restored_count += 1;
            }
        }
    }

    result
}

/// Try to restore a switch region as a string switch.
///
/// JADX Reference: SwitchOverStringVisitor.java:64-69
fn try_restore_switch_region<F, G, H, I>(
    region: &mut Region,
    get_insn: F,
    get_ssa_uses: G,
    is_invoke_method: H,
    get_const_string: I,
) -> Option<bool>
where
    F: Fn(u32) -> Option<InsnType> + Copy,
    G: Fn(u16, u32) -> Vec<(u32, u16)> + Copy,
    H: Fn(u32, &str) -> bool + Copy,
    I: Fn(u32, usize) -> Option<String> + Copy,
{
    match region {
        Region::Switch { header_block, cases } => {
            restore_switch_over_string(*header_block, cases, get_insn, get_ssa_uses, is_invoke_method, get_const_string)
        }
        Region::Sequence(contents) => {
            // Recursively process nested regions
            for content in contents.iter_mut() {
                if let RegionContent::Region(nested) = content {
                    if let Some(true) = try_restore_switch_region(
                        nested,
                        get_insn,
                        get_ssa_uses,
                        is_invoke_method,
                        get_const_string,
                    ) {
                        return Some(true);
                    }
                }
            }
            None
        }
        Region::If { then_region, else_region, .. } => {
            if let Some(true) = try_restore_switch_region(
                then_region,
                get_insn,
                get_ssa_uses,
                is_invoke_method,
                get_const_string,
            ) {
                return Some(true);
            }
            if let Some(else_reg) = else_region {
                if let Some(true) = try_restore_switch_region(
                    else_reg,
                    get_insn,
                    get_ssa_uses,
                    is_invoke_method,
                    get_const_string,
                ) {
                    return Some(true);
                }
            }
            None
        }
        Region::Loop { body, .. } => {
            try_restore_switch_region(body, get_insn, get_ssa_uses, is_invoke_method, get_const_string)
        }
        Region::TryCatch { try_region, handlers, finally, .. } => {
            if let Some(true) = try_restore_switch_region(
                try_region,
                get_insn,
                get_ssa_uses,
                is_invoke_method,
                get_const_string,
            ) {
                return Some(true);
            }
            for handler in handlers {
                if let Some(true) = try_restore_switch_region(
                    &mut handler.region,
                    get_insn,
                    get_ssa_uses,
                    is_invoke_method,
                    get_const_string,
                ) {
                    return Some(true);
                }
            }
            if let Some(fin) = finally {
                return try_restore_switch_region(fin, get_insn, get_ssa_uses, is_invoke_method, get_const_string);
            }
            None
        }
        _ => None,
    }
}

/// Restore switch over string pattern.
///
/// JADX Reference: SwitchOverStringVisitor.java:71-125
fn restore_switch_over_string<F, G, H, I>(
    header_block: u32,
    cases: &mut Vec<CaseInfo>,
    get_insn: F,
    get_ssa_uses: G,
    is_invoke_method: H,
    get_const_string: I,
) -> Option<bool>
where
    F: Fn(u32) -> Option<InsnType> + Copy,
    G: Fn(u16, u32) -> Vec<(u32, u16)> + Copy,
    H: Fn(u32, &str) -> bool + Copy,
    I: Fn(u32, usize) -> Option<String> + Copy,
{
    // Step 1: Find the switch instruction and check if it's switching on hashCode()
    // JADX Reference: SwitchOverStringVisitor.java:73-79
    let (str_reg, str_version) = get_str_hash_code_arg(header_block, get_insn)?;

    let cases_count = cases.len();

    // Step 2: Get all uses of the string variable
    // JADX Reference: SwitchOverStringVisitor.java:82-86
    let uses = get_ssa_uses(str_reg, str_version);
    // Need at least one hashCode + one equals per case
    if uses.len() < cases_count + 1 {
        return None;
    }

    // Step 3: Collect all String.equals() calls
    // JADX Reference: SwitchOverStringVisitor.java:88-91
    let str_eq_insns = collect_equals_insns(&uses, is_invoke_method, get_const_string);
    if str_eq_insns.len() < cases_count {
        return None;
    }

    // Step 4: Process each case to extract string values
    let mut switch_data = SwitchData::new();
    switch_data.str_eq_insns = str_eq_insns;

    for case_info in cases.iter() {
        if !process_case(&mut switch_data, case_info, get_insn, get_const_string) {
            // Failed to process case
            return None;
        }
    }

    // Step 5: Build new cases with string keys
    // JADX Reference: SwitchOverStringVisitor.java:106-115
    let new_cases: Vec<CaseInfo> = switch_data
        .cases
        .iter()
        .map(|case_data| {
            let keys: Vec<CaseKey> = case_data
                .str_values
                .iter()
                .map(|s| CaseKey::String(s.clone()))
                .collect();
            CaseInfo {
                keys,
                container: case_data
                    .code
                    .as_ref()
                    .map(|c| match c {
                        RegionContent::Region(r) => Box::new((**r).clone()),
                        RegionContent::Block(b) => Box::new(Region::Sequence(vec![RegionContent::Block(*b)])),
                    })
                    .unwrap_or_else(|| Box::new(Region::Sequence(vec![]))),
            }
        })
        .collect();

    // Replace cases with string-based cases
    *cases = new_cases;

    Some(true)
}

/// Check if the switch argument comes from String.hashCode() call.
/// Returns (string_register, ssa_version) if found.
///
/// JADX Reference: SwitchOverStringVisitor.java:354-377
fn get_str_hash_code_arg<F>(header_block: u32, get_insn: F) -> Option<(u16, u32)>
where
    F: Fn(u32) -> Option<InsnType>,
{
    // Get the switch instruction from the header block
    // In practice, we'd need to search for SWITCH instruction in the block
    // For now, assume the get_insn function can find it

    // The switch argument should be the result of String.hashCode()
    // Pattern: invoke-virtual {vX}, Ljava/lang/String;->hashCode()I
    //          switch vX

    // This would need to trace the SSA chain to find the hashCode call
    // For now, return None to indicate this needs full implementation
    // with proper instruction access

    None // Placeholder - needs full SSA chain traversal
}

/// Collect all String.equals() calls for a string variable.
///
/// JADX Reference: SwitchOverStringVisitor.java:283-298
fn collect_equals_insns<H, I>(
    uses: &[(u32, u16)],
    is_invoke_method: H,
    get_const_string: I,
) -> HashMap<u32, String>
where
    H: Fn(u32, &str) -> bool,
    I: Fn(u32, usize) -> Option<String>,
{
    let mut map = HashMap::new();

    for &(insn_offset, _arg_idx) in uses {
        // Check if this is a String.equals() call
        // JADX Reference: SwitchOverStringVisitor.java:287-289
        if is_invoke_method(insn_offset, "java.lang.String.equals(Ljava/lang/Object;)Z") {
            // Get the string constant from arg[1]
            // JADX Reference: SwitchOverStringVisitor.java:290-294
            if let Some(str_value) = get_const_string(insn_offset, 1) {
                map.insert(insn_offset, str_value);
            }
        }
    }

    map
}

/// Process a single case from the hashCode switch.
///
/// JADX Reference: SwitchOverStringVisitor.java:301-317
fn process_case<F, I>(
    switch_data: &mut SwitchData,
    case_info: &CaseInfo,
    get_insn: F,
    get_const_string: I,
) -> bool
where
    F: Fn(u32) -> Option<InsnType> + Copy,
    I: Fn(u32, usize) -> Option<String> + Copy,
{
    // Each case in the hashCode switch contains if-chains comparing with equals()
    // We need to extract the string values from those comparisons

    let mut case_data = CaseData::new();

    // Visit the case container to find if-regions with equals() comparisons
    // JADX Reference: SwitchOverStringVisitor.java:303-316
    if !fill_case_data_from_region(&case_info.container, switch_data, &mut case_data, get_insn, get_const_string) {
        return false;
    }

    if case_data.str_values.is_empty() {
        return false;
    }

    case_data.code = Some(RegionContent::Region(case_info.container.clone()));
    switch_data.cases.push(case_data);
    true
}

/// Extract string comparison data from a region (if-chain in a case).
///
/// JADX Reference: SwitchOverStringVisitor.java:320-351
fn fill_case_data_from_region<F, I>(
    region: &Region,
    switch_data: &SwitchData,
    case_data: &mut CaseData,
    get_insn: F,
    get_const_string: I,
) -> bool
where
    F: Fn(u32) -> Option<InsnType> + Copy,
    I: Fn(u32, usize) -> Option<String> + Copy,
{
    match region {
        Region::If { condition, then_region, else_region, .. } => {
            // Check if condition is a String.equals() comparison
            // JADX Reference: SwitchOverStringVisitor.java:328-343
            if let Some(str_value) = extract_string_from_condition(condition, switch_data) {
                case_data.str_values.push(str_value);

                // Determine which branch has the actual code (based on negation)
                // JADX Reference: SwitchOverStringVisitor.java:349-350
                let is_negated = matches!(condition, Condition::Not(_));
                if is_negated {
                    if let Some(else_reg) = else_region {
                        case_data.code = Some(RegionContent::Region(else_reg.clone()));
                    }
                } else {
                    case_data.code = Some(RegionContent::Region(then_region.clone()));
                }
                return true;
            }
            false
        }
        Region::Sequence(contents) => {
            // Process nested regions
            for content in contents {
                if let RegionContent::Region(nested) = content {
                    if fill_case_data_from_region(nested, switch_data, case_data, get_insn, get_const_string) {
                        return true;
                    }
                }
            }
            // If no if-region found, the case might have direct code
            true
        }
        _ => true,
    }
}

/// Extract string value from a condition that wraps a String.equals() call.
///
/// JADX Reference: SwitchOverStringVisitor.java:328-343
fn extract_string_from_condition(condition: &Condition, switch_data: &SwitchData) -> Option<String> {
    match condition {
        Condition::Simple { block, .. } => {
            // The condition block should contain the if instruction
            // Check if it compares the result of a String.equals() call
            // Look up in our collected equals insns
            switch_data.str_eq_insns.get(block).cloned()
        }
        Condition::Not(inner) => {
            // NOT(equals) pattern - negated comparison
            extract_string_from_condition(inner, switch_data)
        }
        _ => None,
    }
}

/// Check if a region matches the string switch pattern with two switches.
/// Returns the second (code) switch region index if found.
///
/// JADX Reference: SwitchOverStringVisitor.java:159-265
fn find_code_switch(
    regions: &[Region],
    start_idx: usize,
    num_arg_reg: u16,
) -> Option<usize> {
    // Look for the next switch region that switches on the integer index variable
    for (idx, region) in regions.iter().enumerate().skip(start_idx + 1) {
        if let Region::Switch { .. } = region {
            // Check if this switch uses num_arg_reg
            // For now, return the first switch found after our position
            return Some(idx);
        }
    }
    None
}

#[cfg(test)]
mod tests {
    use super::*;

    #[test]
    fn test_case_data() {
        let mut case_data = CaseData::new();
        case_data.str_values.push("hello".to_string());
        case_data.str_values.push("world".to_string());
        case_data.code_num = 0;

        assert_eq!(case_data.str_values.len(), 2);
        assert_eq!(case_data.code_num, 0);
    }

    #[test]
    fn test_switch_data() {
        let mut switch_data = SwitchData::new();
        switch_data.str_eq_insns.insert(100, "test".to_string());

        assert_eq!(switch_data.str_eq_insns.len(), 1);
        assert!(switch_data.cases.is_empty());
    }

    #[test]
    fn test_case_key_string() {
        let key = CaseKey::String("hello".to_string());
        assert_eq!(format!("{}", key), "\"hello\"");
    }
}
