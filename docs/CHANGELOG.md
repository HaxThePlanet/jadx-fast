# Changelog

## December 2025

### Dec 21, 2025 - Kotlin Function Modifiers

**Kotlin Modifier Support**
- Added IR fields: is_suspend, is_inline_function, is_infix, is_operator, receiver_type
- Extractor applies modifiers from Kotlin metadata to MethodData
- Method generator emits modifiers as Java comments: `/* suspend */ public void foo()`
- Files: `info.rs`, `extractor.rs`, `method_gen.rs`

### Dec 21, 2025 - All P1 Semantic Issues Fixed

**NEW-008: Malformed Synchronized Blocks**
- Check ACC_DECLARED_SYNCHRONIZED (0x20000) flag instead of sync instruction count
- File: `crates/dexterity-codegen/src/body_gen.rs`

**NEW-009: Missing Imports**
- Added import collection for ConstClass, InstanceGet/Put, InvokeCustom instructions
- File: `crates/dexterity-codegen/src/class_gen.rs`

**NEW-010: Boolean vs Null Comparisons**
- Added `name_suggests_boolean_method()` heuristic (is*, has*, can*, should*, etc.)
- File: `crates/dexterity-codegen/src/body_gen.rs`

**NEW-011: Parameter/Field Mismatch**
- Added fallback to SSA version 0 name for parameter registers
- File: `crates/dexterity-codegen/src/expr_gen.rs`

**NEW-012: Constructor Result Discarded**
- Assign constructor result to receiver register's variable when tracking fails
- File: `crates/dexterity-codegen/src/body_gen.rs`

### Dec 20, 2025 - Iterative Pass Execution (JADX Parity)

**Iterative Simplification + Code Shrinking**
- Added fixpoint loop for `simplify_instructions()` + `shrink_code()` passes
- Matches JADX's `traverseIterative()` behavior
- Iteration limit: `5 × block_count` (from JADX's `DepthRegionTraversal.java`)
- Enables nested ternary optimization and chained simplifications
- File: `crates/dexterity-cli/src/decompiler.rs:92-114`

### Dec 20, 2025 - All P0 Bugs Fixed

**NEW-006: Enum Value Extraction** - Fixed enum constants with wrong values
- Removed Int(0)/Int(1) to Bool conversion
- Changed to backwards search for register values
- Commits: `6c161be5c`, `c967197ad`

**NEW-004: Variable Type Confusion** - Fixed different object types sharing same variable name
- Changed `types_compatible_for_naming()` to require exact class match
- File: `var_naming.rs:255`

**NEW-002: Undefined Variables** - Fixed PHI variables declared without initializers
- Added constant initializer tracking for PHI nodes
- File: `body_gen.rs`

**NEW-003: throw non-Throwable** - Fixed throwing non-Throwable types
- Emit `throw null;` with warning for invalid throw arguments
- Commit: `6b023278e`

### Dec 19, 2025

- TernaryMod + IfRegionVisitor control flow improvements
- Kotlin type variance annotations
- Compose UI complexity detection
- Exception handler PHI declarations

### Dec 18, 2025

- Interface generic type parameters
- Undefined variable references
- Missing import statements
- Constructor generic types

### Dec 17, 2025

- Variable naming algorithm ported from JADX (edge cases remain)
- THP optimization (8.8% faster at 56 cores)
- Exception handling improvements
- Multi-catch support
- Enum constant name corruption fix

### Dec 16, 2025

- Variable naming (27,794 -> 0 arg0/arg1 instances)
- Class-level generic type parameters (736 classes)
- Undefined variables in If/Switch/Synchronized regions
- Double-dot class names fix
- Invalid Java identifiers fix
