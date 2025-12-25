//! Memory and buffer limits.

use std::sync::LazyLock;
use crate::env_limit;

/// Maximum size for a single string added to SimpleCodeWriter (10MB).
/// Prevents memory exhaustion from huge strings.
pub const CODE_WRITER_STRING_LIMIT: usize = 10_000_000;

/// Maximum total buffer size for SimpleCodeWriter (100MB).
/// Prevents OOM by capping cumulative output size.
pub const CODE_WRITER_BUFFER_LIMIT: usize = 100_000_000;

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

/// Thread stack size in bytes (256MB).
/// Required for deep CFG recursion in decompilation.
pub const THREAD_STACK_SIZE: usize = 256 * 1024 * 1024;
