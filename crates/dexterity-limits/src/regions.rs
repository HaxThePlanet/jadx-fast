//! Region processing limits.

/// Maximum region stack size.
/// Prevents unbounded growth of region nesting stack.
/// Very conservative limit - bail out early to leave headroom for stack unwinding.
pub const REGION_STACK_LIMIT: usize = 20;

/// Maximum number of contents in a region.
/// Prevents runaway region content accumulation.
pub const REGION_CONTENTS_LIMIT: usize = 100_000;

/// Multiplier for regions count limit (block_count * this value).
/// Prevents excessive region creation relative to basic blocks.
pub const REGIONS_COUNT_MULTIPLIER: usize = 100;

/// Multiplier for iteration budget (block_count * this value).
/// Limits iterations during region construction.
pub const ITERATION_BUDGET_MULTIPLIER: usize = 20;

/// Maximum depth for if-region visitor traversal.
pub const IF_REGION_MAX_DEPTH: usize = 100;

/// Maximum depth for region block counting and jump analysis.
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
