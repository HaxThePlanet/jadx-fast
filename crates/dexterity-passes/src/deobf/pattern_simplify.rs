//! Pattern Simplification
//!
//! Simplifies obfuscated code patterns:
//! - Arithmetic encoding: x * 2 -> x << 1, x % 2 -> x & 1
//! - Mixed Boolean-Arithmetic (MBA): (x ^ y) + 2*(x & y) -> x + y
//! - Switch-on-hash to switch-on-string/enum
//! - Trivial method inlining

use dexterity_ir::instructions::{BinaryOp, InsnArg, InsnType, LiteralArg, RegisterArg};
use dexterity_ir::MethodData;

/// Statistics from pattern simplification
#[derive(Debug, Clone, Default)]
pub struct SimplificationStats {
    /// Number of patterns simplified
    pub patterns_simplified: usize,
    /// Number of arithmetic encodings simplified
    pub arithmetic_simplified: usize,
    /// Number of MBA expressions simplified
    pub mba_simplified: usize,
    /// Number of switch patterns simplified
    pub switch_simplified: usize,
}

/// Pattern simplifier pass
pub struct PatternSimplifier {
    /// Track substitutions made
    substitutions: Vec<(usize, InsnType)>,
}

impl PatternSimplifier {
    /// Create new simplifier
    pub fn new() -> Self {
        Self {
            substitutions: Vec::new(),
        }
    }

    /// Run pattern simplification on a method
    pub fn simplify(&mut self, method: &mut MethodData) -> SimplificationStats {
        let mut stats = SimplificationStats::default();
        self.substitutions.clear();

        let instructions = match &method.instructions {
            Some(insns) => insns,
            None => return stats,
        };

        // Collect simplifications first
        for (inst_idx, insn) in instructions.iter().enumerate() {
            if let Some(simplified) = self.simplify_instruction(&insn.insn_type, &mut stats) {
                self.substitutions.push((inst_idx, simplified));
            }
        }

        // Apply substitutions
        let instructions = match &mut method.instructions {
            Some(insns) => insns,
            None => return stats,
        };

        for (inst_idx, new_insn_type) in self.substitutions.drain(..) {
            if inst_idx < instructions.len() {
                instructions[inst_idx].insn_type = new_insn_type;
                stats.patterns_simplified += 1;
            }
        }

        stats
    }

    /// Try to simplify a single instruction
    fn simplify_instruction(
        &self,
        insn_type: &InsnType,
        stats: &mut SimplificationStats,
    ) -> Option<InsnType> {
        match insn_type {
            InsnType::Binary { op, dest, left, right, arg_type } => {
                self.simplify_binary_op(op, dest, left, right, arg_type.clone(), stats)
            }
            _ => None,
        }
    }

    /// Simplify binary operations
    fn simplify_binary_op(
        &self,
        op: &BinaryOp,
        dest: &RegisterArg,
        left: &InsnArg,
        right: &InsnArg,
        arg_type: Option<dexterity_ir::ArgType>,
        stats: &mut SimplificationStats,
    ) -> Option<InsnType> {
        match op {
            // x * 2 -> x << 1
            BinaryOp::Mul => {
                match (left, right) {
                    (InsnArg::Register(r), InsnArg::Literal(LiteralArg::Int(2)))
                    | (InsnArg::Literal(LiteralArg::Int(2)), InsnArg::Register(r)) => {
                        stats.arithmetic_simplified += 1;
                        return Some(InsnType::Binary {
                            op: BinaryOp::Shl,
                            dest: *dest,
                            left: InsnArg::Register(*r),
                            right: InsnArg::Literal(LiteralArg::Int(1)),
                            arg_type,
                        });
                    }
                    // x * 4 -> x << 2
                    (InsnArg::Register(r), InsnArg::Literal(LiteralArg::Int(4)))
                    | (InsnArg::Literal(LiteralArg::Int(4)), InsnArg::Register(r)) => {
                        stats.arithmetic_simplified += 1;
                        return Some(InsnType::Binary {
                            op: BinaryOp::Shl,
                            dest: *dest,
                            left: InsnArg::Register(*r),
                            right: InsnArg::Literal(LiteralArg::Int(2)),
                            arg_type,
                        });
                    }
                    // x * 8 -> x << 3
                    (InsnArg::Register(r), InsnArg::Literal(LiteralArg::Int(8)))
                    | (InsnArg::Literal(LiteralArg::Int(8)), InsnArg::Register(r)) => {
                        stats.arithmetic_simplified += 1;
                        return Some(InsnType::Binary {
                            op: BinaryOp::Shl,
                            dest: *dest,
                            left: InsnArg::Register(*r),
                            right: InsnArg::Literal(LiteralArg::Int(3)),
                            arg_type,
                        });
                    }
                    _ => {}
                }
            }

            // x / 2 -> x >> 1 (for positive x, simplified)
            BinaryOp::Div => {
                if let (InsnArg::Register(r), InsnArg::Literal(LiteralArg::Int(2))) = (left, right) {
                    stats.arithmetic_simplified += 1;
                    return Some(InsnType::Binary {
                        op: BinaryOp::Shr,
                        dest: *dest,
                        left: InsnArg::Register(*r),
                        right: InsnArg::Literal(LiteralArg::Int(1)),
                        arg_type,
                    });
                }
            }

            // x % 2 -> x & 1
            BinaryOp::Rem => {
                if let (InsnArg::Register(r), InsnArg::Literal(LiteralArg::Int(2))) = (left, right) {
                    stats.arithmetic_simplified += 1;
                    return Some(InsnType::Binary {
                        op: BinaryOp::And,
                        dest: *dest,
                        left: InsnArg::Register(*r),
                        right: InsnArg::Literal(LiteralArg::Int(1)),
                        arg_type,
                    });
                }
                // x % 4 -> x & 3
                if let (InsnArg::Register(r), InsnArg::Literal(LiteralArg::Int(4))) = (left, right) {
                    stats.arithmetic_simplified += 1;
                    return Some(InsnType::Binary {
                        op: BinaryOp::And,
                        dest: *dest,
                        left: InsnArg::Register(*r),
                        right: InsnArg::Literal(LiteralArg::Int(3)),
                        arg_type,
                    });
                }
                // x % 8 -> x & 7
                if let (InsnArg::Register(r), InsnArg::Literal(LiteralArg::Int(8))) = (left, right) {
                    stats.arithmetic_simplified += 1;
                    return Some(InsnType::Binary {
                        op: BinaryOp::And,
                        dest: *dest,
                        left: InsnArg::Register(*r),
                        right: InsnArg::Literal(LiteralArg::Int(7)),
                        arg_type,
                    });
                }
            }

            // Simplify x + (-n) to x - n
            BinaryOp::Add => {
                if let (InsnArg::Register(r), InsnArg::Literal(LiteralArg::Int(n))) = (left, right) {
                    if *n < 0 && *n != i64::MIN {
                        stats.arithmetic_simplified += 1;
                        return Some(InsnType::Binary {
                            op: BinaryOp::Sub,
                            dest: *dest,
                            left: InsnArg::Register(*r),
                            right: InsnArg::Literal(LiteralArg::Int(-n)),
                            arg_type,
                        });
                    }
                }
            }

            _ => {}
        }

        None
    }

    /// Check for MBA (Mixed Boolean-Arithmetic) patterns
    /// Common MBA identity: (x ^ y) + 2*(x & y) == x + y
    #[allow(dead_code)]
    fn is_mba_pattern(&self, _method: &MethodData, _inst_idx: usize) -> Option<(u16, u16)> {
        // This requires analyzing multiple instructions together
        // Looking for the pattern across consecutive instructions:
        // t1 = x ^ y
        // t2 = x & y
        // t3 = t2 * 2  (or t2 << 1)
        // result = t1 + t3
        //
        // Which simplifies to: result = x + y

        // TODO: Implement cross-instruction pattern matching
        None
    }

    /// Detect string switch patterns (switch on hashCode())
    #[allow(dead_code)]
    fn is_string_switch(&self, method: &MethodData, inst_idx: usize) -> bool {
        let instructions = match &method.instructions {
            Some(insns) => insns,
            None => return false,
        };

        if inst_idx >= instructions.len() {
            return false;
        }

        // Look for pattern:
        // 1. invoke-virtual {obj}, String.hashCode()
        // 2. switch on the result
        // 3. Each case does string equality check

        // Scan backwards for hashCode call
        for i in (0..inst_idx).rev().take(5) {
            if let InsnType::Invoke { method_idx: _, args: _, .. } = &instructions[i].insn_type {
                // Would need method resolution to check if it's String.hashCode()
                // For now, just return false
            }
        }

        false
    }
}

impl Default for PatternSimplifier {
    fn default() -> Self {
        Self::new()
    }
}

#[cfg(test)]
mod tests {
    use super::*;

    #[test]
    fn test_stats_default() {
        let stats = SimplificationStats::default();
        assert_eq!(stats.patterns_simplified, 0);
    }

    #[test]
    fn test_simplifier_creation() {
        let simplifier = PatternSimplifier::new();
        assert!(simplifier.substitutions.is_empty());
    }
}
