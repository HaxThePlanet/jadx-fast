//! Core decompilation algorithms
//!
//! This module contains the foundational algorithms:
//! - Dominator tree computation (Cooper-Harvey-Kennedy)
//! - Live variable analysis (iterative dataflow)

pub mod dominator_tree;
pub mod live_vars;

pub use dominator_tree::{compute_dominators, compute_dominance_frontier, DominatorInfo};
pub use live_vars::{LiveVarAnalysis, LivenessInfo};
