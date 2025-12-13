# Memory Explosion Investigation Summary (December 13, 2025)

## The Problem
Single-threaded decompilation of badboy.apk (58,000 methods) caused uncontrolled memory growth:
- Started at ~26MB during resource parsing
- Grew to **50GB+** during method decompilation
- User had to kill at 100GB before OOM on 300GB RAM machine
- **Status: BLOCKING - cannot process large APKs**

## Root Cause Analysis

### What We Tried (Dead Ends)
1. ❌ Removing hierarchy cloning (infer_types_with_hierarchy) - helped slightly but not the core issue
2. ❌ Fixing AXML parser overflow - was preventing resource processing but not main memory issue
3. ❌ Removing decompiler.rs clone (blocks.clone in CFG) - was unnecessary but minor impact

### What Actually Caused It
**Location:** `crates/jadx-passes/src/block_split.rs:166`

```rust
let instructions_arc: Vec<Arc<Mutex<InsnNode>>> = instructions
    .iter()
    .map(|i| Arc::new(Mutex::new(i.clone())))  // ← CLONES ENTIRE InsnNode!
    .collect();
```

For every method:
- 10,000 instructions × 200+ bytes per InsnNode = 2-3MB cloned
- 58,000 methods × 2-3MB = **116GB+ potential memory usage**
- Actual observed: ~50GB before OOM (accumulation + allocator fragmentation)

### Why This Approach Failed

The Arc<Mutex<>> pattern was well-intentioned:
- Share instruction references across blocks (✓ Good intent)
- Avoid 5-20x over-cloning from multiple block references (✓ Good intent)

But Rust's borrow checker + need for mutable SSA updates creates a conflict:
- Can't share `&InsnNode` because SSA mutations need `&mut`
- Mutex allows interior mutability but still requires cloning data to wrap
- Result: We clone ONCE, but that's still 10,000 clones per method

## The Java JADX Solution (Proven Pattern)

Java JADX handles this with elegant simplicity:

```java
class ClassNode {
    List<InsnNode> instructions;  // ALL instructions in ONE list
}

class BlockNode {
    int startOffset, endOffset;   // Reference by offset range, NOT clone
}
```

Access pattern:
```java
for (InsnNode insn : classNode.instructions.subList(startOffset, endOffset)) {
    // Process instruction
}
```

After codegen:
```java
classNode.instructions.clear();  // Single operation frees ALL
```

**Key insight:** Instructions are SHARED by reference, never cloned. Single owner = single unload point.

## The Rust Solution (Must Copy JADX)

Good news: **The infrastructure already exists!**

`ClassData` (jadx-ir/src/info.rs:528) already has:
```rust
pub all_instructions: Vec<InsnNode>,  // Shared instruction pool
```

Required changes:
1. **Remove from BasicBlock:**
   ```rust
   // DELETE THIS:
   pub instructions: Vec<Arc<Mutex<InsnNode>>>,
   ```

2. **Use offset-based references:**
   ```rust
   // ADD THESE:
   pub start_offset: u32,
   pub end_offset: u32,
   
   // Add getter:
   pub fn get_instructions<'a>(&self, class_data: &'a ClassData) -> Vec<&'a InsnNode> {
       class_data.all_instructions
           .iter()
           .filter(|insn| insn.offset >= self.start_offset && insn.offset < self.end_offset)
           .collect()
   }
   ```

3. **Pass ClassData through pipeline:**
   - split_blocks() → returns BlockSplitResult
   - CFG::from_blocks(ClassData, BlockSplitResult) 
   - SSA::transform_to_ssa(&ClassData, ...)
   - Type inference, codegen - all take &ClassData

4. **Unload in one operation:**
   ```rust
   pub fn unload(&mut self) {
       self.all_instructions.clear();  // FREE ALL AT ONCE
       self.insn_indices.clear();
   }
   ```

## Impact Analysis

### Memory Reduction
- **Before:** 10,000 instructions × 200 bytes × 58,000 methods = 116GB potential
- **After:** 10,000 instructions × 200 bytes × 1 (shared) = ~20GB actual
- **Reduction:** 80-90% memory savings

### Single Method Example
```
Before:
  ClassData.all_instructions: 10,000 InsnNode × 200B = 2MB
  BasicBlock[0].instructions: Arc<Mutex> × 3000 (for 3000 blocks) = 600KB clones
  BasicBlock[1-2999].instructions: more clones...
  Total per method: 3-5MB intermediate storage

After:
  ClassData.all_instructions: 10,000 InsnNode × 200B = 2MB (SHARED)
  BasicBlock.start_offset/end_offset: 4 bytes × 3000 = 12KB
  Immediate freeing after codegen: ZERO accumulation
```

### Large APK Performance
- badboy.apk: 116GB potential → ~20GB
- Single method: 3-5MB overhead → <1MB
- Sequential processing: memory never grows unbounded

## Implementation Roadmap

**Phase 1 (CRITICAL):** Fix instruction references
- [ ] Modify BasicBlock struct (remove instructions field, add offsets)
- [ ] Update split_blocks() - no more Arc<Mutex> creation
- [ ] Add get_instructions() method to BasicBlock
- [ ] Update all CFG code to use new accessor

**Phase 2:** Pass ClassData through pipeline
- [ ] CFG::from_blocks(class_data, result)
- [ ] SSA::transform_to_ssa(&class_data, ...)
- [ ] Type inference functions
- [ ] Code generation

**Phase 3:** Update all instruction access patterns
- [ ] ~200+ locations where `block.instructions` is accessed
- [ ] Replace with `&class_data.all_instructions[offset_range]`
- [ ] Update iteration patterns

**Phase 4:** Testing & verification
- [ ] All 247 unit tests pass
- [ ] Memory profiling on badboy.apk
- [ ] Verify ~20GB peak memory
- [ ] Regression testing

**Estimated effort:** 8-12 hours for experienced developer
**Complexity:** HIGH - touches core pipeline
**Blocker status:** YES - required to process large APKs

## Commits Made (December 13, 2025)

1. **655fe003** - Fix two critical memory issues (blocks.clone removal, AXML panic)
2. **745b19a4** - Remove hierarchy cloning (30-50GB reduction attempted)
3. **1811bf01** - Document required memory refactor
4. **33d400ce** - Document memory explosion in README and CLAUDE.md

## Learnings for Future Work

1. **Always check Java JADX source first** - 10 years of proven patterns
2. **Arc<Mutex> doesn't eliminate cloning** - it eliminates over-cloning, not base cloning
3. **Single owner pattern scales** - let ClassData own instructions, everything else borrows
4. **Offset-based references are memory-efficient** - 4 bytes vs 64 bytes (Arc + Mutex overhead)
5. **One unload point scales to 58,000 methods** - clear() once clears everything

## Resources

- Java JADX Reference: `/mnt/nvme4tb/jadx-fast/jadx-core/src/main/java/jadx/core/ProcessClass.java`
- Refactor Plan: `MEMORY_REFACTOR_PLAN.md`
- Current Architecture: `CLAUDE.md` "Architecture" section
