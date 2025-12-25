//! Fallback method body generator
//!
//! Used when the standard decompilation pipeline fails.
//! Implements JADX's SimpleModeHelper algorithm for:
//! - DFS block sorting to minimize gotos
//! - Empty block removal
//! - Label generation for multi-predecessor blocks
//! - Goto generation for non-fallthrough control flow
//!
//! Reference: jadx-core/src/main/java/jadx/core/dex/visitors/SimpleModeVisitor.java

use std::collections::{HashMap, HashSet, VecDeque};
use dexterity_ir::instructions::{InsnNode, InsnType};
use dexterity_passes::{BasicBlock, BlockSplitResult};
use crate::writer::CodeWriter;

/// Generate method body in fallback mode (raw instructions)
/// Simple dump without block structure
pub fn generate_fallback_body<W: CodeWriter>(insns: &[InsnNode], code: &mut W) {
    code.start_line().add("// Method generation failed or fallback mode requested").newline();
    code.start_line().add("// dumping raw instructions").newline();

    if insns.is_empty() {
        code.start_line().add("// No instructions found").newline();
        return;
    }

    code.start_line().add("{").newline();
    code.inc_indent();

    for insn in insns {
        // Format instruction first to check for comment escape
        let insn_str = format_insn_fallback(insn);

        /// Clone of JADX MethodGen.isCommentEscapeNeeded
        /// Reference: jadx-core/src/main/java/jadx/core/codegen/MethodGen.java:513-521
        ///
        /// When dumping bytecode as multi-line comments, strings containing `*/`
        /// will break the comment block. JADX temporarily closes the comment,
        /// uses a single-line comment for that instruction, then re-opens.
        let escape_comment = insn_str.contains("*/");

        if escape_comment {
            // Close multi-line comment temporarily
            code.dec_indent();
            code.start_line().add("*/").newline();
            code.start_line().add("//  ");
            code.add(&format!("{:04x} ", insn.offset));
        } else {
            code.start_line();
            // Format: /* 000a */ <instruction>
            code.add(&format!("/* {:04x} */ ", insn.offset));
        }

        code.add(&insn_str);
        code.add(";");
        code.newline();

        if escape_comment {
            // Re-open multi-line comment
            code.start_line().add("/*").newline();
            code.inc_indent();
        }
    }

    code.dec_indent();
    code.start_line().add("}").newline();
}

/// Format instruction for fallback view
fn format_insn_fallback(insn: &InsnNode) -> String {
    // For now, use the Debug implementation which is reasonably readable for IR
    // In the future, we could make this look more like Java/Smali
    format!("{:?}", insn.insn_type)
}

/// SimpleModeHelper - JADX-style simple mode generation with block structure
///
/// Clone of JADX's SimpleModeVisitor that generates code in simple mode
/// when region analysis fails. Uses DFS ordering to minimize gotos.
pub struct SimpleModeHelper<'a> {
    /// Blocks sorted in DFS order
    sorted_blocks: Vec<&'a BasicBlock>,
    /// Set of blocks that need labels (have multiple predecessors or are jump targets)
    needs_label: HashSet<u32>,
    /// Set of blocks that end with goto (next block is not fallthrough)
    needs_goto: HashSet<u32>,
    /// Map from block ID to its position in sorted order
    block_positions: HashMap<u32, usize>,
}

impl<'a> SimpleModeHelper<'a> {
    /// Create a new SimpleModeHelper from block split result
    ///
    /// Clone of JADX's SimpleModeVisitor.process()
    pub fn new(block_result: &'a BlockSplitResult) -> Self {
        let mut helper = SimpleModeHelper {
            sorted_blocks: Vec::new(),
            needs_label: HashSet::new(),
            needs_goto: HashSet::new(),
            block_positions: HashMap::new(),
        };

        helper.process(block_result);
        helper
    }

    /// Process blocks: DFS sort, detect labels and gotos
    fn process(&mut self, block_result: &'a BlockSplitResult) {
        if block_result.blocks.is_empty() {
            return;
        }

        // Step 1: DFS sort to minimize gotos (JADX's sortBlocks)
        self.dfs_sort(block_result);

        // Step 2: Remove empty blocks that just jump (JADX's removeEmptyBlocks)
        // Note: We don't actually remove, just skip during generation

        // Step 3: Detect which blocks need labels (JADX's markLabels)
        self.mark_labels();

        // Step 4: Detect which blocks need goto at end (JADX's markGotos)
        self.mark_gotos(block_result);
    }

    /// DFS sort blocks to minimize the number of required gotos
    ///
    /// Clone of JADX's sortBlocks() method
    fn dfs_sort(&mut self, block_result: &'a BlockSplitResult) {
        let mut visited = HashSet::new();
        let mut work_queue = VecDeque::new();

        // Start from entry block
        if let Some(entry) = block_result.get_block(block_result.entry_block) {
            work_queue.push_back(entry);
            visited.insert(entry.id);
        }

        // DFS traversal
        while let Some(block) = work_queue.pop_front() {
            self.sorted_blocks.push(block);
            self.block_positions.insert(block.id, self.sorted_blocks.len() - 1);

            // Add successors in reverse order so first successor is processed last (goes first)
            let mut successors: Vec<_> = block.successors.iter()
                .filter_map(|id| block_result.get_block(*id))
                .filter(|b| !visited.contains(&b.id))
                .collect();

            // Sort to prefer fallthrough: immediate successor (offset-adjacent) first
            successors.sort_by_key(|b| {
                // Prefer block that immediately follows in offset order
                if b.start_offset == block.end_offset {
                    0 // Fallthrough candidate
                } else {
                    1
                }
            });

            // Push in reverse order so first goes to front of work queue
            for succ in successors.into_iter().rev() {
                if visited.insert(succ.id) {
                    work_queue.push_front(succ);
                }
            }
        }

        // Add any unreachable blocks (exception handlers, etc)
        for block in &block_result.blocks {
            if !visited.contains(&block.id) {
                visited.insert(block.id);
                self.sorted_blocks.push(block);
                self.block_positions.insert(block.id, self.sorted_blocks.len() - 1);
            }
        }
    }

    /// Mark blocks that need labels
    ///
    /// A block needs a label if:
    /// - It has multiple predecessors (merge point)
    /// - It's a jump target from non-adjacent block
    ///
    /// Clone of JADX's markLabels()
    fn mark_labels(&mut self) {
        for (pos, block) in self.sorted_blocks.iter().enumerate() {
            // Multiple predecessors means it's a merge point
            if block.predecessors.len() > 1 {
                self.needs_label.insert(block.id);
                continue;
            }

            // Check if any predecessor is not the immediately preceding block
            if let Some(pred_id) = block.predecessors.first() {
                if let Some(pred_pos) = self.block_positions.get(pred_id) {
                    // If predecessor is not immediately before, we need a label
                    if *pred_pos + 1 != pos {
                        self.needs_label.insert(block.id);
                    }
                }
            }

            // First block doesn't need label (it's the entry point)
            if pos == 0 && block.predecessors.is_empty() {
                self.needs_label.remove(&block.id);
            }
        }
    }

    /// Mark blocks that need goto at the end
    ///
    /// A block needs goto if its successor is not the next block in sorted order
    ///
    /// Clone of JADX's markGotos()
    fn mark_gotos(&mut self, block_result: &'a BlockSplitResult) {
        for (pos, block) in self.sorted_blocks.iter().enumerate() {
            // Skip blocks that end with return/throw (no fallthrough possible)
            if is_exit_instruction(block) {
                continue;
            }

            // Get the natural successor (for if/goto, it's the target; for fallthrough, it's next offset)
            if let Some(succ_id) = get_fallthrough_successor(block, block_result) {
                if let Some(succ_pos) = self.block_positions.get(&succ_id) {
                    // If successor is not immediately after this block, need goto
                    if *succ_pos != pos + 1 {
                        self.needs_goto.insert(block.id);
                        // Also mark target as needing label
                        self.needs_label.insert(succ_id);
                    }
                }
            }
        }
    }

    /// Generate code in simple mode with labels and gotos
    pub fn generate<W: CodeWriter>(&self, code: &mut W) {
        code.start_line().add("// Simple mode: region analysis failed").newline();
        code.start_line().add("// Generated with labels and gotos").newline();
        code.newline();

        for (pos, block) in self.sorted_blocks.iter().enumerate() {
            // Skip truly empty blocks
            if block.instructions.is_empty() && !self.needs_label.contains(&block.id) {
                continue;
            }

            // Generate label if needed
            if self.needs_label.contains(&block.id) {
                // Use block offset as label name for readability
                code.start_line().add(&format!("L_{:04x}:", block.start_offset)).newline();
            }

            // Generate instructions
            for insn in &block.instructions {
                // Format instruction first to check for comment escape
                let insn_str = format_insn_simple(insn);

                /// Clone of JADX MethodGen.isCommentEscapeNeeded
                /// Reference: jadx-core/src/main/java/jadx/core/codegen/MethodGen.java:513-521
                let escape_comment = insn_str.contains("*/");

                if escape_comment {
                    // Close multi-line comment temporarily
                    code.start_line().add("*/").newline();
                    code.start_line().add("//  ");
                    code.add(&format!("{:04x} ", insn.offset));
                } else {
                    code.start_line();
                    code.add(&format!("/* {:04x} */ ", insn.offset));
                }

                code.add(&insn_str);
                code.add(";");
                code.newline();

                if escape_comment {
                    // Re-open multi-line comment
                    code.start_line().add("/*").newline();
                }
            }

            // Generate goto if needed
            if self.needs_goto.contains(&block.id) {
                if let Some(target) = self.get_goto_target(block, pos) {
                    code.start_line().add(&format!("goto L_{:04x};", target)).newline();
                }
            }

            // Add blank line between blocks for readability
            if pos < self.sorted_blocks.len() - 1 {
                code.newline();
            }
        }
    }

    /// Get the goto target offset for a block
    fn get_goto_target(&self, block: &BasicBlock, _pos: usize) -> Option<u32> {
        // For if instructions, the goto target is the else branch
        if let Some(last) = block.instructions.last() {
            match &last.insn_type {
                InsnType::Goto { target } => return Some(*target),
                InsnType::If { target, .. } => {
                    // For if, we need the fallthrough, not the target
                    // The fallthrough is the successor that's not the target
                    for succ_id in &block.successors {
                        if let Some(succ) = self.sorted_blocks.iter().find(|b| b.id == *succ_id) {
                            if succ.start_offset != *target {
                                return Some(succ.start_offset);
                            }
                        }
                    }
                }
                _ => {}
            }
        }

        // Fallback: use first successor
        if let Some(succ_id) = block.successors.first() {
            if let Some(succ) = self.sorted_blocks.iter().find(|b| b.id == *succ_id) {
                return Some(succ.start_offset);
            }
        }

        None
    }
}

/// Check if block ends with exit instruction (return/throw)
fn is_exit_instruction(block: &BasicBlock) -> bool {
    if let Some(last) = block.instructions.last() {
        matches!(last.insn_type, InsnType::Return { .. } | InsnType::Throw { .. })
    } else {
        false
    }
}

/// Get the fallthrough successor for a block
fn get_fallthrough_successor(block: &BasicBlock, _block_result: &BlockSplitResult) -> Option<u32> {
    if let Some(last) = block.instructions.last() {
        match &last.insn_type {
            InsnType::Goto { target } => {
                // For goto, the "fallthrough" is the target
                // Find block that starts at target offset
                return Some(*target);
            }
            InsnType::If { .. } => {
                // For if, we have two successors - the fallthrough is the non-target
                // Actually, for simple mode we only care if any successor needs goto
                return block.successors.first().copied();
            }
            InsnType::PackedSwitch { .. } | InsnType::SparseSwitch { .. } => {
                // Switch has multiple successors, no simple fallthrough
                return None;
            }
            InsnType::Return { .. } | InsnType::Throw { .. } => {
                // No fallthrough for exits
                return None;
            }
            _ => {}
        }
    }

    // Default: first successor
    block.successors.first().copied()
}

/// Format instruction for simple mode (more readable than fallback)
fn format_insn_simple(insn: &InsnNode) -> String {
    match &insn.insn_type {
        InsnType::Move { dest, src } => {
            format!("r{} = {:?}", dest.reg_num, src)
        }
        InsnType::Const { dest, value } => {
            format!("r{} = {:?}", dest.reg_num, value)
        }
        InsnType::ConstString { dest, string_idx, .. } => {
            format!("r{} = str#{}", dest.reg_num, string_idx)
        }
        InsnType::Return { value: Some(val) } => {
            format!("return {:?}", val)
        }
        InsnType::Return { value: None } => {
            "return".to_string()
        }
        InsnType::Throw { exception } => {
            format!("throw {:?}", exception)
        }
        InsnType::If { left, right, condition, target } => {
            if let Some(r) = right {
                format!("if ({:?} {:?} {:?}) goto L_{:04x}", left, condition, r, target)
            } else {
                format!("if ({:?} {:?}) goto L_{:04x}", left, condition, target)
            }
        }
        InsnType::Goto { target } => {
            format!("goto L_{:04x}", target)
        }
        InsnType::Invoke { method_idx, args, .. } => {
            let args_str: Vec<String> = args.iter().map(|a| format!("{:?}", a)).collect();
            format!("invoke method#{} ({})", method_idx, args_str.join(", "))
        }
        InsnType::NewInstance { type_idx, .. } => {
            format!("new type#{}", type_idx)
        }
        InsnType::InstanceGet { dest, object, field_idx, .. } => {
            format!("r{} = {:?}.field#{}", dest.reg_num, object, field_idx)
        }
        InsnType::InstancePut { object, value, field_idx, .. } => {
            format!("{:?}.field#{} = {:?}", object, field_idx, value)
        }
        InsnType::StaticGet { dest, field_idx, .. } => {
            format!("r{} = sfield#{}", dest.reg_num, field_idx)
        }
        InsnType::StaticPut { value, field_idx, .. } => {
            format!("sfield#{} = {:?}", field_idx, value)
        }
        InsnType::ArrayGet { dest, array, index, .. } => {
            format!("r{} = {:?}[{:?}]", dest.reg_num, array, index)
        }
        InsnType::ArrayPut { array, index, value, .. } => {
            format!("{:?}[{:?}] = {:?}", array, index, value)
        }
        InsnType::Binary { dest, left, right, op, .. } => {
            format!("r{} = {:?} {:?} {:?}", dest.reg_num, left, op, right)
        }
        InsnType::Unary { dest, arg, op, .. } => {
            format!("r{} = {:?} {:?}", dest.reg_num, op, arg)
        }
        InsnType::Nop => "nop".to_string(),
        InsnType::MoveResult { dest, .. } => {
            format!("r{} = move-result", dest.reg_num)
        }
        InsnType::MoveException { dest } => {
            format!("r{} = move-exception", dest.reg_num)
        }
        _ => format!("{:?}", insn.insn_type),
    }
}

/// Generate method body using simple mode with blocks
///
/// This is the main entry point for JADX-compatible simple mode generation.
/// Use when region analysis fails but we have valid block structure.
pub fn generate_simple_mode<W: CodeWriter>(block_result: &BlockSplitResult, code: &mut W) {
    code.start_line().add("{").newline();
    code.inc_indent();

    let helper = SimpleModeHelper::new(block_result);
    helper.generate(code);

    code.dec_indent();
    code.start_line().add("}").newline();
}

#[cfg(test)]
mod tests {
    use super::*;

    fn make_block(id: u32, start: u32, end: u32, succs: Vec<u32>, preds: Vec<u32>) -> BasicBlock {
        BasicBlock {
            id,
            start_offset: start,
            end_offset: end,
            instructions: vec![],
            successors: succs,
            predecessors: preds,
            flags: 0,
        }
    }

    #[test]
    fn test_dfs_sort_linear() {
        // Simple linear flow: block 0 -> block 1 -> block 2
        let blocks = vec![
            make_block(0, 0, 4, vec![1], vec![]),
            make_block(1, 4, 8, vec![2], vec![0]),
            make_block(2, 8, 12, vec![], vec![1]),
        ];

        let result = BlockSplitResult {
            blocks,
            entry_block: 0,
            exit_blocks: vec![2],
        };

        let helper = SimpleModeHelper::new(&result);

        // Should be in order: 0, 1, 2
        assert_eq!(helper.sorted_blocks.len(), 3);
        assert_eq!(helper.sorted_blocks[0].id, 0);
        assert_eq!(helper.sorted_blocks[1].id, 1);
        assert_eq!(helper.sorted_blocks[2].id, 2);

        // No labels or gotos needed for linear flow
        assert!(helper.needs_label.is_empty());
        assert!(helper.needs_goto.is_empty());
    }

    #[test]
    fn test_dfs_sort_branch() {
        // Branch: block 0 -> block 1 and block 0 -> block 2
        let blocks = vec![
            make_block(0, 0, 4, vec![1, 2], vec![]),
            make_block(1, 4, 8, vec![], vec![0]),
            make_block(2, 8, 12, vec![], vec![0]),
        ];

        let result = BlockSplitResult {
            blocks,
            entry_block: 0,
            exit_blocks: vec![1, 2],
        };

        let helper = SimpleModeHelper::new(&result);

        // Should have all 3 blocks
        assert_eq!(helper.sorted_blocks.len(), 3);
    }

    #[test]
    fn test_labels_for_merge() {
        // Merge point: blocks 1 and 2 both go to block 3
        let blocks = vec![
            make_block(0, 0, 4, vec![1, 2], vec![]),
            make_block(1, 4, 8, vec![3], vec![0]),
            make_block(2, 8, 12, vec![3], vec![0]),
            make_block(3, 12, 16, vec![], vec![1, 2]),
        ];

        let result = BlockSplitResult {
            blocks,
            entry_block: 0,
            exit_blocks: vec![3],
        };

        let helper = SimpleModeHelper::new(&result);

        // Block 3 has multiple predecessors, needs label
        assert!(helper.needs_label.contains(&3));
    }
}
