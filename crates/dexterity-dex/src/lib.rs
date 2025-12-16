//! DEX file format parser for jadx-rust
//!
//! This crate provides parsing capabilities for Android DEX (Dalvik Executable) files.
//! It supports zero-copy parsing where possible and handles all DEX format versions.

pub mod consts;
pub mod error;
pub mod header;
pub mod insns;
pub mod reader;
pub mod sections;
pub mod utils;

pub use error::{DexError, Result};
pub use header::DexHeader;
pub use reader::DexReader;
pub use sections::{ClassDef, ClassData, CodeItem, EncodedMethod, EncodedField, EncodedValue, FieldId, MethodId, ProtoId, parse_encoded_array};

/// Magic bytes for DEX files: "dex\n"
pub const DEX_MAGIC: [u8; 4] = [0x64, 0x65, 0x78, 0x0a];

/// Magic bytes for ZIP files (APK detection)
pub const ZIP_MAGIC: [u8; 4] = [0x50, 0x4B, 0x03, 0x04];

/// Endian constant for little-endian DEX files
pub const ENDIAN_CONSTANT: u32 = 0x12345678;

/// No index marker
pub const NO_INDEX: u32 = 0xFFFFFFFF;
