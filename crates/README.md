# jadx-rust

A high-performance Android DEX/APK decompiler written in Rust.

This is a Rust port of [JADX](https://github.com/skylot/jadx), aiming for identical output with significantly improved performance through Rust's zero-cost abstractions, memory safety, and parallel processing capabilities.

## Project Status

**Work in Progress** - DEX parsing complete, IR and passes in progress, code generation planned.

| Component | Status | Description |
|-----------|--------|-------------|
| jadx-dex | ✅ Complete | DEX parsing, instruction decoding (256 opcodes), code items |
| jadx-ir | ✅ Phase 1 | IR types, instruction builder, class/method/field data |
| jadx-passes | 🔨 Phase 1 | Block splitting pass, visitor traits |
| jadx-codegen | 🔨 Partial | CodeWriter trait, SimpleCodeWriter |
| jadx-cli | 🔨 Phase 1 | Full CLI args, APK/DEX processing, stub output |

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
- Class/method/field data structures
- Try-catch block handling
- Full CLI matching Java JADX options (50+ flags)
- APK extraction and multi-DEX support
- Framework class filtering (jadx-fast optimization)
- Progress bar and logging
- Stub Java output generation

### Planned
- SSA transformation
- Type inference
- Region reconstruction (CFG → if/loop/switch)
- Full Java source code generation
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

Current test coverage: **40 tests** across all crates.

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
├── jadx-dex/           # DEX binary format parsing
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
├── jadx-ir/            # Intermediate representation
│   ├── types.rs        # ArgType (primitives, objects, arrays)
│   ├── instructions.rs # IR instruction types (InsnNode, InsnType)
│   ├── builder.rs      # DEX -> IR conversion
│   ├── info.rs         # MethodData, ClassData, FieldData
│   ├── nodes.rs        # ClassNode, MethodNode, BlockNode
│   ├── regions.rs      # Control flow regions
│   └── attributes.rs   # Attribute storage
│
├── jadx-passes/        # Decompilation passes
│   ├── block_split.rs  # Basic block splitting
│   └── visitor.rs      # Visitor trait definitions
│
├── jadx-codegen/       # Java source generation
│   └── writer.rs       # CodeWriter trait
│
└── jadx-cli/           # CLI application
    ├── main.rs         # Entry point, APK/DEX processing
    ├── args.rs         # CLI arguments (50+ options)
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
  2. SSA transformation
  3. Type inference
  4. Region reconstruction (CFG → if/loop/switch)
    ↓ [jadx-codegen]
Generate → Java source code
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
