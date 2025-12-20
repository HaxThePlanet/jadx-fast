//! Library fingerprinting for APK decompilation caching
//!
//! This crate provides fingerprinting capabilities for DEX classes and methods.
//! Fingerprints are designed to remain stable across obfuscation (ProGuard/R8)
//! by hashing structural properties that cannot be changed without breaking functionality:
//!
//! - Opcode sequences (actual bytecode instructions)
//! - Method signatures (parameter types, return types)
//! - Structural metadata (register counts, instruction counts)
//! - Class hierarchy (superclass, interfaces)
//!
//! # Example
//!
//! ```ignore
//! use dexterity_fingerprint::{fingerprint_class, fingerprint_method};
//! use dexterity_dex::DexReader;
//!
//! let dex = DexReader::from_file("classes.dex")?;
//! for class in dex.class_defs() {
//!     let fp = fingerprint_class(&class, &dex)?;
//!     println!("Class fingerprint: {:016x}", fp.combined_hash());
//! }
//! ```

pub mod cache;
pub mod class;
pub mod method;

pub use cache::{denormalize_code, normalize_code, FingerprintCache};
pub use class::{extract_name_mapping, fingerprint_class, ClassFingerprint, ClassNameMapping};
pub use method::{fingerprint_method, MethodFingerprint};

use std::hash::{Hash, Hasher};
use rustc_hash::FxHasher;

/// Fast 64-bit hash using FxHasher (same as rustc uses)
#[inline]
pub fn fx_hash<T: Hash>(value: &T) -> u64 {
    let mut hasher = FxHasher::default();
    value.hash(&mut hasher);
    hasher.finish()
}

/// Combine multiple hashes into one
#[inline]
pub fn combine_hashes(hashes: &[u64]) -> u64 {
    let mut combined = 0u64;
    for (i, &h) in hashes.iter().enumerate() {
        // Rotate and XOR to preserve information from all inputs
        combined ^= h.rotate_left((i as u32 * 7) % 64);
    }
    combined
}

#[cfg(test)]
mod tests {
    use super::*;

    #[test]
    fn test_combine_hashes_order_matters() {
        let a = combine_hashes(&[1, 2, 3]);
        let b = combine_hashes(&[3, 2, 1]);
        assert_ne!(a, b, "Order should affect combined hash");
    }

    #[test]
    fn test_combine_hashes_empty() {
        let h = combine_hashes(&[]);
        assert_eq!(h, 0);
    }
}
