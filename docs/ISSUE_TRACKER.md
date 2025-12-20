# Issue Tracker

**Status:** 5 P0 + 5 P1 Critical Issues Open (Dec 20, 2025)

## Open Issues - P0 Critical (Won't Compile)

### NEW-001: Static Final Fields Initialized to Null

**Priority:** P0 - COMPILATION ERROR
**Scope:** 30+ files
**APKs:** Medium, Large

**Problem:**
```java
// Dexterity (WRONG):
private static final byte[] DIGITS = null;
static {
    DIGITS = new byte[]{48, 49, ...};  // ERROR: Cannot reassign final
}

// JADX (CORRECT):
private static final byte[] DIGITS = {48, 49, 50, 51, ...};
```

**Files Affected:**
- `Buffer.java`, `NanoHTTPD.java`, `MD5Utils.java`, `FactoryPools.java`, `LazyHeaders.java`, +25 more

**Root Cause:** `class_gen.rs` - Field init extraction fails to inline array initializers

---

### NEW-002: Undefined/Uninitialized Variables

**Priority:** P0 - COMPILATION ERROR
**Scope:** 40+ methods

**Problem:**
```java
// Dexterity (WRONG):
int i;  // Never initialized
while (i < 16) {  // ERROR: Variable i might not have been initialized
    i++;
}

// JADX (CORRECT):
for (int i = 0; i < 16; i++) {
    ...
}
```

**Files Affected:**
- `MD5Utils.java`, `h.java` (grpc), `ZendeskDiskLruCache.java`, +37 more

**Root Cause:** `loops.rs`, `var_naming.rs` - Loop variable initialization lost

---

### NEW-003: throw non-Throwable

**Priority:** P0 - COMPILATION ERROR
**Scope:** 5+ methods
**Status:** FIXED by bigballs (Dec 20, 2025)

**Problem:**
```java
// Dexterity (WRONG):
int i = 0;
throw i;  // ERROR: Incompatible types: int cannot be converted to Throwable

// JADX (CORRECT):
throw null;  // or proper exception
```

**Files Affected:**
- `h.java` (io.grpc.k1) lines 175, 185, 1081, 1244, 1272

**Root Cause:** `body_gen.rs` - Exception object tracking lost in CFG

---

### NEW-004: Variable Type Confusion

**Priority:** P0 - COMPILATION ERROR
**Scope:** 20+ methods

**Problem:**
```java
// Dexterity (WRONG):
String source = "BadAccessibility";
source = obj.getSource();  // ERROR: AccessibilityNodeInfo cannot be assigned to String
source.recycle();          // ERROR: String has no recycle() method

// JADX (CORRECT):
Log.d("BadAccessibility", ...);
AccessibilityNodeInfo source = event.getSource();
source.recycle();
```

**Files Affected:**
- `BadAccessibilityService.java`, `NanoHTTPD.java`, +18 more

**Root Cause:** `type_inference.rs`, `var_naming.rs` - Same name reused for different types

---

### NEW-005: Kotlin Singleton INSTANCE Uninitialized

**Priority:** P0 - RUNTIME NPE
**Scope:** All Kotlin object declarations

**Problem:**
```java
// Dexterity (WRONG):
public static final MaliciousPatterns INSTANCE;  // Uninitialized!

// JADX (CORRECT):
public static final MaliciousPatterns INSTANCE = new MaliciousPatterns();
```

**Files Affected:**
- All Kotlin `object` declarations, `Companion` objects

**Root Cause:** `dexterity-kotlin/` - Singleton pattern not detected

---

### NEW-006: Enum Constant Wrong Types

**Priority:** P0 - COMPILATION ERROR
**Scope:** Multiple enums
**Status:** FIXED by bigballs (Dec 20, 2025)

**Problem:**
```java
// Dexterity (WRONG):
public enum b {
    OK(false),           // ERROR: Expected int, got boolean
    CANCELLED(true),
    PERMISSION_DENIED(6),
    RESOURCE_EXHAUSTED(5),  // Duplicate values
}

// JADX (CORRECT):
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

**Root Cause:** `class_gen.rs` - Enum bytecode value decoding

---

### NEW-007: Unreachable Code After Return

**Priority:** P0/P1 - COMPILATION WARNING/ERROR
**Scope:** 15+ methods

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
| NEW-003 | throw non-Throwable | Dec 20, 2025 (bigballs) |
| NEW-006 | Enum wrong value types | Dec 20, 2025 (bigballs) |
| Variable Naming | Long prefix l->j, OBJ_ALIAS | Dec 20, 2025 |

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
