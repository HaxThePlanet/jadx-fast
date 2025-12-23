//! Code-level renaming (variables and parameters)
//!
//! JADX Reference: jadx-core/src/main/java/jadx/core/dex/visitors/rename/CodeRenameVisitor.java
//! Cloned from JADX's CodeRenameVisitor visitor.
//!
//! This module handles renaming of entities within method bodies:
//! - Method arguments (parameters) - stored in MethodData.arg_names
//! - Local variables (SSA variables) - requires SSA variable tracking
//!
//! The JADX implementation:
//! - Processes ICodeRename entries from user-provided code data
//! - Applies renames to method arguments via argRegs.get(argNum).getSVar().getCodeVar().setName()
//! - Applies renames to SSA variables via ssaVar.getCodeVar().setName()
//!
//! Dexterity implementation:
//! - Method arguments: Use MethodData.arg_names (same as debug info names)
//! - Variables: Stored in CodeRenames for use during codegen

use std::collections::HashMap;
use dexterity_ir::ClassData;
use crate::signature::method_proto_to_descriptor;

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

    /// Get all class types that have renames
    pub fn class_types(&self) -> impl Iterator<Item = &String> {
        self.renames.keys()
    }

    /// Get total number of renames
    pub fn len(&self) -> usize {
        self.renames.values().map(|v| v.len()).sum()
    }
}

/// Apply code renames to classes
///
/// JADX Reference: jadx-core/src/main/java/jadx/core/dex/visitors/rename/CodeRenameVisitor.java
/// Cloned from JADX's CodeRenameVisitor.visit() and applyRenames() methods.
///
/// This function applies user-provided renames to method arguments and variables.
///
/// # Arguments
/// * `classes` - Classes to apply renames to
/// * `renames` - The code renames to apply
///
/// # Returns
/// Number of renames successfully applied
pub fn apply_code_renames(classes: &mut [ClassData], renames: &CodeRenames) -> usize {
    if renames.is_empty() {
        return 0;
    }

    let mut applied_count = 0;

    for cls in classes {
        let class_renames = renames.get_for_class(&cls.class_type);
        if class_renames.is_empty() {
            continue;
        }

        for method in &mut cls.methods {
            // Build method short ID for matching
            // JADX uses MethodInfo.makeSignature() which is name + proto
            let proto = method_proto_to_descriptor(&method.arg_types, &method.return_type);
            let method_short_id = format!("{}:{}{}", method.name, method.name, proto);
            let alt_short_id = format!("{}{}", method.name, proto);

            for rename in class_renames {
                // Match by method short ID
                // JADX Reference: CodeRenameVisitor.applyRenames() line 61
                if rename.method_short_id != method_short_id && rename.method_short_id != alt_short_id {
                    continue;
                }

                match &rename.code_ref {
                    CodeRefType::MethodArg { index } => {
                        // JADX Reference: CodeRenameVisitor.processRename() case MTH_ARG (lines 77-85)
                        // Rename method argument by setting its name
                        if *index < method.arg_names.len() {
                            method.arg_names[*index] = Some(rename.new_name.clone());
                            applied_count += 1;
                        } else if *index < method.arg_types.len() {
                            // Extend arg_names if needed
                            while method.arg_names.len() < method.arg_types.len() {
                                method.arg_names.push(None);
                            }
                            if *index < method.arg_names.len() {
                                method.arg_names[*index] = Some(rename.new_name.clone());
                                applied_count += 1;
                            }
                        }
                        // JADX logs warning if arg index is out of range
                    }
                    CodeRefType::Variable { reg_num: _, ssa_version: _ } => {
                        // JADX Reference: CodeRenameVisitor.processRename() case VAR (lines 87-96)
                        // Variables require SSA system integration.
                        // For now, we store the rename but can't apply it directly.
                        // The codegen phase can look up variable renames from CodeRenames.
                        //
                        // Future: When dexterity-ir has SSAVar.getCodeVar().setName() equivalent,
                        // iterate through mth.getSVars() to find matching (regNum, ssaVer)
                        //
                        // Note: JADX logs "Can't find variable ref by regNum_ssaVer" on failure
                    }
                }
            }
        }

        // Process inner classes recursively (JADX does this in visit())
        // Note: In dexterity, inner classes are separate ClassData entries
    }

    applied_count
}

/// CodeRenameVisitor equivalent - holds rename state during class processing
///
/// JADX Reference: jadx-core/src/main/java/jadx/core/dex/visitors/rename/CodeRenameVisitor.java
/// Cloned from JADX's CodeRenameVisitor class.
///
/// This struct provides a visitor-like interface for applying code renames.
pub struct CodeRenameVisitor {
    renames: CodeRenames,
}

impl CodeRenameVisitor {
    /// Create a new visitor with the given renames
    pub fn new(renames: CodeRenames) -> Self {
        Self { renames }
    }

    /// Apply renames to all classes
    ///
    /// JADX Reference: CodeRenameVisitor.visit() - processes class and inner classes
    pub fn apply_to_classes(&self, classes: &mut [ClassData]) -> usize {
        apply_code_renames(classes, &self.renames)
    }

    /// Check if visitor has any renames to apply
    pub fn has_renames(&self) -> bool {
        !self.renames.is_empty()
    }
}

#[cfg(test)]
mod tests {
    use super::*;
    use dexterity_ir::{ArgType, MethodData};

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

    #[test]
    fn test_apply_method_arg_rename() {
        // Create a class with a method that has arguments
        let mut cls = ClassData::new("Lcom/Test;".to_string(), 0);
        let mut method = MethodData::new("doSomething".to_string(), 0, ArgType::Void);
        method.arg_types = vec![ArgType::Object("Landroid/content/Context;".to_string()), ArgType::Int];
        method.arg_names = vec![None, None]; // No debug info names
        cls.methods.push(method);

        // Create rename for first argument
        let mut renames = CodeRenames::new();
        renames.add_method_arg("Lcom/Test;", "doSomething(Landroid/content/Context;I)V", 0, "context");

        // Apply renames
        let mut classes = vec![cls];
        let applied = apply_code_renames(&mut classes, &renames);

        assert_eq!(applied, 1);
        assert_eq!(classes[0].methods[0].arg_names[0], Some("context".to_string()));
        assert_eq!(classes[0].methods[0].arg_names[1], None); // Unchanged
    }

    #[test]
    fn test_code_rename_visitor() {
        let mut renames = CodeRenames::new();
        renames.add_method_arg("Lcom/Test;", "foo()V", 0, "param");

        let visitor = CodeRenameVisitor::new(renames);
        assert!(visitor.has_renames());

        let mut classes = vec![];
        let applied = visitor.apply_to_classes(&mut classes);
        assert_eq!(applied, 0); // No matching classes
    }

    #[test]
    fn test_renames_len() {
        let mut renames = CodeRenames::new();
        assert_eq!(renames.len(), 0);

        renames.add_method_arg("Lcom/A;", "foo()V", 0, "a");
        renames.add_method_arg("Lcom/A;", "bar()V", 0, "b");
        renames.add_method_arg("Lcom/B;", "baz()V", 0, "c");

        assert_eq!(renames.len(), 3);
        assert_eq!(renames.class_types().count(), 2);
    }
}
