//! CleanRegions pass - Remove empty blocks and regions from the region tree
//!
//! This pass performs depth-first traversal of the region tree and removes:
//! - Blocks with DONT_GENERATE flag
//! - Empty blocks (no instructions)
//! - Regions where all children are removable
//!
//! Preserves:
//! - Empty endless loops (while(true) {})
//!
//! Equivalent to JADX's CleanRegions.java

use dexterity_ir::{
    attributes::AFlag,
    regions::{LoopKind, Region, RegionContent},
};
use crate::ssa::SsaBlock;

/// Result of clean regions pass
#[derive(Debug, Default)]
pub struct CleanRegionsResult {
    /// Number of blocks removed
    pub blocks_removed: usize,
    /// Number of regions removed
    pub regions_removed: usize,
}

/// Clean empty regions from a region tree
///
/// # Arguments
/// * `region` - The root region to clean
/// * `blocks` - The SSA blocks for checking emptiness
///
/// # Returns
/// - `Some(region)` if region should be kept (possibly modified)
/// - `None` if region should be removed
pub fn clean_regions(region: &mut Region, blocks: &[SsaBlock]) -> CleanRegionsResult {
    let mut result = CleanRegionsResult::default();
    clean_region_recursive(region, blocks, &mut result);
    result
}

/// Check if a region is removable and clean it recursively
fn clean_region_recursive(region: &mut Region, blocks: &[SsaBlock], result: &mut CleanRegionsResult) {
    match region {
        Region::Sequence(contents) => {
            // Remove empty children
            let original_len = contents.len();
            contents.retain_mut(|content| {
                !can_remove_content(content, blocks, result)
            });
            result.regions_removed += original_len.saturating_sub(contents.len());

            // Recursively clean remaining children
            for content in contents.iter_mut() {
                if let RegionContent::Region(nested) = content {
                    clean_region_recursive(nested, blocks, result);
                }
            }
        }

        Region::If { then_region, else_region, .. } => {
            // Clean then branch
            clean_region_recursive(then_region, blocks, result);

            // Clean else branch if present
            if let Some(else_reg) = else_region {
                clean_region_recursive(else_reg, blocks, result);
                // Remove else if it's now empty
                if region_is_removable(else_reg, blocks) {
                    *else_region = None;
                    result.regions_removed += 1;
                }
            }
        }

        Region::Loop { body, kind, .. } => {
            // Don't remove endless loops even if empty
            if matches!(kind, LoopKind::Endless) {
                // Keep endless loops, just clean body
                clean_region_recursive(body, blocks, result);
            } else {
                // Clean body
                clean_region_recursive(body, blocks, result);
            }
        }

        Region::Switch { cases, .. } => {
            // Clean each case (default is one of the cases)
            for case in cases.iter_mut() {
                clean_region_recursive(&mut case.container, blocks, result);
            }
        }

        Region::TryCatch { try_region, handlers, finally } => {
            // Clean try region
            clean_region_recursive(try_region, blocks, result);

            // Clean handlers
            for handler in handlers.iter_mut() {
                clean_region_recursive(&mut handler.region, blocks, result);
            }

            // Clean finally
            if let Some(finally_reg) = finally {
                clean_region_recursive(finally_reg, blocks, result);
            }
        }

        Region::Synchronized { body, .. } => {
            clean_region_recursive(body, blocks, result);
        }

        // Break/Continue/TernaryAssignment/TernaryReturn are leaf nodes
        Region::Break { .. } | Region::Continue { .. } |
        Region::TernaryAssignment { .. } | Region::TernaryReturn { .. } => {}
    }
}

/// Check if a RegionContent can be removed
fn can_remove_content(content: &mut RegionContent, blocks: &[SsaBlock], result: &mut CleanRegionsResult) -> bool {
    match content {
        RegionContent::Block(block_id) => {
            let block_idx = *block_id as usize;
            if block_idx < blocks.len() {
                let block = &blocks[block_idx];
                // Remove if:
                // 1. All instructions have DONT_GENERATE flag
                // 2. Block has no instructions
                let is_empty = block.instructions.is_empty();
                let all_dont_generate = !block.instructions.is_empty() &&
                    block.instructions.iter().all(|i| i.has_flag(AFlag::DontGenerate));

                if is_empty || all_dont_generate {
                    result.blocks_removed += 1;
                    return true;
                }
            }
            false
        }
        RegionContent::Region(nested) => {
            // First clean the nested region
            clean_region_recursive(nested, blocks, result);
            // Then check if it's removable
            region_is_removable(nested, blocks)
        }
    }
}

/// Check if a region is removable (all children are empty/removable)
fn region_is_removable(region: &Region, blocks: &[SsaBlock]) -> bool {
    match region {
        Region::Sequence(contents) => {
            contents.iter().all(|c| content_is_removable(c, blocks))
        }

        Region::If { then_region, else_region, .. } => {
            region_is_removable(then_region, blocks) &&
            else_region.as_ref().map(|e| region_is_removable(e, blocks)).unwrap_or(true)
        }

        Region::Loop { kind, body, .. } => {
            // Don't remove endless loops
            if matches!(kind, LoopKind::Endless) {
                false
            } else {
                region_is_removable(body, blocks)
            }
        }

        Region::Switch { cases, .. } => {
            cases.iter().all(|c| region_is_removable(&c.container, blocks))
        }

        Region::TryCatch { try_region, handlers, finally } => {
            region_is_removable(try_region, blocks) &&
            handlers.iter().all(|h| region_is_removable(&h.region, blocks)) &&
            finally.as_ref().map(|f| region_is_removable(f, blocks)).unwrap_or(true)
        }

        Region::Synchronized { body, .. } => {
            region_is_removable(body, blocks)
        }

        // Break/Continue are not removable (they have semantic meaning)
        Region::Break { .. } | Region::Continue { .. } => false,

        // Ternary expressions are not removable
        Region::TernaryAssignment { .. } | Region::TernaryReturn { .. } => false,
    }
}

/// Check if a RegionContent is removable
fn content_is_removable(content: &RegionContent, blocks: &[SsaBlock]) -> bool {
    match content {
        RegionContent::Block(block_id) => {
            let block_idx = *block_id as usize;
            if block_idx < blocks.len() {
                let block = &blocks[block_idx];
                block.instructions.is_empty() ||
                block.instructions.iter().all(|i| i.has_flag(AFlag::DontGenerate))
            } else {
                false
            }
        }
        RegionContent::Region(nested) => {
            region_is_removable(nested, blocks)
        }
    }
}

#[cfg(test)]
mod tests {
    use super::*;
    use dexterity_ir::instructions::{InsnNode, InsnType};
    use dexterity_ir::types::ArgType;

    fn make_block(id: u32, instructions: Vec<InsnNode>) -> SsaBlock {
        SsaBlock {
            id,
            phi_nodes: vec![],
            instructions,
            successors: vec![],
            predecessors: vec![],
        }
    }

    fn make_nop_insn() -> InsnNode {
        InsnNode {
            insn_type: InsnType::Nop,
            offset: 0,
            flags: 0,
            result_type: Some(ArgType::Void),
            source_line: None,
        }
    }

    #[test]
    fn test_empty_block_removal() {
        let blocks = vec![
            make_block(0, vec![]),
        ];

        let mut region = Region::Sequence(vec![
            RegionContent::Block(0),
        ]);

        let result = clean_regions(&mut region, &blocks);

        assert_eq!(result.blocks_removed, 1);
        if let Region::Sequence(contents) = &region {
            assert!(contents.is_empty());
        }
    }

    #[test]
    fn test_endless_loop_preserved() {
        let blocks = vec![
            make_block(0, vec![]),
        ];

        let mut region = Region::Loop {
            kind: LoopKind::Endless,
            condition: None,
            body: Box::new(Region::Sequence(vec![])),
            details: None,
            loop_type: dexterity_ir::regions::LoopType::None,
            condition_at_end: false,
            header_block: None,
            pre_condition_block: None,
            label: None,
        };

        let _result = clean_regions(&mut region, &blocks);

        // Endless loop should be preserved
        assert!(matches!(region, Region::Loop { .. }));
    }

    #[test]
    fn test_non_empty_block_preserved() {
        let blocks = vec![
            make_block(0, vec![make_nop_insn()]),
        ];

        let mut region = Region::Sequence(vec![
            RegionContent::Block(0),
        ]);

        let result = clean_regions(&mut region, &blocks);

        assert_eq!(result.blocks_removed, 0);
        if let Region::Sequence(contents) = &region {
            assert_eq!(contents.len(), 1);
        }
    }
}
