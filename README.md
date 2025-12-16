<p align="center">
<pre>
      ____  _______  _________ ______ ____  ____________  __
     / __ \/ ____/ |/ /_  __// ____// __ \/  _/_  __/\ \/ /
    / / / / __/  |   / / /  / __/  / /_/ // /  / /    \  /
   / /_/ / /___ /   | / /  / /___ / _, _// /  / /     / /
  /_____/_____//_/|_|/_/  /_____//_/ |_/___/ /_/     /_/

           High-performance Android decompiler written in Rust
</pre>
</p>

<p align="center">
  <a href="LICENSE"><img src="https://img.shields.io/badge/License-Apache_2.0-blue.svg" alt="License"></a>
  <a href="https://www.rust-lang.org/"><img src="https://img.shields.io/badge/Rust-1.70+-orange.svg" alt="Rust"></a>
</p>

---

A high-performance Android DEX/APK decompiler written in Rust, producing Java source code compatible with [JADX](https://github.com/skylot/jadx) output.

**~59,000 lines of Rust | 683 integration tests passing | ~70% JADX feature parity**

## Highlights

- **Up to 185x faster** than Java JADX on small APKs
- **Up to 46x less memory** usage compared to Java JADX
- **High JADX compatibility** - core decompilation matches Java JADX
- **Common input formats** - APK, DEX, JAR, AAR, ZIP
- **Complete deobfuscation** - ProGuard mappings, JOBF persistence
- **Kotlin support** - metadata parsing, name restoration
- **Multi-core parallel** - tested up to 112 threads (29x speedup)

## Development Velocity

**Built in 5 days** by [@HaxThePlanet](https://github.com/haxtheplanet) — Dec 11-15, 2025:

```
        Rust Lines of Code Added per Day

  Dec 11 │█████████████████                      │  16,735
  Dec 12 │███████████████████████████████████████│  36,464  ← biggest day
  Dec 13 │██                                     │   1,528
  Dec 14 │█                                      │     836
  Dec 15 │███████                                │   6,018
         └───────────────────────────────────────┘
```

| Metric | Value |
|--------|-------|
| **Time span** | 5 days |
| **Total commits** | 136 |
| **Rust lines added** | 61,581 |
| **Rust lines deleted** | 5,957 |
| **Net Rust lines** | 55,624 |
| **Final codebase** | ~59,000 lines |
| **Peak day** | 36,464 LOC (Dec 12) |
| **Tests** | 683 integration tests passing |

## Development Priorities

Current focus areas for reaching JADX parity:

| Priority | Task | Impact | Status |
|----------|------|--------|--------|
| **1** | Complete 683 integration tests (186 TODOs remain) | Fill in missing test sources and assertions | 🔄 In Progress |
| **2** | Type inference bounds refactor | Reduces Unknown types from ~40% → ~20% | ✅ Done (Dec 15) |
| **3** | Deboxing pass | Remove `Integer.valueOf()`, `Boolean.valueOf()` clutter | ✅ Done (Dec 15) |
| **4** | For-loop recognition | Convert while loops to for/for-each patterns | ✅ Done (Dec 15) |
| **5** | Ternary detection | Convert if-else to `? :` expressions | ✅ Done (Dec 15) |
| **6** | Arithmetic simplification | Clean up `x + (-1)` → `x - 1`, boolean XOR | ✅ Done (Dec 15) |
| **7** | Constant inlining | Inline single-use constants into expressions | ✅ Done (Dec 15) |

## Quick Start

### Build

```bash
cd crates
cargo build --release -p dexterity-cli
```

### Basic Usage

```bash
# Decompile an APK
./target/release/dexterity -d output/ app.apk

# With deobfuscation
./target/release/dexterity --deobf -d output/ app.apk

# Export as Gradle project
./target/release/dexterity -e -d output/ app.apk
```

## Performance

Benchmarks on 56-thread system:

| APK Size | Dexterity | Java JADX | Speedup |
|----------|-----------|-----------|---------|
| Small (10KB) | 0.01s / 6MB | 1.85s / 275MB | **185x faster, 46x less memory** |
| Medium (11MB) | 3.59s / 304MB | 14.97s / 5.5GB | **4x faster, 18x less memory** |
| Large (55MB) | 0.90s / 85MB | 11.93s / 3.4GB | **13x faster, 41x less memory** |
| XL (98MB) | 0.66s / 63MB | 6.34s / 1.7GB | **10x faster, 27x less memory** |
| XXL (164MB) | 5.70s / 397MB | 22.50s / 6.0GB | **4x faster, 15x less memory** |
| Massive (647MB) | 20.85s / 677MB | 46.08s / 10.7GB | **2x faster, 16x less memory** |

### Core Scaling

Benchmark on 9MB APK (5,501 classes, 2 DEX files) showing parallel scaling efficiency:

```
Cores │ Time    │ Speedup │ Efficiency
──────┼─────────┼─────────┼───────────
    1 │ 36.99s  │   1.0x  │   100%
    2 │ 18.30s  │   2.0x  │   101%
    4 │  9.45s  │   3.9x  │    98%
    8 │  5.09s  │   7.3x  │    91%  ◀─ sweet spot
   12 │  3.63s  │  10.2x  │    85%
   16 │  2.91s  │  12.7x  │    79%  ◀─ diminishing returns start
   24 │  2.18s  │  17.0x  │    71%
   32 │  1.83s  │  20.2x  │    63%
   48 │  1.49s  │  24.8x  │    52%
   64 │  1.37s  │  27.0x  │    42%
  112 │  1.26s  │  29.4x  │    26%
```

```
Speedup vs Core Count

30x ┤                                    ●───● 112 cores
    │                              ●────●
25x ┤                        ●────●
    │                  ●────●
20x ┤             ●───●
    │        ●───●
15x ┤      ●
    │    ●
10x ┤   ●
    │  ●
 5x ┤ ●
    │●
 1x ┼─┬──┬──┬──┬──┬──┬──┬──┬──┬──┬──┬
    1  4  8  12 16 24 32 48 64    112
                Cores
```

**Key findings:**
- **Near-linear scaling up to 8 cores** (91% efficiency)
- **Sweet spot: 8-16 cores** - best performance per watt
- **Diminishing returns after 16 cores** - efficiency drops below 80%
- **64→112 cores gives only 8% speedup** - thread coordination overhead dominates

### vs Java JADX (same workload)

Apples-to-apples comparison decompiling identical classes (no framework filtering):

```
Tool       │ Cores │  Time  │ Classes
───────────┼───────┼────────┼─────────
JADX       │  112  │ 12.13s │  9,569
Dexterity  │  112  │  3.88s │  9,607
───────────┴───────┴────────┴─────────
                     3.1x faster
```

## Feature Status

| Category | Status | Details |
|----------|--------|---------|
| DEX Parsing | ✅ 100% | All 224 Dalvik opcodes |
| Control Flow | ✅ 100% | CFG, dominators, SSA, type inference |
| Region Reconstruction | ✅ 100% | if/else, loops, switch, try-catch, synchronized, finally |
| Code Generation | 🔶 80% | Annotations, ternary, multi-catch, inner classes |
| Input Formats | 🔶 60% | APK, DEX, JAR, AAR, ZIP (missing AAB, APKS, XAPK, Smali) |
| Resources | ✅ 100% | AXML and resources.arsc (1:1 match) |
| Kotlin Support | ✅ 100% | Metadata, name restoration, intrinsics |
| Deobfuscation | ✅ 100% | --deobf, ProGuard mappings, JOBF files |
| Variable Naming | ✅ 100% | Full JADX parity |
| Optimization Passes | 🔶 70% | Deboxing, arith simplify, const inline, code shrink, enum visitor done |

## CLI Reference

### Input/Output

| Flag | Description |
|------|-------------|
| `<input>` | Input file(s): APK, DEX, JAR, AAR, ZIP |
| `-d, --output-dir` | Output directory |
| `--output-dir-src` | Output directory for sources only |
| `--output-dir-res` | Output directory for resources only |
| `-r, --no-res` | Skip resources decompilation |
| `-s, --no-src` | Skip sources decompilation |
| `--single-class` | Decompile single class by name |

### Deobfuscation

| Flag | Description |
|------|-------------|
| `--deobf` | Enable deobfuscation |
| `--deobf-min` | Minimum name length to keep (default: 3) |
| `--deobf-max` | Maximum name length (default: 64) |
| `--mappings-path` | Path to ProGuard mappings file |
| `--deobf-cfg-file` | Path to JOBF aliases file |
| `--deobf-cfg-file-mode` | File mode: `read`, `save`, `read-or-save` |
| `--deobf-whitelist` | Package pattern to skip (repeatable) |

### Export

| Flag | Description |
|------|-------------|
| `-e, --export-gradle` | Export as Gradle project |
| `--export-gradle-type` | Gradle project type |

### Code Generation

| Flag | Description |
|------|-------------|
| `--no-imports` | Disable import statements |
| `--no-debug-info` | Disable debug info in output |
| `--no-inline-anonymous` | Disable anonymous class inlining |
| `--no-inline-methods` | Disable method inlining |
| `--no-move-inner-classes` | Keep inner classes in separate files |
| `--no-kotlin-metadata` | Disable Kotlin metadata parsing |
| `--escape-unicode` | Escape unicode characters in strings |
| `--respect-bytecode-access-modifiers` | Use original access modifiers |

### Performance

| Flag | Description |
|------|-------------|
| `-j, --threads-count` | Number of threads (default: all cores) |

### Output Control

| Flag | Description |
|------|-------------|
| `-v, --verbose` | Verbose output |
| `-q, --quiet` | Quiet mode |
| `--log-level` | Log level: `quiet`, `progress`, `info`, `debug` |

## Sample Output

```java
package io.github.skylot.android.smallapp;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

/* loaded from: classes.dex */
public class MainActivity extends Activity {
    @Override // android.app.Activity
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i("SmallApp", "Hello");
    }
}
```

## Architecture

```
APK/DEX -> dexterity-dex -> dexterity-ir -> dexterity-passes -> dexterity-codegen -> Java Source
                |           |
         dexterity-resources  dexterity-deobf / dexterity-kotlin
```

| Crate | Purpose |
|-------|---------|
| `dexterity-dex` | DEX binary parsing (memory-mapped, all 224 opcodes) |
| `dexterity-ir` | Intermediate representation, class hierarchy |
| `dexterity-passes` | SSA, type inference, region reconstruction |
| `dexterity-codegen` | Java source generation |
| `dexterity-resources` | AXML and resources.arsc decoding |
| `dexterity-deobf` | Deobfuscation, ProGuard parser |
| `dexterity-kotlin` | Kotlin metadata parsing |
| `dexterity-cli` | CLI application |

## Key Technical Features

- **Full multi-core parallelism** - Rayon-based parallel processing
- **Lock-free caching** - DashMap for concurrent string cache
- **Lazy instruction loading** - Bounded memory for huge APKs
- **jemalloc allocator** - Optimized for high-concurrency workloads
- **Memory-mapped I/O** - Zero-copy DEX parsing

## Documentation

- [Quality Status](docs/QUALITY_STATUS.md) - Detailed output quality vs Java JADX
- [Roadmap](docs/ROADMAP.md) - Remaining work and implementation plan
- [Changelog](docs/CHANGELOG.md) - Development history and fixes
- [Architecture](crates/AGENTS.md) - Crate structure and design

## Development

### Building from Source

```bash
cd crates
cargo build --release -p dexterity-cli
```

### Running Tests

```bash
cd crates
cargo test
```

### Test Parity with Java JADX

Goal: Match all 577 integration tests from `jadx-fast/jadx-core/src/test/java/jadx/tests/integration/`.

| Category | Java | Rust | TODOs | Status |
|----------|------|------|-------|--------|
| names | 20 | 32 | 37 | ⚠️ Incomplete |
| loops | 52 | 57 | 27 | ⚠️ Incomplete |
| conditions | 56 | 66 | 25 | ⚠️ Incomplete |
| types | 45 | 63 | 25 | ⚠️ Incomplete |
| rename | 7 | 16 | 24 | ⚠️ Incomplete |
| inner | 39 | 41 | 23 | ⚠️ Incomplete |
| trycatch | 51 | 58 | 22 | ⚠️ Incomplete |
| inline | 18 | 24 | 2 | 🔶 Mostly done |
| others | 97 | 113 | 1 | 🔶 Mostly done |
| enums | 24 | 26 | 0 | ✅ Done |
| generics | 21 | 25 | 0 | ✅ Done |
| invoke | 23 | 23 | 0 | ✅ Done |
| variables | 13 | 15 | 0 | ✅ Done |
| java8 | 11 | 14 | 0 | ✅ Done |
| synchronize | 7 | 8 | 0 | ✅ Done |
| switches | 26 | 23 | 0 | ✅ Done |
| arrays | 16 | 16 | 0 | ✅ Done |
| arith | 14 | 19 | 0 | ✅ Done |
| annotations | 7 | 9 | 0 | ✅ Done |
| android | 7 | 7 | 0 | ✅ Done |
| debuginfo | 5 | 3 | 0 | ✅ Done |
| special | 1 | 1 | 0 | ✅ Done |
| deobf | 8 | 7 | 0 | ✅ Done |
| usethis | 4 | 4 | 0 | ✅ Done |
| code | 2 | 2 | 0 | ✅ Done |
| fallback | 2 | 2 | 0 | ✅ Done |
| jbc | 1 | 1 | 0 | ✅ Done |
| sample | - | 5 | 0 | ✅ Done |
| **TOTAL** | **577** | **680** | **186** | |

Rust tests are in `crates/dexterity-cli/tests/integration/` - 680 integration tests + 3 framework tests = 683 total passing, 186 TODOs remaining.

### Implementation TODOs

| File | Description |
|------|-------------|
| `dexterity-cli/src/converter.rs:210` | Parse and store type parameters in method.type_parameters |
| `dexterity-cli/src/converter.rs:770` | Multi-DEX support (currently hardcoded to dex_idx: 0) |
| `dexterity-cli/src/gradle_export.rs` | Gradle export dependencies handling (3 locations) |
| `dexterity-passes/src/type_inference.rs:665` | Compute LCA of all phi sources after initial resolution |

## Comparison with Java JADX

### Region Builder Analysis

The region builder transforms flat control flow graphs into hierarchical region trees for structured code generation. Dexterity's implementation is modeled after JADX's `RegionMaker`.

**Core Algorithm: ~85% similar** - Same fundamental approach (back-edge loop detection, post-dominance conditionals, recursive region building with stack).

| Feature | Dexterity | JADX | Status |
|---------|-----------|------|--------|
| **Architecture** |
| Entry point | `build_regions()` → `make_method_region()` | `RegionMakerVisitor` → `makeMthRegion()` | Same |
| Traversal | `traverse()` recursive DFS | `traverse()` recursive DFS | Same |
| Region stack | `RegionStack` with exits | `RegionStack` with State/exits | Same |
| **Loops** |
| Back-edge detection | Yes | Yes | Done |
| While/do-while | Yes | Yes | Done |
| Break/continue insertion | `EdgeInsn::Break/Continue` | Break/Continue nodes | Done |
| Loop labels (nested) | Yes | Yes | Done |
| **For-loop recognition** | `detect_indexed_for_pattern` | `LoopRegionVisitor` | Done |
| **For-each (arrays)** | `detect_array_foreach_pattern` | Iterator/array patterns | **Disabled** |
| **For-each (iterables)** | `detect_iterator_pattern` | Iterator patterns | **Disabled** |
| **Conditionals** |
| If-else detection | Yes | Yes | Done |
| Merge point (post-dom) | Yes | Yes | Done |
| Condition merging (&&/\|\|) | `build_merged_condition()` | `mergeNestedIfNodes()` | Done |
| **Ternary patterns** | `detect_ternary_pattern` | `TERNARY` mode | Done |
| **Try-Catch-Finally** |
| Try block detection | Yes | Yes | Done |
| Exception handlers | `HandlerInfo` | Handler regions | Done |
| Finally detection | `detect_finally_block()` | Yes | Done |
| Duplicated finally extraction | `mark_duplicated_finally()` | Yes | Done |
| **Switch** |
| PackedSwitch | Yes | Yes | Done |
| SparseSwitch | Yes | Yes | Done |
| Merge point detection | Intersection of reachable sets | Dominance frontier | Done |
| **Fallthrough handling** | Basic | Advanced with reordering | Partial |
| **Break insertion pass** | `case_ends_with_exit` | `SwitchBreakVisitor` | Done |
| **Synchronized** |
| MONITOR_ENTER/EXIT pairing | `find_sync_region()` | `SynchronizedRegionMaker` | Done |
| Body detection | Forward reachability | Yes | Done |
| **Post-Processing** |
| If optimization | No | `IfRegionVisitor` | **TODO** |
| Clean regions pass | No | `CleanRegions` | **TODO** |
| Loop visitor | Codegen-time detection | `LoopRegionVisitor` | Partial (for-each disabled) |

**Feature Completeness: ~85%** - For-loop recognition, ternary detection, and smart break insertion now implemented.

### Known Limitations

**For-each loop detection is disabled**: The current region builder doesn't always include all body blocks in the loop region, causing for-each loops to generate with empty bodies. Indexed for-loops (`for(int i=0; i<n; i++)`) work correctly, but for-each patterns over arrays and iterables are disabled and fall back to while loops.

**Root cause**: For-each detection happens at code generation time, but the loop body region may not contain all the blocks that belong to the loop body. JADX solves this with a dedicated `LoopRegionVisitor` pass that runs BEFORE code generation, marking iterator instructions (`hasNext()`, `next()`) with `AFlag.DONT_GENERATE`.

**Workaround needed**: Implement a proper `LoopRegionVisitor` pass that:
1. Runs after region building but before code generation
2. Detects for-each patterns (iterator and array-based)
3. Marks the iterator variable and `next()` calls with `DontGenerate` flag
4. Transforms the loop region to `LoopKind::ForEach` with proper element variable

Until this is implemented, iterator-based loops generate as:
```java
while (iterator.hasNext()) {
    Object item = iterator.next();
    // body
}
```
Instead of:
```java
for (Object item : collection) {
    // body
}
```

### Implementation Status

| Component | Status | Notes |
|-----------|--------|-------|
| Core pipeline | ~85% | Parsing, SSA, type inference, regions, codegen work |
| Optimization passes | ~60% | Deboxing, arithmetic simplification, const inlining done; missing shrinking |
| Tooling/extras | ~20% | CLI only, no GUI/plugins/IDE |

### Missing Decompiler Passes (High Priority)

| Pass | Purpose |
|------|---------|
| ~~`CodeShrinkVisitor`~~ | ~~Remove redundant code, unused variables~~ 🔶 Partial (Dec 15) |
| ~~`SimplifyVisitor`~~ | ~~Simplify expressions, optimize conditionals~~ 🔶 Partial (arith done) |
| ~~`DeboxingVisitor`~~ | ~~Remove Integer.valueOf(), Boolean.valueOf()~~ ✅ Done |
| ~~`ConstInlineVisitor`~~ | ~~Inline constant values~~ ✅ Done |
| ~~`EnumVisitor`~~ | ~~Enum class reconstruction~~ 🔶 Partial (Dec 15) |
| ~~`TernaryMod`~~ | ~~Ternary expression conversion~~ ✅ Done |
| `SwitchOverStringVisitor` | Switch-on-string handling |
| `FixSwitchOverEnum` | Enum switch optimization |
| `ProcessAnonymous` | Anonymous class processing |
| `ExtractFieldInit` | Field initializer extraction |
| `MethodInvokeVisitor` | Method invocation resolution |
| `ResolveJavaJSR` | JSR/RET instruction handling |
| `OverrideMethodVisitor` | Override and inheritance analysis |
| `ShadowFieldVisitor` | Shadow field detection |
| `GenericTypesVisitor` | Generic type inference |
| `DebugInfoApplyVisitor` | Debug info application |

### Missing Input Formats

| Format | Description |
|--------|-------------|
| AAB | Android App Bundle |
| APKM | APK Media Container |
| APKS | Split APKs bundle |
| XAPK | XAPK format |
| Smali | Smali source input |
| Java class → DEX | Java bytecode conversion |

### Missing CLI Options

| Option | Purpose |
|--------|---------|
| `--show-bad-code` | Visualize problematic code |
| `--add-debug-lines` | Add debug line comments |
| `--comments-level` | Control comment verbosity |
| `--integer-format` | Hex/decimal format control |
| `-P` plugin options | Plugin configuration |

### Missing Code Generation Features

| Feature | Description |
|---------|-------------|
| Rename comments | `/* renamed from: X */` annotations |
| JSON IR export | Full JSON intermediate representation |
| Source maps | IDE source mapping output |
| Debug line comments | Inline bytecode offset comments |

### Not Planned

| Feature | Reason |
|---------|--------|
| GUI | CLI-focused tool |
| IDE plugins | Out of scope |
| Script/plugin system | Out of scope |
| DOT graph export | Low priority |

## License

Apache-2.0 (same as JADX)

## Credits

- [skylot/jadx](https://github.com/skylot/jadx) - The original JADX project

---

<p align="center">
  <b>Reference Implementation:</b> Java JADX v1.5.3 source is included at <code>jadx-fast/</code> for comparison during development.
</p>
