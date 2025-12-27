//! Split CodeVars by Type Compatibility (JADX parity: InitCodeVariables.collectConnectedVars)
//!
//! This pass runs AFTER type inference to split CodeVars that contain SSA variables
//! with incompatible types. This prevents type errors like `strArr = count` where
//! count is int but strArr should be String[].
//!
//! Bug fixed: P0-KOTLIN-BRANCH-TYPE-MERGE
//!
//! JADX Reference: InitCodeVariables.java runs after TypeInference, so it can check
//! type compatibility when merging phi-connected variables. Since Dexterity runs
//! init_code_variables BEFORE type inference, we need this post-inference pass to
//! fix over-merged CodeVars.

use dexterity_ir::ssa::{SSAContext, SSAVarRef, CodeVarId};
use dexterity_ir::types::ArgType;
use crate::var_naming::types_compatible_for_naming;
use crate::type_inference::TypeInferenceResult;
use crate::ssa::SsaResult;

/// Result of splitting CodeVars
#[derive(Debug, Default)]
pub struct SplitCodeVarsResult {
    /// Number of CodeVars that were split
    pub split_count: usize,
    /// Number of new CodeVars created
    pub new_code_vars: usize,
}

/// Split CodeVars containing incompatible types into separate CodeVars
///
/// This pass examines each CodeVar with multiple SSA variables and groups them
/// by type compatibility. Variables with incompatible types (e.g., int vs String[])
/// are split into separate CodeVars.
///
/// # Arguments
/// * `ssa_result` - The SSA result containing the SSAContext to modify
/// * `types` - Type inference results containing the resolved types for SSA variables
///
/// # Returns
/// Statistics about how many CodeVars were split
pub fn split_incompatible_code_vars(
    ssa_result: &mut SsaResult,
    types: &TypeInferenceResult,
) -> SplitCodeVarsResult {
    let mut result = SplitCodeVarsResult::default();
    let ctx = &mut ssa_result.ssa_context;

    // Phase 1: Collect CodeVars that need processing
    // We process CodeVars with >1 SSA var (including params with incompatible reassignments)
    // P1-TYPE-PARAM-REASSIGN: Parameters CAN be split if reassigned to incompatible types
    let code_vars_to_process: Vec<CodeVarId> = ctx.code_vars
        .iter()
        .filter(|cv| cv.ssa_vars.len() > 1 && !cv.is_this)
        .map(|cv| cv.id)
        .collect();

    // Phase 2: Check each CodeVar and split if needed
    for cv_id in code_vars_to_process {
        if needs_split(ctx, cv_id, types) {
            let new_count = split_code_var_by_type(ctx, cv_id, types);
            if new_count > 0 {
                result.split_count += 1;
                result.new_code_vars += new_count;
            }
        }
    }

    result
}

/// Check if a CodeVar contains incompatible types that need splitting
fn needs_split(
    ctx: &SSAContext,
    cv_id: CodeVarId,
    types: &TypeInferenceResult,
) -> bool {
    let cv = match ctx.get_code_var(cv_id) {
        Some(cv) => cv,
        None => return false,
    };

    if cv.ssa_vars.len() <= 1 {
        return false;
    }

    // Get types for all SSA vars in this CodeVar
    let var_types: Vec<Option<&ArgType>> = cv.ssa_vars
        .iter()
        .map(|vr| types.types.get(&(vr.reg_num, vr.version)))
        .collect();

    // Check all pairs for compatibility
    for i in 0..var_types.len() {
        for j in (i + 1)..var_types.len() {
            match (&var_types[i], &var_types[j]) {
                (Some(t1), Some(t2)) => {
                    if !types_compatible_for_naming(t1, t2) {
                        return true; // Found incompatible types - needs split
                    }
                }
                // If either type is unknown, be conservative and don't split
                _ => {}
            }
        }
    }

    false
}

/// Split a CodeVar into multiple CodeVars grouped by type compatibility
///
/// Uses a simple grouping algorithm:
/// 1. For parameters, version 0 MUST be in the first group (to preserve is_param flag)
/// 2. For each SSA var, try to find a compatible group
/// 3. If found, add to that group
/// 4. If not, create a new group
///
/// JADX Reference: When FixTypesVisitor.insertMovesForPhi() creates new SSA vars,
/// it keeps the original parameter type immutable. We mimic this by ensuring version 0
/// stays with the original CodeVar (which preserves is_param and the parameter name).
///
/// Returns the number of new CodeVars created (0 if no split needed)
fn split_code_var_by_type(
    ctx: &mut SSAContext,
    cv_id: CodeVarId,
    types: &TypeInferenceResult,
) -> usize {
    // Collect CodeVar metadata and SSA vars (clone to avoid borrow issues)
    let (ssa_vars, is_param): (Vec<SSAVarRef>, bool) = match ctx.get_code_var(cv_id) {
        Some(cv) => (cv.ssa_vars.clone(), cv.is_param),
        None => return 0,
    };

    if ssa_vars.len() <= 1 {
        return 0;
    }

    // For parameters, find version 0 and ensure it's processed first
    // This keeps version 0 in the first group, preserving is_param on the original CodeVar
    let sorted_vars: Vec<SSAVarRef> = if is_param {
        let mut vars = ssa_vars.clone();
        // Sort so version 0 comes first
        vars.sort_by_key(|v| v.version);
        vars
    } else {
        ssa_vars.clone()
    };

    // Group variables by type compatibility
    let mut groups: Vec<Vec<SSAVarRef>> = Vec::new();

    for var_ref in &sorted_vars {
        let var_type = types.types.get(&(var_ref.reg_num, var_ref.version));

        // Try to find a compatible group
        let mut found_group = false;
        for group in &mut groups {
            if let Some(first) = group.first() {
                let first_type = types.types.get(&(first.reg_num, first.version));

                let compatible = match (var_type, first_type) {
                    (Some(t1), Some(t2)) => types_compatible_for_naming(t1, t2),
                    // If one is unknown, group with it (conservative - avoid over-splitting)
                    (None, _) | (_, None) => true,
                };

                if compatible {
                    group.push(*var_ref);
                    found_group = true;
                    break;
                }
            }
        }

        if !found_group {
            // Create new group for this var
            groups.push(vec![*var_ref]);
        }
    }

    // If only one group, no split needed
    if groups.len() <= 1 {
        return 0;
    }

    // Update original CodeVar with first group
    if let Some(cv) = ctx.get_code_var_mut(cv_id) {
        cv.ssa_vars = groups[0].clone();
    }

    let mut new_count = 0;

    // Create new CodeVars for remaining groups
    for group in groups.into_iter().skip(1) {
        let new_cv_id = ctx.new_code_var();

        // Link each SSA var in the group to the new CodeVar
        for var_ref in group {
            ctx.link_to_code_var(var_ref, new_cv_id);
        }

        new_count += 1;
    }

    new_count
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

    fn make_type_result(types: Vec<((u16, u32), ArgType)>) -> TypeInferenceResult {
        TypeInferenceResult {
            types: types.into_iter().collect(),
            num_constraints: 0,
            num_type_vars: 0,
            num_resolved: 0,
        }
    }

    #[test]
    fn test_no_split_needed_single_type() {
        let mut ssa = make_empty_ssa_result();
        let ctx = &mut ssa.ssa_context;

        // Create SSA vars with compatible int types
        let v1 = ctx.new_var_with_version(0, 0);
        let v2 = ctx.new_var_with_version(0, 1);

        // Create CodeVar linking both
        let cv_id = ctx.new_code_var();
        ctx.link_to_code_var(v1, cv_id);
        ctx.link_to_code_var(v2, cv_id);

        // Both are int - compatible
        let types = make_type_result(vec![
            ((0, 0), ArgType::Int),
            ((0, 1), ArgType::Int),
        ]);

        let result = split_incompatible_code_vars(&mut ssa, &types);

        assert_eq!(result.split_count, 0);
        assert_eq!(result.new_code_vars, 0);

        // Both should still share the same CodeVar
        let cv1 = ssa.ssa_context.get_var(v1).unwrap().code_var;
        let cv2 = ssa.ssa_context.get_var(v2).unwrap().code_var;
        assert_eq!(cv1, cv2);
    }

    #[test]
    fn test_split_int_vs_string_array() {
        let mut ssa = make_empty_ssa_result();
        let ctx = &mut ssa.ssa_context;

        // Create SSA vars: count (int) and strArr (String[])
        let v1 = ctx.new_var_with_version(5, 0); // count (int)
        let v2 = ctx.new_var_with_version(5, 1); // strArr (String[])

        // Create CodeVar linking both (simulates init_code_vars over-merging)
        let cv_id = ctx.new_code_var();
        ctx.link_to_code_var(v1, cv_id);
        ctx.link_to_code_var(v2, cv_id);

        // int vs String[] - incompatible!
        let types = make_type_result(vec![
            ((5, 0), ArgType::Int),
            ((5, 1), ArgType::Array(Box::new(
                ArgType::Object("java/lang/String".to_string())
            ))),
        ]);

        let result = split_incompatible_code_vars(&mut ssa, &types);

        // Should have split the CodeVar
        assert_eq!(result.split_count, 1);
        assert_eq!(result.new_code_vars, 1);

        // Verify vars now have different CodeVars
        let cv1 = ssa.ssa_context.get_var(v1).unwrap().code_var;
        let cv2 = ssa.ssa_context.get_var(v2).unwrap().code_var;
        assert_ne!(cv1, cv2, "Variables with incompatible types should have different CodeVars");
    }

    #[test]
    fn test_three_way_split() {
        let mut ssa = make_empty_ssa_result();
        let ctx = &mut ssa.ssa_context;

        // Three vars: int, String, String[] - all incompatible with each other
        let v1 = ctx.new_var_with_version(5, 0);
        let v2 = ctx.new_var_with_version(5, 1);
        let v3 = ctx.new_var_with_version(5, 2);

        let cv_id = ctx.new_code_var();
        ctx.link_to_code_var(v1, cv_id);
        ctx.link_to_code_var(v2, cv_id);
        ctx.link_to_code_var(v3, cv_id);

        let types = make_type_result(vec![
            ((5, 0), ArgType::Int),
            ((5, 1), ArgType::Object("java/lang/String".to_string())),
            ((5, 2), ArgType::Array(Box::new(
                ArgType::Object("java/lang/String".to_string())
            ))),
        ]);

        let result = split_incompatible_code_vars(&mut ssa, &types);

        assert_eq!(result.split_count, 1);
        assert_eq!(result.new_code_vars, 2); // Split into 3 groups = 2 new CodeVars

        // All three should have different CodeVars
        let cv1 = ssa.ssa_context.get_var(v1).unwrap().code_var;
        let cv2 = ssa.ssa_context.get_var(v2).unwrap().code_var;
        let cv3 = ssa.ssa_context.get_var(v3).unwrap().code_var;
        assert_ne!(cv1, cv2);
        assert_ne!(cv2, cv3);
        assert_ne!(cv1, cv3);
    }

    #[test]
    fn test_params_split_when_incompatible() {
        // P1-TYPE-PARAM-REASSIGN: Parameters SHOULD be split when reassigned to incompatible types
        let mut ssa = make_empty_ssa_result();
        let ctx = &mut ssa.ssa_context;

        // Parameter (v1) is reassigned to incompatible type (v2)
        let v1 = ctx.new_var_with_version(1, 0); // Original param (int)
        let v2 = ctx.new_var_with_version(1, 1); // Reassigned (String)

        let cv_id = ctx.new_code_var();
        if let Some(cv) = ctx.get_code_var_mut(cv_id) {
            cv.is_param = true; // Mark as parameter
        }
        ctx.link_to_code_var(v1, cv_id);
        ctx.link_to_code_var(v2, cv_id);

        // int vs String - incompatible!
        let types = make_type_result(vec![
            ((1, 0), ArgType::Int),
            ((1, 1), ArgType::Object("java/lang/String".to_string())),
        ]);

        let result = split_incompatible_code_vars(&mut ssa, &types);

        // Params SHOULD be split when types are incompatible
        assert_eq!(result.split_count, 1);
        assert_eq!(result.new_code_vars, 1);

        // Version 0 (original param) stays with original CodeVar
        // Version 1 (reassigned) gets new CodeVar
        let cv1 = ssa.ssa_context.get_var(v1).unwrap().code_var;
        let cv2 = ssa.ssa_context.get_var(v2).unwrap().code_var;
        assert_ne!(cv1, cv2, "Parameter reassigned to incompatible type should get separate CodeVar");

        // Original CodeVar (cv_id) should still have is_param=true
        let original_cv = ssa.ssa_context.get_code_var(cv_id).unwrap();
        assert!(original_cv.is_param, "Original CodeVar should preserve is_param flag");
    }

    #[test]
    fn test_compatible_object_types() {
        let mut ssa = make_empty_ssa_result();
        let ctx = &mut ssa.ssa_context;

        // Object and specific type - compatible (due to java/lang/Object rule)
        let v1 = ctx.new_var_with_version(5, 0);
        let v2 = ctx.new_var_with_version(5, 1);

        let cv_id = ctx.new_code_var();
        ctx.link_to_code_var(v1, cv_id);
        ctx.link_to_code_var(v2, cv_id);

        let types = make_type_result(vec![
            ((5, 0), ArgType::Object("java/lang/Object".to_string())),
            ((5, 1), ArgType::Object("java/lang/String".to_string())),
        ]);

        let result = split_incompatible_code_vars(&mut ssa, &types);

        // Should NOT split - Object is compatible with any object type
        assert_eq!(result.split_count, 0);
    }

    #[test]
    fn test_unknown_types_stay_grouped() {
        let mut ssa = make_empty_ssa_result();
        let ctx = &mut ssa.ssa_context;

        // If one type is unknown, don't split (conservative)
        let v1 = ctx.new_var_with_version(5, 0);
        let v2 = ctx.new_var_with_version(5, 1);

        let cv_id = ctx.new_code_var();
        ctx.link_to_code_var(v1, cv_id);
        ctx.link_to_code_var(v2, cv_id);

        // Only v1 has a known type
        let types = make_type_result(vec![
            ((5, 0), ArgType::Int),
            // v2 has no type in the map (unknown)
        ]);

        let result = split_incompatible_code_vars(&mut ssa, &types);

        // Should NOT split when type is unknown
        assert_eq!(result.split_count, 0);
    }
}
