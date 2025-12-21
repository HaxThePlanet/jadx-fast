# Changelog

## December 2025

### Dec 21, 2025 - DEX Debug Opcodes + Resource Qualifiers

**dexterity-dex: Debug Opcode Fix**
- Fixed DBG_SET_FILE (0x09) to properly read its uleb128 argument for JADX parity
- Previously skipped without consuming the argument, causing parse offset drift
- File: `crates/dexterity-dex/src/sections/code_item.rs`

**dexterity-resources: BCP-47 Locale Support**
- Implemented proper BCP-47 locale tag formatting (`b+language+script+region+variant`)
- Added support for `locale_variant` field (e.g., POSIX variants)
- Distinguishes between old-style (`pt-rBR`) and BCP-47 (`b+sr+Latn`) formats
- Added 5 new unit tests for qualifier handling:
  - `test_qualifier_string_old_style_locale`
  - `test_qualifier_string_bcp47_with_script`
  - `test_qualifier_string_bcp47_with_variant`
  - `test_qualifier_string_default`
  - `test_qualifier_string_with_density`
- File: `crates/dexterity-resources/src/arsc.rs`

### Dec 21, 2025 - Phase 1 + Phase 2 Complete

**Phase 2: Boolean Expression Simplification**
- Short-circuit OR condition merging: Combined nested if conditions into `a || b` patterns
- Added `collect_branch_blocks_with_barrier()` with barrier parameter to prevent cross-branch block inclusion
- OR type 2 detection: Detect when both conditions branch to same "true" target
- Fixed `MergedCondition::merge()` then/else block assignment for OR patterns
- Added `MergeMode` enum (And/Or/Single) for tracking merge type
- Files: `conditionals.rs`, `region_builder.rs`

**Phase 1: Static Field Inline Initialization**
- Added `NewInstance` variant to `FieldValue` enum in `info.rs`
- Extended `extract_field_init.rs` to detect `new-instance` + `invoke-direct <init>` + `sput-object` pattern
- Empty clinit suppression in `method_gen.rs`: Skip generating `static {}` blocks with only `return-void`
- Added `NewInstance` rendering in `class_gen.rs` for static field initializers
- Files: `info.rs`, `extract_field_init.rs`, `class_gen.rs`, `method_gen.rs`

### Dec 20, 2025 - Kotlin BitEncoding Port (100% Parity)

**BitEncoding Decoder Ported from Java**
- Implemented `bit_encoding_decode()` in Rust with two encoding modes:
  - UTF-8 mode (marker = '\0'): Each char is directly a byte (modern format)
  - 8-to-7 bit mode (marker = '\u0001'): Legacy 7-bit byte packing
- Added `jvm_metadata.proto` with `StringTableTypes` message for proper d2 string resolution
- Implemented 68 predefined Kotlin string lookups (kotlin/Any, kotlin/collections/*, kotlin/Function0-22, etc.)
- Kotlin metadata parsing now 100% functional
- Files: `parser.rs`, `proto/jvm_metadata.proto`

### Dec 21, 2025 - Kotlin Class and Function Modifiers

**Kotlin Modifier Support (JADX kotlin-metadata plugin parity)**
- **Class modifiers:** `/* data */`, `/* sealed */`, `/* value */` emitted after Java modifiers, before `class` keyword
  - Example: `public final /* data */ class User { ... }`
- **Function modifiers:** `/* operator */`, `/* suspend */`, `/* inline */`, `/* infix */`, `/* tailrec */` emitted before Java modifiers
  - Example: `/* suspend */ public Object fetchData(Continuation $completion) { ... }`
- Added IR fields: is_suspend, is_inline_function, is_infix, is_operator, is_tailrec, receiver_type
- Extractor applies modifiers from Kotlin metadata to MethodData
- **Type variance:** `<out R>`, `<in T>` preserved from Kotlin metadata
- **Class aliases:** Now correctly use simple names instead of full paths
- Files: `info.rs`, `extractor.rs`, `method_gen.rs`, `class_gen.rs`

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
