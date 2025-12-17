//! Type to Java source code conversion
//!
//! Converts dexterity-ir types to Java type strings.

use dexterity_ir::ArgType;
use crate::dex_info::replace_inner_class_separator;

/// Convert an ArgType to its Java source representation (fully qualified)
pub fn type_to_string(ty: &ArgType) -> String {
    type_to_string_with_imports(ty, None)
}

/// Convert an ArgType to Java source, using simple names for imported types
pub fn type_to_string_with_imports(ty: &ArgType, imports: Option<&std::collections::BTreeSet<String>>) -> String {
    type_to_string_with_imports_and_package(ty, imports, None)
}

/// Convert an ArgType to Java source, using simple names for imported and same-package types
pub fn type_to_string_with_imports_and_package(
    ty: &ArgType,
    imports: Option<&std::collections::BTreeSet<String>>,
    current_package: Option<&str>,
) -> String {
    match ty {
        ArgType::Void => "void".to_string(),
        ArgType::Boolean => "boolean".to_string(),
        ArgType::Byte => "byte".to_string(),
        ArgType::Char => "char".to_string(),
        ArgType::Short => "short".to_string(),
        ArgType::Int => "int".to_string(),
        ArgType::Long => "long".to_string(),
        ArgType::Float => "float".to_string(),
        ArgType::Double => "double".to_string(),
        ArgType::Object(name) => object_to_java_name_with_imports_and_package(name, imports, current_package),
        ArgType::Array(elem) => format!("{}[]", type_to_string_with_imports_and_package(elem, imports, current_package)),
        ArgType::Generic { base, params } => {
            let base_name = object_to_java_name_with_imports_and_package(base, imports, current_package);
            if params.is_empty() {
                base_name
            } else {
                let param_str: Vec<_> = params.iter()
                    .map(|t| type_to_string_with_imports_and_package(t, imports, current_package))
                    .collect();
                format!("{}<{}>", base_name, param_str.join(", "))
            }
        }
        ArgType::Wildcard { bound, inner } => {
            use dexterity_ir::types::WildcardBound;
            match (bound, inner) {
                (WildcardBound::Unbounded, _) => "?".to_string(),
                (WildcardBound::Extends, Some(t)) => format!("? extends {}", type_to_string_with_imports_and_package(t, imports, current_package)),
                (WildcardBound::Super, Some(t)) => format!("? super {}", type_to_string_with_imports_and_package(t, imports, current_package)),
                _ => "?".to_string(),
            }
        }
        ArgType::TypeVariable(name) => name.clone(),
        // JADX-compatible fallback: Unknown types become Object with warning comment
        // This ensures generated code compiles even when type inference fails
        ArgType::Unknown => "Object /* JADX WARNING: Unknown type */".to_string(),
        // Partial type inference results - use best guess based on constraints
        ArgType::UnknownNarrow => "int /* JADX INFO: Narrow type unknown */".to_string(),
        ArgType::UnknownWide => "long /* JADX INFO: Wide type unknown */".to_string(),
        ArgType::UnknownObject => "Object /* JADX INFO: Object type unknown */".to_string(),
        ArgType::UnknownArray => "Object[] /* JADX INFO: Array type unknown */".to_string(),
        ArgType::UnknownIntegral => "int /* JADX INFO: Integral type */".to_string(),
    }
}

/// Convert an internal class name to Java source format
/// e.g., "java/lang/String" -> "String" (for common types)
/// or "com/example/Foo" -> "com.example.Foo" (full qualified)
pub fn object_to_java_name(internal: &str) -> String {
    object_to_java_name_with_imports(internal, None)
}

/// Convert an internal class name to Java source format, using simple names when imported
pub fn object_to_java_name_with_imports(internal: &str, imports: Option<&std::collections::BTreeSet<String>>) -> String {
    object_to_java_name_with_imports_and_package(internal, imports, None)
}

/// Convert an internal class name to Java source format, using simple names for imported and same-package types
pub fn object_to_java_name_with_imports_and_package(
    internal: &str,
    imports: Option<&std::collections::BTreeSet<String>>,
    current_package: Option<&str>,
) -> String {
    // Strip L prefix and ; suffix if present
    let stripped = internal
        .strip_prefix('L')
        .unwrap_or(internal)
        .strip_suffix(';')
        .unwrap_or(internal);

    // Handle common java.lang types with short names
    if let Some(simple) = get_java_lang_short_name(stripped) {
        return simple.to_string();
    }

    // Check if type is imported - if so, use simple name
    if let Some(imported_types) = imports {
        if imported_types.contains(stripped) {
            // Return just the simple class name (handle inner classes with $)
            if let Some(simple) = stripped.rsplit('/').next() {
                // Convert $ to . for inner class notation (R$layout -> R.layout), but preserve $$
                return replace_inner_class_separator(simple);
            }
        }
    }

    // Check if type is in the same package - if so, use simple name (MEDIUM-001 fix)
    if let Some(pkg) = current_package {
        if let Some(type_pkg) = get_package_internal(stripped) {
            if type_pkg == pkg {
                // Same package - use simple name
                if let Some(simple) = stripped.rsplit('/').next() {
                    return replace_inner_class_separator(simple);
                }
            }
        }
    }

    // Convert / to . for package separator and $ to . for inner classes
    // This converts "com/example/R$layout" to "com.example.R.layout", but preserves $$
    replace_inner_class_separator(&stripped.replace('/', "."))
}

/// Get package from internal name without L; wrapping (helper for same-package detection)
fn get_package_internal(internal: &str) -> Option<String> {
    let pos = internal.rfind('/')?;
    Some(internal[..pos].replace('/', "."))
}

/// Get short name for java.lang classes (no import needed)
fn get_java_lang_short_name(internal: &str) -> Option<&'static str> {
    match internal {
        "java/lang/Object" => Some("Object"),
        "java/lang/String" => Some("String"),
        "java/lang/Class" => Some("Class"),
        "java/lang/Integer" => Some("Integer"),
        "java/lang/Long" => Some("Long"),
        "java/lang/Float" => Some("Float"),
        "java/lang/Double" => Some("Double"),
        "java/lang/Boolean" => Some("Boolean"),
        "java/lang/Byte" => Some("Byte"),
        "java/lang/Short" => Some("Short"),
        "java/lang/Character" => Some("Character"),
        "java/lang/Void" => Some("Void"),
        "java/lang/Number" => Some("Number"),
        "java/lang/Throwable" => Some("Throwable"),
        "java/lang/Exception" => Some("Exception"),
        "java/lang/RuntimeException" => Some("RuntimeException"),
        "java/lang/Error" => Some("Error"),
        "java/lang/Thread" => Some("Thread"),
        "java/lang/Runnable" => Some("Runnable"),
        "java/lang/StringBuilder" => Some("StringBuilder"),
        "java/lang/StringBuffer" => Some("StringBuffer"),
        "java/lang/Comparable" => Some("Comparable"),
        "java/lang/Iterable" => Some("Iterable"),
        "java/lang/Enum" => Some("Enum"),
        "java/lang/Override" => Some("Override"),
        "java/lang/Deprecated" => Some("Deprecated"),
        "java/lang/SuppressWarnings" => Some("SuppressWarnings"),
        _ => None,
    }
}

/// Strip the L and ; from a class descriptor if present
fn strip_descriptor(internal: &str) -> &str {
    let s = internal.strip_prefix('L').unwrap_or(internal);
    s.strip_suffix(';').unwrap_or(s)
}

/// Get the simple (unqualified) class name
pub fn get_simple_name(internal: &str) -> &str {
    let stripped = strip_descriptor(internal);
    stripped.rsplit('/').next().unwrap_or(stripped)
}

/// Get the simple (unqualified) class name from an ArgType
/// Returns the base type name for Object and Generic types
pub fn get_simple_name_from_argtype(ty: &ArgType) -> String {
    match ty {
        ArgType::Object(name) => get_simple_name(name).to_string(),
        ArgType::Generic { base, .. } => get_simple_name(base).to_string(),
        _ => type_to_string(ty),
    }
}

/// Get the innermost class name (for inner classes, returns just the inner part)
/// e.g., "Lcom/example/Outer$Inner;" -> "Inner"
/// e.g., "Lcom/example/Outer;" -> "Outer"
pub fn get_innermost_name(internal: &str) -> &str {
    let simple = get_simple_name(internal);
    // For inner classes like Outer$Inner, return just Inner
    simple.rsplit('$').next().unwrap_or(simple)
}

/// Get the package name from an internal class name
pub fn get_package(internal: &str) -> Option<String> {
    let stripped = strip_descriptor(internal);
    let pos = stripped.rfind('/')?;
    Some(stripped[..pos].replace('/', "."))
}

/// Convert a literal value to string representation
pub fn literal_to_string(value: i64, ty: &ArgType) -> String {
    match ty {
        ArgType::Boolean => {
            if value == 0 { "false" } else { "true" }.to_string()
        }
        ArgType::Char => {
            let c = char::from_u32(value as u32).unwrap_or('\u{FFFD}');
            escape_char(c)
        }
        ArgType::Byte => format!("(byte) {}", value as i8),
        ArgType::Short => format_short(value as i16),
        ArgType::Int => format_integer(value as i32),
        ArgType::Long => format_long(value),
        ArgType::Float => {
            let f = f32::from_bits(value as u32);
            format_float(f)
        }
        ArgType::Double => {
            let d = f64::from_bits(value as u64);
            format_double(d)
        }
        ArgType::Object(_) | ArgType::Array(_) => {
            if value == 0 {
                "null".to_string()
            } else {
                format!("{}", value)
            }
        }
        _ => format!("{}", value),
    }
}

/// Format a short literal with special value handling
fn format_short(value: i16) -> String {
    match value {
        i16::MAX => "Short.MAX_VALUE".to_string(),
        i16::MIN => "Short.MIN_VALUE".to_string(),
        _ => format!("(short) {}", value),
    }
}

/// Format an integer literal with special value handling
fn format_integer(value: i32) -> String {
    match value {
        i32::MAX => "Integer.MAX_VALUE".to_string(),
        i32::MIN => "Integer.MIN_VALUE".to_string(),
        _ => format!("{}", value),
    }
}

/// Format a long literal with special value handling
fn format_long(value: i64) -> String {
    match value {
        i64::MAX => "Long.MAX_VALUE".to_string(),
        i64::MIN => "Long.MIN_VALUE".to_string(),
        _ => format!("{}L", value),
    }
}

/// Escape a character literal
fn escape_char(c: char) -> String {
    escape_char_pub(c)
}

/// Public version of escape_char for use from body_gen.rs
pub fn escape_char_pub(c: char) -> String {
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

/// Format a float literal
fn format_float(f: f32) -> String {
    if f.is_nan() {
        "Float.NaN".to_string()
    } else if f == f32::INFINITY {
        "Float.POSITIVE_INFINITY".to_string()
    } else if f == f32::NEG_INFINITY {
        "Float.NEGATIVE_INFINITY".to_string()
    } else if f == f32::MIN_POSITIVE {
        "Float.MIN_VALUE".to_string()
    } else if f == f32::MAX {
        "Float.MAX_VALUE".to_string()
    } else if f.to_bits() == 0x0080_0000 {
        // Float.MIN_NORMAL = 1.17549435E-38f
        "Float.MIN_NORMAL".to_string()
    } else if f == 0.0 {
        if f.is_sign_negative() {
            "-0.0f".to_string()
        } else {
            "0.0f".to_string()
        }
    } else {
        format!("{}f", f)
    }
}

/// Format a double literal
fn format_double(d: f64) -> String {
    if d.is_nan() {
        "Double.NaN".to_string()
    } else if d == f64::INFINITY {
        "Double.POSITIVE_INFINITY".to_string()
    } else if d == f64::NEG_INFINITY {
        "Double.NEGATIVE_INFINITY".to_string()
    } else if d == f64::MIN_POSITIVE {
        "Double.MIN_VALUE".to_string()
    } else if d == f64::MAX {
        "Double.MAX_VALUE".to_string()
    } else if d.to_bits() == 0x0010_0000_0000_0000 {
        // Double.MIN_NORMAL = 2.2250738585072014E-308
        "Double.MIN_NORMAL".to_string()
    } else if d == 0.0 {
        if d.is_sign_negative() {
            "-0.0d".to_string()
        } else {
            "0.0d".to_string()
        }
    } else {
        format!("{}d", d)
    }
}

/// Escape a string for Java source (default: no unicode escaping)
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

#[cfg(test)]
mod tests {
    use super::*;

    #[test]
    fn test_primitive_types() {
        assert_eq!(type_to_string(&ArgType::Int), "int");
        assert_eq!(type_to_string(&ArgType::Boolean), "boolean");
        assert_eq!(type_to_string(&ArgType::Void), "void");
    }

    #[test]
    fn test_object_types() {
        assert_eq!(
            type_to_string(&ArgType::Object("java/lang/String".to_string())),
            "String"
        );
        assert_eq!(
            type_to_string(&ArgType::Object("com/example/Foo".to_string())),
            "com.example.Foo"
        );
    }

    #[test]
    fn test_array_types() {
        assert_eq!(
            type_to_string(&ArgType::Array(Box::new(ArgType::Int))),
            "int[]"
        );
        assert_eq!(
            type_to_string(&ArgType::Array(Box::new(ArgType::Array(Box::new(ArgType::Int))))),
            "int[][]"
        );
    }

    #[test]
    fn test_escape_string() {
        assert_eq!(escape_string("hello"), "\"hello\"");
        assert_eq!(escape_string("hello\nworld"), "\"hello\\nworld\"");
        assert_eq!(escape_string("say \"hi\""), "\"say \\\"hi\\\"\"");
    }

    #[test]
    fn test_literal_boolean() {
        assert_eq!(literal_to_string(0, &ArgType::Boolean), "false");
        assert_eq!(literal_to_string(1, &ArgType::Boolean), "true");
    }

    #[test]
    fn test_literal_char() {
        assert_eq!(literal_to_string('A' as i64, &ArgType::Char), "'A'");
        assert_eq!(literal_to_string('\n' as i64, &ArgType::Char), "'\\n'");
    }

    #[test]
    fn test_special_short_values() {
        assert_eq!(literal_to_string(i16::MAX as i64, &ArgType::Short), "Short.MAX_VALUE");
        assert_eq!(literal_to_string(i16::MIN as i64, &ArgType::Short), "Short.MIN_VALUE");
        assert_eq!(literal_to_string(100, &ArgType::Short), "(short) 100");
    }

    #[test]
    fn test_special_integer_values() {
        assert_eq!(literal_to_string(i32::MAX as i64, &ArgType::Int), "Integer.MAX_VALUE");
        assert_eq!(literal_to_string(i32::MIN as i64, &ArgType::Int), "Integer.MIN_VALUE");
        assert_eq!(literal_to_string(42, &ArgType::Int), "42");
    }

    #[test]
    fn test_special_long_values() {
        assert_eq!(literal_to_string(i64::MAX, &ArgType::Long), "Long.MAX_VALUE");
        assert_eq!(literal_to_string(i64::MIN, &ArgType::Long), "Long.MIN_VALUE");
        assert_eq!(literal_to_string(12345, &ArgType::Long), "12345L");
    }

    #[test]
    fn test_special_float_values() {
        let nan_bits = f32::NAN.to_bits() as i64;
        let inf_bits = f32::INFINITY.to_bits() as i64;
        let neg_inf_bits = f32::NEG_INFINITY.to_bits() as i64;
        let max_bits = f32::MAX.to_bits() as i64;
        let min_bits = f32::MIN_POSITIVE.to_bits() as i64;

        assert_eq!(literal_to_string(nan_bits, &ArgType::Float), "Float.NaN");
        assert_eq!(literal_to_string(inf_bits, &ArgType::Float), "Float.POSITIVE_INFINITY");
        assert_eq!(literal_to_string(neg_inf_bits, &ArgType::Float), "Float.NEGATIVE_INFINITY");
        assert_eq!(literal_to_string(max_bits, &ArgType::Float), "Float.MAX_VALUE");
        assert_eq!(literal_to_string(min_bits, &ArgType::Float), "Float.MIN_VALUE");

        // Regular float - test that it has 'f' suffix
        let regular = 3.0f32.to_bits() as i64;
        assert!(literal_to_string(regular, &ArgType::Float).ends_with("f"));
    }

    #[test]
    fn test_special_double_values() {
        let nan_bits = f64::NAN.to_bits() as i64;
        let inf_bits = f64::INFINITY.to_bits() as i64;
        let neg_inf_bits = f64::NEG_INFINITY.to_bits() as i64;
        let max_bits = f64::MAX.to_bits() as i64;
        let min_bits = f64::MIN_POSITIVE.to_bits() as i64;

        assert_eq!(literal_to_string(nan_bits, &ArgType::Double), "Double.NaN");
        assert_eq!(literal_to_string(inf_bits, &ArgType::Double), "Double.POSITIVE_INFINITY");
        assert_eq!(literal_to_string(neg_inf_bits, &ArgType::Double), "Double.NEGATIVE_INFINITY");
        assert_eq!(literal_to_string(max_bits, &ArgType::Double), "Double.MAX_VALUE");
        assert_eq!(literal_to_string(min_bits, &ArgType::Double), "Double.MIN_VALUE");

        // Regular double - test that it has 'd' suffix
        let regular = 3.0f64.to_bits() as i64;
        assert!(literal_to_string(regular, &ArgType::Double).ends_with("d"));
    }
}
