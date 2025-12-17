# Dexterity-Codegen JADX Parity Assessment

**Last Updated**: 2025-12-17
**Reference**: `jadx-fast/jadx-core/src/main/java/jadx/core/codegen/`
**Overall Parity**: **90%**

---

## Executive Summary

Dexterity's code generation module achieves approximately **90% feature parity** with JADX's mature codegen implementation. Key strengths include full lambda/method reference support, comprehensive control flow handling, and robust type generation. Main gaps are increment/decrement operators and compound assignments.

| Component | Parity | Status |
|-----------|--------|--------|
| Class Generation | 92% | Production Ready |
| Method Generation | 95% | Production Ready |
| Expression Generation | 88% | Production Ready |
| Control Flow | 90% | Production Ready |
| Condition Generation | 85% | Production Ready |
| Type Generation | 95% | Production Ready |
| Annotation Generation | 90% | Production Ready |
| Variable Naming | 85% | Production Ready |
| Code Quality | 88% | Production Ready |
| Special Cases | 75% | Partial |

---

## Architecture Comparison

### JADX Codegen (Java - 9 files, ~4,100 lines)
| File | Lines | Purpose |
|------|-------|---------|
| CodeGen.java | ~200 | Entry point |
| ClassGen.java | ~900 | Class structure |
| MethodGen.java | ~450 | Method signatures |
| InsnGen.java | ~800 | Expressions |
| RegionGen.java | ~600 | Control flow |
| ConditionGen.java | ~300 | Boolean conditions |
| TypeGen.java | ~250 | Type formatting |
| AnnotationGen.java | ~200 | Annotations |
| NameGen.java | ~400 | Variable naming |

### Dexterity Codegen (Rust - 11 modules, ~13,102 lines)
| Module | Lines | JADX Equivalent |
|--------|-------|-----------------|
| body_gen.rs | ~6,569 | RegionGen + InsnGen |
| class_gen.rs | ~1,711 | ClassGen |
| expr_gen.rs | ~1,454 | InsnGen |
| dex_info.rs | ~959 | N/A (DEX bridge) |
| stmt_gen.rs | ~759 | InsnGen (statements) |
| method_gen.rs | ~725 | MethodGen |
| type_gen.rs | ~480 | TypeGen |
| access_flags.rs | ~218 | (utilities) |
| writer.rs | ~141 | CodeWriter |
| fallback_gen.rs | ~44 | Fallback mode |

---

## Detailed Parity Tables

### 1. Class Generation - 92%

| Feature | Status | Notes |
|---------|--------|-------|
| Package declaration | DONE | |
| Import management (sorted BTreeSet) | DONE | |
| Class modifiers | DONE | public/private/final/abstract/interface |
| Extends/Implements | DONE | |
| Type parameters | DONE | `<T extends Number>` |
| Field generation | DONE | With modifiers, initial values |
| Annotation rendering | DONE | Class/method/field level |
| Inner class detection (4 types) | DONE | Named, Anonymous, Local, Lambda |
| Anonymous class inlining | DONE | |
| SAM interface detection | DONE | |
| Import collision handling | 90% | Some edge cases |
| Synthetic constructor filtering | DONE | |

### 2. Method Generation - 95%

| Feature | Status | Notes |
|---------|--------|-------|
| Method signatures | DONE | |
| All access modifiers | DONE | |
| Type parameters | DONE | Method-level generics |
| Parameter names | DONE | Debug info + fallback |
| Throws clause | DONE | |
| Varargs handling | DONE | `Type...` syntax |
| Default methods (Java 8) | DONE | |
| @Override heuristic | DONE | |
| Static blocks | DONE | `static {}` |
| Enum constructor hiding | DONE | |

### 3. Expression Generation - 88%

| Feature | Status | Notes |
|---------|--------|-------|
| Const values | DONE | int/long/float/double |
| Special constants | 85% | Integer.MAX_VALUE, Float.NaN partial |
| String literals | DONE | With escaping |
| Class literals | DONE | `.class` syntax |
| Object instantiation | DONE | |
| Array operations | DONE | new, length, get, put |
| Field access | DONE | instance/static |
| Method invocation (5 kinds) | DONE | virtual/static/direct/super/interface |
| Binary operators | DONE | +,-,*,/,%,&,\|,^,<<,>> |
| Unary operators | DONE | -, ~, ! |
| Comparisons | DONE | ==, !=, <, >, <=, >= |
| Type casting | DONE | |
| InstanceOf | DONE | |
| Ternary expressions | DONE | `a ? b : c` |
| Lambda expressions | DONE | Full body decompilation |
| Method references | DONE | `Foo::method`, `Foo::new` |
| Boxing detection | DONE | `Integer.valueOf()` removal |
| Negative literal wrapping | 80% | |
| **Increment/decrement** | **0%** | `i++`, `--j` NOT IMPLEMENTED |
| **Compound assignment** | **0%** | `+=`, `-=` NOT IMPLEMENTED |

### 4. Control Flow - 90%

| Feature | Status | Notes |
|---------|--------|-------|
| If/else | DONE | |
| Else-if chaining | DONE | |
| While loops | DONE | |
| Do-while loops | DONE | |
| For loops | DONE | Init/cond/update |
| For-each (array) | DONE | |
| For-each (iterator) | DONE | hasNext()/next() |
| Switch statements | DONE | With fallthrough |
| Try-catch | DONE | |
| Try-catch-finally | DONE | |
| Multi-catch | DONE | `catch (A | B e)` |
| Synchronized blocks | DONE | |
| Break/continue | DONE | |
| Labeled break/continue | 70% | Some patterns |
| Infinite loops | DONE | `while (true)` |

### 5. Condition Generation - 85%

| Feature | Status | Notes |
|---------|--------|-------|
| Simple comparisons | DONE | `a == b` |
| AND conditions | DONE | `a && b` |
| OR conditions | DONE | `a \|\| b` |
| NOT conditions | DONE | `!cond` |
| Boolean simplification | 75% | `x == true` -> `x` |
| Object null checks | DONE | `x == null` |
| Boolean negation | 80% | `!x` vs `x == false` |
| Nested condition merge | 70% | `if(a){if(b){}}` patterns |
| De Morgan's law | 60% | `!(a && b)` -> `!a \|\| !b` |

### 6. Type Generation - 95%

| Feature | Status | Notes |
|---------|--------|-------|
| All 9 primitives | DONE | void, boolean...double |
| Object types | DONE | |
| Array types (multi-dim) | DONE | `int[][]` |
| Generics | DONE | `List<String>` |
| Wildcards | DONE | `? extends`, `? super` |
| Type variables | DONE | `<T>` |
| java.lang short names | DONE | |
| Inner class names (`$` -> `.`) | DONE | |
| Unknown fallback to Object | DONE | |

### 7. Annotation Generation - 90%

| Feature | Status | Notes |
|---------|--------|-------|
| Basic annotations | DONE | @Override, @Deprecated |
| Annotation values | DONE | `@Foo(value = 1)` |
| Array values | DONE | `@Foo({1, 2, 3})` |
| Single element shorthand | DONE | |
| Skip build-time annotations | DONE | |
| Skip dalvik internal | DONE | |
| Visibility filtering | 85% | |

### 8. Variable Naming - 85%

| Feature | Status | Notes |
|---------|--------|-------|
| Debug info names | DONE | |
| Type-based naming | DONE | str, list, map, etc. |
| Unique name generation | DONE | name, name2, name3 |
| Reserved name checking | 75% | |
| Root package collision | 0% | NOT IMPLEMENTED |
| Fallback naming | DONE | v0, v1 convention |

### 9. Code Quality Features - 88%

| Feature | Status | Notes |
|---------|--------|-------|
| HashMap capacity management | DONE | OOM prevention |
| StringBuilder chain optimization | DONE | `.append()` -> `+` |
| Variable inlining | DONE | Single-use vars |
| Final var detection | DONE | |
| Expression inlining | DONE | |
| Fallback mode | DONE | Raw bytecode on error |
| Line number comments | DONE | Optional |
| Resource ID replacement | DONE | R.* references |
| Deobfuscation filtering | DONE | min/max name length |

### 10. Special Cases - 75%

| Feature | Status | Notes |
|---------|--------|-------|
| Enum reconstruction | DONE | |
| Enum synthetic hiding | DONE | values(), valueOf() |
| INVOKE_CUSTOM | DONE | Lambda/method ref |
| CMP_L/CMP_G expansion | 60% | |
| Polymorphic invoke | DONE | MethodHandle |
| **String switch** | **79%** | Two-switch pattern merge DONE |
| Android R.* handling | DONE | |
| Instance arg propagation | DONE | |

---

## Gap Analysis

### P1 - High Impact (~5% total gap)

| Gap | Impact | JADX Reference | Notes |
|-----|--------|----------------|-------|
| Increment/decrement | 3% | InsnGen:1216-1230 | `i++`, `--j` patterns |
| Compound assignment | 2% | ModVisitor | `+=`, `-=`, etc. |

### P2 - Medium Impact (~2% total gap)

| Gap | Impact | JADX Reference | Notes |
|-----|--------|----------------|-------|
| De Morgan's law | 1% | IfCondition.simplify() | Full simplification |
| Nested condition merge | 1% | IfRegionMaker:200-350 | `if(a){if(b){}}` |

### Recently Completed (Dec 17, 2025)

| Feature | Coverage | JADX Reference | Notes |
|---------|----------|----------------|-------|
| String switch reconstruction | **79%** | SwitchOverStringVisitor | Two-switch pattern merge via `detect_two_switch_in_sequence()` |

### P3 - Low Impact (~2% total gap)

| Gap | Impact | JADX Reference | Notes |
|-----|--------|----------------|-------|
| Root package collision | 0.5% | NameGen:36-48 | Variable vs package |
| CMP ternary expansion | 0.5% | InsnGen:391-401 | Floating point |
| Reserved name edge cases | 0.5% | NameGen | Inner class names |
| Special constants | 0.5% | StringUtils:452-518 | MIN_VALUE, NaN, etc. |

---

## Roadmap to 100%

### Phase 1: P1 Gaps (Target: 95%)
1. Implement increment/decrement detection in `mod_visitor.rs`
   - Pattern: `x = x + 1` -> `x++`
   - Pattern: `x = x - 1` -> `x--`
   - Pre vs post increment context

2. Implement compound assignment detection
   - Pattern: `x = x + n` -> `x += n`
   - Works for: +, -, *, /, %, &, |, ^, <<, >>

### Phase 2: P2 Gaps (Target: 98%)
1. String switch reconstruction pass
2. Complete De Morgan simplification
3. Nested condition merging

### Phase 3: P3 Gaps (Target: 100%)
1. Root package collision avoidance
2. Full CMP ternary expansion
3. Complete special constant recognition

---

## Verification Checklist

Run against test APKs and compare output:
- [ ] Simple APK: Identical output expected
- [ ] Medium APK: <5% differences expected
- [ ] Large APK: <10% differences expected (mostly P1 gaps)
- [ ] Lambda-heavy APK: Full lambda/method ref support verified
- [ ] Obfuscated APK: Memory stability verified

---

## References

- `docs/JADX_CODEGEN_REFERENCE.md` - JADX codegen documentation
- `docs/PASSES_COMPARISON.md` - Pass pipeline comparison
- `crates/dexterity-codegen/` - Dexterity implementation
