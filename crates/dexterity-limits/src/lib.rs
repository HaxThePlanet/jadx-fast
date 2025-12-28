//! Centralized limits and safety guards for Dexterity decompiler.
//!
//! This crate provides all limits used throughout the decompiler to prevent
//! unbounded resource consumption. Every limit hit MUST be logged.
//!
//! # Usage
//!
//! ```rust,ignore
//! use dexterity_limits::{limit_exceeded, codegen::INLINE_DEPTH_LIMIT};
//!
//! if depth >= INLINE_DEPTH_LIMIT {
//!     limit_exceeded!("INLINE_DEPTH", INLINE_DEPTH_LIMIT, depth);
//!     return fallback_value;
//! }
//! ```

pub mod codegen;
pub mod memory;
pub mod regions;
pub mod ssa;
pub mod type_system;
pub mod zip;

/// Log when a limit is hit. EVERY limit hit MUST use this macro.
/// Uses error! level because limit hits indicate potential problems.
///
/// # Arguments
/// * `$limit_name` - Human-readable name of the limit
/// * `$limit_value` - The limit value that was exceeded
/// * `$actual` - The actual value that exceeded the limit
/// * `$extra` - Optional additional fields for structured logging
///
/// # Example
/// ```rust
/// use dexterity_limits::limit_exceeded;
///
/// let depth = 101;
/// let limit = 100;
/// limit_exceeded!("INLINE_DEPTH", limit, depth);
/// // Logs: LIMIT_EXCEEDED: INLINE_DEPTH limit reached (101 >= 100)
/// ```
#[macro_export]
macro_rules! limit_exceeded {
    ($limit_name:expr, $limit_value:expr, $actual:expr) => {
        tracing::error!(
            limit_name = $limit_name,
            limit_value = $limit_value,
            actual_value = $actual,
            "LIMIT_EXCEEDED: {} limit reached ({} >= {})",
            $limit_name,
            $actual,
            $limit_value
        );
    };
    ($limit_name:expr, $limit_value:expr, $actual:expr, $($extra:tt)+) => {
        tracing::error!(
            limit_name = $limit_name,
            limit_value = $limit_value,
            actual_value = $actual,
            $($extra)+,
            "LIMIT_EXCEEDED: {} limit reached ({} >= {})",
            $limit_name,
            $actual,
            $limit_value
        );
    };
}

/// Helper to get an env var as usize with a default value
#[inline]
pub fn env_limit(var_name: &str, default: usize) -> usize {
    std::env::var(var_name)
        .ok()
        .and_then(|v| v.parse().ok())
        .unwrap_or(default)
}

/// Helper to get an env var as u64 with a default value
#[inline]
pub fn env_limit_u64(var_name: &str, default: u64) -> u64 {
    std::env::var(var_name)
        .ok()
        .and_then(|v| v.parse().ok())
        .unwrap_or(default)
}
