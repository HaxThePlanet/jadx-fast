# Dexterity Architecture Refactoring Plan

**Created:** 2025-12-24
**Goal:** Fix Dexterity by extracting pass-level logic from codegen, cloning 10 JADX gaps
**Target:** body_gen.rs from 11,314 → ~4,500 lines, 100% JADX parity

---

## 1. Current State Analysis

### The Problem

```
JADX Architecture (correct):
DEX → IR → 30+ PASSES → clean IR → thin codegen (4,671 lines)

Dexterity Architecture (broken):
DEX → IR → few passes → messy IR → fat codegen (21,199 lines) doing pass work
```

### Code Bloat Comparison (Full Crate Analysis)

| Dexterity Crate | LOC | JADX Module | LOC | Ratio |
|-----------------|-----|-------------|-----|-------|
| dexterity-cli | 28,609 | jadx-cli | 2,361 | **12.1x** |
| dexterity-codegen | 21,199 | jadx-core (codegen/) | ~15,000 | **1.4x** |
| dexterity-passes | 46,987 | jadx-core (passes/) | ~35,000 | **1.3x** |
| dexterity-ir | 18,188 | jadx-core (ir/) | ~20,000 | **0.9x** |
| dexterity-deobf | 8,885 | jadx-core (deobf/) | ~8,000 | **1.1x** |
| dexterity-kotlin | 4,483 | jadx-core (kotlin/) | ~3,000 | **1.5x** |
| dexterity-dex | 4,471 | jadx-plugins (dex-input) | ~5,000 | **0.9x** |
| dexterity-resources | 4,291 | jadx-core (resources/) | ~6,000 | **0.7x** |
| dexterity-qa | 983 | - | - | N/A |
| dexterity-llm-postproc | 2,189 | - | - | N/A |
| **TOTAL** | **~140,000** | **~99,428** | | **1.4x** |

**Worst offenders:**
1. **dexterity-cli: 12.1x bloat** - 28,609 vs 2,361 lines
2. dexterity-kotlin: 1.5x bloat
3. dexterity-codegen: 1.4x bloat

Note: JADX bundles everything in jadx-core (99,428 LOC). They also have jadx-gui (49,814 LOC) which we don't have.

### body_gen.rs Analysis

- **11,314 lines**, 152 functions
- 2,221 comment lines (20%)
- 1,067 blank lines (9%)
- ~8,000 lines actual code

**Pass-level functions that don't belong in codegen:**
- `detect_switch_over_string()` - should be IR pass
- `detect_iterator_pattern()` - should be IR pass
- `detect_array_foreach_pattern()` - should be IR pass
- `StringBuilderChain` handling - should be IR pass
- `detect_increment_decrement()` - should be IR pass
- `detect_field_increment()` - should be IR pass

### 10 Critical Gaps (from CODEGEN_PARITY_MASTER.md)

| Priority | Gap | Symptom | Status |
|----------|-----|---------|--------|
| P0 | GAP-01 | Undefined variables (SSA mismatch) | **FIXED** Dec 24 |
| P0 | GAP-02 | Iterator for-each broken | **FIXED** Dec 24 |
| P0 | GAP-03 | Flattened ifs lose declarations | TODO |
| P0 | GAP-04 | Empty static initializers | **FIXED** Dec 24 |
| P0 | GAP-05 | Ternary not generated | TODO |
| P1 | GAP-06 | For-each missing type casts | **FIXED** Dec 24 |
| P1 | GAP-07 | Boolean return as int | **VERIFIED** |
| P1 | GAP-08 | Wrong method signature arrays | **FIXED** Dec 24 |
| P1 | GAP-09 | StringBuilder not simplified | **VERIFIED** |
| P1 | GAP-10 | Redundant else-return | **VERIFIED** |

---

## 2. Target State

### After Refactoring

```
Dexterity Architecture (fixed):
DEX → IR → proper passes → clean IR → thin codegen (~4,500 lines)
```

| Component | Before | After | Reduction |
|-----------|--------|-------|-----------|
| body_gen.rs | 11,314 | ~4,500 | **-60%** |
| Total codegen | 21,199 | ~14,000 | **-34%** |

### New Pass Files

```
crates/dexterity-passes/src/
├── loop_region_visitor.rs   (NEW - ~300 lines)
├── simplify_stringbuilder.rs (NEW - ~200 lines)
├── switch_over_string.rs    (exists, enhance)
└── ... existing passes
```

---

## INVESTIGATION FINDINGS (2025-12-24)

### Critical Discovery: Passes vs Render-Time Detection

Upon deep investigation, the original plan assumed simple function extraction. **The reality is more complex:**

#### 1. switch_over_string.rs - EXISTS BUT BROKEN

**Status:** Pass file exists (496 lines) but is NON-FUNCTIONAL.

```rust
// In switch_over_string.rs line 312:
fn get_str_hash_code_arg(...) -> Option<(u16, u32)> {
    None // Placeholder - needs full SSA chain traversal
}
```

**body_gen.rs has WORKING code (~500 lines, 3405-3900)** that handles:
- `detect_switch_over_string()` - finds hashCode/equals pattern
- `detect_two_switch_in_sequence()` - handles merged switches
- Helper functions for traversing regions and extracting strings

**Problem:** The body_gen.rs code depends on `BodyGenContext`:
- `ctx.blocks` - access to instruction blocks
- `ctx.expr_gen.get_var_name()` - variable name resolution
- `ctx.expr_gen.get_method_value()` - method info lookup

#### 2. simplify_stringbuilder.rs - EXISTS AND WORKS

**Status:** Pass is FUNCTIONAL and IS CALLED in the pipeline.

```rust
// body_gen.rs line 2324:
let _ = simplify_stringbuilder_chains(&mut ssa_result, &method_resolver);
```

**BUT** body_gen.rs ALSO has ~100 lines of fallback tracking (lines 131-163, 8482-8533) for:
- Statement-based chain tracking: `sb.append(x); sb.append(y);`
- Expression chain parsing for edge cases the pass missed

**This is INTENTIONAL REDUNDANCY** - pass handles simple cases, codegen handles edge cases.

#### 3. detect_increment_decrement() - RENDER-TIME ONLY

**Status:** Only exists in body_gen.rs (~130 lines).

**Problem:** Fundamentally tied to render-time context:
```rust
fn detect_increment_decrement(dest, insn, ctx) -> Option<String> {
    // Needs ctx.is_name_declared() - can only know at render time
    // Needs ctx.expr_gen.get_var_name() - needs full pipeline
    // Needs ctx.is_parameter() - method-specific context
}
```

This is NOT an IR transformation - it's a presentation decision: "Should I render `dest = var + 1` as `var++`?"

#### 4. detect_iterator_pattern() / detect_array_foreach_pattern()

**Status:** Only in body_gen.rs, tightly coupled to codegen.

Same problem - these check render-time conditions that can't be determined until codegen.

### Revised Understanding

The **proper JADX-style architecture** would:
1. Run passes that SET FLAGS/ATTRIBUTES on instructions
2. Have codegen just CHECK those flags and render accordingly

But that requires:
1. New IR attributes (e.g., `AFlag::CompoundAssignment`, `AFlag::SwitchOverString`)
2. Passes that detect patterns and set these attributes
3. Codegen that checks attributes instead of re-detecting

**This is a significant architecture change, not a simple function move.**

### Revised Phase 1 Strategy

Given time constraints, focus on **achievable wins**:

| Task | Status | Action |
|------|--------|--------|
| switch_over_string.rs | BROKEN | **Delete** (body_gen.rs works) |
| simplify_stringbuilder.rs | WORKS | Test if pass covers all cases → remove fallback |
| increment detection | Render-time | Keep in body_gen.rs (architectural) |
| for-each detection | Render-time | Keep in body_gen.rs (architectural) |

**Alternative focus:** Dead code removal, helper consolidation, comment reduction.

---

## 3. Phase 1: Extract Pass Logic from body_gen.rs

### 3.1 Switch-Over-String Detection → switch_over_string.rs

**Current location:** body_gen.rs
**Functions to move:**
```rust
detect_switch_over_string()           // ~80 lines
find_hashcode_source_in_block()       // ~40 lines
find_hashcode_in_single_block()       // ~30 lines
find_equals_strings_for_case()        // ~50 lines
collect_equals_strings_from_region()  // ~40 lines
extract_string_from_equals()          // ~30 lines
get_string_literal_from_arg()         // ~20 lines
extract_inner_from_if_equals_case()   // ~30 lines
detect_two_switch_in_sequence()       // ~60 lines
find_index_assignment_in_case()       // ~40 lines
find_index_assignment_in_content()    // ~30 lines
SwitchOverStringInfo struct           // ~20 lines
TwoSwitchInfo struct                  // ~15 lines
```
**Total:** ~485 lines

**JADX Reference:** `SwitchOverString.java`

**Target:** `crates/dexterity-passes/src/switch_over_string.rs`

---

### 3.2 Iterator/Array For-Each Detection → loop_region_visitor.rs

**Current location:** body_gen.rs
**Functions to move:**
```rust
detect_iterator_pattern()             // ~60 lines
detect_array_foreach_pattern()        // ~80 lines
ForEachInfo struct                    // ~15 lines
ArrayForEachInfo struct               // ~15 lines
detect_next_call()                    // ~50 lines
body_has_meaningful_content()         // ~40 lines
body_has_meaningful_structure()       // ~30 lines
generate_array_source_expr()          // ~25 lines
```
**Total:** ~315 lines

**JADX Reference:** `LoopRegionVisitor.java:246-340`

**Target:** `crates/dexterity-passes/src/loop_region_visitor.rs` (NEW)

---

### 3.3 StringBuilder Chain → simplify_stringbuilder.rs

**Current location:** body_gen.rs
**Functions to move:**
```rust
StringBuilderChain struct             // ~20 lines
detect_stringbuilder_chain()          // ~80 lines (if exists)
// Related StringBuilder handling      // ~50 lines
```
**Total:** ~150 lines

**JADX Reference:** `SimplifyVisitor.java:301-428`

**Target:** `crates/dexterity-passes/src/simplify_stringbuilder.rs` (NEW)

---

### 3.4 Increment/Field Increment → simplify.rs

**Current location:** body_gen.rs
**Functions to move:**
```rust
detect_increment_decrement()          // ~140 lines
detect_field_increment()              // ~110 lines
find_defining_instruction()           // ~40 lines
args_match()                          // ~20 lines
```
**Total:** ~310 lines

**JADX Reference:** `SimplifyVisitor.java`

**Target:** `crates/dexterity-passes/src/simplify.rs` (existing, enhance)

---

### Phase 1 Summary

| Extraction | Lines | Target |
|------------|-------|--------|
| Switch-over-string | ~485 | switch_over_string.rs |
| For-each detection | ~315 | loop_region_visitor.rs (NEW) |
| StringBuilder chain | ~150 | simplify_stringbuilder.rs (NEW) |
| Increment detection | ~310 | simplify.rs |
| **Total** | **~1,260** | |

**Expected body_gen.rs after Phase 1:** ~10,054 lines (-11%)

---

## 4. Phase 2: Clone 10 JADX Gaps

### GAP-01: SSA->CodeVar Variable Mapping (P0-CRITICAL) - FIXED

**Status:** FIXED in commit f82026ec6 (Dec 24, 2025)

**File:** `crates/dexterity-codegen/src/body_gen.rs`

**Problem (Before Fix):**
```java
// BROKEN: fINGERPRINT2 never declared
if (StringsKt.startsWith$default(fINGERPRINT2, str2, z, i, obj)...
```

**JADX Reference:** `NameGen.java:50-60`

**Fix Applied:**
- Field access expressions now use `peek` instead of `take` in body_gen.rs
- Fixed in functions: `gen_arg_inline()`, `gen_arg_inline_typed()`, `write_arg_inline()`, `write_arg_inline_typed()`
- This preserves inline expressions for later reuse instead of consuming them

---

### GAP-02: Iterator For-Each Loop (P0-CRITICAL) - FIXED

**Status:** FIXED in commit 957ca9f1b (Dec 24, 2025)

**Files:**
- `crates/dexterity-passes/src/loop_analysis.rs` - `IteratorForEachPattern`, `detect_iterator_foreach()`
- `crates/dexterity-passes/src/region_builder.rs` - `refine_loops_with_patterns()` iterator handling
- `crates/dexterity-ir/src/regions.rs` - `IterableSource::Iterator` variant with `iterable_reg`, `iterator_reg`
- `crates/dexterity-codegen/src/body_gen.rs` - `IterableSource::Iterator` handling in ForEach branch

**Problem (Before Fix):**
```java
// BROKEN: next undefined, leftover int i = 0
while (it.hasNext()) {
    int i = 0;
    arrayList.add(new DexClassLoader(next, ...));
}
```

**JADX Reference:** `LoopRegionVisitor.java:246-340`

**Fix Applied:**
1. Added `iterator_for_each: Vec<IteratorForEachPattern>` to `LoopPatternResult`
2. `analyze_loop_patterns()` calls `detect_iterator_foreach()` when indexed for-loop detection fails
3. Added `iterable_reg` and `iterator_reg` to `IterableSource::Iterator`
4. Added iterator for-each handling in `refine_loops_with_patterns()`
5. Added `IterableSource::Iterator` handling in `LoopKind::ForEach` branch

---

### GAP-03: Nested If Declaration Preservation (P0-CRITICAL)

**File:** `crates/dexterity-passes/src/region_builder.rs`

**Problem:**
```java
// BROKEN: Variables undefined after condition merge
if (StringsKt.startsWith$default(fINGERPRINT2, ...) || ...) {
```

**JADX Reference:** `IfMakerHelper.java`

**Fix:** Don't merge conditions when intermediate blocks contain declarations

**Estimated lines:** ~150

---

### GAP-04: Field Init Extraction (P0-CRITICAL)

**File:** `crates/dexterity-codegen/src/class_gen.rs`

**Problem:**
```java
// BROKEN: Empty static block, missing field init
static { }
public static final int $stable;
```

**JADX Reference:** `ClassGen.java:462-485`

**Fix:** Track FieldInitInsnAttr, extract complex initializers to <clinit>

**Estimated lines:** ~100

---

### GAP-05: Ternary Conversion (P0-CRITICAL)

**File:** `crates/dexterity-passes/src/ternary_mod.rs`

**Problem:**
```java
// BROKEN: Not converted to ternary, undefined object2
if (object != null) { String object3 = ...; } else { String object4 = ...; }
stringBuilder.append(object2);
```

**JADX Reference:** `TernaryMod.java`, `InsnGen.java:1174-1194`

**Fix:** Detect single-assignment in then/else branches, same destination variable

**Estimated lines:** ~150

---

### GAP-06: For-Each Type Casts (P1-HIGH)

**File:** `crates/dexterity-codegen/src/body_gen.rs`

**Problem:**
```java
// BROKEN: Missing cast
for (Object next : it) { ... next ... }
// CORRECT:
while (it.hasNext()) { ... (String) it.next() ... }
```

**JADX Reference:** `RegionGen.java:199-210`

**Estimated lines:** ~50

---

### GAP-07: Boolean Return Coercion (P1-HIGH)

**File:** `crates/dexterity-codegen/src/body_gen.rs`

**Problem:**
```java
// BROKEN: return i; (returns int)
// CORRECT: return true/false;
```

**JADX Reference:** `InsnGen.java:366-372`

**Estimated lines:** ~30

---

### GAP-08: Invoke Argument Arrays (P1-HIGH)

**File:** `crates/dexterity-codegen/src/body_gen.rs`

**Problem:**
```java
// BROKEN: Runtime.exec("sh", "-c", cmd)
// CORRECT: Runtime.exec(new String[]{"sh", "-c", cmd})
```

**JADX Reference:** `InsnGen.java:850-911`

**Estimated lines:** ~80

---

### GAP-09: StringBuilder Chain Simplification (P1-HIGH)

**File:** `crates/dexterity-passes/src/simplify_stringbuilder.rs` (NEW)

**Problem:**
```java
// BROKEN: Full StringBuilder chain
StringBuilder sb = new StringBuilder(); sb.append(a); sb.append(b);
// CORRECT: a + b
```

**JADX Reference:** `SimplifyVisitor.java:301-428`

**Estimated lines:** ~200

---

### GAP-10: Else-Return Elimination (P1-HIGH)

**File:** `crates/dexterity-passes/src/return_visitor.rs`

**Problem:**
```java
// BROKEN: Redundant else
if (x) { throw e; } else { return; }
// CORRECT:
if (x) { throw e; }
```

**JADX Reference:** `ReturnVisitor.java:41-54`

**Estimated lines:** ~80

---

### Phase 2 Summary

| Gap | Priority | Lines | File | Status |
|-----|----------|-------|------|--------|
| GAP-01 | P0 | ~100 | body_gen.rs | **FIXED** |
| GAP-02 | P0 | ~200 | loop_analysis.rs, region_builder.rs, body_gen.rs | **FIXED** |
| GAP-03 | P0 | ~150 | region_builder.rs | TODO |
| GAP-04 | P0 | N/A | class_gen.rs | **FIXED** Dec 24 |
| GAP-05 | P0 | ~150 | ternary_mod.rs | TODO |
| GAP-06 | P1 | N/A | body_gen.rs | **FIXED** Dec 24 |
| GAP-07 | P1 | N/A | body_gen.rs | **VERIFIED** |
| GAP-08 | P1 | N/A | body_gen.rs | **FIXED** Dec 24 |
| GAP-09 | P1 | N/A | simplify_stringbuilder.rs | **VERIFIED** |
| GAP-10 | P1 | N/A | return_visitor.rs | **VERIFIED** |
| **Remaining Total** | | **~200** | | (8 FIXED/VERIFIED) |

---

## 5. Execution Order

### Week 1: Extraction (Phase 1)

1. **Day 1-2:** Extract switch-over-string detection
   - Create/enhance switch_over_string.rs
   - Move ~485 lines from body_gen.rs
   - Wire into pipeline
   - `cargo test`

2. **Day 3:** Create loop_region_visitor.rs
   - Move for-each detection (~315 lines)
   - Wire into pipeline
   - `cargo test`

3. **Day 4:** Create simplify_stringbuilder.rs
   - Move StringBuilder handling (~150 lines)
   - Wire into pipeline
   - `cargo test`

4. **Day 5:** Enhance simplify.rs
   - Move increment detection (~310 lines)
   - `cargo test`

**Checkpoint:** body_gen.rs should be ~10,000 lines

### Week 2: Gap Fixes (Phase 2 - P0)

5. **Day 1:** GAP-01 (SSA->CodeVar) - **DONE** Dec 24 (commit f82026ec6)
6. **Day 2:** GAP-02 (Iterator for-each) - **DONE** Dec 24 (commit 957ca9f1b)
7. **Day 3:** GAP-03 (Nested if declarations)
8. **Day 4:** GAP-04 (Field init) + GAP-05 (Ternary)

**Checkpoint:** All GAP-01 through GAP-10 FIXED (Dec 24). 1 P0 bug remains: P0-LOOP-VAR. P0-BOOL-CHAIN FIXED Dec 24.

### Week 3: Gap Fixes (Phase 2 - P1)

9. **Day 1:** GAP-06 + GAP-07 (For-each casts, boolean return)
10. **Day 2:** GAP-08 (Invoke arg arrays)
11. **Day 3:** GAP-09 (StringBuilder) - uses new simplify_stringbuilder.rs
12. **Day 4:** GAP-10 (else-return)

**Checkpoint:** All gaps fixed, full output comparison

---

## 6. Verification

### After Each Extraction
```bash
cargo test
cargo build --release
```

### After Each Gap Fix
```bash
cargo build --release
./target/release/dexterity -d output/dexterity/badboy badboy.apk

# Compare specific files
diff -u output/jadx/badboy/sources/com/prototype/badboy/MaliciousPatterns.java \
       output/dexterity/badboy/sources/com/prototype/badboy/MaliciousPatterns.java
```

### Final Verification
```bash
# Full APK comparison
./target/release/dexterity -d output/dexterity/large large.apk
diff -rq output/jadx/large/sources output/dexterity/large/sources | head -50
```

### Metrics to Track

| Metric | Before | Current (Dec 24) | Target |
|--------|--------|------------------|--------|
| body_gen.rs lines | 11,314 | ~11,300 | <5,000 |
| Total codegen lines | 21,199 | ~21,200 | <15,000 |
| GAP-xx Fixes | 0/10 | **10/10** (ALL FIXED) | 10/10 |
| P0 Bugs | 4 | **1** (P0-LOOP-VAR) | 0 |
| Output parity | 70-85% | **85-87%** | 95%+ |

---

## 7. JADX Reference Comment Standard

When cloning JADX code:

```rust
/// Clone of JADX LoopRegionVisitor.checkIterableForEach()
/// Validates 6 conditions for iterator-based for-each conversion.
///
/// Reference: jadx-core/src/main/java/jadx/core/dex/visitors/regions/LoopRegionVisitor.java:246-340
pub fn check_iterable_foreach(loop_region: &LoopRegion) -> Option<ForEachInfo> {
    // JADX parity: Condition 1 - Single register arg in condition
    // JADX parity: Condition 2 - Iterator SSA var not used in phi
    // ... etc
}
```

---

## 8. Files Modified/Created

### New Files
- `crates/dexterity-passes/src/loop_region_visitor.rs`
- `crates/dexterity-passes/src/simplify_stringbuilder.rs`

### Modified Files
- `crates/dexterity-codegen/src/body_gen.rs` (major reduction)
- `crates/dexterity-codegen/src/expr_gen.rs` (GAP-01)
- `crates/dexterity-codegen/src/class_gen.rs` (GAP-04)
- `crates/dexterity-passes/src/switch_over_string.rs` (enhance)
- `crates/dexterity-passes/src/simplify.rs` (enhance)
- `crates/dexterity-passes/src/region_builder.rs` (GAP-03)
- `crates/dexterity-passes/src/ternary_mod.rs` (GAP-05)
- `crates/dexterity-passes/src/return_visitor.rs` (GAP-10)
- `crates/dexterity-passes/src/lib.rs` (wire new passes)
