# JADX Codegen Clone Master Document

**Date:** 2025-12-23
**Author:** Claude Code Clone Specialist
**Status:** ACTIVE - Critical parity gaps identified

---

## Executive Summary

This document provides **line-by-line JADX source code references** for cloning codegen functionality into dexterity. The goal is not to "improve" but to achieve **exact behavioral parity** with JADX's 10+ years of edge case handling.

### Critical Finding: Semantic Bugs in Output

Direct output comparison (`output/jadx/` vs `output/dexterity/`) reveals:
- **Undefined variable references** (code won't compile)
- **Field initialization logic bugs** (runtime failures)
- **Constructor assignments lost** (data corruption)
- **Type information missing** (raw types instead of generics)

These are NOT cosmetic issues - they produce **broken Java code**.

---

## JADX Codegen Architecture (Reference)

```
jadx-fast/jadx-core/src/main/java/jadx/core/codegen/
├── CodeGen.java           # Entry point
├── ClassGen.java          # Class declarations, imports (887 lines)
├── MethodGen.java         # Method signatures, bodies (570 lines)
├── InsnGen.java           # Instruction expressions (1237 lines)
├── RegionGen.java         # Control flow regions (385 lines)
├── ConditionGen.java      # Condition expressions
├── NameGen.java           # Variable naming (117 lines)
├── TypeGen.java           # Type formatting
├── AnnotationGen.java     # Annotations
├── SimpleModeHelper.java  # Fallback mode
└── utils/
    ├── CodeGenUtils.java  # Utilities
    └── CodeComment.java   # Comments
```

---

## Clone Task Priority Matrix

| Priority | ID | Gap | JADX Reference | Dexterity File | Lines to Clone |
|----------|-----|-----|----------------|----------------|----------------|
| **P0-CRITICAL** | CG-001 | Field initialization tracking | InsnGen.java:149-180 | body_gen.rs | ~100 |
| **P0-CRITICAL** | CG-002 | Variable SSA->CodeVar mapping | NameGen.java:50-60 | expr_gen.rs | ~50 |
| **P0-CRITICAL** | CG-003 | Constructor field assignment | InsnGen.java:727-783 | body_gen.rs | ~100 |
| **P1-HIGH** | CG-004 | Static invoke same-class elision | InsnGen.java:889-896 | body_gen.rs | ~30 |
| **P1-HIGH** | CG-005 | Ternary expression generation | InsnGen.java:1174-1194 | body_gen.rs | ~50 |
| **P1-HIGH** | CG-006 | For-each loop body preservation | RegionGen.java:199-210 | body_gen.rs | ~50 |
| **P2-MEDIUM** | CG-007 | StringBuilder chain simplify | SimplifyVisitor (pass) | passes | ~150 |
| **P2-MEDIUM** | CG-008 | Else-return elimination | ReturnVisitor (pass) | passes | ~80 |
| **P2-MEDIUM** | CG-009 | Nested if flattening | IfMakerHelper (pass) | passes | ~100 |
| **P3-LOW** | CG-010 | Private constructor detection | ClassGen pattern | class_gen.rs | ~30 |

---

## P0-CRITICAL: Clone Tasks (Code Won't Compile/Run)

### CG-001: Field Initialization Tracking Bug

**Symptom:** Field assigned in constructor but shows as `null` at declaration.

**JADX Reference:** `InsnGen.java:149-180` - `declareVar()` and `assignVar()`
```java
// InsnGen.java:149-156
public void assignVar(ICodeWriter code, InsnNode insn) throws CodegenException {
    RegisterArg arg = insn.getResult();
    if (insn.contains(AFlag.DECLARE_VAR)) {
        declareVar(code, arg);  // Emit type + name
    } else {
        addArg(code, arg, false);  // Just name
    }
}
```

**Bug in Dexterity:**
```java
// WRONG: Field initialized at declaration AND in constructor
private final Collection<m> a = null;  // Always null!
b(Collection<m> collection) {
    this.a = collection;  // Only in else branch
}

// JADX CORRECT:
private final Collection<m> a;  // No initializer
b(Collection<m> collection) {
    if (collection == null || collection.size() == 0) {
        this.a = null;
    } else {
        this.a = collection;
    }
}
```

**Clone Task:**
- Track which fields are initialized in constructors
- Don't emit initializer at declaration if constructor assigns
- Reference: `ClassGen.java:462-485` field initialization logic

---

### CG-002: Variable SSA->CodeVar Mapping Bug

**Symptom:** `data2` is undefined - wrong variable reference.

**JADX Reference:** `NameGen.java:50-60` - `assignArg()` with CodeVar
```java
// NameGen.java:50-60
public String assignArg(CodeVar var) {
    if (fallback) {
        return getFallbackName(var);
    }
    if (var.isThis()) {
        return RegisterArg.THIS_ARG_NAME;
    }
    String name = getUniqueVarName(makeArgName(var));
    var.setName(name);
    return name;
}
```

**Bug in Dexterity:**
```java
// WRONG: Uses undefined variable
if (cls.isInstance(data2)) {  // data2 doesn't exist!
    return cls.cast(this.data);
}

// JADX CORRECT:
if (cls.isInstance(this.data)) {
    return cls.cast(this.data);
}
```

**Clone Task:**
- SSA versions must map to consistent CodeVar names
- Use `this.` prefix for instance field access
- Track when register refers to field vs local
- Reference: `InsnGen.java:186-213` instance field access

---

### CG-003: Constructor Field Assignment Bug

**Symptom:** Constructor creates local variable, never assigns to field.

**JADX Reference:** `InsnGen.java:727-783` - `makeConstructor()`
```java
// InsnGen.java:783
generateMethodArguments(code, insn, 0, callMth);
```

And the IPUT handling:
```java
// InsnGen.java:483-489
case IPUT: {
    FieldInfo fieldInfo = (FieldInfo) ((IndexInsnNode) insn).getIndex();
    instanceField(code, fieldInfo, insn.getArg(1));
    code.add(" = ");
    addArg(code, insn.getArg(0), false);
    break;
}
```

**Bug in Dexterity:**
```java
// WRONG: Handler created but discarded
public a() {
    super();
    final Handler handler = new Handler(Looper.getMainLooper());  // Created but never assigned!
}
private final Handler a = new Handler();  // Wrong: no Looper

// JADX CORRECT:
private final Handler a = new Handler(Looper.getMainLooper());
// No constructor needed - field initializer is correct
```

**Clone Task:**
- Detect field initialization in `<init>` methods
- Combine NEW-INSTANCE + INVOKE-DIRECT + IPUT sequences
- Emit field initializer at declaration when possible
- Reference: `FieldInitInsnAttr` pattern in ClassGen

---

## P1-HIGH: Clone Tasks (Wrong Behavior)

### CG-004: Static Invoke Same-Class Elision

**JADX Reference:** `InsnGen.java:889-896`
```java
// InsnGen.java:889-896
case STATIC:
    ClassInfo insnCls = mth.getParentClass().getClassInfo();
    ClassInfo declClass = callMth.getDeclClass();
    if (!insnCls.equals(declClass)) {
        useClass(code, declClass);
        code.add('.');
    }
    break;
```

**Bug in Dexterity:**
```java
// WRONG: Redundant class prefix
Assert.isAssignable(cls, cls2, "");

// JADX CORRECT (within Assert class):
isAssignable(cls, cls2, "");
```

**Clone Task:**
- Compare current class with invoke target class
- Omit class prefix for same-class static calls
- ~30 lines in body_gen.rs invoke handling

---

### CG-005: Ternary Expression Generation

**JADX Reference:** `InsnGen.java:1174-1194`
```java
// InsnGen.java:1174-1194
private void makeTernary(TernaryInsn insn, ICodeWriter code, Set<Flags> state) throws CodegenException {
    boolean wrap = state.contains(Flags.BODY_ONLY);
    if (wrap) {
        code.add('(');
    }
    InsnArg first = insn.getArg(0);
    InsnArg second = insn.getArg(1);
    ConditionGen condGen = new ConditionGen(this);
    if (first.isTrue() && second.isFalse()) {
        condGen.add(code, insn.getCondition());
    } else {
        condGen.wrap(code, insn.getCondition());
        code.add(" ? ");
        addArg(code, first, false);
        code.add(" : ");
        addArg(code, second, false);
    }
    if (wrap) {
        code.add(')');
    }
}
```

**Bug in Dexterity:**
```java
// WRONG: Undefined variable and lost ternary
if (object != null) {
    String object3 = object.getClass().getName();
} else {
    String object4 = "null";
}
stringBuilder.append(object2);  // object2 UNDEFINED!

// JADX CORRECT:
stringBuilder.append(obj != null ? obj.getClass().getName() : "null");
```

**Clone Task:**
- TernaryInsn detection in passes (TernaryMod)
- Proper condition wrapping
- Result variable propagation
- Reference: `TernaryMod.java` pass for pattern detection

---

### CG-006: For-Each Loop Body Preservation

**JADX Reference:** `RegionGen.java:199-210`
```java
// RegionGen.java:199-210
if (type instanceof ForEachLoop) {
    ForEachLoop forEachLoop = (ForEachLoop) type;
    code.add("for (");
    declareVar(code, forEachLoop.getVarArg());
    code.add(" : ");
    addArg(code, forEachLoop.getIterableArg(), false);
    code.add(") {");
    CodeGenUtils.addCodeComments(code, mth, condInsn);
    makeRegionIndent(code, region.getBody());  // KEY: Body generation
    code.startLine('}');
    return;
}
```

**Bug in Dexterity:**
```java
// WRONG: Empty loop body
for (Object length : objectArr) {
}

// JADX CORRECT:
for (Object obj : objArr) {
    if (obj == null) {
        throw new IllegalArgumentException(str);
    }
}
```

**Clone Task:**
- ForEachLoop body region not being passed to makeRegionIndent
- Loop body blocks being excluded from body region
- Reference: `LoopRegionVisitor.java` for body assembly

---

## P2-MEDIUM: Clone Tasks (Suboptimal Output)

### CG-007: StringBuilder Chain Simplification

**JADX Reference:** `SimplifyVisitor.java:369-428` (PASS, not codegen)
```java
// SimplifyVisitor.java:369-428
private static InsnNode convertStringBuilderChain(MethodNode mth, InvokeNode toStrInsn, List<InsnNode> chain) {
    // 1. Collect all arguments from StringBuilder constructor + append() calls
    // 2. Verify at least one String argument exists
    // 3. Concatenate consecutive constant strings
    // 4. Create STR_CONCAT instruction with all args
    InsnNode concatInsn = new InsnNode(InsnType.STR_CONCAT, simplifiedArgs);
    return concatInsn;
}
```

**Bug in Dexterity:**
```java
// WRONG: Verbose
StringBuilder stringBuilder = new StringBuilder();
stringBuilder.append("Action{actionType='");
stringBuilder.append(this.actionType);
// ... 6 more lines

// JADX CORRECT:
return "Action{actionType='" + this.actionType + "', data=" + this.data + '}';
```

**Clone Task:**
- Create `simplify_stringbuilder.rs` pass
- Track StringBuilder chain: new -> append* -> toString
- Convert to STR_CONCAT instruction
- ~150 lines of pass code

---

### CG-008: Else-Return Elimination

**JADX Reference:** `ReturnVisitor.java:41-54` (PASS)
```java
// ReturnVisitor.java:41-54
public void processBlockTraced(MethodNode mth, IBlock container, IRegion currentRegion) {
    if (block.contains(AFlag.RETURN)) {
        List<InsnNode> insns = block.getInstructions();
        if (insns.size() == 1
                && blockNotInLoop(mth, block)
                && noTrailInstructions(block)) {
            insns.remove(0);
            block.remove(AFlag.RETURN);
        }
    }
}
```

**Bug in Dexterity:**
```java
// WRONG: Redundant else-return
if (!Strings.hasLength(str)) {
    throw new IllegalArgumentException(str2);
} else {
    return;
}

// JADX CORRECT:
if (!Strings.hasLength(str)) {
    throw new IllegalArgumentException(str2);
}
```

**Clone Task:**
- Enhance `return_visitor.rs`
- Key: `noTrailInstructions()` check
- Remove return if nothing follows in region
- ~80 lines of pass code

---

### CG-009: Nested If Flattening

**JADX Reference:** `IfMakerHelper.java` (PASS)

**Bug in Dexterity:**
```java
// WRONG: Nested
if (Strings.hasLength(str) && Strings.hasLength(str2)) {
    if (str.indexOf(str2) != -1) {
        throw new IllegalArgumentException(str3);
    }
}

// JADX CORRECT:
if (Strings.hasLength(str) && Strings.hasLength(str2) && str.indexOf(str2) != -1) {
    throw new IllegalArgumentException(str3);
}
```

**Clone Task:**
- Detect `if (A) { if (B) { BODY } }` pattern
- Merge when outer has no else branch
- ~100 lines of pass code

---

## JADX InsnGen.java Clone Reference (1237 lines)

### Instruction Switch Statement (lines 315-651)

Each case needs verification in dexterity `expr_gen.rs`:

| InsnType | JADX Lines | Dexterity Status |
|----------|-----------|------------------|
| CONST_STR | 316-319 | ✅ Implemented |
| CONST_CLASS | 321-325 | ✅ Implemented |
| CONST | 327-330 | ✅ Implemented |
| MOVE | 332-334 | ✅ Implemented |
| CHECK_CAST/CAST | 336-350 | ✅ Implemented |
| ARITH | 352-354 | ✅ Implemented |
| NEG | 356-358 | ✅ Implemented |
| NOT | 360-363 | ✅ Implemented |
| RETURN | 365-372 | ✅ Implemented |
| BREAK | 374-380 | ⚠️ Check loop labels |
| CONTINUE | 382-384 | ✅ Implemented |
| THROW | 386-389 | ✅ Implemented |
| CMP_L/CMP_G | 391-402 | ⚠️ Verify ternary output |
| INSTANCE_OF | 404-416 | ✅ Implemented |
| CONSTRUCTOR | 417-419 | ❌ **BUG: CG-003** |
| INVOKE | 421-423 | ⚠️ Check same-class static |
| NEW_ARRAY | 425-441 | ✅ Implemented |
| ARRAY_LENGTH | 443-446 | ✅ Implemented |
| FILLED_NEW_ARRAY | 448-449 | ✅ Implemented |
| FILL_ARRAY | 451-461 | ⚠️ Verify fallback |
| AGET | 463-467 | ✅ Implemented |
| APUT | 469-476 | ✅ Implemented |
| IGET | 478-482 | ✅ Implemented |
| IPUT | 483-489 | ⚠️ **Check field tracking** |
| SGET | 491-492 | ✅ Implemented |
| SPUT | 493-499 | ✅ Implemented |
| STR_CONCAT | 501-516 | ⚠️ **Needs pass to create** |
| MONITOR_ENTER/EXIT | 517-534 | ✅ Fallback only |
| TERNARY | 536-537 | ❌ **BUG: CG-005** |
| ONE_ARG | 539-541 | ✅ Implemented |

### Constructor Generation (lines 727-848)

```java
// Critical logic to clone:
// 1. Anonymous class detection (729-732)
// 2. Self invoke removal (733-735)
// 3. Method resolution (736-743)
// 4. super/this handling (745-750)
// 5. Outer class instance (752-804)
// 6. Inline anonymous constructor (806-848)
```

### Invoke Generation (lines 850-936)

```java
// Critical logic to clone:
// 1. InvokeType dispatch (852-897)
// 2. STATIC same-class elision (889-896) - BUG CG-004
// 3. Method annotation attachment (898-909)
// 4. Argument generation (910)
```

---

## JADX RegionGen.java Clone Reference (385 lines)

### If Region (lines 103-147)

```java
// Clone checklist:
// 1. Source line attachment (104-108)
// 2. Comment-out mode (109-112)
// 3. Condition generation (114-116)
// 4. Metadata attachment (117-125)
// 5. Then region indent (126)
// 6. Else-if chain connection (136-138) - Important!
// 7. Else region (139-145)
```

### Loop Region (lines 164-229)

```java
// Clone checklist:
// 1. Loop label emission (166-169)
// 2. Infinite loop detection (172-178)
// 3. ForLoop type handling (185-198)
// 4. ForEachLoop type handling (199-210) - BUG CG-006
// 5. Do-while detection (213-220)
// 6. While loop (221-227)
```

### Switch Region (lines 244-271)

```java
// Clone checklist:
// 1. Switch header (248-253)
// 2. Case iteration (255-268)
// 3. Default case key handling (259-260)
// 4. Enum field handling (274-311)
```

### Try-Catch Region (lines 313-384)

```java
// Clone checklist:
// 1. Try block (314-319)
// 2. Catch-all handler ordering (322-336)
// 3. Finally region (337-341)
// 4. Catch type union (354-361)
// 5. Exception arg naming (364-377)
```

---

## Clone Implementation Guide

### Standard Comment Format

When cloning JADX code, use this format:

```rust
/// Clone of JADX InsnGen.makeConstructor()
/// Generates constructor invocations with proper new instance handling.
///
/// Reference: jadx-fast/jadx-core/src/main/java/jadx/core/codegen/InsnGen.java:727-783
fn make_constructor(&mut self, insn: &ConstructorInsn) -> String {
    // JADX parity: Check for anonymous class first (line 729)
    if self.is_anonymous_class(&insn.class_type) {
        return self.inline_anonymous_constructor(insn);
    }
    // ...
}
```

### Testing Parity

```bash
# Regenerate outputs
./target/release/dexterity -d output/dexterity/large large.apk
jadx -d output/jadx/large large.apk

# Compare specific file
diff -u output/jadx/large/sources/o/b/a.java \
       output/dexterity/large/sources/o/b/a.java
```

---

## File Mapping: JADX Java -> Dexterity Rust

| JADX File | Dexterity File | Lines | Parity |
|-----------|----------------|-------|--------|
| InsnGen.java | expr_gen.rs + body_gen.rs | 1237 | 70% |
| RegionGen.java | body_gen.rs (regions) | 385 | 75% |
| ClassGen.java | class_gen.rs | 887 | 85% |
| MethodGen.java | method_gen.rs | 570 | 80% |
| NameGen.java | expr_gen.rs (naming) | 117 | 60% |
| ConditionGen.java | body_gen.rs (conditions) | ~200 | 70% |
| TypeGen.java | type_gen.rs | ~300 | 90% |
| AnnotationGen.java | method_gen.rs (annotations) | ~400 | 75% |
| SimpleModeHelper.java | fallback_gen.rs | ~150 | 80% |

---

## Implementation Order

1. **CG-001, CG-002, CG-003** - Fix compilation/runtime bugs first
2. **CG-004, CG-005, CG-006** - Fix wrong behavior
3. **CG-007, CG-008, CG-009** - Optimize output quality
4. **CG-010** - Polish

Each clone task should:
1. Read JADX source at specified line range
2. Understand the algorithm completely
3. Write equivalent Rust with JADX reference comments
4. Test against output comparison
5. Document in JADX_CODEGEN_CLONE_STATUS.md

---

---

## P0-CRITICAL: Additional Gaps Found (2025-12-23)

### CG-011: Outer Class Reference (this$0 → OuterClass.this)

**Symptom:** Dexterity exposes synthetic `this.this$0` instead of `OuterClass.this`

**JADX Reference:**
- `InsnGen.java:186-213` - `instanceField()` method with `FieldReplaceAttr`
- `ClassModifier.java:80-149` - `removeSyntheticFields()` + `removeFieldUsageFromConstructor()`

```java
// InsnGen.java:191-202
FieldReplaceAttr replace = fieldNode.get(AType.FIELD_REPLACE);
if (replace != null) {
    switch (replace.getReplaceType()) {
        case CLASS_INSTANCE:
            useClass(code, replace.getClsRef());
            code.add(".this");  // <-- KEY: Emit OuterClass.this
            break;
        case VAR:
            addArg(code, replace.getVarRef());
            break;
    }
    return;
}
```

**Bug in Dexterity:**
```java
// WRONG: Exposes synthetic field
this.this$0.tempFileManagerFactory.create()
```

**JADX CORRECT:**
```java
NanoHTTPD.this.tempFileManagerFactory.create()
```

**Clone Task:**
1. Add `FieldReplaceAttr` equivalent to `dexterity-ir`
2. In `ClassModifier` equivalent pass, mark `this$N` fields with CLASS_INSTANCE replacement
3. In `expr_gen.rs` field access, check for replacement and emit `OuterClass.this`

---

### CG-012: Constructor Synthetic Parameter Filtering

**Symptom:** Dexterity exposes synthetic constructor parameters for inner classes

**JADX Reference:** `ClassModifier.java:112-149` - `removeFieldUsageFromConstructor()`

```java
// ClassModifier.java:137-139
mth.skipFirstArgument();  // <-- KEY: removes synthetic param
InsnRemover.remove(mth, block, insn);  // removes field store
```

**Bug in Dexterity:**
```java
// WRONG: Exposes synthetic outer class parameter
ClientHandler(NanoHTTPD nanoHTTPD, InputStream inputStream, Socket socket) {
    this.this$0 = nanoHTTPD;  // <-- WRONG: exposed
```

**JADX CORRECT:**
```java
private ClientHandler(InputStream inputStream, Socket socket) {
    this.inputStream = inputStream;
```

**Clone Task:**
1. Add `SkipMethodArgsAttr` equivalent to `dexterity-ir`
2. Create `ClassModifier` pass in `dexterity-passes` that:
   - Detects synthetic this$N fields in inner classes
   - Finds constructor that stores outer class reference as first arg
   - Marks field as DONT_GENERATE, marks method to skip first arg
   - Removes IPUT instruction storing outer reference

---

### CG-013: Inner Class Simple Naming in Same Outer Scope

**Symptom:** Dexterity uses fully qualified inner class names within same outer class

**JADX Reference:** `ClassGen.java:433-460` - `addClsName()` + `addClsShortNameForced()`

**Bug in Dexterity:**
```java
// WRONG: Qualified when simple name suffices
NanoHTTPD.HTTPSession hTTPSession = new NanoHTTPD.HTTPSession(...)
protected NanoHTTPD.AsyncRunner asyncRunner;
```

**JADX CORRECT:**
```java
HTTPSession hTTPSession = NanoHTTPD.this.new HTTPSession(...)
protected AsyncRunner asyncRunner;
```

**Clone Task:**
1. Track current outer class context in codegen state
2. When referencing inner class of current outer, use simple name
3. Handle `OuterClass.this.new InnerClass()` syntax for inner class construction

---

### CG-014: Static Field Initializer Inlining

**Symptom:** Dexterity separates static field declarations from their initializers

**JADX Reference:** `ClassGen.java:462-485` - field initialization with `FieldInitInsnAttr`

**Bug in Dexterity:**
```java
// WRONG: Separated declaration and initialization
private static final Pattern CHARSET_PATTERN;
static {
    CHARSET_PATTERN = Pattern.compile(CHARSET_REGEX, 2);
}
```

**JADX CORRECT:**
```java
private static final Pattern CHARSET_PATTERN = Pattern.compile(CHARSET_REGEX, 2);
```

**Clone Task:**
1. In `<clinit>` processing, detect simple field initialization patterns
2. Attach `FieldInitInsnAttr` to fields with simple initializers
3. In field codegen, emit inline initializer instead of bare declaration

---

### CG-015: Constant Field Resolution for Imports

**Symptom:** JADX resolves literal constants to source class fields (adds imports)

**JADX Reference:** `AndroidResourcesUtils.handleAppResField()` + constant propagation

**Bug in Dexterity:**
```java
// WRONG: Uses literal string, no import
import java.io.File;
// ... uses literal "content-type"
```

**JADX CORRECT:**
```java
import com.mihoyo.astrolabe.upload.base.utils.HttpHeaders;
// ... uses HttpHeaders.CONTENT_TYPE
```

**Clone Task:**
1. Add constant field database to `DexInfoProvider`
2. When emitting string/int literal, check if matches public static final field
3. If match found, emit field reference and add import

---

## JADX ClassModifier.java Clone Reference

Critical visitor for synthetic removal. **Must be cloned entirely.**

```java
// ClassModifier.java Key Methods:
//
// 1. removeSyntheticFields() - lines 80-110
//    - Detects synthetic fields (this$0, val$)
//    - Checks if field type is outer class
//    - Calls removeFieldUsageFromConstructor()
//    - Sets field.add(AFlag.DONT_GENERATE)
//    - Sets FieldReplaceAttr with CLASS_INSTANCE
//
// 2. removeFieldUsageFromConstructor() - lines 112-149
//    - Finds first IPUT that stores outer class reference
//    - Calls mth.skipFirstArgument()
//    - Removes IPUT instruction
//    - Wraps remaining uses with IGET
//
// 3. removeSyntheticMethods() - lines 151-179
//    - Removes bridge methods
//    - Handles synthetic constructor for inner classes
//
// 4. removeBridgeMethod() - lines 243-258
//    - Detects simple wrapper methods
//    - Delegates to checkSyntheticWrapper()
```

---

## Implementation Priority Order (Updated)

### Phase 1: Critical Synthetic Removal (CG-011, CG-012, CG-013)
This is **THE MOST IMPORTANT** gap. It affects every inner class.

1. Add `FieldReplaceAttr` to dexterity-ir (new attribute type)
2. Create `ClassModifier` equivalent pass in dexterity-passes
3. Update `expr_gen.rs` for outer class reference replacement
4. Update `method_gen.rs` for constructor arg skipping

### Phase 2: Field Initialization (CG-014)
Second priority - affects static field output quality.

### Phase 3: Existing Critical Bugs (CG-001, CG-002, CG-003)
The issues identified by previous analysis.

### Phase 4: Quality Improvements (CG-004 through CG-010)
As documented above.

---

---

## Additional Gaps Found (2025-12-23 Audit)

### CG-016: super() Elision for Default Object Constructor
**JADX Reference**: `InsnGen.java:745-747`

JADX doesn't emit `super()` when calling java.lang.Object's default constructor:

```java
// JADX output:
public a(String str) {
    this.actionType = str;
    this.data = null;
}

// Dexterity output (WRONG):
public a(String str) {
    super();  // <-- Should NOT be here for Object constructor
    this.actionType = str;
    this.data = null;
}
```

**Clone Task:**
1. Check if super call target is `java/lang/Object.<init>()V`
2. Skip generating `super()` when calling Object's default constructor
3. Location: `body_gen.rs` constructor call handling

---

### CG-017: @Override Annotation with Source Method Comment
**JADX Reference**: `MethodGen.java:191-207` - `addOverrideAnnotation()`

```java
// MethodGen.java:196-207
if (!overrideAttr.getBaseMethods().contains(mth)) {
    code.startLine("@Override");
    if (mth.checkCommentsLevel(CommentsLevel.INFO)) {
        code.add(" // ");
        code.add(Utils.listToString(overrideAttr.getOverrideList(), ", ",
                o -> o.getDeclaringClass().getClassInfo().getShortName()));
    }
}
```

**Bug in Dexterity:**
```java
// WRONG:
public void a(a<?> aVar) {

// JADX CORRECT:
@Override // o.b.e
public void a(o.b.a<?> aVar) {
```

**Clone Task:**
1. Implement override detection (compare method signature against parent class/interfaces)
2. Generate `@Override // SourceClass` comment
3. Location: `method_gen.rs`

---

### CG-018: Field Rename Comments
**JADX Reference**: `ClassGen.java:450-452`, `CodeGenUtils.addRenamedComment()`

```java
// CodeGenUtils.addRenamedComment()
if (classInfo.hasAlias() && cls.checkCommentsLevel(CommentsLevel.INFO)) {
    CodeGenUtils.addRenamedComment(code, cls, classInfo.getType().getObject());
}
```

**Bug in Dexterity:**
```java
// WRONG:
final e c;

// JADX CORRECT:
/* renamed from: c, reason: collision with root package name */
final /* synthetic */ e f6398c;
```

**Clone Task:**
1. Track original field names before renaming
2. Detect reasons for rename (collision, deobfuscation)
3. Generate `/* renamed from: X, reason: Y */` comment
4. Location: `class_gen.rs` field generation

---

### CG-019: Synthetic Field/Method Comments
**JADX Reference**: AccessFlags handling + comments

```java
// JADX adds synthetic marker:
final /* synthetic */ j a;
```

**Clone Task:**
1. Check `ACC_SYNTHETIC` flag on fields/methods
2. Add `/* synthetic */` inline comment
3. Location: `class_gen.rs`, `method_gen.rs`

---

### CG-020: Access Modifier Change Comments
**JADX Reference**: `CodeGenUtils.java` access change tracking

```java
// JADX output:
/* JADX INFO: Access modifiers changed from: private */
public void b(o.b.a<?> aVar, j jVar, f fVar, e eVar, Iterator<m> it) {
```

This happens when JADX changes visibility for access bridge methods.

**Clone Task:**
1. Track original access flags from DEX
2. Detect when codegen modifies visibility
3. Generate `/* JADX INFO: Access modifiers changed from: X */` comment
4. Location: `method_gen.rs`

---

### CG-021: STR_CONCAT Instruction Generation (Upgrade from CG-007)

**JADX Reference**: `SimplifyVisitor.java:369-428` + `InsnGen.java:501-515`

JADX converts StringBuilder chains to `InsnType.STR_CONCAT`:
```java
// SimplifyVisitor detects:
StringBuilder sb = new StringBuilder();
sb.append("A");
sb.append(var);
sb.append("B");
return sb.toString();

// Converts to STR_CONCAT which InsnGen renders as:
return "A" + var + "B";
```

**Clone Task:**
1. Add `SimplifyStringBuilder` pass in `dexterity-passes`
2. Pattern match: `new StringBuilder` -> `append*` -> `toString`
3. Create `StrConcat` instruction type in dexterity-ir
4. Handle in `body_gen.rs` with `" + "` separator

---

### CG-022: Qualified Type Names in Same Class
**JADX Reference**: `InsnGen.java:889-896` (static invoke), `ClassGen.useClassInternal()`

```java
// JADX within same class:
b(aVar, jVar, fVar, eVar, collection.iterator());

// Dexterity WRONG:
this.b(aVar, jVar, fVar, eVar, this.a.iterator());
```

**Clone Task:**
1. Check if method/field access is within same class
2. Skip `this.` prefix for instance method calls
3. Skip class prefix for static calls in same class
4. Location: `body_gen.rs` invoke handling

---

## Summary: Priority Matrix Update

| Priority | Tasks | Impact |
|----------|-------|--------|
| **P0** | CG-011, CG-012, CG-016, CG-022 | Code won't compile |
| **P1** | CG-013, CG-014, CG-017, CG-021 | Wrong behavior |
| **P2** | CG-018, CG-019, CG-020 | Missing comments |
| **P3** | Others | Polish |

---

## Implementation Status (2025-12-23 Audit)

| Task ID | Description | Status | Location |
|---------|-------------|--------|----------|
| CG-016 | super() elision for Object.<init>() | ✅ DONE | body_gen.rs:8331-8342, 8373-8383 |
| CG-017 | @Override with source class comment | ✅ DONE | method_gen.rs:636-638 |
| CG-019 | /* synthetic */ field/method comments | ✅ DONE | class_gen.rs:1496-1501, method_gen.rs:693-698 |
| CG-021 | STR_CONCAT (StringBuilder folding) | ✅ DONE | simplify_stringbuilder.rs, body_gen.rs:9793 |
| CG-022 | Skip this. for same-class methods | ✅ DONE | body_gen.rs:8378-8391 |
| CG-011 | Outer class reference (this$0) | 🔄 PARTIAL | body_gen.rs:7124-7135 |
| CG-012 | Constructor synthetic param filter | ⏳ PENDING | - |
| CG-013 | Inner class simple naming | ⏳ PENDING | - |
| CG-014 | Static field initializer inlining | ⏳ PENDING | - |
| CG-018 | Field rename comments | ✅ DONE | class_gen.rs:1468-1486 |
| CG-020 | Access modifier change comments | ⏳ PENDING | - |

---

## Related Documents

- [JADX_CODEGEN_REAL_GAPS.md](JADX_CODEGEN_REAL_GAPS.md) - Output comparison evidence
- [JADX_CODEGEN_PARITY.md](JADX_CODEGEN_PARITY.md) - Feature parity status
- [QUALITY_STATUS.md](QUALITY_STATUS.md) - Overall quality grades
- [ROADMAP.md](ROADMAP.md) - Implementation priorities
