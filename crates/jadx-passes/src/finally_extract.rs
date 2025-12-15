//! Finally block extraction
//!
//! This module implements the Java JADX algorithm for detecting and extracting
//! finally blocks by finding duplicated instruction sequences.
//!
//! In Java bytecode, finally blocks are compiled as:
//! 1. A catch-all handler that stores exception, runs finally code, then re-throws
//! 2. Duplicated finally code at end of try and each catch handler
//!
//! This algorithm:
//! - Finds catch-all handlers with re-throw instructions
//! - Searches for duplicate instruction sequences in other handlers and try exits
//! - Marks finally instructions with FINALLY_INSNS flag
//! - Marks duplicate instructions with DONT_GENERATE flag

use std::collections::BTreeSet;

use jadx_ir::attributes::AFlag;
use jadx_ir::instructions::{InsnNode, InsnType};

use crate::cfg::CFG;
use crate::region_builder::{HandlerInfo, TryInfo};

/// Instruction slice - tracks a sequence of instructions across blocks
#[derive(Debug, Clone)]
pub struct InsnsSlice {
    /// List of instructions: (block_id, instruction_index)
    pub insns_list: Vec<(u32, usize)>,
    /// Blocks containing these instructions
    pub blocks: BTreeSet<u32>,
    /// True if this slice is complete (all instructions found)
    pub complete: bool,
}

impl InsnsSlice {
    pub fn new() -> Self {
        InsnsSlice {
            insns_list: Vec::new(),
            blocks: BTreeSet::new(),
            complete: false,
        }
    }

    /// Add an instruction to the slice
    pub fn add_insn(&mut self, block_id: u32, insn_idx: usize) {
        self.insns_list.push((block_id, insn_idx));
        self.blocks.insert(block_id);
    }

    /// Add multiple instructions from a block
    pub fn add_insns(&mut self, block_id: u32, start_idx: usize, count: usize) {
        for i in 0..count {
            self.insns_list.push((block_id, start_idx + i));
        }
        self.blocks.insert(block_id);
    }

    /// Add a block to the slice
    pub fn add_block(&mut self, block_id: u32) {
        self.blocks.insert(block_id);
    }

    /// Mark slice as complete
    pub fn set_complete(&mut self, complete: bool) {
        self.complete = complete;
    }

    /// Mark slice as incomplete
    pub fn reset_incomplete(&mut self) {
        self.complete = false;
    }

    /// Check if slice is complete
    pub fn is_complete(&self) -> bool {
        self.complete
    }

    /// Get the instruction list
    pub fn get_insns_list(&self) -> &[(u32, usize)] {
        &self.insns_list
    }

    /// Get blocks
    pub fn get_blocks(&self) -> &BTreeSet<u32> {
        &self.blocks
    }
}

/// Finally extraction context
pub struct FinallyExtractInfo {
    /// Start block of finally code (first block after move-exception)
    start_block: u32,
    /// All blocks in the finally handler
    all_handler_blocks: BTreeSet<u32>,
    /// Finally instruction slice (the canonical finally code)
    finally_insns_slice: InsnsSlice,
    /// Duplicate instruction slices found in other handlers/try exits
    duplicate_slices: Vec<InsnsSlice>,
    /// Blocks already checked (to avoid re-checking)
    checked_blocks: BTreeSet<u32>,
    /// Current duplicate slice being built
    cur_dup_slice: Option<InsnsSlice>,
    /// Current duplicate instructions being compared
    cur_dup_insns: Vec<usize>,
    /// Offset in current duplicate instructions
    cur_dup_insns_offset: usize,
}

impl FinallyExtractInfo {
    pub fn new(
        start_block: u32,
        all_handler_blocks: BTreeSet<u32>,
    ) -> Self {
        FinallyExtractInfo {
            start_block,
            all_handler_blocks,
            finally_insns_slice: InsnsSlice::new(),
            duplicate_slices: Vec::new(),
            checked_blocks: BTreeSet::new(),
            cur_dup_slice: None,
            cur_dup_insns: Vec::new(),
            cur_dup_insns_offset: 0,
        }
    }

    pub fn get_finally_insns_slice(&self) -> &InsnsSlice {
        &self.finally_insns_slice
    }

    pub fn get_finally_insns_slice_mut(&mut self) -> &mut InsnsSlice {
        &mut self.finally_insns_slice
    }

    pub fn get_duplicate_slices(&self) -> &[InsnsSlice] {
        &self.duplicate_slices
    }

    pub fn add_duplicate_slice(&mut self, slice: InsnsSlice) {
        self.duplicate_slices.push(slice);
    }

    pub fn get_checked_blocks(&mut self) -> &mut BTreeSet<u32> {
        &mut self.checked_blocks
    }

    pub fn get_all_handler_blocks(&self) -> &BTreeSet<u32> {
        &self.all_handler_blocks
    }

    pub fn get_start_block(&self) -> u32 {
        self.start_block
    }

    pub fn set_cur_dup_slice(&mut self, slice: Option<InsnsSlice>) {
        self.cur_dup_slice = slice;
    }

    pub fn get_cur_dup_slice(&self) -> Option<&InsnsSlice> {
        self.cur_dup_slice.as_ref()
    }

    pub fn set_cur_dup_insns(&mut self, insns: Vec<usize>, offset: usize) {
        self.cur_dup_insns = insns;
        self.cur_dup_insns_offset = offset;
    }

    pub fn get_cur_dup_insns(&self) -> &[usize] {
        &self.cur_dup_insns
    }

    pub fn get_cur_dup_insns_offset(&self) -> usize {
        self.cur_dup_insns_offset
    }
}

/// Extract finally blocks from try-catch
///
/// Based on Java JADX MarkFinallyVisitor.extractFinally() (line 104-235)
pub fn extract_finally(
    cfg: &CFG,
    try_info: &TryInfo,
    all_handler: &HandlerInfo,
) -> Option<FinallyExtractInfo> {
    // Get handler block (entry point with move-exception)
    let handler_block_id = all_handler.handler_block;
    let handler_block = cfg.get_block(handler_block_id)?;

    // Get blocks dominated by handler (excluding the move-exception block itself)
    let mut handler_blocks: Vec<u32> = all_handler.handler_blocks.iter().copied().collect();
    handler_blocks.retain(|&id| id != handler_block_id);

    // Remove throw block and empty predecessors (Java line 109, 237-257)
    cut_path_ends(cfg, &mut handler_blocks);

    if handler_blocks.is_empty() || all_blocks_empty(cfg, &handler_blocks) {
        // Empty finally - just remove the catch-all handler
        return None;
    }

    // Get start block (first successor of handler entry)
    let start_block = handler_block.successors.first().copied()?;

    // Create extraction context
    let handler_blocks_set: BTreeSet<u32> = handler_blocks.iter().copied().collect();
    let mut extract_info = FinallyExtractInfo::new(
        start_block,
        handler_blocks_set,
    );

    // Search for duplicate instruction sequences in other exception handlers
    // (Java line 137-148)
    for other_handler in &try_info.handlers {
        if std::ptr::eq(other_handler, all_handler) {
            continue;
        }

        for &check_block_id in &other_handler.handler_blocks {
            if search_duplicate_insns(check_block_id, &mut extract_info, cfg) {
                break;
            } else {
                extract_info.get_finally_insns_slice_mut().reset_incomplete();
            }
        }
    }

    // TODO: Search for duplicates in try exit paths (Java line 166-205)
    // This requires CFG path collection helpers which will be added in Phase 3

    // Verify all slices match (Java line 267-292)
    if !check_slices(&extract_info) {
        return None;
    }

    Some(extract_info)
}

/// Cut path ends - remove throw block and empty predecessors
///
/// Based on Java JADX cutPathEnds() (line 237-257)
fn cut_path_ends(cfg: &CFG, handler_blocks: &mut Vec<u32>) {
    // Find throw blocks
    let throw_blocks: Vec<u32> = handler_blocks
        .iter()
        .filter(|&&id| {
            if let Some(block) = cfg.get_block(id) {
                if let Some(last_insn) = block.last_insn() {
                    matches!(last_insn.insn_type, InsnType::Throw { .. })
                } else {
                    false
                }
            } else {
                false
            }
        })
        .copied()
        .collect();

    if throw_blocks.len() != 1 {
        // Unexpected throw block count - skip cutting
        return;
    }

    let throw_block = throw_blocks[0];
    handler_blocks.retain(|&id| id != throw_block);

    // Remove empty predecessors recursively
    remove_empty_up_path(cfg, handler_blocks, throw_block);
}

/// Remove empty blocks in the path to throw block
///
/// Based on Java JADX removeEmptyUpPath() (line 249-257)
fn remove_empty_up_path(cfg: &CFG, handler_blocks: &mut Vec<u32>, start_block: u32) {
    if let Some(block) = cfg.get_block(start_block) {
        for &pred in &block.predecessors {
            if let Some(pred_block) = cfg.get_block(pred) {
                if pred_block.is_empty() {
                    if let Some(pos) = handler_blocks.iter().position(|&id| id == pred) {
                        handler_blocks.remove(pos);
                        // Check if this is not a back edge before recursing
                        if !is_back_edge(cfg, pred, start_block) {
                            remove_empty_up_path(cfg, handler_blocks, pred);
                        }
                    }
                }
            }
        }
    }
}

/// Check if edge is a back edge (loop)
fn is_back_edge(cfg: &CFG, from: u32, to: u32) -> bool {
    // Simple check: if 'from' has higher ID than 'to', it's likely a back edge
    // More sophisticated check would use dominator tree
    from > to
}

/// Check if all blocks are empty
fn all_blocks_empty(cfg: &CFG, blocks: &[u32]) -> bool {
    blocks.iter().all(|&id| {
        cfg.get_block(id)
            .map(|b| b.is_empty())
            .unwrap_or(true)
    })
}

/// Search for duplicate instruction sequence starting from a block
///
/// Based on Java JADX searchDuplicateInsns() (line 347-359)
fn search_duplicate_insns(check_block: u32, extract_info: &mut FinallyExtractInfo, cfg: &CFG) -> bool {
    // Check if already processed
    if !extract_info.get_checked_blocks().insert(check_block) {
        return false;
    }

    let start_block = extract_info.get_start_block();

    // Try to match from first block
    if let Some(dup_slice) = search_from_first_block(check_block, start_block, extract_info, cfg) {
        extract_info.add_duplicate_slice(dup_slice);
        return true;
    }

    false
}

/// Search for match starting from the first block
///
/// Based on Java JADX searchFromFirstBlock() (line 361-376)
fn search_from_first_block(
    dup_block_id: u32,
    start_block_id: u32,
    extract_info: &mut FinallyExtractInfo,
    cfg: &CFG,
) -> Option<InsnsSlice> {
    // Try to match as start block
    let dup_slice = is_start_block(dup_block_id, start_block_id, extract_info, cfg)?;

    if !dup_slice.is_complete() {
        // Need to check block tree for complete match
        // TODO: implement checkBlocksTree (Java line 367-373)
        // For now, just accept incomplete slices
    }

    check_temp_slice(dup_slice)
}

/// Check if temporary slice is valid
///
/// Based on Java JADX checkTempSlice() (line 378-392)
fn check_temp_slice(slice: InsnsSlice) -> Option<InsnsSlice> {
    if slice.insns_list.is_empty() {
        return None;
    }

    // Ignore slice with only one 'if' instruction
    // TODO: implement this check when we have access to instruction types

    Some(slice)
}

/// Check if block is the start of finally code (may start mid-block)
///
/// Based on Java JADX isStartBlock() (line 397-475)
fn is_start_block(
    dup_block_id: u32,
    finally_block_id: u32,
    extract_info: &mut FinallyExtractInfo,
    cfg: &CFG,
) -> Option<InsnsSlice> {
    extract_info.set_cur_dup_slice(None);

    let dup_block = cfg.get_block(dup_block_id)?;
    let finally_block = cfg.get_block(finally_block_id)?;

    let dup_insns = &dup_block.instructions;
    let finally_insns = &finally_block.instructions;

    let dup_size = dup_insns.len();
    let fin_size = finally_insns.len();

    if dup_size < fin_size {
        return None;
    }

    let (start_pos, end_pos, complete) = if dup_size == fin_size {
        // Exact size match - compare all instructions
        if !check_insns_match(extract_info, dup_insns, finally_insns, 0) {
            return None;
        }
        (0, 0, false)
    } else {
        // dup_size > fin_size - finally might start mid-block
        let start_pos = dup_size - fin_size;

        // Fast check from end of block
        if check_insns_match(extract_info, dup_insns, finally_insns, start_pos) {
            (start_pos, 0, false)
        } else {
            // Search for start position
            let mut found_start = None;
            for i in 1..start_pos {
                if check_insns_match(extract_info, dup_insns, finally_insns, i) {
                    found_start = Some((i, fin_size + i));
                    break;
                }
            }

            if let Some((start, end)) = found_start {
                (start, end, true)
            } else {
                return None;
            }
        }
    };

    // Build instruction slices
    let mut slice = InsnsSlice::new();
    extract_info.set_cur_dup_slice(Some(slice.clone()));

    let end_index = if end_pos != 0 {
        end_pos + 1
    } else {
        dup_size
    };

    // Fill duplicate slice
    for i in start_pos..end_index {
        slice.add_insn(dup_block_id, i);
    }

    // Fill finally slice (if not already complete)
    let finally_slice = extract_info.get_finally_insns_slice_mut();
    if !finally_slice.is_complete() {
        for i in 0..finally_insns.len() {
            finally_slice.add_insn(finally_block_id, i);
        }
    }

    if complete || end_pos != 0 {
        slice.set_complete(true);
        finally_slice.set_complete(true);
    }

    Some(slice)
}

/// Check if instructions match
///
/// Based on Java JADX checkInsns() (line 477-487)
fn check_insns_match(
    extract_info: &mut FinallyExtractInfo,
    dup_insns: &[InsnNode],
    finally_insns: &[InsnNode],
    delta: usize,
) -> bool {
    let indices: Vec<usize> = (delta..delta + finally_insns.len()).collect();
    extract_info.set_cur_dup_insns(indices, delta);

    for (i, finally_insn) in finally_insns.iter().enumerate().rev() {
        let dup_insn = &dup_insns[delta + i];
        if !same_insns(dup_insn, finally_insn) {
            return false;
        }
    }

    true
}

/// Check if two instructions are the same
///
/// Based on Java JADX sameInsns() (line 561-574)
fn same_insns(dup_insn: &InsnNode, finally_insn: &InsnNode) -> bool {
    // Check instruction type matches
    if std::mem::discriminant(&dup_insn.insn_type) != std::mem::discriminant(&finally_insn.insn_type) {
        return false;
    }

    // TODO: Check arguments match (with SSA variable handling)
    // This requires implementing is_same_args() with SSA awareness
    // For now, just match on instruction type

    true
}

/// Verify all duplicate slices match the finally slice
///
/// Based on Java JADX checkSlices() (line 267-292)
fn check_slices(extract_info: &FinallyExtractInfo) -> bool {
    let finally_slice = extract_info.get_finally_insns_slice();
    let finally_insns_count = finally_slice.insns_list.len();

    if finally_insns_count == 0 {
        return false;
    }

    // Check all duplicate slices have same size
    for dup_slice in extract_info.get_duplicate_slices() {
        if dup_slice.insns_list.len() != finally_insns_count {
            return false;
        }
    }

    // TODO: Check instruction types match across all slices

    true
}

/// Apply finally marking - mark instructions with flags
///
/// Based on Java JADX apply() (line 294-308)
pub fn apply_finally_marking(extract_info: &FinallyExtractInfo, cfg: &mut CFG) {
    // Mark finally slice with FINALLY_INSNS
    mark_slice(&extract_info.finally_insns_slice, AFlag::FinallyInsns, cfg);

    // Mark duplicate slices with DONT_GENERATE
    for dup_slice in &extract_info.duplicate_slices {
        mark_slice(dup_slice, AFlag::DontGenerate, cfg);
    }
}

/// Mark instructions in a slice with a flag
///
/// Based on Java JADX markSlice() (line 310-327)
fn mark_slice(slice: &InsnsSlice, flag: AFlag, cfg: &mut CFG) {
    // Mark each instruction
    for &(block_id, insn_idx) in &slice.insns_list {
        if let Some(block) = cfg.get_block_mut(block_id) {
            if let Some(insn) = block.instructions.get_mut(insn_idx) {
                insn.add_flag(flag);
            }
        }
    }

    // If all instructions in a block are marked, mark the block too
    for &block_id in &slice.blocks {
        if let Some(block) = cfg.get_block_mut(block_id) {
            let all_marked = block.instructions.iter().all(|insn| {
                insn.has_flag(flag)
            });
            if all_marked {
                block.add_flag(flag);
            }
        }
    }
}
