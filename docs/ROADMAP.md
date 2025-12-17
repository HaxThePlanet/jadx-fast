# Dexterity Implementation Roadmap

**Current State:** HIGH QUALITY ACHIEVED (Dec 16, 2025)
**Strategy:** Clone remaining JADX functionality using comprehensive algorithm documentation

---

## JADX Reference Documentation

8 detailed algorithm documents created from `jadx-fast` source analysis:

| Document | JADX Source | Purpose |
|----------|-------------|---------|
| [JADX_TYPE_INFERENCE.md](JADX_TYPE_INFERENCE.md) | TypeInferenceVisitor.java (26 files) | Two-phase bounds-based type system |
| [JADX_VARIABLE_NAMING.md](JADX_VARIABLE_NAMING.md) | NameGen.java | Multi-stage naming pipeline |
| [JADX_CODEGEN_REFERENCE.md](JADX_CODEGEN_REFERENCE.md) | ClassGen/MethodGen/InsnGen/RegionGen | Code generation patterns |
| [JADX_REGION_CONTROL_FLOW.md](JADX_REGION_CONTROL_FLOW.md) | RegionMaker.java | Region hierarchy and reconstruction |
| [JADX_SSA_CFG.md](JADX_SSA_CFG.md) | SSATransform.java | SSA transformation and CFG |
| [JADX_EXCEPTION_HANDLING.md](JADX_EXCEPTION_HANDLING.md) | AttachTryCatchVisitor.java | Try-catch-finally reconstruction |
| [JADX_OPTIMIZATION_PASSES.md](JADX_OPTIMIZATION_PASSES.md) | 50+ visitor classes | Optimization pass pipeline |
| [JADX_DEOBFUSCATION.md](JADX_DEOBFUSCATION.md) | DeobfuscatorVisitor.java | Two-phase deobfuscation |

---

## What's Done vs What to Clone

### Implemented (JADX Parity)

| Component | Dexterity File | LOC | Status |
|-----------|----------------|-----|--------|
| SSA Transform | ssa.rs | 964 | DONE |
| Type Inference | type_inference.rs | 2,432 | DONE |
| Region Builder | region_builder.rs | 2,066 | DONE |
| Variable Naming | var_naming.rs | 1,480 | DONE |
| Code Generation | body_gen.rs + expr_gen.rs | 6,347 | DONE |
| Exception Handling | region_builder.rs | - | DONE |
| Deobfuscation | deobf.rs | 1,825 | DONE |

### To Clone Next

| Component | JADX Source | Priority | Reference Doc | Status |
|-----------|-------------|----------|---------------|--------|
| Interface Generics | ClassGen.java | P1 | [JADX_CODEGEN_REFERENCE.md](JADX_CODEGEN_REFERENCE.md) | **DONE** - Fixed signature parsing to handle ArgType::Generic |
| SimplifyVisitor audit | SimplifyVisitor.java (638 LOC) | P2 | [JADX_OPTIMIZATION_PASSES.md](JADX_OPTIMIZATION_PASSES.md) | **DONE** - double negation, CMP unwrapping, cast chain, CHECK_CAST elimination |
| TernaryMod pass | TernaryMod.java (352 LOC) | P2 | [JADX_OPTIMIZATION_PASSES.md](JADX_OPTIMIZATION_PASSES.md) | **DONE** |
| Multi-DEX support | RootNode.java | P2 | jadx-core/dex/nodes/ | **DONE** |
| Warning comments | CodeGen.java retry | P3 | [JADX_CODEGEN_REFERENCE.md](JADX_CODEGEN_REFERENCE.md) | **DONE** |
| For-each loops | LoopRegionVisitor.java | P2 | [JADX_CODEGEN_REFERENCE.md](JADX_CODEGEN_REFERENCE.md) | **DONE** - array pattern + iterator pattern |

---

## Implementation Priorities

### P1: Interface Generic Parameters - **DONE (Dec 17, 2025)**

**Problem (FIXED):**
```java
// Before:   public abstract class Maybe implements MaybeSource
// After:    public abstract class Maybe<T> implements MaybeSource<T>
```

**Root Cause:** In `parse_class_signature()`, the interface matching logic only handled `ArgType::Object` but not `ArgType::Generic`. When the signature parser returned a generic interface like `MaybeSource<T>`, it was incorrectly skipped.

**Fix:** Updated `crates/dexterity-cli/src/converter.rs` lines 288-313 to extract base class names from both `ArgType::Object` and `ArgType::Generic` variants when matching parsed interfaces against original DEX interfaces.

**Validation:** Classes like `Maybe<T>`, `Flowable<T>`, `SerializedSubscriber<T>`, etc. now correctly show generic type parameters in their implements clauses, matching JADX output.

### P2: Optimization Pass Audit

Compare dexterity implementations against JADX originals:

| Dexterity | JADX | LOC Comparison | Status |
|-----------|------|----------------|--------|
| simplify.rs (1,646) | SimplifyVisitor.java (638) | Audit complete | **DONE** - double negation, CMP unwrapping, cast chain optimization |
| code_shrink.rs (1,038) | CodeShrinkVisitor.java (299) | Audit complete | **DONE** - pipeline integration, cross-block inlining, sync boundary checks |
| conditionals.rs (740) | TernaryMod.java (352) | Port ternary conversion | **DONE** - return-ternary, single-branch ternary |
| mod_visitor.rs (443) | ModVisitor.java (634) | Array init fusion | **DONE** - NEW_ARRAY+FILL_ARRAY fusion, dead MOVE removal |

**Reference:** [JADX_OPTIMIZATION_PASSES.md](JADX_OPTIMIZATION_PASSES.md)

### P2: Multi-DEX Support - DONE

Multi-DEX support has been implemented. The codebase now properly handles APKs with multiple DEX files (classes.dex, classes2.dex, etc.) through the `dex_idx` parameter in converter.rs and main.rs.

### P3: Warning Comments

Add JADX-style diagnostic comments:
- `/* JADX WARNING: ... */` for type inference failures
- `/* renamed from: ... */` for deobfuscation

**Reference:** [JADX_CODEGEN_REFERENCE.md](JADX_CODEGEN_REFERENCE.md) - CodeGen retry logic

---

## JADX Algorithm Clone Checklist

### SSA & CFG ([JADX_SSA_CFG.md](JADX_SSA_CFG.md))
- [x] Phi placement via dominance frontier
- [x] Variable renaming with version counters
- [x] Block splitting (SPLIT_WITHOUT_CONNECT, SEPARATE_INSNS)
- [x] Exception handler temporary CFG edges - **DONE** (TmpEdge flag, from_blocks_with_try_catch, add/remove temp edges in cfg.rs)

### Type Inference ([JADX_TYPE_INFERENCE.md](JADX_TYPE_INFERENCE.md))
- [x] AssignBound vs UseBound separation
- [x] Type comparison lattice (EQUAL, NARROW, WIDER, CONFLICT)
- [x] Best type selection via max(bounds)
- [x] TypeSearch multi-variable solver (iteration limit: 1M) - **DONE**

### Region Control Flow ([JADX_REGION_CONTROL_FLOW.md](JADX_REGION_CONTROL_FLOW.md))
- [x] Region hierarchy (If, Loop, Switch, TryCatch, Synchronized)
- [x] RegionMaker traverse algorithm
- [x] Loop detection via back-edge dominance
- [x] Break/continue insertion
- [x] Endless loop explicit breaks - **DONE** (Region::Break/Continue variants, if-break pattern in loop bodies)
- [x] For-each loop detection - **DONE** (Array pattern: `i < arr.length` with AGET → `for (T item : arr)`, Iterator pattern: hasNext/next)

### Variable Naming ([JADX_VARIABLE_NAMING.md](JADX_VARIABLE_NAMING.md))
- [x] Debug info application
- [x] Type-based aliases (String→str, Class→cls, etc.)
- [x] Method pattern extraction (getName()→name)
- [x] Array names (int[]→iArr)
- [x] Collision handling with numeric suffixes
- [x] Reserved names for inner classes - **DONE** (infrastructure in var_naming.rs, inner_class_names parameter)

### Optimization Passes ([JADX_OPTIMIZATION_PASSES.md](JADX_OPTIMIZATION_PASSES.md))
- [x] ConstInlineVisitor equivalent
- [x] SimplifyVisitor audit - **DONE**: double negation (--x, ~~x, !!x), CMP unwrapping, StringBuilder chain (codegen level), cast chain optimization, CHECK_CAST duplicate elimination
- [x] TernaryMod (If-region to ternary) - **IMPLEMENTED** (analysis pass in ternary_mod.rs, detection at codegen in body_gen.rs)
- [x] DeboxingVisitor - **IMPLEMENTED** (at codegen level in body_gen.rs:2992-3006, BoxingType in expr_gen.rs)
- [x] PrepareForCodeGen final cleanup - **IMPLEMENTED** (prepare_for_codegen.rs, redundant move removal, associative chain marking)
- [x] IfCondition.simplify() - **DONE** (De Morgan's laws, double negation elimination, NOT distribution for ternary, in regions.rs Condition::simplify())

### Code Generation ([JADX_CODEGEN_REFERENCE.md](JADX_CODEGEN_REFERENCE.md))
- [x] Import management (BTreeSet for sorting)
- [x] Inner class detection (4 patterns)
- [x] Special numeric values (MIN/MAX_VALUE, NaN, INFINITY)
- [x] String escaping with Unicode
- [x] HashMap capacity management (memory pooling)

### Exception Handling ([JADX_EXCEPTION_HANDLING.md](JADX_EXCEPTION_HANDLING.md))
- [x] TryCatchBlockAttr structure
- [x] Handler merging for multi-catch
- [x] Finally block extraction via InsnsSlice matching - **DONE** (copyCodeVars SSA sync added)
- [x] MONITOR_ENTER/EXIT as implicit finally - **DONE** (is_monitor_only_handler() filters synchronized cleanup handlers)

### Deobfuscation ([JADX_DEOBFUSCATION.md](JADX_DEOBFUSCATION.md))
- [x] Two-phase system (DeobfuscatorVisitor, RenameVisitor)
- [x] Name generation strategy (p-prefix, C-prefix, f/m-prefix)
- [x] Condition precedence (FORBID > FORCE_RENAME > NO_ACTION)
- [x] Common package whitelist

---

## Key File References

### Dexterity Core Files
| File | LOC | Purpose |
|------|-----|---------|
| `crates/dexterity-passes/src/type_inference.rs` | 2,432 | Type inference |
| `crates/dexterity-codegen/src/body_gen.rs` | 4,985 | Region traversal |
| `crates/dexterity-passes/src/region_builder.rs` | 2,066 | Control flow |
| `crates/dexterity-passes/src/var_naming.rs` | 1,480 | Variable naming |
| `crates/dexterity-codegen/src/expr_gen.rs` | 1,362 | Expression gen |
| `crates/dexterity-codegen/src/class_gen.rs` | 1,537 | Class structure |

### JADX Source (jadx-fast)
| File | Path | Lines |
|------|------|-------|
| InsnGen.java | jadx-core/.../codegen/ | 800+ |
| ClassGen.java | jadx-core/.../codegen/ | 900 |
| RegionMaker.java | jadx-core/.../regions/maker/ | 100+ |
| TypeInferenceVisitor.java | jadx-core/.../typeinference/ | 400+ |
| SimplifyVisitor.java | jadx-core/.../visitors/ | 638 |

---

## Success Metrics

| Metric | Current | Target | Status |
|--------|---------|--------|--------|
| Variable naming | 99.98% | 100% | ACHIEVED |
| Class generics | 736 classes | All | ACHIEVED |
| Interface generics | 100% | 100% | **ACHIEVED** (Dec 17) |
| Speed advantage | 3-88x | Maintain | ACHIEVED |
| Test pass rate | 685/685 | 100% | ACHIEVED |
| Optimization passes | ~82% | 90% | P2 |

---

## Completed Work History

### Dec 16, 2025 - THREE MAJOR Bug Fixes
1. **Variable Naming** - 27,794 → 6 arg0/arg1 (99.98% reduction)
2. **Class-Level Generics** - 736 classes with `<T>`
3. **Undefined Variables** - 701 → ~0 (Switch/Synchronized regions)

### Previous 5 Phases
- Phase 1: Method-Level Generic Type Parameters (+5-8%)
- Phase 2: Switch Statement Recovery (+2-4%)
- Phase 3: Variable Naming Prefixes (+1-2%)
- Phase 4: Exception Handling Block Limit (+1-2%)
- Phase 5: PHI Node Type Resolution (+1-2%)

### Earlier Fixes
- P0-2: Switch statements (dominance frontier merge)
- P1-1: Variable naming (field/cast/array/PHI scoring)
- P1-2: Type inference (bounds-based with LCA)
- P2: Package name preservation (common whitelist)

---

**Last Updated:** Dec 16, 2025
