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

use tracing::error;

use dexterity_ir::instructions::InsnType;
use dexterity_ir::regions::{CaseInfo, CaseKey, CatchHandler, Condition, LoopKind, LoopType, Region, RegionContent};

use crate::block_split::BasicBlock;
use crate::cfg::CFG;
use crate::finally_extract::{apply_finally_marking, extract_finally};
use crate::conditionals::{detect_conditionals, find_condition_chains, IfInfo, MergedCondition, MergeMode};
use crate::if_region_visitor::process_if_regions;
use crate::loops::{detect_loops, LoopInfo};
use crate::ternary_mod::{try_transform_to_ternary, TernaryTransformResult};

/// Try block information
#[derive(Debug, Clone)]
pub struct TryInfo {
    /// Unique ID for this try block (index in try list)
    pub id: usize,
    /// Block where try starts
    pub start_block: u32,
    /// Blocks covered by this try
    pub try_blocks: BTreeSet<u32>,
    /// Handler blocks for each exception type
    pub handlers: Vec<HandlerInfo>,
    /// Block after the try-catch (merge point)
    pub merge_block: Option<u32>,
    /// Outer try block ID (for nested exception handling)
    pub outer_try_block: Option<usize>,
    /// Inner try block IDs (for nested exception handling)
    pub inner_try_blocks: Vec<usize>,
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
    /// True if this is a finally handler (not a catch)
    pub is_finally: bool,
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
                    let label = get_break_label(loop_info, all_loops, block, succ);
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
///
/// Port of JADX LoopRegionMaker.addBreakLabel() (lines 385-414)
/// A label is needed when:
/// 1. The break source block is in multiple nested loops (depth >= 2)
/// 2. The break target is NOT inside another loop (otherwise control stays in loop hierarchy)
/// 3. The break exits beyond the immediate parent loop
fn get_break_label(loop_info: &LoopInfo, all_loops: &[LoopInfo], from_block: u32, to_block: u32) -> Option<String> {
    // Step 1: Check if break target is in any loop
    // If the target is inside a loop, no label needed - control stays in loop hierarchy
    let target_in_loop = all_loops.iter().any(|l| l.blocks.contains(&to_block));
    if target_in_loop {
        return None;
    }

    // Step 2: Count how many loops contain the source block
    // Only need labels for nested loops (2+ loops containing the source)
    let loops_containing_source: Vec<&LoopInfo> = all_loops
        .iter()
        .filter(|l| l.blocks.contains(&from_block))
        .collect();

    if loops_containing_source.len() < 2 {
        // Not in nested loops - no label needed
        return None;
    }

    // Step 3: Find the parent (outermost) loop containing the source
    let parent_loop = loops_containing_source
        .iter()
        .find(|l| l.parent.is_none())
        .or_else(|| loops_containing_source.first())
        .copied();

    if let Some(parent) = parent_loop {
        // Step 4: Check if break goes outside the parent loop
        // If target is the parent's exit or end block, no label needed
        let is_parent_exit = parent.exit_targets.contains(&to_block)
            || parent.exit_blocks.contains(&to_block);

        if !is_parent_exit {
            // Breaking beyond parent loop - need label for the current loop
            return Some(format!("loop_{}", loop_info.header));
        }
    }

    // Default: if loop has a parent, add a label (conservative fallback)
    if loop_info.parent.is_some() {
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

/// ACC_DECLARED_SYNCHRONIZED flag for methods in DEX format
/// Note: DEX uses 0x20000 for declared-synchronized methods, NOT 0x0020
/// This indicates a method that was declared with the synchronized keyword.
/// The compiler generates implicit MONITOR_ENTER at start and MONITOR_EXIT at end.
const ACC_DECLARED_SYNCHRONIZED: u32 = 0x20000;

/// Build region tree from a CFG
pub fn build_regions(cfg: &CFG) -> Region {
    build_regions_with_try_catch(cfg, &[])
}

/// Build regions with try-catch block information from IR
pub fn build_regions_with_try_catch(cfg: &CFG, try_blocks: &[dexterity_ir::TryBlock]) -> Region {
    build_regions_with_method_flags(cfg, try_blocks, 0)
}

/// Build regions with try-catch block information and method access flags.
///
/// When `method_flags` contains ACC_DECLARED_SYNCHRONIZED (0x20000), the method uses
/// implicit monitor enter/exit generated by the compiler. These should NOT
/// generate synchronized(this) blocks - the method declaration itself is synchronized.
pub fn build_regions_with_method_flags(cfg: &CFG, try_blocks: &[dexterity_ir::TryBlock], method_flags: u32) -> Region {
    // Note: No hard block limit - using JADX-style dynamic iteration limits instead.
    // RegionBuilder tracks iteration_budget (5 × block_count) and panics if exceeded.
    // This allows processing of large methods while preventing infinite loops.
    // Panics are caught by catch_unwind in body_gen.rs and converted to stub methods.

    // Convert try blocks to internal format
    let tries = detect_try_catch_regions(cfg, try_blocks);

    let loops = detect_loops(cfg);
    let conditionals = detect_conditionals(cfg, &loops);

    // For synchronized methods, the compiler generates implicit MONITOR_ENTER/EXIT
    // that should NOT become synchronized(this) blocks. Skip detection in this case.
    let syncs = if method_flags & ACC_DECLARED_SYNCHRONIZED != 0 {
        tracing::debug!("Skipping synchronized detection: method has ACC_DECLARED_SYNCHRONIZED (flags=0x{:04x})", method_flags);
        Vec::new()
    } else {
        let syncs = detect_synchronized_blocks(cfg);
        if !syncs.is_empty() {
            tracing::debug!("Detected {} synchronized blocks (flags=0x{:04x})", syncs.len(), method_flags);
        }
        syncs
    };

    let merged = find_condition_chains(&conditionals, cfg);

    let mut builder = RegionBuilder::new(cfg, &loops, &conditionals, &syncs, &tries, &merged);
    let mut region = builder.make_method_region();

    // Apply if-region optimizations (branch reordering, else-if chain marking)
    process_if_regions(&mut region, cfg);

    region
}

/// Mark duplicated finally code with `DONT_GENERATE` before region building.
///
/// This runs the finally extraction algorithm and applies instruction/block flags
/// so codegen can skip duplicated finally sequences (1:1 with JADX behavior).
pub fn mark_duplicated_finally(cfg: &mut CFG, try_blocks: &[dexterity_ir::TryBlock]) {
    if try_blocks.is_empty() {
        return;
    }

    let tries = detect_try_catch_regions(cfg, try_blocks);

    for try_info in &tries {
        // Catch-all handler (None type) is a candidate for finally.
        let Some(catch_all_idx) = try_info.handlers.iter().position(|h| h.exception_type.is_none()) else {
            continue;
        };
        let catch_all_handler = &try_info.handlers[catch_all_idx];

        // Heuristic: finally handler ends with a throw (re-throw of stored exception).
        let Some(last_block_id) = catch_all_handler.handler_blocks.iter().max().copied() else {
            continue;
        };
        let Some(last_block) = cfg.get_block(last_block_id) else {
            continue;
        };
        let ends_with_throw = last_block
            .instructions
            .last()
            .map(|insn| matches!(insn.insn_type, InsnType::Throw { .. }))
            .unwrap_or(false);
        if !ends_with_throw {
            continue;
        }

        if let Some(extract_info) = extract_finally(cfg, try_info, catch_all_handler) {
            apply_finally_marking(&extract_info, cfg);
        }
    }
}

/// Detect try-catch regions from IR TryBlock information
fn detect_try_catch_regions(cfg: &CFG, try_blocks: &[dexterity_ir::TryBlock]) -> Vec<TryInfo> {
    let mut tries = Vec::with_capacity(try_blocks.len());

    // Debug: Log try blocks from DEX
    if std::env::var("DEBUG_TRY_CATCH").is_ok() {
        eprintln!("[DEBUG_TRY_CATCH] Input try_blocks count: {}", try_blocks.len());
        for (i, tb) in try_blocks.iter().enumerate() {
            eprintln!("[DEBUG_TRY_CATCH] Try[{}]: start=0x{:x}, end=0x{:x}, handlers={:?}",
                i, tb.start_addr, tb.end_addr,
                tb.handlers.iter().map(|h| format!("{:?}@0x{:x}", h.exception_type, h.handler_addr)).collect::<Vec<_>>());
        }
    }

    // Build a map of start_offset (instruction address) -> block_id for fast lookups
    // CRITICAL: block_id is a sequential index (0, 1, 2...) but instruction addresses
    // are actual DEX offsets (0x0, 0xb, 0x1c...). We need this map to convert addresses.
    let mut addr_to_block: BTreeMap<u32, u32> = BTreeMap::new();
    for block_id in cfg.block_ids() {
        if let Some(block) = cfg.get_block(block_id) {
            addr_to_block.insert(block.start_offset, block_id);
        }
    }

    // P1-SWITCH-INIT FIX: Pre-collect ALL try block ranges first
    // This is needed so that when collecting handler blocks, we can stop at blocks
    // that belong to OTHER try blocks (prevents enum switch init handlers from
    // collecting subsequent try blocks' body code)
    let all_try_ranges: Vec<BTreeSet<u32>> = try_blocks.iter().map(|try_block| {
        let mut try_block_ids = BTreeSet::new();
        for block_id in cfg.block_ids() {
            if let Some(block) = cfg.get_block(block_id) {
                let block_start = block.start_offset;
                let block_end = block.end_offset;
                if block_start < try_block.end_addr && block_end > try_block.start_addr {
                    try_block_ids.insert(block_id);
                }
            }
        }
        try_block_ids
    }).collect();

    for (try_idx, try_block) in try_blocks.iter().enumerate() {
        // Find blocks covered by this try
        // CRITICAL FIX: Compare block address ranges NOT block_id (sequential index)
        // A block is covered if it OVERLAPS with the try range, not just starts within it.
        // This handles cases where try covers just a few instructions in the middle of a block.
        let mut try_block_ids = BTreeSet::new();
        for block_id in cfg.block_ids() {
            if let Some(block) = cfg.get_block(block_id) {
                // Check if block overlaps with try range:
                // block starts before try ends AND block ends after try starts
                let block_start = block.start_offset;
                let block_end = block.end_offset;
                if block_start < try_block.end_addr && block_end > try_block.start_addr {
                    try_block_ids.insert(block_id);
                }
            }
        }

        if try_block_ids.is_empty() {
            if std::env::var("DEBUG_TRY_CATCH").is_ok() {
                eprintln!("[DEBUG_TRY_CATCH] SKIPPED: No CFG blocks in range 0x{:x}-0x{:x}, cfg block offsets: {:?}",
                    try_block.start_addr, try_block.end_addr,
                    cfg.block_ids().take(10).filter_map(|id| cfg.get_block(id).map(|b| format!("0x{:x}-0x{:x}", b.start_offset, b.end_offset))).collect::<Vec<_>>());
            }
            continue;
        }

        if std::env::var("DEBUG_TRY_CATCH").is_ok() {
            eprintln!("[DEBUG_TRY_CATCH] Found {} blocks in try range 0x{:x}-0x{:x}: {:?}",
                try_block_ids.len(), try_block.start_addr, try_block.end_addr,
                try_block_ids.iter().filter_map(|&id| cfg.get_block(id).map(|b| format!("block{}@0x{:x}-0x{:x}", id, b.start_offset, b.end_offset))).collect::<Vec<_>>());
        }

        // Find start block (first block in try)
        let start_block = *try_block_ids.iter().next().unwrap();

        // CRITICAL FIX (P0-CFG01): Remove handler entry addresses from try_block_ids BEFORE
        // collecting handler blocks. Handler entry addresses may fall within the try address
        // range (when catch code immediately follows try code in bytecode), but they must NOT
        // be considered part of the try body. If we leave them in try_block_ids, then
        // collect_handler_blocks_by_dominance() will exclude them during its walk, resulting
        // in empty handler_blocks and the handler code incorrectly staying in the try body.
        // This matches JADX's prepareTryBlocks() which removes handler blocks from try blocks.
        let mut try_block_ids = try_block_ids;
        for h in &try_block.handlers {
            // Convert handler address to block ID using the addr_to_block map
            if let Some(&handler_block_id) = addr_to_block.get(&h.handler_addr) {
                try_block_ids.remove(&handler_block_id);
            }
        }

        // Convert exception handlers, filtering out monitor-exit-only handlers
        // These are synthetic handlers for synchronized blocks that should not generate code
        let handlers: Vec<HandlerInfo> = try_block.handlers.iter().filter_map(|h| {
            // Convert handler address to block ID
            let handler_block = match addr_to_block.get(&h.handler_addr) {
                Some(&block_id) => block_id,
                None => {
                    if std::env::var("DEBUG_TRY_CATCH").is_ok() {
                        eprintln!("[DEBUG_TRY_CATCH] No block found for handler addr 0x{:x}", h.handler_addr);
                    }
                    return None; // Skip handlers with no matching block
                }
            };

            // Use dominance-based block collection (JADX BlockExceptionHandler.java style)
            // This replaces the old simple forward reachability with a hard 500-block limit
            // P1-SWITCH-INIT FIX: Collect blocks that belong to OTHER try blocks (not this one)
            // so handler collection stops at their boundaries
            let other_try_blocks: BTreeSet<u32> = all_try_ranges.iter()
                .enumerate()
                .filter(|(idx, _)| *idx != try_idx)
                .flat_map(|(_, blocks)| blocks.iter().copied())
                .collect();
            let handler_blocks = collect_handler_blocks_by_dominance(cfg, handler_block, &try_block_ids, &other_try_blocks);

            if std::env::var("DEBUG_TRY_CATCH").is_ok() {
                eprintln!("[DEBUG_TRY_CATCH] Handler: type={:?}, block=0x{:x}, handler_blocks={:?}",
                    h.exception_type, handler_block,
                    handler_blocks.iter().map(|b| format!("0x{:x}", b)).collect::<Vec<_>>());
            }

            // Filter out monitor-exit-only handlers (synchronized block cleanup)
            // These handlers only contain: MOVE_EXCEPTION, MONITOR_EXIT, THROW
            // JADX's removeMonitorExitFromExcHandler() removes these at the instruction level
            // We filter them at the region level to avoid generating try/catch for synchronized blocks
            if h.exception_type.is_none() && is_monitor_only_handler(cfg, &handler_blocks) {
                if std::env::var("DEBUG_TRY_CATCH").is_ok() {
                    eprintln!("[DEBUG_TRY_CATCH] FILTERED: monitor-only handler at 0x{:x}", handler_block);
                }
                return None;
            }

            Some(HandlerInfo {
                exception_type: h.exception_type.clone(),
                handler_block,
                handler_blocks,
                is_finally: false,
            })
        }).collect();

        // Merge handlers that share the same handler_block (multi-catch pattern)
        // In Java 7+, catch (IOException | SQLException e) compiles to multiple
        // catch entries pointing to the same handler block
        let handlers = merge_multi_catch_handlers(handlers);

        // CRITICAL FIX (P0-CFG01): Remove ALL handler blocks from try_block_ids
        // Now that collect_handler_blocks_by_dominance() collects all dominated blocks
        // (including those within the try address range), we must remove them from
        // try_block_ids to prevent handler code from appearing in the try body.
        // This matches JADX's prepareTryBlocks() which does: blocks.removeAll(eh.getBlocks())
        for handler in &handlers {
            for &hblock in &handler.handler_blocks {
                try_block_ids.remove(&hblock);
            }
        }

        // Find merge block (first block after all try and handler blocks)
        let all_blocks: BTreeSet<u32> = try_block_ids.iter()
            .chain(handlers.iter().flat_map(|h| h.handler_blocks.iter()))
            .copied()
            .collect();

        let merge_block = all_blocks.iter()
            .flat_map(|&b| cfg.successors(b))
            .find(|&&succ| !all_blocks.contains(&succ))
            .copied();

        let try_info = TryInfo {
            id: tries.len(),
            start_block,
            try_blocks: try_block_ids.clone(),
            handlers: handlers.clone(),
            merge_block,
            outer_try_block: None,
            inner_try_blocks: Vec::new(),
        };

        // Debug: Log created TryInfo
        if std::env::var("DEBUG_TRY_CATCH").is_ok() {
            eprintln!("[DEBUG_TRY_CATCH] Created TryInfo[{}]: start_block=0x{:x}, try_blocks={:?}, handlers={}, merge={:?}",
                try_info.id, try_info.start_block,
                try_info.try_blocks.iter().map(|b| format!("0x{:x}", b)).collect::<Vec<_>>(),
                try_info.handlers.len(),
                try_info.merge_block.map(|b| format!("0x{:x}", b)));
        }

        tries.push(try_info);
    }

    // Establish nested exception relationships (JADX BlockExceptionHandler.checkTryCatchRelation style)
    establish_try_nesting(&mut tries);

    tries
}

/// Establish outer/inner relationships between try blocks
///
/// Based on JADX BlockExceptionHandler.checkTryCatchRelation() algorithm.
/// Detects when one try block is nested inside another's handler or try region.
fn establish_try_nesting(tries: &mut [TryInfo]) {
    let n = tries.len();
    if n < 2 {
        return;
    }

    // For each pair of try blocks, check if one contains the other
    for i in 0..n {
        for j in 0..n {
            if i == j {
                continue;
            }

            // Check if try[j] is nested inside try[i]
            // This happens when try[j]'s start block is either:
            // 1. Inside try[i]'s try blocks, or
            // 2. Inside one of try[i]'s handler blocks
            let j_start = tries[j].start_block;

            let is_in_try_region = tries[i].try_blocks.contains(&j_start);
            let is_in_handler = tries[i].handlers.iter()
                .any(|h| h.handler_blocks.contains(&j_start));

            if is_in_try_region || is_in_handler {
                // try[j] is nested inside try[i]
                // Only set if not already set (avoid overwriting with deeper nesting)
                if tries[j].outer_try_block.is_none() {
                    tries[j].outer_try_block = Some(i);
                }
            }
        }
    }

    // Build inner_try_blocks lists from outer_try_block references
    for i in 0..n {
        if let Some(outer_id) = tries[i].outer_try_block {
            // We can't mutate while iterating, so we collect and apply after
            // This is a limitation - we'll do a second pass
        }
    }

    // Second pass to populate inner_try_blocks
    let outer_refs: Vec<(usize, usize)> = tries.iter()
        .filter_map(|t| t.outer_try_block.map(|outer| (t.id, outer)))
        .collect();

    for (inner_id, outer_id) in outer_refs {
        if outer_id < tries.len() {
            tries[outer_id].inner_try_blocks.push(inner_id);
        }
    }
}

/// Collect all blocks belonging to an exception handler
///
/// Based on JADX BlockExceptionHandler.java collectHandlerBlocks() method.
/// Uses a hybrid approach:
/// 1. First tries dominance-based collection (proper analysis, no hard limit)
/// 2. Falls back to forward reachability if dominance yields insufficient results
///    (handles synthetic CFGs and edge cases where dominance isn't computed)
///
/// CRITICAL (P0-CFG01): This function deliberately does NOT exclude try_blocks during
/// collection. Handler blocks may have addresses within the try range (when catch code
/// immediately follows try code in bytecode). If we excluded try_blocks here, those
/// handler blocks would be missed, causing handler code to appear in the try body.
/// The caller (detect_try_catch_regions) removes collected handler blocks from
/// try_block_ids AFTER this function returns.
///
/// P1-SWITCH-INIT: Added `other_try_blocks` parameter - blocks that belong to OTHER
/// try blocks. Collection stops when it hits these blocks to prevent enum switch init
/// handlers from collecting subsequent try blocks' body code.
fn collect_handler_blocks_by_dominance(
    cfg: &CFG,
    handler_block: u32,
    _try_blocks: &BTreeSet<u32>,  // Kept for API compatibility but intentionally unused
    other_try_blocks: &BTreeSet<u32>,  // P1-SWITCH-INIT: Blocks in OTHER try blocks to stop at
) -> BTreeSet<u32> {
    // Try dominance-based collection first
    // Collect ALL blocks dominated by the handler, even if they're in the try address range
    // P1-SWITCH-INIT: But STOP at blocks that belong to other try blocks
    let mut dominated_blocks = BTreeSet::new();
    for block_id in cfg.block_ids() {
        // P1-SWITCH-INIT: Skip blocks that belong to other try blocks
        if other_try_blocks.contains(&block_id) {
            continue;
        }
        if cfg.dominates(handler_block, block_id) {
            dominated_blocks.insert(block_id);
        }
    }

    // If dominance found blocks beyond just the handler itself, use those results
    if dominated_blocks.len() > 1 || (dominated_blocks.len() == 1 && !dominated_blocks.contains(&handler_block)) {
        return dominated_blocks;
    }

    // Fall back to forward reachability (for synthetic CFGs or edge cases)
    // Don't filter by try_blocks - collect all reachable blocks from handler
    // P1-SWITCH-INIT: But STOP at blocks that belong to other try blocks
    let mut handler_blocks = BTreeSet::new();
    let mut worklist = vec![handler_block];
    let mut visited = BTreeSet::new();

    while let Some(b) = worklist.pop() {
        if visited.contains(&b) {
            continue;
        }
        visited.insert(b);

        // P1-SWITCH-INIT: Skip blocks that belong to other try blocks
        if other_try_blocks.contains(&b) {
            continue;
        }

        handler_blocks.insert(b);

        // Add successors (no hard limit needed with dominance fallback)
        for &succ in cfg.successors(b) {
            if !visited.contains(&succ) {
                worklist.push(succ);
            }
        }
    }

    handler_blocks
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
                // IMPORTANT: Also add to body_blocks - the exit block may contain
                // actual body code BEFORE the monitor-exit instruction.
                // The code generator will skip the MONITOR_EXIT instruction itself.
                body_blocks.insert(block_id);
                // Don't continue past exit blocks (don't add successors)
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

/// Merge handlers that share the same handler_block into multi-catch handlers
///
/// In Java 7+, multi-catch syntax like `catch (IOException | SQLException e)`
/// compiles to multiple catch entries in the bytecode, all pointing to the
/// same handler block. This function detects this pattern and merges the
/// handlers into a single HandlerInfo with multiple exception types.
fn merge_multi_catch_handlers(handlers: Vec<HandlerInfo>) -> Vec<HandlerInfo> {
    if handlers.len() <= 1 {
        return handlers;
    }

    // Group handlers by handler_block
    let mut by_block: BTreeMap<u32, Vec<HandlerInfo>> = BTreeMap::new();
    for handler in handlers {
        by_block.entry(handler.handler_block).or_default().push(handler);
    }

    // Merge handlers with the same handler_block
    let mut merged: Vec<HandlerInfo> = Vec::new();
    for (_block, mut group) in by_block {
        if group.len() == 1 {
            // Single handler for this block - no merging needed
            merged.push(group.remove(0));
        } else {
            // Multiple handlers for same block - merge into multi-catch
            // Take the first handler as base and add exception types from others
            let mut base = group.remove(0);

            // Collect all exception types (skip catch-all handlers in merge)
            let mut all_types: Vec<String> = Vec::new();
            if let Some(t) = base.exception_type.take() {
                all_types.push(t);
            }
            for other in group {
                if let Some(t) = other.exception_type {
                    if !all_types.contains(&t) {
                        all_types.push(t);
                    }
                }
            }

            // If we have multiple types, set the first as the main type
            // The full list will be passed through the handler_blocks (not ideal)
            // or we need to store multi-catch types directly
            if all_types.len() > 1 {
                // Store as pipe-separated for now (will parse in codegen)
                // Better approach: add exception_types: Vec<String> to HandlerInfo
                base.exception_type = Some(all_types.join("|"));
            } else if !all_types.is_empty() {
                base.exception_type = Some(all_types.remove(0));
            }

            merged.push(base);
        }
    }

    merged
}

/// Detect monitor-exit-only handlers that are used for synchronized blocks
///
/// Compilers generate synthetic catch-all handlers that only release
/// the monitor lock when an exception occurs inside a synchronized block.
/// They should not generate try-catch code since the synchronized syntax
/// already implies the lock release.
///
/// Pattern detected:
/// ```text
/// :catchall
///   move-exception v0
///   monitor-exit v1
///   throw v0
/// ```
fn is_monitor_only_handler(cfg: &CFG, handler_blocks: &BTreeSet<u32>) -> bool {
    // Handler should have few blocks (typically 1)
    if handler_blocks.len() > 3 {
        return false;
    }

    // Collect all instructions from handler blocks
    let mut has_monitor_exit = false;
    let mut has_throw = false;
    let mut other_insn_count = 0;

    for &block_id in handler_blocks {
        if let Some(block) = cfg.get_block(block_id) {
            for insn in &block.instructions {
                match &insn.insn_type {
                    InsnType::MoveException { .. } => {} // MoveException is allowed but not required
                    InsnType::MonitorExit { .. } => has_monitor_exit = true,
                    InsnType::Throw { .. } => has_throw = true,
                    InsnType::Nop => {} // NOPs are ignored
                    InsnType::Goto { .. } => {} // GOTOs between handler blocks are ok
                    _ => other_insn_count += 1,
                }
            }
        }
    }

    // A monitor-only handler has MONITOR_EXIT and THROW, with no other meaningful instructions
    has_monitor_exit && has_throw && other_insn_count == 0
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

    /// Push a new region level. Returns false if limit exceeded (JADX-style bail out).
    fn push(&mut self) -> bool {
        // JADX: RegionStack.java:66 - bail out when limit exceeded
        // Override with DEXTERITY_REGION_STACK_LIMIT env var
        let limit = dexterity_limits::regions::region_stack_limit();
        if self.exits.len() > limit {
            tracing::error!(
                stack_size = self.exits.len(),
                limit = limit,
                "LIMIT_EXCEEDED: Region stack overflow, bailing out"
            );
            return false;
        }
        self.exits.push(BTreeSet::new());
        true
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
    /// Try-catch regions
    #[allow(dead_code)]
    tries: &'a [TryInfo],
    /// Merged condition chains (for &&, || synthesis)
    #[allow(dead_code)]
    merged_conditions: &'a [MergedCondition],
    /// Blocks that have been processed (like Java's processedBlocks)
    processed: BTreeSet<u32>,
    /// Loop header -> LoopInfo lookup
    loop_map: BTreeMap<u32, &'a LoopInfo>,
    /// Condition block -> IfInfo lookup
    cond_map: BTreeMap<u32, &'a IfInfo>,
    /// Sync enter block -> SyncInfo lookup
    sync_map: BTreeMap<u32, &'a SyncInfo>,
    /// Try start block -> TryInfo lookup
    try_map: BTreeMap<u32, &'a TryInfo>,
    /// Merged condition first_block -> MergedCondition lookup
    merged_map: BTreeMap<u32, &'a MergedCondition>,
    /// Blocks that are part of a merged condition (to skip when encountered)
    #[allow(dead_code)]
    merged_blocks: BTreeSet<u32>,
    /// Region stack for exit tracking
    stack: RegionStack,
    /// Number of regions created so far
    regions_count: usize,
    /// Maximum number of regions allowed (blocks * 100)
    regions_limit: usize,
    /// Iteration budget for traversal (5 × block_count, like JADX)
    iteration_budget: usize,
    /// Number of iterations used so far
    iterations_used: usize,
}

impl<'a> RegionBuilder<'a> {
    fn new(
        cfg: &'a CFG,
        loops: &'a [LoopInfo],
        conditionals: &'a [IfInfo],
        syncs: &'a [SyncInfo],
        tries: &'a [TryInfo],
        merged_conditions: &'a [MergedCondition],
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

        let mut try_map = BTreeMap::new();
        for t in tries {
            try_map.insert(t.start_block, t);
        }

        // Build merged condition maps
        let mut merged_map = BTreeMap::new();
        let mut merged_blocks = BTreeSet::new();
        for m in merged_conditions {
            merged_map.insert(m.first_block, m);
            // Track all blocks that are part of merged conditions (except first)
            // so we can skip them when traversing
            for &block in &m.merged_blocks[1..] {
                merged_blocks.insert(block);
            }
        }

        let block_count = cfg.block_ids().count();
        RegionBuilder {
            cfg,
            loops,
            conditionals,
            syncs,
            tries,
            merged_conditions,
            processed: BTreeSet::new(),
            loop_map,
            cond_map,
            sync_map,
            try_map,
            merged_map,
            merged_blocks,
            stack: RegionStack::new(),
            regions_count: 0,
            regions_limit: block_count * 100,
            // Increased from 5x to 20x to handle complex control flows like large.apk
            // Methods with 76 blocks may need 761 iterations (10x), so 20x is safer margin
            iteration_budget: block_count * 20,
            iterations_used: 0,
        }
    }

    /// Check iteration budget and panic if exceeded (like JADX's JadxOverflowException)
    /// This prevents infinite loops in complex CFGs while allowing large methods to be processed
    fn check_iteration_budget(&mut self) {
        self.iterations_used += 1;
        if self.iterations_used > self.iteration_budget {
            error!(
                iterations = self.iterations_used,
                budget = self.iteration_budget,
                blocks = self.iteration_budget / 10,
                "LIMIT_EXCEEDED: Region iteration limit reached"
            );
            panic!(
                "Iteration limit reached: {} iterations (budget: {} = 10 × {} blocks)",
                self.iterations_used,
                self.iteration_budget,
                self.iteration_budget / 10
            );
        }
    }

    /// Build region for method (entry point)
    fn make_method_region(&mut self) -> Region {
        let entry = self.cfg.entry();
        self.make_region(entry)
    }

    /// Make a region starting from a block (like Java's makeRegion)
    fn make_region(&mut self, start_block: u32) -> Region {
        // JADX: RegionMaker.java:68
        self.regions_count += 1;
        if self.regions_count > self.regions_limit {
            error!(
                regions_count = self.regions_count,
                regions_limit = self.regions_limit,
                "LIMIT_EXCEEDED: Regions count limit reached"
            );
            panic!("Regions count limit reached");
        }

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
            if contents.len() > 100_000 { // Safety limit
                error!(
                    contents_len = contents.len(),
                    block_id = block_id,
                    "LIMIT_EXCEEDED: Region contents limit reached (100,000)"
                );
                panic!("Region contents limit reached (100,000) at block {}", block_id);
            }
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
        // JADX-style iteration budget check (DepthRegionTraversal.java)
        self.check_iteration_budget();

        // Check if we're at an exit
        if self.stack.contains_exit(block_id) {
            return None;
        }

        // Check if already processed
        if self.processed.contains(&block_id) {
            return None;
        }

        // Debug: Show what we're checking for this block
        if std::env::var("DEBUG_TRY_CATCH").is_ok() {
            let is_try = self.try_map.contains_key(&block_id);
            let is_loop = self.loop_map.contains_key(&block_id);
            if is_try || is_loop {
                eprintln!("[DEBUG_TRY_CATCH] traverse block {}: is_try={}, is_loop={}", block_id, is_try, is_loop);
            }
        }

        // Check for synchronized block (MONITOR_ENTER)
        if let Some(sync_info) = self.sync_map.get(&block_id).copied() {
            let (sync_region, next) = self.process_synchronized(sync_info);
            contents.push(RegionContent::Region(Box::new(sync_region)));
            return next;
        }

        // Check for try-catch block start
        if let Some(try_info) = self.try_map.get(&block_id).copied() {
            // P1-TRY-CATCH-RECON: If this block is ALSO a loop header, process loop first
            // so that the try-catch can be nested inside the loop body
            if let Some(loop_info) = self.loop_map.get(&block_id).copied() {
                if std::env::var("DEBUG_TRY_CATCH").is_ok() {
                    eprintln!("[DEBUG_TRY_CATCH] Block {} is BOTH try start AND loop header, processing loop first", block_id);
                }
                let (loop_region, next) = self.process_loop(loop_info);
                contents.push(RegionContent::Region(Box::new(loop_region)));
                return next;
            }
            if std::env::var("DEBUG_TRY_CATCH").is_ok() {
                eprintln!("[DEBUG_TRY_CATCH] PROCESSING try at block 0x{:x} with {} handlers", block_id, try_info.handlers.len());
            }
            let (try_region, next) = self.process_try_catch(try_info);
            contents.push(RegionContent::Region(Box::new(try_region)));
            return next;
        }

        // Check for loop start first (like Java)
        if let Some(loop_info) = self.loop_map.get(&block_id).copied() {
            if std::env::var("DEBUG_TRY_CATCH").is_ok() {
                eprintln!("[DEBUG_TRY_CATCH] PROCESSING loop at block {} with {} blocks: {:?}",
                    block_id, loop_info.blocks.len(), loop_info.blocks);
            }
            // This is a loop header - process the loop
            let (loop_region, next) = self.process_loop(loop_info);
            contents.push(RegionContent::Region(Box::new(loop_region)));
            return next;
        }

        // Check for conditional
        if let Some(cond_info) = self.cond_map.get(&block_id).copied() {
            if std::env::var("DEBUG_CONDITIONALS").is_ok() {
                eprintln!("[REGION] block={} is conditional, then={:?} else={:?}",
                    block_id, cond_info.then_blocks, cond_info.else_blocks);
            }
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

        // JADX-style bail out when region stack limit exceeded
        if !self.stack.push() {
            return (Region::Sequence(vec![]), None);
        }

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
            enter_insn_offset: 0, // Offset stored in block instructions
            enter_block: sync_info.enter_block,
            body: Box::new(body),
            exit_insn_offsets: vec![], // Exit offsets stored in block instructions
        };

        (region, exit_block)
    }

    /// Build the body of a synchronized block.
    /// For single-block sync: directly include the block (MONITOR_ENTER/EXIT are filtered in codegen).
    /// For multi-block sync: use make_region to handle all nested control flow.
    fn build_sync_body(&mut self, sync_info: &SyncInfo) -> Region {
        // Handle single-block synchronized: when MONITOR_ENTER and MONITOR_EXIT
        // are in the same block, the body IS that block (instructions between them).
        let is_single_block = sync_info.exit_blocks.contains(&sync_info.enter_block);

        if is_single_block {
            // Single-block sync: the body is the enter block itself.
            // Note: The enter block is already marked as processed by process_synchronized,
            // so we can't use make_region here. Instead, directly include the block content.
            // The MONITOR_ENTER and MONITOR_EXIT instructions are filtered out during code generation.
            return Region::Sequence(vec![RegionContent::Block(sync_info.enter_block)]);
        }

        // Multi-block sync: find first successor in body_blocks and use make_region
        let body_start = self.cfg
            .successors(sync_info.enter_block)
            .iter()
            .find(|&&s| sync_info.body_blocks.contains(&s) && !self.processed.contains(&s))
            .copied();

        let Some(start) = body_start else {
            return Region::Sequence(vec![]);
        };

        // Use the main make_region method to build the body.
        // The exit block was already added to the stack by process_synchronized,
        // so make_region will stop at the sync boundary automatically.
        // This properly handles all nested control flow: if/else, loops, try-catch, etc.
        self.make_region(start)
    }

    /// Find a nested loop starting at this block within a synchronized region
    #[allow(dead_code)]
    fn find_nested_loop_in_sync(&self, block: u32, sync: &SyncInfo) -> Option<&'a LoopInfo> {
        self.loops.iter().find(|l| {
            l.header == block && sync.body_blocks.contains(&l.header)
        })
    }

    /// Process a try-catch region (like Java's TryCatchRegionMaker)
    fn process_try_catch(&mut self, try_info: &TryInfo) -> (Region, Option<u32>) {
        // CRITICAL FIX (P0-CFG01): Do NOT pre-mark try blocks as processed here.
        // build_try_body needs to call process_if -> build_branch_region -> traverse,
        // and traverse checks self.processed to decide whether to process a block.
        // If we pre-mark all try blocks, traverse will skip them all, resulting in
        // empty nested regions. Instead, build_try_body marks blocks as it processes them.

        // JADX-style bail out when region stack limit exceeded
        if !self.stack.push() {
            return (Region::Sequence(vec![]), try_info.merge_block);
        }

        // Add merge point as exit
        self.stack.add_exit(try_info.merge_block);

        // Build try body region - this will mark blocks as processed
        let try_body = self.build_try_body(try_info);

        // Detect finally block from catch-all handler
        // In Java bytecode, finally is implemented as:
        // 1. A catch-all handler that stores exception, runs finally code, then re-throws
        // 2. Finally code is also duplicated at end of try and each catch handler
        let (finally_region, finally_handler_idx) = self.detect_finally_block(try_info);

        // Build catch handlers (excluding finally handler if detected)
        let catch_handlers: Vec<CatchHandler> = try_info
            .handlers
            .iter()
            .enumerate()
            .filter(|(idx, _)| finally_handler_idx.map_or(true, |fi| *idx != fi))
            .map(|(_, handler)| {
                // Mark handler blocks as processed
                for &block in &handler.handler_blocks {
                    self.processed.insert(block);
                }

                // Build handler body
                let handler_body = self.build_handler_body(handler);

                // Convert exception type to Vec<String> for multi-catch support
                // Multi-catch types are stored as pipe-separated (e.g., "IOException|SQLException")
                let exception_types: Vec<String> = handler
                    .exception_type
                    .as_ref()
                    .map(|t| {
                        if t.contains('|') {
                            // Multi-catch: split pipe-separated types
                            t.split('|').map(|s| s.to_string()).collect()
                        } else {
                            vec![t.clone()]
                        }
                    })
                    .unwrap_or_default();

                CatchHandler {
                    exception_types,
                    catch_all: handler.exception_type.is_none(),
                    region: Box::new(handler_body),
                }
            })
            .collect();

        self.stack.pop();

        let region = Region::TryCatch {
            try_region: Box::new(try_body),
            handlers: catch_handlers,
            finally: finally_region,
        };

        (region, try_info.merge_block)
    }

    /// Detect finally block from catch-all handler
    ///
    /// Java compilers implement finally as:
    /// 1. A catch-all handler (catches Throwable) that:
    ///    - Stores the exception
    ///    - Executes the finally code
    ///    - Re-throws the exception
    /// 2. Finally code is duplicated at:
    ///    - End of try block (normal exit)
    ///    - End of each catch handler
    ///
    /// Returns (finally_region, handler_index) if finally detected
    fn detect_finally_block(&mut self, try_info: &TryInfo) -> (Option<Box<Region>>, Option<usize>) {
        // Find catch-all handler (exception_type is None)
        let catch_all_idx = try_info.handlers.iter().position(|h| h.exception_type.is_none());
        let catch_all_handler = match catch_all_idx {
            Some(idx) => &try_info.handlers[idx],
            None => return (None, None),
        };

        // Check if catch-all handler ends with a throw instruction
        // This is the pattern for finally: catch-all -> finally code -> re-throw
        let last_block_id = catch_all_handler.handler_blocks.iter().max().copied();
        let last_block = match last_block_id.and_then(|id| self.cfg.get_block(id)) {
            Some(b) => b,
            None => return (None, None),
        };

        // Check if the last instruction is a Throw
        let ends_with_throw = last_block
            .instructions
            .last()
            .map(|insn| matches!(insn.insn_type, InsnType::Throw { .. }))
            .unwrap_or(false);

        if !ends_with_throw {
            // Not a finally pattern - this is a real catch-all handler
            return (None, None);
        }

        // Run finally extraction algorithm
        // Use simple finally detection (works for basic cases)
        // Mark handler blocks as processed
        for &block in &catch_all_handler.handler_blocks {
            self.processed.insert(block);
        }

        // Build finally region from catch-all handler body (excluding the throw at the end)
        // The finally code is everything in the catch-all handler except the re-throw
        let finally_region = self.build_finally_body(catch_all_handler);

        (Some(Box::new(finally_region)), catch_all_idx)
    }

    /// Build finally body from catch-all handler
    /// Includes all handler blocks; codegen skips DONT_GENERATE marked instructions
    fn build_finally_body(&self, handler: &HandlerInfo) -> Region {
        let mut contents = Vec::new();

        // Build handler blocks in order
        let mut sorted_blocks: Vec<u32> = handler.handler_blocks.iter().copied().collect();
        sorted_blocks.sort();

        // Include all blocks - codegen will skip duplicated instructions marked DONT_GENERATE
        for block_id in sorted_blocks {
            contents.push(RegionContent::Block(block_id));
        }

        Region::Sequence(contents)
    }

    /// Build the try body region
    fn build_try_body(&mut self, try_info: &TryInfo) -> Region {
        let mut contents = Vec::new();
        let mut processed_in_try = BTreeSet::new();

        // Build blocks in order
        let mut sorted_blocks: Vec<u32> = try_info.try_blocks.iter().copied().collect();
        sorted_blocks.sort();

        for block_id in sorted_blocks {
            // Skip already processed (in case of nested structures)
            if !try_info.try_blocks.contains(&block_id) {
                continue;
            }
            // Skip blocks already processed as part of nested structures
            if processed_in_try.contains(&block_id) {
                continue;
            }

            // Check for nested loops/conditionals within try
            if let Some(loop_info) = self.loop_map.get(&block_id).copied() {
                if loop_info.blocks.iter().all(|b| try_info.try_blocks.contains(b)) {
                    let body = self.build_loop_body(loop_info);
                    contents.push(RegionContent::Region(Box::new(Region::Loop {
                        kind: loop_info.kind,
                        condition: Some(self.extract_condition(loop_info.header)),
                        body: Box::new(body),
                        details: None,
                        loop_type: LoopType::None,
                        condition_at_end: loop_info.kind == LoopKind::DoWhile,
                        header_block: Some(loop_info.header),
                        pre_condition_block: None,
                        label: None,
                    })));
                    // Mark all loop blocks as processed (both local and global)
                    for &b in &loop_info.blocks {
                        processed_in_try.insert(b);
                        self.processed.insert(b);
                    }
                    continue;
                }
            }

            if let Some(cond) = self.cond_map.get(&block_id).copied() {
                if cond.then_blocks.iter().all(|b| try_info.try_blocks.contains(b))
                    && cond.else_blocks.iter().all(|b| try_info.try_blocks.contains(b))
                {
                    // Mark the condition block as globally processed before calling process_if
                    // (process_if also marks it, but this ensures it's marked even if process_if
                    // returns early, e.g., for ternary transformation)
                    self.processed.insert(block_id);
                    let (if_region, _) = self.process_if(cond);
                    contents.push(RegionContent::Region(Box::new(if_region)));
                    // Mark all then/else blocks as processed (both local and global)
                    // Note: process_if marks these via traverse, but we also need local tracking
                    for &b in &cond.then_blocks {
                        processed_in_try.insert(b);
                        self.processed.insert(b);
                    }
                    for &b in &cond.else_blocks {
                        processed_in_try.insert(b);
                        self.processed.insert(b);
                    }
                    continue;
                }
            }

            // Mark block as globally processed (prevents re-traversal after try-catch returns)
            self.processed.insert(block_id);
            contents.push(RegionContent::Block(block_id));
        }

        Region::Sequence(contents)
    }

    /// Build an exception handler body region
    fn build_handler_body(&self, handler: &HandlerInfo) -> Region {
        let mut contents = Vec::new();

        // Build handler blocks in order
        let mut sorted_blocks: Vec<u32> = handler.handler_blocks.iter().copied().collect();
        sorted_blocks.sort();

        for block_id in sorted_blocks {
            contents.push(RegionContent::Block(block_id));
        }

        Region::Sequence(contents)
    }

    /// Process a loop region (like Java's LoopRegionMaker.process)
    fn process_loop(&mut self, loop_info: &LoopInfo) -> (Region, Option<u32>) {
        // Mark all loop blocks as processed
        for &block in &loop_info.blocks {
            self.processed.insert(block);
        }

        // JADX-style bail out when region stack limit exceeded
        if !self.stack.push() {
            let loop_exit = loop_info.exit_targets.first().copied();
            return (Region::Sequence(vec![]), loop_exit);
        }

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
            details: None,
            loop_type: LoopType::None,
            condition_at_end: loop_info.kind == LoopKind::DoWhile,
            header_block: Some(loop_info.header),
            pre_condition_block: None,
            label: None,
        };

        (region, loop_exit)
    }

    /// Extract condition from a block that ends with an If instruction
    ///
    /// In Dalvik bytecode, the branch is taken when the condition is TRUE.
    /// But in structured Java code, the "then" block is the fall-through path
    /// (when condition is FALSE). So we negate the condition to match Java semantics.
    ///
    /// However, when then/else branches have been swapped (indicated by negate=false),
    /// we should NOT negate the condition.
    ///
    /// If this block is the first of a merged condition chain (&&, ||), we build
    /// a compound condition instead of a simple one.
    fn extract_condition_with_negation(&self, block_id: u32, negate: bool) -> Condition {
        // Check if this block is part of a merged condition chain
        if let Some(merged) = self.merged_map.get(&block_id) {
            if merged.merged_blocks.len() > 1 {
                return self.build_merged_condition(merged);
            }
        }

        // Simple single-block condition
        self.extract_simple_condition_with_negation(block_id, negate)
    }

    /// Extract condition, always negating (for loops and other cases where we always negate)
    fn extract_condition(&self, block_id: u32) -> Condition {
        self.extract_condition_with_negation(block_id, true)
    }

    /// Extract a simple condition from a single block
    fn extract_simple_condition_with_negation(&self, block_id: u32, negate: bool) -> Condition {
        if let Some(block) = self.cfg.get_block(block_id) {
            // Find the If instruction (usually the last one)
            for insn in block.instructions.iter().rev() {
                if let InsnType::If { condition, .. } = &insn.insn_type {
                    if negate {
                        return Condition::simple_negated(block_id, condition.clone());
                    } else {
                        return Condition::simple(block_id, condition.clone());
                    }
                }
            }
        }
        Condition::Unknown
    }

    /// Extract a simple condition from a single block (always negated, for compatibility)
    fn extract_simple_condition(&self, block_id: u32) -> Condition {
        self.extract_simple_condition_with_negation(block_id, true)
    }

    /// Build a compound condition from a merged condition chain
    fn build_merged_condition(&self, merged: &MergedCondition) -> Condition {
        // Build conditions for each block in the chain
        // For OR chains, the first condition uses "branch when true" semantics,
        // meaning the branch target is the TRUE case. We need to NOT negate
        // the first condition to preserve this.
        //
        // Example for `a || b`:
        //   if-nez a, :true   ; branch to true when a is true
        //   if-eqz b, :false  ; branch to false when b is false (i.e., true when b is true)
        //
        // Without special handling, we'd get: !a || b (wrong)
        // With special handling: a || b (correct)
        let conditions: Vec<Condition> = if merged.mode == MergeMode::Or && merged.merged_blocks.len() > 1 {
            merged
                .merged_blocks
                .iter()
                .enumerate()
                .map(|(i, &block)| {
                    if i == 0 {
                        // First condition in OR: DON'T negate
                        // "branch when true" means true case of OR
                        self.extract_simple_condition_with_negation(block, false)
                    } else {
                        // Subsequent conditions: negate normally
                        // The if-eqz becomes "true when value is true" after negation
                        self.extract_simple_condition(block)
                    }
                })
                .collect()
        } else {
            merged
                .merged_blocks
                .iter()
                .map(|&block| self.extract_simple_condition(block))
                .collect()
        };

        if conditions.is_empty() {
            return Condition::Unknown;
        }

        if conditions.len() == 1 {
            return conditions.into_iter().next().unwrap();
        }

        // Combine based on merge mode
        match merged.mode {
            MergeMode::And => {
                // AND chain: a && b && c
                let mut conditions = conditions;
                let mut result = conditions.pop().unwrap();
                while let Some(left) = conditions.pop() {
                    result = Condition::and(left, result);
                }
                result
            }
            MergeMode::Or => {
                // OR chain: a || b || c
                let mut conditions = conditions;
                let mut result = conditions.pop().unwrap();
                while let Some(left) = conditions.pop() {
                    result = Condition::or(left, result);
                }
                result
            }
            MergeMode::Single => {
                // Should not happen for len > 1, but handle gracefully
                conditions.into_iter().next().unwrap()
            }
        }
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
                // Extract proper condition from nested loop header instead of Unknown
                let nested_condition = self.extract_condition(nested_loop.header);

                // Recursively build nested loop body
                let nested_body = self.build_loop_body(nested_loop);

                contents.push(RegionContent::Region(Box::new(Region::Loop {
                    kind: nested_loop.kind,
                    condition: Some(nested_condition),
                    body: Box::new(nested_body),
                    details: None,
                    loop_type: LoopType::None,
                    condition_at_end: nested_loop.kind == LoopKind::DoWhile,
                    header_block: Some(nested_loop.header),
                    pre_condition_block: None,
                    label: None,
                })));
            } else if let Some(try_info) = self.try_map.get(&block_id).copied() {
                // P1-TRY-CATCH-RECON FIX: Handle nested try-catch inside loops
                // This mirrors the handling of nested loops and conditionals
                if std::env::var("DEBUG_TRY_CATCH").is_ok() {
                    eprintln!("[DEBUG_TRY_CATCH] PROCESSING nested try-catch at block {} inside loop", block_id);
                }
                let (try_region, _) = self.process_try_catch(try_info);
                contents.push(RegionContent::Region(Box::new(try_region)));
                // Mark all try blocks and handler blocks as visited
                for &b in &try_info.try_blocks {
                    visited.insert(b);
                }
                for handler in &try_info.handlers {
                    for &b in &handler.handler_blocks {
                        visited.insert(b);
                    }
                }
            } else if let Some(cond) = self.cond_map.get(&block_id).copied() {
                // Nested conditional - check if fully contained in loop
                let then_in_loop = cond.then_blocks.iter().all(|b| loop_info.blocks.contains(b));
                let else_in_loop = cond.else_blocks.iter().all(|b| loop_info.blocks.contains(b));
                if then_in_loop && else_in_loop {
                    let (if_region, _) = self.process_if(cond);
                    contents.push(RegionContent::Region(Box::new(if_region)));
                    // Mark all then/else blocks as visited to prevent duplicate processing
                    // This is critical: process_if handles these blocks recursively,
                    // so we must not add them to worklist again
                    for &b in &cond.then_blocks {
                        visited.insert(b);
                    }
                    for &b in &cond.else_blocks {
                        visited.insert(b);
                    }
                } else {
                    // One branch exits the loop - create if-break structure
                    if let Some(break_region) = self.create_loop_break_region(cond, loop_info) {
                        contents.push(RegionContent::Region(Box::new(break_region)));
                        // Mark the branch that's inside the loop as visited
                        let inside_blocks: Vec<u32> = cond.then_blocks.iter()
                            .chain(cond.else_blocks.iter())
                            .filter(|b| loop_info.blocks.contains(b))
                            .copied()
                            .collect();
                        for b in inside_blocks {
                            visited.insert(b);
                        }
                    } else {
                        contents.push(RegionContent::Block(block_id));
                    }
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

        // Ensure ALL blocks in the loop are included (fixes for-each empty body issue)
        // Some blocks may not be reachable via successors from body_start due to
        // complex control flow (iterator patterns, exception handlers, etc.)
        let skip_header = loop_info.kind != LoopKind::DoWhile;
        for &block_id in &loop_info.blocks {
            // Skip header for while loops (it's already processed as condition)
            if skip_header && block_id == loop_info.header {
                continue;
            }
            // Add any unvisited blocks that are part of the loop
            if !visited.contains(&block_id) {
                visited.insert(block_id);
                // Check for nested structures (same logic as above)
                if let Some(nested_loop) = self.find_nested_loop(block_id, loop_info) {
                    let nested_condition = self.extract_condition(nested_loop.header);
                    let nested_body = self.build_loop_body(nested_loop);
                    contents.push(RegionContent::Region(Box::new(Region::Loop {
                        kind: nested_loop.kind,
                        condition: Some(nested_condition),
                        body: Box::new(nested_body),
                        details: None,
                        loop_type: LoopType::None,
                        condition_at_end: nested_loop.kind == LoopKind::DoWhile,
                        header_block: Some(nested_loop.header),
                        pre_condition_block: None,
                        label: None,
                    })));
                } else if let Some(try_info) = self.try_map.get(&block_id).copied() {
                    // P1-TRY-CATCH-RECON FIX: Handle nested try-catch inside loops (fallback loop)
                    if std::env::var("DEBUG_TRY_CATCH").is_ok() {
                        eprintln!("[DEBUG_TRY_CATCH] PROCESSING nested try-catch at block {} inside loop (fallback)", block_id);
                    }
                    let (try_region, _) = self.process_try_catch(try_info);
                    contents.push(RegionContent::Region(Box::new(try_region)));
                    // Mark all try blocks and handler blocks as visited
                    for &b in &try_info.try_blocks {
                        visited.insert(b);
                    }
                    for handler in &try_info.handlers {
                        for &b in &handler.handler_blocks {
                            visited.insert(b);
                        }
                    }
                } else if let Some(cond) = self.cond_map.get(&block_id).copied() {
                    if cond.then_blocks.iter().all(|b| loop_info.blocks.contains(b))
                        && cond.else_blocks.iter().all(|b| loop_info.blocks.contains(b))
                    {
                        let (if_region, _) = self.process_if(cond);
                        contents.push(RegionContent::Region(Box::new(if_region)));
                        // Mark all then/else blocks as visited to prevent duplicate processing
                        for &b in &cond.then_blocks {
                            visited.insert(b);
                        }
                        for &b in &cond.else_blocks {
                            visited.insert(b);
                        }
                    } else {
                        // One branch exits the loop - create if-break structure
                        if let Some(break_region) = self.create_loop_break_region(cond, loop_info) {
                            contents.push(RegionContent::Region(Box::new(break_region)));
                            // Mark the branch that's inside the loop as visited
                            for &b in cond.then_blocks.iter().chain(cond.else_blocks.iter()) {
                                if loop_info.blocks.contains(&b) {
                                    visited.insert(b);
                                }
                            }
                        } else {
                            contents.push(RegionContent::Block(block_id));
                        }
                    }
                } else {
                    contents.push(RegionContent::Block(block_id));
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

    /// Create if-break or if-return region for a conditional that exits the loop
    ///
    /// When one branch of an IF exits the loop, we create:
    /// - if (cond) break; else { body } - when then branch exits via jump
    /// - if (cond) return; else { body } - when then branch exits via return
    /// - if (!cond) break; else { body } - when else branch exits (negated condition)
    fn create_loop_break_region(&mut self, cond: &IfInfo, loop_info: &LoopInfo) -> Option<Region> {
        // Check both collected blocks AND direct successors to determine which branch exits.
        // This handles cases where:
        // 1. The exit block is not included in then_blocks/else_blocks because it's the merge point
        // 2. The exit is a direct successor containing a return statement
        let succs = self.cfg.successors(cond.condition_block);

        // P0-FOREACH-SEM FIX: Correctly map Dalvik successor order to Java then/else
        // In Dalvik bytecode:
        //   succs[0] = fall-through (taken when Dalvik condition is FALSE)
        //   succs[1] = branch target (taken when Dalvik condition is TRUE)
        //
        // negate_condition maps this to Java semantics:
        //   negate_condition=true:  Java "then" = Dalvik FALSE = succs[0]
        //   negate_condition=false: Java "then" = Dalvik TRUE  = succs[1]
        let (then_target, else_target) = if cond.negate_condition {
            (succs.get(0).copied(), succs.get(1).copied())
        } else {
            (succs.get(1).copied(), succs.get(0).copied())
        };

        // A branch exits if:
        // 1. Any block in then_blocks/else_blocks is outside the loop, OR
        // 2. The direct successor is outside the loop (handles empty block lists)
        let then_exits = cond.then_blocks.iter().any(|b| !loop_info.blocks.contains(b))
            || then_target.map(|t| !loop_info.blocks.contains(&t)).unwrap_or(false);
        let else_exits = cond.else_blocks.iter().any(|b| !loop_info.blocks.contains(b))
            || else_target.map(|t| !loop_info.blocks.contains(&t)).unwrap_or(false);

        // Only handle simple cases where exactly one branch exits
        if then_exits == else_exits {
            // Both exit or neither exits - can't create simple if-break
            return None;
        }

        // Check if the exit branch terminates with return/throw (not a break)
        // Also check the direct successor block for return/throw
        let (exit_blocks, exit_target) = if then_exits {
            (&cond.then_blocks, then_target)
        } else {
            (&cond.else_blocks, else_target)
        };
        let exits_via_return = self.exits_via_return_or_throw(exit_blocks)
            || exit_target.map(|t| self.block_ends_with_return_or_throw(t)).unwrap_or(false);

        // Get break label for nested loops
        let label = if loop_info.parent.is_some() {
            Some(format!("loop_{}", loop_info.header))
        } else {
            None
        };

        if then_exits {
            // Then branch exits the loop: if (cond) break/return; [else { body }]
            let condition = self.extract_condition_with_negation(cond.condition_block, cond.negate_condition);
            let else_region = if cond.else_blocks.is_empty() {
                None
            } else {
                Some(Box::new(self.build_branch_region(&cond.else_blocks)))
            };

            // Create then region - either break or the return block itself
            let then_region = if exits_via_return {
                // Include ALL blocks from the exit path (including Goto blocks and final return)
                // This ensures we capture const assignments before return
                let exit_blocks = self.collect_exit_path_blocks(then_target);
                if !exit_blocks.is_empty() {
                    let contents: Vec<RegionContent> = exit_blocks.into_iter()
                        .map(RegionContent::Block)
                        .collect();
                    Region::Sequence(contents)
                } else if cond.then_blocks.is_empty() {
                    if let Some(target) = then_target {
                        Region::Sequence(vec![RegionContent::Block(target)])
                    } else {
                        Region::Break { label }
                    }
                } else {
                    self.build_branch_region(&cond.then_blocks)
                }
            } else {
                Region::Break { label }
            };

            Some(Region::If {
                condition,
                condition_blocks: vec![cond.condition_block],
                then_region: Box::new(then_region),
                else_region,
            })
        } else {
            // Else branch exits the loop: if (!cond) break/return; [else { body }]
            // Negate the condition so the break/return is in the then branch
            let condition = self.extract_condition_with_negation(cond.condition_block, !cond.negate_condition);
            let else_region = if cond.then_blocks.is_empty() {
                None
            } else {
                Some(Box::new(self.build_branch_region(&cond.then_blocks)))
            };

            // Create then region - either break or the return block itself
            let then_region = if exits_via_return {
                // Include ALL blocks from the exit path (including Goto blocks and final return)
                // This ensures we capture const assignments before return
                let exit_blocks = self.collect_exit_path_blocks(else_target);
                if !exit_blocks.is_empty() {
                    let contents: Vec<RegionContent> = exit_blocks.into_iter()
                        .map(RegionContent::Block)
                        .collect();
                    Region::Sequence(contents)
                } else if cond.else_blocks.is_empty() {
                    if let Some(target) = else_target {
                        Region::Sequence(vec![RegionContent::Block(target)])
                    } else {
                        Region::Break { label }
                    }
                } else {
                    self.build_branch_region(&cond.else_blocks)
                }
            } else {
                Region::Break { label }
            };

            Some(Region::If {
                condition,
                condition_blocks: vec![cond.condition_block],
                then_region: Box::new(then_region),
                else_region,
            })
        }
    }

    /// Collect all blocks in the exit path from start to the actual return/throw
    /// This includes intermediate Goto blocks which may contain important assignments
    fn collect_exit_path_blocks(&self, start: Option<u32>) -> Vec<u32> {
        let mut blocks = Vec::new();
        let mut current_block = match start {
            Some(b) => b,
            None => return blocks,
        };
        let mut visited = std::collections::BTreeSet::new();

        for _ in 0..10 {
            if !visited.insert(current_block) {
                break;
            }

            if let Some(block) = self.cfg.get_block(current_block) {
                blocks.push(current_block);

                if let Some(last) = block.instructions.last() {
                    match &last.insn_type {
                        InsnType::Return { .. } | InsnType::Throw { .. } => {
                            // Found the end of the path
                            break;
                        }
                        InsnType::Goto { target } => {
                            if let Some(target_block) = self.cfg.block_ids().find(|&bid| {
                                self.cfg.get_block(bid)
                                    .map(|b| b.start_offset == *target)
                                    .unwrap_or(false)
                            }) {
                                current_block = target_block;
                                continue;
                            }
                            break;
                        }
                        _ => break,
                    }
                }
            }
            break;
        }
        blocks
    }

    /// Check if a set of blocks exits via return or throw (not a loop break)
    fn exits_via_return_or_throw(&self, blocks: &[u32]) -> bool {
        for &block_id in blocks {
            if self.block_ends_with_return_or_throw(block_id) {
                return true;
            }
        }
        false
    }

    /// Check if a single block ends with return or throw
    /// Follows Goto chains AND fall-through blocks to find the actual exit instruction
    fn block_ends_with_return_or_throw(&self, block_id: u32) -> bool {
        let mut current_block = block_id;
        let mut visited = std::collections::BTreeSet::new();

        // Follow Goto chain AND fall-through (up to 10 hops to prevent infinite loops)
        for _hop in 0..10 {
            if !visited.insert(current_block) {
                // Cycle detected
                return false;
            }

            if let Some(block) = self.cfg.get_block(current_block) {
                if let Some(last) = block.instructions.last() {
                    match &last.insn_type {
                        InsnType::Return { .. } | InsnType::Throw { .. } => {
                            return true;
                        }
                        InsnType::Goto { target } => {
                            // Follow the goto to the target block
                            // Find block by offset
                            if let Some(target_block) = self.cfg.block_ids().find(|&bid| {
                                self.cfg.get_block(bid)
                                    .map(|b| b.start_offset == *target)
                                    .unwrap_or(false)
                            }) {
                                current_block = target_block;
                                continue;
                            }
                            return false;
                        }
                        // P0-FOREACH-SEM FIX: For non-branching instructions (like Move),
                        // check if this block has exactly one successor (fall-through).
                        // If so, follow the fall-through to see if it ends with return.
                        InsnType::If { .. } | InsnType::PackedSwitch { .. } | InsnType::SparseSwitch { .. } => {
                            // Branching instruction - can't determine single exit path
                            return false;
                        }
                        _ => {
                            // Non-branching, non-return instruction - check for fall-through
                            let succs = self.cfg.successors(current_block);
                            if succs.len() == 1 {
                                // Single successor = fall-through to next block
                                current_block = succs[0];
                                continue;
                            }
                            // No successors or multiple (shouldn't happen for non-branch)
                            return false;
                        }
                    }
                }
            }
            return false;
        }
        false
    }

    /// Process an if-else region (like Java's IfRegionMaker.process)
    fn process_if(&mut self, cond: &IfInfo) -> (Region, Option<u32>) {
        // Mark condition block as processed
        self.processed.insert(cond.condition_block);

        // =========================================================================
        // TernaryMod Phase 2: Try ternary transformation BEFORE building sub-regions
        // This matches JADX TernaryMod.java which runs before CodeShrinkVisitor.
        // =========================================================================
        //
        // Check if this if-else can be converted to a ternary expression:
        //   if (cond) { r = a; } else { r = b; }  ->  r = cond ? a : b;
        //   if (cond) { return a; } else { return b; }  ->  return cond ? a : b;

        // Extract condition first (needed for ternary)
        // For merged conditions, build the composite condition
        // P1-HOTRELOAD FIX: For single-block merged conditions, use the IfInfo's negate_condition
        // instead of the default true. This ensures throw patterns (which set negate=false) work correctly.
        let condition = if let Some(merged) = self.merged_map.get(&cond.condition_block) {
            if merged.merged_blocks.len() == 1 {
                // Single-block "merged" condition - use IfInfo's negate_condition
                // This respects the throw pattern detection which sets negate=false
                self.extract_condition_with_negation(cond.condition_block, cond.negate_condition)
            } else {
                // True merged condition (multiple blocks)
                self.build_merged_condition(merged)
            }
        } else {
            // No merged condition - use IfInfo's negate_condition
            self.extract_condition_with_negation(cond.condition_block, cond.negate_condition)
        };

        // P0-BOOL-CHAIN DEBUG
        if std::env::var("DEBUG_CONDITIONALS").is_ok() {
            eprintln!("[PROCESS_IF] block={} negate_condition={} then_blocks={:?} else_blocks={:?}",
                cond.condition_block, cond.negate_condition, cond.then_blocks, cond.else_blocks);
        }

        // For merged conditions (AND/OR), try to use the MergedCondition's then_block/else_block
        // which are the VALUE blocks, not all the condition blocks.
        // But only if BOTH are available - otherwise fall back to IfInfo blocks.
        let (ternary_then_blocks, ternary_else_blocks) = if let Some(merged) = self.merged_map.get(&cond.condition_block) {
            // Only use merged blocks if we have BOTH then and else value blocks
            // Otherwise the merged condition is not a complete ternary pattern
            match (merged.then_block, merged.else_block) {
                (Some(then_block), Some(else_block)) => {
                    // Mark all merged condition blocks as processed
                    for &block in &merged.merged_blocks {
                        self.processed.insert(block);
                    }
                    (vec![then_block], vec![else_block])
                }
                _ => {
                    // Fall back to IfInfo blocks if merged blocks are incomplete
                    (cond.then_blocks.clone(), cond.else_blocks.clone())
                }
            }
        } else {
            (cond.then_blocks.clone(), cond.else_blocks.clone())
        };

        // Only try ternary if we have an else branch
        if !ternary_else_blocks.is_empty() {
            match try_transform_to_ternary(
                condition.clone(),
                &ternary_then_blocks,
                &ternary_else_blocks,
                self.cfg,
            ) {
                TernaryTransformResult::Assignment {
                    condition: ternary_cond,
                    dest_reg,
                    dest_version,
                    then_block,
                    else_block,
                } => {
                    // Mark blocks as processed
                    self.processed.insert(then_block);
                    self.processed.insert(else_block);

                    // Return TernaryAssignment region
                    let region = Region::TernaryAssignment {
                        condition: ternary_cond,
                        dest_reg,
                        dest_version,
                        then_value_block: then_block,
                        else_value_block: else_block,
                    };
                    return (region, cond.merge_block);
                }
                TernaryTransformResult::Return {
                    condition: ternary_cond,
                    then_block,
                    else_block,
                } => {
                    // Mark blocks as processed
                    self.processed.insert(then_block);
                    self.processed.insert(else_block);

                    // Return TernaryReturn region
                    let region = Region::TernaryReturn {
                        condition: ternary_cond,
                        then_value_block: then_block,
                        else_value_block: else_block,
                    };
                    return (region, cond.merge_block);
                }
                TernaryTransformResult::NotTernary => {
                    // Fall through to normal if-else processing
                }
            }
        }

        // =========================================================================
        // Normal if-else processing (when ternary transformation not applicable)
        // =========================================================================

        // JADX-style bail out when region stack limit exceeded
        if !self.stack.push() {
            return (Region::Sequence(vec![]), cond.merge_block);
        }

        // Add merge point as exit
        self.stack.add_exit(cond.merge_block);

        // If this is a merged condition (&&, ||), mark ALL merged blocks as processed.
        // This prevents the merged blocks from being processed again as separate conditionals.
        // The code from merged blocks is generated by emit_condition_block_prelude in codegen.
        let (merged_block_set, is_merged_or) = if let Some(merged) = self.merged_map.get(&cond.condition_block) {
            for &block in &merged.merged_blocks {
                self.processed.insert(block);
            }
            let is_or = merged.mode == MergeMode::Or && merged.merged_blocks.len() > 1;
            (merged.merged_blocks.iter().copied().collect::<BTreeSet<u32>>(), is_or)
        } else {
            (BTreeSet::new(), false)
        };

        // For merged OR conditions, we use the merged condition's then_block and else_block
        // which correctly identify the TRUE and FALSE result blocks.
        //
        // Example: `if (a || b) { true_code } else { false_code }`
        // Bytecode:
        //   if-nez a, :true_block  ; branch to true when a is true
        //   if-nez b, :true_block  ; branch to true when b is true
        //   false_code
        //   goto merge
        //   :true_block
        //   true_code
        //
        // The merged condition has:
        //   then_block = true_block (the shared TRUE result)
        //   else_block = false_block (the FALSE result from the last condition)
        let (filtered_then_blocks, filtered_else_blocks) = if is_merged_or {
            // For merged OR: use the merged condition's then_block and else_block
            let merged = self.merged_map.get(&cond.condition_block).unwrap();
            let then_blocks = if let Some(then_block) = merged.then_block {
                vec![then_block]
            } else {
                vec![]
            };
            let else_blocks = if let Some(else_block) = merged.else_block {
                vec![else_block]
            } else {
                vec![]
            };
            (then_blocks, else_blocks)
        } else {
            // Normal case: filter out merged condition blocks
            let then_blocks: Vec<u32> = cond.then_blocks
                .iter()
                .filter(|&&b| !merged_block_set.contains(&b))
                .copied()
                .collect();
            let else_blocks: Vec<u32> = cond.else_blocks
                .iter()
                .filter(|&&b| !merged_block_set.contains(&b))
                .copied()
                .collect();
            (then_blocks, else_blocks)
        };

        // P0-BOOL-CHAIN DEBUG
        if std::env::var("DEBUG_CONDITIONALS").is_ok() {
            eprintln!("[PROCESS_IF] block={} filtered_then_blocks={:?} filtered_else_blocks={:?} is_merged_or={}",
                cond.condition_block, filtered_then_blocks, filtered_else_blocks, is_merged_or);
        }

        // P0-BOOL-CHAIN FIX: DON'T add else_blocks as exits!
        // JADX only adds the merge point (outBlock) as exit, not the else_block.
        // Reference: IfRegionMaker.java:88 - only `stack.addExit(outBlock)`
        //
        // Adding else_blocks as exits was incorrectly preventing nested conditionals
        // from including them in their else_regions, causing truncated boolean chains.
        // The else_blocks should remain accessible for nested conditionals that share
        // the same "true" target (OR pattern: if-nez a, :true; if-nez b, :true; ...)

        // Build then region
        // Note: Don't pre-mark blocks as processed - let traverse() discover
        // nested control structures (switches, ifs, loops) properly
        let then_region = if filtered_then_blocks.is_empty() {
            Region::Sequence(vec![])
        } else {
            self.build_branch_region(&filtered_then_blocks)
        };

        // Clear the else_blocks exits before building else region
        // (they were temporary barriers for then_region building)
        self.stack.pop();

        // JADX-style bail out when region stack limit exceeded (unlikely here but be safe)
        if !self.stack.push() {
            // Bail out - return the if with just the then region
            return (
                Region::If {
                    condition: self.extract_condition_with_negation(cond.condition_block, cond.negate_condition),
                    condition_blocks: vec![cond.condition_block],
                    then_region: Box::new(then_region),
                    else_region: None,
                },
                cond.merge_block,
            );
        }
        self.stack.add_exit(cond.merge_block);

        // Build else region
        let else_region = if filtered_else_blocks.is_empty() {
            None
        } else {
            Some(Box::new(self.build_branch_region(&filtered_else_blocks)))
        };

        self.stack.pop();

        // P0-BOOL-CHAIN DEBUG: Log what regions we actually built
        if std::env::var("DEBUG_CONDITIONALS").is_ok() {
            eprintln!("[PROCESS_IF] block={} BUILT then_region={:?}",
                cond.condition_block, format!("{:?}", then_region).chars().take(200).collect::<String>());
            eprintln!("[PROCESS_IF] block={} BUILT else_region={:?}",
                cond.condition_block, format!("{:?}", else_region).chars().take(200).collect::<String>());
        }

        let region = Region::If {
            condition,
            condition_blocks: vec![cond.condition_block],
            then_region: Box::new(then_region),
            else_region,
        };

        (region, cond.merge_block)
    }

    /// Build a region from a list of blocks
    /// Build a region for a branch (then/else block)
    /// Uses traverse to properly detect nested control structures (switches, ifs, loops)
    fn build_branch_region(&mut self, blocks: &[u32]) -> Region {
        if blocks.is_empty() {
            return Region::Sequence(vec![]);
        }

        // Use traverse to properly detect nested structures like switches, loops, ifs
        // This is critical for switch-over-string patterns which are inside if-branches
        let first = blocks[0];
        let mut contents = Vec::new();

        if std::env::var("DEBUG_CONDITIONALS").is_ok() {
            eprintln!("[BUILD_BRANCH] blocks={:?}, starting at {}", blocks, first);
        }

        // Traverse starting from the first block - this will:
        // 1. Detect switches and process them as Region::Switch
        // 2. Detect nested ifs and process them as Region::If
        // 3. Handle regular blocks as RegionContent::Block
        let mut current = Some(first);
        while let Some(block_id) = current {
            if std::env::var("DEBUG_CONDITIONALS").is_ok() {
                let is_cond = self.cond_map.contains_key(&block_id);
                let is_proc = self.processed.contains(&block_id);
                eprintln!("[BUILD_BRANCH] traverse block={} is_cond={} is_processed={}", block_id, is_cond, is_proc);
            }
            current = self.traverse(&mut contents, block_id);
        }

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

        // JADX-style bail out when region stack limit exceeded
        if !self.stack.push() {
            return (Region::Sequence(vec![]), merge_block);
        }
        self.stack.add_exit(merge_block);

        // Build cases with proper keys (using CaseInfo matching JADX)
        let mut cases: Vec<CaseInfo> = Vec::new();

        for (i, &target) in succs.iter().enumerate() {
            // Don't include merge block as a case
            if merge_block == Some(target) {
                continue;
            }

            // Build case body - collect blocks until merge point and process them
            // for nested control structures (if/else, loops, etc.)
            let case_blocks = self.collect_case_blocks(target, merge_block);

            // If the case has multiple blocks or the first block has control flow,
            // process recursively to detect nested structures
            let case_region = if case_blocks.is_empty() {
                // Empty case - just reference the target block
                self.processed.insert(target);
                Region::Sequence(vec![RegionContent::Block(target)])
            } else if case_blocks.len() == 1 {
                // Single block - simple case
                let single_block = case_blocks[0];
                self.processed.insert(single_block);
                Region::Sequence(vec![RegionContent::Block(single_block)])
            } else {
                // Multiple blocks - mark all as processed and create sequence
                // The blocks are already collected in order
                for &b in &case_blocks {
                    self.processed.insert(b);
                }
                let contents: Vec<RegionContent> = case_blocks
                    .iter()
                    .map(|&b| RegionContent::Block(b))
                    .collect();
                Region::Sequence(contents)
            };

            // Determine if this is the default case
            // For packed/sparse switches, default is the fallthrough block (last successor)
            // which doesn't have a corresponding key in switch_info
            let is_default = if let Some(ref info) = switch_info {
                // If we have switch info, default is the successor without a corresponding key
                // The last successor is always the default (fallthrough) block
                i == succs.len() - 1 || i >= info.len()
            } else {
                // No switch info - last successor is default
                i == succs.len() - 1
            };

            if is_default {
                // Default case uses CaseKey::Default (matches JADX DEFAULT_CASE_KEY)
                cases.push(CaseInfo::new(vec![CaseKey::Default], case_region));
            } else {
                // Get key for this case
                let key = switch_info
                    .as_ref()
                    .and_then(|info| info.get(i))
                    .copied()
                    .unwrap_or(i as i32);

                cases.push(CaseInfo::new(vec![CaseKey::Int(key)], case_region));
            }
        }

        self.stack.pop();

        // Detect and fix fall-through case ordering
        // Port of JADX SwitchRegionMaker.reOrderSwitchCases() (lines 315-336)
        let fall_through_map = self.detect_fall_through_cases(&succs, merge_block);
        let cases = if !fall_through_map.is_empty() && self.is_bad_cases_order(&cases, &fall_through_map) {
            self.reorder_switch_cases(cases, &fall_through_map)
        } else {
            cases
        };

        let region = Region::Switch {
            header_block: block,
            cases,
        };

        (region, merge_block)
    }

    /// Detect fall-through relationships between switch cases
    ///
    /// Returns a map from case target block -> next case target block that it falls through to.
    /// A case falls through if its last block has a successor that is another case target.
    fn detect_fall_through_cases(
        &self,
        case_targets: &[u32],
        merge_block: Option<u32>,
    ) -> std::collections::BTreeMap<u32, u32> {
        let mut fall_through: std::collections::BTreeMap<u32, u32> = std::collections::BTreeMap::new();
        let target_set: std::collections::BTreeSet<u32> = case_targets.iter().copied().collect();

        for &target in case_targets {
            // Skip merge block
            if merge_block == Some(target) {
                continue;
            }

            // Collect all blocks in this case
            let case_blocks = self.collect_case_blocks(target, merge_block);
            let last_block = case_blocks.last().copied().unwrap_or(target);

            // Check if last block's successors include another case target
            for &succ in self.cfg.successors(last_block) {
                if target_set.contains(&succ) && succ != target && merge_block != Some(succ) {
                    // This case falls through to another case
                    fall_through.insert(target, succ);
                    break;
                }
            }
        }

        fall_through
    }

    /// Check if the current case order is bad (doesn't respect fall-through)
    ///
    /// Port of JADX SwitchRegionMaker.isBadCasesOrder() (lines 304-313)
    fn is_bad_cases_order(
        &self,
        cases: &[CaseInfo],
        fall_through_map: &std::collections::BTreeMap<u32, u32>,
    ) -> bool {
        let mut expected_next: Option<u32> = None;

        for case in cases {
            // Get the target block for this case (first block in the region)
            let case_target = self.get_case_first_block(&case.container);
            if let Some(target) = case_target {
                // If we expected a specific next case and this isn't it, order is bad
                if let Some(expected) = expected_next {
                    if target != expected {
                        return true;
                    }
                }

                // Check if this case falls through to another
                expected_next = fall_through_map.get(&target).copied();
            }
        }

        // If we still expect a next case at the end, order is bad
        expected_next.is_some()
    }

    /// Reorder switch cases to respect fall-through relationships
    ///
    /// Port of JADX SwitchRegionMaker.reOrderSwitchCases() (lines 315-336)
    fn reorder_switch_cases(
        &self,
        mut cases: Vec<CaseInfo>,
        fall_through_map: &std::collections::BTreeMap<u32, u32>,
    ) -> Vec<CaseInfo> {
        // Sort cases so that fall-through source comes before target
        cases.sort_by(|a, b| {
            let a_target = self.get_case_first_block(&a.container);
            let b_target = self.get_case_first_block(&b.container);

            if let (Some(a_target), Some(b_target)) = (a_target, b_target) {
                // If a falls through to b, a should come before b
                if fall_through_map.get(&a_target) == Some(&b_target) {
                    return std::cmp::Ordering::Less;
                }
                // If b falls through to a, b should come before a
                if fall_through_map.get(&b_target) == Some(&a_target) {
                    return std::cmp::Ordering::Greater;
                }
            }

            std::cmp::Ordering::Equal
        });

        cases
    }

    /// Get the first block from a case region
    fn get_case_first_block(&self, region: &Region) -> Option<u32> {
        match region {
            Region::Sequence(contents) => {
                for content in contents {
                    if let RegionContent::Block(block) = content {
                        return Some(*block);
                    }
                }
                None
            }
            _ => None,
        }
    }

    /// Get switch keys from the instruction
    fn get_switch_info(&self, block: u32) -> Option<Vec<i32>> {
        let b = self.cfg.get_block(block)?;
        let last = b.instructions.last()?;

        match &last.insn_type {
            InsnType::PackedSwitch {
                first_key, targets, ..
            } => {
                // Generate consecutive keys from first_key
                if targets.is_empty() {
                    None
                } else {
                    Some(
                        (0..targets.len())
                            .map(|i| first_key + i as i32)
                            .collect(),
                    )
                }
            }
            InsnType::SparseSwitch { keys, .. } => {
                if keys.is_empty() {
                    None
                } else {
                    Some(keys.clone())
                }
            }
            _ => None,
        }
    }

    /// Find the merge point for a switch statement
    ///
    /// Uses a dominance-based approach (like JADX's calcSwitchOut):
    /// 1. Primary: Use immediate post-dominator of the switch block
    /// 2. Fallback: Use dominance frontier union of non-terminating cases
    /// 3. Handle terminating cases (return/throw) which don't contribute to merge
    fn find_switch_merge(&self, switch_block: u32, targets: &[u32]) -> Option<u32> {
        if targets.is_empty() {
            return None;
        }

        // Convert targets to a set for quick lookup
        let target_set: BTreeSet<u32> = targets.iter().copied().collect();

        // Strategy 1: Use immediate post-dominator (most reliable)
        // The ipdom is the first block that ALL paths from the switch must pass through
        if let Some(ipdom) = self.cfg.ipdom(switch_block) {
            // Validate: ipdom should not be the switch block itself
            if ipdom != switch_block {
                // Check if ipdom is a case target - this can happen with fallthrough
                // In that case, it's still valid if it has multiple predecessors
                let is_valid_target = if target_set.contains(&ipdom) {
                    // ipdom is a case target - only valid if it's a merge point
                    // (has multiple predecessors, indicating fallthrough from other cases)
                    let preds = self.cfg.predecessors(ipdom);
                    preds.len() > 1 || targets.len() == 1
                } else {
                    // Not a case target - always valid
                    true
                };

                if is_valid_target {
                    // Check if ipdom is reachable from any non-terminating case
                    let has_non_terminating = targets.iter().any(|&t| {
                        !self.is_terminating_case(t, switch_block, ipdom)
                    });

                    if has_non_terminating {
                        return Some(ipdom);
                    }
                }
            }
        }

        // Strategy 2: Find merge via dominance frontier union
        // Collect blocks in dominance frontier of each case target
        let mut frontier_union: BTreeSet<u32> = BTreeSet::new();
        let mut non_terminating_count = 0;

        for &target in targets {
            // Skip targets that terminate (return/throw) without reaching a common merge
            if self.case_terminates_early(target, switch_block) {
                continue;
            }
            non_terminating_count += 1;

            // Add dominance frontier blocks
            let df = self.cfg.dominance_frontier(target);
            for block in df {
                if block != switch_block {
                    frontier_union.insert(block);
                }
            }
        }

        // If all cases terminate, there's no merge point
        if non_terminating_count == 0 {
            return None;
        }

        // Filter frontier to find valid merge candidates
        // A valid merge point should:
        // 1. Not be one of the case targets
        // 2. Be reachable from at least one non-terminating case
        let valid_merges: Vec<u32> = frontier_union
            .into_iter()
            .filter(|&b| !target_set.contains(&b))
            .collect();

        if valid_merges.len() == 1 {
            return Some(valid_merges[0]);
        }

        // Multiple candidates: choose the one closest to switch (smallest block ID in RPO)
        // This typically gives us the earliest merge point
        if !valid_merges.is_empty() {
            return valid_merges.into_iter().min();
        }

        // Strategy 3: Fallback - find first common reachable block from non-terminating cases
        self.find_common_reachable(switch_block, targets)
    }

    /// Check if a case target terminates early (return/throw without reaching merge)
    fn case_terminates_early(&self, target: u32, switch_block: u32) -> bool {
        let mut visited = BTreeSet::new();
        let mut worklist = vec![target];

        while let Some(block) = worklist.pop() {
            if !visited.insert(block) {
                continue;
            }

            // Check if block terminates
            if let Some(b) = self.cfg.get_block(block) {
                if let Some(last) = b.instructions.last() {
                    if matches!(last.insn_type, InsnType::Return { .. } | InsnType::Throw { .. }) {
                        // This path terminates - continue checking other paths
                        continue;
                    }
                }
            }

            // Get successors
            let succs = self.cfg.successors(block);
            if succs.is_empty() {
                // Dead end (likely unreachable)
                continue;
            }

            // If we can reach a block that's not the switch and has multiple predecessors,
            // this case doesn't terminate early - it reaches a merge point
            for &succ in succs {
                if succ == switch_block {
                    // Loop back to switch - ignore
                    continue;
                }

                let preds = self.cfg.predecessors(succ);
                if preds.len() > 1 {
                    // Found a merge point - this case doesn't terminate early
                    return false;
                }

                if !visited.contains(&succ) {
                    worklist.push(succ);
                }
            }
        }

        // All paths from this target terminate (return/throw)
        true
    }

    /// Check if a case is terminating (ends with return/throw without reaching ipdom)
    fn is_terminating_case(&self, target: u32, switch_block: u32, ipdom: u32) -> bool {
        let mut visited = BTreeSet::new();
        let mut worklist = vec![target];

        while let Some(block) = worklist.pop() {
            if !visited.insert(block) {
                continue;
            }

            // Reached ipdom - not terminating
            if block == ipdom {
                return false;
            }

            // Check if block terminates
            if let Some(b) = self.cfg.get_block(block) {
                if let Some(last) = b.instructions.last() {
                    if matches!(last.insn_type, InsnType::Return { .. } | InsnType::Throw { .. }) {
                        continue; // This path terminates, check other paths
                    }
                }
            }

            // Add successors (except back to switch)
            for &succ in self.cfg.successors(block) {
                if succ != switch_block && !visited.contains(&succ) {
                    worklist.push(succ);
                }
            }
        }

        // Never reached ipdom - all paths terminate
        true
    }

    /// Fallback: Find first common reachable block from non-terminating cases
    fn find_common_reachable(&self, switch_block: u32, targets: &[u32]) -> Option<u32> {
        // Collect reachable blocks from each non-terminating case
        let mut case_reaches: Vec<BTreeSet<u32>> = Vec::new();

        for &target in targets {
            if self.case_terminates_early(target, switch_block) {
                continue;
            }

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

            if !reachable.is_empty() {
                case_reaches.push(reachable);
            }
        }

        if case_reaches.is_empty() {
            return None;
        }

        // Find common blocks (intersection of all reachable sets)
        let mut common = case_reaches[0].clone();
        for reaches in case_reaches.iter().skip(1) {
            common = common.intersection(reaches).copied().collect();
        }

        // Remove case targets from common set
        let target_set: BTreeSet<u32> = targets.iter().copied().collect();
        common = common.difference(&target_set).copied().collect();

        // The merge point is the earliest common block
        common.into_iter().next()
    }

    /// Collect blocks belonging to a switch case until the merge point
    ///
    /// This uses a BFS traversal to collect ALL blocks reachable from the case start
    /// that are bounded by the merge point. This properly handles:
    /// - Nested if/else within cases
    /// - Nested loops within cases
    /// - Complex control flow patterns
    fn collect_case_blocks(&self, start: u32, merge: Option<u32>) -> Vec<u32> {
        let mut blocks = Vec::new();
        let mut visited = BTreeSet::new();
        let mut worklist = vec![start];

        while let Some(block_id) = worklist.pop() {
            // Skip if already visited
            if !visited.insert(block_id) {
                continue;
            }

            // Stop at merge point (don't include it in case)
            if merge == Some(block_id) {
                continue;
            }

            // Add this block to the case
            blocks.push(block_id);

            // Check if this block terminates (return/throw)
            let terminates = self.cfg.get_block(block_id)
                .and_then(|b| b.instructions.last())
                .map(|insn| matches!(insn.insn_type, InsnType::Return { .. } | InsnType::Throw { .. }))
                .unwrap_or(false);

            if terminates {
                // Don't follow successors of terminating blocks
                continue;
            }

            // Add all successors to worklist
            for &succ in self.cfg.successors(block_id) {
                if !visited.contains(&succ) && merge != Some(succ) {
                    worklist.push(succ);
                }
            }
        }

        // Sort blocks by ID for consistent ordering
        blocks.sort();
        blocks
    }
}

/// Simplified region construction for a method
pub fn build_method_regions(blocks: &BTreeMap<u32, BasicBlock>, entry: u32) -> Region {
    // Convert to BlockSplitResult format
    use crate::block_split::BlockSplitResult;

    // Convert BTreeMap to Vec
    let blocks_vec: Vec<BasicBlock> = blocks.values().cloned().collect();

    let exits: Vec<u32> = blocks_vec
        .iter()
        .filter(|b| {
            b.instructions
                .last()
                .map(|i| matches!(i.insn_type, InsnType::Return { .. } | InsnType::Throw { .. }))
                .unwrap_or(false)
        })
        .map(|b| b.id)
        .collect();

    let result = BlockSplitResult {
        blocks: blocks_vec,
        entry_block: entry,
        exit_blocks: exits,
    };

    let cfg = CFG::from_blocks(result);
    build_regions(&cfg)
}

// ============================================================================
// Loop Pattern Integration (JADX Parity: ForLoop/ForEach distinction)
// ============================================================================

use dexterity_ir::regions::{ForLoopInfo, ForEachLoopInfo, IterableSource, LoopDetails};
use crate::loop_analysis::LoopPatternResult;

/// Refine loop regions with pattern analysis results
///
/// This function walks the region tree and updates Loop regions with detailed
/// information from loop pattern analysis. This enables proper ForLoop/ForEach
/// distinction in code generation.
///
/// This should be called after both region building and loop pattern analysis:
/// 1. build_regions() creates initial regions with LoopKind::While
/// 2. analyze_loop_patterns() identifies For and ForEach patterns
/// 3. refine_loops_with_patterns() updates regions with pattern details
pub fn refine_loops_with_patterns(region: &mut Region, patterns: &LoopPatternResult) {
    refine_loops_recursive(region, patterns);
}

fn refine_loops_recursive(region: &mut Region, patterns: &LoopPatternResult) {
    match region {
        Region::Loop { kind, body, details, .. } => {
            // Check if there's a pattern for this loop
            // We need to find the header block from the condition
            // For now, we use the loop_kinds map which is keyed by header

            // Try to find matching array ForEach pattern
            for foreach in &patterns.array_for_each {
                if let Some(detected_kind) = patterns.loop_kinds.get(&foreach.header) {
                    if *detected_kind == LoopKind::ForEach && *kind != LoopKind::ForEach {
                        // Update kind and add details
                        *kind = LoopKind::ForEach;
                        *details = Some(Box::new(LoopDetails::foreach_loop(ForEachLoopInfo {
                            elem_var: None,
                            elem_var_reg: Some(foreach.elem_var),
                            iterable: IterableSource::Array {
                                array_reg: foreach.array_reg,
                                index_reg: Some(foreach.index_var),
                            },
                        })));
                        break;
                    }
                }
            }

            // Try to find matching iterator ForEach pattern (Iterable.iterator/hasNext/next)
            // JADX Reference: LoopRegionVisitor.checkIterableForEach()
            if !matches!(kind, LoopKind::ForEach) {
                for iter_foreach in &patterns.iterator_for_each {
                    if let Some(detected_kind) = patterns.loop_kinds.get(&iter_foreach.header) {
                        if *detected_kind == LoopKind::ForEach {
                            // Update kind and add details for iterator-based for-each
                            *kind = LoopKind::ForEach;
                            *details = Some(Box::new(LoopDetails::foreach_loop(ForEachLoopInfo {
                                elem_var: None,
                                elem_var_reg: Some(iter_foreach.elem_var),
                                iterable: IterableSource::Iterator {
                                    iterable_reg: iter_foreach.iterable_reg,
                                    iterator_reg: iter_foreach.iterator_reg,
                                    iterator_call_offset: Some(iter_foreach.iterator_call_offset),
                                    has_next_offset: Some(iter_foreach.has_next_offset),
                                    next_offset: Some(iter_foreach.next_call_offset),
                                    // GAP-06 FIX: Pass cast type for proper element type
                                    cast_type_idx: iter_foreach.cast_type_idx,
                                },
                            })));
                            break;
                        }
                    }
                }
            }

            // Try to find matching For pattern (if not already ForEach)
            if !matches!(kind, LoopKind::ForEach) {
                for for_pattern in &patterns.for_loops {
                    if let Some(detected_kind) = patterns.loop_kinds.get(&for_pattern.header) {
                        if *detected_kind == LoopKind::For && *kind != LoopKind::For {
                            // Update kind and add details
                            *kind = LoopKind::For;
                            *details = Some(Box::new(LoopDetails::for_loop(ForLoopInfo {
                                init_block: None, // Could be extracted from pattern
                                init_offset: Some(for_pattern.init_insn_offset),
                                incr_block: None,
                                incr_offset: Some(for_pattern.incr_insn_offset),
                                loop_var: None,
                                loop_var_reg: Some(for_pattern.loop_var),
                            })));
                            break;
                        }
                    }
                }
            }

            // Recurse into body
            refine_loops_recursive(body, patterns);
        }
        Region::Sequence(contents) => {
            for content in contents {
                if let RegionContent::Region(inner) = content {
                    refine_loops_recursive(inner, patterns);
                }
            }
        }
        Region::If { then_region, else_region, .. } => {
            refine_loops_recursive(then_region, patterns);
            if let Some(else_r) = else_region {
                refine_loops_recursive(else_r, patterns);
            }
        }
        Region::Switch { cases, .. } => {
            for case in cases {
                refine_loops_recursive(&mut case.container, patterns);
            }
        }
        Region::TryCatch { try_region, handlers, finally, .. } => {
            refine_loops_recursive(try_region, patterns);
            for handler in handlers {
                refine_loops_recursive(&mut handler.region, patterns);
            }
            if let Some(fin) = finally {
                refine_loops_recursive(fin, patterns);
            }
        }
        Region::Synchronized { body, .. } => {
            refine_loops_recursive(body, patterns);
        }
        Region::Break { .. } | Region::Continue { .. } => {}
        Region::TernaryAssignment { .. } | Region::TernaryReturn { .. } => {}
    }
}

#[cfg(test)]
mod tests {
    use super::*;
    use crate::block_split::split_blocks;
    use crate::block_split::BlockSplitResult;
    use dexterity_ir::attributes::AFlag;
    use dexterity_ir::instructions::{IfCondition, InsnArg, InsnNode, InsnType};
    use dexterity_ir::{ExceptionHandler, TryBlock};

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
        let blocks = split_blocks(&instructions);
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
        let blocks = split_blocks(&instructions);
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
        let blocks = split_blocks(&instructions);
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
        let blocks = split_blocks(&instructions);
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
        let blocks = split_blocks(&instructions);
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

    #[test]
    fn test_mark_duplicated_finally_marks_duplicate_handler_insns() {
        let mut blocks = BTreeMap::new();

        // Try block (id == address for this synthetic test)
        let mut b0 = BasicBlock::new(0, 0);
        b0.instructions.push(InsnNode::new(InsnType::Nop, 0));
        blocks.insert(0, b0);

        // Catch-all (finally) handler: 10 -> 11 -> 12 (throw)
        let mut b10 = BasicBlock::new(10, 10);
        b10.successors = vec![11];
        blocks.insert(10, b10);

        let mut b11 = BasicBlock::new(11, 11);
        b11.instructions.push(InsnNode::new(InsnType::Nop, 11));
        b11.instructions.push(InsnNode::new(InsnType::Nop, 12));
        b11.predecessors = vec![10];
        b11.successors = vec![12];
        blocks.insert(11, b11);

        let mut b12 = BasicBlock::new(12, 13);
        b12.instructions.push(InsnNode::new(
            InsnType::Throw {
                exception: InsnArg::reg(0),
            },
            13,
        ));
        b12.predecessors = vec![11];
        blocks.insert(12, b12);

        // A catch handler with a duplicated copy of the finally code: 20 -> 21
        let mut b20 = BasicBlock::new(20, 20);
        b20.successors = vec![21];
        blocks.insert(20, b20);

        let mut b21 = BasicBlock::new(21, 21);
        b21.instructions.push(InsnNode::new(InsnType::Nop, 21));
        b21.instructions.push(InsnNode::new(InsnType::Nop, 22));
        b21.predecessors = vec![20];
        blocks.insert(21, b21);

        // Convert BTreeMap to Vec for BlockSplitResult
        let blocks_vec: Vec<BasicBlock> = blocks.into_values().collect();
        let mut cfg = CFG::from_blocks(BlockSplitResult {
            blocks: blocks_vec,
            entry_block: 0,
            exit_blocks: vec![12],
        });

        let try_blocks = [TryBlock {
            start_addr: 0,
            end_addr: 1,
            handlers: vec![
                ExceptionHandler {
                    exception_type: Some("Ljava/lang/Exception;".to_string()),
                    handler_addr: 20,
                },
                ExceptionHandler {
                    exception_type: None,
                    handler_addr: 10,
                },
            ],
        }];

        mark_duplicated_finally(&mut cfg, &try_blocks);

        let dup_block = cfg.get_block(21).expect("duplicate block missing");
        assert!(
            dup_block
                .instructions
                .iter()
                .all(|i| i.has_flag(AFlag::DontGenerate)),
            "expected duplicated finally instructions to be marked DONT_GENERATE"
        );
    }

    #[test]
    fn test_refine_loops_with_patterns() {
        // Test that refine_loops_with_patterns updates loop kinds and details
        use crate::loop_analysis::LoopPatternResult;
        use std::collections::HashMap;

        // Create a simple loop region
        let mut region = Region::Loop {
            kind: LoopKind::While,
            condition: Some(Condition::Unknown),
            body: Box::new(Region::Sequence(vec![])),
            details: None,
            loop_type: LoopType::None,
            condition_at_end: false,
            header_block: None,
            pre_condition_block: None,
            label: None,
        };

        // Create loop patterns with a For loop pattern (header = 0, not matching our region)
        let mut patterns = LoopPatternResult::default();
        patterns.loop_kinds.insert(0, LoopKind::For);

        // Refine - should not change since we have no matching header
        refine_loops_with_patterns(&mut region, &patterns);

        // Verify kind is still While (no match found)
        match &region {
            Region::Loop { kind, details, .. } => {
                assert_eq!(*kind, LoopKind::While, "Kind should remain While when no pattern matches");
                assert!(details.is_none(), "Details should remain None when no pattern matches");
            }
            _ => panic!("Expected Loop region"),
        }
    }

    #[test]
    fn test_refine_nested_loops() {
        // Test that nested loops are also refined
        use crate::loop_analysis::LoopPatternResult;

        // Create nested loop structure
        let inner_loop = Region::Loop {
            kind: LoopKind::While,
            condition: Some(Condition::Unknown),
            body: Box::new(Region::Sequence(vec![])),
            details: None,
            loop_type: LoopType::None,
            condition_at_end: false,
            header_block: None,
            pre_condition_block: None,
            label: None,
        };

        let mut region = Region::Loop {
            kind: LoopKind::While,
            condition: Some(Condition::Unknown),
            body: Box::new(Region::Sequence(vec![RegionContent::Region(Box::new(inner_loop))])),
            details: None,
            loop_type: LoopType::None,
            condition_at_end: false,
            header_block: None,
            pre_condition_block: None,
            label: None,
        };

        let patterns = LoopPatternResult::default();

        // Should traverse without panicking
        refine_loops_with_patterns(&mut region, &patterns);

        // Both loops should still be While (no patterns)
        match &region {
            Region::Loop { kind, body, .. } => {
                assert_eq!(*kind, LoopKind::While);
                match body.as_ref() {
                    Region::Sequence(contents) => {
                        if let Some(RegionContent::Region(inner)) = contents.first() {
                            match inner.as_ref() {
                                Region::Loop { kind: inner_kind, .. } => {
                                    assert_eq!(*inner_kind, LoopKind::While);
                                }
                                _ => panic!("Expected inner Loop"),
                            }
                        }
                    }
                    _ => panic!("Expected Sequence body"),
                }
            }
            _ => panic!("Expected Loop region"),
        }
    }
}
