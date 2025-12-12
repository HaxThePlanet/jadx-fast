//! DEX information for code generation
//!
//! This module provides a way to pass DEX string/type/field/method data
//! to code generation, enabling proper name resolution instead of
//! placeholder indices like `Type#123`.

use std::collections::HashMap;

use crate::expr_gen::{ExprGen, FieldInfo, MethodInfo};
use jadx_ir::types::ArgType;

/// DEX information needed for code generation
///
/// This struct holds pre-extracted data from a DEX file that's needed
/// during code generation to resolve indices to actual names.
#[derive(Default)]
pub struct DexInfo {
    /// String pool: string_idx -> string value
    pub strings: HashMap<u32, String>,
    /// Type names: type_idx -> type descriptor (e.g., "Ljava/lang/String;")
    pub types: HashMap<u32, String>,
    /// Field info: field_idx -> (class_name, field_name, field_type)
    pub fields: HashMap<u32, FieldInfo>,
    /// Method info: method_idx -> (class_name, method_name, return_type, param_types)
    pub methods: HashMap<u32, MethodInfo>,
}

impl DexInfo {
    /// Create a new empty DexInfo
    pub fn new() -> Self {
        Self::default()
    }

    /// Add a string to the pool
    pub fn add_string(&mut self, idx: u32, value: String) {
        self.strings.insert(idx, value);
    }

    /// Add a type name
    pub fn add_type(&mut self, idx: u32, descriptor: String) {
        self.types.insert(idx, descriptor);
    }

    /// Add field info
    pub fn add_field(&mut self, idx: u32, info: FieldInfo) {
        self.fields.insert(idx, info);
    }

    /// Add method info
    pub fn add_method(&mut self, idx: u32, info: MethodInfo) {
        self.methods.insert(idx, info);
    }

    /// Get a string by index
    pub fn get_string(&self, idx: u32) -> Option<&str> {
        self.strings.get(&idx).map(|s| s.as_str())
    }

    /// Get a type name by index, converting descriptor to simple name
    pub fn get_type_name(&self, idx: u32) -> Option<String> {
        self.types.get(&idx).map(|desc| descriptor_to_java_name(desc))
    }

    /// Get field info by index
    pub fn get_field(&self, idx: u32) -> Option<&FieldInfo> {
        self.fields.get(&idx)
    }

    /// Get method info by index
    pub fn get_method(&self, idx: u32) -> Option<&MethodInfo> {
        self.methods.get(&idx)
    }

    /// Get field type by index (for type inference)
    pub fn get_field_type(&self, idx: u32) -> Option<ArgType> {
        self.fields.get(&idx).map(|f| f.field_type.clone())
    }

    /// Get type by index as ArgType (for type inference)
    pub fn get_type_as_argtype(&self, idx: u32) -> Option<ArgType> {
        self.types.get(&idx).and_then(|desc| descriptor_to_argtype(desc))
    }

    /// Get method return type by index (for type inference)
    pub fn get_method_return_type(&self, idx: u32) -> Option<(Vec<ArgType>, ArgType)> {
        self.methods.get(&idx).map(|m| {
            (m.param_types.clone(), m.return_type.clone())
        })
    }

    /// Populate an ExprGen with this DEX info
    pub fn populate_expr_gen(&self, expr_gen: &mut ExprGen) {
        // Add all strings
        for (&idx, value) in &self.strings {
            expr_gen.set_string(idx, value.clone());
        }

        // Add all type names (converting descriptors to Java names)
        for (&idx, desc) in &self.types {
            let java_name = descriptor_to_java_name(desc);
            expr_gen.set_type_name(idx, java_name);
        }

        // Add all field info
        for (&idx, info) in &self.fields {
            expr_gen.set_field_info(idx, info.clone());
        }

        // Add all method info
        for (&idx, info) in &self.methods {
            expr_gen.set_method_info(idx, info.clone());
        }
    }
}

/// Convert a DEX type descriptor to an ArgType (for type inference)
/// Public version for use from body_gen.rs
pub fn descriptor_to_argtype_pub(desc: &str) -> Option<ArgType> {
    descriptor_to_argtype(desc)
}

/// Convert a DEX type descriptor to an ArgType (for type inference)
fn descriptor_to_argtype(desc: &str) -> Option<ArgType> {
    if desc.is_empty() {
        return None;
    }

    let first = desc.chars().next()?;
    Some(match first {
        'V' => ArgType::Void,
        'Z' => ArgType::Boolean,
        'B' => ArgType::Byte,
        'S' => ArgType::Short,
        'C' => ArgType::Char,
        'I' => ArgType::Int,
        'J' => ArgType::Long,
        'F' => ArgType::Float,
        'D' => ArgType::Double,
        '[' => {
            let elem = descriptor_to_argtype(&desc[1..])?;
            ArgType::Array(Box::new(elem))
        }
        'L' => {
            let inner = desc
                .strip_prefix('L')?
                .strip_suffix(';')?;
            ArgType::Object(inner.to_string())
        }
        _ => return None,
    })
}

/// Convert a DEX type descriptor to a Java type name
///
/// Examples:
/// - "Ljava/lang/String;" -> "String"
/// - "[I" -> "int[]"
/// - "I" -> "int"
fn descriptor_to_java_name(desc: &str) -> String {
    if desc.is_empty() {
        return "Object".to_string();
    }

    let first = desc.chars().next().unwrap();
    match first {
        'V' => "void".to_string(),
        'Z' => "boolean".to_string(),
        'B' => "byte".to_string(),
        'S' => "short".to_string(),
        'C' => "char".to_string(),
        'I' => "int".to_string(),
        'J' => "long".to_string(),
        'F' => "float".to_string(),
        'D' => "double".to_string(),
        '[' => {
            let elem = descriptor_to_java_name(&desc[1..]);
            format!("{}[]", elem)
        }
        'L' => {
            // Object type: Ljava/lang/String; -> String (simple name)
            // or java.lang.String (full name if needed)
            let inner = desc
                .strip_prefix('L')
                .unwrap_or(desc)
                .strip_suffix(';')
                .unwrap_or(desc);
            // Convert / to . and take simple name
            let full_name = inner.replace('/', ".");
            // For now, use simple name (last component)
            full_name
                .rsplit('.')
                .next()
                .unwrap_or(&full_name)
                .to_string()
        }
        _ => desc.to_string(),
    }
}

/// Convert a DEX type descriptor to a full Java type name (with package)
pub fn descriptor_to_full_java_name(desc: &str) -> String {
    if desc.is_empty() {
        return "java.lang.Object".to_string();
    }

    let first = desc.chars().next().unwrap();
    match first {
        'V' => "void".to_string(),
        'Z' => "boolean".to_string(),
        'B' => "byte".to_string(),
        'S' => "short".to_string(),
        'C' => "char".to_string(),
        'I' => "int".to_string(),
        'J' => "long".to_string(),
        'F' => "float".to_string(),
        'D' => "double".to_string(),
        '[' => {
            let elem = descriptor_to_full_java_name(&desc[1..]);
            format!("{}[]", elem)
        }
        'L' => {
            let inner = desc
                .strip_prefix('L')
                .unwrap_or(desc)
                .strip_suffix(';')
                .unwrap_or(desc);
            inner.replace('/', ".")
        }
        _ => desc.to_string(),
    }
}

#[cfg(test)]
mod tests {
    use super::*;

    #[test]
    fn test_descriptor_to_java_name() {
        assert_eq!(descriptor_to_java_name("I"), "int");
        assert_eq!(descriptor_to_java_name("Z"), "boolean");
        assert_eq!(descriptor_to_java_name("[I"), "int[]");
        assert_eq!(descriptor_to_java_name("[[D"), "double[][]");
        assert_eq!(descriptor_to_java_name("Ljava/lang/String;"), "String");
        assert_eq!(
            descriptor_to_java_name("Landroid/widget/TextView;"),
            "TextView"
        );
    }

    #[test]
    fn test_descriptor_to_full_java_name() {
        assert_eq!(descriptor_to_full_java_name("Ljava/lang/String;"), "java.lang.String");
        assert_eq!(
            descriptor_to_full_java_name("Landroid/widget/TextView;"),
            "android.widget.TextView"
        );
    }

    #[test]
    fn test_populate_expr_gen() {
        let mut dex_info = DexInfo::new();
        dex_info.add_string(0, "Hello".to_string());
        dex_info.add_type(0, "Ljava/lang/String;".to_string());
        dex_info.add_field(
            0,
            FieldInfo {
                class_name: "MyClass".to_string(),
                field_name: "value".to_string(),
                field_type: ArgType::Int,
            },
        );

        let mut expr_gen = ExprGen::new();
        dex_info.populate_expr_gen(&mut expr_gen);

        // Verify strings were added (would need getter to verify)
        // For now just ensure no panic
    }
}
