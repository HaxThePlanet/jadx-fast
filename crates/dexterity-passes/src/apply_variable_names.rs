//! Apply Variable Names Pass
//!
//! Clone of JADX ApplyVariableNames.java (273 lines)
//! Reference: jadx-fast/jadx-core/src/main/java/jadx/core/dex/visitors/ApplyVariableNames.java
//!
//! This pass guesses variable names from usage patterns when debug info is unavailable.
//! Runs after ProcessVariables to apply names to declared variables.
//!
//! Key behaviors cloned from JADX:
//! - Type-based naming: String → "str", Exception → "exc", Iterator → "it"
//! - Invoke-based naming: getInstance() → className, getXxx() → "xxx"
//! - Constructor naming: new Foo() → "foo"
//! - Array length: arr.length → "length"
//! - Method argument preservation: keep existing valid names

use std::collections::HashMap;
use dexterity_ir::instructions::{InsnNode, InsnType};
use dexterity_ir::types::ArgType;
use crate::ssa::SsaResult;

/// Method info for invoke-based variable naming
#[derive(Debug, Clone)]
pub struct MethodNameInfo {
    pub method_name: String,
    pub class_name: String,
}

/// JADX Reference: ApplyVariableNames.java:39-55
/// Common type → variable name mappings
fn get_object_alias() -> HashMap<&'static str, &'static str> {
    let mut m = HashMap::new();
    m.insert("java/lang/String", "str");
    m.insert("Ljava/lang/String;", "str");
    m.insert("java/lang/Class", "cls");
    m.insert("Ljava/lang/Class;", "cls");
    m.insert("java/lang/Throwable", "th");
    m.insert("Ljava/lang/Throwable;", "th");
    m.insert("java/lang/Object", "obj");
    m.insert("Ljava/lang/Object;", "obj");
    m.insert("java/util/Iterator", "it");
    m.insert("Ljava/util/Iterator;", "it");
    m.insert("java/util/HashMap", "map");
    m.insert("Ljava/util/HashMap;", "map");
    m.insert("java/lang/Boolean", "bool");
    m.insert("Ljava/lang/Boolean;", "bool");
    m.insert("java/lang/Short", "sh");
    m.insert("Ljava/lang/Short;", "sh");
    m.insert("java/lang/Integer", "num");
    m.insert("Ljava/lang/Integer;", "num");
    m.insert("java/lang/Character", "ch");
    m.insert("Ljava/lang/Character;", "ch");
    m.insert("java/lang/Byte", "b");
    m.insert("Ljava/lang/Byte;", "b");
    m.insert("java/lang/Float", "f");
    m.insert("Ljava/lang/Float;", "f");
    m.insert("java/lang/Long", "l");
    m.insert("Ljava/lang/Long;", "l");
    m.insert("java/lang/Double", "d");
    m.insert("Ljava/lang/Double;", "d");
    m.insert("java/lang/StringBuilder", "sb");
    m.insert("Ljava/lang/StringBuilder;", "sb");
    m.insert("java/lang/Exception", "exc");
    m.insert("Ljava/lang/Exception;", "exc");
    m
}

/// JADX Reference: ApplyVariableNames.java:57-58
/// Variable names that are good as-is
const GOOD_VAR_NAMES: &[&str] = &["size", "length", "list", "map", "next"];

/// JADX Reference: ApplyVariableNames.java:59-60
/// Method name prefixes to strip
const INVOKE_PREFIXES: &[&str] = &["get", "set", "to", "parse", "read", "format"];

/// Result of applying variable names
#[derive(Debug, Default)]
pub struct ApplyVariableNamesResult {
    /// Number of variables renamed
    pub renamed_count: usize,
    /// Number of variables with type-based names
    pub type_based_names: usize,
    /// Number of variables with invoke-based names
    pub invoke_based_names: usize,
}

/// Apply variable names to SSA variables
///
/// JADX Reference: ApplyVariableNames.visit()
/// Reference: jadx-fast/jadx-core/src/main/java/jadx/core/dex/visitors/ApplyVariableNames.java:70-78
pub fn apply_variable_names(
    ssa: &SsaResult,
    existing_names: &mut HashMap<(u16, u32), String>,
    types: &HashMap<(u16, u32), ArgType>,
) -> ApplyVariableNamesResult {
    apply_variable_names_with_lookups(ssa, existing_names, types, None, None)
}

/// Apply variable names with optional method/type lookups for better naming
///
/// This enhanced version can extract meaningful names from:
/// - Invoke instructions (getString() → "string", getInstance() → className)
/// - NewInstance instructions (new HashMap() → "hashMap")
///
/// JADX Reference: ApplyVariableNames.java:70-78
pub fn apply_variable_names_with_lookups<'a>(
    ssa: &SsaResult,
    existing_names: &mut HashMap<(u16, u32), String>,
    types: &HashMap<(u16, u32), ArgType>,
    method_lookup: Option<&'a dyn Fn(u32) -> Option<MethodNameInfo>>,
    type_lookup: Option<&'a dyn Fn(u32) -> Option<String>>,
) -> ApplyVariableNamesResult {
    let mut result = ApplyVariableNamesResult::default();
    let obj_alias = get_object_alias();

    // Build a map of definitions: (reg, ssa) -> defining instruction
    let mut definitions: HashMap<(u16, u32), &InsnNode> = HashMap::new();
    for block in &ssa.blocks {
        for insn in &block.instructions {
            if let Some((reg, ssa_ver)) = get_dest_register(insn) {
                definitions.insert((reg, ssa_ver), insn);
            }
        }
    }

    // Apply names to variables that don't have good names
    for (&key, var_type) in types {
        // Skip if already has a good name
        if let Some(name) = existing_names.get(&key) {
            if is_valid_name(name) {
                continue;
            }
        }

        // Try to guess name from usage
        if let Some(new_name) = guess_name_with_lookups(key, var_type, &definitions, &obj_alias, method_lookup, type_lookup) {
            existing_names.insert(key, new_name.clone());
            result.renamed_count += 1;

            // Track naming source for statistics
            if definitions.get(&key).map(|i| matches!(i.insn_type, InsnType::Invoke { .. })).unwrap_or(false) {
                result.invoke_based_names += 1;
            } else {
                result.type_based_names += 1;
            }
        }
    }

    result
}

/// Get destination register from instruction
fn get_dest_register(insn: &InsnNode) -> Option<(u16, u32)> {
    match &insn.insn_type {
        InsnType::Move { dest, .. } => Some((dest.reg_num, dest.ssa_version)),
        InsnType::Const { dest, .. } => Some((dest.reg_num, dest.ssa_version)),
        InsnType::Binary { dest, .. } => Some((dest.reg_num, dest.ssa_version)),
        InsnType::Unary { dest, .. } => Some((dest.reg_num, dest.ssa_version)),
        InsnType::Invoke { dest: Some(dest), .. } => Some((dest.reg_num, dest.ssa_version)),
        InsnType::InstanceGet { dest, .. } => Some((dest.reg_num, dest.ssa_version)),
        InsnType::StaticGet { dest, .. } => Some((dest.reg_num, dest.ssa_version)),
        InsnType::ArrayGet { dest, .. } => Some((dest.reg_num, dest.ssa_version)),
        InsnType::ArrayLength { dest, .. } => Some((dest.reg_num, dest.ssa_version)),
        InsnType::NewInstance { dest, .. } => Some((dest.reg_num, dest.ssa_version)),
        InsnType::NewArray { dest, .. } => Some((dest.reg_num, dest.ssa_version)),
        InsnType::Cast { dest, .. } => Some((dest.reg_num, dest.ssa_version)),
        // CheckCast modifies object in place, doesn't have a separate dest
        // InstanceOf stores result in a dest register
        InsnType::InstanceOf { dest, .. } => Some((dest.reg_num, dest.ssa_version)),
        _ => None,
    }
}

/// Check if a name is valid (not a placeholder like "v0", "p0", etc.)
///
/// JADX Reference: NameMapper.isValidAndPrintable()
fn is_valid_name(name: &str) -> bool {
    if name.is_empty() {
        return false;
    }

    // Reject placeholder names
    if name.len() <= 3 {
        let first = name.chars().next().unwrap();
        if (first == 'v' || first == 'p' || first == 'r') && name[1..].parse::<u32>().is_ok() {
            return false;
        }
    }

    // Must be a valid Java identifier
    let mut chars = name.chars();
    if let Some(first) = chars.next() {
        if !first.is_alphabetic() && first != '_' && first != '$' {
            return false;
        }
    }
    for c in chars {
        if !c.is_alphanumeric() && c != '_' && c != '$' {
            return false;
        }
    }

    true
}

/// Guess variable name from type and usage (without lookups)
fn guess_name(
    key: (u16, u32),
    var_type: &ArgType,
    definitions: &HashMap<(u16, u32), &InsnNode>,
    obj_alias: &HashMap<&str, &str>,
) -> Option<String> {
    guess_name_with_lookups(key, var_type, definitions, obj_alias, None, None)
}

/// Guess variable name from type and usage with optional lookups
///
/// JADX Reference: ApplyVariableNames.guessName()
/// Reference: jadx-fast/jadx-core/src/main/java/jadx/core/dex/visitors/ApplyVariableNames.java:80-107
fn guess_name_with_lookups<'a>(
    key: (u16, u32),
    var_type: &ArgType,
    definitions: &HashMap<(u16, u32), &InsnNode>,
    obj_alias: &HashMap<&str, &str>,
    method_lookup: Option<&'a dyn Fn(u32) -> Option<MethodNameInfo>>,
    type_lookup: Option<&'a dyn Fn(u32) -> Option<String>>,
) -> Option<String> {
    // Try to get name from defining instruction
    if let Some(insn) = definitions.get(&key) {
        if let Some(name) = make_name_from_insn_with_lookups(insn, obj_alias, method_lookup, type_lookup) {
            return Some(name);
        }
    }

    // Fall back to type-based naming
    make_name_for_type(var_type, obj_alias)
}

/// Make name from instruction without lookups (backward compatible)
fn make_name_from_insn(insn: &InsnNode, obj_alias: &HashMap<&str, &str>) -> Option<String> {
    make_name_from_insn_with_lookups(insn, obj_alias, None, None)
}

/// Make name from instruction with optional lookups
///
/// JADX Reference: ApplyVariableNames.makeNameFromInsn()
/// Reference: jadx-fast/jadx-core/src/main/java/jadx/core/dex/visitors/ApplyVariableNames.java:124-159
fn make_name_from_insn_with_lookups<'a>(
    insn: &InsnNode,
    _obj_alias: &HashMap<&str, &str>,
    method_lookup: Option<&'a dyn Fn(u32) -> Option<MethodNameInfo>>,
    type_lookup: Option<&'a dyn Fn(u32) -> Option<String>>,
) -> Option<String> {
    match &insn.insn_type {
        // Invoke - extract name from method name
        // getString() -> "string", getInstance() -> className, iterator() -> "it"
        InsnType::Invoke { method_idx, .. } => {
            if let Some(lookup) = method_lookup {
                if let Some(info) = lookup(*method_idx) {
                    // Special methods first
                    if let Some(special) = extract_special_method_name(&info.method_name, &info.class_name) {
                        return Some(special);
                    }
                    // Then try prefix stripping (getUser -> user)
                    if let Some(base) = cut_invoke_prefix(&info.method_name) {
                        return Some(base);
                    }
                    // Fall back to method name if reasonable length
                    if info.method_name.len() <= 12 && !info.method_name.starts_with('<') {
                        return Some(info.method_name.clone());
                    }
                }
            }
            None
        }

        // NewInstance - use class name for variable name
        // new HashMap() -> "hashMap", new File() -> "file"
        InsnType::NewInstance { type_idx, .. } => {
            if let Some(lookup) = type_lookup {
                if let Some(type_name) = lookup(*type_idx) {
                    let simple_name = extract_simple_class_name(&type_name);
                    return Some(make_name_from_class_name(&simple_name));
                }
            }
            None
        }

        // NewArray - try to use element type for naming
        InsnType::NewArray { type_idx, .. } => {
            if let Some(lookup) = type_lookup {
                if let Some(type_name) = lookup(*type_idx) {
                    // For array types, extract element type and add "Arr" suffix
                    let base = extract_simple_class_name(&type_name);
                    let base_lower = make_name_from_class_name(&base);
                    return Some(format!("{}Arr", base_lower));
                }
            }
            Some("arr".to_string())
        }

        // CheckCast - use target type
        InsnType::CheckCast { type_idx, .. } => {
            if let Some(lookup) = type_lookup {
                if let Some(type_name) = lookup(*type_idx) {
                    let simple_name = extract_simple_class_name(&type_name);
                    return Some(make_name_from_class_name(&simple_name));
                }
            }
            None
        }

        // ArrayLength always returns "length"
        InsnType::ArrayLength { .. } => Some("length".to_string()),

        // ConstString -> "str"
        InsnType::ConstString { .. } => Some("str".to_string()),

        // InstanceOf -> boolean result
        InsnType::InstanceOf { .. } => Some("z".to_string()),

        // Compare -> comparison result
        InsnType::Compare { .. } => Some("cmp".to_string()),

        _ => None,
    }
}

/// Extract special method name patterns
/// JADX: ApplyVariableNames special method cases
fn extract_special_method_name(method_name: &str, class_name: &str) -> Option<String> {
    // getInstance() -> className (lowercase first letter)
    if method_name == "getInstance" || method_name == "newInstance" {
        let simple = extract_simple_class_name(class_name);
        return Some(make_name_from_class_name(&simple));
    }

    // iterator() -> "it"
    if method_name == "iterator" {
        return Some("it".to_string());
    }

    // next() for iterators -> "next"
    if method_name == "next" && class_name.contains("Iterator") {
        return Some("next".to_string());
    }

    // valueOf() -> type-based name
    if method_name == "valueOf" {
        let simple = extract_simple_class_name(class_name);
        return Some(make_name_from_class_name(&simple));
    }

    // size() -> "size", length() -> "length"
    if method_name == "size" || method_name == "length" || method_name == "count" {
        return Some(method_name.to_string());
    }

    None
}

/// Make name for type
///
/// JADX Reference: ApplyVariableNames.makeNameForType()
/// Reference: jadx-fast/jadx-core/src/main/java/jadx/core/dex/visitors/ApplyVariableNames.java:161-169
fn make_name_for_type(arg_type: &ArgType, obj_alias: &HashMap<&str, &str>) -> Option<String> {
    match arg_type {
        ArgType::Boolean => Some("z".to_string()),
        ArgType::Byte => Some("b".to_string()),
        ArgType::Short => Some("s".to_string()),
        ArgType::Char => Some("c".to_string()),
        ArgType::Int => Some("i".to_string()),
        ArgType::Long => Some("j".to_string()),
        ArgType::Float => Some("f".to_string()),
        ArgType::Double => Some("d".to_string()),
        ArgType::Void => None,

        ArgType::Object(class_name) => {
            // Check alias map first
            if let Some(&alias) = obj_alias.get(class_name.as_str()) {
                return Some(alias.to_string());
            }

            // Extract simple class name
            let simple_name = extract_simple_class_name(class_name);
            Some(make_name_from_class_name(&simple_name))
        }

        ArgType::Array(elem_type) => {
            // arrType + "Arr"
            if let Some(base_name) = make_name_for_type(elem_type, obj_alias) {
                Some(format!("{}Arr", base_name))
            } else {
                Some("arr".to_string())
            }
        }

        ArgType::Unknown => Some("obj".to_string()),

        _ => Some("var".to_string()),
    }
}

/// Extract simple class name from full class name
///
/// "Lcom/example/MyClass;" -> "MyClass"
/// "com/example/MyClass" -> "MyClass"
fn extract_simple_class_name(class_name: &str) -> String {
    let name = class_name
        .trim_start_matches('L')
        .trim_end_matches(';');

    // Get last component after / or $
    if let Some(pos) = name.rfind(|c| c == '/' || c == '$') {
        name[pos + 1..].to_string()
    } else {
        name.to_string()
    }
}

/// Make variable name from class name
///
/// JADX Reference: ApplyVariableNames.fromName() and makeNameForCheckedClass()
/// Reference: jadx-fast/jadx-core/src/main/java/jadx/core/dex/visitors/ApplyVariableNames.java:185-222
fn make_name_from_class_name(class_name: &str) -> String {
    if class_name.is_empty() {
        return "obj".to_string();
    }

    // If all uppercase, lowercase it
    if class_name.chars().all(|c| c.is_uppercase() || !c.is_alphabetic()) {
        return class_name.to_lowercase();
    }

    // Lowercase first character
    let mut chars: Vec<char> = class_name.chars().collect();
    if !chars.is_empty() {
        chars[0] = chars[0].to_lowercase().next().unwrap_or(chars[0]);
    }
    let result: String = chars.into_iter().collect();

    // If result equals original (was already lowercase), add "Var" suffix
    if result == class_name {
        if class_name.len() < 3 {
            return format!("{}Var", class_name);
        }
    }

    result
}

/// Cut invoke prefix from method name
///
/// JADX Reference: ApplyVariableNames.cutPrefix()
/// Reference: jadx-fast/jadx-core/src/main/java/jadx/core/dex/visitors/ApplyVariableNames.java:259-266
fn cut_invoke_prefix(name: &str) -> Option<String> {
    for prefix in INVOKE_PREFIXES {
        if name.starts_with(prefix) && name.len() > prefix.len() {
            let suffix = &name[prefix.len()..];
            // Lowercase first char of suffix
            let mut chars: Vec<char> = suffix.chars().collect();
            if !chars.is_empty() {
                chars[0] = chars[0].to_lowercase().next().unwrap_or(chars[0]);
            }
            return Some(chars.into_iter().collect());
        }
    }
    None
}

#[cfg(test)]
mod tests {
    use super::*;

    #[test]
    fn test_extract_simple_class_name() {
        assert_eq!(extract_simple_class_name("Lcom/example/MyClass;"), "MyClass");
        assert_eq!(extract_simple_class_name("com/example/Outer$Inner"), "Inner");
        assert_eq!(extract_simple_class_name("java/lang/String"), "String");
    }

    #[test]
    fn test_make_name_from_class_name() {
        assert_eq!(make_name_from_class_name("String"), "string");
        assert_eq!(make_name_from_class_name("IOException"), "iOException");
        assert_eq!(make_name_from_class_name("URL"), "url");
        assert_eq!(make_name_from_class_name("a"), "aVar");
    }

    #[test]
    fn test_cut_invoke_prefix() {
        assert_eq!(cut_invoke_prefix("getName"), Some("name".to_string()));
        assert_eq!(cut_invoke_prefix("setVisible"), Some("visible".to_string()));
        assert_eq!(cut_invoke_prefix("toString"), Some("string".to_string()));
        assert_eq!(cut_invoke_prefix("foo"), None);
    }

    #[test]
    fn test_is_valid_name() {
        assert!(!is_valid_name("v0"));
        assert!(!is_valid_name("p1"));
        assert!(!is_valid_name("r2"));
        assert!(is_valid_name("name"));
        assert!(is_valid_name("myVar"));
        assert!(is_valid_name("_temp"));
    }
}
