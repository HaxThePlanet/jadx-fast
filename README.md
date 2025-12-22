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

**Goal:** 1:1 identical decompilation output with JADX
**Status:** 5 P0, 4 P1 open | Grade: C+ | Kotlin 100% | Resources 100% | **f.java audit: 4.6% identical** - see [QUALITY_STATUS.md](docs/QUALITY_STATUS.md)

## Performance

Benchmarked on 5 APKs (110 MB total) on 100GB RAM disk (Dec 22, 2025):

| APK | Dexterity (112t) | JADX (56t) | Speedup |
|-----|------------------|------------|---------|
| small.apk | 0.022s | 1.85s | **84x** |
| medium.apk | 1.26s | 14.81s | **11.8x** |
| large.apk | 2.60s | 17.08s | **6.6x** |
| badboy.apk | 0.23s | 14.07s | **61x** |
| badboy-x86.apk | 0.21s | 13.71s | **65x** |
| **Total** | **4.32s** | **61.52s** | **14.2x** |

**Key advantages:**
- **14x faster** than JADX overall (up to 84x on small APKs)
- **28x less memory** (758 MB vs 21 GB on 24 APK benchmark)
- **Zero errors** (0 vs 54 JADX errors on 5 APK benchmark)
- Scales to 112 threads (56 cores + hyperthreading)
- See [PERFORMANCE.md](docs/PERFORMANCE.md) for detailed benchmarks

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
- **Kotlin support:** Full metadata parsing (100% parity with JADX's kotlin-metadata plugin)
  - Class modifiers: `/* data */`, `/* sealed */`, `/* value */`
  - Function modifiers: `/* suspend */`, `/* inline */`, `/* operator */`, `/* infix */`, `/* tailrec */`
  - Type variance: `<out R>`, `<in T>` from Kotlin metadata
  - Name restoration from obfuscated code
  - Static field inline initialization (`INSTANCE = new ClassName()`)
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

```
                    ┌─────────────────── DEXTERITY ───────────────────┐
                    │                                                 │
   ┌─────────┐      │  ┌─────┐   ┌────┐   ┌────────┐   ┌─────────┐   │   ┌──────────┐
   │ APK/DEX │─────▶│  │ dex │──▶│ IR │──▶│ passes │──▶│ codegen │───│──▶│   .java  │
   └─────────┘      │  └─────┘   └────┘   └────────┘   └─────────┘   │   └──────────┘
                    │   parse    build     optimize     emit java    │
                    │            (IR = Intermediate Representation)  │
                    └─────────────────────────────────────────────────┘

   ╔═══════════════════════════════════════════════════════════════════════════════╗
   ║  JADX (Java)                         Dexterity (Rust)                         ║
   ╠═══════════════════════════════════════════════════════════════════════════════╣
   ║  InputFile.java          ─────▶      dexterity-dex     (DEX parsing)          ║
   ║  MethodNode.java         ─────▶      dexterity-ir      (SSA, CFG)             ║
   ║  RegionMaker.java        ─────▶      dexterity-passes  (20+ transforms)       ║
   ║  InsnGen.java            ─────▶      dexterity-codegen (Java emission)        ║
   ║  ResourcesLoader.java    ─────▶      dexterity-resources                      ║
   ║  kotlin-metadata plugin  ─────▶      dexterity-kotlin  (100% parity)          ║
   ╚═══════════════════════════════════════════════════════════════════════════════╝
```

| Crate | Purpose | Parity |
|-------|---------|--------|
| dexterity-dex | DEX binary parsing | 100% |
| dexterity-ir | Intermediate representation | 100% |
| dexterity-passes | Decompilation passes | 85% |
| dexterity-codegen | Java source generation | 85% |
| dexterity-resources | Resource decoding | 100% |
| dexterity-deobf | Deobfuscation | 90% |
| dexterity-kotlin | Kotlin metadata | 100% |
| dexterity-llm-postproc | LLM post-processing | N/A |
| dexterity-qa | Quality assurance tooling | N/A |
| dexterity-py | Python bindings | N/A |
| dexterity-cli | CLI application | 95% |

*Feature completeness vs JADX. Overall grade: **B+**. Variable naming: JADX slightly better (0.93 vs 0.70-0.81). See [Quality Status](docs/QUALITY_STATUS.md).*

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
