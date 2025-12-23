# JADX Pass Parity Status

## Philosophy

We are **NOT rewriting JADX**. We are **CLONING** it.

JADX has 10 years of edge case handling that we cannot replicate by just looking at output.
We must clone the source code logic exactly, preserving behavior for all edge cases.

**Last Updated:** Dec 23, 2025

---

## Summary

| Category | Total | Implemented | Missing | Coverage |
|----------|-------|-------------|---------|----------|
| Core Visitors | 31 | 28 | 3 | 90% |
| Region Visitors | 17 | 16 | 1 | 94% |
| Block Processing | 8 | 6 | 2 | 75% |
| Type Inference | 27 | 24 | 3 | 89% |
| Subdirectories | 22 | 12 | 10 | 55% |
| **TOTAL** | **105** | **86** | **19** | **82%** |

### New Passes Implemented (Dec 23, 2025)
- `switch_over_string.rs` - JADX SwitchOverStringVisitor clone
- `replace_new_array.rs` - JADX ReplaceNewArray clone
- `fix_multi_entry_loops.rs` - JADX FixMultiEntryLoops clone
- `process_try_catch_regions.rs` - JADX ProcessTryCatchRegions clone
- `signature_processor.rs` - JADX SignatureProcessor clone (validation logic)
- `synchronized_region.rs` - JADX SynchronizedRegionMaker clone
- `exc_handlers_region.rs` - JADX ExcHandlersRegionMaker clone

---

## CRITICAL MISSING PASSES (P0)

These passes are essential for correct decompilation output.

### P0-1: SwitchOverStringVisitor
**JADX Source:** `jadx-core/src/main/java/jadx/core/dex/visitors/regions/SwitchOverStringVisitor.java` (479 lines)
**Status:** IMPLEMENTED - `switch_over_string.rs`
**Impact:** String switch statements show as complex hashCode/equals patterns

```java
// JADX SwitchOverStringVisitor.java:71-125
// Detects pattern: switch(str.hashCode()) { case XYZ: if(str.equals("...")) }
// Transforms to clean: switch(str) { case "...": }
```

---

### P0-2: ReplaceNewArray
**JADX Source:** `jadx-core/src/main/java/jadx/core/dex/visitors/ReplaceNewArray.java` (218 lines)
**Status:** IMPLEMENTED - `replace_new_array.rs`
**Impact:** Array initializations show as new + sequential puts instead of literals

```java
// JADX ReplaceNewArray.java:69-182
// Transforms: int[] arr = new int[3]; arr[0] = 1; arr[1] = 2; arr[2] = 3;
// Into:       int[] arr = {1, 2, 3};
```

---

### P0-3: SignatureProcessor
**JADX Source:** `jadx-core/src/main/java/jadx/core/dex/visitors/SignatureProcessor.java` (337 lines)
**Status:** IMPLEMENTED - `signature_processor.rs` + `converter.rs`
**Impact:** Generic type signatures not properly parsed from annotations

```java
// JADX SignatureProcessor.java - Parses dalvik signature annotations
// Extracts: class Foo<T extends Bar> implements Comparable<T>
// From: .annotation system Ldalvik/annotation/Signature;
```

Core signature parsing is in `converter.rs`. Validation logic cloned in `signature_processor.rs`:
- `validate_parsed_type()` - Type validation against DEX types
- `validate_full_class_name()` - Java identifier validation
- `fix_type_param_declarations()` - Add missing type parameters
- `validate_inner_type()` - Inner class type validation
- `process_super_type()` / `process_interfaces()` - Type merging

---

### P0-4: AttachTryCatchVisitor
**JADX Source:** `jadx-core/src/main/java/jadx/core/dex/visitors/AttachTryCatchVisitor.java` (153 lines)
**Status:** PARTIALLY IMPLEMENTED (in block_split.rs)
**Impact:** Try-catch regions may be incorrectly bounded

```java
// JADX AttachTryCatchVisitor.java:45-60 - Core logic
// Attaches CatchAttr to instructions within try bounds
// Marks TRY_ENTER and TRY_LEAVE flags
```

**Clone Task:**
1. Verify current implementation in `block_split.rs` matches JADX exactly
2. Add missing `attachCatchAttr()` merge logic (lines 94-103)
3. Add `insertNOP()` for empty try regions (lines 146-152)

---

## HIGH PRIORITY MISSING (P1)

### P1-1: FixMultiEntryLoops
**JADX Source:** `jadx-core/src/main/java/jadx/core/dex/visitors/blocks/FixMultiEntryLoops.java` (130 lines)
**Status:** IMPLEMENTED - `fix_multi_entry_loops.rs`
**Impact:** Loops with multiple entry points may cause region construction failures

```java
// JADX FixMultiEntryLoops.java:26-50
// Detects loops where header has predecessors from outside the loop
// Inserts synthetic blocks to normalize the CFG
```

---

### P1-2: ProcessTryCatchRegions
**JADX Source:** `jadx-core/src/main/java/jadx/core/dex/visitors/regions/ProcessTryCatchRegions.java` (120 lines)
**Status:** IMPLEMENTED - `process_try_catch_regions.rs`
**Impact:** Try-catch blocks may not be properly structured as regions

```java
// JADX ProcessTryCatchRegions.java - Wraps try-catch into TryCatchRegion
// Creates proper nesting of try blocks with their handlers
```

---

### P1-3: ExcHandlersRegionMaker
**JADX Source:** `jadx-core/src/main/java/jadx/core/dex/visitors/regions/maker/ExcHandlersRegionMaker.java` (~200 lines)
**Status:** IMPLEMENTED - `exc_handlers_region.rs`
**Impact:** Exception handler regions not properly constructed

```rust
// JADX Reference: ExcHandlersRegionMaker.java:34-42
// Cloned: process_exc_handlers(), find_handler_exits(), process_exc_handler()
```

---

### P1-4: SynchronizedRegionMaker
**JADX Source:** `jadx-core/src/main/java/jadx/core/dex/visitors/regions/maker/SynchronizedRegionMaker.java` (~150 lines)
**Status:** IMPLEMENTED - `synchronized_region.rs`
**Impact:** synchronized blocks not detected

```rust
// JADX Reference: SynchronizedRegionMaker.java:41-90
// Cloned: process_synchronized_regions(), find_monitor_enters(), find_monitor_exits()
// Also: can_remove_sync_block(), create_synchronized_region()
```

---

### P1-5: DebugInfoVisitors
**JADX Source:** `jadx-core/src/main/java/jadx/core/dex/visitors/debuginfo/` (2 files, ~200 lines total)
**Status:** NOT IMPLEMENTED
**Impact:** Original variable names and line numbers not used

---

## MEDIUM PRIORITY (P2)

### P2-1: AttachCommentsVisitor
**JADX Source:** `jadx-core/src/main/java/jadx/core/dex/visitors/AttachCommentsVisitor.java` (139 lines)
**Status:** NOT IMPLEMENTED
**Impact:** Original source comments not preserved

---

### P2-2: FixAccessModifiers
**JADX Source:** `jadx-core/src/main/java/jadx/core/dex/visitors/fixaccessmodifiers/` (2 files, ~300 lines)
**Status:** NOT IMPLEMENTED
**Impact:** Private methods called from inner classes may have wrong visibility

---

### P2-3: AddAndroidConstants
**JADX Source:** `jadx-core/src/main/java/jadx/core/dex/visitors/prepare/AddAndroidConstants.java` (~150 lines)
**Status:** NOT IMPLEMENTED
**Impact:** Android resource IDs not resolved to R.id.xxx format

---

### P2-4: CollectConstValues
**JADX Source:** `jadx-core/src/main/java/jadx/core/dex/visitors/prepare/CollectConstValues.java` (~100 lines)
**Status:** NOT IMPLEMENTED
**Impact:** Constant field values not extracted from annotations

---

## LOW PRIORITY (P3)

### P3-1: ResolveJavaJSR (Legacy)
**JADX Source:** `jadx-core/src/main/java/jadx/core/dex/visitors/blocks/ResolveJavaJSR.java` (108 lines)
**Status:** NOT IMPLEMENTED
**Impact:** Ancient Java 1.4 finally blocks (rare in modern DEX)

---

### P3-2: FallbackModeVisitor
**JADX Source:** `jadx-core/src/main/java/jadx/core/dex/visitors/FallbackModeVisitor.java` (40 lines)
**Status:** NOT IMPLEMENTED
**Impact:** Debug/fallback output mode

---

### P3-3: DotGraphVisitor
**JADX Source:** `jadx-core/src/main/java/jadx/core/dex/visitors/DotGraphVisitor.java` (332 lines)
**Status:** NOT IMPLEMENTED
**Impact:** Debug visualization only

---

### P3-4: NonFinalResIdsVisitor
**JADX Source:** `jadx-core/src/main/java/jadx/core/dex/visitors/gradle/NonFinalResIdsVisitor.java` (~100 lines)
**Status:** NOT IMPLEMENTED
**Impact:** Gradle library module resource ID handling

---

### P3-5: SourceFileRename / UserRenames
**JADX Source:** `jadx-core/src/main/java/jadx/core/dex/visitors/rename/` (4 files)
**Status:** PARTIALLY IMPLEMENTED
**Impact:** User-defined renames and source file metadata

---

## IMPLEMENTED PASSES (Reference)

### Core Visitors (25/31)
| JADX File | Dexterity File | Status |
|-----------|----------------|--------|
| AnonymousClassVisitor.java | anonymous_class_visitor.rs | ✅ |
| ApplyVariableNames.java | var_naming.rs | ✅ |
| AttachMethodDetails.java | attach_method_details.rs | ✅ |
| CheckCode.java | check_code.rs | ✅ |
| ClassModifier.java | class_modifier.rs | ✅ NEW |
| ConstInlineVisitor.java | const_inline.rs | ✅ |
| ConstructorVisitor.java | constructor_visitor.rs | ✅ |
| DeboxingVisitor.java | deboxing.rs | ✅ |
| EnumVisitor.java | enum_visitor.rs | ✅ |
| ExtractFieldInit.java | extract_field_init.rs | ✅ |
| FixSwitchOverEnum.java | fix_switch_over_enum.rs | ✅ NEW |
| GenericTypesVisitor.java | generic_types.rs | ✅ |
| InitCodeVariables.java | init_code_vars.rs | ✅ |
| InlineMethods.java | inline_methods.rs | ✅ NEW |
| MarkMethodsForInline.java | method_inline.rs | ✅ |
| MethodInvokeVisitor.java | method_invoke.rs | ✅ |
| MethodThrowsVisitor.java | method_throws_visitor.rs | ✅ |
| ModVisitor.java | mod_visitor.rs | ✅ |
| MoveInlineVisitor.java | move_inline.rs | ✅ |
| OverrideMethodVisitor.java | override_method.rs | ✅ |
| PrepareForCodeGen.java | prepare_for_codegen.rs | ✅ |
| ProcessAnonymous.java | process_anonymous.rs | ✅ |
| ProcessInstructionsVisitor.java | process_instructions.rs | ✅ |
| ShadowFieldVisitor.java | shadow_field.rs | ✅ |
| SimplifyVisitor.java | simplify.rs | ✅ |

### Region Visitors (12/17)
| JADX File | Dexterity File | Status |
|-----------|----------------|--------|
| CheckRegions.java | check_regions.rs | ✅ |
| CleanRegions.java | clean_regions.rs | ✅ |
| IfRegionVisitor.java | if_region_visitor.rs | ✅ |
| LoopRegionVisitor.java | loop_analysis.rs | ✅ |
| PostProcessRegions.java | post_process_regions.rs | ✅ |
| RegionMakerVisitor.java | region_builder.rs | ✅ |
| ReturnVisitor.java | return_visitor.rs | ✅ |
| SwitchBreakVisitor.java | switch_break_visitor.rs | ✅ NEW |
| TernaryMod.java | ternary_mod.rs | ✅ |
| IfRegionMaker.java | if_region_visitor.rs | ✅ |
| LoopRegionMaker.java | loop_analysis.rs | ✅ |
| SwitchRegionMaker.java | region_builder.rs | ✅ |

### Block Processing (5/8)
| JADX File | Dexterity File | Status |
|-----------|----------------|--------|
| BlockProcessor.java | cfg.rs / ssa.rs | ✅ |
| BlockSplitter.java | block_split.rs | ✅ |
| DominatorTree.java | algorithms/dominators.rs | ✅ |
| PostDominatorTree.java | algorithms/dominators.rs | ✅ |
| BlockFinisher.java | block_split.rs | ✅ |

### Type Inference (24/27)
All major type inference components implemented in:
- type_inference.rs
- type_update.rs
- type_search.rs
- type_bound.rs
- fix_types.rs
- finish_type_inference.rs

### Other Subdirectories
| Category | Implemented | Total |
|----------|-------------|-------|
| shrink/ | 3/3 | code_shrink.rs |
| finaly/ | 3/3 | finally_extract.rs |
| usage/ | 3/3 | usage_info.rs |
| kotlin/ | 1/1 | kotlin_intrinsics.rs |

---

## Next Steps

### Phase 1: Critical Missing - COMPLETE ✅
1. [x] Clone SwitchOverStringVisitor.java -> switch_over_string.rs ✅
2. [x] Clone ReplaceNewArray.java -> replace_new_array.rs ✅
3. [x] Clone SignatureProcessor.java -> signature_processor.rs ✅
4. [ ] Verify/fix AttachTryCatchVisitor parity (partially implemented in block_split.rs)

### Phase 2: High Priority - MOSTLY COMPLETE ✅
1. [x] Clone FixMultiEntryLoops.java -> fix_multi_entry_loops.rs ✅
2. [x] Clone ProcessTryCatchRegions.java -> process_try_catch_regions.rs ✅
3. [x] Clone ExcHandlersRegionMaker.java -> exc_handlers_region.rs ✅
4. [x] Clone SynchronizedRegionMaker.java -> synchronized_region.rs ✅
5. [ ] Clone DebugInfo visitors

### Phase 3: Medium Priority (Remaining)
1. [ ] Clone AttachCommentsVisitor.java
2. [ ] Clone FixAccessModifiers/
3. [ ] Clone prepare/ visitors

### Phase 4: Polish (Ongoing)
1. [ ] Low priority passes as needed
2. [ ] Edge case testing
3. [ ] Performance optimization

---

## How to Clone a Pass

1. **Read the JADX source file completely** - Understand the full algorithm
2. **Identify all helper methods** - Clone private methods too
3. **Map JADX types to Dexterity types**:
   - `InsnNode` -> `InsnType` / `Instruction`
   - `RegisterArg` -> `RegisterArg` struct
   - `SSAVar` -> SSA variable indices
   - `BlockNode` -> `BlockId`
   - `MethodNode` -> `MethodData`
4. **Add JADX reference comments** with line numbers:
   ```rust
   // JADX Reference: SwitchOverStringVisitor.java:71-125
   // Clone of: restoreSwitchOverString()
   ```
5. **Test with edge cases** - JADX tests are in jadx-core/src/test/

---

*This document tracks JADX pass parity. Update as passes are implemented.*
