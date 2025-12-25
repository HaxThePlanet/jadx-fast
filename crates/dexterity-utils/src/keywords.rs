//! Java reserved words - single source of truth
//!
//! This module provides the canonical list of Java reserved keywords
//! used throughout Dexterity for identifier validation.

use lazy_static::lazy_static;
use std::collections::HashSet;

/// Complete list of Java reserved words (69 keywords)
///
/// JADX Reference: NameMapper.RESERVED_NAMES
///
/// Includes:
/// - All Java keywords (abstract, class, etc.)
/// - Literals (true, false, null)
/// - Reserved but unused (goto, const)
/// - Underscore (reserved since Java 9)
pub const JAVA_RESERVED_WORDS: &[&str] = &[
    "_",
    "abstract",
    "assert",
    "boolean",
    "break",
    "byte",
    "case",
    "catch",
    "char",
    "class",
    "const",
    "continue",
    "default",
    "do",
    "double",
    "else",
    "enum",
    "extends",
    "false",
    "final",
    "finally",
    "float",
    "for",
    "goto",
    "if",
    "implements",
    "import",
    "instanceof",
    "int",
    "interface",
    "long",
    "native",
    "new",
    "null",
    "package",
    "private",
    "protected",
    "public",
    "return",
    "short",
    "static",
    "strictfp",
    "super",
    "switch",
    "synchronized",
    "this",
    "throw",
    "throws",
    "transient",
    "true",
    "try",
    "void",
    "volatile",
    "while",
];

lazy_static! {
    /// HashSet of reserved names for O(1) lookup
    ///
    /// JADX Reference: NameMapper.RESERVED_NAMES
    pub static ref RESERVED_NAMES: HashSet<&'static str> = {
        JAVA_RESERVED_WORDS.iter().copied().collect()
    };
}

#[cfg(test)]
mod tests {
    use super::*;

    #[test]
    fn test_reserved_words_count() {
        // Should have 54 keywords (Java SE keywords + literals + special)
        assert_eq!(JAVA_RESERVED_WORDS.len(), 54);
        assert_eq!(RESERVED_NAMES.len(), 54);
    }

    #[test]
    fn test_common_keywords() {
        assert!(RESERVED_NAMES.contains("class"));
        assert!(RESERVED_NAMES.contains("public"));
        assert!(RESERVED_NAMES.contains("private"));
        assert!(RESERVED_NAMES.contains("static"));
        assert!(RESERVED_NAMES.contains("final"));
        assert!(RESERVED_NAMES.contains("void"));
        assert!(RESERVED_NAMES.contains("return"));
        assert!(RESERVED_NAMES.contains("if"));
        assert!(RESERVED_NAMES.contains("else"));
        assert!(RESERVED_NAMES.contains("for"));
        assert!(RESERVED_NAMES.contains("while"));
        assert!(RESERVED_NAMES.contains("try"));
        assert!(RESERVED_NAMES.contains("catch"));
    }

    #[test]
    fn test_literals() {
        assert!(RESERVED_NAMES.contains("true"));
        assert!(RESERVED_NAMES.contains("false"));
        assert!(RESERVED_NAMES.contains("null"));
    }

    #[test]
    fn test_special_reserved() {
        // Underscore reserved since Java 9
        assert!(RESERVED_NAMES.contains("_"));
        // goto and const are reserved but unused
        assert!(RESERVED_NAMES.contains("goto"));
        assert!(RESERVED_NAMES.contains("const"));
    }

    #[test]
    fn test_not_reserved() {
        assert!(!RESERVED_NAMES.contains("String"));
        assert!(!RESERVED_NAMES.contains("main"));
        assert!(!RESERVED_NAMES.contains("args"));
        assert!(!RESERVED_NAMES.contains("System"));
    }
}
