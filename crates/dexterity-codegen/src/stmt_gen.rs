//! Statement generation - converts IR instructions to Java statements
//!
//! This module generates Java statements from IR instructions.
//! Works with expr_gen for expressions within statements.

use dexterity_ir::instructions::{InsnArg, InsnType, RegisterArg};
use dexterity_ir::ArgType;

use crate::expr_gen::ExprGen;
use crate::type_gen::type_to_string;
use crate::writer::CodeWriter;

/// Statement generator using expression generator context
pub struct StmtGen<'a> {
    expr: &'a ExprGen,
}

impl<'a> StmtGen<'a> {
    /// Create a new statement generator
    pub fn new(expr: &'a ExprGen) -> Self {
        StmtGen { expr }
    }

    /// Generate a variable declaration with assignment
    /// Format: Type varName = expr;
    pub fn gen_var_decl<W: CodeWriter>(
        &self,
        dest: &RegisterArg,
        ty: &ArgType,
        expr_str: &str,
        code: &mut W,
    ) {
        let var_name = self.expr.get_var_name(dest);
        let type_str = type_to_string(ty);
        code.start_line()
            .add(&type_str)
            .add(" ")
            .add(&var_name)
            .add(" = ")
            .add(expr_str)
            .add(";")
            .newline();
    }

    /// Generate an assignment statement
    /// Format: varName = expr;
    pub fn gen_assign<W: CodeWriter>(
        &self,
        dest: &RegisterArg,
        expr_str: &str,
        code: &mut W,
    ) {
        let var_name = self.expr.get_var_name(dest);
        code.start_line()
            .add(&var_name)
            .add(" = ")
            .add(expr_str)
            .add(";")
            .newline();
    }

    /// Generate a return statement
    /// Format: return; or return expr;
    pub fn gen_return<W: CodeWriter>(
        &self,
        value: Option<&InsnArg>,
        code: &mut W,
    ) {
        code.start_line().add("return");
        if let Some(v) = value {
            code.add(" ");
            self.expr.write_arg(code, v);
        }
        code.add(";").newline();
    }

    /// Generate a throw statement
    /// Format: throw expr;
    pub fn gen_throw<W: CodeWriter>(
        &self,
        exception: &InsnArg,
        code: &mut W,
    ) {
        code.start_line().add("throw ");
        self.expr.write_arg(code, exception);
        code.add(";").newline();
    }

    /// Generate array put statement
    /// Format: array[index] = value;
    pub fn gen_array_put<W: CodeWriter>(
        &self,
        array: &InsnArg,
        index: &InsnArg,
        value: &InsnArg,
        code: &mut W,
    ) {
        code.start_line();
        self.expr.write_arg(code, array);
        code.add("[");
        self.expr.write_arg(code, index);
        code.add("] = ");
        self.expr.write_arg(code, value);
        code.add(";").newline();
    }

    /// Generate instance field put statement
    /// Format: object.field = value; or this.field = value;
    pub fn gen_instance_put<W: CodeWriter>(
        &self,
        object: &InsnArg,
        field_name: &str,
        value: &InsnArg,
        code: &mut W,
    ) {
        code.start_line();
        // Use "this." prefix explicitly like JADX when writing to own fields
        let obj_str = self.expr.gen_arg(object);
        if obj_str == "this" {
            code.add("this");
        } else {
            self.expr.write_arg(code, object);
        }
        code.add(".").add(field_name).add(" = ");
        self.expr.write_arg(code, value);
        code.add(";").newline();
    }

    /// Generate static field put statement
    /// Format: ClassName.field = value;
    pub fn gen_static_put<W: CodeWriter>(
        &self,
        class_name: &str,
        field_name: &str,
        value: &InsnArg,
        code: &mut W,
    ) {
        code.start_line()
            .add(class_name)
            .add(".")
            .add(field_name)
            .add(" = ");
        self.expr.write_arg(code, value);
        code.add(";").newline();
    }

    /// Generate method call as statement (ignoring return value)
    /// Format: expr.method(args); or method(args);
    pub fn gen_invoke_stmt<W: CodeWriter>(
        &self,
        invoke_expr: &str,
        code: &mut W,
    ) {
        code.start_line()
            .add(invoke_expr)
            .add(";")
            .newline();
    }

    /// Generate monitor enter (synchronized block start)
    pub fn gen_monitor_enter<W: CodeWriter>(
        &self,
        object: &InsnArg,
        code: &mut W,
    ) {
        code.start_line().add("synchronized (");
        self.expr.write_arg(code, object);
        code.add(") {").newline();
        code.inc_indent();
    }

    /// Generate monitor exit (synchronized block end)
    pub fn gen_monitor_exit<W: CodeWriter>(
        &self,
        _object: &InsnArg,
        code: &mut W,
    ) {
        code.dec_indent();
        code.start_line().add("}").newline();
    }

    /// Generate statement from IR instruction (returns true if handled)
    pub fn gen_stmt<W: CodeWriter>(
        &self,
        insn: &InsnType,
        result_type: Option<&ArgType>,
        code: &mut W,
    ) -> bool {
        match insn {
            InsnType::Return { value } => {
                self.gen_return(value.as_ref(), code);
                true
            }

            InsnType::Throw { exception } => {
                self.gen_throw(exception, code);
                true
            }

            InsnType::ArrayPut { array, index, value, .. } => {
                self.gen_array_put(array, index, value, code);
                true
            }

            InsnType::InstancePut { object, field_idx, value } => {
                // Try to get field name, fallback to field#N
                let field_name = format!("field#{}", field_idx);
                self.gen_instance_put(object, &field_name, value, code);
                true
            }

            InsnType::StaticPut { field_idx, value } => {
                // Try to get class/field name, fallback
                let class_name = format!("Class#{}", field_idx);
                let field_name = format!("field#{}", field_idx);
                self.gen_static_put(&class_name, &field_name, value, code);
                true
            }

            InsnType::MonitorEnter { object: _ } => {
                // MonitorEnter is handled at the region level (Region::Synchronized)
                // Don't emit code here - just mark as handled
                true
            }

            InsnType::MonitorExit { object: _ } => {
                // MonitorExit is handled at the region level (Region::Synchronized)
                // Don't emit code here - just mark as handled
                true
            }

            InsnType::FillArrayData { array, payload_offset, element_width, data } => {
                if data.is_empty() {
                    // Payload not parsed, emit placeholder comment
                    code.start_line()
                        .add("/* fill-array-data ")
                        .add(&self.expr.gen_arg(array))
                        .add(" at offset ")
                        .add(&payload_offset.to_string())
                        .add(" */")
                        .newline();
                } else {
                    // Generate array element assignments
                    let array_name = self.expr.gen_arg(array);
                    for (i, value) in data.iter().enumerate() {
                        code.start_line();
                        code.add(&array_name)
                            .add("[")
                            .add(&i.to_string())
                            .add("] = ");
                        // Format value based on element width
                        match element_width {
                            1 => code.add(&format!("(byte) {}", *value as i8)),
                            2 => {
                                // Could be short or char - use short for now
                                code.add(&format!("(short) {}", *value as i16))
                            }
                            4 => code.add(&value.to_string()),
                            8 => code.add(&format!("{}L", value)),
                            _ => code.add(&value.to_string()),
                        };
                        code.add(";").newline();
                    }
                }
                true
            }

            // Expressions that produce a result - generate assignment
            InsnType::Const { dest, .. }
            | InsnType::ConstString { dest, .. }
            | InsnType::ConstClass { dest, .. }
            | InsnType::Move { dest, .. }
            | InsnType::MoveResult { dest }
            | InsnType::MoveException { dest }
            | InsnType::NewInstance { dest, .. }
            | InsnType::NewArray { dest, .. }
            | InsnType::ArrayLength { dest, .. }
            | InsnType::ArrayGet { dest, .. }
            | InsnType::InstanceOf { dest, .. }
            | InsnType::InstanceGet { dest, .. }
            | InsnType::StaticGet { dest, .. }
            | InsnType::Unary { dest, .. }
            | InsnType::Binary { dest, .. }
            | InsnType::Cast { dest, .. }
            | InsnType::Compare { dest, .. } => {
                if let Some(expr_str) = self.expr.gen_insn(insn) {
                    if let Some(ty) = result_type {
                        self.gen_var_decl(dest, ty, &expr_str, code);
                    } else {
                        self.gen_assign(dest, &expr_str, code);
                    }
                    true
                } else {
                    false
                }
            }

            InsnType::FilledNewArray { dest, .. } => {
                if let Some(expr_str) = self.expr.gen_insn(insn) {
                    if let Some(d) = dest {
                        if let Some(ty) = result_type {
                            self.gen_var_decl(d, ty, &expr_str, code);
                        } else {
                            self.gen_assign(d, &expr_str, code);
                        }
                    }
                    true
                } else {
                    false
                }
            }

            InsnType::Invoke { .. } => {
                // Invoke can be expression or statement
                if let Some(expr_str) = self.expr.gen_insn(insn) {
                    self.gen_invoke_stmt(&expr_str, code);
                    true
                } else {
                    false
                }
            }

            InsnType::CheckCast { object: _, type_idx: _ } => {
                // Check-cast is usually implicit after assignment
                // Generate a comment for now
                if let Some(expr_str) = self.expr.gen_insn(insn) {
                    code.start_line()
                        .add("/* check-cast: ")
                        .add(&expr_str)
                        .add(" */")
                        .newline();
                }
                true
            }

            // Control flow - handled by region/block gen
            InsnType::If { .. }
            | InsnType::Goto { .. }
            | InsnType::PackedSwitch { .. }
            | InsnType::SparseSwitch { .. } => false,

            // SSA-specific
            InsnType::Phi { .. } => false,

            InsnType::Nop => true, // No-op, nothing to generate

            // Break/Continue - generate the statement
            InsnType::Break { label } => {
                code.start_line();
                if let Some(lbl) = label {
                    code.add("break ").add(lbl).add(";");
                } else {
                    code.add("break;");
                }
                code.newline();
                true
            }
            InsnType::Continue { label } => {
                code.start_line();
                if let Some(lbl) = label {
                    code.add("continue ").add(lbl).add(";");
                } else {
                    code.add("continue;");
                }
                code.newline();
                true
            }
        }
    }
}

/// Generate if statement header
pub fn gen_if_header<W: CodeWriter>(condition: &str, code: &mut W) {
    code.start_line()
        .add("if (")
        .add(condition)
        .add(") {")
        .newline();
    code.inc_indent();
}

/// Generate else clause
pub fn gen_else<W: CodeWriter>(code: &mut W) {
    code.dec_indent();
    code.start_line().add("} else {").newline();
    code.inc_indent();
}

/// Generate else-if clause
pub fn gen_else_if<W: CodeWriter>(condition: &str, code: &mut W) {
    code.dec_indent();
    code.start_line()
        .add("} else if (")
        .add(condition)
        .add(") {")
        .newline();
    code.inc_indent();
}

/// Close a block (if/else/while/for/etc)
pub fn gen_close_block<W: CodeWriter>(code: &mut W) {
    code.dec_indent();
    code.start_line().add("}").newline();
}

/// Generate while loop header
pub fn gen_while_header<W: CodeWriter>(condition: &str, code: &mut W) {
    code.start_line()
        .add("while (")
        .add(condition)
        .add(") {")
        .newline();
    code.inc_indent();
}

/// Generate do-while loop start
pub fn gen_do_while_start<W: CodeWriter>(code: &mut W) {
    code.start_line().add("do {").newline();
    code.inc_indent();
}

/// Generate do-while loop end
pub fn gen_do_while_end<W: CodeWriter>(condition: &str, code: &mut W) {
    code.dec_indent();
    code.start_line()
        .add("} while (")
        .add(condition)
        .add(");")
        .newline();
}

/// Generate for loop header
pub fn gen_for_header<W: CodeWriter>(
    init: &str,
    condition: &str,
    update: &str,
    code: &mut W,
) {
    code.start_line()
        .add("for (")
        .add(init)
        .add("; ")
        .add(condition)
        .add("; ")
        .add(update)
        .add(") {")
        .newline();
    code.inc_indent();
}

/// Generate enhanced for loop header
pub fn gen_foreach_header<W: CodeWriter>(
    var_type: &str,
    var_name: &str,
    iterable: &str,
    code: &mut W,
) {
    code.start_line()
        .add("for (")
        .add(var_type)
        .add(" ")
        .add(var_name)
        .add(" : ")
        .add(iterable)
        .add(") {")
        .newline();
    code.inc_indent();
}

/// Generate switch statement header
pub fn gen_switch_header<W: CodeWriter>(value: &str, code: &mut W) {
    code.start_line()
        .add("switch (")
        .add(value)
        .add(") {")
        .newline();
    code.inc_indent();
}

/// Generate switch case
pub fn gen_case<W: CodeWriter>(value: i32, code: &mut W) {
    // Don't use start_line's indent - cases align with switch
    code.dec_indent();
    code.start_line()
        .add("case ")
        .add(&value.to_string())
        .add(":")
        .newline();
    code.inc_indent();
}

/// Generate default case
pub fn gen_default_case<W: CodeWriter>(code: &mut W) {
    code.dec_indent();
    code.start_line().add("default:").newline();
    code.inc_indent();
}

/// Generate break statement
pub fn gen_break<W: CodeWriter>(code: &mut W) {
    code.start_line().add("break;").newline();
}

/// Generate continue statement
pub fn gen_continue<W: CodeWriter>(code: &mut W) {
    code.start_line().add("continue;").newline();
}

/// Generate try block start
pub fn gen_try_start<W: CodeWriter>(code: &mut W) {
    code.start_line().add("try {").newline();
    code.inc_indent();
}

/// Generate catch clause
pub fn gen_catch<W: CodeWriter>(
    exception_type: &str,
    var_name: &str,
    code: &mut W,
) {
    code.dec_indent();
    code.start_line()
        .add("} catch (")
        .add(exception_type)
        .add(" ")
        .add(var_name)
        .add(") {")
        .newline();
    code.inc_indent();
}

/// Generate finally clause
pub fn gen_finally<W: CodeWriter>(code: &mut W) {
    code.dec_indent();
    code.start_line().add("} finally {").newline();
    code.inc_indent();
}

/// Generate a label
pub fn gen_label<W: CodeWriter>(label: &str, code: &mut W) {
    // Labels are typically outdented one level
    code.dec_indent();
    code.start_line().add(label).add(":").newline();
    code.inc_indent();
}

/// Generate goto (as labeled break for structured code)
pub fn gen_labeled_break<W: CodeWriter>(label: &str, code: &mut W) {
    code.start_line()
        .add("break ")
        .add(label)
        .add(";")
        .newline();
}

#[cfg(test)]
mod tests {
    use super::*;
    use crate::writer::SimpleCodeWriter;

    fn make_expr_gen() -> ExprGen {
        let mut gen = ExprGen::new();
        // Disable deobfuscation renaming for tests (don't rename short var names like v0, v5)
        gen.set_deobf_limits(0, 64);
        gen
    }

    #[test]
    fn test_return_void() {
        let expr = make_expr_gen();
        let stmt = StmtGen::new(&expr);
        let mut writer = SimpleCodeWriter::new();
        stmt.gen_return(None, &mut writer);
        assert_eq!(writer.finish().trim(), "return;");
    }

    #[test]
    fn test_return_value() {
        let expr = make_expr_gen();
        let stmt = StmtGen::new(&expr);
        let mut writer = SimpleCodeWriter::new();
        let arg = InsnArg::reg(0);
        stmt.gen_return(Some(&arg), &mut writer);
        assert_eq!(writer.finish().trim(), "return obj0;");
    }

    #[test]
    fn test_throw() {
        let expr = make_expr_gen();
        let stmt = StmtGen::new(&expr);
        let mut writer = SimpleCodeWriter::new();
        let exception = InsnArg::reg(5);
        stmt.gen_throw(&exception, &mut writer);
        assert_eq!(writer.finish().trim(), "throw obj5;");
    }

    #[test]
    fn test_array_put() {
        let expr = make_expr_gen();
        let stmt = StmtGen::new(&expr);
        let mut writer = SimpleCodeWriter::new();
        let array = InsnArg::reg(0);
        let index = InsnArg::lit(5);
        let value = InsnArg::reg(1);
        stmt.gen_array_put(&array, &index, &value, &mut writer);
        assert_eq!(writer.finish().trim(), "obj0[5] = obj1;");
    }

    #[test]
    fn test_if_else() {
        let mut writer = SimpleCodeWriter::new();
        gen_if_header("x > 0", &mut writer);
        writer.start_line().add("doSomething();").newline();
        gen_else(&mut writer);
        writer.start_line().add("doOther();").newline();
        gen_close_block(&mut writer);

        let code = writer.finish();
        assert!(code.contains("if (x > 0) {"));
        assert!(code.contains("} else {"));
        assert!(code.contains("}"));
    }

    #[test]
    fn test_else_if_chain() {
        let mut writer = SimpleCodeWriter::new();
        gen_if_header("x > 10", &mut writer);
        writer.start_line().add("doBig();").newline();
        gen_else_if("x > 5", &mut writer);
        writer.start_line().add("doMedium();").newline();
        gen_else_if("x > 0", &mut writer);
        writer.start_line().add("doSmall();").newline();
        gen_else(&mut writer);
        writer.start_line().add("doNone();").newline();
        gen_close_block(&mut writer);

        let code = writer.finish();
        assert!(code.contains("if (x > 10) {"));
        assert!(code.contains("} else if (x > 5) {"));
        assert!(code.contains("} else if (x > 0) {"));
        assert!(code.contains("} else {"));
    }

    #[test]
    fn test_while_loop() {
        let mut writer = SimpleCodeWriter::new();
        gen_while_header("i < 10", &mut writer);
        writer.start_line().add("i++;").newline();
        gen_close_block(&mut writer);

        let code = writer.finish();
        assert!(code.contains("while (i < 10) {"));
    }

    #[test]
    fn test_for_loop() {
        let mut writer = SimpleCodeWriter::new();
        gen_for_header("int i = 0", "i < 10", "i++", &mut writer);
        writer.start_line().add("process(i);").newline();
        gen_close_block(&mut writer);

        let code = writer.finish();
        assert!(code.contains("for (int i = 0; i < 10; i++) {"));
    }

    #[test]
    fn test_foreach_loop() {
        let mut writer = SimpleCodeWriter::new();
        gen_foreach_header("String", "item", "items", &mut writer);
        writer.start_line().add("process(item);").newline();
        gen_close_block(&mut writer);

        let code = writer.finish();
        assert!(code.contains("for (String item : items) {"));
    }

    #[test]
    fn test_switch() {
        let mut writer = SimpleCodeWriter::new();
        gen_switch_header("value", &mut writer);
        gen_case(0, &mut writer);
        writer.start_line().add("handleZero();").newline();
        gen_break(&mut writer);
        gen_case(1, &mut writer);
        writer.start_line().add("handleOne();").newline();
        gen_break(&mut writer);
        gen_default_case(&mut writer);
        writer.start_line().add("handleDefault();").newline();
        gen_close_block(&mut writer);

        let code = writer.finish();
        assert!(code.contains("switch (value) {"));
        assert!(code.contains("case 0:"));
        assert!(code.contains("case 1:"));
        assert!(code.contains("default:"));
    }

    #[test]
    fn test_try_catch() {
        let mut writer = SimpleCodeWriter::new();
        gen_try_start(&mut writer);
        writer.start_line().add("riskyOperation();").newline();
        gen_catch("Exception", "e", &mut writer);
        writer.start_line().add("handleError(e);").newline();
        gen_finally(&mut writer);
        writer.start_line().add("cleanup();").newline();
        gen_close_block(&mut writer);

        let code = writer.finish();
        assert!(code.contains("try {"));
        assert!(code.contains("} catch (Exception e) {"));
        assert!(code.contains("} finally {"));
    }
}
