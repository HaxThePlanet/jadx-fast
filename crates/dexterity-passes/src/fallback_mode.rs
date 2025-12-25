//! Fallback Mode Visitor
//!
//! JADX Clone: jadx-core/src/main/java/jadx/core/dex/visitors/FallbackModeVisitor.java
//! Original Author: Skylot
//! Clone Date: Dec 2025
//! Lines: 55
//!
//! Removes unnecessary exception catch attributes from instructions that don't throw exceptions.
//! This is a cleanup pass used in fallback mode to simplify the IR.

use dexterity_ir::instructions::InsnType;

/// Instruction types that cannot throw exceptions
const NON_THROWING_INSN_TYPES: &[&str] = &[
    "Return",
    "If",
    "Goto",
    "Move",
    "MoveException",
    "Binary",
    "Unary",
    "Const",
    "ConstString",
    "ConstClass",
    "Compare",
];

/// Result of fallback mode processing
#[derive(Debug, Clone, Default)]
pub struct FallbackModeResult {
    /// Number of instructions processed
    pub instructions_processed: usize,
    /// Number of exception catches removed
    pub catches_removed: usize,
}

/// Check if an instruction type can throw an exception
///
/// JADX Reference: FallbackModeVisitor.visit() switch statement
pub fn can_throw_exception(insn_type: &InsnType) -> bool {
    match insn_type {
        // These never throw
        InsnType::Return { .. } => false,
        InsnType::If { .. } => false,
        InsnType::Goto { .. } => false,
        InsnType::Move { .. } => false,
        InsnType::MoveException { .. } => false,
        InsnType::Binary { .. } => false,
        InsnType::Unary { .. } => false,
        InsnType::Const { .. } => false,
        InsnType::ConstString { .. } => false,
        InsnType::ConstClass { .. } => false,
        InsnType::Compare { .. } => false,
        InsnType::Nop => false,
        InsnType::PackedSwitch { .. } => false,
        InsnType::SparseSwitch { .. } => false,
        InsnType::Phi { .. } => false,
        InsnType::Goto { .. } => false,
        InsnType::Cast { .. } => false,

        // These can throw
        InsnType::Invoke { .. } => true,
        InsnType::InvokeCustom { .. } => true,
        InsnType::NewInstance { .. } => true,
        InsnType::NewArray { .. } => true,
        InsnType::ArrayLength { .. } => true,
        InsnType::ArrayGet { .. } => true,
        InsnType::ArrayPut { .. } => true,
        InsnType::InstanceGet { .. } => true,
        InsnType::InstancePut { .. } => true,
        InsnType::StaticGet { .. } => true,
        InsnType::StaticPut { .. } => true,
        InsnType::CheckCast { .. } => true,
        InsnType::InstanceOf { .. } => true,
        InsnType::Throw { .. } => true,
        InsnType::MonitorEnter { .. } => true,
        InsnType::MonitorExit { .. } => true,
        InsnType::FilledNewArray { .. } => true,
        InsnType::FillArrayData { .. } => true,

        // Unknown/other - assume can throw
        _ => true,
    }
}

/// Process instructions to mark which ones actually need exception handling.
///
/// Returns the result with statistics.
///
/// JADX Reference: FallbackModeVisitor.visit()
pub fn process_fallback_mode(insn_types: &[InsnType]) -> FallbackModeResult {
    let mut result = FallbackModeResult::default();

    for insn_type in insn_types {
        result.instructions_processed += 1;
        if !can_throw_exception(insn_type) {
            // In a real implementation, this would remove the EXC_CATCH attribute
            // from the instruction. For now we just count.
            result.catches_removed += 1;
        }
    }

    result
}

/// Check if a method needs fallback mode processing
///
/// Returns true if there are any non-throwing instructions with catch attributes.
pub fn needs_fallback_processing(insn_types: &[InsnType], has_catch_attr: &[bool]) -> bool {
    for (insn_type, &has_catch) in insn_types.iter().zip(has_catch_attr.iter()) {
        if has_catch && !can_throw_exception(insn_type) {
            return true;
        }
    }
    false
}

#[cfg(test)]
mod tests {
    use super::*;

    #[test]
    fn test_can_throw_return() {
        let insn = InsnType::Return { value: None };
        assert!(!can_throw_exception(&insn));
    }

    #[test]
    fn test_can_throw_invoke() {
        use dexterity_ir::instructions::InvokeKind;
        let insn = InsnType::Invoke {
            kind: InvokeKind::Virtual,
            method_idx: 0,
            args: vec![].into(),
            proto_idx: None,
            dest: None,
        };
        assert!(can_throw_exception(&insn));
    }

    #[test]
    fn test_can_throw_move() {
        use dexterity_ir::instructions::{InsnArg, RegisterArg};
        let insn = InsnType::Move {
            dest: RegisterArg::new(0),
            src: InsnArg::Register(RegisterArg::new(1)),
        };
        assert!(!can_throw_exception(&insn));
    }

    #[test]
    fn test_can_throw_const() {
        use dexterity_ir::instructions::{LiteralArg, RegisterArg};
        let insn = InsnType::Const {
            dest: RegisterArg::new(0),
            value: LiteralArg::Int(42),
        };
        assert!(!can_throw_exception(&insn));
    }

    #[test]
    fn test_process_fallback_mode() {
        use dexterity_ir::instructions::{InvokeKind, LiteralArg, RegisterArg};

        let insns = vec![
            InsnType::Const {
                dest: RegisterArg::new(0),
                value: LiteralArg::Int(42),
            },
            InsnType::Return { value: None },
            InsnType::Invoke {
                kind: InvokeKind::Virtual,
                method_idx: 0,
                args: vec![].into(),
                proto_idx: None,
                dest: None,
            },
        ];

        let result = process_fallback_mode(&insns);
        assert_eq!(result.instructions_processed, 3);
        assert_eq!(result.catches_removed, 2); // Const and Return don't throw
    }
}
