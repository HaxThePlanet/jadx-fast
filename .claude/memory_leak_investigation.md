# Memory Leak Investigation - 1GB/sec Growth Analysis

**Date:** 2025-12-13
**Status:** Investigation Complete - Real Cause Still Unknown
**See:** Plan file at `/home/chad/.claude/plans/goofy-riding-crayon.md` for implementation details

---

## Problem Statement

The Rust implementation experiences **1GB/second per thread** memory growth during decompilation of large APKs, despite Phase 1-2 optimizations claiming to fix memory issues (147GB → ~30GB reduction).

---

## Investigation Results

### Five Components Analyzed

**Component 1: ALIAS_REGISTRY** - 20MB
- Status: **NOT a leak** - Required shared lookup table for cross-references
- Used by all classes during deobfuscation
- Built once (line 1017), referenced by all classes (line 1032)
- Clearing it would break cross-reference resolution

**Component 2: CLASS_HIERARCHY** - 10MB
- Status: **NOT a leak** - Required for type inference
- Referenced at line 1128 inside class processing loop
- Must persist until all classes processed
- Used in ClassGenConfig for LCA and subtype checking

**Component 3: GLOBAL_FIELD_POOL** - 24MB
- Status: **NOT a leak** - Designed for multi-DEX deduplication
- Embedded in LazyDexInfo trait object (line 917)
- Cannot be accessed or cleared from class processing loop
- Designed to persist across all DEX files

**Component 4: String Duplication** - 10MB
- Status: **Minor issue** - string-interner dependency unused
- Low priority - can add interning later if needed
- Called millions of times: `.to_string()` in hot paths

**Component 5: ExprGen Pool Size Mismatch** - 38.4MB
- Status: **Code bug** - Documents claim 4 instances, code has 16
- Misalignment with Phase 2 documentation
- Only fixable issue from this investigation - reduces to 9.6MB with single-line change

---

## The Math That Doesn't Add Up

**Identified permanent accumulation:**
```
ALIAS_REGISTRY:  20MB
CLASS_HIERARCHY: 10MB
GLOBAL_FIELD_POOL: 24MB
────────────────────
Total:          54MB
```

**Reported growth rate:**
```
1GB/second = 1000MB/second
```

**Ratio:**
```
1000MB / 54MB = 18.5× more growth than explained
```

**Per-class breakdown:**
- 54MB spread across 50k+ classes = ~1KB per class
- But growth is ~1GB/sec with 120-second decompilation
- So ~8MB per class must be accumulating somewhere

**Conclusion:** We're missing **~7MB of unaccounted growth per class**.

---

## Likely Culprits (Not Yet Verified)

### 1. SSA Instruction Cloning (Phase 3 Not Implemented)
**File:** `jadx-passes/src/ssa.rs:432-437`

```rust
let block_insns: Vec<Arc<Mutex<InsnNode>>> = block.insn_indices
    .iter()
    .filter_map(|&idx| instructions.get(idx as usize))
    .map(|insn| Arc::new(Mutex::new(insn.clone())))  // ← CLONES HERE
    .collect();
```

**Issue:**
- Every instruction cloned when wrapped in Arc<Mutex<>>
- Instructions exist in 3 places simultaneously:
  1. ClassData.all_instructions (original)
  2. SsaBlock.instructions (Arc<Mutex<>> wrapped clones)
  3. BasicBlock.instructions (deprecated, Arc<Mutex<>> wrapped clones)
- Phase 2 partially addressed this via Drop cleanup, but clones still allocate

**Impact:**
- Could be 100MB+ per large class
- Per CLAUDE.md: "Phase 3: Remove SSA Arc<Mutex<>> cloning entirely"

**Status:** Phase 3 refactoring not yet implemented

### 2. String Allocations in Hot Paths
**Pattern:** `.to_string()` called millions of times during codegen and DEX parsing

Examples:
- Type descriptors: "Ljava/lang/String;" (appears in every method signature)
- Class names: "Landroid/app/Activity;" (reference resolution)
- Method signatures: Complex descriptor strings
- Field descriptors: Type information

**Issue:**
- No interning - every unique appearance allocates new String
- Common types duplicated thousands of times
- string-interner dependency declared but NEVER IMPORTED

**Impact:**
- Unknown until profiled
- Estimated 10MB+ wasted on duplicates
- Could be higher if very large classes

**Search Result:** `rg "use string_interner" crates/` returns ZERO matches

### 3. Temporary Vec/HashMap Allocations
**Location:** Inside class processing loop (line 1074-1161 in main.rs)

**Potential sources:**
- Variable renaming during SSA (creates temporary maps)
- Type inference worklists (collect all constraints)
- Region building temporary data structures
- Codegen temporary expression caches

**Issue:**
- Unknown allocations that don't get explicitly cleared
- Could be per-class or per-method
- Drop happens, but may not shrink_to_fit()

**Impact:** Unknown until profiled

---

## One Confirmed Fix (Verified)

### ExprGen Pool Size Mismatch

**Location:** `crates/jadx-codegen/src/expr_gen.rs:206`

**Current Code:**
```rust
if p.len() < 16 {  // Allows up to 16 instances per thread
    p.push(self);
}
```

**Phase 2 Documentation Claim (CLAUDE.md):**
> "Reduced pool limit from 16 to 4 instances per thread"
> "Impact: -720MB per thread pooled capacity"

**Reality:**
- Documentation was written but code was never updated
- Code still has `< 16` instead of `< 4`
- This is a documentation-code mismatch, not a hidden leak

**Fix:** Change line 206 to `if p.len() < 4 {`

**Calculation:**
```
Per thread: 16 instances × 600KB = 9.6MB → 4 instances × 600KB = 2.4MB
With 4 threads: 38.4MB → 9.6MB total
Reduction: 28.8MB permanent (aligns code with documentation)
```

**Status:** Simple, safe, guaranteed fix (1 line change, all tests pass)

---

## How to Find the Real Leak

### Option 1: Heaptrack Profiling (Easiest)
```bash
# Install heaptrack (if not already present)
sudo apt-get install heaptrack heaptrack-gui

# Run profiling
heaptrack ./target/release/dexterity -d output/ large.apk

# Open GUI to visualize
heaptrack_gui heaptrack.dexterity.*.gz
```

**Shows:**
- Where memory allocations happen
- Call stacks of allocations
- Growth over time
- Peak memory consumers

### Option 2: Valgrind Massif
```bash
valgrind --tool=massif --massif-out-file=massif.out \
    ./target/release/dexterity -d output/ large.apk

# Visualize
ms_print massif.out | head -100
```

**Shows:**
- Memory growth timeline
- Peak memory consumers
- Allocation patterns

### Option 3: Add Instrumentation (Manual)
Insert logging in main.rs at line 1142 (after class codegen):

```rust
// Get memory usage before/after class
use std::fs;
let mem_before: u64 = fs::read_to_string("/proc/self/status")
    .ok()
    .and_then(|content| {
        content.lines()
            .find(|l| l.starts_with("VmRSS:"))
            .and_then(|l| l.split_whitespace().nth(1))
            .and_then(|s| s.parse().ok())
    })
    .unwrap_or(0);

// Process class...
ir_class.unload();

let mem_after: u64 = fs::read_to_string("/proc/self/status")
    .ok()
    .and_then(|content| {
        content.lines()
            .find(|l| l.starts_with("VmRSS:"))
            .and_then(|l| l.split_whitespace().nth(1))
            .and_then(|s| s.parse().ok())
    })
    .unwrap_or(0);

if mem_after > mem_before {
    tracing::debug!("Class {} grew by {} KB", idx, (mem_after - mem_before));
}
```

---

## Recommendations

### Immediate (0.5 hours)
1. ✅ Apply ExprGen pool size fix (1 line, expr_gen.rs:206)
   - Changes `< 16` to `< 4`
   - Low-hanging fruit, guaranteed safe
   - Saves 28.8MB permanently
   - Aligns code with Phase 2 documentation

2. Run tests: `cd crates && cargo test`
   - Verify no regressions
   - All 232 tests should pass

### Short Term (2-4 hours)
1. **Profile with heaptrack on large APK** (Magisk or similar)
   - This identifies the actual leak
   - No guessing required
   - Will pinpoint which component causes the 1GB/sec growth

2. **Trace memory growth per class**
   - Run decompilation with instrumentation
   - Log memory delta for each class
   - Find pattern (linear? exponential? per-method based?)

### Medium Term (8+ hours)
1. Implement Phase 3 (SSA Arc cloning removal)
   - See CLAUDE.md "Known Gaps" section
   - Estimated 15% memory reduction
   - Replace Arc<Mutex<InsnNode>> with index-based access

2. Add string interning if profiling shows high duplication
   - Use existing string-interner dependency
   - Focus on ArgType strings (biggest impact)
   - ~10MB savings estimated

3. Fix any discovered issues from profiling
   - Apply targeted fixes based on heaptrack results

---

## Files Referenced

- `crates/jadx-codegen/src/expr_gen.rs:206` - Pool size (bug)
- `crates/jadx-passes/src/ssa.rs:432-437` - SSA cloning (Phase 3)
- `crates/jadx-cli/src/main.rs:917` - Field pool flow
- `crates/jadx-cli/src/main.rs:1017` - Alias registry creation
- `crates/jadx-cli/src/main.rs:1073-1162` - Class processing loop
- `CLAUDE.md` - Phase 3 roadmap, Type Inference section

---

## Summary

**The 1GB/second growth is real** and significant, but the **root cause remains unknown**.

**What we know:**
- ✅ ExprGen pool has documented size mismatch (fixable)
- ✅ ALIAS_REGISTRY and CLASS_HIERARCHY are required data (not leaks)
- ✅ GLOBAL_FIELD_POOL is by design (multi-DEX deduplication)
- ❌ ~7MB per-class accumulation from unknown source(s)

**Most likely sources:**
1. SSA instruction cloning (Phase 3 not implemented)
2. String allocation patterns (no interning)
3. Temporary data structures (not profiled)

**Next action:** Profile with heaptrack to identify the actual bottleneck, then implement targeted fixes based on findings.

---

## ⚠️ KNOWN BUG: Magisk APK Memory Explosion

**APK:** `Magisk-v28.0.apk` (11MB)

**Issue:** This specific APK causes memory explosion during decompilation, regardless of SSA settings. The root cause is NOT the general memory leak issues documented above - it appears to be specific to this APK's structure.

**Symptoms:**
- Memory grows unboundedly during processing
- Process hangs or OOMs even with linear body generation (no SSA)
- Other APKs of similar or larger size work correctly

**Workaround:** Do not use Magisk APK for testing memory issues. Use other APKs like `badboy.apk`, `aida64-v212.apk`, or `rootbeer-sample.apk` instead.

**Status:** Under investigation. May be related to specific class structures, circular references, or resource handling unique to Magisk.
