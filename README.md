# jadx-rust

A Rust rewrite of [JADX](https://github.com/skylot/jadx) - the Android DEX/APK decompiler.

## Project Goal

**Produce decompiled Java source code that is byte-for-byte identical to Java JADX output.**

This project reimplements `jadx-core` (the decompilation engine) in Rust. The goal is 1:1 output compatibility with the Java version - not jadx-gui. When complete, you can run both implementations on the same APK and `diff` should show zero differences.

```bash
# Golden file testing strategy
java -jar jadx-cli.jar -d expected/ input.apk
./jadx-rust -d actual/ input.apk
diff -r expected/ actual/  # Goal: empty (byte-for-byte identical)
```

## Current Status

**~22,000 lines of Rust | 166 tests | Full pipeline functional**

| Crate | Lines | Tests | Purpose |
|-------|------:|------:|---------|
| jadx-dex | 3,620 | 28 | DEX binary parsing (all 256 opcodes) |
| jadx-ir | 2,305 | 14 | Intermediate representation |
| jadx-passes | 6,242 | 43 | SSA, type inference, region reconstruction |
| jadx-codegen | 6,500 | 69 | Java source generation |
| jadx-resources | 1,712 | 7 | AXML and resources.arsc decoding |
| jadx-cli | 1,995 | 5 | CLI with all JADX options |

### Sample Output

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

### What's Working

- Full DEX parsing (headers, pools, all 256 Dalvik opcodes)
- Basic block splitting and CFG construction
- Dominator tree computation (Cooper-Harvey-Kennedy)
- SSA transformation with phi nodes
- Type inference with constraint solving
- Region reconstruction (if/else, while/for, switch, try/catch, synchronized)
- Else-if chaining (nested if in else → `else if`)
- ForEach loop detection from iterator patterns
- Ternary operator reconstruction
- Multi-catch exception handling
- Full annotation support (@Override, @Deprecated, custom)
- Name resolution from DEX string/type/field/method pools
- Import generation with simple name usage
- Variable declarations with type-based naming
- Inner class notation (`R$layout` → `R.layout`)
- Anonymous inner class body inlining (`new Runnable() { ... }`)
- Framework class filtering (android.*, kotlin.*, java.*)

### Remaining for 1:1 Match

- Edge cases in deeply nested control flow

## Building

```bash
cd crates && cargo build --release -p jadx-cli
```

## Usage

```bash
# Basic decompilation
./target/release/jadx-rust -d output/ app.apk

# Single class
./target/release/jadx-rust --single-class MainActivity -d output/ app.apk

# Parallel processing
./target/release/jadx-rust -j 16 -d output/ app.apk
```

All 50+ Java JADX CLI options are supported.

## Architecture

```
DEX/APK → jadx-dex (parse) → jadx-ir (IR) → jadx-passes (analyze) → jadx-codegen (emit Java)
```

### Pipeline

1. **jadx-dex**: Memory-mapped DEX parsing (header, strings, types, classes, methods, code)
2. **jadx-ir**: Build IR from Dalvik bytecode (InsnNode, InsnType variants)
3. **jadx-passes**: Transform IR
   - Block splitting (instructions → basic blocks)
   - CFG construction with dominance
   - SSA transformation (phi placement, variable renaming)
   - Type inference (constraint-based with unification)
   - Region reconstruction (CFG → structured if/loop/switch/try)
4. **jadx-codegen**: Emit Java source with name resolution from DEX pools

### Key Design Choices

| Choice | Benefit |
|--------|---------|
| Arena allocation (bumpalo) | Cache-friendly IR, fast cleanup |
| Enum-based IR | No class hierarchy, pattern matching |
| String interning | Deduplicated type/method names |
| Rayon parallelism | Concurrent class processing |
| Memory-mapped I/O | Zero-copy DEX parsing |

## Why Rust?

| Metric | Java JADX | Rust Target |
|--------|-----------|-------------|
| Parse time | baseline | 5-10x faster (zero-copy mmap) |
| Memory usage | 4-8 GB | 1-2 GB (arena allocation) |
| Total time | baseline | 2-4x faster |

## Testing

```bash
cd crates && cargo test
```

Golden file tests compare output against Java JADX to catch any deviation in formatting, whitespace, or structure.

## License

Apache-2.0 (same as JADX)

## Credits

- [skylot/jadx](https://github.com/skylot/jadx) - The original JADX project
- Built with assistance from Claude (Anthropic)
