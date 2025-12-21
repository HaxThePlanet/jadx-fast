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
**Status:** All P0 + P1 + P2 bugs fixed, Kotlin 100%, Phase 1 + Phase 2 complete (Dec 21, 2025) - see [QUALITY_STATUS.md](docs/QUALITY_STATUS.md)

## Performance

Benchmarked on 24 APKs (977 MB total):

| Metric | Dexterity | JADX | Advantage |
|--------|-----------|------|-----------|
| Wall Clock | 101s | 107s | **6% faster** |
| Peak Memory | 758 MB | 21 GB | **28x less** |
| Errors | 0 | 143 | **Zero errors** |

- Scales to 56+ CPU cores (92% efficiency at 16 cores)
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
APK/DEX -> dexterity-dex -> dexterity-ir -> dexterity-passes -> dexterity-codegen -> Java Source
```

| Crate | Purpose | Parity |
|-------|---------|--------|
| dexterity-dex | DEX binary parsing | 100% |
| dexterity-ir | Intermediate representation | 90% |
| dexterity-passes | Decompilation passes | 85% |
| dexterity-codegen | Java source generation | 85% |
| dexterity-resources | Resource decoding | 100% |
| dexterity-deobf | Deobfuscation | 90% |
| dexterity-kotlin | Kotlin metadata | 100% |
| dexterity-cli | CLI application | 95% |

*Feature completeness vs JADX. See [Quality Status](docs/QUALITY_STATUS.md) for APK-specific grades (75-90%).*

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

## License

Apache-2.0 (same as JADX)

## Credits

- [skylot/jadx](https://github.com/skylot/jadx) - The original JADX project

---

<p align="center">
  <b>Reference Implementation:</b> Java JADX v1.5.3 at <code>jadx-fast/</code>
</p>
