# Dexterity Codegen vs JADX Clone Audit

**Date:** 2025-12-23
**Status:** Verified from actual output comparison (output/jadx vs output/dexterity)

## Executive Summary

Direct comparison of `MaliciousPatterns.java` and other files reveals **~70-85% parity** with JADX.
The documentation claims higher, but actual output shows **critical semantic bugs**.

---

## Critical Issues (P0) - Produce Non-Compiling Code

### P0-CG-001: Undefined Variable References
**Status:** Critical
**Files:** `body_gen.rs`, `expr_gen.rs`
**JADX Reference:** `InsnGen.java`, `NameGen.java`

**Problem:**
```java
// DEXTERITY (BROKEN):
if (StringsKt.startsWith$default(fINGERPRINT2, str2, z, i, obj)...
//                               ^^^^^^^^^^^ NEVER DECLARED!

// JADX (CORRECT):
String str = Build.FINGERPRINT;
if (!StringsKt.startsWith$default(str, "generic", false, 2, (Object) null))
```

**Root Cause:**
1. SGET instruction stores inline expression at SSA version X
2. Condition generation looks for expression at SSA version Y
3. Version mismatch causes fallback to var_naming which generates `fINGERPRINT2`
4. But that variable was never declared because it was marked for inlining

**Fix Strategy:**
Clone JADX's approach: Don't merge conditions that require intermediate variable declarations.

---

### P0-CG-002: Wrong Return Types
**Status:** Critical
**Files:** `body_gen.rs`

**Problem:**
```java
// DEXTERITY (BROKEN):
public final boolean isRooted() {
    int i = 0;
    ...
    return i;  // RETURNS INT, NOT BOOLEAN!
}

// JADX (CORRECT):
public final boolean isRooted() {
    for (String str : rootPaths) {
        if (new File(str).exists()) {
            return true;
        }
    }
    return false;
}
```

**Root Cause:**
For-each loop detection/body generation is losing content.

---

### P0-CG-003: For-Each Loop Body Issues
**Status:** PARTIALLY FIXED (2025-12-24)
**Files:** `body_gen.rs`

**Problem:**
```java
// DEXTERITY (BROKEN - BEFORE FIX):
final Iterator it = paths2.iterator();
for (Object next : it) {  // WRONG: iterating over iterator!
    int i = 0;  // LEFTOVER - SHOULD BE SKIPPED!
    (Collection)arrayList.add(new DexClassLoader(next, ...));
    //         ^^^^^^ Missing (String) cast on 'next'
}

// DEXTERITY (AFTER PARTIAL FIX):
while (it.hasNext()) {  // FIXED: proper while loop now
    int i = 0;  // STILL LEFTOVER
    (Collection)arrayList.add(new DexClassLoader(next, ...));
    //         ^^^^^^ 'next' still undefined - needs it.next()
}

// JADX (CORRECT):
Iterator it = list.iterator();
while (it.hasNext()) {
    arrayList.add(new DexClassLoader((String) it.next(), ...));
}
```

**Fix Applied (2025-12-24):**
Disabled broken iterator for-each detection at codegen level in `body_gen.rs:6159-6180`.
Added JADX parity comment referencing `LoopRegionVisitor.java:246-340`.

**Remaining Issues:**
1. `it.next()` call not being generated - `next` variable is undefined
2. `int i = 0;` leftover not being skipped
3. Missing type cast on iterator item
4. Unnecessary `(Collection)` cast being added

**Root Cause Analysis:**
JADX implements iterator for-each detection at IR level (`LoopRegionVisitor.checkIterableForEach`)
with strict validation (iterator use count == 2, etc.) and marks instructions with DONT_GENERATE.
Dexterity's codegen-level approach is fundamentally different and cannot properly handle the transformation.

**Required Fix:**
Clone JADX `LoopRegionVisitor.java:246-340` to `dexterity-passes` as a proper IR pass.
Apply DONT_GENERATE equivalent flags before codegen.

---

### P0-CG-004: Flattened Nested Ifs with Lost Declarations
**Status:** Critical

**Problem:**
JADX generates properly nested ifs with variables declared at each level:
```java
String str = Build.FINGERPRINT;
if (!StringsKt.startsWith$default(str, "generic", ...)) {
    String str2 = Build.FINGERPRINT;
    if (!StringsKt.startsWith$default(str2, "unknown", ...)) {
        // ... more nesting
    }
}
```

Dexterity flattens to a single condition with undefined variables:
```java
if (StringsKt.startsWith$default(fINGERPRINT2, ...) || ...) {
    z = true;
}
```

**Fix Strategy:**
Clone JADX `IfRegionMaker.java` - don't merge conditions when blocks contain variable declarations.

---

## High Priority Issues (P1)

### P1-CG-001: Missing Field Initializers
**Files:** `class_gen.rs`, DEX parsing

**Problem:**
```java
// JADX:
public static final int $stable = 0;

// DEXTERITY:
public static final int $stable;  // MISSING = 0
```

---

### P1-CG-002: Ternary Expression Conversion Failure
**Files:** `body_gen.rs`, `ternary_mod.rs`

**Problem:**
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

---

### P1-CG-003: Synthetic Field Exposure
**Files:** `class_modifier.rs` (NEW)

**Problem:**
```java
// DEXTERITY:
this.this$0.tempFileManagerFactory.create()

// JADX:
NanoHTTPD.this.tempFileManagerFactory.create()
```

**JADX Reference:** `ClassModifier.java:80-149`

---

### P1-CG-004: Redundant else-return Not Eliminated
**Files:** `return_visitor.rs`

**Problem:**
```java
// DEXTERITY:
if (!Strings.hasLength(str)) {
    throw new IllegalArgumentException(str2);
} else {
    return;  // REDUNDANT!
}

// JADX:
if (!Strings.hasLength(str)) {
    throw new IllegalArgumentException(str2);
}
```

**JADX Reference:** `ReturnVisitor.java:41-54`

---

## JADX Source Files for Cloning

| JADX File | Lines | Purpose | Dexterity Equivalent |
|-----------|-------|---------|----------------------|
| `InsnGen.java` | 1237 | Expression generation | `expr_gen.rs`, `body_gen.rs` |
| `RegionGen.java` | 385 | Control flow regions | `body_gen.rs` |
| `NameGen.java` | 117 | Variable naming | `var_naming.rs` |
| `ConditionGen.java` | ~200 | Conditions | `body_gen.rs::generate_condition` |
| `ReturnVisitor.java` | ~100 | Return cleanup | `return_visitor.rs` |
| `IfRegionMaker.java` | ~300 | If structure | `region_builder.rs` |
| `ClassModifier.java` | ~300 | Synthetic removal | `class_modifier.rs` (NEW) |
| `TernaryMod.java` | ~200 | Ternary patterns | `ternary_mod.rs` |

---

## Testing Parity

After each fix:
```bash
cargo build --release
./target/release/dexterity -d output/dexterity/badboy badboy.apk
diff -u output/jadx/badboy/sources/com/prototype/badboy/MaliciousPatterns.java \
       output/dexterity/badboy/sources/com/prototype/badboy/MaliciousPatterns.java
```

---

## File Counts

| APK | JADX Files | Dexterity Files | Gap |
|-----|------------|-----------------|-----|
| badboy | 86 | 53 | -33 (38%) |

---

## Known Working Areas

- Simple class declarations
- Basic method signatures
- Annotation handling
- Import generation
- String constants
- Simple if/else structures
- Constructor generation
- Field declarations (mostly)
