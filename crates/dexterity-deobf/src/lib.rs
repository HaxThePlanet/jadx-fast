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
//! - Mapping export (Tiny, SRG, TSRG, ProGuard formats)
//! - Dalvik to JVM bytecode conversion utilities
//! - JADX constants (DEFAULT_PACKAGE_NAME, ANONYMOUS_CLASS_PREFIX, etc.)

pub mod consts;
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
pub mod file_type_detector;
pub mod mapping_exporter;
pub mod dalvik_to_jvm;

pub use name_mapper::NameMapper;
pub use conditions::{
    DeobfCondition, Action, LengthCondition, ValidityCondition, CombinedCondition,
    PrintableCondition, PackageWhitelistCondition, RenameFlag, build_conditions_from_flags,
    ExcludeAndroidRClass, AvoidClsAndPkgNamesCollision, BaseDeobfCondition,
    // JADX parity additions
    AlwaysRename, DeobfWhitelist, JADX_DEFAULT_WHITELIST, RenameReason,
    PredicateCondition, rename_matching_pattern, rename_shorter_than,
    // JADX DeobfLengthCondition defaults
    DEFAULT_DEOBF_MIN_LENGTH, DEFAULT_DEOBF_MAX_LENGTH,
};
pub use file_type_detector::{detect_file_extension, get_file_type_name};
pub use alias_provider::{AliasProvider, DeobfAliasProvider};
pub use visitor::DeobfuscatorVisitor;
pub use registry::AliasRegistry;
pub use mapping_parser::{parse_proguard_mapping, parse_proguard_mapping_file, MappingError};
pub use signature::{arg_type_to_descriptor, method_proto_to_descriptor};
pub use source_file_rename::{
    apply_source_file_renames, UseSourceNameAsClassNameAlias, get_better_class_name,
};
pub use jobf::{
    JobfPresets, JobfMode, get_class_alias, get_field_alias, get_method_alias,
    // JADX parity: SaveDeobfMapping visitor functions
    save_deobf_mapping, load_deobf_mapping,
};
pub use rename_validator::{
    fix_class_short_name, validate_fields, validate_methods, find_case_collisions,
    collect_root_packages, fix_root_package_collisions,
    // JADX parity additions
    fix_case_sensitive_collisions, is_default_package, get_default_package_name,
    // JADX checkPackage cloning
    check_package, PackageCheckResult, apply_package_check_to_class,
    // Inner class collision check
    check_inner_class_parent_collision,
    consts as rename_consts,
};
pub use tlds::ExcludePackageWithTLDNames;
pub use user_renames::{UserRenames, UserRenamesBuilder};
pub use code_rename::{
    CodeRenames, CodeRename, CodeRefType, CodeRenameVisitor, apply_code_renames,
};
pub use mapping_exporter::{
    MappingExporter, MappingFormat, collect_mappings,
};
pub use dalvik_to_jvm::{
    get_method_arg_lv_index, get_method_arg_lvt_index, get_method_var_lv_index,
    get_type_slot_count, dalvik_reg_to_lv_index, VarInfo, collect_method_vars,
};
pub use consts::{
    DEFAULT_PACKAGE_NAME, ANONYMOUS_CLASS_PREFIX, MTH_TOSTRING_SIGNATURE,
    OVERRIDE_ANNOTATION, CLASS_NAME_PREFIX, is_anonymous_class_name,
    java_types,
};
