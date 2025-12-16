//! Deobfuscation support for dexterity
//!
//! This crate provides:
//! - Name validation (NameMapper)
//! - Rename conditions (when to deobfuscate)
//! - Alias providers (how to generate new names)
//! - Alias registry (global storage for cross-reference resolution)
//! - Mapping file parsing (ProGuard format)

pub mod name_mapper;
pub mod conditions;
pub mod alias_provider;
pub mod visitor;
pub mod registry;
pub mod mapping_parser;
pub mod signature;

pub use name_mapper::NameMapper;
pub use conditions::{
    DeobfCondition, Action, LengthCondition, ValidityCondition, CombinedCondition,
    PrintableCondition, PackageWhitelistCondition, RenameFlag, build_conditions_from_flags,
};
pub use alias_provider::{AliasProvider, DeobfAliasProvider};
pub use visitor::DeobfuscatorVisitor;
pub use registry::AliasRegistry;
pub use mapping_parser::{parse_proguard_mapping, parse_proguard_mapping_file, MappingError};
pub use signature::{arg_type_to_descriptor, method_proto_to_descriptor};
