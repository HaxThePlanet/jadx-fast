//! Fingerprint cache for storing and retrieving cached decompilation results
//!
//! The cache stores decompiled Java source code keyed by class fingerprint.
//! When the same class (by structure) is seen in another APK, the cached
//! decompilation is returned instead of re-decompiling.
//!
//! ## Normalization
//!
//! The cache uses **normalized code** to handle obfuscation differences.
//! Different obfuscation runs produce different names for identical bytecode:
//! - APK v1: `class a { void c0() {...} }`
//! - APK v2: `class a { void a0() {...} }`  (same bytecode, different names)
//!
//! On STORE: Names are replaced with placeholders (`$$__CLASS__$$`, `$$__M0__$$`)
//! On RETRIEVE: Placeholders are replaced with the NEW class's actual names

use crate::class::ClassNameMapping;
use crate::ClassFingerprint;
use parking_lot::RwLock;
use rustc_hash::FxHashMap;
use serde::{Deserialize, Serialize};
use std::collections::VecDeque;
use std::path::{Path, PathBuf};
use std::sync::atomic::{AtomicU64, Ordering};

/// Cache entry for a decompiled class
#[derive(Debug, Clone, Serialize, Deserialize)]
pub struct CacheEntry {
    /// Combined fingerprint hash for quick lookup
    pub hash: u64,
    /// Normalized Java source code with placeholder names
    /// Class name replaced with $$__CLASS__$$
    /// Method names replaced with $$__M0__$$, $$__M1__$$, etc.
    /// Field names replaced with $$__F0__$$, $$__F1__$$, etc.
    pub normalized_code: String,
    /// Size in bytes of the normalized_code
    pub size_bytes: usize,
    /// Hash of the source APK path (for cross-APK safety)
    /// Cache hits only allowed from DIFFERENT APKs to avoid type reference issues
    pub source_apk_hash: u64,
}

/// Normalize decompiled code by replacing names with placeholders
///
/// This allows the same cached code to be used across APKs with
/// different obfuscation, by re-injecting the correct names on retrieval.
///
/// Returns the original code unchanged if normalization would be ambiguous
/// or unsafe (e.g., class name = method name, or generic type parameters).
pub fn normalize_code(code: &str, mapping: &ClassNameMapping) -> String {
    // SAFETY CHECK 1: Skip classes with generic type parameters
    // Generics like <T>, <K, V> have type-parameter names that we don't track
    // and can't safely substitute (e.g., "T t" vs "O o")
    if code.contains("<T>") || code.contains("<T,") || code.contains("<K,") ||
       code.contains("<E>") || code.contains("<V>") || code.contains("<R>") ||
       code.contains("<T extends") || code.contains("<? extends") {
        return code.to_string();
    }

    // SAFETY CHECK 2: Skip normalization if names would collide
    // When class name = method name, we can't distinguish them in text replacement
    // (e.g., "interface a { void a(); }" - both "a" look the same)
    for method_name in &mapping.method_names {
        if method_name == &mapping.class_name {
            // Can't normalize - return original code
            // This class won't benefit from caching but won't produce wrong output
            return code.to_string();
        }
    }
    for field_name in &mapping.field_names {
        if field_name == &mapping.class_name {
            return code.to_string();
        }
    }

    let mut result = code.to_string();

    // Replace package declaration first (most specific context)
    // "package com.example.foo;" -> "package $$__PKG__$$;"
    if !mapping.package_name.is_empty() {
        let pkg_pattern = format!("package {};", mapping.package_name);
        let pkg_replacement = "package $$__PKG__$$;";
        result = result.replace(&pkg_pattern, pkg_replacement);
    }

    // Replace method names (before class name)
    // Replace in reverse order (highest index first) to prevent partial matches
    for (i, method_name) in mapping.method_names.iter().enumerate().rev() {
        if !method_name.is_empty() && !is_special_method(method_name) {
            let placeholder = format!("$$__M{}__$$", i);
            result = replace_identifier(&result, method_name, &placeholder);
        }
    }

    // Replace field names (before class name)
    for (i, field_name) in mapping.field_names.iter().enumerate().rev() {
        if !field_name.is_empty() {
            let placeholder = format!("$$__F{}__$$", i);
            result = replace_identifier(&result, field_name, &placeholder);
        }
    }

    // Replace class name LAST
    if !mapping.class_name.is_empty() {
        result = replace_identifier(&result, &mapping.class_name, "$$__CLASS__$$");
    }

    result
}

/// Denormalize cached code by replacing placeholders with actual names
///
/// Uses the NEW class's name mapping to inject the correct names
/// for the current APK being decompiled.
///
/// Returns None if the cached code has placeholders that don't match
/// the provided mapping (safety check to avoid returning wrong code).
pub fn denormalize_code(normalized: &str, mapping: &ClassNameMapping) -> Option<String> {
    let mut result = normalized.to_string();

    // Replace package placeholder
    if !mapping.package_name.is_empty() {
        let pkg_replacement = format!("package {};", mapping.package_name);
        result = result.replace("package $$__PKG__$$;", &pkg_replacement);
    }

    // Replace class placeholder
    result = result.replace("$$__CLASS__$$", &mapping.class_name);

    // Replace method placeholders
    for (i, method_name) in mapping.method_names.iter().enumerate() {
        let placeholder = format!("$$__M{}__$$", i);
        result = result.replace(&placeholder, method_name);
    }

    // Replace field placeholders
    for (i, field_name) in mapping.field_names.iter().enumerate() {
        let placeholder = format!("$$__F{}__$$", i);
        result = result.replace(&placeholder, field_name);
    }

    // SAFETY CHECK: Ensure no unreplaced placeholders remain
    // This catches mismatches where cached code expects more names than we have
    if result.contains("$$__M") || result.contains("$$__F") ||
       result.contains("$$__CLASS__$$") || result.contains("$$__PKG__$$") {
        tracing::warn!(
            "Cache safety check failed: unreplaced placeholders in cached code for {}",
            mapping.class_name
        );
        return None;
    }

    Some(result)
}

/// Replace an identifier in code, respecting word boundaries
/// Ensures we don't replace partial matches (e.g., "a" in "getData")
fn replace_identifier(code: &str, old_name: &str, new_name: &str) -> String {
    // For single-character names, we need exact matching
    // For multi-character names, simple replace is usually safe for obfuscated code
    if old_name.len() <= 2 {
        // Use word boundary matching for short identifiers
        replace_word_boundary(code, old_name, new_name)
    } else {
        code.replace(old_name, new_name)
    }
}

/// Replace identifier with word boundary checking
fn replace_word_boundary(code: &str, old_name: &str, new_name: &str) -> String {
    let mut result = String::with_capacity(code.len() + 100);
    let chars: Vec<char> = code.chars().collect();
    let old_chars: Vec<char> = old_name.chars().collect();
    let mut i = 0;

    while i < chars.len() {
        // Check if we have a potential match
        if i + old_chars.len() <= chars.len() {
            let mut matches = true;
            for (j, &old_c) in old_chars.iter().enumerate() {
                if chars[i + j] != old_c {
                    matches = false;
                    break;
                }
            }

            if matches {
                // Check word boundaries
                let before_ok = i == 0 || !is_identifier_char(chars[i - 1]);
                let after_ok = i + old_chars.len() >= chars.len()
                    || !is_identifier_char(chars[i + old_chars.len()]);

                if before_ok && after_ok {
                    result.push_str(new_name);
                    i += old_chars.len();
                    continue;
                }
            }
        }

        result.push(chars[i]);
        i += 1;
    }

    result
}

/// Check if character can be part of a Java identifier
#[inline]
fn is_identifier_char(c: char) -> bool {
    c.is_alphanumeric() || c == '_' || c == '$'
}

/// Check if method name is a special method that shouldn't be replaced
#[inline]
fn is_special_method(name: &str) -> bool {
    matches!(name,
        "<init>" | "<clinit>" |
        "toString" | "hashCode" | "equals" | "clone" | "finalize" |
        "onCreate" | "onStart" | "onResume" | "onPause" | "onStop" | "onDestroy" |
        "onCreateView" | "onViewCreated" | "onActivityCreated" |
        "onSaveInstanceState" | "onRestoreInstanceState" |
        "onClick" | "onTouch" | "onLongClick" |
        "run" | "call" | "apply" | "accept" | "get" | "test" |
        "compare" | "compareTo" | "iterator" | "hasNext" | "next" |
        "onBind" | "onUnbind" | "onRebind" | "onTransact" |
        "asBinder" | "getInterfaceDescriptor" |
        "writeToParcel" | "describeContents" | "createFromParcel" | "newArray"
    )
}

/// Statistics for the fingerprint cache
#[derive(Debug, Default, Clone)]
pub struct CacheStats {
    /// Total number of cache lookups
    pub lookups: u64,
    /// Number of cache hits
    pub hits: u64,
    /// Number of cache misses
    pub misses: u64,
    /// Number of entries in cache
    pub entries: u64,
    /// Current cache size in bytes
    pub size_bytes: u64,
    /// Maximum cache size in bytes
    pub max_size_bytes: u64,
}

impl CacheStats {
    /// Calculate hit rate as a percentage
    pub fn hit_rate(&self) -> f64 {
        if self.lookups == 0 {
            0.0
        } else {
            (self.hits as f64 / self.lookups as f64) * 100.0
        }
    }
}

/// High-performance fingerprint cache with size limits
///
/// Uses in-memory storage with LRU eviction when max size is reached.
/// Optionally persists to disk for cross-session caching.
pub struct FingerprintCache {
    /// In-memory cache: hash -> entry
    entries: RwLock<FxHashMap<u64, CacheEntry>>,
    /// LRU order tracking (front = oldest, back = newest)
    lru_order: RwLock<VecDeque<u64>>,
    /// Current cache size in bytes
    current_size: AtomicU64,
    /// Maximum cache size in bytes
    max_size_bytes: u64,
    /// Cache directory for persistence
    cache_dir: Option<PathBuf>,
    /// Statistics
    lookups: AtomicU64,
    hits: AtomicU64,
    misses: AtomicU64,
}

impl FingerprintCache {
    /// Create a new in-memory cache with default 50GB limit
    pub fn new() -> Self {
        Self::with_max_size_gb(50)
    }

    /// Create a cache with specified max size in GB
    pub fn with_max_size_gb(max_gb: u64) -> Self {
        Self {
            entries: RwLock::new(FxHashMap::default()),
            lru_order: RwLock::new(VecDeque::new()),
            current_size: AtomicU64::new(0),
            max_size_bytes: max_gb * 1024 * 1024 * 1024,
            cache_dir: None,
            lookups: AtomicU64::new(0),
            hits: AtomicU64::new(0),
            misses: AtomicU64::new(0),
        }
    }

    /// Create a cache with disk persistence
    pub fn with_disk_cache<P: AsRef<Path>>(cache_dir: P, max_gb: u64) -> std::io::Result<Self> {
        let cache_dir = cache_dir.as_ref().to_path_buf();
        std::fs::create_dir_all(&cache_dir)?;

        let mut cache = Self::with_max_size_gb(max_gb);
        cache.cache_dir = Some(cache_dir.clone());

        // Try to load existing cache
        if let Err(e) = cache.load_from_disk() {
            tracing::debug!("Could not load fingerprint cache from disk: {}", e);
        }

        Ok(cache)
    }

    /// Look up cached decompilation by fingerprint
    /// Returns the **normalized** Java source if found, but ONLY from a different APK
    ///
    /// # Safety
    ///
    /// Cross-APK caching is safe because classes with identical structure
    /// in different APKs are likely the same library code with different obfuscation.
    /// Within-APK caching is UNSAFE because classes with same structure may have
    /// different type references (e.g., class `a.b` vs `c.d` with same bytecode).
    ///
    /// # Arguments
    /// * `fingerprint` - The class fingerprint to look up
    /// * `current_apk_hash` - Hash of the current APK path (lookups from same APK are rejected)
    pub fn lookup(&self, fingerprint: &ClassFingerprint, current_apk_hash: u64) -> Option<String> {
        let hash = fingerprint.combined_hash();
        self.lookups.fetch_add(1, Ordering::Relaxed);

        let entries = self.entries.read();
        if let Some(entry) = entries.get(&hash) {
            // SAFETY CHECK: Only return hit if from a DIFFERENT APK
            if entry.source_apk_hash == current_apk_hash {
                // Same APK - not safe to use cached code (type reference issues)
                self.misses.fetch_add(1, Ordering::Relaxed);
                return None;
            }

            self.hits.fetch_add(1, Ordering::Relaxed);

            // Update LRU (move to back)
            drop(entries);
            self.touch_lru(hash);

            let entries = self.entries.read();
            return entries.get(&hash).map(|e| e.normalized_code.clone());
        }

        self.misses.fetch_add(1, Ordering::Relaxed);
        None
    }

    /// Store decompiled class in cache
    /// Takes **normalized** code with placeholder names
    ///
    /// # Arguments
    /// * `fingerprint` - The class fingerprint
    /// * `normalized_code` - Java source with placeholder names
    /// * `source_apk_hash` - Hash of the APK this class came from (for cross-APK safety)
    pub fn store(&self, fingerprint: ClassFingerprint, normalized_code: String, source_apk_hash: u64) {
        let hash = fingerprint.combined_hash();
        let size_bytes = normalized_code.len();

        // Evict if necessary
        self.evict_if_needed(size_bytes);

        let entry = CacheEntry {
            hash,
            normalized_code,
            size_bytes,
            source_apk_hash,
        };

        let mut entries = self.entries.write();

        // If updating existing entry, adjust size
        if let Some(old) = entries.get(&hash) {
            self.current_size.fetch_sub(old.size_bytes as u64, Ordering::Relaxed);
        }

        entries.insert(hash, entry);
        self.current_size.fetch_add(size_bytes as u64, Ordering::Relaxed);

        drop(entries);

        // Add to LRU
        let mut lru = self.lru_order.write();
        // Remove if already present
        lru.retain(|&h| h != hash);
        lru.push_back(hash);
    }

    /// Move hash to back of LRU (most recently used)
    fn touch_lru(&self, hash: u64) {
        let mut lru = self.lru_order.write();
        // Remove from current position
        lru.retain(|&h| h != hash);
        // Add to back
        lru.push_back(hash);
    }

    /// Evict oldest entries until we have room for new_size bytes
    fn evict_if_needed(&self, new_size: usize) {
        let max = self.max_size_bytes;
        let current = self.current_size.load(Ordering::Relaxed);

        if current + new_size as u64 <= max {
            return;
        }

        // Need to evict
        let target = max.saturating_sub(new_size as u64);
        let mut to_evict = Vec::new();

        {
            let lru = self.lru_order.read();
            let entries = self.entries.read();
            let mut running_size = current;

            for &hash in lru.iter() {
                if running_size <= target {
                    break;
                }
                if let Some(entry) = entries.get(&hash) {
                    running_size = running_size.saturating_sub(entry.size_bytes as u64);
                    to_evict.push(hash);
                }
            }
        }

        // Actually evict
        if !to_evict.is_empty() {
            let mut entries = self.entries.write();
            let mut lru = self.lru_order.write();

            for hash in to_evict {
                if let Some(entry) = entries.remove(&hash) {
                    self.current_size.fetch_sub(entry.size_bytes as u64, Ordering::Relaxed);
                }
                lru.retain(|&h| h != hash);
            }
        }
    }

    /// Get cache statistics
    pub fn stats(&self) -> CacheStats {
        CacheStats {
            lookups: self.lookups.load(Ordering::Relaxed),
            hits: self.hits.load(Ordering::Relaxed),
            misses: self.misses.load(Ordering::Relaxed),
            entries: self.entries.read().len() as u64,
            size_bytes: self.current_size.load(Ordering::Relaxed),
            max_size_bytes: self.max_size_bytes,
        }
    }

    /// Get number of entries in cache
    pub fn len(&self) -> usize {
        self.entries.read().len()
    }

    /// Check if cache is empty
    pub fn is_empty(&self) -> bool {
        self.len() == 0
    }

    /// Get current cache size in bytes
    pub fn size_bytes(&self) -> u64 {
        self.current_size.load(Ordering::Relaxed)
    }

    /// Get current cache size in MB
    pub fn size_mb(&self) -> f64 {
        self.size_bytes() as f64 / (1024.0 * 1024.0)
    }

    /// Clear all entries
    pub fn clear(&self) {
        let mut entries = self.entries.write();
        let mut lru = self.lru_order.write();
        entries.clear();
        lru.clear();
        self.current_size.store(0, Ordering::Relaxed);
    }

    /// Save cache to disk (binary format for speed)
    pub fn save_to_disk(&self) -> std::io::Result<()> {
        let cache_dir = match &self.cache_dir {
            Some(dir) => dir,
            None => return Ok(()),
        };

        let entries = self.entries.read();

        // Save as JSON (could use bincode for speed)
        let cache_file = cache_dir.join("fingerprint_cache.json");
        let data: Vec<&CacheEntry> = entries.values().collect();
        let json = serde_json::to_string(&data)?;
        std::fs::write(&cache_file, json)?;

        // Save stats
        let stats_file = cache_dir.join("cache_stats.json");
        let stats = self.stats();
        let stats_json = serde_json::json!({
            "lookups": stats.lookups,
            "hits": stats.hits,
            "misses": stats.misses,
            "entries": stats.entries,
            "size_bytes": stats.size_bytes,
            "hit_rate": stats.hit_rate(),
        });
        std::fs::write(&stats_file, serde_json::to_string_pretty(&stats_json)?)?;

        tracing::info!(
            "Saved fingerprint cache: {} entries, {:.1} MB",
            entries.len(),
            self.size_mb()
        );

        Ok(())
    }

    /// Load cache from disk
    fn load_from_disk(&self) -> std::io::Result<()> {
        let cache_dir = match &self.cache_dir {
            Some(dir) => dir,
            None => return Ok(()),
        };

        let cache_file = cache_dir.join("fingerprint_cache.json");
        if !cache_file.exists() {
            return Ok(());
        }

        let json = std::fs::read_to_string(&cache_file)?;
        let data: Vec<CacheEntry> = serde_json::from_str(&json)?;

        let mut entries = self.entries.write();
        let mut lru = self.lru_order.write();
        let mut total_size = 0u64;

        for entry in data {
            total_size += entry.size_bytes as u64;
            lru.push_back(entry.hash);
            entries.insert(entry.hash, entry);
        }

        self.current_size.store(total_size, Ordering::Relaxed);

        tracing::info!(
            "Loaded fingerprint cache: {} entries, {:.1} MB",
            entries.len(),
            total_size as f64 / (1024.0 * 1024.0)
        );

        Ok(())
    }
}

impl Default for FingerprintCache {
    fn default() -> Self {
        Self::new()
    }
}

impl Drop for FingerprintCache {
    fn drop(&mut self) {
        if self.cache_dir.is_some() && self.len() > 0 {
            if let Err(e) = self.save_to_disk() {
                tracing::warn!("Failed to save fingerprint cache: {}", e);
            }
        }
    }
}

#[cfg(test)]
mod tests {
    use super::*;
    use crate::MethodFingerprint;

    fn make_test_fingerprint(seed: u64) -> ClassFingerprint {
        ClassFingerprint {
            methods_hash: seed * 12345,
            fields_hash: seed * 67890,
            hierarchy_hash: seed * 11111,
            access_flags: 1,
            method_count: 5,
            field_count: 3,
            method_fingerprints: vec![],
        }
    }

    #[test]
    fn test_cache_store_and_lookup() {
        let cache = FingerprintCache::new();
        let fp = make_test_fingerprint(1);

        cache.store(fp.clone(), "public class Foo {}".to_string());

        let result = cache.lookup(&fp);
        assert!(result.is_some());
        assert_eq!(result.unwrap(), "public class Foo {}");
    }

    #[test]
    fn test_cache_miss() {
        let cache = FingerprintCache::new();
        let fp = make_test_fingerprint(1);

        let result = cache.lookup(&fp);
        assert!(result.is_none());

        let stats = cache.stats();
        assert_eq!(stats.lookups, 1);
        assert_eq!(stats.misses, 1);
    }

    #[test]
    fn test_cache_size_limit() {
        // 1KB limit
        let cache = FingerprintCache {
            entries: RwLock::new(FxHashMap::default()),
            lru_order: RwLock::new(VecDeque::new()),
            current_size: AtomicU64::new(0),
            max_size_bytes: 1024,
            cache_dir: None,
            lookups: AtomicU64::new(0),
            hits: AtomicU64::new(0),
            misses: AtomicU64::new(0),
        };

        // Add entries that exceed limit
        for i in 0..10 {
            let fp = make_test_fingerprint(i);
            let source = "x".repeat(200); // 200 bytes each
            cache.store(fp, source);
        }

        // Should have evicted some entries
        assert!(cache.size_bytes() <= 1024);
        assert!(cache.len() < 10);
    }

    #[test]
    fn test_cache_stats() {
        let cache = FingerprintCache::new();
        let fp = make_test_fingerprint(1);

        cache.store(fp.clone(), "test".to_string());
        cache.lookup(&fp);
        cache.lookup(&fp);

        let stats = cache.stats();
        assert_eq!(stats.lookups, 2);
        assert_eq!(stats.hits, 2);
        assert_eq!(stats.entries, 1);
    }
}
