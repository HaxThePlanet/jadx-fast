# Dexterity-Passes vs JADX Passes: Comprehensive Reference

This document provides a detailed comparison between JADX's visitor passes and Dexterity's pass implementations, tracking parity status and implementation details.

## Overview

| Metric | JADX | Dexterity | Status |
|--------|------|-----------|--------|
| Total Passes | 63+ | 24+ | ~38% |
| Type Inference Files | 26 | 5 | Enhanced |
| Region Analysis Files | 8 | 3 | Partial |
| Code Optimization Passes | 15+ | 10 | Enhanced |

---

## Pass Pipeline Comparison

### JADX Pass Execution Order (REGIONS MODE)

```
PRE-DECOMPILE STAGE (Class-Level)
├── SignatureProcessor          - Generic type signatures
├── OverrideMethodVisitor       - @Override detection
├── AddAndroidConstants         - R.id.xxx replacement
├── DeobfuscatorVisitor         - Name deobfuscation
├── RenameVisitor               - Class/field/method renaming
├── UsageInfoVisitor            - Dependency tracking
├── CollectConstValues          - Static final values
├── ProcessAnonymous            - Anonymous/lambda detection
└── ProcessMethodsForInline     - Mark methods for inlining

INSTRUCTIONS IR STAGE
├── CheckCode                   - Validate/remove bad code
├── DebugInfoAttachVisitor      - Debug symbols (optional)
├── AttachTryCatchVisitor       - Try/catch attachment
├── AttachMethodDetails         - Method details for invokes
└── ProcessInstructionsVisitor  - Initialize instruction info

BLOCKS IR STAGE
├── BlockSplitter               - Split into basic blocks
├── BlockProcessor              - Compute dominators, fix CFG
└── BlockFinisher               - Post-dominator tree

SSA & EARLY OPTIMIZATION
├── SSATransform                - Convert to SSA form
├── MoveInlineVisitor           - Inline redundant moves
├── ConstructorVisitor          - Replace invoke with new
├── InitCodeVariables           - Initialize code variables
├── MarkFinallyVisitor          - Detect duplicate finally
└── ConstInlineVisitor          - Inline constant registers

TYPE INFERENCE STAGE (CRITICAL)
├── TypeInferenceVisitor        - Main type inference
├── DebugInfoApplyVisitor       - Apply debug type info
├── FixTypesVisitor             - Fix unresolved types
└── FinishTypeInference         - Validate and finalize

POST-TYPE INFERENCE
├── ProcessKotlinInternals      - Kotlin var names
├── CodeRenameVisitor           - Apply naming
├── InlineMethods               - Inline marked methods
├── GenericTypesVisitor         - Generic type info
├── ShadowFieldVisitor          - Shadowed field access
└── DeboxingVisitor             - Remove boxing

STRUCTURAL OPTIMIZATION
├── AnonymousClassVisitor       - Anonymous class inline prep
├── ModVisitor                  - Instruction modifications
├── CodeShrinkVisitor           - Inline variables
├── ReplaceNewArray             - Array initialization
├── SimplifyVisitor             - Simplify expressions
└── MethodThrowsVisitor         - Collect exceptions

REGIONS IR STAGE
├── RegionMakerVisitor          - Pack blocks into regions
├── IfRegionVisitor             - Optimize if-else
├── SwitchOverStringVisitor     - String switch patterns
├── ReturnVisitor               - Optimize returns
├── CleanRegions                - Remove empty regions
├── CodeShrinkVisitor (2nd)     - Final inlining
├── MethodInvokeVisitor         - Overload/varargs
├── SimplifyVisitor (2nd)       - Final simplification
└── CheckRegions                - Validate regions

SPECIALIZED TRANSFORMATIONS
├── EnumVisitor                 - Restore enum classes
├── FixSwitchOverEnum           - Enum switch cleanup
├── NonFinalResIdsVisitor       - Resource constants
├── ExtractFieldInit            - Field initialization
├── FixAccessModifiers          - Access adjustment
└── ClassModifier               - Remove synthetic

FINAL CODE PREPARATION
├── LoopRegionVisitor           - while→for/foreach
├── SwitchBreakVisitor          - Break optimization
├── ProcessVariables            - Variable declaration
├── ApplyVariableNames          - Final naming
└── PrepareForCodeGen           - Final preparation
```

### Dexterity Pass Execution Order

```
1. BlockSplitter          - Split into basic blocks
2. CFG Construction       - Compute dominators, CFG
3. Finally Marking        - Detect finally blocks
4. Region Building        - Build region tree
5. SSA Transformation     - Convert to SSA form
6. ModVisitor             - Instruction modifications
7. Constant Inlining      - Inline constants
8. Type Inference         - Infer register types
9. Simplification         - Simplify expressions
10. Code Shrinking        - Inline variables
11. Prepare for Codegen   - Final preparation
12. Variable Naming       - Assign variable names
```

---

## Detailed Pass Comparison

### 1. Block Processing

| JADX Pass | Dexterity Equivalent | Status | Notes |
|-----------|---------------------|--------|-------|
| `BlockSplitter.java` | `block_split.rs` | DONE | Full parity |
| `BlockProcessor.java` | `cfg.rs` | PARTIAL | Missing FixMultiEntryLoops |
| `BlockFinisher.java` | `cfg.rs` | PARTIAL | Post-dominator incomplete |
| `CheckCode.java` | - | MISSING | Bad code validation |

**Dexterity Implementation:**
- `block_split.rs`: 300+ lines, splits bytecode into basic blocks
- `cfg.rs`: 500+ lines, builds CFG and computes dominators

**Missing from Dexterity:**
- `FixMultiEntryLoops` - Restructure loops with multiple entry points
- `BlockFinisher` post-dominator completion

---

### 2. SSA Transformation

| JADX Pass | Dexterity Equivalent | Status | Notes |
|-----------|---------------------|--------|-------|
| `SSATransform.java` (467 lines) | `ssa.rs` | DONE | Full SSA with phi nodes |
| `MoveInlineVisitor.java` | `ssa.rs` | PARTIAL | Basic move inlining |

**Dexterity Implementation:**
- `ssa.rs`: 800+ lines, complete SSA transformation
- Computes dominance frontiers
- Inserts phi nodes correctly
- Handles def-use chains

**Key Algorithm Differences:**

JADX SSATransform:
```java
1. collectCodeVars() - Identify all variables
2. prepareForSSA() - Initialize SSA state
3. insertPhiFunctions() - Insert phi nodes at dom frontiers
4. renameVariables() - Rename with versioned vars
5. removePhiWithSingleArg() - Cleanup trivial phis
```

Dexterity SSA:
```rust
1. compute_dominators() - Build dominator tree
2. compute_dom_frontiers() - Calculate frontiers
3. insert_phi_nodes() - Place phi functions
4. rename_variables() - Apply versioning
5. cleanup_phis() - Remove redundant phis
```

---

### 3. Type Inference (CRITICAL)

This is the area with the largest gap. JADX has 26 files, Dexterity has 3.

#### JADX Type Inference Architecture

```
jadx/core/dex/visitors/typeinference/
├── TypeInferenceVisitor.java    (365 lines) - Main engine
├── TypeSearch.java              (250 lines) - Type hierarchy search
├── TypeUpdate.java              (680 lines) - Propagation engine
├── TypeCompare.java             (393 lines) - Type comparison
├── ITypeBound.java              - Bound interface
├── TypeBoundConst.java          - Constant bounds
├── TypeBoundCheckCastAssign.java - Cast bounds
├── TypeBoundInvokeAssign.java   - Invoke return bounds
├── TypeBoundInvokeUse.java      - Invoke arg bounds
├── TypeBoundFieldGetAssign.java - Field get bounds
├── BoundEnum.java               - ASSIGN vs USE
├── TypeInfo.java                - Per-variable info
├── TypeCompareEnum.java         - Comparison results
└── ... (13 more files)
```

#### Dexterity Type Inference Architecture

```
dexterity-passes/src/
├── type_inference.rs   (2200+ lines) - Main engine
├── type_bound.rs       (650+ lines)  - NEW: TypeBound trait system
└── type_update.rs      (600+ lines)  - NEW: Propagation engine
```

#### Key Concept Comparison

| Concept | JADX | Dexterity | Status |
|---------|------|-----------|--------|
| Type Bounds | `ITypeBound` interface with 6+ impls | `TypeBound` trait with 5 impls | NEW |
| Bound Direction | `BoundEnum.ASSIGN/USE` | `BoundEnum::Assign/Use` | NEW |
| Dynamic Bounds | `TypeBoundInvokeAssign`, etc. | `TypeBoundInvokeAssign`, etc. | NEW |
| Type Comparison | 8 result types (EQUAL, WIDER, etc.) | `TypeCompare` with 8 results | DONE |
| Per-var Info | `TypeInfo` per SSAVar | `TypeInfo` per TypeVar | NEW |
| Propagation | `TypeUpdate` with listeners | `TypeUpdateEngine` | NEW |
| Generic Resolution | Full generic type handling | Partial TypeVariable resolution | PARTIAL |

#### Type Comparison Results

JADX `TypeCompareEnum`:
```java
EQUAL              - Types are identical
WIDER              - First is wider than second
NARROW             - First is narrower than second
WIDER_BY_GENERIC   - Wider only by generic info
NARROW_BY_GENERIC  - Narrower only by generic info
CONFLICT           - Incompatible types
CONFLICT_BY_GENERIC - Conflict due to generic mismatch
UNKNOWN            - Can't determine
```

Dexterity `TypeCompare` (in `dexterity-ir/src/types.rs`):
```rust
Equal
Wider
Narrow
WiderByGeneric
NarrowByGeneric
Conflict
ConflictByGeneric
Unknown
```

#### Type Bound Types

| JADX Bound | Dexterity Equivalent | Purpose |
|------------|---------------------|---------|
| `TypeBoundConst` | `TypeBoundConst` | Direct type constraint |
| `TypeBoundCheckCastAssign` | `TypeBoundCheckCastAssign` | Soft cast constraint |
| `TypeBoundInvokeAssign` | `TypeBoundInvokeAssign` | Generic return resolution |
| `TypeBoundInvokeUse` | `TypeBoundInvokeUse` | Arg type constraint |
| `TypeBoundFieldGetAssign` | `TypeBoundFieldGetAssign` | Field generic resolution |

---

### 4. Region Building

| JADX Pass | Dexterity Equivalent | Status | Notes |
|-----------|---------------------|--------|-------|
| `RegionMakerVisitor.java` | `region_builder.rs` | PARTIAL | Basic regions |
| `IfRegionMaker.java` (525 lines) | `conditionals.rs` | PARTIAL | Missing AND/OR merge |
| `LoopRegionMaker.java` (200+ lines) | `loop_analysis.rs` | PARTIAL | Basic patterns |
| `SwitchRegionMaker.java` | `region_builder.rs` | DONE | Switch regions |
| `TryCatchRegionMaker.java` | `finally_extract.rs` | PARTIAL | Finally only |

#### Key Missing Features in Region Building

1. **Nested IF Merging** (JADX `IfRegionMaker.java:200-350`)
   - Combine sequential IFs with AND/OR logic
   - `isEqualPaths()` check for identical code
   - Condition inversion detection

2. **Loop Pattern Detection** (JADX `LoopRegionMaker.java`)
   - While → For conversion
   - Enhanced for-each reconstruction
   - Loop condition inversion

3. **Ternary Detection**
   - Pattern: `(a ? b : c) && (a ? d : e)`
   - JADX has sophisticated ternary recognition

---

### 5. Code Optimization

| JADX Pass | Dexterity Equivalent | Status | Notes |
|-----------|---------------------|--------|-------|
| `ModVisitor.java` (633 lines) | `mod_visitor.rs` | PARTIAL | Missing patterns |
| `SimplifyVisitor.java` (637 lines) | `simplify.rs` | PARTIAL | Basic simplification |
| `CodeShrinkVisitor.java` | `code_shrink.rs` | DONE | Variable inlining |
| `ConstInlineVisitor.java` (307 lines) | `const_inline.rs` | DONE | Constant inlining |
| `ReplaceNewArray.java` | `mod_visitor.rs` | DONE | Array init patterns |
| `DeboxingVisitor.java` (181 lines) | `body_gen.rs`, `expr_gen.rs` | DONE | BoxingType detection at codegen |

#### ModVisitor Pattern Comparison

JADX patterns handled:
```java
- String concatenation chain → StringBuilder
- Field arithmetic (f += n) → compound assignment
- Boolean negation propagation
- Type cast elimination
- CMP instruction inlining
- Ternary conversion
- Array fill patterns
```

Dexterity patterns handled:
```rust
- Move coalescing
- Constant folding
- Dead code elimination
- Redundant cast removal (basic)
- Array initialization
- StringBuilder chain (partial)
```

**Missing Dexterity Patterns:**
- Full StringBuilder chain detection
- Field arithmetic conversion
- CMP instruction inlining
- Boolean negation propagation

---

### 6. Variable Naming

| JADX Pass | Dexterity Equivalent | Status | Notes |
|-----------|---------------------|--------|-------|
| `ProcessVariables.java` | `var_naming.rs` | PARTIAL | Basic naming |
| `ApplyVariableNames.java` | `var_naming.rs` | PARTIAL | Combined |
| `CodeRenameVisitor.java` | - | MISSING | Deobfuscation naming |

Dexterity `var_naming.rs`:
- Type-based name generation
- Basic scope analysis
- Common type prefixes (str, list, map, etc.)

---

### 7. Post-Type Inference Passes

| JADX Pass | Dexterity Equivalent | Status | Priority |
|-----------|---------------------|--------|----------|
| `FixTypesVisitor.java` | `fix_types.rs` | DONE | HIGH |
| `FinishTypeInference.java` | - | PARTIAL | HIGH |
| `DeboxingVisitor.java` | `deboxing.rs` | DONE | MEDIUM |
| `GenericTypesVisitor.java` | `generic_types.rs` | DONE | Attach generic type info to constructors |
| `ShadowFieldVisitor.java` | `shadow_field.rs` | DONE | Fix shadowed field access with super/cast |

Implemented passes:

1. **FixTypesVisitor** (`fix_types.rs`) - Heuristic fallbacks for unresolved types
   - 8 strategies: RestoreTypeVarCasts, InsertCasts, DeduceTypes, SplitConstInsns,
     FixIncompatiblePrimitives, ForceImmutableTypes, InsertAdditionalMove, RemoveGenerics
2. **DeboxingVisitor** (`deboxing.rs`) - Remove primitive boxing calls
   - Handles Integer, Boolean, Byte, Short, Character, Long, Float, Double
   - Utility functions for wrapper class detection

---

### 8. Specialized Passes

| JADX Pass | Dexterity Equivalent | Status | Notes |
|-----------|---------------------|--------|-------|
| `EnumVisitor.java` | `enum_visitor.rs` | DONE | Enum reconstruction |
| `ConstructorVisitor.java` | - | PARTIAL | Basic constructor handling |
| `MethodInvokeVisitor.java` (441 lines) | `method_invoke.rs` | DONE | Overload resolution with explicit casts |
| `SwitchOverStringVisitor.java` | `body_gen.rs` | DONE | Two-switch pattern merge (79% coverage) |
| `ExtractFieldInit.java` | `extract_field_init.rs` | DONE | Field init extraction |

---

### 9. Pre-Decompile Passes (Not Yet Implemented)

| JADX Pass | Purpose | Priority |
|-----------|---------|----------|
| `SignatureProcessor.java` | Parse generic type signatures | HIGH |
| `OverrideMethodVisitor.java` | @Override detection | MEDIUM |
| `AddAndroidConstants.java` | R.id.xxx replacement | MEDIUM |
| `DeobfuscatorVisitor.java` | Name deobfuscation | LOW |

---

## Implementation Priority Roadmap

### Phase 1: Type Inference Enhancement (COMPLETED)
1. ✅ Create `type_bound.rs` with TypeBound trait hierarchy
2. ✅ Create `type_update.rs` with propagation engine
3. ✅ Integrate new TypeBound system into `type_inference.rs`
4. ✅ Create `fix_types.rs` for heuristic fallbacks
5. ✅ Create `deboxing.rs` for primitive unboxing

### Phase 2: Post-Type Passes (Current)
1. ⏳ `FinishTypeInference` pass - type validation
2. ⏳ `GenericTypesVisitor` - generic type application
3. ⏳ `ShadowFieldVisitor` - shadowed field handling

### Phase 3: Region Enhancement
1. Enhance `IfRegionMaker` - AND/OR merging
2. Enhance `LoopRegionVisitor` - while→for conversion
3. Add `TernaryDetection` - ternary expression recognition

### Phase 4: Code Optimization
1. Full StringBuilder chain detection
2. Field arithmetic conversion
3. CMP instruction inlining
4. Boolean negation propagation

### Phase 5: Specialized Passes
1. `ConstructorVisitor` - constructor handling
2. `MethodInvokeVisitor` - overload resolution
3. `SignatureProcessor` - generic signatures

---

## Key Algorithm References

### Type Inference Three-Phase Algorithm (JADX)

```java
// TypeInferenceVisitor.java
public void visit(MethodNode mth) {
    // Phase 1: Assign immutable types
    assignImmutableTypes(mth);

    // Phase 2: Initialize type bounds
    initTypeBounds(mth);

    // Phase 3: Run type propagation
    runTypePropagation(mth);
}
```

### Type Update Propagation (JADX)

```java
// TypeUpdate.java
public TypeUpdateResult apply(SSAVar var, ArgType candidateType) {
    // 1. Check listener constraints
    for (RegisterArg useArg : var.getUseList()) {
        InsnNode insn = useArg.getParentInsn();
        TypeListener listener = getListener(insn.getType());
        if (listener != null) {
            result = listener.update(var, candidateType);
            if (result == REJECT) return REJECT;
        }
    }

    // 2. Apply if all listeners accept
    if (result == CHANGED) {
        var.setType(candidateType);
    }
    return result;
}
```

### Region Building Algorithm (JADX)

```java
// RegionMaker.java
public void makeRegions(BlockNode startBlock) {
    // 1. Build dominator tree
    // 2. For each block in dominator order:
    //    - If IF block: create IfRegion (potentially merged)
    //    - If LOOP header: create LoopRegion
    //    - If SWITCH: create SwitchRegion
    //    - Otherwise: add to current region
    // 3. Post-process regions for optimization
}
```

---

## File Size Comparison

| Category | JADX (Java lines) | Dexterity (Rust lines) |
|----------|-------------------|------------------------|
| Type Inference | ~4,500 | ~3,500 |
| Region Building | ~2,000 | ~1,500 |
| Code Optimization | ~3,000 | ~2,000 |
| Variable Naming | ~800 | ~600 |
| SSA | ~500 | ~800 |
| **Total** | **~10,800** | **~8,400** |

Note: Rust code tends to be more compact than Java, so line count alone doesn't indicate coverage.

---

## Testing Verification

To verify pass parity:

```bash
# Run dexterity tests
cargo test --package dexterity-passes

# Compare output with JADX
./qa_tools/compare_decompilation.sh test.apk
```

---

## References

- JADX Source: `jadx-fast/jadx-core/src/main/java/jadx/core/dex/visitors/`
- Dexterity Source: `crates/dexterity-passes/src/`
- Type Inference: See `docs/JADX_TYPE_INFERENCE.md`
- Region Building: See `docs/JADX_REGION_CONTROL_FLOW.md`
- Code Generation: See `docs/JADX_CODEGEN_REFERENCE.md`
