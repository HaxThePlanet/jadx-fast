//! Global alias registry for deobfuscation
//!
//! Thread-safe registry mapping original names to aliases.
//! Used to track all deobfuscated names and apply them during code generation.

use std::collections::HashMap;
use std::sync::RwLock;

/// Global registry storing all aliases for deobfuscation.
///
/// This registry is populated during the deobfuscation pass and queried
/// during code generation to resolve cross-references.
#[derive(Debug, Default)]
pub struct AliasRegistry {
    /// Class aliases: class_type (e.g., "La/b/c;") -> alias (e.g., "MyClass")
    classes: RwLock<HashMap<String, String>>,
    /// Package aliases: package (e.g., "a/b") -> alias (e.g., "com/example")
    packages: RwLock<HashMap<String, String>>,
    /// Field aliases: (class_type, field_name) -> alias
    fields: RwLock<HashMap<(String, String), String>>,
    /// Method aliases: (class_type, method_name, proto_shorty) -> alias
    /// Proto shorty is used to disambiguate overloaded methods
    methods: RwLock<HashMap<(String, String, String), String>>,
}

impl AliasRegistry {
    /// Create a new empty alias registry
    pub fn new() -> Self {
        Self::default()
    }

    // === Class Aliases ===

    /// Set an alias for a class
    pub fn set_class_alias(&self, class_type: &str, alias: &str) {
        let mut classes = self.classes.write().unwrap();
        classes.insert(class_type.to_string(), alias.to_string());
    }

    /// Get the alias for a class, if one exists
    pub fn get_class_alias(&self, class_type: &str) -> Option<String> {
        let classes = self.classes.read().unwrap();
        classes.get(class_type).cloned()
    }

    /// Check if a class has an alias
    pub fn has_class_alias(&self, class_type: &str) -> bool {
        let classes = self.classes.read().unwrap();
        classes.contains_key(class_type)
    }

    /// Get the number of class aliases
    pub fn class_count(&self) -> usize {
        let classes = self.classes.read().unwrap();
        classes.len()
    }

    // === Package Aliases ===

    /// Set an alias for a package
    pub fn set_package_alias(&self, package: &str, alias: &str) {
        let mut packages = self.packages.write().unwrap();
        packages.insert(package.to_string(), alias.to_string());
    }

    /// Get the alias for a package, if one exists
    pub fn get_package_alias(&self, package: &str) -> Option<String> {
        let packages = self.packages.read().unwrap();
        packages.get(package).cloned()
    }

    // === Field Aliases ===

    /// Set an alias for a field
    pub fn set_field_alias(&self, class_type: &str, field_name: &str, alias: &str) {
        let mut fields = self.fields.write().unwrap();
        fields.insert(
            (class_type.to_string(), field_name.to_string()),
            alias.to_string(),
        );
    }

    /// Get the alias for a field, if one exists
    pub fn get_field_alias(&self, class_type: &str, field_name: &str) -> Option<String> {
        let fields = self.fields.read().unwrap();
        fields
            .get(&(class_type.to_string(), field_name.to_string()))
            .cloned()
    }

    /// Get the number of field aliases
    pub fn field_count(&self) -> usize {
        let fields = self.fields.read().unwrap();
        fields.len()
    }

    // === Method Aliases ===

    /// Set an alias for a method
    ///
    /// `proto_shorty` is used to disambiguate overloaded methods.
    /// It can be empty string if not needed.
    pub fn set_method_alias(
        &self,
        class_type: &str,
        method_name: &str,
        proto_shorty: &str,
        alias: &str,
    ) {
        let mut methods = self.methods.write().unwrap();
        methods.insert(
            (
                class_type.to_string(),
                method_name.to_string(),
                proto_shorty.to_string(),
            ),
            alias.to_string(),
        );
    }

    /// Get the alias for a method, if one exists
    pub fn get_method_alias(
        &self,
        class_type: &str,
        method_name: &str,
        proto_shorty: &str,
    ) -> Option<String> {
        let methods = self.methods.read().unwrap();
        // Try exact match first
        if let Some(alias) = methods.get(&(
            class_type.to_string(),
            method_name.to_string(),
            proto_shorty.to_string(),
        )) {
            return Some(alias.clone());
        }
        // Fall back to match without proto (for simpler lookups)
        if !proto_shorty.is_empty() {
            if let Some(alias) = methods.get(&(
                class_type.to_string(),
                method_name.to_string(),
                String::new(),
            )) {
                return Some(alias.clone());
            }
        }
        None
    }

    /// Get the number of method aliases
    pub fn method_count(&self) -> usize {
        let methods = self.methods.read().unwrap();
        methods.len()
    }

    // === Bulk Operations ===

    /// Get total count of all aliases
    pub fn total_count(&self) -> usize {
        self.class_count() + self.field_count() + self.method_count()
    }

    /// Clear all aliases
    pub fn clear(&self) {
        self.classes.write().unwrap().clear();
        self.packages.write().unwrap().clear();
        self.fields.write().unwrap().clear();
        self.methods.write().unwrap().clear();
    }
}

#[cfg(test)]
mod tests {
    use super::*;

    #[test]
    fn test_class_alias() {
        let registry = AliasRegistry::new();

        // No alias initially
        assert!(registry.get_class_alias("La/b/c;").is_none());

        // Set alias
        registry.set_class_alias("La/b/c;", "MyClass");

        // Get alias
        assert_eq!(
            registry.get_class_alias("La/b/c;"),
            Some("MyClass".to_string())
        );
        assert!(registry.has_class_alias("La/b/c;"));
        assert_eq!(registry.class_count(), 1);
    }

    #[test]
    fn test_field_alias() {
        let registry = AliasRegistry::new();

        registry.set_field_alias("La/b/c;", "x", "fieldX");

        assert_eq!(
            registry.get_field_alias("La/b/c;", "x"),
            Some("fieldX".to_string())
        );
        assert!(registry.get_field_alias("La/b/c;", "y").is_none());
    }

    #[test]
    fn test_method_alias() {
        let registry = AliasRegistry::new();

        // Method with proto
        registry.set_method_alias("La/b/c;", "a", "VL", "onCreate");
        assert_eq!(
            registry.get_method_alias("La/b/c;", "a", "VL"),
            Some("onCreate".to_string())
        );

        // Method without proto (fallback)
        registry.set_method_alias("La/b/c;", "b", "", "doSomething");
        assert_eq!(
            registry.get_method_alias("La/b/c;", "b", ""),
            Some("doSomething".to_string())
        );
        // Can also find with any proto since we stored empty
        assert_eq!(
            registry.get_method_alias("La/b/c;", "b", "V"),
            Some("doSomething".to_string())
        );
    }

    #[test]
    fn test_thread_safety() {
        use std::sync::Arc;
        use std::thread;

        let registry = Arc::new(AliasRegistry::new());
        let mut handles = vec![];

        // Spawn multiple writers
        for i in 0..10 {
            let reg = Arc::clone(&registry);
            handles.push(thread::spawn(move || {
                reg.set_class_alias(&format!("Lclass{};", i), &format!("Class{}", i));
            }));
        }

        // Wait for all writers
        for handle in handles {
            handle.join().unwrap();
        }

        // Verify all were written
        assert_eq!(registry.class_count(), 10);

        // Spawn multiple readers
        let mut handles = vec![];
        for i in 0..10 {
            let reg = Arc::clone(&registry);
            handles.push(thread::spawn(move || {
                assert_eq!(
                    reg.get_class_alias(&format!("Lclass{};", i)),
                    Some(format!("Class{}", i))
                );
            }));
        }

        for handle in handles {
            handle.join().unwrap();
        }
    }
}
