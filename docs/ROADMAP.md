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
| Type Inference | type_inference.rs | 2,010 | DONE |
| Region Builder | region_builder.rs | 1,929 | DONE |
| Variable Naming | var_naming.rs | 1,392 | DONE |
| Code Generation | body_gen.rs + expr_gen.rs | 5,525 | DONE |
| Exception Handling | region_builder.rs | - | DONE |
| Deobfuscation | deobf.rs | 1,825 | DONE |

### To Clone Next

| Component | JADX Source | Priority | Reference Doc | Status |
|-----------|-------------|----------|---------------|--------|
| Interface Generics | ClassGen.java | P1 | [JADX_CODEGEN_REFERENCE.md](JADX_CODEGEN_REFERENCE.md) | **PENDING AGENT IN PROGRESS** |
| SimplifyVisitor audit | SimplifyVisitor.java (638 LOC) | P2 | [JADX_OPTIMIZATION_PASSES.md](JADX_OPTIMIZATION_PASSES.md) | **PARTIAL - double negation, CMP unwrapping done** |
| TernaryMod pass | TernaryMod.java (352 LOC) | P2 | [JADX_OPTIMIZATION_PASSES.md](JADX_OPTIMIZATION_PASSES.md) | **DONE** |
| Multi-DEX support | RootNode.java | P2 | jadx-core/dex/nodes/ | **DONE** |
| Warning comments | CodeGen.java retry | P3 | [JADX_CODEGEN_REFERENCE.md](JADX_CODEGEN_REFERENCE.md) | **DONE** |

---

## Implementation Priorities

### P1: Interface Generic Parameters

**Problem:**
```java
// Current:  public abstract class Maybe implements MaybeSource
// Target:   public abstract class Maybe<T> implements MaybeSource<T>
```

**Reference:** [JADX_CODEGEN_REFERENCE.md](JADX_CODEGEN_REFERENCE.md) - ClassGen.java interface signature handling

**Files:**
- `crates/dexterity-cli/src/converter.rs` - Parse interface signatures
- `crates/dexterity-codegen/src/class_gen.rs` - Emit interface type params

### P2: Optimization Pass Audit

Compare dexterity implementations against JADX originals:

| Dexterity | JADX | LOC Comparison | Status |
|-----------|------|----------------|--------|
| simplify.rs (1,520) | SimplifyVisitor.java (638) | Audit complete | **DONE** - double negation, CMP unwrapping, cast chain optimization |
| code_shrink.rs (910+) | CodeShrinkVisitor.java (299) | Audit complete | **DONE** - pipeline integration, cross-block inlining, sync boundary checks |
| conditionals.rs (740) | TernaryMod.java (352) | Port ternary conversion | Pending |

**Reference:** [JADX_OPTIMIZATION_PASSES.md](JADX_OPTIMIZATION_PASSES.md)

### P2: Multi-DEX Support

**Problem:** Currently hardcoded `dex_idx: 0` in converter.rs:~950

**Fix:** Handle APKs with multiple classes.dex, classes2.dex, etc.

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
- [ ] Exception handler temporary CFG edges (partial)

### Type Inference ([JADX_TYPE_INFERENCE.md](JADX_TYPE_INFERENCE.md))
- [x] AssignBound vs UseBound separation
- [x] Type comparison lattice (EQUAL, NARROW, WIDER, CONFLICT)
- [x] Best type selection via max(bounds)
- [ ] TypeSearch multi-variable solver (iteration limit: 1M) - **PENDING AGENT IN PROGRESS**

### Region Control Flow ([JADX_REGION_CONTROL_FLOW.md](JADX_REGION_CONTROL_FLOW.md))
- [x] Region hierarchy (If, Loop, Switch, TryCatch, Synchronized)
- [x] RegionMaker traverse algorithm
- [x] Loop detection via back-edge dominance
- [x] Break/continue insertion
- [x] Endless loop explicit breaks - **DONE** (Region::Break/Continue variants, if-break pattern in loop bodies)

### Variable Naming ([JADX_VARIABLE_NAMING.md](JADX_VARIABLE_NAMING.md))
- [x] Debug info application
- [x] Type-based aliases (String→str, Class→cls, etc.)
- [x] Method pattern extraction (getName()→name)
- [x] Array names (int[]→iArr)
- [x] Collision handling with numeric suffixes
- [ ] Reserved names for inner classes - partial

### Optimization Passes ([JADX_OPTIMIZATION_PASSES.md](JADX_OPTIMIZATION_PASSES.md))
- [x] ConstInlineVisitor equivalent
- [~] SimplifyVisitor audit - **PARTIAL**: double negation (--x, ~~x, !!x), CMP unwrapping done; StringBuilder chain **PENDING AGENT IN PROGRESS**, cast optimization pending
- [x] TernaryMod (If-region to ternary) - **IMPLEMENTED** (analysis pass in ternary_mod.rs, detection at codegen in body_gen.rs)
- [x] DeboxingVisitor - **IMPLEMENTED** (at codegen level in body_gen.rs:2992-3006, BoxingType in expr_gen.rs)
- [x] PrepareForCodeGen final cleanup - **IMPLEMENTED** (prepare_for_codegen.rs, redundant move removal, associative chain marking)

### Code Generation ([JADX_CODEGEN_REFERENCE.md](JADX_CODEGEN_REFERENCE.md))
- [x] Import management (BTreeSet for sorting)
- [x] Inner class detection (4 patterns)
- [x] Special numeric values (MIN/MAX_VALUE, NaN, INFINITY)
- [x] String escaping with Unicode
- [x] HashMap capacity management (memory pooling)

### Exception Handling ([JADX_EXCEPTION_HANDLING.md](JADX_EXCEPTION_HANDLING.md))
- [x] TryCatchBlockAttr structure
- [x] Handler merging for multi-catch
- [ ] Finally block extraction via InsnsSlice matching - **PENDING AGENT IN PROGRESS**
- [ ] MONITOR_ENTER/EXIT as implicit finally - partial

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
| `crates/dexterity-passes/src/type_inference.rs` | 2,010 | Type inference |
| `crates/dexterity-codegen/src/body_gen.rs` | 4,163 | Region traversal |
| `crates/dexterity-passes/src/region_builder.rs` | 1,929 | Control flow |
| `crates/dexterity-passes/src/var_naming.rs` | 1,392 | Variable naming |
| `crates/dexterity-codegen/src/expr_gen.rs` | 1,362 | Expression gen |
| `crates/dexterity-codegen/src/class_gen.rs` | 1,532 | Class structure |

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
| Interface generics | PARTIAL | 100% | P1 |
| Speed advantage | 3-88x | Maintain | ACHIEVED |
| Test pass rate | 685/685 | 100% | ACHIEVED |
| Optimization passes | ~60% | 90% | P2 |

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
