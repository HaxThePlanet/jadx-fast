//! Rename validation and collision handling
//!
//! JADX Reference: jadx-core/src/main/java/jadx/core/dex/visitors/rename/RenameVisitor.java
//! Cloned from JADX's RenameVisitor class for exact parity.
//!
//! This module provides validation functions to detect and fix:
//! - Duplicate field names within a class (checkFields)
//! - Method signature collisions (checkMethods)
//! - Invalid class names: anonymous patterns, leading digits (fixClsShortName)
//! - Case-insensitive path collisions for Windows filesystem (checkNames)
//! - Inner class name collision with parent (checkClassName)
//! - Default package renaming (checkPackage)
//! - Root package name collision with field names (processRootPackages)

use std::collections::{HashSet, HashMap};

use dexterity_ir::{ClassData, MethodData};

use crate::alias_provider::AliasProvider;
use crate::name_mapper::NameMapper;
use crate::consts::{ANONYMOUS_CLASS_PREFIX, DEFAULT_PACKAGE_NAME, is_anonymous_class_name, CLASS_NAME_PREFIX};

/// Constants re-exported from centralized consts module
///
/// JADX Reference: jadx-core/src/main/java/jadx/core/Consts.java
pub mod consts {
    pub use crate::consts::{ANONYMOUS_CLASS_PREFIX, DEFAULT_PACKAGE_NAME, is_anonymous_class_name, CLASS_NAME_PREFIX};
}

/// Check if an inner class name collides with any of its parent class names
///
/// JADX Reference: RenameVisitor.checkClassName() lines 101-112
///
/// In Java, inner classes must have different names than their enclosing classes
/// to avoid ambiguity. This function detects such collisions.
///
/// Example: `Foo$Foo` - inner class Foo inside outer class Foo is problematic
pub fn check_inner_class_parent_collision(class_type: &str, alias: Option<&str>) -> bool {
    // Only check inner classes (those with $ in the name)
    let internal = class_type.trim_start_matches('L').trim_end_matches(';');

    // Get the simple name (after last /)
    let simple = internal.rsplit('/').next().unwrap_or(internal);

    // Check if it's an inner class
    if !simple.contains('$') {
        return false;
    }

    // Get the name we're checking (alias or simple name)
    let check_name = if let Some(a) = alias {
        a
    } else {
        // Extract just the inner class name (after last $)
        simple.rsplit('$').next().unwrap_or(simple)
    };

    // Split by $ and check if check_name matches any parent name
    let parts: Vec<&str> = simple.split('$').collect();
    if parts.len() < 2 {
        return false;
    }

    // The last part is the inner class name, check against all parent parts
    for i in 0..parts.len() - 1 {
        if parts[i] == check_name {
            return true;
        }
    }

    false
}

/// Fix class name if it's invalid
///
/// JADX Reference: RenameVisitor.fixClsShortName() lines 131-159
/// Cloned from JADX's fixClsShortName method exactly.
///
/// Returns:
/// - Some(fixed_name) if the name was fixed
/// - None if the name couldn't be fixed (needs complete rename from deobfuscator)
///
/// JADX behavior:
/// 1. Empty name -> null (needs deobfuscation)
/// 2. Anonymous class pattern (^\d+$) -> "AnonymousClass" + cleaned name
/// 3. Leading $ or digit -> 'C' + cleaned name
/// 4. Non-printable chars -> removed
/// 5. Invalid identifier -> 'C' + name
pub fn fix_class_short_name(
    class_name: &str,
    rename_valid: bool,
    rename_printable: bool,
) -> Option<String> {
    // JADX: if (StringUtils.isEmpty(clsName)) { return null; }
    if class_name.is_empty() {
        return None;
    }

    // JADX: if (renameValid && ANONYMOUS_CLASS_PATTERN.matcher(clsName).matches())
    // Handle anonymous classes (pure digit names like "1", "2")
    if rename_valid && is_anonymous_class_name(class_name) {
        // JADX: return Consts.ANONYMOUS_CLASS_PREFIX + NameMapper.removeInvalidCharsMiddle(clsName);
        return Some(format!(
            "{}{}",
            ANONYMOUS_CLASS_PREFIX,
            NameMapper::remove_invalid_chars_middle(class_name)
        ));
    }

    // JADX: char firstChar = clsName.charAt(0);
    // JADX: if (firstChar == '$' || Character.isDigit(firstChar))
    // Handle names starting with $ or digit
    if rename_valid {
        let first_char = class_name.chars().next().unwrap();
        if first_char == '$' || first_char.is_ascii_digit() {
            // JADX: return 'C' + NameMapper.removeInvalidCharsMiddle(clsName);
            return Some(format!(
                "{}{}",
                CLASS_NAME_PREFIX,
                NameMapper::remove_invalid_chars_middle(class_name)
            ));
        }
    }

    // JADX: String cleanClsName = args.isRenamePrintable()
    //         ? NameMapper.removeNonPrintableCharacters(clsName) : clsName;
    let mut result = if rename_printable {
        NameMapper::remove_non_printable(class_name)
    } else {
        class_name.to_string()
    };

    // JADX: if (cleanClsName.isEmpty()) { return null; }
    if result.is_empty() {
        return None;
    }

    // JADX: if (renameValid) {
    //         cleanClsName = NameMapper.removeInvalidChars(clsName, "C");
    //         if (!NameMapper.isValidIdentifier(cleanClsName)) {
    //             return 'C' + cleanClsName;
    //         }
    //     }
    if rename_valid {
        result = NameMapper::remove_invalid_chars(class_name, "C");
        if !NameMapper::is_valid_identifier(&result) {
            return Some(format!("{}{}", CLASS_NAME_PREFIX, result));
        }
    }

    // JADX: return cleanClsName;
    Some(result)
}

/// Validate and fix field names within a class to ensure uniqueness
///
/// Returns the number of fields that were renamed
pub fn validate_fields<A: AliasProvider>(
    cls: &mut ClassData,
    alias_provider: &A,
    rename_valid: bool,
    rename_printable: bool,
) -> usize {
    let mut renamed_count = 0;
    let mut names_used: HashSet<String> = HashSet::new();

    // Process all fields (static and instance)
    let mut process_field = |field: &mut dexterity_ir::FieldData| {
        let field_name = field.alias.as_ref().unwrap_or(&field.name).clone();

        let mut needs_rename = false;

        // Check uniqueness
        if !names_used.insert(field_name.clone()) {
            needs_rename = true;
        }

        // Check validity
        if rename_valid && !NameMapper::is_valid_identifier(&field_name) {
            needs_rename = true;
        }

        // Check printability
        if rename_printable && !NameMapper::is_all_chars_printable(&field_name) {
            needs_rename = true;
        }

        if needs_rename && field.alias.is_none() {
            // Generate new alias using provider
            let new_alias = alias_provider.for_field(field);
            // Ensure new name is also unique
            let mut unique_alias = new_alias.clone();
            let mut counter = 2;
            while names_used.contains(&unique_alias) {
                unique_alias = format!("{}{}", new_alias, counter);
                counter += 1;
            }
            names_used.insert(unique_alias.clone());
            field.alias = Some(unique_alias);
            renamed_count += 1;
        }
    };

    for field in &mut cls.static_fields {
        process_field(field);
    }
    for field in &mut cls.instance_fields {
        process_field(field);
    }

    renamed_count
}

/// Check if a method can be renamed
///
/// JADX Reference: RenameVisitor.canRename(MethodNode mth)
/// Returns false if:
/// - Method already has an alias (DONT_RENAME equivalent)
/// - Method is a bridge method (ACC_BRIDGE flag or has related method in same class)
///
/// Bridge method detection: A bridge method is a synthetic method that delegates
/// to another method with the same name but different signature (usually due to
/// generic type erasure or covariant return types). We only skip rename if:
/// - The method has ACC_BRIDGE flag (0x40), OR
/// - There's another method with same name but DIFFERENT signature in the same class
///
/// We DO NOT skip rename for collision case (same name + same signature) because
/// that's exactly what we're trying to fix.
fn can_rename_method(method: &MethodData, all_methods: &[MethodData]) -> bool {
    use crate::signature::method_proto_to_descriptor;

    // If already has alias, don't rename
    if method.alias.is_some() {
        return false;
    }

    // Check if this is a bridge method (ACC_BRIDGE = 0x40)
    // JADX: Bridge methods have related methods in same class, renaming won't help collision
    if method.access_flags & 0x40 != 0 {
        return false;
    }

    // JADX Reference: Check if there's a related method from same class
    // (bridge method case - renaming this method will also rename the original)
    // We detect this by looking for methods with same name but DIFFERENT signature
    // Note: Same name + same signature is a collision we WANT to fix, not a bridge
    let method_name = method.alias.as_ref().unwrap_or(&method.name);
    let method_proto = method_proto_to_descriptor(&method.arg_types, &method.return_type);

    for other in all_methods {
        let other_name = other.alias.as_ref().unwrap_or(&other.name);
        if other_name == method_name {
            let other_proto = method_proto_to_descriptor(&other.arg_types, &other.return_type);
            // Same name but DIFFERENT signature = bridge method case
            // (same name + same signature is just a collision, not a bridge)
            if other_proto != method_proto {
                return false;
            }
        }
    }

    true
}

/// Validate and fix method names for signature collisions
///
/// Returns the number of methods that were renamed
pub fn validate_methods<A: AliasProvider>(
    cls: &mut ClassData,
    alias_provider: &A,
    rename_valid: bool,
    rename_printable: bool,
) -> usize {
    use crate::signature::method_proto_to_descriptor;

    let mut renamed_count = 0;

    // First pass: fix invalid/non-printable method names
    for method in &mut cls.methods {
        // Skip constructors
        if method.name == "<init>" || method.name == "<clinit>" {
            continue;
        }

        let method_name = method.alias.as_ref().unwrap_or(&method.name);

        let not_valid = rename_valid && !NameMapper::is_valid_identifier(method_name);
        let not_printable = rename_printable && !NameMapper::is_all_chars_printable(method_name);

        if (not_valid || not_printable) && method.alias.is_none() {
            let is_override = method.annotations.iter().any(|a| {
                a.annotation_type.ends_with("/Override")
            });
            method.alias = Some(alias_provider.for_method(method, is_override));
            renamed_count += 1;
        }
    }

    // Second pass: detect signature collisions
    // JADX Reference: RenameVisitor.checkMethods() lines 196-205
    if rename_valid {
        let mut signatures: HashMap<String, usize> = HashMap::new();

        // Build signature -> first index mapping
        for (i, method) in cls.methods.iter().enumerate() {
            if method.name == "<init>" || method.name == "<clinit>" {
                continue;
            }
            let name = method.alias.as_ref().unwrap_or(&method.name);
            let proto = method_proto_to_descriptor(&method.arg_types, &method.return_type);
            let signature = format!("{}{}", name, proto);
            signatures.entry(signature).or_insert(i);
        }

        // Need a copy of methods for can_rename check
        let methods_snapshot: Vec<MethodData> = cls.methods.clone();

        // Check for collisions and rename duplicates
        let mut seen_signatures: HashSet<String> = HashSet::new();
        for method in &mut cls.methods {
            if method.name == "<init>" || method.name == "<clinit>" {
                continue;
            }
            let name = method.alias.as_ref().unwrap_or(&method.name);
            let proto = method_proto_to_descriptor(&method.arg_types, &method.return_type);
            let signature = format!("{}{}", name, proto);

            // JADX Reference: RenameVisitor line 200 - check canRename before renaming
            if !seen_signatures.insert(signature.clone())
                && can_rename_method(method, &methods_snapshot)
            {
                // Collision detected - rename this method
                let is_override = method.annotations.iter().any(|a| {
                    a.annotation_type.ends_with("/Override")
                });
                method.alias = Some(alias_provider.for_method(method, is_override));
                renamed_count += 1;
            }
        }
    }

    renamed_count
}

/// Check for case-insensitive class path collisions
///
/// Returns classes that need renaming due to case collisions
pub fn find_case_collisions(classes: &[ClassData]) -> Vec<usize> {
    let mut paths_lower: HashSet<String> = HashSet::new();
    let mut collisions: Vec<usize> = Vec::new();

    for (i, cls) in classes.iter().enumerate() {
        let path = cls.alias.as_ref().unwrap_or(&cls.class_type);
        let path_lower = path.to_lowercase();
        if !paths_lower.insert(path_lower) {
            collisions.push(i);
        }
    }

    collisions
}

/// Fix case-insensitive filesystem collisions
///
/// JADX Reference: jadx-core/src/main/java/jadx/core/dex/visitors/rename/RenameVisitor.java:62-72
/// Cloned from JADX's case-insensitive handling in checkNames() exactly.
///
/// On case-insensitive filesystems (Windows, macOS default), class paths like
/// "com/example/MyClass" and "com/example/Myclass" would map to the same file.
/// This function detects and fixes such collisions by renaming conflicting classes.
///
/// JADX behavior:
/// ```java
/// if (!args.isFsCaseSensitive() && args.isRenameCaseSensitive()) {
///     Set<String> clsFullPaths = new HashSet<>(classes.size());
///     for (ClassNode cls : classes) {
///         ClassInfo clsInfo = cls.getClassInfo();
///         if (!clsFullPaths.add(clsInfo.getAliasFullPath().toLowerCase())) {
///             clsInfo.changeShortName(aliasProvider.forClass(cls));
///             cls.addAttr(new RenameReasonAttr(cls).append("case insensitive filesystem"));
///             clsFullPaths.add(clsInfo.getAliasFullPath().toLowerCase());
///         }
///     }
/// }
/// ```
///
/// # Arguments
/// * `classes` - Classes to check for collisions
/// * `alias_provider` - Provider to generate new aliases for colliding classes
/// * `fs_case_sensitive` - Whether the filesystem is case-sensitive
///
/// # Returns
/// Number of classes that were renamed
pub fn fix_case_sensitive_collisions<A: AliasProvider>(
    classes: &mut [ClassData],
    alias_provider: &A,
    fs_case_sensitive: bool,
) -> usize {
    // JADX: if (!args.isFsCaseSensitive() && args.isRenameCaseSensitive())
    // We assume isRenameCaseSensitive is true when calling this function
    if fs_case_sensitive {
        return 0;
    }

    let mut renamed_count = 0;
    // JADX: Set<String> clsFullPaths = new HashSet<>(classes.size());
    let mut paths_lower: HashSet<String> = HashSet::with_capacity(classes.len());

    for cls in classes.iter_mut() {
        // JADX: clsInfo.getAliasFullPath() - gets the full path including package alias
        let path = get_full_alias_path(cls);
        let path_lower = path.to_lowercase();

        // JADX: if (!clsFullPaths.add(clsInfo.getAliasFullPath().toLowerCase()))
        if !paths_lower.insert(path_lower.clone()) {
            // JADX: clsInfo.changeShortName(aliasProvider.forClass(cls));
            // Collision detected - rename this class
            cls.alias = Some(alias_provider.for_class(cls));
            renamed_count += 1;

            // JADX: cls.addAttr(new RenameReasonAttr(cls).append("case insensitive filesystem"));
            // Note: RenameReason tracking is stored in the conditions module's RenameReason enum

            // JADX: clsFullPaths.add(clsInfo.getAliasFullPath().toLowerCase());
            // Re-add with new path to avoid cascading collisions
            let new_path = get_full_alias_path(cls);
            paths_lower.insert(new_path.to_lowercase());
        }
    }

    renamed_count
}

/// Get the full alias path for a class (package + class name)
fn get_full_alias_path(cls: &ClassData) -> String {
    let class_type = cls.class_type.trim_start_matches('L').trim_end_matches(';');
    if let Some(ref alias) = cls.alias {
        // Replace just the class name part
        if let Some(last_slash) = class_type.rfind('/') {
            let pkg = &class_type[..last_slash];
            format!("{}/{}", pkg, alias)
        } else {
            alias.clone()
        }
    } else {
        class_type.to_string()
    }
}

/// Check if a package is the default (empty) package
///
/// JADX Reference: jadx-core/src/main/java/jadx/core/dex/visitors/rename/RenameVisitor.java:116-118
pub fn is_default_package(package: &str) -> bool {
    package.is_empty()
}

/// Get the default package name for classes in the default package
///
/// JADX Reference: jadx-core/src/main/java/jadx/core/Consts.java:DEFAULT_PACKAGE_NAME
pub fn get_default_package_name() -> &'static str {
    DEFAULT_PACKAGE_NAME
}

/// Result of checking a package for validity
#[derive(Debug, Clone, PartialEq, Eq)]
pub enum PackageCheckResult {
    /// Package is valid, no changes needed
    NoChange,
    /// Package should use DEFAULT_PACKAGE_NAME (empty package case)
    UseDefaultPackage,
    /// Package needs a new alias (invalid/non-printable)
    NeedsAlias(String),
}

/// Check if a package needs renaming
///
/// JADX Reference: RenameVisitor.checkPackage() lines 115-128
/// Cloned from JADX's checkPackage method exactly.
///
/// This function checks:
/// 1. If package is empty (default package), returns DEFAULT_PACKAGE_NAME
/// 2. If package name is not a valid identifier, returns a generated alias
/// 3. If package name contains non-printable chars, returns a generated alias
///
/// # Arguments
/// * `package_name` - The current package name (or alias if already renamed)
/// * `alias_provider` - Provider to generate a new package alias if needed
/// * `rename_valid` - Whether to check for valid identifiers
/// * `rename_printable` - Whether to check for printable characters
///
/// # Returns
/// The result indicating what action to take
pub fn check_package<A: AliasProvider>(
    package_name: &str,
    alias_provider: &A,
    rename_valid: bool,
    rename_printable: bool,
) -> PackageCheckResult {
    // JADX: if (args.isRenameValid() && pkg.getAliasPkgInfo().isDefaultPkg())
    // Check for default (empty) package
    if rename_valid && is_default_package(package_name) {
        // JADX: pkg.setFullAlias(Consts.DEFAULT_PACKAGE_NAME, false);
        return PackageCheckResult::UseDefaultPackage;
    }

    // JADX: boolean notValid = args.isRenameValid() && !NameMapper.isValidIdentifier(pkgName);
    let not_valid = rename_valid && !NameMapper::is_valid_identifier(package_name);

    // JADX: boolean notPrintable = args.isRenamePrintable() && !NameMapper.isAllCharsPrintable(pkgName);
    let not_printable = rename_printable && !NameMapper::is_all_chars_printable(package_name);

    // JADX: if (notValid || notPrintable) { pkg.setLeafAlias(aliasProvider.forPackage(pkg), false); }
    if not_valid || not_printable {
        let new_alias = alias_provider.for_package(package_name);
        return PackageCheckResult::NeedsAlias(new_alias);
    }

    PackageCheckResult::NoChange
}

/// Apply package check result to a class
///
/// This is a helper to apply the result of check_package to a class's package alias.
/// Returns true if the class's package was modified.
pub fn apply_package_check_to_class(cls: &mut ClassData, result: &PackageCheckResult) -> bool {
    match result {
        PackageCheckResult::NoChange => false,
        PackageCheckResult::UseDefaultPackage => {
            cls.pkg_alias = Some(DEFAULT_PACKAGE_NAME.to_string());
            true
        }
        PackageCheckResult::NeedsAlias(alias) => {
            cls.pkg_alias = Some(alias.clone());
            true
        }
    }
}

/// Collect all root package names (first segment of package paths)
pub fn collect_root_packages(classes: &[ClassData]) -> HashSet<String> {
    let mut root_pkgs = HashSet::new();

    for cls in classes {
        let class_type = cls.class_type.trim_start_matches('L').trim_end_matches(';');
        if let Some(pos) = class_type.find('/') {
            root_pkgs.insert(class_type[..pos].to_string());
        }
    }

    root_pkgs
}

/// Rename fields that collide with root package names
pub fn fix_root_package_collisions<A: AliasProvider>(
    classes: &mut [ClassData],
    alias_provider: &A,
) -> usize {
    let root_pkgs = collect_root_packages(classes);
    let mut renamed_count = 0;

    for cls in classes {
        for field in cls.static_fields.iter_mut().chain(cls.instance_fields.iter_mut()) {
            let field_name = field.alias.as_ref().unwrap_or(&field.name);
            if root_pkgs.contains(field_name) && field.alias.is_none() {
                field.alias = Some(alias_provider.for_field(field));
                renamed_count += 1;
            }
        }
    }

    renamed_count
}

#[cfg(test)]
mod tests {
    use super::*;
    use crate::alias_provider::DeobfAliasProvider;
    use dexterity_ir::{ArgType, FieldData, MethodData};

    #[test]
    fn test_fix_class_short_name() {
        // Anonymous class name
        let result = fix_class_short_name("123", true, false);
        assert_eq!(result, Some("AnonymousClass123".to_string()));

        // Name starting with digit
        let result = fix_class_short_name("1Foo", true, false);
        assert_eq!(result, Some("C1Foo".to_string()));

        // Name starting with $ - $ is valid in Java identifiers, but we prefix with C
        // to ensure it's not a leading $ (which could cause issues with inner class references)
        let result = fix_class_short_name("$Foo", true, false);
        assert_eq!(result, Some("C$Foo".to_string()));

        // Valid name
        let result = fix_class_short_name("MyClass", true, false);
        assert_eq!(result, Some("MyClass".to_string()));

        // Empty name
        let result = fix_class_short_name("", true, false);
        assert!(result.is_none());
    }

    #[test]
    fn test_validate_fields_uniqueness() {
        let provider = DeobfAliasProvider::new(64);
        let mut cls = ClassData::new("Lcom/Test;".to_string(), 0);

        // Add two fields with the same name
        cls.static_fields.push(FieldData::new("value".to_string(), 0, ArgType::Int));
        cls.static_fields.push(FieldData::new("value".to_string(), 0, ArgType::Long));

        let renamed = validate_fields(&mut cls, &provider, true, false);

        // One should be renamed due to collision
        assert_eq!(renamed, 1);
        assert!(cls.static_fields[1].alias.is_some());
    }

    #[test]
    fn test_validate_methods_collision() {
        let provider = DeobfAliasProvider::new(64);
        let mut cls = ClassData::new("Lcom/Test;".to_string(), 0);

        // Add two methods with the same signature
        cls.methods.push(MethodData::new("doIt".to_string(), 0, ArgType::Void));
        cls.methods.push(MethodData::new("doIt".to_string(), 0, ArgType::Void));

        let renamed = validate_methods(&mut cls, &provider, true, false);

        // One should be renamed due to collision
        assert_eq!(renamed, 1);
        assert!(cls.methods[1].alias.is_some());
    }

    #[test]
    fn test_collect_root_packages() {
        let classes = vec![
            ClassData::new("Lcom/example/Foo;".to_string(), 0),
            ClassData::new("Lorg/test/Bar;".to_string(), 0),
            ClassData::new("Lcom/other/Baz;".to_string(), 0),
        ];

        let roots = collect_root_packages(&classes);

        assert!(roots.contains("com"));
        assert!(roots.contains("org"));
        assert_eq!(roots.len(), 2);
    }

    #[test]
    fn test_inner_class_parent_collision() {
        // JADX Reference: RenameVisitor.checkClassName() lines 101-112
        // Inner class shouldn't have same name as parent

        // No collision - regular inner class
        assert!(!check_inner_class_parent_collision("Lcom/example/Outer$Inner;", None));

        // Collision - inner class same name as outer
        assert!(check_inner_class_parent_collision("Lcom/example/Foo$Foo;", None));

        // Collision - deeply nested, inner same as grandparent
        assert!(check_inner_class_parent_collision("Lcom/example/Parent$Child$Parent;", None));

        // No collision - not an inner class
        assert!(!check_inner_class_parent_collision("Lcom/example/Regular;", None));

        // Collision via alias - inner class renamed to parent's name
        assert!(check_inner_class_parent_collision("Lcom/example/Outer$Inner;", Some("Outer")));

        // No collision via alias - different name
        assert!(!check_inner_class_parent_collision("Lcom/example/Outer$Inner;", Some("Other")));
    }
}
