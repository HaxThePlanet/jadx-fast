//! Code validation pass
//!
//! This pass validates instruction correctness before decompilation:
//! - Register numbers are within method bounds
//! - Methods don't have >255 arguments (Java spec limit)
//! - Instructions don't reference invalid registers
//!
//! Based on JADX's CheckCode.java visitor.

use dexterity_ir::instructions::{InsnArg, InsnNode, InsnType, RegisterArg};

/// Result of code validation
#[derive(Debug, Default)]
pub struct CheckCodeResult {
    /// Errors found during validation (will fail decompilation)
    pub errors: Vec<CheckCodeError>,
    /// Warnings found (decompilation can continue)
    pub warnings: Vec<CheckCodeWarning>,
    /// Whether the method should be ignored (too many args, empty)
    pub should_ignore: bool,
}

/// A validation error
#[derive(Debug, Clone)]
pub struct CheckCodeError {
    /// Instruction offset where error occurred
    pub offset: u32,
    /// Error message
    pub message: String,
}

/// A validation warning
#[derive(Debug, Clone)]
pub struct CheckCodeWarning {
    /// Instruction offset where warning occurred
    pub offset: u32,
    /// Warning message
    pub message: String,
}

impl CheckCodeResult {
    /// Check if validation passed (no errors)
    pub fn is_valid(&self) -> bool {
        self.errors.is_empty()
    }
}

/// Check code for a method
///
/// # Arguments
/// * `instructions` - List of instructions to check
/// * `regs_count` - Number of registers available in the method
/// * `args_count` - Number of method arguments
/// * `is_used` - Whether the method is used by other methods
///
/// # Returns
/// * `CheckCodeResult` with any errors/warnings found
pub fn check_code(
    instructions: &[InsnNode],
    regs_count: u16,
    args_count: usize,
    is_used: bool,
) -> CheckCodeResult {
    let mut result = CheckCodeResult::default();

    // Java spec doesn't allow more than 255 args
    if args_count > 255 {
        if can_remove_method(instructions, is_used) {
            result.should_ignore = true;
            result.warnings.push(CheckCodeWarning {
                offset: 0,
                message: format!("Method has {} arguments (>255), will be ignored", args_count),
            });
            return result;
        } else {
            result.warnings.push(CheckCodeWarning {
                offset: 0,
                message: format!("Method has {} arguments (>255), may cause issues", args_count),
            });
        }
    }

    // Check all instructions
    check_instructions(&mut result, instructions, regs_count);

    result
}

/// Check if a method can be safely removed (ignored)
///
/// A method can be removed if:
/// - It's not used by any other method
/// - It has no instructions, or only NOP/void-return instructions
fn can_remove_method(instructions: &[InsnNode], is_used: bool) -> bool {
    if !is_used {
        return true;
    }

    if instructions.is_empty() {
        return true;
    }

    for insn in instructions {
        match &insn.insn_type {
            InsnType::Nop => {}
            InsnType::Return { value: None } => {}
            _ => return false,
        }
    }

    true
}

/// Check all instructions for register validity
fn check_instructions(result: &mut CheckCodeResult, instructions: &[InsnNode], regs_count: u16) {
    for insn in instructions {
        // Collect all register arguments from this instruction
        let mut registers = Vec::new();
        collect_registers(&insn.insn_type, &mut registers);

        // Validate each register
        for reg in registers {
            if reg.reg_num >= regs_count {
                result.errors.push(CheckCodeError {
                    offset: insn.offset,
                    message: format!(
                        "Incorrect register number {} in instruction at offset {}, expected to be less than {}",
                        reg.reg_num, insn.offset, regs_count
                    ),
                });
            }
        }
    }
}

/// Collect all register arguments from an instruction
fn collect_registers(insn_type: &InsnType, registers: &mut Vec<RegisterArg>) {
    match insn_type {
        InsnType::Nop => {}

        InsnType::Const { dest, .. } => {
            registers.push(*dest);
        }

        InsnType::ConstString { dest, .. } => {
            registers.push(*dest);
        }

        InsnType::ConstClass { dest, .. } => {
            registers.push(*dest);
        }

        InsnType::Move { dest, src } => {
            registers.push(*dest);
            collect_from_arg(src, registers);
        }

        InsnType::MoveResult { dest } => {
            registers.push(*dest);
        }

        InsnType::MoveException { dest } => {
            registers.push(*dest);
        }

        InsnType::Return { value } => {
            if let Some(arg) = value {
                collect_from_arg(arg, registers);
            }
        }

        InsnType::Throw { exception } => {
            collect_from_arg(exception, registers);
        }

        InsnType::MonitorEnter { object } => {
            collect_from_arg(object, registers);
        }

        InsnType::MonitorExit { object } => {
            collect_from_arg(object, registers);
        }

        InsnType::CheckCast { object, .. } => {
            collect_from_arg(object, registers);
        }

        InsnType::InstanceOf { dest, object, .. } => {
            registers.push(*dest);
            collect_from_arg(object, registers);
        }

        InsnType::ArrayLength { dest, array } => {
            registers.push(*dest);
            collect_from_arg(array, registers);
        }

        InsnType::NewInstance { dest, .. } => {
            registers.push(*dest);
        }

        InsnType::NewArray { dest, size, .. } => {
            registers.push(*dest);
            collect_from_arg(size, registers);
        }

        InsnType::FilledNewArray { dest, args, .. } => {
            if let Some(d) = dest {
                registers.push(*d);
            }
            for arg in args.iter() {
                collect_from_arg(arg, registers);
            }
        }

        InsnType::FillArrayData { array, .. } => {
            collect_from_arg(array, registers);
        }

        InsnType::ArrayGet { dest, array, index, .. } => {
            registers.push(*dest);
            collect_from_arg(array, registers);
            collect_from_arg(index, registers);
        }

        InsnType::ArrayPut { array, index, value, .. } => {
            collect_from_arg(array, registers);
            collect_from_arg(index, registers);
            collect_from_arg(value, registers);
        }

        InsnType::InstanceGet { dest, object, .. } => {
            registers.push(*dest);
            collect_from_arg(object, registers);
        }

        InsnType::InstancePut { object, value, .. } => {
            collect_from_arg(object, registers);
            collect_from_arg(value, registers);
        }

        InsnType::StaticGet { dest, .. } => {
            registers.push(*dest);
        }

        InsnType::StaticPut { value, .. } => {
            collect_from_arg(value, registers);
        }

        InsnType::Invoke { args, dest, .. } => {
            if let Some(d) = dest {
                registers.push(*d);
            }
            for arg in args.iter() {
                collect_from_arg(arg, registers);
            }
        }

        InsnType::InvokeCustom { args, dest, .. } => {
            if let Some(d) = dest {
                registers.push(*d);
            }
            for arg in args.iter() {
                collect_from_arg(arg, registers);
            }
        }

        InsnType::Unary { dest, arg, .. } => {
            registers.push(*dest);
            collect_from_arg(arg, registers);
        }

        InsnType::Binary { dest, left, right, .. } => {
            registers.push(*dest);
            collect_from_arg(left, registers);
            collect_from_arg(right, registers);
        }

        InsnType::Cast { dest, arg, .. } => {
            registers.push(*dest);
            collect_from_arg(arg, registers);
        }

        InsnType::Compare { dest, left, right, .. } => {
            registers.push(*dest);
            collect_from_arg(left, registers);
            collect_from_arg(right, registers);
        }

        InsnType::If { left, right, .. } => {
            collect_from_arg(left, registers);
            if let Some(r) = right {
                collect_from_arg(r, registers);
            }
        }

        InsnType::Ternary { dest, left, right, then_value, else_value, .. } => {
            registers.push(*dest);
            collect_from_arg(left, registers);
            if let Some(r) = right {
                collect_from_arg(r, registers);
            }
            collect_from_arg(then_value, registers);
            collect_from_arg(else_value, registers);
        }

        InsnType::Goto { .. } => {}

        InsnType::PackedSwitch { value, .. } => {
            collect_from_arg(value, registers);
        }

        InsnType::SparseSwitch { value, .. } => {
            collect_from_arg(value, registers);
        }

        InsnType::Phi { dest, sources } => {
            registers.push(*dest);
            for (_, arg) in sources.iter() {
                collect_from_arg(arg, registers);
            }
        }

        InsnType::MoveMulti { moves } => {
            for (dest, src) in moves {
                registers.push(*dest);
                collect_from_arg(src, registers);
            }
        }

        InsnType::StrConcat { dest, args } => {
            registers.push(*dest);
            for arg in args {
                collect_from_arg(arg, registers);
            }
        }

        InsnType::RegionArg { args } => {
            for arg in args {
                collect_from_arg(arg, registers);
            }
        }

        InsnType::OneArg { arg } => {
            collect_from_arg(arg, registers);
        }

        InsnType::Constructor { dest, args, .. } => {
            registers.push(*dest);
            for arg in args {
                collect_from_arg(arg, registers);
            }
        }

        InsnType::JavaJsr { .. } => {}

        InsnType::JavaRet { addr_reg } => {
            registers.push(*addr_reg);
        }

        InsnType::Break { .. } => {}
        InsnType::Continue { .. } => {}
    }
}

/// Collect register from an InsnArg
fn collect_from_arg(arg: &InsnArg, registers: &mut Vec<RegisterArg>) {
    match arg {
        InsnArg::Register(reg) => {
            registers.push(*reg);
        }
        InsnArg::Wrapped(wrapped) => {
            // Recursively collect from wrapped instruction (if it has inline_insn)
            if let Some(inline_insn) = &wrapped.inline_insn {
                collect_registers(&inline_insn.insn_type, registers);
            }
        }
        // Literals don't contain registers
        InsnArg::Literal(_) => {}
        // This reference
        InsnArg::This { .. } => {}
        // Type references don't contain registers
        InsnArg::Type(_) => {}
        // Field references don't contain registers
        InsnArg::Field(_) => {}
        // Method references don't contain registers
        InsnArg::Method(_) => {}
        // String references don't contain registers
        InsnArg::String(_) => {}
        // Named arguments don't contain direct registers
        InsnArg::Named { .. } => {}
        // Catch-all for any other variants
        _ => {}
    }
}

#[cfg(test)]
mod tests {
    use super::*;
    use dexterity_ir::instructions::LiteralArg;

    #[test]
    fn test_check_code_valid() {
        let instructions = vec![
            InsnNode::new(InsnType::Const {
                dest: RegisterArg::new(0),
                value: LiteralArg::Int(42)
            }, 0),
            InsnNode::new(InsnType::Return { value: None }, 2),
        ];

        let result = check_code(&instructions, 5, 0, false);
        assert!(result.is_valid());
        assert!(!result.should_ignore);
    }

    #[test]
    fn test_check_code_invalid_register() {
        let instructions = vec![
            InsnNode::new(InsnType::Const {
                dest: RegisterArg::new(10), // Beyond regs_count of 5
                value: LiteralArg::Int(42)
            }, 0),
        ];

        let result = check_code(&instructions, 5, 0, false);
        assert!(!result.is_valid());
        assert_eq!(result.errors.len(), 1);
        assert!(result.errors[0].message.contains("10"));
    }

    #[test]
    fn test_check_code_too_many_args() {
        let instructions = vec![
            InsnNode::new(InsnType::Return { value: None }, 0),
        ];

        let result = check_code(&instructions, 300, 300, false);
        assert!(result.should_ignore);
    }

    #[test]
    fn test_can_remove_empty_unused() {
        assert!(can_remove_method(&[], false));
        assert!(can_remove_method(&[], true));
    }
}
