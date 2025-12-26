//! Depth-First Region Traversal
//!
//! JADX Clone: jadx-core/src/main/java/jadx/core/dex/visitors/regions/DepthRegionTraversal.java
//! Original Author: Skylot
//! Clone Date: Dec 2025
//! Lines: 92
//!
//! Provides utilities for traversing region trees in depth-first order.
//! Used by various region-processing visitors like LoopRegionVisitor, TernaryMod, etc.

use dexterity_ir::regions::{Region, RegionContent};

/// Limit multiplier for iterative traversal to prevent infinite loops
const ITERATIVE_LIMIT_MULTIPLIER: usize = 5;

/// Trait for region visitors that process regions during traversal
///
/// JADX Reference: IRegionVisitor interface
pub trait RegionVisitor {
    /// Called when entering a region. Return true to traverse children, false to skip.
    ///
    /// JADX Reference: enterRegion(MethodNode mth, IRegion region)
    fn enter_region(&mut self, region: &Region) -> bool {
        let _ = region;
        true
    }

    /// Called when leaving a region after processing all children.
    ///
    /// JADX Reference: leaveRegion(MethodNode mth, IRegion region)
    fn leave_region(&mut self, region: &Region) {
        let _ = region;
    }

    /// Process a block (leaf node in region tree).
    ///
    /// JADX Reference: processBlock(MethodNode mth, IBlock container)
    fn process_block(&mut self, block_id: u32) {
        let _ = block_id;
    }
}

/// Trait for iterative region visitors that may require multiple passes
///
/// JADX Reference: IRegionIterativeVisitor interface
pub trait RegionIterativeVisitor {
    /// Visit a region. Return true if changes were made (triggers another pass).
    ///
    /// JADX Reference: visitRegion(MethodNode mth, IRegion region)
    fn visit_region(&mut self, region: &mut Region) -> bool;
}

/// Traverse a region tree in depth-first order.
///
/// JADX Reference: DepthRegionTraversal.traverse()
pub fn traverse<V: RegionVisitor>(region: &Region, visitor: &mut V) {
    traverse_internal(region, visitor);
}

/// Traverse a specific container (region or block).
///
/// JADX Reference: DepthRegionTraversal.traverse(mth, container, visitor)
pub fn traverse_container<V: RegionVisitor>(content: &RegionContent, visitor: &mut V) {
    traverse_container_with_depth(content, visitor, 0);
}

fn traverse_container_with_depth<V: RegionVisitor>(content: &RegionContent, visitor: &mut V, depth: usize) {
    match content {
        RegionContent::Block(block_id) => {
            visitor.process_block(*block_id);
        }
        RegionContent::Region(region) => {
            traverse_internal_with_depth(region, visitor, depth);
        }
    }
}

/// Internal traversal implementation.
///
/// JADX Reference: DepthRegionTraversal.traverseInternal()
fn traverse_internal<V: RegionVisitor>(region: &Region, visitor: &mut V) {
    traverse_internal_with_depth(region, visitor, 0);
}

fn traverse_internal_with_depth<V: RegionVisitor>(region: &Region, visitor: &mut V, depth: usize) {
    // Prevent stack overflow from deeply nested regions
    let max_depth = dexterity_limits::regions::visitor_max_depth();
    if depth > max_depth {
        tracing::error!(
            depth = depth,
            limit = max_depth,
            "LIMIT_EXCEEDED: Region traversal (internal) max depth reached"
        );
        return;
    }

    if visitor.enter_region(region) {
        // Get sub-contents based on region type
        for content in get_region_contents(region) {
            traverse_container_with_depth(&content, visitor, depth + 1);
        }
    }
    visitor.leave_region(region);
}

/// Get the contents of a region for traversal
fn get_region_contents(region: &Region) -> Vec<RegionContent> {
    match region {
        Region::Sequence(contents) => contents.clone(),
        Region::If {
            then_region,
            else_region,
            ..
        } => {
            let mut contents = vec![RegionContent::Region(then_region.clone())];
            if let Some(else_r) = else_region {
                contents.push(RegionContent::Region(else_r.clone()));
            }
            contents
        }
        Region::Loop { body, .. } => {
            vec![RegionContent::Region(body.clone())]
        }
        Region::Switch { cases, .. } => cases
            .iter()
            .map(|c| RegionContent::Region(c.container.clone()))
            .collect(),
        Region::TryCatch {
            try_region,
            handlers,
            finally,
            ..
        } => {
            let mut contents = vec![RegionContent::Region(try_region.clone())];
            for handler in handlers {
                contents.push(RegionContent::Region(handler.region.clone()));
            }
            if let Some(finally_r) = finally {
                contents.push(RegionContent::Region(finally_r.clone()));
            }
            contents
        }
        Region::Synchronized { body, .. } => {
            vec![RegionContent::Region(body.clone())]
        }
        // Leaf regions
        Region::Break { .. }
        | Region::Continue { .. }
        | Region::TernaryAssignment { .. }
        | Region::TernaryReturn { .. } => vec![],
    }
}

/// Traverse iteratively until no more changes are made.
///
/// JADX Reference: DepthRegionTraversal.traverseIterative()
pub fn traverse_iterative<V: RegionIterativeVisitor>(
    region: &mut Region,
    visitor: &mut V,
    block_count: usize,
) -> Result<(), TraversalError> {
    let limit = ITERATIVE_LIMIT_MULTIPLIER * block_count.max(10);
    let mut iterations = 0;

    loop {
        let changed = traverse_iterative_step(region, visitor)?;
        if !changed {
            break;
        }
        iterations += 1;
        if iterations > limit {
            return Err(TraversalError::IterationLimitReached {
                limit,
                iterations,
            });
        }
    }

    Ok(())
}

/// Traverse iteratively including exception handler regions.
///
/// JADX Reference: DepthRegionTraversal.traverseIncludingExcHandlers()
pub fn traverse_including_exc_handlers<V: RegionIterativeVisitor>(
    region: &mut Region,
    exception_handlers: &mut [Region],
    visitor: &mut V,
    block_count: usize,
) -> Result<(), TraversalError> {
    let limit = ITERATIVE_LIMIT_MULTIPLIER * block_count.max(10);
    let mut iterations = 0;

    loop {
        let mut changed = traverse_iterative_step(region, visitor)?;

        if !changed {
            // Check exception handlers
            for handler in exception_handlers.iter_mut() {
                if traverse_iterative_step(handler, visitor)? {
                    changed = true;
                    break;
                }
            }
        }

        if !changed {
            break;
        }

        iterations += 1;
        if iterations > limit {
            return Err(TraversalError::IterationLimitReached {
                limit,
                iterations,
            });
        }
    }

    Ok(())
}

/// Single step of iterative traversal.
///
/// JADX Reference: DepthRegionTraversal.traverseIterativeStepInternal()
fn traverse_iterative_step<V: RegionIterativeVisitor>(
    region: &mut Region,
    visitor: &mut V,
) -> Result<bool, TraversalError> {
    traverse_iterative_step_with_depth(region, visitor, 0)
}

fn traverse_iterative_step_with_depth<V: RegionIterativeVisitor>(
    region: &mut Region,
    visitor: &mut V,
    depth: usize,
) -> Result<bool, TraversalError> {
    // Prevent stack overflow from deeply nested regions
    let max_depth = dexterity_limits::regions::visitor_max_depth();
    if depth > max_depth {
        tracing::error!(
            depth = depth,
            limit = max_depth,
            "LIMIT_EXCEEDED: Region traversal max depth reached"
        );
        return Ok(false);  // Continue traversal without going deeper
    }

    // Visit this region first
    if visitor.visit_region(region) {
        return Ok(true);
    }

    // Recursively visit sub-regions based on region type
    match region {
        Region::Sequence(contents) => {
            for content in contents.iter_mut() {
                if let RegionContent::Region(sub_region) = content {
                    if traverse_iterative_step_with_depth(sub_region, visitor, depth + 1)? {
                        return Ok(true);
                    }
                }
            }
        }
        Region::If {
            then_region,
            else_region,
            ..
        } => {
            if traverse_iterative_step_with_depth(then_region, visitor, depth + 1)? {
                return Ok(true);
            }
            if let Some(else_r) = else_region {
                if traverse_iterative_step_with_depth(else_r, visitor, depth + 1)? {
                    return Ok(true);
                }
            }
        }
        Region::Loop { body, .. } => {
            if traverse_iterative_step_with_depth(body, visitor, depth + 1)? {
                return Ok(true);
            }
        }
        Region::Switch { cases, .. } => {
            for case in cases.iter_mut() {
                if traverse_iterative_step_with_depth(&mut case.container, visitor, depth + 1)? {
                    return Ok(true);
                }
            }
        }
        Region::TryCatch {
            try_region,
            handlers,
            finally,
            ..
        } => {
            if traverse_iterative_step_with_depth(try_region, visitor, depth + 1)? {
                return Ok(true);
            }
            for handler in handlers.iter_mut() {
                if traverse_iterative_step_with_depth(&mut handler.region, visitor, depth + 1)? {
                    return Ok(true);
                }
            }
            if let Some(finally_r) = finally {
                if traverse_iterative_step_with_depth(finally_r, visitor, depth + 1)? {
                    return Ok(true);
                }
            }
        }
        Region::Synchronized { body, .. } => {
            if traverse_iterative_step_with_depth(body, visitor, depth + 1)? {
                return Ok(true);
            }
        }
        // Leaf regions - no sub-regions
        Region::Break { .. }
        | Region::Continue { .. }
        | Region::TernaryAssignment { .. }
        | Region::TernaryReturn { .. } => {}
    }

    Ok(false)
}

/// Error type for traversal operations
#[derive(Debug, Clone)]
pub enum TraversalError {
    /// Iteration limit reached (likely infinite loop in visitor)
    IterationLimitReached { limit: usize, iterations: usize },
    /// Stack overflow during traversal (region tree too deep)
    StackOverflow,
}

impl std::fmt::Display for TraversalError {
    fn fmt(&self, f: &mut std::fmt::Formatter<'_>) -> std::fmt::Result {
        match self {
            TraversalError::IterationLimitReached { limit, iterations } => {
                write!(
                    f,
                    "Iterative traversal limit reached: {} iterations (limit: {})",
                    iterations, limit
                )
            }
            TraversalError::StackOverflow => {
                write!(f, "Stack overflow during region traversal")
            }
        }
    }
}

impl std::error::Error for TraversalError {}

/// Traced region visitor that maintains a stack of parent regions during traversal.
///
/// JADX Clone: jadx-core/src/main/java/jadx/core/dex/visitors/regions/TracedRegionVisitor.java
/// Original Author: Skylot
/// Clone Date: Dec 2025
/// Lines: 32
///
/// This is an abstract base class that automatically tracks the current region path.
/// Implementations can access the current parent region during block processing.
pub struct TracedRegionVisitor<F>
where
    F: FnMut(u32, Option<&Region>),
{
    /// Stack of regions we've entered
    region_stack: Vec<Region>,
    /// Callback for processing blocks with their current region
    process_block_fn: F,
}

impl<F> TracedRegionVisitor<F>
where
    F: FnMut(u32, Option<&Region>),
{
    /// Create a new traced visitor with a block processing function.
    ///
    /// The function receives the block ID and the current parent region (if any).
    pub fn new(process_block_fn: F) -> Self {
        Self {
            region_stack: Vec::new(),
            process_block_fn,
        }
    }

    /// Get the current region (top of stack)
    pub fn current_region(&self) -> Option<&Region> {
        self.region_stack.last()
    }

    /// Get the region stack depth
    pub fn depth(&self) -> usize {
        self.region_stack.len()
    }
}

impl<F> RegionVisitor for TracedRegionVisitor<F>
where
    F: FnMut(u32, Option<&Region>),
{
    fn enter_region(&mut self, region: &Region) -> bool {
        self.region_stack.push(region.clone());
        true
    }

    fn leave_region(&mut self, _region: &Region) {
        self.region_stack.pop();
    }

    fn process_block(&mut self, block_id: u32) {
        let current = self.region_stack.last();
        (self.process_block_fn)(block_id, current);
    }
}

/// Traverse a region tree with traced context.
///
/// The callback receives each block ID along with its parent region.
///
/// JADX Reference: TracedRegionVisitor.processBlockTraced()
pub fn traverse_traced<F>(region: &Region, mut process_block_fn: F)
where
    F: FnMut(u32, Option<&Region>),
{
    let mut visitor = TracedRegionVisitor::new(|block_id, current_region| {
        process_block_fn(block_id, current_region);
    });
    traverse(region, &mut visitor);
}

#[cfg(test)]
mod tests {
    use super::*;

    struct CountingVisitor {
        regions_entered: usize,
        regions_left: usize,
        blocks_visited: usize,
    }

    impl RegionVisitor for CountingVisitor {
        fn enter_region(&mut self, _region: &Region) -> bool {
            self.regions_entered += 1;
            true
        }

        fn leave_region(&mut self, _region: &Region) {
            self.regions_left += 1;
        }

        fn process_block(&mut self, _block_id: u32) {
            self.blocks_visited += 1;
        }
    }

    #[test]
    fn test_basic_traversal() {
        let mut visitor = CountingVisitor {
            regions_entered: 0,
            regions_left: 0,
            blocks_visited: 0,
        };

        // Create a simple sequence region with one block
        let region = Region::Sequence(vec![RegionContent::Block(1)]);

        traverse(&region, &mut visitor);

        assert_eq!(visitor.regions_entered, 1);
        assert_eq!(visitor.regions_left, 1);
        assert_eq!(visitor.blocks_visited, 1);
    }

    #[test]
    fn test_nested_traversal() {
        let mut visitor = CountingVisitor {
            regions_entered: 0,
            regions_left: 0,
            blocks_visited: 0,
        };

        // Create nested regions
        let inner = Region::Sequence(vec![RegionContent::Block(2)]);
        let outer = Region::Sequence(vec![
            RegionContent::Block(1),
            RegionContent::Region(Box::new(inner)),
            RegionContent::Block(3),
        ]);

        traverse(&outer, &mut visitor);

        assert_eq!(visitor.regions_entered, 2);
        assert_eq!(visitor.regions_left, 2);
        assert_eq!(visitor.blocks_visited, 3);
    }

    struct IterativeCountingVisitor {
        visits: usize,
        max_visits: usize,
    }

    impl RegionIterativeVisitor for IterativeCountingVisitor {
        fn visit_region(&mut self, _region: &mut Region) -> bool {
            self.visits += 1;
            self.visits < self.max_visits
        }
    }

    #[test]
    fn test_iterative_traversal() {
        let mut visitor = IterativeCountingVisitor {
            visits: 0,
            max_visits: 3,
        };

        let mut region = Region::Sequence(vec![RegionContent::Block(1)]);

        let result = traverse_iterative(&mut region, &mut visitor, 10);

        assert!(result.is_ok());
        assert_eq!(visitor.visits, 3);
    }

    #[test]
    fn test_iteration_limit() {
        struct InfiniteVisitor;

        impl RegionIterativeVisitor for InfiniteVisitor {
            fn visit_region(&mut self, _region: &mut Region) -> bool {
                true // Always return true = infinite loop
            }
        }

        let mut visitor = InfiniteVisitor;
        let mut region = Region::Sequence(vec![RegionContent::Block(1)]);

        let result = traverse_iterative(&mut region, &mut visitor, 10);

        assert!(matches!(
            result,
            Err(TraversalError::IterationLimitReached { .. })
        ));
    }
}
