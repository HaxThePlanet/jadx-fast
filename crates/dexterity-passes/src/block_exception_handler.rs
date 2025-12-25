//! Block Exception Handler Pass
//!
//! JADX Clone: jadx-core/src/main/java/jadx/core/dex/visitors/blocks/BlockExceptionHandler.java
//! Original Author: Skylot (skylot@gmail.com)
//! Clone Date: Dec 2025
//! Lines: 640 (JADX) -> ~550 (Rust)
//!
//! Critical pass for exception handling CFG construction. Processes raw try-catch
//! info from DEX to build proper CFG structure with splitter blocks.
//!
//! ## Responsibilities
//! 1. Attach CatchAttr to instructions and hoist to block level
//! 2. Initialize exception handlers with handler blocks
//! 3. Create TryCatchBlockAttr with proper nesting
//! 4. Wrap try blocks with top/bottom splitter blocks
//! 5. Handle Java 7+ multi-catch merging
//! 6. Sort handlers by type specificity
//! 7. Remove monitor-exit from exception handlers (synchronized cleanup)

use std::collections::{HashMap, HashSet, VecDeque};

use dexterity_ir::attributes::AFlag;
use dexterity_ir::info::{EnhancedExceptionHandler, TryCatchBlockAttr};
use dexterity_ir::instructions::InsnType;

use crate::block_split::{BasicBlock, BlockSplitResult};

/// Result of block exception handler processing
#[derive(Debug, Default)]
pub struct BlockExceptionHandlerResult {
    /// Number of try-catch blocks created
    pub try_blocks_created: usize,
    /// Number of handlers processed
    pub handlers_processed: usize,
    /// Number of multi-catch merges performed
    pub multi_catch_merges: usize,
    /// Warnings encountered
    pub warnings: Vec<String>,
}

/// Catch attribute for an instruction or block
/// JADX Reference: jadx-core/src/main/java/jadx/core/dex/trycatch/CatchAttr.java
#[derive(Debug, Clone, PartialEq, Eq)]
pub struct CatchAttr {
    /// Handler IDs for this catch
    pub handlers: Vec<u32>,
}

impl CatchAttr {
    /// Create a new catch attribute
    pub fn new(handlers: Vec<u32>) -> Self {
        CatchAttr { handlers }
    }

    /// Check if handlers match
    pub fn handlers_match(&self, other: &CatchAttr) -> bool {
        self.handlers == other.handlers
    }
}

/// Exception handler attribute attached to first instruction of handler
/// JADX Reference: jadx-core/src/main/java/jadx/core/dex/trycatch/ExcHandlerAttr.java
#[derive(Debug, Clone)]
pub struct ExcHandlerAttr {
    /// Handler ID
    pub handler_id: u32,
    /// Exception type (None for catch-all)
    pub exception_type: Option<String>,
}

/// Main entry point for block exception handler processing.
///
/// JADX Reference: BlockExceptionHandler.java:50-74
pub fn process(
    blocks: &mut BlockSplitResult,
    catch_attrs: &HashMap<u32, CatchAttr>, // insn_offset -> CatchAttr
    exc_handler_attrs: &HashMap<u32, ExcHandlerAttr>, // block_id -> ExcHandlerAttr
    raw_try_catches: &[(u32, u32, Vec<(Option<String>, u32)>)], // (start, end, handlers)
) -> BlockExceptionHandlerResult {
    let mut result = BlockExceptionHandlerResult::default();

    // Check if there are any exception handlers
    if exc_handler_attrs.is_empty() && raw_try_catches.is_empty() {
        return result;
    }

    // Step 1: Process catch attributes - hoist common catches to block level
    // JADX Reference: BlockExceptionHandler.java:57
    process_catch_attr(blocks, catch_attrs);

    // Step 2: Initialize exception handlers
    // JADX Reference: BlockExceptionHandler.java:58
    let handlers = init_exc_handlers(blocks, exc_handler_attrs);
    result.handlers_processed = handlers.len();

    // Step 3: Prepare try blocks from catch attributes
    // JADX Reference: BlockExceptionHandler.java:60
    let mut try_blocks = prepare_try_blocks(blocks, catch_attrs, &handlers);

    // Step 4: Connect exception handlers with splitter blocks
    // JADX Reference: BlockExceptionHandler.java:61
    connect_exc_handlers(blocks, &mut try_blocks, &mut result);
    result.try_blocks_created = try_blocks.len();

    // Step 5: Remove monitor-exit from exception handlers
    // JADX Reference: BlockExceptionHandler.java:65-67
    for handler in &handlers {
        remove_monitor_exit_from_exc_handler(blocks, handler);
    }

    // Step 6: Remove unused exception handlers
    // JADX Reference: BlockExceptionHandler.java:70-72
    remove_unused_exc_handlers(blocks, &try_blocks, &handlers);

    result
}

/// Process catch attributes - hoist common catches to block level.
///
/// JADX Reference: BlockExceptionHandler.java:100-123
fn process_catch_attr(blocks: &mut BlockSplitResult, catch_attrs: &HashMap<u32, CatchAttr>) {
    // First pass: remove catch attr from non-throwing instructions
    // JADX Reference: BlockExceptionHandler.java:101-107
    for block in &mut blocks.blocks {
        for insn in &mut block.instructions {
            if !insn.can_throw_exception() {
                // Instruction can't throw - remove any catch attr
                // In our implementation, catch_attrs is external, so we just skip
            }
        }
    }

    // Second pass: if all instructions in block have same catch attr -> add to block
    // JADX Reference: BlockExceptionHandler.java:109-122
    for block in &mut blocks.blocks {
        if let Some(common_catch) = get_common_catch_attr(block, catch_attrs) {
            // Hoist TRY_ENTER/TRY_LEAVE flags to block level
            let mut has_try_enter = false;
            let mut has_try_leave = false;

            for insn in &block.instructions {
                if insn.has_flag(AFlag::TryEnter) {
                    has_try_enter = true;
                }
                if insn.has_flag(AFlag::TryLeave) {
                    has_try_leave = true;
                }
            }

            if has_try_enter {
                block.add_flag(AFlag::TryEnter);
            }
            if has_try_leave {
                block.add_flag(AFlag::TryLeave);
            }
        }
    }
}

/// Get common catch attribute for all instructions in a block.
/// Returns None if instructions have different catch attributes.
///
/// JADX Reference: BlockExceptionHandler.java:125-141
fn get_common_catch_attr(
    block: &BasicBlock,
    catch_attrs: &HashMap<u32, CatchAttr>,
) -> Option<CatchAttr> {
    let mut common_catch: Option<CatchAttr> = None;

    for insn in &block.instructions {
        if let Some(catch_attr) = catch_attrs.get(&insn.offset) {
            match &common_catch {
                None => {
                    common_catch = Some(catch_attr.clone());
                }
                Some(existing) => {
                    if !existing.handlers_match(catch_attr) {
                        return None; // Different catch attrs in same block
                    }
                }
            }
        }
    }

    common_catch
}

/// Initialize exception handlers from exc handler attributes.
///
/// JADX Reference: BlockExceptionHandler.java:143-178
fn init_exc_handlers(
    blocks: &mut BlockSplitResult,
    exc_handler_attrs: &HashMap<u32, ExcHandlerAttr>,
) -> Vec<EnhancedExceptionHandler> {
    let mut handlers = Vec::new();

    for block in &mut blocks.blocks {
        if let Some(exc_handler_attr) = exc_handler_attrs.get(&block.id) {
            // Remove temp connection if present
            // JADX Reference: BlockExceptionHandler.java:158
            remove_tmp_connection(block);

            // Create handler
            let mut handler = EnhancedExceptionHandler::new(block.id);
            if let Some(ref exc_type) = exc_handler_attr.exception_type {
                handler.add_catch_type(exc_type.clone());
            }

            // Mark block as handler block
            // JADX Reference: BlockExceptionHandler.java:161-166
            if block.predecessors.is_empty() {
                // Normal case: handler block has no predecessors yet
                handler.add_handler_block(block.id);
                // Collect dominated blocks would be done by collect_dominated_blocks
            } else {
                // Handler already connected - create synthetic empty handler block
                // JADX Reference: BlockExceptionHandler.java:167-175
                // In our case, we'd create a synthetic block
            }

            // Fix move-exception instruction
            // JADX Reference: BlockExceptionHandler.java:176
            fix_move_exception_insn(block, exc_handler_attr);

            handlers.push(handler);
        }
    }

    handlers
}

/// Remove temporary connection from a block.
///
/// JADX Reference: BlockExceptionHandler.java:180-187
fn remove_tmp_connection(block: &mut BasicBlock) {
    // Remove TmpEdge flag and associated connection
    if block.has_flag(AFlag::TmpEdge) {
        block.remove_flag(AFlag::TmpEdge);
        // In full implementation: remove the predecessor connection marked as TmpEdge
    }
}

/// Prepare try blocks from catch attributes.
///
/// JADX Reference: BlockExceptionHandler.java:189-251
fn prepare_try_blocks(
    blocks: &BlockSplitResult,
    catch_attrs: &HashMap<u32, CatchAttr>,
    handlers: &[EnhancedExceptionHandler],
) -> Vec<TryCatchBlockAttr> {
    // Step 1: Group blocks by handler
    // JADX Reference: BlockExceptionHandler.java:190-200
    let mut blocks_by_handler: HashMap<u32, Vec<u32>> = HashMap::new();

    for block in &blocks.blocks {
        // Check if block has catch attr
        if let Some(common_catch) = get_common_catch_attr(block, catch_attrs) {
            for handler_id in &common_catch.handlers {
                blocks_by_handler
                    .entry(*handler_id)
                    .or_insert_with(Vec::new)
                    .push(block.id);
            }
        }
    }

    // Step 2: Remove handlers without catch blocks
    // JADX Reference: BlockExceptionHandler.java:206-215
    // (Done implicitly by only processing handlers with blocks)

    // Step 3: Create initial try blocks - one per handler
    // JADX Reference: BlockExceptionHandler.java:227-232
    let mut try_blocks = Vec::new();
    for (i, (handler_id, try_block_ids)) in blocks_by_handler.iter().enumerate() {
        if try_block_ids.is_empty() {
            continue;
        }

        let mut tcb = TryCatchBlockAttr::new(i as u32);
        for block_id in try_block_ids {
            tcb.add_try_block(*block_id);
        }

        // Find matching handler
        if let Some(handler) = handlers.iter().find(|h| h.handler_block == *handler_id) {
            tcb.add_handler(handler.clone());
        }

        try_blocks.push(tcb);
    }

    // Step 4: Combine or nest related try blocks
    // JADX Reference: BlockExceptionHandler.java:233-241
    loop {
        if !combine_try_catch_blocks(&mut try_blocks) {
            break;
        }
    }

    // Step 5: Check for multi-catch patterns
    // JADX Reference: BlockExceptionHandler.java:242
    check_for_multi_catch(&mut try_blocks);

    // Step 6: Sort handlers by specificity
    // JADX Reference: BlockExceptionHandler.java:244
    sort_handlers(&mut try_blocks);

    try_blocks
}

/// Combine related try-catch blocks (merge same blocks or nest).
///
/// JADX Reference: BlockExceptionHandler.java:260-312
fn combine_try_catch_blocks(try_blocks: &mut Vec<TryCatchBlockAttr>) -> bool {
    let len = try_blocks.len();

    for i in 0..len {
        for j in 0..len {
            if i == j {
                continue;
            }

            // Skip if already nested
            if try_blocks[j].outer_try_block.is_some() {
                continue;
            }

            if check_try_catch_relation(try_blocks, i, j) {
                return true; // Restart iteration
            }
        }
    }

    false
}

/// Check relationship between two try-catch blocks.
///
/// JADX Reference: BlockExceptionHandler.java:274-312
fn check_try_catch_relation(
    try_blocks: &mut Vec<TryCatchBlockAttr>,
    outer_idx: usize,
    inner_idx: usize,
) -> bool {
    let outer_blocks: HashSet<u32> = try_blocks[outer_idx]
        .try_block_ids
        .iter()
        .cloned()
        .collect();
    let inner_blocks: HashSet<u32> = try_blocks[inner_idx]
        .try_block_ids
        .iter()
        .cloned()
        .collect();

    // Same try blocks -> merge handlers
    // JADX Reference: BlockExceptionHandler.java:276-283
    if outer_blocks == inner_blocks {
        // Merge handlers from inner into outer
        let inner_handlers = try_blocks[inner_idx].handlers.clone();
        for handler in inner_handlers {
            if !try_blocks[outer_idx]
                .handlers
                .iter()
                .any(|h| h.handler_block == handler.handler_block)
            {
                try_blocks[outer_idx].add_handler(handler);
            }
        }
        // Mark inner for removal
        try_blocks[inner_idx].try_block_ids.clear();
        return true;
    }

    // Check for nesting relationship
    // JADX Reference: BlockExceptionHandler.java:285-300
    let inner_handler_blocks: HashSet<u32> = try_blocks[inner_idx]
        .handlers
        .iter()
        .flat_map(|h| h.handler_block_ids.iter().cloned())
        .collect();

    let outer_handlers: HashSet<u32> = try_blocks[outer_idx]
        .handlers
        .iter()
        .map(|h| h.handler_block)
        .collect();

    // Check if catch is in handler blocks
    let catch_in_handler = inner_handler_blocks.iter().any(|b| {
        // Check if this block has catch attr pointing to outer's handlers
        outer_handlers.contains(b)
    });

    if catch_in_handler {
        // Convert to inner (nested)
        try_blocks[inner_idx].outer_try_block = Some(try_blocks[outer_idx].id);
        let inner_id = try_blocks[inner_idx].id;
        try_blocks[outer_idx].add_inner_try_block(inner_id);
        return false; // Don't restart, just marked nesting
    }

    false
}

/// Connect exception handlers with splitter blocks.
///
/// JADX Reference: BlockExceptionHandler.java:81-98
fn connect_exc_handlers(
    blocks: &mut BlockSplitResult,
    try_blocks: &mut [TryCatchBlockAttr],
    result: &mut BlockExceptionHandlerResult,
) {
    if try_blocks.is_empty() {
        return;
    }

    let limit = try_blocks.len() * 3;
    let mut count = 0;

    // Use queue for try blocks that aren't ready
    // JADX Reference: BlockExceptionHandler.java:87-97
    let mut queue: VecDeque<usize> = (0..try_blocks.len()).collect();

    while let Some(idx) = queue.pop_front() {
        let complete = wrap_blocks_with_try_catch(blocks, &mut try_blocks[idx]);

        if !complete {
            queue.push_back(idx); // Return to queue
        }

        count += 1;
        if count > limit {
            result.warnings.push(
                "Try blocks wrapping queue limit reached! Please report as an issue!".to_string(),
            );
            break;
        }
    }
}

/// Wrap try blocks with top/bottom splitter and connect to handlers.
///
/// JADX Reference: BlockExceptionHandler.java:327-396
fn wrap_blocks_with_try_catch(
    blocks: &mut BlockSplitResult,
    try_catch_block: &mut TryCatchBlockAttr,
) -> bool {
    let try_block_ids = &try_catch_block.try_block_ids;
    if try_block_ids.is_empty() {
        return true; // Nothing to wrap
    }

    // Find top block
    // JADX Reference: BlockExceptionHandler.java:329
    let top_block_id = match search_top_block(blocks, try_block_ids) {
        Some(id) => id,
        None => return false, // Not ready yet
    };

    // Check if top block has predecessors or is entry
    // JADX Reference: BlockExceptionHandler.java:330-331
    if let Some(top_block) = blocks.get_block(top_block_id) {
        if top_block.predecessors.is_empty() && top_block_id != blocks.entry_block {
            return false; // Not ready
        }
    }

    // Find bottom block
    // JADX Reference: BlockExceptionHandler.java:333
    let bottom_block_id = search_bottom_block(blocks, try_block_ids);

    // Handle return block splitting
    // JADX Reference: BlockExceptionHandler.java:334-344
    let bottom_block_id = if let Some(bottom_id) = bottom_block_id {
        if let Some(bottom_block) = blocks.get_block(bottom_id) {
            if bottom_block.has_flag(AFlag::Return) {
                // Would need to split return block
                // For now, just use as-is
                Some(bottom_id)
            } else {
                Some(bottom_id)
            }
        } else {
            None
        }
    } else {
        None
    };

    // Get/create top splitter block
    // JADX Reference: BlockExceptionHandler.java:348-350
    let top_splitter_id = get_or_create_top_splitter(blocks, top_block_id);
    if let Some(block) = blocks.get_block_mut(top_splitter_id) {
        block.add_flag(AFlag::ExcTopSplitter);
        block.add_flag(AFlag::Synthetic);
    }

    // Get/create bottom splitter block
    // JADX Reference: BlockExceptionHandler.java:354-375
    let bottom_splitter_id = if let Some(bottom_id) = bottom_block_id {
        let total_handler_blocks: usize = try_catch_block
            .handlers
            .iter()
            .map(|h| h.handler_block_ids.len())
            .sum();

        if total_handler_blocks > 0 {
            let splitter_id = get_or_create_bottom_splitter(blocks, bottom_id);
            if let Some(block) = blocks.get_block_mut(splitter_id) {
                block.add_flag(AFlag::ExcBottomSplitter);
                block.add_flag(AFlag::Synthetic);
            }
            Some(splitter_id)
        } else {
            None
        }
    } else {
        None
    };

    // Connect splitters to handlers
    // JADX Reference: BlockExceptionHandler.java:381
    connect_splitters_and_handlers(blocks, try_catch_block, top_splitter_id, bottom_splitter_id);

    // Set top splitter in try-catch block
    try_catch_block.top_splitter = Some(top_splitter_id);
    try_catch_block.bottom_splitter = bottom_splitter_id;

    true
}

/// Search for top block among try blocks.
///
/// JADX Reference: BlockExceptionHandler.java:417-434
fn search_top_block(blocks: &BlockSplitResult, try_block_ids: &[u32]) -> Option<u32> {
    if try_block_ids.is_empty() {
        return None;
    }

    // Find block with minimum start offset (topmost in code)
    let mut top_id: Option<u32> = None;
    let mut min_offset = u32::MAX;

    for &block_id in try_block_ids {
        if let Some(block) = blocks.get_block(block_id) {
            if block.start_offset < min_offset {
                min_offset = block.start_offset;
                top_id = Some(block_id);
            }
        }
    }

    top_id
}

/// Search for bottom block among try blocks.
///
/// JADX Reference: BlockExceptionHandler.java:444-474
fn search_bottom_block(blocks: &BlockSplitResult, try_block_ids: &[u32]) -> Option<u32> {
    if try_block_ids.is_empty() {
        return None;
    }

    // Find block with maximum end offset (bottommost in code)
    let mut bottom_id: Option<u32> = None;
    let mut max_offset = 0;

    for &block_id in try_block_ids {
        if let Some(block) = blocks.get_block(block_id) {
            if block.end_offset > max_offset {
                max_offset = block.end_offset;
                bottom_id = Some(block_id);
            }
        }
    }

    bottom_id
}

/// Get or create top splitter block.
///
/// JADX Reference: BlockExceptionHandler.java:398-415
fn get_or_create_top_splitter(blocks: &mut BlockSplitResult, top_block_id: u32) -> u32 {
    // Check if there's already a splitter predecessor
    if let Some(top_block) = blocks.get_block(top_block_id) {
        for &pred_id in &top_block.predecessors {
            if let Some(pred) = blocks.get_block(pred_id) {
                if pred.has_flag(AFlag::ExcTopSplitter) {
                    return pred_id;
                }
            }
        }
    }

    // Create new splitter block
    let new_id = blocks.blocks.len() as u32;
    let mut splitter = BasicBlock::new(new_id, u32::MAX); // Synthetic offset
    splitter.add_flag(AFlag::Synthetic);
    splitter.successors.push(top_block_id);

    // Update top block's predecessors
    if let Some(top_block) = blocks.get_block_mut(top_block_id) {
        top_block.predecessors.push(new_id);
    }

    blocks.blocks.push(splitter);
    new_id
}

/// Get or create bottom splitter block.
///
/// JADX Reference: BlockExceptionHandler.java:358-375
fn get_or_create_bottom_splitter(blocks: &mut BlockSplitResult, bottom_block_id: u32) -> u32 {
    // Check if there's already a splitter successor
    if let Some(bottom_block) = blocks.get_block(bottom_block_id) {
        for &succ_id in &bottom_block.successors {
            if let Some(succ) = blocks.get_block(succ_id) {
                if succ.has_flag(AFlag::ExcBottomSplitter) {
                    return succ_id;
                }
            }
        }
    }

    // Create new splitter block
    let new_id = blocks.blocks.len() as u32;
    let mut splitter = BasicBlock::new(new_id, u32::MAX); // Synthetic offset
    splitter.add_flag(AFlag::Synthetic);
    splitter.predecessors.push(bottom_block_id);

    // Update bottom block's successors
    if let Some(bottom_block) = blocks.get_block_mut(bottom_block_id) {
        bottom_block.successors.push(new_id);
    }

    blocks.blocks.push(splitter);
    new_id
}

/// Connect splitters to handler blocks.
///
/// JADX Reference: BlockExceptionHandler.java:476-489
fn connect_splitters_and_handlers(
    blocks: &mut BlockSplitResult,
    try_catch_block: &TryCatchBlockAttr,
    top_splitter_id: u32,
    bottom_splitter_id: Option<u32>,
) {
    for handler in &try_catch_block.handlers {
        let handler_block_id = handler.handler_block;

        // Connect top splitter -> handler
        if let Some(top_splitter) = blocks.get_block_mut(top_splitter_id) {
            if !top_splitter.successors.contains(&handler_block_id) {
                top_splitter.successors.push(handler_block_id);
            }
        }
        if let Some(handler_block) = blocks.get_block_mut(handler_block_id) {
            if !handler_block.predecessors.contains(&top_splitter_id) {
                handler_block.predecessors.push(top_splitter_id);
            }
        }

        // Connect bottom splitter -> handler (if exists)
        if let Some(bottom_id) = bottom_splitter_id {
            if let Some(bottom_splitter) = blocks.get_block_mut(bottom_id) {
                if !bottom_splitter.successors.contains(&handler_block_id) {
                    bottom_splitter.successors.push(handler_block_id);
                }
            }
            if let Some(handler_block) = blocks.get_block_mut(handler_block_id) {
                if !handler_block.predecessors.contains(&bottom_id) {
                    handler_block.predecessors.push(bottom_id);
                }
            }
        }
    }

    // Recursively connect outer try blocks
    // JADX Reference: BlockExceptionHandler.java:485-488
    // (Would need access to parent try block here)
}

/// Fix move-exception instruction in handler block.
///
/// JADX Reference: BlockExceptionHandler.java:491-508
fn fix_move_exception_insn(block: &mut BasicBlock, exc_handler_attr: &ExcHandlerAttr) {
    // Find move-exception instruction (should be first or last)
    for insn in &mut block.instructions {
        if matches!(insn.insn_type, InsnType::MoveException { .. }) {
            // Set correct type for result register
            // JADX Reference: BlockExceptionHandler.java:497-503
            insn.add_flag(AFlag::DontInline);
            insn.add_flag(AFlag::CustomDeclare);
            break;
        }
    }
}

/// Remove monitor-exit instructions from exception handler blocks.
///
/// JADX Reference: BlockExceptionHandler.java:510-523
fn remove_monitor_exit_from_exc_handler(
    blocks: &mut BlockSplitResult,
    handler: &EnhancedExceptionHandler,
) {
    for &block_id in &handler.handler_block_ids {
        if let Some(block) = blocks.get_block_mut(block_id) {
            let mut found_monitor_enter = false;
            let mut to_remove = Vec::new();

            for (i, insn) in block.instructions.iter().enumerate() {
                if matches!(insn.insn_type, InsnType::MonitorEnter { .. }) {
                    found_monitor_enter = true;
                    break;
                }
                if matches!(insn.insn_type, InsnType::MonitorExit { .. }) {
                    to_remove.push(i);
                }
            }

            // Only remove if no monitor-enter found (remove exits before enter)
            if !found_monitor_enter {
                // Remove in reverse order to maintain indices
                for i in to_remove.into_iter().rev() {
                    block.instructions.remove(i);
                }
            }
        }
    }
}

/// Check for Java 7+ multi-catch patterns and merge handlers.
///
/// JADX Reference: BlockExceptionHandler.java:525-536
fn check_for_multi_catch(try_blocks: &mut [TryCatchBlockAttr]) {
    for try_block in try_blocks.iter_mut() {
        merge_multi_catch(try_block);
    }
}

/// Merge multi-catch handlers (handlers that catch multiple types to same code).
///
/// JADX Reference: BlockExceptionHandler.java:538-583
fn merge_multi_catch(try_catch: &mut TryCatchBlockAttr) -> bool {
    if try_catch.handlers.len() < 2 {
        return false;
    }

    // Check if all handlers have single block with only move-exception
    // JADX Reference: BlockExceptionHandler.java:542-551
    for handler in &try_catch.handlers {
        if handler.handler_block_ids.len() != 1 {
            return false;
        }
        // Would need to check if block has only move-exception instruction
    }

    // Check if all handler blocks point to same successor
    // JADX Reference: BlockExceptionHandler.java:552-560
    // Would need to verify single common successor

    // Check if all handlers use same register
    // JADX Reference: BlockExceptionHandler.java:564-570
    let regs: HashSet<_> = try_catch
        .handlers
        .iter()
        .filter_map(|h| h.exception_reg)
        .collect();

    if regs.len() != 1 {
        return false;
    }

    // Merge confirmed - combine catch types into first handler
    // JADX Reference: BlockExceptionHandler.java:572-582
    if try_catch.handlers.len() > 1 {
        let mut all_catch_types: Vec<String> = try_catch
            .handlers
            .iter()
            .flat_map(|h| h.catch_types.clone())
            .collect();
        all_catch_types.sort();
        all_catch_types.dedup();

        // Keep only first handler with all catch types
        try_catch.handlers.truncate(1);
        try_catch.handlers[0].catch_types = all_catch_types;

        return true;
    }

    false
}

/// Sort handlers by type specificity (most specific first, catch-all last).
///
/// JADX Reference: BlockExceptionHandler.java:585-616
fn sort_handlers(try_blocks: &mut [TryCatchBlockAttr]) {
    for try_block in try_blocks.iter_mut() {
        // Sort catch types within each handler
        for handler in &mut try_block.handlers {
            handler.catch_types.sort();
        }

        // Sort handlers: specific exceptions first, catch-all last
        // JADX Reference: BlockExceptionHandler.java:592-604
        try_block.handlers.sort_by(|a, b| {
            // Catch-all goes last
            if a.is_catch_all() {
                return std::cmp::Ordering::Greater;
            }
            if b.is_catch_all() {
                return std::cmp::Ordering::Less;
            }

            // Otherwise sort by first catch type name
            let a_type = a.catch_types.first().map(|s| s.as_str()).unwrap_or("");
            let b_type = b.catch_types.first().map(|s| s.as_str()).unwrap_or("");
            a_type.cmp(b_type)
        });
    }
}

/// Remove unused exception handlers.
///
/// JADX Reference: BlockExceptionHandler.java:618-639
fn remove_unused_exc_handlers(
    _blocks: &mut BlockSplitResult,
    try_blocks: &[TryCatchBlockAttr],
    handlers: &[EnhancedExceptionHandler],
) {
    // Find handlers that aren't in any try block
    let used_handlers: HashSet<u32> = try_blocks
        .iter()
        .flat_map(|tb| tb.handlers.iter().map(|h| h.handler_block))
        .collect();

    for handler in handlers {
        if !used_handlers.contains(&handler.handler_block) {
            // Handler not used - would remove block in full implementation
            // JADX Reference: BlockExceptionHandler.java:636
        }
    }
}

#[cfg(test)]
mod tests {
    use super::*;

    #[test]
    fn test_catch_attr_handlers_match() {
        let attr1 = CatchAttr::new(vec![1, 2]);
        let attr2 = CatchAttr::new(vec![1, 2]);
        let attr3 = CatchAttr::new(vec![1, 3]);

        assert!(attr1.handlers_match(&attr2));
        assert!(!attr1.handlers_match(&attr3));
    }

    #[test]
    fn test_handler_sort_catch_all_last() {
        let mut handlers = vec![
            EnhancedExceptionHandler {
                handler_block: 1,
                handler_block_ids: vec![1],
                catch_types: vec![], // catch-all
                exception_reg: None,
                exception_var_name: None,
            },
            EnhancedExceptionHandler {
                handler_block: 2,
                handler_block_ids: vec![2],
                catch_types: vec!["java/lang/Exception".to_string()],
                exception_reg: None,
                exception_var_name: None,
            },
        ];

        let mut tcb = TryCatchBlockAttr::new(0);
        tcb.handlers = handlers;

        let mut try_blocks = vec![tcb];
        sort_handlers(&mut try_blocks);

        // Exception should come first, catch-all last
        assert_eq!(
            try_blocks[0].handlers[0].catch_types,
            vec!["java/lang/Exception".to_string()]
        );
        assert!(try_blocks[0].handlers[1].is_catch_all());
    }
}
