# Implementation Roadmap

Remaining work to achieve full JADX parity.

## Current State

- **~98% feature complete** vs Java jadx-core
- **~85% variable naming parity** with JADX
- **Type inference foundation complete** (ClassHierarchy, TypeCompare)

## Priority 1: Type Inference Improvements

### Phase 1: Bounds-Based Refactor (High Impact)

**Files:** `jadx-passes/src/type_inference.rs`

Current system uses flat `Constraint` enum. JADX uses separate assign/use bounds:

```rust
// Current (Rust)
enum Constraint {
    Equals(TypeVar, InferredType),
    Same(TypeVar, TypeVar),
    Subtype(TypeVar, InferredType),
}

// Target (matching JADX)
struct AssignBound { var: TypeVar, bound_type: ArgType, source: BoundSource }
struct UseBound { var: TypeVar, bound_type: ArgType, usage: BoundUsage }
```

**Expected Impact:**
- Fixes ~50% of type errors
- Reduces Unknown types from ~40% to ~20%

### Phase 2: PHI Constant Splitting

**Files:** `jadx-passes/src/phi_const_split.rs` (new)

Duplicate constants used by multiple PHI nodes to enable independent type inference per branch.

**Expected Impact:**
- Fixes remaining type conflicts in static initializers
- Reduces Unknown types to ~10%

### Phase 3: Array Element Tracking

Track APUT instructions to refine array element types from `Object[]` to concrete types.

**Expected Impact:**
- Array type precision: 30% -> 70%

## Priority 2: Code Quality Polish

### Warning Comments
Add JADX-style warning comments:
- `/* JADX WARNING: ... */` for type inference failures
- `/* renamed from: ... */` for deobfuscation

**Files:** `jadx-codegen/src/class_gen.rs`, `jadx-codegen/src/method_gen.rs`

### Variable Naming (Final 15%)
- Method invocation pattern matching (`getString()` -> `string`)
- Reserved word handling for static fields

**Files:** `jadx-passes/src/var_naming.rs`

## Priority 3: Missing Features

### .smali Input Support
Parse smali assembly files directly.

### .jobf Persistence
Save/load deobfuscation mappings (`--deobf-cfg-file`).

### Additional Mapping Formats
- Tiny format parser
- Enigma format parser

## Type Inference Gap Analysis

### Algorithm Differences

| Feature | Java JADX | Dexterity | Status |
|---------|-----------|-----------|--------|
| Constraint solving | Iterative bound merging | Fixed-iteration unification | Gap |
| Type comparison | 8-value TypeCompareEnum | Simple equality + basic | Done |
| Bounds system | Assign/use separation | Flat Constraint enum | Gap |
| Class hierarchy | Full with LCA | Implemented | Done |
| PHI handling | Bidirectional propagation | Unidirectional | Gap |

### Variable Naming Differences

| Type | JADX | Dexterity | Status |
|------|------|-----------|--------|
| long | `l` | `l` | Fixed |
| Throwable | `th` | `th` | Fixed |
| Class | `cls` | `cls` | Fixed |
| StringBuilder | `sb` | `sb` | Fixed |
| View | `view` | `view` | Fixed |
| Method patterns | `getString()` -> `string` | Not implemented | Gap |

## Success Metrics

| Metric | Current | Target |
|--------|---------|--------|
| Variable naming parity | 85% | 95% |
| Unknown variable types | ~40% | ~10% |
| Array type precision | ~30% | ~70% |
| Static initializer errors | ~10% | 0% |
| Warning comment support | 0% | 100% |

## Files Summary

### Type Inference Foundation (Complete)
- `jadx-ir/src/class_hierarchy.rs` - ~450 lines, LCA calculation
- `jadx-ir/src/types.rs` - +200 lines, TypeCompare system

### Needs Work
- `jadx-passes/src/type_inference.rs` - Refactor to bounds-based
- `jadx-passes/src/var_naming.rs` - Add method pattern matching
- `jadx-codegen/src/class_gen.rs` - Add warning comments
