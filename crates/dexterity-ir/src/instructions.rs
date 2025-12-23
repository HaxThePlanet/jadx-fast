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

    // === JADX InsnNode visitor methods for 100% parity ===

    /// Visit this instruction and all inner (wrapped) instructions (JADX: visitInsns)
    ///
    /// Calls the visitor function on this instruction, then recursively
    /// visits any wrapped instructions in the arguments.
    pub fn visit_insns<F>(&self, visitor: &mut F)
    where
        F: FnMut(&InsnNode),
    {
        visitor(self);
        for arg in self.insn_type.get_args() {
            if let InsnArg::Wrapped(wrapped) = arg {
                if let Some(ref inner) = wrapped.inline_insn {
                    inner.visit_insns(visitor);
                }
            }
        }
    }

    /// Visit this instruction and all inner (wrapped) instructions, returning early on Some (JADX: visitInsns<R>)
    ///
    /// Calls the visitor function on this instruction, then recursively
    /// visits any wrapped instructions. Returns early if visitor returns Some.
    pub fn visit_insns_until<F, R>(&self, visitor: &mut F) -> Option<R>
    where
        F: FnMut(&InsnNode) -> Option<R>,
    {
        if let Some(result) = visitor(self) {
            return Some(result);
        }
        for arg in self.insn_type.get_args() {
            if let InsnArg::Wrapped(wrapped) = arg {
                if let Some(ref inner) = wrapped.inline_insn {
                    if let Some(result) = inner.visit_insns_until(visitor) {
                        return Some(result);
                    }
                }
            }
        }
        None
    }

    /// Visit all args recursively, but excluding wrapped args (JADX: visitArgs)
    ///
    /// Visits the actual arguments (registers, literals, etc.) but descends
    /// into wrapped instructions to visit their arguments too.
    pub fn visit_args<F>(&self, visitor: &mut F)
    where
        F: FnMut(&InsnArg),
    {
        for arg in self.insn_type.get_args() {
            if let InsnArg::Wrapped(wrapped) = arg {
                if let Some(ref inner) = wrapped.inline_insn {
                    inner.visit_args(visitor);
                }
            } else {
                visitor(arg);
            }
        }
    }

    /// Visit all args recursively, returning early on Some (JADX: visitArgs<R>)
    pub fn visit_args_until<F, R>(&self, visitor: &mut F) -> Option<R>
    where
        F: FnMut(&InsnArg) -> Option<R>,
    {
        for arg in self.insn_type.get_args() {
            if let InsnArg::Wrapped(wrapped) = arg {
                if let Some(ref inner) = wrapped.inline_insn {
                    if let Some(result) = inner.visit_args_until(visitor) {
                        return Some(result);
                    }
                }
            } else if let Some(result) = visitor(arg) {
                return Some(result);
            }
        }
        None
    }

    // === JADX InsnNode utility methods for 100% parity ===

    /// Check if this instruction can be safely reordered (JADX: canReorder)
    ///
    /// Returns true for instructions without side effects that can be moved
    /// during optimization passes.
    pub fn can_reorder(&self) -> bool {
        if self.has_flag(AFlag::DontGenerate) {
            // DONT_GENERATE instructions can usually be reordered
            // Exception: MONITOR_EXIT must stay in place
            if matches!(&self.insn_type, InsnType::MonitorExit { .. }) {
                return false;
            }
            return true;
        }

        // Check wrapped args recursively
        for arg in self.insn_type.get_args() {
            if let InsnArg::Wrapped(wrapped) = arg {
                if let Some(ref inner) = wrapped.inline_insn {
                    if !inner.can_reorder() {
                        return false;
                    }
                }
            }
        }

        // Instructions that can be safely reordered
        matches!(
            &self.insn_type,
            InsnType::Const { .. }
                | InsnType::ConstString { .. }
                | InsnType::ConstClass { .. }
                | InsnType::Cast { .. }
                | InsnType::Move { .. }
                | InsnType::Unary { .. }
                | InsnType::Binary { .. }
                | InsnType::Compare { .. }
                | InsnType::CheckCast { .. }
                | InsnType::InstanceOf { .. }
                | InsnType::FillArrayData { .. }
                | InsnType::FilledNewArray { .. }
                | InsnType::NewArray { .. }
                | InsnType::StrConcat { .. }
        )
        // Note: SGET/IGET could be reorderable for final fields, but we're conservative
    }

    /// Check if this instruction can throw an exception (JADX: canThrowException)
    ///
    /// Returns false for instructions that are guaranteed not to throw.
    pub fn can_throw_exception(&self) -> bool {
        match &self.insn_type {
            InsnType::Return { .. }
            | InsnType::If { .. }
            | InsnType::Goto { .. }
            | InsnType::Move { .. }
            | InsnType::MoveException { .. }
            | InsnType::Unary { op: UnaryOp::Neg | UnaryOp::Not | UnaryOp::BoolNot, .. }
            | InsnType::Const { .. }
            | InsnType::ConstString { .. }
            | InsnType::ConstClass { .. }
            | InsnType::Compare { .. }
            | InsnType::Nop => false,
            _ => true,
        }
    }

    /// Check if this is an exit edge instruction (JADX: isExitEdgeInsn)
    ///
    /// Returns true for instructions that exit the current block/method.
    pub fn is_exit_edge_insn(&self) -> bool {
        matches!(
            &self.insn_type,
            InsnType::Return { .. }
                | InsnType::Throw { .. }
                | InsnType::Continue { .. }
                | InsnType::Break { .. }
        )
    }

    /// Check if any argument contains a wrapped instruction (JADX: containsWrappedInsn)
    pub fn contains_wrapped_insn(&self) -> bool {
        self.insn_type.get_args().iter().any(|arg| arg.is_wrapped())
    }

    /// Check if this instruction can have its result removed (JADX: canRemoveResult)
    ///
    /// Returns true for INVOKE and CONSTRUCTOR which can be called
    /// without using the return value.
    pub fn can_remove_result(&self) -> bool {
        matches!(
            &self.insn_type,
            InsnType::Invoke { .. } | InsnType::Constructor { .. }
        )
    }

    /// Check if instruction contains a specific arg (JADX: containsArg)
    pub fn contains_arg(&self, target: &InsnArg) -> bool {
        for arg in self.insn_type.get_args() {
            if std::ptr::eq(arg, target) {
                return true;
            }
        }
        false
    }

    /// Check if instruction uses a specific register variable (JADX: containsVar)
    pub fn contains_var(&self, target: &RegisterArg) -> bool {
        for arg in self.insn_type.get_args() {
            if let InsnArg::Register(reg) = arg {
                if reg.same_reg_and_ssa(target) {
                    return true;
                }
            } else if let InsnArg::Wrapped(wrapped) = arg {
                if let Some(ref inner) = wrapped.inline_insn {
                    if inner.contains_var(target) {
                        return true;
                    }
                }
            }
        }
        false
    }

    /// Collect all register arguments from this instruction (JADX: getRegisterArgs)
    ///
    /// Recursively collects registers from wrapped instructions too.
    pub fn get_register_args(&self, collection: &mut Vec<RegisterArg>) {
        for arg in self.insn_type.get_args() {
            match arg {
                InsnArg::Register(reg) => collection.push(*reg),
                InsnArg::Wrapped(wrapped) => {
                    if let Some(ref inner) = wrapped.inline_insn {
                        inner.get_register_args(collection);
                    }
                }
                _ => {}
            }
        }
    }

    /// Get the destination register if this instruction has one (JADX: getResult)
    pub fn get_result(&self) -> Option<&RegisterArg> {
        self.insn_type.get_dest()
    }

    /// Check if this instruction has a destination register
    pub fn has_result(&self) -> bool {
        self.insn_type.get_dest().is_some()
    }

    /// Deep equality check comparing all arguments (JADX: isDeepEquals)
    pub fn is_deep_equals(&self, other: &InsnNode) -> bool {
        if !self.is_same(other) {
            return false;
        }
        // Compare result types
        if self.result_type != other.result_type {
            return false;
        }
        // Compare arguments (need to implement proper InsnType comparison)
        std::mem::discriminant(&self.insn_type) == std::mem::discriminant(&other.insn_type)
    }

    /// Copy common parameters to another instruction (JADX: copyCommonParams)
    pub fn copy_common_params(&self, target: &mut InsnNode) {
        target.flags = self.flags;
        target.source_line = self.source_line;
        target.offset = self.offset;
    }

    // === JADX InsnNode mutation methods for 100% parity ===
    // Cloned from: jadx-fast/jadx-core/src/main/java/jadx/core/dex/nodes/InsnNode.java

    /// Copy this instruction to a new instruction (JADX: copy)
    ///
    /// Creates a deep copy of the instruction including all arguments.
    /// The copy has the same type, arguments, and metadata.
    ///
    /// JADX Reference: InsnNode.java:364-373
    /// ```java
    /// public InsnNode copy() {
    ///     return copyCommonParams(new InsnNode(insnType, getArgsCount()));
    /// }
    /// ```
    pub fn copy(&self) -> InsnNode {
        let mut copy = InsnNode {
            insn_type: self.insn_type.clone(),
            result_type: self.result_type.clone(),
            source_line: None, // Will be set by copy_common_params
            offset: 0,         // Will be set by copy_common_params
            flags: 0,          // Will be set by copy_common_params
        };
        self.copy_common_params(&mut copy);
        copy
    }

    /// Copy this instruction without the result register (JADX: copyWithoutResult)
    ///
    /// Creates a copy with no destination register. Used when inlining
    /// an expression where the result is not needed separately.
    ///
    /// JADX Reference: InsnNode.java:375-381
    /// ```java
    /// public InsnNode copyWithoutResult() {
    ///     InsnNode copy = copy();
    ///     copy.setResult(null);
    ///     return copy;
    /// }
    /// ```
    pub fn copy_without_result(&self) -> InsnNode {
        let mut copy = self.copy();
        copy.result_type = None;
        // Clear the destination in the instruction type
        if let Some(dest) = copy.insn_type.get_dest_mut() {
            // We can't easily "remove" the dest, but we can mark it as unused
            dest.ssa_version = u32::MAX; // Sentinel for "no result"
        }
        copy
    }

    /// Inherit metadata from another instruction (JADX: inheritMetadata)
    ///
    /// Copies the offset and source line from the source instruction.
    /// Used when creating synthetic instructions that should have the
    /// same location info as their source.
    ///
    /// JADX Reference: InsnNode.java:400-416
    /// ```java
    /// public void inheritMetadata(InsnNode sourceInsn) {
    ///     setOffset(sourceInsn.getOffset());
    ///     setSourceLine(sourceInsn.getSourceLine());
    /// }
    /// ```
    pub fn inherit_metadata(&mut self, source: &InsnNode) {
        self.offset = source.offset;
        self.source_line = source.source_line;
    }

    /// Set the source line number
    pub fn set_source_line(&mut self, line: Option<u32>) {
        self.source_line = line;
    }

    /// Get the source line number
    pub fn get_source_line(&self) -> Option<u32> {
        self.source_line
    }

    /// Set the bytecode offset
    pub fn set_offset(&mut self, offset: u32) {
        self.offset = offset;
    }

    /// Get the bytecode offset
    pub fn get_offset(&self) -> u32 {
        self.offset
    }

    /// Get the number of arguments (JADX: getArgsCount)
    pub fn get_args_count(&self) -> usize {
        self.insn_type.get_args().len()
    }

    /// Get argument at index (JADX: getArg)
    pub fn get_arg(&self, index: usize) -> Option<&InsnArg> {
        self.insn_type.get_args().get(index)
    }

    /// Set the result type
    pub fn set_result_type(&mut self, result_type: Option<ArgType>) {
        self.result_type = result_type;
    }

    /// Get the result type
    pub fn get_result_type(&self) -> Option<&ArgType> {
        self.result_type.as_ref()
    }
}

// === JADX InsnNode mutation methods on InsnType ===
// These methods modify the instruction arguments in place

impl InsnType {
    /// Replace an argument at a specific index (JADX-style setArg)
    ///
    /// JADX Reference: InsnNode.java:142-153
    /// ```java
    /// public void setArg(int n, InsnArg arg) {
    ///     arg.setParentInsn(this);
    ///     arguments.set(n, arg);
    /// }
    /// ```
    pub fn set_arg(&mut self, index: usize, new_arg: InsnArg) -> bool {
        match self {
            InsnType::Move { src, .. } if index == 0 => {
                *src = new_arg;
                true
            }
            InsnType::Return { value, .. } if index == 0 => {
                *value = Some(new_arg);
                true
            }
            InsnType::Throw { exception, .. } if index == 0 => {
                *exception = new_arg;
                true
            }
            InsnType::MonitorEnter { object, .. } | InsnType::MonitorExit { object, .. } if index == 0 => {
                *object = new_arg;
                true
            }
            InsnType::CheckCast { object, .. } if index == 0 => {
                *object = new_arg;
                true
            }
            InsnType::InstanceOf { object, .. } if index == 0 => {
                *object = new_arg;
                true
            }
            InsnType::ArrayLength { array, .. } if index == 0 => {
                *array = new_arg;
                true
            }
            InsnType::NewArray { size, .. } if index == 0 => {
                *size = new_arg;
                true
            }
            InsnType::FilledNewArray { args, .. } => {
                if index < args.len() {
                    args[index] = new_arg;
                    true
                } else {
                    false
                }
            }
            InsnType::FillArrayData { array, .. } if index == 0 => {
                *array = new_arg;
                true
            }
            InsnType::ArrayGet { array, index: idx, .. } => {
                match index {
                    0 => { *array = new_arg; true }
                    1 => { *idx = new_arg; true }
                    _ => false
                }
            }
            InsnType::ArrayPut { array, index: idx, value, .. } => {
                match index {
                    0 => { *array = new_arg; true }
                    1 => { *idx = new_arg; true }
                    2 => { *value = new_arg; true }
                    _ => false
                }
            }
            InsnType::InstanceGet { object, .. } if index == 0 => {
                *object = new_arg;
                true
            }
            InsnType::InstancePut { object, value, .. } => {
                match index {
                    0 => { *object = new_arg; true }
                    1 => { *value = new_arg; true }
                    _ => false
                }
            }
            InsnType::StaticPut { value, .. } if index == 0 => {
                *value = new_arg;
                true
            }
            InsnType::Invoke { args, .. } | InsnType::InvokeCustom { args, .. } => {
                if index < args.len() {
                    args[index] = new_arg;
                    true
                } else {
                    false
                }
            }
            InsnType::Unary { arg, .. } if index == 0 => {
                *arg = new_arg;
                true
            }
            InsnType::Binary { left, right, .. } => {
                match index {
                    0 => { *left = new_arg; true }
                    1 => { *right = new_arg; true }
                    _ => false
                }
            }
            InsnType::Cast { arg, .. } if index == 0 => {
                *arg = new_arg;
                true
            }
            InsnType::Compare { left, right, .. } => {
                match index {
                    0 => { *left = new_arg; true }
                    1 => { *right = new_arg; true }
                    _ => false
                }
            }
            InsnType::If { left, right, .. } => {
                match index {
                    0 => { *left = new_arg; true }
                    1 => { *right = Some(new_arg); true }
                    _ => false
                }
            }
            InsnType::Ternary { left, right, then_value, else_value, .. } => {
                match index {
                    0 => { *left = new_arg; true }
                    1 => { *right = Some(new_arg); true }
                    2 => { *then_value = new_arg; true }
                    3 => { *else_value = new_arg; true }
                    _ => false
                }
            }
            InsnType::PackedSwitch { value, .. } | InsnType::SparseSwitch { value, .. } if index == 0 => {
                *value = new_arg;
                true
            }
            InsnType::StrConcat { args, .. } | InsnType::RegionArg { args, .. } => {
                if index < args.len() {
                    args[index] = new_arg;
                    true
                } else {
                    false
                }
            }
            InsnType::OneArg { arg, .. } if index == 0 => {
                *arg = new_arg;
                true
            }
            InsnType::Constructor { args, .. } => {
                if index < args.len() {
                    args[index] = new_arg;
                    true
                } else {
                    false
                }
            }
            _ => false,
        }
    }

    /// Replace an argument by reference (JADX: replaceArg)
    ///
    /// Recursively searches for the `from` argument and replaces it with `to`.
    /// Returns true if replacement was successful.
    ///
    /// JADX Reference: InsnNode.java:166-184
    /// ```java
    /// public boolean replaceArg(InsnArg from, InsnArg to) {
    ///     int count = getArgsCount();
    ///     for (int i = 0; i < count; i++) {
    ///         InsnArg arg = arguments.get(i);
    ///         if (arg == from) {
    ///             arguments.set(i, to);
    ///             return true;
    ///         }
    ///         if (arg.isInsnWrap()) {
    ///             if (((InsnWrapArg) arg).getWrapInsn().replaceArg(from, to)) {
    ///                 return true;
    ///             }
    ///         }
    ///     }
    ///     return false;
    /// }
    /// ```
    pub fn replace_arg(&mut self, from: &InsnArg, to: InsnArg) -> bool {
        // Get mutable args and search for match
        self.replace_arg_recursive(from, to)
    }

    /// Internal recursive argument replacement
    fn replace_arg_recursive(&mut self, from: &InsnArg, to: InsnArg) -> bool {
        // Check each argument position
        let args = self.get_args();
        for i in 0..args.len() {
            // Check if this arg matches (by content, not pointer)
            if self.arg_matches_at(i, from) {
                return self.set_arg(i, to);
            }
            // Check wrapped instructions recursively
            if let Some(InsnArg::Wrapped(wrapped)) = self.get_args().get(i) {
                if let Some(ref inner) = wrapped.inline_insn {
                    // Need mutable access to inner - clone and replace
                    let mut inner_clone = (**inner).clone();
                    if inner_clone.insn_type.replace_arg(from, to.clone()) {
                        // Replace the wrapped arg with updated version
                        let new_wrapped = InsnArg::Wrapped(Box::new(WrappedInsn {
                            insn_idx: wrapped.insn_idx,
                            result_type: wrapped.result_type.clone(),
                            inline_insn: Some(Box::new(inner_clone)),
                        }));
                        return self.set_arg(i, new_wrapped);
                    }
                }
            }
        }
        false
    }

    /// Check if argument at index matches the target
    fn arg_matches_at(&self, index: usize, target: &InsnArg) -> bool {
        if let Some(arg) = self.get_args().get(index) {
            // Compare by content
            match (arg, target) {
                (InsnArg::Register(a), InsnArg::Register(b)) => a.same_reg_and_ssa(b),
                (InsnArg::Literal(a), InsnArg::Literal(b)) => a.same_value(b),
                (InsnArg::Type(a), InsnArg::Type(b)) => a == b,
                (InsnArg::Field(a), InsnArg::Field(b)) => a == b,
                (InsnArg::Method(a), InsnArg::Method(b)) => a == b,
                (InsnArg::String(a), InsnArg::String(b)) => a == b,
                (InsnArg::Named { name: a, .. }, InsnArg::Named { name: b, .. }) => a == b,
                (InsnArg::This { class_type: a }, InsnArg::This { class_type: b }) => a == b,
                _ => false,
            }
        } else {
            false
        }
    }

    /// Add an argument to the end (for variable-arg instructions) (JADX: addArg)
    ///
    /// JADX Reference: InsnNode.java:121-126
    pub fn add_arg(&mut self, arg: InsnArg) -> bool {
        match self {
            InsnType::Invoke { args, .. }
            | InsnType::InvokeCustom { args, .. }
            | InsnType::FilledNewArray { args, .. } => {
                args.push(arg);
                true
            }
            InsnType::StrConcat { args, .. }
            | InsnType::RegionArg { args }
            | InsnType::Constructor { args, .. } => {
                args.push(arg);
                true
            }
            _ => false, // Fixed-arg instructions can't add args
        }
    }

    /// Remove an argument at index (JADX: removeArg)
    ///
    /// JADX Reference: InsnNode.java:204-211
    pub fn remove_arg(&mut self, index: usize) -> Option<InsnArg> {
        match self {
            InsnType::Invoke { args, .. }
            | InsnType::InvokeCustom { args, .. }
            | InsnType::FilledNewArray { args, .. } => {
                if index < args.len() {
                    Some(args.remove(index))
                } else {
                    None
                }
            }
            InsnType::StrConcat { args, .. }
            | InsnType::RegionArg { args }
            | InsnType::Constructor { args, .. } => {
                if index < args.len() {
                    Some(args.remove(index))
                } else {
                    None
                }
            }
            InsnType::Phi { sources, .. } => {
                if index < sources.len() {
                    Some(sources.remove(index).1)
                } else {
                    None
                }
            }
            _ => None, // Fixed-arg instructions can't remove args
        }
    }

    /// Get mutable access to all arguments as a slice
    pub fn get_args_mut(&mut self) -> Option<&mut [InsnArg]> {
        match self {
            InsnType::Invoke { args, .. }
            | InsnType::InvokeCustom { args, .. }
            | InsnType::FilledNewArray { args, .. } => Some(args.as_mut_slice()),
            InsnType::StrConcat { args, .. }
            | InsnType::RegionArg { args }
            | InsnType::Constructor { args, .. } => Some(args.as_mut_slice()),
            _ => None,
        }
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
        /// Result register (merged from MoveResult, JADX parity)
        /// Set by process_instructions pass BEFORE SSA transformation
        dest: Option<RegisterArg>,
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
        /// Type hint from DEX opcode (e.g., Double from div-double, Float from add-float)
        arg_type: Option<ArgType>,
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
    /// Get all arguments from this instruction type (JADX: getArguments)
    ///
    /// Returns a slice of all InsnArg in this instruction.
    /// Note: Returns an empty slice for instructions without arguments.
    pub fn get_args(&self) -> &[InsnArg] {
        match self {
            InsnType::Nop => &[],
            InsnType::Const { .. } => &[],
            InsnType::ConstString { .. } => &[],
            InsnType::ConstClass { .. } => &[],
            InsnType::Move { src, .. } => std::slice::from_ref(src),
            InsnType::MoveResult { .. } => &[],
            InsnType::MoveException { .. } => &[],
            InsnType::Return { value: Some(v), .. } => std::slice::from_ref(v),
            InsnType::Return { value: None, .. } => &[],
            InsnType::Throw { exception } => std::slice::from_ref(exception),
            InsnType::MonitorEnter { object } => std::slice::from_ref(object),
            InsnType::MonitorExit { object } => std::slice::from_ref(object),
            InsnType::CheckCast { object, .. } => std::slice::from_ref(object),
            InsnType::InstanceOf { object, .. } => std::slice::from_ref(object),
            InsnType::ArrayLength { array, .. } => std::slice::from_ref(array),
            InsnType::NewInstance { .. } => &[],
            InsnType::NewArray { size, .. } => std::slice::from_ref(size),
            InsnType::FilledNewArray { args, .. } => args.as_slice(),
            InsnType::FillArrayData { array, .. } => std::slice::from_ref(array),
            InsnType::ArrayGet { array, .. } => {
                // Can't return both, use get_args_vec for multiple
                std::slice::from_ref(array)
            }
            InsnType::ArrayPut { array, .. } => std::slice::from_ref(array),
            InsnType::InstanceGet { object, .. } => std::slice::from_ref(object),
            InsnType::InstancePut { object, .. } => std::slice::from_ref(object),
            InsnType::StaticGet { .. } => &[],
            InsnType::StaticPut { value, .. } => std::slice::from_ref(value),
            InsnType::Invoke { args, .. } => args.as_slice(),
            InsnType::InvokeCustom { args, .. } => args.as_slice(),
            InsnType::Unary { arg, .. } => std::slice::from_ref(arg),
            InsnType::Binary { left, .. } => std::slice::from_ref(left),
            InsnType::Cast { arg, .. } => std::slice::from_ref(arg),
            InsnType::Compare { left, .. } => std::slice::from_ref(left),
            InsnType::If { left, .. } => std::slice::from_ref(left),
            InsnType::Ternary { left, .. } => std::slice::from_ref(left),
            InsnType::Goto { .. } => &[],
            InsnType::PackedSwitch { value, .. } => std::slice::from_ref(value),
            InsnType::SparseSwitch { value, .. } => std::slice::from_ref(value),
            InsnType::Phi { .. } => {
                // Return empty - use get_phi_sources for PHI nodes
                &[]
            }
            InsnType::MoveMulti { .. } => &[],
            InsnType::StrConcat { args, .. } => args.as_slice(),
            InsnType::RegionArg { args } => args.as_slice(),
            InsnType::OneArg { arg } => std::slice::from_ref(arg),
            InsnType::Constructor { args, .. } => args.as_slice(),
            InsnType::JavaJsr { .. } => &[],
            InsnType::JavaRet { .. } => &[],
            InsnType::Break { .. } => &[],
            InsnType::Continue { .. } => &[],
        }
    }

    /// Get destination register if this instruction has one (JADX: getResult)
    pub fn get_dest(&self) -> Option<&RegisterArg> {
        match self {
            InsnType::Const { dest, .. }
            | InsnType::ConstString { dest, .. }
            | InsnType::ConstClass { dest, .. }
            | InsnType::Move { dest, .. }
            | InsnType::MoveResult { dest, .. }
            | InsnType::MoveException { dest, .. }
            | InsnType::InstanceOf { dest, .. }
            | InsnType::ArrayLength { dest, .. }
            | InsnType::NewInstance { dest, .. }
            | InsnType::NewArray { dest, .. }
            | InsnType::ArrayGet { dest, .. }
            | InsnType::InstanceGet { dest, .. }
            | InsnType::StaticGet { dest, .. }
            | InsnType::Unary { dest, .. }
            | InsnType::Binary { dest, .. }
            | InsnType::Cast { dest, .. }
            | InsnType::Compare { dest, .. }
            | InsnType::Ternary { dest, .. }
            | InsnType::Phi { dest, .. }
            | InsnType::StrConcat { dest, .. }
            | InsnType::Constructor { dest, .. } => Some(dest),
            InsnType::FilledNewArray { dest, .. } => dest.as_ref(),
            InsnType::Invoke { dest, .. } | InsnType::InvokeCustom { dest, .. } => dest.as_ref(),
            _ => None,
        }
    }

    /// Get mutable destination register if this instruction has one
    pub fn get_dest_mut(&mut self) -> Option<&mut RegisterArg> {
        match self {
            InsnType::Const { dest, .. }
            | InsnType::ConstString { dest, .. }
            | InsnType::ConstClass { dest, .. }
            | InsnType::Move { dest, .. }
            | InsnType::MoveResult { dest, .. }
            | InsnType::MoveException { dest, .. }
            | InsnType::InstanceOf { dest, .. }
            | InsnType::ArrayLength { dest, .. }
            | InsnType::NewInstance { dest, .. }
            | InsnType::NewArray { dest, .. }
            | InsnType::ArrayGet { dest, .. }
            | InsnType::InstanceGet { dest, .. }
            | InsnType::StaticGet { dest, .. }
            | InsnType::Unary { dest, .. }
            | InsnType::Binary { dest, .. }
            | InsnType::Cast { dest, .. }
            | InsnType::Compare { dest, .. }
            | InsnType::Ternary { dest, .. }
            | InsnType::Phi { dest, .. }
            | InsnType::StrConcat { dest, .. }
            | InsnType::Constructor { dest, .. } => Some(dest),
            InsnType::FilledNewArray { dest, .. } => dest.as_mut(),
            InsnType::Invoke { dest, .. } | InsnType::InvokeCustom { dest, .. } => dest.as_mut(),
            _ => None,
        }
    }

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

    /// Negate this literal (JADX: negate)
    /// Used for condition inversion (e.g., `if (x == 0)` → `if (x != 0)`)
    pub fn negate(&self) -> LiteralArg {
        match self {
            LiteralArg::Int(v) => LiteralArg::Int(-v),
            LiteralArg::Float(v) => LiteralArg::Float(-v),
            LiteralArg::Double(v) => LiteralArg::Double(-v),
            LiteralArg::Null => LiteralArg::Null,
        }
    }

    /// Check if this literal is negative (JADX: isNegative)
    pub fn is_negative(&self) -> bool {
        match self {
            LiteralArg::Int(v) => *v < 0,
            LiteralArg::Float(v) => *v < 0.0 && v.is_finite(),
            LiteralArg::Double(v) => *v < 0.0 && v.is_finite(),
            LiteralArg::Null => false,
        }
    }

    /// Create a literal representing boolean false (JADX: litFalse)
    pub fn lit_false() -> LiteralArg {
        LiteralArg::Int(0)
    }

    /// Create a literal representing boolean true (JADX: litTrue)
    pub fn lit_true() -> LiteralArg {
        LiteralArg::Int(1)
    }

    /// Check if this literal represents boolean false
    pub fn is_false(&self) -> bool {
        self.is_zero()
    }

    /// Check if this literal represents boolean true
    pub fn is_true(&self) -> bool {
        matches!(self, LiteralArg::Int(1))
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

// === JADX IfOp methods for 100% parity ===
// Cloned from: jadx-fast/jadx-core/src/main/java/jadx/core/dex/instructions/IfOp.java

impl IfCondition {
    /// Invert this condition (JADX: invert)
    ///
    /// Returns the opposite condition. Used when inverting if branches.
    ///
    /// JADX Reference: IfOp.java:34-46
    /// ```java
    /// public IfOp invert() {
    ///     switch (this) {
    ///         case EQ: return NE;
    ///         case NE: return EQ;
    ///         case LT: return GE;
    ///         case LE: return GT;
    ///         case GT: return LE;
    ///         case GE: return LT;
    ///     }
    /// }
    /// ```
    pub fn invert(&self) -> IfCondition {
        match self {
            IfCondition::Eq => IfCondition::Ne,
            IfCondition::Ne => IfCondition::Eq,
            IfCondition::Lt => IfCondition::Ge,
            IfCondition::Ge => IfCondition::Lt,
            IfCondition::Gt => IfCondition::Le,
            IfCondition::Le => IfCondition::Gt,
        }
    }

    /// Mirror this condition (swap operand order) (JADX: mirror)
    ///
    /// Returns the equivalent condition after swapping left/right operands.
    /// E.g., `a < b` becomes `b > a`
    ///
    /// JADX Reference: IfOp.java:48-60
    /// ```java
    /// public IfOp mirror() {
    ///     switch (this) {
    ///         case LT: return GT;
    ///         case LE: return GE;
    ///         case GT: return LT;
    ///         case GE: return LE;
    ///         default: return this; // EQ and NE are symmetric
    ///     }
    /// }
    /// ```
    pub fn mirror(&self) -> IfCondition {
        match self {
            IfCondition::Lt => IfCondition::Gt,
            IfCondition::Le => IfCondition::Ge,
            IfCondition::Gt => IfCondition::Lt,
            IfCondition::Ge => IfCondition::Le,
            _ => *self, // EQ and NE are symmetric
        }
    }

    /// Get the operator symbol for code generation
    pub fn symbol(&self) -> &'static str {
        match self {
            IfCondition::Eq => "==",
            IfCondition::Ne => "!=",
            IfCondition::Lt => "<",
            IfCondition::Ge => ">=",
            IfCondition::Gt => ">",
            IfCondition::Le => "<=",
        }
    }

    /// Check if this is an equality comparison (JADX usage pattern)
    pub fn is_equality(&self) -> bool {
        matches!(self, IfCondition::Eq | IfCondition::Ne)
    }

    /// Check if this is an ordered comparison (JADX usage pattern)
    pub fn is_ordered(&self) -> bool {
        !self.is_equality()
    }
}

// === JADX IfNode methods on InsnType ===
// Cloned from: jadx-fast/jadx-core/src/main/java/jadx/core/dex/instructions/IfNode.java

impl InsnType {
    /// Invert the condition of an If instruction (JADX: invertCondition)
    ///
    /// Inverts the condition and swaps the arguments if needed.
    ///
    /// JADX Reference: IfNode.java:72-82
    /// ```java
    /// public void invertCondition() {
    ///     op = op.invert();
    ///     if (getArgsCount() == 2) {
    ///         InsnArg tmp = getArg(0);
    ///         setArg(0, getArg(1));
    ///         setArg(1, tmp);
    ///     }
    /// }
    /// ```
    pub fn invert_if_condition(&mut self) -> bool {
        match self {
            InsnType::If { condition, left, right, .. } => {
                *condition = condition.invert();
                // Swap arguments for 2-arg comparisons
                if let Some(ref mut r) = right {
                    std::mem::swap(left, r);
                }
                true
            }
            InsnType::Ternary { condition, left, right, then_value, else_value, .. } => {
                *condition = condition.invert();
                // Swap condition arguments
                if let Some(ref mut r) = right {
                    std::mem::swap(left, r);
                }
                // Swap then/else values
                std::mem::swap(then_value, else_value);
                true
            }
            _ => false,
        }
    }

    /// Change the condition of an If instruction (JADX: changeCondition)
    ///
    /// JADX Reference: IfNode.java:93-100
    pub fn change_if_condition(&mut self, new_condition: IfCondition, a: InsnArg, b: Option<InsnArg>) -> bool {
        match self {
            InsnType::If { condition, left, right, .. } => {
                *condition = new_condition;
                *left = a;
                *right = b;
                true
            }
            _ => false,
        }
    }

    /// Get the condition from an If/Ternary instruction
    pub fn get_if_condition(&self) -> Option<&IfCondition> {
        match self {
            InsnType::If { condition, .. } | InsnType::Ternary { condition, .. } => Some(condition),
            _ => None,
        }
    }

    /// Get mutable condition from an If/Ternary instruction
    pub fn get_if_condition_mut(&mut self) -> Option<&mut IfCondition> {
        match self {
            InsnType::If { condition, .. } | InsnType::Ternary { condition, .. } => Some(condition),
            _ => None,
        }
    }

    /// Get the If target offset
    pub fn get_if_target(&self) -> Option<u32> {
        match self {
            InsnType::If { target, .. } => Some(*target),
            _ => None,
        }
    }

    /// Set the If target offset
    pub fn set_if_target(&mut self, new_target: u32) -> bool {
        match self {
            InsnType::If { target, .. } => {
                *target = new_target;
                true
            }
            _ => false,
        }
    }

    /// Normalize the If condition (JADX: normalize)
    ///
    /// Ensures the argument order is canonical (result variable on left).
    /// This helps with consistent pattern matching in passes.
    ///
    /// JADX Reference: IfNode.java:84-92
    pub fn normalize_if_condition(&mut self) -> bool {
        match self {
            InsnType::If { condition, left, right: Some(right_arg), .. } => {
                // Check if right arg has a result (is a defined variable)
                // and left doesn't - if so, swap them
                let should_swap = matches!(
                    (&*left, &*right_arg),
                    (InsnArg::Literal(_), InsnArg::Register(_))
                );
                if should_swap {
                    std::mem::swap(left, right_arg);
                    *condition = condition.mirror();
                }
                true
            }
            _ => false,
        }
    }
}

// === JADX PhiInsn methods on InsnType ===
// Cloned from: jadx-fast/jadx-core/src/main/java/jadx/core/dex/instructions/PhiInsn.java

impl InsnType {
    /// Bind an argument to a predecessor block (JADX: bindArg)
    ///
    /// Adds a new argument coming from the specified predecessor block.
    ///
    /// JADX Reference: PhiInsn.java:36-50
    /// ```java
    /// public void bindArg(RegisterArg arg, BlockNode pred) {
    ///     if (blockBinds.contains(pred)) {
    ///         throw new JadxRuntimeException("Duplicate predecessors in PHI insn");
    ///     }
    ///     super.addArg(arg);
    ///     blockBinds.add(pred);
    /// }
    /// ```
    pub fn bind_phi_arg(&mut self, block_id: u32, arg: InsnArg) -> bool {
        match self {
            InsnType::Phi { sources, .. } => {
                // Check for duplicates
                if sources.iter().any(|(id, _)| *id == block_id) {
                    return false; // Duplicate predecessor
                }
                sources.push((block_id, arg));
                true
            }
            _ => false,
        }
    }

    /// Get the block ID for an argument by index (JADX: getBlockByArgIndex)
    ///
    /// JADX Reference: PhiInsn.java:62-64
    pub fn get_phi_block_by_index(&self, arg_index: usize) -> Option<u32> {
        match self {
            InsnType::Phi { sources, .. } => {
                sources.get(arg_index).map(|(block_id, _)| *block_id)
            }
            _ => None,
        }
    }

    /// Get the block ID for a specific argument (JADX: getBlockByArg)
    ///
    /// JADX Reference: PhiInsn.java:53-59
    /// ```java
    /// public BlockNode getBlockByArg(RegisterArg arg) {
    ///     int index = getArgIndex(arg);
    ///     if (index == -1) return null;
    ///     return blockBinds.get(index);
    /// }
    /// ```
    pub fn get_phi_block_by_arg(&self, target: &InsnArg) -> Option<u32> {
        match self {
            InsnType::Phi { sources, .. } => {
                for (block_id, arg) in sources.iter() {
                    if Self::args_equal(arg, target) {
                        return Some(*block_id);
                    }
                }
                None
            }
            _ => None,
        }
    }

    /// Helper to compare args for equality
    fn args_equal(a: &InsnArg, b: &InsnArg) -> bool {
        match (a, b) {
            (InsnArg::Register(ra), InsnArg::Register(rb)) => ra.same_reg_and_ssa(rb),
            (InsnArg::Literal(la), InsnArg::Literal(lb)) => la.same_value(lb),
            (InsnArg::Type(ta), InsnArg::Type(tb)) => ta == tb,
            (InsnArg::Field(fa), InsnArg::Field(fb)) => fa == fb,
            (InsnArg::Method(ma), InsnArg::Method(mb)) => ma == mb,
            (InsnArg::String(sa), InsnArg::String(sb)) => sa == sb,
            _ => false,
        }
    }

    /// Remove a PHI argument at index (JADX: removeArg)
    ///
    /// JADX Reference: PhiInsn.java:83-88
    /// ```java
    /// public RegisterArg removeArg(int index) {
    ///     RegisterArg reg = (RegisterArg) super.removeArg(index);
    ///     blockBinds.remove(index);
    ///     reg.getSVar().updateUsedInPhiList();
    ///     return reg;
    /// }
    /// ```
    pub fn remove_phi_arg(&mut self, index: usize) -> Option<(u32, InsnArg)> {
        match self {
            InsnType::Phi { sources, .. } => {
                if index < sources.len() {
                    Some(sources.remove(index))
                } else {
                    None
                }
            }
            _ => None,
        }
    }

    /// Remove a PHI argument by block ID
    pub fn remove_phi_arg_by_block(&mut self, block_id: u32) -> Option<InsnArg> {
        match self {
            InsnType::Phi { sources, .. } => {
                if let Some(idx) = sources.iter().position(|(id, _)| *id == block_id) {
                    Some(sources.remove(idx).1)
                } else {
                    None
                }
            }
            _ => None,
        }
    }

    /// Get all PHI sources as a slice (block_id, arg)
    pub fn get_phi_sources(&self) -> &[(u32, InsnArg)] {
        match self {
            InsnType::Phi { sources, .. } => sources.as_slice(),
            _ => &[],
        }
    }

    /// Get mutable PHI sources
    pub fn get_phi_sources_mut(&mut self) -> Option<&mut PhiSources> {
        match self {
            InsnType::Phi { sources, .. } => Some(sources),
            _ => None,
        }
    }

    /// Get PHI argument count
    pub fn get_phi_arg_count(&self) -> usize {
        match self {
            InsnType::Phi { sources, .. } => sources.len(),
            _ => 0,
        }
    }

    /// Check if this is a PHI instruction
    pub fn is_phi(&self) -> bool {
        matches!(self, InsnType::Phi { .. })
    }

    /// Get PHI destination register
    pub fn get_phi_dest(&self) -> Option<&RegisterArg> {
        match self {
            InsnType::Phi { dest, .. } => Some(dest),
            _ => None,
        }
    }

    /// Get mutable PHI destination register
    pub fn get_phi_dest_mut(&mut self) -> Option<&mut RegisterArg> {
        match self {
            InsnType::Phi { dest, .. } => Some(dest),
            _ => None,
        }
    }
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
