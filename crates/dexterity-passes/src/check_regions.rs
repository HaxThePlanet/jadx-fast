//! Region validation pass
//!
//! This pass validates the region structure after region building:
//! - Ensures all basic blocks are included in regions
//! - Detects duplicated blocks
//! - Validates loop conditions (single instruction headers)
//! - Warns on missing blocks (code lost)
//!
//! Based on JADX's CheckRegions.java visitor.

use std::collections::HashSet;
use dexterity_ir::regions::{Region, RegionContent, LoopKind};
use dexterity_ir::attributes::AFlag;
use crate::BasicBlock;

/// Result of region validation
#[derive(Debug, Default)]
pub struct CheckRegionsResult {
    /// Blocks that are included in regions
    pub blocks_in_regions: HashSet<u32>,
    /// Blocks that are duplicated (appear in multiple regions)
    pub duplicated_blocks: Vec<u32>,
    /// Blocks that are missing from regions (code lost)
    pub missing_blocks: Vec<MissingBlock>,
    /// Warnings about loop conditions
    pub loop_warnings: Vec<LoopWarning>,
}

/// Information about a missing block
#[derive(Debug, Clone)]
pub struct MissingBlock {
    /// Block ID
    pub block_id: u32,
    /// Number of instructions in the block
    pub instruction_count: usize,
    /// Description of lost code (for warning message)
    pub code_description: String,
}

/// Warning about a loop condition
#[derive(Debug, Clone)]
pub struct LoopWarning {
    /// Header block ID
    pub header_block: u32,
    /// Number of instructions in header (expected 1)
    pub instruction_count: usize,
    /// Warning message
    pub message: String,
}

impl CheckRegionsResult {
    /// Check if validation passed (no missing blocks)
    pub fn is_valid(&self) -> bool {
        self.missing_blocks.is_empty()
    }

    /// Get all warnings as strings
    pub fn warnings(&self) -> Vec<String> {
        let mut warnings = Vec::new();

        for block in &self.missing_blocks {
            warnings.push(format!(
                "Code restructure failed: missing block: B{}, code lost: {}",
                block.block_id, block.code_description
            ));
        }

        for warning in &self.loop_warnings {
            warnings.push(warning.message.clone());
        }

        warnings
    }
}

/// Check regions for a method
///
/// # Arguments
/// * `region` - The root region of the method
/// * `blocks` - All basic blocks in the method
///
/// # Returns
/// * `CheckRegionsResult` with validation results
pub fn check_regions(region: &Region, blocks: &[BasicBlock]) -> CheckRegionsResult {
    let mut result = CheckRegionsResult::default();

    // Phase 1: Collect all blocks in regions
    collect_blocks_in_regions(region, &mut result.blocks_in_regions, &mut result.duplicated_blocks);

    // Phase 2: Check for missing blocks
    for block in blocks {
        // Skip blocks that are already in regions
        if result.blocks_in_regions.contains(&block.id) {
            continue;
        }

        // Skip empty blocks
        if block.instructions.is_empty() {
            continue;
        }

        // Skip blocks marked with special flags
        if block.has_flag(AFlag::AddedToRegion) {
            continue;
        }
        if block.has_flag(AFlag::DontGenerate) {
            continue;
        }
        if block.has_flag(AFlag::Remove) {
            continue;
        }

        // This block is missing
        let code_description = format!(
            "[{} instructions at offset {}]",
            block.instructions.len(),
            block.start_offset
        );

        result.missing_blocks.push(MissingBlock {
            block_id: block.id,
            instruction_count: block.instructions.len(),
            code_description,
        });
    }

    // Phase 3: Check loop conditions
    check_loop_conditions(region, blocks, &mut result.loop_warnings);

    result
}

/// Recursively collect all block IDs from a region
fn collect_blocks_in_regions(
    region: &Region,
    blocks_in_regions: &mut HashSet<u32>,
    duplicated: &mut Vec<u32>,
) {
    match region {
        Region::Sequence(contents) => {
            for content in contents {
                collect_from_content(content, blocks_in_regions, duplicated);
            }
        }

        Region::If { then_region, else_region, .. } => {
            collect_blocks_in_regions(then_region, blocks_in_regions, duplicated);
            if let Some(else_reg) = else_region {
                collect_blocks_in_regions(else_reg, blocks_in_regions, duplicated);
            }
        }

        Region::Loop { body, header_block, .. } => {
            // Add header block if present
            if let Some(header) = header_block {
                if !blocks_in_regions.insert(*header) {
                    duplicated.push(*header);
                }
            }
            collect_blocks_in_regions(body, blocks_in_regions, duplicated);
        }

        Region::Switch { header_block, cases } => {
            if !blocks_in_regions.insert(*header_block) {
                duplicated.push(*header_block);
            }
            for case in cases {
                collect_blocks_in_regions(&case.container, blocks_in_regions, duplicated);
            }
        }

        Region::TryCatch { try_region, handlers, finally } => {
            collect_blocks_in_regions(try_region, blocks_in_regions, duplicated);
            for handler in handlers {
                collect_blocks_in_regions(&handler.region, blocks_in_regions, duplicated);
            }
            if let Some(finally_region) = finally {
                collect_blocks_in_regions(finally_region, blocks_in_regions, duplicated);
            }
        }

        Region::Synchronized { enter_block, body, .. } => {
            if !blocks_in_regions.insert(*enter_block) {
                duplicated.push(*enter_block);
            }
            collect_blocks_in_regions(body, blocks_in_regions, duplicated);
        }

        Region::TernaryAssignment { then_value_block, else_value_block, .. } => {
            if !blocks_in_regions.insert(*then_value_block) {
                duplicated.push(*then_value_block);
            }
            if !blocks_in_regions.insert(*else_value_block) {
                duplicated.push(*else_value_block);
            }
        }

        Region::TernaryReturn { then_value_block, else_value_block, .. } => {
            if !blocks_in_regions.insert(*then_value_block) {
                duplicated.push(*then_value_block);
            }
            if !blocks_in_regions.insert(*else_value_block) {
                duplicated.push(*else_value_block);
            }
        }

        Region::Break { .. } | Region::Continue { .. } => {
            // No blocks to collect
        }
    }
}

/// Collect blocks from a RegionContent
fn collect_from_content(
    content: &RegionContent,
    blocks_in_regions: &mut HashSet<u32>,
    duplicated: &mut Vec<u32>,
) {
    match content {
        RegionContent::Block(block_id) => {
            if !blocks_in_regions.insert(*block_id) {
                duplicated.push(*block_id);
            }
        }
        RegionContent::Region(nested) => {
            collect_blocks_in_regions(nested, blocks_in_regions, duplicated);
        }
    }
}

/// Check loop conditions
fn check_loop_conditions(region: &Region, blocks: &[BasicBlock], warnings: &mut Vec<LoopWarning>) {
    match region {
        Region::Loop { header_block, body, kind, .. } => {
            // Check if header has single instruction (the condition)
            if let Some(header_id) = header_block {
                if let Some(header) = blocks.iter().find(|b| b.id == *header_id) {
                    // For conditional loops (while, for), header should have exactly 1 instruction
                    if !matches!(kind, LoopKind::Endless) {
                        if header.instructions.len() != 1 {
                            warnings.push(LoopWarning {
                                header_block: *header_id,
                                instruction_count: header.instructions.len(),
                                message: format!(
                                    "Incorrect condition in loop: B{} has {} instructions (expected 1)",
                                    header_id, header.instructions.len()
                                ),
                            });
                        }
                    }
                }
            }

            // Recursively check nested loops
            check_loop_conditions(body, blocks, warnings);
        }

        Region::Sequence(contents) => {
            for content in contents {
                if let RegionContent::Region(nested) = content {
                    check_loop_conditions(nested, blocks, warnings);
                }
            }
        }

        Region::If { then_region, else_region, .. } => {
            check_loop_conditions(then_region, blocks, warnings);
            if let Some(else_reg) = else_region {
                check_loop_conditions(else_reg, blocks, warnings);
            }
        }

        Region::Switch { cases, .. } => {
            for case in cases {
                check_loop_conditions(&case.container, blocks, warnings);
            }
        }

        Region::TryCatch { try_region, handlers, finally } => {
            check_loop_conditions(try_region, blocks, warnings);
            for handler in handlers {
                check_loop_conditions(&handler.region, blocks, warnings);
            }
            if let Some(finally_region) = finally {
                check_loop_conditions(finally_region, blocks, warnings);
            }
        }

        Region::Synchronized { body, .. } => {
            check_loop_conditions(body, blocks, warnings);
        }

        _ => {}
    }
}

/// Simple check for whether any blocks are missing from regions
pub fn has_missing_blocks(region: &Region, block_count: usize) -> bool {
    let mut blocks_in_regions = HashSet::new();
    let mut duplicated = Vec::new();
    collect_blocks_in_regions(region, &mut blocks_in_regions, &mut duplicated);
    blocks_in_regions.len() < block_count
}

#[cfg(test)]
mod tests {
    use super::*;

    fn make_block(id: u32, insn_count: usize) -> BasicBlock {
        BasicBlock {
            id,
            start_offset: id * 10,
            end_offset: id * 10 + 5,
            instructions: (0..insn_count)
                .map(|_| dexterity_ir::instructions::InsnNode::new(
                    dexterity_ir::instructions::InsnType::Nop,
                    0
                ))
                .collect(),
            successors: vec![],
            predecessors: vec![],
            flags: 0,
        }
    }

    #[test]
    fn test_sequence_covers_all() {
        let region = Region::Sequence(vec![
            RegionContent::Block(0),
            RegionContent::Block(1),
            RegionContent::Block(2),
        ]);

        let blocks = vec![
            make_block(0, 1),
            make_block(1, 1),
            make_block(2, 1),
        ];

        let result = check_regions(&region, &blocks);
        assert!(result.is_valid());
        assert_eq!(result.blocks_in_regions.len(), 3);
    }

    #[test]
    fn test_missing_block() {
        let region = Region::Sequence(vec![
            RegionContent::Block(0),
            RegionContent::Block(1),
            // Block 2 is missing!
        ]);

        let blocks = vec![
            make_block(0, 1),
            make_block(1, 1),
            make_block(2, 5), // 5 instructions lost
        ];

        let result = check_regions(&region, &blocks);
        assert!(!result.is_valid());
        assert_eq!(result.missing_blocks.len(), 1);
        assert_eq!(result.missing_blocks[0].block_id, 2);
    }

    #[test]
    fn test_empty_block_ok() {
        let region = Region::Sequence(vec![
            RegionContent::Block(0),
        ]);

        let blocks = vec![
            make_block(0, 1),
            make_block(1, 0), // Empty block - OK to be missing
        ];

        let result = check_regions(&region, &blocks);
        assert!(result.is_valid());
    }
}
