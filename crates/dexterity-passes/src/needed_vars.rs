//! Compute variables needed for output (lazy type inference optimization)
//!
//! This module implements a backward dataflow analysis to find the transitive
//! closure of variables needed from side-effect instructions. Variables that
//! aren't needed don't require type inference.

use rustc_hash::FxHashSet;
use dexterity_ir::instructions::{InsnArg, InsnType, RegisterArg};
use crate::ssa::{SsaResult, SsaBlock, PhiNode};

/// Compute the set of SSA variables that are actually needed in output.
/// Variables not in this set can skip type inference.
///
/// A variable is "needed" if:
/// 1. It's used by a side-effect instruction (Return, Throw, Invoke, Put operations)
/// 2. It's transitively used to compute a needed variable
///
/// # Returns
/// Set of (reg_num, ssa_version) pairs for needed variables
pub fn collect_needed_variables(ssa: &SsaResult) -> FxHashSet<(u16, u32)> {
    let mut needed: FxHashSet<(u16, u32)> = FxHashSet::default();
    let mut worklist: Vec<(u16, u32)> = Vec::new();

    // Build definition map: (reg, version) -> instruction that defines it
    let mut defs: rustc_hash::FxHashMap<(u16, u32), &InsnType> = rustc_hash::FxHashMap::default();

    for block in &ssa.blocks {
        for insn in &block.instructions {
            if let Some((reg, ver)) = get_dest(&insn.insn_type) {
                defs.insert((reg, ver), &insn.insn_type);
            }
        }
    }

    // Phase 1: Collect variables used by side-effect instructions
    for block in &ssa.blocks {
        for insn in &block.instructions {
            if is_side_effect(&insn.insn_type) {
                collect_uses(&insn.insn_type, &mut needed, &mut worklist);
            }
        }

        // PHI nodes: if any PHI result is referenced, we'll need all sources
        // We handle this in the transitive closure phase
    }

    // Phase 2: Transitive closure - propagate backwards through definitions
    while let Some(var) = worklist.pop() {
        // Find the instruction that defines this variable
        if let Some(insn) = defs.get(&var) {
            // Add all uses of the defining instruction to worklist
            collect_uses(insn, &mut needed, &mut worklist);
        }
    }

    // Phase 3: Handle PHI nodes - if result is needed, all sources are needed
    for block in &ssa.blocks {
        for phi in &block.phi_nodes {
            let dest = (phi.dest.reg_num, phi.dest.ssa_version);
            if needed.contains(&dest) {
                // Add all PHI sources
                for (_, src) in &phi.sources {
                    if let InsnArg::Register(reg) = src {
                        let src_var = (reg.reg_num, reg.ssa_version);
                        if needed.insert(src_var) {
                            worklist.push(src_var);
                        }
                    }
                }
            }
        }
    }

    // One more iteration to catch any new needed vars from PHI sources
    while let Some(var) = worklist.pop() {
        if let Some(insn) = defs.get(&var) {
            collect_uses(insn, &mut needed, &mut worklist);
        }
    }

    needed
}

/// Check if an instruction has side effects (must be executed)
fn is_side_effect(insn: &InsnType) -> bool {
    matches!(
        insn,
        InsnType::Return { .. }
            | InsnType::Throw { .. }
            | InsnType::Invoke { .. }
            | InsnType::InvokeCustom { .. }
            | InsnType::ArrayPut { .. }
            | InsnType::InstancePut { .. }
            | InsnType::StaticPut { .. }
            | InsnType::MonitorEnter { .. }
            | InsnType::MonitorExit { .. }
            | InsnType::FillArrayData { .. }
    )
}

/// Get the destination register of an instruction (if any)
fn get_dest(insn: &InsnType) -> Option<(u16, u32)> {
    match insn {
        InsnType::Move { dest, .. }
        | InsnType::Const { dest, .. }
        | InsnType::ConstString { dest, .. }
        | InsnType::ConstClass { dest, .. }
        | InsnType::MoveResult { dest, .. }
        | InsnType::MoveException { dest }
        | InsnType::NewInstance { dest, .. }
        | InsnType::NewArray { dest, .. }
        | InsnType::FilledNewArray { dest, .. }
        | InsnType::ArrayLength { dest, .. }
        | InsnType::ArrayGet { dest, .. }
        | InsnType::InstanceGet { dest, .. }
        | InsnType::StaticGet { dest, .. }
        | InsnType::Unary { dest, .. }
        | InsnType::Binary { dest, .. }
        | InsnType::Cast { dest, .. }
        | InsnType::Compare { dest, .. }
        | InsnType::InstanceOf { dest, .. }
        | InsnType::CheckCast { dest, .. }
        | InsnType::Ternary { dest, .. } => Some((dest.reg_num, dest.ssa_version)),

        InsnType::Invoke { dest: Some(dest), .. }
        | InsnType::InvokeCustom { dest: Some(dest), .. } => Some((dest.reg_num, dest.ssa_version)),

        _ => None,
    }
}

/// Collect all register uses from an instruction, adding new ones to worklist
fn collect_uses(insn: &InsnType, needed: &mut FxHashSet<(u16, u32)>, worklist: &mut Vec<(u16, u32)>) {
    let mut add_use = |arg: &InsnArg| {
        if let InsnArg::Register(reg) = arg {
            let var = (reg.reg_num, reg.ssa_version);
            if needed.insert(var) {
                worklist.push(var);
            }
        }
    };

    match insn {
        InsnType::Return { value: Some(v) } => add_use(v),
        InsnType::Throw { exception } => add_use(exception),
        InsnType::Move { src, .. } => add_use(src),
        InsnType::NewArray { size, .. } => add_use(size),
        InsnType::ArrayLength { array, .. } => add_use(array),
        InsnType::ArrayGet { array, index, .. } => {
            add_use(array);
            add_use(index);
        }
        InsnType::ArrayPut { array, index, value, .. } => {
            add_use(array);
            add_use(index);
            add_use(value);
        }
        InsnType::InstanceGet { object, .. } => add_use(object),
        InsnType::InstancePut { object, value, .. } => {
            add_use(object);
            add_use(value);
        }
        InsnType::StaticPut { value, .. } => add_use(value),
        InsnType::Invoke { args, .. } | InsnType::InvokeCustom { args, .. } => {
            for arg in args.iter() {
                add_use(arg);
            }
        }
        InsnType::FilledNewArray { args, .. } => {
            for arg in args.iter() {
                add_use(arg);
            }
        }
        InsnType::Unary { arg, .. } => add_use(arg),
        InsnType::Binary { left, right, .. } => {
            add_use(left);
            add_use(right);
        }
        InsnType::Cast { arg, .. } => add_use(arg),
        InsnType::Compare { left, right, .. } => {
            add_use(left);
            add_use(right);
        }
        InsnType::If { left, right, .. } => {
            add_use(left);
            if let Some(r) = right {
                add_use(r);
            }
        }
        InsnType::InstanceOf { object, .. } => add_use(object),
        InsnType::CheckCast { object, .. } => add_use(object),
        InsnType::MonitorEnter { object } | InsnType::MonitorExit { object } => add_use(object),
        InsnType::Ternary { condition, true_val, false_val, .. } => {
            add_use(condition);
            add_use(true_val);
            add_use(false_val);
        }
        InsnType::FillArrayData { array, .. } => add_use(array),
        InsnType::PackedSwitch { value, .. } | InsnType::SparseSwitch { value, .. } => add_use(value),

        // Instructions without uses
        InsnType::Return { value: None }
        | InsnType::Const { .. }
        | InsnType::ConstString { .. }
        | InsnType::ConstClass { .. }
        | InsnType::NewInstance { .. }
        | InsnType::StaticGet { .. }
        | InsnType::MoveResult { .. }
        | InsnType::MoveException { .. }
        | InsnType::Goto { .. }
        | InsnType::Nop
        | InsnType::Phi { .. } => {}
    }
}

#[cfg(test)]
mod tests {
    use super::*;
    use dexterity_ir::instructions::{InsnNode, LiteralArg};

    fn make_reg(num: u16, ver: u32) -> RegisterArg {
        RegisterArg { reg_num: num, ssa_version: ver }
    }

    fn make_reg_arg(num: u16, ver: u32) -> InsnArg {
        InsnArg::Register(make_reg(num, ver))
    }

    #[test]
    fn test_return_marks_needed() {
        let block = SsaBlock {
            id: 0,
            phi_nodes: vec![],
            instructions: vec![
                InsnNode::new(InsnType::Const {
                    dest: make_reg(0, 0),
                    value: LiteralArg::Int(42)
                }, 0),
                InsnNode::new(InsnType::Return {
                    value: Some(make_reg_arg(0, 0))
                }, 1),
            ],
            successors: vec![],
            predecessors: vec![],
        };

        let ssa = SsaResult {
            blocks: vec![block],
            dominators: Default::default(),
            dom_frontiers: Default::default(),
            max_versions: Default::default(),
            ssa_context: dexterity_ir::ssa::SSAContext::new(),
        };

        let needed = collect_needed_variables(&ssa);
        assert!(needed.contains(&(0, 0)), "Returned variable should be needed");
    }

    #[test]
    fn test_unused_var_not_needed() {
        let block = SsaBlock {
            id: 0,
            phi_nodes: vec![],
            instructions: vec![
                InsnNode::new(InsnType::Const {
                    dest: make_reg(0, 0),
                    value: LiteralArg::Int(42)
                }, 0),
                InsnNode::new(InsnType::Const {
                    dest: make_reg(1, 0),
                    value: LiteralArg::Int(99)
                }, 1),
                InsnNode::new(InsnType::Return {
                    value: Some(make_reg_arg(0, 0))
                }, 2),
            ],
            successors: vec![],
            predecessors: vec![],
        };

        let ssa = SsaResult {
            blocks: vec![block],
            dominators: Default::default(),
            dom_frontiers: Default::default(),
            max_versions: Default::default(),
            ssa_context: dexterity_ir::ssa::SSAContext::new(),
        };

        let needed = collect_needed_variables(&ssa);
        assert!(needed.contains(&(0, 0)), "Returned variable should be needed");
        assert!(!needed.contains(&(1, 0)), "Unused variable should not be needed");
    }

    #[test]
    fn test_transitive_needed() {
        use dexterity_ir::instructions::BinaryOp;

        let block = SsaBlock {
            id: 0,
            phi_nodes: vec![],
            instructions: vec![
                // v0 = 1
                InsnNode::new(InsnType::Const {
                    dest: make_reg(0, 0),
                    value: LiteralArg::Int(1)
                }, 0),
                // v1 = 2
                InsnNode::new(InsnType::Const {
                    dest: make_reg(1, 0),
                    value: LiteralArg::Int(2)
                }, 1),
                // v2 = v0 + v1
                InsnNode::new(InsnType::Binary {
                    dest: make_reg(2, 0),
                    op: BinaryOp::Add,
                    left: make_reg_arg(0, 0),
                    right: make_reg_arg(1, 0),
                    arg_type: None,
                }, 2),
                // return v2
                InsnNode::new(InsnType::Return {
                    value: Some(make_reg_arg(2, 0))
                }, 3),
            ],
            successors: vec![],
            predecessors: vec![],
        };

        let ssa = SsaResult {
            blocks: vec![block],
            dominators: Default::default(),
            dom_frontiers: Default::default(),
            max_versions: Default::default(),
            ssa_context: dexterity_ir::ssa::SSAContext::new(),
        };

        let needed = collect_needed_variables(&ssa);
        assert!(needed.contains(&(0, 0)), "v0 should be transitively needed");
        assert!(needed.contains(&(1, 0)), "v1 should be transitively needed");
        assert!(needed.contains(&(2, 0)), "v2 should be needed");
    }
}
