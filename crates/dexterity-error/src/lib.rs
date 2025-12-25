//! Shared error types for the Dexterity decompiler
//!
//! This crate provides a unified error hierarchy for all Dexterity components.
//! Each component can define its own error types and convert them to the common
//! `DexterityError` type for consistent error handling across the pipeline.

use thiserror::Error;

/// Result type alias for Dexterity operations
pub type Result<T> = std::result::Result<T, DexterityError>;

/// Unified error type for the Dexterity decompiler
///
/// This enum encompasses all error categories that can occur during decompilation:
/// - DEX parsing errors
/// - Resource parsing errors
/// - Deobfuscation/mapping errors
/// - Region traversal errors
/// - Code generation errors
/// - I/O errors
#[derive(Error, Debug)]
pub enum DexterityError {
    // =========================================================================
    // DEX Parsing Errors
    // =========================================================================
    #[error("Invalid DEX magic bytes")]
    InvalidDexMagic,

    #[error("Invalid DEX version: {0}")]
    InvalidDexVersion(String),

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

    #[error("DEX parse error at offset 0x{offset:X}: {message}")]
    DexParse { offset: usize, message: String },

    #[error("Memory map error: {0}")]
    Mmap(String),

    // =========================================================================
    // Resource Parsing Errors
    // =========================================================================
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

    #[error("Resource decode error at position 0x{position:x}: {message}")]
    ResourceDecode { position: u64, message: String },

    #[error("UTF-16 decode error")]
    Utf16DecodeError,

    // =========================================================================
    // Mapping/Deobfuscation Errors
    // =========================================================================
    #[error("Mapping parse error at line {line}: {message}")]
    MappingParse { line: usize, message: String },

    // =========================================================================
    // Region Traversal Errors
    // =========================================================================
    #[error("Iterative traversal limit reached: {iterations} iterations (limit: {limit})")]
    TraversalLimitReached { limit: usize, iterations: usize },

    #[error("Stack overflow during region traversal")]
    TraversalStackOverflow,

    // =========================================================================
    // Code Generation Errors
    // =========================================================================
    #[error("Code generation error: {0}")]
    CodeGen(String),

    #[error("Type inference failed for register {register}: {message}")]
    TypeInference { register: u16, message: String },

    #[error("Invalid region structure: {0}")]
    InvalidRegion(String),

    // =========================================================================
    // Region Building Errors
    // =========================================================================
    #[error("Region stack overflow: limit {limit} exceeded")]
    RegionStackOverflow { limit: usize },

    #[error("Regions limit reached: {limit} regions created")]
    RegionsLimitReached { limit: usize },

    #[error("Contents limit reached in block {block_id}: limit {limit} exceeded")]
    ContentsLimitReached { block_id: u32, limit: usize },

    #[error("Iteration limit reached: {used} iterations used of {budget} budget ({blocks} blocks)")]
    IterationLimitReached {
        used: usize,
        budget: usize,
        blocks: usize,
    },

    // =========================================================================
    // General Errors
    // =========================================================================
    #[error("I/O error: {0}")]
    Io(#[from] std::io::Error),

    #[error("UTF-8 decode error: {0}")]
    Utf8(#[from] std::string::FromUtf8Error),

    #[error("{0}")]
    Other(String),
}

// ============================================================================
// Error Category Helpers
// ============================================================================

impl DexterityError {
    /// Returns true if this is a DEX parsing error
    pub fn is_dex_error(&self) -> bool {
        matches!(
            self,
            Self::InvalidDexMagic
                | Self::InvalidDexVersion(_)
                | Self::InvalidEndian(_)
                | Self::ChecksumMismatch { .. }
                | Self::InvalidStringIndex(_)
                | Self::InvalidTypeIndex(_)
                | Self::InvalidMethodIndex(_)
                | Self::InvalidFieldIndex(_)
                | Self::InvalidProtoIndex(_)
                | Self::InvalidClassDefIndex(_)
                | Self::InvalidOffset { .. }
                | Self::UnexpectedEof { .. }
                | Self::InvalidOpcode(_)
                | Self::InvalidInstructionFormat { .. }
                | Self::InvalidLeb128
                | Self::InvalidMutf8
                | Self::DexParse { .. }
                | Self::Mmap(_)
        )
    }

    /// Returns true if this is a resource parsing error
    pub fn is_resource_error(&self) -> bool {
        matches!(
            self,
            Self::InvalidBinaryXml(_)
                | Self::InvalidStringPool(_)
                | Self::InvalidArsc(_)
                | Self::UnexpectedChunkType(_)
                | Self::InvalidHeaderSize { .. }
                | Self::InvalidChunkSize { .. }
                | Self::StringIndexOutOfBounds { .. }
                | Self::ResourceDecode { .. }
                | Self::Utf16DecodeError
        )
    }

    /// Returns true if this is a traversal error
    pub fn is_traversal_error(&self) -> bool {
        matches!(
            self,
            Self::TraversalLimitReached { .. } | Self::TraversalStackOverflow
        )
    }

    /// Returns true if this is recoverable (decompilation can continue)
    pub fn is_recoverable(&self) -> bool {
        matches!(
            self,
            Self::TypeInference { .. }
                | Self::CodeGen(_)
                | Self::InvalidRegion(_)
                | Self::TraversalLimitReached { .. }
        )
    }
}

// ============================================================================
// Convenience Constructors
// ============================================================================

impl DexterityError {
    /// Create a DEX parse error with offset and message
    pub fn dex_parse(offset: usize, message: impl Into<String>) -> Self {
        Self::DexParse {
            offset,
            message: message.into(),
        }
    }

    /// Create a resource decode error
    pub fn resource_decode(position: u64, message: impl Into<String>) -> Self {
        Self::ResourceDecode {
            position,
            message: message.into(),
        }
    }

    /// Create a mapping parse error
    pub fn mapping_parse(line: usize, message: impl Into<String>) -> Self {
        Self::MappingParse {
            line,
            message: message.into(),
        }
    }

    /// Create a code generation error
    pub fn codegen(message: impl Into<String>) -> Self {
        Self::CodeGen(message.into())
    }

    /// Create a type inference error
    pub fn type_inference(register: u16, message: impl Into<String>) -> Self {
        Self::TypeInference {
            register,
            message: message.into(),
        }
    }

    /// Create an other/generic error
    pub fn other(message: impl Into<String>) -> Self {
        Self::Other(message.into())
    }
}

#[cfg(test)]
mod tests {
    use super::*;

    #[test]
    fn test_error_categories() {
        assert!(DexterityError::InvalidDexMagic.is_dex_error());
        assert!(!DexterityError::InvalidDexMagic.is_resource_error());

        assert!(DexterityError::InvalidBinaryXml("test".into()).is_resource_error());
        assert!(!DexterityError::InvalidBinaryXml("test".into()).is_dex_error());

        let traversal = DexterityError::TraversalLimitReached {
            limit: 100,
            iterations: 101,
        };
        assert!(traversal.is_traversal_error());
        assert!(traversal.is_recoverable());
    }

    #[test]
    fn test_error_display() {
        let err = DexterityError::InvalidDexVersion("039".into());
        assert_eq!(err.to_string(), "Invalid DEX version: 039");

        let err = DexterityError::dex_parse(0x1234, "bad header");
        assert_eq!(err.to_string(), "DEX parse error at offset 0x1234: bad header");
    }

    #[test]
    fn test_io_error_conversion() {
        let io_err = std::io::Error::new(std::io::ErrorKind::NotFound, "file not found");
        let err: DexterityError = io_err.into();
        assert!(matches!(err, DexterityError::Io(_)));
    }
}
