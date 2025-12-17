# Kotlin Metadata Parity: Dexterity vs JADX

**Last Updated:** December 17, 2025

## Executive Summary

| Metric | Value |
|--------|-------|
| **Overall Parity** | **28%** (5/18 JADX features implemented) |
| **Proto Parsing** | 95% (comprehensive metadata schema) |
| **IR Extraction** | 28% (limited feature usage) |
| **Production Impact** | Low - class/method names work, field names broken |

Dexterity has **comprehensive Kotlin metadata parsing** via protobuf (663 lines) but **minimal feature extraction** to IR. JADX implements 9 practical features; Dexterity implements 2.5 of them.

---

## Feature Comparison Matrix

### Name Recovery Features

| Feature | JADX | Dexterity | Status | Gap Description |
|---------|:----:|:---------:|:------:|-----------------|
| Class aliasing (d2 array) | YES | YES | **DONE** | `precompute_kotlin_aliases()` in deobf.rs |
| Method parameter names | YES | YES | **DONE** | `extract_names_to_ir()` in extractor.rs |
| Field name extraction | YES | NO | **GAP** | `field_name_matches()` always returns false |
| toString() parsing | YES | NO | **GAP** | No bytecode analysis (JADX: ToStringParser.kt) |
| Getter method recognition | YES | NO | **GAP** | No pattern matching (JADX: KotlinUtils.kt) |
| Kotlin intrinsics vars | YES | NO | **GAP** | No ProcessKotlinInternals equivalent |

### Class Modifier Features

| Feature | JADX | Dexterity | Status | Gap Description |
|---------|:----:|:---------:|:------:|-----------------|
| Data class detection | YES | PARTIAL | **GAP** | `isData` parsed but not applied to IR |
| Companion object rename | YES | NO | **GAP** | `companion_object_name` field unused |
| Sealed class subclasses | PARTIAL | NO | **GAP** | `sealed_subclass_fq_name` unused |
| Inline/Value classes | NO | PARSED | N/A | Proto supports, neither uses |

### Type System Features

| Feature | JADX | Dexterity | Status | Gap Description |
|---------|:----:|:---------:|:------:|-----------------|
| Nullable types | NO | PARSED | N/A | `Type.nullable` field defined |
| Generic type parameters | NO | PARSED | N/A | Full `TypeParameter` message |
| Type variance (in/out) | NO | PARSED | N/A | `variance` enum defined |
| Type projections | NO | PARSED | N/A | Star projection supported |

### Function Modifier Features

| Feature | JADX | Dexterity | Status | Gap Description |
|---------|:----:|:---------:|:------:|-----------------|
| Suspend functions | NO | PARSED | N/A | `isSuspend` flag defined |
| Inline functions | NO | PARSED | N/A | `isInline` flag defined |
| Operator/infix markers | NO | PARSED | N/A | `isOperator`, `isInfix` flags |
| Tail recursion | NO | PARSED | N/A | `isTailrec` flag defined |

### Debug/Metadata Features

| Feature | JADX | Dexterity | Status | Gap Description |
|---------|:----:|:---------:|:------:|-----------------|
| SMAP/SourceDebugExtension | YES | NO | **GAP** | Separate JADX plugin |
| Annotation preservation | PARTIAL | NO | **GAP** | Full `Annotation` message unused |
| Function contracts | NO | PARSED | N/A | `Contract`, `Effect` messages |

---

## Implementation Status by File

### `crates/dexterity-kotlin/src/parser.rs` (280 lines)

| Component | Status | Notes |
|-----------|--------|-------|
| `@kotlin.Metadata` annotation parsing | COMPLETE | k, mv, d1, d2, xs, pn, xi fields |
| Base64 d1 decoding | COMPLETE | Primary protobuf source |
| d2 fallback parsing | MINIMAL | Just validates presence |
| Protobuf decoding | COMPLETE | Full Class/Package messages |
| Flag extraction | **1/20+** | Only `isData` checked (line 154) |

### `crates/dexterity-kotlin/src/extractor.rs` (95 lines)

| Component | Status | Notes |
|-----------|--------|-------|
| Class name extraction | WORKING | Via d2 array |
| Method parameter extraction | WORKING | From `kmFunction.value_parameter` |
| Field name extraction | **BROKEN** | Lines 91-94: always returns `false` |
| Property getter/setter | NOT IMPLEMENTED | Signatures defined but unused |
| JVM signature matching | BASIC | Just `name + "()"`, no param types |

### `crates/dexterity-kotlin/proto/metadata.proto` (663 lines)

| Message Type | Defined | Used |
|--------------|:-------:|:----:|
| Class | YES | YES (partial) |
| Function | YES | YES (names only) |
| Property | YES | NO (extraction broken) |
| Constructor | YES | YES (params only) |
| ValueParameter | YES | YES (names only) |
| Type | YES | NO |
| TypeParameter | YES | NO |
| TypeAlias | YES | NO |
| Annotation | YES | NO |
| Contract | YES | NO |
| EnumEntry | YES | NO |

### `crates/dexterity-kotlin/src/visitor.rs` (103 lines)

| Component | Status | Notes |
|-----------|--------|-------|
| KotlinMetadataVisitor | WORKING | Processes all classes |
| Recursive nested class handling | WORKING | Processes inner classes |
| KotlinAwareCondition wrapper | WORKING | Prevents over-deobfuscation |

---

## JADX Implementation Reference

JADX Kotlin support is implemented across two plugins:

### jadx-kotlin-metadata Plugin

**Location:** `jadx-fast/jadx-plugins/jadx-kotlin-metadata/`

| File | Purpose | Dexterity Equivalent |
|------|---------|---------------------|
| `KotlinMetadataPlugin.kt` | Plugin entry point | `lib.rs` |
| `KotlinMetadataOptions.kt` | 7 configurable options | None (hardcoded) |
| `KotlinMetadataPreparePass.kt` | Class alias extraction | `precompute_kotlin_aliases()` |
| `KotlinMetadataDecompilePass.kt` | Main processing | `extractor.rs` (partial) |
| `KotlinMetadataUtils.kt` | Metadata utilities | `parser.rs` |
| `ToStringParser.kt` | toString() bytecode analysis | **MISSING** |
| `KotlinUtils.kt` | Getter/default method detection | **MISSING** |
| `KmClassWrapper.kt` | Metadata wrapper | N/A (inline in Rust) |

**Library:** `org.jetbrains.kotlin:kotlin-metadata-jvm:2.2.21`
**Dexterity:** Custom protobuf via `prost`

### ProcessKotlinInternals (Core)

**Location:** `jadx-fast/jadx-core/src/main/java/jadx/core/dex/visitors/kotlin/ProcessKotlinInternals.java`

Extracts variable names from `kotlin.jvm.internal.Intrinsics` calls:
- `checkNotNullParameter(Object, String)`
- `checkNotNullExpressionValue(Object, String)`
- Handles `$this$` and `$` prefixes

**Dexterity Status:** NOT IMPLEMENTED

---

## Roadmap to 100% Parity

### P1: High Impact, Quick Wins (3 tasks)

| Task | Impact | Effort | File |
|------|--------|--------|------|
| 1. Fix `field_name_matches()` | HIGH | LOW | `extractor.rs:91-94` |
| 2. Apply `isData` flag to IR | MEDIUM | LOW | `extractor.rs` + IR |
| 3. Companion object renaming | MEDIUM | LOW | `extractor.rs` |

**Expected Parity After P1:** 45%

### P2: Medium Impact (3 tasks)

| Task | Impact | Effort | File |
|------|--------|--------|------|
| 4. Kotlin intrinsics extraction | HIGH | MEDIUM | New pass in passes crate |
| 5. Getter method recognition | MEDIUM | MEDIUM | Pattern matching in codegen |
| 6. toString() bytecode parsing | MEDIUM | HIGH | New parser module |

**Expected Parity After P2:** 72%

### P3: Full Feature Parity (3 tasks)

| Task | Impact | Effort | File |
|------|--------|--------|------|
| 7. Suspend/inline function markers | LOW | LOW | Flag extraction |
| 8. Type variance annotations | LOW | MEDIUM | Type system integration |
| 9. SMAP debug extension support | LOW | HIGH | New attribute parser |

**Expected Parity After P3:** 100%

---

## Critical Bug: Field Name Extraction

**Location:** `crates/dexterity-kotlin/src/extractor.rs:91-94`

```rust
fn field_name_matches(_field: &FieldData, _property: &proto::Property) -> bool {
    // TODO: Implement proper field matching
    false
}
```

This function **always returns false**, meaning Kotlin field names are NEVER extracted despite:
1. Proto schema fully supporting `Property` messages
2. Parser correctly decoding property metadata
3. JADX successfully extracting field names

**Fix:** Implement JVM field signature matching:
```rust
fn field_name_matches(field: &FieldData, property: &proto::Property) -> bool {
    // Match by field signature from property.fieldSignature
    // or fall back to name-based matching
}
```

---

## Comparison: What Works

| Scenario | JADX | Dexterity |
|----------|------|-----------|
| Obfuscated Kotlin class names | Restored | Restored |
| Obfuscated method param names | Restored | Restored |
| Obfuscated field names | Restored | **NOT restored** |
| Data class comment | Added | Not added |
| Companion object named | Yes | No |
| Variable names from intrinsics | Restored | Not restored |

---

## Proto Schema Capabilities (Unused)

Dexterity's proto schema supports features neither JADX nor Dexterity currently uses:

- **Function contracts** (`Contract`, `Effect`, `Expression` messages)
- **Context receivers** (`context_receiver_type` on Class/Function/Property)
- **Type alias metadata** (`TypeAlias` message)
- **Annotation arguments** (nested annotations, arrays, class literals)
- **Version requirements** (`VersionRequirement` message)
- **Compiler plugin data** passthrough

These represent future enhancement opportunities beyond JADX parity.
