//! Control Flow Flattening (CFF) Detection
//!
//! Detects control flow flattening obfuscation patterns:
//! - Switch dispatcher with state variable
//! - Loop containing switch statement
//! - State transitions between cases

use dexterity_ir::instructions::{InsnArg, InsnNode, InsnType, LiteralArg};
use dexterity_ir::MethodData;
use std::collections::{HashMap, HashSet};

/// A detected state variable used in CFF
#[derive(Debug, Clone)]
pub struct StateVariable {
    /// Register holding the state
    pub register: u16,
    /// Initial value (if constant)
    pub initial_value: Option<i64>,
    /// All observed state values
    pub states: HashSet<i64>,
}

/// A detected CFF pattern
#[derive(Debug, Clone)]
pub struct CffPattern {
    /// The dispatcher instruction index (contains switch)
    pub dispatcher_idx: usize,
    /// The state variable
    pub state_var: StateVariable,
    /// State transitions: from_state -> (to_state, target_offset)
    pub transitions: HashMap<i64, Vec<(i64, u32)>>,
    /// Case target offsets
    pub case_offsets: Vec<u32>,
    /// Confidence score (0.0 - 1.0)
    pub confidence: f32,
}

impl CffPattern {
    /// Get the original CFG edges implied by this pattern
    pub fn get_original_edges(&self) -> Vec<(usize, u32)> {
        let mut edges = Vec::new();

        for (_from_state, transitions) in &self.transitions {
            for (_, target_offset) in transitions {
                edges.push((self.dispatcher_idx, *target_offset));
            }
        }

        edges
    }
}

/// Detector for control flow flattening
pub struct CffDetector {
    /// Potential state variables found
    state_candidates: Vec<StateVariable>,
    /// Detected patterns
    patterns: Vec<CffPattern>,
}

impl CffDetector {
    /// Create new detector
    pub fn new() -> Self {
        Self {
            state_candidates: Vec::new(),
            patterns: Vec::new(),
        }
    }

    /// Detect CFF patterns in a method
    pub fn detect(&mut self, method: &MethodData) -> Option<CffPattern> {
        self.state_candidates.clear();
        self.patterns.clear();

        let instructions = match &method.instructions {
            Some(insns) => insns,
            None => return None,
        };

        // Step 1: Find switch statements
        let switches = self.find_switches(instructions);
        if switches.is_empty() {
            return None;
        }

        // Step 2: For each switch, check if it's a CFF dispatcher
        for (inst_idx, switch_insn) in switches {
            if let Some(pattern) = self.analyze_switch(instructions, inst_idx, switch_insn) {
                self.patterns.push(pattern);
            }
        }

        // Return highest confidence pattern
        self.patterns.iter()
            .max_by(|a, b| a.confidence.partial_cmp(&b.confidence).unwrap())
            .cloned()
    }

    /// Find all switch statements in the method
    fn find_switches<'a>(&self, instructions: &'a [InsnNode]) -> Vec<(usize, &'a InsnNode)> {
        let mut switches = Vec::new();

        for (idx, insn) in instructions.iter().enumerate() {
            if matches!(&insn.insn_type, InsnType::PackedSwitch { .. } | InsnType::SparseSwitch { .. }) {
                switches.push((idx, insn));
            }
        }

        switches
    }

    /// Analyze a switch to determine if it's a CFF dispatcher
    fn analyze_switch(
        &mut self,
        instructions: &[InsnNode],
        inst_idx: usize,
        switch_insn: &InsnNode,
    ) -> Option<CffPattern> {
        // Extract switch info
        let (value_arg, case_offsets) = match &switch_insn.insn_type {
            InsnType::PackedSwitch { value, targets, .. } => {
                let targets_u32: Vec<u32> = targets.iter().map(|t| *t as u32).collect();
                (value, targets_u32)
            }
            InsnType::SparseSwitch { value, targets, .. } => {
                let targets_u32: Vec<u32> = targets.iter().map(|t| *t as u32).collect();
                (value, targets_u32)
            }
            _ => return None,
        };

        // Get the switch variable register
        let state_reg = match value_arg {
            InsnArg::Register(reg) => reg.reg_num,
            _ => return None,
        };

        // Check if this switch is inside a loop (back edge to this instruction or earlier)
        let has_back_edge = self.has_back_edge(instructions, inst_idx);

        // Collect all case targets
        let all_offsets = case_offsets.clone();

        // Check if cases update the state variable and loop back
        let mut state_updates = HashMap::new();
        let mut transitions: HashMap<i64, Vec<(i64, u32)>> = HashMap::new();
        let mut confidence = 0.0;

        // Look for state updates in instructions after the switch
        for (case_idx, &target_offset) in all_offsets.iter().enumerate() {
            // Find instructions at target offset
            if let Some((new_state, back_edge)) = self.find_state_update_at_offset(
                instructions, target_offset, state_reg, inst_idx
            ) {
                state_updates.insert(case_idx as i64, new_state);

                if back_edge {
                    // This case loops back to the dispatcher
                    transitions.entry(case_idx as i64)
                        .or_default()
                        .push((new_state, target_offset));
                    confidence += 0.2;
                }
            }
        }

        // CFF characteristics:
        // 1. Switch inside a loop
        // 2. Most cases update state variable
        // 3. Cases loop back to dispatcher

        if has_back_edge {
            confidence += 0.3;
        }

        let update_ratio = state_updates.len() as f32 / all_offsets.len().max(1) as f32;
        confidence += update_ratio * 0.3;

        // Minimum threshold for CFF detection
        if confidence < 0.5 {
            return None;
        }

        // Collect observed states
        let mut states: HashSet<i64> = HashSet::new();
        states.extend(0..all_offsets.len() as i64);
        states.extend(state_updates.values().cloned());

        Some(CffPattern {
            dispatcher_idx: inst_idx,
            state_var: StateVariable {
                register: state_reg,
                initial_value: None,
                states,
            },
            transitions,
            case_offsets: all_offsets,
            confidence: confidence.min(1.0),
        })
    }

    /// Check if there's a back edge to this instruction index
    fn has_back_edge(&self, instructions: &[InsnNode], target_idx: usize) -> bool {
        let target_offset = instructions.get(target_idx).map(|i| i.offset).unwrap_or(0);

        // Check if any instruction after target_idx jumps back to it
        for insn in instructions.iter().skip(target_idx + 1) {
            match &insn.insn_type {
                InsnType::Goto { target } if *target == target_offset => return true,
                InsnType::If { target, .. } if *target == target_offset => return true,
                _ => {}
            }
        }

        false
    }

    /// Find state variable update at a specific offset
    fn find_state_update_at_offset(
        &self,
        instructions: &[InsnNode],
        target_offset: u32,
        state_reg: u16,
        dispatcher_idx: usize,
    ) -> Option<(i64, bool)> {
        let dispatcher_offset = instructions.get(dispatcher_idx).map(|i| i.offset).unwrap_or(0);

        // Find instruction at target offset
        let start_idx = instructions.iter()
            .position(|i| i.offset >= target_offset)?;

        let mut new_state = None;
        let mut has_back_edge = false;

        // Scan forward from target, looking for state update and back edge
        for insn in instructions.iter().skip(start_idx).take(20) {
            match &insn.insn_type {
                // state = constant
                InsnType::Const { dest, value: LiteralArg::Int(val) } if dest.reg_num == state_reg => {
                    new_state = Some(*val);
                }
                // Jump back to dispatcher
                InsnType::Goto { target } if *target == dispatcher_offset => {
                    has_back_edge = true;
                    break;
                }
                InsnType::If { target, .. } if *target == dispatcher_offset => {
                    has_back_edge = true;
                    break;
                }
                // Stop at another switch or return
                InsnType::PackedSwitch { .. } | InsnType::SparseSwitch { .. } |
                InsnType::Return { .. } | InsnType::Throw { .. } => {
                    break;
                }
                _ => {}
            }
        }

        new_state.map(|s| (s, has_back_edge))
    }

    /// Get detection results
    pub fn get_patterns(&self) -> &[CffPattern] {
        &self.patterns
    }

    /// Check if a method appears to be CFF-obfuscated
    pub fn is_cff_obfuscated(&mut self, method: &MethodData) -> bool {
        self.detect(method).is_some()
    }
}

impl Default for CffDetector {
    fn default() -> Self {
        Self::new()
    }
}

#[cfg(test)]
mod tests {
    use super::*;

    #[test]
    fn test_state_variable() {
        let state = StateVariable {
            register: 0,
            initial_value: Some(0),
            states: [0, 1, 2].into_iter().collect(),
        };
        assert_eq!(state.states.len(), 3);
    }

    #[test]
    fn test_detector_creation() {
        let detector = CffDetector::new();
        assert!(detector.patterns.is_empty());
    }
}
