# Dexterity Passes Clone Master Gaps

**Date:** 2024-12-24
**Source Truth:** JADX jadx-fast source code + actual decompilation output comparison
**Test APK:** badboy.apk (com.prototype.badboy.MaliciousPatterns.java)

## Executive Summary

Comparative analysis of JADX vs Dexterity output reveals significant quality gaps despite having 70 pass files vs JADX's 124 visitors. The gaps fall into these critical categories:

1. **Ternary Restoration BROKEN** - Detection exists but produces empty if/else blocks
2. **For-Each Loop Detection BROKEN** - Shows broken while loops with undefined variables
3. **Variable Resolution BROKEN** - Many SSA versions not resolving to values
4. **Static Initializer BROKEN** - Empty static {} blocks
5. **Method Throws Clauses MISSING** - Not adding throws to method signatures
6. **Lambda/Anonymous Class INCOMPLETE** - Wrong inline handling

---

## P0: CRITICAL - Ternary Expressions Not Generating

### Problem
**Dexterity Output:**
```java
inputStreamReader = new InputStreamReader(inputStream, Charsets.UTF_8);
if ((Reader)inputStreamReader instanceof BufferedReader) {
} else {
}
return TextStreamsKt.readText(inputStreamReader);
```

**JADX Output:**
```java
Reader inputStreamReader = new InputStreamReader(inputStream, Charsets.UTF_8);
return TextStreamsKt.readText(inputStreamReader instanceof BufferedReader
    ? (BufferedReader) inputStreamReader
    : new BufferedReader(inputStreamReader, 8192));
```

### Root Cause Analysis
The code for ternary detection exists in `body_gen.rs:5987-5990` but is returning `None`. The issue is:
1. `detect_ternary_pattern()` requires single-instruction blocks
2. JADX TernaryMod.java has special handling for `instanceof ? cast : constructor` pattern
3. The CheckCast instruction handling may not be creating proper inline expressions

### JADX Reference
- **File:** `jadx-core/src/main/java/jadx/core/dex/visitors/regions/TernaryMod.java`
- **Lines:** 67-170 (makeTernaryInsn)
- **Key Logic:** Lines 195-209 (getTernaryInsnBlock) requires exactly 1 instruction

### Clone Tasks (Multi-Part Fix)

**Part A: CheckCast Inline Expression Leaking into Conditions**
```rust
// body_gen.rs line 4274 - gen_arg_with_inline_peek is picking up CheckCast expressions
// for instanceof conditions, causing: "(Reader)x instanceof BufferedReader"
//
// FIX: When generating instanceof conditions, don't use inlined CheckCast expressions
// The cast is redundant for instanceof - use original variable name instead.
```

**Part B: Detect CheckCast-based Ternary Pattern**
```rust
// body_gen.rs - Add detection for instanceof+CheckCast+NewInstance pattern
// Reference: JADX TernaryMod.java lines 137-168
//
// Pattern:
//   if (x instanceof Y) { check-cast x to Y } else { new Y(x) }
//
// Detection:
//   1. Then-block has only CheckCast instruction (modifies in place, no dest)
//   2. Else-block has NewInstance + constructor invoke
//   3. Types match the instanceof check
//
// Generate:
//   x instanceof Y ? (Y)x : new Y(x, ...)
```

**Part C: CheckCast Block Recognition**
```rust
// body_gen.rs detect_simple_ternary line 4946
// Empty check fails because CheckCast has no dest - get_insn_dest returns None
//
// FIX: Add special handling for blocks containing only CheckCast
// - Extract cast expression: "(Type)object"
// - Use input register's SSA version as dest for ternary tracking
```

---

## P0: CRITICAL - For-Each Loops Not Restoring

### Problem
**Dexterity Output (isRooted method):**
```java
String[] strArr = new String[14];
strArr[0] = "/system/bin/su";
// ...
while (i < strArr.length) {
    i2 = 0;
    if (file.exists()) {  // ERROR: 'file' undefined!
        break;
    }
}
return i;  // ERROR: returns wrong value
```

**JADX Output:**
```java
String[] rootPaths = {"/system/bin/su", ...};
for (String str : rootPaths) {
    if (new File(str).exists()) {
        return true;
    }
}
return false;
```

### Root Cause Analysis
1. `loop_analysis.rs` has array for-each detection but isn't finding the pattern
2. The AGET instruction and index variable aren't being linked
3. Variable `file` shows SSA version resolution failure

### JADX Reference
- **File:** `jadx-core/src/main/java/jadx/core/dex/visitors/regions/LoopRegionVisitor.java`
- **Lines:** 146-244 (checkArrayForEach)
- **Key Logic:** Lines 177-209 (matching AGET with index variable)

### Clone Task
```rust
// loop_analysis.rs - Clone JADX checkArrayForEach exactly
// 1. Verify increment is ADD literal 1
// 2. Verify init is CONST 0
// 3. Find AGET with matching index register in body
// 4. Verify array in AGET matches condition's ARRAY_LENGTH
```

---

## P1: HIGH - Variable Resolution Failures

### Problem
Multiple undefined variables in output:
- `file` (in isRooted, checkMagisk loops)
- `file2` (in checkSuBinary, checkBusybox)
- `split$default`, `item`, `itemAt`, `intOrNull`, `text`, `object` (various methods)

### Root Cause
SSA version resolution failing - variables defined but not connected to their defining instructions during codegen.

### JADX Reference
- **File:** `jadx-core/src/main/java/jadx/core/dex/visitors/regions/variables/ProcessVariables.java`
- **File:** `jadx-core/src/main/java/jadx/core/codegen/InsnGen.java`

### Clone Task
Audit `expr_gen.rs` variable resolution against JADX ProcessVariables.java

---

## P1: HIGH - Static Initializer Empty

### Problem
**Dexterity Output:**
```java
static {
}
```

**JADX Output:**
```java
static {
    String str = "exec";
    Intrinsics.checkNotNullExpressionValue(str, "toString(...)");
    c = str;
    adSdkStrings = CollectionsKt.listOf(new String[]{...});
    $stable = 8;
}
```

### Root Cause Analysis
1. `extract_field_init.rs` is extracting TOO MUCH - moving field inits that JADX keeps in clinit
2. JADX has specific rules for what can be extracted vs. what stays:
   - Only simple CONST/CONST_STRING followed by SPUT
   - Complex expressions (method calls, new arrays) stay in clinit
3. After extraction, clinit may have SPUTs but their values can't be resolved

### JADX Reference
- **File:** `jadx-core/src/main/java/jadx/core/dex/visitors/ExtractFieldInit.java`
- **Key Logic:** Lines 86-147 - isFieldValueValid() determines what CAN be extracted
- Complex assignments (INVOKE, NEW_ARRAY, etc.) are NOT extracted

### Clone Tasks

**Part A: Match JADX Extraction Criteria**
```rust
// extract_field_init.rs - Clone JADX isFieldValueValid logic
// Only extract if ALL conditions met:
// 1. Value is CONST, CONST_STRING, or CONST_CLASS
// 2. Field is final (static final only for extraction)
// 3. No side effects in value computation
//
// Reference: ExtractFieldInit.java lines 97-120
```

**Part B: Preserve Clinit Body for Complex Inits**
```rust
// extract_field_init.rs - Don't mark SPUTs for removal if:
// 1. Value comes from method invocation (e.g., listOf())
// 2. Value is a new array with initializers
// 3. Value depends on other field values
//
// Reference: ExtractFieldInit.java lines 128-145
```

---

## P1: HIGH - Method Throws Clauses Missing

### Problem
**Dexterity:** `public final String execCommand1(String cmd) {`
**JADX:** `public final String execCommand1(String cmd) throws IOException {`

### JADX Reference
- **File:** `jadx-core/src/main/java/jadx/core/dex/visitors/MethodThrowsVisitor.java`
- Propagates checked exceptions from invokes

### Clone Task
Verify `method_throws_visitor.rs` is collecting and emitting throws

---

## P2: MEDIUM - Private Constructor Missing

### Problem
**Dexterity:** No constructor generated
**JADX:** `private MaliciousPatterns() {}`

### JADX Reference
- **File:** `jadx-core/src/main/java/jadx/core/dex/visitors/ConstructorVisitor.java`

### Clone Task
Verify `constructor_visitor.rs` handles Kotlin singleton pattern

---

## P2: MEDIUM - Type Declaration Mismatch

### Problem
**Dexterity:** `InputStreamReader inputStreamReader;`
**JADX:** `Reader inputStreamReader = ...;`

JADX uses broader type (Reader) when the variable flows through an instanceof check.

### JADX Reference
- **File:** `jadx-core/src/main/java/jadx/core/dex/visitors/typeinference/TypeInferenceVisitor.java`
- Type widening for instanceof patterns

---

## JADX Visitors Missing in Dexterity

| JADX Visitor | Dexterity Equivalent | Status |
|-------------|---------------------|--------|
| AttachCommentsVisitor | - | MISSING |
| DotGraphVisitor | - | MISSING (debug) |
| FallbackModeVisitor | - | MISSING |
| MarkFinallyVisitor | finally_extract.rs | PARTIAL |
| NonFinalResIdsVisitor | - | MISSING |
| ProcessKotlinInternals | kotlin_intrinsics.rs | PARTIAL |
| ProcessMethodsForInline | method_inline.rs | PARTIAL |
| ResolveJavaJSR | - | MISSING (legacy) |
| SourceFileRename | - | MISSING |
| UserRenames | - | MISSING |
| VisibilityUtils | - | MISSING |

## Priority Implementation Order

1. **P0-TERNARY:** Fix ternary detection for instanceof+cast pattern
2. **P0-FOREACH:** Fix array for-each detection with JADX exact clone
3. **P1-VARRES:** Audit SSA variable resolution in expr_gen
4. **P1-CLINIT:** Fix static initializer body generation
5. **P1-THROWS:** Fix method throws clause emission
6. **P2-CTOR:** Fix private constructor generation
7. **P2-TYPE:** Type widening for instanceof patterns

## Testing Methodology

After each fix:
```bash
# Decompile with both tools
/mnt/nvme4tb/dexterity/crates/target/release/dexterity /mnt/nvme4tb/dexterity/apks/badboy.apk -d /tmp/dex
/mnt/nvme4tb/dexterity/jadx-fast/build/jadx/bin/jadx /mnt/nvme4tb/dexterity/apks/badboy.apk -d /tmp/jadx

# Compare specific files
diff /tmp/dex/sources/com/prototype/badboy/MaliciousPatterns.java \
     /tmp/jadx/sources/com/prototype/badboy/MaliciousPatterns.java
```

## Notes

- Framework classes (android.*, kotlin.*) are intentionally filtered - see DESIGN_DECISIONS.md
- Clone JADX exactly - don't improve, match behavior precisely
- Add JADX reference comments for all cloned logic
