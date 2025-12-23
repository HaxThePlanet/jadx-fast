//! MoveInlineVisitor - Inline redundant move instructions
//!
//! This pass performs copy propagation by inlining MOVE instructions:
//! - Removes self-moves (a = a)
//! - Removes moves with unused results
//! - For used moves, replaces all uses with the source register
//!
//! Runs after SSA transform, before CodeShrinkVisitor.
//! Equivalent to JADX's MoveInlineVisitor.java

use std::collections::HashSet;

use dexterity_ir::{
    attributes::AFlag,
    instructions::{InsnArg, InsnNode, InsnType, RegisterArg},
    ssa::SSAContext,
};
use crate::ssa::SsaBlock;

/// Result of move inline pass
#[derive(Debug, Default)]
pub struct MoveInlineResult {
    /// Number of moves removed (self-moves)
    pub self_moves_removed: usize,
    /// Number of unused moves removed
    pub unused_moves_removed: usize,
    /// Number of moves inlined (copy propagation)
    pub moves_inlined: usize,
    /// Number of moves that couldn't be inlined
    pub moves_kept: usize,
    /// Warnings generated
    pub warnings: Vec<String>,
}

/// Perform move inlining on SSA blocks
///
/// # Arguments
/// * `blocks` - Mutable slice of SSA blocks to process
/// * `ssa_ctx` - SSA context with variable use information
///
/// # Returns
/// * `MoveInlineResult` with statistics
pub fn inline_moves(blocks: &mut [SsaBlock], ssa_ctx: &SSAContext) -> MoveInlineResult {
    let mut result = MoveInlineResult::default();

    // First pass: collect moves to process
    let mut moves_to_remove: HashSet<(u32, usize)> = HashSet::new(); // (block_id, insn_idx)
    let mut moves_to_inline: Vec<MoveInfo> = Vec::new();

    for block in blocks.iter() {
        for (insn_idx, insn) in block.instructions.iter().enumerate() {
            if let InsnType::Move { dest, src } = &insn.insn_type {
                let move_info = analyze_move(dest, src, insn, block.id, insn_idx, ssa_ctx);

                match move_info.action {
                    MoveAction::Remove => {
                        moves_to_remove.insert((block.id, insn_idx));
                        match move_info.reason {
                            MoveRemoveReason::SelfMove => result.self_moves_removed += 1,
                            MoveRemoveReason::UnusedResult => result.unused_moves_removed += 1,
                            MoveRemoveReason::Inlined => result.moves_inlined += 1,
                        }
                    }
                    MoveAction::Inline => {
                        moves_to_inline.push(move_info);
                    }
                    MoveAction::Keep => {
                        result.moves_kept += 1;
                    }
                }
            }
        }
    }

    // Second pass: perform inlining (replace uses with source)
    for move_info in &moves_to_inline {
        if let Some(block) = blocks.iter_mut().find(|b| b.id == move_info.block_id) {
            if perform_inline(block, blocks, move_info, ssa_ctx, &mut result) {
                moves_to_remove.insert((move_info.block_id, move_info.insn_idx));
                result.moves_inlined += 1;
            } else {
                result.moves_kept += 1;
            }
        }
    }

    // Third pass: mark removed moves with DONT_GENERATE
    for block in blocks.iter_mut() {
        for (insn_idx, insn) in block.instructions.iter_mut().enumerate() {
            if moves_to_remove.contains(&(block.id, insn_idx)) {
                insn.add_flag(AFlag::DontGenerate);
            }
        }
    }

    result
}

/// Information about a move instruction
struct MoveInfo {
    block_id: u32,
    insn_idx: usize,
    dest_reg: u16,
    dest_ssa: u32,
    src: InsnArg,
    action: MoveAction,
    reason: MoveRemoveReason,
}

#[derive(Debug, Clone, Copy, PartialEq, Eq)]
enum MoveAction {
    Remove,
    Inline,
    Keep,
}

#[derive(Debug, Clone, Copy, PartialEq, Eq)]
enum MoveRemoveReason {
    SelfMove,
    UnusedResult,
    Inlined,
}

/// Analyze a move instruction to determine action
fn analyze_move(
    dest: &RegisterArg,
    src: &InsnArg,
    _insn: &InsnNode,
    block_id: u32,
    insn_idx: usize,
    ssa_ctx: &SSAContext,
) -> MoveInfo {
    let dest_reg = dest.reg_num;
    let dest_ssa = dest.ssa_version;

    // Check for self-move (same register and SSA version)
    if let InsnArg::Register(src_reg) = src {
        if dest_reg == src_reg.reg_num && dest_ssa == src_reg.ssa_version {
            return MoveInfo {
                block_id,
                insn_idx,
                dest_reg,
                dest_ssa,
                src: src.clone(),
                action: MoveAction::Remove,
                reason: MoveRemoveReason::SelfMove,
            };
        }

        // Check if source is assigned in a phi (don't mix already merged variables)
        let src_var_ref = dexterity_ir::ssa::SSAVarRef {
            reg_num: src_reg.reg_num,
            version: src_reg.ssa_version,
        };
        if let Some(src_var) = ssa_ctx.vars.get(&src_var_ref) {
            // Check if this variable is used in phi instructions
            if !src_var.used_in_phi.is_empty() {
                return MoveInfo {
                    block_id,
                    insn_idx,
                    dest_reg,
                    dest_ssa,
                    src: src.clone(),
                    action: MoveAction::Keep,
                    reason: MoveRemoveReason::Inlined,
                };
            }
        }
    }

    // Check the result's uses
    let dest_var_ref = dexterity_ir::ssa::SSAVarRef {
        reg_num: dest_reg,
        version: dest_ssa,
    };

    if let Some(dest_var) = ssa_ctx.vars.get(&dest_var_ref) {
        // No uses - remove
        if dest_var.use_list.is_empty() {
            return MoveInfo {
                block_id,
                insn_idx,
                dest_reg,
                dest_ssa,
                src: src.clone(),
                action: MoveAction::Remove,
                reason: MoveRemoveReason::UnusedResult,
            };
        }

        // Used in phi - can't inline (would corrupt SSA form)
        if !dest_var.used_in_phi.is_empty() {
            return MoveInfo {
                block_id,
                insn_idx,
                dest_reg,
                dest_ssa,
                src: src.clone(),
                action: MoveAction::Keep,
                reason: MoveRemoveReason::Inlined,
            };
        }

        // Has uses but not in phi - can inline
        return MoveInfo {
            block_id,
            insn_idx,
            dest_reg,
            dest_ssa,
            src: src.clone(),
            action: MoveAction::Inline,
            reason: MoveRemoveReason::Inlined,
        };
    }

    // Unknown variable - keep to be safe
    MoveInfo {
        block_id,
        insn_idx,
        dest_reg,
        dest_ssa,
        src: src.clone(),
        action: MoveAction::Keep,
        reason: MoveRemoveReason::Inlined,
    }
}

/// Perform inline of a move by replacing uses with source
fn perform_inline(
    _move_block: &mut SsaBlock,
    blocks: &mut [SsaBlock],
    move_info: &MoveInfo,
    ssa_ctx: &SSAContext,
    result: &mut MoveInlineResult,
) -> bool {
    let dest_var_ref = dexterity_ir::ssa::SSAVarRef {
        reg_num: move_info.dest_reg,
        ssa_version: move_info.dest_ssa,
    };

    let use_list = match ssa_ctx.vars.get(&dest_var_ref) {
        Some(var) => var.use_list.clone(),
        None => return false,
    };

    if use_list.is_empty() {
        return true; // No uses to replace
    }

    // Create the replacement arg
    let replace_arg = match &move_info.src {
        InsnArg::Register(reg) => InsnArg::Register(reg.clone()),
        InsnArg::Literal(lit) => InsnArg::Literal(lit.clone()),
        InsnArg::Wrapped(wrapped) => InsnArg::Wrapped(wrapped.clone()),
        other => other.clone(),
    };

    // Replace all uses
    let mut all_replaced = true;
    for &use_idx in &use_list {
        let use_offset = use_idx as u32;

        // Find the instruction with this use
        for block in blocks.iter_mut() {
            for insn in block.instructions.iter_mut() {
                if insn.offset == use_offset {
                    if !replace_arg_in_insn(insn, move_info.dest_reg, move_info.dest_ssa, &replace_arg) {
                        result.warnings.push(format!(
                            "Failed to replace arg r{}v{} in insn at offset {}",
                            move_info.dest_reg, move_info.dest_ssa, use_offset
                        ));
                        all_replaced = false;
                    }
                }
            }
        }
    }

    all_replaced
}

/// Replace an argument in an instruction
fn replace_arg_in_insn(insn: &mut InsnNode, reg_num: u16, ssa_version: u32, replacement: &InsnArg) -> bool {
    // Check all arguments in the instruction
    match &mut insn.insn_type {
        InsnType::Move { src, .. } => {
            if matches_reg(src, reg_num, ssa_version) {
                *src = replacement.clone();
                return true;
            }
        }
        InsnType::Binary { left, right, .. } => {
            let mut found = false;
            if matches_reg(left, reg_num, ssa_version) {
                *left = replacement.clone();
                found = true;
            }
            if matches_reg(right, reg_num, ssa_version) {
                *right = replacement.clone();
                found = true;
            }
            return found;
        }
        InsnType::Unary { arg, .. } => {
            if matches_reg(arg, reg_num, ssa_version) {
                *arg = replacement.clone();
                return true;
            }
        }
        InsnType::Compare { left, right, .. } => {
            let mut found = false;
            if matches_reg(left, reg_num, ssa_version) {
                *left = replacement.clone();
                found = true;
            }
            if matches_reg(right, reg_num, ssa_version) {
                *right = replacement.clone();
                found = true;
            }
            return found;
        }
        InsnType::If { left, right, .. } => {
            let mut found = false;
            if matches_reg(left, reg_num, ssa_version) {
                *left = replacement.clone();
                found = true;
            }
            if let Some(r) = right {
                if matches_reg(r, reg_num, ssa_version) {
                    *r = replacement.clone();
                    found = true;
                }
            }
            return found;
        }
        InsnType::Return { value: Some(val), .. } => {
            if matches_reg(val, reg_num, ssa_version) {
                *val = replacement.clone();
                return true;
            }
        }
        InsnType::Throw { exception } => {
            if matches_reg(exception, reg_num, ssa_version) {
                *exception = replacement.clone();
                return true;
            }
        }
        InsnType::Invoke { args, .. } | InsnType::InvokeCustom { args, .. } => {
            let mut found = false;
            for arg in args.iter_mut() {
                if matches_reg(arg, reg_num, ssa_version) {
                    *arg = replacement.clone();
                    found = true;
                }
            }
            return found;
        }
        InsnType::Constructor { args, .. } => {
            let mut found = false;
            for arg in args.iter_mut() {
                if matches_reg(arg, reg_num, ssa_version) {
                    *arg = replacement.clone();
                    found = true;
                }
            }
            return found;
        }
        InsnType::InstancePut { object, value, .. } => {
            let mut found = false;
            if matches_reg(object, reg_num, ssa_version) {
                *object = replacement.clone();
                found = true;
            }
            if matches_reg(value, reg_num, ssa_version) {
                *value = replacement.clone();
                found = true;
            }
            return found;
        }
        InsnType::InstanceGet { object, .. } => {
            if matches_reg(object, reg_num, ssa_version) {
                *object = replacement.clone();
                return true;
            }
        }
        InsnType::StaticPut { value, .. } => {
            if matches_reg(value, reg_num, ssa_version) {
                *value = replacement.clone();
                return true;
            }
        }
        InsnType::ArrayGet { array, index, .. } => {
            let mut found = false;
            if matches_reg(array, reg_num, ssa_version) {
                *array = replacement.clone();
                found = true;
            }
            if matches_reg(index, reg_num, ssa_version) {
                *index = replacement.clone();
                found = true;
            }
            return found;
        }
        InsnType::ArrayPut { array, index, value, .. } => {
            let mut found = false;
            if matches_reg(array, reg_num, ssa_version) {
                *array = replacement.clone();
                found = true;
            }
            if matches_reg(index, reg_num, ssa_version) {
                *index = replacement.clone();
                found = true;
            }
            if matches_reg(value, reg_num, ssa_version) {
                *value = replacement.clone();
                found = true;
            }
            return found;
        }
        InsnType::ArrayLength { array, .. } => {
            if matches_reg(array, reg_num, ssa_version) {
                *array = replacement.clone();
                return true;
            }
        }
        InsnType::CheckCast { object, .. } => {
            if matches_reg(object, reg_num, ssa_version) {
                *object = replacement.clone();
                return true;
            }
        }
        InsnType::InstanceOf { object, .. } => {
            if matches_reg(object, reg_num, ssa_version) {
                *object = replacement.clone();
                return true;
            }
        }
        InsnType::MonitorEnter { object } | InsnType::MonitorExit { object } => {
            if matches_reg(object, reg_num, ssa_version) {
                *object = replacement.clone();
                return true;
            }
        }
        InsnType::Switch { value, .. } => {
            if matches_reg(value, reg_num, ssa_version) {
                *value = replacement.clone();
                return true;
            }
        }
        InsnType::NewArray { size, .. } => {
            if matches_reg(size, reg_num, ssa_version) {
                *size = replacement.clone();
                return true;
            }
        }
        InsnType::FilledNewArray { args, .. } => {
            let mut found = false;
            for arg in args.iter_mut() {
                if matches_reg(arg, reg_num, ssa_version) {
                    *arg = replacement.clone();
                    found = true;
                }
            }
            return found;
        }
        InsnType::FillArrayData { array, .. } => {
            if matches_reg(array, reg_num, ssa_version) {
                *array = replacement.clone();
                return true;
            }
        }
        _ => {}
    }

    false
}

/// Check if an argument matches the target register
fn matches_reg(arg: &InsnArg, reg_num: u16, ssa_version: u32) -> bool {
    if let InsnArg::Register(reg) = arg {
        reg.reg_num == reg_num && reg.ssa_version == ssa_version
    } else {
        false
    }
}

#[cfg(test)]
mod tests {
    use super::*;
    use dexterity_ir::types::ArgType;
    use dexterity_ir::ssa::{SSAVar, SSAVarRef};
    use std::collections::HashMap;

    fn make_move_insn(offset: u32, dest_reg: u16, dest_ssa: u32, src_reg: u16, src_ssa: u32) -> InsnNode {
        InsnNode {
            insn_type: InsnType::Move {
                dest: RegisterArg { reg_num: dest_reg, ssa_version: dest_ssa },
                src: InsnArg::Register(RegisterArg { reg_num: src_reg, ssa_version: src_ssa }),
            },
            offset,
            flags: 0,
            result_type: Some(ArgType::Int),
            source_line: None,
        }
    }

    #[test]
    fn test_self_move_detection() {
        let mut blocks = vec![SsaBlock {
            id: 0,
            phi_nodes: vec![],
            instructions: vec![
                make_move_insn(0, 1, 0, 1, 0), // r1v0 = r1v0 (self-move)
            ],
            successors: vec![],
            predecessors: vec![],
        }];

        let ssa_ctx = SSAContext::default();
        let result = inline_moves(&mut blocks, &ssa_ctx);

        assert_eq!(result.self_moves_removed, 1);
        assert!(blocks[0].instructions[0].has_flag(AFlag::DontGenerate));
    }

    #[test]
    fn test_unused_result_removal() {
        let mut blocks = vec![SsaBlock {
            id: 0,
            phi_nodes: vec![],
            instructions: vec![
                make_move_insn(0, 1, 1, 2, 0), // r1v1 = r2v0 (unused)
            ],
            successors: vec![],
            predecessors: vec![],
        }];

        // Create SSA context with variable that has no uses
        let mut vars = HashMap::new();
        vars.insert(
            SSAVarRef { reg_num: 1, ssa_version: 1 },
            SSAVar {
                def_insn_idx: Some(0),
                use_list: vec![], // No uses
                arg_type: Some(ArgType::Int),
                is_phi: false,
                used_in_phi: false,
            },
        );
        let ssa_ctx = SSAContext {
            vars,
            phi_at_block: HashMap::new(),
        };

        let result = inline_moves(&mut blocks, &ssa_ctx);

        assert_eq!(result.unused_moves_removed, 1);
        assert!(blocks[0].instructions[0].has_flag(AFlag::DontGenerate));
    }
}
