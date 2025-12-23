//! Arena allocation and typed indices

use std::marker::PhantomData;

/// A typed index into an arena
///
/// This is a lightweight handle that points to an element in an arena.
/// It's Copy regardless of whether T is Copy, since it only contains an index.
#[derive(Debug, PartialEq, Eq, Hash)]
pub struct ArenaId<T> {
    index: u32,
    _marker: PhantomData<T>,
}

// Manually implement Clone and Copy without requiring T: Copy
// This is correct because ArenaId only contains a u32 and PhantomData<T>,
// and PhantomData<T> is always Copy regardless of T.
impl<T> Clone for ArenaId<T> {
    fn clone(&self) -> Self {
        *self
    }
}

impl<T> Copy for ArenaId<T> {}

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
