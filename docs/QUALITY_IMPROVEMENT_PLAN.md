# Implementation Plan: Close Quality Gap Between Rust JADX and Java JADX

## Goal

Improve Rust JADX (dexterity) output to match Java JADX quality for `badboy.apk`, focusing on the `MainActivity` decompilation differences.

## Current State vs Target

**Java JADX Output (Target):**
- ✅ Full import statements
- ✅ Correct constructor with field initializations
- ✅ Meaningful variable names (`aVar`, `z5`, `str`, `th`)
- ✅ Type-aware conditions (`if (mainActivity == null)`)
- ✅ Type casts and annotations
- ✅ Rename/warning comments

**Rust JADX Output (Current):**
- ❌ No import statements
- ❌ Broken constructor (empty/nonsensical)
- ❌ Generic variable names (`v0`, `i`, `i2`)
- ❌ Wrong conditions (`if (mainActivity == 0)`)
- ❌ Missing type casts
- ❌ No comments

## Root Cause Analysis

1. **Missing Imports:** Import collection from method bodies is commented out (working code disabled)
2. **Variable Naming:** Sophisticated naming pass exists but isn't used; simple fallback runs instead
3. **Constructor:** No fallback for `super()` calls in constructors (assumes `new-instance` always exists)
4. **Conditions:** Type information not used when generating comparisons
5. **Comments:** No infrastructure exists (larger project, defer to later)

## Implementation Strategy

### Phase 1: Critical Fixes (Day 1 - ~5 hours)

These fixes have maximum impact with minimal risk and will bring output to 80%+ parity.

#### Fix 1: Enable Import Collection (5 minutes)

*   **Impact:** HIGH
*   **Risk:** NONE
*   **Effort:** TRIVIAL
*   **File:** `crates/jadx-codegen/src/class_gen.rs` (Lines: 290-293)

**Action:** Uncomment the import collection code:

```rust
// DELETE THESE COMMENT MARKERS:
// TEMPORARILY DISABLED TO TEST
// if let Some(instructions) = method.instructions() {
//     self.collect_from_instructions(instructions, dex_info);
// }

// RESULT:
if let Some(instructions) = method.instructions() {
    self.collect_from_instructions(instructions, dex_info);
}
```

**Why This Works:** The `collect_from_instructions` method already correctly extracts types from method bodies (invoke, field access, new-instance, casts). It's fully implemented and just needs to be enabled.

**Test:** After change, `MainActivity.java` should show proper import statements for all types used in method bodies.

---

#### Fix 2: Constructor super() Call Fallback (2 hours)

*   **Impact:** HIGH
*   **Risk:** LOW
*   **Effort:** MEDIUM
*   **File:** `crates/jadx-codegen/src/body_gen.rs` (Lines: 2073-2154)

**Problem:** Constructor handling assumes `new-instance` precedes `invoke-direct <init>`. In constructors, the object is `this`, so no `new-instance` exists. Result: `super()` calls are silently dropped.

**Action:** Add fallback logic after the pending `new-instance` block (after line 2153):

```rust
} else {
    // Fallback: No pending new-instance means this is a super()/this() call in a constructor
    // The object being initialized is 'this', not a newly created object
    if let Some(method_info) = ctx.expr_gen.get_method_value(*method_idx) {
        if method_info.method_name == "<init>" {
            let recv_expr = ctx.expr_gen.gen_arg(&InsnArg::Register(*recv_reg));

            // Build argument list (skip receiver which is first arg)
            let arg_strs: Vec<_> = args.iter()
                .skip(1)
                .map(|a| ctx.gen_arg_inline(a))
                .collect();

            // Emit: super.methodName(args) or this.methodName(args)
            code.start_line();
            code.add(&recv_expr).add(".").add(&method_info.method_name)
                .add("(").add(&arg_strs.join(", ")).add(");");
            code.newline();

            return true;
        }
    }
}
```

**Why This Works:** Detects when `invoke-direct <init>` occurs without a pending `new-instance`, indicating a constructor's `super()`/`this()` call, and emits it directly.

**Test:** `MainActivity` constructor should show field initializations and `super()` calls instead of empty/broken body.

---

#### Fix 3: Use Sophisticated Variable Naming (3 hours)

*   **Impact:** HIGH
*   **Risk:** MEDIUM
*   **Effort:** MEDIUM
*   **Files:**
    *   `crates/jadx-codegen/src/body_gen.rs` (lines 640-641, add helper ~line 780)
    *   `crates/jadx-passes/src/var_naming.rs` (already correct, just use it)

**Problem:** Two variable naming implementations exist:
1.  `jadx-passes/var_naming.rs` - JADX-compatible with `OBJ_ALIAS` mappings (CORRECT, runs in pipeline)
2.  `body_gen.rs:generate_var_names()` - Simple type-based naming (WRONG, actually used)

The pipeline already calls `assign_var_names()` and produces `VarNamingResult`, but code generation ignores it.

**Action 1:** Modify body generation to use the pass results (`body_gen.rs` ~line 579):

```rust
// Around line 640-641, REPLACE:
apply_inferred_types(&mut ctx);
generate_var_names(&mut ctx);

// WITH:
// Use sophisticated variable naming from jadx-passes (JADX-compatible)
let first_param_reg = method.regs_count.saturating_sub(method.ins_count);
let num_params = method.arg_types.len() as u16;
let var_names = jadx_passes::assign_var_names(&ssa_result, &type_result, first_param_reg, num_params);

apply_inferred_types(&mut ctx);
apply_var_names_from_pass(&var_names, &mut ctx);
```

**Action 2:** Add helper function (around line 780):

```rust
/// Apply variable names from jadx-passes var_naming result (JADX-compatible)
fn apply_var_names_from_pass(var_names: &jadx_passes::VarNamingResult, ctx: &mut BodyGenContext) {
    for ((reg, version), name) in &var_names.names {
        ctx.expr_gen.set_var_name(*reg, *version, name.clone());
    }
}
```

**Action 3:** Remove or comment out the old `generate_var_names()` function call (it's now replaced).

**Why This Works:** The `jadx-passes` implementation already matches Java JADX's `OBJ_ALIAS` mappings (`String`→`str`, `Throwable`→`th`, etc.). We're just using it instead of the simple fallback.

**Test:** Variable names should change from `v0`/`obj`/`i` to `aVar`/`str`/`th`/`z5` matching Java JADX patterns.

---

### Phase 2: Quality Enhancements (Day 2 - ~4 hours)

#### Fix 4: Type-Aware Condition Generation (4 hours)

*   **Impact:** MEDIUM
*   **Risk:** MEDIUM
*   **Effort:** MEDIUM
*   **File:** `crates/jadx-codegen/src/body_gen.rs` (Lines: 1008-1084)

**Problem:** Conditions are generated without checking operand types:
- Objects compared to `0` instead of `null`
- Booleans not simplified (`x == 0` instead of `!x`)

**Action:** Enhance `generate_condition()` to look up types:

```rust
// Around line 1018, in generate_condition, MODIFY the If instruction handling:

if let InsnType::If { condition: _, left, right, .. } = &insn.insn_type {
    let left_str = ctx.expr_gen.gen_arg(left);

    // NEW: Get type of left operand
    let left_type = if let InsnArg::Register(reg) = left {
        ctx.type_info.as_ref()
            .and_then(|ti| ti.types.get(&(reg.reg_num, reg.ssa_version)))
            .cloned()
    } else {
        None
    };

    let is_zero_compare = right.is_none() || matches!(right, Some(r) if is_zero_literal(r));

    if is_zero_compare {
        let effective_op = if *negated { negate_op(op) } else { *op };

        // NEW: Check type to decide comparison format
        let is_object = matches!(left_type, Some(ArgType::Object(_)) | Some(ArgType::Array(_)));
        let is_boolean = matches!(left_type, Some(ArgType::Boolean));

        match effective_op {
            IfCondition::Eq => {
                if is_object {
                    return format!("{} == null", left_str);
                } else if is_boolean {
                    return format!("! পান", wrap_if_complex(&left_str));
                } else {
                    return format!("{} == 0", left_str);
                }
            }
            IfCondition::Ne => {
                if is_object {
                    return format!("{} != null", left_str);
                } else if is_boolean {
                    return left_str;
                } else {
                    return format!("{} != 0", left_str);
                }
            }
            // ... rest of cases unchanged
        }
    }
    // ... rest of function
}
```

**Why This Works:** Type inference has already run and stored type information. We just need to look it up and use it when formatting conditions.

**Test:** Conditions should show `if (mainActivity == null)` instead of `if (mainActivity == 0)` and `if (flag)` instead of `if (flag != 0)`.

---

### Phase 3: Polish (Future - ~12-16 hours)

**Deferred:** Comment system infrastructure
- Rename reason comments
- Warning comments for type inference failures
- Debug comments (loaded from `classes.dex`)

**Rationale:** Comments improve readability but don't affect code correctness. Focus on making code work first, add comments as enhancement later.

---

## Testing Strategy

**After Each Fix:**

```bash
cd crates
cargo build --release
./target/release/dexterity ../decompilation-reference-jadx-java/badboy-x86.apk -d /tmp/rust-out

# Compare with reference
diff -u ../test-reference/MainActivity-jadx-java.java \
        /tmp/rust-out/com/topjohnwu/magisk/ui/MainActivity.java | head -100
```

**Success Metrics:**
- After Fix 1: Import statements present
- After Fix 2: Constructor has field initializations, not empty
- After Fix 3: Variable names match JADX patterns (`aVar`, `str`, `th`, `z5`)
- After Fix 4: Conditions use `== null` for objects

**Overall Goal:** < 50 lines of diff with Java JADX output (down from ~300 currently)

**Regression Testing:**
Run on multiple APKs:
```bash
cargo test --workspace  # All unit tests must pass
./target/release/dexterity ../decompilation-reference-jadx-java/badboy-x86.apk -d /tmp/test1
./target/release/dexterity ../jadx-fast/jadx-cli/src/test/resources/samples/small.apk -d /tmp/test2
```

