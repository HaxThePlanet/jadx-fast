# JADX SSA Transformation & CFG Processing Reference

This document provides implementation-level detail of JADX's SSA transformation and CFG (Control Flow Graph) processing systems for building a 1:1 clone in Rust.

## File Organization

**Location:** `jadx-core/src/main/java/jadx/core/dex/`

### SSA Visitors

| File | Lines | Purpose |
|------|-------|---------|
| `visitors/ssa/SSATransform.java` | 467 | Main SSA transformation logic |
| `visitors/ssa/LiveVarAnalysis.java` | 121 | Live variable analysis |
| `visitors/ssa/RenameState.java` | 64 | Variable renaming state machine |

### Block/CFG Visitors

| File | Lines | Purpose |
|------|-------|---------|
| `visitors/blocks/BlockSplitter.java` | 467 | Splits bytecode into basic blocks |
| `visitors/blocks/BlockProcessor.java` | 770 | Main block processing pipeline |
| `visitors/blocks/BlockExceptionHandler.java` | 641 | Exception handler integration |
| `visitors/blocks/DominatorTree.java` | 167 | Dominance tree calculation |
| `visitors/blocks/PostDominatorTree.java` | 73 | Post-dominance tree |
| `visitors/blocks/FixMultiEntryLoops.java` | - | Loop structure fixes |

### Instructions & Args

| File | Lines | Purpose |
|------|-------|---------|
| `instructions/PhiInsn.java` | 142 | Phi function implementation |
| `instructions/args/SSAVar.java` | 344 | SSA variable representation |
| `instructions/args/RegisterArg.java` | - | Register argument wrapping |

### Core Data

| File | Lines | Purpose |
|------|-------|---------|
| `nodes/BlockNode.java` | 250+ | Block representation with CFG data |
| `nodes/MethodNode.java` | - | Method container with basic blocks |

---

## SSA Construction Algorithm - Phi Node Placement

### Entry Point

`SSATransform.process()` - Main SSA transformation

### Algorithm Overview

```
1. LiveVarAnalysis - Determine which registers are live at which blocks
2. For each register (0 to regsCount):
   a. Identify assignment blocks (blocks where register is assigned)
   b. Use dominance frontier to place phi nodes
   c. Process all blocks in dominance frontier
3. RenameVariables - Traverse dominator tree, assigning versions
4. Phi cleanup and optimization
```

### placePhi Method (SSATransform.java lines 66-94)

**Purpose:** Place phi nodes for a single register

```
placePhi(MethodNode mth, int regNum, LiveVarAnalysis la):
  1. Initialize BitSets: hasPhi (blocks with phi nodes), processed (visited)
  2. Get assignment blocks from LiveVarAnalysis.getAssignBlocks(regNum)
  3. Worklist algorithm iterates over assignment blocks
  4. For each block, iterate its dominance frontier (lines 81-92):
     - Check if block not already has phi and is live (isLive)
     - Add phi node via addPhi()
     - Mark as processed; if first time seeing this block, add to worklist
  5. Continue until worklist empty
```

### addPhi Method (SSATransform.java lines 96-120)

**Purpose:** Create and insert phi instruction

```
addPhi(MethodNode mth, BlockNode block, int regNum):
  - Get/create PhiListAttr on block
  - Size = predecessor count
  - Special case: Enter block adds size for method arguments (this + params)
  - Creates PhiInsn(regNum, size) with no args initially
  - Sets offset to block's start offset
  - Returns instruction for insertion at block start
```

---

## LiveVarAnalysis Algorithm

**File:** `visitors/ssa/LiveVarAnalysis.java` (121 lines)

### Data Structures

```java
uses[blockId]         // Registers used before defined in block
defs[blockId]         // Registers defined in block
assignBlocks[regNum]  // Which blocks assign to register
liveIn[blockId]       // Live-in set for block
```

### Process

**fillBasicBlockInfo() (lines 56-78):**
```
For each instruction in each block:
  - Register arguments: if not already defined, add to gen set
  - Register result: add to kill set, mark block as assignment
```

**processLiveInfo() (lines 80-111):**
```
Iterative data flow analysis (up to blocksCount * 10 iterations)
For each block: newIn = OR(successor liveIns) - kills + uses
Fixed point: continue until no changes
```

---

## Variable Renaming and SSA Form

### RenameState Structure

**File:** `visitors/ssa/RenameState.java` (64 lines)

```java
- mth: MethodNode
- block: BlockNode
- vars: SSAVar[] (one per register)
- versions: int[] (version counter per register)
```

### Renaming Algorithm (SSATransform.renameVariables lines 122-135)

**1. Initialize via RenameState.init():**
- For this argument: `startVar(thisArg)` -> version 0
- For all parameter registers: `startVar(argReg)` -> version 0

**2. Traverse Dominator Tree (lines 126-134):**
- Depth-first using dominator tree structure
- Stack-based traversal of dominated blocks
- For each block: `renameVarsInBlock(mth, state)`
- When descending to children: copy state via `RenameState.copyFrom()`

**3. Process Block Instructions (renameVarsInBlock() lines 146-179):**
```
For non-phi instructions:
  - Register arguments (uses): Get SSAVar from state, call use(arg)
  - Results: Create new SSAVar via startVar(result)
For phi successors:
  - Get phi nodes in successor block
  - Bind phi args to current state via bindPhiArg()
```

**4. Version Assignment (RenameState.startVar() lines 56-62):**
```
version = versions[regNum]++  // Post-increment version counter
Create new SSAVar: mth.makeNewSVar(regNum, version, regArg)
Store in vars[regNum]
```

### SSAVar Structure

**File:** `instructions/args/SSAVar.java` (344 lines)

```java
Fields:
- regNum, version       // Identifier (equality on both)
- assign: RegisterArg   // Phi or regular instruction result
- useList: List<RegisterArg>  // All uses of this var
- usedInPhi: List<PhiInsn>    // Phis that use this var
- codeVar: CodeVar      // Later bound to code variable
- typeInfo: TypeInfo    // Type inference data
```

### Phi Binding (bindPhiArg() lines 181-190)

```
For each successor with phi nodes:
  - Get phi's register number
  - Find SSAVar in current state
  - Call phi.bindArg(state.getBlock()) to bind arg to predecessor block
  - Register use via var.use(arg)
  - Track in var.addUsedInPhi(phiInsn)
```

---

## Block Processing and CFG Construction

**File:** `visitors/blocks/BlockProcessor.java` (770 lines)

### Processing Pipeline (processBlocksTree() lines 52-95)

```
1. Remove unreachable blocks
2. Compute dominators -> check for unreachable -> recompute
3. Fix multi-entry loops
4. Update clean successors
5. Iterative block modifications (lines 71-77):
   - modifyBlocksTree() - repeatedly modify CFG
   - Recompute dominators after each change
   - Limit: max(100, blocksCount) iterations
6. Check unreachable
7. Compute dominance frontier -> DominatorTree.computeDominanceFrontier()
8. Register loops, process nested loops
9. Post-dominators -> PostDominatorTree.compute()
10. Update clean successors
```

### Block Modifications (modifyBlocksTree() lines 309-319)

- `checkLoops()` - Loop structure fixes
- `mergeConstReturn()` - Merge constant + return blocks
- `splitExitBlocks()` - Split return/throw blocks

---

## Block Splitting Algorithm

**File:** `visitors/blocks/BlockSplitter.java` (467 lines)

### Initial Basic Block Creation (splitBasicBlocks() lines 86-128)

**Instructions triggering block split:**

**SPLIT_WITHOUT_CONNECT (lines 50-57):** RETURN, THROW, GOTO, IF, SWITCH, JSR, RET
- After these, next instruction starts new block (not connected)

**SEPARATE_INSNS (lines 34-41):** RETURN, IF, SWITCH, MONITOR_ENTER/EXIT, THROW, MOVE_EXCEPTION
- These need isolation in own block

**Other triggers (lines 115-119):**
- Try-enter/try-leave boundaries
- Exception handler start
- Jump targets
- Do-while loops

### CFG Construction

```
1. Create enter block (marked with MTH_ENTER_BLOCK)
2. Create exit block (marked with MTH_EXIT_BLOCK)
3. Iterate instructions:
   - First instruction: connect to enter via connectNewBlock()
   - Between: check split conditions
   - Map offset -> block in blocksMap
4. Process jumps: setupConnectionsFromJumps() connects blocks via jump targets
5. Process exceptions: addTempConnectionsForExcHandlers() creates temporary edges
6. Setup exit connections: connect all blocks with no successors to exit
```

### Exception Handler Connection Logic (lines 265-291)

- Traverse all instructions with `EXC_CATCH` attribute
- For each handler, create temporary connection from relevant block to handler block
- These edges help build dominance tree (more complete CFG)
- Later removed by `BlockExceptionHandler` in actual exception handling

---

## Dominance Frontier Calculation

**File:** `visitors/blocks/DominatorTree.java` (167 lines)

### Dominance Calculation (DominatorTree.compute() lines 23-27)

```
1. Sort blocks via DFS: BlockUtils.visitDFS(mth, sorted::add)
2. Build dominator array: BlockNode[] doms = build(sorted, BlockNode::getPredecessors)
3. Apply to blocks: set idom, doms BitSet, dominatesOn list
```

### Algorithm (build() lines 40-79)

Implements: Cooper, Keith D.; Harvey, Timothy J; Kennedy, Ken (2001)
"A Simple, Fast Dominance Algorithm"
Based on: http://www.hipersoft.rice.edu/grads/publications/dom14.pdf

**Steps:**
```
1. Initialize: doms[0] = root (entry block), others null
2. Iterate until fixed point:
   - For blocks 1 to N:
     - Find first dominator predecessor: newIDom
     - For remaining predecessors: newIDom = intersect(newIDom, pred)
     - If changed, set flag for recomputation
3. Intersect algorithm (lines 81-92):
   - Walk up dominator chains of two blocks
   - Find lowest common ancestor
```

### Apply (lines 95-109)

```
Root: empty dominator set, null idom
For each other block:
  - Set idom from doms array
  - Add block to idom.dominatesOn
  - Collect all dominators (recursive via idom chain)
```

### Dominance Frontier (computeDominanceFrontier() lines 131-156)

```
For each block with 2+ predecessors:
  For each predecessor:
    Walk up from predecessor until reaching this block's idom
    Add this block to each ancestor's dominance frontier (BitSet)

Special case: blocks can be in own dominance frontier (self-loop back edges)
```

**Definition:** Node X is in DF(Y) if:
- Y strictly dominates pred(X) but doesn't strictly dominate X

This precisely identifies where phi nodes are needed for a variable assigned at Y.

---

## Exception Handler Integration

**File:** `visitors/blocks/BlockExceptionHandler.java` (641 lines)

### Process (process() lines 50-74)

```
1. Compute dominance frontier with temp exception edges
2. Process catch attributes: remove from non-throwing insns
3. Initialize exception handlers: initExcHandlers()
4. Prepare try blocks: prepareTryBlocks()
5. Connect handlers to try blocks: connectExcHandlers()
6. Register in method
7. Remove monitor-exit from handlers
8. Remove marked blocks
```

### Initialize Handlers (initExcHandlers() lines 144-178)

- Find instructions with `EXC_HANDLER` attribute (exception handler starts)
- Split handler block if it has predecessors (to isolate handler)
- Create handler's block and mark dominated blocks as handler blocks
- Fix move-exception instruction with correct exception type

### Try-Catch Wrapping (wrapBlocksWithTryCatch() lines 327-396)

```
- Find top block (block with predecessors from outside try region)
- Find bottom block (where try paths rejoin)
- Create synthetic splitter blocks:
  - Top splitter (marked EXC_TOP_SPLITTER): connects try entry and handler entry
  - Bottom splitter (marked EXC_BOTTOM_SPLITTER): connects handler and continuation
- Connect splitters to all handlers
- Special handling for return blocks to avoid self-loops
```

### Merge Multi-Catch (lines 538-583)

- If multiple handlers all only contain move-exception and flow to same block:
  - Merge them into single handler with multiple catch types
  - Remove redundant handler blocks

---

## Post-Dominator Tree

**File:** `visitors/blocks/PostDominatorTree.java` (73 lines)

### Purpose

Identify blocks guaranteed to execute after a given block

### Algorithm

```
1. Reverse DFS from exit to entry (building reverse topological order)
2. Reorder blocks to match reverse DFS
3. Run standard dominator algorithm on reversed graph (using successors instead of predecessors)
4. Remap results back to original block ordering
5. Handle infinite loops: blocks not visited get empty post-dominator set
```

### Usage

- Loop analysis
- Dead code detection
- Code generation ordering

---

## SSA Destruction / De-SSA Conversion

JADX performs partial SSA destruction via:

### Phi Node Cleanup (SSATransform.tryToFixUselessPhi() lines 259-298)

- Remove unused phi nodes
- Merge phi with single argument into move instruction
- Merge phi with identical arguments into move instruction
- Iterative until fixed point (limit: `getSVars().size() * 2`)

### Phi Inlining (inlinePhiInsn() lines 390-419)

```
If phi has one argument and all uses can be inlined:
  - Replace phi's SSAVar references with arg's SSAVar
  - Remove phi instruction
  - Add DONT_INLINE flag to prevent redundant copies
```

### Phi Hiding (hidePhiInsns() lines 448-452)

- Remove all PHI instructions from blocks
- They're kept in `PhiListAttr` for analysis but not in final output
- Later passes use PHI info for type inference without generating them

**Note:** Full de-SSA (removing all SSA properties) happens during code generation, not here. JADX keeps SSA form for downstream analysis.

---

## Critical Data Structures

### BlockNode

**File:** `nodes/BlockNode.java` (250+ lines)

```java
- cid: int                          // Const ID (permanent)
- pos: int                          // Position in blocks list (for BitSet indexing)
- startOffset: int                  // Bytecode offset
- instructions: List<InsnNode>
- predecessors/successors: List<BlockNode>
- cleanSuccessors: List<BlockNode>  // Excluding exception paths, loop back edges
- doms: BitSet                      // All dominators (excluding self)
- postDoms: BitSet                  // All post-dominators
- domFrontier: BitSet               // Dominance frontier
- idom: BlockNode                   // Immediate dominator
- iPostDom: BlockNode               // Immediate post-dominator
- dominatesOn: List<BlockNode>      // Blocks this dominates
```

### PhiInsn

**File:** `instructions/PhiInsn.java` (142 lines)

```java
- blockBinds: List<BlockNode>  // Map args to their predecessor blocks
- Result: RegisterArg (same reg number as all args)
- Arguments: RegisterArg[] (uninitialized initially)

Key method: bindArg(RegisterArg arg, BlockNode pred)
  - Associates argument with specific predecessor block
  - Maintains parallel lists of args and binding blocks
```

### SSAVar

**File:** `instructions/args/SSAVar.java` (344 lines)

```java
- regNum/version: int               // Identifier (e.g., "r3v2" = register 3, version 2)
- assign: RegisterArg               // Single assignment (from phi or normal insn)
- useList: List<RegisterArg>        // All uses
- usedInPhi: List<PhiInsn>          // Phis that use this var
- codeVar: CodeVar                  // Later linked to high-level variable
- typeInfo: TypeInfo                // Type constraints/inference

Key methods:
- use(RegisterArg): Add use and set SSAVar reference
- removeUse(RegisterArg): Remove use
- addUsedInPhi(PhiInsn): Track phi nodes
```

### LiveVarAnalysis

```java
- uses[blockId]: BitSet             // Gen (upward exposed uses)
- defs[blockId]: BitSet             // Kill (definitions)
- assignBlocks[regNum]: BitSet      // Which blocks assign to register
- liveIn[blockId]: BitSet           // Live-in set

Pattern: Dataflow analysis (gen/kill sets, fixpoint iteration)
```

---

## Exception Handler Attributes

### TryCatchBlockAttr

```java
- id: int                           // Unique identifier
- handlers: List<ExceptionHandler>
- blocks: List<BlockNode>           // Blocks in try region
- innerTryBlocks: List             // Nested try blocks
- outerTryBlock: TryCatchBlockAttr  // Parent try block
- topSplitter/bottomSplitter: BlockNode  // Synthetic boundary blocks
```

### ExceptionHandler

```java
- handlerBlock: BlockNode           // Start of handler
- blocks: List<BlockNode>           // All handler blocks
- catchTypes: List<ClassInfo>       // Exception types caught
- arg: RegisterArg/NamedArg         // Exception variable (from move-exception)
```

### CatchAttr (on instructions)

```java
- handlers: List<ExceptionHandler>  // Which handlers can catch from this insn
```

---

## Key Algorithm Properties

### Iterative Refinement

- Block splitting phase sets up preliminary CFG
- Exception handlers add temporary edges for better dominance
- Dominator computation runs multiple times as CFG is refined
- Loop detection adds block markers that trigger further refinement

### Correctness Invariants

1. Every block reachable from entry
2. Every block that doesn't return/throw has successor(s)
3. Phi nodes placed exactly at dominance frontier + live-in set
4. Every register use has dominating assignment (SSAVar)
5. Each SSAVar version has exactly one assignment

### Performance Optimization

- BitSets for dominance info (space & time efficient)
- Cached dominance frontier (computed once)
- Clean successors cached (excludes exception/loop edges)
- Iteration limits prevent infinite loops in pathological CFGs

---

## Implementation Checklist for Rust Clone

### Phase 1: Basic Block Construction

- [ ] Parse bytecode into instruction stream
- [ ] Implement basic block splitter (identify split points)
- [ ] Build initial CFG edges
- [ ] Handle jump targets
- [ ] Connect to entry/exit blocks

### Phase 2: Exception Handling

- [ ] Parse exception handler table
- [ ] Create temporary CFG edges to handlers
- [ ] Implement handler block splitter
- [ ] Connect try blocks and handlers

### Phase 3: Dominance Analysis

- [ ] Implement DFS block ordering
- [ ] Implement dominator algorithm (Cooper et al.)
- [ ] Calculate dominance frontier using algorithm
- [ ] Implement post-dominator calculation (reverse graph)

### Phase 4: Loop Detection & Refinement

- [ ] Mark loop start/end blocks
- [ ] Implement loop nesting hierarchy
- [ ] Insert pre-headers, break/continue blocks
- [ ] Recompute dominators as needed

### Phase 5: SSA Construction

- [ ] Implement live variable analysis (gen/kill/liveIn)
- [ ] Implement phi placement (dominance frontier algorithm)
- [ ] Implement variable renaming (dominator tree traversal)
- [ ] Create phi nodes with proper predecessor binding

### Phase 6: SSA Cleanup

- [ ] Implement phi optimization (same args, single arg)
- [ ] Implement phi inlining
- [ ] Remove unused phis
- [ ] Hide phis from final output

---

## Code Generation Dependencies

These systems output to:
- **InitCodeVariables**: Links SSAVar to CodeVar (high-level variables)
- **TypeInference**: Uses SSA structure to infer types
- **ConstantPropagation**: Tracks constant assignments through SSA
- **DeadCodeElimination**: Uses dominance info
- **CodeRegionBuilder**: Uses blocks and dominance to build control structures

These must run **after** SSA transformation completes.

---

## Rust Implementation Notes

### Data Structures

```rust
pub struct BlockNode {
    pub id: BlockId,
    pub pos: usize,
    pub start_offset: u32,
    pub instructions: Vec<InsnNode>,
    pub predecessors: Vec<BlockId>,
    pub successors: Vec<BlockId>,
    pub clean_successors: Vec<BlockId>,
    pub doms: BitSet,
    pub post_doms: BitSet,
    pub dom_frontier: BitSet,
    pub idom: Option<BlockId>,
    pub i_post_dom: Option<BlockId>,
    pub dominates_on: Vec<BlockId>,
}

pub struct PhiInsn {
    pub reg_num: u32,
    pub result: RegisterArg,
    pub args: Vec<RegisterArg>,
    pub block_binds: Vec<BlockId>,
}

pub struct SSAVar {
    pub reg_num: u32,
    pub version: u32,
    pub assign: RegisterArgRef,
    pub use_list: Vec<RegisterArgRef>,
    pub used_in_phi: Vec<PhiInsnRef>,
    pub code_var: Option<CodeVarRef>,
    pub type_info: TypeInfo,
}

pub struct LiveVarAnalysis {
    pub uses: Vec<BitSet>,      // Per-block gen sets
    pub defs: Vec<BitSet>,      // Per-block kill sets
    pub assign_blocks: Vec<BitSet>,  // Per-register assignment blocks
    pub live_in: Vec<BitSet>,   // Per-block live-in sets
}
```

### Key Algorithms

Use `bitvec` or `fixedbitset` crate for efficient BitSet operations.

The dominator algorithm is well-documented (Cooper et al. 2001) and maps directly to Rust iterators.
