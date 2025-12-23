//! Initialize Code Variables pass (JADX parity: InitCodeVariables.java)
//!
//! This pass runs after SSA transformation to link SSA variables to CodeVars.
//! CodeVars group multiple SSA versions that represent the same source-level variable.
//!
//! Key behaviors:
//! 1. Method arguments (this, parameters) get their own CodeVars marked as params
//! 2. PHI-connected SSA variables share the same CodeVar
//! 3. Each unique SSA variable gets a CodeVar for proper naming

use rustc_hash::FxHashSet;
use crate::ssa::{SsaResult, SsaBlock};
use dexterity_ir::ssa::{SSAContext, SSAVarRef, SSA_FLAG_METHOD_ARG, SSA_FLAG_THIS_ARG};

/// Initialize code variables from SSA result
///
/// Parameters:
/// - ssa_result: The SSA transformation result containing blocks and SSAContext
/// - this_reg: Optional register number for 'this' argument (None for static methods)
/// - param_regs: Register numbers for method parameters
pub fn init_code_variables(
    ssa_result: &mut SsaResult,
    this_reg: Option<u16>,
    param_regs: &[u16],
) {
    let ctx = &mut ssa_result.ssa_context;

    // 1. Initialize 'this' argument if present (version 0)
    if let Some(reg) = this_reg {
        let var_ref = SSAVarRef::new(reg, 0);
        init_this_var(ctx, var_ref);
    }

    // 2. Initialize method parameter registers (version 0)
    for &reg in param_regs {
        let var_ref = SSAVarRef::new(reg, 0);
        init_param_var(ctx, var_ref);
    }

    // 3. Initialize code vars for all other SSA variables
    // Get all var refs first to avoid borrow issues
    let all_refs: Vec<SSAVarRef> = ctx.vars.keys().copied().collect();

    for var_ref in all_refs {
        init_code_var(ctx, var_ref, &ssa_result.blocks);
    }
}

/// Initialize the 'this' variable
fn init_this_var(ctx: &mut SSAContext, var_ref: SSAVarRef) {
    // Check if already has code var
    if let Some(var) = ctx.get_var(var_ref) {
        if var.code_var.is_some() {
            return;
        }
    }

    // Mark as 'this' argument
    if let Some(var) = ctx.get_var_mut(var_ref) {
        var.flags |= SSA_FLAG_THIS_ARG | SSA_FLAG_METHOD_ARG;
    }

    // Create code var with special 'this' naming
    let code_var_id = ctx.new_code_var_named("this".to_string());
    if let Some(cv) = ctx.get_code_var_mut(code_var_id) {
        cv.is_this = true;
        cv.is_param = true;
    }

    ctx.link_to_code_var(var_ref, code_var_id);
}

/// Initialize a method parameter variable
fn init_param_var(ctx: &mut SSAContext, var_ref: SSAVarRef) {
    // Check if already has code var
    if let Some(var) = ctx.get_var(var_ref) {
        if var.code_var.is_some() {
            return;
        }
    }

    // Mark as method argument
    if let Some(var) = ctx.get_var_mut(var_ref) {
        var.flags |= SSA_FLAG_METHOD_ARG;
    }

    // Create code var for parameter
    let code_var_id = ctx.new_code_var();
    if let Some(cv) = ctx.get_code_var_mut(code_var_id) {
        cv.is_param = true;
    }

    ctx.link_to_code_var(var_ref, code_var_id);
}

/// Initialize code var for a regular SSA variable
/// If the variable is used in PHI nodes, collects all phi-connected vars
/// and assigns them the same CodeVar
fn init_code_var(ctx: &mut SSAContext, var_ref: SSAVarRef, blocks: &[SsaBlock]) {
    // Check if already has code var
    if let Some(var) = ctx.get_var(var_ref) {
        if var.code_var.is_some() {
            return;
        }
    }

    // Create new code var
    let code_var_id = ctx.new_code_var();

    // Check if this variable is used in any PHI
    let is_phi_connected = if let Some(var) = ctx.get_var(var_ref) {
        var.is_used_in_phi() || var.is_assigned_in_phi()
    } else {
        false
    };

    if is_phi_connected {
        // Collect all phi-connected variables and assign same CodeVar
        let connected = collect_phi_connected_vars(var_ref, blocks, ctx);

        // Check for existing code vars to merge flags from
        let mut is_param = false;
        let mut is_this = false;
        let mut name: Option<String> = None;

        for &vr in &connected {
            if let Some(var) = ctx.get_var(vr) {
                if let Some(cv_id) = var.code_var {
                    if let Some(cv) = ctx.get_code_var(cv_id) {
                        is_param |= cv.is_param;
                        is_this |= cv.is_this;
                        if name.is_none() && cv.name.is_some() {
                            name = cv.name.clone();
                        }
                    }
                }
            }
        }

        // Update code var with merged flags
        if let Some(cv) = ctx.get_code_var_mut(code_var_id) {
            cv.is_param = is_param;
            cv.is_this = is_this;
            if let Some(n) = name {
                cv.name = Some(n);
            }
        }

        // Link all connected vars to this code var
        for vr in connected {
            // Skip if already linked to a different code var
            if let Some(var) = ctx.get_var(vr) {
                if var.code_var.is_some() && var.code_var != Some(code_var_id) {
                    continue;
                }
            }
            ctx.link_to_code_var(vr, code_var_id);
        }
    } else {
        // Simple case - just link this var
        ctx.link_to_code_var(var_ref, code_var_id);
    }
}

/// Collect all SSA variables connected through PHI nodes
///
/// This follows the transitive closure through PHI definitions and uses:
/// - If a var is used in a PHI, include the PHI's result var
/// - If a var is defined by a PHI, include all the PHI's source vars
fn collect_phi_connected_vars(
    start: SSAVarRef,
    blocks: &[SsaBlock],
    ctx: &SSAContext,
) -> FxHashSet<SSAVarRef> {
    let mut connected = FxHashSet::default();
    connected.insert(start);

    // Build a map of PHI nodes for efficient lookup
    let mut phi_by_dest: FxHashSet<SSAVarRef> = FxHashSet::default();
    let mut phi_sources: Vec<(SSAVarRef, Vec<SSAVarRef>)> = Vec::new();

    for block in blocks {
        for phi in &block.phi_nodes {
            let dest_ref = SSAVarRef::new(phi.dest.reg_num, phi.dest.ssa_version);
            phi_by_dest.insert(dest_ref);

            let sources: Vec<SSAVarRef> = phi.sources.iter()
                .map(|(_, src)| SSAVarRef::new(src.reg_num, src.ssa_version))
                .collect();

            phi_sources.push((dest_ref, sources));
        }
    }

    // Iteratively expand the connected set
    let mut work_list: Vec<SSAVarRef> = vec![start];

    while let Some(current) = work_list.pop() {
        // Check if this var is the destination of a PHI
        if phi_by_dest.contains(&current) {
            // Find the PHI and add all its sources
            for (dest, sources) in &phi_sources {
                if *dest == current {
                    for src in sources {
                        if connected.insert(*src) {
                            work_list.push(*src);
                        }
                    }
                }
            }
        }

        // Check if this var is used as a source in any PHI
        for (dest, sources) in &phi_sources {
            if sources.contains(&current) {
                // Add the PHI destination
                if connected.insert(*dest) {
                    work_list.push(*dest);
                }
                // Also add other sources from same PHI
                for src in sources {
                    if connected.insert(*src) {
                        work_list.push(*src);
                    }
                }
            }
        }
    }

    connected
}

/// Re-run code variable initialization (used after certain passes)
pub fn rerun_code_variables(
    ssa_result: &mut SsaResult,
    this_reg: Option<u16>,
    param_regs: &[u16],
) {
    // Reset all SSA vars' code_var links
    for var in ssa_result.ssa_context.vars.values_mut() {
        var.reset_type_and_code_var();
    }

    // Clear existing code vars
    ssa_result.ssa_context.code_vars.clear();

    // Re-initialize
    init_code_variables(ssa_result, this_reg, param_regs);
}

#[cfg(test)]
mod tests {
    use super::*;
    use crate::ssa::SsaResult;
    use dexterity_ir::ssa::SSAContext;
    use rustc_hash::{FxHashMap, FxHashSet};

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
    fn test_this_var_initialization() {
        let mut result = make_empty_ssa_result();
        result.ssa_context.new_var_with_version(0, 0); // this in r0v0

        init_code_variables(&mut result, Some(0), &[]);

        let var = result.ssa_context.get_var(SSAVarRef::new(0, 0)).unwrap();
        assert!(var.code_var.is_some());

        let cv = result.ssa_context.get_code_var(var.code_var.unwrap()).unwrap();
        assert!(cv.is_this);
        assert!(cv.is_param);
        assert_eq!(cv.name, Some("this".to_string()));
    }

    #[test]
    fn test_param_var_initialization() {
        let mut result = make_empty_ssa_result();
        result.ssa_context.new_var_with_version(1, 0); // param in r1v0
        result.ssa_context.new_var_with_version(2, 0); // param in r2v0

        init_code_variables(&mut result, None, &[1, 2]);

        let var1 = result.ssa_context.get_var(SSAVarRef::new(1, 0)).unwrap();
        let var2 = result.ssa_context.get_var(SSAVarRef::new(2, 0)).unwrap();

        assert!(var1.code_var.is_some());
        assert!(var2.code_var.is_some());

        let cv1 = result.ssa_context.get_code_var(var1.code_var.unwrap()).unwrap();
        let cv2 = result.ssa_context.get_code_var(var2.code_var.unwrap()).unwrap();

        assert!(cv1.is_param);
        assert!(cv2.is_param);
        assert!(!cv1.is_this);
        assert!(!cv2.is_this);
    }
}
