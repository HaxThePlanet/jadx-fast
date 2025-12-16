# Issue Tracker: Dexterity JADX Parity Issues

This tracker contains structured issues for autonomous agents working toward JADX parity.
See `LLM_AGENT_GUIDE.md` for workflow instructions.

---

## CRITICAL Issues (P1) - Blocks Production Use

These prevent code compilation or execution. Fix these first.

### Issue ID: CRITICAL-001

**Status:** OPEN
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

**Expected Output (JADX):**
```java
for (int i = 0; i < jSONArray.length(); i++) {
    arrayList.add(GetProductDefinition(jSONArray.getJSONObject(i)));
}
```

**Actual Output (Dexterity):**
```java
int i;  // declared but uninitialized
while (i < i2) {  // i2 is UNDEFINED!
    v3.add(StoreDeserializer.GetProductDefinition(...));
    i++;
}
```

**Root Cause:**

Control flow analysis in loop counter resolution failing to properly track loop bounds through SSA variables. The loop index counter `i` and loop bound `i2` are likely both SSA variables, but the SSA variable tracking or constraint solving isn't properly connecting them.

**Relevant Code Areas:**

- `/mnt/nvme4tb/jadx-rust/crates/dexterity-passes/src/region_builder.rs` (64,921 lines)
  - Function: `build_loop_region()` (lines ~1000-1200) - Loop region construction
  - Function: `find_loop_merge()` (lines ~800-900) - Loop exit detection
  - Variable scope tracking throughout

- `/mnt/nvme4tb/jadx-rust/crates/dexterity-passes/src/cfg.rs` (21,245 lines)
  - Function: `build_cfg()` - Control flow graph construction
  - Function: `compute_successors()` - Block successor calculation

- `/mnt/nvme4tb/jadx-rust/crates/dexterity-passes/src/ssa.rs` (34,239 lines)
  - Function: `transform_to_ssa()` - SSA variable versioning
  - Structure: `PhiNode` - Variable at join points

**JADX Reference:**

- File: `/mnt/nvme4tb/jadx-rust/jadx-fast/jadx-core/src/main/java/jadx/core/dex/visitors/regions/RegionMaker.java`
  - Look for: `createLoopRegion()` method
  - Look for: Loop boundary detection logic
  - Pattern: How JADX resolves loop counter variables through SSA

- File: `/mnt/nvme4tb/jadx-rust/jadx-fast/jadx-core/src/main/java/jadx/core/dex/visitors/ssa/SSATransform.java`
  - Pattern: How SSA variables are versioned through loop boundaries

**Test Strategy:**

1. Write integration test with for-loop that has:
   - Loop counter `i`
   - Loop bound based on method call result (`.length()`)
   - Complex control flow

2. Run existing loop tests:
   ```bash
   cargo test loop
   cargo test --test integration_test_framework loops
   ```

3. Run QA tool on medium APK sample to see if fix improves compilation metrics

4. Test edge cases:
   - Loop with constant bounds: `for (int i = 0; i < 10; i++)`
   - Loop with field bounds: `for (int i = 0; i < this.size; i++)`
   - Nested loops: Loop inside loop
   - While loops with complex condition

**Test Code Example:**
```rust
#[test]
fn test_loop_bounds_defined() {
    let java_code = r#"
        public class Test {
            void process(String[] items) {
                for (int i = 0; i < items.length; i++) {
                    System.out.println(items[i]);
                }
            }
        }
    "#;

    test_java_to_java(java_code, |decompiled| {
        // Verify no undefined loop variables
        assert!(!decompiled.contains("i2"));
        assert!(!decompiled.contains("v"), "Should not have register variables");

        // Verify correct loop structure
        assert!(decompiled.contains("for") || decompiled.contains("while"));
        assert!(decompiled.contains("items.length"));
    });
}
```

**Acceptance Criteria:**

- [ ] No undefined variables in generated code
- [ ] All loop bounds properly resolved and defined
- [ ] All existing tests continue to pass
- [ ] New test passes
- [ ] Decompiled code compiles without errors
- [ ] Quality metrics improve (especially for medium/large APKs)

**Implementation Notes:**

- Start by understanding how loop regions are built
- Trace through an example: `for (int i = 0; i < arr.length; i++)`
- Check how loop counter and bound are tracked through SSA
- Look for places where variables aren't properly propagated
- Consider: Is the issue in SSA transformation, region building, or code generation?

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

**Status:** OPEN
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

**Expected Output (JADX):**
```java
public static List<ProductDefinition> DeserializeProducts(String str) {
    try {
        JSONArray jSONArray = new JSONArray(str);
        // ...
        return arrayList;
    } catch (JSONException e) {
        throw new RuntimeException(e);
    }
}
```

**Actual Output (Dexterity):**
```java
public static List<ProductDefinition> DeserializeProducts(String str) {
    try {
        // ...
        return arrayList;
    } catch (JSONException e) {
        throw new RuntimeException(str);  // Wrong: str instead of e
    }
}
// OR elsewhere:
return 0;  // Wrong: should be null for List<ProductDefinition> return type
```

**Root Cause:**

Type inference not properly tracking return type through exception handlers or complex control flow. Default value selection wrong (0 vs null).

**Relevant Code Areas:**

- `/mnt/nvme4tb/jadx-rust/crates/dexterity-passes/src/type_inference.rs` - Type constraint solving
- `/mnt/nvme4tb/jadx-rust/crates/dexterity-codegen/src/body_gen.rs` - Return statement generation
- `/mnt/nvme4tb/jadx-rust/crates/dexterity-ir/src/types.rs` - Type system

**Acceptance Criteria:**

- [ ] All return statements match method return type
- [ ] Null used for reference types, not 0
- [ ] Exception handling preserves correct types
- [ ] Tests pass
- [ ] Metrics improve

---

### Issue ID: CRITICAL-004

**Status:** OPEN
**Priority:** P1 (CRITICAL)
**Category:** Type Mismatch (Comparison)
**Impact:** Type error, won't compile
**Estimated Complexity:** Medium (2-4 hours)
**Affected APKs:** Medium, Large

**Description:**

String variable compared to integer constant: `if (v6 == 0)` where `v6` is String.

**Example Location:**

File: `com/twitter/sdk/android/tweetcomposer/ComposerActivity.java`
Line: 85 in decompiled output

**Expected Output (JADX):**
```java
if (authToken != null) {
    // use authToken
}
```

**Actual Output (Dexterity):**
```java
String v6 = ...;
if (v6 == 0) {  // Type mismatch: String compared to int!
    // ...
}
```

**Root Cause:**

Type inference not properly tracking variable types through assignments and conditionals. String type lost somewhere in the analysis chain.

**Relevant Code Areas:**

- `/mnt/nvme4tb/jadx-rust/crates/dexterity-passes/src/type_inference.rs` - Constraint generation for comparisons
- `/mnt/nvme4tb/jadx-rust/crates/dexterity-passes/src/ssa.rs` - Type tracking through SSA variables
- `/mnt/nvme4tb/jadx-rust/crates/dexterity-codegen/src/expr_gen.rs` - Comparison expression generation

**Acceptance Criteria:**

- [ ] No type mismatches in conditionals
- [ ] String variables not compared to integers
- [ ] Object types not compared to primitives
- [ ] Tests pass

---

### Issue ID: CRITICAL-005

**Status:** OPEN
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

**Actual Output (Dexterity):**
```java
public Builder(Context context) {
    if (context != null) {  // INVERTED! Should be ==
        throw new IllegalArgumentException("Context must not be null");
    }
    this.context = context;
}
```

**Root Cause:**

Condition inversion in decompilation - likely in how conditionals are reconstructed from bytecode jump targets.

**Relevant Code Areas:**

- `/mnt/nvme4tb/jadx-rust/crates/dexterity-passes/src/region_builder.rs` - Conditional region building
- `/mnt/nvme4tb/jadx-rust/crates/dexterity-passes/src/conditionals.rs` - Condition analysis

**Acceptance Criteria:**

- [ ] Null checks produce correct conditions
- [ ] All conditionals match original semantics
- [ ] Tests pass

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

**Status:** OPEN
**Priority:** P2 (HIGH)
**Category:** Duplicate Variable Declarations
**Impact:** Variable shadowing, confusion
**Estimated Complexity:** Medium (2-4 hours)
**Affected APKs:** Medium, Large

**Description:**

Same variable declared multiple times in same scope (shadowing).

**Example:**
```java
boolean str2 = ...;     // Line 64
int str2 = ...;         // Line 65 - duplicate!
boolean str2 = ...;     // Line 66 - duplicate!
```

**Count:** 20+ instances

**Root Cause:**

Scope analysis creating variables in wrong scope or not tracking existing declarations.

**Relevant Code Areas:**

- `/mnt/nvme4tb/jadx-rust/crates/dexterity-passes/src/var_naming.rs` - Scope tracking
- `/mnt/nvme4tb/jadx-rust/crates/dexterity-codegen/src/body_gen.rs` - Variable declaration generation
- `/mnt/nvme4tb/jadx-rust/crates/dexterity-passes/src/ssa.rs` - SSA variable tracking

**Acceptance Criteria:**

- [ ] No duplicate declarations in same scope
- [ ] Proper shadowing only when needed
- [ ] Tests pass

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

| Priority | Count | Status | Total Time Est. |
|----------|-------|--------|-----------------|
| CRITICAL (P1) | 6 | OPEN | 12-20 hours |
| HIGH (P2) | 4 | OPEN | 8-14 hours |
| MEDIUM (P3) | 2 | OPEN | 2-3 hours |
| **Total** | **12** | **OPEN** | **22-37 hours** |

## Progress Summary

| Category | Open | In Progress | Resolved | Total |
|----------|------|-------------|----------|-------|
| CRITICAL | 6 | 0 | 0 | 6 |
| HIGH | 4 | 0 | 0 | 4 |
| MEDIUM | 2 | 0 | 0 | 2 |
| **Total** | **12** | **0** | **0** | **12** |

## How to Use This Tracker

1. **Select an Issue**: Pick one with Status=OPEN, starting with CRITICAL priority
2. **Update Status**: Change Status to IN_PROGRESS when you start
3. **Claim the Issue**: Note your agent ID
4. **Complete Work**: Change Status to RESOLVED when done
5. **Update PROGRESS.md**: Record metrics and completion details

---

**Last Updated: 2025-12-16**
**For workflow instructions, see: `LLM_AGENT_GUIDE.md`**
