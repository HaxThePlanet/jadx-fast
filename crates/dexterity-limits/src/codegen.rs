//! Code generation limits.

/// Maximum depth for inline expression expansion.
/// Prevents stack overflow when expressions are deeply nested.
pub const INLINE_DEPTH_LIMIT: usize = 100;

/// Maximum depth for codegen recursion tracking.
/// Used by DepthGuard RAII pattern to track call depth.
pub const CODEGEN_RECURSION_LIMIT: usize = 50;

/// Maximum depth for region nesting in code generation.
/// Prevents infinite recursion in complex control flow structures.
/// Very conservative limit - bail out early to leave headroom for stack unwinding.
pub const MAX_REGION_DEPTH: usize = 20;

/// Maximum depth for condition expression generation (AND/OR/NOT trees).
/// Prevents stack overflow on deeply nested boolean conditions.
pub const MAX_CONDITION_DEPTH: usize = 20;

/// Maximum number of merges for conditional statements.
/// Prevents runaway merging in nested conditionals.
pub const MAX_CONDITIONAL_MERGES: usize = 100;

/// Maximum capacity before HashMap pools are dropped and recreated.
/// Prevents memory explosion from large methods polluting the pool.
pub const MAX_POOLED_CAPACITY: usize = 1_000;
