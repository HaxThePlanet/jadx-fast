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
**Status:** 🟢 PRODUCTION-READY | 0 P0 Bugs | A-/B+ Grade (85-90%) - see [ROADMAP.md](docs/ROADMAP.md)

> **December 25, 2025 (Christmas Day!):** Production-ready! All P0 bugs fixed. **4-218x faster than JADX** with **10-52x less memory**. Processing **5,200 APKs/hour** at 2.7 sec average. Boolean simplification, lambda suppression (92→55 files), diamond operator (1,254 instances), lambda inlining complete. **TernaryMod region-level pass** now at full JADX parity. Resources at 1:1 JADX parity. **Anti-RE ZIP hardening** recovers 83% of obfuscated APKs.

## Performance

### ⚡ Speed Comparison

```
                              DECOMPILATION TIME (seconds)
    ┌─────────────────────────────────────────────────────────────────────────────┐
    │                                                                             │
    │  small.apk     ▓ 0.01s                                                      │
    │                ░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░ 2.18s   │
    │                                                                    218x ⚡  │
    │                                                                             │
    │  medium.apk    ▓▓▓▓▓▓▓▓ 2.07s                                               │
    │                ░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░ 16.6s   │
    │                                                                      8x ⚡  │
    │                                                                             │
    │  large.apk     ▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓ 4.82s                                       │
    │                ░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░ 19.7s   │
    │                                                                      4x ⚡  │
    │                                                                             │
    │  badboy.apk    ▓ 0.28s                                                      │
    │                ░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░ 15.5s   │
    │                                                                     55x ⚡  │
    └─────────────────────────────────────────────────────────────────────────────┘
                            ▓ Dexterity    ░ JADX
```

### 🧠 Memory Comparison

```
                              PEAK MEMORY USAGE (MB)
    ┌─────────────────────────────────────────────────────────────────────────────┐
    │                                                                             │
    │  small.apk     ▓ 12 MB                                                      │
    │                ░░░░░░░░░░░░░ 267 MB                               22x less  │
    │                                                                             │
    │  medium.apk    ▓▓ 354 MB                                                    │
    │                ░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░ 5,388 MB  │
    │                                                                   15x less  │
    │                                                                             │
    │  large.apk     ▓▓▓ 579 MB                                                   │
    │                ░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░ 6,558 MB  │
    │                                                                   11x less  │
    │                                                                             │
    │  badboy.apk    ▓ 79 MB                                                      │
    │                ░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░ 4,126 MB          │
    │                                                                   52x less  │
    └─────────────────────────────────────────────────────────────────────────────┘
                            ▓ Dexterity    ░ JADX
```

### 📊 Benchmark Summary

| APK | Dexterity | JADX | **Speed** | Dex RAM | JADX RAM | **RAM** |
|-----|-----------|------|-----------|---------|----------|---------|
| small.apk | 0.01s | 2.18s | **218x** ⚡ | 12 MB | 267 MB | **22x less** |
| medium.apk | 2.07s | 16.6s | **8x** ⚡ | 354 MB | 5,388 MB | **15x less** |
| large.apk | 4.82s | 19.7s | **4x** ⚡ | 579 MB | 6,558 MB | **11x less** |
| badboy.apk | 0.28s | 15.5s | **55x** ⚡ | 79 MB | 4,126 MB | **52x less** |
| **TOTAL** | **7.18s** | **54.0s** | **7.5x** ⚡ | **< 1 GB** | **> 6 GB** | **10x less** |

*Benchmarked on 56-core Xeon with NVMe storage (Dec 25, 2025)*

> **TL;DR:** Dexterity is **4-218x faster** and uses **10-52x less memory** than JADX

### Batch Processing Optimization

For processing many APKs, parallel workers outperform single-threaded max-core usage:

| Config | Workers | Threads/Worker | Time (100 APKs, 1.4GB) |
|--------|---------|----------------|------------------------|
| Sequential | 1 | 112 | 3m31s |
| **Optimal** | **7** | **16** | **2m0s** |
| Over-parallel | 10 | 11 | 2m15s |

**Recommendation:** On a 56-core system (112 threads), use **7 parallel workers with 16 threads each**. This is 76% faster than processing one APK at a time with all threads. Too many workers (10+) starves each APK of threads.

See [PERFORMANCE.md](docs/PERFORMANCE.md) for detailed benchmarks

### Throughput at Scale

| Hardware | Cores | Apps/Hour | Avg Time | 1M APKs |
|----------|-------|-----------|----------|---------|
| 2×Xeon 8280 | 56 | **5,200** | 2.7 sec | 8 days |
| Xeon 6780E (projected) | 144 | **~8,500** | ~1.6 sec | ~5 days |

### RAM Disk for Maximum I/O Performance

For fastest decompilation, use a RAM disk for input/output:

```bash
# Create 100GB RAM disk (requires sufficient RAM)
sudo mkdir -p /mnt/ramdisk
sudo mount -t tmpfs -o size=100g tmpfs /mnt/ramdisk

# Copy APKs to RAM disk and decompile there
cp app.apk /mnt/ramdisk/
./target/release/dexterity -d /mnt/ramdisk/output/ /mnt/ramdisk/app.apk

# Benchmarks show 2-3x speedup vs NVMe for I/O-bound operations
```

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
- **Anti-RE ZIP Hardening:** Handles obfuscated APKs (83% success rate on bad APKs)
  - Path traversal protection (JADX JadxZipSecurity.java clone)
  - Compression bomb detection (100x ratio threshold)
  - Fallback ZIP parser recovers corrupted entries
- **Deobfuscation:** ProGuard mappings, JOBF files
- **Kotlin support:** ~85-90% parity (B+ Grade)
  - Class modifiers: `/* data */`, `/* sealed */`, `/* value */` - works
  - Function modifiers: `/* suspend */`, `/* inline */`, `/* operator */` - works
  - Field declarations AND usages: Aliased correctly (FIXED Dec 24)
  - **P2:** Enum constants as raw integers (type inference gap)
- **Control flow:** OR condition merging (`a || b` patterns), short-circuit evaluation
- **Throws declarations:** Parse `dalvik/annotation/Throws` (~26% parity - framework class filtering differences)
- **Resource resolution:** `R.layout.activity_main` (enabled by default)
- **Drop-in JADX replacement:** Same CLI arguments

## Documentation

| Document | Description |
|----------|-------------|
| [Documentation Index](docs/INDEX.md) | Full documentation index |
| [CLI Reference](docs/CLI_REFERENCE.md) | All command-line options |
| [Performance](docs/PERFORMANCE.md) | Detailed benchmarks |
| [Roadmap](docs/ROADMAP.md) | Status, bugs, quality grades, known issues, future work |
| [Architecture](docs/ARCHITECTURE.md) | Crate structure |
| [Design Decisions](docs/DESIGN_DECISIONS.md) | Framework filtering, Compose detection |

## Architecture

<p align="center">
  <img src="docs/architecture.svg" alt="Dexterity Architecture" width="100%">
</p>

| Crate | Purpose | Grade | Notes |
|-------|---------|-------|-------|
| dexterity-dex | DEX binary parsing | **A+** | Verified complete |
| dexterity-ir | Intermediate representation | **A (95%)** | SSA + regions working |
| dexterity-passes | Decompilation passes | **B+ (88%)** | 86/105 JADX passes |
| dexterity-codegen | Java source generation | **A-/B+ (85-90%)** | Production-ready |
| dexterity-resources | Resource decoding | **A+** | 1:1 JADX parity verified |
| dexterity-deobf | Deobfuscation | **A- (90%)** | ProGuard/JOBF working |
| dexterity-kotlin | Kotlin metadata | **B+ (85-90%)** | Field alias references FIXED Dec 24 |
| dexterity-cli | CLI application | **A** | Drop-in JADX replacement, anti-RE hardening |

*Updated Dec 25, 2025. See [ROADMAP.md](docs/ROADMAP.md) for details and remaining work.*

### Recent JADX Pass Clones (Dec 2025)

| Pass | JADX Lines | Description |
|------|------------|-------------|
| `block_exception_handler` | 640 | Exception CFG construction with splitter blocks |
| `debug_info` | 442 | Debug info attach + apply (variable names/types) - **COMPLETE Dec 25** |
| `switch_over_string` | 479 | Java 7+ string switch restoration |
| `synchronized_region` | 184 | Synchronized block handling |
| `fix_multi_entry_loops` | 125 | CFG normalization for loops |
| `process_try_catch_regions` | 127 | Try-catch region wrapping |
| `exc_handlers_region` | 153 | Exception handler regions |
| `class_modifier` | ~300 | Synthetic element hiding |
| `inline_methods` | ~300 | Method inlining |
| `signature_processor` | 337 | Generic type signatures |
| `fix_access_modifiers` | ~120 | Inner class visibility fixes - **COMPLETE Dec 25** |
| `attach_comments` | ~140 | Diagnostic comment attachment - **COMPLETE Dec 25** |

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

Benchmark APKs used for comparison (~8,858 Java files total):

| APK | Files | Description |
|-----|-------|-------------|
| small.apk | 1 | Minimal test case |
| medium.apk | 2,890 | Mid-size application |
| large.apk | 5,901 | Large production app |
| badboy.apk | 55 | Multi-DEX obfuscated |
| badboy-x86.apk | 13 | x86 variant |

To generate comparison output locally:
```bash
# Decompile with both tools
./target/release/dexterity -d output/dexterity/small/ apks/small.apk
jadx -d output/jadx/small/ apks/small.apk

# Compare specific file
diff output/dexterity/large/sources/o/a/b.java output/jadx/large/sources/o/a/b.java
```

## License

Apache-2.0 (same as JADX)

## Credits

- [skylot/jadx](https://github.com/skylot/jadx) - The original JADX project

---

<p align="center">
  <b>Reference Implementation:</b> Java JADX v1.5.3 at <code>jadx-fast/</code>
</p>
