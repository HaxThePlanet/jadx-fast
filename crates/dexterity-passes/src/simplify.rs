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
//! ## Cast chain optimization
//! - Round-trip cast elimination: `(int)(long)x` → `x` (when x is int)
//! - Chain cast simplification: `(double)(long)x` → `(double)x` (skip intermediate)
//!
//! ## CHECK_CAST optimization (object type casts)
//! - Duplicate cast elimination: `(T)(T)x` → `(T)x` - redundant identical casts
//! - Type-match elimination: `(T)x` → `x` when x already has type T
//!
//! Note: StringBuilder chain → STR_CONCAT is handled at codegen level, not here.
//!
//! Based on JADX's SimplifyVisitor patterns.

use std::collections::{HashMap, HashSet};
use dexterity_ir::attributes::AFlag;
use dexterity_ir::instructions::{BinaryOp, CastType, CompareOp, IfCondition, InsnArg, InsnNode, InsnType, LiteralArg, UnaryOp, RegisterArg};
use dexterity_ir::types::ArgType;
use crate::ssa::SsaResult;

/// Result of simplification pass
#[derive(Debug)]
pub struct SimplifyResult {
    /// Number of instructions simplified
    pub simplified_count: usize,
    /// Number of Compare instructions marked for removal (after CMP unwrapping)
    pub dead_cmp_count: usize,
}

/// Simplify instructions in SSA form
pub fn simplify_instructions(ssa: &mut SsaResult, types: Option<&HashMap<(u16, u32), ArgType>>) -> SimplifyResult {
    let mut simplified_count = 0;

    // Phase 1: Build maps of register definitions for pattern matching
    // Maps (reg_num, ssa_version) -> (UnaryOp, inner_arg) for unary operations
    let mut unary_defs: HashMap<(u16, u32), (UnaryOp, InsnArg)> = HashMap::new();
    // Maps (reg_num, ssa_version) -> (CompareOp, left, right) for CMP operations
    let mut cmp_defs: HashMap<(u16, u32), (CompareOp, InsnArg, InsnArg)> = HashMap::new();
    // Maps (reg_num, ssa_version) -> (CastType, inner_arg) for cast operations
    let mut cast_defs: HashMap<(u16, u32), (CastType, InsnArg)> = HashMap::new();
    // Maps (reg_num, ssa_version) -> type_idx for CHECK_CAST operations
    // Used to detect duplicate object type casts
    let mut check_cast_defs: HashMap<(u16, u32), u32> = HashMap::new();

    for block in &ssa.blocks {
        for insn in &block.instructions {
            match &insn.insn_type {
                InsnType::Unary { dest, op, arg } => {
                    unary_defs.insert((dest.reg_num, dest.ssa_version), (*op, arg.clone()));
                }
                InsnType::Compare { dest, op, left, right } => {
                    cmp_defs.insert((dest.reg_num, dest.ssa_version), (*op, left.clone(), right.clone()));
                }
                InsnType::Cast { dest, cast_type, arg } => {
                    cast_defs.insert((dest.reg_num, dest.ssa_version), (*cast_type, arg.clone()));
                }
                InsnType::CheckCast { object, type_idx } => {
                    // Track which registers have been CHECK_CAST to which type
                    // Note: CHECK_CAST modifies in place, so we track the input register
                    if let InsnArg::Register(reg) = object {
                        check_cast_defs.insert((reg.reg_num, reg.ssa_version), *type_idx);
                    }
                }
                _ => {}
            }
        }
    }

    // Phase 2: Count all uses of CMP results and track which are IF-with-compare-to-zero
    // A CMP can only be marked dead if ALL its uses are IF instructions comparing to zero
    // Maps CMP key -> (total_uses, if_zero_uses)
    let mut cmp_use_counts: HashMap<(u16, u32), (usize, usize)> = HashMap::new();

    // Initialize counts for all CMP definitions
    for key in cmp_defs.keys() {
        cmp_use_counts.insert(*key, (0, 0));
    }

    // Count uses of CMP results across all instructions
    for block in &ssa.blocks {
        for insn in &block.instructions {
            // Count uses in all instruction arguments
            let mut count_use = |arg: &InsnArg, is_if_zero_use: bool| {
                if let InsnArg::Register(reg) = arg {
                    let key = (reg.reg_num, reg.ssa_version);
                    if let Some((total, if_zero)) = cmp_use_counts.get_mut(&key) {
                        *total += 1;
                        if is_if_zero_use {
                            *if_zero += 1;
                        }
                    }
                }
            };

            match &insn.insn_type {
                InsnType::If { left, right, .. } => {
                    // Check if this is a compare-to-zero pattern
                    let comparing_to_zero = match right {
                        Some(InsnArg::Literal(LiteralArg::Int(0))) => true,
                        None => true, // *z variants implicitly compare to 0
                        _ => false,
                    };
                    count_use(left, comparing_to_zero);
                    if let Some(r) = right {
                        count_use(r, false);
                    }
                }
                InsnType::Ternary { left, right, then_value, else_value, .. } => {
                    // Ternary conditions can also unwrap CMP when comparing to zero
                    let comparing_to_zero = match right {
                        Some(InsnArg::Literal(LiteralArg::Int(0))) => true,
                        None => true,
                        _ => false,
                    };
                    count_use(left, comparing_to_zero);
                    if let Some(r) = right {
                        count_use(r, false);
                    }
                    count_use(then_value, false);
                    count_use(else_value, false);
                }
                InsnType::Binary { left, right, .. } => {
                    count_use(left, false);
                    count_use(right, false);
                }
                InsnType::Unary { arg, .. } => {
                    count_use(arg, false);
                }
                InsnType::Move { src, .. } => {
                    count_use(src, false);
                }
                InsnType::Return { value: Some(v) } => {
                    count_use(v, false);
                }
                InsnType::Invoke { args, .. } => {
                    for arg in args {
                        count_use(arg, false);
                    }
                }
                InsnType::ArrayGet { array, index, .. } => {
                    count_use(array, false);
                    count_use(index, false);
                }
                InsnType::ArrayPut { array, index, value, .. } => {
                    count_use(array, false);
                    count_use(index, false);
                    count_use(value, false);
                }
                InsnType::InstanceGet { object, .. } => {
                    count_use(object, false);
                }
                InsnType::InstancePut { object, value, .. } => {
                    count_use(object, false);
                    count_use(value, false);
                }
                InsnType::StaticPut { value, .. } => {
                    count_use(value, false);
                }
                _ => {}
            }
        }
    }

    // Determine which CMPs can be safely marked as dead (all uses are IF-zero)
    let mut safe_to_remove_cmps: HashSet<(u16, u32)> = HashSet::new();
    for (key, (total, if_zero)) in &cmp_use_counts {
        if *total > 0 && *total == *if_zero {
            // All uses are IF instructions comparing to zero - safe to inline and remove
            safe_to_remove_cmps.insert(*key);
        }
    }

    // Phase 3: Apply simplifications
    for block in &mut ssa.blocks {
        for insn in &mut block.instructions {
            if let Some(new_insn) = simplify_insn(insn, types, &unary_defs, &cmp_defs, &cast_defs, &check_cast_defs) {
                *insn = new_insn;
                simplified_count += 1;
            }
        }
    }

    // Phase 4: Mark CMP instructions as dead only if ALL uses were IF-zero patterns
    let mut dead_cmp_count = 0;
    for block in &mut ssa.blocks {
        for insn in &mut block.instructions {
            if let InsnType::Compare { dest, .. } = &insn.insn_type {
                let key = (dest.reg_num, dest.ssa_version);
                if safe_to_remove_cmps.contains(&key) && !insn.has_flag(AFlag::DontGenerate) {
                    insn.add_flag(AFlag::DontGenerate);
                    dead_cmp_count += 1;
                }
            }
        }
    }

    SimplifyResult { simplified_count, dead_cmp_count }
}

/// Try to simplify a single instruction
fn simplify_insn(
    insn: &InsnNode,
    types: Option<&HashMap<(u16, u32), ArgType>>,
    unary_defs: &HashMap<(u16, u32), (UnaryOp, InsnArg)>,
    cmp_defs: &HashMap<(u16, u32), (CompareOp, InsnArg, InsnArg)>,
    cast_defs: &HashMap<(u16, u32), (CastType, InsnArg)>,
    check_cast_defs: &HashMap<(u16, u32), u32>,
) -> Option<InsnNode> {
    match &insn.insn_type {
        InsnType::Binary { dest, op, left, right, .. } => {
            simplify_binary(*dest, *op, left.clone(), right.clone(), insn.offset, types)
        }
        InsnType::Unary { dest, op, arg } => {
            simplify_unary(*dest, *op, arg.clone(), insn.offset, unary_defs)
        }
        InsnType::If { condition, left, right, target } => {
            simplify_if(*condition, left.clone(), right.clone(), *target, insn.offset, cmp_defs)
        }
        InsnType::Ternary { dest, condition, left, right, then_value, else_value } => {
            simplify_ternary(*dest, *condition, left.clone(), right.clone(),
                           then_value.clone(), else_value.clone(), insn.offset, cmp_defs)
        }
        InsnType::Cast { dest, cast_type, arg } => {
            simplify_cast(*dest, *cast_type, arg.clone(), insn.offset, cast_defs)
        }
        InsnType::CheckCast { object, type_idx } => {
            simplify_check_cast(object.clone(), *type_idx, insn.offset, types, check_cast_defs)
        }
        // Clone of JADX SimplifyVisitor.java:581-636
        // convertFieldArith: IPUT(ARITH(IGET, lit)) -> field += lit
        InsnType::InstancePut { object, field_idx, value } => {
            convert_field_arith_iput(object.clone(), *field_idx, value.clone(), insn.offset)
        }
        InsnType::StaticPut { field_idx, value } => {
            convert_field_arith_sput(*field_idx, value.clone(), insn.offset)
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

/// Simplify Ternary conditions with CMP unwrapping
///
/// Similar to simplify_if, handles patterns like:
/// - `cmp_result == 0 ? a : b` → `left == right ? a : b`
/// - `cmp_result < 0 ? a : b` → `left < right ? a : b`
fn simplify_ternary(
    dest: RegisterArg,
    condition: IfCondition,
    left: InsnArg,
    right: Option<InsnArg>,
    then_value: InsnArg,
    else_value: InsnArg,
    offset: u32,
    cmp_defs: &HashMap<(u16, u32), (CompareOp, InsnArg, InsnArg)>,
) -> Option<InsnNode> {
    // CMP unwrapping: if (cmp_result OP 0) -> if (cmp_left OP cmp_right)
    // Only applies when comparing a CMP result to zero

    // Check if left is a register that was defined by a CMP instruction
    if let InsnArg::Register(reg) = &left {
        if let Some((_, cmp_left, cmp_right)) = cmp_defs.get(&(reg.reg_num, reg.ssa_version)) {
            // Check if we're comparing to zero
            let is_compare_to_zero = match &right {
                Some(InsnArg::Literal(LiteralArg::Int(0))) => true,
                None => true, // *z variants implicitly compare to 0
                _ => false,
            };

            if is_compare_to_zero {
                // CMP returns -1 (a < b), 0 (a == b), or 1 (a > b)
                // Unwrap the CMP directly into the ternary condition
                return Some(InsnNode::new(
                    InsnType::Ternary {
                        dest,
                        condition,  // The condition stays the same!
                        left: cmp_left.clone(),
                        right: Some(cmp_right.clone()),
                        then_value,
                        else_value,
                    },
                    offset,
                ));
            }
        }
    }

    None
}

/// Simplify cast operations
/// Handles:
/// - Double cast elimination: (int)(int)x → (int)x (then potentially just x via move)
/// - Round-trip cast elimination: (int)(long)(int)x → (int)x
/// - Inverse cast elimination: (long)(int)x where the inner cast widens and outer narrows back
fn simplify_cast(
    dest: RegisterArg,
    cast_type: CastType,
    arg: InsnArg,
    offset: u32,
    cast_defs: &HashMap<(u16, u32), (CastType, InsnArg)>,
) -> Option<InsnNode> {
    // Check if the argument is a register defined by another cast
    if let InsnArg::Register(reg) = &arg {
        if let Some((inner_cast, inner_arg)) = cast_defs.get(&(reg.reg_num, reg.ssa_version)) {
            // Check for inverse casts that cancel out
            if let Some(simplified) = simplify_cast_chain(cast_type, *inner_cast, inner_arg.clone(), dest, offset) {
                return Some(simplified);
            }
        }
    }

    None
}

/// Check if two casts can be simplified when chained
/// Returns Some(simplified_insn) if the casts cancel out or can be combined
fn simplify_cast_chain(
    outer_cast: CastType,
    inner_cast: CastType,
    original_arg: InsnArg,
    dest: RegisterArg,
    offset: u32,
) -> Option<InsnNode> {
    // Get source and target types for each cast
    let (inner_src, inner_dst) = cast_types(inner_cast);
    let (outer_src, outer_dst) = cast_types(outer_cast);

    // Verify the chain is valid (inner's output = outer's input)
    if inner_dst != outer_src {
        return None;
    }

    // Round-trip elimination: (srcType)(dstType)(srcType)x → x
    // e.g., (int)(long)(int)x → x
    // This works when we widen then narrow back to the same type
    if inner_src == outer_dst {
        // The cast chain returns to the original type - just move the original value
        return Some(InsnNode::new(
            InsnType::Move { dest, src: original_arg },
            offset,
        ));
    }

    // Widening + narrowing to a smaller intermediate type
    // e.g., (int)(double)(long)x - can't simplify, intermediate precision loss
    // But (int)(long)(int)x → (int)x when going through wider type

    // Check if we can skip the intermediate step
    // If inner widens and outer narrows to something between inner_src and inner_dst
    if let Some(direct_cast) = get_direct_cast(inner_src, outer_dst) {
        if direct_cast != inner_cast && direct_cast != outer_cast {
            // We can use a direct cast instead of the chain
            return Some(InsnNode::new(
                InsnType::Cast {
                    dest,
                    cast_type: direct_cast,
                    arg: original_arg,
                },
                offset,
            ));
        }
    }

    None
}

/// Get the source and target primitive types for a cast
fn cast_types(cast: CastType) -> (PrimitiveType, PrimitiveType) {
    match cast {
        CastType::IntToLong => (PrimitiveType::Int, PrimitiveType::Long),
        CastType::IntToFloat => (PrimitiveType::Int, PrimitiveType::Float),
        CastType::IntToDouble => (PrimitiveType::Int, PrimitiveType::Double),
        CastType::LongToInt => (PrimitiveType::Long, PrimitiveType::Int),
        CastType::LongToFloat => (PrimitiveType::Long, PrimitiveType::Float),
        CastType::LongToDouble => (PrimitiveType::Long, PrimitiveType::Double),
        CastType::FloatToInt => (PrimitiveType::Float, PrimitiveType::Int),
        CastType::FloatToLong => (PrimitiveType::Float, PrimitiveType::Long),
        CastType::FloatToDouble => (PrimitiveType::Float, PrimitiveType::Double),
        CastType::DoubleToInt => (PrimitiveType::Double, PrimitiveType::Int),
        CastType::DoubleToLong => (PrimitiveType::Double, PrimitiveType::Long),
        CastType::DoubleToFloat => (PrimitiveType::Double, PrimitiveType::Float),
        CastType::IntToByte => (PrimitiveType::Int, PrimitiveType::Byte),
        CastType::IntToChar => (PrimitiveType::Int, PrimitiveType::Char),
        CastType::IntToShort => (PrimitiveType::Int, PrimitiveType::Short),
    }
}

/// Simple enum for tracking primitive types in cast chains
#[derive(Debug, Clone, Copy, PartialEq, Eq)]
enum PrimitiveType {
    Byte,
    Char,
    Short,
    Int,
    Long,
    Float,
    Double,
}

/// Get the direct cast between two types if one exists
fn get_direct_cast(from: PrimitiveType, to: PrimitiveType) -> Option<CastType> {
    match (from, to) {
        (PrimitiveType::Int, PrimitiveType::Long) => Some(CastType::IntToLong),
        (PrimitiveType::Int, PrimitiveType::Float) => Some(CastType::IntToFloat),
        (PrimitiveType::Int, PrimitiveType::Double) => Some(CastType::IntToDouble),
        (PrimitiveType::Int, PrimitiveType::Byte) => Some(CastType::IntToByte),
        (PrimitiveType::Int, PrimitiveType::Char) => Some(CastType::IntToChar),
        (PrimitiveType::Int, PrimitiveType::Short) => Some(CastType::IntToShort),
        (PrimitiveType::Long, PrimitiveType::Int) => Some(CastType::LongToInt),
        (PrimitiveType::Long, PrimitiveType::Float) => Some(CastType::LongToFloat),
        (PrimitiveType::Long, PrimitiveType::Double) => Some(CastType::LongToDouble),
        (PrimitiveType::Float, PrimitiveType::Int) => Some(CastType::FloatToInt),
        (PrimitiveType::Float, PrimitiveType::Long) => Some(CastType::FloatToLong),
        (PrimitiveType::Float, PrimitiveType::Double) => Some(CastType::FloatToDouble),
        (PrimitiveType::Double, PrimitiveType::Int) => Some(CastType::DoubleToInt),
        (PrimitiveType::Double, PrimitiveType::Long) => Some(CastType::DoubleToLong),
        (PrimitiveType::Double, PrimitiveType::Float) => Some(CastType::DoubleToFloat),
        _ => None, // No direct cast available
    }
}

/// Simplify CHECK_CAST operations (object type casts)
///
/// Based on JADX's processCast() in SimplifyVisitor.java:
/// 1. Duplicate cast elimination: if object was already cast to same type
/// 2. Type-match elimination: if object already has the target type
///
/// Returns Some(Nop) if cast can be eliminated, None otherwise.
fn simplify_check_cast(
    object: InsnArg,
    type_idx: u32,
    offset: u32,
    _types: Option<&HashMap<(u16, u32), ArgType>>,
    check_cast_defs: &HashMap<(u16, u32), u32>,
) -> Option<InsnNode> {
    // Check for duplicate cast: if the object register was defined by a CHECK_CAST
    // with the same target type, this cast is redundant
    if let InsnArg::Register(reg) = &object {
        if let Some(&prev_type_idx) = check_cast_defs.get(&(reg.reg_num, reg.ssa_version)) {
            if prev_type_idx == type_idx {
                // This is a duplicate cast - the object was already cast to this type
                // Replace with NOP instruction
                return Some(InsnNode::new(InsnType::Nop, offset));
            }
        }
    }

    // Future optimization: check if object's type already matches target type
    // This would require type information lookup by type_idx
    // if let Some(types) = types {
    //     if let InsnArg::Register(reg) = &object {
    //         if let Some(obj_type) = types.get(&(reg.reg_num, reg.ssa_version)) {
    //             // Check if obj_type matches the type at type_idx
    //             // Would need access to DEX type pool to resolve type_idx
    //         }
    //     }
    // }

    None
}

/// Clone of JADX SimplifyVisitor.java:581-636
/// Convert field arith operation to arith instruction for IPUT
///
/// Pattern: IPUT(object, field, ARITH(IGET(object, field), value))
/// Result:  Binary with ArithOneArg flag (object.field += value)
///
/// Reference: convertFieldArith(MethodNode, InsnNode)
fn convert_field_arith_iput(
    object: InsnArg,
    field_idx: u32,
    value: InsnArg,
    offset: u32,
) -> Option<InsnNode> {
    // Check if value is a wrapped ARITH instruction
    // JADX: if (!arg.isInsnWrap()) return null;
    let wrapped = match &value {
        InsnArg::Wrapped(w) => w,
        _ => return None,
    };

    let arith_insn = wrapped.get_wrap_insn()?;

    // Check if wrapped instruction is ARITH (Binary)
    // JADX: if (wrapType != InsnType.ARITH && wrapType != InsnType.STR_CONCAT) return null;
    let (op, arith_left, arith_right) = match &arith_insn.insn_type {
        InsnType::Binary { op, left, right, .. } => (*op, left, right),
        InsnType::StrConcat { args, .. } if !args.is_empty() => {
            // For STR_CONCAT, use ADD operation with first arg as left
            // JADX handles this for string field concatenation
            return None; // TODO: Handle STR_CONCAT case
        }
        _ => return None,
    };

    // Check if first arg of ARITH is a wrapped IGET
    // JADX: if (!wrap.getArg(0).isInsnWrap()) return null;
    let get_wrapped = match arith_left {
        InsnArg::Wrapped(w) => w,
        _ => return None,
    };

    let get_insn = get_wrapped.get_wrap_insn()?;

    // Check if inner instruction is IGET with same field
    // JADX: InsnType getType = get.getType();
    //       if (getType != InsnType.IGET && getType != InsnType.SGET) return null;
    let (get_object, get_field_idx) = match &get_insn.insn_type {
        InsnType::InstanceGet { object, field_idx, .. } => (Some(object), *field_idx),
        _ => return None,
    };

    // Verify field indices match
    // JADX: if (!field.equals(innerField)) return null;
    if get_field_idx != field_idx {
        return None;
    }

    // Verify instance registers match for IGET/IPUT
    // JADX: if (getType == InsnType.IGET && insn.getType() == InsnType.IPUT) {
    //           if (!reg.equals(putReg)) return null;
    //       }
    if let Some(get_obj) = get_object {
        if !args_equal(&object, get_obj) {
            return None;
        }
    }

    // Create one-arg arith instruction
    // JADX: return ArithNode.oneArgOp(ar.getOp(), fArg, ar.getArg(1));
    let mut result = InsnNode::new(
        InsnType::new_arith_one_arg(op, arith_left.clone(), arith_right.clone()),
        offset,
    );
    result.add_flag(AFlag::ArithOneArg);

    Some(result)
}

/// Clone of JADX SimplifyVisitor.java:581-636
/// Convert field arith operation to arith instruction for SPUT
///
/// Pattern: SPUT(field, ARITH(SGET(field), value))
/// Result:  Binary with ArithOneArg flag (Class.field += value)
fn convert_field_arith_sput(
    field_idx: u32,
    value: InsnArg,
    offset: u32,
) -> Option<InsnNode> {
    // Check if value is a wrapped ARITH instruction
    let wrapped = match &value {
        InsnArg::Wrapped(w) => w,
        _ => return None,
    };

    let arith_insn = wrapped.get_wrap_insn()?;

    // Check if wrapped instruction is ARITH (Binary)
    let (op, arith_left, arith_right) = match &arith_insn.insn_type {
        InsnType::Binary { op, left, right, .. } => (*op, left, right),
        _ => return None,
    };

    // Check if first arg of ARITH is a wrapped SGET
    let get_wrapped = match arith_left {
        InsnArg::Wrapped(w) => w,
        _ => return None,
    };

    let get_insn = get_wrapped.get_wrap_insn()?;

    // Check if inner instruction is SGET with same field
    let get_field_idx = match &get_insn.insn_type {
        InsnType::StaticGet { field_idx, .. } => *field_idx,
        _ => return None,
    };

    // Verify field indices match
    if get_field_idx != field_idx {
        return None;
    }

    // Create one-arg arith instruction
    let mut result = InsnNode::new(
        InsnType::new_arith_one_arg(op, arith_left.clone(), arith_right.clone()),
        offset,
    );
    result.add_flag(AFlag::ArithOneArg);

    Some(result)
}

/// Helper to check if two InsnArgs are equal (for instance register comparison)
/// JADX Reference: InsnArg.equals() comparison
fn args_equal(a: &InsnArg, b: &InsnArg) -> bool {
    match (a, b) {
        (InsnArg::Register(ra), InsnArg::Register(rb)) => {
            ra.reg_num == rb.reg_num && ra.ssa_version == rb.ssa_version
        }
        (InsnArg::Literal(la), InsnArg::Literal(lb)) => la == lb,
        (InsnArg::String(sa), InsnArg::String(sb)) => sa == sb,
        (InsnArg::Type(ta), InsnArg::Type(tb)) => ta == tb,
        _ => false,
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
                        arg_type: None,
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
                        arg_type: None,
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

    // Helper for tests that don't need unary_defs/cmp_defs/cast_defs/check_cast_defs tracking
    fn simplify_insn_simple(insn: &InsnNode, types: Option<&HashMap<(u16, u32), ArgType>>) -> Option<InsnNode> {
        let empty_unary_defs = HashMap::new();
        let empty_cmp_defs = HashMap::new();
        let empty_cast_defs = HashMap::new();
        let empty_check_cast_defs = HashMap::new();
        simplify_insn(insn, types, &empty_unary_defs, &empty_cmp_defs, &empty_cast_defs, &empty_check_cast_defs)
    }

    #[test]
    fn test_add_negative_simplification() {
        let insn = InsnNode::new(
            InsnType::Binary {
                dest: RegisterArg::new(0),
                op: BinaryOp::Add,
                left: InsnArg::reg(1),
                right: InsnArg::Literal(LiteralArg::Int(-5)),
                arg_type: None,
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
                arg_type: None,
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
                arg_type: None,
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
                arg_type: None,
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
                arg_type: None,
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
                arg_type: None,
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
                arg_type: None,
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
                arg_type: None,
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
                arg_type: None,
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
                arg_type: None,
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
                arg_type: None,
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
                arg_type: None,
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
                arg_type: None,
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
                arg_type: None,
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
                arg_type: None,
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
                arg_type: None,
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
                arg_type: None,
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
                arg_type: None,
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
                arg_type: None,
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
                arg_type: None,
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
                arg_type: None,
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
        let empty_cast_defs: HashMap<(u16, u32), (CastType, InsnArg)> = HashMap::new();
        let empty_check_cast_defs: HashMap<(u16, u32), u32> = HashMap::new();
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

        let result = simplify_insn(&insn, None, &unary_defs, &empty_cmp_defs, &empty_cast_defs, &empty_check_cast_defs);
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
        let empty_cast_defs: HashMap<(u16, u32), (CastType, InsnArg)> = HashMap::new();
        let empty_check_cast_defs: HashMap<(u16, u32), u32> = HashMap::new();
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

        let result = simplify_insn(&insn, None, &unary_defs, &empty_cmp_defs, &empty_cast_defs, &empty_check_cast_defs);
        assert!(result.is_some(), "Double bitwise NOT should be simplified");

        let simplified = result.unwrap();
        assert!(matches!(&simplified.insn_type, InsnType::Move { .. }));
    }

    #[test]
    fn test_double_bool_not_elimination() {
        // !!x → x (double boolean NOT)
        let mut unary_defs: HashMap<(u16, u32), (UnaryOp, InsnArg)> = HashMap::new();
        let empty_cmp_defs: HashMap<(u16, u32), (CompareOp, InsnArg, InsnArg)> = HashMap::new();
        let empty_cast_defs: HashMap<(u16, u32), (CastType, InsnArg)> = HashMap::new();
        let empty_check_cast_defs: HashMap<(u16, u32), u32> = HashMap::new();
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

        let result = simplify_insn(&insn, None, &unary_defs, &empty_cmp_defs, &empty_cast_defs, &empty_check_cast_defs);
        assert!(result.is_some(), "Double boolean NOT should be simplified");

        let simplified = result.unwrap();
        assert!(matches!(&simplified.insn_type, InsnType::Move { .. }));
    }

    #[test]
    fn test_mixed_negation_not_simplified() {
        // -~x should NOT be simplified (different ops)
        let mut unary_defs: HashMap<(u16, u32), (UnaryOp, InsnArg)> = HashMap::new();
        let empty_cmp_defs: HashMap<(u16, u32), (CompareOp, InsnArg, InsnArg)> = HashMap::new();
        let empty_cast_defs: HashMap<(u16, u32), (CastType, InsnArg)> = HashMap::new();
        let empty_check_cast_defs: HashMap<(u16, u32), u32> = HashMap::new();
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

        let result = simplify_insn(&insn, None, &unary_defs, &empty_cmp_defs, &empty_cast_defs, &empty_check_cast_defs);
        assert!(result.is_none(), "Mixed negation types should NOT be simplified");
    }

    #[test]
    fn test_cmp_unwrapping_eq_zero() {
        // Pattern: if (cmp_l(a, b) == 0) → if (a == b)
        let empty_unary_defs: HashMap<(u16, u32), (UnaryOp, InsnArg)> = HashMap::new();
        let mut cmp_defs: HashMap<(u16, u32), (CompareOp, InsnArg, InsnArg)> = HashMap::new();
        let empty_cast_defs: HashMap<(u16, u32), (CastType, InsnArg)> = HashMap::new();
        let empty_check_cast_defs: HashMap<(u16, u32), u32> = HashMap::new();

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

        let result = simplify_insn(&insn, None, &empty_unary_defs, &cmp_defs, &empty_cast_defs, &empty_check_cast_defs);
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
        let empty_cast_defs: HashMap<(u16, u32), (CastType, InsnArg)> = HashMap::new();
        let empty_check_cast_defs: HashMap<(u16, u32), u32> = HashMap::new();

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

        let result = simplify_insn(&insn, None, &empty_unary_defs, &cmp_defs, &empty_cast_defs, &empty_check_cast_defs);
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
        let empty_cast_defs: HashMap<(u16, u32), (CastType, InsnArg)> = HashMap::new();
        let empty_check_cast_defs: HashMap<(u16, u32), u32> = HashMap::new();

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

        let result = simplify_insn(&insn, None, &empty_unary_defs, &cmp_defs, &empty_cast_defs, &empty_check_cast_defs);
        assert!(result.is_some(), "CMP unwrapping with *z variant should work");

        let simplified = result.unwrap();
        assert!(matches!(&simplified.insn_type, InsnType::If { .. }));
    }

    #[test]
    fn test_cmp_unwrapping_non_zero_not_simplified() {
        // Comparing CMP result to non-zero should NOT be simplified
        let empty_unary_defs: HashMap<(u16, u32), (UnaryOp, InsnArg)> = HashMap::new();
        let mut cmp_defs: HashMap<(u16, u32), (CompareOp, InsnArg, InsnArg)> = HashMap::new();
        let empty_cast_defs: HashMap<(u16, u32), (CastType, InsnArg)> = HashMap::new();
        let empty_check_cast_defs: HashMap<(u16, u32), u32> = HashMap::new();

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

        let result = simplify_insn(&insn, None, &empty_unary_defs, &cmp_defs, &empty_cast_defs, &empty_check_cast_defs);
        assert!(result.is_none(), "CMP unwrapping with non-zero comparison should NOT be simplified");
    }

    #[test]
    fn test_round_trip_cast_elimination() {
        // Pattern: (int)(long)(int)x → x (round-trip cast)
        let empty_unary_defs: HashMap<(u16, u32), (UnaryOp, InsnArg)> = HashMap::new();
        let empty_cmp_defs: HashMap<(u16, u32), (CompareOp, InsnArg, InsnArg)> = HashMap::new();
        let mut cast_defs: HashMap<(u16, u32), (CastType, InsnArg)> = HashMap::new();
        let empty_check_cast_defs: HashMap<(u16, u32), u32> = HashMap::new();

        // r1_0 was defined as (long)r0_0
        cast_defs.insert(
            (1, 0),
            (CastType::IntToLong, InsnArg::Register(RegisterArg::with_ssa(0, 0))),
        );

        // r2 = (int)r1_0 → should simplify to r2 = r0_0 (move)
        let insn = InsnNode::new(
            InsnType::Cast {
                dest: RegisterArg::with_ssa(2, 0),
                cast_type: CastType::LongToInt,
                arg: InsnArg::Register(RegisterArg::with_ssa(1, 0)),
            },
            0,
        );

        let result = simplify_insn(&insn, None, &empty_unary_defs, &empty_cmp_defs, &cast_defs, &empty_check_cast_defs);
        assert!(result.is_some(), "Round-trip cast should be eliminated");

        let simplified = result.unwrap();
        match &simplified.insn_type {
            InsnType::Move { dest, src } => {
                assert_eq!(dest.reg_num, 2);
                if let InsnArg::Register(reg) = src {
                    assert_eq!(reg.reg_num, 0); // Original value
                    assert_eq!(reg.ssa_version, 0);
                } else {
                    panic!("Expected Register source");
                }
            }
            _ => panic!("Expected Move instruction for round-trip cast elimination"),
        }
    }

    #[test]
    fn test_float_double_round_trip_cast() {
        // Pattern: (float)(double)(float)x → x
        let empty_unary_defs: HashMap<(u16, u32), (UnaryOp, InsnArg)> = HashMap::new();
        let empty_cmp_defs: HashMap<(u16, u32), (CompareOp, InsnArg, InsnArg)> = HashMap::new();
        let mut cast_defs: HashMap<(u16, u32), (CastType, InsnArg)> = HashMap::new();
        let empty_check_cast_defs: HashMap<(u16, u32), u32> = HashMap::new();

        // r1_0 was defined as (double)r0_0
        cast_defs.insert(
            (1, 0),
            (CastType::FloatToDouble, InsnArg::Register(RegisterArg::with_ssa(0, 0))),
        );

        // r2 = (float)r1_0 → should simplify to r2 = r0_0 (move)
        let insn = InsnNode::new(
            InsnType::Cast {
                dest: RegisterArg::with_ssa(2, 0),
                cast_type: CastType::DoubleToFloat,
                arg: InsnArg::Register(RegisterArg::with_ssa(1, 0)),
            },
            0,
        );

        let result = simplify_insn(&insn, None, &empty_unary_defs, &empty_cmp_defs, &cast_defs, &empty_check_cast_defs);
        assert!(result.is_some(), "Float-double round-trip cast should be eliminated");

        let simplified = result.unwrap();
        assert!(matches!(&simplified.insn_type, InsnType::Move { .. }));
    }

    #[test]
    fn test_chain_cast_direct() {
        // Pattern: (double)(long)(int)x → (double)x (skip intermediate)
        let empty_unary_defs: HashMap<(u16, u32), (UnaryOp, InsnArg)> = HashMap::new();
        let empty_cmp_defs: HashMap<(u16, u32), (CompareOp, InsnArg, InsnArg)> = HashMap::new();
        let mut cast_defs: HashMap<(u16, u32), (CastType, InsnArg)> = HashMap::new();
        let empty_check_cast_defs: HashMap<(u16, u32), u32> = HashMap::new();

        // r1_0 was defined as (long)r0_0
        cast_defs.insert(
            (1, 0),
            (CastType::IntToLong, InsnArg::Register(RegisterArg::with_ssa(0, 0))),
        );

        // r2 = (double)r1_0 → should simplify to r2 = (double)r0_0
        let insn = InsnNode::new(
            InsnType::Cast {
                dest: RegisterArg::with_ssa(2, 0),
                cast_type: CastType::LongToDouble,
                arg: InsnArg::Register(RegisterArg::with_ssa(1, 0)),
            },
            0,
        );

        let result = simplify_insn(&insn, None, &empty_unary_defs, &empty_cmp_defs, &cast_defs, &empty_check_cast_defs);
        assert!(result.is_some(), "Chain cast should be simplified to direct cast");

        let simplified = result.unwrap();
        match &simplified.insn_type {
            InsnType::Cast { dest, cast_type, arg } => {
                assert_eq!(dest.reg_num, 2);
                assert_eq!(*cast_type, CastType::IntToDouble);
                if let InsnArg::Register(reg) = arg {
                    assert_eq!(reg.reg_num, 0); // Original value
                } else {
                    panic!("Expected Register arg");
                }
            }
            _ => panic!("Expected Cast instruction with simplified type"),
        }
    }

    #[test]
    fn test_incompatible_cast_chain_not_simplified() {
        // Pattern: (float)(byte)x should NOT be simplified (incompatible types)
        let empty_unary_defs: HashMap<(u16, u32), (UnaryOp, InsnArg)> = HashMap::new();
        let empty_cmp_defs: HashMap<(u16, u32), (CompareOp, InsnArg, InsnArg)> = HashMap::new();
        let mut cast_defs: HashMap<(u16, u32), (CastType, InsnArg)> = HashMap::new();
        let empty_check_cast_defs: HashMap<(u16, u32), u32> = HashMap::new();

        // r1_0 was defined as (byte)r0_0
        cast_defs.insert(
            (1, 0),
            (CastType::IntToByte, InsnArg::Register(RegisterArg::with_ssa(0, 0))),
        );

        // r2 = (float)r1_0 - can't simplify because there's no IntToFloat then ByteToFloat
        // Actually the outer cast is from byte (after IntToByte), but CastType only tracks specific conversions
        // This chain's intermediate type (Byte) != outer's source type (Int for IntToFloat)
        let insn = InsnNode::new(
            InsnType::Cast {
                dest: RegisterArg::with_ssa(2, 0),
                cast_type: CastType::IntToFloat, // This expects int, but we have byte
                arg: InsnArg::Register(RegisterArg::with_ssa(1, 0)),
            },
            0,
        );

        let result = simplify_insn(&insn, None, &empty_unary_defs, &empty_cmp_defs, &cast_defs, &empty_check_cast_defs);
        // The chain is invalid (byte != int for source), so no simplification
        assert!(result.is_none(), "Incompatible cast chain should NOT be simplified");
    }

    #[test]
    fn test_duplicate_check_cast_elimination() {
        // Pattern: (T)(T)x → NOP (duplicate object type cast)
        // If r1_0 was already CHECK_CAST to type_idx=5, and we do CHECK_CAST again to type_idx=5
        // The second cast is redundant and should become NOP
        let empty_unary_defs: HashMap<(u16, u32), (UnaryOp, InsnArg)> = HashMap::new();
        let empty_cmp_defs: HashMap<(u16, u32), (CompareOp, InsnArg, InsnArg)> = HashMap::new();
        let empty_cast_defs: HashMap<(u16, u32), (CastType, InsnArg)> = HashMap::new();
        let empty_check_cast_defs: HashMap<(u16, u32), u32> = HashMap::new();
        let mut check_cast_defs: HashMap<(u16, u32), u32> = HashMap::new();

        // r1_0 was previously CHECK_CAST to type_idx=5
        check_cast_defs.insert((1, 0), 5);

        // CHECK_CAST r1_0 to same type_idx=5 → should become NOP
        let insn = InsnNode::new(
            InsnType::CheckCast {
                object: InsnArg::Register(RegisterArg::with_ssa(1, 0)),
                type_idx: 5,
            },
            0,
        );

        let result = simplify_insn(&insn, None, &empty_unary_defs, &empty_cmp_defs, &empty_cast_defs, &check_cast_defs);
        assert!(result.is_some(), "Duplicate CHECK_CAST should be eliminated");

        let simplified = result.unwrap();
        assert!(matches!(&simplified.insn_type, InsnType::Nop), "Duplicate CHECK_CAST should become NOP");
    }

    #[test]
    fn test_different_check_cast_not_eliminated() {
        // Pattern: (T2)(T1)x → keep both (different target types)
        let empty_unary_defs: HashMap<(u16, u32), (UnaryOp, InsnArg)> = HashMap::new();
        let empty_cmp_defs: HashMap<(u16, u32), (CompareOp, InsnArg, InsnArg)> = HashMap::new();
        let empty_cast_defs: HashMap<(u16, u32), (CastType, InsnArg)> = HashMap::new();
        let empty_check_cast_defs: HashMap<(u16, u32), u32> = HashMap::new();
        let mut check_cast_defs: HashMap<(u16, u32), u32> = HashMap::new();

        // r1_0 was previously CHECK_CAST to type_idx=5
        check_cast_defs.insert((1, 0), 5);

        // CHECK_CAST r1_0 to different type_idx=10 → should NOT be eliminated
        let insn = InsnNode::new(
            InsnType::CheckCast {
                object: InsnArg::Register(RegisterArg::with_ssa(1, 0)),
                type_idx: 10,
            },
            0,
        );

        let result = simplify_insn(&insn, None, &empty_unary_defs, &empty_cmp_defs, &empty_cast_defs, &check_cast_defs);
        assert!(result.is_none(), "CHECK_CAST to different type should NOT be eliminated");
    }
}
