# CLAUDE.md

This file provides guidance to Claude Code (claude.ai/code) when working with code in this repository.

## Project Overview

**Dexterity** is a high-performance Android DEX/APK decompiler written in Rust, inspired by [JADX](https://github.com/skylot/jadx). The goal is 1:1 output compatibility with Java JADX while achieving 2-4x faster performance through zero-copy parsing and native parallelism.

**Current status**: 88,366 lines of Rust, 877 tests (92% coverage of Java JADX test suite with ~953 total tests), full decompilation pipeline functional.

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
| `jadx-dex` | DEX file parsing (header, strings, types, classes, methods, all 224 Dalvik opcodes) |
| `jadx-ir` | Intermediate representation (InsnNode, InsnType, ClassData, MethodData, regions) |
| `jadx-passes` | Analysis passes (block split, CFG, dominators, SSA, type inference, loops, regions) |
| `jadx-codegen` | Java source generation (class/method/field/expr/stmt) |
| `jadx-resources` | Android resource decoding (AXML, resources.arsc) |
| `jadx-cli` | CLI application with JADX-compatible options |
| `jadx-deobf` | Deobfuscation (name validation, conditions, alias generation, registry, ProGuard parser) |

### Key Design Patterns

1. **Enum-based IR** - Instructions as `InsnType` enum variants, not class hierarchy
2. **SSA Form** - Full SSA transformation with phi nodes for type inference
3. **Region Tree** - Hierarchical control flow (Sequence, If, Loop, Switch, TryCatch with finally)
4. **Parallel by Default** (`rayon`) - Class-level parallelism
5. **Standard heap allocation** - Uses Rust's default allocator with strategic cloning

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

- **Finally block deduplication**: The marking pass is enabled (`mark_duplicated_finally()` runs before region building), but try-exit path duplicate search and SSA/arg-aware instruction matching are still pending for full JADX parity.

## Deobfuscation Roadmap

Note: Deobfuscation is cosmetic renaming (a.b.c → MainActivity.onCreate). The decompiled code is fully readable without it - you can see all logic, strings, URLs, API keys. Short names are just less convenient.

| Component | Status | Description |
|-----------|--------|-------------|
| Alias tracking in IR | ✅ Done | `alias: Option<String>` on class/method/field nodes |
| Conditions system | ✅ Done | Length and validity conditions (jadx-deobf crate) |
| Auto-alias generator | ✅ Done | Generates C0001, m0002, f0 style names |
| Alias registry | ✅ Done | Thread-safe global registry for cross-reference resolution |
| Pipeline integration | ✅ Done | `--deobf` flag wired into CLI |
| ProGuard parser | ✅ Done | `--mappings-path` loads ProGuard mapping files |
| Cross-ref aliasing | ✅ Done | Method bodies use deobfuscated names via AliasAwareDexInfo |
| Tiny/Enigma parsers | ❌ Pending | Other mapping formats |
| .jobf persistence | ⚠️ Partial | CLI param defined, read/write logic not implemented |

### What --deobf does (implemented):

- ✅ Renames short/invalid identifiers → AbstractActivityC1234, m0methodName
- ✅ Loads ProGuard mapping files (`--mappings-path mapping.txt`)
- ✅ Cross-reference resolution - method bodies show deobfuscated names
- ⚠️ Save/load `.jobf` files (CLI parameter exists, not yet implemented)

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

- **Static field initialization extraction**: Moves simple static field assignments from `<clinit>` to field declarations
  - Scan for SPUT (static put) instructions in static initializer
  - Extract constant values (int, float, string, boolean, null, type references)
  - Only extract static final fields (safety constraint)
  - Remove extracted SPUT instructions from method body
  - Significantly reduces CPU cost during static initializer decompilation (50-70% speedup)
  - Implementation: `jadx-passes/src/extract_field_init.rs` (~320 lines)
  - Achieves 1:1 output compatibility with Java JADX

## Framework Class Filtering

The CLI filters out framework classes by default:
- `android.*`, `androidx.*`, `kotlin.*`, `java.*`, `javax.*`
- Generated code: `R.java`, `BuildConfig`, Dagger/Hilt factories
- Cross-platform: Flutter (`io.flutter.*`), React Native (`com.facebook.react.*`)
