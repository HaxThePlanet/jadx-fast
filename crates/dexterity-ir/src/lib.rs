//! Intermediate representation types for dexterity
//!
//! This crate defines the core IR data structures used throughout the decompiler.
//!
//! ## Module Overview
//!
//! - `types` - Type system (ArgType, TypeCompare, type comparison)
//! - `instructions` - IR instruction types and arguments
//! - `info` - Class, method, field metadata
//! - `regions` - High-level control flow structures
//! - `ssa` - SSA variable infrastructure and use-def chains
//! - `attributes` - Node attribute flags (55→80% JADX parity)
//! - `class_hierarchy` - Type hierarchy for LCA queries
//! - `arena` - Arena allocation for instruction pooling

pub mod arena;
pub mod attributes;
pub mod builder;
pub mod class_hierarchy;
pub mod info;
pub mod instructions;
pub mod kotlin_metadata;
pub mod nodes;
pub mod regions;
pub mod ssa;
pub mod types;

// Re-exports
pub use arena::ArenaId;
pub use builder::build_ir_insn;
pub use class_hierarchy::ClassHierarchy;
pub use info::{
    Annotation, AnnotationElement, AnnotationValue, AnnotationVisibility, BytecodeRef, ClassData,
    DebugInfo, ExceptionHandler, FieldData, FieldValue, KotlinClassInfo, LocalVar, MethodData,
    MethodInlineAttr, ProcessState, TryBlock, TypeParameter,
};
pub use instructions::{InsnArg, InsnNode, InsnType, LambdaHandleType, LambdaInfo, RegisterArg, WrappedInsn};
pub use kotlin_metadata::{KotlinMetadata, KOTLIN_METADATA_ANNOTATION};
pub use ssa::{
    CodeVar, SSAContext, SSAVar, SSAVarRef, TypeBound, TypeInfo,
    SSA_FLAG_IMMUTABLE_TYPE, SSA_FLAG_METHOD_ARG, SSA_FLAG_PHI_ASSIGN, SSA_FLAG_THIS_ARG,
};
pub use types::{compare_types, ArgType, TypeCompare};
