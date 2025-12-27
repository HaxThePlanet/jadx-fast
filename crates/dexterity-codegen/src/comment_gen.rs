//! Code comment generation utilities
//!
//! JADX Clone: jadx-core/src/main/java/jadx/core/codegen/utils/CodeGenUtils.java
//!
//! This module provides utilities for emitting code comments during code generation.
//! It handles multi-line comments with proper formatting according to the comment style.
//!
//! ## Comment Escaping (GAP-17 Fix)
//!
//! When text contains `*/` sequences, they are escaped to `*\/` to prevent
//! premature closing of block comments. This matches JADX behavior.

use dexterity_ir::attributes::{CodeComment, CodeCommentsAttr, CommentStyle};

use crate::class_gen::CommentsLevel;
use crate::writer::CodeWriter;

/// Escape comment text to prevent premature closing of block comments.
///
/// GAP-17 Fix: Replaces `*/` with `*\/` to prevent breaking block comments.
///
/// JADX Reference: InsnGen.java comment escaping
pub fn escape_comment_text(text: &str) -> String {
    // Escape */ to prevent premature comment closing
    text.replace("*/", "*\\/")
}

/// Add code comments to the output.
///
/// JADX Clone: CodeGenUtils.addCodeComments()
/// Reference: jadx-core/src/main/java/jadx/core/codegen/utils/CodeGenUtils.java:30-50
///
/// # Arguments
/// * `code` - The code writer to output to
/// * `comments` - The comments attribute (if any)
/// * `start_new_line` - Whether to start on a new line (true for declarations, false for inline)
/// * `comments_level` - The current comments verbosity level
pub fn add_code_comments<W: CodeWriter>(
    code: &mut W,
    comments: Option<&CodeCommentsAttr>,
    start_new_line: bool,
    comments_level: CommentsLevel,
) {
    let Some(attr) = comments else { return };
    if attr.is_empty() {
        return;
    }

    // UserOnly and above shows user-provided comments
    if !comments_level.should_show(CommentsLevel::UserOnly) {
        return;
    }

    for comment in attr.iter() {
        add_single_comment(code, comment, start_new_line);
    }
}

/// Add a single comment to the output.
///
/// # Arguments
/// * `code` - The code writer to output to
/// * `comment` - The comment to add
/// * `start_new_line` - Whether to start on a new line
fn add_single_comment<W: CodeWriter>(
    code: &mut W,
    comment: &CodeComment,
    start_new_line: bool,
) {
    if start_new_line {
        code.start_line();
    } else {
        code.add(" ");
    }

    let style = &comment.style;

    // Handle single-line vs multi-line comments
    if comment.comment.contains('\n') {
        // Multi-line comment
        emit_multiline_comment(code, &comment.comment, style);
    } else {
        // Single-line comment
        emit_single_line_comment(code, &comment.comment, style);
    }
}

/// Emit a single-line comment.
fn emit_single_line_comment<W: CodeWriter>(
    code: &mut W,
    text: &str,
    style: &CommentStyle,
) {
    code.add(style.start());
    // GAP-17 Fix: Escape */ in block comments to prevent premature closing
    if matches!(style, CommentStyle::Block | CommentStyle::BlockCondensed) {
        code.add(&escape_comment_text(text));
    } else {
        code.add(text);
    }
    code.add(style.end());
}

/// Emit a multi-line comment with proper formatting.
///
/// JADX Clone: CodeGenUtils.appendMultiLineString()
fn emit_multiline_comment<W: CodeWriter>(
    code: &mut W,
    text: &str,
    style: &CommentStyle,
) {
    // GAP-17 Fix: Escape */ in block comments to prevent premature closing
    let escaped_text;
    let text_to_use = if matches!(style, CommentStyle::Block | CommentStyle::BlockCondensed) {
        escaped_text = escape_comment_text(text);
        &escaped_text
    } else {
        text
    };

    let lines: Vec<&str> = text_to_use.lines().collect();
    if lines.is_empty() {
        return;
    }

    // For line comments, each line is separate
    if matches!(style, CommentStyle::Line) {
        for (i, line) in lines.iter().enumerate() {
            if i > 0 {
                code.start_line();
            }
            code.add(style.start());
            code.add(line);
        }
        return;
    }

    // For block comments, use proper wrapping
    code.add(style.start());
    code.add(lines[0]);

    for line in &lines[1..] {
        code.newline();
        code.add(style.on_new_line());
        code.add(line);
    }

    code.add(style.end());
}

/// Add a simple comment directly (convenience method).
///
/// This is useful when you just need to add a quick comment without
/// going through the attribute system.
///
/// # Arguments
/// * `code` - The code writer
/// * `text` - The comment text
/// * `style` - The comment style to use
/// * `start_new_line` - Whether to start on a new line
pub fn add_comment<W: CodeWriter>(
    code: &mut W,
    text: &str,
    style: CommentStyle,
    start_new_line: bool,
) {
    let comment = CodeComment::new(text, style);
    add_single_comment(code, &comment, start_new_line);
}

/// Add a condensed block comment: `/* text */`
pub fn add_block_comment<W: CodeWriter>(code: &mut W, text: &str, start_new_line: bool) {
    add_comment(code, text, CommentStyle::BlockCondensed, start_new_line);
}

/// Add a line comment: `// text`
pub fn add_line_comment<W: CodeWriter>(code: &mut W, text: &str) {
    add_comment(code, text, CommentStyle::Line, true);
}

/// Add an info-level comment (/* loaded from: ... */, /* renamed from: ... */).
///
/// Only emits if `comments_level` is at least `Info`.
pub fn add_info_comment<W: CodeWriter>(
    code: &mut W,
    text: &str,
    comments_level: CommentsLevel,
) {
    if comments_level.show_info() {
        add_block_comment(code, text, true);
    }
}

/// Add a warning comment (/* WARNING: ... */).
///
/// Only emits if `comments_level` is at least `Warn`.
pub fn add_warn_comment<W: CodeWriter>(
    code: &mut W,
    text: &str,
    comments_level: CommentsLevel,
) {
    if comments_level.show_warn() {
        add_block_comment(code, &format!("Dexterity WARNING: {}", text), true);
    }
}

/// Add an error comment (/* ERROR: ... */).
///
/// Only emits if `comments_level` is at least `Error`.
pub fn add_error_comment<W: CodeWriter>(
    code: &mut W,
    text: &str,
    comments_level: CommentsLevel,
) {
    if comments_level.show_error() {
        add_block_comment(code, &format!("Dexterity ERROR: {}", text), true);
    }
}

// ====================
// GAP-USAGE-COMMENTS: Usage Information Comments
// ====================
// JADX Reference: ClassGen.java:825-857

/// Add class usage info comments (debug level).
///
/// GAP-USAGE-COMMENTS Fix: Adds comments showing class dependencies and usages.
///
/// JADX Reference: ClassGen.java:addClassUsageInfo()
///
/// # Arguments
/// * `code` - The code writer
/// * `deps` - Classes this class depends on (as display strings)
/// * `use_in` - Classes that use this class (as display strings)
/// * `use_in_methods` - Methods that use this class (as display strings)
/// * `comments_level` - Current comments level
pub fn add_class_usage_info<W: CodeWriter>(
    code: &mut W,
    deps: &[String],
    use_in: &[String],
    use_in_methods: &[String],
    comments_level: CommentsLevel,
) {
    if !comments_level.show_debug() {
        return;
    }

    // Dependencies
    code.start_line();
    code.add(&format!("// deps - {}", deps.len()));
    for dep in deps {
        code.start_line();
        code.add(&format!("//  {}", dep));
    }

    // Class usage
    code.start_line();
    code.add(&format!("// use in - {}", use_in.len()));
    for cls in use_in {
        code.start_line();
        code.add(&format!("//  {}", cls));
    }

    // Method usage
    code.start_line();
    code.add(&format!("// use in methods - {}", use_in_methods.len()));
    for mth in use_in_methods {
        code.start_line();
        code.add(&format!("//  {}", mth));
    }
}

/// Add method usage info comments (debug level).
///
/// GAP-USAGE-COMMENTS Fix: Adds comments showing where a method is called from.
///
/// JADX Reference: ClassGen.java:addMthUsageInfo()
///
/// # Arguments
/// * `code` - The code writer
/// * `use_in_methods` - Methods that call this method (as display strings)
/// * `comments_level` - Current comments level
pub fn add_method_usage_info<W: CodeWriter>(
    code: &mut W,
    use_in_methods: &[String],
    comments_level: CommentsLevel,
) {
    if !comments_level.show_debug() {
        return;
    }

    code.start_line();
    code.add(&format!("// use in methods - {}", use_in_methods.len()));
    for mth in use_in_methods {
        code.start_line();
        code.add(&format!("//  {}", mth));
    }
}

/// Add field usage info comments (debug level).
///
/// GAP-USAGE-COMMENTS Fix: Adds comments showing where a field is used.
///
/// JADX Reference: ClassGen.java:addFieldUsageInfo()
///
/// # Arguments
/// * `code` - The code writer
/// * `use_in_methods` - Methods that use this field (as display strings)
/// * `comments_level` - Current comments level
pub fn add_field_usage_info<W: CodeWriter>(
    code: &mut W,
    use_in_methods: &[String],
    comments_level: CommentsLevel,
) {
    if !comments_level.show_debug() {
        return;
    }

    code.start_line();
    code.add(&format!("// use in methods - {}", use_in_methods.len()));
    for mth in use_in_methods {
        code.start_line();
        code.add(&format!("//  {}", mth));
    }
}

#[cfg(test)]
mod tests {
    use super::*;
    use crate::writer::SimpleCodeWriter;

    #[test]
    fn test_block_comment() {
        let mut writer = SimpleCodeWriter::new();
        add_block_comment(&mut writer, "test comment", true);
        assert_eq!(writer.finish(), "/* test comment */");
    }

    #[test]
    fn test_line_comment() {
        let mut writer = SimpleCodeWriter::new();
        add_line_comment(&mut writer, "test comment");
        assert_eq!(writer.finish(), "// test comment");
    }

    #[test]
    fn test_multiline_line_comment() {
        let mut writer = SimpleCodeWriter::new();
        add_comment(&mut writer, "line1\nline2\nline3", CommentStyle::Line, true);
        assert_eq!(writer.finish(), "// line1\n// line2\n// line3");
    }

    #[test]
    fn test_multiline_block_comment() {
        let mut writer = SimpleCodeWriter::new();
        add_comment(&mut writer, "line1\nline2", CommentStyle::Block, true);
        assert_eq!(writer.finish(), "/*\n * line1\n * line2\n */");
    }

    #[test]
    fn test_code_comments_attr() {
        let mut writer = SimpleCodeWriter::new();
        let mut attr = CodeCommentsAttr::new();
        attr.add_block("comment 1");
        attr.add_line("comment 2");

        add_code_comments(&mut writer, Some(&attr), true, CommentsLevel::Info);
        let result = writer.finish();

        assert!(result.contains("/* comment 1 */"));
        assert!(result.contains("// comment 2"));
    }

    #[test]
    fn test_comments_level_filtering() {
        let mut writer = SimpleCodeWriter::new();
        let mut attr = CodeCommentsAttr::new();
        attr.add_block("test");

        // CommentsLevel::None should not show any comments
        add_code_comments(&mut writer, Some(&attr), true, CommentsLevel::None);
        assert_eq!(writer.finish(), "");
    }

    /// GAP-17 Fix: Test that */ sequences are escaped in block comments
    #[test]
    fn test_comment_escape_block_comment() {
        let mut writer = SimpleCodeWriter::new();
        add_block_comment(&mut writer, "string contains */ which breaks", true);
        // The */ should be escaped to *\/
        assert_eq!(writer.finish(), "/* string contains *\\/ which breaks */");
    }

    /// GAP-17 Fix: Test that */ is NOT escaped in line comments (no need)
    #[test]
    fn test_comment_escape_line_comment() {
        let mut writer = SimpleCodeWriter::new();
        add_line_comment(&mut writer, "string contains */ which is fine in line comments");
        // Line comments don't need escaping for */
        assert_eq!(writer.finish(), "// string contains */ which is fine in line comments");
    }

    #[test]
    fn test_escape_comment_text() {
        assert_eq!(escape_comment_text("no escaping needed"), "no escaping needed");
        assert_eq!(escape_comment_text("has */ in it"), "has *\\/ in it");
        assert_eq!(escape_comment_text("multiple */ and */ here"), "multiple *\\/ and *\\/ here");
    }

    // GAP-USAGE-COMMENTS: Usage comment tests

    #[test]
    fn test_class_usage_info_debug() {
        let mut writer = SimpleCodeWriter::new();
        let deps = vec!["com.example.Dep1".to_string(), "com.example.Dep2".to_string()];
        let use_in = vec!["com.example.User".to_string()];
        let use_in_methods = vec!["com.example.Foo.bar()".to_string()];

        add_class_usage_info(&mut writer, &deps, &use_in, &use_in_methods, CommentsLevel::Debug);
        let result = writer.finish();

        assert!(result.contains("// deps - 2"));
        assert!(result.contains("//  com.example.Dep1"));
        assert!(result.contains("// use in - 1"));
        assert!(result.contains("// use in methods - 1"));
    }

    #[test]
    fn test_class_usage_info_not_debug() {
        let mut writer = SimpleCodeWriter::new();
        add_class_usage_info(&mut writer, &[], &[], &[], CommentsLevel::Info);
        assert_eq!(writer.finish(), "");
    }

    #[test]
    fn test_field_usage_info() {
        let mut writer = SimpleCodeWriter::new();
        let methods = vec![
            "com.example.Foo.bar()".to_string(),
            "com.example.Baz.qux()".to_string(),
        ];

        add_field_usage_info(&mut writer, &methods, CommentsLevel::Debug);
        let result = writer.finish();

        assert!(result.contains("// use in methods - 2"));
        assert!(result.contains("//  com.example.Foo.bar()"));
    }

    #[test]
    fn test_method_usage_info() {
        let mut writer = SimpleCodeWriter::new();
        let callers = vec!["com.example.Caller.call()".to_string()];

        add_method_usage_info(&mut writer, &callers, CommentsLevel::Debug);
        let result = writer.finish();

        assert!(result.contains("// use in methods - 1"));
        assert!(result.contains("//  com.example.Caller.call()"));
    }
}
