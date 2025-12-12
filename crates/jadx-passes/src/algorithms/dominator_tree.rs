//! Dominator tree computation
//!
//! Implementation of the Cooper-Harvey-Kennedy algorithm for computing dominators.
//! Paper: "A Simple, Fast Dominance Algorithm" (2001)
//! http://www.hipersoft.rice.edu/grads/publications/dom14.pdf

use fixedbitset::FixedBitSet;

/// Result of dominator tree computation
#[derive(Debug)]
pub struct DominatorInfo {
    /// Immediate dominator for each block (idom[i] = immediate dominator of block i)
    /// idom[0] is undefined (entry block has no dominator)
    pub idom: Vec<u32>,
    /// Dominance frontier for each block
    pub dom_frontier: Vec<FixedBitSet>,
    /// Set of blocks dominated by each block
    pub dominates: Vec<FixedBitSet>,
    /// Set of dominators for each block (blocks that dominate this block)
    pub doms: Vec<FixedBitSet>,
}

/// Compute dominator tree for a CFG
///
/// # Arguments
/// * `num_blocks` - Number of basic blocks
/// * `predecessors` - For each block, list of predecessor block indices
/// * `successors` - For each block, list of successor block indices
///
/// # Returns
/// DominatorInfo containing idom array and dominance frontiers
///
/// # Panics
/// If the CFG is malformed (unreachable blocks, etc.)
pub fn compute_dominators(
    num_blocks: usize,
    predecessors: &[Vec<u32>],
    _successors: &[Vec<u32>],
) -> DominatorInfo {
    if num_blocks == 0 {
        return DominatorInfo {
            idom: Vec::new(),
            dom_frontier: Vec::new(),
            dominates: Vec::new(),
            doms: Vec::new(),
        };
    }

    // Build immediate dominators using Cooper-Harvey-Kennedy algorithm
    let idom = build_idom(num_blocks, predecessors);

    // Collect dominator sets for each block
    let doms = collect_doms(num_blocks, &idom);

    // Build dominates relation (inverse of doms)
    let dominates = build_dominates(num_blocks, &idom);

    // Compute dominance frontier
    let dom_frontier = compute_dominance_frontier_internal(num_blocks, predecessors, &idom);

    DominatorInfo {
        idom,
        dom_frontier,
        dominates,
        doms,
    }
}

/// Compute just the dominance frontier (call after compute_dominators if needed separately)
pub fn compute_dominance_frontier(
    num_blocks: usize,
    predecessors: &[Vec<u32>],
    idom: &[u32],
) -> Vec<FixedBitSet> {
    compute_dominance_frontier_internal(num_blocks, predecessors, idom)
}

/// Build immediate dominator array using iterative algorithm
fn build_idom(num_blocks: usize, predecessors: &[Vec<u32>]) -> Vec<u32> {
    // idom[i] = immediate dominator of block i
    // Use u32::MAX as "undefined"
    let mut idom = vec![u32::MAX; num_blocks];

    // Entry block (0) dominates itself
    idom[0] = 0;

    let mut changed = true;
    while changed {
        changed = false;

        // Process blocks in reverse postorder (skip entry block)
        for block_id in 1..num_blocks {
            let preds = &predecessors[block_id];

            // Find first processed predecessor
            let mut new_idom = u32::MAX;
            let mut picked_pred = u32::MAX;

            for &pred in preds {
                if idom[pred as usize] != u32::MAX {
                    new_idom = pred;
                    picked_pred = pred;
                    break;
                }
            }

            if new_idom == u32::MAX {
                // No processed predecessor yet - skip for now
                continue;
            }

            // Intersect with other processed predecessors
            for &pred in preds {
                if pred == picked_pred {
                    continue;
                }
                if idom[pred as usize] != u32::MAX {
                    new_idom = intersect(&idom, pred, new_idom);
                }
            }

            if idom[block_id] != new_idom {
                idom[block_id] = new_idom;
                changed = true;
            }
        }
    }

    idom
}

/// Find lowest common ancestor in dominator tree
#[inline]
fn intersect(idom: &[u32], mut b1: u32, mut b2: u32) -> u32 {
    while b1 != b2 {
        while b1 > b2 {
            b1 = idom[b1 as usize];
        }
        while b2 > b1 {
            b2 = idom[b2 as usize];
        }
    }
    b1
}

/// Collect the set of dominators for each block
fn collect_doms(num_blocks: usize, idom: &[u32]) -> Vec<FixedBitSet> {
    let mut doms = Vec::with_capacity(num_blocks);

    for i in 0..num_blocks {
        let mut dom_set = FixedBitSet::with_capacity(num_blocks);

        if i == 0 {
            // Entry block only dominated by itself
            dom_set.insert(0);
        } else {
            // Walk up dominator tree collecting dominators
            let mut current = idom[i];
            while current != u32::MAX && !dom_set.contains(current as usize) {
                dom_set.insert(current as usize);
                if current == 0 {
                    break;
                }
                current = idom[current as usize];
            }
        }

        doms.push(dom_set);
    }

    doms
}

/// Build the "dominates" relation (inverse of idom)
fn build_dominates(num_blocks: usize, idom: &[u32]) -> Vec<FixedBitSet> {
    let mut dominates = vec![FixedBitSet::with_capacity(num_blocks); num_blocks];

    // Each block is dominated by its idom
    for i in 1..num_blocks {
        let dom = idom[i] as usize;
        if dom < num_blocks {
            dominates[dom].insert(i);
        }
    }

    dominates
}

/// Compute dominance frontier for each block
fn compute_dominance_frontier_internal(
    num_blocks: usize,
    predecessors: &[Vec<u32>],
    idom: &[u32],
) -> Vec<FixedBitSet> {
    let mut dom_frontier = vec![FixedBitSet::with_capacity(num_blocks); num_blocks];

    for block_id in 0..num_blocks {
        let preds = &predecessors[block_id];

        // Only process join points (blocks with >= 2 predecessors)
        if preds.len() >= 2 {
            let block_idom = if block_id == 0 { u32::MAX } else { idom[block_id] };

            for &pred in preds {
                let mut runner = pred;

                // Walk up dominator tree until we reach this block's idom
                while runner != block_idom && runner != u32::MAX {
                    dom_frontier[runner as usize].insert(block_id);

                    if runner == 0 {
                        break;
                    }
                    runner = idom[runner as usize];
                }
            }
        }
    }

    dom_frontier
}

#[cfg(test)]
mod tests {
    use super::*;

    #[test]
    fn test_simple_diamond() {
        // CFG:
        //     0
        //    / \
        //   1   2
        //    \ /
        //     3
        let predecessors = vec![
            vec![],           // 0: entry
            vec![0],          // 1: from 0
            vec![0],          // 2: from 0
            vec![1, 2],       // 3: from 1, 2
        ];
        let successors = vec![
            vec![1, 2],       // 0: to 1, 2
            vec![3],          // 1: to 3
            vec![3],          // 2: to 3
            vec![],           // 3: exit
        ];

        let info = compute_dominators(4, &predecessors, &successors);

        // Check idom
        assert_eq!(info.idom[1], 0); // 1 dominated by 0
        assert_eq!(info.idom[2], 0); // 2 dominated by 0
        assert_eq!(info.idom[3], 0); // 3 dominated by 0 (not 1 or 2)

        // Check dominance frontier
        // Block 1's DF should contain 3
        assert!(info.dom_frontier[1].contains(3));
        // Block 2's DF should contain 3
        assert!(info.dom_frontier[2].contains(3));
    }

    #[test]
    fn test_loop() {
        // CFG:
        //   0 -> 1 -> 2 -> 3
        //        ^    |
        //        +----+
        let predecessors = vec![
            vec![],           // 0: entry
            vec![0, 2],       // 1: from 0, 2 (loop header)
            vec![1],          // 2: from 1
            vec![2],          // 3: from 2
        ];
        let successors = vec![
            vec![1],          // 0: to 1
            vec![2],          // 1: to 2
            vec![1, 3],       // 2: to 1, 3
            vec![],           // 3: exit
        ];

        let info = compute_dominators(4, &predecessors, &successors);

        // Check idom
        assert_eq!(info.idom[1], 0);
        assert_eq!(info.idom[2], 1);
        assert_eq!(info.idom[3], 2);

        // Block 2's DF should contain 1 (back edge target)
        assert!(info.dom_frontier[2].contains(1));
    }

    #[test]
    fn test_empty() {
        let info = compute_dominators(0, &[], &[]);
        assert!(info.idom.is_empty());
    }

    #[test]
    fn test_single_block() {
        let predecessors = vec![vec![]];
        let successors = vec![vec![]];

        let info = compute_dominators(1, &predecessors, &successors);

        assert_eq!(info.idom.len(), 1);
        assert_eq!(info.idom[0], 0); // Entry dominates itself
    }
}
