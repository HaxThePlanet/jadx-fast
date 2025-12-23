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
| **instructions/** | 25 Java files | ~3,500 LOC | 75% |
| **instructions/args/** | 12 Java files | ~2,800 LOC | 80% |
| **nodes/** | 14 Java files | ~4,200 LOC | 60% |
| **attributes/** | 15 Java files | ~1,500 LOC | 95% |
| **regions/** | 11 Java files | ~2,000 LOC | 85% |
| **info/** | 8 Java files | ~1,800 LOC | 90% |
| **TOTAL** | ~85 Java files | ~15,800 LOC | **~80%** |

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

#### P2-C: SwitchInsn Data & Blocks
**JADX Source:** `jadx-fast/jadx-core/src/main/java/jadx/core/dex/instructions/SwitchInsn.java`
**Priority:** MEDIUM - Required for switch optimization

```java
// JADX SwitchInsn.java:20-26
private final int dataTarget;
private final boolean packed;
@Nullable private SwitchData switchData;
private int def;  // default target
private Object[] modifiedKeys;
private BlockNode[] targetBlocks;
private BlockNode defTargetBlock;

// JADX SwitchInsn.java:44-56
@Override
public void initBlocks(BlockNode curBlock) {
    if (switchData == null) {
        throw new JadxRuntimeException("Switch data not yet attached");
    }
    List<BlockNode> successors = curBlock.getSuccessors();
    int[] targets = switchData.getTargets();
    int len = targets.length;
    targetBlocks = new BlockNode[len];
    for (int i = 0; i < len; i++) {
        targetBlocks[i] = getBlockByOffset(targets[i], successors);
    }
    defTargetBlock = getBlockByOffset(def, successors);
}

// JADX SwitchInsn.java:58-76
@Override
public boolean replaceTargetBlock(BlockNode origin, BlockNode replace) {
    if (targetBlocks == null) return false;
    int count = 0;
    int len = targetBlocks.length;
    for (int i = 0; i < len; i++) {
        if (targetBlocks[i] == origin) {
            targetBlocks[i] = replace;
            count++;
        }
    }
    if (defTargetBlock == origin) {
        defTargetBlock = replace;
        count++;
    }
    return count > 0;
}

// JADX SwitchInsn.java:164-180 - Key modification for enum switches
public void modifyKey(int i, Object newKey) {
    if (modifiedKeys == null) {
        int[] keys = getKeys();
        int caseCount = keys.length;
        Object[] newKeys = new Object[caseCount];
        for (int j = 0; j < caseCount; j++) {
            newKeys[j] = keys[j];
        }
        modifiedKeys = newKeys;
    }
    modifiedKeys[i] = newKey;
}
```

---

#### P2-D: ArithNode Operations
**JADX Source:** `jadx-fast/jadx-core/src/main/java/jadx/core/dex/instructions/ArithNode.java`
**Priority:** MEDIUM - Required for arithmetic simplification

```java
// JADX ArithNode.java:58
private final ArithOp op;

// JADX ArithNode.java:44-55 - Type fixing for bitwise ops
private static ArgType fixResultType(ArithOp op, ArgType type) {
    if (type == ArgType.INT && op.isBitOp()) {
        return ArgType.INT_BOOLEAN;  // Result might be boolean
    }
    return type;
}

private static ArgType fixArgType(ArithOp op, ArgType type) {
    if (type == ArgType.INT && op.isBitOp()) {
        return ArgType.NARROW_NUMBERS_NO_FLOAT;
    }
    return type;
}

// JADX ArithNode.java:73-77 - One-arg form (x += 2)
public static ArithNode oneArgOp(ArithOp op, InsnArg res, InsnArg a) {
    ArithNode insn = new ArithNode(op, null, res, a);
    insn.add(AFlag.ARITH_ONEARG);
    return insn;
}

// JADX ArithNode.java:95-109 - Literal comparison for isSame()
private boolean isSameLiteral(ArithNode other) {
    InsnArg thisSecond = getArg(1);
    InsnArg otherSecond = other.getArg(1);
    if (thisSecond.isLiteral() != otherSecond.isLiteral()) {
        return false;
    }
    if (!thisSecond.isLiteral()) return true;
    long thisLit = ((LiteralArg) thisSecond).getLiteral();
    long otherLit = ((LiteralArg) otherSecond).getLiteral();
    return thisLit == otherLit;
}
```

---

### PRIORITY 3 (P3) - BlockNode Infrastructure

#### P3-A: BlockNode Core CFG
**JADX Source:** `jadx-fast/jadx-core/src/main/java/jadx/core/dex/nodes/BlockNode.java`
**Priority:** HIGH - Required for CFG passes

```java
// JADX BlockNode.java:32-40 - Core fields
private int id;
private int startOffset;
private final List<InsnNode> instructions = new ArrayList<>(2);
private List<BlockNode> predecessors = new ArrayList<>(1);
private List<BlockNode> successors = new ArrayList<>(1);
private List<BlockNode> dominatesOn = new ArrayList<>();
private List<BlockNode> postDominatesOn = Collections.emptyList();

// JADX BlockNode.java:42-48 - Dominator tree
private BlockNode idom;       // Immediate dominator
private BitSet doms;          // Dominator set (bitset for efficiency)
private BitSet domFrontier;   // Dominance frontier
private BlockNode iPostDom;   // Immediate post-dominator

// JADX BlockNode.java:112-124 - Successor/predecessor ops
public void addSuccessor(BlockNode block) {
    if (!successors.contains(block)) {
        successors.add(block);
        block.predecessors.add(this);
    }
}

public void removeSuccessor(BlockNode block) {
    successors.remove(block);
    block.predecessors.remove(this);
}

// JADX BlockNode.java:169-182 - Dominance queries
public boolean isDominator(BlockNode block) {
    return doms != null && doms.get(block.getId());
}

public boolean isPostDominator(BlockNode block) {
    // Post-dominance check
}

// JADX BlockNode.java:198-216 - Lock for modification control
private volatile boolean locked;

public void lock() {
    locked = true;
    successors = Collections.unmodifiableList(successors);
    predecessors = Collections.unmodifiableList(predecessors);
}

public boolean isLocked() {
    return locked;
}
```

---

#### P3-B: BlockNode Exception Handler Support
**JADX Source:** `jadx-fast/jadx-core/src/main/java/jadx/core/dex/nodes/BlockNode.java:220-250`

```java
// JADX BlockNode.java:220-228 - Exception handling
private boolean excHandler;  // Is this an exception handler entry?

public void initFromExcHandler() {
    this.excHandler = true;
}

public boolean isExcHandler() {
    return excHandler;
}

// JADX BlockNode.java:230-245 - Synthetic block markers
private boolean syntheticBlock;  // Created by passes, not in DEX

public boolean isSyntheticBlock() {
    return syntheticBlock;
}

public void setSyntheticBlock(boolean syntheticBlock) {
    this.syntheticBlock = syntheticBlock;
}
```

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

#### P4-B: TargetInsnNode (Abstract Base)
**JADX Source:** `jadx-fast/jadx-core/src/main/java/jadx/core/dex/instructions/TargetInsnNode.java`

```java
// JADX TargetInsnNode.java - Abstract base for jump instructions
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

**IR Parity Status: ~85% Complete**

| Component | Status | Priority |
|-----------|--------|----------|
| InsnType enum | ✅ 100% | - |
| ArgType system | ✅ 100% | - |
| AFlag/AType | ✅ 100% | - |
| SSAVar | ✅ 95% | - |
| InsnNode mutation | ✅ 90% | P1 ✓ |
| IfNode methods | ✅ 100% | P2-A ✓ |
| PhiInsn methods | ✅ 100% | P2-B ✓ |
| BlockNode CFG | ❌ 50% | P3 |
| Data payloads | ❌ 70% | P5 |

### Completed Today (Dec 23, 2025)

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
1. P3-A: BlockNode CFG (dominators, predecessors)
2. P2-C: SwitchInsn data & blocks
3. P2-D: ArithNode operations

---

*Last updated: Dec 23, 2025 - P1-A, P2-A, P2-B complete*
