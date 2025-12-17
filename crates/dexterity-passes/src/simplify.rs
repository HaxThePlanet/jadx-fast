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
//! - `x - (-N)` → `x + N`
//! - `0 - x` → `-x`
//! - `x * -1` → `-x` (multiplication by negative one)
//! - `x / -1` → `-x` (division by negative one)
//!
//! ## Boolean simplifications
//! - `bool ^ 1` → `!bool`
//! - `bool ^ 0` → `bool` (move)
//!
//! ## Double negation elimination
//! - `--x` → `x` (arithmetic double negation)
//! - `~~x` → `x` (bitwise double NOT)
//! - `!!x` → `x` (boolean double NOT)
//!
//! ## CMP unwrapping in conditions
//! - `if (cmp_l(a, b) == 0)` → `if (a == b)`
//! - `if (cmp_l(a, b) != 0)` → `if (a != b)`
//! - `if (cmp_l(a, b) < 0)` → `if (a < b)`
//! - `if (cmp_l(a, b) <= 0)` → `if (a <= b)`
//! - `if (cmp_l(a, b) > 0)` → `if (a > b)`
//! - `if (cmp_l(a, b) >= 0)` → `if (a >= b)`
//!
//! Based on JADX's SimplifyVisitor patterns.

use std::collections::HashMap;
use dexterity_ir::instructions::{BinaryOp, CompareOp, IfCondition, InsnArg, InsnNode, InsnType, LiteralArg, UnaryOp, RegisterArg};
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

    // Phase 1: Build maps of register definitions for pattern matching
    // Maps (reg_num, ssa_version) -> (UnaryOp, inner_arg) for unary operations
    let mut unary_defs: HashMap<(u16, u32), (UnaryOp, InsnArg)> = HashMap::new();
    // Maps (reg_num, ssa_version) -> (CompareOp, left, right) for CMP operations
    let mut cmp_defs: HashMap<(u16, u32), (CompareOp, InsnArg, InsnArg)> = HashMap::new();

    for block in &ssa.blocks {
        for insn in &block.instructions {
            match &insn.insn_type {
                InsnType::Unary { dest, op, arg } => {
                    unary_defs.insert((dest.reg_num, dest.ssa_version), (*op, arg.clone()));
                }
                InsnType::Compare { dest, op, left, right } => {
                    cmp_defs.insert((dest.reg_num, dest.ssa_version), (*op, left.clone(), right.clone()));
                }
                _ => {}
            }
        }
    }

    // Phase 2: Apply simplifications
    for block in &mut ssa.blocks {
        for insn in &mut block.instructions {
            if let Some(new_insn) = simplify_insn(insn, types, &unary_defs, &cmp_defs) {
                *insn = new_insn;
                simplified_count += 1;
            }
        }
    }

    SimplifyResult { simplified_count }
}

/// Try to simplify a single instruction
fn simplify_insn(
    insn: &InsnNode,
    types: Option<&HashMap<(u16, u32), ArgType>>,
    unary_defs: &HashMap<(u16, u32), (UnaryOp, InsnArg)>,
    cmp_defs: &HashMap<(u16, u32), (CompareOp, InsnArg, InsnArg)>,
) -> Option<InsnNode> {
    match &insn.insn_type {
        InsnType::Binary { dest, op, left, right } => {
            simplify_binary(*dest, *op, left.clone(), right.clone(), insn.offset, types)
        }
        InsnType::Unary { dest, op, arg } => {
            simplify_unary(*dest, *op, arg.clone(), insn.offset, unary_defs)
        }
        InsnType::If { condition, left, right, target } => {
            simplify_if(*condition, left.clone(), right.clone(), *target, insn.offset, cmp_defs)
        }
        _ => None,
    }
}

/// Simplify unary operations
/// Handles:
/// - Double negation: --x → x (arithmetic)
/// - Double NOT: ~~x → x (bitwise)
/// - Double boolean NOT: !!x → x
fn simplify_unary(
    dest: RegisterArg,
    op: UnaryOp,
    arg: InsnArg,
    offset: u32,
    unary_defs: &HashMap<(u16, u32), (UnaryOp, InsnArg)>,
) -> Option<InsnNode> {
    // Check if the argument is a register defined by another unary operation
    if let InsnArg::Register(reg) = &arg {
        if let Some((inner_op, inner_arg)) = unary_defs.get(&(reg.reg_num, reg.ssa_version)) {
            // Double negation elimination: -(-x) → x
            if op == UnaryOp::Neg && *inner_op == UnaryOp::Neg {
                return Some(InsnNode::new(
                    InsnType::Move { dest, src: inner_arg.clone() },
                    offset,
                ));
            }
            // Double bitwise NOT elimination: ~~x → x
            if op == UnaryOp::Not && *inner_op == UnaryOp::Not {
                return Some(InsnNode::new(
                    InsnType::Move { dest, src: inner_arg.clone() },
                    offset,
                ));
            }
            // Double boolean NOT elimination: !!x → x
            if op == UnaryOp::BoolNot && *inner_op == UnaryOp::BoolNot {
                return Some(InsnNode::new(
                    InsnType::Move { dest, src: inner_arg.clone() },
                    offset,
                ));
            }
        }
    }
    None
}

/// Simplify If conditions with CMP unwrapping
/// Handles patterns like:
/// - `if (cmp_l(a, b) == 0)` → `if (a == b)`
/// - `if (cmp_l(a, b) != 0)` → `if (a != b)`
/// - `if (cmp_l(a, b) < 0)` → `if (a < b)`
/// - `if (cmp_l(a, b) <= 0)` → `if (a <= b)`
/// - `if (cmp_l(a, b) > 0)` → `if (a > b)`
/// - `if (cmp_l(a, b) >= 0)` → `if (a >= b)`
fn simplify_if(
    condition: IfCondition,
    left: InsnArg,
    right: Option<InsnArg>,
    target: u32,
    offset: u32,
    cmp_defs: &HashMap<(u16, u32), (CompareOp, InsnArg, InsnArg)>,
) -> Option<InsnNode> {
    // CMP unwrapping: if (cmp_result OP 0) -> if (cmp_left OP cmp_right)
    // Only applies when comparing a CMP result to zero

    // Check if left is a register that was defined by a CMP instruction
    if let InsnArg::Register(reg) = &left {
        if let Some((_, cmp_left, cmp_right)) = cmp_defs.get(&(reg.reg_num, reg.ssa_version)) {
            // Check if we're comparing to zero
            let comparing_to_zero = match &right {
                Some(InsnArg::Literal(LiteralArg::Int(0))) => true,
                None => true, // *z variants implicitly compare to 0
                _ => false,
            };

            if comparing_to_zero {
                // CMP returns -1 (a < b), 0 (a == b), or 1 (a > b)
                // So: cmp(a,b) == 0 means a == b
                //     cmp(a,b) != 0 means a != b
                //     cmp(a,b) < 0 means a < b
                //     cmp(a,b) <= 0 means a <= b
                //     cmp(a,b) > 0 means a > b
                //     cmp(a,b) >= 0 means a >= b
                return Some(InsnNode::new(
                    InsnType::If {
                        condition,  // The condition stays the same!
                        left: cmp_left.clone(),
                        right: Some(cmp_right.clone()),
                        target,
                    },
                    offset,
                ));
            }
        }
    }

    None
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

/// Check if an argument is negative one (-1)
/// Used for x * -1 → -x simplification
fn is_negative_one_literal(arg: &InsnArg) -> bool {
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
            // x - (-N) → x + N (subtracting a negative)
            if let Some(neg_val) = get_negative_literal(&right) {
                return Some(InsnNode::new(
                    InsnType::Binary {
                        dest,
                        op: BinaryOp::Add,
                        left,
                        right: InsnArg::Literal(LiteralArg::Int(neg_val)),
                    },
                    offset,
                ));
            }
            // 0 - x → -x (negation)
            if is_zero_literal(&left) {
                return Some(InsnNode::new(
                    InsnType::Unary { dest, op: UnaryOp::Neg, arg: right },
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
            // x * -1 → -x (multiplication by negative one)
            if is_negative_one_literal(&right) {
                return Some(InsnNode::new(
                    InsnType::Unary { dest, op: UnaryOp::Neg, arg: left },
                    offset,
                ));
            }
            // -1 * x → -x
            if is_negative_one_literal(&left) {
                return Some(InsnNode::new(
                    InsnType::Unary { dest, op: UnaryOp::Neg, arg: right },
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
            // x / -1 → -x (division by negative one)
            if is_negative_one_literal(&right) {
                return Some(InsnNode::new(
                    InsnType::Unary { dest, op: UnaryOp::Neg, arg: left },
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

    // Helper for tests that don't need unary_defs/cmp_defs tracking
    fn simplify_insn_simple(insn: &InsnNode, types: Option<&HashMap<(u16, u32), ArgType>>) -> Option<InsnNode> {
        let empty_unary_defs = HashMap::new();
        let empty_cmp_defs = HashMap::new();
        simplify_insn(insn, types, &empty_unary_defs, &empty_cmp_defs)
    }

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

        let result = simplify_insn_simple(&insn, None);
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

        let result = simplify_insn_simple(&insn, None);
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

        let result = simplify_insn_simple(&insn, Some(&types));
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

        let result = simplify_insn_simple(&insn, Some(&types));
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

        let result = simplify_insn_simple(&insn, Some(&types));
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

        let result = simplify_insn_simple(&insn, None);
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

        let result = simplify_insn_simple(&insn, None);
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

        let result = simplify_insn_simple(&insn, None);
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

        let result = simplify_insn_simple(&insn, None);
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

        let result = simplify_insn_simple(&insn, None);
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

        let result = simplify_insn_simple(&insn, None);
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

        let result = simplify_insn_simple(&insn, None);
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

        let result = simplify_insn_simple(&insn, None);
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

        let result = simplify_insn_simple(&insn, None);
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
        let result = simplify_insn_simple(&insn, None);
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

        let result = simplify_insn_simple(&insn, None);
        assert!(result.is_some());
        let simplified = result.unwrap();
        match &simplified.insn_type {
            InsnType::Const { value: LiteralArg::Int(0), .. } => {}
            _ => panic!("Expected Const 0 instruction"),
        }
    }

    #[test]
    fn test_sub_negative_simplification() {
        // x - (-5) → x + 5
        let insn = InsnNode::new(
            InsnType::Binary {
                dest: RegisterArg::new(0),
                op: BinaryOp::Sub,
                left: InsnArg::reg(1),
                right: InsnArg::Literal(LiteralArg::Int(-5)),
            },
            0,
        );

        let result = simplify_insn_simple(&insn, None);
        assert!(result.is_some());

        let simplified = result.unwrap();
        match &simplified.insn_type {
            InsnType::Binary { op, right, .. } => {
                assert_eq!(*op, BinaryOp::Add);
                assert!(matches!(right, InsnArg::Literal(LiteralArg::Int(5))));
            }
            _ => panic!("Expected Binary Add instruction"),
        }
    }

    #[test]
    fn test_zero_minus_x_negation() {
        // 0 - x → -x
        let insn = InsnNode::new(
            InsnType::Binary {
                dest: RegisterArg::new(0),
                op: BinaryOp::Sub,
                left: InsnArg::Literal(LiteralArg::Int(0)),
                right: InsnArg::reg(1),
            },
            0,
        );

        let result = simplify_insn_simple(&insn, None);
        assert!(result.is_some());

        let simplified = result.unwrap();
        match &simplified.insn_type {
            InsnType::Unary { op, .. } => {
                assert_eq!(*op, UnaryOp::Neg);
            }
            _ => panic!("Expected Unary Neg instruction"),
        }
    }

    #[test]
    fn test_mul_negative_one() {
        // x * -1 → -x
        let insn = InsnNode::new(
            InsnType::Binary {
                dest: RegisterArg::new(0),
                op: BinaryOp::Mul,
                left: InsnArg::reg(1),
                right: InsnArg::Literal(LiteralArg::Int(-1)),
            },
            0,
        );

        let result = simplify_insn_simple(&insn, None);
        assert!(result.is_some());

        let simplified = result.unwrap();
        match &simplified.insn_type {
            InsnType::Unary { op, arg, .. } => {
                assert_eq!(*op, UnaryOp::Neg);
                assert!(matches!(arg, InsnArg::Register(_)));
            }
            _ => panic!("Expected Unary Neg instruction"),
        }
    }

    #[test]
    fn test_div_negative_one() {
        // x / -1 → -x
        let insn = InsnNode::new(
            InsnType::Binary {
                dest: RegisterArg::new(0),
                op: BinaryOp::Div,
                left: InsnArg::reg(1),
                right: InsnArg::Literal(LiteralArg::Int(-1)),
            },
            0,
        );

        let result = simplify_insn_simple(&insn, None);
        assert!(result.is_some());

        let simplified = result.unwrap();
        match &simplified.insn_type {
            InsnType::Unary { op, arg, .. } => {
                assert_eq!(*op, UnaryOp::Neg);
                assert!(matches!(arg, InsnArg::Register(_)));
            }
            _ => panic!("Expected Unary Neg instruction"),
        }
    }

    #[test]
    fn test_neg_one_mul_x() {
        // -1 * x → -x
        let insn = InsnNode::new(
            InsnType::Binary {
                dest: RegisterArg::new(0),
                op: BinaryOp::Mul,
                left: InsnArg::Literal(LiteralArg::Int(-1)),
                right: InsnArg::reg(1),
            },
            0,
        );

        let result = simplify_insn_simple(&insn, None);
        assert!(result.is_some());

        let simplified = result.unwrap();
        match &simplified.insn_type {
            InsnType::Unary { op, arg, .. } => {
                assert_eq!(*op, UnaryOp::Neg);
                assert!(matches!(arg, InsnArg::Register(_)));
            }
            _ => panic!("Expected Unary Neg instruction"),
        }
    }

    #[test]
    fn test_double_negation_elimination() {
        // --x → x (double arithmetic negation)
        // First: r1 = -r0
        // Second: r2 = -r1
        // Result: r2 = r0 (move)

        let mut unary_defs: HashMap<(u16, u32), (UnaryOp, InsnArg)> = HashMap::new();
        let empty_cmp_defs: HashMap<(u16, u32), (CompareOp, InsnArg, InsnArg)> = HashMap::new();
        // r1_0 was defined as -r0_0
        unary_defs.insert((1, 0), (UnaryOp::Neg, InsnArg::Register(RegisterArg::with_ssa(0, 0))));

        // Now simplify r2 = -r1_0
        let insn = InsnNode::new(
            InsnType::Unary {
                dest: RegisterArg::with_ssa(2, 0),
                op: UnaryOp::Neg,
                arg: InsnArg::Register(RegisterArg::with_ssa(1, 0)),
            },
            0,
        );

        let result = simplify_insn(&insn, None, &unary_defs, &empty_cmp_defs);
        assert!(result.is_some(), "Double negation should be simplified");

        let simplified = result.unwrap();
        match &simplified.insn_type {
            InsnType::Move { dest, src } => {
                assert_eq!(dest.reg_num, 2);
                // src should be r0_0 (the original value)
                if let InsnArg::Register(reg) = src {
                    assert_eq!(reg.reg_num, 0);
                    assert_eq!(reg.ssa_version, 0);
                } else {
                    panic!("Expected Register source");
                }
            }
            _ => panic!("Expected Move instruction for double negation elimination"),
        }
    }

    #[test]
    fn test_double_bitwise_not_elimination() {
        // ~~x → x (double bitwise NOT)
        let mut unary_defs: HashMap<(u16, u32), (UnaryOp, InsnArg)> = HashMap::new();
        let empty_cmp_defs: HashMap<(u16, u32), (CompareOp, InsnArg, InsnArg)> = HashMap::new();
        // r1_0 was defined as ~r0_0
        unary_defs.insert((1, 0), (UnaryOp::Not, InsnArg::Register(RegisterArg::with_ssa(0, 0))));

        // Now simplify r2 = ~r1_0
        let insn = InsnNode::new(
            InsnType::Unary {
                dest: RegisterArg::with_ssa(2, 0),
                op: UnaryOp::Not,
                arg: InsnArg::Register(RegisterArg::with_ssa(1, 0)),
            },
            0,
        );

        let result = simplify_insn(&insn, None, &unary_defs, &empty_cmp_defs);
        assert!(result.is_some(), "Double bitwise NOT should be simplified");

        let simplified = result.unwrap();
        assert!(matches!(&simplified.insn_type, InsnType::Move { .. }));
    }

    #[test]
    fn test_double_bool_not_elimination() {
        // !!x → x (double boolean NOT)
        let mut unary_defs: HashMap<(u16, u32), (UnaryOp, InsnArg)> = HashMap::new();
        let empty_cmp_defs: HashMap<(u16, u32), (CompareOp, InsnArg, InsnArg)> = HashMap::new();
        // r1_0 was defined as !r0_0
        unary_defs.insert((1, 0), (UnaryOp::BoolNot, InsnArg::Register(RegisterArg::with_ssa(0, 0))));

        // Now simplify r2 = !r1_0
        let insn = InsnNode::new(
            InsnType::Unary {
                dest: RegisterArg::with_ssa(2, 0),
                op: UnaryOp::BoolNot,
                arg: InsnArg::Register(RegisterArg::with_ssa(1, 0)),
            },
            0,
        );

        let result = simplify_insn(&insn, None, &unary_defs, &empty_cmp_defs);
        assert!(result.is_some(), "Double boolean NOT should be simplified");

        let simplified = result.unwrap();
        assert!(matches!(&simplified.insn_type, InsnType::Move { .. }));
    }

    #[test]
    fn test_mixed_negation_not_simplified() {
        // -~x should NOT be simplified (different ops)
        let mut unary_defs: HashMap<(u16, u32), (UnaryOp, InsnArg)> = HashMap::new();
        let empty_cmp_defs: HashMap<(u16, u32), (CompareOp, InsnArg, InsnArg)> = HashMap::new();
        // r1_0 was defined as ~r0_0
        unary_defs.insert((1, 0), (UnaryOp::Not, InsnArg::Register(RegisterArg::with_ssa(0, 0))));

        // Now try to simplify r2 = -r1_0 (Neg of Not)
        let insn = InsnNode::new(
            InsnType::Unary {
                dest: RegisterArg::with_ssa(2, 0),
                op: UnaryOp::Neg,  // Different from Not
                arg: InsnArg::Register(RegisterArg::with_ssa(1, 0)),
            },
            0,
        );

        let result = simplify_insn(&insn, None, &unary_defs, &empty_cmp_defs);
        assert!(result.is_none(), "Mixed negation types should NOT be simplified");
    }

    #[test]
    fn test_cmp_unwrapping_eq_zero() {
        // Pattern: if (cmp_l(a, b) == 0) → if (a == b)
        let empty_unary_defs: HashMap<(u16, u32), (UnaryOp, InsnArg)> = HashMap::new();
        let mut cmp_defs: HashMap<(u16, u32), (CompareOp, InsnArg, InsnArg)> = HashMap::new();

        // r0_0 was defined as cmp_long(r1_0, r2_0)
        cmp_defs.insert(
            (0, 0),
            (
                CompareOp::CmpLong,
                InsnArg::Register(RegisterArg::with_ssa(1, 0)),
                InsnArg::Register(RegisterArg::with_ssa(2, 0)),
            ),
        );

        // if (r0_0 == 0) goto target
        let insn = InsnNode::new(
            InsnType::If {
                condition: IfCondition::Eq,
                left: InsnArg::Register(RegisterArg::with_ssa(0, 0)),
                right: Some(InsnArg::Literal(LiteralArg::Int(0))),
                target: 100,
            },
            0,
        );

        let result = simplify_insn(&insn, None, &empty_unary_defs, &cmp_defs);
        assert!(result.is_some(), "CMP unwrapping should work");

        let simplified = result.unwrap();
        match &simplified.insn_type {
            InsnType::If { condition, left, right, target } => {
                assert_eq!(*condition, IfCondition::Eq);
                assert_eq!(*target, 100);
                // left should be r1_0, right should be r2_0
                if let InsnArg::Register(reg) = left {
                    assert_eq!(reg.reg_num, 1);
                } else {
                    panic!("Expected Register left");
                }
                if let Some(InsnArg::Register(reg)) = right {
                    assert_eq!(reg.reg_num, 2);
                } else {
                    panic!("Expected Register right");
                }
            }
            _ => panic!("Expected If instruction"),
        }
    }

    #[test]
    fn test_cmp_unwrapping_lt_zero() {
        // Pattern: if (cmp_l(a, b) < 0) → if (a < b)
        let empty_unary_defs: HashMap<(u16, u32), (UnaryOp, InsnArg)> = HashMap::new();
        let mut cmp_defs: HashMap<(u16, u32), (CompareOp, InsnArg, InsnArg)> = HashMap::new();

        cmp_defs.insert(
            (0, 0),
            (
                CompareOp::CmpLong,
                InsnArg::Register(RegisterArg::with_ssa(1, 0)),
                InsnArg::Register(RegisterArg::with_ssa(2, 0)),
            ),
        );

        // if (r0_0 < 0) goto target (Ltz - less than zero)
        let insn = InsnNode::new(
            InsnType::If {
                condition: IfCondition::Lt,
                left: InsnArg::Register(RegisterArg::with_ssa(0, 0)),
                right: Some(InsnArg::Literal(LiteralArg::Int(0))),
                target: 200,
            },
            0,
        );

        let result = simplify_insn(&insn, None, &empty_unary_defs, &cmp_defs);
        assert!(result.is_some(), "CMP unwrapping with Lt should work");

        let simplified = result.unwrap();
        match &simplified.insn_type {
            InsnType::If { condition, .. } => {
                assert_eq!(*condition, IfCondition::Lt);
            }
            _ => panic!("Expected If instruction"),
        }
    }

    #[test]
    fn test_cmp_unwrapping_z_variant() {
        // Pattern: if (cmp_l(a, b) == 0) with no explicit right (zero variant)
        let empty_unary_defs: HashMap<(u16, u32), (UnaryOp, InsnArg)> = HashMap::new();
        let mut cmp_defs: HashMap<(u16, u32), (CompareOp, InsnArg, InsnArg)> = HashMap::new();

        cmp_defs.insert(
            (0, 0),
            (
                CompareOp::CmpLong,
                InsnArg::Register(RegisterArg::with_ssa(1, 0)),
                InsnArg::Register(RegisterArg::with_ssa(2, 0)),
            ),
        );

        // if-eqz r0_0 (no explicit right operand, implicitly comparing to 0)
        let insn = InsnNode::new(
            InsnType::If {
                condition: IfCondition::Eq,
                left: InsnArg::Register(RegisterArg::with_ssa(0, 0)),
                right: None,  // *z variants have no explicit right
                target: 300,
            },
            0,
        );

        let result = simplify_insn(&insn, None, &empty_unary_defs, &cmp_defs);
        assert!(result.is_some(), "CMP unwrapping with *z variant should work");

        let simplified = result.unwrap();
        assert!(matches!(&simplified.insn_type, InsnType::If { .. }));
    }

    #[test]
    fn test_cmp_unwrapping_non_zero_not_simplified() {
        // Comparing CMP result to non-zero should NOT be simplified
        let empty_unary_defs: HashMap<(u16, u32), (UnaryOp, InsnArg)> = HashMap::new();
        let mut cmp_defs: HashMap<(u16, u32), (CompareOp, InsnArg, InsnArg)> = HashMap::new();

        cmp_defs.insert(
            (0, 0),
            (
                CompareOp::CmpLong,
                InsnArg::Register(RegisterArg::with_ssa(1, 0)),
                InsnArg::Register(RegisterArg::with_ssa(2, 0)),
            ),
        );

        // if (r0_0 == 1) - comparing to 1, not 0
        let insn = InsnNode::new(
            InsnType::If {
                condition: IfCondition::Eq,
                left: InsnArg::Register(RegisterArg::with_ssa(0, 0)),
                right: Some(InsnArg::Literal(LiteralArg::Int(1))),  // Not zero!
                target: 400,
            },
            0,
        );

        let result = simplify_insn(&insn, None, &empty_unary_defs, &cmp_defs);
        assert!(result.is_none(), "CMP unwrapping with non-zero comparison should NOT be simplified");
    }
}
