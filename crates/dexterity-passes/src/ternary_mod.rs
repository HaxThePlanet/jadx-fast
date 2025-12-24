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
use tracing::{debug, trace};

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
    // After GOTO/NOP removal (JADX parity), blocks contain only meaningful instructions
    if then_block.instructions.len() == 1 {
        if let Some(dest) = get_assignment_dest(&then_block.instructions[0].insn_type) {
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

/// Get the destination register of the last instruction in a block (if it's an assignment)
/// After GOTO/NOP removal (JADX parity), the last instruction is the meaningful one
fn get_last_assignment_dest(block: &BasicBlock) -> Option<u16> {
    block
        .instructions
        .last()
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

/// Verify that both then and else blocks flow into the SAME PHI node.
/// This matches JADX TernaryMod.java lines 100-104.
///
/// Returns (merge_block_id, phi_version) if valid PHI merge exists.
pub fn verify_phi_merge(
    then_block_id: u32,
    else_block_id: u32,
    dest_reg: u16,
    cfg: &CFG,
) -> Option<(u32, u32)> {
    // Find common successor (merge block)
    let then_succs = cfg.successors(then_block_id);
    let else_succs = cfg.successors(else_block_id);

    // Find the common successor
    let merge_block_id = then_succs.iter()
        .find(|s| else_succs.contains(s))
        .copied()?;

    // Get the merge block
    let merge_block = cfg.get_block(merge_block_id)?;

    // Find PHI node for dest_reg in merge block
    for insn in &merge_block.instructions {
        if let InsnType::Phi { dest, sources } = &insn.insn_type {
            if dest.reg_num == dest_reg {
                // Check if both then and else blocks are sources
                let has_then = sources.iter().any(|(block_id, _)| *block_id == then_block_id);
                let has_else = sources.iter().any(|(block_id, _)| *block_id == else_block_id);

                if has_then && has_else {
                    debug!(
                        then_block_id,
                        else_block_id,
                        merge_block_id,
                        dest_reg,
                        phi_version = dest.ssa_version,
                        "PHI merge verified"
                    );
                    return Some((merge_block_id, dest.ssa_version));
                } else {
                    trace!(
                        then_block_id,
                        else_block_id,
                        merge_block_id,
                        dest_reg,
                        has_then,
                        has_else,
                        sources_len = sources.len(),
                        "PHI found but missing expected sources"
                    );
                }
            }
        }
    }

    debug!(
        then_block_id,
        else_block_id,
        merge_block_id,
        dest_reg,
        "No matching PHI node found in merge block"
    );
    None
}

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
    let debug_ternary = std::env::var("DEXTERITY_DEBUG_TERNARY").is_ok();

    if debug_ternary {
        eprintln!("[TERNARY DEBUG] try_transform_to_ternary called with then_blocks={:?}, else_blocks={:?}", then_blocks, else_blocks);
    }

    trace!(
        ?then_blocks,
        ?else_blocks,
        "try_transform_to_ternary: checking pattern"
    );

    // JADX TernaryMod.java line 79-83: Both branches must be single blocks
    if then_blocks.len() != 1 || else_blocks.len() != 1 {
        debug!(
            then_len = then_blocks.len(),
            else_len = else_blocks.len(),
            "Ternary rejected: not single blocks"
        );
        return TernaryTransformResult::NotTernary;
    }

    let then_block_id = then_blocks[0];
    let else_block_id = else_blocks[0];

    // Get the blocks
    let then_block = match cfg.get_block(then_block_id) {
        Some(b) => b,
        None => {
            debug!(then_block_id, "Ternary rejected: then block not found");
            return TernaryTransformResult::NotTernary;
        }
    };
    let else_block = match cfg.get_block(else_block_id) {
        Some(b) => b,
        None => {
            debug!(else_block_id, "Ternary rejected: else block not found");
            return TernaryTransformResult::NotTernary;
        }
    };

    // JADX TernaryMod.java lines 195-209: getTernaryInsnBlock() requires exactly 1 instruction
    // After block splitting, JADX removes GOTO/NOP via removeInsns() (BlockSplitter.java:375-385)
    // JADX Clone: Also handle constructor pattern (NewInstance + InvokeDirect<init>) as one instruction.
    // In JADX, ConstructorVisitor runs before TernaryMod and merges these into ConstructorInsn.
    // In Dexterity, prepare_for_codegen runs AFTER region building, so we handle it here.
    let (then_insn_opt, then_count) = get_effective_insn_from_block(then_block);
    let (else_insn_opt, else_count) = get_effective_insn_from_block(else_block);

    if debug_ternary {
        eprintln!("[TERNARY DEBUG] then_block {} has {} raw insns, {} effective insns",
            then_block_id, then_block.instructions.len(), then_count);
        eprintln!("[TERNARY DEBUG] else_block {} has {} raw insns, {} effective insns",
            else_block_id, else_block.instructions.len(), else_count);
        for (i, insn) in then_block.instructions.iter().enumerate() {
            eprintln!("[TERNARY DEBUG]   then_block insn[{}]: {:?}", i, std::mem::discriminant(&insn.insn_type));
        }
        for (i, insn) in else_block.instructions.iter().enumerate() {
            eprintln!("[TERNARY DEBUG]   else_block insn[{}]: {:?}", i, std::mem::discriminant(&insn.insn_type));
        }
    }

    if then_count != 1 || else_count != 1 {
        debug!(
            then_block_id,
            else_block_id,
            then_insn_count = then_count,
            else_insn_count = else_count,
            "Ternary rejected: blocks must have exactly 1 effective instruction (JADX parity)"
        );
        if debug_ternary {
            eprintln!("[TERNARY DEBUG] REJECTED: then_count={}, else_count={} (need both == 1)",
                then_count, else_count);
        }
        return TernaryTransformResult::NotTernary;
    }

    let then_insn = then_insn_opt.expect("effective count is 1");
    let else_insn = else_insn_opt.expect("effective count is 1");

    // Try Pattern 1: Assignment in both branches (lines 97-135)
    // Use effective assignment dest which handles constructor pattern
    let then_dest_opt = get_effective_assignment_dest(then_block);
    let else_dest_opt = get_effective_assignment_dest(else_block);

    if debug_ternary {
        eprintln!("[TERNARY DEBUG] then_dest_opt = {:?}", then_dest_opt);
        eprintln!("[TERNARY DEBUG] else_dest_opt = {:?}", else_dest_opt);
    }

    if let (Some(then_dest), Some(else_dest)) = (then_dest_opt, else_dest_opt) {
        if debug_ternary {
            eprintln!("[TERNARY DEBUG] then_dest = ({}, {}), else_dest = ({}, {})",
                then_dest.0, then_dest.1, else_dest.0, else_dest.1);
            eprintln!("[TERNARY DEBUG] regs match? {}", then_dest.0 == else_dest.0);
        }
        // Both must assign to the same register (they'll merge at a PHI node)
        if then_dest.0 == else_dest.0 {
            // JADX TernaryMod.java lines 100-104: Verify PHI merge
            // Both branches must feed into the SAME PHI node
            if let Some((_merge_block, phi_version)) = verify_phi_merge(
                then_block_id,
                else_block_id,
                then_dest.0,
                cfg,
            ) {
                if debug_ternary {
                    eprintln!("[TERNARY DEBUG] PHI verified! merge_block={}, phi_version={}", _merge_block, phi_version);
                    eprintln!("[TERNARY DEBUG] ACCEPTED: assignment pattern with PHI, returning Assignment");
                }
                debug!(
                    then_block_id,
                    else_block_id,
                    dest_reg = then_dest.0,
                    phi_version,
                    "Ternary ACCEPTED: assignment pattern with PHI verification"
                );
                return TernaryTransformResult::Assignment {
                    condition,
                    dest_reg: then_dest.0,
                    dest_version: phi_version, // Use PHI version for proper SSA tracking
                    then_block: then_block_id,
                    else_block: else_block_id,
                };
            } else {
                if debug_ternary {
                    eprintln!("[TERNARY DEBUG] PHI verification failed, but still accepting");
                    eprintln!("[TERNARY DEBUG] ACCEPTED: assignment pattern without PHI, returning Assignment");
                }
                // Still accept without PHI verification for backwards compatibility
                // (some cases may not have explicit PHI nodes in the IR)
                debug!(
                    then_block_id,
                    else_block_id,
                    dest_reg = then_dest.0,
                    dest_version = then_dest.1,
                    "Ternary ACCEPTED: assignment pattern (no PHI verification)"
                );
                return TernaryTransformResult::Assignment {
                    condition,
                    dest_reg: then_dest.0,
                    dest_version: then_dest.1,
                    then_block: then_block_id,
                    else_block: else_block_id,
                };
            }
        } else {
            debug!(
                then_block_id,
                else_block_id,
                then_dest_reg = then_dest.0,
                else_dest_reg = else_dest.0,
                "Ternary rejected: different destination registers"
            );
        }
    } else {
        let then_has_dest = get_assignment_dest_with_version(&then_insn.insn_type).is_some();
        let else_has_dest = get_assignment_dest_with_version(&else_insn.insn_type).is_some();
        trace!(
            then_block_id,
            else_block_id,
            then_has_dest,
            else_has_dest,
            then_insn_type = ?std::mem::discriminant(&then_insn.insn_type),
            else_insn_type = ?std::mem::discriminant(&else_insn.insn_type),
            "Ternary: not an assignment pattern"
        );
    }

    // Try Pattern 2: Return from both branches (lines 137-168)
    if is_return_instruction(&then_insn.insn_type) && is_return_instruction(&else_insn.insn_type) {
        // Skip void returns (nothing to ternary-fy)
        if has_return_value(&then_insn.insn_type) && has_return_value(&else_insn.insn_type) {
            debug!(
                then_block_id,
                else_block_id,
                "Ternary ACCEPTED: return pattern"
            );
            return TernaryTransformResult::Return {
                condition,
                then_block: then_block_id,
                else_block: else_block_id,
            };
        } else {
            debug!(
                then_block_id,
                else_block_id,
                "Ternary rejected: void return pattern"
            );
        }
    }

    TernaryTransformResult::NotTernary
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

/// Get the effective instruction from a block, handling constructor patterns.
/// JADX Clone: Mirrors ConstructorVisitor.java behavior where NewInstance + InvokeDirect<init>
/// is treated as a single ConstructorInsn. In our IR, we may have:
/// 1. Pre-merge: NewInstance + InvokeDirect<init>
/// 2. Post-merge: NewInstance + Constructor (merged form)
/// 3. With assignment: NewInstance + Constructor + Move (when result assigned to different reg)
///
/// Returns (effective_insn, effective_count) where effective_count is:
/// - 1 if there's a single logical instruction (including constructor pattern)
/// - The actual count otherwise
fn get_effective_insn_from_block<'a>(
    block: &'a crate::block_split::BasicBlock,
) -> (Option<&'a dexterity_ir::instructions::InsnNode>, usize) {
    use dexterity_ir::instructions::{InsnArg, InvokeKind};

    // Filter out Nop instructions
    let non_nop: Vec<_> = block.instructions.iter()
        .filter(|insn| !matches!(insn.insn_type, InsnType::Nop))
        .collect();

    // Check for constructor pattern: NewInstance followed by InvokeDirect<init>
    if non_nop.len() == 2 {
        if let (
            InsnType::NewInstance { dest: new_dest, .. },
            InsnType::Invoke { kind: InvokeKind::Direct, args, .. }
        ) = (&non_nop[0].insn_type, &non_nop[1].insn_type) {
            // Check if invoke is a constructor (<init>) calling on the new instance
            if let Some(InsnArg::Register(recv)) = args.first() {
                if recv.reg_num == new_dest.reg_num {
                    // This is NewInstance + InvokeDirect<init> pattern
                    // Treat as single instruction, return the NewInstance as it has the dest
                    return (Some(non_nop[0]), 1);
                }
            }
        }
    }

    // Check for 4-instruction constructor pattern with inlined const args:
    // NewInstance + Const + Constructor + Move
    // This happens when constructor takes literal args like: new BufferedReader(reader, 8192)
    //   insn[0]: NewInstance { dest: r1, type_idx: BufferedReader }
    //   insn[1]: Const { dest: r2, value: 8192 }
    //   insn[2]: Constructor { dest: r1, args: [reader, r2] }
    //   insn[3]: Move { dest: r3, src: r1 }
    if non_nop.len() == 4 {
        let debug_ternary = std::env::var("DEXTERITY_DEBUG_TERNARY").is_ok();
        if debug_ternary {
            eprintln!("[TERNARY DEBUG] Checking 4-insn constructor pattern:");
            for (i, insn) in non_nop.iter().enumerate() {
                eprintln!("[TERNARY DEBUG]   insn[{}]: {:?}", i, insn.insn_type.name());
            }
        }
        // Pattern: NewInstance + Const + Constructor + Move
        if let (
            InsnType::NewInstance { dest: new_dest, .. },
            InsnType::Const { .. },
            InsnType::Constructor { dest: ctor_dest, .. },
            InsnType::Move { dest: _move_dest, src: InsnArg::Register(move_src) }
        ) = (&non_nop[0].insn_type, &non_nop[1].insn_type, &non_nop[2].insn_type, &non_nop[3].insn_type) {
            // Verify chain: NewInstance creates obj, Constructor uses it, Move copies result
            if new_dest.reg_num == ctor_dest.reg_num && ctor_dest.reg_num == move_src.reg_num {
                if debug_ternary {
                    eprintln!("[TERNARY DEBUG]   4-insn pattern verified! Returning 1 effective insn");
                }
                // Return the Move as it defines the effective destination
                return (Some(non_nop[3]), 1);
            }
        }
        // Also check NewInstance + Const + InvokeDirect + Move (pre-merge constructor)
        if let (
            InsnType::NewInstance { dest: new_dest, .. },
            InsnType::Const { .. },
            InsnType::Invoke { kind: InvokeKind::Direct, args, .. },
            InsnType::Move { dest: _move_dest, src: InsnArg::Register(move_src) }
        ) = (&non_nop[0].insn_type, &non_nop[1].insn_type, &non_nop[2].insn_type, &non_nop[3].insn_type) {
            if let Some(InsnArg::Register(recv)) = args.first() {
                if new_dest.reg_num == recv.reg_num && recv.reg_num == move_src.reg_num {
                    if debug_ternary {
                        eprintln!("[TERNARY DEBUG]   4-insn InvokeDirect pattern verified! Returning 1 effective insn");
                    }
                    return (Some(non_nop[3]), 1);
                }
            }
        }
    }

    // Check for constructor pattern:
    // NewInstance + InvokeDirect<init> + Move (when assigning to a different register for PHI merge)
    // This is the instanceof ternary pattern:
    //   else: r0 = new BufferedReader; invoke-direct r0.<init>(r1, 8192); move r1 = r0
    if non_nop.len() == 3 {
        let debug_ternary = std::env::var("DEXTERITY_DEBUG_TERNARY").is_ok();
        if debug_ternary {
            eprintln!("[TERNARY DEBUG] Checking 3-insn constructor pattern:");
            eprintln!("[TERNARY DEBUG]   insn[0]: {:?}", non_nop[0].insn_type.name());
            eprintln!("[TERNARY DEBUG]   insn[1]: {:?}", non_nop[1].insn_type.name());
            eprintln!("[TERNARY DEBUG]   insn[2]: {:?}", non_nop[2].insn_type.name());
        }
        // Pattern 1: NewInstance + InvokeDirect + Move (pre-merge)
        if let (
            InsnType::NewInstance { dest: new_dest, .. },
            InsnType::Invoke { kind: InvokeKind::Direct, args, .. },
            InsnType::Move { dest: move_dest, src: InsnArg::Register(move_src) }
        ) = (&non_nop[0].insn_type, &non_nop[1].insn_type, &non_nop[2].insn_type) {
            // Check if invoke is a constructor (<init>) calling on the new instance
            if let Some(InsnArg::Register(recv)) = args.first() {
                if debug_ternary {
                    eprintln!("[TERNARY DEBUG]   InvokeDirect pattern: new_dest={}, recv={}, move_src={}",
                        new_dest.reg_num, recv.reg_num, move_src.reg_num);
                }
                // Verify chain: NewInstance creates obj, InvokeDirect initializes it, Move assigns result
                if new_dest.reg_num == recv.reg_num && recv.reg_num == move_src.reg_num {
                    if debug_ternary {
                        eprintln!("[TERNARY DEBUG]   Chain verified! Returning 1 effective insn");
                    }
                    // Return the Move as it defines the effective destination
                    return (Some(non_nop[2]), 1);
                }
            }
        }
        // Pattern 2: NewInstance + Constructor + Move (post-merge)
        if let (
            InsnType::NewInstance { dest: new_dest, .. },
            InsnType::Constructor { dest: ctor_dest, .. },
            InsnType::Move { dest: move_dest, src: InsnArg::Register(move_src) }
        ) = (&non_nop[0].insn_type, &non_nop[1].insn_type, &non_nop[2].insn_type) {
            if debug_ternary {
                eprintln!("[TERNARY DEBUG]   Constructor pattern: new_dest={}, ctor_dest={}, move_src={}",
                    new_dest.reg_num, ctor_dest.reg_num, move_src.reg_num);
            }
            // Verify chain: NewInstance creates obj, Constructor initializes it, Move assigns result
            if new_dest.reg_num == ctor_dest.reg_num && ctor_dest.reg_num == move_src.reg_num {
                if debug_ternary {
                    eprintln!("[TERNARY DEBUG]   Chain verified! Returning 1 effective insn");
                }
                // Return the Move as it defines the effective destination
                return (Some(non_nop[2]), 1);
            }
        }
        if debug_ternary {
            eprintln!("[TERNARY DEBUG]   No pattern matched");
        }
    }

    // Check for 2-instruction variant: NewInstance + Constructor (no Move, already using right reg)
    if non_nop.len() == 2 {
        if let (
            InsnType::NewInstance { dest: new_dest, .. },
            InsnType::Constructor { dest: ctor_dest, .. }
        ) = (&non_nop[0].insn_type, &non_nop[1].insn_type) {
            if new_dest.reg_num == ctor_dest.reg_num {
                // NewInstance + Constructor pattern
                return (Some(non_nop[0]), 1);
            }
        }
    }

    // Check for CheckCast (simple case - already 1 instruction)
    if non_nop.len() == 1 {
        return (Some(non_nop[0]), 1);
    }

    (non_nop.first().copied(), non_nop.len())
}

/// Get destination from an instruction, including constructor pattern.
/// For constructor pattern (NewInstance), returns the NewInstance's destination.
/// For CheckCast, returns the object register (cast operates in place).
fn get_effective_assignment_dest(
    block: &crate::block_split::BasicBlock,
) -> Option<(u16, u32)> {
    use dexterity_ir::instructions::{InsnArg, InvokeKind};

    // Filter out Nop instructions
    let non_nop: Vec<_> = block.instructions.iter()
        .filter(|insn| !matches!(insn.insn_type, InsnType::Nop))
        .collect();

    // Check for constructor pattern: NewInstance followed by InvokeDirect<init>
    if non_nop.len() == 2 {
        if let (
            InsnType::NewInstance { dest: new_dest, .. },
            InsnType::Invoke { kind: InvokeKind::Direct, args, .. }
        ) = (&non_nop[0].insn_type, &non_nop[1].insn_type) {
            if let Some(InsnArg::Register(recv)) = args.first() {
                if recv.reg_num == new_dest.reg_num {
                    // Constructor pattern - dest is the NewInstance dest
                    return Some((new_dest.reg_num, new_dest.ssa_version));
                }
            }
        }
    }

    // Check for 4-instruction constructor pattern with const args:
    // NewInstance + Const + Constructor + Move
    if non_nop.len() == 4 {
        if let (
            InsnType::NewInstance { dest: new_dest, .. },
            InsnType::Const { .. },
            InsnType::Constructor { dest: ctor_dest, .. },
            InsnType::Move { dest: move_dest, src: InsnArg::Register(move_src) }
        ) = (&non_nop[0].insn_type, &non_nop[1].insn_type, &non_nop[2].insn_type, &non_nop[3].insn_type) {
            if new_dest.reg_num == ctor_dest.reg_num && ctor_dest.reg_num == move_src.reg_num {
                return Some((move_dest.reg_num, move_dest.ssa_version));
            }
        }
        // Also NewInstance + Const + InvokeDirect + Move (pre-merge)
        if let (
            InsnType::NewInstance { dest: new_dest, .. },
            InsnType::Const { .. },
            InsnType::Invoke { kind: InvokeKind::Direct, args, .. },
            InsnType::Move { dest: move_dest, src: InsnArg::Register(move_src) }
        ) = (&non_nop[0].insn_type, &non_nop[1].insn_type, &non_nop[2].insn_type, &non_nop[3].insn_type) {
            if let Some(InsnArg::Register(recv)) = args.first() {
                if new_dest.reg_num == recv.reg_num && recv.reg_num == move_src.reg_num {
                    return Some((move_dest.reg_num, move_dest.ssa_version));
                }
            }
        }
    }

    // Check for constructor pattern + Move:
    // NewInstance + InvokeDirect<init> + Move (when assigning to a different register for PHI merge)
    if non_nop.len() == 3 {
        // Pattern 1: NewInstance + InvokeDirect + Move (pre-merge)
        if let (
            InsnType::NewInstance { dest: new_dest, .. },
            InsnType::Invoke { kind: InvokeKind::Direct, args, .. },
            InsnType::Move { dest: move_dest, src: InsnArg::Register(move_src) }
        ) = (&non_nop[0].insn_type, &non_nop[1].insn_type, &non_nop[2].insn_type) {
            if let Some(InsnArg::Register(recv)) = args.first() {
                if new_dest.reg_num == recv.reg_num && recv.reg_num == move_src.reg_num {
                    return Some((move_dest.reg_num, move_dest.ssa_version));
                }
            }
        }
        // Pattern 2: NewInstance + Constructor + Move (post-merge)
        if let (
            InsnType::NewInstance { dest: new_dest, .. },
            InsnType::Constructor { dest: ctor_dest, .. },
            InsnType::Move { dest: move_dest, src: InsnArg::Register(move_src) }
        ) = (&non_nop[0].insn_type, &non_nop[1].insn_type, &non_nop[2].insn_type) {
            // Verify chain and return the Move destination (the PHI merge target)
            if new_dest.reg_num == ctor_dest.reg_num && ctor_dest.reg_num == move_src.reg_num {
                return Some((move_dest.reg_num, move_dest.ssa_version));
            }
        }
    }

    // Check for 2-instruction variant: NewInstance + Constructor
    if non_nop.len() == 2 {
        if let (
            InsnType::NewInstance { dest: new_dest, .. },
            InsnType::Constructor { dest: ctor_dest, .. }
        ) = (&non_nop[0].insn_type, &non_nop[1].insn_type) {
            if new_dest.reg_num == ctor_dest.reg_num {
                return Some((new_dest.reg_num, new_dest.ssa_version));
            }
        }
    }

    // Single instruction case
    if non_nop.len() == 1 {
        // JADX Clone: CheckCast operates in place - the object register IS the dest
        // In instanceof ternary: cond ? (Type)obj : new Type(obj)
        // The CheckCast result is the casted object in the same register
        if let InsnType::CheckCast { object, .. } = &non_nop[0].insn_type {
            if let InsnArg::Register(reg) = object {
                return Some((reg.reg_num, reg.ssa_version));
            }
        }
        return get_assignment_dest_with_version(&non_nop[0].insn_type);
    }

    None
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
