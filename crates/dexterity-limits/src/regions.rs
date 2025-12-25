//! Region processing limits.
//!
//! All limits can be overridden via environment variables.
//! Example: `DEXTERITY_VISITOR_MAX_DEPTH=200 dexterity app.apk`

use crate::env_limit;
use std::sync::LazyLock;

// =============================================================================
// VISITOR DEPTH LIMITS - Controls stack overflow protection
// =============================================================================

/// Default maximum depth for all visitor traversals.
/// Override with DEXTERITY_VISITOR_MAX_DEPTH env var.
pub const DEFAULT_VISITOR_MAX_DEPTH: usize = 100;

/// Runtime-configurable visitor max depth.
/// Used by: depth_region_traversal, if_region_visitor, return_visitor,
/// dot_graph_visitor, post_process_regions, process_region_for_inlining.
pub static VISITOR_MAX_DEPTH: LazyLock<usize> = LazyLock::new(|| {
    env_limit("DEXTERITY_VISITOR_MAX_DEPTH", DEFAULT_VISITOR_MAX_DEPTH)
});

/// Get the current visitor max depth limit.
#[inline]
pub fn visitor_max_depth() -> usize {
    *VISITOR_MAX_DEPTH
}

// =============================================================================
// REGION STACK LIMITS
// =============================================================================

/// Maximum region stack size.
/// Prevents unbounded growth of region nesting stack.
/// Very conservative limit - bail out early to leave headroom for stack unwinding.
/// Override with DEXTERITY_REGION_STACK_LIMIT env var.
pub const DEFAULT_REGION_STACK_LIMIT: usize = 20;

pub static REGION_STACK_LIMIT: LazyLock<usize> = LazyLock::new(|| {
    env_limit("DEXTERITY_REGION_STACK_LIMIT", DEFAULT_REGION_STACK_LIMIT)
});

#[inline]
pub fn region_stack_limit() -> usize {
    *REGION_STACK_LIMIT
}

// =============================================================================
// REGION CONTENT LIMITS
// =============================================================================

/// Maximum number of contents in a region.
/// Prevents runaway region content accumulation.
pub const REGION_CONTENTS_LIMIT: usize = 100_000;

/// Multiplier for regions count limit (block_count * this value).
/// Prevents excessive region creation relative to basic blocks.
pub const REGIONS_COUNT_MULTIPLIER: usize = 100;

/// Multiplier for iteration budget (block_count * this value).
/// Limits iterations during region construction.
pub const ITERATION_BUDGET_MULTIPLIER: usize = 20;

// =============================================================================
// LEGACY CONSTANTS (for backwards compatibility)
// =============================================================================

/// Maximum depth for if-region visitor traversal.
/// DEPRECATED: Use visitor_max_depth() instead.
pub const IF_REGION_MAX_DEPTH: usize = 100;

/// Maximum depth for region block counting and jump analysis.
/// DEPRECATED: Use visitor_max_depth() instead.
pub const REGION_TRAVERSAL_MAX_DEPTH: usize = 100;

/// Maximum iterations for switch break analysis.
pub const SWITCH_BREAK_MAX_ITERATIONS: usize = 100;

/// Maximum iterations for array replacement optimization.
pub const REPLACE_ARRAY_MAX_ITERATIONS: usize = 100;

/// Multiplier for try blocks wrapping queue (try_blocks * this value).
pub const TRY_BLOCKS_WRAPPING_MULTIPLIER: usize = 3;

/// Multiplier for iterative traversal limit (block_count * this value).
/// From JADX DepthRegionTraversal.
pub const ITERATIVE_TRAVERSAL_MULTIPLIER: usize = 5;
