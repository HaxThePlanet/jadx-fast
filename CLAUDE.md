# CLAUDE.md

This file provides guidance to Claude Code (claude.ai/code) when working with code in this repository.

## Project Overview

**Dexterity** is a high-performance Android DEX/APK decompiler written in Rust, inspired by [JADX](https://github.com/skylot/jadx). The goal is 1:1 output compatibility with Java JADX while achieving 2-4x faster performance through zero-copy parsing, arena allocation, and native parallelism.

**Current status**: ~69,700 lines of Rust, 227 tests (222 passing), full decompilation pipeline functional.

## Build Commands

```bash
# Build (from crates/ directory)
cd crates && cargo build --release -p jadx-cli

# Run
./target/release/dexterity -d output/ app.apk

# Run all tests
cd crates && cargo test

# Run single test
cd crates && cargo test test_name

# Run tests for specific crate
cd crates && cargo test -p jadx-codegen

# Check without building
cd crates && cargo check
```

## Architecture

### Decompilation Pipeline

```
DEX bytes → jadx-dex (parsing) → jadx-ir (IR) → jadx-passes (analysis) → jadx-codegen (Java source)
```

### Crate Structure

| Crate | Purpose |
|-------|---------|
| `jadx-dex` | DEX file parsing (header, strings, types, classes, methods, all 256 opcodes) |
| `jadx-ir` | Intermediate representation (InsnNode, InsnType, ClassData, MethodData, regions) |
| `jadx-passes` | Analysis passes (block split, CFG, dominators, SSA, type inference, loops, regions) |
| `jadx-codegen` | Java source generation (class/method/field/expr/stmt) |
| `jadx-resources` | Android resource decoding (AXML, resources.arsc) |
| `jadx-cli` | CLI application with JADX-compatible options |
| `jadx-deobf` | Deobfuscation (name validation, conditions, alias generation, registry, ProGuard parser) |

### Key Design Patterns

1. **Arena Allocation** (`bumpalo`) - IR nodes allocated in per-method arenas
2. **Enum-based IR** - Instructions as `InsnType` enum variants, not class hierarchy
3. **SSA Form** - Full SSA transformation with phi nodes for type inference
4. **Region Tree** - Hierarchical control flow (Sequence, If, Loop, Switch, TryCatch)
5. **Parallel by Default** (`rayon`) - Class-level parallelism

### Java → Rust Type Mappings

| Java JADX | Rust |
|-----------|------|
| `ClassNode` | `ClassDef` |
| `MethodNode` | `MethodDef` |
| `BlockNode` | `BasicBlock` |
| `InsnNode` hierarchy | `Instruction` enum |
| `SSAVar` | `SsaVariable` |

## Key Files

| File | Purpose |
|------|---------|
| `jadx-passes/src/ssa.rs` | SSA transformation (phi placement, variable renaming) |
| `jadx-passes/src/region_builder.rs` | Control flow region reconstruction |
| `jadx-codegen/src/body_gen.rs` | Method body decompilation (instruction → Java, ternary detection) |
| `jadx-codegen/src/method_gen.rs` | Method signature and annotation generation |
| `jadx-codegen/src/class_gen.rs` | Class structure, fields, and annotation generation |
| `jadx-codegen/src/dex_info.rs` | DEX data access for name resolution |
| `jadx-dex/src/sections/encoded_value.rs` | Annotation parsing from DEX format |
| `jadx-dex/src/sections/class_def.rs` | Class annotation directory reading |
| `jadx-cli/src/converter.rs` | DEX to IR conversion pipeline (including annotation conversion) |

## Testing Strategy

Golden file testing against Java JADX output:

```bash
# Generate reference from Java JADX
java -jar jadx-cli.jar -d expected/ input.apk

# Run Rust implementation
./jadx-rust -d actual/ input.apk

# Compare (goal: byte-for-byte identical)
diff -r expected/ actual/
```

## Known Gaps (vs Java JADX)

- Finally blocks in try-catch-finally (try-catch works, finally detection not yet implemented)

## Recently Implemented Features

- **Annotations**: Full annotation support (@Override, @Deprecated, custom annotations)
  - Parsed from DEX annotations_directory
  - Stored in IR (ClassData, MethodData, FieldData)
  - Emitted in codegen with proper formatting

- **Ternary operators**: Reconstructed from simple if/else patterns
  - Detects patterns where both branches assign to same register
  - Emits `dest = cond ? then_val : else_val`

- **Multi-catch**: Full support for `catch (Type1 | Type2 e)` syntax
  - Multiple exception types in single catch block

- **Anonymous class inlining**: Inline body generation at instantiation site
  - Detection: `Outer$1`, `Outer$$Lambda$1` patterns
  - Full method body generation inside `new ParentType() { ... }`
  - Class registry passed through codegen pipeline

- **Final local variables**: SSA-based detection
  - Variables assigned exactly once marked as `final`
  - Integrated with variable declaration emission

- **Deobfuscation infrastructure**: Full deobfuscation pipeline
  - Name validation and conditions system
  - Auto-alias generator with configurable prefixes
  - Thread-safe alias registry for cross-reference resolution
  - ProGuard mapping file parser (integration tests pending)
  - Visitor pattern for IR transformation

## Framework Class Filtering

The CLI filters out framework classes by default:
- `android.*`, `androidx.*`, `kotlin.*`, `java.*`, `javax.*`
- Generated code: `R.java`, `BuildConfig`, Dagger/Hilt factories
- Cross-platform: Flutter (`io.flutter.*`), React Native (`com.facebook.react.*`)
