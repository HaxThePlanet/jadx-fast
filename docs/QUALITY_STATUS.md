# Quality Status

**Status:** 0 P0, 7 P1, 2 P2 Open | Kotlin 100% | P1-S06 Try-Catch Fixed (Dec 21, 2025)
**Goal:** 1:1 identical decompilation output with JADX
**Output Refresh:** Dec 21, 2025 - All 5 APK samples refreshed (~8,858 Java files)
**Resources:** 1:1 JADX parity achieved (103 directories, 152 files, zero differences)

## Current Grades

| Category | Grade | Notes |
|----------|-------|-------|
| **Codegen** | **B+** | All P0 + P1 bugs fixed, Phase 1 + Phase 2 complete |
| **IR/Control Flow** | **B** | OR condition merging, synchronized blocks fixed |
| **Variable Naming** | **A-** | 13 mappings vs JADX 5, GAP-002 fixed |
| **Kotlin Support** | **A** | 100% parity - BitEncoding ported |
| **Resources** | **A+** | 1:1 JADX parity - 103 dirs, 152 files, zero diff |
| **Overall** | **B+** | Production ready for most APKs |

## Bug Status

| Priority | Status |
|----------|--------|
| P0 Bugs | **ALL FIXED** (7 fixed) |
| P1 Bugs | **7 Open** (P1-S01, P1-S06, P1-S09, P1-S11, P1-S12 fixed; P1-S02 to P1-S05, P1-S07, P1-S08, P1-S10 remain) |
| P2 Bugs | **2 Open** (P2-Q01, P2-Q03) |
| P3 Polish | 2 open (POL-001, POL-002) |

See [ISSUE_TRACKER.md](ISSUE_TRACKER.md) for full issue list.

## Recent Improvements (Dec 21, 2025)

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
| Total Tests | 1,217 passing (687 integration + 530 unit) |
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
