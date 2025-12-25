//! Return statement optimization pass
//!
//! Clone of JADX ReturnVisitor.java
//! Reference: jadx-fast/jadx-core/src/main/java/jadx/core/dex/visitors/regions/ReturnVisitor.java
//!
//! This pass optimizes return statements in regions:
//! - Removes redundant return statements at end of void methods
//! - Removes empty else branches that contain only return
//! - Simplifies if-throw-else-return patterns
//!
//! JADX key insight: A void return at the end of a method is redundant if nothing follows.
//! An else { return; } is redundant if the then branch exits (throw, return, break, continue).

use dexterity_ir::regions::{Region, RegionContent};
use dexterity_ir::instructions::{InsnNode, InsnType};
use std::collections::HashMap;

/// Result of return optimization
#[derive(Debug, Default)]
pub struct ReturnVisitorResult {
    /// Number of redundant returns removed
    pub removed_returns: usize,
    /// Number of if-return patterns simplified
    pub simplified_patterns: usize,
    /// Number of empty else branches removed
    pub empty_else_removed: usize,
}

/// Optimize return statements in a region tree
///
/// Clone of JADX ReturnVisitor.visit()
/// Reference: jadx-fast/jadx-core/src/main/java/jadx/core/dex/visitors/regions/ReturnVisitor.java:26-30
///
/// # Arguments
/// * `region` - The root region to optimize (mutated in place)
/// * `is_void_method` - Whether this is a void method
///
/// # Returns
/// * `ReturnVisitorResult` with optimization statistics
pub fn optimize_returns(region: &mut Region, is_void_method: bool) -> ReturnVisitorResult {
    let mut result = ReturnVisitorResult::default();
    visit_region(region, is_void_method, &mut result, &HashMap::new(), 0);
    result
}

/// Optimize returns with block data for checking block contents
///
/// # Arguments
/// * `region` - The root region to optimize
/// * `is_void_method` - Whether this is a void method
/// * `blocks` - Map of block_id to instructions for checking block contents
pub fn optimize_returns_with_blocks(
    region: &mut Region,
    is_void_method: bool,
    blocks: &HashMap<u32, Vec<InsnNode>>,
) -> ReturnVisitorResult {
    let mut result = ReturnVisitorResult::default();
    visit_region(region, is_void_method, &mut result, blocks, 0);
    result
}

/// Visit a region and optimize returns
///
/// Clone of JADX ReturnVisitor.ReturnRemoverVisitor
/// Reference: jadx-fast/jadx-core/src/main/java/jadx/core/dex/visitors/regions/ReturnVisitor.java:32-120
fn visit_region(
    region: &mut Region,
    is_void_method: bool,
    result: &mut ReturnVisitorResult,
    blocks: &HashMap<u32, Vec<InsnNode>>,
    depth: usize,
) {
    // Prevent stack overflow from deeply nested regions (matching if_region_visitor.rs pattern)
    const MAX_DEPTH: usize = 100;
    if depth > MAX_DEPTH {
        tracing::error!(
            depth = depth,
            limit = MAX_DEPTH,
            "LIMIT_EXCEEDED: Return visitor max depth reached"
        );
        return;
    }

    match region {
        Region::Sequence(contents) => {
            // First visit all nested regions
            for content in contents.iter_mut() {
                if let RegionContent::Region(nested) = content {
                    visit_region(nested, is_void_method, result, blocks, depth + 1);
                }
            }

            // Then check for redundant trailing return in void method
            if is_void_method {
                if remove_trailing_return(contents, blocks) {
                    result.removed_returns += 1;
                }
            }
        }

        Region::If { then_region, else_region, .. } => {
            visit_region(then_region, is_void_method, result, blocks, depth + 1);
            if let Some(else_reg) = else_region {
                visit_region(else_reg, is_void_method, result, blocks, depth + 1);
            }

            // Check for empty else that can be removed
            // Clone of JADX pattern: if (cond) { throw/return } else { return; }
            // The else is unnecessary if then exits and else only contains void return
            if is_void_method {
                if let Some(else_reg) = else_region {
                    if region_is_only_void_return(else_reg, blocks) {
                        // Check if then branch exits (throw, return, etc.)
                        if region_always_exits(then_region, blocks) {
                            // Remove the else region
                            *else_region = None;
                            result.empty_else_removed += 1;
                        }
                    }
                }
            }

            // Check for if-return pattern simplification
            if simplify_if_return(region, is_void_method, blocks) {
                result.simplified_patterns += 1;
            }
        }

        Region::Loop { body, .. } => {
            visit_region(body, is_void_method, result, blocks, depth + 1);
        }

        Region::Switch { cases, .. } => {
            for case in cases {
                visit_region(&mut case.container, is_void_method, result, blocks, depth + 1);
            }
        }

        Region::TryCatch { try_region, handlers, finally } => {
            visit_region(try_region, is_void_method, result, blocks, depth + 1);
            for handler in handlers {
                visit_region(&mut handler.region, is_void_method, result, blocks, depth + 1);
            }
            if let Some(finally_region) = finally {
                visit_region(finally_region, is_void_method, result, blocks, depth + 1);
            }
        }

        Region::Synchronized { body, .. } => {
            visit_region(body, is_void_method, result, blocks, depth + 1);
        }

        // Terminal regions don't need processing
        _ => {}
    }
}

/// Remove trailing return statement from void method
///
/// Clone of JADX ReturnVisitor.processBlockTraced()
/// Reference: jadx-fast/jadx-core/src/main/java/jadx/core/dex/visitors/regions/ReturnVisitor.java:41-54
///
/// In void methods, a trailing `return;` is redundant and can be removed
/// if nothing follows it in the region tree.
fn remove_trailing_return(
    contents: &mut Vec<RegionContent>,
    blocks: &HashMap<u32, Vec<InsnNode>>,
) -> bool {
    if contents.is_empty() {
        return false;
    }

    // Check if last content is a block with only a void return
    if let Some(RegionContent::Block(block_id)) = contents.last() {
        if let Some(insns) = blocks.get(block_id) {
            if is_void_return_block(insns) {
                // Remove the block containing only void return
                contents.pop();
                return true;
            }
        }
    }

    false
}

/// Simplify if-return patterns
///
/// Clone of JADX pattern optimization
/// Patterns like `if (cond) { throw; } else { return; }` → `if (cond) { throw; }`
fn simplify_if_return(
    _region: &mut Region,
    _is_void_method: bool,
    _blocks: &HashMap<u32, Vec<InsnNode>>,
) -> bool {
    // The main simplification (else { return; } removal) is now handled
    // directly in visit_region. Additional patterns could be added here.
    false
}

/// Check if a region contains only a void return
///
/// Used to detect `else { return; }` patterns that can be removed.
fn region_is_only_void_return(region: &Region, blocks: &HashMap<u32, Vec<InsnNode>>) -> bool {
    match region {
        Region::Sequence(contents) => {
            // Single block with only void return
            if contents.len() == 1 {
                if let RegionContent::Block(block_id) = &contents[0] {
                    if let Some(insns) = blocks.get(block_id) {
                        return is_void_return_block(insns);
                    }
                }
            }
            false
        }
        _ => false,
    }
}

/// Check if a region always exits (throw, return, break, continue)
///
/// Clone of JADX region exit checking
/// A region "always exits" if control never falls through to the next statement.
fn region_always_exits(region: &Region, blocks: &HashMap<u32, Vec<InsnNode>>) -> bool {
    match region {
        Region::Sequence(contents) => {
            // Check if last content exits
            if let Some(last) = contents.last() {
                match last {
                    RegionContent::Block(block_id) => {
                        if let Some(insns) = blocks.get(block_id) {
                            return block_ends_with_exit(insns);
                        }
                    }
                    RegionContent::Region(nested) => {
                        return region_always_exits(nested, blocks);
                    }
                }
            }
            false
        }
        Region::If { then_region, else_region, .. } => {
            // If exits if both branches exit
            if let Some(else_reg) = else_region {
                region_always_exits(then_region, blocks) && region_always_exits(else_reg, blocks)
            } else {
                false
            }
        }
        _ => false,
    }
}

/// Check if a block ends with an exit instruction (return, throw)
fn block_ends_with_exit(insns: &[InsnNode]) -> bool {
    if let Some(last) = insns.last() {
        matches!(
            last.insn_type,
            InsnType::Return { .. } | InsnType::Throw { .. }
        )
    } else {
        false
    }
}

/// Check if a region ends with a return statement
pub fn ends_with_return(region: &Region) -> bool {
    match region {
        Region::Sequence(contents) => {
            if let Some(last) = contents.last() {
                match last {
                    RegionContent::Block(_) => {
                        // Would need to check block contents
                        false
                    }
                    RegionContent::Region(nested) => ends_with_return(nested),
                }
            } else {
                false
            }
        }
        _ => false,
    }
}

/// Check if a block contains only a void return
pub fn is_void_return_block(insns: &[InsnNode]) -> bool {
    if insns.len() != 1 {
        return false;
    }

    matches!(insns[0].insn_type, InsnType::Return { value: None })
}

/// Check if a block ends with a return
pub fn block_ends_with_return(insns: &[InsnNode]) -> bool {
    if let Some(last) = insns.last() {
        matches!(last.insn_type, InsnType::Return { .. })
    } else {
        false
    }
}

#[cfg(test)]
mod tests {
    use super::*;

    #[test]
    fn test_empty_region() {
        let mut region = Region::Sequence(vec![]);
        let result = optimize_returns(&mut region, true);
        assert_eq!(result.removed_returns, 0);
    }

    #[test]
    fn test_void_return_block() {
        let insns = vec![InsnNode::new(InsnType::Return { value: None }, 0)];
        assert!(is_void_return_block(&insns));
    }

    #[test]
    fn test_non_void_return_block() {
        use dexterity_ir::instructions::{InsnArg, LiteralArg, RegisterArg};

        let insns = vec![InsnNode::new(
            InsnType::Return {
                value: Some(InsnArg::Register(RegisterArg::new(0)))
            },
            0
        )];
        assert!(!is_void_return_block(&insns));
    }
}
