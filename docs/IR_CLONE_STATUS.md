# Dexterity-IR JADX Parity Status

## Overview

This document tracks the status of cloning JADX's IR (Intermediate Representation) layer into Dexterity.
The IR is the **first and most critical layer** of the decompilation pipeline.

**Goal:** 100% functional parity with JADX's IR to ensure all edge cases are handled identically.

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

## Pending Tasks

### P1: InsnNode Mutation Methods
**Priority:** HIGH - Required for optimization passes

JADX has mutation methods that modify instruction arguments in-place:

```java
// JADX InsnNode methods to clone:
public boolean replaceArg(InsnArg from, InsnArg to);  // Recursive arg replacement
protected boolean removeArg(InsnArg arg);              // Remove arg by reference
public InsnArg removeArg(int index);                   // Remove arg by index
public void rebindArgs();                              // Fix SSA linkage after mutation
public InsnNode copy();                                // Copy instruction
public InsnNode copyWithoutResult();                   // Copy without dest
public InsnNode copy(RegisterArg newReturnArg);        // Copy with new dest
public InsnNode copyWithNewSsaVar(MethodNode mth);     // Copy with fresh SSA
```

**File to modify:** `crates/dexterity-ir/src/instructions.rs`

### P2: Specialized Instruction Methods
**Priority:** MEDIUM - Required for some passes

JADX has specialized instruction subclasses with additional methods:

#### ArithNode.java
- `ArithOp getOp()` - arithmetic operation type
- `boolean isIntOp()` / `isLongOp()` / etc.

#### IfNode.java
- `IfOp getOp()` - comparison operator
- `void invertCondition()` - flip condition
- `void changeCondition(IfOp newOp, InsnArg a, InsnArg b)`

#### InvokeNode.java
- `InvokeType getInvokeType()` - static/virtual/etc
- `MethodInfo getCallMth()`
- `boolean isIntrinsic()`

#### PhiInsn.java
- `List<RegisterArg> getBlockBindsArg()` - get args from specific block
- `void bindArg(InsnArg arg, BlockNode blockNode)`
- `void removeArg(RegisterArg arg)`

#### SwitchInsn.java
- `Object[] getKeys()` / `void modifyKeys(int[] keys)`
- `int[] getTargets()` / `void modifyTargets(int[] targets)`

**Approach:** Add methods to InsnType/InsnNode impl blocks

### P3: BlockNode CFG Infrastructure
**Priority:** HIGH - Required for control flow analysis

JADX's BlockNode (5.6KB) has comprehensive CFG support:

```java
// BlockNode methods to clone:
List<BlockNode> getPredecessors();
List<BlockNode> getSuccessors();
void addPredecessor(BlockNode block);
void addSuccessor(BlockNode block);
BlockNode getIDom();                    // Immediate dominator
void setIDom(BlockNode idom);
BitSet getDoms();                       // Dominator set
void setDoms(BitSet doms);
BitSet getDomFrontier();                // Dominance frontier
List<BlockNode> getDominatesOn();       // Dominated blocks
List<BlockNode> getPostDominatesOn();   // Post-dominated blocks
```

**File to create/modify:** `crates/dexterity-passes/src/cfg.rs`

### P4: RegisterArg Parent Tracking
**Priority:** MEDIUM - Required for SSA mutation

JADX's RegisterArg tracks its parent instruction:

```java
// RegisterArg methods:
InsnNode getParentInsn();
void setParentInsn(InsnNode parentInsn);
SSAVar getSVar();
void setSVar(SSAVar sVar);
```

This enables:
- Finding where a register is defined
- Updating use-def chains when replacing args
- SSA variable management

**File to modify:** `crates/dexterity-ir/src/instructions.rs`

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

- JADX IR: `jadx-fast/jadx-core/src/main/java/jadx/core/dex/`
- Dexterity IR: `crates/dexterity-ir/src/`
- See also: `docs/JADX_PASS_PARITY_REFERENCE.md` for pass-level cloning
