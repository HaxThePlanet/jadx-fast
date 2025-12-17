# Dexterity Architecture

**Dexterity** is a high-performance Android DEX/APK decompiler written in Rust, inspired by [JADX](https://github.com/skylot/jadx).

## Current Status

**Build:** Passing
**Tests:** 1,055+ tests passing (685 integration + 370 unit tests)
**Integration Tests:** 685 passing (100%)
**Lines:** ~78,000 lines of Rust
**Completion:** ~90% feature-complete vs Java jadx-core

## Crate Overview

```
crates/
├── dexterity-dex/       # DEX parsing (4,315 lines)
├── dexterity-ir/        # IR types & class hierarchy (4,236 lines)
├── dexterity-passes/    # Decompilation passes (20,404 lines)
├── dexterity-codegen/   # Java code generation (11,685 lines)
├── dexterity-resources/ # AXML & resources.arsc (4,032 lines)
├── dexterity-deobf/     # Deobfuscation (1,825 lines)
├── dexterity-kotlin/    # Kotlin metadata parsing (597 lines)
└── dexterity-cli/       # CLI application (5,254 lines)
```

### dexterity-dex (DEX Parsing)

Memory-mapped DEX file parsing with zero-copy access.

**Key components:**
- `reader.rs` - DexReader with lock-free concurrent access
- `sections/string_pool.rs` - parking_lot::RwLock + FxHashMap for fast string caching
- `header.rs` - DEX header parsing (magic, checksum, offsets)
- `consts.rs` - Dalvik opcode definitions (all 224 opcodes)

### dexterity-ir (Intermediate Representation)

Core IR types shared across all passes.

**Key components:**
- `instructions.rs` - ~40+ instruction variants (`InsnType` enum including Ternary)
- `types.rs` - Type system (`ArgType`, primitives, arrays, objects)
- `nodes.rs` - `ClassNode`, `MethodNode`, `FieldNode`, `BlockNode` definitions
- `class_hierarchy.rs` - Class hierarchy with LCA calculation for type inference (~382 lines)
- `builder.rs` - IR builder from DEX bytecode
- `regions.rs` - Control flow region types (if/loop/switch/try)

### dexterity-passes (Decompilation Passes)

Transform IR through analysis passes.

**Key components:**
- `block_split.rs` - Instructions → basic blocks
- `cfg.rs` - CFG construction with dominance (Cooper-Harvey-Kennedy)
- `ssa.rs` - SSA transformation with phi nodes (FxHashMap for fast lookups)
- `type_inference.rs` - Constraint-based type inference with:
  - Combined DEX lookups + class hierarchy support
  - Post-solve PHI node LCA computation for conflicting types
  - ObjectType constraints for array elements (vs Unknown)
  - 7 constraint types: Equals, Same, Subtype, ArrayOf, Numeric, Integral, ObjectType
- `region_builder.rs` - CFG → structured regions (if/loop/switch/try)
- `conditionals.rs` - Else-if chaining, ternary reconstruction
- `loops.rs` - ForEach detection from iterator patterns
- `extract_field_init.rs` - Static initializer extraction (`<clinit>` → field decls)
- `method_inline.rs` - Synthetic bridge method inlining (`access$XXX`)
- `kotlin_intrinsics.rs` - Kotlin intrinsics handling
- `var_naming.rs` - JADX-style variable naming (98% parity)
- `finally_extract.rs` - Finally block handling

### dexterity-codegen (Code Generation)

Emit Java source from IR.

**Key components:**
- `class_gen.rs` - Class/interface/enum/annotation generation
- `method_gen.rs` - Method signatures and bodies
- `body_gen.rs` - Statement and expression generation (~5,491 lines)
- `fallback_gen.rs` - Fallback mode raw instruction output
- `expr_gen.rs` - Expression code generation
- `stmt_gen.rs` - Statement code generation
- `type_gen.rs` - Type name generation with import handling
- `dex_info.rs` - GlobalFieldPool for multi-DEX field resolution
- `access_flags.rs` - Java access modifier generation

### dexterity-resources (Resource Decoding)

Android resource file decoding.

**Key components:**
- `axml.rs` - Binary XML parsing (AndroidManifest, layouts)
- `arsc.rs` - resources.arsc parsing (strings, dimensions, colors)
- `string_pool.rs` - String pool decoding
- `constants.rs` - Android resource type constants

### dexterity-deobf (Deobfuscation)

Name deobfuscation and mapping support.

**Key components:**
- `alias_provider.rs` - Auto-generates `C0001`, `m0002` style names
- `conditions.rs` - Name validity conditions (length, characters, case)
- `registry.rs` - Thread-safe global alias registry
- `mapping_parser.rs` - ProGuard mapping file parser
- `name_mapper.rs` - Name mapping coordination
- `visitor.rs` - Deobfuscation pass visitor

### dexterity-kotlin (Kotlin Support)

Kotlin metadata parsing and name restoration.

**Key components:**
- `parser.rs` - `@Metadata` annotation protobuf parsing
- `extractor.rs` - Name extraction from Kotlin metadata
- `visitor.rs` - Kotlin name restoration pass

### dexterity-cli (CLI Application)

Command-line interface and decompilation orchestration.

**Key components:**
- `main.rs` - Main entry, parallel processing, file output
- `args.rs` - CLI argument parsing (clap)
- `converter.rs` - DEX → IR conversion orchestration
- `decompiler.rs` - High-level decompilation API
- `gradle_export.rs` - Android Studio project export
- `deobf.rs` - Deobfuscation integration

## Pipeline Architecture

```
APK/DEX → dexterity-dex → dexterity-ir → dexterity-passes → dexterity-codegen → Java Source
                ↓           ↓
         dexterity-resources  dexterity-deobf
                          dexterity-kotlin
```

1. **dexterity-dex**: Parse DEX file (memory-mapped, zero-copy)
2. **dexterity-ir**: Build IR from Dalvik bytecode
3. **dexterity-passes**: Transform IR through passes:
   - Block splitting → CFG → Dominance → SSA → Type inference → Regions
4. **dexterity-codegen**: Emit Java source with proper names and imports

## Key Design Choices

| Choice | Benefit |
|--------|---------|
| Memory-mapped DEX | Zero-copy parsing, minimal memory |
| DashMap string cache | Lock-free concurrent access |
| Rayon parallelism | Full CPU utilization (92.5% efficiency) |
| Arc<str> strings | Zero-copy sharing across threads |
| jemalloc allocator | Better performance under contention |
| Lazy instruction loading | Bounded memory for huge APKs |

## Build Commands

```bash
cd /mnt/nvme4tb/jadx-rust/crates

# Development build
cargo build

# Release build (recommended)
cargo build --release

# Distribution build (maximum optimization)
cargo build --profile dist

# Run tests
cargo test

# Run with arguments
cargo run --release -p dexterity-cli -- -d output/ input.apk
```

## Performance

| Metric | Dexterity | Notes |
|--------|-----------|-------|
| Small APK (10KB) | 0.01s / 6MB | 185x faster, 46x less memory than Java JADX |
| Medium APK (11MB) | 3.59s / 304MB | 4x faster, 18x less memory |
| Large APK (55MB) | 0.90s / 85MB | 13x faster, 41x less memory |
| Core utilization | 92.5% | 3x better than Java JADX |
| Peak memory | Bounded | Lazy loading for huge APKs |
