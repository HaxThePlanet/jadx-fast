//! Enum class reconstruction pass
//!
//! This pass analyzes enum classes to extract:
//! - Enum field names and ordinals
//! - Constructor arguments for each enum value
//! - The $VALUES field
//!
//! Based on JADX's EnumVisitor.

use std::collections::HashMap;
use dexterity_ir::instructions::{InsnArg, InsnNode, InsnType, LiteralArg, InvokeKind};
use dexterity_ir::{ArgType, ClassData, FieldData, MethodData};

/// Information about an enum class
#[derive(Debug, Clone)]
pub struct EnumClassInfo {
    /// The enum class type
    pub class_type: String,
    /// Enum fields in order
    pub fields: Vec<EnumFieldInfo>,
    /// Index of the $VALUES field in static_fields
    pub values_field_idx: Option<usize>,
    /// Index of the <clinit> method
    pub class_init_idx: Option<usize>,
}

/// Information about a single enum field
#[derive(Debug, Clone)]
pub struct EnumFieldInfo {
    /// Field name
    pub name: String,
    /// Ordinal value
    pub ordinal: i32,
    /// Index of the field in static_fields
    pub field_idx: usize,
    /// Constructor arguments (beyond name and ordinal)
    pub extra_args: Vec<EnumArg>,
}

/// An argument to an enum constructor
#[derive(Debug, Clone)]
pub enum EnumArg {
    /// Integer literal
    Int(i64),
    /// Float literal
    Float(f64),
    /// Boolean literal
    Bool(bool),
    /// Null
    Null,
    /// Reference to another enum field
    EnumRef(String),
    /// Other (not recognized)
    Other,
}

/// Result of enum analysis
#[derive(Debug, Default)]
pub struct EnumVisitorResult {
    /// Information about analyzed enum classes
    pub enum_infos: HashMap<String, EnumClassInfo>,
    /// Number of enum classes found
    pub enum_count: usize,
    /// Number successfully analyzed
    pub analyzed_count: usize,
}

/// Analyze a class for enum patterns
pub fn analyze_enum_class(class: &ClassData) -> Option<EnumClassInfo> {
    // Must be an enum class
    if !class.is_enum() {
        return None;
    }

    // Must extend java.lang.Enum
    if class.superclass.as_deref() != Some("Ljava/lang/Enum;") {
        return None;
    }

    let mut info = EnumClassInfo {
        class_type: class.class_type.clone(),
        fields: Vec::new(),
        values_field_idx: None,
        class_init_idx: None,
    };

    // Find the $VALUES field
    let values_field_idx = find_values_field(class)?;
    info.values_field_idx = Some(values_field_idx);

    // Find the <clinit> method
    let clinit_idx = class.methods.iter().position(|m| m.name == "<clinit>")?;
    info.class_init_idx = Some(clinit_idx);

    // Analyze the static initializer to extract enum fields
    let clinit = &class.methods[clinit_idx];
    let fields = extract_enum_fields(class, clinit)?;
    info.fields = fields;

    Some(info)
}

/// Check if a type matches the class type
fn type_matches_class(field_type: &ArgType, class_type: &str) -> bool {
    match field_type {
        ArgType::Object(s) => s == class_type,
        _ => false,
    }
}

/// Check if a type is an array of the class type
fn type_is_array_of_class(field_type: &ArgType, class_type: &str) -> bool {
    match field_type {
        ArgType::Array(inner) => type_matches_class(inner, class_type),
        _ => false,
    }
}

/// Find the $VALUES field (static array of the enum type)
fn find_values_field(class: &ClassData) -> Option<usize> {
    for (idx, field) in class.static_fields.iter().enumerate() {
        // Check if it's a static array of the enum type
        if type_is_array_of_class(&field.field_type, &class.class_type) {
            // Prefer field named $VALUES
            if field.name == "$VALUES" {
                return Some(idx);
            }
        }
    }

    // Fallback: find any static array of enum type
    for (idx, field) in class.static_fields.iter().enumerate() {
        if type_is_array_of_class(&field.field_type, &class.class_type) {
            // Check if it's synthetic (access flag 0x1000)
            if field.access_flags & 0x1000 != 0 {
                return Some(idx);
            }
        }
    }

    // Last resort: any static array of this type
    class.static_fields.iter()
        .position(|f| type_is_array_of_class(&f.field_type, &class.class_type))
}

/// Extract enum fields from the static initializer
fn extract_enum_fields(class: &ClassData, clinit: &MethodData) -> Option<Vec<EnumFieldInfo>> {
    let insns = clinit.get_instructions();
    if insns.is_empty() {
        return None;
    }

    let mut fields: Vec<EnumFieldInfo> = Vec::new();
    let mut pending_constructs: HashMap<u16, PendingConstruct> = HashMap::new();

    // Pass 1: Find constructor calls and store in map by register
    for insn in insns.iter() {
        if let InsnType::Invoke { kind: InvokeKind::Direct, args, .. } = &insn.insn_type {
            // Check if this is a constructor call for our enum type
            // Constructor calls have the instance as first argument
            if args.is_empty() {
                continue;
            }

            // Get the instance register
            if let InsnArg::Register(reg) = &args[0] {
                // Check if args[1] is a string (enum name) and args[2] is int (ordinal)
                if args.len() >= 3 {
                    let name = extract_string_arg(&args[1], insns);
                    let ordinal = extract_int_arg(&args[2], insns);

                    if let (Some(name), Some(ordinal)) = (name, ordinal) {
                        // Extract extra constructor arguments
                        let extra_args: Vec<EnumArg> = args.iter().skip(3)
                            .map(|a| convert_to_enum_arg(a, insns))
                            .collect();

                        pending_constructs.insert(reg.reg_num, PendingConstruct {
                            name,
                            ordinal: ordinal as i32,
                            extra_args,
                        });
                    }
                }
            }
        }
    }

    // Pass 2: Find SPUT instructions that store enum instances to static fields
    for (field_idx, field) in class.static_fields.iter().enumerate() {
        // Skip if not an enum field (should be same type as class)
        if !type_matches_class(&field.field_type, &class.class_type) {
            continue;
        }

        // Skip synthetic/values field
        if field.name.starts_with('$') {
            continue;
        }

        // Look for SPUT that stores to this field
        for insn in insns.iter() {
            if let InsnType::StaticPut { value, .. } = &insn.insn_type {
                // Check if storing to this field
                if let InsnArg::Register(reg) = value {
                    if let Some(construct) = pending_constructs.get(&reg.reg_num) {
                        // Check if this field matches the construct name
                        if field.name == construct.name {
                            fields.push(EnumFieldInfo {
                                name: construct.name.clone(),
                                ordinal: construct.ordinal,
                                field_idx,
                                extra_args: construct.extra_args.clone(),
                            });
                        }
                    }
                }
            }
        }
    }

    // If we didn't find fields via SPUT, try alternative approach
    // using field names directly
    if fields.is_empty() {
        for (field_idx, field) in class.static_fields.iter().enumerate() {
            if !type_matches_class(&field.field_type, &class.class_type) {
                continue;
            }
            if field.name.starts_with('$') {
                continue;
            }

            // Check if there's a construct with matching name
            if let Some(construct) = pending_constructs.values()
                .find(|c| c.name == field.name)
            {
                fields.push(EnumFieldInfo {
                    name: construct.name.clone(),
                    ordinal: construct.ordinal,
                    field_idx,
                    extra_args: construct.extra_args.clone(),
                });
            } else {
                // Create field with unknown ordinal
                let ordinal = fields.len() as i32;
                fields.push(EnumFieldInfo {
                    name: field.name.clone(),
                    ordinal,
                    field_idx,
                    extra_args: Vec::new(),
                });
            }
        }
    }

    // Sort by ordinal
    fields.sort_by_key(|f| f.ordinal);

    if fields.is_empty() {
        None
    } else {
        Some(fields)
    }
}

/// Temporary struct for constructor info
struct PendingConstruct {
    name: String,
    ordinal: i32,
    extra_args: Vec<EnumArg>,
}

/// Extract a string argument from an instruction argument
/// Note: In DEX, strings are loaded via const-string with string_idx
fn extract_string_arg(arg: &InsnArg, insns: &[InsnNode]) -> Option<String> {
    match arg {
        InsnArg::Register(reg) => {
            // Look for CONST_STRING that defines this register
            for insn in insns {
                if let InsnType::ConstString { dest, .. } = &insn.insn_type {
                    if dest.reg_num == reg.reg_num {
                        // We don't have access to the string pool here,
                        // so we'll use the field name as a fallback
                        return Some(format!("string_{}", reg.reg_num));
                    }
                }
            }
            None
        }
        _ => None,
    }
}

/// Extract an integer argument from an instruction argument
fn extract_int_arg(arg: &InsnArg, insns: &[InsnNode]) -> Option<i64> {
    match arg {
        InsnArg::Literal(LiteralArg::Int(n)) => Some(*n),
        InsnArg::Register(reg) => {
            // Look for CONST that defines this register
            for insn in insns {
                if let InsnType::Const { dest, value: LiteralArg::Int(n) } = &insn.insn_type {
                    if dest.reg_num == reg.reg_num {
                        return Some(*n);
                    }
                }
            }
            None
        }
        _ => None,
    }
}

/// Convert an instruction argument to an EnumArg
fn convert_to_enum_arg(arg: &InsnArg, insns: &[InsnNode]) -> EnumArg {
    match arg {
        InsnArg::Literal(lit) => match lit {
            LiteralArg::Int(n) => EnumArg::Int(*n),
            LiteralArg::Float(f) => EnumArg::Float(*f as f64),
            LiteralArg::Double(d) => EnumArg::Float(*d),
            LiteralArg::Null => EnumArg::Null,
        },
        InsnArg::Register(reg) => {
            // Try to find what defines this register
            for insn in insns {
                match &insn.insn_type {
                    InsnType::Const { dest, value } if dest.reg_num == reg.reg_num => {
                        return match value {
                            LiteralArg::Int(0) => EnumArg::Bool(false),
                            LiteralArg::Int(1) => EnumArg::Bool(true),
                            LiteralArg::Int(n) => EnumArg::Int(*n),
                            LiteralArg::Float(f) => EnumArg::Float(*f as f64),
                            LiteralArg::Double(d) => EnumArg::Float(*d),
                            LiteralArg::Null => EnumArg::Null,
                        };
                    }
                    InsnType::ConstString { dest, .. } if dest.reg_num == reg.reg_num => {
                        // String constant - we don't have access to string pool
                        return EnumArg::Other;
                    }
                    InsnType::StaticGet { dest, .. } if dest.reg_num == reg.reg_num => {
                        // Could be a reference to another enum value
                        return EnumArg::EnumRef(format!("field_{}", reg.reg_num));
                    }
                    _ => {}
                }
            }
            EnumArg::Other
        }
        _ => EnumArg::Other,
    }
}

/// Check if a method should be hidden because it's an enum synthetic method
pub fn is_enum_synthetic_method(class: &ClassData, method: &MethodData) -> bool {
    if !class.is_enum() {
        return false;
    }

    // Check for values() method
    if method.name == "values" && method.arg_types.is_empty() {
        return true;
    }

    // Check for valueOf(String) method
    if method.name == "valueOf" && method.arg_types.len() == 1 {
        if let Some(ArgType::Object(s)) = method.arg_types.first() {
            if s == "Ljava/lang/String;" {
                return true;
            }
        }
    }

    false
}

/// Check if a field should be hidden because it's $VALUES
pub fn is_values_field(class: &ClassData, field: &FieldData) -> bool {
    if !class.is_enum() {
        return false;
    }

    type_is_array_of_class(&field.field_type, &class.class_type)
        && (field.name == "$VALUES" || field.access_flags & 0x1000 != 0)
}

#[cfg(test)]
mod tests {
    use super::*;

    fn make_enum_class() -> ClassData {
        let mut class = ClassData::new("Lcom/example/Color;".to_string(), 0x4001); // public enum
        class.superclass = Some("Ljava/lang/Enum;".to_string());

        // Add enum fields: RED, GREEN, BLUE
        class.static_fields.push(FieldData {
            name: "RED".to_string(),
            alias: None,
            field_type: ArgType::Object("Lcom/example/Color;".to_string()),
            access_flags: 0x4019, // public static final enum
            initial_value: None,
            annotations: Vec::new(),
            dex_field_idx: None,
        });
        class.static_fields.push(FieldData {
            name: "GREEN".to_string(),
            alias: None,
            field_type: ArgType::Object("Lcom/example/Color;".to_string()),
            access_flags: 0x4019,
            initial_value: None,
            annotations: Vec::new(),
            dex_field_idx: None,
        });
        class.static_fields.push(FieldData {
            name: "BLUE".to_string(),
            alias: None,
            field_type: ArgType::Object("Lcom/example/Color;".to_string()),
            access_flags: 0x4019,
            initial_value: None,
            annotations: Vec::new(),
            dex_field_idx: None,
        });

        // Add $VALUES field
        class.static_fields.push(FieldData {
            name: "$VALUES".to_string(),
            alias: None,
            field_type: ArgType::Array(Box::new(ArgType::Object("Lcom/example/Color;".to_string()))),
            access_flags: 0x101a, // private static final synthetic
            initial_value: None,
            annotations: Vec::new(),
            dex_field_idx: None,
        });

        class
    }

    #[test]
    fn test_is_enum() {
        let class = make_enum_class();
        assert!(class.is_enum());
    }

    #[test]
    fn test_find_values_field() {
        let class = make_enum_class();
        let idx = find_values_field(&class);
        assert_eq!(idx, Some(3)); // $VALUES is at index 3
    }

    #[test]
    fn test_is_values_field() {
        let class = make_enum_class();
        assert!(!is_values_field(&class, &class.static_fields[0])); // RED
        assert!(is_values_field(&class, &class.static_fields[3])); // $VALUES
    }

    #[test]
    fn test_non_enum_class() {
        let class = ClassData::new("Lcom/example/Regular;".to_string(), 0x0001);
        assert!(analyze_enum_class(&class).is_none());
    }

    #[test]
    fn test_type_matches_class() {
        let class_type = "Lcom/example/Color;";
        assert!(type_matches_class(&ArgType::Object(class_type.to_string()), class_type));
        assert!(!type_matches_class(&ArgType::Int, class_type));
    }

    #[test]
    fn test_type_is_array_of_class() {
        let class_type = "Lcom/example/Color;";
        let array_type = ArgType::Array(Box::new(ArgType::Object(class_type.to_string())));
        assert!(type_is_array_of_class(&array_type, class_type));
        assert!(!type_is_array_of_class(&ArgType::Object(class_type.to_string()), class_type));
    }
}
