# Changelog

## December 2025

### Dec 21, 2025 - P1-S02 Dead Code Elimination for Boolean Constants

**Eliminated unused `final int i = 1;` declarations**

Boolean constant values (0/1) are now always inlined, preventing dead code declarations.

**Problem:**
```java
public static String[] tokenizeToStringArray(String str, String str2) {
    final int i = 1;  // DEAD CODE - never used after boolean conversion
    return Strings.tokenizeToStringArray(str, str2, true, true);
}
```

**Fix Applied:**
- In `InsnType::Const` handler, always inline values 0 or 1 via `store_inline_expr()`
- The inline expression is used by `write_arg_inline_typed()` which converts to `true`/`false` in boolean context
- Prevents declaration emission since the value is inlined at all use sites

**Result:**
```java
public static String[] tokenizeToStringArray(String str, String str2) {
    return Strings.tokenizeToStringArray(str, str2, true, true);  // Matches JADX
}
```

**Files changed:** `body_gen.rs`

### Dec 21, 2025 - P1-S02 Boolean Method Argument Fix (Extension)

**Extended boolean literal conversion to method arguments**

Method calls with boolean parameters now receive `true`/`false` instead of int variables.

**Problem:**
```java
final int i = 1;
return tokenizeToStringArray(str, str2, i, i);  // Wrong: passes int
```

**Fix Applied:**
- Extended `write_arg_inline_typed()` to check `const_values` for boolean parameters
- When target type is Boolean and register holds constant 0/1, emit `false`/`true`

**Results:**
- 27 additional boolean argument fixes
- All 687 tests pass

**Files changed:** `body_gen.rs`

### Dec 21, 2025 - P1-S02 Boolean Return Value Fix

**Fixed boolean return statements returning int constants**

Boolean methods that returned int variables (set to 0 or 1) now correctly return `true`/`false`.

**Problem:**
```java
public boolean equals(Object obj) {
    final int i = 1;
    if (obj == this) {
        return i;  // Wrong: returns int variable
    }
    ...
}
```

**Fix Applied:**
1. Added `const_values` HashMap to track all Const instruction values
2. Added `collect_const_values()` function in `body_gen.rs`
3. Updated return statement handler to check const_values for boolean context

**Results:**
- 59.6% reduction in `return variable;` patterns (6241 → 2521)
- Boolean methods now return `true`/`false` instead of int variables
- All 687 tests pass

**Files changed:** `body_gen.rs`

### Dec 21, 2025 - P1-S05 Variable Naming Underscore Fix (Partial)

**Fixed variable naming pattern to match JADX**

The `generate_unique_name()` function in `body_gen.rs` was generating names like `j_2`, `factory_2` with underscores, while JADX generates `j2`, `factory2` without underscores.

**Fix Applied:**
- Changed `format!("{}_{}", base_name, suffix)` to `format!("{}{}", base_name, suffix)` in `body_gen.rs:707`
- Now matches the `make_unique()` pattern in `var_naming.rs`

**Results:**
- 87.6% reduction in underscore naming patterns (25,251 → 3,122)
- Remaining patterns are intentional loop labels like `loop_23`
- All 687 tests pass

**Files changed:** `body_gen.rs`

**Remaining P1-S05 issues:** Undefined variable references (`l2`), ternary extraction to separate statements, wrong return values - these require deeper control flow fixes.

### Dec 21, 2025 - P1-S06 + P1-S12 Try-Catch Block Fix

**Try-Catch Region Detection Fixed**

Root cause: `detect_try_catch_regions()` in `region_builder.rs` compared block IDs (sequential: 0, 1, 2, ...) with instruction addresses (like 0x10, 0x20, ...), causing incorrect block assignment.

**Fixes Applied:**

1. **Block ID vs Offset Mismatch** - Now uses `block.start_offset` instead of `block_id` for try block range matching in `region_builder.rs`

2. **Handler Address Mapping** - Added `addr_to_block` map to convert handler addresses to block IDs for correct handler block identification

3. **New Function `split_blocks_with_handlers()`** - Handler addresses are now treated as block leaders for correct block boundaries. Added to `block_split.rs` and exported in `lib.rs`

4. **Decompiler Integration** - Updated `decompiler.rs` to pass handler addresses to block splitting

5. **Stack Overflow Prevention** - Added recursion depth limits to prevent infinite recursion on complex control flow:
   - `recursion_depth` limit (100) in `RegionBuilder` (`region_builder.rs`)
   - `region_depth` limit (100) in `BodyGenContext` (`body_gen.rs`)

**Results:**
- All tests pass
- Large APK completes in 6.5s with 0 errors (previously caused stack overflow)
- Try-catch blocks now correctly generated with proper handler placement

**Files changed:** `region_builder.rs`, `block_split.rs`, `lib.rs`, `decompiler.rs`, `body_gen.rs`

### Dec 21, 2025 - Resources 1:1 JADX Parity Achieved

**Resources Output Now Identical to JADX (103 directories, 152 files, zero differences)**

Five key fixes achieved complete resource extraction parity:

1. **Gravity Flag Decoding** - Added `decode_gravity_flags()` in axml.rs that properly decomposes compound values like `0x800013` into `start|center_vertical`

2. **Resource Name Suffix Fix** - Fixed duplicate detection in arsc.rs so same resource ID with different configs (drawable + drawable-v21) are no longer treated as duplicates. Only adds `_res_0x{id}` suffix for actual name collisions.

3. **Version Qualifier Stripping** - Updated `normalize_config_qualifier()` in main.rs to strip standalone version qualifiers from binary XML paths (`layout-v21` becomes `layout`)

4. **xmlns Attribute Order** - Sort namespace declarations to put `android` first for JADX compatibility

5. **tileMode Enum** - Added tileMode enum decoding (`1` becomes `repeat`)

**Files changed:** `axml.rs`, `arsc.rs`, `main.rs`

### Dec 21, 2025 - Output Refresh Completed

**All 5 APK Samples Refreshed**
- Total Java files decompiled: ~8,858 files
  - small: 1 file
  - medium: 2,890 files
  - large: 5,901 files
  - badboy: 53 files
  - badboy-x86: 13 files
- Output location consolidated: `output/dexterity/`
- Root-level extraction directories cleaned up

**Fixes Verified in Output**
- Debug opcode fix (DBG_SET_FILE): Working correctly in decompiled output
- Config qualifier fix (BCP-47 locale tags): Verified in resource directories

### Dec 21, 2025 - P1-S11 Throws Declaration Fix

**Throws Clause Support (P1-S11)**
- Parse `dalvik/annotation/Throws` from DEX annotations to extract declared exceptions
- Added `get_throws_from_annotations()` to extract exception types from annotation array
- Added `collect_throws_from_instructions()` for static mapping of common exception-throwing methods
- Caught exception filtering: skip exceptions already handled in try-catch blocks
- Throws parity improved from ~13.7% to 41.7% (3x improvement)
- File: `crates/dexterity-codegen/src/method_gen.rs`

### Dec 21, 2025 - DEX Debug Opcodes + Resource Qualifiers

**dexterity-dex: Debug Opcode Fix**
- Fixed DBG_SET_FILE (0x09) to properly read its uleb128 argument for JADX parity
- Previously skipped without consuming the argument, causing parse offset drift
- File: `crates/dexterity-dex/src/sections/code_item.rs`

**dexterity-resources: BCP-47 Locale Support (RES-001)**
- Implemented proper BCP-47 locale tag formatting (`b+language+script+region+variant`)
- Added support for `locale_variant` field (e.g., POSIX variants)
- Distinguishes between old-style (`pt-rBR`) and BCP-47 (`b+sr+Latn`) formats
- Fix location: `crates/dexterity-resources/src/arsc.rs:205-274`
- Added 5 new unit tests for qualifier handling:
  - `test_qualifier_string_old_style_locale`
  - `test_qualifier_string_bcp47_with_script`
  - `test_qualifier_string_bcp47_with_variant`
  - `test_qualifier_string_default`
  - `test_qualifier_string_with_density`
- **Validation Status:** COMPLETE AND WORKING (5/5 tests passing)
- **JADX Comparison:** Identical output for BCP-47, old-style locales, density, and API level qualifiers

### Dec 21, 2025 - Phase 1 + Phase 2 + Phase 3 Complete

**Phase 3: Dead CMP Elimination (P2-Q05 Fix)**
- Fixed unused Compare variable declarations (e.g., `int compare = cmp_long(a, b);`)
- Added `SimplifyResult.dead_cmp_count` field to track CMP instructions marked for removal
- When CMP results are unwrapped into If conditions, the original CMP is marked with `DontGenerate`
- Three-phase simplify pass: 1) build maps, 2) apply simplifications and track unwrapped CMPs, 3) mark dead CMPs
- File: `crates/dexterity-passes/src/simplify.rs`

**Phase 2: Boolean Expression Simplification**
- Short-circuit OR condition merging: Combined nested if conditions into `a || b` patterns
- Added `collect_branch_blocks_with_barrier()` with barrier parameter to prevent cross-branch block inclusion
- OR type 2 detection: Detect when both conditions branch to same "true" target
- Fixed `MergedCondition::merge()` then/else block assignment for OR patterns
- Added `MergeMode` enum (And/Or/Single) for tracking merge type
- Files: `conditionals.rs`, `region_builder.rs`

**Phase 1: Static Field Inline Initialization**
- Added `NewInstance` variant to `FieldValue` enum in `info.rs`
- Extended `extract_field_init.rs` to detect `new-instance` + `invoke-direct <init>` + `sput-object` pattern
- Empty clinit suppression in `method_gen.rs`: Skip generating `static {}` blocks with only `return-void`
- Added `NewInstance` rendering in `class_gen.rs` for static field initializers
- Files: `info.rs`, `extract_field_init.rs`, `class_gen.rs`, `method_gen.rs`

### Dec 20, 2025 - Kotlin BitEncoding Port (100% Parity)

**BitEncoding Decoder Ported from Java**
- Implemented `bit_encoding_decode()` in Rust with two encoding modes:
  - UTF-8 mode (marker = '\0'): Each char is directly a byte (modern format)
  - 8-to-7 bit mode (marker = '\u0001'): Legacy 7-bit byte packing
- Added `jvm_metadata.proto` with `StringTableTypes` message for proper d2 string resolution
- Implemented 68 predefined Kotlin string lookups (kotlin/Any, kotlin/collections/*, kotlin/Function0-22, etc.)
- Kotlin metadata parsing now 100% functional
- Files: `parser.rs`, `proto/jvm_metadata.proto`

### Dec 21, 2025 - Kotlin Class and Function Modifiers

**Kotlin Modifier Support (JADX kotlin-metadata plugin parity)**
- **Class modifiers:** `/* data */`, `/* sealed */`, `/* value */` emitted after Java modifiers, before `class` keyword
  - Example: `public final /* data */ class User { ... }`
- **Function modifiers:** `/* operator */`, `/* suspend */`, `/* inline */`, `/* infix */`, `/* tailrec */` emitted before Java modifiers
  - Example: `/* suspend */ public Object fetchData(Continuation $completion) { ... }`
- Added IR fields: is_suspend, is_inline_function, is_infix, is_operator, is_tailrec, receiver_type
- Extractor applies modifiers from Kotlin metadata to MethodData
- **Type variance:** `<out R>`, `<in T>` preserved from Kotlin metadata
- **Class aliases:** Now correctly use simple names instead of full paths
- Files: `info.rs`, `extractor.rs`, `method_gen.rs`, `class_gen.rs`

### Dec 21, 2025 - All P1 Semantic Issues Fixed

**NEW-008: Malformed Synchronized Blocks**
- Check ACC_DECLARED_SYNCHRONIZED (0x20000) flag instead of sync instruction count
- File: `crates/dexterity-codegen/src/body_gen.rs`

**NEW-009: Missing Imports**
- Added import collection for ConstClass, InstanceGet/Put, InvokeCustom instructions
- File: `crates/dexterity-codegen/src/class_gen.rs`

**NEW-010: Boolean vs Null Comparisons**
- Added `name_suggests_boolean_method()` heuristic (is*, has*, can*, should*, etc.)
- File: `crates/dexterity-codegen/src/body_gen.rs`

**NEW-011: Parameter/Field Mismatch**
- Added fallback to SSA version 0 name for parameter registers
- File: `crates/dexterity-codegen/src/expr_gen.rs`

**NEW-012: Constructor Result Discarded**
- Assign constructor result to receiver register's variable when tracking fails
- File: `crates/dexterity-codegen/src/body_gen.rs`

### Dec 20, 2025 - Iterative Pass Execution (JADX Parity)

**Iterative Simplification + Code Shrinking**
- Added fixpoint loop for `simplify_instructions()` + `shrink_code()` passes
- Matches JADX's `traverseIterative()` behavior
- Iteration limit: `5 × block_count` (from JADX's `DepthRegionTraversal.java`)
- Enables nested ternary optimization and chained simplifications
- File: `crates/dexterity-cli/src/decompiler.rs:92-114`

### Dec 20, 2025 - All P0 Bugs Fixed

**NEW-006: Enum Value Extraction** - Fixed enum constants with wrong values
- Removed Int(0)/Int(1) to Bool conversion
- Changed to backwards search for register values
- Commits: `6c161be5c`, `c967197ad`

**NEW-004: Variable Type Confusion** - Fixed different object types sharing same variable name
- Changed `types_compatible_for_naming()` to require exact class match
- File: `var_naming.rs:255`

**NEW-002: Undefined Variables** - Fixed PHI variables declared without initializers
- Added constant initializer tracking for PHI nodes
- File: `body_gen.rs`

**NEW-003: throw non-Throwable** - Fixed throwing non-Throwable types
- Emit `throw null;` with warning for invalid throw arguments
- Commit: `6b023278e`

### Dec 19, 2025

- TernaryMod + IfRegionVisitor control flow improvements
- Kotlin type variance annotations
- Compose UI complexity detection
- Exception handler PHI declarations

### Dec 18, 2025

- Interface generic type parameters
- Undefined variable references
- Missing import statements
- Constructor generic types

### Dec 17, 2025

- Variable naming algorithm ported from JADX (edge cases remain)
- THP optimization (8.8% faster at 56 cores)
- Exception handling improvements
- Multi-catch support
- Enum constant name corruption fix

### Dec 16, 2025

- Variable naming (27,794 -> 0 arg0/arg1 instances)
- Class-level generic type parameters (736 classes)
- Undefined variables in If/Switch/Synchronized regions
- Double-dot class names fix
- Invalid Java identifiers fix
