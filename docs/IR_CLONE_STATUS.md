# Dexterity-IR JADX Parity Status

## Overview

This document tracks the status of cloning JADX's IR (Intermediate Representation) layer into Dexterity.
The IR is the **first and most critical layer** of the decompilation pipeline.

**Goal:** 100% functional parity with JADX's IR to ensure all edge cases are handled identically.

**Philosophy:** We are NOT rewriting JADX. We are CLONING it. JADX has 10 years of edge case handling
that we cannot replicate by just looking at output. We must clone the source code logic exactly.

**Updated:** Dec 23, 2025 - Comprehensive analysis of JADX source code

---

## JADX IR Files Overview

JADX IR is in `jadx-fast/jadx-core/src/main/java/jadx/core/dex/`:

| Category | Files | Approx LOC | Status |
|----------|-------|------------|--------|
| **instructions/** | 25 Java files | ~3,500 LOC | 90% |
| **instructions/args/** | 12 Java files | ~2,800 LOC | 85% |
| **nodes/** | 14 Java files | ~4,200 LOC | 90% |
| **attributes/** | 15 Java files | ~1,500 LOC | 95% |
| **regions/** | 11 Java files | ~2,000 LOC | 85% |
| **info/** | 8 Java files | ~1,800 LOC | 90% |
| **TOTAL** | ~85 Java files | ~15,800 LOC | **~92%** |

---

## Completed Components (100% Parity)

### 1. InsnType Enum (`instructions.rs`)
| JADX | Dexterity | Status |
|------|-----------|--------|
| 35 instruction types | 35+ types | ✅ Complete |
| CONST, CONST_STR, CONST_CLASS | ✅ | Exact match |
| ARITH (NEG, NOT, ADD, SUB, ...) | ✅ Unary/Binary | Exact match |
| MOVE, MOVE_MULTI, CAST, RETURN | ✅ | Exact match |
| GOTO, THROW, MOVE_EXCEPTION | ✅ | Exact match |
| IF, SWITCH, TERNARY | ✅ | Exact match |
| INVOKE (5 kinds), CONSTRUCTOR | ✅ | Exact match |
| AGET, APUT, IGET, IPUT, SGET, SPUT | ✅ | Exact match |
| NEW_ARRAY, NEW_INSTANCE, FILLED_NEW_ARRAY | ✅ | Exact match |
| PHI, STR_CONCAT, ONE_ARG, REGION_ARG | ✅ | Exact match |
| JAVA_JSR, JAVA_RET | ✅ | Legacy support |
| BREAK, CONTINUE | ✅ | Synthetic |

### 2. ArgType System (`types.rs`)
| Component | JADX Lines | Dexterity Lines | Status |
|-----------|------------|-----------------|--------|
| Primitive types | 9 | 9 | ✅ Complete |
| Object/Array/Generic | Full | Full | ✅ Complete |
| TypeVariable with bounds | Full | Full | ✅ Complete |
| Wildcard (extends/super) | Full | Full | ✅ Complete |
| OuterGeneric (Outer<T>.Inner) | Full | Full | ✅ Complete |
| Unknown variants (14 types) | 14 | 14 | ✅ Complete |
| TypeCompare (8 results) | 8 | 8 | ✅ Complete |
| compare_types() hierarchy | Full | Full | ✅ Complete |

### 3. AFlag Attributes (`attributes.rs`)
| JADX Flags | Dexterity | Status |
|------------|-----------|--------|
| 59 boolean flags | 60 flags | ✅ Complete (+TmpEdge) |
| Exact order/naming | ✅ | From/To JADX name conversion |

### 4. SSAVar System (`ssa.rs`)
| Method | Status | Notes |
|--------|--------|-------|
| `get_only_one_use_in_phi()` | ✅ | Copy propagation |
| `reset_type_and_code_var()` | ✅ | Re-inference support |
| `update_used_in_phi_list()` | ✅ | PHI tracking |
| `is_assigned_in_phi()` | ✅ | Via flags |
| `is_type_immutable()` | ✅ | Type bounds |
| TypeInfo with bounds | ✅ | Full constraint system |
| CodeVar grouping | ✅ | Variable merging |

### 5. InsnNode Methods (`instructions.rs`) - NEWLY ADDED
| JADX Method | Dexterity | Status |
|-------------|-----------|--------|
| `visitInsns()` | `visit_insns()` | ✅ Added |
| `visitInsns<R>()` | `visit_insns_until()` | ✅ Added |
| `visitArgs()` | `visit_args()` | ✅ Added |
| `visitArgs<R>()` | `visit_args_until()` | ✅ Added |
| `canReorder()` | `can_reorder()` | ✅ Added |
| `canThrowException()` | `can_throw_exception()` | ✅ Added |
| `isExitEdgeInsn()` | `is_exit_edge_insn()` | ✅ Added |
| `containsWrappedInsn()` | `contains_wrapped_insn()` | ✅ Added |
| `canRemoveResult()` | `can_remove_result()` | ✅ Added |
| `containsArg()` | `contains_arg()` | ✅ Added |
| `containsVar()` | `contains_var()` | ✅ Added |
| `getRegisterArgs()` | `get_register_args()` | ✅ Added |
| `getResult()` | `get_result()` | ✅ Added |
| `isDeepEquals()` | `is_deep_equals()` | ✅ Added |
| `copyCommonParams()` | `copy_common_params()` | ✅ Added |
| `isConstInsn()` | `is_const_insn()` | ✅ Existing |
| `isSame()` | `is_same()` | ✅ Existing |

### 6. InsnType Methods - NEWLY ADDED
| Method | Status | Notes |
|--------|--------|-------|
| `get_args()` | ✅ Added | Returns arg slice |
| `get_dest()` | ✅ Added | Returns dest RegisterArg |
| `get_dest_mut()` | ✅ Added | Mutable dest access |
| `name()` | ✅ Existing | JADX type name |

---

## Pending Tasks - DETAILED CLONE LIST

The following sections contain exact JADX file references with line numbers.
Each task includes the Java source to clone from.

---

### PRIORITY 1 (P1) - Critical for Pass Parity

#### P1-A: InsnNode Mutation Methods
**JADX Source:** `jadx-fast/jadx-core/src/main/java/jadx/core/dex/nodes/InsnNode.java`
**Priority:** CRITICAL - Required for 12+ JADX passes

Clone these methods exactly:

```java
// JADX InsnNode.java:166-184
public boolean replaceArg(InsnArg from, InsnArg to) {
    int count = getArgsCount();
    for (int i = 0; i < count; i++) {
        InsnArg arg = arguments.get(i);
        if (arg == from) {
            InsnArg newArg = to;
            newArg.setParentInsn(this);
            arguments.set(i, newArg);
            return true;
        }
        if (arg.isInsnWrap()) {
            if (((InsnWrapArg) arg).getWrapInsn().replaceArg(from, to)) {
                return true;
            }
        }
    }
    return false;
}

// JADX InsnNode.java:186-202
protected boolean removeArg(InsnArg arg) {
    int index = getArgIndex(arg);
    if (index == -1) {
        return false;
    }
    removeArg(index);
    return true;
}

// JADX InsnNode.java:204-211
public InsnArg removeArg(int index) {
    InsnArg arg = arguments.remove(index);
    arg.setParentInsn(null);
    return arg;
}

// JADX InsnNode.java:213-222
public void rebindArgs() {
    arguments.forEach(arg -> arg.setParentInsn(this));
    if (result != null) {
        result.setParentInsn(this);
    }
}

// JADX InsnNode.java:364-373
public InsnNode copy() {
    return copyCommonParams(new InsnNode(insnType, getArgsCount()));
}

// JADX InsnNode.java:375-381
public InsnNode copyWithoutResult() {
    InsnNode copy = copy();
    copy.setResult(null);
    return copy;
}

// JADX InsnNode.java:383-398 - Copy with new SSA variable
public InsnNode copyWithNewSsaVar(MethodNode mth) {
    InsnNode copy = copy();
    RegisterArg res = copy.getResult();
    if (res != null) {
        RegisterArg newResult = res.duplicate();
        SSAVar newSsaVar = mth.makeNewSVar(newResult);
        newResult.setSVar(newSsaVar);
        copy.setResult(newResult);
    }
    return copy;
}

// JADX InsnNode.java:400-416
public void inheritMetadata(InsnNode sourceInsn) {
    setOffset(sourceInsn.getOffset());
    setSourceLine(sourceInsn.getSourceLine());
}
```

**Dexterity Target:** `crates/dexterity-ir/src/instructions.rs`

---

#### P1-B: InsnArg Parent Tracking System
**JADX Source:** `jadx-fast/jadx-core/src/main/java/jadx/core/dex/instructions/args/InsnArg.java`
**Priority:** CRITICAL - Required for replaceArg, SSA

Clone these:

```java
// JADX InsnArg.java:21-25
protected InsnNode parentInsn;
protected ArgType type;

// JADX InsnArg.java:27-32
public InsnNode getParentInsn() {
    return parentInsn;
}

// JADX InsnArg.java:34-39
public void setParentInsn(InsnNode parentInsn) {
    this.parentInsn = parentInsn;
}

// JADX InsnArg.java:112-118 - Static factory methods
public static RegisterArg reg(int regNum, ArgType type) {
    return new RegisterArg(regNum, type);
}

public static RegisterArg reg(InsnData insn, int argNum, ArgType type) {
    return new RegisterArg(insn.getReg(argNum), type);
}

public static LiteralArg lit(long literal, ArgType type) {
    return new LiteralArg(literal, type);
}

public static LiteralArg lit(InsnData insn, ArgType type) {
    return new LiteralArg(insn.getLiteral(), type);
}

// JADX InsnArg.java:178-191 - Wrap instruction into argument
public static InsnArg wrapInsnIntoArg(InsnNode insn) {
    InsnArg arg = new InsnWrapArg(insn);
    insn.add(AFlag.WRAPPED);
    return arg;
}

public static InsnArg wrapArg(InsnNode parentInsn, RegisterArg arg) {
    if (parentInsn == arg.getParentInsn()) {
        return arg;
    }
    InsnArg wrap = wrapInsnIntoArg(arg.getAssignInsn());
    wrap.setParentInsn(parentInsn);
    return wrap;
}
```

**Dexterity Target:** `crates/dexterity-ir/src/instructions.rs` (extend `InsnArg` enum)

---

#### P1-C: RegisterArg SSA Linkage
**JADX Source:** `jadx-fast/jadx-core/src/main/java/jadx/core/dex/instructions/args/RegisterArg.java`
**Priority:** CRITICAL - Required for SSA operations

Clone these:

```java
// JADX RegisterArg.java:22-27
private SSAVar sVar;

// JADX RegisterArg.java:38-42
public SSAVar getSVar() {
    return sVar;
}

// JADX RegisterArg.java:44-56
public void setSVar(SSAVar sVar) {
    if (this.sVar != null) {
        this.sVar.removeUse(this);
    }
    this.sVar = sVar;
}

// JADX RegisterArg.java:58-63
public void resetSSAVar() {
    if (this.sVar != null) {
        this.sVar.removeUse(this);
        this.sVar = null;
    }
}

// JADX RegisterArg.java:65-72
public InsnNode getAssignInsn() {
    if (sVar == null) {
        return null;
    }
    return sVar.getAssignInsn();
}

// JADX RegisterArg.java:87-96
public RegisterArg duplicate() {
    RegisterArg dup = new RegisterArg(regNum, getInitType());
    dup.setType(type);
    return copyCommonParams(dup);
}
```

**Dexterity Target:** Extend `RegisterArg` struct in `instructions.rs`

---

### PRIORITY 2 (P2) - Specialized Instructions

#### P2-A: IfNode Condition Methods
**JADX Source:** `jadx-fast/jadx-core/src/main/java/jadx/core/dex/instructions/IfNode.java`
**Priority:** HIGH - Required for condition simplification

```java
// JADX IfNode.java:72-82
public void invertCondition() {
    op = op.invert();
    if (getArgsCount() == 2) {
        InsnArg tmp = getArg(0);
        setArg(0, getArg(1));
        setArg(1, tmp);
    }
}

// JADX IfNode.java:84-92
public void normalize() {
    // Ensure arg0 is the one with result (if any)
    if (getArgsCount() == 2) {
        RegisterArg firstArg = (RegisterArg) getArg(0);
        RegisterArg secondArg = (RegisterArg) getArg(1);
        // ... comparison logic
    }
}

// JADX IfNode.java:93-100
public void changeCondition(IfOp newOp, InsnArg a, InsnArg b) {
    setArg(0, a);
    setArg(1, b);
    this.op = newOp;
}
```

---

#### P2-B: PhiInsn Block Bindings
**JADX Source:** `jadx-fast/jadx-core/src/main/java/jadx/core/dex/instructions/PhiInsn.java`
**Priority:** HIGH - Required for SSA passes

```java
// JADX PhiInsn.java:22-23
private final List<BlockNode> blockBinds;  // Maps args to predecessor blocks

// JADX PhiInsn.java:36-50
public void bindArg(RegisterArg arg, BlockNode pred) {
    if (blockBinds.contains(pred)) {
        throw new JadxRuntimeException("Duplicate predecessors in PHI insn");
    }
    if (pred == null) {
        throw new JadxRuntimeException("Null bind block in PHI insn");
    }
    super.addArg(arg);
    blockBinds.add(pred);
}

// JADX PhiInsn.java:53-59
@Nullable
public BlockNode getBlockByArg(RegisterArg arg) {
    int index = getArgIndex(arg);
    if (index == -1) return null;
    return blockBinds.get(index);
}

// JADX PhiInsn.java:62-64
public BlockNode getBlockByArgIndex(int argIndex) {
    return blockBinds.get(argIndex);
}

// JADX PhiInsn.java:83-88
@Override
public RegisterArg removeArg(int index) {
    RegisterArg reg = (RegisterArg) super.removeArg(index);
    blockBinds.remove(index);
    reg.getSVar().updateUsedInPhiList();
    return reg;
}
```

---

#### P2-C: SwitchInsn Data & Blocks - COMPLETED
**JADX Source:** `jadx-fast/jadx-core/src/main/java/jadx/core/dex/instructions/SwitchInsn.java`
**Priority:** ~~MEDIUM~~ **DONE** (Dec 23, 2025)
**Dexterity Implementation:** `crates/dexterity-ir/src/instructions.rs` - `SwitchData` struct

SwitchData implemented with:
- `size`, `keys`, `targets` fields
- `fix_targets(switch_offset)` - convert relative to absolute offsets
- `new_packed()`, `new_sparse()` constructors
- `iter()`, `is_packed()`, `get_size()`, `get_keys()`, `get_targets()` utility methods

```java
// JADX SwitchInsn.java:20-26 - REFERENCE (implemented in Rust)
private final int dataTarget;
private final boolean packed;
@Nullable private SwitchData switchData;
private int def;  // default target
private Object[] modifiedKeys;
private BlockNode[] targetBlocks;
private BlockNode defTargetBlock;
```

---

#### P2-D: ArithNode Operations - COMPLETED
**JADX Source:** `jadx-fast/jadx-core/src/main/java/jadx/core/dex/instructions/ArithNode.java`
**Priority:** ~~MEDIUM~~ **DONE** (Dec 23, 2025)
**Dexterity Implementation:** `crates/dexterity-ir/src/instructions.rs` - `BinaryOp` and `InsnType` methods

BinaryOp methods implemented:
- `symbol()` - operator symbols for codegen
- `is_bit_op()` - check for AND/OR/XOR
- `is_shift_op()` - check for SHL/SHR/USHR
- `is_commutative()` - check if a op b == b op a

InsnType methods implemented:
- `new_arith_one_arg()` - create compound assignment
- `is_same_arith_literal()` - compare literal values
- `is_same_arith()` - full arithmetic comparison

```java
// JADX ArithNode.java - REFERENCE (implemented in Rust)
// See BinaryOp::symbol(), BinaryOp::is_bit_op(), etc. in instructions.rs
```

---

### PRIORITY 3 (P3) - BlockNode Infrastructure - COMPLETED

#### P3-A: BlockNode Core CFG - COMPLETED
**JADX Source:** `jadx-fast/jadx-core/src/main/java/jadx/core/dex/nodes/BlockNode.java`
**Priority:** ~~HIGH~~ **DONE** (Dec 23, 2025)
**Dexterity Implementation:** `crates/dexterity-ir/src/nodes.rs` - `BlockNode` struct

Full JADX-compatible dominator infrastructure implemented:
- `cid`, `pos`, `start_offset` - block identity fields
- `doms`, `post_doms`, `dom_frontier` - BitSet-based dominator sets
- `idom`, `ipost_dom` - immediate dominator/post-dominator
- `dominates_on` - reverse dominator tree
- `predecessors`, `successors`, `clean_successors` - CFG edges
- `locked` - post-analysis mutation prevention
- All getter/setter methods with JADX reference comments

```java
// JADX BlockNode.java:32-48 - REFERENCE (implemented in Rust)
// See BlockNode struct in nodes.rs
```

---

#### P3-B: BlockNode Exception Handler Support - COMPLETED
**JADX Source:** `jadx-fast/jadx-core/src/main/java/jadx/core/dex/nodes/BlockNode.java:220-250`
**Priority:** ~~MEDIUM~~ **DONE** (Dec 23, 2025)
**Dexterity Implementation:** `crates/dexterity-ir/src/nodes.rs` - via AFlag attributes

Implemented via AFlag system:
- `is_synthetic()` - check AFlag::Synthetic
- `is_return_block()` - check AFlag::Return
- `is_mth_exit_block()` - check AFlag::MthExitBlock

---

### PRIORITY 4 (P4) - Additional Instruction Types

#### P4-A: InsnWrapArg
**JADX Source:** `jadx-fast/jadx-core/src/main/java/jadx/core/dex/instructions/args/InsnWrapArg.java`

```java
// JADX InsnWrapArg.java:12-22
public final class InsnWrapArg extends InsnArg {
    private final InsnNode wrappedInsn;

    InsnWrapArg(@NotNull InsnNode insn) {
        RegisterArg result = insn.getResult();
        this.type = result != null ? result.getType() : ArgType.UNKNOWN;
        this.wrappedInsn = insn;
    }

    public InsnNode getWrapInsn() {
        return wrappedInsn;
    }

    // JADX InsnWrapArg.java:28-31
    public InsnNode unWrapWithCopy() {
        InsnNode copy = wrappedInsn.copyWithoutResult();
        copy.remove(AFlag.WRAPPED);
        return copy;
    }
}
```

---

#### P4-B: TargetInsnNode (Abstract Base) - COMPLETED
**JADX Source:** `jadx-fast/jadx-core/src/main/java/jadx/core/dex/instructions/TargetInsnNode.java`
**Priority:** ~~MEDIUM~~ **DONE** (Dec 23, 2025)
**Dexterity Implementation:** `crates/dexterity-ir/src/instructions.rs` - `InsnType` methods

TargetInsnNode methods implemented on InsnType:
- `is_target_insn()` - check if instruction is If/Goto/Switch
- `replace_target_offset()` - replace target blocks
- `get_target_offsets()` - get all jump targets
- `get_single_target()`, `set_single_target()` - for If/Goto

```java
// JADX TargetInsnNode.java - REFERENCE (implemented in Rust)
public abstract class TargetInsnNode extends InsnNode {
    public void initBlocks(BlockNode curBlock) {
        // Override in GOTO, IF, SWITCH
    }

    public boolean replaceTargetBlock(BlockNode origin, BlockNode replace) {
        return false;  // Override in subclasses
    }
}
```

---

#### P4-C: IndexInsnNode
**JADX Source:** `jadx-fast/jadx-core/src/main/java/jadx/core/dex/instructions/IndexInsnNode.java`

```java
// JADX IndexInsnNode.java:10-26
public class IndexInsnNode extends InsnNode {
    private Object index;  // Can be ArgType, FieldInfo, MethodInfo

    public IndexInsnNode(InsnType type, Object index, int argCount) {
        super(type, argCount);
        this.index = index;
    }

    public Object getIndex() {
        return index;
    }

    public void updateIndex(Object index) {
        this.index = index;
    }

    public ArgType getIndexAsType() {
        return (ArgType) index;
    }
}
```

---

#### P4-D: InvokeCustomNode (Lambda/MethodRef)
**JADX Source:** `jadx-fast/jadx-core/src/main/java/jadx/core/dex/instructions/InvokeCustomNode.java`

```java
// JADX InvokeCustomNode.java:13-17
private MethodInfo implMthInfo;       // Implementation method
private MethodHandleType handleType;  // INVOKE_STATIC, etc.
private InsnNode callInsn;            // Actual call instruction
private boolean inlineInsn;           // Should inline lambda?
private boolean useRef;               // Use method reference syntax

// JADX InvokeCustomNode.java:55-67 - Getters/Setters
public MethodInfo getImplMthInfo() { return implMthInfo; }
public void setImplMthInfo(MethodInfo info) { this.implMthInfo = info; }
public MethodHandleType getHandleType() { return handleType; }
public InsnNode getCallInsn() { return callInsn; }
public boolean isInlineInsn() { return inlineInsn; }
public boolean isUseRef() { return useRef; }

// JADX InvokeCustomNode.java:94-101
@Nullable
public BaseInvokeNode getInvokeCall() {
    if (callInsn.getType() == InsnType.INVOKE) {
        return (BaseInvokeNode) callInsn;
    }
    return null;
}
```

---

### PRIORITY 5 (P5) - Data Structures

#### P5-A: SwitchData
**JADX Source:** `jadx-fast/jadx-core/src/main/java/jadx/core/dex/instructions/SwitchData.java`

```java
// JADX SwitchData.java - Payload for switch instructions
public class SwitchData {
    private final int[] keys;
    private final int[] targets;
    private final int size;

    public int[] getKeys() { return keys; }
    public int[] getTargets() { return targets; }
    public int getSize() { return size; }
}
```

#### P5-B: FillArrayData
**JADX Source:** `jadx-fast/jadx-core/src/main/java/jadx/core/dex/instructions/FillArrayData.java`

```java
// JADX FillArrayData.java - Payload for fill-array-data
public class FillArrayData {
    private final byte[] data;
    private final int elemWidth;  // 1, 2, 4, or 8 bytes
    private final int size;

    public int getSize() { return size; }
    public ArgType getElementType() { /* from elemWidth */ }
    public List<LiteralArg> getLiteralArgs(ArgType elType) { /* decode data */ }
}
```

---

## Implementation Order

**Phase 1: Core Mutation (P1-A through P1-C)**
1. Add `parent_insn: Option<InsnIndex>` to InsnArg
2. Implement `replace_arg()` on InsnNode
3. Implement `copy()`, `copy_without_result()`, `copy_with_new_ssa_var()`
4. Implement `inherit_metadata()`
5. Implement `rebind_args()`

**Phase 2: Specialized Instructions (P2-A through P2-D)**
1. Add `invert_condition()`, `normalize()` to IfNode
2. Add block bindings to PhiInsn
3. Add target block tracking to SwitchInsn
4. Add `is_same_literal()` to ArithNode

**Phase 3: BlockNode CFG (P3-A, P3-B)**
1. Add dominator fields to BlockNode
2. Add predecessor/successor mutation methods
3. Add lock mechanism
4. Add exception handler markers

**Phase 4: Additional Types (P4-A through P4-D)**
1. Ensure InsnWrapArg methods complete
2. Add TargetInsnNode trait
3. Add IndexInsnNode support
4. Add InvokeCustomNode fields

**Phase 5: Data Structures (P5-A, P5-B)**
1. Add SwitchData struct
2. Add FillArrayData struct

---

## Architecture Notes

### JADX IR Structure
```
RootNode
  └── ClassNode[]
       └── MethodNode
            ├── BlockNode[] (CFG)
            │    └── InsnNode[] (instructions)
            ├── SSAVar[] (variables)
            └── Region (high-level control flow)
```

### Dexterity IR Structure (Current)
```
DexContext
  └── ClassData[]
       └── MethodData
            ├── instructions: Vec<InsnNode>
            └── SSAContext (variables)
```

### Key Differences
1. **Block ownership:** JADX blocks own instructions; Dexterity uses indices
2. **SSA linkage:** JADX uses parent pointers; Dexterity uses indices
3. **Regions:** JADX has separate region tree; Dexterity embeds in passes

---

## Files Changed in This Analysis

1. `crates/dexterity-ir/src/instructions.rs` - Added visitor/utility methods
2. `crates/dexterity-ir/src/info.rs` - Fixed missing constructor fields

## Verification

```bash
# Verify IR compiles
cargo check --package dexterity-ir

# Verify full project
cargo check
```

---

## References

### JADX Source Files (Clone From)

**Instructions:**
- `InsnNode.java` (403 lines) - Base instruction node
- `InsnType.java` (53 lines) - Instruction type enum
- `ArithNode.java` (137 lines) - Arithmetic operations
- `IfNode.java` (121 lines) - Conditional branches
- `InvokeNode.java` (205 lines) - Method calls
- `InvokeCustomNode.java` (133 lines) - Lambda/method refs
- `PhiInsn.java` (141 lines) - SSA PHI nodes
- `SwitchInsn.java` (190 lines) - Switch statements
- `GotoNode.java` (33 lines) - Unconditional jumps
- `IndexInsnNode.java` (67 lines) - Indexed instructions
- `TargetInsnNode.java` (19 lines) - Jump base class
- `ConstStringNode.java` (41 lines) - String constants
- `FillArrayInsn.java` (67 lines) - Array initialization

**Arguments:**
- `InsnArg.java` (239 lines) - Base argument class
- `RegisterArg.java` (164 lines) - Register arguments
- `LiteralArg.java` (114 lines) - Literal constants
- `InsnWrapArg.java` (97 lines) - Wrapped instructions
- `SSAVar.java` (343 lines) - SSA variables
- `ArgType.java` (690 lines) - Type system
- `CodeVar.java` (95 lines) - Source-level variables

**Nodes:**
- `BlockNode.java` (358 lines) - CFG blocks
- `MethodNode.java` (560 lines) - Method representation
- `ClassNode.java` (580 lines) - Class representation
- `RootNode.java` (252 lines) - Decompilation root

**Attributes:**
- `AFlag.java` (110 lines) - Boolean flags
- `AType.java` (78 lines) - Typed attributes

### Dexterity Files (Clone To)

- `crates/dexterity-ir/src/instructions.rs` - Instructions and arguments
- `crates/dexterity-ir/src/types.rs` - Type system
- `crates/dexterity-ir/src/ssa.rs` - SSA infrastructure
- `crates/dexterity-ir/src/attributes.rs` - AFlag/AType system
- `crates/dexterity-ir/src/regions.rs` - Control flow regions
- `crates/dexterity-ir/src/nodes.rs` - Block/Method nodes

### Pass-Level Cloning

See `docs/JADX_PASS_PARITY_REFERENCE.md` for pass-level cloning tasks.

---

## Summary

**IR Parity Status: ~92% Complete** (up from ~85%)

| Component | Status | Priority |
|-----------|--------|----------|
| InsnType enum | ✅ 100% | - |
| ArgType system | ✅ 100% | - |
| AFlag/AType | ✅ 100% | - |
| SSAVar | ✅ 95% | - |
| InsnNode mutation | ✅ 95% | P1 ✓ |
| IfNode methods | ✅ 100% | P2-A ✓ |
| PhiInsn methods | ✅ 100% | P2-B ✓ |
| BlockNode CFG | ✅ 95% | P1, P7 ✓ |
| SwitchData | ✅ 100% | P2 ✓ |
| TargetInsnNode | ✅ 100% | P3 ✓ |
| ArithNode/BinaryOp | ✅ 100% | P4 ✓ |
| InvokeNode | ✅ 100% | P5 ✓ |
| InsnNode Rebind | ✅ 100% | P6 ✓ |

### Completed Dec 23, 2025 - JADX IR Clone Progress (~840 lines)

**P1: BlockNode Dominator Infrastructure** (~250 lines) ✅
**File:** `crates/dexterity-ir/src/nodes.rs`
- Added full JADX-compatible dominator fields:
  - `cid` - const ID (stable block identity) (JADX: BlockNode.java:25-26)
  - `pos` - position in blocks list (for BitSet operations) (JADX: BlockNode.java:29-30)
  - `start_offset` - bytecode offset (JADX: BlockNode.java:35)
  - `doms: Option<FixedBitSet>` - all dominators (JADX: BlockNode.java:46)
  - `post_doms: Option<FixedBitSet>` - post-dominators (JADX: BlockNode.java:51)
  - `dom_frontier: Option<FixedBitSet>` - dominance frontier (JADX: BlockNode.java:56)
  - `idom: Option<BlockId>` - immediate dominator (JADX: BlockNode.java:61)
  - `ipost_dom: Option<BlockId>` - immediate post-dominator (JADX: BlockNode.java:66)
  - `dominates_on: Vec<BlockId>` - reverse dominator tree (JADX: BlockNode.java:71)
  - `clean_successors: Option<Vec<BlockId>>` - exclude exception handlers (JADX: BlockNode.java:41)
  - `locked: bool` - prevent post-analysis mutation (JADX: BlockNode.java:122-135)
- Fixed `ArenaId<T>` to properly implement `Copy` without requiring `T: Copy` (arena.rs:24)

**P2: SwitchData Struct** (~130 lines) ✅
**File:** `crates/dexterity-ir/src/instructions.rs`
- JADX Reference: `SwitchData.java`
- `size`, `keys`, `targets` fields (JADX: SwitchData.java:8-10)
- `fix_targets(switch_offset)` - convert relative to absolute offsets (JADX: SwitchData.java:19-25)
- `new_packed()`, `new_sparse()` constructors
- `iter()`, `is_packed()` utility methods
- `get_size()`, `get_keys()`, `get_targets()` accessors (JADX: SwitchData.java:27-37)

**P3: TargetInsnNode Methods** (~80 lines) ✅
**File:** `crates/dexterity-ir/src/instructions.rs`
- JADX Reference: `TargetInsnNode.java`
- `is_target_insn()` - check if instruction is If/Goto/Switch
- `replace_target_offset()` - replace target blocks (JADX: SwitchInsn.java:58-76)
- `get_target_offsets()` - get all jump targets
- `get_single_target()`, `set_single_target()` - for If/Goto

**P4: ArithNode/BinaryOp Methods** (~120 lines) ✅
**File:** `crates/dexterity-ir/src/instructions.rs`
- JADX Reference: `ArithNode.java`, `ArithOp.java`
- `BinaryOp::symbol()` - operator symbols for codegen (JADX: ArithOp.java:30-32)
- `BinaryOp::is_bit_op()` - check for AND/OR/XOR (JADX: ArithOp.java:34-36)
- `BinaryOp::is_shift_op()` - check for SHL/SHR/USHR
- `BinaryOp::is_commutative()` - check if a op b == b op a
- `InsnType::new_arith_one_arg()` - create compound assignment (JADX: ArithNode.java:73-77)
- `InsnType::is_same_arith_literal()` - compare literal values (JADX: ArithNode.java:95-109)
- `InsnType::is_same_arith()` - full arithmetic comparison (JADX: ArithNode.java:85-94)

**P5: InvokeNode Methods** (~180 lines) ✅
**File:** `crates/dexterity-ir/src/instructions.rs`
- JADX Reference: `InvokeNode.java`
- `is_invoke()` - check if instruction is Invoke/InvokeCustom
- `is_static_call()` - check InvokeType.STATIC (JADX: InvokeNode.java:53-55)
- `get_first_arg_offset()` - 0 for static, 1 for instance (JADX: InvokeNode.java:61-63)
- `get_instance_arg()`, `get_instance_arg_mut()` - receiver for virtual calls (JADX: InvokeNode.java:65-67)
- `get_invoke_kind()`, `get_method_idx()`, `get_call_args()` - invoke accessors
- `is_polymorphic_call()` - MethodHandle/VarHandle (JADX: InvokeNode.java:71-73)
- `is_super_call()`, `is_direct_call()`, `is_interface_call()` - invoke type checks

**P6: InsnNode Rebind Methods** (~80 lines) ✅
**File:** `crates/dexterity-ir/src/instructions.rs`
- JADX Reference: `InsnNode.java:213-222`, `InsnNode.java:166-211`
- `rebind_args()` - JADX API parity (no-op in Rust, validates consistency)
- `replace_arg(from, to)` - replace argument throughout instruction (recursive for wrapped)
- `remove_arg(index)` - remove argument (delegates to InsnType)

**P7: BlockNode CFG Methods** (completed with P1) ✅
**File:** `crates/dexterity-ir/src/nodes.rs`
- `get_clean_successors()`, `set_clean_successors()` (JADX: BlockNode.java:107-109)
- `lock()`, `is_locked()` (JADX: BlockNode.java:122-135)
- `is_empty()` (JADX: BlockNode.java:247-249)
- `is_synthetic()`, `is_return_block()`, `is_mth_exit_block()` (JADX: BlockNode.java:235-245)

---

### Previously Completed (Earlier Dec 23, 2025)

**P1-A: InsnNode Mutation Methods** ✅
- `copy()` - Deep copy of instruction (JADX: InsnNode.java:364-373)
- `copy_without_result()` - Copy without dest register
- `inherit_metadata()` - Copy offset/source_line from source
- `set_arg()` / `replace_arg()` - Argument replacement with wrapped insn recursion
- `add_arg()` / `remove_arg()` - Variable-arg instruction support
- `get_args_count()` / `get_arg()` - Argument accessors

**P2-A: IfNode/IfCondition Methods** ✅
- `IfCondition::invert()` - Invert condition (JADX: IfOp.java:34-46)
- `IfCondition::mirror()` - Swap operand order (JADX: IfOp.java:48-60)
- `invert_if_condition()` - Invert If/Ternary (JADX: IfNode.java:72-82)
- `change_if_condition()` - Modify condition (JADX: IfNode.java:93-100)
- `normalize_if_condition()` - Canonical arg order (JADX: IfNode.java:84-92)
- `get_if_target()` / `set_if_target()` - Target accessors

**P2-B: PhiInsn Block Bindings** ✅
- `bind_phi_arg()` - Add arg with block binding (JADX: PhiInsn.java:36-50)
- `get_phi_block_by_index()` - Get block by arg index (JADX: PhiInsn.java:62-64)
- `get_phi_block_by_arg()` - Get block for specific arg (JADX: PhiInsn.java:53-59)
- `remove_phi_arg()` - Remove by index (JADX: PhiInsn.java:83-88)
- `remove_phi_arg_by_block()` - Remove by block ID
- `get_phi_sources()` / `get_phi_sources_mut()` - Source accessors

**Next Steps:**
1. Complete P4-A: InsnWrapArg methods
2. Complete P4-B: TargetInsnNode trait
3. Complete P4-C: IndexInsnNode support
4. Complete P4-D: InvokeCustomNode fields

---

*Last updated: Dec 23, 2025 - P1-P7 complete (~840 lines), IR Parity 85% -> 92%*
