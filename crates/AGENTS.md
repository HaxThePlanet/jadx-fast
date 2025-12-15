# Dexterity Architecture

**Dexterity** is a high-performance Android DEX/APK decompiler written in Rust, inspired by [JADX](https://github.com/skylot/jadx).

## Current Status

**Build:** ✅ Passing
**Tests:** ~245 tests (100% pass rate)
**Lines:** ~52,000 lines of Rust
**Completion:** ~98% feature-complete vs Java jadx-core

## Crate Overview

```
crates/
├── jadx-dex/       # DEX parsing (3,836 lines)
├── jadx-ir/        # IR types & class hierarchy (3,841 lines)
├── jadx-passes/    # Decompilation passes (9,202 lines)
├── jadx-codegen/   # Java code generation (7,973 lines)
├── jadx-resources/ # AXML & resources.arsc (4,032 lines)
├── jadx-deobf/     # Deobfuscation (1,628 lines)
├── jadx-kotlin/    # Kotlin metadata parsing (597 lines)
└── jadx-cli/       # CLI application (4,207 lines)
```

### jadx-dex (DEX Parsing)

Memory-mapped DEX file parsing with zero-copy access.

**Key components:**
- `reader.rs` - DexReader with DashMap string cache for lock-free concurrent access
- `header.rs` - DEX header parsing (magic, checksum, offsets)
- `consts.rs` - Dalvik opcode definitions (all 224 opcodes)

### jadx-ir (Intermediate Representation)

Core IR types shared across all passes.

**Key components:**
- `instructions.rs` - ~40 instruction variants (`InsnType` enum)
- `types.rs` - Type system (`ArgType`, primitives, arrays, objects)
- `nodes.rs` - `ClassDef`, `MethodDef`, `FieldDef` definitions
- `class_hierarchy.rs` - Class hierarchy with LCA calculation for type inference
- `builder.rs` - IR builder from DEX bytecode
- `regions.rs` - Control flow region types (if/loop/switch/try)

### jadx-passes (Decompilation Passes)

Transform IR through analysis passes.

**Key components:**
- `block_split.rs` - Instructions → basic blocks
- `cfg.rs` - CFG construction with dominance (Cooper-Harvey-Kennedy)
- `ssa.rs` - SSA transformation with phi nodes
- `type_inference.rs` - Constraint-based type inference with unification
- `region_builder.rs` - CFG → structured regions (if/loop/switch/try)
- `conditionals.rs` - Else-if chaining, ternary reconstruction
- `loops.rs` - ForEach detection from iterator patterns
- `extract_field_init.rs` - Static initializer extraction (`<clinit>` → field decls)
- `method_inline.rs` - Synthetic bridge method inlining (`access$XXX`)
- `kotlin_intrinsics.rs` - Kotlin intrinsics handling
- `var_naming.rs` - JADX-style variable naming (85% parity)
- `finally_extract.rs` - Finally block handling

### jadx-codegen (Code Generation)

Emit Java source from IR.

**Key components:**
- `class_gen.rs` - Class/interface/enum/annotation generation
- `method_gen.rs` - Method signatures and bodies
- `body_gen.rs` - Statement and expression generation
- `expr_gen.rs` - Expression code generation
- `stmt_gen.rs` - Statement code generation
- `type_gen.rs` - Type name generation with import handling
- `dex_info.rs` - GlobalFieldPool for multi-DEX field resolution
- `access_flags.rs` - Java access modifier generation

### jadx-resources (Resource Decoding)

Android resource file decoding.

**Key components:**
- `axml.rs` - Binary XML parsing (AndroidManifest, layouts)
- `arsc.rs` - resources.arsc parsing (strings, dimensions, colors)
- `string_pool.rs` - String pool decoding
- `constants.rs` - Android resource type constants

### jadx-deobf (Deobfuscation)

Name deobfuscation and mapping support.

**Key components:**
- `alias_provider.rs` - Auto-generates `C0001`, `m0002` style names
- `conditions.rs` - Name validity conditions (length, characters, case)
- `registry.rs` - Thread-safe global alias registry
- `mapping_parser.rs` - ProGuard mapping file parser
- `name_mapper.rs` - Name mapping coordination
- `visitor.rs` - Deobfuscation pass visitor

### jadx-kotlin (Kotlin Support)

Kotlin metadata parsing and name restoration.

**Key components:**
- `parser.rs` - `@Metadata` annotation protobuf parsing
- `extractor.rs` - Name extraction from Kotlin metadata
- `visitor.rs` - Kotlin name restoration pass

### jadx-cli (CLI Application)

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
APK/DEX → jadx-dex → jadx-ir → jadx-passes → jadx-codegen → Java Source
                ↓           ↓
         jadx-resources  jadx-deobf
                          jadx-kotlin
```

1. **jadx-dex**: Parse DEX file (memory-mapped, zero-copy)
2. **jadx-ir**: Build IR from Dalvik bytecode
3. **jadx-passes**: Transform IR through passes:
   - Block splitting → CFG → Dominance → SSA → Type inference → Regions
4. **jadx-codegen**: Emit Java source with proper names and imports

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
cargo run --release -p jadx-cli -- -d output/ input.apk
```

## Performance

| Metric | Dexterity | Notes |
|--------|-----------|-------|
| Small APK (10KB) | 0.15s | 12x faster than Java JADX |
| Large APK (14MB) | 10.8s | Comparable, 100% complete |
| Core utilization | 92.5% | 3x better than Java JADX |
| Peak memory | Bounded | Lazy loading for huge APKs |
