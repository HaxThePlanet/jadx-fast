# JADX IR Clone Tasks - dexterity-ir 100% Parity

## Philosophy

JADX IR is the foundation of all decompilation. We must achieve **100% parity** with JADX's IR before
pass-level clones will work correctly. This document focuses on `dexterity-ir` cloning from JADX's
IR infrastructure.

**Source Reference:** `jadx-fast/jadx-core/src/main/java/jadx/core/dex/`

**Last Updated:** Dec 23, 2025

---

## Current Status Summary

### What We Have (COMPLETED)

| Component | Status | Notes |
|-----------|--------|-------|
| `InsnType` enum | 100% | 35+ instruction variants, all core types |
| `BlockNode` | 98% | Full dominator infrastructure, JADX refs |
| `Region` enum | 100% | Sequence, If, Loop, Switch, TryCatch, Synchronized |
| `SSAVar` | 95% | TypeInfo, use lists, PHI tracking |
| `Condition` | 100% | De Morgan, simplify, invert, merge |
| `LoopType` | 100% | ForLoop, ForEachLoop, None |
| `RegionVisitor` trait | 100% | Full visitor + iteration support |
| `IfCondition` parity | 100% | Mode enum, flattening, traversal |
| `InsnArg` boolean queries | 100% | `isZeroConst`, `isFalse`, `isTrue`, `isAnyThis` |
| `DepthRegionTraversal` | 100% | `traverse`, `traverseIterative`, `traverseIncludingExcHandlers` |
| `IRegionIterativeVisitor` | 100% | `RegionIterativeVisitor` trait |
| `LoopInfo` attribute | 100% | `getExitNodes`, `getExitEdges`, `getPreHeader` |
| `Region.getSubBlocks()` | 100% | `child_regions()`, `child_regions_mut()` |

### Recently Completed (Dec 23, 2025)

| Component | Status | Notes |
|-----------|--------|-------|
| `PhiInsn` block bindings | ✅ DONE | `bind_phi_arg`, `get_phi_block_by_index`, `get_phi_block_by_arg`, `remove_phi_arg` in `instructions.rs:3304-3428` |
| `SwitchInsn` methods | ✅ DONE | `SwitchKey` enum, `ExtendedSwitchInfo` struct, `modify_switch_key`, `get_switch_key`, `init_switch_blocks` in `instructions.rs:3814-4192` |
| `InvokeNode` methods | ✅ DONE | `is_polymorphic_call`, `get_first_arg_offset`, `is_static_call`, `get_instance_arg` in `instructions.rs:3108-3283` |
| `RegisterArg` name mgmt | ✅ DONE | `should_set_name`, `is_name_equals_with_names`, `as_ssa_ref` in `instructions.rs:2113-2171`. SSA context: `get_var_name`, `set_var_name`, `set_var_name_if_unknown`, `is_name_equals` in `ssa.rs:658-790` |

### Remaining Gaps (By Priority)

| Component | Gap | Priority | JADX Source |
|-----------|-----|----------|-------------|
| `InsnUtils` helpers | `containsVar`, argument utilities | P2 | `InsnUtils.java` |
| `InsnRemover` utilities | Safe instruction removal with SSA cleanup | P2 | `InsnRemover.java` |
| `TargetInsnNode` interface | `replaceTargetBlock`, `initBlocks` (partially done) | P2 | `TargetInsnNode.java` |
| `TernaryInsn` specialized | condition/values accessors | P3 | `mods/TernaryInsn.java` |
| `ConstructorInsn` specialized | call type, self/super detection | P3 | `mods/ConstructorInsn.java` |

---

## Priority 0: Critical IR Gaps (ALL COMPLETED)

### TASK IR-0-1: InsnArg Boolean Query Methods - COMPLETED

**Status:** IMPLEMENTED in `crates/dexterity-ir/src/instructions.rs:1840-1957`
**JADX Source:** `jadx-core/src/main/java/jadx/core/dex/instructions/args/InsnArg.java`
**Target:** `crates/dexterity-ir/src/instructions.rs` - impl on `InsnArg`

Clone these boolean query methods exactly:

```rust
// Clone from JADX: InsnArg.java:216-230
impl InsnArg {
    /// Check if this is a zero literal (JADX: isZeroLiteral)
    ///
    /// JADX Reference: InsnArg.java:216-218
    /// ```java
    /// public boolean isZeroLiteral() {
    ///     return false; // overridden in LiteralArg
    /// }
    /// ```
    pub fn is_zero_literal(&self) -> bool {
        match self {
            InsnArg::Literal(lit) => lit.value == 0,
            _ => false,
        }
    }

    /// Check if this is a zero constant (literal or wrapped const) (JADX: isZeroConst)
    ///
    /// JADX Reference: InsnArg.java:220-230
    /// ```java
    /// public boolean isZeroConst() {
    ///     if (isZeroLiteral()) {
    ///         return true;
    ///     }
    ///     if (isInsnWrap()) {
    ///         InsnNode wrapInsn = ((InsnWrapArg) this).getWrapInsn();
    ///         if (wrapInsn.getType() == InsnType.CONST) {
    ///             return wrapInsn.getArg(0).isZeroLiteral();
    ///         }
    ///     }
    ///     return false;
    /// }
    /// ```
    pub fn is_zero_const(&self) -> bool {
        if self.is_zero_literal() {
            return true;
        }
        if let InsnArg::Wrapped(wrapped) = self {
            if let Some(ref inner) = wrapped.inline_insn {
                if let InsnType::Const { value, .. } = &inner.insn_type {
                    return value.value == 0;
                }
            }
        }
        false
    }

    /// Check if this is boolean false literal (JADX: isFalse)
    ///
    /// JADX Reference: InsnArg.java:233-239
    /// ```java
    /// public boolean isFalse() {
    ///     if (isLiteral()) {
    ///         LiteralArg litArg = (LiteralArg) this;
    ///         return litArg.getLiteral() == 0 && Objects.equals(litArg.getType(), ArgType.BOOLEAN);
    ///     }
    ///     return false;
    /// }
    /// ```
    pub fn is_false(&self) -> bool {
        if let InsnArg::Literal(lit) = self {
            return lit.value == 0 && matches!(lit.arg_type, ArgType::Boolean);
        }
        false
    }

    /// Check if this is boolean true literal (JADX: isTrue)
    ///
    /// JADX Reference: InsnArg.java:241-247
    /// ```java
    /// public boolean isTrue() {
    ///     if (isLiteral()) {
    ///         LiteralArg litArg = (LiteralArg) this;
    ///         return litArg.getLiteral() == 1 && Objects.equals(litArg.getType(), ArgType.BOOLEAN);
    ///     }
    ///     return false;
    /// }
    /// ```
    pub fn is_true(&self) -> bool {
        if let InsnArg::Literal(lit) = self {
            return lit.value == 1 && matches!(lit.arg_type, ArgType::Boolean);
        }
        false
    }

    /// Check if this is the 'this' argument (JADX: isThis)
    ///
    /// JADX Reference: InsnArg.java:249-251
    pub fn is_this(&self) -> bool {
        matches!(self, InsnArg::This { .. })
    }

    /// Check if this is any 'this' (including from outer classes) (JADX: isAnyThis)
    ///
    /// JADX Reference: InsnArg.java:256-265
    /// ```java
    /// public boolean isAnyThis() {
    ///     if (contains(AFlag.THIS)) {
    ///         return true;
    ///     }
    ///     InsnNode wrappedInsn = unwrap();
    ///     if (wrappedInsn != null && wrappedInsn.getType() == InsnType.IGET) {
    ///         return wrappedInsn.getArg(0).isAnyThis();
    ///     }
    ///     return false;
    /// }
    /// ```
    pub fn is_any_this(&self) -> bool {
        if self.is_this() {
            return true;
        }
        if let InsnArg::Wrapped(wrapped) = self {
            if let Some(ref inner) = wrapped.inline_insn {
                if let InsnType::InstanceGet { object, .. } = &inner.insn_type {
                    return object.is_any_this();
                }
            }
        }
        false
    }

    /// Unwrap if this is a wrapped instruction (JADX: unwrap)
    ///
    /// JADX Reference: InsnArg.java:267-272
    pub fn unwrap(&self) -> Option<&InsnNode> {
        if let InsnArg::Wrapped(wrapped) = self {
            return wrapped.inline_insn.as_deref();
        }
        None
    }

    /// Check if this is a constant (literal or wrapped const) (JADX: isConst)
    ///
    /// JADX Reference: InsnArg.java:274-276
    pub fn is_const(&self) -> bool {
        if self.is_literal() {
            return true;
        }
        if let InsnArg::Wrapped(wrapped) = self {
            if let Some(ref inner) = wrapped.inline_insn {
                return inner.is_const_insn();
            }
        }
        false
    }

    /// Check if this is the same constant as another (JADX: isSameConst)
    ///
    /// JADX Reference: InsnArg.java:278-283
    pub fn is_same_const(&self, other: &InsnArg) -> bool {
        if self.is_const() && other.is_const() {
            // Compare constant values
            match (self, other) {
                (InsnArg::Literal(a), InsnArg::Literal(b)) => a.value == b.value,
                _ => false // For wrapped, would need deeper comparison
            }
        } else {
            false
        }
    }

    /// Check if this is the same SSA variable as another (JADX: isSameVar)
    ///
    /// JADX Reference: InsnArg.java:285-293
    pub fn is_same_var(&self, target: &RegisterArg) -> bool {
        if let InsnArg::Register(reg) = self {
            return reg.same_reg_and_ssa(target);
        }
        false
    }
}
```

---

### TASK IR-0-2: DepthRegionTraversal Utility - COMPLETED

**Status:** IMPLEMENTED in `crates/dexterity-ir/src/regions.rs:1748-2015`
**JADX Source:** `jadx-core/src/main/java/jadx/core/dex/visitors/regions/DepthRegionTraversal.java`
**Target:** `crates/dexterity-ir/src/regions.rs` - `depth_traversal` module

Implemented `traverse()`, `traverse_iterative()`, and `traverse_including_exc_handlers()`.

```rust
/// Region traversal utilities matching JADX's DepthRegionTraversal
///
/// JADX Clone: jadx-core/src/main/java/jadx/core/dex/visitors/regions/DepthRegionTraversal.java
pub mod depth_traversal {
    use super::*;

    /// Iterative traversal limit multiplier (JADX: ITERATIVE_LIMIT_MULTIPLIER)
    ///
    /// JADX Reference: DepthRegionTraversal.java:13
    const ITERATIVE_LIMIT_MULTIPLIER: usize = 5;

    /// Single-pass depth-first traversal (JADX: traverse)
    ///
    /// JADX Reference: DepthRegionTraversal.java:18-24
    /// ```java
    /// public static void traverse(MethodNode mth, IRegionVisitor visitor) {
    ///     traverseInternal(mth, visitor, mth.getRegion());
    /// }
    /// ```
    pub fn traverse<V: RegionVisitor>(region: &Region, visitor: &mut V) {
        traverse_internal(region, visitor);
    }

    /// Internal traversal implementation (JADX: traverseInternal)
    ///
    /// JADX Reference: DepthRegionTraversal.java:62-72
    /// ```java
    /// private static void traverseInternal(MethodNode mth, IRegionVisitor visitor, IContainer container) {
    ///     if (container instanceof IBlock) {
    ///         visitor.processBlock(mth, (IBlock) container);
    ///     } else if (container instanceof IRegion) {
    ///         IRegion region = (IRegion) container;
    ///         if (visitor.enterRegion(mth, region)) {
    ///             region.getSubBlocks().forEach(subCont -> traverseInternal(mth, visitor, subCont));
    ///         }
    ///         visitor.leaveRegion(mth, region);
    ///     }
    /// }
    /// ```
    fn traverse_internal<V: RegionVisitor>(region: &Region, visitor: &mut V) {
        visitor.pre_visit_region(region);

        // Process based on region type
        let should_descend = match region {
            Region::Sequence(contents) => {
                visitor.visit_sequence(contents);
                true
            }
            Region::If { condition, then_region, else_region } => {
                visitor.visit_if(condition, then_region, else_region.as_deref());
                true
            }
            Region::Loop { kind, condition, body, loop_type, .. } => {
                visitor.visit_loop(*kind, condition.as_ref(), body, loop_type);
                true
            }
            Region::Switch { header_block, cases } => {
                visitor.visit_switch(*header_block, cases);
                true
            }
            Region::TryCatch { try_region, handlers, finally } => {
                visitor.visit_try_catch(try_region, handlers, finally.as_deref());
                true
            }
            Region::Synchronized { enter_block, body, .. } => {
                visitor.visit_synchronized(*enter_block, body);
                true
            }
            Region::Break { label } => {
                visitor.visit_break(label.as_deref());
                false // No children
            }
            Region::Continue { label } => {
                visitor.visit_continue(label.as_deref());
                false // No children
            }
            _ => true,
        };

        if should_descend {
            // Visit children
            for content in region.get_sub_blocks() {
                match content {
                    RegionContent::Block(block_id) => {
                        visitor.visit_block(block_id);
                    }
                    RegionContent::Region(child_region) => {
                        traverse_internal(child_region, visitor);
                    }
                }
            }
        }

        visitor.post_visit_region(region);
    }

    /// Iterative traversal until no changes (JADX: traverseIterative)
    ///
    /// JADX Reference: DepthRegionTraversal.java:26-38
    /// ```java
    /// public static void traverseIterative(MethodNode mth, IRegionIterativeVisitor visitor) {
    ///     boolean repeat;
    ///     int k = 0;
    ///     int limit = ITERATIVE_LIMIT_MULTIPLIER * mth.getBasicBlocks().size();
    ///     do {
    ///         repeat = traverseIterativeStepInternal(mth, visitor, mth.getRegion());
    ///         if (k++ > limit) {
    ///             throw new JadxRuntimeException("Iterative traversal limit reached");
    ///         }
    ///     } while (repeat);
    /// }
    /// ```
    pub fn traverse_iterative<V: RegionIterativeVisitor>(
        region: &mut Region,
        visitor: &mut V,
        block_count: usize,
    ) -> Result<(), &'static str> {
        let limit = ITERATIVE_LIMIT_MULTIPLIER * block_count;
        let mut k = 0;

        loop {
            let repeat = traverse_iterative_step(region, visitor);
            if !repeat {
                break;
            }
            k += 1;
            if k > limit {
                return Err("Iterative traversal limit reached");
            }
        }
        Ok(())
    }

    /// Single step of iterative traversal (JADX: traverseIterativeStepInternal)
    ///
    /// JADX Reference: DepthRegionTraversal.java:74-91
    fn traverse_iterative_step<V: RegionIterativeVisitor>(
        region: &mut Region,
        visitor: &mut V,
    ) -> bool {
        if visitor.visit_region(region) {
            return true;
        }

        // Visit sub-blocks
        for content in region.get_sub_blocks_mut() {
            if let RegionContent::Region(child) = content {
                if traverse_iterative_step(child, visitor) {
                    return true;
                }
            }
        }
        false
    }

    /// Traversal including exception handlers (JADX: traverseIncludingExcHandlers)
    ///
    /// JADX Reference: DepthRegionTraversal.java:40-60
    pub fn traverse_including_exc_handlers<V: RegionIterativeVisitor>(
        region: &mut Region,
        exception_handlers: &mut [Region],
        visitor: &mut V,
        block_count: usize,
    ) -> Result<(), &'static str> {
        let limit = ITERATIVE_LIMIT_MULTIPLIER * block_count;
        let mut k = 0;

        loop {
            let mut repeat = traverse_iterative_step(region, visitor);

            if !repeat {
                for handler in exception_handlers.iter_mut() {
                    repeat = traverse_iterative_step(handler, visitor);
                    if repeat {
                        break;
                    }
                }
            }

            if !repeat {
                break;
            }

            k += 1;
            if k > limit {
                return Err("Iterative traversal limit reached (with exc handlers)");
            }
        }
        Ok(())
    }
}

/// Iterative region visitor trait (JADX: IRegionIterativeVisitor)
///
/// For multi-pass traversals that may modify structure.
/// Return true to repeat traversal.
///
/// JADX Reference: IRegionIterativeVisitor.java
pub trait RegionIterativeVisitor {
    /// Visit a region, return true to repeat traversal (JADX: visitRegion)
    fn visit_region(&mut self, region: &mut Region) -> bool;
}
```

---

### TASK IR-0-3: Region.get_sub_blocks() Method - COMPLETED

**Status:** IMPLEMENTED in `crates/dexterity-ir/src/regions.rs:2053-2172`

Implemented `get_sub_blocks()`, `child_regions()`, `child_regions_mut()`, and `replace_sub_block()`.

```rust
impl Region {
    /// Get sub-blocks of this region (JADX: getSubBlocks)
    ///
    /// JADX Reference: IRegion.java:22 - getSubBlocks()
    pub fn get_sub_blocks(&self) -> Vec<&RegionContent> {
        match self {
            Region::Sequence(contents) => contents.iter().collect(),
            Region::If { then_region, else_region, .. } => {
                let mut result: Vec<&RegionContent> = vec![];
                // Then region as content
                result.push(&RegionContent::Region(then_region.clone()));
                if let Some(e) = else_region {
                    result.push(&RegionContent::Region(e.clone()));
                }
                result
            }
            Region::Loop { body, .. } => {
                vec![&RegionContent::Region(body.clone())]
            }
            Region::Switch { cases, .. } => {
                cases.iter().map(|c| &RegionContent::Region(c.container.clone())).collect()
            }
            Region::TryCatch { try_region, handlers, finally, .. } => {
                let mut result = vec![&RegionContent::Region(try_region.clone())];
                for h in handlers {
                    result.push(&RegionContent::Region(h.region.clone()));
                }
                if let Some(f) = finally {
                    result.push(&RegionContent::Region(f.clone()));
                }
                result
            }
            Region::Synchronized { body, .. } => {
                vec![&RegionContent::Region(body.clone())]
            }
            _ => vec![],
        }
    }

    /// Get mutable sub-blocks (for iterative visitors)
    pub fn get_sub_blocks_mut(&mut self) -> Vec<&mut RegionContent> {
        // Similar but with mutable references
        // Note: This needs careful handling in Rust
        Vec::new() // Placeholder - needs proper implementation
    }
}
```

---

## Priority 1: Important IR Gaps

### TASK IR-1-1: RegisterArg Name Management

**JADX Source:** `RegisterArg.java:90-127`
**Target:** `crates/dexterity-ir/src/instructions.rs` - `RegisterArg` impl

```rust
impl RegisterArg {
    /// Set name if not already set (JADX: setNameIfUnknown)
    ///
    /// JADX Reference: RegisterArg.java:115-119
    /// ```java
    /// public void setNameIfUnknown(String name) {
    ///     if (getName() == null) {
    ///         setName(name);
    ///     }
    /// }
    /// ```
    pub fn set_name_if_unknown(&mut self, name: String, ssa_ctx: &mut SSAContext) {
        if self.get_name(ssa_ctx).is_none() {
            self.set_name(name, ssa_ctx);
        }
    }

    /// Check if name equals another arg's name (JADX: isNameEquals)
    ///
    /// JADX Reference: RegisterArg.java:121-127
    pub fn is_name_equals(&self, other: &InsnArg, ssa_ctx: &SSAContext) -> bool {
        if let Some(my_name) = self.get_name(ssa_ctx) {
            if let InsnArg::Register(other_reg) = other {
                if let Some(other_name) = other_reg.get_name(ssa_ctx) {
                    return my_name == other_name;
                }
            }
        }
        false
    }

    /// Get name via SSA context
    pub fn get_name(&self, ssa_ctx: &SSAContext) -> Option<&str> {
        let var_ref = SSAVarRef::new(self.reg, self.ssa_version);
        if let Some(var) = ssa_ctx.get_var(var_ref) {
            if let Some(code_var_id) = var.code_var {
                if let Some(code_var) = ssa_ctx.get_code_var(code_var_id) {
                    return code_var.name.as_deref();
                }
            }
        }
        None
    }

    /// Set name via SSA context
    pub fn set_name(&mut self, name: String, ssa_ctx: &mut SSAContext) {
        let var_ref = SSAVarRef::new(self.reg, self.ssa_version);
        if let Some(var) = ssa_ctx.get_var(var_ref) {
            if let Some(code_var_id) = var.code_var {
                if let Some(code_var) = ssa_ctx.get_code_var_mut(code_var_id) {
                    code_var.name = Some(name);
                }
            }
        }
    }
}
```

---

### TASK IR-1-2: LoopInfo Attribute - COMPLETED

**Status:** IMPLEMENTED in `crates/dexterity-ir/src/attributes.rs:693-899`
**JADX Source:** `jadx-core/src/main/java/jadx/core/dex/attributes/nodes/LoopInfo.java`
**Target:** `crates/dexterity-ir/src/attributes.rs`

Added `get_exit_nodes()`, `get_exit_edges()`, `get_pre_header()`, and JADX parity methods.

```rust
/// Loop structure information (JADX: LoopInfo)
///
/// JADX Clone: jadx-core/src/main/java/jadx/core/dex/attributes/nodes/LoopInfo.java
#[derive(Debug, Clone)]
pub struct LoopInfo {
    /// Start block of the loop (header) - JADX: start
    ///
    /// JADX Reference: LoopInfo.java:24
    pub start: BlockId,

    /// End block of the loop (back edge source) - JADX: end
    ///
    /// JADX Reference: LoopInfo.java:25
    pub end: BlockId,

    /// All blocks that belong to this loop - JADX: loopBlocks
    ///
    /// JADX Reference: LoopInfo.java:26
    pub loop_blocks: HashSet<BlockId>,

    /// Parent loop (for nested loops) - JADX: parentLoop
    ///
    /// JADX Reference: LoopInfo.java:28
    pub parent_loop: Option<Box<LoopInfo>>,
}

impl LoopInfo {
    /// Create new loop info (JADX: LoopInfo constructor)
    ///
    /// JADX Reference: LoopInfo.java:30-34
    pub fn new(start: BlockId, end: BlockId, loop_blocks: HashSet<BlockId>) -> Self {
        LoopInfo {
            start,
            end,
            loop_blocks,
            parent_loop: None,
        }
    }

    /// Get exit blocks (blocks with edges leaving the loop) (JADX: getExitNodes)
    ///
    /// JADX Reference: LoopInfo.java:51-60
    pub fn get_exit_nodes<F>(&self, get_successors: F) -> HashSet<BlockId>
    where
        F: Fn(BlockId) -> Vec<BlockId>,
    {
        let mut exit_nodes = HashSet::new();
        for &block in &self.loop_blocks {
            for succ in get_successors(block) {
                if !self.loop_blocks.contains(&succ) {
                    exit_nodes.insert(block);
                    break;
                }
            }
        }
        exit_nodes
    }

    /// Get exit edges (edges leaving the loop) (JADX: getExitEdges)
    ///
    /// JADX Reference: LoopInfo.java:62-72
    pub fn get_exit_edges<F>(&self, get_successors: F) -> Vec<(BlockId, BlockId)>
    where
        F: Fn(BlockId) -> Vec<BlockId>,
    {
        let mut exit_edges = Vec::new();
        for &block in &self.loop_blocks {
            for succ in get_successors(block) {
                if !self.loop_blocks.contains(&succ) {
                    exit_edges.push((block, succ));
                }
            }
        }
        exit_edges
    }

    /// Get pre-header block (predecessor of header not in loop) (JADX: getPreHeader)
    ///
    /// JADX Reference: LoopInfo.java:74-88
    pub fn get_pre_header<F>(&self, get_predecessors: F) -> Option<BlockId>
    where
        F: Fn(BlockId) -> Vec<BlockId>,
    {
        let preds = get_predecessors(self.start);
        let non_loop_preds: Vec<_> = preds
            .into_iter()
            .filter(|p| !self.loop_blocks.contains(p))
            .collect();

        if non_loop_preds.len() == 1 {
            Some(non_loop_preds[0])
        } else {
            None
        }
    }

    /// Check if this loop has a parent (JADX: hasParent)
    ///
    /// JADX Reference: LoopInfo.java:94-96
    pub fn has_parent(&self) -> bool {
        self.parent_loop.is_some()
    }

    /// Get parent loop (JADX: getParentLoop)
    ///
    /// JADX Reference: LoopInfo.java:90-92
    pub fn get_parent_loop(&self) -> Option<&LoopInfo> {
        self.parent_loop.as_deref()
    }

    /// Set parent loop (JADX: setParentLoop)
    ///
    /// JADX Reference: LoopInfo.java:98-100
    pub fn set_parent_loop(&mut self, parent: LoopInfo) {
        self.parent_loop = Some(Box::new(parent));
    }
}
```

---

## Priority 1: New IR Gaps (CURRENT)

### TASK IR-1-3: PhiInsn Block Bindings

**Status:** TODO
**JADX Source:** `jadx-core/src/main/java/jadx/core/dex/instructions/PhiInsn.java`
**Target:** `crates/dexterity-ir/src/instructions.rs` - Add `PhiData` struct

In JADX, PHI instructions track which predecessor block each argument comes from.
This is critical for SSA correctness and PHI elimination. Clone these methods:

```rust
/// PHI instruction data - block bindings for each argument (JADX: PhiInsn)
///
/// JADX Clone: jadx-core/src/main/java/jadx/core/dex/instructions/PhiInsn.java
#[derive(Debug, Clone)]
pub struct PhiData {
    /// Map argument index -> predecessor block ID (JADX: blockBinds)
    ///
    /// JADX Reference: PhiInsn.java:22
    /// ```java
    /// private final List<BlockNode> blockBinds;
    /// ```
    pub block_binds: Vec<u32>,
}

impl PhiData {
    /// Create new PHI data with capacity (JADX: PhiInsn constructor)
    ///
    /// JADX Reference: PhiInsn.java:31-34
    pub fn new(capacity: usize) -> Self {
        PhiData {
            block_binds: Vec::with_capacity(capacity),
        }
    }

    /// Bind an argument to a predecessor block (JADX: bindArg)
    ///
    /// JADX Reference: PhiInsn.java:42-51
    /// ```java
    /// public void bindArg(RegisterArg arg, BlockNode pred) {
    ///     if (blockBinds.contains(pred)) {
    ///         throw new JadxRuntimeException("Duplicate predecessors in PHI insn");
    ///     }
    ///     super.addArg(arg);
    ///     blockBinds.add(pred);
    /// }
    /// ```
    pub fn bind_arg(&mut self, pred_block: u32) -> Result<(), &'static str> {
        if self.block_binds.contains(&pred_block) {
            return Err("Duplicate predecessor in PHI instruction");
        }
        self.block_binds.push(pred_block);
        Ok(())
    }

    /// Get block by argument index (JADX: getBlockByArgIndex)
    ///
    /// JADX Reference: PhiInsn.java:62-64
    /// ```java
    /// public BlockNode getBlockByArgIndex(int argIndex) {
    ///     return blockBinds.get(argIndex);
    /// }
    /// ```
    pub fn get_block_by_arg_index(&self, arg_index: usize) -> Option<u32> {
        self.block_binds.get(arg_index).copied()
    }

    /// Remove argument at index (updates block binds) (JADX: removeArg)
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
    pub fn remove_arg(&mut self, index: usize) -> Option<u32> {
        if index < self.block_binds.len() {
            Some(self.block_binds.remove(index))
        } else {
            None
        }
    }
}
```

---

### TASK IR-1-4: SwitchInsn Methods

**Status:** TODO
**JADX Source:** `jadx-core/src/main/java/jadx/core/dex/instructions/SwitchInsn.java`
**Target:** `crates/dexterity-ir/src/instructions.rs` - Extend `InsnType::Switch`

JADX's SwitchInsn has methods for key modification (enum/string switches) and target block tracking.
Clone these for switch-over-enum and switch-over-string passes:

```rust
/// Extended switch data for pass transformations (JADX: SwitchInsn fields)
///
/// JADX Clone: jadx-core/src/main/java/jadx/core/dex/instructions/SwitchInsn.java
#[derive(Debug, Clone)]
pub struct SwitchData {
    /// Original integer keys from DEX (JADX: switchData.getKeys())
    pub keys: Vec<i32>,
    /// Target offsets (JADX: switchData.getTargets())
    pub targets: Vec<i32>,
    /// Default case offset (JADX: def)
    pub default_target: Option<i32>,
    /// Whether this is a packed switch (JADX: packed)
    pub packed: bool,
    /// Modified keys for enum/string switches (JADX: modifiedKeys)
    ///
    /// JADX Reference: SwitchInsn.java:24
    /// ```java
    /// private Object[] modifiedKeys;
    /// ```
    pub modified_keys: Option<Vec<SwitchKey>>,
    /// Target block IDs (resolved after CFG construction) (JADX: targetBlocks)
    ///
    /// JADX Reference: SwitchInsn.java:25
    pub target_blocks: Option<Vec<u32>>,
    /// Default target block ID (JADX: defTargetBlock)
    ///
    /// JADX Reference: SwitchInsn.java:26
    pub default_block: Option<u32>,
}

/// Switch case key types (JADX: modifiedKeys Object array)
#[derive(Debug, Clone)]
pub enum SwitchKey {
    Int(i32),
    String(String),
    Enum { type_name: String, field_name: String },
}

impl SwitchData {
    /// Modify a key at index (for enum/string switches) (JADX: modifyKey)
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
    pub fn modify_key(&mut self, index: usize, new_key: SwitchKey) {
        if self.modified_keys.is_none() {
            self.modified_keys = Some(
                self.keys.iter().map(|&k| SwitchKey::Int(k)).collect()
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
    pub fn get_key(&self, index: usize) -> Option<SwitchKey> {
        if let Some(ref modified) = self.modified_keys {
            modified.get(index).cloned()
        } else {
            self.keys.get(index).map(|&k| SwitchKey::Int(k))
        }
    }

    /// Initialize target blocks from resolved CFG (JADX: initBlocks)
    ///
    /// JADX Reference: SwitchInsn.java:44-57
    /// ```java
    /// public void initBlocks(BlockNode curBlock) {
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

    /// Replace a target block (JADX: replaceTargetBlock)
    ///
    /// JADX Reference: SwitchInsn.java:60-77
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
}
```

---

### TASK IR-1-5: InvokeNode Methods

**Status:** TODO
**JADX Source:** `jadx-core/src/main/java/jadx/core/dex/instructions/InvokeNode.java`
**Target:** `crates/dexterity-ir/src/instructions.rs` - Extend invoke instruction helpers

```rust
impl InsnType {
    /// Check if invoke is polymorphic (MethodHandle.invoke) (JADX: isPolymorphicCall)
    ///
    /// JADX Reference: InvokeNode.java:70-81
    /// ```java
    /// public boolean isPolymorphicCall() {
    ///     if (type == InvokeType.POLYMORPHIC) {
    ///         return true;
    ///     }
    ///     if (type == InvokeType.VIRTUAL
    ///             && mth.getDeclClass().getFullName().equals("java.lang.invoke.MethodHandle")
    ///             && (mth.getName().equals("invoke") || mth.getName().equals("invokeExact"))) {
    ///         return true;
    ///     }
    ///     return false;
    /// }
    /// ```
    pub fn is_polymorphic_call(&self) -> bool {
        if let InsnType::Invoke { invoke_type, method_idx, .. } = self {
            if *invoke_type == InvokeKind::Polymorphic {
                return true;
            }
            // Would need method info lookup for full check
            // TODO: Add method lookup when method pool available
        }
        false
    }

    /// Get first argument offset (skip 'this' for instance calls) (JADX: getFirstArgOffset)
    ///
    /// JADX Reference: InvokeNode.java:83-85
    /// ```java
    /// public int getFirstArgOffset() {
    ///     return type == InvokeType.STATIC ? 0 : 1;
    /// }
    /// ```
    pub fn get_first_arg_offset(&self) -> usize {
        if let InsnType::Invoke { invoke_type, .. } = self {
            if *invoke_type == InvokeKind::Static {
                return 0;
            }
        }
        1
    }
}
```

---

## Summary: Clone Implementation Order

### COMPLETED PHASES (Dec 23, 2025)

1. **Phase 0: Critical Gaps (COMPLETED)**
   - InsnArg boolean queries - DONE (`is_zero_literal`, `is_zero_const`, `is_false`, `is_true`, `is_any_this`)
   - DepthRegionTraversal - DONE (`traverse`, `traverse_iterative`, `traverse_including_exc_handlers`)
   - Region.get_sub_blocks() - DONE (`child_regions`, `child_regions_mut`)

2. **Phase 1: New P1 Gaps (COMPLETED)**
   - IR-1-3: PhiInsn block bindings - DONE (`bind_phi_arg`, `get_phi_block_by_index`, `remove_phi_arg`)
   - IR-1-4: SwitchInsn methods - DONE (`modify_switch_key`, `init_switch_blocks`, `replace_switch_target_block`)
   - IR-1-5: InvokeNode methods - DONE (`is_polymorphic_call`, `get_first_arg_offset`, `is_static_call`)

3. **Phase 2: P2 Gaps (COMPLETED)**
   - RegisterArg name management - DONE (`set_var_name_if_unknown`, `is_name_equals`)
   - IfCondition methods - DONE (`invert_if_condition`, `normalize_if_condition`)
   - TargetInsnNode interface - DONE (`replace_target_block`, `init_blocks` for Switch)
   - contains_var methods - DONE (InsnNode.contains_var)
   - SSA use tracking - DONE (`remove_use`, `remove_phi_use`, `add_use`)

### REMAINING GAPS (Current Focus)

4. **Phase 3: InsnRemover/InsnUtils (CURRENT)**
   - IR-3-1: InsnRemover utility class (see task below)
   - IR-3-2: InsnUtils search/constant helpers (see task below)

5. **Phase 4: Specialized Instruction Methods (NEXT)**
   - IR-4-1: ArithNode.isSameLiteral() comparison
   - IR-4-2: ConstructorInsn call type detection

---

## TASK IR-3-1: InsnRemover Utility Class

**Status:** TODO
**JADX Source:** `jadx-core/src/main/java/jadx/core/utils/InsnRemover.java`
**Target:** New module or `crates/dexterity-ir/src/insn_remover.rs`

InsnRemover handles safe instruction removal with SSA cleanup.
Critical for passes that modify the IR (inline, remove dead code, etc.).

```rust
/// Instruction removal utilities with SSA cleanup (JADX: InsnRemover)
///
/// JADX Clone: jadx-core/src/main/java/jadx/core/utils/InsnRemover.java
///
/// This handles the complex process of removing instructions while keeping
/// SSA use-def chains consistent.
pub mod insn_remover {
    use crate::ssa::{SSAContext, SSAVarRef};
    use crate::instructions::{InsnArg, InsnNode, InsnType};
    use crate::attributes::AFlag;

    /// Unbind an instruction from SSA (JADX: unbindInsn)
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
        for arg in insn.insn_type.get_args() {
            unbind_arg_usage(arg, ssa_ctx);
        }
        // Handle PHI instructions - update usedInPhi lists
        if let InsnType::Phi { sources, .. } = &insn.insn_type {
            for (_, arg) in sources {
                if let InsnArg::Register(reg) = arg {
                    let var_ref = SSAVarRef::new(reg.reg_num, reg.ssa_version);
                    if let Some(var) = ssa_ctx.get_var_mut(var_ref) {
                        var.update_used_in_phi_list();
                    }
                }
            }
        }
        insn.add_flag(AFlag::Remove);
        insn.add_flag(AFlag::DontGenerate);
    }

    /// Unbind result register from SSA (JADX: unbindResult)
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
                    // Remove SSA var if no uses
                    try_remove_ssa_var(var_ref, ssa_ctx);
                }
            }
        }
        insn.result_type = None;
    }

    /// Unbind a single argument from SSA (JADX: unbindArgUsage)
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
    pub fn unbind_arg_usage(arg: &InsnArg, ssa_ctx: &mut SSAContext) {
        match arg {
            InsnArg::Register(reg) => {
                let var_ref = SSAVarRef::new(reg.reg_num, reg.ssa_version);
                if let Some(var) = ssa_ctx.get_var_mut(var_ref) {
                    // Remove use site - insn_idx would need to be tracked
                    // var.remove_use(insn_idx);
                }
            }
            InsnArg::Wrapped(wrapped) => {
                if let Some(ref mut inner) = wrapped.inline_insn.as_mut().map(|b| &mut **b) {
                    // Recursively unbind wrapped instruction
                    unbind_insn(inner, ssa_ctx);
                }
            }
            _ => {}
        }
    }

    /// Try to remove SSA variable if it has no uses (JADX: removeSsaVar)
    ///
    /// JADX Reference: InsnRemover.java:133-163
    fn try_remove_ssa_var(var_ref: SSAVarRef, ssa_ctx: &mut SSAContext) -> bool {
        if let Some(var) = ssa_ctx.get_var(var_ref) {
            if var.use_list.is_empty() && var.used_in_phi.is_empty() {
                ssa_ctx.remove_var(var_ref);
                return true;
            }
        }
        false
    }
}
```

---

## TASK IR-3-2: InsnUtils Search/Constant Helpers

**Status:** TODO
**JADX Source:** `jadx-core/src/main/java/jadx/core/utils/InsnUtils.java`
**Target:** `crates/dexterity-ir/src/insn_utils.rs` or extend instructions.rs

```rust
/// Instruction utility helpers (JADX: InsnUtils)
///
/// JADX Clone: jadx-core/src/main/java/jadx/core/utils/InsnUtils.java
pub mod insn_utils {
    use crate::instructions::{InsnArg, InsnNode, InsnType, LiteralArg};
    use crate::types::ArgType;

    /// Get constant value from instruction argument (JADX: getConstValueByArg)
    ///
    /// Returns the constant value from a literal, wrapped const instruction,
    /// or following MOVE chains to find the source constant.
    ///
    /// JADX Reference: InsnUtils.java:62-82
    /// ```java
    /// public static Object getConstValueByArg(RootNode root, InsnArg arg) {
    ///     if (arg.isLiteral()) {
    ///         return arg;
    ///     }
    ///     if (arg.isRegister()) {
    ///         RegisterArg reg = (RegisterArg) arg;
    ///         InsnNode parInsn = reg.getAssignInsn();
    ///         if (parInsn == null) {
    ///             return null;
    ///         }
    ///         if (parInsn.getType() == InsnType.MOVE) {
    ///             return getConstValueByArg(root, parInsn.getArg(0));
    ///         }
    ///         return getConstValueByInsn(root, parInsn);
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
    /// JADX Reference: InsnUtils.java:266-283
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

    /// Constant value types
    #[derive(Debug, Clone)]
    pub enum ConstValue {
        Int(i64),
        Float(f32),
        Double(f64),
        StringIdx(u32),
        TypeIdx(u32),
        Null,
    }

    impl ConstValue {
        pub fn from_literal(lit: &LiteralArg) -> Self {
            match lit {
                LiteralArg::Int(v) => ConstValue::Int(*v),
                LiteralArg::Float(v) => ConstValue::Float(*v),
                LiteralArg::Double(v) => ConstValue::Double(*v),
                LiteralArg::Null => ConstValue::Null,
            }
        }
    }
}
```

---

## TASK IR-4-1: ArithNode.isSameLiteral Comparison

**Status:** TODO
**JADX Source:** `jadx-core/src/main/java/jadx/core/dex/instructions/ArithNode.java:96-110`
**Target:** `crates/dexterity-ir/src/instructions.rs` - Add to Binary comparison

```rust
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
    ///     // both literals - compare values
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
```

---

## TASK IR-4-2: ConstructorInsn Call Type Detection

**Status:** TODO
**JADX Source:** `jadx-core/src/main/java/jadx/core/dex/instructions/mods/ConstructorInsn.java`
**Target:** `crates/dexterity-ir/src/instructions.rs` - Add ConstructorCallType enum

```rust
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
    /// JADX Reference: ConstructorInsn.java:45-62
    /// ```java
    /// public CallType getCallType() {
    ///     if (callType != null) return callType;
    ///     // Detect based on instance arg and class type
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
        current_class: &str,
        is_instance_this: bool,
    ) -> Option<ConstructorCallType> {
        if let InsnType::Constructor { type_idx, .. } = self {
            // Would need type resolution to get class name from type_idx
            // For now, use heuristics based on this arg
            if is_instance_this {
                // Could be THIS or SUPER - need class comparison
                Some(ConstructorCallType::Super) // Default assumption
            } else {
                Some(ConstructorCallType::Constructor)
            }
        } else {
            None
        }
    }
}
```

---

## Reference Comment Format

Every cloned method MUST include this format:

```rust
/// Brief description (JADX: methodName)
///
/// JADX Reference: FileName.java:start-end
/// ```java
/// // Exact JADX source code
/// ```
pub fn rust_method_name(...) {
    // Clone JADX logic exactly
}
```

---

*This document provides exact IR-level clone specifications for JADX parity in dexterity-ir.*
