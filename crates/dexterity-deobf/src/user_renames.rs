//! User-provided renames support
//!
//! Ported from jadx-core/src/main/java/jadx/core/dex/visitors/rename/UserRenames.java
//!
//! This module allows applying user-specified renames to classes, methods, and fields.
//! Users can provide a mapping of original names to desired aliases.

use std::collections::HashMap;

use dexterity_ir::ClassData;

use crate::signature::method_proto_to_descriptor;

/// User-provided renames
#[derive(Debug, Default, Clone)]
pub struct UserRenames {
    /// Package renames: original -> alias
    pub packages: HashMap<String, String>,
    /// Class renames: original_class_type -> alias
    pub classes: HashMap<String, String>,
    /// Field renames: (class_type, field_name) -> alias
    pub fields: HashMap<(String, String), String>,
    /// Method renames: (class_type, method_name, proto) -> alias
    pub methods: HashMap<(String, String, String), String>,
}

impl UserRenames {
    /// Create empty user renames
    pub fn new() -> Self {
        Self::default()
    }

    /// Add a class rename
    pub fn add_class(&mut self, class_type: &str, alias: &str) {
        self.classes.insert(class_type.to_string(), alias.to_string());
    }

    /// Add a field rename
    pub fn add_field(&mut self, class_type: &str, field_name: &str, alias: &str) {
        self.fields.insert(
            (class_type.to_string(), field_name.to_string()),
            alias.to_string(),
        );
    }

    /// Add a method rename
    pub fn add_method(&mut self, class_type: &str, method_name: &str, proto: &str, alias: &str) {
        self.methods.insert(
            (class_type.to_string(), method_name.to_string(), proto.to_string()),
            alias.to_string(),
        );
    }

    /// Add a package rename
    pub fn add_package(&mut self, package: &str, alias: &str) {
        self.packages.insert(package.to_string(), alias.to_string());
    }

    /// Check if there are any renames
    pub fn is_empty(&self) -> bool {
        self.packages.is_empty()
            && self.classes.is_empty()
            && self.fields.is_empty()
            && self.methods.is_empty()
    }

    /// Apply renames to a list of classes
    pub fn apply(&self, classes: &mut [ClassData]) {
        if self.is_empty() {
            return;
        }

        for cls in classes {
            // Apply class rename
            if let Some(alias) = self.classes.get(&cls.class_type) {
                cls.alias = Some(alias.clone());
            }

            // Apply field renames
            for field in cls.static_fields.iter_mut().chain(cls.instance_fields.iter_mut()) {
                let key = (cls.class_type.clone(), field.name.clone());
                if let Some(alias) = self.fields.get(&key) {
                    field.alias = Some(alias.clone());
                }
            }

            // Apply method renames
            for method in &mut cls.methods {
                let proto = method_proto_to_descriptor(&method.arg_types, &method.return_type);
                let key = (cls.class_type.clone(), method.name.clone(), proto);
                if let Some(alias) = self.methods.get(&key) {
                    method.alias = Some(alias.clone());
                }
            }
        }
    }

    /// Apply package renames to class types
    ///
    /// This modifies the class_type field to reflect package renames.
    /// Note: This should be called carefully as it changes the class identity.
    pub fn apply_package_renames(&self, classes: &mut [ClassData]) {
        if self.packages.is_empty() {
            return;
        }

        for cls in classes {
            // Extract package from class type
            let class_type = cls.class_type.trim_start_matches('L').trim_end_matches(';');
            if let Some(last_slash) = class_type.rfind('/') {
                let package = &class_type[..last_slash];
                if let Some(new_pkg) = self.packages.get(package) {
                    // Update pkg_alias instead of modifying class_type
                    cls.pkg_alias = Some(new_pkg.clone());
                }
            }
        }
    }
}

/// Builder for UserRenames with fluent API
pub struct UserRenamesBuilder {
    renames: UserRenames,
}

impl UserRenamesBuilder {
    pub fn new() -> Self {
        Self {
            renames: UserRenames::new(),
        }
    }

    pub fn class(mut self, class_type: &str, alias: &str) -> Self {
        self.renames.add_class(class_type, alias);
        self
    }

    pub fn field(mut self, class_type: &str, field_name: &str, alias: &str) -> Self {
        self.renames.add_field(class_type, field_name, alias);
        self
    }

    pub fn method(mut self, class_type: &str, method_name: &str, proto: &str, alias: &str) -> Self {
        self.renames.add_method(class_type, method_name, proto, alias);
        self
    }

    pub fn package(mut self, package: &str, alias: &str) -> Self {
        self.renames.add_package(package, alias);
        self
    }

    pub fn build(self) -> UserRenames {
        self.renames
    }
}

impl Default for UserRenamesBuilder {
    fn default() -> Self {
        Self::new()
    }
}

#[cfg(test)]
mod tests {
    use super::*;
    use dexterity_ir::{ArgType, FieldData, MethodData};

    #[test]
    fn test_empty_renames() {
        let renames = UserRenames::new();
        assert!(renames.is_empty());
    }

    #[test]
    fn test_apply_class_rename() {
        let mut renames = UserRenames::new();
        renames.add_class("Lcom/old/MyClass;", "RenamedClass");

        let mut classes = vec![ClassData::new("Lcom/old/MyClass;".to_string(), 0)];
        renames.apply(&mut classes);

        assert_eq!(classes[0].alias, Some("RenamedClass".to_string()));
    }

    #[test]
    fn test_apply_field_rename() {
        let mut renames = UserRenames::new();
        renames.add_field("Lcom/Test;", "oldField", "newField");

        let mut classes = vec![ClassData::new("Lcom/Test;".to_string(), 0)];
        classes[0].instance_fields.push(FieldData::new(
            "oldField".to_string(),
            0,
            ArgType::Int,
        ));
        renames.apply(&mut classes);

        assert_eq!(
            classes[0].instance_fields[0].alias,
            Some("newField".to_string())
        );
    }

    #[test]
    fn test_apply_method_rename() {
        let mut renames = UserRenames::new();
        renames.add_method("Lcom/Test;", "oldMethod", "()V", "newMethod");

        let mut classes = vec![ClassData::new("Lcom/Test;".to_string(), 0)];
        classes[0].methods.push(MethodData::new(
            "oldMethod".to_string(),
            0,
            ArgType::Void,
        ));
        renames.apply(&mut classes);

        assert_eq!(classes[0].methods[0].alias, Some("newMethod".to_string()));
    }

    #[test]
    fn test_builder() {
        let renames = UserRenamesBuilder::new()
            .class("Lcom/A;", "RenamedA")
            .field("Lcom/A;", "x", "renamedX")
            .build();

        assert!(!renames.is_empty());
        assert_eq!(renames.classes.get("Lcom/A;"), Some(&"RenamedA".to_string()));
        assert_eq!(
            renames.fields.get(&("Lcom/A;".to_string(), "x".to_string())),
            Some(&"renamedX".to_string())
        );
    }
}
