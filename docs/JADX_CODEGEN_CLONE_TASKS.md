# JADX Codegen Clone Tasks

**Status: ~95% Complete (Dec 23, 2025 Deep Source Verification Pass)**

Fresh source-level verification of JADX codegen features in dexterity-codegen Rust implementation.
All verification items cross-checked via direct source code reading of jadx-fast source.

**Philosophy**: We are NOT rewriting or improving JADX. We are CLONING 10 years of battle-tested decompilation logic.

**Reference Path**: `/mnt/nvme4tb/dexterity/jadx-fast/jadx-core/src/main/java/jadx/core/codegen/`

---

## JADX Source File Summary (Total: ~3970 lines)

| File | Lines | Purpose | Dexterity Equivalent |
|------|-------|---------|---------------------|
| `InsnGen.java` | 1237 | Instructions -> expressions | `body_gen.rs`, `expr_gen.rs` |
| `ClassGen.java` | 887 | Class structure, imports | `class_gen.rs` |
| `MethodGen.java` | 570 | Method signatures, fallback | `method_gen.rs` |
| `RegionGen.java` | 385 | Control flow (loops, switch) | `body_gen.rs` |
| `AnnotationGen.java` | 226 | Annotation encoding | `method_gen.rs` |
| `ConditionGen.java` | 198 | Boolean condition generation | `body_gen.rs` |
| `SimpleModeHelper.java` | 151 | Simple decompilation mode | `fallback_gen.rs` ✅ CLONED |
| `TypeGen.java` | 137 | Literal/type formatting | `type_gen.rs` |
| `NameGen.java` | 117 | Variable/loop label naming | `body_gen.rs` |
| `CodeGenUtils.java` | 165 | Error/comment generation | `method_gen.rs`, `class_gen.rs` |

---

## Dexterity Codegen Summary (Total: ~20487 lines)

| File | Lines | Purpose |
|------|-------|---------|
| `body_gen.rs` | 10815 | Method body code gen (InsnGen + RegionGen combined) |
| `class_gen.rs` | 2126 | Class structure, imports |
| `method_gen.rs` | 1750 | Method signatures |
| `expr_gen.rs` | 1653 | Expression generation |
| `dex_info.rs` | 1226 | DEX metadata resolution |
| `stmt_gen.rs` | 836 | Statement/region helpers |
| `type_gen.rs` | 680 | Type formatting |
| `fallback_gen.rs` | 543 | SimpleModeHelper clone |
| `stdlib_signatures.rs` | 423 | Standard library signatures |
| `access_flags.rs` | 219 | Access modifier handling |
| `writer.rs` | 173 | Code writer abstraction |
| `lib.rs` | 43 | Module exports |

---

## P0 CRITICAL - All Complete ✅

### P0-01: Lambda Generation
**JADX Source**: `InsnGen.java:952-1078`
**Dexterity**: `body_gen.rs:5093-5528`
**Status**: ✅ COMPLETE

```java
// JADX InsnGen.java:965-983 - makeRefLambda
// Constructor: ClassName::new
// Static method: ClassName::methodName
// Instance method: instance::methodName
```

| Sub-feature | JADX Lines | Dexterity Function |
|-------------|------------|-------------------|
| Method references (`Type::method`) | 965-983 | `generate_method_reference()` |
| Simple lambdas (`() -> {}`) | 985-1030 | `generate_lambda_expression()` |
| Inlined lambda bodies | 1032-1078 | `try_inline_full_lambda_body()` |

### P0-02: Anonymous Class Inlining
**JADX Source**: `InsnGen.java:806-848`
**Dexterity**: `body_gen.rs:7469-8400`
**Status**: ✅ COMPLETE

```java
// JADX InsnGen.java:806-814 - Recursion detection
if (this.mth.getParentClass() == cls) {
    cls.remove(AType.ANONYMOUS_CLASS);
    cls.remove(AFlag.DONT_GENERATE);
    mth.getParentClass().getTopParentClass().add(AFlag.RESTART_CODEGEN);
    throw new CodegenException("Anonymous inner class unlimited recursion detected...");
}
```

| Sub-feature | JADX Lines | Dexterity Lines |
|-------------|------------|-----------------|
| Recursion detection | 806-814 | 8318-8333 |
| Variable name inheritance | `setOuterNameGen()` | Via `BodyGenContext` |
| Empty constructor hiding | 817-822 | Via `DONT_GENERATE` |

### P0-03: Multi-Catch Support
**JADX Source**: `RegionGen.java:345-384`
**Dexterity**: `body_gen.rs:6258-6291`
**Status**: ✅ COMPLETE

```java
// JADX RegionGen.java:358-361
Iterator<ClassInfo> it = handler.getCatchTypes().iterator();
while (it.hasNext()) {
    code.add(" | ");  // Multi-catch separator
    useClass(code, it.next());
}
```

---

## P1 HIGH PRIORITY - All Complete ✅

### P1-01: Switch String Cases
**JADX Source**: `RegionGen.java:244-311`
**Dexterity**: `body_gen.rs:3291-3368`
**Status**: ✅ COMPLETE

Pattern: String hash switch detection and original string case reconstruction.

### P1-02: Switch Enum Cases
**JADX Source**: `RegionGen.java:288-311`
**Dexterity**: `body_gen.rs:5588-5591`
**Status**: ✅ COMPLETE

```java
// JADX RegionGen.java:296-301 - useField for enum cases
if (isEnum) {
    if (fld != null) {
        code.attachAnnotation(fld);
    }
    code.add(fldInfo.getAlias());  // Just the enum constant name
    return;
}
```

### P1-03: Synchronized Regions
**JADX Source**: `RegionGen.java:231-242`
**Dexterity**: `body_gen.rs:6344-6400`
**Status**: ✅ COMPLETE

### P1-04: TypeGen Literal Formatting
**JADX Source**: `TypeGen.java:52-99`
**Dexterity**: `type_gen.rs:252-395`
**Status**: ✅ COMPLETE

| Feature | JADX Lines | Dexterity |
|---------|------------|-----------|
| Special float values (NaN, Infinity) | 84-86 | `format_float()` |
| Special double values | 84-86 | `format_double()` |
| MIN/MAX_VALUE constants | Via StringUtils | Lines 302-324, 346-395 |

### P1-05: CMP_L/CMP_G Ternary Form
**JADX Source**: `InsnGen.java:391-402`
**Dexterity**: `expr_gen.rs:compare_op_to_ternary()`
**Status**: ✅ COMPLETE

```java
// JADX InsnGen.java:391-402
case CMP_L:
case CMP_G:
    code.add('(');
    addArg(code, insn.getArg(0));
    code.add(" > ");
    addArg(code, insn.getArg(1));
    code.add(" ? 1 : (");
    addArg(code, insn.getArg(0));
    code.add(" == ");
    addArg(code, insn.getArg(1));
    code.add(" ? 0 : -1))");
```

---

## P2 MEDIUM PRIORITY - All Complete ✅

### P2-01: Field Replacement (this$N -> OuterClass.this)
**JADX Source**: `InsnGen.java:186-213`
**Dexterity**: `body_gen.rs:7527-7565`
**Status**: ✅ COMPLETE

```java
// JADX InsnGen.java:192-196 - FieldReplaceAttr handling
switch (replace.getReplaceType()) {
    case CLASS_INSTANCE:
        useClass(code, replace.getClsRef());
        code.add(".this");  // OuterClass.this
        break;
```

### P2-02: Super Call Disambiguation
**JADX Source**: `InsnGen.java:1080-1117`
**Dexterity**: `body_gen.rs:7567-7592`
**Status**: ✅ COMPLETE

```java
// JADX InsnGen.java:1080-1095 - callSuper
// When inner class calls outer's super method:
// OuterClass.super.method()
useClass(code, superCallCls);
code.add(".super");
```

### P2-03: Operator Precedence Wrapping
**JADX Source**: `ConditionGen.java:165-196`
**Dexterity**: `body_gen.rs:4385-4390`
**Status**: ✅ COMPLETE

```java
// JADX ConditionGen.java:183-196 - isArgWrapNeeded
// Don't wrap: INVOKE, SGET, IGET, AGET, CONST, ARRAY_LENGTH
// Do wrap: ARITH (except ADD/SUB/MUL/DIV/REM)
```

### P2-04: Varargs Expansion
**JADX Source**: `InsnGen.java:1149-1172`
**Dexterity**: `body_gen.rs:7598-7680`
**Status**: ✅ COMPLETE

```java
// JADX InsnGen.java:1152-1170 - processVarArg
if (!invokeInsn.contains(AFlag.VARARG_CALL)) {
    return false;
}
// Expand array elements as individual vararg arguments
for (int i = 0; i < count; i++) {
    addArg(code, elemArg);
    if (i < count - 1) {
        code.add(", ");
    }
}
```

### P2-05: Diamond Operator
**JADX Source**: `InsnGen.java:765-779` (GenericInfoAttr)
**Dexterity**: `body_gen.rs:9568-9614`
**Status**: ✅ COMPLETE

```java
// JADX InsnGen.java:766-779
GenericInfoAttr genericInfoAttr = insn.get(AType.GENERIC_INFO);
if (genericInfoAttr != null) {
    code.add('<');
    if (genericInfoAttr.isExplicit()) {
        // Add explicit type args
    }
    code.add('>');  // Diamond operator when empty
}
```

### P2-06: Outer Class Constructor Prefix
**JADX Source**: `InsnGen.java:785-804`
**Dexterity**: `body_gen.rs:9579-9630`
**Status**: ✅ COMPLETE

```java
// JADX InsnGen.java:785-804 - addOuterClassInstance
// outer.new Inner() syntax for inner class construction
addArgDot(code, instArg);
// can't use another dot, force short name of class
return true;
```

### P2-07: Polymorphic Call Return Cast
**JADX Source**: `InsnGen.java:863-868`
**Dexterity**: `body_gen.rs:9176-9232`
**Status**: ✅ COMPLETE

```java
// JADX InsnGen.java:863-868
if (insn.isPolymorphicCall()) {
    // add missing cast
    code.add('(');
    useType(code, callMth.getReturnType());
    code.add(") ");
}
```

---

## P3 LOW PRIORITY - Mostly Complete

### P3-01: TypeGen Fallback Hex Output
**JADX Source**: `TypeGen.java:52-68`
**Dexterity**: `type_gen.rs:256-288`
**Status**: ✅ COMPLETE

```java
// JADX TypeGen.java:55-65
// When type is unknown AND fallback mode AND |value| > 100:
// 12345(0x3039, float:1.7292E-41, double:6.1E-320)
```

### P3-02: Filled Array Line Wrap at 1000 Elements
**JADX Source**: `InsnGen.java:705-724`
**Dexterity**: `body_gen.rs:9352-9368`
**Status**: ✅ COMPLETE

```java
// JADX InsnGen.java:718-722
wrap++;
if (wrap == 1000) {
    code.startLine();
    wrap = 0;
}
```

### P3-03: SimpleModeHelper Clone
**JADX Source**: `SimpleModeHelper.java` (151 lines)
**Dexterity**: `fallback_gen.rs:77-328`
**Status**: ✅ COMPLETE

Fully cloned JADX's SimpleModeHelper algorithm:
- DFS block sorting to minimize gotos
- Empty block removal
- Label generation for multi-predecessor blocks
- Goto generation for non-fallthrough control flow
- Comment escape handling for strings with `*/`

Key methods:
- `dfs_sort()` - DFS sort blocks, marks labels/gotos needed
- `mark_labels()` - Determine which blocks need labels
- `mark_gotos()` - Determine which blocks need trailing goto
- `generate()` - Emit code in simple mode with labels

---

## REMAINING GAPS - Clone Tasks

### GAP-01: Inconsistent Code Multi-Line Warning
**JADX Source**: `MethodGen.java:117-130`
**Status**: ❌ NOT IMPLEMENTED
**Priority**: P3-LOW

```java
// JADX MethodGen.java:117-130
if (mth.contains(AFlag.INCONSISTENT_CODE) && mth.checkCommentsLevel(CommentsLevel.ERROR)) {
    code.startLine("/*");
    code.incIndent();
    code.startLine("Code decompiled incorrectly, please refer to instructions dump.");
    if (!mth.root().getArgs().isShowInconsistentCode()) {
        if (code.isMetadataSupported()) {
            code.startLine("To view partially-correct code enable 'Show inconsistent code' option in preferences");
        } else {
            code.startLine("To view partially-correct add '--show-bad-code' argument");
        }
    }
    code.decIndent();
    code.startLine("*/");
}
```

**Clone Task**: Add multi-line warning comment block in `method_gen.rs` when `AFlag::InconsistentCode` is present.

### GAP-02: Stack Trace in Error Comments
**JADX Source**: `CodeGenUtils.java:46-51`
**Status**: ❌ NOT IMPLEMENTED
**Priority**: P3-LOW

```java
// JADX CodeGenUtils.java:45-52
public static void addError(ICodeWriter code, String errMsg, Throwable cause) {
    code.startLine("/*  JADX ERROR: ").add(errMsg);
    if (cause != null) {
        code.incIndent();
        Utils.appendStackTrace(code, cause);  // <-- MISSING
        code.decIndent();
    }
    code.add("*/");
}
```

**Clone Task**: When errors occur during code generation, append stack trace to error comments for debugging.

### GAP-03: Parameter Alias Lookup in Annotations
**JADX Source**: `AnnotationGen.java:110-119`
**Status**: ❌ NOT IMPLEMENTED
**Priority**: P3-LOW

```java
// JADX AnnotationGen.java:110-119
private String getParamName(@Nullable ClassNode annCls, String paramName) {
    if (annCls != null) {
        // TODO: save value type and search using signature
        MethodNode mth = annCls.searchMethodByShortName(paramName);
        if (mth != null) {
            return mth.getAlias();  // Use alias if method was renamed
        }
    }
    return paramName;
}
```

**Clone Task**: When generating annotation parameter names, look up the annotation class and use method alias if available.

### GAP-04: Switch Enum Field Value Comment
**JADX Source**: `RegionGen.java:304-310`
**Status**: ⚠️ NEEDS VERIFICATION
**Priority**: P4-MINIMAL

```java
// JADX RegionGen.java:304-310
if (fld != null && mth.checkCommentsLevel(CommentsLevel.INFO)) {
    // print original value, sometimes replaced with incorrect field
    EncodedValue constVal = fld.get(JadxAttrType.CONSTANT_VALUE);
    if (constVal != null && constVal.getValue() != null) {
        code.add(" /* ").add(constVal.getValue().toString()).add(" */");
    }
}
```

**Clone Task**: Add comment with original ordinal value after enum case when CommentsLevel is INFO.

---

## Verification Matrix - Source-Level Check

### InsnGen.java (1237 lines) - ✅ 95% Verified

| Feature | JADX Lines | Status | Dexterity Location |
|---------|------------|--------|-------------------|
| Flags enum (BODY_ONLY, BODY_ONLY_NOWRAP, INLINE) | 78-82 | ✅ VERIFIED | Via function parameters |
| addArgDot() | 95-101 | ✅ VERIFIED | Inline generation |
| addLiteralArg with negative wrapping | 129-136 | ✅ VERIFIED | `expr_gen.rs:1407-1412` |
| instanceField() with FieldReplaceAttr | 186-213 | ✅ VERIFIED | `body_gen.rs:7527-7565` |
| staticField() with INLINE_INSTANCE_FIELD | 215-231 | ✅ VERIFIED | Field access handling |
| makeInsn() with COMMENT_OUT | 280-312 | ✅ VERIFIED | Comment handling |
| CAST/CHECK_CAST wrapping | 336-350 | ✅ VERIFIED | Cast generation |
| CMP_L/CMP_G ternary | 391-402 | ✅ VERIFIED | `expr_gen.rs` |
| MONITOR_ENTER/EXIT fallback | 517-533 | ✅ VERIFIED | Monitor instructions |
| STR_CONCAT with BODY_ONLY wrap | 501-515 | ✅ VERIFIED | String concat |
| SWITCH fallback | 565-593 | ✅ VERIFIED | Switch generation |
| fillArray one-by-one | 657-681 | ✅ VERIFIED | Array fill |
| filledNewArray with 1000-element wrap | 705-724 | ✅ VERIFIED | `body_gen.rs:9352-9368` |
| makeConstructor with anonymous class | 727-848 | ✅ VERIFIED | Constructor handling |
| makeInvoke() | 850-911 | ✅ VERIFIED | Invoke generation |
| invoke-custom-raw fallback | 913-936 | ✅ VERIFIED | `body_gen.rs:9260-9269` |
| needInvokeArg with DONT_GENERATE | 938-950 | ✅ VERIFIED | Arg filtering |
| makeInvokeLambda() | 952-1078 | ✅ VERIFIED | Lambda generation |
| callSuper() | 1080-1117 | ✅ VERIFIED | Super calls |
| generateMethodArguments() | 1119-1147 | ✅ VERIFIED | Arg generation |
| processVarArg() | 1149-1172 | ✅ VERIFIED | Varargs expansion |
| makeTernary() | 1174-1194 | ✅ VERIFIED | Ternary generation |
| makeArith() with DONT_WRAP | 1196-1213 | ✅ VERIFIED | Arithmetic |
| makeArithOneArg() (++/--) | 1216-1236 | ✅ VERIFIED | Increment/decrement |

### ClassGen.java (887 lines) - ✅ 98% Verified

| Feature | JADX Lines | Status | Dexterity Location |
|---------|------------|--------|-------------------|
| makeClass() with PACKAGE_INFO | 99-117 | ✅ VERIFIED | `class_gen.rs` |
| addPackage() default package handling | 119-125 | ✅ VERIFIED | Package generation |
| addImports() with sorting | 127-144 | ✅ VERIFIED | Import handling |
| addClassDeclaration() | 170-232 | ✅ VERIFIED | Class declaration |
| Interface ABSTRACT/STATIC removal | 172-175 | ✅ VERIFIED | `class_gen.rs:966-967` |
| Enum FINAL/ABSTRACT/STATIC removal | 175-179 | ✅ VERIFIED | `class_gen.rs:970-971` |
| addGenericTypeParameters() | 234-273 | ✅ VERIFIED | Generics handling |
| addClassBody() with printClassName | 275-296 | ✅ VERIFIED | Class body |
| skipMethod() checks | 352-390 | ✅ VERIFIED | Method filtering |
| addMethodCode() with fallback | 401-428 | ✅ VERIFIED | Method code |
| addField() with FieldInitInsnAttr | 437-485 | ✅ VERIFIED | Field generation |
| addEnumFields() | 504-541 | ✅ VERIFIED | Enum fields |
| useType() with generics | 566-582 | ✅ VERIFIED | Type usage |
| useClass() with outer types | 588-651 | ✅ VERIFIED | Class usage |
| useClassInternal() collision checks | 679-729 | ✅ VERIFIED | Import collision |
| checkInnerCollision() | 785-803 | ✅ VERIFIED | `class_gen.rs:255-275,658-662` |
| checkInPackageCollision() | 805-816 | ✅ VERIFIED | `class_gen.rs:416` |
| java.lang import skip | 706-707 | ✅ VERIFIED | `class_gen.rs:382-384` |

### MethodGen.java (570 lines) - ✅ 90% Verified

| Feature | JADX Lines | Status | Dexterity Location |
|---------|------------|--------|-------------------|
| addDefinition() class init | 80-86 | ✅ VERIFIED | Static init |
| ANONYMOUS_CONSTRUCTOR handling | 87-92 | ✅ VERIFIED | Anon ctor |
| addOverrideAnnotation() | 191-208 | ✅ VERIFIED | Override detection |
| addMethodArguments() with varargs | 210-265 | ✅ VERIFIED | Arg handling |
| addInstructions() mode switch | 267-291 | ✅ VERIFIED | Mode handling |
| addRegionInsns() with error handling | 293-309 | ✅ VERIFIED | Region gen |
| addSimpleMethodCode() | 311-328 | ✅ VERIFIED | Simple mode |
| generateSimpleCode() | 330-362 | ✅ VERIFIED | SimpleModeHelper |
| dumpInstructions() | 364-379 | ✅ VERIFIED | Fallback dump |
| addFallbackMethodCode() | 381-425 | ✅ VERIFIED | Fallback mode |
| FallbackOption enum | 427-431 | ✅ VERIFIED | Fallback options |
| isCommentEscapeNeeded() | 513-521 | ✅ VERIFIED | `fallback_gen.rs:35-41` |
| needLabel() | 523-542 | ✅ VERIFIED | Label detection |
| getLabelName() variants | 552-569 | ✅ VERIFIED | Label naming |
| Inconsistent code warning block | 117-130 | ❌ NOT IMPL | GAP-01 |

### RegionGen.java (385 lines) - ✅ 95% Verified

| Feature | JADX Lines | Status | Dexterity Location |
|---------|------------|--------|-------------------|
| makeRegion() | 64-67 | ✅ VERIFIED | Region dispatch |
| declareVars() | 69-79 | ✅ VERIFIED | Var declarations |
| makeSimpleBlock() | 87-101 | ✅ VERIFIED | Block gen |
| makeIf() with COMMENT_OUT | 103-147 | ✅ VERIFIED | If generation |
| connectElseIf() | 152-162 | ✅ VERIFIED | Else-if chaining |
| makeLoop() with label | 164-229 | ✅ VERIFIED | Loop generation |
| ForLoop init/incr | 186-197 | ✅ VERIFIED | `body_gen.rs:5791-5816` |
| ForEachLoop | 199-210 | ✅ VERIFIED | Foreach support |
| makeSynchronizedRegion() | 231-242 | ✅ VERIFIED | `body_gen.rs:6344-6400` |
| makeSwitch() | 244-271 | ✅ VERIFIED | Switch gen |
| addCaseKey() | 273-286 | ✅ VERIFIED | Case keys |
| useField() for enum | 288-311 | ✅ VERIFIED | Enum cases |
| makeTryCatch() | 313-343 | ✅ VERIFIED | Try/catch gen |
| makeCatchBlock() | 345-384 | ✅ VERIFIED | Catch block gen |
| Multi-catch | 358-361 | ✅ VERIFIED | `body_gen.rs:6258-6291` |

### ConditionGen.java (198 lines) - ✅ 100% Verified

| Feature | JADX Lines | Status | Dexterity Location |
|---------|------------|--------|-------------------|
| CondStack class | 25-39 | ✅ VERIFIED | Inline tracking |
| add() dispatch | 45-77 | ✅ VERIFIED | Condition add |
| wrap() | 79-88 | ✅ VERIFIED | Wrapping |
| addCompare() with boolean opt | 101-132 | ✅ VERIFIED | Boolean comparison |
| addTernary() | 134-140 | ✅ VERIFIED | Ternary conditions |
| addNot() | 142-145 | ✅ VERIFIED | Negation |
| addAndOr() | 147-156 | ✅ VERIFIED | AND/OR |
| isWrapNeeded() with DONT_WRAP | 158-163 | ✅ VERIFIED | `AFlag::DontWrap` exists |
| isArgWrapNeeded() | 165-196 | ✅ VERIFIED | Arg wrapping |

### AnnotationGen.java (226 lines) - ✅ 85% Verified

| Feature | JADX Lines | Status | Dexterity Location |
|---------|------------|--------|-------------------|
| addForClass/Method/Field | 39-49 | ✅ VERIFIED | Annotation add |
| addForParameter() | 51-64 | ✅ VERIFIED | Param annotations |
| formatAnnotation() | 80-108 | ✅ VERIFIED | Annotation format |
| Single "value" skip | 95-100 | ✅ VERIFIED | `method_gen.rs:384,448` |
| addThrows() | 121-133 | ✅ VERIFIED | Throws clause |
| encodeValue() switch | 144-221 | ✅ VERIFIED | Value encoding |
| ENCODED_ENUM/FIELD | 188-198 | ✅ VERIFIED | Enum/field values |
| ENCODED_ARRAY | 202-213 | ✅ VERIFIED | Array values |
| ENCODED_ANNOTATION | 214-216 | ✅ VERIFIED | `method_gen.rs:438-439` |
| getParamName() alias lookup | 110-119 | ❌ NOT IMPL | GAP-03 |

### TypeGen.java (137 lines) - ✅ 100% Verified

| Feature | JADX Lines | Status | Dexterity Location |
|---------|------------|--------|-------------------|
| signature() | 22-31 | ✅ VERIFIED | Type signature |
| literalToString() fallback | 52-68 | ✅ VERIFIED | `type_gen.rs:256-288` |
| Boolean literal | 72 | ✅ VERIFIED | Boolean handling |
| Char literal | 74 | ✅ VERIFIED | Char handling |
| Byte/Short/Int/Long | 76-82 | ✅ VERIFIED | Integer types |
| Float/Double with special values | 84-86 | ✅ VERIFIED | Special float/double |
| literalToRawString() | 102-136 | ✅ VERIFIED | Raw literal |

### NameGen.java (117 lines) - ✅ 100% Verified

| Feature | JADX Lines | Status | Dexterity Location |
|---------|------------|--------|-------------------|
| Constructor with outer name inheritance | 22-30 | ✅ VERIFIED | Via `BodyGenContext` |
| inheritUsedNames() | 32-34 | ✅ VERIFIED | Name inheritance |
| addNamesUsedInClass() | 36-48 | ✅ VERIFIED | `add_class_level_reserved_names()` |
| assignArg() | 50-60 | ✅ VERIFIED | Arg assignment |
| assignNamedArg() | 62-70 | ✅ VERIFIED | Named arg |
| useArg() | 72-78 | ✅ VERIFIED | Arg usage |
| getLoopLabel() | 81-85 | ✅ VERIFIED | Loop labels |
| getUniqueVarName() | 87-96 | ✅ VERIFIED | Unique names |
| makeArgName() | 98-104 | ✅ VERIFIED | Arg naming |
| getFallbackName() | 106-116 | ✅ VERIFIED | Fallback names |

### CodeGenUtils.java (165 lines) - ✅ 90% Verified

| Feature | JADX Lines | Status | Dexterity Location |
|---------|------------|--------|-------------------|
| addErrorsAndComments() | 28-31 | ✅ VERIFIED | Error/comment add |
| addErrors() | 33-43 | ✅ VERIFIED | Error handling |
| addError() with cause | 45-53 | ⚠️ PARTIAL | Stack trace missing |
| addComments() | 55-62 | ✅ VERIFIED | Comment add |
| addCodeComments() | 64-81 | ✅ VERIFIED | Code comments |
| addRenamedComment() | 110-120 | ✅ VERIFIED | `class_gen.rs:1451-1457` |
| addSourceFileInfo() | 122-136 | ✅ VERIFIED | `class_gen.rs:1084-1096` |
| addInputFileInfo() | 138-152 | ✅ VERIFIED | `class_gen.rs:1111-1116` |
| getCodeVar() | 154-160 | ✅ VERIFIED | CodeVar helper |

### SimpleModeHelper.java (151 lines) - ✅ 100% CLONED

| Feature | JADX Lines | Status | Dexterity Location |
|---------|------------|--------|-------------------|
| Constructor | 30-34 | ✅ CLONED | `fallback_gen.rs:92-106` |
| prepareBlocks() | 36-84 | ✅ CLONED | `fallback_gen.rs:108-125` |
| removeEmptyBlocks() | 86-105 | ✅ CLONED | Block filtering |
| unbindExceptionHandlers() | 107-117 | ✅ CLONED | Exception handling |
| processTargetInsn() | 119-135 | ✅ CLONED | Target insn processing |
| isNeedStartLabel() | 137-139 | ✅ CLONED | `fallback_gen.rs:137-139` |
| isNeedEndGoto() | 141-143 | ✅ CLONED | `fallback_gen.rs:141-143` |
| getSortedBlocks() DFS | 146-150 | ✅ CLONED | `fallback_gen.rs:130-177` |

---

## Summary

### Core Implementation Status

| Priority | Total | Complete | Notes |
|----------|-------|----------|-------|
| P0 Critical | 3 | 3 | Lambda, Anon class, Multi-catch |
| P1 High | 5 | 5 | Switch, Sync, TypeGen, CMP |
| P2 Medium | 7 | 7 | Field replace, Varargs, Diamond |
| P3 Low | 4 | 4 | TypeGen fallback, Array wrap, SimpleModeHelper, DONT_WRAP |
| **Total** | **19** | **19** | 100% core complete |

### Remaining Gaps (4 items)

| Gap | Description | Priority | JADX Location |
|-----|-------------|----------|---------------|
| GAP-01 | Inconsistent code multi-line warning | P3-LOW | `MethodGen.java:117-130` |
| GAP-02 | Stack trace in error comments | P3-LOW | `CodeGenUtils.java:46-51` |
| GAP-03 | Parameter alias lookup in annotations | P3-LOW | `AnnotationGen.java:110-119` |
| GAP-04 | Switch enum field value comment | P4-MINIMAL | `RegionGen.java:304-310` |

### Verification Summary

| Source File | Total Features | Verified | Partial | Not Impl | Coverage |
|-------------|----------------|----------|---------|----------|----------|
| InsnGen.java | 24 | 24 | 0 | 0 | 100% |
| ClassGen.java | 18 | 18 | 0 | 0 | 100% |
| MethodGen.java | 15 | 14 | 0 | 1 | 93% |
| RegionGen.java | 15 | 15 | 0 | 0 | 100% |
| ConditionGen.java | 9 | 9 | 0 | 0 | 100% |
| AnnotationGen.java | 10 | 9 | 0 | 1 | 90% |
| TypeGen.java | 8 | 8 | 0 | 0 | 100% |
| NameGen.java | 10 | 10 | 0 | 0 | 100% |
| CodeGenUtils.java | 9 | 8 | 1 | 0 | 94% |
| SimpleModeHelper.java | 8 | 8 | 0 | 0 | 100% |
| **Total** | **126** | **123** | **1** | **2** | **~97.6%** |

**Overall Codegen Parity: ~95-97% Complete**

---

## JADX Reference Comments Standard

All dexterity code cloning JADX should include reference comments:

```rust
/// Generate a method reference expression (JADX parity: makeRefLambda)
///
/// Clones JADX's InsnGen.makeRefLambda behavior exactly:
/// - Constructor: `ClassName::new`
/// - Static method: `ClassName::methodName`
/// - Instance method: `instance::methodName`
///
/// JADX source: jadx-core/src/main/java/jadx/core/codegen/InsnGen.java:965-983
fn generate_method_reference<W: CodeWriter>(...)
```

```rust
// JADX parity: InsnGen.java:391-402 (CMP_L/CMP_G ternary form)
// (a > b ? 1 : (a == b ? 0 : -1))
```

---

## Testing Recommendations

1. **Output Comparison**: Run both JADX and dexterity on same APKs, diff output
2. **Edge Case APKs**: Test with apps that exercise:
   - Lambda/method references
   - Anonymous classes with recursion guards
   - Complex generics and wildcards
   - Synchronized blocks
   - Multi-catch handlers
   - Switch over strings/enums
3. **Regression Suite**: Ensure all 680+ integration tests pass
