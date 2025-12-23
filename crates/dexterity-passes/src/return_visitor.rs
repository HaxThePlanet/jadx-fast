//! Return statement optimization pass
//!
//! This pass optimizes return statements in regions:
//! - Removes redundant return statements at end of void methods
//! - Simplifies if-return patterns
//! - Combines common return patterns
//!
//! Based on JADX's ReturnVisitor.java visitor.

use dexterity_ir::regions::{Region, RegionContent};
use dexterity_ir::instructions::{InsnNode, InsnType};

/// Result of return optimization
#[derive(Debug, Default)]
pub struct ReturnVisitorResult {
    /// Number of redundant returns removed
    pub removed_returns: usize,
    /// Number of if-return patterns simplified
    pub simplified_patterns: usize,
}

/// Optimize return statements in a region tree
///
/// # Arguments
/// * `region` - The root region to optimize (mutated in place)
/// * `is_void_method` - Whether this is a void method
///
/// # Returns
/// * `ReturnVisitorResult` with optimization statistics
pub fn optimize_returns(region: &mut Region, is_void_method: bool) -> ReturnVisitorResult {
    let mut result = ReturnVisitorResult::default();
    visit_region(region, is_void_method, &mut result);
    result
}

/// Visit a region and optimize returns
fn visit_region(region: &mut Region, is_void_method: bool, result: &mut ReturnVisitorResult) {
    match region {
        Region::Sequence(contents) => {
            // First visit all nested regions
            for content in contents.iter_mut() {
                if let RegionContent::Region(nested) = content {
                    visit_region(nested, is_void_method, result);
                }
            }

            // Then check for redundant trailing return in void method
            if is_void_method {
                if remove_trailing_return(contents) {
                    result.removed_returns += 1;
                }
            }
        }

        Region::If { then_region, else_region, .. } => {
            visit_region(then_region, is_void_method, result);
            if let Some(else_reg) = else_region {
                visit_region(else_reg, is_void_method, result);
            }

            // Check for if-return pattern simplification
            if simplify_if_return(region, is_void_method) {
                result.simplified_patterns += 1;
            }
        }

        Region::Loop { body, .. } => {
            visit_region(body, is_void_method, result);
        }

        Region::Switch { cases, .. } => {
            for case in cases {
                visit_region(&mut case.container, is_void_method, result);
            }
        }

        Region::TryCatch { try_region, handlers, finally } => {
            visit_region(try_region, is_void_method, result);
            for handler in handlers {
                visit_region(&mut handler.region, is_void_method, result);
            }
            if let Some(finally_region) = finally {
                visit_region(finally_region, is_void_method, result);
            }
        }

        Region::Synchronized { body, .. } => {
            visit_region(body, is_void_method, result);
        }

        // Terminal regions don't need processing
        _ => {}
    }
}

/// Remove trailing return statement from void method
///
/// In void methods, a trailing `return;` is redundant and can be removed.
fn remove_trailing_return(contents: &mut Vec<RegionContent>) -> bool {
    if contents.is_empty() {
        return false;
    }

    // Check if last content is a block with only a void return
    if let Some(RegionContent::Block(_block_id)) = contents.last() {
        // Would need to check block instructions
        // For now, return false - full implementation would:
        // 1. Get the block
        // 2. Check if last instruction is Return { value: None }
        // 3. Check if it's the only instruction
        // 4. If so, remove the block
        false
    } else {
        false
    }
}

/// Simplify if-return patterns
///
/// Patterns like:
/// ```text
/// if (cond) {
///     return x;
/// }
/// return y;
/// ```
/// Can be simplified in some cases.
fn simplify_if_return(_region: &mut Region, _is_void_method: bool) -> bool {
    // TODO: Implement if-return simplification
    // This would:
    // 1. Detect patterns where then/else both end in return
    // 2. Check if the condition can be inverted to reduce nesting
    // 3. Apply transformation if beneficial
    false
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
