# JADX-Rust Agent Coordination

**Goal**: Full 1:1 JADX port - output MUST match Java JADX exactly for golden file testing.

## Current Status (Build: PASSING)

```
crates/
├── jadx-dex/      # DEX parsing - MOSTLY COMPLETE (2,016 lines)
├── jadx-ir/       # IR types - MOSTLY COMPLETE (1,582 lines)
├── jadx-passes/   # Decompilation passes - STUB (437 lines)
├── jadx-codegen/  # Code generation - STUB (130 lines)
└── jadx-cli/      # CLI app - PARTIAL (540 lines)
```

## Work Assignments

### AGENT 1: Core Algorithms (jadx-passes/src/algorithms/)
**Files to create:**
- `dominator_tree.rs` - Port from `visitors/blocks/DominatorTree.java` (166 lines)
- `post_dominator_tree.rs` - Port from `visitors/blocks/PostDominatorTree.java` (~150 lines)
- `live_var_analysis.rs` - Port from `visitors/ssa/LiveVarAnalysis.java` (120 lines)

**Key optimizations:**
- Use `FixedBitSet` instead of Java BitSet
- SIMD-friendly bit operations for liveness (u64 arrays)
- Cache-friendly CSR format for dominator tree

**Reference Java:** `/jadx-core/src/main/java/jadx/core/dex/visitors/`

**1:1 matching requirements:**
- Dominator tree must produce identical idom[] array
- Dominance frontiers must match exactly
- Liveness sets must match per-block

---

### AGENT 2: SSA Transform (jadx-passes/src/ssa/)
**Files to create:**
- `mod.rs` - SSA module
- `transform.rs` - Port from `visitors/ssa/SSATransform.java` (467 lines)
- `phi.rs` - Phi instruction handling
- `rename.rs` - Variable renaming

**Dependencies:** Needs Agent 1's algorithms

**Key methods to port:**
```java
// SSATransform.java
process(mth)           // Main orchestrator
placePhi(mth, regNum, la)  // Dominance frontier phi placement
renameVariables(mth)   // Stack-based SSA renaming
```

**1:1 matching requirements:**
- Phi nodes must be placed at identical blocks
- SSA variable versions must match (r0_0, r0_1, etc.)
- Phi arguments must be in same order

---

### AGENT 3: Type System (jadx-passes/src/types/)
**Files to create:**
- `mod.rs` - Type module
- `inference.rs` - Port from `visitors/typeinference/TypeInferenceVisitor.java` (365 lines)
- `bounds.rs` - Type bounds and constraints
- `compare.rs` - Port from `TypeCompare.java` (393 lines)

**Dependencies:** Needs Agent 2's SSA output

**Key concepts:**
```rust
pub trait TypeBound {
    fn upper_bound(&self) -> &ArgType;
    fn lower_bound(&self) -> &ArgType;
}

pub enum TypeConstraint {
    Assign { from: VarId, to: VarId },
    Call { method: MethodId, arg_idx: usize, var: VarId },
    Return { method: MethodId, var: VarId },
}
```

**1:1 matching requirements:**
- Inferred types must match Java JADX exactly
- Type widening/narrowing must be identical

---

### AGENT 4: Regions + Codegen (jadx-passes/src/regions/, jadx-codegen/)
**Files to create:**

In `jadx-passes/src/regions/`:
- `mod.rs` - Region module
- `maker.rs` - Port from `visitors/regions/RegionMakerVisitor.java` (51 lines)
- `if_region.rs` - Port from `maker/IfRegionMaker.java` (524 lines)
- `loop_region.rs` - Port from `maker/LoopRegionMaker.java` (470 lines)
- `switch_region.rs` - Port from `maker/SwitchRegionMaker.java` (406 lines)

In `jadx-codegen/src/`:
- `class_gen.rs` - Class code generation
- `method_gen.rs` - Method body generation
- `expr_gen.rs` - Expression generation
- `stmt_gen.rs` - Statement generation

**Dependencies:** Needs Agent 2/3 output

**1:1 matching requirements:**
- Control flow structure must be identical
- Generated Java source must match byte-for-byte (modulo whitespace)

---

## Critical Types (jadx-ir)

These IR types are shared - DO NOT modify without coordination:

```rust
// jadx-ir/src/nodes.rs - Core nodes
pub struct MethodDef { ... }
pub struct BasicBlock { ... }
pub struct ClassDef { ... }

// jadx-ir/src/instructions.rs - IR instructions
pub enum Instruction { ... }  // ~40 variants

// jadx-ir/src/types.rs - Type system
pub enum ArgType { ... }
```

---

## Testing Strategy

```bash
# 1. Generate reference from Java JADX
java -jar jadx-cli.jar -d expected/ test.apk

# 2. Run Rust implementation
./target/release/jadx-rust -d actual/ test.apk

# 3. Diff must be empty
diff -r expected/ actual/
```

**Test APK:** GoldRush APK (sha256: aa7382155dc62389b3bbb0e2ee93c882b5118e3da7924db8575cb137ca36596b)

---

## Conflict Avoidance

| Directory | Owner | Status |
|-----------|-------|--------|
| jadx-dex/ | DONE | Maintenance only |
| jadx-ir/ | SHARED | Coordinate changes |
| jadx-passes/src/algorithms/ | Agent 1 | IN PROGRESS |
| jadx-passes/src/ssa/ | Agent 2 | BLOCKED on Agent 1 |
| jadx-passes/src/types/ | Agent 3 | BLOCKED on Agent 2 |
| jadx-passes/src/regions/ | Agent 4 | BLOCKED on Agent 3 |
| jadx-codegen/ | Agent 4 | BLOCKED on regions |
| jadx-cli/ | ALL | Coordinate |

---

## Java → Rust Mappings

| Java | Rust | Notes |
|------|------|-------|
| `BlockNode` | `BasicBlock` | Use arena ID |
| `InsnNode` hierarchy | `Instruction` enum | ~40 variants |
| `SSAVar` | `SsaVariable` | Per-method arena |
| `BitSet` | `FixedBitSet` | Or u64 arrays |
| `List<T>` | `SmallVec<[T; N]>` | Stack for small |
| `Map<K,V>` | `FxHashMap<K,V>` | Fast hashing |
| `@JadxVisitor` | `impl Pass for T` | Trait-based |

---

## Build Commands

```bash
cd /mnt/nvme4tb/jadx-rust/crates
cargo build           # Debug build
cargo build --release # Release build
cargo test            # Run tests
```

---

## Priority Order

1. **Agent 1 FIRST** - Algorithms are foundation
2. **Agent 2 NEXT** - SSA depends on algorithms
3. **Agent 3 THEN** - Types depend on SSA
4. **Agent 4 LAST** - Regions/codegen depend on types

Work in parallel where possible:
- Agent 1 + Agent 4 (regions struct design) can run simultaneously
- Agent 2 can start on SSA structure while waiting for algorithms
- Agent 3 can design type system while waiting for SSA
