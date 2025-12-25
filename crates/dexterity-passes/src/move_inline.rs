//! MoveInlineVisitor - Inline redundant MOVE instructions
//!
//! This pass inlines redundant MOVE instructions by:
//! 1. Removing self-moves where dest and src are the same SSA variable
//! 2. Removing moves where the result is unused
//! 3. Replacing uses of move results with the source (copy propagation)
//!
//! Equivalent to JADX's MoveInlineVisitor.java (141 lines)
//!
//! # When to Run
//! After SSA transform, before CodeShrinkVisitor.
//!
//! # Algorithm
//! For each MOVE instruction:
//! - If dest.sameRegAndSVar(src): remove (self-move)
//! - If result has no uses: remove (dead code)
//! - If result is used in PHI: skip (can't inline across control flow)
//! - Otherwise: replace all uses of result with source, then remove

use std::collections::{HashMap, HashSet};

use dexterity_ir::{
    attributes::AFlag,
    instructions::{InsnArg, InsnNode, InsnType, RegisterArg},
    ssa::{SSAContext, SSAVarRef},
};

/// Result of move inline pass
#[derive(Debug, Default)]
pub struct MoveInlineResult {
    /// Number of self-moves removed (dest == src)
    pub self_moves_removed: usize,
    /// Number of unused result moves removed
    pub unused_moves_removed: usize,
    /// Number of moves inlined via copy propagation
    pub moves_inlined: usize,
    /// Number of moves skipped (used in PHI)
    pub phi_skipped: usize,
    /// Total moves processed
    pub total_moves: usize,
}

/// Inline redundant MOVE instructions in SSA blocks
///
/// # Arguments
/// * `instructions` - The instruction list to process
/// * `ssa_context` - SSA context with variable use information
///
/// # Returns
/// * `MoveInlineResult` with processing statistics
pub fn inline_moves(
    instructions: &mut Vec<InsnNode>,
    ssa_context: Option<&SSAContext>,
) -> MoveInlineResult {
    let mut result = MoveInlineResult::default();

    // First pass: identify moves that can be removed or inlined
    let mut moves_to_remove: HashSet<u32> = HashSet::new();
    let mut replacements: HashMap<SSAVarRef, InsnArg> = HashMap::new();

    for insn in instructions.iter() {
        if let InsnType::Move { dest, src } = &insn.insn_type {
            result.total_moves += 1;

            // Check for self-move: dest and src are the same register and version
            if is_same_ssa_var(dest, src) {
                moves_to_remove.insert(insn.offset);
                result.self_moves_removed += 1;
                continue;
            }

            // Check if result has uses via SSA context
            if let Some(ctx) = ssa_context {
                let dest_ref = SSAVarRef::new(dest.reg_num, dest.ssa_version);
                if let Some(ssa_var) = ctx.vars.get(&dest_ref) {
                    // If no uses, remove the move (dead code)
                    if ssa_var.use_list.is_empty() && ssa_var.used_in_phi.is_empty() {
                        moves_to_remove.insert(insn.offset);
                        result.unused_moves_removed += 1;
                        continue;
                    }

                    // If used in PHI, can't inline (control flow merge)
                    if !ssa_var.used_in_phi.is_empty() {
                        result.phi_skipped += 1;
                        continue;
                    }

                    // Can inline: record replacement and mark for removal
                    replacements.insert(dest_ref, src.clone());
                    moves_to_remove.insert(insn.offset);
                    result.moves_inlined += 1;
                }
            } else {
                // Without SSA context, just handle obvious self-moves
                // (already handled above)
            }
        }
    }

    // Second pass: apply replacements to all instruction arguments
    if !replacements.is_empty() {
        for insn in instructions.iter_mut() {
            apply_replacements(&mut insn.insn_type, &replacements);
        }
    }

    // Third pass: mark moves for removal
    for insn in instructions.iter_mut() {
        if moves_to_remove.contains(&insn.offset) {
            insn.add_flag(AFlag::DontGenerate);
        }
    }

    result
}

/// Check if dest and src represent the same SSA variable
fn is_same_ssa_var(dest: &RegisterArg, src: &InsnArg) -> bool {
    match src {
        InsnArg::Register(src_reg) => {
            dest.reg_num == src_reg.reg_num && dest.ssa_version == src_reg.ssa_version
        }
        _ => false,
    }
}

/// Apply replacements to instruction arguments
fn apply_replacements(insn_type: &mut InsnType, replacements: &HashMap<SSAVarRef, InsnArg>) {
    // Helper to replace a single argument
    fn maybe_replace(arg: &mut InsnArg, replacements: &HashMap<SSAVarRef, InsnArg>) {
        if let InsnArg::Register(reg) = arg {
            let var_ref = SSAVarRef::new(reg.reg_num, reg.ssa_version);
            if let Some(replacement) = replacements.get(&var_ref) {
                *arg = replacement.clone();
            }
        }
    }

    match insn_type {
        InsnType::Move { src, .. } => {
            maybe_replace(src, replacements);
        }

        InsnType::Return { value: Some(val) } => {
            maybe_replace(val, replacements);
        }

        InsnType::Throw { exception } => {
            maybe_replace(exception, replacements);
        }

        InsnType::Binary { left, right, .. } => {
            maybe_replace(left, replacements);
            maybe_replace(right, replacements);
        }

        InsnType::Unary { arg, .. } => {
            maybe_replace(arg, replacements);
        }

        InsnType::If { left, right, .. } => {
            maybe_replace(left, replacements);
            if let Some(r) = right {
                maybe_replace(r, replacements);
            }
        }

        InsnType::ArrayGet { array, index, .. } => {
            maybe_replace(array, replacements);
            maybe_replace(index, replacements);
        }

        InsnType::ArrayPut { array, index, value, .. } => {
            maybe_replace(array, replacements);
            maybe_replace(index, replacements);
            maybe_replace(value, replacements);
        }

        InsnType::InstanceGet { object, .. } => {
            maybe_replace(object, replacements);
        }

        InsnType::InstancePut { object, value, .. } => {
            maybe_replace(object, replacements);
            maybe_replace(value, replacements);
        }

        InsnType::StaticPut { value, .. } => {
            maybe_replace(value, replacements);
        }

        InsnType::Invoke { args, .. } => {
            for arg in args.iter_mut() {
                maybe_replace(arg, replacements);
            }
        }

        InsnType::Constructor { args, .. } => {
            for arg in args.iter_mut() {
                maybe_replace(arg, replacements);
            }
        }

        InsnType::NewArray { size, .. } => {
            maybe_replace(size, replacements);
        }

        InsnType::FilledNewArray { args, .. } => {
            for arg in args {
                maybe_replace(arg, replacements);
            }
        }

        InsnType::ArrayLength { array, .. } => {
            maybe_replace(array, replacements);
        }

        InsnType::CheckCast { object, .. } => {
            maybe_replace(object, replacements);
        }

        InsnType::InstanceOf { object, .. } => {
            maybe_replace(object, replacements);
        }

        InsnType::PackedSwitch { value, .. } | InsnType::SparseSwitch { value, .. } => {
            maybe_replace(value, replacements);
        }

        InsnType::FillArrayData { array, .. } => {
            maybe_replace(array, replacements);
        }

        InsnType::MonitorEnter { object } | InsnType::MonitorExit { object } => {
            maybe_replace(object, replacements);
        }

        InsnType::Compare { left, right, .. } => {
            maybe_replace(left, replacements);
            maybe_replace(right, replacements);
        }

        // Instructions with no replaceable arguments
        InsnType::Const { .. }
        | InsnType::ConstString { .. }
        | InsnType::ConstClass { .. }
        | InsnType::NewInstance { .. }
        | InsnType::StaticGet { .. }
        | InsnType::Return { value: None }
        | InsnType::Goto { .. }
        | InsnType::Nop
        | InsnType::MoveException { .. }
        | InsnType::MoveResult { .. }
        | InsnType::Phi { .. } => {}

        // Catch-all for any variants we might have missed
        #[allow(unreachable_patterns)]
        _ => {}
    }
}

#[cfg(test)]
mod tests {
    use super::*;
    use dexterity_ir::types::ArgType;

    fn make_register(reg_num: u16, ssa_version: u32) -> RegisterArg {
        RegisterArg { reg_num, ssa_version }
    }

    fn make_insn(offset: u32, insn_type: InsnType) -> InsnNode {
        InsnNode {
            offset,
            insn_type,
            result_type: Some(ArgType::Int),
            source_line: None,
            flags: 0,
            extended_switch_info: None,
            extended_if_info: None,
            attrs: None,
        }
    }

    #[test]
    fn test_self_move_removal() {
        let mut instructions = vec![
            make_insn(0, InsnType::Move {
                dest: make_register(1, 1),
                src: InsnArg::Register(make_register(1, 1)),
            }),
        ];

        let result = inline_moves(&mut instructions, None);

        assert_eq!(result.self_moves_removed, 1);
        assert_eq!(result.total_moves, 1);
        assert!(instructions[0].has_flag(AFlag::DontGenerate));
    }

    #[test]
    fn test_different_reg_not_removed() {
        let mut instructions = vec![
            make_insn(0, InsnType::Move {
                dest: make_register(1, 1),
                src: InsnArg::Register(make_register(2, 0)),
            }),
        ];

        let result = inline_moves(&mut instructions, None);

        assert_eq!(result.self_moves_removed, 0);
        assert_eq!(result.total_moves, 1);
        assert!(!instructions[0].has_flag(AFlag::DontGenerate));
    }

    #[test]
    fn test_same_reg_different_version_not_removed() {
        // r1v1 = r1v0 is NOT a self-move (different SSA versions)
        let mut instructions = vec![
            make_insn(0, InsnType::Move {
                dest: make_register(1, 1),
                src: InsnArg::Register(make_register(1, 0)),
            }),
        ];

        let result = inline_moves(&mut instructions, None);

        assert_eq!(result.self_moves_removed, 0);
        assert_eq!(result.total_moves, 1);
        assert!(!instructions[0].has_flag(AFlag::DontGenerate));
    }

    #[test]
    fn test_unused_move_with_ssa_context() {
        let mut instructions = vec![
            make_insn(0, InsnType::Move {
                dest: make_register(1, 1),
                src: InsnArg::Register(make_register(2, 0)),
            }),
        ];

        // Create SSA context where r1v1 has no uses
        let mut ctx = SSAContext::new();
        let var_ref = SSAVarRef::new(1, 1);
        let ssa_var = dexterity_ir::ssa::SSAVar::new(1, 1);
        ctx.vars.insert(var_ref, ssa_var);

        let result = inline_moves(&mut instructions, Some(&ctx));

        assert_eq!(result.unused_moves_removed, 1);
        assert!(instructions[0].has_flag(AFlag::DontGenerate));
    }

    #[test]
    fn test_phi_usage_prevents_inline() {
        let mut instructions = vec![
            make_insn(0, InsnType::Move {
                dest: make_register(1, 1),
                src: InsnArg::Register(make_register(2, 0)),
            }),
        ];

        // Create SSA context where r1v1 is used in a PHI
        let mut ctx = SSAContext::new();
        let var_ref = SSAVarRef::new(1, 1);
        let mut ssa_var = dexterity_ir::ssa::SSAVar::new(1, 1);
        ssa_var.used_in_phi.push(100); // Used in PHI at insn 100
        ctx.vars.insert(var_ref, ssa_var);

        let result = inline_moves(&mut instructions, Some(&ctx));

        assert_eq!(result.phi_skipped, 1);
        assert!(!instructions[0].has_flag(AFlag::DontGenerate));
    }

    #[test]
    fn test_copy_propagation() {
        // r1v1 = r2v0
        // return r1v1  -> should become return r2v0
        let mut instructions = vec![
            make_insn(0, InsnType::Move {
                dest: make_register(1, 1),
                src: InsnArg::Register(make_register(2, 0)),
            }),
            make_insn(1, InsnType::Return {
                value: Some(InsnArg::Register(make_register(1, 1))),
            }),
        ];

        // Create SSA context where r1v1 is used in insn 1
        let mut ctx = SSAContext::new();
        let var_ref = SSAVarRef::new(1, 1);
        let mut ssa_var = dexterity_ir::ssa::SSAVar::new(1, 1);
        ssa_var.use_list.push(1); // Used in return at offset 1
        ctx.vars.insert(var_ref, ssa_var);

        let result = inline_moves(&mut instructions, Some(&ctx));

        assert_eq!(result.moves_inlined, 1);
        assert!(instructions[0].has_flag(AFlag::DontGenerate));

        // Check that the return now uses r2v0
        if let InsnType::Return { value: Some(InsnArg::Register(reg)) } = &instructions[1].insn_type {
            assert_eq!(reg.reg_num, 2);
            assert_eq!(reg.ssa_version, 0);
        } else {
            panic!("Expected Return with register argument");
        }
    }
}
