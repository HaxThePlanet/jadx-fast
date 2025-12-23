# JADX IR Parity Gap Analysis

**Date:** 2025-12-23
**Status:** Initial comprehensive analysis against JADX source code
**JADX Source:** `/mnt/nvme4tb/dexterity/jadx-fast/jadx-core/src/main/java/jadx/core/dex/`

## Executive Summary

Dexterity-IR has **~8,900 lines** of IR implementation with solid foundations:
- ✅ Core IR structures (InsnNode, BlockNode, MethodNode, ClassNode)
- ✅ SSA infrastructure (SSAVar, PhiInsn)
- ✅ Region system (if, loop, switch, try-catch)
- ✅ Dominator analysis support
- ✅ 128-bit attribute flags (69+ defined)
- ✅ Kotlin metadata support
- ✅ Lambda/method reference support

However, JADX has **10 years of development** with edge case handling and methods we're missing.

---

## 1. InsnNode Gap Analysis

**JADX:** `/jadx-fast/jadx-core/src/main/java/jadx/core/dex/nodes/InsnNode.java` (620 lines)

### ✅ Methods We Have
- `get_type()`, `get_result()`, `set_result()`
- `get_args_count()`, `get_arg()`, `set_arg()`, `add_arg()`
- `is_const_insn()`, `is_exit_edge_insn()`
- `can_reorder()`, `can_throw_exception()`
- `copy()`, `copy_without_result()`
- `replace_arg()`, `remove_arg()`
- `visit_insns()` (Consumer variant)
- `is_same()` (basic version)

### ❌ Missing JADX Methods

#### Visitor Pattern Enhancements
```rust
// JADX: InsnNode.java:300-363
// TODO: Add Function-based visitors with early termination
pub fn visit_insns<R, F>(&self, visitor: F) -> Option<R>
    where F: FnMut(&InsnNode) -> Option<R>

pub fn visit_args<R, F>(&self, visitor: F) -> Option<R>
    where F: FnMut(&InsnArg) -> Option<R>
```

#### Copy Variants
```rust
// JADX: InsnNode.java:454-487
// TODO: Add specialized copy methods
pub fn copy_without_ssa(&self) -> InsnNode
pub fn copy_with_new_ssa_var(&mut self, method: &MethodNode) -> InsnNode
pub fn copy_common_params<T: InsnNode>(&self, copy: T) -> T
```

#### SSA Rebinding
```rust
// JADX: InsnNode.java:489-512
// TODO: Fix SSA after altering instructions
pub fn rebind_args(&mut self)
```

#### Metadata Inheritance
```rust
// JADX: InsnNode.java:535-548
// TODO: Copy metadata from source instruction
pub fn inherit_metadata(&mut self, source_insn: &InsnNode)
```

#### Argument Analysis
```rust
// JADX: InsnNode.java:198-206
// TODO: Collect all RegisterArgs recursively
pub fn get_register_args(&self, collection: &mut Vec<RegisterArg>)

// JADX: InsnNode.java:122-127
// TODO: Deep variable search
pub fn contains_var(&self, reg: &RegisterArg) -> bool

// JADX: InsnNode.java:110-120
// TODO: Direct argument containment
pub fn contains_arg(&self, arg: &InsnArg) -> bool

// JADX: InsnNode.java:164-172
// TODO: Get argument index
pub fn get_arg_index(&self, arg: &InsnArg) -> Option<usize>
```

#### Deep Equality
```rust
// JADX: InsnNode.java:397-407
// TODO: Hard equals comparing all arguments
pub fn is_deep_equals(&self, other: &InsnNode) -> bool
```

#### Result Removal
```rust
// JADX: InsnNode.java:233-242
// TODO: Check if result can be removed (INVOKE, CONSTRUCTOR)
pub fn can_remove_result(&self) -> bool
```

#### Wrapped Instruction Check
```rust
// JADX: InsnNode.java:288-295
// TODO: Check if contains wrapped instructions
pub fn contains_wrapped_insn(&self) -> bool
```

---

## 2. BlockNode Gap Analysis

**JADX:** `/jadx-fast/jadx-core/src/main/java/jadx/core/dex/nodes/BlockNode.java` (283 lines)

### ✅ What We Have
- Basic fields: cid, pos, startOffset
- CFG: predecessors, successors, cleanSuccessors
- Dominators: doms, postDoms, domFrontier, idom, iPostDom
- dominatesOn list

### ❌ Missing JADX Methods

#### Lock Mechanism
```rust
// JADX: BlockNode.java:122-135
// TODO: Freeze block after analysis to prevent mutations
pub fn lock(&mut self) {
    // Convert lists to immutable locked lists
    // Validate domFrontier is set
    // Throw error if validation fails
}
```

#### Position Update
```rust
// JADX: BlockNode.java:115-120
// TODO: Batch update block positions
pub fn update_block_positions(blocks: &mut Vec<BlockNode>)
```

#### Clean Successors Logic
```rust
// JADX: BlockNode.java:111-163
// TODO: Update cleanSuccessors filtering exception handlers and loop back edges
pub fn update_clean_successors(&mut self)

// Private helper
fn clean_successors(block: &BlockNode) -> Vec<BlockNode> {
    // Filter out exception handler paths
    // Filter out loop back edges
}
```

#### Dominator Query
```rust
// JADX: BlockNode.java:177-179
// TODO: Check if block is dominator of this
pub fn is_dominator(&self, block: &BlockNode) -> bool {
    self.doms.get(block.pos)
}
```

#### State Queries
```rust
// JADX: BlockNode.java:235-249
// TODO: Add state check methods
pub fn is_synthetic(&self) -> bool
pub fn is_return_block(&self) -> bool
pub fn is_mth_exit_block(&self) -> bool
pub fn is_empty(&self) -> bool
```

---

## 3. SSAVar Gap Analysis

**JADX:** `/jadx-fast/jadx-core/src/main/java/jadx/core/dex/instructions/args/SSAVar.java` (344 lines)

### ✅ What We Have
- Basic fields: regNum, version
- assign, useList
- TypeInfo integration

### ❌ Missing JADX Features

#### PHI Tracking
```rust
// JADX: SSAVar.java:39, 142-202
// TODO: Track PHI usage separately
used_in_phi: Option<Vec<PhiInsn>>,

pub fn add_used_in_phi(&mut self, phi: PhiInsn)
pub fn remove_used_in_phi(&mut self, phi: &PhiInsn)
pub fn update_used_in_phi_list(&mut self)
pub fn get_only_one_use_in_phi(&self) -> Option<&PhiInsn>
pub fn get_used_in_phi(&self) -> &[PhiInsn]
pub fn get_phi_list(&self) -> Vec<PhiInsn>  // Concat assign PHI + usedInPhi
pub fn is_assign_in_phi(&self) -> bool
pub fn is_used_in_phi(&self) -> bool
```

#### CodeVar Integration
```rust
// JADX: SSAVar.java:44, 222-260
// TODO: Link to high-level CodeVar after InitCodeVariables pass
code_var: Option<CodeVar>,

pub fn get_code_var(&self) -> &CodeVar
pub fn set_code_var(&mut self, code_var: CodeVar)
pub fn is_code_var_set(&self) -> bool
pub fn reset_type_and_code_var(&mut self)
```

#### Name Management via CodeVar
```rust
// JADX: SSAVar.java:213-227
// TODO: Name delegation to CodeVar
pub fn set_name(&mut self, name: String)
pub fn get_name(&self) -> Option<&str>
```

#### Immutable Type Support
```rust
// JADX: SSAVar.java:88-109
// TODO: Immutable type marking
pub fn get_immutable_type(&self) -> Option<ArgType>
pub fn is_type_immutable(&self) -> bool
pub fn mark_as_immutable(&mut self, arg_type: ArgType)
```

#### Type Setting
```rust
// JADX: SSAVar.java:111-128
// TODO: Type update with immutability check
pub fn set_type(&mut self, arg_type: ArgType)  // Throws if immutable
pub fn force_set_type(&mut self, arg_type: ArgType)  // Ignores immutability
```

#### Use Management
```rust
// JADX: SSAVar.java:130-140
// TODO: SSA use-def chain management
pub fn use_arg(&mut self, arg: &mut RegisterArg)
pub fn remove_use(&mut self, arg: &RegisterArg)
```

#### Debug Info
```rust
// JADX: SSAVar.java:262-309
// TODO: Detailed variable info for debugging
pub fn get_detailed_var_info(&self, mth: &MethodNode) -> String
pub fn to_short_string(&self) -> String
```

---

## 4. PhiInsn Gap Analysis

**JADX:** `/jadx-fast/jadx-core/src/main/java/jadx/core/dex/instructions/PhiInsn.java` (142 lines)

### ✅ What We Have
- Basic PhiInsn structure
- Phi in InsnType enum

### ❌ Missing JADX Features

#### Block Binding
```rust
// JADX: PhiInsn.java:22, 36-51
// TODO: Map arguments to predecessor blocks (same order as args)
block_binds: Vec<BlockId>,

pub fn bind_arg(&mut self, pred: BlockId) -> RegisterArg
pub fn bind_arg_with_reg(&mut self, arg: RegisterArg, pred: BlockId)
```

#### Block Queries
```rust
// JADX: PhiInsn.java:53-64
// TODO: Get block by argument
pub fn get_block_by_arg(&self, arg: &RegisterArg) -> Option<BlockId>
pub fn get_block_by_arg_index(&self, index: usize) -> BlockId
```

#### Argument Removal Override
```rust
// JADX: PhiInsn.java:73-88
// TODO: Override to also remove block binding and update SSAVar
pub fn remove_arg(&mut self, index: usize) -> RegisterArg {
    let reg = super::remove_arg(index);
    self.block_binds.remove(index);
    reg.get_svar().update_used_in_phi_list();
    reg
}
```

#### SSAVar Lookup
```rust
// JADX: PhiInsn.java:90-102
// TODO: Find argument by SSAVar
pub fn get_arg_by_ssa_var(&self, ssa_var: &SSAVar) -> Option<&RegisterArg>
```

#### Argument Replacement Override
```rust
// JADX: PhiInsn.java:104-120
// TODO: PHI-specific replaceArg handling
pub fn replace_arg(&mut self, from: InsnArg, to: InsnArg) -> bool {
    // Add to usedInPhi
    // Update SSAVar lists
}
```

#### Prevent Direct Arg Manipulation
```rust
// JADX: PhiInsn.java:122-130
// TODO: Throw error for direct addArg/setArg
pub fn add_arg(&mut self, arg: InsnArg) {
    panic!("Direct addArg forbidden for PHI, use bind_arg");
}

pub fn set_arg(&mut self, n: usize, arg: InsnArg) {
    panic!("Direct setArg forbidden for PHI, use bind_arg");
}
```

---

## 5. AFlag Enum Gap Analysis

**JADX:** `/jadx-fast/jadx-core/src/main/java/jadx/core/dex/attributes/AFlag.java` (109 flags)
**Dexterity:** `crates/dexterity-ir/src/attributes.rs` (69 flags)

### ❌ Missing 40 Flags

```rust
// Control flow
ORIG_RETURN,              // Original return before transformation
DISABLE_BLOCKS_LOCK,      // Allow block mutation after lock

// Inlining control
DONT_WRAP,                // Don't wrap in parentheses
DONT_INLINE_CONST,        // Don't inline this constant
COMMENT_OUT,              // Comment out in codegen instead of removing

// Naming
DONT_RENAME,              // Skip during deobfuscation
FORCE_RAW_NAME,           // Use raw name instead of alias

// Exception handling
IGNORE_THROW_SPLIT,       // Don't split on throw

// Arguments
NO_SKIP_ARGS,             // Don't skip any arguments
INLINE_INSTANCE_FIELD,    // Inline field initialization

// Special markers
PACKAGE_INFO,             // package-info.java class
ANDROID_R_CLASS,          // Android R class marker

// Variables
CUSTOM_DECLARE,           // Variable doesn't need declaration
DECLARE_VAR,              // Force variable declaration

// Regions
ELSE_IF_CHAIN,            // Part of else-if chain
REQUEST_IF_REGION_OPTIMIZE,  // Run if region visitor again
REQUEST_CODE_SHRINK,      // Request code shrinking

// Method processing
METHOD_CANDIDATE_FOR_INLINE,  // Mark as inline candidate
USE_LINES_HINTS,          // Trust source line info

// Class processing
RESTART_CODEGEN,          // Must run codegen again
RELOAD_AT_CODEGEN_STAGE,  // Unload before codegen
CLASS_DEEP_RELOAD,        // Deep unload/reload
CLASS_UNLOADED,           // Class was unloaded
DONT_UNLOAD_CLASS,        // Don't unload (debug only)

// Special bytecode
RESOLVE_JAVA_JSR,         // Resolve JSR/RET instructions
COMPUTE_POST_DOM,         // Compute post-dominators

// Casting
SOFT_CAST,                // Synthetic cast for type inference

// Calls
VARARG_CALL,              // Variable argument call

// Code warnings
INCONSISTENT_CODE,        // Decompilation issue warning

// Other
HIDDEN,                   // Used inside other insn but not in args
REMOVE_SUPER_CLASS,       // Don't add super class
ADDED_TO_REGION,          // Already added to region
```

---

## 6. AType Enum Gap Analysis

**JADX:** `/jadx-fast/jadx-core/src/main/java/jadx/core/dex/attributes/AType.java` (107 lines)

### ❌ Missing Attribute Types

Dexterity doesn't have a full AType enum. We need:

```rust
pub enum AType {
    // Comments and errors
    CodeComments,
    JadxError,
    JadxComments,
    RenameReason,

    // Class attributes
    EnumClass,
    EnumMap,
    ClassTypeVars,
    AnonymousClass,
    Inlined,

    // Field attributes
    FieldInitInsn,
    FieldReplace,

    // Method attributes
    LocalVarsDebugInfo,
    MethodInline,
    MethodReplace,
    BridgedBy,
    SkipMthArgs,
    MethodOverride,
    MethodTypeVars,
    TryBlocksList,
    MethodCodeFeatures,
    MethodThrows,

    // Region attributes
    DeclareVariables,

    // Block attributes
    PhiList,
    ForceReturn,
    Loop,
    EdgeInsn,
    SpecialEdge,
    TmpEdge,
    TryBlock,

    // Block or instruction
    ExcHandler,
    ExcCatch,

    // Instruction attributes
    LoopLabel,
    Jump,
    MethodDetails,
    GenericInfo,
    RegionRef,

    // Register attributes
    RegDebugInfo,
}
```

---

## 7. MethodNode Gap Analysis

**JADX:** `/jadx-fast/jadx-core/src/main/java/jadx/core/dex/nodes/MethodNode.java` (760+ lines)

### ✅ What We Have
- Basic method info structure
- Load/unload mechanism

### ❌ Missing JADX Features

#### Load/Unload with State
```rust
// JADX: MethodNode.java:114-186
// TODO: Comprehensive load/unload
pub fn load(&mut self) -> Result<(), DecodeException>
pub fn unload(&mut self)
pub fn reload(&mut self)
```

#### SSA Variable Management
```rust
// JADX: MethodNode.java:79
// TODO: List of SSA variables
s_vars: Vec<SSAVar>,

pub fn make_new_svar(&mut self, arg: &mut RegisterArg) -> SSAVar
```

#### Argument Initialization
```rust
// JADX: MethodNode.java:188-230
// TODO: Initialize method arguments with AFlag markers
fn init_arguments(&mut self, args: &[ArgType])
fn get_args_start_pos(&self, args: &[ArgType]) -> usize
```

#### Type Updates
```rust
// JADX: MethodNode.java:131-138, 241-259
// TODO: Update types after generic resolution
pub fn update_types(&mut self, arg_types: Vec<ArgType>, ret_type: ArgType)
pub fn update_type_parameters(&mut self, type_params: Vec<ArgType>)
pub fn update_return_type(&mut self, ret_type: ArgType)
pub fn update_arg_types(&mut self, new_arg_types: Vec<ArgType>, comment: &str)
pub fn contains_generic_args(&self) -> bool
```

#### Block Management
```rust
// JADX: MethodNode.java:75-78
// TODO: Enter/exit blocks
enter_block: Option<BlockId>,
exit_block: Option<BlockId>,
blocks_max_cid: u32,
```

---

## 8. Region System Gap Analysis

### ✅ What We Have
- Basic Region enum with main types
- LoopType variants

### ❌ Potential Missing Features

Need to verify against JADX region classes:
- `/jadx-fast/jadx-core/src/main/java/jadx/core/dex/regions/Region.java`
- `/jadx-fast/jadx-core/src/main/java/jadx/core/dex/regions/conditions/IfRegion.java`
- `/jadx-fast/jadx-core/src/main/java/jadx/core/dex/regions/loops/LoopRegion.java`
- `/jadx-fast/jadx-core/src/main/java/jadx/core/dex/regions/SwitchRegion.java`
- `/jadx-fast/jadx-core/src/main/java/jadx/core/dex/regions/TryCatchRegion.java`
- `/jadx-fast/jadx-core/src/main/java/jadx/core/dex/regions/SynchronizedRegion.java`

---

## 9. Priority Ranking

### P0 - Critical for Parity (Do First)
1. **PhiInsn block_binds** - Essential for SSA
2. **SSAVar PHI tracking** (usedInPhi methods)
3. **SSAVar CodeVar integration**
4. **AFlag missing 40 flags** - Needed by passes
5. **InsnNode rebind_args()** - SSA correctness

### P1 - High Impact (Do Second)
6. **InsnNode visitor enhancements** (Function variants)
7. **BlockNode lock()** mechanism
8. **SSAVar immutable type support**
9. **InsnNode copy variants** (copy_with_new_ssa_var, etc.)
10. **MethodNode SSA variable management**

### P2 - Medium Impact (Do Third)
11. **AType enum** - Full attribute type system
12. **InsnNode contains_var/contains_arg**
13. **BlockNode state queries**
14. **SSAVar detailed debug info**
15. **MethodNode type updates**

### P3 - Nice to Have (Do Later)
16. **InsnNode is_deep_equals**
17. **BlockNode update_clean_successors logic**
18. **Region system verification**
19. **MethodNode load/unload enhancements**

---

## 10. Approach

**DO NOT REWRITE** - We must **clone JADX functionality**:

1. ✅ **Copy method signatures exactly** - Match JADX API
2. ✅ **Copy logic patterns** - Use JADX algorithms
3. ✅ **Add JADX reference comments** - Track what we cloned
4. ✅ **Preserve edge case handling** - JADX's 10 years of fixes
5. ✅ **Match behavior precisely** - Same inputs → same outputs

Example reference comment format:
```rust
// Copied from JADX: jadx-core/src/main/java/jadx/core/dex/nodes/InsnNode.java:300-329
// visitInsns with early termination support
pub fn visit_insns<R, F>(&self, visitor: F) -> Option<R>
    where F: FnMut(&InsnNode) -> Option<R>
{
    // ... exact JADX logic in Rust ...
}
```

---

## 11. Conclusion

**Current Status:** ~75% IR parity
**Missing:** ~25% of JADX's IR infrastructure
**Effort:** ~2,000-3,000 lines to add

**Key Gaps:**
- SSA PHI tracking integration
- CodeVar high-level variable system
- 40 missing attribute flags
- Enhanced visitor patterns
- SSA rebinding after mutations
- Lock mechanism for frozen blocks

**Next Steps:** Execute cloning tasks in priority order (P0 → P1 → P2 → P3)
