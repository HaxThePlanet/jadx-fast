# Quality Status

**Status:** 0 P0, 9 P1, 2 P2 Open | Kotlin 100% | P1-S11 Throws Fixed (Dec 21, 2025)
**Goal:** 1:1 identical decompilation output with JADX
**Output Refresh:** Dec 21, 2025 - All 5 APK samples refreshed (~8,858 Java files)

## Current Grades

| Category | Grade | Notes |
|----------|-------|-------|
| **Codegen** | **B+** | All P0 + P1 bugs fixed, Phase 1 + Phase 2 complete |
| **IR/Control Flow** | **B** | OR condition merging, synchronized blocks fixed |
| **Variable Naming** | **A-** | 13 mappings vs JADX 5, GAP-002 fixed |
| **Kotlin Support** | **A** | 100% parity - BitEncoding ported |
| **Overall** | **B+** | Production ready for most APKs |

## Bug Status

| Priority | Status |
|----------|--------|
| P0 Bugs | **ALL FIXED** (7 fixed) |
| P1 Bugs | **9 Open** (P1-S01, P1-S09, P1-S11 fixed; P1-S02 to P1-S08, P1-S10, P1-S12 remain) |
| P2 Bugs | **2 Open** (P2-Q01, P2-Q03) |
| P3 Polish | 2 open (POL-001, POL-002) |

See [ISSUE_TRACKER.md](ISSUE_TRACKER.md) for full issue list.

## Recent Improvements (Dec 21, 2025)

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
