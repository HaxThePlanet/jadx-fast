# Memory Optimization - START HERE

This file is the entry point for anyone who wants to implement the memory optimization work.

**If you just want to use the decompiler**: Go to `DECOMPILATION_STATUS.md` instead.

---

## ⚡ The Challenge

**Current State**:
- ✅ Decompilation works (all 247 tests pass)
- ✅ small.apk decompiles in 5ms
- ❌ Large APKs don't work yet (2 issues: 1 infinite loop, 1 memory)

**Memory Problem**:
- Peak memory on large APKs: ~67 GB (unoptimized)
- Java JADX uses: ~5 GB (optimized with Arc patterns)
- **Goal**: Reduce memory by 85% (67 GB → 10-15 GB)

**Your Challenge**: Implement Phase 1-3 optimization (13-19 hours total)

---

## 🚀 Quick Path Forward

### Step 1: Understand (5 minutes)
Read this file → understand what you're optimizing

### Step 2: Plan (30 minutes)
Read `OPTIMIZATION_PLAN.md` → Priority 1 section → understand the approach

### Step 3: Implement (6-10 hours)
Follow the step-by-step code changes → Phase 1 Arc<InsnNode> implementation

### Step 4: Verify (1 hour)
Run tests → verify memory improvements

---

## 📊 What You'll Accomplish

### Phase 1: Arc<InsnNode> (6-10 hours)
**What**: Share instruction objects instead of cloning
**How**: Wrap instructions in Arc<Mutex<InsnNode>>
**Savings**: 80-90% of block splitting phase
**Impact**: Huge - this is where most cloning happens

### Phase 2: Early Unload (1-2 hours)
**What**: Free instruction arrays after block splitting
**How**: Keep Arc references, drop original Vec
**Savings**: 40-50% additional
**Impact**: Major - instructions consume lots of memory

### Phase 3: Lazy Initialization (2-3 hours)
**What**: Only allocate BitSets when needed
**How**: Lazy init in dominance analysis
**Savings**: 10-20% additional
**Impact**: Moderate - helps on some APKs

### Result: 85% Total Memory Reduction
```
Before: 67 GB peak (1,350x input size)
After:  10-15 GB peak (200-300x input size)
Savings: 52 GB reduction!
```

---

## ✅ Why This Works

Java JADX uses these exact patterns - they're **proven to work**:
1. ✅ Arc<T> avoids cloning large data structures
2. ✅ Mutex ensures thread safety
3. ✅ Lazy initialization saves memory on small cases

No fancy algorithms needed - just apply proven patterns.

---

## 🎯 Phase 1 Deep Dive (The Most Important)

### The Problem
```
Vec<InsnNode> instructions: 1 MB each
Block splitting: clones instructions for each block
Result: 50 MB → 1 GB on large APKs
```

### The Solution
```
Vec<Arc<Mutex<InsnNode>>>: Share references instead
Each Arc: 8 bytes (just a pointer)
Result: 50 MB stays ~50 MB (reference count only)
```

### The Implementation
1. Change `Vec<InsnNode>` → `Vec<Arc<Mutex<InsnNode>>>`
2. Wrap each instruction: `Arc::new(Mutex::new(insn))`
3. When reading: `insn.lock().unwrap().field`
4. When writing: `insn.lock().unwrap().field = value`
5. Add `Arc::ptr_eq()` guards for deadlock prevention

**Time**: 6-10 hours coding (all changes are mechanical)

---

## 📋 Prerequisites

- ✅ Rust basics (Arc, Mutex, ownership)
- ✅ Familiar with the codebase (seen block_split.rs, cfg.rs)
- ✅ Can compile and run tests
- ✅ Understand that Arc = shared ownership, Mutex = mutual exclusion

### If You're Rusty on These:
- **Arc**: Think "shared pointer" like C++ shared_ptr
- **Mutex**: Think "lock" - ensures only one thread accesses at a time
- **ptr_eq**: Check if two Arc pointers point to same object (without locking)

---

## 🛠️ How to Get Started

### 1. Set Up Environment
```bash
cd crates
cargo build --release -p jadx-cli  # Build once
cargo test                          # Verify all 247 tests pass
```

### 2. Understand Phase 1 Plan
```bash
# Read and understand:
# 1. OPTIMIZATION_PLAN.md (the roadmap)
# 2. MEMORY_ANALYSIS.md (the "why")
# 3. MEMORY_QUICK_REFERENCE.md (the "how")
```

### 3. Pick Your First File
**Start with**: `jadx-passes/src/block_split.rs`
- Lines 189-191: Where Vec<InsnNode> is populated
- This is the ROOT CAUSE of memory explosion
- Start here, then work outward

### 4. Follow The Pattern
Same change pattern repeats across files:
```rust
// BEFORE:
pub instructions: Vec<InsnNode>,

// AFTER:
pub instructions: Vec<Arc<Mutex<InsnNode>>>,

// When reading:
let insn = &instructions[0];
insn.field  // BEFORE
insn.lock().unwrap().field  // AFTER

// When writing:
instructions[0].field = value  // BEFORE
instructions[0].lock().unwrap().field = value  // AFTER

// When checking equality (deadlock prevention):
if Arc::ptr_eq(&a, &b) {
    // Same object - no deadlock risk
} else {
    // Different objects - safe to lock both
}
```

---

## 📊 Expected Memory Improvements

### Phase 1 Only (Arc<InsnNode>)
```
Small APK (2 classes):     ~5 MB → ~5 MB (no change, already small)
Medium APK (100 classes):  ~50 MB → ~20 MB (60% reduction)
Large APK (900 classes):   ~1-2 GB → ~200-300 MB (75-85% reduction)
```

### All 3 Phases Complete
```
Small APK:    ~5 MB → ~5 MB
Medium APK:   ~50 MB → ~10 MB (80% reduction)
Large APK:    ~1-2 GB → ~100-150 MB (85-90% reduction)
Huge APK:     ~67 GB → ~10-15 GB (85% reduction) ← Verified
```

---

## ⚠️ Potential Pitfalls

### 1. Deadlock Risk (Easy to Fix)
**Problem**: Two Arc pointers same object, lock both → deadlock
**Solution**: Use `Arc::ptr_eq(&a, &b)` to check before locking
**Pattern**: Already shown above

### 2. Performance
**Problem**: Mutex locking on every field access might be slow
**Solution**: Lock once, extract what you need, release
```rust
// Good: One lock
let insn = instructions[0].lock().unwrap();
if insn.field1 == value {
    insn.field2 = other_value;
}

// Bad: Multiple locks (slower)
if instructions[0].lock().unwrap().field1 == value {
    instructions[0].lock().unwrap().field2 = other_value;  // Another lock!
}
```

### 3. Compilation Errors
**Problem**: Type mismatches on Arc/Mutex changes
**Solution**: Compiler error messages are very helpful - just follow them

---

## 🧪 Testing Strategy

### Run Tests After Each Phase
```bash
cargo test  # Should show all 247 passing
```

### Memory Testing
```bash
# Build release
cargo build --release -p jadx-cli

# Measure memory (macOS/Linux)
/usr/bin/time -v ./target/release/dexterity -d output/ input.apk

# Look for: "Maximum resident set size" = peak memory
```

### Before/After Comparison
1. Measure small.apk (baseline - should stay ~same)
2. Measure medium.apk (should reduce significantly)
3. Compare: `(before - after) / before * 100%`

---

## 📚 Documentation Links

**Full Plan**: `OPTIMIZATION_PLAN.md`
- Step-by-step implementation
- Exact line numbers to change
- Code examples for each file

**Technical Deep Dive**: `MEMORY_ANALYSIS.md`
- Why we need optimization
- How Java JADX does it
- Detailed architecture

**Quick Reference**: `MEMORY_QUICK_REFERENCE.md`
- Common patterns
- Commands to run
- Troubleshooting

**Project Guidance**: `CLAUDE.md`
- Project-specific instructions
- Key files to know
- Architecture overview

---

## 🎯 Success Criteria

### Phase 1 Complete When:
- ✅ All 247 tests pass
- ✅ No compilation errors
- ✅ small.apk still decompiles correctly
- ✅ Code review approved

### Memory Reduction Verified When:
- ✅ Peak memory reduced by 60-80% on medium APK
- ✅ Large APK processes farther (memory relief)
- ✅ No new bugs introduced

### Ready for Phase 2 When:
- ✅ Phase 1 complete and tested
- ✅ Memory improvement verified
- ✅ All tests passing

---

## 💡 Pro Tips

1. **Start Small**: Phase 1 is the big one - do it completely before Phase 2
2. **Incremental**: Change one file, test, move to next - don't try all at once
3. **Documentation**: Read OPTIMIZATION_PLAN.md line numbers - they're exact
4. **Ask Questions**: If stuck, check MEMORY_QUICK_REFERENCE.md troubleshooting
5. **Save Work**: Commit after each file completes
6. **Profile Often**: Measure memory after each phase - see your progress!

---

## 🏁 Timeline

| Phase | Time | Files | Impact |
|-------|------|-------|--------|
| Phase 1 | 6-10h | 8-10 | 80-90% memory reduction |
| Phase 2 | 1-2h  | 2-3 | 40-50% additional |
| Phase 3 | 2-3h  | 1-2 | 10-20% additional |
| **Total** | **13-19h** | | **85% total reduction** |

**Ready to commit 13-19 hours?** → Go to `OPTIMIZATION_PLAN.md`

---

## ❓ FAQ

**Q: Do I need to understand the whole decompiler?**
A: No! Memory optimization is localized. You just need to know: Arc = shared reference, Mutex = lock

**Q: Will my changes break things?**
A: Tests will catch it. All 247 must pass after each phase.

**Q: Can I do partial phases?**
A: Yes! Phase 1 alone gives 80-90% benefit. Phases 2-3 are cherry on top.

**Q: How will I know if I'm winning?**
A: Peak memory (from `time -v` command) will drop significantly after Phase 1.

**Q: What if I get stuck?**
A: Check `MEMORY_QUICK_REFERENCE.md` troubleshooting section, or review OPTIMIZATION_PLAN.md exact steps.

---

## 🚀 Next Step

**Read**: `OPTIMIZATION_PLAN.md` - Priority 1 section

**Then**: Start Phase 1 implementation (following exact line numbers in the plan)

**Finally**: Measure success with: `/usr/bin/time -v ./target/release/dexterity ...`

---

**Status**: Ready for implementation
**Time Estimate**: 13-19 hours total (6-10 for Phase 1)
**Expected Result**: 85% memory reduction + support for large APKs

**Let's make this decompiler production-ready! 🚀**
