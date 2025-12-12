//! Access flags to Java modifier strings
//!
//! Converts DEX access flags to Java source code modifiers.

/// Access flag constants (from DEX format)
pub mod flags {
    pub const ACC_PUBLIC: u32 = 0x0001;
    pub const ACC_PRIVATE: u32 = 0x0002;
    pub const ACC_PROTECTED: u32 = 0x0004;
    pub const ACC_STATIC: u32 = 0x0008;
    pub const ACC_FINAL: u32 = 0x0010;
    pub const ACC_SYNCHRONIZED: u32 = 0x0020;
    pub const ACC_VOLATILE: u32 = 0x0040;
    pub const ACC_BRIDGE: u32 = 0x0040;
    pub const ACC_TRANSIENT: u32 = 0x0080;
    pub const ACC_VARARGS: u32 = 0x0080;
    pub const ACC_NATIVE: u32 = 0x0100;
    pub const ACC_INTERFACE: u32 = 0x0200;
    pub const ACC_ABSTRACT: u32 = 0x0400;
    pub const ACC_STRICT: u32 = 0x0800;
    pub const ACC_SYNTHETIC: u32 = 0x1000;
    pub const ACC_ANNOTATION: u32 = 0x2000;
    pub const ACC_ENUM: u32 = 0x4000;
    pub const ACC_CONSTRUCTOR: u32 = 0x10000;
    pub const ACC_DECLARED_SYNCHRONIZED: u32 = 0x20000;
}

use flags::*;

/// Access flag context - different contexts use different flags
#[derive(Debug, Clone, Copy, PartialEq, Eq)]
pub enum AccessContext {
    /// Class-level access flags
    Class,
    /// Method-level access flags
    Method,
    /// Field-level access flags
    Field,
}

/// Convert access flags to a modifier string for Java source
pub fn access_flags_to_string(flags: u32, context: AccessContext) -> String {
    let mut parts = Vec::new();

    // Visibility (same for all contexts)
    if flags & ACC_PUBLIC != 0 {
        parts.push("public");
    } else if flags & ACC_PRIVATE != 0 {
        parts.push("private");
    } else if flags & ACC_PROTECTED != 0 {
        parts.push("protected");
    }
    // package-private has no keyword

    // Static (all contexts)
    if flags & ACC_STATIC != 0 {
        parts.push("static");
    }

    match context {
        AccessContext::Class => {
            // Final (but not for enums, and interface is implicitly abstract)
            if flags & ACC_FINAL != 0 && flags & ACC_ENUM == 0 {
                parts.push("final");
            }
            // Abstract (but not for interfaces, they're implicitly abstract)
            if flags & ACC_ABSTRACT != 0 && flags & ACC_INTERFACE == 0 {
                parts.push("abstract");
            }
            // strictfp
            if flags & ACC_STRICT != 0 {
                parts.push("strictfp");
            }
        }
        AccessContext::Method => {
            // Final
            if flags & ACC_FINAL != 0 {
                parts.push("final");
            }
            // synchronized
            if flags & ACC_SYNCHRONIZED != 0 {
                parts.push("synchronized");
            }
            // native
            if flags & ACC_NATIVE != 0 {
                parts.push("native");
            }
            // abstract
            if flags & ACC_ABSTRACT != 0 {
                parts.push("abstract");
            }
            // strictfp
            if flags & ACC_STRICT != 0 {
                parts.push("strictfp");
            }
        }
        AccessContext::Field => {
            // Final
            if flags & ACC_FINAL != 0 {
                parts.push("final");
            }
            // volatile
            if flags & ACC_VOLATILE != 0 {
                parts.push("volatile");
            }
            // transient
            if flags & ACC_TRANSIENT != 0 {
                parts.push("transient");
            }
        }
    }

    if parts.is_empty() {
        String::new()
    } else {
        parts.join(" ") + " "
    }
}

/// Check if flags represent an interface
pub fn is_interface(flags: u32) -> bool {
    flags & ACC_INTERFACE != 0
}

/// Check if flags represent an enum
pub fn is_enum(flags: u32) -> bool {
    flags & ACC_ENUM != 0
}

/// Check if flags represent an annotation
pub fn is_annotation(flags: u32) -> bool {
    flags & ACC_ANNOTATION != 0
}

/// Check if flags represent a synthetic element
pub fn is_synthetic(flags: u32) -> bool {
    flags & ACC_SYNTHETIC != 0
}

/// Check if this is a bridge method
pub fn is_bridge(flags: u32) -> bool {
    flags & ACC_BRIDGE != 0
}

/// Check if this method has varargs
pub fn is_varargs(flags: u32) -> bool {
    flags & ACC_VARARGS != 0
}

/// Get the class type keyword (class, interface, enum, @interface)
pub fn class_type_keyword(flags: u32) -> &'static str {
    if is_annotation(flags) {
        "@interface"
    } else if is_interface(flags) {
        "interface"
    } else if is_enum(flags) {
        "enum"
    } else {
        "class"
    }
}

#[cfg(test)]
mod tests {
    use super::*;

    #[test]
    fn test_public_class() {
        let result = access_flags_to_string(ACC_PUBLIC, AccessContext::Class);
        assert_eq!(result, "public ");
    }

    #[test]
    fn test_public_final_class() {
        let result = access_flags_to_string(ACC_PUBLIC | ACC_FINAL, AccessContext::Class);
        assert_eq!(result, "public final ");
    }

    #[test]
    fn test_public_abstract_class() {
        let result = access_flags_to_string(ACC_PUBLIC | ACC_ABSTRACT, AccessContext::Class);
        assert_eq!(result, "public abstract ");
    }

    #[test]
    fn test_interface_no_abstract() {
        // Interface should not emit "abstract" keyword
        let result = access_flags_to_string(ACC_PUBLIC | ACC_INTERFACE | ACC_ABSTRACT, AccessContext::Class);
        assert_eq!(result, "public ");
    }

    #[test]
    fn test_enum_no_final() {
        // Enum should not emit "final" keyword
        let result = access_flags_to_string(ACC_PUBLIC | ACC_ENUM | ACC_FINAL, AccessContext::Class);
        assert_eq!(result, "public ");
    }

    #[test]
    fn test_private_static_method() {
        let result = access_flags_to_string(ACC_PRIVATE | ACC_STATIC, AccessContext::Method);
        assert_eq!(result, "private static ");
    }

    #[test]
    fn test_volatile_field() {
        let result = access_flags_to_string(ACC_PRIVATE | ACC_VOLATILE, AccessContext::Field);
        assert_eq!(result, "private volatile ");
    }

    #[test]
    fn test_class_type_keywords() {
        assert_eq!(class_type_keyword(0), "class");
        assert_eq!(class_type_keyword(ACC_INTERFACE), "interface");
        assert_eq!(class_type_keyword(ACC_ENUM), "enum");
        assert_eq!(class_type_keyword(ACC_ANNOTATION | ACC_INTERFACE), "@interface");
    }
}
