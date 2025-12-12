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

use std::collections::{BTreeMap, HashMap, HashSet};

use jadx_ir::instructions::{IfCondition, InsnArg, InsnNode, InsnType, InvokeKind, LiteralArg};
use jadx_ir::regions::{Condition, LoopKind, Region, RegionContent};
use jadx_ir::types::ArgType;
use jadx_ir::MethodData;
use jadx_passes::block_split::{split_blocks, BasicBlock};
use jadx_passes::cfg::CFG;
use jadx_passes::region_builder::build_regions;
use jadx_passes::ssa::transform_to_ssa;
use jadx_passes::type_inference::{infer_types, TypeInferenceResult};

use crate::dex_info::DexInfoProvider;
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
    /// Last invoke expression (for MoveResult pairing)
    pub last_invoke_expr: Option<String>,
    /// Pending new-instance instructions waiting for <init> call
    /// Maps register number to type_idx for combining new-instance + invoke-direct <init>
    pub pending_new_instances: HashMap<u16, u32>,
}

impl BodyGenContext {
    /// Create a new body generation context from method data
    pub fn from_method(method: &MethodData) -> Self {
        Self::from_method_with_dex(method, None)
    }

    /// Create a new body generation context from method data with DEX info for name resolution
    pub fn from_method_with_dex(method: &MethodData, dex_info: Option<std::sync::Arc<dyn DexInfoProvider>>) -> Self {
        let mut expr_gen = ExprGen::new();

        // Set DEX provider for lazy lookups during code generation
        if let Some(dex) = dex_info {
            expr_gen.set_dex_provider(dex);
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
            pending_new_instances: HashMap::new(),
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

    /// Check if this register AND version is a parameter (already has a type from method signature)
    /// Note: In SSA form, only version 0 of a parameter register is the actual parameter.
    /// Later versions are redefinitions that need to be declared as locals.
    pub fn is_parameter(&self, reg: u16, version: u32) -> bool {
        // Only version 0 of parameter registers are actual parameters
        version == 0 && reg >= self.first_param_reg
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
    emit_assignment_with_hint(dest, value_str, None, ctx, code);
}

/// Emit an assignment with an optional type hint from the instruction context
fn emit_assignment_with_hint<W: CodeWriter>(
    dest: &RegisterArg,
    value_str: &str,
    type_hint: Option<&ArgType>,
    ctx: &mut BodyGenContext,
    code: &mut W,
) {
    let var_name = ctx.expr_gen.get_var_name(dest);
    let reg = dest.reg_num;
    let version = dest.ssa_version;

    code.start_line();

    // Check if we need to declare this variable
    // In SSA form, only version 0 of parameter registers are actual parameters
    if !ctx.is_declared(reg, version) && !ctx.is_parameter(reg, version) {
        // Priority: 1. Type inference, 2. Type hint, 3. Try version 0, 4. Object fallback
        let decl_type = ctx.get_inferred_type_versioned(reg, version)
            .or_else(|| type_hint)
            .or_else(|| {
                // Try version 0 if specific version not found
                if version != 0 {
                    ctx.get_inferred_type_versioned(reg, 0)
                } else {
                    None
                }
            });

        if let Some(arg_type) = decl_type {
            let type_str = type_to_string(arg_type);
            code.add(&type_str).add(" ");
        } else {
            // Fallback: use Object as default type (better than Java 10+ 'var')
            code.add("Object ");
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
    // Use SSA blocks instead of CFG blocks to preserve SSA versions for proper variable naming
    ctx.blocks = ssa_blocks_to_map(&ssa_result);
    ctx.type_info = Some(type_result);

    // Apply inferred types and generate variable names
    apply_inferred_types(&mut ctx);
    generate_var_names(&mut ctx);

    // Generate code from region tree
    generate_region(&region, &mut ctx, code);
}

/// Generate method body from instructions with DEX info for name resolution
///
/// When `dex_info` is provided, indices like `Type#123` resolve to actual
/// class names like `TextView`, and `field#456` becomes actual field names.
pub fn generate_body_with_dex<W: CodeWriter>(
    method: &MethodData,
    dex_info: Option<std::sync::Arc<dyn DexInfoProvider>>,
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

    // Type inference on SSA form - use DEX lookups if available for better type accuracy
    let type_result = if let Some(ref dex) = dex_info {
        let dex_clone = dex.clone();
        let dex_clone2 = dex.clone();
        let dex_clone3 = dex.clone();
        jadx_passes::infer_types_with_context(
            &ssa_result,
            move |idx| dex_clone.get_type_name(idx).map(|s| ArgType::Object(s)),
            move |idx| dex_clone2.get_field(idx).map(|f| f.field_type.clone()),
            move |idx| dex_clone3.get_method(idx).map(|m| (m.param_types.clone(), m.return_type.clone())),
        )
    } else {
        infer_types(&ssa_result)
    };

    // Build region tree for structured code
    let region = build_regions(&cfg);

    // Create generation context with type info and DEX data for name resolution
    let mut ctx = BodyGenContext::from_method_with_dex(method, dex_info.clone());
    // Use SSA blocks instead of CFG blocks to preserve SSA versions for proper variable naming
    ctx.blocks = ssa_blocks_to_map(&ssa_result);
    ctx.type_info = Some(type_result);

    // Apply inferred types and generate variable names
    apply_inferred_types(&mut ctx);
    generate_var_names(&mut ctx);

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

/// Generate variable names based on inferred types
/// This should be called after apply_inferred_types
fn generate_var_names(ctx: &mut BodyGenContext) {
    // Track name usage counts for disambiguation
    let mut name_counts: std::collections::HashMap<String, u32> = std::collections::HashMap::new();

    // Get all type entries and sort by (reg, version) for deterministic naming
    let mut type_entries: Vec<((u16, u32), ArgType)> = Vec::new();
    if let Some(ref type_info) = ctx.type_info {
        for ((reg, version), arg_type) in &type_info.types {
            // Skip parameter registers - they already have names
            if *reg >= ctx.first_param_reg {
                continue;
            }
            type_entries.push(((*reg, *version), arg_type.clone()));
        }
    }
    type_entries.sort_by_key(|((reg, version), _)| (*reg, *version));

    for ((reg, version), arg_type) in type_entries {
        let base_name = type_to_var_name(&arg_type);
        let count = name_counts.entry(base_name.clone()).or_insert(0);
        let name = if *count == 0 {
            base_name.clone()
        } else {
            format!("{}{}", base_name, count)
        };
        *count += 1;
        ctx.expr_gen.set_var_name(reg, version, name);
    }
}

/// Convert a type to a variable name prefix
fn type_to_var_name(ty: &ArgType) -> String {
    match ty {
        ArgType::Int => "i".to_string(),
        ArgType::Long => "l".to_string(),
        ArgType::Float => "f".to_string(),
        ArgType::Double => "d".to_string(),
        ArgType::Boolean => "z".to_string(),
        ArgType::Byte => "b".to_string(),
        ArgType::Char => "c".to_string(),
        ArgType::Short => "s".to_string(),
        ArgType::Void => "v".to_string(),
        ArgType::Object(name) => {
            // Extract simple class name and lowercase first char
            let simple = name.rsplit('/').next().unwrap_or(name);
            let simple = simple.trim_start_matches('L').trim_end_matches(';');
            let mut chars = simple.chars();
            match chars.next() {
                Some(c) => c.to_lowercase().chain(chars).collect(),
                None => "obj".to_string(),
            }
        }
        ArgType::Array(elem) => {
            format!("{}Arr", type_to_var_name(elem))
        }
        ArgType::Unknown => "v".to_string(),
        ArgType::Generic { base, .. } => {
            // Use base class name for generics
            let simple = base.rsplit('/').next().unwrap_or(base);
            let simple = simple.trim_start_matches('L').trim_end_matches(';');
            let mut chars = simple.chars();
            match chars.next() {
                Some(c) => c.to_lowercase().chain(chars).collect(),
                None => "obj".to_string(),
            }
        }
        ArgType::Wildcard { .. } => "w".to_string(),
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

                        // Check if this is a zero-comparison (commonly used for booleans)
                        let is_zero_compare = right.is_none() || matches!(right, Some(r) if is_zero_literal(r));

                        if is_zero_compare {
                            // Simplify boolean comparisons: x == 0 -> !x, x != 0 -> x
                            let effective_op = if *negated { negate_op(op) } else { *op };
                            match effective_op {
                                IfCondition::Eq => return format!("!{}", wrap_if_complex(&left_str)),
                                IfCondition::Ne => return left_str,
                                _ => {
                                    // For other ops (lt, gt, etc.), keep explicit comparison
                                    let op_str = if_condition_to_string(op, *negated);
                                    return format!("{} {} 0", left_str, op_str);
                                }
                            }
                        }

                        let right_str = match right {
                            Some(r) => ctx.expr_gen.gen_arg(r),
                            None => "0".to_string(),
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
            // Only wrap in parens if needed
            let left_wrapped = wrap_for_and(&left_str, left);
            let right_wrapped = wrap_for_and(&right_str, right);
            format!("{} && {}", left_wrapped, right_wrapped)
        }

        Condition::Or(left, right) => {
            let left_str = generate_condition(left, ctx);
            let right_str = generate_condition(right, ctx);
            // Only wrap in parens if needed
            let left_wrapped = wrap_for_or(&left_str, left);
            let right_wrapped = wrap_for_or(&right_str, right);
            format!("{} || {}", left_wrapped, right_wrapped)
        }

        Condition::Not(inner) => {
            let inner_str = generate_condition(inner, ctx);
            format!("!{}", wrap_if_complex(&inner_str))
        }

        Condition::Ternary { condition, if_true, if_false } => {
            let cond_str = generate_condition(condition, ctx);
            let true_str = generate_condition(if_true, ctx);
            let false_str = generate_condition(if_false, ctx);
            format!("{} ? {} : {}", wrap_if_complex(&cond_str), true_str, false_str)
        }

        Condition::Unknown => "/* condition */".to_string(),
    }
}

/// Check if an InsnArg is a zero literal
fn is_zero_literal(arg: &InsnArg) -> bool {
    matches!(arg, InsnArg::Literal(LiteralArg::Int(0)))
}

/// Negate an IfCondition
fn negate_op(op: &IfCondition) -> IfCondition {
    match op {
        IfCondition::Eq => IfCondition::Ne,
        IfCondition::Ne => IfCondition::Eq,
        IfCondition::Lt => IfCondition::Ge,
        IfCondition::Ge => IfCondition::Lt,
        IfCondition::Gt => IfCondition::Le,
        IfCondition::Le => IfCondition::Gt,
    }
}

/// Wrap string in parentheses if it contains operators
fn wrap_if_complex(s: &str) -> String {
    if s.contains(" && ") || s.contains(" || ") || s.contains(" ? ") {
        format!("({})", s)
    } else {
        s.to_string()
    }
}

/// Wrap condition string for && context (wrap || subconditions)
fn wrap_for_and(s: &str, cond: &Condition) -> String {
    if matches!(cond, Condition::Or(..)) {
        format!("({})", s)
    } else {
        s.to_string()
    }
}

/// Wrap condition string for || context (wrap && subconditions)
fn wrap_for_or(s: &str, cond: &Condition) -> String {
    if matches!(cond, Condition::And(..)) {
        format!("({})", s)
    } else {
        s.to_string()
    }
}

/// Generate exception variable name from exception type
fn generate_exception_var_name(exc_type: &str, index: usize) -> String {
    // Extract simple class name
    let simple = exc_type.rsplit('.').next().unwrap_or(exc_type);
    let simple = simple.rsplit('/').next().unwrap_or(simple);

    // Generate a short name based on common patterns
    let base = match simple {
        "Exception" | "RuntimeException" => "e",
        "IOException" => "ioException",
        "NullPointerException" | "NPE" => "npe",
        "IllegalArgumentException" => "iae",
        "IllegalStateException" => "ise",
        "IndexOutOfBoundsException" => "ioobe",
        "ClassCastException" => "cce",
        "SecurityException" => "se",
        "Throwable" => "th",
        _ if simple.ends_with("Exception") => {
            // Convert FooBarException -> fooBarException or just e
            let prefix = simple.strip_suffix("Exception").unwrap_or(simple);
            if prefix.len() <= 3 {
                "e"
            } else {
                let mut chars = prefix.chars();
                match chars.next() {
                    Some(c) => {
                        let name: String = c.to_lowercase().chain(chars).collect();
                        return if index == 0 { name } else { format!("{}{}", name, index) };
                    }
                    None => "e",
                }
            }
        }
        _ => "e",
    };

    if index == 0 {
        base.to_string()
    } else {
        format!("{}{}", base, index)
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

// Note: Condition setup removed due to memory issues
// The proper fix requires rethinking how condition blocks are processed

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

/// Convert SSA blocks to BasicBlock map for code generation
/// This preserves the SSA versions on register arguments
fn ssa_blocks_to_map(ssa_result: &jadx_passes::ssa::SsaResult) -> BTreeMap<u32, BasicBlock> {
    let mut map = BTreeMap::new();
    for ssa_block in &ssa_result.blocks {
        // Compute offsets from instructions
        let start_offset = ssa_block.instructions.first().map(|i| i.offset).unwrap_or(0);
        let end_offset = ssa_block.instructions.last().map(|i| i.offset + 1).unwrap_or(0);
        let basic_block = BasicBlock {
            id: ssa_block.id,
            start_offset,
            end_offset,
            instructions: ssa_block.instructions.clone(),
            successors: ssa_block.successors.clone(),
            predecessors: ssa_block.predecessors.clone(),
        };
        map.insert(ssa_block.id, basic_block);
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
                    gen_while_header(&condition_str, code);
                    generate_region(body, ctx, code);
                    gen_close_block(code);
                }
                LoopKind::DoWhile => {
                    gen_do_while_start(code);
                    generate_region(body, ctx, code);
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

        Region::Switch { header_block, cases, default } => {
            // Extract switch value from the header block's switch instruction
            let switch_value = ctx.blocks.get(header_block)
                .and_then(|block| block.instructions.iter().rev().find_map(|insn| {
                    match &insn.insn_type {
                        InsnType::PackedSwitch { value, .. } |
                        InsnType::SparseSwitch { value, .. } => Some(ctx.expr_gen.gen_arg(value)),
                        _ => None,
                    }
                }))
                .unwrap_or_else(|| "/* value */".to_string());

            code.start_line()
                .add("switch (")
                .add(&switch_value)
                .add(") {")
                .newline();
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

            for (i, handler) in handlers.iter().enumerate() {
                let exc_type = handler
                    .exception_type
                    .as_deref()
                    .unwrap_or("Exception");
                // Generate exception variable name based on type
                let exc_var = generate_exception_var_name(exc_type, i);
                code.start_line()
                    .add("} catch (")
                    .add(exc_type)
                    .add(" ")
                    .add(&exc_var)
                    .add(") {")
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

        Region::Synchronized { enter_block, body } => {
            // Extract lock object from the MonitorEnter instruction in the enter block
            let lock_obj = ctx.blocks.get(enter_block)
                .and_then(|block| block.instructions.iter().find_map(|insn| {
                    match &insn.insn_type {
                        InsnType::MonitorEnter { object } => Some(ctx.expr_gen.gen_arg(object)),
                        _ => None,
                    }
                }))
                .unwrap_or_else(|| "/* lock */".to_string());

            code.start_line()
                .add("synchronized (")
                .add(&lock_obj)
                .add(") {")
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
    let insns: Vec<_> = block.instructions.iter().collect();

    for (i, insn) in insns.iter().enumerate() {
        // Skip control flow instructions - they're handled by region structure
        if is_control_flow(&insn.insn_type) {
            continue;
        }

        // Check if next instruction is MoveResult (for invoke pairing)
        let next_is_move_result = insns.get(i + 1)
            .map(|next| matches!(next.insn_type, InsnType::MoveResult { .. }))
            .unwrap_or(false);

        // Generate statement or expression
        if !generate_insn_with_lookahead(insn, next_is_move_result, ctx, code) {
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

/// Generate code for an instruction with lookahead information
fn generate_insn_with_lookahead<W: CodeWriter>(
    insn: &InsnNode,
    next_is_move_result: bool,
    ctx: &mut BodyGenContext,
    code: &mut W,
) -> bool {
    // Special handling for Invoke: store expression if MoveResult follows
    if let InsnType::Invoke { kind, method_idx, args } = &insn.insn_type {
        // Check if this is an <init> call on a pending new-instance
        if matches!(kind, InvokeKind::Direct) {
            // Get method info to check if this is <init>
            if let Some(method_info) = ctx.expr_gen.get_method_value(*method_idx) {
                if method_info.method_name == "<init>" {
                    // Get the receiver register (first argument for non-static)
                    if let Some(InsnArg::Register(recv_reg)) = args.first() {
                        // Check if this register has a pending new-instance
                        if let Some(type_idx) = ctx.pending_new_instances.remove(&recv_reg.reg_num) {
                            // Get the type name
                            let type_name = ctx.expr_gen.get_type_value(type_idx)
                                .unwrap_or_else(|| format!("Type#{}", type_idx));

                            // Generate arguments (skip the receiver 'this')
                            let args_str: Vec<_> = args.iter()
                                .skip(1)
                                .map(|a| ctx.expr_gen.gen_arg(a))
                                .collect();

                            // Combined expression: new Type(args)
                            let expr = format!("new {}({})", type_name, args_str.join(", "));

                            // Create a synthetic RegisterArg for the destination
                            let dest = RegisterArg::with_ssa(recv_reg.reg_num, recv_reg.ssa_version);
                            emit_assignment(&dest, &expr, ctx, code);
                            return true;
                        }
                    }
                }
            }
        }

        // Normal invoke handling
        let expr = if let Some(expr) = ctx.expr_gen.gen_insn(&insn.insn_type) {
            expr
        } else {
            // Fallback
            let args_str: Vec<_> = args.iter().map(|a| ctx.expr_gen.gen_arg(a)).collect();
            format!("method#{}({})", method_idx, args_str.join(", "))
        };

        if next_is_move_result {
            // Store expression for MoveResult to use
            ctx.last_invoke_expr = Some(expr);
        } else {
            // No MoveResult follows: emit as statement (void return or discarded)
            code.start_line().add(&expr).add(";").newline();
        }
        return true;
    }

    // For all other instructions, use the standard generator
    generate_insn(insn, ctx, code)
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
            // Type hint from literal type
            let type_hint = match value {
                LiteralArg::Int(v) if *v >= i32::MIN as i64 && *v <= i32::MAX as i64 => Some(ArgType::Int),
                LiteralArg::Int(_) => Some(ArgType::Long),
                LiteralArg::Float(_) => Some(ArgType::Float),
                LiteralArg::Double(_) => Some(ArgType::Double),
                LiteralArg::Null => None, // null can be any object type
            };
            emit_assignment_with_hint(dest, &val_str, type_hint.as_ref(), ctx, code);
            true
        }

        InsnType::ConstString { dest, string_idx } => {
            // Use gen_insn to properly resolve the string value from DexInfo
            let value = ctx.expr_gen.gen_insn(&insn.insn_type)
                .unwrap_or_else(|| format!("string#{}", string_idx));
            // String type hint
            let string_type = ArgType::Object("java/lang/String".to_string());
            emit_assignment_with_hint(dest, &value, Some(&string_type), ctx, code);
            true
        }

        InsnType::Move { dest, src } => {
            let src_str = ctx.expr_gen.gen_arg(src);
            emit_assignment(dest, &src_str, ctx, code);
            true
        }

        InsnType::MoveResult { dest } => {
            // Use the stored invoke expression from the previous invoke
            let expr = ctx.last_invoke_expr.take()
                .unwrap_or_else(|| "/* result */".to_string());
            emit_assignment(dest, &expr, ctx, code);
            true
        }

        InsnType::MoveException { dest: _ } => {
            // MoveException captures the caught exception - this is implicit in Java's
            // catch clause syntax (catch (Type e) { ... }), so we don't emit anything
            true
        }

        InsnType::NewInstance { dest, type_idx } => {
            // Don't emit code here - track this as a pending new-instance
            // It will be combined with the following invoke-direct <init> call
            ctx.pending_new_instances.insert(dest.reg_num, *type_idx);
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
            // ArrayLength always returns int
            emit_assignment_with_hint(dest, &value, Some(&ArgType::Int), ctx, code);
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
            let field_ref = ctx.expr_gen.get_static_field_ref(*field_idx)
                .unwrap_or_else(|| format!("field#{}", field_idx));
            emit_assignment(dest, &field_ref, ctx, code);
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

        InsnType::Unary { dest, op: _, arg: _ } => {
            if let Some(expr) = ctx.expr_gen.gen_insn(&insn.insn_type) {
                emit_assignment(dest, &expr, ctx, code);
                true
            } else {
                false
            }
        }

        InsnType::Binary { dest, op: _, left: _, right: _ } => {
            if let Some(expr) = ctx.expr_gen.gen_insn(&insn.insn_type) {
                emit_assignment(dest, &expr, ctx, code);
                true
            } else {
                false
            }
        }

        InsnType::Cast { dest, cast_type: _, arg: _ } => {
            if let Some(expr) = ctx.expr_gen.gen_insn(&insn.insn_type) {
                emit_assignment(dest, &expr, ctx, code);
                true
            } else {
                false
            }
        }

        InsnType::Compare { dest, op: _, left: _, right: _ } => {
            if let Some(expr) = ctx.expr_gen.gen_insn(&insn.insn_type) {
                emit_assignment(dest, &expr, ctx, code);
                true
            } else {
                false
            }
        }

        InsnType::InstanceOf { dest, object, type_idx } => {
            let obj_str = ctx.expr_gen.gen_arg(object);
            let type_name = ctx.expr_gen.get_type_value(*type_idx)
                .unwrap_or_else(|| format!("Type#{}", type_idx));
            let expr = format!("{} instanceof {}", obj_str, type_name);
            emit_assignment(dest, &expr, ctx, code);
            true
        }

        InsnType::CheckCast { object, type_idx } => {
            // Check-cast is a runtime type check + cast
            // Generate as: var = (Type) var;
            let obj_str = ctx.expr_gen.gen_arg(object);
            if let Some(cast_expr) = ctx.expr_gen.gen_insn(&insn.insn_type) {
                code.start_line()
                    .add(&obj_str)
                    .add(" = ")
                    .add(&cast_expr)
                    .add(";")
                    .newline();
            } else {
                // Fallback with type index
                code.start_line()
                    .add(&obj_str)
                    .add(" = (Type#")
                    .add(&type_idx.to_string())
                    .add(") ")
                    .add(&obj_str)
                    .add(";")
                    .newline();
            }
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
            let type_name = ctx.expr_gen.get_type_value(*type_idx)
                .unwrap_or_else(|| format!("Type#{}", type_idx));
            let expr = format!("{}.class", type_name);
            emit_assignment(dest, &expr, ctx, code);
            true
        }

        InsnType::FilledNewArray { dest, type_idx, args } => {
            let args_str: Vec<_> = args.iter().map(|a| ctx.expr_gen.gen_arg(a)).collect();
            let type_name = ctx.expr_gen.get_type_value(*type_idx)
                .unwrap_or_else(|| format!("Type#{}", type_idx));
            let expr = format!("new {}[] {{ {} }}", type_name, args_str.join(", "));
            if let Some(d) = dest {
                emit_assignment(d, &expr, ctx, code);
            }
            true
        }

        InsnType::FillArrayData { array: _, payload_offset: _ } => {
            // TODO: Parse array data payload and generate array initialization
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
