//! Method body code generation
//!
//! This module generates Java source code for method bodies through a full
//! decompilation pipeline:
//!
//! ## Pipeline Stages
//! 1. **Block splitting** - Convert linear instructions into basic blocks
//! 2. **CFG construction** - Build control flow graph with edges
//! 3. **SSA transformation** - Convert to Static Single Assignment form with phi nodes
//! 4. **Type inference** - Infer types for all registers using constraint solving
//! 5. **Region reconstruction** - Convert CFG to structured regions (if/else, loops, switch)
//! 6. **Code emission** - Walk the region tree to emit Java source
//!
//! ## Key Features
//! - **Name resolution**: When `DexInfo` is provided, resolves string/field/method
//!   indices to actual names (e.g., `Log.i()` instead of `method#123`)
//! - **Type declarations**: Emits type on first variable assignment
//! - **Condition extraction**: Generates actual conditions like `v0 == 0` from If blocks
//! - **Invoke/MoveResult pairing**: Combines invoke + move-result into assignments
//!
//! ## Usage
//! ```ignore
//! // Without name resolution (placeholders like Type#123)
//! generate_body(&method, &mut writer);
//!
//! // With name resolution (actual names from DEX)
//! generate_body_with_dex(&method, Some(&dex_info), &mut writer);
//! ```

use std::collections::{BTreeMap, HashSet};

use jadx_ir::instructions::{IfCondition, InsnNode, InsnType};
use jadx_ir::regions::{Condition, LoopKind, Region, RegionContent};
use jadx_ir::types::ArgType;
use jadx_ir::MethodData;
use jadx_passes::block_split::{split_blocks, BasicBlock};
use jadx_passes::cfg::CFG;
use jadx_passes::region_builder::build_regions;
use jadx_passes::ssa::transform_to_ssa;
use jadx_passes::type_inference::{infer_types, TypeInferenceResult};

use crate::dex_info::DexInfo;
use crate::expr_gen::ExprGen;
use crate::stmt_gen::{
    gen_break, gen_close_block, gen_do_while_end, gen_do_while_start, gen_else, gen_if_header,
    gen_while_header,
};
use crate::type_gen::type_to_string;
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
    /// Type inference results (optional - populated when SSA is run)
    pub type_info: Option<TypeInferenceResult>,
    /// Variables that have been declared (to avoid redeclaration)
    pub declared_vars: HashSet<(u16, u32)>,
    /// First parameter register (registers >= this are parameters, already declared)
    pub first_param_reg: u16,
    /// Last invoke expression (for MoveResult to pick up)
    pub last_invoke_expr: Option<String>,
}

impl BodyGenContext {
    /// Create a new body generation context from method data
    pub fn from_method(method: &MethodData) -> Self {
        Self::from_method_with_dex(method, None)
    }

    /// Create a new body generation context from method data with DEX info for name resolution
    pub fn from_method_with_dex(method: &MethodData, dex_info: Option<&DexInfo>) -> Self {
        let mut expr_gen = ExprGen::new();

        // Populate ExprGen with DEX data if available (for name resolution)
        if let Some(dex) = dex_info {
            dex.populate_expr_gen(&mut expr_gen);
        }

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
            type_info: None,
            declared_vars: HashSet::new(),
            first_param_reg,
            last_invoke_expr: None,
        }
    }

    /// Get the inferred type for a register, if available
    pub fn get_inferred_type(&self, reg: u16) -> Option<&ArgType> {
        self.type_info.as_ref().and_then(|ti| ti.types.get(&(reg, 0)))
    }

    /// Get the inferred type for a register with specific SSA version
    pub fn get_inferred_type_versioned(&self, reg: u16, version: u32) -> Option<&ArgType> {
        self.type_info.as_ref().and_then(|ti| ti.types.get(&(reg, version)))
    }

    /// Check if a variable has been declared
    pub fn is_declared(&self, reg: u16, version: u32) -> bool {
        self.declared_vars.contains(&(reg, version))
    }

    /// Mark a variable as declared
    pub fn mark_declared(&mut self, reg: u16, version: u32) {
        self.declared_vars.insert((reg, version));
    }

    /// Check if this register is a parameter (already has a type from method signature)
    pub fn is_parameter(&self, reg: u16) -> bool {
        reg >= self.first_param_reg
    }
}

use jadx_ir::instructions::RegisterArg;

/// Emit an assignment statement, with type declaration if this is the first assignment
fn emit_assignment<W: CodeWriter>(
    dest: &RegisterArg,
    value_str: &str,
    ctx: &mut BodyGenContext,
    code: &mut W,
) {
    let var_name = ctx.expr_gen.get_var_name(dest);
    let reg = dest.reg_num;
    let version = dest.ssa_version;

    code.start_line();

    // Check if we need to declare this variable
    if !ctx.is_declared(reg, version) && !ctx.is_parameter(reg) {
        // Get the type from type inference
        if let Some(arg_type) = ctx.get_inferred_type_versioned(reg, version) {
            let type_str = type_to_string(arg_type);
            code.add(&type_str).add(" ");
        } else {
            // Fallback: try to get from expr_gen's var_types
            code.add("var ");  // Use 'var' as fallback (Java 10+ style)
        }
        ctx.mark_declared(reg, version);
    }

    code.add(&var_name)
        .add(" = ")
        .add(value_str)
        .add(";")
        .newline();
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

    // Build CFG
    let cfg = CFG::from_blocks(block_result.clone());

    // SSA transformation
    let ssa_result = transform_to_ssa(&block_result);

    // Type inference on SSA form
    let type_result = infer_types(&ssa_result);

    // Build region tree for structured code
    let region = build_regions(&cfg);

    // Create generation context with type info
    let mut ctx = BodyGenContext::from_method(method);
    ctx.blocks = cfg_blocks_to_map(&cfg);
    ctx.type_info = Some(type_result);

    // Apply inferred types to expression generator
    apply_inferred_types(&mut ctx);

    // Generate code from region tree
    generate_region(&region, &mut ctx, code);
}

/// Generate method body from instructions with DEX info for name resolution
///
/// When `dex_info` is provided, indices like `Type#123` resolve to actual
/// class names like `TextView`, and `field#456` becomes actual field names.
pub fn generate_body_with_dex<W: CodeWriter>(
    method: &MethodData,
    dex_info: Option<&DexInfo>,
    code: &mut W,
) {
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

    // Build CFG
    let cfg = CFG::from_blocks(block_result.clone());

    // SSA transformation
    let ssa_result = transform_to_ssa(&block_result);

    // Type inference on SSA form
    let type_result = infer_types(&ssa_result);

    // Build region tree for structured code
    let region = build_regions(&cfg);

    // Create generation context with type info and DEX data for name resolution
    let mut ctx = BodyGenContext::from_method_with_dex(method, dex_info);
    ctx.blocks = cfg_blocks_to_map(&cfg);
    ctx.type_info = Some(type_result);

    // Apply inferred types to expression generator
    apply_inferred_types(&mut ctx);

    // Generate code from region tree
    generate_region(&region, &mut ctx, code);
}

/// Apply inferred types from type inference to the expression generator
fn apply_inferred_types(ctx: &mut BodyGenContext) {
    if let Some(ref type_info) = ctx.type_info {
        for ((reg, version), arg_type) in &type_info.types {
            ctx.expr_gen.set_var_type(*reg, *version, arg_type.clone());
        }
    }
}

/// Generate condition expression string from a Condition
fn generate_condition(condition: &Condition, ctx: &BodyGenContext) -> String {
    match condition {
        Condition::Simple { block, op, negated } => {
            // Look up the block to find the If instruction with operands
            if let Some(basic_block) = ctx.blocks.get(block) {
                // Find the If instruction (usually the last one)
                for insn in basic_block.instructions.iter().rev() {
                    if let InsnType::If { condition: _, left, right, .. } = &insn.insn_type {
                        let left_str = ctx.expr_gen.gen_arg(left);
                        let right_str = match right {
                            Some(r) => ctx.expr_gen.gen_arg(r),
                            None => "0".to_string(), // Compare to zero
                        };

                        // Get the operator string
                        let op_str = if_condition_to_string(op, *negated);

                        return format!("{} {} {}", left_str, op_str, right_str);
                    }
                }
            }
            "/* condition */".to_string()
        }

        Condition::And(left, right) => {
            let left_str = generate_condition(left, ctx);
            let right_str = generate_condition(right, ctx);
            format!("({}) && ({})", left_str, right_str)
        }

        Condition::Or(left, right) => {
            let left_str = generate_condition(left, ctx);
            let right_str = generate_condition(right, ctx);
            format!("({}) || ({})", left_str, right_str)
        }

        Condition::Not(inner) => {
            let inner_str = generate_condition(inner, ctx);
            format!("!({})", inner_str)
        }

        Condition::Ternary { condition, if_true, if_false } => {
            let cond_str = generate_condition(condition, ctx);
            let true_str = generate_condition(if_true, ctx);
            let false_str = generate_condition(if_false, ctx);
            format!("({}) ? ({}) : ({})", cond_str, true_str, false_str)
        }

        Condition::Unknown => "/* condition */".to_string(),
    }
}

/// Convert IfCondition to operator string
fn if_condition_to_string(op: &IfCondition, negated: bool) -> &'static str {
    match (op, negated) {
        (IfCondition::Eq, false) => "==",
        (IfCondition::Eq, true) => "!=",
        (IfCondition::Ne, false) => "!=",
        (IfCondition::Ne, true) => "==",
        (IfCondition::Lt, false) => "<",
        (IfCondition::Lt, true) => ">=",
        (IfCondition::Ge, false) => ">=",
        (IfCondition::Ge, true) => "<",
        (IfCondition::Gt, false) => ">",
        (IfCondition::Gt, true) => "<=",
        (IfCondition::Le, false) => "<=",
        (IfCondition::Le, true) => ">",
    }
}

/// Generate setup instructions from condition blocks (non-If instructions)
/// These define variables that are used in the condition expression
fn generate_condition_setup<W: CodeWriter>(condition: &Condition, ctx: &mut BodyGenContext, code: &mut W) {
    // Only process Simple conditions - compound conditions recurse
    if let Condition::Simple { block, .. } = condition {
        // Get just this one block's instructions (avoid collecting from nested conditions)
        if let Some(basic_block) = ctx.blocks.get(block).cloned() {
            for insn in &basic_block.instructions {
                // Skip the If instruction itself and control flow
                if matches!(insn.insn_type, InsnType::If { .. }) || is_control_flow(&insn.insn_type) {
                    continue;
                }
                // Generate the instruction
                if !generate_insn(insn, ctx, code) {
                    code.start_line()
                        .add("/* ")
                        .add(&format!("{:?}", insn.insn_type))
                        .add(" */")
                        .newline();
                }
            }
        }

        // Flush any pending invoke expression
        if let Some(invoke) = ctx.last_invoke_expr.take() {
            code.start_line().add(&invoke).add(";").newline();
        }
    }
    // For compound conditions (And, Or, Not), the nested Simple conditions
    // will be handled when generate_condition recurses
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
fn generate_region<W: CodeWriter>(region: &Region, ctx: &mut BodyGenContext, code: &mut W) {
    match region {
        Region::Sequence(contents) => {
            for content in contents {
                generate_content(content, ctx, code);
            }
        }

        Region::If {
            condition,
            then_region,
            else_region,
        } => {
            // First, output any setup instructions from the condition block(s)
            // These are the non-If instructions that define variables used in the condition
            generate_condition_setup(condition, ctx, code);

            // Generate the actual condition expression
            let condition_str = generate_condition(condition, ctx);

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
            condition,
            body,
        } => {
            // Generate condition expression if available
            let condition_str = match condition {
                Some(cond) => generate_condition(cond, ctx),
                None => "true".to_string(),
            };

            match kind {
                LoopKind::While | LoopKind::For => {
                    // For while loops, setup instructions go before the loop
                    if let Some(cond) = condition {
                        generate_condition_setup(cond, ctx, code);
                    }
                    gen_while_header(&condition_str, code);
                    generate_region(body, ctx, code);
                    gen_close_block(code);
                }
                LoopKind::DoWhile => {
                    gen_do_while_start(code);
                    generate_region(body, ctx, code);
                    // For do-while, condition setup is at the end of the body
                    if let Some(cond) = condition {
                        generate_condition_setup(cond, ctx, code);
                    }
                    gen_do_while_end(&condition_str, code);
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
fn generate_content<W: CodeWriter>(content: &RegionContent, ctx: &mut BodyGenContext, code: &mut W) {
    match content {
        RegionContent::Block(block_id) => {
            // Clone the block to avoid borrow conflict with ctx
            if let Some(block) = ctx.blocks.get(block_id).cloned() {
                generate_block(&block, ctx, code);
            }
        }
        RegionContent::Region(region) => {
            generate_region(region, ctx, code);
        }
    }
}

/// Generate code for a basic block
fn generate_block<W: CodeWriter>(block: &BasicBlock, ctx: &mut BodyGenContext, code: &mut W) {
    for insn in &block.instructions {
        // Skip control flow instructions - they're handled by region structure
        if is_control_flow(&insn.insn_type) {
            continue;
        }

        // Generate statement or expression
        if !generate_insn(insn, ctx, code) {
            // Fallback: emit as comment
            code.start_line()
                .add("/* ")
                .add(&format!("{:?}", insn.insn_type))
                .add(" */")
                .newline();
        }
    }

    // Flush any pending invoke expression that wasn't consumed by MoveResult
    if let Some(invoke) = ctx.last_invoke_expr.take() {
        code.start_line().add(&invoke).add(";").newline();
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
    ctx: &mut BodyGenContext,
    code: &mut W,
) -> bool {
    match &insn.insn_type {
        InsnType::Nop => true, // Nothing to generate

        InsnType::Return { value } => {
            code.start_line().add("return");
            if let Some(v) = value {
                code.add(" ").add(&ctx.expr_gen.gen_arg(v));
            }
            code.add(";").newline();
            true
        }

        InsnType::Throw { exception } => {
            code.start_line()
                .add("throw ")
                .add(&ctx.expr_gen.gen_arg(exception))
                .add(";")
                .newline();
            true
        }

        InsnType::Const { dest, value } => {
            let val_str = ctx.expr_gen.gen_literal(value);
            emit_assignment(dest, &val_str, ctx, code);
            true
        }

        InsnType::ConstString { dest, string_idx } => {
            // Use gen_insn to properly resolve the string value from DexInfo
            let value = ctx.expr_gen.gen_insn(&insn.insn_type)
                .unwrap_or_else(|| format!("string#{}", string_idx));
            emit_assignment(dest, &value, ctx, code);
            true
        }

        InsnType::Move { dest, src } => {
            let src_str = ctx.expr_gen.gen_arg(src);
            emit_assignment(dest, &src_str, ctx, code);
            true
        }

        InsnType::MoveResult { dest } => {
            // Result of previous invoke - use stored expression
            let expr = ctx.last_invoke_expr.take()
                .unwrap_or_else(|| "/* result */".to_string());
            emit_assignment(dest, &expr, ctx, code);
            true
        }

        InsnType::MoveException { dest } => {
            emit_assignment(dest, "/* caught exception */", ctx, code);
            true
        }

        InsnType::NewInstance { dest, type_idx } => {
            if let Some(expr) = ctx.expr_gen.gen_insn(&insn.insn_type) {
                emit_assignment(dest, &expr, ctx, code);
            } else {
                let value = format!("new Type#{}()", type_idx);
                emit_assignment(dest, &value, ctx, code);
            }
            true
        }

        InsnType::NewArray { dest, type_idx, size } => {
            if let Some(expr) = ctx.expr_gen.gen_insn(&insn.insn_type) {
                emit_assignment(dest, &expr, ctx, code);
            } else {
                let size_str = ctx.expr_gen.gen_arg(size);
                let value = format!("new Type#{}[{}]", type_idx, size_str);
                emit_assignment(dest, &value, ctx, code);
            }
            true
        }

        InsnType::ArrayLength { dest, array } => {
            let arr_str = ctx.expr_gen.gen_arg(array);
            let value = format!("{}.length", arr_str);
            emit_assignment(dest, &value, ctx, code);
            true
        }

        InsnType::ArrayGet { dest, array, index, .. } => {
            let arr_str = ctx.expr_gen.gen_arg(array);
            let idx_str = ctx.expr_gen.gen_arg(index);
            let value = format!("{}[{}]", arr_str, idx_str);
            emit_assignment(dest, &value, ctx, code);
            true
        }

        InsnType::ArrayPut { array, index, value, .. } => {
            code.start_line()
                .add(&ctx.expr_gen.gen_arg(array))
                .add("[")
                .add(&ctx.expr_gen.gen_arg(index))
                .add("] = ")
                .add(&ctx.expr_gen.gen_arg(value))
                .add(";")
                .newline();
            true
        }

        InsnType::InstanceGet { dest, object, field_idx } => {
            let obj_str = ctx.expr_gen.gen_arg(object);
            let field_name = ctx.expr_gen.get_field_name(*field_idx)
                .unwrap_or_else(|| format!("field#{}", field_idx));
            let value = format!("{}.{}", obj_str, field_name);
            emit_assignment(dest, &value, ctx, code);
            true
        }

        InsnType::InstancePut { object, field_idx, value } => {
            let obj_str = ctx.expr_gen.gen_arg(object);
            let val_str = ctx.expr_gen.gen_arg(value);
            let field_name = ctx.expr_gen.get_field_name(*field_idx)
                .unwrap_or_else(|| format!("field#{}", field_idx));
            code.start_line()
                .add(&obj_str)
                .add(".")
                .add(&field_name)
                .add(" = ")
                .add(&val_str)
                .add(";")
                .newline();
            true
        }

        InsnType::StaticGet { dest, field_idx } => {
            let var_name = ctx.expr_gen.get_var_name(dest);
            let field_ref = ctx.expr_gen.get_static_field_ref(*field_idx)
                .unwrap_or_else(|| format!("field#{}", field_idx));
            code.start_line()
                .add(&var_name)
                .add(" = ")
                .add(&field_ref)
                .add(";")
                .newline();
            true
        }

        InsnType::StaticPut { field_idx, value } => {
            let val_str = ctx.expr_gen.gen_arg(value);
            let field_ref = ctx.expr_gen.get_static_field_ref(*field_idx)
                .unwrap_or_else(|| format!("field#{}", field_idx));
            code.start_line()
                .add(&field_ref)
                .add(" = ")
                .add(&val_str)
                .add(";")
                .newline();
            true
        }

        InsnType::Invoke { kind: _, method_idx, args } => {
            let expr = if let Some(e) = ctx.expr_gen.gen_insn(&insn.insn_type) {
                e
            } else {
                // Fallback
                let args_str: Vec<_> = args.iter().map(|a| ctx.expr_gen.gen_arg(a)).collect();
                format!("method#{}({})", method_idx, args_str.join(", "))
            };
            // Store the expression for potential MoveResult
            // If there's a pending invoke that wasn't consumed by MoveResult, output it now
            if let Some(prev) = ctx.last_invoke_expr.take() {
                code.start_line().add(&prev).add(";").newline();
            }
            ctx.last_invoke_expr = Some(expr);
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
            code.start_line()
                .add("synchronized (")
                .add(&ctx.expr_gen.gen_arg(object))
                .add(") {")
                .newline();
            code.inc_indent();
            true
        }

        InsnType::MonitorExit { object: _ } => {
            code.dec_indent();
            code.start_line().add("}").newline();
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

        // Break/Continue handled by loop region structure
        InsnType::Break { .. } => {
            code.start_line().add("break;").newline();
            true
        }
        InsnType::Continue { .. } => {
            code.start_line().add("continue;").newline();
            true
        }
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
