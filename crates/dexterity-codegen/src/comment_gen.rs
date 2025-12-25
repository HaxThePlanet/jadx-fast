//! Code comment generation utilities
//!
//! JADX Clone: jadx-core/src/main/java/jadx/core/codegen/utils/CodeGenUtils.java
//!
//! This module provides utilities for emitting code comments during code generation.
//! It handles multi-line comments with proper formatting according to the comment style.

use dexterity_ir::attributes::{CodeComment, CodeCommentsAttr, CommentStyle};

use crate::class_gen::CommentsLevel;
use crate::writer::CodeWriter;

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
    code.add(text);
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
    let lines: Vec<&str> = text.lines().collect();
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
}
