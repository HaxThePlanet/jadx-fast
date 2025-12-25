//! Error types for Android resource parsing

use thiserror::Error;

#[derive(Error, Debug)]
pub enum ResourceError {
    #[error("IO error: {0}")]
    Io(#[from] std::io::Error),

    #[error("Invalid binary XML: {0}")]
    InvalidBinaryXml(String),

    #[error("Invalid string pool: {0}")]
    InvalidStringPool(String),

    #[error("Invalid ARSC: {0}")]
    InvalidArsc(String),

    #[error("Unexpected chunk type: 0x{0:04x}")]
    UnexpectedChunkType(u16),

    #[error("Invalid header size: expected 0x{expected:x}, got 0x{actual:x}")]
    InvalidHeaderSize { expected: u32, actual: u32 },

    #[error("Invalid chunk size: expected 0x{expected:x}, got 0x{actual:x}")]
    InvalidChunkSize { expected: u32, actual: u32 },

    #[error("String index out of bounds: {index} >= {count}")]
    StringIndexOutOfBounds { index: u32, count: u32 },

    #[error("Decode error at position 0x{position:x}: {message}")]
    DecodeError { position: u64, message: String },

    #[error("UTF-8 decode error: {0}")]
    Utf8Error(#[from] std::string::FromUtf8Error),

    #[error("UTF-16 decode error")]
    Utf16Error,
}

pub type Result<T> = std::result::Result<T, ResourceError>;
