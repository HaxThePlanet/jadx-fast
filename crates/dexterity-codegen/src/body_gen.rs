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
use rustc_hash::FxHashMap;
use tracing::error;

use dexterity_ir::attributes::AFlag;
use dexterity_ir::instructions::{BinaryOp, IfCondition, InsnArg, InsnNode, InsnType, InvokeKind, LambdaInfo, LiteralArg};
use dexterity_ir::regions::{Condition, LoopKind, Region, RegionContent};
use dexterity_ir::types::ArgType;
use dexterity_ir::{MethodData, MethodInlineAttr, TryBlock};
use dexterity_passes::block_split::{split_blocks, BasicBlock};
use dexterity_passes::cfg::CFG;
use dexterity_passes::region_builder::{build_regions_with_try_catch, mark_duplicated_finally};
use dexterity_passes::ssa::transform_to_ssa_owned;
use dexterity_passes::type_inference::{infer_types, TypeInferenceResult};
use dexterity_passes::var_naming::types_compatible_for_naming;

use crate::class_gen::{get_inner_class_simple_name, is_anonymous_class};
use crate::dex_info::DexInfoProvider;
use crate::expr_gen::{BoxingType, ExprGen};
use crate::method_gen::generate_method_with_dex;
use crate::stmt_gen::{
    gen_break, gen_close_block, gen_do_while_end, gen_do_while_start, gen_else, gen_else_if,
    gen_if_header, gen_while_header, gen_for_header,
};
use crate::type_gen::{literal_to_string, object_to_java_name, type_to_string, type_to_string_with_imports};
use crate::writer::CodeWriter;

/// Sanitize a method name to be a valid Java identifier
/// Kotlin internal methods often have hyphens (e.g., set-impl, getGreen-0d7_KjU)
/// which are invalid Java identifiers. This converts hyphens to underscores.
fn sanitize_method_name(name: &str) -> String {
    if !name.contains('-') {
        return name.to_string();
    }
    name.replace('-', "_")
}

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
    /// Variables that have been declared (to avoid redeclaration) - tracks (reg, version)
    pub declared_vars: HashSet<(u16, u32)>,
    /// Variable names that have been declared, mapping to their declared type
    /// Used to detect when different SSA versions with incompatible types share the same name
    pub declared_name_types: HashMap<String, ArgType>,
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
    pub anonymous_classes: HashMap<String, std::sync::Arc<dexterity_ir::ClassData>>,
    /// Variables that are final (only assigned once)
    /// A variable is final if max_versions[reg] == 0 (never reassigned after initial assignment)
    pub final_vars: HashSet<(u16, u32)>,
    /// Current class type (internal format like "com/example/MyClass")
    /// Used to distinguish super() vs this() in constructor calls
    pub current_class_type: Option<String>,
    /// Phi node destinations that need early declaration at method start
    /// These are variables that merge values from multiple branches
    pub phi_declarations: HashSet<(u16, u32)>,
    /// Instructions to skip in for-each loops (block_id -> set of instruction indices)
    pub skip_foreach_insns: HashMap<u32, HashSet<usize>>,
    /// StringBuilder chain tracking for optimization
    /// Maps register number to chain of arguments for string concatenation
    /// When we see StringBuilder.<init> we start tracking, append() adds args,
    /// toString() emits concatenation instead of method chain
    pub stringbuilder_chains: HashMap<u16, StringBuilderChain>,
    /// Last StringBuilder register after append() - for MoveResult to transfer chain
    pub last_stringbuilder_reg: Option<u16>,
    /// Pending vararg arrays being tracked for expansion
    /// Key: (reg_num, ssa_version) - tracks NewArray + ArrayPut sequences
    pub pending_vararg_arrays: HashMap<(u16, u32), PendingVarargArray>,
    /// Last source line number seen (for tracking line changes)
    pub last_source_line: Option<u32>,
    /// Whether to emit debug line comments (// .line N)
    pub add_debug_lines: bool,
    /// Whether this method is a constructor (<init>)
    /// Used for single-branch ternary optimization
    pub is_constructor: bool,
    /// Synthetic lambda methods available for inlining
    /// Maps method name (e.g., "lambda$main$0") to method data
    pub lambda_methods: HashMap<String, std::sync::Arc<dexterity_ir::MethodData>>,
    /// Loop pattern analysis results (for/foreach detection)
    pub loop_patterns: dexterity_passes::LoopPatternResult,
    /// Current exception handler block ID (if currently generating code inside a catch block)
    /// Used to track exception context for proper variable declaration handling
    pub exception_handler_block: Option<u32>,
    /// Set of blocks that are exception handler entry points
    /// PHI nodes with sources from these blocks need special handling
    pub exception_handler_blocks: HashSet<u32>,
}

/// Tracks a StringBuilder chain for optimization to string concatenation
#[derive(Debug, Clone)]
pub struct StringBuilderChain {
    /// Arguments to concatenate (in order)
    pub args: Vec<String>,
    /// Whether the chain is still valid (set to false if non-append method is called)
    pub valid: bool,
}

/// Tracks a pending vararg array being built from NewArray + ArrayPut sequence
///
/// When we see `new Object[N]` followed by `arr[0] = v1; arr[1] = v2; ...`,
/// we track the elements so we can expand them as varargs at the invoke site.
#[derive(Debug, Clone)]
pub struct PendingVarargArray {
    /// Declared array size
    pub size: usize,
    /// Type index for element type
    pub type_idx: u32,
    /// Elements filled so far - indexed by array position
    /// None means that index hasn't been written yet
    pub elements: Vec<Option<String>>,
    /// Number of indices that have been filled
    pub filled_count: usize,
    /// Whether array has been invalidated (used in non-vararg context)
    pub invalidated: bool,
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
        inner_classes: Option<&std::collections::HashMap<String, std::sync::Arc<dexterity_ir::ClassData>>>,
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
            declared_name_types: HashMap::new(),
            first_param_reg,
            last_invoke_expr: None,
            pending_new_instances: HashMap::new(),
            imports: None,
            use_counts: HashMap::new(),
            inlined_exprs: HashMap::new(),
            anonymous_classes,
            final_vars: HashSet::new(),
            current_class_type: None,
            phi_declarations: HashSet::new(),
            skip_foreach_insns: HashMap::new(),
            stringbuilder_chains: HashMap::new(),
            last_stringbuilder_reg: None,
            pending_vararg_arrays: HashMap::new(),
            last_source_line: None,
            add_debug_lines: false,
            is_constructor: method.name == "<init>",
            lambda_methods: HashMap::new(),
            loop_patterns: dexterity_passes::LoopPatternResult::default(),
            exception_handler_block: None,
            exception_handler_blocks: HashSet::new(),
        }
    }

    /// Create a new body generation context with lambda methods for inlining
    pub fn from_method_with_lambda_methods(
        method: &MethodData,
        dex_info: Option<std::sync::Arc<dyn DexInfoProvider>>,
        inner_classes: Option<&std::collections::HashMap<String, std::sync::Arc<dexterity_ir::ClassData>>>,
        lambda_methods: Option<&HashMap<String, std::sync::Arc<dexterity_ir::MethodData>>>,
    ) -> Self {
        let mut ctx = Self::from_method_with_dex_and_inner_classes(method, dex_info, inner_classes);
        if let Some(lambdas) = lambda_methods {
            ctx.lambda_methods = lambdas.clone();
        }
        ctx
    }

    /// Register an anonymous class for inline generation
    pub fn register_anonymous_class(&mut self, type_desc: String, class_data: dexterity_ir::ClassData) {
        self.anonymous_classes.insert(type_desc, std::sync::Arc::new(class_data));
    }

    /// Get an anonymous class by type descriptor
    pub fn get_anonymous_class(&self, type_desc: &str) -> Option<&dexterity_ir::ClassData> {
        self.anonymous_classes.get(type_desc).map(|arc| arc.as_ref())
    }

    /// Get a synthetic lambda method by name for inlining
    pub fn get_lambda_method(&self, name: &str) -> Option<&dexterity_ir::MethodData> {
        self.lambda_methods.get(name).map(|arc| arc.as_ref())
    }

    /// Set loop pattern analysis results (for/foreach detection)
    pub fn set_loop_patterns(&mut self, patterns: dexterity_passes::LoopPatternResult) {
        self.loop_patterns = patterns;
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

    /// Set the current class type (internal format like "com/example/MyClass")
    /// Used to distinguish super() vs this() in constructor calls
    pub fn set_current_class_type(&mut self, class_type: String) {
        self.current_class_type = Some(class_type);
    }

    /// Get inlined expression if available, removing it from storage
    pub fn take_inline_expr(&mut self, reg: u16, version: u32) -> Option<String> {
        self.inlined_exprs.remove(&(reg, version))
    }

    /// Peek at inlined expression without removing it (for checking if it's a constant)
    pub fn peek_inline_expr(&self, reg: u16, version: u32) -> Option<&String> {
        self.inlined_exprs.get(&(reg, version))
    }

    /// Get constant integer value from an argument, checking both literals and inlined expressions
    /// Returns Some(value) if the argument is a constant integer (literal or inlined constant expression)
    pub fn get_constant_int_value(&self, arg: &InsnArg) -> Option<i64> {
        match arg {
            InsnArg::Literal(LiteralArg::Int(v)) => Some(*v),
            InsnArg::Register(reg) => {
                // Check if there's an inlined expression that's a numeric constant
                if let Some(expr) = self.peek_inline_expr(reg.reg_num, reg.ssa_version) {
                    // Try to parse as integer (handles "0", "42", "-1", etc.)
                    if let Ok(v) = expr.parse::<i64>() {
                        return Some(v);
                    }
                    // Handle Long suffix: "42L"
                    if expr.ends_with('L') || expr.ends_with('l') {
                        if let Ok(v) = expr[..expr.len()-1].parse::<i64>() {
                            return Some(v);
                        }
                    }
                }
                None
            }
            _ => None,
        }
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

    /// Generate argument expression with type-aware formatting (0 -> null for Objects)
    pub fn gen_arg_inline_typed(&mut self, arg: &InsnArg, target_type: &ArgType) -> String {
        if let InsnArg::Register(reg) = arg {
            // Check if we have an inlined expression for this register
            if let Some(expr) = self.take_inline_expr(reg.reg_num, reg.ssa_version) {
                // Check if this is a pure integer literal that needs type conversion
                if let Ok(value) = expr.trim().parse::<i64>() {
                    match target_type {
                        ArgType::Char => {
                            let c = char::from_u32(value as u32).unwrap_or('\u{FFFD}');
                            return crate::type_gen::escape_char_pub(c);
                        }
                        ArgType::Boolean => {
                            return if value == 0 { "false" } else { "true" }.to_string();
                        }
                        // Convert 0 to null for Object/Array types (JADX parity)
                        ArgType::Object(_) | ArgType::Array(_) | ArgType::UnknownObject => {
                            if value == 0 {
                                return "null".to_string();
                            }
                        }
                        _ => {}
                    }
                }
                return expr;
            }
        }
        // Fall back to type-aware generation
        crate::type_gen::literal_to_string_with_arg(arg, target_type)
            .unwrap_or_else(|| self.expr_gen.gen_arg(arg))
    }

    /// Generate argument expression with inline peek (doesn't consume the inlined expr)
    /// This is useful for conditions where we need to reference the expression
    /// without consuming it (since the actual instruction will be processed later)
    pub fn gen_arg_with_inline_peek(&self, arg: &InsnArg) -> String {
        if let InsnArg::Register(reg) = arg {
            // Check if we have an inlined expression for this register
            if let Some(expr) = self.peek_inline_expr(reg.reg_num, reg.ssa_version) {
                return expr.clone();
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

    /// Write an argument with type-aware formatting
    ///
    /// This method uses the target type to properly format literals:
    /// - For `char` type: formats `91` as `'['`
    /// - For `boolean` type: formats `0`/`1` as `false`/`true`
    /// - For other types: uses default formatting
    ///
    /// This is essential for method invocations where the parameter type
    /// differs from how the literal is stored (e.g., `append(char)` receiving an int).
    pub fn write_arg_inline_typed<W: CodeWriter>(&mut self, writer: &mut W, arg: &InsnArg, target_type: &ArgType) {
        if let InsnArg::Register(reg) = arg {
            // Check if we have an inlined expression for this register
            if let Some(expr) = self.take_inline_expr(reg.reg_num, reg.ssa_version) {
                // Check if this is a pure integer literal that needs type conversion
                // e.g., "91" should become "'['" when target type is char
                // e.g., "0" should become "null" when target type is Object
                if let Ok(value) = expr.trim().parse::<i64>() {
                    match target_type {
                        ArgType::Char => {
                            let c = char::from_u32(value as u32).unwrap_or('\u{FFFD}');
                            writer.add(&crate::type_gen::escape_char_pub(c));
                            return;
                        }
                        ArgType::Boolean => {
                            writer.add(if value == 0 { "false" } else { "true" });
                            return;
                        }
                        // Convert 0 to null for Object/Array types (JADX parity)
                        ArgType::Object(_) | ArgType::Array(_) | ArgType::UnknownObject => {
                            if value == 0 {
                                writer.add("null");
                                return;
                            }
                        }
                        _ => {}
                    }
                }
                // Not a convertible literal, use as-is
                writer.add(&expr);
                return;
            }
        }
        // Use type-aware formatting for the argument
        self.expr_gen.write_arg_with_type(writer, arg, target_type);
    }

    /// Set imports for using simple type names in variable declarations
    pub fn set_imports(&mut self, imports: Option<BTreeSet<String>>) {
        self.imports = imports;
    }

    /// Set escape unicode mode (escape non-ASCII chars as \uXXXX in strings)
    pub fn set_escape_unicode(&mut self, escape_unicode: bool) {
        self.expr_gen.set_escape_unicode(escape_unicode);
    }

    /// Get the inferred type for a register, if available
    pub fn get_inferred_type(&self, reg: u16) -> Option<&ArgType> {
        self.type_info.as_ref().and_then(|ti| ti.types.get(&(reg, 0)))
    }

    /// Get the inferred type for a register with specific SSA version
    pub fn get_inferred_type_versioned(&self, reg: u16, version: u32) -> Option<&ArgType> {
        self.type_info.as_ref().and_then(|ti| ti.types.get(&(reg, version)))
    }

    /// Check if a variable has been declared (by SSA version)
    pub fn is_declared(&self, reg: u16, version: u32) -> bool {
        self.declared_vars.contains(&(reg, version))
    }

    /// Check if a variable NAME has been declared (to prevent same-name redeclarations)
    /// Different SSA versions may share the same Java variable name
    pub fn is_name_declared(&self, name: &str) -> bool {
        self.declared_name_types.contains_key(name)
    }

    /// Get the type of a declared variable name (if it exists)
    pub fn get_declared_name_type(&self, name: &str) -> Option<&ArgType> {
        self.declared_name_types.get(name)
    }

    /// Mark a variable as declared (by SSA version and name)
    pub fn mark_declared(&mut self, reg: u16, version: u32) {
        self.declared_vars.insert((reg, version));
    }

    /// Mark a variable name as declared with its type
    pub fn mark_name_declared(&mut self, name: &str, declared_type: &ArgType) {
        self.declared_name_types.insert(name.to_string(), declared_type.clone());
    }

    /// Generate a unique name by adding numeric suffix
    /// Used when incompatible types need separate variable names
    fn generate_unique_name(&self, base_name: &str) -> String {
        let mut suffix = 2;
        loop {
            let candidate = format!("{}_{}", base_name, suffix);
            if !self.declared_name_types.contains_key(&candidate) {
                return candidate;
            }
            suffix += 1;
        }
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
    pub fn set_final_vars_from_max_versions(&mut self, max_versions: &FxHashMap<u16, u32>) {
        for (&reg, &max_version) in max_versions {
            if max_version == 1 {
                // Only version 1 exists for this register (one definition) - it's final
                self.final_vars.insert((reg, 1));
            }
        }
    }

    /// Check if currently generating code inside an exception handler
    pub fn in_exception_handler(&self) -> bool {
        self.exception_handler_block.is_some()
    }

    /// Set the current exception handler block ID
    pub fn enter_exception_handler(&mut self, block_id: u32) {
        self.exception_handler_block = Some(block_id);
    }

    /// Clear the current exception handler block ID
    pub fn exit_exception_handler(&mut self) {
        self.exception_handler_block = None;
    }

    /// Check if a block is an exception handler entry point
    pub fn is_exception_handler_block(&self, block_id: u32) -> bool {
        self.exception_handler_blocks.contains(&block_id)
    }

    /// Register a block as an exception handler entry point
    pub fn register_exception_handler_block(&mut self, block_id: u32) {
        self.exception_handler_blocks.insert(block_id);
    }
}

use dexterity_ir::instructions::RegisterArg;

/// Count variable uses across all blocks
/// Returns a map of (reg, version) -> use count
fn count_variable_uses(blocks: &BTreeMap<u32, BasicBlock>) -> HashMap<(u16, u32), usize> {
    let mut counts: HashMap<(u16, u32), usize> = HashMap::new();

    for block in blocks.values() {
        for insn in &block.instructions {
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
        InsnType::InvokeCustom { args, .. } => {
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
        // CheckCast is inlined - don't count as use since it stores cast expression for later use
        InsnType::CheckCast { .. } => {}
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
        InsnType::Ternary { left, right, then_value, else_value, .. } => {
            count_arg(left);
            if let Some(r) = right { count_arg(r); }
            count_arg(then_value);
            count_arg(else_value);
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
        | InsnType::Goto { .. } | InsnType::Break { .. } | InsnType::Continue { .. }
        // New JADX-compatible instructions
        | InsnType::JavaJsr { .. } | InsnType::JavaRet { .. } | InsnType::RegionArg { .. } => {}

        // New instructions with args
        InsnType::MoveMulti { moves } => {
            for (_, src) in moves {
                count_arg(src);
            }
        }
        InsnType::StrConcat { args, .. } => {
            for arg in args {
                count_arg(arg);
            }
        }
        InsnType::OneArg { arg } => count_arg(arg),
        InsnType::Constructor { args, .. } => {
            for arg in args {
                count_arg(arg);
            }
        }
    }
}

/// Identify exception handler blocks from try_blocks metadata
/// Returns a set of block IDs that are exception handler entry points
fn collect_exception_handler_blocks(
    ssa_result: &dexterity_passes::ssa::SsaResult,
    try_blocks: &[TryBlock],
) -> HashSet<u32> {
    let mut handler_blocks = HashSet::new();

    // Build a map from instruction offset to block ID
    let mut offset_to_block: HashMap<u32, u32> = HashMap::new();
    for block in &ssa_result.blocks {
        if let Some(first_insn) = block.instructions.first() {
            offset_to_block.insert(first_insn.offset, block.id);
        }
    }

    // Find blocks that start at exception handler addresses
    for try_block in try_blocks {
        for handler in &try_block.handlers {
            if let Some(&block_id) = offset_to_block.get(&handler.handler_addr) {
                handler_blocks.insert(block_id);
            }
        }
    }

    handler_blocks
}

/// Collect phi node destinations from SSA result
/// These variables need early declaration at method start since phi "assignments" aren't emitted
/// Exception handler blocks are skipped since their phi nodes merge exception paths
fn collect_phi_destinations(
    ssa_result: &dexterity_passes::ssa::SsaResult,
    exception_handler_blocks: &HashSet<u32>,
) -> HashSet<(u16, u32)> {
    let mut phi_dests = HashSet::new();
    for block in &ssa_result.blocks {
        // Skip phi nodes in exception handler blocks - these merge exception paths
        // and should not be declared at method start
        if exception_handler_blocks.contains(&block.id) {
            continue;
        }
        for phi in &block.phi_nodes {
            // Skip 'this' parameter (reg 0, version 0 for instance methods)
            if phi.dest.reg_num == 0 && phi.dest.ssa_version == 0 {
                continue;
            }
            phi_dests.insert((phi.dest.reg_num, phi.dest.ssa_version));
        }
    }
    phi_dests
}

/// Count variable uses from phi node sources in SSA result
/// This must be called BEFORE ssa_blocks_to_map_owned consumes the SSA result
/// because phi nodes are not included in BasicBlock instructions
fn count_phi_source_uses(ssa_result: &dexterity_passes::ssa::SsaResult) -> HashMap<(u16, u32), usize> {
    let mut counts: HashMap<(u16, u32), usize> = HashMap::new();
    for block in &ssa_result.blocks {
        for phi in &block.phi_nodes {
            for (_, source) in &phi.sources {
                *counts.entry((source.reg_num, source.ssa_version)).or_insert(0) += 1;
            }
        }
    }
    counts
}

/// Merge phi source use counts into the main use counts HashMap
fn merge_use_counts(main: &mut HashMap<(u16, u32), usize>, other: HashMap<(u16, u32), usize>) {
    for (key, count) in other {
        *main.entry(key).or_insert(0) += count;
    }
}

/// Emit declarations for phi variables at method start
/// Like Java JADX's DeclareVariablesAttr, this ensures variables used before
/// their first "real" assignment are declared
///
/// IMPORTANT: Only declares variables that are actually used (dead variable elimination)
/// This prevents "unused variable" declarations like JADX avoids.
fn emit_phi_declarations<W: CodeWriter>(ctx: &mut BodyGenContext, code: &mut W) {
    if ctx.phi_declarations.is_empty() {
        return;
    }

    // Sort for deterministic output
    let mut phi_vars: Vec<_> = ctx.phi_declarations.iter().copied().collect();
    phi_vars.sort();

    for (reg, version) in phi_vars {
        // DEAD VARIABLE ELIMINATION: Skip variables that are never used
        // This matches JADX's behavior of not declaring unused variables
        let use_count = ctx.use_counts.get(&(reg, version)).copied().unwrap_or(0);
        if use_count == 0 {
            continue;
        }

        // Get variable name using a temp RegisterArg
        let temp_reg = RegisterArg { reg_num: reg, ssa_version: version };
        let mut var_name = ctx.expr_gen.get_var_name(&temp_reg);

        // Skip if already declared (e.g., parameter)
        if ctx.is_declared(reg, version) || ctx.is_parameter(reg, version) {
            continue;
        }

        // Get the type from type inference
        let var_type = ctx.get_inferred_type_versioned(reg, version)
            .or_else(|| ctx.get_inferred_type_versioned(reg, 0))
            .cloned()
            .unwrap_or_else(|| ArgType::Object("java/lang/Object".to_string()));

        // Check if name is already declared with an incompatible type
        if let Some(existing_type) = ctx.get_declared_name_type(&var_name) {
            if !types_compatible_for_naming(existing_type, &var_type) {
                // Incompatible type - generate unique name
                var_name = ctx.generate_unique_name(&var_name);
                ctx.expr_gen.set_var_name(reg, version, var_name.clone());
            } else {
                // Compatible type - skip declaration (reuse existing)
                continue;
            }
        }

        // Emit declaration
        code.start_line();

        // Use imports-aware type formatting if available
        let type_str = if let Some(ref imports) = ctx.imports {
            type_to_string_with_imports(&var_type, Some(imports))
        } else {
            type_to_string(&var_type)
        };

        code.add(&type_str).add(" ").add(&var_name).add(";").newline();

        // Mark as declared (both by version and by name with type)
        ctx.mark_declared(reg, version);
        ctx.mark_name_declared(&var_name, &var_type);
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

    // DEAD VARIABLE ELIMINATION: Skip variables that are never used
    let use_count = ctx.use_counts.get(&(reg, version)).copied().unwrap_or(0);
    if use_count == 0 {
        return;  // Skip unused variables - dead code elimination
    }

    // Check if this variable should be inlined (used exactly once)
    if ctx.should_inline(reg, version) {
        // Store the expression for later inlining instead of emitting
        ctx.store_inline_expr(reg, version, value_str.to_string());
        return;
    }

    let mut var_name = ctx.expr_gen.get_var_name(dest);

    // Determine the type for this variable (used for declaration and compatibility check)
    // Priority: 1. Type inference, 2. Type hint, 3. Try version 0, 4. Object fallback
    let decl_type = ctx.get_inferred_type_versioned(reg, version)
        .cloned()
        .or_else(|| type_hint.cloned())
        .or_else(|| {
            if version != 0 {
                ctx.get_inferred_type_versioned(reg, 0).cloned()
            } else {
                None
            }
        })
        .unwrap_or_else(|| ArgType::Object("java/lang/Object".to_string()));

    // Check if we need to declare this variable
    // In SSA form, only version 0 of parameter registers are actual parameters
    let needs_decl = if ctx.is_declared(reg, version) || ctx.is_parameter(reg, version) {
        false
    } else if let Some(existing_type) = ctx.get_declared_name_type(&var_name) {
        // Name exists - check type compatibility
        if !types_compatible_for_naming(existing_type, &decl_type) {
            // Incompatible type - generate unique name
            var_name = ctx.generate_unique_name(&var_name);
            ctx.expr_gen.set_var_name(reg, version, var_name.clone());
            true  // Needs declaration with new name
        } else {
            false  // Compatible, reuse existing
        }
    } else {
        true  // Name not declared yet
    };

    code.start_line();

    if needs_decl {
        // Emit 'final' keyword if this variable is only assigned once
        if ctx.is_final(reg, version) {
            code.add("final ");
        }

        // Use simple names when imports are available
        let type_str = type_to_string_with_imports(&decl_type, ctx.imports.as_ref());
        code.add(&type_str).add(" ");

        ctx.mark_declared(reg, version);
        ctx.mark_name_declared(&var_name, &decl_type);
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

    // DEAD VARIABLE ELIMINATION: Skip variables that are never used
    let use_count = ctx.use_counts.get(&(reg, version)).copied().unwrap_or(0);
    if use_count == 0 {
        return false;  // Skip unused variables - dead code elimination
    }

    // Check if this variable should be inlined (used exactly once)
    // This is the rare case where we need the String for deferred emission
    if ctx.should_inline(reg, version) {
        // For increment/decrement patterns, generate the compact form for inlining too
        if let Some(incr_expr) = detect_increment_decrement(dest, insn, ctx) {
            ctx.store_inline_expr(reg, version, incr_expr);
            return true;
        }
        if let Some(expr_str) = ctx.expr_gen.gen_insn(insn) {
            ctx.store_inline_expr(reg, version, expr_str);
            return true;
        }
        return false;
    }

    // Check for increment/decrement pattern: i = i + 1 -> i++ or i = i - 1 -> i--
    // This must be checked before the variable is declared as new
    if let Some(incr_decr) = detect_increment_decrement(dest, insn, ctx) {
        code.start_line().add(&incr_decr).add(";").newline();
        return true;
    }

    let mut var_name = ctx.expr_gen.get_var_name(dest);

    // Determine the type for this variable (used for declaration and compatibility check)
    // Priority: 1. Type inference, 2. Type hint, 3. Try version 0, 4. Object fallback
    let decl_type = ctx.get_inferred_type_versioned(reg, version)
        .cloned()
        .or_else(|| type_hint.cloned())
        .or_else(|| {
            if version != 0 {
                ctx.get_inferred_type_versioned(reg, 0).cloned()
            } else {
                None
            }
        })
        .unwrap_or_else(|| ArgType::Object("java/lang/Object".to_string()));

    // Check if we need to declare this variable
    let needs_decl = if ctx.is_declared(reg, version) || ctx.is_parameter(reg, version) {
        false
    } else if let Some(existing_type) = ctx.get_declared_name_type(&var_name) {
        // Name exists - check type compatibility
        if !types_compatible_for_naming(existing_type, &decl_type) {
            // Incompatible type - generate unique name
            var_name = ctx.generate_unique_name(&var_name);
            ctx.expr_gen.set_var_name(reg, version, var_name.clone());
            true  // Needs declaration with new name
        } else {
            false  // Compatible, reuse existing
        }
    } else {
        true  // Name not declared yet
    };

    code.start_line();

    if needs_decl {
        if ctx.is_final(reg, version) {
            code.add("final ");
        }

        let type_str = type_to_string_with_imports(&decl_type, ctx.imports.as_ref());
        code.add(&type_str).add(" ");

        ctx.mark_declared(reg, version);
        ctx.mark_name_declared(&var_name, &decl_type);
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

/// Detect increment/decrement and compound assignment patterns
/// Patterns detected:
/// - `dest = var + 1` where var is the same variable (previous SSA version) -> `var++`
/// - `dest = var - 1` where var is the same variable (previous SSA version) -> `var--`
/// - `dest = 1 + var` where var is the same variable -> `var++`
/// - `dest = var + N` for other N -> `var += N`
/// - `dest = var - N` for other N -> `var -= N`
/// - `dest = var * N` -> `var *= N`
/// - `dest = var / N` -> `var /= N`
/// - `dest = var % N` -> `var %= N`
/// - `dest = var & N` -> `var &= N`
/// - `dest = var | N` -> `var |= N`
/// - `dest = var ^ N` -> `var ^= N`
/// - `dest = var << N` -> `var <<= N`
/// - `dest = var >> N` -> `var >>= N`
/// - `dest = var >>> N` -> `var >>>= N`
fn detect_increment_decrement(
    dest: &RegisterArg,
    insn: &InsnType,
    ctx: &BodyGenContext,
) -> Option<String> {
    use dexterity_ir::instructions::BinaryOp;

    if let InsnType::Binary { op, left, right, .. } = insn {
        // Get the left operand - must be a register
        let left_reg = match left {
            InsnArg::Register(r) => r,
            _ => return None,
        };

        // Check if left operand is the same variable as destination (same reg, different SSA version)
        // This handles the common case: i_v2 = i_v1 + 1
        if left_reg.reg_num != dest.reg_num {
            // Check for commutative case: N + var or N * var (only for Add and Mul)
            if matches!(op, BinaryOp::Add | BinaryOp::Mul) {
                if let InsnArg::Register(right_reg) = right {
                    if right_reg.reg_num == dest.reg_num {
                        let var_name = ctx.expr_gen.get_var_name(right_reg);
                        let right_str = ctx.expr_gen.gen_arg(left);

                        // For Add with literal 1/-1, use ++ or --
                        if *op == BinaryOp::Add {
                            if let InsnArg::Literal(LiteralArg::Int(val)) = left {
                                if *val == 1 {
                                    return Some(format!("{}++", var_name));
                                } else if *val == -1 {
                                    return Some(format!("{}--", var_name));
                                }
                            }
                        }

                        let op_str = match op {
                            BinaryOp::Add => "+=",
                            BinaryOp::Mul => "*=",
                            _ => return None,
                        };
                        return Some(format!("{} {} {}", var_name, op_str, right_str));
                    }
                }
            }
            return None;
        }

        // Get the variable name from the left operand
        let var_name = ctx.expr_gen.get_var_name(left_reg);

        // Generate right operand expression
        let right_str = ctx.expr_gen.gen_arg(right);

        // For Add and Sub with literal 1/-1, use ++ or --
        if let InsnArg::Literal(LiteralArg::Int(val)) = right {
            match op {
                BinaryOp::Add => {
                    if *val == 1 {
                        return Some(format!("{}++", var_name));
                    } else if *val == -1 {
                        return Some(format!("{}--", var_name));
                    } else if *val == 0 {
                        return None; // += 0 is a no-op, keep original
                    }
                }
                BinaryOp::Sub => {
                    if *val == 1 {
                        return Some(format!("{}--", var_name));
                    } else if *val == -1 {
                        return Some(format!("{}++", var_name));
                    } else if *val == 0 {
                        return None; // -= 0 is a no-op, keep original
                    }
                }
                _ => {}
            }
        }

        // Map binary operator to compound assignment operator
        let op_str = match op {
            BinaryOp::Add => "+=",
            BinaryOp::Sub => "-=",
            BinaryOp::Mul => "*=",
            BinaryOp::Div => "/=",
            BinaryOp::Rem => "%=",
            BinaryOp::And => "&=",
            BinaryOp::Or => "|=",
            BinaryOp::Xor => "^=",
            BinaryOp::Shl => "<<=",
            BinaryOp::Shr => ">>=",
            BinaryOp::Ushr => ">>>=",
            BinaryOp::Rsub => return None, // rsub is not commutative, can't make compound
        };

        Some(format!("{} {} {}", var_name, op_str, right_str))
    } else {
        None
    }
}

/// Detect field increment/compound assignment patterns for InstancePut/StaticPut
/// Patterns detected:
/// - `obj.field = obj.field + 1` -> `obj.field++`
/// - `obj.field = obj.field - 1` -> `obj.field--`
/// - `obj.field = obj.field + N` -> `obj.field += N`
/// - `obj.field = obj.field - N` -> `obj.field -= N`
/// - etc. for all compound assignment operators
///
/// Returns Some((field_expr, op_str)) if pattern detected, e.g., ("obj.field", "++")
fn detect_field_increment(
    field_idx: u32,
    object: Option<&InsnArg>, // None for static fields
    value: &InsnArg,
    ctx: &BodyGenContext,
) -> Option<String> {
    use dexterity_ir::instructions::BinaryOp;

    // Value must be a register
    let value_reg = match value {
        InsnArg::Register(r) => r,
        _ => return None,
    };

    // Find the instruction that defines this register
    let defining_insn = find_defining_instruction(value_reg, ctx)?;

    // Must be a Binary operation
    let (op, left, right) = match &defining_insn.insn_type {
        InsnType::Binary { op, left, right, .. } => (op, left, right),
        _ => return None,
    };

    // Check if left operand is a field get of the same field
    let field_matches = match (object, left) {
        // Instance field: check both object and field_idx match
        (Some(put_obj), InsnArg::Register(get_reg)) => {
            // The left register should be defined by an InstanceGet of the same field
            if let Some(get_insn) = find_defining_instruction(get_reg, ctx) {
                if let InsnType::InstanceGet { object: get_obj, field_idx: get_field_idx, .. } = &get_insn.insn_type {
                    *get_field_idx == field_idx && args_match(put_obj, get_obj)
                } else {
                    false
                }
            } else {
                false
            }
        }
        // Static field: just check field_idx matches
        (None, InsnArg::Register(get_reg)) => {
            if let Some(get_insn) = find_defining_instruction(get_reg, ctx) {
                if let InsnType::StaticGet { field_idx: get_field_idx, .. } = &get_insn.insn_type {
                    *get_field_idx == field_idx
                } else {
                    false
                }
            } else {
                false
            }
        }
        _ => false,
    };

    if !field_matches {
        return None;
    }

    // Build the field expression
    let field_expr = if let Some(obj) = object {
        let obj_str = ctx.expr_gen.gen_arg(obj);
        let field_info = ctx.expr_gen.get_field_value(field_idx);
        let field_name = field_info.as_ref()
            .map(|f| f.field_name.to_string())
            .unwrap_or_else(|| format!("field#{}", field_idx));
        format!("{}.{}", obj_str, field_name)
    } else {
        let field_info = ctx.expr_gen.get_field_value(field_idx);
        field_info.as_ref()
            .map(|f| format!("{}.{}", f.class_name, f.field_name))
            .unwrap_or_else(|| format!("field#{}", field_idx))
    };

    // Generate the compound operation
    let right_str = ctx.expr_gen.gen_arg(right);

    // For Add and Sub with literal 1/-1, use ++ or --
    if let InsnArg::Literal(LiteralArg::Int(val)) = right {
        match op {
            BinaryOp::Add => {
                if *val == 1 {
                    return Some(format!("{}++", field_expr));
                } else if *val == -1 {
                    return Some(format!("{}--", field_expr));
                }
            }
            BinaryOp::Sub => {
                if *val == 1 {
                    return Some(format!("{}--", field_expr));
                } else if *val == -1 {
                    return Some(format!("{}++", field_expr));
                }
            }
            _ => {}
        }
    }

    // Map binary operator to compound assignment operator
    let op_str = match op {
        BinaryOp::Add => "+=",
        BinaryOp::Sub => "-=",
        BinaryOp::Mul => "*=",
        BinaryOp::Div => "/=",
        BinaryOp::Rem => "%=",
        BinaryOp::And => "&=",
        BinaryOp::Or => "|=",
        BinaryOp::Xor => "^=",
        BinaryOp::Shl => "<<=",
        BinaryOp::Shr => ">>=",
        BinaryOp::Ushr => ">>>=",
        BinaryOp::Rsub => return None,
    };

    Some(format!("{} {} {}", field_expr, op_str, right_str))
}

/// Find the instruction that defines a register (by reg_num and ssa_version)
fn find_defining_instruction(reg: &RegisterArg, ctx: &BodyGenContext) -> Option<InsnNode> {
    for block in ctx.blocks.values() {
        for insn in &block.instructions {
            // Check if this instruction defines the register we're looking for
            let defines_reg = match &insn.insn_type {
                InsnType::Binary { dest, .. }
                | InsnType::Unary { dest, .. }
                | InsnType::InstanceGet { dest, .. }
                | InsnType::StaticGet { dest, .. }
                | InsnType::ArrayGet { dest, .. }
                | InsnType::Const { dest, .. }
                | InsnType::ConstString { dest, .. }
                | InsnType::ConstClass { dest, .. }
                | InsnType::NewInstance { dest, .. }
                | InsnType::NewArray { dest, .. }
                | InsnType::ArrayLength { dest, .. }
                | InsnType::InstanceOf { dest, .. }
                | InsnType::Move { dest, .. }
                | InsnType::MoveResult { dest }
                | InsnType::MoveException { dest } => {
                    dest.reg_num == reg.reg_num && dest.ssa_version == reg.ssa_version
                }
                InsnType::FilledNewArray { dest: Some(d), .. } => {
                    d.reg_num == reg.reg_num && d.ssa_version == reg.ssa_version
                }
                _ => false,
            };

            if defines_reg {
                return Some(insn.clone());
            }
        }
    }
    None
}

/// Check if two InsnArg values refer to the same thing
fn args_match(a: &InsnArg, b: &InsnArg) -> bool {
    match (a, b) {
        (InsnArg::Register(ra), InsnArg::Register(rb)) => {
            // Same register (ignore SSA version - field access may be on different versions of same object)
            ra.reg_num == rb.reg_num
        }
        (InsnArg::This { .. }, InsnArg::This { .. }) => true,
        (InsnArg::Literal(LiteralArg::Int(a)), InsnArg::Literal(LiteralArg::Int(b))) => a == b,
        (InsnArg::Literal(LiteralArg::Null), InsnArg::Literal(LiteralArg::Null)) => true,
        _ => false,
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

    let block_result = split_blocks(insns);

    if block_result.blocks.is_empty() {
        code.start_line()
            .add("/* no blocks */")
            .newline();
        add_default_return(&method.return_type, code);
        return;
    }

    let mut cfg = CFG::from_blocks(block_result);

    mark_duplicated_finally(&mut cfg, &method.try_blocks);

    let region = build_regions_with_try_catch(&cfg, &method.try_blocks);

    let block_result = cfg.into_blocks();

    let ssa_result = transform_to_ssa_owned(block_result);

    let type_result = infer_types(&ssa_result);

    // Use sophisticated variable naming from dexterity-passes (JADX-compatible)
    let first_param_reg = method.regs_count.saturating_sub(method.ins_count);
    let num_params = method.arg_types.len() as u16;
    let var_names = dexterity_passes::assign_var_names(&ssa_result, &type_result, first_param_reg, num_params);

    let mut ctx = BodyGenContext::from_method(method);
    let max_versions = ssa_result.max_versions.clone();
    // Identify exception handler blocks to skip in phi declaration
    let exception_handler_blocks = collect_exception_handler_blocks(&ssa_result, &method.try_blocks);
    // Collect phi destinations AND phi source uses before consuming SSA result
    ctx.phi_declarations = collect_phi_destinations(&ssa_result, &exception_handler_blocks);
    let phi_uses = count_phi_source_uses(&ssa_result);
    ctx.blocks = ssa_blocks_to_map_owned(ssa_result);
    ctx.type_info = Some(type_result);

    // Count variable uses from both instructions and phi sources
    ctx.use_counts = count_variable_uses(&ctx.blocks);
    merge_use_counts(&mut ctx.use_counts, phi_uses);

    ctx.set_final_vars_from_max_versions(&max_versions);

    apply_inferred_types(&mut ctx);
    apply_var_names_from_pass(&var_names, &mut ctx);

    // Emit declarations for phi variables at method start
    emit_phi_declarations(&mut ctx, code);

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
    use std::panic::{catch_unwind, AssertUnwindSafe};

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

    // Wrap decompilation pipeline in panic catch to handle SKIP limits
    let decompile_result = catch_unwind(AssertUnwindSafe(|| {
        generate_body_impl(method, insns, dex_info.clone(), imports, code);
    }));

    // Handle panic - generate warning comment and stub
    if let Err(panic_payload) = decompile_result {
        let msg = if let Some(s) = panic_payload.downcast_ref::<&str>() {
            s.to_string()
        } else if let Some(s) = panic_payload.downcast_ref::<String>() {
            s.clone()
        } else {
            "Method decompilation failed".to_string()
        };

        // Strip "SKIP:" prefix if present
        let warning_msg = msg.trim_start_matches("SKIP:").trim();

        code.start_line()
            .add("/* JADX WARN: ")
            .add(warning_msg)
            .add(" */")
            .newline();
        code.start_line()
            .add("throw new UnsupportedOperationException(\"Method not decompiled\");")
            .newline();
    }
}

/// Internal implementation of body generation (can panic)
fn generate_body_impl<W: CodeWriter>(
    method: &MethodData,
    insns: &[InsnNode],
    dex_info: Option<std::sync::Arc<dyn DexInfoProvider>>,
    imports: Option<&BTreeSet<String>>,
    code: &mut W,
) {
    let block_result = split_blocks(insns);

    if block_result.blocks.is_empty() {
        code.start_line()
            .add("/* no blocks */")
            .newline();
        add_default_return(&method.return_type, code);
        return;
    }

    let mut cfg = CFG::from_blocks(block_result);

    mark_duplicated_finally(&mut cfg, &method.try_blocks);

    let region = build_regions_with_try_catch(&cfg, &method.try_blocks);

    let block_result = cfg.into_blocks();

    let ssa_result = transform_to_ssa_owned(block_result);

    let type_result = if let Some(ref dex) = dex_info {
        let dex_clone = dex.clone();
        let dex_clone2 = dex.clone();
        let dex_clone3 = dex.clone();

        // Direct parsing without caching - avoids DashMap overhead
        dexterity_passes::infer_types_with_context(
            &ssa_result,
            move |idx| dex_clone.get_type_as_argtype(idx),
            move |idx| dex_clone2.get_field_type(idx),
            move |idx| dex_clone3.get_method_return_type(idx),
        )
    } else {
        infer_types(&ssa_result)
    };

    // Use sophisticated variable naming from dexterity-passes (JADX-compatible)
    let first_param_reg = method.regs_count.saturating_sub(method.ins_count);
    let num_params = method.arg_types.len() as u16;

    // Create lookup closures for better variable naming when dex_info is available
    let var_names = if let Some(ref dex) = dex_info {
        let dex_for_method = dex.clone();
        let dex_for_type = dex.clone();
        let dex_for_field = dex.clone();

        let method_lookup = move |idx: u32| {
            dex_for_method.get_method(idx).map(|m| dexterity_passes::MethodNameInfo {
                method_name: m.method_name.to_string(),
                class_name: m.class_name.to_string(),
            })
        };

        let type_lookup = move |idx: u32| {
            dex_for_type.get_type_name(idx)
        };

        let field_lookup = move |idx: u32| {
            dex_for_field.get_field(idx).map(|f| dexterity_passes::FieldNameInfo {
                field_name: f.field_name.to_string(),
                class_name: f.class_name.to_string(),
            })
        };

        // Build actual parameter names to reserve in var_naming
        let param_names: Vec<String> = method.arg_types.iter().enumerate().map(|(i, param_type)| {
            method.arg_names.get(i)
                .and_then(|n| n.clone())
                .unwrap_or_else(|| generate_param_name(i, param_type))
        }).collect();

        dexterity_passes::assign_var_names_with_lookups(
            &ssa_result,
            &type_result,
            first_param_reg,
            num_params,
            Some(&param_names),
            Some(&method_lookup),
            Some(&type_lookup),
            Some(&field_lookup),
            method.debug_info.as_ref(),
            None, // No inner class names in this context (use generate_body_with_inner_classes for full support)
        )
    } else {
        dexterity_passes::assign_var_names(&ssa_result, &type_result, first_param_reg, num_params)
    };

    let mut ctx = BodyGenContext::from_method_with_dex(method, dex_info.clone());
    let max_versions = ssa_result.max_versions.clone();
    // Identify exception handler blocks to skip in phi declaration
    let exception_handler_blocks = collect_exception_handler_blocks(&ssa_result, &method.try_blocks);
    // Collect phi destinations AND phi source uses before consuming SSA result
    ctx.phi_declarations = collect_phi_destinations(&ssa_result, &exception_handler_blocks);
    let phi_uses = count_phi_source_uses(&ssa_result);
    ctx.blocks = ssa_blocks_to_map_owned(ssa_result);
    ctx.type_info = Some(type_result);
    ctx.imports = imports.cloned();

    // Count variable uses from both instructions and phi sources
    ctx.use_counts = count_variable_uses(&ctx.blocks);
    merge_use_counts(&mut ctx.use_counts, phi_uses);

    ctx.set_final_vars_from_max_versions(&max_versions);

    apply_inferred_types(&mut ctx);
    apply_var_names_from_pass(&var_names, &mut ctx);

    // Emit declarations for phi variables at method start
    emit_phi_declarations(&mut ctx, code);

    // Generate code from region tree
    generate_region(&region, &mut ctx, code);
}

thread_local! {
    static CODEGEN_DEPTH: std::cell::RefCell<usize> = std::cell::RefCell::new(0);
}

/// Generate method body from instructions with inner classes for anonymous class inlining
///
/// When `inner_classes` is provided, anonymous inner class instantiations will have
/// their method bodies inlined instead of just `new AnonymousClass()`.
///
/// The `current_class_type` parameter is used to distinguish `super()` vs `this()` in constructors.
///
/// When `lambda_methods` is provided, synthetic lambda methods can be inlined into lambda expressions.
pub fn generate_body_with_inner_classes<W: CodeWriter>(
    method: &MethodData,
    dex_info: Option<std::sync::Arc<dyn DexInfoProvider>>,
    imports: Option<&BTreeSet<String>>,
    inner_classes: Option<&HashMap<String, std::sync::Arc<dexterity_ir::ClassData>>>,
    hierarchy: Option<&dexterity_ir::ClassHierarchy>,
    current_class_type: Option<&str>,
    deobf_min_length: usize,
    deobf_max_length: usize,
    fallback: bool,
    res_names: &HashMap<u32, String>,
    replace_consts: bool,
    add_debug_lines: bool,
    code: &mut W,
) {
    generate_body_with_inner_classes_and_lambdas(
        method, dex_info, imports, inner_classes, None, hierarchy,
        current_class_type, deobf_min_length, deobf_max_length, fallback, res_names, replace_consts, add_debug_lines, code
    );
}

/// Generate method body with full context including lambda methods for inlining
pub fn generate_body_with_inner_classes_and_lambdas<W: CodeWriter>(
    method: &MethodData,
    dex_info: Option<std::sync::Arc<dyn DexInfoProvider>>,
    imports: Option<&BTreeSet<String>>,
    inner_classes: Option<&HashMap<String, std::sync::Arc<dexterity_ir::ClassData>>>,
    lambda_methods: Option<&HashMap<String, std::sync::Arc<dexterity_ir::MethodData>>>,
    hierarchy: Option<&dexterity_ir::ClassHierarchy>,
    current_class_type: Option<&str>,
    deobf_min_length: usize,
    deobf_max_length: usize,
    fallback: bool,
    res_names: &HashMap<u32, String>,
    replace_consts: bool,
    add_debug_lines: bool,
    code: &mut W,
) {
    use std::panic::{catch_unwind, AssertUnwindSafe};

    if fallback {
        if let Some(insns) = method.instructions() {
             crate::fallback_gen::generate_fallback_body(insns, code);
             return;
        } else {
             code.start_line().add("/* fallback: no instructions loaded */").newline();
             return;
        }
    }

    // Clone lambda_methods for the closure
    let lambda_methods_clone = lambda_methods.cloned();

    let result = catch_unwind(AssertUnwindSafe(|| {
        generate_body_with_inner_classes_impl(
            method,
            dex_info.clone(),
            imports,
            inner_classes,
            lambda_methods_clone.as_ref(),
            hierarchy,
            current_class_type,
            deobf_min_length,
            deobf_max_length,
            res_names,
            replace_consts,
            add_debug_lines,
            code
        )
    }));

    if let Err(_payload) = result {
         code.start_line().add("/* JADX WARNING: Method generation error */").newline();
         if let Some(insns) = method.instructions() {
             crate::fallback_gen::generate_fallback_body(insns, code);
         }
    }
}

fn generate_body_with_inner_classes_impl<W: CodeWriter>(
    method: &MethodData,
    dex_info: Option<std::sync::Arc<dyn DexInfoProvider>>,
    imports: Option<&BTreeSet<String>>,
    inner_classes: Option<&HashMap<String, std::sync::Arc<dexterity_ir::ClassData>>>,
    lambda_methods: Option<&HashMap<String, std::sync::Arc<dexterity_ir::MethodData>>>,
    hierarchy: Option<&dexterity_ir::ClassHierarchy>,
    current_class_type: Option<&str>,
    deobf_min_length: usize,
    deobf_max_length: usize,
    res_names: &HashMap<u32, String>,
    replace_consts: bool,
    add_debug_lines: bool,
    code: &mut W,
) {
    CODEGEN_DEPTH.with(|depth| {
        let mut d = depth.borrow_mut();
        *d += 1;
        if *d > 50 { // Limit recursion depth
             // Don't panic, just stop inlining? No, panic unwinds to catch_unwind in main (if added)
             // JADX throws exception.
             error!(
                 depth = *d,
                 limit = 50,
                 method = %method.name,
                 "LIMIT_EXCEEDED: Codegen recursion limit reached"
             );
             *d -= 1;
             panic!("Codegen recursion limit reached (50) in {}", method.name);
        }
    });

    struct DepthGuard;
    impl Drop for DepthGuard {
        fn drop(&mut self) {
            CODEGEN_DEPTH.with(|depth| {
                let mut d = depth.borrow_mut();
                if *d > 0 { *d -= 1; }
            });
        }
    }
    let _guard = DepthGuard;

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

    let block_result = split_blocks(insns);

    if block_result.blocks.is_empty() {
        code.start_line()
            .add("/* no blocks */")
            .newline();
        add_default_return(&method.return_type, code);
        return;
    }

    let mut cfg = CFG::from_blocks(block_result);

    // Note: JADX uses dynamic iteration limits (5x block count), not hard block limits.
    // The region_builder handles this with iteration_budget tracking.
    // Panics are caught by catch_unwind at line ~915 and converted to stub methods.

    mark_duplicated_finally(&mut cfg, &method.try_blocks);

    let region = build_regions_with_try_catch(&cfg, &method.try_blocks);
    
    let block_result = cfg.into_blocks();

    let ssa_result = transform_to_ssa_owned(block_result);

    // Use the most complete type inference variant available:
    // - With both hierarchy and dex_info: best precision (lookups + LCA computation)
    // - With hierarchy only: LCA for phi nodes but no field/method type lookups
    // - With dex_info only: field/method/type lookups but no LCA
    // - Neither: basic constraint-based inference only
    let type_result = match (hierarchy, &dex_info) {
        (Some(h), Some(dex)) => {
            // Best precision: both hierarchy (for LCA) and DEX lookups
            let dex_clone = dex.clone();
            let dex_clone2 = dex.clone();
            let dex_clone3 = dex.clone();
            dexterity_passes::infer_types_with_context_and_hierarchy(
                &ssa_result,
                move |idx| dex_clone.get_type_as_argtype(idx),
                move |idx| dex_clone2.get_field_type(idx),
                move |idx| dex_clone3.get_method_return_type(idx),
                h,
            )
        }
        (Some(h), None) => {
            // Hierarchy only (for LCA computation)
            dexterity_passes::infer_types_with_hierarchy(&ssa_result, h)
        }
        (None, Some(dex)) => {
            // DEX lookups only
            let dex_clone = dex.clone();
            let dex_clone2 = dex.clone();
            let dex_clone3 = dex.clone();
            dexterity_passes::infer_types_with_context(
                &ssa_result,
                move |idx| dex_clone.get_type_as_argtype(idx),
                move |idx| dex_clone2.get_field_type(idx),
                move |idx| dex_clone3.get_method_return_type(idx),
            )
        }
        (None, None) => {
            // Basic inference only
            infer_types(&ssa_result)
        }
    };

    // Use sophisticated variable naming from dexterity-passes (JADX-compatible)
    let first_param_reg = method.regs_count.saturating_sub(method.ins_count);
    let num_params = method.arg_types.len() as u16;

    // Create lookup closures for better variable naming when dex_info is available
    let var_names = if let Some(ref dex) = dex_info {
        let dex_for_method = dex.clone();
        let dex_for_type = dex.clone();
        let dex_for_field = dex.clone();

        // Arc<MethodInfo> - we only clone the fields we need, not the whole struct
        let method_lookup = move |idx: u32| {
            dex_for_method.get_method(idx).map(|m| dexterity_passes::MethodNameInfo {
                method_name: m.method_name.to_string(),
                class_name: m.class_name.to_string(),
            })
        };

        let type_lookup = move |idx: u32| {
            dex_for_type.get_type_name(idx)
        };

        let field_lookup = move |idx: u32| {
            dex_for_field.get_field(idx).map(|f| dexterity_passes::FieldNameInfo {
                field_name: f.field_name.to_string(),
                class_name: f.class_name.to_string(),
            })
        };

        // Build actual parameter names to reserve in var_naming
        let param_names: Vec<String> = method.arg_types.iter().enumerate().map(|(i, param_type)| {
            method.arg_names.get(i)
                .and_then(|n| n.clone())
                .unwrap_or_else(|| generate_param_name(i, param_type))
        }).collect();

        // Extract inner class short names to reserve (prevents variable-class collisions)
        // This matches JADX's NameGen.addNamesUsedInClass() behavior
        let inner_class_short_names: Vec<String> = inner_classes
            .map(|ic| ic.keys()
                .filter(|k| k.contains('$'))  // Only actual inner classes
                .map(|k| get_inner_class_simple_name(k))
                .filter(|name| !name.chars().all(|c| c.is_ascii_digit()))  // Skip anonymous (1, 2, etc.)
                .collect())
            .unwrap_or_default();

        dexterity_passes::assign_var_names_with_lookups(
            &ssa_result,
            &type_result,
            first_param_reg,
            num_params,
            Some(&param_names),
            Some(&method_lookup),
            Some(&type_lookup),
            Some(&field_lookup),
            method.debug_info.as_ref(),
            if inner_class_short_names.is_empty() { None } else { Some(&inner_class_short_names) },
        )
    } else {
        dexterity_passes::assign_var_names(&ssa_result, &type_result, first_param_reg, num_params)
    };

    let mut ctx = BodyGenContext::from_method_with_lambda_methods(method, dex_info.clone(), inner_classes, lambda_methods);
    ctx.expr_gen.set_deobf_limits(deobf_min_length, deobf_max_length);
    ctx.expr_gen.set_resources(res_names.clone(), replace_consts);
    let max_versions = ssa_result.max_versions.clone();
    // Identify exception handler blocks to skip in phi declaration
    let exception_handler_blocks = collect_exception_handler_blocks(&ssa_result, &method.try_blocks);
    // Collect phi destinations AND phi source uses before consuming SSA result
    ctx.phi_declarations = collect_phi_destinations(&ssa_result, &exception_handler_blocks);
    let phi_uses = count_phi_source_uses(&ssa_result);
    ctx.blocks = ssa_blocks_to_map_owned(ssa_result);
    ctx.type_info = Some(type_result);
    ctx.imports = imports.cloned();

    // Set current class type for super() vs this() detection in constructors
    if let Some(class_type) = current_class_type {
        ctx.set_current_class_type(class_type.to_string());
    }

    // Count variable uses from both instructions and phi sources
    ctx.use_counts = count_variable_uses(&ctx.blocks);
    merge_use_counts(&mut ctx.use_counts, phi_uses);

    ctx.set_final_vars_from_max_versions(&max_versions);

    apply_inferred_types(&mut ctx);
    apply_var_names_from_pass(&var_names, &mut ctx);

    // Emit declarations for phi variables at method start
    emit_phi_declarations(&mut ctx, code);

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

/// Apply variable names from dexterity-passes var_naming result (JADX-compatible)
fn apply_var_names_from_pass(var_names: &dexterity_passes::VarNamingResult, ctx: &mut BodyGenContext) {
    for ((reg, version), name) in &var_names.names {
        ctx.expr_gen.set_var_name(*reg, *version, name.clone());
    }
}

/// Convert a type to a variable name prefix (used in tests)
#[cfg(test)]
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
            let simple = simple.rsplit('$').next().unwrap_or(simple);
            let simple = simple.rsplit('.').next().unwrap_or(simple);

            if simple.chars().all(|c| !c.is_ascii_lowercase()) && !simple.is_empty() {
                simple.to_lowercase()
            } else {
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
        ArgType::UnknownNarrow => "n".to_string(),
        ArgType::UnknownWide => "w".to_string(),
        ArgType::UnknownObject => "obj".to_string(),
        ArgType::UnknownArray => "arr".to_string(),
        ArgType::UnknownIntegral => "i".to_string(),
        ArgType::Generic { base, .. } => {
            let simple = base.rsplit('/').next().unwrap_or(base);
            let simple = simple.trim_start_matches('L').trim_end_matches(';');
            let simple = simple.rsplit('$').next().unwrap_or(simple);
            let simple = simple.rsplit('.').next().unwrap_or(simple);

            if simple.chars().all(|c| !c.is_ascii_lowercase()) && !simple.is_empty() {
                simple.to_lowercase()
            } else {
                let mut chars = simple.chars();
                match chars.next() {
                    Some(c) => c.to_lowercase().chain(chars).collect(),
                    None => "obj".to_string(),
                }
            }
        }
        ArgType::Wildcard { .. } => "w".to_string(),
        ArgType::TypeVariable(name) => name.to_lowercase(),
    }
}

/// Detect if a condition block contains a hasNext() call (iterator pattern)
/// Returns Some((iterator_reg, hasNext_call_str)) if detected
fn detect_iterator_pattern(condition: &Condition, ctx: &BodyGenContext) -> Option<(u16, String)> {
    if let Condition::Simple { block, .. } = condition {
        if let Some(basic_block) = ctx.blocks.get(block) {
            // Look for an Invoke instruction calling hasNext()
            for insn in basic_block.instructions.iter() {
                // Check both Interface and Virtual invokes (ArrayList uses virtual, interface uses interface)
                if let InsnType::Invoke { kind, method_idx, args, .. } = &insn.insn_type {
                    if matches!(kind, InvokeKind::Interface | InvokeKind::Virtual) {
                        if let Some(method_info) = ctx.expr_gen.get_method_value(*method_idx) {
                            if &*method_info.method_name == "hasNext" && args.len() == 1 {
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

/// ForEach loop detection result (iterator pattern)
struct ForEachInfo {
    /// The item variable name
    item_var: String,
    /// The item type (from cast or inferred)
    item_type: Option<String>,
    /// Block containing next() call
    skip_block: u32,
    /// Index of first instruction to skip (next() call)
    skip_start: usize,
    /// Number of instructions to skip (next, MoveResult, optionally CheckCast)
    skip_count: usize,
}

/// Array for-each loop detection result
/// Detects pattern: for (int i = 0; i < array.length; i++) { item = array[i]; }
/// Converts to: for (Type item : array) { }
struct ArrayForEachInfo {
    /// The array expression string
    array_expr: String,
    /// The item variable name (extracted from AGET result)
    item_var: String,
    /// The item type (element type of array)
    item_type: String,
    /// Index register number (to track i++ and array[i])
    #[allow(dead_code)]
    index_reg: u16,
    /// Block containing AGET instruction
    aget_block: u32,
    /// Index of AGET instruction in the block
    aget_insn_idx: usize,
    /// Block containing increment (i++) instruction
    incr_block: u32,
    /// Index of increment instruction in the block
    incr_insn_idx: usize,
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
    for (i, insn) in block.instructions.iter().enumerate() {
        // Check both Interface and Virtual invokes
        if let InsnType::Invoke { kind, method_idx, args, .. } = &insn.insn_type {
            if matches!(kind, InvokeKind::Interface | InvokeKind::Virtual) {
                if let Some(method_info) = ctx.expr_gen.get_method_value(*method_idx) {
                    if &*method_info.method_name == "next" && args.len() == 1 {
                        if let InsnArg::Register(reg) = &args[0] {
                            if reg.reg_num == iterator_reg {
                                // Found next() call on the same iterator
                                // Look for MoveResult to get item variable name
                                let mut item_var = "item".to_string();
                                let mut item_type: Option<String> = None;

                                // Check next instruction for MoveResult
                                if i + 1 < block.instructions.len() {
                                    let next_insn = &block.instructions[i + 1];
                                    if let InsnType::MoveResult { dest } = &next_insn.insn_type {
                                        item_var = ctx.expr_gen.get_var_name(dest);

                                        // Check for CheckCast following MoveResult to get item type
                                        let mut has_cast = false;
                                        if i + 2 < block.instructions.len() {
                                            let cast_insn = &block.instructions[i + 2];
                                            if let InsnType::CheckCast { type_idx, .. } = &cast_insn.insn_type {
                                                if let Some(type_name) = ctx.expr_gen.get_type_value(*type_idx) {
                                                    let simple = type_name.rsplit('/').next().unwrap_or(&type_name);
                                                    item_type = Some(simple.to_string());
                                                    has_cast = true;
                                                }
                                            }
                                        }
                                        // Skip: next() + MoveResult + optionally CheckCast
                                        let skip_count = if has_cast { 3 } else { 2 };
                                        return Some(ForEachInfo {
                                            item_var,
                                            item_type,
                                            skip_block: first_block,
                                            skip_start: i,
                                            skip_count,
                                        });
                                    }
                                }

                                // No MoveResult - just skip the next() call
                                return Some(ForEachInfo {
                                    item_var,
                                    item_type,
                                    skip_block: first_block,
                                    skip_start: i,
                                    skip_count: 1,
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

/// Check if the loop body has meaningful content after skipping iterator instructions
/// Returns true if there are instructions/regions beyond just the iterator next() call
fn body_has_meaningful_content(body: &Region, foreach_info: &ForEachInfo, ctx: &BodyGenContext) -> bool {
    fn count_meaningful_in_block(block_id: u32, skip_block: u32, skip_start: usize, skip_count: usize, ctx: &BodyGenContext) -> usize {
        if let Some(block) = ctx.blocks.get(&block_id) {
            let skip_end = skip_start + skip_count;
            block.instructions.iter().enumerate()
                .filter(|(i, insn)| {
                    // Skip if this is the skip_block and instruction is in skip range
                    if block_id == skip_block && *i >= skip_start && *i < skip_end {
                        return false;
                    }
                    // Skip control flow
                    !is_control_flow(&insn.insn_type)
                })
                .count()
        } else {
            0
        }
    }

    fn count_meaningful_in_region(region: &Region, skip_block: u32, skip_start: usize, skip_count: usize, ctx: &BodyGenContext) -> usize {
        match region {
            Region::Sequence(contents) => {
                contents.iter().map(|c| match c {
                    RegionContent::Block(b) => count_meaningful_in_block(*b, skip_block, skip_start, skip_count, ctx),
                    RegionContent::Region(r) => count_meaningful_in_region(r, skip_block, skip_start, skip_count, ctx),
                }).sum()
            }
            Region::If { then_region, else_region, .. } => {
                let then_count = count_meaningful_in_region(then_region, skip_block, skip_start, skip_count, ctx);
                let else_count = else_region.as_ref()
                    .map(|r| count_meaningful_in_region(r, skip_block, skip_start, skip_count, ctx))
                    .unwrap_or(0);
                then_count + else_count
            }
            Region::Loop { body, .. } => {
                count_meaningful_in_region(body, skip_block, skip_start, skip_count, ctx)
            }
            Region::Switch { cases, .. } => {
                cases.iter()
                    .map(|c| count_meaningful_in_region(&c.container, skip_block, skip_start, skip_count, ctx))
                    .sum()
            }
            Region::TryCatch { try_region, handlers, finally } => {
                let try_count = count_meaningful_in_region(try_region, skip_block, skip_start, skip_count, ctx);
                let catch_count: usize = handlers.iter()
                    .map(|c| count_meaningful_in_region(&c.region, skip_block, skip_start, skip_count, ctx))
                    .sum();
                let finally_count = finally.as_ref()
                    .map(|r| count_meaningful_in_region(r, skip_block, skip_start, skip_count, ctx))
                    .unwrap_or(0);
                try_count + catch_count + finally_count
            }
            Region::Synchronized { body, .. } => {
                count_meaningful_in_region(body, skip_block, skip_start, skip_count, ctx)
            }
            Region::Break { .. } | Region::Continue { .. } => {
                // Break/continue are single statements, no meaningful content to count
                0
            }
            Region::TernaryAssignment { .. } | Region::TernaryReturn { .. } => {
                // Ternaries are meaningful statements
                1
            }
        }
    }

    count_meaningful_in_region(body, foreach_info.skip_block, foreach_info.skip_start, foreach_info.skip_count, ctx) > 0
}

/// Check if body has content beyond just the skip_block
/// A block only counts if it has non-control-flow instructions
fn body_has_meaningful_structure(body: &Region, skip_block: u32, ctx: &BodyGenContext) -> bool {
    fn block_has_content(block_id: u32, skip_block: u32, ctx: &BodyGenContext) -> bool {
        // Skip block doesn't count (its content will be skipped)
        if block_id == skip_block {
            return false;
        }
        // Check if block has any non-control-flow instructions
        if let Some(block) = ctx.blocks.get(&block_id) {
            block.instructions.iter().any(|insn| !is_control_flow(&insn.insn_type))
        } else {
            false
        }
    }

    fn count_meaningful_blocks(region: &Region, skip_block: u32, ctx: &BodyGenContext) -> usize {
        match region {
            Region::Sequence(contents) => {
                contents.iter().map(|c| match c {
                    RegionContent::Block(b) => if block_has_content(*b, skip_block, ctx) { 1 } else { 0 },
                    RegionContent::Region(r) => count_meaningful_blocks(r, skip_block, ctx),
                }).sum()
            }
            Region::If { then_region, else_region, .. } => {
                let then_count = count_meaningful_blocks(then_region, skip_block, ctx);
                let else_count = else_region.as_ref()
                    .map(|r| count_meaningful_blocks(r, skip_block, ctx))
                    .unwrap_or(0);
                then_count + else_count
            }
            Region::Loop { body, .. } => count_meaningful_blocks(body, skip_block, ctx),
            Region::Switch { cases, .. } => {
                cases.iter()
                    .map(|c| count_meaningful_blocks(&c.container, skip_block, ctx))
                    .sum()
            }
            Region::TryCatch { try_region, handlers, finally } => {
                let try_count = count_meaningful_blocks(try_region, skip_block, ctx);
                let catch_count: usize = handlers.iter()
                    .map(|c| count_meaningful_blocks(&c.region, skip_block, ctx))
                    .sum();
                let finally_count = finally.as_ref()
                    .map(|r| count_meaningful_blocks(r, skip_block, ctx))
                    .unwrap_or(0);
                try_count + catch_count + finally_count
            }
            Region::Synchronized { body, .. } => count_meaningful_blocks(body, skip_block, ctx),
            Region::Break { .. } | Region::Continue { .. } => {
                // Break/continue are single statements, no blocks to count
                0
            }
            Region::TernaryAssignment { .. } | Region::TernaryReturn { .. } => {
                // Ternaries are meaningful statements
                1
            }
        }
    }
    count_meaningful_blocks(body, skip_block, ctx) > 0
}

/// Generate the array source expression for a for-each loop.
/// Traces back through the SSA graph to find if the array comes from a method call.
/// If so, generates the method call expression (e.g., "str.split(\";\")").
/// Otherwise, returns the simple variable name.
///
/// This matches JADX's behavior which uses `len.getArg(0)` which can be either
/// a register or a wrapped instruction containing a method call.
fn generate_array_source_expr(arr_reg_arg: &dexterity_ir::instructions::RegisterArg, ctx: &BodyGenContext) -> String {
    // First, try to find the defining instruction for this array register
    if let Some(defining_insn) = find_defining_instruction(arr_reg_arg, ctx) {
        // If the array is defined by a MoveResult, the actual source is the preceding invoke
        if matches!(defining_insn.insn_type, InsnType::MoveResult { .. }) {
            // Find the invoke instruction that precedes this MoveResult
            // We need to look in the same block, at the previous instruction
            for block in ctx.blocks.values() {
                for (i, insn) in block.instructions.iter().enumerate() {
                    if insn.offset == defining_insn.offset {
                        // Found the MoveResult - look at previous instruction
                        if i > 0 {
                            let prev_insn = &block.instructions[i - 1];
                            if let InsnType::Invoke { kind, method_idx, args, .. } = &prev_insn.insn_type {
                                // Generate the method call expression
                                if let Some(info) = ctx.expr_gen.get_method_value(*method_idx) {
                                    let mut expr = String::new();
                                    let skip_count = if matches!(kind, InvokeKind::Static) { 0 } else { 1 };

                                    match kind {
                                        InvokeKind::Static => {
                                            expr.push_str(&info.class_name);
                                            expr.push('.');
                                        }
                                        InvokeKind::Virtual | InvokeKind::Interface | InvokeKind::Direct => {
                                            if let Some(receiver) = args.first() {
                                                expr.push_str(&ctx.expr_gen.gen_arg(receiver));
                                                expr.push('.');
                                            }
                                        }
                                        _ => {}
                                    }

                                    expr.push_str(&sanitize_method_name(&info.method_name));
                                    expr.push('(');

                                    // Generate arguments
                                    let arg_strs: Vec<String> = args.iter()
                                        .skip(skip_count)
                                        .map(|arg| ctx.expr_gen.gen_arg(arg))
                                        .collect();
                                    expr.push_str(&arg_strs.join(", "));
                                    expr.push(')');

                                    return expr;
                                }
                            }
                        }
                        break;
                    }
                }
            }
        }
    }

    // Fall back to simple variable name
    ctx.expr_gen.gen_arg(&InsnArg::Register(*arr_reg_arg))
}

/// Detect array for-each loop pattern
/// Pattern: for (int i = 0; i < array.length; i++) { item = array[i]; ... }
/// Requirements (matching JADX LoopRegionVisitor.checkArrayForEach):
/// 1. Index initialized to 0 (CONST instruction)
/// 2. Condition: i < array.length (LT comparison with ArrayLength)
/// 3. Increment: i++ (ADD by literal 1)
/// 4. Body has AGET using same index and array
fn detect_array_foreach_pattern(
    condition: &Condition,
    body: &Region,
    ctx: &BodyGenContext,
) -> Option<ArrayForEachInfo> {
    // Extract condition block to find ArrayLength comparison
    let (cond_block_id, _op, _negated) = match condition {
        Condition::Simple { block, op: _, negated } => (*block, (), *negated),
        _ => return None,
    };

    let cond_block = ctx.blocks.get(&cond_block_id)?;

    // Find If instruction in condition block to get the comparison
    let mut index_reg: Option<u16> = None;
    let mut array_reg_arg: Option<dexterity_ir::instructions::RegisterArg> = None;
    let mut array_length_reg: Option<u16> = None;

    // First pass: look for ArrayLength instruction to identify the array
    for insn in &cond_block.instructions {
        if let InsnType::ArrayLength { dest, array } = &insn.insn_type {
            if let InsnArg::Register(arr_reg) = array {
                // Keep full RegisterArg to preserve SSA version for tracing
                array_reg_arg = Some(*arr_reg);
                array_length_reg = Some(dest.reg_num);
            }
        }
    }

    // Second pass: find the If instruction comparing index to array.length
    for insn in &cond_block.instructions {
        if let InsnType::If { condition: if_cond, left, right, .. } = &insn.insn_type {
            // For array for-each: i < length (LT) or negated as i >= length (GE)
            let is_lt_pattern = matches!(if_cond, IfCondition::Lt | IfCondition::Ge);
            if !is_lt_pattern {
                continue;
            }

            // Extract index register (should be on left of comparison with length)
            if let InsnArg::Register(left_reg) = left {
                if let Some(right_arg) = right {
                    if let InsnArg::Register(right_reg) = right_arg {
                        // Check if right side is array.length result
                        if array_length_reg == Some(right_reg.reg_num) {
                            index_reg = Some(left_reg.reg_num);
                        }
                    }
                }
            }
        }
    }

    let idx_reg = index_reg?;
    let arr_reg_arg = array_reg_arg?;
    let arr_reg = arr_reg_arg.reg_num;

    // Now scan body for:
    // 1. AGET instruction using index_reg and array_reg
    // 2. Increment instruction: index_reg = index_reg + 1
    let mut aget_info: Option<(u32, usize, String, String)> = None; // (block, idx, item_var, item_type)
    let mut incr_info: Option<(u32, usize)> = None; // (block, idx)

    fn scan_body_for_array_foreach(
        region: &Region,
        idx_reg: u16,
        arr_reg: u16,
        ctx: &BodyGenContext,
        aget_info: &mut Option<(u32, usize, String, String)>,
        incr_info: &mut Option<(u32, usize)>,
    ) {
        match region {
            Region::Sequence(contents) => {
                for content in contents {
                    match content {
                        RegionContent::Block(block_id) => {
                            if let Some(block) = ctx.blocks.get(block_id) {
                                for (insn_idx, insn) in block.instructions.iter().enumerate() {
                                    // Look for AGET: item = array[index]
                                    if let InsnType::ArrayGet { dest, array, index, elem_type } = &insn.insn_type {
                                        if let (InsnArg::Register(arr), InsnArg::Register(idx)) = (array, index) {
                                            if arr.reg_num == arr_reg && idx.reg_num == idx_reg {
                                                let item_var = ctx.expr_gen.get_var_name(dest);
                                                let item_type = match elem_type {
                                                    dexterity_ir::instructions::ArrayElemType::Object => "Object".to_string(),
                                                    dexterity_ir::instructions::ArrayElemType::Boolean => "boolean".to_string(),
                                                    dexterity_ir::instructions::ArrayElemType::Byte => "byte".to_string(),
                                                    dexterity_ir::instructions::ArrayElemType::Char => "char".to_string(),
                                                    dexterity_ir::instructions::ArrayElemType::Short => "short".to_string(),
                                                    dexterity_ir::instructions::ArrayElemType::Int => "int".to_string(),
                                                    dexterity_ir::instructions::ArrayElemType::Wide => "long".to_string(),
                                                };
                                                *aget_info = Some((*block_id, insn_idx, item_var, item_type));
                                            }
                                        }
                                    }

                                    // Look for increment: i = i + 1
                                    if let InsnType::Binary { dest, op, left, right } = &insn.insn_type {
                                        if *op == BinaryOp::Add && dest.reg_num == idx_reg {
                                            if let InsnArg::Register(left_reg) = left {
                                                if left_reg.reg_num == idx_reg {
                                                    if let InsnArg::Literal(LiteralArg::Int(val)) = right {
                                                        if *val == 1 {
                                                            *incr_info = Some((*block_id, insn_idx));
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                        RegionContent::Region(nested) => {
                            scan_body_for_array_foreach(nested, idx_reg, arr_reg, ctx, aget_info, incr_info);
                        }
                    }
                }
            }
            Region::If { then_region, else_region, .. } => {
                scan_body_for_array_foreach(then_region, idx_reg, arr_reg, ctx, aget_info, incr_info);
                if let Some(else_reg) = else_region {
                    scan_body_for_array_foreach(else_reg, idx_reg, arr_reg, ctx, aget_info, incr_info);
                }
            }
            Region::Loop { body, .. } => {
                scan_body_for_array_foreach(body, idx_reg, arr_reg, ctx, aget_info, incr_info);
            }
            _ => {}
        }
    }

    scan_body_for_array_foreach(body, idx_reg, arr_reg, ctx, &mut aget_info, &mut incr_info);

    // Both AGET and increment must be found
    let (aget_block, aget_idx, item_var, item_type) = aget_info?;
    let (incr_block, incr_idx) = incr_info?;

    // Generate array expression - trace back to method calls if array comes from invoke result
    let array_expr = generate_array_source_expr(&arr_reg_arg, ctx);

    Some(ArrayForEachInfo {
        array_expr,
        item_var,
        item_type,
        index_reg: idx_reg,
        aget_block,
        aget_insn_idx: aget_idx,
        incr_block,
        incr_insn_idx: incr_idx,
    })
}

// =============================================================================
// Switch-over-String Detection
// =============================================================================

/// Information about a detected switch-over-string pattern
struct SwitchOverStringInfo {
    /// The string expression being switched on
    string_expr: String,
    /// Map from case key (hashCode value) to string literal(s)
    case_strings: std::collections::HashMap<i32, Vec<String>>,
}

/// Information about a two-switch pattern for string switches
/// Java compilers emit switch-over-string as:
/// Switch 1: switch(str.hashCode()) { case X: if(str.equals("val")) idx=N; break; }
/// Switch 2: switch(idx) { case 0: doFoo(); case 1: doBar(); }
/// This struct captures the mapping needed to merge them into a single string switch
#[derive(Clone)]
struct TwoSwitchInfo {
    /// The string expression being switched on
    string_expr: String,
    /// The original string register (for equals() detection)
    string_source: (u16, u32),
    /// Maps index value -> string literal(s) that map to that index
    index_to_strings: std::collections::HashMap<i32, Vec<String>>,
    /// The index of the second switch in the parent sequence (to skip it later)
    second_switch_idx: usize,
}

/// Detect if a switch is actually a switch over a string
/// Java compiler transforms: switch(str) { case "hello": ... }
/// Into: switch(str.hashCode()) { case 99162322: if(str.equals("hello")) ... }
fn detect_switch_over_string(
    header_block: u32,
    cases: &[dexterity_ir::regions::CaseInfo],
    ctx: &BodyGenContext,
) -> Option<SwitchOverStringInfo> {
    let block = ctx.blocks.get(&header_block)?;

    // Find the switch instruction and get the value register
    let switch_reg = block.instructions.iter().find_map(|insn| {
        match &insn.insn_type {
            InsnType::PackedSwitch { value, .. } | InsnType::SparseSwitch { value, .. } => {
                if let InsnArg::Register(reg_arg) = value {
                    Some((reg_arg.reg_num, reg_arg.ssa_version))
                } else {
                    None
                }
            }
            _ => None,
        }
    })?;

    // Look for invoke-virtual hashCode() followed by MoveResult that produces switch_reg
    let string_source = find_hashcode_source_in_block(block, switch_reg.0, switch_reg.1, ctx)?;

    // Generate the string expression
    let string_reg_arg = dexterity_ir::instructions::RegisterArg {
        reg_num: string_source.0,
        ssa_version: string_source.1,
    };
    let string_expr = ctx.expr_gen.get_var_name(&string_reg_arg);

    // Collect string literals from equals() calls in each case
    use dexterity_ir::regions::CaseKey;
    let mut case_strings = std::collections::HashMap::new();

    for case in cases {
        let strings = find_equals_strings_for_case(&case.container, string_source.0, ctx);
        if !strings.is_empty() {
            for key in &case.keys {
                if let CaseKey::Int(int_key) = key {
                    case_strings.insert(*int_key, strings.clone());
                }
            }
        }
    }

    // Must have found at least one string to confirm pattern
    if case_strings.is_empty() {
        return None;
    }

    Some(SwitchOverStringInfo {
        string_expr,
        case_strings,
    })
}

/// Find the string register that had hashCode() called on it
/// Searches the given block first, then falls back to searching all blocks
fn find_hashcode_source_in_block(
    block: &dexterity_passes::block_split::BasicBlock,
    target_reg: u16,
    target_version: u32,
    ctx: &BodyGenContext,
) -> Option<(u16, u32)> {
    // First try the given block
    if let Some(result) = find_hashcode_in_single_block(block, target_reg, target_version, ctx) {
        return Some(result);
    }

    // Fall back to searching all blocks (hashCode might be in a predecessor)
    for other_block in ctx.blocks.values() {
        if let Some(result) = find_hashcode_in_single_block(other_block, target_reg, target_version, ctx) {
            return Some(result);
        }
    }

    None
}

/// Search a single block for hashCode() producing the target register
fn find_hashcode_in_single_block(
    block: &dexterity_passes::block_split::BasicBlock,
    target_reg: u16,
    target_version: u32,
    ctx: &BodyGenContext,
) -> Option<(u16, u32)> {
    // Look for invoke-virtual hashCode() followed by MoveResult that puts into target_reg
    for (i, insn) in block.instructions.iter().enumerate() {
        if let InsnType::Invoke { kind: InvokeKind::Virtual, method_idx, args, .. } = &insn.insn_type {
            // hashCode() takes just `this`
            if args.len() == 1 {
                // Verify method name is "hashCode"
                if let Some(method_info) = ctx.expr_gen.get_method_value(*method_idx) {
                    if &*method_info.method_name != "hashCode" {
                        continue;
                    }
                } else {
                    continue;
                }
                // Check if next instruction is MoveResult to our target
                if i + 1 < block.instructions.len() {
                    if let InsnType::MoveResult { dest } = &block.instructions[i + 1].insn_type {
                        if dest.reg_num == target_reg && dest.ssa_version == target_version {
                            // Confirmed hashCode() - return the string register
                            if let InsnArg::Register(reg_arg) = &args[0] {
                                return Some((reg_arg.reg_num, reg_arg.ssa_version));
                            }
                        }
                    }
                }
            }
        }
    }
    None
}

/// Find string literals from equals() calls in a case region
fn find_equals_strings_for_case(
    region: &Region,
    string_reg: u16,
    ctx: &BodyGenContext,
) -> Vec<String> {
    let mut strings = Vec::new();
    collect_equals_strings_from_region(region, string_reg, ctx, &mut strings);
    strings
}

/// Recursively collect string literals from equals() calls
fn collect_equals_strings_from_region(
    region: &Region,
    string_reg: u16,
    ctx: &BodyGenContext,
    strings: &mut Vec<String>,
) {
    match region {
        Region::Sequence(contents) => {
            for content in contents {
                match content {
                    RegionContent::Block(block_id) => {
                        if let Some(block) = ctx.blocks.get(block_id) {
                            for insn in &block.instructions {
                                if let Some(s) = extract_string_from_equals(insn, string_reg, ctx) {
                                    strings.push(s);
                                }
                            }
                        }
                    }
                    RegionContent::Region(nested) => {
                        collect_equals_strings_from_region(nested, string_reg, ctx, strings);
                    }
                }
            }
        }
        Region::If { condition, then_region, else_region } => {
            // Check condition block for equals() call
            if let Condition::Simple { block, .. } = condition {
                if let Some(block) = ctx.blocks.get(block) {
                    for insn in &block.instructions {
                        if let Some(s) = extract_string_from_equals(insn, string_reg, ctx) {
                            strings.push(s);
                        }
                    }
                }
            }
            collect_equals_strings_from_region(then_region, string_reg, ctx, strings);
            if let Some(else_reg) = else_region {
                collect_equals_strings_from_region(else_reg, string_reg, ctx, strings);
            }
        }
        _ => {}
    }
}

/// Extract string literal from an equals() call
fn extract_string_from_equals(
    insn: &InsnNode,
    string_reg: u16,
    ctx: &BodyGenContext,
) -> Option<String> {
    if let InsnType::Invoke { kind: InvokeKind::Virtual, method_idx, args, .. } = &insn.insn_type {
        // equals() takes 2 args: this, other
        if args.len() == 2 {
            // Verify method name is "equals"
            if let Some(method_info) = ctx.expr_gen.get_method_value(*method_idx) {
                if &*method_info.method_name != "equals" {
                    return None;
                }
            } else {
                return None;
            }
            // Check if first arg is our string register (str.equals(literal))
            if let InsnArg::Register(reg_arg) = &args[0] {
                if reg_arg.reg_num == string_reg {
                    return get_string_literal_from_arg(&args[1], ctx);
                }
            }
            // Also check reverse: "literal".equals(str)
            if let InsnArg::Register(reg_arg) = &args[1] {
                if reg_arg.reg_num == string_reg {
                    return get_string_literal_from_arg(&args[0], ctx);
                }
            }
        }
    }
    None
}

/// Get string literal from an instruction argument (handles const-string lookup)
fn get_string_literal_from_arg(arg: &InsnArg, ctx: &BodyGenContext) -> Option<String> {
    match arg {
        InsnArg::String(string_idx) => {
            ctx.expr_gen.get_string_value(*string_idx)
        }
        InsnArg::Register(reg_arg) => {
            // Look up the defining instruction to find const-string
            for block in ctx.blocks.values() {
                for insn in &block.instructions {
                    if let InsnType::ConstString { dest, string_idx } = &insn.insn_type {
                        if dest.reg_num == reg_arg.reg_num && dest.ssa_version == reg_arg.ssa_version {
                            return ctx.expr_gen.get_string_value(*string_idx);
                        }
                    }
                }
            }
            None
        }
        _ => None,
    }
}

// =============================================================================
// Two-Switch Pattern Detection (for switch-over-string merge)
// =============================================================================

/// Detect if a sequence contains a two-switch pattern that should be merged.
/// Java compilers emit switch-over-string as:
/// Switch 1: switch(str.hashCode()) { case X: if(str.equals("val")) idx=N; break; }
/// Switch 2: switch(idx) { case 0: doFoo(); case 1: doBar(); }
///
/// Returns: (first_switch_idx, TwoSwitchInfo) if pattern detected
fn detect_two_switch_in_sequence(
    contents: &[RegionContent],
    ctx: &BodyGenContext,
) -> Option<(usize, TwoSwitchInfo)> {
    // Scan for potential first switches (hashCode-based)
    for (idx, content) in contents.iter().enumerate() {
        if let RegionContent::Region(region) = content {
            if let Region::Switch { header_block, cases, .. } = region.as_ref() {
                // Check if this is a hashCode-based string switch
                let block = ctx.blocks.get(header_block)?;

                // Find the switch instruction and get the value register
                let switch_reg = block.instructions.iter().find_map(|insn| {
                    match &insn.insn_type {
                        InsnType::PackedSwitch { value, .. } | InsnType::SparseSwitch { value, .. } => {
                            if let InsnArg::Register(reg_arg) = value {
                                Some((reg_arg.reg_num, reg_arg.ssa_version))
                            } else {
                                None
                            }
                        }
                        _ => None,
                    }
                })?;

                // Look for hashCode() followed by MoveResult that produces switch_reg
                let string_source = find_hashcode_source_in_block(block, switch_reg.0, switch_reg.1, ctx)?;

                // Generate the string expression
                let string_reg_arg = dexterity_ir::instructions::RegisterArg {
                    reg_num: string_source.0,
                    ssa_version: string_source.1,
                };
                let string_expr = ctx.expr_gen.get_var_name(&string_reg_arg);

                // Now check if cases assign to an index variable
                let mut index_assignments: Vec<(i32, Vec<String>)> = Vec::new(); // (index, strings)
                let mut common_index_reg: Option<u16> = None;

                for case in cases {
                    // Find string literal from equals() call
                    let strings = find_equals_strings_for_case(&case.container, string_source.0, ctx);
                    if strings.is_empty() {
                        continue;
                    }

                    // Find index assignment: Const { dest, value: Int(N) }
                    if let Some((reg, _, index_value)) = find_index_assignment_in_case(&case.container, ctx) {
                        if let Some(expected_reg) = common_index_reg {
                            if reg != expected_reg {
                                // Different index registers - not a two-switch pattern
                                continue;
                            }
                        } else {
                            common_index_reg = Some(reg);
                        }
                        index_assignments.push((index_value, strings));
                    }
                }

                // Need at least one index assignment to be a two-switch pattern
                if index_assignments.is_empty() {
                    continue;
                }

                let index_reg = common_index_reg?;

                // Look for second switch that uses the index register
                for (second_idx, second_content) in contents.iter().enumerate().skip(idx + 1) {
                    if let RegionContent::Region(second_region) = second_content {
                        if let Region::Switch { header_block: second_header, cases: second_cases, .. } = second_region.as_ref() {
                            // Check if second switch uses our index register
                            let second_block = ctx.blocks.get(second_header)?;
                            let second_switch_reg = second_block.instructions.iter().find_map(|insn| {
                                match &insn.insn_type {
                                    InsnType::PackedSwitch { value, .. } | InsnType::SparseSwitch { value, .. } => {
                                        if let InsnArg::Register(reg_arg) = value {
                                            Some(reg_arg.reg_num)
                                        } else {
                                            None
                                        }
                                    }
                                    _ => None,
                                }
                            })?;

                            if second_switch_reg == index_reg {
                                // Found matching second switch!
                                // Build the index -> strings mapping
                                let mut index_to_strings = std::collections::HashMap::new();
                                for (index_value, strings) in index_assignments {
                                    index_to_strings.insert(index_value, strings);
                                }

                                // Found valid two-switch pattern
                                return Some((idx, TwoSwitchInfo {
                                    string_expr,
                                    string_source,
                                    index_to_strings,
                                    second_switch_idx: second_idx,
                                }));
                            }
                        }
                    }
                }
            }
        }
    }
    None
}

/// Find index assignment in a case region (Const { dest, value: Int(N) })
fn find_index_assignment_in_case(
    region: &Region,
    ctx: &BodyGenContext,
) -> Option<(u16, u32, i32)> {
    match region {
        Region::Sequence(contents) => {
            for content in contents {
                if let Some(result) = find_index_assignment_in_content(content, ctx) {
                    return Some(result);
                }
            }
            None
        }
        Region::If { then_region, else_region, .. } => {
            // Check then region
            if let Some(result) = find_index_assignment_in_case(then_region, ctx) {
                return Some(result);
            }
            // Check else region
            if let Some(else_reg) = else_region {
                if let Some(result) = find_index_assignment_in_case(else_reg, ctx) {
                    return Some(result);
                }
            }
            None
        }
        _ => None,
    }
}

/// Find index assignment in a region content
fn find_index_assignment_in_content(
    content: &RegionContent,
    ctx: &BodyGenContext,
) -> Option<(u16, u32, i32)> {
    match content {
        RegionContent::Block(block_id) => {
            let block = ctx.blocks.get(block_id)?;
            for insn in &block.instructions {
                if let InsnType::Const { dest, value: LiteralArg::Int(val) } = &insn.insn_type {
                    // Convert i64 to i32 (index values should be small)
                    return Some((dest.reg_num, dest.ssa_version, *val as i32));
                }
            }
            None
        }
        RegionContent::Region(region) => find_index_assignment_in_case(region, ctx),
    }
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

/// Check if a variable name suggests it's an object type (used for null comparison heuristic)
/// This helps detect null comparisons when type inference fails
fn name_suggests_object_type(name: &str) -> bool {
    // Convert to lowercase for case-insensitive matching
    let lower = name.to_lowercase();

    // Common object type name patterns (sorted by likely frequency)
    let object_patterns = [
        // String types (most common)
        "string", "str", "text", "name", "path", "url", "uri", "s",
        // Collection types
        "list", "set", "map", "array", "collection", "queue", "stack",
        "iterator", "iterable", "arraylist", "hashmap", "hashset",
        "treemap", "treeset", "linkedlist", "vector",
        // Common object patterns
        "obj", "object", "instance", "ref", "result", "data", "value",
        "item", "element", "entry", "node", "key", "record",
        // Stream/IO types
        "stream", "reader", "writer", "input", "output", "buffer",
        "file", "dir", "directory", "folder", "channel", "socket", "connection",
        // Android/UI types
        "view", "context", "intent", "bundle", "cursor", "adapter",
        "activity", "fragment", "dialog", "window", "layout",
        "bitmap", "drawable", "paint", "canvas", "rect",
        // Android storage types
        "storage", "external", "internal", "cache", "downloads",
        // Exception types
        "exception", "error", "throwable", "cause",
        // Generic suffixes that suggest objects
        "handler", "listener", "callback", "factory", "builder",
        "manager", "service", "provider", "controller", "helper",
        "util", "utils", "config", "options", "params", "args",
        // Java/Kotlin types
        "charsequence", "runnable", "callable", "thread", "class",
        "method", "field", "constructor", "type", "annotation",
        // Network/JSON types
        "request", "response", "client", "server", "message",
        "json", "xml", "document", "parser", "encoder", "decoder",
        // Firebase/Google types
        "task", "snapshot", "reference", "database", "storage",
        // Security types
        "key", "token", "credential", "certificate", "signature",
        // Other common objects
        "display", "device", "sensor", "camera", "audio", "video",
        "image", "resource", "asset", "preference", "editor",
    ];

    // Check for exact match or as suffix (e.g., "string1", "str2")
    for pattern in object_patterns {
        if lower == pattern {
            return true;
        }
        // Check if it's a pattern with a numeric suffix (e.g., "string1", "str2")
        if lower.starts_with(pattern) {
            let suffix = &lower[pattern.len()..];
            if suffix.is_empty() || suffix.chars().all(|c| c.is_ascii_digit()) {
                return true;
            }
        }
    }

    // Check for camelCase patterns (e.g., myString, someList)
    if lower.ends_with("string") || lower.ends_with("list") || lower.ends_with("map")
        || lower.ends_with("set") || lower.ends_with("array") || lower.ends_with("object")
        || lower.ends_with("collection") || lower.ends_with("stream") || lower.ends_with("context")
        || lower.ends_with("view") || lower.ends_with("activity") || lower.ends_with("fragment")
        || lower.ends_with("handler") || lower.ends_with("listener") || lower.ends_with("callback")
        || lower.ends_with("manager") || lower.ends_with("service") || lower.ends_with("provider")
        || lower.ends_with("exception") || lower.ends_with("error") || lower.ends_with("request")
        || lower.ends_with("response") || lower.ends_with("result") || lower.ends_with("data")
        // File/directory patterns
        || lower.ends_with("file") || lower.ends_with("directory") || lower.ends_with("dir")
        || lower.ends_with("path") || lower.ends_with("folder")
        // Storage patterns
        || lower.ends_with("storage") || lower.contains("storage")
        || lower.contains("directory") || lower.contains("file")
        // Other common patterns
        || lower.ends_with("bundle") || lower.ends_with("intent") || lower.ends_with("cursor")
        || lower.ends_with("adapter") || lower.ends_with("builder") || lower.ends_with("factory")
        || lower.ends_with("instance") || lower.ends_with("reference") || lower.ends_with("resource")
    {
        return true;
    }

    false
}

/// Generate condition expression string from a Condition
/// Uses gen_arg_with_inline_peek to support inlined expressions (e.g., loop bounds)
fn generate_condition(condition: &Condition, ctx: &BodyGenContext) -> String {
    match condition {
        Condition::Simple { block, op, negated } => {
            // Look up the block to find the If instruction with operands
            if let Some(basic_block) = ctx.blocks.get(block) {
                // Find the If instruction (usually the last one)
                for insn in basic_block.instructions.iter().rev() {
                    if let InsnType::If { condition: _, left, right, .. } = &insn.insn_type {
                        // Use gen_arg_with_inline_peek to substitute inlined expressions
                        // This is critical for loop conditions where variables like array.length()
                        // were marked for inlining - ensures we generate "i < arr.length()"
                        // instead of "i < i2" (undefined variable)
                        let left_str = ctx.gen_arg_with_inline_peek(left);

                        // Get type of left operand for type-aware condition generation
                        // Strategy: Check multiple sources in priority order:
                        // 1. type_info (from type inference) - if it returns a concrete object/array type, use it
                        // 2. expr_gen (which has method parameter types set from method signature)
                        // 3. Fall back to None if neither has useful information
                        //
                        // Note: type_info may return Unknown or Int even for object types due to inference limitations,
                        // so we check expr_gen as a secondary source for parameter types.
                        let left_type = if let InsnArg::Register(reg) = left {
                            let type_info_type = ctx.type_info.as_ref()
                                .and_then(|ti| ti.types.get(&(reg.reg_num, reg.ssa_version)))
                                .cloned();
                            let expr_gen_type = ctx.expr_gen.get_var_type(reg.reg_num, reg.ssa_version);

                            // Prefer type_info if it's a concrete object/array type
                            // Otherwise, check expr_gen (for parameter types)
                            match &type_info_type {
                                Some(ArgType::Object(_)) | Some(ArgType::Array(_)) => type_info_type,
                                Some(ArgType::Boolean) => type_info_type,
                                // For Unknown, Int, or other types, check if expr_gen has better info
                                _ => match &expr_gen_type {
                                    Some(ArgType::Object(_)) | Some(ArgType::Array(_)) => expr_gen_type,
                                    Some(ArgType::Boolean) => expr_gen_type,
                                    // Fall back to type_info if neither has object/boolean
                                    _ => type_info_type.or(expr_gen_type),
                                }
                            }
                        } else {
                            None
                        };

                        // Check type to decide comparison format
                        // Use explicit type if available, otherwise fall back to name-based heuristic
                        // Note: ArgType::Unknown means type inference couldn't determine the type,
                        // so we should also use the name heuristic in that case.
                        // Also treat ArgType::Int and ArgType::Boolean as ambiguous because DEX
                        // bytecode uses if-eqz for null checks, boolean checks, AND integer zero
                        // checks - they're indistinguishable at the bytecode level, so we need
                        // the name heuristic to disambiguate.
                        let type_is_ambiguous = left_type.is_none()
                            || matches!(left_type, Some(ArgType::Unknown))
                            || matches!(left_type, Some(ArgType::Int))
                            || matches!(left_type, Some(ArgType::Boolean));
                        let is_object = matches!(left_type, Some(ArgType::Object(_)) | Some(ArgType::Array(_)) | Some(ArgType::Generic { .. }))
                            || (type_is_ambiguous && name_suggests_object_type(&left_str));
                        let is_boolean = matches!(left_type, Some(ArgType::Boolean));

                        // Check if this is a comparison against 1 (true) for boolean types
                        let is_one_compare = matches!(right, Some(r) if is_one_literal(r));
                        if is_one_compare && is_boolean {
                            let effective_op = if *negated { negate_op(op) } else { *op };

                            // Special case: check if left operand is a bitwise AND/OR of booleans
                            // Convert: (a & b) == true -> a && b
                            // Convert: (a | b) == true -> a || b
                            if let InsnArg::Register(reg) = left {
                                if let Some(bitwise_op) = find_bitwise_boolean_op(reg.reg_num, reg.ssa_version, ctx) {
                                    let logical_op = match bitwise_op.op {
                                        BinaryOp::And => "&&",
                                        BinaryOp::Or => "||",
                                        _ => unreachable!(), // find_bitwise_boolean_op only returns And/Or
                                    };
                                    let result = format!("{} {} {}", bitwise_op.left_str, logical_op, bitwise_op.right_str);
                                    return match effective_op {
                                        IfCondition::Eq => result, // (a & b) == true -> a && b
                                        IfCondition::Ne => format!("!({})", result), // (a & b) != true -> !(a && b)
                                        _ => format!("({}) {} 1", result, if_condition_to_string(op, *negated)),
                                    };
                                }
                            }

                            match effective_op {
                                IfCondition::Eq => {
                                    // bool == true -> just bool
                                    return left_str;
                                }
                                IfCondition::Ne => {
                                    // bool != true -> !bool
                                    return format!("!{}", wrap_if_complex(&left_str));
                                }
                                _ => {}
                            }
                        }

                        // Check if this is a zero-comparison (commonly used for booleans and null checks)
                        let is_zero_compare = right.is_none() || matches!(right, Some(r) if is_zero_literal(r));

                        if is_zero_compare {
                            let effective_op = if *negated { negate_op(op) } else { *op };

                            // Special case: check if left operand is a bitwise AND/OR of booleans
                            // Convert: (a & b) != false -> a && b  (ne 0 means true)
                            // Convert: (a | b) != false -> a || b  (ne 0 means true)
                            // Convert: (a & b) == false -> !(a && b)
                            // Convert: (a | b) == false -> !(a || b)
                            if is_boolean {
                                if let InsnArg::Register(reg) = left {
                                    if let Some(bitwise_op) = find_bitwise_boolean_op(reg.reg_num, reg.ssa_version, ctx) {
                                        let logical_op = match bitwise_op.op {
                                            BinaryOp::And => "&&",
                                            BinaryOp::Or => "||",
                                            _ => unreachable!(),
                                        };
                                        let result = format!("{} {} {}", bitwise_op.left_str, logical_op, bitwise_op.right_str);
                                        return match effective_op {
                                            IfCondition::Ne => result, // (a & b) != false -> a && b
                                            IfCondition::Eq => format!("!({})", result), // (a & b) == false -> !(a && b)
                                            _ => format!("({}) {} 0", result, if_condition_to_string(op, *negated)),
                                        };
                                    }
                                }
                            }

                            match effective_op {
                                IfCondition::Eq => {
                                    if is_object {
                                        return format!("{} == null", left_str);
                                    } else if is_boolean {
                                        return format!("!{}", wrap_if_complex(&left_str));
                                    } else {
                                        return format!("{} == 0", left_str);
                                    }
                                }
                                IfCondition::Ne => {
                                    if is_object {
                                        return format!("{} != null", left_str);
                                    } else if is_boolean {
                                        return left_str;
                                    } else {
                                        return format!("{} != 0", left_str);
                                    }
                                }
                                _ => {
                                    // For other ops (lt, gt, etc.), keep explicit comparison
                                    let op_str = if_condition_to_string(op, *negated);
                                    return format!("{} {} 0", left_str, op_str);
                                }
                            }
                        }

                        let right_str = match right {
                            Some(r) => ctx.gen_arg_with_inline_peek(r),
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
            // Simplify negation by pushing it into the inner condition when possible
            match inner.as_ref() {
                // Not(Simple) -> flip the negated flag and generate without ! wrapper
                Condition::Simple { block, op, negated } => {
                    let flipped = Condition::Simple {
                        block: *block,
                        op: *op,
                        negated: !*negated,
                    };
                    generate_condition(&flipped, ctx)
                }
                // Not(Not(x)) -> x (double negation elimination)
                Condition::Not(inner_inner) => {
                    generate_condition(inner_inner, ctx)
                }
                // Not(And/Or/Ternary) - must wrap with !
                _ => {
                    let inner_str = generate_condition(inner, ctx);
                    format!("!{}", wrap_if_complex(&inner_str))
                }
            }
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

/// Check if an InsnArg is a one literal (true for boolean comparisons)
fn is_one_literal(arg: &InsnArg) -> bool {
    matches!(arg, InsnArg::Literal(LiteralArg::Int(1)))
}

/// Result of finding a bitwise boolean operation
/// Used for converting (a & b) == true -> a && b
#[derive(Debug)]
struct BitwiseBooleanOp {
    /// The binary operation (And or Or)
    op: BinaryOp,
    /// String representation of left operand
    left_str: String,
    /// String representation of right operand
    right_str: String,
}

/// Find if a register is defined by a bitwise AND/OR operation on boolean values
/// Returns the operation and operand strings if found
fn find_bitwise_boolean_op(
    reg_num: u16,
    ssa_version: u32,
    ctx: &BodyGenContext,
) -> Option<BitwiseBooleanOp> {
    // Search all blocks for the instruction that defines this register
    for block in ctx.blocks.values() {
        for insn in &block.instructions {
            if let InsnType::Binary { dest, op, left, right } = &insn.insn_type {
                // Check if this instruction defines the register we're looking for
                if dest.reg_num == reg_num && dest.ssa_version == ssa_version {
                    // Only interested in bitwise AND/OR
                    if *op != BinaryOp::And && *op != BinaryOp::Or {
                        return None;
                    }

                    // Check if both operands are boolean type
                    let left_is_bool = is_arg_boolean(left, ctx);
                    let right_is_bool = is_arg_boolean(right, ctx);

                    if left_is_bool && right_is_bool {
                        let left_str = ctx.expr_gen.gen_arg(left);
                        let right_str = ctx.expr_gen.gen_arg(right);
                        return Some(BitwiseBooleanOp {
                            op: *op,
                            left_str,
                            right_str,
                        });
                    }
                    return None;
                }
            }
        }
    }
    None
}

/// Check if an InsnArg is of boolean type
fn is_arg_boolean(arg: &InsnArg, ctx: &BodyGenContext) -> bool {
    match arg {
        InsnArg::Register(reg) => {
            ctx.type_info.as_ref()
                .and_then(|ti| ti.types.get(&(reg.reg_num, reg.ssa_version)))
                .map_or(false, |ty| matches!(ty, ArgType::Boolean))
        }
        // A literal can be treated as boolean if it's 0 or 1
        InsnArg::Literal(LiteralArg::Int(v)) => *v == 0 || *v == 1,
        _ => false,
    }
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

/// Information about a return-ternary pattern
struct ReturnTernaryInfo {
    /// Expression string for the "then" return value
    then_value: String,
    /// Expression string for the "else" return value
    else_value: String,
}

/// Detect return-ternary pattern: both branches return a value
/// Pattern: if (cond) { return a; } else { return b; } -> return cond ? a : b;
/// From JADX TernaryMod.java lines 137-168
fn detect_return_ternary_pattern(
    then_region: &Region,
    else_region: &Region,
    ctx: &BodyGenContext,
) -> Option<ReturnTernaryInfo> {
    // Both branches must be simple sequences with single blocks
    let then_block_id = get_single_block(then_region)?;
    let else_block_id = get_single_block(else_region)?;

    let then_block = ctx.blocks.get(&then_block_id)?;
    let else_block = ctx.blocks.get(&else_block_id)?;

    // Find return instructions in both blocks
    let then_return = then_block.instructions.iter()
        .find(|i| matches!(i.insn_type, InsnType::Return { value: Some(_) }));
    let else_return = else_block.instructions.iter()
        .find(|i| matches!(i.insn_type, InsnType::Return { value: Some(_) }));

    // Both must have non-void returns
    let (then_ret, else_ret) = match (then_return, else_return) {
        (Some(t), Some(e)) => (t, e),
        _ => return None,
    };

    // Extract return values
    let then_value = match &then_ret.insn_type {
        InsnType::Return { value: Some(v) } => ctx.expr_gen.gen_arg(v),
        _ => return None,
    };
    let else_value = match &else_ret.insn_type {
        InsnType::Return { value: Some(v) } => ctx.expr_gen.gen_arg(v),
        _ => return None,
    };

    // JADX check: don't mix literal and non-literal (one arg is literal)
    // This prevents asymmetric ternaries that look odd
    let then_is_literal = matches!(&then_ret.insn_type,
        InsnType::Return { value: Some(v) } if matches!(v, InsnArg::Literal(_)));
    let else_is_literal = matches!(&else_ret.insn_type,
        InsnType::Return { value: Some(v) } if matches!(v, InsnArg::Literal(_)));

    if then_is_literal != else_is_literal {
        return None;
    }

    Some(ReturnTernaryInfo {
        then_value,
        else_value,
    })
}

/// Information about a single-branch ternary pattern
struct SingleBranchTernaryInfo {
    /// Destination register
    dest_reg: u16,
    /// SSA version of destination
    dest_version: u32,
    /// Expression string for the "then" value
    then_value: String,
    /// Variable name for the "else" value (same variable, earlier version)
    else_var_name: String,
}

/// Detect single-branch ternary pattern: if (cond) { r = a; }
/// Pattern: if (cond) { r = a; } -> r = cond ? a : r;
/// From JADX TernaryMod.java lines 266-348 (processOneBranchTernary)
/// Used in constructors to help move super() calls to top
fn detect_single_branch_ternary_pattern(
    then_region: &Region,
    ctx: &BodyGenContext,
    is_constructor: bool,
) -> Option<SingleBranchTernaryInfo> {
    // Then branch must be a simple sequence with single block
    let then_block_id = get_single_block(then_region)?;
    let then_block = ctx.blocks.get(&then_block_id)?;

    // Get non-control-flow instructions
    let insns: Vec<_> = then_block.instructions.iter()
        .filter(|i| !is_control_flow(&i.insn_type))
        .collect();

    // Must have exactly one assignment instruction
    if insns.len() != 1 {
        return None;
    }

    let insn = insns[0];
    let dest = get_insn_dest(&insn.insn_type)?;
    let value = get_insn_value_expr(&insn.insn_type, ctx)?;

    // Get the variable name for the else branch (same register, but we use current name)
    // In Java, this becomes: r = cond ? a : r
    let else_var_name = ctx.expr_gen.get_var_name(&dexterity_ir::instructions::RegisterArg::with_ssa(dest.0, dest.1));

    // JADX constraint: Only apply this optimization in constructors (helps move super() to top)
    // or when the variable is not used in the else branch to prevent: l = (l == 0) ? 1 : l
    // For now, only enable for constructors to be conservative
    if !is_constructor {
        return None;
    }

    Some(SingleBranchTernaryInfo {
        dest_reg: dest.0,
        dest_version: dest.1,
        then_value: value,
        else_var_name,
    })
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
        .filter(|i| !is_control_flow(&i.insn_type))
        .collect();
    let else_insns: Vec<_> = else_block.instructions.iter()
        .filter(|i| !is_control_flow(&i.insn_type))
        .collect();

    // Allow up to 2 instructions if the last one is an assignment
    // (handles cases like loading a constant then using it)
    if then_insns.is_empty() || else_insns.is_empty() || then_insns.len() > 2 || else_insns.len() > 2 {
        return None;
    }

    // Last instruction in each block must be an assignment to the same register
    let then_insn = then_insns.last()?;
    let else_insn = else_insns.last()?;

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
        .filter(|i| !is_control_flow(&i.insn_type))
        .collect();

    if insns.is_empty() || insns.len() > 2 {
        return None;
    }

    let last_insn = insns.last()?;
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

/// Simplify ternary-to-boolean patterns:
/// - `cond ? true : false` -> `cond`
/// - `cond ? false : true` -> `!cond`
/// Returns the simplified expression or None if no simplification possible
fn simplify_ternary_to_boolean(condition_str: &str, then_value: &str, else_value: &str) -> Option<String> {
    let then_trimmed = then_value.trim();
    let else_trimmed = else_value.trim();

    // Pattern: cond ? true : false -> cond
    if then_trimmed == "true" && else_trimmed == "false" {
        return Some(condition_str.to_string());
    }

    // Pattern: cond ? false : true -> !cond
    if then_trimmed == "false" && else_trimmed == "true" {
        // Need to negate the condition
        // If condition already has !, remove it (double negation)
        let cond = condition_str.trim();
        if cond.starts_with("!(") && cond.ends_with(")") {
            // !(...) -> extract inner
            return Some(cond[2..cond.len()-1].to_string());
        } else if cond.starts_with("!") && !cond[1..].contains(" ") {
            // !x -> x (simple variable negation)
            return Some(cond[1..].to_string());
        } else {
            // Wrap in negation
            if cond.contains(" ") && !cond.starts_with("(") {
                return Some(format!("!({})", cond));
            } else {
                return Some(format!("!{}", cond));
            }
        }
    }

    // Pattern: cond ? 1 : 0 with boolean context (also represents true/false)
    // This is more conservative - only simplify if we know it's boolean context
    if then_trimmed == "1" && else_trimmed == "0" {
        // Check if condition itself suggests boolean context
        // For now, don't simplify - the 1/0 might be intentional integers
        return None;
    }

    None
}

/// Emit a ternary assignment: dest = cond ? then_val : else_val
fn emit_ternary_assignment<W: CodeWriter>(
    ternary: &TernaryExprInfo,
    condition_str: &str,
    ctx: &mut BodyGenContext,
    code: &mut W,
) {
    use dexterity_ir::instructions::RegisterArg;

    let mut var_name = ctx.expr_gen.get_var_name(&RegisterArg::with_ssa(ternary.dest_reg, ternary.dest_version));
    let reg = ternary.dest_reg;
    let version = ternary.dest_version;

    // Determine the type for this variable
    let decl_type = ctx.get_inferred_type_versioned(reg, version)
        .or_else(|| ctx.get_inferred_type_versioned(reg, 0))
        .cloned()
        .unwrap_or_else(|| ArgType::Object("java/lang/Object".to_string()));

    // Check if we need to declare this variable
    let needs_decl = if ctx.is_declared(reg, version) || ctx.is_parameter(reg, version) {
        false
    } else if let Some(existing_type) = ctx.get_declared_name_type(&var_name) {
        if !types_compatible_for_naming(existing_type, &decl_type) {
            var_name = ctx.generate_unique_name(&var_name);
            ctx.expr_gen.set_var_name(reg, version, var_name.clone());
            true
        } else {
            false
        }
    } else {
        true
    };

    code.start_line();

    if needs_decl {
        let type_str = type_to_string_with_imports(&decl_type, ctx.imports.as_ref());
        code.add(&type_str).add(" ");
        ctx.mark_declared(reg, version);
        ctx.mark_name_declared(&var_name, &decl_type);
    }

    // Try to simplify ternary-to-boolean patterns first
    if let Some(simplified) = simplify_ternary_to_boolean(condition_str, &ternary.then_value, &ternary.else_value) {
        // Simplified to just a boolean expression
        code.add(&var_name)
            .add(" = ")
            .add(&simplified)
            .add(";")
            .newline();
        return;
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

/// Emit a return-ternary: return cond ? then_val : else_val
/// From JADX TernaryMod.java lines 137-168
fn emit_return_ternary<W: CodeWriter>(
    ternary: &ReturnTernaryInfo,
    condition_str: &str,
    return_type: &ArgType,
    code: &mut W,
) {
    // Try to simplify ternary-to-boolean patterns first
    if let Some(simplified) = simplify_ternary_to_boolean(condition_str, &ternary.then_value, &ternary.else_value) {
        // Simplified to just a boolean expression
        code.start_line()
            .add("return ")
            .add(&simplified)
            .add(";")
            .newline();
        return;
    }

    // For boolean return type, simplify `cond ? 1 : 0` to just `cond`
    // and `cond ? 0 : 1` to `!cond`
    // In DEX bytecode, boolean comparisons often result in 1/0 literals
    if matches!(return_type, ArgType::Boolean) {
        let then_trimmed = ternary.then_value.trim();
        let else_trimmed = ternary.else_value.trim();

        if then_trimmed == "1" && else_trimmed == "0" {
            // cond ? 1 : 0 in boolean context -> cond
            code.start_line()
                .add("return ")
                .add(condition_str)
                .add(";")
                .newline();
            return;
        }
        if then_trimmed == "0" && else_trimmed == "1" {
            // cond ? 0 : 1 in boolean context -> !cond
            code.start_line()
                .add("return !(")
                .add(condition_str)
                .add(");")
                .newline();
            return;
        }
    }

    // Generate return with ternary expression
    code.start_line()
        .add("return ")
        .add(condition_str)
        .add(" ? ")
        .add(&ternary.then_value)
        .add(" : ")
        .add(&ternary.else_value)
        .add(";")
        .newline();
}

/// Emit a single-branch ternary: dest = cond ? then_val : dest
/// From JADX TernaryMod.java lines 266-348 (processOneBranchTernary)
fn emit_single_branch_ternary<W: CodeWriter>(
    ternary: &SingleBranchTernaryInfo,
    condition_str: &str,
    ctx: &mut BodyGenContext,
    code: &mut W,
) {
    use dexterity_ir::instructions::RegisterArg;

    let mut var_name = ctx.expr_gen.get_var_name(&RegisterArg::with_ssa(ternary.dest_reg, ternary.dest_version));
    let reg = ternary.dest_reg;
    let version = ternary.dest_version;

    // Determine the type for this variable
    let decl_type = ctx.get_inferred_type_versioned(reg, version)
        .or_else(|| ctx.get_inferred_type_versioned(reg, 0))
        .cloned()
        .unwrap_or_else(|| ArgType::Object("java/lang/Object".to_string()));

    // Check if we need to declare this variable
    let needs_decl = if ctx.is_declared(reg, version) || ctx.is_parameter(reg, version) {
        false
    } else if let Some(existing_type) = ctx.get_declared_name_type(&var_name) {
        if !types_compatible_for_naming(existing_type, &decl_type) {
            var_name = ctx.generate_unique_name(&var_name);
            ctx.expr_gen.set_var_name(reg, version, var_name.clone());
            true
        } else {
            false
        }
    } else {
        true
    };

    code.start_line();

    if needs_decl {
        let type_str = type_to_string_with_imports(&decl_type, ctx.imports.as_ref());
        code.add(&type_str).add(" ");
        ctx.mark_declared(reg, version);
        ctx.mark_name_declared(&var_name, &decl_type);
    }

    // Generate ternary: dest = cond ? then_val : dest
    code.add(&var_name)
        .add(" = ")
        .add(condition_str)
        .add(" ? ")
        .add(&ternary.then_value)
        .add(" : ")
        .add(&ternary.else_var_name)
        .add(";")
        .newline();
}

/// Convert SSA blocks to BasicBlock map by taking ownership (no cloning)
/// This is the memory-efficient version
fn ssa_blocks_to_map_owned(ssa_result: dexterity_passes::ssa::SsaResult) -> BTreeMap<u32, BasicBlock> {
    let mut map = BTreeMap::new();
    for ssa_block in ssa_result.blocks {
        // Compute offsets from instructions
        let start_offset = ssa_block.instructions.first().map(|i| i.offset).unwrap_or(0);
        let end_offset = ssa_block.instructions.last().map(|i| i.offset + 1).unwrap_or(0);
        let basic_block = BasicBlock {
            id: ssa_block.id,
            start_offset,
            end_offset,
            instructions: ssa_block.instructions, // Move, not clone!
            successors: ssa_block.successors,     // Move, not clone!
            predecessors: ssa_block.predecessors, // Move, not clone!
            flags: 0,
        };
        map.insert(ssa_block.id, basic_block);
    }
    map
}

/// Generate a lambda expression with proper syntax
fn generate_lambda_expression<W: CodeWriter>(
    info: &dexterity_ir::LambdaInfo,
    invoke_args: &[dexterity_ir::InsnArg],
    ctx: &mut BodyGenContext,
    code: &mut W,
) {
    // Generate parameter list
    let param_count = info.lambda_param_types.len();
    if param_count == 0 {
        code.add("()");
    } else if param_count == 1 {
        let param_name = generate_lambda_param_name(0, &info.lambda_param_types[0]);
        code.add(&param_name);
    } else {
        code.add("(");
        for (i, param_type) in info.lambda_param_types.iter().enumerate() {
            if i > 0 { code.add(", "); }
            code.add(&generate_lambda_param_name(i, param_type));
        }
        code.add(")");
    }

    code.add(" -> ");

    // Try to inline the lambda body if available
    if info.inline_body {
        if let Some(lambda_method) = ctx.get_lambda_method(&info.impl_method_name) {
            if let Some(body_expr) = try_inline_single_expression_lambda(lambda_method, info, invoke_args, ctx) {
                code.add(&body_expr);
                return;
            }
        }
    }

    // Fallback: Generate a block that calls the implementation method
    generate_lambda_method_call_body(info, invoke_args, ctx, code);
}

fn try_inline_single_expression_lambda(
    lambda_method: &dexterity_ir::MethodData,
    info: &dexterity_ir::LambdaInfo,
    invoke_args: &[dexterity_ir::InsnArg],
    ctx: &BodyGenContext,
) -> Option<String> {
    let instructions = lambda_method.instructions()?;
    let meaningful: Vec<_> = instructions.iter()
        .filter(|i| !matches!(i.insn_type, dexterity_ir::InsnType::Nop))
        .collect();

    if meaningful.len() == 1 {
        if let dexterity_ir::InsnType::Return { value: Some(ret_arg) } = &meaningful[0].insn_type {
            return Some(generate_arg_with_lambda_mapping(ret_arg, info, invoke_args, ctx));
        }
    }
    if meaningful.len() == 2 {
        if let dexterity_ir::InsnType::Return { value: Some(ret_arg) } = &meaningful[1].insn_type {
            if let dexterity_ir::InsnArg::Register(reg) = ret_arg {
                if let Some(expr) = generate_insn_as_expression(&meaningful[0].insn_type, reg.reg_num, info, invoke_args, ctx) {
                    return Some(expr);
                }
            }
        }
    }
    None
}

fn generate_insn_as_expression(
    insn_type: &dexterity_ir::InsnType,
    _target_reg: u16,
    info: &dexterity_ir::LambdaInfo,
    invoke_args: &[dexterity_ir::InsnArg],
    ctx: &BodyGenContext,
) -> Option<String> {
    use dexterity_ir::instructions::BinaryOp;
    match insn_type {
        dexterity_ir::InsnType::Binary { left, op, right, .. } => {
            let left_str = generate_arg_with_lambda_mapping(left, info, invoke_args, ctx);
            let right_str = generate_arg_with_lambda_mapping(right, info, invoke_args, ctx);
            let op_str = match op {
                BinaryOp::Add => "+",
                BinaryOp::Sub => "-",
                BinaryOp::Mul => "*",
                BinaryOp::Div => "/",
                BinaryOp::Rem => "%",
                BinaryOp::And => "&",
                BinaryOp::Or => "|",
                BinaryOp::Xor => "^",
                BinaryOp::Shl => "<<",
                BinaryOp::Shr => ">>",
                BinaryOp::Ushr => ">>>",
                BinaryOp::Rsub => "-", // Rsub is reverse subtract
            };
            Some(format!("{} {} {}", left_str, op_str, right_str))
        }
        dexterity_ir::InsnType::Const { value, .. } => Some(ctx.expr_gen.gen_literal(value)),
        _ => None,
    }
}

fn generate_arg_with_lambda_mapping(
    arg: &dexterity_ir::InsnArg,
    info: &dexterity_ir::LambdaInfo,
    invoke_args: &[dexterity_ir::InsnArg],
    ctx: &BodyGenContext,
) -> String {
    match arg {
        dexterity_ir::InsnArg::Register(reg) => {
            let reg_num = reg.reg_num as usize;
            if reg_num < info.captured_arg_count && reg_num < invoke_args.len() {
                return ctx.expr_gen.gen_arg(&invoke_args[reg_num]);
            }
            let param_idx = reg_num.saturating_sub(info.captured_arg_count);
            if param_idx < info.lambda_param_types.len() {
                return generate_lambda_param_name(param_idx, &info.lambda_param_types[param_idx]);
            }
            format!("v{}", reg_num)
        }
        dexterity_ir::InsnArg::Literal(lit) => ctx.expr_gen.gen_literal(lit),
        // For other arg types (Type, Field, Method, String refs), use the standard gen_arg
        _ => ctx.expr_gen.gen_arg(arg),
    }
}

fn generate_lambda_param_name(idx: usize, param_type: &dexterity_ir::ArgType) -> String {
    use dexterity_ir::ArgType;
    let base = match param_type {
        ArgType::Int => "i", ArgType::Long => "l", ArgType::Float => "f",
        ArgType::Double => "d", ArgType::Boolean => "b", ArgType::Byte => "b",
        ArgType::Char => "c", ArgType::Short => "s",
        ArgType::Object(name) => {
            let simple = name.rsplit('/').next().unwrap_or("obj").strip_suffix(';').unwrap_or(name.rsplit('/').next().unwrap_or("obj"));
            let prefix = simple.chars().next().unwrap_or('o').to_lowercase().to_string();
            return if idx > 0 { format!("{}{}", prefix, idx) } else { prefix };
        }
        ArgType::Array(_) | ArgType::UnknownArray => "arr",
        ArgType::Generic { base, .. } => {
            let prefix = base.rsplit('/').next().unwrap_or("t").chars().next().unwrap_or('t').to_lowercase().to_string();
            return if idx > 0 { format!("{}{}", prefix, idx) } else { prefix };
        }
        ArgType::Void => "v",
        ArgType::Unknown | ArgType::Wildcard { .. } | ArgType::TypeVariable(_)
        | ArgType::UnknownNarrow | ArgType::UnknownWide | ArgType::UnknownObject
        | ArgType::UnknownIntegral => "p",
    };
    if idx == 0 { base.to_string() } else { format!("{}{}", base, idx) }
}

fn generate_lambda_method_call_body<W: CodeWriter>(
    info: &dexterity_ir::LambdaInfo,
    invoke_args: &[dexterity_ir::InsnArg],
    ctx: &mut BodyGenContext,
    code: &mut W,
) {
    let is_void = matches!(info.lambda_return_type, dexterity_ir::ArgType::Void);
    let use_block = !invoke_args.is_empty() || !is_void;

    if use_block {
        code.add("{").newline().inc_indent();
        code.start_line();
        if !is_void { code.add("return "); }
    }

    if matches!(info.handle_type, dexterity_ir::LambdaHandleType::InvokeStatic) {
        code.add(&info.impl_class.replace('/', ".")).add(".").add(&info.impl_method_name);
    } else {
        if !invoke_args.is_empty() { ctx.write_arg_inline(code, &invoke_args[0]); code.add("."); }
        else { code.add("this."); }
        code.add(&info.impl_method_name);
    }

    code.add("(");
    let skip = if matches!(info.handle_type, dexterity_ir::LambdaHandleType::InvokeStatic) { 0 } else { 1 };
    let mut first = true;
    for (i, arg) in invoke_args.iter().enumerate() {
        if i < skip { continue; }
        if !first { code.add(", "); }
        first = false;
        ctx.write_arg_inline(code, arg);
    }
    for (i, pt) in info.lambda_param_types.iter().enumerate() {
        if !first { code.add(", "); }
        first = false;
        code.add(&generate_lambda_param_name(i, pt));
    }
    code.add(")");

    if use_block {
        code.add(";").newline().dec_indent();
        code.start_line().add("}");
    }
}

/// Generate a merged string switch from a two-switch pattern
/// Takes the second switch (with index cases) and maps case indices to string literals
fn generate_merged_string_switch<W: CodeWriter>(
    content: &RegionContent,
    info: &TwoSwitchInfo,
    ctx: &mut BodyGenContext,
    code: &mut W,
) {
    // Extract the switch from the content
    let switch_region = match content {
        RegionContent::Region(region) => region.as_ref(),
        _ => {
            // Not a region - shouldn't happen, fall back to normal generation
            generate_content(content, ctx, code);
            return;
        }
    };

    if let Region::Switch { header_block: _, cases } = switch_region {
        use dexterity_ir::regions::CaseKey;

        // Generate switch header with string expression
        code.start_line()
            .add("switch (")
            .add(&info.string_expr)
            .add(") {")
            .newline();
        code.inc_indent();

        // Separate default case from regular cases
        let default_case = cases.iter().find(|c| c.is_default());
        let regular_cases: Vec<_> = cases.iter().filter(|c| !c.is_default()).collect();

        for (case_idx, case) in regular_cases.iter().enumerate() {
            // Map index keys to string literals
            let mut emitted_any = false;
            for key in &case.keys {
                if let CaseKey::Int(int_key) = key {
                    if let Some(strings) = info.index_to_strings.get(int_key) {
                        for s in strings {
                            code.start_line()
                                .add("case ")
                                .add(&crate::type_gen::escape_string(s))
                                .add(":")
                                .newline();
                            emitted_any = true;
                        }
                    }
                }
            }

            // If no string found for this index, emit a comment
            if !emitted_any {
                for key in &case.keys {
                    let key_str = match key {
                        CaseKey::Int(i) => i.to_string(),
                        CaseKey::String(s) => format!("\"{}\"", s),
                        CaseKey::Enum { field_name, .. } => field_name.clone(),
                        CaseKey::Default => "default".to_string(),
                    };
                    code.start_line()
                        .add("case ")
                        .add(&key_str)
                        .add(": /* index */")
                        .newline();
                }
            }

            code.inc_indent();
            generate_region(&case.container, ctx, code);

            // Only add break if case doesn't end with return/throw/continue/break
            let needs_break = !case_ends_with_exit(&case.container, ctx);
            if needs_break {
                let is_last_case = case_idx == regular_cases.len() - 1;
                if !is_last_case || default_case.is_none() {
                    gen_break(code);
                } else {
                    gen_break(code);
                }
            }
            code.dec_indent();
        }

        if let Some(def) = default_case {
            code.start_line().add("default:").newline();
            code.inc_indent();
            generate_region(&def.container, ctx, code);
            code.dec_indent();
        }

        code.dec_indent();
        code.start_line().add("}").newline();
    } else {
        // Not a switch - fall back to normal generation
        generate_content(content, ctx, code);
    }
}

/// Generate code from a region
fn generate_region<W: CodeWriter>(region: &Region, ctx: &mut BodyGenContext, code: &mut W) {
    match region {
        Region::Sequence(contents) => {
            // Check for two-switch pattern (switch-over-string merge)
            let two_switch_info = detect_two_switch_in_sequence(contents, ctx);

            for (idx, content) in contents.iter().enumerate() {
                if let Some((first_idx, ref info)) = two_switch_info {
                    // Skip the first switch entirely (it's the hashCode switch)
                    if idx == first_idx {
                        continue;
                    }
                    // For the second switch, generate merged output
                    if idx == info.second_switch_idx {
                        generate_merged_string_switch(content, info, ctx, code);
                        continue;
                    }
                }
                generate_content(content, ctx, code);
            }
        }

        Region::If {
            condition,
            then_region,
            else_region,
        } => {
            // Emit pre-condition setup instructions (e.g., array.length for bounds)
            // These instructions define variables used in the condition but are not part
            // of the condition itself (like "length = arr.length" before "if (length == 0)")
            emit_condition_block_prelude(condition, ctx, code);

            // Check if this if/else can be converted to a ternary expression
            if let Some(else_reg) = else_region {
                // Pattern 1: Assignment in both branches -> dest = cond ? a : b
                if let Some(ternary) = detect_ternary_pattern(then_region, else_reg, ctx) {
                    let condition_str = generate_condition(condition, ctx);
                    emit_ternary_assignment(&ternary, &condition_str, ctx, code);
                    return;
                }

                // Pattern 2: Return in both branches -> return cond ? a : b
                // Only for non-void return methods
                if !matches!(ctx.return_type, ArgType::Void) {
                    if let Some(return_ternary) = detect_return_ternary_pattern(then_region, else_reg, ctx) {
                        let condition_str = generate_condition(condition, ctx);
                        emit_return_ternary(&return_ternary, &condition_str, &ctx.return_type, code);
                        return;
                    }
                }
            } else {
                // Pattern 3: Single-branch assignment (constructor pattern) -> r = cond ? a : r
                // Only for constructors to help move super() calls to top
                if ctx.is_constructor {
                    if let Some(single_ternary) = detect_single_branch_ternary_pattern(then_region, ctx, true) {
                        let condition_str = generate_condition(condition, ctx);
                        emit_single_branch_ternary(&single_ternary, &condition_str, ctx, code);
                        return;
                    }
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
            details,
            ..
        } => {
            // Use loop details if available (JADX parity: ForLoop/ForEach distinction)
            let _loop_details = details;

            // Emit pre-condition setup instructions (e.g., array.length() for loop bounds)
            // These instructions define variables used in the condition but are not part
            // of the condition itself (like "i2 = jSONArray.length()" before "i < i2")
            if let Some(cond) = condition {
                emit_condition_block_prelude(cond, ctx, code);
            }

            // Generate condition expression if available
            let condition_str = match condition {
                Some(cond) => generate_condition(cond, ctx),
                None => "true".to_string(),
            };

            match kind {
                LoopKind::While | LoopKind::For => {
                    // Try traditional for loop first (for indexed for-loops like for(int i=0; i<N; i++))
                    let header_block_id = match condition {
                        Some(Condition::Simple { block, .. }) => Some(block),
                        _ => None,
                    };

                    if let Some(header_id) = header_block_id {
                        if let Some(for_pattern) = ctx.loop_patterns.for_loops.iter().find(|p| p.header == *header_id) {
                            // Generate traditional for loop: for (int i = 0; i < N; i++)
                            let loop_reg = dexterity_ir::instructions::RegisterArg::with_ssa(for_pattern.loop_var.0, for_pattern.loop_var.1);
                            let var_name = ctx.expr_gen.get_var_name(&loop_reg);

                            // Initialize: "int i = 0"
                            let init_str = format!("int {} = 0", var_name);

                            // Condition: already have it
                            let cond_str = condition_str.clone();

                            // Update: "i++"
                            let update_str = format!("{}++", var_name);

                            gen_for_header(&init_str, &cond_str, &update_str, code);
                            generate_region(body, ctx, code);
                            gen_close_block(code);
                            return;
                        }
                    }

                    // Array for-each detection: detect pattern for (int i = 0; i < array.length; i++) { item = array[i]; }
                    // Try this before iterator detection as it's more specific
                    if let Some(cond) = condition {
                        if let Some(arr_foreach) = detect_array_foreach_pattern(cond, body, ctx) {
                            // Generate array for-each: for (Type item : array) {
                            code.start_line()
                                .add("for (")
                                .add(&arr_foreach.item_type)
                                .add(" ")
                                .add(&arr_foreach.item_var)
                                .add(" : ")
                                .add(&arr_foreach.array_expr)
                                .add(") {")
                                .newline();
                            code.inc_indent();

                            // Mark instructions to skip: AGET and increment (i++)
                            let mut skip_set_aget: HashSet<usize> = HashSet::new();
                            skip_set_aget.insert(arr_foreach.aget_insn_idx);
                            ctx.skip_foreach_insns.insert(arr_foreach.aget_block, skip_set_aget);

                            let mut skip_set_incr: HashSet<usize> = HashSet::new();
                            skip_set_incr.insert(arr_foreach.incr_insn_idx);
                            // If AGET and increment are in same block, merge skip sets
                            if arr_foreach.aget_block == arr_foreach.incr_block {
                                if let Some(existing) = ctx.skip_foreach_insns.get_mut(&arr_foreach.incr_block) {
                                    existing.insert(arr_foreach.incr_insn_idx);
                                }
                            } else {
                                ctx.skip_foreach_insns.insert(arr_foreach.incr_block, skip_set_incr);
                            }

                            generate_region(body, ctx, code);

                            // Clean up skip sets
                            ctx.skip_foreach_insns.remove(&arr_foreach.aget_block);
                            ctx.skip_foreach_insns.remove(&arr_foreach.incr_block);

                            gen_close_block(code);
                            return;
                        }
                    }

                    // Iterator for-each detection: detect iterator patterns (hasNext/next) and generate
                    // enhanced for-loop syntax. Region builder now ensures all body blocks are
                    // included, fixing the empty body issue.
                    if let Some(cond) = condition {
                        if let Some((iter_reg, iter_str)) = detect_iterator_pattern(cond, ctx) {
                            if let Some(foreach_info) = detect_next_call(body, iter_reg, ctx) {
                                // Only generate for-each if body has meaningful content after skipping
                                // Also check that body has multiple blocks or nested regions (not just the iterator block)
                                if body_has_meaningful_content(body, &foreach_info, ctx)
                                    && body_has_meaningful_structure(body, foreach_info.skip_block, ctx) {
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

                                    // Mark iterator instructions to skip in body
                                    let skip_set: HashSet<usize> = (foreach_info.skip_start
                                        ..foreach_info.skip_start + foreach_info.skip_count)
                                        .collect();
                                    ctx.skip_foreach_insns.insert(foreach_info.skip_block, skip_set);

                                    generate_region(body, ctx, code);

                                    // Clean up skip set after generating body
                                    ctx.skip_foreach_insns.remove(&foreach_info.skip_block);

                                    gen_close_block(code);
                                    return;
                                }
                                // Fall through to while loop if body would be empty
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
                    // LoopKind::ForEach is set by SSA-level pattern analysis
                    // Use details if available for direct for-each generation
                    let mut generated_foreach = false;

                    if let Some(loop_details) = details {
                        if let Some(foreach_info) = &loop_details.foreach_info {
                            if let dexterity_ir::regions::IterableSource::Array { array_reg, index_reg: Some(_idx_reg) } = &foreach_info.iterable {
                                // Get element variable name and type from register
                                if let Some(elem_reg) = &foreach_info.elem_var_reg {
                                    let elem_var_reg = dexterity_ir::instructions::RegisterArg::with_ssa(elem_reg.0, elem_reg.1);
                                    let elem_var_name = ctx.expr_gen.get_var_name(&elem_var_reg);

                                    // Get array expression and element type
                                    let arr_reg = dexterity_ir::instructions::RegisterArg::with_ssa(array_reg.0, array_reg.1);
                                    let array_expr = ctx.expr_gen.get_var_name(&arr_reg);

                                    // Try to get element type from array type
                                    let elem_type = ctx.type_info.as_ref()
                                        .and_then(|ti| ti.types.get(&(elem_reg.0, elem_reg.1)))
                                        .map(|t| type_to_string_with_imports(t, ctx.imports.as_ref()))
                                        .unwrap_or_else(|| "Object".to_string());

                                    // Generate for-each: for (Type elem : array)
                                    code.start_line()
                                        .add("for (")
                                        .add(&elem_type)
                                        .add(" ")
                                        .add(&elem_var_name)
                                        .add(" : ")
                                        .add(&array_expr)
                                        .add(") {")
                                        .newline();
                                    code.inc_indent();

                                    generate_region(body, ctx, code);

                                    gen_close_block(code);
                                    generated_foreach = true;
                                }
                            }
                        }
                    }

                    // Fall back to while loop if foreach generation didn't work
                    if !generated_foreach {
                        gen_while_header(&condition_str, code);
                        generate_region(body, ctx, code);
                        gen_close_block(code);
                    }
                }
            }
        }

        Region::Switch { header_block, cases } => {
            use dexterity_ir::regions::CaseKey;

            // Try to detect switch-over-string pattern
            let string_switch_info = detect_switch_over_string(*header_block, cases, ctx);

            // Separate default case from regular cases
            let default_case = cases.iter().find(|c| c.is_default());
            let regular_cases: Vec<_> = cases.iter().filter(|c| !c.is_default()).collect();

            // Emit non-switch instructions from header block (setup instructions)
            // For switch-over-string, skip hashCode() and related setup instructions
            if let Some(block) = ctx.blocks.get(header_block) {
                let instructions: Vec<_> = block.instructions.clone();
                let num_insns = instructions.len();
                for (i, insn) in instructions.iter().enumerate() {
                    // Skip switch instructions
                    if matches!(insn.insn_type, InsnType::PackedSwitch { .. } | InsnType::SparseSwitch { .. }) {
                        continue;
                    }
                    // Skip instructions marked with DONT_GENERATE
                    if insn.has_flag(AFlag::DontGenerate) {
                        continue;
                    }
                    // Skip control flow instructions
                    if is_control_flow(&insn.insn_type) {
                        continue;
                    }
                    // For switch-over-string, skip hashCode() invoke and its MoveResult
                    if string_switch_info.is_some() {
                        if matches!(insn.insn_type, InsnType::Invoke { kind: InvokeKind::Virtual, .. }) {
                            // Check if this is a 1-arg invoke followed by MoveResult (hashCode pattern)
                            if let InsnType::Invoke { args, .. } = &insn.insn_type {
                                if args.len() == 1 && i + 1 < num_insns {
                                    if matches!(instructions[i + 1].insn_type, InsnType::MoveResult { .. }) {
                                        continue;
                                    }
                                }
                            }
                        }
                        if matches!(insn.insn_type, InsnType::MoveResult { .. }) {
                            // Skip MoveResult that follows hashCode
                            if i > 0 {
                                if let InsnType::Invoke { args, kind: InvokeKind::Virtual, .. } = &instructions[i - 1].insn_type {
                                    if args.len() == 1 {
                                        continue;
                                    }
                                }
                            }
                        }
                    }
                    // Peek at next instruction for MoveResult handling
                    let next_is_move_result = if i + 1 < num_insns {
                        matches!(instructions[i + 1].insn_type, InsnType::MoveResult { .. })
                    } else {
                        false
                    };
                    generate_insn_with_lookahead(&insn, next_is_move_result, ctx, code);
                }
            }

            // Determine switch value - use string var for switch-over-string
            let switch_value = if let Some(ref info) = string_switch_info {
                info.string_expr.clone()
            } else {
                ctx.blocks.get(header_block)
                    .and_then(|block| block.instructions.iter().rev().find_map(|insn| {
                        match &insn.insn_type {
                            InsnType::PackedSwitch { value, .. } |
                            InsnType::SparseSwitch { value, .. } => Some(ctx.expr_gen.gen_arg(value)),
                            _ => None,
                        }
                    }))
                    .unwrap_or_else(|| "/* value */".to_string())
            };

            code.start_line()
                .add("switch (")
                .add(&switch_value)
                .add(") {")
                .newline();
            code.inc_indent();

            for (case_idx, case) in regular_cases.iter().enumerate() {
                // For switch-over-string, emit string literal case labels
                if let Some(ref info) = string_switch_info {
                    let mut emitted_any = false;
                    for key in &case.keys {
                        if let CaseKey::Int(int_key) = key {
                            if let Some(strings) = info.case_strings.get(int_key) {
                                for s in strings {
                                    code.start_line()
                                        .add("case ")
                                        .add(&crate::type_gen::escape_string(s))
                                        .add(":")
                                        .newline();
                                    emitted_any = true;
                                }
                            }
                        }
                    }
                    // If no string found for this key, fall back to integer
                    if !emitted_any {
                        for key in &case.keys {
                            code.start_line()
                                .add("case ")
                                .add(&key.to_string())
                                .add(": /* hashCode */")
                                .newline();
                        }
                    }
                } else {
                    // Normal integer switch
                    for key in &case.keys {
                        code.start_line()
                            .add("case ")
                            .add(&key.to_string())
                            .add(":")
                            .newline();
                    }
                }
                code.inc_indent();
                generate_region(&case.container, ctx, code);

                // Only add break if case doesn't end with return/throw/continue/break
                let needs_break = !case_ends_with_exit(&case.container, ctx);
                if needs_break {
                    // Check if this is the last case before default - if so, might be fallthrough
                    let is_last_case = case_idx == regular_cases.len() - 1;
                    if !is_last_case || default_case.is_none() {
                        gen_break(code);
                    } else {
                        // Last case before default - add break
                        gen_break(code);
                    }
                }
                code.dec_indent();
            }

            if let Some(def) = default_case {
                code.start_line().add("default:").newline();
                code.inc_indent();
                generate_region(&def.container, ctx, code);
                // Don't add break after default - it's the last case
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
                // Track both the exception variable name and its type for proper declaration tracking
                let (exc_var, exc_type) = if handler.catch_all {
                    // Catch-all handler
                    let exc_var = generate_exception_var_name("Throwable", i);
                    code.start_line()
                        .add("} catch (Throwable ")
                        .add(&exc_var)
                        .add(") {")
                        .newline();
                    (exc_var, ArgType::Object("java/lang/Throwable".to_string()))
                } else if handler.is_multi_catch() {
                    // Multi-catch: catch (Type1 | Type2 | Type3 e)
                    // Convert internal format (java/io/IOException) to Java format (java.io.IOException)
                    let exc_types: Vec<String> = handler.exception_types.iter()
                        .map(|t| object_to_java_name(t))
                        .collect();
                    let exc_types_str = exc_types.join(" | ");
                    let first_type = exc_types.first()
                        .map(|s| s.as_str())
                        .unwrap_or("Exception");
                    let exc_var = generate_exception_var_name(first_type, i);
                    // Use first exception type for tracking (they're all compatible via multi-catch)
                    let first_internal = handler.exception_types.first()
                        .cloned()
                        .unwrap_or_else(|| "java/lang/Exception".to_string());
                    code.start_line()
                        .add("} catch (")
                        .add(&exc_types_str)
                        .add(" ")
                        .add(&exc_var)
                        .add(") {")
                        .newline();
                    (exc_var, ArgType::Object(first_internal))
                } else {
                    // Single exception type
                    // Convert internal format (java/io/IOException) to Java format (java.io.IOException)
                    let exc_type_internal = handler.exception_type()
                        .unwrap_or("java/lang/Exception");
                    let exc_type = object_to_java_name(exc_type_internal);
                    let exc_var = generate_exception_var_name(&exc_type, i);
                    code.start_line()
                        .add("} catch (")
                        .add(&exc_type)
                        .add(" ")
                        .add(&exc_var)
                        .add(") {")
                        .newline();
                    (exc_var, ArgType::Object(exc_type_internal.to_string()))
                };

                // Mark exception variable as declared - prevents redeclaration inside catch block
                ctx.mark_name_declared(&exc_var, &exc_type);

                // Enter exception handler context for proper variable handling
                if let Some(entry_block) = get_handler_entry_block(&handler.region) {
                    ctx.enter_exception_handler(entry_block);
                }

                code.inc_indent();
                generate_region(&handler.region, ctx, code);
                code.dec_indent();

                // Exit exception handler context
                ctx.exit_exception_handler();
            }

            if let Some(fin) = finally {
                code.start_line().add("} finally {").newline();
                code.inc_indent();
                generate_region(fin, ctx, code);
                code.dec_indent();
            }

            code.start_line().add("}").newline();
        }

        Region::Synchronized { enter_block, body, .. } => {
            // Emit non-monitor instructions from enter block (setup instructions)
            if let Some(block) = ctx.blocks.get(enter_block) {
                let instructions: Vec<_> = block.instructions.clone();
                let num_insns = instructions.len();
                for (i, insn) in instructions.iter().enumerate() {
                    // Skip monitor instructions
                    if matches!(insn.insn_type, InsnType::MonitorEnter { .. } | InsnType::MonitorExit { .. }) {
                        continue;
                    }
                    // Skip instructions marked with DONT_GENERATE
                    if insn.has_flag(AFlag::DontGenerate) {
                        continue;
                    }
                    // Skip control flow instructions
                    if is_control_flow(&insn.insn_type) {
                        continue;
                    }
                    // Peek at next instruction for MoveResult handling
                    let next_is_move_result = if i + 1 < num_insns {
                        matches!(instructions[i + 1].insn_type, InsnType::MoveResult { .. })
                    } else {
                        false
                    };
                    generate_insn_with_lookahead(&insn, next_is_move_result, ctx, code);
                }
            }

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

        Region::Break { label } => {
            code.start_line();
            if let Some(lbl) = label {
                code.add("break ").add(lbl).add(";");
            } else {
                code.add("break;");
            }
            code.newline();
        }

        Region::Continue { label } => {
            code.start_line();
            if let Some(lbl) = label {
                code.add("continue ").add(lbl).add(";");
            } else {
                code.add("continue;");
            }
            code.newline();
        }

        Region::TernaryAssignment { .. } => {
            // TernaryAssignment regions are for Phase 2 implementation.
            // Currently, ternary assignments are detected and emitted at If region level.
            // This placeholder codegen is reached only if a TernaryAssignment region was created,
            // which doesn't happen in Phase 1. Phase 2 will implement region-level transformation.
            code.start_line()
                .add("/* TernaryAssignment region - phase 2 implementation */")
                .newline();
        }

        Region::TernaryReturn { .. } => {
            // TernaryReturn regions are for Phase 2 implementation.
            // Currently, ternary returns are detected and emitted at If region level.
            // This placeholder codegen is reached only if a TernaryReturn region was created,
            // which doesn't happen in Phase 1. Phase 2 will implement region-level transformation.
            code.start_line()
                .add("/* TernaryReturn region - phase 2 implementation */")
                .newline();
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

    // Check if this block has instructions to skip (for-each iterator calls)
    let skip_insns = ctx.skip_foreach_insns.get(&block.id).cloned();

    // Iterate directly without Arc/Mutex overhead
    for (i, insn) in block.instructions.iter().enumerate() {
        // Skip instructions marked for for-each suppression
        if let Some(ref skip_set) = skip_insns {
            if skip_set.contains(&i) {
                continue;
            }
        }

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

        // Peek at next instruction without overhead
        let next_is_move_result = if i + 1 < block.instructions.len() {
            let next = &block.instructions[i + 1];
            matches!(next.insn_type, InsnType::MoveResult { .. })
        } else {
            false
        };

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

/// Get the entry block ID from a region (first block in the region)
/// Used to identify exception handler entry points
fn get_handler_entry_block(region: &Region) -> Option<u32> {
    match region {
        Region::Sequence(contents) => {
            contents.iter().find_map(|c| match c {
                RegionContent::Block(id) => Some(*id),
                RegionContent::Region(r) => get_handler_entry_block(r),
            })
        }
        Region::If { condition, .. } => condition.get_blocks().first().copied(),
        Region::Loop { header_block, .. } => *header_block,
        Region::Switch { header_block, .. } => Some(*header_block),
        Region::TryCatch { try_region, .. } => get_handler_entry_block(try_region),
        Region::Synchronized { enter_block, .. } => Some(*enter_block),
        Region::Break { .. } | Region::Continue { .. } => None,
        Region::TernaryAssignment { .. } | Region::TernaryReturn { .. } => None,
    }
}

/// Emit pre-condition instructions from a condition block
/// These are the setup instructions that define variables used in the condition
/// (e.g., array.length() call before `i < length` comparison)
/// Excludes the final If instruction which is handled by generate_condition
fn emit_condition_block_prelude<W: CodeWriter>(condition: &Condition, ctx: &mut BodyGenContext, code: &mut W) {
    // Collect all block IDs from the condition
    let block_ids = condition.get_blocks();

    for block_id in block_ids {
        // Clone the instructions to avoid borrow conflict with ctx
        let instructions: Vec<_> = match ctx.blocks.get(&block_id) {
            Some(block) => block.instructions.clone(),
            None => continue,
        };

        let num_insns = instructions.len();
        for (i, insn) in instructions.iter().enumerate() {
            // Skip control flow instructions (If, Goto, Switch)
            if is_control_flow(&insn.insn_type) {
                continue;
            }

            // Skip instructions marked with DONT_GENERATE
            if insn.has_flag(AFlag::DontGenerate) {
                continue;
            }

            // Peek at next instruction for MoveResult handling
            let next_is_move_result = if i + 1 < num_insns {
                matches!(instructions[i + 1].insn_type, InsnType::MoveResult { .. })
            } else {
                false
            };

            // Generate the instruction
            generate_insn_with_lookahead(&insn, next_is_move_result, ctx, code);
        }
    }
}

/// Check if a case region ends with an exit instruction (return, throw, break, continue)
/// If so, we don't need to add a break statement after it
fn case_ends_with_exit(region: &Region, ctx: &BodyGenContext) -> bool {
    match region {
        Region::Sequence(contents) if !contents.is_empty() => {
            // Check the last element
            match contents.last() {
                Some(RegionContent::Block(block_id)) => {
                    if let Some(block) = ctx.blocks.get(block_id) {
                        if let Some(last) = block.instructions.last() {
                            return matches!(
                                last.insn_type,
                                InsnType::Return { .. } | InsnType::Throw { .. }
                            );
                        }
                    }
                    false
                }
                Some(RegionContent::Region(inner)) => case_ends_with_exit(inner, ctx),
                None => false,
            }
        }
        Region::If { then_region, else_region, .. } => {
            // If both branches exit, the if exits
            if let Some(else_reg) = else_region {
                case_ends_with_exit(then_region, ctx) && case_ends_with_exit(else_reg, ctx)
            } else {
                false
            }
        }
        Region::Loop { .. } => {
            // Loops might exit via break but we can't easily detect it
            // Conservatively return false
            false
        }
        Region::TryCatch { try_region, handlers, .. } => {
            // If try and all handlers exit, the try-catch exits
            if !case_ends_with_exit(try_region, ctx) {
                return false;
            }
            handlers.iter().all(|h| case_ends_with_exit(&h.region, ctx))
        }
        Region::Break { .. } | Region::Continue { .. } => {
            // Break and continue are exit statements
            true
        }
        _ => false,
    }
}

/// Generate an anonymous class body inline
/// Returns the full expression: `new ParentType(args) { methods... }`
fn generate_anonymous_class_inline<W: CodeWriter>(
    class: &dexterity_ir::ClassData,
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
        crate::type_gen::get_simple_name_from_argtype(&class.interfaces[0])
    } else if let Some(ref superclass) = class.superclass {
        get_simple_name(superclass).to_string()
    } else {
        "Object".to_string()
    };

    // Start the anonymous class: new ParentType(args) {
    code.add("new ").add(&parent_type).add("(").add(constructor_args).add(") {");

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

// =============================================================================
// Varargs Expansion Support
// =============================================================================

/// Check if an inlined expression is a filled array literal that can be expanded for varargs.
/// Returns the inner arguments if expandable, None otherwise.
///
/// Matches patterns like: `new String[] { "a", "b", "c" }`
/// Does NOT match: variable references, method calls returning arrays, etc.
fn extract_vararg_array_elements(inlined_expr: &str) -> Option<Vec<&str>> {
    // Pattern: "new TypeName[] { elem1, elem2, ... }"
    // Must start with "new " to ensure it's a literal
    if !inlined_expr.starts_with("new ") {
        return None;
    }

    // Find the "[] {" pattern that marks array literal start
    let array_start = inlined_expr.find("[] { ")?;
    let content_start = array_start + 5; // Skip "[] { "

    // Find the closing " }"
    let content_end = inlined_expr.rfind(" }")?;

    if content_start > content_end {
        // Empty array: new Type[] { } - valid for varargs (zero args)
        return Some(Vec::new());
    }

    // Extract the content between { and }
    let content = &inlined_expr[content_start..content_end];

    if content.is_empty() {
        return Some(Vec::new());
    }

    // Split by ", " but need to handle nested structures like strings with commas
    // For now, use a simple approach that handles most cases:
    // - Split by ", " that are not inside strings
    let elements = split_array_elements(content);
    Some(elements)
}

/// Split array elements, handling quoted strings that might contain commas
fn split_array_elements(content: &str) -> Vec<&str> {
    let mut elements = Vec::new();
    let mut start = 0;
    let mut in_string = false;
    let mut escape_next = false;

    let bytes = content.as_bytes();
    let mut i = 0;

    while i < bytes.len() {
        let c = bytes[i] as char;

        if escape_next {
            escape_next = false;
            i += 1;
            continue;
        }

        if c == '\\' {
            escape_next = true;
            i += 1;
            continue;
        }

        if c == '"' {
            in_string = !in_string;
            i += 1;
            continue;
        }

        // Check for ", " separator outside of strings
        if !in_string && c == ',' && i + 1 < bytes.len() && bytes[i + 1] == b' ' {
            let elem = &content[start..i];
            if !elem.is_empty() {
                elements.push(elem.trim());
            }
            start = i + 2; // Skip ", "
            i += 2;
            continue;
        }

        i += 1;
    }

    // Add the last element
    if start < content.len() {
        let elem = &content[start..];
        if !elem.is_empty() {
            elements.push(elem.trim());
        }
    }

    elements
}

/// Try to expand a pending vararg array from NewArray + ArrayPut pattern.
/// Returns the expanded argument string or None if not expandable.
fn try_expand_pending_vararg_array(arg: &InsnArg, ctx: &mut BodyGenContext) -> Option<String> {
    if let InsnArg::Register(reg) = arg {
        let key = (reg.reg_num, reg.ssa_version);

        // Need to check then remove to avoid borrow issues
        let should_expand = ctx.pending_vararg_arrays.get(&key)
            .map(|p| !p.invalidated && p.filled_count == p.size)
            .unwrap_or(false);

        if should_expand {
            if let Some(pending) = ctx.pending_vararg_arrays.remove(&key) {
                // All elements filled - expand as varargs
                let elements: Vec<String> = pending.elements
                    .into_iter()
                    .map(|opt| opt.unwrap_or_else(|| "null".to_string()))
                    .collect();

                return Some(elements.join(", "));
            }
        }
    }
    None
}

/// Try to expand a vararg argument from an inlined filled array or pending array.
/// Returns the expanded argument string or None if not expandable.
fn try_expand_vararg(arg: &InsnArg, ctx: &mut BodyGenContext) -> Option<String> {
    // Try 1: FilledNewArray pattern (inlined expression string matching)
    if let InsnArg::Register(reg) = arg {
        // Peek at inlined expression without consuming it
        if let Some(inlined) = ctx.peek_inline_expr(reg.reg_num, reg.ssa_version) {
            if let Some(elements) = extract_vararg_array_elements(inlined) {
                // Convert to owned strings before consuming to avoid borrow conflict
                let result = elements.iter().map(|s| s.to_string()).collect::<Vec<_>>().join(", ");

                // Consume the inlined expression since we're using it
                ctx.take_inline_expr(reg.reg_num, reg.ssa_version);

                return Some(result);
            }
        }
    }

    // Try 2: NewArray + ArrayPut pattern (pending array tracking)
    try_expand_pending_vararg_array(arg, ctx)
}

/// Heuristic: should we expand varargs when method definition is unknown?
///
/// Checks if:
/// 1. Last parameter type is an array
/// 2. The argument is either:
///    a. A filled array literal (new Type[] { ... }), OR
///    b. A pending vararg array built via NewArray + ArrayPut
fn should_heuristic_expand_varargs(
    param_types: &[ArgType],
    args: &[&InsnArg],
    ctx: &BodyGenContext,
) -> bool {
    // Must have at least one parameter and argument
    if param_types.is_empty() || args.is_empty() {
        return false;
    }

    // Last parameter must be an array type
    let last_param = param_types.last().unwrap();
    if !matches!(last_param, ArgType::Array(_)) {
        return false;
    }

    // Last argument must be expandable as varargs
    let last_arg = args.last().unwrap();
    if let InsnArg::Register(reg) = last_arg {
        // Check 1: inlined filled array literal (FilledNewArray pattern)
        if let Some(inlined) = ctx.peek_inline_expr(reg.reg_num, reg.ssa_version) {
            if extract_vararg_array_elements(inlined).is_some() {
                return true;
            }
        }

        // Check 2: pending vararg array (NewArray + ArrayPut pattern)
        let key = (reg.reg_num, reg.ssa_version);
        if let Some(pending) = ctx.pending_vararg_arrays.get(&key) {
            if !pending.invalidated && pending.filled_count == pending.size {
                return true;
            }
        }
    }

    false
}

/// Write method arguments with varargs expansion support
///
/// When the method is varargs and the last argument is an inlined filled array,
/// expands `foo(new String[]{"a", "b"})` to `foo("a", "b")`
fn write_typed_args_with_varargs<W: CodeWriter>(
    args: &[InsnArg],
    param_types: &[ArgType],
    skip_count: usize,
    is_varargs: Option<bool>,
    ctx: &mut BodyGenContext,
    code: &mut W,
) {
    let args_to_process: Vec<_> = args.iter().skip(skip_count).collect();
    let arg_count = args_to_process.len();

    if arg_count == 0 {
        return;
    }

    // Limit arguments to method parameter count when we have type info
    // This filters out Kotlin default parameter markers (extra args beyond declared params)
    // Only apply when: param_types is non-empty AND not varargs AND args exceed params
    let effective_arg_count = if !param_types.is_empty()
        && !is_varargs.unwrap_or(false)
        && arg_count > param_types.len()
    {
        param_types.len()
    } else {
        arg_count
    };

    // Check if we should attempt varargs expansion:
    // 1. Method is known to be varargs, OR
    // 2. Method varargs status unknown but heuristic suggests expansion
    let should_try_varargs = is_varargs.unwrap_or(false)
        || (is_varargs.is_none() && should_heuristic_expand_varargs(param_types, &args_to_process, ctx));

    for (i, a) in args_to_process.iter().take(effective_arg_count).enumerate() {
        if i > 0 {
            code.add(", ");
        }

        let is_last_arg = i == effective_arg_count - 1;

        // Try varargs expansion only for the last argument
        if is_last_arg && should_try_varargs {
            if let Some(expanded) = try_expand_vararg(a, ctx) {
                // Handle empty varargs (expanded will be empty string)
                if !expanded.is_empty() {
                    code.add(&expanded);
                }
                // If empty, we don't add anything (no trailing comma needed)
                // but we need to remove the extra ", " we added before this arg
                // Actually, the logic handles this correctly - if expanded is empty,
                // we just don't add anything, which is correct for empty varargs
                continue;
            }
        }

        // Normal argument handling
        if let Some(param_type) = param_types.get(i) {
            ctx.write_arg_inline_typed(code, *a, param_type);
        } else {
            ctx.write_arg_inline(code, *a);
        }
    }
}

/// Generate code for invoke-polymorphic (MethodHandle/VarHandle API)
/// Format: receiver.invoke(args...)
/// Note: proto_idx contains return type info but we don't have proto table access yet
/// The cast will be added when MoveResult processes the return value
#[allow(unused_variables)]
fn write_polymorphic_invoke<W: CodeWriter>(
    args: &[InsnArg],
    proto_idx: Option<u32>,
    ctx: &mut BodyGenContext,
    code: &mut W,
) {
    // Write receiver (first arg) - should be the MethodHandle/VarHandle
    if let Some(receiver) = args.first() {
        ctx.write_arg_inline(code, receiver);
    }

    // Write .invoke(remaining args)
    code.add(".invoke(");
    for (i, arg) in args.iter().skip(1).enumerate() {
        if i > 0 {
            code.add(", ");
        }
        ctx.write_arg_inline(code, arg);
    }
    code.add(")");
}

/// Generate an invoke expression with inlined arguments
/// OPTIMIZED: Write invoke expression directly to CodeWriter - avoids String allocation
/// This is the hot path for all method calls
fn write_invoke_with_inlining<W: CodeWriter>(
    kind: &InvokeKind,
    method_idx: u32,
    args: &[InsnArg],
    proto_idx: Option<u32>,
    ctx: &mut BodyGenContext,
    code: &mut W,
) {
    // Handle polymorphic invoke specially (MethodHandle/VarHandle)
    if matches!(kind, InvokeKind::Polymorphic) {
        write_polymorphic_invoke(args, proto_idx, ctx, code);
        return;
    }

    // Synthetic accessor inlining (DEC19-OPEN-004)
    // Check if this is a synthetic accessor (access$XXX) that should be inlined
    if let Some(ref dex) = ctx.expr_gen.dex_provider {
        if let Some(inline_attr) = dex.get_method_inline_attr(method_idx) {
            match inline_attr {
                MethodInlineAttr::FieldGet { field_idx, is_instance } => {
                    // Replace access$XXX(obj) with obj.field or Class.field
                    if let Some(field_info) = ctx.expr_gen.get_field_value(field_idx) {
                        if is_instance {
                            // Instance field: first arg is the object
                            if let Some(receiver) = args.first() {
                                ctx.write_arg_inline(code, receiver);
                                code.add(".");
                            }
                            code.add(&field_info.field_name);
                        } else {
                            // Static field: Class.field
                            code.add(&field_info.class_name).add(".").add(&field_info.field_name);
                        }
                        return;
                    }
                }
                MethodInlineAttr::FieldSet { field_idx, is_instance } => {
                    // Replace access$XXX(obj, value) with (obj.field = value) or (Class.field = value)
                    if let Some(field_info) = ctx.expr_gen.get_field_value(field_idx) {
                        code.add("(");
                        if is_instance {
                            // Instance field: obj.field = value
                            if let Some(receiver) = args.first() {
                                ctx.write_arg_inline(code, receiver);
                                code.add(".");
                            }
                            code.add(&field_info.field_name).add(" = ");
                            // Value is second arg for instance, first for static
                            if args.len() > 1 {
                                ctx.write_arg_inline(code, &args[1]);
                            }
                        } else {
                            // Static field: Class.field = value
                            code.add(&field_info.class_name).add(".").add(&field_info.field_name).add(" = ");
                            if let Some(value) = args.first() {
                                ctx.write_arg_inline(code, value);
                            }
                        }
                        code.add(")");
                        return;
                    }
                }
                MethodInlineAttr::MethodCall { method_idx: target_method_idx } => {
                    // Replace access$XXX(obj, args...) with direct method call
                    // Recursively call with the target method
                    // Skip first arg (it becomes receiver if instance method)
                    if let Some(target_info) = ctx.expr_gen.get_method_value(target_method_idx) {
                        // Determine if target is static (no receiver in accessor args)
                        // Synthetic accessors for instance methods include 'this' as first arg
                        let is_static = args.is_empty() ||
                            (target_info.param_types.len() == args.len());

                        if is_static {
                            // Static method call
                            code.add(&target_info.class_name).add(".").add(&sanitize_method_name(&target_info.method_name)).add("(");
                            for (i, arg) in args.iter().enumerate() {
                                if i > 0 { code.add(", "); }
                                ctx.write_arg_inline(code, arg);
                            }
                            code.add(")");
                        } else {
                            // Instance method: first arg is receiver
                            if let Some(receiver) = args.first() {
                                ctx.write_arg_inline(code, receiver);
                                code.add(".");
                            }
                            code.add(&sanitize_method_name(&target_info.method_name)).add("(");
                            for (i, arg) in args.iter().skip(1).enumerate() {
                                if i > 0 { code.add(", "); }
                                ctx.write_arg_inline(code, arg);
                            }
                            code.add(")");
                        }
                        return;
                    }
                }
                MethodInlineAttr::NotNeeded => {
                    // Fall through to normal handling
                }
            }
        }
    }

    // Get method info for proper formatting
    if let Some(info) = ctx.expr_gen.get_method_value(method_idx) {
        let skip_count = if matches!(kind, InvokeKind::Static) { 0 } else { 1 };

        // StringBuilder chain optimization: Convert StringBuilder chains to string concatenation
        // Pattern: new StringBuilder(...).append(...).append(...).toString() -> "..." + "..." + ...
        if is_stringbuilder_class(&info.class_name) {
            // First try statement-based chain tracking (for patterns like: sb.append(x); sb.append(y);)
            if let Some(InsnArg::Register(recv_reg)) = args.first() {
                let method_name = &*info.method_name;

                if method_name == "append" {
                    // Check if we're tracking this StringBuilder
                    // First check if chain exists and is valid (immutable borrow)
                    let should_track = ctx.stringbuilder_chains
                        .get(&recv_reg.reg_num)
                        .map(|c| c.valid && args.len() > 1)
                        .unwrap_or(false);

                    if should_track {
                        // Generate the arg inline first (needs mutable borrow of ctx)
                        let arg_str = ctx.gen_arg_inline(&args[1]);
                        // Now we can get mutable access to the chain
                        if let Some(chain) = ctx.stringbuilder_chains.get_mut(&recv_reg.reg_num) {
                            chain.args.push(arg_str);
                            // Mark for MoveResult to transfer chain (append returns this)
                            ctx.last_stringbuilder_reg = Some(recv_reg.reg_num);
                            // Don't emit any code - we'll emit concatenation at toString()
                            return;
                        }
                    }
                } else if method_name == "toString" {
                    // Check if we have a tracked chain for this StringBuilder
                    if let Some(chain) = ctx.stringbuilder_chains.remove(&recv_reg.reg_num) {
                        if chain.valid && !chain.args.is_empty() {
                            // Optimize consecutive string literals
                            let optimized = concat_constant_strings(&chain.args);
                            let concat_expr = optimized.join(" + ");
                            code.add(&concat_expr);
                            return;
                        }
                    }
                } else if method_name != "<init>" {
                    // Any other method on StringBuilder invalidates the chain
                    if let Some(chain) = ctx.stringbuilder_chains.get_mut(&recv_reg.reg_num) {
                        chain.valid = false;
                    }
                }
            }

            // Fall back to inlined expression chain parsing (for: new StringBuilder().append().toString())
            if let Some(concat_expr) = try_convert_stringbuilder_chain(&info.method_name, args, ctx) {
                code.add(&concat_expr);
                return;
            }
        }

        match kind {
            InvokeKind::Static => {
                // Deboxing: Check if this is a boxing method like Integer.valueOf(int)
                // If so and the argument is a constant, emit just the literal instead
                if let Some(boxing_type) = BoxingType::from_method(&info) {
                    if args.len() == 1 {
                        // Check for constant value (either direct literal or inlined constant expression)
                        if let Some(value) = ctx.get_constant_int_value(&args[0]) {
                            // Deboxing succeeds - write the literal directly
                            boxing_type.write_literal(code, value);
                            // If it was an inlined register, consume the inlined expression
                            if let InsnArg::Register(reg) = &args[0] {
                                ctx.take_inline_expr(reg.reg_num, reg.ssa_version);
                            }
                            return;
                        }
                    }
                }

                // Normal static method call with type-aware argument formatting
                code.add(&info.class_name).add(".").add(&sanitize_method_name(&info.method_name)).add("(");
                write_typed_args_with_varargs(args, &info.param_types, skip_count, info.is_varargs, ctx, code);
                code.add(")");
            }
            InvokeKind::Virtual | InvokeKind::Interface | InvokeKind::Direct => {
                if &*info.method_name == "<init>" {
                    // Check receiver - determine if it's "this" by variable name
                    let is_this = if let Some(InsnArg::Register(reg)) = args.first() {
                        ctx.expr_gen.get_var_name(reg) == "this"
                    } else {
                        false
                    };

                    if is_this {
                        // Constructor call on 'this' - could be super() or this()
                        // Compare target class with current class to determine which
                        let is_same_class = ctx.current_class_type.as_ref()
                            .map(|current| current.as_str() == &*info.class_type)
                            .unwrap_or(false);

                        if is_same_class {
                            // Same class → this() constructor chaining
                            code.add("this(");
                        } else {
                            // Different class → super() call
                            code.add("super(");
                        }
                    } else {
                        code.add("new ").add(&info.class_name).add("(");
                    }
                } else {
                    // For instance methods, check if receiver is 'this' - if so, omit it
                    // Java doesn't require explicit 'this.' prefix for instance method calls
                    let is_this_receiver = if let Some(InsnArg::Register(reg)) = args.first() {
                        ctx.expr_gen.get_var_name(reg) == "this"
                    } else {
                        false
                    };

                    if !is_this_receiver {
                        if let Some(receiver) = args.first() {
                            ctx.write_arg_inline(code, receiver);
                            code.add(".");
                        }
                    }
                    code.add(&sanitize_method_name(&info.method_name)).add("(");
                }
                // Use type-aware argument formatting with varargs expansion
                write_typed_args_with_varargs(args, &info.param_types, skip_count, info.is_varargs, ctx, code);
                code.add(")");
            }
            InvokeKind::Super => {
                if &*info.method_name == "<init>" {
                    code.add("super(");
                } else {
                    code.add("super.").add(&sanitize_method_name(&info.method_name)).add("(");
                }
                // Use type-aware argument formatting with varargs expansion
                write_typed_args_with_varargs(args, &info.param_types, skip_count, info.is_varargs, ctx, code);
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

/// Helper writer that ignores formatting and writes to a single line string
struct RawStringWriter {
    buf: String,
}

impl RawStringWriter {
    fn with_capacity(capacity: usize) -> Self {
        Self { buf: String::with_capacity(capacity) }
    }
}

impl CodeWriter for RawStringWriter {
    fn start_line(&mut self) -> &mut Self { self }
    fn add(&mut self, s: &str) -> &mut Self {
        self.buf.push_str(s);
        self
    }
    fn newline(&mut self) -> &mut Self { self }
    fn inc_indent(&mut self) {}
    fn dec_indent(&mut self) {}
    fn indent(&self) -> u32 { 0 }
    fn finish(self) -> String { self.buf }
}

fn gen_invoke_with_inlining(
    kind: &InvokeKind,
    method_idx: u32,
    args: &[InsnArg],
    proto_idx: Option<u32>,
    ctx: &mut BodyGenContext,
) -> String {
    // OPTIMIZED: Use RawStringWriter to write directly to string buffer
    // This avoids creating intermediate strings for every argument
    let mut writer = RawStringWriter::with_capacity(50 + args.len() * 10);
    write_invoke_with_inlining(kind, method_idx, args, proto_idx, ctx, &mut writer);
    writer.finish()
}

/// Generate code for an instruction with lookahead information
fn generate_insn_with_lookahead<W: CodeWriter>(
    insn: &InsnNode,
    next_is_move_result: bool,
    ctx: &mut BodyGenContext,
    code: &mut W,
) -> bool {
    // Emit source line comment if changed (only when add_debug_lines is enabled)
    if ctx.add_debug_lines {
        if let Some(line) = insn.source_line {
            if ctx.last_source_line != Some(line) {
                code.start_line().add("// .line ").add(&line.to_string()).newline();
                ctx.last_source_line = Some(line);
            }
        }
    }

    // Special handling for Invoke: store expression if MoveResult follows
    if let InsnType::Invoke { kind, method_idx, args, proto_idx } = &insn.insn_type {
        // Check if this is an <init> call on a pending new-instance
        if matches!(kind, InvokeKind::Direct) {
            // Get method info to check if this is <init>
            if let Some(method_info) = ctx.expr_gen.get_method_value(*method_idx) {
                if &*method_info.method_name == "<init>" {
                    // Get the receiver register (first argument for non-static)
                    if let Some(InsnArg::Register(recv_reg)) = args.first() {
                        // Check if this register has a pending new-instance
                        if let Some(type_idx) = ctx.pending_new_instances.remove(&recv_reg.reg_num) {
                            // Get the type name and descriptor
                            let type_name = ctx.expr_gen.get_type_value(type_idx)
                                .unwrap_or_else(|| format!("Type#{}", type_idx));

                            // Check if this is StringBuilder/StringBuffer for chain optimization
                            if is_stringbuilder_class(&type_name) {
                                // Start tracking the chain with constructor arg (if any)
                                let initial_arg = if args.len() > 1 {
                                    // Constructor has an argument (could be String or other type)
                                    ctx.gen_arg_inline(&args[1])
                                } else {
                                    // Empty constructor - start with empty string
                                    "\"\"".to_string()
                                };
                                ctx.stringbuilder_chains.insert(recv_reg.reg_num, StringBuilderChain {
                                    args: vec![initial_arg],
                                    valid: true,
                                });
                                // Don't emit code - we'll emit concatenation at toString()
                                return true;
                            }

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
                                    // Also check if name is declared (avoid same-name redeclaration)
                                    let needs_decl = !ctx.is_declared(reg, version)
                                        && !ctx.is_parameter(reg, version)
                                        && !ctx.is_name_declared(&var_name);
                                    let imports = ctx.imports.clone();
                                    let dex = ctx.expr_gen.dex_provider.clone();

                                    // Take the class out temporarily to avoid borrow conflict
                                    let anon_class = ctx.anonymous_classes.remove(anon_class_key.as_ref().unwrap()).unwrap();

                                    // Extract declaration type (both for display and tracking)
                                    let (decl_type_str, decl_type) = if !anon_class.interfaces.is_empty() {
                                        (crate::type_gen::get_simple_name_from_argtype(&anon_class.interfaces[0]),
                                         anon_class.interfaces[0].clone())
                                    } else if let Some(ref superclass) = anon_class.superclass {
                                        (crate::type_gen::get_simple_name(superclass).to_string(),
                                         ArgType::Object(superclass.clone()))
                                    } else {
                                        ("Object".to_string(),
                                         ArgType::Object("java/lang/Object".to_string()))
                                    };

                                    // Declare variable if needed
                                    code.start_line();
                                    if needs_decl {
                                        code.add(&decl_type_str).add(" ");
                                        ctx.mark_declared(reg, version);
                                        ctx.mark_name_declared(&var_name, &decl_type);
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

                            // Check if we need to declare (also check name to avoid same-name redeclaration)
                            let needs_decl = !ctx.is_declared(reg, version)
                                && !ctx.is_parameter(reg, version)
                                && !ctx.is_name_declared(&var_name);

                            code.start_line();
                            if needs_decl {
                                code.add(&type_name).add(" ");
                                ctx.mark_declared(reg, version);
                                ctx.mark_name_declared(&var_name, &ArgType::Object(type_name.clone().into()));
                            }
                            code.add(&var_name).add(" = new ").add(&type_name).add("(");
                            // Use type-aware formatting (0 -> null for Object params)
                            let param_types = &method_info.param_types;
                            for (i, a) in args.iter().skip(1).enumerate() {
                                if i > 0 { code.add(", "); }
                                if let Some(param_type) = param_types.get(i) {
                                    ctx.write_arg_inline_typed(code, a, param_type);
                                } else {
                                    ctx.write_arg_inline(code, a);
                                }
                            }
                            code.add(");").newline();
                            return true;
                        } else {
                            // Fallback: No pending new-instance for this register
                            // This can happen in two cases:
                            // 1. Constructor calling super() or this() - legitimate
                            // 2. Static method or non-constructor - should NOT emit super()
                            if let Some(method_info) = ctx.expr_gen.get_method_value(*method_idx) {
                                if &*method_info.method_name == "<init>" {
                                    // Build argument list (skip receiver which is first arg)
                                    // Use type-aware formatting (0 -> null for Object params)
                                    let param_types = &method_info.param_types;
                                    let arg_strs: Vec<_> = args.iter()
                                        .skip(1)
                                        .enumerate()
                                        .map(|(i, a)| {
                                            if let Some(param_type) = param_types.get(i) {
                                                ctx.gen_arg_inline_typed(a, param_type)
                                            } else {
                                                ctx.gen_arg_inline(a)
                                            }
                                        })
                                        .collect();

                                    // Only emit super()/this() if we're actually in a constructor
                                    // For static methods and non-constructors, this would be invalid Java
                                    if ctx.is_constructor {
                                        // Check if calling same class (this()) or parent (super())
                                        let is_same_class = ctx.current_class_type.as_ref()
                                            .map(|current| current.as_str() == &*method_info.class_type)
                                            .unwrap_or(false);

                                        code.start_line();
                                        if is_same_class {
                                            code.add("this(").add(&arg_strs.join(", ")).add(");");
                                        } else {
                                            code.add("super(").add(&arg_strs.join(", ")).add(");");
                                        }
                                        code.newline();
                                    } else {
                                        // Not in constructor - emit as new ClassName(args)
                                        // This handles cases where new-instance tracking failed
                                        code.start_line();
                                        code.add("new ").add(&method_info.class_name).add("(")
                                            .add(&arg_strs.join(", ")).add(");");
                                        code.newline();
                                    }

                                    return true;
                                }
                            }
                        }
                    }
                }
            }
        }

        // Normal invoke handling - use inlining for arguments
        if next_is_move_result {
            // Store expression for MoveResult to use (needs String)
            let expr = gen_invoke_with_inlining(kind, *method_idx, args, *proto_idx, ctx);
            ctx.last_invoke_expr = Some(expr);
        } else {
            // OPTIMIZED: No MoveResult follows - write directly without String allocation
            code.start_line();
            write_invoke_with_inlining(kind, *method_idx, args, *proto_idx, ctx, code);
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
                // Check if we're returning 0 for an object type - should be null
                // In Dalvik, null is often stored as 0 and returned as a const 0
                // This can happen via direct literal OR via inlined const expression
                let is_zero_value = match v {
                    // Direct literal 0
                    InsnArg::Literal(LiteralArg::Int(0)) => true,
                    // Register with inlined expression "0"
                    InsnArg::Register(reg) => {
                        ctx.peek_inline_expr(reg.reg_num, reg.ssa_version)
                            .map(|s| s == "0")
                            .unwrap_or(false)
                    }
                    _ => false,
                };
                let is_object_return = matches!(
                    ctx.return_type,
                    ArgType::Object(_) | ArgType::Array(_)
                );
                if is_zero_value && is_object_return {
                    code.add("null");
                    // Consume the inlined expression if it was a register
                    if let InsnArg::Register(reg) = v {
                        ctx.take_inline_expr(reg.reg_num, reg.ssa_version);
                    }
                } else {
                    ctx.write_arg_inline(code, v);  // OPTIMIZED: direct write
                }
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
            // Check if type inference determined this register is boolean
            let inferred_type = ctx.type_info.as_ref()
                .and_then(|ti| ti.types.get(&(dest.reg_num, dest.ssa_version)))
                .cloned();

            // Use inferred type if available, otherwise fall back to literal type
            let type_hint = inferred_type.clone().or_else(|| match value {
                LiteralArg::Int(v) if *v >= i32::MIN as i64 && *v <= i32::MAX as i64 => Some(ArgType::Int),
                LiteralArg::Int(_) => Some(ArgType::Long),
                LiteralArg::Float(_) => Some(ArgType::Float),
                LiteralArg::Double(_) => Some(ArgType::Double),
                LiteralArg::Null => None, // null can be any object type
            });

            // Generate literal using type-aware function for proper boolean/char handling
            let val_str = if let (Some(ref ty), LiteralArg::Int(v)) = (&type_hint, value) {
                literal_to_string(*v, ty)
            } else {
                ctx.expr_gen.gen_literal(value)
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

        InsnType::Move { dest, src } => {
            // Check if this variable is used only once - if so, inline it
            let reg = dest.reg_num;
            let version = dest.ssa_version;

            if ctx.should_inline(reg, version) {
                // Get the source expression (which might itself be inlined)
                let src_expr = ctx.gen_arg_inline(src);
                ctx.store_inline_expr(reg, version, src_expr);
                true // Don't emit anything, will be inlined at use site
            } else {
                // Multi-use variable - emit normal assignment
                emit_assignment_insn(dest, &insn.insn_type, None, ctx, code);
                true
            }
        }

        InsnType::MoveResult { dest } => {
            // Check if we're transferring a StringBuilder chain (after append() call)
            if let Some(src_reg) = ctx.last_stringbuilder_reg.take() {
                // Transfer the chain to the new register
                if let Some(chain) = ctx.stringbuilder_chains.remove(&src_reg) {
                    ctx.stringbuilder_chains.insert(dest.reg_num, chain);
                    // Don't emit anything - chain continues
                    return true;
                }
            }

            // Use the stored invoke expression from the previous invoke
            let expr = ctx.last_invoke_expr.take()
                .unwrap_or_else(|| "/* result */".to_string());

            let reg = dest.reg_num;
            let version = dest.ssa_version;

            // If single use, store for inlining instead of emitting assignment
            if ctx.should_inline(reg, version) {
                ctx.store_inline_expr(reg, version, expr);
            } else {
                emit_assignment(dest, &expr, ctx, code);
            }
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

        InsnType::NewArray { dest, size, type_idx } => {
            // Handle NewArray specially to properly inline size argument
            let reg = dest.reg_num;
            let version = dest.ssa_version;

            // Track for potential vararg expansion if:
            // 1. Size is a constant (literal or inlined constant in register)
            // 2. Size is reasonable (1-64 elements)
            // 3. Array is used more than once (APUTs + final use)
            let const_size: Option<usize> = match size {
                InsnArg::Literal(LiteralArg::Int(size_val)) => Some(*size_val as usize),
                InsnArg::Register(size_reg) => {
                    // Check if size register has an inlined constant
                    ctx.peek_inline_expr(size_reg.reg_num, size_reg.ssa_version)
                        .and_then(|s| s.parse::<usize>().ok())
                }
                _ => None,
            };

            if let Some(size_val) = const_size {
                if size_val > 0 && size_val <= 64 {
                    let use_count = ctx.use_counts.get(&(reg, version)).copied().unwrap_or(0);
                    // Needs at least: N ArrayPuts + 1 final Invoke = N+1 uses
                    if use_count > 1 {
                        ctx.pending_vararg_arrays.insert(
                            (reg, version),
                            PendingVarargArray {
                                size: size_val,
                                type_idx: *type_idx,
                                elements: vec![None; size_val],
                                filled_count: 0,
                                invalidated: false,
                            },
                        );
                    }
                }
            }

            // Get element type name
            let type_name = ctx.expr_gen.get_type_value(*type_idx)
                .unwrap_or_else(|| format!("Type#{}", type_idx));
            let elem_name = if type_name.ends_with("[]") {
                type_name.trim_end_matches("[]").to_string()
            } else {
                type_name.trim_start_matches('[').trim_start_matches('L').trim_end_matches(';').to_string()
            };

            // Get size with inlining support
            let size_str = ctx.gen_arg_inline(size);
            let new_array_expr = format!("new {}[{}]", elem_name, size_str);

            // Check if result should be inlined
            if ctx.should_inline(reg, version) {
                ctx.store_inline_expr(reg, version, new_array_expr);
                return true;
            }

            // Emit the assignment
            let var_name = ctx.expr_gen.get_var_name(dest);
            code.start_line();

            // DEAD VARIABLE ELIMINATION: Skip variables that are never used
            let use_count = ctx.use_counts.get(&(reg, version)).copied().unwrap_or(0);
            if use_count == 0 {
                return true;  // Skip unused array allocation
            }

            let needs_decl = !ctx.is_declared(reg, version)
                && !ctx.is_parameter(reg, version)
                && !ctx.is_name_declared(&var_name);

            if needs_decl {
                let decl_type = ctx.get_inferred_type_versioned(reg, version);
                if ctx.is_final(reg, version) {
                    code.add("final ");
                }
                if let Some(arg_type) = decl_type {
                    let type_str = type_to_string_with_imports(arg_type, ctx.imports.as_ref());
                    code.add(&type_str).add(" ");
                } else {
                    code.add(&type_name).add(" ");
                }
                ctx.mark_declared(reg, version);
                ctx.mark_name_declared(&var_name, &ArgType::Unknown);
            }

            code.add(&var_name).add(" = ").add(&new_array_expr).add(";").newline();
            true
        }

        InsnType::ArrayLength { dest, array } => {
            // Invalidate pending vararg array - it's being used in non-vararg context
            if let InsnArg::Register(arr_reg) = array {
                if let Some(pending) = ctx.pending_vararg_arrays.get_mut(
                    &(arr_reg.reg_num, arr_reg.ssa_version)
                ) {
                    pending.invalidated = true;
                }
            }

            // OPTIMIZED: Direct write with int type hint
            emit_assignment_insn(dest, &insn.insn_type, Some(&ArgType::Int), ctx, code);
            true
        }

        InsnType::ArrayGet { dest, array, index, .. } => {
            // Invalidate pending vararg array - it's being read, not just built
            if let InsnArg::Register(arr_reg) = array {
                if let Some(pending) = ctx.pending_vararg_arrays.get_mut(
                    &(arr_reg.reg_num, arr_reg.ssa_version)
                ) {
                    pending.invalidated = true;
                }
            }
            // Handle ArrayGet specially to properly inline index argument
            let reg = dest.reg_num;
            let version = dest.ssa_version;

            // Build expression with inlining support for array and index
            let array_str = ctx.gen_arg_inline(array);
            let index_str = ctx.gen_arg_inline(index);
            let array_get_expr = format!("{}[{}]", array_str, index_str);

            // Check if result should be inlined
            if ctx.should_inline(reg, version) {
                ctx.store_inline_expr(reg, version, array_get_expr);
                return true;
            }

            // Emit the assignment
            let var_name = ctx.expr_gen.get_var_name(dest);
            code.start_line();

            let needs_decl = !ctx.is_declared(reg, version)
                && !ctx.is_parameter(reg, version)
                && !ctx.is_name_declared(&var_name);

            if needs_decl {
                let decl_type = ctx.get_inferred_type_versioned(reg, version);
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
                ctx.mark_name_declared(&var_name, &ArgType::Unknown);
            }

            code.add(&var_name).add(" = ").add(&array_get_expr).add(";").newline();
            true
        }

        InsnType::ArrayPut { array, index, value, .. } => {
            // Check if this is writing to a tracked pending vararg array
            if let InsnArg::Register(arr_reg) = array {
                let key = (arr_reg.reg_num, arr_reg.ssa_version);

                // Get constant index value (from literal or inlined constant in register)
                let const_idx: Option<usize> = match index {
                    InsnArg::Literal(LiteralArg::Int(idx_val)) => Some(*idx_val as usize),
                    InsnArg::Register(idx_reg) => {
                        // Check if index register has an inlined constant
                        ctx.peek_inline_expr(idx_reg.reg_num, idx_reg.ssa_version)
                            .and_then(|s| s.parse::<usize>().ok())
                    }
                    _ => None,
                };

                // First check if we should absorb this into pending vararg
                let should_absorb = {
                    if let Some(pending) = ctx.pending_vararg_arrays.get(&key) {
                        if !pending.invalidated {
                            if let Some(idx) = const_idx {
                                idx < pending.size && pending.elements[idx].is_none()
                            } else {
                                false
                            }
                        } else {
                            false
                        }
                    } else {
                        false
                    }
                };

                if should_absorb {
                    // Generate value string while we don't have mutable borrow
                    let value_str = ctx.gen_arg_inline(value);

                    if let Some(idx) = const_idx {
                        if let Some(pending) = ctx.pending_vararg_arrays.get_mut(&key) {
                            pending.elements[idx] = Some(value_str);
                            pending.filled_count += 1;
                            // Suppress this ArrayPut - absorbed into varargs
                            return true;
                        }
                    }
                } else if let Some(pending) = ctx.pending_vararg_arrays.get_mut(&key) {
                    // Non-constant index, duplicate write, or other issue - invalidate
                    if !pending.invalidated {
                        pending.invalidated = true;
                    }
                }
            }

            // Fall through to normal ArrayPut handling
            code.start_line();
            ctx.write_arg_inline(code, array);
            code.add("[");
            ctx.write_arg_inline(code, index);
            code.add("] = ");
            ctx.write_arg_inline(code, value);
            code.add(";").newline();
            true
        }

        InsnType::InstanceGet { dest, .. } => {
            // OPTIMIZED: Direct write
            emit_assignment_insn(dest, &insn.insn_type, None, ctx, code);
            true
        }

        InsnType::InstancePut { object, field_idx, value } => {
            // Check for field increment pattern first: obj.field = obj.field + 1 -> obj.field++
            if let Some(increment_expr) = detect_field_increment(*field_idx, Some(object), value, ctx) {
                code.start_line().add(&increment_expr).add(";").newline();
                return true;
            }

            // OPTIMIZED: Direct write without String allocation
            // Get field info for both name and type (for proper boolean literal formatting)
            let field_info = ctx.expr_gen.get_field_value(*field_idx);
            let field_name = field_info.as_ref()
                .map(|f| f.field_name.to_string())
                .unwrap_or_else(|| format!("field#{}", field_idx));
            let field_type = field_info
                .map(|f| f.field_type)
                .unwrap_or(ArgType::Unknown);
            code.start_line();
            ctx.expr_gen.write_arg(code, object);
            code.add(".").add(&field_name).add(" = ");
            // Use typed writer with inlining support for proper variable resolution
            ctx.write_arg_inline_typed(code, value, &field_type);
            code.add(";").newline();
            true
        }

        InsnType::StaticGet { dest, .. } => {
            // OPTIMIZED: Direct write
            emit_assignment_insn(dest, &insn.insn_type, None, ctx, code);
            true
        }

        InsnType::StaticPut { field_idx, value } => {
            // Check for static field increment pattern: Class.field = Class.field + 1 -> Class.field++
            if let Some(increment_expr) = detect_field_increment(*field_idx, None, value, ctx) {
                code.start_line().add(&increment_expr).add(";").newline();
                return true;
            }

            // OPTIMIZED: Direct write without String allocation
            // Get field info for both name and type (for proper boolean literal formatting)
            let field_info = ctx.expr_gen.get_field_value(*field_idx);
            let field_ref = field_info.as_ref()
                .map(|f| format!("{}.{}", f.class_name, f.field_name))
                .unwrap_or_else(|| format!("field#{}", field_idx));
            let field_type = field_info
                .map(|f| f.field_type)
                .unwrap_or(ArgType::Unknown);
            code.start_line().add(&field_ref).add(" = ");
            // Use typed writer with inlining support for proper variable resolution
            ctx.write_arg_inline_typed(code, value, &field_type);
            code.add(";").newline();
            true
        }

        InsnType::Invoke { kind, method_idx, args, proto_idx } => {
            // Use write_invoke_with_inlining to properly inline constant arguments
            code.start_line();
            write_invoke_with_inlining(kind, *method_idx, args, *proto_idx, ctx, code);
            code.add(";").newline();
            true
        }

        InsnType::InvokeCustom { call_site_idx, args, dest: _, lambda_info } => {
            // Lambda/method reference - generate lambda syntax
            code.start_line();

            if let Some(info) = lambda_info {
                // Generate lambda based on info
                if info.use_method_ref {
                    // Method reference syntax: Class::method or obj::method
                    code.add(&info.impl_class).add("::").add(&info.impl_method_name);
                } else {
                    // Lambda syntax: (args) -> body or (args) -> { statements }
                    generate_lambda_expression(info, args, ctx, code);
                }
            } else {
                // Fallback - no lambda info available
                code.add("/* invoke-custom #").add(&call_site_idx.to_string());
                if !args.is_empty() {
                    code.add("(");
                    for (i, arg) in args.iter().enumerate() {
                        if i > 0 {
                            code.add(", ");
                        }
                        ctx.write_arg_inline(code, arg);
                    }
                    code.add(")");
                }
                code.add(" */");
            }

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

        InsnType::CheckCast { object, type_idx } => {
            // Check-cast in Dalvik modifies the register in place (no new SSA version)
            // Instead of emitting a statement, store the cast expression for inlining at use site
            // So: v0 = (Type)v0; use(v0) becomes: use((Type)originalExpr)
            if let InsnArg::Register(reg) = object {
                let type_name = ctx.expr_gen.get_type_value(*type_idx)
                    .unwrap_or_else(|| format!("Type#{}", type_idx));

                // Get the original expression or variable name
                let original_expr = ctx.take_inline_expr(reg.reg_num, reg.ssa_version)
                    .unwrap_or_else(|| ctx.expr_gen.get_var_name(reg));

                // Create cast expression
                let cast_expr = format!("({}){}", type_name, original_expr);

                // Store for inlining at use site
                ctx.store_inline_expr(reg.reg_num, reg.ssa_version, cast_expr);
            }
            true // Instruction handled (nothing emitted)
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

        InsnType::ConstClass { dest, .. } => {
            // OPTIMIZED: Direct write
            emit_assignment_insn(dest, &insn.insn_type, None, ctx, code);
            true
        }

        InsnType::FilledNewArray { dest, type_idx, args } => {
            // OPTIMIZED: Direct write avoiding Vec<String> allocation
            let type_name = ctx.expr_gen.get_type_value(*type_idx)
                .unwrap_or_else(|| format!("Type#{}", type_idx));
            // Type is array type, extract element type
            // Handle both Java format (Object[]) and internal format ([Ljava/lang/Object;)
            let elem_type = if type_name.ends_with("[]") {
                // Java format: strip trailing []
                type_name.trim_end_matches("[]").to_string()
            } else {
                // Internal format: [Ljava/lang/Object; -> java/lang/Object
                type_name.trim_start_matches('[').trim_start_matches('L').trim_end_matches(';').to_string()
            };
            if let Some(d) = dest {
                let reg = d.reg_num;
                let version = d.ssa_version;

                // Check inlining (rare case - needs String)
                if ctx.should_inline(reg, version) {
                    let args_str: Vec<_> = args.iter().map(|a| ctx.gen_arg_inline(a)).collect();
                    let expr = format!("new {}[] {{ {} }}", elem_type, args_str.join(", "));
                    ctx.store_inline_expr(reg, version, expr);
                } else {
                    let var_name = ctx.expr_gen.get_var_name(d);
                    code.start_line();

                    // Emit type declaration if needed (also check name to avoid same-name redeclaration)
                    let needs_decl = !ctx.is_declared(reg, version)
                        && !ctx.is_parameter(reg, version)
                        && !ctx.is_name_declared(&var_name);

                    if needs_decl {
                        if ctx.is_final(reg, version) {
                            code.add("final ");
                        }
                        code.add(&elem_type).add("[] ");
                        ctx.mark_declared(reg, version);
                        ctx.mark_name_declared(&var_name, &ArgType::Unknown);
                    }

                    code.add(&var_name).add(" = new ").add(&elem_type).add("[] { ");
                    for (i, a) in args.iter().enumerate() {
                        if i > 0 { code.add(", "); }
                        ctx.write_arg_inline(code, a);
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

        // Ternary expressions: dest = cond ? then : else
        InsnType::Ternary { dest, condition, left, right, then_value, else_value } => {
            let cond_str = format!(
                "{}{}{}",
                ctx.expr_gen.gen_arg(left),
                match condition {
                    IfCondition::Eq => " == ",
                    IfCondition::Ne => " != ",
                    IfCondition::Lt => " < ",
                    IfCondition::Ge => " >= ",
                    IfCondition::Gt => " > ",
                    IfCondition::Le => " <= ",
                },
                right.as_ref().map(|r| ctx.expr_gen.gen_arg(r)).unwrap_or_else(|| "0".to_string())
            );
            let then_str = ctx.expr_gen.gen_arg(then_value);
            let else_str = ctx.expr_gen.gen_arg(else_value);

            let ternary_expr = format!("{} ? {} : {}", cond_str, then_str, else_str);
            ctx.store_inline_expr(dest.reg_num, dest.ssa_version, ternary_expr);
            true
        }

        // New JADX-compatible instructions
        InsnType::MoveMulti { moves } => {
            // Parallel assignments - emit as sequential for now
            for (dest, src) in moves {
                code.start_line();
                code.add(&ctx.expr_gen.get_var_name(dest));
                code.add(" = ");
                ctx.expr_gen.write_arg(code, src);
                code.add(";").newline();
            }
            true
        }
        InsnType::StrConcat { dest, args } => {
            // String concatenation: dest = arg1 + arg2 + ...
            code.start_line();
            code.add(&ctx.expr_gen.get_var_name(dest));
            code.add(" = ");
            for (i, arg) in args.iter().enumerate() {
                if i > 0 { code.add(" + "); }
                ctx.expr_gen.write_arg(code, arg);
            }
            code.add(";").newline();
            true
        }
        InsnType::RegionArg { .. } => true, // Placeholder - no code gen
        InsnType::OneArg { arg } => {
            // Just emit the argument as an expression statement
            code.start_line();
            ctx.expr_gen.write_arg(code, arg);
            code.add(";").newline();
            true
        }
        InsnType::Constructor { dest, type_idx, method_idx, args, generic_types } => {
            // Constructor: dest = new Type<T>(args)
            let reg = dest.reg_num;
            let version = dest.ssa_version;

            // Get type name from type_idx
            let type_name = ctx.expr_gen.get_type_value(*type_idx)
                .unwrap_or_else(|| format!("UnknownType{}", type_idx));

            // Build generic type suffix if present (JADX GenericTypesVisitor parity)
            let generic_suffix = if let Some(generics) = generic_types {
                if !generics.is_empty() {
                    let types: Vec<_> = generics.iter()
                        .map(|gt| type_to_string_with_imports(gt, ctx.imports.as_ref()))
                        .collect();
                    format!("<{}>", types.join(", "))
                } else {
                    String::new()
                }
            } else {
                String::new()
            };

            // Get constructor parameter types for type-aware formatting (0 -> null for Objects)
            let param_types = ctx.expr_gen.get_method_value(*method_idx)
                .map(|info| info.param_types.clone())
                .unwrap_or_default();

            // Build args string with inlining support
            let args_str: Vec<_> = args.iter().enumerate()
                .map(|(i, arg)| {
                    if let Some(param_type) = param_types.get(i) {
                        ctx.gen_arg_inline_typed(arg, param_type)
                    } else {
                        ctx.gen_arg_inline(arg)
                    }
                })
                .collect();

            // Build the constructor expression
            let ctor_expr = format!("new {}{}{}{}", type_name, generic_suffix, "(", args_str.join(", ") + ")");

            // Check if result should be inlined (single-use variable)
            if ctx.should_inline(reg, version) {
                ctx.store_inline_expr(reg, version, ctor_expr);
                return true;
            }

            // Multi-use variable - emit assignment
            let var_name = ctx.expr_gen.get_var_name(dest);
            code.start_line();

            // Check if we need to declare the variable
            let needs_decl = !ctx.is_declared(reg, version)
                && !ctx.is_parameter(reg, version)
                && !ctx.is_name_declared(&var_name);

            if needs_decl {
                let decl_type = ctx.get_inferred_type_versioned(reg, version);
                if ctx.is_final(reg, version) {
                    code.add("final ");
                }
                if let Some(arg_type) = decl_type {
                    let type_str = type_to_string_with_imports(arg_type, ctx.imports.as_ref());
                    code.add(&type_str).add(" ");
                } else {
                    // Use the constructed type as the declaration type
                    code.add(&type_name).add(&generic_suffix).add(" ");
                }
                ctx.mark_declared(reg, version);
                ctx.mark_name_declared(&var_name, &ArgType::Unknown);
            }

            code.add(&var_name).add(" = ").add(&ctor_expr).add(";").newline();
            true
        }
        InsnType::JavaJsr { target } => {
            // JSR is legacy - emit as comment
            code.start_line().add(&format!("/* jsr {} */", target)).newline();
            true
        }
        InsnType::JavaRet { addr_reg } => {
            // RET is legacy - emit as comment
            code.start_line().add(&format!("/* ret {} */", addr_reg.reg_num)).newline();
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
                None => "obj".to_string(),
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
        ArgType::Boolean => "z".to_string(),
        ArgType::Byte => "b".to_string(),
        ArgType::Char => "c".to_string(),
        ArgType::Short => "s".to_string(),
        // Handle generic types by extracting base class name
        ArgType::Generic { base, .. } => {
            let simple = base.rsplit('/').next().unwrap_or(base);
            let simple = simple.rsplit('$').next().unwrap_or(simple);
            let mut chars = simple.chars();
            match chars.next() {
                Some(c) => c.to_lowercase().chain(chars).collect(),
                None => "obj".to_string(),
            }
        }
        // Handle type variables by using the variable name lowercase
        ArgType::TypeVariable(name) => name.to_lowercase(),
        // Handle wildcards by using the bound type if available
        ArgType::Wildcard { inner: Some(inner), .. } => generate_param_name(index, inner),
        ArgType::Wildcard { inner: None, .. } => "obj".to_string(),
        ArgType::Void => "v".to_string(),
        ArgType::Unknown | ArgType::UnknownNarrow | ArgType::UnknownWide
        | ArgType::UnknownObject | ArgType::UnknownArray | ArgType::UnknownIntegral => "obj".to_string(),
    };

    // JADX starts numeric suffixes from 2, not 1
    // First param: i, second: i2, third: i3, etc.
    if index == 0 {
        base
    } else {
        format!("{}{}", base, index + 1)
    }
}

/// Check if class name is StringBuilder or StringBuffer
fn is_stringbuilder_class(class_name: &str) -> bool {
    class_name == "StringBuilder" || class_name == "StringBuffer"
}

/// Try to convert a StringBuilder chain to string concatenation
/// Returns Some(concat_expr) if successful, None if not a valid chain
///
/// Handles patterns like:
/// - `new StringBuilder("init").append(x).append(y).toString()` -> `"init" + x + y`
/// - `new StringBuilder().append(x).toString()` -> `"" + x`
///
/// Does NOT convert chains with:
/// - Methods other than append/toString (e.g., reverse, delete, insert)
/// - Chains that don't end with toString()
fn try_convert_stringbuilder_chain(
    method_name: &str,
    args: &[InsnArg],
    ctx: &mut BodyGenContext,
) -> Option<String> {
    // Only process toString() calls
    if method_name != "toString" {
        return None;
    }

    // Get the receiver (first argument for instance methods)
    let receiver = args.first()?;

    // Check if receiver is a register with an inlined expression
    if let InsnArg::Register(reg) = receiver {
        if let Some(expr) = ctx.take_inline_expr(reg.reg_num, reg.ssa_version) {
            // Try to parse as StringBuilder chain
            if let Some(concat_args) = parse_stringbuilder_chain(&expr) {
                // Need at least one argument, and at least one must be a string
                if concat_args.is_empty() {
                    return None;
                }

                // Pre-concatenate consecutive constant strings (like JADX does)
                let optimized_args = concat_constant_strings(&concat_args);

                // Build concatenation expression
                if optimized_args.len() == 1 {
                    // Single arg - just return it (might be a constant string result)
                    return Some(optimized_args[0].clone());
                }

                // Multiple args - join with +
                return Some(optimized_args.join(" + "));
            }
            // Not a valid chain - put the expression back and fall through
            ctx.store_inline_expr(reg.reg_num, reg.ssa_version, expr);
        }
    }

    None
}

/// Parse a StringBuilder chain expression to extract the concatenation arguments
/// Returns None if the expression is not a valid StringBuilder chain
///
/// Valid patterns:
/// - `new StringBuilder()` -> vec!["\"\""]
/// - `new StringBuilder("text")` -> vec!["\"text\""]
/// - `new StringBuilder().append(x)` -> vec!["\"\"", "x"]
/// - `new StringBuilder("a").append(b).append(c)` -> vec!["\"a\"", "b", "c"]
fn parse_stringbuilder_chain(expr: &str) -> Option<Vec<String>> {
    let expr = expr.trim();

    // Must start with "new StringBuilder" or "new StringBuffer"
    if !expr.starts_with("new StringBuilder") && !expr.starts_with("new StringBuffer") {
        return None;
    }

    let mut args = Vec::new();
    let mut remaining = expr;

    // Parse the constructor: new StringBuilder(...) or new StringBuilder()
    let ctor_start = remaining.find('(')?;
    remaining = &remaining[ctor_start + 1..];

    // Find matching closing paren for constructor
    let ctor_arg_end = find_matching_paren(remaining)?;
    let ctor_arg = remaining[..ctor_arg_end].trim();
    remaining = &remaining[ctor_arg_end + 1..];

    // Add constructor argument if present
    if ctor_arg.is_empty() {
        args.push("\"\"".to_string());
    } else {
        args.push(ctor_arg.to_string());
    }

    // Parse append chain
    loop {
        remaining = remaining.trim();
        if remaining.is_empty() {
            break;
        }

        // Check for .append(
        if !remaining.starts_with(".append(") {
            // Not an append - could be .toString() at the end, or invalid method
            if remaining.starts_with(".toString()") {
                break;
            }
            // Invalid chain (has other methods like .reverse())
            return None;
        }

        remaining = &remaining[8..]; // Skip ".append("

        // Find the argument (handle nested parens)
        let arg_end = find_matching_paren(remaining)?;
        let arg = remaining[..arg_end].trim();
        remaining = &remaining[arg_end + 1..];

        if !arg.is_empty() {
            args.push(arg.to_string());
        }
    }

    // Verify at least one arg is a string type for valid concatenation
    let has_string = args.iter().any(|a| a.starts_with('"') || a.starts_with("String.valueOf("));
    if !has_string && args.len() <= 1 {
        // Need at least one explicit string or multiple args for valid concat
        // If only one non-string arg, we'd get something like `5` which isn't string concat
        if args.len() == 1 && !args[0].starts_with('"') {
            // Single non-string arg like `new StringBuilder().append(5).toString()`
            // Should produce String.valueOf(5), but for simplicity we'll let it generate `"" + 5`
            args.insert(0, "\"\"".to_string());
        }
    }

    Some(args)
}

/// Find the position of the closing paren that matches the opening paren at position 0
/// (The string should start right after the opening paren)
fn find_matching_paren(s: &str) -> Option<usize> {
    let mut depth = 1;
    let mut in_string = false;
    let mut escape = false;
    let mut in_char = false;

    for (i, c) in s.char_indices() {
        if escape {
            escape = false;
            continue;
        }

        match c {
            '\\' if in_string || in_char => {
                escape = true;
            }
            '"' if !in_char => {
                in_string = !in_string;
            }
            '\'' if !in_string => {
                in_char = !in_char;
            }
            '(' if !in_string && !in_char => {
                depth += 1;
            }
            ')' if !in_string && !in_char => {
                depth -= 1;
                if depth == 0 {
                    return Some(i);
                }
            }
            _ => {}
        }
    }
    None
}

/// Concatenate consecutive constant string arguments
/// e.g., ["\"a\"", "\"b\"", "x", "\"c\"", "\"d\""] -> ["\"ab\"", "x", "\"cd\""]
fn concat_constant_strings(args: &[String]) -> Vec<String> {
    if args.len() <= 1 {
        return args.to_vec();
    }

    let mut result = Vec::with_capacity(args.len());
    let mut pending_strings: Vec<&str> = Vec::new();

    for arg in args {
        if let Some(s) = extract_string_literal(arg) {
            pending_strings.push(s);
        } else {
            // Flush any pending strings
            if !pending_strings.is_empty() {
                let combined = pending_strings.join("");
                result.push(format!("\"{}\"", combined));
                pending_strings.clear();
            }
            result.push(arg.clone());
        }
    }

    // Flush remaining strings
    if !pending_strings.is_empty() {
        let combined = pending_strings.join("");
        result.push(format!("\"{}\"", combined));
    }

    result
}

/// Extract the content of a string literal (without quotes)
/// Returns None if not a string literal
fn extract_string_literal(arg: &str) -> Option<&str> {
    let arg = arg.trim();
    if arg.starts_with('"') && arg.ends_with('"') && arg.len() >= 2 {
        Some(&arg[1..arg.len() - 1])
    } else {
        None
    }
}

#[cfg(test)]
mod tests {
    use super::*;
    use crate::writer::SimpleCodeWriter;
    use dexterity_ir::instructions::{InsnArg, InsnNode, InsnType, LiteralArg, RegisterArg};

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
        use dexterity_ir::ClassData;

        // Create a simple anonymous class that implements Runnable
        let mut anon_class = ClassData::new("Lcom/example/Test$1;".to_string(), 0x0001);
        anon_class.interfaces.push(ArgType::Object("java/lang/Runnable".to_string()));

        // Add a run() method
        let mut run_method = MethodData::new("run".to_string(), 0x0001, ArgType::Void);
        run_method.regs_count = 1;
        run_method.ins_count = 1;
        // Empty body - just return
        run_method.set_instructions(vec![dexterity_ir::instructions::InsnNode::new(
            dexterity_ir::instructions::InsnType::Return { value: None },
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
        let block_result = dexterity_passes::block_split::split_blocks(method.get_instructions());
        let ssa_result = dexterity_passes::ssa::transform_to_ssa(&block_result);

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

    #[test]
    fn test_increment_decrement_pattern_detection() {
        use dexterity_ir::instructions::BinaryOp;

        // Create a minimal context for testing
        let method = make_method();
        let ctx = BodyGenContext::from_method(&method);

        // Test i = i + 1 -> i++
        let dest = RegisterArg::with_ssa(0, 2);
        let insn = InsnType::Binary {
            dest: dest.clone(),
            op: BinaryOp::Add,
            left: InsnArg::Register(RegisterArg::with_ssa(0, 1)),
            right: InsnArg::Literal(LiteralArg::Int(1)),
        };
        let result = detect_increment_decrement(&dest, &insn, &ctx);
        assert!(result.is_some(), "Should detect i++ pattern");
        assert!(result.unwrap().ends_with("++"), "Should produce i++ form");

        // Test i = i - 1 -> i--
        let insn_dec = InsnType::Binary {
            dest: dest.clone(),
            op: BinaryOp::Sub,
            left: InsnArg::Register(RegisterArg::with_ssa(0, 1)),
            right: InsnArg::Literal(LiteralArg::Int(1)),
        };
        let result_dec = detect_increment_decrement(&dest, &insn_dec, &ctx);
        assert!(result_dec.is_some(), "Should detect i-- pattern");
        assert!(result_dec.unwrap().ends_with("--"), "Should produce i-- form");

        // Test i = i + 5 -> i += 5
        let insn_add5 = InsnType::Binary {
            dest: dest.clone(),
            op: BinaryOp::Add,
            left: InsnArg::Register(RegisterArg::with_ssa(0, 1)),
            right: InsnArg::Literal(LiteralArg::Int(5)),
        };
        let result_add5 = detect_increment_decrement(&dest, &insn_add5, &ctx);
        assert!(result_add5.is_some(), "Should detect i += 5 pattern");
        assert!(result_add5.unwrap().contains(" += 5"), "Should produce i += 5 form");

        // Test i = i - 3 -> i -= 3
        let insn_sub3 = InsnType::Binary {
            dest: dest.clone(),
            op: BinaryOp::Sub,
            left: InsnArg::Register(RegisterArg::with_ssa(0, 1)),
            right: InsnArg::Literal(LiteralArg::Int(3)),
        };
        let result_sub3 = detect_increment_decrement(&dest, &insn_sub3, &ctx);
        assert!(result_sub3.is_some(), "Should detect i -= 3 pattern");
        assert!(result_sub3.unwrap().contains(" -= 3"), "Should produce i -= 3 form");

        // Test different register - should NOT detect pattern
        let insn_diff_reg = InsnType::Binary {
            dest: dest.clone(),
            op: BinaryOp::Add,
            left: InsnArg::Register(RegisterArg::with_ssa(1, 0)), // Different register!
            right: InsnArg::Literal(LiteralArg::Int(1)),
        };
        let result_diff = detect_increment_decrement(&dest, &insn_diff_reg, &ctx);
        assert!(result_diff.is_none(), "Should not detect pattern with different registers");

        // Test non-literal right operand - SHOULD NOW detect compound assignment pattern
        let insn_non_literal = InsnType::Binary {
            dest: dest.clone(),
            op: BinaryOp::Add,
            left: InsnArg::Register(RegisterArg::with_ssa(0, 1)),
            right: InsnArg::Register(RegisterArg::with_ssa(2, 0)), // Register, not literal
        };
        let result_non_lit = detect_increment_decrement(&dest, &insn_non_literal, &ctx);
        assert!(result_non_lit.is_some(), "Should detect compound assignment pattern with non-literal operand");
        assert!(result_non_lit.unwrap().contains(" += "), "Should produce += form");

        // Test multiplication - SHOULD NOW detect *= pattern
        let insn_mul = InsnType::Binary {
            dest: dest.clone(),
            op: BinaryOp::Mul,
            left: InsnArg::Register(RegisterArg::with_ssa(0, 1)),
            right: InsnArg::Literal(LiteralArg::Int(2)),
        };
        let result_mul = detect_increment_decrement(&dest, &insn_mul, &ctx);
        assert!(result_mul.is_some(), "Should detect *= pattern for multiplication");
        assert!(result_mul.unwrap().contains(" *= 2"), "Should produce *= 2 form");

        // Test division - SHOULD detect /= pattern
        let insn_div = InsnType::Binary {
            dest: dest.clone(),
            op: BinaryOp::Div,
            left: InsnArg::Register(RegisterArg::with_ssa(0, 1)),
            right: InsnArg::Literal(LiteralArg::Int(3)),
        };
        let result_div = detect_increment_decrement(&dest, &insn_div, &ctx);
        assert!(result_div.is_some(), "Should detect /= pattern for division");
        assert!(result_div.unwrap().contains(" /= 3"), "Should produce /= 3 form");

        // Test bitwise AND - SHOULD detect &= pattern
        let insn_and = InsnType::Binary {
            dest: dest.clone(),
            op: BinaryOp::And,
            left: InsnArg::Register(RegisterArg::with_ssa(0, 1)),
            right: InsnArg::Literal(LiteralArg::Int(0xFF)),
        };
        let result_and = detect_increment_decrement(&dest, &insn_and, &ctx);
        assert!(result_and.is_some(), "Should detect &= pattern for AND");
        assert!(result_and.unwrap().contains(" &= "), "Should produce &= form");

        // Test shift right - SHOULD detect >>= pattern
        let insn_shr = InsnType::Binary {
            dest: dest.clone(),
            op: BinaryOp::Shr,
            left: InsnArg::Register(RegisterArg::with_ssa(0, 1)),
            right: InsnArg::Literal(LiteralArg::Int(1)),
        };
        let result_shr = detect_increment_decrement(&dest, &insn_shr, &ctx);
        assert!(result_shr.is_some(), "Should detect >>= pattern for shift right");
        assert!(result_shr.unwrap().contains(" >>= 1"), "Should produce >>= 1 form");
    }

    #[test]
    fn test_simplify_ternary_to_boolean() {
        // Test cond ? true : false -> cond
        let result = simplify_ternary_to_boolean("x > 0", "true", "false");
        assert_eq!(result, Some("x > 0".to_string()), "cond ? true : false should simplify to cond");

        // Test cond ? false : true -> !cond
        let result = simplify_ternary_to_boolean("x > 0", "false", "true");
        assert_eq!(result, Some("!(x > 0)".to_string()), "cond ? false : true should simplify to !(cond)");

        // Test simple condition with negation: !x ? false : true -> x
        let result = simplify_ternary_to_boolean("!x", "false", "true");
        assert_eq!(result, Some("x".to_string()), "!x ? false : true should simplify to x (double negation)");

        // Test !(expr) ? false : true -> expr
        let result = simplify_ternary_to_boolean("!(a && b)", "false", "true");
        assert_eq!(result, Some("a && b".to_string()), "!(a && b) ? false : true should simplify to (a && b)");

        // Test non-boolean ternary - should not simplify
        let result = simplify_ternary_to_boolean("x > 0", "1", "2");
        assert_eq!(result, None, "Non-boolean ternary should not simplify");

        // Test partial boolean - should not simplify
        let result = simplify_ternary_to_boolean("x > 0", "true", "null");
        assert_eq!(result, None, "Mixed boolean/null should not simplify");

        // Test with whitespace
        let result = simplify_ternary_to_boolean("a == b", " true ", " false ");
        assert_eq!(result, Some("a == b".to_string()), "Should handle whitespace in values");
    }

    // StringBuilder chain optimization tests
    #[test]
    fn test_parse_stringbuilder_chain_simple() {
        // Test simple constructor with string
        let result = parse_stringbuilder_chain("new StringBuilder(\"hello\")");
        assert!(result.is_some());
        assert_eq!(result.unwrap(), vec!["\"hello\""]);
    }

    #[test]
    fn test_parse_stringbuilder_chain_empty() {
        // Test empty constructor
        let result = parse_stringbuilder_chain("new StringBuilder()");
        assert!(result.is_some());
        assert_eq!(result.unwrap(), vec!["\"\""]);
    }

    #[test]
    fn test_parse_stringbuilder_chain_with_appends() {
        // Test chain with appends
        let result = parse_stringbuilder_chain("new StringBuilder(\"a\").append(b).append(\"c\")");
        assert!(result.is_some());
        assert_eq!(result.unwrap(), vec!["\"a\"", "b", "\"c\""]);
    }

    #[test]
    fn test_parse_stringbuilder_chain_invalid() {
        // Test invalid chain (has reverse)
        let result = parse_stringbuilder_chain("new StringBuilder(str).reverse()");
        assert!(result.is_none());

        // Test non-StringBuilder
        let result = parse_stringbuilder_chain("new ArrayList()");
        assert!(result.is_none());
    }

    #[test]
    fn test_concat_constant_strings() {
        // Test consecutive constant string concatenation
        let args = vec![
            "\"a\"".to_string(),
            "\"b\"".to_string(),
            "x".to_string(),
            "\"c\"".to_string(),
            "\"d\"".to_string(),
        ];
        let result = concat_constant_strings(&args);
        assert_eq!(result, vec!["\"ab\"", "x", "\"cd\""]);
    }

    #[test]
    fn test_concat_constant_strings_no_merge() {
        // Test when no consecutive constants
        let args = vec!["\"a\"".to_string(), "x".to_string(), "\"b\"".to_string()];
        let result = concat_constant_strings(&args);
        assert_eq!(result, vec!["\"a\"", "x", "\"b\""]);
    }

    #[test]
    fn test_extract_string_literal() {
        assert_eq!(extract_string_literal("\"hello\""), Some("hello"));
        assert_eq!(extract_string_literal("  \"world\"  "), Some("world"));
        assert_eq!(extract_string_literal("variable"), None);
        assert_eq!(extract_string_literal("123"), None);
    }

    #[test]
    fn test_find_matching_paren() {
        // Test simple case
        assert_eq!(find_matching_paren("hello)"), Some(5));

        // Test with nested parens
        assert_eq!(find_matching_paren("foo(bar))"), Some(8));

        // Test with string containing paren
        assert_eq!(find_matching_paren("\"a)b\")"), Some(5));

        // Test with char literal
        assert_eq!(find_matching_paren("')')"), Some(3));
    }

    #[test]
    fn test_is_stringbuilder_class() {
        assert!(is_stringbuilder_class("StringBuilder"));
        assert!(is_stringbuilder_class("StringBuffer"));
        assert!(!is_stringbuilder_class("String"));
        assert!(!is_stringbuilder_class("ArrayList"));
    }

    // Varargs expansion tests
    #[test]
    fn test_extract_vararg_array_elements_simple() {
        let result = extract_vararg_array_elements(r#"new String[] { "a", "b", "c" }"#);
        assert!(result.is_some());
        let elements = result.unwrap();
        assert_eq!(elements.len(), 3);
        assert_eq!(elements[0], r#""a""#);
        assert_eq!(elements[1], r#""b""#);
        assert_eq!(elements[2], r#""c""#);
    }

    #[test]
    fn test_extract_vararg_array_elements_integers() {
        let result = extract_vararg_array_elements("new int[] { 1, 2, 3 }");
        assert!(result.is_some());
        let elements = result.unwrap();
        assert_eq!(elements.len(), 3);
        assert_eq!(elements[0], "1");
        assert_eq!(elements[1], "2");
        assert_eq!(elements[2], "3");
    }

    #[test]
    fn test_extract_vararg_array_elements_empty() {
        // Empty array - valid for varargs (zero args)
        let result = extract_vararg_array_elements("new Object[] { }");
        assert!(result.is_some());
        let elements = result.unwrap();
        assert_eq!(elements.len(), 0);
    }

    #[test]
    fn test_extract_vararg_array_elements_single() {
        let result = extract_vararg_array_elements(r#"new String[] { "only" }"#);
        assert!(result.is_some());
        let elements = result.unwrap();
        assert_eq!(elements.len(), 1);
        assert_eq!(elements[0], r#""only""#);
    }

    #[test]
    fn test_extract_vararg_array_elements_mixed() {
        let result = extract_vararg_array_elements(r#"new Object[] { "hello", 42, var }"#);
        assert!(result.is_some());
        let elements = result.unwrap();
        assert_eq!(elements.len(), 3);
        assert_eq!(elements[0], r#""hello""#);
        assert_eq!(elements[1], "42");
        assert_eq!(elements[2], "var");
    }

    #[test]
    fn test_extract_vararg_array_elements_not_array_literal() {
        // Variable reference - should NOT match
        assert!(extract_vararg_array_elements("arr").is_none());
        // Method call - should NOT match
        assert!(extract_vararg_array_elements("getArray()").is_none());
        // Array access - should NOT match
        assert!(extract_vararg_array_elements("arr[0]").is_none());
    }

    #[test]
    fn test_extract_vararg_array_elements_string_with_comma() {
        // String containing comma should be treated as single element
        let result = extract_vararg_array_elements(r#"new String[] { "hello, world", "test" }"#);
        assert!(result.is_some());
        let elements = result.unwrap();
        assert_eq!(elements.len(), 2);
        assert_eq!(elements[0], r#""hello, world""#);
        assert_eq!(elements[1], r#""test""#);
    }

    #[test]
    fn test_split_array_elements_escaped_quotes() {
        // String with escaped quotes
        let elements = split_array_elements(r#""say \"hello\"", "test""#);
        assert_eq!(elements.len(), 2);
        assert_eq!(elements[0], r#""say \"hello\"""#);
        assert_eq!(elements[1], r#""test""#);
    }
}
