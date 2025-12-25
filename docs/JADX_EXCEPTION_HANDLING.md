# JADX Exception Handling & Finally Block Reconstruction Reference

This document provides implementation-level detail of JADX's exception handling and finally block reconstruction system for building a 1:1 clone in Rust.

## Core Files

### Exception Handling Package (`dex/trycatch/`)

| File | Purpose |
|------|---------|
| `TryCatchBlockAttr.java` | Main attribute class representing try-catch blocks |
| `ExceptionHandler.java` | Represents individual exception handlers (catch blocks) |
| `CatchAttr.java` | Attribute containing list of handlers for an instruction |
| `ExcHandlerAttr.java` | Wrapper attribute for exception handlers |

### Finally Block Package (`visitors/finaly/`)

| File | Purpose |
|------|---------|
| `MarkFinallyVisitor.java` | Searches and marks duplicated finally code |
| `FinallyExtractInfo.java` | Data structure holding finally extraction metadata |
| `InsnsSlice.java` | Represents a slice of instructions in finally blocks |

---

## TryCatchBlockAttr - Structure and Nested Exception Handling

### Key Attributes

```java
private final int id;                                    // Unique ID for try block
private final List<ExceptionHandler> handlers;           // List of catch handlers
private List<BlockNode> blocks;                         // Protected code blocks
private TryCatchBlockAttr outerTryBlock;               // For nested try-catch
private List<TryCatchBlockAttr> innerTryBlocks;        // Inner nested blocks
private boolean merged;                                 // Merged with outer block flag
private BlockNode topSplitter;                         // Synthetic block at try entrance
```

### Key Methods

| Method | Description |
|--------|-------------|
| `isAllHandler()` | Checks if only catch-all (Throwable) handler exists |
| `isThrowOnly()` | Verifies try block contains only THROW/MOVE_EXCEPTION/MONITOR_EXIT |
| `addInnerTryBlock()` | Manages nested exception handling relationships |
| `getOuterTryBlock()` | Gets parent try block |

Inner and outer try block linking supports complex nested scenarios.

---

## ExceptionHandler - Exception Variable and Handler Details

### Key Attributes

```java
private List<ClassInfo> catchTypes;      // Exception types caught (can be multiple)
private int handlerOffset;               // DEX offset where handler starts
private BlockNode handlerBlock;          // Synthetic entry block for handler
private List<BlockNode> blocks;          // All blocks dominated by handler
private InsnArg arg;                     // Exception variable (move-exception result)
private TryCatchBlockAttr tryBlock;      // Reference to parent try block
private boolean isFinally;               // True if this is finally handler
```

### Key Methods

| Method | Description |
|--------|-------------|
| `build()` | Static factory creating handlers from DEX data |
| `addCatchType()` / `getCatchTypes()` | Multi-exception support (multi-catch) |
| `isCatchAll()` | Detects catch(Throwable) or null type handlers |
| `getArgType()` | Derives exception type, returns THROWABLE for catch-all |
| `markForRemove()` | Marks handler blocks with REMOVE flag for cleanup |

---

## Try-Catch Block Reconstruction from DEX Exception Tables

### Input Data Flow

**DEX Exception Table contains:**
- `ITry.getStartOffset()` / `ITry.getEndOffset()` - Protected code range
- `ICatch.getTypes()` - Array of exception type class names
- `ICatch.getHandlers()` - Array of handler offsets (bytecode locations)
- `ICatch.getCatchAllHandler()` - Special handler for catch-all (index -1 if none)

### Reconstruction Process (AttachTryCatchVisitor)

**Phase 1: Attachment** (`AttachTryCatchVisitor.initTryCatches`)
```
- Iterates through raw DEX try blocks
- For each ITry, collects handlers via convertToHandlers()
- Creates ExceptionHandler objects at handler offsets
- Marks instructions with TRY_ENTER flag at start, TRY_LEAVE at end
- Inserts synthetic NOP instructions if no instructions in range
```

**Phase 2: Attachment Storage** (`markTryBounds`)
```
- Attaches CatchAttr to all instructions in try range
- Handlers sorted by offset (CatchAttr.build())
- Each handler marked with ExcHandlerAttr on entry instruction
```

**Phase 3: Block Analysis** (`BlockExceptionHandler.process`)
```
processCatchAttr()           -> Remove catch attr from non-throwing insns
                             -> Consolidate common catch attrs per block

initExcHandlers()            -> Extract handler entry blocks
                             -> Connect dominance tree for handler blocks

prepareTryBlocks()           -> Build try-catch graph
                             -> Merge multi-catch handlers
                             -> Establish outer/inner relationships

connectExcHandlers()         -> Wrap try blocks with splitters
                             -> Connect handlers to top/bottom splitters
```

---

## Finally Block Detection and Reconstruction (MarkFinallyVisitor)

### Prerequisites for Finally Extraction

1. Try block must have exactly one catch-all (Throwable) handler
2. Catch-all handler must re-throw the exception at end
3. Handler must contain code beyond just move-exception

### Extraction Process (extractFinally)

```
1. Find Catch-All Handler
   - Scan handlers for isCatchAll()
   - Verify last insn is THROW

2. Collect Handler Blocks
   - Get blocks dominated by handler block (via dominance frontier)
   - Remove handler entry block (contains move-exception)
   - Remove empty throw-only blocks

3. Search for Duplicated Finally Code
   - For each specific exception handler in try block:
     - Search for duplicate instruction sequences
     - Match from end of blocks first (common pattern)

4. Validate Slices
   - All duplicate slices must have same size
   - Instruction types must match exactly
   - Register variables must be compatible

5. Remove Finally from Try Paths
   - Find path endings (blocks leading to handler exit)
   - Collect predecessor blocks for all exit points
   - Search upward for finally code duplication
```

### Finally Code Extraction

- Instructions marked with `DONT_GENERATE` flag in duplicates
- Instructions marked with `FINALLY_INSNS` flag in original
- SSA variables synchronized via `copyCodeVars()`
- Register debug info preserved for proper variable naming

### Edge Cases Handled

| Case | Handling |
|------|----------|
| **Incomplete slices** | Only complete slices accepted |
| **Loop end blocks** | Skip loop back edges during traversal |
| **Register assignments** | Track assignments via `assignedOutsideHandler()` |
| **Debug information** | Match via `RegDebugInfoAttr` when available |
| **Variable compatibility** | Check `sameCodeVar()` and `sameDebugInfo()` |

---

## FinallyExtractor - Duplicated Code Identification

### Data Structure (InsnsSlice)

```java
List<InsnNode> insnsList              // Ordered list of instructions
Map<InsnNode, BlockNode> insnMap      // Maps insn to containing block
boolean complete                       // Indicates all expected insns found
```

### Detection Algorithm

**isStartBlock() - Find where finally code begins in duplicate:**
- Handles mid-block finally code start
- Compares from end of block first (optimization)
- Falls back to linear search if needed

**checkBlocksTree() - Recursively match block structure:**
- Cache blocks already checked (BlockPair -> Boolean)
- Verify successors match between finally and duplicate
- Stop at handler blocks (contained in allHandlerBlocks)
- Build complete slice tree

**sameInsns() - Instruction matching:**
- Check instruction types match
- Compare all arguments
- Handle register and constant arguments specially

**isSameArgs() - Argument compatibility checking:**
- **Register args**: Check SSA variables (sameCodeVar)
- **Fallback**: Check debug info or assignment context
- **Constants**: Must have identical constant values

### Slice Completion

- Slices marked complete when all instructions found
- Incomplete slices reset if extraction fails
- Final validation ensures all slices have same structure

---

## Nested Exception Handling

### Outer/Inner Relationships

**Detection** (`BlockExceptionHandler.checkTryCatchRelation`)

```
Case 1: Same Try Blocks
  -> Merge handlers into single try block with combined handlers

Case 2: Catch in Handler + Catch/Try Outside Handler
  -> Inner try block nested under outer
  -> Inner marked with setOuterTryBlock()
  -> Outer.addInnerTryBlock()

Case 3: Subset of Handlers
  -> Merge if inner handlers contain all outer handlers
```

**Finally Block with Inner Try Blocks:**
- When finally extracted, inner try blocks merged into outer
- All handlers collected recursively
- Ensures complete duplicate detection across nesting levels

### Example Structure

```
TryCatchBlockAttr (id=0, outer)
├── handlers: [ExceptionHandler for Exception]
├── blocks: [B1, B2, B3]
└── innerTryBlocks: [TryCatchBlockAttr (id=1, inner)]
    ├── handlers: [ExceptionHandler for IOException]
    ├── blocks: [B2]
    └── outerTryBlock: (reference to id=0)
```

---

## Edge Cases: Synchronized Blocks, Try-With-Resources

### Synchronized Block Handling (SynchronizedRegionMaker)

**Relationship to Exception Handling:**
- Synchronized blocks compiled to MONITOR_ENTER/MONITOR_EXIT
- MONITOR_EXIT must be in handler blocks (implicit finally)
- `removeMonitorExitFromExcHandler()` removes monitor-exit from handler blocks

**Detection:**
```java
// In BlockExceptionHandler.removeMonitorExitFromExcHandler()
for (BlockNode excBlock : excHandler.getBlocks()) {
    for (InsnNode insn : excBlock.getInstructions()) {
        if (insn.getType() == InsnType.MONITOR_ENTER) {
            break;  // Stop at monitor-enter
        }
        if (insn.getType() == InsnType.MONITOR_EXIT) {
            remover.addAndUnbind(insn);  // Remove monitor-exit
        }
    }
}
```

**Synchronized Region Creation:**
- MONITOR_ENTER instruction marks region entrance
- Traverse successors finding matching MONITOR_EXIT instructions
- Multiple exits handled via `traverseMonitorExits()`
- Synthetic blocks created for exit path convergence

### Try-With-Resources

- Not explicitly handled in exception system
- Compiled to implicit finally blocks with monitor operations
- Detected as catch-all handler with cleanup code duplication
- Multi-catch support enables resource exception merging

---

## Exception Variables - Move-Exception Handling

### MOVE_EXCEPTION Instruction Processing

**Instruction Definition:**
- Type: `InsnType.MOVE_EXCEPTION`
- Takes result register for exception variable
- First instruction in handler block (or after handler entry NOP)

**Variable Type Inference** (`BlockExceptionHandler.fixMoveExceptionInsn`)
```java
if (me != null && me.getType() == InsnType.MOVE_EXCEPTION) {
    ArgType argType = excHandler.getArgType();  // From handler's catch types
    RegisterArg resArg = InsnArg.reg(me.getResult().getRegNum(), argType);
    me.setResult(resArg);
    me.add(AFlag.DONT_INLINE);
    resArg.add(AFlag.CUSTOM_DECLARE);
    excHandler.setArg(resArg);
}
```

### Variable Lifecycle

1. **Creation** - RegisterArg created with inferred type
2. **SSA Assignment** - Variable assigned to exception handler
3. **Reference Tracking** - Uses tracked via SSA def-use chains
4. **Code Variable Mapping** - `copyCodeVars()` during finally extraction

### Exception Argument Cases

```java
public ArgType getArgType() {
    if (isCatchAll()) {
        return ArgType.THROWABLE;  // catch-all -> Throwable type
    }
    List<ClassInfo> types = getCatchTypes();
    if (types.size() == 1) {
        return types.iterator().next().getType();  // Single type
    }
    return ArgType.THROWABLE;  // Multi-catch -> Common Throwable
}
```

### Named Arguments for Unused Exceptions

```java
if (/* no move-exception found */) {
    // Handler not used in code -> create synthetic "unused" var
    excHandler.setArg(new NamedArg("unused", argType));
}
```

### Multi-Catch Handler Merging

When multiple handlers (IOException, SQLException) merge to single catch:
- All handlers' move-exception insns point to same register
- Register gets union of exception types or defaults to Throwable
- Variable name generation uses first exception type for declaration

---

## Data Flow Architecture

### Processing Pipeline

```
1. AttachTryCatchVisitor
   Input: ITry[] from DEX
   Output: CatchAttr attached to insns, ExceptionHandlers created

2. BlockExceptionHandler.process()
   Input: Method with instructions marked for try-catch
   Output: TryCatchBlockAttr list, outer/inner relationships

3. ProcessTryCatchRegions
   Input: TryCatchBlockAttr, Region tree
   Output: TryCatchRegion wrapping try/catch code

4. MarkFinallyVisitor
   Input: TryCatchBlockAttr with handlers
   Output: Finally code marked, duplicate code hidden

5. RegionGen (CodeGen)
   Input: TryCatchRegion with finally info
   Output: Java try/catch/finally source code
```

### Key Attributes Used

| Attribute | Purpose |
|-----------|---------|
| `AType.EXC_CATCH` | CatchAttr on instructions |
| `AType.EXC_HANDLER` | ExcHandlerAttr on handler entry |
| `AType.TRY_BLOCK` | TryCatchBlockAttr on try blocks |
| `AType.TRY_BLOCKS_LIST` | List of all try blocks on method |
| `AFlag.TRY_ENTER` / `TRY_LEAVE` | Try boundary marking |
| `AFlag.FINALLY_INSNS` | Instructions in finally block |
| `AFlag.DONT_GENERATE` | Duplicate finally code to hide |
| `AFlag.EXC_TOP_SPLITTER` | Synthetic top block |
| `AFlag.EXC_BOTTOM_SPLITTER` | Synthetic bottom block |

---

## Rust Implementation Recommendations

### Phase 1: Core Data Structures

```rust
pub struct ExceptionHandler {
    pub catch_types: Vec<ClassInfo>,
    pub handler_offset: u32,
    pub handler_block: Option<BlockNodeRef>,
    pub blocks: Vec<BlockNodeRef>,
    pub arg: Option<RegisterArg>,
    pub try_block: Option<TryCatchBlockRef>,
    pub is_finally: bool,
}

pub struct TryCatchBlockAttr {
    pub id: u32,
    pub handlers: Vec<ExceptionHandler>,
    pub blocks: Vec<BlockNodeRef>,
    pub outer_try_block: Option<TryCatchBlockRef>,
    pub inner_try_blocks: Vec<TryCatchBlockRef>,
    pub merged: bool,
    pub top_splitter: Option<BlockNodeRef>,
    pub bottom_splitter: Option<BlockNodeRef>,
}

pub struct InsnsSlice {
    pub insns_list: Vec<InsnNodeRef>,
    pub insn_map: HashMap<InsnNodeRef, BlockNodeRef>,
    pub complete: bool,
}

pub struct CatchAttr {
    pub handlers: Vec<ExceptionHandlerRef>,
}
```

### Phase 2: DEX Parsing (ITry/ICatch)

- Parse exception_ids section from DEX file
- Build offset -> instruction mapping
- Create ExceptionHandler for each handler offset

### Phase 3: Try-Catch Block Assembly

- Attach CatchAttr to instructions in try range
- Merge multi-catch handlers
- Build outer/inner relationships

### Phase 4: Finally Extraction

- Detect catch-all with re-throw pattern
- Pattern matching for instruction duplication
- SSA variable synchronization

### Phase 5: Code Generation

- Wrap with splitter blocks
- Generate try/catch/finally regions
- Handle synchronized blocks with implicit finally

---

## Key Algorithm: Finally Detection

```rust
fn extract_finally(try_block: &TryCatchBlockAttr) -> Option<FinallyExtractInfo> {
    // 1. Find catch-all handler
    let catch_all = try_block.handlers.iter()
        .find(|h| h.is_catch_all())?;

    // 2. Verify ends with throw
    let handler_blocks = &catch_all.blocks;
    let last_insn = handler_blocks.last()?.instructions.last()?;
    if last_insn.insn_type != InsnType::Throw {
        return None;
    }

    // 3. Collect finally code from handler
    let finally_insns = collect_finally_insns(handler_blocks);

    // 4. Search for duplicates in other paths
    let mut slices = Vec::new();
    for handler in &try_block.handlers {
        if handler.is_catch_all() { continue; }
        if let Some(slice) = find_duplicate_slice(handler, &finally_insns) {
            slices.push(slice);
        }
    }

    // 5. Validate all slices match
    if !validate_slices(&slices, &finally_insns) {
        return None;
    }

    Some(FinallyExtractInfo {
        finally_insns,
        duplicate_slices: slices,
    })
}
```

---

## Key Files Summary

| File | Lines | Purpose |
|------|-------|---------|
| `TryCatchBlockAttr.java` | ~150 | Try block container |
| `ExceptionHandler.java` | ~200 | Handler representation |
| `MarkFinallyVisitor.java` | ~400 | Finally detection |
| `BlockExceptionHandler.java` | 641 | CFG integration |
| `InsnsSlice.java` | ~100 | Instruction slice |
| `FinallyExtractInfo.java` | ~50 | Extraction metadata |
