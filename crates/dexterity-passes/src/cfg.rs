//! Control Flow Graph with dominance analysis
//!
//! This module provides a CFG representation with dominance and post-dominance
//! computation using the Cooper-Harvey-Kennedy algorithm.

use std::collections::{BTreeMap, BTreeSet};

use crate::block_split::{BasicBlock, BlockSplitResult};

/// Control Flow Graph with dominance information
#[derive(Debug)]
pub struct CFG {
    /// Basic blocks indexed by ID
    blocks: BTreeMap<u32, BasicBlock>,
    /// Entry block ID
    entry: u32,
    /// Exit block IDs
    exits: Vec<u32>,
    /// Immediate dominators: block -> idom
    idom: BTreeMap<u32, u32>,
    /// Immediate post-dominators: block -> ipdom
    ipdom: BTreeMap<u32, u32>,
    /// Dominator tree: parent -> children
    dom_tree: BTreeMap<u32, Vec<u32>>,
    /// Post-dominator tree: parent -> children
    pdom_tree: BTreeMap<u32, Vec<u32>>,
    /// Reverse postorder of blocks
    rpo: Vec<u32>,
}

impl CFG {
    /// Build CFG from block split result
    pub fn from_blocks(result: BlockSplitResult) -> Self {
        let mut cfg = CFG {
            blocks: result.blocks,
            entry: result.entry_block,
            exits: result.exit_blocks,
            idom: BTreeMap::new(),
            ipdom: BTreeMap::new(),
            dom_tree: BTreeMap::new(),
            pdom_tree: BTreeMap::new(),
            rpo: Vec::new(),
        };

        if !cfg.blocks.is_empty() {
            cfg.compute_rpo();
            cfg.compute_dominators();
            cfg.compute_post_dominators();
            cfg.build_dom_trees();
        }

        cfg
    }

    /// Get entry block ID
    pub fn entry(&self) -> u32 {
        self.entry
    }

    /// Get exit block IDs
    pub fn exits(&self) -> &[u32] {
        &self.exits
    }

    /// Get a block by ID
    pub fn get_block(&self, id: u32) -> Option<&BasicBlock> {
        self.blocks.get(&id)
    }

    /// Get all block IDs
    pub fn block_ids(&self) -> impl Iterator<Item = u32> + '_ {
        self.blocks.keys().copied()
    }

    /// Get blocks in reverse postorder
    pub fn rpo_order(&self) -> &[u32] {
        &self.rpo
    }

    /// Get immediate dominator of a block
    pub fn idom(&self, block: u32) -> Option<u32> {
        self.idom.get(&block).copied()
    }

    /// Get immediate post-dominator of a block
    pub fn ipdom(&self, block: u32) -> Option<u32> {
        self.ipdom.get(&block).copied()
    }

    /// Check if block `a` dominates block `b`
    pub fn dominates(&self, a: u32, b: u32) -> bool {
        if a == b {
            return true;
        }
        let mut current = b;
        while let Some(dom) = self.idom.get(&current) {
            if *dom == a {
                return true;
            }
            if *dom == current {
                break; // Entry node
            }
            current = *dom;
        }
        false
    }

    /// Check if block `a` post-dominates block `b`
    pub fn post_dominates(&self, a: u32, b: u32) -> bool {
        if a == b {
            return true;
        }
        let mut current = b;
        while let Some(pdom) = self.ipdom.get(&current) {
            if *pdom == a {
                return true;
            }
            if *pdom == current {
                break;
            }
            current = *pdom;
        }
        false
    }

    /// Get children in dominator tree
    pub fn dom_children(&self, block: u32) -> &[u32] {
        self.dom_tree.get(&block).map(|v| v.as_slice()).unwrap_or(&[])
    }

    /// Get children in post-dominator tree
    pub fn pdom_children(&self, block: u32) -> &[u32] {
        self.pdom_tree.get(&block).map(|v| v.as_slice()).unwrap_or(&[])
    }

    /// Get successors of a block
    pub fn successors(&self, block: u32) -> &[u32] {
        self.blocks
            .get(&block)
            .map(|b| b.successors.as_slice())
            .unwrap_or(&[])
    }

    /// Get predecessors of a block
    pub fn predecessors(&self, block: u32) -> &[u32] {
        self.blocks
            .get(&block)
            .map(|b| b.predecessors.as_slice())
            .unwrap_or(&[])
    }

    /// Get mutable reference to a block
    pub fn get_block_mut(&mut self, id: u32) -> Option<&mut BasicBlock> {
        self.blocks.get_mut(&id)
    }

    /// Collect all blocks dominated by dominator within a region
    ///
    /// Returns blocks that are:
    /// 1. In the region set
    /// 2. Dominated by the dominator block
    pub fn collect_dominated_blocks(&self, dominator: u32, region: &BTreeSet<u32>) -> Vec<u32> {
        let mut result = Vec::new();

        for &block_id in region {
            if block_id != dominator && self.dominates(dominator, block_id) {
                result.push(block_id);
            }
        }

        result
    }

    /// Collect predecessor path from start block back to boundary blocks
    ///
    /// Returns all blocks on paths from start_block back to stop_at blocks
    pub fn collect_predecessors(&self, start: u32, stop_at: &BTreeSet<u32>) -> Vec<u32> {
        let mut result = Vec::new();
        let mut visited = BTreeSet::new();
        let mut worklist = vec![start];

        while let Some(block_id) = worklist.pop() {
            if !visited.insert(block_id) {
                continue;
            }

            // Stop at boundary
            if stop_at.contains(&block_id) {
                continue;
            }

            result.push(block_id);

            // Add predecessors to worklist
            if let Some(block) = self.blocks.get(&block_id) {
                for &pred in &block.predecessors {
                    if !visited.contains(&pred) {
                        worklist.push(pred);
                    }
                }
            }
        }

        result
    }

    /// Find the bottom block in a region (block with no successors in region)
    pub fn get_bottom_block(&self, blocks: &BTreeSet<u32>) -> Option<u32> {
        for &block_id in blocks {
            if let Some(block) = self.blocks.get(&block_id) {
                // Check if this block has no successors in the region
                let has_succ_in_region = block.successors.iter().any(|s| blocks.contains(s));
                if !has_succ_in_region {
                    return Some(block_id);
                }
            }
        }
        None
    }

    /// Follow path through empty blocks
    pub fn follow_empty_path(&self, start: u32) -> u32 {
        let mut current = start;
        let mut visited = BTreeSet::new();

        loop {
            if !visited.insert(current) {
                // Cycle detected, return current
                return current;
            }

            if let Some(block) = self.blocks.get(&current) {
                if !block.is_empty() {
                    return current;
                }

                // Follow single successor
                if block.successors.len() == 1 {
                    current = block.successors[0];
                } else {
                    return current;
                }
            } else {
                return current;
            }
        }
    }

    /// Get blocks that are path starts for try exit paths
    ///
    /// Returns blocks that lead from try blocks to the merge point
    pub fn get_try_exit_paths(
        &self,
        bottom: u32,
        bottom_finally: u32,
        exit_block: Option<u32>,
    ) -> Vec<u32> {
        let mut result = Vec::new();

        if let Some(bottom_block) = self.blocks.get(&bottom) {
            // Get predecessors excluding the finally bottom block
            for &pred in &bottom_block.predecessors {
                if pred != bottom_finally {
                    // If bottom is exit block, get predecessors of predecessors
                    if Some(bottom) == exit_block {
                        if let Some(pred_block) = self.blocks.get(&pred) {
                            result.extend(pred_block.predecessors.iter().copied());
                        }
                    } else {
                        result.push(pred);
                    }
                }
            }
        }

        result
    }

    /// Compute reverse postorder traversal
    fn compute_rpo(&mut self) {
        let mut visited = BTreeSet::new();
        let mut postorder = Vec::new();

        self.dfs_postorder(self.entry, &mut visited, &mut postorder);

        // Reverse to get RPO
        postorder.reverse();
        self.rpo = postorder;
    }

    fn dfs_postorder(&self, block: u32, visited: &mut BTreeSet<u32>, postorder: &mut Vec<u32>) {
        if !visited.insert(block) {
            return;
        }

        if let Some(b) = self.blocks.get(&block) {
            for &succ in &b.successors {
                self.dfs_postorder(succ, visited, postorder);
            }
        }

        postorder.push(block);
    }

    /// Compute immediate dominators using Cooper-Harvey-Kennedy algorithm
    fn compute_dominators(&mut self) {
        if self.rpo.is_empty() {
            return;
        }

        // Map block ID to RPO index
        let mut rpo_num: BTreeMap<u32, usize> = BTreeMap::new();
        for (i, &block) in self.rpo.iter().enumerate() {
            rpo_num.insert(block, i);
        }

        // Initialize: entry dominates itself
        self.idom.insert(self.entry, self.entry);

        // Iterate until convergence
        let mut changed = true;
        while changed {
            changed = false;

            for &block in &self.rpo {
                if block == self.entry {
                    continue;
                }

                let preds = self.predecessors(block).to_vec();
                if preds.is_empty() {
                    continue;
                }

                // Find first processed predecessor
                let mut new_idom = None;
                for &pred in &preds {
                    if self.idom.contains_key(&pred) {
                        new_idom = Some(pred);
                        break;
                    }
                }

                let Some(mut new_idom) = new_idom else {
                    continue;
                };

                // Intersect with other predecessors
                for &pred in &preds {
                    if pred == new_idom {
                        continue;
                    }
                    if self.idom.contains_key(&pred) {
                        new_idom = self.intersect(pred, new_idom, &rpo_num);
                    }
                }

                if self.idom.get(&block) != Some(&new_idom) {
                    self.idom.insert(block, new_idom);
                    changed = true;
                }
            }
        }
    }

    /// Intersect two dominators
    fn intersect(&self, mut b1: u32, mut b2: u32, rpo_num: &BTreeMap<u32, usize>) -> u32 {
        // Limit iterations to prevent infinite loops
        let max_iters = self.blocks.len() * 2;
        let mut iters = 0;

        while b1 != b2 && iters < max_iters {
            iters += 1;
            let n1 = rpo_num.get(&b1).copied().unwrap_or(usize::MAX);
            let n2 = rpo_num.get(&b2).copied().unwrap_or(usize::MAX);

            if n1 > n2 {
                if let Some(&dom) = self.idom.get(&b1) {
                    if dom != b1 {
                        b1 = dom;
                    } else {
                        break;
                    }
                } else {
                    break;
                }
            } else {
                if let Some(&dom) = self.idom.get(&b2) {
                    if dom != b2 {
                        b2 = dom;
                    } else {
                        break;
                    }
                } else {
                    break;
                }
            }
        }
        b1
    }

    /// Compute post-dominators (dominators on reverse CFG)
    fn compute_post_dominators(&mut self) {
        if self.exits.is_empty() {
            return;
        }

        // Create virtual exit node if multiple exits
        let _exit_node = if self.exits.len() == 1 {
            self.exits[0]
        } else {
            // Use max block ID + 1 as virtual exit
            let virtual_exit = self.blocks.keys().max().map(|&m| m + 1).unwrap_or(0);
            virtual_exit
        };

        // Compute reverse postorder on reverse CFG
        let mut reverse_rpo = Vec::new();
        let mut visited = BTreeSet::new();

        // DFS from exits on reverse CFG
        for &exit in &self.exits {
            self.reverse_dfs_postorder(exit, &mut visited, &mut reverse_rpo);
        }
        reverse_rpo.reverse();

        // Map to RPO numbers
        let mut rpo_num: BTreeMap<u32, usize> = BTreeMap::new();
        for (i, &block) in reverse_rpo.iter().enumerate() {
            rpo_num.insert(block, i);
        }

        // Initialize exits
        for &exit in &self.exits {
            self.ipdom.insert(exit, exit);
        }

        // Iterate until convergence
        let mut changed = true;
        while changed {
            changed = false;

            for &block in &reverse_rpo {
                if self.exits.contains(&block) {
                    continue;
                }

                // Successors are predecessors in reverse CFG
                let succs = self.successors(block).to_vec();
                if succs.is_empty() {
                    continue;
                }

                let mut new_ipdom = None;
                for &succ in &succs {
                    if self.ipdom.contains_key(&succ) {
                        new_ipdom = Some(succ);
                        break;
                    }
                }

                let Some(mut new_ipdom) = new_ipdom else {
                    continue;
                };

                for &succ in &succs {
                    if succ == new_ipdom {
                        continue;
                    }
                    if self.ipdom.contains_key(&succ) {
                        new_ipdom = self.intersect_pdom(succ, new_ipdom, &rpo_num);
                    }
                }

                if self.ipdom.get(&block) != Some(&new_ipdom) {
                    self.ipdom.insert(block, new_ipdom);
                    changed = true;
                }
            }
        }
    }

    fn reverse_dfs_postorder(
        &self,
        block: u32,
        visited: &mut BTreeSet<u32>,
        postorder: &mut Vec<u32>,
    ) {
        if !visited.insert(block) {
            return;
        }

        // Traverse predecessors (successors in reverse CFG)
        for &pred in self.predecessors(block) {
            self.reverse_dfs_postorder(pred, visited, postorder);
        }

        postorder.push(block);
    }

    fn intersect_pdom(&self, mut b1: u32, mut b2: u32, rpo_num: &BTreeMap<u32, usize>) -> u32 {
        // Limit iterations to prevent infinite loops
        let max_iters = self.blocks.len() * 2;
        let mut iters = 0;

        while b1 != b2 && iters < max_iters {
            iters += 1;
            let n1 = rpo_num.get(&b1).copied().unwrap_or(usize::MAX);
            let n2 = rpo_num.get(&b2).copied().unwrap_or(usize::MAX);

            if n1 > n2 {
                if let Some(&dom) = self.ipdom.get(&b1) {
                    if dom != b1 {
                        b1 = dom;
                    } else {
                        break;
                    }
                } else {
                    break;
                }
            } else {
                if let Some(&dom) = self.ipdom.get(&b2) {
                    if dom != b2 {
                        b2 = dom;
                    } else {
                        break;
                    }
                } else {
                    break;
                }
            }
        }
        b1
    }

    /// Build dominator and post-dominator trees
    fn build_dom_trees(&mut self) {
        // Build dominator tree
        for (&block, &dom) in &self.idom {
            if block != dom {
                self.dom_tree.entry(dom).or_default().push(block);
            }
        }

        // Build post-dominator tree
        for (&block, &pdom) in &self.ipdom {
            if block != pdom {
                self.pdom_tree.entry(pdom).or_default().push(block);
            }
        }

        // Sort children for deterministic output
        for children in self.dom_tree.values_mut() {
            children.sort();
        }
        for children in self.pdom_tree.values_mut() {
            children.sort();
        }
    }

    /// Get dominance frontier for a block (used for SSA)
    pub fn dominance_frontier(&self, block: u32) -> Vec<u32> {
        let mut frontier = Vec::new();

        // For each block in CFG
        for &b in self.blocks.keys() {
            // Check if block is in dominance frontier of `block`
            let preds = self.predecessors(b);
            if preds.len() >= 2 {
                for &pred in preds {
                    if self.dominates(block, pred) && !self.strictly_dominates(block, b) {
                        frontier.push(b);
                        break;
                    }
                }
            }
        }

        frontier
    }

    /// Check strict dominance (a dominates b and a != b)
    pub fn strictly_dominates(&self, a: u32, b: u32) -> bool {
        a != b && self.dominates(a, b)
    }

    /// Extract blocks from CFG, consuming self
    /// This allows blocks to be reused after dominator computation without cloning
    pub fn into_blocks(self) -> BlockSplitResult {
        BlockSplitResult {
            blocks: self.blocks,
            entry_block: self.entry,
            exit_blocks: self.exits,
        }
    }

    /// Take blocks out of CFG, replacing with empty map
    /// Use this to pass blocks to SSA after CFG computation
    pub fn take_blocks(&mut self) -> BlockSplitResult {
        BlockSplitResult {
            blocks: std::mem::take(&mut self.blocks),
            entry_block: self.entry,
            exit_blocks: std::mem::take(&mut self.exits),
        }
    }
}

#[cfg(test)]
mod tests {
    use super::*;
    use crate::block_split::split_blocks;
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
    fn test_simple_cfg() {
        // Linear: B0 -> B1 -> return
        let instructions = vec![make_nop(0), make_nop(1), make_return(2)];
        let blocks = split_blocks(&instructions);
        let cfg = CFG::from_blocks(blocks);

        assert_eq!(cfg.entry(), 0);
        assert_eq!(cfg.exits(), &[0]);
    }

    #[test]
    fn test_if_dominance() {
        // B0: if -> B1 (then), B2 (else)
        // B1: goto B3
        // B2: goto B3
        // B3: return
        let instructions = vec![
            make_if(0, 3),    // B0: if-eqz goto 3
            make_goto(1, 4),  // B1: goto 4
            make_nop(2),      // (unreachable filler)
            make_goto(3, 4),  // B2: goto 4
            make_return(4),   // B3: return
        ];
        let blocks = split_blocks(&instructions);
        let cfg = CFG::from_blocks(blocks);

        // B0 should dominate all blocks
        assert!(cfg.dominates(0, 0));
    }

    #[test]
    fn test_loop_dominance() {
        // B0: entry
        // B1: loop header (condition)
        // B2: loop body -> back to B1
        // B3: exit
        let instructions = vec![
            make_goto(0, 1),  // B0: goto loop header
            make_if(1, 3),    // B1: if-eqz exit, else continue
            make_goto(2, 1),  // B2: back edge to B1
            make_return(3),   // B3: exit
        ];
        let blocks = split_blocks(&instructions);
        let cfg = CFG::from_blocks(blocks);

        // Entry dominates everything
        assert!(cfg.dominates(0, 0));

        // Check RPO is computed
        assert!(!cfg.rpo_order().is_empty());
    }

    #[test]
    fn test_post_dominance() {
        // Simple if-else that merges
        let instructions = vec![
            make_if(0, 2),    // B0: if
            make_goto(1, 3),  // B1: then -> merge
            make_goto(2, 3),  // B2: else -> merge
            make_return(3),   // B3: merge + return
        ];
        let blocks = split_blocks(&instructions);
        let cfg = CFG::from_blocks(blocks);

        // B3 (return) should post-dominate everything
        // (it's the only exit)
        for &block in cfg.block_ids().collect::<Vec<_>>().iter() {
            // All blocks eventually reach B3
            assert!(cfg.post_dominates(cfg.exits()[0], block) || block == cfg.exits()[0]);
        }
    }
}
