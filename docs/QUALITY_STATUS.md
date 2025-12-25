# Quality Status

**Status:** NOT PRODUCTION-READY | Multiple P0 Bugs | C-/D+ Grade (55-65%) | 64% File Coverage | Dec 25, 2025
**Reality Check:** Dec 25, 2025 02:26 - Re-graded after P0-TERNARY-INLINE fix
**Goal:** Correct decompilation close to JADX (not byte-for-byte identical)
**Resources:** 1:1 JADX parity achieved (103 directories, 152 files, zero differences)
**Codegen:** ~55-65% semantic correctness; outputs 64% of JADX files
**Open Work:** Critical bugs in control flow, ternary inlining, boolean chains

---

## HONEST ASSESSMENT (Dec 25, 2025)

### Reality vs Previous Claims

| Metric | Previously Claimed | Reality |
|--------|-------------------|---------|
| Overall Grade | A- (95-96%) | **C-/D+ (55-65%)** |
| P0 Bugs | 0 | **5-10 critical issues** per complex file |
| Compilable | Yes | **No** - undefined variables |
| Semantically Correct | Yes | **No** - inverted logic, broken loops |
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

#### 2. Logic Inversions (Wrong Behavior)
```java
// Dexterity - isBeingDebugged() - WRONG LOGIC
if (!Debug.isDebuggerConnected()) {
    if (Debug.waitingForDebugger()) {
        return false;  // INVERTED!
    } else {
        return true;   // INVERTED!
    }
}
return z;  // Always false

// JADX - CORRECT
return Debug.isDebuggerConnected() || Debug.waitingForDebugger();
```

#### 3. Spurious Return Statements (Broken Control Flow)
```java
// Dexterity - loadMultipleDex() Lines 293-295
while (it.hasNext()) {
    return true;   // Unreachable code after this
    return true;   // Unreachable
    arrayList.add(...);  // Never executes
}

// Dexterity - checkTracerPid() Lines 487-506
it = ...iterator();
return true;  // Random return in middle of method
while (it.hasNext()) {
    return true;  // More garbage
    ...
}
```

#### 4. Missing Expression Inlining
```java
// Dexterity - execCommand1
z = inputStreamReader instanceof BufferedReader;
BufferedReader r3 = z ? (BufferedReader)inputStreamReader : new BufferedReader(inputStreamReader, i);
return TextStreamsKt.readText(obj);  // Uses wrong variable!

// JADX - Correct inline
return TextStreamsKt.readText(inputStreamReader instanceof BufferedReader
    ? (BufferedReader) inputStreamReader
    : new BufferedReader(inputStreamReader, 8192));
```

#### 5. Broken For-Each Loops
```java
// Dexterity - isRooted() Lines 657-663
for (String str : strArr) {
    if (new File(str).exists()) {
        break;  // Just breaks, doesn't return
    }
}
return true;  // Always returns true!

// JADX - Correct
for (String str : strArr) {
    if (new File(str).exists()) {
        return true;  // Returns on match
    }
}
return false;  // Returns false if no match
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

- Ternary expression inlining -> undefined `obj` variables
- For-each loop return semantics -> always returns true/false incorrectly
- Boolean chain logic -> inverted conditions
- Complex control flow -> spurious `return true;` scattered throughout
- Variable declarations in complex expressions

---

## Honest Per-Category Grades

| Category | Grade | Evidence |
|----------|-------|----------|
| **Codegen** | D+ (55-65%) | Undefined variables, broken control flow |
| **Type Inference** | B (80%) | Works for simple cases, fails on ternaries |
| **IR/Control Flow** | D (50%) | Spurious returns, inverted logic |
| **Variable Naming** | C (70%) | Many undefined or wrong variables |
| **Kotlin Support** | C+ (75%) | Field aliases work, complex patterns fail |
| **Resources** | A+ (100%) | 1:1 JADX parity verified |
| **Overall** | **C-/D+ (55-65%)** | NOT production-ready |

---

## P0 Bugs (OPEN - Dec 25, 2025)

| ID | Issue | Severity | Example |
|----|-------|----------|---------|
| P0-UNDEF-VAR | Undefined variables in ternary expressions | **PARTIAL** | `i` fixed (8192 inlines); `obj`, `mODEL2` still open |
| P0-LOGIC-INV | Logic inversions in boolean methods | **CRITICAL** | `isBeingDebugged()` returns opposite |
| P0-SPURIOUS-RET | Spurious `return true;` in control flow | **CRITICAL** | `loadMultipleDex()`, `checkTracerPid()` |
| P0-FOREACH-SEM | For-each loop semantics wrong | **IN PROGRESS** | Shared block problem - return block serves if-body AND final return |
| P0-TERNARY-INLINE | Ternary expression inlining fails | **PARTIAL** | Literal inlining works (8192), result variable (`obj`) still undefined |

---

## Fixes Needed

1. **Ternary inlining** - PARTIAL (Dec 25) - literal 8192 inlines, but result variable (`obj`) still undefined
2. **For-each return semantics** - Shared block problem (see below)
3. **Boolean chain handling** - OR/AND condition merging
4. **Control flow cleanup** - Remove spurious return statements
5. **Variable declaration** - ~~`i`~~ FIXED; `obj`, `mODEL2` still undefined

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
