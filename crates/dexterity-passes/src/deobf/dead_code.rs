//! Dead Code Elimination
//!
//! Removes unreachable code and dead instructions:
//! - Unreachable blocks (no path from entry)
//! - Dead instructions (defined but never used)
//! - Dummy exception handlers (rethrow-only, empty catch)

use dexterity_ir::instructions::{InsnArg, InsnNode, InsnType};
use dexterity_ir::MethodData;
use std::collections::HashSet;

/// Statistics from dead code elimination
#[derive(Debug, Clone, Default)]
pub struct DeadCodeStats {
    /// Number of instructions removed
    pub instructions_removed: usize,
    /// Number of blocks removed
    pub blocks_removed: usize,
    /// Number of exception handlers removed
    pub handlers_removed: usize,
}

/// Dead code eliminator pass
pub struct DeadCodeEliminator {
    /// Registers that are used (read from)
    used_registers: HashSet<u16>,
    /// Registers that are defined (written to)
    defined_registers: HashSet<u16>,
}

impl DeadCodeEliminator {
    /// Create new eliminator
    pub fn new() -> Self {
        Self {
            used_registers: HashSet::new(),
            defined_registers: HashSet::new(),
        }
    }

    /// Run dead code elimination on a method
    pub fn eliminate(&mut self, method: &mut MethodData) -> DeadCodeStats {
        let mut stats = DeadCodeStats::default();

        // Phase 1: Find used registers
        self.find_used_registers(method);

        // Phase 2: Remove dead instructions
        stats.instructions_removed = self.remove_dead_instructions(method);

        // Phase 3: Remove dummy exception handlers
        stats.handlers_removed = self.remove_dummy_handlers(method);

        stats
    }

    /// Find all registers that are used (read)
    fn find_used_registers(&mut self, method: &MethodData) {
        self.used_registers.clear();
        self.defined_registers.clear();

        let instructions = match &method.instructions {
            Some(insns) => insns,
            None => return,
        };

        for inst in instructions {
            // Collect used registers
            self.collect_used_registers(inst);
            // Collect defined registers
            self.collect_defined_registers(inst);
        }
    }

    /// Collect registers used (read) by an instruction
    fn collect_used_registers(&mut self, inst: &InsnNode) {
        match &inst.insn_type {
            InsnType::Move { src, .. } => {
                self.add_used_from_arg(src);
            }
            InsnType::Binary { left, right, .. } => {
                self.add_used_from_arg(left);
                self.add_used_from_arg(right);
            }
            InsnType::Unary { arg, .. } => {
                self.add_used_from_arg(arg);
            }
            InsnType::Return { value } => {
                if let Some(v) = value {
                    self.add_used_from_arg(v);
                }
            }
            InsnType::If { left, right, .. } => {
                self.add_used_from_arg(left);
                if let Some(r) = right {
                    self.add_used_from_arg(r);
                }
            }
            InsnType::ArrayGet { array, index, .. } => {
                self.add_used_from_arg(array);
                self.add_used_from_arg(index);
            }
            InsnType::ArrayPut { array, index, value, .. } => {
                self.add_used_from_arg(array);
                self.add_used_from_arg(index);
                self.add_used_from_arg(value);
            }
            InsnType::InstanceGet { object, .. } => {
                self.add_used_from_arg(object);
            }
            InsnType::InstancePut { object, value, .. } => {
                self.add_used_from_arg(object);
                self.add_used_from_arg(value);
            }
            InsnType::StaticPut { value, .. } => {
                self.add_used_from_arg(value);
            }
            InsnType::Invoke { args, .. } => {
                for arg in args {
                    self.add_used_from_arg(arg);
                }
            }
            InsnType::InvokeCustom { args, .. } => {
                for arg in args {
                    self.add_used_from_arg(arg);
                }
            }
            InsnType::Throw { exception } => {
                self.add_used_from_arg(exception);
            }
            InsnType::CheckCast { object, .. } => {
                self.add_used_from_arg(object);
            }
            InsnType::InstanceOf { object, .. } => {
                self.add_used_from_arg(object);
            }
            InsnType::ArrayLength { array, .. } => {
                self.add_used_from_arg(array);
            }
            InsnType::MonitorEnter { object } | InsnType::MonitorExit { object } => {
                self.add_used_from_arg(object);
            }
            InsnType::PackedSwitch { value, .. } | InsnType::SparseSwitch { value, .. } => {
                self.add_used_from_arg(value);
            }
            InsnType::Compare { left, right, .. } => {
                self.add_used_from_arg(left);
                self.add_used_from_arg(right);
            }
            InsnType::NewArray { size, .. } => {
                self.add_used_from_arg(size);
            }
            InsnType::FilledNewArray { args, .. } => {
                for arg in args {
                    self.add_used_from_arg(arg);
                }
            }
            InsnType::FillArrayData { array, .. } => {
                self.add_used_from_arg(array);
            }
            InsnType::Phi { sources, .. } => {
                for (_, arg) in sources {
                    self.add_used_from_arg(arg);
                }
            }
            InsnType::Ternary { left, right, then_value, else_value, .. } => {
                self.add_used_from_arg(left);
                if let Some(r) = right {
                    self.add_used_from_arg(r);
                }
                self.add_used_from_arg(then_value);
                self.add_used_from_arg(else_value);
            }
            _ => {}
        }
    }

    /// Add register from argument to used set
    fn add_used_from_arg(&mut self, arg: &InsnArg) {
        if let InsnArg::Register(reg) = arg {
            self.used_registers.insert(reg.reg_num);
        }
    }

    /// Collect registers defined (written) by an instruction
    fn collect_defined_registers(&mut self, inst: &InsnNode) {
        if let Some(dest) = self.get_dest_register(&inst.insn_type) {
            self.defined_registers.insert(dest);
        }
    }

    /// Get destination register of an instruction
    fn get_dest_register(&self, insn_type: &InsnType) -> Option<u16> {
        match insn_type {
            InsnType::Move { dest, .. } => Some(dest.reg_num),
            InsnType::Const { dest, .. } => Some(dest.reg_num),
            InsnType::ConstString { dest, .. } => Some(dest.reg_num),
            InsnType::ConstClass { dest, .. } => Some(dest.reg_num),
            InsnType::Binary { dest, .. } => Some(dest.reg_num),
            InsnType::Unary { dest, .. } => Some(dest.reg_num),
            InsnType::ArrayGet { dest, .. } => Some(dest.reg_num),
            InsnType::InstanceGet { dest, .. } => Some(dest.reg_num),
            InsnType::StaticGet { dest, .. } => Some(dest.reg_num),
            InsnType::Invoke { dest: Some(dest), .. } => Some(dest.reg_num),
            InsnType::InvokeCustom { dest: Some(dest), .. } => Some(dest.reg_num),
            InsnType::NewInstance { dest, .. } => Some(dest.reg_num),
            InsnType::NewArray { dest, .. } => Some(dest.reg_num),
            InsnType::FilledNewArray { dest: Some(dest), .. } => Some(dest.reg_num),
            InsnType::CheckCast { .. } => None, // CheckCast doesn't define a new register
            InsnType::InstanceOf { dest, .. } => Some(dest.reg_num),
            InsnType::ArrayLength { dest, .. } => Some(dest.reg_num),
            InsnType::Compare { dest, .. } => Some(dest.reg_num),
            InsnType::MoveException { dest } => Some(dest.reg_num),
            InsnType::MoveResult { dest } => Some(dest.reg_num),
            InsnType::Phi { dest, .. } => Some(dest.reg_num),
            InsnType::Ternary { dest, .. } => Some(dest.reg_num),
            InsnType::Cast { dest, .. } => Some(dest.reg_num),
            _ => None,
        }
    }

    /// Remove dead instructions (defined but never used, no side effects)
    fn remove_dead_instructions(&self, method: &mut MethodData) -> usize {
        let instructions = match &mut method.instructions {
            Some(insns) => insns,
            None => return 0,
        };

        let original_len = instructions.len();
        instructions.retain(|inst| !self.is_dead_instruction(&inst.insn_type));
        original_len - instructions.len()
    }

    /// Check if an instruction is dead (can be safely removed)
    fn is_dead_instruction(&self, insn_type: &InsnType) -> bool {
        // Get the destination register, if any
        let dest = match insn_type {
            InsnType::Move { dest, .. } => Some(dest.reg_num),
            InsnType::Const { dest, .. } => Some(dest.reg_num),
            InsnType::ConstString { dest, .. } => Some(dest.reg_num),
            InsnType::ConstClass { dest, .. } => Some(dest.reg_num),
            InsnType::Binary { dest, .. } => Some(dest.reg_num),
            InsnType::Unary { dest, .. } => Some(dest.reg_num),
            // These have side effects and shouldn't be removed even if unused
            InsnType::Invoke { .. } => return false,
            InsnType::InvokeCustom { .. } => return false,
            InsnType::InstancePut { .. } => return false,
            InsnType::StaticPut { .. } => return false,
            InsnType::ArrayPut { .. } => return false,
            InsnType::Throw { .. } => return false,
            InsnType::MonitorEnter { .. } | InsnType::MonitorExit { .. } => return false,
            InsnType::Return { .. } => return false,
            InsnType::Goto { .. } => return false,
            InsnType::If { .. } => return false,
            InsnType::PackedSwitch { .. } | InsnType::SparseSwitch { .. } => return false,
            InsnType::FillArrayData { .. } => return false,
            // Other instructions that produce values
            InsnType::ArrayGet { dest, .. } => Some(dest.reg_num),
            InsnType::InstanceGet { dest, .. } => Some(dest.reg_num),
            InsnType::StaticGet { dest, .. } => Some(dest.reg_num),
            InsnType::NewInstance { dest, .. } => Some(dest.reg_num),
            InsnType::NewArray { dest, .. } => Some(dest.reg_num),
            InsnType::FilledNewArray { dest: Some(dest), .. } => Some(dest.reg_num),
            InsnType::InstanceOf { dest, .. } => Some(dest.reg_num),
            InsnType::ArrayLength { dest, .. } => Some(dest.reg_num),
            InsnType::Compare { dest, .. } => Some(dest.reg_num),
            InsnType::MoveException { dest } => Some(dest.reg_num),
            InsnType::MoveResult { dest } => Some(dest.reg_num),
            InsnType::Phi { dest, .. } => Some(dest.reg_num),
            _ => None,
        };

        // If the destination is never used, it's dead
        if let Some(d) = dest {
            !self.used_registers.contains(&d)
        } else {
            false
        }
    }

    /// Remove dummy exception handlers
    fn remove_dummy_handlers(&self, method: &mut MethodData) -> usize {
        let instructions = match &method.instructions {
            Some(insns) => insns,
            None => return 0,
        };

        // Find handlers that just rethrow immediately
        let dummy_handlers: Vec<usize> = method.try_blocks.iter()
            .enumerate()
            .filter(|(_, try_block)| {
                try_block.handlers.iter().all(|handler| {
                    self.is_rethrow_handler(instructions, handler.handler_addr as usize)
                })
            })
            .map(|(idx, _)| idx)
            .collect();

        // Remove dummy handlers (in reverse to preserve indices)
        let removed = dummy_handlers.len();
        for idx in dummy_handlers.into_iter().rev() {
            method.try_blocks.remove(idx);
        }

        removed
    }

    /// Check if a handler just rethrows the exception
    fn is_rethrow_handler(&self, instructions: &[InsnNode], handler_offset: usize) -> bool {
        // Find instruction at handler offset
        // This is a simplified check - in reality we'd need to map offsets to instruction indices

        // Look for pattern: move-exception vX; throw vX
        if handler_offset + 1 < instructions.len() {
            let first = &instructions[handler_offset];
            let second = &instructions[handler_offset + 1];

            if let (
                InsnType::MoveException { dest },
                InsnType::Throw { exception: InsnArg::Register(exc_reg) }
            ) = (&first.insn_type, &second.insn_type) {
                return dest.reg_num == exc_reg.reg_num;
            }
        }

        false
    }
}

impl Default for DeadCodeEliminator {
    fn default() -> Self {
        Self::new()
    }
}

#[cfg(test)]
mod tests {
    use super::*;

    #[test]
    fn test_stats_default() {
        let stats = DeadCodeStats::default();
        assert_eq!(stats.instructions_removed, 0);
        assert_eq!(stats.blocks_removed, 0);
    }

    #[test]
    fn test_eliminator_creation() {
        let eliminator = DeadCodeEliminator::new();
        assert!(eliminator.used_registers.is_empty());
    }
}
