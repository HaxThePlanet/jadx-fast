# Changelog

## December 2025

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
