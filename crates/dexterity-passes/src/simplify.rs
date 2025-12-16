//! Instruction simplification pass
//!
//! This pass simplifies instructions to produce cleaner output:
//!
//! ## Identity eliminations
//! - `x + 0` → `x`
//! - `x - 0` → `x`
//! - `x * 1` → `x`
//! - `x / 1` → `x`
//! - `x | 0` → `x`
//! - `x & -1` → `x` (AND with all bits set)
//! - `x ^ 0` → `x`
//! - `x << 0` → `x`, `x >> 0` → `x`, `x >>> 0` → `x`
//!
//! ## Constant folding
//! - `x * 0` → `0`
//! - `x & 0` → `0`
//! - `x | -1` → `-1`
//! - `x % 1` → `0`
//!
//! ## Algebraic transformations
//! - `x + (-N)` → `x - N`
//!
//! ## Boolean simplifications
//! - `bool ^ 1` → `!bool`
//! - `bool ^ 0` → `bool` (move)
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

/// Check if an argument is a zero literal (0)
fn is_zero_literal(arg: &InsnArg) -> bool {
    matches!(arg, InsnArg::Literal(LiteralArg::Int(0)))
}

/// Check if an argument is a one literal (1)
fn is_one_literal(arg: &InsnArg) -> bool {
    matches!(arg, InsnArg::Literal(LiteralArg::Int(1)))
}

/// Check if an argument is all bits set (-1 for int)
fn is_all_ones_literal(arg: &InsnArg) -> bool {
    matches!(arg, InsnArg::Literal(LiteralArg::Int(-1)))
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
            // x + 0 → x
            if is_zero_literal(&right) {
                return Some(InsnNode::new(
                    InsnType::Move { dest, src: left },
                    offset,
                ));
            }
            // 0 + x → x
            if is_zero_literal(&left) {
                return Some(InsnNode::new(
                    InsnType::Move { dest, src: right },
                    offset,
                ));
            }
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
        BinaryOp::Sub => {
            // x - 0 → x
            if is_zero_literal(&right) {
                return Some(InsnNode::new(
                    InsnType::Move { dest, src: left },
                    offset,
                ));
            }
        }
        BinaryOp::Mul => {
            // x * 1 → x
            if is_one_literal(&right) {
                return Some(InsnNode::new(
                    InsnType::Move { dest, src: left },
                    offset,
                ));
            }
            // 1 * x → x
            if is_one_literal(&left) {
                return Some(InsnNode::new(
                    InsnType::Move { dest, src: right },
                    offset,
                ));
            }
            // x * 0 → 0
            if is_zero_literal(&right) {
                return Some(InsnNode::new(
                    InsnType::Const { dest, value: LiteralArg::Int(0) },
                    offset,
                ));
            }
            // 0 * x → 0
            if is_zero_literal(&left) {
                return Some(InsnNode::new(
                    InsnType::Const { dest, value: LiteralArg::Int(0) },
                    offset,
                ));
            }
        }
        BinaryOp::Div => {
            // x / 1 → x
            if is_one_literal(&right) {
                return Some(InsnNode::new(
                    InsnType::Move { dest, src: left },
                    offset,
                ));
            }
        }
        BinaryOp::Rem => {
            // x % 1 → 0 (any integer mod 1 is 0)
            if is_one_literal(&right) {
                return Some(InsnNode::new(
                    InsnType::Const { dest, value: LiteralArg::Int(0) },
                    offset,
                ));
            }
        }
        BinaryOp::Or => {
            // x | 0 → x
            if is_zero_literal(&right) {
                return Some(InsnNode::new(
                    InsnType::Move { dest, src: left },
                    offset,
                ));
            }
            // 0 | x → x
            if is_zero_literal(&left) {
                return Some(InsnNode::new(
                    InsnType::Move { dest, src: right },
                    offset,
                ));
            }
            // x | -1 → -1 (all bits set)
            if is_all_ones_literal(&right) {
                return Some(InsnNode::new(
                    InsnType::Const { dest, value: LiteralArg::Int(-1) },
                    offset,
                ));
            }
        }
        BinaryOp::And => {
            // x & -1 → x (AND with all bits set is identity)
            if is_all_ones_literal(&right) {
                return Some(InsnNode::new(
                    InsnType::Move { dest, src: left },
                    offset,
                ));
            }
            // -1 & x → x
            if is_all_ones_literal(&left) {
                return Some(InsnNode::new(
                    InsnType::Move { dest, src: right },
                    offset,
                ));
            }
            // x & 0 → 0
            if is_zero_literal(&right) || is_zero_literal(&left) {
                return Some(InsnNode::new(
                    InsnType::Const { dest, value: LiteralArg::Int(0) },
                    offset,
                ));
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
                } else {
                    // Non-boolean XOR
                    // x ^ 0 → x
                    if *lit == 0 {
                        return Some(InsnNode::new(
                            InsnType::Move { dest, src: left },
                            offset,
                        ));
                    }
                }
            }
            // Also check left side for 0 ^ x → x
            if is_zero_literal(&left) {
                return Some(InsnNode::new(
                    InsnType::Move { dest, src: right },
                    offset,
                ));
            }
        }
        BinaryOp::Shl | BinaryOp::Shr | BinaryOp::Ushr => {
            // x << 0 → x, x >> 0 → x, x >>> 0 → x
            if is_zero_literal(&right) {
                return Some(InsnNode::new(
                    InsnType::Move { dest, src: left },
                    offset,
                ));
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

    #[test]
    fn test_add_zero_identity() {
        // x + 0 → x
        let insn = InsnNode::new(
            InsnType::Binary {
                dest: RegisterArg::new(0),
                op: BinaryOp::Add,
                left: InsnArg::reg(1),
                right: InsnArg::Literal(LiteralArg::Int(0)),
            },
            0,
        );

        let result = simplify_insn(&insn, None);
        assert!(result.is_some());
        assert!(matches!(&result.unwrap().insn_type, InsnType::Move { .. }));
    }

    #[test]
    fn test_sub_zero_identity() {
        // x - 0 → x
        let insn = InsnNode::new(
            InsnType::Binary {
                dest: RegisterArg::new(0),
                op: BinaryOp::Sub,
                left: InsnArg::reg(1),
                right: InsnArg::Literal(LiteralArg::Int(0)),
            },
            0,
        );

        let result = simplify_insn(&insn, None);
        assert!(result.is_some());
        assert!(matches!(&result.unwrap().insn_type, InsnType::Move { .. }));
    }

    #[test]
    fn test_mul_one_identity() {
        // x * 1 → x
        let insn = InsnNode::new(
            InsnType::Binary {
                dest: RegisterArg::new(0),
                op: BinaryOp::Mul,
                left: InsnArg::reg(1),
                right: InsnArg::Literal(LiteralArg::Int(1)),
            },
            0,
        );

        let result = simplify_insn(&insn, None);
        assert!(result.is_some());
        assert!(matches!(&result.unwrap().insn_type, InsnType::Move { .. }));
    }

    #[test]
    fn test_mul_zero_constant_fold() {
        // x * 0 → 0
        let insn = InsnNode::new(
            InsnType::Binary {
                dest: RegisterArg::new(0),
                op: BinaryOp::Mul,
                left: InsnArg::reg(1),
                right: InsnArg::Literal(LiteralArg::Int(0)),
            },
            0,
        );

        let result = simplify_insn(&insn, None);
        assert!(result.is_some());
        let simplified = result.unwrap();
        match &simplified.insn_type {
            InsnType::Const { value: LiteralArg::Int(0), .. } => {}
            _ => panic!("Expected Const 0 instruction"),
        }
    }

    #[test]
    fn test_div_one_identity() {
        // x / 1 → x
        let insn = InsnNode::new(
            InsnType::Binary {
                dest: RegisterArg::new(0),
                op: BinaryOp::Div,
                left: InsnArg::reg(1),
                right: InsnArg::Literal(LiteralArg::Int(1)),
            },
            0,
        );

        let result = simplify_insn(&insn, None);
        assert!(result.is_some());
        assert!(matches!(&result.unwrap().insn_type, InsnType::Move { .. }));
    }

    #[test]
    fn test_or_zero_identity() {
        // x | 0 → x
        let insn = InsnNode::new(
            InsnType::Binary {
                dest: RegisterArg::new(0),
                op: BinaryOp::Or,
                left: InsnArg::reg(1),
                right: InsnArg::Literal(LiteralArg::Int(0)),
            },
            0,
        );

        let result = simplify_insn(&insn, None);
        assert!(result.is_some());
        assert!(matches!(&result.unwrap().insn_type, InsnType::Move { .. }));
    }

    #[test]
    fn test_and_all_ones_identity() {
        // x & -1 → x
        let insn = InsnNode::new(
            InsnType::Binary {
                dest: RegisterArg::new(0),
                op: BinaryOp::And,
                left: InsnArg::reg(1),
                right: InsnArg::Literal(LiteralArg::Int(-1)),
            },
            0,
        );

        let result = simplify_insn(&insn, None);
        assert!(result.is_some());
        assert!(matches!(&result.unwrap().insn_type, InsnType::Move { .. }));
    }

    #[test]
    fn test_and_zero_constant_fold() {
        // x & 0 → 0
        let insn = InsnNode::new(
            InsnType::Binary {
                dest: RegisterArg::new(0),
                op: BinaryOp::And,
                left: InsnArg::reg(1),
                right: InsnArg::Literal(LiteralArg::Int(0)),
            },
            0,
        );

        let result = simplify_insn(&insn, None);
        assert!(result.is_some());
        let simplified = result.unwrap();
        match &simplified.insn_type {
            InsnType::Const { value: LiteralArg::Int(0), .. } => {}
            _ => panic!("Expected Const 0 instruction"),
        }
    }

    #[test]
    fn test_shift_zero_identity() {
        // x << 0 → x
        let insn = InsnNode::new(
            InsnType::Binary {
                dest: RegisterArg::new(0),
                op: BinaryOp::Shl,
                left: InsnArg::reg(1),
                right: InsnArg::Literal(LiteralArg::Int(0)),
            },
            0,
        );

        let result = simplify_insn(&insn, None);
        assert!(result.is_some());
        assert!(matches!(&result.unwrap().insn_type, InsnType::Move { .. }));
    }

    #[test]
    fn test_xor_zero_non_boolean() {
        // For non-boolean: x ^ 0 → x
        let insn = InsnNode::new(
            InsnType::Binary {
                dest: RegisterArg::new(0),
                op: BinaryOp::Xor,
                left: InsnArg::reg(1),
                right: InsnArg::Literal(LiteralArg::Int(0)),
            },
            0,
        );

        // No type info - should still simplify x ^ 0 → x
        let result = simplify_insn(&insn, None);
        assert!(result.is_some());
        assert!(matches!(&result.unwrap().insn_type, InsnType::Move { .. }));
    }

    #[test]
    fn test_rem_one_constant_fold() {
        // x % 1 → 0
        let insn = InsnNode::new(
            InsnType::Binary {
                dest: RegisterArg::new(0),
                op: BinaryOp::Rem,
                left: InsnArg::reg(1),
                right: InsnArg::Literal(LiteralArg::Int(1)),
            },
            0,
        );

        let result = simplify_insn(&insn, None);
        assert!(result.is_some());
        let simplified = result.unwrap();
        match &simplified.insn_type {
            InsnType::Const { value: LiteralArg::Int(0), .. } => {}
            _ => panic!("Expected Const 0 instruction"),
        }
    }
}
