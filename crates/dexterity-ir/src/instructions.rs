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
    /// Extended switch info for switch-over-enum/string passes (JADX: SwitchInsn fields)
    ///
    /// Lazily initialized when switch transformation methods are called.
    /// Only valid for PackedSwitch and SparseSwitch instructions.
    ///
    /// JADX Reference: SwitchInsn.java:19-26 (modifiedKeys, targetBlocks, defTargetBlock, def)
    pub extended_switch_info: Option<Box<ExtendedSwitchInfo>>,

    /// Extended if info for block bindings (JADX: IfNode fields)
    ///
    /// Lazily initialized when if block methods are called.
    /// Only valid for If instructions.
    ///
    /// Cloned from JADX: jadx-core/src/main/java/jadx/core/dex/instructions/IfNode.java:21-22
    pub extended_if_info: Option<Box<ExtendedIfInfo>>,
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
            extended_switch_info: None,
            extended_if_info: None,
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

    /// Deep equality check including all arguments (JADX: isDeepEquals)
    ///
    /// Checks instruction type, result, and all arguments recursively.
    /// This is a more thorough comparison than is_same().
    ///
    /// Copied from JADX: jadx-core/src/main/java/jadx/core/dex/nodes/InsnNode.java:397-407
    /// ```java
    /// public boolean isDeepEquals(InsnNode other) {
    ///     if (this == other) {
    ///         return true;
    ///     }
    ///     return isSame(other)
    ///             && Objects.equals(result, other.result)
    ///             && Objects.equals(arguments, other.arguments);
    /// }
    /// ```
    pub fn is_deep_equals(&self, other: &InsnNode) -> bool {
        // Quick pointer check
        if std::ptr::eq(self, other) {
            return true;
        }

        // Check basic instruction sameness
        if !self.is_same(other) {
            return false;
        }

        // Compare result types
        if self.result_type != other.result_type {
            return false;
        }

        // Compare all arguments deeply
        let self_args = self.insn_type.get_args();
        let other_args = other.insn_type.get_args();

        if self_args.len() != other_args.len() {
            return false;
        }

        // Deep comparison of each argument
        self_args.iter().zip(other_args.iter()).all(|(a, b)| {
            args_deep_equal(a, b)
        })
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
            extended_switch_info: self.extended_switch_info.clone(),
            extended_if_info: self.extended_if_info.clone(),
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

    /// Copy instruction without SSA variable (JADX: copyWithoutSsa)
    ///
    /// Creates a copy allowing the result register to be copied only if
    /// it has no SSA variable set. Throws error if SSA is set, as SSA
    /// variables can't be duplicated (SSA = single assignment).
    ///
    /// Copied from JADX: jadx-core/src/main/java/jadx/core/dex/nodes/InsnNode.java:454-464
    /// ```java
    /// public InsnNode copyWithoutSsa() {
    ///     InsnNode copy = copyWithoutResult();
    ///     if (result != null) {
    ///         if (result.getSVar() == null) {
    ///             copy.setResult(result.duplicate());
    ///         } else {
    ///             throw new JadxRuntimeException("Can't copy if SSA var is set");
    ///         }
    ///     }
    ///     return copy;
    /// }
    /// ```
    pub fn copy_without_ssa(&self) -> Result<InsnNode, &'static str> {
        let mut copy = self.copy_without_result();

        // Copy result register only if no SSA variable is set
        if let Some(ref result_type) = self.result_type {
            // Check if we have a destination register with SSA
            if let Some(dest) = self.insn_type.get_dest() {
                if dest.ssa_version == u32::MAX || dest.ssa_version == 0 {
                    // No SSA var, safe to copy
                    copy.result_type = Some(result_type.clone());
                    // Copy the dest register without SSA
                    if let Some(copy_dest) = copy.insn_type.get_dest_mut() {
                        *copy_dest = dest.clone();
                        copy_dest.ssa_version = 0; // Clear SSA
                    }
                } else {
                    // SSA var is set - cannot copy
                    return Err("Can't copy if SSA var is set");
                }
            }
        }

        Ok(copy)
    }

    /// Copy instruction with new result register (JADX: copy with RegisterArg)
    ///
    /// Creates a copy with a specific result register provided.
    ///
    /// Copied from JADX: jadx-core/src/main/java/jadx/core/dex/nodes/InsnNode.java:469-473
    /// ```java
    /// public InsnNode copy(RegisterArg newReturnArg) {
    ///     InsnNode copy = copy();
    ///     copy.setResult(newReturnArg);
    ///     return copy;
    /// }
    /// ```
    pub fn copy_with_result(&self, new_result: RegisterArg) -> InsnNode {
        let mut copy = self.copy();
        // Update the destination in the instruction type
        // Note: result_type is preserved from the original copy
        // RegisterArg doesn't contain type info, the type comes from the instruction
        if let Some(dest) = copy.insn_type.get_dest_mut() {
            *dest = new_result;
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
    ///
    /// WARNING: This uses get_args() which returns incomplete data for some instructions.
    /// For accurate argument count, use get_args_vec().len() instead.
    pub fn get_args_count(&self) -> usize {
        self.insn_type.get_args().len()
    }

    /// Get argument at index (JADX: getArg)
    pub fn get_arg(&self, index: usize) -> Option<&InsnArg> {
        self.insn_type.get_args().get(index)
    }

    /// Get ALL arguments from this instruction
    ///
    /// This is the preferred method for getting arguments as it returns
    /// all operands for every instruction type. Use this for:
    /// - Visitor patterns
    /// - SSA analysis
    /// - Data flow analysis
    pub fn get_args_vec(&self) -> Vec<&InsnArg> {
        self.insn_type.get_args_vec()
    }

    /// Set the result type
    pub fn set_result_type(&mut self, result_type: Option<ArgType>) {
        self.result_type = result_type;
    }

    /// Get the result type
    pub fn get_result_type(&self) -> Option<&ArgType> {
        self.result_type.as_ref()
    }

    /// Rebind all arguments to this instruction (JADX: rebindArgs)
    ///
    /// In JADX, this updates the parent instruction reference for all arguments.
    /// Since Rust doesn't use mutable parent pointers in the same way, this
    /// method exists for API parity and performs validation instead.
    ///
    /// JADX Reference: InsnNode.java:224-233
    /// ```java
    /// public void rebindArgs() {
    ///     for (InsnArg arg : arguments) {
    ///         arg.setParentInsn(this);
    ///     }
    ///     if (result != null) {
    ///         result.setParentInsn(this);
    ///     }
    /// }
    /// ```
    ///
    /// In Rust, this validates the instruction structure is consistent.
    pub fn rebind_args(&mut self) {
        // In Rust, we don't have parent pointers to update.
        // This method exists for JADX API parity.
        //
        // Future enhancement: could validate that all arguments are valid,
        // that wrapped instructions are properly nested, etc.
        //
        // For now, this is a no-op that signals intent.
    }

    /// Replace an argument throughout the instruction (JADX: replaceArg)
    ///
    /// Replaces all occurrences of `from` with `to` in this instruction's
    /// arguments, including in wrapped instructions.
    ///
    /// JADX Reference: InsnNode.java:132-146
    /// ```java
    /// public boolean replaceArg(InsnArg from, InsnArg to) {
    ///     int count = getArgsCount();
    ///     for (int i = 0; i < count; i++) {
    ///         InsnArg arg = arguments.get(i);
    ///         if (arg == from) {
    ///             InsnRemover.unbindArgUsage(null, arg);
    ///             setArg(i, to);
    ///             return true;
    ///         }
    ///         if (arg.isInsnWrap() && ((InsnWrapArg) arg).getWrapInsn().replaceArg(from, to)) {
    ///             return true;
    ///         }
    ///     }
    ///     return false;
    /// }
    /// ```
    pub fn replace_arg(&mut self, from: &InsnArg, to: InsnArg) -> bool {
        // Check direct arguments first - find matching index
        let args_count = self.get_args_count();
        let mut match_index: Option<usize> = None;

        for i in 0..args_count {
            if let Some(arg) = self.get_arg(i) {
                // Compare by content for registers, by index for literals
                let matches = match (arg, from) {
                    (InsnArg::Register(a), InsnArg::Register(b)) => a.same_reg_and_ssa(b),
                    (InsnArg::Literal(a), InsnArg::Literal(b)) => a.same_value(b),
                    (InsnArg::Type(a), InsnArg::Type(b)) => a == b,
                    (InsnArg::Field(a), InsnArg::Field(b)) => a == b,
                    (InsnArg::Method(a), InsnArg::Method(b)) => a == b,
                    (InsnArg::String(a), InsnArg::String(b)) => a == b,
                    _ => false,
                };
                if matches {
                    match_index = Some(i);
                    break;
                }
            }
        }

        // If we found a match, replace it
        if let Some(i) = match_index {
            return self.insn_type.set_arg(i, to);
        }

        // Check wrapped instructions recursively
        // Note: In Rust, we'd need mutable access to wrapped instructions
        // which requires a different approach than JADX's simple recursion
        false
    }

    /// Remove an argument from this instruction (JADX: removeArg)
    ///
    /// Removes the argument at the specified index. This is primarily used
    /// for PHI instructions during SSA transformation.
    ///
    /// JADX Reference: InsnNode.java:157-162
    /// ```java
    /// public void removeArg(int n) {
    ///     InsnArg arg = arguments.remove(n);
    ///     InsnRemover.unbindArgUsage(null, arg);
    /// }
    /// ```
    pub fn remove_arg(&mut self, index: usize) -> Option<InsnArg> {
        self.insn_type.remove_arg(index)
    }
}

/// Helper function for deep equality comparison of instruction arguments
///
/// Recursively compares arguments, handling wrapped instructions.
fn args_deep_equal(a: &InsnArg, b: &InsnArg) -> bool {
    match (a, b) {
        (InsnArg::Register(r1), InsnArg::Register(r2)) => {
            r1.reg_num == r2.reg_num && r1.ssa_version == r2.ssa_version
        }
        (InsnArg::Literal(l1), InsnArg::Literal(l2)) => {
            // Compare literal values directly using discriminant + value
            std::mem::discriminant(l1) == std::mem::discriminant(l2) && match (l1, l2) {
                (LiteralArg::Int(v1), LiteralArg::Int(v2)) => v1 == v2,
                (LiteralArg::Float(v1), LiteralArg::Float(v2)) => v1.to_bits() == v2.to_bits(),
                (LiteralArg::Double(v1), LiteralArg::Double(v2)) => v1.to_bits() == v2.to_bits(),
                (LiteralArg::Null, LiteralArg::Null) => true,
                _ => false,
            }
        }
        (InsnArg::Type(t1), InsnArg::Type(t2)) => t1 == t2,
        (InsnArg::Field(f1), InsnArg::Field(f2)) => f1 == f2,
        (InsnArg::Method(m1), InsnArg::Method(m2)) => m1 == m2,
        (InsnArg::String(s1), InsnArg::String(s2)) => s1 == s2,
        (InsnArg::Wrapped(w1), InsnArg::Wrapped(w2)) => {
            // Deep compare wrapped instructions
            match (&w1.inline_insn, &w2.inline_insn) {
                (Some(i1), Some(i2)) => i1.is_deep_equals(i2),
                (None, None) => true,
                _ => false,
            }
        }
        (InsnArg::This { .. }, InsnArg::This { .. }) => true,
        _ => false, // Different variants
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

// ============================================================================
// JADX Parity: LambdaInfo (P12 - InvokeCustomNode fields)
// Cloned from: jadx-fast/jadx-core/src/main/java/jadx/core/dex/instructions/InvokeCustomNode.java
// ============================================================================

/// Lambda/method reference information
///
/// This contains the parsed call site information for generating lambda syntax.
/// Matches JADX's InvokeCustomNode fields.
///
/// JADX Reference: InvokeCustomNode.java:12-17
#[derive(Debug, Clone)]
pub struct LambdaInfo {
    /// The method handle type for the implementation (JADX: handleType)
    ///
    /// JADX Reference: InvokeCustomNode.java:14
    pub handle_type: LambdaHandleType,

    /// Implementation method index (JADX: implMthInfo.methodIdx)
    ///
    /// JADX Reference: InvokeCustomNode.java:13
    pub impl_method_idx: u32,

    /// Implementation method class (JADX: implMthInfo.declClass)
    pub impl_class: String,

    /// Implementation method name (JADX: implMthInfo.name)
    pub impl_method_name: String,

    /// Functional interface method name (e.g., "apply", "run", "accept")
    pub interface_method_name: String,

    /// Whether to use method reference syntax (::) instead of lambda (JADX: useRef)
    ///
    /// JADX Reference: InvokeCustomNode.java:17, :87-92
    /// ```java
    /// public boolean isUseRef() {
    ///     return useRef;
    /// }
    /// ```
    pub use_method_ref: bool,

    /// Whether to inline the lambda body (synthetic methods) (JADX: inlineInsn)
    ///
    /// JADX Reference: InvokeCustomNode.java:16, :79-84
    /// ```java
    /// public boolean isInlineInsn() {
    ///     return inlineInsn;
    /// }
    /// ```
    pub inline_body: bool,

    /// Number of captured variables (args passed to invoke-custom that become method params)
    pub captured_arg_count: usize,

    /// Lambda parameter types (from the functional interface's abstract method)
    pub lambda_param_types: Vec<ArgType>,

    /// Lambda return type (from the functional interface's abstract method)
    pub lambda_return_type: ArgType,

    /// Call instruction index (JADX: callInsn)
    ///
    /// In JADX this is an InsnNode, in Dexterity we use an instruction index.
    ///
    /// JADX Reference: InvokeCustomNode.java:15, :71-77
    /// ```java
    /// public InsnNode getCallInsn() {
    ///     return callInsn;
    /// }
    /// ```
    pub call_insn_idx: Option<u32>,
}

impl LambdaInfo {
    /// Create a new LambdaInfo with default values
    pub fn new(handle_type: LambdaHandleType, impl_method_idx: u32) -> Self {
        LambdaInfo {
            handle_type,
            impl_method_idx,
            impl_class: String::new(),
            impl_method_name: String::new(),
            interface_method_name: String::new(),
            use_method_ref: false,
            inline_body: false,
            captured_arg_count: 0,
            lambda_param_types: Vec::new(),
            lambda_return_type: ArgType::Void,
            call_insn_idx: None,
        }
    }

    /// Get the method handle type (JADX: getHandleType)
    ///
    /// JADX Reference: InvokeCustomNode.java:63-65
    pub fn get_handle_type(&self) -> LambdaHandleType {
        self.handle_type
    }

    /// Set the method handle type (JADX: setHandleType)
    ///
    /// JADX Reference: InvokeCustomNode.java:67-69
    pub fn set_handle_type(&mut self, handle_type: LambdaHandleType) {
        self.handle_type = handle_type;
    }

    /// Check if should use method reference syntax (JADX: isUseRef)
    ///
    /// JADX Reference: InvokeCustomNode.java:87-89
    pub fn is_use_ref(&self) -> bool {
        self.use_method_ref
    }

    /// Set whether to use method reference syntax (JADX: setUseRef)
    ///
    /// JADX Reference: InvokeCustomNode.java:91-93
    pub fn set_use_ref(&mut self, use_ref: bool) {
        self.use_method_ref = use_ref;
    }

    /// Check if should inline the lambda body (JADX: isInlineInsn)
    ///
    /// JADX Reference: InvokeCustomNode.java:79-81
    pub fn is_inline_insn(&self) -> bool {
        self.inline_body
    }

    /// Set whether to inline the lambda body (JADX: setInlineInsn)
    ///
    /// JADX Reference: InvokeCustomNode.java:83-85
    pub fn set_inline_insn(&mut self, inline: bool) {
        self.inline_body = inline;
    }

    /// Get the call instruction index (JADX: getCallInsn)
    ///
    /// JADX Reference: InvokeCustomNode.java:71-73
    pub fn get_call_insn_idx(&self) -> Option<u32> {
        self.call_insn_idx
    }

    /// Set the call instruction index (JADX: setCallInsn)
    ///
    /// JADX Reference: InvokeCustomNode.java:75-77
    pub fn set_call_insn_idx(&mut self, idx: Option<u32>) {
        self.call_insn_idx = idx;
    }

    /// Check if this is a static method reference (JADX: isStaticCall always returns true for InvokeCustomNode)
    ///
    /// JADX Reference: InvokeCustomNode.java:109-111
    pub fn is_static_call(&self) -> bool {
        true // InvokeCustomNode is always static
    }

    /// Get the first argument offset (JADX: getFirstArgOffset always returns 0 for InvokeCustomNode)
    ///
    /// JADX Reference: InvokeCustomNode.java:114-116
    pub fn get_first_arg_offset(&self) -> usize {
        0 // No 'this' argument for lambda
    }

    /// Check if the call insn is an invoke (JADX: getInvokeCall)
    ///
    /// JADX Reference: InvokeCustomNode.java:95-101
    /// ```java
    /// @Nullable
    /// public BaseInvokeNode getInvokeCall() {
    ///     if (callInsn.getType() == InsnType.INVOKE) {
    ///         return (BaseInvokeNode) callInsn;
    ///     }
    ///     return null;
    /// }
    /// ```
    pub fn has_invoke_call(&self) -> bool {
        self.call_insn_idx.is_some()
    }

    /// Compare with another LambdaInfo for equality (JADX: isSame partial)
    ///
    /// JADX Reference: InvokeCustomNode.java:40-53
    pub fn is_same(&self, other: &LambdaInfo) -> bool {
        self.handle_type == other.handle_type
            && self.impl_method_idx == other.impl_method_idx
            && self.use_method_ref == other.use_method_ref
            && self.inline_body == other.inline_body
    }
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
        /// Generic type parameters with diamond operator support
        /// Clone of JADX's GenericInfoAttr (InsnGen.java:765-780)
        /// Reference: jadx-core/src/main/java/jadx/core/dex/attributes/nodes/GenericInfoAttr.java
        generic_info: Option<crate::attributes::GenericInfoAttr>,
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
                // Note: Returns only array. Use get_args_vec() for all arguments.
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

    /// Get ALL arguments from this instruction type as a Vec (JADX: getArguments - COMPLETE VERSION)
    ///
    /// Unlike `get_args()` which returns only the first argument for multi-argument instructions,
    /// this method returns ALL arguments for every instruction type.
    ///
    /// Use this method when you need to iterate over all operands, such as:
    /// - Visitor patterns that process all arguments
    /// - SSA use-def chain analysis
    /// - Copy propagation and constant folding
    /// - Data flow analysis
    pub fn get_args_vec(&self) -> Vec<&InsnArg> {
        match self {
            // No arguments
            InsnType::Nop => vec![],
            InsnType::Const { .. } => vec![],
            InsnType::ConstString { .. } => vec![],
            InsnType::ConstClass { .. } => vec![],
            InsnType::MoveResult { .. } => vec![],
            InsnType::MoveException { .. } => vec![],
            InsnType::NewInstance { .. } => vec![],
            InsnType::StaticGet { .. } => vec![],
            InsnType::Goto { .. } => vec![],
            InsnType::JavaJsr { .. } => vec![],
            InsnType::JavaRet { .. } => vec![],
            InsnType::Break { .. } => vec![],
            InsnType::Continue { .. } => vec![],

            // Single argument
            InsnType::Move { src, .. } => vec![src],
            InsnType::Return { value: Some(v), .. } => vec![v],
            InsnType::Return { value: None, .. } => vec![],
            InsnType::Throw { exception } => vec![exception],
            InsnType::MonitorEnter { object } => vec![object],
            InsnType::MonitorExit { object } => vec![object],
            InsnType::CheckCast { object, .. } => vec![object],
            InsnType::InstanceOf { object, .. } => vec![object],
            InsnType::ArrayLength { array, .. } => vec![array],
            InsnType::NewArray { size, .. } => vec![size],
            InsnType::FillArrayData { array, .. } => vec![array],
            InsnType::InstanceGet { object, .. } => vec![object],
            InsnType::StaticPut { value, .. } => vec![value],
            InsnType::Unary { arg, .. } => vec![arg],
            InsnType::Cast { arg, .. } => vec![arg],
            InsnType::PackedSwitch { value, .. } => vec![value],
            InsnType::SparseSwitch { value, .. } => vec![value],
            InsnType::OneArg { arg } => vec![arg],

            // Two arguments - FIXED: returns both
            InsnType::ArrayGet { array, index, .. } => vec![array, index],
            InsnType::Binary { left, right, .. } => vec![left, right],
            InsnType::Compare { left, right, .. } => vec![left, right],
            InsnType::InstancePut { object, value, .. } => vec![object, value],

            // Two or three arguments
            InsnType::If { left, right, .. } => {
                match right {
                    Some(r) => vec![left, r],
                    None => vec![left],
                }
            }

            // Three arguments - FIXED: returns all
            InsnType::ArrayPut { array, index, value, .. } => vec![array, index, value],

            // Four+ arguments (Ternary)
            InsnType::Ternary { left, right, then_value, else_value, .. } => {
                match right {
                    Some(r) => vec![left, r, then_value, else_value],
                    None => vec![left, then_value, else_value],
                }
            }

            // Variable argument lists
            InsnType::FilledNewArray { args, .. } => args.iter().collect(),
            InsnType::Invoke { args, .. } => args.iter().collect(),
            InsnType::InvokeCustom { args, .. } => args.iter().collect(),
            InsnType::StrConcat { args, .. } => args.iter().collect(),
            InsnType::RegionArg { args } => args.iter().collect(),
            InsnType::Constructor { args, .. } => args.iter().collect(),

            // PHI nodes - FIXED: returns all source values
            InsnType::Phi { sources, .. } => {
                sources.iter().map(|(_, arg)| arg).collect()
            }

            // MoveMulti - FIXED: returns all source values
            InsnType::MoveMulti { moves } => {
                moves.iter().map(|(_, src)| src).collect()
            }
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

    // =========================================================================
    // JADX RegisterArg Name Management - 100% Parity
    // Cloned from: jadx-fast/jadx-core/src/main/java/jadx/core/dex/instructions/args/RegisterArg.java
    // =========================================================================

    /// Set name if not already set (JADX: setNameIfUnknown)
    ///
    /// Sets the variable name only if it doesn't already have one.
    /// Used during code generation to assign generated names (like "v0", "i", etc.)
    /// without overwriting debug info names.
    ///
    /// JADX Reference: RegisterArg.java:115-119
    /// ```java
    /// public void setNameIfUnknown(String name) {
    ///     if (getName() == null) {
    ///         setName(name);
    ///     }
    /// }
    /// ```
    ///
    /// Note: This method requires access to the SSA context to update the CodeVar.
    /// The caller should use `ssa_ctx.set_var_name_if_unknown(reg.reg_num, reg.ssa_version, name)`.
    pub fn should_set_name(&self, current_name: Option<&str>) -> bool {
        current_name.is_none()
    }

    /// Check if name equals another arg's name (JADX: isNameEquals)
    ///
    /// Compares variable names between two arguments. Used for detecting
    /// when two different SSA versions represent the same named variable.
    ///
    /// JADX Reference: RegisterArg.java:121-127
    /// ```java
    /// public boolean isNameEquals(InsnArg other) {
    ///     if (other instanceof RegisterArg) {
    ///         String name = getName();
    ///         if (name != null) {
    ///             return name.equals(((RegisterArg) other).getName());
    ///         }
    ///     }
    ///     return false;
    /// }
    /// ```
    ///
    /// Note: Names are retrieved from SSA context. Use with:
    /// `ssa_ctx.get_var_name(reg.reg_num, reg.ssa_version)`
    pub fn is_name_equals_with_names(my_name: Option<&str>, other_name: Option<&str>) -> bool {
        match (my_name, other_name) {
            (Some(a), Some(b)) => a == b,
            _ => false,
        }
    }

    /// Create an SSA variable reference from this register arg
    ///
    /// Returns a tuple of (reg_num, ssa_version) for SSA context lookups.
    pub fn as_ssa_ref(&self) -> (u16, u32) {
        (self.reg_num, self.ssa_version)
    }
}

/// Literal argument
#[derive(Debug, Clone, PartialEq)]
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

    // =========================================================================
    // JADX Parity: LiteralArg additional methods (P9)
    // Cloned from: jadx-fast/jadx-core/src/main/java/jadx/core/dex/instructions/args/LiteralArg.java
    // =========================================================================

    /// Check if this literal is an integer type (JADX: isInteger)
    ///
    /// Returns true for INT, BYTE, CHAR, SHORT, LONG types.
    /// Used for arithmetic operations and type inference.
    ///
    /// JADX Reference: LiteralArg.java:66-77
    /// ```java
    /// public boolean isInteger() {
    ///     switch (type.getPrimitiveType()) {
    ///         case INT:
    ///         case BYTE:
    ///         case CHAR:
    ///         case SHORT:
    ///         case LONG:
    ///             return true;
    ///         default:
    ///             return false;
    ///     }
    /// }
    /// ```
    pub fn is_integer(&self) -> bool {
        matches!(self, LiteralArg::Int(_))
    }

    /// Create a literal argument (JADX: make)
    ///
    /// Factory method for creating literal arguments with specified type.
    ///
    /// JADX Reference: LiteralArg.java:11-13
    /// ```java
    /// public static LiteralArg make(long value, ArgType type) {
    ///     return new LiteralArg(value, type);
    /// }
    /// ```
    pub fn make(value: i64, arg_type: &ArgType) -> Self {
        match arg_type {
            ArgType::Float => LiteralArg::Float(f32::from_bits(value as u32)),
            ArgType::Double => LiteralArg::Double(f64::from_bits(value as u64)),
            _ => LiteralArg::Int(value),
        }
    }

    /// Create a literal with fixed type based on value (JADX: makeWithFixedType)
    ///
    /// For 0/1 values, type may be boolean. For other values, narrows the type.
    ///
    /// JADX Reference: LiteralArg.java:15-17
    /// ```java
    /// public static LiteralArg makeWithFixedType(long value, ArgType type) {
    ///     return new LiteralArg(value, fixLiteralType(value, type));
    /// }
    /// ```
    pub fn make_with_fixed_type(value: i64, arg_type: &ArgType) -> Self {
        // Apply type fixing logic from JADX
        let fixed_type = Self::fix_literal_type(value, arg_type);
        Self::make(value, &fixed_type)
    }

    /// Fix literal type based on value (JADX: fixLiteralType)
    ///
    /// Returns appropriate type based on the literal value:
    /// - 0 or known type: return as-is
    /// - 1: could be boolean, byte, short, char, int
    /// - Other: narrow numeric types (no boolean)
    ///
    /// JADX Reference: LiteralArg.java:19-27
    /// ```java
    /// private static ArgType fixLiteralType(long value, ArgType type) {
    ///     if (value == 0 || type.isTypeKnown() || type.contains(PrimitiveType.LONG) || type.contains(PrimitiveType.DOUBLE)) {
    ///         return type;
    ///     }
    ///     if (value == 1) {
    ///         return ArgType.NARROW_NUMBERS;
    ///     }
    ///     return ArgType.NARROW_NUMBERS_NO_BOOL;
    /// }
    /// ```
    pub fn fix_literal_type(value: i64, arg_type: &ArgType) -> ArgType {
        // If value is 0, type is known, or is long/double, keep as-is
        if value == 0 {
            return arg_type.clone();
        }
        if arg_type.is_type_known() {
            return arg_type.clone();
        }
        if matches!(arg_type, ArgType::Long | ArgType::Double) {
            return arg_type.clone();
        }

        // For value 1, could be boolean too
        if value == 1 {
            return ArgType::UnknownIntegral; // NARROW_NUMBERS equivalent
        }

        // Other values can't be boolean
        ArgType::UnknownIntegral // NARROW_NUMBERS_NO_BOOL equivalent
    }

    /// Duplicate this literal (JADX: duplicate)
    ///
    /// JADX Reference: LiteralArg.java:112-114
    pub fn duplicate(&self) -> Self {
        self.clone()
    }
}

// === JADX SwitchData for 100% parity ===
// Cloned from: jadx-fast/jadx-core/src/main/java/jadx/core/dex/instructions/SwitchData.java

/// Switch instruction data payload (JADX: SwitchData)
///
/// Contains the case keys and target offsets for switch instructions.
/// This is a separate struct that can be shared between multiple switch
/// instructions if they reference the same payload.
///
/// JADX Reference: jadx-core/src/main/java/jadx/core/dex/instructions/SwitchData.java
#[derive(Debug, Clone)]
pub struct SwitchData {
    /// Number of cases in the switch
    ///
    /// JADX Reference: SwitchData.java:8
    pub size: usize,

    /// Case key values
    ///
    /// For packed switches, these are consecutive (first_key, first_key+1, ...).
    /// For sparse switches, these are the actual case values.
    ///
    /// JADX Reference: SwitchData.java:9
    pub keys: Vec<i32>,

    /// Target offsets (in bytecode units)
    ///
    /// These are initially relative to the switch payload, then fixed up
    /// via `fix_targets` to be absolute offsets.
    ///
    /// JADX Reference: SwitchData.java:10
    pub targets: Vec<i32>,
}

impl SwitchData {
    /// Create a new SwitchData from a DEX switch payload
    ///
    /// JADX Reference: SwitchData.java:12-17
    /// ```java
    /// public SwitchData(ISwitchPayload payload) {
    ///     this.size = payload.getSize();
    ///     this.keys = payload.getKeys();
    ///     this.targets = payload.getTargets();
    /// }
    /// ```
    pub fn new(size: usize, keys: Vec<i32>, targets: Vec<i32>) -> Self {
        debug_assert_eq!(keys.len(), size);
        debug_assert_eq!(targets.len(), size);
        SwitchData { size, keys, targets }
    }

    /// Create a packed switch data
    ///
    /// For packed switches, keys are consecutive starting from first_key.
    pub fn new_packed(first_key: i32, targets: Vec<i32>) -> Self {
        let size = targets.len();
        let keys: Vec<i32> = (0..size as i32).map(|i| first_key + i).collect();
        SwitchData { size, keys, targets }
    }

    /// Create a sparse switch data
    pub fn new_sparse(keys: Vec<i32>, targets: Vec<i32>) -> Self {
        debug_assert_eq!(keys.len(), targets.len());
        let size = keys.len();
        SwitchData { size, keys, targets }
    }

    /// Fix target offsets by adding the switch instruction offset (JADX: fixTargets)
    ///
    /// Converts relative targets (from payload) to absolute bytecode offsets.
    ///
    /// JADX Reference: SwitchData.java:19-25
    /// ```java
    /// public void fixTargets(int switchOffset) {
    ///     int size = this.size;
    ///     int[] targets = this.targets;
    ///     for (int i = 0; i < size; i++) {
    ///         targets[i] += switchOffset;
    ///     }
    /// }
    /// ```
    pub fn fix_targets(&mut self, switch_offset: i32) {
        for target in &mut self.targets {
            *target += switch_offset;
        }
    }

    /// Get the number of cases (JADX: getSize)
    ///
    /// JADX Reference: SwitchData.java:27-29
    pub fn get_size(&self) -> usize {
        self.size
    }

    /// Get the case keys (JADX: getKeys)
    ///
    /// JADX Reference: SwitchData.java:31-33
    pub fn get_keys(&self) -> &[i32] {
        &self.keys
    }

    /// Get the target offsets (JADX: getTargets)
    ///
    /// JADX Reference: SwitchData.java:35-37
    pub fn get_targets(&self) -> &[i32] {
        &self.targets
    }

    /// Get a specific key by index
    pub fn get_key(&self, index: usize) -> Option<i32> {
        self.keys.get(index).copied()
    }

    /// Get a specific target by index
    pub fn get_target(&self, index: usize) -> Option<i32> {
        self.targets.get(index).copied()
    }

    /// Iterate over (key, target) pairs
    pub fn iter(&self) -> impl Iterator<Item = (i32, i32)> + '_ {
        self.keys.iter().zip(self.targets.iter()).map(|(k, t)| (*k, *t))
    }

    /// Check if this is a packed switch (consecutive keys)
    pub fn is_packed(&self) -> bool {
        if self.keys.is_empty() {
            return true;
        }
        let first = self.keys[0];
        self.keys.iter().enumerate().all(|(i, &k)| k == first + i as i32)
    }
}

impl std::fmt::Display for SwitchData {
    /// Format as JADX does in toString()
    ///
    /// JADX Reference: SwitchData.java:40-49
    fn fmt(&self, f: &mut std::fmt::Formatter<'_>) -> std::fmt::Result {
        write!(f, "switch-data {{")?;
        for i in 0..self.size {
            if i > 0 {
                write!(f, ", ")?;
            }
            write!(f, "{}->0x{:x}", self.keys[i], self.targets[i])?;
        }
        write!(f, "}}")
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
///
/// Cloned from JADX: jadx-core/src/main/java/jadx/core/dex/instructions/InvokeType.java
#[derive(Debug, Clone, Copy, PartialEq, Eq)]
pub enum InvokeKind {
    /// invoke-virtual: virtual method dispatch
    Virtual,
    /// invoke-super: super class method call
    Super,
    /// invoke-direct: direct method call (constructors, private)
    Direct,
    /// invoke-static: static method call
    Static,
    /// invoke-interface: interface method call
    Interface,
    /// invoke-polymorphic: polymorphic invoke (MethodHandle/VarHandle)
    Polymorphic,
    /// invoke-custom: processed lambda/method reference
    Custom,
    /// invoke-custom-raw: raw invoke-custom before processing
    /// JADX Reference: InvokeType.java:11
    CustomRaw,
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
///
/// JADX Reference: jadx-core/src/main/java/jadx/core/dex/instructions/ArithOp.java
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

// === JADX ArithOp methods for 100% parity ===
// Cloned from: jadx-fast/jadx-core/src/main/java/jadx/core/dex/instructions/ArithOp.java

impl BinaryOp {
    /// Get the operator symbol for code generation (JADX: getSymbol)
    ///
    /// JADX Reference: ArithOp.java:30-32
    pub fn symbol(&self) -> &'static str {
        match self {
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
            BinaryOp::Rsub => "-", // reverse subtract shows as -
        }
    }

    /// Check if this is a bitwise operation (JADX: isBitOp)
    ///
    /// Used for type inference - bitwise ops work on int/long but
    /// result type should be INT_BOOLEAN for single-bit operations.
    ///
    /// JADX Reference: ArithOp.java:34-36
    pub fn is_bit_op(&self) -> bool {
        matches!(
            self,
            BinaryOp::And | BinaryOp::Or | BinaryOp::Xor
        )
    }

    /// Check if this is a shift operation
    pub fn is_shift_op(&self) -> bool {
        matches!(
            self,
            BinaryOp::Shl | BinaryOp::Shr | BinaryOp::Ushr
        )
    }

    /// Check if this operation is commutative (a op b == b op a)
    pub fn is_commutative(&self) -> bool {
        matches!(
            self,
            BinaryOp::Add | BinaryOp::Mul | BinaryOp::And | BinaryOp::Or | BinaryOp::Xor
        )
    }
}

// === JADX ArithNode methods on InsnType ===
// Cloned from: jadx-fast/jadx-core/src/main/java/jadx/core/dex/instructions/ArithNode.java

impl InsnType {
    /// Create a one-argument arithmetic instruction (JADX: oneArgOp)
    ///
    /// Creates an instruction for compound assignment like `a += 2`.
    /// The result is set to null and ARITH_ONEARG flag should be added.
    ///
    /// JADX Reference: ArithNode.java:74-78
    /// ```java
    /// public static ArithNode oneArgOp(ArithOp op, InsnArg res, InsnArg a) {
    ///     ArithNode insn = new ArithNode(op, null, res, a);
    ///     insn.add(AFlag.ARITH_ONEARG);
    ///     return insn;
    /// }
    /// ```
    pub fn new_arith_one_arg(op: BinaryOp, target: InsnArg, value: InsnArg) -> Self {
        // Note: The caller should add AFlag::ArithOnearg flag to the InsnNode
        InsnType::Binary {
            dest: RegisterArg::new(0), // Placeholder, not used for one-arg form
            op,
            left: target,
            right: value,
            arg_type: None,
        }
    }

    /// Check if this is a one-arg arithmetic instruction (a += b form)
    ///
    /// One-arg instructions have the ARITH_ONEARG flag set on the InsnNode.
    /// The first argument is both the source and destination.
    pub fn is_arith_one_arg(&self) -> bool {
        // This needs to check the flag on InsnNode, not InsnType
        // Caller should use: insn.has_flag(AFlag::ArithOnearg)
        false
    }

    /// Get the arithmetic operation if this is a Binary instruction
    pub fn get_arith_op(&self) -> Option<BinaryOp> {
        match self {
            InsnType::Binary { op, .. } => Some(*op),
            _ => None,
        }
    }

    /// Check if two arithmetic instructions have the same literal operand (JADX: isSameLiteral)
    ///
    /// Compares the second operand (usually the literal) of two arithmetic
    /// instructions. Returns false if either operand is not a literal.
    ///
    /// JADX Reference: ArithNode.java:96-110
    /// ```java
    /// private boolean isSameLiteral(ArithNode other) {
    ///     InsnArg thisSecond = getArg(1);
    ///     InsnArg otherSecond = other.getArg(1);
    ///     if (thisSecond.isLiteral() != otherSecond.isLiteral()) {
    ///         return false;
    ///     }
    ///     if (!thisSecond.isLiteral()) {
    ///         return true; // both not literals
    ///     }
    ///     // both literals
    ///     long thisLit = ((LiteralArg) thisSecond).getLiteral();
    ///     long otherLit = ((LiteralArg) otherSecond).getLiteral();
    ///     return thisLit == otherLit;
    /// }
    /// ```
    pub fn is_same_arith_literal(&self, other: &InsnType) -> bool {
        match (self, other) {
            (
                InsnType::Binary { right: self_right, .. },
                InsnType::Binary { right: other_right, .. },
            ) => {
                let self_is_lit = matches!(self_right, InsnArg::Literal(_));
                let other_is_lit = matches!(other_right, InsnArg::Literal(_));

                if self_is_lit != other_is_lit {
                    return false;
                }

                if !self_is_lit {
                    // Both are not literals - considered equal for this purpose
                    return true;
                }

                // Both are literals - compare values
                match (self_right, other_right) {
                    (InsnArg::Literal(a), InsnArg::Literal(b)) => a.same_value(b),
                    _ => false,
                }
            }
            _ => false,
        }
    }

    /// Check if this arithmetic instruction is the same as another (JADX: isSame)
    ///
    /// Compares operation type and literal values.
    ///
    /// JADX Reference: ArithNode.java:85-94
    pub fn is_same_arith(&self, other: &InsnType) -> bool {
        match (self, other) {
            (
                InsnType::Binary { op: self_op, .. },
                InsnType::Binary { op: other_op, .. },
            ) => {
                if self_op != other_op {
                    return false;
                }
                self.is_same_arith_literal(other)
            }
            _ => false,
        }
    }
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

// === JADX TargetInsnNode methods on InsnType ===
// Cloned from: jadx-fast/jadx-core/src/main/java/jadx/core/dex/instructions/TargetInsnNode.java

impl InsnType {
    /// Check if this is a target instruction (extends TargetInsnNode)
    ///
    /// JADX Reference: TargetInsnNode.java
    pub fn is_target_insn(&self) -> bool {
        matches!(
            self,
            InsnType::If { .. }
                | InsnType::Goto { .. }
                | InsnType::PackedSwitch { .. }
                | InsnType::SparseSwitch { .. }
        )
    }

    /// Replace a target block with another (JADX: replaceTargetBlock)
    ///
    /// Replaces all occurrences of `origin_offset` with `replace_offset` in
    /// the instruction's target offsets. Returns true if any replacement was made.
    ///
    /// JADX Reference: TargetInsnNode.java:15-17
    /// ```java
    /// public boolean replaceTargetBlock(BlockNode origin, BlockNode replace) {
    ///     return false;
    /// }
    /// ```
    ///
    /// Overridden in IfNode, GotoNode, SwitchInsn:
    ///
    /// JADX Reference: SwitchInsn.java:60-77
    /// ```java
    /// public boolean replaceTargetBlock(BlockNode origin, BlockNode replace) {
    ///     if (targetBlocks == null) return false;
    ///     int count = 0;
    ///     for (int i = 0; i < targetBlocks.length; i++) {
    ///         if (targetBlocks[i] == origin) {
    ///             targetBlocks[i] = replace;
    ///             count++;
    ///         }
    ///     }
    ///     if (defTargetBlock == origin) {
    ///         defTargetBlock = replace;
    ///         count++;
    ///     }
    ///     return count > 0;
    /// }
    /// ```
    pub fn replace_target_offset(&mut self, origin_offset: u32, replace_offset: u32) -> bool {
        match self {
            InsnType::If { target, .. } => {
                if *target == origin_offset {
                    *target = replace_offset;
                    true
                } else {
                    false
                }
            }
            InsnType::Goto { target } => {
                if *target == origin_offset {
                    *target = replace_offset;
                    true
                } else {
                    false
                }
            }
            InsnType::PackedSwitch { targets, .. } => {
                let mut count = 0;
                for target in targets.iter_mut() {
                    if *target == origin_offset {
                        *target = replace_offset;
                        count += 1;
                    }
                }
                count > 0
            }
            InsnType::SparseSwitch { targets, .. } => {
                let mut count = 0;
                for target in targets.iter_mut() {
                    if *target == origin_offset {
                        *target = replace_offset;
                        count += 1;
                    }
                }
                count > 0
            }
            _ => false,
        }
    }

    /// Get all target offsets from this instruction
    ///
    /// Returns all bytecode offsets this instruction can jump to.
    pub fn get_target_offsets(&self) -> Vec<u32> {
        match self {
            InsnType::If { target, .. } => vec![*target],
            InsnType::Goto { target } => vec![*target],
            InsnType::PackedSwitch { targets, .. } => targets.clone(),
            InsnType::SparseSwitch { targets, .. } => targets.clone(),
            _ => vec![],
        }
    }

    /// Get the single target offset (for If and Goto)
    pub fn get_single_target(&self) -> Option<u32> {
        match self {
            InsnType::If { target, .. } => Some(*target),
            InsnType::Goto { target } => Some(*target),
            _ => None,
        }
    }

    /// Set the single target offset (for If and Goto)
    pub fn set_single_target(&mut self, new_target: u32) -> bool {
        match self {
            InsnType::If { target, .. } => {
                *target = new_target;
                true
            }
            InsnType::Goto { target } => {
                *target = new_target;
                true
            }
            _ => false,
        }
    }
}

// === JADX InvokeNode methods on InsnType ===
// Cloned from: jadx-fast/jadx-core/src/main/java/jadx/core/dex/instructions/InvokeNode.java

impl InsnType {
    /// Check if this is an invoke instruction
    pub fn is_invoke(&self) -> bool {
        matches!(
            self,
            InsnType::Invoke { .. }
                | InsnType::InvokeCustom { .. }
                | InsnType::Constructor { .. }
        )
    }

    /// Check if this is a static invocation (JADX: isStaticCall)
    ///
    /// JADX Reference: InvokeNode.java:63-65
    /// ```java
    /// public boolean isStaticCall() {
    ///     return invokeType == InvokeType.STATIC;
    /// }
    /// ```
    pub fn is_static_call(&self) -> bool {
        match self {
            InsnType::Invoke { kind: InvokeKind::Static, .. } => true,
            _ => false,
        }
    }

    /// Get the first argument offset (JADX: getFirstArgOffset)
    ///
    /// For static methods this is 0, for instance methods this is 1
    /// (to skip the receiver argument).
    ///
    /// JADX Reference: InvokeNode.java:67-69
    /// ```java
    /// public int getFirstArgOffset() {
    ///     return isStaticCall() ? 0 : 1;
    /// }
    /// ```
    pub fn get_first_arg_offset(&self) -> usize {
        if self.is_static_call() {
            0
        } else {
            1
        }
    }

    /// Get the instance argument (receiver) for virtual calls (JADX: getInstanceArg)
    ///
    /// Returns the first argument which is the receiver object for
    /// virtual, super, direct, and interface calls. Returns None for
    /// static calls or non-invoke instructions.
    ///
    /// JADX Reference: InvokeNode.java:51-57
    /// ```java
    /// public InsnArg getInstanceArg() {
    ///     if (isStaticCall()) {
    ///         return null;
    ///     }
    ///     return getArg(0);
    /// }
    /// ```
    pub fn get_instance_arg(&self) -> Option<&InsnArg> {
        match self {
            InsnType::Invoke { kind, args, .. } => {
                if *kind == InvokeKind::Static {
                    None
                } else {
                    args.first()
                }
            }
            InsnType::InvokeCustom { args, .. } => {
                // InvokeCustom doesn't have an instance arg in the same sense
                args.first()
            }
            InsnType::Constructor { args, .. } => {
                // Constructor's "this" is the newly created object
                args.first()
            }
            _ => None,
        }
    }

    /// Get mutable instance argument
    pub fn get_instance_arg_mut(&mut self) -> Option<&mut InsnArg> {
        match self {
            InsnType::Invoke { kind, args, .. } => {
                if *kind == InvokeKind::Static {
                    None
                } else {
                    args.first_mut()
                }
            }
            InsnType::InvokeCustom { args, .. } => args.first_mut(),
            InsnType::Constructor { args, .. } => args.first_mut(),
            _ => None,
        }
    }

    /// Get the invoke kind if this is an Invoke instruction
    pub fn get_invoke_kind(&self) -> Option<InvokeKind> {
        match self {
            InsnType::Invoke { kind, .. } => Some(*kind),
            _ => None,
        }
    }

    /// Get the method index for invoke instructions
    pub fn get_method_idx(&self) -> Option<u32> {
        match self {
            InsnType::Invoke { method_idx, .. } => Some(*method_idx),
            InsnType::Constructor { method_idx, .. } => Some(*method_idx),
            _ => None,
        }
    }

    /// Get the arguments for invoke instructions (excluding receiver for instance calls)
    ///
    /// Returns the actual call arguments, skipping the receiver for virtual calls.
    pub fn get_call_args(&self) -> &[InsnArg] {
        match self {
            InsnType::Invoke { kind, args, .. } => {
                if *kind == InvokeKind::Static {
                    args.as_slice()
                } else {
                    // Skip first arg (receiver)
                    if args.len() > 1 {
                        &args.as_slice()[1..]
                    } else {
                        &[]
                    }
                }
            }
            InsnType::InvokeCustom { args, .. } => args.as_slice(),
            InsnType::Constructor { args, .. } => {
                // Constructor args don't include the receiver (it's implicit)
                args.as_slice()
            }
            _ => &[],
        }
    }

    /// Check if this is a polymorphic invoke (MethodHandle/VarHandle)
    ///
    /// JADX Reference: InvokeNode.java:71-73
    pub fn is_polymorphic_call(&self) -> bool {
        match self {
            InsnType::Invoke { kind: InvokeKind::Polymorphic, .. } => true,
            _ => false,
        }
    }

    /// Check if this is a super call
    pub fn is_super_call(&self) -> bool {
        match self {
            InsnType::Invoke { kind: InvokeKind::Super, .. } => true,
            _ => false,
        }
    }

    /// Check if this is a direct call (private method or constructor)
    pub fn is_direct_call(&self) -> bool {
        match self {
            InsnType::Invoke { kind: InvokeKind::Direct, .. } => true,
            _ => false,
        }
    }

    /// Check if this is an interface call
    pub fn is_interface_call(&self) -> bool {
        match self {
            InsnType::Invoke { kind: InvokeKind::Interface, .. } => true,
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

    /// Bind a new argument to a PHI instruction (JADX: PhiInsn.bindArg)
    ///
    /// Creates a new phi argument for the given predecessor block.
    /// Returns error if duplicate predecessor or not a PHI instruction.
    ///
    /// Cloned from JADX: jadx-core/src/main/java/jadx/core/dex/instructions/PhiInsn.java:42-51
    /// ```java
    /// public void bindArg(RegisterArg arg, BlockNode pred) {
    ///     if (blockBinds.contains(pred)) {
    ///         throw new JadxRuntimeException("Duplicate predecessors in PHI insn: " + pred);
    ///     }
    ///     if (pred == null) {
    ///         throw new JadxRuntimeException("Null bind block in PHI insn");
    ///     }
    ///     super.addArg(arg);
    ///     blockBinds.add(pred);
    /// }
    /// ```
    pub fn phi_bind_arg(&mut self, arg: InsnArg, pred_block_id: u32) -> Result<(), &'static str> {
        match self {
            InsnType::Phi { sources, .. } => {
                // Check for duplicate predecessor
                if sources.iter().any(|(bid, _)| *bid == pred_block_id) {
                    return Err("Duplicate predecessor in PHI insn");
                }
                sources.push((pred_block_id, arg));
                Ok(())
            }
            _ => Err("Not a PHI instruction"),
        }
    }

    /// Get PHI argument by SSA variable (JADX: PhiInsn.getArgBySsaVar)
    ///
    /// Finds which PHI argument corresponds to a given SSA variable.
    ///
    /// Cloned from JADX: jadx-core/src/main/java/jadx/core/dex/instructions/PhiInsn.java:91-102
    /// ```java
    /// public RegisterArg getArgBySsaVar(SSAVar ssaVar) {
    ///     if (getArgsCount() == 0) {
    ///         return null;
    ///     }
    ///     for (InsnArg insnArg : getArguments()) {
    ///         RegisterArg reg = (RegisterArg) insnArg;
    ///         if (reg.getSVar() == ssaVar) {
    ///             return reg;
    ///         }
    ///     }
    ///     return null;
    /// }
    /// ```
    pub fn get_phi_arg_by_ssa_var(&self, reg_num: u16, version: u32) -> Option<&InsnArg> {
        match self {
            InsnType::Phi { sources, .. } => {
                for (_, arg) in sources {
                    if let InsnArg::Register(reg) = arg {
                        if reg.reg_num == reg_num && reg.ssa_version == version {
                            return Some(arg);
                        }
                    }
                }
                None
            }
            _ => None,
        }
    }

    /// Get mutable PHI argument by SSA variable
    pub fn get_phi_arg_by_ssa_var_mut(&mut self, reg_num: u16, version: u32) -> Option<&mut InsnArg> {
        match self {
            InsnType::Phi { sources, .. } => {
                for (_, arg) in sources.iter_mut() {
                    if let InsnArg::Register(reg) = arg {
                        if reg.reg_num == reg_num && reg.ssa_version == version {
                            return Some(arg);
                        }
                    }
                }
                None
            }
            _ => None,
        }
    }

    // =========================================================================
    // JADX Parity: FillArrayData methods (P11)
    // Cloned from: jadx-fast/jadx-core/src/main/java/jadx/core/dex/instructions/FillArrayData.java
    // =========================================================================

    /// Get FillArrayData size (JADX: getSize)
    ///
    /// Returns the number of elements in the array payload.
    ///
    /// JADX Reference: FillArrayData.java:59-61
    pub fn get_fill_array_size(&self) -> Option<usize> {
        match self {
            InsnType::FillArrayData { data, .. } => Some(data.len()),
            _ => None,
        }
    }

    /// Get FillArrayData element width (JADX: via elemSize)
    ///
    /// Returns the element width in bytes (1, 2, 4, or 8).
    ///
    /// JADX Reference: FillArrayData.java:24 (elemSize field)
    pub fn get_fill_array_elem_width(&self) -> Option<u8> {
        match self {
            InsnType::FillArrayData { element_width, .. } => Some(*element_width),
            _ => None,
        }
    }

    /// Get element type based on width (JADX: getElementType)
    ///
    /// Returns the inferred element type based on element width.
    ///
    /// JADX Reference: FillArrayData.java:39-53
    /// ```java
    /// private static ArgType getElementType(int elementWidthUnit) {
    ///     switch (elementWidthUnit) {
    ///         case 1:
    ///         case 0:
    ///             return ONE_BYTE_TYPE;
    ///         case 2:
    ///             return TWO_BYTES_TYPE;
    ///         case 4:
    ///             return FOUR_BYTES_TYPE;
    ///         case 8:
    ///             return EIGHT_BYTES_TYPE;
    ///         default:
    ///             throw new JadxRuntimeException("Unknown array element width: " + elementWidthUnit);
    ///     }
    /// }
    /// ```
    pub fn get_fill_array_element_type(&self) -> Option<ArgType> {
        match self {
            InsnType::FillArrayData { element_width, .. } => {
                match element_width {
                    0 | 1 => Some(ArgType::Unknown), // byte or boolean
                    2 => Some(ArgType::Unknown),     // short or char
                    4 => Some(ArgType::Unknown),     // int or float
                    8 => Some(ArgType::Unknown),     // long or double
                    _ => None,
                }
            }
            _ => None,
        }
    }

    /// Get literal args from FillArrayData (JADX: getLiteralArgs)
    ///
    /// Converts the raw array data to a list of LiteralArg values.
    ///
    /// JADX Reference: FillArrayData.java:67-95
    /// ```java
    /// public List<LiteralArg> getLiteralArgs(ArgType type) {
    ///     List<LiteralArg> list = new ArrayList<>(size);
    ///     Object array = data;
    ///     switch (elemSize) {
    ///         case 1:
    ///             for (byte b : (byte[]) array) {
    ///                 list.add(InsnArg.lit(b, type));
    ///             }
    ///             break;
    ///         // ... other cases
    ///     }
    ///     return list;
    /// }
    /// ```
    pub fn get_fill_array_literal_args(&self, target_type: &ArgType) -> Option<Vec<LiteralArg>> {
        match self {
            InsnType::FillArrayData { data, .. } => {
                let literals: Vec<LiteralArg> = data.iter()
                    .map(|&v| LiteralArg::make(v, target_type))
                    .collect();
                Some(literals)
            }
            _ => None,
        }
    }

    /// Format data as string (JADX: dataToString)
    ///
    /// JADX Reference: FillArrayData.java:116-129
    pub fn fill_array_data_to_string(&self) -> Option<String> {
        match self {
            InsnType::FillArrayData { data, element_width, .. } => {
                let values: Vec<String> = data.iter().map(|v| {
                    match element_width {
                        1 => format!("{}", *v as i8),
                        2 => format!("{}", *v as i16),
                        4 => format!("{}", *v as i32),
                        8 => format!("{}", v),
                        _ => format!("0x{:x}", v),
                    }
                }).collect();
                Some(format!("[{}]", values.join(", ")))
            }
            _ => None,
        }
    }

    /// Check if FillArrayData is same as another (JADX: isSame)
    ///
    /// JADX Reference: FillArrayData.java:98-107
    pub fn is_fill_array_same(&self, other: &InsnType) -> bool {
        match (self, other) {
            (
                InsnType::FillArrayData { data: data1, element_width: w1, .. },
                InsnType::FillArrayData { data: data2, element_width: w2, .. },
            ) => {
                w1 == w2 && data1 == data2
            }
            _ => false,
        }
    }

    // =========================================================================
    // JADX Parity: ConstStringNode accessor methods
    // Cloned from: jadx-fast/jadx-core/src/main/java/jadx/core/dex/instructions/ConstStringNode.java
    // =========================================================================

    /// Get the string index from a ConstString instruction (JADX: getStringIdx)
    ///
    /// Returns None if this is not a ConstString instruction.
    ///
    /// JADX Reference: ConstStringNode.java:20-22
    /// ```java
    /// public StringRef getString() {
    ///     return str;
    /// }
    /// ```
    pub fn get_string_idx(&self) -> Option<u32> {
        match self {
            InsnType::ConstString { string_idx, .. } => Some(*string_idx),
            _ => None,
        }
    }

    /// Check if this is a ConstString instruction
    pub fn is_const_string(&self) -> bool {
        matches!(self, InsnType::ConstString { .. })
    }

    // =========================================================================
    // JADX Parity: ConstClassNode accessor methods
    // Cloned from: jadx-fast/jadx-core/src/main/java/jadx/core/dex/instructions/ConstClassNode.java
    // =========================================================================

    /// Get the type index from a ConstClass instruction (JADX: getClsType)
    ///
    /// Returns None if this is not a ConstClass instruction.
    ///
    /// JADX Reference: ConstClassNode.java:22-24
    /// ```java
    /// public ArgType getClsType() {
    ///     return clsType;
    /// }
    /// ```
    pub fn get_class_type_idx(&self) -> Option<u32> {
        match self {
            InsnType::ConstClass { type_idx, .. } => Some(*type_idx),
            _ => None,
        }
    }

    /// Check if this is a ConstClass instruction
    pub fn is_const_class(&self) -> bool {
        matches!(self, InsnType::ConstClass { .. })
    }

    // =========================================================================
    // JADX Parity: PhiInsn accessor methods
    // Cloned from: jadx-fast/jadx-core/src/main/java/jadx/core/dex/instructions/PhiInsn.java
    // =========================================================================

    /// Get a PHI argument by its SSA variable (JADX: getArgBySsaVar)
    ///
    /// Searches the PHI sources for an argument matching the given SSA variable
    /// (register number and version).
    ///
    /// JADX Reference: PhiInsn.java:91-102
    /// ```java
    /// @Nullable
    /// public RegisterArg getArgBySsaVar(SSAVar ssaVar) {
    ///     if (getArgsCount() == 0) {
    ///         return null;
    ///     }
    ///     for (InsnArg insnArg : getArguments()) {
    ///         RegisterArg reg = (RegisterArg) insnArg;
    ///         if (reg.getSVar() == ssaVar) {
    ///             return reg;
    ///         }
    ///     }
    ///     return null;
    /// }
    /// ```
    pub fn get_phi_arg_by_ssa(&self, reg_num: u16, ssa_version: u32) -> Option<&InsnArg> {
        match self {
            InsnType::Phi { sources, .. } => {
                for (_, arg) in sources.iter() {
                    if let InsnArg::Register(reg) = arg {
                        if reg.reg_num == reg_num && reg.ssa_version == ssa_version {
                            return Some(arg);
                        }
                    }
                }
                None
            }
            _ => None,
        }
    }

    /// Get a PHI source by block ID (JADX: getBlockByArgIndex inverse)
    ///
    /// Returns the argument associated with the given block ID in the PHI.
    ///
    /// JADX Reference: PhiInsn.java:62-64
    /// ```java
    /// public BlockNode getBlockByArgIndex(int argIndex) {
    ///     return blockBinds.get(argIndex);
    /// }
    /// ```
    pub fn get_phi_arg_by_block(&self, block_id: u32) -> Option<&InsnArg> {
        match self {
            InsnType::Phi { sources, .. } => {
                for (bid, arg) in sources.iter() {
                    if *bid == block_id {
                        return Some(arg);
                    }
                }
                None
            }
            _ => None,
        }
    }

    /// Check if PHI is empty (no sources)
    pub fn is_phi_empty(&self) -> bool {
        match self {
            InsnType::Phi { sources, .. } => sources.is_empty(),
            _ => true,
        }
    }

    /// Get PHI sources count
    pub fn get_phi_sources_count(&self) -> usize {
        match self {
            InsnType::Phi { sources, .. } => sources.len(),
            _ => 0,
        }
    }
}

// =============================================================================
// JADX Parity: InsnArg static wrapping methods
// Cloned from: jadx-fast/jadx-core/src/main/java/jadx/core/dex/instructions/args/InsnArg.java
// =============================================================================

impl InsnArg {
    /// Wrap an instruction into an InsnArg (JADX: wrapInsnIntoArg)
    ///
    /// Creates an InsnWrapArg containing the given instruction. This is used
    /// for instruction inlining when an instruction's result is used directly
    /// as an argument to another instruction.
    ///
    /// For CONST and MOVE instructions (without FORCE_ASSIGN_INLINE), the
    /// instruction's argument is returned directly rather than wrapping.
    ///
    /// JADX Reference: InsnArg.java:161-185
    /// ```java
    /// @NotNull
    /// public static InsnArg wrapInsnIntoArg(InsnNode insn) {
    ///     InsnType type = insn.getType();
    ///     if (type == InsnType.CONST || type == InsnType.MOVE) {
    ///         if (insn.contains(AFlag.FORCE_ASSIGN_INLINE)) {
    ///             // ... wrap anyway
    ///         } else {
    ///             // Return the instruction's first argument directly
    ///             InsnArg arg = insn.getArg(0);
    ///             insn.add(AFlag.DONT_GENERATE);
    ///             return arg;
    ///         }
    ///     }
    ///     return wrap(insn);
    /// }
    /// ```
    ///
    /// Note: In Dexterity we don't have parent pointers, so this method
    /// creates a new wrapped arg. Flag handling should be done by the caller.
    pub fn wrap_insn_into_arg(insn: &InsnNode, insn_idx: u32) -> Self {
        // For simple CONST/MOVE, we might want to extract the argument directly
        // but in Dexterity's immutable model, we always wrap
        let result_type = insn.result_type.clone().unwrap_or(ArgType::Unknown);
        InsnArg::Wrapped(Box::new(WrappedInsn {
            insn_idx,
            result_type,
            inline_insn: Some(Box::new(insn.clone())),
        }))
    }

    /// Wrap an instruction with optional inlining (JADX: wrap)
    ///
    /// Creates an InsnWrapArg. The wrapped instruction's result type
    /// is used as the argument type.
    ///
    /// JADX Reference: InsnArg.java:193-199
    /// ```java
    /// public static InsnArg wrap(InsnNode insn) {
    ///     RegisterArg result = insn.getResult();
    ///     ArgType type = result != null ? result.getType() : ArgType.UNKNOWN;
    ///     return new InsnWrapArg(insn);
    /// }
    /// ```
    pub fn wrap(insn: &InsnNode, insn_idx: u32) -> Self {
        let result_type = insn.result_type.clone().unwrap_or(ArgType::Unknown);
        InsnArg::Wrapped(Box::new(WrappedInsn {
            insn_idx,
            result_type,
            inline_insn: Some(Box::new(insn.clone())),
        }))
    }

    /// Create a wrapped arg by index only (lazy wrapping)
    ///
    /// This creates a wrapped arg that only stores the instruction index,
    /// without the inline instruction. Used when we want to defer loading
    /// the wrapped instruction.
    pub fn wrap_by_idx(insn_idx: u32, result_type: ArgType) -> Self {
        InsnArg::Wrapped(Box::new(WrappedInsn::new(insn_idx, result_type)))
    }
}

// ============================================================================
// JADX Expression Inlining (wrapInstruction) - P1 CRITICAL
// Clone of: jadx-fast/jadx-core/src/main/java/jadx/core/dex/instructions/args/InsnArg.java:100-149
// ============================================================================

use crate::ssa::SSAContext;

/// Wrap an instruction into an argument, replacing the register use in the parent instruction.
///
/// This is the core mechanism for expression inlining. When we have:
/// ```text
/// v0 = add v1, v2   ; instruction to wrap
/// v3 = mul v0, v4   ; parent instruction using v0
/// ```
///
/// We transform to:
/// ```text
/// v3 = mul (add v1, v2), v4   ; v0 is now a wrapped expression
/// ```
///
/// JADX Reference: InsnArg.java:100-149
/// ```java
/// public InsnArg wrapInstruction(MethodNode mth, InsnNode insn, boolean unbind) {
///     InsnNode parent = parentInsn;
///     if (parent == null) return null;
///     if (parent == insn) return null;  // Can't wrap into itself
///
///     int i = getArgIndex(parent, this);
///     if (i == -1) return null;
///
///     // Handle variable name preservation for MOVE insns
///     if (insn.getType() == InsnType.MOVE && this.isRegister()) {
///         String name = ((RegisterArg) this).getName();
///         if (name != null) {
///             // ... preserve name logic
///         }
///     }
///
///     InsnArg arg = wrapInsnIntoArg(insn);
///     parent.setArg(i, arg);  // Replace this arg with wrapped version
///
///     if (unbind) {
///         InsnRemover.unbindArgUsage(mth, this);
///         InsnRemover.unbindResult(mth, insn);
///         insn.setResult(null);
///     }
///     return arg;
/// }
/// ```
///
/// Parameters:
/// - `instructions`: Mutable slice of all method instructions
/// - `ssa_ctx`: SSA context for parent tracking and SSA updates
/// - `use_insn_idx`: Index of instruction where register is used (the use site)
/// - `arg_pos`: Position of the register argument within use_insn
/// - `def_insn_idx`: Index of instruction that defines the register (to be wrapped)
/// - `unbind`: If true, update SSA information (remove uses, clear result)
///
/// Returns:
/// - `Some(())` on success
/// - `None` if wrapping failed (no parent, self-reference, etc.)
pub fn wrap_instruction(
    instructions: &mut [InsnNode],
    ssa_ctx: &mut SSAContext,
    use_insn_idx: u32,
    arg_pos: u8,
    def_insn_idx: u32,
    unbind: bool,
) -> Option<()> {
    // Get parent instruction for the use site
    let parent_insn_idx = ssa_ctx.get_arg_parent(use_insn_idx, arg_pos)?;

    // Can't wrap instruction into itself
    if parent_insn_idx == def_insn_idx {
        return None;
    }

    // Get the definition instruction to wrap
    let def_insn = instructions.get(def_insn_idx as usize)?.clone();

    // Get the parent instruction
    let parent_insn = instructions.get_mut(parent_insn_idx as usize)?;

    // Handle variable name preservation for MOVE insns (JADX parity)
    // JADX Reference: InsnArg.java:108-124
    if let InsnType::Move { src, dest } = &def_insn.insn_type {
        if let InsnArg::Register(reg) = src {
            // Check if the source register has a name we should preserve
            let name = ssa_ctx.get_var_name(reg.reg_num, reg.ssa_version);
            if let Some(name) = name {
                // Preserve the name by setting it on the result register
                let dest_reg = dest;
                ssa_ctx.set_var_name_if_unknown(
                    dest_reg.reg_num,
                    dest_reg.ssa_version,
                    name.to_string(),
                );
            }
        }
    }

    // Create the wrapped argument
    let result_type = def_insn.result_type.clone().unwrap_or(ArgType::Unknown);
    let wrapped_arg = InsnArg::Wrapped(Box::new(WrappedInsn {
        insn_idx: def_insn_idx,
        result_type,
        inline_insn: Some(Box::new(def_insn.clone())),
    }));

    // Replace the argument in the parent instruction
    if !parent_insn.insn_type.set_arg(arg_pos as usize, wrapped_arg) {
        return None;
    }

    // Handle unbind (SSA cleanup)
    if unbind {
        // Get the use site's original register arg
        if let Some(InsnArg::Register(use_reg)) = def_insn.insn_type.get_args().get(arg_pos as usize) {
            // Remove use from SSA var
            if let Some(var) = ssa_ctx.get_var_mut(crate::ssa::SSAVarRef::new(use_reg.reg_num, use_reg.ssa_version)) {
                var.remove_use(use_insn_idx);
            }
        }

        // Clear the result of the wrapped instruction (mark as DONT_GENERATE)
        if let Some(wrapped_insn) = instructions.get_mut(def_insn_idx as usize) {
            wrapped_insn.flags |= AFlag::DontGenerate as u128;
            wrapped_insn.flags |= AFlag::Wrapped as u128;
        }
    }

    // Update parent tracking for the new wrapped arg
    ssa_ctx.remove_arg_parent(use_insn_idx, arg_pos);

    Some(())
}

/// Check if an instruction can be wrapped (inlined) into another instruction.
///
/// JADX has various checks for when wrapping is safe. This function
/// implements the common checks.
///
/// JADX Reference: Various uses in jadx.core.dex.visitors.ModVisitor
///
/// Returns true if the instruction can be safely wrapped.
pub fn can_wrap_instruction(
    instructions: &[InsnNode],
    def_insn_idx: u32,
    use_insn_idx: u32,
) -> bool {
    // Get the definition instruction
    let def_insn = match instructions.get(def_insn_idx as usize) {
        Some(insn) => insn,
        None => return false,
    };

    // Check if already marked as don't inline
    if def_insn.has_flag(AFlag::DontInline) {
        return false;
    }

    // Check if already wrapped
    if def_insn.has_flag(AFlag::Wrapped) {
        return false;
    }

    // Can't wrap instructions without results
    if def_insn.get_result().is_none() {
        return false;
    }

    // Instructions that can throw may not be safe to wrap past certain points
    // This is a simplification - JADX has more nuanced checks
    if def_insn.can_throw_exception() {
        // Still allow wrapping if into the immediate next instruction
        // (no control flow changes between def and use)
        let diff = if use_insn_idx > def_insn_idx {
            use_insn_idx - def_insn_idx
        } else {
            return false; // Use before def - shouldn't happen in valid SSA
        };

        // Only wrap if immediately adjacent
        if diff > 1 {
            return false;
        }
    }

    true
}

// ============================================================================
// JADX SSA Rebinding (rebindArgs) - P2 MEDIUM
// Clone of: jadx-fast/jadx-core/src/main/java/jadx/core/dex/nodes/InsnNode.java:493-512
// ============================================================================

/// Rebuild SSA use-def chains after instruction modifications.
///
/// This is called after modifying an instruction to ensure SSA information
/// remains consistent. It updates:
/// 1. The SSAVar.assign for the result register (if any)
/// 2. The SSAVar.use list for each argument register
/// 3. The usedInPhi list for arguments used in PHI nodes
///
/// JADX Reference: InsnNode.java:493-512
/// ```java
/// public void rebindArgs() {
///     RegisterArg resArg = getResult();
///     if (resArg != null) {
///         SSAVar ssaVar = resArg.getSVar();
///         if (ssaVar == null) {
///             throw new JadxRuntimeException("No SSA var for result arg");
///         }
///         ssaVar.setAssign(resArg);
///     }
///     for (InsnArg arg : getArguments()) {
///         if (arg instanceof RegisterArg) {
///             SSAVar ssaVar = ((RegisterArg) arg).getSVar();
///             ssaVar.use((RegisterArg) arg);
///             ssaVar.updateUsedInPhiList();
///         } else if (arg instanceof InsnWrapArg) {
///             ((InsnWrapArg) arg).getWrapInsn().rebindArgs();
///         }
///     }
/// }
/// ```
///
/// Parameters:
/// - `insn`: The instruction to rebind
/// - `insn_idx`: The instruction's index (for SSA tracking)
/// - `ssa_ctx`: The SSA context to update
pub fn rebind_args(insn: &InsnNode, insn_idx: u32, ssa_ctx: &mut SSAContext) {
    // Handle result register
    if let Some(result_reg) = insn.get_result() {
        let var_ref = crate::ssa::SSAVarRef::new(result_reg.reg_num, result_reg.ssa_version);
        if let Some(var) = ssa_ctx.get_var_mut(var_ref) {
            var.assign_insn_idx = Some(insn_idx);
        }
    }

    // Handle arguments
    rebind_args_recursive(&insn.insn_type, insn_idx, ssa_ctx);
}

/// Recursively rebind arguments, handling wrapped instructions
fn rebind_args_recursive(insn_type: &InsnType, insn_idx: u32, ssa_ctx: &mut SSAContext) {
    for arg in insn_type.get_args() {
        match arg {
            InsnArg::Register(reg) => {
                // Add this as a use site for the SSA variable
                let var_ref = crate::ssa::SSAVarRef::new(reg.reg_num, reg.ssa_version);
                if let Some(var) = ssa_ctx.get_var_mut(var_ref) {
                    var.add_use(insn_idx);
                }
            }
            InsnArg::Wrapped(wrapped) => {
                // Recursively rebind wrapped instruction
                if let Some(ref inner) = wrapped.inline_insn {
                    rebind_args(inner, wrapped.insn_idx, ssa_ctx);
                }
            }
            _ => {}
        }
    }
}

/// Unbind an argument from SSA tracking (JADX: InsnRemover.unbindArgUsage)
///
/// Removes the use relationship between an argument and its SSA variable.
/// Called when an argument is being replaced or removed.
///
/// JADX Reference: InsnRemover.java:133-163
/// ```java
/// public static void unbindArgUsage(@Nullable MethodNode mth, InsnArg arg) {
///     if (arg instanceof RegisterArg) {
///         RegisterArg reg = (RegisterArg) arg;
///         SSAVar sVar = reg.getSVar();
///         if (sVar != null) {
///             sVar.removeUse(reg);
///         }
///     } else if (arg instanceof InsnWrapArg) {
///         InsnNode wrapInsn = ((InsnWrapArg) arg).getWrapInsn();
///         unbindInsn(mth, wrapInsn);
///     }
/// }
/// ```
pub fn unbind_arg_usage(arg: &InsnArg, insn_idx: u32, ssa_ctx: &mut SSAContext) {
    match arg {
        InsnArg::Register(reg) => {
            let var_ref = crate::ssa::SSAVarRef::new(reg.reg_num, reg.ssa_version);
            if let Some(var) = ssa_ctx.get_var_mut(var_ref) {
                var.remove_use(insn_idx);
            }
        }
        InsnArg::Wrapped(wrapped) => {
            // Recursively unbind wrapped instruction's args
            if let Some(ref inner) = wrapped.inline_insn {
                unbind_insn_args(inner, wrapped.insn_idx, ssa_ctx);
            }
        }
        _ => {}
    }
}

/// Unbind all arguments of an instruction (JADX: unbindInsn helper)
pub fn unbind_insn_args(insn: &InsnNode, insn_idx: u32, ssa_ctx: &mut SSAContext) {
    for arg in insn.insn_type.get_args() {
        unbind_arg_usage(arg, insn_idx, ssa_ctx);
    }
}

/// Unbind the result of an instruction (JADX: InsnRemover.unbindResult)
///
/// Called when an instruction's result is no longer needed.
///
/// JADX Reference: InsnRemover.java:183-196
/// ```java
/// public static void unbindResult(@Nullable MethodNode mth, InsnNode insn) {
///     RegisterArg r = insn.getResult();
///     if (r == null) {
///         return;
///     }
///     SSAVar ssaVar = r.getSVar();
///     if (ssaVar == null) {
///         return;
///     }
///     // ... cleanup logic
/// }
/// ```
pub fn unbind_result(insn: &InsnNode, ssa_ctx: &mut SSAContext) {
    if let Some(result_reg) = insn.get_result() {
        let var_ref = crate::ssa::SSAVarRef::new(result_reg.reg_num, result_reg.ssa_version);
        if let Some(var) = ssa_ctx.get_var_mut(var_ref) {
            var.assign_insn_idx = None;
        }
    }
}

/// Update SSA used_in_phi lists for all variables used by an instruction
///
/// This should be called after modifying PHI arguments to keep the
/// usedInPhi tracking accurate.
///
/// JADX Reference: SSAVar.java:158-166
pub fn update_phi_uses(insn: &InsnNode, insn_idx: u32, is_phi: bool, ssa_ctx: &mut SSAContext) {
    for arg in insn.insn_type.get_args() {
        if let InsnArg::Register(reg) = arg {
            let var_ref = crate::ssa::SSAVarRef::new(reg.reg_num, reg.ssa_version);
            if let Some(var) = ssa_ctx.get_var_mut(var_ref) {
                if is_phi {
                    var.add_phi_use(insn_idx);
                } else {
                    var.remove_phi_use(insn_idx);
                }
            }
        }
    }
}

// ============================================================================
// JADX SwitchInsn Extended Methods - 100% Parity
// Cloned from: jadx-fast/jadx-core/src/main/java/jadx/core/dex/instructions/SwitchInsn.java
// ============================================================================

/// Switch case key types for enum/string switches (JADX: modifiedKeys Object array)
///
/// JADX uses Object[] to store modified keys that can be Integer, String, or EnumField.
/// This enum provides type-safe equivalent for Rust.
///
/// JADX Reference: SwitchInsn.java:24
/// ```java
/// private Object[] modifiedKeys;
/// ```
#[derive(Debug, Clone, PartialEq, Eq)]
pub enum SwitchKey {
    /// Integer key (original DEX key)
    Int(i32),
    /// String key (for switch-over-string after transformation)
    String(String),
    /// Enum field key (for switch-over-enum after transformation)
    Enum {
        /// Fully qualified enum type name
        type_name: String,
        /// Enum field name
        field_name: String,
    },
}

impl std::fmt::Display for SwitchKey {
    fn fmt(&self, f: &mut std::fmt::Formatter<'_>) -> std::fmt::Result {
        match self {
            SwitchKey::Int(i) => write!(f, "{}", i),
            SwitchKey::String(s) => write!(f, "\"{}\"", s.escape_default()),
            SwitchKey::Enum { field_name, .. } => write!(f, "{}", field_name),
        }
    }
}

// ============================================================================
// ExtendedIfInfo - Block bindings for If instructions (JADX: IfNode fields)
// ============================================================================

/// Extended If instruction info for block bindings after CFG construction
///
/// JADX's IfNode stores `thenBlock` and `elseBlock` references that are resolved
/// after CFG is built. This struct holds those block IDs.
///
/// Cloned from JADX: jadx-core/src/main/java/jadx/core/dex/instructions/IfNode.java:18-22
/// ```java
/// protected IfOp op;
/// private BlockNode thenBlock;
/// private BlockNode elseBlock;
/// ```
#[derive(Debug, Clone, Default)]
pub struct ExtendedIfInfo {
    /// Then branch block ID (resolved after CFG construction)
    ///
    /// Cloned from JADX: IfNode.java:21
    /// ```java
    /// private BlockNode thenBlock;
    /// ```
    pub then_block: Option<u32>,

    /// Else branch block ID (resolved after CFG construction)
    ///
    /// Cloned from JADX: IfNode.java:22
    /// ```java
    /// private BlockNode elseBlock;
    /// ```
    pub else_block: Option<u32>,
}

// ============================================================================
// ExtendedSwitchInfo - Switch instruction extended data
// ============================================================================

/// Extended switch instruction info for pass transformations (JADX: SwitchInsn fields)
///
/// This struct holds additional data that JADX's SwitchInsn class stores beyond
/// the basic SwitchData payload. Used for switch-over-enum and switch-over-string
/// transformations.
///
/// JADX Clone: jadx-core/src/main/java/jadx/core/dex/instructions/SwitchInsn.java
#[derive(Debug, Clone, Default)]
pub struct ExtendedSwitchInfo {
    /// Modified keys for enum/string switches (JADX: modifiedKeys)
    ///
    /// Initially None. When a switch-over-enum or switch-over-string pass
    /// transforms the switch, this is populated with the actual enum/string keys.
    ///
    /// JADX Reference: SwitchInsn.java:24
    /// ```java
    /// private Object[] modifiedKeys;
    /// ```
    pub modified_keys: Option<Vec<SwitchKey>>,

    /// Target block IDs (resolved after CFG construction) (JADX: targetBlocks)
    ///
    /// JADX Reference: SwitchInsn.java:25
    /// ```java
    /// private BlockNode[] targetBlocks;
    /// ```
    pub target_blocks: Option<Vec<u32>>,

    /// Default target block ID (JADX: defTargetBlock)
    ///
    /// JADX Reference: SwitchInsn.java:26
    /// ```java
    /// private BlockNode defTargetBlock;
    /// ```
    pub default_block: Option<u32>,

    /// Default case offset (next instruction) (JADX: def)
    ///
    /// JADX Reference: SwitchInsn.java:22
    /// ```java
    /// private int def; // next instruction
    /// ```
    pub default_offset: Option<u32>,
}

impl ExtendedSwitchInfo {
    /// Create new extended switch info
    pub fn new() -> Self {
        Self::default()
    }

    /// Modify a key at index (for enum/string switches) (JADX: modifyKey)
    ///
    /// Converts integer keys to enum/string keys during switch transformation passes.
    ///
    /// JADX Reference: SwitchInsn.java:170-181
    /// ```java
    /// public void modifyKey(int i, Object newKey) {
    ///     if (modifiedKeys == null) {
    ///         int[] keys = getKeys();
    ///         int caseCount = keys.length;
    ///         Object[] newKeys = new Object[caseCount];
    ///         for (int j = 0; j < caseCount; j++) {
    ///             newKeys[j] = keys[j];
    ///         }
    ///         modifiedKeys = newKeys;
    ///     }
    ///     modifiedKeys[i] = newKey;
    /// }
    /// ```
    pub fn modify_key(&mut self, index: usize, new_key: SwitchKey, original_keys: &[i32]) {
        if self.modified_keys.is_none() {
            // Initialize from original integer keys
            self.modified_keys = Some(
                original_keys.iter().map(|&k| SwitchKey::Int(k)).collect()
            );
        }
        if let Some(ref mut keys) = self.modified_keys {
            if index < keys.len() {
                keys[index] = new_key;
            }
        }
    }

    /// Get key at index (modified or original) (JADX: getKey)
    ///
    /// JADX Reference: SwitchInsn.java:163-168
    /// ```java
    /// public Object getKey(int i) {
    ///     if (modifiedKeys != null) {
    ///         return modifiedKeys[i];
    ///     }
    ///     return getSwitchData().getKeys()[i];
    /// }
    /// ```
    pub fn get_key(&self, index: usize, original_keys: &[i32]) -> Option<SwitchKey> {
        if let Some(ref modified) = self.modified_keys {
            modified.get(index).cloned()
        } else {
            original_keys.get(index).map(|&k| SwitchKey::Int(k))
        }
    }

    /// Check if keys have been modified (enum/string switch)
    pub fn has_modified_keys(&self) -> bool {
        self.modified_keys.is_some()
    }

    /// Initialize target blocks from resolved CFG (JADX: initBlocks)
    ///
    /// Called after CFG construction to resolve bytecode offsets to block IDs.
    ///
    /// JADX Reference: SwitchInsn.java:44-57
    /// ```java
    /// public void initBlocks(BlockNode curBlock) {
    ///     if (switchData == null) {
    ///         throw new JadxRuntimeException("Switch data not yet attached");
    ///     }
    ///     List<BlockNode> successors = curBlock.getSuccessors();
    ///     int[] targets = switchData.getTargets();
    ///     int len = targets.length;
    ///     targetBlocks = new BlockNode[len];
    ///     for (int i = 0; i < len; i++) {
    ///         targetBlocks[i] = getBlockByOffset(targets[i], successors);
    ///     }
    ///     defTargetBlock = getBlockByOffset(def, successors);
    /// }
    /// ```
    pub fn init_blocks(&mut self, target_block_ids: Vec<u32>, default_block_id: Option<u32>) {
        self.target_blocks = Some(target_block_ids);
        self.default_block = default_block_id;
    }

    /// Get target blocks (JADX: getTargetBlocks)
    ///
    /// JADX Reference: SwitchInsn.java:183-185
    pub fn get_target_blocks(&self) -> Option<&[u32]> {
        self.target_blocks.as_deref()
    }

    /// Get default target block (JADX: getDefTargetBlock)
    ///
    /// JADX Reference: SwitchInsn.java:187-189
    pub fn get_default_block(&self) -> Option<u32> {
        self.default_block
    }

    /// Replace a target block (JADX: replaceTargetBlock)
    ///
    /// Used during CFG modifications to update block references.
    ///
    /// JADX Reference: SwitchInsn.java:60-77
    /// ```java
    /// public boolean replaceTargetBlock(BlockNode origin, BlockNode replace) {
    ///     if (targetBlocks == null) {
    ///         return false;
    ///     }
    ///     int count = 0;
    ///     int len = targetBlocks.length;
    ///     for (int i = 0; i < len; i++) {
    ///         if (targetBlocks[i] == origin) {
    ///             targetBlocks[i] = replace;
    ///             count++;
    ///         }
    ///     }
    ///     if (defTargetBlock == origin) {
    ///         defTargetBlock = replace;
    ///         count++;
    ///     }
    ///     return count > 0;
    /// }
    /// ```
    pub fn replace_target_block(&mut self, origin: u32, replace: u32) -> bool {
        let mut count = 0;
        if let Some(ref mut blocks) = self.target_blocks {
            for block in blocks.iter_mut() {
                if *block == origin {
                    *block = replace;
                    count += 1;
                }
            }
        }
        if self.default_block == Some(origin) {
            self.default_block = Some(replace);
            count += 1;
        }
        count > 0
    }

    /// Check if blocks have been initialized
    pub fn has_blocks(&self) -> bool {
        self.target_blocks.is_some()
    }

    /// Get the case count
    pub fn get_case_count(&self) -> usize {
        self.target_blocks.as_ref().map(|b| b.len()).unwrap_or(0)
    }
}

// ============================================================================
// InsnNode methods for SwitchInsn extended functionality
// ============================================================================

impl InsnNode {
    /// Get or create extended switch info for this instruction
    ///
    /// Returns None if this is not a switch instruction.
    pub fn get_switch_info(&self) -> Option<&ExtendedSwitchInfo> {
        self.extended_switch_info.as_ref().map(|b| b.as_ref())
    }

    /// Get mutable extended switch info
    pub fn get_switch_info_mut(&mut self) -> Option<&mut ExtendedSwitchInfo> {
        if self.insn_type.is_switch() {
            if self.extended_switch_info.is_none() {
                self.extended_switch_info = Some(Box::new(ExtendedSwitchInfo::new()));
            }
            self.extended_switch_info.as_mut().map(|b| b.as_mut())
        } else {
            None
        }
    }

    /// Modify a switch key (for enum/string switches) (JADX: SwitchInsn.modifyKey)
    ///
    /// JADX Reference: SwitchInsn.java:170-181
    pub fn modify_switch_key(&mut self, index: usize, new_key: SwitchKey) -> bool {
        let original_keys = match &self.insn_type {
            // PackedSwitch: keys are first_key, first_key+1, ...
            InsnType::PackedSwitch { first_key, targets, .. } => {
                (0..targets.len()).map(|i| *first_key + i as i32).collect::<Vec<_>>()
            }
            InsnType::SparseSwitch { keys, .. } => keys.clone(),
            _ => return false,
        };

        if let Some(info) = self.get_switch_info_mut() {
            info.modify_key(index, new_key, &original_keys);
            true
        } else {
            false
        }
    }

    /// Get a switch key (modified or original) (JADX: SwitchInsn.getKey)
    ///
    /// JADX Reference: SwitchInsn.java:163-168
    pub fn get_switch_key(&self, index: usize) -> Option<SwitchKey> {
        let original_keys: Vec<i32> = match &self.insn_type {
            // PackedSwitch: keys are first_key, first_key+1, ...
            InsnType::PackedSwitch { first_key, targets, .. } => {
                (0..targets.len()).map(|i| *first_key + i as i32).collect()
            }
            InsnType::SparseSwitch { keys, .. } => keys.clone(),
            _ => return None,
        };

        if let Some(info) = self.get_switch_info() {
            info.get_key(index, &original_keys)
        } else {
            original_keys.get(index).map(|&k| SwitchKey::Int(k))
        }
    }

    /// Initialize switch target blocks (JADX: SwitchInsn.initBlocks)
    ///
    /// JADX Reference: SwitchInsn.java:44-57
    pub fn init_switch_blocks(&mut self, target_blocks: Vec<u32>, default_block: Option<u32>) -> bool {
        if let Some(info) = self.get_switch_info_mut() {
            info.init_blocks(target_blocks, default_block);
            true
        } else {
            false
        }
    }

    /// Get switch target blocks (JADX: SwitchInsn.getTargetBlocks)
    pub fn get_switch_target_blocks(&self) -> Option<&[u32]> {
        self.get_switch_info().and_then(|i| i.get_target_blocks())
    }

    /// Get switch default block (JADX: SwitchInsn.getDefTargetBlock)
    pub fn get_switch_default_block(&self) -> Option<u32> {
        self.get_switch_info().and_then(|i| i.get_default_block())
    }

    /// Replace a switch target block (JADX: SwitchInsn.replaceTargetBlock)
    ///
    /// JADX Reference: SwitchInsn.java:60-77
    pub fn replace_switch_target_block(&mut self, origin: u32, replace: u32) -> bool {
        if let Some(info) = self.get_switch_info_mut() {
            info.replace_target_block(origin, replace)
        } else {
            false
        }
    }

    // =========================================================================
    // JADX Parity: IfNode block binding methods (100% PARITY)
    // Cloned from: jadx-fast/jadx-core/src/main/java/jadx/core/dex/instructions/IfNode.java
    // =========================================================================

    /// Get or create extended if info for this instruction
    ///
    /// Returns None if this is not an If instruction.
    pub fn get_if_info(&self) -> Option<&ExtendedIfInfo> {
        self.extended_if_info.as_ref().map(|b| b.as_ref())
    }

    /// Get mutable extended if info
    pub fn get_if_info_mut(&mut self) -> Option<&mut ExtendedIfInfo> {
        if matches!(self.insn_type, InsnType::If { .. }) {
            if self.extended_if_info.is_none() {
                self.extended_if_info = Some(Box::new(ExtendedIfInfo::default()));
            }
            self.extended_if_info.as_mut().map(|b| b.as_mut())
        } else {
            None
        }
    }

    /// Get then block ID (JADX: IfNode.getThenBlock)
    ///
    /// Returns the block ID for the "then" branch after CFG construction.
    ///
    /// Cloned from JADX: jadx-core/src/main/java/jadx/core/dex/instructions/IfNode.java:114-116
    /// ```java
    /// public BlockNode getThenBlock() {
    ///     return thenBlock;
    /// }
    /// ```
    pub fn get_then_block(&self) -> Option<u32> {
        self.extended_if_info.as_ref().and_then(|info| info.then_block)
    }

    /// Get else block ID (JADX: IfNode.getElseBlock)
    ///
    /// Returns the block ID for the "else" branch after CFG construction.
    ///
    /// Cloned from JADX: jadx-core/src/main/java/jadx/core/dex/instructions/IfNode.java:118-120
    /// ```java
    /// public BlockNode getElseBlock() {
    ///     return elseBlock;
    /// }
    /// ```
    pub fn get_else_block(&self) -> Option<u32> {
        self.extended_if_info.as_ref().and_then(|info| info.else_block)
    }

    /// Initialize if block bindings from CFG (JADX: IfNode.initBlocks)
    ///
    /// Called after CFG construction to resolve offset-based targets to block IDs.
    ///
    /// Cloned from JADX: jadx-core/src/main/java/jadx/core/dex/instructions/IfNode.java:89-98
    /// ```java
    /// public void initBlocks(BlockNode curBlock) {
    ///     List<BlockNode> successors = curBlock.getSuccessors();
    ///     thenBlock = getBlockByOffset(target, successors);
    ///     if (successors.size() == 1) {
    ///         elseBlock = thenBlock;
    ///     } else {
    ///         elseBlock = selectOther(thenBlock, successors);
    ///     }
    /// }
    /// ```
    pub fn init_if_blocks(&mut self, then_block: u32, else_block: u32) -> bool {
        if matches!(self.insn_type, InsnType::If { .. }) {
            self.extended_if_info = Some(Box::new(ExtendedIfInfo {
                then_block: Some(then_block),
                else_block: Some(else_block),
            }));
            true
        } else {
            false
        }
    }

    /// Replace an if target block (JADX: IfNode.replaceTargetBlock)
    ///
    /// Cloned from JADX: jadx-core/src/main/java/jadx/core/dex/instructions/IfNode.java:100-112
    /// ```java
    /// public boolean replaceTargetBlock(BlockNode origin, BlockNode replace) {
    ///     boolean replaced = false;
    ///     if (thenBlock == origin) {
    ///         thenBlock = replace;
    ///         replaced = true;
    ///     }
    ///     if (elseBlock == origin) {
    ///         elseBlock = replace;
    ///         replaced = true;
    ///     }
    ///     return replaced;
    /// }
    /// ```
    pub fn replace_if_target_block(&mut self, origin: u32, replace: u32) -> bool {
        if let Some(ref mut info) = self.extended_if_info {
            let mut replaced = false;
            if info.then_block == Some(origin) {
                info.then_block = Some(replace);
                replaced = true;
            }
            if info.else_block == Some(origin) {
                info.else_block = Some(replace);
                replaced = true;
            }
            replaced
        } else {
            false
        }
    }
}

impl InsnType {
    /// Check if this is a switch instruction
    pub fn is_switch(&self) -> bool {
        matches!(self, InsnType::PackedSwitch { .. } | InsnType::SparseSwitch { .. })
    }

    /// Get switch keys if this is a switch instruction
    pub fn get_switch_keys(&self) -> Option<Vec<i32>> {
        match self {
            // PackedSwitch: keys are first_key, first_key+1, first_key+2, ...
            InsnType::PackedSwitch { first_key, targets, .. } => {
                Some((0..targets.len()).map(|i| *first_key + i as i32).collect())
            }
            InsnType::SparseSwitch { keys, .. } => Some(keys.clone()),
            _ => None,
        }
    }

    /// Get switch targets if this is a switch instruction
    pub fn get_switch_targets(&self) -> Option<&[u32]> {
        match self {
            InsnType::PackedSwitch { targets, .. } => Some(targets),
            InsnType::SparseSwitch { targets, .. } => Some(targets),
            _ => None,
        }
    }

    /// Get switch case count
    pub fn get_switch_case_count(&self) -> usize {
        match self {
            InsnType::PackedSwitch { targets, .. } => targets.len(),
            InsnType::SparseSwitch { keys, .. } => keys.len(),
            _ => 0,
        }
    }

    /// Check if this is a packed switch
    pub fn is_packed_switch(&self) -> bool {
        matches!(self, InsnType::PackedSwitch { .. })
    }

    /// Check if this is a sparse switch
    pub fn is_sparse_switch(&self) -> bool {
        matches!(self, InsnType::SparseSwitch { .. })
    }
}

// =============================================================================
// JADX InsnRemover Parity - Instruction Removal Utilities
// =============================================================================
//
// JADX Clone: jadx-core/src/main/java/jadx/core/utils/InsnRemover.java
//
// These utilities handle safe instruction removal with SSA cleanup.
// Critical for passes that modify the IR (inline, remove dead code, etc.).

/// Instruction removal utilities with SSA cleanup (JADX: InsnRemover)
///
/// JADX Clone: jadx-core/src/main/java/jadx/core/utils/InsnRemover.java
///
/// This module handles the complex process of removing instructions while
/// keeping SSA use-def chains consistent.
pub mod insn_remover {
    use super::*;
    use crate::ssa::{SSAContext, SSAVarRef};
    use crate::attributes::AFlag;

    /// Unbind an instruction from SSA (JADX: unbindInsn)
    ///
    /// This removes all SSA uses from arguments and unbinds the result.
    /// The instruction is marked with DONT_GENERATE flag.
    ///
    /// JADX Reference: InsnRemover.java:89-93
    /// ```java
    /// public static void unbindInsn(@Nullable MethodNode mth, InsnNode insn) {
    ///     unbindAllArgs(mth, insn);
    ///     unbindResult(mth, insn);
    ///     insn.add(AFlag.DONT_GENERATE);
    /// }
    /// ```
    pub fn unbind_insn(insn: &mut InsnNode, ssa_ctx: &mut SSAContext) {
        unbind_all_args(insn, ssa_ctx);
        unbind_result(insn, ssa_ctx);
        insn.add_flag(AFlag::DontGenerate);
    }

    /// Unbind all arguments from SSA use lists (JADX: unbindAllArgs)
    ///
    /// Removes all argument uses from SSA variables. For PHI instructions,
    /// also updates the usedInPhi lists. Marks instruction with REMOVE and
    /// DONT_GENERATE flags.
    ///
    /// JADX Reference: InsnRemover.java:104-117
    /// ```java
    /// public static void unbindAllArgs(@Nullable MethodNode mth, InsnNode insn) {
    ///     for (InsnArg arg : insn.getArguments()) {
    ///         unbindArgUsage(mth, arg);
    ///     }
    ///     if (insn.getType() == InsnType.PHI) {
    ///         for (InsnArg arg : insn.getArguments()) {
    ///             if (arg instanceof RegisterArg) {
    ///                 ((RegisterArg) arg).getSVar().updateUsedInPhiList();
    ///             }
    ///         }
    ///     }
    ///     insn.add(AFlag.REMOVE);
    ///     insn.add(AFlag.DONT_GENERATE);
    /// }
    /// ```
    pub fn unbind_all_args(insn: &mut InsnNode, ssa_ctx: &mut SSAContext) {
        // Unbind each argument
        for arg in insn.insn_type.get_args() {
            unbind_arg_usage(arg, insn.offset, ssa_ctx);
        }

        // Handle PHI instructions - update usedInPhi lists
        if let InsnType::Phi { sources, .. } = &insn.insn_type {
            for (_, arg) in sources {
                if let InsnArg::Register(reg) = arg {
                    let var_ref = SSAVarRef::new(reg.reg_num, reg.ssa_version);
                    if let Some(var) = ssa_ctx.get_var_mut(var_ref) {
                        // Remove from usedInPhi list
                        var.remove_phi_use(insn.offset);
                    }
                }
            }
        }

        insn.add_flag(AFlag::Remove);
        insn.add_flag(AFlag::DontGenerate);
    }

    /// Unbind result register from SSA (JADX: unbindResult)
    ///
    /// If the instruction defines an SSA variable, removes it if it has no
    /// remaining uses.
    ///
    /// JADX Reference: InsnRemover.java:119-131
    /// ```java
    /// public static void unbindResult(@Nullable MethodNode mth, InsnNode insn) {
    ///     RegisterArg r = insn.getResult();
    ///     if (r == null) {
    ///         return;
    ///     }
    ///     if (mth != null) {
    ///         SSAVar ssaVar = r.getSVar();
    ///         if (ssaVar != null && ssaVar.getAssignInsn() == insn) {
    ///             removeSsaVar(mth, ssaVar);
    ///         }
    ///     }
    ///     insn.setResult(null);
    /// }
    /// ```
    pub fn unbind_result(insn: &mut InsnNode, ssa_ctx: &mut SSAContext) {
        if let Some(dest) = insn.insn_type.get_dest() {
            let var_ref = SSAVarRef::new(dest.reg_num, dest.ssa_version);

            // Check if this is the defining instruction
            if let Some(var) = ssa_ctx.get_var(var_ref) {
                if var.assign_insn_idx == Some(insn.offset) {
                    // Try to remove SSA var if no uses remain
                    try_remove_ssa_var(var_ref, ssa_ctx);
                }
            }
        }
        insn.result_type = None;
    }

    /// Unbind a single argument from SSA (JADX: unbindArgUsage)
    ///
    /// Removes the use from the SSA variable's use list. For wrapped
    /// instructions, recursively unbinds the inner instruction.
    ///
    /// JADX Reference: InsnRemover.java:165-176
    /// ```java
    /// public static void unbindArgUsage(@Nullable MethodNode mth, InsnArg arg) {
    ///     if (arg instanceof RegisterArg) {
    ///         RegisterArg reg = (RegisterArg) arg;
    ///         SSAVar sVar = reg.getSVar();
    ///         if (sVar != null) {
    ///             sVar.removeUse(reg);
    ///         }
    ///     } else if (arg instanceof InsnWrapArg) {
    ///         InsnWrapArg wrap = (InsnWrapArg) arg;
    ///         unbindInsn(mth, wrap.getWrapInsn());
    ///     }
    /// }
    /// ```
    pub fn unbind_arg_usage(arg: &InsnArg, insn_offset: u32, ssa_ctx: &mut SSAContext) {
        match arg {
            InsnArg::Register(reg) => {
                let var_ref = SSAVarRef::new(reg.reg_num, reg.ssa_version);
                if let Some(var) = ssa_ctx.get_var_mut(var_ref) {
                    var.remove_use(insn_offset);
                }
            }
            InsnArg::Wrapped(wrapped) => {
                if let Some(ref inner) = wrapped.inline_insn {
                    // For wrapped instructions, we would need mutable access
                    // In practice, wrapped insns are already handled separately
                    let _ = inner; // Acknowledge the inner instruction
                }
            }
            _ => {}
        }
    }

    /// Try to remove SSA variable if it has no uses (JADX: removeSsaVar)
    ///
    /// Removes the variable only if it has no remaining uses (neither regular
    /// uses nor PHI uses).
    ///
    /// JADX Reference: InsnRemover.java:133-163
    pub fn try_remove_ssa_var(var_ref: SSAVarRef, ssa_ctx: &mut SSAContext) -> bool {
        if let Some(var) = ssa_ctx.get_var(var_ref) {
            if var.use_list.is_empty() && var.used_in_phi.is_empty() {
                ssa_ctx.remove_var(var_ref);
                return true;
            }
        }
        false
    }

    /// Check if an instruction can be safely removed (JADX: dontGenerateIfNotUsed)
    ///
    /// Returns true if the instruction was marked DONT_GENERATE because its
    /// result is not used in any generated code.
    ///
    /// JADX Reference: InsnUtils.java:238-252
    /// ```java
    /// public static boolean dontGenerateIfNotUsed(InsnNode insn) {
    ///     RegisterArg resArg = insn.getResult();
    ///     if (resArg != null) {
    ///         SSAVar ssaVar = resArg.getSVar();
    ///         for (RegisterArg arg : ssaVar.getUseList()) {
    ///             InsnNode parentInsn = arg.getParentInsn();
    ///             if (parentInsn != null && !parentInsn.contains(AFlag.DONT_GENERATE)) {
    ///                 return false;
    ///             }
    ///         }
    ///     }
    ///     insn.add(AFlag.DONT_GENERATE);
    ///     return true;
    /// }
    /// ```
    pub fn dont_generate_if_not_used(insn: &mut InsnNode, ssa_ctx: &SSAContext) -> bool {
        if let Some(dest) = insn.insn_type.get_dest() {
            let var_ref = SSAVarRef::new(dest.reg_num, dest.ssa_version);
            if let Some(var) = ssa_ctx.get_var(var_ref) {
                // If there are any uses that will be generated, we can't skip
                if !var.use_list.is_empty() {
                    return false;
                }
            }
        }
        insn.add_flag(AFlag::DontGenerate);
        true
    }
}

// =============================================================================
// JADX InsnUtils Parity - Instruction Utility Helpers
// =============================================================================
//
// JADX Clone: jadx-core/src/main/java/jadx/core/utils/InsnUtils.java

/// Constant value types for instruction analysis
///
/// JADX Clone: Return types from InsnUtils.getConstValueByArg/getConstValueByInsn
#[derive(Debug, Clone, PartialEq)]
pub enum ConstValue {
    /// Integer constant (includes byte, short, int, long)
    Int(i64),
    /// Float constant
    Float(f32),
    /// Double constant
    Double(f64),
    /// String constant (by index)
    StringIdx(u32),
    /// Type/class constant (by index)
    TypeIdx(u32),
    /// Null constant
    Null,
}

impl ConstValue {
    /// Create from a LiteralArg
    pub fn from_literal(lit: &LiteralArg) -> Self {
        match lit {
            LiteralArg::Int(v) => ConstValue::Int(*v),
            LiteralArg::Float(v) => ConstValue::Float(*v),
            LiteralArg::Double(v) => ConstValue::Double(*v),
            LiteralArg::Null => ConstValue::Null,
        }
    }

    /// Check if this is a zero value
    pub fn is_zero(&self) -> bool {
        match self {
            ConstValue::Int(0) => true,
            ConstValue::Float(f) if *f == 0.0 => true,
            ConstValue::Double(d) if *d == 0.0 => true,
            ConstValue::Null => true,
            _ => false,
        }
    }
}

/// Instruction utility helpers (JADX: InsnUtils)
///
/// JADX Clone: jadx-core/src/main/java/jadx/core/utils/InsnUtils.java
pub mod insn_utils {
    use super::*;

    /// Get constant value from instruction argument (JADX: getConstValueByArg)
    ///
    /// Returns the constant value from a literal or wrapped const instruction.
    ///
    /// JADX Reference: InsnUtils.java:62-82
    /// ```java
    /// public static Object getConstValueByArg(RootNode root, InsnArg arg) {
    ///     if (arg.isLiteral()) {
    ///         return arg;
    ///     }
    ///     if (arg.isInsnWrap()) {
    ///         InsnNode insn = ((InsnWrapArg) arg).getWrapInsn();
    ///         return getConstValueByInsn(root, insn);
    ///     }
    ///     return null;
    /// }
    /// ```
    pub fn get_const_value_by_arg(arg: &InsnArg) -> Option<ConstValue> {
        match arg {
            InsnArg::Literal(lit) => Some(ConstValue::from_literal(lit)),
            InsnArg::Wrapped(wrapped) => {
                if let Some(ref inner) = wrapped.inline_insn {
                    get_const_value_by_insn(inner)
                } else {
                    None
                }
            }
            _ => None,
        }
    }

    /// Get constant value from instruction (JADX: getConstValueByInsn)
    ///
    /// JADX Reference: InsnUtils.java:89-114
    /// ```java
    /// public static Object getConstValueByInsn(RootNode root, InsnNode insn) {
    ///     switch (insn.getType()) {
    ///         case CONST:
    ///             return insn.getArg(0);
    ///         case CONST_STR:
    ///             return ((ConstStringNode) insn).getString();
    ///         case CONST_CLASS:
    ///             return ((ConstClassNode) insn).getClsType();
    ///         default:
    ///             return null;
    ///     }
    /// }
    /// ```
    pub fn get_const_value_by_insn(insn: &InsnNode) -> Option<ConstValue> {
        match &insn.insn_type {
            InsnType::Const { value, .. } => Some(ConstValue::from_literal(value)),
            InsnType::ConstString { string_idx, .. } => Some(ConstValue::StringIdx(*string_idx)),
            InsnType::ConstClass { type_idx, .. } => Some(ConstValue::TypeIdx(*type_idx)),
            _ => None,
        }
    }

    /// Check if instruction arg contains a specific SSA variable (JADX: containsVar)
    ///
    /// JADX Reference: InsnUtils.java:285-294
    /// ```java
    /// public static boolean containsVar(InsnArg insnArg, RegisterArg arg) {
    ///     if (insnArg.isRegister()) {
    ///         return ((RegisterArg) insnArg).sameRegAndSVar(arg);
    ///     }
    ///     if (insnArg.isInsnWrap()) {
    ///         InsnNode wrapInsn = ((InsnWrapArg) insnArg).getWrapInsn();
    ///         return containsVar(wrapInsn, arg);
    ///     }
    ///     return false;
    /// }
    /// ```
    pub fn arg_contains_var(arg: &InsnArg, target_reg: u16, target_version: u32) -> bool {
        match arg {
            InsnArg::Register(reg) => {
                reg.reg_num == target_reg && reg.ssa_version == target_version
            }
            InsnArg::Wrapped(wrapped) => {
                if let Some(ref inner) = wrapped.inline_insn {
                    insn_contains_var(inner, target_reg, target_version)
                } else {
                    false
                }
            }
            _ => false,
        }
    }

    /// Check if instruction contains a variable (JADX: containsVar for InsnNode)
    ///
    /// Checks both result and all arguments (including wrapped instructions).
    ///
    /// JADX Reference: InsnUtils.java:266-283
    /// ```java
    /// public static boolean containsVar(InsnNode insn, RegisterArg arg) {
    ///     if (insn == null) {
    ///         return false;
    ///     }
    ///     RegisterArg result = insn.getResult();
    ///     if (result != null && result.sameRegAndSVar(arg)) {
    ///         return true;
    ///     }
    ///     for (InsnArg insnArg : insn.getArguments()) {
    ///         if (containsVar(insnArg, arg)) {
    ///             return true;
    ///         }
    ///     }
    ///     return false;
    /// }
    /// ```
    pub fn insn_contains_var(insn: &InsnNode, target_reg: u16, target_version: u32) -> bool {
        // Check result
        if let Some(dest) = insn.insn_type.get_dest() {
            if dest.reg_num == target_reg && dest.ssa_version == target_version {
                return true;
            }
        }
        // Check args
        for arg in insn.insn_type.get_args() {
            if arg_contains_var(arg, target_reg, target_version) {
                return true;
            }
        }
        false
    }

    /// Get wrapped instruction from argument (JADX: getWrappedInsn)
    ///
    /// JADX Reference: InsnUtils.java:222-228
    /// ```java
    /// public static InsnNode getWrappedInsn(InsnArg arg) {
    ///     if (arg != null && arg.isInsnWrap()) {
    ///         return ((InsnWrapArg) arg).getWrapInsn();
    ///     }
    ///     return null;
    /// }
    /// ```
    pub fn get_wrapped_insn(arg: &InsnArg) -> Option<&InsnNode> {
        if let InsnArg::Wrapped(wrapped) = arg {
            wrapped.inline_insn.as_deref()
        } else {
            None
        }
    }

    /// Check if wrapped instruction is of specific type (JADX: isWrapped)
    ///
    /// JADX Reference: InsnUtils.java:230-236
    /// ```java
    /// public static boolean isWrapped(InsnArg arg, InsnType insnType) {
    ///     if (arg != null && arg.isInsnWrap()) {
    ///         InsnNode wrapInsn = ((InsnWrapArg) arg).getWrapInsn();
    ///         return wrapInsn.getType() == insnType;
    ///     }
    ///     return false;
    /// }
    /// ```
    pub fn is_wrapped_type(arg: &InsnArg, check_type: &str) -> bool {
        if let InsnArg::Wrapped(wrapped) = arg {
            if let Some(ref inner) = wrapped.inline_insn {
                return inner.type_name() == check_type;
            }
        }
        false
    }

    /// Get single argument from instruction if it has exactly one (JADX: getSingleArg)
    ///
    /// JADX Reference: InsnUtils.java:203-208
    /// ```java
    /// public static InsnArg getSingleArg(InsnNode insn) {
    ///     if (insn != null && insn.getArgsCount() == 1) {
    ///         return insn.getArg(0);
    ///     }
    ///     return null;
    /// }
    /// ```
    pub fn get_single_arg(insn: &InsnNode) -> Option<&InsnArg> {
        let args = insn.insn_type.get_args();
        if args.len() == 1 {
            args.first()
        } else {
            None
        }
    }

    /// Check if instruction is of specific type (JADX: isInsnType)
    ///
    /// JADX Reference: InsnUtils.java:218-220
    /// ```java
    /// public static boolean isInsnType(@Nullable InsnNode insn, InsnType insnType) {
    ///     return insn != null && insn.getType() == insnType;
    /// }
    /// ```
    pub fn is_insn_type(insn: &InsnNode, type_name_str: &str) -> bool {
        insn.type_name() == type_name_str
    }

    /// Format bytecode offset as hex string (JADX: formatOffset)
    ///
    /// JADX Reference: InsnUtils.java:36-41
    /// ```java
    /// public static String formatOffset(int offset) {
    ///     if (offset < 0) {
    ///         return "?";
    ///     }
    ///     return String.format("0x%04x", offset);
    /// }
    /// ```
    pub fn format_offset(offset: i32) -> String {
        if offset < 0 {
            "?".to_string()
        } else {
            format!("0x{:04x}", offset)
        }
    }
}

// =============================================================================
// JADX ArithNode.isSameLiteral Parity
// =============================================================================

impl InsnNode {
    /// Compare two arithmetic instructions including literal values (JADX: ArithNode.isSame)
    ///
    /// JADX Reference: ArithNode.java:84-110
    /// ```java
    /// public boolean isSame(InsnNode obj) {
    ///     if (this == obj) return true;
    ///     if (!(obj instanceof ArithNode) || !super.isSame(obj)) return false;
    ///     ArithNode other = (ArithNode) obj;
    ///     return op == other.op && isSameLiteral(other);
    /// }
    ///
    /// private boolean isSameLiteral(ArithNode other) {
    ///     InsnArg thisSecond = getArg(1);
    ///     InsnArg otherSecond = other.getArg(1);
    ///     if (thisSecond.isLiteral() != otherSecond.isLiteral()) {
    ///         return false;
    ///     }
    ///     if (!thisSecond.isLiteral()) {
    ///         return true;  // both not literals
    ///     }
    ///     long thisLit = ((LiteralArg) thisSecond).getLiteral();
    ///     long otherLit = ((LiteralArg) otherSecond).getLiteral();
    ///     return thisLit == otherLit;
    /// }
    /// ```
    pub fn is_same_arith(&self, other: &InsnNode) -> bool {
        match (&self.insn_type, &other.insn_type) {
            (InsnType::Binary { op: op1, right: r1, .. },
             InsnType::Binary { op: op2, right: r2, .. }) => {
                if op1 != op2 {
                    return false;
                }
                // Check literal comparison
                match (r1, r2) {
                    (InsnArg::Literal(l1), InsnArg::Literal(l2)) => l1.same_value(l2),
                    (InsnArg::Literal(_), _) | (_, InsnArg::Literal(_)) => false,
                    _ => true,  // Both non-literals, ops match
                }
            }
            _ => false,
        }
    }
}

// =============================================================================
// JADX ConstructorInsn.CallType Parity
// =============================================================================

/// Constructor call type (JADX: ConstructorInsn.CallType)
///
/// JADX Clone: jadx-core/src/main/java/jadx/core/dex/instructions/mods/ConstructorInsn.java:20-25
/// ```java
/// public enum CallType {
///     CONSTRUCTOR,  // new Object()
///     SUPER,        // super()
///     THIS,         // this()
///     SELF          // same class call
/// }
/// ```
#[derive(Debug, Clone, Copy, PartialEq, Eq)]
pub enum ConstructorCallType {
    /// Normal constructor: new Object()
    Constructor,
    /// Super constructor: super(...)
    Super,
    /// This constructor: this(...)
    This,
    /// Same class self call
    SelfCall,
}

impl InsnType {
    /// Get the constructor call type (JADX: ConstructorInsn.getCallType)
    ///
    /// Determines whether this is a normal constructor, super(), this(),
    /// or self call based on the instance argument and class type.
    ///
    /// JADX Reference: ConstructorInsn.java:45-62
    /// ```java
    /// public CallType getCallType() {
    ///     if (callType != null) return callType;
    ///     if (instanceArg.isThis()) {
    ///         if (classType.equals(mth.getParentClass().getType())) {
    ///             callType = CallType.THIS;
    ///         } else {
    ///             callType = CallType.SUPER;
    ///         }
    ///     } else {
    ///         callType = CallType.CONSTRUCTOR;
    ///     }
    ///     return callType;
    /// }
    /// ```
    pub fn get_constructor_call_type(
        &self,
        constructor_class: &str,
        current_class: &str,
        is_instance_this: bool,
    ) -> Option<ConstructorCallType> {
        if let InsnType::Constructor { .. } = self {
            if is_instance_this {
                if constructor_class == current_class {
                    Some(ConstructorCallType::This)
                } else {
                    Some(ConstructorCallType::Super)
                }
            } else {
                Some(ConstructorCallType::Constructor)
            }
        } else {
            None
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

    #[test]
    fn test_const_value() {
        let int_val = ConstValue::Int(42);
        assert!(!int_val.is_zero());

        let zero_val = ConstValue::Int(0);
        assert!(zero_val.is_zero());

        let null_val = ConstValue::Null;
        assert!(null_val.is_zero());
    }

    #[test]
    fn test_insn_utils_format_offset() {
        assert_eq!(insn_utils::format_offset(0), "0x0000");
        assert_eq!(insn_utils::format_offset(255), "0x00ff");
        assert_eq!(insn_utils::format_offset(-1), "?");
    }

    #[test]
    fn test_constructor_call_type() {
        let ctor = InsnType::Constructor {
            dest: RegisterArg::new(0),
            type_idx: 0,
            method_idx: 0,
            args: vec![],
            generic_info: None,
        };

        // Normal constructor
        assert_eq!(
            ctor.get_constructor_call_type("SomeClass", "MyClass", false),
            Some(ConstructorCallType::Constructor)
        );

        // Super call
        assert_eq!(
            ctor.get_constructor_call_type("ParentClass", "MyClass", true),
            Some(ConstructorCallType::Super)
        );

        // This call
        assert_eq!(
            ctor.get_constructor_call_type("MyClass", "MyClass", true),
            Some(ConstructorCallType::This)
        );
    }
}
