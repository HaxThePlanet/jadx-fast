//! Non-Final Resource IDs Visitor
//!
//! JADX Clone: jadx-core/src/main/java/jadx/core/dex/visitors/gradle/NonFinalResIdsVisitor.java
//! Original Author: Skylot
//! Clone Date: Dec 2025
//! Lines: 118
//!
//! Detects usage of Android resource constants (R.id.xxx) in switch statements.
//! In Gradle library modules (AGP 5+), R class fields are non-final, which causes
//! issues with switch statements that require constant expressions.
//!
//! This visitor sets a flag when non-final R.id usage is detected, which can be
//! used to inform users about potential recompilation issues.

use dexterity_ir::regions::Region;

/// Result of non-final resource ID detection
#[derive(Debug, Clone, Default)]
pub struct NonFinalResIdsResult {
    /// True if non-final R class usage was detected in switch cases
    pub non_final_res_ids_required: bool,
    /// Number of switch statements checked
    pub switches_checked: usize,
    /// Number of R class field references found in switch cases
    pub r_class_references: usize,
}

/// Check if a class name is an Android resource class (R$xxx or R)
///
/// JADX Reference: NonFinalResIdsVisitor.isCustomResourceClass()
pub fn is_custom_resource_class(class_name: &str) -> bool {
    // Check for R$xxx pattern (inner class of R)
    if let Some(parent) = get_parent_class(class_name) {
        // Parent should be named "R" but not "android.R"
        let short_name = parent.rsplit('/').next().unwrap_or(parent);
        short_name == "R" && !parent.starts_with("android/")
    } else {
        false
    }
}

/// Check if a class is the android resource class hierarchy
///
/// JADX Reference: AndroidResourcesUtils.isResourceClass()
pub fn is_resource_class(class_name: &str) -> bool {
    // Check if this is an R class or R inner class
    let short_name = class_name.rsplit('/').next().unwrap_or(class_name);

    // R class itself
    if short_name == "R" {
        return true;
    }

    // R inner classes like R$id, R$string, R$layout, etc.
    if short_name.starts_with("R$") {
        return true;
    }

    false
}

/// Get the parent class from a nested class name
fn get_parent_class(class_name: &str) -> Option<&str> {
    class_name.rsplit_once('$').map(|(parent, _)| parent)
}

/// Detect non-final resource ID usage in a method's regions
///
/// JADX Reference: NonFinalResIdsVisitor.visitRegion() + detectSwitchOverResIds()
pub fn detect_non_final_res_ids(region: &Region) -> NonFinalResIdsResult {
    let mut result = NonFinalResIdsResult::default();
    detect_in_region(region, &mut result);
    result
}

fn detect_in_region(region: &Region, result: &mut NonFinalResIdsResult) {
    match region {
        Region::Switch { cases, .. } => {
            result.switches_checked += 1;
            // Check each case for R class field references
            for case in cases {
                for key in &case.keys {
                    // Check for enum field references (R.id.xxx becomes Enum { type_name: "R$id", field_name: "xxx" })
                    if let dexterity_ir::regions::CaseKey::Enum { type_name, .. } = key {
                        // Check if this is an R class field reference
                        if is_resource_class(type_name) && !type_name.starts_with("android/") {
                            result.r_class_references += 1;
                            result.non_final_res_ids_required = true;
                        }
                    }
                    // Also check integer cases that might reference R.id fields
                    if let dexterity_ir::regions::CaseKey::Int(_) = key {
                        // Integer switch cases are already resolved - the field_class_resolver
                        // would need to track which integers came from R.id fields
                        // This is handled at a different level in the decompiler
                    }
                }
                // Recurse into case body
                detect_in_region(&case.container, result);
            }
        }
        Region::Sequence(contents) => {
            for content in contents {
                if let dexterity_ir::regions::RegionContent::Region(sub_region) = content {
                    detect_in_region(sub_region, result);
                }
            }
        }
        Region::If {
            then_region,
            else_region,
            ..
        } => {
            detect_in_region(then_region, result);
            if let Some(else_r) = else_region {
                detect_in_region(else_r, result);
            }
        }
        Region::Loop { body, .. } => {
            detect_in_region(body, result);
        }
        Region::TryCatch {
            try_region,
            handlers,
            finally,
            ..
        } => {
            detect_in_region(try_region, result);
            for handler in handlers {
                detect_in_region(&handler.region, result);
            }
            if let Some(finally_r) = finally {
                detect_in_region(finally_r, result);
            }
        }
        Region::Synchronized { body, .. } => {
            detect_in_region(body, result);
        }
        // Leaf regions - no recursion needed
        Region::Break { .. }
        | Region::Continue { .. }
        | Region::TernaryAssignment { .. }
        | Region::TernaryReturn { .. } => {}
    }
}

#[cfg(test)]
mod tests {
    use super::*;

    #[test]
    fn test_is_custom_resource_class() {
        // Custom R class - should return true
        assert!(is_custom_resource_class("com/example/R$id"));
        assert!(is_custom_resource_class("com/example/R$string"));
        assert!(is_custom_resource_class("com/myapp/R$layout"));

        // Android framework R class - should return false
        assert!(!is_custom_resource_class("android/R$id"));
        assert!(!is_custom_resource_class("android/R$string"));

        // Non-R classes - should return false
        assert!(!is_custom_resource_class("com/example/MyClass"));
        assert!(!is_custom_resource_class("com/example/SomeClass$Inner"));
    }

    #[test]
    fn test_is_resource_class() {
        // R classes - should return true
        assert!(is_resource_class("com/example/R"));
        assert!(is_resource_class("com/example/R$id"));
        assert!(is_resource_class("android/R"));
        assert!(is_resource_class("android/R$string"));

        // Non-R classes - should return false
        assert!(!is_resource_class("com/example/MyClass"));
        assert!(!is_resource_class("com/example/Router"));
        assert!(!is_resource_class("com/example/ResourceHelper"));
    }

    #[test]
    fn test_get_parent_class() {
        assert_eq!(get_parent_class("com/example/R$id"), Some("com/example/R"));
        assert_eq!(
            get_parent_class("com/example/Outer$Inner"),
            Some("com/example/Outer")
        );
        assert_eq!(get_parent_class("com/example/Simple"), None);
    }
}
