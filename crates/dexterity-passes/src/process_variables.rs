//! Process Variables pass (JADX parity: ProcessVariables.java)
//!
//! This pass runs after InitCodeVariables and type inference to:
//! 1. Mark instructions with DECLARE_VAR flag where variables should be declared
//! 2. Collect CodeVars that need declaration at method/region start
//!
//! JADX Reference: ProcessVariables.java checkDeclareAtAssign() and declareVarInRegion()
//!
//! Key insight: JADX marks INSTRUCTIONS with DECLARE_VAR flag during pre-analysis,
//! then InsnGen just checks the flag. This is much simpler than runtime tracking.

use rustc_hash::FxHashMap;
use crate::ssa::SsaResult;
use dexterity_ir::attributes::AFlag;
use dexterity_ir::instructions::{InsnType, RegisterArg};
use dexterity_ir::ssa::{SSAContext, SSAVarRef, CodeVarId};
use dexterity_ir::types::ArgType;

/// Result of processing variables
#[derive(Debug, Default)]
pub struct ProcessVariablesResult {
    /// Number of instructions marked with DECLARE_VAR
    pub declared_at_assign: usize,
    /// CodeVars that need declaration at method start (can't be declared at assign)
    pub declare_at_method_start: Vec<CodeVarId>,
    /// Warnings generated during processing
    pub warnings: Vec<String>,
}

/// Process variables in the SSA result - marks instructions with DECLARE_VAR flag
///
/// This is the main entry point matching JADX ProcessVariables.process()
pub fn process_variables(ssa_result: &mut SsaResult) -> ProcessVariablesResult {
    let mut result = ProcessVariablesResult::default();

    // Build CodeVar -> first assignment instruction mapping
    // JADX: collectUsageInfo() builds usage data, then checkDeclareAtAssign() marks instructions
    let assignments = collect_assignments(ssa_result);

    // First pass: Collect which instructions to mark (avoiding borrow issues)
    let mut to_mark: Vec<AssignmentInfo> = Vec::new();

    {
        let ctx = &ssa_result.ssa_context;
        for cv in &ctx.code_vars {
            // Skip parameters - they're already declared in method signature
            if cv.is_param || cv.is_this {
                continue;
            }

            // Get all SSA vars for this CodeVar
            let ssa_vars = &cv.ssa_vars;
            if ssa_vars.is_empty() {
                continue;
            }

            // Check if we can declare at the first assignment
            // JADX: checkDeclareAtAssign() - only works if single assignment point or first assignment dominates all uses
            if let Some(first_assign) = find_first_assignment(ssa_vars, &assignments) {
                // Check if this is a valid declaration point
                // Valid if: not a PHI assignment, not in exception handler, has single definition point
                if can_declare_at_assign(&first_assign, ssa_vars, ctx, &ssa_result.blocks) {
                    to_mark.push(first_assign);
                } else {
                    // Can't declare at assign - needs declaration at method/region start
                    // IMPORTANT: Still mark first assignment to avoid undeclared variables
                    // TODO: Implement proper DeclareVariablesAttr at region start
                    to_mark.push(first_assign);
                    result.declare_at_method_start.push(cv.id);
                }
            } else {
                // No assignment found (PHI-only var?) - declare at method start
                result.declare_at_method_start.push(cv.id);
            }
        }
    }

    // Second pass: Mark instructions with DECLARE_VAR
    for assign in to_mark {
        if mark_instruction_declare_var(ssa_result, &assign) {
            result.declared_at_assign += 1;
        }
    }

    result
}

/// Assignment location info
#[derive(Debug, Clone)]
struct AssignmentInfo {
    block_id: u32,
    insn_idx: usize,
    insn_offset: u32,
    var_ref: SSAVarRef,
}

/// Collect all assignment locations for each SSA variable
fn collect_assignments(ssa_result: &SsaResult) -> FxHashMap<SSAVarRef, AssignmentInfo> {
    let mut assignments = FxHashMap::default();

    for block in &ssa_result.blocks {
        for (idx, insn) in block.instructions.iter().enumerate() {
            // Get destination register if this instruction assigns one
            if let Some(dest) = get_insn_dest(&insn.insn_type) {
                let var_ref = SSAVarRef::new(dest.reg_num, dest.ssa_version);
                assignments.insert(var_ref, AssignmentInfo {
                    block_id: block.id,
                    insn_idx: idx,
                    insn_offset: insn.offset,
                    var_ref,
                });
            }
        }
    }

    assignments
}

/// Get destination register from instruction type
fn get_insn_dest(insn_type: &InsnType) -> Option<&RegisterArg> {
    match insn_type {
        InsnType::Const { dest, .. }
        | InsnType::ConstString { dest, .. }
        | InsnType::ConstClass { dest, .. }
        | InsnType::Move { dest, .. }
        | InsnType::MoveResult { dest }
        | InsnType::MoveException { dest }
        | InsnType::NewInstance { dest, .. }
        | InsnType::NewArray { dest, .. }
        | InsnType::ArrayLength { dest, .. }
        | InsnType::Unary { dest, .. }
        | InsnType::Binary { dest, .. }
        | InsnType::InstanceGet { dest, .. }
        | InsnType::StaticGet { dest, .. }
        | InsnType::ArrayGet { dest, .. }
        | InsnType::InstanceOf { dest, .. }
        | InsnType::Cast { dest, .. }
        | InsnType::Compare { dest, .. }
        | InsnType::FilledNewArray { dest: Some(dest), .. }
        | InsnType::Invoke { dest: Some(dest), .. }
        | InsnType::Constructor { dest, .. } => Some(dest),
        _ => None,
    }
}

/// Find the first (lowest offset) assignment for any of the SSA vars in a CodeVar
fn find_first_assignment(
    ssa_vars: &[SSAVarRef],
    assignments: &FxHashMap<SSAVarRef, AssignmentInfo>,
) -> Option<AssignmentInfo> {
    let mut first: Option<AssignmentInfo> = None;

    for var_ref in ssa_vars {
        if let Some(info) = assignments.get(var_ref) {
            match &first {
                None => first = Some(info.clone()),
                Some(existing) if info.insn_offset < existing.insn_offset => {
                    first = Some(info.clone());
                }
                _ => {}
            }
        }
    }

    first
}

/// Check if we can declare a variable at its assignment point
/// JADX: checkDeclareAtAssign() logic
fn can_declare_at_assign(
    assign: &AssignmentInfo,
    ssa_vars: &[SSAVarRef],
    ctx: &SSAContext,
    blocks: &[crate::ssa::SsaBlock],
) -> bool {
    // Check if this SSA var is from a PHI node (can't declare at PHI)
    if let Some(var) = ctx.get_var(assign.var_ref) {
        if var.is_assigned_in_phi() {
            return false;
        }
    }

    // Check if there are multiple non-PHI assignments (need to declare separately)
    let non_phi_assigns: Vec<_> = ssa_vars.iter()
        .filter(|vr| {
            ctx.get_var(**vr)
                .map(|v| !v.is_assigned_in_phi())
                .unwrap_or(false)
        })
        .collect();

    // If only one non-PHI assignment, we can declare at that point
    // If multiple, we need declaration at region start
    if non_phi_assigns.len() > 1 {
        // Check if all assignments are to the same instruction offset (same source location)
        // This can happen with inlined code - still only one logical declaration point
        let first_offset = assign.insn_offset;
        let all_same_offset = non_phi_assigns.iter().all(|vr| {
            find_var_offset_in_blocks(*vr, blocks)
                .map(|off| off == first_offset)
                .unwrap_or(false)
        });

        if !all_same_offset {
            return false;
        }
    }

    true
}

/// Find the instruction offset for an SSA var's assignment (takes blocks slice)
fn find_var_offset_in_blocks(var_ref: &SSAVarRef, blocks: &[crate::ssa::SsaBlock]) -> Option<u32> {
    for block in blocks {
        for insn in &block.instructions {
            if let Some(dest) = get_insn_dest(&insn.insn_type) {
                if dest.reg_num == var_ref.reg_num && dest.ssa_version == var_ref.version {
                    return Some(insn.offset);
                }
            }
        }
    }
    None
}

/// Mark the instruction at the given location with DECLARE_VAR flag
fn mark_instruction_declare_var(ssa_result: &mut SsaResult, assign: &AssignmentInfo) -> bool {
    for block in &mut ssa_result.blocks {
        if block.id == assign.block_id {
            if let Some(insn) = block.instructions.get_mut(assign.insn_idx) {
                insn.add_flag(AFlag::DeclareVar);
                return true;
            }
        }
    }
    false
}

/// Get the name for a CodeVar (for code generation)
pub fn get_code_var_name(ctx: &SSAContext, cv_id: CodeVarId) -> String {
    if let Some(cv) = ctx.get_code_var(cv_id) {
        cv.display_name()
    } else {
        format!("var{}", cv_id)
    }
}

/// Merge information from multiple SSA vars into a CodeVar's type
pub fn merge_code_var_type(ctx: &mut SSAContext, cv_id: CodeVarId) {
    // Collect all types from SSA vars
    let types: Vec<ArgType> = {
        if let Some(cv) = ctx.get_code_var(cv_id) {
            cv.ssa_vars.iter()
                .filter_map(|vr| ctx.get_var(*vr))
                .map(|v| v.type_info.var_type.clone())
                .filter(|t| !matches!(t, ArgType::Unknown))
                .collect()
        } else {
            Vec::new()
        }
    };

    // Find the most specific type
    let merged_type = if types.is_empty() {
        ArgType::Unknown
    } else if types.len() == 1 {
        types[0].clone()
    } else {
        // Use the first non-Object type, or Object if all are Objects
        types.iter()
            .find(|t| !matches!(t, ArgType::Object(n) if n == "java/lang/Object"))
            .cloned()
            .unwrap_or_else(|| types[0].clone())
    };

    // Update the CodeVar
    if let Some(cv) = ctx.get_code_var_mut(cv_id) {
        cv.var_type = merged_type;
    }
}

#[cfg(test)]
mod tests {
    use super::*;
    use crate::ssa::SsaResult;
    use dexterity_ir::ssa::SSAContext;
    use rustc_hash::FxHashMap;

    fn make_empty_ssa_result() -> SsaResult {
        SsaResult {
            blocks: Vec::new(),
            dominators: FxHashMap::default(),
            dom_frontiers: FxHashMap::default(),
            max_versions: FxHashMap::default(),
            ssa_context: SSAContext::new(),
        }
    }

    #[test]
    fn test_get_insn_dest() {
        use dexterity_ir::instructions::{LiteralArg, RegisterArg};

        let dest = RegisterArg { reg_num: 0, ssa_version: 0 };

        // Const has dest
        let const_insn = InsnType::Const { dest: dest.clone(), value: LiteralArg::Int(42) };
        assert!(get_insn_dest(&const_insn).is_some());

        // Return has no dest
        let ret_insn = InsnType::ReturnVoid;
        assert!(get_insn_dest(&ret_insn).is_none());
    }
}
