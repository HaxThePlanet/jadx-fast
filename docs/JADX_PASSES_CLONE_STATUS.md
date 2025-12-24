# JADX Passes Clone Status

**Status:** Dec 23, 2025 - HONEST REASSESSMENT
**Author:** Claude Opus 4.5
**Reference:** `jadx-fast/jadx-core/src/main/java/jadx/core/dex/visitors/`
**Real-World Parity:** **~75%** (based on Balloon.java comparison)

Previous claims of 90%+ were theoretical structural coverage. Real-world output comparison shows significant gaps.

This document tracks progress toward **100% JADX parity** for the passes layer. JADX has 10 years of battle-tested edge case handling. We must clone its functionality exactly, not reinvent.

## Related Documentation
- **[JADX_PASSES_PARITY_AUDIT.md](JADX_PASSES_PARITY_AUDIT.md)** - Line-by-line source comparison
- **[JADX_CLONE_TASKS.md](JADX_CLONE_TASKS.md)** - Actionable clone tasks with code snippets

---

## Pass Ordering Reference

### JADX Pre-Decompile Passes (Jadx.java:103-119)
| # | JADX Pass | Dexterity | Status | Notes |
|---|-----------|-----------|--------|-------|
| 1 | SignatureProcessor | `signature_processor.rs` | **DONE** | Generic signature parsing |
| 2 | OverrideMethodVisitor | `override_method.rs` | **DONE** | @Override detection |
| 3 | AddAndroidConstants | N/A | **MISSING** | Android R.* constants → fields |
| 4 | DeobfuscatorVisitor | `rename_visitor.rs` (partial) | **70%** | Deobf mapping, class rename |
| 5 | SourceFileRename | N/A | **MISSING** | Rename classes from SourceFile attr |
| 6 | RenameVisitor | `rename_visitor.rs` | **DONE** | Name validation, collision fix |
| 7 | SaveDeobfMapping | N/A | **MISSING** | Persist deobf mappings to file |
| 8 | UsageInfoVisitor | `usage_info.rs` | **DONE** | Build usage graph |
| 9 | CollectConstValues | N/A | **MISSING** | Collect static final values |
| 10 | ProcessAnonymous | `process_anonymous.rs` | **DONE** | Mark anonymous classes |
| 11 | ProcessMethodsForInline | `method_inline.rs` | **DONE** | Mark methods for inline |

### JADX Regions Mode Passes (Jadx.java:122-212)

#### Instructions IR Phase
| # | JADX Pass | Dexterity | Status | Notes |
|---|-----------|-----------|--------|-------|
| 1 | CheckCode | `check_code.rs` | **DONE** | Register bounds, >255 args |
| 2 | DebugInfoAttachVisitor | `debug_info.rs` | **85%** | Line numbers, local vars |
| 3 | AttachTryCatchVisitor | `region_builder.rs` | **DONE** | Try-catch block detection |
| 4 | AttachCommentsVisitor | N/A | **MISSING** | User code comments |
| 5 | AttachMethodDetails | `attach_method_details.rs` | **DONE** | Signature parsing |
| 6 | ProcessInstructionsVisitor | `process_instructions.rs` | **DONE** | Merge Invoke+MoveResult |

#### Blocks IR Phase
| # | JADX Pass | Dexterity | Status | Notes |
|---|-----------|-----------|--------|-------|
| 7 | BlockSplitter | `block_split.rs` | **DONE** | Basic block creation |
| 8 | BlockProcessor | `cfg.rs` + `algorithms/` | **90%** | Dominators, loops, exit splits |
| 9 | BlockFinisher | N/A (implicit) | **DONE** | Lock blocks (simple pass) |

#### SSA Phase
| # | JADX Pass | Dexterity | Status | Notes |
|---|-----------|-----------|--------|-------|
| 10 | SSATransform | `ssa.rs` | **DONE** | PHI insertion, var renaming |
| 11 | MoveInlineVisitor | `move_inline.rs` | **DONE** | Inline move instructions |
| 12 | ConstructorVisitor | `constructor_visitor.rs` | **DONE** | super()/this() handling |
| 13 | InitCodeVariables | `init_code_vars.rs` | **DONE** | SSAVar→CodeVar linking |
| 14 | MarkFinallyVisitor | `finally_extract.rs` | **DONE** | Finally block detection |
| 15 | ConstInlineVisitor | `const_inline.rs` | **DONE** | Inline constant values |

#### Type Inference Phase
| # | JADX Pass | Dexterity | Status | Notes |
|---|-----------|-----------|--------|-------|
| 16 | TypeInferenceVisitor | `type_inference.rs` | **85%** | Constraint-based inference |
| 17 | DebugInfoApplyVisitor | `debug_info.rs` | **80%** | Apply types from debug info |
| 18 | FixTypesVisitor | `fix_types.rs` | **DONE** | 8 fallback strategies |
| 19 | FinishTypeInference | `finish_type_inference.rs` | **DONE** | Final validation |

#### Code Optimization Phase
| # | JADX Pass | Dexterity | Status | Notes |
|---|-----------|-----------|--------|-------|
| 20 | ProcessKotlinInternals | `kotlin_intrinsics.rs` | **DONE** | Intrinsics.checkNotNull etc |
| 21 | CodeRenameVisitor | N/A | **MISSING** | User variable renames |
| 22 | InlineMethods | `inline_methods.rs` | **DONE** | Inline small methods |
| 23 | GenericTypesVisitor | `generic_types.rs` | **DONE** | Generic type attachment |
| 24 | ShadowFieldVisitor | `shadow_field.rs` | **DONE** | this$0 → OuterClass.this |
| 25 | DeboxingVisitor | `deboxing.rs` | **DONE** | Integer→int etc |
| 26 | AnonymousClassVisitor | `anonymous_class_visitor.rs` | **DONE** | Inline anonymous classes |
| 27 | ModVisitor | `mod_visitor.rs` | **DONE** | Code modifications |
| 28 | CodeShrinkVisitor | `code_shrink.rs` | **DONE** | Inline wrapped args |
| 29 | ReplaceNewArray | `replace_new_array.rs` | **DONE** | new int[]{1,2,3} |

#### Regions IR Phase
| # | JADX Pass | Dexterity | Status | Notes |
|---|-----------|-----------|--------|-------|
| 30 | RegionMakerVisitor | `region_builder.rs` | **90%** | Build region tree |
| 31 | IfRegionVisitor | `if_region_visitor.rs` | **DONE** | Simplify if regions |
| 32 | SwitchOverStringVisitor | `switch_over_string.rs` | **DONE** | String switch pattern |
| 33 | ReturnVisitor | `return_visitor.rs` | **DONE** | Return optimization |
| 34 | CleanRegions | `clean_regions.rs` | **DONE** | Remove empty regions |

#### Post-Processing Phase
| # | JADX Pass | Dexterity | Status | Notes |
|---|-----------|-----------|--------|-------|
| 35 | MethodThrowsVisitor | `method_throws_visitor.rs` | **DONE** | Throws clause |
| 36 | CodeShrinkVisitor (2nd) | `code_shrink.rs` | **DONE** | Another shrink pass |
| 37 | MethodInvokeVisitor | `method_invoke.rs` | **DONE** | Varargs, casts |
| 38 | SimplifyVisitor | `simplify.rs` | **DONE** | Expression simplify |
| 39 | CheckRegions | `check_regions.rs` | **DONE** | Validate coverage |

#### Class Processing Phase
| # | JADX Pass | Dexterity | Status | Notes |
|---|-----------|-----------|--------|-------|
| 40 | EnumVisitor | `enum_visitor.rs` | **DONE** | Enum reconstruction |
| 41 | FixSwitchOverEnum | `fix_switch_over_enum.rs` | **DONE** | Switch map → ordinal |
| 42 | NonFinalResIdsVisitor | N/A | **MISSING** | Gradle nonFinalResIds flag |
| 43 | ExtractFieldInit | `extract_field_init.rs` | **DONE** | Field initializers |
| 44 | FixAccessModifiers | N/A | **MISSING** | private→package for inner |
| 45 | ClassModifier | `class_modifier.rs` | **DONE** | Synthetic field hide |
| 46 | LoopRegionVisitor | `loop_analysis.rs` | **80%** | For-loop patterns |
| 47 | SwitchBreakVisitor | `switch_break_visitor.rs` | **DONE** | Optimize switch breaks |

#### Variable Naming Phase
| # | JADX Pass | Dexterity | Status | Notes |
|---|-----------|-----------|--------|-------|
| 48 | MarkMethodsForInline | `method_inline.rs` | **DONE** | 2nd pass inline marks |
| 49 | ProcessVariables | `process_variables.rs` | **DONE** | Finalize CodeVars |
| 50 | ApplyVariableNames | `var_naming.rs` | **DONE** | Name generation |

#### Final Phase
| # | JADX Pass | Dexterity | Status | Notes |
|---|-----------|-----------|--------|-------|
| 51 | PrepareForCodeGen | `prepare_for_codegen.rs` | **DONE** | Final prep |

---

## Missing Passes - Priority Clone List

### P1 (High Priority - Affects Output Quality)

#### 1. FixAccessModifiers.java (122 lines)
**Location:** `visitors/fixaccessmodifiers/FixAccessModifiers.java`
**Purpose:** Change private→package for inner class access

```java
// JADX: FixAccessModifiers.java:58-67
// When inner class accesses private method of outer class,
// compiler generates synthetic accessor. JADX detects this and
// changes visibility to package-private instead.
private void fixClassVisibility(ClassNode cls) {
    AccessInfo accessFlags = cls.getAccessFlags();
    if (cls.isTopClass() && (accessFlags.isPrivate() || accessFlags.isProtected())) {
        changeVisibility(cls, AccessFlags.PUBLIC);
    }
    // ... visibility checks based on usage
}
```

**Clone To:** `crates/dexterity-passes/src/fix_access_modifiers.rs`

#### 2. LoopRegionVisitor.java Enhancement (457 lines)
**Location:** `visitors/regions/LoopRegionVisitor.java`
**Gap:** Iterator for-each (`for (T x : collection)`) pattern is **incomplete**

```java
// JADX: LoopRegionVisitor.java:246-340
// checkIterableForEach() - detect Iterator.hasNext()/next() pattern
private static boolean checkIterableForEach(MethodNode mth, LoopRegion loopRegion, IfCondition condition) {
    // Find iterator assign: Collection.iterator()
    // Find hasNext call in condition
    // Find next() call in loop body
    // Verify all uses are inside loop
}
```

**Clone To:** Enhance `crates/dexterity-passes/src/loop_analysis.rs`

### P2 (Medium Priority)

#### 3. AddAndroidConstants.java (45 lines)
**Location:** `visitors/prepare/AddAndroidConstants.java`
**Purpose:** Add android.R.* constants from resource mapping

```java
// JADX: AddAndroidConstants.java:27-44
// Before CollectConstValues, add Android SDK R.* constants
// so they can be resolved during const replacement
AndroidResourcesMap.getMap().forEach((resId, path) -> {
    int sep = path.indexOf('/');
    String clsName = R_INNER_CLS + path.substring(0, sep);
    String resName = path.substring(sep + 1);
    constStorage.addGlobalConstField(field, resId);
});
```

**Clone To:** `crates/dexterity-passes/src/add_android_constants.rs`

#### 4. CollectConstValues.java (65 lines)
**Location:** `visitors/prepare/CollectConstValues.java`
**Purpose:** Store static final field values for const replacement

```java
// JADX: CollectConstValues.java:49-63
// For unused static final fields, store their compile-time values
// so references can be replaced with literals
public static Object getFieldConstValue(FieldNode fld) {
    AccessInfo accFlags = fld.getAccessFlags();
    if (!accFlags.isStatic() || !accFlags.isFinal()) {
        return null;
    }
    if (!fld.getUseIn().isEmpty()) {
        return null; // still used, don't inline
    }
    return constVal.getValue();
}
```

**Clone To:** `crates/dexterity-passes/src/collect_const_values.rs`

#### 5. CodeRenameVisitor.java (126 lines)
**Location:** `visitors/rename/CodeRenameVisitor.java`
**Purpose:** Apply user-defined variable renames (GUI feature)

```java
// JADX: CodeRenameVisitor.java:74-103
// Process user renames stored in ICodeData
// Supports: MTH_ARG (method args) and VAR (local variables)
switch (codeRef.getAttachType()) {
    case MTH_ARG:
        argRegs.get(argNum).getSVar().getCodeVar().setName(rename.getNewName());
        break;
    case VAR:
        // Find SSAVar by regNum + ssaVersion
        ssaVar.getCodeVar().setName(rename.getNewName());
        break;
}
```

**Clone To:** `crates/dexterity-passes/src/code_rename_visitor.rs`

### P3 (Lower Priority)

#### 6. AttachCommentsVisitor.java (140 lines)
**Purpose:** Attach user code comments to AST nodes
**Clone To:** `crates/dexterity-passes/src/attach_comments_visitor.rs`

#### 7. SourceFileRename.java
**Purpose:** Rename classes based on SourceFile attribute
**Clone To:** Enhance `rename_visitor.rs`

#### 8. SaveDeobfMapping.java
**Purpose:** Persist deobfuscation mappings to file
**Clone To:** `crates/dexterity-deobf/src/save_mapping.rs`

#### 9. NonFinalResIdsVisitor.java (119 lines)
**Purpose:** Set Gradle `android.nonFinalResIds = true` when needed
**Clone To:** `crates/dexterity-passes/src/non_final_res_ids.rs`

---

## TernaryMod Status

**JADX:** `regions/TernaryMod.java` (353 lines)
**Dexterity:** `ternary_mod.rs` (670 lines)

### Implemented Patterns
- [x] Assignment in both branches (`r = cond ? a : b`)
- [x] Return from both branches (`return cond ? a : b`)
- [x] Single-branch assignment (constructor pattern)
- [x] PHI merge verification
- [x] JADX-style block validation (exactly 1 instruction)

### Missing Features
- [ ] `verifyLineHints()` - Source line consistency check (lines 172-184)
- [ ] `checkLineStats()` - Statistics for source line validation (lines 230-259)
- [ ] `containsTernary()` - Nested ternary detection (lines 211-225)
- [ ] Iterative optimization with CodeShrinkVisitor (line 37-41)

---

## LoopRegionVisitor Status

**JADX:** `regions/LoopRegionVisitor.java` (457 lines)
**Dexterity:** `loop_analysis.rs` (~400 lines)

### Implemented Patterns
- [x] Indexed for-loop (`for (int i = 0; i < N; i++)`)
- [x] Array for-each (`for (T elem : array)`)
- [x] PHI-based loop variable detection
- [x] usedOnlyInLoop validation
- [x] assignOnlyInLoop validation

### Missing Features
- [ ] **Iterator for-each** (`for (T x : collection)`) - CRITICAL
- [ ] `checkInvoke()` helper for Iterator pattern validation
- [ ] `fixIterableType()` for generic type fixup
- [ ] `REQUEST_IF_REGION_OPTIMIZE` flag after loop conversion

---

## BlockProcessor Status

**JADX:** `blocks/BlockProcessor.java` (769 lines)
**Dexterity:** Distributed across `cfg.rs`, `algorithms/`, `fix_multi_entry_loops.rs`

### Implemented Features
- [x] Dominator computation
- [x] Loop detection and registration
- [x] Back edge identification
- [x] Exit block splitting
- [x] Multi-entry loop fixing

### Missing Features
- [ ] `deduplicateBlockInsns()` - Extract common instructions from predecessors (lines 136-161)
- [ ] `mergeConstReturn()` - Merge const+return blocks (lines 321-350)
- [ ] `simplifyLoopEnd()` - Create synthetic loop end blocks (lines 386-402)
- [ ] `insertPreHeader()` - Insert pre-header for loops (lines 433-466)
- [ ] `insertBlocksForBreak()` - Synthetic break blocks (lines 471-488)
- [ ] `insertBlocksForContinue()` - Synthetic continue blocks (lines 493-509)
- [ ] `splitLoops()` - Split multiple back edges (lines 511-533)
- [ ] Debug modification tracking (lines 749-768)

---

## Debug Info Status

**JADX:** `debuginfo/DebugInfoAttachVisitor.java` (200 lines) + `DebugInfoApplyVisitor.java` (243 lines)
**Dexterity:** `debug_info.rs` (577 lines)

### Implemented Features
- [x] Source line attachment
- [x] Local variable debug info
- [x] Line number verification
- [x] `fix_names_for_phi_insns()` - PHI name propagation
- [x] `fix_lines_for_return()` - Return line fixing
- [x] `process_method_parameters()` - MethodParameters attribute

### Missing Integration
- [ ] Full integration with SSA/TypeInference pipeline
- [ ] `searchAndApplyVarDebugInfo()` with TypeUpdate (line 74-84)
- [ ] Proper TypeUpdateResult handling (line 136-148)

---

## Summary Statistics

| Category | JADX Passes | Dexterity | Coverage |
|----------|-------------|-----------|----------|
| Pre-Decompile | 11 | 8 | 73% |
| Instructions IR | 6 | 5 | 83% |
| Blocks IR | 3 | 3 | 100% |
| SSA | 6 | 6 | 100% |
| Type Inference | 4 | 4 | 100% |
| Code Optimization | 10 | 9 | 90% |
| Regions IR | 5 | 5 | 100% |
| Post-Processing | 5 | 5 | 100% |
| Class Processing | 8 | 7 | 88% |
| Variable Naming | 3 | 3 | 100% |
| Final | 1 | 1 | 100% |
| **TOTAL** | **62** | **56** | **90%** |

### Real-World Parity (Balloon.java Test)

Based on actual output comparison of `com/skydoves/balloon/Balloon.java`:

| Aspect | Parity | Notes |
|--------|--------|-------|
| Structural | ~95% | All classes/methods present |
| Naming | ~70% | Kotlin d2 metadata not used |
| Types | ~80% | Enum constants as raw ints |
| Control Flow | ~85% | Switch case ordering differs |
| **Overall** | **~75-80%** | Visible differences in output |

### Critical Gaps (8 items - updated from Balloon.java)

**P0 - Bugs/Missing (affects output quality):**
1. **Type descriptor in field names** - `Lcom/skydoves/balloon/d;` in names
2. **Kotlin d2 metadata field rename** - Not using metadata for field names
3. **Enum constant resolution** - Raw ints instead of `ALIGN_BALLOON`
4. `CollectConstValues.java` - Static final inlining
5. Iterator for-each in `LoopRegionVisitor.java`

**P1 - Correctness:**
6. `FixAccessModifiers.java` - Inner class visibility
7. Switch case ordering - Region structure differs
8. Kotlin assertion string extraction

### Lower Priority (4 passes)
1. `AttachCommentsVisitor.java` - User comments
2. `SourceFileRename.java` - SourceFile rename
3. `SaveDeobfMapping.java` - Mapping persistence
4. `NonFinalResIdsVisitor.java` - Gradle flag

---

## Clone Guidelines

When cloning JADX passes:

1. **Add Reference Comments**
   ```rust
   //! JADX Clone: jadx-core/.../SomeVisitor.java (NNN lines)
   //! Original Author: Skylot (skylot@gmail.com)
   //! Clone Date: Dec 2025
   ```

2. **Match JADX Line References**
   ```rust
   // JADX Reference: SomeVisitor.java:123-145
   // Purpose: Detect pattern X when Y condition is met
   fn some_function(...) { ... }
   ```

3. **Preserve JADX Logic Exactly**
   - Don't "improve" JADX's logic
   - Edge cases are intentional
   - If something looks wrong, it probably handles a real-world case

4. **Test Against Same APKs**
   - Use same APK samples as JADX tests
   - Output should be identical

---

*Generated by Claude Opus 4.5 on Dec 23, 2025*
