//! Rename Validator Pass - Orchestrates all name validation checks
//!
//! JADX Reference: jadx-core/src/main/java/jadx/core/dex/visitors/rename/RenameVisitor.java
//! Cloned from JADX's RenameVisitor.process() orchestration logic.
//!
//! This pass orchestrates the validation functions from dexterity-deobf/rename_validator.rs:
//! 1. fix_class_short_name() - Anonymous prefix, leading digits
//! 2. validate_fields() - Field collision detection within classes
//! 3. validate_methods() - Method signature collision detection
//! 4. check_inner_class_parent_collision() - Inner class name != parent class name
//! 5. fix_case_sensitive_collisions() - Windows/macOS filesystem handling
//! 6. fix_root_package_collisions() - Root package field name collision
//!
//! The validation functions already exist but were never invoked. This pass provides
//! the orchestration layer to call them in sequence after deobfuscation alias prepass.

use dexterity_ir::ClassData;
use dexterity_deobf::{
    AliasProvider,
    fix_class_short_name,
    validate_fields,
    validate_methods,
    check_inner_class_parent_collision,
    fix_case_sensitive_collisions,
    fix_root_package_collisions,
};

/// Result of applying rename validation
#[derive(Debug, Default)]
pub struct RenameValidationResult {
    /// Number of class short names fixed (anonymous, leading digit/dollar)
    pub class_names_fixed: usize,
    /// Number of inner classes renamed due to parent collision
    pub inner_class_collisions_fixed: usize,
    /// Number of fields renamed due to collision
    pub fields_renamed: usize,
    /// Number of methods renamed due to collision
    pub methods_renamed: usize,
    /// Number of classes renamed for case-insensitive filesystem
    pub case_collisions_fixed: usize,
    /// Number of fields renamed due to root package collision
    pub root_package_collisions_fixed: usize,
}

impl RenameValidationResult {
    /// Total number of renames applied
    pub fn total_renames(&self) -> usize {
        self.class_names_fixed
            + self.inner_class_collisions_fixed
            + self.fields_renamed
            + self.methods_renamed
            + self.case_collisions_fixed
            + self.root_package_collisions_fixed
    }
}

/// Apply per-class rename validation
///
/// JADX Reference: RenameVisitor.checkFields() and checkMethods()
///
/// This function is designed to be called during parallel class processing.
/// It validates and fixes field/method names within a single class.
///
/// # Arguments
/// * `cls` - The class to validate
/// * `alias_provider` - Provider to generate unique aliases when needed
/// * `rename_valid` - Whether to check for valid Java identifiers
/// * `rename_printable` - Whether to check for printable characters
///
/// # Returns
/// Number of fields + methods renamed
pub fn validate_class_names<A: AliasProvider>(
    cls: &mut ClassData,
    alias_provider: &A,
    rename_valid: bool,
    rename_printable: bool,
) -> usize {
    let mut renamed = 0;

    // Step 1: Fix class short name if needed (anonymous, leading digit)
    if cls.alias.is_none() {
        let class_type = cls.class_type.trim_start_matches('L').trim_end_matches(';');
        let short_name = class_type
            .rsplit('/')
            .next()
            .unwrap_or(class_type)
            .rsplit('$')
            .next()
            .unwrap_or(class_type);

        if let Some(fixed_name) = fix_class_short_name(short_name, rename_valid, rename_printable) {
            if fixed_name != short_name {
                cls.alias = Some(fixed_name);
                renamed += 1;
            }
        }
    }

    // Step 2: Check inner class parent collision
    if check_inner_class_parent_collision(&cls.class_type, cls.alias.as_deref()) {
        if cls.alias.is_none() {
            cls.alias = Some(alias_provider.for_class(cls));
            renamed += 1;
        }
    }

    // Step 3: Validate fields (collision detection within this class)
    renamed += validate_fields(cls, alias_provider, rename_valid, rename_printable);

    // Step 4: Validate methods (signature collision detection)
    renamed += validate_methods(cls, alias_provider, rename_valid, rename_printable);

    renamed
}

/// Apply all rename validation checks to a set of classes
///
/// JADX Reference: RenameVisitor.process() -> checkNames()
///
/// # Arguments
/// * `classes` - Mutable slice of classes to validate
/// * `alias_provider` - Provider to generate unique aliases when needed
/// * `rename_valid` - Whether to check for valid Java identifiers
/// * `rename_printable` - Whether to check for printable characters
/// * `fs_case_sensitive` - Whether the filesystem is case-sensitive (false for Windows/macOS)
///
/// # Returns
/// Statistics about how many names were fixed/renamed
pub fn apply_rename_validation<A: AliasProvider>(
    classes: &mut [ClassData],
    alias_provider: &A,
    rename_valid: bool,
    rename_printable: bool,
    fs_case_sensitive: bool,
) -> RenameValidationResult {
    let mut result = RenameValidationResult::default();

    // JADX Reference: RenameVisitor.checkNames() -> checkClassName() for each class
    // Step 1: Fix class short names (anonymous prefix, leading digits)
    for cls in classes.iter_mut() {
        // Only process if no alias already set
        if cls.alias.is_none() {
            // Extract short name from class type
            let class_type = cls.class_type.trim_start_matches('L').trim_end_matches(';');
            let short_name = class_type
                .rsplit('/')
                .next()
                .unwrap_or(class_type)
                .rsplit('$')
                .next()
                .unwrap_or(class_type);

            if let Some(fixed_name) = fix_class_short_name(short_name, rename_valid, rename_printable) {
                if fixed_name != short_name {
                    cls.alias = Some(fixed_name);
                    result.class_names_fixed += 1;
                }
            }
        }
    }

    // JADX Reference: RenameVisitor.checkClassName() lines 101-112
    // Step 2: Check inner class parent collision
    for cls in classes.iter_mut() {
        let current_alias = cls.alias.as_deref();
        if check_inner_class_parent_collision(&cls.class_type, current_alias) {
            // Inner class has same name as parent - need to rename
            if cls.alias.is_none() {
                cls.alias = Some(alias_provider.for_class(cls));
                result.inner_class_collisions_fixed += 1;
            }
        }
    }

    // JADX Reference: RenameVisitor.checkNames() -> checkFields() for each class
    // Step 3: Validate fields (collision detection within each class)
    for cls in classes.iter_mut() {
        let renamed = validate_fields(cls, alias_provider, rename_valid, rename_printable);
        result.fields_renamed += renamed;
    }

    // JADX Reference: RenameVisitor.checkNames() -> checkMethods() for each class
    // Step 4: Validate methods (signature collision detection)
    for cls in classes.iter_mut() {
        let renamed = validate_methods(cls, alias_provider, rename_valid, rename_printable);
        result.methods_renamed += renamed;
    }

    // JADX Reference: RenameVisitor.checkNames() lines 62-72
    // Step 5: Fix case-insensitive filesystem collisions (Windows/macOS)
    // This is only needed when fs_case_sensitive is false
    let case_fixed = fix_case_sensitive_collisions(classes, alias_provider, fs_case_sensitive);
    result.case_collisions_fixed = case_fixed;

    // JADX Reference: RenameVisitor.processRootPackages()
    // Step 6: Fix root package collisions (field names matching root package names)
    let root_fixed = fix_root_package_collisions(classes, alias_provider);
    result.root_package_collisions_fixed = root_fixed;

    result
}

/// Apply rename validation with default settings
///
/// Uses:
/// - rename_valid = true
/// - rename_printable = true
/// - fs_case_sensitive = true (Linux default)
pub fn apply_rename_validation_default<A: AliasProvider>(
    classes: &mut [ClassData],
    alias_provider: &A,
) -> RenameValidationResult {
    apply_rename_validation(classes, alias_provider, true, true, true)
}

#[cfg(test)]
mod tests {
    use super::*;
    use dexterity_deobf::DeobfAliasProvider;
    use dexterity_ir::{ArgType, FieldData, MethodData};

    #[test]
    fn test_apply_rename_validation_empty() {
        let provider = DeobfAliasProvider::new(64);
        let mut classes: Vec<ClassData> = vec![];

        let result = apply_rename_validation(&mut classes, &provider, true, true, true);

        assert_eq!(result.total_renames(), 0);
    }

    #[test]
    fn test_fix_anonymous_class_name() {
        let provider = DeobfAliasProvider::new(64);
        let mut classes = vec![
            ClassData::new("Lcom/example/Outer$1;".to_string(), 0),
        ];

        let result = apply_rename_validation(&mut classes, &provider, true, true, true);

        // Anonymous class "1" should become "AnonymousClass1"
        assert!(classes[0].alias.is_some());
        assert!(classes[0].alias.as_ref().unwrap().starts_with("AnonymousClass"));
        assert_eq!(result.class_names_fixed, 1);
    }

    #[test]
    fn test_fix_leading_digit_class() {
        let provider = DeobfAliasProvider::new(64);
        let mut classes = vec![
            ClassData::new("Lcom/example/123Class;".to_string(), 0),
        ];

        let result = apply_rename_validation(&mut classes, &provider, true, true, true);

        // Class starting with digit should be prefixed with C
        assert!(classes[0].alias.is_some());
        assert!(classes[0].alias.as_ref().unwrap().starts_with('C'));
        assert_eq!(result.class_names_fixed, 1);
    }

    #[test]
    fn test_field_collision_detection() {
        let provider = DeobfAliasProvider::new(64);
        let mut cls = ClassData::new("Lcom/Test;".to_string(), 0);

        // Add two fields with the same name
        cls.static_fields.push(FieldData::new("value".to_string(), 0, ArgType::Int));
        cls.static_fields.push(FieldData::new("value".to_string(), 0, ArgType::Long));

        let mut classes = vec![cls];
        let result = apply_rename_validation(&mut classes, &provider, true, true, true);

        // One field should be renamed due to collision
        assert_eq!(result.fields_renamed, 1);
    }

    #[test]
    fn test_method_collision_detection() {
        let provider = DeobfAliasProvider::new(64);
        let mut cls = ClassData::new("Lcom/Test;".to_string(), 0);

        // Add two methods with the same signature
        cls.methods.push(MethodData::new("doIt".to_string(), 0, ArgType::Void));
        cls.methods.push(MethodData::new("doIt".to_string(), 0, ArgType::Void));

        let mut classes = vec![cls];
        let result = apply_rename_validation(&mut classes, &provider, true, true, true);

        // One method should be renamed due to collision
        assert_eq!(result.methods_renamed, 1);
    }

    #[test]
    fn test_inner_class_parent_collision() {
        let provider = DeobfAliasProvider::new(64);
        let mut classes = vec![
            ClassData::new("Lcom/example/Foo$Foo;".to_string(), 0),
        ];

        let result = apply_rename_validation(&mut classes, &provider, true, true, true);

        // Inner class named same as outer should be renamed
        assert!(classes[0].alias.is_some());
        assert_eq!(result.inner_class_collisions_fixed, 1);
    }

    #[test]
    fn test_valid_class_unchanged() {
        let provider = DeobfAliasProvider::new(64);
        let mut classes = vec![
            ClassData::new("Lcom/example/MyClass;".to_string(), 0),
        ];

        let result = apply_rename_validation(&mut classes, &provider, true, true, true);

        // Valid class name should not be changed
        assert!(classes[0].alias.is_none());
        assert_eq!(result.total_renames(), 0);
    }
}
