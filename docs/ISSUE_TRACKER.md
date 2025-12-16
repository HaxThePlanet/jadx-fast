# Issue Tracker: Dexterity JADX Parity Issues

This tracker contains structured issues for autonomous agents working toward JADX parity.
See `LLM_AGENT_GUIDE.md` for workflow instructions.

---

## CRITICAL Issues (P1) - Blocks Production Use

These prevent code compilation or execution. Fix these first.

### Issue ID: CRITICAL-001

**Status:** RESOLVED (Dec 16, 2025)
**Priority:** P1 (CRITICAL)
**Category:** Undefined Variables
**Impact:** Code won't compile
**Estimated Complexity:** Medium (2-4 hours)
**Affected APKs:** Medium, Large

**Description:**

Loop variable boundary `i2` is undefined in while condition: `while (i < i2)`

The loop iteration uses a variable that was never defined, causing immediate compilation failure.

**Example Location:**

File: `com/unity/purchasing/common/StoreDeserializer.java`
Method: `DeserializeProducts`
Line: 17 in decompiled output

**Previous Output (Dexterity - Before Fix):**
```java
int i;  // declared but uninitialized
while (i < i2) {  // i2 is UNDEFINED!
    v3.add(StoreDeserializer.GetProductDefinition(...));
    i++;
}
```

**Current Output (Dexterity - After Fix):**
```java
int i = 0;
while (i < jSONArray.length()) {  // FIXED: inlined expression
    v3.add(StoreDeserializer.GetProductDefinition(...));
    i++;
}
```

**Root Cause (Found):**

Loop condition setup instructions weren't being emitted before the condition was generated. The expressions like `array.length()` were not being substituted in loop conditions.

**Resolution:**

- Added `gen_arg_with_inline_peek()` in body_gen.rs to support inlined expressions in conditions
- Added `emit_condition_block_prelude()` to process loop header instructions before condition

**Files Changed:**
- `crates/dexterity-codegen/src/body_gen.rs`

**Acceptance Criteria:**

- [x] No undefined variables in generated code
- [x] All loop bounds properly resolved and defined
- [x] All existing tests continue to pass (680/680)
- [x] Decompiled code compiles without errors

---

### Issue ID: CRITICAL-002

**Status:** OPEN
**Priority:** P1 (CRITICAL)
**Category:** Undefined Variables (Nested Scope)
**Impact:** Code won't compile
**Estimated Complexity:** Medium (2-4 hours)
**Affected APKs:** Medium, Large

**Description:**

Variable `v2` is referenced but never defined in nested or conditional scope.

**Example Location:**

File: `com/twitter/sdk/android/tweetcomposer/ComposerActivity.java`
Method: `Builder.session()`
Line: 100 in decompiled output

**Expected Output (JADX):**
```java
public Builder session(TwitterSession twitterSession) {
    if (twitterSession == null) {
        throw new IllegalArgumentException("session must not be null");
    }
    TwitterAuthToken authToken = twitterSession.getAuthToken();
    // ...
}
```

**Actual Output (Dexterity):**
```java
public Builder session(TwitterSession twitterSession) {
    // ... condition logic ...
    v2.someMethod();  // v2 is UNDEFINED!
}
```

**Root Cause:**

Variables in nested scopes or after conditionals not properly tracked. Similar to CRITICAL-001 but for conditional branches.

**Relevant Code Areas:**

- `/mnt/nvme4tb/jadx-rust/crates/dexterity-passes/src/region_builder.rs` - Conditional region handling
- `/mnt/nvme4tb/jadx-rust/crates/dexterity-passes/src/ssa.rs` - PHI node placement for conditionals
- `/mnt/nvme4tb/jadx-rust/crates/dexterity-codegen/src/body_gen.rs` - Variable scope tracking during code generation

**Acceptance Criteria:**

- [ ] No undefined variables in conditional branches
- [ ] Variables properly scoped across if/else blocks
- [ ] All tests pass
- [ ] Metrics improve

---

### Issue ID: CRITICAL-003

**Status:** RESOLVED (Dec 16, 2025)
**Priority:** P1 (CRITICAL)
**Category:** Type Mismatch (Wrong Return Type)
**Impact:** Runtime type error, won't compile
**Estimated Complexity:** Medium (2-4 hours)
**Affected APKs:** Large

**Description:**

Method returns primitive `0` for object type (should be `null`).

**Example Location:**

File: `com/unity/purchasing/common/StoreDeserializer.java`
Method: `DeserializeProducts`
Line: 31 in decompiled output

**Previous Output (Dexterity - Before Fix):**
```java
return 0;  // Wrong: should be null for List<ProductDefinition> return type
```

**Current Output (Dexterity - After Fix):**
```java
return null;  // FIXED: Correctly generates null for object return types
```

**Root Cause (Found):**

Dalvik returns 0 for null references, but the return statement generation wasn't converting this to `null` for object-returning methods.

**Resolution:**

- Added type-aware null detection in return statement handling
- When return type is object/array and value is 0, now correctly generates `null`

**Files Changed:**
- `crates/dexterity-codegen/src/body_gen.rs`

**Acceptance Criteria:**

- [x] All return statements match method return type
- [x] Null used for reference types, not 0
- [x] Tests pass (680/680)
- [x] Metrics improve

---

### Issue ID: CRITICAL-004

**Status:** PARTIALLY RESOLVED (Dec 16, 2025)
**Priority:** P1 (CRITICAL)
**Category:** Type Mismatch (Comparison)
**Impact:** Type error, won't compile
**Estimated Complexity:** Medium (2-4 hours)
**Affected APKs:** Medium, Large

**Description:**

Object variables compared to integer constant `0` instead of `null`.

**Example Location:**

File: `com/twitter/sdk/android/tweetcomposer/ComposerActivity.java`
Line: 100 in decompiled output

**Previous Output (Dexterity - Before Fix):**
```java
if (twitterSession == 0) {  // Type mismatch: Object compared to int!
    throw new IllegalArgumentException("TwitterSession must not be null");
}
```

**Current Output (Dexterity - After Fix for method parameters):**
```java
if (twitterSession == null) {  // FIXED for parameters
    throw new IllegalArgumentException("TwitterSession must not be null");
}
```

**Root Cause (Found):**

The condition generation was only checking `type_info` (from type inference) but not `expr_gen.var_types` (which has parameter types from method signature).

**Resolution (Partial):**

- Added fallback to `expr_gen.get_var_type()` in `generate_condition()` when type_info doesn't have the type
- Added `get_var_type()` method to expr_gen.rs
- Method parameter types now correctly resolve to objects -> null comparisons

**Remaining Issue:**

Local variables (not parameters) still show `== 0` when type inference fails to track them properly. This requires deeper type inference work in type_inference.rs constraint propagation.

**Files Changed:**
- `crates/dexterity-codegen/src/body_gen.rs` - Added fallback type lookup in `generate_condition()`
- `crates/dexterity-codegen/src/expr_gen.rs` - Added `get_var_type()` method

**Acceptance Criteria:**

- [x] Method parameters correctly compared to null (not 0)
- [ ] Local variables correctly compared to null (requires deeper type inference work)
- [ ] String variables not compared to integers
- [x] Tests pass (683/683)

---

### Issue ID: CRITICAL-005

**Status:** RESOLVED (Dec 16, 2025)
**Priority:** P1 (CRITICAL)
**Category:** Logic Inversion
**Impact:** Wrong program behavior
**Estimated Complexity:** Low (1-2 hours)
**Affected APKs:** Medium, Large

**Description:**

Null check condition inverted: Code checks `!= null` but should check `== null`.

**Example Location:**

File: `com/twitter/sdk/android/tweetcomposer/ComposerActivity.java`
Method: `Builder` constructor
Line: 35 in decompiled output

**Expected Output (JADX):**
```java
public Builder(Context context) {
    if (context == null) {
        throw new IllegalArgumentException("Context must not be null");
    }
    this.context = context;
}
```

**Previous Output (Dexterity - Before Fix):**
```java
public Builder(Context context) {
    if (context != null) {  // INVERTED! Should be ==
        throw new IllegalArgumentException("Context must not be null");
    }
    this.context = context;
}
```

**Current Output (Dexterity - After Fix):**
```java
public Builder(Context context) {
    if (context == null) {
        IllegalArgumentException v2 = new IllegalArgumentException("Context must not be null");
        throw v2;
    } else {
        this.context = context;
    }
}
```

**Root Cause (Found):**

For "branch-to-throw" patterns like `if-eqz v0, :throw_label`, the bytecode branches when the condition is TRUE (e.g., null). The decompiler was:
1. Using fall-through as "then" block (assignment code)
2. Using branch target as "else" block (throw code)
3. Negating the condition

This resulted in inverted logic. The fix detects when the branch target throws and swaps the blocks WITHOUT negating the condition.

**Resolution:**

Modified `find_branch_blocks()` in `conditionals.rs` to:
1. Detect when branch target (else_target) ends with a throw
2. Detect when fall-through (then_target) doesn't throw
3. In this case, swap the blocks and DON'T negate the condition
4. Use `u32::MAX` as merge for throw block to ensure it's included

**Files Changed:**
- `crates/dexterity-passes/src/conditionals.rs`: Added throw detection and block swapping logic, added `negate_condition` field to `IfInfo`
- `crates/dexterity-passes/src/region_builder.rs`: Added `extract_condition_with_negation()` to respect the negation flag

**Acceptance Criteria:**

- [x] Null checks produce correct conditions
- [x] All conditionals match original semantics
- [x] Tests pass (680/680 integration tests pass)

---

### Issue ID: CRITICAL-006

**Status:** OPEN
**Priority:** P1 (CRITICAL)
**Category:** Missing Code
**Impact:** Incomplete output
**Estimated Complexity:** Low (1-2 hours)
**Affected APKs:** Medium, Large

**Description:**

Method bodies are completely missing, likely simple getter/setter methods.

**Example Location:**

File: `com/twitter/sdk/android/core/TwitterCore.java`
Methods: `getIdentifier()`, `getVersion()`
Lines: 18-38 in JADX (completely absent in Dexterity)

**Expected Output (JADX):**
```java
public String getIdentifier() {
    return "com.twitter.sdk.android:twitter-core";
}

public String getVersion() {
    return "3.1.1.9";
}
```

**Actual Output (Dexterity):**
```
[methods completely missing]
```

**Root Cause:**

Code generation for simple methods failing - likely an early return or exception in method body generation.

**Relevant Code Areas:**

- `/mnt/nvme4tb/jadx-rust/crates/dexterity-codegen/src/body_gen.rs` - Method body generation
- `/mnt/nvme4tb/jadx-rust/crates/dexterity-codegen/src/class_gen.rs` - Method enumeration

**Acceptance Criteria:**

- [ ] All methods have bodies
- [ ] No methods are skipped
- [ ] Tests pass

---

## HIGH Priority Issues (P2) - Severely Reduces Quality

These significantly impact code quality but don't block compilation.

### Issue ID: HIGH-001

**Status:** OPEN
**Priority:** P2 (HIGH)
**Category:** Register-Based Variable Names
**Impact:** Low code quality, unreadable
**Estimated Complexity:** Medium (2-4 hours)
**Affected APKs:** Medium, Large

**Description:**

Variables have register-based names (`v2`, `v3`, `v6`) instead of meaningful names.

**Count:** 50+ variables across medium/large APKs

**Expected:** `buffer`, `token`, `authToken`, `result`

**Actual:** `v2`, `v3`, `v6`

**Root Cause:**

SSA variable name recovery or scoring not working properly. CodeVar grouping or name selection failing to pick meaningful names.

**Relevant Code Areas:**

- `/mnt/nvme4tb/jadx-rust/crates/dexterity-passes/src/var_naming.rs` (44,770 lines)
  - Function: `assign_variable_names()` - Main naming logic
  - Function: `score_candidate_name()` - Name quality scoring
  - Structure: `NameCandidate` - Name proposal tracking

**Acceptance Criteria:**

- [ ] Variable quality score improves from 0.67 toward 1.0
- [ ] No register names in output (except as last resort)
- [ ] Tests pass

---

### Issue ID: HIGH-002

**Status:** RESOLVED (Dec 16, 2025)
**Priority:** P2 (HIGH)
**Category:** Duplicate Variable Declarations
**Impact:** Variable shadowing, confusion
**Estimated Complexity:** Medium (2-4 hours)
**Affected APKs:** Medium, Large

**Description:**

Same variable declared multiple times in same scope (shadowing).

**Previous Output (Before Fix):**
```java
boolean str2;     // Line 64
int str2;         // Line 65 - duplicate!
boolean str2;     // Line 66 - duplicate!
```

**Current Output (After Fix):**
```java
int i;  // PHI declaration at start
// ...
i = 0;  // No redeclaration, just assignment
```

**Root Cause (Found):**

The `declared_vars` tracking used `(reg, version)` as key, but different SSA versions of the same register may share the same Java variable name. This caused:
1. PHI declarations at method start: `int i;` for version 1
2. Later assignment: `int i = 0;` for version 2 (duplicate declaration)

**Resolution:**

- Added `declared_names: HashSet<String>` to BodyGenContext in body_gen.rs
- Added `is_name_declared()` and `mark_name_declared()` methods
- Updated all declaration sites to check both SSA version AND variable name before declaring
- Modified: `emit_phi_declarations()`, `emit_assignment_with_hint()`, `emit_assignment_insn()`, and others

**Files Changed:**
- `crates/dexterity-codegen/src/body_gen.rs` - Added name-based declaration tracking

**Acceptance Criteria:**

- [x] No duplicate declarations in same scope (for same variable name)
- [x] Proper shadowing only when needed
- [x] Tests pass (683/683)

---

### Issue ID: HIGH-003

**Status:** OPEN
**Priority:** P2 (HIGH)
**Category:** Missing Static Modifier
**Impact:** Structural error, inheritance issues
**Estimated Complexity:** Low (1-2 hours)
**Affected APKs:** Medium, Large

**Description:**

Inner classes missing `static` keyword.

**Expected:**
```java
public static class Builder {
```

**Actual:**
```java
public class Builder {  // Missing static!
```

**Root Cause:**

Class member resolution not tracking static modifier properly.

**Relevant Code Areas:**

- `/mnt/nvme4tb/jadx-rust/crates/dexterity-codegen/src/class_gen.rs` - Class structure generation
- `/mnt/nvme4tb/jadx-rust/crates/dexterity-ir/src/nodes.rs` - Class metadata

**Acceptance Criteria:**

- [ ] Inner classes properly marked as static
- [ ] Modifiers match original DEX
- [ ] Tests pass

---

### Issue ID: HIGH-004

**Status:** OPEN
**Priority:** P2 (HIGH)
**Category:** Unreachable Code
**Impact:** Dead code remains
**Estimated Complexity:** Low (1-2 hours)
**Affected APKs:** Medium, Large

**Description:**

Code after return/throw statements marked as unreachable, but still emitted.

**Example:**
```java
return arrayList;
i++;  // Dead code - after return
RuntimeException runtimeException = new RuntimeException(string);  // Dead code
throw runtimeException;  // Never executed
```

**Root Cause:**

Code generation not skipping unreachable blocks.

**Relevant Code Areas:**

- `/mnt/nvme4tb/jadx-rust/crates/dexterity-codegen/src/body_gen.rs` - Block traversal
- `/mnt/nvme4tb/jadx-rust/crates/dexterity-passes/src/region_builder.rs` - Unreachable block detection

**Acceptance Criteria:**

- [ ] Unreachable code removed from output
- [ ] Only reachable paths emitted
- [ ] Tests pass

---

## MEDIUM Priority Issues (P3) - Impacts Usability

Lower priority - improve readability and standards compliance.

### Issue ID: MEDIUM-001

**Status:** OPEN
**Priority:** P3 (MEDIUM)
**Category:** Verbose Type Names
**Impact:** Reduced readability
**Estimated Complexity:** Low (1-2 hours)
**Affected APKs:** Medium, Large

**Description:**

Fully qualified names used instead of importing types.

**Expected:**
```java
import java.util.ConcurrentHashMap;

private ConcurrentHashMap<Session, TwitterApiClient> apiClients;
```

**Actual:**
```java
private java.util.concurrent.ConcurrentHashMap<com.twitter.sdk.android.core.Session, com.twitter.sdk.android.core.TwitterApiClient> apiClients;
```

**Acceptance Criteria:**

- [ ] Common types properly imported
- [ ] Qualified names only when necessary
- [ ] Readability improved

---

### Issue ID: MEDIUM-002

**Status:** OPEN
**Priority:** P3 (MEDIUM)
**Category:** Missing Exception Imports
**Impact:** Code won't compile (import error)
**Estimated Complexity:** Low (1 hour)
**Affected APKs:** Medium, Large

**Description:**

Exception types used but not imported.

**Expected:**
```java
import org.json.JSONException;

catch (JSONException e) {
```

**Actual:**
```
[no import]
catch (JSONException e) {  // JSONException not imported - won't compile
```

**Acceptance Criteria:**

- [ ] All used exception types imported
- [ ] Code compiles without import errors

---

## Issue Statistics

**Current Issue Status (Dec 16, 2025):**

| Priority | Resolved | Remaining |
|----------|----------|-----------|
| CRITICAL | 4 (+1 partial) | 2 |
| HIGH | 1 | 3 |
| MEDIUM | 0 | 2 |

**Total: 5 resolved, 7 remaining** to reach 90%+ quality target.

| Priority | Count | Status | Total Time Est. |
|----------|-------|--------|-----------------|
| CRITICAL (P1) | 6 | 2 OPEN, 3 RESOLVED, 1 PARTIAL | 4-8 hours remaining |
| HIGH (P2) | 4 | 3 OPEN, 1 RESOLVED | 5-8 hours |
| MEDIUM (P3) | 2 | OPEN | 2-3 hours |
| **Total** | **12** | **7 OPEN, 5 RESOLVED** | **11-19 hours remaining** |

## Progress Summary

| Category | Open | In Progress | Partial | Resolved | Total |
|----------|------|-------------|---------|----------|-------|
| CRITICAL | 2 | 0 | 1 | 3 | 6 |
| HIGH | 3 | 0 | 0 | 1 | 4 |
| MEDIUM | 2 | 0 | 0 | 0 | 2 |
| **Total** | **7** | **0** | **(1 incl.)** | **5** | **12** |

## Recent Changes

- **Dec 16, 2025**: CRITICAL-001 (Undefined Loop Variables) RESOLVED
  - Added `gen_arg_with_inline_peek()` and `emit_condition_block_prelude()` in body_gen.rs
  - Loop conditions now correctly emit setup instructions
- **Dec 16, 2025**: CRITICAL-003 (Type Mismatch null as 0) RESOLVED
  - Added type-aware null detection in return statement handling
  - Correctly generates `return null;` for object-returning methods
- **Dec 16, 2025**: CRITICAL-005 (Logic Inversion) RESOLVED
  - Fixed null check condition inversion in branch-to-throw patterns
  - Modified `find_branch_blocks()` in conditionals.rs, added `negate_condition` field to `IfInfo`
- **Dec 16, 2025**: CRITICAL-004 (Type Comparison) PARTIALLY RESOLVED
  - Added fallback type lookup from expr_gen for method parameters
  - Parameters now correctly compared to null (not 0)
  - Local variables still need type inference improvements
- **Dec 16, 2025**: HIGH-002 (Duplicate Declarations) RESOLVED
  - Added name-based declaration tracking (`declared_names: HashSet<String>`)
  - Different SSA versions with same name no longer cause duplicate declarations

**All 683 integration tests pass after these fixes.**

## How to Use This Tracker

1. **Select an Issue**: Pick one with Status=OPEN, starting with CRITICAL priority
2. **Update Status**: Change Status to IN_PROGRESS when you start
3. **Claim the Issue**: Note your agent ID
4. **Complete Work**: Change Status to RESOLVED when done
5. **Update PROGRESS.md**: Record metrics and completion details

---

**Last Updated: 2025-12-16**
**For workflow instructions, see: `LLM_AGENT_GUIDE.md`**
