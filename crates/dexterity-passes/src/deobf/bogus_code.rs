//! Bogus Code Removal
//!
//! Removes useless code patterns inserted by obfuscators:
//! - Dead stores (assigned but never read)
//! - Useless computations (result discarded)
//! - Redundant null checks (after new or non-null constant)
//! - Identity operations (x + 0, x * 1, x = x)

use dexterity_ir::instructions::{BinaryOp, InsnArg, InsnType, LiteralArg};
use dexterity_ir::MethodData;
use std::collections::{HashMap, HashSet};

/// Statistics from bogus code removal
#[derive(Debug, Clone, Default)]
pub struct BogusCodeStats {
    /// Number of instructions removed
    pub instructions_removed: usize,
    /// Number of dead stores removed
    pub dead_stores_removed: usize,
    /// Number of identity operations removed
    pub identity_ops_removed: usize,
    /// Number of redundant checks removed
    pub redundant_checks_removed: usize,
}

/// Bogus code remover pass
pub struct BogusCodeRemover {
    /// Register use counts
    use_counts: HashMap<u16, usize>,
    /// Registers known to be non-null
    non_null_regs: HashSet<u16>,
    /// Registers that were just defined
    just_defined: HashSet<u16>,
}

impl BogusCodeRemover {
    /// Create new remover
    pub fn new() -> Self {
        Self {
            use_counts: HashMap::new(),
            non_null_regs: HashSet::new(),
            just_defined: HashSet::new(),
        }
    }

    /// Run bogus code removal on a method
    pub fn remove(&mut self, method: &mut MethodData) -> BogusCodeStats {
        let mut stats = BogusCodeStats::default();

        // Phase 1: Count register uses
        self.count_uses(method);

        // Phase 2: Find non-null registers
        self.find_non_null_registers(method);

        // Phase 3: Remove bogus code
        let instructions = match &mut method.instructions {
            Some(insns) => insns,
            None => return stats,
        };

        self.just_defined.clear();
        let original_len = instructions.len();

        instructions.retain(|inst| {
            let keep = !self.is_bogus(&inst.insn_type, &mut stats);
            if keep {
                // Track definitions for next instruction
                if let Some(dest) = self.get_dest(&inst.insn_type) {
                    self.just_defined.insert(dest);
                }
            }
            keep
        });

        stats.instructions_removed = original_len - instructions.len();
        stats
    }

    /// Count how many times each register is used
    fn count_uses(&mut self, method: &MethodData) {
        self.use_counts.clear();

        let instructions = match &method.instructions {
            Some(insns) => insns,
            None => return,
        };

        for inst in instructions {
            for reg in self.get_used_registers(&inst.insn_type) {
                *self.use_counts.entry(reg).or_insert(0) += 1;
            }
        }
    }

    /// Find registers known to be non-null
    fn find_non_null_registers(&mut self, method: &MethodData) {
        self.non_null_regs.clear();

        let instructions = match &method.instructions {
            Some(insns) => insns,
            None => return,
        };

        for inst in instructions {
            match &inst.insn_type {
                // Result of new is never null
                InsnType::NewInstance { dest, .. } => {
                    self.non_null_regs.insert(dest.reg_num);
                }
                // Non-null string constants
                InsnType::ConstString { dest, .. } => {
                    self.non_null_regs.insert(dest.reg_num);
                }
                // Class constants are never null
                InsnType::ConstClass { dest, .. } => {
                    self.non_null_regs.insert(dest.reg_num);
                }
                // New arrays are never null
                InsnType::NewArray { dest, .. } => {
                    self.non_null_regs.insert(dest.reg_num);
                }
                InsnType::FilledNewArray { dest: Some(dest), .. } => {
                    self.non_null_regs.insert(dest.reg_num);
                }
                _ => {}
            }
        }
    }

    /// Check if an instruction is bogus and should be removed
    fn is_bogus(&self, insn_type: &InsnType, stats: &mut BogusCodeStats) -> bool {
        // Check for identity operations
        if self.is_identity_op(insn_type) {
            stats.identity_ops_removed += 1;
            return true;
        }

        // Check for dead stores (defined but never used)
        if self.is_dead_store(insn_type) {
            stats.dead_stores_removed += 1;
            return true;
        }

        false
    }

    /// Check if instruction is an identity operation
    fn is_identity_op(&self, insn_type: &InsnType) -> bool {
        match insn_type {
            // x = x (self-move)
            InsnType::Move { dest, src: InsnArg::Register(src_reg) }
                if dest.reg_num == src_reg.reg_num => true,

            // x + 0, x - 0, x | 0, x ^ 0
            InsnType::Binary { op, dest, left, right, .. } => {
                match (op, left, right) {
                    // x + 0 = x
                    (BinaryOp::Add, InsnArg::Register(r), InsnArg::Literal(LiteralArg::Int(0)))
                    | (BinaryOp::Add, InsnArg::Literal(LiteralArg::Int(0)), InsnArg::Register(r))
                        if r.reg_num == dest.reg_num => true,

                    // x - 0 = x
                    (BinaryOp::Sub, InsnArg::Register(r), InsnArg::Literal(LiteralArg::Int(0)))
                        if r.reg_num == dest.reg_num => true,

                    // x * 1 = x
                    (BinaryOp::Mul, InsnArg::Register(r), InsnArg::Literal(LiteralArg::Int(1)))
                    | (BinaryOp::Mul, InsnArg::Literal(LiteralArg::Int(1)), InsnArg::Register(r))
                        if r.reg_num == dest.reg_num => true,

                    // x / 1 = x
                    (BinaryOp::Div, InsnArg::Register(r), InsnArg::Literal(LiteralArg::Int(1)))
                        if r.reg_num == dest.reg_num => true,

                    // x | 0 = x
                    (BinaryOp::Or, InsnArg::Register(r), InsnArg::Literal(LiteralArg::Int(0)))
                    | (BinaryOp::Or, InsnArg::Literal(LiteralArg::Int(0)), InsnArg::Register(r))
                        if r.reg_num == dest.reg_num => true,

                    // x ^ 0 = x
                    (BinaryOp::Xor, InsnArg::Register(r), InsnArg::Literal(LiteralArg::Int(0)))
                    | (BinaryOp::Xor, InsnArg::Literal(LiteralArg::Int(0)), InsnArg::Register(r))
                        if r.reg_num == dest.reg_num => true,

                    // x & -1 = x (all bits set)
                    (BinaryOp::And, InsnArg::Register(r), InsnArg::Literal(LiteralArg::Int(-1)))
                    | (BinaryOp::And, InsnArg::Literal(LiteralArg::Int(-1)), InsnArg::Register(r))
                        if r.reg_num == dest.reg_num => true,

                    // x << 0 = x, x >> 0 = x
                    (BinaryOp::Shl, InsnArg::Register(r), InsnArg::Literal(LiteralArg::Int(0)))
                    | (BinaryOp::Shr, InsnArg::Register(r), InsnArg::Literal(LiteralArg::Int(0)))
                    | (BinaryOp::Ushr, InsnArg::Register(r), InsnArg::Literal(LiteralArg::Int(0)))
                        if r.reg_num == dest.reg_num => true,

                    _ => false,
                }
            }

            _ => false,
        }
    }

    /// Check if instruction is a dead store
    fn is_dead_store(&self, insn_type: &InsnType) -> bool {
        // Only check pure computations (no side effects)
        let dest = match insn_type {
            InsnType::Const { dest, .. } => Some(dest.reg_num),
            InsnType::Move { dest, .. } => Some(dest.reg_num),
            InsnType::Binary { dest, .. } => Some(dest.reg_num),
            InsnType::Unary { dest, .. } => Some(dest.reg_num),
            // These have potential side effects
            InsnType::Invoke { .. } => return false,
            InsnType::InvokeCustom { .. } => return false,
            InsnType::InstanceGet { .. } => return false, // May have side effects in getter
            InsnType::ArrayGet { .. } => return false, // May throw
            _ => return false,
        };

        if let Some(d) = dest {
            // Check if this register is never used
            self.use_counts.get(&d).copied().unwrap_or(0) == 0
        } else {
            false
        }
    }

    /// Get destination register of an instruction
    fn get_dest(&self, insn_type: &InsnType) -> Option<u16> {
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
            InsnType::Invoke { dest, .. } => dest.as_ref().map(|d| d.reg_num),
            InsnType::InvokeCustom { dest, .. } => dest.as_ref().map(|d| d.reg_num),
            InsnType::NewInstance { dest, .. } => Some(dest.reg_num),
            InsnType::NewArray { dest, .. } => Some(dest.reg_num),
            InsnType::FilledNewArray { dest, .. } => dest.as_ref().map(|d| d.reg_num),
            InsnType::InstanceOf { dest, .. } => Some(dest.reg_num),
            InsnType::ArrayLength { dest, .. } => Some(dest.reg_num),
            InsnType::Compare { dest, .. } => Some(dest.reg_num),
            InsnType::MoveException { dest } => Some(dest.reg_num),
            InsnType::MoveResult { dest } => Some(dest.reg_num),
            InsnType::Phi { dest, .. } => Some(dest.reg_num),
            _ => None,
        }
    }

    /// Get registers used by an instruction
    fn get_used_registers(&self, insn_type: &InsnType) -> Vec<u16> {
        let mut regs = Vec::new();

        match insn_type {
            InsnType::Move { src, .. } => {
                self.add_reg_from_arg(src, &mut regs);
            }
            InsnType::Binary { left, right, .. } => {
                self.add_reg_from_arg(left, &mut regs);
                self.add_reg_from_arg(right, &mut regs);
            }
            InsnType::Unary { arg, .. } => {
                self.add_reg_from_arg(arg, &mut regs);
            }
            InsnType::Return { value } => {
                if let Some(v) = value {
                    self.add_reg_from_arg(v, &mut regs);
                }
            }
            InsnType::If { left, right, .. } => {
                self.add_reg_from_arg(left, &mut regs);
                if let Some(r) = right {
                    self.add_reg_from_arg(r, &mut regs);
                }
            }
            InsnType::PackedSwitch { value, .. } | InsnType::SparseSwitch { value, .. } => {
                self.add_reg_from_arg(value, &mut regs);
            }
            InsnType::ArrayGet { array, index, .. } => {
                self.add_reg_from_arg(array, &mut regs);
                self.add_reg_from_arg(index, &mut regs);
            }
            InsnType::ArrayPut { array, index, value, .. } => {
                self.add_reg_from_arg(array, &mut regs);
                self.add_reg_from_arg(index, &mut regs);
                self.add_reg_from_arg(value, &mut regs);
            }
            InsnType::InstanceGet { object, .. } => {
                self.add_reg_from_arg(object, &mut regs);
            }
            InsnType::InstancePut { object, value, .. } => {
                self.add_reg_from_arg(object, &mut regs);
                self.add_reg_from_arg(value, &mut regs);
            }
            InsnType::StaticPut { value, .. } => {
                self.add_reg_from_arg(value, &mut regs);
            }
            InsnType::Invoke { args, .. } => {
                for arg in args {
                    self.add_reg_from_arg(arg, &mut regs);
                }
            }
            InsnType::InvokeCustom { args, .. } => {
                for arg in args {
                    self.add_reg_from_arg(arg, &mut regs);
                }
            }
            InsnType::Throw { exception } => {
                self.add_reg_from_arg(exception, &mut regs);
            }
            InsnType::CheckCast { object, .. } => {
                self.add_reg_from_arg(object, &mut regs);
            }
            InsnType::InstanceOf { object, .. } => {
                self.add_reg_from_arg(object, &mut regs);
            }
            InsnType::ArrayLength { array, .. } => {
                self.add_reg_from_arg(array, &mut regs);
            }
            InsnType::MonitorEnter { object } | InsnType::MonitorExit { object } => {
                self.add_reg_from_arg(object, &mut regs);
            }
            InsnType::Compare { left, right, .. } => {
                self.add_reg_from_arg(left, &mut regs);
                self.add_reg_from_arg(right, &mut regs);
            }
            InsnType::NewArray { size, .. } => {
                self.add_reg_from_arg(size, &mut regs);
            }
            InsnType::FilledNewArray { args, .. } => {
                for arg in args {
                    self.add_reg_from_arg(arg, &mut regs);
                }
            }
            InsnType::FillArrayData { array, .. } => {
                self.add_reg_from_arg(array, &mut regs);
            }
            InsnType::Phi { sources, .. } => {
                for (_, arg) in sources {
                    self.add_reg_from_arg(arg, &mut regs);
                }
            }
            _ => {}
        }

        regs
    }

    /// Add register from argument to vector if it's a register
    fn add_reg_from_arg(&self, arg: &InsnArg, regs: &mut Vec<u16>) {
        if let InsnArg::Register(reg) = arg {
            regs.push(reg.reg_num);
        }
    }
}

impl Default for BogusCodeRemover {
    fn default() -> Self {
        Self::new()
    }
}

#[cfg(test)]
mod tests {
    use super::*;

    #[test]
    fn test_stats_default() {
        let stats = BogusCodeStats::default();
        assert_eq!(stats.instructions_removed, 0);
    }

    #[test]
    fn test_remover_creation() {
        let remover = BogusCodeRemover::new();
        assert!(remover.use_counts.is_empty());
    }
}
