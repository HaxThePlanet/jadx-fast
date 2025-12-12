//! Utility functions for DEX parsing

pub mod leb128;
pub mod mutf8;

pub use leb128::{read_sleb128, read_uleb128, read_uleb128p1};
pub use mutf8::decode_mutf8;
