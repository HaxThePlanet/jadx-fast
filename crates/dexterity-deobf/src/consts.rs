//! JADX constants for deobfuscation
//!
//! JADX Reference: jadx-core/src/main/java/jadx/core/Consts.java
//! Cloned from JADX's Consts class exactly for parity.
//!
//! These constants are used throughout the deobfuscation pipeline to ensure
//! identical behavior with JADX output.

/// Default package name for classes in the default (unnamed) package.
///
/// JADX Reference: Consts.DEFAULT_PACKAGE_NAME = "defpackage"
/// When a class has no package (e.g., just "MyClass" instead of "com.example.MyClass"),
/// JADX moves it to this synthetic package for valid Java output.
pub const DEFAULT_PACKAGE_NAME: &str = "defpackage";

/// Prefix for anonymous class aliases.
///
/// JADX Reference: Consts.ANONYMOUS_CLASS_PREFIX = "AnonymousClass"
/// When a class name consists only of digits (e.g., "1", "2", "123"),
/// JADX prefixes it with this string to make it a valid Java identifier.
/// Example: Class "1" becomes "AnonymousClass1"
pub const ANONYMOUS_CLASS_PREFIX: &str = "AnonymousClass";

/// toString() method signature for detection.
///
/// JADX Reference: Consts.MTH_TOSTRING_SIGNATURE = "toString()Ljava/lang/String;"
pub const MTH_TOSTRING_SIGNATURE: &str = "toString()Ljava/lang/String;";

/// Override annotation type descriptor.
///
/// JADX Reference: Consts.OVERRIDE_ANNOTATION = "Ljava/lang/Override;"
pub const OVERRIDE_ANNOTATION: &str = "Ljava/lang/Override;";

/// Common Java class types used in deobfuscation.
///
/// JADX Reference: Various CLASS_* constants in Consts.java
pub mod java_types {
    /// java.lang.Object
    pub const CLASS_OBJECT: &str = "java.lang.Object";
    /// java.lang.String
    pub const CLASS_STRING: &str = "java.lang.String";
    /// java.lang.Class
    pub const CLASS_CLASS: &str = "java.lang.Class";
    /// java.lang.Throwable
    pub const CLASS_THROWABLE: &str = "java.lang.Throwable";
    /// java.lang.Error
    pub const CLASS_ERROR: &str = "java.lang.Error";
    /// java.lang.Exception
    pub const CLASS_EXCEPTION: &str = "java.lang.Exception";
    /// java.lang.RuntimeException
    pub const CLASS_RUNTIME_EXCEPTION: &str = "java.lang.RuntimeException";
    /// java.lang.Enum
    pub const CLASS_ENUM: &str = "java.lang.Enum";
    /// java.lang.StringBuilder
    pub const CLASS_STRING_BUILDER: &str = "java.lang.StringBuilder";
}

/// Pattern for anonymous class names (pure digit names).
///
/// JADX Reference: RenameVisitor.ANONYMOUS_CLASS_PATTERN = Pattern.compile("^\\d+$")
/// Matches class names that consist entirely of digits.
///
/// Examples:
/// - "1" -> matches (anonymous class)
/// - "123" -> matches (anonymous class)
/// - "a1" -> no match (has letters)
/// - "1a" -> no match (has letters)
/// - "" -> no match (empty)
pub fn is_anonymous_class_name(name: &str) -> bool {
    !name.is_empty() && name.chars().all(|c| c.is_ascii_digit())
}

/// Prefix added to class names that start with a digit or $.
///
/// JADX Reference: RenameVisitor.fixClsShortName() uses 'C' prefix
/// When a class name starts with a digit or $, JADX prefixes it with 'C'.
pub const CLASS_NAME_PREFIX: char = 'C';

#[cfg(test)]
mod tests {
    use super::*;

    #[test]
    fn test_constants_match_jadx() {
        // Verify our constants match JADX exactly
        assert_eq!(DEFAULT_PACKAGE_NAME, "defpackage");
        assert_eq!(ANONYMOUS_CLASS_PREFIX, "AnonymousClass");
        assert_eq!(MTH_TOSTRING_SIGNATURE, "toString()Ljava/lang/String;");
        assert_eq!(OVERRIDE_ANNOTATION, "Ljava/lang/Override;");
    }

    #[test]
    fn test_is_anonymous_class_name() {
        // JADX: Pattern.compile("^\\d+$")

        // These are anonymous class names (all digits)
        assert!(is_anonymous_class_name("1"));
        assert!(is_anonymous_class_name("2"));
        assert!(is_anonymous_class_name("123"));
        assert!(is_anonymous_class_name("999999"));

        // These are NOT anonymous class names
        assert!(!is_anonymous_class_name(""));        // empty
        assert!(!is_anonymous_class_name("a"));       // letter
        assert!(!is_anonymous_class_name("a1"));      // starts with letter
        assert!(!is_anonymous_class_name("1a"));      // ends with letter
        assert!(!is_anonymous_class_name("1$"));      // has $
        assert!(!is_anonymous_class_name("$1"));      // starts with $
        assert!(!is_anonymous_class_name("Foo"));     // normal name
        assert!(!is_anonymous_class_name("Foo1"));    // normal name with digit
    }

    #[test]
    fn test_java_types() {
        use java_types::*;

        assert_eq!(CLASS_OBJECT, "java.lang.Object");
        assert_eq!(CLASS_STRING, "java.lang.String");
        assert_eq!(CLASS_THROWABLE, "java.lang.Throwable");
        assert_eq!(CLASS_ENUM, "java.lang.Enum");
    }
}
