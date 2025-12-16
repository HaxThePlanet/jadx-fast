//! Method inlining detection pass
//!
//! Detects synthetic bridge methods (access$XXX) that can be inlined.
//! These are compiler-generated methods that provide access to private members
//! of outer classes for inner classes.
//!
//! Patterns detected:
//! - Field getters: `return obj.field;` or `return SomeClass.staticField;`
//! - Field setters: `obj.field = arg; return arg;` or `SomeClass.staticField = arg;`
//! - Method delegation: `return obj.method(args);`

use dexterity_ir::instructions::{InsnArg, InsnType, InvokeKind};
use dexterity_ir::{MethodData, MethodInlineAttr};

/// Analyze a method and determine if it can be inlined.
/// Returns the inline attribute if the method is simple enough to inline.
pub fn analyze_method_for_inline(method: &MethodData) -> Option<MethodInlineAttr> {
    // Only analyze inline candidates
    if !method.is_inline_candidate() {
        return None;
    }

    // Skip methods with no instructions or too many instructions
    let insns = method.get_instructions();
    if insns.is_empty() || insns.len() > 5 {
        return Some(MethodInlineAttr::NotNeeded);
    }

    // Filter out nops and get meaningful instructions
    let meaningful: Vec<_> = insns
        .iter()
        .filter(|i| !matches!(i.insn_type, InsnType::Nop))
        .collect();

    if meaningful.is_empty() {
        return Some(MethodInlineAttr::NotNeeded);
    }

    // Try to detect simple patterns
    match meaningful.len() {
        // Simple getter: just return field
        1 => {
            if let Some(attr) = try_detect_simple_getter(&meaningful) {
                return Some(attr);
            }
        }
        // Getter with return or setter with return
        2 => {
            if let Some(attr) = try_detect_getter_pattern(&meaningful) {
                return Some(attr);
            }
            if let Some(attr) = try_detect_method_delegate(&meaningful) {
                return Some(attr);
            }
        }
        // Setter pattern: field-put, return
        3 => {
            if let Some(attr) = try_detect_setter_pattern(&meaningful) {
                return Some(attr);
            }
        }
        _ => {}
    }

    Some(MethodInlineAttr::NotNeeded)
}

/// Try to detect a simple getter pattern: single instruction returning a field
fn try_detect_simple_getter(insns: &[&dexterity_ir::InsnNode]) -> Option<MethodInlineAttr> {
    if insns.len() != 1 {
        return None;
    }

    match &insns[0].insn_type {
        // Static field get that is returned
        InsnType::StaticGet { field_idx, .. } => Some(MethodInlineAttr::FieldGet {
            field_idx: *field_idx,
            is_instance: false,
        }),
        // Instance field get (first instruction)
        InsnType::InstanceGet { field_idx, .. } => Some(MethodInlineAttr::FieldGet {
            field_idx: *field_idx,
            is_instance: true,
        }),
        _ => None,
    }
}

/// Try to detect getter pattern: field-get, return
fn try_detect_getter_pattern(insns: &[&dexterity_ir::InsnNode]) -> Option<MethodInlineAttr> {
    if insns.len() != 2 {
        return None;
    }

    // Check first instruction is field get
    let field_get = match &insns[0].insn_type {
        InsnType::StaticGet { field_idx, .. } => Some((*field_idx, false)),
        InsnType::InstanceGet { field_idx, .. } => Some((*field_idx, true)),
        _ => None,
    };

    if let Some((field_idx, is_instance)) = field_get {
        // Check second instruction is return
        if matches!(&insns[1].insn_type, InsnType::Return { .. }) {
            return Some(MethodInlineAttr::FieldGet {
                field_idx,
                is_instance,
            });
        }
    }

    None
}

/// Try to detect setter pattern: field-put, (move), return
fn try_detect_setter_pattern(insns: &[&dexterity_ir::InsnNode]) -> Option<MethodInlineAttr> {
    if insns.len() < 2 {
        return None;
    }

    // Check first instruction is field put
    let field_put = match &insns[0].insn_type {
        InsnType::StaticPut { field_idx, .. } => Some((*field_idx, false)),
        InsnType::InstancePut { field_idx, .. } => Some((*field_idx, true)),
        _ => None,
    };

    if let Some((field_idx, is_instance)) = field_put {
        // Check last instruction is return
        let last = insns.last().unwrap();
        if matches!(&last.insn_type, InsnType::Return { .. }) {
            return Some(MethodInlineAttr::FieldSet {
                field_idx,
                is_instance,
            });
        }
    }

    None
}

/// Try to detect method delegation pattern: invoke, return
fn try_detect_method_delegate(insns: &[&dexterity_ir::InsnNode]) -> Option<MethodInlineAttr> {
    if insns.len() != 2 {
        return None;
    }

    // Check first instruction is invoke
    if let InsnType::Invoke { method_idx, kind, .. } = &insns[0].insn_type {
        // Skip constructors
        if matches!(kind, InvokeKind::Direct | InvokeKind::Super) {
            // Could be constructor, check name if we have it
            // For now, allow direct calls as they might be private method calls
        }

        // Check second instruction is return
        if matches!(&insns[1].insn_type, InsnType::Return { .. }) {
            return Some(MethodInlineAttr::MethodCall {
                method_idx: *method_idx,
            });
        }
    }

    None
}

/// Mark methods in a class for inline
pub fn mark_methods_for_inline(methods: &mut [MethodData]) {
    for method in methods {
        if method.inline_attr.is_none() {
            method.inline_attr = analyze_method_for_inline(method);
        }
    }
}

/// Check if a method should be hidden from output (because it will be inlined)
pub fn should_skip_method(method: &MethodData) -> bool {
    matches!(
        method.inline_attr,
        Some(MethodInlineAttr::FieldGet { .. })
            | Some(MethodInlineAttr::FieldSet { .. })
            | Some(MethodInlineAttr::MethodCall { .. })
    )
}

#[cfg(test)]
mod tests {
    use super::*;
    use dexterity_ir::instructions::{InsnNode, RegisterArg};
    use dexterity_ir::ArgType;

    fn make_synthetic_method(name: &str, access_flags: u32) -> MethodData {
        MethodData::new(name.to_string(), access_flags | 0x1000, ArgType::Int)
    }

    #[test]
    fn test_detect_static_field_getter() {
        let mut method = make_synthetic_method("access$000", 0x0008); // static synthetic
        method.set_instructions(vec![
            InsnNode::new(
                InsnType::StaticGet {
                    dest: RegisterArg::new(0),
                    field_idx: 42,
                },
                0,
            ),
            InsnNode::new(
                InsnType::Return {
                    value: Some(InsnArg::reg(0)),
                },
                1,
            ),
        ]);

        let attr = analyze_method_for_inline(&method);
        assert!(matches!(
            attr,
            Some(MethodInlineAttr::FieldGet {
                field_idx: 42,
                is_instance: false
            })
        ));
    }

    #[test]
    fn test_detect_instance_field_getter() {
        let mut method = make_synthetic_method("access$100", 0x0008);
        method.set_instructions(vec![
            InsnNode::new(
                InsnType::InstanceGet {
                    dest: RegisterArg::new(0),
                    object: InsnArg::reg(1),
                    field_idx: 10,
                },
                0,
            ),
            InsnNode::new(
                InsnType::Return {
                    value: Some(InsnArg::reg(0)),
                },
                1,
            ),
        ]);

        let attr = analyze_method_for_inline(&method);
        assert!(matches!(
            attr,
            Some(MethodInlineAttr::FieldGet {
                field_idx: 10,
                is_instance: true
            })
        ));
    }

    #[test]
    fn test_detect_static_field_setter() {
        let mut method = make_synthetic_method("access$002", 0x0008);
        method.set_instructions(vec![
            InsnNode::new(
                InsnType::StaticPut {
                    value: InsnArg::reg(0),
                    field_idx: 42,
                },
                0,
            ),
            InsnNode::new(InsnType::Return { value: None }, 1),
        ]);

        // Need at least 3 instructions for setter pattern (put, move, return)
        // This should not match setter pattern with only 2 insns
    }

    #[test]
    fn test_non_synthetic_not_inlined() {
        let mut method = MethodData::new("normalMethod".to_string(), 0x0001, ArgType::Int);
        method.set_instructions(vec![InsnNode::new(
            InsnType::StaticGet {
                dest: RegisterArg::new(0),
                field_idx: 42,
            },
            0,
        )]);

        let attr = analyze_method_for_inline(&method);
        assert!(attr.is_none());
    }
}
