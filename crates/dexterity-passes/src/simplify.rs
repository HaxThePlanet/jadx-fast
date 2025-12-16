//! Instruction simplification pass
//!
//! This pass simplifies instructions to produce cleaner output:
//! - `x + (-N)` → `x - N`
//! - `bool ^ 1` → `!bool`
//! - `bool ^ 0` → `bool` (move)
//! - Redundant double negation: `!!x` → `x`
//!
//! Based on JADX's SimplifyVisitor patterns.

use std::collections::HashMap;
use dexterity_ir::instructions::{BinaryOp, InsnArg, InsnNode, InsnType, LiteralArg, UnaryOp, RegisterArg};
use dexterity_ir::types::ArgType;
use crate::ssa::SsaResult;

/// Result of simplification pass
#[derive(Debug)]
pub struct SimplifyResult {
    /// Number of instructions simplified
    pub simplified_count: usize,
}

/// Simplify instructions in SSA form
pub fn simplify_instructions(ssa: &mut SsaResult, types: Option<&HashMap<(u16, u32), ArgType>>) -> SimplifyResult {
    let mut simplified_count = 0;

    for block in &mut ssa.blocks {
        for insn in &mut block.instructions {
            if let Some(new_insn) = simplify_insn(insn, types) {
                *insn = new_insn;
                simplified_count += 1;
            }
        }
    }

    SimplifyResult { simplified_count }
}

/// Try to simplify a single instruction
fn simplify_insn(insn: &InsnNode, types: Option<&HashMap<(u16, u32), ArgType>>) -> Option<InsnNode> {
    match &insn.insn_type {
        InsnType::Binary { dest, op, left, right } => {
            simplify_binary(*dest, *op, left.clone(), right.clone(), insn.offset, types)
        }
        _ => None,
    }
}

/// Simplify binary operations
fn simplify_binary(
    dest: RegisterArg,
    op: BinaryOp,
    left: InsnArg,
    right: InsnArg,
    offset: u32,
    types: Option<&HashMap<(u16, u32), ArgType>>,
) -> Option<InsnNode> {
    match op {
        BinaryOp::Add => {
            // x + (-N) → x - N
            if let Some(neg_val) = get_negative_literal(&right) {
                let new_insn = InsnNode::new(
                    InsnType::Binary {
                        dest,
                        op: BinaryOp::Sub,
                        left,
                        right: InsnArg::Literal(LiteralArg::Int(neg_val)),
                    },
                    offset,
                );
                return Some(new_insn);
            }
        }
        BinaryOp::Xor => {
            // bool ^ 1 → !bool (NOT)
            // bool ^ 0 → bool (MOVE)
            if let InsnArg::Literal(LiteralArg::Int(lit)) = &right {
                // Check if left operand is boolean type
                let is_boolean = if let InsnArg::Register(reg) = &left {
                    types.map_or(false, |t| {
                        matches!(t.get(&(reg.reg_num, reg.ssa_version)), Some(ArgType::Boolean))
                    })
                } else {
                    false
                };

                if is_boolean {
                    match *lit {
                        0 => {
                            // bool ^ 0 → bool (just move)
                            let new_insn = InsnNode::new(
                                InsnType::Move { dest, src: left },
                                offset,
                            );
                            return Some(new_insn);
                        }
                        1 => {
                            // bool ^ 1 → !bool (Boolean NOT)
                            let new_insn = InsnNode::new(
                                InsnType::Unary { dest, op: UnaryOp::BoolNot, arg: left },
                                offset,
                            );
                            return Some(new_insn);
                        }
                        _ => {}
                    }
                }
            }
        }
        _ => {}
    }

    None
}

/// Get the negated value if the argument is a negative literal
fn get_negative_literal(arg: &InsnArg) -> Option<i64> {
    if let InsnArg::Literal(LiteralArg::Int(val)) = arg {
        if *val < 0 {
            // Return the positive version
            return Some(-*val);
        }
    }
    None
}

#[cfg(test)]
mod tests {
    use super::*;

    #[test]
    fn test_add_negative_simplification() {
        let insn = InsnNode::new(
            InsnType::Binary {
                dest: RegisterArg::new(0),
                op: BinaryOp::Add,
                left: InsnArg::reg(1),
                right: InsnArg::Literal(LiteralArg::Int(-5)),
            },
            0,
        );

        let result = simplify_insn(&insn, None);
        assert!(result.is_some());

        let simplified = result.unwrap();
        match &simplified.insn_type {
            InsnType::Binary { op, right, .. } => {
                assert_eq!(*op, BinaryOp::Sub);
                assert!(matches!(right, InsnArg::Literal(LiteralArg::Int(5))));
            }
            _ => panic!("Expected Binary instruction"),
        }
    }

    #[test]
    fn test_add_positive_not_simplified() {
        let insn = InsnNode::new(
            InsnType::Binary {
                dest: RegisterArg::new(0),
                op: BinaryOp::Add,
                left: InsnArg::reg(1),
                right: InsnArg::Literal(LiteralArg::Int(5)),
            },
            0,
        );

        let result = simplify_insn(&insn, None);
        assert!(result.is_none()); // No simplification needed
    }

    #[test]
    fn test_xor_boolean_1() {
        // bool ^ 1 → !bool
        let insn = InsnNode::new(
            InsnType::Binary {
                dest: RegisterArg::new(0),
                op: BinaryOp::Xor,
                left: InsnArg::Register(RegisterArg::with_ssa(1, 0)),
                right: InsnArg::Literal(LiteralArg::Int(1)),
            },
            0,
        );

        // Create type info marking register 1 as boolean
        let mut types = HashMap::new();
        types.insert((1, 0), ArgType::Boolean);

        let result = simplify_insn(&insn, Some(&types));
        assert!(result.is_some());

        let simplified = result.unwrap();
        match &simplified.insn_type {
            InsnType::Unary { op, .. } => {
                assert_eq!(*op, UnaryOp::BoolNot);
            }
            _ => panic!("Expected Unary BoolNot instruction"),
        }
    }

    #[test]
    fn test_xor_boolean_0() {
        // bool ^ 0 → bool (move)
        let insn = InsnNode::new(
            InsnType::Binary {
                dest: RegisterArg::new(0),
                op: BinaryOp::Xor,
                left: InsnArg::Register(RegisterArg::with_ssa(1, 0)),
                right: InsnArg::Literal(LiteralArg::Int(0)),
            },
            0,
        );

        // Create type info marking register 1 as boolean
        let mut types = HashMap::new();
        types.insert((1, 0), ArgType::Boolean);

        let result = simplify_insn(&insn, Some(&types));
        assert!(result.is_some());

        let simplified = result.unwrap();
        assert!(matches!(&simplified.insn_type, InsnType::Move { .. }));
    }

    #[test]
    fn test_xor_non_boolean_not_simplified() {
        // Non-boolean xor should not be simplified
        let insn = InsnNode::new(
            InsnType::Binary {
                dest: RegisterArg::new(0),
                op: BinaryOp::Xor,
                left: InsnArg::Register(RegisterArg::with_ssa(1, 0)),
                right: InsnArg::Literal(LiteralArg::Int(1)),
            },
            0,
        );

        // Create type info marking register 1 as int (not boolean)
        let mut types = HashMap::new();
        types.insert((1, 0), ArgType::Int);

        let result = simplify_insn(&insn, Some(&types));
        assert!(result.is_none()); // No simplification for non-boolean
    }
}
