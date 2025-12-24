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

**Goal:** Correct decompilation close to JADX
**Status:** 0 P0 Bugs | ~80% Syntax Quality | 180% File Coverage - see [ROADMAP.md](docs/ROADMAP.md)

> **Update (Dec 24, 2025):** P0-SYNTHETIC fixed. Dexterity now outputs 180% of JADX files (81 vs 45 for badboy) because lambda classes are not yet inlined (P1-LAMBDA in progress).

## Performance

<p align="center">
  <img src="docs/benchmarks.svg" alt="Dexterity Benchmarks" width="100%">
</p>

<details>
<summary>Detailed benchmark table</summary>

| APK | Dexterity (112t) | JADX (56t) | Speedup |
|-----|------------------|------------|---------|
| small.apk | 0.022s | 1.85s | **84x** |
| medium.apk | 1.26s | 14.81s | **11.8x** |
| large.apk | 2.60s | 17.08s | **6.6x** |
| badboy.apk | 0.23s | 14.07s | **61x** |
| badboy-x86.apk | 0.21s | 13.71s | **65x** |
| **Total** | **4.32s** | **61.52s** | **14.2x** |

*Benchmarked on 100GB RAM disk (Dec 22, 2025)*

</details>

### Batch Processing Optimization

For processing many APKs, parallel workers outperform single-threaded max-core usage:

| Config | Workers | Threads/Worker | Time (100 APKs, 1.4GB) |
|--------|---------|----------------|------------------------|
| Sequential | 1 | 112 | 3m31s |
| **Optimal** | **7** | **16** | **2m0s** |
| Over-parallel | 10 | 11 | 2m15s |

**Recommendation:** On a 56-core system (112 threads), use **7 parallel workers with 16 threads each**. This is 76% faster than processing one APK at a time with all threads. Too many workers (10+) starves each APK of threads.

See [PERFORMANCE.md](docs/PERFORMANCE.md) for detailed benchmarks

## Quick Start

```bash
# Build
cd crates
cargo build --release -p dexterity-cli

# Decompile an APK
./target/release/dexterity -d output/ app.apk

# With deobfuscation
./target/release/dexterity --deobf -d output/ app.apk

# Export as Gradle project
./target/release/dexterity -e -d output/ app.apk
```

## Key Features

- **Input formats:** APK, DEX, JAR, AAR, AAB, XAPK, APKM (APKS not yet supported)
- **Deobfuscation:** ProGuard mappings, JOBF files
- **Kotlin support:** ~85-90% parity (B+ Grade)
  - Class modifiers: `/* data */`, `/* sealed */`, `/* value */` - works
  - Function modifiers: `/* suspend */`, `/* inline */`, `/* operator */` - works
  - Field declarations AND usages: Aliased correctly (FIXED Dec 24)
  - **P2:** Enum constants as raw integers (type inference gap)
- **Control flow:** OR condition merging (`a || b` patterns), short-circuit evaluation
- **Throws declarations:** Parse `dalvik/annotation/Throws` (41.7% parity, 3x improvement)
- **Resource resolution:** `R.layout.activity_main` (enabled by default)
- **Drop-in JADX replacement:** Same CLI arguments

## Documentation

| Document | Description |
|----------|-------------|
| [Documentation Index](docs/INDEX.md) | Full documentation index |
| [CLI Reference](docs/CLI_REFERENCE.md) | All command-line options |
| [Performance](docs/PERFORMANCE.md) | Detailed benchmarks |
| [Quality Status](docs/QUALITY_STATUS.md) | Current quality grades |
| [Architecture](docs/ARCHITECTURE.md) | Crate structure |
| [Design Decisions](docs/DESIGN_DECISIONS.md) | Framework filtering, Compose detection |
| [Known Issues](docs/KNOWN_ISSUES.md) | Limitations and workarounds |
| [Roadmap](docs/ROADMAP.md) | Future work |

## Architecture

<p align="center">
  <img src="docs/architecture.svg" alt="Dexterity Architecture" width="100%">
</p>

| Crate | Purpose | Grade | Notes |
|-------|---------|-------|-------|
| dexterity-dex | DEX binary parsing | **A+** | Verified complete |
| dexterity-ir | Intermediate representation | **B (85%)** | SSA + regions working |
| dexterity-passes | Decompilation passes | **B- (80%)** | 86/105 JADX passes |
| dexterity-codegen | Java source generation | **B- (80%)** | Syntax quality; file coverage gap |
| dexterity-resources | Resource decoding | **A+** | 1:1 JADX parity verified |
| dexterity-deobf | Deobfuscation | **B (85%)** | ProGuard/JOBF working |
| dexterity-kotlin | Kotlin metadata | **C (70%)** | Field decl aliased; usages P1 bug |
| dexterity-cli | CLI application | **A** | Drop-in JADX replacement |

*Updated Dec 24, 2025. See [QUALITY_STATUS.md](docs/QUALITY_STATUS.md) for details, [ROADMAP.md](docs/ROADMAP.md) for P0/P1 bugs.*

### Recent JADX Pass Clones (Dec 2025)

| Pass | JADX Lines | Description |
|------|------------|-------------|
| `block_exception_handler` | 640 | Exception CFG construction with splitter blocks |
| `debug_info` | 442 | Debug info attach + apply (variable names/types) |
| `switch_over_string` | 479 | Java 7+ string switch restoration |
| `synchronized_region` | 184 | Synchronized block handling |
| `fix_multi_entry_loops` | 125 | CFG normalization for loops |
| `process_try_catch_regions` | 127 | Try-catch region wrapping |
| `exc_handlers_region` | 153 | Exception handler regions |
| `class_modifier` | ~300 | Synthetic element hiding |
| `inline_methods` | ~300 | Method inlining |
| `signature_processor` | 337 | Generic type signatures |

See [JADX_CLONE_TASKS.md](docs/JADX_CLONE_TASKS.md) for complete clone specifications with JADX line references.

## Sample Output

```java
package io.github.skylot.android.smallapp;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i("SmallApp", "Hello");
    }
}
```

## Reference Output Examples

Comparison examples of Dexterity vs JADX decompilation output (~8,858 Java files total):

- **Small APK** (1 file)
  - [Dexterity output](output/dexterity/small/sources/) | [JADX output](output/jadx/small/sources/)

- **Medium APK** (2,890 files)
  - [Dexterity output](output/dexterity/medium/sources/) | [JADX output](output/jadx/medium/sources/)

- **Large APK** (5,901 files)
  - [Dexterity output](output/dexterity/large/sources/) | [JADX output](output/jadx/large/sources/)

- **Badboy APK** (53 files)
  - [Dexterity output](output/dexterity/badboy/sources/) | [JADX output](output/jadx/badboy/sources/)

- **Badboy-x86 APK** (13 files)
  - [Dexterity output](output/dexterity/badboy-x86/sources/) | [JADX output](output/jadx/badboy-x86/sources/)

Notable reference file: [o/a/b.java](output/dexterity/large/sources/o/a/b.java) (Dexterity) vs [o/a/b.java](output/jadx/large/sources/o/a/b.java) (JADX)

## License

Apache-2.0 (same as JADX)

## Credits

- [skylot/jadx](https://github.com/skylot/jadx) - The original JADX project

---

<p align="center">
  <b>Reference Implementation:</b> Java JADX v1.5.3 at <code>jadx-fast/</code>
</p>
