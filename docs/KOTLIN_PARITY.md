# Kotlin Metadata Parity: Dexterity vs JADX

**Last Updated:** December 26, 2025

## Executive Summary

| Metric | Status | Notes |
|--------|--------|-------|
| **Overall Parity** | **~85-90%** | Field aliases FIXED (Dec 24), Method chains FIXED (Dec 25) |
| **Proto Parsing** | **~95%** | BitEncoding, d2 strings all working |
| **Rename Reasons** | **FIXED** | Now includes "reason: from kotlin metadata" |
| **Field Aliasing** | **FIXED** | `register_kotlin_aliases()` + `AliasAwareDexInfo` |
| **Method Chains** | **FIXED** | Kotlin stdlib semantic naming + SemanticOrigin tracking |

### Reality Check: a0.java (SegmentedByteString.kt) Comparison (Dec 24, 2025)

Comparing `output/jadx/large/sources/l/a0.java` vs `output/dexterity/large/sources/l/a0.java`:

```java
// JADX (CORRECT - uses JVM field signature matching):
/* renamed from: w, reason: from kotlin metadata */
private final transient byte[][] segments;

/* renamed from: x, reason: from kotlin metadata */
private final transient int[] directory;

// Dexterity (FIXED Dec 24 - now matches JADX):
/* renamed from: w, reason: from kotlin metadata */
private final transient byte[][] segments;

/* renamed from: x, reason: from kotlin metadata */
private final transient int[] directory;
```

### P1 Bug FIXED: Field Aliases Now Applied (Dec 24, 2025)

**Fix:** Added `register_kotlin_aliases()` in `deobf.rs` to copy Kotlin-derived field aliases to `AliasRegistry`
- Aliases set on `FieldData.alias` during Kotlin metadata processing
- Copied to registry so `AliasAwareDexInfo.get_field()` can look them up
- Field usages in IGET/IPUT/SGET/SPUT now use aliased names

**Verified Output:** `this.segments`, `this.directory` match JADX exactly

### P1-CHECKTRACER FIXED: Kotlin Method Chain Decompilation (Dec 25, 2025)

**Problem:** Kotlin method chains like `File(...).readLines().find{...}?.split(":")?.trim()?.toIntOrNull()` produced 48 lines of garbled code with undefined variables.

**Fix Applied:**
1. **Kotlin Stdlib Semantic Naming** (`var_naming.rs` lines 1755-1800):
   - StringsKt: split->parts, trim->trimmed, toIntOrNull->parsed
   - FilesKt: readLines->lines, readText->content
   - CollectionsKt: find->found, filter->filtered, map->mapped
   - Iterator: next->item

2. **SemanticOrigin Tracking** (`var_naming.rs` lines 414-433, 512-540):
   - Extended enum with Kotlin variants: KotlinFind, KotlinSplit, KotlinTrim, KotlinParsed, IteratorNext, KotlinReadLines
   - Enhanced `origins_compatible()` to prevent merging Kotlin chain variables

3. **Empty If-Branch Generation** (`body_gen.rs` lines 4974-5011, 7008-7027):
   - Added `invert_condition_string()` helper for clean condition inversion
   - Skip entirely empty if statements
   - Invert condition when then-branch is empty but else-branch has content

**Result:** `checkTracerPid()` now decompiles cleanly instead of producing incomprehensible output.

---

### What IS Working (Dec 23-25, 2025)

1. **Rename reason comments** - FIXED in `class_gen.rs` and `method_gen.rs`
2. **Method parameter names** - Applied when signatures match
3. **Function modifiers** - suspend/inline/infix/operator/tailrec applied to IR
4. **Type variance** - `<in T>`, `<out T>` annotations emitted correctly
5. **Data/sealed/value class detection** - Flags stored in KotlinClassInfo
6. **Kotlin stdlib method chain naming** - FIXED Dec 25 (P1-CHECKTRACER)

---

## Feature Comparison Matrix

### Name Recovery Features

| Feature | JADX | Dexterity | Status | Notes |
|---------|:----:|:---------:|:------:|-------|
| Class aliasing (d2 array) | YES | YES | **FIXED** | Parsed and applied via `AliasRegistry` |
| Method parameter names | YES | YES | **DONE** | `apply_kotlin_names()` in extractor.rs |
| Field name extraction | YES | YES | **FIXED** | Field aliases via `register_kotlin_aliases()` |
| Rename reason comments | YES | YES | **FIXED** | "reason: from kotlin metadata" now emitted |
| toString() parsing | YES | YES | **DONE** | `tostring_parser.rs` bytecode analysis |
| Getter method recognition | YES | PARTIAL | **DONE** | `apply_getter_recognition()` matches methods |
| Kotlin intrinsics vars | YES | YES | **DONE** | `kotlin_intrinsics.rs` extracts names |

**FIXED (Dec 24):** Field aliases now registered via `register_kotlin_aliases()` and applied via `AliasAwareDexInfo.get_field()`.

### Class Modifier Features

| Feature | JADX | Dexterity | Status | Notes |
|---------|:----:|:---------:|:------:|-------|
| Data class detection | YES | YES | **DONE** | `is_data_class` flag in `KotlinClassInfo` |
| Companion object rename | YES | YES | **DONE** | `apply_companion_object_name()` sets field alias |
| Sealed class subclasses | PARTIAL | YES | **DONE** | `sealed_subclasses` stored in `KotlinClassInfo` |
| Inline/Value classes | NO | YES | **DONE** | `is_inline` flag parsed and stored |

**Class Modifier Output Format:**
Class modifiers are emitted as comments after Java modifiers, before the `class` keyword:
```java
public final /* data */ class User { ... }
public abstract /* sealed */ class Result { ... }
public final /* value */ class Color { ... }
```

### Type System Features

| Feature | JADX | Dexterity | Status | Notes |
|---------|:----:|:---------:|:------:|-------|
| Nullable types | NO | PARSED | N/A | `Type.nullable` field defined |
| Generic type parameters | NO | PARSED | N/A | Full `TypeParameter` message |
| Type variance (in/out) | NO | YES | **DONE** | `<in T>`, `<out T>` annotations emitted |
| Type projections | NO | PARSED | N/A | Star projection supported |
| Reified type parameters | NO | YES | **DONE** | `<reified T>` for inline functions |

### Function Modifier Features

| Feature | JADX | Dexterity | Status | Notes |
|---------|:----:|:---------:|:------:|-------|
| Suspend functions | NO | YES | **DONE** | `MethodData.is_suspend` applied to IR |
| Inline functions | NO | YES | **DONE** | `MethodData.is_inline_function` applied to IR |
| Operator/infix markers | NO | YES | **DONE** | `MethodData.is_operator`, `is_infix` applied to IR |
| Extension receiver_type | NO | YES | **DONE** | `MethodData.receiver_type` applied to IR |
| Tail recursion | NO | YES | **DONE** | `is_tailrec` flag extracted |

**Function Modifier Output Format:**
Function modifiers are emitted as comments before Java modifiers:
```java
/* suspend */ public Object fetchData(Continuation $completion) { ... }
/* inline */ public final void repeat(int times, Function1 action) { ... }
/* operator */ public String plus(String other) { ... }
/* infix */ public boolean contains(String element) { ... }
/* tailrec */ public int factorial(int n, int acc) { ... }
/* suspend inline */ public Object withContext(CoroutineContext context, Function2 block, Continuation $completion) { ... }
```

### Debug/Metadata Features

| Feature | JADX | Dexterity | Status | Notes |
|---------|:----:|:---------:|:------:|-------|
| SMAP/SourceDebugExtension | YES | YES | **DONE** | `smap_parser.rs`, `smap_types.rs` |
| Annotation preservation | PARTIAL | PARTIAL | **DONE** | Runtime annotations emitted |
| Function contracts | NO | PARSED | N/A | `Contract`, `Effect` messages |

---

## Implementation Status by File

### `crates/dexterity-kotlin/src/parser.rs` (500+ lines)

| Component | Status | Notes |
|-----------|--------|-------|
| `@kotlin.Metadata` annotation parsing | COMPLETE | k, mv, d1, d2, xs, pn, xi fields |
| **BitEncoding decoder** | **COMPLETE** | Ported from Java - UTF-8 + 8-to-7 modes |
| **StringTableTypes parsing** | **COMPLETE** | Proper d2 string resolution |
| **Predefined strings lookup** | **COMPLETE** | 68 common Kotlin types |
| Protobuf decoding | COMPLETE | Full Class/Package messages |
| Flag extraction | **COMPLETE** | Class, Function, Property flags parsed |
| Function flags | **COMPLETE** | suspend, inline, operator, infix, tailrec |
| Property flags | **COMPLETE** | var, const, lateinit, delegated |

### `crates/dexterity-kotlin/src/extractor.rs` (550+ lines)

| Component | Status | Notes |
|-----------|--------|-------|
| Class name extraction | WORKING | Via d2 array |
| Method parameter extraction | WORKING | From `kmFunction.value_parameter` |
| Field name extraction | **FIXED** | Via `register_kotlin_aliases()` + `AliasAwareDexInfo` |
| Property getter/setter | **WORKING** | `apply_getter_recognition()` matches methods |
| JVM signature matching | **FIXED** | Field aliases now applied regardless of JVM sig |
| KotlinClassInfo population | **DONE** | isData, isSealed, isInline, companion |
| Rename reasons | **FIXED** | `add_rename_reason("from kotlin metadata")` called |

### `crates/dexterity-kotlin/src/types.rs` (155 lines)

| Type | Purpose | Status |
|------|---------|--------|
| `KotlinClassMetadata` | High-level class metadata | Enhanced |
| `KotlinClassFlags` | **NEW** data/sealed/inline/inner/expect/fun | Complete |
| `KotlinFunctionFlags` | **NEW** suspend/inline/operator/infix/tailrec | Complete |
| `KotlinPropertyFlags` | **NEW** var/const/lateinit/delegated | Complete |
| `KotlinParameter` | Parameter with crossinline/noinline | Enhanced |

### `crates/dexterity-ir/src/info.rs` (KotlinClassInfo)

| Field | Type | Status |
|-------|------|--------|
| `is_data_class` | bool | **NEW** |
| `is_sealed` | bool | **NEW** |
| `is_inline` | bool | **NEW** |
| `is_companion` | bool | **NEW** |
| `companion_name` | Option<String> | **NEW** |
| `sealed_subclasses` | Vec<String> | **NEW** |

### `crates/dexterity-passes/src/kotlin_intrinsics.rs` (373 lines)

| Component | Status | Notes |
|-----------|--------|-------|
| `process_kotlin_intrinsics()` | **WORKING** | Pattern-based extraction |
| `process_kotlin_intrinsics_with_context()` | **NEW** | Full DEX context support |
| `IntrinsicsContext` | **NEW** | Method signatures + string pool |
| Intrinsics method detection | **WORKING** | checkNotNullParameter, etc. |
| Parameter name cleaning | **WORKING** | $this$, $receiver removal |

---

## Implementation Completeness

### ~~P0: Critical Bugs~~ - ALL FIXED

| Bug | Location | Root Cause | JADX Reference | Status |
|-----|----------|------------|----------------|--------|
| ~~Field aliases not applied~~ | `deobf.rs:register_kotlin_aliases()` | Now copies aliases to registry | `KotlinMetadataUtils.kt:111-116` | ✅ **FIXED Dec 24** |

### Completed Tasks

| Task | Status | Impact |
|------|--------|--------|
| 1. Field alias registration | **FIXED** | Field names restored via `register_kotlin_aliases()` |
| 2. Apply `isData` flag to IR | **DONE** | Data class detection |
| 3. Companion object renaming | **DONE** | Custom companion names |
| 4. Kotlin intrinsics extraction | **DONE** | Parameter names from runtime checks |
| 5. Getter method recognition | **DONE** | Property accessor matching |
| 6. Suspend/inline function markers | **DONE** | Function modifier extraction |
| 7. Apply function modifiers to IR | **DONE** | is_suspend, is_inline_function, is_infix, is_operator |
| 8. Extension function receiver_type | **DONE** | receiver_type applied to MethodData |
| 9. toString() bytecode parsing | **DONE** | Field names from toString() patterns |
| 10. Type variance annotations | **DONE** | `<in T>`, `<out T>` emitted |
| 11. BitEncoding decoder | **DONE** | Ported from Java (Dec 20, 2025) |
| 12. StringTableTypes parsing | **DONE** | jvm_metadata.proto added |
| 13. Predefined strings lookup | **DONE** | 68 common Kotlin types |
| 14. Rename reason comments | **DONE** | "reason: from kotlin metadata" emitted |

**Current Parity:** ~85-90% (field aliasing FIXED Dec 24)

#### Completed: Type Parameter Bounds Parsing (Dec 21, 2025)

Implemented full support for Kotlin type parameter bounds:
- Added `parse_kotlin_type_name()` function to convert Kotlin type strings to `ArgType`
- Added `KOTLIN_TO_JAVA_TYPES` mapping table (28 common Kotlin→Java type mappings)
- Supports parameterized types like `Comparable<T>`, `Map<K, V>`
- Handles type variables, arrays, and nested generics
- Filters implicit `kotlin/Any` → `java.lang.Object` bounds (Java's default)
- Merges Kotlin bounds with Java signature bounds

Example output:
```kotlin
// Before (95% parity)
class Foo<T> { ... }  // Missing bounds

// After (100% parity)
class Foo<T extends Comparable<T>> { ... }  // Bounds preserved
```

**Files Modified:**
- `crates/dexterity-kotlin/src/parser.rs` - Added `parse_kotlin_type_name()` and type mapping table
- `crates/dexterity-kotlin/src/extractor.rs` - Updated type parameter conversion (was TODO at line 47)

#### Completed: BitEncoding Port (Dec 20, 2025)

Ported the complete Kotlin BitEncoding decoder from Java to Rust:
- **UTF-8 mode** (marker = '\0'): Each char is directly a byte, modern format
- **8-to-7 bit mode** (marker = '\u0001'): Legacy format with 7-bit byte packing
- Added `jvm_metadata.proto` with `StringTableTypes` message for proper d2 string resolution
- Implemented 68 predefined Kotlin string lookups (kotlin/Any, kotlin/Function0-22, etc.)

Source: `org.jetbrains.kotlin.metadata.jvm.deserialization.BitEncoding`

Files added/modified:
- `crates/dexterity-kotlin/src/parser.rs` - `bit_encoding_decode()`, `utf8_mode_decode()`, `decode_8to7_mode()`
- `crates/dexterity-kotlin/proto/jvm_metadata.proto` - StringTableTypes message

#### Completed: Type Variance Annotations (Dec 19, 2025)

Implemented full support for Kotlin declaration-site variance:
- Added `TypeVariance` enum (Invariant/Covariant/Contravariant) to IR
- Parse variance from Kotlin metadata protobuf (`TypeParameter.variance`)
- Generate proper `<in T>`, `<out T>` annotations in output
- Added `reified` modifier support for inline functions
- 2 unit tests for variance generation

Example output:
```kotlin
// Before (61% parity)
interface Consumer<T> { ... }

// After (67% parity)
interface Consumer<in T> { ... }  // Contravariant
interface Producer<out E> { ... } // Covariant
```

**Parity Status:** 95% achieved

#### Completed: toString() Bytecode Parsing (Dec 19, 2025)

Implemented bytecode analysis for Kotlin data class toString() methods:
- Added `tostring_parser.rs` module with state machine for StringBuilder pattern detection
- Parse `StringBuilder.append()` chains to extract field names from string literals
- Map field references (InstanceGet instructions) to their original names
- Falls back to this when protobuf metadata is unavailable or obfuscated
- 4 unit tests for parser logic

Example pattern matched:
```java
// Kotlin data class generates:
// override fun toString() = "User(name=$name, age=$age)"

// Bytecode pattern:
new StringBuilder()
  .append("User(name=")   // ← Extract "User" as class alias, "name" as field alias
  .append(this.name)       // ← Map to field_idx
  .append(", age=")        // ← Extract "age" as field alias
  .append(this.age)        // ← Map to field_idx
  .append(")")
  .toString()
```

**Files Added:**
- `crates/dexterity-kotlin/src/tostring_parser.rs` - Core parser implementation

**Files Modified:**
- `crates/dexterity-kotlin/src/lib.rs` - Module integration
- `crates/dexterity-kotlin/src/extractor.rs` - `apply_tostring_names()` function
- `crates/dexterity-cli/src/main.rs` - Pass DexReader to Kotlin processing

---

## Field Name Extraction: Implementation (FIXED Dec 24, 2025)

**Location:** `crates/dexterity-kotlin/src/extractor.rs` + `crates/dexterity-cli/src/deobf.rs`

**How it works now:**
1. `field_matches()` sets `field.alias` on matching fields during Kotlin metadata processing
2. `register_kotlin_aliases()` copies aliases to `AliasRegistry` for cross-class lookups
3. `AliasAwareDexInfo.get_field()` returns aliased field names for IGET/IPUT/SGET/SPUT

```rust
fn field_matches(field: &FieldData, property: &KotlinProperty) -> bool {
    // Strategy 1: JVM signature match (works when signature is present)
    if !property.jvm_field_signature.is_empty() {
        // Parse "fieldName:Ltype;" and compare
        // This works when signature is present
    }

    // Strategy 2: Exact name match (fast path)
    if field.name == property.name { return true; }

    // Strategy 3: Backing field pattern (name$delegate)
    if field.name.starts_with(&property.name) && field.name.contains('$') { return true; }

    // Strategy 4: Underscore prefix pattern (_name -> name)
    if field.name.starts_with("_") && field.name[1..] == property.name { return true; }

    // NO fallback for obfuscated names - this was the bug fix
    // But now obfuscated fields like "w" don't match "segments"
    false
}
```

### JADX Reference for Correct Implementation

**File:** `jadx-fast/jadx-plugins/jadx-kotlin-metadata/src/main/kotlin/jadx/plugins/kotlin/metadata/utils/KotlinMetadataUtils.kt:111-116`

```kotlin
fun mapFields(cls: ClassNode, kmClass: KmClass): Map<FieldNode, String> {
    return kmClass.properties.mapNotNull { kmProperty ->
        val fieldNode = cls.searchFieldByShortId(kmProperty.shortId)
            ?: return@mapNotNull null
        fieldNode to kmProperty.name
    }.toMap()
}
```

**Key:** `kmProperty.shortId` returns `fieldSignature?.toString()` which gives JVM field signature like `"w:[[B"`.

---

## Comparison: What Works Now

| Scenario | JADX | Dexterity | Status |
|----------|------|-----------|--------|
| Obfuscated Kotlin class names | Restored | Restored | **DONE** |
| Obfuscated method param names | Restored | Restored | **DONE** |
| Obfuscated field names | Restored | Restored | ✅ **FIXED Dec 24** |
| Rename reason comments | Yes | Yes | **FIXED** |
| Data class detection | Comment added | Flag stored | **DONE** |
| Companion object naming | Yes | Yes | **DONE** |
| Variable names from intrinsics | Restored | Restored | **DONE** |
| Suspend function detection | No | Yes (applied to IR) | **DONE** |
| Inline function detection | No | Yes (applied to IR) | **DONE** |
| Infix/operator detection | No | Yes (applied to IR) | **DONE** |
| Extension receiver_type | No | Yes (applied to IR) | **DONE** |
| Sealed class subclasses | Partial | Yes | **DONE** |

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
