//! Intermediate representation types for dexterity
//!
//! This crate defines the core IR data structures used throughout the decompiler.

pub mod arena;
pub mod attributes;
pub mod builder;
pub mod class_hierarchy;
pub mod info;
pub mod instructions;
pub mod nodes;
pub mod regions;
pub mod types;
pub mod kotlin_metadata;

// Re-exports
pub use arena::ArenaId;
pub use builder::build_ir_insn;
pub use class_hierarchy::ClassHierarchy;
pub use info::{
    Annotation, AnnotationElement, AnnotationValue, AnnotationVisibility,
    BytecodeRef, ClassData, DebugInfo, ExceptionHandler, FieldData, FieldValue,
    KotlinClassInfo, LocalVar, MethodData, MethodInlineAttr, ProcessState, TryBlock, TypeParameter,
};
pub use instructions::{InsnArg, InsnNode, InsnType, LambdaHandleType, LambdaInfo, RegisterArg};
pub use types::{ArgType, TypeCompare, compare_types};
pub use kotlin_metadata::{KotlinMetadata, KOTLIN_METADATA_ANNOTATION};
