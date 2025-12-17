//! DEX/JVM signature helpers
//!
//! Used to disambiguate method aliases (overloads) when storing aliases in `AliasRegistry`.

use dexterity_ir::ArgType;

/// Convert an `ArgType` into a DEX type descriptor.
pub fn arg_type_to_descriptor(ty: &ArgType) -> String {
    match ty {
        ArgType::Void => "V".to_string(),
        ArgType::Boolean => "Z".to_string(),
        ArgType::Byte => "B".to_string(),
        ArgType::Char => "C".to_string(),
        ArgType::Short => "S".to_string(),
        ArgType::Int => "I".to_string(),
        ArgType::Long => "J".to_string(),
        ArgType::Float => "F".to_string(),
        ArgType::Double => "D".to_string(),
        ArgType::Object(name) => {
            let stripped = name
                .strip_prefix('L')
                .unwrap_or(name)
                .strip_suffix(';')
                .unwrap_or(name);
            format!("L{};", stripped)
        }
        ArgType::Array(elem) => format!("[{}", arg_type_to_descriptor(elem)),
        ArgType::Generic { base, .. } => {
            // Erase generics for descriptor purposes
            let stripped = base
                .strip_prefix('L')
                .unwrap_or(base)
                .strip_suffix(';')
                .unwrap_or(base);
            format!("L{};", stripped)
        }
        ArgType::Wildcard { inner: Some(inner), .. } => arg_type_to_descriptor(inner),
        ArgType::Wildcard { inner: None, .. } => "Ljava/lang/Object;".to_string(),
        ArgType::TypeVariable(_) => "Ljava/lang/Object;".to_string(), // Type erasure
        ArgType::Unknown => "Ljava/lang/Object;".to_string(),
        // Unknown variants during type inference - use Object as placeholder
        ArgType::UnknownNarrow => "I".to_string(),  // Could be int/float/etc
        ArgType::UnknownWide => "J".to_string(),    // Could be long/double
        ArgType::UnknownObject => "Ljava/lang/Object;".to_string(),
        ArgType::UnknownArray => "[Ljava/lang/Object;".to_string(),
        ArgType::UnknownIntegral => "I".to_string(),  // Integer-like
    }
}

/// Convert a method prototype into a DEX descriptor string: `(params)return`.
pub fn method_proto_to_descriptor(params: &[ArgType], ret: &ArgType) -> String {
    let mut out = String::new();
    out.push('(');
    for p in params {
        out.push_str(&arg_type_to_descriptor(p));
    }
    out.push(')');
    out.push_str(&arg_type_to_descriptor(ret));
    out
}

