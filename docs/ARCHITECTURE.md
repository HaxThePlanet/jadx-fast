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
├── dexterity-dex/         # DEX parsing (~4,500 lines)
├── dexterity-ir/          # IR types & class hierarchy (~10,744 lines)
├── dexterity-passes/      # Decompilation passes (~34,200 lines)
├── dexterity-codegen/     # Java code generation (~18,860 lines)
├── dexterity-resources/   # AXML & resources.arsc (~4,300 lines)
├── dexterity-deobf/       # Deobfuscation (~1,850 lines)
├── dexterity-kotlin/      # Kotlin metadata parsing (~2,100 lines)
├── dexterity-cli/         # CLI application (~6,100 lines)
├── dexterity-error/       # Unified error types
├── dexterity-utils/       # Shared utilities
├── dexterity-limits/      # Resource limits & safety guards
├── dexterity-qa/          # Quality assurance tools
└── dexterity-llm-postproc/# LLM post-processing utilities
```

Total: ~86,000 lines of Rust (core crates)

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
| `init_code_vars.rs` | Initialize CodeVars from SSAVars (JADX parity) |
| `process_variables.rs` | Remove unused vars, finalize CodeVars (JADX parity) |
| `type_inference.rs` | Constraint-based type inference |
| `finish_type_inference.rs` | Type validation, unknown type warnings (JADX FinishTypeInference parity) |
| `region_builder.rs` | CFG to structured regions |
| `conditionals.rs` | Else-if chaining, ternary reconstruction |
| `loops.rs` | ForEach detection from iterator patterns |
| `var_naming.rs` | JADX-style variable naming with SSAContext |
| `code_shrink.rs` | Single-use variable inlining |
| `deboxing.rs` | Primitive boxing/unboxing optimization |
| `needed_vars.rs` | Compute variables needed for output (lazy inference support) |
| `check_code.rs` | Instruction validation (register bounds, >255 args) |
| `check_regions.rs` | Region coverage validation (missing blocks, duplicates) |
| `usage_info.rs` | Usage graph for classes/methods/fields |
| `process_anonymous.rs` | Anonymous/lambda class detection for inlining |
| `post_process_regions.rs` | Loop condition merging, switch breaks |
| `return_visitor.rs` | Return statement optimization |
| `constructor_visitor.rs` | Constructor processing (super/this calls) |
| `attach_method_details.rs` | Method signature parsing, throws, generics |
| `attach_comments.rs` | Diagnostic comment counting/attachment (JADX parity, Dec 25) |
| `debug_info.rs` | Debug info attach + apply (Stage 0.5/5.1, Dec 25) |
| `fix_access_modifiers.rs` | Inner class visibility fixes (JADX parity, Dec 25) |

### dexterity-codegen (Code Generation)

Emit Java source from IR.

| File | Purpose |
|------|---------|
| `class_gen.rs` | Class/interface/enum/annotation generation |
| `method_gen.rs` | Method signatures and bodies |
| `body_gen.rs` | Statement and expression generation (~9,710 lines) |
| `type_gen.rs` | Type name generation with import handling |
| `writer.rs` | Java source code writer with formatting |
| `stdlib_signatures.rs` | Pre-computed library method signatures (~150 methods) |
| `comment_gen.rs` | Comment emission utilities (5 CommentStyles, Dec 25) |

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

Complete Kotlin metadata parsing with BitEncoding decoder ported from Java.

| File | Purpose |
|------|---------|
| `parser.rs` | @Metadata annotation parsing, BitEncoding decoder (UTF-8 + 8-to-7 modes) |
| `extractor.rs` | Name extraction, modifier application to IR |
| `tostring_parser.rs` | toString() bytecode analysis for field names |
| `proto/jvm_metadata.proto` | StringTableTypes message for d2 string resolution |
| `proto/metadata.proto` | Full Kotlin metadata protobuf schema |

### dexterity-cli (CLI Application)

Command-line interface and decompilation orchestration.

| File | Purpose |
|------|---------|
| `main.rs` | Main entry, parallel processing, file output, ZIP security |
| `args.rs` | CLI argument parsing (clap) |
| `decompiler.rs` | High-level decompilation API with debug info pipeline |
| `converter.rs` | DEX to IR conversion, FixAccessModifiers (~120 lines, Dec 25) |
| `gradle_export.rs` | Android Studio project export |
| `zip_fallback.rs` | Anti-RE fallback ZIP parser for corrupted APKs |

**Anti-RE Features (Dec 24, 2025):**
- Path traversal protection (blocks `../` patterns)
- Compression bomb detection (100x ratio, 25MB min)
- Fallback ZIP parser with signature-based entry recovery

**Decompiler Pipeline (Dec 25, 2025):**
- Stage 0.5: `attach_debug_info()` - attaches source lines before block splitting
- Stage 5.1: `apply_debug_info()` - applies variable names/types after type inference

## Key Design Choices

| Choice | Benefit |
|--------|---------|
| Memory-mapped DEX | Zero-copy parsing, minimal memory |
| DashMap string cache | Lock-free concurrent access |
| Rayon parallelism | Full CPU utilization (92.5% efficiency) |
| Arc<str> strings | Zero-copy sharing across threads |
| jemalloc allocator | Better performance under contention |
| Lazy instruction loading | Bounded memory for huge APKs |
| Library signature cache | O(1) lookup for ~150 common Java/Android methods |
| Lazy type inference | Only infer types for variables used in output |

## JADX Parity

| Crate | Parity | Notes |
|-------|--------|-------|
| dexterity-dex | **100%** | Full DEX parsing |
| dexterity-ir | **100%** | Complete SSA infrastructure |
| dexterity-passes | **90%** | 8 new passes added Dec 22 |
| dexterity-codegen | **85-90%** | Java source gen - production-ready |
| dexterity-resources | **100%** | AXML + resources.arsc |
| dexterity-deobf | **90%** | ProGuard mapping support |
| dexterity-kotlin | **100%** | Full metadata parsing |
| dexterity-cli | **95%** | JADX CLI compatibility |

*Feature completeness vs JADX. See [ROADMAP.md](ROADMAP.md) for grades and status.*

## Performance (Dec 25, 2025)

| Metric | Value |
|--------|-------|
| **Overall** | 14x faster than JADX |
| **Current Hardware** | 2x Xeon 8280, 56 cores |
| **Throughput** | 5.2K apps/hour @ 2.7 sec avg |
| **Projected (6780E, 144 cores)** | ~8.5K apps/hour @ ~1.6 sec avg |
| **1 Million APKs** | 8 days (current) -> ~5 days (6780E) |

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
