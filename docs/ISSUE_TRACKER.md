# Issue Tracker

**Status:** 5 P1 Issues Open (Dec 20, 2025) - 6 P0 Fixed, 1 Not A Bug

## Fixed Issues - P0 Critical (All Resolved)

### NEW-001: Static Final Fields Initialized to Null

**Priority:** P0 - COMPILATION ERROR
**Scope:** 30+ files
**APKs:** Medium, Large
**Status:** FIXED (Dec 20, 2025)

**Problem:**
```java
// Dexterity (WRONG):
private static final byte[] DIGITS = null;
static {
    DIGITS = new byte[]{48, 49, ...};  // ERROR: Cannot reassign final
}

// JADX (CORRECT):
private static final byte[] DIGITS = {48, 49, 50, 51, ...};
// OR:
private static final Pattern BOUNDARY_PATTERN;  // No initializer
static {
    BOUNDARY_PATTERN = Pattern.compile(...);  // Assigned in static block
}
```

**Fix:** Modified `extract_field_init.rs` to:
1. Clear null initial values for fields with non-constant clinit assignments
2. Only extract the LAST SPUT per field, skip if any SPUT is non-constant

**Result:** 344 → 4 `static final = null` patterns (99% reduction). Remaining 4 are legitimate null fields.

---

### NEW-002: Undefined/Uninitialized Variables

**Priority:** P0 - COMPILATION ERROR
**Scope:** 40+ methods
**Status:** FIXED (Dec 20, 2025)

**Problem:**
```java
// Dexterity (WRONG - before fix):
int i;  // Never initialized
while (i < 16) {  // ERROR: Variable i might not have been initialized
    i++;
}

// Dexterity (CORRECT - after fix):
int i = 0;  // PHI constant init included
while (i < 16) {
    i++;
}
```

**Files Affected:**
- `MD5Utils.java`, `h.java` (grpc), `ZendeskDiskLruCache.java`, +37 more

**Root Cause:** PHI variable declarations didn't include constant initializers from SSA sources

**Fix Applied:** Modified `body_gen.rs` to:
1. Added `phi_constant_inits` field to track constant sources for PHI variables
2. Added `collect_phi_constant_inits()` to scan SSA before consumption
3. Modified `emit_phi_declarations()` to emit `int i = 0;` instead of `int i;`
4. Added type compatibility checks (boolean 0/1 → false/true, objects → null)

**Result:** Medium APK: 4 → 20 initialized variables. Large APK: 5,432 initialized (83% coverage).

---

### NEW-003: throw non-Throwable

**Priority:** P0 - COMPILATION ERROR
**Scope:** 5+ methods
**Status:** FIXED (Dec 20, 2025)
**Commit:** `6b023278e`

**Problem:**
```java
// Dexterity (WRONG - before fix):
int i = 0;
throw i;  // ERROR: Incompatible types: int cannot be converted to Throwable

// Dexterity (CORRECT - after fix):
/* JADX WARN: Attempted to throw non-Throwable value */
throw null;
```

**Files Affected:**
- `h.java` (io.grpc.k1) lines 175, 185, 1081, 1244, 1272

**Root Cause:** `body_gen.rs` - Exception object tracking lost in CFG

**Fix Applied:** Added validation in `body_gen.rs` that checks if the throw argument is a valid Throwable type. For non-Throwable types (primitives like int, boolean, etc.), emits `throw null;` with a JADX-style warning comment to maintain compilability.

---

### NEW-004: Variable Type Confusion

**Priority:** P0 - COMPILATION ERROR
**Scope:** 20+ methods
**Status:** FIXED (Dec 20, 2025)

**Problem:**
```java
// Dexterity (WRONG - before fix):
String source = "BadAccessibility";
source = obj.getSource();  // ERROR: AccessibilityNodeInfo cannot be assigned to String
source.recycle();          // ERROR: String has no recycle() method

// Dexterity (CORRECT - after fix):
String str = "BadAccessibility";
AccessibilityNodeInfo source = event.getSource();
source.recycle();
```

**Files Affected:**
- `BadAccessibilityService.java`, `NanoHTTPD.java`, +18 more

**Root Cause:** `var_naming.rs:250-255` - `types_compatible_for_naming()` returned `true` for any two Object types

**Fix Applied:** Modified `var_naming.rs:255` to require exact class match for Object types:
```rust
// Before (TOO PERMISSIVE):
(ArgType::Object(_), ArgType::Object(_)) => true,

// After (CORRECT - line 255):
(ArgType::Object(name1), ArgType::Object(name2)) => name1 == name2,
```

Different object types (String vs AccessibilityNodeInfo) now get separate variable names, preventing type confusion.

---

### NEW-005: Kotlin Singleton INSTANCE Uninitialized

**Status:** NOT A BUG (Dec 20, 2025)

**Analysis:** INSTANCE fields ARE properly initialized in static blocks:
```java
public static final BillingFactory INSTANCE;
static {
    BillingFactory.INSTANCE = new BillingFactory();
}
```
This is valid Java - static final fields can be initialized in static initializer blocks.
The original issue description was incorrect.

---

### NEW-006: Enum Constant Wrong Types

**Priority:** P0 - COMPILATION ERROR
**Scope:** Multiple enums
**Status:** FIXED (Dec 20, 2025)
**Commits:** `6c161be5c`, `c967197ad`

**Problem:**
```java
// Dexterity (WRONG - before fix):
public enum b {
    OK(false),           // ERROR: Expected int, got boolean
    CANCELLED(true),
    PERMISSION_DENIED(6),
    RESOURCE_EXHAUSTED(5),  // Duplicate values - register reuse caused wrong values
}

// JADX (CORRECT - after fix):
public enum b {
    OK(0),
    CANCELLED(1),
    ...
    PERMISSION_DENIED(7),
    RESOURCE_EXHAUSTED(8),
}
```

**Files Affected:**
- `d1.java` (io.grpc), other enums

**Root Cause:** Two issues:
1. `enum_visitor.rs` incorrectly converted Int(0)/Int(1) to Bool(false)/Bool(true)
2. Enum argument lookup searched forward, causing register reuse to match wrong values for enums with 7+ constants

**Fix Applied:**
1. Removed Int(0/1)->Bool conversion - integers stay as integers (commit `6c161be5c`)
2. Changed to search BACKWARDS from instruction index to find nearest preceding definition (commit `c967197ad`)

---

### NEW-007: Unreachable Code After Return

**Priority:** P0/P1 - COMPILATION WARNING/ERROR
**Scope:** 15+ methods
**Status:** FIXED (Dec 20, 2025)

**Problem:**
```java
// Dexterity (WRONG):
return this.o.values().toArray(h.Z);
synchronized (obj) {  // UNREACHABLE
    return this.o.values().toArray(h.Z);
}

// JADX (CORRECT):
synchronized (this.l) {
    gVarArr = (g[]) this.o.values().toArray(Z);
}
return gVarArr;
```

**Root Cause:** `region_builder.rs` - Synchronized block boundaries wrong

---

## Open Issues - P1 High (Wrong Semantics)

### NEW-008: Malformed Synchronized Blocks
**Scope:** 10+ methods - Statements outside sync that should be inside

### NEW-009: Missing Imports
**Scope:** Many files - `Function1`, `List` used without import

### NEW-010: Boolean vs Null Comparisons
**Scope:** Multiple - `isClosed() == null` where boolean

### NEW-011: Parameter/Field Mismatch
**Scope:** 30+ methods - Wrong parameter assigned to field

### NEW-012: Constructor Result Discarded
**Scope:** 20+ methods - `new Foo(...)` result not assigned

---

## Previously Fixed

| ID | Bug | Fixed |
|----|-----|-------|
| BUG-001 to BUG-007 | Original P0 bugs | Dec 20, 2025 |
| P1-001 to P1-004 | Original P1 bugs | Dec 20, 2025 |
| NEW-001 | Static final = null + reassign | Dec 20, 2025 |
| NEW-002 | Undefined/uninitialized variables | Dec 20, 2025 |
| NEW-003 | throw non-Throwable validation | Dec 20, 2025 |
| NEW-004 | Variable type confusion | Dec 20, 2025 |
| NEW-006 | Enum wrong types / backwards search fix | Dec 20, 2025 |
| NEW-007 | Unreachable code after return | Dec 20, 2025 |
| Variable Naming | Long prefix l->j, OBJ_ALIAS | Dec 20, 2025 |
| P2-001 | JADX parity for variable naming | Dec 20, 2025 |

---

### P2-001: JADX Parity for Variable Naming in Method Parameters

**Priority:** P2 - MEDIUM
**Status:** FIXED (Dec 20, 2025)
**Commit:** `d60cf950b`

**Problem:** Variable naming for method parameters did not match JADX output, causing inconsistent decompiled code.

**Fix Applied:**
1. Added "Var" suffix for short class names (< 3 characters)
   - Example: `AB` class becomes `abVar` instead of `ab`
2. Implemented OBJ_ALIAS mappings matching JADX:
   - `String` -> `str`, `StringBuilder/StringBuffer` -> `sb`
   - `Map/HashMap/LinkedHashMap/TreeMap` -> `map`
   - `List/ArrayList/LinkedList` -> `list`
   - `Set/HashSet/TreeSet` -> `set`
   - `Iterator` -> `it`, `Exception` -> `exc`, etc.
3. Added collision detection with suffixes starting at 2
   - Example: `str`, `str2`, `str3`, etc.
4. Added `is_static` parameter to fix off-by-one error in parameter register calculation

**Files Changed:**
- `crates/dexterity-passes/src/var_naming.rs` - Core naming logic
- `crates/dexterity-codegen/src/method_gen.rs` - Parameter naming
- `crates/dexterity-codegen/src/body_gen.rs` - Variable naming in body

---

## Bug Report Template

```markdown
**Priority:** P0/P1/P2/P3
**Category:** Codegen / Control Flow / Type System / Variable Naming

**APK:** [name]
**Class:** [fully qualified]
**Method:** [if applicable]

**JADX Output (correct):**
[code]

**Dexterity Output (wrong):**
[code]

**Description:**
[explanation]
```
