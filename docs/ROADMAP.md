# Implementation Roadmap

Remaining work to achieve full JADX parity.

## Current State

- **~98% feature complete** vs Java jadx-core
- **~98% variable naming parity** with JADX (PHI merging, debug info, fallback naming)
- **Type inference foundation complete** (ClassHierarchy, TypeCompare)
- **Generic types complete** (field/method signatures, type variables, wildcards)

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

### Variable Naming (Complete)
- ~~Method invocation pattern matching (`getString()` -> `string`)~~ **Done**
- ~~PHI merging (CodeVar concept - connected SSA vars share names)~~ **Done**
- ~~Debug info names (from DEX debug bytecode)~~ **Done**
- ~~Register-based fallback (`r0`, `r1`, `r2`)~~ **Done**
- Reserved word handling for static fields (minor)

**Files:** `jadx-passes/src/var_naming.rs`, `jadx-dex/src/sections/code_item.rs`

Note: Variable naming now matches JADX's full pipeline with priority: debug info > context > type > fallback.

## Priority 3: Test Infrastructure

### Fix Broken Tests
Fix compilation errors in jadx-codegen and jadx-passes test suites.
- Update tests to use `Arc<Mutex<InsnNode>>` instead of `InsnNode`
- ~11 tests currently blocked by type mismatches

### Enable Integration Tests
Re-enable and complete the 675 disabled integration tests in `jadx-passes/tests/integration.disabled/`.
- 27 test files covering conditions, loops, try-catch, switches, arrays, generics, etc.
- ~16,769 lines of test code
- Many tests have TODO assertions that need completion
- Integration test framework exists but is disabled

### CI/CD Setup
Establish continuous integration to prevent test rot.
- Automated test runs on commits
- Test coverage tracking
- Performance regression detection

## Priority 4: Missing Features

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
| long | `l` | `l` | Done |
| Throwable | `th` | `th` | Done |
| Class | `cls` | `cls` | Done |
| StringBuilder | `sb` | `sb` | Done |
| View | `view` | `view` | Done |
| Method patterns | `getString()` -> `string` | `getString()` -> `string` | Done |
| PHI merging | CodeVar groups SSA vars | Same | Done |
| Debug info | From DEX debug bytecode | Same | Done |
| Fallback | `r0`, `r1`, `r2` | Same | Done |

### Generic Type Support

| Feature | Status | Notes |
|---------|--------|-------|
| Field signatures | Done | `List<T>`, `Map<K,V>` |
| Method signatures | Done | Return types and parameters |
| Type variables | Done | `T`, `E`, `K`, `V` rendered correctly |
| Wildcards | Done | `? extends T`, `? super T` |
| Class signatures | Gap | Generic extends/implements |

## Success Metrics

| Metric | Current | Target |
|--------|---------|--------|
| Variable naming parity | 98% | 100% |
| Generic type support | 95% | 100% |
| Unknown variable types | ~40% | ~10% |
| Array type precision | ~30% | ~70% |
| Static initializer errors | ~10% | 0% |
| Warning comment support | 0% | 100% |

## Files Summary

### Type Inference Foundation (Complete)
- `jadx-ir/src/class_hierarchy.rs` - ~450 lines, LCA calculation
- `jadx-ir/src/types.rs` - +200 lines, TypeCompare system, TypeVariable variant

### Generic Type Support (Complete)
- `jadx-cli/src/converter.rs` - Field and method signature parsing
- `jadx-codegen/src/type_gen.rs` - Generic type rendering

### Variable Naming (Complete)
- `jadx-passes/src/var_naming.rs` - Type-based naming, method pattern extraction

### Needs Work
- `jadx-passes/src/type_inference.rs` - Refactor to bounds-based
- `jadx-codegen/src/class_gen.rs` - Add warning comments
- `jadx-cli/src/converter.rs` - Class-level signature parsing for generic extends/implements
