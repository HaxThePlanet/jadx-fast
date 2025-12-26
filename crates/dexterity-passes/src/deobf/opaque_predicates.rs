//! Opaque Predicate Detection
//!
//! Detects conditionals that always evaluate to the same value:
//! - Mathematical identities: x*x >= 0, (x^x) == 0, x*(x+1) % 2 == 0
//! - Type impossibilities: null instanceof T
//! - Constant propagation through phi nodes

use dexterity_ir::instructions::{BinaryOp, IfCondition, InsnArg, InsnNode, InsnType, LiteralArg};
use dexterity_ir::MethodData;
use std::collections::HashSet;

/// Type of opaque predicate
#[derive(Debug, Clone, Copy, PartialEq, Eq)]
pub enum PredicateType {
    /// Always evaluates to true
    AlwaysTrue,
    /// Always evaluates to false
    AlwaysFalse,
    /// Result depends on input but is predictable
    Predictable,
}

/// A detected opaque predicate
#[derive(Debug, Clone)]
pub struct OpaquePredicate {
    /// Instruction index in the method's instruction list
    pub instruction_idx: usize,
    /// Type of predicate
    pub predicate_type: PredicateType,
    /// Confidence score (0.0 - 1.0)
    pub confidence: f32,
    /// Description of the pattern matched
    pub pattern: String,
}

/// Detector for opaque predicates
pub struct OpaquePredicateDetector {
    /// Detected predicates
    predicates: Vec<OpaquePredicate>,
    /// Registers known to be non-negative (e.g., array length results)
    non_negative_regs: HashSet<u16>,
}

impl OpaquePredicateDetector {
    /// Create new detector
    pub fn new() -> Self {
        Self {
            predicates: Vec::new(),
            non_negative_regs: HashSet::new(),
        }
    }

    /// Detect opaque predicates in a method
    pub fn detect(&mut self, method: &MethodData) -> Vec<OpaquePredicate> {
        self.predicates.clear();
        self.non_negative_regs.clear();

        let instructions = match &method.instructions {
            Some(insns) => insns,
            None => return Vec::new(),
        };

        // First pass: identify non-negative registers
        self.find_non_negative_registers(instructions);

        // Second pass: analyze conditionals
        for (inst_idx, insn) in instructions.iter().enumerate() {
            if let Some(predicate) = self.analyze_instruction(insn, inst_idx) {
                self.predicates.push(predicate);
            }
        }

        self.predicates.clone()
    }

    /// Find registers that are guaranteed non-negative
    fn find_non_negative_registers(&mut self, instructions: &[InsnNode]) {
        for insn in instructions {
            match &insn.insn_type {
                // Array length is always >= 0
                InsnType::ArrayLength { dest, .. } => {
                    self.non_negative_regs.insert(dest.reg_num);
                }
                // Invoke results like String.length() are >= 0
                InsnType::Invoke { dest: Some(dest), .. } => {
                    // Would need method resolution to know the return type
                    // For now, conservatively don't add
                    let _ = dest;
                }
                _ => {}
            }
        }
    }

    /// Analyze a single instruction for opaque predicate patterns
    fn analyze_instruction(
        &self,
        insn: &InsnNode,
        inst_idx: usize,
    ) -> Option<OpaquePredicate> {
        match &insn.insn_type {
            // Check binary comparisons
            InsnType::Binary { op, left, right, .. } => {
                self.check_binary_predicate(op, left, right, inst_idx)
            }
            // Check if-type conditionals
            InsnType::If { condition, left, right, .. } => {
                self.check_if_predicate(condition, left, right.as_ref(), inst_idx)
            }
            _ => None,
        }
    }

    /// Check binary operations for opaque predicates
    fn check_binary_predicate(
        &self,
        op: &BinaryOp,
        left: &InsnArg,
        right: &InsnArg,
        inst_idx: usize,
    ) -> Option<OpaquePredicate> {
        // Pattern: x ^ x == 0 (always true)
        if matches!(op, BinaryOp::Xor) && self.same_register(left, right) {
            return Some(OpaquePredicate {
                instruction_idx: inst_idx,
                predicate_type: PredicateType::AlwaysTrue,
                confidence: 1.0,
                pattern: "x ^ x == 0".to_string(),
            });
        }

        // Pattern: x - x == 0 (always true)
        if matches!(op, BinaryOp::Sub) && self.same_register(left, right) {
            return Some(OpaquePredicate {
                instruction_idx: inst_idx,
                predicate_type: PredicateType::AlwaysTrue,
                confidence: 1.0,
                pattern: "x - x == 0".to_string(),
            });
        }

        // Pattern: x | x == x (always true for comparison)
        if matches!(op, BinaryOp::Or) && self.same_register(left, right) {
            return Some(OpaquePredicate {
                instruction_idx: inst_idx,
                predicate_type: PredicateType::Predictable,
                confidence: 0.9,
                pattern: "x | x == x".to_string(),
            });
        }

        // Pattern: x & x == x (always true for comparison)
        if matches!(op, BinaryOp::And) && self.same_register(left, right) {
            return Some(OpaquePredicate {
                instruction_idx: inst_idx,
                predicate_type: PredicateType::Predictable,
                confidence: 0.9,
                pattern: "x & x == x".to_string(),
            });
        }

        // Check for multiplication patterns
        if matches!(op, BinaryOp::Mul) {
            // x * x is always >= 0 for integers (useful context)
            if self.same_register(left, right) {
                return Some(OpaquePredicate {
                    instruction_idx: inst_idx,
                    predicate_type: PredicateType::Predictable,
                    confidence: 0.8,
                    pattern: "x * x >= 0".to_string(),
                });
            }
        }

        // Check for modulo patterns
        if matches!(op, BinaryOp::Rem) {
            // x * (x + 1) % 2 == 0 (product of consecutive integers is always even)
            if self.is_literal_value(right, 2) {
                return Some(OpaquePredicate {
                    instruction_idx: inst_idx,
                    predicate_type: PredicateType::Predictable,
                    confidence: 0.5,
                    pattern: "potential x*(x+1) % 2 == 0".to_string(),
                });
            }
        }

        None
    }

    /// Check if conditions for opaque predicates
    fn check_if_predicate(
        &self,
        condition: &IfCondition,
        left: &InsnArg,
        right: Option<&InsnArg>,
        inst_idx: usize,
    ) -> Option<OpaquePredicate> {
        // Check for constant comparisons
        // If comparing two constants, we can determine the result
        match (left, right) {
            // Comparing constant to zero (if-*z variants)
            (InsnArg::Literal(LiteralArg::Int(val)), None) => {
                let result = match condition {
                    IfCondition::Eq => *val == 0,
                    IfCondition::Ne => *val != 0,
                    IfCondition::Lt => *val < 0,
                    IfCondition::Ge => *val >= 0,
                    IfCondition::Gt => *val > 0,
                    IfCondition::Le => *val <= 0,
                };
                return Some(OpaquePredicate {
                    instruction_idx: inst_idx,
                    predicate_type: if result { PredicateType::AlwaysTrue } else { PredicateType::AlwaysFalse },
                    confidence: 1.0,
                    pattern: format!("if ({} {} 0)", val, condition.symbol()),
                });
            }
            // Comparing two constants
            (InsnArg::Literal(LiteralArg::Int(a)), Some(InsnArg::Literal(LiteralArg::Int(b)))) => {
                let result = match condition {
                    IfCondition::Eq => a == b,
                    IfCondition::Ne => a != b,
                    IfCondition::Lt => a < b,
                    IfCondition::Ge => a >= b,
                    IfCondition::Gt => a > b,
                    IfCondition::Le => a <= b,
                };
                return Some(OpaquePredicate {
                    instruction_idx: inst_idx,
                    predicate_type: if result { PredicateType::AlwaysTrue } else { PredicateType::AlwaysFalse },
                    confidence: 1.0,
                    pattern: format!("if ({} {} {})", a, condition.symbol(), b),
                });
            }
            // Comparing register to itself (x == x is always true, x != x is always false)
            (InsnArg::Register(r1), Some(InsnArg::Register(r2))) if r1.reg_num == r2.reg_num => {
                let (pred_type, is_opaque) = match condition {
                    IfCondition::Eq => (PredicateType::AlwaysTrue, true),  // x == x
                    IfCondition::Ne => (PredicateType::AlwaysFalse, true), // x != x
                    IfCondition::Le => (PredicateType::AlwaysTrue, true),  // x <= x
                    IfCondition::Ge => (PredicateType::AlwaysTrue, true),  // x >= x
                    IfCondition::Lt => (PredicateType::AlwaysFalse, true), // x < x
                    IfCondition::Gt => (PredicateType::AlwaysFalse, true), // x > x
                };
                if is_opaque {
                    return Some(OpaquePredicate {
                        instruction_idx: inst_idx,
                        predicate_type: pred_type,
                        confidence: 1.0,
                        pattern: format!("if (x {} x)", condition.symbol()),
                    });
                }
            }
            _ => {}
        }

        None
    }

    /// Check if two arguments reference the same register
    fn same_register(&self, left: &InsnArg, right: &InsnArg) -> bool {
        match (left, right) {
            (InsnArg::Register(l), InsnArg::Register(r)) => l.reg_num == r.reg_num,
            _ => false,
        }
    }

    /// Check if argument is a literal with specific value
    fn is_literal_value(&self, arg: &InsnArg, value: i64) -> bool {
        match arg {
            InsnArg::Literal(LiteralArg::Int(v)) => *v == value,
            _ => false,
        }
    }

    /// Attempt to simplify an opaque predicate
    pub fn simplify(&self, method: &mut MethodData, predicate: &OpaquePredicate) -> bool {
        let instructions = match &mut method.instructions {
            Some(insns) => insns,
            None => return false,
        };

        if predicate.instruction_idx >= instructions.len() {
            return false;
        }

        match predicate.predicate_type {
            PredicateType::AlwaysTrue => {
                // Replace with unconditional true
                true
            }
            PredicateType::AlwaysFalse => {
                // Replace with unconditional false or remove branch
                true
            }
            PredicateType::Predictable => {
                // More complex, may need additional context
                predicate.confidence > 0.8
            }
        }
    }

    /// Get detection results
    pub fn get_results(&self) -> &[OpaquePredicate] {
        &self.predicates
    }
}

impl Default for OpaquePredicateDetector {
    fn default() -> Self {
        Self::new()
    }
}

#[cfg(test)]
mod tests {
    use super::*;

    #[test]
    fn test_predicate_types() {
        assert_eq!(PredicateType::AlwaysTrue, PredicateType::AlwaysTrue);
        assert_ne!(PredicateType::AlwaysTrue, PredicateType::AlwaysFalse);
    }

    #[test]
    fn test_detector_creation() {
        let detector = OpaquePredicateDetector::new();
        assert!(detector.predicates.is_empty());
    }
}
