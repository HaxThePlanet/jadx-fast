# Algorithm References: Understanding Dexterity Decompilation

High-level algorithm overviews to help autonomous agents understand how decompilation works.

See `CODE_NAVIGATION.md` for file locations and `ISSUE_TRACKER.md` for specific problems.

---

## Algorithm 1: SSA Transformation (Static Single Assignment)

### Overview

Converts Dalvik bytecode (where variables can be assigned multiple times) into SSA form where each variable is assigned exactly once. This enables powerful analysis algorithms downstream.

Example:
```java
// Before (non-SSA - x assigned twice):
x = 5;
if (condition) {
    x = 10;
}
print(x);  // Which x? (5 or 10?)

// After (SSA - each assignment is unique):
x_1 = 5;
if (condition) {
    x_2 = 10;
} else {
    x_3 = x_1;  // Implicit else assignment
}
x_4 = phi(x_2, x_3);  // At merge: x_4 is 10 or 5
print(x_4);
```

### Key Concepts

**1. Phi Nodes** - Represent variable joining at control flow merge points
   - Where multiple control flows join, phi node selects the right version
   - Example: `x_4 = phi(x_2, x_3)` means "x_4 is x_2 from true branch, x_3 from false branch"

**2. Dominance Analysis** - What blocks execute before others
   - Block A dominates block B if all paths to B go through A
   - Dominator tree shows control flow hierarchy
   - Dominance frontier: Where variables meet different definitions

**3. Phi Placement** - Where to insert phi nodes
   - Insert phi nodes at dominance frontiers
   - Each assignment creates a "live range" through the code
   - Phi nodes mark where live ranges meet

**4. Variable Versioning** - Renaming variables with version numbers
   - `x` becomes `x_1`, `x_2`, `x_3` etc.
   - Each version has single assignment point
   - Later passes can reason about each version independently

### Dexterity Implementation

**File:** `crates/dexterity-passes/src/ssa.rs` (~964 lines)

**Entry Point:** `transform_to_ssa(method: &mut MethodNode)`

**Key Functions:**
```rust
fn transform_to_ssa(method: &mut MethodNode) {
    // 1. Build CFG (control flow graph)
    let cfg = build_cfg(&method.blocks);

    // 2. Compute dominator tree (Cooper-Harvey-Kennedy algorithm)
    let dominators = compute_dominators(&cfg);

    // 3. Calculate dominance frontier for each block
    let dom_frontier = calculate_dominance_frontier(&cfg, &dominators);

    // 4. Insert phi nodes at dominance frontiers
    insert_phi_nodes(&mut method.blocks, &dom_frontier, &assignments);

    // 5. Rename variables with version numbers
    rename_variables(&mut method.blocks, &ssa_cfg);
}
```

**Data Structures:**
```rust
struct DominatorTree {
    idom: HashMap<BlockId, BlockId>,      // Immediate dominator for each block
    dominators: HashMap<BlockId, BitSet>, // All dominators for each block
}

struct PhiNode {
    var: SSAVar,
    sources: Vec<(BlockId, SSAVar)>,  // Which var comes from which predecessor
}
```

### JADX Reference

**File:** `jadx-fast/jadx-core/src/main/java/jadx/core/dex/visitors/ssa/SSATransform.java`

**Key Method:** `SSATransform.process()`

**Comparison to Dexterity:**
- JADX: Iterative phi node insertion until fixed point
- Dexterity: Single-pass phi insertion using dominance frontier
- Both use similar dominator tree algorithms

### Common Issues

**Problem:** Undefined variables in generated code
- Often stems from incorrect phi node placement
- Variable defined in one block but used in another without phi node
- Example: `while (i < i2)` where `i2` not properly tracked through loop

**Solution Strategy:**
1. Verify phi nodes placed at all join points
2. Check dominator tree is correct
3. Ensure all variable uses have preceding phi node or definition
4. Trace through example code by hand to find missing phi node

---

## Algorithm 2: Type Inference

### Overview

Infers Java types from untyped Dalvik bytecode. Dalvik bytecode doesn't have type information, just register operations. Type inference uses constraints from operations to deduce types.

Example:
```java
// Dalvik (no types):
v0 = new-instance String
v1 = check-cast v0 String  // Constraint: v0 is String

// Java inference result:
String v0 = new String(...);
String v1 = (String) v0;
```

### Key Concepts

**1. Constraint Generation** - Extract type requirements from bytecode
   - Literal assignments: `const v0, 5` → v0 is int
   - Method calls: `invoke-virtual v0, String.length()` → v0 is String
   - Array operations: `aget v0, v1` → v0 is element type of v1
   - Type constraints: `check-cast v0, String` → v0 is String

**2. Constraint Solving** - Find type assignments satisfying all constraints
   - Bounds system: Upper/lower bounds on types
   - Conflict resolution: When two constraints conflict (String vs int), find common type
   - Iterative refinement: Apply constraints repeatedly until fixed point

**3. Bounds System** - JADX-style type bounds
   - AssignBound: What type can be assigned TO this variable
   - UseBound: What type is this variable used FROM
   - Examples:
     - `x = "hello"` → UseBound: String (value is String)
     - `String x = y` → AssignBound: String (x must be assignable to String)

**4. PHI Node Type Merging** - Resolving conflicting types at joins
   - At phi nodes, variable might come from different types
   - Example: `x = phi(String x, Integer x)` → Find common type
   - Solution: Compute LCA (Least Common Ancestor) in class hierarchy

### Dexterity Implementation

**File:** `crates/dexterity-passes/src/type_inference.rs` (~1,958 lines)

**Entry Point:** `infer_types_with_context_and_hierarchy()`

**Key Functions:**
```rust
fn infer_types_with_context_and_hierarchy() {
    // 1. Generate constraints from bytecode operations
    let mut constraints = Vec::new();
    for (var, instr) in method_instructions {
        generate_constraints(&instr, &mut constraints);
    }

    // 2. Solve constraint system iteratively
    solve_constraints(&mut constraints, &class_hierarchy);

    // 3. Handle phi nodes - merge conflicting types via LCA
    for phi_node in method.phi_nodes {
        resolve_phi_node_type(phi_node, &class_hierarchy);
    }

    // 4. Apply bounds refinements
    apply_bounds_refinement(&mut var_types);
}
```

**Constraint Types:**
```rust
enum Constraint {
    Equals(TypeVar, ArgType),              // v = <type>
    Same(TypeVar, TypeVar),                // v1 and v2 are same type
    Subtype(TypeVar, ArgType),             // v must be subtype of <type>
    ArrayOf(TypeVar, Box<Constraint>),    // v is array of <element constraint>
    Numeric(TypeVar),                      // v must be numeric (int/long/float/double)
    Integral(TypeVar),                     // v must be integral (int/long)
    ObjectType(TypeVar),                   // v must be object (not primitive)
    AssignBound(TypeVar, ArgType),         // What can be assigned TO v
    UseBound(TypeVar, ArgType),            // What v is used FROM
}
```

**LCA (Least Common Ancestor) Example:**
```
Class Hierarchy:       java/lang/Object
                            |
                    --------+--------
                   |                |
            java/lang/String   java/lang/Integer
                   |                |
              "Hello"           42

Inference: v = phi("hello", 42)
Types: String vs Integer
LCA: java/lang/Object (common ancestor)
Result: Object v = phi("hello", 42)
```

### JADX Reference

**Files:**
- Type inference: `jadx-fast/jadx-core/src/main/java/jadx/core/dex/visitors/typeinference/TypeInferenceVisitor.java`
- Type comparison: `jadx-fast/jadx-core/src/main/java/jadx/core/dex/tinfo/TypeCompare.java`
- Bounds: Look for `TypeBounds` or similar

**Key Methods:**
- Type constraint generation from operations
- Bounds-based solving
- PHI node type merging

### Common Issues

**Problem:** Type mismatches in generated code
- `String v6 == 0` (comparing String to int)
- `return 0;` for object types (should be `null`)

**Solution Strategy:**
1. Verify constraints generated for all bytecode operations
2. Check constraint solver handles all constraint types
3. Verify bounds system properly tracks upper/lower bounds
4. Check phi node type merging uses LCA
5. Trace through problematic instruction by hand

---

## Algorithm 3: Region Building (Control Flow Reconstruction)

### Overview

Converts flat control flow graph (all jumps and branches) into structured control flow (if/else, loops, switch, try/catch). This makes generated code readable and proper Java.

Example:
```java
// Flat CFG (GOTO-based):
B1: if (x < 10) goto B3
B2: y = 0; goto B4
B3: y = 1; goto B4
B4: print(y); return

// Structured (Region-based):
if (x < 10) {
    y = 1;
} else {
    y = 0;
}
print(y);
return;
```

### Key Concepts

**1. Region Types** - Different control flow structures
   - SequenceRegion: List of statements
   - IfRegion: Conditional with true/false branches
   - LoopRegion: Loops (while, for, do-while)
   - SwitchRegion: Switch statement
   - TryRegion: Try-catch-finally

**2. Loop Detection** - Identifying loops from CFG
   - Back edge: Edge that jumps backward to earlier block
   - Loop detection: Find blocks reachable from back edge target
   - Loop types: While, For, Do-while determined by merge point

**3. Switch Detection** - Extracting switch statements
   - Packed/Sparse switch instructions indicate switch
   - Find merge point where all cases rejoin
   - Extract case blocks between switch and merge

**4. Post-Dominator Analysis** - Finding merge points
   - Post-dominator: Block that must execute after another
   - Immediate post-dominator: First block after control flow merges
   - Used to find where loops end, switches merge, if/else converge

### Dexterity Implementation

**File:** `crates/dexterity-passes/src/region_builder.rs` (~1,903 lines)

**Entry Point:** `build_regions(method: &mut MethodNode)`

**Key Functions:**
```rust
fn build_regions(method: &mut MethodNode) -> Region {
    // 1. Start with entry block
    let mut region_stack = vec![entry_block];

    while let Some(block) = region_stack.pop() {
        // 2. Check what kind of region to build
        if is_loop_header(block) {
            let loop_region = build_loop_region(block);
            region_stack.push(loop_region.exit_block);
        } else if is_switch(block) {
            let switch_region = build_switch_region(block);
            region_stack.push(switch_region.merge_block);
        } else if has_conditional(block) {
            let if_region = build_if_region(block);
            region_stack.push(if_region.merge_block);
        } else {
            region_stack.push(next_block);
        }
    }
}

fn build_loop_region(header: &Block) {
    // 1. Find loop body blocks (reachable from header, loop back to header)
    let body_blocks = collect_loop_blocks(header);

    // 2. Find loop merge point (immediate post-dominator of back edge)
    let merge_point = find_loop_merge(header, &body_blocks);

    // 3. Build loop region with exit condition
    LoopRegion {
        header: header,
        body: body_blocks,
        exit: merge_point,
    }
}

fn build_switch_region(switch_block: &Block) {
    // 1. Get switch targets from PackedSwitch/SparseSwitch
    let cases = extract_switch_cases(switch_block);

    // 2. Find merge point via dominance frontier
    let merge_point = find_switch_merge(switch_block, &cases);

    // 3. Collect blocks for each case
    let case_regions = cases.iter()
        .map(|case_target| collect_case_blocks(case_target, &merge_point));

    SwitchRegion {
        cases: case_regions,
        default: collect_case_blocks(default_target, &merge_point),
        merge: merge_point,
    }
}
```

**Data Structures:**
```rust
enum Region {
    Sequence(Vec<Region>),
    If { condition, true_region, false_region, merge_block },
    Loop { header, body, exit },
    Switch { cases, default, merge_block },
    Try { try_region, catches, finally_region },
}

struct LoopInfo {
    header: BlockId,
    body_blocks: HashSet<BlockId>,
    back_edges: Vec<(BlockId, BlockId)>,
    exit_block: BlockId,
}
```

### JADX Reference

**File:** `jadx-fast/jadx-core/src/main/java/jadx/core/dex/visitors/regions/RegionMaker.java`

**Key Methods:**
- Loop detection and region building
- Switch merge point detection
- Post-dominator analysis
- If/else region construction

### Common Issues

**Problem:** Undefined loop variables
- Loop bounds variable not properly tracked
- `while (i < i2)` where `i2` is undefined

**Solution Strategy:**
1. Verify loop body blocks are correctly identified
2. Check loop merge point detection (should use post-dominators)
3. Verify variables used in loop condition are in scope
4. Check SSA phi nodes properly connect loop variables
5. Trace through loop boundaries by hand

**Problem:** Empty switch bodies
- Switch merge point incorrect
- Case blocks not properly collected

**Solution Strategy:**
1. Verify switch targets extracted correctly
2. Check merge point uses post-dominator or dominance frontier
3. Verify case blocks collected with BFS/DFS to merge point
4. Check default case handled correctly
5. Test with multi-case switches and complex merges

---

## Algorithm 4: Variable Naming

### Overview

Assigns meaningful names to variables based on context, type, and usage patterns. Transforms SSA names (`v1`, `v2`) into readable names (`buffer`, `token`, `context`).

Example:
```java
// Before (SSA):
v0 = this.field
v1 = check-cast v0 String
v2 = invoke v1 length()

// After (Meaningful):
buffer = this.field
str = (String) buffer
len = str.length()
```

### Key Concepts

**1. CodeVar Groups** - SSA variables connected by PHI nodes
   - All SSA versions of same variable grouped together
   - Example: `x_1`, `x_2`, `x_3` from phi nodes → all in one CodeVar group
   - Group gets single meaningful name

**2. Name Scoring** - Ranking name candidates by quality
   - Priority: DebugInfo > FieldAccess > CheckCast > MethodPattern > Type > Fallback
   - Each source proposes name with score
   - Best scoring name selected for entire CodeVar group

**3. Name Sources:**
   - **DebugInfo:** From DEX debug bytecode (most reliable)
   - **FieldAccess:** `obj.buffer` → name "buffer"
   - **CheckCast:** `(String)obj` → name "str"
   - **MethodPattern:** `getString()` → name "string"
   - **Type:** From inferred type (String→"str", View→"view")
   - **Array Type:** `byte[]` → "bArr", `String[]` → "strArr"
   - **Fallback:** Register-based ("r0", "r1", "r2")

**4. Reserved Word Handling**
   - Avoid Java keywords (if, while, class, etc.)
   - Rename conflicts (two variables with same name)

### Dexterity Implementation

**File:** `crates/dexterity-passes/src/var_naming.rs` (~1,157 lines)

**Entry Point:** `assign_variable_names(method: &mut MethodNode)`

**Key Functions:**
```rust
fn assign_variable_names(method: &mut MethodNode) {
    // 1. Group SSA variables by phi node connections
    let codevar_groups = group_by_phi_nodes(&method.ssa_vars);

    // 2. For each group, generate name candidates
    for group in codevar_groups {
        let candidates = generate_candidates(&group, &method);

        // 3. Score candidates
        for candidate in &mut candidates {
            candidate.score = score_candidate_name(&candidate, &method);
        }

        // 4. Select best name
        let best = candidates.max_by_key(|c| c.score);
        group.name = best.name;
    }
}

fn generate_candidates(group: &CodeVarGroup, method: &MethodNode) -> Vec<NameCandidate> {
    let mut candidates = Vec::new();

    // Check debug info
    if let Some(debug_name) = group.debug_name {
        candidates.push(NameCandidate {
            name: debug_name,
            source: DebugInfo,
            score: 1000.0,
        });
    }

    // Check field accesses
    for var in &group.ssa_vars {
        if let Some(field_name) = extract_field_name(var) {
            candidates.push(NameCandidate {
                name: field_name,
                source: FieldAccess,
                score: 500.0,
            });
        }
    }

    // Check type
    if let Some(type_name) = type_to_name(&group.type) {
        candidates.push(NameCandidate {
            name: type_name,
            source: TypeBased,
            score: 100.0,
        });
    }

    // Fallback
    candidates.push(NameCandidate {
        name: format!("r{}", group.index),
        source: Fallback,
        score: 1.0,
    });

    candidates
}

fn score_candidate_name(candidate: &NameCandidate, method: &MethodNode) -> f32 {
    let mut score = match candidate.source {
        DebugInfo => 1000.0,
        FieldAccess => 500.0,
        CheckCast => 400.0,
        MethodPattern => 300.0,
        TypeBased => 100.0,
        Fallback => 1.0,
    };

    // Adjust for conflicts
    if has_conflict(&candidate.name, method) {
        score *= 0.5;
    }

    score
}
```

**Data Structures:**
```rust
struct CodeVar {
    ssa_vars: Vec<SSAVar>,
    name: String,
    type: ArgType,
    debug_info: Option<String>,
}

struct NameCandidate {
    name: String,
    source: NameSource,
    score: f32,
}

enum NameSource {
    DebugInfo,
    FieldAccess,
    CheckCast,
    MethodPattern,
    TypeBased,
    Fallback,
}
```

### JADX Reference

**Files:**
- Main: `jadx-fast/jadx-core/src/main/java/jadx/core/dex/visitors/ReSugarCode.java`
- SSAVar: `jadx-fast/jadx-core/src/main/java/jadx/core/dex/instructions/args/SSAVar.java`

**Key Concepts:**
- CodeVar grouping via SSA
- Multi-source naming (debug info, type, pattern)
- Name scoring and selection

### Common Issues

**Problem:** Register-based names (v2, v3, v6) in output
- CodeVar grouping not working
- Scoring system failing
- No good candidates from context

**Solution Strategy:**
1. Verify phi nodes properly connect related SSA vars
2. Check CodeVar grouping combines all related vars
3. Verify scoring function works correctly
4. Check debug info is being used when available
5. Consider adding more name sources (field access, method patterns)

---

## Algorithm 5: Control Flow Graph (CFG) Construction

### Overview

Builds graph representation of method control flow. Each basic block is node, control flow edges show possible paths. Foundation for SSA, region building, and type inference.

### Key Concepts

**1. Basic Blocks** - Maximal sequences of consecutive instructions with no jumps
   - Entry: First instruction (target point for other blocks)
   - Exit: Instruction that can branch (conditional, return, throw, etc.)
   - Middle: All other instructions

**2. Successors/Predecessors** - Control flow relationships
   - Successor: Block that can execute after this one
   - Predecessor: Block that can execute before this one
   - Example: `if` block has two successors (true/false branches)

**3. Dominator Relationships** - Control flow hierarchy
   - Block A dominates B if all paths to B go through A
   - Immediate dominator (idom): First dominator in path
   - Dominator tree: Tree representation of domination

**4. Post-Dominator** - Reverse domination
   - Block A post-dominates B if all paths from B go through A
   - Used for finding where control flow merges

### Dexterity Implementation

**File:** `crates/dexterity-passes/src/cfg.rs` (~710 lines)

**Entry Point:** `build_cfg(blocks: &Vec<Block>) -> CFG`

**Key Functions:**
```rust
fn build_cfg(blocks: &Vec<Block>) -> CFG {
    // 1. Identify basic block boundaries
    let basic_blocks = split_into_basic_blocks(blocks);

    // 2. Calculate successors for each block
    for block in &basic_blocks {
        block.successors = compute_successors(block, &basic_blocks);
        block.predecessors = compute_predecessors(block, &basic_blocks);
    }

    // 3. Compute dominator tree (Cooper-Harvey-Kennedy)
    let dom_tree = compute_dominator_tree(&basic_blocks);

    // 4. Compute post-dominator tree (reverse CFG)
    let post_dom_tree = compute_post_dominator_tree(&basic_blocks);

    CFG {
        blocks: basic_blocks,
        entry: entry_block,
        exit: exit_block,
        dominators: dom_tree,
        post_dominators: post_dom_tree,
    }
}

fn compute_successors(block: &Block, all_blocks: &Vec<Block>) -> Vec<BlockId> {
    let last_instr = &block.instructions.last();

    match last_instr.opcode {
        Opcode::If => {
            // Two successors: true target and fallthrough
            vec![get_target(instr), next_block(block)]
        },
        Opcode::PackedSwitch | Opcode::SparseSwitch => {
            // Successors: all case targets + default (fallthrough)
            let mut successors = extract_switch_targets(instr);
            successors.push(next_block(block));
            successors
        },
        Opcode::Return | Opcode::Throw => {
            // No successors (method exits)
            vec![]
        },
        _ => {
            // Normal fallthrough to next block
            vec![next_block(block)]
        }
    }
}
```

**Data Structures:**
```rust
struct CFG {
    blocks: Vec<Block>,
    entry: BlockId,
    exit: Option<BlockId>,
    successors: HashMap<BlockId, Vec<BlockId>>,
    predecessors: HashMap<BlockId, Vec<BlockId>>,
}

struct DominatorTree {
    idom: HashMap<BlockId, BlockId>,           // Immediate dominator
    dominators: HashMap<BlockId, HashSet<BlockId>>, // All dominators
}
```

### JADX Reference

**File:** `jadx-fast/jadx-core/src/main/java/jadx/core/dex/visitors/blocksmaker/BlockProcessor.java`

**Key Methods:**
- Block identification from instructions
- Successor calculation
- Dominator tree computation

### Common Issues

**Problem:** Switch successors not properly calculated
- PackedSwitch/SparseSwitch not handled
- Default (fallthrough) case missing

**Solution Strategy:**
1. Verify all switch target types are handled
2. Check fallthrough block is always added as successor
3. Verify successor calculation for all instruction types
4. Test switch statements with multiple cases

---

## Quick Algorithm Reference

| Algorithm | Purpose | Key File | When Issues | Impact |
|-----------|---------|----------|-------------|--------|
| SSA Transform | Assign unique variable versions | `ssa.rs` | Undefined variables | Code won't compile |
| Type Inference | Infer Java types | `type_inference.rs` | Type mismatches | Type errors |
| Region Building | Reconstruct loops/switches | `region_builder.rs` | Empty switch bodies | Code structure wrong |
| Variable Naming | Assign meaningful names | `var_naming.rs` | Register names (v2,v3) | Low readability |
| CFG Construction | Build control flow graph | `cfg.rs` | Foundation for other passes | Many downstream issues |

---

**Last Updated: 2025-12-16**
**For file locations, see: `CODE_NAVIGATION.md`**
**For specific issues, see: `ISSUE_TRACKER.md`**
