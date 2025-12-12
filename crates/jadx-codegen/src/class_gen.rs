//! Class code generation
//!
//! Generates Java source code for classes using jadx-ir types.

use jadx_ir::{ClassData, FieldData, FieldValue};

use crate::access_flags::{self, AccessContext};
use crate::dex_info::DexInfo;
use crate::method_gen::{generate_method, generate_method_with_dex};
use crate::type_gen::{escape_string, get_package, get_simple_name, literal_to_string, type_to_string};
use crate::writer::{CodeWriter, SimpleCodeWriter};

/// Configuration for class generation
#[derive(Debug, Clone)]
pub struct ClassGenConfig {
    /// Use imports for types (vs fully qualified names)
    pub use_imports: bool,
    /// Show debug comments
    pub show_debug: bool,
    /// Fallback mode (show raw bytecode on error)
    pub fallback: bool,
}

impl Default for ClassGenConfig {
    fn default() -> Self {
        ClassGenConfig {
            use_imports: true,
            show_debug: false,
            fallback: false,
        }
    }
}

/// Generate Java source code for a class
pub fn generate_class(class: &ClassData, config: &ClassGenConfig) -> String {
    let mut writer = SimpleCodeWriter::new();
    generate_class_to_writer(class, config, &mut writer);
    writer.finish()
}

/// Generate Java source code for a class with DEX info for name resolution
///
/// When `dex_info` is provided, type/field/method indices are resolved to actual names.
pub fn generate_class_with_dex(
    class: &ClassData,
    config: &ClassGenConfig,
    dex_info: Option<&DexInfo>,
) -> String {
    let mut writer = SimpleCodeWriter::new();
    generate_class_to_writer_with_dex(class, config, dex_info, &mut writer);
    writer.finish()
}

/// Generate Java source code for a class into a writer
pub fn generate_class_to_writer<W: CodeWriter>(class: &ClassData, config: &ClassGenConfig, code: &mut W) {
    generate_class_to_writer_with_dex(class, config, None, code)
}

/// Generate Java source code for a class into a writer with DEX info
pub fn generate_class_to_writer_with_dex<W: CodeWriter>(
    class: &ClassData,
    config: &ClassGenConfig,
    dex_info: Option<&DexInfo>,
    code: &mut W,
) {
    // Package declaration
    if let Some(pkg) = get_package(&class.class_type) {
        code.add("package ").add(&pkg).add(";").newline().newline();
    }

    // TODO: Add imports when use_imports is true
    // For now, we use fully qualified names

    // Class declaration
    add_class_declaration(class, code);

    // Class body
    code.add(" {").newline();
    code.inc_indent();

    // Fields
    add_fields(class, code);

    // Methods (pass DEX info for name resolution in method bodies)
    add_methods_with_dex(class, config, dex_info, code);

    code.dec_indent();
    code.start_line().add("}").newline();
}

/// Add class declaration (modifiers, name, extends, implements)
fn add_class_declaration<W: CodeWriter>(class: &ClassData, code: &mut W) {
    let mut flags = class.access_flags;

    // Interfaces are implicitly abstract and static
    if access_flags::is_interface(flags) {
        flags &= !(access_flags::flags::ACC_ABSTRACT | access_flags::flags::ACC_STATIC);
    }
    // Enums are implicitly final
    if access_flags::is_enum(flags) {
        flags &= !(access_flags::flags::ACC_FINAL | access_flags::flags::ACC_ABSTRACT);
    }

    // Modifiers
    let mods = access_flags::access_flags_to_string(flags, AccessContext::Class);
    if !mods.is_empty() {
        code.add(&mods);
    }

    // Class type keyword
    let keyword = access_flags::class_type_keyword(class.access_flags);
    code.add(keyword).add(" ");

    // Class name
    let simple_name = get_simple_name(&class.class_type);
    code.add(simple_name);

    // Extends
    if let Some(ref superclass) = class.superclass {
        // Don't show "extends Object"
        if superclass != "java/lang/Object" {
            code.add(" extends ");
            code.add(&type_to_string(&jadx_ir::ArgType::Object(superclass.clone())));
        }
    }

    // Implements
    if !class.interfaces.is_empty() {
        if access_flags::is_interface(class.access_flags) {
            code.add(" extends ");
        } else {
            code.add(" implements ");
        }
        let ifaces: Vec<_> = class
            .interfaces
            .iter()
            .map(|i| type_to_string(&jadx_ir::ArgType::Object(i.clone())))
            .collect();
        code.add(&ifaces.join(", "));
    }
}

/// Add field declarations
fn add_fields<W: CodeWriter>(class: &ClassData, code: &mut W) {
    let has_fields = !class.static_fields.is_empty() || !class.instance_fields.is_empty();

    if has_fields {
        code.newline();
    }

    // Static fields first
    for field in &class.static_fields {
        add_field(field, code);
    }

    // Instance fields
    for field in &class.instance_fields {
        add_field(field, code);
    }
}

/// Add a single field declaration
fn add_field<W: CodeWriter>(field: &FieldData, code: &mut W) {
    code.start_line();

    // Modifiers
    let mods = access_flags::access_flags_to_string(field.access_flags, AccessContext::Field);
    if !mods.is_empty() {
        code.add(&mods);
    }

    // Type
    code.add(&type_to_string(&field.field_type));
    code.add(" ");

    // Name
    code.add(&field.name);

    // Initial value
    if let Some(ref value) = field.initial_value {
        code.add(" = ");
        add_field_value(value, &field.field_type, code);
    }

    code.add(";").newline();
}

/// Add field initial value
fn add_field_value<W: CodeWriter>(value: &FieldValue, _field_type: &jadx_ir::ArgType, code: &mut W) {
    match value {
        FieldValue::Byte(v) => code.add(&literal_to_string(*v as i64, &jadx_ir::ArgType::Byte)),
        FieldValue::Short(v) => code.add(&literal_to_string(*v as i64, &jadx_ir::ArgType::Short)),
        FieldValue::Char(v) => code.add(&literal_to_string(*v as i64, &jadx_ir::ArgType::Char)),
        FieldValue::Int(v) => code.add(&literal_to_string(*v as i64, &jadx_ir::ArgType::Int)),
        FieldValue::Long(v) => code.add(&literal_to_string(*v, &jadx_ir::ArgType::Long)),
        FieldValue::Float(v) => code.add(&format!("{}f", v)),
        FieldValue::Double(v) => code.add(&format!("{}d", v)),
        FieldValue::String(s) => code.add(&escape_string(s)),
        FieldValue::Type(t) => {
            code.add(&type_to_string(&jadx_ir::ArgType::Object(t.clone())));
            code.add(".class")
        }
        FieldValue::Null => code.add("null"),
    };
}

/// Add method declarations
fn add_methods<W: CodeWriter>(class: &ClassData, config: &ClassGenConfig, code: &mut W) {
    add_methods_with_dex(class, config, None, code)
}

/// Add method declarations with DEX info for name resolution
fn add_methods_with_dex<W: CodeWriter>(
    class: &ClassData,
    config: &ClassGenConfig,
    dex_info: Option<&DexInfo>,
    code: &mut W,
) {
    for method in &class.methods {
        code.newline();
        generate_method_with_dex(method, class, config.fallback, dex_info, code);
    }
}

#[cfg(test)]
mod tests {
    use super::*;
    use jadx_ir::ArgType;

    fn make_class(name: &str, flags: u32) -> ClassData {
        let mut class = ClassData::new(format!("L{};", name), flags);
        class.superclass = Some("java/lang/Object".to_string());
        class
    }

    #[test]
    fn test_simple_class() {
        let class = make_class("com/example/Foo", 0x0001); // public
        let config = ClassGenConfig::default();
        let code = generate_class(&class, &config);

        assert!(code.contains("package com.example;"));
        assert!(code.contains("public class Foo"));
    }

    #[test]
    fn test_interface() {
        let class = make_class("com/example/Bar", 0x0601); // public abstract interface
        let config = ClassGenConfig::default();
        let code = generate_class(&class, &config);

        assert!(code.contains("public interface Bar"));
        // Should NOT contain "abstract" for interface
        assert!(!code.contains("abstract interface"));
    }

    #[test]
    fn test_enum() {
        let class = make_class("com/example/MyEnum", 0x4011); // public final enum
        let config = ClassGenConfig::default();
        let code = generate_class(&class, &config);

        assert!(code.contains("public enum MyEnum"));
        // Should NOT contain "final" for enum
        assert!(!code.contains("final enum"));
    }

    #[test]
    fn test_with_field() {
        let mut class = make_class("com/example/Test", 0x0001);
        class.instance_fields.push(FieldData {
            name: "value".to_string(),
            access_flags: 0x0002, // private
            field_type: ArgType::Int,
            initial_value: None,
        });
        let config = ClassGenConfig::default();
        let code = generate_class(&class, &config);

        assert!(code.contains("private int value;"));
    }

    #[test]
    fn test_with_static_final_field() {
        let mut class = make_class("com/example/Constants", 0x0001);
        class.static_fields.push(FieldData {
            name: "MAX_VALUE".to_string(),
            access_flags: 0x0019, // public static final
            field_type: ArgType::Int,
            initial_value: Some(FieldValue::Int(100)),
        });
        let config = ClassGenConfig::default();
        let code = generate_class(&class, &config);

        assert!(code.contains("public static final int MAX_VALUE = 100;"));
    }

    #[test]
    fn test_implements() {
        let mut class = make_class("com/example/MyClass", 0x0001);
        class.interfaces.push("java/io/Serializable".to_string());
        class.interfaces.push("java/lang/Cloneable".to_string());
        let config = ClassGenConfig::default();
        let code = generate_class(&class, &config);

        assert!(code.contains("implements java.io.Serializable, java.lang.Cloneable"));
    }
}
