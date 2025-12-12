//! Name validation utilities
//!
//! Ported from jadx-core/src/main/java/jadx/core/deobf/NameMapper.java

use lazy_static::lazy_static;
use regex::Regex;
use std::collections::HashSet;

lazy_static! {
    /// Valid Java identifier pattern
    static ref VALID_JAVA_IDENTIFIER: Regex = Regex::new(
        r"^[\p{L}_$][\p{L}\p{N}_$]*$"
    ).unwrap();

    /// Reserved Java keywords
    static ref RESERVED_NAMES: HashSet<&'static str> = {
        let mut set = HashSet::new();
        for name in &[
            "_",
            "abstract", "assert", "boolean", "break", "byte",
            "case", "catch", "char", "class", "const", "continue",
            "default", "do", "double",
            "else", "enum", "extends",
            "false", "final", "finally", "float", "for",
            "goto",
            "if", "implements", "import", "instanceof", "int", "interface",
            "long",
            "native", "new", "null",
            "package", "private", "protected", "public",
            "return",
            "short", "static", "strictfp", "super", "switch", "synchronized",
            "this", "throw", "throws", "transient", "true", "try",
            "void", "volatile",
            "while",
        ] {
            set.insert(*name);
        }
        set
    };
}

/// Name validation and manipulation utilities
pub struct NameMapper;

impl NameMapper {
    /// Check if a name is a reserved Java keyword
    pub fn is_reserved(name: &str) -> bool {
        RESERVED_NAMES.contains(name)
    }

    /// Check if a string is a valid Java identifier
    pub fn is_valid_identifier(name: &str) -> bool {
        !name.is_empty()
            && !Self::is_reserved(name)
            && VALID_JAVA_IDENTIFIER.is_match(name)
    }

    /// Check if a character is valid for starting a Java identifier
    pub fn is_valid_identifier_start(c: char) -> bool {
        c.is_alphabetic() || c == '_' || c == '$'
    }

    /// Check if a character is valid as part of a Java identifier
    pub fn is_valid_identifier_part(c: char) -> bool {
        c.is_alphanumeric() || c == '_' || c == '$'
    }

    /// Check if a character is printable ASCII (32-126)
    pub fn is_printable_ascii(c: char) -> bool {
        let code = c as u32;
        (32..=126).contains(&code)
    }

    /// Check if all characters in a string are printable ASCII
    pub fn is_all_chars_printable(s: &str) -> bool {
        s.chars().all(Self::is_printable_ascii)
    }

    /// Check if a name is valid and contains only printable characters
    pub fn is_valid_and_printable(name: &str) -> bool {
        Self::is_valid_identifier(name) && Self::is_all_chars_printable(name)
    }

    /// Remove invalid characters from the middle of a name
    /// Note: May leave invalid start characters (numbers), caller should add prefix
    pub fn remove_invalid_chars_middle(name: &str) -> String {
        if Self::is_valid_identifier(name) && Self::is_all_chars_printable(name) {
            return name.to_string();
        }

        name.chars()
            .filter(|&c| Self::is_printable_ascii(c) && Self::is_valid_identifier_part(c))
            .collect()
    }

    /// Remove invalid characters and add prefix if needed
    pub fn remove_invalid_chars(name: &str, prefix: &str) -> String {
        let result = Self::remove_invalid_chars_middle(name);
        if !result.is_empty() {
            let first = result.chars().next().unwrap();
            if !Self::is_valid_identifier_start(first) {
                return format!("{}{}", prefix, result);
            }
        }
        result
    }

    /// Remove non-printable characters
    pub fn remove_non_printable(name: &str) -> String {
        name.chars()
            .filter(|&c| Self::is_printable_ascii(c))
            .collect()
    }
}

#[cfg(test)]
mod tests {
    use super::*;

    #[test]
    fn test_reserved_words() {
        assert!(NameMapper::is_reserved("class"));
        assert!(NameMapper::is_reserved("void"));
        assert!(NameMapper::is_reserved("_"));
        assert!(!NameMapper::is_reserved("foo"));
        assert!(!NameMapper::is_reserved("myClass"));
    }

    #[test]
    fn test_valid_identifier() {
        assert!(NameMapper::is_valid_identifier("foo"));
        assert!(NameMapper::is_valid_identifier("Foo"));
        assert!(NameMapper::is_valid_identifier("_foo"));
        assert!(NameMapper::is_valid_identifier("$foo"));
        assert!(NameMapper::is_valid_identifier("foo123"));
        assert!(NameMapper::is_valid_identifier("foo_bar"));

        assert!(!NameMapper::is_valid_identifier(""));
        assert!(!NameMapper::is_valid_identifier("123foo"));
        assert!(!NameMapper::is_valid_identifier("class"));
        assert!(!NameMapper::is_valid_identifier("foo-bar"));
        assert!(!NameMapper::is_valid_identifier("foo bar"));
    }

    #[test]
    fn test_printable() {
        assert!(NameMapper::is_all_chars_printable("hello"));
        assert!(NameMapper::is_all_chars_printable("Hello123"));
        assert!(!NameMapper::is_all_chars_printable("hello\n"));
        assert!(!NameMapper::is_all_chars_printable("hello\x00"));
    }

    #[test]
    fn test_remove_invalid() {
        assert_eq!(NameMapper::remove_invalid_chars_middle("hello"), "hello");
        assert_eq!(NameMapper::remove_invalid_chars_middle("he-llo"), "hello");
        assert_eq!(NameMapper::remove_invalid_chars_middle("123"), "123");

        assert_eq!(NameMapper::remove_invalid_chars("123foo", "v"), "v123foo");
        assert_eq!(NameMapper::remove_invalid_chars("foo", "v"), "foo");
    }
}
