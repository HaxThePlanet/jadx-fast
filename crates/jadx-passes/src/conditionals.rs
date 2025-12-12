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
pub fn detect_if_else_if_chains<'a>(conditionals: &'a [IfInfo], cfg: &CFG) -> Vec<Vec<&'a IfInfo>> {
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

#[cfg(test)]
mod tests {
    use super::*;
    use crate::block_split::split_blocks;
    use crate::loops::detect_loops;
    use jadx_ir::instructions::{IfCondition, InsnArg, InsnNode, InsnType};

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
}
