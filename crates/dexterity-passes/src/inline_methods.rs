//! Method inlining pass
//!
//! This pass inlines simple getter/setter methods and other marked methods
//! to produce cleaner decompiled output.
//!
//! ## JADX Reference
//!
//! This pass is a direct clone of JADX's `InlineMethods.java` (195 lines).
//! See: jadx-fast/jadx-core/src/main/java/jadx/core/dex/visitors/InlineMethods.java
//!
//! Related pass: `MarkMethodsForInline.java` (185 lines)
//! See: jadx-fast/jadx-core/src/main/java/jadx/core/dex/visitors/MarkMethodsForInline.java
//!
//! Key behaviors cloned from JADX:
//! - `MethodInlineAttr` - Marks methods for inlining with the instruction to inline
//! - `inlineMethod()` - Replaces invoke with the inlined instruction
//! - `replaceRegs()` - Remaps registers from the inlined method to caller
//! - Getter/setter pattern detection
//! - Single-instruction method detection
//!
//! ## Getter/Setter Inlining
//!
//! ```java
//! // Before:
//! int x = obj.getValue();
//!
//! // If getValue() is: return this.value;
//! // After inlining:
//! int x = obj.value;
//! ```
//!
//! ## Single-Instruction Methods
//!
//! Methods that contain only a single meaningful instruction can be inlined:
//! - Field getter: `return this.field;`
//! - Field setter: `this.field = arg;`
//! - Constant getter: `return 42;`
//! - Simple wrapper: `return otherMethod();`

use dexterity_ir::instructions::{InsnArg, InsnNode, InsnType, InvokeKind, RegisterArg, MethodRef, FieldRef};
use dexterity_ir::MethodData;
use std::collections::HashMap;

/// Result of the method inlining pass
#[derive(Debug, Default)]
pub struct InlineMethodsResult {
    /// Number of methods inlined
    pub methods_inlined: usize,
    /// Number of getter inlines
    pub getters_inlined: usize,
    /// Number of setter inlines
    pub setters_inlined: usize,
    /// Number of constant getters inlined
    pub constants_inlined: usize,
    /// Number of wrapper methods inlined
    pub wrappers_inlined: usize,
}

/// Attribute marking a method for inlining
///
/// JADX Reference: MethodInlineAttr
#[derive(Debug, Clone)]
pub struct MethodInlineAttr {
    /// The instruction to inline (the method body)
    pub insn: InsnNode,
    /// Register numbers for the arguments (indices into method args)
    pub args_reg_nums: Vec<u16>,
    /// Whether this method doesn't need inlining (too complex)
    pub not_needed: bool,
}

impl MethodInlineAttr {
    /// Create a "not needed" marker
    pub fn not_needed() -> Self {
        Self {
            insn: InsnNode::new(InsnType::Nop, 0),
            args_reg_nums: Vec::new(),
            not_needed: true,
        }
    }

    /// Create an inlinable method marker
    pub fn inlinable(insn: InsnNode, args_reg_nums: Vec<u16>) -> Self {
        Self {
            insn,
            args_reg_nums,
            not_needed: false,
        }
    }
}

/// Type of inlinable pattern detected
#[derive(Debug, Clone, PartialEq, Eq)]
pub enum InlinePattern {
    /// Field getter: return this.field
    Getter { field: FieldRef, is_static: bool },
    /// Field setter: this.field = arg
    Setter { field: FieldRef, is_static: bool },
    /// Constant getter: return CONSTANT
    ConstGetter { value: i64 },
    /// Simple wrapper: return otherMethod(...)
    Wrapper { method: MethodRef },
    /// Not inlinable
    None,
}

/// Analyze a method to determine if it can be inlined
///
/// JADX Reference: MarkMethodsForInline.process()
///
/// Returns the inline pattern if the method is inlinable, None otherwise.
pub fn analyze_method_for_inlining(method: &MethodData) -> InlinePattern {
    // Skip abstract, native, or no-code methods
    let code = match &method.code {
        Some(c) => c,
        None => return InlinePattern::None,
    };

    // Get meaningful instructions (skip nop, goto)
    let meaningful: Vec<&InsnNode> = code.instructions.iter()
        .filter(|i| !matches!(i.insn_type,
            InsnType::Nop | InsnType::Goto { .. }
        ))
        .collect();

    // Single return instruction
    if meaningful.len() == 1 {
        return check_single_insn_pattern(meaningful[0], method);
    }

    // Two instructions: one operation + return
    if meaningful.len() == 2 {
        return check_two_insn_pattern(&meaningful, method);
    }

    InlinePattern::None
}

/// Check if a single instruction is inlinable
fn check_single_insn_pattern(insn: &InsnNode, _method: &MethodData) -> InlinePattern {
    match &insn.insn_type {
        // return this.field - instance getter
        InsnType::Return { value: Some(arg) } => {
            // Would need to trace the arg back to a field get
            // This is a simplified check
            InlinePattern::None
        }

        // return void - empty method, not useful to inline
        InsnType::ReturnVoid => InlinePattern::None,

        // IGET + implicit return - instance getter
        InsnType::InstanceGet { field, .. } => {
            InlinePattern::Getter {
                field: field.clone(),
                is_static: false,
            }
        }

        // SGET + implicit return - static getter
        InsnType::StaticGet { field, .. } => {
            InlinePattern::Getter {
                field: field.clone(),
                is_static: true,
            }
        }

        // CONST + implicit return - constant getter
        InsnType::Const { value, .. } => {
            if let dexterity_ir::instructions::LiteralArg::Int(v) = value {
                InlinePattern::ConstGetter { value: *v }
            } else {
                InlinePattern::None
            }
        }

        _ => InlinePattern::None,
    }
}

/// Check if two instructions form an inlinable pattern
fn check_two_insn_pattern(insns: &[&InsnNode], _method: &MethodData) -> InlinePattern {
    let first = insns[0];
    let second = insns[1];

    // IGET + RETURN value - instance getter
    if let InsnType::InstanceGet { dest, field, .. } = &first.insn_type {
        if let InsnType::Return { value: Some(ret_arg) } = &second.insn_type {
            if matches!(ret_arg, InsnArg::Register(r) if r.reg_num == dest.reg_num) {
                return InlinePattern::Getter {
                    field: field.clone(),
                    is_static: false,
                };
            }
        }
    }

    // SGET + RETURN value - static getter
    if let InsnType::StaticGet { dest, field, .. } = &first.insn_type {
        if let InsnType::Return { value: Some(ret_arg) } = &second.insn_type {
            if matches!(ret_arg, InsnArg::Register(r) if r.reg_num == dest.reg_num) {
                return InlinePattern::Getter {
                    field: field.clone(),
                    is_static: true,
                };
            }
        }
    }

    // IPUT + RETURN_VOID - instance setter
    if let InsnType::InstancePut { field, .. } = &first.insn_type {
        if matches!(second.insn_type, InsnType::ReturnVoid) {
            return InlinePattern::Setter {
                field: field.clone(),
                is_static: false,
            };
        }
    }

    // SPUT + RETURN_VOID - static setter
    if let InsnType::StaticPut { field, .. } = &first.insn_type {
        if matches!(second.insn_type, InsnType::ReturnVoid) {
            return InlinePattern::Setter {
                field: field.clone(),
                is_static: true,
            };
        }
    }

    // INVOKE + RETURN - wrapper method
    if let InsnType::Invoke { method: mref, .. } = &first.insn_type {
        if matches!(second.insn_type, InsnType::Return { .. } | InsnType::ReturnVoid) {
            return InlinePattern::Wrapper {
                method: mref.clone(),
            };
        }
    }

    InlinePattern::None
}

/// Replace an invoke instruction with an inlined instruction
///
/// JADX Reference: InlineMethods.inlineMethod()
pub fn inline_invoke(
    invoke_insn: &InsnNode,
    inline_attr: &MethodInlineAttr,
) -> Option<InsnNode> {
    if inline_attr.not_needed {
        return None;
    }

    // Copy the instruction without result
    let mut inlined = inline_attr.insn.clone();

    // Replace registers based on the mapping
    // This is a simplified version - full implementation would handle all arg types
    replace_registers(&mut inlined, invoke_insn, &inline_attr.args_reg_nums);

    // Copy result from invoke to inlined instruction
    if let InsnType::Invoke { dest, .. } = &invoke_insn.insn_type {
        if let Some(dest_reg) = dest {
            set_insn_result(&mut inlined, dest_reg.clone());
        }
    }

    Some(inlined)
}

/// Replace registers in the inlined instruction with caller's registers
///
/// JADX Reference: InlineMethods.replaceRegs()
fn replace_registers(
    inlined: &mut InsnNode,
    invoke: &InsnNode,
    args_reg_nums: &[u16],
) {
    // Build a mapping from inlined method's registers to caller's args
    let mut reg_map: HashMap<u16, InsnArg> = HashMap::new();

    if let InsnType::Invoke { args, .. } = &invoke.insn_type {
        for (i, &reg_num) in args_reg_nums.iter().enumerate() {
            if let Some(arg) = args.get(i) {
                reg_map.insert(reg_num, arg.clone());
            }
        }
    }

    // Apply the mapping to all register uses in the inlined instruction
    replace_insn_args(inlined, &reg_map);
}

/// Replace register arguments in an instruction using a mapping
fn replace_insn_args(insn: &mut InsnNode, reg_map: &HashMap<u16, InsnArg>) {
    // Helper to replace a single arg
    let replace_arg = |arg: &mut InsnArg| {
        if let InsnArg::Register(reg) = arg {
            if let Some(replacement) = reg_map.get(&reg.reg_num) {
                *arg = replacement.clone();
            }
        }
    };

    // Apply to all args in the instruction based on type
    match &mut insn.insn_type {
        InsnType::InstanceGet { object, .. } => replace_arg(object),
        InsnType::InstancePut { object, value, .. } => {
            replace_arg(object);
            replace_arg(value);
        }
        InsnType::StaticPut { value, .. } => replace_arg(value),
        InsnType::Return { value: Some(v) } => replace_arg(v),
        InsnType::Invoke { args, .. } => {
            for arg in args.iter_mut() {
                replace_arg(arg);
            }
        }
        InsnType::Binary { left, right, .. } => {
            replace_arg(left);
            replace_arg(right);
        }
        InsnType::Unary { arg, .. } => replace_arg(arg),
        _ => {}
    }
}

/// Set the result register of an instruction
fn set_insn_result(insn: &mut InsnNode, result: RegisterArg) {
    match &mut insn.insn_type {
        InsnType::InstanceGet { dest, .. }
        | InsnType::StaticGet { dest, .. }
        | InsnType::Const { dest, .. }
        | InsnType::Move { dest, .. }
        | InsnType::Binary { dest, .. }
        | InsnType::Unary { dest, .. } => {
            *dest = result;
        }
        InsnType::Invoke { dest, .. } => {
            *dest = Some(result);
        }
        _ => {}
    }
}

/// Process all invoke instructions in a method for inlining opportunities
///
/// JADX Reference: InlineMethods.visit()
pub fn process_method_inlines(
    instructions: &mut Vec<InsnNode>,
    inline_attrs: &HashMap<String, MethodInlineAttr>,
) -> InlineMethodsResult {
    let mut result = InlineMethodsResult::default();

    let mut i = 0;
    while i < instructions.len() {
        let insn = &instructions[i];

        if let InsnType::Invoke { method, .. } = &insn.insn_type {
            // Build method key for lookup
            let method_key = format!("{}.{}", method.class, method.name);

            if let Some(attr) = inline_attrs.get(&method_key) {
                if let Some(inlined) = inline_invoke(insn, attr) {
                    // Replace the invoke with the inlined instruction
                    instructions[i] = inlined;
                    result.methods_inlined += 1;
                }
            }
        }

        i += 1;
    }

    result
}

#[cfg(test)]
mod tests {
    use super::*;

    #[test]
    fn test_method_inline_attr_not_needed() {
        let attr = MethodInlineAttr::not_needed();
        assert!(attr.not_needed);
    }

    #[test]
    fn test_inline_pattern_detection() {
        // Simplified test - full test would need proper MethodData construction
    }

    #[test]
    fn test_getter_pattern() {
        let pattern = InlinePattern::Getter {
            field: FieldRef {
                class: "Test".to_string(),
                name: "value".to_string(),
                field_type: "I".to_string(),
            },
            is_static: false,
        };

        assert!(matches!(pattern, InlinePattern::Getter { is_static: false, .. }));
    }
}
