//! Deobfuscation support for dexterity
//!
//! This crate provides:
//! - Name validation (NameMapper)
//! - Rename conditions (when to deobfuscate)
//! - Alias providers (how to generate new names)
//! - Alias registry (global storage for cross-reference resolution)
//! - Mapping file parsing (ProGuard format)
//! - Source file-based class renaming
//! - JADX .jobf format support

pub mod name_mapper;
pub mod conditions;
pub mod alias_provider;
pub mod visitor;
pub mod registry;
pub mod mapping_parser;
pub mod signature;
pub mod source_file_rename;
pub mod jobf;
pub mod rename_validator;
pub mod tlds;
pub mod user_renames;
pub mod code_rename;

pub use name_mapper::NameMapper;
pub use conditions::{
    DeobfCondition, Action, LengthCondition, ValidityCondition, CombinedCondition,
    PrintableCondition, PackageWhitelistCondition, RenameFlag, build_conditions_from_flags,
    ExcludeAndroidRClass, AvoidClsAndPkgNamesCollision,
};
pub use alias_provider::{AliasProvider, DeobfAliasProvider};
pub use visitor::DeobfuscatorVisitor;
pub use registry::AliasRegistry;
pub use mapping_parser::{parse_proguard_mapping, parse_proguard_mapping_file, MappingError};
pub use signature::{arg_type_to_descriptor, method_proto_to_descriptor};
pub use source_file_rename::{
    apply_source_file_renames, UseSourceNameAsClassNameAlias, get_better_class_name,
};
pub use jobf::{JobfPresets, JobfMode, get_class_alias, get_field_alias, get_method_alias};
pub use rename_validator::{
    fix_class_short_name, validate_fields, validate_methods, find_case_collisions,
    collect_root_packages, fix_root_package_collisions,
};
pub use tlds::ExcludePackageWithTLDNames;
pub use user_renames::{UserRenames, UserRenamesBuilder};
