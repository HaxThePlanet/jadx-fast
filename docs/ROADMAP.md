# Implementation Roadmap

Remaining work to achieve full JADX parity.

## Current State

- **~70% feature complete** vs Java jadx-core (core pipeline works, missing optimization passes)
- **~98% variable naming parity** with JADX (PHI merging, debug info, fallback naming)
- **Type inference foundation complete** (ClassHierarchy, TypeCompare)
- **Generic types complete** (field/method signatures, type variables, wildcards)

## Priority 1: Type Inference Improvements

### Phase 1: Combined Lookups + Hierarchy ✅ DONE (Dec 15)

**Files:** `dexterity-passes/src/type_inference.rs`, `dexterity-codegen/src/body_gen.rs`

- Created `infer_types_with_context_and_hierarchy()` combining DEX lookups with class hierarchy
- Updated body_gen.rs to use combined function when both hierarchy and dex_info available
- Previously hierarchy and lookups were mutually exclusive - now work together

**Results:**
- Better type resolution when both DEX metadata and class relationships available

### Phase 2: PHI Node LCA Computation ✅ DONE (Dec 15)

**Files:** `dexterity-passes/src/type_inference.rs`

- Added post-solve LCA (Least Common Ancestor) computation for phi nodes
- When phi sources have conflicting object types (e.g., String and Integer), computes common supertype
- Uses existing `ClassHierarchy.common_supertype()` infrastructure

**Results:**
- Phi node type conflicts now resolved via LCA instead of Unknown

### Phase 3: Array Element Type Inference ✅ DONE (Dec 15)

**Files:** `dexterity-passes/src/type_inference.rs`

- For `ArrayElemType::Object`, now adds `ObjectType` constraint instead of Unknown
- Ensures object array elements are typed as `java/lang/Object` rather than `Unknown`
- Specific types still inferred via `ArrayOf` bidirectional propagation

**Results:**
- Array type precision improved with Object fallback instead of Unknown

### Phase 4: PHI Constant Splitting (Future)

**Files:** `dexterity-passes/src/phi_const_split.rs` (new)

Duplicate constants used by multiple PHI nodes to enable independent type inference per branch.

**Expected Impact:**
- Fixes remaining type conflicts in static initializers
- Reduces Unknown types to ~10%

### Phase 5: Full Bounds-Based Refactor (Future)

Full migration to JADX-style separate assign/use bounds:

```rust
// Target (matching JADX)
struct AssignBound { var: TypeVar, bound_type: ArgType, source: BoundSource }
struct UseBound { var: TypeVar, bound_type: ArgType, usage: BoundUsage }
```

**Expected Impact:**
- Fixes remaining ~50% of type errors
- Further reduces Unknown types

## Priority 2: Code Quality Polish

### Warning Comments
Add JADX-style warning comments:
- `/* JADX WARNING: ... */` for type inference failures
- `/* renamed from: ... */` for deobfuscation

**Files:** `dexterity-codegen/src/class_gen.rs`, `dexterity-codegen/src/method_gen.rs`

### Variable Naming (Complete)
- ~~Method invocation pattern matching (`getString()` -> `string`)~~ **Done**
- ~~PHI merging (CodeVar concept - connected SSA vars share names)~~ **Done**
- ~~Debug info names (from DEX debug bytecode)~~ **Done**
- ~~Register-based fallback (`r0`, `r1`, `r2`)~~ **Done**
- Reserved word handling for static fields (minor)

**Files:** `dexterity-passes/src/var_naming.rs`, `dexterity-dex/src/sections/code_item.rs`

Note: Variable naming now matches JADX's full pipeline with priority: debug info > context > type > fallback.

## Priority 3: Test Infrastructure (COMPLETE)

### Tests Status
All test infrastructure is now complete and passing:
- 985 tests with 100% pass rate
- 680 integration tests fully implemented in `dexterity-cli/tests/integration/`
- Zero TODOs remaining - all assertions completed
- All crate unit tests passing

### Future CI/CD
Establish continuous integration to prevent test rot.
- Automated test runs on commits
- Test coverage tracking
- Performance regression detection

## Priority 4: Missing Features

### .smali Input Support
Parse smali assembly files directly.

### Additional Mapping Formats
- Tiny format parser
- Enigma format parser

## Completed Features

### Deobfuscation (100% Complete)
- ~~.jobf Persistence~~ **Done** - `--deobf-cfg-file` and `--deobf-cfg-file-mode`
- ~~Package renaming~~ **Done** - Short segments renamed (a/b → p000a/p001b)
- ~~Collision detection~~ **Done** - Classes matching package names force-renamed
- ~~Whitelist support~~ **Done** - `--deobf-whitelist "pattern"`
- ~~ProGuard mappings~~ **Done** - `--mappings-path`

### CLI Flags Status

#### Fully Working Flags
| Flag | Status | Notes |
|------|--------|-------|
| `--deobf` | ✅ Working | Enables deobfuscation |
| `--deobf-min/max` | ✅ Working | Min/max name length for renaming |
| `--rename-flags` | ✅ Working | case/valid/printable filters |
| `--no-imports` | ✅ Working | Use fully qualified names |
| `--no-debug-info` | ✅ Working | Skip debug info parsing |
| `--inline-methods` | ✅ Working | Controls synthetic method inlining |
| `--escape-unicode` | ✅ Working | Escape non-ASCII chars as \uXXXX |
| `--export-gradle` | ✅ Working | Export as Gradle project |
| `--no-src` | ✅ Working | Skip source decompilation |
| `--no-res` | ✅ Working | Skip resource extraction |
| `-j/--threads-count` | ✅ Working | Thread pool size |
| `-d/--output-dir` | ✅ Working | Output directory |
| `--log-level` | ✅ Working | Logging verbosity |
| `--decompilation-mode` | ✅ Working | auto/restructure/simple/fallback |
| `--kotlin-metadata` | ✅ Working | Process @Metadata annotations |

#### Stub Flags (Defined but Not Implemented)
| Flag | Status | Notes |
|------|--------|-------|
| `--show-bad-code` | ⚠️ Stub | Add flag check to error handling |
| `--comments-level` | ⚠️ Stub | Add comment generation for error/warn levels |
| `--use-kotlin-methods-for-var-names` | ⚠️ Stub | Wire up Kotlin param names to var_naming |
| `--no-replace-consts` | ⚠️ No-op | Const replacement not implemented yet |
| `--respect-bytecode-access-modifiers` | ⚠️ No-op | Modifiers already preserved |
| `--no-xml-pretty-print` | ⚠️ No-op | XML already not pretty-printed |

## Type Inference Gap Analysis

### Algorithm Differences

| Feature | Java JADX | dexterity | Status |
|---------|-----------|-----------|--------|
| Constraint solving | Iterative bound merging | Fixed-iteration unification | Gap |
| Type comparison | 8-value TypeCompareEnum | Simple equality + basic | Done |
| Bounds system | Assign/use separation | Flat Constraint enum | Gap |
| Class hierarchy | Full with LCA | Implemented + LCA for PHI | Done |
| PHI handling | Bidirectional propagation | Same + post-solve LCA | Done |
| Lookups + hierarchy | Combined | Combined (new) | Done |
| Array element types | Object fallback | ObjectType constraint | Done |

### Variable Naming Differences

| Type | JADX | dexterity | Status |
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
| Deobfuscation parity | 100% | 100% |
| Variable naming parity | 98% | 100% |
| Generic type support | 95% | 100% |
| Unknown variable types | ~20% | ~10% |
| Array type precision | ~50% | ~70% |
| Static initializer errors | ~10% | 0% |
| Warning comment support | 0% | 100% |

**Recent Progress (Dec 15):**
- Unknown types reduced from ~40% to ~20% via combined lookups+hierarchy and PHI LCA
- Array type precision improved with ObjectType constraint fallback

## Files Summary

### Type Inference Foundation (Complete)
- `dexterity-ir/src/class_hierarchy.rs` - ~380 lines, LCA calculation
- `dexterity-ir/src/types.rs` - +200 lines, TypeCompare system, TypeVariable variant

### Generic Type Support (Complete)
- `dexterity-cli/src/converter.rs` - Field and method signature parsing
- `dexterity-codegen/src/type_gen.rs` - Generic type rendering

### Variable Naming (Complete)
- `dexterity-passes/src/var_naming.rs` - Type-based naming, method pattern extraction

### Needs Work
- `dexterity-passes/src/type_inference.rs` - Refactor to bounds-based
- `dexterity-codegen/src/class_gen.rs` - Add warning comments
- `dexterity-cli/src/converter.rs` - Class-level signature parsing for generic extends/implements
