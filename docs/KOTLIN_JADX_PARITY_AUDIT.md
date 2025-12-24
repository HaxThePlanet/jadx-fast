# Kotlin JADX Parity Audit

## Executive Summary

**Parity Level: ~70-75%** (Field aliasing P0 bug, rename reasons FIXED)

**Last Updated:** December 23, 2025 - VERIFIED STATUS

Dexterity's `dexterity-kotlin` crate has substantial parity with JADX's Kotlin metadata handling, but a **critical P0 bug prevents field aliases from being applied**. The implementation includes proper JADX reference comments throughout the codebase.

### Key Findings (Dec 23, 2025)

| Feature | Status | Notes |
|---------|--------|-------|
| **Field Aliasing** | **P0 BUG** | `jvm_field_signature` often None, `field_matches()` fails |
| **Rename Reasons** | **FIXED** | "reason: from kotlin metadata" now emitted |
| **Proto Parsing** | **DONE** | BitEncoding, d2, all working |
| **Function Modifiers** | **DONE** | suspend/inline/infix/operator/tailrec |

## JADX Source Locations (jadx-fast)

### Core Kotlin Plugins
1. `jadx-plugins/jadx-kotlin-metadata/` - Metadata annotation processing
2. `jadx-plugins/jadx-kotlin-source-debug-extension/` - SMAP processing
3. `jadx-core/src/main/java/jadx/core/dex/visitors/kotlin/ProcessKotlinInternals.java` - Intrinsics handling

## Feature-by-Feature Comparison

### ✅ FULLY CLONED

#### 1. Kotlin Metadata Parsing (`parser.rs`)
| JADX File | Dexterity File | Status |
|-----------|----------------|--------|
| `KotlinMetadataDecompilePass.kt` | `parser.rs`, `lib.rs` | ✅ Complete |
| `KmClassWrapper.kt` | `types.rs` | ✅ Complete |
| `KotlinMetadataConsts.kt` | `parser.rs:14-55` | ✅ Complete |

**Features:**
- BitEncoding decode (UTF-8 and 8-to-7 modes)
- Protobuf message parsing (StringTableTypes, Class, Package)
- All 5 metadata kinds (Class=1, FileFacade=2, SyntheticClass=3, MultiFileClassFacade=4, MultiFileClassPart=5)
- Full flag parsing (class, function, property, parameter)
- Type parameter variance (IN/OUT/INV) and bounds

#### 2. SMAP Parsing (`smap_types.rs`, `smap_parser.rs`)
| JADX File | Dexterity File | Status |
|-----------|----------------|--------|
| `SMAP.kt` | `smap_types.rs` | ✅ Complete |
| `SMAPParser.kt` | `smap_parser.rs` | ✅ Complete |
| `SourceInfo.kt` | `smap_types.rs:217-223` | ✅ Complete |
| `KotlinSmapUtils.kt` | `lib.rs:343+` | ✅ Complete |

**Features:**
- Complete JSR-045 format parsing
- Kotlin and KotlinDebug strata support
- Line mapping and file mapping
- Binary search for line lookup
- Class alias extraction from SMAP

#### 3. toString() Parser (`tostring_parser.rs`)
| JADX File | Dexterity File | Status |
|-----------|----------------|--------|
| `ToStringParser.kt` | `tostring_parser.rs` | ✅ Complete |

**Features:**
- StringBuilder pattern recognition
- Field name extraction from toString() format
- Arrays.toString() handling (P1.2 FIX - JADX Reference: ToStringParser.kt:66-74)
- Class alias extraction from first string

#### 4. Kotlin Intrinsics (`kotlin_intrinsics.rs`)
| JADX File | Dexterity File | Status |
|-----------|----------------|--------|
| `ProcessKotlinInternals.java` | `kotlin_intrinsics.rs` | ✅ Complete |

**Features:**
- `checkNotNullParameter` name extraction
- `checkNotNullExpressionValue` name extraction
- `checkParameterIsNotNull` handling
- SGET constant field revert (P1.3 FIX - JADX Reference: ProcessKotlinInternals.java:164-172)
- Hide intrinsics option (JADX Reference: ProcessKotlinInternals.java:134-136)

#### 5. Name Extraction (`extractor.rs`)
| JADX File | Dexterity File | Status |
|-----------|----------------|--------|
| `KotlinMetadataUtils.kt` | `extractor.rs` | **P0 BUG** |
| `KotlinUtils.kt` | `extractor.rs` | Partial |

**Working Features:**
- Class alias from d2 array with package validation
- Class alias from SMAP
- Method argument renaming with JVM signature matching
- Companion object detection and hiding analysis (JADX Reference: KotlinMetadataUtils.kt:118-141)
- Getter recognition (JADX Reference: KotlinUtils.kt:25-52)
- Default method recognition with $default suffix (JADX Reference: KotlinUtils.kt:53-89)
- **Rename reason comments** - FIXED: "reason: from kotlin metadata" now emitted

**P0 BUG: Field/property renaming NOT working:**
- `field_matches()` fails because `property.jvm_field_signature` is often None
- Obfuscated fields like `w` don't match property names like `segments`
- JADX uses `KmProperty.fieldSignature` for exact JVM name matching

#### 6. Options System (`lib.rs`)
| JADX File | Dexterity File | Status |
|-----------|----------------|--------|
| `KotlinMetadataOptions.kt` | `lib.rs:83-178` | ✅ Complete |

**Options:**
- `class_alias` - Rename class alias
- `method_args` - Rename function arguments
- `fields` - Rename fields
- `companion` - Rename companion object
- `data_class` - Add data class modifier
- `to_string` - Rename fields using toString
- `getters` - Rename simple getters to field names
- `smap_class_alias` - Use SMAP for class alias

### P0: CRITICAL GAPS

#### 1. Field Alias Application (P0 BUG)
**JADX:** `KotlinMetadataUtils.kt:111-116` - `mapFields()` uses `searchFieldByShortId(kmProperty.shortId)`
**Dexterity:** `extractor.rs:field_matches()` fails because `jvm_field_signature` is often None

**Evidence (a0.java / SegmentedByteString.kt):**
```java
// JADX: /* renamed from: w, reason: from kotlin metadata */
//       private final transient byte[][] segments;
// Dexterity: private final transient byte[][] w;  // NO ALIAS!
```

**Root Cause:** Parser extracts JVM field signature but it's not being populated for all properties.

### ⚠️ MINOR GAPS

#### 1. Package Part Counting Validation
**JADX:** `KotlinMetadataUtils.kt:77-90` - `countPkgParts()`
**Dexterity:** Has similar logic but worth auditing for edge cases

#### 2. Companion Class Rename
**JADX:** `KotlinMetadataDecompilePass.kt:78-80` - Renames companion inner class to "Companion"
**Dexterity:** Comment at `extractor.rs:943-947` notes this requires inner class access

#### 3. Default Method Dominator Analysis
**JADX:** `KotlinUtils.kt:64-75` - Uses dominator analysis to find original method
**Dexterity:** `extractor.rs:997` - Uses name matching heuristic instead

### ✅ BONUS FEATURES (Beyond JADX)

1. **Multi-core parallel processing** - Dexterity processes classes in parallel
2. **Options builder pattern** - Fluent API for configuration
3. **Comprehensive tracing** - Debug logging throughout

## JADX Reference Comments in Dexterity

The codebase maintains extensive JADX reference comments:

```rust
// JADX Reference: ProcessKotlinInternals.java:164-172
// JADX Reference: KotlinMetadataUtils.kt:118-141
// JADX Reference: ToStringParser.kt:66-74
// JADX Reference: KotlinUtils.kt:46-51
// etc.
```

## Files Structure Mapping

| JADX Plugin | Dexterity Crate |
|-------------|-----------------|
| `jadx-kotlin-metadata/` | `crates/dexterity-kotlin/src/` |
| `jadx-kotlin-source-debug-extension/` | `crates/dexterity-kotlin/src/smap_*.rs` |
| `ProcessKotlinInternals.java` | `crates/dexterity-passes/src/kotlin_intrinsics.rs` |

## Recommended Clone Tasks

### P0 - CRITICAL (Blocking Field Aliasing)

1. **Fix JVM Field Signature Population**
   - File: `parser.rs` - `parse_property()`
   - Problem: `jvm_field_signature` is often None
   - JADX Reference: `KmExt.kt:10` - `inline val KmProperty.shortId: String? get() = fieldSignature?.toString()`
   - Action: Ensure fieldSignature is always extracted from protobuf when present

2. **Improve field_matches() Fallback**
   - File: `extractor.rs:field_matches()`
   - Problem: When JVM sig is None, no fallback for obfuscated fields
   - JADX Reference: `KotlinMetadataUtils.kt:111-116`
   - Action: Match by field index order if signatures unavailable

### P1 - Important Refinements

1. **Verify Companion Class Rename Path**
   - File: `extractor.rs:943-947`
   - Action: Ensure inner class companion rename is properly triggered
   - JADX Reference: `KotlinMetadataDecompilePass.kt:78-80`

2. **Audit Package Part Counting**
   - File: `extractor.rs` or `lib.rs`
   - Action: Compare exact algorithm with JADX's `countPkgParts()`
   - JADX Reference: `KotlinMetadataUtils.kt:77-90`

### P2 - Nice-to-Have

1. **Default Method Dominator Analysis**
   - Current: Name matching heuristic
   - JADX: Dominator tree analysis
   - Impact: More accurate $default method matching in complex cases
   - JADX Reference: `KotlinUtils.kt:64-75`

## Conclusion

Dexterity's Kotlin handling has **~70-75% JADX parity** with one critical P0 bug:

**What's Working:**
1. Proto parsing (BitEncoding, d2 strings, all flags)
2. Function modifiers (suspend/inline/infix/operator/tailrec)
3. Type variance (`<in T>`, `<out T>`)
4. Data/sealed/value class detection
5. Rename reason comments (FIXED Dec 23, 2025)
6. SMAP parsing and class alias extraction
7. Kotlin intrinsics variable name extraction

**P0 Bug Blocking Production Use:**
- Field aliases NOT being applied (w→segments fails)
- Root cause: `jvm_field_signature` often None in parser
- Impact: Obfuscated Kotlin files have wrong field names

**Realistic Parity:** ~70-75% for obfuscated Kotlin code

---
*Audit performed: 2025-12-23*
*Verified by: claude-opus-4-5-20251101*
*JADX Source: jadx-fast (in-tree)*
*Dexterity Crate: dexterity-kotlin*
