# JADX Kotlin Clone Tasks - REAL GAPS (Not 98%)

**Created: 2025-12-23**
**Author: claude-opus-4-5-20251101**
**Status: HONEST ASSESSMENT - CRITICAL BUGS FOUND**

The previous doc claimed "98% parity" but comparing actual output shows **SEVERE BUGS**.
This document identifies the REAL differences based on MainActivityKt.java and Balloon.java analysis.

---

## CRITICAL BUG: Field Name/Type Corruption

### What JADX Produces (Correct)

```java
/* renamed from: A, reason: from kotlin metadata */
private final kotlin.h autoDismissRunnable;

/* renamed from: C, reason: from kotlin metadata */
private final Context context;

/* renamed from: c, reason: collision with root package name and from kotlin metadata */
private final PopupWindow bodyWindow;
```

### What Dexterity Produces (BROKEN)

```java
/* renamed from: A */
private final h Lcom/skydoves/balloon/d;;  // BUG: Type descriptor as field name!

/* renamed from: C */
private final Context onBalloonClickListener;  // BUG: Wrong name

/* renamed from: c */
private final PopupWindow destroyed = new PopupWindow();  // BUG: Wrong alias
```

### Root Cause Analysis

1. **Type descriptor leaking into field name** - `Lcom/skydoves/balloon/d;` is a JVM type
2. **Kotlin metadata d2 parsing bug** - Field names from metadata are wrong
3. **Name mapping corruption** - `autoDismissRunnable` → `Lcom/skydoves/balloon/d;`

### Severity: P0 CRITICAL - This makes the output unusable.

### Root Cause Location

**File:** `crates/dexterity-kotlin/src/extractor.rs:432-435`

```rust
// Strategy 3: Obfuscated field name matching
if looks_obfuscated(&field.name) && !looks_obfuscated(&property.name) {
    return true;  // BUG! Returns true unconditionally - matches ANY field to ANY property!
}
```

This causes:
1. Field "A" (obfuscated) matches first property in list
2. Field "C" (obfuscated) matches wrong property
3. Wrong Kotlin property names assigned as aliases

### JADX Reference for Correct Implementation

**File:** `jadx-fast/jadx-plugins/jadx-kotlin-metadata/src/main/kotlin/jadx/plugins/kotlin/metadata/KotlinMetadataDecompilePass.kt:50-80`

JADX matches fields by:
1. JVM field signature (from `fieldSignature`)
2. Getter/setter signatures
3. Explicit field name from metadata

---

## CRITICAL BUG 2: field_matches() Strategy 3

**Location:** `crates/dexterity-kotlin/src/extractor.rs:418-445`

```rust
fn field_matches(field: &FieldData, property: &KotlinProperty) -> bool {
    // ... strategies 1-2 ...

    // Strategy 3: BROKEN - always returns true!
    if looks_obfuscated(&field.name) && !looks_obfuscated(&property.name) {
        return true;  // ← THIS IS THE BUG
    }
    // ... strategy 4 ...
}
```

### Fix Required

Clone JADX's field matching from:
**File:** `jadx-fast/jadx-plugins/jadx-kotlin-metadata/src/main/kotlin/jadx/plugins/kotlin/metadata/utils/KotlinMetadataUtils.kt:63-90`

JADX uses `KmProperty.fieldSignature` to get the exact JVM field name/type and matches by signature.

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

| # | Bug | Location | JADX Reference | Est. Complexity |
|---|-----|----------|----------------|-----------------|
| 1 | field_matches() returns true unconditionally | `extractor.rs:432-435` | `KotlinMetadataUtils.kt:63-90` | Medium |
| 2 | Type descriptor leaking into field name | `extractor.rs` | `KotlinMetadataDecompilePass.kt` | Medium |

### P1: HIGH (Missing Features)

| # | Feature | Location | JADX Reference | Est. Complexity |
|---|---------|----------|----------------|-----------------|
| 3 | Warning/Info comment infrastructure | `info.rs`, `class_gen.rs` | `NotificationAttrNode.java` | Low |
| 4 | "Access modifiers changed" comments | `fix_access_modifiers.rs` | `FixAccessModifiers.java:118` | Low |
| 5 | "Removed duplicated region" warnings | `region_builder.rs` | `RegionMaker.java:60` | Low |
| 6 | Lambda method extraction ($lambda$N) | `body_gen.rs` | `InsnGen.java:1032-1080` | High |

### P2: MEDIUM (Polish)

| # | Feature | Location | JADX Reference | Est. Complexity |
|---|---------|----------|----------------|-----------------|
| 7 | Import resolution strategy | `class_gen.rs` | `ClassGen.java` imports | Medium |
| 8 | Rename reason format | `class_gen.rs` | `RenameReasonAttr.java` | Low |
| 9 | "Code decompiled incorrectly" fallback | `method_gen.rs` | `MethodGen.java` fallback | Low |

---

## Immediate Next Steps

1. **FIX P0 BUGS FIRST** - The output is currently broken for obfuscated Kotlin code
2. **Clone JADX field matching** - Use JVM field signatures, not heuristics
3. **Add warning/info infrastructure** - Enable proper JADX-style comments
4. **Verify with diff** - Run `diff output/jadx/.../Balloon.java output/dexterity/.../Balloon.java`

---

## Realistic Parity Assessment

| File Type | Current Parity | After P0 Fix | After P1/P2 |
|-----------|----------------|--------------|-------------|
| Kotlin Compose (MainActivityKt) | ~70% | ~80% | ~95% |
| Kotlin Library (Balloon.java) | ~60% | ~85% | ~95% |
| Plain Java | ~90% | ~90% | ~95% |

---

*Document created by honest analysis of actual output differences.*
*Don't trust claims - verify with diffs.*
*Last updated: 2025-12-23*
