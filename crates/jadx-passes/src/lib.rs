//! Decompilation passes for jadx-rust
//!
//! This crate contains the visitor passes that transform the IR.

pub mod algorithms;
pub mod block_split;
pub mod cfg;
pub mod conditionals;
pub mod loops;
pub mod method_inline;
pub mod region_builder;
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
pub use loops::{detect_loops, LoopInfo};
pub use method_inline::{
    analyze_method_for_inline, mark_methods_for_inline, should_skip_method,
};
pub use region_builder::{
    build_regions, detect_all_loop_edges, detect_loop_edge_insns, EdgeInsn, EdgeInsnKind,
    LoopEdgeInsns,
};
pub use ssa::{transform_to_ssa, transform_to_ssa_owned, DominatorTree, PhiNode, SsaBlock, SsaResult};
pub use type_inference::{
    infer_types, infer_types_with_context, Constraint, InferredType, TypeInference,
    TypeInferenceResult, TypeVar,
};
pub use var_naming::{assign_var_names, VarNaming, VarNamingResult};

/// Pass trait for decompilation passes
pub trait Pass: Send + Sync {
    /// Name of this pass
    fn name(&self) -> &'static str;

    /// Passes that must run before this one
    fn run_after(&self) -> &[&'static str] {
        &[]
    }
}
