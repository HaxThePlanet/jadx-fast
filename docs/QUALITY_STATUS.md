# Quality Status

**Status:** 2 P0, 3 P1, 0 P2 | Kotlin 100% | Type Inference ~90% JADX parity | **f.java audit FAILED** (Dec 22, 2025)
**Goal:** 1:1 identical decompilation output with JADX
**Output Refresh:** Dec 21, 2025 - All 5 APK samples refreshed (~8,858 Java files)
**Resources:** 1:1 JADX parity achieved (103 directories, 152 files, zero differences)

## f.java Comparison Audit (Dec 22, 2025)

**Result: NOT NEAR 1:1 PARITY**

| Metric | Count |
|--------|-------|
| Total f.java files in JADX | 151 |
| Identical | **7 (4.6%)** |
| Different | 130 (86.1%) |
| Missing (filtered by design) | 14 |

Critical bugs produce **non-compilable code** that also loses semantic meaning.

## Current Grades

| Category | Grade | Notes |
|----------|-------|-------|
| **Codegen** | **C+** | 2 P0 open (CFG01, CFG03); 3 P0 fixed Dec 22 (CFG02, CFG04, TYPE01) |
| **Type Inference** | **B+** | ~85% JADX parity (up from ~60%), 7 files / ~7,100 lines |
| **IR/Control Flow** | **C-** | CFG bugs: broken try-catch, missing branches; empty if-bodies fixed Dec 22 |
| **Variable Naming** | **B** | 13 mappings, but JADX scores 0.93 vs Dexterity 0.70-0.81 on complex methods |
| **Kotlin Support** | **A** | 100% parity - BitEncoding ported |
| **Resources** | **A+** | 1:1 JADX parity - 103 dirs, 152 files, zero diff |
| **Overall** | **C+** | Major CFG/codegen issues blocking production use |

## Bug Status

| Priority | Status |
|----------|--------|
| P0 Bugs | **2 OPEN** - CFG01, CFG03 from f.java audit (code won't compile); CFG02, CFG04, TYPE01 fixed Dec 22 |
| P1 Bugs | **3 OPEN** - CFG06-07, ENUM01 from f.java audit; CFG05 fixed Dec 22 |
| P2 Bugs | **ALL FIXED** (P2-Q01, P2-Q02, P2-Q03, P2-Q04, P2-Q05 fixed) |
| P3 Polish | **ALL DONE** - POL-001 by design (library filtering intentional), POL-002 fixed |

See [ISSUE_TRACKER.md](ISSUE_TRACKER.md) for full issue list.

## New Bugs from f.java Audit (Dec 22, 2025)

### P0 Critical (Code Won't Compile) - 3 bugs (3 fixed Dec 22)

| ID | Issue | Difficulty | Example File |
|----|-------|------------|--------------|
| **P0-CFG01** | Try-catch exception variable scope corruption | **HARD** | io/grpc/j1/f.java |
| ~~P0-CFG02~~ | ~~Empty if-body for early returns~~ | ~~MEDIUM~~ | **FIXED** Dec 22 |
| **P0-CFG03** | Undefined variables in complex expressions | **HARD** | net/time4j/f.java |
| ~~P0-TYPE01~~ | ~~Double literals as raw long bits~~ | ~~EASY~~ | **FIXED** Dec 22 |
| ~~P0-CFG04~~ | ~~Complex boolean expressions garbled~~ | ~~MEDIUM~~ | **FIXED** Dec 22 |

### P1 Semantic (Wrong Behavior) - 3 bugs (1 fixed Dec 22)

| ID | Issue | Difficulty | Example File |
|----|-------|------------|--------------|
| ~~P1-CFG05~~ | ~~Variables used outside exception scope~~ | ~~MEDIUM~~ | **FIXED** Dec 22 |
| **P1-CFG06** | Missing if-else branch bodies | **MEDIUM** | com/geetest/sdk/f.java |
| **P1-CFG07** | Switch case bodies with undefined variables | **HARD** | net/time4j/f.java |
| **P1-ENUM01** | Enum reconstruction failures | **MEDIUM** | net/time4j/f.java |

### Difficulty Legend

- **EASY**: Isolated fix, single module, clear root cause
- **MEDIUM**: Multiple modules, requires CFG understanding
- **HARD**: Deep SSA/CFG changes, may affect many passes

## Recent Improvements (Dec 22, 2025)

### P1-S02: Return Type Constraint Propagation Enhancement
- **Return type constraint propagation** - Added `method_return_type` field to `TypeInference` struct
- **New builder method** - `with_method_return_type()` to set method's return type
- **Return instruction handling** - Handle `Return { value: Some(arg) }` to add `UseBound(Boolean)` constraint
- **New public APIs** - `infer_types_with_full_context()`, `infer_types_with_context_and_return_type()`
- **Ternary simplification enhancement** - Extended `simplify_ternary_to_boolean()` to accept target type parameter
- **Integer to boolean simplification** - Simplify `? 1 : 0` to condition when target type is Boolean
- **New helper function** - `negate_condition()` for double-negation elimination
- **Files:** `type_inference.rs`, `lib.rs`, `body_gen.rs`

### P1-S05: Ternary Detection JADX Parity - FIXED
- **Ported JADX's `removeInsns()`** - Removes GOTO/NOP from blocks after splitting
- **Simplified ternary detection** - Now uses `block.instructions.len() == 1` matching JADX's `getTernaryInsnBlock()`
- **All 16 ternary tests pass** including `nested_ternary_in_comparison_test`
- **Files:** `block_split.rs`, `ternary_mod.rs`

### Type Inference: ~85% JADX Parity Achieved (Dec 22, 2025)

Type inference has been significantly enhanced from ~60% to ~85% JADX parity. Dexterity implements the core functionality of JADX's 26 type inference files in 7 focused Rust modules (~9,100 lines total).

**Components Completed:**

| Component | Description | Status |
|-----------|-------------|--------|
| **TypeSearch** | Multi-variable constraint solving (Phase 2 fallback) | **COMPLETE** |
| **TypeBound** | Trait system with 5 implementations (Use, Assign, Compare, Cast, Super) | **COMPLETE** |
| **TypeUpdateEngine** | All 10 type update listeners implemented | **COMPLETE** |
| **TypeCompare** | Full generic/TypeVariable/Wildcard/OuterGeneric support | **COMPLETE** |
| **FixTypes** | 8 fallback strategies for unresolved types | **COMPLETE** |
| **FinishTypeInference** | Final validation pass | **COMPLETE** |

**Key Features:**
- **type_search.rs** - New module for multi-variable constraint solving when single-variable inference fails
- **TypeCompare** - Enhanced with TypeVariable and OuterGeneric handling for complex generic scenarios
- **TypeUpdateEngine** - All 10 TypeUpdate listeners from JADX ported (field access, method calls, array ops, etc.)
- **58 type-related tests passing** across all type inference modules

**Files:** `type_inference.rs`, `type_search.rs`, `type_bound.rs`, `type_update.rs`, `type_listener.rs`, `fix_types.rs`, `finish_type_inference.rs`

## Previous Improvements (Dec 21, 2025)

### P1-S06 + P1-S12: Try-Catch Block Fix
- **Block ID vs offset mismatch fixed** - `detect_try_catch_regions()` now uses `block.start_offset` instead of `block_id`
- **Handler address mapping** - Added `addr_to_block` map to convert handler addresses to block IDs
- **New function `split_blocks_with_handlers()`** - Handler addresses are now block leaders
- **Stack overflow prevention** - Added `recursion_depth` limit (100) in `RegionBuilder` and `region_depth` limit (100) in `BodyGenContext`
- **Results:** All tests pass, large APK completes in 6.5s with 0 errors (previously caused stack overflow)
- **Files:** `region_builder.rs`, `block_split.rs`, `lib.rs`, `decompiler.rs`, `body_gen.rs`

### Resources 1:1 JADX Parity Achieved
- **Complete parity:** 103 directories, 152 files, zero differences with JADX output
- **Gravity flag decoding:** `decode_gravity_flags()` in axml.rs decomposes compound values (e.g., `0x800013` to `start|center_vertical`)
- **Resource name suffix fix:** Only adds `_res_0x{id}` suffix for actual name collisions, not config variants
- **Version qualifier stripping:** `normalize_config_qualifier()` strips standalone version qualifiers (`layout-v21` to `layout`)
- **xmlns attribute order:** Namespace declarations sorted with `android` first
- **tileMode enum:** Added enum decoding (`1` to `repeat`)

### P1-S11: Throws Declaration Fix
- **Throws parity improved from ~13.7% to 41.7%** (3x improvement)
- Parse `dalvik/annotation/Throws` from DEX annotations
- Added `get_throws_from_annotations()` to extract exception types from annotations
- `collect_throws_from_instructions()` scans for known exception-throwing library methods
- Checked exceptions filtered against caught types in try-catch blocks
- All 1,217 tests pass

### Output Refresh Completed
- All 5 APK samples refreshed: small, medium, large, badboy, badboy-x86
- Total Java files decompiled: ~8,858 files
- Output location consolidated: `output/dexterity/`
- Root-level extraction directories cleaned up

### Verified Fixes
- **Debug opcode fix (DBG_SET_FILE):** Verified in decompiled output
- **Config qualifier fix (BCP-47 locale tags):** Verified in resource directories

### Phase 2: Boolean Expression Simplification
- Short-circuit OR condition merging (`a || b` patterns)
- Barrier parameter for collect_branch_blocks
- OR type 2 detection for same-target branching
- Fixed region building for merged OR conditions

### Phase 1: Static Field Inline Initialization
- NewInstance variant in FieldValue for `new ClassName()` patterns
- Extended extract_field_init.rs for new-instance pattern detection
- Empty clinit suppression (skip `static {}` with only return-void)

## Quality Metrics

| Metric | Value |
|--------|-------|
| Total Tests | 1,254 passing (690 integration + 564 unit) |
| Type Inference Parity | **~90%** (up from ~85%, 7 files / ~9,100 lines, 58 type tests) |
| Throws Parity | 41.7% (up from ~13.7%, 3x improvement) |
| Kotlin Parity | 100% (BitEncoding ported, all modifiers work) |
| DEX Debug Info | 100% (DBG_SET_FILE uleb128 fix) |
| Resources Parity | **100% (1:1 JADX - 103 dirs, 152 files, zero diff)** |
| Resource Qualifiers | 100% (BCP-47 locale tags - **VALIDATED**) |
| Total Java Files | ~8,858 (across 5 APK samples) |

## Validated Fixes

### RES-001: BCP-47 Locale Format (Dec 21, 2025)

**Status:** COMPLETE AND WORKING

**Fix Location:** `crates/dexterity-resources/src/arsc.rs:205-274`

**Unit Test Results (5/5 passing):**
| Test | Description | Status |
|------|-------------|--------|
| `test_qualifier_string_old_style_locale` | Old-style locales: `pt-rBR`, `de` | PASS |
| `test_qualifier_string_bcp47_with_script` | BCP-47 with script: `b+sr+Latn`, `b+zh+Hans+CN` | PASS |
| `test_qualifier_string_bcp47_with_variant` | BCP-47 with variant: `b+en+POSIX` | PASS |
| `test_qualifier_string_default` | Default (empty) qualifier | PASS |
| `test_qualifier_string_with_density` | Combined qualifiers: `xhdpi`, `fr-hdpi` | PASS |

**JADX Output Comparison:**
- BCP-47 directories: `values-b+sr+Latn` - IDENTICAL
- Old-style locales: `values-pt-rBR`, `values-en-rAU` - IDENTICAL
- Density qualifiers: `values-hdpi`, `values-xhdpi` - IDENTICAL
- API level qualifiers: `values-v30`, `values-v21` - IDENTICAL
- Resource file contents: Serbian/Cyrillic text preserved - IDENTICAL

## Output Quality by APK Size

| APK | Files | Quality | Notes |
|-----|-------|---------|-------|
| Small (9.8KB) | 1 | **A** | Simple code works |
| Medium (10.3MB) | 2,890 | **B+** | Most issues resolved |
| Large (51.5MB) | 5,901 | **B** | Complex control flow handled with OR merging |
| Badboy | 53 | **B+** | Malware analysis ready |
| Badboy-x86 | 13 | **B-** | x86 architecture support |

---

For all issues, see [ISSUE_TRACKER.md](ISSUE_TRACKER.md).
For roadmap, see [ROADMAP.md](ROADMAP.md).
For QA reports, see [qa_reports/GRADE_SUMMARY.md](../qa_reports/GRADE_SUMMARY.md).
