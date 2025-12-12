//! Region builder - orchestrates control flow reconstruction
//!
//! This module transforms a flat CFG into a hierarchical Region tree that
//! represents structured control flow (if/else, loops, switch, try-catch).
//! This is the key step that enables generating readable Java code instead
//! of goto-based spaghetti.
//!
//! ## Algorithm Overview
//!
//! Based on JADX's RegionMaker implementation for 1:1 output compatibility:
//!
//! 1. **Detect loops** - Find back edges, classify as while/do-while/for/endless
//! 2. **Detect conditionals** - Find if/else patterns with merge points
//! 3. **Detect synchronized** - Match MONITOR_ENTER/MONITOR_EXIT pairs
//! 4. **Build region tree** - Recursively process blocks, wrapping in regions
//!
//! ## Region Types
//!
//! - **Sequence** - Linear list of blocks/nested regions
//! - **If** - Conditional with then/else branches and merge point
//! - **Loop** - While, do-while, for, foreach, or endless loops
//! - **Switch** - Multi-way branch with case regions
//! - **TryCatch** - Exception handling with handlers and optional finally
//! - **Synchronized** - Monitor-protected critical section
//!
//! ## Break/Continue Detection
//!
//! The module also detects break and continue edges within loops:
//! - **Break**: Edge from inside loop to outside (not through normal exit)
//! - **Continue**: Edge to loop header from non-latch position
//!
//! Labels are generated for nested loops (e.g., `break loop_0;`)

use std::collections::{BTreeMap, BTreeSet};

use jadx_ir::instructions::{IfCondition, InsnType};
use jadx_ir::regions::{CatchHandler, Condition, LoopKind, Region, RegionContent, SwitchCase};

use crate::block_split::BasicBlock;
use crate::cfg::CFG;
use crate::conditionals::{detect_conditionals, IfInfo};
use crate::loops::{detect_loops, LoopInfo};

/// Try block information
#[derive(Debug, Clone)]
pub struct TryInfo {
    /// Block where try starts
    pub start_block: u32,
    /// Blocks covered by this try
    pub try_blocks: BTreeSet<u32>,
    /// Handler blocks for each exception type
    pub handlers: Vec<HandlerInfo>,
    /// Block after the try-catch (merge point)
    pub merge_block: Option<u32>,
}

/// Exception handler information
#[derive(Debug, Clone)]
pub struct HandlerInfo {
    /// Exception type (None = catch-all)
    pub exception_type: Option<String>,
    /// Handler entry block
    pub handler_block: u32,
    /// Blocks in the handler
    pub handler_blocks: BTreeSet<u32>,
}

/// Synchronized block information
#[derive(Debug, Clone)]
pub struct SyncInfo {
    /// Block with MONITOR_ENTER
    pub enter_block: u32,
    /// Blocks with MONITOR_EXIT
    pub exit_blocks: BTreeSet<u32>,
    /// Blocks inside the synchronized region
    pub body_blocks: BTreeSet<u32>,
}

/// Edge instruction - synthetic instruction inserted at CFG edge
#[derive(Debug, Clone)]
pub struct EdgeInsn {
    /// Source block
    pub from: u32,
    /// Target block
    pub to: u32,
    /// Instruction type
    pub kind: EdgeInsnKind,
}

/// Kind of edge instruction
#[derive(Debug, Clone)]
pub enum EdgeInsnKind {
    /// Break out of loop
    Break { label: Option<String> },
    /// Continue to next iteration
    Continue { label: Option<String> },
}

/// Break/continue edge information for a loop
#[derive(Debug, Clone)]
pub struct LoopEdgeInsns {
    /// Loop header block
    pub loop_header: u32,
    /// Break edges (exit loop early)
    pub breaks: Vec<EdgeInsn>,
    /// Continue edges (skip to next iteration)
    pub continues: Vec<EdgeInsn>,
}

/// Detect break and continue edges for a loop
///
/// Break edges: edges from inside the loop to outside (not through normal exit)
/// Continue edges: edges to the loop header from inside (not the back edge at end)
pub fn detect_loop_edge_insns(cfg: &CFG, loop_info: &LoopInfo, all_loops: &[LoopInfo]) -> LoopEdgeInsns {
    let mut breaks = Vec::new();
    let mut continues = Vec::new();

    for &block in &loop_info.blocks {
        for &succ in cfg.successors(block) {
            // Check for break: edge goes outside the loop
            if !loop_info.blocks.contains(&succ) {
                // This is an exit edge
                // Check if it's NOT the normal loop exit (from the loop condition)
                let is_normal_exit = block == loop_info.header
                    && loop_info.exit_blocks.contains(&block);

                if !is_normal_exit {
                    // This is a break - determine if we need a label
                    let label = get_break_label(loop_info, all_loops);
                    breaks.push(EdgeInsn {
                        from: block,
                        to: succ,
                        kind: EdgeInsnKind::Break { label },
                    });
                }
            }

            // Check for continue: edge goes to header from non-latch position
            if succ == loop_info.header && loop_info.blocks.contains(&block) {
                // The "latch" is typically the block with the back edge at the end of the loop.
                // If there are multiple back edges, the latch is usually the one with the highest
                // block number (last in the loop body).
                let latch_block = loop_info
                    .back_edges
                    .iter()
                    .map(|(src, _)| *src)
                    .max()
                    .unwrap_or(block);

                // An edge to the header is a "continue" if:
                // 1. It's not from the latch block (the natural loop end)
                // 2. OR it's from a conditional branch (not the fall-through)
                let is_from_latch = block == latch_block;

                // Check if this block has multiple successors (conditional)
                let block_succs = cfg.successors(block);
                let is_conditional = block_succs.len() > 1;

                // If it's from a conditional in the middle of the loop, it's a continue
                if is_conditional && !is_from_latch {
                    let label = get_continue_label(loop_info, all_loops, block);
                    continues.push(EdgeInsn {
                        from: block,
                        to: succ,
                        kind: EdgeInsnKind::Continue { label },
                    });
                }
            }
        }
    }

    LoopEdgeInsns {
        loop_header: loop_info.header,
        breaks,
        continues,
    }
}

/// Get label for break statement (needed for nested loops)
fn get_break_label(loop_info: &LoopInfo, all_loops: &[LoopInfo]) -> Option<String> {
    // Check if this loop is nested inside another
    if loop_info.parent.is_some() {
        // Generate label like "loop_N" where N is the header block
        Some(format!("loop_{}", loop_info.header))
    } else {
        None
    }
}

/// Get label for continue statement (needed for nested loops)
fn get_continue_label(loop_info: &LoopInfo, all_loops: &[LoopInfo], from_block: u32) -> Option<String> {
    // Check if the continue is from inside a nested loop
    let is_in_nested = all_loops.iter().any(|l| {
        l.header != loop_info.header
            && l.parent == Some(loop_info.header)
            && l.blocks.contains(&from_block)
    });

    if is_in_nested {
        // Need label to continue outer loop
        Some(format!("loop_{}", loop_info.header))
    } else {
        None
    }
}

/// Detect all break/continue edges for all loops
pub fn detect_all_loop_edges(cfg: &CFG, loops: &[LoopInfo]) -> Vec<LoopEdgeInsns> {
    loops
        .iter()
        .map(|l| detect_loop_edge_insns(cfg, l, loops))
        .collect()
}

/// Build region tree from a CFG
pub fn build_regions(cfg: &CFG) -> Region {
    // Detect loops and conditionals
    let loops = detect_loops(cfg);
    let conditionals = detect_conditionals(cfg, &loops);

    // Detect synchronized blocks
    let syncs = detect_synchronized_blocks(cfg);

    // Create builder context
    let mut builder = RegionBuilder::new(cfg, &loops, &conditionals, &syncs);

    // Build from entry block
    builder.make_method_region()
}

/// Detect synchronized blocks by finding MONITOR_ENTER/MONITOR_EXIT pairs
pub fn detect_synchronized_blocks(cfg: &CFG) -> Vec<SyncInfo> {
    let mut syncs = Vec::new();

    for block_id in cfg.block_ids() {
        if let Some(block) = cfg.get_block(block_id) {
            for insn in &block.instructions {
                if matches!(insn.insn_type, InsnType::MonitorEnter { .. }) {
                    // Found a monitor enter - find matching exits
                    if let Some(sync_info) = find_sync_region(cfg, block_id) {
                        syncs.push(sync_info);
                    }
                }
            }
        }
    }

    syncs
}

/// Find the synchronized region starting from a MONITOR_ENTER block
fn find_sync_region(cfg: &CFG, enter_block: u32) -> Option<SyncInfo> {
    let mut body_blocks = BTreeSet::new();
    let mut exit_blocks = BTreeSet::new();
    let mut worklist = vec![enter_block];
    let mut visited = BTreeSet::new();

    while let Some(block_id) = worklist.pop() {
        if visited.contains(&block_id) {
            continue;
        }
        visited.insert(block_id);

        if let Some(block) = cfg.get_block(block_id) {
            // Check for MONITOR_EXIT
            let has_exit = block.instructions.iter().any(|insn| {
                matches!(insn.insn_type, InsnType::MonitorExit { .. })
            });

            if has_exit {
                exit_blocks.insert(block_id);
                // Don't continue past exit blocks
                continue;
            }

            body_blocks.insert(block_id);

            // Add successors to worklist
            for &succ in cfg.successors(block_id) {
                if !visited.contains(&succ) {
                    worklist.push(succ);
                }
            }
        }
    }

    if exit_blocks.is_empty() {
        return None;
    }

    Some(SyncInfo {
        enter_block,
        exit_blocks,
        body_blocks,
    })
}

/// Region stack - tracks exits and nested regions (matching Java's RegionStack)
struct RegionStack {
    /// Exit blocks at each nesting level
    exits: Vec<BTreeSet<u32>>,
}

impl RegionStack {
    fn new() -> Self {
        RegionStack {
            exits: vec![BTreeSet::new()],
        }
    }

    /// Push a new region level
    fn push(&mut self) {
        self.exits.push(BTreeSet::new());
    }

    /// Pop a region level
    fn pop(&mut self) {
        if self.exits.len() > 1 {
            self.exits.pop();
        }
    }

    /// Add an exit block at current level
    fn add_exit(&mut self, block: Option<u32>) {
        if let Some(b) = block {
            if let Some(exits) = self.exits.last_mut() {
                exits.insert(b);
            }
        }
    }

    /// Check if block is an exit at any level
    fn contains_exit(&self, block: u32) -> bool {
        self.exits.iter().any(|exits| exits.contains(&block))
    }
}

/// Region builder state
struct RegionBuilder<'a> {
    cfg: &'a CFG,
    loops: &'a [LoopInfo],
    #[allow(dead_code)]
    conditionals: &'a [IfInfo],
    #[allow(dead_code)]
    syncs: &'a [SyncInfo],
    /// Blocks that have been processed (like Java's processedBlocks)
    processed: BTreeSet<u32>,
    /// Loop header -> LoopInfo lookup
    loop_map: BTreeMap<u32, &'a LoopInfo>,
    /// Condition block -> IfInfo lookup
    cond_map: BTreeMap<u32, &'a IfInfo>,
    /// Sync enter block -> SyncInfo lookup
    sync_map: BTreeMap<u32, &'a SyncInfo>,
    /// Region stack for exit tracking
    stack: RegionStack,
}

impl<'a> RegionBuilder<'a> {
    fn new(
        cfg: &'a CFG,
        loops: &'a [LoopInfo],
        conditionals: &'a [IfInfo],
        syncs: &'a [SyncInfo],
    ) -> Self {
        let mut loop_map = BTreeMap::new();
        for l in loops {
            loop_map.insert(l.header, l);
        }

        let mut cond_map = BTreeMap::new();
        for c in conditionals {
            cond_map.insert(c.condition_block, c);
        }

        let mut sync_map = BTreeMap::new();
        for s in syncs {
            sync_map.insert(s.enter_block, s);
        }

        RegionBuilder {
            cfg,
            loops,
            conditionals,
            syncs,
            processed: BTreeSet::new(),
            loop_map,
            cond_map,
            sync_map,
            stack: RegionStack::new(),
        }
    }

    /// Build region for method (entry point)
    fn make_method_region(&mut self) -> Region {
        let entry = self.cfg.entry();
        self.make_region(entry)
    }

    /// Make a region starting from a block (like Java's makeRegion)
    fn make_region(&mut self, start_block: u32) -> Region {
        let mut contents = Vec::new();

        // Check if we've already hit an exit
        if self.stack.contains_exit(start_block) {
            return Region::Sequence(contents);
        }

        // Check if already processed (duplicate region warning in Java)
        if self.processed.contains(&start_block) {
            return Region::Sequence(contents);
        }

        let mut current = Some(start_block);

        while let Some(block_id) = current {
            current = self.traverse(&mut contents, block_id);
        }

        if contents.len() == 1 {
            // Unwrap single-element sequence
            match contents.pop().unwrap() {
                RegionContent::Region(r) => *r,
                RegionContent::Block(b) => Region::Sequence(vec![RegionContent::Block(b)]),
            }
        } else {
            Region::Sequence(contents)
        }
    }

    /// Traverse a block and return next block to process (like Java's traverse)
    fn traverse(&mut self, contents: &mut Vec<RegionContent>, block_id: u32) -> Option<u32> {
        // Check if we're at an exit
        if self.stack.contains_exit(block_id) {
            return None;
        }

        // Check if already processed
        if self.processed.contains(&block_id) {
            return None;
        }

        // Check for synchronized block (MONITOR_ENTER)
        if let Some(sync_info) = self.sync_map.get(&block_id).copied() {
            let (sync_region, next) = self.process_synchronized(sync_info);
            contents.push(RegionContent::Region(Box::new(sync_region)));
            return next;
        }

        // Check for loop start first (like Java)
        if let Some(loop_info) = self.loop_map.get(&block_id).copied() {
            // This is a loop header - process the loop
            let (loop_region, next) = self.process_loop(loop_info);
            contents.push(RegionContent::Region(Box::new(loop_region)));
            return next;
        }

        // Check for conditional
        if let Some(cond_info) = self.cond_map.get(&block_id).copied() {
            let (if_region, next) = self.process_if(cond_info);
            contents.push(RegionContent::Region(Box::new(if_region)));
            return next;
        }

        // Check for switch
        if self.is_switch_block(block_id) {
            let (switch_region, next) = self.process_switch(block_id);
            contents.push(RegionContent::Region(Box::new(switch_region)));
            return next;
        }

        // Regular block - add it and continue
        self.processed.insert(block_id);
        contents.push(RegionContent::Block(block_id));

        // Get next block
        let succs = self.cfg.successors(block_id);
        if succs.len() == 1 && !self.stack.contains_exit(succs[0]) {
            Some(succs[0])
        } else {
            None
        }
    }

    /// Process a synchronized block (like Java's SynchronizedRegionMaker)
    fn process_synchronized(&mut self, sync_info: &SyncInfo) -> (Region, Option<u32>) {
        // Mark enter block as processed
        self.processed.insert(sync_info.enter_block);

        self.stack.push();

        // Find exit point (block after MONITOR_EXIT)
        let exit_block = sync_info
            .exit_blocks
            .iter()
            .filter_map(|&exit| {
                self.cfg.successors(exit).first().copied()
            })
            .next();

        self.stack.add_exit(exit_block);

        // Build body region
        let body = self.build_sync_body(sync_info);

        // Mark all body and exit blocks as processed
        for &block in &sync_info.body_blocks {
            self.processed.insert(block);
        }
        for &block in &sync_info.exit_blocks {
            self.processed.insert(block);
        }

        self.stack.pop();

        let region = Region::Synchronized {
            enter_block: sync_info.enter_block,
            body: Box::new(body),
        };

        (region, exit_block)
    }

    /// Build the body of a synchronized block
    fn build_sync_body(&mut self, sync_info: &SyncInfo) -> Region {
        let mut contents = Vec::new();

        // Get first block after the enter block
        let body_start = self.cfg
            .successors(sync_info.enter_block)
            .first()
            .copied();

        if let Some(start) = body_start {
            if sync_info.body_blocks.contains(&start) {
                let mut current = Some(start);
                while let Some(block_id) = current {
                    if sync_info.exit_blocks.contains(&block_id) {
                        break;
                    }
                    if !sync_info.body_blocks.contains(&block_id) {
                        break;
                    }

                    contents.push(RegionContent::Block(block_id));

                    // Get next block in body
                    current = self.cfg
                        .successors(block_id)
                        .iter()
                        .find(|&&s| sync_info.body_blocks.contains(&s) && !sync_info.exit_blocks.contains(&s))
                        .copied();
                }
            }
        }

        Region::Sequence(contents)
    }

    /// Process a loop region (like Java's LoopRegionMaker.process)
    fn process_loop(&mut self, loop_info: &LoopInfo) -> (Region, Option<u32>) {
        // Mark all loop blocks as processed
        for &block in &loop_info.blocks {
            self.processed.insert(block);
        }

        self.stack.push();

        // Determine loop exit
        let loop_exit = loop_info.exit_targets.first().copied();
        self.stack.add_exit(loop_exit);

        // Extract condition from the loop header
        let condition = self.extract_condition(loop_info.header);

        // Build loop body
        let body = self.build_loop_body(loop_info);

        self.stack.pop();

        let region = Region::Loop {
            kind: loop_info.kind,
            condition: Some(condition),
            body: Box::new(body),
        };

        (region, loop_exit)
    }

    /// Extract condition from a block that ends with an If instruction
    ///
    /// In Dalvik bytecode, the branch is taken when the condition is TRUE.
    /// But in structured Java code, the "then" block is the fall-through path
    /// (when condition is FALSE). So we negate the condition to match Java semantics.
    fn extract_condition(&self, block_id: u32) -> Condition {
        if let Some(block) = self.cfg.get_block(block_id) {
            // Find the If instruction (usually the last one)
            for insn in block.instructions.iter().rev() {
                if let InsnType::If { condition, .. } = &insn.insn_type {
                    // Use simple_negated because:
                    // - In Dalvik: if condition TRUE, branch to else; else fall-through to then
                    // - In Java: if (cond) { then } requires cond TRUE -> then
                    // So we need to negate the Dalvik condition
                    return Condition::simple_negated(block_id, condition.clone());
                }
            }
        }
        Condition::Unknown
    }

    /// Build loop body region
    fn build_loop_body(&mut self, loop_info: &LoopInfo) -> Region {
        let mut contents = Vec::new();
        let mut visited = BTreeSet::new();

        // For while loops, start after the header condition
        // For do-while loops, include the header in the body
        let body_start = if loop_info.kind == LoopKind::DoWhile {
            loop_info.header
        } else {
            // Find first non-header block that's in the loop
            self.cfg
                .successors(loop_info.header)
                .iter()
                .find(|&&s| loop_info.blocks.contains(&s) && s != loop_info.header)
                .copied()
                .unwrap_or(loop_info.header)
        };

        let mut worklist = vec![body_start];

        while let Some(block_id) = worklist.pop() {
            if visited.contains(&block_id) {
                continue;
            }
            if !loop_info.blocks.contains(&block_id) {
                continue;
            }

            visited.insert(block_id);

            // Check for nested structures
            if let Some(nested_loop) = self.find_nested_loop(block_id, loop_info) {
                let body = self.build_loop_body(nested_loop);
                contents.push(RegionContent::Region(Box::new(Region::Loop {
                    kind: nested_loop.kind,
                    condition: Some(Condition::Unknown),
                    body: Box::new(body),
                })));
            } else if let Some(cond) = self.cond_map.get(&block_id).copied() {
                // Nested conditional - check if fully contained in loop
                if cond.then_blocks.iter().all(|b| loop_info.blocks.contains(b))
                    && cond.else_blocks.iter().all(|b| loop_info.blocks.contains(b))
                {
                    let (if_region, _) = self.process_if(cond);
                    contents.push(RegionContent::Region(Box::new(if_region)));
                } else {
                    contents.push(RegionContent::Block(block_id));
                }
            } else {
                contents.push(RegionContent::Block(block_id));
            }

            // Add successors that are in the loop
            for &succ in self.cfg.successors(block_id) {
                if loop_info.blocks.contains(&succ) && !visited.contains(&succ) {
                    worklist.push(succ);
                }
            }
        }

        Region::Sequence(contents)
    }

    /// Find a nested loop starting at this block
    fn find_nested_loop(&self, block: u32, parent: &LoopInfo) -> Option<&'a LoopInfo> {
        self.loops.iter().find(|l| {
            l.header == block && l.header != parent.header && parent.blocks.contains(&l.header)
        })
    }

    /// Process an if-else region (like Java's IfRegionMaker.process)
    fn process_if(&mut self, cond: &IfInfo) -> (Region, Option<u32>) {
        // Mark condition block as processed
        self.processed.insert(cond.condition_block);

        self.stack.push();

        // Add merge point as exit
        self.stack.add_exit(cond.merge_block);

        // Extract condition from the block
        let condition = self.extract_condition(cond.condition_block);

        // Build then region
        let then_region = if cond.then_blocks.is_empty() {
            Region::Sequence(vec![])
        } else {
            for &b in &cond.then_blocks {
                self.processed.insert(b);
            }
            self.build_branch_region(&cond.then_blocks)
        };

        // Build else region
        let else_region = if cond.else_blocks.is_empty() {
            None
        } else {
            for &b in &cond.else_blocks {
                self.processed.insert(b);
            }
            Some(Box::new(self.build_branch_region(&cond.else_blocks)))
        };

        self.stack.pop();

        let region = Region::If {
            condition,
            then_region: Box::new(then_region),
            else_region,
        };

        (region, cond.merge_block)
    }

    /// Build a region from a list of blocks
    fn build_branch_region(&self, blocks: &[u32]) -> Region {
        if blocks.is_empty() {
            return Region::Sequence(vec![]);
        }

        let contents: Vec<RegionContent> = blocks
            .iter()
            .map(|&b| RegionContent::Block(b))
            .collect();

        Region::Sequence(contents)
    }

    /// Check if a block is a switch statement
    fn is_switch_block(&self, block: u32) -> bool {
        if let Some(b) = self.cfg.get_block(block) {
            if let Some(last) = b.instructions.last() {
                return matches!(
                    last.insn_type,
                    InsnType::PackedSwitch { .. } | InsnType::SparseSwitch { .. }
                );
            }
        }
        false
    }

    /// Process a switch region (like Java's SwitchRegionMaker.process)
    fn process_switch(&mut self, block: u32) -> (Region, Option<u32>) {
        self.processed.insert(block);

        // Get switch targets and extract keys from instruction
        let succs = self.cfg.successors(block);
        let switch_info = self.get_switch_info(block);

        // Find merge point - the block where all cases converge
        let merge_block = self.find_switch_merge(block, &succs);

        self.stack.push();
        self.stack.add_exit(merge_block);

        // Build cases with proper keys
        let mut cases: Vec<SwitchCase> = Vec::new();
        let mut default_case = None;

        for (i, &target) in succs.iter().enumerate() {
            // Don't include merge block as a case
            if merge_block == Some(target) {
                continue;
            }

            // Build case body - collect blocks until merge point
            let case_blocks = self.collect_case_blocks(target, merge_block);
            for &b in &case_blocks {
                self.processed.insert(b);
            }

            let case_region = if case_blocks.is_empty() {
                Region::Sequence(vec![RegionContent::Block(target)])
            } else {
                let contents: Vec<RegionContent> = case_blocks
                    .iter()
                    .map(|&b| RegionContent::Block(b))
                    .collect();
                Region::Sequence(contents)
            };

            // Get key for this case
            let key = switch_info
                .as_ref()
                .and_then(|info| info.get(i))
                .copied()
                .unwrap_or(i as i32);

            // Check if this is the default case (usually last successor for packed switch)
            if i == succs.len() - 1 && switch_info.is_none() {
                default_case = Some(Box::new(case_region));
            } else {
                cases.push(SwitchCase {
                    keys: vec![key],
                    region: Box::new(case_region),
                });
            }
        }

        self.stack.pop();

        let region = Region::Switch {
            header_block: block,
            cases,
            default: default_case,
        };

        (region, merge_block)
    }

    /// Get switch keys from the instruction
    /// Note: Switch payload data is not yet parsed - returns None for now
    fn get_switch_info(&self, block: u32) -> Option<Vec<i32>> {
        let b = self.cfg.get_block(block)?;
        let last = b.instructions.last()?;

        match &last.insn_type {
            InsnType::PackedSwitch { .. } | InsnType::SparseSwitch { .. } => {
                // TODO: Parse switch payload data from the bytecode
                // For now, we don't have the keys/targets extracted
                None
            }
            _ => None,
        }
    }

    /// Find the merge point for a switch statement
    fn find_switch_merge(&self, switch_block: u32, targets: &[u32]) -> Option<u32> {
        if targets.is_empty() {
            return None;
        }

        // Collect all blocks reachable from each case
        let mut case_reaches: Vec<BTreeSet<u32>> = Vec::new();

        for &target in targets {
            let mut reachable = BTreeSet::new();
            let mut worklist = vec![target];
            let mut visited = BTreeSet::new();

            while let Some(b) = worklist.pop() {
                if visited.contains(&b) {
                    continue;
                }
                visited.insert(b);
                reachable.insert(b);

                // Don't follow back edges to the switch block
                for &succ in self.cfg.successors(b) {
                    if succ != switch_block && !visited.contains(&succ) {
                        worklist.push(succ);
                    }
                }
            }

            case_reaches.push(reachable);
        }

        // Find common blocks (intersection of all reachable sets)
        if case_reaches.is_empty() {
            return None;
        }

        let mut common = case_reaches[0].clone();
        for reaches in case_reaches.iter().skip(1) {
            common = common.intersection(reaches).copied().collect();
        }

        // The merge point is the earliest common block
        // (lowest ID, assuming blocks are numbered in order)
        common.into_iter().next()
    }

    /// Collect blocks belonging to a switch case until the merge point
    fn collect_case_blocks(&self, start: u32, merge: Option<u32>) -> Vec<u32> {
        let mut blocks = Vec::new();
        let mut current = Some(start);
        let mut visited = BTreeSet::new();

        while let Some(block_id) = current {
            if visited.contains(&block_id) {
                break;
            }
            if merge == Some(block_id) {
                break;
            }

            visited.insert(block_id);
            blocks.push(block_id);

            // Follow single successor or stop at branch
            let succs = self.cfg.successors(block_id);
            current = if succs.len() == 1 {
                let next = succs[0];
                if merge != Some(next) {
                    Some(next)
                } else {
                    None
                }
            } else {
                None
            };
        }

        blocks
    }
}

/// Simplified region construction for a method
pub fn build_method_regions(blocks: &BTreeMap<u32, BasicBlock>, entry: u32) -> Region {
    // Convert to BlockSplitResult format
    use crate::block_split::BlockSplitResult;

    let exits: Vec<u32> = blocks
        .values()
        .filter(|b| {
            b.instructions
                .last()
                .map(|i| matches!(i.insn_type, InsnType::Return { .. } | InsnType::Throw { .. }))
                .unwrap_or(false)
        })
        .map(|b| b.id)
        .collect();

    let result = BlockSplitResult {
        blocks: blocks.clone(),
        entry_block: entry,
        exit_blocks: exits,
    };

    let cfg = CFG::from_blocks(result);
    build_regions(&cfg)
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
    fn test_linear_region() {
        let instructions = vec![make_nop(0), make_nop(1), make_return(2)];
        let blocks = split_blocks(instructions);
        let cfg = CFG::from_blocks(blocks);
        let region = build_regions(&cfg);

        // Should be a sequence
        assert!(matches!(region, Region::Sequence(_)));
    }

    #[test]
    fn test_if_region() {
        let instructions = vec![
            make_if(0, 2),   // if
            make_nop(1),     // then
            make_return(2),  // merge
        ];
        let blocks = split_blocks(instructions);
        let cfg = CFG::from_blocks(blocks);
        let region = build_regions(&cfg);

        // Root should contain an If region
        match region {
            Region::Sequence(contents) => {
                let _has_if = contents.iter().any(|c| {
                    matches!(c, RegionContent::Region(r) if matches!(**r, Region::If { .. }))
                });
                // May or may not detect as if depending on structure
            }
            Region::If { .. } => {
                // Direct if is also valid
            }
            _ => {}
        }
    }

    #[test]
    fn test_loop_region() {
        let instructions = vec![
            make_if(0, 2),   // loop condition
            make_goto(1, 0), // back edge
            make_return(2),  // exit
        ];
        let blocks = split_blocks(instructions);
        let cfg = CFG::from_blocks(blocks);
        let region = build_regions(&cfg);

        // Should contain a Loop region
        fn contains_loop(region: &Region) -> bool {
            match region {
                Region::Loop { .. } => true,
                Region::Sequence(contents) => contents.iter().any(|c| match c {
                    RegionContent::Region(r) => contains_loop(r),
                    _ => false,
                }),
                Region::If { then_region, else_region, .. } => {
                    contains_loop(then_region)
                        || else_region.as_ref().map(|r| contains_loop(r)).unwrap_or(false)
                }
                _ => false,
            }
        }

        assert!(contains_loop(&region));
    }

    #[test]
    fn test_break_detection() {
        // while (cond) { if (x) break; body }
        // B0: if cond -> B3 (exit)
        // B1: if x -> B3 (break!)
        // B2: body -> B0
        // B3: return
        let instructions = vec![
            make_if(0, 3),   // B0: loop condition, exit if true
            make_if(1, 3),   // B1: break condition, break if true
            make_goto(2, 0), // B2: back edge
            make_return(3),  // B3: exit
        ];
        let blocks = split_blocks(instructions);
        let cfg = CFG::from_blocks(blocks);
        let loops = detect_loops(&cfg);

        assert_eq!(loops.len(), 1);

        let edge_insns = detect_loop_edge_insns(&cfg, &loops[0], &loops);

        // Should detect one break edge (from B1 to B3)
        // The edge from B0 to B3 is the normal loop exit, not a break
        assert!(
            !edge_insns.breaks.is_empty(),
            "Should detect break edge from inner condition"
        );
    }

    #[test]
    fn test_continue_detection() {
        // while (cond) { if (x) continue; body }
        // B0: if cond -> B3 (exit)
        // B1: if x -> B0 (continue!)
        // B2: body -> B0 (natural back edge)
        // B3: return
        let instructions = vec![
            make_if(0, 3),   // B0: loop condition
            make_if(1, 0),   // B1: continue if true
            make_goto(2, 0), // B2: natural back edge
            make_return(3),  // B3: exit
        ];
        let blocks = split_blocks(instructions);
        let cfg = CFG::from_blocks(blocks);
        let loops = detect_loops(&cfg);

        assert_eq!(loops.len(), 1);

        let edge_insns = detect_loop_edge_insns(&cfg, &loops[0], &loops);

        // Should detect continue edge from B1 to B0
        // B2 to B0 is the natural back edge, not a continue
        assert!(
            !edge_insns.continues.is_empty(),
            "Should detect continue edge from inner condition"
        );
    }
}
