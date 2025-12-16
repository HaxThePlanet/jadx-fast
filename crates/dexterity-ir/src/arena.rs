//! Arena allocation and typed indices

use std::marker::PhantomData;

/// A typed index into an arena
#[derive(Debug, Clone, Copy, PartialEq, Eq, Hash)]
pub struct ArenaId<T> {
    index: u32,
    _marker: PhantomData<T>,
}

impl<T> ArenaId<T> {
    /// Create a new arena ID
    pub fn new(index: u32) -> Self {
        ArenaId {
            index,
            _marker: PhantomData,
        }
    }

    /// Get the raw index
    pub fn index(&self) -> u32 {
        self.index
    }
}
