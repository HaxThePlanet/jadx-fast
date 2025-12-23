# JADX Codegen Clone Status

## Source-Level Audit Report

This document provides a detailed source-level comparison between JADX codegen (Java) and dexterity-codegen (Rust), identifying what has been cloned, what matches, and what gaps remain.

**Audit Date:** 2025-12-23
**JADX Source:** `jadx-fast/jadx-core/src/main/java/jadx/core/codegen/`
**Dexterity Source:** `crates/dexterity-codegen/src/`

---

## File-Level Mapping

| JADX File | Lines | Dexterity Equivalent | Status |
|-----------|-------|---------------------|--------|
| InsnGen.java | 1237 | body_gen.rs, expr_gen.rs | ~95% |
| ClassGen.java | 887 | class_gen.rs | ~90% |
| MethodGen.java | 570 | method_gen.rs | ~95% |
| RegionGen.java | 385 | stmt_gen.rs, body_gen.rs | ~90% |
| ConditionGen.java | 198 | body_gen.rs (conditions) | ~95% |
| TypeGen.java | 137 | type_gen.rs | ~98% |
| AnnotationGen.java | 226 | method_gen.rs | ~85% |
| NameGen.java | 117 | body_gen.rs (naming) | ~90% |
| CodeGenUtils.java | 164 | (scattered) | ~80% |

---

## Detailed Feature Analysis

### 1. InsnGen.java - Instruction Generation

#### 1.1 addArg / addLiteralArg - Negative Literal Wrapping
**JADX Location:** `InsnGen.java:129-136`
```java
private void addLiteralArg(ICodeWriter code, LiteralArg litArg, Set<Flags> flags) {
    String literalStr = lit(litArg);
    if (!flags.contains(Flags.BODY_ONLY_NOWRAP) && literalStr.startsWith("-")) {
        code.add('(').add(literalStr).add(')');
    } else {
        code.add(literalStr);
    }
}
```

**Dexterity Status:** ✅ IMPLEMENTED
**Location:** `expr_gen.rs:1407-1417`
```rust
/// Clone of JADX InsnGen.addLiteralArg() - wraps negative literals to avoid
/// syntax issues like `a - -5` which should be `a - (-5)`
///
/// Reference: jadx-core/src/main/java/jadx/core/codegen/InsnGen.java:129-136
pub fn maybe_paren_wrap(s: &str) -> String {
    // JADX parity: wrap if starts with '-' (negative literal) or contains space
    if s.starts_with('-') || (s.contains(' ') && !s.starts_with('(')) {
        format!("({})", s)
    } else {
        s.to_string()
    }
}
```

#### 1.2 processVarArg - Varargs Array Expansion
**JADX Location:** `InsnGen.java:1149-1172`
```java
private boolean processVarArg(ICodeWriter code, BaseInvokeNode invokeInsn, InsnArg lastArg) {
    if (!invokeInsn.contains(AFlag.VARARG_CALL)) return false;
    if (!lastArg.getType().isArray() || !lastArg.isInsnWrap()) return false;
    InsnNode insn = ((InsnWrapArg) lastArg).getWrapInsn();
    if (insn.getType() != InsnType.FILLED_NEW_ARRAY) return false;
    // Expand array elements...
}
```

**Dexterity Status:** ✅ IMPLEMENTED (comprehensive)
**Location:** `body_gen.rs:7598-7864`
- `extract_vararg_array_elements()` - Extract from FilledNewArray pattern
- `try_expand_vararg()` - Main expansion logic
- `try_expand_pending_vararg_array()` - NewArray+ArrayPut pattern
- `should_heuristic_expand_varargs()` - Heuristic for unknown methods
- `PendingVarargArray` struct - Track arrays being built

#### 1.3 makeArithOneArg - Increment/Decrement Operators
**JADX Location:** `InsnGen.java:1216-1236`
```java
private void makeArithOneArg(ArithNode insn, ICodeWriter code) {
    if (arg.isLiteral() && (op == ArithOp.ADD || op == ArithOp.SUB)) {
        LiteralArg lit = (LiteralArg) arg;
        if (lit.getLiteral() == 1 && lit.isInteger()) {
            addArg(code, resArg, false);
            String opSymbol = op.getSymbol();
            code.add(opSymbol).add(opSymbol);  // i++ or i--
            return;
        }
    }
    // +=, -=, ...
}
```

**Dexterity Status:** ✅ IMPLEMENTED
**Location:** `body_gen.rs:1649-1760, 1839-1934`
- Variable increment: `i++`, `i--`
- Field increment: `obj.field++`
- Static field increment: `Class.field++`
- Compound assignment: `i += 5`, `i -= 3`

#### 1.4 needInvokeArg - Skip 'this' in Method Calls
**JADX Location:** `InsnGen.java:939-950`
```java
private boolean needInvokeArg(InsnArg arg) {
    if (arg.isAnyThis()) {
        if (arg.isThis()) return false;
        ClassNode clsNode = mth.root().resolveClass(arg.getType());
        if (clsNode != null && clsNode.contains(AFlag.DONT_GENERATE)) {
            return false;
        }
    }
    return true;
}
```

**Dexterity Status:** ✅ IMPLEMENTED
**Location:** `body_gen.rs:8840, expr_gen.rs:936, 1132`
- Skip 'this' for instance methods
- Skip for non-generated classes

#### 1.5 filledNewArray - 1000 Element Line Wrap
**JADX Location:** `InsnGen.java:705-724`
```java
wrap++;
if (wrap == 1000) {
    code.startLine();
    wrap = 0;
}
```

**Dexterity Status:** ✅ IMPLEMENTED
**Location:** `body_gen.rs:9352-9368`
```rust
wrap += 1;
if wrap == 1000 {
    code.newline().start_line();
    wrap = 0;
}
```

#### 1.6 makeConstructor - GenericInfoAttr / Diamond Operator
**JADX Location:** `InsnGen.java:765-780`
```java
GenericInfoAttr genericInfoAttr = insn.get(AType.GENERIC_INFO);
if (genericInfoAttr != null) {
    code.add('<');
    if (genericInfoAttr.isExplicit()) {
        // Add explicit generic types
    }
    code.add('>');
}
```

**Dexterity Status:** ❌ NOT IMPLEMENTED
**Impact:** Diamond operator `<>` not generated for generic constructors
**Priority:** Medium

#### 1.7 addOuterClassInstance - Outer Class Constructor Prefix
**JADX Location:** `InsnGen.java:785-804`
```java
private boolean addOuterClassInstance(ConstructorInsn insn, ICodeWriter code, MethodNode callMth) {
    if (callMth == null || !callMth.contains(AFlag.SKIP_FIRST_ARG)) return false;
    // Generate: outer.new Inner()
    addArgDot(code, instArg);
    return true;
}
```

**Dexterity Status:** ❌ NOT IMPLEMENTED
**Impact:** `outer.new Inner()` pattern not generated
**Priority:** Low (edge case)

#### 1.8 isPolymorphicCall Cast
**JADX Location:** `InsnGen.java:863-868`
```java
if (insn.isPolymorphicCall()) {
    code.add('(');
    useType(code, callMth.getReturnType());
    code.add(") ");
}
```

**Dexterity Status:** ❌ NOT IMPLEMENTED
**Impact:** MethodHandle.invoke() return type cast missing
**Priority:** Low (rare)

---

### 2. ClassGen.java - Class Generation

#### 2.1 Import Conflict Detection
**JADX Location:** `ClassGen.java:698-700, 785-816`
```java
if (checkInnerCollision(cls.root(), useCls, extClsInfo)
        || checkInPackageCollision(cls.root(), useCls, extClsInfo)) {
    return fullName;
}
```

**Dexterity Status:** ✅ IMPLEMENTED (simplified)
**Location:** `class_gen.rs:254, 567-620`
```rust
/// Maps simple names to list of fully qualified names (for conflict detection)
simple_name_map: HashMap<String, Vec<String>>,

pub fn get_non_conflicting_imports(&self) -> BTreeSet<String> {
    let conflicting_fqns: BTreeSet<&str> = self.simple_name_map
        .values()
        .filter(|fqns| {
            let unique: BTreeSet<&str> = fqns.iter().map(String::as_str).collect();
            unique.len() > 1  // Multiple FQNs = conflict
        })
        // ...
}
```

**Note:** Dexterity uses simple name collision detection. JADX also checks:
- Inner class name collisions (recursive parent check)
- Same-package class collisions

#### 2.2 expandInnerClassName - Inner Class Name Expansion
**JADX Location:** `ClassGen.java:731-749`
```java
private String expandInnerClassName(ClassInfo useCls, ClassInfo extClsInfo) {
    List<ClassInfo> clsList = new ArrayList<>();
    clsList.add(extClsInfo);
    ClassInfo parentCls = extClsInfo.getParentClass();
    while (parentCls != null) {
        // Build parent chain
    }
    return Utils.listToString(clsList, ".", ClassInfo::getAliasShortName);
}
```

**Dexterity Status:** ⚠️ PARTIAL
**Location:** `class_gen.rs` - Inner class handling exists but may not match exactly
**Impact:** Complex inner class references might differ

#### 2.3 addGenericTypeParameters - Generic Type Bounds
**JADX Location:** `ClassGen.java:234-273`
```java
List<ArgType> list = genericInfo.getExtendTypes();
if (list != null && !list.isEmpty()) {
    code.add(" extends ");
    // Add bounds with & separator
}
```

**Dexterity Status:** ✅ IMPLEMENTED
**Location:** `class_gen.rs` - Generic type parameter generation with bounds

---

### 3. TypeGen.java - Type/Literal Generation

#### 3.1 literalToString with Fallback
**JADX Location:** `TypeGen.java:52-68`
```java
public static String literalToString(LiteralArg arg, MethodNode mth, boolean fallback) {
    // Normal conversion
    if (fallback && Math.abs(lit) > 100) {
        return lit + "(0x" + Long.toHexString(lit) + ", float:" + ... + ")";
    }
}
```

**Dexterity Status:** ✅ IMPLEMENTED
**Location:** `type_gen.rs:256-288`
```rust
/// Clone of JADX TypeGen.literalToString with fallback support
/// Reference: jadx-core/src/main/java/jadx/core/codegen/TypeGen.java:52-68
pub fn literal_to_string_with_fallback(value: i64, ty: &ArgType, fallback: bool) -> String
```

---

### 4. ConditionGen.java - Condition Generation

#### 4.1 Boolean Simplification
**JADX Location:** `ConditionGen.java` - Various simplifications

**Dexterity Status:** ✅ IMPLEMENTED
**Location:** `body_gen.rs`, `expr_gen.rs:1285-1300`
- `== true` → just the boolean
- `!= false` → just the boolean
- `== false` → `!bool`
- `!= true` → `!bool`

---

### 5. AnnotationGen.java - Annotation Generation

#### 5.1 getParamName - Annotation Parameter Alias
**JADX Location:** `AnnotationGen.java` - Parameter name lookup

**Dexterity Status:** ⚠️ NEEDS VERIFICATION
**Location:** `method_gen.rs` - Annotation handling exists

---

## Summary

### Verified as Cloned ✅
1. Negative literal wrapping (`maybe_paren_wrap`)
2. Varargs expansion (comprehensive implementation)
3. Increment/decrement operators (`i++`, `i--`, `obj.field++`)
4. 1000-element line wrap for filled arrays
5. Fallback mode literal hex output
6. Import conflict detection (simple name collisions)
7. Boolean condition simplification
8. Skip 'this' in method calls

### Gaps Identified ❌
1. **GenericInfoAttr / Diamond Operator** - `new ArrayList<>()` not generated
2. **addOuterClassInstance** - `outer.new Inner()` pattern
3. **isPolymorphicCall cast** - MethodHandle return type cast
4. **checkInnerCollision** - Recursive inner class collision check
5. **checkInPackageCollision** - Same-package collision check

### Priority for Cloning
| Feature | Priority | Effort | Impact |
|---------|----------|--------|--------|
| Diamond Operator | Medium | Low | Visual parity |
| Inner Class Collision | Low | Medium | Edge cases |
| Outer Class Instance | Low | Low | Rare |
| Polymorphic Cast | Low | Low | Very rare |
| Package Collision | Low | Medium | Edge cases |

---

### 6. MethodGen.java - Method Generation

#### 6.1 addMethodArguments - Varargs in Signature
**JADX Location:** `MethodGen.java:240-252`
```java
if (!it.hasNext() && mth.getAccessFlags().isVarArgs()) {
    if (argType.isArray()) {
        ArgType elType = argType.getArrayElement();
        classGen.useType(code, elType);
        code.add("...");  // Type... args
    }
}
```

**Dexterity Status:** ✅ IMPLEMENTED
**Location:** `method_gen.rs` - Varargs signature with `...` syntax

#### 6.2 isCommentEscapeNeeded - Escape `*/` in Dumps
**JADX Location:** `MethodGen.java:513-521`
```java
if (option == COMMENTED_DUMP) {
    if (insn.getType() == InsnType.CONST_STR) {
        String str = ((ConstStringNode) insn).getString();
        return str.contains("*/");
    }
}
```

**Dexterity Status:** ⚠️ PARTIAL
**Impact:** Strings containing `*/` in comment dumps might break
**Priority:** Low

#### 6.3 @Override Annotation
**JADX Location:** `MethodGen.java:191-208`

**Dexterity Status:** ✅ IMPLEMENTED
**Location:** `method_gen.rs` - @Override annotation generation

---

### 7. RegionGen.java - Control Flow Regions

#### 7.1 Else-If Chain
**JADX Location:** `RegionGen.java:152-162`
```java
private boolean connectElseIf(ICodeWriter code, IContainer els) {
    if (els.contains(AFlag.ELSE_IF_CHAIN)) {
        IContainer elseBlock = RegionUtils.getSingleSubBlock(els);
        if (elseBlock instanceof IfRegion) {
            makeIf((IfRegion) elseBlock, code, false);
            return true;
        }
    }
    return false;
}
```

**Dexterity Status:** ✅ IMPLEMENTED
**Location:** `body_gen.rs:5749` - Else-if chain detection and generation

#### 7.2 Multi-Catch Syntax
**JADX Location:** `RegionGen.java:354-361`
```java
while (it.hasNext()) {
    code.add(" | ");
    useClass(code, it.next());
}
```

**Dexterity Status:** ✅ IMPLEMENTED
**Location:** `body_gen.rs:6269-6280`
```rust
} else if handler.is_multi_catch() {
    // Multi-catch: catch (Type1 | Type2 | Type3 e)
```

#### 7.3 Enum Switch Case
**JADX Location:** `RegionGen.java:273-286`
```java
if (k instanceof FieldNode) {
    FieldNode fld = (FieldNode) k;
    useField(code, fld.getFieldInfo(), fld);
}
```

**Dexterity Status:** ✅ IMPLEMENTED
**Location:** `body_gen.rs:5590`, `class_gen.rs:173-198` - Enum switch mapping support

#### 7.4 DeclareVariables at Region Start
**JADX Location:** `RegionGen.java:69-79`

**Dexterity Status:** ✅ IMPLEMENTED
**Location:** Variable declarations handled in region generation

---

## Summary Stats

| Category | JADX Features | Dexterity Status |
|----------|--------------|------------------|
| InsnGen | 15+ major | ~95% cloned |
| ClassGen | 10+ major | ~90% cloned |
| MethodGen | 8+ major | ~95% cloned |
| RegionGen | 8+ major | ~95% cloned |
| TypeGen | 5+ major | ~98% cloned |
| ConditionGen | 4+ major | ~95% cloned |
| AnnotationGen | 5+ major | ~85% cloned |

**Overall Estimated Parity: ~93%** (Source-Level Audit, Dec 23, 2025)

---

## Remaining Gaps for 100% Parity

The following features are NOT yet implemented and prevent 100% JADX parity:

### Gap 1: Diamond Operator (GenericInfoAttr)
**JADX Location:** `InsnGen.java:765-780`
**Impact:** Generic constructors do not generate `<>` syntax
**Example:** `new ArrayList<String>()` instead of `new ArrayList<>()`
**Priority:** Medium (visual parity only, semantically correct)

### Gap 2: Outer Class Constructor Prefix
**JADX Location:** `InsnGen.java:785-804`
**Impact:** Inner class constructors with outer instance don't use `outer.new Inner()` syntax
**Example:** `new Inner(outer)` instead of `outer.new Inner()`
**Priority:** Low (rare edge case)

### Gap 3: Polymorphic Call Return Cast
**JADX Location:** `InsnGen.java:863-868`
**Impact:** MethodHandle.invoke() calls don't cast return type
**Example:** Missing `(ReturnType)` prefix on polymorphic invoke results
**Priority:** Low (very rare in real APKs)

### Gap 4: Inner Class Name Collision Check
**JADX Location:** `ClassGen.java:785-816`
**Impact:** Recursive inner class name collision detection not implemented
**Note:** Simple name collision IS implemented; only recursive parent check is missing
**Priority:** Low (edge case)

### Gap 5: Comment Escape (`*/`)
**JADX Location:** `MethodGen.java:513-521`
**Impact:** Strings containing `*/` in commented dumps may break multi-line comments
**Priority:** Low (only affects fallback/comment mode)

---

## JADX Reference Comments Standard

When cloning JADX functionality, use this comment format:

```rust
/// Clone of JADX [ClassName].[methodName] - [brief description]
/// Reference: jadx-core/src/main/java/jadx/core/[path]/[File].java:[lines]
```

Example:
```rust
/// Clone of JADX InsnGen.addLiteralArg() - wraps negative literals to avoid
/// syntax issues like `a - -5` which should be `a - (-5)`
///
/// Reference: jadx-core/src/main/java/jadx/core/codegen/InsnGen.java:129-136
pub fn maybe_paren_wrap(s: &str) -> String {
```
