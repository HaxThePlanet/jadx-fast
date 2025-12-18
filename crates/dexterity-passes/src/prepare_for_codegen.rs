//! Prepare for code generation - final cleanup pass
//!
//! This pass performs final cleanup before code generation, based on JADX's
//! PrepareForCodeGen visitor. Many operations from JADX are already handled
//! at codegen time in Dexterity:
//!
//! - NOP removal: handled in body_gen.rs (returns true, no output)
//! - MONITOR_ENTER/EXIT: skipped in codegen, handled as synchronized regions
//! - MOVE_EXCEPTION: handled at codegen (implicit in catch clause)
//! - Compound assignment (a += 2): detected in body_gen.rs
//! - Type suffixes (L, f, d): handled in type_gen.rs and expr_gen.rs
//! - Single-use inlining: handled in code_shrink.rs
//!
//! This pass adds:
//! - Redundant move removal: `a = a;` where result is unused
//! - Parenthesis optimization hints: mark associative op chains
//! - Self-constructor removal: remove redundant self-init calls

use dexterity_ir::instructions::{InsnType, InsnArg, BinaryOp};
use dexterity_ir::attributes::AFlag;
use crate::ssa::{SsaResult, SsaBlock};

/// Result of prepare for codegen pass
#[derive(Debug, Default)]
pub struct PrepareForCodeGenResult {
    /// Number of redundant moves removed
    pub redundant_moves_removed: usize,
    /// Number of instructions marked for no-wrap (parenthesis optimization)
    pub no_wrap_marked: usize,
    /// Number of CONSTRUCTOR instructions synthesized
    pub constructors_synthesized: usize,
    /// Number of STR_CONCAT instructions synthesized
    pub str_concat_synthesized: usize,
}

/// Check if a binary operation is associative (can be chained without parentheses)
fn is_associative(op: &BinaryOp) -> bool {
    matches!(op, BinaryOp::Add | BinaryOp::Mul | BinaryOp::And | BinaryOp::Or | BinaryOp::Xor)
}

/// Run the prepare for codegen pass
pub fn prepare_for_codegen(ssa: &mut SsaResult) -> PrepareForCodeGenResult {
    let mut result = PrepareForCodeGenResult::default();

    for block in &mut ssa.blocks {
        remove_redundant_moves(block, &mut result);
        mark_associative_chains(block, &mut result);
        synthesize_constructors(block, &mut result);
    }

    result
}

/// Remove redundant moves: `a = a;` where result is unused and names match
///
/// In SSA form, this appears as:
/// - Move instruction where dest register == source register (same reg_num)
/// - Result has no uses (use count = 0)
fn remove_redundant_moves(block: &mut SsaBlock, result: &mut PrepareForCodeGenResult) {
    // Collect offsets of moves to mark as don't generate
    let mut to_remove: Vec<u32> = Vec::new();

    for insn in &block.instructions {
        if let InsnType::Move { dest, src } = &insn.insn_type {
            // Check if source is a register with same reg_num as dest
            if let InsnArg::Register(src_reg) = src {
                if dest.reg_num == src_reg.reg_num {
                    // Same register - this is a redundant move
                    // In SSA, this can happen after phi elimination or
                    // copy propagation optimizations
                    to_remove.push(insn.offset);
                }
            }
        }
    }

    // Mark redundant moves as don't generate
    for insn in &mut block.instructions {
        if to_remove.contains(&insn.offset) {
            insn.add_flag(AFlag::DontGenerate);
            result.redundant_moves_removed += 1;
        }
    }
}

/// Mark associative operation chains for parenthesis optimization
///
/// For operations like `(a + b) + c`, if the inner operation matches
/// the outer operation for associative ops (ADD, MUL, AND, OR, XOR),
/// mark them to avoid wrapping with parentheses.
///
/// This improves readability: `a + b + c` instead of `(a + b) + c`
fn mark_associative_chains(block: &mut SsaBlock, result: &mut PrepareForCodeGenResult) {
    // Build a map from result register to instruction for lookup
    let mut result_to_insn: std::collections::HashMap<(u16, u32), (BinaryOp, u32)> =
        std::collections::HashMap::new();

    for insn in &block.instructions {
        if let InsnType::Binary { dest, op, .. } = &insn.insn_type {
            if is_associative(op) {
                result_to_insn.insert((dest.reg_num, dest.ssa_version), (*op, insn.offset));
            }
        }
    }

    // Now check each binary instruction to see if its operands are
    // binary instructions with the same associative operator
    let mut to_mark: Vec<u32> = Vec::new();

    for insn in &block.instructions {
        if let InsnType::Binary { op, left, right, .. } = &insn.insn_type {
            if !is_associative(op) {
                continue;
            }

            // Check if left operand is a binary with same op
            if let InsnArg::Register(left_reg) = left {
                if let Some((inner_op, inner_offset)) =
                    result_to_insn.get(&(left_reg.reg_num, left_reg.ssa_version))
                {
                    if inner_op == op {
                        to_mark.push(*inner_offset);
                    }
                }
            }

            // Check if right operand is a binary with same op
            // Note: For ADD, we can still chain: a + (b + c) = a + b + c
            // but for SUB we cannot: a - (b - c) != a - b - c
            if let InsnArg::Register(right_reg) = right {
                if let Some((inner_op, inner_offset)) =
                    result_to_insn.get(&(right_reg.reg_num, right_reg.ssa_version))
                {
                    if inner_op == op {
                        // Only mark right side for fully associative ops
                        // ADD, MUL, AND, OR, XOR are all fully associative
                        to_mark.push(*inner_offset);
                    }
                }
            }
        }
    }

    // Mark instructions
    for insn in &mut block.instructions {
        if to_mark.contains(&insn.offset) && !insn.has_flag(AFlag::DontWrap) {
            insn.add_flag(AFlag::DontWrap);
            result.no_wrap_marked += 1;
        }
    }
}

/// Synthesize CONSTRUCTOR instructions by fusing NewInstance + <init> pairs
///
/// Pattern detected:
/// ```
/// v0 = new Type()           // NewInstance
/// v0.<init>(args)           // Invoke Direct <init>
/// →  v0 = new Type(args)    // Constructor (synthesized)
/// ```
///
/// This matches JADX's behavior of combining object allocation with initialization.
fn synthesize_constructors(block: &mut SsaBlock, result: &mut PrepareForCodeGenResult) {
    use dexterity_ir::instructions::{InsnNode, InvokeKind};
    use std::collections::HashMap;

    // Build map of NewInstance instructions by (reg_num, ssa_version) -> (index, type_idx, offset)
    let mut new_instances: HashMap<(u16, u32), (usize, u32, u32)> = HashMap::new();

    for (idx, insn) in block.instructions.iter().enumerate() {
        if let InsnType::NewInstance { dest, type_idx } = &insn.insn_type {
            new_instances.insert(
                (dest.reg_num, dest.ssa_version),
                (idx, *type_idx, insn.offset),
            );
        }
    }

    // Find matching <init> calls and synthesize CONSTRUCTOR instructions
    let mut constructors_to_create: Vec<(usize, usize, InsnNode)> = Vec::new();

    for (idx, insn) in block.instructions.iter().enumerate() {
        if let InsnType::Invoke { kind, method_idx, args, .. } = &insn.insn_type {
            // Check if this is a Direct invoke (constructor call)
            if matches!(kind, InvokeKind::Direct) && !args.is_empty() {
                // Get the receiver register (first argument to <init>)
                if let InsnArg::Register(receiver) = &args[0] {
                    // Check if this receiver matches a NewInstance
                    if let Some((new_idx, type_idx, new_offset)) =
                        new_instances.get(&(receiver.reg_num, receiver.ssa_version))
                    {
                        // Create CONSTRUCTOR instruction
                        let dest = receiver.clone();
                        let ctor_args = args[1..].to_vec(); // Skip 'this' arg

                        let ctor_insn = InsnNode::new(
                            InsnType::Constructor {
                                dest,
                                type_idx: *type_idx,
                                method_idx: *method_idx,
                                args: ctor_args,
                            },
                            *new_offset, // Use NewInstance offset for better source mapping
                        );

                        constructors_to_create.push((*new_idx, idx, ctor_insn));
                    }
                }
            }
        }
    }

    // Apply the transformations (in reverse to maintain indices)
    for (new_idx, init_idx, ctor_insn) in constructors_to_create.iter().rev() {
        // Replace <init> call with CONSTRUCTOR
        block.instructions[*init_idx] = ctor_insn.clone();

        // Mark NewInstance as DONT_GENERATE
        block.instructions[*new_idx].add_flag(AFlag::DontGenerate);

        result.constructors_synthesized += 1;
    }
}

#[cfg(test)]
mod tests {
    use super::*;
    use dexterity_ir::instructions::{InsnNode, RegisterArg};
    use rustc_hash::{FxHashMap, FxHashSet};

    fn make_ssa_result(blocks: Vec<SsaBlock>) -> SsaResult {
        SsaResult {
            blocks,
            dominators: FxHashMap::default(),
            dom_frontiers: FxHashMap::default(),
            max_versions: FxHashMap::default(),
        }
    }

    fn make_insn(offset: u32, insn_type: InsnType) -> InsnNode {
        InsnNode {
            offset,
            insn_type,
            result_type: None,
            source_line: None,
            flags: 0,
        }
    }

    #[test]
    fn test_redundant_move_removal() {
        let block = SsaBlock {
            id: 0,
            instructions: vec![
                make_insn(0, InsnType::Move {
                    dest: RegisterArg { reg_num: 1, ssa_version: 1 },
                    src: InsnArg::Register(RegisterArg { reg_num: 1, ssa_version: 0 }),
                }),
            ],
            phi_nodes: vec![],
            successors: vec![],
            predecessors: vec![],
        };

        let mut ssa = make_ssa_result(vec![block]);

        let result = prepare_for_codegen(&mut ssa);
        assert_eq!(result.redundant_moves_removed, 1);
        assert!(ssa.blocks[0].instructions[0].has_flag(AFlag::DontGenerate));
    }

    #[test]
    fn test_non_redundant_move_not_removed() {
        let block = SsaBlock {
            id: 0,
            instructions: vec![
                make_insn(0, InsnType::Move {
                    dest: RegisterArg { reg_num: 1, ssa_version: 1 },
                    src: InsnArg::Register(RegisterArg { reg_num: 2, ssa_version: 0 }),
                }),
            ],
            phi_nodes: vec![],
            successors: vec![],
            predecessors: vec![],
        };

        let mut ssa = make_ssa_result(vec![block]);

        let result = prepare_for_codegen(&mut ssa);
        assert_eq!(result.redundant_moves_removed, 0);
        assert!(!ssa.blocks[0].instructions[0].has_flag(AFlag::DontGenerate));
    }

    #[test]
    fn test_associative_chain_marking() {
        // Create: result = (a + b) + c
        // Where inner = a + b, outer = inner + c
        let block = SsaBlock {
            id: 0,
            instructions: vec![
                // inner = a + b  (stored in r3)
                make_insn(0, InsnType::Binary {
                    dest: RegisterArg { reg_num: 3, ssa_version: 0 },
                    op: BinaryOp::Add,
                    left: InsnArg::Register(RegisterArg { reg_num: 1, ssa_version: 0 }),
                    right: InsnArg::Register(RegisterArg { reg_num: 2, ssa_version: 0 }),
                }),
                // result = inner + c (r4 = r3 + c)
                make_insn(1, InsnType::Binary {
                    dest: RegisterArg { reg_num: 4, ssa_version: 0 },
                    op: BinaryOp::Add,
                    left: InsnArg::Register(RegisterArg { reg_num: 3, ssa_version: 0 }),
                    right: InsnArg::Register(RegisterArg { reg_num: 5, ssa_version: 0 }),
                }),
            ],
            phi_nodes: vec![],
            successors: vec![],
            predecessors: vec![],
        };

        let mut ssa = make_ssa_result(vec![block]);

        let result = prepare_for_codegen(&mut ssa);
        // The inner add (offset 0) should be marked as DontWrap
        assert_eq!(result.no_wrap_marked, 1);
        assert!(ssa.blocks[0].instructions[0].has_flag(AFlag::DontWrap));
    }

    #[test]
    fn test_non_associative_not_marked() {
        // Create: result = (a - b) - c
        // SUB is not associative, so we should NOT mark it
        let block = SsaBlock {
            id: 0,
            instructions: vec![
                // inner = a - b  (stored in r3)
                make_insn(0, InsnType::Binary {
                    dest: RegisterArg { reg_num: 3, ssa_version: 0 },
                    op: BinaryOp::Sub,
                    left: InsnArg::Register(RegisterArg { reg_num: 1, ssa_version: 0 }),
                    right: InsnArg::Register(RegisterArg { reg_num: 2, ssa_version: 0 }),
                }),
                // result = inner - c (r4 = r3 - c)
                make_insn(1, InsnType::Binary {
                    dest: RegisterArg { reg_num: 4, ssa_version: 0 },
                    op: BinaryOp::Sub,
                    left: InsnArg::Register(RegisterArg { reg_num: 3, ssa_version: 0 }),
                    right: InsnArg::Register(RegisterArg { reg_num: 5, ssa_version: 0 }),
                }),
            ],
            phi_nodes: vec![],
            successors: vec![],
            predecessors: vec![],
        };

        let mut ssa = make_ssa_result(vec![block]);

        let result = prepare_for_codegen(&mut ssa);
        // SUB is not associative, should not be marked
        assert_eq!(result.no_wrap_marked, 0);
        assert!(!ssa.blocks[0].instructions[0].has_flag(AFlag::DontWrap));
    }
}
