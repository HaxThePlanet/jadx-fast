//! Decompiler orchestration
//!
//! This module coordinates the full decompilation pipeline:
//! 1. DEX parsing (jadx-dex)
//! 2. IR construction (jadx-ir)
//! 3. Decompilation passes (jadx-passes)
//! 4. Code generation (jadx-codegen)

use jadx_ir::regions::Region;
use jadx_ir::{ClassData, MethodData};
use jadx_passes::{
    assign_var_names, split_blocks, transform_to_ssa, infer_types, build_regions,
    BlockSplitResult, CFG, SsaResult, TypeInferenceResult, VarNamingResult,
};
use jadx_codegen::{
    generate_body_with_dex, generate_class_with_dex,
    dex_info::DexInfoProvider,
    class_gen::ClassGenConfig,
    writer::{CodeWriter, SimpleCodeWriter},
};

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
}

/// Decompile a method through the full pipeline
///
/// Pipeline stages:
/// 1. Block splitting - split linear instructions into basic blocks
/// 2. CFG construction - build control flow graph with dominance info
/// 3. SSA transformation - convert to SSA form with phi nodes
/// 4. Type inference - infer types for all registers
/// 5. Variable naming - assign meaningful names to variables
/// 6. Region reconstruction - convert CFG to structured regions (if/loop/switch)
pub fn decompile_method(method: &MethodData) -> Option<DecompiledMethod> {
    if method.instructions.is_empty() {
        return None;
    }

    // Clone instructions for the pipeline
    let instructions = method.instructions.clone();

    // Stage 1: Block splitting
    let blocks = split_blocks(instructions);
    if blocks.blocks.is_empty() {
        return None;
    }

    // Stage 2: Build CFG
    let cfg = CFG::from_blocks(blocks.clone());

    // Stage 3: SSA transformation
    let ssa = transform_to_ssa(&blocks);

    // Stage 4: Type inference
    let types = infer_types(&ssa);

    // Stage 5: Variable naming
    let first_param_reg = method.regs_count.saturating_sub(method.ins_count);
    let num_params = method.arg_types.len() as u16;
    let var_names = assign_var_names(&ssa, &types, first_param_reg, num_params);

    // Stage 6: Region reconstruction
    let regions = build_regions(&cfg);

    Some(DecompiledMethod {
        blocks,
        cfg,
        ssa,
        types,
        var_names,
        regions,
    })
}

/// Check if a method has code that can be decompiled
pub fn method_has_code(method: &MethodData) -> bool {
    !method.instructions.is_empty()
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

/// Generate Java source code for a method body
pub fn generate_method_code(method: &MethodData, dex_info: Option<std::sync::Arc<dyn DexInfoProvider>>) -> String {
    let mut writer = SimpleCodeWriter::new();
    generate_body_with_dex(method, dex_info, &mut writer);
    writer.finish()
}

/// Generate Java source code for a class
pub fn generate_class_code(class: &ClassData, dex_info: Option<std::sync::Arc<dyn DexInfoProvider>>) -> String {
    let config = ClassGenConfig {
        use_imports: true,
        show_debug: false,
        fallback: true,
        escape_unicode: false,
        inline_anonymous: true,
        add_debug_lines: false,
    };
    generate_class_with_dex(class, &config, dex_info)
}

/// Decompile a class and generate Java source code
pub fn decompile_class(class: &ClassData, dex_info: Option<std::sync::Arc<dyn DexInfoProvider>>) -> String {
    generate_class_code(class, dex_info)
}

#[cfg(test)]
mod tests {
    use super::*;
    use jadx_ir::instructions::{InsnNode, InsnType, LiteralArg, RegisterArg, InsnArg};
    use jadx_ir::ArgType;

    fn make_test_method() -> MethodData {
        let mut method = MethodData::new("test".to_string(), 0x0001, ArgType::Int);
        method.regs_count = 2;
        method.ins_count = 0;

        // Simple method: return 42
        // const v0, 42
        // return v0
        method.instructions = vec![
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
        ];

        method
    }

    #[test]
    fn test_decompile_simple_method() {
        let method = make_test_method();
        let result = decompile_method(&method);

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
        let result = decompile_method(&method);

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
        method.instructions = vec![
            InsnNode::new(
                InsnType::If {
                    condition: jadx_ir::instructions::IfCondition::Eq,
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
        ];

        let result = decompile_method(&method);
        assert!(result.is_some());

        let result = result.unwrap();
        // Should have multiple blocks due to branching
        assert!(result.blocks.block_count() >= 2);
    }
}
