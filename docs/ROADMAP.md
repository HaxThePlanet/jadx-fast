# Roadmap

**Status:** All P0 Fixed, 5 P1 Open (Dec 20, 2025)
**See:** [QUALITY_STATUS.md](QUALITY_STATUS.md) for current grades

## Current Priority: Fix P1 Semantic Issues

### NEW-008: Malformed Synchronized Blocks
**Problem:** Statements outside sync that should be inside
**Scope:** 10+ methods
**Root Cause:** `region_builder.rs` - Synchronized block boundaries wrong
**Files:** `crates/dexterity-passes/src/region_builder.rs`

### NEW-009: Missing Imports
**Problem:** `Function1`, `List` used without import
**Scope:** Many files
**Root Cause:** Import collector misses some type references
**Files:** `crates/dexterity-codegen/src/class_gen.rs`

### NEW-010: Boolean vs Null Comparisons
**Problem:** `isClosed() == null` where boolean method
**Scope:** Multiple
**Root Cause:** Type inference not propagating boolean type
**Files:** `crates/dexterity-passes/src/type_inference.rs`

### NEW-011: Parameter/Field Mismatch
**Problem:** Wrong parameter assigned to field
**Scope:** 30+ methods
**Root Cause:** Parameter/field matching logic
**Files:** `crates/dexterity-codegen/src/body_gen.rs`

### NEW-012: Constructor Result Discarded
**Problem:** `new Foo(...)` result not assigned
**Scope:** 20+ methods
**Root Cause:** Constructor synthesis not tracking result usage
**Files:** `crates/dexterity-codegen/src/body_gen.rs`

---

## Previously Completed (Dec 20, 2025)

All P0 compilation errors fixed:
- NEW-001: Static final = null + reassign
- NEW-002: Undefined/uninitialized variables
- NEW-003: throw non-Throwable validation
- NEW-004: Variable type confusion
- NEW-006: Enum wrong value types
- NEW-007: Unreachable code after return

---

## Future (After P1 Fixed)

### Input Format Support
- APKS (App Bundle split) - Not implemented

### Kotlin Parity (72%)
- Type variance, suspend functions, inline classes

### Performance
- Memory reduction, startup optimization

---

For current status, see [QUALITY_STATUS.md](QUALITY_STATUS.md).
For issue details, see [ISSUE_TRACKER.md](ISSUE_TRACKER.md).
