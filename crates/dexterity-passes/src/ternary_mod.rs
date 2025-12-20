//! TernaryMod optimization pass
//!
//! Converts if-else regions to ternary expressions where applicable.
//! Based on JADX's TernaryMod.java algorithm.
//!
//! ## Patterns Recognized
//!
//! **Pattern 1: Assignment in both branches**
//! ```java
//! if (cond) { r = a; } else { r = b; }
//! // -> r = cond ? a : b;
//! ```
//!
//! **Pattern 2: Return from both branches**
//! ```java
//! if (cond) { return a; } else { return b; }
//! // -> return cond ? a : b;
//! ```
//!
//! **Pattern 3: Single-branch assignment (constructors)**
//! ```java
//! if (cond) { r = a; }
//! // -> r = cond ? a : r;
//! ```

use crate::block_split::BasicBlock;
use crate::CFG;
use dexterity_ir::instructions::InsnType;
use dexterity_ir::regions::{Region, RegionContent};
use std::collections::HashSet;

/// Result of ternary mod analysis
#[derive(Debug, Default)]
pub struct TernaryModResult {
    /// Number of if-else patterns that could be ternaries
    pub assignment_ternaries: usize,
    /// Number of if-else patterns with return in both branches
    pub return_ternaries: usize,
    /// Number of single-branch assignments (constructor pattern)
    pub single_branch_ternaries: usize,
    /// Total ternary opportunities found
    pub total: usize,
    /// Block IDs involved in ternary patterns (for debugging)
    pub ternary_blocks: HashSet<u32>,
}

/// Information about a detected ternary pattern
#[derive(Debug, Clone)]
pub struct TernaryPattern {
    /// The kind of ternary pattern
    pub kind: TernaryKind,
    /// The destination register (for assignment patterns)
    pub dest_reg: Option<u16>,
    /// Block containing the "then" value
    pub then_block: u32,
    /// Block containing the "else" value (None for single-branch)
    pub else_block: Option<u32>,
}

/// Kind of ternary pattern
#[derive(Debug, Clone, Copy, PartialEq, Eq)]
pub enum TernaryKind {
    /// Both branches assign to the same register
    Assignment,
    /// Both branches return
    Return,
    /// Single branch assigns (constructor pattern)
    SingleBranchAssignment,
}

/// Analyze a region tree for ternary optimization opportunities.
///
/// This is a read-only analysis pass that identifies if-else patterns
/// that could be converted to ternary expressions.
///
/// # Arguments
/// * `region` - The region tree to analyze
/// * `blocks` - The basic blocks for instruction analysis
/// * `cfg` - The control flow graph
///
/// # Returns
/// A `TernaryModResult` with statistics about ternary opportunities
pub fn analyze_ternary_opportunities(
    region: &Region,
    blocks: &[BasicBlock],
    _cfg: &CFG,
) -> TernaryModResult {
    let mut result = TernaryModResult::default();
    analyze_region(region, blocks, &mut result);
    result.total = result.assignment_ternaries + result.return_ternaries + result.single_branch_ternaries;
    result
}

/// Recursively analyze a region for ternary patterns
fn analyze_region(region: &Region, blocks: &[BasicBlock], result: &mut TernaryModResult) {
    match region {
        Region::If {
            condition: _,
            then_region,
            else_region,
        } => {
            // Check if this if-else could be a ternary
            if let Some(else_reg) = else_region {
                if let Some(pattern) = detect_ternary_pattern_in_regions(then_region, else_reg, blocks) {
                    match pattern.kind {
                        TernaryKind::Assignment => result.assignment_ternaries += 1,
                        TernaryKind::Return => result.return_ternaries += 1,
                        TernaryKind::SingleBranchAssignment => result.single_branch_ternaries += 1,
                    }
                    result.ternary_blocks.insert(pattern.then_block);
                    if let Some(else_block) = pattern.else_block {
                        result.ternary_blocks.insert(else_block);
                    }
                }
            } else {
                // Single-branch if - check for constructor pattern
                if let Some(pattern) = detect_single_branch_pattern(then_region, blocks) {
                    result.single_branch_ternaries += 1;
                    result.ternary_blocks.insert(pattern.then_block);
                }
            }

            // Recursively check nested regions
            analyze_region(then_region, blocks, result);
            if let Some(else_reg) = else_region {
                analyze_region(else_reg, blocks, result);
            }
        }
        Region::Sequence(contents) => {
            for content in contents {
                if let RegionContent::Region(inner) = content {
                    analyze_region(inner, blocks, result);
                }
            }
        }
        Region::Loop { body, .. } => {
            analyze_region(body, blocks, result);
        }
        Region::Switch { cases, .. } => {
            for case in cases {
                analyze_region(&case.container, blocks, result);
            }
        }
        Region::TryCatch {
            try_region,
            handlers,
            finally,
            ..
        } => {
            analyze_region(try_region, blocks, result);
            for handler in handlers {
                analyze_region(&handler.region, blocks, result);
            }
            if let Some(fin) = finally {
                analyze_region(fin, blocks, result);
            }
        }
        Region::Synchronized { body, .. } => {
            analyze_region(body, blocks, result);
        }
        Region::Break { .. } | Region::Continue { .. } => {
            // Break and continue are leaf nodes, nothing to analyze
        }
        Region::TernaryAssignment { .. } | Region::TernaryReturn { .. } => {
            // TernaryAssignment and TernaryReturn are already transformed ternaries
            // Nothing to analyze
        }
    }
}

/// Detect if a pair of then/else regions form a ternary pattern
fn detect_ternary_pattern_in_regions(
    then_region: &Region,
    else_region: &Region,
    blocks: &[BasicBlock],
) -> Option<TernaryPattern> {
    // Get single blocks from both regions
    let then_block_id = get_single_block_id(then_region)?;
    let else_block_id = get_single_block_id(else_region)?;

    // Get the actual blocks
    let then_block = blocks.get(then_block_id as usize)?;
    let else_block = blocks.get(else_block_id as usize)?;

    // Check for assignment pattern
    let then_dest = get_last_assignment_dest(then_block);
    let else_dest = get_last_assignment_dest(else_block);

    if let (Some(td), Some(ed)) = (then_dest, else_dest) {
        if td == ed {
            return Some(TernaryPattern {
                kind: TernaryKind::Assignment,
                dest_reg: Some(td),
                then_block: then_block_id,
                else_block: Some(else_block_id),
            });
        }
    }

    // Check for return pattern
    if has_return_instruction(then_block) && has_return_instruction(else_block) {
        return Some(TernaryPattern {
            kind: TernaryKind::Return,
            dest_reg: None,
            then_block: then_block_id,
            else_block: Some(else_block_id),
        });
    }

    None
}

/// Detect single-branch assignment pattern (used in constructors)
fn detect_single_branch_pattern(
    then_region: &Region,
    blocks: &[BasicBlock],
) -> Option<TernaryPattern> {
    let then_block_id = get_single_block_id(then_region)?;
    let then_block = blocks.get(then_block_id as usize)?;

    // Check if it's a single assignment
    if let Some(dest) = get_last_assignment_dest(then_block) {
        // Only applies if there's just one instruction (the assignment)
        let non_control_count = then_block.instructions.iter()
            .filter(|insn| !is_control_flow(&insn.insn_type))
            .count();

        if non_control_count == 1 {
            return Some(TernaryPattern {
                kind: TernaryKind::SingleBranchAssignment,
                dest_reg: Some(dest),
                then_block: then_block_id,
                else_block: None,
            });
        }
    }

    None
}

/// Extract a single block ID from a region if it contains exactly one block
fn get_single_block_id(region: &Region) -> Option<u32> {
    match region {
        Region::Sequence(contents) if contents.len() == 1 => {
            match &contents[0] {
                RegionContent::Block(id) => Some(*id),
                RegionContent::Region(inner) => get_single_block_id(inner),
            }
        }
        _ => None,
    }
}

/// Get the destination register of the last assignment instruction in a block
fn get_last_assignment_dest(block: &BasicBlock) -> Option<u16> {
    block
        .instructions
        .iter()
        .rev()
        .find(|insn| !is_control_flow(&insn.insn_type))
        .and_then(|insn| get_assignment_dest(&insn.insn_type))
}

/// Check if a block ends with a return instruction
fn has_return_instruction(block: &BasicBlock) -> bool {
    block
        .instructions
        .iter()
        .any(|insn| matches!(insn.insn_type, InsnType::Return { .. }))
}

/// Check if an instruction is control flow (should be excluded from analysis)
fn is_control_flow(insn_type: &InsnType) -> bool {
    matches!(
        insn_type,
        InsnType::If { .. }
            | InsnType::Goto { .. }
            | InsnType::Return { .. }
            | InsnType::PackedSwitch { .. }
            | InsnType::SparseSwitch { .. }
            | InsnType::Throw { .. }
    )
}

/// Get the destination register from an assignment instruction
fn get_assignment_dest(insn_type: &InsnType) -> Option<u16> {
    match insn_type {
        InsnType::Move { dest, .. } => Some(dest.reg_num),
        InsnType::MoveResult { dest } => Some(dest.reg_num),
        InsnType::MoveException { dest } => Some(dest.reg_num),
        InsnType::Const { dest, .. } => Some(dest.reg_num),
        InsnType::ConstString { dest, .. } => Some(dest.reg_num),
        InsnType::ConstClass { dest, .. } => Some(dest.reg_num),
        InsnType::Binary { dest, .. } => Some(dest.reg_num),
        InsnType::Unary { dest, .. } => Some(dest.reg_num),
        InsnType::Cast { dest, .. } => Some(dest.reg_num),
        InsnType::Compare { dest, .. } => Some(dest.reg_num),
        InsnType::ArrayLength { dest, .. } => Some(dest.reg_num),
        InsnType::NewInstance { dest, .. } => Some(dest.reg_num),
        InsnType::NewArray { dest, .. } => Some(dest.reg_num),
        InsnType::FilledNewArray { dest: Some(dest), .. } => Some(dest.reg_num),
        InsnType::InstanceOf { dest, .. } => Some(dest.reg_num),
        InsnType::InstanceGet { dest, .. } => Some(dest.reg_num),
        InsnType::StaticGet { dest, .. } => Some(dest.reg_num),
        InsnType::ArrayGet { dest, .. } => Some(dest.reg_num),
        InsnType::Phi { dest, .. } => Some(dest.reg_num),
        // Note: CheckCast modifies in place, doesn't have dest
        // Note: Invoke with result uses MoveResult
        _ => None,
    }
}

/// Process ternary mod optimization pass.
///
/// This runs the analysis and returns information about ternary opportunities.
/// The actual code generation is handled by body_gen.rs which uses similar
/// pattern detection at emit time.
///
/// For iterative optimization (JADX-style), this can be called in a loop
/// with code shrinking between iterations.
///
/// # Arguments
/// * `region` - The region tree to analyze
/// * `blocks` - The basic blocks
/// * `cfg` - The control flow graph
///
/// # Returns
/// Analysis result with counts of ternary opportunities
pub fn process_ternary_mod(
    region: &Region,
    blocks: &[BasicBlock],
    cfg: &CFG,
) -> TernaryModResult {
    analyze_ternary_opportunities(region, blocks, cfg)
}

// ============================================================================
// TernaryMod Transformation (Phase 2) - JADX TernaryMod.java Algorithm
// ============================================================================
//
// This implements the actual transformation of if-else regions to ternary
// expressions. Called by region_builder.rs before building if sub-regions.

use dexterity_ir::regions::Condition;

/// Result of ternary transformation attempt
#[derive(Debug)]
pub enum TernaryTransformResult {
    /// Successfully transformed to ternary assignment: dest = cond ? then : else
    Assignment {
        condition: Condition,
        dest_reg: u16,
        dest_version: u32,
        then_block: u32,
        else_block: u32,
    },
    /// Successfully transformed to ternary return: return cond ? then : else
    Return {
        condition: Condition,
        then_block: u32,
        else_block: u32,
    },
    /// Could not transform (not a ternary pattern)
    NotTernary,
}

/// Try to transform an if-else pattern into a ternary expression.
///
/// This is called by RegionBuilder BEFORE building sub-regions.
/// If successful, returns the ternary transformation result.
///
/// Pattern 1: Assignment in both branches
///   if (cond) { r = a; } else { r = b; }
///   -> r = cond ? a : b;
///
/// Pattern 2: Return from both branches
///   if (cond) { return a; } else { return b; }
///   -> return cond ? a : b;
///
/// # Arguments
/// * `condition` - The condition from the if-block
/// * `then_blocks` - Block IDs in the then branch
/// * `else_blocks` - Block IDs in the else branch
/// * `cfg` - The control flow graph with block access
///
/// # Returns
/// * `TernaryTransformResult` - Success with transformation info or NotTernary
pub fn try_transform_to_ternary(
    condition: Condition,
    then_blocks: &[u32],
    else_blocks: &[u32],
    cfg: &CFG,
) -> TernaryTransformResult {
    // JADX TernaryMod.java line 79-83: Both branches must be single blocks
    if then_blocks.len() != 1 || else_blocks.len() != 1 {
        return TernaryTransformResult::NotTernary;
    }

    let then_block_id = then_blocks[0];
    let else_block_id = else_blocks[0];

    // Get the blocks
    let then_block = match cfg.get_block(then_block_id) {
        Some(b) => b,
        None => return TernaryTransformResult::NotTernary,
    };
    let else_block = match cfg.get_block(else_block_id) {
        Some(b) => b,
        None => return TernaryTransformResult::NotTernary,
    };

    // JADX TernaryMod.java line 90-91: Each block must have exactly one meaningful instruction
    // (excluding control flow like goto)
    let then_meaningful = get_meaningful_instructions(then_block);
    let else_meaningful = get_meaningful_instructions(else_block);

    if then_meaningful.len() != 1 || else_meaningful.len() != 1 {
        return TernaryTransformResult::NotTernary;
    }

    let then_insn = &then_block.instructions[then_meaningful[0]];
    let else_insn = &else_block.instructions[else_meaningful[0]];

    // Try Pattern 1: Assignment in both branches (lines 97-135)
    if let (Some(then_dest), Some(else_dest)) = (
        get_assignment_dest_with_version(&then_insn.insn_type),
        get_assignment_dest_with_version(&else_insn.insn_type),
    ) {
        // Both must assign to the same register (they'll merge at a PHI node)
        if then_dest.0 == else_dest.0 {
            return TernaryTransformResult::Assignment {
                condition,
                dest_reg: then_dest.0,
                dest_version: then_dest.1,
                then_block: then_block_id,
                else_block: else_block_id,
            };
        }
    }

    // Try Pattern 2: Return from both branches (lines 137-168)
    if is_return_instruction(&then_insn.insn_type) && is_return_instruction(&else_insn.insn_type) {
        // Skip void returns (nothing to ternary-fy)
        if has_return_value(&then_insn.insn_type) && has_return_value(&else_insn.insn_type) {
            return TernaryTransformResult::Return {
                condition,
                then_block: then_block_id,
                else_block: else_block_id,
            };
        }
    }

    TernaryTransformResult::NotTernary
}

/// Get indices of meaningful (non-control-flow) instructions in a block
fn get_meaningful_instructions(block: &BasicBlock) -> Vec<usize> {
    block
        .instructions
        .iter()
        .enumerate()
        .filter(|(_, insn)| !is_control_flow(&insn.insn_type))
        .map(|(i, _)| i)
        .collect()
}

/// Get the destination register and SSA version from an assignment instruction
fn get_assignment_dest_with_version(insn_type: &InsnType) -> Option<(u16, u32)> {
    match insn_type {
        InsnType::Move { dest, .. } => Some((dest.reg_num, dest.ssa_version)),
        InsnType::MoveResult { dest } => Some((dest.reg_num, dest.ssa_version)),
        InsnType::MoveException { dest } => Some((dest.reg_num, dest.ssa_version)),
        InsnType::Const { dest, .. } => Some((dest.reg_num, dest.ssa_version)),
        InsnType::ConstString { dest, .. } => Some((dest.reg_num, dest.ssa_version)),
        InsnType::ConstClass { dest, .. } => Some((dest.reg_num, dest.ssa_version)),
        InsnType::Binary { dest, .. } => Some((dest.reg_num, dest.ssa_version)),
        InsnType::Unary { dest, .. } => Some((dest.reg_num, dest.ssa_version)),
        InsnType::Cast { dest, .. } => Some((dest.reg_num, dest.ssa_version)),
        InsnType::Compare { dest, .. } => Some((dest.reg_num, dest.ssa_version)),
        InsnType::ArrayLength { dest, .. } => Some((dest.reg_num, dest.ssa_version)),
        InsnType::NewInstance { dest, .. } => Some((dest.reg_num, dest.ssa_version)),
        InsnType::NewArray { dest, .. } => Some((dest.reg_num, dest.ssa_version)),
        InsnType::FilledNewArray { dest: Some(dest), .. } => Some((dest.reg_num, dest.ssa_version)),
        InsnType::InstanceOf { dest, .. } => Some((dest.reg_num, dest.ssa_version)),
        InsnType::InstanceGet { dest, .. } => Some((dest.reg_num, dest.ssa_version)),
        InsnType::StaticGet { dest, .. } => Some((dest.reg_num, dest.ssa_version)),
        InsnType::ArrayGet { dest, .. } => Some((dest.reg_num, dest.ssa_version)),
        InsnType::Phi { dest, .. } => Some((dest.reg_num, dest.ssa_version)),
        _ => None,
    }
}

/// Check if an instruction is a return
fn is_return_instruction(insn_type: &InsnType) -> bool {
    matches!(insn_type, InsnType::Return { .. })
}

/// Check if a return instruction has a value (not void return)
fn has_return_value(insn_type: &InsnType) -> bool {
    match insn_type {
        InsnType::Return { value } => value.is_some(),
        _ => false,
    }
}

#[cfg(test)]
mod tests {
    use super::*;
    use dexterity_ir::instructions::{LiteralArg, RegisterArg};

    #[test]
    fn test_is_control_flow() {
        assert!(is_control_flow(&InsnType::Goto { target: 0 }));
        assert!(is_control_flow(&InsnType::Return { value: None }));
        assert!(!is_control_flow(&InsnType::Const {
            dest: RegisterArg::new(0),
            value: LiteralArg::Int(42),
        }));
    }

    #[test]
    fn test_get_assignment_dest() {
        let const_insn = InsnType::Const {
            dest: RegisterArg::new(5),
            value: LiteralArg::Int(100),
        };
        assert_eq!(get_assignment_dest(&const_insn), Some(5));

        let goto_insn = InsnType::Goto { target: 0 };
        assert_eq!(get_assignment_dest(&goto_insn), None);
    }
}
