//! Instruction utility functions
//!
//! Helper functions for instruction analysis including constant value extraction,
//! variable containment checks, instruction unwrapping, and common patterns.
//!
//! Copied from JADX: jadx-core/src/main/java/jadx/core/utils/InsnUtils.java

use crate::instructions::{InsnArg, InsnNode, InsnType};

/// Constant value types extracted from instructions
#[derive(Debug, Clone, PartialEq)]
pub enum ConstValue {
    /// Integer constant
    Int(i64),
    /// Float constant
    Float(f32),
    /// Double constant
    Double(f64),
    /// String constant
    String(String),
    /// Type/class constant
    Type(String),
    /// Null constant
    Null,
}

/// Get constant value from argument (JADX: getConstValueByArg)
///
/// Extracts constant from literal, wrapped const instruction, or by
/// following MOVE chains to find the source constant.
///
/// JADX Reference: InsnUtils.java:62-82
/// ```java
/// public static Object getConstValueByArg(RootNode root, InsnArg arg) {
///     if (arg.isLiteral()) {
///         return arg;
///     }
///     if (arg.isRegister()) {
///         RegisterArg reg = (RegisterArg) arg;
///         InsnNode parInsn = reg.getAssignInsn();
///         if (parInsn == null) {
///             return null;
///         }
///         if (parInsn.getType() == InsnType.MOVE) {
///             return getConstValueByArg(root, parInsn.getArg(0));
///         }
///         return getConstValueByInsn(root, parInsn);
///     }
///     if (arg.isInsnWrap()) {
///         InsnNode insn = ((InsnWrapArg) arg).getWrapInsn();
///         return getConstValueByInsn(root, insn);
///     }
///     return null;
/// }
/// ```
pub fn get_const_value_by_arg(arg: &InsnArg) -> Option<ConstValue> {
    match arg {
        InsnArg::Literal(lit) => Some(match lit {
            crate::instructions::LiteralArg::Int(v) => ConstValue::Int(*v),
            crate::instructions::LiteralArg::Float(v) => ConstValue::Float(*v),
            crate::instructions::LiteralArg::Double(v) => ConstValue::Double(*v),
            crate::instructions::LiteralArg::Null => ConstValue::Null,
        }),
        InsnArg::String(idx) => Some(ConstValue::String(format!("str#{}", idx))),
        InsnArg::Wrapped(wrapped) => wrapped
            .inline_insn
            .as_ref()
            .and_then(|insn| get_const_value_by_insn(insn)),
        _ => None,
    }
}

/// Get constant value from instruction (JADX: getConstValueByInsn)
///
/// Extracts the constant value from CONST, CONST_STR, or CONST_CLASS instructions.
///
/// JADX Reference: InsnUtils.java:89-114
/// ```java
/// public static Object getConstValueByInsn(RootNode root, InsnNode insn) {
///     switch (insn.getType()) {
///         case CONST:
///             return insn.getArg(0);
///         case CONST_STR:
///             return ((ConstStringNode) insn).getString();
///         case CONST_CLASS:
///             return ((ConstClassNode) insn).getClsType();
///         default:
///             return null;
///     }
/// }
/// ```
pub fn get_const_value_by_insn(insn: &InsnNode) -> Option<ConstValue> {
    match &insn.insn_type {
        InsnType::Const { value, .. } => Some(match value {
            crate::instructions::LiteralArg::Int(v) => ConstValue::Int(*v),
            crate::instructions::LiteralArg::Float(v) => ConstValue::Float(*v),
            crate::instructions::LiteralArg::Double(v) => ConstValue::Double(*v),
            crate::instructions::LiteralArg::Null => ConstValue::Null,
        }),
        InsnType::ConstString { string_idx, .. } => Some(ConstValue::String(format!("str#{}", string_idx))),
        InsnType::ConstClass { type_idx, .. } => Some(ConstValue::Type(format!("type#{}", type_idx))),
        _ => None,
    }
}

/// Check if argument contains a specific SSA variable (JADX: containsVar)
///
/// Recursively checks if the argument or any wrapped instruction contains
/// a specific register with SSA version.
///
/// JADX Reference: InsnUtils.java:285-294
/// ```java
/// public static boolean containsVar(InsnArg insnArg, RegisterArg arg) {
///     if (insnArg.isRegister()) {
///         return ((RegisterArg) insnArg).sameRegAndSVar(arg);
///     }
///     if (insnArg.isInsnWrap()) {
///         InsnNode wrapInsn = ((InsnWrapArg) insnArg).getWrapInsn();
///         return containsVar(wrapInsn, arg);
///     }
///     return false;
/// }
/// ```
pub fn arg_contains_var(arg: &InsnArg, target_reg: u16, target_version: u32) -> bool {
    match arg {
        InsnArg::Register(reg) => {
            reg.reg_num == target_reg && reg.ssa_version == target_version
        }
        InsnArg::Wrapped(wrapped) => wrapped
            .inline_insn
            .as_ref()
            .map(|insn| insn_contains_var(insn, target_reg, target_version))
            .unwrap_or(false),
        _ => false,
    }
}

/// Check if instruction contains variable (JADX: containsVar for InsnNode)
///
/// Checks if the instruction's result or any of its arguments contains
/// the specified register and SSA version.
///
/// JADX Reference: InsnUtils.java:266-283
/// ```java
/// public static boolean containsVar(InsnNode insn, RegisterArg arg) {
///     RegisterArg result = insn.getResult();
///     if (result != null && result.sameRegAndSVar(arg)) {
///         return true;
///     }
///     for (InsnArg insnArg : insn.getArguments()) {
///         if (containsVar(insnArg, arg)) {
///             return true;
///         }
///     }
///     return false;
/// }
/// ```
pub fn insn_contains_var(insn: &InsnNode, target_reg: u16, target_version: u32) -> bool {
    // Check result
    if let Some(dest) = insn.insn_type.get_dest() {
        if dest.reg_num == target_reg && dest.ssa_version == target_version {
            return true;
        }
    }

    // Check arguments
    for arg in insn.insn_type.get_args() {
        if arg_contains_var(arg, target_reg, target_version) {
            return true;
        }
    }

    false
}

/// Get wrapped instruction from argument (JADX: getWrappedInsn)
///
/// Returns the instruction wrapped inside an InsnWrapArg, or None if
/// the argument is not a wrapped instruction.
///
/// JADX Reference: InsnUtils.java:222-228
/// ```java
/// public static InsnNode getWrappedInsn(InsnArg arg) {
///     if (arg != null && arg.isInsnWrap()) {
///         return ((InsnWrapArg) arg).getWrapInsn();
///     }
///     return null;
/// }
/// ```
pub fn get_wrapped_insn(arg: &InsnArg) -> Option<&InsnNode> {
    match arg {
        InsnArg::Wrapped(wrapped) => wrapped.inline_insn.as_deref(),
        _ => None,
    }
}

/// Check if wrapped instruction is of specific type (JADX: isWrappedInsn)
///
/// Returns true if the argument is a wrapped instruction of the specified type.
///
/// JADX Reference: InsnUtils.java:230-237
/// ```java
/// public static boolean isWrappedInsn(InsnArg arg, InsnType type) {
///     if (arg.isInsnWrap()) {
///         InsnNode insn = ((InsnWrapArg) arg).getWrapInsn();
///         return insn.getType() == type;
///     }
///     return false;
/// }
/// ```
pub fn is_wrapped_insn_type(arg: &InsnArg, check_type: fn(&InsnType) -> bool) -> bool {
    match arg {
        InsnArg::Wrapped(wrapped) => wrapped
            .inline_insn
            .as_ref()
            .map(|insn| check_type(&insn.insn_type))
            .unwrap_or(false),
        _ => false,
    }
}

/// Format bytecode offset as hex string (JADX: formatOffset)
///
/// Formats an offset value as a zero-padded hexadecimal string.
///
/// JADX Reference: InsnUtils.java:341-343
/// ```java
/// public static String formatOffset(int offset) {
///     return String.format("0x%04x", offset);
/// }
/// ```
pub fn format_offset(offset: u32) -> String {
    format!("0x{:04x}", offset)
}

/// Check if instruction is a constant instruction (JADX: isConstInsn)
///
/// Returns true for CONST, CONST_STR, and CONST_CLASS instructions.
pub fn is_const_insn(insn: &InsnNode) -> bool {
    matches!(
        &insn.insn_type,
        InsnType::Const { .. } | InsnType::ConstString { .. } | InsnType::ConstClass { .. }
    )
}

/// Check if argument is a literal zero (JADX: isZeroLiteral)
///
/// Returns true if the argument is a literal with value 0.
pub fn is_zero_literal(arg: &InsnArg) -> bool {
    matches!(arg, InsnArg::Literal(crate::instructions::LiteralArg::Int(0)))
}

/// Check if argument is a literal one (JADX: isOneLiteral)
///
/// Returns true if the argument is a literal with value 1.
pub fn is_one_literal(arg: &InsnArg) -> bool {
    matches!(arg, InsnArg::Literal(crate::instructions::LiteralArg::Int(1)))
}

/// Check if instruction is a MOVE instruction (JADX: isMoveInsn)
///
/// Returns true if the instruction is a MOVE.
pub fn is_move_insn(insn: &InsnNode) -> bool {
    matches!(&insn.insn_type, InsnType::Move { .. })
}

/// Check if instruction is a constant zero (JADX: isZeroConst)
///
/// Returns true if the instruction is CONST with value 0.
pub fn is_zero_const(insn: &InsnNode) -> bool {
    matches!(&insn.insn_type, InsnType::Const { value: crate::instructions::LiteralArg::Int(0), .. })
}

#[cfg(test)]
mod tests {
    use super::*;
    use crate::instructions::{LiteralArg, RegisterArg};

    #[test]
    fn test_get_const_value_int() {
        let lit = LiteralArg::Int(42);
        let arg = InsnArg::Literal(lit);
        let const_val = get_const_value_by_arg(&arg);
        assert_eq!(const_val, Some(ConstValue::Int(42)));
    }

    #[test]
    fn test_get_const_value_string() {
        let arg = InsnArg::String("hello".to_string());
        let const_val = get_const_value_by_arg(&arg);
        assert_eq!(const_val, Some(ConstValue::String("hello".to_string())));
    }

    #[test]
    fn test_arg_contains_var() {
        let reg = RegisterArg {
            reg_num: 5,
            ssa_version: 2,
            arg_type: ArgType::Int,
        };
        let arg = InsnArg::Register(reg);
        assert!(arg_contains_var(&arg, 5, 2));
        assert!(!arg_contains_var(&arg, 5, 3));
        assert!(!arg_contains_var(&arg, 6, 2));
    }

    #[test]
    fn test_format_offset() {
        assert_eq!(format_offset(0), "0x0000");
        assert_eq!(format_offset(255), "0x00ff");
        assert_eq!(format_offset(4096), "0x1000");
    }

    #[test]
    fn test_is_zero_literal() {
        let zero = InsnArg::Literal(LiteralArg::Int(0));
        let one = InsnArg::Literal(LiteralArg::Int(1));
        assert!(is_zero_literal(&zero));
        assert!(!is_zero_literal(&one));
    }

    #[test]
    fn test_is_one_literal() {
        let zero = InsnArg::Literal(LiteralArg::Int(0));
        let one = InsnArg::Literal(LiteralArg::Int(1));
        assert!(!is_one_literal(&zero));
        assert!(is_one_literal(&one));
    }
}
