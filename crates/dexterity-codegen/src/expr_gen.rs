//! Expression generation - converts IR instructions to Java expressions
//!
//! This module turns IR instructions into Java source code expressions.
//! For example: `Binary { op: Add, left: v0, right: v1 }` -> `"a + b"`
//!
//! ⚠️ CRITICAL MEMORY WARNING ⚠️
//!
//! The ExprGen struct uses HashMap pooling with capacity shrinking to prevent
//! catastrophic memory growth. DO NOT modify the reset() logic without
//! understanding the memory implications - see reset() documentation.
//!
//! The bug: HashMap::clear() retains capacity permanently, causing 100GB+
//! memory explosions on real APKs when large obfuscated methods inflate
//! HashMap capacity that is then retained across all remaining classes.

use std::cell::RefCell;
use std::collections::HashMap;
use std::sync::Arc;

use dexterity_ir::instructions::{
    BinaryOp, CastType, IfCondition, InsnArg, InsnType,
    InvokeKind, LiteralArg, RegisterArg, UnaryOp,
};
use dexterity_ir::types::ArgType;

use crate::dex_info::DexInfoProvider;
use crate::type_gen::literal_to_string;

/// Expression generation context
///
/// ⚠️ WARNING: Contains 6 HashMaps that MUST be properly shrunk via reset()
///
/// These HashMaps are pooled and reused across methods for performance.
/// The reset() method MUST check capacity and replace oversized HashMaps,
/// otherwise capacity accumulates and causes memory explosions (100GB+ OOM).
///
/// See reset() documentation for detailed explanation of the bug.
///
/// OPTIMIZATION: Uses Arc<str> instead of String for var_names, strings, and
/// type_names. This makes .clone() nearly free (atomic refcount bump) instead
/// of allocating a new String on every access. Critical for performance since
/// gen_arg() is called millions of times during code generation.
pub struct ExprGen {
    /// Variable names: (reg_num, ssa_version) -> name
    /// Uses Arc<str> for cheap cloning in hot paths
    var_names: HashMap<(u16, u32), Arc<str>>,
    /// Variable types (for casting decisions)
    var_types: HashMap<(u16, u32), ArgType>,
    /// String pool for const-string (local cache)
    /// Uses Arc<str> for cheap cloning in hot paths
    strings: HashMap<u32, Arc<str>>,
    /// Type names for type_idx (local cache)
    /// Uses Arc<str> for cheap cloning in hot paths
    type_names: HashMap<u32, Arc<str>>,
    /// Field info for field_idx (local cache)
    field_info: HashMap<u32, FieldInfo>,
    /// Method info for method_idx (local cache)
    method_info: HashMap<u32, MethodInfo>,
    /// Optional DEX info provider for lazy lookups
    pub dex_provider: Option<Arc<dyn DexInfoProvider>>,
    /// Escape non-ASCII characters in strings as \uXXXX
    pub escape_unicode: bool,
}

/// Field information
#[derive(Clone)]
pub struct FieldInfo {
    /// Simple class name (e.g., "Log") for code generation
    pub class_name: String,
    /// Internal class type (e.g., "android/util/Log") for import collection
    pub class_type: String,
    pub field_name: String,
    pub field_type: ArgType,
}

/// Method information
#[derive(Clone)]
pub struct MethodInfo {
    /// Simple class name (e.g., "Log") for code generation
    pub class_name: String,
    /// Internal class type (e.g., "android/util/Log") for import collection
    pub class_type: String,
    pub method_name: String,
    pub return_type: ArgType,
    pub param_types: Vec<ArgType>,
}

// Thread-local pool of ExprGen instances for reuse across methods
// Reduces allocation overhead by reusing HashMap capacity
thread_local! {
    static EXPR_GEN_POOL: RefCell<Vec<ExprGen>> = RefCell::new(Vec::new());
}

impl ExprGen {
    /// Create a new expression generator
    pub fn new() -> Self {
        ExprGen {
            var_names: HashMap::new(),
            var_types: HashMap::new(),
            strings: HashMap::new(),
            type_names: HashMap::new(),
            field_info: HashMap::new(),
            method_info: HashMap::new(),
            dex_provider: None,
            escape_unicode: false,
        }
    }

    /// Create a new expression generator with a DEX info provider for lazy lookups
    pub fn with_dex_provider(dex_provider: Arc<dyn DexInfoProvider>) -> Self {
        ExprGen {
            var_names: HashMap::new(),
            var_types: HashMap::new(),
            strings: HashMap::new(),
            type_names: HashMap::new(),
            field_info: HashMap::new(),
            method_info: HashMap::new(),
            dex_provider: Some(dex_provider),
            escape_unicode: false,
        }
    }

    /// Set escape unicode mode (escape non-ASCII chars as \uXXXX)
    pub fn set_escape_unicode(&mut self, escape: bool) {
        self.escape_unicode = escape;
    }

    /// Set the DEX info provider for lazy lookups
    pub fn set_dex_provider(&mut self, provider: Arc<dyn DexInfoProvider>) {
        self.dex_provider = Some(provider);
    }

    /// Reset for reuse - CRITICAL: Must shrink oversized HashMaps
    ///
    /// ⚠️ DANGER: HashMap::clear() PERMANENTLY RETAINS CAPACITY ⚠️
    ///
    /// This was the root cause of 100GB+ memory explosions on real APKs.
    ///
    /// THE BUG:
    /// - Process small class (10 vars) → HashMap capacity = 14 bytes
    /// - Process huge obfuscated class (10,000 vars) → capacity = 10MB
    /// - Process small class again → capacity STILL 10MB! ❌
    ///
    /// With 6 HashMaps per ExprGen × 16 pooled instances per thread × 10 threads:
    /// - One huge method inflates ALL 960 HashMaps to 10MB each
    /// - Total: 9.6GB locked PERMANENTLY
    /// - Multiple huge methods → 100GB+ OOM kill
    ///
    /// THE FIX:
    /// - Replace HashMap if capacity > 1000 (shrinks to ~0)
    /// - Keep capacity if small (reuse allocation)
    ///
    /// DO NOT CHANGE THIS without understanding the memory implications!
    pub fn reset(&mut self) {
        // MAX_POOLED_CAPACITY = threshold for replacing vs clearing
        // Too high: memory explosion from huge methods
        // Too low: unnecessary allocations for normal methods
        const MAX_POOLED_CAPACITY: usize = 1000;

        // Variable names: (register, ssa_version) -> name
        // CRITICAL: Replace if oversized to prevent memory leak
        if self.var_names.capacity() > MAX_POOLED_CAPACITY {
            self.var_names = HashMap::new();  // SHRINK - drops old allocation
        } else {
            self.var_names.clear();  // Reuse - keeps capacity
        }

        // Variable types: (register, ssa_version) -> ArgType
        // CRITICAL: Replace if oversized to prevent memory leak
        if self.var_types.capacity() > MAX_POOLED_CAPACITY {
            self.var_types = HashMap::new();  // SHRINK - drops old allocation
        } else {
            self.var_types.clear();  // Reuse - keeps capacity
        }

        // String constants: string_idx -> String value
        // CRITICAL: Replace if oversized to prevent memory leak
        if self.strings.capacity() > MAX_POOLED_CAPACITY {
            self.strings = HashMap::new();  // SHRINK - drops old allocation
        } else {
            self.strings.clear();  // Reuse - keeps capacity
        }

        // Type names: type_idx -> type name
        // CRITICAL: Replace if oversized to prevent memory leak
        if self.type_names.capacity() > MAX_POOLED_CAPACITY {
            self.type_names = HashMap::new();  // SHRINK - drops old allocation
        } else {
            self.type_names.clear();  // Reuse - keeps capacity
        }

        // Field info cache: field_idx -> FieldInfo
        // CRITICAL: Replace if oversized to prevent memory leak
        if self.field_info.capacity() > MAX_POOLED_CAPACITY {
            self.field_info = HashMap::new();  // SHRINK - drops old allocation
        } else {
            self.field_info.clear();  // Reuse - keeps capacity
        }

        // Method info cache: method_idx -> MethodInfo
        // CRITICAL: Replace if oversized to prevent memory leak
        if self.method_info.capacity() > MAX_POOLED_CAPACITY {
            self.method_info = HashMap::new();  // SHRINK - drops old allocation
        } else {
            self.method_info.clear();  // Reuse - keeps capacity
        }

        self.dex_provider = None;
    }

    /// Get an ExprGen from the thread-local pool (or create new)
    pub fn from_pool() -> Self {
        EXPR_GEN_POOL.with(|pool| {
            pool.borrow_mut().pop().unwrap_or_else(|| ExprGen::new())
        })
    }

    /// Return an ExprGen to the thread-local pool for reuse
    pub fn return_to_pool(mut self) {
        self.reset();
        EXPR_GEN_POOL.with(|pool| {
            let mut p = pool.borrow_mut();
            // Limit pool size to avoid unbounded growth
            if p.len() < 16 {
                p.push(self);
            }
        });
    }

    /// Set variable name (converts to Arc<str> for cheap cloning)
    pub fn set_var_name(&mut self, reg: u16, version: u32, name: String) {
        self.var_names.insert((reg, version), Arc::from(name));
    }

    /// Set variable type
    pub fn set_var_type(&mut self, reg: u16, version: u32, ty: ArgType) {
        self.var_types.insert((reg, version), ty);
    }

    /// Set string constant (converts to Arc<str> for cheap cloning)
    pub fn set_string(&mut self, idx: u32, value: String) {
        self.strings.insert(idx, Arc::from(value));
    }

    /// Set type name (converts to Arc<str> for cheap cloning)
    pub fn set_type_name(&mut self, idx: u32, name: String) {
        self.type_names.insert(idx, Arc::from(name));
    }

    /// Set field info
    pub fn set_field_info(&mut self, idx: u32, info: FieldInfo) {
        self.field_info.insert(idx, info);
    }

    /// Set method info
    pub fn set_method_info(&mut self, idx: u32, info: MethodInfo) {
        self.method_info.insert(idx, info);
    }

    /// Get field info by index (local cache first, then DEX provider)
    pub fn get_field_info(&self, idx: u32) -> Option<FieldInfo> {
        self.get_field_value(idx)
    }

    /// Get field name (just the name, not qualified)
    /// Uses local cache first, then DEX provider fallback
    pub fn get_field_name(&self, idx: u32) -> Option<String> {
        self.get_field_value(idx).map(|f| f.field_name)
    }

    /// Get static field reference (Class.fieldName)
    pub fn get_static_field_ref(&self, idx: u32) -> Option<String> {
        self.get_field_value(idx).map(|f| format!("{}.{}", f.class_name, f.field_name))
    }

    /// Get variable name (or generate default)
    /// Returns Arc<str> for cheap cloning - clone is just atomic refcount bump
    pub fn get_var_name(&self, reg: &RegisterArg) -> Arc<str> {
        self.var_names
            .get(&(reg.reg_num, reg.ssa_version))
            .cloned()
            .unwrap_or_else(|| Arc::from(format!("v{}", reg.reg_num)))
    }

    /// Get string by index (local cache first, then DEX provider)
    /// Returns Arc<str> for cheap cloning
    pub fn get_string_value(&self, idx: u32) -> Option<Arc<str>> {
        self.strings.get(&idx).cloned()
            .or_else(|| self.dex_provider.as_ref().and_then(|p| p.get_string(idx).map(Arc::from)))
    }

    /// Get type name by index (local cache first, then DEX provider)
    /// Returns Arc<str> for cheap cloning
    pub fn get_type_value(&self, idx: u32) -> Option<Arc<str>> {
        self.type_names.get(&idx).cloned()
            .or_else(|| self.dex_provider.as_ref().and_then(|p| p.get_type_name(idx).map(Arc::from)))
    }

    /// Get field info by index (local cache first, then DEX provider)
    pub fn get_field_value(&self, idx: u32) -> Option<FieldInfo> {
        self.field_info.get(&idx).cloned()
            .or_else(|| self.dex_provider.as_ref().and_then(|p| p.get_field(idx)))
    }

    /// Get method info by index (local cache first, then DEX provider)
    pub fn get_method_value(&self, idx: u32) -> Option<MethodInfo> {
        self.method_info.get(&idx).cloned()
            .or_else(|| self.dex_provider.as_ref().and_then(|p| p.get_method(idx).map(|arc| (*arc).clone())))
    }

    /// Generate expression for an instruction argument
    pub fn gen_arg(&self, arg: &InsnArg) -> String {
        match arg {
            InsnArg::Register(reg) => self.get_var_name(reg),
            InsnArg::Literal(lit) => self.gen_literal(lit),
            InsnArg::Type(idx) => self.get_type_value(*idx)
                .unwrap_or_else(|| format!("Type#{}", idx)),
            InsnArg::Field(idx) => format!("field#{}", idx),
            InsnArg::Method(idx) => format!("method#{}", idx),
            InsnArg::String(idx) => self.get_string_value(*idx)
                .map(|s| format!("\"{}\"", escape_string_inner(&s, self.escape_unicode)))
                .unwrap_or_else(|| format!("string#{}", idx)),
        }
    }

    /// OPTIMIZED: Write arg directly to CodeWriter without String allocation
    /// This is the zero-allocation pattern following Java JADX design
    pub fn write_arg<W: crate::writer::CodeWriter>(&self, writer: &mut W, arg: &InsnArg) {
        match arg {
            InsnArg::Register(reg) => {
                writer.add(&self.get_var_name(reg));
            }
            InsnArg::Literal(lit) => {
                self.write_literal(writer, lit);
            }
            InsnArg::Type(idx) => {
                let type_name = self.get_type_value(*idx)
                    .unwrap_or_else(|| format!("Type#{}", idx));
                writer.add(&type_name);
            }
            InsnArg::Field(idx) => {
                writer.add(&format!("field#{}", idx));
            }
            InsnArg::Method(idx) => {
                writer.add(&format!("method#{}", idx));
            }
            InsnArg::String(idx) => {
                if let Some(s) = self.get_string_value(*idx) {
                    writer.add("\"").add(&escape_string_inner(&s, self.escape_unicode)).add("\"");
                } else {
                    writer.add(&format!("string#{}", idx));
                }
            }
        }
    }

    /// Write arg directly to CodeWriter with target type awareness
    /// This ensures proper literal formatting: 0 -> false for boolean fields
    pub fn write_arg_with_type<W: crate::writer::CodeWriter>(&self, writer: &mut W, arg: &InsnArg, target_type: &ArgType) {
        match arg {
            InsnArg::Literal(LiteralArg::Int(v)) => {
                // Use type-aware literal formatting (0 -> false, 1 -> true for booleans)
                writer.add(&literal_to_string(*v, target_type));
            }
            // All other cases delegate to the regular write_arg
            _ => self.write_arg(writer, arg),
        }
    }

    /// Generate literal expression
    pub fn gen_literal(&self, lit: &LiteralArg) -> String {
        match lit {
            LiteralArg::Int(v) => {
                if *v >= i32::MIN as i64 && *v <= i32::MAX as i64 {
                    format!("{}", v)
                } else {
                    format!("{}L", v)
                }
            }
            LiteralArg::Float(v) => {
                if v.is_nan() {
                    "Float.NaN".to_string()
                } else if v.is_infinite() {
                    if *v > 0.0 { "Float.POSITIVE_INFINITY" } else { "Float.NEGATIVE_INFINITY" }.to_string()
                } else {
                    format!("{}f", v)
                }
            }
            LiteralArg::Double(v) => {
                if v.is_nan() {
                    "Double.NaN".to_string()
                } else if v.is_infinite() {
                    if *v > 0.0 { "Double.POSITIVE_INFINITY" } else { "Double.NEGATIVE_INFINITY" }.to_string()
                } else {
                    format!("{}d", v)
                }
            }
            LiteralArg::Null => "null".to_string(),
        }
    }

    /// OPTIMIZED: Write literal directly to CodeWriter without String allocation
    pub fn write_literal<W: crate::writer::CodeWriter>(&self, writer: &mut W, lit: &LiteralArg) {
        match lit {
            LiteralArg::Int(v) => {
                if *v >= i32::MIN as i64 && *v <= i32::MAX as i64 {
                    writer.add(&format!("{}", v));
                } else {
                    writer.add(&format!("{}L", v));
                }
            }
            LiteralArg::Float(v) => {
                if v.is_nan() {
                    writer.add("Float.NaN");
                } else if v.is_infinite() {
                    if *v > 0.0 { writer.add("Float.POSITIVE_INFINITY"); } else { writer.add("Float.NEGATIVE_INFINITY"); }
                } else {
                    writer.add(&format!("{}f", v));
                }
            }
            LiteralArg::Double(v) => {
                if v.is_nan() {
                    writer.add("Double.NaN");
                } else if v.is_infinite() {
                    if *v > 0.0 { writer.add("Double.POSITIVE_INFINITY"); } else { writer.add("Double.NEGATIVE_INFINITY"); }
                } else {
                    writer.add(&format!("{}d", v));
                }
            }
            LiteralArg::Null => {
                writer.add("null");
            }
        }
    }

    /// Generate expression for instruction
    pub fn gen_insn(&self, insn: &InsnType) -> Option<String> {
        match insn {
            InsnType::Const { value, .. } => Some(self.gen_literal(value)),

            InsnType::ConstString { string_idx, .. } => {
                Some(self.get_string_value(*string_idx)
                    .map(|s| format!("\"{}\"", escape_string_inner(&s, self.escape_unicode)))
                    .unwrap_or_else(|| format!("string#{}", string_idx)))
            }

            InsnType::ConstClass { type_idx, .. } => {
                let name = self.get_type_value(*type_idx)
                    .unwrap_or_else(|| format!("Type#{}", type_idx));
                Some(format!("{}.class", name))
            }

            InsnType::Move { src, .. } => Some(self.gen_arg(src)),

            InsnType::NewInstance { type_idx, .. } => {
                let name = self.get_type_value(*type_idx)
                    .unwrap_or_else(|| format!("Type#{}", type_idx));
                Some(format!("new {}()", name))
            }

            InsnType::NewArray { size, type_idx, .. } => {
                let name = self.get_type_value(*type_idx)
                    .unwrap_or_else(|| format!("Type#{}", type_idx));
                let size_str = self.gen_arg(size);
                // Type is array type, get element type
                let elem_name = name.trim_start_matches('[').trim_start_matches('L').trim_end_matches(';');
                Some(format!("new {}[{}]", elem_name, size_str))
            }

            InsnType::FilledNewArray { type_idx, args, .. } => {
                let name = self.get_type_value(*type_idx)
                    .unwrap_or_else(|| format!("Type#{}", type_idx));
                let elem_name = name.trim_start_matches('[').trim_start_matches('L').trim_end_matches(';');
                let args_str: Vec<_> = args.iter().map(|a| self.gen_arg(a)).collect();
                Some(format!("new {}[] {{ {} }}", elem_name, args_str.join(", ")))
            }

            InsnType::ArrayLength { array, .. } => {
                Some(format!("{}.length", self.gen_arg(array)))
            }

            InsnType::ArrayGet { array, index, .. } => {
                Some(format!("{}[{}]", self.gen_arg(array), self.gen_arg(index)))
            }

            InsnType::InstanceOf { object, type_idx, .. } => {
                let name = self.get_type_value(*type_idx)
                    .unwrap_or_else(|| format!("Type#{}", type_idx));
                Some(format!("{} instanceof {}", self.gen_arg(object), name))
            }

            InsnType::InstanceGet { object, field_idx, .. } => {
                if let Some(info) = self.get_field_value(*field_idx) {
                    Some(format!("{}.{}", self.gen_arg(object), info.field_name))
                } else {
                    Some(format!("{}.field#{}", self.gen_arg(object), field_idx))
                }
            }

            InsnType::StaticGet { field_idx, .. } => {
                if let Some(info) = self.get_field_value(*field_idx) {
                    Some(format!("{}.{}", info.class_name, info.field_name))
                } else {
                    Some(format!("field#{}", field_idx))
                }
            }

            InsnType::Invoke { kind, method_idx, args } => {
                let args_str: Vec<_> = args.iter()
                    .skip(if matches!(kind, InvokeKind::Static) { 0 } else { 1 }) // Skip 'this' for non-static
                    .map(|a| self.gen_arg(a))
                    .collect();

                if let Some(info) = self.get_method_value(*method_idx) {
                    match kind {
                        InvokeKind::Static => {
                            Some(format!("{}.{}({})", info.class_name, info.method_name, args_str.join(", ")))
                        }
                        InvokeKind::Virtual | InvokeKind::Interface | InvokeKind::Direct => {
                            let receiver = args.first().map(|a| self.gen_arg(a)).unwrap_or_default();
                            // Handle constructor calls: this.<init>() -> super()
                            if info.method_name == "<init>" {
                                if receiver == "this" {
                                    // Constructor calling super constructor
                                    Some(format!("super({})", args_str.join(", ")))
                                } else {
                                    // new SomeClass() - this is typically handled by NewInstance
                                    Some(format!("new {}({})", info.class_name, args_str.join(", ")))
                                }
                            } else if receiver == "this" {
                                Some(format!("{}({})", info.method_name, args_str.join(", ")))
                            } else {
                                Some(format!("{}.{}({})", receiver, info.method_name, args_str.join(", ")))
                            }
                        }
                        InvokeKind::Super => {
                            if info.method_name == "<init>" {
                                Some(format!("super({})", args_str.join(", ")))
                            } else {
                                Some(format!("super.{}({})", info.method_name, args_str.join(", ")))
                            }
                        }
                        _ => Some(format!("method#{}({})", method_idx, args_str.join(", ")))
                    }
                } else {
                    Some(format!("method#{}({})", method_idx, args_str.join(", ")))
                }
            }

            InsnType::Unary { op, arg, .. } => {
                let arg_str = self.gen_arg(arg);
                Some(match op {
                    UnaryOp::Neg => format!("-{}", maybe_paren(&arg_str)),
                    UnaryOp::Not => format!("~{}", maybe_paren(&arg_str)),
                })
            }

            InsnType::Binary { op, left, right, .. } => {
                let left_str = self.gen_arg(left);
                let right_str = self.gen_arg(right);
                let op_str = binary_op_str(*op);
                Some(format!("{} {} {}", maybe_paren(&left_str), op_str, maybe_paren(&right_str)))
            }

            InsnType::Cast { cast_type, arg, .. } => {
                let arg_str = self.gen_arg(arg);
                let type_str = cast_type_str(*cast_type);
                Some(format!("({}){}", type_str, maybe_paren(&arg_str)))
            }

            InsnType::Compare { left, right, .. } => {
                // Compare returns int (-1, 0, 1), used for long/float/double comparisons
                let left_str = self.gen_arg(left);
                let right_str = self.gen_arg(right);
                Some(format!("compare({}, {})", left_str, right_str))
            }

            InsnType::CheckCast { object, type_idx } => {
                let name = self.get_type_value(*type_idx)
                    .unwrap_or_else(|| format!("Type#{}", type_idx));
                Some(format!("({}){}", name, self.gen_arg(object)))
            }

            _ => None, // Statements, not expressions
        }
    }

    /// OPTIMIZED: Write instruction expression directly to CodeWriter without String allocation
    /// Returns true if expression was written, false if instruction is a statement
    pub fn write_insn<W: crate::writer::CodeWriter>(&self, writer: &mut W, insn: &InsnType) -> bool {
        match insn {
            InsnType::Const { value, .. } => {
                self.write_literal(writer, value);
                true
            }

            InsnType::ConstString { string_idx, .. } => {
                if let Some(s) = self.get_string_value(*string_idx) {
                    writer.add("\"").add(&escape_string_inner(&s, self.escape_unicode)).add("\"");
                } else {
                    writer.add(&format!("string#{}", string_idx));
                }
                true
            }

            InsnType::Move { src, .. } => {
                self.write_arg(writer, src);
                true
            }

            InsnType::ArrayLength { array, .. } => {
                self.write_arg(writer, array);
                writer.add(".length");
                true
            }

            InsnType::ArrayGet { array, index, .. } => {
                self.write_arg(writer, array);
                writer.add("[");
                self.write_arg(writer, index);
                writer.add("]");
                true
            }

            InsnType::Unary { op, arg, .. } => {
                match op {
                    UnaryOp::Neg => writer.add("-"),
                    UnaryOp::Not => writer.add("~"),
                };
                self.write_arg(writer, arg);
                true
            }

            InsnType::Binary { op, left, right, .. } => {
                self.write_arg(writer, left);
                writer.add(" ").add(binary_op_str(*op)).add(" ");
                self.write_arg(writer, right);
                true
            }

            InsnType::Cast { cast_type, arg, .. } => {
                writer.add("(").add(cast_type_str(*cast_type)).add(")");
                self.write_arg(writer, arg);
                true
            }

            InsnType::Compare { left, right, .. } => {
                writer.add("compare(");
                self.write_arg(writer, left);
                writer.add(", ");
                self.write_arg(writer, right);
                writer.add(")");
                true
            }

            InsnType::InstanceOf { object, type_idx, .. } => {
                self.write_arg(writer, object);
                let name = self.get_type_value(*type_idx)
                    .unwrap_or_else(|| format!("Type#{}", type_idx));
                writer.add(" instanceof ").add(&name);
                true
            }

            InsnType::InstanceGet { object, field_idx, .. } => {
                self.write_arg(writer, object);
                if let Some(info) = self.get_field_value(*field_idx) {
                    writer.add(".").add(&info.field_name);
                } else {
                    writer.add(&format!(".field#{}", field_idx));
                }
                true
            }

            InsnType::StaticGet { field_idx, .. } => {
                if let Some(info) = self.get_field_value(*field_idx) {
                    writer.add(&info.class_name).add(".").add(&info.field_name);
                } else {
                    writer.add(&format!("field#{}", field_idx));
                }
                true
            }

            InsnType::Invoke { kind, method_idx, args } => {
                // Skip 'this' arg for non-static methods
                let skip_receiver = !matches!(kind, InvokeKind::Static);

                if let Some(info) = self.get_method_value(*method_idx) {
                    match kind {
                        InvokeKind::Static => {
                            writer.add(&info.class_name).add(".").add(&info.method_name).add("(");
                            for (i, a) in args.iter().enumerate() {
                                if i > 0 { writer.add(", "); }
                                self.write_arg(writer, a);
                            }
                            writer.add(")");
                        }
                        InvokeKind::Virtual | InvokeKind::Interface | InvokeKind::Direct => {
                            if let Some(receiver) = args.first() {
                                let recv_name = self.gen_arg(receiver); // Need this for conditional logic
                                if info.method_name == "<init>" {
                                    if recv_name == "this" {
                                        writer.add("super(");
                                    } else {
                                        writer.add("new ").add(&info.class_name).add("(");
                                    }
                                } else if recv_name == "this" {
                                    writer.add(&info.method_name).add("(");
                                } else {
                                    self.write_arg(writer, receiver);
                                    writer.add(".").add(&info.method_name).add("(");
                                }
                            }
                            for (i, a) in args.iter().skip(if skip_receiver { 1 } else { 0 }).enumerate() {
                                if i > 0 { writer.add(", "); }
                                self.write_arg(writer, a);
                            }
                            writer.add(")");
                        }
                        InvokeKind::Super => {
                            if info.method_name == "<init>" {
                                writer.add("super(");
                            } else {
                                writer.add("super.").add(&info.method_name).add("(");
                            }
                            for (i, a) in args.iter().skip(if skip_receiver { 1 } else { 0 }).enumerate() {
                                if i > 0 { writer.add(", "); }
                                self.write_arg(writer, a);
                            }
                            writer.add(")");
                        }
                        _ => {
                            writer.add(&format!("method#{}(", method_idx));
                            for (i, a) in args.iter().enumerate() {
                                if i > 0 { writer.add(", "); }
                                self.write_arg(writer, a);
                            }
                            writer.add(")");
                        }
                    }
                } else {
                    writer.add(&format!("method#{}(", method_idx));
                    for (i, a) in args.iter().enumerate() {
                        if i > 0 { writer.add(", "); }
                        self.write_arg(writer, a);
                    }
                    writer.add(")");
                }
                true
            }

            InsnType::CheckCast { object, type_idx } => {
                let name = self.get_type_value(*type_idx)
                    .unwrap_or_else(|| format!("Type#{}", type_idx));
                writer.add("(").add(&name).add(")");
                self.write_arg(writer, object);
                true
            }

            InsnType::NewInstance { type_idx, .. } => {
                let name = self.get_type_value(*type_idx)
                    .unwrap_or_else(|| format!("Type#{}", type_idx));
                writer.add("new ").add(&name).add("()");
                true
            }

            InsnType::NewArray { size, type_idx, .. } => {
                let name = self.get_type_value(*type_idx)
                    .unwrap_or_else(|| format!("Type#{}", type_idx));
                let elem_name = name.trim_start_matches('[').trim_start_matches('L').trim_end_matches(';');
                writer.add("new ").add(elem_name).add("[");
                self.write_arg(writer, size);
                writer.add("]");
                true
            }

            InsnType::ConstClass { type_idx, .. } => {
                let name = self.get_type_value(*type_idx)
                    .unwrap_or_else(|| format!("Type#{}", type_idx));
                writer.add(&name).add(".class");
                true
            }

            _ => false, // Statements, not expressions
        }
    }

    /// Generate condition expression for If instruction
    pub fn gen_condition(&self, condition: IfCondition, left: &InsnArg, right: Option<&InsnArg>) -> String {
        let left_str = self.gen_arg(left);
        let op = condition_op_str(condition);

        if let Some(right) = right {
            format!("{} {} {}", left_str, op, self.gen_arg(right))
        } else {
            // Zero comparison
            format!("{} {} 0", left_str, op)
        }
    }
}

impl Default for ExprGen {
    fn default() -> Self {
        Self::new()
    }
}

/// Binary operation to string
fn binary_op_str(op: BinaryOp) -> &'static str {
    match op {
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
        BinaryOp::Rsub => "-", // Reverse subtraction handled specially
    }
}

/// Condition to comparison operator
fn condition_op_str(cond: IfCondition) -> &'static str {
    match cond {
        IfCondition::Eq => "==",
        IfCondition::Ne => "!=",
        IfCondition::Lt => "<",
        IfCondition::Ge => ">=",
        IfCondition::Gt => ">",
        IfCondition::Le => "<=",
    }
}

/// Cast type to Java type string
fn cast_type_str(cast: CastType) -> &'static str {
    match cast {
        CastType::IntToLong => "long",
        CastType::IntToFloat => "float",
        CastType::IntToDouble => "double",
        CastType::LongToInt => "int",
        CastType::LongToFloat => "float",
        CastType::LongToDouble => "double",
        CastType::FloatToInt => "int",
        CastType::FloatToLong => "long",
        CastType::FloatToDouble => "double",
        CastType::DoubleToInt => "int",
        CastType::DoubleToLong => "long",
        CastType::DoubleToFloat => "float",
        CastType::IntToByte => "byte",
        CastType::IntToChar => "char",
        CastType::IntToShort => "short",
    }
}

/// Wrap in parentheses if needed (for complex expressions)
fn maybe_paren(s: &str) -> String {
    if s.contains(' ') && !s.starts_with('(') {
        format!("({})", s)
    } else {
        s.to_string()
    }
}

/// Escape string for Java source with optional unicode escaping
///
/// When `escape_unicode` is true, non-ASCII characters are escaped as \uXXXX.
/// When false, UTF-8 characters are preserved for readability.
fn escape_string_inner(s: &str, escape_unicode: bool) -> String {
    let mut result = String::with_capacity(s.len());
    for c in s.chars() {
        match c {
            '"' => result.push_str("\\\""),
            '\\' => result.push_str("\\\\"),
            '\n' => result.push_str("\\n"),
            '\r' => result.push_str("\\r"),
            '\t' => result.push_str("\\t"),
            c if c.is_control() => {
                result.push_str(&format!("\\u{:04x}", c as u32));
            }
            c if escape_unicode && !c.is_ascii() => {
                // Escape non-ASCII characters as \uXXXX
                if (c as u32) <= 0xFFFF {
                    result.push_str(&format!("\\u{:04x}", c as u32));
                } else {
                    // Surrogate pair for chars > 0xFFFF
                    let code = c as u32 - 0x10000;
                    let high = ((code >> 10) + 0xD800) as u16;
                    let low = ((code & 0x3FF) + 0xDC00) as u16;
                    result.push_str(&format!("\\u{:04x}\\u{:04x}", high, low));
                }
            }
            c => result.push(c),
        }
    }
    result
}

/// Escape string for Java source (backward compatible, no unicode escaping)
fn escape_string(s: &str) -> String {
    escape_string_inner(s, false)
}

#[cfg(test)]
mod tests {
    use super::*;
    use dexterity_ir::instructions::ArrayElemType;

    #[test]
    fn test_literal_gen() {
        let gen = ExprGen::new();
        assert_eq!(gen.gen_literal(&LiteralArg::Int(42)), "42");
        assert_eq!(gen.gen_literal(&LiteralArg::Int(5000000000)), "5000000000L");
        assert_eq!(gen.gen_literal(&LiteralArg::Null), "null");
    }

    #[test]
    fn test_var_name() {
        let mut gen = ExprGen::new();
        gen.set_var_name(0, 1, "myVar".to_string());

        let reg = RegisterArg::with_ssa(0, 1);
        assert_eq!(gen.get_var_name(&reg), "myVar");

        // Unknown var gets default name
        let reg2 = RegisterArg::with_ssa(5, 0);
        assert_eq!(gen.get_var_name(&reg2), "v5");
    }

    #[test]
    fn test_binary_op() {
        let gen = ExprGen::new();
        let insn = InsnType::Binary {
            dest: RegisterArg::new(0),
            op: BinaryOp::Add,
            left: InsnArg::reg(1),
            right: InsnArg::reg(2),
        };
        assert_eq!(gen.gen_insn(&insn), Some("v1 + v2".to_string()));
    }

    #[test]
    fn test_unary_op() {
        let gen = ExprGen::new();
        let insn = InsnType::Unary {
            dest: RegisterArg::new(0),
            op: UnaryOp::Neg,
            arg: InsnArg::reg(1),
        };
        assert_eq!(gen.gen_insn(&insn), Some("-v1".to_string()));
    }

    #[test]
    fn test_array_access() {
        let gen = ExprGen::new();
        let insn = InsnType::ArrayGet {
            dest: RegisterArg::new(0),
            array: InsnArg::reg(1),
            index: InsnArg::reg(2),
            elem_type: ArrayElemType::Int,
        };
        assert_eq!(gen.gen_insn(&insn), Some("v1[v2]".to_string()));
    }

    #[test]
    fn test_condition() {
        let gen = ExprGen::new();
        let cond = gen.gen_condition(
            IfCondition::Eq,
            &InsnArg::reg(0),
            Some(&InsnArg::reg(1))
        );
        assert_eq!(cond, "v0 == v1");
    }

    #[test]
    fn test_escape_string() {
        assert_eq!(escape_string("hello"), "hello");
        assert_eq!(escape_string("say \"hi\""), "say \\\"hi\\\"");
        assert_eq!(escape_string("line1\nline2"), "line1\\nline2");
    }
}
