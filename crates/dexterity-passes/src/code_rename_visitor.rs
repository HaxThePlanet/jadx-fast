//! Code Rename Visitor Pass
//!
//! JADX Clone: jadx-core/src/main/java/jadx/core/dex/visitors/rename/CodeRenameVisitor.java (126 lines)
//! Original Author: Skylot (skylot@gmail.com)
//! Clone Date: Dec 2025
//!
//! ## Purpose
//!
//! Applies user-defined renames to variables and method arguments.
//! This is a GUI feature in JADX that allows users to rename local variables
//! and method parameters. The renames are stored in ICodeData and applied
//! during decompilation.
//!
//! ## JADX Reference
//!
//! ```java
//! // CodeRenameVisitor.java:74-103
//! private static void processRename(MethodNode mth, IJavaCodeRef codeRef, ICodeRename rename) {
//!     switch (codeRef.getAttachType()) {
//!         case MTH_ARG: {
//!             List<RegisterArg> argRegs = mth.getArgRegs();
//!             int argNum = codeRef.getIndex();
//!             if (argNum < argRegs.size()) {
//!                 argRegs.get(argNum).getSVar().getCodeVar().setName(rename.getNewName());
//!             }
//!             break;
//!         }
//!         case VAR: {
//!             int regNum = codeRef.getIndex() >> 16;
//!             int ssaVer = codeRef.getIndex() & 0xFFFF;
//!             for (SSAVar ssaVar : mth.getSVars()) {
//!                 if (ssaVar.getRegNum() == regNum && ssaVar.getVersion() == ssaVer) {
//!                     ssaVar.getCodeVar().setName(rename.getNewName());
//!                     return;
//!                 }
//!             }
//!             break;
//!         }
//!     }
//! }
//! ```
//!
//! ## Code Reference Types
//!
//! - MTH_ARG: Method argument by index
//! - VAR: Local variable by register number + SSA version

use std::collections::HashMap;

/// Type of code reference for renaming
/// JADX Reference: CodeRefType enum
#[derive(Debug, Clone, Copy, PartialEq, Eq)]
pub enum CodeRefType {
    /// Method argument by index
    MthArg,
    /// Local variable by register + SSA version
    Var,
    /// Instruction at offset (not used for renaming)
    Insn,
}

/// Reference to a specific code element
/// JADX Reference: IJavaCodeRef
#[derive(Debug, Clone)]
pub struct CodeRef {
    /// Type of the reference
    pub attach_type: CodeRefType,
    /// Index/encoding of the reference
    /// For MTH_ARG: argument index
    /// For VAR: (regNum << 16) | ssaVersion
    pub index: u32,
}

impl CodeRef {
    /// Create a method argument reference
    pub fn method_arg(arg_index: u32) -> Self {
        Self {
            attach_type: CodeRefType::MthArg,
            index: arg_index,
        }
    }

    /// Create a variable reference
    ///
    /// JADX Reference: CodeRenameVisitor.java:87-88
    pub fn var(reg_num: u16, ssa_version: u16) -> Self {
        Self {
            attach_type: CodeRefType::Var,
            index: ((reg_num as u32) << 16) | (ssa_version as u32),
        }
    }

    /// Get register number from VAR reference
    pub fn get_reg_num(&self) -> u16 {
        (self.index >> 16) as u16
    }

    /// Get SSA version from VAR reference
    pub fn get_ssa_version(&self) -> u16 {
        (self.index & 0xFFFF) as u16
    }
}

/// A rename instruction
/// JADX Reference: ICodeRename
#[derive(Debug, Clone)]
pub struct CodeRename {
    /// The class containing the method
    pub declaring_class: String,
    /// The method short ID
    pub method_short_id: String,
    /// Code reference to rename
    pub code_ref: CodeRef,
    /// New name to apply
    pub new_name: String,
}

/// SSA variable info for applying renames
#[derive(Debug, Clone)]
pub struct SSAVarInfo {
    /// Register number
    pub reg_num: u16,
    /// SSA version
    pub version: u16,
    /// Current name (mutable)
    pub name: Option<String>,
}

/// Method info for applying renames
#[derive(Debug, Clone)]
pub struct MethodRenameInfo {
    /// Declaring class
    pub declaring_class: String,
    /// Method short ID
    pub method_short_id: String,
    /// Method argument registers (by index)
    pub arg_regs: Vec<SSAVarInfo>,
    /// All SSA variables
    pub ssa_vars: Vec<SSAVarInfo>,
}

/// Result of code rename pass
#[derive(Debug, Default)]
pub struct CodeRenameResult {
    /// Number of method argument renames applied
    pub arg_renames: usize,
    /// Number of variable renames applied
    pub var_renames: usize,
    /// Warnings (e.g., reference not found)
    pub warnings: Vec<String>,
}

/// Code rename storage (grouped by class)
/// JADX Reference: CodeRenameVisitor.java:39
#[derive(Debug, Default)]
pub struct CodeRenameStorage {
    /// Renames grouped by class raw name
    renames_by_class: HashMap<String, Vec<CodeRename>>,
}

impl CodeRenameStorage {
    /// Create empty storage
    pub fn new() -> Self {
        Self::default()
    }

    /// Update renames from code data
    ///
    /// JADX Reference: CodeRenameVisitor.java:116-124
    pub fn update_renames(&mut self, renames: Vec<CodeRename>) {
        self.renames_by_class.clear();

        for rename in renames {
            self.renames_by_class
                .entry(rename.declaring_class.clone())
                .or_default()
                .push(rename);
        }
    }

    /// Get renames for a class
    pub fn get_renames(&self, class_name: &str) -> Option<&Vec<CodeRename>> {
        self.renames_by_class.get(class_name)
    }
}

/// Apply a single rename to a method.
///
/// JADX Reference: CodeRenameVisitor.java:74-103
fn process_rename(
    method: &mut MethodRenameInfo,
    code_ref: &CodeRef,
    new_name: &str,
    result: &mut CodeRenameResult,
) -> bool {
    match code_ref.attach_type {
        CodeRefType::MthArg => {
            // JADX Reference: CodeRenameVisitor.java:77-84
            let arg_num = code_ref.index as usize;
            if arg_num < method.arg_regs.len() {
                method.arg_regs[arg_num].name = Some(new_name.to_string());
                result.arg_renames += 1;
                true
            } else {
                result.warnings.push(format!(
                    "Incorrect method arg ref {}, should be less than {}",
                    arg_num,
                    method.arg_regs.len()
                ));
                false
            }
        }
        CodeRefType::Var => {
            // JADX Reference: CodeRenameVisitor.java:86-96
            let reg_num = code_ref.get_reg_num();
            let ssa_ver = code_ref.get_ssa_version();

            for ssa_var in &mut method.ssa_vars {
                if ssa_var.reg_num == reg_num && ssa_var.version == ssa_ver {
                    ssa_var.name = Some(new_name.to_string());
                    result.var_renames += 1;
                    return true;
                }
            }

            result.warnings.push(format!(
                "Can't find variable ref by {}_{} in {}",
                reg_num, ssa_ver, method.method_short_id
            ));
            false
        }
        _ => {
            result.warnings.push(format!(
                "Rename code ref type {:?} not yet supported",
                code_ref.attach_type
            ));
            false
        }
    }
}

/// Apply renames to a method.
///
/// JADX Reference: CodeRenameVisitor.java:57-72
pub fn apply_renames_to_method(
    method: &mut MethodRenameInfo,
    renames: &[CodeRename],
) -> CodeRenameResult {
    let mut result = CodeRenameResult::default();

    for rename in renames {
        if rename.method_short_id != method.method_short_id {
            continue;
        }

        process_rename(method, &rename.code_ref, &rename.new_name, &mut result);
    }

    result
}

/// Apply renames to all methods in a class.
///
/// JADX Reference: CodeRenameVisitor.java:48-56
pub fn apply_renames(
    class_name: &str,
    methods: &mut [MethodRenameInfo],
    storage: &CodeRenameStorage,
) -> CodeRenameResult {
    let mut result = CodeRenameResult::default();

    if let Some(renames) = storage.get_renames(class_name) {
        for method in methods {
            let method_result = apply_renames_to_method(method, renames);
            result.arg_renames += method_result.arg_renames;
            result.var_renames += method_result.var_renames;
            result.warnings.extend(method_result.warnings);
        }
    }

    // Process inner classes recursively would go here
    // JADX Reference: CodeRenameVisitor.java:53

    result
}

#[cfg(test)]
mod tests {
    use super::*;

    #[test]
    fn test_code_ref_method_arg() {
        let code_ref = CodeRef::method_arg(2);
        assert_eq!(code_ref.attach_type, CodeRefType::MthArg);
        assert_eq!(code_ref.index, 2);
    }

    #[test]
    fn test_code_ref_var() {
        let code_ref = CodeRef::var(5, 3);
        assert_eq!(code_ref.attach_type, CodeRefType::Var);
        assert_eq!(code_ref.get_reg_num(), 5);
        assert_eq!(code_ref.get_ssa_version(), 3);
    }

    #[test]
    fn test_process_rename_method_arg() {
        let mut method = MethodRenameInfo {
            declaring_class: "Test".to_string(),
            method_short_id: "foo(I)V".to_string(),
            arg_regs: vec![
                SSAVarInfo { reg_num: 1, version: 0, name: None },
                SSAVarInfo { reg_num: 2, version: 0, name: None },
            ],
            ssa_vars: vec![],
        };

        let mut result = CodeRenameResult::default();
        let code_ref = CodeRef::method_arg(1);
        process_rename(&mut method, &code_ref, "newArg", &mut result);

        assert_eq!(result.arg_renames, 1);
        assert_eq!(method.arg_regs[1].name, Some("newArg".to_string()));
    }

    #[test]
    fn test_process_rename_var() {
        let mut method = MethodRenameInfo {
            declaring_class: "Test".to_string(),
            method_short_id: "foo(I)V".to_string(),
            arg_regs: vec![],
            ssa_vars: vec![
                SSAVarInfo { reg_num: 0, version: 0, name: None },
                SSAVarInfo { reg_num: 1, version: 2, name: None },
            ],
        };

        let mut result = CodeRenameResult::default();
        let code_ref = CodeRef::var(1, 2);
        process_rename(&mut method, &code_ref, "renamedVar", &mut result);

        assert_eq!(result.var_renames, 1);
        assert_eq!(method.ssa_vars[1].name, Some("renamedVar".to_string()));
    }

    #[test]
    fn test_process_rename_not_found() {
        let mut method = MethodRenameInfo {
            declaring_class: "Test".to_string(),
            method_short_id: "foo(I)V".to_string(),
            arg_regs: vec![],
            ssa_vars: vec![],
        };

        let mut result = CodeRenameResult::default();
        let code_ref = CodeRef::var(99, 99);
        process_rename(&mut method, &code_ref, "notFound", &mut result);

        assert_eq!(result.var_renames, 0);
        assert!(!result.warnings.is_empty());
    }

    #[test]
    fn test_code_rename_storage() {
        let mut storage = CodeRenameStorage::new();

        let renames = vec![
            CodeRename {
                declaring_class: "Test".to_string(),
                method_short_id: "foo(I)V".to_string(),
                code_ref: CodeRef::method_arg(0),
                new_name: "arg0".to_string(),
            },
        ];

        storage.update_renames(renames);

        assert!(storage.get_renames("Test").is_some());
        assert!(storage.get_renames("Other").is_none());
    }
}
