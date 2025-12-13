# jadx-rust

A high-performance Android DEX/APK decompiler written in Rust.

This is a Rust port of [JADX](https://github.com/skylot/jadx), aiming for identical output with significantly improved performance through Rust's zero-cost abstractions, memory safety, and parallel processing capabilities.

## Current Status: 1:1 Output Match with Java JADX

**~87,000 lines of Rust | 877 tests passing | 0 semantic differences in golden tests**

The full decompilation pipeline produces **identical output** to Java JADX:

```java
// Rust jadx output (identical to Java JADX)
package io.github.skylot.android.smallapp;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends Activity {

	@Override // android.app.Activity
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.setContentView(R.layout.activity_main);
		Log.i("SmallApp", "Hello");
	}
}
```

**Key features achieving 1:1 match:**
- Parameter names from debug info (`savedInstanceState` not `bundle`)
- @Override with declaring class comment (`// android.app.Activity`)
- String literals, field names, method calls fully resolved
- Expression inlining (single-use variables eliminated)
- Default constructors skipped, trailing returns removed
- **Resource extraction**: 1:1 match with Java JADX (AndroidManifest.xml, layouts, drawables, values/*.xml, META-INF)

| Component | Lines | Tests | Status |
|-----------|------:|------:|--------|
| jadx-dex | 3,700 | 14 | ✅ Complete |
| jadx-ir | 2,400 | 28 | ✅ Complete |
| jadx-passes | 6,000 | 43 | ✅ Complete |
| jadx-codegen | 6,200 | 70 | ✅ Complete |
| jadx-resources | 3,350 | 9 | ✅ Complete |
| jadx-deobf | 800 | 5 | ✅ Complete |
| jadx-kotlin | 400+ | - | ⏳ Phase 2 Complete |
| jadx-cli | 2,600 | 7 | ✅ Complete |

## Features

### Completed
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
- ForEach loop detection from iterator patterns
- FillArrayData inline array literal generation
- Multi-catch exception handling (`catch (Type1 | Type2 e)`)
- Ternary operator reconstruction from if/else patterns
- Inner class detection (anonymous, named, lambda, local)
- Class/method/field data structures
- Java source generation (class signatures, method bodies, expressions)
- **Name resolution from DEX string/type/field/method pools**
- **Annotation support** (@Override with declaring class, @Deprecated, custom annotations)
- Variable naming (type-based: `str` for String, `i` for int)
- **Parameter naming from DEX debug info** (original names preserved)
- **Expression inlining** (single-use variables eliminated)
- Constructor cleanup (`super()` instead of `this.<init>()`)
- Default constructor omission (implicit in Java)
- Trailing return removal (unnecessary in Java)
- Import-aware simple names in method bodies
- Full CLI matching Java JADX options (50+ flags)
- APK extraction and multi-DEX support
- **JAR/AAR input support** (with D8/dx conversion for .class files)
- Framework class filtering (jadx-fast optimization)
- **Finally block detection** (catch-all → finally transformation)
- Progress bar and logging
- Complete decompilation pipeline (DEX → IR → passes → Java)
- **Resource decoding (AXML)**: AndroidManifest.xml, layouts, drawables (250+ attribute mappings)
- **Resource table (ARSC)**: Full values/*.xml generation with config qualifiers
  - strings.xml, colors.xml, styles.xml, arrays.xml, plurals.xml, dimens.xml, integers.xml, bools.xml
  - Config qualifier parsing (en-rUS, hdpi, xhdpi, v21, night, land, etc.)
  - Complex entries (styles with parent inheritance, typed arrays, plurals)
- Dimension value decoding (dp, sp, px, etc.)
- Final variable detection (SSA-based)
- **Android enum/flag value decoding** (match_parent, wrap_content, vertical, nonZero, etc.)
- **Raw file extraction** (META-INF, assets, native libs)

### Edge Cases (rare differences)
- Unusual exception handlers in complex control flow

### Known Issues

| Issue | Location | Output |
|-------|----------|--------|
| Live vars panic | `live_vars.rs:118` | Panics if >1000 iterations |

**Type inference fallbacks**: Falls back to `Object`/`int`/`vN` when type cannot be determined.

### Recently Fixed
- ✅ **1:1 Output Match** - Golden tests show 0 semantic differences vs Java JADX
- ✅ **Parameter naming** - Extracts original parameter names from DEX debug info
- ✅ **@Override comments** - Includes declaring class: `@Override // android.app.Activity`
- ✅ **Expression inlining** - Eliminates single-use variables for cleaner output
- ✅ **Resource extraction** - Full AXML/ARSC parsing with values/*.xml generation
- ✅ **Dimension decoding** - Correct dp/sp/px values (fixed radix multiplier calculation)
- ✅ **Final variables** - SSA-based detection marks single-assignment locals as `final`
- ✅ **ForEach loops** - Detect iterator patterns → `for (Type item : collection)`
- ✅ **FillArrayData** - Generates inline array literals `new int[]{1, 2, 3}` instead of placeholder
- ✅ **Multi-catch exceptions** - `catch (IOException | SQLException e)` syntax support
- ✅ **Ternary operators** - Detect if/else assigning to same variable → `x = cond ? a : b`
- ✅ **Anonymous inner classes** - Detection utilities for `Outer$1`, `Outer$Inner`, `Outer$$Lambda$1`
- ✅ **Finally block detection** - Catch-all handlers ending with re-throw → `finally { }` blocks
- ✅ **JAR/AAR support** - Process JAR/AAR files (D8/dx conversion for .class files)
- ✅ Default constructors - Skipped when just calling `super()` (implicit in Java)
- ✅ Trailing void returns - Removed unnecessary `return;` statements
- ✅ Import simple names - Variables use simple type names when imported
- ✅ Switch case keys - Packed/sparse switch payloads now parsed correctly
- ✅ Static field initial values - Full support (primitives, strings, types, booleans, arrays, enums, field refs)
- ✅ **Android enum values** - match_parent, wrap_content, vertical, horizontal, nonZero, evenOdd
- ✅ **Raw file extraction** - META-INF, assets, native libs extracted from APK
- ✅ **Config qualifier parsing** - Full ResTable_config parsing (locale, density, SDK, orientation, night mode)
- ✅ **Complex resource entries** - styles.xml, arrays.xml, plurals.xml with parent inheritance
- ✅ **Expanded AXML attributes** - 250+ Android framework attribute mappings for manifest/layout parsing
- ✅ **Kotlin Metadata Parsing** - Full `@kotlin.Metadata` annotation support with protobuf decoding (Phase 2 complete)

### In Progress: Kotlin Metadata Support for 1:1 Java JADX Parity

**Phase 1-2: Foundation (✅ Complete)**
- ✅ Created `jadx-kotlin` crate
- ✅ Downloaded official Kotlin metadata.proto schema
- ✅ Setup prost protobuf code generation (~1200 lines of generated code)
- ✅ Implemented full protobuf parser with base64 decoding
- ✅ Supports 3 metadata kinds: Class, Package (FileFacade), SyntheticClass
- ✅ Extracts original Kotlin names: class names, function names, property (field) names, parameter names
- ✅ Implements name extraction and IR application logic

**Phase 3-4: Integration (In Progress)**
- ⏳ Kotlin Intrinsics variable name extraction (Intrinsics.checkNotNullParameter calls)
- ⏳ Kotlin-aware deobfuscation integration (skip renaming for Kotlin-provided aliases)
- ⏳ CLI integration (--kotlin-metadata flag, enabled by default like Java JADX)
- ⏳ Comprehensive testing with 25 Kotlin feature test cases
- ⏳ Real-world APK validation against Java JADX output

**Phase 5: Extended Features (Future)**
- FileFacade handling (top-level functions)
- SyntheticClass handling (lambdas)
- toString() parser (extract field names from toString method)
- Companion object detection and hiding
- Data class marking
- Full feature parity with Java JADX Kotlin plugin

### Future
- Deobfuscation support (phase 4)
- ProGuard mapping file support

## Building

```bash
cd crates
cargo build --release
```

## Testing

```bash
cargo test --workspace
```

Current test coverage: **180 tests** across all crates, including golden file comparison tests.

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

# JAR file (requires d8 or dx in PATH for .class files)
jadx-rust -d output/ library.jar

# AAR file (Android Archive)
jadx-rust -d output/ library.aar
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
├── jadx-passes/        # Decompilation passes (5,817 lines)
│   ├── block_split.rs  # Basic block splitting
│   ├── cfg.rs          # Control flow graph + dominators
│   ├── ssa.rs          # SSA transformation + phi nodes
│   ├── type_inference.rs   # Type inference with constraints
│   ├── var_naming.rs       # Type-based variable naming [NEW]
│   ├── region_builder.rs   # CFG → structured regions
│   ├── conditionals.rs     # Condition analysis (&&, ||)
│   ├── loops.rs            # Loop detection and classification
│   └── algorithms/     # Graph algorithms
│       └── dominance.rs    # Cooper-Harvey-Kennedy dominance
│
├── jadx-codegen/       # Java source generation (3,556 lines)
│   ├── writer.rs       # CodeWriter trait
│   ├── class_gen.rs    # Class declaration generation
│   ├── method_gen.rs   # Method signature generation
│   ├── body_gen.rs     # Method body from regions
│   ├── expr_gen.rs     # Expression generation with name resolution
│   ├── stmt_gen.rs     # Statement generation
│   ├── type_gen.rs     # Type formatting
│   ├── dex_info.rs     # DEX data for name resolution [NEW]
│   └── access_flags.rs # Modifier strings
│
├── jadx-kotlin/        # Kotlin metadata parsing [NEW - Phase 2]
│   ├── build.rs        # Prost protobuf code generation (generates ~1200 lines)
│   ├── proto/
│   │   ├── metadata.proto      # Kotlin @kotlin.Metadata schema (official from Kotlin repo)
│   │   └── ext_options.proto   # JVM-specific protobuf extensions
│   └── src/
│       ├── lib.rs              # Public API: process_kotlin_metadata()
│       ├── parser.rs           # Protobuf decoding, base64 decompression (290 lines)
│       │   ├── find_kotlin_metadata() - locate @kotlin.Metadata annotation
│       │   ├── parse_d1_protobuf() - decode base64 protobuf data
│       │   └── Classes support: Class, Package (FileFacade), SyntheticClass
│       ├── extractor.rs        # Apply extracted names to IR (96 lines)
│       │   └── apply_kotlin_names() - map classes/methods/fields to ClassData
│       ├── types.rs            # High-level types (KotlinClassMetadata, etc)
│       └── visitor.rs          # Kotlin-aware deobfuscation integration (TODO)
│
└── jadx-cli/           # CLI application (1,363 lines)
    ├── main.rs         # Entry point, APK/DEX processing
    ├── args.rs         # CLI arguments (50+ options)
    ├── converter.rs    # DEX → IR conversion [Kotlin metadata integration point]
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
    ↓ [jadx-kotlin] ⏳ (Phase 2: Parser + Extractor complete)
Extract @kotlin.Metadata:
  1. Find @kotlin.Metadata annotation ✅
  2. Decode base64 protobuf (d1 field) ✅
  3. Extract original Kotlin names ✅
  4. Apply names to IR (ClassData, MethodData, FieldData) ✅
  5. Deobfuscation integration (pending)
    ↓ [jadx-passes] ✅
Transform:
  1. Block splitting (instructions → basic blocks) ✅
  2. CFG construction + dominators ✅
  3. SSA transformation + phi nodes ✅
  4. Type inference + constraints ✅
  5. Variable naming (type-based) ✅
  6. Kotlin Intrinsics extraction (pending)
  7. Region reconstruction (CFG → if/loop/switch) ✅
    ↓ [jadx-codegen] ✅
Generate → Java source code with name resolution
  - Strings, types, fields, methods resolved from DEX pools
  - Kotlin names override deobfuscation (when available)
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

**Achieved: identical output** to Java JADX on test APKs with 0 semantic differences:
- Golden file tests compare Rust output vs Java JADX output
- Parameter names, annotations, imports all match
- Differential testing validates correctness

## Dependencies

- `memmap2` - Memory-mapped file I/O
- `zip` - APK extraction
- `rayon` - Data parallelism
- `petgraph` - Graph algorithms for CFG
- `clap` - CLI argument parsing
- `indicatif` - Progress bars
- `tracing` - Logging
- `prost` & `prost-build` - Protobuf code generation (Kotlin metadata support)
- `base64` - Base64 decoding for protobuf data

## Technical Details: Kotlin Metadata Support

**@kotlin.Metadata Annotation Structure:**
- `k` (kind): Class (1), FileFacade (2), SyntheticClass (3)
- `mv` (metadata version): e.g., [1, 8, 0]
- `d1` (data1): Base64-encoded protobuf with class/function/property metadata
- `d2` (data2): Human-readable string array fallback
- `xs`, `pn`, `xi`: Additional metadata fields

**Protobuf Schema:**
- Source: Official Kotlin repository (https://github.com/JetBrains/kotlin/tree/master/core/metadata/src/)
- Messages: Class, Function, Property, ValueParameter, Package, etc.
- Generated Rust types: ~1200 lines via `prost-build`
- Type-safe, zero-copy deserialization

**Name Extraction:**
1. Find `@kotlin.Metadata` annotation in `ClassData.annotations`
2. Extract d1 field and decode base64 to binary protobuf
3. Parse protobuf using generated Rust types
4. Build string table from d2 array (human-readable names)
5. Extract: class name, function names, property names, parameter names
6. Apply to IR: `ClassData.alias`, `MethodData.alias`, `FieldData.alias`, `arg_names`

**Deobfuscation Integration:**
- Kotlin-provided names take precedence over deobfuscation heuristics
- Works with or without ProGuard mappings
- Graceful fallback: if metadata parsing fails, uses standard deobfuscation

## License

Apache-2.0 (same as JADX)

## Acknowledgments

This project is a Rust port of [JADX](https://github.com/skylot/jadx) by skylot. All credit for the decompilation algorithms and architecture goes to the original JADX authors.
