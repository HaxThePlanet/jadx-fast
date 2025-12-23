//! Exception Handlers Region Maker Pass
//!
//! JADX Clone: jadx-core/src/main/java/jadx/core/dex/visitors/regions/maker/ExcHandlersRegionMaker.java
//! Original Author: Skylot (skylot@gmail.com)
//! Clone Date: Dec 2025
//!
//! Processes exception handlers to create proper handler regions.
//! The pass:
//! 1. Collects handler blocks for try-catch blocks
//! 2. Finds handler exits by computing path crosses
//! 3. Creates handler regions with proper exit points
//! 4. Handles successor blocks that aren't included in any region

use std::collections::HashSet;

use dexterity_ir::regions::Region;

/// Result of exception handler region processing
#[derive(Debug, Default)]
pub struct ExcHandlersRegionResult {
    /// Number of handler regions created
    pub handlers_processed: usize,
    /// Number of successor blocks added to out-region
    pub out_blocks_added: usize,
    /// Warnings encountered
    pub warnings: Vec<String>,
}

/// Information about an exception handler
#[derive(Debug, Clone)]
pub struct ExceptionHandlerInfo {
    /// Exception type (None for catch-all)
    pub exception_type: Option<String>,
    /// Handler block ID
    pub handler_block: u32,
    /// Top splitter block for this handler
    pub top_splitter: Option<u32>,
    /// Whether this is a finally handler
    pub is_finally: bool,
    /// Handler region (once constructed)
    pub handler_region: Option<Box<Region>>,
}

/// Information about a try-catch block
#[derive(Debug, Clone)]
pub struct TryCatchBlockAttr {
    /// Try block start offset
    pub start_offset: u32,
    /// Try block end offset
    pub end_offset: u32,
    /// Exception handlers
    pub handlers: Vec<ExceptionHandlerInfo>,
}

/// Process exception handlers to create proper regions.
///
/// JADX Reference: ExcHandlersRegionMaker.java:34-42
pub fn process_exc_handlers<F, G, H, I, J, K>(
    try_catch_blocks: &[TryCatchBlockAttr],
    method_region: &Region,
    get_successors: F,
    get_dom_frontier: G,
    is_path_exists: H,
    is_in_loop: I,
    region_contains_block: J,
    mut make_region: K,
) -> ExcHandlersRegionResult
where
    F: Fn(u32) -> Vec<u32> + Copy,
    G: Fn(u32) -> HashSet<u32> + Copy,
    H: Fn(u32, u32) -> bool + Copy,
    I: Fn(u32) -> bool + Copy,
    J: Fn(&Region, u32) -> bool + Copy,
    K: FnMut(u32, &HashSet<u32>) -> Option<Region>,
{
    let mut result = ExcHandlersRegionResult::default();

    if try_catch_blocks.is_empty() {
        return result;
    }

    // Process each try-catch block
    // JADX Reference: ExcHandlersRegionMaker.java:46-81
    for tc in try_catch_blocks {
        // Collect handler blocks and their splitters
        // JADX Reference: ExcHandlersRegionMaker.java:47-57
        let mut handler_blocks = Vec::new();
        let mut splitters = HashSet::new();

        for handler in &tc.handlers {
            handler_blocks.push(handler.handler_block);
            if let Some(splitter) = handler.top_splitter {
                splitters.insert(splitter);
            }
        }

        // Find common exit points
        // JADX Reference: ExcHandlersRegionMaker.java:58-75
        let exits = find_handler_exits(
            &splitters,
            &handler_blocks,
            get_successors,
            is_path_exists,
        );

        // Process each handler
        // JADX Reference: ExcHandlersRegionMaker.java:76-78
        for handler in &tc.handlers {
            if let Some(_region) = process_exc_handler(
                handler,
                &exits,
                get_dom_frontier,
                is_path_exists,
                is_in_loop,
                region_contains_block,
                method_region,
                &mut make_region,
            ) {
                result.handlers_processed += 1;
            }
        }
    }

    result
}

/// Find common exit points for handlers.
///
/// JADX Reference: ExcHandlersRegionMaker.java:58-75
fn find_handler_exits<F, H>(
    splitters: &HashSet<u32>,
    handler_blocks: &[u32],
    get_successors: F,
    is_path_exists: H,
) -> HashSet<u32>
where
    F: Fn(u32) -> Vec<u32> + Copy,
    H: Fn(u32, u32) -> bool + Copy,
{
    let mut exits = HashSet::new();

    for &splitter in splitters {
        for &handler in handler_blocks {
            // Get first successor of splitter
            // JADX Reference: ExcHandlersRegionMaker.java:64-65
            let succs = get_successors(splitter);
            if succs.is_empty() {
                continue;
            }
            let ss = succs[0];

            // Find path cross between splitter successor and handler
            // JADX Reference: ExcHandlersRegionMaker.java:70-71
            if let Some(cross) = find_path_cross(ss, handler, get_successors, is_path_exists) {
                if cross != ss && cross != handler {
                    exits.insert(cross);
                }
            }
        }
    }

    exits
}

/// Find path cross between two blocks.
///
/// Returns first block reachable from both start blocks.
fn find_path_cross<F, H>(
    block1: u32,
    block2: u32,
    get_successors: F,
    is_path_exists: H,
) -> Option<u32>
where
    F: Fn(u32) -> Vec<u32> + Copy,
    H: Fn(u32, u32) -> bool + Copy,
{
    // BFS from block1, checking if block2 can reach each node
    let mut visited = HashSet::new();
    let mut queue = vec![block1];

    while let Some(block) = queue.pop() {
        if !visited.insert(block) {
            continue;
        }

        // Check if block2 can reach this block
        if is_path_exists(block2, block) {
            return Some(block);
        }

        for succ in get_successors(block) {
            if !visited.contains(&succ) {
                queue.push(succ);
            }
        }
    }

    None
}

/// Process a single exception handler.
///
/// JADX Reference: ExcHandlersRegionMaker.java:119-152
fn process_exc_handler<G, H, I, J, K>(
    handler: &ExceptionHandlerInfo,
    exits: &HashSet<u32>,
    get_dom_frontier: G,
    is_path_exists: H,
    is_in_loop: I,
    region_contains_block: J,
    method_region: &Region,
    make_region: &mut K,
) -> Option<Region>
where
    G: Fn(u32) -> HashSet<u32> + Copy,
    H: Fn(u32, u32) -> bool + Copy,
    I: Fn(u32) -> bool + Copy,
    J: Fn(&Region, u32) -> bool + Copy,
    K: FnMut(u32, &HashSet<u32>) -> Option<Region>,
{
    let start = handler.handler_block;

    // Get dominator for handler exits
    // JADX Reference: ExcHandlersRegionMaker.java:125-131
    let dom = if handler.is_finally {
        handler.top_splitter.unwrap_or(start)
    } else {
        start
    };

    // Compute handler exits from dominance frontier
    // JADX Reference: ExcHandlersRegionMaker.java:135-143
    let dom_frontier = get_dom_frontier(dom);
    let in_loop = is_in_loop(start);

    let mut handler_exits = HashSet::new();
    for exit_block in dom_frontier {
        // Check if exit is valid: path exists and block is in method region
        // JADX Reference: ExcHandlersRegionMaker.java:138-141
        if (!in_loop || is_path_exists(start, exit_block))
            && region_contains_block(method_region, exit_block)
        {
            handler_exits.insert(exit_block);
        }
    }

    // Add exits from handler analysis
    handler_exits.extend(exits.iter().cloned());

    // Create handler region
    // JADX Reference: ExcHandlersRegionMaker.java:144
    make_region(start, &handler_exits)
}

/// Find handler successor blocks not in any region.
///
/// JADX Reference: ExcHandlersRegionMaker.java:86-117
pub fn find_handlers_out_blocks<F, G>(
    try_catch_blocks: &[TryCatchBlockAttr],
    method_region: &Region,
    get_all_region_blocks: F,
    get_last_block_successors: G,
) -> Vec<u32>
where
    F: Fn(&Region) -> HashSet<u32>,
    G: Fn(&Region) -> Vec<u32>,
{
    let all_region_blocks = get_all_region_blocks(method_region);
    let mut successor_blocks = HashSet::new();

    // Collect successor blocks from all handlers
    // JADX Reference: ExcHandlersRegionMaker.java:91-102
    for tc in try_catch_blocks {
        for handler in &tc.handlers {
            if let Some(ref region) = handler.handler_region {
                let last_succs = get_last_block_successors(region);
                for succ in last_succs {
                    successor_blocks.insert(succ);
                }
            }
        }
    }

    // Remove blocks already in regions
    // JADX Reference: ExcHandlersRegionMaker.java:103
    let out_blocks: Vec<u32> = successor_blocks
        .into_iter()
        .filter(|b| !all_region_blocks.contains(b))
        .collect();

    out_blocks
}

/// Get top splitter block for a handler.
///
/// JADX Reference: BlockUtils.getTopSplitterForHandler() used in ExcHandlersRegionMaker
pub fn get_top_splitter_for_handler<F>(
    handler_block: u32,
    get_predecessors: F,
    is_splitter: impl Fn(u32) -> bool,
) -> Option<u32>
where
    F: Fn(u32) -> Vec<u32>,
{
    // Walk up predecessors to find the splitter block
    let mut current = handler_block;
    let mut visited = HashSet::new();

    while visited.insert(current) {
        if is_splitter(current) {
            return Some(current);
        }

        let preds = get_predecessors(current);
        if preds.len() != 1 {
            break;
        }
        current = preds[0];
    }

    None
}

#[cfg(test)]
mod tests {
    use super::*;

    #[test]
    fn test_result_default() {
        let result = ExcHandlersRegionResult::default();
        assert_eq!(result.handlers_processed, 0);
        assert_eq!(result.out_blocks_added, 0);
        assert!(result.warnings.is_empty());
    }

    #[test]
    fn test_exception_handler_info() {
        let handler = ExceptionHandlerInfo {
            exception_type: Some("java.lang.Exception".to_string()),
            handler_block: 10,
            top_splitter: Some(5),
            is_finally: false,
            handler_region: None,
        };

        assert_eq!(handler.handler_block, 10);
        assert!(!handler.is_finally);
    }

    #[test]
    fn test_try_catch_block_attr() {
        let tc = TryCatchBlockAttr {
            start_offset: 0,
            end_offset: 100,
            handlers: vec![
                ExceptionHandlerInfo {
                    exception_type: Some("java.lang.Exception".to_string()),
                    handler_block: 10,
                    top_splitter: None,
                    is_finally: false,
                    handler_region: None,
                },
            ],
        };

        assert_eq!(tc.handlers.len(), 1);
        assert_eq!(tc.start_offset, 0);
    }

    #[test]
    fn test_find_handler_exits_empty() {
        let exits = find_handler_exits(
            &HashSet::new(),
            &[],
            |_| vec![],
            |_, _| false,
        );
        assert!(exits.is_empty());
    }

    #[test]
    fn test_find_handlers_out_blocks_empty() {
        let region = Region::Sequence(vec![]);
        let out_blocks = find_handlers_out_blocks(
            &[],
            &region,
            |_| HashSet::new(),
            |_| vec![],
        );
        assert!(out_blocks.is_empty());
    }

    #[test]
    fn test_get_top_splitter() {
        // Linear chain: 0 -> 1 -> 2, where 0 is splitter
        let splitter = get_top_splitter_for_handler(
            2,
            |block| {
                match block {
                    2 => vec![1],
                    1 => vec![0],
                    _ => vec![],
                }
            },
            |block| block == 0,
        );
        assert_eq!(splitter, Some(0));
    }
}
