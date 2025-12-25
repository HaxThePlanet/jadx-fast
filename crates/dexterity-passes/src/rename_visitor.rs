//! Rename visitor for handling invalid Java identifiers
//!
//! Clone of JADX RenameVisitor.java and NameMapper.java
//! Source: jadx-core/src/main/java/jadx/core/dex/visitors/rename/RenameVisitor.java (256 lines)
//! Source: jadx-core/src/main/java/jadx/core/deobf/NameMapper.java (199 lines)
//!
//! This module handles:
//! - Detecting invalid Java identifiers (reserved words, unprintable chars)
//! - Renaming classes with numeric names (anonymous class pattern)
//! - Renaming fields/methods with invalid characters
//! - Collision detection for duplicate names
//! - Case-insensitive filesystem handling

use std::collections::HashSet;
use lazy_static::lazy_static;
use regex::Regex;

// =============================================================================
// JADX NameMapper Clone
// =============================================================================

lazy_static! {
    /// Valid Java identifier pattern
    /// JADX Reference: NameMapper.VALID_JAVA_IDENTIFIER
    static ref VALID_JAVA_IDENTIFIER: Regex = Regex::new(r"^[\p{L}_$][\p{L}\p{N}_$]*$").unwrap();

    /// Valid Java full identifier (with dots)
    /// JADX Reference: NameMapper.VALID_JAVA_FULL_IDENTIFIER
    static ref VALID_JAVA_FULL_IDENTIFIER: Regex =
        Regex::new(r"^([\p{L}_$][\p{L}\p{N}_$]*\.)*[\p{L}_$][\p{L}\p{N}_$]*$").unwrap();

    /// Anonymous class pattern: just digits like "1", "2", "123"
    /// JADX Reference: RenameVisitor.ANONYMOUS_CLASS_PATTERN
    static ref ANONYMOUS_CLASS_PATTERN: Regex = Regex::new(r"^\d+$").unwrap();

    /// Reserved Java keywords that cannot be used as identifiers
    /// JADX Reference: NameMapper.RESERVED_NAMES
    static ref RESERVED_NAMES: HashSet<&'static str> = {
        let mut set = HashSet::new();
        set.insert("_");
        set.insert("abstract");
        set.insert("assert");
        set.insert("boolean");
        set.insert("break");
        set.insert("byte");
        set.insert("case");
        set.insert("catch");
        set.insert("char");
        set.insert("class");
        set.insert("const");
        set.insert("continue");
        set.insert("default");
        set.insert("do");
        set.insert("double");
        set.insert("else");
        set.insert("enum");
        set.insert("extends");
        set.insert("false");
        set.insert("final");
        set.insert("finally");
        set.insert("float");
        set.insert("for");
        set.insert("goto");
        set.insert("if");
        set.insert("implements");
        set.insert("import");
        set.insert("instanceof");
        set.insert("int");
        set.insert("interface");
        set.insert("long");
        set.insert("native");
        set.insert("new");
        set.insert("null");
        set.insert("package");
        set.insert("private");
        set.insert("protected");
        set.insert("public");
        set.insert("return");
        set.insert("short");
        set.insert("static");
        set.insert("strictfp");
        set.insert("super");
        set.insert("switch");
        set.insert("synchronized");
        set.insert("this");
        set.insert("throw");
        set.insert("throws");
        set.insert("transient");
        set.insert("true");
        set.insert("try");
        set.insert("void");
        set.insert("volatile");
        set.insert("while");
        set
    };
}

/// Anonymous class prefix used when renaming numeric class names
/// JADX Reference: Consts.ANONYMOUS_CLASS_PREFIX
pub const ANONYMOUS_CLASS_PREFIX: &str = "AnonymousClass";

/// Default package name when package is empty
/// JADX Reference: Consts.DEFAULT_PACKAGE_NAME
pub const DEFAULT_PACKAGE_NAME: &str = "defpackage";

// =============================================================================
// NameMapper Functions
// =============================================================================

/// Check if a string is a Java reserved word
///
/// JADX Reference: NameMapper.isReserved()
pub fn is_reserved(s: &str) -> bool {
    RESERVED_NAMES.contains(s)
}

/// Check if a string is a valid Java identifier
///
/// JADX Reference: NameMapper.isValidIdentifier()
pub fn is_valid_identifier(s: &str) -> bool {
    !s.is_empty() && !is_reserved(s) && VALID_JAVA_IDENTIFIER.is_match(s)
}

/// Check if a string is a valid Java full identifier (with dots)
///
/// JADX Reference: NameMapper.isValidFullIdentifier()
pub fn is_valid_full_identifier(s: &str) -> bool {
    !s.is_empty() && !is_reserved(s) && VALID_JAVA_FULL_IDENTIFIER.is_match(s)
}

/// Check if a code point is valid as a Java identifier start
///
/// JADX Reference: NameMapper.isValidIdentifierStart()
pub fn is_valid_identifier_start(c: char) -> bool {
    c.is_alphabetic() || c == '_' || c == '$'
}

/// Check if a code point is valid as a Java identifier part
///
/// JADX Reference: NameMapper.isValidIdentifierPart()
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

/// Check if all characters in a string are printable ASCII
///
/// JADX Reference: NameMapper.isAllCharsPrintable()
pub fn is_all_chars_printable(s: &str) -> bool {
    s.chars().all(is_printable_ascii)
}

/// Check if a string is both a valid identifier and all printable
///
/// JADX Reference: NameMapper.isValidAndPrintable()
pub fn is_valid_and_printable(s: &str) -> bool {
    is_valid_identifier(s) && is_all_chars_printable(s)
}

/// Remove invalid characters from the middle of a name
/// Note: Result may start with invalid start char (e.g., digits)
///
/// JADX Reference: NameMapper.removeInvalidCharsMiddle()
pub fn remove_invalid_chars_middle(name: &str) -> String {
    if is_valid_identifier(name) && is_all_chars_printable(name) {
        return name.to_string();
    }

    name.chars()
        .filter(|&c| is_printable_ascii(c) && is_valid_identifier_part(c))
        .collect()
}

/// Remove invalid characters from a name, prepending prefix if needed
///
/// JADX Reference: NameMapper.removeInvalidChars()
pub fn remove_invalid_chars(name: &str, prefix: &str) -> String {
    let result = remove_invalid_chars_middle(name);
    if !result.is_empty() {
        let first_char = result.chars().next().unwrap();
        if !is_valid_identifier_start(first_char) {
            return format!("{}{}", prefix, result);
        }
    }
    result
}

/// Remove non-printable characters from a string
///
/// JADX Reference: NameMapper.removeNonPrintableCharacters()
pub fn remove_non_printable_chars(name: &str) -> String {
    name.chars().filter(|&c| is_printable_ascii(c)).collect()
}

// =============================================================================
// RenameVisitor Functions
// =============================================================================

/// Result of rename processing
#[derive(Debug, Default)]
pub struct RenameResult {
    /// Number of classes renamed
    pub classes_renamed: u32,
    /// Number of fields renamed
    pub fields_renamed: u32,
    /// Number of methods renamed
    pub methods_renamed: u32,
    /// Number of packages renamed
    pub packages_renamed: u32,
    /// Rename reasons (for logging/debugging)
    pub reasons: Vec<RenameReason>,
}

/// Reason for a rename
#[derive(Debug, Clone)]
pub struct RenameReason {
    /// Original name
    pub original: String,
    /// New name after rename
    pub new_name: String,
    /// Why it was renamed
    pub reason: RenameReasonType,
}

/// Type of rename reason
#[derive(Debug, Clone, PartialEq, Eq)]
pub enum RenameReasonType {
    /// Invalid Java identifier
    InvalidIdentifier,
    /// Contains non-printable characters
    NonPrintable,
    /// Anonymous class (numeric name)
    AnonymousClass,
    /// Invalid first character ($ or digit)
    InvalidFirstChar,
    /// Collision with another name
    NameCollision,
    /// Collision with reserved keyword
    ReservedKeyword,
    /// Case-insensitive filesystem collision
    CaseInsensitive,
}

/// Fix a class short name, returning None if completely unfixable
///
/// JADX Reference: RenameVisitor.fixClsShortName()
pub fn fix_class_short_name(cls_name: &str, rename_valid: bool, rename_printable: bool) -> Option<String> {
    if cls_name.is_empty() {
        return None;
    }

    if rename_valid {
        // JADX: Anonymous class pattern: ^\\d+$
        if ANONYMOUS_CLASS_PATTERN.is_match(cls_name) {
            return Some(format!("{}{}", ANONYMOUS_CLASS_PREFIX, remove_invalid_chars_middle(cls_name)));
        }

        // JADX: Invalid first char ($ or digit)
        let first_char = cls_name.chars().next().unwrap();
        if first_char == '$' || first_char.is_ascii_digit() {
            return Some(format!("C{}", remove_invalid_chars_middle(cls_name)));
        }
    }

    // Clean non-printable chars
    let clean_cls_name = if rename_printable {
        remove_non_printable_chars(cls_name)
    } else {
        cls_name.to_string()
    };

    if clean_cls_name.is_empty() {
        return None;
    }

    if rename_valid {
        let cleaned = remove_invalid_chars(cls_name, "C");
        if !is_valid_identifier(&cleaned) {
            return Some(format!("C{}", cleaned));
        }
        return Some(cleaned);
    }

    Some(clean_cls_name)
}

/// Fix a field name, returning None if completely unfixable
///
/// JADX Reference: RenameVisitor.checkFields() logic
pub fn fix_field_name(field_name: &str, rename_valid: bool, rename_printable: bool) -> Option<String> {
    if field_name.is_empty() {
        return None;
    }

    let not_valid = rename_valid && !is_valid_identifier(field_name);
    let not_printable = rename_printable && !is_all_chars_printable(field_name);

    if not_valid || not_printable {
        let cleaned = remove_invalid_chars(field_name, "f");
        if cleaned.is_empty() {
            return None;
        }
        return Some(cleaned);
    }

    Some(field_name.to_string())
}

/// Fix a method name, returning None if completely unfixable
///
/// JADX Reference: RenameVisitor.checkMethods() logic
pub fn fix_method_name(method_name: &str, rename_valid: bool, rename_printable: bool) -> Option<String> {
    if method_name.is_empty() {
        return None;
    }

    // Skip constructors
    if method_name == "<init>" || method_name == "<clinit>" {
        return Some(method_name.to_string());
    }

    let not_valid = rename_valid && !is_valid_identifier(method_name);
    let not_printable = rename_printable && !is_all_chars_printable(method_name);

    if not_valid || not_printable {
        let cleaned = remove_invalid_chars(method_name, "m");
        if cleaned.is_empty() {
            return None;
        }
        return Some(cleaned);
    }

    Some(method_name.to_string())
}

/// Fix a package name, returning None if completely unfixable
///
/// JADX Reference: RenameVisitor.checkPackage() logic
pub fn fix_package_name(pkg_name: &str, rename_valid: bool, rename_printable: bool) -> Option<String> {
    if pkg_name.is_empty() {
        // JADX: Use default package name for empty packages
        if rename_valid {
            return Some(DEFAULT_PACKAGE_NAME.to_string());
        }
        return None;
    }

    let not_valid = rename_valid && !is_valid_identifier(pkg_name);
    let not_printable = rename_printable && !is_all_chars_printable(pkg_name);

    if not_valid || not_printable {
        let cleaned = remove_invalid_chars(pkg_name, "p");
        if cleaned.is_empty() {
            return None;
        }
        return Some(cleaned);
    }

    Some(pkg_name.to_string())
}

/// Alias provider for generating unique names
///
/// JADX Reference: IAliasProvider interface
pub struct AliasProvider {
    counter: u32,
    prefix: String,
}

impl AliasProvider {
    pub fn new(prefix: &str) -> Self {
        Self {
            counter: 0,
            prefix: prefix.to_string(),
        }
    }

    /// Generate a new unique alias
    pub fn next(&mut self) -> String {
        self.counter += 1;
        format!("{}{}", self.prefix, self.counter)
    }

    /// Generate alias for a class
    pub fn for_class(&mut self) -> String {
        self.counter += 1;
        format!("C{:04x}", self.counter)
    }

    /// Generate alias for a field
    pub fn for_field(&mut self) -> String {
        self.counter += 1;
        format!("f{:04x}", self.counter)
    }

    /// Generate alias for a method
    pub fn for_method(&mut self) -> String {
        self.counter += 1;
        format!("m{:04x}", self.counter)
    }

    /// Generate alias for a package
    pub fn for_package(&mut self) -> String {
        self.counter += 1;
        format!("p{:04x}", self.counter)
    }
}

// =============================================================================
// Class Name Checking with Collision Detection
// =============================================================================

/// Check and fix class names, handling collisions
///
/// JADX Reference: RenameVisitor.checkClassName()
pub fn check_class_name(
    cls_name: &str,
    parent_class_names: &[&str],
    used_names: &mut HashSet<String>,
    alias_provider: &mut AliasProvider,
    rename_valid: bool,
    rename_printable: bool,
) -> (String, Option<RenameReason>) {
    // Try to fix the name first
    let fixed = match fix_class_short_name(cls_name, rename_valid, rename_printable) {
        Some(fixed) if fixed != cls_name => {
            let reason = if ANONYMOUS_CLASS_PATTERN.is_match(cls_name) {
                RenameReasonType::AnonymousClass
            } else {
                RenameReasonType::InvalidIdentifier
            };
            (fixed, Some(RenameReason {
                original: cls_name.to_string(),
                new_name: String::new(), // Will be filled below
                reason,
            }))
        }
        Some(fixed) => (fixed, None),
        None => {
            // Completely unfixable, use deobfuscator
            let new_name = alias_provider.for_class();
            return (new_name.clone(), Some(RenameReason {
                original: cls_name.to_string(),
                new_name,
                reason: RenameReasonType::NonPrintable,
            }));
        }
    };

    let (mut new_name, reason_opt) = fixed;

    // Check for collision with parent class names
    if rename_valid {
        for parent_name in parent_class_names {
            if *parent_name == new_name {
                let alias = alias_provider.for_class();
                return (alias.clone(), Some(RenameReason {
                    original: cls_name.to_string(),
                    new_name: alias,
                    reason: RenameReasonType::NameCollision,
                }));
            }
        }
    }

    // Check for collision with already-used names
    if used_names.contains(&new_name) {
        let alias = alias_provider.for_class();
        return (alias.clone(), Some(RenameReason {
            original: cls_name.to_string(),
            new_name: alias,
            reason: RenameReasonType::NameCollision,
        }));
    }

    used_names.insert(new_name.clone());

    // Update the new_name in reason if we have one
    if let Some(mut reason) = reason_opt {
        reason.new_name = new_name.clone();
        return (new_name, Some(reason));
    }

    (new_name, None)
}

/// Check for case-insensitive filesystem collisions
///
/// JADX Reference: RenameVisitor.checkNames() case sensitivity logic
pub fn check_case_insensitive_collision(
    full_path: &str,
    used_paths: &mut HashSet<String>,
    alias_provider: &mut AliasProvider,
) -> Option<String> {
    let lower_path = full_path.to_lowercase();
    if used_paths.contains(&lower_path) {
        let new_name = alias_provider.for_class();
        used_paths.insert(format!("{}.java", new_name).to_lowercase());
        Some(new_name)
    } else {
        used_paths.insert(lower_path);
        None
    }
}

// =============================================================================
// Tests
// =============================================================================

#[cfg(test)]
mod tests {
    use super::*;

    #[test]
    fn test_is_reserved() {
        assert!(is_reserved("class"));
        assert!(is_reserved("void"));
        assert!(is_reserved("_"));
        assert!(!is_reserved("myClass"));
        assert!(!is_reserved("main"));
    }

    #[test]
    fn test_is_valid_identifier() {
        assert!(is_valid_identifier("myVar"));
        assert!(is_valid_identifier("MyClass"));
        assert!(is_valid_identifier("_private"));
        assert!(is_valid_identifier("$field"));
        assert!(!is_valid_identifier("123abc"));
        assert!(!is_valid_identifier("class"));
        assert!(!is_valid_identifier("my-var"));
        assert!(!is_valid_identifier(""));
    }

    #[test]
    fn test_is_all_chars_printable() {
        assert!(is_all_chars_printable("hello"));
        assert!(is_all_chars_printable("Hello123"));
        assert!(!is_all_chars_printable("hello\x00"));
        assert!(!is_all_chars_printable("hello\u{200B}")); // Zero-width space
    }

    #[test]
    fn test_remove_invalid_chars_middle() {
        assert_eq!(remove_invalid_chars_middle("hello"), "hello");
        assert_eq!(remove_invalid_chars_middle("hello-world"), "helloworld");
        assert_eq!(remove_invalid_chars_middle("123abc"), "123abc");
    }

    #[test]
    fn test_remove_invalid_chars() {
        assert_eq!(remove_invalid_chars("hello", "C"), "hello");
        assert_eq!(remove_invalid_chars("123abc", "C"), "C123abc");
        assert_eq!(remove_invalid_chars("$abc", "C"), "$abc"); // $ is valid
    }

    #[test]
    fn test_fix_class_short_name_anonymous() {
        // Anonymous class: "1" -> "AnonymousClass1"
        let fixed = fix_class_short_name("1", true, true);
        assert_eq!(fixed, Some("AnonymousClass1".to_string()));

        let fixed = fix_class_short_name("123", true, true);
        assert_eq!(fixed, Some("AnonymousClass123".to_string()));
    }

    #[test]
    fn test_fix_class_short_name_dollar() {
        // Dollar start: "$Inner" -> stays "$Inner" ($ is valid)
        let fixed = fix_class_short_name("$Inner", true, true);
        assert_eq!(fixed, Some("C$Inner".to_string()));
    }

    #[test]
    fn test_fix_class_short_name_valid() {
        // Valid name: unchanged
        let fixed = fix_class_short_name("MyClass", true, true);
        assert_eq!(fixed, Some("MyClass".to_string()));
    }

    #[test]
    fn test_fix_field_name() {
        assert_eq!(fix_field_name("myField", true, true), Some("myField".to_string()));
        assert_eq!(fix_field_name("123field", true, true), Some("f123field".to_string()));
    }

    #[test]
    fn test_fix_method_name() {
        assert_eq!(fix_method_name("myMethod", true, true), Some("myMethod".to_string()));
        assert_eq!(fix_method_name("<init>", true, true), Some("<init>".to_string()));
        assert_eq!(fix_method_name("123method", true, true), Some("m123method".to_string()));
    }

    #[test]
    fn test_alias_provider() {
        let mut provider = AliasProvider::new("Test");
        assert_eq!(provider.next(), "Test1");
        assert_eq!(provider.next(), "Test2");
        assert_eq!(provider.for_class(), "C0003");
        assert_eq!(provider.for_field(), "f0004");
    }
}
