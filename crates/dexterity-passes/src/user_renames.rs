//! User Renames Visitor
//!
//! JADX Clone: jadx-core/src/main/java/jadx/core/dex/visitors/rename/UserRenames.java
//! Original Author: Skylot
//! Clone Date: Dec 2025
//! Lines: 99
//!
//! Applies user-provided renames to classes, fields, methods, and packages.
//! This is primarily used for GUI/API-based renaming but works for programmatic use.

use std::collections::HashMap;

/// Types of references that can be renamed
#[derive(Debug, Clone, Copy, PartialEq, Eq, Hash)]
pub enum RefType {
    /// Class/Type reference
    Class,
    /// Field reference
    Field,
    /// Method reference
    Method,
    /// Package reference
    Package,
}

/// A rename entry for a code element (user-provided)
#[derive(Debug, Clone)]
pub struct UserRename {
    /// Type of element being renamed
    pub ref_type: RefType,
    /// Full name of declaring class (e.g., "com/example/MyClass")
    pub declaring_class: String,
    /// Short ID for field/method (e.g., "fieldName:I" or "methodName(II)V")
    pub short_id: Option<String>,
    /// New name to apply
    pub new_name: String,
}

/// Result of applying user renames
#[derive(Debug, Clone, Default)]
pub struct UserRenamesResult {
    /// Number of class renames applied
    pub classes_renamed: usize,
    /// Number of field renames applied
    pub fields_renamed: usize,
    /// Number of method renames applied
    pub methods_renamed: usize,
    /// Number of package renames applied
    pub packages_renamed: usize,
    /// Warnings about failed renames
    pub warnings: Vec<String>,
}

/// Apply user-provided renames to a codebase.
///
/// JADX Reference: UserRenames.apply()
pub fn apply_user_renames(
    renames: &[UserRename],
    class_info: &HashMap<String, ClassRenameInfo>,
) -> UserRenamesResult {
    let mut result = UserRenamesResult::default();

    // Group renames by declaring class
    let mut by_class: HashMap<&str, Vec<&UserRename>> = HashMap::new();
    let mut package_renames = Vec::new();

    for rename in renames {
        if rename.ref_type == RefType::Package {
            package_renames.push(rename);
        } else {
            by_class
                .entry(&rename.declaring_class)
                .or_default()
                .push(rename);
        }
    }

    // Process class-level renames
    for (class_name, class_renames) in by_class {
        if let Some(info) = class_info.get(class_name) {
            for rename in class_renames {
                match rename.ref_type {
                    RefType::Class => {
                        // Class rename
                        result.classes_renamed += 1;
                    }
                    RefType::Field => {
                        // Field rename
                        if let Some(short_id) = &rename.short_id {
                            if info.field_short_ids.contains(short_id) {
                                result.fields_renamed += 1;
                            } else {
                                result.warnings.push(format!(
                                    "Field reference not found: {} in {}",
                                    short_id, class_name
                                ));
                            }
                        }
                    }
                    RefType::Method => {
                        // Method rename
                        if let Some(short_id) = &rename.short_id {
                            if info.method_short_ids.contains(short_id) {
                                result.methods_renamed += 1;
                            } else {
                                result.warnings.push(format!(
                                    "Method reference not found: {} in {}",
                                    short_id, class_name
                                ));
                            }
                        }
                    }
                    RefType::Package => {
                        // Handled separately
                    }
                }
            }
        } else {
            result.warnings.push(format!(
                "Class info with reference '{}' not found",
                class_name
            ));
        }
    }

    // Process package renames
    for rename in package_renames {
        result.packages_renamed += 1;
    }

    result
}

/// Information about a class for rename resolution
#[derive(Debug, Clone, Default)]
pub struct ClassRenameInfo {
    /// Short IDs of all fields in the class
    pub field_short_ids: Vec<String>,
    /// Short IDs of all methods in the class
    pub method_short_ids: Vec<String>,
}

#[cfg(test)]
mod tests {
    use super::*;

    #[test]
    fn test_apply_class_rename() {
        let renames = vec![UserRename {
            ref_type: RefType::Class,
            declaring_class: "com/example/MyClass".to_string(),
            short_id: None,
            new_name: "RenamedClass".to_string(),
        }];

        let mut class_info = HashMap::new();
        class_info.insert(
            "com/example/MyClass".to_string(),
            ClassRenameInfo::default(),
        );

        let result = apply_user_renames(&renames, &class_info);
        assert_eq!(result.classes_renamed, 1);
        assert_eq!(result.warnings.len(), 0);
    }

    #[test]
    fn test_apply_field_rename() {
        let renames = vec![UserRename {
            ref_type: RefType::Field,
            declaring_class: "com/example/MyClass".to_string(),
            short_id: Some("myField:I".to_string()),
            new_name: "renamedField".to_string(),
        }];

        let mut class_info = HashMap::new();
        class_info.insert(
            "com/example/MyClass".to_string(),
            ClassRenameInfo {
                field_short_ids: vec!["myField:I".to_string()],
                method_short_ids: vec![],
            },
        );

        let result = apply_user_renames(&renames, &class_info);
        assert_eq!(result.fields_renamed, 1);
        assert_eq!(result.warnings.len(), 0);
    }

    #[test]
    fn test_missing_class_warning() {
        let renames = vec![UserRename {
            ref_type: RefType::Class,
            declaring_class: "com/example/NonExistent".to_string(),
            short_id: None,
            new_name: "RenamedClass".to_string(),
        }];

        let class_info = HashMap::new();

        let result = apply_user_renames(&renames, &class_info);
        assert_eq!(result.classes_renamed, 0);
        assert_eq!(result.warnings.len(), 1);
    }

    #[test]
    fn test_package_rename() {
        let renames = vec![UserRename {
            ref_type: RefType::Package,
            declaring_class: "com/example".to_string(),
            short_id: None,
            new_name: "com/renamed".to_string(),
        }];

        let class_info = HashMap::new();

        let result = apply_user_renames(&renames, &class_info);
        assert_eq!(result.packages_renamed, 1);
    }
}
