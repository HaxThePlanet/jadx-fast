# Quality Status

**Status:** NOT PRODUCTION-READY | 3 P0 Bugs Remaining | C/C- Grade (60-70%) | 64% File Coverage | Dec 25, 2025
**Last Update:** Dec 25, 2025 - P0-LOGIC-INV and P0-SPURIOUS-RET FIXED
**Goal:** Correct decompilation close to JADX (not byte-for-byte identical)
**Resources:** 1:1 JADX parity achieved (103 directories, 152 files, zero differences)
**Codegen:** ~60-70% semantic correctness; outputs 64% of JADX files
**Open Work:** Undefined variables (P0-UNDEF-VAR), for-each loop returns (P0-FOREACH-SEM)

---

## HONEST ASSESSMENT (Dec 25, 2025)

### Reality vs Previous Claims

| Metric | Previously Claimed | Current Reality |
|--------|-------------------|-----------------|
| Overall Grade | A- (95-96%) | **C/C- (60-70%)** - improved from C-/D+ |
| P0 Bugs | 0 | **3 remaining** (2 fixed Dec 25) |
| Compilable | Yes | **No** - undefined variables (`z`, `mODEL2`) |
| Semantically Correct | Yes | **Partial** - logic fixed, loops still broken |
| Production Ready | Yes | **No** |

### Critical Issues Found (MaliciousPatterns.java)

#### 1. Undefined Variables (Won't Compile)
```java
// Dexterity Line 148-151 - obj never assigned
return TextStreamsKt.readText(obj);  // UNDEFINED!

// Line 428 - mODEL2, mODEL22, mANUFACTURER2, hARDWARE2 undefined
if (!StringsKt.contains$default(mODEL2, ...))  // UNDEFINED!

// Line 642 - i never initialized
strArr[i] = "/system/bin/su";  // i UNDEFINED!
```

#### 2. ~~Logic Inversions~~ ✅ FIXED (Dec 25)
```java
// BEFORE (broken):
if (!Debug.isDebuggerConnected()) {
    if (Debug.waitingForDebugger()) { return false; } else { return true; }
}

// AFTER (fixed):
if (Debug.isDebuggerConnected() || Debug.waitingForDebugger()) {
    z = true;
}
return z;  // Correct semantics
```

#### 3. ~~Spurious Return Statements~~ ✅ FIXED (Dec 25)
```java
// BEFORE (broken): loadMultipleDex()
while (it.hasNext()) {
    return true;   // Unreachable!
    arrayList.add(...);
}

// AFTER (fixed):
while (it.hasNext()) {
    arrayList.add(new DexClassLoader(...));
}
return arrayList;  // Correct - no spurious returns
```

#### 4. Undeclared Variables in Ternary (P0-UNDEF-VAR) 🔴 OPEN
```java
// Current Dexterity - execCommand1 (line 148)
z = inputStreamReader instanceof BufferedReader;  // 'z' NEVER DECLARED!
BufferedReader r3 = inputStreamReader instanceof BufferedReader
    ? (BufferedReader)inputStreamReader
    : new BufferedReader(inputStreamReader, 8192);  // 8192 inlines correctly now
return TextStreamsKt.readText(...);

// detectEmulator$lambda$1 (lines 425-455)
if (!StringsKt.contains$default(mODEL2, ...))  // mODEL2 UNDEFINED!
if (!StringsKt.contains$default(hARDWARE2, ...))  // hARDWARE2 UNDEFINED!
```

#### 5. Empty For-Each Loop Body (P0-FOREACH-SEM) 🔴 OPEN
```java
// Current Dexterity - isRooted() (lines 651-655)
for (String str : strArr) {
    if (new File(str).exists()) {
        // EMPTY! No return statement emitted
    }
}
return z;  // Always returns initial false!

// JADX - Correct
for (String str : strArr) {
    if (new File(str).exists()) {
        return true;  // Returns on match
    }
}
return false;
```

---

## File Coverage

| Tool | Files | Notes |
|------|-------|-------|
| JADX | 86 | Complete output with lambda inlining |
| Dexterity | 55 | 64% coverage, lambda classes suppressed |

---

## What Works

- Simple getter methods (execSu, execId, getCameraInfo, etc.)
- Basic DexClassLoader calls
- Static field initialization (partially)
- Inner class structure
- Imports
- Method signatures
- Resources (1:1 JADX parity)

## What's Broken

- **P0-UNDEF-VAR:** Variable declarations missing (e.g., `z` in instanceof, `mODEL2` in static field refs)
- **P0-FOREACH-SEM:** For-each loop return not emitted - if-body is empty, always returns initial value
- ~~Boolean chain logic~~ ✅ FIXED - OR patterns now merge correctly
- ~~Complex control flow~~ ✅ FIXED - Spurious returns eliminated

---

## Honest Per-Category Grades

| Category | Grade | Evidence |
|----------|-------|----------|
| **Codegen** | C (65-70%) | ↑ Improved - logic/returns fixed; var decl still broken |
| **Type Inference** | B (80%) | Works for simple cases, fails on ternary var decl |
| **IR/Control Flow** | C+ (75%) | ↑ Improved - spurious returns fixed, loop body issue remains |
| **Variable Naming** | C (70%) | Some undefined variables (`z`, `mODEL2`) |
| **Kotlin Support** | C+ (75%) | Field aliases work, complex patterns fail |
| **Resources** | A+ (100%) | 1:1 JADX parity verified |
| **Overall** | **C/C- (60-70%)** | ↑ Improved from C-/D+ - NOT yet production-ready |

---

## P0 Bugs (Updated Dec 25, 2025)

| ID | Issue | Status | Example |
|----|-------|--------|---------|
| P0-UNDEF-VAR | Undefined variables (`z`, `mODEL2`, `i`) | 🔴 **OPEN** | `z = inputStreamReader instanceof BufferedReader;` - z never declared |
| P0-FOREACH-SEM | Empty for-each loop body | 🔴 **OPEN** | `if (file.exists()) { }` - return not emitted |
| P0-TERNARY-INLINE | Ternary var declaration | 🟡 **PARTIAL** | Literal 8192 inlines ✅; var decl broken |
| ~~P0-LOGIC-INV~~ | ~~Boolean logic inversions~~ | ✅ **FIXED** | OR pattern Type 2 now uses correct FALSE case |
| ~~P0-SPURIOUS-RET~~ | ~~Spurious returns~~ | ✅ **FIXED** | Disabled broken P0-BOOL-CHAIN transformation |

---

## Fixes Needed

1. 🔴 **P0-UNDEF-VAR** - Variable declaration not emitted for:
   - `z` in instanceof expressions (e.g., `z = inputStreamReader instanceof BufferedReader`)
   - `mODEL2`, `hARDWARE2` etc. - static field aliases not resolved
   - `i` in some array index expressions
2. 🔴 **P0-FOREACH-SEM** - For-each loop if-body is empty, return not emitted
3. 🟡 **P0-TERNARY-INLINE** - Partial fix: literals inline, var declarations broken
4. ~~**Boolean chain handling**~~ ✅ FIXED (Dec 25) - OR pattern Type 2 corrected
5. ~~**Control flow cleanup**~~ ✅ FIXED (Dec 25) - Disabled broken P0-BOOL-CHAIN transformation

### P0-FOREACH-SEM Technical Details (Dec 25, 2025)

**Fixes Applied:**
1. **Successor Ordering** (region_builder.rs:1717-1729): Fixed then/else branch mapping based on `negate_condition`
2. **Fall-through Detection** (region_builder.rs:1949-1966): Extended to follow fall-through blocks, not just Goto chains

**Root Cause Identified:**
The return block is **shared** between:
- The if-body inside the for-each loop (early return)
- The method's final return

```
// CFG structure:
Block 4 (if exists): goto Block 5
Block 5: return true
Block 6 (loop exit): return false  // or falls through to return true
```

When exit blocks are included in the if-body region, the return instruction is not emitted because:
- The block may be marked as "already processed"
- Or code gen prevents duplicate emission of shared blocks

**Possible Solutions:**
1. Clone shared blocks when used in multiple regions
2. Use break/continue with labels instead of duplicating returns
3. JADX approach: restructure CFG to avoid shared blocks

---

## Test Coverage Note

The 687+ integration tests pass syntactic checks but NOT semantic correctness. Tests verify:
- Code generates without panics
- Basic structure is correct
- Resources match JADX

Tests do NOT verify:
- Generated code compiles
- Generated code has correct semantics
- Complex control flow is correct

---

## Previous (Overstated) Documentation

The previous documentation claimed A- grade and production-ready status. This was based on:
- Test pass rates (which don't verify semantics)
- Simple method comparisons
- Resource parity (which IS accurate)

The reality is that complex methods have serious issues that make the output non-compilable and semantically incorrect.

---

For detailed issue tracking, see [ROADMAP.md](ROADMAP.md).
