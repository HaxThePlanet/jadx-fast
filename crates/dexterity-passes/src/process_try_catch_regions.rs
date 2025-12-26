//! Process Try-Catch Regions Pass
//!
//! JADX Clone: jadx-core/src/main/java/jadx/core/dex/visitors/regions/ProcessTryCatchRegions.java
//! Original Author: Skylot (skylot@gmail.com)
//! Clone Date: Dec 2025
//!
//! Extracts blocks to separate try/catch regions. This pass wraps blocks
//! that are dominated by a try-catch handler into proper TryCatchRegion
//! structures.

use std::collections::HashSet;

use dexterity_ir::regions::{CatchHandler, Region, RegionContent};

/// Result of processing try-catch regions
#[derive(Debug, Default)]
pub struct ProcessTryCatchRegionsResult {
    /// Number of try-catch regions created
    pub regions_created: usize,
    /// Warnings encountered
    pub warnings: Vec<String>,
}

/// Information about a try-catch block
#[derive(Debug, Clone)]
pub struct TryCatchBlockInfo {
    /// Top splitter block for this try region
    pub top_splitter: u32,
    /// Blocks in the try region
    pub try_blocks: HashSet<u32>,
    /// Exception handlers for this try block
    pub handlers: Vec<HandlerInfo>,
    /// Parent try block (for nested try-catch)
    pub outer_try: Option<usize>,
}

/// Information about an exception handler
#[derive(Debug, Clone)]
pub struct HandlerInfo {
    /// Handler block ID
    pub handler_block: u32,
    /// Exception type (None for catch-all)
    pub exception_type: Option<String>,
    /// Whether this handler has been removed
    pub removed: bool,
}

/// Process try-catch regions in a method.
///
/// JADX Reference: ProcessTryCatchRegions.java:27-39
pub fn process_try_catch_regions<F, G>(
    root_region: &mut Region,
    try_blocks: &mut Vec<TryCatchBlockInfo>,
    has_path_through: F,
    is_handler_path: G,
) -> ProcessTryCatchRegionsResult
where
    F: Fn(u32, &Region) -> bool + Copy,
    G: Fn(&TryCatchBlockInfo, &Region) -> bool + Copy,
{
    let mut result = ProcessTryCatchRegionsResult::default();

    if try_blocks.is_empty() {
        return result;
    }

    // Sort try blocks so parent comes first
    // JADX Reference: ProcessTryCatchRegions.java:47
    sort_try_blocks(try_blocks);

    // Traverse regions and wrap matching blocks
    // JADX Reference: ProcessTryCatchRegions.java:35-38
    while !try_blocks.is_empty() {
        let changed = check_and_wrap_region(
            root_region,
            try_blocks,
            has_path_through,
            is_handler_path,
            &mut result,
        );

        if !changed {
            break;
        }
    }

    result
}

/// Sort try blocks so parent try blocks come first.
///
/// JADX Reference: ProcessTryCatchRegions.java:41-49
fn sort_try_blocks(try_blocks: &mut Vec<TryCatchBlockInfo>) {
    // Simple sort: blocks with outer_try should come after their parent
    try_blocks.sort_by(|a, b| {
        match (a.outer_try, b.outer_try) {
            (None, Some(_)) => std::cmp::Ordering::Less,
            (Some(_), None) => std::cmp::Ordering::Greater,
            _ => std::cmp::Ordering::Equal,
        }
    });
}

/// Check region and wrap if it contains a try-catch top splitter.
///
/// JADX Reference: ProcessTryCatchRegions.java:51-64
fn check_and_wrap_region<F, G>(
    region: &mut Region,
    try_blocks: &mut Vec<TryCatchBlockInfo>,
    has_path_through: F,
    is_handler_path: G,
    result: &mut ProcessTryCatchRegionsResult,
) -> bool
where
    F: Fn(u32, &Region) -> bool + Copy,
    G: Fn(&TryCatchBlockInfo, &Region) -> bool + Copy,
{
    // Find try block with top splitter in this region
    // JADX Reference: ProcessTryCatchRegions.java:53-62
    let mut found_idx = None;
    for (idx, tb) in try_blocks.iter().enumerate() {
        if region_contains_block(region, tb.top_splitter) {
            found_idx = Some(idx);
            break;
        }
    }

    if let Some(idx) = found_idx {
        let tb = try_blocks.remove(idx);
        if wrap_blocks(region, &tb, has_path_through, is_handler_path) {
            result.regions_created += 1;
            return true;
        } else {
            result.warnings.push(format!(
                "Can't wrap try/catch for region with splitter block: {}",
                tb.top_splitter
            ));
        }
    }

    false
}

/// Check if a region directly contains a block.
fn region_contains_block(region: &Region, block_id: u32) -> bool {
    match region {
        Region::Sequence(contents) => {
            contents.iter().any(|c| match c {
                RegionContent::Block(b) => *b == block_id,
                _ => false,
            })
        }
        Region::Loop { body, .. } => region_contains_block(body, block_id),
        _ => false,
    }
}

/// Wrap blocks dominated by top_splitter into a TryCatchRegion.
///
/// JADX Reference: ProcessTryCatchRegions.java:69-113
fn wrap_blocks<F, G>(
    region: &mut Region,
    tb: &TryCatchBlockInfo,
    has_path_through: F,
    is_handler_path: G,
) -> bool
where
    F: Fn(u32, &Region) -> bool + Copy,
    G: Fn(&TryCatchBlockInfo, &Region) -> bool + Copy,
{
    match region {
        Region::Loop { body, .. } => {
            // Recurse into loop body
            // JADX Reference: ProcessTryCatchRegions.java:73-76
            return wrap_blocks(body, tb, has_path_through, is_handler_path);
        }
        Region::If {   .. } => {
            // For branch regions, wrap in parent
            // JADX Reference: ProcessTryCatchRegions.java:77-79
            // Would need parent reference to properly handle this
            return false;
        }
        Region::Sequence(contents) => {
            // Find blocks that are dominated by top_splitter
            // JADX Reference: ProcessTryCatchRegions.java:81-90
            let mut try_contents: Vec<RegionContent> = Vec::new();

            for content in contents.iter() {
                // Check if content has path through dominator
                if has_path_through_content(tb.top_splitter, content, has_path_through) {
                    // Check if this is a handler path
                    if let RegionContent::Region(r) = content {
                        if is_handler_path(tb, r) {
                            break;
                        }
                    }
                    try_contents.push(content.clone());
                }
            }

            if try_contents.is_empty() {
                return false;
            }

            // Create TryCatchRegion
            // JADX Reference: ProcessTryCatchRegions.java:95-97
            let try_region = Region::Sequence(try_contents.clone());
            let handlers: Vec<CatchHandler> = tb.handlers
                .iter()
                .filter(|h| !h.removed)
                .map(|h| CatchHandler {
                    exception_types: h.exception_type.clone().into_iter().collect(),
                    catch_all: h.exception_type.is_none(),
                    region: Box::new(Region::Sequence(vec![RegionContent::Block(h.handler_block)])),
                })
                .collect();

            let try_catch = Region::TryCatch {
                try_region: Box::new(try_region),
                handlers,
                finally: None,
            };

            // Replace first content with TryCatchRegion
            // JADX Reference: ProcessTryCatchRegions.java:100-103
            if let Some(first_idx) = contents.iter().position(|c| {
                try_contents.first().map(|tc| std::ptr::eq(c, tc)).unwrap_or(false)
            }) {
                // Remove try_contents from contents
                contents.retain(|c| !try_contents.iter().any(|tc| content_eq(c, tc)));

                // Insert TryCatchRegion at first_idx
                contents.insert(first_idx, RegionContent::Region(Box::new(try_catch)));
                return true;
            }

            false
        }
        _ => false,
    }
}

/// Check if content has path through dominator block.
fn has_path_through_content<F>(dominator: u32, content: &RegionContent, has_path: F) -> bool
where
    F: Fn(u32, &Region) -> bool,
{
    match content {
        RegionContent::Block(b) => *b == dominator,
        RegionContent::Region(r) => has_path(dominator, r),
    }
}

/// Check if two RegionContent are equal (by content, not reference).
fn content_eq(a: &RegionContent, b: &RegionContent) -> bool {
    match (a, b) {
        (RegionContent::Block(a), RegionContent::Block(b)) => a == b,
        _ => false, // Region comparison would need deeper logic
    }
}

#[cfg(test)]
mod tests {
    use super::*;

    #[test]
    fn test_handler_info() {
        let handler = HandlerInfo {
            handler_block: 10,
            exception_type: Some("java/lang/Exception".to_string()),
            removed: false,
        };

        assert_eq!(handler.handler_block, 10);
        assert!(!handler.removed);
    }

    #[test]
    fn test_try_catch_block_info() {
        let mut try_blocks = HashSet::new();
        try_blocks.insert(1);
        try_blocks.insert(2);
        try_blocks.insert(3);

        let info = TryCatchBlockInfo {
            top_splitter: 0,
            try_blocks,
            handlers: vec![
                HandlerInfo {
                    handler_block: 10,
                    exception_type: Some("java/lang/Exception".to_string()),
                    removed: false,
                },
            ],
            outer_try: None,
        };

        assert_eq!(info.top_splitter, 0);
        assert_eq!(info.try_blocks.len(), 3);
        assert_eq!(info.handlers.len(), 1);
    }

    #[test]
    fn test_sort_try_blocks() {
        let mut blocks = vec![
            TryCatchBlockInfo {
                top_splitter: 1,
                try_blocks: HashSet::new(),
                handlers: vec![],
                outer_try: Some(0),
            },
            TryCatchBlockInfo {
                top_splitter: 0,
                try_blocks: HashSet::new(),
                handlers: vec![],
                outer_try: None,
            },
        ];

        sort_try_blocks(&mut blocks);

        // Parent (outer_try: None) should come first
        assert!(blocks[0].outer_try.is_none());
        assert!(blocks[1].outer_try.is_some());
    }

    #[test]
    fn test_region_contains_block() {
        let region = Region::Sequence(vec![
            RegionContent::Block(1),
            RegionContent::Block(2),
            RegionContent::Block(3),
        ]);

        assert!(region_contains_block(&region, 1));
        assert!(region_contains_block(&region, 2));
        assert!(region_contains_block(&region, 3));
        assert!(!region_contains_block(&region, 4));
    }

    #[test]
    fn test_result_default() {
        let result = ProcessTryCatchRegionsResult::default();
        assert_eq!(result.regions_created, 0);
        assert!(result.warnings.is_empty());
    }
}
