# JADX Simplification & Optimization Passes Reference

This document provides implementation-level detail of JADX's simplification and optimization visitors for building a 1:1 clone in Rust.

## Overview

JADX applies multiple optimization passes to improve decompiled code quality:

| Visitor | Purpose |
|---------|---------|
| SimplifyVisitor | Expression simplification |
| ModVisitor | Instruction modification & replacement |
| CodeShrinkVisitor | Variable inlining |
| TernaryMod | Ternary operator reconstruction |
| ConstInlineVisitor | Constant inlining |
| PrepareForCodeGen | Final cleanup |

---

## SimplifyVisitor - Expression Simplification

**File:** `dex/visitors/SimplifyVisitor.java` (638 lines)

### Purpose

Core expression simplification pass that processes individual instructions.

### Arithmetic Simplification

```
c + (-1)     ->  c - 1        (negative literal optimization)
bool XOR 0   ->  bool         (boolean XOR simplification)
bool XOR 1   ->  NOT bool
```

### String Operations

**StringBuilder Optimization:** Detects and converts chains of `StringBuilder.append()` calls to `STR_CONCAT` synthetic instructions.

Handles both patterns:
- **Inline chains:** `new StringBuilder(xxx).append(yyy).toString()`
- **Variable chains:** `sb = new StringBuilder(...); sb.append(...); str = sb.toString();`

**String Constructor Optimization:** Converts `String(byte[])` and `String(char[])` to literal strings when possible. Reconstructs strings from filled arrays when printable character ratio is high.

### Cast Optimization

- Removes unnecessary CAST instructions when types don't differ
- Detects duplicate casts and replaces with MOVE
- Handles cast shadowing (nested casts that can be optimized)
- Preserves EXPLICIT_CAST flag for null values

### Condition Simplification

```
if (cmp_l(a, b) == 0)  ->  if (a == b)   (CMP simplification)
```

Simplifies ternary conditions using IfCondition.simplify().

### Integration with CodeShrinkVisitor

- Triggers code shrinking when modifications are made
- Iteratively applies shrinking if instructions were removed

---

## ModVisitor - Instruction Modification & Replacement

**File:** `dex/visitors/ModVisitor.java` (634 lines)

### Annotation

```java
@JadxVisitor(
    name = "ModVisitor",
    desc = "Modify method instructions",
    runBefore = { CodeShrinkVisitor.class, ProcessVariables.class }
)
```

### Purpose

Modify instructions before code shrinking (mid-pipeline optimization).

### Three-Step Process

**Step 1: Replace Instructions**
- **Const Replacement**: Replaces constant values with static field references (CONST/CONST_STR/CONST_CLASS -> SGET)
- **Switch Key Replacement**: Replaces literal keys with const field references
- **Array Initialization Fusion**: Combines NEW_ARRAY + FILL_ARRAY into FILLED_NEW_ARRAY
  - Validates array sizes match between NEW_ARRAY size arg and FILL_ARRAY data size
- **Boolean Cast Conversion**: Converts `(boolean to primitive)` casts to ternary operators
  - `(boolean as int)` -> `bool ? 1 : 0`
  - Special handling for DOUBLE/FLOAT with bit conversions

**Step 2: Remove Instructions**
- Removes NOP, GOTO, NEW_INSTANCE
- Removes instructions marked with AFlag.REMOVE
- Clears exception move instructions when unused

**Step 3: Iterative Remove**
- Iteratively removes dead MOVE instructions with unused results
- Continues until no more dead code is found

### Additional Features

- **Field Visibility Handling**: Inserts casts when field is not visible from use site
- **Anonymous Constructor Processing**: Marks arguments as final and forbids inlining
- **CMP Inlining**: Inlines CMP instructions into IF conditions to help with condition merging

---

## CodeShrinkVisitor - Variable Inlining

**File:** `dex/visitors/shrink/CodeShrinkVisitor.java` (299 lines)

### Annotation

```java
@JadxVisitor(
    name = "CodeShrinkVisitor",
    desc = "Inline variables to make code smaller",
    runAfter = { ModVisitor.class }
)
```

### Purpose

Inline single-use variables and simplify MOVEs for code size reduction.

### Inlining Strategy

**Safety Checks:**
1. Variable has exactly 1 use (or forced inline via AFlag.FORCE_ASSIGN_INLINE)
2. Not marked with DONT_INLINE
3. Assignment instruction not marked with DONT_INLINE or WRAPPED
4. Variable not used in PHI nodes (unless forced)
5. If variable is named, verify it's safe to inline (check for duplicates)
6. Lambda inlining restrictions: can't inline lambda as instance argument to invoke

### Movement Between Blocks

- Verifies path exists between assignment and use blocks
- Checks instruction reordering is safe (no side effects in between)
- Validates no synchronization boundary crossing
- Uses BitSet to track register usage conflicts

### Implementation Details (ArgsInfo class)

- Tracks inline borders and dependency chains
- Manages wrapped/nested instructions
- Enforces instruction ordering constraints via canReorder() checks

### MOVE Simplification

- Replaces `move r, (wrapped_insn)` with unwrapped instruction directly
- Applies metadata inheritance from MOVE to actual instruction

---

## TernaryMod - Ternary Operator Reconstruction

**File:** `dex/visitors/regions/TernaryMod.java` (352 lines)

### Purpose

Converts IF regions to ternary operations for cleaner code.

### Two-Phase Execution

1. **Initial Pass**: Convert all possible ternary nodes
2. **Iterative Pass**: Repeated runs with code shrinking after each conversion

### Ternary Patterns Recognized

**Pattern 1: Assignment in both branches**
```java
// Before:
if (condition) {
    r = thenValue;
} else {
    r = elseValue;
}

// After:
r = condition ? thenValue : elseValue;
```

**Pattern 2: Return from both branches**
```java
// Before:
if (condition) {
    return thenValue;
} else {
    return elseValue;
}

// After:
return condition ? thenValue : elseValue;
```

**Pattern 3: Single-branch assignment (constructors)**
```java
// Before:
if (condition) {
    r = value;
}

// After:
r = condition ? value : r;
```
(Used in constructors to help move super() calls to top)

### Constraints

- Else-if chains are excluded (AFlag.ELSE_IF_CHAIN)
- Line hints verification (can disable nested ternaries for readability)
- Phi node dependency verification
- Source line tracking for better debugging

### Integration

- Calls CodeShrinkVisitor after each transformation
- Respects source line hints for code style

---

## Boolean Simplification & Condition Optimization

**File:** `dex/regions/conditions/IfCondition.java`

### Simplification Rules (IfCondition.simplify())

**Boolean Comparisons:**
```
(a & b) == 0    ->  a == 0 && b == 0
(a & b) != 0    ->  a != 0 || b != 0
(a | b) == 1    ->  a == 1 || b == 1
(a | b) != 1    ->  a != 1 && b != 1
```

**Double Negation Removal:**
```
!!condition     ->  condition
NOT NOT cond    ->  cond
```

**CMP Simplification:**
```
cmp_l(a, b) == 0    ->  a == b
cmp_g(a, b) == 0    ->  a == b
(a == false)        ->  NOT a
```

**Mode Inversion (De Morgan's Law):**
```
!(a AND b)      ->  !a OR !b
!(a OR b)       ->  !a AND !b
```

**Ternary Optimization:**
```
NOT (a ? b : c) ->  a ? NOT b : NOT c
```

**Negation Count Heuristic:**
- If more than 50% of arguments are negated, invert the entire condition
- Improves readability: `!(a || b || c)` becomes `!a && !b && !c`

---

## Constant Inlining & Folding

**File:** `dex/visitors/ConstInlineVisitor.java` (307 lines)

### Annotation

```java
@JadxVisitor(
    name = "Constants Inline",
    desc = "Inline constant registers into instructions",
    runAfter = { SSATransform.class, MarkFinallyVisitor.class },
    runBefore = TypeInferenceVisitor.class
)
```

### Constant Types

- CONST (literals)
- MOVE (with literal arg)
- CONST_STR (string literals)
- CONST_CLASS (class references)

### Inlining Restrictions

Prevents null inlining in dangerous contexts:
- Instance argument to INVOKE
- Array index/length operations
- Field access base
- Switch operand
- Monitor enter/exit
- instanceof operand

Forbids inlining of variables used in finally blocks.

### Optimization

- Replaces constant with SGET reference if it matches a class const field
- Adds explicit type casting for non-int constants
- Handles BYTE type specially (EXPLICIT_PRIMITIVE_TYPE flag)
- Hides const instruction if used only in DONT_GENERATE marked instructions

---

## Array Initialization Optimization

**Locations:** ModVisitor (`makeFilledArrayInsn()`) and ProcessInstructionsVisitor

### Pattern: NEW_ARRAY + FILL_ARRAY Fusion

```java
// Original bytecode:
r0 = new int[3];        // NEW_ARRAY
fill-array-data r0, [1, 2, 3]  // FILL_ARRAY

// Optimized to:
r0 = [1, 2, 3];         // FILLED_NEW_ARRAY
```

### Process

1. Detect NEW_ARRAY followed by FILL_ARRAY (via SSA use-chain)
2. Verify array sizes match
3. Extract literal values from fill-array-data instruction
4. Create FILLED_NEW_ARRAY with all elements
5. Replace const field references in array elements with SGET instructions
6. Remove FILL_ARRAY instruction

### Type Handling

```java
ArgType insnArrayType = newArrayNode.getArrayType();
ArgType insnElementType = insnArrayType.getArrayElement();
ArgType elType = insn.getElementType();

// Handle type unknowns and primitives
if (!elType.isTypeKnown() && insnElementType.isPrimitive() &&
    elType.contains(insnElementType.getPrimitiveType())) {
    elType = insnElementType;
}

// Validate and report mismatches
```

---

## StringBuilder Optimization

### Pattern Recognition & Conversion

**Inline Pattern:**
```java
// Original:
"result " + value + " text"

// Decompiled to:
new StringBuilder().append("result ").append(value).append(" text").toString()

// Optimized to:
"result " + value + " text"  // Using STR_CONCAT
```

**Variable Pattern:**
```java
// Original:
StringBuilder sb = new StringBuilder(init);
sb.append(a);
sb.append(b);
String result = sb.toString();

// Optimized to:
String result = init + a + b;  // STR_CONCAT
```

### Constant Concatenation

Consecutive constant arguments are pre-concatenated:
```java
"a" + "b" + x + "c" + "d"  ->  "ab" + x + "cd"
```

### Implementation (SimplifyVisitor.convertStringBuilderChain)

1. Flatten instruction chain via SSA uses
2. Extract all append arguments
3. Verify at least one string argument exists
4. Create STR_CONCAT synthetic instruction
5. Remove all StringBuilder instructions and rebind args

---

## Code Cleanup & Normalization

### PrepareForCodeGen Visitor (Final Pre-Codegen Pass)

**Instruction Removal:**
- NOP instructions
- MONITOR_ENTER/EXIT (synchronized handling)
- MOVE_EXCEPTION (exception variable binding)
- Self-constructor calls
- Dead MOVE instructions: `unused_result = unused_result;`

**Inline Checks:**
- Replace MOVE wrapping another instruction with the inner instruction directly
- Example: `move r, (add r1, r2)` -> `r = r1 + r2;`

**Arithmetic Modification:**
- Simplify one-argument arithmetic to compound assignments
- Example: `r = r + 1;` -> `r += 1;`

**Null Cast Addition:**
- Inserts explicit casts for null values in type-sensitive contexts

**Const Usage Check:**
- Adds explicit type information for non-int constants
- Special handling for LONG and FLOAT types (bit representations)

---

## Execution Pipeline

### Order of Execution

```
SimplifyVisitor (expression simplification)
    |
    v
ModVisitor (instruction replacement & removal)
    |
    v
CodeShrinkVisitor (variable inlining)
    |
    v
ConstInlineVisitor (constant inlining)
    |
    v
TernaryMod (ternary reconstruction - iterative)
    |
    v
PrepareForCodeGen (final cleanup)
    |
    v
CodeGeneration
```

### Key Dependencies

- ModVisitor runs **BEFORE** CodeShrinkVisitor
- CodeShrinkVisitor triggered after SimplifyVisitor modifications
- ConstInlineVisitor runs **BEFORE** TypeInferenceVisitor
- PrepareForCodeGen runs **AFTER** CodeShrinkVisitor
- TernaryMod is iterative (runs multiple passes with shrinking)

---

## Pattern Examples for Rust Implementation

### Arithmetic Constant Folding

```rust
// SimplifyVisitor.simplifyArith()
fn simplify_arith(insn: &mut ArithInsn) {
    match insn.op {
        ArithOp::Add if is_negative_literal(&insn.arg_b) => {
            insn.op = ArithOp::Sub;
            insn.arg_b = negate_literal(&insn.arg_b);
        }
        ArithOp::Xor if is_boolean(&insn.arg_a) => {
            if is_literal_zero(&insn.arg_b) {
                // XOR 0 -> MOVE
                convert_to_move(insn);
            } else if is_literal_one(&insn.arg_b) {
                // XOR 1 -> NOT
                convert_to_not(insn);
            }
        }
        _ => {}
    }
}
```

### Dead Code Removal

```rust
// ModVisitor.iterativeRemoveStep() + CodeShrinkVisitor
fn remove_dead_code(method: &mut MethodNode) {
    loop {
        let mut changed = false;

        // Remove MOVE instructions with unused results
        for block in &mut method.blocks {
            block.instructions.retain(|insn| {
                if insn.is_move() && insn.result_unused() {
                    changed = true;
                    false
                } else {
                    true
                }
            });
        }

        // Remove constants with all uses in DONT_GENERATE
        for block in &mut method.blocks {
            for insn in &mut block.instructions {
                if insn.is_const() && all_uses_dont_generate(insn) {
                    insn.add_flag(AFlag::DontGenerate);
                    changed = true;
                }
            }
        }

        if !changed { break; }
    }
}
```

### Expression Simplification

```rust
// SimplifyVisitor patterns
fn simplify_expression(insn: &mut InsnNode) -> bool {
    match insn.insn_type {
        // String concatenation chains -> STR_CONCAT
        InsnType::Invoke if is_string_builder_chain(insn) => {
            convert_to_str_concat(insn)
        }

        // String constructor with byte[] -> ConstStringNode
        InsnType::Invoke if is_string_from_bytes(insn) => {
            try_convert_to_string_literal(insn)
        }

        // CHECK_CAST with compatible types -> MOVE
        InsnType::CheckCast if types_compatible(insn) => {
            convert_to_move(insn)
        }

        // Nested casts where inner is subclass of outer -> remove inner
        InsnType::CheckCast if has_redundant_inner_cast(insn) => {
            remove_inner_cast(insn)
        }

        _ => false
    }
}
```

### Condition Optimization

```rust
// IfCondition.simplify() patterns
fn simplify_condition(cond: &mut IfCondition) {
    // De Morgan's laws for NOT (AND/OR)
    if let IfCondition::Not(inner) = cond {
        match inner.as_mut() {
            IfCondition::And(args) => {
                // NOT (a AND b) -> NOT a OR NOT b
                *cond = IfCondition::Or(
                    args.iter().map(|a| IfCondition::Not(Box::new(a.clone()))).collect()
                );
            }
            IfCondition::Or(args) => {
                // NOT (a OR b) -> NOT a AND NOT b
                *cond = IfCondition::And(
                    args.iter().map(|a| IfCondition::Not(Box::new(a.clone()))).collect()
                );
            }
            _ => {}
        }
    }

    // CMP instruction unwrapping
    if let IfCondition::Compare(cmp) = cond {
        if cmp.is_cmp_to_zero() {
            *cond = unwrap_cmp_condition(cmp);
        }
    }

    // Boolean comparisons to true/false
    if let IfCondition::Compare(cmp) = cond {
        if cmp.is_bool_compare_to_literal() {
            *cond = simplify_bool_compare(cmp);
        }
    }

    // Double negation elimination
    if let IfCondition::Not(inner) = cond {
        if let IfCondition::Not(inner_inner) = inner.as_ref() {
            *cond = inner_inner.as_ref().clone();
        }
    }
}
```

---

## Key Files Summary

| File | Lines | Purpose |
|------|-------|---------|
| `SimplifyVisitor.java` | 638 | Expression simplification |
| `ModVisitor.java` | 634 | Instruction modification |
| `CodeShrinkVisitor.java` | 299 | Variable inlining |
| `TernaryMod.java` | 352 | Ternary reconstruction |
| `IfCondition.java` | 364 | Condition simplification |
| `ConstInlineVisitor.java` | 307 | Constant inlining |
| `TernaryInsn.java` | 110 | Ternary instruction |
| `PrepareForCodeGen.java` | ~200 | Final cleanup |

---

## Rust Implementation

### Core Structures

```rust
pub struct SimplifyVisitor;

impl Visitor for SimplifyVisitor {
    fn visit_method(&mut self, method: &mut MethodNode) {
        let mut changed = true;
        while changed {
            changed = false;
            for block in &mut method.blocks {
                for insn in &mut block.instructions {
                    changed |= self.simplify_insn(insn);
                }
            }
            if changed {
                CodeShrinkVisitor::shrink(method);
            }
        }
    }
}

pub struct CodeShrinkVisitor;

impl CodeShrinkVisitor {
    pub fn shrink(method: &mut MethodNode) {
        for var in method.get_ssa_vars() {
            if Self::can_inline(&var) {
                Self::inline_var(method, &var);
            }
        }
    }

    fn can_inline(var: &SSAVar) -> bool {
        var.use_count() == 1
            && !var.has_flag(AFlag::DontInline)
            && !var.assign.insn.has_flag(AFlag::DontInline)
            && !var.used_in_phi()
    }
}

pub struct TernaryMod;

impl TernaryMod {
    pub fn process(region: &mut Region) -> bool {
        let mut changed = true;
        while changed {
            changed = Self::process_once(region);
            if changed {
                CodeShrinkVisitor::shrink_region(region);
            }
        }
        changed
    }

    fn process_once(region: &mut Region) -> bool {
        // Find if-regions that can be converted to ternary
        // ...
    }
}
```

### Visitor Order

```rust
pub fn optimize_method(method: &mut MethodNode) {
    // Phase 1: Simplify expressions
    SimplifyVisitor.visit_method(method);

    // Phase 2: Modify and replace instructions
    ModVisitor.visit_method(method);

    // Phase 3: Shrink code (inline variables)
    CodeShrinkVisitor::shrink(method);

    // Phase 4: Inline constants
    ConstInlineVisitor.visit_method(method);

    // Phase 5: Build regions and convert to ternary
    let regions = build_regions(method);
    TernaryMod::process(&mut regions);

    // Phase 6: Final cleanup
    PrepareForCodeGen.visit_method(method);
}
```
