# Roadmap

**Status:** All P0 + P1 Fixed (Dec 21, 2025)
**See:** [QUALITY_STATUS.md](QUALITY_STATUS.md) for current grades

## Current Priority: Kotlin Parity (72% → 100%)

### Quick Wins (LOW effort)
1. Apply suspend modifier to IR method signatures
2. Apply inline modifier to IR method signatures
3. Populate extension function receiver_type
4. Extract inline_class_underlying_property_name

### Harder (HIGH effort)
5. SMAP/SourceDebugExtension parsing for Kotlin source mapping

---

## Recently Fixed (Dec 21, 2025)

All P0 compilation errors + P1 semantic issues fixed:

### P1 Semantic Issues (Fixed)
- NEW-008: Malformed synchronized blocks - ACC_DECLARED_SYNCHRONIZED flag
- NEW-009: Missing imports - ConstClass, InstanceGet/Put, InvokeCustom collection
- NEW-010: Boolean vs null comparisons - Method name heuristics
- NEW-011: Parameter/field mismatch - SSA version 0 fallback
- NEW-012: Constructor result discarded - Assign on tracking failure

### P0 Compilation Errors (Fixed)
- NEW-001: Static final = null + reassign
- NEW-002: Undefined/uninitialized variables
- NEW-003: throw non-Throwable validation
- NEW-004: Variable type confusion
- NEW-006: Enum wrong value types
- NEW-007: Unreachable code after return

---

## Future Work

### Input Format Support
- APKS (App Bundle split) - Not implemented

### Kotlin Parity (72%)
- Type variance, suspend functions, inline classes

### Performance
- Memory reduction, startup optimization

---

For current status, see [QUALITY_STATUS.md](QUALITY_STATUS.md).
For issue details, see [ISSUE_TRACKER.md](ISSUE_TRACKER.md).
