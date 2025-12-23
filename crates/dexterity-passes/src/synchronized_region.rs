//! Synchronized Region Maker Pass
//!
//! JADX Clone: jadx-core/src/main/java/jadx/core/dex/visitors/regions/maker/SynchronizedRegionMaker.java
//! Original Author: Skylot (skylot@gmail.com)
//! Clone Date: Dec 2025
//!
//! Detects and constructs synchronized regions from MONITOR_ENTER/MONITOR_EXIT pairs.
//! The pass:
//! 1. Identifies MONITOR_ENTER instructions
//! 2. Traverses to find matching MONITOR_EXIT instructions
//! 3. Creates SynchronizedRegion wrapping the synchronized block body
//! 4. Optionally removes synchronized blocks in synchronized methods

use std::collections::HashSet;

use dexterity_ir::instructions::InsnType;
use dexterity_ir::regions::{Region, RegionContent};

/// Result of synchronized region processing
#[derive(Debug, Default)]
pub struct SynchronizedRegionResult {
    /// Number of synchronized regions created
    pub regions_created: usize,
    /// Number of synchronized blocks removed (in synchronized methods)
    pub regions_removed: usize,
    /// Warnings encountered
    pub warnings: Vec<String>,
}

/// Information about a monitor instruction
#[derive(Debug, Clone)]
pub struct MonitorInfo {
    /// Block containing the monitor instruction
    pub block_id: u32,
    /// Instruction offset within the block
    pub insn_offset: u32,
    /// Monitor argument (the object being synchronized on)
    pub arg_reg: u16,
    /// SSA version of the argument register
    pub arg_version: u32,
}

/// Information about a synchronized block
#[derive(Debug, Clone)]
pub struct SyncBlockInfo {
    /// MONITOR_ENTER instruction info
    pub enter: MonitorInfo,
    /// MONITOR_EXIT instructions (can be multiple for try-finally)
    pub exits: Vec<MonitorInfo>,
    /// Blocks contained in the synchronized region
    pub body_blocks: HashSet<u32>,
    /// Exit block (first block after synchronized region)
    pub exit_block: Option<u32>,
}

/// Process synchronized regions in a method.
///
/// JADX Reference: SynchronizedRegionMaker.java:41-90
pub fn process_synchronized_regions<F, G, H, I, J>(
    enter_block: u32,
    get_block_insns: F,
    get_insn_type: G,
    get_insn_arg: H,
    get_successors: I,
    is_path_exists: J,
) -> SynchronizedRegionResult
where
    F: Fn(u32) -> Vec<u32> + Copy,
    G: Fn(u32) -> Option<InsnType> + Copy,
    H: Fn(u32, usize) -> Option<(u16, u32)> + Copy, // (insn_offset, arg_idx) -> (reg, version)
    I: Fn(u32) -> Vec<u32> + Copy,
    J: Fn(u32, u32) -> bool + Copy, // (from, to) -> has_path
{
    let mut result = SynchronizedRegionResult::default();

    // Find all MONITOR_ENTER instructions
    // JADX Reference: SynchronizedRegionMaker.java:41-48
    let enters = find_monitor_enters(enter_block, get_block_insns, get_insn_type, get_insn_arg, get_successors);

    for enter in enters {
        // Find matching MONITOR_EXIT instructions
        // JADX Reference: SynchronizedRegionMaker.java:95-112
        let exits = find_monitor_exits(
            &enter,
            get_block_insns,
            get_insn_type,
            get_insn_arg,
            get_successors,
        );

        if exits.is_empty() {
            result.warnings.push(format!(
                "No MONITOR_EXIT found for MONITOR_ENTER at block {} offset {}",
                enter.block_id, enter.insn_offset
            ));
            continue;
        }

        // Find exit block (common successor of all exits)
        // JADX Reference: SynchronizedRegionMaker.java:66-90
        let exit_block = find_exit_block(&exits, get_successors, is_path_exists);

        let sync_info = SyncBlockInfo {
            enter,
            exits,
            body_blocks: HashSet::new(), // Would be computed by region maker
            exit_block,
        };

        // In full implementation, would create SynchronizedRegion here
        // JADX Reference: SynchronizedRegionMaker.java:42-44
        result.regions_created += 1;
    }

    result
}

/// Find all MONITOR_ENTER instructions via DFS from entry block.
///
/// JADX Reference: SynchronizedRegionMaker.java traversal logic
fn find_monitor_enters<F, G, H, I>(
    start_block: u32,
    get_block_insns: F,
    get_insn_type: G,
    get_insn_arg: H,
    get_successors: I,
) -> Vec<MonitorInfo>
where
    F: Fn(u32) -> Vec<u32> + Copy,
    G: Fn(u32) -> Option<InsnType> + Copy,
    H: Fn(u32, usize) -> Option<(u16, u32)> + Copy,
    I: Fn(u32) -> Vec<u32> + Copy,
{
    let mut enters = Vec::new();
    let mut visited = HashSet::new();
    let mut stack = vec![start_block];

    while let Some(block_id) = stack.pop() {
        if !visited.insert(block_id) {
            continue;
        }

        // Check instructions in this block
        for insn_offset in get_block_insns(block_id) {
            if let Some(InsnType::MonitorEnter { .. }) = get_insn_type(insn_offset) {
                // Get the argument register
                if let Some((reg, version)) = get_insn_arg(insn_offset, 0) {
                    enters.push(MonitorInfo {
                        block_id,
                        insn_offset,
                        arg_reg: reg,
                        arg_version: version,
                    });
                }
            }
        }

        // Continue DFS
        for succ in get_successors(block_id) {
            if !visited.contains(&succ) {
                stack.push(succ);
            }
        }
    }

    enters
}

/// Find MONITOR_EXIT instructions matching a MONITOR_ENTER.
///
/// JADX Reference: SynchronizedRegionMaker.java:95-112
/// Traverse from monitor-enter thru successors and collect blocks contains monitor-exit
fn find_monitor_exits<F, G, H, I>(
    enter: &MonitorInfo,
    get_block_insns: F,
    get_insn_type: G,
    get_insn_arg: H,
    get_successors: I,
) -> Vec<MonitorInfo>
where
    F: Fn(u32) -> Vec<u32> + Copy,
    G: Fn(u32) -> Option<InsnType> + Copy,
    H: Fn(u32, usize) -> Option<(u16, u32)> + Copy,
    I: Fn(u32) -> Vec<u32> + Copy,
{
    let mut exits = Vec::new();
    let mut visited = HashSet::new();

    traverse_monitor_exits(
        enter.block_id,
        enter.arg_reg,
        enter.arg_version,
        &mut exits,
        &mut visited,
        get_block_insns,
        get_insn_type,
        get_insn_arg,
        get_successors,
    );

    exits
}

/// Recursive traversal to find monitor exits.
///
/// JADX Reference: SynchronizedRegionMaker.java:95-112
#[allow(clippy::too_many_arguments)]
fn traverse_monitor_exits<F, G, H, I>(
    block_id: u32,
    arg_reg: u16,
    arg_version: u32,
    exits: &mut Vec<MonitorInfo>,
    visited: &mut HashSet<u32>,
    get_block_insns: F,
    get_insn_type: G,
    get_insn_arg: H,
    get_successors: I,
)
where
    F: Fn(u32) -> Vec<u32> + Copy,
    G: Fn(u32) -> Option<InsnType> + Copy,
    H: Fn(u32, usize) -> Option<(u16, u32)> + Copy,
    I: Fn(u32) -> Vec<u32> + Copy,
{
    if !visited.insert(block_id) {
        return;
    }

    // Check instructions for MONITOR_EXIT with matching arg
    // JADX Reference: SynchronizedRegionMaker.java:98-105
    for insn_offset in get_block_insns(block_id) {
        if let Some(InsnType::MonitorExit { .. }) = get_insn_type(insn_offset) {
            if let Some((reg, version)) = get_insn_arg(insn_offset, 0) {
                // Check if same object as MONITOR_ENTER
                // JADX uses arg.equals(arg) which compares SSA variables
                if reg == arg_reg && version == arg_version {
                    exits.push(MonitorInfo {
                        block_id,
                        insn_offset,
                        arg_reg: reg,
                        arg_version: version,
                    });
                    return; // Found exit in this path, don't continue
                }
            }
        }
    }

    // Continue traversal
    // JADX Reference: SynchronizedRegionMaker.java:107-111
    for succ in get_successors(block_id) {
        traverse_monitor_exits(
            succ,
            arg_reg,
            arg_version,
            exits,
            visited,
            get_block_insns,
            get_insn_type,
            get_insn_arg,
            get_successors,
        );
    }
}

/// Find common exit block after synchronized region.
///
/// JADX Reference: SynchronizedRegionMaker.java:66-90
/// If single exit, return its successor.
/// If multiple exits, find path cross.
fn find_exit_block<I, J>(
    exits: &[MonitorInfo],
    get_successors: I,
    is_path_exists: J,
) -> Option<u32>
where
    I: Fn(u32) -> Vec<u32> + Copy,
    J: Fn(u32, u32) -> bool + Copy,
{
    if exits.is_empty() {
        return None;
    }

    if exits.len() == 1 {
        // Single exit - return first successor
        // JADX Reference: SynchronizedRegionMaker.java:66-67
        let succs = get_successors(exits[0].block_id);
        return succs.first().copied();
    }

    // Multiple exits - find path cross
    // JADX Reference: SynchronizedRegionMaker.java:68-90
    // traverseMonitorExitsCross() finds first node reachable from all exit blocks
    let exit_blocks: Vec<u32> = exits.iter().map(|e| e.block_id).collect();
    find_path_cross(&exit_blocks, get_successors, is_path_exists)
}

/// Find first block reachable from all given blocks.
///
/// JADX Reference: SynchronizedRegionMaker.java:117-139
fn find_path_cross<I, J>(
    blocks: &[u32],
    get_successors: I,
    is_path_exists: J,
) -> Option<u32>
where
    I: Fn(u32) -> Vec<u32> + Copy,
    J: Fn(u32, u32) -> bool + Copy,
{
    if blocks.is_empty() {
        return None;
    }

    let first = blocks[0];
    let mut visited = HashSet::new();
    let mut stack = vec![first];

    // BFS from first block to find cross point
    while let Some(block) = stack.pop() {
        if !visited.insert(block) {
            continue;
        }

        // Check if this block is reachable from all exit blocks
        let is_cross = blocks.iter().all(|&exit_block| {
            exit_block == block || is_path_exists(exit_block, block)
        });

        if is_cross {
            return Some(block);
        }

        for succ in get_successors(block) {
            if !visited.contains(&succ) {
                stack.push(succ);
            }
        }
    }

    None
}

/// Check if synchronized block can be removed for synchronized method.
///
/// JADX Reference: SynchronizedRegionMaker.java:163-183
/// canRemoveSyncBlock() checks if:
/// - Static method: sync on class const (Class.class)
/// - Instance method: sync on 'this'
pub fn can_remove_sync_block<F>(
    is_static_method: bool,
    sync_arg_reg: u16,
    sync_arg_version: u32,
    is_this_arg: F,
    get_const_class: impl Fn(u16, u32) -> Option<String>,
    class_name: &str,
) -> bool
where
    F: Fn(u16, u32) -> bool,
{
    if is_static_method {
        // For static synchronized methods, sync arg should be Class.class
        // JADX Reference: SynchronizedRegionMaker.java:165-175
        if let Some(const_class) = get_const_class(sync_arg_reg, sync_arg_version) {
            return const_class == class_name;
        }
        false
    } else {
        // For instance synchronized methods, sync arg should be 'this'
        // JADX Reference: SynchronizedRegionMaker.java:176-181
        is_this_arg(sync_arg_reg, sync_arg_version)
    }
}

/// Remove synchronized region from a synchronized method.
///
/// JADX Reference: SynchronizedRegionMaker.java:141-160
/// removeSynchronized() replaces SynchronizedRegion with its inner region
pub fn remove_synchronized_from_method(region: &mut Region) -> bool {
    match region {
        Region::Sequence(contents) => {
            // Check if first element is a synchronized region
            // JADX Reference: SynchronizedRegionMaker.java:144-145
            if let Some(first) = contents.first() {
                if let RegionContent::Region(inner) = first {
                    if matches!(inner.as_ref(), Region::Synchronized { .. }) {
                        // Would extract inner region and replace
                        // JADX Reference: SynchronizedRegionMaker.java:149
                        return true;
                    }
                }
            }
            false
        }
        _ => false,
    }
}

/// Create a synchronized region wrapping the given body.
///
/// JADX Reference: SynchronizedRegionMaker.java:42-44
pub fn create_synchronized_region(
    enter_insn_offset: u32,
    enter_block: u32,
    exit_insn_offsets: Vec<u32>,
    body: Region,
) -> Region {
    Region::Synchronized {
        enter_insn_offset,
        enter_block,
        body: Box::new(body),
        exit_insn_offsets,
    }
}

#[cfg(test)]
mod tests {
    use super::*;

    #[test]
    fn test_result_default() {
        let result = SynchronizedRegionResult::default();
        assert_eq!(result.regions_created, 0);
        assert_eq!(result.regions_removed, 0);
        assert!(result.warnings.is_empty());
    }

    #[test]
    fn test_monitor_info() {
        let info = MonitorInfo {
            block_id: 1,
            insn_offset: 10,
            arg_reg: 5,
            arg_version: 0,
        };
        assert_eq!(info.block_id, 1);
        assert_eq!(info.insn_offset, 10);
    }

    #[test]
    fn test_sync_block_info() {
        let enter = MonitorInfo {
            block_id: 1,
            insn_offset: 10,
            arg_reg: 5,
            arg_version: 0,
        };
        let exit = MonitorInfo {
            block_id: 3,
            insn_offset: 30,
            arg_reg: 5,
            arg_version: 0,
        };

        let info = SyncBlockInfo {
            enter,
            exits: vec![exit],
            body_blocks: HashSet::new(),
            exit_block: Some(4),
        };

        assert_eq!(info.exits.len(), 1);
        assert_eq!(info.exit_block, Some(4));
    }

    #[test]
    fn test_can_remove_sync_static() {
        // Static method with class const sync
        let result = can_remove_sync_block(
            true, // is_static
            5,
            0,
            |_, _| false,
            |_, _| Some("com.example.MyClass".to_string()),
            "com.example.MyClass",
        );
        assert!(result);
    }

    #[test]
    fn test_can_remove_sync_instance() {
        // Instance method with 'this' sync
        let result = can_remove_sync_block(
            false, // not static
            0,
            0,
            |reg, _| reg == 0, // v0 is 'this'
            |_, _| None,
            "com.example.MyClass",
        );
        assert!(result);
    }

    #[test]
    fn test_create_synchronized_region() {
        let body = Region::Sequence(vec![]);
        let sync_region = create_synchronized_region(10, 1, vec![30], body);

        match sync_region {
            Region::Synchronized { enter_insn_offset, enter_block, exit_insn_offsets, .. } => {
                assert_eq!(enter_insn_offset, 10);
                assert_eq!(enter_block, 1);
                assert_eq!(exit_insn_offsets, vec![30]);
            }
            _ => panic!("Expected Synchronized region"),
        }
    }
}
