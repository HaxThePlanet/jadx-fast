//! String escaping functions for Java source code
//!
//! These functions escape strings and characters for safe inclusion
//! in generated Java source code.

use crate::keywords::RESERVED_NAMES;

/// Escape a character for Java source with surrounding quotes
///
/// Returns a string like 'c' or '\n' suitable for a char literal.
pub fn escape_char(c: char) -> String {
    match c {
        '\n' => "'\\n'".to_string(),
        '\r' => "'\\r'".to_string(),
        '\t' => "'\\t'".to_string(),
        '\'' => "'\\''".to_string(),
        '\\' => "'\\\\'".to_string(),
        '\0' => "'\\0'".to_string(),
        c if c.is_ascii_graphic() || c == ' ' => format!("'{}'", c),
        c => format!("'\\u{:04x}'", c as u32),
    }
}

/// Escape a string for Java source code
///
/// Returns a quoted string with special characters escaped.
/// Non-ASCII characters are preserved for readability.
pub fn escape_string(s: &str) -> String {
    escape_string_with_unicode(s, false)
}

/// Escape a string for Java source with optional unicode escaping
///
/// When `escape_unicode` is true, non-ASCII characters are escaped as \uXXXX.
/// When false, UTF-8 characters are preserved for readability.
pub fn escape_string_with_unicode(s: &str, escape_unicode: bool) -> String {
    let mut result = String::with_capacity(s.len() + 2);
    result.push('"');
    for c in s.chars() {
        match c {
            '\n' => result.push_str("\\n"),
            '\r' => result.push_str("\\r"),
            '\t' => result.push_str("\\t"),
            '"' => result.push_str("\\\""),
            '\\' => result.push_str("\\\\"),
            c if c.is_ascii_graphic() || c == ' ' => result.push(c),
            c if !escape_unicode && c.is_alphanumeric() => result.push(c),
            c if !escape_unicode && !c.is_control() => result.push(c),
            c if c as u32 <= 0xFFFF => {
                result.push_str(&format!("\\u{:04x}", c as u32));
            }
            c => {
                // Surrogate pair for chars > 0xFFFF
                let code = c as u32 - 0x10000;
                let high = ((code >> 10) + 0xD800) as u16;
                let low = ((code & 0x3FF) + 0xDC00) as u16;
                result.push_str(&format!("\\u{:04x}\\u{:04x}", high, low));
            }
        }
    }
    result.push('"');
    result
}

/// Escape inner string content (without surrounding quotes)
///
/// Use this when you need to escape content that will be placed
/// inside an already-quoted string.
pub fn escape_string_inner(s: &str) -> String {
    let mut result = String::with_capacity(s.len());
    for c in s.chars() {
        match c {
            '\n' => result.push_str("\\n"),
            '\r' => result.push_str("\\r"),
            '\t' => result.push_str("\\t"),
            '"' => result.push_str("\\\""),
            '\\' => result.push_str("\\\\"),
            c => result.push(c),
        }
    }
    result
}

/// Escape a reserved word by appending an underscore
///
/// If the name is a Java reserved word, appends '_' to make it valid.
/// Otherwise returns the name unchanged.
pub fn escape_reserved_word(name: &str) -> String {
    if RESERVED_NAMES.contains(name) {
        format!("{}$_", name)
    } else {
        name.to_string()
    }
}

#[cfg(test)]
mod tests {
    use super::*;

    #[test]
    fn test_escape_char() {
        assert_eq!(escape_char('a'), "'a'");
        assert_eq!(escape_char('Z'), "'Z'");
        assert_eq!(escape_char('0'), "'0'");
        assert_eq!(escape_char(' '), "' '");
        assert_eq!(escape_char('\n'), "'\\n'");
        assert_eq!(escape_char('\r'), "'\\r'");
        assert_eq!(escape_char('\t'), "'\\t'");
        assert_eq!(escape_char('\''), "'\\''");
        assert_eq!(escape_char('\\'), "'\\\\'");
        assert_eq!(escape_char('\0'), "'\\0'");
    }

    #[test]
    fn test_escape_char_unicode() {
        // Non-ASCII should be escaped as \uXXXX
        assert_eq!(escape_char('\u{00A9}'), "'\\u00a9'"); // copyright symbol
    }

    #[test]
    fn test_escape_string() {
        assert_eq!(escape_string("hello"), "\"hello\"");
        assert_eq!(escape_string("hello world"), "\"hello world\"");
        assert_eq!(escape_string("line1\nline2"), "\"line1\\nline2\"");
        assert_eq!(escape_string("tab\there"), "\"tab\\there\"");
        assert_eq!(escape_string("quote\"here"), "\"quote\\\"here\"");
        assert_eq!(escape_string("back\\slash"), "\"back\\\\slash\"");
    }

    #[test]
    fn test_escape_string_with_unicode() {
        // Without unicode escaping, non-ASCII is preserved
        let s = "caf\u{00E9}"; // café
        assert!(escape_string(s).contains('\u{00E9}'));

        // With unicode escaping, non-ASCII is escaped
        let escaped = escape_string_with_unicode(s, true);
        assert!(escaped.contains("\\u00e9"));
    }

    #[test]
    fn test_escape_string_inner() {
        assert_eq!(escape_string_inner("hello"), "hello");
        assert_eq!(escape_string_inner("line1\nline2"), "line1\\nline2");
        assert_eq!(escape_string_inner("quote\"here"), "quote\\\"here");
    }

    #[test]
    fn test_escape_reserved_word() {
        assert_eq!(escape_reserved_word("class"), "class$_");
        assert_eq!(escape_reserved_word("public"), "public$_");
        assert_eq!(escape_reserved_word("static"), "static$_");
        assert_eq!(escape_reserved_word("void"), "void$_");
        assert_eq!(escape_reserved_word("return"), "return$_");

        // Non-reserved words unchanged
        assert_eq!(escape_reserved_word("myClass"), "myClass");
        assert_eq!(escape_reserved_word("foo"), "foo");
    }
}
