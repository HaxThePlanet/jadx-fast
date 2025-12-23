//! Code-level renaming (variables and parameters)
//!
//! Ported from jadx-core/src/main/java/jadx/core/dex/visitors/rename/CodeRenameVisitor.java
//!
//! This module handles renaming of entities within method bodies:
//! - Method arguments (parameters)
//! - Local variables (SSA variables)
//!
//! Note: Full implementation requires integration with the SSA system in dexterity-ir.
//! Currently provides the data structures and interfaces for future implementation.

use std::collections::HashMap;

/// Reference type for code-level renames
#[derive(Debug, Clone, PartialEq, Eq)]
pub enum CodeRefType {
    /// Method argument/parameter
    MethodArg { index: usize },
    /// Local variable (identified by register number and SSA version)
    Variable { reg_num: u16, ssa_version: u16 },
}

/// A code-level rename entry
#[derive(Debug, Clone)]
pub struct CodeRename {
    /// The class containing the method
    pub class_type: String,
    /// Method short ID (name + signature)
    pub method_short_id: String,
    /// What to rename
    pub code_ref: CodeRefType,
    /// New name
    pub new_name: String,
}

/// Collection of code-level renames
#[derive(Debug, Default)]
pub struct CodeRenames {
    /// Renames grouped by class
    renames: HashMap<String, Vec<CodeRename>>,
}

impl CodeRenames {
    pub fn new() -> Self {
        Self::default()
    }

    /// Add a method argument rename
    pub fn add_method_arg(&mut self, class_type: &str, method_id: &str, arg_index: usize, new_name: &str) {
        let entry = self.renames.entry(class_type.to_string()).or_default();
        entry.push(CodeRename {
            class_type: class_type.to_string(),
            method_short_id: method_id.to_string(),
            code_ref: CodeRefType::MethodArg { index: arg_index },
            new_name: new_name.to_string(),
        });
    }

    /// Add a variable rename
    pub fn add_variable(&mut self, class_type: &str, method_id: &str, reg_num: u16, ssa_version: u16, new_name: &str) {
        let entry = self.renames.entry(class_type.to_string()).or_default();
        entry.push(CodeRename {
            class_type: class_type.to_string(),
            method_short_id: method_id.to_string(),
            code_ref: CodeRefType::Variable { reg_num, ssa_version },
            new_name: new_name.to_string(),
        });
    }

    /// Get renames for a specific class
    pub fn get_for_class(&self, class_type: &str) -> &[CodeRename] {
        self.renames.get(class_type).map(|v| v.as_slice()).unwrap_or(&[])
    }

    /// Check if there are any renames
    pub fn is_empty(&self) -> bool {
        self.renames.is_empty()
    }
}

// Note: Applying CodeRenames requires access to SSA variables in MethodData.
// This is deferred until dexterity-ir exposes SSA variable naming APIs.
//
// Future implementation would look like:
//
// pub fn apply_code_renames(classes: &mut [ClassData], renames: &CodeRenames) {
//     for cls in classes {
//         let class_renames = renames.get_for_class(&cls.class_type);
//         for method in &mut cls.methods {
//             for rename in class_renames {
//                 if rename.method_short_id == method.short_id() {
//                     match &rename.code_ref {
//                         CodeRefType::MethodArg { index } => {
//                             // Rename arg_types[index] -> rename.new_name
//                         }
//                         CodeRefType::Variable { reg_num, ssa_version } => {
//                             // Find SSA var and set name
//                         }
//                     }
//                 }
//             }
//         }
//     }
// }

#[cfg(test)]
mod tests {
    use super::*;

    #[test]
    fn test_code_renames() {
        let mut renames = CodeRenames::new();

        renames.add_method_arg("Lcom/Test;", "foo()V", 0, "context");
        renames.add_variable("Lcom/Test;", "bar(I)V", 1, 0, "count");

        let test_renames = renames.get_for_class("Lcom/Test;");
        assert_eq!(test_renames.len(), 2);

        assert!(matches!(test_renames[0].code_ref, CodeRefType::MethodArg { index: 0 }));
        assert_eq!(test_renames[0].new_name, "context");

        assert!(matches!(test_renames[1].code_ref, CodeRefType::Variable { reg_num: 1, ssa_version: 0 }));
        assert_eq!(test_renames[1].new_name, "count");
    }

    #[test]
    fn test_empty_renames() {
        let renames = CodeRenames::new();
        assert!(renames.is_empty());
        assert!(renames.get_for_class("Lcom/Test;").is_empty());
    }
}
