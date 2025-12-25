//! Code generation limits.
//!
//! All limits can be overridden via environment variables.
//! Example: `DEXTERITY_CODEGEN_MAX_DEPTH=50 dexterity app.apk`

use crate::env_limit;
use std::sync::LazyLock;

// =============================================================================
// CODEGEN DEPTH LIMITS - Controls stack overflow protection in code generation
// =============================================================================

/// Default maximum depth for codegen region recursion.
/// Override with DEXTERITY_CODEGEN_MAX_DEPTH env var.
pub const DEFAULT_MAX_REGION_DEPTH: usize = 20;

/// Runtime-configurable codegen max depth.
/// Used by: generate_region, generate_else_chain, case_ends_with_exit_depth.
pub static MAX_REGION_DEPTH: LazyLock<usize> = LazyLock::new(|| {
    env_limit("DEXTERITY_CODEGEN_MAX_DEPTH", DEFAULT_MAX_REGION_DEPTH)
});

/// Get the current codegen max depth limit.
#[inline]
pub fn max_region_depth() -> usize {
    *MAX_REGION_DEPTH
}

/// Default maximum depth for condition expression generation.
/// Override with DEXTERITY_CONDITION_MAX_DEPTH env var.
pub const DEFAULT_MAX_CONDITION_DEPTH: usize = 20;

/// Runtime-configurable condition max depth.
pub static MAX_CONDITION_DEPTH: LazyLock<usize> = LazyLock::new(|| {
    env_limit("DEXTERITY_CONDITION_MAX_DEPTH", DEFAULT_MAX_CONDITION_DEPTH)
});

#[inline]
pub fn max_condition_depth() -> usize {
    *MAX_CONDITION_DEPTH
}

// =============================================================================
// OTHER CODEGEN LIMITS
// =============================================================================

/// Maximum depth for inline expression expansion.
/// Prevents stack overflow when expressions are deeply nested.
pub const INLINE_DEPTH_LIMIT: usize = 100;

/// Maximum depth for codegen recursion tracking.
/// Used by DepthGuard RAII pattern to track call depth.
pub const CODEGEN_RECURSION_LIMIT: usize = 50;

/// Maximum number of merges for conditional statements.
/// Prevents runaway merging in nested conditionals.
pub const MAX_CONDITIONAL_MERGES: usize = 100;

/// Maximum capacity before HashMap pools are dropped and recreated.
/// Prevents memory explosion from large methods polluting the pool.
pub const MAX_POOLED_CAPACITY: usize = 1_000;
