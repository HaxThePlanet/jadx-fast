//! Java source code generator for jadx-rust
//!
//! This crate generates Java source code from the IR.
//!
//! # Main Components
//!
//! - `class_gen` - Generates complete Java class files
//! - `method_gen` - Generates method signatures and bodies
//! - `type_gen` - Converts IR types to Java type strings
//! - `access_flags` - Converts access flags to Java modifier strings
//! - `expr_gen` - Generates Java expressions from IR instructions
//! - `writer` - Code writer abstraction

pub mod access_flags;
pub mod class_gen;
pub mod expr_gen;
pub mod method_gen;
pub mod type_gen;
pub mod writer;

// Re-exports for convenience
pub use class_gen::{generate_class, ClassGenConfig};
pub use expr_gen::{ExprGen, FieldInfo, MethodInfo};
pub use type_gen::{type_to_string, escape_string};
pub use writer::{CodeWriter, SimpleCodeWriter};
