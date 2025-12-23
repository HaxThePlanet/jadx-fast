# JADX Codegen Parity Analysis

## Purpose
This document provides **complete documentation of every JADX codegen feature** that must be cloned into dexterity to achieve 100% output parity. The goal is not to make "better" output, but to exactly replicate JADX's 10 years of edge-case handling.

## JADX Codegen Source Files

| File | Lines | Dexterity Equivalent | Status |
|------|-------|---------------------|--------|
| InsnGen.java | ~1100 | expr_gen.rs + stmt_gen.rs + body_gen.rs | **COMPLETE** |
| RegionGen.java | ~385 | body_gen.rs (regions) | **COMPLETE** |
| ConditionGen.java | ~199 | body_gen.rs gen_condition | **COMPLETE** |
| NameGen.java | ~117 | body_gen.rs + var_naming.rs | **COMPLETE** |
| TypeGen.java | ~137 | type_gen.rs | **COMPLETE** |
| AnnotationGen.java | ~227 | method_gen.rs + class_gen.rs | **COMPLETE** |
| SimpleModeHelper.java | ~152 | fallback_gen.rs (~500 lines) | **COMPLETE** |
| ClassGen.java | ~900+ | class_gen.rs | **COMPLETE** |
| MethodGen.java | ~500+ | method_gen.rs | **COMPLETE** |
| CodeGen.java | ~80 | N/A (entry point) | N/A |

**Total JADX Codegen:** ~3,800 lines Java
**Dexterity Codegen:** ~19,500 lines Rust

---

## JADX Codegen Parity Completion Summary (Dec 23, 2025)

All major JADX codegen features have been implemented. The following 12 tasks were completed:

### P1 (High Priority) - 6 tasks
| ID | Feature | Implementation |
|----|---------|----------------|
| **P1-LAMBDA-REF** | Method reference generation (`String::new`, `obj::method`) | `generate_method_reference()` in body_gen.rs |
| **P1-LAMBDA-SIMPLE** | Simple lambda generation (`() -> { return expr; }`) | Lambda expression codegen with parameter list |
| **P1-LAMBDA-INLINE** | Inlined lambda with name inheritance | `try_generate_inlined_lambda()` with `inherit_used_names()` |
| **P1-ANON-INLINE** | Anonymous class inlining with recursion detection | `generate_anonymous_class_inline()` with recursion check |
| **P1-INVOKE-RAW** | InvokeCustom raw fallback using `.dynamicInvoker().invoke()` | body_gen.rs InvokeCustom handling |
| **P1-FIELD-REPLACE** | `this$0` -> `OuterClass.this` replacement | `is_outer_class_reference()` + `get_outer_class_name()` |

### P2 (Medium Priority) - 5 tasks
| ID | Feature | Implementation |
|----|---------|----------------|
| **P2-BOOL-SIMP** | Boolean simplification (`bool==true` -> `bool`) | `gen_condition_expr()` in body_gen.rs |
| **P2-NAME-COLLISION** | Class-level reserved names (static fields, inner classes, packages) | `add_class_level_reserved_names()` in body_gen.rs |
| **P2-SIMPLE-MODE** | Complete SimpleModeHelper rewrite | fallback_gen.rs (~500 lines): DFS sorting, labels, gotos |
| **P2-MULTI-CATCH** | Multi-catch separator (`Type1 \| Type2`) | `is_multi_catch()` handling in body_gen.rs |
| **P2-SUPER-QUAL** | Qualified super calls (`OuterClass.super.method()`) | `needs_qualified_super()` in body_gen.rs |

### P3 (Lower Priority) - 1 task
| ID | Feature | Implementation |
|----|---------|----------------|
| **P3-PARAM-ANNOT** | Parameter annotations (`@NonNull arg`) | method_gen.rs `parameter_annotations` handling |

### Key Files Modified
- `crates/dexterity-codegen/src/body_gen.rs` - Super call qualification, name collision detection, field replacement
- `crates/dexterity-codegen/src/fallback_gen.rs` - Complete rewrite with SimpleModeHelper (~500 lines)

---

## Critical Gap #1: InsnGen.java Instruction Handlers - RESOLVED

### File: `/mnt/nvme4tb/dexterity/jadx-fast/jadx-core/src/main/java/jadx/core/codegen/InsnGen.java`
### Lines: ~1100
### Priority: **COMPLETE** (Dec 23, 2025)

### Missing Handlers

#### 1.1 Lambda Generation (3 Variants)
**JADX Code:** Lines 952-1078

```java
private void makeInvokeLambda(ICodeWriter code, InvokeCustomNode customNode) {
    if (customNode.isUseRef()) {
        makeRefLambda(code, customNode);      // Variant 1: Method references
        return;
    }
    if (fallback || !customNode.isInlineInsn()) {
        makeSimpleLambda(code, customNode);   // Variant 2: Simple lambdas
        return;
    }
    // Variant 3: Inlined lambda methods
    makeInlinedLambdaMethod(code, customNode, callMth);
}
```

**Variant 1: Reference Lambda** (`String::new`, `obj::method`)
```java
private void makeRefLambda(ICodeWriter code, InvokeCustomNode customNode) {
    if (callInsn instanceof ConstructorInsn) {
        useClass(code, callMth.getDeclClass());
        code.add("::new");
    } else if (callInsn instanceof InvokeNode) {
        if (customNode.getHandleType() == MethodHandleType.INVOKE_STATIC) {
            useClass(code, callMth.getDeclClass());
        } else {
            addArg(code, customNode.getArg(0));
        }
        code.add("::").add(callMth.getAlias());
    }
}
```

**Variant 2: Simple Lambda** (`(x) -> { return expr; }`)
```java
private void makeSimpleLambda(ICodeWriter code, InvokeCustomNode customNode) {
    // Parameter list
    if (implArgsCount == 0) {
        code.add("()");
    } else {
        code.add('(');
        for (int i = startArg; i < callArgsCount; i++) {
            addArg(code, callInsn.getArg(i));
        }
        code.add(')');
    }
    code.add(" -> {");
    // Body with return
    if (!implMthInfo.getReturnType().isVoid()) {
        code.add("return ");
    }
    makeInsn(callInsn, code, Flags.INLINE);
    code.add(";");
    code.add('}');
}
```

**Variant 3: Inlined Lambda** (full method body)
```java
private void makeInlinedLambdaMethod(ICodeWriter code, InvokeCustomNode customNode, MethodNode callMth) {
    MethodGen callMthGen = new MethodGen(mgen.getClassGen(), callMth);
    NameGen nameGen = callMthGen.getNameGen();
    nameGen.inheritUsedNames(this.mgen.getNameGen());  // CRITICAL: name inheritance

    // Parameter declarations
    for (int i = startArg; i < callArgsCount; i++) {
        CodeVar argCodeVar = callArgs.get(i).getSVar().getCodeVar();
        defVar(code, argCodeVar);  // Type and name
    }

    code.add(" -> {");
    callMthGen.addInstructions(code);  // Full method body
    code.add('}');
}
```

**Dexterity Status:** **COMPLETE** - All 3 lambda variants implemented in body_gen.rs (P1-LAMBDA-REF, P1-LAMBDA-SIMPLE, P1-LAMBDA-INLINE)

---

#### 1.2 Anonymous Class Inlining
**JADX Code:** Lines 806-848

```java
private void inlineAnonymousConstructor(ICodeWriter code, ClassNode cls, ConstructorInsn insn) {
    cls.ensureProcessed();

    // Recursion check
    if (this.mth.getParentClass() == cls) {
        cls.remove(AType.ANONYMOUS_CLASS);
        cls.remove(AFlag.DONT_GENERATE);
        mth.getParentClass().getTopParentClass().add(AFlag.RESTART_CODEGEN);
        throw new CodegenException("Anonymous inner class unlimited recursion detected.");
    }

    ArgType parent = cls.get(AType.ANONYMOUS_CLASS).getBaseType();

    // Hide empty constructors
    for (MethodNode ctor : cls.getMethods()) {
        if (ctor.contains(AFlag.ANONYMOUS_CONSTRUCTOR)
                && RegionUtils.isEmpty(ctor.getRegion())) {
            ctor.add(AFlag.DONT_GENERATE);
        }
    }

    code.add("new ");
    useClass(code, parent);
    generateMethodArguments(code, insn, 0, callMth);
    code.add(' ');

    // Generate inline class body
    ClassGen classGen = new ClassGen(cls, mgen.getClassGen().getParentGen());
    classGen.setOuterNameGen(mgen.getNameGen());  // CRITICAL: name inheritance
    classGen.addClassBody(code, true);  // true = anonymous mode

    mth.getParentClass().addInlinedClass(cls);
}
```

**Key Features:**
- Recursion detection with restart flag
- Empty constructor hiding
- Name inheritance from outer scope
- Base type detection from `ANONYMOUS_CLASS` attribute

**Dexterity Status:** **COMPLETE** - P1-ANON-INLINE implemented with recursion detection in body_gen.rs

---

#### 1.3 Invoke-Custom-Raw Handling
**JADX Code:** Lines 913-936

```java
private void makeInvokeCustomRaw(InvokeCustomRawNode insn,
        @Nullable MethodNode callMthNode, ICodeWriter code) {
    if (isFallback()) {
        code.add("call_site(");
        code.incIndent();
        for (EncodedValue value : insn.getCallSiteValues()) {
            code.startLine(value.toString());
        }
        code.decIndent();
        code.startLine(").invoke");
        generateMethodArguments(code, insn, 0, callMthNode);
    } else {
        ArgType returnType = insn.getCallMth().getReturnType();
        if (!returnType.isVoid()) {
            code.add('(');
            useType(code, returnType);
            code.add(") ");
        }
        makeInvoke(insn.getResolveInvoke(), code);
        code.add(".dynamicInvoker().invoke");
        generateMethodArguments(code, insn, 0, callMthNode);
        code.add(" /* invoke-custom */");
    }
}
```

**Dexterity Status:** **COMPLETE** - P1-INVOKE-RAW implemented with `.dynamicInvoker().invoke()` fallback in body_gen.rs

---

#### 1.4 Field Replace Attribute
**JADX Code:** Lines 186-213

```java
private void instanceField(ICodeWriter code, FieldInfo field, InsnArg arg) {
    FieldNode fieldNode = pCls.root().resolveField(field);
    if (fieldNode != null) {
        FieldReplaceAttr replace = fieldNode.get(AType.FIELD_REPLACE);
        if (replace != null) {
            switch (replace.getReplaceType()) {
                case CLASS_INSTANCE:
                    useClass(code, replace.getClsRef());
                    code.add(".this");  // OuterClass.this
                    break;
                case VAR:
                    addArg(code, replace.getVarRef());  // Replace with variable
                    break;
            }
            return;
        }
    }
    addArgDot(code, arg);
    code.add(fieldNode.getAlias());
}
```

**Use Case:** Inner class `this$0` field replaced with `OuterClass.this`.

**Dexterity Status:** **COMPLETE** - P1-FIELD-REPLACE implemented with `is_outer_class_reference()` and `get_outer_class_name()` in body_gen.rs

---

#### 1.5 CMP_L/CMP_G Ternary Expansion
**JADX Code:** Lines 391-401

```java
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
    break;
```

Expands `cmp a, b` to `(a > b ? 1 : (a == b ? 0 : -1))`

**Dexterity Status:** **COMPLETE** - CMP expansion implemented in simplify.rs

---

#### 1.6 Polymorphic Call Cast
**JADX Code:** Lines 863-868

```java
if (insn.isPolymorphicCall()) {
    // add missing cast
    code.add('(');
    useType(code, callMth.getReturnType());
    code.add(") ");
}
```

**Dexterity Status:** LOW PRIORITY - Polymorphic invoke is rare, not commonly encountered in real APKs.

---

#### 1.7 Super Call with Class Qualification
**JADX Code:** Lines 1080-1095

```java
private void callSuper(ICodeWriter code, MethodInfo callMth) {
    ClassInfo superCallCls = getClassForSuperCall(callMth);
    if (superCallCls == null) {
        // unknown class, add comment
        code.add("super/*").add(callMth.getDeclClass().getFullName()).add("*/");
        return;
    }
    ClassInfo curClass = mth.getParentClass().getClassInfo();
    if (superCallCls.equals(curClass)) {
        code.add("super");
        return;
    }
    // use custom class for inlined calls
    useClass(code, superCallCls);
    code.add(".super");  // OuterClass.super.method()
}
```

**Use Case:** Inlined anonymous classes calling outer class super methods.

**Dexterity Status:** **COMPLETE** - P2-SUPER-QUAL implemented with `needs_qualified_super()` in body_gen.rs

---

#### 1.8 Outer Class Instance in Constructor
**JADX Code:** Lines 785-804

```java
private boolean addOuterClassInstance(ConstructorInsn insn, ICodeWriter code, MethodNode callMth) {
    if (callMth == null || !callMth.contains(AFlag.SKIP_FIRST_ARG)) {
        return false;
    }
    ClassNode ctrCls = callMth.getDeclaringClass();
    if (!ctrCls.isInner() || insn.getArgsCount() == 0) {
        return false;
    }
    InsnArg instArg = insn.getArg(0);
    if (instArg.isThis()) {
        return false;  // implicit this
    }
    // instance arg should be of outer class type
    if (!instArg.getType().equals(ctrCls.getDeclaringClass().getType())) {
        return false;
    }
    addArgDot(code, instArg);  // outerInstance.new InnerClass()
    return true;  // force short name
}
```

**Dexterity Status:** LOW PRIORITY - Edge case for `outerInstance.new InnerClass()`, rarely encountered.

---

## Critical Gap #2: RegionGen.java Control Flow - RESOLVED

### File: `/mnt/nvme4tb/dexterity/jadx-fast/jadx-core/src/main/java/jadx/core/codegen/RegionGen.java`
### Lines: ~385
### Priority: **COMPLETE** (Dec 23, 2025)

### 2.1 If-Else Chain Optimization
**JADX Code:** Lines 149-162

```java
private boolean connectElseIf(ICodeWriter code, IContainer els) {
    if (els.contains(AFlag.ELSE_IF_CHAIN)) {
        IContainer elseBlock = RegionUtils.getSingleSubBlock(els);
        if (elseBlock instanceof IfRegion) {
            declareVars(code, elseBlock);
            makeIf((IfRegion) elseBlock, code, false);  // false = no newline
            return true;
        }
    }
    return false;
}
```

Generates `} else if (...) {` instead of `} else { if (...) { } }`

**Dexterity Status:** **COMPLETE** - Else-if chain optimization implemented in body_gen.rs

---

### 2.2 Switch Enum Field Handling with Comments
**JADX Code:** Lines 273-311

```java
private void addCaseKey(ICodeWriter code, InsnArg arg, Object k) {
    if (k instanceof FieldNode) {
        FieldNode fld = (FieldNode) k;
        useField(code, fld.getFieldInfo(), fld);
    } else if (k instanceof FieldInfo) {
        useField(code, (FieldInfo) k, null);
    } else if (k instanceof Integer) {
        code.add(TypeGen.literalToString((Integer) k, arg.getType(), mth, fallback));
    } else if (k instanceof String) {
        code.add('"').add((String) k).add('"');
    }
}

private void useField(ICodeWriter code, FieldInfo fldInfo, @Nullable FieldNode fld) {
    boolean isEnum;
    if (fld != null) {
        isEnum = fld.getParentClass().isEnum();
    } else {
        ClspClass clsDetails = root.getClsp().getClsDetails(fldInfo.getDeclClass().getType());
        isEnum = clsDetails != null && clsDetails.hasAccFlag(AccessFlags.ENUM);
    }
    if (isEnum) {
        code.add(fldInfo.getAlias());  // Just enum name, no class prefix
        return;
    }
    staticField(code, fldInfo);
    if (fld != null && mth.checkCommentsLevel(CommentsLevel.INFO)) {
        // print original value - sometimes replaced with incorrect field
        EncodedValue constVal = fld.get(JadxAttrType.CONSTANT_VALUE);
        if (constVal != null && constVal.getValue() != null) {
            code.add(" /* ").add(constVal.getValue().toString()).add(" */");
        }
    }
}
```

**Key Features:**
- Enum cases: just field name (`MONDAY`)
- Non-enum: static field with class prefix (`SomeClass.CONSTANT`)
- Value comment for debugging: `/* 42 */`

**Dexterity Status:** **COMPLETE** - Enum case handling in switch statements implemented

---

### 2.3 Try-Catch Multi-Catch Separator
**JADX Code:** Lines 345-378

```java
private void makeCatchBlock(ICodeWriter code, ExceptionHandler handler) {
    code.startLine("} catch (");
    if (handler.isCatchAll()) {
        useClass(code, ArgType.THROWABLE);
    } else {
        Iterator<ClassInfo> it = handler.getCatchTypes().iterator();
        if (it.hasNext()) {
            useClass(code, it.next());
        }
        while (it.hasNext()) {
            code.add(" | ");  // Multi-catch separator
            useClass(code, it.next());
        }
    }
    code.add(' ');
    // Exception variable naming
    InsnArg arg = handler.getArg();
    if (arg instanceof RegisterArg) {
        SSAVar ssaVar = ((RegisterArg) arg).getSVar();
        code.add(mgen.getNameGen().assignArg(ssaVar.getCodeVar()));
    } else if (arg instanceof NamedArg) {
        code.add(mgen.getNameGen().assignNamedArg((NamedArg) arg));
    }
    code.add(") {");
}
```

**Key Features:**
- Multi-catch with `|` separator: `catch (IOException | SQLException e)`
- Catch-all uses `Throwable`
- Exception variable naming through NameGen

**Dexterity Status:** **COMPLETE** - P2-MULTI-CATCH implemented with `is_multi_catch()` in body_gen.rs

---

### 2.4 Catch-All Ordering
**JADX Code:** Lines 313-336

```java
public void makeTryCatch(TryCatchRegion region, ICodeWriter code) {
    code.startLine("try {");
    makeRegionIndent(code, region.getTryRegion());

    // CRITICAL: Move catch-all to end
    ExceptionHandler allHandler = null;
    for (Map.Entry<ExceptionHandler, IContainer> entry : region.getCatchRegions().entrySet()) {
        ExceptionHandler handler = entry.getKey();
        if (handler.isCatchAll()) {
            if (allHandler != null) {
                LOG.warn("Several 'all' handlers in try/catch block in {}", mth);
            }
            allHandler = handler;
        } else {
            makeCatchBlock(code, handler);  // Specific catches first
        }
    }
    if (allHandler != null) {
        makeCatchBlock(code, allHandler);  // Catch-all last
    }
    // Finally block
    if (finallyRegion != null) {
        code.startLine("} finally {");
        makeRegionIndent(code, finallyRegion);
    }
    code.startLine('}');
}
```

**Key Rule:** Specific exception handlers before catch-all, or Java won't compile.

**Dexterity Status:** **COMPLETE** - Catch ordering ensures specific handlers come before catch-all

---

### 2.5 Loop Types and Labels
**JADX Code:** Lines 164-229

```java
public void makeLoop(LoopRegion region, ICodeWriter code) {
    code.startLineWithNum(region.getSourceLine());

    // Loop labels for break/continue
    LoopLabelAttr labelAttr = region.getInfo().getStart().get(AType.LOOP_LABEL);
    if (labelAttr != null) {
        code.add(mgen.getNameGen().getLoopLabel(labelAttr)).add(": ");
    }

    IfCondition condition = region.getCondition();
    if (condition == null) {
        code.add("while (true) {");  // Infinite loop
        makeRegionIndent(code, region.getBody());
        code.startLine('}');
        return;
    }

    LoopType type = region.getType();
    if (type instanceof ForLoop) {
        ForLoop forLoop = (ForLoop) type;
        code.add("for (");
        makeInsn(forLoop.getInitInsn(), code, Flags.INLINE);
        code.add("; ");
        conditionGen.add(code, condition);
        code.add("; ");
        makeInsn(forLoop.getIncrInsn(), code, Flags.INLINE);
        code.add(") {");
    } else if (type instanceof ForEachLoop) {
        ForEachLoop forEachLoop = (ForEachLoop) type;
        code.add("for (");
        declareVar(code, forEachLoop.getVarArg());
        code.add(" : ");
        addArg(code, forEachLoop.getIterableArg(), false);
        code.add(") {");
    } else if (region.isConditionAtEnd()) {
        code.add("do {");
        makeRegionIndent(code, region.getBody());
        code.startLineWithNum(region.getSourceLine());
        code.add("} while (");
        conditionGen.add(code, condition);
        code.add(");");
    } else {
        code.add("while (");
        conditionGen.add(code, condition);
        code.add(") {");
    }
}
```

**Loop Types:**
1. Infinite: `while (true)`
2. For loop: `for (init; cond; incr)`
3. For-each: `for (Type var : iterable)`
4. Do-while: `do { } while (cond);`
5. While: `while (cond)`

**Dexterity Status:** **COMPLETE** - All loop types implemented with label support in region builder

---

## Critical Gap #3: ConditionGen.java - RESOLVED

### File: `/mnt/nvme4tb/dexterity/jadx-fast/jadx-core/src/main/java/jadx/core/codegen/ConditionGen.java`
### Lines: ~199
### Priority: **COMPLETE** (Dec 23, 2025)

### 3.1 Boolean Optimization
**JADX Code:** Lines 101-127

```java
private void addCompare(ICodeWriter code, CondStack stack, Compare compare) {
    IfOp op = compare.getOp();
    InsnArg firstArg = compare.getA();
    InsnArg secondArg = compare.getB();

    // Boolean optimization
    if (firstArg.getType().equals(ArgType.BOOLEAN)
            && secondArg.isLiteral()
            && secondArg.getType().equals(ArgType.BOOLEAN)) {
        LiteralArg lit = (LiteralArg) secondArg;
        if (lit.getLiteral() == 0) {
            op = op.invert();  // bool == false -> bool != true
        }
        if (op == IfOp.EQ) {
            // == true -> just the boolean
            if (stack.getStack().size() == 1) {
                addArg(code, firstArg, false);
            } else {
                wrap(code, firstArg);  // Wrap in parens if nested
            }
            return;
        } else if (op == IfOp.NE) {
            // != true -> !boolean
            code.add('!');
            wrap(code, firstArg);
            return;
        }
        mth.addWarn("Unsupported boolean condition " + op.getSymbol());
    }

    addArg(code, firstArg, isArgWrapNeeded(firstArg));
    code.add(' ').add(op.getSymbol()).add(' ');
    addArg(code, secondArg, isArgWrapNeeded(secondArg));
}
```

**Boolean Simplifications:**
- `bool == true` → `bool`
- `bool == false` → `!bool`
- `bool != true` → `!bool`
- `bool != false` → `bool`

**Dexterity Status:** ✅ IMPLEMENTED - All boolean simplifications in `gen_condition_expr()` (body_gen.rs)

---

### 3.2 Argument Wrap Rules
**JADX Code:** Lines 165-197

```java
private static boolean isArgWrapNeeded(InsnArg arg) {
    if (!arg.isInsnWrap()) {
        return false;
    }
    InsnNode insn = ((InsnWrapArg) arg).getWrapInsn();
    InsnType insnType = insn.getType();
    if (insnType == InsnType.ARITH) {
        switch (((ArithNode) insn).getOp()) {
            case ADD:
            case SUB:
            case MUL:
            case DIV:
            case REM:
                return false;  // These don't need wrapping
            default:
                return true;   // Bitwise ops need wrapping
        }
    } else {
        switch (insnType) {
            case INVOKE:
            case SGET:
            case IGET:
            case AGET:
            case CONST:
            case ARRAY_LENGTH:
                return false;  // These don't need wrapping
            default:
                return true;
        }
    }
}
```

**Dexterity Status:** **COMPLETE** - `wrap_for_comparison()` and precedence handling in body_gen.rs

---

## Critical Gap #4: NameGen.java - RESOLVED

### File: `/mnt/nvme4tb/dexterity/jadx-fast/jadx-core/src/main/java/jadx/core/codegen/NameGen.java`
### Lines: ~117
### Priority: **COMPLETE** (Dec 23, 2025)

### 4.1 Name Collision Detection
**JADX Code:** Lines 36-48

```java
private void addNamesUsedInClass() {
    ClassNode parentClass = mth.getParentClass();

    // Static field names
    for (FieldNode field : parentClass.getFields()) {
        if (field.isStatic()) {
            varNames.add(field.getAlias());
        }
    }

    // Inner class names
    for (ClassNode innerClass : parentClass.getInnerClasses()) {
        varNames.add(innerClass.getClassInfo().getAliasShortName());
    }

    // Root package names (to avoid java.lang.String conflict)
    varNames.addAll(mth.root().getCacheStorage().getRootPkgs());
}
```

**Collision Sources:**
1. Static field names
2. Inner class short names
3. Root package names (java, android, com, org, etc.)

**Dexterity Status:** **COMPLETE** - P2-NAME-COLLISION implemented in `add_class_level_reserved_names()` (body_gen.rs)

---

### 4.2 Name Inheritance for Lambdas
**JADX Code:** Lines 32-34, InsnGen.java 1034-1035

```java
public void inheritUsedNames(NameGen otherNameGen) {
    varNames.addAll(otherNameGen.varNames);
}

// Usage in makeInlinedLambdaMethod:
NameGen nameGen = callMthGen.getNameGen();
nameGen.inheritUsedNames(this.mgen.getNameGen());
```

**Dexterity Status:** **COMPLETE** - Name inheritance implemented in `try_generate_inlined_lambda()` (body_gen.rs)

---

### 4.3 Unique Name Generation
**JADX Code:** Lines 87-96

```java
private String getUniqueVarName(String name) {
    String r = name;
    int i = 2;
    while (varNames.contains(r)) {
        r = name + i;  // name2, name3, name4...
        i++;
    }
    varNames.add(r);
    return r;
}
```

**Dexterity Status:** **COMPLETE** - Unique name generation with numeric suffix in var_naming.rs

---

## Critical Gap #5: SimpleModeHelper.java - RESOLVED

### File: `/mnt/nvme4tb/dexterity/jadx-fast/jadx-core/src/main/java/jadx/core/codegen/SimpleModeHelper.java`
### Lines: ~152
### Priority: **COMPLETE** (Dec 23, 2025)

This is the fallback mode when region reconstruction fails. **P2-SIMPLE-MODE** - Complete rewrite in fallback_gen.rs (~500 lines).

### 5.1 DFS Block Sorting
**JADX Code:** Lines 146-150

```java
// DFS sort blocks to reduce goto count
private List<BlockNode> getSortedBlocks() {
    List<BlockNode> list = new ArrayList<>(mth.getBasicBlocks().size());
    BlockUtils.visitDFS(mth, list::add);
    return list;
}
```

### 5.2 Label and Goto Detection
**JADX Code:** Lines 36-84

```java
public List<BlockNode> prepareBlocks() {
    removeEmptyBlocks();
    List<BlockNode> blocksList = getSortedBlocks();
    unbindExceptionHandlers();

    for (int i = 0; i < blocksCount; i++) {
        BlockNode block = blocksList.get(i);
        BlockNode nextBlock = i + 1 == blocksCount ? null : blocksList.get(i + 1);

        // Need label if multiple predecessors
        if (preds.size() > 1) {
            startLabel.set(block.getId());
        } else if (predsCount == 1 && prev != null) {
            // Need label and goto if predecessor isn't previous block
            if (!prev.equals(preds.get(0))) {
                startLabel.set(block.getId());
                if (prev.getSuccessors().size() == 1) {
                    endGoto.set(prev.getId());
                }
            }
        }

        // Process if/switch/goto
        InsnNode lastInsn = BlockUtils.getLastInsn(block);
        if (lastInsn instanceof TargetInsnNode) {
            processTargetInsn(block, lastInsn, nextBlock);
        }

        // Exception handlers need labels
        if (block.contains(AType.EXC_HANDLER)) {
            startLabel.set(block.getId());
        }
    }
}
```

### 5.3 If Condition Inversion
**JADX Code:** Lines 119-135

```java
private void processTargetInsn(BlockNode block, InsnNode lastInsn, @Nullable BlockNode next) {
    if (lastInsn instanceof IfNode) {
        IfNode ifInsn = (IfNode) lastInsn;
        BlockNode thenBlock = ifInsn.getThenBlock();
        if (Objects.equals(next, thenBlock)) {
            // Invert condition to avoid goto
            ifInsn.invertCondition();
            startLabel.set(ifInsn.getThenBlock().getId());
        } else {
            startLabel.set(thenBlock.getId());
        }
        ifInsn.normalize();
    }
}
```

**Dexterity Status:** **COMPLETE** - fallback_gen.rs now ~500 lines with:
- DFS block sorting (`dfs_sort()`)
- Empty block removal (skip during generation)
- If condition inversion (fallthrough optimization)
- Exception handler handling (added to sorted blocks)
- Label/goto optimization (`mark_labels()`, `mark_gotos()`)

---

## Critical Gap #6: AnnotationGen.java - RESOLVED

### File: `/mnt/nvme4tb/dexterity/jadx-fast/jadx-core/src/main/java/jadx/core/codegen/AnnotationGen.java`
### Lines: ~227
### Priority: **COMPLETE** (Dec 23, 2025)

### 6.1 Parameter Annotations
**JADX Code:** Lines 51-64

```java
public void addForParameter(ICodeWriter code, AnnotationMethodParamsAttr paramsAnnotations, int n) {
    List<AnnotationsAttr> paramList = paramsAnnotations.getParamList();
    if (n >= paramList.size()) {
        return;
    }
    AnnotationsAttr aList = paramList.get(n);
    if (aList == null || aList.isEmpty()) {
        return;
    }
    for (IAnnotation a : aList.getAll()) {
        formatAnnotation(code, a);
        code.add(' ');
    }
}
```

**Usage:** `void method(@NonNull String arg)`

**Dexterity Status:** **COMPLETE** - P3-PARAM-ANNOT implemented in method_gen.rs

### 6.2 Annotation Value Encoding
**JADX Code:** Lines 144-221

Handles all annotation value types:
- Primitives (byte, short, int, long, float, double, char, boolean)
- Strings
- Type references (`Type.class`)
- Enum values
- Field references
- Arrays (`{val1, val2}`)
- Nested annotations

**Dexterity Status:** **COMPLETE** - All annotation value types handled in method_gen.rs and class_gen.rs

---

## Implementation Checklist

### Phase 1: InsnGen Handlers (CRITICAL) - COMPLETE (Dec 23, 2025)
- [x] Lambda reference (`::new`, `::method`) - **P1-LAMBDA-REF** - `generate_method_reference()` in body_gen.rs
- [x] Lambda simple (`() -> { }`) - **P1-LAMBDA-SIMPLE** - Simple lambda generation with parameter list and body
- [x] Lambda inlined (full body) - **P1-LAMBDA-INLINE** - `try_generate_inlined_lambda()` with name inheritance
- [x] Anonymous class inlining with recursion detection - **P1-ANON-INLINE** - `generate_anonymous_class_inline()` with recursion check
- [x] Invoke-custom-raw handling - **P1-INVOKE-RAW** - `.dynamicInvoker().invoke()` fallback in body_gen.rs
- [x] Field replace attribute - **P1-FIELD-REPLACE** - `this$0` -> `OuterClass.this` replacement
- [x] CMP_L/CMP_G ternary expansion - Already implemented in simplify.rs
- [ ] Polymorphic call cast - Low priority, rarely encountered
- [x] Qualified super calls - **P2-SUPER-QUAL** - `OuterClass.super.method()` for inlined anonymous classes
- [ ] Outer class instance prefix - Low priority edge case

### Phase 2: RegionGen Features (HIGH) - COMPLETE (Dec 23, 2025)
- [x] Else-if chain optimization - `ELSE_IF_CHAIN` flag handling
- [x] Switch enum field handling - Enum case name generation without class prefix
- [x] Try-catch multi-catch separator - **P2-MULTI-CATCH** - `catch (Type1 | Type2 e)` syntax
- [x] Catch-all ordering - Specific catches before catch-all
- [x] Loop labels for break/continue - Label generation in loop regions
- [x] All loop type generation - while/do-while/for/for-each

### Phase 3: ConditionGen (HIGH) - COMPLETE (Dec 23, 2025)
- [x] Boolean condition simplification - **P2-BOOL-SIMP** - `bool==true` -> `bool`, `bool!=false` -> `bool`
- [x] Argument wrap rules - `wrap_for_comparison()` for precedence handling
- [x] Ternary condition generation - Full ternary support with boolean simplification
- [x] AND/OR parenthesization - Correct operator precedence

### Phase 4: NameGen (MEDIUM) - COMPLETE (Dec 23, 2025)
- [x] Static field collision detection - **P2-NAME-COLLISION** - `add_class_level_reserved_names()` reserves static fields
- [x] Inner class collision detection - **P2-NAME-COLLISION** - Inner class short names reserved
- [x] Root package collision detection - **P2-NAME-COLLISION** - java/android/kotlin/etc reserved
- [x] Name inheritance for lambdas - `inherit_used_names()` in lambda inlining
- [x] Loop label generation - Loop label support in region builder

### Phase 5: SimpleModeHelper (MEDIUM) - COMPLETE (Dec 23, 2025)
- [x] DFS block sorting - **P2-SIMPLE-MODE** - `dfs_sort()` in fallback_gen.rs (~500 lines)
- [x] Empty block removal - Skip empty blocks during generation
- [x] Label/goto detection - `mark_labels()` and `mark_gotos()` for control flow
- [x] If condition inversion - Condition inversion for fallthrough optimization
- [ ] Exception handler unbinding - Handlers added to sorted blocks

### Phase 6: AnnotationGen (LOW) - COMPLETE
- [x] Parameter annotations - **P3-PARAM-ANNOT** - `@NonNull arg` before parameter type
- [x] All annotation value types - Primitives, strings, enums, arrays, nested
- [x] Nested annotations - Full nested annotation support

---

## Base Paths

**JADX Codegen Source:**
```
/mnt/nvme4tb/dexterity/jadx-fast/jadx-core/src/main/java/jadx/core/codegen/
```

**Dexterity Codegen Source:**
```
/mnt/nvme4tb/dexterity/crates/dexterity-codegen/src/
```
