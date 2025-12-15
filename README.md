```
      ____  _______  _________ ______ ____  ____________  __
     / __ \/ ____/ |/ /_  __// ____// __ \/  _/_  __/\ \/ /
    / / / / __/  |   / / /  / __/  / /_/ // /  / /    \  /
   / /_/ / /___ /   | / /  / /___ / _, _// /  / /     / /
  /_____/_____//_/|_|/_/  /_____//_/ |_/___/ /_/     /_/

  ⚡ High-performance Android decompiler written in Rust 🦀
```

A high-performance Android DEX/APK decompiler written in Rust, inspired by [JADX](https://github.com/skylot/jadx).

## Project Goal

**Produce decompiled Java source code that matches Java JADX output.**

This project reimplements `jadx-core` (the decompilation engine) in Rust. The goal is output compatibility with the Java version.

**Reference Implementation:** Java JADX v1.5.3 source is included at `jadx-fast/` for comparison during development.

## Current Status

**~52,000 lines of Rust | 106 passing tests + 675 disabled | ~98% jadx-core parity**

| Category | Status |
|----------|--------|
| DEX parsing | 100% - All 224 Dalvik opcodes |
| Control flow | 100% - CFG, dominators, SSA, type inference |
| Region reconstruction | 95% - if/else/loops/switch/try-catch/synchronized |
| Code generation | 100% - Annotations, ternary, multi-catch, inner classes |
| APK/DEX/JAR/AAR/ZIP | 100% - Full support |
| Resources (AXML, arsc) | 100% - 1:1 match |
| Kotlin support | 100% - Metadata, name restoration, intrinsics |
| Deobfuscation | 100% - --deobf, ProGuard mappings |
| Variable naming | 85% - JADX parity |

### Performance (56 threads)

| APK Size | jadx-rust | Java JADX | Speedup |
|----------|-----------|-----------|---------|
| Small (10KB) | 0.01s / 6MB | 1.85s / 275MB | **185x faster, 46x less memory** |
| Medium (11MB) | 3.59s / 304MB | 14.97s / 5.5GB | **4x faster, 18x less memory** |
| Large (55MB) | 0.90s / 85MB | 11.93s / 3.4GB | **13x faster, 41x less memory** |

## Quick Start

```bash
# Build
cd crates && cargo build --release -p jadx-cli

# Decompile
./target/release/dexterity -d output/ app.apk

# With deobfuscation
./target/release/dexterity --deobf -d output/ app.apk

# ProGuard mapping
./target/release/dexterity --deobf --mappings-path mapping.txt -d output/ app.apk

# Whitelist packages from deobfuscation
./target/release/dexterity --deobf --deobf-whitelist "android.support.v4.*" -d output/ app.apk

# Save/load deobfuscation aliases (JOBF file)
./target/release/dexterity --deobf --deobf-cfg-file-mode read-or-save -d output/ app.apk

# Gradle project export
./target/release/dexterity -e -d output/ app.apk

# Parallel threads (default: all cores)
./target/release/dexterity -j 8 -d output/ app.apk
```

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
APK/DEX -> jadx-dex -> jadx-ir -> jadx-passes -> jadx-codegen -> Java Source
                |           |
         jadx-resources  jadx-deobf / jadx-kotlin
```

| Crate | Purpose |
|-------|---------|
| jadx-dex | DEX binary parsing (memory-mapped, all 224 opcodes) |
| jadx-ir | Intermediate representation, class hierarchy |
| jadx-passes | SSA, type inference, region reconstruction |
| jadx-codegen | Java source generation |
| jadx-resources | AXML and resources.arsc decoding |
| jadx-deobf | Deobfuscation, ProGuard parser |
| jadx-kotlin | Kotlin metadata parsing |
| jadx-cli | CLI application |

## Key Features

- **Full multi-core parallelism** - 92.5% core utilization via rayon
- **Lock-free caching** - DashMap for concurrent string cache
- **Lazy instruction loading** - Bounded memory for huge APKs
- **jemalloc allocator** - Optimized for high-concurrency workloads

## Documentation

- [Quality Status](docs/QUALITY_STATUS.md) - Detailed output quality vs Java JADX
- [Roadmap](docs/ROADMAP.md) - Remaining work and implementation plan
- [Changelog](docs/CHANGELOG.md) - Development history and fixes
- [Architecture](crates/AGENTS.md) - Crate structure and design

## Not Yet Implemented

- Smali file (`.smali`) processing
- Warning/rename comments (`/* JADX WARNING: ... */`)

## License

Apache-2.0 (same as JADX)

## Credits

- [skylot/jadx](https://github.com/skylot/jadx) - The original JADX project
