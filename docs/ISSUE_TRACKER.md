# Issue Tracker

**Status:** Open: 0 P0, 3 P1, 2 P2 | IR 100% Complete | P0-C08 fixed (instanceof syntax), P1-S08 fixed (short-circuit prelude), P1-S02 fixed (returns + args), P1-S03 merged with P1-S05, P1-S05 partial (simple ternaries), P1-S07 fixed (Dec 22, 2025)
**Reference Files:**
- `com/amplitude/api/f.java` (AmplitudeClient - 1033 lines)
- `f/c/a/f/a/d/n.java` (NativeLibraryExtractor - 143 lines)

## Open Issues

### P0 Critical (Won't Compile)

| ID | Issue | Example | Location |
|----|-------|---------|----------|
| ~~P0-C01~~ | ~~Duplicate import names~~ | **FIXED** - Filter conflicting simple names | class_gen.rs |
| ~~P0-C02~~ | ~~Undefined variables in constructors~~ | **FIXED** - Wide type register offset | body_gen.rs |
| ~~P0-C03~~ | ~~Assignment in parentheses~~ | **FIXED** - Remove unnecessary parens | body_gen.rs |
| ~~P0-C04~~ | ~~Unreachable code after return~~ | **FIXED** - Skip code after throw/return | body_gen.rs |
| ~~P0-C05~~ | ~~Variable shadows parameter~~ | **FIXED** - Register param names | body_gen.rs |
| ~~P0-C06~~ | ~~Wrong constructor chain~~ | **FIXED** - Normalize class type format | body_gen.rs |
| ~~P0-C07~~ | ~~Undefined variable references~~ | **FIXED** - Use write_arg_inline() for inlined exprs | body_gen.rs |
| ~~P0-C08~~ | ~~Invalid instanceof syntax~~ | **FIXED** - `instanceof X == null` and `!x instanceof Y` patterns | body_gen.rs |

### P1 Semantic (Wrong Behavior)

| ID | Issue | Example | Location |
|----|-------|---------|----------|
| ~~P1-S01~~ | ~~Empty if blocks missing return~~ | **FIXED** - is_empty_region() fix | body_gen.rs |
| ~~P1-S02~~ | ~~Boolean vs int confusion~~ | **FIXED** - const_values tracking for returns (59.6% reduction) + method args (27 fixes) + dead code elimination for 0/1 constants | body_gen.rs |
| ~~P1-S03~~ | ~~Wrong return value~~ | **MERGED with P1-S05** - Same root cause (control flow reconstruction) | body_gen.rs |
| P1-S04 | Wrong method signature call | **NEEDS REPRO** - 2 args passed to 1-arg method (wide type handling?) | body_gen.rs |
| P1-S05 | Control flow logic wrong | **PARTIAL** - Merge block prelude processing for simple ternaries; complex nested ternary patterns (like `D(long j)`) still broken - inner ternary not detected | var_naming.rs, body_gen.rs |
| ~~P1-S06~~ | ~~Missing try-catch blocks~~ | **FIXED** - Block ID vs offset mismatch fixed, handler addresses as block leaders, stack overflow prevention | region_builder.rs, block_split.rs, decompiler.rs, body_gen.rs |
| ~~P1-S07~~ | ~~Truncated loop body~~ | **FIXED** - Semantic origin tracking prevents ArrayBound/LoopCounter variable collapse | var_naming.rs |
| ~~P1-S08~~ | ~~Method calls before guard~~ | **FIXED** - Only emit first block prelude for short-circuit conditions (AND/OR) | body_gen.rs |
| ~~P1-S09~~ | ~~For-each over Iterator~~ | **FIXED** - Validate collection expr or fall back to while | body_gen.rs |
| P1-S10 | Code after loop ends | **NEEDS REPRO** - `it.next()` after while loop (related to P1-S07) | body_gen.rs |
| ~~P1-S11~~ | ~~Missing throws declaration~~ | **FIXED** - Parse dalvik/annotation/Throws | method_gen.rs |
| ~~P1-S12~~ | ~~Empty catch block~~ | **FIXED** - Same root cause as P1-S06; block ID vs offset mismatch fixed with stack overflow prevention | region_builder.rs, body_gen.rs |

### P2 Quality Issues

| ID | Issue | Impact |
|----|-------|--------|
| P2-Q01 | Missing field rename comments | **VERIFIED** - Implemented, requires `--deobf` flag |
| P2-Q02 | Synthetic accessor methods visible | **VERIFIED** - Implemented with inline_attr, all tests pass |
| P2-Q03 | Wrong import classes | **VERIFIED** - Conflict detection via simple_name_map, needs specific repro |
| ~~P2-Q04~~ | ~~JADX WARNING comments~~ | **FIXED** - Changed to Dexterity branding |
| ~~P2-Q05~~ | ~~Unused variable declarations~~ | **FIXED** - CMP inlining fix in simplify.rs (counts ALL uses, marks dead only if ALL are IF/Ternary compare-to-zero) |

### Investigation (Blocked)

| ID | Issue | Status | Details |
|----|-------|--------|---------|
| INV-001 | Zara APK hang | APK unavailable | [KNOWN_ISSUES.md](KNOWN_ISSUES.md#inv-001-hanging-apk---zara-android-app) |

#### P1-S05: Control Flow Logic Fix (Dec 22, 2025)

**Status:** PARTIAL

**Example Method:** `com/amplitude/api/f.java:D(long j)`

**Expected (JADX):**
```java
private boolean D(long j2) {
    return j2 - this.w < (this.H ? this.D : this.E);
}
```

**Current (Dexterity):**
```java
private boolean D(long j) {
    long l;
    int j2 = 0;
    j -= l2;
    return j < l ? 1 : 0;
}
```

**Root Cause Analysis (Dec 22, 2025):**

The bytecode structure is:
```smali
iget-boolean v0, this.H     ; Block 0: condition
if-eqz v0, :else
iget-wide v0, this.D        ; Block 1: then (ternary value)
goto :merge
:else
iget-wide v0, this.E        ; Block 2: else (ternary value)
:merge
iget-wide v2, this.w        ; Block 3: merge block
sub-long p1, v2
cmp-long p1, p1, v0
if-gez p1, :false           ; Block 3 continued: outer ternary
const 1
goto :ret
:false
const 0
:ret
return p1
```

The issue is that the **inner ternary** (`this.H ? this.D : this.E` for v0) is not being detected as a TernaryAssignment region, even though it should satisfy all criteria:
- Both branches are single blocks (blocks 1, 2)
- Both have single meaningful instructions (iget-wide)
- Both assign to the same register (v0)

Investigation needed:
1. Why isn't the ternary detection triggering for the inner pattern?
2. Is there a block splitting issue that prevents correct analysis?
3. Is the condition analysis grouping blocks incorrectly?

**Partial Fix Applied (Dec 22, 2025):**
- `find_merge_block_for_ternary()` - Finds common successor of then/else value blocks
- `process_merge_block_prelude_for_ternary()` - Processes merge block prelude
- `uses_register()` helper - Checks register references

**Previous fixes (Dec 21, 2025):**
- Underscore naming pattern (`j2` instead of `j_2`)
- Field access inlining improvements
- Ternary sub-expressions inline

**Files Changed:** `body_gen.rs`, `var_naming.rs`

#### P1-S06 + P1-S12: Try-Catch Block Fix (Dec 21, 2025)

**Status:** FIXED

**Root Cause:** `detect_try_catch_regions()` in `region_builder.rs` compared block IDs (sequential: 0, 1, 2, ...) with instruction addresses (like 0x10, 0x20, ...).

**Fix Applied:**
1. **Block ID vs Offset Mismatch** - Now uses `block.start_offset` instead of `block_id` for try block range matching
2. **Handler Address Mapping** - Added `addr_to_block` map to convert handler addresses to block IDs
3. **New Function `split_blocks_with_handlers()`** - Handler addresses are now block leaders for correct block boundaries (block_split.rs, exported in lib.rs)
4. **Decompiler Integration** - `decompiler.rs` now passes handler addresses to block splitting
5. **Stack Overflow Prevention** - Added `recursion_depth` limit (100) in `RegionBuilder` and `region_depth` limit (100) in `BodyGenContext`

**Results:**
- All tests pass
- Large APK completes in 6.5s with 0 errors (previously caused stack overflow)
- Try-catch blocks now correctly generated with proper handler placement

**Files Changed:** `region_builder.rs`, `block_split.rs`, `lib.rs`, `decompiler.rs`, `body_gen.rs`

#### P1-S07: Variable Naming Collapse Fix (Dec 21, 2025)

**Status:** FIXED

**Problem:** In `io/jsonwebtoken/io/Base64.java:decodeFast()`:
- All variables collapsed to single name (`length`)
- Loop condition became `while (length < length - 1)` - always false
- Loop bodies appeared empty due to wrong variable references

**Root Cause:** Variables from `ArrayLength` instructions (array bounds) were being grouped with variables from `Const 0/1` instructions (loop counters) via PHI nodes because:
1. Both are `int` type - type compatibility check passed
2. PHI nodes merged them into the same CodeVar group
3. All got the same name (`length`), making loop conditions self-referential and always false

**Fix Applied:**
1. **SemanticOrigin Enum** - Track variable semantic purpose:
   - `ArrayBound` - from ArrayLength instruction
   - `LoopCounter` - from Const 0 or 1
   - `Other` - everything else

2. **build_semantic_origins()** - Pre-compute origins for all SSA variables, including PHI node origin propagation

3. **origins_compatible()** - Prevent grouping ArrayBound with LoopCounter even if types match

4. **PHI Origin Propagation** - If PHI has conflicting source origins (ArrayBound + LoopCounter), mark dest as ArrayBound to prevent merging with loop counters

**Before Fix:**
```java
int length = 0;
Object obj1 = cArr != null ? cArr.length : length;
while (length < length - 1) {   // Always false!
```

**After Fix:**
```java
int i = 0;
int length;
Object obj1 = cArr != null ? cArr.length : i;
while (i < length - 1) {   // Correct: counter vs bound
```

**Results:**
- All 198 passes tests pass
- All 104 codegen tests pass
- Loop conditions now correctly use separate variables for counter and bound

**Files Changed:** `var_naming.rs`

### Previously Tracked (Completed or Superseded)

| ID | Issue | Status |
|----|-------|--------|
| ~~GAP-001~~ | ~~Kotlin package deobfuscation~~ | **FIXED** - get_aliased_class_name() + extract_and_register_package_alias() |
| ~~GAP-002~~ | ~~Variable naming quality~~ | **FIXED** - OBJ_ALIAS exact matching, GOOD_VAR_NAMES, toString(), type+method fallback |
| POL-002 | Cosmetic formatting | Low priority |

### Performance TODOs

See [PERFORMANCE.md](PERFORMANCE.md#implementation-status) for tracked optimizations.

---

## Fixed Issues (Dec 21, 2025)

### P0-C08: Invalid instanceof Syntax Fix (Dec 21 Night)

**Problem:** Two invalid Java syntax patterns were generated:
1. `object instanceof X == null` - instanceof results compared to null
2. `!object instanceof X` - negation not properly parenthesized

Both cause compilation errors (P0 bug).

**Root Cause:**
1. The `name_suggests_object_type()` heuristic matched class names in instanceof expressions
   (e.g., "JSONObject" in "obj instanceof JSONObject"), causing instanceof results to be
   incorrectly classified as object types
2. The `wrap_if_complex()` function didn't wrap instanceof expressions before applying negation

**Fix Applied:**
1. Added `is_instanceof` check in `generate_condition()` to detect expressions containing ` instanceof `
2. Excluded instanceof expressions from `is_object` classification
3. Added instanceof expressions to `is_boolean` classification
4. Updated `wrap_if_complex()` to wrap expressions containing ` instanceof `

**Before Fix:**
```java
if (object instanceof JSONObject == null && ...)  // Invalid!
if (!object instanceof Enum)  // Invalid!
```

**After Fix:**
```java
if (!(object instanceof JSONObject) && ...)  // Correct
if (!(object instanceof Enum))  // Correct
```

**Results:**
- All tests pass
- No more `instanceof X == null` patterns in output
- No more `!x instanceof X` patterns in output

**Files Changed:** `body_gen.rs`

### P1-S08: Method Calls Before Guard Fix (Dec 21 Night)

**Problem:** In compound conditions like `matcher.matches() && hashMap.get(matcher.group()) == null`,
the `matcher.group()` call was being hoisted before the `if` statement, causing it to execute
before `matcher.matches()`. This violates short-circuit semantics and can cause runtime errors.

**Root Cause:** `emit_condition_block_prelude()` was emitting prelude instructions from ALL blocks
in a compound condition (AND/OR), but for short-circuit evaluation, blocks after the first are
only executed if prior conditions are true/false.

**Fix Applied:**
1. Added `get_first_condition_block()` helper to get only the leftmost block in a compound condition
2. Modified `emit_condition_block_prelude()` to only emit prelude for the first block when
   processing AND, OR, or Ternary conditions
3. Subsequent blocks' prelude instructions are now protected by the short-circuit evaluation

**Before Fix:**
```java
String group = matcher.group(1);  // Called BEFORE matches()!
if (matcher.matches() && hashMap.get(group) == null) { ... }
```

**After Fix:**
```java
if (matcher.matches() && obj == null) { ... }
```

**Files Changed:** `body_gen.rs`

### P1-S02: Boolean Return Value Fix (Dec 21 Night)

**Note:** P1-S03 was merged with P1-S05 (same root cause). The boolean return fix is tracked as part of P1-S02.

| ID | Bug | Fix |
|----|-----|-----|
| P1-S02 | Boolean methods returning int 0/1 variables | Added const_values tracking and type-aware return formatting |
| BOOL-003 | `return i;` where i=0 in boolean method | Check const_values for "0"/"1" constants, convert to false/true |
| BOOL-004 | Type-aware return statement | Use write_arg_inline_typed with return type for all returns |

**Progress:** 59.6% reduction in `return variable;` patterns (6241 -> 2521)
**Files changed:** `body_gen.rs`
**Implementation:**
- Added `const_values` HashMap to track all Const instruction values
- Added `collect_const_values()` function to collect constant values
- Check const_values for 0/1 constants in boolean return context
- Convert 0->false, 1->true for boolean method returns
- Use `write_arg_inline_typed` with return type for general type awareness
- **Dead code elimination:** Always inline Const 0/1 values to prevent unused `final int i = 1;` declarations

### P1-S09: For-Each Over Iterator Fix (Dec 21 Night)

| ID | Bug | Fix |
|----|-----|-----|
| P1-S09 | For-each over Iterator | Find collection source from `.iterator()` call |
| FOREACH-001 | Illegal Java syntax | `for (x : iterator)` is invalid - must iterate over Iterable |
| FOREACH-002 | Collection source tracing | Added `find_iterator_source_collection()` to trace back through MoveResult→Invoke |

**Progress:** No more illegal `for (x : iterator)` syntax - correctly uses collection or falls back to while loop
**Files changed:** `body_gen.rs`
**Implementation:**
- `find_iterator_source_collection()` traces from iterator register to find `.iterator()` call
- Extracts the collection receiver (e.g., `this.a` from `this.a.iterator()`)
- Only generates for-each if collection source found, otherwise uses while loop
- All 60 loop tests pass

### P1-S02: Boolean Context Detection Extension (Dec 21 Evening)

| ID | Bug | Fix |
|----|-----|-----|
| P1-S02 | Boolean vs int confusion | Extended boolean literal detection to field assignments |
| BOOL-001 | InstancePut boolean context | Added boolean_literal_candidates check for instance field puts |
| BOOL-002 | StaticPut boolean context | Added boolean_literal_candidates check for static field puts |

**Progress:** Boolean detection now covers: Invoke args, InstancePut, StaticPut
**Files changed:** `type_inference.rs`
**Implementation:**
- When a boolean field is being assigned from a 0/1 literal register, apply Equals(Boolean) constraint
- This ensures the variable is typed as boolean instead of int
- Works alongside existing Invoke argument detection

### P1-S11: Throws Declaration Fix (Dec 21 Evening)

| ID | Bug | Fix |
|----|-----|-----|
| P1-S11 | Missing throws declaration | Parse `dalvik/annotation/Throws` from DEX annotations |
| THROWS-001 | Annotation parsing | Added `get_throws_from_annotations()` to extract exception types |
| THROWS-002 | Library method throws | Static mapping of common exception-throwing methods |
| THROWS-003 | Caught exception filtering | Skip exceptions already caught in try-catch blocks |

**Progress:** Throws parity improved from ~13.7% to 41.7% (3x improvement)
**Files changed:** `method_gen.rs`
**Implementation:**
- `get_throws_from_annotations()` parses `dalvik/annotation/Throws` annotation
- `collect_throws_from_instructions()` scans for library method calls
- Checked exceptions filtered against caught types
- Both sources merged in method signature generation

### Phase 4: Try-Catch Handler Matching (Dec 21 Evening)

| ID | Bug | Fix |
|----|-----|-----|
| TRY-001 | handler_off used as index not offset | Changed to HashMap with byte offsets for proper DEX format matching |
| TRY-002 | Missing handlers when offset != index | Added dual-key storage (both index and byte offset) |
| TRY-003 | Invalid try without catch/finally | Added early return when handlers list is empty |
| TRY-004 | Exception type resolution failure | Added fallback to `java/lang/Exception` when type lookup fails |

**Progress:** 0 -> 1556 try blocks generated (30% of JADX's 5176)
**Files changed:** `code_item.rs`, `converter.rs`, `body_gen.rs`

### Phase 2: Boolean Expression Simplification (Dec 21 PM)

| ID | Bug | Fix |
|----|-----|-----|
| COND-001 | Short-circuit OR not detected | Added MergeMode::Or with can_merge() and merge() logic |
| COND-002 | OR type 2 pattern missing | Detect when both conditions branch to same "true" target |
| COND-003 | Cross-branch block inclusion | Added barrier parameter to collect_branch_blocks_with_barrier() |
| COND-004 | Wrong then/else for merged OR | Fixed then_block/else_block assignment in MergedCondition::merge() |

**Files changed:** `conditionals.rs`, `region_builder.rs`

### Phase 1: Static Field Inline Initialization (Dec 21 PM)

| ID | Bug | Fix |
|----|-----|-----|
| INIT-001 | Static field inline init | NewInstance variant in FieldValue for `new ClassName()` patterns |
| INIT-002 | new-instance pattern detection | extract_field_init.rs detects new-instance + invoke-direct + sput-object |
| INIT-003 | Empty static initializers | method_gen.rs skips `static {}` blocks with only return-void |
| INIT-004 | NewInstance rendering | class_gen.rs renders `new ClassName()` for static field initializers |

**Files changed:** `info.rs`, `extract_field_init.rs`, `class_gen.rs`, `method_gen.rs`

### DEX + Resources Fixes (Dec 21 Late PM)

| ID | Bug | Fix | Validation |
|----|-----|-----|------------|
| DEX-001 | DBG_SET_FILE (0x09) not reading uleb128 | Added uleb128 read for file string index | Verified |
| RES-001 | BCP-47 locale format missing | Implemented `b+language+script+region+variant` format | **VALIDATED** (5/5 tests passing) |
| RES-002 | locale_variant field unused | Added variant support with uppercase formatting | Verified |
| RES-003 | Old-style vs BCP-47 confusion | Added detection logic based on script/variant presence | Verified |

**Files changed:** `code_item.rs`, `arsc.rs`

#### RES-001 Validation Details (Dec 21, 2025)

**Status:** COMPLETE AND WORKING

**Fix Location:** `crates/dexterity-resources/src/arsc.rs:205-274`

**Unit Tests (5/5 passing):**
- `test_qualifier_string_old_style_locale` - validates `pt-rBR`, `de` formats
- `test_qualifier_string_bcp47_with_script` - validates `b+sr+Latn`, `b+zh+Hans+CN` formats
- `test_qualifier_string_bcp47_with_variant` - validates `b+en+POSIX` format
- `test_qualifier_string_default` - validates default (empty) qualifier
- `test_qualifier_string_with_density` - validates `xhdpi`, `fr-hdpi` combined qualifiers

**Output Comparison vs JADX:**
- BCP-47 directories: `values-b+sr+Latn` (created correctly)
- Old-style locales: `values-pt-rBR`, `values-en-rAU` (working)
- Density qualifiers: `values-hdpi`, `values-xhdpi` (preserved)
- API level qualifiers: `values-v30`, `values-v21` (working)
- Resource file contents: Identical to JADX (Serbian/Cyrillic text preserved)

### Latest Fixes (Dec 21 PM)

| ID | Bug | Fix |
|----|-----|-----|
| P1-S09 | For-each over Iterator illegal Java | Validate collection expr contains `.`/`(`/`[` or fall back to while loop |
| P2-Q05 | Unused Compare variable declarations | CMP inlining fix in simplify.rs - counts ALL uses, marks dead only if ALL are IF/Ternary compare-to-zero, added ternary CMP support |
| P0-C04 | Unreachable code after return | emitted_exit tracking in generate_block() |
| P1-S01 | Empty if blocks missing return | Enhanced is_empty_region_with_ctx() recursion |
| VAR-001 | OBJ_ALIAS exact matching | Changed from contains() to exact FQN matching |
| VAR-002 | GOOD_VAR_NAMES set | Added "list" and "map" to direct-use names (13 total) |
| VAR-003 | toString() handling | Returns declaring class name (e.g., Pattern.toString() -> "pattern") |
| VAR-004 | Type+method fallback | make_type_method_name() (e.g., Pattern.compile() -> "patternCompile") |
| PKG-001 | Kotlin package deobfuscation | get_aliased_class_name() + extract_and_register_package_alias() |
| BRAND-001 | Dexterity branding | Changed JADX -> Dexterity in all warning comments |

### P1 Semantic Issues

| ID | Bug | Fix |
|----|-----|-----|
| NEW-008 | Malformed synchronized blocks | ACC_DECLARED_SYNCHRONIZED flag handling |
| NEW-009 | Missing imports | ConstClass, InstanceGet/Put, InvokeCustom collection |
| NEW-010 | Boolean vs null comparisons | Method name heuristics (is*, has*, can*) |
| NEW-011 | Parameter/field mismatch | SSA version 0 fallback for params |
| NEW-012 | Constructor result discarded | Assign to variable on tracking failure |

### P0 Compilation Errors

| ID | Bug | Fix |
|----|-----|-----|
| NEW-001 | Static final = null + reassign | Track final field initialization |
| NEW-002 | Undefined/uninitialized variables | PHI node constant tracking |
| NEW-003 | throw non-Throwable validation | Emit `throw null;` with warning |
| NEW-004 | Variable type confusion | Require exact class match for naming |
| NEW-006 | Enum wrong value types | Backwards search for register values |
| NEW-007 | Unreachable code after return | Dead code elimination |

### Previously Fixed (Dec 20, 2025)

| ID | Bug | Fixed |
|----|-----|-------|
| BUG-001 to BUG-012 | Original P0/P1 bugs | Dec 20, 2025 |
| P2-001 | JADX parity for variable naming | Dec 20, 2025 |

---

## Bug Report Template

```markdown
**Priority:** P0/P1/P2/P3
**Category:** Codegen / Control Flow / Type System / Variable Naming

**APK:** [name]
**Class:** [fully qualified]
**Method:** [if applicable]

**JADX Output (correct):**
[code]

**Dexterity Output (wrong):**
[code]

**Description:**
[explanation]
```
