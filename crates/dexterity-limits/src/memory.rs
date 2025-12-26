//! Memory and buffer limits.
//!
//! All limits can be overridden via environment variables.
//! Example: `DEXTERITY_THREAD_STACK_MB=512 dexterity app.apk`

use std::sync::LazyLock;
use crate::env_limit;

// =============================================================================
// THREAD STACK CONFIGURATION
// =============================================================================

/// Default main thread stack size in MB.
/// Override with DEXTERITY_MAIN_STACK_MB env var.
pub const DEFAULT_MAIN_STACK_MB: usize = 512;

/// Default worker thread stack size in MB.
/// Override with DEXTERITY_THREAD_STACK_MB env var.
/// Note: 512MB handles deeply nested methods in large APKs.
pub const DEFAULT_THREAD_STACK_MB: usize = 512;

/// Runtime-configurable main thread stack size in bytes.
pub static MAIN_STACK_SIZE: LazyLock<usize> = LazyLock::new(|| {
    env_limit("DEXTERITY_MAIN_STACK_MB", DEFAULT_MAIN_STACK_MB) * 1024 * 1024
});

/// Runtime-configurable worker thread stack size in bytes.
pub static THREAD_STACK_SIZE: LazyLock<usize> = LazyLock::new(|| {
    env_limit("DEXTERITY_THREAD_STACK_MB", DEFAULT_THREAD_STACK_MB) * 1024 * 1024
});

/// Get main thread stack size in bytes.
#[inline]
pub fn main_stack_size() -> usize {
    *MAIN_STACK_SIZE
}

/// Get worker thread stack size in bytes.
#[inline]
pub fn thread_stack_size() -> usize {
    *THREAD_STACK_SIZE
}

// =============================================================================
// CODE WRITER LIMITS
// =============================================================================

/// Maximum size for a single string added to SimpleCodeWriter (10MB).
/// Prevents memory exhaustion from huge strings.
pub const CODE_WRITER_STRING_LIMIT: usize = 10_000_000;

/// Maximum total buffer size for SimpleCodeWriter (100MB).
/// Prevents OOM by capping cumulative output size.
pub const CODE_WRITER_BUFFER_LIMIT: usize = 100_000_000;

// =============================================================================
// PROCESS MEMORY LIMITS
// =============================================================================

/// Process memory limit in GB (configurable via DEXTERITY_MEMORY_LIMIT_GB).
/// Default: 32GB. Process is aborted if exceeded.
pub static MEMORY_LIMIT_GB: LazyLock<usize> = LazyLock::new(|| {
    env_limit("DEXTERITY_MEMORY_LIMIT_GB", 32)
});

/// Get memory limit in bytes.
#[inline]
pub fn memory_limit_bytes() -> usize {
    *MEMORY_LIMIT_GB * 1024 * 1024 * 1024
}
