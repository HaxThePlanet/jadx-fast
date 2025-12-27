//! Attach diagnostic comments to IR nodes
//!
//! JADX Clone: jadx-core/src/main/java/jadx/core/dex/visitors/AttachCommentsVisitor.java
//!
//! This pass counts diagnostic information (warnings, errors, deobfuscation info,
//! source file references) that will be emitted during code generation.
//!
//! Note: Class/field/method level comments are currently emitted inline during codegen
//! (in class_gen.rs and method_gen.rs). This pass primarily tracks instruction-level
//! comments that are attached to InsnNode.attrs during analysis passes.
//!
//! ## Comment Sources
//!
//! | Level | Comment Type | Source |
//! |-------|-------------|--------|
//! | Class | `/* loaded from: X.java */` | Inline in class_gen.rs |
//! | Class | `/* renamed from: pkg.Cls */` | Inline in class_gen.rs |
//! | Field | `/* renamed from: f */` | Inline in class_gen.rs |
//! | Method | `/* renamed from: m */` | Inline in method_gen.rs |
//! | Insn | Type inference warnings | InsnNode.attrs.CodeCommentsAttr |
//!
//! ## Future Work
//!
//! To fully implement JADX parity, ClassData/FieldData/MethodData would need
//! an `attrs: AttributeStorage` field (like InsnNode has). Then this pass
//! could attach CodeCommentsAttr to those nodes for unified comment handling.

use dexterity_ir::{ClassData, MethodData};

/// Result of attach comments pass
#[derive(Debug, Default, Clone)]
pub struct AttachCommentsResult {
    /// Number of classes with source file info (will get "loaded from" comment)
    pub classes_with_source: usize,
    /// Number of classes with rename info (will get "renamed from" comment)
    pub classes_renamed: usize,
    /// Number of fields with rename info
    pub fields_renamed: usize,
    /// Number of methods with rename info
    pub methods_renamed: usize,
    /// Number of instructions with code comments attached
    pub insn_comments: usize,
}

impl AttachCommentsResult {
    /// Total comment opportunities found
    pub fn total(&self) -> usize {
        self.classes_with_source
            + self.classes_renamed
            + self.fields_renamed
            + self.methods_renamed
            + self.insn_comments
    }
}

/// Analyze a class for diagnostic comments.
///
/// This pass counts the diagnostic comments that will be emitted during codegen.
/// Class/field/method level comments are emitted inline in codegen, while
/// instruction-level comments are attached to InsnNode.attrs.
///
/// # Arguments
/// * `class` - The class to analyze
///
/// # Returns
/// Statistics about comments that will be emitted
pub fn attach_comments(class: &ClassData) -> AttachCommentsResult {
    let mut result = AttachCommentsResult::default();

    // Count class-level comment sources
    if class.source_file.is_some() {
        result.classes_with_source += 1;
    }

    // Check if class has an alias (renamed)
    if class.alias.is_some() {
        result.classes_renamed += 1;
    }

    // Count field renames
    for field in class.static_fields.iter().chain(class.instance_fields.iter()) {
        if field.alias.is_some() {
            result.fields_renamed += 1;
        }
    }

    // Count method renames and instruction comments
    for method in &class.methods {
        count_method_comments(method, &mut result);
    }

    result
}

/// Count comments for a method and its instructions.
fn count_method_comments(method: &MethodData, result: &mut AttachCommentsResult) {
    // Check if method has an alias (renamed)
    if method.alias.is_some() {
        result.methods_renamed += 1;
    }

    // Count instruction-level comments
    if let Some(insns) = &method.instructions {
        for insn in insns {
            if insn.has_code_comments() {
                result.insn_comments += 1;
            }
        }
    }
}

#[cfg(test)]
mod tests {
    use super::*;

    // ACC_PUBLIC = 0x0001
    const ACC_PUBLIC: u32 = 0x0001;

    #[test]
    fn test_count_source_file() {
        let class = ClassData {
            class_type: "Lcom/example/Test;".to_string(),
            source_file: Some("Test.java".to_string()),
            access_flags: ACC_PUBLIC,
            ..Default::default()
        };

        let result = attach_comments(&class);

        assert_eq!(result.classes_with_source, 1);
        assert_eq!(result.classes_renamed, 0);
    }

    #[test]
    fn test_count_renamed_class() {
        let class = ClassData {
            class_type: "Lcom/example/Test;".to_string(),
            alias: Some("RenamedTest".to_string()),
            access_flags: ACC_PUBLIC,
            ..Default::default()
        };

        let result = attach_comments(&class);

        assert_eq!(result.classes_renamed, 1);
    }

    #[test]
    fn test_empty_class() {
        let class = ClassData {
            class_type: "Lcom/example/Test;".to_string(),
            access_flags: ACC_PUBLIC,
            ..Default::default()
        };

        let result = attach_comments(&class);

        assert_eq!(result.total(), 0);
    }
}
