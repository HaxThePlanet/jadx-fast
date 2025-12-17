# Code Navigation Guide

Maps issue categories to relevant source files and provides context for code exploration.

See `LLM_AGENT_GUIDE.md` for workflow and `ISSUE_TRACKER.md` for issue details.

---

## Issue Category → Source Files

Navigate to the right files based on the issue you're working on.

### Category 1: Undefined Variables / Control Flow Issues

**Issues:** CRITICAL-001, CRITICAL-002, HIGH-004
**Root Problem:** Loop bounds, conditional scopes, or unreachable blocks not properly tracked

#### Primary Files

**File 1: `/mnt/nvme4tb/jadx-rust/crates/dexterity-passes/src/region_builder.rs`** (~2,094 lines)
- **Type:** Large - Use grep for specific functions
- **Key Functions:**
  - `build_regions()` (entry point) - Orchestrates region building
  - `build_loop_region()` - Handles loop detection and construction
  - `find_loop_merge()` - Detects loop exit point
  - `build_if_region()` - Conditional region handling
  - `build_switch_region()` - Switch region handling

**How to find functions:**
```bash
grep -n "fn build_loop_region" region_builder.rs
grep -n "fn find_loop_merge" region_builder.rs
grep -n "struct LoopInfo" region_builder.rs
```

**What to look for:**
- How loop variables are tracked through iterations
- How loop bounds (from/to) are resolved
- How conditionals create phi nodes
- How merge points are calculated
- Variable scope at each region boundary

**Key Data Structures:**
- `LoopInfo` - Loop metadata
- `Region` - Abstract control flow region
- `RegionState` - Region building context

---

**File 2: `/mnt/nvme4tb/jadx-rust/crates/dexterity-passes/src/cfg.rs`** (~831 lines)
- **Type:** Medium - Can search for specific functions
- **Key Functions:**
  - `build_cfg()` - Constructs control flow graph
  - `compute_successors()` - Calculates block successors (includes switch handling)
  - Build dominator tree
  - Calculate immediate dominators

**How to find functions:**
```bash
grep -n "fn build_cfg" cfg.rs
grep -n "fn compute_successors" cfg.rs
grep -n "DominatorTree" cfg.rs
```

**What to look for:**
- Switch instruction successor calculation (check PackedSwitch/SparseSwitch handling)
- Block predecessor/successor relationships
- Dominator tree structure
- Immediate dominator calculation

---

**File 3: `/mnt/nvme4tb/jadx-rust/crates/dexterity-passes/src/ssa.rs`** (~964 lines)
- **Type:** Large - Use grep for functions
- **Key Functions:**
  - `transform_to_ssa()` - Entry point for SSA transformation
  - Dominator tree computation
  - Dominance frontier calculation
  - Phi node insertion
  - Variable versioning and renaming

**How to find functions:**
```bash
grep -n "fn transform_to_ssa" ssa.rs
grep -n "fn insert_phi_nodes" ssa.rs
grep -n "struct PhiNode" ssa.rs
grep -n "fn rename_variables" ssa.rs
```

**What to look for:**
- How phi nodes are placed at join points
- How dominator frontier is calculated
- How SSA variables track through merge points
- How loop variables are versioned

---

#### Supporting Files

**File 4: `/mnt/nvme4tb/jadx-rust/crates/dexterity-passes/src/block_split.rs`**
- **Type:** Small
- **Purpose:** Splits instructions into basic blocks
- **Key Function:** `compute_successors()` - Determines block boundaries

---

### Category 2: Type Inference Issues

**Issues:** CRITICAL-003, CRITICAL-004, HIGH-002
**Root Problem:** Type constraints not properly propagated through control flow

#### Primary Files

**File 1: `/mnt/nvme4tb/jadx-rust/crates/dexterity-passes/src/type_inference.rs`** (~2,644 lines)
- **Type:** Very Large - Extensive grep usage required
- **Key Functions:**
  - `infer_types_with_context_and_hierarchy()` - Main type inference entry
  - `generate_constraints()` - Creates type constraints from bytecode
  - `solve_constraints()` - Solves constraint system
  - `resolve_phi_node_type()` - PHI node type merging
  - `compute_lca()` - Least common ancestor for type conflicts

**How to find functions:**
```bash
grep -n "fn infer_types_with_context_and_hierarchy" type_inference.rs
grep -n "fn generate_constraints" type_inference.rs
grep -n "fn solve_constraints" type_inference.rs
grep -n "enum Constraint" type_inference.rs
```

**What to look for:**
- Constraint types: `Equals`, `Same`, `Subtype`, `ArrayOf`, `Numeric`, `Integral`, `ObjectType`
- How constraints are generated from bytecode operations
- How constraint solver handles conflicts
- PHI node type resolution
- LCA (Least Common Ancestor) computation

**Key Data Structures:**
```rust
enum Constraint {
    Equals(TypeVar, ArgType),
    Same(TypeVar, TypeVar),
    Subtype(TypeVar, ArgType),
    ArrayOf(TypeVar, Box<Constraint>),
    Numeric(TypeVar),
    Integral(TypeVar),
    ObjectType(TypeVar),
    AssignBound(TypeVar, ArgType),  // What can be assigned TO
    UseBound(TypeVar, ArgType),      // What is used FROM
}

struct TypeBounds {
    upper_bound: Option<ArgType>,
    lower_bound: Option<ArgType>,
}
```

---

**File 2: `/mnt/nvme4tb/jadx-rust/crates/dexterity-ir/src/class_hierarchy.rs`** (~382 lines)
- **Type:** Medium
- **Key Functions:**
  - `common_supertype()` - LCA computation for class hierarchy
  - `is_subtype_of()` - Subtype checking
  - Build class hierarchy graph

**How to find functions:**
```bash
grep -n "fn common_supertype" class_hierarchy.rs
grep -n "fn is_subtype_of" class_hierarchy.rs
```

**What to look for:**
- How class hierarchy is represented
- LCA algorithm implementation
- Type comparison logic

---

**File 3: `/mnt/nvme4tb/jadx-rust/crates/dexterity-ir/src/types.rs`** (~669 lines)
- **Type:** Large
- **Key Functions:**
  - Type system definitions
  - Type comparison logic

**What to look for:**
- `ArgType` enum (primitive types, arrays, objects, generics)
- Type comparison operators
- Type variable (`TypeVar`) representation

---

#### Supporting Files

**File 4: `/mnt/nvme4tb/jadx-rust/crates/dexterity-codegen/src/body_gen.rs`** (~5,491 lines)
- **Type:** Very Large - Use grep for specific functions
- **Purpose:** Generates Java code from IR
- **Key:** How type information is used in code generation

**Where type mismatches appear:**
```bash
grep -n "return.*0" body_gen.rs      # Look for return statements
grep -n "return null" body_gen.rs
grep -n "default_value" body_gen.rs  # How defaults are chosen
```

---

### Category 3: Variable Naming Issues

**Issues:** HIGH-001, HIGH-002
**Root Problem:** Variable names are register-based (v2, v3) instead of meaningful

#### Primary Files

**File 1: `/mnt/nvme4tb/jadx-rust/crates/dexterity-passes/src/var_naming.rs`** (~1,480 lines)
- **Type:** Medium - Can search for specific functions
- **Key Functions:**
  - `assign_variable_names()` - Main naming entry
  - `score_candidate_name()` - Name quality scoring
  - `generate_name_candidates()` - Proposes names from context
  - `merge_codevar_groups()` - PHI node variable grouping

**How to find functions:**
```bash
grep -n "fn assign_variable_names" var_naming.rs
grep -n "fn score_candidate_name" var_naming.rs
grep -n "struct CodeVar" var_naming.rs
grep -n "struct NameCandidate" var_naming.rs
```

**What to look for:**
- How CodeVar groups track related SSA variables
- Name scoring logic
- How field access patterns inform names
- How type information influences naming
- Debug info integration

**Key Data Structures:**
```rust
struct CodeVar {
    ssa_vars: Vec<SSAVar>,  // SSA variables in this group (connected by PHI)
    best_name: Option<String>,
    score: f32,
}

struct NameCandidate {
    name: String,
    source: NameSource,  // Where name came from
    score: f32,
}

enum NameSource {
    DebugInfo,
    MethodPattern,      // getString() -> "string"
    FieldAccess,        // obj.buffer -> "buffer"
    CheckCast,          // (String)obj -> "str"
    TypeName,           // Type-based: "view", "token"
    Fallback,           // Register: "r0", "r1", "r2"
}
```

---

**File 2: `/mnt/nvme4tb/jadx-rust/crates/dexterity-codegen/src/expr_gen.rs`** (~1,379 lines)
- **Type:** Large
- **Purpose:** Expression code generation
- **Key:** Where variables are referenced in expressions

---

### Category 4: Code Generation Issues

**Issues:** CRITICAL-006, HIGH-003
**Root Problem:** Methods not generated or missing modifiers

#### Primary Files

**File 1: `/mnt/nvme4tb/jadx-rust/crates/dexterity-codegen/src/class_gen.rs`** (~1,539 lines)
- **Type:** Large
- **Key Functions:**
  - `generate_class()` - Class/interface/enum generation
  - `generate_methods()` - Method enumeration and generation
  - `generate_field()` - Field generation
  - `generate_modifiers()` - Access flag generation

**How to find functions:**
```bash
grep -n "fn generate_class" class_gen.rs
grep -n "fn generate_methods" class_gen.rs
grep -n "fn generate_modifiers" class_gen.rs
grep -n "static" class_gen.rs | grep "fn\|let"  # Look for static handling
```

**What to look for:**
- How methods are skipped or omitted
- How modifiers are determined (static, final, etc.)
- Inner class handling
- Where methods go missing

---

**File 2: `/mnt/nvme4tb/jadx-rust/crates/dexterity-codegen/src/body_gen.rs`** (~5,491 lines)
- **Type:** Very Large
- **Purpose:** Method body generation
- **Key Functions:**
  - `generate_method_body()` - Generates statement blocks
  - Error handling for method generation

**What to look for:**
- Where methods fail to generate bodies
- Exception handling in method generation
- Early returns that skip code generation

---

**File 3: `/mnt/nvme4tb/jadx-rust/crates/dexterity-ir/src/nodes.rs`**
- **Type:** Medium
- **Purpose:** IR node definitions
- **Key Structures:**
  - `MethodNode` - Method metadata
  - `ClassNode` - Class metadata with flags
  - `AccessFlags` - Modifier information

---

---

## How to Search Efficiently

### Grep Patterns

Find function definitions:
```bash
grep -n "^pub fn function_name\|^fn function_name" file.rs
```

Find struct/enum definitions:
```bash
grep -n "^pub struct\|^pub enum" file.rs
```

Find specific patterns:
```bash
grep -n "undefined\|i2\|i2)" region_builder.rs
grep -n "return 0\|return 0;" body_gen.rs
grep -n "static " class_gen.rs
```

Find all references to a function:
```bash
grep -n "function_name(" file.rs
```

---

## Understanding File Organization

### By Size

| Size | Strategy | Examples |
|------|----------|----------|
| <500 lines | Read entire file | `block_split.rs`, `class_hierarchy.rs` |
| 500-1700 lines | Search for functions, read specific functions | `cfg.rs` (831), `ssa.rs` (964), `var_naming.rs` (1,480), `class_gen.rs` (1,539), `expr_gen.rs` (1,379), `conditionals.rs` (740), `simplify.rs` (1,646) |
| 1700-5500 lines | Grep for functions, read relevant sections | `type_inference.rs` (2,644), `region_builder.rs` (2,094), `body_gen.rs` (5,491) |

### File Dependency Chain

```
IR Building:
  dexterity-dex → dexterity-ir → dexterity-passes → dexterity-codegen

Detailed:
  reader.rs → builder.rs → {cfg.rs, ssa.rs, type_inference.rs, region_builder.rs} → {body_gen.rs, class_gen.rs}
```

---

## Navigation Workflow by Issue Type

### For CRITICAL-001 (Undefined loop bounds `i2`)

1. **Start:** `LLM_AGENT_GUIDE.md` → `ISSUE_TRACKER.md` → This file
2. **Understand:** `ALGORITHM_REFERENCES.md` → "SSA Transformation" + "Region Building"
3. **Navigate:**
   - `region_builder.rs::build_loop_region()` - See loop region construction
   - `region_builder.rs::find_loop_merge()` - See merge point detection
   - `ssa.rs` - Understand SSA variable tracking
4. **Reference:** `jadx-fast/jadx-core/src/main/java/jadx/core/dex/visitors/regions/RegionMaker.java`
5. **Test:** Write test for loop bounds in `loops_tests.rs`
6. **Implement:** Fix in `region_builder.rs` or `ssa.rs`

### For CRITICAL-003 (Type mismatch `return 0;` for object)

1. **Navigate:**
   - `type_inference.rs::infer_types_with_context_and_hierarchy()` - See type solving
   - `class_hierarchy.rs::common_supertype()` - See LCA computation
   - `body_gen.rs` - See where return statements are generated
2. **Reference:** `jadx-fast/jadx-core/src/main/java/jadx/core/dex/visitors/typeinference/TypeInferenceVisitor.java`
3. **Test:** Write test for return type checking
4. **Implement:** Fix type constraint generation or resolution

### For HIGH-001 (Register-based variable names `v2`, `v3`)

1. **Navigate:**
   - `var_naming.rs::assign_variable_names()` - See naming entry
   - `var_naming.rs::score_candidate_name()` - See name scoring
2. **Reference:** `jadx-fast/jadx-core/src/main/java/jadx/core/dex/visitors/ReSugarCode.java`
3. **Test:** Write test for variable name quality
4. **Implement:** Improve scoring or CodeVar grouping

---

## Quick Reference: File Locations by Component

### IR Building
- DEX parsing: `crates/dexterity-dex/src/reader.rs`
- IR construction: `crates/dexterity-ir/src/builder.rs`

### Analysis Passes
- SSA: `crates/dexterity-passes/src/ssa.rs`
- CFG: `crates/dexterity-passes/src/cfg.rs`
- Type inference: `crates/dexterity-passes/src/type_inference.rs`
- Region building: `crates/dexterity-passes/src/region_builder.rs`
- Variable naming: `crates/dexterity-passes/src/var_naming.rs`
- Conditionals: `crates/dexterity-passes/src/conditionals.rs`

### Code Generation
- Class generation: `crates/dexterity-codegen/src/class_gen.rs`
- Method generation: `crates/dexterity-codegen/src/method_gen.rs`
- Body generation: `crates/dexterity-codegen/src/body_gen.rs`
- Expression generation: `crates/dexterity-codegen/src/expr_gen.rs`
- Type generation: `crates/dexterity-codegen/src/type_gen.rs`

### Tests
- Integration tests: `crates/dexterity-cli/tests/integration/`
- Loop tests: `crates/dexterity-cli/tests/integration/loops_tests.rs`
- SSA tests: `crates/dexterity-cli/tests/integration/ssa_tests.rs`
- Type tests: `crates/dexterity-cli/tests/integration/type_tests.rs`

---

## Common Grep Commands

```bash
# Find where a variable is used
cd /mnt/nvme4tb/jadx-rust/crates/dexterity-passes/src
grep -n "loop_bounds\|loop_counter" *.rs

# Find all references to a function
grep -rn "build_loop_region(" .

# Find struct definitions
grep -n "struct.*Info\|enum.*Region" *.rs

# Find TODOs or FIXMEs related to loops
grep -n "TODO.*loop\|FIXME.*loop" *.rs

# Count lines in a file
wc -l region_builder.rs

# Find function signatures
grep -n "^pub fn\|^fn" region_builder.rs | head -20
```

---

## Next Steps

1. **Pick an issue** from `ISSUE_TRACKER.md`
2. **Read algorithm** from `ALGORITHM_REFERENCES.md`
3. **Find code** using this guide
4. **Implement fix** following patterns
5. **Test thoroughly**
6. **Update** `ISSUE_TRACKER.md` and `PROGRESS.md`

---

## JADX Codegen Source Reference

For implementing JADX parity features, here's the key JADX source file map:

### JADX Codegen Files (`jadx-fast/jadx-core/src/main/java/jadx/core/codegen/`)

| File | Lines | Purpose | Key Methods |
|------|-------|---------|-------------|
| `CodeGen.java` | ~200 | Entry point | `generate()`, `wrapCodeGen()` |
| `ClassGen.java` | ~900 | Class structure | `makeClass()`, `addImports()`, `useType()` |
| `MethodGen.java` | ~500 | Method signatures | `addDefinition()`, `addParams()` |
| `InsnGen.java` | ~1200 | Expression/statement | `makeInsnBody()`, `makeInvoke()`, `makeInvokeLambda()` |
| `RegionGen.java` | ~400 | Control flow | `makeIf()`, `makeLoop()`, `makeSwitch()`, `makeTryCatch()` |
| `ConditionGen.java` | ~200 | Boolean conditions | `addCompare()`, `addTernary()`, `addAndOr()` |
| `TypeGen.java` | ~300 | Type formatting | `literalToString()`, `formatDouble()` |
| `AnnotationGen.java` | ~200 | Annotations | `formatAnnotation()` |
| `NameGen.java` | ~400 | Variable naming | `assignArg()`, `getUniqueVarName()` |

### JADX IR Types (`jadx-fast/jadx-core/src/main/java/jadx/core/dex/`)

| File | Purpose | Key Classes |
|------|---------|-------------|
| `instructions/InsnType.java` | Instruction enum | All 40+ instruction types |
| `instructions/mods/TernaryInsn.java` | Ternary expression IR | `TernaryInsn` |
| `instructions/InvokeCustomNode.java` | Lambda invoke | `InvokeCustomNode` |
| `regions/conditions/IfCondition.java` | Condition tree | `IfCondition`, `Mode` enum |
| `regions/conditions/Compare.java` | Comparison | `Compare`, `IfOp` |
| `regions/loops/LoopRegion.java` | Loop structure | `LoopRegion`, `LoopType` |
| `regions/loops/ForLoop.java` | For loop info | `ForLoop` |
| `regions/loops/ForEachLoop.java` | For-each info | `ForEachLoop` |

### Key Search Commands

```bash
# Find lambda handling in JADX
grep -n "makeInvokeLambda\|makeRefLambda" jadx-fast/jadx-core/src/main/java/jadx/core/codegen/InsnGen.java

# Find ternary handling
grep -n "TERNARY\|TernaryInsn" jadx-fast/jadx-core/src/main/java/jadx/core/codegen/*.java

# Find condition simplification
grep -n "simplify\|invert" jadx-fast/jadx-core/src/main/java/jadx/core/dex/regions/conditions/IfCondition.java

# Find InsnWrapArg usage (inline expressions)
grep -n "InsnWrapArg\|isInsnWrap" jadx-fast/jadx-core/src/main/java/jadx/core/codegen/InsnGen.java

# Find attribute system
grep -n "AFlag\|AType\|contains\|get(" jadx-fast/jadx-core/src/main/java/jadx/core/codegen/RegionGen.java
```

### Dexterity ↔ JADX File Mapping

| Dexterity | JADX | Notes |
|-----------|------|-------|
| `body_gen.rs` | `InsnGen.java` + `RegionGen.java` | Combined |
| `expr_gen.rs` | `InsnGen.java` (expression part) | Expression gen only |
| `stmt_gen.rs` | `RegionGen.java` | Statement templates |
| `class_gen.rs` | `ClassGen.java` | Direct equivalent |
| `method_gen.rs` | `MethodGen.java` | Direct equivalent |
| `type_gen.rs` | `TypeGen.java` | Direct equivalent |
| `regions.rs` | `IfCondition.java` + Regions | Condition + region types |

---

**Last Updated: 2025-12-17**
**For algorithm context, see: `ALGORITHM_REFERENCES.md`**
**For codegen parity, see: `JADX_CODEGEN_REFERENCE.md` Part 4**
**For issues, see: `ISSUE_TRACKER.md`**
