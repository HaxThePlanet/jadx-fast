//! Loop pattern analysis for indexed for-loops and array for-each
//!
//! This module analyzes loop structures at the SSA level to detect:
//! - Indexed for-loops: `for (int i = 0; i < N; i++)`
//! - Array for-each: `for (T elem : array)`
//!
//! Based on JADX's LoopRegionVisitor patterns.

use std::collections::HashMap;
use dexterity_ir::instructions::{BinaryOp, InsnArg, InsnNode, InsnType, LiteralArg, RegisterArg};
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

    for loop_info in loops {
        // Try to detect indexed for-loop pattern
        if let Some(for_pattern) = detect_indexed_for(ssa, loop_info, &def_map, &use_counts) {
            // Check if it's actually an array for-each
            if let Some(foreach_pattern) = detect_array_foreach(ssa, &for_pattern, &def_map, &use_counts) {
                result.array_for_each.push(foreach_pattern);
                result.loop_kinds.insert(loop_info.header, LoopKind::ForEach);
            } else {
                result.for_loops.push(for_pattern);
                result.loop_kinds.insert(loop_info.header, LoopKind::For);
            }
        }
    }

    result
}

/// Try to detect an indexed for-loop pattern
fn detect_indexed_for(
    ssa: &SsaResult,
    loop_info: &LoopInfo,
    def_map: &HashMap<(u16, u32), &InsnNode>,
    use_counts: &HashMap<(u16, u32), usize>,
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

    // Get one of the phi sources as the initial value
    let init_source = phi_for_var.sources.iter()
        .find(|(pred, _)| !loop_info.blocks.contains(pred))?;

    // Get the initialization instruction
    let init_insn = def_map.get(&(init_source.1.reg_num, init_source.1.ssa_version))?;

    // Init should be a CONST 0
    let is_zero_init = matches!(&init_insn.insn_type,
        InsnType::Const { value: LiteralArg::Int(0), .. }
    );

    if !is_zero_init {
        return None;
    }

    // Find the increment instruction in the loop body
    // It should be an ADD with literal 1
    let incr_insn = find_increment_insn(ssa, loop_info, loop_var)?;

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
    def_map: &HashMap<(u16, u32), &InsnNode>,
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
                if let InsnType::Binary { dest, op: BinaryOp::Add, left, right } = &insn.insn_type {
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
}
