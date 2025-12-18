//! Information types (class info, method info, etc.)
//!
//! These types hold metadata about classes and methods during decompilation.
//!
//! ## Lazy Loading (like Java JADX)
//!
//! To minimize memory usage, method instructions are loaded on-demand:
//!
//! ```text
//! NOT_LOADED → LOADED → PROCESS_COMPLETE → UNLOADED
//! ```
//!
//! - `NOT_LOADED`: Only metadata stored (name, signature, bytecode reference)
//! - `LOADED`: Instructions decoded from bytecode
//! - `PROCESS_COMPLETE`: Analysis passes complete
//! - `UNLOADED`: Instructions dropped, only generated code remains
//!
//! This allows processing large APKs with bounded memory by loading
//! methods only when needed and unloading immediately after code generation.

use crate::instructions::InsnNode;
use crate::types::ArgType;
use crate::kotlin_metadata::KotlinMetadata;

/// A generic type parameter declaration (e.g., T, E extends Number)
/// Used for method-level type parameters like `<T extends Comparable<T>>`
#[derive(Debug, Clone)]
pub struct TypeParameter {
    /// The name of the type parameter (e.g., "T", "E", "K", "V")
    pub name: String,
    /// The bounds (extends constraints). Empty means extends Object implicitly.
    /// Multiple bounds means T extends A & B & C
    pub bounds: Vec<ArgType>,
}

/// Processing state for classes and methods (mirrors Java JADX's ProcessState)
///
/// This enables lazy loading: load instructions on-demand, unload after codegen.
#[derive(Debug, Clone, Copy, PartialEq, Eq, Default)]
pub enum ProcessState {
    /// Not yet loaded - only metadata available, bytecode not decoded
    #[default]
    NotLoaded,
    /// Loaded - instructions decoded and available
    Loaded,
    /// Processing started - analysis passes running
    ProcessStarted,
    /// Processing complete - ready for code generation
    ProcessComplete,
    /// Generated and unloaded - code written, memory freed
    GeneratedAndUnloaded,
}

impl ProcessState {
    /// Check if processing is complete (either still loaded or already unloaded)
    pub fn is_process_complete(&self) -> bool {
        matches!(self, ProcessState::ProcessComplete | ProcessState::GeneratedAndUnloaded)
    }

    /// Check if instructions are currently available
    pub fn is_loaded(&self) -> bool {
        matches!(self, ProcessState::Loaded | ProcessState::ProcessStarted | ProcessState::ProcessComplete)
    }
}

/// Loading stage for dependency-aware processing (mirrors JADX's LoadStage)
///
/// This tracks whether dependencies have been loaded, enabling staged processing:
/// - ProcessStage: Class loaded but dependencies may not be
/// - CodegenStage: All dependencies loaded, ready for code generation
#[derive(Debug, Clone, Copy, PartialEq, Eq, Default)]
pub enum LoadStage {
    /// No loading stage set yet
    #[default]
    None,
    /// Process stage - class is being processed, dependencies may not be loaded yet
    ProcessStage,
    /// Codegen stage - all dependencies loaded, ready for code generation
    CodegenStage,
}

impl LoadStage {
    /// Check if we're at codegen stage (all dependencies available)
    pub fn is_codegen_ready(&self) -> bool {
        matches!(self, LoadStage::CodegenStage)
    }
}

/// Reference to bytecode in DEX file for lazy loading
///
/// Instead of storing decoded instructions upfront, we store this lightweight
/// reference and decode only when needed. This is the key to JADX's memory efficiency.
#[derive(Debug, Clone)]
pub struct BytecodeRef {
    /// DEX file index (for multi-DEX APKs)
    pub dex_idx: u32,
    /// Method index within the DEX file
    pub method_idx: u32,
    /// Bytecode offset within the DEX file (for direct access)
    pub code_offset: u64,
    /// Number of code units (2 bytes each)
    pub insns_count: u32,
    /// Register count
    pub regs_count: u16,
    /// Input parameter count
    pub ins_count: u16,
    /// Output count
    pub outs_count: u16,
}

/// An annotation with its type and element values
#[derive(Debug, Clone)]
pub struct Annotation {
    /// Annotation type (e.g., "java/lang/Override", "java/lang/Deprecated")
    pub annotation_type: String,
    /// Annotation visibility (build, runtime, system)
    pub visibility: AnnotationVisibility,
    /// Element name-value pairs
    pub elements: Vec<AnnotationElement>,
}

impl Annotation {
    /// Create a new annotation with the given type
    pub fn new(annotation_type: String, visibility: AnnotationVisibility) -> Self {
        Annotation {
            annotation_type,
            visibility,
            elements: Vec::new(),
        }
    }

    /// Get the simple name of this annotation (e.g., "Override" from "java/lang/Override")
    pub fn simple_name(&self) -> &str {
        self.annotation_type.rsplit('/').next().unwrap_or(&self.annotation_type)
    }

    /// Check if this is a standard annotation that should be emitted
    pub fn should_emit(&self) -> bool {
        // Only emit runtime-visible annotations by default
        matches!(self.visibility, AnnotationVisibility::Runtime | AnnotationVisibility::System)
    }
}

/// Annotation visibility
#[derive(Debug, Clone, Copy, PartialEq, Eq)]
pub enum AnnotationVisibility {
    /// Build-time only (not visible at runtime)
    Build,
    /// Visible at runtime via reflection
    Runtime,
    /// System annotation (visible to runtime, but not user code)
    System,
}

/// An annotation element (name-value pair)
#[derive(Debug, Clone)]
pub struct AnnotationElement {
    /// Element name
    pub name: String,
    /// Element value
    pub value: AnnotationValue,
}

/// Annotation element value
#[derive(Debug, Clone)]
pub enum AnnotationValue {
    /// Byte value
    Byte(i8),
    /// Short value
    Short(i16),
    /// Char value
    Char(u16),
    /// Int value
    Int(i32),
    /// Long value
    Long(i64),
    /// Float value
    Float(f32),
    /// Double value
    Double(f64),
    /// String value
    String(String),
    /// Type reference (class literal)
    Type(String),
    /// Enum constant (class name, field name)
    Enum(String, String),
    /// Nested annotation
    Annotation(Box<Annotation>),
    /// Array of values
    Array(Vec<AnnotationValue>),
    /// Boolean value
    Boolean(bool),
    /// Null
    Null,
}

/// Method inline attribute - stores info for inlining synthetic bridge methods
#[derive(Debug, Clone)]
pub enum MethodInlineAttr {
    /// Method should not be inlined
    NotNeeded,
    /// Method can be inlined - replace invokes with field get
    FieldGet {
        /// Field index to get
        field_idx: u32,
        /// Is instance field (vs static)
        is_instance: bool,
    },
    /// Method can be inlined - replace invokes with field set
    FieldSet {
        /// Field index to set
        field_idx: u32,
        /// Is instance field (vs static)
        is_instance: bool,
    },
    /// Method can be inlined - replace invokes with method call
    MethodCall {
        /// Method index to call
        method_idx: u32,
    },
}

/// Method information and IR
///
/// Supports lazy loading like Java JADX's MethodNode:
/// - `bytecode_ref`: Lightweight reference to bytecode (always present if has code)
/// - `insn_indices`: Indices into ClassData.all_instructions (populated when load() is called)
/// - After codegen, call unload() to free the indices
/// - Instructions live in ClassData.all_instructions (shared across all methods/blocks)
#[derive(Debug, Clone, Default)]
pub struct MethodData {
    /// Method name
    pub name: String,
    /// Alias name (from deobfuscation or mapping file)
    pub alias: Option<String>,
    /// Access flags
    pub access_flags: u32,
    /// Return type
    pub return_type: ArgType,
    /// Parameter types
    pub arg_types: Vec<ArgType>,
    /// Parameter names from debug info (None = no debug info)
    pub arg_names: Vec<Option<String>>,
    /// Generic type parameters (e.g., <T, E extends Number>)
    /// Parsed from dalvik.annotation.Signature
    pub type_parameters: Vec<TypeParameter>,
    /// Register count
    pub regs_count: u16,
    /// Input parameter count (includes 'this' for instance methods)
    pub ins_count: u16,
    /// Output count
    pub outs_count: u16,
    /// Processing state for lazy loading
    pub state: ProcessState,
    /// Reference to bytecode for lazy loading (None for abstract/native methods)
    pub bytecode_ref: Option<BytecodeRef>,
    /// Instruction indices into ClassData.all_instructions (NEW: shared pool pattern)
    /// Empty when not loaded, populated when load() is called.
    /// This eliminates cloning by storing indices instead of full InsnNode copies.
    pub insn_indices: Vec<u32>,
    /// Instructions - None when not loaded, Some when loaded (DEPRECATED: kept for compatibility)
    /// Use insn_indices + ClassData.all_instructions instead
    /// Remove this field after full migration to index-based blocks
    pub instructions: Option<Vec<InsnNode>>,
    /// Try-catch blocks
    pub try_blocks: Vec<TryBlock>,
    /// Debug info (line numbers, local variables)
    pub debug_info: Option<DebugInfo>,
    /// Annotations on this method
    pub annotations: Vec<Annotation>,
    /// Method inline attribute (for synthetic bridge methods)
    pub inline_attr: Option<MethodInlineAttr>,
    /// Annotation default value (for annotation interface methods)
    /// Parsed from dalvik/annotation/AnnotationDefault class-level annotation
    /// Used to emit "default <value>" in method declarations
    pub annotation_default: Option<AnnotationValue>,

    // === JADX Parity: Method Analysis Fields ===
    /// 'this' argument register for instance methods (like JADX's MethodNode.thisArg)
    /// Format: (register_number, ssa_version)
    /// None for static methods
    pub this_arg: Option<(u16, u32)>,
    /// List of argument registers (like JADX's MethodNode.argsList)
    /// Format: Vec<(register_number, ssa_version)>
    pub args_list: Vec<(u16, u32)>,
    /// Entry block ID (like JADX's MethodNode.enterBlock)
    pub enter_block: Option<u32>,
    /// Exit block ID (like JADX's MethodNode.exitBlock)
    pub exit_block: Option<u32>,
    /// Methods which use this method (like JADX's MethodNode.useIn)
    /// Format: (class_type, method_name) tuples
    pub use_in: Vec<(String, String)>,
}

impl MethodData {
    /// Create a new method data (starts in NotLoaded state)
    pub fn new(name: String, access_flags: u32, return_type: ArgType) -> Self {
        MethodData {
            name,
            alias: None,
            access_flags,
            return_type,
            arg_types: Vec::new(),
            arg_names: Vec::new(),
            type_parameters: Vec::new(),
            regs_count: 0,
            ins_count: 0,
            outs_count: 0,
            state: ProcessState::NotLoaded,
            bytecode_ref: None,
            insn_indices: Vec::new(),  // NEW: empty until load() is called
            instructions: None,
            try_blocks: Vec::new(),
            debug_info: None,
            annotations: Vec::new(),
            inline_attr: None,
            annotation_default: None,
            // JADX parity fields
            this_arg: None,
            args_list: Vec::new(),
            enter_block: None,
            exit_block: None,
            use_in: Vec::new(),
        }
    }

    /// Create a method with pre-loaded instructions (for backwards compatibility)
    ///
    /// This creates a method in Loaded state with instructions already decoded.
    /// Used during the transition period; new code should use lazy loading.
    pub fn new_with_instructions(
        name: String,
        access_flags: u32,
        return_type: ArgType,
        instructions: Vec<InsnNode>,
    ) -> Self {
        MethodData {
            name,
            alias: None,
            access_flags,
            return_type,
            arg_types: Vec::new(),
            arg_names: Vec::new(),
            type_parameters: Vec::new(),
            regs_count: 0,
            ins_count: 0,
            outs_count: 0,
            state: ProcessState::Loaded,
            bytecode_ref: None,
            insn_indices: Vec::new(),  // NEW: empty when using old-style instructions field
            instructions: Some(instructions),
            try_blocks: Vec::new(),
            debug_info: None,
            annotations: Vec::new(),
            inline_attr: None,
            annotation_default: None,
            // JADX parity fields
            this_arg: None,
            args_list: Vec::new(),
            enter_block: None,
            exit_block: None,
            use_in: Vec::new(),
        }
    }

    /// Unload instruction array early (like Java JADX's MethodNode.unloadInsnArr())
    ///
    /// Call this after block splitting. The instruction array is freed while blocks
    /// retain their references. This saves ~2GB per large method before SSA/type inference.
    ///
    /// Note: This still keeps try_blocks and other metadata for further analysis.
    /// Call unload() after codegen to free everything.
    pub fn unload_instruction_array(&mut self) {
        if self.state == ProcessState::NotLoaded || self.state == ProcessState::GeneratedAndUnloaded {
            return;
        }
        self.instructions = None;  // Free the main instruction vector
        // Keep try_blocks for now - they're still useful during analysis
        self.insn_indices.clear();  // Free indices if using shared pool
        self.insn_indices.shrink_to_fit();
    }

    /// Unload instructions to free memory (like Java JADX's MethodNode.unload())
    ///
    /// Call this after code generation to release memory. The method metadata
    /// (name, signature, annotations) is retained for cross-reference resolution.
    pub fn unload(&mut self) {
        if self.state == ProcessState::NotLoaded || self.state == ProcessState::GeneratedAndUnloaded {
            return;
        }
        // Free both old and new instruction storage
        self.instructions = None;  // Old style (deprecated)
        self.insn_indices.clear();  // NEW: Free indices into shared pool
        self.insn_indices.shrink_to_fit();
        // Free try blocks (they reference instruction offsets, useless without instructions)
        self.try_blocks.clear();
        self.try_blocks.shrink_to_fit();
        // Keep debug_info - it's small and useful for stack traces
        // Keep annotations - they're part of the class API
        self.state = ProcessState::GeneratedAndUnloaded;
    }

    /// Check if instructions are currently loaded and available
    pub fn is_loaded(&self) -> bool {
        self.instructions.is_some()
    }

    /// Get instructions, returns empty slice if not loaded
    ///
    /// Use `is_loaded()` to check first, or `instructions()` for Option.
    /// Returns empty slice instead of panicking for robustness with lazy loading.
    pub fn get_instructions(&self) -> &[InsnNode] {
        self.instructions.as_ref()
            .map(|v| v.as_slice())
            .unwrap_or(&[])  // Return empty slice if not loaded (lazy loading pattern)
    }

    /// Get instructions as Option (doesn't panic)
    pub fn instructions(&self) -> Option<&[InsnNode]> {
        self.instructions.as_ref().map(|v| v.as_slice())
    }

    /// Get mutable instructions, panics if not loaded
    pub fn get_instructions_mut(&mut self) -> &mut Vec<InsnNode> {
        self.instructions.as_mut()
            .expect("Method instructions not loaded - call load() first")
    }

    /// Set instructions (marks method as Loaded)
    pub fn set_instructions(&mut self, instructions: Vec<InsnNode>) {
        self.instructions = Some(instructions);
        self.state = ProcessState::Loaded;
    }

    /// Load instructions from bytecode reference (lazy loading)
    ///
    /// This is the key to JADX-style memory efficiency: instructions are stored
    /// on disk (via BytecodeRef) and only decoded when actually needed.
    ///
    /// IMPORTANT: The actual loading should happen in the caller (converter/main)
    /// that has access to dexterity_dex parsing functions. This method is a placeholder
    /// for the lazy loading pattern. Real implementation decodes instructions from
    /// the bytecode stored in bytecode_ref.
    ///
    /// For now, this is a no-op since instructions are loaded in converter before
    /// the class is returned. In a full lazy loading implementation, this would
    /// decode instructions from bytecode_ref on-demand.
    pub fn load(&mut self, _dex_bytes: &[u8]) -> Result<(), String> {
        // Already loaded
        if self.is_loaded() {
            return Ok(());
        }

        // No bytecode to load (abstract method, native, etc.)
        let Some(_bytecode_ref) = &self.bytecode_ref else {
            return Ok(());
        };

        // TODO: Implement actual lazy loading by decoding instructions from bytecode_ref
        // For now, instructions should be loaded by the converter before returning the class
        Ok(())
    }

    /// Get the display name (alias if set, otherwise original name)
    pub fn display_name(&self) -> &str {
        self.alias.as_deref().unwrap_or(&self.name)
    }

    /// Check if this is a static method
    pub fn is_static(&self) -> bool {
        self.access_flags & 0x0008 != 0
    }

    /// Check if this is a constructor
    pub fn is_constructor(&self) -> bool {
        self.name == "<init>"
    }

    /// Check if this is a static initializer
    pub fn is_class_init(&self) -> bool {
        self.name == "<clinit>"
    }

    /// Check if this is an abstract method
    pub fn is_abstract(&self) -> bool {
        self.access_flags & 0x0400 != 0
    }

    /// Check if this is a native method
    pub fn is_native(&self) -> bool {
        self.access_flags & 0x0100 != 0
    }

    /// Check if this is a synthetic method
    pub fn is_synthetic(&self) -> bool {
        self.access_flags & 0x1000 != 0
    }

    /// Check if this is a bridge method
    pub fn is_bridge(&self) -> bool {
        self.access_flags & 0x0040 != 0
    }

    /// Check if this method is a candidate for inlining (synthetic/bridge methods)
    pub fn is_inline_candidate(&self) -> bool {
        // Synthetic methods (access$XXX patterns) or bridge methods
        (self.is_synthetic() || self.is_bridge() || self.name.starts_with("access$"))
            && !self.is_constructor()
            && !self.is_class_init()
    }

    /// Get the number of parameters (excluding 'this')
    pub fn param_count(&self) -> usize {
        self.arg_types.len()
    }

    /// Get the first register used for parameters
    pub fn first_arg_reg(&self) -> u16 {
        self.regs_count.saturating_sub(self.ins_count)
    }

    // === JADX Parity: Method Analysis Methods ===

    /// Set the 'this' argument register (like JADX's MethodNode.setThisArg)
    /// Call this during SSA construction for instance methods
    pub fn set_this_arg(&mut self, reg_num: u16, ssa_version: u32) {
        self.this_arg = Some((reg_num, ssa_version));
    }

    /// Get the 'this' argument register
    pub fn get_this_arg(&self) -> Option<(u16, u32)> {
        self.this_arg
    }

    /// Add an argument register to the arguments list (like JADX's MethodNode.addArg)
    pub fn add_arg(&mut self, reg_num: u16, ssa_version: u32) {
        self.args_list.push((reg_num, ssa_version));
    }

    /// Set all argument registers at once
    pub fn set_args_list(&mut self, args: Vec<(u16, u32)>) {
        self.args_list = args;
    }

    /// Set the entry block ID (like JADX's MethodNode.setEnterBlock)
    pub fn set_enter_block(&mut self, block_id: u32) {
        self.enter_block = Some(block_id);
    }

    /// Set the exit block ID (like JADX's MethodNode.setExitBlock)
    pub fn set_exit_block(&mut self, block_id: u32) {
        self.exit_block = Some(block_id);
    }

    /// Add a method that uses this method (like JADX's MethodNode.addUseIn)
    pub fn add_use_in(&mut self, class_type: String, method_name: String) {
        let entry = (class_type, method_name);
        if !self.use_in.contains(&entry) {
            self.use_in.push(entry);
        }
    }

    /// Check if this method is used by other methods
    pub fn has_usages(&self) -> bool {
        !self.use_in.is_empty()
    }
}

/// Try-catch block information (basic structure for initial parsing from DEX)
#[derive(Debug, Clone)]
pub struct TryBlock {
    /// Start offset (code units)
    pub start_addr: u32,
    /// End offset (code units, exclusive)
    pub end_addr: u32,
    /// Exception handlers
    pub handlers: Vec<ExceptionHandler>,
}

/// Exception handler (basic structure for initial parsing from DEX)
#[derive(Debug, Clone)]
pub struct ExceptionHandler {
    /// Exception type (None for catch-all)
    pub exception_type: Option<String>,
    /// Handler address (code units)
    pub handler_addr: u32,
}

/// Try-catch block attribute for CFG processing (matches JADX's TryCatchBlockAttr)
///
/// This enhanced structure is created during exception handler processing and provides
/// complete information about try-catch regions including nesting, block lists, and
/// synthetic splitter blocks for proper control flow.
#[derive(Debug, Clone)]
pub struct TryCatchBlockAttr {
    /// Unique identifier for this try-catch block
    pub id: u32,
    /// Exception handlers for this try block
    pub handlers: Vec<EnhancedExceptionHandler>,
    /// Block IDs in the try region
    pub try_block_ids: Vec<u32>,
    /// Inner (nested) try-catch blocks
    pub inner_try_blocks: Vec<u32>,  // IDs of nested TryCatchBlockAttr
    /// Outer (parent) try-catch block (None if top-level)
    pub outer_try_block: Option<u32>,  // ID of parent TryCatchBlockAttr
    /// Top splitter block ID (synthetic block connecting try entry and handler entry)
    pub top_splitter: Option<u32>,
    /// Bottom splitter block ID (synthetic block connecting handler exit and continuation)
    pub bottom_splitter: Option<u32>,
}

impl TryCatchBlockAttr {
    /// Create a new try-catch block attribute
    pub fn new(id: u32) -> Self {
        TryCatchBlockAttr {
            id,
            handlers: Vec::new(),
            try_block_ids: Vec::new(),
            inner_try_blocks: Vec::new(),
            outer_try_block: None,
            top_splitter: None,
            bottom_splitter: None,
        }
    }

    /// Add a handler to this try-catch block
    pub fn add_handler(&mut self, handler: EnhancedExceptionHandler) {
        self.handlers.push(handler);
    }

    /// Add a block to the try region
    pub fn add_try_block(&mut self, block_id: u32) {
        if !self.try_block_ids.contains(&block_id) {
            self.try_block_ids.push(block_id);
        }
    }

    /// Add a nested try-catch block
    pub fn add_inner_try_block(&mut self, inner_id: u32) {
        if !self.inner_try_blocks.contains(&inner_id) {
            self.inner_try_blocks.push(inner_id);
        }
    }
}

/// Enhanced exception handler with full block and type information
///
/// This matches JADX's ExceptionHandler class and provides complete information
/// about the handler region, caught exception types, and exception variable.
#[derive(Debug, Clone)]
pub struct EnhancedExceptionHandler {
    /// Handler start block ID
    pub handler_block: u32,
    /// All block IDs that are part of this handler
    pub handler_block_ids: Vec<u32>,
    /// Exception types caught by this handler (multi-catch support)
    /// Empty Vec means catch-all
    pub catch_types: Vec<String>,
    /// Register number for the exception variable (from MOVE_EXCEPTION)
    pub exception_reg: Option<u16>,
    /// Exception variable name (from debug info or generated)
    pub exception_var_name: Option<String>,
}

impl EnhancedExceptionHandler {
    /// Create a new enhanced exception handler
    pub fn new(handler_block: u32) -> Self {
        EnhancedExceptionHandler {
            handler_block,
            handler_block_ids: vec![handler_block],
            catch_types: Vec::new(),
            exception_reg: None,
            exception_var_name: None,
        }
    }

    /// Add a caught exception type
    pub fn add_catch_type(&mut self, exception_type: String) {
        if !self.catch_types.contains(&exception_type) {
            self.catch_types.push(exception_type);
        }
    }

    /// Add a block to this handler region
    pub fn add_handler_block(&mut self, block_id: u32) {
        if !self.handler_block_ids.contains(&block_id) {
            self.handler_block_ids.push(block_id);
        }
    }

    /// Check if this is a catch-all handler
    pub fn is_catch_all(&self) -> bool {
        self.catch_types.is_empty()
    }

    /// Check if this handler can be merged with another (same handler block)
    pub fn can_merge_with(&self, other: &EnhancedExceptionHandler) -> bool {
        // Can merge if they flow to the same block and don't overlap exception types
        self.handler_block == other.handler_block
            && self.catch_types.iter().all(|t1| !other.catch_types.contains(t1))
    }

    /// Merge another handler into this one (for multi-catch)
    pub fn merge(&mut self, other: EnhancedExceptionHandler) {
        // Merge catch types
        for catch_type in other.catch_types {
            self.add_catch_type(catch_type);
        }
        // Merge handler blocks
        for block_id in other.handler_block_ids {
            self.add_handler_block(block_id);
        }
        // Keep first exception variable if not set
        if self.exception_reg.is_none() && other.exception_reg.is_some() {
            self.exception_reg = other.exception_reg;
            self.exception_var_name = other.exception_var_name;
        }
    }
}

/// Debug information for a method
#[derive(Debug, Clone, Default)]
pub struct DebugInfo {
    /// Line number entries (address -> line number)
    pub line_numbers: Vec<(u32, u32)>,
    /// Local variable entries
    pub local_vars: Vec<LocalVar>,
    /// Whether line numbers are reliable (JADX USE_LINES_HINTS flag)
    /// Set to true if:
    /// - min_line > 3 (not adjusted)
    /// - repeating_lines <= 3 (allows for-loop indexing)
    pub lines_valid: bool,
}

/// Local variable debug info (JADX ILocalVar parity)
#[derive(Debug, Clone)]
pub struct LocalVar {
    /// Variable name
    pub name: String,
    /// Variable type descriptor (e.g., "Ljava/lang/String;")
    pub type_desc: String,
    /// Generic type signature (e.g., "Ljava/util/List<Ljava/lang/String;>;")
    /// Used for generic type expansion
    pub signature: Option<String>,
    /// Register number
    pub reg: u16,
    /// Start address (code units). -1 (u32::MAX) indicates a method parameter
    pub start_addr: u32,
    /// End address (code units)
    pub end_addr: u32,
    /// Whether this variable is a method parameter
    pub is_parameter: bool,
    /// Whether the variable scope has been finalized (DBG_END_LOCAL seen)
    pub is_end: bool,
}

impl LocalVar {
    /// Create a new LocalVar with default flags
    pub fn new(name: String, type_desc: String, reg: u16, start_addr: u32, end_addr: u32) -> Self {
        LocalVar {
            name,
            type_desc,
            signature: None,
            reg,
            start_addr,
            end_addr,
            is_parameter: false,
            is_end: false,
        }
    }

    /// Create a LocalVar for a method parameter
    pub fn parameter(name: String, type_desc: String, reg: u16) -> Self {
        LocalVar {
            name,
            type_desc,
            signature: None,
            reg,
            start_addr: u32::MAX, // -1 equivalent, marks as parameter
            end_addr: u32::MAX,
            is_parameter: true,
            is_end: false,
        }
    }

    /// Mark this variable as ended (scope finalized)
    pub fn mark_end(&mut self, addr: u32) {
        self.end_addr = addr;
        self.is_end = true;
    }

    /// Check if this variable is active at the given address
    pub fn is_active_at(&self, addr: u32) -> bool {
        if self.is_parameter {
            // Parameters are always active throughout the method
            true
        } else {
            addr >= self.start_addr && addr <= self.end_addr
        }
    }
}

/// Kotlin-specific class markers parsed from @kotlin.Metadata annotation
#[derive(Debug, Clone, Default)]
pub struct KotlinClassInfo {
    /// True if this is a Kotlin data class
    pub is_data_class: bool,
    /// True if this is a sealed class
    pub is_sealed: bool,
    /// True if this is an inline/value class
    pub is_inline: bool,
    /// True if this is a companion object
    pub is_companion: bool,
    /// Custom companion object name (if not "Companion")
    pub companion_name: Option<String>,
    /// Sealed class subclass FQ names
    pub sealed_subclasses: Vec<String>,
}

/// Class information
///
/// Supports lazy loading like Java JADX's ClassNode.
/// Call `unload()` after code generation to free method instructions.
#[derive(Debug, Clone)]
pub struct ClassData {
    /// Class type descriptor (e.g., "Lcom/example/Foo;")
    pub class_type: String,
    /// Alias name (from deobfuscation or mapping file)
    pub alias: Option<String>,
    /// Package alias (from deobfuscation or mapping file)
    pub pkg_alias: Option<String>,
    /// Access flags
    pub access_flags: u32,
    /// Superclass type (None for java/lang/Object)
    pub superclass: Option<String>,
    /// Superclass with full type information including generics
    /// Parsed from dalvik.annotation.Signature - like JADX's ClassNode.superClass ArgType
    /// Falls back to wrapping superclass String as ArgType::Object if no signature
    pub superclass_type: Option<ArgType>,
    /// Implemented interfaces with full type information (including generics)
    /// Parsed from DEX and enhanced by Signature annotation - like JADX's ClassNode.interfaces
    pub interfaces: Vec<ArgType>,
    /// Generic type parameters (e.g., <T, E extends Number>)
    /// Parsed from dalvik.annotation.Signature - like JADX's ClassNode.generics
    pub type_parameters: Vec<TypeParameter>,
    /// Source file name
    pub source_file: Option<String>,
    /// DEX file name this class was loaded from (e.g., "classes.dex", "classes2.dex")
    pub dex_name: Option<String>,
    /// Processing state for lazy loading
    pub state: ProcessState,
    /// Loading stage for dependency-aware processing (like JADX's LoadStage)
    pub load_stage: LoadStage,
    /// Methods
    pub methods: Vec<MethodData>,
    /// Static fields
    pub static_fields: Vec<FieldData>,
    /// Instance fields
    pub instance_fields: Vec<FieldData>,
    /// Annotations on this class
    pub annotations: Vec<Annotation>,
    /// NEW: Shared instruction pool for all methods/blocks (index-based block splitting)
    /// Instead of cloning instructions into each block, we store them once here and
    /// reference by index. Methods store Vec<u32> insn_indices, BasicBlocks store Vec<u32> insn_indices.
    /// This eliminates the 5-20x memory cloning that happens during block splitting.
    /// Reduces peak per-class memory from 7-12 GB to ~2-3 GB.
    pub all_instructions: Vec<InsnNode>,
    pub kotlin_metadata: Option<KotlinMetadata>,
    /// Kotlin-specific class information (data class, sealed, etc.)
    pub kotlin_class_info: Option<KotlinClassInfo>,

    // === JADX Parity: Inner Class Support ===
    /// Inner classes defined within this class (like JADX's ClassNode.innerClasses)
    /// Stores class type descriptors of inner classes
    pub inner_classes: Vec<String>,
    /// Parent class for inner classes (like JADX's ClassNode.parentClass)
    /// None for top-level classes, Some(parent_type) for inner classes
    pub parent_class: Option<String>,
    /// Classes that have been inlined into this class (like JADX's ClassNode.inlinedClasses)
    /// Used for anonymous inner class inlining
    pub inlined_classes: Vec<String>,

    // === JADX Parity: Dependency Tracking ===
    /// Top-level classes used by this class (like JADX's ClassNode.dependencies)
    /// Only populated for top-level classes. Used for load ordering.
    pub dependencies: Vec<String>,
    /// Classes needed at code generation stage (like JADX's ClassNode.codegenDeps)
    /// These must be fully loaded before this class can generate code.
    pub codegen_deps: Vec<String>,

    // === JADX Parity: Usage Tracking ===
    /// Classes which use this class (like JADX's ClassNode.useIn)
    /// Used for cross-reference analysis and dependency management
    pub use_in: Vec<String>,
    /// Methods which use this class by instructions (like JADX's ClassNode.useInMth)
    /// Format: (class_type, method_name) tuples
    pub use_in_mth: Vec<(String, String)>,
}

impl ClassData {
    /// Create a new class data
    pub fn new(class_type: String, access_flags: u32) -> Self {
        ClassData {
            class_type,
            alias: None,
            pkg_alias: None,
            access_flags,
            superclass: None,
            superclass_type: None,
            interfaces: Vec::new(),
            type_parameters: Vec::new(),
            source_file: None,
            dex_name: None,
            state: ProcessState::NotLoaded,
            load_stage: LoadStage::None,
            methods: Vec::new(),
            static_fields: Vec::new(),
            instance_fields: Vec::new(),
            annotations: Vec::new(),
            all_instructions: Vec::new(),
            kotlin_metadata: None,
            kotlin_class_info: None,
            // JADX parity fields
            inner_classes: Vec::new(),
            parent_class: None,
            inlined_classes: Vec::new(),
            dependencies: Vec::new(),
            codegen_deps: Vec::new(),
            use_in: Vec::new(),
            use_in_mth: Vec::new(),
        }
    }

    /// Check if this is a Kotlin data class
    pub fn is_data_class(&self) -> bool {
        self.kotlin_class_info.as_ref().map(|k| k.is_data_class).unwrap_or(false)
    }

    /// Check if this is a Kotlin sealed class
    pub fn is_sealed_class(&self) -> bool {
        self.kotlin_class_info.as_ref().map(|k| k.is_sealed).unwrap_or(false)
    }

    /// Check if this is a Kotlin inline/value class
    pub fn is_inline_class(&self) -> bool {
        self.kotlin_class_info.as_ref().map(|k| k.is_inline).unwrap_or(false)
    }

    /// Set Kotlin class info
    pub fn set_kotlin_class_info(&mut self, info: KotlinClassInfo) {
        self.kotlin_class_info = Some(info);
    }

    /// Unload all method instructions to free memory (like Java JADX's ClassNode.unload())
    ///
    /// Call this after code generation. The class metadata is retained.
    pub fn unload(&mut self) {
        for method in &mut self.methods {
            method.unload();
        }
        self.state = ProcessState::GeneratedAndUnloaded;
    }

    /// Get the current processing state
    pub fn get_state(&self) -> ProcessState {
        self.state
    }

    /// Set processing state
    pub fn set_state(&mut self, state: ProcessState) {
        self.state = state;
    }

    /// Get the display name (alias if set, otherwise simple_name)
    pub fn display_name(&self) -> &str {
        self.alias.as_deref().unwrap_or_else(|| self.simple_name())
    }

    /// Get the simple name (without package)
    /// For inner classes (e.g., "Outer$Inner"), returns just "Inner"
    pub fn simple_name(&self) -> &str {
        let name = self.class_type.trim_start_matches('L').trim_end_matches(';');
        let after_slash = name.rsplit('/').next().unwrap_or(name);
        // For inner classes, get the part after the last $ (e.g., "Outer$Inner" -> "Inner")
        after_slash.rsplit('$').next().unwrap_or(after_slash)
    }

    /// Get the package name
    pub fn package(&self) -> Option<&str> {
        let name = self.class_type.trim_start_matches('L').trim_end_matches(';');
        let pos = name.rfind('/')?;
        Some(&name[..pos])
    }

    /// Check if public
    pub fn is_public(&self) -> bool {
        self.access_flags & 0x0001 != 0
    }

    /// Check if final
    pub fn is_final(&self) -> bool {
        self.access_flags & 0x0010 != 0
    }

    /// Check if interface
    pub fn is_interface(&self) -> bool {
        self.access_flags & 0x0200 != 0
    }

    /// Check if abstract
    pub fn is_abstract(&self) -> bool {
        self.access_flags & 0x0400 != 0
    }

    /// Check if enum
    pub fn is_enum(&self) -> bool {
        self.access_flags & 0x4000 != 0
    }

    /// Check if annotation
    pub fn is_annotation(&self) -> bool {
        self.access_flags & 0x2000 != 0
    }

    /// NEW: Add an instruction to the shared pool and return its index
    /// Used during loading: load_method_instructions() calls this for each decoded instruction
    pub fn add_instruction(&mut self, insn: InsnNode) -> u32 {
        let idx = self.all_instructions.len() as u32;
        self.all_instructions.push(insn);
        idx
    }

    /// NEW: Get a reference to an instruction by its index
    pub fn get_instruction(&self, idx: u32) -> Option<&InsnNode> {
        self.all_instructions.get(idx as usize)
    }

    /// NEW: Get a mutable reference to an instruction by its index
    pub fn get_instruction_mut(&mut self, idx: u32) -> Option<&mut InsnNode> {
        self.all_instructions.get_mut(idx as usize)
    }

    /// NEW: Get multiple instructions by their indices
    pub fn get_instructions_by_indices<'a>(&'a self, indices: &[u32]) -> Vec<&'a InsnNode> {
        indices.iter()
            .filter_map(|&idx| self.get_instruction(idx))
            .collect()
    }

    pub fn get_kotlin_metadata(&self) -> Option<&KotlinMetadata> {
        self.kotlin_metadata.as_ref()
    }

    pub fn set_kotlin_metadata(&mut self, metadata: KotlinMetadata) {
        self.kotlin_metadata = Some(metadata);
    }

    // === JADX Parity: Inner Class Methods ===

    /// Check if this is an inner class (has a parent)
    /// Like JADX's ClassNode.isInner()
    pub fn is_inner(&self) -> bool {
        self.parent_class.is_some()
    }

    /// Check if this is a top-level class (not an inner class)
    /// Like JADX's ClassNode.isTopClass()
    pub fn is_top_class(&self) -> bool {
        self.parent_class.is_none()
    }

    /// Add an inner class to this class
    /// Also sets the inner class's parent_class reference
    pub fn add_inner_class(&mut self, inner_type: String) {
        if !self.inner_classes.contains(&inner_type) {
            self.inner_classes.push(inner_type);
        }
    }

    /// Set the parent class for this inner class
    pub fn set_parent_class(&mut self, parent_type: String) {
        self.parent_class = Some(parent_type);
    }

    /// Get the outer class name from an inner class type descriptor
    /// e.g., "Lcom/example/Outer$Inner;" -> "Lcom/example/Outer;"
    pub fn get_outer_class_from_type(class_type: &str) -> Option<String> {
        let name = class_type.trim_start_matches('L').trim_end_matches(';');
        if let Some(dollar_pos) = name.rfind('$') {
            Some(format!("L{};", &name[..dollar_pos]))
        } else {
            None
        }
    }

    /// Check if this class type looks like an inner class (contains $)
    pub fn is_inner_class_type(class_type: &str) -> bool {
        let name = class_type.trim_start_matches('L').trim_end_matches(';');
        name.contains('$')
    }

    // === JADX Parity: Dependency Tracking Methods ===

    /// Add a dependency (class used by this class)
    /// Only meaningful for top-level classes
    pub fn add_dependency(&mut self, dep_type: String) {
        if !self.dependencies.contains(&dep_type) && dep_type != self.class_type {
            self.dependencies.push(dep_type);
        }
    }

    /// Add a codegen dependency (class needed for code generation)
    pub fn add_codegen_dep(&mut self, dep_type: String) {
        if !self.codegen_deps.contains(&dep_type) && dep_type != self.class_type {
            self.codegen_deps.push(dep_type);
        }
    }

    /// Get all dependencies (both regular and codegen)
    pub fn all_deps(&self) -> impl Iterator<Item = &String> {
        self.dependencies.iter().chain(self.codegen_deps.iter())
    }

    /// Check if this class depends on another
    pub fn depends_on(&self, class_type: &str) -> bool {
        self.dependencies.iter().any(|d| d == class_type) ||
        self.codegen_deps.iter().any(|d| d == class_type)
    }

    // === JADX Parity: Load Stage Methods ===

    /// Get current load stage
    pub fn get_load_stage(&self) -> LoadStage {
        self.load_stage
    }

    /// Set load stage
    pub fn set_load_stage(&mut self, stage: LoadStage) {
        self.load_stage = stage;
    }

    /// Check if ready for code generation (all dependencies loaded)
    pub fn is_codegen_ready(&self) -> bool {
        self.load_stage.is_codegen_ready()
    }

    // === JADX Parity: Inlined Class Methods ===

    /// Add a class that was inlined into this class (like JADX's ClassNode.addInlinedClass)
    pub fn add_inlined_class(&mut self, class_type: String) {
        if !self.inlined_classes.contains(&class_type) {
            self.inlined_classes.push(class_type);
        }
    }

    /// Check if a class has been inlined into this class
    pub fn has_inlined_class(&self, class_type: &str) -> bool {
        self.inlined_classes.iter().any(|c| c == class_type)
    }

    // === JADX Parity: Usage Tracking Methods ===

    /// Add a class that uses this class (like JADX's ClassNode.addUseIn)
    pub fn add_use_in(&mut self, class_type: String) {
        if !self.use_in.contains(&class_type) && class_type != self.class_type {
            self.use_in.push(class_type);
        }
    }

    /// Add a method that uses this class (like JADX's ClassNode.addUseInMth)
    pub fn add_use_in_mth(&mut self, class_type: String, method_name: String) {
        let entry = (class_type, method_name);
        if !self.use_in_mth.contains(&entry) {
            self.use_in_mth.push(entry);
        }
    }

    /// Check if this class is used by another class
    pub fn is_used_by(&self, class_type: &str) -> bool {
        self.use_in.iter().any(|c| c == class_type)
    }

    /// Check if this class is used by any other classes
    pub fn has_usages(&self) -> bool {
        !self.use_in.is_empty() || !self.use_in_mth.is_empty()
    }
}

/// Field information
#[derive(Debug, Clone, Default)]
pub struct FieldData {
    /// Field name
    pub name: String,
    /// Alias name (from deobfuscation or mapping file)
    pub alias: Option<String>,
    /// Access flags
    pub access_flags: u32,
    /// Field type
    pub field_type: ArgType,
    /// Initial value (for static fields)
    pub initial_value: Option<FieldValue>,
    /// Annotations on this field
    pub annotations: Vec<Annotation>,
    /// DEX field index (for mapping instructions back to fields)
    pub dex_field_idx: Option<u32>,
    /// Methods which use this field (like JADX's FieldNode.useIn)
    /// Format: (class_type, method_name) tuples
    pub use_in: Vec<(String, String)>,
}

impl FieldData {
    /// Create a new field data
    pub fn new(name: String, access_flags: u32, field_type: ArgType) -> Self {
        FieldData {
            name,
            alias: None,
            access_flags,
            field_type,
            initial_value: None,
            annotations: Vec::new(),
            dex_field_idx: None,
            use_in: Vec::new(),
        }
    }

    /// Get the display name (alias if set, otherwise original name)
    pub fn display_name(&self) -> &str {
        self.alias.as_deref().unwrap_or(&self.name)
    }

    /// Check if static
    pub fn is_static(&self) -> bool {
        self.access_flags & 0x0008 != 0
    }

    /// Check if final
    pub fn is_final(&self) -> bool {
        self.access_flags & 0x0010 != 0
    }

    // === JADX Parity: Usage Tracking Methods ===

    /// Add a method that uses this field (like JADX's FieldNode.addUseIn)
    pub fn add_use_in(&mut self, class_type: String, method_name: String) {
        let entry = (class_type, method_name);
        if !self.use_in.contains(&entry) {
            self.use_in.push(entry);
        }
    }

    /// Check if this field is used by any methods
    pub fn has_usages(&self) -> bool {
        !self.use_in.is_empty()
    }
}

/// Field initial value
#[derive(Debug, Clone, PartialEq)]
pub enum FieldValue {
    Byte(i8),
    Short(i16),
    Char(u16),
    Int(i32),
    Long(i64),
    Float(f32),
    Double(f64),
    String(String),
    Type(String),
    Boolean(bool),
    Null,
    /// Array of values (for array field initializers)
    Array(Vec<FieldValue>),
    /// Enum constant reference (class name, field name)
    Enum(String, String),
    /// Field reference (class name, field name)
    Field(String, String),
}

#[cfg(test)]
mod tests {
    use super::*;

    #[test]
    fn test_class_simple_name() {
        let class = ClassData::new("Lcom/example/Foo;".to_string(), 0);
        assert_eq!(class.simple_name(), "Foo");
    }

    #[test]
    fn test_class_package() {
        let class = ClassData::new("Lcom/example/Foo;".to_string(), 0);
        assert_eq!(class.package(), Some("com/example"));
    }

    #[test]
    fn test_method_flags() {
        let mut method = MethodData::new("<init>".to_string(), 0x0001, ArgType::Void);
        assert!(method.is_constructor());
        assert!(!method.is_static());

        method.access_flags = 0x0008;
        assert!(method.is_static());
    }

    #[test]
    fn test_first_arg_reg() {
        let mut method = MethodData::new("test".to_string(), 0, ArgType::Void);
        method.regs_count = 5;
        method.ins_count = 2;
        assert_eq!(method.first_arg_reg(), 3);
    }

    #[test]
    fn test_method_unload() {
        use crate::instructions::{InsnNode, InsnType};

        let mut method = MethodData::new("test".to_string(), 0, ArgType::Void);
        method.set_instructions(vec![
            InsnNode::new(InsnType::Nop, 0),
            InsnNode::new(InsnType::Nop, 1),
        ]);

        assert!(method.is_loaded());
        assert_eq!(method.state, ProcessState::Loaded);

        method.unload();

        assert!(!method.is_loaded());
        assert_eq!(method.state, ProcessState::GeneratedAndUnloaded);
        assert!(method.instructions.is_none());
    }

    #[test]
    fn test_class_unload() {
        use crate::instructions::{InsnNode, InsnType};

        let mut class = ClassData::new("Lcom/example/Test;".to_string(), 0);

        let mut method1 = MethodData::new("method1".to_string(), 0, ArgType::Void);
        method1.set_instructions(vec![InsnNode::new(InsnType::Nop, 0)]);

        let mut method2 = MethodData::new("method2".to_string(), 0, ArgType::Void);
        method2.set_instructions(vec![InsnNode::new(InsnType::Nop, 0)]);

        class.methods.push(method1);
        class.methods.push(method2);

        // Both methods loaded
        assert!(class.methods[0].is_loaded());
        assert!(class.methods[1].is_loaded());

        // Unload entire class
        class.unload();

        // All methods unloaded
        assert!(!class.methods[0].is_loaded());
        assert!(!class.methods[1].is_loaded());
        assert_eq!(class.state, ProcessState::GeneratedAndUnloaded);
    }
}
