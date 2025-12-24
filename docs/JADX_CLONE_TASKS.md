# JADX Clone Tasks

**Purpose:** Actionable tasks to achieve 100% JADX parity
**Reference:** `jadx-fast/jadx-core/src/main/java/jadx/core/dex/visitors/`
**Updated:** Dec 23, 2025

---

## P0: Critical (Affects Output Quality)

### Task 1: Iterator For-Each Method Resolution
**File:** `crates/dexterity-passes/src/loop_analysis.rs`
**JADX:** `LoopRegionVisitor.java:246-384`
**Status:** Partial - detection exists but method resolver returns false

**Problem:**
The `is_has_next_call()`, `is_iterator_call()`, and `is_next_call()` functions in `loop_analysis.rs:709-764` always return `false` when no method resolver is provided. This means iterator for-each patterns are never detected.

**Solution:**
```rust
// JADX Clone: LoopRegionVisitor.java:389-405
// checkInvoke(insn, declClsFullName, mthId)
pub fn check_invoke(
    insn: &InsnNode,
    method_resolver: &dyn Fn(u32) -> Option<MethodInfo>,
    decl_cls: Option<&str>,
    short_id: &str,
) -> bool {
    if let InsnType::Invoke { method_idx, kind, .. } = &insn.insn_type {
        if !matches!(kind, InvokeKind::Virtual | InvokeKind::Interface) {
            return false;
        }
        if let Some(info) = method_resolver(*method_idx) {
            if info.short_id == short_id {
                if let Some(cls) = decl_cls {
                    return info.decl_class == cls;
                }
                return true;
            }
        }
    }
    false
}
```

**Files to modify:**
1. `crates/dexterity-passes/src/loop_analysis.rs` - Add method resolver parameter
2. `crates/dexterity-passes/src/lib.rs` - Export MethodInfo struct
3. Caller must pass DEX method resolution callback

---

### Task 2: StringBuilder Chain to STR_CONCAT
**File:** `crates/dexterity-passes/src/simplify.rs`
**JADX:** `SimplifyVisitor.java:305-428`
**Status:** MISSING

**What JADX does:**
Converts:
```java
new StringBuilder().append(a).append(b).toString()
```
To:
```java
a + b
```

**Clone from JADX:**
```java
// SimplifyVisitor.java:305-323
private static InsnNode convertInvoke(MethodNode mth, InsnNode insn) {
    MethodInfo callMth = ((InvokeNode) insn).getCallMth();
    if (callMth.getDeclClass().getFullName().equals("java.lang.StringBuilder")) {
        return convertStringBuilderChain(mth, (InvokeNode) insn);
    }
    return null;
}

// SimplifyVisitor.java:369-428
private static InsnNode convertStringBuilderChain(MethodNode mth, InvokeNode insn) {
    // Pattern: new StringBuilder().append(x).append(y)...toString()
    // Walk backwards through the chain
    // Collect all append arguments
    // Create STR_CONCAT with all args
}
```

---

### Task 3: Field Visibility Cast Insertion
**File:** `crates/dexterity-passes/src/mod_visitor.rs`
**JADX:** `ModVisitor.java:175-211`
**Status:** MISSING

**What JADX does:**
When a field is accessed on a subclass but is defined in a superclass with package-private visibility, JADX inserts a cast:
```java
// Before: subclassRef.packagePrivateField
// After: ((SuperClass) subclassRef).packagePrivateField
```

**Clone this logic:**
```java
// ModVisitor.java:175-211
private static void fixFieldUsage(MethodNode mth, IndexInsnNode insn) {
    InsnArg instanceArg = insn.getArg(insn.getType() == InsnType.IGET ? 0 : 1);
    if (instanceArg.contains(AFlag.SUPER)) {
        return;
    }
    FieldInfo fieldInfo = (FieldInfo) insn.getIndex();
    if (!isFieldVisibleInMethod(mth, fieldInfo)) {
        // Insert cast to declaring class
        ArgType declType = ArgType.object(fieldInfo.getDeclClass().getFullName());
        InsnNode castNode = new IndexInsnNode(InsnType.CHECK_CAST, declType, 1);
        // ... wrap instance arg in cast
    }
}
```

---

### Task 4: Fix Type Descriptor in Field Names (Balloon.java P0)
**File:** `crates/dexterity-codegen/src/` (type formatting)
**Evidence:** Balloon.java comparison
**Status:** BUG

**Problem:**
Field names contain raw type descriptors instead of proper names:
```java
// Dexterity (WRONG):
private final h Lcom/skydoves/balloon/d;;  // Type descriptor in name!

// JADX (Correct):
private final kotlin.h autoDismissRunnable;
```

**Root Cause:** Type descriptor `Lcom/skydoves/balloon/d;` being concatenated into field name instead of being formatted as type.

**Fix:** Check field name generation in codegen - ensure type descriptors are only used for type annotations, not names.

---

### Task 5: Kotlin d2 Metadata Field Rename (Balloon.java P0)
**File:** `crates/dexterity-kotlin/src/extractor.rs`
**JADX:** Uses `@Metadata` annotation `d2` array for field names
**Status:** NOT IMPLEMENTED

**Problem:**
Kotlin metadata contains real field names in `d2` array but Dexterity doesn't use them:
```java
// Dexterity (WRONG):
private final Context onBalloonClickListener;  // Wrong name

// JADX (Correct):
/* renamed from: C, reason: from kotlin metadata */
private final Context context;  // Correct name from d2
```

**JADX Implementation:**
```java
// KotlinMetadataParseHelper.java
// Parses d2 array from @Metadata annotation
// Maps obfuscated names to original Kotlin names
// d2 contains: class name, field names, method names, parameter names
```

**Files to modify:**
1. `crates/dexterity-kotlin/src/extractor.rs` - Parse d2 array for field names
2. `crates/dexterity-deobf/src/` - Apply Kotlin name hints during rename

---

### Task 6: Enum Constant Field Initialization (Balloon.java P0)
**File:** `crates/dexterity-passes/src/collect_const_values.rs`
**JADX:** `visitors/prepare/CollectConstValues.java:49-63`
**Status:** MISSING

**Problem:**
Enum fields initialized with raw integers instead of enum constants:
```java
// Dexterity (WRONG):
public c u = 1056964608;  // Raw float bits as int
public a w = 1056964608;

// JADX (Correct):
this.u = com.skydoves.balloon.c.ALIGN_BALLOON;
this.w = com.skydoves.balloon.a.BOTTOM;
```

**JADX Implementation:**
```java
// CollectConstValues.java:49-63
public static Object getFieldConstValue(FieldNode fld) {
    AccessInfo accFlags = fld.getAccessFlags();
    if (!accFlags.isStatic() || !accFlags.isFinal()) {
        return null;
    }
    // Get enum constant reference from static field
    // Store in constStorage for later replacement
}
```

**Fix:** Implement enum constant collection and replacement during codegen.

---

## P1: High (Correctness)

### Task 7: Loop Pre-Header Insertion
**File:** `crates/dexterity-passes/src/cfg.rs` or new file
**JADX:** `BlockProcessor.java:433-466`
**Status:** MISSING

**What JADX does:**
Inserts a synthetic pre-header block before loop headers with multiple predecessors:
```
Before:          After:
A-->|            A-->|
    v                v
    H (loop)     pre_H-->H (loop)
    ^                    ^
B-->|            B-------|
```

**Clone:**
```java
// BlockProcessor.java:433-466
private static boolean insertPreHeader(MethodNode mth, LoopInfo loop) {
    BlockNode start = loop.getStart();
    List<BlockNode> preds = start.getPredecessors();
    int predsCount = preds.size() - 1; // don't count back edge
    if (predsCount == 1) {
        return false;
    }
    // Create preHeader block, redirect non-back-edge predecessors
    BlockNode preHeader = BlockSplitter.startNewBlock(mth, -1);
    preHeader.add(AFlag.SYNTHETIC);
    // ...
}
```

---

### Task 8: Break/Continue Block Insertion
**File:** `crates/dexterity-passes/src/cfg.rs`
**JADX:** `BlockProcessor.java:471-509`
**Status:** MISSING

**What JADX does:**
Inserts synthetic blocks at loop exits and before loop end for clean break/continue placement.

```java
// BlockProcessor.java:471-488 - insertBlocksForBreak
private static boolean insertBlocksForBreak(MethodNode mth, LoopInfo loop) {
    List<Edge> edges = loop.getExitEdges();
    for (Edge edge : edges) {
        if (!target.contains(AFlag.SYNTHETIC) && !source.contains(AFlag.SYNTHETIC)) {
            BlockSplitter.insertBlockBetween(mth, source, target);
        }
    }
}

// BlockProcessor.java:493-509 - insertBlocksForContinue
private static boolean insertBlocksForContinue(MethodNode mth, LoopInfo loop) {
    // Insert blocks before loop end if multiple predecessors
}
```

---

### Task 9: Ternary Line Hints Verification
**File:** `crates/dexterity-passes/src/ternary_mod.rs`
**JADX:** `TernaryMod.java:172-259`
**Status:** MISSING

**What JADX does:**
Prevents ternary creation when source line hints indicate separate statements.

```java
// TernaryMod.java:172-184
private static boolean verifyLineHints(MethodNode mth, InsnNode thenInsn, InsnNode elseInsn) {
    if (mth.contains(AFlag.USE_LINES_HINTS)
            && thenInsn.getSourceLine() != elseInsn.getSourceLine()) {
        if (thenInsn.getSourceLine() != 0 && elseInsn.getSourceLine() != 0) {
            return checkLineStats(thenInsn, elseInsn);
        }
        return !containsTernary(thenInsn) && !containsTernary(elseInsn);
    }
    return true;
}
```

---

## P2: Medium (Parity)

### Task 10: Deduplicate Block Instructions
**File:** `crates/dexterity-passes/src/cfg.rs`
**JADX:** `BlockProcessor.java:136-161`
**Status:** MISSING

**What JADX does:**
When multiple predecessor blocks end with the same instruction, move it to the successor:
```
Before:          After:
A: i=0           A: (empty)
   v                v
B: i=0           B: (empty)
   v                v
   C     -->        C: i=0
```

---

### Task 11: Merge Const+Return Blocks
**File:** `crates/dexterity-passes/src/cfg.rs`
**JADX:** `BlockProcessor.java:321-350`
**Status:** MISSING

**What JADX does:**
Merges a const instruction block with its following return block:
```
Before:          After:
const r0, 0      return 0
goto L1
L1: return r0
```

---

### Task 12: CMP Inline to IF
**File:** `crates/dexterity-passes/src/mod_visitor.rs`
**JADX:** `ModVisitor.java:378-394`
**Status:** PARTIAL (done in simplify.rs but may differ)

**What JADX does:**
Inlines CMP instruction result directly into IF condition.

---

### Task 13: Annotation Const Replacement
**File:** New file or `mod_visitor.rs`
**JADX:** `ModVisitor.java:279-338`
**Status:** MISSING

**What JADX does:**
Replaces constant references in annotations with actual field values.

---

## P3: Low (Features)

### Task 14: NonFinalResIdsVisitor
**File:** New file `crates/dexterity-passes/src/non_final_res_ids.rs`
**JADX:** `gradle/NonFinalResIdsVisitor.java` (119 lines)
**Status:** MISSING

**Purpose:** Gradle build.gradle flag detection for non-final R.* usage.

Only matters for Gradle export. Low priority.

---

### Task 15: AttachCommentsVisitor
**File:** New file `crates/dexterity-passes/src/attach_comments.rs`
**JADX:** `AttachCommentsVisitor.java` (139 lines)
**Status:** MISSING

**Purpose:** Attach user-added code comments from ICodeData.

Only matters for GUI. Low priority.

---

## Clone Template

When cloning JADX functionality, use this template:

```rust
//! JADX Clone: jadx-core/src/main/java/jadx/core/dex/visitors/SomeVisitor.java
//! Original Author: skylot (JADX - MIT License)
//! Clone Date: Dec 2025
//!
//! This module is a direct port of JADX's SomeVisitor for behavioral parity.

/// JADX Reference: SomeVisitor.java:123-156
///
/// [Copy JADX's Javadoc or add description]
///
/// # Edge Cases (from JADX)
/// - Edge case 1: [describe]
/// - Edge case 2: [describe]
pub fn some_function(/* match JADX params */) -> /* match JADX return */ {
    // JADX: line 123-130 - Phase 1: [description]
    // ... code ...

    // JADX: line 131-140 - Phase 2: [description]
    // ... code ...

    // JADX: line 141-156 - Phase 3: [description]
    // ... code ...
}
```

---

## Testing Parity

After cloning each task:

1. **Compile both tools:**
   ```bash
   cd /mnt/nvme4tb/dexterity && cargo build --release
   cd /mnt/nvme4tb/dexterity/jadx-fast && ./gradlew build
   ```

2. **Decompile test APK with both:**
   ```bash
   ./target/release/dexterity -d output_dexterity input.apk
   ./jadx-fast/build/jadx/bin/jadx -d output_jadx input.apk
   ```

3. **Diff the output:**
   ```bash
   diff -rq output_dexterity output_jadx | head -50
   ```

4. **Check specific patterns:**
   - For iterator for-each: Look for `while (iter.hasNext())` vs `for (T x : collection)`
   - For StringBuilder: Look for `new StringBuilder().append()` vs `+`
   - For ternary: Look for `if { a=x; } else { a=y; }` vs `a = cond ? x : y`

---

## Priority Order for Maximum Impact

1. **P0-Task 2: StringBuilder chain** - Very visible in output
2. **P0-Task 1: Iterator for-each** - Common pattern
3. **P1-Task 4: Loop pre-header** - Required for clean loops
4. **P0-Task 3: Field visibility cast** - Correctness issue
5. **P1-Task 5: Break/continue blocks** - Required for control flow
6. **P1-Task 6: Ternary line hints** - Quality improvement

---

*Generated by Claude Opus 4.5 - Dec 23, 2025*
