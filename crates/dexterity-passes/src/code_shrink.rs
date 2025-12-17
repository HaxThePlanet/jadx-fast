//! Code shrinking pass - inline single-use variables
//!
//! This pass identifies instructions that can be "wrapped" (inlined) into their
//! use sites, eliminating intermediate variable assignments:
//!
//! Before:
//!   int temp = a + b;
//!   int result = temp * 2;
//!
//! After:
//!   int result = (a + b) * 2;
//!
//! Based on JADX's CodeShrinkVisitor.
//!
//! ## Cross-Block Inlining
//!
//! Unlike simple same-block inlining, cross-block inlining moves instructions
//! between different basic blocks. This requires checking:
//! 1. Path exists from def block to use block
//! 2. No side effects between def and use
//! 3. No register reassignments on the path
//! 4. Special handling for synchronized regions

use std::collections::{HashMap, HashSet, VecDeque};
use dexterity_ir::instructions::{InsnArg, InsnNode, InsnType, InvokeKind, RegisterArg};
use dexterity_ir::attributes::AFlag;
use crate::ssa::SsaResult;

/// Result of code shrinking pass
#[derive(Debug, Default)]
pub struct CodeShrinkResult {
    /// Number of instructions marked for wrapping
    pub wrapped_count: usize,
    /// Map of (use_offset) -> (wrapped_insn_offset)
    /// Tells codegen which instruction to inline at which use site
    pub wrap_info: HashMap<u32, WrapTarget>,
}

/// Information about a wrapped instruction
#[derive(Debug, Clone)]
pub struct WrapTarget {
    /// Offset of the instruction to inline
    pub insn_offset: u32,
    /// Which argument index to replace (in the use instruction)
    pub arg_index: usize,
    /// The SSA variable being replaced
    pub ssa_var: (u16, u32),
}

/// Perform code shrinking - mark single-use variables for inlining
pub fn shrink_code(ssa: &mut SsaResult) -> CodeShrinkResult {
    let mut result = CodeShrinkResult::default();

    // Phase 1: Count uses of each SSA variable
    let use_counts = count_uses(ssa);

    // Phase 2: Find single-use variables and their definitions
    let single_use_defs = find_single_use_defs(ssa, &use_counts);

    // Phase 3: For each block, try to wrap instructions (same-block inlining)
    for block in &mut ssa.blocks {
        shrink_block(block, &single_use_defs, &use_counts, &mut result);
    }

    // Phase 4: Try cross-block inlining for remaining single-use variables
    try_cross_block_inlining(ssa, &single_use_defs, &mut result);

    result
}

/// Shrink a single block by identifying wrappable instructions
fn shrink_block(
    block: &mut crate::ssa::SsaBlock,
    single_use_defs: &HashMap<(u16, u32), DefInfo>,
    _use_counts: &HashMap<(u16, u32), usize>,
    result: &mut CodeShrinkResult,
) {
    // Build list of instruction info for this block
    let insn_count = block.instructions.len();
    if insn_count == 0 {
        return;
    }

    // Track which instructions are in this block by offset
    let block_offsets: HashSet<u32> = block.instructions.iter().map(|i| i.offset).collect();

    // Track inline borders for reordering safety
    let mut inline_borders: HashMap<usize, usize> = HashMap::new();
    for i in 0..insn_count {
        inline_borders.insert(i, i);
    }

    // Collect wrap candidates first (to avoid borrow issues)
    let mut wrap_candidates: Vec<(usize, usize, u32, usize, (u16, u32))> = Vec::new();

    // Process instructions in reverse order (process uses before defs)
    for use_idx in (0..insn_count).rev() {
        let use_insn = &block.instructions[use_idx];
        let use_offset = use_insn.offset;

        // Skip already wrapped or don't-generate instructions
        if use_insn.has_flag(AFlag::Wrapped) || use_insn.has_flag(AFlag::DontGenerate) {
            continue;
        }

        // Get all register arguments from this instruction
        let args = get_register_args(use_insn);

        for (arg_idx, (reg_num, ssa_version)) in args.iter().enumerate() {
            let ssa_var = (*reg_num, *ssa_version);

            // Check if this variable has a single-use definition
            if let Some(def_info) = single_use_defs.get(&ssa_var) {
                // Only inline within same block for now (simpler, safer)
                if !block_offsets.contains(&def_info.insn_offset) {
                    continue;
                }

                // Find the def instruction index in this block
                let def_idx = block.instructions.iter()
                    .position(|i| i.offset == def_info.insn_offset);

                if let Some(def_idx) = def_idx {
                    // Check if we can safely move/inline this instruction
                    if can_inline(block, def_idx, use_idx, &inline_borders) {
                        // Check additional constraints
                        let def_insn = &block.instructions[def_idx];

                        // Don't inline if marked don't-inline
                        if def_insn.has_flag(AFlag::DontInline) {
                            continue;
                        }

                        // Don't inline phi nodes
                        if matches!(def_insn.insn_type, InsnType::Phi { .. }) {
                            continue;
                        }

                        // Check null safety for receivers/arrays
                        if !is_safe_to_inline_at(&block.instructions[use_idx], arg_idx, def_insn) {
                            continue;
                        }

                        // Update inline border
                        inline_borders.insert(use_idx, def_idx);

                        // Record candidate for later processing
                        wrap_candidates.push((def_idx, use_idx, use_offset, arg_idx, ssa_var));
                    }
                }
            }
        }
    }

    // Now apply the wrapping (mutably)
    for (def_idx, _use_idx, use_offset, arg_idx, ssa_var) in wrap_candidates {
        let def_offset = block.instructions[def_idx].offset;
        block.instructions[def_idx].add_flag(AFlag::Wrapped);

        result.wrap_info.insert(use_offset, WrapTarget {
            insn_offset: def_offset,
            arg_index: arg_idx,
            ssa_var,
        });
        result.wrapped_count += 1;
    }
}

/// Check if an instruction at def_idx can be inlined at use_idx
fn can_inline(
    block: &crate::ssa::SsaBlock,
    def_idx: usize,
    use_idx: usize,
    inline_borders: &HashMap<usize, usize>,
) -> bool {
    // Def must come before use
    if def_idx >= use_idx {
        return false;
    }

    // Check inline border
    let border = inline_borders.get(&use_idx).copied().unwrap_or(use_idx);
    if def_idx >= border {
        return false;
    }

    let def_insn = &block.instructions[def_idx];

    // Get registers used by the def instruction
    let def_args = get_register_args(def_insn);
    let def_regs: HashSet<u16> = def_args.iter().map(|(r, _)| *r).collect();

    // Check if the def instruction can be reordered
    let def_can_reorder = can_reorder(def_insn);

    // Check all instructions between def and use
    for i in (def_idx + 1)..use_idx {
        let between = &block.instructions[i];

        // Skip already wrapped instructions
        if between.has_flag(AFlag::Wrapped) {
            continue;
        }

        // If def can't reorder, nothing between can have side effects
        if !def_can_reorder && !can_reorder(between) {
            return false;
        }

        // Check if any instruction between redefines a register used by def
        if let Some(result_reg) = get_result_reg(between) {
            if def_regs.contains(&result_reg.reg_num) {
                return false;
            }
        }
    }

    true
}

/// Check if an instruction can be safely reordered (no side effects)
fn can_reorder(insn: &InsnNode) -> bool {
    match &insn.insn_type {
        // Pure computations - safe to reorder
        InsnType::Const { .. } |
        InsnType::ConstString { .. } |
        InsnType::ConstClass { .. } |
        InsnType::Move { .. } |
        InsnType::MoveResult { .. } |
        InsnType::MoveException { .. } |
        InsnType::Unary { .. } |
        InsnType::Binary { .. } |
        InsnType::Compare { .. } |
        InsnType::Cast { .. } |
        InsnType::InstanceOf { .. } |
        InsnType::ArrayLength { .. } |
        InsnType::Ternary { .. } |
        InsnType::Nop => true,

        // Field reads - generally safe but could have side effects with volatile
        InsnType::InstanceGet { .. } |
        InsnType::StaticGet { .. } => true,

        // Array reads - safe assuming no concurrent modification
        InsnType::ArrayGet { .. } => true,

        // Side effects - cannot reorder
        InsnType::Invoke { .. } |
        InsnType::InvokeCustom { .. } |
        InsnType::InstancePut { .. } |
        InsnType::StaticPut { .. } |
        InsnType::ArrayPut { .. } |
        InsnType::NewInstance { .. } |
        InsnType::NewArray { .. } |
        InsnType::FilledNewArray { .. } |
        InsnType::FillArrayData { .. } |
        InsnType::Throw { .. } |
        InsnType::MonitorEnter { .. } |
        InsnType::MonitorExit { .. } |
        InsnType::CheckCast { .. } => false,

        // Control flow - cannot reorder
        InsnType::If { .. } |
        InsnType::Goto { .. } |
        InsnType::Return { .. } |
        InsnType::PackedSwitch { .. } |
        InsnType::SparseSwitch { .. } |
        InsnType::Break { .. } |
        InsnType::Continue { .. } => false,

        // Phi nodes shouldn't be in instruction list
        InsnType::Phi { .. } => false,
    }
}

/// Check if it's safe to inline def_insn as arg_idx of use_insn
/// (handles null receiver/array safety)
fn is_safe_to_inline_at(use_insn: &InsnNode, arg_idx: usize, def_insn: &InsnNode) -> bool {
    // Check if the def produces a potentially null value
    let could_be_null = match &def_insn.insn_type {
        InsnType::Const { value, .. } => {
            matches!(value, dexterity_ir::instructions::LiteralArg::Null) ||
            matches!(value, dexterity_ir::instructions::LiteralArg::Int(0))
        }
        // Invoke can return null
        InsnType::Invoke { .. } => true,
        // Field gets can be null
        InsnType::InstanceGet { .. } | InsnType::StaticGet { .. } => true,
        // Array gets can be null
        InsnType::ArrayGet { .. } => true,
        // Cast can produce null
        InsnType::Cast { .. } => true,
        _ => false,
    };

    if !could_be_null {
        return true;
    }

    // Check if use position would NPE on null
    match &use_insn.insn_type {
        // Instance receiver must not be null
        InsnType::Invoke { kind, .. } => {
            if arg_idx == 0 && !matches!(kind, InvokeKind::Static) {
                return false;
            }
        }
        // Array base must not be null
        InsnType::ArrayLength { .. } |
        InsnType::ArrayGet { .. } |
        InsnType::ArrayPut { .. } => {
            if arg_idx == 0 {
                return false;
            }
        }
        // Instance field object must not be null
        InsnType::InstanceGet { .. } => {
            if arg_idx == 0 {
                return false;
            }
        }
        InsnType::InstancePut { .. } => {
            // object is arg 1 (value is arg 0)
            if arg_idx == 1 {
                return false;
            }
        }
        // Monitor ops
        InsnType::MonitorEnter { .. } |
        InsnType::MonitorExit { .. } => {
            return false;
        }
        _ => {}
    }

    true
}

/// Information about an instruction definition
#[derive(Debug, Clone)]
struct DefInfo {
    insn_offset: u32,
    block_id: u32,
}

/// Find definitions of single-use variables
fn find_single_use_defs(
    ssa: &SsaResult,
    use_counts: &HashMap<(u16, u32), usize>,
) -> HashMap<(u16, u32), DefInfo> {
    let mut defs = HashMap::new();

    for block in &ssa.blocks {
        for insn in &block.instructions {
            if let Some(dest) = get_result_reg(insn) {
                let key = (dest.reg_num, dest.ssa_version);

                // Only track single-use variables
                if use_counts.get(&key).copied().unwrap_or(0) == 1 {
                    defs.insert(key, DefInfo {
                        insn_offset: insn.offset,
                        block_id: block.id,
                    });
                }
            }
        }
    }

    defs
}

/// Get all register arguments from an instruction
fn get_register_args(insn: &InsnNode) -> Vec<(u16, u32)> {
    let mut args = Vec::new();

    match &insn.insn_type {
        InsnType::Move { src, .. } => {
            if let InsnArg::Register(r) = src {
                args.push((r.reg_num, r.ssa_version));
            }
        }
        InsnType::Return { value: Some(v) } => {
            if let InsnArg::Register(r) = v {
                args.push((r.reg_num, r.ssa_version));
            }
        }
        InsnType::Throw { exception } => {
            if let InsnArg::Register(r) = exception {
                args.push((r.reg_num, r.ssa_version));
            }
        }
        InsnType::InstanceGet { object, .. } => {
            if let InsnArg::Register(r) = object {
                args.push((r.reg_num, r.ssa_version));
            }
        }
        InsnType::InstancePut { value, object, .. } => {
            if let InsnArg::Register(r) = value {
                args.push((r.reg_num, r.ssa_version));
            }
            if let InsnArg::Register(r) = object {
                args.push((r.reg_num, r.ssa_version));
            }
        }
        InsnType::StaticPut { value, .. } => {
            if let InsnArg::Register(r) = value {
                args.push((r.reg_num, r.ssa_version));
            }
        }
        InsnType::Invoke { args: invoke_args, .. } => {
            for arg in invoke_args {
                if let InsnArg::Register(r) = arg {
                    args.push((r.reg_num, r.ssa_version));
                }
            }
        }
        InsnType::Unary { arg, .. } => {
            if let InsnArg::Register(r) = arg {
                args.push((r.reg_num, r.ssa_version));
            }
        }
        InsnType::Binary { left, right, .. } => {
            if let InsnArg::Register(r) = left {
                args.push((r.reg_num, r.ssa_version));
            }
            if let InsnArg::Register(r) = right {
                args.push((r.reg_num, r.ssa_version));
            }
        }
        InsnType::Cast { arg, .. } => {
            if let InsnArg::Register(r) = arg {
                args.push((r.reg_num, r.ssa_version));
            }
        }
        InsnType::Compare { left, right, .. } => {
            if let InsnArg::Register(r) = left {
                args.push((r.reg_num, r.ssa_version));
            }
            if let InsnArg::Register(r) = right {
                args.push((r.reg_num, r.ssa_version));
            }
        }
        InsnType::If { left, right, .. } => {
            if let InsnArg::Register(r) = left {
                args.push((r.reg_num, r.ssa_version));
            }
            if let Some(InsnArg::Register(r)) = right {
                args.push((r.reg_num, r.ssa_version));
            }
        }
        InsnType::NewArray { size, .. } => {
            if let InsnArg::Register(r) = size {
                args.push((r.reg_num, r.ssa_version));
            }
        }
        InsnType::ArrayLength { array, .. } => {
            if let InsnArg::Register(r) = array {
                args.push((r.reg_num, r.ssa_version));
            }
        }
        InsnType::ArrayGet { array, index, .. } => {
            if let InsnArg::Register(r) = array {
                args.push((r.reg_num, r.ssa_version));
            }
            if let InsnArg::Register(r) = index {
                args.push((r.reg_num, r.ssa_version));
            }
        }
        InsnType::ArrayPut { array, index, value, .. } => {
            if let InsnArg::Register(r) = array {
                args.push((r.reg_num, r.ssa_version));
            }
            if let InsnArg::Register(r) = index {
                args.push((r.reg_num, r.ssa_version));
            }
            if let InsnArg::Register(r) = value {
                args.push((r.reg_num, r.ssa_version));
            }
        }
        InsnType::FilledNewArray { args: fill_args, .. } => {
            for arg in fill_args {
                if let InsnArg::Register(r) = arg {
                    args.push((r.reg_num, r.ssa_version));
                }
            }
        }
        InsnType::FillArrayData { array, .. } => {
            if let InsnArg::Register(r) = array {
                args.push((r.reg_num, r.ssa_version));
            }
        }
        InsnType::InstanceOf { object, .. } => {
            if let InsnArg::Register(r) = object {
                args.push((r.reg_num, r.ssa_version));
            }
        }
        InsnType::CheckCast { object, .. } => {
            if let InsnArg::Register(r) = object {
                args.push((r.reg_num, r.ssa_version));
            }
        }
        InsnType::MonitorEnter { object } |
        InsnType::MonitorExit { object } => {
            if let InsnArg::Register(r) = object {
                args.push((r.reg_num, r.ssa_version));
            }
        }
        InsnType::PackedSwitch { value, .. } |
        InsnType::SparseSwitch { value, .. } => {
            if let InsnArg::Register(r) = value {
                args.push((r.reg_num, r.ssa_version));
            }
        }
        _ => {}
    }

    args
}

/// Get the result register of an instruction
fn get_result_reg(insn: &InsnNode) -> Option<&RegisterArg> {
    match &insn.insn_type {
        InsnType::Const { dest, .. } |
        InsnType::Move { dest, .. } |
        InsnType::Unary { dest, .. } |
        InsnType::Binary { dest, .. } |
        InsnType::InstanceGet { dest, .. } |
        InsnType::StaticGet { dest, .. } |
        InsnType::ArrayGet { dest, .. } |
        InsnType::ArrayLength { dest, .. } |
        InsnType::NewInstance { dest, .. } |
        InsnType::NewArray { dest, .. } |
        InsnType::InstanceOf { dest, .. } |
        InsnType::Cast { dest, .. } |
        InsnType::Compare { dest, .. } => Some(dest),
        InsnType::FilledNewArray { dest: Some(dest), .. } => Some(dest),
        _ => None,
    }
}

/// Count uses of each SSA variable
fn count_uses(ssa: &SsaResult) -> HashMap<(u16, u32), usize> {
    let mut counts: HashMap<(u16, u32), usize> = HashMap::new();

    for block in &ssa.blocks {
        // Count uses in phi nodes
        for phi in &block.phi_nodes {
            for (_, src) in &phi.sources {
                *counts.entry((src.reg_num, src.ssa_version)).or_insert(0) += 1;
            }
        }

        // Count uses in instructions
        for insn in &block.instructions {
            for (reg, ver) in get_register_args(insn) {
                *counts.entry((reg, ver)).or_insert(0) += 1;
            }
        }
    }

    counts
}

// =============================================================================
// Cross-Block Inlining Support
// =============================================================================

/// Check if a path exists from one block to another using BFS
fn path_exists(ssa: &SsaResult, from_block: u32, to_block: u32) -> bool {
    if from_block == to_block {
        return true;
    }

    // Build block index for quick lookup
    let block_index: HashMap<u32, usize> = ssa.blocks.iter()
        .enumerate()
        .map(|(i, b)| (b.id, i))
        .collect();

    let mut visited = HashSet::new();
    let mut queue = VecDeque::new();
    queue.push_back(from_block);
    visited.insert(from_block);

    while let Some(block_id) = queue.pop_front() {
        if let Some(&idx) = block_index.get(&block_id) {
            for &succ in &ssa.blocks[idx].successors {
                if succ == to_block {
                    return true;
                }
                if visited.insert(succ) {
                    queue.push_back(succ);
                }
            }
        }
    }

    false
}

/// Get all blocks on the path between two blocks
fn get_path_blocks(ssa: &SsaResult, from_block: u32, to_block: u32) -> HashSet<u32> {
    let mut result = HashSet::new();

    // Build block index for quick lookup
    let block_index: HashMap<u32, usize> = ssa.blocks.iter()
        .enumerate()
        .map(|(i, b)| (b.id, i))
        .collect();

    // BFS to find all reachable blocks from `from_block` that can reach `to_block`
    // First pass: find all blocks reachable from from_block
    let mut forward_reachable = HashSet::new();
    let mut queue = VecDeque::new();
    queue.push_back(from_block);
    forward_reachable.insert(from_block);

    while let Some(block_id) = queue.pop_front() {
        if let Some(&idx) = block_index.get(&block_id) {
            for &succ in &ssa.blocks[idx].successors {
                if forward_reachable.insert(succ) {
                    queue.push_back(succ);
                }
            }
        }
    }

    // Second pass: find all blocks that can reach to_block (backwards)
    let mut backward_reachable = HashSet::new();
    queue.push_back(to_block);
    backward_reachable.insert(to_block);

    while let Some(block_id) = queue.pop_front() {
        if let Some(&idx) = block_index.get(&block_id) {
            for &pred in &ssa.blocks[idx].predecessors {
                if backward_reachable.insert(pred) {
                    queue.push_back(pred);
                }
            }
        }
    }

    // Intersection: blocks on the path are those reachable from `from` AND that can reach `to`
    for block_id in forward_reachable {
        if backward_reachable.contains(&block_id) {
            result.insert(block_id);
        }
    }

    result
}

/// Check if a register is reassigned by an instruction
fn reassigns_reg(insn: &InsnNode, regs: &HashSet<u16>) -> bool {
    if let Some(dest) = get_result_reg(insn) {
        return regs.contains(&dest.reg_num);
    }
    false
}

/// Check if we can safely move an instruction between blocks
///
/// This checks:
/// 1. Path exists from def block to use block
/// 2. All instructions after def in def block are reorderable and don't reassign args
/// 3. All instructions in intermediate blocks are reorderable and don't reassign args
/// 4. All instructions before use in use block are reorderable and don't reassign args
fn can_move_between_blocks(
    ssa: &SsaResult,
    def_info: &DefInfo,
    use_block_id: u32,
    use_insn_offset: u32,
) -> bool {
    let def_block_id = def_info.block_id;
    let def_insn_offset = def_info.insn_offset;

    // If same block, use the existing same-block check
    if def_block_id == use_block_id {
        return true; // Handled by can_inline()
    }

    // Check if path exists
    if !path_exists(ssa, def_block_id, use_block_id) {
        return false;
    }

    // Build block index
    let block_index: HashMap<u32, usize> = ssa.blocks.iter()
        .enumerate()
        .map(|(i, b)| (b.id, i))
        .collect();

    // Find the def instruction and get its argument registers
    let def_block_idx = match block_index.get(&def_block_id) {
        Some(&idx) => idx,
        None => return false,
    };
    let def_block = &ssa.blocks[def_block_idx];

    // Find def instruction and get its argument registers
    let def_insn = def_block.instructions.iter()
        .find(|i| i.offset == def_insn_offset);
    let def_args: HashSet<u16> = match def_insn {
        Some(insn) => get_register_args(insn).iter().map(|(r, _)| *r).collect(),
        None => return false,
    };

    // Check instructions after def in the def block
    let mut found_def = false;
    for insn in &def_block.instructions {
        if insn.offset == def_insn_offset {
            found_def = true;
            continue;
        }
        if found_def {
            // Check instructions after def
            if !can_reorder(insn) || reassigns_reg(insn, &def_args) {
                return false;
            }
        }
    }

    // Get all blocks on the path (excluding def and use blocks)
    let path_blocks = get_path_blocks(ssa, def_block_id, use_block_id);

    // Check all intermediate blocks
    for &block_id in &path_blocks {
        if block_id == def_block_id || block_id == use_block_id {
            continue;
        }

        let block_idx = match block_index.get(&block_id) {
            Some(&idx) => idx,
            None => continue,
        };
        let block = &ssa.blocks[block_idx];

        // Check if this is a synchronized region exit (MONITOR_EXIT)
        let has_monitor_exit = block.instructions.iter()
            .any(|i| matches!(i.insn_type, InsnType::MonitorExit { .. }));

        if has_monitor_exit {
            // Don't move across synchronized region boundary
            return false;
        }

        // Skip blocks marked don't-generate
        if block.instructions.iter().any(|i| i.has_flag(AFlag::DontGenerate)) {
            continue;
        }

        // Check all instructions in intermediate blocks
        for insn in &block.instructions {
            if !can_reorder(insn) || reassigns_reg(insn, &def_args) {
                return false;
            }
        }
    }

    // Check instructions before use in the use block
    let use_block_idx = match block_index.get(&use_block_id) {
        Some(&idx) => idx,
        None => return false,
    };
    let use_block = &ssa.blocks[use_block_idx];

    for insn in &use_block.instructions {
        if insn.offset == use_insn_offset {
            // Reached the use instruction - we're done
            return true;
        }
        // Check instructions before use
        if !can_reorder(insn) || reassigns_reg(insn, &def_args) {
            return false;
        }
    }

    // Use instruction not found in use block (shouldn't happen)
    false
}

/// Try to inline cross-block for the entire SSA result
fn try_cross_block_inlining(
    ssa: &mut SsaResult,
    single_use_defs: &HashMap<(u16, u32), DefInfo>,
    result: &mut CodeShrinkResult,
) {
    // Collect cross-block wrap candidates
    // (def_block_id, def_idx, use_block_id, use_idx, use_offset, arg_idx, ssa_var)
    let mut wrap_candidates: Vec<(u32, usize, u32, usize, u32, usize, (u16, u32))> = Vec::new();

    // Build block index
    let block_index: HashMap<u32, usize> = ssa.blocks.iter()
        .enumerate()
        .map(|(i, b)| (b.id, i))
        .collect();

    // For each block, check uses that reference definitions in other blocks
    for use_block in &ssa.blocks {
        let use_block_id = use_block.id;

        for (use_idx, use_insn) in use_block.instructions.iter().enumerate() {
            // Skip already wrapped instructions
            if use_insn.has_flag(AFlag::Wrapped) || use_insn.has_flag(AFlag::DontGenerate) {
                continue;
            }

            let args = get_register_args(use_insn);

            for (arg_idx, (reg_num, ssa_version)) in args.iter().enumerate() {
                let ssa_var = (*reg_num, *ssa_version);

                // Check if this variable has a single-use definition
                if let Some(def_info) = single_use_defs.get(&ssa_var) {
                    // Only consider cross-block (same-block handled in shrink_block)
                    if def_info.block_id == use_block_id {
                        continue;
                    }

                    // Check if we can move between blocks
                    if !can_move_between_blocks(ssa, def_info, use_block_id, use_insn.offset) {
                        continue;
                    }

                    // Find def block and instruction
                    let def_block_idx = match block_index.get(&def_info.block_id) {
                        Some(&idx) => idx,
                        None => continue,
                    };
                    let def_block = &ssa.blocks[def_block_idx];

                    let def_idx = match def_block.instructions.iter()
                        .position(|i| i.offset == def_info.insn_offset) {
                        Some(idx) => idx,
                        None => continue,
                    };

                    let def_insn = &def_block.instructions[def_idx];

                    // Don't inline if marked don't-inline
                    if def_insn.has_flag(AFlag::DontInline) {
                        continue;
                    }

                    // Don't inline phi nodes
                    if matches!(def_insn.insn_type, InsnType::Phi { .. }) {
                        continue;
                    }

                    // Check null safety
                    if !is_safe_to_inline_at(use_insn, arg_idx, def_insn) {
                        continue;
                    }

                    // Check lambda inline restriction
                    if !check_lambda_inline(def_insn, use_insn, arg_idx) {
                        continue;
                    }

                    wrap_candidates.push((
                        def_info.block_id,
                        def_idx,
                        use_block_id,
                        use_idx,
                        use_insn.offset,
                        arg_idx,
                        ssa_var,
                    ));
                }
            }
        }
    }

    // Apply cross-block wrapping
    // Need to rebuild block index since we're mutating
    let block_index: HashMap<u32, usize> = ssa.blocks.iter()
        .enumerate()
        .map(|(i, b)| (b.id, i))
        .collect();

    for (def_block_id, def_idx, _use_block_id, _use_idx, use_offset, arg_idx, ssa_var) in wrap_candidates {
        if let Some(&block_idx) = block_index.get(&def_block_id) {
            let def_offset = ssa.blocks[block_idx].instructions[def_idx].offset;
            ssa.blocks[block_idx].instructions[def_idx].add_flag(AFlag::Wrapped);

            result.wrap_info.insert(use_offset, WrapTarget {
                insn_offset: def_offset,
                arg_index: arg_idx,
                ssa_var,
            });
            result.wrapped_count += 1;
        }
    }
}

/// Check lambda inline restriction - forbid inlining lambda as instance arg to invoke
/// This prevents invalid patterns like: () -> { ... }.apply();
fn check_lambda_inline(_def_insn: &InsnNode, use_insn: &InsnNode, arg_idx: usize) -> bool {
    // Check if def is InvokeCustom (lambda)
    // Note: Dexterity doesn't have a specific InvokeCustom type, but lambdas are
    // typically represented as invoke-custom or invoke-interface on functional interfaces
    // For now, we'll be conservative and allow all - this can be refined later

    // If use is an invoke with this as the instance arg (arg 0 for non-static), reject
    if let InsnType::Invoke { kind, .. } = &use_insn.insn_type {
        if arg_idx == 0 && !matches!(kind, InvokeKind::Static) {
            // Check if def is a lambda-like pattern
            // For now, we'll skip this restriction and rely on null safety checks
            // TODO: Add proper InvokeCustom detection when available
        }
    }

    true
}

#[cfg(test)]
mod tests {
    use super::*;
    use dexterity_ir::instructions::{BinaryOp, LiteralArg};
    use rustc_hash::{FxHashMap, FxHashSet};

    fn make_ssa_block(id: u32, insns: Vec<InsnNode>) -> crate::ssa::SsaBlock {
        crate::ssa::SsaBlock {
            id,
            instructions: insns,
            phi_nodes: vec![],
            successors: vec![],
            predecessors: vec![],
        }
    }

    #[test]
    fn test_can_reorder_pure() {
        // Pure computations can be reordered
        let insn = InsnNode::new(
            InsnType::Binary {
                dest: RegisterArg::new(0),
                op: BinaryOp::Add,
                left: InsnArg::reg(1),
                right: InsnArg::reg(2),
            },
            0,
        );
        assert!(can_reorder(&insn));
    }

    #[test]
    fn test_cannot_reorder_invoke() {
        // Method calls cannot be reordered
        let insn = InsnNode::new(
            InsnType::Invoke {
                kind: InvokeKind::Virtual,
                method_idx: 0,
                args: vec![InsnArg::reg(0)],
                proto_idx: None,
            },
            0,
        );
        assert!(!can_reorder(&insn));
    }

    #[test]
    fn test_null_safety_receiver() {
        // Invoking on potentially null is unsafe
        let use_insn = InsnNode::new(
            InsnType::Invoke {
                kind: InvokeKind::Virtual,
                method_idx: 0,
                args: vec![InsnArg::reg(0)],
                proto_idx: None,
            },
            1,
        );
        let def_insn = InsnNode::new(
            InsnType::InstanceGet {
                dest: RegisterArg::new(0),
                object: InsnArg::reg(1),
                field_idx: 0,
            },
            0,
        );

        // arg_idx 0 is the receiver for virtual invoke
        assert!(!is_safe_to_inline_at(&use_insn, 0, &def_insn));
    }

    #[test]
    fn test_null_safety_non_receiver() {
        // Non-receiver args can accept null
        let use_insn = InsnNode::new(
            InsnType::Invoke {
                kind: InvokeKind::Virtual,
                method_idx: 0,
                args: vec![InsnArg::reg(0), InsnArg::reg(1)],
                proto_idx: None,
            },
            1,
        );
        let def_insn = InsnNode::new(
            InsnType::Const {
                dest: RegisterArg::new(1),
                value: LiteralArg::Null,
            },
            0,
        );

        // arg_idx 1 is not the receiver
        assert!(is_safe_to_inline_at(&use_insn, 1, &def_insn));
    }

    #[test]
    fn test_count_uses() {
        let block = make_ssa_block(0, vec![
            InsnNode::new(
                InsnType::Const {
                    dest: RegisterArg::with_ssa(0, 0),
                    value: LiteralArg::Int(10),
                },
                0,
            ),
            InsnNode::new(
                InsnType::Binary {
                    dest: RegisterArg::with_ssa(1, 0),
                    op: BinaryOp::Add,
                    left: InsnArg::Register(RegisterArg::with_ssa(0, 0)),
                    right: InsnArg::Literal(LiteralArg::Int(5)),
                },
                1,
            ),
        ]);

        let ssa = SsaResult {
            blocks: vec![block],
            dominators: FxHashMap::default(),
            dom_frontiers: FxHashMap::default(),
            max_versions: FxHashMap::default(),
        };

        let counts = count_uses(&ssa);
        // v0_0 should be used once (in the binary op)
        assert_eq!(counts.get(&(0, 0)), Some(&1));
    }
}
