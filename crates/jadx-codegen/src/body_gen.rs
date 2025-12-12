//! Method body code generation
//!
//! This module generates Java source code for method bodies by:
//! 1. Splitting instructions into basic blocks
//! 2. Building a control flow graph
//! 3. Constructing a region tree (if/else, loops, switches)
//! 4. Walking the region tree to emit structured Java code

use std::collections::BTreeMap;

use jadx_ir::instructions::{InsnNode, InsnType};
use jadx_ir::regions::{LoopKind, Region, RegionContent};
use jadx_ir::types::ArgType;
use jadx_ir::MethodData;
use jadx_passes::block_split::{split_blocks, BasicBlock};
use jadx_passes::cfg::CFG;
use jadx_passes::region_builder::build_regions;

use crate::expr_gen::ExprGen;
use crate::stmt_gen::{
    gen_break, gen_close_block, gen_do_while_end, gen_do_while_start, gen_else, gen_if_header,
    gen_while_header, StmtGen,
};
use crate::writer::CodeWriter;

/// Context for generating method body code
pub struct BodyGenContext {
    /// Expression generator with variable names and type info
    pub expr_gen: ExprGen,
    /// Basic blocks by ID
    pub blocks: BTreeMap<u32, BasicBlock>,
    /// Method return type
    pub return_type: ArgType,
    /// Number of registers
    pub regs_count: u16,
    /// Number of parameter registers
    pub ins_count: u16,
}

impl BodyGenContext {
    /// Create a new body generation context from method data
    pub fn from_method(method: &MethodData) -> Self {
        let mut expr_gen = ExprGen::new();

        // Set up parameter names based on method signature
        // Parameters are in the last `ins_count` registers
        let first_param_reg = method.regs_count.saturating_sub(method.ins_count);
        let is_static = method.is_static();
        let param_offset = if is_static { 0 } else { 1 }; // Skip 'this' for instance methods

        for (i, param_type) in method.arg_types.iter().enumerate() {
            let reg = first_param_reg + param_offset as u16 + i as u16;
            let name = generate_param_name(i, param_type);
            expr_gen.set_var_name(reg, 0, name);
            expr_gen.set_var_type(reg, 0, param_type.clone());
        }

        // Set up 'this' if instance method
        if !is_static && method.ins_count > 0 {
            expr_gen.set_var_name(first_param_reg, 0, "this".to_string());
        }

        BodyGenContext {
            expr_gen,
            blocks: BTreeMap::new(),
            return_type: method.return_type.clone(),
            regs_count: method.regs_count,
            ins_count: method.ins_count,
        }
    }
}

/// Generate method body from instructions
pub fn generate_body<W: CodeWriter>(method: &MethodData, code: &mut W) {
    if method.instructions.is_empty() {
        code.start_line()
            .add("/* empty method */")
            .newline();
        add_default_return(&method.return_type, code);
        return;
    }

    // Split into basic blocks
    let block_result = split_blocks(method.instructions.clone());

    if block_result.blocks.is_empty() {
        code.start_line()
            .add("/* no blocks */")
            .newline();
        add_default_return(&method.return_type, code);
        return;
    }

    // Build CFG and region tree
    let cfg = CFG::from_blocks(block_result);
    let region = build_regions(&cfg);

    // Create generation context
    let mut ctx = BodyGenContext::from_method(method);
    ctx.blocks = cfg_blocks_to_map(&cfg);

    // Generate code from region tree
    generate_region(&region, &ctx, code);
}

/// Convert CFG blocks to a map (borrowing around CFG internals)
fn cfg_blocks_to_map(cfg: &CFG) -> BTreeMap<u32, BasicBlock> {
    let mut map = BTreeMap::new();
    for block_id in cfg.block_ids() {
        if let Some(block) = cfg.get_block(block_id) {
            map.insert(block_id, block.clone());
        }
    }
    map
}

/// Generate code from a region
fn generate_region<W: CodeWriter>(region: &Region, ctx: &BodyGenContext, code: &mut W) {
    match region {
        Region::Sequence(contents) => {
            for content in contents {
                generate_content(content, ctx, code);
            }
        }

        Region::If {
            condition: _,
            then_region,
            else_region,
        } => {
            // Find the condition from the first block that ends with If
            let condition_str = "/* condition */".to_string();

            gen_if_header(&condition_str, code);
            generate_region(then_region, ctx, code);

            if let Some(else_reg) = else_region {
                gen_else(code);
                generate_region(else_reg, ctx, code);
            }

            gen_close_block(code);
        }

        Region::Loop {
            kind,
            condition: _,
            body,
        } => {
            match kind {
                LoopKind::While | LoopKind::For => {
                    gen_while_header("/* condition */", code);
                    generate_region(body, ctx, code);
                    gen_close_block(code);
                }
                LoopKind::DoWhile => {
                    gen_do_while_start(code);
                    generate_region(body, ctx, code);
                    gen_do_while_end("/* condition */", code);
                }
                LoopKind::Endless => {
                    gen_while_header("true", code);
                    generate_region(body, ctx, code);
                    gen_close_block(code);
                }
                LoopKind::ForEach => {
                    // TODO: Detect foreach patterns
                    gen_while_header("/* iterator.hasNext() */", code);
                    generate_region(body, ctx, code);
                    gen_close_block(code);
                }
            }
        }

        Region::Switch { cases, default } => {
            code.start_line().add("switch (/* value */) {").newline();
            code.inc_indent();

            for case in cases {
                for key in &case.keys {
                    code.start_line()
                        .add("case ")
                        .add(&key.to_string())
                        .add(":")
                        .newline();
                }
                code.inc_indent();
                generate_region(&case.region, ctx, code);
                gen_break(code);
                code.dec_indent();
            }

            if let Some(def) = default {
                code.start_line().add("default:").newline();
                code.inc_indent();
                generate_region(def, ctx, code);
                code.dec_indent();
            }

            code.dec_indent();
            code.start_line().add("}").newline();
        }

        Region::TryCatch {
            try_region,
            handlers,
            finally,
        } => {
            code.start_line().add("try {").newline();
            code.inc_indent();
            generate_region(try_region, ctx, code);
            code.dec_indent();

            for handler in handlers {
                let exc_type = handler
                    .exception_type
                    .as_deref()
                    .unwrap_or("Exception");
                code.start_line()
                    .add("} catch (")
                    .add(exc_type)
                    .add(" e) {")
                    .newline();
                code.inc_indent();
                generate_region(&handler.region, ctx, code);
                code.dec_indent();
            }

            if let Some(fin) = finally {
                code.start_line().add("} finally {").newline();
                code.inc_indent();
                generate_region(fin, ctx, code);
                code.dec_indent();
            }

            code.start_line().add("}").newline();
        }

        Region::Synchronized { body } => {
            code.start_line()
                .add("synchronized (/* lock */) {")
                .newline();
            code.inc_indent();
            generate_region(body, ctx, code);
            code.dec_indent();
            code.start_line().add("}").newline();
        }
    }
}

/// Generate code from region content (block or nested region)
fn generate_content<W: CodeWriter>(content: &RegionContent, ctx: &BodyGenContext, code: &mut W) {
    match content {
        RegionContent::Block(block_id) => {
            if let Some(block) = ctx.blocks.get(block_id) {
                generate_block(block, ctx, code);
            }
        }
        RegionContent::Region(region) => {
            generate_region(region, ctx, code);
        }
    }
}

/// Generate code for a basic block
fn generate_block<W: CodeWriter>(block: &BasicBlock, ctx: &BodyGenContext, code: &mut W) {
    let stmt_gen = StmtGen::new(&ctx.expr_gen);

    for insn in &block.instructions {
        // Skip control flow instructions - they're handled by region structure
        if is_control_flow(&insn.insn_type) {
            continue;
        }

        // Generate statement or expression
        if !generate_insn(insn, ctx, &stmt_gen, code) {
            // Fallback: emit as comment
            code.start_line()
                .add("/* ")
                .add(&format!("{:?}", insn.insn_type))
                .add(" */")
                .newline();
        }
    }
}

/// Check if instruction is control flow (handled by regions)
fn is_control_flow(insn: &InsnType) -> bool {
    matches!(
        insn,
        InsnType::If { .. }
            | InsnType::Goto { .. }
            | InsnType::PackedSwitch { .. }
            | InsnType::SparseSwitch { .. }
    )
}

/// Generate code for a single instruction
fn generate_insn<W: CodeWriter>(
    insn: &InsnNode,
    ctx: &BodyGenContext,
    stmt_gen: &StmtGen,
    code: &mut W,
) -> bool {
    match &insn.insn_type {
        InsnType::Nop => true, // Nothing to generate

        InsnType::Return { value } => {
            stmt_gen.gen_return(value.as_ref(), code);
            true
        }

        InsnType::Throw { exception } => {
            stmt_gen.gen_throw(exception, code);
            true
        }

        InsnType::Const { dest, value } => {
            let val_str = ctx.expr_gen.gen_literal(value);
            let var_name = ctx.expr_gen.get_var_name(dest);
            code.start_line()
                .add(&var_name)
                .add(" = ")
                .add(&val_str)
                .add(";")
                .newline();
            true
        }

        InsnType::ConstString { dest, string_idx } => {
            let var_name = ctx.expr_gen.get_var_name(dest);
            code.start_line()
                .add(&var_name)
                .add(" = ")
                .add("string#")
                .add(&string_idx.to_string())
                .add(";")
                .newline();
            true
        }

        InsnType::Move { dest, src } => {
            let var_name = ctx.expr_gen.get_var_name(dest);
            let src_str = ctx.expr_gen.gen_arg(src);
            code.start_line()
                .add(&var_name)
                .add(" = ")
                .add(&src_str)
                .add(";")
                .newline();
            true
        }

        InsnType::MoveResult { dest } => {
            // Result of previous invoke - usually combined with invoke
            let var_name = ctx.expr_gen.get_var_name(dest);
            code.start_line()
                .add(&var_name)
                .add(" = /* result */;")
                .newline();
            true
        }

        InsnType::MoveException { dest } => {
            let var_name = ctx.expr_gen.get_var_name(dest);
            code.start_line()
                .add(&var_name)
                .add(" = /* caught exception */;")
                .newline();
            true
        }

        InsnType::NewInstance { dest, type_idx } => {
            let var_name = ctx.expr_gen.get_var_name(dest);
            code.start_line()
                .add(&var_name)
                .add(" = new Type#")
                .add(&type_idx.to_string())
                .add("();")
                .newline();
            true
        }

        InsnType::NewArray { dest, type_idx, size } => {
            let var_name = ctx.expr_gen.get_var_name(dest);
            let size_str = ctx.expr_gen.gen_arg(size);
            code.start_line()
                .add(&var_name)
                .add(" = new Type#")
                .add(&type_idx.to_string())
                .add("[")
                .add(&size_str)
                .add("];")
                .newline();
            true
        }

        InsnType::ArrayLength { dest, array } => {
            let var_name = ctx.expr_gen.get_var_name(dest);
            let arr_str = ctx.expr_gen.gen_arg(array);
            code.start_line()
                .add(&var_name)
                .add(" = ")
                .add(&arr_str)
                .add(".length;")
                .newline();
            true
        }

        InsnType::ArrayGet { dest, array, index, .. } => {
            let var_name = ctx.expr_gen.get_var_name(dest);
            let arr_str = ctx.expr_gen.gen_arg(array);
            let idx_str = ctx.expr_gen.gen_arg(index);
            code.start_line()
                .add(&var_name)
                .add(" = ")
                .add(&arr_str)
                .add("[")
                .add(&idx_str)
                .add("];")
                .newline();
            true
        }

        InsnType::ArrayPut { array, index, value, .. } => {
            stmt_gen.gen_array_put(array, index, value, code);
            true
        }

        InsnType::InstanceGet { dest, object, field_idx } => {
            let var_name = ctx.expr_gen.get_var_name(dest);
            let obj_str = ctx.expr_gen.gen_arg(object);
            code.start_line()
                .add(&var_name)
                .add(" = ")
                .add(&obj_str)
                .add(".field#")
                .add(&field_idx.to_string())
                .add(";")
                .newline();
            true
        }

        InsnType::InstancePut { object, field_idx, value } => {
            let obj_str = ctx.expr_gen.gen_arg(object);
            let val_str = ctx.expr_gen.gen_arg(value);
            code.start_line()
                .add(&obj_str)
                .add(".field#")
                .add(&field_idx.to_string())
                .add(" = ")
                .add(&val_str)
                .add(";")
                .newline();
            true
        }

        InsnType::StaticGet { dest, field_idx } => {
            let var_name = ctx.expr_gen.get_var_name(dest);
            code.start_line()
                .add(&var_name)
                .add(" = field#")
                .add(&field_idx.to_string())
                .add(";")
                .newline();
            true
        }

        InsnType::StaticPut { field_idx, value } => {
            let val_str = ctx.expr_gen.gen_arg(value);
            code.start_line()
                .add("field#")
                .add(&field_idx.to_string())
                .add(" = ")
                .add(&val_str)
                .add(";")
                .newline();
            true
        }

        InsnType::Invoke { kind, method_idx, args } => {
            if let Some(expr) = ctx.expr_gen.gen_insn(&insn.insn_type) {
                code.start_line().add(&expr).add(";").newline();
            } else {
                // Fallback
                let args_str: Vec<_> = args.iter().map(|a| ctx.expr_gen.gen_arg(a)).collect();
                code.start_line()
                    .add("method#")
                    .add(&method_idx.to_string())
                    .add("(")
                    .add(&args_str.join(", "))
                    .add(");")
                    .newline();
            }
            true
        }

        InsnType::Unary { dest, op, arg } => {
            if let Some(expr) = ctx.expr_gen.gen_insn(&insn.insn_type) {
                let var_name = ctx.expr_gen.get_var_name(dest);
                code.start_line()
                    .add(&var_name)
                    .add(" = ")
                    .add(&expr)
                    .add(";")
                    .newline();
                true
            } else {
                false
            }
        }

        InsnType::Binary { dest, op, left, right } => {
            if let Some(expr) = ctx.expr_gen.gen_insn(&insn.insn_type) {
                let var_name = ctx.expr_gen.get_var_name(dest);
                code.start_line()
                    .add(&var_name)
                    .add(" = ")
                    .add(&expr)
                    .add(";")
                    .newline();
                true
            } else {
                false
            }
        }

        InsnType::Cast { dest, cast_type, arg } => {
            if let Some(expr) = ctx.expr_gen.gen_insn(&insn.insn_type) {
                let var_name = ctx.expr_gen.get_var_name(dest);
                code.start_line()
                    .add(&var_name)
                    .add(" = ")
                    .add(&expr)
                    .add(";")
                    .newline();
                true
            } else {
                false
            }
        }

        InsnType::Compare { dest, op, left, right } => {
            if let Some(expr) = ctx.expr_gen.gen_insn(&insn.insn_type) {
                let var_name = ctx.expr_gen.get_var_name(dest);
                code.start_line()
                    .add(&var_name)
                    .add(" = ")
                    .add(&expr)
                    .add(";")
                    .newline();
                true
            } else {
                false
            }
        }

        InsnType::InstanceOf { dest, object, type_idx } => {
            let var_name = ctx.expr_gen.get_var_name(dest);
            let obj_str = ctx.expr_gen.gen_arg(object);
            code.start_line()
                .add(&var_name)
                .add(" = ")
                .add(&obj_str)
                .add(" instanceof Type#")
                .add(&type_idx.to_string())
                .add(";")
                .newline();
            true
        }

        InsnType::CheckCast { object, type_idx } => {
            // Check-cast doesn't produce output, it's a runtime check
            code.start_line()
                .add("/* check-cast ")
                .add(&ctx.expr_gen.gen_arg(object))
                .add(" to Type#")
                .add(&type_idx.to_string())
                .add(" */")
                .newline();
            true
        }

        InsnType::MonitorEnter { object } => {
            stmt_gen.gen_monitor_enter(object, code);
            true
        }

        InsnType::MonitorExit { object } => {
            stmt_gen.gen_monitor_exit(object, code);
            true
        }

        InsnType::ConstClass { dest, type_idx } => {
            let var_name = ctx.expr_gen.get_var_name(dest);
            code.start_line()
                .add(&var_name)
                .add(" = Type#")
                .add(&type_idx.to_string())
                .add(".class;")
                .newline();
            true
        }

        InsnType::FilledNewArray { dest, type_idx, args } => {
            let args_str: Vec<_> = args.iter().map(|a| ctx.expr_gen.gen_arg(a)).collect();
            if let Some(d) = dest {
                let var_name = ctx.expr_gen.get_var_name(d);
                code.start_line()
                    .add(&var_name)
                    .add(" = new Type#")
                    .add(&type_idx.to_string())
                    .add("[] { ")
                    .add(&args_str.join(", "))
                    .add(" };")
                    .newline();
            }
            true
        }

        InsnType::FillArrayData { array, payload_offset } => {
            code.start_line()
                .add("/* fill-array-data */")
                .newline();
            true
        }

        // Phi nodes are SSA artifacts, skip them
        InsnType::Phi { .. } => true,

        // Control flow handled by region structure
        InsnType::If { .. }
        | InsnType::Goto { .. }
        | InsnType::PackedSwitch { .. }
        | InsnType::SparseSwitch { .. } => true,
    }
}

/// Generate a default return statement
fn add_default_return<W: CodeWriter>(return_type: &ArgType, code: &mut W) {
    match return_type {
        ArgType::Void => {}
        ArgType::Boolean => {
            code.start_line().add("return false;").newline();
        }
        ArgType::Byte | ArgType::Char | ArgType::Short | ArgType::Int => {
            code.start_line().add("return 0;").newline();
        }
        ArgType::Long => {
            code.start_line().add("return 0L;").newline();
        }
        ArgType::Float => {
            code.start_line().add("return 0.0f;").newline();
        }
        ArgType::Double => {
            code.start_line().add("return 0.0d;").newline();
        }
        _ => {
            code.start_line().add("return null;").newline();
        }
    }
}

/// Generate parameter name from type and index
fn generate_param_name(index: usize, ty: &ArgType) -> String {
    let base = match ty {
        ArgType::Object(name) => {
            let simple = name.rsplit('/').next().unwrap_or(name);
            let simple = simple.trim_end_matches(';');
            let mut chars = simple.chars();
            match chars.next() {
                Some(c) => c.to_lowercase().chain(chars).collect(),
                None => format!("arg{}", index),
            }
        }
        ArgType::Array(elem) => {
            let elem_name = generate_param_name(index, elem);
            format!("{}Arr", elem_name)
        }
        ArgType::Int => "i".to_string(),
        ArgType::Long => "l".to_string(),
        ArgType::Float => "f".to_string(),
        ArgType::Double => "d".to_string(),
        ArgType::Boolean => "flag".to_string(),
        ArgType::Byte => "b".to_string(),
        ArgType::Char => "c".to_string(),
        ArgType::Short => "s".to_string(),
        _ => format!("arg{}", index),
    };

    if index == 0 {
        base
    } else {
        format!("{}{}", base, index)
    }
}

#[cfg(test)]
mod tests {
    use super::*;
    use crate::writer::SimpleCodeWriter;
    use jadx_ir::instructions::{InsnArg, InsnNode, InsnType, LiteralArg, RegisterArg};

    fn make_method() -> MethodData {
        MethodData::new("test".to_string(), 0x0001, ArgType::Void)
    }

    #[test]
    fn test_empty_method() {
        let method = make_method();
        let mut writer = SimpleCodeWriter::new();
        generate_body(&method, &mut writer);
        let code = writer.finish();
        assert!(code.contains("empty method"));
    }

    #[test]
    fn test_simple_return() {
        let mut method = make_method();
        method.instructions.push(InsnNode::new(
            InsnType::Return { value: None },
            0,
        ));

        let mut writer = SimpleCodeWriter::new();
        generate_body(&method, &mut writer);
        let code = writer.finish();
        assert!(code.contains("return;"));
    }

    #[test]
    fn test_const_and_return() {
        let mut method = MethodData::new("test".to_string(), 0x0001, ArgType::Int);
        method.regs_count = 1;

        method.instructions.push(InsnNode::new(
            InsnType::Const {
                dest: RegisterArg::new(0),
                value: LiteralArg::Int(42),
            },
            0,
        ));
        method.instructions.push(InsnNode::new(
            InsnType::Return {
                value: Some(InsnArg::reg(0)),
            },
            1,
        ));

        let mut writer = SimpleCodeWriter::new();
        generate_body(&method, &mut writer);
        let code = writer.finish();
        assert!(code.contains("42"));
        assert!(code.contains("return"));
    }
}
