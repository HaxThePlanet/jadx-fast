# Roadmap

**Status:** All P0 + P1 Fixed, Kotlin 100% (Dec 20, 2025)
**See:** [QUALITY_STATUS.md](QUALITY_STATUS.md) for current grades

## Kotlin Metadata: COMPLETE

### BitEncoding Port (Dec 20, 2025)
- Ported Kotlin BitEncoding decoder from Java to Rust
- UTF-8 mode (marker = '\0') and 8-to-7 bit mode (legacy) supported
- Added StringTableTypes parsing via jvm_metadata.proto
- 68 predefined Kotlin strings lookup implemented

### All Kotlin Features (Complete)
- BitEncoding decoder (UTF-8 + 8-to-7 modes)
- StringTableTypes for proper d2 string resolution
- 68 predefined Kotlin strings (kotlin/Any, kotlin/Function0-22, etc.)
- suspend/inline/infix/operator function modifiers applied to IR
- Extension function receiver_type populated
- Type variance (`<in T>`, `<out T>`) applied to IR
- Data/sealed/value class detection
- Companion object handling
- Method/field name extraction from Kotlin metadata
- toString() bytecode parsing for obfuscated field names

---

## Recently Fixed (Dec 21, 2025)

### Kotlin Function Modifiers
- Added IR fields: is_suspend, is_inline_function, is_infix, is_operator
- Added receiver_type for extension functions
- Modifiers emitted as comments: `/* suspend */ public void foo()`

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

### Performance
- Memory reduction, startup optimization

---

For current status, see [QUALITY_STATUS.md](QUALITY_STATUS.md).
For issue details, see [ISSUE_TRACKER.md](ISSUE_TRACKER.md).
