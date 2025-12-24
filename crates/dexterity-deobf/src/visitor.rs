//! Deobfuscation visitor
//!
//! JADX Reference: jadx-core/src/main/java/jadx/core/deobf/DeobfuscatorVisitor.java
//! Cloned from JADX's DeobfuscatorVisitor class.
//!
//! Key behavior from JADX:
//! 1. Process packages FIRST (DeobfuscatorVisitor.process() lines 34-47)
//! 2. If any package was renamed, call root.runPackagesUpdate()
//! 3. THEN process classes

use std::collections::HashMap;
use std::sync::Arc;
use dexterity_ir::ClassData;
use crate::conditions::DeobfCondition;
use crate::alias_provider::AliasProvider;
use crate::registry::AliasRegistry;
use crate::signature::method_proto_to_descriptor;

/// Deobfuscation visitor that applies renaming to classes
pub struct DeobfuscatorVisitor<C, A>
where
    C: DeobfCondition,
    A: AliasProvider,
{
    condition: C,
    alias_provider: A,
    /// Optional registry to populate with aliases for cross-reference resolution
    registry: Option<Arc<AliasRegistry>>,
}

impl<C, A> DeobfuscatorVisitor<C, A>
where
    C: DeobfCondition,
    A: AliasProvider,
{
    pub fn new(condition: C, alias_provider: A) -> Self {
        Self {
            condition,
            alias_provider,
            registry: None,
        }
    }

    /// Set the alias registry to populate during processing
    pub fn with_registry(mut self, registry: Arc<AliasRegistry>) -> Self {
        self.registry = Some(registry);
        self
    }

    /// Process a single class, applying deobfuscation
    pub fn process_class(&self, cls: &mut ClassData) {
        // Check if class should be renamed
        let class_action = self.condition.check_class(cls);
        if class_action.should_rename() && cls.alias.is_none() {
            let alias = self.alias_provider.for_class(cls);
            cls.alias = Some(alias.clone());
            // Register alias for cross-reference resolution
            if let Some(ref reg) = self.registry {
                reg.set_class_alias(&cls.class_type, &alias);
            }
        }

        // Process fields
        for field in &mut cls.static_fields {
            let action = self.condition.check_field(field);
            if action.should_rename() && field.alias.is_none() {
                let alias = self.alias_provider.for_field(field);
                field.alias = Some(alias.clone());
                if let Some(ref reg) = self.registry {
                    reg.set_field_alias(&cls.class_type, &field.name, &alias);
                }
            }
        }
        for field in &mut cls.instance_fields {
            let action = self.condition.check_field(field);
            if action.should_rename() && field.alias.is_none() {
                let alias = self.alias_provider.for_field(field);
                field.alias = Some(alias.clone());
                if let Some(ref reg) = self.registry {
                    reg.set_field_alias(&cls.class_type, &field.name, &alias);
                }
            }
        }

        // Process methods
        for method in &mut cls.methods {
            let action = self.condition.check_method(method);
            if action.should_rename() && method.alias.is_none() {
                let is_override = Self::is_likely_override(method);
                let alias = self.alias_provider.for_method(method, is_override);
                method.alias = Some(alias.clone());
                if let Some(ref reg) = self.registry {
                    let proto_desc = method_proto_to_descriptor(&method.arg_types, &method.return_type);
                    reg.set_method_alias(&cls.class_type, &method.name, &proto_desc, &alias);
                }
            }
        }
    }

    /// Check if a method is likely an override (has @Override annotation)
    fn is_likely_override(method: &dexterity_ir::MethodData) -> bool {
        method.annotations.iter().any(|a| {
            a.annotation_type == "java/lang/Override"
                || a.annotation_type.ends_with("/Override")
        })
    }

    /// Process multiple classes
    pub fn process_classes(&self, classes: &mut [ClassData]) {
        for cls in classes {
            self.process_class(cls);
        }
    }

    /// Process packages first, then classes - matching JADX behavior exactly
    ///
    /// JADX Reference: DeobfuscatorVisitor.process() lines 34-47
    /// ```java
    /// public static void process(RootNode root, IRenameCondition renameCondition, IAliasProvider aliasProvider) {
    ///     boolean pkgUpdated = false;
    ///     // JADX processes packages FIRST
    ///     for (PackageNode pkg : root.getPackages()) {
    ///         if (renameCondition.shouldRename(pkg)) {
    ///             String alias = aliasProvider.forPackage(pkg);
    ///             if (alias != null) {
    ///                 pkg.rename(alias, false);
    ///                 pkgUpdated = true;
    ///             }
    ///         }
    ///     }
    ///     if (pkgUpdated) {
    ///         root.runPackagesUpdate();  // <-- Important!
    ///     }
    ///     // THEN processes classes...
    /// }
    /// ```
    ///
    /// Returns the package rename mapping (old_pkg -> new_pkg) for later use
    pub fn process_with_packages(
        &self,
        packages: &mut Vec<String>,
        classes: &mut [ClassData],
    ) -> HashMap<String, String> {
        // JADX: Process packages first
        let pkg_renames = self.process_packages(packages);

        // JADX: if (pkgUpdated) { root.runPackagesUpdate(); }
        // In dexterity, this means updating class pkg_alias fields
        if !pkg_renames.is_empty() {
            self.update_class_packages(classes, &pkg_renames);
        }

        // Then process classes
        self.process_classes(classes);

        pkg_renames
    }

    /// Process packages for renaming
    ///
    /// JADX Reference: DeobfuscatorVisitor.process() package loop lines 36-45
    ///
    /// Returns a map of old package names to new package aliases
    fn process_packages(&self, packages: &mut Vec<String>) -> HashMap<String, String> {
        let mut renames = HashMap::new();

        for pkg in packages.iter_mut() {
            let action = self.condition.check_package(pkg);
            if action.should_rename() {
                // JADX: String alias = aliasProvider.forPackage(pkg);
                let alias = self.alias_provider.for_package(pkg);

                // Store the rename mapping
                renames.insert(pkg.clone(), alias.clone());

                // Register in registry if available
                if let Some(ref reg) = self.registry {
                    reg.set_package_alias(pkg, &alias);
                }

                // Update the package in place
                *pkg = alias;
            }
        }

        renames
    }

    /// Update class pkg_alias fields based on package renames
    ///
    /// JADX Reference: RootNode.runPackagesUpdate()
    /// In JADX, this updates the package tree and class references.
    /// In dexterity, we update the pkg_alias field on ClassData.
    fn update_class_packages(
        &self,
        classes: &mut [ClassData],
        pkg_renames: &HashMap<String, String>,
    ) {
        for cls in classes.iter_mut() {
            // Get the class's package from its class_type
            // e.g., "Lcom/example/MyClass;" -> "com/example"
            let class_type = cls.class_type.trim_start_matches('L').trim_end_matches(';');
            if let Some(last_slash) = class_type.rfind('/') {
                let pkg = &class_type[..last_slash];

                // Check if this package was renamed
                if let Some(new_pkg) = pkg_renames.get(pkg) {
                    // Set the pkg_alias - the new package path for this class
                    cls.pkg_alias = Some(new_pkg.clone());

                    // Register in registry if available
                    if let Some(ref reg) = self.registry {
                        reg.set_class_package_alias(&cls.class_type, new_pkg);
                    }
                }
            }
        }
    }
}

/// Configuration for deobfuscation
#[derive(Debug, Clone)]
pub struct DeobfConfig {
    /// Minimum name length (shorter names are renamed)
    pub min_length: usize,
    /// Maximum name length (longer names get hashed)
    pub max_length: usize,
    /// Whether deobfuscation is enabled
    pub enabled: bool,
}

impl Default for DeobfConfig {
    fn default() -> Self {
        Self {
            min_length: 3,
            max_length: 64,
            enabled: false,
        }
    }
}

impl DeobfConfig {
    pub fn new(enabled: bool, min_length: usize, max_length: usize) -> Self {
        Self {
            min_length,
            max_length,
            enabled,
        }
    }
}

#[cfg(test)]
mod tests {
    use super::*;
    use crate::conditions::CombinedCondition;
    use crate::alias_provider::DeobfAliasProvider;
    use dexterity_ir::{ArgType, FieldData, MethodData};

    #[test]
    fn test_visitor() {
        let condition = CombinedCondition::default_jadx(3, 64);
        let provider = DeobfAliasProvider::new(64);
        let visitor = DeobfuscatorVisitor::new(condition, provider);

        // Create a class with short names
        let mut cls = ClassData::new("La/b/C;".to_string(), 0);
        cls.methods.push(MethodData::new("a".to_string(), 0, ArgType::Void));
        cls.instance_fields.push(FieldData::new("x".to_string(), 0, ArgType::Int));

        // Process
        visitor.process_class(&mut cls);

        // Class should be renamed (name "C" is only 1 char)
        assert!(cls.alias.is_some(), "Class should have alias");

        // Method should be renamed (name "a" is only 1 char)
        assert!(cls.methods[0].alias.is_some(), "Method should have alias");

        // Field should be renamed (name "x" is only 1 char)
        assert!(cls.instance_fields[0].alias.is_some(), "Field should have alias");
    }

    #[test]
    fn test_no_rename_valid_names() {
        let condition = CombinedCondition::default_jadx(3, 64);
        let provider = DeobfAliasProvider::new(64);
        let visitor = DeobfuscatorVisitor::new(condition, provider);

        // Create a class with valid names
        let mut cls = ClassData::new("Lcom/example/MainActivity;".to_string(), 0);
        cls.methods.push(MethodData::new("onCreate".to_string(), 0, ArgType::Void));
        cls.instance_fields.push(FieldData::new("count".to_string(), 0, ArgType::Int));

        // Process
        visitor.process_class(&mut cls);

        // Nothing should be renamed
        assert!(cls.alias.is_none(), "Class should not have alias");
        assert!(cls.methods[0].alias.is_none(), "Method should not have alias");
        assert!(cls.instance_fields[0].alias.is_none(), "Field should not have alias");
    }

    #[test]
    fn test_process_with_packages() {
        // JADX Reference: DeobfuscatorVisitor.process() lines 34-47
        // Test that packages are processed FIRST, then classes

        let condition = CombinedCondition::default_jadx(3, 64);
        let provider = DeobfAliasProvider::new(64);
        let visitor = DeobfuscatorVisitor::new(condition, provider);

        // Create packages with short names that should be renamed
        let mut packages = vec![
            "a".to_string(),           // Short, should be renamed
            "ab".to_string(),          // Short, should be renamed
            "com/example".to_string(), // Valid, should NOT be renamed
        ];

        // Create classes in those packages
        let mut classes = vec![
            ClassData::new("La/MyClass;".to_string(), 0),          // In package "a"
            ClassData::new("Lab/OtherClass;".to_string(), 0),      // In package "ab"
            ClassData::new("Lcom/example/MainActivity;".to_string(), 0), // In package "com/example"
        ];

        // Process with packages
        let pkg_renames = visitor.process_with_packages(&mut packages, &mut classes);

        // Short packages should be renamed
        assert!(!pkg_renames.is_empty(), "Some packages should be renamed");
        assert!(pkg_renames.contains_key("a"), "Package 'a' should be renamed");
        assert!(pkg_renames.contains_key("ab"), "Package 'ab' should be renamed");

        // Valid package should not be renamed
        assert!(!pkg_renames.contains_key("com/example"), "Package 'com/example' should not be renamed");

        // Classes in renamed packages should have pkg_alias set
        assert!(
            classes[0].pkg_alias.is_some(),
            "Class in 'a' should have pkg_alias"
        );
        assert!(
            classes[1].pkg_alias.is_some(),
            "Class in 'ab' should have pkg_alias"
        );

        // Class in valid package should NOT have pkg_alias set
        assert!(
            classes[2].pkg_alias.is_none(),
            "Class in 'com/example' should not have pkg_alias"
        );

        // Verify the pkg_alias values match the renamed package names
        assert_eq!(
            classes[0].pkg_alias.as_ref().unwrap(),
            pkg_renames.get("a").unwrap(),
            "pkg_alias should match renamed package"
        );
    }

    #[test]
    fn test_update_class_packages() {
        // JADX Reference: RootNode.runPackagesUpdate()
        // Test that class pkg_alias is updated when packages are renamed

        let condition = CombinedCondition::default_jadx(3, 64);
        let provider = DeobfAliasProvider::new(64);
        let visitor = DeobfuscatorVisitor::new(condition, provider);

        // Simulate a package rename
        let mut pkg_renames = HashMap::new();
        pkg_renames.insert("a/b".to_string(), "renamed/package".to_string());

        // Create classes
        let mut classes = vec![
            ClassData::new("La/b/MyClass;".to_string(), 0),      // In renamed package
            ClassData::new("La/b/c/Other;".to_string(), 0),      // In subpackage (not directly renamed)
            ClassData::new("Lcom/example/Main;".to_string(), 0), // Different package
        ];

        // Apply package updates
        visitor.update_class_packages(&mut classes, &pkg_renames);

        // Class in renamed package should have pkg_alias
        assert_eq!(
            classes[0].pkg_alias,
            Some("renamed/package".to_string()),
            "Class in 'a/b' should have pkg_alias set"
        );

        // Class in subpackage should NOT have pkg_alias (only exact match)
        assert!(
            classes[1].pkg_alias.is_none(),
            "Class in 'a/b/c' should not have pkg_alias (subpackage not renamed)"
        );

        // Class in different package should NOT have pkg_alias
        assert!(
            classes[2].pkg_alias.is_none(),
            "Class in 'com/example' should not have pkg_alias"
        );
    }
}
