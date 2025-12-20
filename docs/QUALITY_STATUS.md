# Quality Status

**Status:** Critical Issues Found (Dec 20, 2025)
**Goal:** 1:1 identical decompilation output with JADX

## Current Grades (Post Deep Analysis)

| Category | Grade | Notes |
|----------|-------|-------|
| **Codegen** | **D** | 70+ P0 compilation errors found |
| **IR/Control Flow** | **D** | Synchronized blocks, loops broken |
| **Variable Naming** | **B-** | JADX parity improved (long=j, OBJ_ALIAS) |
| **JADX 1:1 Match** | **F** | Major structural differences |
| **Overall** | **D** | Not production ready |

## Critical Issues Found (Dec 20 Deep Analysis)

Deep comparison of JADX vs Dexterity output on Medium, Large, and Badboy APKs.

### P0 Critical - WON'T COMPILE (3 Open, 3 Fixed, 1 Not A Bug)

| ID | Issue | Scope | Example |
|----|-------|-------|---------|
| **NEW-001** | Static final = null + reassign | 30+ files | `final byte[] X = null; static { X = {...}; }` |
| **NEW-002** | Undefined/uninitialized variables | 40+ methods | `int i; while(i < 16)` - i never set |
| **NEW-003** | throw non-Throwable | 5+ methods | ~~`throw i;` where i is int~~ **FIXED** |
| **NEW-004** | Variable type confusion | 20+ methods | String reused for AccessibilityNodeInfo |
| **NEW-005** | Kotlin INSTANCE uninitialized | All Kotlin objects | ~~`static final INSTANCE;`~~ **NOT A BUG** - initialized in static block |
| **NEW-006** | Enum wrong value types | Multiple enums | ~~`OK(false)` instead of `OK(0)`~~ **FIXED** |
| **NEW-007** | Unreachable code after return | 15+ methods | ~~`return x; synchronized {...}`~~ **FIXED** |

### P1 High - WRONG SEMANTICS (5 Categories, 55+ instances)

| ID | Issue | Scope |
|----|-------|-------|
| **NEW-008** | Malformed synchronized blocks | 10+ methods |
| **NEW-009** | Missing imports | Many files |
| **NEW-010** | Boolean vs null comparisons | Multiple |
| **NEW-011** | Parameter/field mismatch | 30+ methods |
| **NEW-012** | Constructor result discarded | 20+ methods |

### Previously Fixed (Dec 20, 2025)

| ID | Bug | Status |
|----|-----|--------|
| BUG-001 | Switch map synthetic classes | FIXED |
| BUG-002 | Undefined division variables | FIXED |
| BUG-003 | Missing type cast in equals() | FIXED |
| BUG-004 | Boolean returns integer | FIXED |
| BUG-005 | Infinite recursion in clone() | FIXED |
| BUG-006 | Boolean compared to null | FIXED |
| BUG-007 | Undefined variable in hashCode() | FIXED |
| P1-001 to P1-004 | Various | FIXED |
| NEW-003 | throw non-Throwable | FIXED |
| NEW-006 | Enum wrong value types | FIXED |
| Variable Naming | Long prefix l->j, OBJ_ALIAS mappings | FIXED |

## Quality Metrics

| Metric | Value |
|--------|-------|
| Integration Tests | 687/687 passing |
| Unit Tests | 490/490 passing |
| **Real-world APK compilation** | **FAILING** |

## Output Quality by APK Size

| APK Size | Quality | Notes |
|----------|---------|-------|
| Small (9.8KB) | **A** | Simple code works |
| Medium (10.3MB) | **D** | 30+ P0 errors |
| Large (51.5MB) | **F** | 70+ P0 errors |
| Badboy | **D** | Critical Kotlin issues |

## Root Causes

| Issue | Source File | Component |
|-------|-------------|-----------|
| Static final init | `class_gen.rs` | Field extraction |
| Undefined vars | `var_naming.rs`, `loops.rs` | Variable tracking |
| throw non-Throwable | `body_gen.rs` | Exception handling |
| Type confusion | `type_inference.rs` | Type system |
| Kotlin INSTANCE | `dexterity-kotlin/` | Singleton detection |
| Synchronized blocks | `region_builder.rs` | Control flow |

---

For fix plan, see [ROADMAP.md](ROADMAP.md).
For issue details, see [ISSUE_TRACKER.md](ISSUE_TRACKER.md).
