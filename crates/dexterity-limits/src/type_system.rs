//! Type inference limits.

/// Maximum number of type variables to process.
/// Prevents runaway type inference on extremely complex methods.
pub const VARS_PROCESS_LIMIT: usize = 5_000;

/// Maximum iterations for type search algorithm.
/// Prevents infinite loops in constraint solving.
pub const SEARCH_ITERATION_LIMIT: usize = 1_000_000;

/// Maximum number of type candidates per variable.
/// Limits candidate explosion during type search.
pub const CANDIDATES_COUNT_LIMIT: usize = 10;

/// Multiplier for type updates limit (insn_count * this).
/// From JADX TypeUpdateInfo.
pub const TYPE_UPDATES_LIMIT_MULTIPLIER: usize = 10;
