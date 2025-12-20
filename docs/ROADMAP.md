# Roadmap

**Status:** Critical Issues Found - NOT Production Ready (Dec 20, 2025)
**See:** [QUALITY_STATUS.md](QUALITY_STATUS.md) for current grades

## Immediate Priority: Fix P0 Compilation Errors

### Phase 1: Static Field Initialization (NEW-001)

**Problem:** `final byte[] X = null; static { X = {...}; }` - illegal Java
**Scope:** 30+ files
**Fix:** Inline array/object initializers into field declarations
**Files:** `crates/dexterity-codegen/src/class_gen.rs`

### Phase 2: Undefined Variables (NEW-002)

**Problem:** `int i; while(i < 16)` - i never initialized
**Scope:** 40+ methods
**Fix:** Properly track loop variable initialization in SSA
**Files:** `crates/dexterity-passes/src/loops.rs`, `var_naming.rs`

### Phase 3: throw non-Throwable (NEW-003) - FIXED

**Problem:** `throw i;` where i is int
**Scope:** 5+ methods
**Fix:** Validate exception type, emit `throw null;` for non-Throwable types
**Files:** `crates/dexterity-codegen/src/body_gen.rs`
**Status:** FIXED by bigballs (Dec 20, 2025)

### Phase 4: Variable Type Confusion (NEW-004)

**Problem:** Same variable name reused for incompatible types
**Scope:** 20+ methods
**Fix:** Don't reuse variable names across type changes
**Files:** `crates/dexterity-passes/src/type_inference.rs`, `var_naming.rs`

### Phase 5: Kotlin INSTANCE (NEW-005)

**Problem:** `static final INSTANCE;` - uninitialized
**Scope:** All Kotlin objects
**Fix:** Detect and emit singleton initialization
**Files:** `crates/dexterity-kotlin/src/`

### Phase 6: Enum Values (NEW-006) - FIXED

**Problem:** `OK(false)` instead of `OK(0)`
**Scope:** Multiple enums
**Fix:** Search backwards for register values, don't convert 0/1 to boolean
**Files:** `crates/dexterity-passes/src/enum_visitor.rs`
**Status:** FIXED by bigballs (Dec 20, 2025)

### Phase 7: Synchronized Blocks (NEW-007)

**Problem:** Return before synchronized block (unreachable code)
**Scope:** 15+ methods
**Fix:** Correct synchronized region boundary detection
**Files:** `crates/dexterity-passes/src/region_builder.rs`

---

## Secondary Priority: P1 Semantic Issues

| Issue | Description |
|-------|-------------|
| NEW-008 | Malformed synchronized blocks |
| NEW-009 | Missing imports |
| NEW-010 | Boolean vs null comparisons |
| NEW-011 | Parameter/field mismatch |
| NEW-012 | Constructor result discarded |

---

## Previously Completed

| Issue | Status |
|-------|--------|
| NEW-003 throw non-Throwable | FIXED Dec 20 |
| NEW-006 Enum wrong values | FIXED Dec 20 |
| Self-reference simplification | FIXED Dec 20 |
| Empty else blocks | FIXED Dec 20 |
| BUG-001 to BUG-012 | FIXED Dec 20 |
| P1-001 to P1-004 | FIXED Dec 20 |
| Variable Naming: long prefix l->j | FIXED Dec 20 |
| Variable Naming: OBJ_ALIAS mappings | FIXED Dec 20 |

---

## Future (After P0/P1 Fixed)

### Input Format Support
- APKS (App Bundle split) - Not implemented

### Kotlin Parity (72%)
- Type variance, suspend functions, inline classes

### Performance
- Memory reduction, startup optimization

---

For current status, see [QUALITY_STATUS.md](QUALITY_STATUS.md).
For issue details, see [ISSUE_TRACKER.md](ISSUE_TRACKER.md).
