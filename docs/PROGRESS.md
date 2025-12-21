# Progress Tracking: Dexterity JADX Parity

**Status:** 0 P0, 9 P1, 2 P2 Open | Kotlin 100% | P1-S11 Throws Fixed (Dec 21, 2025)
**Tests:** 1,217 passing (687 integration + 530 unit)
**Benchmark:** 1.49x faster, 14.6x memory efficiency
**Output Refresh:** Dec 21, 2025 - All 5 APK samples (~8,858 Java files)

---

## Current Quality Grades

| Category | Grade | Notes |
|----------|-------|-------|
| **Codegen** | **B+** | All P0 + P1 bugs fixed, Phase 1 + Phase 2 complete |
| **IR/Control Flow** | **B** | OR condition merging, synchronized blocks fixed |
| **Variable Naming** | **A-** | 13 mappings (JADX has 5), GAP-002 fixed |
| **Kotlin Support** | **A** | 100% parity - BitEncoding ported |
| **Overall** | **B+** | Production ready for most APKs |

See [QUALITY_STATUS.md](QUALITY_STATUS.md) for details.

---

## Recent Work (Dec 21, 2025)

### P1-S11: Throws Declaration Fix
- **Throws parity improved from ~13.7% to 41.7%** (3x improvement)
- Parse `dalvik/annotation/Throws` from DEX annotations
- Added `get_throws_from_annotations()` to extract exception types
- `collect_throws_from_instructions()` scans for known library method throws
- Checked exceptions filtered against caught types in try-catch blocks
- **Files:** `method_gen.rs`

### Phase 3: Dead CMP Elimination
- **P2-Q05 fix:** Unused Compare variable declarations eliminated
- **SimplifyResult.dead_cmp_count:** New field tracks CMP instructions marked for removal
- **DontGenerate flag:** Compare instructions inlined into If conditions get marked
- **Files:** `simplify.rs`

### Phase 2: Boolean Expression Simplification
- **Short-circuit OR condition merging:** Combined nested if conditions into `a || b` patterns
- **Barrier parameter for collect_branch_blocks:** Prevents including other branch's target in branch blocks
- **OR type 2 detection:** Short-circuit OR where both conditions branch to same "true" target
- **Fixed region building for merged OR conditions:** Correct then/else block assignment
- **Files:** `conditionals.rs`, `region_builder.rs`

### Phase 1: Static Field Inline Initialization
- **NewInstance variant in FieldValue:** Supports `new ClassName()` pattern for Kotlin object INSTANCE
- **extract_field_init.rs extended:** Detects `new-instance` + `invoke-direct <init>` + `sput-object` pattern
- **Empty clinit suppression:** Skips generating `static {}` blocks with only `return-void`
- **Files:** `info.rs`, `extract_field_init.rs`, `class_gen.rs`, `method_gen.rs`

### Other Improvements
- **Variable Naming P0:** OBJ_ALIAS exact matching, GOOD_VAR_NAMES (13 total), toString() returns class name
- **Variable Naming P1:** make_type_method_name() fallback (e.g., Pattern.compile() -> "patternCompile")
- **Empty Else Elimination:** Enhanced is_empty_region_with_ctx() recursive checks
- **Unreachable Code:** emitted_exit tracking skips instructions after return/throw
- **Kotlin Package Deobf:** get_aliased_class_name() + extract_and_register_package_alias()
- **Dexterity Branding:** All warning comments now show "Dexterity" instead of "JADX"

See [ISSUE_TRACKER.md](ISSUE_TRACKER.md) for fixed bug details.

---

## Open Work

| ID | Issue | Priority |
|----|-------|----------|
| INV-001 | Zara APK hang | Investigation (blocked) |
| POL-001 | Library skip filters | P3 |
| POL-002 | Cosmetic formatting | P3 |

**Completed:** GAP-001 (Kotlin package deobf) and GAP-002 (variable naming) - see [ISSUE_TRACKER.md](ISSUE_TRACKER.md#fixed-issues-dec-21-2025).

---

## Quality Metrics

| Metric | Value |
|--------|-------|
| Integration Tests | 687/687 |
| Unit Tests | 530/530 |
| Throws Parity | 41.7% (up from ~13.7%) |
| Speed Advantage | 1.49x faster than JADX |
| Memory Efficiency | 14.6x better (574MB vs 8.4GB) |

---

## Testing

```bash
# All tests
cargo test

# Integration tests
cargo test --test integration_tests

# QA tool
./target/release/dexterity-qa --jadx-path /path/to/jadx --dexterity-path ./target/release/dexterity --apk-path app.apk
```

---

For issues, see [ISSUE_TRACKER.md](ISSUE_TRACKER.md).
For roadmap, see [ROADMAP.md](ROADMAP.md).
For known issues, see [KNOWN_ISSUES.md](KNOWN_ISSUES.md).
