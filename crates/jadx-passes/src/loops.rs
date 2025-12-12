//! Loop detection and analysis
//!
//! This module detects natural loops in the CFG using dominance information.
//! A natural loop is defined by a back edge (an edge where the target dominates
//! the source).

use std::collections::{BTreeMap, BTreeSet, VecDeque};

use jadx_ir::regions::LoopKind;

use crate::cfg::CFG;

/// Information about a detected loop
#[derive(Debug, Clone)]
pub struct LoopInfo {
    /// Loop header block (dominates all blocks in loop)
    pub header: u32,
    /// All blocks contained in this loop
    pub blocks: BTreeSet<u32>,
    /// Back edges: (source, target=header)
    pub back_edges: Vec<(u32, u32)>,
    /// Blocks that have edges leaving the loop
    pub exit_blocks: Vec<u32>,
    /// Blocks outside the loop that are targets of exit edges
    pub exit_targets: Vec<u32>,
    /// Type of loop (while, do-while, etc.)
    pub kind: LoopKind,
    /// Nesting depth (0 = outermost)
    pub depth: u32,
    /// Parent loop header (if nested)
    pub parent: Option<u32>,
}

impl LoopInfo {
    /// Check if a block is in this loop
    pub fn contains(&self, block: u32) -> bool {
        self.blocks.contains(&block)
    }

    /// Check if this is a pre-tested loop (while)
    pub fn is_pre_tested(&self) -> bool {
        matches!(self.kind, LoopKind::While | LoopKind::For)
    }

    /// Check if this is a post-tested loop (do-while)
    pub fn is_post_tested(&self) -> bool {
        matches!(self.kind, LoopKind::DoWhile)
    }
}

/// Detect all natural loops in the CFG
pub fn detect_loops(cfg: &CFG) -> Vec<LoopInfo> {
    // Step 1: Find all back edges
    let back_edges = find_back_edges(cfg);

    if back_edges.is_empty() {
        return Vec::new();
    }

    // Step 2: Group back edges by header
    let mut header_to_back_edges: BTreeMap<u32, Vec<(u32, u32)>> = BTreeMap::new();
    for (src, dst) in back_edges {
        header_to_back_edges.entry(dst).or_default().push((src, dst));
    }

    // Step 3: Build natural loop for each header
    let mut loops: Vec<LoopInfo> = Vec::new();

    for (header, edges) in header_to_back_edges {
        let blocks = find_natural_loop(cfg, header, &edges);
        let (exit_blocks, exit_targets) = find_loop_exits(cfg, &blocks);
        let kind = classify_loop(cfg, header, &blocks, &exit_blocks);

        loops.push(LoopInfo {
            header,
            blocks,
            back_edges: edges,
            exit_blocks,
            exit_targets,
            kind,
            depth: 0,
            parent: None,
        });
    }

    // Step 4: Compute nesting relationships
    compute_nesting(&mut loops);

    // Sort by depth (innermost first) for processing order
    loops.sort_by(|a, b| b.depth.cmp(&a.depth));

    loops
}

/// Find all back edges in the CFG
/// A back edge is an edge (u, v) where v dominates u
fn find_back_edges(cfg: &CFG) -> Vec<(u32, u32)> {
    let mut back_edges = Vec::new();

    for block_id in cfg.block_ids() {
        for &succ in cfg.successors(block_id) {
            // Check if successor dominates this block (back edge)
            if cfg.dominates(succ, block_id) {
                back_edges.push((block_id, succ));
            }
        }
    }

    back_edges
}

/// Find all blocks in a natural loop given its header and back edges
fn find_natural_loop(cfg: &CFG, header: u32, back_edges: &[(u32, u32)]) -> BTreeSet<u32> {
    let mut loop_blocks = BTreeSet::new();
    loop_blocks.insert(header);

    // Worklist algorithm: start from back edge sources, work backwards
    let mut worklist: VecDeque<u32> = VecDeque::new();

    for &(src, _) in back_edges {
        if src != header {
            loop_blocks.insert(src);
            worklist.push_back(src);
        }
    }

    // Add all blocks that can reach a back edge source without going through header
    while let Some(block) = worklist.pop_front() {
        for &pred in cfg.predecessors(block) {
            if !loop_blocks.contains(&pred) {
                loop_blocks.insert(pred);
                worklist.push_back(pred);
            }
        }
    }

    loop_blocks
}

/// Find blocks that exit the loop and their targets
fn find_loop_exits(cfg: &CFG, loop_blocks: &BTreeSet<u32>) -> (Vec<u32>, Vec<u32>) {
    let mut exit_blocks = Vec::new();
    let mut exit_targets = Vec::new();

    for &block in loop_blocks {
        for &succ in cfg.successors(block) {
            if !loop_blocks.contains(&succ) {
                if !exit_blocks.contains(&block) {
                    exit_blocks.push(block);
                }
                if !exit_targets.contains(&succ) {
                    exit_targets.push(succ);
                }
            }
        }
    }

    (exit_blocks, exit_targets)
}

/// Classify the type of loop
fn classify_loop(
    cfg: &CFG,
    header: u32,
    loop_blocks: &BTreeSet<u32>,
    exit_blocks: &[u32],
) -> LoopKind {
    // Check if header is an exit block (while loop pattern)
    let header_is_exit = exit_blocks.contains(&header);

    // Check if only back edge sources are exits (do-while pattern)
    let back_edge_sources: BTreeSet<u32> = cfg
        .predecessors(header)
        .iter()
        .filter(|&&p| loop_blocks.contains(&p))
        .copied()
        .collect();

    let exits_at_back_edge = exit_blocks
        .iter()
        .all(|e| back_edge_sources.contains(e));

    // Check for endless loop (no exits)
    if exit_blocks.is_empty() {
        return LoopKind::Endless;
    }

    if header_is_exit && !exits_at_back_edge {
        // Condition at header, exit before body
        LoopKind::While
    } else if exits_at_back_edge && !header_is_exit {
        // Condition at end, body always executes once
        LoopKind::DoWhile
    } else if header_is_exit {
        // Could be either, default to while
        // (for loop detection would need more analysis)
        LoopKind::While
    } else {
        // Multiple exit points or complex structure
        LoopKind::While
    }
}

/// Compute nesting relationships between loops
fn compute_nesting(loops: &mut [LoopInfo]) {
    let n = loops.len();

    // For each pair of loops, check containment
    for i in 0..n {
        for j in 0..n {
            if i == j {
                continue;
            }

            // Check if loop j is contained in loop i
            let j_header = loops[j].header;
            if loops[i].blocks.contains(&j_header) && loops[i].header != j_header {
                // j is nested inside i
                // Check if this is the immediate parent (closest containing loop)
                let current_parent = loops[j].parent;
                let should_update = match current_parent {
                    None => true,
                    Some(p) => {
                        // Find the loop with header p
                        let parent_size = loops
                            .iter()
                            .find(|l| l.header == p)
                            .map(|l| l.blocks.len())
                            .unwrap_or(usize::MAX);
                        loops[i].blocks.len() < parent_size
                    }
                };

                if should_update {
                    loops[j].parent = Some(loops[i].header);
                }
            }
        }
    }

    // Compute depths based on parent chain
    for i in 0..n {
        let mut depth = 0;
        let mut current = loops[i].parent;
        while let Some(parent_header) = current {
            depth += 1;
            current = loops
                .iter()
                .find(|l| l.header == parent_header)
                .and_then(|l| l.parent);
        }
        loops[i].depth = depth;
    }
}

/// Get loops containing a specific block, ordered from innermost to outermost
pub fn loops_containing_block(loops: &[LoopInfo], block: u32) -> Vec<&LoopInfo> {
    let mut containing: Vec<&LoopInfo> = loops.iter().filter(|l| l.contains(block)).collect();

    // Sort by depth descending (innermost first)
    containing.sort_by(|a, b| b.depth.cmp(&a.depth));

    containing
}

/// Get the innermost loop containing a block
pub fn innermost_loop(loops: &[LoopInfo], block: u32) -> Option<&LoopInfo> {
    loops_containing_block(loops, block).first().copied()
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
    fn test_no_loops() {
        let instructions = vec![make_nop(0), make_return(1)];
        let blocks = split_blocks(&instructions);
        let cfg = CFG::from_blocks(blocks);
        let loops = detect_loops(&cfg);

        assert!(loops.is_empty());
    }

    #[test]
    fn test_simple_while_loop() {
        // while (cond) { body }
        // B0: if cond goto B2 (exit)
        // B1: body, goto B0 (back edge)
        // B2: return
        let instructions = vec![
            make_if(0, 2),   // B0: loop header, exit if true
            make_goto(1, 0), // B1: back to header (back edge)
            make_return(2),  // B2: exit
        ];
        let blocks = split_blocks(&instructions);
        let cfg = CFG::from_blocks(blocks);
        let loops = detect_loops(&cfg);

        assert_eq!(loops.len(), 1);
        assert_eq!(loops[0].header, 0);
        assert!(loops[0].blocks.contains(&0));
        assert!(loops[0].blocks.contains(&1));
        assert!(!loops[0].blocks.contains(&2)); // Exit not in loop
    }

    #[test]
    fn test_do_while_loop() {
        // do { body } while (cond)
        // B0: body
        // B1: if cond goto B0 (back edge), else fall through
        // B2: return
        let instructions = vec![
            make_goto(0, 1), // B0: body -> condition
            make_if(1, 0),   // B1: back to B0 if true
            make_return(2),  // B2: exit
        ];
        let blocks = split_blocks(&instructions);
        let cfg = CFG::from_blocks(blocks);
        let loops = detect_loops(&cfg);

        assert_eq!(loops.len(), 1);
        // Header is the target of back edge
        assert!(loops[0].blocks.len() >= 2);
    }

    #[test]
    fn test_nested_loops() {
        // for outer { for inner { } }
        // B0: outer header
        // B1: inner header
        // B2: inner body -> B1
        // B3: outer body after inner -> B0
        // B4: exit
        let instructions = vec![
            make_if(0, 4),   // B0: outer loop, exit if done
            make_if(1, 3),   // B1: inner loop header
            make_goto(2, 1), // B2: inner back edge
            make_goto(3, 0), // B3: outer back edge
            make_return(4),  // B4: exit
        ];
        let blocks = split_blocks(&instructions);
        let cfg = CFG::from_blocks(blocks);
        let loops = detect_loops(&cfg);

        // Should detect 2 loops
        assert_eq!(loops.len(), 2);

        // One should be nested in the other
        let depths: Vec<u32> = loops.iter().map(|l| l.depth).collect();
        assert!(depths.contains(&0)); // Outer loop
        assert!(depths.contains(&1)); // Inner loop
    }

    #[test]
    fn test_endless_loop() {
        // while (true) { }
        // B0: body
        // goto B0
        let instructions = vec![
            make_goto(0, 0), // Infinite loop
        ];
        let blocks = split_blocks(&instructions);
        let cfg = CFG::from_blocks(blocks);
        let loops = detect_loops(&cfg);

        assert_eq!(loops.len(), 1);
        assert_eq!(loops[0].kind, LoopKind::Endless);
    }
}
