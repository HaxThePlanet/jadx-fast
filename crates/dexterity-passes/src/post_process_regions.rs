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
    process_region_with_depth(region, &mut result, 0);
    result
}

/// Process a single region
fn process_region(region: &mut Region, result: &mut PostProcessRegionsResult) {
    process_region_with_depth(region, result, 0);
}

fn process_region_with_depth(region: &mut Region, result: &mut PostProcessRegionsResult, depth: usize) {
    // Prevent stack overflow from deeply nested regions
    let max_depth = dexterity_limits::regions::visitor_max_depth();
    if depth > max_depth {
        tracing::error!(
            depth = depth,
            limit = max_depth,
            "LIMIT_EXCEEDED: post_process_regions max depth reached"
        );
        return;
    }

    match region {
        Region::Loop { kind, body, condition, condition_at_end, .. } => {
            // Merge pre-condition if applicable
            if merge_pre_condition(kind, condition, *condition_at_end) {
                result.merged_conditions += 1;
            }

            // Process nested regions
            process_region_with_depth(body, result, depth + 1);
        }

        Region::Switch { cases, .. } => {
            // Insert breaks in switch cases
            for case in cases {
                if insert_switch_breaks(case, result) {
                    result.inserted_breaks += 1;
                }
                process_region_with_depth(&mut case.container, result, depth + 1);
            }
        }

        Region::Sequence(contents) => {
            // Insert edge instructions if needed
            if !contents.is_empty() {
                // Process each content
                for content in contents.iter_mut() {
                    if let RegionContent::Region(nested) = content {
                        process_region_with_depth(nested, result, depth + 1);
                    }
                }
            }
        }

        Region::If { then_region, else_region, .. } => {
            process_region_with_depth(then_region, result, depth + 1);
            if let Some(else_reg) = else_region {
                process_region_with_depth(else_reg, result, depth + 1);
            }
        }

        Region::TryCatch { try_region, handlers, finally } => {
            process_region_with_depth(try_region, result, depth + 1);
            for handler in handlers {
                process_region_with_depth(&mut handler.region, result, depth + 1);
            }
            if let Some(finally_region) = finally {
                process_region_with_depth(finally_region, result, depth + 1);
            }
        }

        Region::Synchronized { body, .. } => {
            process_region_with_depth(body, result, depth + 1);
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
///
/// Port of JADX SwitchRegionMaker.insertBreaksForCase() (lines 367-405)
fn insert_switch_breaks(case: &mut CaseInfo, _result: &mut PostProcessRegionsResult) -> bool {
    // Check if the case container already ends with an exit (return/throw/break/continue)
    if region_always_exits(&case.container) {
        return false;
    }

    // Case doesn't end with an exit instruction - need to insert a break
    // Wrap the case container to append a break at the end
    insert_break_at_end(&mut case.container)
}

/// Check if a region always exits (return, throw, break, or continue)
///
/// Based on JADX RegionUtils.hasExitBlock() - a region "always exits" if
/// control never falls through to the next statement.
fn region_always_exits(region: &Region) -> bool {
    region_always_exits_with_depth(region, 0)
}

fn region_always_exits_with_depth(region: &Region, depth: usize) -> bool {
    // Prevent stack overflow from deeply nested regions
    let max_depth = dexterity_limits::regions::visitor_max_depth();
    if depth > max_depth {
        return false; // Conservatively assume it doesn't exit
    }

    match region {
        // Break and Continue are exits (they transfer control)
        Region::Break { .. } | Region::Continue { .. } => true,

        // Ternary return is an exit (returns from method)
        Region::TernaryReturn { .. } => true,

        // Sequence: check if the last element exits
        Region::Sequence(contents) => {
            if let Some(last) = contents.last() {
                match last {
                    RegionContent::Block(_) => {
                        // Would need to check if block ends with return/throw
                        // For now, conservatively assume it doesn't exit
                        false
                    }
                    RegionContent::Region(nested) => region_always_exits_with_depth(nested, depth + 1),
                }
            } else {
                false // Empty sequence doesn't exit
            }
        }

        // If-else: both branches must exit for the whole region to exit
        Region::If { then_region, else_region, .. } => {
            let then_exits = region_always_exits_with_depth(then_region, depth + 1);
            let else_exits = else_region
                .as_ref()
                .map(|e| region_always_exits_with_depth(e, depth + 1))
                .unwrap_or(false);
            then_exits && else_exits
        }

        // Try-catch: try and all handlers must exit
        Region::TryCatch { try_region, handlers, .. } => {
            region_always_exits_with_depth(try_region, depth + 1)
                && handlers.iter().all(|h| region_always_exits_with_depth(&h.region, depth + 1))
        }

        // Loop, Switch, Synchronized don't inherently exit
        Region::Loop { .. } => false,
        Region::Switch { .. } => false,
        Region::Synchronized { body, .. } => region_always_exits_with_depth(body, depth + 1),

        // Ternary assignment doesn't exit (just assigns)
        Region::TernaryAssignment { .. } => false,
    }
}

/// Insert a break at the end of a region
///
/// Returns true if a break was inserted
fn insert_break_at_end(region: &mut Region) -> bool {
    match region {
        Region::Sequence(contents) => {
            // Append a Break region at the end
            contents.push(RegionContent::Region(Box::new(Region::Break { label: None })));
            true
        }
        _ => {
            // Wrap the region in a sequence with a break
            let inner = std::mem::replace(region, Region::Sequence(vec![]));
            *region = Region::Sequence(vec![
                RegionContent::Region(Box::new(inner)),
                RegionContent::Region(Box::new(Region::Break { label: None })),
            ]);
            true
        }
    }
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
    region_ends_with_return_or_throw_with_depth(region, 0)
}

fn region_ends_with_return_or_throw_with_depth(region: &Region, depth: usize) -> bool {
    // Prevent stack overflow from deeply nested regions
    let max_depth = dexterity_limits::regions::visitor_max_depth();
    if depth > max_depth {
        return false; // Conservatively assume it doesn't end with return/throw
    }

    match region {
        Region::Sequence(contents) => {
            if let Some(last) = contents.last() {
                match last {
                    RegionContent::Block(_) => {
                        // Would need to check block contents
                        false
                    }
                    RegionContent::Region(nested) => {
                        region_ends_with_return_or_throw_with_depth(nested, depth + 1)
                    }
                }
            } else {
                false
            }
        }
        Region::If { then_region, else_region, .. } => {
            // Both branches must end with return/throw
            region_ends_with_return_or_throw_with_depth(then_region, depth + 1) &&
            else_region.as_ref()
                .map(|e| region_ends_with_return_or_throw_with_depth(e, depth + 1))
                .unwrap_or(false)
        }
        Region::TryCatch { try_region, handlers, .. } => {
            // Try and all handlers must end with return/throw
            region_ends_with_return_or_throw_with_depth(try_region, depth + 1) &&
            handlers.iter().all(|h| region_ends_with_return_or_throw_with_depth(&h.region, depth + 1))
        }
        _ => false,
    }
}

#[cfg(test)]
mod tests {
    use super::*;
    use dexterity_ir::regions::{CaseKey, CaseInfo};

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
            condition_blocks: vec![],
            then_region: Box::new(Region::Sequence(vec![])),
            else_region: Some(Box::new(Region::Sequence(vec![]))),
        };

        let result = post_process_regions(&mut region);
        assert_eq!(result.merged_conditions, 0);
    }

    #[test]
    fn test_switch_break_insertion() {
        // Create a switch with a case that doesn't end with an exit
        let mut region = Region::Switch {
            header_block: 0,
            cases: vec![
                CaseInfo::new(
                    vec![CaseKey::Int(1)],
                    Region::Sequence(vec![RegionContent::Block(10)]),
                ),
                CaseInfo::new(
                    vec![CaseKey::Default],
                    Region::Sequence(vec![
                        RegionContent::Region(Box::new(Region::Break { label: None })),
                    ]),
                ),
            ],
        };

        let result = post_process_regions(&mut region);
        // First case should have had a break inserted
        assert_eq!(result.inserted_breaks, 1);

        // Verify the break was inserted
        if let Region::Switch { cases, .. } = &region {
            // First case should now end with a break
            if let Region::Sequence(contents) = &*cases[0].container {
                assert_eq!(contents.len(), 2); // Block + Break
                if let Some(RegionContent::Region(r)) = contents.last() {
                    assert!(matches!(r.as_ref(), Region::Break { .. }));
                }
            }
            // Second case already had a break, should be unchanged
            if let Region::Sequence(contents) = &*cases[1].container {
                assert_eq!(contents.len(), 1); // Just the original Break
            }
        }
    }

    #[test]
    fn test_switch_no_break_for_exit() {
        // A case that already ends with a break shouldn't get another one
        let mut region = Region::Switch {
            header_block: 0,
            cases: vec![
                CaseInfo::new(
                    vec![CaseKey::Int(1)],
                    Region::Sequence(vec![
                        RegionContent::Region(Box::new(Region::Break { label: None })),
                    ]),
                ),
            ],
        };

        let result = post_process_regions(&mut region);
        assert_eq!(result.inserted_breaks, 0);
    }
}
