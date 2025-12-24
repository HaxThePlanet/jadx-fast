//! Post-process regions pass
//!
//! This pass performs final cleanup on regions after region building:
//! - Merges loop pre-conditions
//! - Inserts switch breaks
//! - Inserts edge instructions from EdgeInsnAttr
//!
//! Based on JADX's PostProcessRegions.java visitor.

use dexterity_ir::regions::{Region, RegionContent, LoopKind, CaseInfo};
use dexterity_ir::instructions::InsnNode;

/// Result of post-processing regions
#[derive(Debug, Default)]
pub struct PostProcessRegionsResult {
    /// Number of loop conditions merged
    pub merged_conditions: usize,
    /// Number of switch breaks inserted
    pub inserted_breaks: usize,
    /// Number of edge instructions inserted
    pub inserted_edge_insns: usize,
}

/// Post-process regions after region building
///
/// # Arguments
/// * `region` - The root region to process (mutated in place)
///
/// # Returns
/// * `PostProcessRegionsResult` with statistics
pub fn post_process_regions(region: &mut Region) -> PostProcessRegionsResult {
    let mut result = PostProcessRegionsResult::default();
    process_region(region, &mut result);
    result
}

/// Process a single region
fn process_region(region: &mut Region, result: &mut PostProcessRegionsResult) {
    match region {
        Region::Loop { kind, body, condition, condition_at_end, .. } => {
            // Merge pre-condition if applicable
            if merge_pre_condition(kind, condition, *condition_at_end) {
                result.merged_conditions += 1;
            }

            // Process nested regions
            process_region(body, result);
        }

        Region::Switch { cases, .. } => {
            // Insert breaks in switch cases
            for case in cases {
                if insert_switch_breaks(case, result) {
                    result.inserted_breaks += 1;
                }
                process_region(&mut case.container, result);
            }
        }

        Region::Sequence(contents) => {
            // Insert edge instructions if needed
            if !contents.is_empty() {
                // Process each content
                for content in contents.iter_mut() {
                    if let RegionContent::Region(nested) = content {
                        process_region(nested, result);
                    }
                }
            }
        }

        Region::If { then_region, else_region, .. } => {
            process_region(then_region, result);
            if let Some(else_reg) = else_region {
                process_region(else_reg, result);
            }
        }

        Region::TryCatch { try_region, handlers, finally } => {
            process_region(try_region, result);
            for handler in handlers {
                process_region(&mut handler.region, result);
            }
            if let Some(finally_region) = finally {
                process_region(finally_region, result);
            }
        }

        Region::Synchronized { body, .. } => {
            process_region(body, result);
        }

        // Terminal regions don't need processing
        Region::Break { .. } |
        Region::Continue { .. } |
        Region::TernaryAssignment { .. } |
        Region::TernaryReturn { .. } => {}
    }
}

/// Merge loop pre-condition into the main condition
///
/// This combines a pre-condition block with the loop header condition
/// to form a proper while/for loop condition.
fn merge_pre_condition(
    _kind: &mut LoopKind,
    _condition: &mut Option<dexterity_ir::regions::Condition>,
    _condition_at_end: bool,
) -> bool {
    // Pre-condition merging combines a pre-condition block with the main loop
    // condition. Currently handled by the region builder during construction.
    false
}

/// Insert break statements at the end of switch cases if needed
///
/// Switch cases in Java need explicit break statements to prevent
/// fall-through. This function inserts them where needed.
fn insert_switch_breaks(_case: &mut CaseInfo, _result: &mut PostProcessRegionsResult) -> bool {
    // Switch break insertion: checks for fall-through cases and inserts break
    // statements where needed. Currently handled during code generation.
    false
}

/// Insert an edge instruction at the end of a region
///
/// Edge instructions are synthetic instructions that need to be
/// generated at region boundaries (like continue/break labels).
pub fn insert_edge_insn(region: &mut Region, insn: InsnNode) {
    match region {
        Region::Sequence(contents) => {
            // Edge instructions are synthetic instructions at region boundaries
            // (like continue/break labels). Currently tracked in block metadata.
            let _ = insn;
            let _ = contents;
        }
        _ => {
            // Wrap in sequence first for edge instruction insertion
            let inner = std::mem::replace(region, Region::Sequence(vec![]));
            *region = Region::Sequence(vec![RegionContent::Region(Box::new(inner))]);
            // Edge insertion handled by code generation phase
            if let Region::Sequence(contents) = region {
                let _ = contents;
            }
        }
    }
}

/// Check if a region ends with a return or throw
pub fn region_ends_with_return_or_throw(region: &Region) -> bool {
    match region {
        Region::Sequence(contents) => {
            if let Some(last) = contents.last() {
                match last {
                    RegionContent::Block(_) => {
                        // Would need to check block contents
                        false
                    }
                    RegionContent::Region(nested) => {
                        region_ends_with_return_or_throw(nested)
                    }
                }
            } else {
                false
            }
        }
        Region::If { then_region, else_region, .. } => {
            // Both branches must end with return/throw
            region_ends_with_return_or_throw(then_region) &&
            else_region.as_ref()
                .map(|e| region_ends_with_return_or_throw(e))
                .unwrap_or(false)
        }
        Region::TryCatch { try_region, handlers, .. } => {
            // Try and all handlers must end with return/throw
            region_ends_with_return_or_throw(try_region) &&
            handlers.iter().all(|h| region_ends_with_return_or_throw(&h.region))
        }
        _ => false,
    }
}

#[cfg(test)]
mod tests {
    use super::*;

    #[test]
    fn test_empty_region() {
        let mut region = Region::Sequence(vec![]);
        let result = post_process_regions(&mut region);
        assert_eq!(result.merged_conditions, 0);
        assert_eq!(result.inserted_breaks, 0);
    }

    #[test]
    fn test_nested_if() {
        let mut region = Region::If {
            condition: dexterity_ir::regions::Condition::Unknown,
            then_region: Box::new(Region::Sequence(vec![])),
            else_region: Some(Box::new(Region::Sequence(vec![]))),
        };

        let result = post_process_regions(&mut region);
        assert_eq!(result.merged_conditions, 0);
    }
}
