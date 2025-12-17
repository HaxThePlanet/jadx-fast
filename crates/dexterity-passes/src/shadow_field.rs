//! ShadowFieldVisitor - Fix shadowed field access
//!
//! This pass runs after type inference and before code shrinking.
//! When a class defines a field with the same name as a parent class field,
//! accessing the parent's field requires either `super.field` or a cast.
//!
//! Equivalent to JADX's ShadowFieldVisitor.java

use std::collections::{HashMap, HashSet};

use dexterity_ir::{ArgType, ClassData, FieldData};
use dexterity_ir::instructions::InsnType;

/// How to fix a shadowed field access
#[derive(Debug, Clone, Copy, PartialEq, Eq)]
pub enum FieldFixType {
    /// Use `super.field` - only when exactly one parent has the field
    Super,
    /// Use `((ParentClass)this).field` - when multiple parents have same field
    Cast,
}

/// Information about fields that need fixing in a class
#[derive(Debug, Default)]
pub struct FieldFixInfo {
    /// Map from field name to fix type
    pub field_fixes: HashMap<String, FieldFixType>,
    /// For Cast fixes, map field name to the declaring class
    pub cast_targets: HashMap<String, String>,
}

/// Result of shadow field analysis
#[derive(Debug)]
pub struct ShadowFieldResult {
    /// Map from class name to field fix information
    pub class_fixes: HashMap<String, FieldFixInfo>,
}

/// Analyze a class hierarchy to find shadowed fields
///
/// A field is shadowed when:
/// 1. The current class has an instance field with some name
/// 2. A parent class also has an instance field with the same name
///
/// # Arguments
/// * `class` - The class to analyze
/// * `class_lookup` - Function to resolve a class by its type descriptor
///
/// # Returns
/// Field fix information for this class, or None if no fixes needed
pub fn search_shadowed_fields<F>(class: &ClassData, class_lookup: F) -> Option<FieldFixInfo>
where
    F: Fn(&str) -> Option<ClassData>,
{
    // Collect all instance fields from this class and all parents
    let all_fields = collect_all_instance_fields(class, &class_lookup);
    if all_fields.is_empty() {
        return None;
    }

    // Group fields by name
    let mut fields_by_name: HashMap<String, Vec<(String, FieldData)>> = HashMap::new();
    for (declaring_class, field) in all_fields {
        fields_by_name
            .entry(field.name.clone())
            .or_default()
            .push((declaring_class, field));
    }

    // Remove entries with only one field (no shadowing)
    fields_by_name.retain(|_, fields| fields.len() > 1);

    if fields_by_name.is_empty() {
        return None;
    }

    let mut fix_info = FieldFixInfo::default();
    let this_class = &class.class_type;

    for (field_name, fields) in fields_by_name {
        // Check if the first field is from this class
        let from_this_class = fields.first().map(|(c, _)| c == this_class).unwrap_or(false);

        if from_this_class && fields.len() == 2 {
            // Only one parent has the field - can use super
            if let Some((other_class, _)) = fields.get(1) {
                if other_class != this_class {
                    fix_info.field_fixes.insert(field_name.clone(), FieldFixType::Super);
                }
            }
        } else {
            // Multiple parents have the field - need cast
            for (declaring_class, _) in &fields {
                if declaring_class != this_class {
                    fix_info.field_fixes.insert(field_name.clone(), FieldFixType::Cast);
                    fix_info.cast_targets.insert(field_name.clone(), declaring_class.clone());
                    break; // Use first parent's class for cast
                }
            }
        }
    }

    if fix_info.field_fixes.is_empty() {
        None
    } else {
        Some(fix_info)
    }
}

/// Collect all instance fields from a class and its parents
fn collect_all_instance_fields<F>(
    class: &ClassData,
    class_lookup: &F,
) -> Vec<(String, FieldData)>
where
    F: Fn(&str) -> Option<ClassData>,
{
    let mut fields = Vec::new();
    let mut visited = HashSet::new();
    let mut current_class = Some(class.clone());

    while let Some(cls) = current_class {
        // Prevent infinite loops
        if !visited.insert(cls.class_type.clone()) {
            break;
        }

        // Add instance fields from this class
        for field in &cls.instance_fields {
            if !field.is_static() {
                fields.push((cls.class_type.clone(), field.clone()));
            }
        }

        // Move to superclass
        current_class = cls.superclass.as_ref().and_then(|sc| {
            if sc == "java/lang/Object" {
                None
            } else {
                class_lookup(sc)
            }
        });
    }

    fields
}

/// Determine if a field access needs fixing and how to fix it
///
/// # Arguments
/// * `field_name` - Name of the field being accessed
/// * `receiver_type` - Type of the receiver (the object whose field is accessed)
/// * `fix_info` - Field fix information for the receiver's class
///
/// # Returns
/// The fix type if needed, or None if no fix required
pub fn get_field_fix(
    field_name: &str,
    receiver_type: &ArgType,
    class_fixes: &HashMap<String, FieldFixInfo>,
) -> Option<(FieldFixType, Option<String>)> {
    // Get class name from receiver type
    let class_name = match receiver_type {
        ArgType::Object(name) => name,
        ArgType::Generic { base, .. } => base,
        _ => return None,
    };

    // Look up fix info for this class
    let fix_info = class_fixes.get(class_name)?;

    // Check if this field needs fixing
    let fix_type = fix_info.field_fixes.get(field_name)?;

    // Get cast target if needed
    let cast_target = if *fix_type == FieldFixType::Cast {
        fix_info.cast_targets.get(field_name).cloned()
    } else {
        None
    };

    Some((*fix_type, cast_target))
}

/// Check if an instruction is a field access that might need fixing
pub fn is_instance_field_access(insn_type: &InsnType) -> bool {
    matches!(insn_type, InsnType::InstanceGet { .. } | InsnType::InstancePut { .. })
}

/// Apply shadow field fixes to a class's method instructions
///
/// This modifies the IR to mark field accesses that need super or cast treatment.
/// The actual code generation happens later based on these marks.
///
/// # Arguments
/// * `class` - The class whose methods to process
/// * `class_fixes` - Pre-computed field fix information for all classes
///
/// # Returns
/// Map from (method_idx, insn_idx) -> (fix_type, cast_target) for instructions needing fixes
pub fn apply_shadow_field_fixes(
    class: &ClassData,
    class_fixes: &HashMap<String, FieldFixInfo>,
) -> HashMap<(usize, usize), (FieldFixType, Option<String>)> {
    let mut result = HashMap::new();

    for (method_idx, method) in class.methods.iter().enumerate() {
        // Skip abstract/native methods
        if method.instructions.is_none() && method.insn_indices.is_empty() {
            continue;
        }

        // Get instructions
        let insns: Vec<_> = if let Some(ref insns) = method.instructions {
            insns.iter().collect()
        } else if !method.insn_indices.is_empty() {
            method.insn_indices.iter()
                .filter_map(|&idx| class.all_instructions.get(idx as usize))
                .collect()
        } else {
            continue;
        };

        for (insn_idx, insn) in insns.iter().enumerate() {
            // Check for instance field access
            match &insn.insn_type {
                InsnType::InstanceGet { field_ref, .. } | InsnType::InstancePut { field_ref, .. } => {
                    // Get field name and receiver type
                    let field_name = &field_ref.name;

                    // For instance field access, receiver is usually `this` (class type)
                    // In more complex cases, we'd need type information from the register
                    let receiver_type = ArgType::Object(class.class_type.clone());

                    if let Some(fix) = get_field_fix(field_name, &receiver_type, class_fixes) {
                        result.insert((method_idx, insn_idx), fix);
                    }
                }
                _ => {}
            }
        }
    }

    result
}

#[cfg(test)]
mod tests {
    use super::*;

    fn make_field(name: &str) -> FieldData {
        FieldData {
            name: name.to_string(),
            field_type: ArgType::Int,
            access_flags: 0, // instance field
            ..Default::default()
        }
    }

    #[test]
    fn test_field_fix_type() {
        let mut fix_info = FieldFixInfo::default();
        fix_info.field_fixes.insert("value".to_string(), FieldFixType::Super);
        fix_info.field_fixes.insert("name".to_string(), FieldFixType::Cast);
        fix_info.cast_targets.insert("name".to_string(), "com/parent/Parent".to_string());

        let mut class_fixes = HashMap::new();
        class_fixes.insert("com/example/Child".to_string(), fix_info);

        // Test super fix
        let receiver = ArgType::Object("com/example/Child".to_string());
        let fix = get_field_fix("value", &receiver, &class_fixes);
        assert!(fix.is_some());
        let (fix_type, cast_target) = fix.unwrap();
        assert_eq!(fix_type, FieldFixType::Super);
        assert!(cast_target.is_none());

        // Test cast fix
        let fix = get_field_fix("name", &receiver, &class_fixes);
        assert!(fix.is_some());
        let (fix_type, cast_target) = fix.unwrap();
        assert_eq!(fix_type, FieldFixType::Cast);
        assert_eq!(cast_target, Some("com/parent/Parent".to_string()));

        // Test no fix needed
        let fix = get_field_fix("other", &receiver, &class_fixes);
        assert!(fix.is_none());
    }

    #[test]
    fn test_is_instance_field_access() {
        use dexterity_ir::FieldRef;

        let field_ref = FieldRef {
            class: "Lcom/example/Test;".to_string(),
            name: "field".to_string(),
            field_type: ArgType::Int,
        };

        assert!(is_instance_field_access(&InsnType::InstanceGet { field_ref: field_ref.clone() }));
        assert!(is_instance_field_access(&InsnType::InstancePut { field_ref: field_ref.clone() }));
        assert!(!is_instance_field_access(&InsnType::StaticGet { field_ref: field_ref.clone() }));
        assert!(!is_instance_field_access(&InsnType::StaticPut { field_ref }));
    }
}
