# Roadmap

**Status:** 1 P0, 1 P1 open | IR 100% | Kotlin 100% | Type Inference ~90% | **SSA Clone Complete** (Dec 22, 2025)
**See:** [QUALITY_STATUS.md](QUALITY_STATUS.md) for grades | [ISSUE_TRACKER.md](ISSUE_TRACKER.md) for issues

---

## Open Work

### P0 Critical - Code Won't Compile (1 remaining)

| ID | Issue | Difficulty | Notes |
|----|-------|------------|-------|
| **P0-CFG03** | Undefined variables in expressions | **HARD** | PARTIAL FIX: compound assignment bug fixed Dec 22 |

### P1 Semantic - Wrong Behavior (1 remaining)

| ID | Issue | Difficulty | Notes |
|----|-------|------------|-------|
| **P1-CFG07** | Switch case bodies undefined vars | **HARD** | Complex SSA in switch |

### Performance TODOs

See [PERFORMANCE.md](PERFORMANCE.md#implementation-status) for P0-3/P1-2 open items.

### Future Features

- APKS (App Bundle split) input format
- Memory reduction, startup optimization

---

## Completed

### SSA System Clone - P0-CFG03 Fix Foundation (Dec 22, 2025)

Completed all 5 phases of cloning JADX's SSA system (~650 lines of new Rust code):

| Phase | File | Purpose | Lines |
|-------|------|---------|-------|
| 1 | `ssa.rs` | Connected SSAContext to SSA Transform | Enhanced |
| 2 | `init_code_vars.rs` | InitCodeVariables pass - links SSAVars to CodeVars | 306 |
| 3 | `process_variables.rs` | ProcessVariables pass - removes unused vars, finalizes CodeVars | 344 |
| 4 | `var_naming.rs` | Enhanced Variable Naming to use SSAContext | Enhanced |
| 5 | Integration | All 219 tests pass, release builds working | Verified |

**Key Accomplishments:**
- SSAContext now properly tracks SSAVars and their relationships
- CodeVars created from SSAVars with proper naming
- Unused variable elimination works correctly
- Variable naming uses SSA information for better names

---

### JADX Parity Passes - 8 New Passes (Dec 22, 2025)

Created ~2,430 lines of new Rust code implementing Tier 1-2 JADX passes:

| Pass | Purpose | Lines |
|------|---------|-------|
| `check_code.rs` | Instruction validation (register bounds, >255 args) | 447 |
| `check_regions.rs` | Region coverage validation (missing blocks, duplicates) | 379 |
| `usage_info.rs` | Usage graph for classes/methods/fields | 340 |
| `process_anonymous.rs` | Anonymous/lambda class detection for inlining | 445 |
| `post_process_regions.rs` | Loop condition merging, switch breaks | 213 |
| `return_visitor.rs` | Return statement optimization | 204 |
| `constructor_visitor.rs` | Constructor processing (super/this calls) | 271 |
| `attach_method_details.rs` | Method signature parsing, throws, generics | 354 |

**Key Features:**
- **Validation:** Detect malformed DEX (register bounds, >255 args, code loss)
- **Anonymous Classes:** Mark single-use synthetic classes for inlining
- **Constructor Chaining:** Identify super()/this() calls, extract field initializers
- **Generic Signatures:** Parse `<T extends Comparable>`, throws clauses
- **Region Post-Processing:** Insert edge instructions, merge loop conditions

---

### P0/P1 Fixes (Dec 22, 2025)

| ID | Issue | Status |
|----|-------|--------|
| P0-TYPE01 | Double literals as raw long bits | **FIXED** |
| P0-CFG01 | Try-catch exception variable scope | **FIXED** |
| P0-CFG02 | Empty if-body for early returns | **FIXED** |
| P0-CFG04 | Complex boolean expressions garbled | **FIXED** |
| P1-CFG05 | Variables outside exception scope | **FIXED** |
| P1-CFG06 | Missing if-else branch bodies | **FIXED** |
| P1-ENUM01 | Enum reconstruction failures | **FIXED** |

---

### P0-CFG03 Partial Fix: Compound Assignment Bug (Dec 22, 2025)

**Problem:** Compound assignments like `l6 /= l3` for undeclared variables.

**Fix:** Added declaration checks in `detect_increment_decrement()` - only generate compound assignment if the left operand is already declared.

**Result:** `l6 /= l3;` → `l2 = l6 / l3;` (proper assignment)

**Remaining:** Variables like `l3`, `l4`, `i3` still undefined - separate SSA issue.

**Files Changed:** `body_gen.rs`

---

### Type Inference Performance Optimization (Dec 22, 2025)

**14x faster than JADX** - Implemented two high-impact optimizations:

#### 1. Library Method Signature Cache
- **File:** `crates/dexterity-codegen/src/stdlib_signatures.rs` (423 lines)
- Pre-computes ~150 common method signatures for Android/Java/Kotlin stdlib
- Uses `LazyLock<FxHashMap>` for O(1) lookups vs DEX parsing
- Covers: `String`, `StringBuilder`, `Object`, `List`, `Map`, `android.util.Log`, `kotlin.jvm.internal.Intrinsics`

#### 2. Needed Variables Collection (Lazy Type Inference Support)
- **File:** `crates/dexterity-passes/src/needed_vars.rs` (339 lines)
- Computes transitive closure of variables needed in output via backward dataflow analysis
- Seeds from side-effect instructions (Return, Throw, Invoke, Put)
- Returns `FxHashSet<(u16, u32)>` of (register, ssa_version) pairs

#### 3. Binary IR Type Hint Field
- **File:** `crates/dexterity-ir/src/instructions.rs`
- Added `arg_type: Option<ArgType>` to `InsnType::Binary`
- Preserves type info from typed DEX opcodes (div-double, add-float, etc.)

**Benchmark Results (100GB RAM disk, 56→112 threads):**

| APK | Dexterity (112t) | JADX (56t) | Speedup |
|-----|------------------|------------|---------|
| small.apk | 0.022s | 1.85s | **84x** |
| medium.apk | 1.26s | 14.81s | **11.8x** |
| large.apk | 2.60s | 17.08s | **6.6x** |
| badboy.apk | 0.23s | 14.07s | **61x** |
| badboy-x86.apk | 0.21s | 13.71s | **65x** |
| **Total** | **4.32s** | **61.52s** | **14.2x** |

---

### P0-CFG04: Complex Boolean Expressions Fix (Dec 22, 2025)

**Problem:** Bitwise conditions like `(window.getDecorView().getSystemUiVisibility() & 4) == 4` were garbled into nonsensical code like `systemUiVisibility &= i2 == i2`.

**Root Causes:**
1. Compound assignments (`&=`) were being used in inline expression generation, producing statements instead of expressions
2. Bitwise operators have lower precedence than comparison operators, so `a & b == c` parses as `a & (b == c)` instead of `(a & b) == c`

**Fixes Applied:**
1. In `body_gen.rs` lines 1304-1317: Removed `detect_increment_decrement` from inline expression generation. Compound assignments are statements, not expressions.
2. In `body_gen.rs` lines 4017-4030: Added `wrap_for_comparison()` helper to wrap expressions containing bitwise operators (`&`, `|`, `^`) in parentheses for correct precedence.
3. In `body_gen.rs` lines 3839-3841: Applied `wrap_for_comparison()` to left operand in comparison conditions.

**Files Changed:** `body_gen.rs`

### Phase 4 Code Optimization: COMPLETE (Dec 22, 2025)

All code optimization patterns from JADX's ModVisitor have been implemented in Dexterity:

| Feature | Implementation | Status |
|---------|---------------|--------|
| StringBuilder chain → concatenation | `body_gen.rs` parse_stringbuilder_chain() | ✅ DONE |
| Field arithmetic (a += 2) | `body_gen.rs` try_convert_to_compound_assignment() | ✅ DONE |
| CMP instruction inlining | `simplify.rs` | ✅ DONE |
| Boolean negation propagation | `if_region_visitor.rs` invert_if_region() | ✅ DONE |
| Array initialization | `mod_visitor.rs` | ✅ DONE |
| Constant folding | `simplify.rs` | ✅ DONE |
| Dead code elimination | `simplify.rs`, `code_shrink.rs` | ✅ DONE |

### Type Inference: ~85% JADX Parity (Dec 22, 2025)

Type inference enhanced from ~60% to ~85% JADX parity. Dexterity now implements the core functionality of JADX's 26 type inference files in 7 focused Rust modules (~9,100 lines total).

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

### P1-S10: JADX Invoke/MoveResult Parity (Dec 22, 2025) - FIXED

**Problem:** Dexterity used a fragile state machine (`last_invoke_expr`, `last_invoke_return`) at codegen level to pair Invoke with MoveResult instructions. This caused undefined variables when subsequent invokes overwrote the state before MoveResult was processed.

**Solution (JADX Parity):** Ported JADX's `ProcessInstructionsVisitor.mergeMoveResult()` pattern - merge runs BEFORE SSA transformation, setting the result destination directly on the Invoke instruction and removing MoveResult.

| File | Change |
|------|--------|
| `instructions.rs` | Added `dest: Option<RegisterArg>` to `InsnType::Invoke` |
| `process_instructions.rs` | **NEW** - Early merge pass (6 tests) |
| `type_inference.rs` | Handle `dest` field directly on Invoke |
| `body_gen.rs` | Handle merged dest, update forEach/iterator patterns |
| `decompiler.rs` | Integrate `process_instructions` before SSA |

**Results:**
- All 690+ integration tests pass
- Real APK testing: 0 undefined variables, only 1 `/* result */` fallback in entire APK
- Type inference improved from ~85% to ~90% JADX parity

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
