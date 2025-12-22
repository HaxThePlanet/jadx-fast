# Roadmap

**Status:** 0 P0, 1 P1 (S10 open), 0 P2 | IR 100% | Kotlin 100% | Type Inference ~85% | P1-S02 enhanced, P1-S05 fixed, P2 all fixed (Dec 22, 2025)
**See:** [QUALITY_STATUS.md](QUALITY_STATUS.md) for grades | [ISSUE_TRACKER.md](ISSUE_TRACKER.md) for issues

---

## Open Work

### P3 Polish

All P3 polish items completed.

### Performance TODOs

See [PERFORMANCE.md](PERFORMANCE.md#implementation-status) for P0-3/P1-2 open items.

### Future Features

- APKS (App Bundle split) input format
- Memory reduction, startup optimization

---

## Completed

### Type Inference: ~85% JADX Parity (Dec 22, 2025)

Type inference enhanced from ~60% to ~85% JADX parity. Dexterity now implements the core functionality of JADX's 26 type inference files in 7 focused Rust modules (~7,100 lines total).

| Component | Description | Status |
|-----------|-------------|--------|
| **TypeSearch** | Multi-variable constraint solving (Phase 2 fallback) | **COMPLETE** |
| **TypeBound** | Trait system with 5 implementations (Use, Assign, Compare, Cast, Super) | **COMPLETE** |
| **TypeUpdateEngine** | All 10 type update listeners implemented | **COMPLETE** |
| **TypeCompare** | Full generic/TypeVariable/Wildcard/OuterGeneric support | **COMPLETE** |
| **FixTypes** | 8 fallback strategies for unresolved types | **COMPLETE** |
| **FinishTypeInference** | Final validation pass | **COMPLETE** |

**Key Improvements:**
- **type_search.rs** - New module for multi-variable constraint solving when single-variable inference fails
- **TypeCompare** - Enhanced with TypeVariable and OuterGeneric handling for complex generic scenarios
- **TypeUpdateEngine** - All 10 TypeUpdate listeners from JADX ported (field access, method calls, array ops, etc.)
- **58 type-related tests passing** across all type inference modules

**Files:** `type_inference.rs`, `type_search.rs`, `type_bound.rs`, `type_update.rs`, `type_listener.rs`, `fix_types.rs`, `finish_type_inference.rs`

### P1-S02: Return Type Constraint Propagation Enhancement (Dec 22, 2025)

- **Return type constraint propagation** - Added `method_return_type` field to `TypeInference` struct
- **New builder method** - `with_method_return_type()` to set method's return type for constraint propagation
- **Return instruction handling** - Handle `Return { value: Some(arg) }` to add `UseBound(Boolean)` constraint when method returns boolean
- **New public APIs** - `infer_types_with_full_context()`, `infer_types_with_context_and_return_type()` (exported in lib.rs)
- **Ternary simplification enhancement** - Extended `simplify_ternary_to_boolean()` to accept target type parameter
- **Integer to boolean simplification** - Simplify `? 1 : 0` to condition and `? 0 : 1` to `!condition` when target type is Boolean
- **New helper function** - `negate_condition()` for double-negation elimination
- **Files changed:** `type_inference.rs`, `lib.rs`, `body_gen.rs`

### POL-002: Cosmetic Formatting - Static Member Class Prefix (Dec 22, 2025)

- **JADX parity for same-class static access** - Omit class prefix when accessing static fields/methods in same class
- **Added `get_static_method_prefix_in_class()`** - Helper to get empty/class prefix based on current class
- **Updated all static field/method access sites** - gen_expr_inline, StaticPut, FieldGet/FieldSet/MethodCall inline attrs
- **Example:** `Adjust.getDefaultInstance()` → `getDefaultInstance()` within Adjust class
- **Files changed:** `expr_gen.rs`, `body_gen.rs`

### P1-S05: Ternary Detection JADX Parity (Dec 22, 2025) - FIXED

- **Ported JADX's `removeInsns()` to Dexterity** - Removes GOTO/NOP from blocks after splitting (mirrors JADX's `BlockSplitter.removeInsns()`)
- **Simplified ternary detection** - Now uses `block.instructions.len() == 1` to match JADX's `getTernaryInsnBlock()` exactly
- **Removed `get_meaningful_instructions()`** - No longer needed with cleaned blocks
- **All 16 ternary tests pass** including `nested_ternary_in_comparison_test`, `chained_ternary_test`, `ternary_in_arithmetic_test`
- **Files changed:** `block_split.rs`, `ternary_mod.rs`

### P0-C08: Invalid instanceof Syntax Fix (Dec 21, 2025)

- **Fixed `instanceof X == null` pattern** - instanceof results incorrectly classified as object types
- **Fixed `!x instanceof X` pattern** - negation not properly parenthesized
- **Added `is_instanceof` detection** - expressions containing ` instanceof ` now treated as boolean
- **Updated `wrap_if_complex()`** - wraps instanceof expressions before applying negation
- **Results:** All tests pass, no more invalid instanceof syntax in decompiled output
- **Files changed:** `body_gen.rs`

### P1-S06 + P1-S12: Try-Catch Block Fix (Dec 21, 2025)

- **Block ID vs offset mismatch fixed** - `detect_try_catch_regions()` now uses `block.start_offset` instead of `block_id` for try block range matching
- **Handler address mapping** - Added `addr_to_block` map to convert handler addresses to block IDs
- **New function `split_blocks_with_handlers()`** - Handler addresses are now block leaders for correct block boundaries
- **Decompiler integration** - `decompiler.rs` now passes handler addresses to block splitting
- **Stack overflow prevention** - Added `recursion_depth` limit (100) in `RegionBuilder` and `region_depth` limit (100) in `BodyGenContext`
- **Results:** All tests pass, large APK completes in 6.5s with 0 errors
- **Files changed:** `region_builder.rs`, `block_split.rs`, `lib.rs`, `decompiler.rs`, `body_gen.rs`

### Resources 1:1 JADX Parity (Dec 21, 2025)

- **Complete parity achieved:** 103 directories, 152 files, zero differences with JADX
- **Gravity flag decoding:** Added `decode_gravity_flags()` in axml.rs to decompose compound values (`0x800013` to `start|center_vertical`)
- **Resource name suffix fix:** Fixed duplicate detection in arsc.rs - only adds `_res_0x{id}` suffix for actual name collisions
- **Version qualifier stripping:** Updated `normalize_config_qualifier()` to strip standalone version qualifiers from binary XML paths
- **xmlns attribute order:** Sort namespace declarations to put `android` first for JADX compatibility
- **tileMode enum:** Added tileMode enum decoding (`1` to `repeat`)
- **Files changed:** `axml.rs`, `arsc.rs`, `main.rs`

### P1-S09: For-Each Over Iterator Fix (Dec 21, 2025)

- **Illegal syntax eliminated** - `for (x : iterator)` is invalid Java, now correctly handled
- Added `find_iterator_source_collection()` to trace from iterator register to collection
- Finds `.iterator()` call and extracts the collection receiver
- Falls back to `while (it.hasNext())` when collection cannot be determined
- All 60 loop tests pass
- **Files changed:** `body_gen.rs`

### P1-S11: Throws Declaration Fix (Dec 21, 2025)

- **Throws parity improved from ~13.7% to 41.7%** (3x improvement)
- Parse `dalvik/annotation/Throws` from DEX annotations
- Added `get_throws_from_annotations()` to extract exception types
- `collect_throws_from_instructions()` scans for known library method throws
- Checked exceptions filtered against caught types
- All 1,217 tests pass
- **Files changed:** `method_gen.rs`

### Output Refresh (Dec 21, 2025)

- **All 5 APK samples refreshed:** small, medium, large, badboy, badboy-x86
- **Total Java files:** ~8,858 files
- **Debug opcode fix verified:** DBG_SET_FILE working correctly in decompiled output
- **Config qualifier fix verified:** BCP-47 locale tags in resource directories
- **Output location consolidated:** `output/dexterity/`
- **Root-level directories cleaned up:** Removed old extraction directories

### DEX Debug Opcodes + Resource Qualifiers (Dec 21, 2025)

- **DBG_SET_FILE (0x09) fix:** Now properly reads uleb128 argument for JADX parity
- **BCP-47 locale tag formatting (RES-001):** Proper `b+language+script+region+variant` format
  - **Validation Status:** COMPLETE AND WORKING
  - **Fix Location:** `crates/dexterity-resources/src/arsc.rs:205-274`
  - **Unit Tests:** 5/5 passing (old-style, BCP-47 script, BCP-47 variant, default, density)
  - **JADX Comparison:** Identical output verified
- **locale_variant field support:** Handles POSIX and other variants
- **Old-style vs BCP-47 detection:** Distinguishes `pt-rBR` from `b+sr+Latn` formats
- **Files changed:** `code_item.rs`, `arsc.rs`

### Phase 3: CMP Instruction Inlining Fix (Dec 21, 2025)

- **CMP inlining fixed in simplify.rs** - CMP instructions now properly inlined into If/Ternary conditions
- **Bug fix:** CMP instructions were incorrectly marked as dead when they had multiple uses
- **Solution:** Now counts ALL uses of CMP results before marking dead
- **Only marks CMP as dead if ALL uses are IF/Ternary with compare-to-zero**
- **Added ternary support for CMP unwrapping** - `cmp_l(a, b) == 0` patterns in ternary conditions
- **P2-Q05 fix:** Unused Compare variable declarations (e.g., `int compare = ...;`) eliminated
- **SimplifyResult.dead_cmp_count:** New field tracks CMP instructions marked for removal
- **DontGenerate flag:** Compare instructions whose results are inlined get marked
- **Files changed:** `simplify.rs`

### Phase 2: Boolean Expression Simplification (Dec 21, 2025)

- **Short-circuit OR condition merging:** Combined nested if conditions into `a || b` patterns
- **Barrier parameter for collect_branch_blocks:** Prevents including other branch's target in branch blocks
- **OR type 2 detection:** Short-circuit OR where both conditions branch to same "true" target
- **Fixed region building for merged OR conditions:** Correct then/else block assignment for OR patterns
- **Files changed:** `conditionals.rs`, `region_builder.rs`

### Phase 1: Static Field Inline Initialization (Dec 21, 2025)

- **NewInstance variant added to FieldValue:** Supports `new ClassName()` pattern for Kotlin object INSTANCE fields
- **extract_field_init.rs extended:** Detects `new-instance` + `invoke-direct <init>` pattern before `sput-object`
- **Empty clinit suppression:** Skips generating `static {}` blocks that only contain `return-void`
- **class_gen.rs NewInstance rendering:** Renders `new ClassName()` for static field initializers
- **Files changed:** `info.rs`, `extract_field_init.rs`, `class_gen.rs`, `method_gen.rs`

### Variable Naming Improvements (Dec 21, 2025)

- **OBJ_ALIAS exact matching:** Changed from contains() to exact FQN matching (e.g., "java.lang.String" => "str")
- **GOOD_VAR_NAMES set:** 13 mappings (JADX has 5): size, length, list, map, next, prev, current, key, value, entries, keys, values
- **toString() handling:** Returns declaring class name (e.g., Pattern.toString() -> "pattern")
- **Type+method fallback:** make_type_method_name() (e.g., Pattern.compile() -> "patternCompile")

### Control Flow Fixes (Dec 21, 2025)

- **Empty Else Elimination:** Enhanced is_empty_region_with_ctx() recursive checks for all region types
- **Unreachable Code:** emitted_exit tracking in generate_block() skips instructions after return/throw

### Kotlin Package Deobfuscation (Dec 21, 2025)

- **dex_info.rs:** get_aliased_class_name() applies both class and package aliases
- **deobf.rs:** extract_and_register_package_alias() extracts mappings from Kotlin metadata

### Dexterity Branding (Dec 21, 2025)

- Changed all warning comments from "JADX" to "Dexterity" (type_gen.rs, body_gen.rs, class_gen.rs)
- Output now shows: `/* Dexterity WARNING: ... */`, `/* Dexterity WARN: ... */`, `/* Dexterity INFO: ... */`

### Kotlin Metadata (Dec 20-21, 2025) - 100% JADX Parity

- BitEncoding decoder (UTF-8 + 8-to-7 modes)
- StringTableTypes for d2 string resolution
- 68 predefined Kotlin strings
- All function modifiers: suspend/inline/infix/operator/tailrec
- Extension function receiver_type
- Type variance (`<in T>`, `<out T>`)
- Data/sealed/value class detection

### Bug Fixes (Dec 21, 2025)

- **P0 (6):** Static final init, undefined vars, throw validation, type confusion, enum values, dead code
- **P1 (5):** Synchronized blocks, imports, boolean comparisons, param/field, constructor result

See [ISSUE_TRACKER.md](ISSUE_TRACKER.md#fixed-issues-dec-21-2025) for details.
