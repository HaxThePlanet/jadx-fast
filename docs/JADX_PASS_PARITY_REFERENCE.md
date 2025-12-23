# JADX Pass Parity Analysis: Complete Missing Pass Documentation

## Purpose
This document provides **complete documentation of every JADX pass missing from Dexterity**, including:
- Exact Java file paths
- Line counts
- Key algorithms/tricks
- Dependencies
- What to clone

---

## Missing Pass #1: SignatureProcessor

**File:** `/mnt/nvme4tb/dexterity/jadx-fast/jadx-core/src/main/java/jadx/core/dex/visitors/SignatureProcessor.java`
**Lines:** 337
**Priority:** HIGH
**Stage:** Pre-Decompile

### What It Does
Parses generic type signatures from Java `.class` file debug attributes. These signatures contain generic type information that isn't in the raw DEX types.

### Key Algorithms
1. **parseClassSignature()** - Parses `<T extends Foo>` declarations on classes
2. **parseFieldSignature()** - Parses generic field types like `List<String>`
3. **parseMethodSignature()** - Parses method generic params, args, and return types
4. **fixTypeParamDeclarations()** - Adds missing type params from super/interfaces
5. **validateParsedType()** - Compares parsed signature against DEX type for conflicts

### Key Dependencies
- `SignatureParser` class (parses the signature string format)
- `TypeUtils.expandTypeVariables()` - resolves type variables

### Implementation Notes
```java
// Pattern: Parse generic signature, validate against DEX type, update node
private void parseFieldSignature(FieldNode field) {
    SignatureParser sp = SignatureParser.fromNode(field);
    if (sp == null) return;
    ArgType signatureType = sp.consumeType();
    ArgType type = root.getTypeUtils().expandTypeVariables(cls, signatureType);
    if (!validateParsedType(type, field.getType())) {
        field.addInfoComment("Incorrect field signature: " + sp.getSignature());
        return;
    }
    field.updateType(type);  // KEY: Updates the field's type with generic info
}
```

---

## Missing Pass #2: AnonymousClassVisitor

**File:** `/mnt/nvme4tb/dexterity/jadx-fast/jadx-core/src/main/java/jadx/core/dex/visitors/AnonymousClassVisitor.java`
**Lines:** 133
**Priority:** HIGH
**Stage:** Post-Type Inference (runs before ModVisitor)

### What It Does
Prepares anonymous class constructors for inlining by:
1. Mapping constructor args to synthetic fields
2. Marking synthetic fields with `DONT_GENERATE`
3. Marking constructor insns with `DONT_GENERATE`

### Key Algorithm
```java
// Pattern: Find synthetic fields that just store constructor args
private static Map<InsnArg, FieldNode> getArgsToFieldsMapping(MethodNode mth, List<InsnNode> usedInsns) {
    for (RegisterArg arg : mth.getArgRegs()) {
        InsnNode useInsn = getParentInsnSkipMove(arg);  // Skip MOVE chains
        if (useInsn.getType() == IPUT) {
            FieldNode fieldNode = cls.searchField(fieldInfo);
            if (fieldNode.getAccessFlags().isSynthetic()) {
                map.put(arg, fieldNode);  // This arg maps to this field
                usedInsns.add(useInsn);
            }
        } else if (useInsn.getType() == CONSTRUCTOR && superConstr.isSuper()) {
            usedInsns.add(useInsn);  // super() call - mark for removal
        }
    }
}
```

### Trick: Skip MOVE chains
```java
private static InsnNode getParentInsnSkipMove(RegisterArg arg) {
    if (parentInsn.getType() == InsnType.MOVE) {
        return getParentInsnSkipMove(parentInsn.getResult());  // Recurse through MOVEs
    }
    return parentInsn;
}
```

---

## Missing Pass #3: CleanRegions

**File:** `/mnt/nvme4tb/dexterity/jadx-fast/jadx-core/src/main/java/jadx/core/dex/visitors/regions/CleanRegions.java`
**Lines:** 65
**Priority:** MEDIUM
**Stage:** Regions IR (after ReturnVisitor)

### What It Does
Removes empty blocks and regions from the region tree using a depth-first traversal.

### Key Algorithm
```java
private static boolean canRemoveRegion(IContainer container) {
    if (container.contains(AFlag.DONT_GENERATE)) return true;
    if (container instanceof BlockNode) {
        return block.getInstructions().isEmpty();  // Empty block
    }
    if (container instanceof LoopRegion && loopRegion.isEndless()) {
        return false;  // Keep empty endless loops (e.g., while(true) {})
    }
    if (container instanceof IRegion) {
        // Recursively check all sub-blocks
        for (IContainer subBlock : region.getSubBlocks()) {
            if (!canRemoveRegion(subBlock)) return false;
        }
        return true;  // All children removable -> this region removable
    }
    return false;
}
```

---

## Missing Pass #4: MethodThrowsVisitor

**File:** `/mnt/nvme4tb/dexterity/jadx-fast/jadx-core/src/main/java/jadx/core/dex/visitors/MethodThrowsVisitor.java`
**Lines:** 325
**Priority:** MEDIUM
**Stage:** Regions IR (after RegionMakerVisitor)

### What It Does
Scans methods to collect thrown exceptions for the `throws` clause in method signatures.

### Key Algorithms
1. **processInstructions()** - Scans all blocks for THROW and INVOKE instructions
2. **checkInsn()** - For THROW: get exception type from arg; For INVOKE: recursively check called method
3. **validateException()** - Determines if exception requires `throws` (skip RuntimeException/Error)
4. **mergeExceptions()** - Removes redundant exceptions (if Exception in set, remove subclasses)
5. **isBaseException()** - Uses classpath to check inheritance

### Trick: Exception Hierarchy Filtering
```java
private void mergeExceptions(Set<String> excSet) {
    if (excSet.contains("java.lang.Exception")) {
        excSet.removeIf(e -> !e.equals("java.lang.Exception"));  // Exception covers all
        return;
    }
    // Remove child exceptions when parent is present
    for (String ex1 : excSet) {
        for (String ex2 : excSet) {
            if (isBaseException(ex1, ex2)) {  // ex1 extends ex2
                toRemove.add(ex1);  // Remove the child
            }
        }
    }
}
```

### Trick: Exclude Caught Exceptions
```java
// Don't add exceptions to throws if they're caught in a catch block
CatchAttr catchAttr = block.get(AType.EXC_CATCH);
for (ExceptionHandler handler : catchAttr.getHandlers()) {
    if (handler.isCatchAll()) continue;  // catch(Throwable) catches everything
    excludedExceptions.add(handler.getArgType().toString());
}
```

---

## Missing Pass #5: DebugInfoAttachVisitor

**File:** `/mnt/nvme4tb/dexterity/jadx-fast/jadx-core/src/main/java/jadx/core/dex/visitors/debuginfo/DebugInfoAttachVisitor.java`
**Lines:** 199
**Priority:** MEDIUM
**Stage:** Instructions IR (runs before BlockSplitter, SSATransform)

### What It Does
Attaches debug information (variable names, types, source line numbers) from DEX debug info to instructions and register args.

### Key Algorithms
1. **attachSourceLines()** - Maps bytecode offsets to source line numbers
2. **attachDebugInfo()** - Attaches `RegDebugInfoAttr` to register args based on offset ranges
3. **setMethodSourceLine()** - Sets method's source line from first instruction

### Key Pattern: Attach by Register Number and Offset Range
```java
for (ILocalVar var : localVars) {
    int regNum = var.getRegNum();
    int start = var.getStartOffset();
    int end = var.getEndOffset();
    ArgType type = getVarType(mth, var);
    RegDebugInfoAttr debugInfoAttr = new RegDebugInfoAttr(type, var.getName());

    for (int i = start; i <= end; i++) {
        InsnNode insn = insnArr[i];
        for (InsnArg arg : insn.getArguments()) {
            if (arg.getRegNum() == regNum) {
                arg.addAttr(debugInfoAttr);  // Attach name/type from debug info
            }
        }
    }
}
```

---

## Missing Pass #6: DebugInfoApplyVisitor

**File:** `/mnt/nvme4tb/dexterity/jadx-fast/jadx-core/src/main/java/jadx/core/dex/visitors/debuginfo/DebugInfoApplyVisitor.java`
**Lines:** 243
**Priority:** MEDIUM
**Stage:** Post-Type Inference (after SSATransform, TypeInferenceVisitor)

### What It Does
Applies debug info (types and names) to SSA variables after type inference.

### Key Algorithms
1. **searchAndApplyVarDebugInfo()** - Searches assign and uses for debug info
2. **applyDebugInfo()** - Uses TypeUpdate to apply debug type, sets name on SSAVar
3. **searchDebugInfoByOffset()** - Fallback: search by instruction offset range
4. **fixLinesForReturn()** - Copy source lines from original return to splitter returns
5. **fixNamesForPhiInsns()** - Propagate names across phi instructions
6. **processMethodParametersAttribute()** - Process MethodParameters attribute for arg names

### Trick: Type Update with Validation
```java
public static boolean applyDebugInfo(MethodNode mth, SSAVar ssaVar, ArgType type, String varName) {
    TypeUpdateResult result = mth.root().getTypeUpdate().applyDebugInfo(mth, ssaVar, type);
    if (result == TypeUpdateResult.REJECT) {
        return false;  // Type conflict - don't apply
    }
    if (NameMapper.isValidAndPrintable(varName)) {
        ssaVar.setName(varName);  // Apply name
    }
    return true;
}
```

---

## Missing Pass #7: CollectConstValues

**File:** `/mnt/nvme4tb/dexterity/jadx-fast/jadx-core/src/main/java/jadx/core/dex/visitors/prepare/CollectConstValues.java`
**Lines:** 64
**Priority:** MEDIUM
**Stage:** Pre-Decompile (after UsageInfoVisitor)

### What It Does
Collects static final field values for constant inlining. Only collects unused fields (if field is used, compiler already inlined it).

### Key Algorithm
```java
public static Object getFieldConstValue(FieldNode fld) {
    if (!accFlags.isStatic() || !accFlags.isFinal()) return null;
    EncodedValue constVal = fld.get(JadxAttrType.CONSTANT_VALUE);
    if (constVal == null) return null;
    if (!fld.getUseIn().isEmpty()) {
        return null;  // Field still used - don't restore (compiler didn't inline)
    }
    return constVal.getValue();  // Return the constant value
}
```

---

## Missing Pass #8: ProcessMethodsForInline

**File:** `/mnt/nvme4tb/dexterity/jadx-fast/jadx-core/src/main/java/jadx/core/dex/visitors/ProcessMethodsForInline.java`
**Lines:** 79
**Priority:** MEDIUM
**Stage:** Pre-Decompile (after UsageInfoVisitor)

### What It Does
Marks synthetic methods as candidates for inlining and fixes class dependencies.

### Key Algorithm
```java
private static boolean canInline(MethodNode mth) {
    AccessInfo accessFlags = mth.getAccessFlags();
    boolean isSynthetic = accessFlags.isSynthetic() || mth.getName().contains("$");
    return isSynthetic && canInlineMethod(mth, accessFlags);
}

private static boolean canInlineMethod(MethodNode mth, AccessInfo accessFlags) {
    if (accessFlags.isStatic()) return true;
    return mth.isConstructor() && mth.root().getArgs().isInlineAnonymousClasses();
}
```

### Trick: Fix Class Dependencies for Inline Order
```java
// Remove cross-dependency so inline target is processed first
parentClass.removeDependency(useTopCls);
useTopCls.addCodegenDep(parentClass);
```

---

## Missing Pass #9: InlineMethods

**File:** `/mnt/nvme4tb/dexterity/jadx-fast/jadx-core/src/main/java/jadx/core/dex/visitors/InlineMethods.java`
**Lines:** 194
**Priority:** MEDIUM
**Stage:** Post-Type Inference (after TypeInferenceVisitor, before ModVisitor)

### What It Does
Actually inlines methods that were marked by ProcessMethodsForInline and MarkMethodsForInline.

### Key Algorithms
1. **processInvokeInsn()** - For each INVOKE, check if callee should be inlined
2. **inlineMethod()** - Copy the inline instruction and replace args
3. **replaceRegs()** - Map method args to inline instruction registers
4. **updateUsageInfo()** - Update usage tracking after inline

### Key Pattern: Arg Remapping
```java
private boolean replaceRegs(MethodNode mth, MethodNode callMth, MethodInlineAttr mia,
                            InvokeNode insn, InsnNode inlCopy) {
    InsnArg[] regs = new InsnArg[callMth.getRegsCount()];
    int[] regNums = mia.getArgsRegNums();
    for (int i = 0; i < regNums.length; i++) {
        InsnArg arg = insn.getArg(i);
        regs[regNums[i]] = arg;  // Map method arg to register slot
    }
    // Replace all register args in inlined instruction
    for (RegisterArg r : inlArgs) {
        InsnArg repl = regs[r.getRegNum()];
        inlCopy.replaceArg(r, repl.duplicate());
    }
}
```

---

## Missing Pass #10: MarkMethodsForInline

**File:** `/mnt/nvme4tb/dexterity/jadx-fast/jadx-core/src/main/java/jadx/core/dex/visitors/MarkMethodsForInline.java`
**Lines:** 185
**Priority:** LOW
**Stage:** Final (after FixAccessModifiers, ClassModifier)

### What It Does
Analyzes synthetic methods to determine if they're simple getters/setters/wrappers that can be inlined.

### Key Patterns Detected
1. **Synthetic getter**: `return field.get` (1 insn)
2. **Synthetic setter**: `field.set(arg)` (1 insn)
3. **Synthetic wrapper**: `return method.call(args)` (2 insns)
4. **isSyntheticAccessPattern()** - Validates IGET/SGET/IPUT/SPUT/INVOKE patterns

```java
private static boolean isSyntheticAccessPattern(MethodNode mth, InsnNode firstInsn, InsnNode retInsn) {
    switch (firstInsn.getType()) {
        case IGET:  // instance field getter: return this.field
            return mthRegs.size() == 1
                && retInsn.getArg(0).isSameVar(firstInsn.getResult())
                && firstInsn.getArg(0).isSameVar(mthRegs.get(0));
        case SGET:  // static field getter: return Cls.field
            return mthRegs.isEmpty()
                && retInsn.getArg(0).isSameVar(firstInsn.getResult());
        case IPUT:  // instance field setter with return: this.field = arg; return arg
            return mthRegs.size() == 2 ...
        // etc.
    }
}
```

---

## Missing Pass #11: MoveInlineVisitor

**File:** `/mnt/nvme4tb/dexterity/jadx-fast/jadx-core/src/main/java/jadx/core/dex/visitors/MoveInlineVisitor.java`
**Lines:** 141
**Priority:** MEDIUM
**Stage:** SSA (after SSATransform, before CodeShrinkVisitor)

### What It Does
Inlines redundant MOVE instructions by replacing all uses with the source.

### Key Algorithm
```java
private static boolean processMove(MethodNode mth, InsnNode move) {
    RegisterArg resultArg = move.getResult();
    InsnArg moveArg = move.getArg(0);

    if (resultArg.sameRegAndSVar(moveArg)) return true;  // Self-move, remove

    SSAVar ssaVar = resultArg.getSVar();
    if (ssaVar.getUseList().isEmpty()) return true;  // Unused result, remove
    if (ssaVar.isUsedInPhi()) return false;  // Can't inline into phi

    // Replace all uses of result with source
    for (RegisterArg useArg : ssaVar.getUseList()) {
        InsnArg replaceArg = moveArg.duplicate();
        useInsn.replaceArg(useArg, replaceArg);
    }
    return true;  // Move can be removed
}
```

---

## Missing Pass #12: FixSwitchOverEnum

**File:** `/mnt/nvme4tb/dexterity/jadx-fast/jadx-core/src/main/java/jadx/core/dex/visitors/FixSwitchOverEnum.java`
**Lines:** 297
**Priority:** MEDIUM
**Stage:** Specialized (after CodeShrinkVisitor, EnumVisitor)

### What It Does
Simplifies synthetic code in `switch` statements over enums. Java compilers generate a synthetic int[] mapping for enum switches.

### Key Patterns
1. **Direct enum switch**: `switch(enum.ordinal())` - Replace ordinal with enum field
2. **Remapped enum switch**: `switch(syntheticArr[enum.ordinal()])` - Use EnumMapAttr to decode

### Key Algorithm
```java
private static boolean processDirectEnumSwitch(MethodNode mth, SwitchInsn swInsn,
                                                InvokeNode invInsn, InsnArg arg) {
    if (!callMth.getShortId().equals("ordinal()I")) return false;

    InsnArg invVar = invInsn.getArg(0);  // The enum variable
    EnumClassAttr enumClassAttr = enumCls.get(AType.ENUM_CLASS);

    // Replace ordinal numbers with enum field references
    for (int i = 0; i < caseCount; i++) {
        int ordinal = (Integer) swInsn.getKey(i);
        FieldNode enumField = enumClassAttr.getFields().get(ordinal).getField();
        swInsn.modifyKey(i, enumField);  // Replace 0,1,2 with ENUM_A, ENUM_B, ENUM_C
    }
}
```

### Synthetic Array Detection
```java
private static void initClsEnumMap(ClassNode enumCls) {
    // In <clinit>, find APUT instructions that build the mapping array
    for (InsnNode insn : clsInitMth.getBasicBlocks()) {
        if (insn.getType() == InsnType.APUT) {
            addToEnumMap(mapAttr, insn);  // Record: arr[ordinal] = caseNumber
        }
    }
}
```

---

## Missing Pass #13: SwitchBreakVisitor

**File:** `/mnt/nvme4tb/dexterity/jadx-fast/jadx-core/src/main/java/jadx/core/dex/visitors/regions/SwitchBreakVisitor.java`
**Lines:** 267
**Priority:** MEDIUM
**Stage:** Final (after LoopRegionVisitor)

### What It Does
Optimizes `break` statements in switch regions:
1. Extract common break from all branches to parent
2. Remove unreachable break after return/throw

### Key Algorithm: ExtractCommonBreak
```java
// If all branches end with break (or exit insn), extract to parent
for (IContainer branch : branches) {
    BlockInsnPair last = RegionUtils.getLastInsnWithBlock(branch);
    if (lastInsn.getType() == InsnType.BREAK) {
        forBreakRemove.add(block);  // Remove individual breaks
        removeCommonBreak = false;
    } else if (!lastInsn.isExitEdgeInsn()) {
        removeCommonBreak = false;  // Not all branches exit
    }
}
if (!forBreakRemove.isEmpty()) {
    // Add single break at end of parent region
    addBreakRegion.add(parentRegion);
}
```

### Key Algorithm: RemoveUnreachableBreak
```java
// Remove break after return/throw
if (isBreakBlock(lastBlock) && isPrevInsnIsExit(lastBlock)) {
    removeBreak(lastBlock, region);  // Unreachable break
}
```

---

## Missing Pass #14: ClassModifier

**File:** `/mnt/nvme4tb/dexterity/jadx-fast/jadx-core/src/main/java/jadx/core/dex/visitors/ClassModifier.java`
**Lines:** 358
**Priority:** LOW
**Stage:** Specialized (after ModVisitor, FixAccessModifiers, ProcessAnonymous)

### What It Does
Removes synthetic classes, methods, and fields that are just compiler artifacts.

### Key Functions
1. **isEmptySyntheticClass()** - Remove empty synthetic classes
2. **removeSyntheticFields()** - Remove outer class reference fields
3. **removeSyntheticMethods()** - Remove bridge methods
4. **removeEmptyMethods()** - Remove empty default constructors

### Bridge Method Detection
```java
private static boolean removeBridgeMethod(ClassNode cls, MethodNode mth) {
    InsnNode wrappedInsn = allInsns.get(0);
    if (wrappedInsn.getType() == InsnType.INVOKE) {
        InvokeNode invokeInsn = (InvokeNode) wrappedInsn;
        if (invokeInsn.getInvokeType() == InvokeType.SUPER) return false;

        MethodNode wrappedMth = resolveMethod(invokeInsn.getCallMth());
        // Change visibility and merge names
        FixAccessModifiers.changeVisibility(wrappedMth, AccessFlags.PUBLIC);
        wrappedMth.rename(mth.getAlias());
        return true;  // Remove bridge
    }
}
```

---

## Missing Pass #15: FixAccessModifiers

**File:** `/mnt/nvme4tb/dexterity/jadx-fast/jadx-core/src/main/java/jadx/core/dex/visitors/fixaccessmodifiers/FixAccessModifiers.java`
**Lines:** 121
**Priority:** LOW
**Stage:** Specialized (after ModVisitor)

### What It Does
Changes class and method access modifiers to ensure code compiles correctly.

### Key Rules
1. Top-level classes with private/protected -> public
2. Overriding methods can't have weaker visibility than parent
3. Referenced classes/methods must be visible from usage site

```java
private void fixMethodVisibility(MethodNode mth) {
    MethodOverrideAttr overrideAttr = mth.get(AType.METHOD_OVERRIDE);
    if (overrideAttr != null) {
        AccessInfo parentAccInfo = overrideAttr.getOverrideList().get(0).getRawAccessFlags();
        if (accessFlags.isVisibilityWeakerThan(parentAccInfo)) {
            changeVisibility(mth, parentAccInfo.getVisibility().rawValue());
        }
    }
}
```

---

## Missing Pass #16: ProcessKotlinInternals

**File:** `/mnt/nvme4tb/dexterity/jadx-fast/jadx-core/src/main/java/jadx/core/dex/visitors/kotlin/ProcessKotlinInternals.java`
**Lines:** 233
**Priority:** LOW
**Stage:** Post-Type Inference (after InitCodeVariables, DebugInfoApplyVisitor)

### What It Does
Extracts variable names from Kotlin intrinsic methods like `Intrinsics.checkNotNull(obj, "variableName")`.

### Key Pattern
```java
private void processInvoke(MethodNode mth, InsnNode insn) {
    MethodInfo invokeMth = ((InvokeNode) insn).getCallMth();
    if (!kotlinVarNameSourceMethods.contains(invokeMth)) return;

    RegisterArg varArg = (RegisterArg) insn.getArg(0);
    String str = getConstString(mth, insn, 1);  // Second arg is var name

    if (str != null) {
        varArg.getSVar().getCodeVar().setName(trimName(str));  // Apply name
        if (hideInsns) {
            insn.add(AFlag.DONT_GENERATE);  // Hide the check
        }
    }
}

private String trimName(String str) {
    if (str.startsWith("$this$")) return str.substring(6);
    if (str.startsWith("$")) return str.substring(1);
    return str;
}
```

---

## Missing Pass #17: AddAndroidConstants

**File:** `/mnt/nvme4tb/dexterity/jadx-fast/jadx-core/src/main/java/jadx/core/dex/visitors/prepare/AddAndroidConstants.java`
**Lines:** 45
**Priority:** LOW
**Stage:** Pre-Decompile (before CollectConstValues)

### What It Does
Adds Android resource constants (R.id.xxx, R.string.xxx) from a mapping file.

### Key Algorithm
```java
public void init(RootNode root) {
    if (root.resolveClass("android.R") != null) return;  // Already have R class

    AndroidResourcesMap.getMap().forEach((resId, path) -> {
        // path = "id/button1" -> R$id.button1
        int sep = path.indexOf('/');
        String clsName = "android.R$" + path.substring(0, sep);
        String resName = path.substring(sep + 1);

        ClassInfo cls = ClassInfo.fromName(root, clsName);
        FieldInfo field = FieldInfo.from(root, cls, resName, ArgType.INT);
        constStorage.addGlobalConstField(field, resId);  // Register constant
    });
}
```

---

## Missing Pass #18: AttachCommentsVisitor

**File:** `/mnt/nvme4tb/dexterity/jadx-fast/jadx-core/src/main/java/jadx/core/dex/visitors/AttachCommentsVisitor.java`
**Lines:** 139
**Priority:** LOW
**Stage:** Instructions IR (before ProcessInstructionsVisitor)

### What It Does
Attaches user-provided code comments from `ICodeData` to classes, fields, methods, and instructions.

### Key Algorithm
```java
private static void applyComments(ClassNode cls, List<ICodeComment> clsComments) {
    for (ICodeComment comment : clsComments) {
        switch (nodeRef.getType()) {
            case CLASS: addComment(cls, comment); break;
            case FIELD: addComment(cls.searchFieldByShortId(nodeRef.getShortId()), comment); break;
            case METHOD:
                MethodNode mth = cls.searchMethodByShortId(nodeRef.getShortId());
                IJavaCodeRef codeRef = comment.getCodeRef();
                if (codeRef == null) {
                    addComment(mth, comment);  // Method-level comment
                } else if (codeRef.getAttachType() == CodeRefType.INSN) {
                    InsnNode insn = mth.getInstructions()[codeRef.getIndex()];
                    addComment(insn, comment);  // Instruction-level comment
                }
                break;
        }
    }
}
```

---

## Missing Pass #19: NonFinalResIdsVisitor

**File:** `/mnt/nvme4tb/dexterity/jadx-fast/jadx-core/src/main/java/jadx/core/dex/visitors/gradle/NonFinalResIdsVisitor.java`
**Lines:** 118
**Priority:** LOW
**Stage:** Specialized (after FixSwitchOverEnum)

### What It Does
Detects usage of Android resource constants in switch cases, which requires `android.nonFinalResIds=true` in gradle.

### Key Pattern
```java
private boolean detectSwitchOverResIds(SwitchRegion switchRegion) {
    for (SwitchRegion.CaseInfo caseInfo : switchRegion.getCases()) {
        for (Object key : caseInfo.getKeys()) {
            if (key instanceof FieldNode) {
                ClassNode topParentClass = ((FieldNode) key).getTopParentClass();
                if (AndroidResourcesUtils.isResourceClass(topParentClass)
                    && !"android.R".equals(topParentClass.getFullName())) {
                    gradleInfoStorage.setNonFinalResIds(true);  // Flag for gradle export
                    return false;
                }
            }
        }
    }
}
```

---

## Deobfuscation Passes (5 passes - LOW priority)

These passes only matter for obfuscated APKs:

### #20: DeobfuscatorVisitor
**File:** `/mnt/nvme4tb/dexterity/jadx-fast/jadx-core/src/main/java/jadx/core/deobf/DeobfuscatorVisitor.java`
- Applies ProGuard/R8 mapping files

### #21: SourceFileRename
**File:** `/mnt/nvme4tb/dexterity/jadx-fast/jadx-core/src/main/java/jadx/core/dex/visitors/rename/SourceFileRename.java`
- Renames source files based on deobfuscation

### #22: RenameVisitor
**File:** `/mnt/nvme4tb/dexterity/jadx-fast/jadx-core/src/main/java/jadx/core/dex/visitors/rename/RenameVisitor.java`
- Handles naming collisions

### #23: SaveDeobfMapping
**File:** `/mnt/nvme4tb/dexterity/jadx-fast/jadx-core/src/main/java/jadx/core/deobf/SaveDeobfMapping.java`
- Exports deobfuscation mappings

### #24: CodeRenameVisitor
**File:** `/mnt/nvme4tb/dexterity/jadx-fast/jadx-core/src/main/java/jadx/core/dex/visitors/rename/CodeRenameVisitor.java`
- Applies rename mappings to code

---

## Summary Table

| # | Pass | File | Lines | Priority | Stage |
|---|------|------|-------|----------|-------|
| 1 | SignatureProcessor | SignatureProcessor.java | 337 | HIGH | Pre-Decompile |
| 2 | AnonymousClassVisitor | AnonymousClassVisitor.java | 133 | HIGH | Post-Type |
| 3 | CleanRegions | regions/CleanRegions.java | 65 | MEDIUM | Regions |
| 4 | MethodThrowsVisitor | MethodThrowsVisitor.java | 325 | MEDIUM | Regions |
| 5 | DebugInfoAttachVisitor | debuginfo/DebugInfoAttachVisitor.java | 199 | MEDIUM | Instructions |
| 6 | DebugInfoApplyVisitor | debuginfo/DebugInfoApplyVisitor.java | 243 | MEDIUM | Post-Type |
| 7 | CollectConstValues | prepare/CollectConstValues.java | 64 | MEDIUM | Pre-Decompile |
| 8 | ProcessMethodsForInline | ProcessMethodsForInline.java | 79 | MEDIUM | Pre-Decompile |
| 9 | InlineMethods | InlineMethods.java | 194 | MEDIUM | Post-Type |
| 10 | MarkMethodsForInline | MarkMethodsForInline.java | 185 | LOW | Final |
| 11 | MoveInlineVisitor | MoveInlineVisitor.java | 141 | MEDIUM | SSA |
| 12 | FixSwitchOverEnum | FixSwitchOverEnum.java | 297 | MEDIUM | Specialized |
| 13 | SwitchBreakVisitor | regions/SwitchBreakVisitor.java | 267 | MEDIUM | Final |
| 14 | ClassModifier | ClassModifier.java | 358 | LOW | Specialized |
| 15 | FixAccessModifiers | fixaccessmodifiers/FixAccessModifiers.java | 121 | LOW | Specialized |
| 16 | ProcessKotlinInternals | kotlin/ProcessKotlinInternals.java | 233 | LOW | Post-Type |
| 17 | AddAndroidConstants | prepare/AddAndroidConstants.java | 45 | LOW | Pre-Decompile |
| 18 | AttachCommentsVisitor | AttachCommentsVisitor.java | 139 | LOW | Instructions |
| 19 | NonFinalResIdsVisitor | gradle/NonFinalResIdsVisitor.java | 118 | LOW | Specialized |
| 20-24 | Deobfuscation (5) | Various | ~600 | LOW | Pre-Decompile |

**Total Missing Lines:** ~3,700 lines of Java

---

## Base Path for All Files
```
/mnt/nvme4tb/dexterity/jadx-fast/jadx-core/src/main/java/jadx/core/dex/visitors/
```

## Dexterity Passes Location
```
/mnt/nvme4tb/dexterity/crates/dexterity-passes/src/
```
