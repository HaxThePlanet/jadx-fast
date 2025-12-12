//! Type to Java source code conversion
//!
//! Converts jadx-ir types to Java type strings.

use jadx_ir::ArgType;

/// Convert an ArgType to its Java source representation
pub fn type_to_string(ty: &ArgType) -> String {
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
        ArgType::Object(name) => object_to_java_name(name),
        ArgType::Array(elem) => format!("{}[]", type_to_string(elem)),
        ArgType::Generic { base, params } => {
            let base_name = object_to_java_name(base);
            if params.is_empty() {
                base_name
            } else {
                let param_str: Vec<_> = params.iter().map(type_to_string).collect();
                format!("{}<{}>", base_name, param_str.join(", "))
            }
        }
        ArgType::Wildcard { bound, inner } => {
            use jadx_ir::types::WildcardBound;
            match (bound, inner) {
                (WildcardBound::Unbounded, _) => "?".to_string(),
                (WildcardBound::Extends, Some(t)) => format!("? extends {}", type_to_string(t)),
                (WildcardBound::Super, Some(t)) => format!("? super {}", type_to_string(t)),
                _ => "?".to_string(),
            }
        }
        ArgType::Unknown => "/* unknown */".to_string(),
    }
}

/// Convert an internal class name to Java source format
/// e.g., "java/lang/String" -> "String" (for common types)
/// or "com/example/Foo" -> "com.example.Foo" (full qualified)
pub fn object_to_java_name(internal: &str) -> String {
    // Handle common java.lang types with short names
    if let Some(simple) = get_java_lang_short_name(internal) {
        return simple.to_string();
    }

    // Convert / to . for package separator
    internal.replace('/', ".")
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
        ArgType::Short => format!("(short) {}", value as i16),
        ArgType::Int => format!("{}", value as i32),
        ArgType::Long => format!("{}L", value),
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

/// Escape a character literal
fn escape_char(c: char) -> String {
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
    } else if f.is_infinite() {
        if f.is_sign_positive() {
            "Float.POSITIVE_INFINITY".to_string()
        } else {
            "Float.NEGATIVE_INFINITY".to_string()
        }
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
    } else if d.is_infinite() {
        if d.is_sign_positive() {
            "Double.POSITIVE_INFINITY".to_string()
        } else {
            "Double.NEGATIVE_INFINITY".to_string()
        }
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

/// Escape a string for Java source
pub fn escape_string(s: &str) -> String {
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
}
