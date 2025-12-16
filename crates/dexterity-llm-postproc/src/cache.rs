//! Caching system for LLM responses

use anyhow::Result;
use serde_json::json;
use sha2::{Digest, Sha256};
use std::collections::HashMap;
use std::fs;
use std::path::PathBuf;

/// Cache key = SHA256(input)
type CacheKey = String;

pub struct Cache {
    cache_dir: PathBuf,
    in_memory: HashMap<CacheKey, String>,
}

impl Cache {
    /// Create a new cache with the given directory
    pub fn new(cache_dir: String) -> Self {
        let path = PathBuf::from(cache_dir);
        if !path.exists() {
            let _ = fs::create_dir_all(&path);
        }

        Self {
            cache_dir: path,
            in_memory: HashMap::new(),
        }
    }

    /// Generate cache key from input
    fn generate_key(input: &str) -> CacheKey {
        let mut hasher = Sha256::new();
        hasher.update(input.as_bytes());
        format!("{:x}", hasher.finalize())
    }

    /// Get cached value
    pub fn get(&mut self, input: &str) -> Option<String> {
        let key = Self::generate_key(input);

        // Check in-memory cache first
        if let Some(value) = self.in_memory.get(&key) {
            tracing::debug!("Cache hit (memory): {}", &key[..8]);
            return Some(value.clone());
        }

        // Check disk cache
        if let Ok(value) = self.get_disk(&key) {
            tracing::debug!("Cache hit (disk): {}", &key[..8]);
            self.in_memory.insert(key, value.clone());
            return Some(value);
        }

        tracing::debug!("Cache miss: {}", &key[..8]);
        None
    }

    /// Set cache value
    pub fn set(&mut self, input: &str, output: &str) -> Result<()> {
        let key = Self::generate_key(input);

        // Store in memory
        self.in_memory.insert(key.clone(), output.to_string());

        // Store on disk
        self.set_disk(&key, output)?;

        Ok(())
    }

    /// Get from disk cache
    fn get_disk(&self, key: &CacheKey) -> Result<String> {
        let cache_file = self.cache_dir.join(format!("{}.json", key));

        if !cache_file.exists() {
            return Err(anyhow::anyhow!("Cache file not found"));
        }

        let content = fs::read_to_string(&cache_file)?;
        let json: serde_json::Value = serde_json::from_str(&content)?;
        let value = json["output"]
            .as_str()
            .ok_or_else(|| anyhow::anyhow!("Invalid cache format"))?;

        Ok(value.to_string())
    }

    /// Set disk cache
    fn set_disk(&self, key: &CacheKey, output: &str) -> Result<()> {
        let cache_file = self.cache_dir.join(format!("{}.json", key));

        let data = json!({
            "key": key,
            "output": output,
            "timestamp": chrono::Utc::now().to_rfc3339(),
        });

        fs::write(&cache_file, data.to_string())?;

        Ok(())
    }

    /// Clear cache
    pub fn clear(&mut self) -> Result<()> {
        self.in_memory.clear();

        if self.cache_dir.exists() {
            fs::remove_dir_all(&self.cache_dir)?;
            fs::create_dir_all(&self.cache_dir)?;
        }

        Ok(())
    }

    /// Get cache statistics
    pub fn stats(&self) -> CacheStats {
        let disk_files = fs::read_dir(&self.cache_dir)
            .map(|entries| entries.count())
            .unwrap_or(0);

        CacheStats {
            memory_items: self.in_memory.len(),
            disk_items: disk_files,
            cache_dir: self.cache_dir.to_string_lossy().to_string(),
        }
    }
}

/// Cache statistics
#[derive(Debug, Clone)]
pub struct CacheStats {
    pub memory_items: usize,
    pub disk_items: usize,
    pub cache_dir: String,
}

#[cfg(test)]
mod tests {
    use super::*;
    use std::fs;

    #[test]
    fn test_cache_key_generation() {
        let input1 = "test input";
        let input2 = "test input";
        let input3 = "different input";

        let key1 = Cache::generate_key(input1);
        let key2 = Cache::generate_key(input2);
        let key3 = Cache::generate_key(input3);

        assert_eq!(key1, key2);
        assert_ne!(key1, key3);
    }

    #[test]
    fn test_cache_operations() {
        let cache_dir = "/tmp/dexterity-cache-test";
        let _ = fs::remove_dir_all(cache_dir);

        let mut cache = Cache::new(cache_dir.to_string());

        // Test set and get
        let input = "test input";
        let output = "test output";

        cache.set(input, output).unwrap();
        assert_eq!(cache.get(input), Some(output.to_string()));

        // Test cache miss
        assert_eq!(cache.get("nonexistent"), None);

        // Cleanup
        let _ = fs::remove_dir_all(cache_dir);
    }
}
