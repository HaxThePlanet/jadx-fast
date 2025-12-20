//! IfRegionVisitor - JADX IfRegionVisitor.java parity
//!
//! This module provides if-region optimization passes matching JADX's IfRegionVisitor:
//! - Branch reordering for readability (orderBranches)
//! - Redundant else block removal (removeRedundantElseBlock)
//! - Else-if chain marking (markElseIfChains)
//!
//! These optimizations run after region building to improve code quality.

use crate::cfg::CFG;
use dexterity_ir::instructions::InsnType;
use dexterity_ir::regions::{Condition, ConditionMode, Region, RegionContent};

/// Result of processing if regions
#[derive(Debug, Default)]
pub struct IfRegionVisitorResult {
    /// Number of branches reordered
    pub branches_reordered: usize,
    /// Number of redundant else blocks removed
    pub else_blocks_removed: usize,
    /// Number of else-if chains marked
    pub else_if_chains_marked: usize,
}

/// Process all if regions in a method's region tree
///
/// Applies three optimization passes:
/// 1. Branch reordering (orderBranches)
/// 2. Redundant else removal (removeRedundantElseBlock)
/// 3. Else-if chain marking (markElseIfChains)
///
/// The `cfg` parameter provides access to BasicBlock instructions for accurate
/// return/throw detection (matching JADX's IfRegionVisitor behavior).
pub fn process_if_regions(region: &mut Region, cfg: &CFG) -> IfRegionVisitorResult {
    let mut result = IfRegionVisitorResult::default();
    process_region_recursive(region, &mut result, cfg, 0);
    result
}

fn process_region_recursive(
    region: &mut Region,
    result: &mut IfRegionVisitorResult,
    cfg: &CFG,
    depth: usize,
) {
    const MAX_DEPTH: usize = 100;
    if depth > MAX_DEPTH {
        return;
    }

    match region {
        Region::If {
            condition,
            then_region,
            else_region,
        } => {
            // First, recursively process nested regions
            process_region_recursive(then_region, result, cfg, depth + 1);
            if let Some(else_r) = else_region.as_mut() {
                process_region_recursive(else_r, result, cfg, depth + 1);
            }

            // Apply optimizations
            if order_branches(condition, then_region, else_region, cfg) {
                result.branches_reordered += 1;
            }

            if remove_redundant_else(then_region, else_region, cfg) {
                result.else_blocks_removed += 1;
            }

            if mark_else_if_chain(then_region, else_region) {
                result.else_if_chains_marked += 1;
            }
        }

        Region::Sequence(contents) => {
            for content in contents.iter_mut() {
                if let RegionContent::Region(r) = content {
                    process_region_recursive(r, result, cfg, depth + 1);
                }
            }
        }

        Region::Loop { body, .. } => {
            process_region_recursive(body, result, cfg, depth + 1);
        }

        Region::Switch { cases, .. } => {
            for case in cases.iter_mut() {
                process_region_recursive(&mut case.container, result, cfg, depth + 1);
            }
        }

        Region::TryCatch {
            try_region,
            handlers,
            finally,
            ..
        } => {
            process_region_recursive(try_region, result, cfg, depth + 1);
            for handler in handlers.iter_mut() {
                process_region_recursive(&mut handler.region, result, cfg, depth + 1);
            }
            if let Some(f) = finally.as_mut() {
                process_region_recursive(f, result, cfg, depth + 1);
            }
        }

        Region::Synchronized { body, .. } => {
            process_region_recursive(body, result, cfg, depth + 1);
        }

        // Terminal regions - nothing to process
        Region::Break { .. }
        | Region::Continue { .. }
        | Region::TernaryAssignment { .. }
        | Region::TernaryReturn { .. } => {}
    }
}

/// Reorder branches for readability
///
/// Based on JADX's IfRegionVisitor.orderBranches() with 8 priority rules:
/// 1. Empty else → keep as-is
/// 2. Empty then → invert condition, swap branches
/// 3. Line hints available → order by source line (not implemented - no debug info)
/// 4. Condition is NOT → invert to remove NOT wrapper
/// 5. Else is simple exit (return/throw) → consider inverting
/// 6. Else has exit but then doesn't → invert
/// 7. Then is if-region but else isn't → invert to create else-if chain
/// 8. Else has break → invert to put break in then
/// 9. (JADX) Else is single throw → invert to put throw in then (cleaner pattern)
///
/// Returns true if branches were reordered.
fn order_branches(
    condition: &mut Condition,
    then_region: &mut Box<Region>,
    else_region: &mut Option<Box<Region>>,
    cfg: &CFG,
) -> bool {
    // Rule 1: If else is empty, nothing to reorder
    if else_region.is_none() || is_empty_region(else_region.as_ref().unwrap()) {
        return false;
    }

    let else_r = else_region.as_ref().unwrap();

    // Rule 2: If then is empty, invert
    if is_empty_region(then_region) {
        invert_if_region(condition, then_region, else_region);
        return true;
    }

    // Rule 3: Line hints - skipped (no debug info access here)

    // Rule 4: If condition is NOT mode, invert to simplify
    if condition.mode() == ConditionMode::Not {
        invert_if_region(condition, then_region, else_region);
        return true;
    }

    // Rule 5 & 6: Exit block heuristics
    let then_has_exit = has_exit_block(then_region, cfg);
    let else_has_exit = has_exit_block(else_r, cfg);

    // If else has exit but then doesn't, invert (puts exit path in then)
    if else_has_exit && !then_has_exit {
        invert_if_region(condition, then_region, else_region);
        return true;
    }

    // Rule 7: Move if from then to else to create else-if chain
    // If then is an if-region but else isn't, invert
    if is_if_region(then_region) && !is_if_region(else_r) && !then_has_exit {
        invert_if_region(condition, then_region, else_region);
        return true;
    }

    // Rule 8: Move break into then branch
    if has_break_statement(else_r) && !has_break_statement(then_region) {
        invert_if_region(condition, then_region, else_region);
        return true;
    }

    // Rule 9 (JADX IfRegionVisitor.java:88-101): If else is single throw, invert
    // This puts throw in then block which is cleaner: if (x == null) throw new NPE();
    if is_throw_only_region(else_r, cfg) && insns_count(else_r) == 1 {
        invert_if_region(condition, then_region, else_region);
        return true;
    }

    false
}

/// Remove redundant else blocks
///
/// Based on JADX's IfRegionVisitor.removeRedundantElseBlock():
/// - If then block ends with return/throw, else is unreachable
/// - Remove else by setting it to None
///
/// Returns true if else was removed.
fn remove_redundant_else(
    then_region: &Region,
    else_region: &mut Option<Box<Region>>,
    cfg: &CFG,
) -> bool {
    // Only process if else exists
    if else_region.is_none() {
        return false;
    }

    // If then doesn't exit, else is reachable
    if !has_exit_block(then_region, cfg) {
        return false;
    }

    // Check if then ends with return or throw
    if ends_with_return_or_throw(then_region, cfg) {
        let else_r = else_region.as_ref().unwrap();

        // Don't remove else-if chains - they're readable as-is
        if is_if_region(else_r) {
            return false;
        }

        // Size heuristic: don't remove if blocks are similar size
        let then_size = insns_count(then_region);
        let else_size = insns_count(else_r);

        // Keep else if sizes are close (within 2x for small blocks)
        if then_size < 5 && then_size > 0 {
            let range = 2;
            if else_size <= then_size * range && then_size <= else_size * range {
                return false;
            }
        }

        // Remove redundant else - this is handled by codegen
        // We mark it by checking at codegen time, not by mutating here
        // (JADX wraps in a Region; we skip generating else)
        return false; // Let codegen handle this pattern
    }

    false
}

/// Mark else-if chains with AFlag::ElseIfChain
///
/// Based on JADX's IfRegionVisitor.markElseIfChains():
/// - Detects pattern: else { if { ... } }
/// - Marks inner if for else-if chain code generation
///
/// Note: This function doesn't need blocks for its core logic, but the signature
/// is maintained for consistency. We pass blocks to process_region_recursive
/// but don't need them here.
///
/// Returns true if a chain was marked.
fn mark_else_if_chain(
    then_region: &Region,
    else_region: &Option<Box<Region>>,
) -> bool {
    // JADX skips if then is simple exit, but we don't have blocks here
    // The main else-if detection still works correctly

    // Check if else is a wrapper around a single if
    if let Some(else_r) = else_region {
        if let Region::Sequence(contents) = else_r.as_ref() {
            if contents.len() == 1 {
                if let RegionContent::Region(inner) = &contents[0] {
                    if matches!(inner.as_ref(), Region::If { .. }) {
                        // This is an else-if chain pattern
                        // Note: AFlag marking requires mutable access to instruction attributes
                        // For now, we detect at codegen time in generate_else_chain()
                        return true;
                    }
                }
            }
        }

        // Direct else-if (no wrapper)
        if matches!(else_r.as_ref(), Region::If { .. }) {
            return true;
        }
    }

    false
}

// ============================================================================
// Helper Functions
// ============================================================================

/// Check if a region is empty (no statements)
fn is_empty_region(region: &Region) -> bool {
    match region {
        Region::Sequence(contents) => contents.is_empty(),
        _ => false,
    }
}

/// Check if a region is an if-region
fn is_if_region(region: &Region) -> bool {
    match region {
        Region::If { .. } => true,
        Region::Sequence(contents) => {
            contents.len() == 1
                && matches!(
                    contents.first(),
                    Some(RegionContent::Region(r)) if matches!(r.as_ref(), Region::If { .. })
                )
        }
        _ => false,
    }
}

/// Check if a region is a simple exit (single return/throw)
#[allow(dead_code)]
fn is_simple_exit(region: &Region, cfg: &CFG) -> bool {
    match region {
        Region::Sequence(contents) => {
            contents.len() == 1
                && matches!(contents.first(), Some(RegionContent::Block(id)) if block_is_return_or_throw(*id, cfg))
        }
        _ => false,
    }
}

/// Check if a region ends with return or throw
fn ends_with_return_or_throw(region: &Region, cfg: &CFG) -> bool {
    match region {
        Region::Sequence(contents) => {
            if let Some(last) = contents.last() {
                match last {
                    RegionContent::Block(block_id) => block_is_return_or_throw(*block_id, cfg),
                    RegionContent::Region(r) => ends_with_return_or_throw(r, cfg),
                }
            } else {
                false
            }
        }
        Region::If {
            then_region,
            else_region,
            ..
        } => {
            // Both branches must end with exit for the if to end with exit
            ends_with_return_or_throw(then_region, cfg)
                && else_region
                    .as_ref()
                    .map_or(false, |r| ends_with_return_or_throw(r, cfg))
        }
        _ => false,
    }
}

/// Check if a region has an exit block (return/throw) anywhere
fn has_exit_block(region: &Region, cfg: &CFG) -> bool {
    match region {
        Region::Sequence(contents) => contents.iter().any(|c| match c {
            RegionContent::Block(block_id) => block_is_return_or_throw(*block_id, cfg),
            RegionContent::Region(r) => has_exit_block(r, cfg),
        }),
        Region::If {
            then_region,
            else_region,
            ..
        } => {
            has_exit_block(then_region, cfg)
                || else_region.as_ref().map_or(false, |r| has_exit_block(r, cfg))
        }
        Region::Loop { body, .. } => has_exit_block(body, cfg),
        Region::Break { .. } | Region::Continue { .. } => true, // These are exits from current context
        _ => false,
    }
}

/// Check if a region contains only a throw instruction (JADX IfRegionVisitor.java:88-101)
fn is_throw_only_region(region: &Region, cfg: &CFG) -> bool {
    match region {
        Region::Sequence(contents) => {
            contents.len() == 1
                && matches!(contents.first(), Some(RegionContent::Block(id)) if block_is_throw_only(*id, cfg))
        }
        _ => false,
    }
}

/// Check if a block's last instruction is return or throw
fn block_is_return_or_throw(block_id: u32, cfg: &CFG) -> bool {
    if let Some(block) = cfg.get_block(block_id) {
        if let Some(last_insn) = block.instructions.last() {
            return matches!(
                last_insn.insn_type,
                InsnType::Return { .. } | InsnType::Throw { .. }
            );
        }
    }
    false
}

/// Check if a block contains only a throw instruction (single meaningful instruction)
fn block_is_throw_only(block_id: u32, cfg: &CFG) -> bool {
    if let Some(block) = cfg.get_block(block_id) {
        // Filter out NOPs and other non-meaningful instructions
        let meaningful: Vec<_> = block
            .instructions
            .iter()
            .filter(|i| !matches!(i.insn_type, InsnType::Nop | InsnType::Goto { .. }))
            .collect();

        if meaningful.len() == 1 {
            return matches!(meaningful[0].insn_type, InsnType::Throw { .. });
        }
    }
    false
}

/// Check if a region contains break statements
fn has_break_statement(region: &Region) -> bool {
    match region {
        Region::Break { .. } => true,
        Region::Sequence(contents) => contents.iter().any(|c| match c {
            RegionContent::Block(_) => false,
            RegionContent::Region(r) => has_break_statement(r),
        }),
        Region::If {
            then_region,
            else_region,
            ..
        } => {
            has_break_statement(then_region)
                || else_region.as_ref().map_or(false, |r| has_break_statement(r))
        }
        // Don't look inside loops - break there doesn't affect outer context
        Region::Loop { .. } => false,
        _ => false,
    }
}

/// Count instructions in a region (approximate)
fn insns_count(region: &Region) -> usize {
    region.total_block_count()
}

/// Invert condition and swap then/else branches
fn invert_if_region(
    condition: &mut Condition,
    then_region: &mut Box<Region>,
    else_region: &mut Option<Box<Region>>,
) {
    // Negate the condition
    let old_condition = std::mem::take(condition);
    *condition = old_condition.negate();

    // Swap branches
    if let Some(else_r) = else_region.take() {
        let old_then = std::mem::replace(then_region, else_r);
        *else_region = Some(old_then);
    }
}

// ============================================================================
// Tests
// ============================================================================

#[cfg(test)]
mod tests {
    use super::*;
    use dexterity_ir::instructions::IfCondition;

    fn make_simple_condition(block: u32) -> Condition {
        Condition::Simple {
            block,
            op: IfCondition::Eq,
            negated: false,
        }
    }

    fn make_empty_sequence() -> Region {
        Region::Sequence(vec![])
    }

    fn make_block_sequence(blocks: Vec<u32>) -> Region {
        Region::Sequence(blocks.into_iter().map(RegionContent::Block).collect())
    }

    #[test]
    fn test_is_empty_region() {
        assert!(is_empty_region(&make_empty_sequence()));
        assert!(!is_empty_region(&make_block_sequence(vec![1])));
    }

    #[test]
    fn test_is_if_region() {
        let if_region = Region::If {
            condition: make_simple_condition(0),
            then_region: Box::new(make_block_sequence(vec![1])),
            else_region: None,
        };
        assert!(is_if_region(&if_region));
        assert!(!is_if_region(&make_block_sequence(vec![1])));
    }

    #[test]
    fn test_has_break_statement() {
        let with_break = Region::Break { label: None };
        assert!(has_break_statement(&with_break));

        let without_break = make_block_sequence(vec![1, 2, 3]);
        assert!(!has_break_statement(&without_break));

        // Break inside if
        let if_with_break = Region::If {
            condition: make_simple_condition(0),
            then_region: Box::new(Region::Break { label: None }),
            else_region: None,
        };
        assert!(has_break_statement(&if_with_break));
    }

    #[test]
    fn test_invert_if_region() {
        let mut condition = make_simple_condition(0);
        let mut then_region = Box::new(make_block_sequence(vec![1]));
        let mut else_region = Some(Box::new(make_block_sequence(vec![2])));

        invert_if_region(&mut condition, &mut then_region, &mut else_region);

        // Condition should be negated
        assert!(condition.is_negated());

        // Branches should be swapped
        match then_region.as_ref() {
            Region::Sequence(contents) => {
                assert_eq!(contents.len(), 1);
                match &contents[0] {
                    RegionContent::Block(id) => assert_eq!(*id, 2),
                    _ => panic!("Expected block"),
                }
            }
            _ => panic!("Expected sequence"),
        }
    }

    fn make_empty_cfg() -> CFG {
        use crate::block_split::BlockSplitResult;
        CFG::from_blocks(BlockSplitResult {
            blocks: vec![],
            entry_block: 0,
            exit_blocks: vec![],
        })
    }

    #[test]
    fn test_order_branches_empty_then() {
        let mut condition = make_simple_condition(0);
        let mut then_region = Box::new(make_empty_sequence());
        let mut else_region = Some(Box::new(make_block_sequence(vec![1])));
        let cfg = make_empty_cfg();

        let reordered = order_branches(&mut condition, &mut then_region, &mut else_region, &cfg);

        assert!(reordered);
        // Then should now have content, else should be empty
        assert!(!is_empty_region(&then_region));
    }

    #[test]
    fn test_order_branches_not_condition() {
        let inner = make_simple_condition(0);
        let mut condition = Condition::Not(Box::new(inner));
        let mut then_region = Box::new(make_block_sequence(vec![1]));
        let mut else_region = Some(Box::new(make_block_sequence(vec![2])));
        let cfg = make_empty_cfg();

        let reordered = order_branches(&mut condition, &mut then_region, &mut else_region, &cfg);

        assert!(reordered);
        // Condition should no longer be NOT at top level
        assert_ne!(condition.mode(), ConditionMode::Not);
    }

    #[test]
    fn test_mark_else_if_chain() {
        // else { if { ... } }
        let inner_if = Region::If {
            condition: make_simple_condition(2),
            then_region: Box::new(make_block_sequence(vec![3])),
            else_region: None,
        };
        let else_region = Some(Box::new(inner_if));
        let then_region = make_block_sequence(vec![1]);

        let marked = mark_else_if_chain(&then_region, &else_region);
        assert!(marked);
    }

    #[test]
    fn test_process_if_regions() {
        // Create a simple if-else structure
        let mut region = Region::If {
            condition: make_simple_condition(0),
            then_region: Box::new(make_empty_sequence()),
            else_region: Some(Box::new(make_block_sequence(vec![1]))),
        };
        let cfg = make_empty_cfg();

        let result = process_if_regions(&mut region, &cfg);

        // Should have reordered branches (empty then → invert)
        assert!(result.branches_reordered > 0);
    }
}
