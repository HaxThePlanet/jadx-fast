//! Name validation utilities
//!
//! Ported from jadx-core/src/main/java/jadx/core/deobf/NameMapper.java

use lazy_static::lazy_static;
use regex::Regex;
use std::collections::HashSet;

lazy_static! {
    /// Valid Java identifier pattern
    ///
    /// JADX Reference: NameMapper.VALID_JAVA_IDENTIFIER
    static ref VALID_JAVA_IDENTIFIER: Regex = Regex::new(
        r"^[\p{L}_$][\p{L}\p{N}_$]*$"
    ).unwrap();

    /// Valid Java fully qualified identifier pattern (e.g., "com.example.MyClass")
    ///
    /// JADX Reference: NameMapper.VALID_JAVA_FULL_IDENTIFIER
    static ref VALID_JAVA_FULL_IDENTIFIER: Regex = Regex::new(
        r"^([\p{L}_$][\p{L}\p{N}_$]*\.)*[\p{L}_$][\p{L}\p{N}_$]*$"
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

    /// Check if a string is a valid fully qualified Java identifier
    ///
    /// JADX Reference: NameMapper.isValidFullIdentifier()
    ///
    /// Examples:
    /// - "MyClass" - valid
    /// - "com.example.MyClass" - valid
    /// - "com.example.123Class" - invalid (starts with digit)
    /// - "class" - invalid (reserved word)
    pub fn is_valid_full_identifier(name: &str) -> bool {
        !name.is_empty()
            && !Self::is_reserved(name)
            && VALID_JAVA_FULL_IDENTIFIER.is_match(name)
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
    ///
    /// JADX Reference: NameMapper.isPrintableAsciiCodePoint()
    pub fn is_printable_ascii(c: char) -> bool {
        let code = c as u32;
        (32..=126).contains(&code)
    }

    /// Check if a code point is printable (including Unicode)
    ///
    /// JADX Reference: NameMapper.isPrintableCodePoint()
    ///
    /// This is more sophisticated than `is_printable_ascii`, checking:
    /// - Not an ISO control character
    /// - Not a non-standard whitespace
    /// - Not in problematic Unicode ranges
    pub fn is_printable_code_point(c: char) -> bool {
        // Check for control characters
        if c.is_control() {
            return false;
        }

        // Check for whitespace (only allow standard space)
        if c.is_whitespace() {
            return c == ' ';
        }

        // Check for problematic Unicode ranges
        // Private Use Area: U+E000 to U+F8FF
        // Surrogates: U+D800 to U+DFFF (but Rust chars can't represent these)
        let code = c as u32;
        if (0xE000..=0xF8FF).contains(&code) {
            return false;
        }

        // Format characters (zero-width joiners, etc.)
        // Common format characters in the range U+200B to U+200F and U+2028 to U+202F
        if (0x200B..=0x200F).contains(&code) || (0x2028..=0x202F).contains(&code) {
            return false;
        }

        // Specials block (includes replacement character)
        if (0xFFF0..=0xFFFF).contains(&code) {
            return false;
        }

        // BOM and other format characters
        if code == 0xFEFF || code == 0xFFFE {
            return false;
        }

        true
    }

    /// Check if all characters in a string are printable ASCII
    ///
    /// JADX Reference: NameMapper.isAllCharsPrintable()
    pub fn is_all_chars_printable(s: &str) -> bool {
        s.chars().all(Self::is_printable_ascii)
    }

    /// Check if all characters in a string are printable (including Unicode)
    pub fn is_all_chars_printable_unicode(s: &str) -> bool {
        s.chars().all(Self::is_printable_code_point)
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

    #[test]
    fn test_valid_full_identifier() {
        // Valid fully qualified names
        assert!(NameMapper::is_valid_full_identifier("MyClass"));
        assert!(NameMapper::is_valid_full_identifier("com.example.MyClass"));
        assert!(NameMapper::is_valid_full_identifier("org.apache.commons.io.FileUtils"));
        assert!(NameMapper::is_valid_full_identifier("a.b.c"));

        // Invalid
        assert!(!NameMapper::is_valid_full_identifier(""));
        assert!(!NameMapper::is_valid_full_identifier("class")); // reserved
        assert!(!NameMapper::is_valid_full_identifier("com.123.MyClass")); // starts with digit
        assert!(!NameMapper::is_valid_full_identifier("com..MyClass")); // empty segment
        assert!(!NameMapper::is_valid_full_identifier(".com.MyClass")); // starts with dot
    }

    #[test]
    fn test_printable_code_point() {
        // Printable
        assert!(NameMapper::is_printable_code_point('a'));
        assert!(NameMapper::is_printable_code_point('Z'));
        assert!(NameMapper::is_printable_code_point('5'));
        assert!(NameMapper::is_printable_code_point(' ')); // standard space
        assert!(NameMapper::is_printable_code_point('ä')); // Unicode letter
        assert!(NameMapper::is_printable_code_point('日')); // CJK

        // Not printable
        assert!(!NameMapper::is_printable_code_point('\n')); // control
        assert!(!NameMapper::is_printable_code_point('\t')); // whitespace
        assert!(!NameMapper::is_printable_code_point('\x00')); // null
        assert!(!NameMapper::is_printable_code_point('\u{200B}')); // zero-width space
        assert!(!NameMapper::is_printable_code_point('\u{FEFF}')); // BOM
    }
}
