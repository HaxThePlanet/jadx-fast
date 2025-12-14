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

use std::collections::{BTreeMap, BTreeSet, HashMap, HashSet};

use jadx_ir::attributes::AFlag;
use jadx_ir::instructions::{IfCondition, InsnArg, InsnNode, InsnType, InvokeKind, LiteralArg};
use jadx_ir::regions::{Condition, LoopKind, Region, RegionContent};
use jadx_ir::types::ArgType;
use jadx_ir::MethodData;
use jadx_passes::block_split::{split_blocks, BasicBlock};
use jadx_passes::cfg::CFG;
use jadx_passes::region_builder::{build_regions_with_try_catch, mark_duplicated_finally};
use jadx_passes::ssa::{transform_to_ssa, transform_to_ssa_owned, SsaResult, SsaBlock};
use jadx_passes::type_inference::{infer_types, TypeInferenceResult};

use crate::class_gen::is_anonymous_class;
use crate::dex_info::DexInfoProvider;
use crate::expr_gen::ExprGen;
use crate::method_gen::{generate_method_with_dex, should_emit_annotation, generate_annotation};
use crate::stmt_gen::{
    gen_break, gen_close_block, gen_do_while_end, gen_do_while_start, gen_else, gen_else_if,
    gen_if_header, gen_while_header,
};
use crate::type_gen::{type_to_string, type_to_string_with_imports};
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
    /// Imports set for using simple type names (internal class names without L; wrapper)
    pub imports: Option<BTreeSet<String>>,
    /// Use counts for each variable (reg, version) - how many times it's read
    pub use_counts: HashMap<(u16, u32), usize>,
    /// Inlined expressions - variables with single use store their expression here
    pub inlined_exprs: HashMap<(u16, u32), String>,
    /// Anonymous class registry - maps type descriptor to ClassData for inline generation
    /// Uses Arc to avoid cloning ClassData for every method
    pub anonymous_classes: HashMap<String, std::sync::Arc<jadx_ir::ClassData>>,
    /// Variables that are final (only assigned once)
    /// A variable is final if max_versions[reg] == 0 (never reassigned after initial assignment)
    pub final_vars: HashSet<(u16, u32)>,
}

impl Drop for BodyGenContext {
    fn drop(&mut self) {
        // Move expr_gen out and return to pool
        // We need to swap it with a temporary one since we can't move out of &mut self
        let temp = ExprGen::new();
        let old = std::mem::replace(&mut self.expr_gen, temp);
        old.return_to_pool();
    }
}

impl BodyGenContext {
    /// Create a new body generation context from method data
    pub fn from_method(method: &MethodData) -> Self {
        Self::from_method_with_dex(method, None)
    }

    /// Create a new body generation context from method data with DEX info for name resolution
    pub fn from_method_with_dex(method: &MethodData, dex_info: Option<std::sync::Arc<dyn DexInfoProvider>>) -> Self {
        Self::from_method_with_dex_and_inner_classes(method, dex_info, None)
    }

    /// Create a new body generation context with DEX info and inner classes for anonymous class inlining
    pub fn from_method_with_dex_and_inner_classes(
        method: &MethodData,
        dex_info: Option<std::sync::Arc<dyn DexInfoProvider>>,
        inner_classes: Option<&std::collections::HashMap<String, std::sync::Arc<jadx_ir::ClassData>>>,
    ) -> Self {
        let mut expr_gen = ExprGen::from_pool();

        // Set DEX provider for lazy lookups during code generation
        if let Some(ref dex) = dex_info {
            expr_gen.set_dex_provider(dex.clone());
        }

        // Set up parameter names based on method signature
        // Parameters are in the last `ins_count` registers
        let first_param_reg = method.regs_count.saturating_sub(method.ins_count);
        let is_static = method.is_static();
        let param_offset = if is_static { 0 } else { 1 }; // Skip 'this' for instance methods

        for (i, param_type) in method.arg_types.iter().enumerate() {
            let reg = first_param_reg + param_offset as u16 + i as u16;
            // Use debug info name if available, otherwise generate from type
            let name = method.arg_names.get(i)
                .and_then(|n| n.clone())
                .unwrap_or_else(|| generate_param_name(i, param_type));
            expr_gen.set_var_name(reg, 0, name);
            expr_gen.set_var_type(reg, 0, param_type.clone());
        }

        // Set up 'this' if instance method
        if !is_static && method.ins_count > 0 {
            expr_gen.set_var_name(first_param_reg, 0, "this".to_string());
        }

        // Register anonymous inner classes for inline generation
        // Using Arc avoids expensive deep cloning - just increment reference count
        let mut anonymous_classes = HashMap::new();
        if let Some(inner) = inner_classes {
            for (class_type, class_data) in inner {
                if is_anonymous_class(class_type) {
                    anonymous_classes.insert(class_type.clone(), class_data.clone());
                }
            }
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
            imports: None,
            use_counts: HashMap::new(),
            inlined_exprs: HashMap::new(),
            anonymous_classes,
            final_vars: HashSet::new(),
        }
    }

    /// Register an anonymous class for inline generation
    pub fn register_anonymous_class(&mut self, type_desc: String, class_data: jadx_ir::ClassData) {
        self.anonymous_classes.insert(type_desc, std::sync::Arc::new(class_data));
    }

    /// Get an anonymous class by type descriptor
    pub fn get_anonymous_class(&self, type_desc: &str) -> Option<&jadx_ir::ClassData> {
        self.anonymous_classes.get(type_desc).map(|arc| arc.as_ref())
    }

    /// Check if a variable should be inlined (used exactly once and has an expression)
    pub fn should_inline(&self, reg: u16, version: u32) -> bool {
        // Don't inline parameters
        if self.is_parameter(reg, version) {
            return false;
        }
        // Check use count - only inline if used exactly once
        self.use_counts.get(&(reg, version)).copied().unwrap_or(0) == 1
    }

    /// Store an expression for potential inlining
    pub fn store_inline_expr(&mut self, reg: u16, version: u32, expr: String) {
        self.inlined_exprs.insert((reg, version), expr);
    }

    /// Get inlined expression if available, removing it from storage
    pub fn take_inline_expr(&mut self, reg: u16, version: u32) -> Option<String> {
        self.inlined_exprs.remove(&(reg, version))
    }

    /// Generate argument expression, substituting inlined expressions for single-use variables
    pub fn gen_arg_inline(&mut self, arg: &InsnArg) -> String {
        if let InsnArg::Register(reg) = arg {
            // Check if we have an inlined expression for this register
            if let Some(expr) = self.take_inline_expr(reg.reg_num, reg.ssa_version) {
                return expr;
            }
        }
        // Fall back to normal expression generation
        self.expr_gen.gen_arg(arg)
    }

    /// OPTIMIZED: Write arg directly to CodeWriter without String allocation
    /// This is the zero-allocation pattern following Java JADX design
    pub fn write_arg_inline<W: CodeWriter>(&mut self, writer: &mut W, arg: &InsnArg) {
        if let InsnArg::Register(reg) = arg {
            // Check if we have an inlined expression for this register
            if let Some(expr) = self.take_inline_expr(reg.reg_num, reg.ssa_version) {
                writer.add(&expr);
                return;
            }
        }
        // Fall back to direct write via ExprGen
        self.expr_gen.write_arg(writer, arg);
    }

    /// Set imports for using simple type names in variable declarations
    pub fn set_imports(&mut self, imports: Option<BTreeSet<String>>) {
        self.imports = imports;
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

    /// Check if a variable is final (only assigned once)
    pub fn is_final(&self, reg: u16, version: u32) -> bool {
        self.final_vars.contains(&(reg, version))
    }

    /// Compute final variables from SSA max_versions
    /// A variable is final if max_versions[reg] == 1 (only one definition - version 1)
    /// SSA versioning starts at 1 for the first definition
    pub fn set_final_vars_from_max_versions(&mut self, max_versions: &HashMap<u16, u32>) {
        for (&reg, &max_version) in max_versions {
            if max_version == 1 {
                // Only version 1 exists for this register (one definition) - it's final
                self.final_vars.insert((reg, 1));
            }
        }
    }
}

use jadx_ir::instructions::RegisterArg;

/// Count variable uses across all blocks
/// Returns a map of (reg, version) -> use count
fn count_variable_uses(blocks: &BTreeMap<u32, BasicBlock>) -> HashMap<(u16, u32), usize> {
    let mut counts: HashMap<(u16, u32), usize> = HashMap::new();

    for block in blocks.values() {
        for insn_arc in &block.instructions {
            let insn = insn_arc.lock().unwrap();
            // Count uses in instruction arguments
            count_uses_in_insn(&insn.insn_type, &mut counts);
        }
    }

    counts
}

/// Count variable uses within a single instruction
fn count_uses_in_insn(insn: &InsnType, counts: &mut HashMap<(u16, u32), usize>) {
    // Helper to count uses in an InsnArg
    let mut count_arg = |arg: &InsnArg| {
        if let InsnArg::Register(reg) = arg {
            *counts.entry((reg.reg_num, reg.ssa_version)).or_insert(0) += 1;
        }
    };

    match insn {
        InsnType::Return { value: Some(v) } => count_arg(v),
        InsnType::Throw { exception } => count_arg(exception),
        InsnType::Move { src, .. } => count_arg(src),
        InsnType::NewArray { size, .. } => count_arg(size),
        InsnType::ArrayLength { array, .. } => count_arg(array),
        InsnType::ArrayGet { array, index, .. } => {
            count_arg(array);
            count_arg(index);
        }
        InsnType::ArrayPut { array, index, value, .. } => {
            count_arg(array);
            count_arg(index);
            count_arg(value);
        }
        InsnType::InstanceGet { object, .. } => count_arg(object),
        InsnType::InstancePut { object, value, .. } => {
            count_arg(object);
            count_arg(value);
        }
        InsnType::StaticPut { value, .. } => count_arg(value),
        InsnType::Invoke { args, .. } => {
            for arg in args {
                count_arg(arg);
            }
        }
        InsnType::Unary { arg, .. } => count_arg(arg),
        InsnType::Binary { left, right, .. } => {
            count_arg(left);
            count_arg(right);
        }
        InsnType::Cast { arg, .. } => count_arg(arg),
        InsnType::Compare { left, right, .. } => {
            count_arg(left);
            count_arg(right);
        }
        InsnType::InstanceOf { object, .. } => count_arg(object),
        InsnType::CheckCast { object, .. } => count_arg(object),
        InsnType::MonitorEnter { object } | InsnType::MonitorExit { object } => count_arg(object),
        InsnType::FilledNewArray { args, .. } => {
            for arg in args {
                count_arg(arg);
            }
        }
        InsnType::FillArrayData { array, .. } => count_arg(array),
        InsnType::If { left, right, .. } => {
            count_arg(left);
            if let Some(r) = right {
                count_arg(r);
            }
        }
        InsnType::PackedSwitch { value, .. } | InsnType::SparseSwitch { value, .. } => count_arg(value),
        InsnType::Phi { sources, .. } => {
            for (_, arg) in sources {
                count_arg(arg);
            }
        }
        // Instructions that don't use registers as sources
        InsnType::Nop | InsnType::Return { value: None } | InsnType::Const { .. }
        | InsnType::ConstString { .. } | InsnType::ConstClass { .. }
        | InsnType::NewInstance { .. } | InsnType::MoveResult { .. }
        | InsnType::MoveException { .. } | InsnType::StaticGet { .. }
        | InsnType::Goto { .. } | InsnType::Break { .. } | InsnType::Continue { .. } => {}
    }
}

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
    let reg = dest.reg_num;
    let version = dest.ssa_version;

    // Check if this variable should be inlined (used exactly once)
    if ctx.should_inline(reg, version) {
        // Store the expression for later inlining instead of emitting
        ctx.store_inline_expr(reg, version, value_str.to_string());
        return;
    }

    let var_name = ctx.expr_gen.get_var_name(dest);

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

        // Emit 'final' keyword if this variable is only assigned once
        if ctx.is_final(reg, version) {
            code.add("final ");
        }

        if let Some(arg_type) = decl_type {
            // Use simple names when imports are available
            let type_str = type_to_string_with_imports(arg_type, ctx.imports.as_ref());
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

/// OPTIMIZED: Emit assignment with direct write from InsnType - avoids String allocation
/// For most cases, writes expression directly to CodeWriter. Only falls back to String
/// allocation for the rare inlining case (variable used exactly once).
fn emit_assignment_insn<W: CodeWriter>(
    dest: &RegisterArg,
    insn: &InsnType,
    type_hint: Option<&ArgType>,
    ctx: &mut BodyGenContext,
    code: &mut W,
) -> bool {
    let reg = dest.reg_num;
    let version = dest.ssa_version;

    // Check if this variable should be inlined (used exactly once)
    // This is the rare case where we need the String for deferred emission
    if ctx.should_inline(reg, version) {
        if let Some(expr_str) = ctx.expr_gen.gen_insn(insn) {
            ctx.store_inline_expr(reg, version, expr_str);
            return true;
        }
        return false;
    }

    let var_name = ctx.expr_gen.get_var_name(dest);

    code.start_line();

    // Check if we need to declare this variable
    if !ctx.is_declared(reg, version) && !ctx.is_parameter(reg, version) {
        let decl_type = ctx.get_inferred_type_versioned(reg, version)
            .or_else(|| type_hint)
            .or_else(|| {
                if version != 0 {
                    ctx.get_inferred_type_versioned(reg, 0)
                } else {
                    None
                }
            });

        if ctx.is_final(reg, version) {
            code.add("final ");
        }

        if let Some(arg_type) = decl_type {
            let type_str = type_to_string_with_imports(arg_type, ctx.imports.as_ref());
            code.add(&type_str).add(" ");
        } else {
            code.add("Object ");
        }
        ctx.mark_declared(reg, version);
    }

    code.add(&var_name).add(" = ");

    // OPTIMIZED: Write expression directly without String allocation
    if ctx.expr_gen.write_insn(code, insn) {
        code.add(";").newline();
        true
    } else {
        // Fallback for unsupported instruction types
        code.add("/* unsupported */;").newline();
        false
    }
}

/// Generate method body from instructions
pub fn generate_body<W: CodeWriter>(method: &MethodData, code: &mut W) {
    let insns = match method.instructions() {
        Some(i) if !i.is_empty() => i,
        _ => {
            code.start_line()
                .add("/* empty method */")
                .newline();
            add_default_return(&method.return_type, code);
            return;
        }
    };

    // Split into basic blocks (pass reference to avoid Vec clone)
    let block_result = split_blocks(insns);

    if block_result.blocks.is_empty() {
        code.start_line()
            .add("/* no blocks */")
            .newline();
        add_default_return(&method.return_type, code);
        return;
    }

    // Build CFG for dominance analysis (takes ownership, no clone needed)
    let mut cfg = CFG::from_blocks(block_result);

    // Mark duplicated finally code before region building (JADX compatibility)
    mark_duplicated_finally(&mut cfg, &method.try_blocks);

    // Build region tree for structured code with try-catch support
    // Region analysis only needs instruction types for control flow, not SSA info
    let region = build_regions_with_try_catch(&cfg, &method.try_blocks);

    // Extract blocks from CFG after region analysis
    let block_result = cfg.into_blocks();

    // SSA transformation - use owned version to avoid cloning instructions
    let ssa_result = transform_to_ssa_owned(block_result);

    // Type inference on SSA form
    let type_result = infer_types(&ssa_result);

    // Create generation context with type info
    let mut ctx = BodyGenContext::from_method(method);
    // Extract max_versions before consuming ssa_result (small HashMap, cheap to move)
    let max_versions = ssa_result.max_versions.clone();
    // Use SSA blocks instead of CFG blocks to preserve SSA versions for proper variable naming
    // Use owned version to avoid cloning instructions again
    ctx.blocks = ssa_blocks_to_map_owned(ssa_result);
    ctx.type_info = Some(type_result);

    // Count variable uses for expression inlining
    ctx.use_counts = count_variable_uses(&ctx.blocks);

    // Compute final variables from SSA - variables with max_version == 0 are final
    ctx.set_final_vars_from_max_versions(&max_versions);

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
    generate_body_with_dex_and_imports(method, dex_info, None, code)
}

/// Generate method body from instructions with DEX info and imports for name resolution
///
/// When `dex_info` is provided, indices like `Type#123` resolve to actual
/// class names like `TextView`, and `field#456` becomes actual field names.
/// When `imports` is provided, imported types use simple names instead of fully qualified.
pub fn generate_body_with_dex_and_imports<W: CodeWriter>(
    method: &MethodData,
    dex_info: Option<std::sync::Arc<dyn DexInfoProvider>>,
    imports: Option<&BTreeSet<String>>,
    code: &mut W,
) {
    let insns = match method.instructions() {
        Some(i) if !i.is_empty() => i,
        _ => {
            code.start_line()
                .add("/* empty method */")
                .newline();
            add_default_return(&method.return_type, code);
            return;
        }
    };

    // Split into basic blocks (pass reference to avoid Vec clone)
    let block_result = split_blocks(insns);

    if block_result.blocks.is_empty() {
        code.start_line()
            .add("/* no blocks */")
            .newline();
        add_default_return(&method.return_type, code);
        return;
    }

    // Build CFG for dominance analysis (takes ownership, no clone needed)
    let mut cfg = CFG::from_blocks(block_result);

    // Mark duplicated finally code before region building (JADX compatibility)
    mark_duplicated_finally(&mut cfg, &method.try_blocks);

    // Build region tree for structured code with try-catch support
    // Region analysis only needs instruction types for control flow, not SSA info
    let region = build_regions_with_try_catch(&cfg, &method.try_blocks);

    // Extract blocks from CFG after region analysis
    let block_result = cfg.into_blocks();

    // SSA transformation - use owned version to avoid cloning instructions
    let ssa_result = transform_to_ssa_owned(block_result);

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

    // Create generation context with type info and DEX data for name resolution
    let mut ctx = BodyGenContext::from_method_with_dex(method, dex_info.clone());
    // Extract max_versions before consuming ssa_result
    let max_versions = ssa_result.max_versions.clone();
    // Use SSA blocks instead of CFG blocks to preserve SSA versions for proper variable naming
    // Use owned version to avoid cloning instructions again
    ctx.blocks = ssa_blocks_to_map_owned(ssa_result);
    ctx.type_info = Some(type_result);
    // Set imports for using simple type names in variable declarations
    ctx.imports = imports.cloned();

    // Count variable uses for expression inlining
    ctx.use_counts = count_variable_uses(&ctx.blocks);

    // Compute final variables from SSA - variables with max_version == 0 are final
    ctx.set_final_vars_from_max_versions(&max_versions);

    // Apply inferred types and generate variable names
    apply_inferred_types(&mut ctx);
    generate_var_names(&mut ctx);

    // Generate code from region tree
    generate_region(&region, &mut ctx, code);
}

/// Generate method body from instructions with inner classes for anonymous class inlining
///
/// When `inner_classes` is provided, anonymous inner class instantiations will have
/// their method bodies inlined instead of just `new AnonymousClass()`.
pub fn generate_body_with_inner_classes<W: CodeWriter>(
    method: &MethodData,
    dex_info: Option<std::sync::Arc<dyn DexInfoProvider>>,
    imports: Option<&BTreeSet<String>>,
    inner_classes: Option<&HashMap<String, std::sync::Arc<jadx_ir::ClassData>>>,
    hierarchy: Option<&jadx_ir::ClassHierarchy>,
    code: &mut W,
) {
    let insns = match method.instructions() {
        Some(i) if !i.is_empty() => i,
        _ => {
            code.start_line()
                .add("/* empty method */")
                .newline();
            add_default_return(&method.return_type, code);
            return;
        }
    };

    // POTENTIAL: Split into basic blocks (pass reference to avoid Vec clone)
    let block_result = split_blocks(insns);

    if block_result.blocks.is_empty() {
        code.start_line()
            .add("/* no blocks */")
            .newline();
        add_default_return(&method.return_type, code);
        return;
    }

    // POTENTIAL: Build CFG for dominance analysis (takes ownership, no clone needed)
    let mut cfg = CFG::from_blocks(block_result);

    // POTENTIAL: Mark duplicated finally code before region building (JADX compatibility)
    mark_duplicated_finally(&mut cfg, &method.try_blocks);

    // POTENTIAL: Build region tree for structured code with try-catch support
    // Region analysis only needs instruction types for control flow, not SSA info
    let region = build_regions_with_try_catch(&cfg, &method.try_blocks);

    // POTENTIAL: Extract blocks from CFG after region analysis
    let block_result = cfg.into_blocks();

    // POTENTIAL: SSA transformation - use owned version to avoid cloning instructions
    let ssa_result = transform_to_ssa_owned(block_result);

    // POTENTIAL: Type inference on SSA form (use hierarchy for better precision if available)
    // Hierarchy enables LCA calculation for PHI nodes and subtype checking
    let type_result = if let Some(h) = hierarchy {
        jadx_passes::infer_types_with_hierarchy(&ssa_result, h)
    } else if let Some(ref dex) = dex_info {
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

    // CLEAN: Create generation context with type info and DEX data for name resolution
    let mut ctx = BodyGenContext::from_method_with_dex(method, dex_info.clone());
    // CLEAN: Extract max_versions before consuming ssa_result
    let max_versions = ssa_result.max_versions.clone();
    // CLEAN: Use owned version to avoid cloning instructions again
    ctx.blocks = ssa_blocks_to_map_owned(ssa_result);
    ctx.type_info = Some(type_result);
    ctx.imports = imports.cloned();

    // POTENTIAL: Register inner classes for anonymous class inlining
    // Using Arc avoids expensive deep cloning - just increment reference count
    if let Some(inner) = inner_classes {
        for (type_desc, class_data) in inner {
            // Only register anonymous classes
            if is_anonymous_class(type_desc) {
                ctx.anonymous_classes.insert(type_desc.clone(), class_data.clone());
            }
        }
    }

    // POTENTIAL: Count variable uses for expression inlining
    ctx.use_counts = count_variable_uses(&ctx.blocks);

    // POTENTIAL: Compute final variables from SSA - variables with max_version == 0 are final
    ctx.set_final_vars_from_max_versions(&max_versions);

    // POTENTIAL: Apply inferred types and generate variable names
    apply_inferred_types(&mut ctx);
    generate_var_names(&mut ctx);

    // POTENTIAL: Generate region code
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
            // Following JADX's getAliasShortName() approach:
            // 1. Split on / (package separator in internal format)
            // 2. Split on $ (inner classes)
            // 3. Split on . (qualified names like BillingClient.Builder)
            let simple = name.rsplit('/').next().unwrap_or(name);
            let simple = simple.trim_start_matches('L').trim_end_matches(';');
            let simple = simple.rsplit('$').next().unwrap_or(simple);
            let simple = simple.rsplit('.').next().unwrap_or(simple);

            // Check if all uppercase (like ABC) - convert entirely to lowercase
            if simple.chars().all(|c| !c.is_ascii_lowercase()) && !simple.is_empty() {
                simple.to_lowercase()
            } else {
                // Normal case: lowercase first character only
                let mut chars = simple.chars();
                match chars.next() {
                    Some(c) => c.to_lowercase().chain(chars).collect(),
                    None => "obj".to_string(),
                }
            }
        }
        ArgType::Array(elem) => {
            format!("{}Arr", type_to_var_name(elem))
        }
        ArgType::Unknown => "v".to_string(),
        ArgType::Generic { base, .. } => {
            // Use base class name for generics
            // Following JADX's getAliasShortName() approach:
            // 1. Split on / (package separator in internal format)
            // 2. Split on $ (inner classes)
            // 3. Split on . (qualified names)
            let simple = base.rsplit('/').next().unwrap_or(base);
            let simple = simple.trim_start_matches('L').trim_end_matches(';');
            let simple = simple.rsplit('$').next().unwrap_or(simple);
            let simple = simple.rsplit('.').next().unwrap_or(simple);

            // Check if all uppercase (like ABC) - convert entirely to lowercase
            if simple.chars().all(|c| !c.is_ascii_lowercase()) && !simple.is_empty() {
                simple.to_lowercase()
            } else {
                // Normal case: lowercase first character only
                let mut chars = simple.chars();
                match chars.next() {
                    Some(c) => c.to_lowercase().chain(chars).collect(),
                    None => "obj".to_string(),
                }
            }
        }
        ArgType::Wildcard { .. } => "w".to_string(),
    }
}

/// Detect if a condition block contains a hasNext() call (iterator pattern)
/// Returns Some((iterator_reg, hasNext_call_str)) if detected
fn detect_iterator_pattern(condition: &Condition, ctx: &BodyGenContext) -> Option<(u16, String)> {
    if let Condition::Simple { block, .. } = condition {
        if let Some(basic_block) = ctx.blocks.get(block) {
            // Look for an Invoke instruction calling hasNext()
            for insn_arc in basic_block.instructions.iter() {
                let insn = insn_arc.lock().unwrap();
                // Check both Interface and Virtual invokes (ArrayList uses virtual, interface uses interface)
                if let InsnType::Invoke { kind, method_idx, args } = &insn.insn_type {
                    if matches!(kind, InvokeKind::Interface | InvokeKind::Virtual) {
                        if let Some(method_info) = ctx.expr_gen.get_method_value(*method_idx) {
                            if method_info.method_name == "hasNext" && args.len() == 1 {
                                // Found hasNext() call - extract the iterator register
                                if let InsnArg::Register(reg) = &args[0] {
                                    let iter_str = ctx.expr_gen.gen_arg(&InsnArg::Register(*reg));
                                    return Some((reg.reg_num, iter_str));
                                }
                            }
                        }
                    }
                }
            }
        }
    }
    None
}

/// ForEach loop detection result
struct ForEachInfo {
    /// The item variable name
    item_var: String,
    /// The item type (from cast or inferred)
    item_type: Option<String>,
}

/// Detect if a region body starts with a next() call on the given iterator register
/// Returns ForEachInfo with item variable name and optional type
fn detect_next_call(body: &Region, iterator_reg: u16, ctx: &BodyGenContext) -> Option<ForEachInfo> {
    // Get the first block in the body
    let first_block = match body {
        Region::Sequence(contents) if !contents.is_empty() => {
            match &contents[0] {
                RegionContent::Block(b) => Some(*b),
                _ => None,
            }
        }
        _ => None,
    }?;

    let block = ctx.blocks.get(&first_block)?;

    // Look for an Invoke calling next() on the iterator
    for (i, insn_arc) in block.instructions.iter().enumerate() {
        let insn = insn_arc.lock().unwrap();
        // Check both Interface and Virtual invokes
        if let InsnType::Invoke { kind, method_idx, args } = &insn.insn_type {
            if matches!(kind, InvokeKind::Interface | InvokeKind::Virtual) {
                if let Some(method_info) = ctx.expr_gen.get_method_value(*method_idx) {
                    if method_info.method_name == "next" && args.len() == 1 {
                        if let InsnArg::Register(reg) = &args[0] {
                            if reg.reg_num == iterator_reg {
                                // Found next() call on the same iterator
                                // Look for MoveResult to get item variable name
                                let mut item_var = "item".to_string();
                                let mut item_type: Option<String> = None;

                                // Check next instruction for MoveResult
                                if i + 1 < block.instructions.len() {
                                    let next_insn = block.instructions[i + 1].lock().unwrap();
                                    if let InsnType::MoveResult { dest } = &next_insn.insn_type {
                                        item_var = ctx.expr_gen.get_var_name(dest);
                                        drop(next_insn);

                                        // Check for CheckCast following MoveResult to get item type
                                        if i + 2 < block.instructions.len() {
                                            let cast_insn = block.instructions[i + 2].lock().unwrap();
                                            if let InsnType::CheckCast { type_idx, .. } = &cast_insn.insn_type {
                                                if let Some(type_name) = ctx.expr_gen.get_type_value(*type_idx) {
                                                    let simple = type_name.rsplit('/').next().unwrap_or(&type_name);
                                                    item_type = Some(simple.to_string());
                                                }
                                            }
                                        }
                                    }
                                }

                                return Some(ForEachInfo { item_var, item_type });
                            }
                        }
                    }
                }
            }
        }
    }
    None
}

/// Generate else or else-if chain
/// If the else region is another If, generates `} else if (cond) {` instead of `} else { if (cond) {`
fn generate_else_chain<W: CodeWriter>(else_region: &Region, ctx: &mut BodyGenContext, code: &mut W) {
    match else_region {
        Region::If { condition, then_region, else_region: nested_else } => {
            // Check if this could be a ternary - if so, don't chain
            if let Some(nested_else_reg) = nested_else {
                if detect_ternary_pattern(then_region, nested_else_reg, ctx).is_some() {
                    // Emit as regular else with ternary inside
                    gen_else(code);
                    generate_region(else_region, ctx, code);
                    return;
                }
            }

            // Generate else-if
            let condition_str = generate_condition(condition, ctx);
            gen_else_if(&condition_str, code);
            generate_region(then_region, ctx, code);

            // Recursively handle the nested else (could be another if or final else)
            if let Some(nested_else_reg) = nested_else {
                generate_else_chain(nested_else_reg, ctx, code);
            }
        }
        _ => {
            // Not an If region - generate regular else
            gen_else(code);
            generate_region(else_region, ctx, code);
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
                for insn_arc in basic_block.instructions.iter().rev() {
                    let insn = insn_arc.lock().unwrap();
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

/// Information about a detected ternary expression
struct TernaryExprInfo {
    /// Destination register
    dest_reg: u16,
    /// SSA version of destination
    dest_version: u32,
    /// Expression string for the "then" value
    then_value: String,
    /// Expression string for the "else" value
    else_value: String,
}

/// Detect if an if/else can be converted to a ternary expression
/// Returns Some with ternary info if both branches assign to the same variable
fn detect_ternary_pattern(
    then_region: &Region,
    else_region: &Region,
    ctx: &BodyGenContext,
) -> Option<TernaryExprInfo> {
    // Try simple single-block pattern first
    if let Some(info) = detect_simple_ternary(then_region, else_region, ctx) {
        return Some(info);
    }

    // Try ternary chain pattern: else branch is another if/else assigning to same var
    if let Region::Sequence(contents) = else_region {
        if contents.len() == 1 {
            if let RegionContent::Region(inner) = &contents[0] {
                if let Region::If { condition: inner_cond, then_region: inner_then, else_region: inner_else } = inner.as_ref() {
                    // The else is a nested if/else - check if it's a ternary chain
                    if let (Some(inner_else_reg), Some(then_dest_info)) =
                        (inner_else.as_ref(), get_branch_assignment_info(then_region, ctx))
                    {
                        // Check if the nested if/else also assigns to the same variable
                        if let Some(chain_ternary) = detect_ternary_pattern(inner_then, inner_else_reg, ctx) {
                            if chain_ternary.dest_reg == then_dest_info.0 {
                                // Build chained ternary: then_val : (inner_cond ? inner_then : inner_else)
                                let inner_cond_str = generate_condition(inner_cond, ctx);
                                let chained_else = format!(
                                    "{} ? {} : {}",
                                    wrap_ternary_condition(&inner_cond_str),
                                    chain_ternary.then_value,
                                    chain_ternary.else_value
                                );
                                return Some(TernaryExprInfo {
                                    dest_reg: then_dest_info.0,
                                    dest_version: then_dest_info.1,
                                    then_value: then_dest_info.2,
                                    else_value: chained_else,
                                });
                            }
                        }
                    }
                }
            }
        }
    }

    None
}

/// Detect simple ternary pattern (both branches are single blocks with one assignment)
fn detect_simple_ternary(
    then_region: &Region,
    else_region: &Region,
    ctx: &BodyGenContext,
) -> Option<TernaryExprInfo> {
    // Both branches must be simple sequences with single blocks
    let then_block_id = get_single_block(then_region)?;
    let else_block_id = get_single_block(else_region)?;

    let then_block = ctx.blocks.get(&then_block_id)?;
    let else_block = ctx.blocks.get(&else_block_id)?;

    // Get non-control-flow instructions from each block
    let then_insns: Vec<_> = then_block.instructions.iter()
        .filter_map(|i| {
            let insn = i.lock().unwrap();
            if !is_control_flow(&insn.insn_type) {
                Some(i.clone())
            } else {
                None
            }
        })
        .collect();
    let else_insns: Vec<_> = else_block.instructions.iter()
        .filter_map(|i| {
            let insn = i.lock().unwrap();
            if !is_control_flow(&insn.insn_type) {
                Some(i.clone())
            } else {
                None
            }
        })
        .collect();

    // Allow up to 2 instructions if the last one is an assignment
    // (handles cases like loading a constant then using it)
    if then_insns.is_empty() || else_insns.is_empty() || then_insns.len() > 2 || else_insns.len() > 2 {
        return None;
    }

    // Last instruction in each block must be an assignment to the same register
    let then_insn_arc = then_insns.last()?;
    let else_insn_arc = else_insns.last()?;

    let then_insn = then_insn_arc.lock().unwrap();
    let else_insn = else_insn_arc.lock().unwrap();

    let then_dest = get_insn_dest(&then_insn.insn_type)?;
    let else_dest = get_insn_dest(&else_insn.insn_type)?;

    if then_dest.0 != else_dest.0 {
        return None;
    }

    // Get the value expressions
    let then_value = get_insn_value_expr(&then_insn.insn_type, ctx)?;
    let else_value = get_insn_value_expr(&else_insn.insn_type, ctx)?;

    Some(TernaryExprInfo {
        dest_reg: then_dest.0,
        dest_version: then_dest.1,
        then_value,
        else_value,
    })
}

/// Get assignment info from a branch region (dest_reg, dest_version, value_expr)
fn get_branch_assignment_info(region: &Region, ctx: &BodyGenContext) -> Option<(u16, u32, String)> {
    let block_id = get_single_block(region)?;
    let block = ctx.blocks.get(&block_id)?;

    let insns: Vec<_> = block.instructions.iter()
        .filter_map(|i| {
            let insn = i.lock().unwrap();
            if !is_control_flow(&insn.insn_type) {
                Some(i.clone())
            } else {
                None
            }
        })
        .collect();

    if insns.is_empty() || insns.len() > 2 {
        return None;
    }

    let last_insn_arc = insns.last()?;
    let last_insn = last_insn_arc.lock().unwrap();
    let dest = get_insn_dest(&last_insn.insn_type)?;
    let value = get_insn_value_expr(&last_insn.insn_type, ctx)?;

    Some((dest.0, dest.1, value))
}

/// Wrap a condition string for use inside a ternary (add parens if needed)
fn wrap_ternary_condition(s: &str) -> String {
    // Add parens if the condition contains ternary or logical operators
    if s.contains(" ? ") || s.contains(" || ") || s.contains(" && ") {
        format!("({})", s)
    } else {
        s.to_string()
    }
}

/// Get the single block from a region if it's a simple sequence with one block
fn get_single_block(region: &Region) -> Option<u32> {
    match region {
        Region::Sequence(contents) if contents.len() == 1 => {
            if let RegionContent::Block(id) = &contents[0] {
                Some(*id)
            } else {
                None
            }
        }
        _ => None,
    }
}

/// Get the destination register from an instruction
fn get_insn_dest(insn: &InsnType) -> Option<(u16, u32)> {
    match insn {
        InsnType::Const { dest, .. }
        | InsnType::ConstString { dest, .. }
        | InsnType::Move { dest, .. }
        | InsnType::MoveResult { dest }
        | InsnType::NewInstance { dest, .. }
        | InsnType::NewArray { dest, .. }
        | InsnType::ArrayLength { dest, .. }
        | InsnType::ArrayGet { dest, .. }
        | InsnType::InstanceGet { dest, .. }
        | InsnType::StaticGet { dest, .. }
        | InsnType::Unary { dest, .. }
        | InsnType::Binary { dest, .. }
        | InsnType::Cast { dest, .. }
        | InsnType::Compare { dest, .. }
        | InsnType::InstanceOf { dest, .. }
        | InsnType::ConstClass { dest, .. } => Some((dest.reg_num, dest.ssa_version)),
        InsnType::Phi { dest, .. } => Some((dest.reg_num, dest.ssa_version)),
        _ => None,
    }
}

/// Get the value expression from an assignment instruction
fn get_insn_value_expr(insn: &InsnType, ctx: &BodyGenContext) -> Option<String> {
    match insn {
        InsnType::Const { value, .. } => Some(ctx.expr_gen.gen_literal(value)),
        InsnType::ConstString { string_idx, .. } => {
            Some(ctx.expr_gen.get_string_value(*string_idx)
                .map(|s| format!("\"{}\"", s))
                .unwrap_or_else(|| format!("string#{}", string_idx)))
        }
        InsnType::Move { src, .. } => Some(ctx.expr_gen.gen_arg(src)),
        InsnType::StaticGet { field_idx, .. } => {
            Some(ctx.expr_gen.get_static_field_ref(*field_idx)
                .unwrap_or_else(|| format!("field#{}", field_idx)))
        }
        InsnType::InstanceGet { object, field_idx, .. } => {
            let obj_str = ctx.expr_gen.gen_arg(object);
            let field_name = ctx.expr_gen.get_field_name(*field_idx)
                .unwrap_or_else(|| format!("field#{}", field_idx));
            Some(format!("{}.{}", obj_str, field_name))
        }
        InsnType::Unary { .. } => {
            ctx.expr_gen.gen_insn(insn)
        }
        InsnType::Binary { .. } => {
            ctx.expr_gen.gen_insn(insn)
        }
        _ => ctx.expr_gen.gen_insn(insn),
    }
}

/// Emit a ternary assignment: dest = cond ? then_val : else_val
fn emit_ternary_assignment<W: CodeWriter>(
    ternary: &TernaryExprInfo,
    condition_str: &str,
    ctx: &mut BodyGenContext,
    code: &mut W,
) {
    use jadx_ir::instructions::RegisterArg;

    let var_name = ctx.expr_gen.get_var_name(&RegisterArg::with_ssa(ternary.dest_reg, ternary.dest_version));
    let reg = ternary.dest_reg;
    let version = ternary.dest_version;

    code.start_line();

    // Check if we need to declare this variable
    if !ctx.is_declared(reg, version) && !ctx.is_parameter(reg, version) {
        let decl_type = ctx.get_inferred_type_versioned(reg, version)
            .or_else(|| ctx.get_inferred_type_versioned(reg, 0));

        if let Some(arg_type) = decl_type {
            let type_str = type_to_string_with_imports(arg_type, ctx.imports.as_ref());
            code.add(&type_str).add(" ");
        } else {
            code.add("Object ");
        }
        ctx.mark_declared(reg, version);
    }

    // Generate ternary expression
    code.add(&var_name)
        .add(" = ")
        .add(condition_str)
        .add(" ? ")
        .add(&ternary.then_value)
        .add(" : ")
        .add(&ternary.else_value)
        .add(";")
        .newline();
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
        let start_offset = ssa_block.instructions.first().map(|i| {
            let insn = i.lock().unwrap();
            insn.offset
        }).unwrap_or(0);
        let end_offset = ssa_block.instructions.last().map(|i| {
            let insn = i.lock().unwrap();
            insn.offset + 1
        }).unwrap_or(0);
        let basic_block = BasicBlock {
            id: ssa_block.id,
            start_offset,
            end_offset,
            instructions: ssa_block.instructions.clone(),
            insn_indices: Vec::new(),  // TODO: Populate with actual indices when Phase 3 is complete
            successors: ssa_block.successors.clone(),
            predecessors: ssa_block.predecessors.clone(),
            flags: 0,
        };
        map.insert(ssa_block.id, basic_block);
    }
    map
}

/// Convert SSA blocks to BasicBlock map by taking ownership (no cloning)
/// This is the memory-efficient version
fn ssa_blocks_to_map_owned(ssa_result: jadx_passes::ssa::SsaResult) -> BTreeMap<u32, BasicBlock> {
    let mut map = BTreeMap::new();
    for ssa_block in ssa_result.blocks {
        // Compute offsets from instructions
        let start_offset = ssa_block.instructions.first().map(|i| {
            let insn = i.lock().unwrap();
            insn.offset
        }).unwrap_or(0);
        let end_offset = ssa_block.instructions.last().map(|i| {
            let insn = i.lock().unwrap();
            insn.offset + 1
        }).unwrap_or(0);
        let basic_block = BasicBlock {
            id: ssa_block.id,
            start_offset,
            end_offset,
            instructions: ssa_block.instructions, // Move, not clone!
            insn_indices: Vec::new(),  // TODO: Populate with actual indices when Phase 3 is complete
            successors: ssa_block.successors,     // Move, not clone!
            predecessors: ssa_block.predecessors, // Move, not clone!
            flags: 0,
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
            // Check if this if/else can be converted to a ternary expression
            if let Some(else_reg) = else_region {
                if let Some(ternary) = detect_ternary_pattern(then_region, else_reg, ctx) {
                    // Generate ternary expression: dest = cond ? then_val : else_val
                    let condition_str = generate_condition(condition, ctx);
                    emit_ternary_assignment(&ternary, &condition_str, ctx, code);
                    return;
                }
            }

            // Standard if/else generation
            let condition_str = generate_condition(condition, ctx);

            gen_if_header(&condition_str, code);
            generate_region(then_region, ctx, code);

            if let Some(else_reg) = else_region {
                // Check if the else region is another If - chain as else-if
                generate_else_chain(else_reg, ctx, code);
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
                    // Check if this While loop is actually a ForEach (iterator pattern)
                    if let Some(cond) = condition {
                        if let Some((iter_reg, iter_str)) = detect_iterator_pattern(cond, ctx) {
                            if let Some(foreach_info) = detect_next_call(body, iter_reg, ctx) {
                                // Generate for-each style syntax
                                let item_type = foreach_info.item_type.as_deref().unwrap_or("Object");
                                let collection = iter_str.replace(".hasNext()", "")
                                    .trim_end()
                                    .to_string();
                                code.start_line()
                                    .add("for (")
                                    .add(item_type)
                                    .add(" ")
                                    .add(&foreach_info.item_var)
                                    .add(" : ")
                                    .add(&collection)
                                    .add(") {")
                                    .newline();
                                code.inc_indent();
                                generate_region(body, ctx, code);
                                gen_close_block(code);
                                return;
                            }
                        }
                    }
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
                    // Already classified as ForEach - try to extract iterator info
                    if let Some(cond) = condition {
                        if let Some((iter_reg, iter_str)) = detect_iterator_pattern(cond, ctx) {
                            if let Some(foreach_info) = detect_next_call(body, iter_reg, ctx) {
                                let item_type = foreach_info.item_type.as_deref().unwrap_or("Object");
                                let collection = iter_str.replace(".hasNext()", "")
                                    .trim_end()
                                    .to_string();
                                code.start_line()
                                    .add("for (")
                                    .add(item_type)
                                    .add(" ")
                                    .add(&foreach_info.item_var)
                                    .add(" : ")
                                    .add(&collection)
                                    .add(") {")
                                    .newline();
                                code.inc_indent();
                                generate_region(body, ctx, code);
                                gen_close_block(code);
                                return;
                            }
                        }
                    }
                    // Fallback
                    gen_while_header("/* iterator.hasNext() */", code);
                    generate_region(body, ctx, code);
                    gen_close_block(code);
                }
            }
        }

        Region::Switch { header_block, cases, default } => {
            // Extract switch value from the header block's switch instruction
            let switch_value = ctx.blocks.get(header_block)
                .and_then(|block| block.instructions.iter().rev().find_map(|insn_arc| {
                    let insn = insn_arc.lock().unwrap();
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
                // Generate catch clause - support multi-catch syntax
                if handler.catch_all {
                    // Catch-all handler
                    let exc_var = generate_exception_var_name("Throwable", i);
                    code.start_line()
                        .add("} catch (Throwable ")
                        .add(&exc_var)
                        .add(") {")
                        .newline();
                } else if handler.is_multi_catch() {
                    // Multi-catch: catch (Type1 | Type2 | Type3 e)
                    let exc_types = handler.exception_types.join(" | ");
                    let first_type = handler.exception_types.first()
                        .map(|s| s.as_str())
                        .unwrap_or("Exception");
                    let exc_var = generate_exception_var_name(first_type, i);
                    code.start_line()
                        .add("} catch (")
                        .add(&exc_types)
                        .add(" ")
                        .add(&exc_var)
                        .add(") {")
                        .newline();
                } else {
                    // Single exception type
                    let exc_type = handler.exception_type()
                        .unwrap_or("Exception");
                    let exc_var = generate_exception_var_name(exc_type, i);
                    code.start_line()
                        .add("} catch (")
                        .add(exc_type)
                        .add(" ")
                        .add(&exc_var)
                        .add(") {")
                        .newline();
                }
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
                .and_then(|block| block.instructions.iter().find_map(|insn_arc| {
                    let insn = insn_arc.lock().unwrap();
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
            // OPTIMIZED: Release immutable borrow before taking mutable borrow
            // Step 1: Extract just what we need while holding immutable ref (cheap field copies)
            let (id, start, end, flags) = {
                if let Some(b) = ctx.blocks.get(block_id) {
                    (b.id, b.start_offset, b.end_offset, b.flags)
                } else {
                    return;
                }
            }; // <- immutable borrow ends here

            // Step 2: Now we can safely use mutable ctx
            // BUT we still need the instructions Vec - this requires a clone of the Arc pointers
            // Which is just memory copies (8 bytes each), not cloning the actual InsnNode data
            let instructions = ctx.blocks[block_id].instructions.clone();
            let block_ref = BasicBlock {
                id,
                start_offset: start,
                end_offset: end,
                instructions,
                insn_indices: Vec::new(),
                successors: Vec::new(),
                predecessors: Vec::new(),
                flags,
            };
            generate_block(&block_ref, ctx, code);
        }
        RegionContent::Region(region) => {
            generate_region(region, ctx, code);
        }
    }
}

/// Generate code for a basic block
fn generate_block<W: CodeWriter>(block: &BasicBlock, ctx: &mut BodyGenContext, code: &mut W) {
    // Skip blocks marked with DONT_GENERATE (duplicated finally code)
    if block.has_flag(AFlag::DontGenerate) {
        return;
    }

    let last_idx = block.instructions.len().saturating_sub(1);

    // OPTIMIZED: Iterate directly without collecting into Vec
    // This avoids allocating a Vec of Arc pointers which causes memory explosion
    for (i, insn_arc) in block.instructions.iter().enumerate() {
        let insn = insn_arc.lock().unwrap();
        // Skip instructions marked with DONT_GENERATE (duplicated finally code)
        if insn.has_flag(AFlag::DontGenerate) {
            continue;
        }

        // Skip control flow instructions - they're handled by region structure
        if is_control_flow(&insn.insn_type) {
            continue;
        }

        // Skip trailing void return - unnecessary in Java (common in constructors and void methods)
        if i == last_idx {
            if let InsnType::Return { value: None } = &insn.insn_type {
                continue;
            }
        }

        // OPTIMIZED: Peek at next instruction without collecting
        let next_is_move_result = if i + 1 < block.instructions.len() {
            let next_arc = &block.instructions[i + 1];
            let next = next_arc.lock().unwrap();
            matches!(next.insn_type, InsnType::MoveResult { .. })
        } else {
            false
        };

        // Generate statement or expression
        if !generate_insn_with_lookahead(&insn, next_is_move_result, ctx, code) {
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

/// Generate an anonymous class body inline
/// Returns the full expression: `new ParentType(args) { methods... }`
fn generate_anonymous_class_inline<W: CodeWriter>(
    class: &jadx_ir::ClassData,
    constructor_args: &str,
    imports: Option<&BTreeSet<String>>,
    dex_info: Option<std::sync::Arc<dyn DexInfoProvider>>,
    code: &mut W,
) {
    use crate::type_gen::get_simple_name;
    use crate::access_flags;

    // Determine parent type - prefer interface (for SAM), else superclass
    let parent_type = if !class.interfaces.is_empty() {
        // Use first interface
        get_simple_name(&class.interfaces[0])
    } else if let Some(ref superclass) = class.superclass {
        get_simple_name(superclass)
    } else {
        "Object"
    };

    // Start the anonymous class: new ParentType(args) {
    code.add("new ").add(parent_type).add("(").add(constructor_args).add(") {");

    // Check if we have any methods to generate (excluding constructors)
    let has_methods = class.methods.iter().any(|m| {
        !m.name.contains("<init>") && !m.name.contains("<clinit>")
            && !access_flags::is_synthetic(m.access_flags)
    });

    if has_methods {
        code.newline();
        code.inc_indent();

        // Generate methods (skip constructors and synthetic methods)
        for method in &class.methods {
            // Skip constructors
            if method.name.contains("<init>") || method.name.contains("<clinit>") {
                continue;
            }
            // Skip synthetic (compiler-generated bridge methods, etc.)
            if access_flags::is_synthetic(method.access_flags) {
                continue;
            }

            code.newline();
            generate_method_with_dex(method, class, false, imports, dex_info.clone(), code);
        }

        code.dec_indent();
        code.start_line();
    }

    code.add("}");
}

/// Generate an invoke expression with inlined arguments
/// OPTIMIZED: Write invoke expression directly to CodeWriter - avoids String allocation
/// This is the hot path for all method calls
fn write_invoke_with_inlining<W: CodeWriter>(
    kind: &InvokeKind,
    method_idx: u32,
    args: &[InsnArg],
    ctx: &mut BodyGenContext,
    code: &mut W,
) {
    // Get method info for proper formatting
    if let Some(info) = ctx.expr_gen.get_method_value(method_idx) {
        let skip_count = if matches!(kind, InvokeKind::Static) { 0 } else { 1 };

        match kind {
            InvokeKind::Static => {
                code.add(&info.class_name).add(".").add(&info.method_name).add("(");
                for (i, a) in args.iter().enumerate() {
                    if i > 0 { code.add(", "); }
                    ctx.write_arg_inline(code, a);
                }
                code.add(")");
            }
            InvokeKind::Virtual | InvokeKind::Interface | InvokeKind::Direct => {
                if info.method_name == "<init>" {
                    // Check receiver - need to determine if "this" or other
                    let is_this = args.first().map(|a| {
                        matches!(a, InsnArg::Register(r) if r.reg_num == 0 && r.ssa_version == 0)
                    }).unwrap_or(false);

                    if is_this {
                        code.add("super(");
                    } else {
                        code.add("new ").add(&info.class_name).add("(");
                    }
                } else {
                    if let Some(receiver) = args.first() {
                        ctx.write_arg_inline(code, receiver);
                        code.add(".");
                    }
                    code.add(&info.method_name).add("(");
                }
                for (i, a) in args.iter().skip(skip_count).enumerate() {
                    if i > 0 { code.add(", "); }
                    ctx.write_arg_inline(code, a);
                }
                code.add(")");
            }
            InvokeKind::Super => {
                if info.method_name == "<init>" {
                    code.add("super(");
                } else {
                    code.add("super.").add(&info.method_name).add("(");
                }
                for (i, a) in args.iter().skip(skip_count).enumerate() {
                    if i > 0 { code.add(", "); }
                    ctx.write_arg_inline(code, a);
                }
                code.add(")");
            }
            _ => {
                code.add("method#").add(&method_idx.to_string()).add("(");
                for (i, a) in args.iter().enumerate() {
                    if i > 0 { code.add(", "); }
                    ctx.write_arg_inline(code, a);
                }
                code.add(")");
            }
        }
    } else {
        // Fallback without method info
        code.add("method#").add(&method_idx.to_string()).add("(");
        for (i, a) in args.iter().enumerate() {
            if i > 0 { code.add(", "); }
            ctx.write_arg_inline(code, a);
        }
        code.add(")");
    }
}

fn gen_invoke_with_inlining(
    kind: &InvokeKind,
    method_idx: u32,
    args: &[InsnArg],
    ctx: &mut BodyGenContext,
) -> String {
    // Get method info for proper formatting
    if let Some(info) = ctx.expr_gen.get_method_value(method_idx) {
        // Generate arguments with inlining (skip 'this' for non-static)
        let skip_count = if matches!(kind, InvokeKind::Static) { 0 } else { 1 };
        let args_str: Vec<_> = args.iter()
            .skip(skip_count)
            .map(|a| ctx.gen_arg_inline(a))
            .collect();

        match kind {
            InvokeKind::Static => {
                format!("{}.{}({})", info.class_name, info.method_name, args_str.join(", "))
            }
            InvokeKind::Virtual | InvokeKind::Interface | InvokeKind::Direct => {
                let receiver = args.first().map(|a| ctx.gen_arg_inline(a)).unwrap_or_default();
                if info.method_name == "<init>" {
                    if receiver == "this" {
                        format!("super({})", args_str.join(", "))
                    } else {
                        format!("new {}({})", info.class_name, args_str.join(", "))
                    }
                } else {
                    format!("{}.{}({})", receiver, info.method_name, args_str.join(", "))
                }
            }
            InvokeKind::Super => {
                if info.method_name == "<init>" {
                    format!("super({})", args_str.join(", "))
                } else {
                    format!("super.{}({})", info.method_name, args_str.join(", "))
                }
            }
            _ => {
                let args_str: Vec<_> = args.iter().map(|a| ctx.gen_arg_inline(a)).collect();
                format!("method#{}({})", method_idx, args_str.join(", "))
            }
        }
    } else {
        // Fallback without method info
        let args_str: Vec<_> = args.iter().map(|a| ctx.gen_arg_inline(a)).collect();
        format!("method#{}({})", method_idx, args_str.join(", "))
    }
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
                            // Get the type name and descriptor
                            let type_name = ctx.expr_gen.get_type_value(type_idx)
                                .unwrap_or_else(|| format!("Type#{}", type_idx));

                            // Get the type descriptor for anonymous class lookup
                            let type_desc = if let Some(ref dex) = ctx.expr_gen.dex_provider {
                                dex.get_type_descriptor(type_idx)
                            } else {
                                None
                            };

                            // Check if this is an anonymous class we should inline
                            let is_anon = type_desc.as_ref()
                                .map(|d| is_anonymous_class(d))
                                .unwrap_or(false);

                            if is_anon {
                                // Check if we have this anonymous class registered
                                let anon_class_key = type_desc.clone();
                                if anon_class_key.as_ref().map(|k| ctx.anonymous_classes.contains_key(k)).unwrap_or(false) {
                                    // Get needed info before taking the class out
                                    let var_name = ctx.expr_gen.get_var_name(recv_reg);
                                    let reg = recv_reg.reg_num;
                                    let version = recv_reg.ssa_version;
                                    let needs_decl = !ctx.is_declared(reg, version) && !ctx.is_parameter(reg, version);
                                    let imports = ctx.imports.clone();
                                    let dex = ctx.expr_gen.dex_provider.clone();

                                    // Take the class out temporarily to avoid borrow conflict
                                    let anon_class = ctx.anonymous_classes.remove(anon_class_key.as_ref().unwrap()).unwrap();

                                    // Extract declaration type
                                    let decl_type = if !anon_class.interfaces.is_empty() {
                                        crate::type_gen::get_simple_name(&anon_class.interfaces[0]).to_string()
                                    } else if let Some(ref superclass) = anon_class.superclass {
                                        crate::type_gen::get_simple_name(superclass).to_string()
                                    } else {
                                        "Object".to_string()
                                    };

                                    // Declare variable if needed
                                    code.start_line();
                                    if needs_decl {
                                        code.add(&decl_type).add(" ");
                                        ctx.mark_declared(reg, version);
                                    }
                                    code.add(&var_name).add(" = ");

                                    // OPTIMIZED: Generate constructor args inline for anonymous class
                                    // Need to build String for generate_anonymous_class_inline signature
                                    let args_str: Vec<_> = args.iter()
                                        .skip(1)
                                        .map(|a| ctx.gen_arg_inline(a))
                                        .collect();
                                    let constructor_args = args_str.join(", ");

                                    // Generate the anonymous class body
                                    generate_anonymous_class_inline(
                                        anon_class.as_ref(),
                                        &constructor_args,
                                        imports.as_ref(),
                                        dex,
                                        code,
                                    );
                                    code.add(";").newline();

                                    // Put it back (in case it's used multiple times - unlikely for anonymous)
                                    ctx.anonymous_classes.insert(anon_class_key.unwrap(), anon_class);

                                    return true;
                                }
                            }

                            // OPTIMIZED: Regular class instantiation - direct write
                            let reg = recv_reg.reg_num;
                            let version = recv_reg.ssa_version;
                            let var_name = ctx.expr_gen.get_var_name(recv_reg);

                            code.start_line();
                            if !ctx.is_declared(reg, version) && !ctx.is_parameter(reg, version) {
                                code.add(&type_name).add(" ");
                                ctx.mark_declared(reg, version);
                            }
                            code.add(&var_name).add(" = new ").add(&type_name).add("(");
                            for (i, a) in args.iter().skip(1).enumerate() {
                                if i > 0 { code.add(", "); }
                                ctx.write_arg_inline(code, a);
                            }
                            code.add(");").newline();
                            return true;
                        }
                    }
                }
            }
        }

        // Normal invoke handling - use inlining for arguments
        if next_is_move_result {
            // Store expression for MoveResult to use (needs String)
            let expr = gen_invoke_with_inlining(kind, *method_idx, args, ctx);
            ctx.last_invoke_expr = Some(expr);
        } else {
            // OPTIMIZED: No MoveResult follows - write directly without String allocation
            code.start_line();
            write_invoke_with_inlining(kind, *method_idx, args, ctx, code);
            code.add(";").newline();
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
                code.add(" ");
                ctx.write_arg_inline(code, v);  // OPTIMIZED: direct write
            }
            code.add(";").newline();
            true
        }

        InsnType::Throw { exception } => {
            code.start_line().add("throw ");
            ctx.write_arg_inline(code, exception);  // OPTIMIZED: direct write
            code.add(";").newline();
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

        InsnType::ConstString { dest, .. } => {
            // OPTIMIZED: Direct write with String type hint
            let string_type = ArgType::Object("java/lang/String".to_string());
            emit_assignment_insn(dest, &insn.insn_type, Some(&string_type), ctx, code);
            true
        }

        InsnType::Move { dest, .. } => {
            // OPTIMIZED: Direct write
            emit_assignment_insn(dest, &insn.insn_type, None, ctx, code);
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

        InsnType::NewArray { dest, .. } => {
            // OPTIMIZED: Direct write
            emit_assignment_insn(dest, &insn.insn_type, None, ctx, code);
            true
        }

        InsnType::ArrayLength { dest, .. } => {
            // OPTIMIZED: Direct write with int type hint
            emit_assignment_insn(dest, &insn.insn_type, Some(&ArgType::Int), ctx, code);
            true
        }

        InsnType::ArrayGet { dest, .. } => {
            // OPTIMIZED: Direct write
            emit_assignment_insn(dest, &insn.insn_type, None, ctx, code);
            true
        }

        InsnType::ArrayPut { array, index, value, .. } => {
            // OPTIMIZED: Direct write without String allocation
            code.start_line();
            ctx.expr_gen.write_arg(code, array);
            code.add("[");
            ctx.expr_gen.write_arg(code, index);
            code.add("] = ");
            ctx.expr_gen.write_arg(code, value);
            code.add(";").newline();
            true
        }

        InsnType::InstanceGet { dest, .. } => {
            // OPTIMIZED: Direct write
            emit_assignment_insn(dest, &insn.insn_type, None, ctx, code);
            true
        }

        InsnType::InstancePut { object, field_idx, value } => {
            // OPTIMIZED: Direct write without String allocation
            let field_name = ctx.expr_gen.get_field_name(*field_idx)
                .unwrap_or_else(|| format!("field#{}", field_idx));
            code.start_line();
            ctx.expr_gen.write_arg(code, object);
            code.add(".").add(&field_name).add(" = ");
            ctx.expr_gen.write_arg(code, value);
            code.add(";").newline();
            true
        }

        InsnType::StaticGet { dest, .. } => {
            // OPTIMIZED: Direct write
            emit_assignment_insn(dest, &insn.insn_type, None, ctx, code);
            true
        }

        InsnType::StaticPut { field_idx, value } => {
            // OPTIMIZED: Direct write without String allocation
            let field_ref = ctx.expr_gen.get_static_field_ref(*field_idx)
                .unwrap_or_else(|| format!("field#{}", field_idx));
            code.start_line().add(&field_ref).add(" = ");
            ctx.expr_gen.write_arg(code, value);
            code.add(";").newline();
            true
        }

        InsnType::Invoke { .. } => {
            // OPTIMIZED: Direct write without String allocation
            code.start_line();
            ctx.expr_gen.write_insn(code, &insn.insn_type);
            code.add(";").newline();
            true
        }

        InsnType::Unary { dest, .. } => {
            // OPTIMIZED: Direct write
            emit_assignment_insn(dest, &insn.insn_type, None, ctx, code);
            true
        }

        InsnType::Binary { dest, .. } => {
            // OPTIMIZED: Direct write
            emit_assignment_insn(dest, &insn.insn_type, None, ctx, code);
            true
        }

        InsnType::Cast { dest, .. } => {
            // OPTIMIZED: Direct write
            emit_assignment_insn(dest, &insn.insn_type, None, ctx, code);
            true
        }

        InsnType::Compare { dest, .. } => {
            // OPTIMIZED: Direct write
            emit_assignment_insn(dest, &insn.insn_type, None, ctx, code);
            true
        }

        InsnType::InstanceOf { dest, .. } => {
            // OPTIMIZED: Direct write
            emit_assignment_insn(dest, &insn.insn_type, None, ctx, code);
            true
        }

        InsnType::CheckCast { object, .. } => {
            // Check-cast is a runtime type check + cast
            // Generate as: var = (Type) var;
            // OPTIMIZED: Direct write without String allocation
            code.start_line();
            ctx.expr_gen.write_arg(code, object);
            code.add(" = ");
            ctx.expr_gen.write_insn(code, &insn.insn_type);
            code.add(";").newline();
            true
        }

        InsnType::MonitorEnter { object } => {
            // OPTIMIZED: Direct write without String allocation
            code.start_line().add("synchronized (");
            ctx.expr_gen.write_arg(code, object);
            code.add(") {").newline();
            code.inc_indent();
            true
        }

        InsnType::MonitorExit { object: _ } => {
            code.dec_indent();
            code.start_line().add("}").newline();
            true
        }

        InsnType::ConstClass { dest, .. } => {
            // OPTIMIZED: Direct write
            emit_assignment_insn(dest, &insn.insn_type, None, ctx, code);
            true
        }

        InsnType::FilledNewArray { dest, type_idx, args } => {
            // OPTIMIZED: Direct write avoiding Vec<String> allocation
            let type_name = ctx.expr_gen.get_type_value(*type_idx)
                .unwrap_or_else(|| format!("Type#{}", type_idx));
            if let Some(d) = dest {
                let reg = d.reg_num;
                let version = d.ssa_version;

                // Check inlining (rare case - needs String)
                if ctx.should_inline(reg, version) {
                    let args_str: Vec<_> = args.iter().map(|a| ctx.expr_gen.gen_arg(a)).collect();
                    let expr = format!("new {}[] {{ {} }}", type_name, args_str.join(", "));
                    ctx.store_inline_expr(reg, version, expr);
                } else {
                    let var_name = ctx.expr_gen.get_var_name(d);
                    code.start_line();

                    // Emit type declaration if needed
                    if !ctx.is_declared(reg, version) && !ctx.is_parameter(reg, version) {
                        if ctx.is_final(reg, version) {
                            code.add("final ");
                        }
                        code.add(&type_name).add("[] ");
                        ctx.mark_declared(reg, version);
                    }

                    code.add(&var_name).add(" = new ").add(&type_name).add("[] { ");
                    for (i, a) in args.iter().enumerate() {
                        if i > 0 { code.add(", "); }
                        ctx.expr_gen.write_arg(code, a);
                    }
                    code.add(" };").newline();
                }
            }
            true
        }

        InsnType::FillArrayData { array, payload_offset, element_width, data } => {
            if data.is_empty() {
                // Payload not parsed, emit placeholder comment
                code.start_line()
                    .add("/* fill-array-data at offset ")
                    .add(&payload_offset.to_string())
                    .add(" */")
                    .newline();
            } else {
                // OPTIMIZED: Write directly to CodeWriter - no Vec<String> allocation
                // Determine element type from width
                let elem_type = match element_width {
                    1 => "byte",
                    2 => "short",
                    4 => "int",
                    8 => "long",
                    _ => "int",
                };

                // Helper to write a single value directly to writer
                fn write_array_value<W: CodeWriter>(code: &mut W, value: i64, element_width: u8) {
                    match element_width {
                        1 => { code.add(&(value as i8).to_string()); }
                        2 => {
                            let char_val = value as u16;
                            if char_val >= 32 && char_val < 127 && char_val != '\'' as u16 {
                                code.add("'");
                                code.add(&char::from_u32(char_val as u32).unwrap_or('?').to_string());
                                code.add("'");
                            } else {
                                code.add(&(value as i16).to_string());
                            }
                        }
                        4 => { code.add(&(value as i32).to_string()); }
                        8 => { code.add(&value.to_string()); code.add("L"); }
                        _ => { code.add(&value.to_string()); }
                    }
                }

                code.start_line();
                ctx.expr_gen.write_arg(code, array);
                code.add(" = new ").add(elem_type).add("[]{");

                if data.len() <= 16 {
                    // Compact inline literal - write all on one line
                    for (i, value) in data.iter().enumerate() {
                        if i > 0 { code.add(", "); }
                        write_array_value(code, *value, *element_width);
                    }
                    code.add("};").newline();
                } else {
                    // Multi-line for large arrays
                    code.newline();
                    code.inc_indent();
                    for (i, value) in data.iter().enumerate() {
                        if i % 10 == 0 {
                            if i > 0 { code.add(",").newline(); }
                            code.start_line();
                        } else {
                            code.add(", ");
                        }
                        write_array_value(code, *value, *element_width);
                    }
                    code.newline();
                    code.dec_indent();
                    code.start_line().add("};").newline();
                }
            }
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
            // For inner classes, use the innermost class name
            let simple = simple.rsplit('$').next().unwrap_or(simple);
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
        method.set_instructions(vec![InsnNode::new(
            InsnType::Return { value: None },
            0,
        )]);

        let mut writer = SimpleCodeWriter::new();
        generate_body(&method, &mut writer);
        let code = writer.finish();
        // Trailing void return is now skipped as unnecessary in Java
        assert!(!code.contains("return;"));
    }

    #[test]
    fn test_const_and_return() {
        let mut method = MethodData::new("test".to_string(), 0x0001, ArgType::Int);
        method.regs_count = 1;

        method.set_instructions(vec![
            InsnNode::new(
                InsnType::Const {
                    dest: RegisterArg::new(0),
                    value: LiteralArg::Int(42),
                },
                0,
            ),
            InsnNode::new(
                InsnType::Return {
                    value: Some(InsnArg::reg(0)),
                },
                1,
            ),
        ]);

        let mut writer = SimpleCodeWriter::new();
        generate_body(&method, &mut writer);
        let code = writer.finish();
        assert!(code.contains("42"));
        assert!(code.contains("return"));
    }

    #[test]
    fn test_anonymous_class_detection() {
        use crate::class_gen::is_anonymous_class;

        // Test anonymous class detection patterns
        assert!(is_anonymous_class("Lcom/example/Outer$1;"), "Simple anonymous class");
        assert!(is_anonymous_class("Lcom/example/Outer$2;"), "Numbered anonymous class");
        assert!(is_anonymous_class("Lcom/example/Outer$Inner$1;"), "Nested anonymous class");
        assert!(!is_anonymous_class("Lcom/example/Outer$Inner;"), "Named inner class");
        assert!(!is_anonymous_class("Lcom/example/Outer;"), "Regular class");
        assert!(!is_anonymous_class("Lcom/example/R$layout;"), "R inner class");
    }

    #[test]
    fn test_anonymous_class_inline_generator() {
        use crate::writer::SimpleCodeWriter;
        use jadx_ir::ClassData;

        // Create a simple anonymous class that implements Runnable
        let mut anon_class = ClassData::new("Lcom/example/Test$1;".to_string(), 0x0001);
        anon_class.interfaces.push("Ljava/lang/Runnable;".to_string());

        // Add a run() method
        let mut run_method = MethodData::new("run".to_string(), 0x0001, ArgType::Void);
        run_method.regs_count = 1;
        run_method.ins_count = 1;
        // Empty body - just return
        run_method.set_instructions(vec![jadx_ir::instructions::InsnNode::new(
            jadx_ir::instructions::InsnType::Return { value: None },
            0,
        )]);
        anon_class.methods.push(run_method);

        // Generate the anonymous class inline
        let mut writer = SimpleCodeWriter::new();
        super::generate_anonymous_class_inline(
            &anon_class,
            "",  // no constructor args
            None,  // no imports
            None,  // no dex info
            &mut writer,
        );
        let code = writer.finish();

        // Verify the output format
        assert!(code.contains("new Runnable()"), "Should use interface name: {}", code);
        assert!(code.contains("{"), "Should have opening brace: {}", code);
        assert!(code.contains("}"), "Should have closing brace: {}", code);
    }

    #[test]
    fn test_final_variable_tracking() {
        // Test that variables used multiple times but never reassigned are marked final
        let mut method = MethodData::new("test".to_string(), 0x0001, ArgType::Void);
        method.regs_count = 2;

        // Build instructions and set via API
        method.set_instructions(vec![
            // v0 = 42 (assigned once, used twice -> should be final)
            InsnNode::new(
                InsnType::Const {
                    dest: RegisterArg::new(0),
                    value: LiteralArg::Int(42),
                },
                0,
            ),
            // v1 = v0 (first use of v0)
            InsnNode::new(
                InsnType::Move {
                    dest: RegisterArg::new(1),
                    src: InsnArg::reg(0),
                },
                1,
            ),
            // return v0 (second use of v0)
            InsnNode::new(
                InsnType::Return {
                    value: Some(InsnArg::reg(0)),
                },
                2,
            ),
        ]);

        // Test the SSA transform directly to see max_versions
        let block_result = jadx_passes::block_split::split_blocks(method.get_instructions());
        let ssa_result = jadx_passes::ssa::transform_to_ssa(&block_result);

        // Debug: print max_versions
        eprintln!("max_versions: {:?}", ssa_result.max_versions);

        // Verify the SSA result - SSA versioning starts at 1 for first definition
        assert_eq!(ssa_result.max_versions.get(&0), Some(&1), "Register 0 should have max_version 1 (one definition)");
        assert_eq!(ssa_result.max_versions.get(&1), Some(&1), "Register 1 should have max_version 1 (one definition)");

        let mut writer = SimpleCodeWriter::new();
        generate_body(&method, &mut writer);
        let code = writer.finish();

        eprintln!("Generated code:\n{}", code);

        // v0 is used twice and never reassigned - should be final
        assert!(code.contains("final"), "Expected 'final' keyword for variable used multiple times but never reassigned. Code: {}", code);
    }

    #[test]
    fn test_type_to_var_name_with_dots() {
        // Test variable naming with qualified class names (following JADX logic)
        // BillingClient.Builder should become "builder" not "billingClient.Builder"

        // Test simple class name
        assert_eq!(
            type_to_var_name(&ArgType::Object("java/lang/String".to_string())),
            "string"
        );

        // Test inner classes with $
        assert_eq!(
            type_to_var_name(&ArgType::Object("com/example/Outer$Inner".to_string())),
            "inner"
        );

        // Test qualified names with dots (main bug fix)
        assert_eq!(
            type_to_var_name(&ArgType::Object("com/google/android/gms/billing/BillingClient.Builder".to_string())),
            "builder"
        );

        // Test multiple dots
        assert_eq!(
            type_to_var_name(&ArgType::Object("com/example/Outer$Middle.Inner".to_string())),
            "inner"
        );

        // Test all-uppercase names
        assert_eq!(
            type_to_var_name(&ArgType::Object("com/example/ABC".to_string())),
            "abc"
        );

        // Test generic with qualified base
        assert_eq!(
            type_to_var_name(&ArgType::Generic {
                base: "java/util/List.Node".to_string(),
                params: vec![]
            }),
            "node"
        );
    }
}
