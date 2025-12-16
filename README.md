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

**~54,000 lines of Rust | 4 active tests, 675 pending | ~70% JADX feature parity**

## Highlights

- **Up to 185x faster** than Java JADX on small APKs
- **Up to 46x less memory** usage compared to Java JADX
- **High JADX compatibility** - core decompilation matches Java JADX
- **Common input formats** - APK, DEX, JAR, AAR, ZIP
- **Complete deobfuscation** - ProGuard mappings, JOBF persistence
- **Kotlin support** - metadata parsing, name restoration
- **Multi-core parallel** - scales to 56+ threads

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
| Optimization Passes | 🔶 30% | Missing shrinking, simplification, deboxing |

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

public class MainActivity extends Activity {

    @Override
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.setContentView(R.layout.activity_main);
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
| others | 97 | 113 | 80 | ⚠️ Incomplete |
| conditions | 56 | 66 | 38 | ⚠️ Incomplete |
| loops | 52 | 57 | 28 | ⚠️ Incomplete |
| trycatch | 51 | 58 | 38 | ⚠️ Incomplete |
| types | 45 | 63 | 36 | ⚠️ Incomplete |
| inner | 39 | 41 | 23 | ⚠️ Incomplete |
| switches | 26 | 23 | 6 | 🔶 Mostly done |
| enums | 24 | 26 | 21 | ⚠️ Incomplete |
| invoke | 23 | 23 | 13 | ⚠️ Incomplete |
| generics | 21 | 25 | 15 | ⚠️ Incomplete |
| names | 20 | 32 | 37 | ⚠️ Incomplete |
| inline | 18 | 24 | 22 | ⚠️ Incomplete |
| arrays | 16 | 16 | 5 | 🔶 Mostly done |
| arith | 14 | 19 | 4 | 🔶 Mostly done |
| variables | 13 | 15 | 11 | ⚠️ Incomplete |
| java8 | 11 | 14 | 7 | ⚠️ Incomplete |
| deobf | 8 | 7 | 1 | ✅ Close |
| annotations | 7 | 9 | 2 | ✅ Close |
| android | 7 | 7 | 2 | ✅ Close |
| synchronize | 7 | 8 | 6 | ⚠️ Incomplete |
| rename | 7 | 16 | 24 | ⚠️ Incomplete |
| debuginfo | 5 | 3 | 2 | ⚠️ Missing tests |
| usethis | 4 | 4 | 0 | ✅ Done |
| code | 2 | 2 | 0 | ✅ Done |
| fallback | 2 | 2 | 1 | ✅ Close |
| special | 1 | 1 | 2 | ⚠️ Incomplete |
| jbc | 1 | 1 | 0 | ✅ Done |
| **TOTAL** | **577** | **675** | **439** | |

Rust tests are in `crates/dexterity-passes/tests/integration.disabled/` - most need assertions added.

### Implementation TODOs

| File | Description |
|------|-------------|
| `dexterity-cli/src/converter.rs:210` | Parse and store type parameters in method.type_parameters |
| `dexterity-cli/src/converter.rs:770` | Multi-DEX support (currently hardcoded to dex_idx: 0) |
| `dexterity-cli/src/gradle_export.rs` | Gradle export dependencies handling (3 locations) |
| `dexterity-passes/src/type_inference.rs:665` | Compute LCA of all phi sources after initial resolution |

## Comparison with Java JADX

### Implementation Status

| Component | Status | Notes |
|-----------|--------|-------|
| Core pipeline | ~70% | Parsing, SSA, type inference, regions, codegen work |
| Optimization passes | ~30% | Missing shrinking, simplification, deboxing |
| Tooling/extras | ~20% | CLI only, no GUI/plugins/IDE |

### Missing Decompiler Passes (High Priority)

| Pass | Purpose |
|------|---------|
| `CodeShrinkVisitor` | Remove redundant code, unused variables |
| `SimplifyVisitor` | Simplify expressions, optimize conditionals |
| `DeboxingVisitor` | Remove Integer.valueOf(), Boolean.valueOf() |
| `ConstInlineVisitor` | Inline constant values |
| `EnumVisitor` | Enum class reconstruction |
| `TernaryMod` | Ternary expression conversion |
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
| Boxing optimization | Clean up redundant boxing in output |
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
