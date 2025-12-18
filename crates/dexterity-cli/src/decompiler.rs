//! Decompiler orchestration
//!
//! This module coordinates the full decompilation pipeline:
//! 1. DEX parsing (dexterity-dex)
//! 2. IR construction (dexterity-ir)
//! 3. Decompilation passes (dexterity-passes)
//! 4. Code generation (dexterity-codegen)

#![allow(dead_code)]

use dexterity_ir::regions::Region;
use dexterity_ir::MethodData;
use dexterity_passes::{
    assign_var_names, split_blocks, transform_to_ssa, infer_types, simplify_instructions,
    inline_constants, shrink_code, prepare_for_codegen, run_mod_visitor, BlockSplitResult, CFG, SsaResult,
    TypeInferenceResult, VarNamingResult, CodeShrinkResult, analyze_loop_patterns, detect_loops, LoopPatternResult,
};
use dexterity_passes::region_builder::{build_regions_with_try_catch, mark_duplicated_finally};

/// Result of decompiling a method
#[derive(Debug)]
pub struct DecompiledMethod {
    /// Basic blocks after splitting
    pub blocks: BlockSplitResult,
    /// Control flow graph
    pub cfg: CFG,
    /// SSA form
    pub ssa: SsaResult,
    /// Inferred types
    pub types: TypeInferenceResult,
    /// Variable names
    pub var_names: VarNamingResult,
    /// Region tree for structured code generation
    pub regions: Region,
    /// Code shrinking result (variable inlining decisions)
    pub shrink_result: CodeShrinkResult,
    /// Loop pattern analysis (for/foreach detection)
    pub loop_patterns: LoopPatternResult,
}

/// Decompile a method through the full pipeline
///
/// Pipeline stages:
/// 1. Block splitting - split linear instructions into basic blocks
/// 2. CFG construction - build control flow graph with dominance info
/// 3. SSA transformation - convert to SSA form with phi nodes
/// 4. Type inference - infer types for all registers (with hierarchy if available)
/// 5. Variable naming - assign meaningful names to variables
/// 6. Region reconstruction - convert CFG to structured regions (if/loop/switch)
pub fn decompile_method(
    method: &MethodData,
    hierarchy: Option<&dexterity_ir::ClassHierarchy>,
) -> Option<DecompiledMethod> {
    // Check if instructions are loaded (lazy loading support)
    let insns = method.instructions()?;
    if insns.is_empty() {
        return None;
    }

    // Stage 1: Block splitting (pass reference to avoid Vec clone)
    let blocks = split_blocks(insns);
    if blocks.blocks.is_empty() {
        return None;
    }

    // Stage 2: Build CFG
    let mut cfg = CFG::from_blocks(blocks);

    // Mark duplicated finally code before region building (JADX compatibility)
    mark_duplicated_finally(&mut cfg, &method.try_blocks);

    // Stage 3: Region reconstruction (preliminary - will be refined after SSA)
    // Build initial regions from CFG structure
    let regions = dexterity_passes::region_builder::build_regions_with_try_catch(&cfg, &method.try_blocks);

    // Take blocks from CFG after dominance analysis (avoids clone)
    let blocks = cfg.take_blocks();
    let mut ssa = transform_to_ssa(&blocks);

    // Stage 4.25: ModVisitor - array initialization fusion, dead code removal
    // Combines NEW_ARRAY + FILL_ARRAY_DATA into FILLED_NEW_ARRAY
    let _ = run_mod_visitor(&mut ssa);

    // Stage 4.5: Constant inlining (before type inference for better results)
    let _ = inline_constants(&mut ssa);

    // Stage 5: Type inference (use hierarchy if available for better precision)
    let types = if let Some(h) = hierarchy {
        dexterity_passes::infer_types_with_hierarchy(&ssa, h)
    } else {
        infer_types(&ssa)
    };

    // Stage 5.5: Simplify instructions (arithmetic, boolean XOR)
    // Convert types to std HashMap for simplify pass
    let type_map: std::collections::HashMap<(u16, u32), _> = types.types.iter()
        .map(|(k, v)| (*k, v.clone()))
        .collect();
    let _ = simplify_instructions(&mut ssa, Some(&type_map));

    // Stage 5.6: Code shrinking - mark single-use variables for inlining
    // This runs after simplify to work on the cleaned-up instruction stream
    let shrink_result = shrink_code(&mut ssa);

    // Stage 5.7: Final cleanup before codegen
    // Removes redundant moves, marks associative chains for parenthesis optimization
    let _ = prepare_for_codegen(&mut ssa);

    // Stage 5.8: Loop pattern analysis (for/foreach detection)
    let loops = detect_loops(&cfg);
    let loop_patterns = analyze_loop_patterns(&ssa, &loops);

    // Stage 6: Variable naming
    let first_param_reg = method.regs_count.saturating_sub(method.ins_count);
    let num_params = method.arg_types.len() as u16;
    let var_names = assign_var_names(&ssa, &types, first_param_reg, num_params);

    Some(DecompiledMethod {
        blocks,
        cfg,
        ssa,
        types,
        var_names,
        regions,
        shrink_result,
        loop_patterns,
    })
}

/// Check if a method has code that can be decompiled
pub fn method_has_code(method: &MethodData) -> bool {
    !method.get_instructions().is_empty()
}

/// Get a summary of decompilation results
pub fn decompile_summary(result: &DecompiledMethod) -> String {
    format!(
        "{} blocks, {} SSA blocks, {} types inferred ({} constraints), {} vars named",
        result.blocks.block_count(),
        result.ssa.blocks.len(),
        result.types.num_resolved,
        result.types.num_constraints,
        result.var_names.names.len(),
    )
}

#[cfg(test)]
mod tests {
    use super::*;
    use dexterity_ir::instructions::{InsnNode, InsnType, LiteralArg, RegisterArg, InsnArg};
    use dexterity_ir::ArgType;

    fn make_test_method() -> MethodData {
        let mut method = MethodData::new("test".to_string(), 0x0001, ArgType::Int);
        method.regs_count = 2;
        method.ins_count = 0;

        // Simple method: return 42
        // const v0, 42
        // return v0
        method.set_instructions(vec![
            InsnNode::new(
                InsnType::Const {
                    dest: RegisterArg::new(0),
                    value: LiteralArg::Int(42),
                },
                0,
            ),
            InsnNode::new(
                InsnType::Return {
                    value: Some(InsnArg::reg(0)),
                },
                1,
            ),
        ]);

        method
    }

    #[test]
    fn test_decompile_simple_method() {
        let method = make_test_method();
        let result = decompile_method(&method, None);

        assert!(result.is_some());
        let result = result.unwrap();

        // Should have at least one block
        assert!(result.blocks.block_count() >= 1);

        // Should have inferred types
        assert!(result.types.num_resolved > 0);
    }

    #[test]
    fn test_empty_method() {
        let method = MethodData::new("empty".to_string(), 0x0001, ArgType::Void);
        let result = decompile_method(&method, None);

        assert!(result.is_none());
    }

    #[test]
    fn test_method_with_branch() {
        let mut method = MethodData::new("branch".to_string(), 0x0001, ArgType::Int);
        method.regs_count = 2;

        // if (p0 == 0) return 1 else return 2
        // if-eqz v0, :cond_true (target = 3)
        // const v1, 2
        // return v1
        // :cond_true
        // const v1, 1
        // return v1
        method.set_instructions(vec![
            InsnNode::new(
                InsnType::If {
                    condition: dexterity_ir::instructions::IfCondition::Eq,
                    left: InsnArg::reg(0),
                    right: None,
                    target: 3,
                },
                0,
            ),
            InsnNode::new(
                InsnType::Const {
                    dest: RegisterArg::new(1),
                    value: LiteralArg::Int(2),
                },
                1,
            ),
            InsnNode::new(
                InsnType::Return {
                    value: Some(InsnArg::reg(1)),
                },
                2,
            ),
            InsnNode::new(
                InsnType::Const {
                    dest: RegisterArg::new(1),
                    value: LiteralArg::Int(1),
                },
                3,
            ),
            InsnNode::new(
                InsnType::Return {
                    value: Some(InsnArg::reg(1)),
                },
                4,
            ),
        ]);

        let result = decompile_method(&method, None);
        assert!(result.is_some());

        let result = result.unwrap();
        // Should have multiple blocks due to branching
        assert!(result.blocks.block_count() >= 2);
    }
}
