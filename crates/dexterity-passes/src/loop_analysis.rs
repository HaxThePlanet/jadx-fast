//! Loop pattern analysis for indexed for-loops and array for-each
//!
//! This module analyzes loop structures at the SSA level to detect:
//! - Indexed for-loops: `for (int i = 0; i < N; i++)`
//! - Array for-each: `for (T elem : array)`
//!
//! Based on JADX's LoopRegionVisitor patterns.

use std::collections::{HashMap, HashSet};
use dexterity_ir::instructions::{BinaryOp, InsnArg, InsnNode, InsnType, InvokeKind, LiteralArg, RegisterArg};
use dexterity_ir::regions::LoopKind;
use crate::ssa::SsaResult;
use crate::loops::LoopInfo;

/// Information about a detected for-loop pattern
#[derive(Debug, Clone)]
pub struct ForLoopPattern {
    /// The loop header block
    pub header: u32,
    /// Initialization instruction (e.g., i = 0)
    pub init_insn_offset: u32,
    /// Increment instruction (e.g., i++)
    pub incr_insn_offset: u32,
    /// The loop variable register (i)
    pub loop_var: (u16, u32), // (reg_num, ssa_version)
    /// Upper bound if detectable
    pub upper_bound: Option<UpperBound>,
}

/// Upper bound for a for-loop
#[derive(Debug, Clone)]
pub enum UpperBound {
    /// Constant value
    Literal(i64),
    /// Array length
    ArrayLength { array_reg: (u16, u32) },
    /// Other register
    Register { reg: (u16, u32) },
}

/// Information about a detected array for-each pattern
#[derive(Debug, Clone)]
pub struct ArrayForEachPattern {
    /// The loop header block
    pub header: u32,
    /// The array being iterated
    pub array_reg: (u16, u32),
    /// The element variable (assigned from arr[i])
    pub elem_var: (u16, u32),
    /// The index variable
    pub index_var: (u16, u32),
    /// Array get instruction offset
    pub aget_offset: u32,
}

/// Result of loop pattern analysis
#[derive(Debug, Default)]
pub struct LoopPatternResult {
    /// Detected indexed for-loops
    pub for_loops: Vec<ForLoopPattern>,
    /// Detected array for-each patterns
    pub array_for_each: Vec<ArrayForEachPattern>,
    /// Detected iterator for-each patterns (Iterable.iterator/hasNext/next)
    pub iterator_for_each: Vec<IteratorForEachPattern>,
    /// Map of loop header to detected kind
    pub loop_kinds: HashMap<u32, LoopKind>,
}

/// Analyze loops for for-loop and for-each patterns
pub fn analyze_loop_patterns(ssa: &SsaResult, loops: &[LoopInfo]) -> LoopPatternResult {
    let mut result = LoopPatternResult::default();

    // Build a map of (reg, version) -> defining instruction
    let mut def_map: HashMap<(u16, u32), &InsnNode> = HashMap::new();
    for block in &ssa.blocks {
        for insn in &block.instructions {
            if let Some(dest) = get_result_reg(insn) {
                def_map.insert((dest.reg_num, dest.ssa_version), insn);
            }
        }
    }

    // Build a map of (reg, version) -> use count
    let use_counts = count_uses(ssa);

    // Build use locations for JADX validation (usedOnlyInLoop)
    let use_locations = build_use_locations(ssa);

    // Build def locations for JADX validation (assignOnlyInLoop)
    let def_locations = build_def_locations(ssa);

    for loop_info in loops {
        // Try to detect indexed for-loop pattern with JADX validations
        if let Some(for_pattern) = detect_indexed_for(
            ssa, loop_info, &def_map, &use_counts, &use_locations, &def_locations
        ) {
            // Check if it's actually an array for-each
            if let Some(foreach_pattern) = detect_array_foreach(ssa, &for_pattern, &def_map, &use_counts) {
                result.array_for_each.push(foreach_pattern);
                result.loop_kinds.insert(loop_info.header, LoopKind::ForEach);
                continue;
            } else {
                result.for_loops.push(for_pattern);
                result.loop_kinds.insert(loop_info.header, LoopKind::For);
                continue;
            }
        }

        // Try iterator for-each pattern (Iterable.iterator/hasNext/next)
        // JADX Reference: LoopRegionVisitor.checkIterableForEach()
        if let Some(iter_pattern) = detect_iterator_foreach(ssa, loop_info, &def_map, &use_locations) {
            result.iterator_for_each.push(iter_pattern);
            result.loop_kinds.insert(loop_info.header, LoopKind::ForEach);
            continue;
        }

        // Default: while loop (no pattern detected)
        result.loop_kinds.insert(loop_info.header, LoopKind::While);
    }

    result
}

/// Try to detect an indexed for-loop pattern
/// Matches JADX LoopRegionVisitor.checkForIndexedLoop()
fn detect_indexed_for(
    ssa: &SsaResult,
    loop_info: &LoopInfo,
    def_map: &HashMap<(u16, u32), &InsnNode>,
    use_counts: &HashMap<(u16, u32), usize>,
    use_locations: &HashMap<(u16, u32), Vec<u32>>,
    def_locations: &HashMap<(u16, u32), (u32, u32)>,
) -> Option<ForLoopPattern> {
    // Find the header block
    let header_block = ssa.blocks.iter().find(|b| b.id == loop_info.header)?;

    // Look for an IF instruction at the end of the header (loop condition)
    let condition_insn = header_block.instructions.iter()
        .find(|i| matches!(&i.insn_type, InsnType::If { .. }))?;

    // Get the condition arguments
    let (cond_left, cond_right) = match &condition_insn.insn_type {
        InsnType::If { left, right, .. } => (left, right.as_ref()),
        _ => return None,
    };

    // The left side should be a register (the loop variable)
    let loop_var = match cond_left {
        InsnArg::Register(reg) => (reg.reg_num, reg.ssa_version),
        _ => return None,
    };

    // Check if there's a phi node for this variable in the header
    let phi_for_var = header_block.phi_nodes.iter()
        .find(|phi| phi.dest.reg_num == loop_var.0)?;

    // JADX: phiInsn.getArgsCount() != 2
    // PHI must have exactly 2 arguments: init from outside + back-edge from loop
    if phi_for_var.sources.len() != 2 {
        return None;
    }

    // Get one of the phi sources as the initial value (from outside the loop)
    let init_source = phi_for_var.sources.iter()
        .find(|(pred, _)| !loop_info.blocks.contains(pred))?;

    // Get the initialization instruction
    let init_insn = def_map.get(&(init_source.1.reg_num, init_source.1.ssa_version))?;

    // Init should be a CONST 0 (or other small constant for some loops)
    let is_zero_init = matches!(&init_insn.insn_type,
        InsnType::Const { value: LiteralArg::Int(0), .. }
    );

    if !is_zero_init {
        return None;
    }

    // Find the increment instruction in the loop body
    // It should be an ADD with literal 1
    let incr_insn = find_increment_insn(ssa, loop_info, loop_var)?;

    // Get the increment result register
    let incr_result = get_result_reg(incr_insn)?;
    let incr_var = (incr_result.reg_num, incr_result.ssa_version);

    // JADX: incrArg.getSVar().getUseCount() != 1
    // Increment result should be used only once (in the PHI node)
    let incr_uses = use_counts.get(&incr_var).copied().unwrap_or(0);
    if incr_uses != 1 {
        return None;
    }

    // JADX: !usedOnlyInLoop(mth, loopRegion, arg)
    // The loop variable must not escape the loop
    if !used_only_in_loop(loop_info, loop_var, use_locations) {
        return None;
    }

    // JADX: can't make loop if argument from increment instruction is assigned in loop
    // Check that increment operands are not reassigned within the loop
    let incr_args = get_register_args(incr_insn);
    for arg in incr_args {
        // Skip the loop variable itself (it's expected to be assigned)
        if arg.0 == loop_var.0 {
            continue;
        }
        let mut visited = HashSet::new();
        if assign_only_in_loop(ssa, loop_info, arg, def_locations, &mut visited) {
            // If the argument is assigned only in the loop, this is problematic
            // because it means the increment depends on a value that changes in the loop
            return None;
        }
    }

    // Determine the upper bound
    let upper_bound = match cond_right {
        Some(InsnArg::Literal(LiteralArg::Int(n))) => Some(UpperBound::Literal(*n)),
        Some(InsnArg::Register(reg)) => {
            // Check if it's array.length
            if let Some(len_insn) = def_map.get(&(reg.reg_num, reg.ssa_version)) {
                if let InsnType::ArrayLength { array, .. } = &len_insn.insn_type {
                    if let InsnArg::Register(arr_reg) = array {
                        Some(UpperBound::ArrayLength {
                            array_reg: (arr_reg.reg_num, arr_reg.ssa_version),
                        })
                    } else {
                        Some(UpperBound::Register {
                            reg: (reg.reg_num, reg.ssa_version),
                        })
                    }
                } else {
                    Some(UpperBound::Register {
                        reg: (reg.reg_num, reg.ssa_version),
                    })
                }
            } else {
                Some(UpperBound::Register {
                    reg: (reg.reg_num, reg.ssa_version),
                })
            }
        }
        None => None,
        _ => None, // Other InsnArg types (Type, Field, Method, etc.)
    };

    Some(ForLoopPattern {
        header: loop_info.header,
        init_insn_offset: init_insn.offset,
        incr_insn_offset: incr_insn.offset,
        loop_var,
        upper_bound,
    })
}

/// Detect if an indexed for-loop is actually an array for-each
fn detect_array_foreach(
    ssa: &SsaResult,
    for_pattern: &ForLoopPattern,
    _def_map: &HashMap<(u16, u32), &InsnNode>,
    use_counts: &HashMap<(u16, u32), usize>,
) -> Option<ArrayForEachPattern> {
    // Must have array length as upper bound
    let array_reg = match &for_pattern.upper_bound {
        Some(UpperBound::ArrayLength { array_reg }) => *array_reg,
        _ => return None,
    };

    // The loop variable should be used exactly 3 times:
    // 1. In the IF condition
    // 2. In an AGET instruction
    // 3. In the increment
    let loop_var_uses = use_counts.get(&for_pattern.loop_var).copied().unwrap_or(0);
    if loop_var_uses != 3 {
        return None;
    }

    // Find the AGET instruction that uses the loop variable as index
    let mut aget_info: Option<(u32, (u16, u32))> = None;

    for block in &ssa.blocks {
        for insn in &block.instructions {
            if let InsnType::ArrayGet { dest, array, index, .. } = &insn.insn_type {
                if let InsnArg::Register(idx_reg) = index {
                    if (idx_reg.reg_num, idx_reg.ssa_version) == for_pattern.loop_var {
                        // Check if the array matches
                        if let InsnArg::Register(arr_reg) = array {
                            if (arr_reg.reg_num, arr_reg.ssa_version) == array_reg {
                                aget_info = Some((insn.offset, (dest.reg_num, dest.ssa_version)));
                            }
                        }
                    }
                }
            }
        }
    }

    let (aget_offset, elem_var) = aget_info?;

    Some(ArrayForEachPattern {
        header: for_pattern.header,
        array_reg,
        elem_var,
        index_var: for_pattern.loop_var,
        aget_offset,
    })
}

/// Find the increment instruction for a loop variable
fn find_increment_insn<'a>(
    ssa: &'a SsaResult,
    loop_info: &LoopInfo,
    loop_var: (u16, u32),
) -> Option<&'a InsnNode> {
    for block_id in &loop_info.blocks {
        if let Some(block) = ssa.blocks.iter().find(|b| b.id == *block_id) {
            for insn in &block.instructions {
                // Look for ADD instruction: v = loop_var + 1
                if let InsnType::Binary { dest, op: BinaryOp::Add, left, right, .. } = &insn.insn_type {
                    // Check if result is assigned to the same register (different SSA version)
                    if dest.reg_num == loop_var.0 {
                        // Check if left operand is the loop variable
                        if let InsnArg::Register(left_reg) = left {
                            if (left_reg.reg_num, left_reg.ssa_version) == loop_var {
                                // Check if right operand is literal 1
                                if matches!(right, InsnArg::Literal(LiteralArg::Int(1))) {
                                    return Some(insn);
                                }
                            }
                        }
                    }
                }
            }
        }
    }
    None
}

/// Get the result register of an instruction, if any
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
            count_insn_uses_inner(insn, &mut counts);
        }
    }

    counts
}

fn count_insn_uses_inner(insn: &InsnNode, counts: &mut HashMap<(u16, u32), usize>) {
    // Helper to count a single arg
    let mut count_arg = |arg: &InsnArg| {
        if let InsnArg::Register(reg) = arg {
            *counts.entry((reg.reg_num, reg.ssa_version)).or_insert(0) += 1;
        }
    };

    match &insn.insn_type {
        InsnType::Move { src, .. } => count_arg(src),
        InsnType::Return { value: Some(v) } => count_arg(v),
        InsnType::Throw { exception } => count_arg(exception),
        InsnType::InstanceGet { object, .. } => count_arg(object),
        InsnType::InstancePut { object, value, .. } => {
            count_arg(object);
            count_arg(value);
        }
        InsnType::StaticPut { value, .. } => count_arg(value),
        InsnType::Invoke { args, .. } => {
            for arg in args {
                count_arg(arg);
            }
        }
        InsnType::Unary { arg, .. } => count_arg(arg),
        InsnType::Binary { left, right, .. } => {
            count_arg(left);
            count_arg(right);
        }
        InsnType::Cast { arg, .. } => count_arg(arg),
        InsnType::Compare { left, right, .. } => {
            count_arg(left);
            count_arg(right);
        }
        InsnType::If { left, right, .. } => {
            count_arg(left);
            if let Some(r) = right {
                count_arg(r);
            }
        }
        InsnType::NewArray { size, .. } => count_arg(size),
        InsnType::ArrayLength { array, .. } => count_arg(array),
        InsnType::ArrayGet { array, index, .. } => {
            count_arg(array);
            count_arg(index);
        }
        InsnType::ArrayPut { array, index, value, .. } => {
            count_arg(array);
            count_arg(index);
            count_arg(value);
        }
        InsnType::FilledNewArray { args, .. } => {
            for arg in args {
                count_arg(arg);
            }
        }
        InsnType::FillArrayData { array, .. } => count_arg(array),
        InsnType::InstanceOf { object, .. } => count_arg(object),
        InsnType::CheckCast { object, .. } => count_arg(object),
        InsnType::MonitorEnter { object } => count_arg(object),
        InsnType::MonitorExit { object } => count_arg(object),
        InsnType::PackedSwitch { value, .. } => count_arg(value),
        InsnType::SparseSwitch { value, .. } => count_arg(value),
        _ => {}
    }
}

// =============================================================================
// JADX LoopRegionVisitor Validation Helpers
// =============================================================================

/// Build map of (reg, version) -> [block_ids where used]
pub fn build_use_locations(ssa: &SsaResult) -> HashMap<(u16, u32), Vec<u32>> {
    let mut locations: HashMap<(u16, u32), Vec<u32>> = HashMap::new();

    for block in &ssa.blocks {
        for phi in &block.phi_nodes {
            for (_, src) in &phi.sources {
                locations.entry((src.reg_num, src.ssa_version))
                    .or_default()
                    .push(block.id);
            }
        }
        for insn in &block.instructions {
            collect_insn_use_locations(insn, block.id, &mut locations);
        }
    }
    locations
}

fn collect_insn_use_locations(insn: &InsnNode, block_id: u32, locations: &mut HashMap<(u16, u32), Vec<u32>>) {
    let mut add_use = |arg: &InsnArg| {
        if let InsnArg::Register(reg) = arg {
            locations.entry((reg.reg_num, reg.ssa_version))
                .or_default()
                .push(block_id);
        }
    };

    match &insn.insn_type {
        InsnType::Move { src, .. } => add_use(src),
        InsnType::Return { value: Some(v) } => add_use(v),
        InsnType::Throw { exception } => add_use(exception),
        InsnType::InstanceGet { object, .. } => add_use(object),
        InsnType::InstancePut { object, value, .. } => { add_use(object); add_use(value); }
        InsnType::StaticPut { value, .. } => add_use(value),
        InsnType::Invoke { args, .. } => { for arg in args { add_use(arg); } }
        InsnType::Unary { arg, .. } => add_use(arg),
        InsnType::Binary { left, right, .. } => { add_use(left); add_use(right); }
        InsnType::Cast { arg, .. } => add_use(arg),
        InsnType::Compare { left, right, .. } => { add_use(left); add_use(right); }
        InsnType::If { left, right, .. } => { add_use(left); if let Some(r) = right { add_use(r); } }
        InsnType::NewArray { size, .. } => add_use(size),
        InsnType::ArrayLength { array, .. } => add_use(array),
        InsnType::ArrayGet { array, index, .. } => { add_use(array); add_use(index); }
        InsnType::ArrayPut { array, index, value, .. } => { add_use(array); add_use(index); add_use(value); }
        InsnType::FilledNewArray { args, .. } => { for arg in args { add_use(arg); } }
        InsnType::FillArrayData { array, .. } => add_use(array),
        InsnType::InstanceOf { object, .. } => add_use(object),
        InsnType::CheckCast { object, .. } => add_use(object),
        InsnType::MonitorEnter { object } => add_use(object),
        InsnType::MonitorExit { object } => add_use(object),
        InsnType::PackedSwitch { value, .. } => add_use(value),
        InsnType::SparseSwitch { value, .. } => add_use(value),
        _ => {}
    }
}

/// Check if a variable is used only inside the loop region.
pub fn used_only_in_loop(
    loop_info: &LoopInfo,
    var: (u16, u32),
    use_locations: &HashMap<(u16, u32), Vec<u32>>,
) -> bool {
    if let Some(block_ids) = use_locations.get(&var) {
        for block_id in block_ids {
            if !loop_info.blocks.contains(block_id) {
                return false;
            }
        }
        true
    } else {
        true
    }
}

/// Check if a variable is assigned only inside the loop.
pub fn assign_only_in_loop(
    ssa: &SsaResult,
    loop_info: &LoopInfo,
    var: (u16, u32),
    def_map: &HashMap<(u16, u32), (u32, u32)>,
    visited: &mut HashSet<(u16, u32)>,
) -> bool {
    if visited.contains(&var) { return true; }
    visited.insert(var);

    if let Some((def_block_id, _)) = def_map.get(&var) {
        if !loop_info.blocks.contains(def_block_id) {
            return false;
        }
    }

    for block in &ssa.blocks {
        for phi in &block.phi_nodes {
            if phi.dest.reg_num == var.0 && phi.dest.ssa_version == var.1 {
                for (pred_block, source) in &phi.sources {
                    if loop_info.blocks.contains(pred_block) {
                        let source_var = (source.reg_num, source.ssa_version);
                        if !assign_only_in_loop(ssa, loop_info, source_var, def_map, visited) {
                            return false;
                        }
                    }
                }
            }
        }
    }
    true
}

/// Build map of (reg, version) -> (block_id, offset) for definitions
pub fn build_def_locations(ssa: &SsaResult) -> HashMap<(u16, u32), (u32, u32)> {
    let mut def_locs: HashMap<(u16, u32), (u32, u32)> = HashMap::new();

    for block in &ssa.blocks {
        for phi in &block.phi_nodes {
            def_locs.insert((phi.dest.reg_num, phi.dest.ssa_version), (block.id, 0));
        }
        for insn in &block.instructions {
            if let Some(dest) = get_result_reg(insn) {
                def_locs.insert((dest.reg_num, dest.ssa_version), (block.id, insn.offset));
            }
        }
    }
    def_locs
}

/// Get register arguments from an instruction
pub fn get_register_args(insn: &InsnNode) -> Vec<(u16, u32)> {
    let mut args = Vec::new();
    let mut add_arg = |arg: &InsnArg| {
        if let InsnArg::Register(reg) = arg {
            args.push((reg.reg_num, reg.ssa_version));
        }
    };

    match &insn.insn_type {
        InsnType::Binary { left, right, .. } => { add_arg(left); add_arg(right); }
        InsnType::Unary { arg, .. } => add_arg(arg),
        InsnType::Move { src, .. } => add_arg(src),
        _ => {}
    }
    args
}

// =============================================================================
// Iterator For-Each Detection
// =============================================================================
// JADX Reference: LoopRegionVisitor.checkIterableForEach()
// See: jadx-fast/jadx-core/src/main/java/jadx/core/dex/visitors/regions/LoopRegionVisitor.java

/// Information about a detected iterator for-each pattern
///
/// JADX Reference: ForEachLoop for Iterable
#[derive(Debug, Clone)]
pub struct IteratorForEachPattern {
    /// The loop header block
    pub header: u32,
    /// The iterable collection being iterated
    pub iterable_reg: (u16, u32),
    /// The iterator variable (from .iterator() call)
    pub iterator_reg: (u16, u32),
    /// The element variable (from .next() call, or from CheckCast if present)
    pub elem_var: (u16, u32),
    /// Type index from CheckCast (if element is cast to specific type)
    /// Used to get proper element type like "String" instead of "Object"
    pub cast_type_idx: Option<u32>,
    /// Offset of the iterator() call
    pub iterator_call_offset: u32,
    /// Offset of the hasNext() call (in condition)
    pub has_next_offset: u32,
    /// Offset of the next() call (in body)
    pub next_call_offset: u32,
}

/// Detect iterator for-each pattern
///
/// JADX Reference: LoopRegionVisitor.checkIterableForEach()
///
/// Pattern:
/// ```java
/// Iterator iter = collection.iterator();
/// while (iter.hasNext()) {
///     Type elem = iter.next();
///     // body
/// }
/// ```
///
/// Becomes:
/// ```java
/// for (Type elem : collection) {
///     // body
/// }
/// ```
pub fn detect_iterator_foreach(
    ssa: &SsaResult,
    loop_info: &LoopInfo,
    def_map: &HashMap<(u16, u32), &InsnNode>,
    use_locations: &HashMap<(u16, u32), Vec<u32>>,
) -> Option<IteratorForEachPattern> {
    // Find the header block
    let header_block = ssa.blocks.iter().find(|b| b.id == loop_info.header)?;

    // Look for IF instruction in condition (the hasNext() check)
    let condition_insn = header_block.instructions.iter()
        .find(|i| matches!(&i.insn_type, InsnType::If { .. }))?;

    // Get the condition argument - should be hasNext() result
    let cond_arg = match &condition_insn.insn_type {
        InsnType::If { left, .. } => left,
        _ => return None,
    };

    // The condition should use a single register (result of hasNext())
    let has_next_result = match cond_arg {
        InsnArg::Register(reg) => (reg.reg_num, reg.ssa_version),
        _ => return None,
    };

    // Find the hasNext() call
    let has_next_insn = def_map.get(&has_next_result)?;
    if !is_has_next_call(has_next_insn, None) {
        return None;
    }

    // Get the iterator variable from hasNext() call
    let iterator_reg = get_invoke_receiver(has_next_insn)?;

    // Find the iterator() call that created this iterator
    let iterator_assign = def_map.get(&iterator_reg)?;
    if !is_iterator_call(iterator_assign, None) {
        return None;
    }

    // Get the iterable collection
    let iterable_reg = get_invoke_receiver(iterator_assign)?;

    // Iterator should be used exactly twice: hasNext() and next()
    let iterator_uses = use_locations.get(&iterator_reg)?;
    if iterator_uses.len() != 2 {
        return None;
    }

    // Find the next() call in the loop body
    let next_call = find_next_call(ssa, loop_info, iterator_reg)?;

    // Get the element variable from next() result
    let next_result = get_invoke_result(&next_call)?;

    // GAP-06 FIX: Look for CheckCast after next() to get proper element type
    // Pattern: Object tmp = iter.next(); String elem = (String) tmp;
    // We want to use 'elem' as the element variable with its proper type
    let (elem_var, cast_type_idx) = find_checkcast_after_next(ssa, loop_info, next_result)
        .unwrap_or((next_result, None));

    // Verify element is used only in loop
    if !used_only_in_loop(loop_info, elem_var, use_locations) {
        return None;
    }

    Some(IteratorForEachPattern {
        header: loop_info.header,
        iterable_reg,
        iterator_reg,
        elem_var,
        cast_type_idx,
        iterator_call_offset: iterator_assign.offset,
        has_next_offset: has_next_insn.offset,
        next_call_offset: next_call.offset,
    })
}

/// Find CheckCast instruction that uses the next() result
/// Returns (casted_var, type_idx) if found, or None
///
/// Note: In Dalvik, CheckCast modifies the object in-place, so the "result"
/// is the same register with potentially a new SSA version
fn find_checkcast_after_next(
    ssa: &SsaResult,
    loop_info: &LoopInfo,
    next_result: (u16, u32),
) -> Option<((u16, u32), Option<u32>)> {
    for block_id in &loop_info.blocks {
        if let Some(block) = ssa.blocks.iter().find(|b| b.id == *block_id) {
            for insn in &block.instructions {
                if let InsnType::CheckCast { object, type_idx } = &insn.insn_type {
                    // Check if this CheckCast uses the next() result
                    if let InsnArg::Register(reg) = object {
                        if (reg.reg_num, reg.ssa_version) == next_result {
                            // Found it! CheckCast modifies in-place, so the element
                            // variable is the same register. Return the type_idx for
                            // proper type resolution.
                            return Some((next_result, Some(*type_idx)));
                        }
                    }
                }
            }
        }
    }
    None
}

/// Method name resolver type for checking method calls
///
/// Takes a method_idx and returns the method name if resolvable.
pub type MethodNameResolver<'a> = &'a dyn Fn(u32) -> Option<String>;

/// Check if an instruction is a .hasNext() call
///
/// JADX Reference: checkInvoke(insn, "java.util.Iterator", "hasNext()Z")
///
/// Note: Full check requires a method resolver. Returns true if:
/// - It's a virtual/interface invoke
/// - Method name (if resolvable) is "hasNext"
fn is_has_next_call(insn: &InsnNode, method_resolver: Option<MethodNameResolver>) -> bool {
    if let InsnType::Invoke { method_idx, kind, .. } = &insn.insn_type {
        if !matches!(kind, InvokeKind::Virtual | InvokeKind::Interface) {
            return false;
        }
        if let Some(resolver) = method_resolver {
            if let Some(name) = resolver(*method_idx) {
                return name == "hasNext";
            }
        }
        // Without resolver, can't determine - return false
        false
    } else {
        false
    }
}

/// Check if an instruction is a .iterator() call
///
/// JADX Reference: checkInvoke(insn, null, "iterator()Ljava/util/Iterator;")
fn is_iterator_call(insn: &InsnNode, method_resolver: Option<MethodNameResolver>) -> bool {
    if let InsnType::Invoke { method_idx, kind, .. } = &insn.insn_type {
        if !matches!(kind, InvokeKind::Virtual | InvokeKind::Interface) {
            return false;
        }
        if let Some(resolver) = method_resolver {
            if let Some(name) = resolver(*method_idx) {
                return name == "iterator";
            }
        }
        // Without resolver, can't determine - return false
        false
    } else {
        false
    }
}

/// Check if an instruction is a .next() call
///
/// JADX Reference: checkInvoke(insn, "java.util.Iterator", "next()Ljava/lang/Object;")
fn is_next_call(insn: &InsnNode, method_resolver: Option<MethodNameResolver>) -> bool {
    if let InsnType::Invoke { method_idx, kind, .. } = &insn.insn_type {
        if !matches!(kind, InvokeKind::Virtual | InvokeKind::Interface) {
            return false;
        }
        if let Some(resolver) = method_resolver {
            if let Some(name) = resolver(*method_idx) {
                return name == "next";
            }
        }
        // Without resolver, can't determine - return false
        false
    } else {
        false
    }
}

/// Get the receiver (first arg) of an invoke instruction
fn get_invoke_receiver(insn: &InsnNode) -> Option<(u16, u32)> {
    if let InsnType::Invoke { args, .. } = &insn.insn_type {
        if let Some(InsnArg::Register(reg)) = args.first() {
            return Some((reg.reg_num, reg.ssa_version));
        }
    }
    None
}

/// Get the result register of an invoke instruction
fn get_invoke_result(insn: &InsnNode) -> Option<(u16, u32)> {
    if let InsnType::Invoke { dest: Some(dest), .. } = &insn.insn_type {
        return Some((dest.reg_num, dest.ssa_version));
    }
    None
}

/// Find the next() call in the loop body
fn find_next_call(
    ssa: &SsaResult,
    loop_info: &LoopInfo,
    iterator_reg: (u16, u32),
) -> Option<InsnNode> {
    for block_id in &loop_info.blocks {
        if let Some(block) = ssa.blocks.iter().find(|b| b.id == *block_id) {
            for insn in &block.instructions {
                if is_next_call(insn, None) {
                    // Check if it's called on the right iterator
                    if let Some(receiver) = get_invoke_receiver(insn) {
                        if receiver == iterator_reg {
                            return Some(insn.clone());
                        }
                    }
                }
            }
        }
    }
    None
}

/// Enhanced loop pattern analysis including iterator for-each
///
/// JADX Reference: LoopRegionVisitor.processLoopRegion()
pub fn analyze_loop_patterns_with_iterables(
    ssa: &SsaResult,
    loops: &[LoopInfo],
) -> EnhancedLoopPatternResult {
    let mut result = EnhancedLoopPatternResult::default();

    // Build helper maps
    let mut def_map: HashMap<(u16, u32), &InsnNode> = HashMap::new();
    for block in &ssa.blocks {
        for insn in &block.instructions {
            if let Some(dest) = get_result_reg(insn) {
                def_map.insert((dest.reg_num, dest.ssa_version), insn);
            }
        }
    }

    let use_counts = count_uses(ssa);
    let use_locations = build_use_locations(ssa);
    let def_locations = build_def_locations(ssa);

    for loop_info in loops {
        // Try indexed for-loop first
        if let Some(for_pattern) = detect_indexed_for(
            ssa, loop_info, &def_map, &use_counts, &use_locations, &def_locations
        ) {
            // Check if it's actually an array for-each
            if let Some(foreach_pattern) = detect_array_foreach(ssa, &for_pattern, &def_map, &use_counts) {
                result.array_for_each.push(foreach_pattern);
                result.loop_kinds.insert(loop_info.header, LoopKind::ForEach);
                continue;
            } else {
                result.for_loops.push(for_pattern);
                result.loop_kinds.insert(loop_info.header, LoopKind::For);
                continue;
            }
        }

        // Try iterator for-each pattern
        if let Some(iter_pattern) = detect_iterator_foreach(ssa, loop_info, &def_map, &use_locations) {
            result.iterator_for_each.push(iter_pattern);
            result.loop_kinds.insert(loop_info.header, LoopKind::ForEach);
            continue;
        }

        // Default: while loop
        result.loop_kinds.insert(loop_info.header, LoopKind::While);
    }

    result
}

/// Enhanced result including iterator for-each patterns
#[derive(Debug, Default)]
pub struct EnhancedLoopPatternResult {
    /// Detected indexed for-loops
    pub for_loops: Vec<ForLoopPattern>,
    /// Detected array for-each patterns
    pub array_for_each: Vec<ArrayForEachPattern>,
    /// Detected iterator for-each patterns (NEW)
    pub iterator_for_each: Vec<IteratorForEachPattern>,
    /// Map of loop header to detected kind
    pub loop_kinds: HashMap<u32, LoopKind>,
}

#[cfg(test)]
mod tests {
    use super::*;

    #[test]
    fn test_upper_bound_literal() {
        let bound = UpperBound::Literal(10);
        assert!(matches!(bound, UpperBound::Literal(10)));
    }

    #[test]
    fn test_upper_bound_array_length() {
        let bound = UpperBound::ArrayLength { array_reg: (1, 0) };
        assert!(matches!(bound, UpperBound::ArrayLength { array_reg: (1, 0) }));
    }

    #[test]
    fn test_used_only_in_loop() {
        let loop_info = LoopInfo {
            header: 1,
            blocks: vec![1, 2, 3].into_iter().collect(),
            back_edges: vec![],
            exit_blocks: Vec::new(),
            exit_targets: Vec::new(),
            kind: LoopKind::While,
            depth: 0,
            parent: None,
        };

        let mut use_locations = HashMap::new();
        use_locations.insert((0, 1), vec![1, 2]);
        use_locations.insert((1, 0), vec![1, 4]);

        assert!(used_only_in_loop(&loop_info, (0, 1), &use_locations));
        assert!(!used_only_in_loop(&loop_info, (1, 0), &use_locations));
        assert!(used_only_in_loop(&loop_info, (2, 0), &use_locations));
    }
}
