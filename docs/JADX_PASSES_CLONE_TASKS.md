# JADX Passes Clone Tasks - Detailed Analysis

**Philosophy:** We are **CLONING JADX**, not rewriting it. 10 years of edge cases demand exact algorithmic parity.

**Analysis Date:** Dec 23, 2025
**Analysis Method:** Direct source comparison of `jadx-fast/` vs `dexterity-passes/`

---

## Executive Summary

After detailed source analysis comparing JADX Java source with Dexterity Rust implementations:

| Category | JADX Files | Dexterity | Coverage | Gap Lines |
|----------|------------|-----------|----------|-----------|
| SimplifyVisitor | 637 lines | 1843 lines | **60%** | ~300 lines missing |
| ModVisitor | 634 lines | 400 lines | **45%** | ~400 lines missing |
| PrepareForCodeGen | 407 lines | 403 lines | **40%** | ~250 lines missing |
| CodeShrinkVisitor | 299 lines | 1100 lines | **85%** | ~50 lines edge cases |
| TypeInference* | 3710 lines | 4000+ lines | **90%** | ~200 lines bounds |

**Total estimated gap: ~1200 lines of core logic to clone**

---

## P0: CRITICAL GAPS (Must Fix for Parity)

### P0-1: SimplifyVisitor - Missing convertInvoke() (StringBuilder → STR_CONCAT)
**JADX Source:** `SimplifyVisitor.java:305-428` (124 lines)
**Dexterity:** Comment says "handled at codegen level" - **VERIFY THIS**

```java
// JADX SimplifyVisitor.java:305-323
// This is CRITICAL for readable output - converts:
//   new StringBuilder("text").append(var).append(123).toString()
// to:
//   "text" + var + 123

private static InsnNode convertInvoke(MethodNode mth, InvokeNode insn) {
    MethodInfo callMth = insn.getCallMth();
    if (callMth.getDeclClass().getFullName().equals(Consts.CLASS_STRING_BUILDER)
            && callMth.getShortId().equals(Consts.MTH_TOSTRING_SIGNATURE)) {
        // Convert StringBuilder chains to STR_CONCAT
        List<InsnNode> callChain = flattenInsnChainUntil(insn, InsnType.CONSTRUCTOR);
        return convertStringBuilderChain(mth, insn, callChain);
    }
    return null;
}
```

**Clone Task:**
1. Clone `convertInvoke()` - StringBuilder chain detection
2. Clone `flattenInsnChainUntil()` - Chain traversal
3. Clone `convertStringBuilderChain()` - STR_CONCAT creation
4. Clone `concatConstArgs()` - Constant string concatenation
5. Clone `collectUseChain()` - Multi-statement StringBuilder tracking
6. Clone `removeStringBuilderInsns()` - Cleanup after conversion

---

### P0-2: SimplifyVisitor - Missing simplifyStringConstructor()
**JADX Source:** `SimplifyVisitor.java:175-216` (42 lines)

```java
// JADX SimplifyVisitor.java:175-216
// Converts: new String(new byte[]{104, 101, 108, 108, 111})
// to: "hello"

private InsnNode simplifyStringConstructor(MethodNode mth, ConstructorInsn insn) {
    if (insn.getCallMth().getDeclClass().getType().equals(ArgType.STRING)
            && insn.getArgsCount() != 0
            && insn.getArg(0).isInsnWrap()) {
        // Check for FilledNewArray of bytes/chars that form printable string
        InsnNode arrInsn = ((InsnWrapArg) insn.getArg(0)).getWrapInsn();
        if (arrInsn.getType() == InsnType.FILLED_NEW_ARRAY) {
            // Extract bytes, check printability, convert to ConstStringNode
            ...
        }
    }
}
```

**Clone Task:**
1. Clone `simplifyStringConstructor()` with printability check
2. Add `NameMapper.isPrintableChar()` equivalent in Dexterity

---

### P0-3: SimplifyVisitor - Missing convertFieldArith()
**JADX Source:** `SimplifyVisitor.java:581-636` (55 lines)

```java
// JADX SimplifyVisitor.java:581-636
// Converts: obj.field = obj.field + value
// to: obj.field += value (ArithNode with ARITH_ONEARG flag)

private static ArithNode convertFieldArith(MethodNode mth, InsnNode insn) {
    // Detects IPUT (ARITH (IGET, lit)) pattern
    // Verifies same field accessed in both get and put
    // Returns ArithNode.oneArgOp() for compound assignment
}
```

**Clone Task:**
1. Clone field arith detection (IPUT/SPUT wrapping ARITH wrapping IGET/SGET)
2. Verify field identity check
3. Create compound assignment ArithNode

---

### P0-4: ModVisitor - Missing replaceConst() (Const Field Replacement)
**JADX Source:** `ModVisitor.java:340-357` (18 lines)

```java
// JADX ModVisitor.java:340-357
// Replaces literal constants with field references
// Example: 0xFF0000FF -> Color.RED

private static void replaceConst(MethodNode mth, ClassNode parentClass,
        BlockNode block, int i, InsnNode insn) {
    IFieldInfoRef f;
    if (insn.getType() == InsnType.CONST_STR) {
        f = parentClass.getConstField(((ConstStringNode) insn).getString());
    } else if (insn.getType() == InsnType.CONST_CLASS) {
        f = parentClass.getConstField(((ConstClassNode) insn).getClsType());
    } else {
        f = parentClass.getConstFieldByLiteralArg((LiteralArg) insn.getArg(0));
    }
    if (f != null) {
        // Replace CONST with SGET
        InsnNode inode = new IndexInsnNode(InsnType.SGET, f.getFieldInfo(), 0);
        replaceInsn(mth, block, i, inode);
    }
}
```

**Clone Task:**
1. Implement `ClassNode.getConstField()` lookup mechanism
2. Clone `replaceConst()` for CONST, CONST_STR, CONST_CLASS
3. Clone `processArith()` for arith literal replacement

---

### P0-5: ModVisitor - Missing fixPrimitiveCast() (Boolean Conversion)
**JADX Source:** `ModVisitor.java:252-277` (26 lines)

```java
// JADX ModVisitor.java:252-277
// Replaces: (long)booleanVar
// With: booleanVar ? 1L : 0L

private static void fixPrimitiveCast(MethodNode mth, BlockNode block, int i, InsnNode insn) {
    InsnArg castArg = insn.getArg(0);
    if (castArg.getType() == ArgType.BOOLEAN) {
        ArgType type = insn.getResult().getType();
        if (type.isPrimitive()) {
            TernaryInsn ternary = makeBooleanConvertInsn(insn.getResult(), castArg, type);
            replaceInsn(mth, block, i, ternary);
        }
    }
}
```

**Clone Task:**
1. Clone `fixPrimitiveCast()` boolean→primitive detection
2. Clone `makeBooleanConvertInsn()` ternary creation
3. Handle DOUBLE/FLOAT bit representations (lines 267-272)

---

### P0-6: ModVisitor - Missing fixFieldUsage() (Visibility Casts)
**JADX Source:** `ModVisitor.java:172-211` (40 lines)

```java
// JADX ModVisitor.java:172-211
// Inserts cast when field not visible from access site
// Example: ((ParentClass)this).privateField

private static void fixFieldUsage(MethodNode mth, IndexInsnNode insn) {
    // Check if instanceArg type matches field declaring class
    // If field not visible, insert CAST insn with EXPLICIT_CAST flag
}
```

**Clone Task:**
1. Clone field visibility check logic
2. Clone cast insertion with EXPLICIT_CAST flag
3. Clone `isFieldVisibleInMethod()` access check

---

## P1: HIGH PRIORITY GAPS

### P1-1: PrepareForCodeGen - Missing modifyArith() (Compound Assignment)
**JADX Source:** `PrepareForCodeGen.java:228-250` (23 lines)

```java
// JADX PrepareForCodeGen.java:228-250
// Converts: a = a + 2
// To: a += 2 (sets ARITH_ONEARG flag)

private static void modifyArith(BlockNode block) {
    for (InsnNode insn : list) {
        if (insn.getType() == InsnType.ARITH && !insn.contains(AFlag.ARITH_ONEARG)) {
            RegisterArg res = insn.getResult();
            InsnArg arg = insn.getArg(0);
            if (res.equals(arg) || (arg.isRegister() && res.sameCodeVar((RegisterArg) arg))) {
                insn.setResult(null);
                insn.add(AFlag.ARITH_ONEARG);
            }
        }
    }
}
```

**Clone Task:** Port to `prepare_for_codegen.rs` with ARITH_ONEARG flag

---

### P1-2: PrepareForCodeGen - Missing checkConstUsage() (Type Suffixes)
**JADX Source:** `PrepareForCodeGen.java:147-175` (29 lines)

```java
// JADX PrepareForCodeGen.java:147-175
// Adds EXPLICIT_PRIMITIVE_TYPE flag for non-int literals
// Makes: long x = 123L; float y = 1.0f;

private static void checkConstUsage(BlockNode block) {
    for (InsnNode blockInsn : block.getInstructions()) {
        blockInsn.visitInsns(insn -> {
            for (InsnArg arg : insn.getArguments()) {
                if (arg.isLiteral() && arg.getType() != ArgType.INT) {
                    arg.add(AFlag.EXPLICIT_PRIMITIVE_TYPE);
                }
            }
        });
    }
}
```

**Clone Task:** Port flag addition logic

---

### P1-3: PrepareForCodeGen - Missing addNullCasts()
**JADX Source:** `PrepareForCodeGen.java:385-406` (22 lines)

```java
// JADX PrepareForCodeGen.java:385-406
// Adds casts for null invoke receivers
// Prevents: null.method() (invalid Java)

private void addNullCasts(MethodNode mth, BlockNode block) {
    for (InsnNode insn : block.getInstructions()) {
        if (insn.getType() == InsnType.INVOKE) {
            verifyNullCast(mth, ((InvokeNode) insn).getInstanceArg());
        }
    }
}
```

**Clone Task:** Port null receiver detection and cast wrapping

---

### P1-4: PrepareForCodeGen - Missing moveConstructorInConstructor()
**JADX Source:** `PrepareForCodeGen.java:256-307` (52 lines)

```java
// JADX PrepareForCodeGen.java:256-307
// Moves super()/this() call to top of constructor
// Fixes: { x = 1; super(); } -> { super(); x = 1; }

private void moveConstructorInConstructor(MethodNode mth) {
    // Find CONSTRUCTOR (super/this) call
    // Verify it can be moved (no arg dependencies)
    // Add warning if semantics might change
}
```

**Clone Task:** Port constructor call reordering with warning generation

---

### P1-5: ModVisitor - Missing processMoveException()
**JADX Source:** `ModVisitor.java:598-626` (29 lines)

```java
// JADX ModVisitor.java:598-626
// Processes MOVE_EXCEPTION with named exception args
// Creates NamedArg for catch clause parameter

private static void processMoveException(MethodNode mth, BlockNode block,
        InsnNode insn, InsnRemover remover) {
    ExcHandlerAttr excHandlerAttr = block.get(AType.EXC_HANDLER);
    // Set exception arg name ("e" or "th")
    // Remove if unused, replace with MOVE if used in phi
}
```

**Clone Task:** Port to dexterity with NamedArg creation

---

### P1-6: ModVisitor - Missing inlineCMPInsns()
**JADX Source:** `ModVisitor.java:377-394` (18 lines)

```java
// JADX ModVisitor.java:377-394
// Inlines CMP instructions into IF by wrapping
// Different from simplify.rs CMP unwrapping!

private static void inlineCMPInsns(MethodNode mth, BlockNode block, int i,
        InsnNode insn, InsnRemover remover) {
    RegisterArg resArg = insn.getResult();
    List<RegisterArg> useList = resArg.getSVar().getUseList();
    if (allMatch(useList, use -> InsnUtils.isInsnType(use.getParentInsn(), InsnType.IF))) {
        for (RegisterArg useArg : new ArrayList<>(useList)) {
            InsnArg wrapArg = InsnArg.wrapInsnIntoArg(insn.copyWithoutResult());
            useInsn.replaceArg(useArg, wrapArg);
        }
        remover.addAndUnbind(insn);
    }
}
```

**Clone Task:** Verify this differs from simplify.rs CMP handling

---

## P2: MEDIUM PRIORITY GAPS

### P2-1: ModVisitor - Missing processAnonymousConstructor()
**JADX Source:** `ModVisitor.java:509-537` (29 lines)

Marks anonymous class constructor args as DONT_INLINE and FINAL.

### P2-2: ModVisitor - Missing replaceConstInAnnotations()
**JADX Source:** `ModVisitor.java:279-338` (60 lines)

Replaces annotation constant values with field references.

### P2-3: PrepareForCodeGen - Missing checkInline()
**JADX Source:** `PrepareForCodeGen.java:130-143` (14 lines)

Replaces MOVE with inner wrapped instruction.

### P2-4: CodeShrinkVisitor - Lambda inline restriction
**JADX Source:** `CodeShrinkVisitor.java:153-167` (15 lines)

```java
// Forbid inline: () -> { ... }.apply()
private static boolean checkLambdaInline(RegisterArg arg, InsnNode assignInsn) {
    if (assignInsn.getType() == InsnType.INVOKE && assignInsn instanceof InvokeCustomNode) {
        // Check if used as instance arg
    }
}
```

### P2-5: SimplifyVisitor - Missing shadowedByOuterCast()
**JADX Source:** `SimplifyVisitor.java:261-268` (8 lines)

Removes redundant inner cast when outer cast is narrower.

---

## P3: LOW PRIORITY / NICE TO HAVE

### P3-1: AttachCommentsVisitor
**JADX Source:** 139 lines - User code comments from annotations

### P3-2: FixAccessModifiers (2 files)
**JADX Source:** ~300 lines - Fix visibility for inner class access

### P3-3: AddAndroidConstants
**JADX Source:** ~150 lines - R.id.xxx resolution

### P3-4: CollectConstValues
**JADX Source:** ~100 lines - Extract const values from annotations

### P3-5: DebugInfoApplyVisitor
**JADX Source:** 101 lines - Apply debug variable names

### P3-6: DebugInfoAttachVisitor
**JADX Source:** 133 lines - Attach debug line numbers

---

## Implementation Guide

### Adding JADX Reference Comments

Every cloned function MUST have:

```rust
/// Clone of JADX SimplifyVisitor.java:305-323
/// Converts StringBuilder.append() chains to STR_CONCAT instructions.
///
/// Reference: convertInvoke(MethodNode, InvokeNode)
fn convert_invoke(mth: &mut MethodData, insn: &InvokeNode) -> Option<InsnNode> {
    // Clone logic here
}
```

### Testing Cloned Passes

JADX has tests in `jadx-fast/jadx-core/src/test/java/jadx/tests/`:
- `api/` - API-level tests
- `integration/` - Full decompilation tests
- `external/` - Real APK tests

Match output exactly for parity verification.

---

## Verification Checklist

Before marking a clone as complete:

- [ ] All public methods cloned
- [ ] All private helper methods cloned
- [ ] Edge case handling preserved
- [ ] JADX reference comments added with line numbers
- [ ] Error handling matches JADX (warnings, comments)
- [ ] Tested with JADX test cases

---

## Priority Order

1. **P0-1 to P0-6**: StringBuilder concat & field operations (MOST VISIBLE)
2. **P1-1 to P1-6**: Code style improvements (compound assignment, type suffixes)
3. **P2-1 to P2-5**: Edge case handling
4. **P3-***: Nice to have features

---

*This document tracks specific clone tasks identified through source comparison.*
*Update as tasks are completed.*
