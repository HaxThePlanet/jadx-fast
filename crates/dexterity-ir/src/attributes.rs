//! Attribute storage for IR nodes

use std::collections::HashMap;
use std::any::{Any, TypeId};

/// Storage for node attributes
#[derive(Debug, Default)]
pub struct AttributeStorage {
    flags: u64,
    #[allow(dead_code)] // Planned for future attribute storage
    attrs: HashMap<TypeId, Box<dyn Any + Send + Sync>>,
}

impl AttributeStorage {
    pub fn new() -> Self {
        Self::default()
    }

    /// Check if a flag is set
    pub fn has_flag(&self, flag: AFlag) -> bool {
        (self.flags & (1 << flag as u8)) != 0
    }

    /// Set a flag
    pub fn add_flag(&mut self, flag: AFlag) {
        self.flags |= 1 << flag as u8;
    }

    /// Remove a flag
    pub fn remove_flag(&mut self, flag: AFlag) {
        self.flags &= !(1 << flag as u8);
    }
}

/// Common attribute flags
#[derive(Debug, Clone, Copy, PartialEq, Eq, Hash)]
#[repr(u8)]
pub enum AFlag {
    Synthetic = 0,
    DontGenerate = 1,
    DontInline = 2,
    SkipFirstArg = 3,
    SkipMth = 4,
    ThisArg = 5,
    ReturnArg = 6,
    Wrapped = 7,
    LoopStart = 8,
    LoopEnd = 9,
    FinallyInsns = 10,
}
