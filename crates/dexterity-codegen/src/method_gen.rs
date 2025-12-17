//! Method code generation
//!
//! Generates Java source code for methods.

use std::collections::BTreeSet;

use dexterity_ir::{Annotation, AnnotationValue, AnnotationVisibility, ArgType, ClassData, MethodData, TypeParameter};

use crate::access_flags::{self, flags::*, AccessContext};
use crate::body_gen::{generate_body_with_dex, generate_body_with_dex_and_imports, generate_body_with_inner_classes};
use crate::dex_info::DexInfoProvider;
use crate::type_gen::{get_innermost_name, get_simple_name, type_to_string_with_imports};
use crate::writer::CodeWriter;

/// Add a rename comment if the method was renamed during deobfuscation
fn add_renamed_comment<W: CodeWriter>(code: &mut W, original_name: &str) {
    code.start_line()
        .add("/* renamed from: ")
        .add(original_name)
        .add(" */")
        .newline();
}

/// Generate type parameters declaration (e.g., "<T, E extends Number>")
/// Like JADX's ClassGen.addGenericTypeParameters()
pub fn generate_type_parameters<W: CodeWriter>(
    type_params: &[TypeParameter],
    imports: Option<&BTreeSet<String>>,
    code: &mut W,
) {
    if type_params.is_empty() {
        return;
    }

    code.add("<");
    for (i, param) in type_params.iter().enumerate() {
        if i > 0 {
            code.add(", ");
        }
        code.add(&param.name);

        // Add bounds if present (e.g., "extends Number & Comparable<T>")
        if !param.bounds.is_empty() {
            code.add(" extends ");
            for (j, bound) in param.bounds.iter().enumerate() {
                if j > 0 {
                    code.add(" & ");
                }
                code.add(&type_to_string_with_imports(bound, imports));
            }
        }
    }
    code.add("> ");
}

/// Check if a method should have @Override annotation (heuristic fallback)
/// We add @Override for non-constructor, non-static, non-private methods
/// in classes that have a superclass (other than Object) or implement interfaces
/// Returns Option<String> with the declaring class name for the comment
fn should_add_override_heuristic(method: &MethodData, class: &ClassData) -> Option<String> {
    // If method already has annotations, let the annotation system handle it
    if !method.annotations.is_empty() {
        return None;
    }

    // Don't add @Override to constructors or static initializers
    if method.is_constructor() || method.is_class_init() {
        return None;
    }
    // Don't add @Override to static or private methods
    if method.is_static() || (method.access_flags & ACC_PRIVATE) != 0 {
        return None;
    }

    // Check if class has a superclass (other than Object)
    if let Some(superclass) = &class.superclass {
        if superclass != "java/lang/Object" {
            // Convert "android/app/Activity" to "android.app.Activity"
            let declaring_class = superclass.replace('/', ".");
            return Some(declaring_class);
        }
    }

    // Check if class implements interfaces - use first interface as declaring class
    if let Some(first_interface) = class.interfaces.first() {
        // Extract class name from ArgType
        let iface_str = match first_interface {
            dexterity_ir::ArgType::Object(name) => name.as_str(),
            dexterity_ir::ArgType::Generic { base, .. } => base.as_str(),
            _ => return None,
        };
        let declaring_class = iface_str.replace('/', ".");
        return Some(declaring_class);
    }

    None
}

/// Generate annotation code for an annotation
pub fn generate_annotation<W: CodeWriter>(annotation: &Annotation, code: &mut W) {
    code.add("@");
    code.add(annotation.simple_name());

    // Add annotation elements if present
    if !annotation.elements.is_empty() {
        code.add("(");
        for (i, elem) in annotation.elements.iter().enumerate() {
            if i > 0 {
                code.add(", ");
            }
            // Single "value" element can omit the name
            if annotation.elements.len() == 1 && elem.name == "value" {
                code.add(&annotation_value_to_string(&elem.value));
            } else {
                code.add(&elem.name);
                code.add(" = ");
                code.add(&annotation_value_to_string(&elem.value));
            }
        }
        code.add(")");
    }
}

/// Convert an annotation value to its string representation
fn annotation_value_to_string(value: &AnnotationValue) -> String {
    match value {
        AnnotationValue::Byte(v) => format!("(byte) {}", v),
        AnnotationValue::Short(v) => format!("(short) {}", v),
        AnnotationValue::Char(v) => {
            if *v >= 32 && *v < 127 {
                format!("'{}'", char::from_u32(*v as u32).unwrap_or('?'))
            } else {
                format!("'\\u{:04x}'", v)
            }
        }
        AnnotationValue::Int(v) => v.to_string(),
        AnnotationValue::Long(v) => format!("{}L", v),
        AnnotationValue::Float(v) => {
            if v.is_nan() {
                "Float.NaN".to_string()
            } else if *v == f32::INFINITY {
                "Float.POSITIVE_INFINITY".to_string()
            } else if *v == f32::NEG_INFINITY {
                "Float.NEGATIVE_INFINITY".to_string()
            } else {
                format!("{}f", v)
            }
        }
        AnnotationValue::Double(v) => {
            if v.is_nan() {
                "Double.NaN".to_string()
            } else if *v == f64::INFINITY {
                "Double.POSITIVE_INFINITY".to_string()
            } else if *v == f64::NEG_INFINITY {
                "Double.NEGATIVE_INFINITY".to_string()
            } else {
                format!("{}d", v)
            }
        }
        AnnotationValue::String(s) => format!("\"{}\"", escape_string(s)),
        AnnotationValue::Type(t) => format!("{}.class", get_simple_name(t)),
        AnnotationValue::Enum(class_name, field_name) => {
            format!("{}.{}", get_simple_name(class_name), field_name)
        }
        AnnotationValue::Annotation(nested) => {
            // Nested annotation (rare case)
            let mut s = String::from("@");
            s.push_str(nested.simple_name());
            if !nested.elements.is_empty() {
                s.push_str("(...)");
            }
            s
        }
        AnnotationValue::Array(values) => {
            if values.len() == 1 {
                // Single-element array can omit braces
                annotation_value_to_string(&values[0])
            } else {
                let items: Vec<_> = values.iter().map(annotation_value_to_string).collect();
                format!("{{{}}}", items.join(", "))
            }
        }
        AnnotationValue::Boolean(v) => v.to_string(),
        AnnotationValue::Null => "null".to_string(),
    }
}

/// Escape special characters in a string
fn escape_string(s: &str) -> String {
    let mut result = String::with_capacity(s.len());
    for c in s.chars() {
        match c {
            '\\' => result.push_str("\\\\"),
            '"' => result.push_str("\\\""),
            '\n' => result.push_str("\\n"),
            '\r' => result.push_str("\\r"),
            '\t' => result.push_str("\\t"),
            _ if c.is_control() => result.push_str(&format!("\\u{:04x}", c as u32)),
            _ => result.push(c),
        }
    }
    result
}

/// Check if an annotation should be emitted in generated code
pub fn should_emit_annotation(annotation: &Annotation) -> bool {
    // Don't emit build-time only annotations
    if matches!(annotation.visibility, AnnotationVisibility::Build) {
        return false;
    }

    // Filter out some common internal annotations that shouldn't be emitted
    let type_name = &annotation.annotation_type;
    if type_name.contains("dalvik/annotation/")
        || type_name.contains("kotlin/jvm/internal/SourceDebugExtension")
    {
        return false;
    }

    // KEEP kotlin/Metadata annotations - they are important for Kotlin reflection
    // This is different from other Kotlin internal annotations

    true
}

/// Generate a method into a writer
#[allow(dead_code)]
pub fn generate_method<W: CodeWriter>(
    method: &MethodData,
    class: &ClassData,
    fallback: bool,
    code: &mut W,
) {
    generate_method_with_dex(method, class, fallback, None, None, code)
}

/// Generate a method into a writer with DEX info for name resolution
pub fn generate_method_with_dex<W: CodeWriter>(
    method: &MethodData,
    class: &ClassData,
    _fallback: bool,
    imports: Option<&BTreeSet<String>>,
    dex_info: Option<std::sync::Arc<dyn DexInfoProvider>>,
    code: &mut W,
) {
    // Emit method annotations from DEX
    for annotation in &method.annotations {
        if should_emit_annotation(annotation) {
            code.start_line();
            generate_annotation(annotation, code);
            code.newline();
        }
    }

    // Fallback: Add @Override annotation heuristically if no annotations present
    // (non-constructor, non-static, non-private methods in classes with superclass)
    if let Some(declaring_class) = should_add_override_heuristic(method, class) {
        code.start_line().add("@Override // ").add(&declaring_class).newline();
    }

    // Add rename comment if method was renamed during deobfuscation (skip constructors)
    if let Some(ref alias) = method.alias {
        if alias != &method.name && !method.is_constructor() {
            add_renamed_comment(code, &method.name);
        }
    }

    code.start_line();

    // Method modifiers (skip for static initializers since we handle them specially)
    if !method.is_class_init() {
        let mods = access_flags::access_flags_to_string(method.access_flags, AccessContext::Method);
        if !mods.is_empty() {
            code.add(&mods);
        }
    }

    // Type parameters (e.g., <T, E extends Number>)
    if !method.is_constructor() && !method.is_class_init() {
        generate_type_parameters(&method.type_parameters, imports, code);
    }

    // Return type and name
    if method.is_constructor() {
        // Constructor - use innermost class name (handles inner classes)
        let class_name = get_innermost_name(&class.class_type);
        code.add(class_name);
    } else if method.is_class_init() {
        // Static initializer
        code.add("static");
    } else {
        // Regular method (use simple names when imports available)
        code.add(&type_to_string_with_imports(&method.return_type, imports));
        code.add(" ");
        // Use alias if available from deobfuscation
        code.add(method.display_name());
    }

    // Parameters (except for static initializer)
    if !method.is_class_init() {
        add_parameters(method, imports, code);
    }

    // Throws clause (except for static initializer)
    if !method.is_class_init() {
        let throws = get_throws_from_annotations(&method.annotations);
        add_throws_clause(&throws, imports, code);
    }

    // Method body
    if method.is_abstract() || method.is_native() {
        // Abstract/native methods have no body
        code.add(";").newline();
    } else if method.is_class_init() {
        // Static initializer block
        code.add(" {").newline();
        code.inc_indent();
        add_method_body_with_dex_and_imports(method, dex_info.clone(), imports, code);
        code.dec_indent();
        code.start_line().add("}").newline();
    } else {
        // Regular method with body
        code.add(" {").newline();
        code.inc_indent();
        add_method_body_with_dex_and_imports(method, dex_info.clone(), imports, code);
        code.dec_indent();
        code.start_line().add("}").newline();
    }
}

/// Generate a method into a writer with inner classes for anonymous class inlining
pub fn generate_method_with_inner_classes<W: CodeWriter>(
    method: &MethodData,
    class: &ClassData,
    fallback: bool,
    imports: Option<&BTreeSet<String>>,
    dex_info: Option<std::sync::Arc<dyn DexInfoProvider>>,
    inner_classes: Option<&std::collections::HashMap<String, std::sync::Arc<ClassData>>>,
    hierarchy: Option<&dexterity_ir::ClassHierarchy>,
    deobf_min_length: usize,
    deobf_max_length: usize,
    res_names: &std::collections::HashMap<u32, String>,
    replace_consts: bool,
    code: &mut W,
) {
    // Emit method annotations from DEX
    for annotation in &method.annotations {
        if should_emit_annotation(annotation) {
            code.start_line();
            generate_annotation(annotation, code);
            code.newline();
        }
    }

    // Fallback: Add @Override annotation heuristically if no annotations present
    if let Some(declaring_class) = should_add_override_heuristic(method, class) {
        code.start_line()
            .add("@Override // ")
            .add(&declaring_class)
            .newline();
    }

    // Add rename comment if method was renamed during deobfuscation (skip constructors)
    if let Some(ref alias) = method.alias {
        if alias != &method.name && !method.is_constructor() {
            add_renamed_comment(code, &method.name);
        }
    }

    code.start_line();

    // Method modifiers (skip for static initializers since we handle them specially)
    if !method.is_class_init() {
        let mods = access_flags::access_flags_to_string(method.access_flags, AccessContext::Method);
        if !mods.is_empty() {
            code.add(&mods);
        }
    }

    // Type parameters (e.g., <T, E extends Number>)
    if !method.is_constructor() && !method.is_class_init() {
        generate_type_parameters(&method.type_parameters, imports, code);
    }

    // Return type and name
    if method.is_constructor() {
        // Constructor - use innermost class name (handles inner classes)
        let class_name = get_innermost_name(&class.class_type);
        code.add(class_name);
    } else if method.is_class_init() {
        // Static initializer
        code.add("static");
    } else {
        code.add(&type_to_string_with_imports(&method.return_type, imports));
        code.add(" ");
        // Use alias if available from deobfuscation
        code.add(method.display_name());
    }

    // Parameters (except for static initializer)
    if !method.is_class_init() {
        add_parameters(method, imports, code);
    }

    // Throws clause (except for static initializer)
    if !method.is_class_init() {
        let throws = get_throws_from_annotations(&method.annotations);
        add_throws_clause(&throws, imports, code);
    }

    // Method body
    if method.is_abstract() || method.is_native() {
        code.add(";").newline();
    } else if method.is_class_init() {
        code.add(" {").newline();
        code.inc_indent();
        add_method_body_with_inner_classes(method, dex_info.clone(), imports, inner_classes, hierarchy, Some(&class.class_type), deobf_min_length, deobf_max_length, fallback, res_names, replace_consts, code);
        code.dec_indent();
        code.start_line().add("}").newline();
    } else {
        code.add(" {").newline();
        code.inc_indent();
        add_method_body_with_inner_classes(method, dex_info.clone(), imports, inner_classes, hierarchy, Some(&class.class_type), deobf_min_length, deobf_max_length, fallback, res_names, replace_consts, code);
        code.dec_indent();
        code.start_line().add("}").newline();
    }
}

/// Add method body with inner classes for anonymous class inlining
fn add_method_body_with_inner_classes<W: CodeWriter>(
    method: &MethodData,
    dex_info: Option<std::sync::Arc<dyn DexInfoProvider>>,
    imports: Option<&BTreeSet<String>>,
    inner_classes: Option<&std::collections::HashMap<String, std::sync::Arc<ClassData>>>,
    hierarchy: Option<&dexterity_ir::ClassHierarchy>,
    current_class_type: Option<&str>,
    deobf_min_length: usize,
    deobf_max_length: usize,
    fallback: bool,
    res_names: &std::collections::HashMap<u32, String>,
    replace_consts: bool,
    code: &mut W,
) {
    generate_body_with_inner_classes(method, dex_info, imports, inner_classes, hierarchy, current_class_type, deobf_min_length, deobf_max_length, fallback, res_names, replace_consts, code);
}

/// Extract throws types from dalvik/annotation/Throws annotation
fn get_throws_from_annotations(annotations: &[Annotation]) -> Vec<String> {
    for annotation in annotations {
        if annotation.annotation_type == "dalvik/annotation/Throws" {
            // The throws annotation has a single "value" element containing an array of Type values
            for elem in &annotation.elements {
                if elem.name == "value" {
                    if let AnnotationValue::Array(values) = &elem.value {
                        return values.iter().filter_map(|v| {
                            if let AnnotationValue::Type(type_name) = v {
                                Some(type_name.clone())
                            } else {
                                None
                            }
                        }).collect();
                    }
                }
            }
        }
    }
    Vec::new()
}

/// Add throws clause to method signature
fn add_throws_clause<W: CodeWriter>(throws: &[String], imports: Option<&BTreeSet<String>>, code: &mut W) {
    if throws.is_empty() {
        return;
    }
    code.add(" throws ");
    for (i, exception) in throws.iter().enumerate() {
        if i > 0 {
            code.add(", ");
        }
        // Use simple name if imported
        code.add(&type_to_string_with_imports(&ArgType::Object(exception.clone()), imports));
    }
}

/// Add method parameters
fn add_parameters<W: CodeWriter>(method: &MethodData, imports: Option<&BTreeSet<String>>, code: &mut W) {
    code.add("(");

    let is_varargs = method.access_flags & ACC_VARARGS != 0;
    let params = &method.arg_types;
    let param_count = params.len();

    for (i, param_type) in params.iter().enumerate() {
        if i > 0 {
            code.add(", ");
        }

        let is_last = i == param_count - 1;
        let is_last_vararg = is_last && is_varargs;

        // Type (convert last array to varargs if needed, use simple names when imports available)
        if is_last_vararg {
            if let ArgType::Array(elem) = param_type {
                code.add(&type_to_string_with_imports(elem, imports));
                code.add("...");
            } else {
                // Fallback - shouldn't happen but handle gracefully
                code.add(&type_to_string_with_imports(param_type, imports));
            }
        } else {
            code.add(&type_to_string_with_imports(param_type, imports));
        }

        // Parameter name: use debug info if available, otherwise generate from type
        code.add(" ");
        let name = method.arg_names.get(i)
            .and_then(|n| n.clone())
            .unwrap_or_else(|| generate_param_name(i, param_type));
        code.add(&name);
    }

    code.add(")");
}

/// Generate a parameter name based on type and index
fn generate_param_name(index: usize, ty: &ArgType) -> String {
    // Try to generate a meaningful name from the type
    let base = match ty {
        ArgType::Object(name) => {
            let simple = get_simple_name(name);
            // Lowercase first letter
            let mut chars = simple.chars();
            match chars.next() {
                Some(c) => c.to_lowercase().chain(chars).collect(),
                None => "obj".to_string(),
            }
        }
        ArgType::Array(elem) => {
            let elem_name = generate_param_name(index, elem);
            format!("{}Arr", elem_name)
        }
        ArgType::Int => "i".to_string(),
        ArgType::Long => "l".to_string(),
        ArgType::Float => "f".to_string(),
        ArgType::Double => "d".to_string(),
        ArgType::Boolean => "z".to_string(),
        ArgType::Byte => "b".to_string(),
        ArgType::Char => "c".to_string(),
        ArgType::Short => "s".to_string(),
        // Handle generic types by extracting base class name
        ArgType::Generic { base, .. } => {
            let simple = get_simple_name(base);
            let mut chars = simple.chars();
            match chars.next() {
                Some(c) => c.to_lowercase().chain(chars).collect(),
                None => "obj".to_string(),
            }
        }
        // Handle type variables by using the variable name lowercase
        ArgType::TypeVariable(name) => name.to_lowercase(),
        // Handle wildcards by using the bound type if available
        ArgType::Wildcard { inner: Some(inner), .. } => generate_param_name(index, inner),
        ArgType::Wildcard { inner: None, .. } => "obj".to_string(),
        ArgType::Void => "v".to_string(),
        ArgType::Unknown => "obj".to_string(),
    };

    // JADX starts numeric suffixes from 2, not 1
    // First param: i, second: i2, third: i3, etc.
    if index == 0 {
        base
    } else {
        format!("{}{}", base, index + 1)
    }
}

/// Add method body using region-based code generation
#[allow(dead_code)]
fn add_method_body<W: CodeWriter>(method: &MethodData, code: &mut W) {
    add_method_body_with_dex_and_imports(method, None, None, code)
}

/// Add method body with DEX info for name resolution
#[allow(dead_code)]
fn add_method_body_with_dex<W: CodeWriter>(
    method: &MethodData,
    dex_info: Option<std::sync::Arc<dyn DexInfoProvider>>,
    code: &mut W,
) {
    // Use the body generator with DEX info for proper name resolution
    generate_body_with_dex(method, dex_info, code);
}

/// Add method body with DEX info and imports for name resolution
fn add_method_body_with_dex_and_imports<W: CodeWriter>(
    method: &MethodData,
    dex_info: Option<std::sync::Arc<dyn DexInfoProvider>>,
    imports: Option<&BTreeSet<String>>,
    code: &mut W,
) {
    // Use the body generator with DEX info and imports for proper name resolution
    generate_body_with_dex_and_imports(method, dex_info, imports, code);
}


#[cfg(test)]
mod tests {
    use super::*;
    use crate::writer::SimpleCodeWriter;

    fn make_class() -> ClassData {
        ClassData::new("Lcom/example/Test;".to_string(), 0x0001)
    }

    fn make_method(name: &str, return_type: ArgType, flags: u32) -> MethodData {
        MethodData::new(name.to_string(), flags, return_type)
    }

    #[test]
    fn test_simple_method() {
        let class = make_class();
        let method = make_method("foo", ArgType::Void, ACC_PUBLIC);
        let mut writer = SimpleCodeWriter::new();
        generate_method(&method, &class, false, &mut writer);
        let code = writer.finish();

        assert!(code.contains("public void foo()"));
    }

    #[test]
    fn test_method_with_params() {
        let class = make_class();
        let mut method = make_method("bar", ArgType::Int, ACC_PUBLIC);
        method.arg_types.push(ArgType::Int);
        method.arg_types.push(ArgType::Object("java/lang/String".to_string()));
        let mut writer = SimpleCodeWriter::new();
        generate_method(&method, &class, false, &mut writer);
        let code = writer.finish();

        assert!(code.contains("public int bar(int i, String string1)"));
    }

    #[test]
    fn test_constructor() {
        let class = make_class();
        let method = make_method("<init>", ArgType::Void, ACC_PUBLIC);
        let mut writer = SimpleCodeWriter::new();
        generate_method(&method, &class, false, &mut writer);
        let code = writer.finish();

        assert!(code.contains("public Test()"));
    }

    #[test]
    fn test_abstract_method() {
        let class = make_class();
        let method = make_method("abstractMethod", ArgType::Void, ACC_PUBLIC | ACC_ABSTRACT);
        let mut writer = SimpleCodeWriter::new();
        generate_method(&method, &class, false, &mut writer);
        let code = writer.finish();

        assert!(code.contains("public abstract void abstractMethod();"));
        // Should NOT have a body
        assert!(!code.contains("{"));
    }

    #[test]
    fn test_native_method() {
        let class = make_class();
        let method = make_method("nativeMethod", ArgType::Int, ACC_PUBLIC | ACC_NATIVE);
        let mut writer = SimpleCodeWriter::new();
        generate_method(&method, &class, false, &mut writer);
        let code = writer.finish();

        assert!(code.contains("public native int nativeMethod();"));
    }

    #[test]
    fn test_varargs_method() {
        let class = make_class();
        let mut method = make_method("varargs", ArgType::Void, ACC_PUBLIC | ACC_VARARGS);
        method.arg_types.push(ArgType::Array(Box::new(ArgType::Object("java/lang/String".to_string()))));
        let mut writer = SimpleCodeWriter::new();
        generate_method(&method, &class, false, &mut writer);
        let code = writer.finish();

        assert!(code.contains("public void varargs(String... stringArr)"));
    }

    #[test]
    fn test_static_initializer() {
        let class = make_class();
        let method = make_method("<clinit>", ArgType::Void, ACC_STATIC);
        let mut writer = SimpleCodeWriter::new();
        generate_method(&method, &class, false, &mut writer);
        let code = writer.finish();

        assert!(code.contains("static {"));
    }
}
