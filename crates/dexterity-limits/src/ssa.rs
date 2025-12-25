//! SSA and phi node limits.

/// Multiplier for dominator tree computation (block_count * this + 1000).
pub const DOMINATOR_ITERATIONS_MULTIPLIER: usize = 10;

/// Base iterations added to dominator limit.
pub const DOMINATOR_ITERATIONS_BASE: usize = 1000;

/// Multiplier for phi node fix iterations (block_count * this + 100).
pub const PHI_FIX_MULTIPLIER: usize = 2;

/// Base iterations added to phi fix limit.
pub const PHI_FIX_BASE: usize = 100;

/// Multiplier for live variable analysis iterations (block_count * this).
/// From JADX LiveVarAnalysis.
pub const LIVE_VAR_ITERATIONS_MULTIPLIER: usize = 10;

/// Multiplier for SSA optimization iterations (block_count * this).
pub const SSA_OPTIMIZATION_MULTIPLIER: usize = 5;
