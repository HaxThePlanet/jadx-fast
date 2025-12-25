//! Shared utility functions for code generation
//!
//! This module contains common helper functions used across multiple
//! codegen modules to avoid duplication.

/// Sanitize a method name by replacing hyphens with underscores.
///
/// Some DEX files contain method names with hyphens (e.g., from Kotlin
/// or obfuscators), which are invalid in Java source code.
///
/// # Examples
/// ```
/// use dexterity_codegen::sanitize_method_name;
/// assert_eq!(sanitize_method_name("get-value"), "get_value");
/// assert_eq!(sanitize_method_name("normalName"), "normalName");
/// ```
pub fn sanitize_method_name(name: &str) -> String {
    if !name.contains('-') {
        return name.to_string();
    }
    name.replace('-', "_")
}

#[cfg(test)]
mod tests {
    use super::*;

    #[test]
    fn test_sanitize_method_name() {
        assert_eq!(sanitize_method_name("normal"), "normal");
        assert_eq!(sanitize_method_name("has-hyphen"), "has_hyphen");
        assert_eq!(sanitize_method_name("multi-hyphen-name"), "multi_hyphen_name");
        assert_eq!(sanitize_method_name("-leading"), "_leading");
        assert_eq!(sanitize_method_name("trailing-"), "trailing_");
    }
}
