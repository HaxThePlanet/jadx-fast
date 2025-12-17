# JADX Region Extraction & Control Flow Reconstruction Reference

This document provides implementation-level detail of JADX's region extraction and control structure reconstruction system for building a 1:1 clone in Rust.

## Core Region Architecture

### Region Hierarchy

**Location:** `jadx-core/src/main/java/jadx/core/dex/regions/`

| Class | Description |
|-------|-------------|
| `Region.java` | Basic container region holding list of IContainer sub-blocks |
| `AbstractRegion.java` | Base class implementing parent tracking and IRegion interface |
| `LoopRegion.java` | Extends ConditionRegion for loop constructs (while, do-while, for, for-each) |
| `IfRegion.java` | Extends ConditionRegion for if/else statements |
| `SwitchRegion.java` | Switch/case statement container |
| `SynchronizedRegion.java` | Synchronized block wrapper |
| `TryCatchRegion.java` | Exception handling regions |
| `ConditionRegion.java` | Abstract base for loops and ifs with IfCondition storage |

### Key Region Interfaces (IRegion, IContainer)

Regions are composable trees where each IContainer can be either:
- A `BlockNode` (basic instruction block)
- An `IRegion` (Region, IfRegion, LoopRegion, SwitchRegion, etc.)

---

## RegionMaker - Main Construction Algorithm

**File:** `jadx-core/src/main/java/jadx/core/dex/visitors/regions/maker/RegionMaker.java` (165 lines)

### Entry Point

`makeMthRegion()` - Creates region from method entry block

### Core Algorithm (RegionMaker.traverse)

```
traverse(region, block) {
  if block == method_exit:
    return null  // stop traversal

  // Priority 1: Check for loops
  if block has LOOP_START flag:
    next = loopMaker.process(region, loop, stack)
    return next

  // Priority 2: Check last instruction type
  if lastInsn == IF:
    next = ifMaker.process(region, block, ifNode, stack)
  else if lastInsn == SWITCH:
    next = SwitchRegionMaker.process(...)
  else if lastInsn == MONITOR_ENTER:
    next = SynchronizedRegionMaker.process(...)
  else:
    region.add(block)  // add as plain block
    next = getNextBlock(block)

  // Continue if not at exit boundary
  if next != null && !stack.containsExit(block):
    return next
  return null
}
```

### Key Components

- `RegionStack` - Maintains nested region context and exit block boundaries
- `processedBlocks` - BlockSet tracking already-processed blocks
- `regionsLimit` - Overflow protection (size * 100)

---

## Loop Detection & Structuring

**File:** `jadx-core/src/main/java/jadx/core/dex/visitors/regions/maker/LoopRegionMaker.java` (470 lines)

### Loop Detection (LoopInfo Attributes)

- Loops identified by dominance frontier analysis (pre-computed on CFG)
- Marked with `AType.LOOP` attribute on start block
- Contains: start block, end block, loop blocks set, exit nodes set

### Loop Type Determination

```
makeLoopRegion(curRegion, loop, exitBlocks) {
  for each exitBlock in priority order:
    if exitBlock has IF instruction:
      conditionBlock = exitBlock
      if exitAtLoopEnd(conditionBlock, loop) OR
         canMergePreCondition(loopStart, conditionBlock) OR
         isEmptySimplePath(loopStart, conditionBlock):
        Create LoopRegion(curRegion, loop, conditionBlock, reversed)
        return it

  if no exit found:
    // Endless loop (while(true), infinite for)
    return makeEndlessLoop(...)
  return null
}
```

### Loop Structure Detection

| Type | Description |
|------|-------------|
| **Condition at Start (while/for)** | Condition block at loop start or early |
| **Condition at End (do-while)** | Condition block at loop end (reversed flag set) |
| **Endless Loops** | No conditional exit found, explicit breaks inserted |

### LoopType Matching (Post-Region Construction)

**While/Do-While:** Generic LoopRegion

**Indexed For Loop (ForLoop type):** Requires:
- Loop end has increment instruction (ARITH node with INC)
- Increment result used in loop back-edge PHI
- Condition uses loop variable

**For-Each Loop (ForEachLoop type):**
- Synthetic variable and iterable
- Fake REGION_ARG instructions injected for variable/iterable

### Break/Continue Insertion

```
insertLoopBreak(stack, loop, loopExit, exitEdge) {
  if exit leads to outer loop:
    confirm = true
    addLabel(parentLoop)  // labeled break if nested
  else:
    // Find insertion point via path analysis
    while following empty path to loopExit:
      if canInsertBreak(point):
        insertEdge = point
        confirm = true

  if confirmed:
    InsnNode break = new InsnNode(BREAK)
    break.addAttr(AType.LOOP, loop)
    EdgeInsnAttr.addEdgeInsn(insertEdge, break)
    if nested loops: break.addAttr(LoopLabelAttr(parentLoop))
}

insertContinue(loop) {
  for each loopEnd predecessor with SYNTHETIC flag:
    if canInsertContinue(pred):
      pred.add(new InsnNode(CONTINUE))
}
```

### Labeled Statements

**File:** `jadx-core/src/main/java/jadx/core/dex/attributes/nodes/LoopLabelAttr.java`

- Applied when breaking from nested loop to outer loop
- Both loop start and break instruction marked with LoopLabelAttr
- Codegen detects and generates: `outerLoop: { ... break outerLoop; }`

---

## If/Else/Switch Reconstruction

### If Statement Maker

**File:** `jadx-core/src/main/java/jadx/core/dex/visitors/regions/maker/IfRegionMaker.java` (525 lines)

### Algorithm - Complex Multi-Pass Merging

```
process(currentRegion, block, ifNode, stack) {
  currentIf = makeIfInfo(block)  // Extract condition blocks

  // Attempt 1: Merge nested if conditions
  mergedIf = mergeNestedIfNodes(currentIf)
  if mergedIf != null:
    currentIf = mergedIf
  else:
    currentIf = IfInfo.invert(currentIf)  // Try inverted

  // Attempt 2: Restructure based on branch validity
  modifiedIf = restructureIf(currentIf)
  if modifiedIf == null:
    // Fallback: try other inversion
    currentIf = restructureIf(makeIfInfo(block))

  confirmMerge(currentIf)  // Mark merged blocks as ADDED_TO_REGION

  // Create region and recurse
  ifRegion = new IfRegion(currentRegion)
  ifRegion.setThenRegion(regionMaker.makeRegion(thenBlock))
  ifRegion.setElseRegion(thenBlock != elseBlock ?
    regionMaker.makeRegion(elseBlock) : null)

  return outBlock
}
```

### Condition Merging (Handle && and || operators)

```
mergeNestedIfNodes(currentIf) {
  // Try to follow then branch
  nextIf = getNextIf(currentIf, curThen)
  if nextIf:
    followThenBranch = true
  else:
    nextIf = getNextIf(currentIf, curElse)
    if nextIf:
      followThenBranch = false

  if followThenBranch:
    // AND pattern: if (a && b)
    result = mergeIfInfo(currentIf, nextIf, AND)
  else:
    // OR pattern: if (a || b)
    result = mergeIfInfo(currentIf, nextIf, OR)

  // Recursively search for more merges
  return searchNestedIf(result)
}
```

---

## IfCondition Tree Structure

**File:** `jadx-core/src/main/java/jadx/core/dex/regions/conditions/IfCondition.java` (364 lines)

### Mode Enum

```java
Mode {
  COMPARE,   // Base: a op b (single condition)
  AND,       // Merged: (a && b)
  OR,        // Merged: (a || b)
  NOT,       // Inversion: !(expr)
  TERNARY    // Ternary: a ? b : c
}
```

### Structure

```java
IfCondition {
  mode: Mode
  compare: Compare (if COMPARE)
  args: List<IfCondition> (if AND/OR/NOT/TERNARY)
}
```

### Simplification Rules

```
// Boolean Comparisons
(a & b) == 0    -> a == 0 && b == 0
(a & b) != 0    -> a != 0 || b != 0
(a | b) == 1    -> a == 1 || b == 1
(a | b) != 1    -> a != 1 && b != 1

// Double Negation Removal
!!condition     -> condition
NOT NOT cond    -> cond

// CMP Simplification
cmp_l(a, b) == 0    -> a == b
cmp_g(a, b) == 0    -> a == b
(a == false)        -> NOT a

// Mode Inversion (De Morgan's Law)
!(a AND b)      -> !a OR !b
!(a OR b)       -> !a AND !b

// Ternary Optimization
NOT (a ? b : c) -> a ? NOT b : NOT c

// Negation Count Heuristic
If more than 50% of arguments are negated, invert the entire condition
Improves readability: !(a || b || c) becomes !a && !b && !c
```

---

## Switch Statement Maker

**File:** `jadx-core/src/main/java/jadx/core/dex/visitors/regions/maker/SwitchRegionMaker.java` (407 lines)

### Key Steps

```
process(currentRegion, block, switchInsn, stack) {
  // Map case blocks to key lists
  blocksMap = {}
  for each target in switchInsn.targets:
    blocksMap[targetBlock].add(key)
  blocksMap[defCase].add(DEFAULT_CASE_KEY)

  // Calculate switch exit block
  out = calcSwitchOut(block, insn, stack)

  // Add cases with fallthrough detection
  addCases(sw, out, stack, blocksMap)

  // Clean up empty cases
  removeEmptyCases(...)

  return out
}

addCases(sw, out, stack, blocksMap) {
  // Detect fallthrough cases using dominance frontier
  for each successor:
    if successor.domFrontier intersects caseBlocks:
      fallThroughCases[successor] = some_case_block

  for each (caseBlock, keysList) in blocksMap:
    caseRegion = regionMaker.makeRegion(caseBlock)
    if fallthrough case:
      caseRegion.add(AFlag.FALL_THROUGH)
    sw.addCase(keysList, caseRegion)
}

// Break insertion (post-processing)
insertBreaks(sw) {
  for each case:
    traverse case checking exit edges
    if region exits switch: add synthetic break
}
```

### Fall-Through Cases

- Detected via dominance frontier analysis
- Marked with FALL_THROUGH flag
- Cases reordered if necessary to match bytecode fallthrough

### Edge Insn Handling

- Break/continue on edges stored in EdgeInsnAttr
- Applied when case exits don't reach normal path
- Particularly important for loops containing switches

---

## Region Tree Hierarchy & Processing

### Parent-Child Relationships

```
LoopRegion extends ConditionRegion extends AbstractRegion
  - parent: IRegion (outer region)
  - body: IRegion (loop body)
  - header: BlockNode (condition block, null for endless)
  - preCondition: BlockNode (for-loop init)

IfRegion extends ConditionRegion
  - parent: IRegion
  - thenRegion: IContainer
  - elseRegion: IContainer (nullable)

SwitchRegion extends AbstractRegion
  - parent: IRegion
  - header: BlockNode
  - cases: List<CaseInfo> with keys and containers

Region extends AbstractRegion
  - blocks: List<IContainer> (flat list of sub-blocks/regions)
```

### RegionStack for Context Management

```java
RegionStack {
  stack: Deque<State>
  curState: State {
    region: IRegion (current nesting context)
    exits: Set<BlockNode> (boundary blocks for this level)
  }

  push(region) - enter new region context
  pop() - exit region context
  addExit(block) - mark block as boundary
  containsExit(block) - check if at boundary
}
```

### Exit Boundary Semantics

- Exit blocks prevent traversal past region boundary
- Used to stop recursion at loop/if condition blocks
- Critical for correct loop body/branch separation

---

## Break/Continue Handling

### Break Insertion (LoopRegionMaker)

- Inserted on edges exiting loop
- Applied to: endless loops, nested loops with external exits
- Label added if breaking to outer loop

### Continue Insertion

- Synthetic predecessors of loop end block marked with CONTINUE
- Only if block can reach loop exit path
- Prevents inlining of other statements

### Labeled Break/Continue

- LoopLabelAttr attached to both break insn and loop start
- Generated when: nested loops where inner exits to outer
- Example: `break outerLoop;`

### Switch Break Optimization

**File:** `jadx-core/src/main/java/jadx/core/dex/visitors/regions/SwitchBreakVisitor.java`

```
ExtractCommonBreak:
  if all case branches end with break/exit:
    remove break from each case
    add single break after switch

RemoveUnreachableBreak:
  if previous insn is exit (return/throw/continue):
    remove break (unreachable)
```

---

## Edge Cases & Complex Scenarios

### Nested Loops

- Parent loop reference stored in LoopInfo
- Break/continue labels track which loop to exit
- Multi-level nesting handled recursively by RegionStack

### Nested Conditionals

- Merged during IfRegionMaker.mergeNestedIfNodes
- Complex patterns detected (AND/OR chains, ternary)
- DesMerge fails if conditions cross-exit (thrown exception)

### Complex Fallthrough

- Switch cases with fallthrough reordered if necessary
- Warning emitted if reordering fails
- Fallthrough flag prevents break extraction

### Loop in Switch in Loop

- Each level maintains separate exit boundary
- Switch case exits validated against outer loop
- Continue in switch case must reach loop end block

### If in Loop Body

- Loop condition blocks marked ADDED_TO_REGION
- If statements within loop processed recursively
- Exit blocks must not cross loop boundary

### Labeled Blocks within Conditionals

- Loop start marked with LoopLabelAttr
- Break instruction carries same label
- Codegen recognizes pattern and generates labeled statement

### Pre-condition Blocks (for-loop init)

- For indexed loops: init instruction before condition
- Pre-condition block verified via:
  - Single variable assignment
  - Result only used in condition/increment
  - No side effects
- Merged into condition during code generation

---

## Post-Processing & Visitors

### Region Processing Pipeline

1. **RegionMakerVisitor** - Initial region tree construction
2. **ProcessTryCatchRegions** - Exception handler wrapping
3. **PostProcessRegions** - Switch break insertion, cleanup
4. **LoopRegionVisitor** - Convert while to indexed/for-each
5. **IfRegionVisitor** - Reorder branches, merge else-if chains
6. **SwitchBreakVisitor** - Extract/remove common breaks
7. **ReturnVisitor** - Optimize return paths
8. **IfRegionVisitor again** - Final optimization pass

### TernaryMod

- Converts nested if-else into ternary operator where appropriate
- Condition pattern: `if (a) x = b; else x = c;` -> `x = a ? b : c;`

---

## Rust Implementation Key Points

### Critical Data Structures

1. **Region tree with parent pointers** (arena allocator recommended)
2. **BlockNode references** (index-based to handle cycles)
3. **Exit boundary set** (compact bit set or HashSet)
4. **Loop dominance frontier** (BitSet)
5. **PHI node tracking** (for indexed loop detection)

### Algorithm Implementation Order

1. Region tree construction (RegionMaker pattern)
2. Loop region handling (nested stack context)
3. If/else merging (complex condition tree builder)
4. Switch processing (fallthrough detection)
5. Break/continue insertion (edge path analysis)
6. Post-processing visitors (tree traversal passes)

### Rust-Specific Considerations

```rust
// Use Rc<RefCell<>> or arena for shared parent references
pub struct Region {
    parent: Option<RegionRef>,
    blocks: Vec<IContainer>,
}

// Visitor pattern with trait methods
pub trait RegionVisitor {
    fn visit_region(&mut self, region: &mut Region);
    fn visit_loop(&mut self, loop_region: &mut LoopRegion);
    fn visit_if(&mut self, if_region: &mut IfRegion);
    fn visit_switch(&mut self, switch_region: &mut SwitchRegion);
}

// Condition tree: recursive enum with Box references
pub enum IfCondition {
    Compare(Compare),
    And(Vec<IfCondition>),
    Or(Vec<IfCondition>),
    Not(Box<IfCondition>),
    Ternary { cond: Box<IfCondition>, then: Box<IfCondition>, else_: Box<IfCondition> },
}

// Exit boundary: BTreeSet for efficient contains checks
pub struct RegionStack {
    stack: Vec<RegionState>,
}

pub struct RegionState {
    region: RegionRef,
    exits: BTreeSet<BlockNodeId>,
}
```

- Use `BitSet` crate for dominance/frontier operations
- Stack depth tracking (prevent stack overflow on deeply nested code)

---

## Key Files Summary

| File | Lines | Purpose |
|------|-------|---------|
| `RegionMaker.java` | 165 | Core algorithm |
| `LoopRegionMaker.java` | 470 | Loop handling |
| `IfRegionMaker.java` | 525 | If/merge logic |
| `SwitchRegionMaker.java` | 407 | Switch logic |
| `IfCondition.java` | 364 | Condition tree model |
| `LoopRegion.java` | 184 | Loop region model |
| `LoopInfo.java` | 111 | Loop metadata |
