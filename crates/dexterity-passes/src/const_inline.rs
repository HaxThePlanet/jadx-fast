//! Constant inlining pass
//!
//! This pass inlines constant values directly into their use sites:
//! - CONST instructions with single use are inlined and removed
//! - Unused CONST instructions are removed
//! - Null inlining is restricted to avoid NPE on receivers/arrays
//!
//! Based on JADX's ConstInlineVisitor.

use std::collections::HashMap;
use dexterity_ir::instructions::{InsnArg, InsnNode, InsnType, LiteralArg};
use dexterity_ir::attributes::AFlag;
use crate::ssa::SsaResult;

/// Result of constant inlining pass
#[derive(Debug)]
pub struct ConstInlineResult {
    /// Number of constants inlined
    pub inlined_count: usize,
    /// Number of unused constants removed
    pub removed_count: usize,
}

/// Inline constants in SSA form
pub fn inline_constants(ssa: &mut SsaResult) -> ConstInlineResult {
    // Phase 1: Count uses for each (reg, version) pair
    let use_counts = count_uses(ssa);

    // Phase 2: Find const definitions and their values
    let const_defs = find_const_defs(ssa);

    // Phase 3: Inline constants where appropriate
    let mut inlined_count = 0;
    let mut removed_count = 0;

    for block in &mut ssa.blocks {
        for insn in &mut block.instructions {
            // Replace uses of single-use constants with their literal values
            let replacements = find_replacements(insn, &const_defs, &use_counts);
            for (arg_idx, literal) in replacements {
                replace_arg(insn, arg_idx, literal);
                inlined_count += 1;
            }
        }

        // Mark unused or single-use constants for removal
        for insn in &mut block.instructions {
            if let InsnType::Const { dest, .. } = &insn.insn_type {
                let key = (dest.reg_num, dest.ssa_version);
                let use_count = use_counts.get(&key).copied().unwrap_or(0);

                if use_count == 0 {
                    // Unused constant - mark for removal
                    insn.add_flag(AFlag::DontGenerate);
                    removed_count += 1;
                } else if use_count == 1 && const_defs.contains_key(&key) {
                    // Single use, already inlined - mark for removal
                    insn.add_flag(AFlag::DontGenerate);
                    removed_count += 1;
                }
            }
        }
    }

    ConstInlineResult {
        inlined_count,
        removed_count,
    }
}

/// Count how many times each SSA variable is used
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
            count_insn_uses(insn, &mut counts);
        }
    }

    counts
}

/// Count uses in a single instruction
fn count_insn_uses(insn: &InsnNode, counts: &mut HashMap<(u16, u32), usize>) {
    match &insn.insn_type {
        InsnType::Move { src, .. } => count_arg(src, counts),
        InsnType::Return { value: Some(v) } => count_arg(v, counts),
        InsnType::Throw { exception } => count_arg(exception, counts),
        InsnType::InstanceGet { object, .. } => count_arg(object, counts),
        InsnType::InstancePut { object, value, .. } => {
            count_arg(object, counts);
            count_arg(value, counts);
        }
        InsnType::StaticPut { value, .. } => count_arg(value, counts),
        InsnType::Invoke { args, .. } => {
            for arg in args {
                count_arg(arg, counts);
            }
        }
        InsnType::Unary { arg, .. } => count_arg(arg, counts),
        InsnType::Binary { left, right, .. } => {
            count_arg(left, counts);
            count_arg(right, counts);
        }
        InsnType::Cast { arg, .. } => count_arg(arg, counts),
        InsnType::Compare { left, right, .. } => {
            count_arg(left, counts);
            count_arg(right, counts);
        }
        InsnType::If { left, right, .. } => {
            count_arg(left, counts);
            if let Some(r) = right {
                count_arg(r, counts);
            }
        }
        InsnType::NewArray { size, .. } => count_arg(size, counts),
        InsnType::ArrayLength { array, .. } => count_arg(array, counts),
        InsnType::ArrayGet { array, index, .. } => {
            count_arg(array, counts);
            count_arg(index, counts);
        }
        InsnType::ArrayPut { array, index, value, .. } => {
            count_arg(array, counts);
            count_arg(index, counts);
            count_arg(value, counts);
        }
        InsnType::FilledNewArray { args, .. } => {
            for arg in args {
                count_arg(arg, counts);
            }
        }
        InsnType::FillArrayData { array, .. } => count_arg(array, counts),
        InsnType::InstanceOf { object, .. } => count_arg(object, counts),
        InsnType::CheckCast { object, .. } => count_arg(object, counts),
        InsnType::MonitorEnter { object } => count_arg(object, counts),
        InsnType::MonitorExit { object } => count_arg(object, counts),
        InsnType::PackedSwitch { value, .. } => count_arg(value, counts),
        InsnType::SparseSwitch { value, .. } => count_arg(value, counts),
        InsnType::Phi { sources, .. } => {
            for (_, src) in sources {
                count_arg(src, counts);
            }
        }
        _ => {}
    }
}

fn count_arg(arg: &InsnArg, counts: &mut HashMap<(u16, u32), usize>) {
    if let InsnArg::Register(reg) = arg {
        *counts.entry((reg.reg_num, reg.ssa_version)).or_insert(0) += 1;
    }
}

/// Find all constant definitions: (reg, version) -> literal value
fn find_const_defs(ssa: &SsaResult) -> HashMap<(u16, u32), LiteralArg> {
    let mut defs = HashMap::new();

    for block in &ssa.blocks {
        for insn in &block.instructions {
            if let InsnType::Const { dest, value } = &insn.insn_type {
                let key = (dest.reg_num, dest.ssa_version);
                defs.insert(key, value.clone());
            }
        }
    }

    defs
}

/// Find which arguments should be replaced with constants
/// Returns: Vec<(arg_index, literal_value)>
fn find_replacements(
    insn: &InsnNode,
    const_defs: &HashMap<(u16, u32), LiteralArg>,
    use_counts: &HashMap<(u16, u32), usize>,
) -> Vec<(usize, LiteralArg)> {
    let mut replacements = Vec::new();

    // Get all arguments from the instruction
    let args = get_insn_args(insn);

    for (idx, arg) in args.iter().enumerate() {
        if let InsnArg::Register(reg) = arg {
            let key = (reg.reg_num, reg.ssa_version);

            // Check if this register holds a constant
            if let Some(literal) = const_defs.get(&key) {
                let use_count = use_counts.get(&key).copied().unwrap_or(0);

                // Only inline if used exactly once (single use)
                // and it's safe to inline (no null NPE issues)
                if use_count == 1 && can_inline_at(insn, idx, literal) {
                    replacements.push((idx, literal.clone()));
                }
            }
        }
    }

    replacements
}

/// Check if a constant can be safely inlined at the given position
/// Null literals cannot be inlined as receivers or array bases
fn can_inline_at(insn: &InsnNode, arg_idx: usize, literal: &LiteralArg) -> bool {
    // Special case: NewArray size can safely inline any integer including zero
    // Only Null is invalid for array size (would cause NPE)
    if let InsnType::NewArray { .. } = &insn.insn_type {
        if arg_idx == 0 {
            // Zero is a valid array size: new int[0] is legal Java
            // Null is never valid for array size
            return !matches!(literal, LiteralArg::Null);
        }
    }

    // Null check - don't inline null where it would cause NPE
    if matches!(literal, LiteralArg::Null) || matches!(literal, LiteralArg::Int(0)) {
        // Check if this is a position that would NPE on null
        match &insn.insn_type {
            // Instance receiver (first arg) - would NPE
            InsnType::Invoke { kind, .. } => {
                if arg_idx == 0 && !matches!(kind, dexterity_ir::instructions::InvokeKind::Static) {
                    return false;
                }
            }
            // Array operations - array is first arg
            InsnType::ArrayLength { .. } |
            InsnType::ArrayGet { .. } |
            InsnType::ArrayPut { .. } => {
                if arg_idx == 0 {
                    return false;
                }
            }
            // Instance field ops - object is first arg
            InsnType::InstanceGet { .. } => {
                if arg_idx == 0 {
                    return false;
                }
            }
            InsnType::InstancePut { .. } => {
                // object is second arg (after value)
                if arg_idx == 1 {
                    return false;
                }
            }
            // Monitor ops
            InsnType::MonitorEnter { .. } |
            InsnType::MonitorExit { .. } => {
                return false;
            }
            // Switch on null
            InsnType::PackedSwitch { .. } |
            InsnType::SparseSwitch { .. } => {
                return false;
            }
            // InstanceOf/CheckCast
            InsnType::InstanceOf { .. } |
            InsnType::CheckCast { .. } => {
                if arg_idx == 0 {
                    return false;
                }
            }
            _ => {}
        }
    }

    true
}

/// Get all arguments from an instruction as a vector
fn get_insn_args(insn: &InsnNode) -> Vec<&InsnArg> {
    match &insn.insn_type {
        InsnType::Move { src, .. } => vec![src],
        InsnType::Return { value: Some(v) } => vec![v],
        InsnType::Throw { exception } => vec![exception],
        InsnType::InstanceGet { object, .. } => vec![object],
        InsnType::InstancePut { object, value, .. } => vec![value, object],
        InsnType::StaticPut { value, .. } => vec![value],
        InsnType::Invoke { args, .. } => args.iter().collect(),
        InsnType::Unary { arg, .. } => vec![arg],
        InsnType::Binary { left, right, .. } => vec![left, right],
        InsnType::Cast { arg, .. } => vec![arg],
        InsnType::Compare { left, right, .. } => vec![left, right],
        InsnType::If { left, right, .. } => {
            let mut v = vec![left];
            if let Some(r) = right {
                v.push(r);
            }
            v
        }
        InsnType::NewArray { size, .. } => vec![size],
        InsnType::ArrayLength { array, .. } => vec![array],
        InsnType::ArrayGet { array, index, .. } => vec![array, index],
        InsnType::ArrayPut { array, index, value, .. } => vec![array, index, value],
        InsnType::FilledNewArray { args, .. } => args.iter().collect(),
        InsnType::FillArrayData { array, .. } => vec![array],
        InsnType::InstanceOf { object, .. } => vec![object],
        InsnType::CheckCast { object, .. } => vec![object],
        InsnType::MonitorEnter { object } => vec![object],
        InsnType::MonitorExit { object } => vec![object],
        InsnType::PackedSwitch { value, .. } => vec![value],
        InsnType::SparseSwitch { value, .. } => vec![value],
        _ => vec![],
    }
}

/// Replace an argument at the given index with a literal
fn replace_arg(insn: &mut InsnNode, arg_idx: usize, literal: LiteralArg) {
    let new_arg = InsnArg::Literal(literal);

    match &mut insn.insn_type {
        InsnType::Move { src, .. } if arg_idx == 0 => *src = new_arg,
        InsnType::Return { value: Some(v) } if arg_idx == 0 => *v = new_arg,
        InsnType::Throw { exception } if arg_idx == 0 => *exception = new_arg,
        InsnType::InstanceGet { object, .. } if arg_idx == 0 => *object = new_arg,
        InsnType::InstancePut { value, object, .. } => {
            if arg_idx == 0 { *value = new_arg; }
            else if arg_idx == 1 { *object = new_arg; }
        }
        InsnType::StaticPut { value, .. } if arg_idx == 0 => *value = new_arg,
        InsnType::Invoke { args, .. } => {
            if arg_idx < args.len() {
                args[arg_idx] = new_arg;
            }
        }
        InsnType::Unary { arg, .. } if arg_idx == 0 => *arg = new_arg,
        InsnType::Binary { left, right, .. } => {
            if arg_idx == 0 { *left = new_arg; }
            else if arg_idx == 1 { *right = new_arg; }
        }
        InsnType::Cast { arg, .. } if arg_idx == 0 => *arg = new_arg,
        InsnType::Compare { left, right, .. } => {
            if arg_idx == 0 { *left = new_arg; }
            else if arg_idx == 1 { *right = new_arg; }
        }
        InsnType::If { left, right, .. } => {
            if arg_idx == 0 { *left = new_arg; }
            else if arg_idx == 1 { *right = Some(new_arg); }
        }
        InsnType::NewArray { size, .. } if arg_idx == 0 => *size = new_arg,
        InsnType::ArrayLength { array, .. } if arg_idx == 0 => *array = new_arg,
        InsnType::ArrayGet { array, index, .. } => {
            if arg_idx == 0 { *array = new_arg; }
            else if arg_idx == 1 { *index = new_arg; }
        }
        InsnType::ArrayPut { array, index, value, .. } => {
            if arg_idx == 0 { *array = new_arg; }
            else if arg_idx == 1 { *index = new_arg; }
            else if arg_idx == 2 { *value = new_arg; }
        }
        InsnType::FilledNewArray { args, .. } => {
            if arg_idx < args.len() {
                args[arg_idx] = new_arg;
            }
        }
        InsnType::FillArrayData { array, .. } if arg_idx == 0 => *array = new_arg,
        InsnType::InstanceOf { object, .. } if arg_idx == 0 => *object = new_arg,
        InsnType::CheckCast { object, .. } if arg_idx == 0 => *object = new_arg,
        InsnType::MonitorEnter { object } if arg_idx == 0 => *object = new_arg,
        InsnType::MonitorExit { object } if arg_idx == 0 => *object = new_arg,
        InsnType::PackedSwitch { value, .. } if arg_idx == 0 => *value = new_arg,
        InsnType::SparseSwitch { value, .. } if arg_idx == 0 => *value = new_arg,
        _ => {}
    }
}

#[cfg(test)]
mod tests {
    use super::*;
    use dexterity_ir::instructions::RegisterArg;

    #[test]
    fn test_can_inline_non_null() {
        // Non-null values can be inlined anywhere
        let literal = LiteralArg::Int(42);
        let insn = InsnNode::new(
            InsnType::Binary {
                dest: RegisterArg::new(0),
                op: dexterity_ir::instructions::BinaryOp::Add,
                left: InsnArg::reg(1),
                right: InsnArg::reg(2),
            },
            0,
        );
        assert!(can_inline_at(&insn, 0, &literal));
        assert!(can_inline_at(&insn, 1, &literal));
    }

    #[test]
    fn test_cannot_inline_null_array() {
        // Null cannot be inlined as array base
        let literal = LiteralArg::Null;
        let insn = InsnNode::new(
            InsnType::ArrayLength {
                dest: RegisterArg::new(0),
                array: InsnArg::reg(1),
            },
            0,
        );
        assert!(!can_inline_at(&insn, 0, &literal));
    }

    #[test]
    fn test_can_inline_null_other() {
        // Null can be inlined in other positions (e.g., binary right operand)
        let literal = LiteralArg::Null;
        let insn = InsnNode::new(
            InsnType::If {
                condition: dexterity_ir::instructions::IfCondition::Eq,
                left: InsnArg::reg(0),
                right: Some(InsnArg::reg(1)),
                target: 10,
            },
            0,
        );
        // Can inline null as the comparison value (arg 1)
        assert!(can_inline_at(&insn, 1, &literal));
    }
}
