//! String pool for DEX strings

use std::collections::HashMap;
use std::sync::RwLock;

use crate::error::Result;

/// A pool of strings loaded from a DEX file
///
/// Uses interior mutability to allow lazy loading while keeping
/// the DexReader immutably borrowed. Thread-safe for parallel access.
pub struct StringPool {
    strings: RwLock<HashMap<u32, String>>,
}

// Safety: StringPool only contains RwLock<HashMap> which is Send+Sync
unsafe impl Sync for StringPool {}

impl StringPool {
    pub fn new() -> Self {
        StringPool {
            strings: RwLock::new(HashMap::new()),
        }
    }

    /// Get a string by index, loading it if necessary
    pub fn get_or_load<F>(&self, idx: u32, load: F) -> Result<&str>
    where
        F: FnOnce() -> Result<String>,
    {
        // Check if already loaded (read lock)
        {
            let strings = self.strings.read().unwrap();
            if let Some(s) = strings.get(&idx) {
                // Safety: We never remove strings, so this reference is stable
                return Ok(unsafe { &*(s.as_str() as *const str) });
            }
        }

        // Load and insert (write lock)
        let s = load()?;
        let mut strings = self.strings.write().unwrap();

        // Double-check pattern - another thread may have inserted
        if !strings.contains_key(&idx) {
            strings.insert(idx, s);
        }

        // Return reference to the inserted string
        let s = strings.get(&idx).unwrap();
        Ok(unsafe { &*(s.as_str() as *const str) })
    }

    /// Get a string if it's already loaded
    pub fn get(&self, idx: u32) -> Option<&str> {
        let strings = self.strings.read().unwrap();
        strings.get(&idx).map(|s| unsafe { &*(s.as_str() as *const str) })
    }

    /// Number of cached strings
    pub fn len(&self) -> usize {
        self.strings.read().unwrap().len()
    }

    /// Check if empty
    pub fn is_empty(&self) -> bool {
        self.strings.read().unwrap().is_empty()
    }
}

impl Default for StringPool {
    fn default() -> Self {
        Self::new()
    }
}
