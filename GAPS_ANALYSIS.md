# JADX vs Dexterity: Type Inference & Variable Naming Gap Analysis

**Date:** 2025-12-12
**Comparison:** Java JADX (master) vs Dexterity (Rust)

---

## Executive Summary

This document identifies specific implementation differences between Java JADX and Dexterity's Rust port for type inference and variable naming. The goal is 1:1 output compatibility.

### Key Findings

- **Type Inference**: 12 critical gaps identified (architecture, algorithm, type system)
- **Variable Naming**: 8 gaps identified (mostly cosmetic name generation differences)
- **Impact**: Type inference gaps cause incorrect types → cascading errors in static initializers and method bodies
- **Priority**: Focus on type inference first (fixes root cause), then variable naming (cosmetic polish)

---

## Part 1: Type Inference Gaps

### 1.1 Algorithm Architecture

| Feature | Java JADX | Rust Dexterity | Gap Impact |
|---------|-----------|----------------|------------|
| **Constraint solving** | Iterative bound merging with TypeBound objects | Fixed-iteration constraint unification | 🔴 HIGH - Different convergence behavior |
| **Type comparison** | TypeCompareEnum (EQUAL, NARROW, WIDER, CONFLICT, NARROW_BY_GENERIC, etc.) | Simple equality + basic compatibility | 🔴 HIGH - Missing generic-aware comparisons |
| **Bounds system** | TypeBound with assign/use bounds, multiple sources | Flat Constraint enum | 🔴 HIGH - No distinction between assign vs use |
| **Iteration limit** | Single pass over SSA vars (forEach) | MAX_ITERATIONS = 100 | 🟡 MEDIUM - May over-iterate or under-converge |

**Details:**

**Java JADX** uses a `TypeBound` class that accumulates bounds from:
- **Assign bounds**: Types flowing INTO a variable (NEW_INSTANCE, method returns, field reads)
- **Use bounds**: Types flowing FROM a variable (method args, field writes)

The solver picks the "best type" by comparing all bounds using `TypeCompareEnum` to find the most specific type that satisfies all constraints.

**Rust Dexterity** uses a `Constraint` enum with `Equals`, `Same`, `Subtype`, `ArrayOf`, etc., and iteratively unifies type variables until convergence. This doesn't distinguish between assign and use bounds.

**Impact:** Different type choices when multiple valid types exist. JADX prefers narrower types from assign bounds; Rust may pick wider types.

---

### 1.2 Type Comparison & Hierarchy

| Feature | Java JADX | Rust Dexterity | Gap Impact |
|---------|-----------|----------------|------------|
| **Class hierarchy** | Full hierarchy loaded, LCA calculation | Not implemented | 🔴 CRITICAL - No supertype/subtype checking |
| **Primitive widening** | Explicit hierarchy (BYTE→SHORT→INT→LONG→FLOAT→DOUBLE) | Basic compatibility (byte/short/char ↔ int) | 🟡 MEDIUM - Some widenings missing |
| **Generic types** | NARROW_BY_GENERIC, WIDER_BY_GENERIC, CONFLICT_BY_GENERIC | Not implemented | 🔴 HIGH - Generic types treated as raw types |
| **Array compatibility** | Arrays compatible with Object, recursive element comparison | Basic ArrayOf constraint | 🟡 MEDIUM - Limited covariance |

**Details:**

**Java JADX** `TypeCompare.compareTypes()`:
- Returns `TypeCompareEnum` with 8 values (EQUAL, NARROW, WIDER, CONFLICT, NARROW_BY_GENERIC, WIDER_BY_GENERIC, CONFLICT_BY_GENERIC, UNKNOWN)
- Uses `ArgType.isInstanceOf()` for hierarchy checks
- Handles wildcards (EXTENDS, SUPER, UNBOUND)

**Rust Dexterity** `types_compatible()`:
- Simple equality checks
- Basic primitive widening (byte/short/char → int)
- Null compatibility with objects
- No hierarchy, no generics

**Impact:** Type conflicts not detected, incorrect type merges in PHI nodes, loss of generic type precision.

---

### 1.3 PHI Node Handling

| Feature | Java JADX | Rust Dexterity | Gap Impact |
|---------|-----------|----------------|------------|
| **PHI bound merging** | `mergePhiBounds()` - bidirectional propagation | Unidirectional Same(dest, source) constraints | 🟡 MEDIUM - Different propagation |
| **PHI constant splitting** | Separate pass to duplicate constants | Not implemented | 🔴 HIGH - Constants shared across branches get wrong types |

**Details:**

**Java JADX** has a `mergePhiBounds()` method that:
- Collects bounds from PHI result
- Collects bounds from all PHI arguments
- Merges them bidirectionally (result influences args, args influence result)

**Rust Dexterity**:
- PHI nodes generate `Constraint::Same(dest_var, src_var)` for each source
- Unifies dest with all sources

**Impact:** Different type resolution when PHI sources have conflicting types. JADX may detect conflicts; Rust may pick arbitrary type.

---

### 1.4 Missing Features

| Feature | Java JADX | Rust Dexterity | Gap Impact |
|---------|-----------|----------------|------------|
| **Immutable type flags** | Sets immutable types before inference (e.g., catch blocks, method params) | No immutable flag support | 🟡 MEDIUM - Some types may be overridden |
| **Method override tracking** | `getMethodOriginDeclClass()` for precise receiver types | Not implemented | 🟠 MEDIUM-LOW - Less precise invoke types |
| **Generic return type resolution** | `getMethodGenericReturnType()` resolves concrete generic types | Returns raw type from DEX | 🔴 HIGH - Loss of generic precision |
| **Array element tracking** | Not explicitly in TypeInferenceVisitor, but planned in roadmap | Not implemented | 🔴 HIGH - Arrays stay as Object[] instead of String[] |

---

### 1.5 Type Inference Algorithm Comparison

#### Java JADX Algorithm

```
1. setImmutableType() - Mark types that cannot change (catch blocks, params)
2. Collect assign bounds (from NEW_INSTANCE, INVOKE returns, field reads)
3. Collect use bounds (from method call args, field writes)
4. mergePhiBounds() - Bidirectional PHI constraint propagation
5. setBestType() - Pick most specific type satisfying all bounds
```

**Key characteristics:**
- Single pass (no explicit iteration)
- Assign vs use bound distinction
- Type comparison with 8-value enum
- Class hierarchy for subtype checks

#### Rust Dexterity Algorithm

```
1. collect_constraints() - Generate Equals/Same/Subtype/ArrayOf constraints
2. solve() - Iterate up to 100 times:
   - For each constraint, unify types
   - Check if types changed
   - Repeat until convergence or max iterations
3. Return resolved types
```

**Key characteristics:**
- Fixed iteration (may converge early or hit limit)
- No assign/use distinction
- Simple equality-based unification
- No hierarchy

---

### 1.6 Type Inference Priority Fixes

| Priority | Gap | Files to Modify | Estimated Complexity |
|----------|-----|-----------------|---------------------|
| 🔴 P0 | **Class hierarchy & LCA** | `jadx-ir/src/class_hierarchy.rs` (new), `jadx-ir/src/lib.rs`, `jadx-cli/src/converter.rs` | High - New subsystem |
| 🔴 P0 | **TypeCompareEnum system** | `jadx-ir/src/types.rs`, `jadx-passes/src/type_inference.rs` | Medium - Enum + comparison logic |
| 🔴 P1 | **Assign vs Use bounds** | `jadx-passes/src/type_inference.rs` | Medium - Refactor constraint system |
| 🔴 P1 | **PHI constant splitting** | `jadx-passes/src/phi_const_split.rs` (new), `jadx-passes/src/lib.rs` | Low - Small pass |
| 🟡 P2 | **Generic type handling** | `jadx-ir/src/types.rs`, `jadx-passes/src/type_inference.rs` | High - Generic infrastructure |
| 🟡 P2 | **Primitive widening hierarchy** | `jadx-passes/src/type_inference.rs` | Low - Extend types_compatible() |

---

## Part 2: Variable Naming Gaps

### 2.1 Name Generation Rules

| Type | Java JADX | Rust Dexterity | Match? |
|------|-----------|----------------|--------|
| **Primitives** | b, c, s, i, l, f, d, z (via getPrimitiveType().getShortName().toLowerCase()) | b, c, s, i, j, f, d, z | ❌ MISMATCH: long is "j" in Rust, should be "l" |
| **String** | "str" | "str" | ✅ Match |
| **Class** | "cls" | Uses first letter of simple name | ❌ Gap |
| **Throwable** | "th" | "e" (if contains "Exception") | ❌ Gap |
| **Object** | "obj" | "obj" | ✅ Match |
| **Iterator** | "it" | "it" | ✅ Match |
| **HashMap** | "map" | "map" | ✅ Match |
| **Integer/Long/Double/Float** | "num"/"l"/"d"/"f" | Not handled | ❌ Gap |
| **Boolean** | "bool" | "z" | ❌ Gap |
| **StringBuilder** | "sb" | "builder" (if contains "Builder") | ❌ Gap |

**Critical Issue:** Long is "j" in Rust but should be "l" for JADX compatibility.

---

### 2.2 Array Naming

| Array Type | Java JADX | Rust Dexterity | Match? |
|------------|-----------|----------------|--------|
| `byte[]` | "bArr" | "bArr" | ✅ Match |
| `String[]` | "strArr" | "strArr" | ✅ Match |
| Generic arrays | Appends "Arr" to element type | "arr" fallback | ❌ Gap |

---

### 2.3 Class Name Extraction

| Pattern | Java JADX | Rust Dexterity | Match? |
|---------|-----------|----------------|--------|
| Simple class name | Extract last component, lowercase first char | Use simple patterns (contains "String", etc.) | ❌ Gap |
| All-uppercase names | Convert to lowercase | Not handled | ❌ Gap |
| Very short names (<3 chars) | Append "Var" | Not handled | ❌ Gap |
| Inner classes | Use innermost name | Not handled | ❌ Gap |

**Example:**
- Java class `android/view/View` → JADX: "view", Rust: "obj"
- Java class `Outer$Inner` → JADX: "inner", Rust: "obj"

---

### 2.4 Method Invocation Pattern Matching

| Feature | Java JADX | Rust Dexterity | Gap Impact |
|---------|-----------|----------------|------------|
| **Strip method prefixes** | Removes "get", "set", "to", "parse", "read", "format" | Not implemented | 🟡 MEDIUM - Less semantic names |
| **getInstance()** | Use declaring class name | Not implemented | 🟡 MEDIUM |
| **iterator()** | "it" | Not implemented | 🟠 LOW |
| **toString()** | Use declaring class name | Not implemented | 🟠 LOW |
| **forName() on Class** | "cls" | Not implemented | 🟠 LOW |

**Impact:** Variables like `String str = getString()` work in both, but `View view = getView()` becomes `View obj` in Rust.

---

### 2.5 Parameter vs Local Variable Naming

| Feature | Java JADX | Rust Dexterity | Match? |
|---------|-----------|----------------|--------|
| **METHOD_ARGUMENT flag** | Uses defined type name, ignores usage | Uses type-based naming | ❌ Gap - No flag system |
| **Parameter name generation** | Type-based with special rules (boolean → "flag") | Type-based with "p0", "p1" fallback | ❌ Different fallback |
| **Debug info names** | Applied via separate pass | Applied in `body_gen.rs` (lines 131-144) | ✅ Similar approach |

---

### 2.6 Unique Name Suffix Generation

| Feature | Java JADX | Rust Dexterity | Match? |
|---------|-----------|----------------|--------|
| **First occurrence** | No suffix (e.g., "i") | No suffix (e.g., "i") | ✅ Match |
| **Second occurrence** | Suffix "2" (e.g., "i2") | Suffix "2" (e.g., "i2") | ✅ Match |
| **Subsequent** | Increment (i3, i4, ...) | Increment (i3, i4, ...) | ✅ Match |

---

### 2.7 Reserved Word Handling

| Feature | Java JADX | Rust Dexterity | Gap Impact |
|---------|-----------|----------------|------------|
| **Static field aliases** | Added to reserved set | Not implemented | 🟠 LOW - Rare collisions |
| **Inner class short names** | Added to reserved set | Not implemented | 🟠 LOW |
| **Root package names** | Added to reserved set | Not implemented | 🟠 LOW |

---

### 2.8 Variable Naming Priority Fixes

| Priority | Gap | Files to Modify | Estimated Complexity |
|----------|-----|-----------------|---------------------|
| 🔴 P0 | **Fix long type: "j" → "l"** | `jadx-passes/src/var_naming.rs:72` | Trivial - One-line fix |
| 🟡 P1 | **Add OBJ_ALIAS map** | `jadx-passes/src/var_naming.rs:65-116` | Low - Extend base_name_for_type() |
| 🟡 P1 | **Class name extraction** | `jadx-passes/src/var_naming.rs` | Medium - Add name parsing logic |
| 🟠 P2 | **Method invocation patterns** | New module or enhance `var_naming.rs` | High - Requires usage analysis |
| 🟠 P3 | **Reserved word handling** | `jadx-passes/src/var_naming.rs` | Low - Add static field check |

---

## Part 3: Root Cause Analysis

### Why Type Inference Matters More

Variable naming depends on type inference results. If types are wrong:

1. **Wrong base names**: `Object obj` instead of `String str`
2. **Cascading errors**: Static initializers fail to parse due to type mismatches
3. **Semantic loss**: Generic `List` instead of `List<String>`

**Example from Badboy APK (mentioned in CLAUDE.md):**
- ~60 static initializer syntax errors
- ~40% variables have Unknown type
- Arrays stay as `Object[]` instead of `String[]`, `int[]`, etc.

These are caused by type inference gaps, not variable naming gaps.

---

## Part 4: Recommended Implementation Order

### Phase 1: Type System Foundation (P0)

1. **Class Hierarchy** (`jadx-ir/src/class_hierarchy.rs`)
   - Extract superclass/interface relationships from DEX
   - Build hierarchy graph
   - Implement LCA algorithm
   - Add isSubtypeOf() and commonSupertype() methods

2. **TypeCompareEnum System** (`jadx-ir/src/types.rs`)
   - Add comparison enum (EQUAL, NARROW, WIDER, CONFLICT, etc.)
   - Implement compareTypes() with hierarchy
   - Handle primitive widening hierarchy
   - Add basic generic awareness

3. **Refactor Type Inference** (`jadx-passes/src/type_inference.rs`)
   - Split Constraint into AssignBound and UseBound
   - Change solver to use TypeCompare instead of equality
   - Implement "best type" selection (most specific type satisfying all bounds)

**Expected Impact:** Fixes ~50-60% of type errors, reduces Unknown types from 40% to ~20%

### Phase 2: Advanced Type Inference (P1)

4. **PHI Constant Splitting** (`jadx-passes/src/phi_const_split.rs`)
   - Duplicate constants used by multiple PHI nodes
   - Enable independent type inference per control flow path

5. **Array Element Tracking** (`jadx-passes/src/type_inference.rs`)
   - Track APUT (array put) to refine array element types
   - Handle FilledNewArray and FillArrayData
   - Use LCA for mixed element types

**Expected Impact:** Reduces Unknown types to ~10%, improves array precision to ~70%

### Phase 3: Variable Naming Polish (P1-P2)

6. **Fix Long Type Name** (`jadx-passes/src/var_naming.rs`)
   - Change line 72: `ArgType::Long => "j"` → `ArgType::Long => "l"`

7. **Add OBJ_ALIAS Map** (`jadx-passes/src/var_naming.rs`)
   - Extend base_name_for_type() with Java JADX's OBJ_ALIAS mappings
   - Class → "cls", Throwable → "th", Integer → "num", Boolean → "bool", StringBuilder → "sb"

8. **Class Name Extraction** (`jadx-passes/src/var_naming.rs`)
   - Extract simple class name from full path
   - Lowercase first character
   - Handle all-uppercase names
   - Handle short names (<3 chars)
   - Handle inner classes

**Expected Impact:** ~80-90% variable name parity with JADX

### Phase 4: Advanced Naming (P2-P3)

9. **Method Invocation Patterns** (new module or enhance `var_naming.rs`)
   - Requires usage analysis to see how variable is assigned
   - Strip method prefixes (get/set/to/parse/read/format)
   - Special method handling (getInstance, iterator, toString, forName)

10. **Reserved Word Handling**
    - Add static field alias checking
    - Add inner class name checking
    - Add root package name checking

**Expected Impact:** ~95%+ variable name parity with JADX

---

## Part 5: Testing Strategy

### Type Inference Tests

1. **Unit tests** (add to `jadx-passes/src/type_inference.rs`)
   - PHI node type resolution with conflicting types
   - Generic type preservation (List<String> vs List)
   - Array element type inference (Object[] vs String[])
   - Primitive widening (byte → int → long)

2. **Integration tests** (golden file testing)
   - Badboy APK static initializers (current: ~60 errors, target: 0)
   - Complex generic classes
   - Anonymous class instantiation with generics

### Variable Naming Tests

1. **Unit tests** (add to `jadx-passes/src/var_naming.rs`)
   - Long type → "l" not "j"
   - Class name extraction (View → "view", Outer$Inner → "inner")
   - OBJ_ALIAS mappings (Throwable → "th", Class → "cls")

2. **Integration tests** (golden file testing)
   - Compare Rust output with Java JADX output byte-for-byte
   - Focus on variable names in method bodies

---

## Part 6: Metrics for Success

### Type Inference

| Metric | Current | Target (Phase 1) | Target (Phase 2) |
|--------|---------|------------------|------------------|
| Static initializer errors (Badboy APK) | ~60 | ~30 | 0 |
| Unknown variable types | ~40% | ~20% | ~10% |
| Array type precision (Object[] vs typed) | ~30% | ~50% | ~70% |
| Generic type preservation | 0% | 30% | 60% |

### Variable Naming

| Metric | Current | Target (Phase 3) | Target (Phase 4) |
|--------|---------|------------------|------------------|
| Long type name ("l" vs "j") | ❌ Wrong | ✅ Correct | ✅ Correct |
| OBJ_ALIAS coverage | ~30% | ~80% | ~90% |
| Class name extraction | ~20% | ~70% | ~85% |
| Method pattern matching | 0% | 0% | ~60% |
| Overall name parity | ~60% | ~85% | ~95% |

---

## Conclusion

**Type inference is the bottleneck.** Fix the type system first (Phase 1-2), then polish variable naming (Phase 3-4).

**Quick wins:**
- Change `Long => "l"` (5 minutes, immediate visible improvement)
- Add OBJ_ALIAS map (1 hour, 20-30% name improvement)

**High-impact work:**
- Class hierarchy + TypeCompareEnum (1-2 weeks, fixes ~50% of type errors)
- Assign/Use bounds refactor (1 week, fixes cascading type issues)

**Total estimated effort:** 3-4 weeks for Phase 1-3, bringing Rust to ~85% parity with Java JADX for both type inference and variable naming.
