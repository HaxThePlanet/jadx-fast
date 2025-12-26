//! Process instructions pass (JADX parity)
//!
//! This pass runs BEFORE block splitting and SSA transformation.
//! It merges invoke + move-result pairs into a single invoke instruction
//! with a `dest` field, following JADX's ProcessInstructionsVisitor pattern.
//!
//! This fixes the undefined variable bug (P1-S10) caused by the fragile
//! state machine in type_inference.rs and body_gen.rs.

use dexterity_ir::instructions::{InsnNode, InsnType};

/// Process instructions before block splitting (JADX pattern)
///
/// This function:
/// 1. Merges invoke + move-result pairs (sets `dest` on invoke, removes move-result)
/// 2. Merges filled-new-array + move-result pairs
///
/// Must be called BEFORE:
/// - `split_blocks()`
/// - `transform_to_ssa()`
/// - Any other IR transformation
pub fn process_instructions(instructions: &mut Vec<InsnNode>) {
    let mut i = 0;
    while i < instructions.len() {
        let should_merge = match &instructions[i].insn_type {
            InsnType::Invoke { dest: None, .. } => true,
            InsnType::InvokeCustom { dest: None, .. } => true,
            InsnType::FilledNewArray { dest: None, .. } => true,
            _ => false,
        };

        if should_merge {
            if let Some(merged_idx) = try_merge_move_result(instructions, i) {
                // Remove the MoveResult instruction
                instructions.remove(merged_idx);
                // Don't increment i since we removed an element after current position
                i += 1;
                continue;
            }
        }
        i += 1;
    }
}

/// Try to merge the next MoveResult with the instruction at invoke_idx
///
/// Returns the index of the MoveResult instruction if successfully merged,
/// None if no merge was possible.
fn try_merge_move_result(instructions: &mut Vec<InsnNode>, invoke_idx: usize) -> Option<usize> {
    // Find next non-NOP instruction
    let next_idx = find_next_real_insn(instructions, invoke_idx + 1)?;

    // Check if it's a MoveResult
    if let InsnType::MoveResult { dest } = &instructions[next_idx].insn_type {
        let dest_reg = *dest;

        // Set dest on the invoke instruction
        match &mut instructions[invoke_idx].insn_type {
            InsnType::Invoke { dest, .. } => {
                *dest = Some(dest_reg);
            }
            InsnType::InvokeCustom { dest, .. } => {
                *dest = Some(dest_reg);
            }
            InsnType::FilledNewArray { dest, .. } => {
                *dest = Some(dest_reg);
            }
            _ => return None,
        }

        // Copy attributes from MoveResult to Invoke (JADX does this)
        instructions[invoke_idx].flags |= instructions[next_idx].flags;
        if instructions[invoke_idx].source_line.is_none() {
            instructions[invoke_idx].source_line = instructions[next_idx].source_line;
        }

        return Some(next_idx);
    }

    None
}

/// Find the next non-NOP instruction starting from `start_idx`
fn find_next_real_insn(instructions: &[InsnNode], start_idx: usize) -> Option<usize> {
    let mut idx = start_idx;
    while idx < instructions.len() {
        if !matches!(instructions[idx].insn_type, InsnType::Nop) {
            return Some(idx);
        }
        idx += 1;
    }
    None
}

/// Statistics about the merge pass
#[derive(Debug, Default)]
pub struct ProcessInstructionsResult {
    /// Number of invoke + move-result pairs merged
    pub invokes_merged: usize,
    /// Number of invoke-custom + move-result pairs merged
    pub invoke_custom_merged: usize,
    /// Number of filled-new-array + move-result pairs merged
    pub filled_array_merged: usize,
    /// Number of move-result instructions removed
    pub move_results_removed: usize,
}

/// Process instructions with statistics
pub fn process_instructions_with_stats(instructions: &mut Vec<InsnNode>) -> ProcessInstructionsResult {
    let mut result = ProcessInstructionsResult::default();
    let mut i = 0;

    while i < instructions.len() {
        let (should_merge, is_invoke, is_invoke_custom, is_filled_array) = match &instructions[i].insn_type {
            InsnType::Invoke { dest: None, .. } => (true, true, false, false),
            InsnType::InvokeCustom { dest: None, .. } => (true, false, true, false),
            InsnType::FilledNewArray { dest: None, .. } => (true, false, false, true),
            _ => (false, false, false, false),
        };

        if should_merge {
            if let Some(merged_idx) = try_merge_move_result(instructions, i) {
                // Track statistics
                if is_invoke {
                    result.invokes_merged += 1;
                } else if is_invoke_custom {
                    result.invoke_custom_merged += 1;
                } else if is_filled_array {
                    result.filled_array_merged += 1;
                }
                result.move_results_removed += 1;

                // Remove the MoveResult instruction
                instructions.remove(merged_idx);
                i += 1;
                continue;
            }
        }
        i += 1;
    }

    result
}

#[cfg(test)]
mod tests {
    use super::*;
    use dexterity_ir::instructions::{InsnArg, InvokeKind, RegisterArg};
    use smallvec::smallvec;

    #[test]
    fn test_merge_invoke_move_result() {
        let mut insns = vec![
            InsnNode::new(
                InsnType::Invoke {
                    kind: InvokeKind::Virtual,
                    method_idx: 1,
                    args: smallvec![],
                    proto_idx: None,
                    dest: None,
                },
                0,
            ),
            InsnNode::new(InsnType::MoveResult { dest: RegisterArg::new(5) }, 2),
        ];

        process_instructions(&mut insns);

        assert_eq!(insns.len(), 1);
        if let InsnType::Invoke { dest, .. } = &insns[0].insn_type {
            assert!(dest.is_some());
            assert_eq!(dest.unwrap().reg_num, 5);
        } else {
            panic!("Expected Invoke");
        }
    }

    #[test]
    fn test_merge_with_nop_between() {
        let mut insns = vec![
            InsnNode::new(
                InsnType::Invoke {
                    kind: InvokeKind::Static,
                    method_idx: 1,
                    args: smallvec![],
                    proto_idx: None,
                    dest: None,
                },
                0,
            ),
            InsnNode::new(InsnType::Nop, 2),
            InsnNode::new(InsnType::MoveResult { dest: RegisterArg::new(3) }, 4),
        ];

        process_instructions(&mut insns);

        // Should merge through NOP - result is Invoke + NOP (MoveResult removed)
        assert_eq!(insns.len(), 2);
        if let InsnType::Invoke { dest, .. } = &insns[0].insn_type {
            assert!(dest.is_some());
            assert_eq!(dest.unwrap().reg_num, 3);
        } else {
            panic!("Expected Invoke");
        }
    }

    #[test]
    fn test_no_merge_when_no_move_result() {
        let mut insns = vec![
            InsnNode::new(
                InsnType::Invoke {
                    kind: InvokeKind::Virtual,
                    method_idx: 1,
                    args: smallvec![],
                    proto_idx: None,
                    dest: None,
                },
                0,
            ),
            InsnNode::new(
                InsnType::Return { value: None },
                2,
            ),
        ];

        let original_len = insns.len();
        process_instructions(&mut insns);

        // No merge - length unchanged
        assert_eq!(insns.len(), original_len);
        if let InsnType::Invoke { dest, .. } = &insns[0].insn_type {
            assert!(dest.is_none()); // dest still None
        } else {
            panic!("Expected Invoke");
        }
    }

    #[test]
    fn test_multiple_invokes_in_sequence() {
        let mut insns = vec![
            // First invoke + move-result
            InsnNode::new(
                InsnType::Invoke {
                    kind: InvokeKind::Virtual,
                    method_idx: 1,
                    args: smallvec![],
                    proto_idx: None,
                    dest: None,
                },
                0,
            ),
            InsnNode::new(InsnType::MoveResult { dest: RegisterArg::new(5) }, 2),
            // Second invoke + move-result
            InsnNode::new(
                InsnType::Invoke {
                    kind: InvokeKind::Static,
                    method_idx: 2,
                    args: smallvec![],
                    proto_idx: None,
                    dest: None,
                },
                4,
            ),
            InsnNode::new(InsnType::MoveResult { dest: RegisterArg::new(6) }, 6),
        ];

        process_instructions(&mut insns);

        // Both should merge
        assert_eq!(insns.len(), 2);

        if let InsnType::Invoke { dest, method_idx, .. } = &insns[0].insn_type {
            assert_eq!(*method_idx, 1);
            assert!(dest.is_some());
            assert_eq!(dest.unwrap().reg_num, 5);
        } else {
            panic!("Expected first Invoke");
        }

        if let InsnType::Invoke { dest, method_idx, .. } = &insns[1].insn_type {
            assert_eq!(*method_idx, 2);
            assert!(dest.is_some());
            assert_eq!(dest.unwrap().reg_num, 6);
        } else {
            panic!("Expected second Invoke");
        }
    }

    #[test]
    fn test_filled_new_array_merge() {
        let mut insns = vec![
            InsnNode::new(
                InsnType::FilledNewArray {
                    dest: None,
                    type_idx: 1,
                    args: smallvec![InsnArg::lit(1), InsnArg::lit(2)],
                },
                0,
            ),
            InsnNode::new(InsnType::MoveResult { dest: RegisterArg::new(7) }, 2),
        ];

        process_instructions(&mut insns);

        assert_eq!(insns.len(), 1);
        if let InsnType::FilledNewArray { dest, .. } = &insns[0].insn_type {
            assert!(dest.is_some());
            assert_eq!(dest.unwrap().reg_num, 7);
        } else {
            panic!("Expected FilledNewArray");
        }
    }

    #[test]
    fn test_stats() {
        let mut insns = vec![
            InsnNode::new(
                InsnType::Invoke {
                    kind: InvokeKind::Virtual,
                    method_idx: 1,
                    args: smallvec![],
                    proto_idx: None,
                    dest: None,
                },
                0,
            ),
            InsnNode::new(InsnType::MoveResult { dest: RegisterArg::new(5) }, 2),
            InsnNode::new(
                InsnType::FilledNewArray {
                    dest: None,
                    type_idx: 1,
                    args: smallvec![],
                },
                4,
            ),
            InsnNode::new(InsnType::MoveResult { dest: RegisterArg::new(6) }, 6),
        ];

        let stats = process_instructions_with_stats(&mut insns);

        assert_eq!(stats.invokes_merged, 1);
        assert_eq!(stats.filled_array_merged, 1);
        assert_eq!(stats.move_results_removed, 2);
    }
}
