//! Collect Usage Region Visitor
//!
//! JADX Clone: jadx-core/src/main/java/jadx/core/dex/visitors/regions/variables/CollectUsageRegionVisitor.java
//! Original Author: Skylot (skylot@gmail.com)
//! Clone Date: Dec 2025
//! Lines: ~80
//!
//! This pass collects SSA variable usage information across regions:
//! - Tracks where each variable is assigned (which region/block)
//! - Tracks where each variable is used (which region/block)
//!
//! This information is used for:
//! - Proper variable declaration placement
//! - Determining variable scope
//! - Identifying variables that can be declared inline

use std::collections::HashMap;

use dexterity_ir::attributes::AFlag;
use dexterity_ir::instructions::{InsnArg, InsnNode};
use dexterity_ir::regions::Region;

/// Location where a variable is used (region + block)
#[derive(Debug, Clone, PartialEq, Eq, Hash)]
pub struct UsePlace {
    /// Region ID containing the use
    pub region_id: u32,
    /// Block ID within the region
    pub block_id: u32,
}

impl UsePlace {
    /// Create a new use place
    pub fn new(region_id: u32, block_id: u32) -> Self {
        UsePlace {
            region_id,
            block_id,
        }
    }
}

/// Usage information for a single SSA variable
#[derive(Debug, Default)]
pub struct VarUsage {
    /// SSA variable ID (version)
    pub var_id: u32,
    /// Register number
    pub reg_num: u16,
    /// Places where this variable is assigned
    pub assigns: Vec<UsePlace>,
    /// Places where this variable is used
    pub uses: Vec<UsePlace>,
}

impl VarUsage {
    /// Create new usage for an SSA variable
    pub fn new(var_id: u32, reg_num: u16) -> Self {
        VarUsage {
            var_id,
            reg_num,
            assigns: Vec::with_capacity(3),
            uses: Vec::with_capacity(3),
        }
    }

    /// Check if this variable has a single assignment
    pub fn is_single_assign(&self) -> bool {
        self.assigns.len() == 1
    }

    /// Check if this variable has a single use
    pub fn is_single_use(&self) -> bool {
        self.uses.len() == 1
    }

    /// Check if variable is used in the same block where it's assigned
    pub fn is_local_to_block(&self) -> bool {
        if self.assigns.len() != 1 {
            return false;
        }
        let assign_place = &self.assigns[0];
        self.uses
            .iter()
            .all(|u| u.block_id == assign_place.block_id)
    }
}

/// Map of SSA variable ID to its usage information
pub type UsageMap = HashMap<u32, VarUsage>;

/// Result of usage region collection
#[derive(Debug, Default)]
pub struct CollectUsageRegionResult {
    /// Usage map for all SSA variables
    pub usage_map: UsageMap,
    /// Number of variables with single assignment
    pub single_assign_count: usize,
    /// Number of variables with single use
    pub single_use_count: usize,
    /// Number of block-local variables
    pub block_local_count: usize,
}

/// Collect SSA variable usage across regions
///
/// JADX Reference: CollectUsageRegionVisitor.java
///
/// # Arguments
/// * `regions` - Region tree to traverse
/// * `instructions` - All instructions in method
///
/// # Returns
/// Usage map for all SSA variables found
pub fn collect_usage_regions(
    regions: &[Region],
    instructions: &[InsnNode],
) -> CollectUsageRegionResult {
    let mut usage_map = UsageMap::new();

    // Process each region
    for region in regions {
        collect_usage_in_region(region, instructions, &mut usage_map);
    }

    // Compute statistics
    let mut single_assign_count = 0;
    let mut single_use_count = 0;
    let mut block_local_count = 0;

    for usage in usage_map.values() {
        if usage.is_single_assign() {
            single_assign_count += 1;
        }
        if usage.is_single_use() {
            single_use_count += 1;
        }
        if usage.is_local_to_block() {
            block_local_count += 1;
        }
    }

    CollectUsageRegionResult {
        usage_map,
        single_assign_count,
        single_use_count,
        block_local_count,
    }
}

/// Collect usage in a single region (recursive)
fn collect_usage_in_region(region: &Region, instructions: &[InsnNode], usage_map: &mut UsageMap) {
    let region_id = match region {
        Region::Method { .. } => 0,
        Region::Loop { header_block, .. } => *header_block,
        Region::If {
            condition_block, ..
        } => *condition_block,
        Region::Switch { switch_block, .. } => *switch_block,
        Region::TryCatch { try_block, .. } => *try_block,
        Region::Synchronized { monitor_block, .. } => *monitor_block,
        Region::Sequence { blocks, .. } => blocks.first().copied().unwrap_or(0),
    };

    // Get blocks in this region
    let blocks = region.get_blocks();

    for &block_id in &blocks {
        let use_place = UsePlace::new(region_id, block_id);

        // Process for-loop init/incr if this is a loop region
        if let Region::Loop { for_loop_info, .. } = region {
            if let Some(for_info) = for_loop_info {
                // Process init instruction
                if let Some(init_offset) = for_info.init_insn_offset {
                    if let Some(insn) = find_insn_at_offset(instructions, init_offset) {
                        process_insn(insn, &use_place, usage_map);
                    }
                }
                // Process increment instruction
                if let Some(incr_offset) = for_info.incr_insn_offset {
                    if let Some(insn) = find_insn_at_offset(instructions, incr_offset) {
                        process_insn(insn, &use_place, usage_map);
                    }
                }
            }
        }

        // Find instructions in this block
        for insn in instructions {
            // Simple block membership check via offset ranges
            // In a real implementation, we'd have block -> instruction mapping
            // For now, process all instructions and rely on SSA variable IDs
            if should_process_insn_in_block(insn, block_id, instructions) {
                process_insn(insn, &use_place, usage_map);
            }
        }
    }

    // Recursively process child regions
    for child in region.get_children() {
        collect_usage_in_region(child, instructions, usage_map);
    }
}

/// Find instruction at a specific offset
fn find_insn_at_offset(instructions: &[InsnNode], offset: u32) -> Option<&InsnNode> {
    instructions.iter().find(|i| i.offset == offset)
}

/// Check if an instruction belongs to a block (simplified check)
fn should_process_insn_in_block(
    insn: &InsnNode,
    _block_id: u32,
    _instructions: &[InsnNode],
) -> bool {
    // In a real implementation, we'd check if insn.offset falls within block's range
    // For now, we process all non-skip instructions
    !insn.has_flag(AFlag::DontGenerate)
}

/// Process a single instruction for usage collection
///
/// JADX Reference: CollectUsageRegionVisitor.processInsn()
fn process_insn(insn: &InsnNode, use_place: &UsePlace, usage_map: &mut UsageMap) {
    // Process result (assignment)
    if let Some(result) = &insn.result {
        if let InsnArg::Register { reg, version, .. } = result {
            if !insn.has_flag(AFlag::DontGenerate) {
                let var_id = version.unwrap_or(0);
                let usage = usage_map
                    .entry(var_id)
                    .or_insert_with(|| VarUsage::new(var_id, *reg));
                usage.assigns.push(use_place.clone());
            }
        }
    }

    // Process args (uses)
    for arg in insn.get_register_args() {
        if let InsnArg::Register { reg, version, .. } = arg {
            if !insn.has_flag(AFlag::DontGenerate) {
                let var_id = version.unwrap_or(0);
                let usage = usage_map
                    .entry(var_id)
                    .or_insert_with(|| VarUsage::new(var_id, *reg));
                usage.uses.push(use_place.clone());
            }
        }
    }
}

/// Collect usage regions from SSA blocks
///
/// This is a simpler interface that works with SSA block data directly.
///
/// # Arguments
/// * `ssa_blocks` - SSA blocks from SSA transformation
/// * `region_mapping` - Optional mapping from block_id to region_id
///
/// # Returns
/// Usage map for all SSA variables
pub fn collect_usage_from_ssa_blocks(
    ssa_blocks: &[crate::ssa::SsaBlock],
    region_mapping: Option<&HashMap<u32, u32>>,
) -> CollectUsageRegionResult {
    let mut usage_map = UsageMap::new();

    for block in ssa_blocks {
        let block_id = block.id;
        let region_id = region_mapping
            .and_then(|m| m.get(&block_id))
            .copied()
            .unwrap_or(block_id);
        let use_place = UsePlace::new(region_id, block_id);

        // Process phi nodes (assignments)
        for phi in &block.phi_nodes {
            let var_id = phi.result_version;
            let usage = usage_map
                .entry(var_id)
                .or_insert_with(|| VarUsage::new(var_id, phi.reg));
            usage.assigns.push(use_place.clone());

            // Phi operands are uses
            for (_, operand_version) in &phi.operands {
                let usage = usage_map
                    .entry(*operand_version)
                    .or_insert_with(|| VarUsage::new(*operand_version, phi.reg));
                usage.uses.push(use_place.clone());
            }
        }

        // Process instructions
        for insn in &block.instructions {
            process_insn(insn, &use_place, &mut usage_map);
        }
    }

    // Compute statistics
    let mut single_assign_count = 0;
    let mut single_use_count = 0;
    let mut block_local_count = 0;

    for usage in usage_map.values() {
        if usage.is_single_assign() {
            single_assign_count += 1;
        }
        if usage.is_single_use() {
            single_use_count += 1;
        }
        if usage.is_local_to_block() {
            block_local_count += 1;
        }
    }

    CollectUsageRegionResult {
        usage_map,
        single_assign_count,
        single_use_count,
        block_local_count,
    }
}

#[cfg(test)]
mod tests {
    use super::*;

    #[test]
    fn test_use_place_equality() {
        let p1 = UsePlace::new(1, 2);
        let p2 = UsePlace::new(1, 2);
        let p3 = UsePlace::new(1, 3);

        assert_eq!(p1, p2);
        assert_ne!(p1, p3);
    }

    #[test]
    fn test_var_usage_single_assign() {
        let mut usage = VarUsage::new(1, 0);
        assert!(!usage.is_single_assign());

        usage.assigns.push(UsePlace::new(0, 0));
        assert!(usage.is_single_assign());

        usage.assigns.push(UsePlace::new(0, 1));
        assert!(!usage.is_single_assign());
    }

    #[test]
    fn test_var_usage_block_local() {
        let mut usage = VarUsage::new(1, 0);
        usage.assigns.push(UsePlace::new(0, 5));
        usage.uses.push(UsePlace::new(0, 5));
        usage.uses.push(UsePlace::new(0, 5));

        assert!(usage.is_local_to_block());

        // Add use in different block
        usage.uses.push(UsePlace::new(0, 6));
        assert!(!usage.is_local_to_block());
    }

    #[test]
    fn test_empty_collection() {
        let result = collect_usage_regions(&[], &[]);
        assert!(result.usage_map.is_empty());
        assert_eq!(result.single_assign_count, 0);
    }
}
