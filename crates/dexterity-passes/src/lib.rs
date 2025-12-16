//! Decompilation passes for dexterity
//!
//! This crate contains the visitor passes that transform the IR.

pub mod algorithms;
pub mod block_split;
pub mod cfg;
pub mod code_shrink;
pub mod conditionals;
pub mod const_inline;
pub mod enum_visitor;
pub mod extract_field_init;
pub mod finally_extract;
pub mod kotlin_intrinsics;
pub mod loop_analysis;
pub mod loops;
pub mod method_inline;
pub mod region_builder;
pub mod simplify;
pub mod ssa;
pub mod type_inference;
pub mod var_naming;
pub mod visitor;

// Re-exports
pub use algorithms::{compute_dominators, DominatorInfo, LiveVarAnalysis, LivenessInfo};
pub use block_split::{split_blocks, BasicBlock, BlockSplitResult};
pub use cfg::CFG;
pub use conditionals::{
    detect_conditionals, detect_ternary_assignment, find_condition_chains, is_ternary_candidate,
    merge_nested_conditions, IfInfo, MergeMode, MergedCondition, TernaryInfo,
};
pub use extract_field_init::{extract_field_init, extract_instance_field_init};
pub use finally_extract::{apply_finally_marking, extract_finally, FinallyExtractInfo, InsnsSlice};
pub use kotlin_intrinsics::process_kotlin_intrinsics;
pub use loops::{detect_loops, LoopInfo};
pub use loop_analysis::{analyze_loop_patterns, ArrayForEachPattern, ForLoopPattern, LoopPatternResult, UpperBound};
pub use method_inline::{
    analyze_method_for_inline, mark_methods_for_inline, should_skip_method,
};
pub use region_builder::{
    build_regions, detect_all_loop_edges, detect_loop_edge_insns, EdgeInsn, EdgeInsnKind,
    LoopEdgeInsns,
};
pub use ssa::{transform_to_ssa, transform_to_ssa_owned, DominatorTree, PhiNode, SsaBlock, SsaResult};
pub use type_inference::{
    infer_types, infer_types_with_context, infer_types_with_context_and_hierarchy,
    infer_types_with_hierarchy, Constraint, InferredType, TypeInference, TypeInferenceResult,
    TypeVar,
};
pub use var_naming::{assign_var_names, assign_var_names_with_lookups, FieldNameInfo, MethodNameInfo, VarNaming, VarNamingResult};
pub use simplify::{simplify_instructions, SimplifyResult};
pub use const_inline::{inline_constants, ConstInlineResult};
pub use code_shrink::{shrink_code, CodeShrinkResult, WrapTarget};
pub use enum_visitor::{
    analyze_enum_class, is_enum_synthetic_method, is_values_field,
    EnumArg, EnumClassInfo, EnumFieldInfo, EnumVisitorResult,
};

/// Pass trait for decompilation passes
pub trait Pass: Send + Sync {
    /// Name of this pass
    fn name(&self) -> &'static str;

    /// Passes that must run before this one
    fn run_after(&self) -> &[&'static str] {
        &[]
    }
}
