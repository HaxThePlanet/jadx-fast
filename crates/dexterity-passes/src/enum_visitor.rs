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
    /// String literal
    String(String),
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

/// Analyze a class for enum patterns (without string lookup - uses field names as fallback)
pub fn analyze_enum_class(class: &ClassData) -> Option<EnumClassInfo> {
    analyze_enum_class_with_strings(class, None::<fn(u32) -> Option<String>>)
}

/// Analyze a class for enum patterns with optional string lookup
///
/// The `string_lookup` function resolves string_idx values to actual strings from the DEX pool.
/// This enables extraction of enum constructor arguments.
pub fn analyze_enum_class_with_strings<F>(class: &ClassData, string_lookup: Option<F>) -> Option<EnumClassInfo>
where
    F: Fn(u32) -> Option<String>,
{
    // Must be an enum class
    if !class.is_enum() {
        return None;
    }

    // Must extend java.lang.Enum (handle both formats)
    let super_class = class.superclass.as_deref();
    if super_class != Some("Ljava/lang/Enum;") && super_class != Some("java/lang/Enum") {
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
    let fields = extract_enum_fields_with_strings(class, clinit, &string_lookup)?;
    info.fields = fields;

    Some(info)
}

/// Check if a type matches the class type
/// Handles both normalized (without L/;) and non-normalized class names
fn type_matches_class(field_type: &ArgType, class_type: &str) -> bool {
    // Normalize class_type by stripping L prefix and ; suffix if present
    let class_type_normalized = class_type
        .strip_prefix('L')
        .unwrap_or(class_type)
        .strip_suffix(';')
        .unwrap_or(class_type);

    match field_type {
        ArgType::Object(s) => s == class_type_normalized || s == class_type,
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

/// Extract enum fields from the static initializer (without string lookup)
#[allow(dead_code)]
fn extract_enum_fields(class: &ClassData, clinit: &MethodData) -> Option<Vec<EnumFieldInfo>> {
    extract_enum_fields_with_strings(class, clinit, &None::<fn(u32) -> Option<String>>)
}

/// Extract enum fields from the static initializer with optional string lookup
fn extract_enum_fields_with_strings<F>(
    class: &ClassData,
    clinit: &MethodData,
    string_lookup: &Option<F>,
) -> Option<Vec<EnumFieldInfo>>
where
    F: Fn(u32) -> Option<String>,
{
    let insns = clinit.get_instructions();
    if insns.is_empty() {
        return None;
    }

    let mut fields: Vec<EnumFieldInfo> = Vec::new();
    // FIXED: Use Vec to store all constructs, indexed by register at each instruction
    let mut pending_constructs: Vec<(u16, usize, PendingConstruct)> = Vec::new(); // (reg_num, insn_idx, construct)

    // Pass 1: Find constructor calls and store in vec with instruction index
    for (insn_idx, insn) in insns.iter().enumerate() {
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
                    // FIXED: Pass instruction index to find nearest preceding constant
                    let name = extract_string_arg_before_idx(&args[1], insns, insn_idx, string_lookup);
                    let ordinal = extract_int_arg_before_idx(&args[2], insns, insn_idx);

                    if let (Some(name), Some(ordinal)) = (name, ordinal) {
                        // Extract extra constructor arguments (skip name, ordinal, get rest)
                        let extra_args: Vec<EnumArg> = args.iter().skip(3)
                            .map(|a| convert_to_enum_arg_with_lookup(a, insns, string_lookup))
                            .collect();

                        // Store with instruction index to track which constructor call this is
                        pending_constructs.push((reg.reg_num, insn_idx, PendingConstruct {
                            name,
                            ordinal: ordinal as i32,
                            extra_args,
                        }));
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
        for (sput_idx, insn) in insns.iter().enumerate() {
            if let InsnType::StaticPut { field_idx: sput_field_idx, value } = &insn.insn_type {
                // Check if this SPUT is storing to the current field we're examining
                // Match by DEX field index if available, otherwise skip
                let matches_field = if let Some(dex_idx) = field.dex_field_idx {
                    dex_idx == *sput_field_idx
                } else {
                    // Fallback: can't match without DEX field index
                    false
                };

                if matches_field {
                    if let InsnArg::Register(reg) = value {
                        // FIXED: Find the most recent constructor call that created this register value
                        // Search backwards from the SPUT to find the constructor call
                        let construct_opt = pending_constructs.iter()
                            .rev() // Start from the end (most recent)
                            .find(|(c_reg, c_idx, _)| *c_reg == reg.reg_num && *c_idx < sput_idx)
                            .map(|(_, _, construct)| construct);

                        if let Some(construct) = construct_opt {
                            fields.push(EnumFieldInfo {
                                name: construct.name.clone(),
                                ordinal: construct.ordinal,
                                field_idx,
                                extra_args: construct.extra_args.clone(),
                            });
                            // Found the SPUT for this field, no need to continue searching
                            break;
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
            if let Some((_, _, construct)) = pending_constructs.iter()
                .find(|(_, _, c)| c.name == field.name)
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

/// Extract a string argument from an instruction argument (without string lookup)
#[allow(dead_code)]
fn extract_string_arg(arg: &InsnArg, insns: &[InsnNode]) -> Option<String> {
    extract_string_arg_with_lookup(arg, insns, &None::<fn(u32) -> Option<String>>)
}

/// Extract a string argument from an instruction argument with optional string lookup
fn extract_string_arg_with_lookup<F>(
    arg: &InsnArg,
    insns: &[InsnNode],
    string_lookup: &Option<F>,
) -> Option<String>
where
    F: Fn(u32) -> Option<String>,
{
    match arg {
        InsnArg::Register(reg) => {
            // Look for CONST_STRING that defines this register
            for insn in insns {
                if let InsnType::ConstString { dest, string_idx } = &insn.insn_type {
                    if dest.reg_num == reg.reg_num {
                        // Try to resolve the string via lookup function
                        if let Some(lookup) = string_lookup {
                            if let Some(s) = lookup(*string_idx) {
                                return Some(s);
                            }
                        }
                        // Fallback: use placeholder
                        return Some(format!("string_{}", reg.reg_num));
                    }
                }
            }
            None
        }
        _ => None,
    }
}

/// Extract a string argument by searching BACKWARDS from before_idx to find nearest preceding CONST_STRING
/// This fixes the enum name corruption bug where register reuse caused wrong strings to be matched
fn extract_string_arg_before_idx<F>(
    arg: &InsnArg,
    insns: &[InsnNode],
    before_idx: usize,
    string_lookup: &Option<F>,
) -> Option<String>
where
    F: Fn(u32) -> Option<String>,
{
    match arg {
        InsnArg::Register(reg) => {
            // Search BACKWARDS from before_idx to find the nearest preceding CONST_STRING
            for i in (0..before_idx).rev() {
                if let InsnType::ConstString { dest, string_idx } = &insns[i].insn_type {
                    if dest.reg_num == reg.reg_num {
                        // Try to resolve the string via lookup function
                        if let Some(lookup) = string_lookup {
                            if let Some(s) = lookup(*string_idx) {
                                return Some(s);
                            }
                        }
                        // Fallback: use placeholder
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

/// Extract an integer argument by searching BACKWARDS from before_idx to find nearest preceding CONST
/// This fixes the enum ordinal bug where register reuse caused wrong ordinals to be matched
fn extract_int_arg_before_idx(arg: &InsnArg, insns: &[InsnNode], before_idx: usize) -> Option<i64> {
    match arg {
        InsnArg::Literal(LiteralArg::Int(n)) => Some(*n),
        InsnArg::Register(reg) => {
            // Search BACKWARDS from before_idx to find the nearest preceding CONST
            for i in (0..before_idx).rev() {
                if let InsnType::Const { dest, value: LiteralArg::Int(n) } = &insns[i].insn_type {
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

/// Convert an instruction argument to an EnumArg (without string lookup)
#[allow(dead_code)]
fn convert_to_enum_arg(arg: &InsnArg, insns: &[InsnNode]) -> EnumArg {
    convert_to_enum_arg_with_lookup(arg, insns, &None::<fn(u32) -> Option<String>>)
}

/// Convert an instruction argument to an EnumArg with optional string lookup
fn convert_to_enum_arg_with_lookup<F>(
    arg: &InsnArg,
    insns: &[InsnNode],
    string_lookup: &Option<F>,
) -> EnumArg
where
    F: Fn(u32) -> Option<String>,
{
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
                    InsnType::ConstString { dest, string_idx } if dest.reg_num == reg.reg_num => {
                        // Try to resolve string via lookup
                        if let Some(lookup) = string_lookup {
                            if let Some(s) = lookup(*string_idx) {
                                return EnumArg::String(s);
                            }
                        }
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
