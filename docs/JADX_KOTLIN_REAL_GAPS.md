# JADX Kotlin Clone Tasks - REAL GAPS

**Created: 2025-12-23**
**Last Updated: 2025-12-23**
**Author: claude-opus-4-5-20251101**
**Status: P0 BUG IDENTIFIED - FIELD ALIASING BROKEN**

This document identifies the REAL differences based on a0.java (SegmentedByteString.kt) and other output comparisons.

## Status Update (Dec 23, 2025)

| Issue | Previous Status | Current Status |
|-------|-----------------|----------------|
| Rename reason comments | MISSING | **FIXED** - "reason: from kotlin metadata" now emitted |
| Field aliasing | BROKEN | **STILL BROKEN** - P0 bug |
| Strategy 3 heuristic | BUG | **FIXED** - Removed unconditional matching |
| JVM signature matching | NOT WORKING | **STILL NOT WORKING** - `jvm_field_signature` often None |

---

## CRITICAL BUG: Field Aliases Not Applied

### What JADX Produces (Correct)

From `output/jadx/large/sources/l/a0.java` (SegmentedByteString.kt):

```java
/* renamed from: w, reason: from kotlin metadata */
private final transient byte[][] segments;

/* renamed from: x, reason: from kotlin metadata */
private final transient int[] directory;

/* renamed from: y, reason: from kotlin metadata */
private final transient int offset;

/* renamed from: z, reason: from kotlin metadata */
private final transient int byteCount;
```

### What Dexterity Produces (BROKEN)

From `output/dexterity/large/sources/l/a0.java`:

```java
private final transient byte[][] w;  // NO ALIAS - should be "segments"
private final transient int[] x;     // NO ALIAS - should be "directory"
private final transient int y;       // NO ALIAS - should be "offset"
private final transient int z;       // NO ALIAS - should be "byteCount"
```

### Root Cause Analysis

1. **JVM field signature is empty** - `property.jvm_field_signature` is often None
2. **No fallback for obfuscated names** - When JVM sig is missing, can't match `w` to `segments`
3. **Parser not extracting fieldSignature** - The protobuf field exists but isn't being populated

### Severity: P0 CRITICAL - Field names remain obfuscated in all Kotlin files.

### Root Cause Location

**File:** `crates/dexterity-kotlin/src/extractor.rs:field_matches()`

The issue is that `property.jvm_field_signature` is often empty, and the current code has NO fallback:

```rust
fn field_matches(field: &FieldData, property: &KotlinProperty) -> bool {
    // Strategy 1: JVM signature match (FAILS - jvm_field_signature often None)
    if !property.jvm_field_signature.is_empty() { ... }

    // Strategy 2: Exact name match (FAILS for obfuscated - "w" != "segments")
    if field.name == property.name { return true; }

    // Strategy 3: Backing field pattern (FAILS - no "$" in "w")
    if field.name.starts_with(&property.name) && field.name.contains('$') { return true; }

    // Strategy 4: Underscore prefix (FAILS - "w" doesn't start with "_")
    if field.name.starts_with("_") && field.name[1..] == property.name { return true; }

    // NO FALLBACK - returns false for obfuscated fields!
    false
}
```

**NOTE:** Strategy 3's unconditional matching bug was FIXED. Now NO fields match at all.

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

**Key insight:** `kmProperty.shortId` comes from `fieldSignature?.toString()` which gives `"w:[[B"` (field name + type descriptor).

---

## PREVIOUSLY CRITICAL BUG 2: field_matches() Strategy 3 - FIXED

**Status:** FIXED (Dec 23, 2025)

**Previous bug:** Strategy 3 unconditionally returned true for ANY obfuscated field matching ANY property.

**Current state:** Strategy 3 removed. Now the code is correct but incomplete - NO fallback for obfuscated fields when JVM signature is missing.

### What's Needed

Fix the parser to populate `jvm_field_signature` from protobuf:

**File:** `crates/dexterity-kotlin/src/parser.rs` - `parse_property()`

The protobuf `Property` message has a `field_signature` extension that needs to be extracted.

**JADX Reference:** `kotlin-metadata-jvm` library extracts `fieldSignature` from JVM extensions.

---

## Executive Summary

Comparing `output/jadx/badboy/sources/com/prototype/badboy/MainActivityKt.java` vs
`output/dexterity/badboy/sources/com/prototype/badboy/MainActivityKt.java`:

| Gap Category | JADX Feature | Dexterity Status | Impact |
|--------------|--------------|------------------|--------|
| **Lambda Extraction** | Generates `$lambda$43` synthetic methods | Missing | HIGH |
| **Warning Comments** | "Removed duplicated region for block" | Missing | MEDIUM |
| **Info Comments** | "Access modifiers changed from: private" | Pass exists but not wired | MEDIUM |
| **Import Resolution** | `CallLog` (uses `CallLog.Calls`) | `CallLog.Calls` (uses `Calls`) | LOW |
| **Companion Imports** | `Composer.Companion` imports | Different resolution | LOW |
| **Variable Naming** | `modifier2`, `function12` | `modifier231`, etc. | LOW |
| **Code Comments** | "Code decompiled incorrectly" fallback | Different handling | LOW |

---

## P0 - Critical Missing: Lambda Method Extraction

### What JADX Does

JADX extracts recompose scope lambdas into synthetic methods:

```java
// JADX output: jadx-fast/MainActivityKt.java:99-111
/* JADX INFO: Access modifiers changed from: private */
public static final Unit Greeting$lambda$43(String str, Modifier modifier, Function1 function1, int i, int i2, Composer composer, int i3) {
    Greeting(str, modifier, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
    return Unit.INSTANCE;
}

/* JADX INFO: Access modifiers changed from: private */
public static final Unit GreetingPreview$lambda$44(int i, Composer composer, int i2) {
    GreetingPreview(composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
    return Unit.INSTANCE;
}
```

### Where This Comes From

**Source:** `jadx-fast/jadx-core/src/main/java/jadx/core/codegen/InsnGen.java:1032-1080`

```java
private void makeInlinedLambdaMethod(ICodeWriter code, InvokeCustomNode customNode, MethodNode callMth) throws CodegenException {
    MethodGen callMthGen = new MethodGen(mgen.getClassGen(), callMth);
    NameGen nameGen = callMthGen.getNameGen();
    nameGen.inheritUsedNames(this.mgen.getNameGen());

    List<ArgType> implArgs = customNode.getImplMthInfo().getArgumentsTypes();
    List<RegisterArg> callArgs = callMth.getArgRegs();
    // ... generates lambda method body inline
}
```

**Related:** `jadx-fast/jadx-core/src/main/java/jadx/core/dex/instructions/invokedynamic/CustomLambdaCall.java`

### Clone Task

1. Add lambda method extraction to `dexterity-codegen`:
   - Detect `invoke-custom` with LambdaMetafactory bootstrap
   - Extract lambda body into synthetic method
   - Generate method named `{Class}$lambda${N}`
   - Handle Compose recompose scope callbacks specially

2. Files to modify:
   - `crates/dexterity-codegen/src/body_gen.rs` - lambda extraction
   - `crates/dexterity-ir/src/instructions.rs` - InvokeCustom handling

---

## P1 - Warning/Info Comment Infrastructure

### What JADX Does

JADX stores warnings and info comments on nodes, emits them in codegen:

```java
// RegionMaker.java:60 - Adds warning to method
mth.addWarn("Removed duplicated region for block: " + startBlock + ' ' + startBlock.getAttributesString());

// FixAccessModifiers.java:118 - Adds info comment
node.addInfoComment("Access modifiers changed from: " + accessFlags.visibilityName());
```

### Output

```java
/* JADX WARN: Removed duplicated region for block: B:107:0x0756  */
/* JADX WARN: Removed duplicated region for block: B:108:0x0758  */
...
/* JADX INFO: Access modifiers changed from: private */
public static final Unit Greeting$lambda$43(...) {
```

### Current Dexterity State

- `fix_access_modifiers.rs` exists but doesn't emit comments
- No `warnings: Vec<String>` field on MethodData/ClassData
- No `info_comments: Vec<String>` field on nodes

### Clone Task

1. Add comment fields to IR:
   ```rust
   // crates/dexterity-ir/src/info.rs
   pub struct MethodData {
       // ... existing fields ...
       /// Warnings to emit at method level (JADX parity)
       pub warnings: Vec<String>,
       /// Info comments to emit at method level (JADX parity)
       pub info_comments: Vec<String>,
   }
   ```

2. Add `add_warn()` and `add_info_comment()` helpers

3. Wire up in codegen:
   ```rust
   // crates/dexterity-codegen/src/method_gen.rs
   fn write_method_header(&mut self, method: &MethodData) {
       for warning in &method.warnings {
           self.code.add_line(&format!("/* Dexterity WARN: {} */", warning));
       }
       for info in &method.info_comments {
           self.code.add_line(&format!("/* Dexterity INFO: {} */", info));
       }
   }
   ```

4. Call from region_builder.rs:
   - **Source:** `jadx-fast/jadx-core/src/main/java/jadx/core/dex/visitors/regions/maker/RegionMaker.java:60`

5. Call from fix_access_modifiers:
   - **Source:** `jadx-fast/jadx-core/src/main/java/jadx/core/dex/visitors/fixaccessmodifiers/FixAccessModifiers.java:118`

---

## P2 - Import Resolution Strategy

### What JADX Does

JADX optimizes imports to use shorter forms:

```java
// JADX imports
import android.provider.CallLog;
import android.provider.ContactsContract;

// JADX code uses
CallLog.Calls.CONTENT_URI
```

### What Dexterity Does

```java
// Dexterity imports
import android.provider.CallLog.Calls;
import android.provider.ContactsContract.Contacts;

// Dexterity code uses
Calls.CONTENT_URI
```

### Source Reference

**Source:** `jadx-fast/jadx-core/src/main/java/jadx/core/codegen/ClassGen.java` (imports)
**Source:** `jadx-fast/jadx-core/src/main/java/jadx/core/codegen/TypeGen.java` (type resolution)

### Clone Task

1. Analyze usage patterns before import generation
2. Prefer importing parent class when multiple inner classes used
3. Handle `.Companion` imports for Kotlin (JADX imports `Composer.Companion`)

Files to modify:
- `crates/dexterity-codegen/src/class_gen.rs` - import resolution

---

## P3 - Variable Naming (SSA)

### What JADX Does

JADX preserves meaningful variable names from SSA:

```java
Modifier modifier2;
Function1<? super String[], Unit> function12;
Function1<? super String[], Unit> function13;
Object objMutableStateOf$default;
Function0 function0;
```

### What Dexterity Does

Different naming pattern (needs verification from full diff).

### Source Reference

**Source:** `jadx-fast/jadx-core/src/main/java/jadx/core/codegen/NameGen.java`
**Source:** `jadx-fast/jadx-core/src/main/java/jadx/core/dex/visitors/ssa/SSATransform.java`

### Clone Task

Lower priority - naming is functional, just different style.

---

## P4 - "Code decompiled incorrectly" Fallback

### What JADX Does

When decompilation fails, JADX emits:

```java
/*
    Code decompiled incorrectly, please refer to instructions dump.
*/
```

### Source Reference

**Source:** `jadx-fast/jadx-core/src/main/java/jadx/core/codegen/MethodGen.java` (fallback handling)

### Clone Task

Add similar fallback messaging when codegen fails.

---

## File Mapping: JADX → Dexterity

| JADX Source | Dexterity Target | Clone Status |
|-------------|------------------|--------------|
| `InsnGen.java:makeInlinedLambdaMethod` | `body_gen.rs` | NOT CLONED |
| `CustomLambdaCall.java` | `instructions.rs` | PARTIAL |
| `RegionMaker.java:addWarn` | `region_builder.rs` | NOT CLONED |
| `FixAccessModifiers.java:addInfoComment` | `fix_access_modifiers.rs` | NOT WIRED |
| `ClassGen.java` (imports) | `class_gen.rs` | DIFFERENT |
| `NameGen.java` | `var_naming.rs` | DIFFERENT |

---

## Priority Order

### Phase 1: Infrastructure (Must Have)
1. **P1: Warning/Info Comment Fields** - Add to IR, wire to codegen
2. **P1: FixAccessModifiers wiring** - Actually use the pass, emit comments

### Phase 2: Lambda Extraction (High Impact)
3. **P0: Lambda Method Extraction** - Generate `$lambda$N` methods
4. **P0: InvokeCustom handling** - LambdaMetafactory support

### Phase 3: Polish (Nice to Have)
5. **P2: Import Resolution** - Match JADX strategy
6. **P3: Variable Naming** - Consider style alignment
7. **P4: Fallback Comments** - "Code decompiled incorrectly"

---

## Testing Strategy

1. Compare against JADX output for:
   - `output/jadx/badboy/` vs `output/dexterity/badboy/`
   - Focus on MainActivityKt.java as reference

2. Key checks:
   - Lambda methods exist with correct names
   - Warning comments present
   - Info comments present
   - Import style matches

3. Automated diff scoring:
   ```bash
   diff output/jadx/.../MainActivityKt.java output/dexterity/.../MainActivityKt.java | wc -l
   ```

---

## Conclusion

The previous "98% parity" claim was based on Kotlin **metadata parsing**, which is indeed mostly complete.
However, the **output quality** differs significantly due to:

1. Missing lambda extraction
2. Missing warning/info comment infrastructure
3. Different import resolution
4. Different variable naming

Realistic current parity: **~70-75%** for Kotlin Compose files.
Goal: **95%+** parity with JADX output.

---

---

## PRIORITY FIX LIST (Clone from JADX)

### P0: CRITICAL (Output Broken)

| # | Bug | Location | JADX Reference | Est. Complexity | Status |
|---|-----|----------|----------------|-----------------|--------|
| 1 | JVM field signature not populated | `parser.rs:parse_property()` | `kotlin-metadata-jvm` | Medium | **OPEN** |
| 2 | No fallback for obfuscated fields | `extractor.rs:field_matches()` | `KotlinMetadataUtils.kt:111-116` | Medium | **OPEN** |
| ~~3~~ | ~~Rename reason comments missing~~ | ~~`class_gen.rs`~~ | ~~`RenameReasonAttr.java`~~ | ~~Low~~ | **FIXED** |
| ~~4~~ | ~~Strategy 3 unconditional matching~~ | ~~`extractor.rs:432-435`~~ | - | ~~Low~~ | **FIXED** |

### P1: HIGH (Missing Features)

| # | Feature | Location | JADX Reference | Est. Complexity |
|---|---------|----------|----------------|-----------------|
| 5 | Warning/Info comment infrastructure | `info.rs`, `class_gen.rs` | `NotificationAttrNode.java` | Low |
| 6 | "Access modifiers changed" comments | `fix_access_modifiers.rs` | `FixAccessModifiers.java:118` | Low |
| 7 | "Removed duplicated region" warnings | `region_builder.rs` | `RegionMaker.java:60` | Low |
| 8 | Lambda method extraction ($lambda$N) | `body_gen.rs` | `InsnGen.java:1032-1080` | High |

### P2: MEDIUM (Polish)

| # | Feature | Location | JADX Reference | Est. Complexity |
|---|---------|----------|----------------|-----------------|
| 9 | Import resolution strategy | `class_gen.rs` | `ClassGen.java` imports | Medium |
| 10 | "Code decompiled incorrectly" fallback | `method_gen.rs` | `MethodGen.java` fallback | Low |

---

## Immediate Next Steps

1. **Fix JVM field signature extraction** - `parser.rs:parse_property()` needs to extract `fieldSignature` from JVM extensions
2. **Add fallback matching** - If JVM sig missing, try index-based matching as last resort
3. **Verify with a0.java** - Run `diff output/jadx/.../a0.java output/dexterity/.../a0.java`

---

## Realistic Parity Assessment (Dec 23, 2025)

| File Type | Current Parity | After P0 Fix | After P1/P2 |
|-----------|----------------|--------------|-------------|
| Kotlin (SegmentedByteString) | ~70% | ~90% | ~95% |
| Kotlin Compose (MainActivityKt) | ~70% | ~85% | ~95% |
| Plain Java | ~90% | ~90% | ~95% |

## What's Fixed (Dec 23, 2025)

1. **Rename reason comments** - Now emits "reason: from kotlin metadata"
2. **Strategy 3 bug** - Removed unconditional obfuscated field matching
3. **JADX reference comments** - Added throughout codebase

---

*Document created by honest analysis of actual output differences.*
*Verified by comparing a0.java output between JADX and Dexterity.*
*Last updated: 2025-12-23*
