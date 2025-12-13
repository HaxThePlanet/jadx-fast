//! Class hierarchy for type inference and subtype checking
//!
//! This module builds a class hierarchy graph from DEX class definitions
//! and provides operations for:
//! - Subtype checking (is A a subtype of B?)
//! - Least Common Ancestor (LCA) calculation for type unification
//! - Supertype/interface relationship queries

use std::collections::{HashMap, HashSet};

/// Class hierarchy graph
#[derive(Debug, Clone)]
pub struct ClassHierarchy {
    /// Class name -> superclass name
    superclass_map: HashMap<String, String>,
    /// Class name -> interface names
    interfaces_map: HashMap<String, Vec<String>>,
    /// All known class names
    all_classes: HashSet<String>,
}

impl ClassHierarchy {
    /// Create a new empty class hierarchy
    pub fn new() -> Self {
        let mut hierarchy = ClassHierarchy {
            superclass_map: HashMap::new(),
            interfaces_map: HashMap::new(),
            all_classes: HashSet::new(),
        };

        // Add fundamental Java types
        hierarchy.add_fundamental_types();
        hierarchy
    }

    /// Add fundamental Java types (Object, String, etc.)
    fn add_fundamental_types(&mut self) {
        // java.lang.Object has no superclass
        self.all_classes.insert("java/lang/Object".to_string());

        // Common fundamental types
        let fundamental = vec![
            ("java/lang/String", "java/lang/Object"),
            ("java/lang/Class", "java/lang/Object"),
            ("java/lang/Throwable", "java/lang/Object"),
            ("java/lang/Exception", "java/lang/Throwable"),
            ("java/lang/RuntimeException", "java/lang/Exception"),
            ("java/lang/Error", "java/lang/Throwable"),
            ("java/lang/Number", "java/lang/Object"),
            ("java/lang/Integer", "java/lang/Number"),
            ("java/lang/Long", "java/lang/Number"),
            ("java/lang/Float", "java/lang/Number"),
            ("java/lang/Double", "java/lang/Number"),
            ("java/lang/Byte", "java/lang/Number"),
            ("java/lang/Short", "java/lang/Number"),
            ("java/lang/Boolean", "java/lang/Object"),
            ("java/lang/Character", "java/lang/Object"),
        ];

        for (class, superclass) in fundamental {
            self.add_class(class.to_string(), Some(superclass.to_string()), vec![]);
        }
    }

    /// Add a class to the hierarchy
    pub fn add_class(
        &mut self,
        class_name: String,
        superclass: Option<String>,
        interfaces: Vec<String>,
    ) {
        self.all_classes.insert(class_name.clone());

        if let Some(super_name) = superclass {
            // Ensure superclass exists
            self.all_classes.insert(super_name.clone());
            self.superclass_map.insert(class_name.clone(), super_name);
        }

        if !interfaces.is_empty() {
            // Ensure all interfaces exist
            for iface in &interfaces {
                self.all_classes.insert(iface.clone());
            }
            self.interfaces_map.insert(class_name, interfaces);
        }
    }

    /// Check if a class is known in the hierarchy
    pub fn has_class(&self, class_name: &str) -> bool {
        self.all_classes.contains(class_name)
    }

    /// Get the direct superclass of a class
    pub fn get_superclass(&self, class_name: &str) -> Option<&str> {
        self.superclass_map.get(class_name).map(|s| s.as_str())
    }

    /// Get all interfaces implemented by a class
    pub fn get_interfaces(&self, class_name: &str) -> Vec<&str> {
        self.interfaces_map
            .get(class_name)
            .map(|ifaces| ifaces.iter().map(|s| s.as_str()).collect())
            .unwrap_or_default()
    }

    /// Check if `subtype` is a subtype of `supertype`
    ///
    /// Returns true if:
    /// - subtype == supertype
    /// - subtype extends supertype (directly or transitively)
    /// - subtype implements supertype (directly or transitively)
    pub fn is_subtype_of(&self, subtype: &str, supertype: &str) -> bool {
        if subtype == supertype {
            return true;
        }

        // Special case: everything is a subtype of Object
        if supertype == "java/lang/Object" {
            return true;
        }

        // BFS to find supertype in class hierarchy
        let mut visited = HashSet::new();
        let mut queue = vec![subtype];

        while let Some(current) = queue.pop() {
            if !visited.insert(current) {
                continue; // Already visited
            }

            // Check direct superclass
            if let Some(super_name) = self.get_superclass(current) {
                if super_name == supertype {
                    return true;
                }
                queue.push(super_name);
            }

            // Check implemented interfaces
            for iface in self.get_interfaces(current) {
                if iface == supertype {
                    return true;
                }
                queue.push(iface);
            }
        }

        false
    }

    /// Compute the Least Common Ancestor (LCA) of two types
    ///
    /// The LCA is the most specific type that is a supertype of both inputs.
    /// This is used for type unification in PHI nodes.
    pub fn least_common_ancestor(&self, type1: &str, type2: &str) -> String {
        if type1 == type2 {
            return type1.to_string();
        }

        // Special cases
        if type1 == "java/lang/Object" || type2 == "java/lang/Object" {
            return "java/lang/Object".to_string();
        }

        // If one is a subtype of the other, return the supertype
        if self.is_subtype_of(type1, type2) {
            return type2.to_string();
        }
        if self.is_subtype_of(type2, type1) {
            return type1.to_string();
        }

        // Collect all ancestors of type1
        let ancestors1 = self.collect_ancestors(type1);

        // Walk up from type2 until we find a common ancestor
        let mut current = type2.to_string();
        loop {
            if ancestors1.contains(&current) {
                return current;
            }

            // Move to superclass
            if let Some(super_name) = self.get_superclass(&current) {
                current = super_name.to_string();
            } else {
                // No more superclasses, fall back to Object
                return "java/lang/Object".to_string();
            }
        }
    }

    /// Collect all ancestors (superclasses and interfaces) of a class
    fn collect_ancestors(&self, class_name: &str) -> HashSet<String> {
        let mut ancestors = HashSet::new();
        let mut queue = vec![class_name.to_string()];

        while let Some(current) = queue.pop() {
            if !ancestors.insert(current.clone()) {
                continue; // Already visited
            }

            // Add superclass
            if let Some(super_name) = self.get_superclass(&current) {
                queue.push(super_name.to_string());
            }

            // Add interfaces
            for iface in self.get_interfaces(&current) {
                queue.push(iface.to_string());
            }
        }

        ancestors
    }

    /// Get the most specific common supertype for a list of types
    ///
    /// This is useful for PHI nodes with multiple incoming values.
    pub fn common_supertype(&self, types: &[&str]) -> String {
        if types.is_empty() {
            return "java/lang/Object".to_string();
        }

        if types.len() == 1 {
            return types[0].to_string();
        }

        // Compute LCA pairwise
        let mut result = types[0].to_string();
        for &ty in &types[1..] {
            result = self.least_common_ancestor(&result, ty);
        }

        result
    }
}

impl Default for ClassHierarchy {
    fn default() -> Self {
        Self::new()
    }
}

#[cfg(test)]
mod tests {
    use super::*;

    #[test]
    fn test_subtype_object() {
        let hierarchy = ClassHierarchy::new();

        // Everything is a subtype of Object
        assert!(hierarchy.is_subtype_of("java/lang/String", "java/lang/Object"));
        assert!(hierarchy.is_subtype_of("java/lang/Integer", "java/lang/Object"));
        assert!(hierarchy.is_subtype_of("java/lang/Exception", "java/lang/Object"));
    }

    #[test]
    fn test_subtype_exception() {
        let hierarchy = ClassHierarchy::new();

        // Exception hierarchy
        assert!(hierarchy.is_subtype_of("java/lang/Exception", "java/lang/Throwable"));
        assert!(hierarchy.is_subtype_of("java/lang/RuntimeException", "java/lang/Exception"));
        assert!(hierarchy.is_subtype_of("java/lang/RuntimeException", "java/lang/Throwable"));

        // Not a subtype
        assert!(!hierarchy.is_subtype_of("java/lang/Error", "java/lang/Exception"));
    }

    #[test]
    fn test_subtype_number() {
        let hierarchy = ClassHierarchy::new();

        // Number hierarchy
        assert!(hierarchy.is_subtype_of("java/lang/Integer", "java/lang/Number"));
        assert!(hierarchy.is_subtype_of("java/lang/Long", "java/lang/Number"));
        assert!(hierarchy.is_subtype_of("java/lang/Double", "java/lang/Number"));

        // Not a subtype
        assert!(!hierarchy.is_subtype_of("java/lang/String", "java/lang/Number"));
    }

    #[test]
    fn test_lca_same_type() {
        let hierarchy = ClassHierarchy::new();

        assert_eq!(
            hierarchy.least_common_ancestor("java/lang/String", "java/lang/String"),
            "java/lang/String"
        );
    }

    #[test]
    fn test_lca_subtype() {
        let hierarchy = ClassHierarchy::new();

        // Exception < Throwable
        assert_eq!(
            hierarchy.least_common_ancestor("java/lang/Exception", "java/lang/Throwable"),
            "java/lang/Throwable"
        );

        // RuntimeException < Exception
        assert_eq!(
            hierarchy.least_common_ancestor("java/lang/RuntimeException", "java/lang/Exception"),
            "java/lang/Exception"
        );
    }

    #[test]
    fn test_lca_siblings() {
        let hierarchy = ClassHierarchy::new();

        // Integer and Long -> Number
        assert_eq!(
            hierarchy.least_common_ancestor("java/lang/Integer", "java/lang/Long"),
            "java/lang/Number"
        );

        // Exception and Error -> Throwable
        assert_eq!(
            hierarchy.least_common_ancestor("java/lang/Exception", "java/lang/Error"),
            "java/lang/Throwable"
        );
    }

    #[test]
    fn test_lca_unrelated() {
        let hierarchy = ClassHierarchy::new();

        // String and Integer -> Object
        assert_eq!(
            hierarchy.least_common_ancestor("java/lang/String", "java/lang/Integer"),
            "java/lang/Object"
        );
    }

    #[test]
    fn test_common_supertype() {
        let hierarchy = ClassHierarchy::new();

        // Integer, Long, Double -> Number
        let types = vec!["java/lang/Integer", "java/lang/Long", "java/lang/Double"];
        assert_eq!(hierarchy.common_supertype(&types), "java/lang/Number");

        // Exception, RuntimeException -> Exception
        let types = vec!["java/lang/Exception", "java/lang/RuntimeException"];
        assert_eq!(hierarchy.common_supertype(&types), "java/lang/Exception");

        // String, Integer -> Object
        let types = vec!["java/lang/String", "java/lang/Integer"];
        assert_eq!(hierarchy.common_supertype(&types), "java/lang/Object");
    }

    #[test]
    fn test_custom_class() {
        let mut hierarchy = ClassHierarchy::new();

        // Add custom class: MyClass extends Exception
        hierarchy.add_class(
            "com/example/MyClass".to_string(),
            Some("java/lang/Exception".to_string()),
            vec![],
        );

        // MyClass < Exception
        assert!(hierarchy.is_subtype_of("com/example/MyClass", "java/lang/Exception"));
        // MyClass < Throwable
        assert!(hierarchy.is_subtype_of("com/example/MyClass", "java/lang/Throwable"));
        // MyClass < Object
        assert!(hierarchy.is_subtype_of("com/example/MyClass", "java/lang/Object"));

        // LCA with RuntimeException -> Exception
        assert_eq!(
            hierarchy.least_common_ancestor("com/example/MyClass", "java/lang/RuntimeException"),
            "java/lang/Exception"
        );
    }
}
