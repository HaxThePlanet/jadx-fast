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
    BinaryOp, CastType, CompareOp, IfCondition, InsnArg, InsnType,
    InvokeKind, LiteralArg, RegisterArg, UnaryOp,
};
use dexterity_ir::types::ArgType;

use crate::dex_info::DexInfoProvider;
use crate::type_gen::literal_to_string;

/// Sanitize a method name to be a valid Java identifier
/// Kotlin internal methods often have hyphens (e.g., set-impl, getGreen-0d7_KjU)
fn sanitize_method_name(name: &str) -> String {
    if !name.contains('-') {
        return name.to_string();
    }
    name.replace('-', "_")
}

/// Expression generation context
///
/// ⚠️ WARNING: Contains 6 HashMaps that MUST be properly shrunk via reset()
///
/// These HashMaps are pooled and reused across methods for performance.
/// The reset() method MUST check capacity and replace oversized HashMaps,
/// otherwise capacity accumulates and causes memory explosions (100GB+ OOM).
///
/// See reset() documentation for detailed explanation of the bug.
pub struct ExprGen {
    /// Variable names: (reg_num, ssa_version) -> name
    var_names: HashMap<(u16, u32), String>,
    /// Variable types (for casting decisions)
    var_types: HashMap<(u16, u32), ArgType>,
    /// String pool for const-string (local cache)
    strings: HashMap<u32, String>,
    /// Type names for type_idx (local cache)
    type_names: HashMap<u32, String>,
    /// Field info for field_idx (local cache)
    field_info: HashMap<u32, FieldInfo>,
    /// Method info for method_idx (local cache)
    method_info: HashMap<u32, MethodInfo>,
    /// Optional DEX info provider for lazy lookups
    pub dex_provider: Option<Arc<dyn DexInfoProvider>>,
    /// Escape non-ASCII characters in strings as \uXXXX
    pub escape_unicode: bool,
    /// Deobfuscation: minimum name length (shorter names get renamed)
    pub deobf_min_length: usize,
    /// Deobfuscation: maximum name length (longer names get renamed)
    pub deobf_max_length: usize,
    /// Resource ID -> name mapping (e.g., 0x7f010001 -> "id/button")
    pub res_names: HashMap<u32, String>,
    /// Whether to replace resource IDs with R.* field references
    pub replace_consts: bool,
}

/// Field information
#[derive(Clone)]
pub struct FieldInfo {
    /// Simple class name (e.g., "Log") for code generation
    pub class_name: Arc<str>,
    /// Internal class type (e.g., "android/util/Log") for import collection
    pub class_type: Arc<str>,
    pub field_name: Arc<str>,
    pub field_type: ArgType,
}

/// Method information
#[derive(Clone)]
pub struct MethodInfo {
    /// Simple class name (e.g., "Log") for code generation
    pub class_name: Arc<str>,
    /// Internal class type (e.g., "android/util/Log") for import collection
    pub class_type: Arc<str>,
    pub method_name: Arc<str>,
    pub return_type: ArgType,
    pub param_types: Vec<ArgType>,
    /// Whether this method accepts varargs (None if unknown, e.g., external method)
    /// Used for varargs expansion: `foo(new String[]{"a", "b"})` → `foo("a", "b")`
    pub is_varargs: Option<bool>,
}

/// Boxing type for deboxing pass
/// Identifies which primitive wrapper class is being used
#[derive(Debug, Clone, Copy, PartialEq, Eq)]
pub enum BoxingType {
    Integer,
    Boolean,
    Byte,
    Short,
    Character,
    Long,
    Float,
    Double,
}

impl BoxingType {
    /// Check if a method is a boxing valueOf method and return the boxing type
    /// Matches patterns like Integer.valueOf(int), Boolean.valueOf(boolean), etc.
    pub fn from_method(info: &MethodInfo) -> Option<BoxingType> {
        // Must be valueOf method with exactly one parameter
        if &*info.method_name != "valueOf" || info.param_types.len() != 1 {
            return None;
        }

        // Match class type (internal format: java/lang/Integer)
        match &*info.class_type {
            "java/lang/Integer" => {
                if matches!(info.param_types[0], ArgType::Int) {
                    Some(BoxingType::Integer)
                } else {
                    None
                }
            }
            "java/lang/Boolean" => {
                if matches!(info.param_types[0], ArgType::Boolean) {
                    Some(BoxingType::Boolean)
                } else {
                    None
                }
            }
            "java/lang/Byte" => {
                if matches!(info.param_types[0], ArgType::Byte) {
                    Some(BoxingType::Byte)
                } else {
                    None
                }
            }
            "java/lang/Short" => {
                if matches!(info.param_types[0], ArgType::Short) {
                    Some(BoxingType::Short)
                } else {
                    None
                }
            }
            "java/lang/Character" => {
                if matches!(info.param_types[0], ArgType::Char) {
                    Some(BoxingType::Character)
                } else {
                    None
                }
            }
            "java/lang/Long" => {
                if matches!(info.param_types[0], ArgType::Long) {
                    Some(BoxingType::Long)
                } else {
                    None
                }
            }
            "java/lang/Float" => {
                if matches!(info.param_types[0], ArgType::Float) {
                    Some(BoxingType::Float)
                } else {
                    None
                }
            }
            "java/lang/Double" => {
                if matches!(info.param_types[0], ArgType::Double) {
                    Some(BoxingType::Double)
                } else {
                    None
                }
            }
            _ => None,
        }
    }

    /// Generate the deboxed literal string from a value
    /// Handles type suffixes and casts:
    /// - Integer: just the number (1)
    /// - Boolean: true/false
    /// - Byte: (byte) 2
    /// - Short: (short) 3
    /// - Character: 'c' (char literal)
    /// - Long: 4L (with L suffix)
    /// - Float: 1.0f (with f suffix)
    /// - Double: 1.0d (with d suffix)
    pub fn format_literal(&self, value: i64) -> String {
        match self {
            BoxingType::Integer => format!("{}", value as i32),
            BoxingType::Boolean => {
                if value == 0 { "false".to_string() } else { "true".to_string() }
            }
            BoxingType::Byte => format!("(byte) {}", value as i8),
            BoxingType::Short => format!("(short) {}", value as i16),
            BoxingType::Character => {
                let c = value as u16;
                // Handle printable ASCII characters
                if c >= 0x20 && c < 0x7F && c != 0x27 && c != 0x5C {
                    format!("'{}'", char::from_u32(c as u32).unwrap_or('?'))
                } else {
                    // Use unicode escape for non-printable or special chars
                    format!("'\\u{:04x}'", c)
                }
            }
            BoxingType::Long => format!("{}L", value),
            BoxingType::Float => {
                let f = f32::from_bits(value as u32);
                if f.is_nan() {
                    "Float.NaN".to_string()
                } else if f.is_infinite() {
                    if f > 0.0 { "Float.POSITIVE_INFINITY".to_string() }
                    else { "Float.NEGATIVE_INFINITY".to_string() }
                } else {
                    format!("{}f", f)
                }
            }
            BoxingType::Double => {
                let d = f64::from_bits(value as u64);
                if d.is_nan() {
                    "Double.NaN".to_string()
                } else if d.is_infinite() {
                    if d > 0.0 { "Double.POSITIVE_INFINITY".to_string() }
                    else { "Double.NEGATIVE_INFINITY".to_string() }
                } else {
                    format!("{}d", d)
                }
            }
        }
    }

    /// Write the deboxed literal directly to a CodeWriter
    pub fn write_literal<W: crate::writer::CodeWriter>(&self, writer: &mut W, value: i64) {
        match self {
            BoxingType::Integer => {
                writer.add(&format!("{}", value as i32));
            }
            BoxingType::Boolean => {
                writer.add(if value == 0 { "false" } else { "true" });
            }
            BoxingType::Byte => {
                writer.add(&format!("(byte) {}", value as i8));
            }
            BoxingType::Short => {
                writer.add(&format!("(short) {}", value as i16));
            }
            BoxingType::Character => {
                let c = value as u16;
                // Handle printable ASCII characters
                if c >= 0x20 && c < 0x7F && c != 0x27 && c != 0x5C {
                    writer.add(&format!("'{}'", char::from_u32(c as u32).unwrap_or('?')));
                } else {
                    writer.add(&format!("'\\u{:04x}'", c));
                }
            }
            BoxingType::Long => {
                writer.add(&format!("{}L", value));
            }
            BoxingType::Float => {
                let f = f32::from_bits(value as u32);
                if f.is_nan() {
                    writer.add("Float.NaN");
                } else if f.is_infinite() {
                    writer.add(if f > 0.0 { "Float.POSITIVE_INFINITY" } else { "Float.NEGATIVE_INFINITY" });
                } else {
                    writer.add(&format!("{}f", f));
                }
            }
            BoxingType::Double => {
                let d = f64::from_bits(value as u64);
                if d.is_nan() {
                    writer.add("Double.NaN");
                } else if d.is_infinite() {
                    writer.add(if d > 0.0 { "Double.POSITIVE_INFINITY" } else { "Double.NEGATIVE_INFINITY" });
                } else {
                    writer.add(&format!("{}d", d));
                }
            }
        }
    }
}

/// Check if an InsnArg is a literal and extract its integer value
pub fn get_literal_int_value(arg: &InsnArg) -> Option<i64> {
    match arg {
        InsnArg::Literal(LiteralArg::Int(v)) => Some(*v),
        _ => None,
    }
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
            deobf_min_length: 3,
            deobf_max_length: 64,
            res_names: HashMap::new(),
            replace_consts: false,
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
            deobf_min_length: 3,
            deobf_max_length: 64,
            res_names: HashMap::new(),
            replace_consts: false,
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

    /// Set deobfuscation name length limits (min and max)
    pub fn set_deobf_limits(&mut self, min_length: usize, max_length: usize) {
        self.deobf_min_length = min_length;
        self.deobf_max_length = max_length;
    }

    /// Set resource names mapping and replacement flag
    pub fn set_resources(&mut self, res_names: HashMap<u32, String>, replace_consts: bool) {
        self.res_names = res_names;
        self.replace_consts = replace_consts;
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

    /// Set variable name
    pub fn set_var_name(&mut self, reg: u16, version: u32, name: String) {
        self.var_names.insert((reg, version), name);
    }

    /// Set variable type
    pub fn set_var_type(&mut self, reg: u16, version: u32, ty: ArgType) {
        self.var_types.insert((reg, version), ty);
    }

    /// Get variable type (if known)
    pub fn get_var_type(&self, reg: u16, version: u32) -> Option<ArgType> {
        self.var_types.get(&(reg, version)).cloned()
    }

    /// Set string constant
    pub fn set_string(&mut self, idx: u32, value: String) {
        self.strings.insert(idx, value);
    }

    /// Set type name
    pub fn set_type_name(&mut self, idx: u32, name: String) {
        self.type_names.insert(idx, name);
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
        self.get_field_value(idx).map(|f| f.field_name.to_string())
    }

    /// Get static field reference (Class.fieldName)
    pub fn get_static_field_ref(&self, idx: u32) -> Option<String> {
        self.get_field_value(idx).map(|f| format!("{}.{}", f.class_name, f.field_name))
    }

    /// Get variable name (or generate default)
    ///
    /// Variable names from our var_naming pass (JADX-compatible) are used as-is.
    /// These include valid short names like "i", "s", "sb", "str", "th" following Java conventions.
    /// Deobfuscation filtering is only applied to unknown/default names, not to our generated names.
    pub fn get_var_name(&self, reg: &RegisterArg) -> String {
        // First, try to use named variable from debug info or type inference
        // Trust names from var_naming pass - they are already JADX-compatible
        if let Some(name) = self.var_names.get(&(reg.reg_num, reg.ssa_version)) {
            return name.clone();
        }

        // No name from var_naming - use fallback
        // This typically means the variable wasn't properly analyzed
        format!("obj{}", reg.reg_num)
    }

    /// Get string by index (local cache first, then DEX provider)
    pub fn get_string_value(&self, idx: u32) -> Option<String> {
        self.strings.get(&idx).cloned()
            .or_else(|| self.dex_provider.as_ref().and_then(|p| p.get_string(idx)))
    }

    /// Get type name by index (local cache first, then DEX provider)
    pub fn get_type_value(&self, idx: u32) -> Option<String> {
        self.type_names.get(&idx).cloned()
            .or_else(|| self.dex_provider.as_ref().and_then(|p| p.get_type_name(idx)))
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
            // New JADX-compatible argument types
            InsnArg::Wrapped(wrapped) => {
                // For wrapped instructions, generate placeholder - actual expansion in code gen
                format!("/* wrapped:{} */", wrapped.insn_idx)
            }
            InsnArg::Named { name, .. } => name.clone(),
            InsnArg::This { class_type } => {
                if class_type.is_empty() {
                    "this".to_string()
                } else {
                    "this".to_string()
                }
            }
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
            // New JADX-compatible argument types
            InsnArg::Wrapped(wrapped) => {
                writer.add(&format!("/* wrapped:{} */", wrapped.insn_idx));
            }
            InsnArg::Named { name, .. } => {
                writer.add(name);
            }
            InsnArg::This { .. } => {
                writer.add("this");
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

    /// Try to resolve an integer literal as a resource ID (R.* field reference)
    /// Returns Some(ref) if resource replacement is enabled and the ID is found,
    /// None otherwise or if replacement is disabled
    fn try_resolve_resource(&self, value: i64) -> Option<String> {
        // Check if replacement is disabled
        if !self.replace_consts {
            return None;
        }

        // Only check valid resource ID range
        if value < 0 || value > u32::MAX as i64 {
            return None;
        }

        let res_id = value as u32;

        // Check if it's a resource ID (0x01xxxxxx or 0x7fxxxxxx)
        let package_id = (res_id >> 24) & 0xFF;
        if package_id != 0x01 && package_id != 0x7f {
            return None;
        }

        // Look up in resource map
        if let Some(res_name) = self.res_names.get(&res_id) {
            // res_name format: "layout/activity_main" or "id/button"
            let parts: Vec<&str> = res_name.split('/').collect();
            if parts.len() == 2 {
                let package_prefix = if package_id == 0x01 {
                    "android.R."  // Framework resource
                } else {
                    "R."  // App resource
                };
                return Some(format!("{}{}.{}", package_prefix, parts[0], parts[1]));
            }
        } else if package_id == 0x7f || package_id == 0x01 {
            // Looks like a resource ID but not found - add comment
            return Some(format!("{} /* Unknown resource */", format!("0x{:08x}", res_id)));
        }

        None
    }

    /// Generate literal expression
    pub fn gen_literal(&self, lit: &LiteralArg) -> String {
        match lit {
            LiteralArg::Int(v) => {
                // Check if this is a resource ID that should be replaced
                if let Some(res_ref) = self.try_resolve_resource(*v) {
                    return res_ref;
                }

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
                // Check if this is a resource ID that should be replaced
                if let Some(res_ref) = self.try_resolve_resource(*v) {
                    writer.add(&res_ref);
                    return;
                }

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
                // Handle both Java format (Object[]) and internal format ([Ljava/lang/Object;)
                let elem_name = if name.ends_with("[]") {
                    // Java format: strip trailing []
                    name.trim_end_matches("[]")
                } else {
                    // Internal format: [Ljava/lang/Object; -> java/lang/Object
                    name.trim_start_matches('[').trim_start_matches('L').trim_end_matches(';')
                };
                Some(format!("new {}[{}]", elem_name, size_str))
            }

            InsnType::FilledNewArray { type_idx, args, .. } => {
                let name = self.get_type_value(*type_idx)
                    .unwrap_or_else(|| format!("Type#{}", type_idx));
                // Type is array type, get element type
                // Handle both Java format (Object[]) and internal format ([Ljava/lang/Object;)
                let elem_name = if name.ends_with("[]") {
                    // Java format: strip trailing []
                    name.trim_end_matches("[]")
                } else {
                    // Internal format: [Ljava/lang/Object; -> java/lang/Object
                    name.trim_start_matches('[').trim_start_matches('L').trim_end_matches(';')
                };
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
                let obj_str = self.gen_arg(object);
                if let Some(info) = self.get_field_value(*field_idx) {
                    // Use "this." prefix explicitly like JADX when accessing own fields
                    if obj_str == "this" {
                        Some(format!("this.{}", info.field_name))
                    } else {
                        Some(format!("{}.{}", obj_str, info.field_name))
                    }
                } else {
                    Some(format!("{}.field#{}", obj_str, field_idx))
                }
            }

            InsnType::StaticGet { field_idx, .. } => {
                if let Some(info) = self.get_field_value(*field_idx) {
                    Some(format!("{}.{}", info.class_name, info.field_name))
                } else {
                    Some(format!("field#{}", field_idx))
                }
            }

            InsnType::Invoke { kind, method_idx, args, .. } => {
                let args_str: Vec<_> = args.iter()
                    .skip(if matches!(kind, InvokeKind::Static) { 0 } else { 1 }) // Skip 'this' for non-static
                    .map(|a| self.gen_arg(a))
                    .collect();

                if let Some(info) = self.get_method_value(*method_idx) {
                    let method_name = sanitize_method_name(&info.method_name);
                    match kind {
                        InvokeKind::Static => {
                            Some(format!("{}.{}({})", info.class_name, method_name, args_str.join(", ")))
                        }
                        InvokeKind::Virtual | InvokeKind::Interface | InvokeKind::Direct => {
                            let receiver = args.first().map(|a| self.gen_arg(a)).unwrap_or_default();
                            // Handle constructor calls: this.<init>() -> super()
                            if &*info.method_name == "<init>" {
                                if receiver == "this" {
                                    // Constructor calling super constructor
                                    Some(format!("super({})", args_str.join(", ")))
                                } else {
                                    // new SomeClass() - this is typically handled by NewInstance
                                    Some(format!("new {}({})", info.class_name, args_str.join(", ")))
                                }
                            } else if receiver == "this" {
                                Some(format!("{}({})", method_name, args_str.join(", ")))
                            } else {
                                Some(format!("{}.{}({})", receiver, method_name, args_str.join(", ")))
                            }
                        }
                        InvokeKind::Super => {
                            if &*info.method_name == "<init>" {
                                Some(format!("super({})", args_str.join(", ")))
                            } else {
                                Some(format!("super.{}({})", method_name, args_str.join(", ")))
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
                    UnaryOp::BoolNot => format!("!{}", maybe_paren(&arg_str)),
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

            InsnType::Compare { op, left, right, .. } => {
                // Compare returns int (-1, 0, 1), used for long/float/double comparisons
                // Use proper Java compare method based on type
                let left_str = self.gen_arg(left);
                let right_str = self.gen_arg(right);
                let method = compare_op_to_method(*op);
                Some(format!("{}({}, {})", method, left_str, right_str))
            }

            InsnType::CheckCast { object, type_idx } => {
                let name = self.get_type_value(*type_idx)
                    .unwrap_or_else(|| format!("Type#{}", type_idx));
                Some(format!("({}){}", name, self.gen_arg(object)))
            }

            InsnType::Ternary { condition, left, right, then_value, else_value, .. } => {
                let cond_str = self.gen_condition(*condition, left, right.as_ref());
                let then_str = self.gen_arg(then_value);
                let else_str = self.gen_arg(else_value);
                Some(format!("({}) ? {} : {}", cond_str, then_str, else_str))
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
                    UnaryOp::BoolNot => writer.add("!"),
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

            InsnType::Compare { op, left, right, .. } => {
                // Use proper Java compare method based on type
                writer.add(compare_op_to_method(*op)).add("(");
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
                // Use "this." prefix explicitly like JADX when accessing own fields
                let obj_str = self.gen_arg(object);
                if obj_str == "this" {
                    writer.add("this");
                } else {
                    self.write_arg(writer, object);
                }
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

            InsnType::Invoke { kind, method_idx, args, .. } => {
                // Skip 'this' arg for non-static methods
                let skip_receiver = !matches!(kind, InvokeKind::Static);

                if let Some(info) = self.get_method_value(*method_idx) {
                    let method_name = sanitize_method_name(&info.method_name);
                    match kind {
                        InvokeKind::Static => {
                            writer.add(&info.class_name).add(".").add(&method_name).add("(");
                            for (i, a) in args.iter().enumerate() {
                                if i > 0 { writer.add(", "); }
                                self.write_arg(writer, a);
                            }
                            writer.add(")");
                        }
                        InvokeKind::Virtual | InvokeKind::Interface | InvokeKind::Direct => {
                            if let Some(receiver) = args.first() {
                                let recv_name = self.gen_arg(receiver); // Need this for conditional logic
                                if &*info.method_name == "<init>" {
                                    if recv_name == "this" {
                                        writer.add("super(");
                                    } else {
                                        writer.add("new ").add(&info.class_name).add("(");
                                    }
                                } else if recv_name == "this" {
                                    writer.add(&method_name).add("(");
                                } else {
                                    self.write_arg(writer, receiver);
                                    writer.add(".").add(&method_name).add("(");
                                }
                            }
                            for (i, a) in args.iter().skip(if skip_receiver { 1 } else { 0 }).enumerate() {
                                if i > 0 { writer.add(", "); }
                                self.write_arg(writer, a);
                            }
                            writer.add(")");
                        }
                        InvokeKind::Super => {
                            if &*info.method_name == "<init>" {
                                writer.add("super(");
                            } else {
                                writer.add("super.").add(&method_name).add("(");
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
                // Type is array type, get element type
                // Handle both Java format (Object[]) and internal format ([Ljava/lang/Object;)
                let elem_name = if name.ends_with("[]") {
                    // Java format: strip trailing []
                    name.trim_end_matches("[]")
                } else {
                    // Internal format: [Ljava/lang/Object; -> java/lang/Object
                    name.trim_start_matches('[').trim_start_matches('L').trim_end_matches(';')
                };
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

            InsnType::Ternary { condition, left, right, then_value, else_value, .. } => {
                writer.add("(");
                let cond_str = self.gen_condition(*condition, left, right.as_ref());
                writer.add(&cond_str).add(") ? ");
                self.write_arg(writer, then_value);
                writer.add(" : ");
                self.write_arg(writer, else_value);
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

/// Compare operation to Java compare method
/// Maps DEX compare instructions to their Java equivalents:
/// - CmpLong -> Long.compare(a, b)
/// - CmplFloat/CmpgFloat -> Float.compare(a, b)
/// - CmplDouble/CmpgDouble -> Double.compare(a, b)
fn compare_op_to_method(op: CompareOp) -> &'static str {
    match op {
        CompareOp::CmpLong => "Long.compare",
        CompareOp::CmplFloat | CompareOp::CmpgFloat => "Float.compare",
        CompareOp::CmplDouble | CompareOp::CmpgDouble => "Double.compare",
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
#[cfg(test)]
fn escape_string(s: &str) -> String {
    escape_string_inner(s, false)
}

#[cfg(test)]
mod tests {
    use super::*;
    use dexterity_ir::instructions::ArrayElemType;

    /// Create an ExprGen for tests with deobfuscation disabled
    /// (don't rename short variable names like v0, v5)
    fn make_test_gen() -> ExprGen {
        let mut gen = ExprGen::new();
        gen.set_deobf_limits(0, 64);
        gen
    }

    #[test]
    fn test_literal_gen() {
        let gen = make_test_gen();
        assert_eq!(gen.gen_literal(&LiteralArg::Int(42)), "42");
        assert_eq!(gen.gen_literal(&LiteralArg::Int(5000000000)), "5000000000L");
        assert_eq!(gen.gen_literal(&LiteralArg::Null), "null");
    }

    #[test]
    fn test_var_name() {
        let mut gen = make_test_gen();
        gen.set_var_name(0, 1, "myVar".to_string());

        let reg = RegisterArg::with_ssa(0, 1);
        assert_eq!(gen.get_var_name(&reg), "myVar");

        // Unknown var gets default name based on type (Object -> obj)
        let reg2 = RegisterArg::with_ssa(5, 0);
        assert_eq!(gen.get_var_name(&reg2), "obj5");
    }

    #[test]
    fn test_binary_op() {
        let gen = make_test_gen();
        let insn = InsnType::Binary {
            dest: RegisterArg::new(0),
            op: BinaryOp::Add,
            left: InsnArg::reg(1),
            right: InsnArg::reg(2),
        };
        assert_eq!(gen.gen_insn(&insn), Some("obj1 + obj2".to_string()));
    }

    #[test]
    fn test_unary_op() {
        let gen = make_test_gen();
        let insn = InsnType::Unary {
            dest: RegisterArg::new(0),
            op: UnaryOp::Neg,
            arg: InsnArg::reg(1),
        };
        assert_eq!(gen.gen_insn(&insn), Some("-obj1".to_string()));
    }

    #[test]
    fn test_array_access() {
        let gen = make_test_gen();
        let insn = InsnType::ArrayGet {
            dest: RegisterArg::new(0),
            array: InsnArg::reg(1),
            index: InsnArg::reg(2),
            elem_type: ArrayElemType::Int,
        };
        assert_eq!(gen.gen_insn(&insn), Some("obj1[obj2]".to_string()));
    }

    #[test]
    fn test_condition() {
        let gen = make_test_gen();
        let cond = gen.gen_condition(
            IfCondition::Eq,
            &InsnArg::reg(0),
            Some(&InsnArg::reg(1))
        );
        assert_eq!(cond, "obj0 == obj1");
    }

    #[test]
    fn test_escape_string() {
        assert_eq!(escape_string("hello"), "hello");
        assert_eq!(escape_string("say \"hi\""), "say \\\"hi\\\"");
        assert_eq!(escape_string("line1\nline2"), "line1\\nline2");
    }

    // Deboxing tests
    #[test]
    fn test_boxing_type_detection() {
        // Test Integer.valueOf(int)
        let int_method = MethodInfo {
            class_name: "Integer".into(),
            class_type: "java/lang/Integer".into(),
            method_name: "valueOf".into(),
            return_type: ArgType::Object("Ljava/lang/Integer;".to_string()),
            param_types: vec![ArgType::Int],
            is_varargs: None,
        };
        assert_eq!(BoxingType::from_method(&int_method), Some(BoxingType::Integer));

        // Test Boolean.valueOf(boolean)
        let bool_method = MethodInfo {
            class_name: "Boolean".into(),
            class_type: "java/lang/Boolean".into(),
            method_name: "valueOf".into(),
            return_type: ArgType::Object("Ljava/lang/Boolean;".to_string()),
            param_types: vec![ArgType::Boolean],
            is_varargs: None,
        };
        assert_eq!(BoxingType::from_method(&bool_method), Some(BoxingType::Boolean));

        // Test Long.valueOf(long)
        let long_method = MethodInfo {
            class_name: "Long".into(),
            class_type: "java/lang/Long".into(),
            method_name: "valueOf".into(),
            return_type: ArgType::Object("Ljava/lang/Long;".to_string()),
            param_types: vec![ArgType::Long],
            is_varargs: None,
        };
        assert_eq!(BoxingType::from_method(&long_method), Some(BoxingType::Long));

        // Test non-boxing method
        let other_method = MethodInfo {
            class_name: "String".into(),
            class_type: "java/lang/String".into(),
            method_name: "valueOf".into(),
            return_type: ArgType::Object("Ljava/lang/String;".to_string()),
            param_types: vec![ArgType::Int],
            is_varargs: None,
        };
        assert_eq!(BoxingType::from_method(&other_method), None);

        // Test wrong method name
        let parse_method = MethodInfo {
            class_name: "Integer".into(),
            class_type: "java/lang/Integer".into(),
            method_name: "parseInt".into(),
            return_type: ArgType::Int,
            param_types: vec![ArgType::Object("Ljava/lang/String;".to_string())],
            is_varargs: None,
        };
        assert_eq!(BoxingType::from_method(&parse_method), None);
    }

    #[test]
    fn test_boxing_type_format_literal() {
        // Integer: just the number
        assert_eq!(BoxingType::Integer.format_literal(42), "42");
        assert_eq!(BoxingType::Integer.format_literal(-1), "-1");

        // Boolean: true/false
        assert_eq!(BoxingType::Boolean.format_literal(0), "false");
        assert_eq!(BoxingType::Boolean.format_literal(1), "true");
        assert_eq!(BoxingType::Boolean.format_literal(5), "true"); // non-zero is true

        // Byte: with cast
        assert_eq!(BoxingType::Byte.format_literal(127), "(byte) 127");
        assert_eq!(BoxingType::Byte.format_literal(2), "(byte) 2");

        // Short: with cast
        assert_eq!(BoxingType::Short.format_literal(32767), "(short) 32767");
        assert_eq!(BoxingType::Short.format_literal(3), "(short) 3");

        // Character: as char literal
        assert_eq!(BoxingType::Character.format_literal(99), "'c'"); // 'c' = 99
        assert_eq!(BoxingType::Character.format_literal(65), "'A'"); // 'A' = 65
        // Non-printable uses unicode escape
        assert_eq!(BoxingType::Character.format_literal(0), "'\\u0000'");
        // Special chars use unicode escape
        assert_eq!(BoxingType::Character.format_literal(0x27), "'\\u0027'"); // single quote

        // Long: with L suffix
        assert_eq!(BoxingType::Long.format_literal(4), "4L");
        assert_eq!(BoxingType::Long.format_literal(9000000000i64), "9000000000L");
    }

    #[test]
    fn test_get_literal_int_value() {
        // Integer literal
        let lit_arg = InsnArg::Literal(LiteralArg::Int(42));
        assert_eq!(get_literal_int_value(&lit_arg), Some(42));

        // Register arg (not a literal)
        let reg_arg = InsnArg::reg(0);
        assert_eq!(get_literal_int_value(&reg_arg), None);

        // Null literal (not an int)
        let null_arg = InsnArg::Literal(LiteralArg::Null);
        assert_eq!(get_literal_int_value(&null_arg), None);
    }
}
