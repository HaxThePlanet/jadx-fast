//! IR instruction types
//!
//! This module defines the intermediate representation for Dalvik instructions.
//! Each IR instruction represents a single operation with typed arguments.

use crate::arena::ArenaId;
use crate::attributes::AFlag;
use crate::types::ArgType;
use smallvec::SmallVec;

/// Type alias for instruction argument vectors.
/// Uses SmallVec to avoid heap allocation for most method calls (<=8 args).
pub type InsnArgs = SmallVec<[InsnArg; 8]>;

/// Type alias for phi node sources.
/// Most phi nodes have <=4 sources (if/else, switch cases).
pub type PhiSources = SmallVec<[(u32, InsnArg); 4]>;

/// Instruction node ID
pub type InsnId = ArenaId<InsnNode>;

/// An IR instruction node
#[derive(Debug, Clone)]
pub struct InsnNode {
    /// Instruction type and operands
    pub insn_type: InsnType,
    /// Result type (if any)
    pub result_type: Option<ArgType>,
    /// Source line number (for debugging)
    pub source_line: Option<u32>,
    /// Original bytecode offset
    pub offset: u32,
    /// Attribute flags (for FINALLY_INSNS, DONT_GENERATE, etc.)
    /// Extended to u128 to support 69+ JADX-compatible flags
    pub flags: u128,
}

impl InsnNode {
    /// Create a new instruction node
    pub fn new(insn_type: InsnType, offset: u32) -> Self {
        InsnNode {
            insn_type,
            result_type: None,
            source_line: None,
            offset,
            flags: 0,
        }
    }

    /// Set the result type
    pub fn with_result(mut self, result_type: ArgType) -> Self {
        self.result_type = Some(result_type);
        self
    }

    /// Check if a flag is set
    pub fn has_flag(&self, flag: AFlag) -> bool {
        (self.flags & (1u128 << flag as u8)) != 0
    }

    /// Set a flag
    pub fn add_flag(&mut self, flag: AFlag) {
        self.flags |= 1u128 << flag as u8;
    }

    /// Remove a flag
    pub fn remove_flag(&mut self, flag: AFlag) {
        self.flags &= !(1u128 << flag as u8);
    }

    /// Clear all flags
    pub fn clear_flags(&mut self) {
        self.flags = 0;
    }

    /// Check if any flags are set
    pub fn has_any_flags(&self) -> bool {
        self.flags != 0
    }

    // === JADX InsnNode methods for 100% parity ===

    /// Check if this is a constant instruction (JADX: isConstInsn)
    ///
    /// Returns true for CONST, CONST_STR, CONST_CLASS instructions.
    pub fn is_const_insn(&self) -> bool {
        matches!(
            &self.insn_type,
            InsnType::Const { .. }
                | InsnType::ConstString { .. }
                | InsnType::ConstClass { .. }
        )
    }

    /// Check if this instruction has the same type and arguments (JADX: isSame)
    pub fn is_same(&self, other: &InsnNode) -> bool {
        // For basic comparison, check insn_type variant and offset
        std::mem::discriminant(&self.insn_type) == std::mem::discriminant(&other.insn_type)
            && self.offset == other.offset
    }

    /// Get instruction type name (JADX: getType().name())
    pub fn type_name(&self) -> &'static str {
        self.insn_type.name()
    }
}

/// Method handle type for lambdas
#[derive(Debug, Clone, Copy, PartialEq, Eq)]
pub enum LambdaHandleType {
    /// Static method invocation
    InvokeStatic,
    /// Instance method invocation
    InvokeInstance,
    /// Constructor invocation (::new)
    InvokeConstructor,
    /// Direct method invocation
    InvokeDirect,
    /// Interface method invocation
    InvokeInterface,
}

/// Lambda/method reference information
///
/// This contains the parsed call site information for generating lambda syntax.
#[derive(Debug, Clone)]
pub struct LambdaInfo {
    /// The method handle type for the implementation
    pub handle_type: LambdaHandleType,
    /// Implementation method index
    pub impl_method_idx: u32,
    /// Implementation method class
    pub impl_class: String,
    /// Implementation method name
    pub impl_method_name: String,
    /// Functional interface method name (e.g., "apply", "run", "accept")
    pub interface_method_name: String,
    /// Whether to use method reference syntax (::) instead of lambda
    pub use_method_ref: bool,
    /// Whether to inline the lambda body (synthetic methods)
    pub inline_body: bool,
    /// Number of captured variables (args passed to invoke-custom that become method params)
    pub captured_arg_count: usize,
    /// Lambda parameter types (from the functional interface's abstract method)
    pub lambda_param_types: Vec<ArgType>,
    /// Lambda return type (from the functional interface's abstract method)
    pub lambda_return_type: ArgType,
}

/// IR instruction types
#[derive(Debug, Clone)]
pub enum InsnType {
    /// No operation
    Nop,

    /// Constant value: result = literal
    Const {
        dest: RegisterArg,
        value: LiteralArg,
    },

    /// Constant string: result = string_ref
    ConstString {
        dest: RegisterArg,
        string_idx: u32,
    },

    /// Constant class: result = class_ref
    ConstClass {
        dest: RegisterArg,
        type_idx: u32,
    },

    /// Move: dest = src
    Move {
        dest: RegisterArg,
        src: InsnArg,
    },

    /// Move result from previous invoke
    MoveResult {
        dest: RegisterArg,
    },

    /// Move exception to register
    MoveException {
        dest: RegisterArg,
    },

    /// Return from method
    Return {
        value: Option<InsnArg>,
    },

    /// Throw exception
    Throw {
        exception: InsnArg,
    },

    /// Monitor enter
    MonitorEnter {
        object: InsnArg,
    },

    /// Monitor exit
    MonitorExit {
        object: InsnArg,
    },

    /// Check cast
    CheckCast {
        object: InsnArg,
        type_idx: u32,
    },

    /// Instance of check: result = object instanceof type
    InstanceOf {
        dest: RegisterArg,
        object: InsnArg,
        type_idx: u32,
    },

    /// Array length: result = array.length
    ArrayLength {
        dest: RegisterArg,
        array: InsnArg,
    },

    /// New instance: result = new Type()
    NewInstance {
        dest: RegisterArg,
        type_idx: u32,
    },

    /// New array: result = new Type[size]
    NewArray {
        dest: RegisterArg,
        size: InsnArg,
        type_idx: u32,
    },

    /// Filled new array: result = new Type[] { args... }
    FilledNewArray {
        dest: Option<RegisterArg>,
        type_idx: u32,
        args: InsnArgs,
    },

    /// Fill array data (from payload)
    FillArrayData {
        array: InsnArg,
        payload_offset: i32,
        /// Element width in bytes (1, 2, 4, or 8)
        element_width: u8,
        /// Array data elements (stored as i64, interpret based on element_width)
        data: Vec<i64>,
    },

    /// Array get: result = array[index]
    ArrayGet {
        dest: RegisterArg,
        array: InsnArg,
        index: InsnArg,
        elem_type: ArrayElemType,
    },

    /// Array put: array[index] = value
    ArrayPut {
        array: InsnArg,
        index: InsnArg,
        value: InsnArg,
        elem_type: ArrayElemType,
    },

    /// Instance field get: result = object.field
    InstanceGet {
        dest: RegisterArg,
        object: InsnArg,
        field_idx: u32,
    },

    /// Instance field put: object.field = value
    InstancePut {
        object: InsnArg,
        field_idx: u32,
        value: InsnArg,
    },

    /// Static field get: result = Class.field
    StaticGet {
        dest: RegisterArg,
        field_idx: u32,
    },

    /// Static field put: Class.field = value
    StaticPut {
        field_idx: u32,
        value: InsnArg,
    },

    /// Method invocation
    Invoke {
        kind: InvokeKind,
        method_idx: u32,
        args: InsnArgs,
        /// Proto index for polymorphic invokes (MethodHandle/VarHandle)
        proto_idx: Option<u32>,
    },

    /// Lambda/method reference invocation (invoke-custom)
    ///
    /// This represents Java 8+ lambda expressions and method references.
    /// The call_site contains bootstrap information for the lambda.
    InvokeCustom {
        /// Call site index in DEX file
        call_site_idx: u32,
        /// Arguments to the lambda
        args: InsnArgs,
        /// Destination register for lambda result
        dest: Option<RegisterArg>,
        /// Lambda metadata (populated during conversion)
        lambda_info: Option<LambdaInfo>,
    },

    /// Unary operation: result = op(arg)
    Unary {
        dest: RegisterArg,
        op: UnaryOp,
        arg: InsnArg,
    },

    /// Binary operation: result = left op right
    Binary {
        dest: RegisterArg,
        op: BinaryOp,
        left: InsnArg,
        right: InsnArg,
    },

    /// Type conversion: result = (type)arg
    Cast {
        dest: RegisterArg,
        cast_type: CastType,
        arg: InsnArg,
    },

    /// Compare: result = cmp(left, right)
    Compare {
        dest: RegisterArg,
        op: CompareOp,
        left: InsnArg,
        right: InsnArg,
    },

    /// Conditional branch: if (cond) goto target
    If {
        condition: IfCondition,
        left: InsnArg,
        right: Option<InsnArg>, // None for *z variants
        target: u32,
    },

    /// Ternary operation: result = (cond) ? then_value : else_value
    Ternary {
        dest: RegisterArg,
        condition: IfCondition,
        left: InsnArg,
        right: Option<InsnArg>, // None for *z variants
        then_value: InsnArg,
        else_value: InsnArg,
    },

    /// Unconditional branch: goto target
    Goto {
        target: u32,
    },

    /// Packed switch (consecutive case keys)
    PackedSwitch {
        value: InsnArg,
        payload_offset: i32,
        /// First key value (keys are first_key, first_key+1, ...)
        first_key: i32,
        /// Target offsets (absolute, in code units) for each case
        targets: Vec<u32>,
    },

    /// Sparse switch (arbitrary case keys)
    SparseSwitch {
        value: InsnArg,
        payload_offset: i32,
        /// Case keys (sorted)
        keys: Vec<i32>,
        /// Target offsets (absolute, in code units) for each case
        targets: Vec<u32>,
    },

    /// Phi node (for SSA form)
    Phi {
        dest: RegisterArg,
        sources: PhiSources, // (block_id, value)
    },

    // === Synthetic/Additional instructions (matching JADX) ===

    /// Move multiple values (for parallel assignments)
    /// Used to represent simultaneous assignments like: a, b = b, a
    /// Matches JADX's MOVE_MULTI
    MoveMulti {
        /// List of (dest, src) pairs to assign simultaneously
        moves: Vec<(RegisterArg, InsnArg)>,
    },

    /// String concatenation: result = arg1 + arg2 + ... (all strings)
    /// Used for StringBuilder-based string concatenation optimization
    /// Matches JADX's STR_CONCAT
    StrConcat {
        dest: RegisterArg,
        args: Vec<InsnArg>,
    },

    /// Region argument placeholder
    /// Fake instruction to keep arguments which will be used in regions codegen
    /// Matches JADX's REGION_ARG
    RegionArg {
        /// Arguments to preserve for region code generation
        args: Vec<InsnArg>,
    },

    /// One argument passthrough
    /// Just generates one argument (used for implicit value propagation)
    /// Matches JADX's ONE_ARG
    OneArg {
        arg: InsnArg,
    },

    /// Constructor invocation (specialized invoke for constructors)
    /// Matches JADX's CONSTRUCTOR - tracks new + <init> patterns
    Constructor {
        dest: RegisterArg,
        type_idx: u32,
        method_idx: u32,
        args: Vec<InsnArg>,
        /// Generic type parameters (e.g., <String> for ArrayList<String>)
        /// Matches JADX's GenericInfoAttr
        generic_types: Option<Vec<ArgType>>,
    },

    /// Java JSR (Jump SubRoutine) - legacy finally implementation
    /// Only found in older Java .class files converted to DEX
    /// Matches JADX's JAVA_JSR
    JavaJsr {
        /// Target subroutine address
        target: u32,
    },

    /// Java RET (Return from subroutine) - legacy finally return
    /// Only found in older Java .class files converted to DEX
    /// Matches JADX's JAVA_RET
    JavaRet {
        /// Register containing return address
        addr_reg: RegisterArg,
    },

    // === Synthetic instructions (added during region reconstruction) ===

    /// Break statement (exit loop early)
    Break {
        /// Optional label for breaking out of nested loops
        label: Option<String>,
    },

    /// Continue statement (skip to next iteration)
    Continue {
        /// Optional label for continuing outer loop
        label: Option<String>,
    },
}

impl InsnType {
    /// Get the instruction type name (JADX: getType().name())
    ///
    /// Returns a string matching JADX's InsnType enum names.
    pub fn name(&self) -> &'static str {
        match self {
            InsnType::Nop => "NOP",
            InsnType::Const { .. } => "CONST",
            InsnType::ConstString { .. } => "CONST_STR",
            InsnType::ConstClass { .. } => "CONST_CLASS",
            InsnType::Move { .. } => "MOVE",
            InsnType::MoveResult { .. } => "MOVE_RESULT",
            InsnType::MoveException { .. } => "MOVE_EXCEPTION",
            InsnType::Return { .. } => "RETURN",
            InsnType::Throw { .. } => "THROW",
            InsnType::MonitorEnter { .. } => "MONITOR_ENTER",
            InsnType::MonitorExit { .. } => "MONITOR_EXIT",
            InsnType::CheckCast { .. } => "CHECK_CAST",
            InsnType::InstanceOf { .. } => "INSTANCE_OF",
            InsnType::ArrayLength { .. } => "ARRAY_LENGTH",
            InsnType::NewInstance { .. } => "NEW_INSTANCE",
            InsnType::NewArray { .. } => "NEW_ARRAY",
            InsnType::FilledNewArray { .. } => "FILLED_NEW_ARRAY",
            InsnType::FillArrayData { .. } => "FILL_ARRAY_DATA",
            InsnType::ArrayGet { .. } => "AGET",
            InsnType::ArrayPut { .. } => "APUT",
            InsnType::InstanceGet { .. } => "IGET",
            InsnType::InstancePut { .. } => "IPUT",
            InsnType::StaticGet { .. } => "SGET",
            InsnType::StaticPut { .. } => "SPUT",
            InsnType::Invoke { .. } => "INVOKE",
            InsnType::InvokeCustom { .. } => "INVOKE_CUSTOM",
            InsnType::Unary { .. } => "ARITH",
            InsnType::Binary { .. } => "ARITH",
            InsnType::Cast { .. } => "CAST",
            InsnType::Compare { .. } => "CMP",
            InsnType::If { .. } => "IF",
            InsnType::Ternary { .. } => "TERNARY",
            InsnType::Goto { .. } => "GOTO",
            InsnType::PackedSwitch { .. } => "SWITCH",
            InsnType::SparseSwitch { .. } => "SWITCH",
            InsnType::Phi { .. } => "PHI",
            InsnType::MoveMulti { .. } => "MOVE_MULTI",
            InsnType::StrConcat { .. } => "STR_CONCAT",
            InsnType::RegionArg { .. } => "REGION_ARG",
            InsnType::OneArg { .. } => "ONE_ARG",
            InsnType::Constructor { .. } => "CONSTRUCTOR",
            InsnType::JavaJsr { .. } => "JAVA_JSR",
            InsnType::JavaRet { .. } => "JAVA_RET",
            InsnType::Break { .. } => "BREAK",
            InsnType::Continue { .. } => "CONTINUE",
        }
    }
}

/// Instruction argument
///
/// Matches JADX's instruction argument hierarchy with additional variants
/// for wrapped instructions and named arguments.
#[derive(Debug, Clone)]
pub enum InsnArg {
    /// Register reference
    Register(RegisterArg),
    /// Literal constant
    Literal(LiteralArg),
    /// Type reference (type_idx)
    Type(u32),
    /// Field reference (field_idx)
    Field(u32),
    /// Method reference (method_idx)
    Method(u32),
    /// String reference (string_idx)
    String(u32),

    // === New JADX-compatible argument types ===

    /// Wrapped instruction (for inlining expressions)
    ///
    /// Used during code optimization to inline simple expressions.
    /// E.g., `x = a + b` can be inlined as argument: `foo(a + b)`
    /// The wrapped instruction's result is used as this argument's value.
    ///
    /// Matches JADX's `InsnWrapArg`
    Wrapped(Box<WrappedInsn>),

    /// Named argument (for synthetic variables)
    ///
    /// Used for special named values like catch exception variables,
    /// loop iterators in for-each, etc.
    ///
    /// Matches JADX's `NamedArg`
    Named {
        name: String,
        arg_type: ArgType,
    },

    /// This reference (for instance methods)
    ///
    /// Explicit 'this' reference, used when 'this' needs special handling
    This {
        class_type: String,
    },
}

/// Wrapped instruction for InsnArg::Wrapped
///
/// Contains an instruction that is inlined as an argument expression.
#[derive(Debug, Clone)]
pub struct WrappedInsn {
    /// The instruction index in the shared pool (or inline instruction)
    pub insn_idx: u32,
    /// The result type of the wrapped instruction
    pub result_type: ArgType,
    /// Optional inline copy of the instruction (for when not using shared pool)
    pub inline_insn: Option<Box<InsnNode>>,
}

impl WrappedInsn {
    /// Create a new wrapped instruction reference
    pub fn new(insn_idx: u32, result_type: ArgType) -> Self {
        WrappedInsn {
            insn_idx,
            result_type,
            inline_insn: None,
        }
    }

    /// Create with an inline instruction copy
    pub fn with_inline(insn: InsnNode) -> Self {
        let result_type = insn.result_type.clone().unwrap_or(ArgType::Unknown);
        WrappedInsn {
            insn_idx: 0,
            result_type,
            inline_insn: Some(Box::new(insn)),
        }
    }

    // === JADX InsnWrapArg methods for 100% parity ===

    /// Get the wrapped instruction (JADX: getWrapInsn)
    pub fn get_wrap_insn(&self) -> Option<&InsnNode> {
        self.inline_insn.as_deref()
    }

    /// Get mutable reference to wrapped instruction
    pub fn get_wrap_insn_mut(&mut self) -> Option<&mut InsnNode> {
        self.inline_insn.as_deref_mut()
    }

    /// Unwrap with a copy of the instruction (JADX: unWrapWithCopy)
    ///
    /// Returns a copy of the wrapped instruction with WRAPPED flag removed.
    /// Used when the instruction needs to be extracted from the wrapper.
    pub fn unwrap_with_copy(&self) -> Option<InsnNode> {
        self.inline_insn.as_ref().map(|insn| {
            let mut copy = (**insn).clone();
            // Clear the WRAPPED flag from the copy
            copy.flags &= !(1u128 << 17); // AFlag::Wrapped is bit 17
            copy
        })
    }

    /// Duplicate this wrapped instruction (JADX: duplicate)
    pub fn duplicate(&self) -> Self {
        WrappedInsn {
            insn_idx: self.insn_idx,
            result_type: self.result_type.clone(),
            inline_insn: self.inline_insn.as_ref().map(|insn| {
                let mut copy = (**insn).clone();
                // Don't copy the result for wrapped copies (JADX: copyWithoutResult)
                copy.result_type = None;
                Box::new(copy)
            }),
        }
    }

    /// Short string representation (JADX: toShortString)
    pub fn to_short_string(&self) -> String {
        if let Some(ref insn) = self.inline_insn {
            // Check for CONST_STR special case
            if let InsnType::ConstString { string_idx, .. } = &insn.insn_type {
                return format!("(str#{})", string_idx);
            }
            format!("(wrap:{}:{})", self.result_type.short_name(), insn.insn_type.name())
        } else {
            format!("(wrap:{}:idx{})", self.result_type.short_name(), self.insn_idx)
        }
    }

    /// Get the result type of the wrapped instruction
    pub fn get_type(&self) -> &ArgType {
        &self.result_type
    }

    /// Set the result type
    pub fn set_type(&mut self, ty: ArgType) {
        self.result_type = ty;
    }

    /// Check if this wraps a const string instruction (JADX: special case in toString)
    pub fn is_const_string(&self) -> bool {
        self.inline_insn.as_ref().map_or(false, |insn| {
            matches!(&insn.insn_type, InsnType::ConstString { .. })
        })
    }
}

impl InsnArg {
    /// Create a register argument
    pub fn reg(reg: u16) -> Self {
        InsnArg::Register(RegisterArg::new(reg))
    }

    /// Create a literal argument
    pub fn lit(value: i64) -> Self {
        InsnArg::Literal(LiteralArg::Int(value))
    }

    /// Create a named argument
    pub fn named(name: impl Into<String>, arg_type: ArgType) -> Self {
        InsnArg::Named {
            name: name.into(),
            arg_type,
        }
    }

    /// Create a wrapped instruction argument
    pub fn wrapped(insn_idx: u32, result_type: ArgType) -> Self {
        InsnArg::Wrapped(Box::new(WrappedInsn::new(insn_idx, result_type)))
    }

    /// Create a this reference
    pub fn this_ref(class_type: impl Into<String>) -> Self {
        InsnArg::This {
            class_type: class_type.into(),
        }
    }

    /// Check if this is a wrapped instruction
    pub fn is_wrapped(&self) -> bool {
        matches!(self, InsnArg::Wrapped(_))
    }

    /// Check if this is a named argument
    pub fn is_named(&self) -> bool {
        matches!(self, InsnArg::Named { .. })
    }

    /// Check if this is a register argument
    pub fn is_register(&self) -> bool {
        matches!(self, InsnArg::Register(_))
    }

    /// Check if this is a literal argument
    pub fn is_literal(&self) -> bool {
        matches!(self, InsnArg::Literal(_))
    }

    /// Get as register if it is one
    pub fn as_register(&self) -> Option<&RegisterArg> {
        match self {
            InsnArg::Register(r) => Some(r),
            _ => None,
        }
    }

    /// Get as mutable register if it is one
    pub fn as_register_mut(&mut self) -> Option<&mut RegisterArg> {
        match self {
            InsnArg::Register(r) => Some(r),
            _ => None,
        }
    }

    /// Get as literal if it is one
    pub fn as_literal(&self) -> Option<&LiteralArg> {
        match self {
            InsnArg::Literal(l) => Some(l),
            _ => None,
        }
    }

    /// Get as wrapped instruction if it is one
    pub fn as_wrapped(&self) -> Option<&WrappedInsn> {
        match self {
            InsnArg::Wrapped(w) => Some(w),
            _ => None,
        }
    }

    /// Get the name if this is a named argument
    pub fn get_name(&self) -> Option<&str> {
        match self {
            InsnArg::Named { name, .. } => Some(name),
            _ => None,
        }
    }

    // === JADX InsnArg methods for 100% parity ===

    /// Check if this is a zero literal (JADX: isZeroLiteral)
    ///
    /// Returns true only for literal zero values (int 0, float 0.0, double 0.0)
    pub fn is_zero_literal(&self) -> bool {
        match self {
            InsnArg::Literal(lit) => lit.is_zero(),
            _ => false,
        }
    }

    /// Check if this is a zero constant (JADX: isZeroConst)
    ///
    /// Returns true for zero literals OR wrapped CONST instructions with zero value.
    /// This is used to detect null/zero comparisons.
    pub fn is_zero_const(&self) -> bool {
        if self.is_zero_literal() {
            return true;
        }
        // Check wrapped CONST instructions for zero value
        if let InsnArg::Wrapped(wrapped) = self {
            if let Some(ref insn) = wrapped.inline_insn {
                // Check if wrapped instruction is a CONST with zero value
                if let InsnType::Const { value, .. } = &insn.insn_type {
                    return value.is_zero();
                }
            }
        }
        false
    }

    /// Check if this represents boolean false (JADX: isFalse)
    ///
    /// Returns true for literal 0 when the type is known to be boolean.
    pub fn is_false(&self, expected_type: Option<&ArgType>) -> bool {
        if let InsnArg::Literal(LiteralArg::Int(0)) = self {
            return expected_type.map_or(false, |t| *t == ArgType::Boolean);
        }
        false
    }

    /// Check if this represents boolean true (JADX: isTrue)
    ///
    /// Returns true for literal 1 when the type is known to be boolean.
    pub fn is_true(&self, expected_type: Option<&ArgType>) -> bool {
        if let InsnArg::Literal(LiteralArg::Int(1)) = self {
            return expected_type.map_or(false, |t| *t == ArgType::Boolean);
        }
        false
    }

    /// Check if this is a constant (literal or wrapped const) (JADX: isConst)
    pub fn is_const(&self) -> bool {
        match self {
            InsnArg::Literal(_) => true,
            InsnArg::Wrapped(wrapped) => {
                if let Some(ref insn) = wrapped.inline_insn {
                    insn.is_const_insn()
                } else {
                    false
                }
            }
            _ => false,
        }
    }

    /// Check if two args represent the same constant value (JADX: isSameConst)
    pub fn is_same_const(&self, other: &InsnArg) -> bool {
        if self.is_const() && other.is_const() {
            // Compare literals directly
            match (self, other) {
                (InsnArg::Literal(a), InsnArg::Literal(b)) => a.same_value(b),
                (InsnArg::String(a), InsnArg::String(b)) => a == b,
                _ => false,
            }
        } else {
            false
        }
    }

    /// Check if this arg uses the same variable as another register (JADX: isSameVar)
    pub fn is_same_var(&self, other: &RegisterArg) -> bool {
        match self {
            InsnArg::Register(reg) => reg.same_reg_and_ssa(other),
            _ => false,
        }
    }

    /// Check if this arg uses the same code variable (ignoring SSA version) (JADX: isSameCodeVar)
    pub fn is_same_code_var(&self, other: &RegisterArg) -> bool {
        match self {
            InsnArg::Register(reg) => reg.same_code_var(other),
            _ => false,
        }
    }

    /// Check if this is a 'this' reference (JADX: isThis via AFlag.THIS)
    pub fn is_this(&self) -> bool {
        matches!(self, InsnArg::This { .. })
    }

    /// Check if this is any 'this' reference including outer class this (JADX: isAnyThis)
    ///
    /// Returns true for 'this' from current or outer classes (common in anonymous classes).
    /// Recursively checks wrapped instructions for IGET of outer this.
    pub fn is_any_this(&self) -> bool {
        if self.is_this() {
            return true;
        }
        // Check wrapped instructions for IGET of 'this$0' pattern
        if let Some(insn) = self.unwrap() {
            if let InsnType::InstanceGet { object, .. } = &insn.insn_type {
                return object.is_any_this();
            }
        }
        false
    }

    /// Unwrap wrapped instruction if present (JADX: unwrap)
    pub fn unwrap(&self) -> Option<&InsnNode> {
        match self {
            InsnArg::Wrapped(wrapped) => wrapped.inline_insn.as_deref(),
            _ => None,
        }
    }

    /// Get type of this argument (JADX: getType)
    pub fn get_type(&self) -> ArgType {
        match self {
            InsnArg::Register(_) => ArgType::Unknown,
            InsnArg::Literal(lit) => lit.get_type(),
            InsnArg::Type(_) => ArgType::Object("java.lang.Class".into()),
            InsnArg::Field(_) => ArgType::Unknown,
            InsnArg::Method(_) => ArgType::Unknown,
            InsnArg::String(_) => ArgType::Object("java.lang.String".into()),
            InsnArg::Wrapped(w) => w.result_type.clone(),
            InsnArg::Named { arg_type, .. } => arg_type.clone(),
            InsnArg::This { class_type } => ArgType::Object(class_type.clone()),
        }
    }

    /// Duplicate this argument (JADX: duplicate)
    pub fn duplicate(&self) -> Self {
        match self {
            InsnArg::Register(reg) => InsnArg::Register(*reg),
            InsnArg::Literal(lit) => InsnArg::Literal(lit.clone()),
            InsnArg::Type(idx) => InsnArg::Type(*idx),
            InsnArg::Field(idx) => InsnArg::Field(*idx),
            InsnArg::Method(idx) => InsnArg::Method(*idx),
            InsnArg::String(idx) => InsnArg::String(*idx),
            InsnArg::Wrapped(w) => InsnArg::Wrapped(Box::new(w.duplicate())),
            InsnArg::Named { name, arg_type } => InsnArg::Named {
                name: name.clone(),
                arg_type: arg_type.clone(),
            },
            InsnArg::This { class_type } => InsnArg::This {
                class_type: class_type.clone(),
            },
        }
    }

    /// Short string representation (JADX: toShortString)
    pub fn to_short_string(&self) -> String {
        match self {
            InsnArg::Register(reg) => format!("v{}", reg.reg_num),
            InsnArg::Literal(lit) => lit.to_short_string(),
            InsnArg::Type(idx) => format!("type#{}", idx),
            InsnArg::Field(idx) => format!("field#{}", idx),
            InsnArg::Method(idx) => format!("method#{}", idx),
            InsnArg::String(idx) => format!("str#{}", idx),
            InsnArg::Wrapped(w) => w.to_short_string(),
            InsnArg::Named { name, .. } => name.clone(),
            InsnArg::This { .. } => "this".to_string(),
        }
    }

    /// Set name for named arguments (JADX NamedArg: setName)
    ///
    /// Returns true if successful (only for Named variant)
    pub fn set_name(&mut self, new_name: impl Into<String>) -> bool {
        match self {
            InsnArg::Named { name, .. } => {
                *name = new_name.into();
                true
            }
            _ => false,
        }
    }
}

/// Register argument
#[derive(Debug, Clone, Copy, PartialEq, Eq, Hash)]
pub struct RegisterArg {
    /// Register number
    pub reg_num: u16,
    /// SSA version (for SSA form)
    pub ssa_version: u32,
}

impl RegisterArg {
    /// Create a new register argument
    pub fn new(reg_num: u16) -> Self {
        RegisterArg {
            reg_num,
            ssa_version: 0,
        }
    }

    /// Create with SSA version
    pub fn with_ssa(reg_num: u16, version: u32) -> Self {
        RegisterArg {
            reg_num,
            ssa_version: version,
        }
    }

    // === JADX RegisterArg methods for 100% parity ===

    /// Check if same register and SSA version (JADX: sameRegAndSVar)
    ///
    /// Returns true if both register number and SSA version match.
    /// Used for precise variable identity in SSA form.
    pub fn same_reg_and_ssa(&self, other: &RegisterArg) -> bool {
        self.reg_num == other.reg_num && self.ssa_version == other.ssa_version
    }

    /// Check if same code variable (ignoring SSA version) (JADX: sameCodeVar)
    ///
    /// Returns true if register numbers match, ignoring SSA versioning.
    /// Used when we care about the underlying variable, not the specific definition.
    pub fn same_code_var(&self, other: &RegisterArg) -> bool {
        self.reg_num == other.reg_num
    }

    /// Check if this is the same register number (JADX: getRegNum comparison)
    pub fn same_reg(&self, other: &RegisterArg) -> bool {
        self.reg_num == other.reg_num
    }

    /// Get register number (JADX: getRegNum)
    pub fn get_reg_num(&self) -> u16 {
        self.reg_num
    }

    /// Get SSA version (JADX: getSVar().getVersion())
    pub fn get_ssa_version(&self) -> u32 {
        self.ssa_version
    }

    /// Duplicate this register arg (JADX: duplicate)
    pub fn duplicate(&self) -> Self {
        *self
    }

    /// Short string representation (JADX: toShortString)
    pub fn to_short_string(&self) -> String {
        if self.ssa_version > 0 {
            format!("v{}_{}", self.reg_num, self.ssa_version)
        } else {
            format!("v{}", self.reg_num)
        }
    }
}

/// Literal argument
#[derive(Debug, Clone)]
pub enum LiteralArg {
    /// Integer/long constant
    Int(i64),
    /// Float constant
    Float(f32),
    /// Double constant
    Double(f64),
    /// Null constant
    Null,
}

impl LiteralArg {
    /// Create from raw bits (for const-wide)
    pub fn from_bits_f32(bits: i32) -> Self {
        LiteralArg::Float(f32::from_bits(bits as u32))
    }

    /// Create from raw bits (for const-wide)
    pub fn from_bits_f64(bits: i64) -> Self {
        LiteralArg::Double(f64::from_bits(bits as u64))
    }

    // === JADX LiteralArg methods for 100% parity ===

    /// Check if this literal is zero (JADX: getLiteral() == 0)
    pub fn is_zero(&self) -> bool {
        match self {
            LiteralArg::Int(v) => *v == 0,
            LiteralArg::Float(v) => *v == 0.0,
            LiteralArg::Double(v) => *v == 0.0,
            LiteralArg::Null => true, // null is considered zero for comparison purposes
        }
    }

    /// Check if two literals have the same value (JADX: equals)
    pub fn same_value(&self, other: &LiteralArg) -> bool {
        match (self, other) {
            (LiteralArg::Int(a), LiteralArg::Int(b)) => a == b,
            (LiteralArg::Float(a), LiteralArg::Float(b)) => a.to_bits() == b.to_bits(),
            (LiteralArg::Double(a), LiteralArg::Double(b)) => a.to_bits() == b.to_bits(),
            (LiteralArg::Null, LiteralArg::Null) => true,
            _ => false,
        }
    }

    /// Get the type of this literal (JADX: getType)
    pub fn get_type(&self) -> ArgType {
        match self {
            LiteralArg::Int(v) => {
                // JADX uses type inference based on value range
                if *v == 0 || *v == 1 {
                    ArgType::Unknown // Could be boolean, byte, short, char, int
                } else if *v >= i8::MIN as i64 && *v <= i8::MAX as i64 {
                    ArgType::UnknownIntegral // byte, short, char, int
                } else if *v >= i16::MIN as i64 && *v <= i16::MAX as i64 {
                    ArgType::UnknownIntegral // short, char, int
                } else if *v >= i32::MIN as i64 && *v <= i32::MAX as i64 {
                    ArgType::Int
                } else {
                    ArgType::Long
                }
            }
            LiteralArg::Float(_) => ArgType::Float,
            LiteralArg::Double(_) => ArgType::Double,
            LiteralArg::Null => ArgType::UnknownObject,
        }
    }

    /// Get the raw integer value (JADX: getLiteral)
    pub fn get_literal(&self) -> i64 {
        match self {
            LiteralArg::Int(v) => *v,
            LiteralArg::Float(v) => v.to_bits() as i64,
            LiteralArg::Double(v) => v.to_bits() as i64,
            LiteralArg::Null => 0,
        }
    }

    /// Short string representation (JADX: toShortString)
    pub fn to_short_string(&self) -> String {
        match self {
            LiteralArg::Int(v) => {
                if *v >= -1000 && *v <= 1000 {
                    format!("{}", v)
                } else {
                    format!("0x{:x}", v)
                }
            }
            LiteralArg::Float(v) => format!("{}f", v),
            LiteralArg::Double(v) => format!("{}d", v),
            LiteralArg::Null => "null".to_string(),
        }
    }

    /// Check if this is a wide type (long/double) (JADX: isWide)
    pub fn is_wide(&self) -> bool {
        matches!(self, LiteralArg::Double(_)) || matches!(self, LiteralArg::Int(v) if *v > i32::MAX as i64 || *v < i32::MIN as i64)
    }
}

/// Array element type for array operations
#[derive(Debug, Clone, Copy, PartialEq, Eq)]
pub enum ArrayElemType {
    Int,
    Wide,
    Object,
    Boolean,
    Byte,
    Char,
    Short,
}

/// Method invocation kind
#[derive(Debug, Clone, Copy, PartialEq, Eq)]
pub enum InvokeKind {
    Virtual,
    Super,
    Direct,
    Static,
    Interface,
    Polymorphic,
    Custom,
}

/// Unary operation
#[derive(Debug, Clone, Copy, PartialEq, Eq)]
pub enum UnaryOp {
    /// Arithmetic negation (-x)
    Neg,
    /// Bitwise NOT (~x for int/long)
    Not,
    /// Boolean NOT (!x for boolean)
    BoolNot,
}

/// Binary operation
#[derive(Debug, Clone, Copy, PartialEq, Eq)]
pub enum BinaryOp {
    Add,
    Sub,
    Mul,
    Div,
    Rem,
    And,
    Or,
    Xor,
    Shl,
    Shr,
    Ushr,
    Rsub,
}

/// Type conversion
#[derive(Debug, Clone, Copy, PartialEq, Eq)]
pub enum CastType {
    IntToLong,
    IntToFloat,
    IntToDouble,
    LongToInt,
    LongToFloat,
    LongToDouble,
    FloatToInt,
    FloatToLong,
    FloatToDouble,
    DoubleToInt,
    DoubleToLong,
    DoubleToFloat,
    IntToByte,
    IntToChar,
    IntToShort,
}

/// Comparison operation
#[derive(Debug, Clone, Copy, PartialEq, Eq)]
pub enum CompareOp {
    /// Compare floats, return -1 on NaN
    CmplFloat,
    /// Compare floats, return 1 on NaN
    CmpgFloat,
    /// Compare doubles, return -1 on NaN
    CmplDouble,
    /// Compare doubles, return 1 on NaN
    CmpgDouble,
    /// Compare longs
    CmpLong,
}

/// If condition
#[derive(Debug, Clone, Copy, PartialEq, Eq)]
pub enum IfCondition {
    Eq,
    Ne,
    Lt,
    Ge,
    Gt,
    Le,
}

#[cfg(test)]
mod tests {
    use super::*;

    #[test]
    fn test_insn_node_creation() {
        let insn = InsnNode::new(InsnType::Nop, 0);
        assert!(matches!(insn.insn_type, InsnType::Nop));
        assert_eq!(insn.offset, 0);
    }

    #[test]
    fn test_register_arg() {
        let reg = RegisterArg::new(5);
        assert_eq!(reg.reg_num, 5);
        assert_eq!(reg.ssa_version, 0);

        let ssa_reg = RegisterArg::with_ssa(5, 3);
        assert_eq!(ssa_reg.ssa_version, 3);
    }

    #[test]
    fn test_insn_arg() {
        let reg = InsnArg::reg(0);
        assert!(matches!(reg, InsnArg::Register(_)));

        let lit = InsnArg::lit(42);
        assert!(matches!(lit, InsnArg::Literal(LiteralArg::Int(42))));
    }
}
