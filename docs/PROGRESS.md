# Progress Tracking: Dexterity JADX Parity

**Status:** 0 P0, 1 P1 (S05 partial), 2 P2 Open | IR 100% | Kotlin 100% | P1-S04/S10 fixed (no repro), P1-S05 partial - block splitting issue (Dec 22, 2025)
**Tests:** 1,217 passing (687 integration + 530 unit)
**Benchmark:** 3.6-81x faster, 14.6x memory efficiency
**Resources:** 1:1 JADX parity (103 directories, 152 files, zero differences)
**Output Refresh:** Dec 21, 2025 - All 5 APK samples (~8,858 Java files)

---

## Current Quality Grades

| Category | Grade | Notes |
|----------|-------|-------|
| **IR Type System** | **A** | 100% parity - OuterGeneric, TypeVariable bounds, all 15 unknown variants |
| **IR SSA** | **A** | 100% parity - All utility methods (get_only_one_use_in_phi, reset_type_and_code_var, etc.) |
| **Codegen** | **B+** | All P0 + P1 bugs fixed, Phase 1 + Phase 2 complete |
| **Control Flow** | **B** | OR condition merging, synchronized blocks fixed |
| **Variable Naming** | **B** | 13 mappings, but JADX scores 0.93 vs Dexterity 0.70-0.81 on complex methods |
| **Kotlin Support** | **A** | 100% parity - BitEncoding ported |
| **Resources** | **A+** | 1:1 JADX parity - 103 dirs, 152 files, zero diff |
| **Overall** | **B+** | Production ready for most APKs |

See [QUALITY_STATUS.md](QUALITY_STATUS.md) for details.

---

## Recent Work (Dec 21, 2025)

### Dexterity-IR 100% Completion
- **Lazy Loading (info.rs):** Implemented actual lazy bytecode decoding with `lazy-loading` feature flag
- **RegionVisitor (regions.rs):** Added visitor pattern with pre/post hooks for clean tree traversal
- **PHI Simplification (ssa.rs):** Added `PhiNode`, `simplify_phis()` for trivial PHI elimination
- **Type Variable Bounds (class_hierarchy.rs):** `TypeVarMapping` now tracks bounds for `<T extends X>` generics
- **Kotlin Class Validation (kotlin_metadata.rs):** Added `ClassResolver` trait for existence checking
- **Tests:** 84 unit tests passing in dexterity-ir
- **Files:** `info.rs`, `regions.rs`, `ssa.rs`, `class_hierarchy.rs`, `kotlin_metadata.rs`, `lib.rs`, `Cargo.toml`

### IR Type System and SSA Parity Complete (Dec 21, 2025)
- **OuterGeneric variant (types.rs):** Nested class generics like `Outer<T>.Inner`
- **TypeVariable with bounds (types.rs):** `extend_types` for `T extends Number & Comparable`
- **All 15 unknown type variants (types.rs):** Added 8 missing variants for precise type inference
- **SSA utility methods (ssa.rs):** `get_only_one_use_in_phi()`, `reset_type_and_code_var()`, `update_used_in_phi_list()`
- **Type utility methods (types.rs):** `select_first()`, `visit_types()`, `get_array_dimension()`, `contains_type_variable()`, `contains_generic()`
- **Cleanup:** Removed duplicate `contains_type_variable()` from class_hierarchy.rs

### P1-S06 + P1-S12: Try-Catch Block Fix
- **Block ID vs offset mismatch fixed** - `detect_try_catch_regions()` now uses `block.start_offset` instead of `block_id`
- **Handler address mapping** - Added `addr_to_block` map to convert handler addresses to block IDs
- **New function `split_blocks_with_handlers()`** - Handler addresses are now block leaders for correct block boundaries
- **Stack overflow prevention** - Added `recursion_depth` limit (100) in `RegionBuilder` and `region_depth` limit (100) in `BodyGenContext`
- **Results:** All tests pass, large APK completes in 6.5s with 0 errors
- **Files:** `region_builder.rs`, `block_split.rs`, `lib.rs`, `decompiler.rs`, `body_gen.rs`

### Resources 1:1 JADX Parity Achieved
- **Complete parity:** 103 directories, 152 files, zero differences with JADX output
- **Gravity flag decoding:** `decode_gravity_flags()` in axml.rs decomposes compound values
- **Resource name suffix fix:** Only adds `_res_0x{id}` for actual name collisions, not config variants
- **Version qualifier stripping:** `normalize_config_qualifier()` strips standalone version qualifiers
- **xmlns attribute order:** Namespace declarations sorted with `android` first
- **tileMode enum:** Added tileMode enum decoding (`1` to `repeat`)
- **Files:** `axml.rs`, `arsc.rs`, `main.rs`

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
| ~~POL-002~~ | ~~Cosmetic formatting~~ | **FIXED** (static member class prefix) |

**Completed:** GAP-001 (Kotlin package deobf), GAP-002 (variable naming), POL-002 (static member class prefix) - see [ISSUE_TRACKER.md](ISSUE_TRACKER.md#fixed-issues-dec-21-2025).

---

## Quality Metrics

| Metric | Value |
|--------|-------|
| Integration Tests | 687/687 |
| Unit Tests | 530/530 |
| Resources Parity | **100% (1:1 JADX - 103 dirs, 152 files, zero diff)** |
| Throws Parity | 41.7% (up from ~13.7%) |
| Speed Advantage | 3.6-81x faster than JADX |
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
