# Memory Explosion Issue - Complete Documentation Index

**Last Updated:** December 13, 2025
**Status:** ROOT CAUSE IDENTIFIED, SOLUTION DOCUMENTED, REFACTORING PENDING

---

## Quick Navigation

### 📋 Start Here
- **[MEMORY_EXPLOSION_SUMMARY.md](./MEMORY_EXPLOSION_SUMMARY.md)** - Complete investigation report with root cause, solution, and implementation roadmap

### 🔍 Issue Details
- **[README.md#critical-finding](./README.md)** - Issue overview in main README (critical section at top)
- **[CLAUDE.md#critical](./CLAUDE.md)** - Issue description for developers in CLAUDE.md

### 🛠️ Implementation Plans
- **[MEMORY_REFACTOR_PLAN.md](./MEMORY_REFACTOR_PLAN.md)** - Detailed refactoring steps (8-12 hours of work)
- **MEMORY_EXPLOSION_SUMMARY.md#implementation-roadmap** - Phase-by-phase breakdown with checklists

### 📚 Reference Materials
- **Java JADX Source:** `/mnt/nvme4tb/jadx-fast/jadx-core/src/main/java/jadx/core/ProcessClass.java`
  - Lines 82-84: Example unload() pattern Java JADX uses
  - Lines 40-98: Full process() method showing memory strategy

---

## The Problem (2-Minute Summary)

Single-threaded decompilation of badboy.apk (58,000 methods):
- **Memory growth:** Started at 26MB → grew to 50GB+ → user killed at 100GB
- **Root cause:** Arc<Mutex> instruction cloning in `split_blocks.rs:166`
  ```rust
  Arc::new(Mutex::new(i.clone()))  // ← Clones ENTIRE InsnNode per instruction!
  ```
- **Per method:** 10,000 instructions × 200B = 2-3MB cloned
- **Per APK:** 58,000 methods × 2-3MB = **116GB+ potential**
- **Status:** BLOCKING - cannot process large APKs

---

## The Solution (2-Minute Summary)

Follow Java JADX's proven architecture:

1. **Current (Wrong):** BasicBlock holds `Vec<Arc<Mutex<InsnNode>>>`
   - Forces cloning 10,000 times per method
   - Accumulates as pipeline runs

2. **Target (Correct):** BasicBlock holds offset references only
   - `start_offset: u32`, `end_offset: u32`
   - Instructions come from `ClassData.all_instructions` (shared)
   - NO CLONING

3. **Changes needed:**
   - Remove `instructions` field from BasicBlock
   - Add offset fields to BasicBlock
   - Pass ClassData through CFG → SSA → codegen
   - Access instructions: `&class_data.all_instructions[offset_range]`
   - Unload: `class_data.all_instructions.clear()` (single operation)

4. **Expected result:** 116GB potential → ~20GB actual (80-90% reduction)

---

## Commits Made (December 13, 2025)

| Commit | Message |
|--------|---------|
| 655fe003 | Fix two critical memory issues (blocks.clone, AXML panic) |
| 745b19a4 | Remove hierarchy cloning from type inference |
| 1811bf01 | Document required memory refactor: index-based instructions |
| 33d400ce | Document memory explosion root cause in README and CLAUDE.md |
| ae75f547 | Add comprehensive memory explosion investigation summary |

---

## Implementation Status

### ✅ Completed
- [x] Root cause identified and verified
- [x] Java JADX pattern analyzed
- [x] Solution documented with code examples
- [x] Implementation roadmap created
- [x] All findings added to documentation

### ⏳ Pending
- [ ] **Phase 1:** Refactor BasicBlock struct (CRITICAL)
  - Remove `instructions: Vec<Arc<Mutex<InsnNode>>>`
  - Add `start_offset: u32, end_offset: u32`
  - Create `get_instructions()` getter method

- [ ] **Phase 2:** Update pipeline functions
  - CFG, SSA, type_inference, codegen all need ClassData parameter

- [ ] **Phase 3:** Replace all instruction access patterns
  - ~200+ locations to update

- [ ] **Phase 4:** Testing and verification
  - Unit tests
  - Memory profiling
  - Regression testing

---

## Key Files to Modify

**High Impact (Must Change):**
- `crates/jadx-passes/src/block_split.rs` - Remove Arc<Mutex> creation
- `crates/jadx-ir/src/info.rs` - BasicBlock struct definition
- `crates/jadx-passes/src/cfg.rs` - CFG functions (add ClassData param)
- `crates/jadx-passes/src/ssa.rs` - SSA functions (add ClassData param)
- `crates/jadx-codegen/src/body_gen.rs` - Codegen functions (add ClassData param)

**Medium Impact (Will Need Updates):**
- `crates/jadx-passes/src/type_inference.rs`
- `crates/jadx-passes/src/var_naming.rs`
- `crates/jadx-passes/src/region_builder.rs`
- All test files that create BasicBlocks

---

## Memory Math

### Before (Current)
```
Per method (10,000 insns):
  ✗ ClassData.all_instructions: 10,000 × 200B = 2MB
  ✗ BasicBlock[0-2999].instructions: Arc<Mutex> clones × 3000 = 600KB
  ✗ CFG overhead: ~500KB
  ✗ SSA overhead: ~1MB
  ✓ Total: 3-5MB per method

Per APK (58,000 methods):
  ✗ Total potential: 174-290GB (but allocator reclaims ~100GB)
  ✗ Actual observed: 50GB+ before OOM
```

### After (Target)
```
Per method (10,000 insns):
  ✓ ClassData.all_instructions: 10,000 × 200B = 2MB (SHARED!)
  ✓ BasicBlock[0-2999].offsets: 4B × 3000 = 12KB
  ✓ CFG overhead: ~100KB
  ✓ SSA overhead: ~100KB
  ✓ Total: <1MB per method (most freed immediately after codegen)

Per APK (58,000 methods):
  ✓ Peak memory: ~20GB (just instruction data)
  ✓ Memory stays bounded: instructions cleared after each class
```

---

## For Next Developer

When implementing this refactoring:

1. **Start with block_split.rs**
   - This is ground zero for the clone creation
   - Removing `instructions_arc` Vec is first fix

2. **Work backward through pipeline**
   - CFG needs to pass ClassData down
   - SSA needs to reference it
   - Codegen needs to access it

3. **Use offset-based access everywhere**
   - Don't try to keep arc references
   - Always use `&class_data.all_instructions[offset]`

4. **Test as you go**
   - Each phase should have passing tests
   - Memory profiling after each phase

5. **Reference Java JADX frequently**
   - Your solution should mirror `/mnt/nvme4tb/jadx-fast/jadx-core/src/main/java/jadx/core/ProcessClass.java`
   - The BlockNode → offset pattern in Java is your Rust target

---

## Success Criteria

✅ Done when:
- [ ] badboy.apk processes with ~20GB peak memory (currently 50GB+)
- [ ] Single method decompilation uses <1MB temporary memory (currently 3-5MB)
- [ ] All 247 unit tests pass
- [ ] No regression in output quality vs JADX
- [ ] Memory growth is bounded by thread count, not method count

---

## Questions?

Refer to:
1. **MEMORY_EXPLOSION_SUMMARY.md** - Full technical analysis
2. **MEMORY_REFACTOR_PLAN.md** - Step-by-step implementation guide
3. **Java JADX Source** - The proven reference implementation
4. **CLAUDE.md** - Architecture overview
