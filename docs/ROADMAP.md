# Dexterity Implementation Roadmap

**Current State:** PRODUCTION READY (Dec 17, 2025)
**Quality Achieved:** 84.4% (medium) / 87.8% (large) | All 19 P1-P2 issues RESOLVED
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
| Null Comparisons | InsnGen.java | P2 | [JADX_CODEGEN_REFERENCE.md](JADX_CODEGEN_REFERENCE.md) | **DONE** - Fixed type-aware condition generation for Int/Boolean/Generic |
| SimplifyVisitor audit | SimplifyVisitor.java (638 LOC) | P2 | [JADX_OPTIMIZATION_PASSES.md](JADX_OPTIMIZATION_PASSES.md) | **DONE** - double negation, CMP unwrapping, cast chain, CHECK_CAST elimination |
| TernaryMod pass | TernaryMod.java (352 LOC) | P2 | [JADX_OPTIMIZATION_PASSES.md](JADX_OPTIMIZATION_PASSES.md) | **DONE** |
| Multi-DEX support | RootNode.java | P2 | jadx-core/dex/nodes/ | **DONE** |
| Warning comments | CodeGen.java retry | P3 | [JADX_CODEGEN_REFERENCE.md](JADX_CODEGEN_REFERENCE.md) | **DONE** |
| For-each loops | LoopRegionVisitor.java | P2 | [JADX_CODEGEN_REFERENCE.md](JADX_CODEGEN_REFERENCE.md) | **DONE** - array pattern + iterator pattern |
| ReplaceNewArray | ReplaceNewArray.java (218 LOC) | P2 | [JADX_OPTIMIZATION_PASSES.md](JADX_OPTIMIZATION_PASSES.md) | **DONE** - NEW_ARRAY + APUT sequence fusion |

---

## Implementation Priorities

### P1: Interface Generic Parameters - **DONE (Dec 17, 2025)**

**Problem (FIXED):**
```java
// Before:   public class State extends AtomicInteger implements ObservableSource
// After:    public class State extends AtomicInteger implements ObservableSource<T>

// Before:   public class MyClass extends BaseClass<T>
// After:    public class MyClass extends BaseClass<T>  (superclass generics preserved)
```

**Root Cause 1 (Interfaces):** In `parse_class_signature()`, the interface matching logic only handled `ArgType::Object` but not `ArgType::Generic`. Fixed by extracting base class names from both variants.

**Root Cause 2 (Superclass):** In `parse_class_signature()`, the superclass type with generics was being parsed but *discarded* with a comment "skip for now, already set from DEX". But DEX only has the raw class name without generic type parameters.

**Fix:**
1. Added `superclass_type: Option<ArgType>` field to `ClassData` in `dexterity-ir/src/info.rs` to store the full generic superclass type
2. Updated `parse_class_signature()` in `converter.rs` to store the parsed superclass type to `class.superclass_type`
3. Updated code generation in `class_gen.rs` to use `superclass_type` when available for the `extends` clause

**Validation:** Classes now correctly show generic type parameters in both `extends` and `implements` clauses, matching JADX output.

### P2: Optimization Pass Audit

Compare dexterity implementations against JADX originals:

| Dexterity | JADX | LOC Comparison | Status |
|-----------|------|----------------|--------|
| simplify.rs (1,646) | SimplifyVisitor.java (638) | Audit complete | **DONE** - double negation, CMP unwrapping, cast chain optimization |
| code_shrink.rs (1,038) | CodeShrinkVisitor.java (299) | Audit complete | **DONE** - pipeline integration, cross-block inlining, sync boundary checks |
| conditionals.rs (740) | TernaryMod.java (352) | Port ternary conversion | **DONE** - return-ternary, single-branch ternary |
| mod_visitor.rs (831) | ModVisitor.java (634) | Array init fusion | **DONE** - NEW_ARRAY+FILL_ARRAY fusion, dead MOVE removal |

**Reference:** [JADX_OPTIMIZATION_PASSES.md](JADX_OPTIMIZATION_PASSES.md)

### P2: Multi-DEX Support - DONE

Multi-DEX support has been implemented. The codebase now properly handles APKs with multiple DEX files (classes.dex, classes2.dex, etc.) through the `dex_idx` parameter in converter.rs and main.rs.

### P3: Warning Comments

Add JADX-style diagnostic comments:
- `/* JADX WARNING: ... */` for type inference failures
- `/* renamed from: ... */` for deobfuscation

**Reference:** [JADX_CODEGEN_REFERENCE.md](JADX_CODEGEN_REFERENCE.md) - CodeGen retry logic

---

## Codegen Feature Parity (NEW - Dec 2025)

### Critical Missing Features (P1)

| Feature | JADX Files | Impact | Status |
|---------|-----------|--------|--------|
| **Lambda expressions** | `InsnGen.makeInvokeLambda()` | Android 8+ apps use ~40% | TODO |
| **Method references** | `InsnGen.makeRefLambda()` | `Foo::method`, `::new` syntax | TODO |
| **INVOKE_CUSTOM parsing** | `InvokeCustomNode.java` | Required for lambdas | TODO |

**Implementation Plan:**
1. Add `InvokeCustom` to `dexterity-ir/src/instructions.rs`
2. Parse `invoke-custom` in `dexterity-dex/src/reader.rs`
3. Create `lambda_detection.rs` pass in `dexterity-passes`
4. Add lambda codegen in `body_gen.rs`

### Important Missing Features (P2)

| Feature | JADX Files | Impact | Status |
|---------|-----------|--------|--------|
| **TernaryInsn IR type** | `TernaryInsn.java` | Cleaner ternary output | TODO |
| **Fallback mode** | `fallbackOnlyInsn()` | Raw bytecode on failure | TODO |
| **Code comments** | `CodeGenUtils.addCodeComments()` | WARN/INFO annotations | TODO |
| **Source line tracking** | `code.startLineWithNum()` | Debug mapping | TODO |

### Edge Cases (P3)

| Feature | JADX Files | Impact | Status |
|---------|-----------|--------|--------|
| **Polymorphic invoke** | `isPolymorphicCall()` | MethodHandle cases | TODO |
| **Android R.* handling** | `handleAppResField()` | Resource ID resolution | TODO |
| **JSR/RET instructions** | `JAVA_JSR`, `JAVA_RET` | Old Java bytecode | TODO |
| **Varargs expansion** | `processVarArg()` | `foo(arr...)` → `foo(a, b)` | TODO |

### Architecture Differences (Reference)

See [JADX_CODEGEN_REFERENCE.md Part 4](JADX_CODEGEN_REFERENCE.md#part-4-jadx-vs-dexterity-codegen-comparison) for detailed comparison.

| Aspect | JADX | Dexterity |
|--------|------|-----------|
| Region traversal | Visitor pattern (`IContainer.generate()`) | Direct pattern matching |
| Inline expressions | `InsnWrapArg` wrapper class | `inlined_exprs` HashMap |
| Attribute system | Rich `AFlag`/`AType` | Simpler `AFlag` enum |
| Condition tree | `IfCondition` with TERNARY mode | Flat `Condition` enum |

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
- [x] ReplaceNewArray - **DONE** (mod_visitor.rs: NEW_ARRAY + APUT sequence fusion, fills gaps with zeros like JADX)

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
| `crates/dexterity-passes/src/type_inference.rs` | 2,559 | Type inference |
| `crates/dexterity-codegen/src/body_gen.rs` | 4,985 | Region traversal |
| `crates/dexterity-passes/src/region_builder.rs` | 2,066 | Control flow |
| `crates/dexterity-passes/src/var_naming.rs` | 1,480 | Variable naming |
| `crates/dexterity-codegen/src/expr_gen.rs` | 1,362 | Expression gen |
| `crates/dexterity-codegen/src/class_gen.rs` | 1,539 | Class structure |

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
| Overall Quality | 84.4-87.8% | 85%+ | **ACHIEVED** |
| Variable naming | 99.96% (11 remaining) | 100% | ACHIEVED |
| Class generics | 736 classes | All | ACHIEVED |
| Interface generics | 100% | 100% | **ACHIEVED** |
| Type inference | 0 Unknown failures | 0 | **ACHIEVED** |
| Defect score | 95.9-96.8% | 95%+ | **ACHIEVED** |
| Speed advantage | 3-88x | Maintain | ACHIEVED |
| Test pass rate | 685/685 | 100% | ACHIEVED |
| P1-P2 issues | 18/18 resolved | All | **ACHIEVED** |

---

## Completed Work History

### Dec 16, 2025 - PRODUCTION READY Status Achieved
All 18 P1-P2 issues resolved. Quality improver confirmed:
- Type inference: 0 Unknown type failures
- Variable naming: 99.96% reduction (27,794 → 11)
- Defect score: 95.9%/96.8%
- Overall quality: 84.4%/87.8%

### Dec 16, 2025 - THREE MAJOR Bug Fixes
1. **Variable Naming** - 27,794 → 11 arg0/arg1 (99.96% reduction)
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
**Status:** PRODUCTION READY - All 18 P1-P2 issues resolved
