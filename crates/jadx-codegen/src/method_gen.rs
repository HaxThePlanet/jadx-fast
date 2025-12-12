//! Method code generation
//!
//! Generates Java source code for methods.

use jadx_ir::{ArgType, ClassData, MethodData};

use crate::access_flags::{self, flags::*, AccessContext};
use crate::type_gen::{get_simple_name, type_to_string};
use crate::writer::CodeWriter;

/// Generate a method into a writer
pub fn generate_method<W: CodeWriter>(
    method: &MethodData,
    class: &ClassData,
    _fallback: bool,
    code: &mut W,
) {
    code.start_line();

    // Method modifiers
    let mods = access_flags::access_flags_to_string(method.access_flags, AccessContext::Method);
    if !mods.is_empty() {
        code.add(&mods);
    }

    // Return type and name
    if method.is_constructor() {
        // Constructor - use class simple name, no return type
        let class_name = get_simple_name(&class.class_type);
        code.add(class_name);
    } else if method.is_class_init() {
        // Static initializer
        code.add("static");
    } else {
        // Regular method
        code.add(&type_to_string(&method.return_type));
        code.add(" ");
        code.add(&method.name);
    }

    // Parameters (except for static initializer)
    if !method.is_class_init() {
        add_parameters(method, code);
    }

    // Method body
    if method.is_abstract() || method.is_native() {
        // Abstract/native methods have no body
        code.add(";").newline();
    } else if method.is_class_init() {
        // Static initializer block
        code.add(" {").newline();
        code.inc_indent();
        add_method_body(method, code);
        code.dec_indent();
        code.start_line().add("}").newline();
    } else {
        // Regular method with body
        code.add(" {").newline();
        code.inc_indent();
        add_method_body(method, code);
        code.dec_indent();
        code.start_line().add("}").newline();
    }
}

/// Add method parameters
fn add_parameters<W: CodeWriter>(method: &MethodData, code: &mut W) {
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

        // Type (convert last array to varargs if needed)
        if is_last_vararg {
            if let ArgType::Array(elem) = param_type {
                code.add(&type_to_string(elem));
                code.add("...");
            } else {
                // Fallback - shouldn't happen but handle gracefully
                code.add(&type_to_string(param_type));
            }
        } else {
            code.add(&type_to_string(param_type));
        }

        // Parameter name (generated)
        code.add(" ");
        code.add(&generate_param_name(i, param_type));
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
                None => format!("arg{}", index),
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
        ArgType::Boolean => "flag".to_string(),
        ArgType::Byte => "b".to_string(),
        ArgType::Char => "c".to_string(),
        ArgType::Short => "s".to_string(),
        _ => format!("arg{}", index),
    };

    // Add index suffix if needed to avoid conflicts
    if index == 0 {
        base
    } else {
        format!("{}{}", base, index)
    }
}

/// Add method body (stub for now - full decompilation TODO)
fn add_method_body<W: CodeWriter>(method: &MethodData, code: &mut W) {
    if method.instructions.is_empty() {
        // No instructions - add TODO comment
        code.start_line().add("/* TODO: decompilation not implemented */").newline();

        // Add default return if needed
        add_default_return(&method.return_type, code);
    } else {
        // Has instructions but we can't decompile yet
        code.start_line().add("/* ").add(&format!("{} instructions", method.instructions.len())).add(" */").newline();

        // For now, just add a throw or default return
        add_stub_body(method, code);
    }
}

/// Add a stub body for undecompiled methods
fn add_stub_body<W: CodeWriter>(method: &MethodData, code: &mut W) {
    // Option 1: throw UnsupportedOperationException
    // code.start_line().add("throw new UnsupportedOperationException(\"Decompilation not implemented\");").newline();

    // Option 2: return default value (less noisy)
    add_default_return(&method.return_type, code);
}

/// Add a default return statement for the given type
fn add_default_return<W: CodeWriter>(return_type: &ArgType, code: &mut W) {
    match return_type {
        ArgType::Void => {
            // No return needed
        }
        ArgType::Boolean => {
            code.start_line().add("return false;").newline();
        }
        ArgType::Byte | ArgType::Char | ArgType::Short | ArgType::Int => {
            code.start_line().add("return 0;").newline();
        }
        ArgType::Long => {
            code.start_line().add("return 0L;").newline();
        }
        ArgType::Float => {
            code.start_line().add("return 0.0f;").newline();
        }
        ArgType::Double => {
            code.start_line().add("return 0.0d;").newline();
        }
        ArgType::Object(_) | ArgType::Array(_) | ArgType::Generic { .. } | ArgType::Wildcard { .. } => {
            code.start_line().add("return null;").newline();
        }
        ArgType::Unknown => {
            code.start_line().add("return null;").newline();
        }
    }
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
