//! Shared utilities for Dexterity decompiler
//!
//! This crate provides common utility functions used across multiple
//! Dexterity crates to avoid code duplication.
//!
//! # Modules
//!
//! - [`keywords`] - Java reserved words constant
//! - [`identifiers`] - Java identifier validation functions
//! - [`escape`] - String escaping functions for Java source
//! - [`names`] - Naming constants and utilities

pub mod escape;
pub mod identifiers;
pub mod keywords;
pub mod names;

// Re-export commonly used items at crate root
pub use escape::{escape_char, escape_reserved_word, escape_string, escape_string_with_unicode};
pub use identifiers::{
    is_printable_ascii, is_reserved, is_valid_full_identifier, is_valid_identifier,
    is_valid_identifier_part, is_valid_identifier_start,
};
pub use keywords::{JAVA_RESERVED_WORDS, RESERVED_NAMES};
pub use names::{
    is_anonymous_class_name, sanitize_method_name, ANONYMOUS_CLASS_PREFIX, CLASS_NAME_PREFIX,
    DEFAULT_PACKAGE_NAME, MTH_TOSTRING_SIGNATURE, OVERRIDE_ANNOTATION,
};
