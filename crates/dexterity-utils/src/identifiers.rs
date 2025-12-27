//! Java identifier validation functions
//!
//! Clone of JADX NameMapper.java identifier validation.
//! Source: jadx-core/src/main/java/jadx/core/deobf/NameMapper.java

use crate::keywords::RESERVED_NAMES;
use lazy_static::lazy_static;
use regex::Regex;

lazy_static! {
    /// Valid Java identifier pattern
    /// JADX Reference: NameMapper.VALID_JAVA_IDENTIFIER
    static ref VALID_JAVA_IDENTIFIER: Regex =
        Regex::new(r"^[\p{L}_$][\p{L}\p{N}_$]*$").unwrap();

    /// Valid Java full identifier (with dots for packages)
    /// JADX Reference: NameMapper.VALID_JAVA_FULL_IDENTIFIER
    static ref VALID_JAVA_FULL_IDENTIFIER: Regex =
        Regex::new(r"^([\p{L}_$][\p{L}\p{N}_$]*\.)*[\p{L}_$][\p{L}\p{N}_$]*$").unwrap();
}

/// Check if a string is a Java reserved word
///
/// JADX Reference: NameMapper.isReserved()
#[inline]
pub fn is_reserved(s: &str) -> bool {
    RESERVED_NAMES.contains(s)
}

/// Check if a string is a valid Java identifier
///
/// JADX Reference: NameMapper.isValidIdentifier()
///
/// A valid identifier:
/// - Is not empty
/// - Is not a reserved word
/// - Starts with a letter, underscore, or dollar sign
/// - Contains only letters, digits, underscores, or dollar signs
pub fn is_valid_identifier(s: &str) -> bool {
    !s.is_empty() && !is_reserved(s) && VALID_JAVA_IDENTIFIER.is_match(s)
}

/// Check if a string is a valid Java full identifier (with dots)
///
/// JADX Reference: NameMapper.isValidFullIdentifier()
///
/// A valid full identifier is a dot-separated sequence of valid identifiers.
/// Example: "com.example.MyClass"
pub fn is_valid_full_identifier(s: &str) -> bool {
    !s.is_empty() && !is_reserved(s) && VALID_JAVA_FULL_IDENTIFIER.is_match(s)
}

/// Check if a character is valid as a Java identifier start
///
/// JADX Reference: NameMapper.isValidIdentifierStart()
#[inline]
pub fn is_valid_identifier_start(c: char) -> bool {
    c.is_alphabetic() || c == '_' || c == '$'
}

/// Check if a character is valid as a Java identifier part
///
/// JADX Reference: NameMapper.isValidIdentifierPart()
#[inline]
pub fn is_valid_identifier_part(c: char) -> bool {
    c.is_alphanumeric() || c == '_' || c == '$'
}

/// Check if a character is printable ASCII (32-126)
///
/// JADX Reference: NameMapper.isPrintableAsciiCodePoint()
#[inline]
pub fn is_printable_ascii(c: char) -> bool {
    let code = c as u32;
    (32..=126).contains(&code)
}

#[cfg(test)]
mod tests {
    use super::*;

    #[test]
    fn test_is_reserved() {
        assert!(is_reserved("class"));
        assert!(is_reserved("public"));
        assert!(is_reserved("static"));
        assert!(is_reserved("void"));
        assert!(is_reserved("true"));
        assert!(is_reserved("false"));
        assert!(is_reserved("null"));

        assert!(!is_reserved("myClass"));
        assert!(!is_reserved("String"));
        assert!(!is_reserved("foo"));
    }

    #[test]
    fn test_is_valid_identifier() {
        // Valid identifiers
        assert!(is_valid_identifier("foo"));
        assert!(is_valid_identifier("Foo"));
        assert!(is_valid_identifier("foo123"));
        assert!(is_valid_identifier("_foo"));
        assert!(is_valid_identifier("$foo"));
        assert!(is_valid_identifier("foo_bar"));
        assert!(is_valid_identifier("camelCase"));
        assert!(is_valid_identifier("PascalCase"));

        // Invalid identifiers
        assert!(!is_valid_identifier("")); // empty
        assert!(!is_valid_identifier("class")); // reserved
        assert!(!is_valid_identifier("123foo")); // starts with digit
        assert!(!is_valid_identifier("foo-bar")); // contains hyphen
        assert!(!is_valid_identifier("foo bar")); // contains space
        assert!(!is_valid_identifier("foo.bar")); // contains dot
    }

    #[test]
    fn test_is_valid_full_identifier() {
        // Valid full identifiers
        assert!(is_valid_full_identifier("foo"));
        assert!(is_valid_full_identifier("foo.bar"));
        assert!(is_valid_full_identifier("com.example.MyClass"));
        assert!(is_valid_full_identifier("com.example.foo.bar.Baz"));

        // Invalid full identifiers
        assert!(!is_valid_full_identifier("")); // empty
        assert!(!is_valid_full_identifier(".")); // just dot
        assert!(!is_valid_full_identifier(".foo")); // starts with dot
        assert!(!is_valid_full_identifier("foo.")); // ends with dot
        assert!(!is_valid_full_identifier("foo..bar")); // double dot
        assert!(!is_valid_full_identifier("123.foo")); // segment starts with digit
    }

    #[test]
    fn test_is_valid_identifier_start() {
        assert!(is_valid_identifier_start('a'));
        assert!(is_valid_identifier_start('Z'));
        assert!(is_valid_identifier_start('_'));
        assert!(is_valid_identifier_start('$'));

        assert!(!is_valid_identifier_start('1'));
        assert!(!is_valid_identifier_start('-'));
        assert!(!is_valid_identifier_start(' '));
    }

    #[test]
    fn test_is_valid_identifier_part() {
        assert!(is_valid_identifier_part('a'));
        assert!(is_valid_identifier_part('Z'));
        assert!(is_valid_identifier_part('1'));
        assert!(is_valid_identifier_part('_'));
        assert!(is_valid_identifier_part('$'));

        assert!(!is_valid_identifier_part('-'));
        assert!(!is_valid_identifier_part(' '));
        assert!(!is_valid_identifier_part('.'));
    }

    #[test]
    fn test_is_printable_ascii() {
        assert!(is_printable_ascii('a'));
        assert!(is_printable_ascii('Z'));
        assert!(is_printable_ascii('0'));
        assert!(is_printable_ascii(' '));
        assert!(is_printable_ascii('~'));

        assert!(!is_printable_ascii('\n'));
        assert!(!is_printable_ascii('\t'));
        assert!(!is_printable_ascii('\0'));
    }
}
