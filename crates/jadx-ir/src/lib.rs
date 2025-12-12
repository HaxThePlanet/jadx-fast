//! Intermediate representation types for jadx-rust
//!
//! This crate defines the core IR data structures used throughout the decompiler.

pub mod arena;
pub mod attributes;
pub mod builder;
pub mod info;
pub mod instructions;
pub mod nodes;
pub mod regions;
pub mod types;

// Re-exports
pub use arena::ArenaId;
pub use builder::build_ir_insn;
pub use info::{
    Annotation, AnnotationElement, AnnotationValue, AnnotationVisibility,
    ClassData, DebugInfo, ExceptionHandler, FieldData, FieldValue, MethodData, TryBlock,
};
pub use instructions::{InsnArg, InsnNode, InsnType, RegisterArg};
pub use types::ArgType;
