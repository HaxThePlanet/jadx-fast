# Dexterity Architecture

High-performance Android DEX/APK decompiler written in Rust, targeting 1:1 JADX parity.

## Pipeline Overview

```
APK/DEX -> dexterity-dex -> dexterity-ir -> dexterity-passes -> dexterity-codegen -> Java Source
                |              |
         dexterity-resources   dexterity-deobf
                               dexterity-kotlin
```

1. **dexterity-dex**: Parse DEX file (memory-mapped, zero-copy)
2. **dexterity-ir**: Build IR from Dalvik bytecode
3. **dexterity-passes**: Transform IR through analysis passes
4. **dexterity-codegen**: Emit Java source with proper names and imports

## Crate Structure

```
crates/
├── dexterity-dex/         # DEX parsing (~4,400 lines)
├── dexterity-ir/          # IR types & class hierarchy (~9,200 lines)
├── dexterity-passes/      # Decompilation passes (~24,600 lines)
├── dexterity-codegen/     # Java code generation (~13,900 lines)
├── dexterity-resources/   # AXML & resources.arsc (~3,400 lines)
├── dexterity-deobf/       # Deobfuscation (~1,800 lines)
├── dexterity-kotlin/      # Kotlin metadata parsing (~992 lines)
├── dexterity-cli/         # CLI application (~5,800 lines)
├── dexterity-qa/          # Quality assurance tools
└── dexterity-llm-postproc/# LLM post-processing utilities
```

Total: ~89,000 lines of Rust

## Crate Details

### dexterity-dex (DEX Parsing)

Memory-mapped DEX file parsing with zero-copy access.

| File | Purpose |
|------|---------|
| `reader.rs` | DexReader with lock-free concurrent access |
| `sections/string_pool.rs` | parking_lot::RwLock + FxHashMap for fast string caching |
| `header.rs` | DEX header parsing (magic, checksum, offsets) |
| `consts.rs` | Dalvik opcode definitions (all 224 opcodes) |

### dexterity-ir (Intermediate Representation)

Core IR types shared across all passes.

| File | Purpose |
|------|---------|
| `instructions.rs` | ~46 instruction variants |
| `types.rs` | Type system with Unknown variants |
| `nodes.rs` | ClassNode, MethodNode, FieldNode, BlockNode |
| `class_hierarchy.rs` | TypeCompare engine, LCA calculation |
| `ssa.rs` | Full SSA infrastructure |
| `attributes.rs` | 60 AFlag flags + 37 AType typed attributes |
| `regions.rs` | Control flow region types (if/loop/switch/try) |

### dexterity-passes (Decompilation Passes)

Transform IR through analysis passes.

| File | Purpose |
|------|---------|
| `block_split.rs` | Instructions to basic blocks |
| `cfg.rs` | CFG construction with dominance (Cooper-Harvey-Kennedy) |
| `ssa.rs` | SSA transformation with phi nodes |
| `type_inference.rs` | Constraint-based type inference |
| `region_builder.rs` | CFG to structured regions |
| `conditionals.rs` | Else-if chaining, ternary reconstruction |
| `loops.rs` | ForEach detection from iterator patterns |
| `var_naming.rs` | JADX-style variable naming |
| `code_shrink.rs` | Single-use variable inlining |
| `deboxing.rs` | Primitive boxing/unboxing optimization |

### dexterity-codegen (Code Generation)

Emit Java source from IR.

| File | Purpose |
|------|---------|
| `class_gen.rs` | Class/interface/enum/annotation generation |
| `method_gen.rs` | Method signatures and bodies |
| `body_gen.rs` | Statement and expression generation (~6,653 lines) |
| `type_gen.rs` | Type name generation with import handling |
| `writer.rs` | Java source code writer with formatting |

### dexterity-resources (Resource Decoding)

Android resource file decoding.

| File | Purpose |
|------|---------|
| `axml.rs` | Binary XML parsing (AndroidManifest, layouts) |
| `arsc.rs` | resources.arsc parsing |
| `android_res_map.rs` | Android framework resource name lookups (10,000+ entries) |

### dexterity-deobf (Deobfuscation)

Name deobfuscation and mapping support.

| File | Purpose |
|------|---------|
| `alias_provider.rs` | Auto-generates C0001, m0002 style names |
| `mapping_parser.rs` | ProGuard mapping file parser |
| `registry.rs` | Thread-safe global alias registry |

### dexterity-kotlin (Kotlin Support)

Kotlin metadata parsing and name restoration.

| File | Purpose |
|------|---------|
| `parser.rs` | @Metadata annotation protobuf parsing |
| `extractor.rs` | Name extraction from Kotlin metadata |

### dexterity-cli (CLI Application)

Command-line interface and decompilation orchestration.

| File | Purpose |
|------|---------|
| `main.rs` | Main entry, parallel processing, file output |
| `args.rs` | CLI argument parsing (clap) |
| `decompiler.rs` | High-level decompilation API |
| `gradle_export.rs` | Android Studio project export |

## Key Design Choices

| Choice | Benefit |
|--------|---------|
| Memory-mapped DEX | Zero-copy parsing, minimal memory |
| DashMap string cache | Lock-free concurrent access |
| Rayon parallelism | Full CPU utilization (92.5% efficiency) |
| Arc<str> strings | Zero-copy sharing across threads |
| jemalloc allocator | Better performance under contention |
| Lazy instruction loading | Bounded memory for huge APKs |

## JADX Parity

| Crate | Parity |
|-------|--------|
| dexterity-dex | **100%** |
| dexterity-ir | **98%** |
| dexterity-passes | **95%** |
| dexterity-codegen | **94%** |
| dexterity-resources | **100%** |
| dexterity-deobf | **100%** |
| dexterity-kotlin | **72%** |
| dexterity-cli | **98%** |

## Build Commands

```bash
cd crates

# Development build
cargo build

# Release build (recommended)
cargo build --release

# Run tests
cargo test

# Run with arguments
cargo run --release -p dexterity-cli -- -d output/ input.apk
```
