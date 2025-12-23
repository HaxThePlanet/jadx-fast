//! Process Variables pass (JADX parity: ProcessVariables.java - simplified)
//!
//! This pass runs after InitCodeVariables and type inference to:
//! 1. Remove unused SSA variables (dead code elimination)
//! 2. Collect and merge CodeVars
//! 3. Determine variable declaration points
//! 4. Check for type conflicts
//!
//! This is a simplified version that doesn't require full region analysis.

use rustc_hash::FxHashMap;
use crate::ssa::SsaResult;
use dexterity_ir::ssa::{SSAContext, SSAVarRef, CodeVarId};
use dexterity_ir::types::ArgType;

/// Result of processing variables
#[derive(Debug, Default)]
pub struct ProcessVariablesResult {
    /// Number of unused variables removed
    pub removed_unused: usize,
    /// Number of type conflicts detected
    pub type_conflicts: usize,
    /// Warnings generated during processing
    pub warnings: Vec<String>,
    /// Variables that should be declared at method start
    pub declare_at_start: Vec<CodeVarId>,
}

/// Process variables in the SSA result
///
/// Parameters:
/// - ssa_result: The SSA transformation result with initialized CodeVars
pub fn process_variables(ssa_result: &mut SsaResult) -> ProcessVariablesResult {
    let mut result = ProcessVariablesResult::default();

    // 1. Remove unused variables
    result.removed_unused = remove_unused_variables(ssa_result);

    // 2. Collect and finalize code vars
    finalize_code_vars(ssa_result);

    // 3. Check for type conflicts
    result.type_conflicts = check_type_conflicts(ssa_result, &mut result.warnings);

    // 4. Determine which vars need declarations at method start
    result.declare_at_start = find_declare_at_start(ssa_result);

    result
}

/// Remove SSA variables that are never used
///
/// A variable is unused if:
/// - It has no uses (use_list is empty)
/// - It is not used in any PHI node
/// - It is not a method parameter
fn remove_unused_variables(ssa_result: &mut SsaResult) -> usize {
    let ctx = &mut ssa_result.ssa_context;
    let mut to_remove = Vec::new();

    // Find unused variables
    for (var_ref, var) in &ctx.vars {
        // Skip if used
        if !var.use_list.is_empty() {
            continue;
        }

        // Skip if used in PHI
        if var.is_used_in_phi() {
            continue;
        }

        // Skip method parameters (they may be used externally)
        if var.flags & dexterity_ir::ssa::SSA_FLAG_METHOD_ARG != 0 {
            continue;
        }

        // Mark for removal
        to_remove.push(*var_ref);
    }

    // Remove unused variables
    let count = to_remove.len();
    for var_ref in to_remove {
        ctx.remove_var(var_ref);
    }

    count
}

/// Finalize code variables by collecting all SSA vars for each CodeVar
fn finalize_code_vars(ssa_result: &mut SsaResult) {
    let ctx = &mut ssa_result.ssa_context;

    // Build a map of CodeVar -> [SSAVarRef]
    let mut code_var_to_ssa: FxHashMap<CodeVarId, Vec<SSAVarRef>> = FxHashMap::default();

    for (var_ref, var) in &ctx.vars {
        if let Some(cv_id) = var.code_var {
            code_var_to_ssa.entry(cv_id).or_default().push(*var_ref);
        }
    }

    // Update each CodeVar with its SSA vars
    for (cv_id, ssa_refs) in code_var_to_ssa {
        if let Some(cv) = ctx.get_code_var_mut(cv_id) {
            cv.ssa_vars = ssa_refs;
        }
    }

    // Determine finality for code vars
    // A var is final if it has exactly one SSA version (single assignment)
    for cv in &mut ctx.code_vars {
        if cv.ssa_vars.len() == 1 {
            // Check if the single SSA var is not from a PHI
            if let Some(var) = ctx.vars.get(&cv.ssa_vars[0]) {
                if !var.is_assigned_in_phi() {
                    cv.is_final = true;
                }
            }
        }
    }
}

/// Check for type conflicts between SSA variables in the same CodeVar
fn check_type_conflicts(ssa_result: &SsaResult, warnings: &mut Vec<String>) -> usize {
    let ctx = &ssa_result.ssa_context;
    let mut conflicts = 0;

    for cv in &ctx.code_vars {
        if cv.ssa_vars.len() < 2 {
            continue;
        }

        // Collect all known types
        let mut types: Vec<(SSAVarRef, &ArgType)> = Vec::new();

        for var_ref in &cv.ssa_vars {
            if let Some(var) = ctx.get_var(*var_ref) {
                let ty = &var.type_info.var_type;
                if !matches!(ty, ArgType::Unknown) {
                    types.push((*var_ref, ty));
                }
            }
        }

        // Check for conflicts - multiple distinct concrete types
        if types.len() > 1 {
            let first_type = types[0].1;
            for (var_ref, ty) in &types[1..] {
                if !types_compatible(first_type, ty) {
                    conflicts += 1;
                    warnings.push(format!(
                        "Type conflict in CodeVar {}: {:?} vs {:?} (var r{}v{})",
                        cv.id, first_type, ty, var_ref.reg_num, var_ref.version
                    ));
                }
            }
        }
    }

    conflicts
}

/// Check if two types are compatible (can be unified)
fn types_compatible(a: &ArgType, b: &ArgType) -> bool {
    match (a, b) {
        // Same types are compatible
        _ if a == b => true,

        // Unknown is compatible with anything
        (ArgType::Unknown, _) | (_, ArgType::Unknown) => true,

        // Object types - check for inheritance relationship
        (ArgType::Object(a_name), ArgType::Object(b_name)) => {
            // java/lang/Object is compatible with any object
            if a_name == "java/lang/Object" || b_name == "java/lang/Object" {
                return true;
            }
            // For now, just check exact match - full hierarchy check would need class hierarchy
            a_name == b_name
        }

        // Arrays with compatible element types
        (ArgType::Array(a_elem), ArgType::Array(b_elem)) => {
            types_compatible(a_elem, b_elem)
        }

        // Primitive widening conversions
        (ArgType::Int, ArgType::Long) | (ArgType::Long, ArgType::Int) => true,
        (ArgType::Float, ArgType::Double) | (ArgType::Double, ArgType::Float) => true,
        (ArgType::Byte, ArgType::Int) | (ArgType::Int, ArgType::Byte) => true,
        (ArgType::Short, ArgType::Int) | (ArgType::Int, ArgType::Short) => true,
        (ArgType::Char, ArgType::Int) | (ArgType::Int, ArgType::Char) => true,

        _ => false,
    }
}

/// Find CodeVars that need to be declared at method start
///
/// These are variables that:
/// - Are not method parameters
/// - Are used before their first assignment (in some control flow path)
/// - Cannot be declared at their assignment point
fn find_declare_at_start(ssa_result: &SsaResult) -> Vec<CodeVarId> {
    let ctx = &ssa_result.ssa_context;
    let mut declare_at_start = Vec::new();

    for cv in &ctx.code_vars {
        // Skip parameters - they're already declared
        if cv.is_param {
            continue;
        }

        // Skip 'this' - it's implicit
        if cv.is_this {
            continue;
        }

        // If CodeVar has multiple SSA versions from PHI nodes,
        // we may need to declare at method start
        let has_phi_assign = cv.ssa_vars.iter().any(|vr| {
            ctx.get_var(*vr)
                .map(|v| v.is_assigned_in_phi())
                .unwrap_or(false)
        });

        if has_phi_assign && cv.ssa_vars.len() > 1 {
            // Check if all non-PHI assignments can handle declaration
            let all_have_assigns = cv.ssa_vars.iter().all(|vr| {
                ctx.get_var(*vr)
                    .and_then(|v| v.assign_insn_idx)
                    .is_some()
            });

            if !all_have_assigns {
                declare_at_start.push(cv.id);
            }
        }
    }

    declare_at_start
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
    fn test_types_compatible() {
        assert!(types_compatible(&ArgType::Int, &ArgType::Int));
        assert!(types_compatible(&ArgType::Unknown, &ArgType::Int));
        assert!(types_compatible(&ArgType::Int, &ArgType::Long));
        assert!(types_compatible(&ArgType::Object("java/lang/Object".to_string()), &ArgType::Object("java/lang/String".to_string())));
        assert!(!types_compatible(&ArgType::Int, &ArgType::Object("java/lang/String".to_string())));
    }

    #[test]
    fn test_unused_variable_removal() {
        let mut result = make_empty_ssa_result();

        // Create a variable with no uses
        let var_ref = result.ssa_context.new_var_with_version(0, 0);
        assert!(result.ssa_context.get_var(var_ref).is_some());

        // Process - should remove unused
        let stats = process_variables(&mut result);
        assert_eq!(stats.removed_unused, 1);
        assert!(result.ssa_context.get_var(var_ref).is_none());
    }

    #[test]
    fn test_used_variable_kept() {
        let mut result = make_empty_ssa_result();

        // Create a variable with a use
        let var_ref = result.ssa_context.new_var_with_version(0, 0);
        if let Some(var) = result.ssa_context.get_var_mut(var_ref) {
            var.add_use(5); // Add a use at instruction 5
        }

        // Process - should keep the variable
        let stats = process_variables(&mut result);
        assert_eq!(stats.removed_unused, 0);
        assert!(result.ssa_context.get_var(var_ref).is_some());
    }
}
