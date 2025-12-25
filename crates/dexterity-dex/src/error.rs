//! Error types for DEX parsing

use thiserror::Error;

/// Result type alias for DEX operations
pub type Result<T> = std::result::Result<T, DexError>;

/// Errors that can occur during DEX parsing
#[derive(Error, Debug)]
pub enum DexError {
    #[error("Invalid DEX magic bytes")]
    InvalidMagic,

    #[error("Invalid DEX version: {0}")]
    InvalidVersion(String),

    #[error("Invalid endian tag: expected 0x12345678, got 0x{0:08X}")]
    InvalidEndian(u32),

    #[error("Checksum mismatch: expected 0x{expected:08X}, got 0x{actual:08X}")]
    ChecksumMismatch { expected: u32, actual: u32 },

    #[error("Invalid string index: {0}")]
    InvalidStringIndex(u32),

    #[error("Invalid type index: {0}")]
    InvalidTypeIndex(u32),

    #[error("Invalid method index: {0}")]
    InvalidMethodIndex(u32),

    #[error("Invalid field index: {0}")]
    InvalidFieldIndex(u32),

    #[error("Invalid proto index: {0}")]
    InvalidProtoIndex(u32),

    #[error("Invalid class def index: {0}")]
    InvalidClassDefIndex(u32),

    #[error("Invalid offset in {section}: 0x{offset:X}")]
    InvalidOffset { section: &'static str, offset: u32 },

    #[error("Unexpected end of data at offset {offset}, needed {needed} bytes")]
    UnexpectedEof { offset: usize, needed: usize },

    #[error("Invalid opcode: 0x{0:02X}")]
    InvalidOpcode(u8),

    #[error("Invalid instruction format for opcode 0x{opcode:02X}")]
    InvalidInstructionFormat { opcode: u8 },

    #[error("Invalid LEB128 encoding")]
    InvalidLeb128,

    #[error("Invalid MUTF-8 encoding")]
    InvalidMutf8,

    #[error("I/O error: {0}")]
    Io(#[from] std::io::Error),

    #[error("Memory map error: {0}")]
    Mmap(String),

    #[error("Parse error at offset 0x{offset:X}: {message}")]
    Parse { offset: usize, message: String },
}
