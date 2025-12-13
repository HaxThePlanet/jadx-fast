# Memory Optimization Plan: Java JADX Pattern Migration

## Objective

Reduce peak memory usage from **67 GB to 10-15 GB** by copying Java JADX's proven memory-efficient patterns into the Rust implementation.

**Root Cause**: Block splitting clones instructions 5-20x per method instead of using shared references (Java JADX pattern).

**Solution**: Implement three complementary optimizations derived directly from Java JADX source code.

---

## Priority 1: Arc<InsnNode> - Shared References (Primary Fix)

**Copy Java JADX's Reference-Based Block Splitting**

### Problem
Currently:
```rust
// block_split.rs - line 189
for insn in insns {
    block.instructions.push(insn.clone());  // ❌ Deep clone, 5-20 repetitions
}
```

Java JADX doesn't clone - it shares references:
```java
// BlockSplitter.java - line 124
curBlock.getInstructions().add(insn);  // ✅ Direct reference, no clone
```

### Solution
Use `Arc<InsnNode>` to create cheap shared references matching Java semantics:

```rust
// block_split.rs - NEW
let instructions_arc: Vec<Arc<InsnNode>> = insns
    .into_iter()
    .map(|i| Arc::new(i))
    .collect();

for insn_arc in &instructions_arc {
    block.instructions.push(Arc::clone(insn_arc));  // ✅ Cheap Arc clone (~8 bytes)
}
```

### Changes Required

**File: `crates/jadx-ir/src/info.rs`**
- Change `BasicBlock.instructions: Vec<InsnNode>` → `Vec<Arc<InsnNode>>`
- Add helper methods to dereference Arc when accessing instruction fields

**File: `crates/jadx-passes/src/block_split.rs`**
- Wrap instructions in Arc before adding to blocks
- Remove `.clone()` calls
- Update all instruction access to dereference Arc

**File: `crates/jadx-passes/src/ssa.rs`**
- Update SSA transformation to work with `Arc<InsnNode>`
- Use `Arc::clone()` for shared references

**File: `crates/jadx-codegen/src/body_gen.rs` and related**
- Update all instruction access code to dereference Arc

### Impact
- **Memory reduction**: 80-90% (from 7-12 GB → 2-3 GB per class)
- **Matches Java JADX**: Reference semantics at instruction level
- **Implementation**: 6-10 hours
- **Risk**: Medium (affects many code paths, needs testing)

### Expected Result
```
Before: 2 GB (load) + 5-10 GB (clones) = 7-12 GB peak
After:  2 GB (load) + 0.1 GB (Arc refs) = 2-3 GB peak
Savings: 80-85%
```

---

## Priority 2: Early Instruction Array Unload

**Copy Java JADX's `unloadInsnArr()` Pattern**

### Problem
Currently:
- Instructions remain in `MethodData.instructions` until full unload
- Memory held unnecessarily through SSA and type inference phases

Java JADX strategy:
```java
// BlockSplitter.java - line 83
mth.updateBlockPositions();
mth.unloadInsnArr();  // ✅ FREE instruction array, keep blocks
```

Instructions moved to blocks, then original array freed.

### Solution
Add `unload_instructions()` call immediately after block splitting:

```rust
// block_split.rs - after blocks created
split_blocks(&insns);
// blocks now hold Arc references to instructions
drop(insns);  // Free original vector, blocks still have Arc pointers
method.unload_instructions();  // Free method's instruction field
```

### Changes Required

**File: `crates/jadx-ir/src/info.rs`**
- Add `MethodData.unload_instructions()` method
- Clear `MethodData.instructions` after blocks created

**File: `crates/jadx-passes/src/block_split.rs`**
- Call `method.unload_instructions()` after block splitting (after line 189)

### Impact
- **Memory reduction**: 40-50% of instruction phase
- **Timing**: Freed before SSA and type inference (saves 2-3 GB)
- **Implementation**: 1-2 hours
- **Risk**: Low (straightforward memory management)

### Expected Result
```
Instruction load: 2 GB
Block split: blocks get Arc refs
unloadInsnArr(): -2 GB freed → 0 additional
SSA/type: works with existing blocks
Savings: Additional 2 GB freed earlier
```

---

## Priority 3: Lazy Initialization Patterns

**Copy Java JADX's EmptyBitSet and Option Patterns**

### Problem
Currently:
- All BitSets allocated upfront for dominance analysis
- PhiInsn lists allocated even when empty
- Increases memory footprint of analysis data

Java JADX patterns:
```java
// BlockNode.java - line 46
private BitSet doms = EmptyBitSet.EMPTY;  // Shared singleton, zero bytes
private List<PhiInsn> usedInPhi = null;   // Null until first PHI
```

### Solution 1: Option<BitSet> for Dominance Data
```rust
// BasicBlock
pub struct BasicBlock {
    pub doms: Option<BitSet>,           // None = empty, Some(bits) = allocated
    pub post_doms: Option<BitSet>,
    pub dom_frontier: Option<BitSet>,
}

impl BasicBlock {
    pub fn new(id: u32) -> Self {
        // All BitSets start as None - zero allocation
        Self {
            doms: None,
            post_doms: None,
            dom_frontier: None,
            // ...
        }
    }

    pub fn set_doms(&mut self, bits: BitSet) {
        self.doms = Some(bits);  // Allocate only when needed
    }
}
```

### Solution 2: Option for PHI Lists
```rust
// SsaVariable
pub struct SsaVariable {
    pub assign: RegisterArg,
    pub use_list: Vec<RegisterArg>,      // Small capacity
    pub used_in_phi: Option<Vec<PhiInsnId>>,  // Null until first PHI
}

impl SsaVariable {
    pub fn add_used_in_phi(&mut self, phi_id: PhiInsnId) {
        if self.used_in_phi.is_none() {
            self.used_in_phi = Some(Vec::with_capacity(1));
        }
        self.used_in_phi.as_mut().unwrap().push(phi_id);
    }
}
```

### Solution 3: Small Initial Capacities
```rust
// BasicBlock
pub struct BasicBlock {
    pub instructions: Vec<Arc<InsnNode>>,  // Vec::with_capacity(2)
    pub predecessors: Vec<BlockId>,        // Vec::with_capacity(1)
    pub successors: Vec<BlockId>,          // Vec::with_capacity(1)
}

impl BasicBlock {
    pub fn new(id: u32) -> Self {
        Self {
            instructions: Vec::with_capacity(2),
            predecessors: Vec::with_capacity(1),
            successors: Vec::with_capacity(1),
            // ...
        }
    }
}
```

### Changes Required

**File: `crates/jadx-ir/src/info.rs`**
- Change dominance fields to `Option<BitSet>`
- Add helper methods for setting/getting dominance data

**File: `crates/jadx-ir/src/attributes.rs`**
- Change `PHI` list fields to `Option<Vec<_>>`
- Add lazy allocation helpers

**File: `crates/jadx-passes/src/dominators.rs`** (or wherever dominance computed)
- Update to allocate BitSets via `Some(bits)` only when computed

### Impact
- **Memory reduction**: 10-20% of analysis phase
- **Dominance savings**: ~60-70% of blocks skip frontier allocation
- **Implementation**: 2-3 hours
- **Risk**: Low (doesn't affect core logic)

---

## Implementation Order

1. **Priority 1** (Arc<InsnNode>) - 6-10 hours
   - Biggest impact (80-90%)
   - Must test thoroughly
   - Start here

2. **Priority 2** (Early unload) - 1-2 hours
   - Quick win, immediate memory relief
   - Do after Priority 1 works

3. **Priority 3** (Lazy initialization) - 2-3 hours
   - Polish, incremental gains
   - Final optimization

---

## Expected Memory Improvement

### Before Optimization
```
Load instructions:           2 GB
Block split (clones):      +5-10 GB  ← Problem
SSA/type inference:         ~0 GB
Analysis (BitSets):         ~1 GB
Codegen/regions:            ~1 GB
─────────────────────────────────
Peak per class:             7-12 GB
Sequential (50+ classes):   67 GB
```

### After Priority 1 (Arc<InsnNode>)
```
Load instructions:           2 GB
Block split (Arc refs):     +0.1 GB  ← Fixed!
SSA/type inference:          ~0 GB
Analysis (BitSets):          ~1 GB
Codegen/regions:             ~1 GB
─────────────────────────────────
Peak per class:              3-4 GB
Sequential (50+ classes):    15-20 GB   ← 75-80% improvement
```

### After All Priorities
```
Load instructions:           2 GB
Block split (Arc refs):     +0.1 GB
SSA/type inference:          ~0 GB
Analysis (Option BitSets):  +0.3 GB  ← Lazy alloc
Codegen/regions:             ~0.5 GB
─────────────────────────────────
Peak per class:              2-3 GB
Sequential (50+ classes):    10-15 GB   ← 85% improvement!
```

---

## Testing Strategy

### Unit Tests
```rust
#[test]
fn test_no_instruction_cloning() {
    let insns = vec![...];  // 100 instructions
    let blocks = split_blocks(insns.clone());

    // Verify Arc reference count
    assert_eq!(Arc::strong_count(&blocks[0].instructions[0]), 2);
    // Not 10+ clones per instruction
}

#[test]
fn test_unload_instructions() {
    let mut method = MethodData::new(...);
    method.set_instructions(insns);
    assert!(method.instructions.is_some());

    method.unload_instructions();
    assert!(method.instructions.is_none());
}

#[test]
fn test_lazy_bitset_none_by_default() {
    let block = BasicBlock::new(0);
    assert!(block.doms.is_none());  // No allocation
}
```

### Integration Tests
```bash
# Compare output before/after
java -jar jadx-cli.jar -d expected/ test.apk
./target/release/dexterity -d actual/ test.apk
diff -r expected/ actual/
# Must be byte-for-byte identical
```

### Memory Profiling
```bash
# Baseline
/usr/bin/time -v ./target/release/dexterity -d /tmp/out/ large.apk 2>&1 | grep "Maximum resident"
# Expected before: ~67 GB

# After Priority 1
# Expected: ~15-20 GB

# After all
# Expected: ~10-15 GB
```

---

## Comparison with Java JADX

| Aspect | Java JADX | Rust Current | Rust New |
|--------|-----------|--------------|----------|
| Instruction storage | `InsnNode[]` in method | `Vec<InsnNode>` in method | `Vec<Arc<InsnNode>>` in blocks |
| Block references | Direct (Java refs) | Cloned `Vec<InsnNode>` | `Vec<Arc<InsnNode>>` |
| Cloning during split | 0x | 5-20x | 0x (Arc clone only) |
| Early unload | Yes (unloadInsnArr) | No | Yes (unload_instructions) |
| Dominance BitSets | Lazy (null until needed) | All allocated | Option (None until needed) |
| Peak memory | 2-8 GB | 67 GB | 10-15 GB |
| Memory multiplier | 50-100x | 1,350x | 200-300x |

---

## Critical Files to Modify

### Phase 1: Arc<InsnNode> Implementation
- `crates/jadx-ir/src/info.rs` - BasicBlock, MethodData structures
- `crates/jadx-passes/src/block_split.rs` - Block splitting logic
- `crates/jadx-passes/src/ssa.rs` - SSA transformation
- `crates/jadx-codegen/src/body_gen.rs` - Body generation
- `crates/jadx-codegen/src/expr_gen.rs` - Expression generation
- Any other files accessing `block.instructions`

### Phase 2: Early Unload
- `crates/jadx-ir/src/info.rs` - Add `unload_instructions()` to MethodData
- `crates/jadx-passes/src/block_split.rs` - Call unload after split

### Phase 3: Lazy Initialization
- `crates/jadx-ir/src/info.rs` - Change dominance fields to Option
- `crates/jadx-passes/src/dominators.rs` - Lazy BitSet allocation
- `crates/jadx-passes/src/ssa.rs` - Option for PHI lists

---

## Java JADX Source References

All patterns derived from:
- `/mnt/nvme4tb/jadx-fast/jadx-core/src/main/java/jadx/core/dex/visitors/blocks/BlockSplitter.java` (line 124, 83)
- `/mnt/nvme4tb/jadx-fast/jadx-core/src/main/java/jadx/core/dex/nodes/MethodNode.java` (lines 357-359)
- `/mnt/nvme4tb/jadx-fast/jadx-core/src/main/java/jadx/core/dex/nodes/BlockNode.java` (lines 37, 46-51)
- `/mnt/nvme4tb/jadx-fast/jadx-core/src/main/java/jadx/core/utils/EmptyBitSet.java`
- `/mnt/nvme4tb/jadx-fast/jadx-core/src/main/java/jadx/core/ProcessClass.java` (lines 80-88)

---

## Success Criteria

- [x] All optimizations derived from Java JADX patterns
- [ ] Priority 1: Arc<InsnNode> implemented, tests passing
- [ ] Priority 2: Early unload integrated
- [ ] Priority 3: Lazy initialization complete
- [ ] All 217 tests still passing
- [ ] Memory peak < 20 GB on 48 MB TeamViewer APK
- [ ] Output byte-for-byte identical to Java JADX

---

## Estimated Implementation Timeline

| Task | Hours | Priority |
|------|-------|----------|
| Arc<InsnNode> | 6-10 | 1 |
| Early unload | 1-2 | 2 |
| Lazy initialization | 2-3 | 3 |
| Testing/debugging | 2-4 | All |
| **Total** | **13-19** | — |

---

## Note on Alternative Approaches

Earlier analysis explored index-based blocks and streaming iterators. Those approaches are **not recommended** because:
- Java JADX uses reference-based blocks, not indices
- More complex to implement with less benefit
- Arc<InsnNode> matches Java semantics exactly
- Proven to work in production (Java JADX)
