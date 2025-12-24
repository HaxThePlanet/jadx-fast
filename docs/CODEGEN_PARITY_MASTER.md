# Dexterity Codegen JADX Parity - Master Document

**Last Updated:** 2025-12-24
**Status:** ACTIVE - NOT AT 100% PARITY
**Goal:** Clone JADX codegen exactly - 10 years of edge cases, not improvement

---

## Executive Summary

| Metric | Claimed (Docs) | Verified (Output) |
|--------|----------------|-------------------|
| Overall Parity | 93-95% | **70-85%** |
| Compiles Correctly | Yes | **NO** - undefined variables |
| Semantic Correctness | Yes | **NO** - broken loops, wrong types |
| JADX Codegen Cloned | Yes | **PARTIAL** |

**Evidence:** Direct output comparison `output/dexterity/` vs `output/jadx/` on badboy.apk, large.apk

---

## Architecture Comparison

### JADX Codegen (Java) - 4,671 lines
```
jadx-core/src/main/java/jadx/core/codegen/
├── InsnGen.java         (1237 lines) - Instruction→expression (MOST CRITICAL)
├── ClassGen.java         (887 lines) - Class structure, imports, fields
├── MethodGen.java        (570 lines) - Method signatures, bodies
├── RegionGen.java        (385 lines) - Control flow (if/loop/switch/try)
├── AnnotationGen.java    (226 lines) - Annotations
├── ConditionGen.java     (198 lines) - Condition expressions
├── SimpleModeHelper.java (151 lines) - Fallback block-based codegen
├── TypeGen.java          (137 lines) - Type/literal formatting
├── NameGen.java          (117 lines) - Variable name deconfliction
├── CodeGen.java           (62 lines) - Entry point
└── utils/
    ├── CodeGenUtils.java (165 lines) - Comments, errors, metadata
    └── CodeComment.java   (35 lines) - Comment structure
```

### Dexterity Codegen (Rust) - 21,093 lines
```
crates/dexterity-codegen/src/
├── body_gen.rs      (11224 lines) - InsnGen + RegionGen combined
├── class_gen.rs      (2201 lines) - ClassGen equivalent
├── method_gen.rs     (1872 lines) - MethodGen equivalent
├── expr_gen.rs       (1653 lines) - Expression generation
├── dex_info.rs       (1226 lines) - DEX data bridge (no JADX equiv)
├── stmt_gen.rs        (836 lines) - Statement generation
├── type_gen.rs        (680 lines) - TypeGen equivalent
├── fallback_gen.rs    (543 lines) - SimpleModeHelper equivalent
├── stdlib_signatures.rs(423 lines) - Library signature cache
├── access_flags.rs    (219 lines) - Access flag formatting
├── writer.rs          (173 lines) - Code output abstraction
└── lib.rs              (43 lines) - Module exports
```

---

## File-by-File Mapping

| JADX File | Lines | Dexterity Equivalent | Status |
|-----------|-------|---------------------|--------|
| InsnGen.java | 1237 | expr_gen.rs + body_gen.rs | 85% - missing edge cases |
| ClassGen.java | 887 | class_gen.rs | 90% - field init gaps |
| MethodGen.java | 570 | method_gen.rs | 95% |
| RegionGen.java | 385 | body_gen.rs | 80% - loop issues |
| AnnotationGen.java | 226 | method_gen.rs | 100% |
| ConditionGen.java | 198 | body_gen.rs:generate_condition() | 95% |
| SimpleModeHelper.java | 151 | fallback_gen.rs | 100% |
| TypeGen.java | 137 | type_gen.rs | 100% |
| NameGen.java | 117 | var_naming.rs | 85% - CodeVar system missing |
| CodeGen.java | 62 | lib.rs | 100% |
| CodeGenUtils.java | 165 | scattered | 100% |

---

## P0-CRITICAL Gaps (Broken Code Output)

### GAP-01: Variable SSA Version Mismatch

**Symptom:**
```java
// DEXTERITY (BROKEN):
if (StringsKt.startsWith$default(fINGERPRINT2, str2, z, i, obj)...
//                               ^^^^^^^^^^^ NEVER DECLARED!

// JADX (CORRECT):
String str = Build.FINGERPRINT;
if (!StringsKt.startsWith$default(str, "generic", false, 2, (Object) null))
```

**Root Cause:** Expression inlining stores at SSA version X, condition retrieves at version Y

**JADX Reference:** `NameGen.java:50-60` - CodeVar system tracks declaration points
```java
public void assignArg(CodeVar var) {
    if (fallback) {
        var.setName(getFallbackName(var));
    } else {
        String name = makeArgName(var);
        var.setName(getUniqueVarName(name));
    }
}
```

**Fix:** Clone JADX CodeVar system - don't inline when declaration required

---

### GAP-02: Iterator For-Each Loop Broken

**Symptom:**
```java
// DEXTERITY (BROKEN):
while (it.hasNext()) {
    int i = 0;  // LEFTOVER - should be skipped
    arrayList.add(new DexClassLoader(next, ...));
    //                               ^^^^ UNDEFINED - needs it.next()
}

// JADX (CORRECT):
Iterator it = list.iterator();
while (it.hasNext()) {
    arrayList.add(new DexClassLoader((String) it.next(), ...));
}
```

**Root Cause:** JADX does iterator for-each at IR level with 6 validation conditions

**JADX Reference:** `LoopRegionVisitor.java:246-340`
```java
private boolean checkIterableForEach(LoopRegion loop, IfRegion ifRegion) {
    // Condition 1: Single register arg in condition (the iterator)
    // Condition 2: Iterator SSA var not used in phi
    // Condition 3: Iterator use list == 2 (hasNext + next)
    // Condition 4: Iterator from collection.iterator() call
    // Condition 5: hasNext() and next() signatures match
    // Condition 6: Iterator only used within loop
    // ALL conditions must pass for for-each conversion
}
```

**Fix:** Clone to `dexterity-passes/src/loop_visitor.rs` as IR pass

---

### GAP-03: Flattened Nested Ifs Lose Declarations

**Symptom:**
```java
// DEXTERITY (BROKEN):
if (StringsKt.startsWith$default(fINGERPRINT2, ...) || ...) {
    z = true;
}
// Variables fINGERPRINT2, str2 are UNDEFINED!

// JADX (CORRECT):
String str = Build.FINGERPRINT;
if (!StringsKt.startsWith$default(str, "generic", ...)) {
    String str2 = Build.FINGERPRINT;
    if (!StringsKt.startsWith$default(str2, "unknown", ...)) {
        // ... properly nested with declarations at each level
    }
}
```

**JADX Reference:** `IfMakerHelper.java` - Controls condition merging rules

**Fix:** Don't merge conditions when intermediate blocks contain variable declarations

---

### GAP-04: Field Init Extraction (PARTIAL)

**Symptom:**
```java
// DEXTERITY (BROKEN):
static {
}  // EMPTY!
public static final int $stable;  // MISSING = 0

// JADX (CORRECT):
static {
    String str = "exec";
    Intrinsics.checkNotNullExpressionValue(str, "toString(...)");
    c = str;
}
public static final int $stable = 8;
```

**JADX Reference:** `ClassGen.java:462-485` - FieldInitInsnAttr tracking

**Status:** Partially fixed (2025-12-24) but still gaps with complex initializers

---

### GAP-05: Ternary Expression Not Generated

**Symptom:**
```java
// DEXTERITY (BROKEN):
if (object != null) {
    String object3 = object.getClass().getName();
} else {
    String object4 = "null";
}
stringBuilder.append(object2);  // object2 UNDEFINED!

// JADX (CORRECT):
stringBuilder.append(obj != null ? obj.getClass().getName() : "null");
```

**JADX Reference:**
- `InsnGen.java:1174-1194` - `makeTernary()`
- `TernaryMod.java` - IR pass detecting ternary patterns

**Fix:** Clone TernaryMod pattern detection to dexterity-passes

---

## P1-HIGH Gaps (Wrong Semantics)

### GAP-06: For-Each Type Casts Missing
```java
// DEXTERITY: for (Object next : it) { ... next ... }
// JADX: while (it.hasNext()) { ... (String) it.next() ... }
```
**JADX Reference:** `RegionGen.java:199-210`

### GAP-07: Boolean Return with Int Literal
```java
// DEXTERITY: return i;  // Returns int, not boolean!
// JADX: return true/false;
```
**JADX Reference:** `InsnGen.java:366-372`, TypeGen coercion

### GAP-08: Wrong Method Signature Arrays
```java
// DEXTERITY: Runtime.getRuntime().exec("sh", "-c", cmd)  // Wrong!
// JADX: Runtime.getRuntime().exec(new String[]{"sh", "-c", cmd})
```
**JADX Reference:** `InsnGen.java:850-911`

### GAP-09: StringBuilder Chain Not Simplified
```java
// DEXTERITY: StringBuilder sb = new StringBuilder(); sb.append(a); sb.append(b); throw new X(sb.toString());
// JADX: throw new X(a + b);
```
**JADX Reference:** `SimplifyVisitor.java:301-428`

### GAP-10: Redundant else-return Not Eliminated
```java
// DEXTERITY: if (x) { throw e; } else { return; }
// JADX: if (x) { throw e; }
```
**JADX Reference:** `ReturnVisitor.java:41-54`

### GAP-13: Native Method Parameter Names Lost (FIXED 2025-12-24)
```java
// BEFORE: public native int executeShellCommand(String str);
// AFTER:  public native int executeShellCommand(String cmd);
```

### GAP-15: Private Constructor Not Generated (FIXED 2025-12-24)
Now correctly shows private/protected constructors.

---

## P2-MEDIUM Gaps

| Gap | Description | JADX Reference |
|-----|-------------|----------------|
| GAP-11 | Lambda method references | InsnGen.java:952-983 |
| GAP-12 | Varargs array expansion | InsnGen.java:1149-1172 |
| GAP-14 | Static same-class method prefix | InsnGen.java |
| GAP-16 | Diamond operator inference | ClassGen.java |
| GAP-17 | Comment escape in strings | InsnGen.java |

---

## JADX Method -> Dexterity Function Mapping

### InsnGen.java (1237 lines) - MOST CRITICAL

| JADX Method | Lines | Dexterity Equivalent | Status |
|-------------|-------|---------------------|--------|
| addArg() | 103-127 | expr_gen.rs:gen_arg() | DONE |
| assignVar() | 149-156 | body_gen.rs:emit_assignment() | INCOMPLETE - SSA mismatch |
| declareVar() | 158-169 | body_gen.rs:declare_var() | INCOMPLETE |
| makeInsnBody() | 314-651 | body_gen.rs:generate_insn() | 90% |
| makeConstructor() | 727-783 | body_gen.rs:generate_invoke() | 85% |
| makeInvoke() | 850-911 | body_gen.rs:generate_invoke() | 85% - arg array issues |
| makeInvokeLambda() | 912-951 | body_gen.rs | PARTIAL |
| makeRefLambda() | 952-983 | body_gen.rs | PARTIAL |
| makeTernary() | 1174-1194 | body_gen.rs:detect_ternary_pattern() | INCOMPLETE |
| makeArith() | 1196-1214 | expr_gen.rs:gen_binary() | DONE |
| makeArithOneArg() | 1216-1236 | body_gen.rs:detect_increment_decrement() | DONE |
| processVarArg() | 1149-1172 | body_gen.rs:write_typed_args_with_varargs() | DONE |

### RegionGen.java (385 lines)

| JADX Method | Lines | Dexterity Equivalent | Status |
|-------------|-------|---------------------|--------|
| makeRegion() | 50-80 | body_gen.rs:generate_region() | DONE |
| makeIf() | 103-147 | body_gen.rs:generate_region_impl(If) | DONE |
| makeLoop() | 164-229 | body_gen.rs:generate_region_impl(Loop) | INCOMPLETE - for-each |
| makeSwitch() | 244-271 | body_gen.rs:generate_region_impl(Switch) | DONE |
| makeTryCatch() | 313-384 | body_gen.rs:generate_try_catch() | DONE |
| makeSynchronizedRegion() | 289-312 | body_gen.rs | DONE |

### ConditionGen.java (198 lines)

| JADX Method | Lines | Dexterity Equivalent | Status |
|-------------|-------|---------------------|--------|
| add() | 45-77 | body_gen.rs:generate_condition() | DONE |
| addCompare() | 101-132 | body_gen.rs:generate_comparison() | DONE |
| addAndOr() | 147-156 | body_gen.rs:generate_compound_condition() | DONE |
| addNot() | 158-165 | body_gen.rs | DONE |
| addTernary() | 167-175 | body_gen.rs | DONE |

### NameGen.java (117 lines)

| JADX Method | Lines | Dexterity Equivalent | Status |
|-------------|-------|---------------------|--------|
| assignArg() | 50-60 | expr_gen.rs:get_var_name() | INCOMPLETE - CodeVar missing |
| getUniqueVarName() | 70-90 | var_naming.rs:make_unique() | DONE |
| getFallbackName() | 95-105 | expr_gen.rs | DONE |

### ClassGen.java (887 lines)

| JADX Method | Lines | Dexterity Equivalent | Status |
|-------------|-------|---------------------|--------|
| makeClass() | 80-140 | class_gen.rs:generate_class() | DONE |
| addClassDeclaration() | 180-250 | class_gen.rs | DONE |
| addFields() | 380-420 | class_gen.rs | DONE |
| addEnumFields() | 422-460 | class_gen.rs | DONE |
| addField() | 462-485 | class_gen.rs | INCOMPLETE - field init |
| addImports() | 500-550 | class_gen.rs | DONE |
| useClass() | 600-680 | class_gen.rs | DONE |
| addGenerics() | 700-750 | class_gen.rs | DONE |

---

## Clone Priority Matrix

| Priority | Gap ID | Description | JADX Lines | Est. Rust Lines | File |
|----------|--------|-------------|------------|-----------------|------|
| P0 | GAP-01 | SSA->CodeVar mapping | 50-60 | ~100 | expr_gen.rs |
| P0 | GAP-02 | Iterator for-each | 246-340 | ~200 | loop_visitor.rs (NEW) |
| P0 | GAP-03 | Nested if declarations | ~300 | ~150 | region_builder.rs |
| P0 | GAP-04 | Field init body | ~80 | ~100 | class_gen.rs |
| P0 | GAP-05 | Ternary conversion | ~100 | ~150 | ternary_mod.rs |
| P1 | GAP-06 | For-each type casts | ~30 | ~50 | body_gen.rs |
| P1 | GAP-07 | Boolean return | ~20 | ~30 | body_gen.rs |
| P1 | GAP-08 | Invoke arg arrays | ~60 | ~80 | body_gen.rs |
| P1 | GAP-09 | StringBuilder | ~150 | ~200 | simplify_stringbuilder.rs |
| P1 | GAP-10 | else-return | ~50 | ~80 | return_visitor.rs |

**P0+P1 Total:** ~1,140 lines of JADX logic to clone

---

## What's Working (Verified)

These features are confirmed working correctly:

- Simple class declarations and structure
- Basic method signatures with all access modifiers
- Annotation handling (class, method, field, parameter)
- Import generation and collision detection
- String constants and unicode escaping
- Simple if/else structures
- Constructor generation (new-instance + <init> fusion)
- Field declarations with simple initializers
- Switch statements (including string switches)
- Try-catch-finally blocks
- Synchronized blocks
- Break/continue with labels
- Increment/decrement operators (++/--)
- Compound assignments (+=, -=, etc.)
- Varargs expansion
- Type casting (CHECK_CAST)
- Array operations (AGET, APUT, length)
- Static and instance field access
- Method invocation (all 5 kinds)
- Lambda expressions (basic)
- Anonymous class inlining (basic)
- @Override heuristic (300+ library methods)
- Kotlin modifier comments (suspend, inline, operator, etc.)
- Type parameters with variance (<out T>, <in T>)

---

## Testing Methodology

After each fix:
```bash
cargo build --release

# Regenerate output
./target/release/dexterity -d output/dexterity/badboy badboy.apk

# Compare against JADX
diff -u output/jadx/badboy/sources/com/prototype/badboy/MaliciousPatterns.java \
       output/dexterity/badboy/sources/com/prototype/badboy/MaliciousPatterns.java
```

### Key Test Files
- `MaliciousPatterns.java` - For-each loops, ternary, complex conditions
- `Assert.java` - StringBuilder chains, nested ifs
- `Balloon.java` - Kotlin metadata, enum constants
- `NativePayload.java` - Native methods, static initializers

---

## JADX Reference Comment Standard

When cloning JADX code, use this format:
```rust
/// Clone of JADX InsnGen.makeTernary()
/// Converts if-else to ternary expressions.
///
/// Reference: jadx-fast/jadx-core/src/main/java/jadx/core/codegen/InsnGen.java:1174-1194
fn make_ternary(...) {
    // JADX parity: Check single assignment in each branch...
}
```

---

## Document History

This unified document supersedes 12 fragmented docs:
- CODEGEN_CLONE_AUDIT.md
- CODEGEN_CLONE_STATUS.md
- CODEGEN_PARITY.md
- CODEGEN_PARITY_ROADMAP.md
- CODEGEN_CLONE_MASTER_VERIFIED.md
- CODEGEN_CLONE_TASKS_DETAILED.md
- JADX_CODEGEN_PARITY.md
- JADX_CODEGEN_CLONE_STATUS.md
- JADX_CODEGEN_CLONE_MASTER.md
- JADX_CODEGEN_CLONE_TASKS.md
- JADX_CODEGEN_REAL_GAPS.md
- JADX_CODEGEN_REFERENCE.md
