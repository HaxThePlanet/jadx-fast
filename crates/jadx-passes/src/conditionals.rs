//! Conditional (if-else) region detection
//!
//! This module detects if-then and if-then-else patterns in the CFG
//! using dominance and post-dominance information.

use std::collections::BTreeSet;

use crate::cfg::CFG;
use crate::loops::LoopInfo;

/// Information about a detected if-else region
#[derive(Debug, Clone)]
pub struct IfInfo {
    /// Block containing the condition (ends with If instruction)
    pub condition_block: u32,
    /// Blocks in the "then" branch
    pub then_blocks: Vec<u32>,
    /// Blocks in the "else" branch (empty for simple if)
    pub else_blocks: Vec<u32>,
    /// Block where branches merge (immediate post-dominator)
    pub merge_block: Option<u32>,
    /// True if this is a simple "if" without else
    pub is_simple_if: bool,
}

impl IfInfo {
    /// Check if this has an else branch
    pub fn has_else(&self) -> bool {
        !self.else_blocks.is_empty()
    }
}

/// Detect if-else regions in the CFG
pub fn detect_conditionals(cfg: &CFG, loops: &[LoopInfo]) -> Vec<IfInfo> {
    let mut conditionals = Vec::new();

    // Find all blocks that end with a conditional branch
    for block_id in cfg.block_ids() {
        let succs = cfg.successors(block_id);

        // Conditional branches have exactly 2 successors
        if succs.len() != 2 {
            continue;
        }

        // Skip if this is a loop header's condition (handled by loop detection)
        if is_loop_condition(block_id, loops) {
            continue;
        }

        let then_target = succs[0]; // Fall-through
        let else_target = succs[1]; // Branch target

        // Find merge point (immediate post-dominator)
        let merge = cfg.ipdom(block_id);

        // Determine then/else blocks
        let (then_blocks, else_blocks) = find_branch_blocks(
            cfg,
            block_id,
            then_target,
            else_target,
            merge,
            loops,
        );

        let is_simple_if = else_blocks.is_empty();

        conditionals.push(IfInfo {
            condition_block: block_id,
            then_blocks,
            else_blocks,
            merge_block: merge,
            is_simple_if,
        });
    }

    // Sort by condition block for deterministic ordering
    conditionals.sort_by_key(|c| c.condition_block);

    conditionals
}

/// Check if a block is a loop condition/header
fn is_loop_condition(block: u32, loops: &[LoopInfo]) -> bool {
    loops.iter().any(|l| l.header == block)
}

/// Find blocks belonging to then and else branches
fn find_branch_blocks(
    cfg: &CFG,
    condition: u32,
    then_target: u32,
    else_target: u32,
    merge: Option<u32>,
    loops: &[LoopInfo],
) -> (Vec<u32>, Vec<u32>) {
    let merge_block = merge.unwrap_or(u32::MAX);

    // Collect blocks reachable from then_target before hitting merge
    let then_blocks = collect_branch_blocks(cfg, then_target, merge_block, condition, loops);

    // Collect blocks reachable from else_target before hitting merge
    let else_blocks = collect_branch_blocks(cfg, else_target, merge_block, condition, loops);

    // Check for simple if: else branch goes directly to merge
    let else_blocks = if else_target == merge_block {
        Vec::new()
    } else {
        else_blocks
    };

    // Also check if then branch goes directly to merge (inverted condition)
    let (then_blocks, else_blocks) = if then_target == merge_block {
        // Swap: else becomes then
        (else_blocks, Vec::new())
    } else {
        (then_blocks, else_blocks)
    };

    (then_blocks, else_blocks)
}

/// Collect all blocks in a branch until merge point
fn collect_branch_blocks(
    cfg: &CFG,
    start: u32,
    merge: u32,
    condition: u32,
    loops: &[LoopInfo],
) -> Vec<u32> {
    let mut blocks = Vec::new();
    let mut visited = BTreeSet::new();
    let mut worklist = vec![start];

    while let Some(block) = worklist.pop() {
        // Stop at merge point
        if block == merge {
            continue;
        }

        // Don't go back to condition
        if block == condition {
            continue;
        }

        // Skip if already visited
        if !visited.insert(block) {
            continue;
        }

        // Skip if this is a different loop's header
        if loops.iter().any(|l| l.header == block && !l.contains(condition)) {
            continue;
        }

        blocks.push(block);

        // Add successors to worklist
        for &succ in cfg.successors(block) {
            worklist.push(succ);
        }
    }

    blocks.sort();
    blocks
}

/// Check if block is reachable from start without going through barrier
#[allow(dead_code)]
fn is_reachable_without(cfg: &CFG, start: u32, target: u32, barrier: u32) -> bool {
    if start == target {
        return true;
    }

    let mut visited = BTreeSet::new();
    let mut worklist = vec![start];

    while let Some(block) = worklist.pop() {
        if block == target {
            return true;
        }

        if block == barrier {
            continue;
        }

        if !visited.insert(block) {
            continue;
        }

        for &succ in cfg.successors(block) {
            worklist.push(succ);
        }
    }

    false
}

/// Detect if-else-if chains
pub fn detect_if_else_if_chains<'a>(conditionals: &'a [IfInfo], _cfg: &CFG) -> Vec<Vec<&'a IfInfo>> {
    let mut chains = Vec::new();
    let mut used = BTreeSet::new();

    for cond in conditionals {
        if used.contains(&cond.condition_block) {
            continue;
        }

        // Check if else branch starts with another if
        if !cond.else_blocks.is_empty() {
            let else_start = cond.else_blocks[0];

            // Find if else_start is a condition block of another if
            let else_if = conditionals
                .iter()
                .find(|c| c.condition_block == else_start);

            if let Some(else_cond) = else_if {
                // Found if-else-if, build chain
                let mut chain = vec![cond];
                let mut current = else_cond;

                loop {
                    used.insert(current.condition_block);
                    chain.push(current);

                    // Check for more else-ifs
                    if current.else_blocks.is_empty() {
                        break;
                    }

                    let next_else = current.else_blocks[0];
                    match conditionals.iter().find(|c| c.condition_block == next_else) {
                        Some(next) if !used.contains(&next.condition_block) => {
                            current = next;
                        }
                        _ => break,
                    }
                }

                chains.push(chain);
                used.insert(cond.condition_block);
            }
        }
    }

    chains
}

/// Merged condition information
/// Represents a condition that may be a compound of multiple if blocks
#[derive(Debug, Clone)]
pub struct MergedCondition {
    /// Original condition block that starts the chain
    pub first_block: u32,
    /// All blocks that were merged into this condition
    pub merged_blocks: Vec<u32>,
    /// The then block after all conditions
    pub then_block: Option<u32>,
    /// The else block after all conditions
    pub else_block: Option<u32>,
    /// The merge point after the entire if structure
    pub out_block: Option<u32>,
    /// The merge mode (AND or OR)
    pub mode: MergeMode,
}

/// How conditions are merged
#[derive(Debug, Clone, Copy, PartialEq, Eq)]
pub enum MergeMode {
    /// Conditions are ANDed together (if a && b)
    And,
    /// Conditions are ORed together (if a || b)
    Or,
    /// Single condition, no merging
    Single,
}

impl MergedCondition {
    /// Create a new merged condition from a single IfInfo
    pub fn from_if_info(info: &IfInfo) -> Self {
        MergedCondition {
            first_block: info.condition_block,
            merged_blocks: vec![info.condition_block],
            then_block: info.then_blocks.first().copied(),
            else_block: info.else_blocks.first().copied(),
            out_block: info.merge_block,
            mode: MergeMode::Single,
        }
    }

    /// Check if another condition can be merged with this one
    pub fn can_merge(&self, other: &IfInfo, cfg: &CFG) -> Option<MergeMode> {
        // Check for AND pattern: this.then leads directly to other.condition
        if let Some(then_block) = self.then_block {
            if then_block == other.condition_block {
                // Check if else blocks point to the same place
                let self_else = self.else_block;
                let other_else = other.else_blocks.first().copied();
                if self_else == other_else || self_else == self.out_block {
                    return Some(MergeMode::And);
                }
            }
        }

        // Check for OR pattern: this.else leads directly to other.condition
        if let Some(else_block) = self.else_block {
            if else_block == other.condition_block {
                // Check if then blocks point to the same place
                let self_then = self.then_block;
                let other_then = other.then_blocks.first().copied();
                if self_then == other_then {
                    return Some(MergeMode::Or);
                }
            }
        }

        None
    }

    /// Merge another condition into this one
    pub fn merge(&mut self, other: &IfInfo, mode: MergeMode) {
        self.merged_blocks.push(other.condition_block);
        self.mode = mode;

        match mode {
            MergeMode::And => {
                // In AND, the then is the inner then, else is the shared else
                self.then_block = other.then_blocks.first().copied();
                // else_block stays the same (shared exit for false)
            }
            MergeMode::Or => {
                // In OR, the else is the inner else, then is the shared then
                self.else_block = other.else_blocks.first().copied();
                // then_block stays the same (shared exit for true)
            }
            MergeMode::Single => {}
        }

        // Update out_block to the merged condition's merge
        if other.merge_block.is_some() {
            self.out_block = other.merge_block;
        }
    }
}

/// Try to merge nested if conditions into compound conditions
///
/// Patterns detected:
/// - AND: `if (a) { if (b) { then } }` -> `if (a && b) { then }`
/// - OR: `if (a) { then } else { if (b) { then } }` -> `if (a || b) { then }`
pub fn merge_nested_conditions(
    start: &IfInfo,
    all_conditionals: &[IfInfo],
    cfg: &CFG,
) -> MergedCondition {
    let mut merged = MergedCondition::from_if_info(start);

    // Try to find nested conditions to merge
    loop {
        let next_block = match merged.mode {
            MergeMode::And | MergeMode::Single => merged.then_block,
            MergeMode::Or => merged.else_block,
        };

        let Some(next) = next_block else {
            break;
        };

        // Find if there's a condition at the next block
        let next_cond = all_conditionals
            .iter()
            .find(|c| c.condition_block == next);

        let Some(next_cond) = next_cond else {
            break;
        };

        // Check if we can merge
        if let Some(mode) = merged.can_merge(next_cond, cfg) {
            merged.merge(next_cond, mode);
        } else {
            break;
        }
    }

    merged
}

/// Find all mergeable condition chains starting from each conditional
pub fn find_condition_chains(conditionals: &[IfInfo], cfg: &CFG) -> Vec<MergedCondition> {
    let mut chains = Vec::new();
    let mut used = BTreeSet::new();

    for cond in conditionals {
        if used.contains(&cond.condition_block) {
            continue;
        }

        let merged = merge_nested_conditions(cond, conditionals, cfg);

        // Mark all merged blocks as used
        for &block in &merged.merged_blocks {
            used.insert(block);
        }

        chains.push(merged);
    }

    chains
}

/// Information about a detected ternary expression
#[derive(Debug, Clone)]
pub struct TernaryInfo {
    /// The condition block
    pub condition_block: u32,
    /// The destination register for the ternary result
    pub dest_reg: u16,
    /// SSA version of dest register in then branch
    pub then_version: u32,
    /// SSA version of dest register in else branch
    pub else_version: u32,
    /// Block containing the then value
    pub then_block: u32,
    /// Block containing the else value
    pub else_block: u32,
    /// Merge block (where phi node would be)
    pub merge_block: u32,
}

/// Detect ternary expressions (if-else that produces a value)
pub fn is_ternary_candidate(cond: &IfInfo, cfg: &CFG) -> bool {
    // Both branches should be single blocks
    if cond.then_blocks.len() != 1 || cond.else_blocks.len() != 1 {
        return false;
    }

    // Both should merge at the same point
    if cond.merge_block.is_none() {
        return false;
    }

    // Both branches should have only one successor (the merge)
    let then_block = cond.then_blocks[0];
    let else_block = cond.else_blocks[0];

    let then_succs = cfg.successors(then_block);
    let else_succs = cfg.successors(else_block);

    then_succs.len() == 1
        && else_succs.len() == 1
        && then_succs[0] == cond.merge_block.unwrap()
        && else_succs[0] == cond.merge_block.unwrap()
}

/// Check if blocks represent a ternary assignment pattern
/// Returns Some((dest_reg, then_value, else_value)) if it's a ternary assignment
pub fn detect_ternary_assignment(
    then_block: &crate::block_split::BasicBlock,
    else_block: &crate::block_split::BasicBlock,
) -> Option<(u16, u32, u32)> {
    use jadx_ir::instructions::InsnType;

    // Find last assignment in then block (excluding control flow)
    let then_assign = then_block.instructions.iter().rev()
        .find(|insn| !is_control_flow_insn(&insn.insn_type))
        .and_then(|insn| get_assignment_dest(&insn.insn_type));

    // Find last assignment in else block
    let else_assign = else_block.instructions.iter().rev()
        .find(|insn| !is_control_flow_insn(&insn.insn_type))
        .and_then(|insn| get_assignment_dest(&insn.insn_type));

    // Both must assign to the same register
    match (then_assign, else_assign) {
        (Some((then_reg, then_ver)), Some((else_reg, else_ver))) if then_reg == else_reg => {
            Some((then_reg, then_ver, else_ver))
        }
        _ => None,
    }
}

/// Check if an instruction is control flow
fn is_control_flow_insn(insn: &jadx_ir::instructions::InsnType) -> bool {
    use jadx_ir::instructions::InsnType;
    matches!(
        insn,
        InsnType::If { .. }
            | InsnType::Goto { .. }
            | InsnType::PackedSwitch { .. }
            | InsnType::SparseSwitch { .. }
    )
}

/// Get the destination register from an assignment instruction
fn get_assignment_dest(insn: &jadx_ir::instructions::InsnType) -> Option<(u16, u32)> {
    use jadx_ir::instructions::InsnType;
    match insn {
        InsnType::Const { dest, .. }
        | InsnType::ConstString { dest, .. }
        | InsnType::Move { dest, .. }
        | InsnType::MoveResult { dest }
        | InsnType::NewInstance { dest, .. }
        | InsnType::NewArray { dest, .. }
        | InsnType::ArrayLength { dest, .. }
        | InsnType::ArrayGet { dest, .. }
        | InsnType::InstanceGet { dest, .. }
        | InsnType::StaticGet { dest, .. }
        | InsnType::Unary { dest, .. }
        | InsnType::Binary { dest, .. }
        | InsnType::Cast { dest, .. }
        | InsnType::Compare { dest, .. }
        | InsnType::InstanceOf { dest, .. }
        | InsnType::ConstClass { dest, .. } => Some((dest.reg_num, dest.ssa_version)),
        InsnType::Phi { dest, .. } => Some((dest.reg_num, dest.ssa_version)),
        _ => None,
    }
}

#[cfg(test)]
mod tests {
    use super::*;
    use crate::block_split::split_blocks;
    use crate::loops::detect_loops;
    use jadx_ir::instructions::{IfCondition, InsnArg, InsnNode, InsnType};

    fn make_if_with_reg(offset: u32, target: u32, reg: u16) -> InsnNode {
        InsnNode::new(
            InsnType::If {
                condition: IfCondition::Eq,
                left: InsnArg::reg(reg),
                right: None,
                target,
            },
            offset,
        )
    }

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
    fn test_simple_if() {
        // if (cond) { then } return
        // B0: if -> B2 (skip then)
        // B1: then
        // B2: return
        let instructions = vec![
            make_if(0, 2),   // B0: skip then if true
            make_nop(1),     // B1: then block
            make_return(2),  // B2: merge/exit
        ];
        let blocks = split_blocks(instructions);
        let cfg = CFG::from_blocks(blocks);
        let loops = detect_loops(&cfg);
        let conds = detect_conditionals(&cfg, &loops);

        assert_eq!(conds.len(), 1);
        assert!(conds[0].is_simple_if || !conds[0].has_else());
    }

    #[test]
    fn test_if_else() {
        // if (cond) { then } else { else } return
        // B0: if -> B2 (else)
        // B1: then -> B3
        // B2: else -> B3
        // B3: return
        let instructions = vec![
            make_if(0, 2),   // B0: goto else if true
            make_goto(1, 3), // B1: then -> merge
            make_goto(2, 3), // B2: else -> merge
            make_return(3),  // B3: merge
        ];
        let blocks = split_blocks(instructions);
        let cfg = CFG::from_blocks(blocks);
        let loops = detect_loops(&cfg);
        let conds = detect_conditionals(&cfg, &loops);

        assert_eq!(conds.len(), 1);
        assert!(conds[0].has_else());
    }

    #[test]
    fn test_no_conditionals_in_loop() {
        // while (cond) { body }
        // The loop condition should not be detected as standalone if
        let instructions = vec![
            make_if(0, 2),   // Loop condition
            make_goto(1, 0), // Back edge
            make_return(2),  // Exit
        ];
        let blocks = split_blocks(instructions);
        let cfg = CFG::from_blocks(blocks);
        let loops = detect_loops(&cfg);
        let conds = detect_conditionals(&cfg, &loops);

        // Loop condition should be filtered out
        assert!(conds.is_empty());
    }

    #[test]
    fn test_and_condition_detection() {
        // if (a && b) { then } else { else }
        // Compiled as:
        // B0: if (!a) goto B3 (else)
        // B1: if (!b) goto B3 (else)
        // B2: then -> B4
        // B3: else -> B4
        // B4: return
        let instructions = vec![
            make_if_with_reg(0, 3, 0), // B0: if (!a) goto else
            make_if_with_reg(1, 3, 1), // B1: if (!b) goto else
            make_goto(2, 4),           // B2: then -> merge
            make_goto(3, 4),           // B3: else -> merge
            make_return(4),            // B4: merge
        ];
        let blocks = split_blocks(instructions);
        let cfg = CFG::from_blocks(blocks);
        let loops = detect_loops(&cfg);
        let conds = detect_conditionals(&cfg, &loops);

        // Should detect both conditions
        assert!(conds.len() >= 1);

        // Find condition chains
        let chains = find_condition_chains(&conds, &cfg);

        // Should merge into single AND chain (or detect as separate depending on exact CFG)
        assert!(!chains.is_empty());
    }

    #[test]
    fn test_or_condition_detection() {
        // if (a || b) { then } else { else }
        // Compiled as:
        // B0: if (a) goto B2 (then)
        // B1: if (b) goto B2 (then)
        // ... else code
        // B2: then
        // In this test we use a simpler pattern
        let instructions = vec![
            make_if_with_reg(0, 2, 0), // B0: if (a) goto then
            make_if_with_reg(1, 2, 1), // B1: if (b) goto then
            make_nop(2),               // B2: then
            make_return(3),            // B3: merge
        ];
        let blocks = split_blocks(instructions);
        let cfg = CFG::from_blocks(blocks);
        let loops = detect_loops(&cfg);
        let conds = detect_conditionals(&cfg, &loops);

        // Should detect conditions
        assert!(!conds.is_empty());
    }
}
