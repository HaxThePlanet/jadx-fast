//! Block splitting pass
//!
//! This pass takes a linear sequence of instructions and splits them into
//! basic blocks at branch points. A basic block is a sequence of instructions
//! where control flow enters at the beginning and leaves at the end.

use rustc_hash::{FxHashMap, FxHashSet};

use dexterity_ir::attributes::AFlag;
use dexterity_ir::instructions::{InsnNode, InsnType};

/// A basic block in the control flow graph
#[derive(Debug, Clone)]
pub struct BasicBlock {
    /// Block ID (unique within method)
    pub id: u32,
    /// Starting offset in the original code
    pub start_offset: u32,
    /// Ending offset (exclusive)
    pub end_offset: u32,
    /// Instructions in this block (owned, no Arc/Mutex overhead)
    pub instructions: Vec<InsnNode>,
    /// Successor block IDs
    pub successors: Vec<u32>,
    /// Predecessor block IDs
    pub predecessors: Vec<u32>,
    /// Attribute flags (for FINALLY_INSNS, DONT_GENERATE, etc.)
    pub flags: u64,
}

impl BasicBlock {
    /// Create a new basic block
    pub fn new(id: u32, start_offset: u32) -> Self {
        BasicBlock {
            id,
            start_offset,
            end_offset: start_offset,
            instructions: Vec::new(),
            successors: Vec::new(),
            predecessors: Vec::new(),
            flags: 0,
        }
    }

    /// Check if block is empty
    pub fn is_empty(&self) -> bool {
        self.instructions.is_empty()
    }

    /// Get the last instruction
    pub fn last_insn(&self) -> Option<&InsnNode> {
        self.instructions.last()
    }

    /// Get the last instruction mutably
    pub fn last_insn_mut(&mut self) -> Option<&mut InsnNode> {
        self.instructions.last_mut()
    }

    /// Check if a flag is set
    pub fn has_flag(&self, flag: AFlag) -> bool {
        (self.flags & (1 << flag as u8)) != 0
    }

    /// Set a flag
    pub fn add_flag(&mut self, flag: AFlag) {
        self.flags |= 1 << flag as u8;
    }

    /// Remove a flag
    pub fn remove_flag(&mut self, flag: AFlag) {
        self.flags &= !(1 << flag as u8);
    }
}

/// Result of block splitting
#[derive(Debug, Clone)]
pub struct BlockSplitResult {
    /// Basic blocks stored in a Vec (indexed by block.id)
    /// Vec is more cache-friendly and faster than BTreeMap for sequential access
    pub blocks: Vec<BasicBlock>,
    /// Entry block ID
    pub entry_block: u32,
    /// Exit block IDs (blocks that end with return/throw)
    pub exit_blocks: Vec<u32>,
}

impl BlockSplitResult {
    /// Get a block by ID - O(n) scan but blocks are typically sequential
    pub fn get_block(&self, id: u32) -> Option<&BasicBlock> {
        self.blocks.iter().find(|b| b.id == id)
    }

    /// Get a mutable block by ID
    pub fn get_block_mut(&mut self, id: u32) -> Option<&mut BasicBlock> {
        self.blocks.iter_mut().find(|b| b.id == id)
    }

    /// Iterate over blocks in order
    pub fn blocks_iter(&self) -> impl Iterator<Item = &BasicBlock> {
        self.blocks.iter()
    }

    /// Get block count
    pub fn block_count(&self) -> usize {
        self.blocks.len()
    }

    /// Get all block IDs
    pub fn block_ids(&self) -> impl Iterator<Item = u32> + '_ {
        self.blocks.iter().map(|b| b.id)
    }
}

/// Split instructions into basic blocks
/// Takes a reference to avoid unnecessary Vec cloning - instructions are only cloned when moved into blocks
pub fn split_blocks(instructions: &[InsnNode]) -> BlockSplitResult {
    if instructions.is_empty() {
        return BlockSplitResult {
            blocks: Vec::new(),
            entry_block: 0,
            exit_blocks: Vec::new(),
        };
    }

    // First pass: find all block leaders (start points)
    // Use FxHashSet for O(1) insertions instead of BTreeSet's O(log N)
    let mut leaders = FxHashSet::default();
    leaders.insert(0u32); // First instruction is always a leader

    for insn in instructions {
        match &insn.insn_type {
            // Branch targets are leaders
            InsnType::Goto { target } => {
                leaders.insert(*target);
            }
            InsnType::If { target, .. } => {
                leaders.insert(*target);
                // Instruction after conditional branch is also a leader
                leaders.insert(insn.offset + 1); // Approximate - should use actual next offset
            }
            InsnType::PackedSwitch { .. } | InsnType::SparseSwitch { .. } => {
                // Switch targets would be added here once we parse the payload
            }
            // Instructions after returns/throws start new blocks (for exception handlers)
            InsnType::Return { .. } | InsnType::Throw { .. } => {
                // Next instruction (if any) is a leader
            }
            _ => {}
        }
    }

    // Build offset -> instruction index mapping
    // Use FxHashMap for O(1) lookups instead of BTreeMap's O(log N)
    let mut offset_to_idx: FxHashMap<u32, usize> = FxHashMap::default();
    for (idx, insn) in instructions.iter().enumerate() {
        offset_to_idx.insert(insn.offset, idx);
    }

    // Create leader set based on instruction indices
    // Use FxHashSet for O(1) membership tests
    let leader_indices: FxHashSet<usize> = leaders
        .iter()
        .filter_map(|&offset| offset_to_idx.get(&offset).copied())
        .collect();

    // Also mark instructions after terminators as leaders
    let mut extended_leaders = leader_indices.clone();
    for (idx, insn) in instructions.iter().enumerate() {
        if is_terminator(&insn.insn_type) && idx + 1 < instructions.len() {
            extended_leaders.insert(idx + 1);
        }
    }

    // Second pass: distribute instructions directly to blocks (no Arc/Mutex overhead)
    // Each instruction is cloned once into its block - simple and memory-efficient
    let mut blocks: Vec<BasicBlock> = Vec::new();
    let mut current_block: Option<BasicBlock> = None;
    let mut block_id = 0u32;
    // Use FxHashMap for O(1) lookups during successor resolution
    let mut offset_to_block: FxHashMap<u32, u32> = FxHashMap::default();

    for (idx, insn) in instructions.iter().enumerate() {
        let offset = insn.offset;

        // Check if we need to start a new block
        if extended_leaders.contains(&idx) {
            // Save current block
            if let Some(block) = current_block.take() {
                if !block.is_empty() {
                    blocks.push(block);
                }
            }

            // Start new block
            let new_block = BasicBlock::new(block_id, offset);
            offset_to_block.insert(offset, block_id);
            current_block = Some(new_block);
            block_id += 1;
        }

        // Clone instruction directly into block (single clone, no Arc overhead)
        if let Some(ref mut block) = current_block {
            block.end_offset = offset + 1; // Approximate
            block.instructions.push(insn.clone());
        }
    }

    // Save final block
    if let Some(block) = current_block {
        if !block.is_empty() {
            blocks.push(block);
        }
    }

    // Third pass: compute successors and predecessors
    let block_ids: Vec<u32> = blocks.iter().map(|b| b.id).collect();

    for &block_id in &block_ids {
        let successors = {
            let block = blocks.iter().find(|b| b.id == block_id).unwrap();
            compute_successors(block, &offset_to_block, &block_ids)
        };

        // Add successors to current block
        if let Some(block) = blocks.iter_mut().find(|b| b.id == block_id) {
            block.successors = successors.clone();
        }

        // Add this block as predecessor to successors
        for &succ_id in &successors {
            if let Some(succ_block) = blocks.iter_mut().find(|b| b.id == succ_id) {
                if !succ_block.predecessors.contains(&block_id) {
                    succ_block.predecessors.push(block_id);
                }
            }
        }
    }

    // Find exit blocks
    let exit_blocks: Vec<u32> = blocks
        .iter()
        .filter(|block| {
            block.last_insn().map_or(false, |insn| {
                matches!(insn.insn_type, InsnType::Return { .. } | InsnType::Throw { .. })
            })
        })
        .map(|block| block.id)
        .collect();

    BlockSplitResult {
        blocks,
        entry_block: 0,
        exit_blocks,
    }
}

/// Check if an instruction is a block terminator
fn is_terminator(insn_type: &InsnType) -> bool {
    matches!(
        insn_type,
        InsnType::Goto { .. }
            | InsnType::If { .. }
            | InsnType::Return { .. }
            | InsnType::Throw { .. }
            | InsnType::PackedSwitch { .. }
            | InsnType::SparseSwitch { .. }
    )
}

/// Compute successors for a block
fn compute_successors(
    block: &BasicBlock,
    offset_to_block: &FxHashMap<u32, u32>,
    all_blocks: &[u32],
) -> Vec<u32> {
    let mut successors = Vec::new();

    if let Some(last_insn) = block.last_insn() {
        match &last_insn.insn_type {
            InsnType::Goto { target } => {
                if let Some(&target_block) = offset_to_block.get(target) {
                    successors.push(target_block);
                }
            }
            InsnType::If { target, .. } => {
                // Fall-through successor
                if let Some(&next_block) = find_next_block(block.id, all_blocks) {
                    successors.push(next_block);
                }
                // Branch target successor
                if let Some(&target_block) = offset_to_block.get(target) {
                    if !successors.contains(&target_block) {
                        successors.push(target_block);
                    }
                }
            }
            InsnType::Return { .. } | InsnType::Throw { .. } => {
                // No successors
            }
            InsnType::PackedSwitch { targets, .. } => {
                // Add all case targets
                for target in targets {
                    if let Some(&target_block) = offset_to_block.get(target) {
                        if !successors.contains(&target_block) {
                            successors.push(target_block);
                        }
                    }
                }
                // Add default case (fall-through to next block)
                if let Some(&next_block) = find_next_block(block.id, all_blocks) {
                    if !successors.contains(&next_block) {
                        successors.push(next_block);
                    }
                }
            }
            InsnType::SparseSwitch { targets, .. } => {
                // Add all case targets
                for target in targets {
                    if let Some(&target_block) = offset_to_block.get(target) {
                        if !successors.contains(&target_block) {
                            successors.push(target_block);
                        }
                    }
                }
                // Add default case (fall-through to next block)
                if let Some(&next_block) = find_next_block(block.id, all_blocks) {
                    if !successors.contains(&next_block) {
                        successors.push(next_block);
                    }
                }
            }
            _ => {
                // Fall through to next block
                if let Some(&next_block) = find_next_block(block.id, all_blocks) {
                    successors.push(next_block);
                }
            }
        }
    }

    successors
}

/// Find the next block after the given block ID
fn find_next_block(block_id: u32, all_blocks: &[u32]) -> Option<&u32> {
    let pos = all_blocks.iter().position(|&id| id == block_id)?;
    all_blocks.get(pos + 1)
}

#[cfg(test)]
mod tests {
    use super::*;
    use dexterity_ir::instructions::{InsnArg, IfCondition};

    fn make_nop(offset: u32) -> InsnNode {
        InsnNode::new(InsnType::Nop, offset)
    }

    fn make_return(offset: u32) -> InsnNode {
        InsnNode::new(InsnType::Return { value: None }, offset)
    }

    fn make_goto(offset: u32, target: u32) -> InsnNode {
        InsnNode::new(InsnType::Goto { target }, offset)
    }

    fn make_if(offset: u32, target: u32) -> InsnNode {
        InsnNode::new(
            InsnType::If {
                condition: IfCondition::Eq,
                left: InsnArg::reg(0),
                right: None,
                target,
            },
            offset,
        )
    }

    #[test]
    fn test_empty_instructions() {
        let result = split_blocks(&vec![]);
        assert_eq!(result.block_count(), 0);
    }

    #[test]
    fn test_single_block() {
        let instructions = vec![make_nop(0), make_nop(1), make_return(2)];
        let result = split_blocks(&instructions);

        assert_eq!(result.block_count(), 1);
        assert_eq!(result.entry_block, 0);
        assert_eq!(result.exit_blocks, vec![0]);

        let block = result.get_block(0).unwrap();
        assert_eq!(block.instructions.len(), 3);
    }

    #[test]
    fn test_goto_splits_block() {
        let instructions = vec![
            make_nop(0),
            make_goto(1, 3),
            make_nop(2),
            make_return(3),
        ];
        let result = split_blocks(&instructions);

        // Should have 3 blocks: [nop, goto], [nop], [return]
        assert_eq!(result.block_count(), 3);
    }

    #[test]
    fn test_if_creates_two_successors() {
        let instructions = vec![
            make_if(0, 2),  // if-eqz goto 2
            make_nop(1),    // fall-through
            make_return(2), // branch target
        ];
        let result = split_blocks(&instructions);

        // Block 0 should have 2 successors
        let block0 = result.get_block(0).unwrap();
        assert_eq!(block0.successors.len(), 2);
    }

    #[test]
    fn test_predecessors_computed() {
        let instructions = vec![
            make_goto(0, 2),
            make_nop(1),
            make_return(2),
        ];
        let result = split_blocks(&instructions);

        // Block with return should have block 0 as predecessor
        if let Some(exit_block) = result.get_block(result.exit_blocks[0]) {
            assert!(!exit_block.predecessors.is_empty());
        }
    }
}
