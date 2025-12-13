# Dexterity → JADX Parity Implementation Roadmap

## Objective
Fix Dexterity's code generation to match JADX output quality on the 159 app-specific classes in badboy.apk.

## Current State
- **159 app-specific classes** generated (com/*, _COROUTINE/*, org/*)
- **6323 total classes** in JADX output (includes framework classes)
- Quality gap: ~30-40% of issues are cosmetic, ~60-70% are functional

## High-Impact Issues (Fixed = 50%+ improvement)

### 1. **@Metadata Annotation Preservation** (CRITICAL)
**Impact:** 5-10% of all issues fixed
**Root Cause:** Annotations from DEX are being filtered or not parsed correctly
**Evidence:** All `_COROUTINE/*` classes missing `@Metadata` import and annotation

**Fix Strategy:**
1. Check `should_emit_annotation()` in `method_gen.rs` line 159-175
2. Verify that `kotlin/Metadata` annotations are NOT filtered (currently they ARE)
3. Ensure annotation types are properly imported (add `import kotlin.Metadata;`)
4. Add unit test for Kotlin metadata preservation

**Files to Modify:**
- `crates/jadx-codegen/src/method_gen.rs` - Fix annotation filtering
- `crates/jadx-codegen/src/class_gen.rs` - Add annotation to imports
- `crates/jadx-codegen/src/type_gen.rs` - Fix type name resolution for annotations

### 2. **Method Name Resolution** (HIGH)
**Impact:** 10-15% of issues (affects method calls, inlining)
**Root Cause:** `access$methodName()` being used instead of actual method name
**Evidence:** `CoroutineDebuggingKt.access$artificialFrame()` should be `.artificialFrame()`

**Fix Strategy:**
1. Check method inlining logic in `body_gen.rs`
2. Verify synthetic method detection (`is_synthetic_method()`)
3. Fix method name resolution when inlining (`expr_gen.rs`)
4. Ensure method names use aliases from deobfuscation when available

**Files to Modify:**
- `crates/jadx-codegen/src/expr_gen.rs` - Method name generation
- `crates/jadx-codegen/src/body_gen.rs` - Synthetic method handling
- `crates/jadx-passes/src/ssa.rs` - Method reference tracking

### 3. **Type Name Resolution** (HIGH)
**Impact:** 15-20% of issues (affects readability)
**Root Cause:** Using fully-qualified names (`java.lang.StackTraceElement`) instead of simple names with imports
**Evidence:** JADX: `StackTraceElement`, Dexterity: `java.lang.StackTraceElement`

**Fix Strategy:**
1. Update `type_to_string_with_imports()` in `type_gen.rs` to ALWAYS use simple names
2. Ensure imports are collected for ALL used types (especially method return types)
3. Add these imports to the class imports set before code generation
4. Verify import deduplication works

**Files to Modify:**
- `crates/jadx-codegen/src/type_gen.rs` - Type name generation
- `crates/jadx-codegen/src/class_gen.rs` - Import collection logic
- `crates/jadx-codegen/src/body_gen.rs` - Type name usage in method bodies

### 4. **Expression Simplification** (MEDIUM)
**Impact:** 5-10% of issues (affects readability)
**Root Cause:** Unnecessary variable declarations for simple expressions
**Evidence:**
```
JADX: new Exception()
Dexterity: Object v0 = new Exception(); v0 = (Throwable)v0;
```

**Fix Strategy:**
1. Detect single-use variables in `body_gen.rs`
2. Inline them directly into expressions instead of declaring separately
3. Remove unnecessary casts when type matches
4. Simplify `move_result` for direct expression results

**Files to Modify:**
- `crates/jadx-codegen/src/body_gen.rs` - Single-use variable detection
- `crates/jadx-codegen/src/expr_gen.rs` - Expression inlining

### 5. **Import Type Deduction** (MEDIUM)
**Impact:** 5-10% of issues (affects compilation)
**Root Cause:** Types used in method signatures not being added to imports
**Evidence:** Missing `import java.util.List;`, `import java.io.IOException;`, etc.

**Fix Strategy:**
1. Scan method signatures for all types (parameters, returns, throws)
2. Scan annotations for their types
3. Add all non-java.lang types to imports
4. Ensure generic type parameters are handled

**Files to Modify:**
- `crates/jadx-codegen/src/class_gen.rs` - Import collection
- `crates/jadx-codegen/src/method_gen.rs` - Method signature analysis

### 6. **Throws Clause Generation** (LOW)
**Impact:** 2-5% of issues
**Root Cause:** Try-catch exception types not being extracted to throws clauses
**Evidence:** Methods catching exceptions don't declare them in throws

**Fix Strategy:**
1. Analyze try-catch blocks to identify checked exceptions
2. Add them to method throws clause
3. Filter out unchecked exceptions (RuntimeException, Error)

**Files to Modify:**
- `crates/jadx-codegen/src/method_gen.rs` - Throws clause generation
- `crates/jadx-passes/src/region_builder.rs` - Exception analysis

## Medium-Impact Issues (Each ~5% improvement)

### 7. **Method Order Consistency**
- Sort methods by: constructors, instance methods, static methods
- JADX maintains certain ordering, Dexterity's is arbitrary

### 8. **@Override Annotation Detection**
- Currently using heuristic (too aggressive)
- Should check actual method hierarchy and interfaces
- Need to compare with class inheritance chain

### 9. **Parameter Name Quality**
- Use debug info when available
- Fall back to type-based naming only when no debug info
- Avoid numeric suffixes when not needed

### 10. **Field Initialization Extraction**
- Move simple field initializers from `<clinit>` to field declarations
- Already partially implemented, needs refinement

## Low-Impact Issues

### 11. **Superclass Name Resolution**
- Use simple name when superclass is in same package or imported

### 12. **Generic Type Parameters**
- Preserve `<T>` syntax in declarations
- Handle bounded generics `<T extends Base>`

### 13. **Code Formatting**
- Indentation consistency
- Line length management
- Comment formatting

## Implementation Priority

### Phase 1 (Week 1): Annotation & Type Fixes
1. Fix @Metadata annotation filtering (**1 hour**)
2. Fix type name resolution to use imports (**2 hours**)
3. Add automatic import deduction (**3 hours**)
4. **Result:** 20-25% quality improvement

### Phase 2 (Week 1-2): Method & Expression Fixes
5. Fix method name resolution (access$) (**2 hours**)
6. Simplify unnecessary variable declarations (**3 hours**)
7. Generate throws clauses (**2 hours**)
8. **Result:** 30-35% quality improvement

### Phase 3 (Week 2): Refinements
9. Fix @Override detection (**2 hours**)
10. Improve parameter naming (**2 hours**)
11. Method order consistency (**1 hour**)
12. **Result:** 40-50% quality improvement

## Success Metrics

| Metric | Current | Target |
|--------|---------|--------|
| Compilation rate | 80% | 95%+ |
| Missing imports | ~20% | <5% |
| Unnecessary variables | ~15% | <2% |
| Method name errors | ~10% | <1% |
| Fully-qualified types | ~30% | <5% |
| @Override correctness | 50% | 95%+ |

## Testing Strategy

1. **Unit Tests:** One test per fix, verify isolated behavior
2. **Integration Tests:** Compare 10 sample classes line-for-line with JADX
3. **Full Suite:** Run against badboy.apk, count matching lines
4. **Regression:** Ensure fixes don't break existing 245 tests

## Estimated Timeline
- **Phase 1:** 6 hours → 20% improvement
- **Phase 2:** 7 hours → 30% improvement
- **Phase 3:** 5 hours → 50% improvement
- **Total:** ~18 hours → 50% quality improvement (from 60% to 85%+ parity)

## Next Steps

1. Start with **Phase 1, Issue #1** (Fix @Metadata annotation filtering)
2. Commit and test after each sub-fix
3. Create before/after comparison screenshots
4. Document lessons learned

---

**Last Updated:** December 12, 2025
**Status:** Ready for implementation
