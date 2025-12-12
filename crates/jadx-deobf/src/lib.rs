//! Deobfuscation support for jadx-rust
//!
//! This crate provides:
//! - Name validation (NameMapper)
//! - Rename conditions (when to deobfuscate)
//! - Alias providers (how to generate new names)
//! - Mapping file parsing (ProGuard format)

pub mod name_mapper;
pub mod conditions;
pub mod alias_provider;
pub mod visitor;

pub use name_mapper::NameMapper;
pub use conditions::{DeobfCondition, Action, LengthCondition, ValidityCondition, CombinedCondition};
pub use alias_provider::{AliasProvider, DeobfAliasProvider};
pub use visitor::DeobfuscatorVisitor;
