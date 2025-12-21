//! Method code generation
//!
//! Generates Java source code for methods.

use std::collections::BTreeSet;

/// Sanitize a method name to be a valid Java identifier
/// R8/D8 optimizer creates synthetic methods with hyphens (e.g., $r8$lambda$...-...)
/// which are invalid Java identifiers. This converts hyphens to underscores.
fn sanitize_method_name(name: &str) -> String {
    if !name.contains('-') {
        return name.to_string();
    }
    // Replace hyphens with underscores (simpler than camelCase for method names)
    name.replace('-', "_")
}

/// Check if a method is too complex to decompile cleanly
/// Returns Some(reason) if method should be skipped, None if it should be decompiled normally
///
/// NOTE: This is more conservative than before - we only skip methods with extreme
/// instruction counts. JADX handles Compose UI code and long methods fine, so we do too.
fn should_skip_complex_method(method: &MethodData) -> Option<String> {
    // Only skip methods with extremely high instruction counts (10000+)
    // JADX handles most methods regardless of size, so we should too
    if let Some(ref bytecode_ref) = method.bytecode_ref {
        if bytecode_ref.insns_count > 10000 {
            return Some(format!("instructions count: {}", bytecode_ref.insns_count));
        }
    }

    // NOTE: We no longer skip methods based on:
    // - Composer parameter (Compose UI code) - JADX handles these fine
    // - @Composable annotation - JADX handles these fine
    // The previous checks were too aggressive and caused unnecessary skipping

    None
}

/// Check if a static initializer (clinit) is empty and should be skipped
/// A clinit is considered empty if it has no instructions or only a return-void
fn is_empty_clinit(method: &MethodData) -> bool {
    if let Some(insns) = method.instructions() {
        // Empty or only return-void
        if insns.is_empty() {
            return true;
        }
        if insns.len() == 1 {
            if let dexterity_ir::InsnType::Return { value: None } = &insns[0].insn_type {
                return true;
            }
        }
    } else {
        // No instructions at all (native or abstract - unusual for clinit)
        return true;
    }
    false
}

use dexterity_ir::{Annotation, AnnotationValue, AnnotationVisibility, ArgType, ClassData, MethodData, TypeParameter};

use crate::access_flags::{self, flags::*, AccessContext};
use crate::body_gen::{generate_body_with_dex, generate_body_with_dex_and_imports, generate_body_with_inner_classes};
use crate::class_gen::CommentsLevel;
use crate::dex_info::DexInfoProvider;
use crate::type_gen::{get_innermost_name, get_package, get_simple_name, type_to_string_with_imports_and_package};
use crate::writer::CodeWriter;

/// Add a rename comment if the method was renamed during deobfuscation
fn add_renamed_comment<W: CodeWriter>(code: &mut W, original_name: &str, comments_level: CommentsLevel) {
    if !comments_level.show_info() {
        return;
    }
    code.start_line()
        .add("/* renamed from: ")
        .add(original_name)
        .add(" */")
        .newline();
}

/// Generate type parameters declaration (e.g., "<T, E extends Number>")
/// Supports Kotlin variance annotations (in/out modifiers)
/// Like JADX's ClassGen.addGenericTypeParameters()
pub fn generate_type_parameters<W: CodeWriter>(
    type_params: &[TypeParameter],
    imports: Option<&BTreeSet<String>>,
    current_package: Option<&str>,
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

        // Add Kotlin variance modifier if present (in/out)
        // This produces declarations like `<in T>` or `<out E>`
        if let Some(keyword) = param.variance.kotlin_keyword() {
            code.add(keyword);
            code.add(" ");
        }

        // Add reified modifier if present (for Kotlin inline functions)
        if param.reified {
            code.add("reified ");
        }

        code.add(&param.name);

        // Add bounds if present (e.g., "extends Number & Comparable<T>")
        if !param.bounds.is_empty() {
            code.add(" extends ");
            for (j, bound) in param.bounds.iter().enumerate() {
                if j > 0 {
                    code.add(" & ");
                }
                code.add(&type_to_string_with_imports_and_package(bound, imports, current_package));
            }
        }
    }
    code.add(">");
}

/// Check if a method should have @Override annotation
///
/// Uses the method's override_attr if set (from override analysis), otherwise
/// falls back to heuristic for common override scenarios (superclass/interface methods).
///
/// Returns Option<String> with the declaring class name for the comment
fn should_add_override_heuristic(method: &MethodData, class: &ClassData) -> Option<String> {
    // BUG-009 fix: Annotation interface methods can't override anything
    if class.is_annotation() {
        return None;
    }

    // Check if method has explicit override attribute from analysis pass
    if let Some(ref override_attr) = method.override_attr {
        // Convert "java/lang/Object" to "java.lang.Object"
        let declaring_class = override_attr.base_class.replace('/', ".");
        return Some(declaring_class);
    }

    // If method already has annotations (like @Override from DEX), let the annotation system handle it
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

    // Fallback heuristic: check if class has a superclass (other than Object)
    // This is a conservative heuristic - may add @Override even when not strictly needed
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
            // Nested annotation - recursively render elements
            let mut s = String::from("@");
            s.push_str(nested.simple_name());
            if !nested.elements.is_empty() {
                s.push('(');
                for (i, elem) in nested.elements.iter().enumerate() {
                    if i > 0 {
                        s.push_str(", ");
                    }
                    // Single "value" element can omit the name
                    if nested.elements.len() == 1 && elem.name == "value" {
                        s.push_str(&annotation_value_to_string(&elem.value));
                    } else {
                        s.push_str(&elem.name);
                        s.push_str(" = ");
                        s.push_str(&annotation_value_to_string(&elem.value));
                    }
                }
                s.push(')');
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
    // Skip empty static initializers (JADX behavior)
    // A clinit is considered empty if it has no instructions or only a return-void
    if method.is_class_init() && is_empty_clinit(method) {
        return;
    }

    // Get current package for simple type names
    let current_package = get_package(&class.class_type);
    let pkg = current_package.as_deref();

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
            add_renamed_comment(code, &method.name, CommentsLevel::Info);
        }
    }

    code.start_line();

    // Kotlin function modifiers (emitted as comments for Java output)
    // These appear before Java modifiers to mirror Kotlin syntax order
    let mut kotlin_mods = Vec::new();
    if method.is_suspend {
        kotlin_mods.push("suspend");
    }
    if method.is_inline_function {
        kotlin_mods.push("inline");
    }
    if method.is_infix {
        kotlin_mods.push("infix");
    }
    if method.is_operator {
        kotlin_mods.push("operator");
    }
    if method.is_tailrec {
        kotlin_mods.push("tailrec");
    }
    if !kotlin_mods.is_empty() {
        code.add("/* ").add(&kotlin_mods.join(" ")).add(" */ ");
    }

    // Method modifiers (skip for static initializers since we handle them specially)
    if !method.is_class_init() {
        let mods = access_flags::access_flags_to_string(method.access_flags, AccessContext::Method);
        if !mods.is_empty() {
            code.add(&mods);
        }
    }

    // Type parameters (e.g., <T, E extends Number>)
    let has_type_params = !method.is_constructor() && !method.is_class_init() && !method.type_parameters.is_empty();
    if has_type_params {
        generate_type_parameters(&method.type_parameters, imports, pkg, code);
        code.add(" "); // Space before return type
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
        // Regular method (use simple names when imports available or same package)
        code.add(&type_to_string_with_imports_and_package(&method.return_type, imports, pkg));
        code.add(" ");
        // Use alias if available from deobfuscation, sanitize for valid Java identifier
        code.add(&sanitize_method_name(method.display_name()));
    }

    // Parameters (except for static initializer)
    if !method.is_class_init() {
        add_parameters(method, imports, pkg, code);
    }

    // Throws clause (except for static initializer)
    if !method.is_class_init() {
        let throws = get_throws_from_annotations(&method.annotations);
        add_throws_clause(&throws, imports, pkg, code);
    }

    // Method body
    if method.is_abstract() || method.is_native() {
        // Abstract/native methods have no body
        // For annotation methods, emit default value if present
        // Like JADX's MethodGen.java lines 172-179
        if class.is_annotation() {
            if let Some(ref default_value) = method.annotation_default {
                code.add(" default ");
                code.add(&annotation_value_to_string(default_value));
            }
        }
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
    comments_level: CommentsLevel,
    add_debug_lines: bool,
    code: &mut W,
) {
    // Skip empty static initializers (JADX behavior)
    // A clinit is considered empty if it has no instructions or only a return-void
    if method.is_class_init() && is_empty_clinit(method) {
        return;
    }

    // Get current package for simple type names
    let current_package = get_package(&class.class_type);
    let pkg = current_package.as_deref();

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
            add_renamed_comment(code, &method.name, comments_level);
        }
    }

    code.start_line();

    // Kotlin function modifiers (emitted as comments for Java output)
    // These appear before Java modifiers to mirror Kotlin syntax order
    let mut kotlin_mods = Vec::new();
    if method.is_suspend {
        kotlin_mods.push("suspend");
    }
    if method.is_inline_function {
        kotlin_mods.push("inline");
    }
    if method.is_infix {
        kotlin_mods.push("infix");
    }
    if method.is_operator {
        kotlin_mods.push("operator");
    }
    if method.is_tailrec {
        kotlin_mods.push("tailrec");
    }
    if !kotlin_mods.is_empty() {
        code.add("/* ").add(&kotlin_mods.join(" ")).add(" */ ");
    }

    // Method modifiers (skip for static initializers since we handle them specially)
    if !method.is_class_init() {
        let mods = access_flags::access_flags_to_string(method.access_flags, AccessContext::Method);
        if !mods.is_empty() {
            code.add(&mods);
        }
    }

    // Type parameters (e.g., <T, E extends Number>)
    let has_type_params = !method.is_constructor() && !method.is_class_init() && !method.type_parameters.is_empty();
    if has_type_params {
        generate_type_parameters(&method.type_parameters, imports, pkg, code);
        code.add(" "); // Space before return type
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
        code.add(&type_to_string_with_imports_and_package(&method.return_type, imports, pkg));
        code.add(" ");
        // Use alias if available from deobfuscation, sanitize for valid Java identifier
        code.add(&sanitize_method_name(method.display_name()));
    }

    // Parameters (except for static initializer)
    if !method.is_class_init() {
        add_parameters(method, imports, pkg, code);
    }

    // Throws clause (except for static initializer)
    if !method.is_class_init() {
        let throws = get_throws_from_annotations(&method.annotations);
        add_throws_clause(&throws, imports, pkg, code);
    }

    // Method body
    if method.is_abstract() || method.is_native() {
        // Abstract/native methods have no body
        // For annotation methods, emit default value if present
        // Like JADX's MethodGen.java lines 172-179
        if class.is_annotation() {
            if let Some(ref default_value) = method.annotation_default {
                code.add(" default ");
                code.add(&annotation_value_to_string(default_value));
            }
        }
        code.add(";").newline();
    } else if method.is_class_init() {
        code.add(" {").newline();
        code.inc_indent();
        add_method_body_with_inner_classes(method, dex_info.clone(), imports, inner_classes, hierarchy, Some(&class.class_type), deobf_min_length, deobf_max_length, fallback, res_names, replace_consts, add_debug_lines, code);
        code.dec_indent();
        code.start_line().add("}").newline();
    } else {
        // Check if method is too complex to decompile cleanly
        // Match JADX behavior: emit stub for extremely complex methods
        if let Some(reason) = should_skip_complex_method(method) {
            code.add(" {").newline();
            code.inc_indent();
            code.start_line().add("/*").newline();
            code.start_line().add("    Method decompilation skipped: too complex").newline();
            code.start_line().add("    Reason: ").add(&reason).newline();
            code.start_line().add("    To view this dump add '--show-bad-code' option").newline();
            code.start_line().add("*/").newline();
            code.start_line().add("throw new UnsupportedOperationException(\"Method not decompiled: ")
                .add(&get_simple_name(&class.class_type))
                .add(".")
                .add(&sanitize_method_name(method.display_name()))
                .add("()\");")
                .newline();
            code.dec_indent();
            code.start_line().add("}").newline();
        } else {
            // Regular method with body
            code.add(" {").newline();
            code.inc_indent();
            add_method_body_with_inner_classes(method, dex_info.clone(), imports, inner_classes, hierarchy, Some(&class.class_type), deobf_min_length, deobf_max_length, fallback, res_names, replace_consts, add_debug_lines, code);
            code.dec_indent();
            code.start_line().add("}").newline();
        }
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
    add_debug_lines: bool,
    code: &mut W,
) {
    generate_body_with_inner_classes(method, dex_info, imports, inner_classes, hierarchy, current_class_type, deobf_min_length, deobf_max_length, fallback, res_names, replace_consts, add_debug_lines, code);
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
fn add_throws_clause<W: CodeWriter>(throws: &[String], imports: Option<&BTreeSet<String>>, current_package: Option<&str>, code: &mut W) {
    if throws.is_empty() {
        return;
    }
    code.add(" throws ");
    for (i, exception) in throws.iter().enumerate() {
        if i > 0 {
            code.add(", ");
        }
        // Use simple name if imported or same package
        code.add(&type_to_string_with_imports_and_package(&ArgType::Object(exception.clone()), imports, current_package));
    }
}

/// Add method parameters
fn add_parameters<W: CodeWriter>(method: &MethodData, imports: Option<&BTreeSet<String>>, current_package: Option<&str>, code: &mut W) {
    code.add("(");

    let is_varargs = method.access_flags & ACC_VARARGS != 0;
    let params = &method.arg_types;
    let param_count = params.len();

    // Generate all parameter names with collision detection (JADX parity)
    let param_names = generate_param_names(params, &method.arg_names);

    for (i, param_type) in params.iter().enumerate() {
        if i > 0 {
            code.add(", ");
        }

        // Parameter annotations (emit before the type, like JADX)
        if i < method.parameter_annotations.len() {
            for annotation in &method.parameter_annotations[i] {
                if should_emit_annotation(annotation) {
                    generate_annotation(annotation, code);
                    code.add(" ");
                }
            }
        }

        let is_last = i == param_count - 1;
        let is_last_vararg = is_last && is_varargs;

        // Type (convert last array to varargs if needed, use simple names when imports available or same package)
        if is_last_vararg {
            if let ArgType::Array(elem) = param_type {
                code.add(&type_to_string_with_imports_and_package(elem, imports, current_package));
                code.add("...");
            } else {
                // Fallback - shouldn't happen but handle gracefully
                code.add(&type_to_string_with_imports_and_package(param_type, imports, current_package));
            }
        } else {
            code.add(&type_to_string_with_imports_and_package(param_type, imports, current_package));
        }

        // Parameter name: use collision-detected name
        code.add(" ");
        code.add(&param_names[i]);
    }

    code.add(")");
}

/// Generate base parameter name from type (with "Var" suffix for short class names)
/// This matches JADX's ApplyVariableNames.fromName() logic
fn generate_base_param_name(ty: &ArgType) -> String {
    match ty {
        ArgType::Object(name) => {
            // JADX PARITY: Use OBJ_ALIAS mappings for common types first
            if name.contains("StringBuilder") || name.contains("StringBuffer") {
                return "sb".to_string();
            }
            if name.contains("String") {
                return "str".to_string();
            }
            if name.contains("Throwable") || name.contains("Error") {
                return "th".to_string();
            }
            if name.contains("Exception") {
                return "exc".to_string();
            }
            if name.contains("Class") && !name.contains("ClassLoader") {
                return "cls".to_string();
            }
            if name.contains("Iterator") {
                return "it".to_string();
            }
            if name.contains("Map") {
                return "map".to_string();
            }
            if name.contains("Set") {
                return "set".to_string();
            }
            if name.contains("List") || name.contains("Collection") || name.contains("Iterable") {
                return "list".to_string();
            }

            // JADX PARITY: Use innermost name (strip $ for inner classes)
            let simple = get_innermost_name(name);

            // Check if all uppercase (like "URL" → "url")
            let is_all_uppercase = simple.chars().all(|c| !c.is_ascii_lowercase());

            let base = if is_all_uppercase {
                simple.to_lowercase()
            } else {
                let mut chars = simple.chars();
                match chars.next() {
                    Some(c) => c.to_lowercase().chain(chars).collect(),
                    None => return "obj".to_string(),
                }
            };

            // JADX PARITY: Add "Var" suffix for short names (< 3 chars)
            if base.len() < 3 {
                format!("{}Var", base)
            } else {
                base
            }
        }
        ArgType::Array(elem) => {
            let elem_name = generate_base_param_name(elem);
            format!("{}Arr", elem_name)
        }
        ArgType::Int => "i".to_string(),
        ArgType::Long => "j".to_string(),
        ArgType::Float => "f".to_string(),
        ArgType::Double => "d".to_string(),
        ArgType::Boolean => "z".to_string(),
        ArgType::Byte => "b".to_string(),
        ArgType::Char => "c".to_string(),
        ArgType::Short => "s".to_string(),
        ArgType::Generic { base, .. } => {
            let simple = get_innermost_name(base);
            let mut chars = simple.chars();
            match chars.next() {
                Some(c) => {
                    let base: String = c.to_lowercase().chain(chars).collect();
                    if base.len() < 3 {
                        format!("{}Var", base)
                    } else {
                        base
                    }
                }
                None => "obj".to_string(),
            }
        }
        ArgType::TypeVariable(name) => name.to_lowercase(),
        ArgType::Wildcard { inner: Some(inner), .. } => generate_base_param_name(inner),
        ArgType::Wildcard { inner: None, .. } => "obj".to_string(),
        ArgType::Void => "v".to_string(),
        ArgType::Unknown | ArgType::UnknownNarrow | ArgType::UnknownWide
        | ArgType::UnknownObject | ArgType::UnknownArray | ArgType::UnknownIntegral => "obj".to_string(),
    }
}

/// Generate parameter names with collision detection (JADX parity)
/// This matches JADX's NameGen.getUniqueVarName() logic
fn generate_param_names(arg_types: &[ArgType], arg_names: &[Option<String>]) -> Vec<String> {
    use std::collections::HashSet;

    // First, generate base names for all parameters
    let base_names: Vec<String> = arg_types.iter().enumerate().map(|(i, ty)| {
        arg_names.get(i)
            .and_then(|n| n.clone())
            .unwrap_or_else(|| generate_base_param_name(ty))
    }).collect();

    // Then apply collision detection (JADX uses suffix starting at 2)
    let mut used: HashSet<String> = HashSet::new();
    let mut result = Vec::with_capacity(base_names.len());

    for base in base_names {
        if !used.contains(&base) {
            used.insert(base.clone());
            result.push(base);
        } else {
            // Find next available suffix starting at 2
            let mut suffix = 2;
            loop {
                let name = format!("{}{}", base, suffix);
                if !used.contains(&name) {
                    used.insert(name.clone());
                    result.push(name);
                    break;
                }
                suffix += 1;
            }
        }
    }

    result
}

/// Generate a parameter name based on type and index (legacy - kept for compatibility)
fn generate_param_name(index: usize, ty: &ArgType) -> String {
    // Try to generate a meaningful name from the type
    // NOTE: Must match body_gen.rs generate_param_name for consistency between signature and body
    let base = match ty {
        ArgType::Object(name) => {
            // JADX PARITY: Use OBJ_ALIAS mappings for common types first
            if name.contains("StringBuilder") || name.contains("StringBuffer") {
                return if index == 0 { "sb".to_string() } else { format!("sb{}", index + 1) };
            }
            if name.contains("String") {
                return if index == 0 { "str".to_string() } else { format!("str{}", index + 1) };
            }
            if name.contains("Throwable") || name.contains("Error") {
                return if index == 0 { "th".to_string() } else { format!("th{}", index + 1) };
            }
            if name.contains("Exception") {
                return if index == 0 { "exc".to_string() } else { format!("exc{}", index + 1) };
            }
            if name.contains("Class") && !name.contains("ClassLoader") {
                return if index == 0 { "cls".to_string() } else { format!("cls{}", index + 1) };
            }
            if name.contains("Iterator") {
                return if index == 0 { "it".to_string() } else { format!("it{}", index + 1) };
            }
            if name.contains("Map") {
                return if index == 0 { "map".to_string() } else { format!("map{}", index + 1) };
            }
            if name.contains("List") {
                return if index == 0 { "list".to_string() } else { format!("list{}", index + 1) };
            }
            if name.contains("Set") {
                return if index == 0 { "set".to_string() } else { format!("set{}", index + 1) };
            }
            if name.contains("Integer") || name.contains("Long") || name.contains("Double")
               || name.contains("Float") || name.contains("Number") {
                return if index == 0 { "num".to_string() } else { format!("num{}", index + 1) };
            }
            if name.contains("Boolean") {
                return if index == 0 { "bool".to_string() } else { format!("bool{}", index + 1) };
            }
            // Use innermost name (strip $ for inner classes) to match JADX
            let simple = get_innermost_name(name);
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
        ArgType::Long => "j".to_string(),  // JADX uses 'j' for long
        ArgType::Float => "f".to_string(),
        ArgType::Double => "d".to_string(),
        ArgType::Boolean => "z".to_string(),
        ArgType::Byte => "b".to_string(),
        ArgType::Char => "c".to_string(),
        ArgType::Short => "s".to_string(),
        // Handle generic types by extracting base class name
        ArgType::Generic { base, .. } => {
            // Use innermost name (strip $ for inner classes) to match JADX
            let simple = get_innermost_name(base);
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
        ArgType::Unknown | ArgType::UnknownNarrow | ArgType::UnknownWide
        | ArgType::UnknownObject | ArgType::UnknownArray | ArgType::UnknownIntegral => "obj".to_string(),
    };

    // Add numeric suffix for params after the first
    // JADX uses index+1 for suffixes: first param no suffix, second param suffix "2", etc.
    // This ensures consistency between method signature and body generation
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

        // Check that method signature has correct modifiers, return type, name and parameter types
        // JADX PARITY: String → "str" (from OBJ_ALIAS mappings)
        assert!(code.contains("public int bar(int i, String str)"), "Code was: {}", code);
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

        // JADX PARITY: String[] → "strArr" (from OBJ_ALIAS mappings + Arr suffix)
        assert!(code.contains("public void varargs(String... strArr)"), "Code was: {}", code);
    }

    #[test]
    fn test_static_initializer() {
        use dexterity_ir::instructions::{InsnNode, InsnType};

        let class = make_class();
        let mut method = make_method("<clinit>", ArgType::Void, ACC_STATIC);
        // Add instructions so clinit isn't considered "empty" (JADX skips empty clinits)
        method.set_instructions(vec![
            InsnNode::new(InsnType::Nop, 0),
            InsnNode::new(InsnType::Nop, 1),
        ]);
        let mut writer = SimpleCodeWriter::new();
        generate_method(&method, &class, false, &mut writer);
        let code = writer.finish();

        assert!(code.contains("static {"));
    }

    #[test]
    fn test_empty_clinit_is_skipped() {
        use dexterity_ir::instructions::{InsnNode, InsnType};

        let class = make_class();

        // Case 1: No instructions at all
        let method = make_method("<clinit>", ArgType::Void, ACC_STATIC);
        let mut writer = SimpleCodeWriter::new();
        generate_method(&method, &class, false, &mut writer);
        let code = writer.finish();
        assert!(!code.contains("static"), "Empty clinit (no instructions) should not generate output");

        // Case 2: Only return-void
        let mut method2 = make_method("<clinit>", ArgType::Void, ACC_STATIC);
        method2.set_instructions(vec![
            InsnNode::new(InsnType::Return { value: None }, 0),
        ]);
        let mut writer2 = SimpleCodeWriter::new();
        generate_method(&method2, &class, false, &mut writer2);
        let code2 = writer2.finish();
        assert!(!code2.contains("static"), "Empty clinit (only return-void) should not generate output");
    }

    #[test]
    fn test_type_parameters_with_variance() {
        use dexterity_ir::info::TypeVariance;

        // Test invariant (default) - no modifier
        let invariant_params = vec![TypeParameter {
            name: "T".to_string(),
            bounds: vec![],
            variance: TypeVariance::Invariant,
            reified: false,
        }];
        let mut writer = SimpleCodeWriter::new();
        generate_type_parameters(&invariant_params, None, None, &mut writer);
        assert_eq!(writer.finish(), "<T>");

        // Test covariant (out) - Kotlin producer
        let out_params = vec![TypeParameter {
            name: "E".to_string(),
            bounds: vec![],
            variance: TypeVariance::Covariant,
            reified: false,
        }];
        let mut writer = SimpleCodeWriter::new();
        generate_type_parameters(&out_params, None, None, &mut writer);
        assert_eq!(writer.finish(), "<out E>");

        // Test contravariant (in) - Kotlin consumer
        let in_params = vec![TypeParameter {
            name: "K".to_string(),
            bounds: vec![],
            variance: TypeVariance::Contravariant,
            reified: false,
        }];
        let mut writer = SimpleCodeWriter::new();
        generate_type_parameters(&in_params, None, None, &mut writer);
        assert_eq!(writer.finish(), "<in K>");

        // Test reified type parameter
        let reified_params = vec![TypeParameter {
            name: "T".to_string(),
            bounds: vec![],
            variance: TypeVariance::Invariant,
            reified: true,
        }];
        let mut writer = SimpleCodeWriter::new();
        generate_type_parameters(&reified_params, None, None, &mut writer);
        assert_eq!(writer.finish(), "<reified T>");

        // Test combined: out + reified
        let combined_params = vec![TypeParameter {
            name: "R".to_string(),
            bounds: vec![],
            variance: TypeVariance::Covariant,
            reified: true,
        }];
        let mut writer = SimpleCodeWriter::new();
        generate_type_parameters(&combined_params, None, None, &mut writer);
        assert_eq!(writer.finish(), "<out reified R>");
    }

    #[test]
    fn test_multiple_type_parameters_with_variance() {
        use dexterity_ir::info::TypeVariance;

        let params = vec![
            TypeParameter {
                name: "K".to_string(),
                bounds: vec![],
                variance: TypeVariance::Contravariant, // in
                reified: false,
            },
            TypeParameter {
                name: "V".to_string(),
                bounds: vec![],
                variance: TypeVariance::Covariant, // out
                reified: false,
            },
        ];
        let mut writer = SimpleCodeWriter::new();
        generate_type_parameters(&params, None, None, &mut writer);
        assert_eq!(writer.finish(), "<in K, out V>");
    }
}
