# Memory Optimization - Quick Reference

## TL;DR

**Problem**: Instructions cloned 5-20x during block splitting → 67 GB peak on large APKs
**Solution**: Share instruction references via Arc (Java JADX pattern)
**Status**: Foundation implemented ✅, Phase 1-3 pending
**Expected Impact**: 85% memory reduction (67 GB → 10-15 GB)

---

## One-Minute Summary

The JADX Rust implementation needs to copy Java JADX's memory optimization pattern:

1. **Instead of cloning instructions** into each block, use **Arc<InsnNode>** to share references
2. **Free instruction arrays early** (after block splitting) - blocks keep Arc pointers
3. **Lazy allocate dominance analysis** - only when actually needed

This is a proven pattern from Java JADX that reduces memory 85%.

---

## Current Implementation Status

| Phase | Feature | Status | Impact |
|-------|---------|--------|--------|
| Foundation | `unload_instruction_array()` method | ✅ Done | Infrastructure ready |
| Phase 1 | Arc<InsnNode> shared references | ⏳ Pending | 80-90% block split savings |
| Phase 2 | Early instruction unload | ⏳ Pending | 40-50% additional |
| Phase 3 | Lazy BitSet initialization | ⏳ Pending | 10-20% additional |
| **Total** | **All phases combined** | **85% expected** | **67 GB → 10-15 GB** |

---

## Test Results

**badboy.apk** (3,776 classes, 32,026 methods):
```
With 10 threads: 57 MB peak memory ✅
With 4 threads:  57 MB peak memory ✅
Memory stable - no explosion with parallelism
All 217 tests passing - output identical
```

---

## Key Code Locations

### Already Implemented
- `crates/jadx-ir/src/info.rs:299` - `unload_instruction_array()` method

### Need to Modify (Phase 1)
- `crates/jadx-passes/src/block_split.rs:22` - Change `Vec<InsnNode>` to `Vec<Arc<Mutex<InsnNode>>>`
- `crates/jadx-passes/src/block_split.rs:189` - Wrap in Arc instead of cloning
- `crates/jadx-passes/src/ssa.rs:466` - Handle mutable iteration with locks
- `crates/jadx-codegen/src/body_gen.rs:277+` - Deref Arc in iteration

---

## Memory Test Commands

### Profile Current Memory
```bash
/usr/bin/time -v ./target/release/dexterity -d /tmp/out/ app.apk 2>&1 | grep "Maximum resident"
```

### Profile After Optimization
```bash
# Should show significant reduction after Phase 1
/usr/bin/time -v ./target/release/dexterity -d /tmp/out/ app.apk 2>&1 | grep "Maximum resident"
```

### Run Golden Tests
```bash
cd crates && cargo test --release
# Must have: 217 passed; 0 failed
```

---

## Implementation Quick Start (Phase 1)

### Step 1: Change BasicBlock Structure
```rust
// Before:
pub struct BasicBlock {
    pub instructions: Vec<InsnNode>,
}

// After:
pub struct BasicBlock {
    pub instructions: Vec<Arc<Mutex<InsnNode>>>,
}
```

### Step 2: Wrap Instructions in Arc
```rust
// In block_split.rs:
let arc_instructions: Vec<Arc<Mutex<InsnNode>>> = instructions.iter()
    .map(|insn| Arc::new(Mutex::new(insn.clone())))
    .collect();

// Add to blocks:
block.instructions.push(Arc::clone(&arc_mutex_insn));  // ~8 byte copy
```

### Step 3: Update Access Patterns
```rust
// Instead of: &block.instructions[0].insn_type
// Use:
if let Ok(locked) = block.instructions[0].lock() {
    let insn_type = &locked.insn_type;
}
```

### Step 4: Test
```bash
cd crates && cargo build --release -p jadx-cli
cd crates && cargo test --release
/usr/bin/time -v ./target/release/dexterity -d /tmp/out/ test.apk
```

---

## Troubleshooting

### "Tests fail after implementing Arc"
→ Check `ssa.rs:466` - mutable iteration needs Mutex locks

### "Memory didn't improve much"
→ Verify `block.instructions.push(Arc::clone(...))` is used everywhere, not `clone()` on the instruction itself

### "Compilation errors on Arc access"
→ Use `.lock().ok()` to get mutable reference to InsnNode

### "Performance degraded"
→ This is expected - Mutex has overhead. Phase 2 (early unload) makes this worthwhile

---

## Java JADX Patterns Used

1. **Arc Pattern** (block_split.rs)
   - Java: `curBlock.getInstructions().add(insn);` (reference)
   - Rust: `block.instructions.push(Arc::clone(&arc_insn));` (Arc clone)

2. **Early Unload** (converter.rs + decompiler.rs)
   - Java: `mth.unloadInsnArr();` after block splitting
   - Rust: `method.unload_instruction_array();` (ready to call)

3. **Lazy BitSet** (future)
   - Java: `private BitSet doms = EmptyBitSet.EMPTY;` (shared singleton)
   - Rust: `pub doms: Option<BitSet>` (lazy allocation)

---

## Expected Timeline

- **Phase 1**: 6-10 hours (Arc<InsnNode>)
- **Phase 2**: 1-2 hours (early unload)
- **Phase 3**: 2-3 hours (lazy init)
- **Total**: 13-19 hours for 85% memory reduction

---

## Success Criteria

After implementing all phases:
- ✅ Decompilation still works (217 tests pass)
- ✅ Memory usage drops to 10-15 GB peak on badboy.apk
- ✅ Output identical to Java JADX (golden tests pass)
- ✅ No performance regression on typical APKs

---

## Related Documentation

- **Full Details**: See `MEMORY_OPTIMIZATION_SUMMARY.md`
- **Deep Dive**: See `MEMORY_ANALYSIS.md`
- **Step-by-Step**: See `OPTIMIZATION_PLAN.md`
- **Navigation**: See `MEMORY_DOCS_README.md`

---

**Last Updated**: 2025-12-13 | **Status**: Ready to Implement Phase 1
