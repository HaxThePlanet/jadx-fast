//! Kotlin-aware deobfuscation visitor

use dexterity_ir::{ClassData, FieldData, MethodData};
use dexterity_deobf::conditions::{DeobfCondition, Action};

/// A deobfuscation condition wrapper that prevents renaming of Kotlin-provided aliases
///
/// This condition wraps another condition and checks if a node (class, method, or field)
/// already has an alias provided by Kotlin metadata. If it does, renaming is skipped to
/// preserve the original Kotlin names.
///
/// Priority order:
/// 1. If Kotlin alias is present → DontRename
/// 2. Otherwise → delegate to wrapped condition
pub struct KotlinAwareCondition {
    inner: Box<dyn DeobfCondition>,
}

impl KotlinAwareCondition {
    /// Create a new Kotlin-aware condition wrapping another condition
    pub fn new(inner: Box<dyn DeobfCondition>) -> Self {
        Self { inner }
    }
}

impl DeobfCondition for KotlinAwareCondition {
    fn check_package(&self, name: &str) -> Action {
        // Packages don't have Kotlin metadata, delegate to inner condition
        self.inner.check_package(name)
    }

    fn check_class(&self, cls: &ClassData) -> Action {
        // If this class has a Kotlin-provided alias, don't rename it
        if cls.alias.is_some() {
            return Action::DontRename;
        }
        // Otherwise delegate to inner condition
        self.inner.check_class(cls)
    }

    fn check_field(&self, field: &FieldData) -> Action {
        // If this field has a Kotlin-provided alias, don't rename it
        if field.alias.is_some() {
            return Action::DontRename;
        }
        // Otherwise delegate to inner condition
        self.inner.check_field(field)
    }

    fn check_method(&self, method: &MethodData) -> Action {
        // If this method has a Kotlin-provided alias, don't rename it
        if method.alias.is_some() {
            return Action::DontRename;
        }
        // Otherwise delegate to inner condition
        self.inner.check_method(method)
    }
}

#[cfg(test)]
mod tests {
    use super::*;

    /// Mock condition that always returns ForceRename for testing
    struct MockCondition;

    impl DeobfCondition for MockCondition {
        fn check_package(&self, _name: &str) -> Action {
            Action::ForceRename
        }

        fn check_class(&self, _cls: &ClassData) -> Action {
            Action::ForceRename
        }

        fn check_field(&self, _field: &FieldData) -> Action {
            Action::ForceRename
        }

        fn check_method(&self, _method: &MethodData) -> Action {
            Action::ForceRename
        }
    }

    #[test]
    fn test_kotlin_aware_condition_structure() {
        // Test that KotlinAwareCondition can be created and has proper delegation
        let condition = KotlinAwareCondition::new(Box::new(MockCondition));

        // Verify the condition is properly instantiated
        // (We use the struct name to confirm it was created)
        let _: &dyn DeobfCondition = &condition;
    }

    #[test]
    fn test_package_check_delegates_to_inner() {
        // Packages don't have Kotlin metadata, should always delegate
        let condition = KotlinAwareCondition::new(Box::new(MockCondition));

        // Package check should return ForceRename from MockCondition
        assert_eq!(condition.check_package("com/example"), Action::ForceRename);
    }
}
