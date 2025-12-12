//! ProGuard mapping file parser
//!
//! Parses ProGuard/R8 mapping files to extract class, field, and method mappings.
//!
//! Format reference: https://www.guardsquare.com/manual/tools/retrace
//!
//! Example mapping file:
//! ```text
//! com.example.Original -> a:
//!     int fieldName -> a
//!     void methodName(int,java.lang.String) -> b
//!     1:10:void methodWithLineNumbers():15:24 -> c
//! ```

use crate::registry::AliasRegistry;
use std::path::Path;

/// Errors that can occur during mapping file parsing
#[derive(Debug, thiserror::Error)]
pub enum MappingError {
    #[error("IO error: {0}")]
    Io(#[from] std::io::Error),
    #[error("Parse error at line {line}: {message}")]
    Parse { line: usize, message: String },
}

/// Parse a ProGuard mapping file and populate the alias registry
///
/// The mapping file format maps obfuscated names to original names:
/// ```text
/// original.ClassName -> obfuscated.a:
///     type fieldName -> a
///     returnType methodName(paramTypes) -> b
/// ```
///
/// Note: In the file, the LEFT side is the original name and RIGHT is obfuscated.
/// We swap these because the DEX contains obfuscated names and we want to
/// display original names.
pub fn parse_proguard_mapping(content: &str, registry: &AliasRegistry) -> Result<(), MappingError> {
    let mut current_class_obfuscated: Option<String> = None;

    for (line_num, raw_line) in content.lines().enumerate() {
        let trimmed = raw_line.trim();

        // Skip empty lines and comments
        if trimmed.is_empty() || trimmed.starts_with('#') {
            continue;
        }

        // Check for leading whitespace BEFORE trimming to detect member mappings
        let is_indented = raw_line.starts_with(' ') || raw_line.starts_with('\t');

        if !is_indented && trimmed.ends_with(':') {
            // Class mapping line: "original.Class -> obfuscated:"
            current_class_obfuscated = Some(parse_class_mapping(trimmed, line_num + 1, registry)?);
        } else if is_indented {
            // Member mapping (indented): field or method
            if let Some(ref class_obf) = current_class_obfuscated {
                parse_member_mapping(trimmed, class_obf, line_num + 1, registry)?;
            }
        }
    }

    Ok(())
}

/// Parse a ProGuard mapping file from a path
pub fn parse_proguard_mapping_file(
    path: &Path,
    registry: &AliasRegistry,
) -> Result<(), MappingError> {
    let content = std::fs::read_to_string(path)?;
    parse_proguard_mapping(&content, registry)
}

/// Parse a class mapping line
///
/// Format: "com.example.Original -> a:"
/// Returns the obfuscated class name (in DEX descriptor format)
fn parse_class_mapping(
    line: &str,
    line_num: usize,
    registry: &AliasRegistry,
) -> Result<String, MappingError> {
    // Remove trailing colon
    let line = line.trim_end_matches(':');

    // Split on " -> "
    let parts: Vec<&str> = line.split(" -> ").collect();
    if parts.len() != 2 {
        return Err(MappingError::Parse {
            line: line_num,
            message: format!("Expected 'original -> obfuscated', got: {}", line),
        });
    }

    let original = parts[0].trim();
    let obfuscated = parts[1].trim();

    // Convert to DEX descriptor format: "a.b.c" -> "La/b/c;"
    let obfuscated_desc = java_name_to_descriptor(obfuscated);

    // Extract simple name from original
    // First get the last component after the last dot (removes package)
    let after_package = original.rsplit('.').next().unwrap_or(original);
    // Then for inner classes (Outer$Inner), get just the inner part
    let original_simple = after_package.rsplit('$').next().unwrap_or(after_package);

    // Store the alias: obfuscated descriptor -> original simple name
    registry.set_class_alias(&obfuscated_desc, original_simple);

    Ok(obfuscated_desc)
}

/// Parse a member mapping line (field or method)
///
/// Field format: "type fieldName -> a"
/// Method format: "returnType methodName(paramTypes) -> b"
/// Method with lines: "1:10:returnType methodName(paramTypes):15:24 -> b"
fn parse_member_mapping(
    line: &str,
    class_type: &str,
    line_num: usize,
    registry: &AliasRegistry,
) -> Result<(), MappingError> {
    // Split on " -> " to get original and obfuscated names
    let parts: Vec<&str> = line.split(" -> ").collect();
    if parts.len() != 2 {
        return Err(MappingError::Parse {
            line: line_num,
            message: format!("Expected 'original -> obfuscated', got: {}", line),
        });
    }

    let original_part = parts[0].trim();
    let obfuscated_name = parts[1].trim();

    // Check if it's a method (contains parentheses) or field
    if original_part.contains('(') {
        parse_method_mapping(original_part, obfuscated_name, class_type, registry)?;
    } else {
        parse_field_mapping(original_part, obfuscated_name, class_type, registry)?;
    }

    Ok(())
}

/// Parse a field mapping
///
/// Format: "type fieldName"
fn parse_field_mapping(
    original_part: &str,
    obfuscated_name: &str,
    class_type: &str,
    registry: &AliasRegistry,
) -> Result<(), MappingError> {
    // Format: "type fieldName"
    // Split on last space to handle types with spaces (e.g., "java.lang.String[]")
    let parts: Vec<&str> = original_part.rsplitn(2, ' ').collect();
    if parts.len() != 2 {
        // Malformed, skip
        return Ok(());
    }

    let original_name = parts[0]; // Field name is last
    // parts[1] would be the type, but we don't need it

    registry.set_field_alias(class_type, obfuscated_name, original_name);
    Ok(())
}

/// Parse a method mapping
///
/// Format: "returnType methodName(paramTypes)"
/// Or with line numbers: "1:10:returnType methodName(paramTypes):15:24"
fn parse_method_mapping(
    original_part: &str,
    obfuscated_name: &str,
    class_type: &str,
    registry: &AliasRegistry,
) -> Result<(), MappingError> {
    let mut part = original_part;

    // Strip leading line number info if present: "1:10:..."
    if part.chars().next().map(|c| c.is_ascii_digit()).unwrap_or(false) {
        // Find the pattern "num:num:" at the start
        if let Some(colon1) = part.find(':') {
            if let Some(colon2) = part[colon1 + 1..].find(':') {
                part = &part[colon1 + 1 + colon2 + 1..];
            }
        }
    }

    // Strip trailing line number info if present: ":15:24"
    if let Some(paren_end) = part.rfind(')') {
        if paren_end + 1 < part.len() && part.as_bytes()[paren_end + 1] == b':' {
            part = &part[..paren_end + 1];
        }
    }

    // Now we have "returnType methodName(paramTypes)"
    // Find the opening paren
    let paren_pos = match part.find('(') {
        Some(pos) => pos,
        None => return Ok(()), // Malformed
    };

    let before_paren = &part[..paren_pos];

    // Split on space to get return type and method name
    let parts: Vec<&str> = before_paren.rsplitn(2, ' ').collect();
    if parts.len() != 2 {
        return Ok(()); // Malformed
    }

    let original_name = parts[0]; // Method name is last

    // For method disambiguation, we could parse param types into proto_shorty
    // For simplicity, store with empty proto (works for most cases)
    registry.set_method_alias(class_type, obfuscated_name, "", original_name);

    Ok(())
}

/// Convert a Java class name to DEX descriptor format
///
/// "com.example.Foo" -> "Lcom/example/Foo;"
/// "com.example.Foo$Inner" -> "Lcom/example/Foo$Inner;"
fn java_name_to_descriptor(name: &str) -> String {
    format!("L{};", name.replace('.', "/"))
}

/// Convert a DEX descriptor to internal name (without L and ;)
///
/// "Lcom/example/Foo;" -> "com/example/Foo"
#[allow(dead_code)]
fn descriptor_to_internal(desc: &str) -> &str {
    if desc.starts_with('L') && desc.ends_with(';') {
        &desc[1..desc.len() - 1]
    } else {
        desc
    }
}

#[cfg(test)]
mod tests {
    use super::*;

    #[test]
    fn test_java_name_to_descriptor() {
        assert_eq!(java_name_to_descriptor("a"), "La;");
        assert_eq!(
            java_name_to_descriptor("com.example.Foo"),
            "Lcom/example/Foo;"
        );
        assert_eq!(
            java_name_to_descriptor("com.example.Foo$Inner"),
            "Lcom/example/Foo$Inner;"
        );
    }

    #[test]
    fn test_parse_class_mapping() {
        let registry = AliasRegistry::new();

        let content = r#"
com.example.MainActivity -> a:
com.example.Utils -> b:
"#;

        parse_proguard_mapping(content, &registry).unwrap();

        assert_eq!(
            registry.get_class_alias("La;"),
            Some("MainActivity".to_string())
        );
        assert_eq!(registry.get_class_alias("Lb;"), Some("Utils".to_string()));
    }

    #[test]
    fn test_parse_field_mapping() {
        let registry = AliasRegistry::new();

        let content = r#"
com.example.Foo -> a:
    int count -> a
    java.lang.String name -> b
"#;

        parse_proguard_mapping(content, &registry).unwrap();

        assert_eq!(
            registry.get_field_alias("La;", "a"),
            Some("count".to_string())
        );
        assert_eq!(
            registry.get_field_alias("La;", "b"),
            Some("name".to_string())
        );
    }

    #[test]
    fn test_parse_method_mapping() {
        let registry = AliasRegistry::new();

        let content = r#"
com.example.Foo -> a:
    void onCreate(android.os.Bundle) -> a
    int calculate(int,int) -> b
"#;

        parse_proguard_mapping(content, &registry).unwrap();

        assert_eq!(
            registry.get_method_alias("La;", "a", ""),
            Some("onCreate".to_string())
        );
        assert_eq!(
            registry.get_method_alias("La;", "b", ""),
            Some("calculate".to_string())
        );
    }

    #[test]
    fn test_parse_method_with_line_numbers() {
        let registry = AliasRegistry::new();

        let content = r#"
com.example.Foo -> a:
    1:10:void methodOne():15:24 -> a
    20:30:int methodTwo(java.lang.String):100:110 -> b
"#;

        parse_proguard_mapping(content, &registry).unwrap();

        assert_eq!(
            registry.get_method_alias("La;", "a", ""),
            Some("methodOne".to_string())
        );
        assert_eq!(
            registry.get_method_alias("La;", "b", ""),
            Some("methodTwo".to_string())
        );
    }

    #[test]
    fn test_parse_with_comments() {
        let registry = AliasRegistry::new();

        let content = r#"
# This is a comment
com.example.Foo -> a:
    # Another comment
    int value -> x
"#;

        parse_proguard_mapping(content, &registry).unwrap();

        assert_eq!(registry.get_class_alias("La;"), Some("Foo".to_string()));
        assert_eq!(
            registry.get_field_alias("La;", "x"),
            Some("value".to_string())
        );
    }

    #[test]
    fn test_parse_inner_class() {
        let registry = AliasRegistry::new();

        let content = r#"
com.example.Outer$Inner -> a$a:
    void method() -> a
"#;

        parse_proguard_mapping(content, &registry).unwrap();

        assert_eq!(
            registry.get_class_alias("La$a;"),
            Some("Inner".to_string())
        );
    }

    #[test]
    fn test_empty_mapping() {
        let registry = AliasRegistry::new();
        parse_proguard_mapping("", &registry).unwrap();
        assert_eq!(registry.total_count(), 0);
    }
}
