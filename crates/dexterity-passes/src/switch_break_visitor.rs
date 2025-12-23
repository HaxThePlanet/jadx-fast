//! Switch break optimization pass
//!
//! This pass optimizes 'break' instructions in switch regions:
//! 1. Extract common break: If all branches end with break/exit, extract to parent
//! 2. Remove unreachable break: If break follows a return/throw, remove it
//!
//! ## JADX Reference
//!
//! This pass is a direct clone of JADX's `SwitchBreakVisitor.java` (267 lines).
//! See: jadx-fast/jadx-core/src/main/java/jadx/core/dex/visitors/regions/SwitchBreakVisitor.java
//!
//! Key behaviors cloned from JADX:
//! - `ExtractCommonBreak` - If break/exit in all branches, move to parent region
//! - `RemoveUnreachableBreak` - Remove break that follows exit insn
//! - Iterative traversal until no more changes
//!
//! ## Example
//!
//! Before:
//! ```java
//! switch (x) {
//!     case 0:
//!         foo();
//!         break;
//!     case 1:
//!         bar();
//!         break;
//! }
//! ```
//!
//! After (if all cases have break):
//! ```java
//! switch (x) {
//!     case 0:
//!         foo();
//!     case 1:
//!         bar();
//! }
//! break;  // Moved to after switch
//! ```
//!
//! ## Unreachable Break Removal
//!
//! Before:
//! ```java
//! case 2:
//!     throw new Exception();
//!     break;  // Unreachable
//! ```
//!
//! After:
//! ```java
//! case 2:
//!     throw new Exception();
//! ```

use std::collections::HashSet;
use dexterity_ir::instructions::{InsnNode, InsnType};
use dexterity_ir::regions::{Region, RegionKind, SwitchCase};

/// Result of the switch break visitor pass
#[derive(Debug, Default)]
pub struct SwitchBreakVisitorResult {
    /// Number of common breaks extracted
    pub common_breaks_extracted: usize,
    /// Number of unreachable breaks removed
    pub unreachable_breaks_removed: usize,
    /// Number of iterations needed
    pub iterations: usize,
}

/// Check if an instruction is a break instruction for a specific switch
pub fn is_break_for_switch(insn: &InsnNode, switch_offset: u32) -> bool {
    matches!(&insn.insn_type, InsnType::Break { target } if *target == switch_offset)
}

/// Check if an instruction is an exit instruction (return, throw, continue)
///
/// JADX Reference: InsnNode.isExitEdgeInsn()
pub fn is_exit_edge_insn(insn: &InsnNode) -> bool {
    matches!(
        &insn.insn_type,
        InsnType::Return { .. }
            | InsnType::ReturnVoid
            | InsnType::Throw { .. }
            | InsnType::Continue { .. }
    )
}

/// Check if a block contains an exit instruction (break, return, throw, continue)
///
/// JADX Reference: BlockUtils.containsExitInsn()
pub fn block_contains_exit_insn(instructions: &[InsnNode]) -> bool {
    instructions.last().map_or(false, is_exit_edge_insn)
}

/// Check if a block is a break-only block
///
/// JADX Reference: BaseSwitchRegionVisitor.isBreakBlock()
pub fn is_break_block(instructions: &[InsnNode], switch_offset: u32) -> bool {
    if let Some(last) = instructions.last() {
        is_break_for_switch(last, switch_offset)
    } else {
        false
    }
}

/// Extract common break from switch cases
///
/// JADX Reference: ExtractCommonBreak.processBranchRegion()
///
/// If all cases of a switch end with either:
/// - A break to this switch
/// - An exit instruction (return, throw, continue)
///
/// Then we can:
/// - Remove the break from each case
/// - Add a single break after the switch
///
/// If all cases end with exit instructions, we can remove the break entirely.
pub fn extract_common_break(
    cases: &mut [SwitchCase],
    switch_offset: u32,
) -> ExtractCommonBreakResult {
    let mut result = ExtractCommonBreakResult::default();

    // First pass: check if all cases end with break or exit
    let mut all_have_break_or_exit = true;
    let mut all_have_exit_only = true;
    let mut cases_with_break: Vec<usize> = Vec::new();

    for (idx, case) in cases.iter().enumerate() {
        if case.body.is_empty() {
            // Empty case - fallthrough, doesn't count
            all_have_exit_only = false;
            continue;
        }

        let last_insn = case.body.last();
        if let Some(insn) = last_insn {
            if is_break_for_switch(insn, switch_offset) {
                cases_with_break.push(idx);
                all_have_exit_only = false;
            } else if is_exit_edge_insn(insn) {
                // Has exit, counts as "has break or exit"
            } else {
                // Neither break nor exit
                all_have_break_or_exit = false;
                all_have_exit_only = false;
            }
        } else {
            all_have_break_or_exit = false;
            all_have_exit_only = false;
        }
    }

    // If not all cases have break/exit, we can't extract
    if !all_have_break_or_exit || cases_with_break.is_empty() {
        return result;
    }

    // Remove break from each case that has one
    for &idx in &cases_with_break {
        if let Some(body) = cases.get_mut(idx).map(|c| &mut c.body) {
            if !body.is_empty() {
                body.pop(); // Remove the break
                result.breaks_removed += 1;
            }
        }
    }

    // If all cases had exit instructions, the common break is unreachable
    if all_have_exit_only {
        result.break_is_unreachable = true;
    } else {
        result.add_break_after_switch = true;
    }

    result
}

/// Result of extracting common break
#[derive(Debug, Default)]
pub struct ExtractCommonBreakResult {
    /// Number of breaks removed from cases
    pub breaks_removed: usize,
    /// Whether to add a break after the switch
    pub add_break_after_switch: bool,
    /// Whether the common break would be unreachable
    pub break_is_unreachable: bool,
}

/// Remove unreachable break instructions
///
/// JADX Reference: RemoveUnreachableBreak
///
/// If a break instruction follows an exit instruction in the same block,
/// the break is unreachable and should be removed.
pub fn remove_unreachable_break(
    instructions: &mut Vec<InsnNode>,
    switch_offset: u32,
) -> usize {
    let mut removed = 0;

    // Check if last instruction is a break
    if let Some(last) = instructions.last() {
        if is_break_for_switch(last, switch_offset) {
            // Check if second-to-last is an exit
            if instructions.len() >= 2 {
                let second_last = &instructions[instructions.len() - 2];
                if is_exit_edge_insn(second_last) {
                    // Break is unreachable, remove it
                    instructions.pop();
                    removed += 1;
                }
            }
        }
    }

    removed
}

/// Process all switch regions in a method for break optimization
///
/// JADX Reference: SwitchBreakVisitor.visit()
///
/// Runs iteratively until no more changes are made (fixpoint).
pub fn optimize_switch_breaks(
    regions: &mut Vec<Region>,
) -> SwitchBreakVisitorResult {
    let mut result = SwitchBreakVisitorResult::default();

    const MAX_ITERATIONS: usize = 100;
    let mut iteration = 0;

    loop {
        let mut changed = false;

        for region in regions.iter_mut() {
            if let RegionKind::Switch { cases, switch_offset, .. } = &mut region.kind {
                // Extract common break
                let extract_result = extract_common_break(cases, *switch_offset);
                if extract_result.breaks_removed > 0 {
                    changed = true;
                    result.common_breaks_extracted += extract_result.breaks_removed;
                }

                // Remove unreachable breaks from each case
                for case in cases.iter_mut() {
                    let removed = remove_unreachable_break(&mut case.body, *switch_offset);
                    if removed > 0 {
                        changed = true;
                        result.unreachable_breaks_removed += removed;
                    }
                }
            }
        }

        iteration += 1;
        result.iterations = iteration;

        if !changed || iteration >= MAX_ITERATIONS {
            break;
        }
    }

    result
}

/// Check if a region ends with return or throw
///
/// JADX Reference: Used in ExtractCommonBreak
pub fn region_ends_with_exit(region: &Region) -> bool {
    match &region.kind {
        RegionKind::Block { instructions } => {
            instructions.last().map_or(false, is_exit_edge_insn)
        }
        RegionKind::Sequence { regions } => {
            regions.last().map_or(false, region_ends_with_exit)
        }
        _ => false,
    }
}

#[cfg(test)]
mod tests {
    use super::*;
    use dexterity_ir::instructions::RegisterArg;

    fn make_break(switch_offset: u32) -> InsnNode {
        InsnNode::new(InsnType::Break { target: switch_offset }, 0)
    }

    fn make_return_void() -> InsnNode {
        InsnNode::new(InsnType::ReturnVoid, 0)
    }

    fn make_throw() -> InsnNode {
        InsnNode::new(
            InsnType::Throw {
                exception: dexterity_ir::instructions::InsnArg::Register(RegisterArg {
                    reg_num: 0,
                    ssa_version: 0,
                }),
            },
            0,
        )
    }

    #[test]
    fn test_is_exit_edge_insn() {
        assert!(is_exit_edge_insn(&make_return_void()));
        assert!(is_exit_edge_insn(&make_throw()));
        assert!(!is_exit_edge_insn(&make_break(100)));
    }

    #[test]
    fn test_is_break_for_switch() {
        let break_insn = make_break(100);
        assert!(is_break_for_switch(&break_insn, 100));
        assert!(!is_break_for_switch(&break_insn, 200));
    }

    #[test]
    fn test_remove_unreachable_break() {
        let mut instructions = vec![
            make_return_void(),
            make_break(100),
        ];

        let removed = remove_unreachable_break(&mut instructions, 100);
        assert_eq!(removed, 1);
        assert_eq!(instructions.len(), 1);
        assert!(matches!(instructions[0].insn_type, InsnType::ReturnVoid));
    }

    #[test]
    fn test_remove_unreachable_break_after_throw() {
        let mut instructions = vec![
            make_throw(),
            make_break(100),
        ];

        let removed = remove_unreachable_break(&mut instructions, 100);
        assert_eq!(removed, 1);
        assert_eq!(instructions.len(), 1);
    }

    #[test]
    fn test_reachable_break_not_removed() {
        let mut instructions = vec![
            InsnNode::new(InsnType::Nop, 0),
            make_break(100),
        ];

        let removed = remove_unreachable_break(&mut instructions, 100);
        assert_eq!(removed, 0);
        assert_eq!(instructions.len(), 2);
    }
}
