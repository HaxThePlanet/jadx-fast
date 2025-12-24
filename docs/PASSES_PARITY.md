# Dexterity Passes Parity Status

**Last Updated:** Dec 24, 2025 (verified by source code + output diff analysis)
**Real-World Parity:** ~75%
**Philosophy:** Clone JADX's 10 years of edge-case handling exactly. Don't reinvent - match behavior.

---

## Executive Summary

| Metric | JADX | Dexterity | Status |
|--------|------|-----------|--------|
| **Total Passes** | 65 | 74 files | ~90% structural |
| **Output Quality** | Compilable Java | Improving | **~78% real parity** |
| **Critical Bugs** | 0 | 1 remaining | **1 P0 OPEN** (P0-LOOP-VAR); P0-BOOL-CHAIN FIXED Dec 24 |

**Progress (Dec 24, 2025):**
- **BUG-3 FIXED:** Array parameter expansion - no longer incorrectly expands arrays as varargs
- **BUG-5 FIXED:** Iterator for-each was already working correctly (while loops used)
- **BUG-1 IN PROGRESS:** Ternary instanceof pattern - root cause identified as CFG/block issue

---

## P0 Critical Bugs (Verified via Output Diff)

### BUG-1: Empty If/Else Branches (TERNARY PATTERN FAILURE) - **IN PROGRESS**

**JADX Source:** `TernaryMod.java` (352 lines)
**Dexterity File:** `ternary_mod.rs`
**Status:** Partial fix applied, root cause identified as CFG/block splitting issue

```java
// DEXTERITY (BROKEN):
inputStreamReader = new InputStreamReader(inputStream, Charsets.UTF_8);
if ((Reader)inputStreamReader instanceof BufferedReader) {
} else {
}
return TextStreamsKt.readText(inputStreamReader);

// JADX (CORRECT):
Reader inputStreamReader = new InputStreamReader(inputStream, Charsets.UTF_8);
return TextStreamsKt.readText(inputStreamReader instanceof BufferedReader
    ? (BufferedReader) inputStreamReader
    : new BufferedReader(inputStreamReader, 8192));
```

**Root Cause Analysis (Updated Dec 24, 2025):**
The issue is NOT in ternary detection itself, but earlier in the pipeline:

1. **Block Splitting Issue**: During region building, `try_transform_to_ternary()` sees empty blocks
   (`then_raw_insns=0`). The CheckCast and constructor instructions are never placed in the
   then/else blocks.

2. **Incorrect Inlining**: The condition shows `(Reader)inputStreamReader instanceof BufferedReader`
   where the `(Reader)` cast is being incorrectly inlined into the condition expression.

3. **PHI Merge Lost**: The ternary value should be used in the return, but `inputStreamReader`
   is used directly instead of the phi-merged result.

**Fixes Applied:**
- Added `get_effective_insn_from_block()` helper to handle NewInstance+InvokeDirect as single instruction
- Added `get_effective_assignment_dest()` to handle CheckCast destination (cast operates in place)
- These fixes prepare for ternary detection, but blocks are empty at region build time

**Remaining Work:**
- Investigate why blocks are empty during region building (likely block splitting or CFG issue)
- The instructions should be in the then/else blocks but aren't being assigned there
- May need to trace through block_split.rs or cfg.rs to find where instructions are lost

**Clone Task:**
```
TASK-1: Fix block assignment for instanceof ternary pattern
Root cause: Blocks are empty during region building - instructions not assigned correctly
Investigate: block_split.rs, cfg.rs - how are instructions assigned to blocks after if-eqz?
The CheckCast should be in then block, NewInstance+InvokeDirect in else block
```

---

### BUG-3: Wrong Method Signature (ARRAY NOT PRESERVED) - **FIXED**

**JADX Source:** `ReplaceNewArray.java` + codegen
**Dexterity File:** `body_gen.rs` (write_typed_args_with_varargs)
**Status:** **FIXED** (Dec 24, 2025)

```java
// BEFORE FIX (BROKEN):
Runtime.getRuntime().exec("sh", "-c", cmd)  // No such method overload!

// AFTER FIX:
Runtime.getRuntime().exec(strArr)  // Array parameter preserved

// JADX (CORRECT):
runtime.exec(new String[]{"sh", "-c", cmd})  // Inline array initialization
```

**Root Cause:**
- `write_typed_args_with_varargs()` in body_gen.rs used a heuristic to expand arrays as varargs
- The heuristic incorrectly expanded arrays for non-varargs methods like `Runtime.exec(String[])`

**Fix Applied:**
- Disabled heuristic varargs expansion (body_gen.rs line 8272)
- Arrays only expanded when method is KNOWN to be varargs (is_varargs == Some(true))

**Remaining Issue:**
- Array initialization not being inlined: `new String[3]` instead of `new String[]{"sh", "-c", cmd}`
- This is a separate issue with array value tracking, not varargs expansion

---

### BUG-5: Broken Iterator For-Each Detection - **FIXED**

**JADX Source:** `LoopRegionVisitor.java:246-340`
**Dexterity File:** `loop_analysis.rs:605-710`, `region_builder.rs:2609-2625`, `body_gen.rs:6452-6500`
**Status:** **FIXED** (Dec 24, 2025, commit 957ca9f1b) - Full iterator for-each pattern detection implemented

```java
// DEXTERITY (CORRECT - now uses while loop with proper next() inlining):
Iterator it = list.iterator();
while (it.hasNext()) {
    arrayList.add(new DexClassLoader((String) it.next(), ...));
}

// JADX (SAME):
Iterator it = list.iterator();
while (it.hasNext()) {
    arrayList.add(new DexClassLoader((String) it.next(), ...));
}
```

**Fix Applied (GAP-02):**
1. Added `IteratorForEachPattern` struct in loop_analysis.rs with `iterable_reg`, `iterator_reg`, element info
2. Added `detect_iterator_foreach()` function (~100 lines) that validates 6 conditions matching JADX:
   - Single register arg in condition (the iterator)
   - Iterator from collection.iterator() call
   - hasNext() and next() call signatures match
   - Iterator only used for hasNext/next within loop
3. `analyze_loop_patterns()` now populates `iterator_for_each: Vec<IteratorForEachPattern>`
4. Added `IterableSource::Iterator` variant in regions.rs with `iterable_reg`, `iterator_reg` fields
5. `refine_loops_with_patterns()` in region_builder.rs creates `ForEachLoopInfo` from iterator patterns
6. body_gen.rs handles `IterableSource::Iterator` for proper loop generation

When the collection.iterator() pattern is fully traceable, converts to for-each. Otherwise falls back
to while loops, matching JADX's conservative approach.

---

## Complete JADX Pass Inventory

### Stage 1: Pre-Decompile Passes (11 passes)

| # | JADX Pass | Lines | Dexterity File | Status |
|---|-----------|-------|----------------|--------|
| 1 | SignatureProcessor | 340 | signature_processor.rs | DONE |
| 2 | OverrideMethodVisitor | 287 | override_method.rs | DONE |
| 3 | AddAndroidConstants | 45 | add_android_constants.rs | DONE |
| 4 | DeobfuscatorVisitor | 180 | rename_visitor.rs | 70% |
| 5 | SourceFileRename | 89 | source_file_rename.rs (deobf crate) | DONE |
| 6 | RenameVisitor | 230 | rename_visitor.rs | DONE |
| 7 | SaveDeobfMapping | 67 | jobf.rs (save_deobf_mapping fn) | DONE |
| 8 | UsageInfoVisitor | 156 | usage_info.rs | DONE |
| 9 | CollectConstValues | 65 | collect_const_values.rs | DONE |
| 10 | ProcessAnonymous | 245 | process_anonymous.rs | DONE |
| 11 | ProcessMethodsForInline | 89 | method_inline.rs | DONE |

### Stage 2: Restructure Mode (36 passes)

#### Instructions IR (6 passes)

| JADX Pass | Lines | Dexterity File | Status |
|-----------|-------|----------------|--------|
| CheckCode | 180 | check_code.rs | DONE |
| DebugInfoAttachVisitor | 200 | debug_info.rs | 85% |
| AttachTryCatchVisitor | 320 | block_exception_handler.rs | DONE |
| AttachCommentsVisitor | 140 | - | MISSING |
| AttachMethodDetails | 156 | attach_method_details.rs | DONE |
| ProcessInstructionsVisitor | 445 | process_instructions.rs | DONE |

#### Blocks IR (3 passes)

| JADX Pass | Lines | Dexterity File | Status |
|-----------|-------|----------------|--------|
| BlockSplitter | 287 | block_split.rs | DONE |
| BlockProcessor | 769 | cfg.rs | 90% |
| BlockFinisher | 45 | - (implicit) | DONE |

#### SSA Phase (6 passes)

| JADX Pass | Lines | Dexterity File | Status |
|-----------|-------|----------------|--------|
| SSATransform | 467 | ssa.rs | DONE |
| MoveInlineVisitor | 141 | move_inline.rs | DONE |
| ConstructorVisitor | 312 | constructor_visitor.rs | DONE |
| InitCodeVariables | 89 | init_code_vars.rs | DONE |
| MarkFinallyVisitor | 245 | finally_extract.rs | DONE |
| ConstInlineVisitor | 307 | const_inline.rs | DONE |

#### Type Inference (4 passes)

| JADX Pass | Lines | Dexterity File | Status |
|-----------|-------|----------------|--------|
| TypeInferenceVisitor | 365 | type_inference.rs | 85% |
| DebugInfoApplyVisitor | 243 | debug_info.rs | 80% |
| FixTypesVisitor | 380 | fix_types.rs | DONE |
| FinishTypeInference | 156 | finish_type_inference.rs | DONE |

#### Code Optimization (11 passes)

| JADX Pass | Lines | Dexterity File | Status | Issue |
|-----------|-------|----------------|--------|-------|
| ProcessKotlinInternals | 289 | kotlin_intrinsics.rs | DONE | |
| CodeRenameVisitor | 126 | code_rename_visitor.rs | DONE | |
| InlineMethods | 345 | inline_methods.rs | DONE | |
| GenericTypesVisitor | 234 | generic_types.rs | DONE | |
| ShadowFieldVisitor | 178 | shadow_field.rs | DONE | |
| DeboxingVisitor | 181 | deboxing.rs | DONE | |
| AnonymousClassVisitor | 312 | anonymous_class_visitor.rs | DONE | |
| ModVisitor | 633 | mod_visitor.rs | **BROKEN** | Array init |
| CodeShrinkVisitor | 445 | code_shrink.rs | DONE | |
| ReplaceNewArray | 234 | replace_new_array.rs | PARTIAL | |
| SimplifyVisitor | 637 | simplify.rs, simplify_stringbuilder.rs | 75% | StringBuilder chains converting |

#### Regions IR (9 passes)

| JADX Pass | Lines | Dexterity File | Status | Issue |
|-----------|-------|----------------|--------|-------|
| RegionMakerVisitor | 890 | region_builder.rs | **BROKEN** | If/else structure |
| IfRegionVisitor | 356 | if_region_visitor.rs | **BROKEN** | Empty branches |
| SwitchOverStringVisitor | 267 | switch_over_string.rs | DONE | |
| ReturnVisitor | 169 | return_visitor.rs | PARTIAL | Else-return |
| CleanRegions | 145 | clean_regions.rs | DONE | |
| MethodThrowsVisitor | 89 | method_throws_visitor.rs | DONE | |
| MethodInvokeVisitor | 441 | method_invoke.rs | DONE | |
| CheckRegions | 234 | check_regions.rs | DONE | |
| ProcessTryCatchRegions | 312 | process_try_catch_regions.rs | DONE | |
| TernaryMod | 352 | ternary_mod.rs | **BROKEN** | instanceof pattern |
| LoopRegionVisitor | 457 | loop_analysis.rs | **DONE** | GAP-02 FIXED Dec 24 - iterator_for_each pattern detection |

#### Class Processing (7 passes)

| JADX Pass | Lines | Dexterity File | Status | Issue |
|-----------|-------|----------------|--------|-------|
| EnumVisitor | 645 | enum_visitor.rs | DONE | |
| FixSwitchOverEnum | 234 | fix_switch_over_enum.rs | DONE | |
| NonFinalResIdsVisitor | 119 | - | MISSING | Gradle |
| ExtractFieldInit | 280 | extract_field_init.rs | **BROKEN** | Static init |
| FixAccessModifiers | 122 | fix_access_modifiers.rs | DONE | |
| ClassModifier | 389 | class_modifier.rs | DONE | |

#### Variable & Final (4 passes)

| JADX Pass | Lines | Dexterity File | Status |
|-----------|-------|----------------|--------|
| SwitchBreakVisitor | 178 | switch_break_visitor.rs | DONE |
| ProcessVariables | 312 | process_variables.rs | PARTIAL |
| ApplyVariableNames | 300 | apply_variable_names.rs | PARTIAL |
| PrepareForCodeGen | 234 | prepare_for_codegen.rs | DONE |

---

## P0 Clone Task List (Priority Order)

### TASK-1: TernaryMod instanceof Pattern
**Priority:** P0 (produces empty if/else blocks)
**JADX Source:** `TernaryMod.java` (352 lines)
**Key Methods:**
- `makeTernaryInsn()` lines 67-135
- `getTernaryInsnBlock()` lines 195-209
- `processOneBranchTernary()` lines 266-277
- `replaceWithTernary()` lines 280-348

**Implementation Notes:**
```java
// JADX TernaryMod.java:97-135 - The core ternary detection
RegisterArg thenResArg = thenInsn.getResult();
RegisterArg elseResArg = elseInsn.getResult();
if (thenResArg != null && elseResArg != null) {
    PhiInsn thenPhi = thenResArg.getSVar().getOnlyOneUseInPhi();
    PhiInsn elsePhi = elseResArg.getSVar().getOnlyOneUseInPhi();
    if (thenPhi == null || thenPhi != elsePhi) {
        return false;  // Must merge to same PHI
    }
    // ... create ternary
}
```

### TASK-3: Array Parameter Preservation
**Priority:** P0 (wrong method signatures)
**JADX Source:** `ReplaceNewArray.java` (234 lines) + codegen
**Key Issue:** When emitting `invoke` with array arg, preserve `new T[]{...}` form

### TASK-5: Iterator For-Each Method Resolver
**Priority:** P0 (broken for-each loops)
**JADX Source:** `LoopRegionVisitor.java:246-405`
**Fix Required:**
1. Add method resolver parameter to `analyze_loop_patterns_with_iterables()`
2. In `is_has_next_call()`, check method signature: `hasNext()Z`
3. In `is_iterator_call()`, check signature: `iterator()Ljava/util/Iterator;`
4. In `is_next_call()`, check signature: `next()Ljava/lang/Object;`

---

## P1 Clone Task List

### TASK-GAP1: StringBuilder Chain Conversion
**JADX Source:** `SimplifyVisitor.java:300-428`
**Dexterity:** `simplify_stringbuilder.rs` - exists but incomplete
**Key Methods:**
- `convertInvoke()` lines 305-323
- `collectUseChain()` lines 325-367
- `convertStringBuilderChain()` lines 369-428

### TASK-GAP3: Else-Return Elimination
**JADX Source:** `ReturnVisitor.java:87-130`
**Dexterity:** `return_visitor.rs` - missing this transformation

---

## Clone Guidelines

When cloning JADX passes:

1. **Add Reference Comments**
   ```rust
   //! JADX Clone: jadx-core/.../SomeVisitor.java (NNN lines)
   //! Original Author: Skylot
   //! Clone Date: Dec 2025
   //!
   //! JADX Reference: Lines XXX-YYY
   ```

2. **Match JADX Line References**
   ```rust
   // JADX Reference: SomeVisitor.java:123-145
   fn some_function(...) { ... }
   ```

3. **Preserve JADX Logic Exactly**
   - Don't "improve" JADX's logic
   - Edge cases are intentional
   - If something looks wrong, it probably handles a real-world case

4. **Test Against Same APKs**
   - Use output/jadx_* vs output/dex_* comparisons
   - Output should be identical for non-cosmetic differences

---

## Test Verification

```bash
# Build dexterity
cd /mnt/nvme4tb/dexterity && cargo build --release

# Compare outputs
diff -u output/jadx_badboy/sources/com/prototype/badboy/MaliciousPatterns.java \
       output/dex_badboy/sources/com/prototype/badboy/MaliciousPatterns.java

# Key file showing BUG-1, BUG-3:
# - Empty if/else at execCommand1/2/3 methods
# - Wrong exec() signature

# Count total differences
diff -r output/jadx_medium/sources output/dex_medium/sources | grep "^diff " | wc -l
```

---

## Summary

**Real-World Parity: ~78%** (Updated Dec 24, 2025)

The clone work is ~90% done structurally. The remaining issues are:
- 4 missing passes (~10% structural)
- 4 critical bugs in existing passes (~22% quality impact) - 2 FIXED Dec 24

**Priority:** Fix BUGS in existing passes (P0) > Add missing features (P1-P2)

| Task | Bug | Status | Effort |
|------|-----|--------|--------|
| TASK-1 | BUG-1 Empty If/Else | TODO | Medium |
| TASK-3 | BUG-3 Wrong Method Sig | **FIXED** Dec 24 | - |
| TASK-5 | BUG-5 Iterator For-Each (GAP-02) | **FIXED** Dec 24 | - |
| GAP-01 | SSA->CodeVar mapping | **FIXED** Dec 24 | - |
| GAP-1 | StringBuilder | TODO | Medium |
| GAP-3 | Else-Return | TODO | Low |
