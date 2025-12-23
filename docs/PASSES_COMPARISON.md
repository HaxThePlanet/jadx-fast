# Dexterity-Passes vs JADX Passes: Comprehensive Reference

This document provides a detailed comparison between JADX's visitor passes and Dexterity's pass implementations, tracking parity status and implementation details.

## Overview

| Metric | JADX | Dexterity | Status |
|--------|------|-----------|--------|
| Total Passes | 63+ | 32+ | ~51% |
| Type Inference Files | 26 | 7 | **~85% Parity** |
| Region Analysis Files | 8 | 5 | Enhanced (Dec 22) |
| Code Optimization Passes | 15+ | 12 | Enhanced |
| SSA/Variable Passes | 4 | 4 | **JADX Parity** (Dec 22) |

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
PRE-DECOMPILE STAGE (NEW Dec 22)
├── CheckCode              - Instruction validation (register bounds, >255 args)
├── UsageInfo              - Usage graph for classes/methods/fields
├── ProcessAnonymous       - Anonymous/lambda class detection
└── AttachMethodDetails    - Method signature parsing, throws, generics

BLOCKS IR STAGE
├── BlockSplitter          - Split into basic blocks
├── CFG Construction       - Compute dominators, CFG
├── Finally Marking        - Detect finally blocks
└── Region Building        - Build region tree

SSA STAGE
├── SSA Transformation     - Convert to SSA form
├── InitCodeVariables      - Link SSAVars to CodeVars (NEW Dec 22)
├── ConstructorVisitor     - Constructor processing (NEW Dec 22)
└── ModVisitor             - Instruction modifications

TYPE INFERENCE STAGE
├── Constant Inlining      - Inline constants
├── Type Inference         - Infer register types
└── Finish Type Inference  - Validate types, generate warnings

POST-TYPE INFERENCE
├── Simplification         ─┐
├── Code Shrinking         ─┴─ ITERATIVE (until fixpoint, max 5×blocks)
├── ReturnVisitor          - Return statement optimization (NEW Dec 22)
└── Loop Pattern Analysis  - for/foreach detection

REGIONS IR STAGE (NEW Dec 22)
├── PostProcessRegions     - Loop condition merging, switch breaks
├── CheckRegions           - Region coverage validation
└── Prepare for Codegen    - Final preparation

FINAL STAGE
├── ProcessVariables       - Remove unused vars, finalize CodeVars (NEW Dec 22)
└── Variable Naming        - Assign variable names with SSAContext
```

**Iterative Pass Execution (Dec 20, 2025):**
Dexterity now runs simplification and code shrinking passes iteratively until no more
changes occur (fixpoint), matching JADX's `traverseIterative()` behavior. The iteration
limit is `5 × block_count`, same as JADX's `DepthRegionTraversal.java:13`.

---

## Detailed Pass Comparison

### 1. Block Processing

| JADX Pass | Dexterity Equivalent | Status | Notes |
|-----------|---------------------|--------|-------|
| `BlockSplitter.java` | `block_split.rs` | DONE | Full parity |
| `BlockProcessor.java` | `cfg.rs` | PARTIAL | Missing FixMultiEntryLoops |
| `BlockFinisher.java` | `cfg.rs` | PARTIAL | Post-dominator incomplete |
| `CheckCode.java` | `check_code.rs` | **DONE** (Dec 22) | Instruction validation |
| `CheckRegions.java` | `check_regions.rs` | **DONE** (Dec 22) | Region coverage validation |

**Dexterity Implementation:**
- `block_split.rs`: 487 lines, splits bytecode into basic blocks
- `cfg.rs`: 831 lines, builds CFG and computes dominators
- `check_code.rs`: 447 lines, validates instructions (register bounds, >255 args)
- `check_regions.rs`: 379 lines, validates region coverage (missing blocks, duplicates)
- Block storage uses `Vec<BasicBlock>` for O(1) direct index access since block IDs are dense sequential integers (0,1,2...). Changed from BTreeMap in Dec 2025 optimization pass.

**Missing from Dexterity:**
- `FixMultiEntryLoops` - Restructure loops with multiple entry points
- `BlockFinisher` post-dominator completion

---

### 2. SSA Transformation

| JADX Pass | Dexterity Equivalent | Status | Notes |
|-----------|---------------------|--------|-------|
| `SSATransform.java` (467 lines) | `ssa.rs` (1,294 lines) | DONE | Full SSA with phi nodes |
| `MoveInlineVisitor.java` | `ssa.rs` | PARTIAL | Basic move inlining |
| `InitCodeVariables.java` | `init_code_vars.rs` (306 lines) | **DONE** (Dec 22) | Link SSAVars to CodeVars |
| `ProcessVariables.java` | `process_variables.rs` (344 lines) | **DONE** (Dec 22) | Remove unused vars, finalize |
| `ConstructorVisitor.java` | `constructor_visitor.rs` (271 lines) | **DONE** (Dec 22) | super/this call processing |

**Dexterity Implementation:**
- `ssa.rs`: 1,294 lines, complete SSA transformation with SSAContext integration
- `init_code_vars.rs`: 306 lines, initializes CodeVars from SSAVars (JADX parity)
- `process_variables.rs`: 344 lines, removes unused variables, finalizes CodeVars
- `constructor_visitor.rs`: 271 lines, identifies super()/this() calls, field initializers
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
6. init_code_vars() - Link SSAVars to CodeVars (NEW Dec 22)
7. process_variables() - Remove unused, finalize (NEW Dec 22)
```

---

### 3. Type Inference (CRITICAL)

**Significant Progress: Dexterity now has ~85% feature parity with JADX's type inference system.**

JADX has 26 files, Dexterity has 7 (consolidated but feature-equivalent).

#### JADX Type Inference Architecture

```
jadx/core/dex/visitors/typeinference/
├── TypeInferenceVisitor.java    (365 lines) - Main engine
├── TypeSearch.java              (403 lines) - Multi-variable constraint solver
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
├── type_inference.rs        (3,229 lines) - Main engine with TypeSearch integrated
├── type_search.rs           (703 lines)   - Modular TypeSearch multi-var solver
├── type_bound.rs            (780 lines)   - TypeBound trait system (5 impls)
├── type_update.rs           (1,146 lines) - Propagation engine with 10 listeners
├── type_listener.rs         (361 lines)   - Type listener traits
├── fix_types.rs             (834 lines)   - FixTypesVisitor equivalent
└── finish_type_inference.rs (298 lines)   - Final validation

dexterity-ir/src/
└── types.rs                 (1,793 lines) - TypeCompare with full generic handling
```

**Total: ~9,100 lines implementing JADX's ~26 files (~4,000 lines)**

#### Key Concept Comparison

| Concept | JADX | Dexterity | Status |
|---------|------|-----------|--------|
| Type Bounds | `ITypeBound` interface with 6+ impls | `TypeBound` trait with 5 impls | ✅ DONE |
| Bound Direction | `BoundEnum.ASSIGN/USE` | `BoundEnum::Assign/Use` | ✅ DONE |
| Dynamic Bounds | `TypeBoundInvokeAssign`, etc. | `TypeBoundInvokeAssign`, etc. | ✅ DONE |
| Type Comparison | 8 result types (EQUAL, WIDER, etc.) | `TypeCompare` with 8 results | ✅ DONE |
| Per-var Info | `TypeInfo` per SSAVar | `TypeInfo` per TypeVar | ✅ DONE |
| Propagation | `TypeUpdate` with listeners | `TypeUpdateEngine` with 10 listeners | ✅ DONE |
| TypeSearch | Multi-variable constraint solver | Integrated Phase 2 fallback | ✅ DONE |
| Generic Resolution | Full generic/TypeVar/wildcard | Full TypeVariable/Wildcard/OuterGeneric | ✅ DONE |
| Fix Types | 8 fallback strategies | 8 matching strategies | ✅ DONE |

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
| `RegionMakerVisitor.java` | `region_builder.rs` | DONE | Full region building with ternary integration |
| `IfRegionMaker.java` (525 lines) | `conditionals.rs` | DONE | AND/OR merge implemented, Phase 2 OR merging |
| `LoopRegionMaker.java` (200+ lines) | `loop_analysis.rs` | DONE | All loop patterns |
| `SwitchRegionMaker.java` | `region_builder.rs` | DONE | Switch regions |
| `TryCatchRegionMaker.java` | `finally_extract.rs` | DONE | Finally extraction |
| `TernaryMod.java` | `ternary_mod.rs` | **DONE Dec 19** | TernaryTransformResult, try_transform_to_ternary() |
| `IfRegionVisitor.java` | `if_region_visitor.rs` | **DONE Dec 19** | 9 branch reordering rules, CFG integration |

#### Recently Implemented Features (Dec 21, 2025 - Phase 2)

1. **Short-circuit OR Condition Merging** (`conditionals.rs`)
   - `MergeMode` enum with And/Or/Single variants for tracking merge type
   - `MergedCondition::can_merge()` detects OR type 1 (else leads to condition) and OR type 2 (same-target branching)
   - `MergedCondition::merge()` correctly assigns then/else blocks for OR patterns
   - `collect_branch_blocks_with_barrier()` prevents cross-branch block inclusion
   - Patterns: `if (a) goto then; if (b) goto then;` -> `if (a || b) { then }`

2. **Barrier-based Branch Collection** (`conditionals.rs`)
   - Added `barrier` parameter to `collect_branch_blocks_with_barrier()`
   - Prevents including the other branch's target in this branch's blocks
   - Critical for short-circuit patterns where both conditions branch to same "true" block

#### Previously Implemented Features (Dec 19, 2025)

1. **TernaryMod Transformation** (`ternary_mod.rs`)
   - `TernaryTransformResult` enum with Assignment, Return, NotTernary variants
   - `try_transform_to_ternary()` detects ternary-convertible patterns
   - Integrated into `process_if()` in `region_builder.rs`
   - Codegen for `TernaryAssignment`/`TernaryReturn` in `body_gen.rs`
   - Patterns: `if (a) x = b; else x = c;` -> `x = a ? b : c;`

2. **IfRegionVisitor Control Flow Inversion** (`if_region_visitor.rs`)
   - Added `cfg: &CFG` parameter for real instruction inspection
   - `ends_with_return_or_throw()` using actual instruction inspection
   - `has_exit_block()` with block access
   - `is_throw_only_region()` and `block_is_throw_only()` for JADX throw inversion
   - Rule 9: If else is single throw, invert to put throw in then

3. **Nested IF Merging** (`conditionals.rs`)
   - `merge_nested_conditions()` implementing JADX's `mergeNestedIfNodes()`
   - AND/OR pattern detection

4. **Loop Pattern Detection** (`loop_analysis.rs`)
   - While -> For conversion
   - Enhanced for-each reconstruction
   - Loop condition inversion

---

### 5. Code Optimization

| JADX Pass | Dexterity Equivalent | Status | Notes |
|-----------|---------------------|--------|-------|
| `ModVisitor.java` (633 lines) | `mod_visitor.rs` (831 lines) + `body_gen.rs` | DONE | StringBuilder chains, field arithmetic (Dec 22, 2025) |
| `SimplifyVisitor.java` (637 lines) | `simplify.rs` (1,820 lines) | DONE | CMP unwrapping + ternary CMP support, dead CMP elimination |
| `CodeShrinkVisitor.java` | `code_shrink.rs` (1,055 lines) | DONE | Variable inlining |
| `ConstInlineVisitor.java` (307 lines) | `const_inline.rs` (471 lines) | DONE | Constant inlining |
| `ReplaceNewArray.java` | `mod_visitor.rs` | DONE | Array init patterns |
| `DeboxingVisitor.java` (181 lines) | `deboxing.rs` (429 lines) | DONE | BoxingType detection at codegen |

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
- StringBuilder chain (DONE Dec 22) - body_gen.rs parse_stringbuilder_chain()
- CMP instruction inlining (in simplify.rs, not mod_visitor.rs)
- Field arithmetic compound assignment (DONE) - body_gen.rs detect_increment_decrement() and detect_field_increment()
- Boolean negation (DONE) - if_region_visitor.rs invert_if_region()
```

**All ModVisitor Patterns Now Implemented (Dec 22, 2025)**

StringBuilder chain optimization works at codegen level by parsing inlined expression strings
(`parse_stringbuilder_chain()` in `body_gen.rs`). This approach bypasses SSA register renaming
issues by operating on the final expression text.

---

### 6. Variable Naming

| JADX Pass | Dexterity Equivalent | Status | Notes |
|-----------|---------------------|--------|-------|
| `ProcessVariables.java` | `process_variables.rs` (344 lines) | **DONE** (Dec 22) | Unused var removal, CodeVar finalization |
| `ApplyVariableNames.java` | `var_naming.rs` (2,672 lines) | **DONE** | SSAContext-aware naming |
| `CodeRenameVisitor.java` | - | MISSING | Deobfuscation naming |

Dexterity Variable Naming (Dec 22, 2025):
- `var_naming.rs` (2,672 lines): JADX-style variable naming with SSAContext integration
- `process_variables.rs` (344 lines): Remove unused variables, finalize CodeVars
- Type-based name generation with enhanced semantics
- Scope analysis with SSA information
- Common type prefixes (str, list, map, etc.)

---

### 7. Post-Type Inference Passes

| JADX Pass | Dexterity Equivalent | Status | Priority |
|-----------|---------------------|--------|----------|
| `FixTypesVisitor.java` | `fix_types.rs` (834 lines) | DONE | HIGH |
| `FinishTypeInference.java` | `finish_type_inference.rs` (298 lines) | DONE | HIGH |
| `DeboxingVisitor.java` | `deboxing.rs` (429 lines) | DONE | MEDIUM |
| `GenericTypesVisitor.java` | `generic_types.rs` (178 lines) | DONE | Attach generic type info to constructors |
| `ShadowFieldVisitor.java` | `shadow_field.rs` (308 lines) | DONE | Fix shadowed field access with super/cast |

Implemented passes:

1. **FixTypesVisitor** (`fix_types.rs`) - Heuristic fallbacks for unresolved types
   - 8 strategies: RestoreTypeVarCasts, InsertCasts, DeduceTypes, SplitConstInsns,
     FixIncompatiblePrimitives, ForceImmutableTypes, InsertAdditionalMove, RemoveGenerics
2. **DeboxingVisitor** (`deboxing.rs`) - Remove primitive boxing calls
   - Handles Integer, Boolean, Byte, Short, Character, Long, Float, Double
   - Utility functions for wrapper class detection
3. **FinishTypeInference** (`finish_type_inference.rs`) - Type validation after inference
   - Validates all SSA variables have known types
   - Generates warnings for variables with unknown types
   - Returns statistics about type inference completeness

---

### 8. Specialized Passes

| JADX Pass | Dexterity Equivalent | Status | Notes |
|-----------|---------------------|--------|-------|
| `EnumVisitor.java` | `enum_visitor.rs` (643 lines) | DONE | Enum reconstruction |
| `ConstructorVisitor.java` | `constructor_visitor.rs` (271 lines) | **DONE** (Dec 22) | super/this calls, field initializers |
| `MethodInvokeVisitor.java` (441 lines) | `method_invoke.rs` (441 lines) | DONE | Overload resolution with explicit casts |
| `SwitchOverStringVisitor.java` | `body_gen.rs` | DONE | Two-switch pattern merge (79% coverage) |
| `ExtractFieldInit.java` | `extract_field_init.rs` (1,024 lines) | DONE | Field init extraction |

---

### 9. Pre-Decompile Passes

| JADX Pass | Dexterity Impl | Status | Priority | Notes |
|-----------|----------------|--------|----------|-------|
| `SignatureProcessor.java` | - | NOT YET | HIGH | Parse generic type signatures |
| `OverrideMethodVisitor.java` | `method_gen.rs` | **~99% PARITY** | DONE | @Override detection via known-methods database |
| `AddAndroidConstants.java` | - | NOT YET | MEDIUM | R.id.xxx replacement |
| `DeobfuscatorVisitor.java` | - | NOT YET | LOW | Name deobfuscation |
| `UsageInfoVisitor.java` | `usage_info.rs` (340 lines) | **DONE** (Dec 22) | MEDIUM | Usage graph for classes/methods/fields |
| `ProcessAnonymous.java` | `process_anonymous.rs` (445 lines) | **DONE** (Dec 22) | MEDIUM | Anonymous/lambda detection |
| `AttachMethodDetails.java` | `attach_method_details.rs` (354 lines) | **DONE** (Dec 22) | HIGH | Method signatures, throws, generics |
| `ReturnVisitor.java` | `return_visitor.rs` (204 lines) | **DONE** (Dec 22) | MEDIUM | Return statement optimization |
| `PostProcessRegions.java` | `post_process_regions.rs` (213 lines) | **DONE** (Dec 22) | MEDIUM | Loop condition merging, switch breaks |

**OverrideMethodVisitor Implementation (Dec 22, 2025):**
- Added comprehensive known-methods database (~80 interfaces/classes, ~500 methods)
- Covers java.lang.*, java.util.*, java.io.*, Android lifecycle, OkHttp, RxJava, Glide
- Achieves 99% @Override parity (10,508 vs JADX's 10,631 on test APK)

**New Passes (Dec 22, 2025):**
- `usage_info.rs`: Builds dependency graph tracking class/method/field usage
- `process_anonymous.rs`: Detects single-use synthetic classes for potential inlining
- `attach_method_details.rs`: Parses method signatures including generic parameters like `<T extends Comparable>` and throws clauses
- `return_visitor.rs`: Optimizes return statements for cleaner output
- `post_process_regions.rs`: Inserts edge instructions, merges loop conditions into headers

---

## Implementation Priority Roadmap

### Phase 1: Type Inference Enhancement (COMPLETED)
1. ✅ Create `type_bound.rs` with TypeBound trait hierarchy
2. ✅ Create `type_update.rs` with propagation engine
3. ✅ Integrate new TypeBound system into `type_inference.rs`
4. ✅ Create `fix_types.rs` for heuristic fallbacks
5. ✅ Create `deboxing.rs` for primitive unboxing

### Phase 2: Post-Type Passes (COMPLETED)
1. ✅ `FinishTypeInference` pass - type validation (`finish_type_inference.rs`)
2. ✅ `GenericTypesVisitor` - generic type application (`generic_types.rs`)
3. ✅ `ShadowFieldVisitor` - shadowed field handling (`shadow_field.rs`)

### Phase 3: Region Enhancement - **COMPLETED Dec 19, 2025**
1. ✅ Enhance `IfRegionMaker` - AND/OR merging (conditionals.rs)
2. ✅ Enhance `LoopRegionVisitor` - while->for conversion (loop_analysis.rs)
3. ✅ Add `TernaryDetection` - ternary expression recognition (ternary_mod.rs)
4. ✅ Add `IfRegionVisitor` - 9 branch reordering rules (if_region_visitor.rs)

### Phase 4: Code Optimization - **COMPLETED Dec 22, 2025**
1. ✅ Full StringBuilder chain detection - body_gen.rs parse_stringbuilder_chain()
2. ✅ Field arithmetic conversion (`a += 2`) - body_gen.rs detect_increment_decrement() and detect_field_increment()
3. ✅ CMP instruction inlining - simplify.rs (Dec 21, 2025)
4. ✅ Boolean negation propagation - if_region_visitor.rs invert_if_region()

### Phase 5: Specialized Passes - PARTIAL
1. `ConstructorVisitor` - constructor handling (PARTIAL - basic handling in codegen)
2. ✅ `MethodInvokeVisitor` - overload resolution - method_invoke.rs (441 lines)
3. `SignatureProcessor` - generic signatures (NOT YET)

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
| Region Building | ~2,000 | ~2,100 |
| Code Optimization | ~3,000 | ~2,500 |
| Variable Naming | ~800 | ~3,000 |
| SSA | ~500 | ~1,900 |
| Pre-Decompile | ~1,500 | ~1,800 |
| Validation | ~800 | ~830 |
| **Total** | **~13,100** | **~15,630** |

Note: Dexterity now has more comprehensive pass implementations than JADX in some areas (Dec 22, 2025).

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
