//! ZIP archive security limits.

use std::sync::LazyLock;
use crate::env_limit;

/// Maximum ZIP entries (configurable via DEXTERITY_ZIP_MAX_ENTRIES).
/// Default: 100,000. Prevents zip bomb attacks.
pub static ZIP_MAX_ENTRIES: LazyLock<usize> = LazyLock::new(|| {
    env_limit("DEXTERITY_ZIP_MAX_ENTRIES", 100_000)
});

/// Maximum entry size in MB (configurable via DEXTERITY_MAX_ENTRY_SIZE_MB).
/// Default: 100MB. Entries larger than this are skipped.
pub static MAX_ENTRY_SIZE_MB: LazyLock<usize> = LazyLock::new(|| {
    env_limit("DEXTERITY_MAX_ENTRY_SIZE_MB", 100)
});

/// Get max entry size in bytes.
#[inline]
pub fn max_entry_size_bytes() -> usize {
    *MAX_ENTRY_SIZE_MB * 1024 * 1024
}

/// Zip bomb detection factor.
/// If uncompressed_size / compressed_size > this, it's a potential zip bomb.
/// From JADX JadxZipSecurity.
pub const ZIP_BOMB_DETECTION_FACTOR: u64 = 100;

/// Minimum uncompressed size before zip bomb detection kicks in (25MB).
/// Files smaller than this are considered safe.
/// From JADX JadxZipSecurity.
pub const ZIP_BOMB_MIN_UNCOMPRESSED_SIZE: u64 = 25 * 1024 * 1024;

/// Maximum method instruction count (configurable via DEXTERITY_MAX_METHOD_INSNS).
/// Default: 10,000. Methods with more instructions are skipped.
pub static MAX_METHOD_INSNS: LazyLock<usize> = LazyLock::new(|| {
    env_limit("DEXTERITY_MAX_METHOD_INSNS", 10_000)
});

/// Maximum iterations for field extraction.
pub const MAX_EXTRACT_ITERATIONS: usize = 100;

/// Maximum depth for value tracing in field extraction.
pub const MAX_TRACE_DEPTH: usize = 20;
