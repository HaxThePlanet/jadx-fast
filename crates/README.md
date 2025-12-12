# jadx-rust

A high-performance Android DEX/APK decompiler written in Rust.

This is a Rust port of [JADX](https://github.com/skylot/jadx), aiming for identical output with significantly improved performance through Rust's zero-cost abstractions, memory safety, and parallel processing capabilities.

## Current Work

- **Linda (Claude Opus 4.5)**: ✅ Condition expression extraction - DONE
  - Modified `region_builder.rs` to extract `IfCondition` from blocks
  - Added `generate_condition()` in `body_gen.rs` to convert `Condition` to expression strings
  - Supports simple conditions, AND/OR/NOT compound conditions, and ternary
  - If/while/for now generate actual conditions like `v0 == 0` instead of `/* condition */`

## Project Status

**Active Development** - ~15,000 lines of Rust, 133 tests passing. Core pipeline functional.

| Component | Lines | Status | Description |
|-----------|------:|--------|-------------|
| jadx-dex | 2,999 | ✅ Complete | DEX parsing, instruction decoding (256 opcodes), code items |
| jadx-ir | 2,121 | ✅ Complete | IR types, instruction builder, regions, class/method/field data |
| jadx-passes | 5,457 | 🔨 60% | Block splitting, CFG, dominators, SSA, type inference, regions |
| jadx-codegen | 3,032 | 🔨 50% | Class/method gen, expression/statement gen, body generation |
| jadx-cli | 1,236 | ✅ Complete | Full CLI args, APK/DEX processing, converter, decompiler pipeline |

## Features

### Implemented
- Memory-mapped DEX file parsing
- Complete Dalvik instruction decoder (256 opcodes, 25 formats)
- LEB128 and MUTF-8 encoding support
- Class, method, field, and prototype parsing
- Method code items with try/catch handler parsing
- Type descriptor parsing
- IR instruction types (all Dalvik operations mapped)
- DEX to IR instruction builder
- Basic block splitting pass
- Control flow graph (CFG) construction
- Dominator tree computation (Cooper-Harvey-Kennedy algorithm)
- SSA transformation with phi node placement
- Type inference with constraint solving
- Region reconstruction (if/else, loops, switch, try-catch)
- Class/method/field data structures
- Java source generation (class signatures, method bodies, expressions)
- Full CLI matching Java JADX options (50+ flags)
- APK extraction and multi-DEX support
- Framework class filtering (jadx-fast optimization)
- Progress bar and logging
- Complete decompilation pipeline (DEX → IR → passes → Java)

### In Progress
- Expression simplification
- Copy propagation
- Dead code elimination
- Variable naming and renaming

### Planned
- Parallel class processing
- Deobfuscation support
- Resource decoding
- Identical output to Java JADX for regression testing

## Building

```bash
cd crates
cargo build --release
```

## Testing

```bash
cargo test --workspace
```

Current test coverage: **133 tests** across all crates.

## Usage

```bash
# Basic usage
jadx-rust -d output/ app.apk

# With deobfuscation
jadx-rust --deobf -d output/ app.apk

# Parallel processing
jadx-rust -j 16 -d output/ classes.dex

# Single class
jadx-rust --single-class MainActivity -d output/ app.apk
```

## Project Structure

```
crates/
├── jadx-dex/           # DEX binary format parsing (2,999 lines)
│   ├── header.rs       # DEX header (112 bytes)
│   ├── reader.rs       # Memory-mapped file reader
│   ├── sections/       # Class, field, method, proto, code item parsing
│   │   ├── class_def.rs
│   │   ├── code_item.rs    # Method bytecode + try/catch
│   │   ├── field_id.rs
│   │   ├── method_id.rs
│   │   └── proto_id.rs
│   ├── insns/          # Dalvik opcode decoder
│   │   ├── opcode.rs   # 256 Dalvik opcodes
│   │   ├── format.rs   # 25 instruction formats
│   │   └── decoder.rs  # Instruction iterator
│   └── utils/          # LEB128, MUTF-8 utilities
│
├── jadx-ir/            # Intermediate representation (2,121 lines)
│   ├── types.rs        # ArgType (primitives, objects, arrays)
│   ├── instructions.rs # IR instruction types (InsnNode, InsnType)
│   ├── builder.rs      # DEX -> IR conversion
│   ├── info.rs         # MethodData, ClassData, FieldData
│   ├── nodes.rs        # ClassNode, MethodNode, BlockNode
│   ├── regions.rs      # Control flow regions (if/loop/switch/try)
│   └── attributes.rs   # Attribute storage
│
├── jadx-passes/        # Decompilation passes (5,457 lines)
│   ├── block_split.rs  # Basic block splitting
│   ├── cfg.rs          # Control flow graph + dominators
│   ├── ssa.rs          # SSA transformation + phi nodes
│   ├── type_inference.rs   # Type inference with constraints
│   ├── region_builder.rs   # CFG → structured regions
│   ├── conditionals.rs     # Condition analysis (&&, ||)
│   ├── loops.rs            # Loop detection and classification
│   └── algorithms/     # Graph algorithms
│       └── dominance.rs    # Cooper-Harvey-Kennedy dominance
│
├── jadx-codegen/       # Java source generation (3,032 lines)
│   ├── writer.rs       # CodeWriter trait
│   ├── class_gen.rs    # Class declaration generation
│   ├── method_gen.rs   # Method signature generation
│   ├── body_gen.rs     # Method body from regions
│   ├── expr_gen.rs     # Expression generation
│   ├── stmt_gen.rs     # Statement generation
│   ├── type_gen.rs     # Type formatting
│   └── access_flags.rs # Modifier strings
│
└── jadx-cli/           # CLI application (1,236 lines)
    ├── main.rs         # Entry point, APK/DEX processing
    ├── args.rs         # CLI arguments (50+ options)
    ├── converter.rs    # DEX → IR conversion
    └── decompiler.rs   # Pipeline orchestration
```

## Architecture

The decompilation pipeline follows the same architecture as Java JADX:

```
DEX/APK File
    ↓ [jadx-cli] ✅
Load + Extract DEX files
    ↓ [jadx-dex] ✅
Parse → ClassDef, MethodId, CodeItem, Instructions
    ↓ [jadx-ir] ✅
Build IR → InsnNode, MethodData, ClassData
    ↓ [jadx-passes]
Transform:
  1. Block splitting (instructions → basic blocks) ✅
  2. CFG construction + dominators ✅
  3. SSA transformation + phi nodes ✅
  4. Type inference + constraints ✅
  5. Region reconstruction (CFG → if/loop/switch) ✅
    ↓ [jadx-codegen] ✅
Generate → Java source code (class/method/body/expr)
```

## Performance Goals

| Metric | Java JADX | Rust Target |
|--------|-----------|-------------|
| Parse time | baseline | 2-3x faster |
| Memory usage | baseline | 50% reduction |
| Total time | baseline | 2-4x faster |

Key optimizations:
- **Memory-mapped I/O** - Zero-copy DEX parsing
- **Arena allocation** - Cache-friendly IR node storage
- **String interning** - Deduplicated type/method names
- **Rayon parallelism** - Concurrent class processing
- **Framework skipping** - Skip android/kotlin/java classes

## Compatibility

The goal is **identical output** to Java JADX for regression testing. This enables:
- Differential testing against the Java implementation
- Gradual migration and validation
- Confidence in correctness

## Dependencies

- `memmap2` - Memory-mapped file I/O
- `zip` - APK extraction
- `rayon` - Data parallelism
- `petgraph` - Graph algorithms for CFG
- `clap` - CLI argument parsing
- `indicatif` - Progress bars
- `tracing` - Logging

## License

Apache-2.0 (same as JADX)

## Acknowledgments

This project is a Rust port of [JADX](https://github.com/skylot/jadx) by skylot. All credit for the decompilation algorithms and architecture goes to the original JADX authors.
