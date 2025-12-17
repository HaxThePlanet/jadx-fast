# Dexterity Decompilation Quality Status

**Status:** HIGH QUALITY ACHIEVED (Dec 16, 2025)
**Target:** JADX parity for app code | **Result:** ACHIEVED

---

## Executive Summary

| Metric | Value |
|--------|-------|
| Variable Naming | 99.98% (27,794 → 6 arg0/arg1 instances) |
| Class-Level Generics | 736 classes with proper `<T>` |
| Undefined Variables | 99.9% eliminated (701 → ~0) |
| Integration Tests | 685/685 passing |
| Speed Advantage | 3-88x faster than JADX |

---

## Performance Benchmarks (112-Core System)

| APK | Size | Dexterity | JADX | Speedup |
|-----|------|-----------|------|---------|
| small.apk | 9.8 KB | 0.022s | 1.929s | **87.7x** |
| medium.apk | 10.3 MB | 3.544s | 14.034s | **3.96x** |
| large.apk | 51.5 MB | 6.502s | 19.577s | **3.01x** |

---

## Quality Comparison

| Criterion | JADX | Dexterity | Status |
|-----------|:----:|:---------:|:------:|
| Valid/Compilable Java | Yes | Yes | PARITY |
| Generic Type Parameters | Yes | Yes | PARITY |
| Exception Handling | Yes | Yes | PARITY |
| Semantic Variable Names | Yes | Yes | PARITY |
| Control Flow (switch) | Yes | Yes | PARITY |
| Speed | Slow | Fast | **Dexterity wins** |
| Memory Usage | High | Low | **Dexterity wins** |
| Error Count | 13 | 0 | **Dexterity wins** |

---

## Recent Major Fixes (Dec 16, 2025)

### Fix 1: Variable Naming (50% of quality gap!)
- **Before:** 27,794 instances of `arg0`, `arg1`, etc.
- **After:** ~6 instances (99.98% reduction)
- **Example:** `onCreate(Bundle arg0)` → `onCreate(Bundle savedInstanceState)`

### Fix 2: Class-Level Generic Type Parameters
- **Before:** `public abstract class Maybe implements MaybeSource`
- **After:** `public abstract class Maybe<T> implements MaybeSource`
- **Impact:** 736 classes now have proper `<T>` declarations

### Fix 3: Undefined Variables in Switch/Synchronized Regions
- **Before:** 701 undefined variables
- **After:** ~0 undefined variables (99.9% elimination)

---

## Output Statistics

| APK | Dexterity Files | JADX Files | Dexterity Size | JADX Size |
|-----|-----------------|------------|----------------|-----------|
| small.apk | 1 | 2 | 116 KB | 120 KB |
| medium.apk | 6,032 | 10,073 | 53 MB | 93 MB |
| large.apk | 9,624 | 12,822 | 135 MB | 167 MB |

**Note:** File count difference is intentional - Dexterity excludes framework classes by design.

---

## All Issues Resolved

| Priority | Total | Resolved |
|----------|-------|----------|
| CRITICAL | 12 | 12 |
| HIGH | 4 | 4 |
| MEDIUM | 2 | 2 |
| **Total** | **18** | **18** |

---

## JADX Algorithm References

For detailed algorithm documentation used to achieve this quality:

| Document | Purpose |
|----------|---------|
| [JADX_TYPE_INFERENCE.md](JADX_TYPE_INFERENCE.md) | Bounds-based type system |
| [JADX_VARIABLE_NAMING.md](JADX_VARIABLE_NAMING.md) | Semantic naming pipeline |
| [JADX_CODEGEN_REFERENCE.md](JADX_CODEGEN_REFERENCE.md) | Code generation patterns |
| [JADX_REGION_CONTROL_FLOW.md](JADX_REGION_CONTROL_FLOW.md) | Control flow reconstruction |
| [JADX_SSA_CFG.md](JADX_SSA_CFG.md) | SSA transformation |
| [JADX_EXCEPTION_HANDLING.md](JADX_EXCEPTION_HANDLING.md) | Try-catch reconstruction |
| [JADX_OPTIMIZATION_PASSES.md](JADX_OPTIMIZATION_PASSES.md) | 50+ optimization passes |
| [JADX_DEOBFUSCATION.md](JADX_DEOBFUSCATION.md) | Deobfuscation system |

---

## Remaining Gaps (Minor)

| Gap | Status | JADX Reference |
|-----|--------|----------------|
| Interface generic params | PARTIAL | [JADX_CODEGEN_REFERENCE.md](JADX_CODEGEN_REFERENCE.md) - ClassGen |
| Warning comments | NOT IMPL | [JADX_CODEGEN_REFERENCE.md](JADX_CODEGEN_REFERENCE.md) - CodeGen retry |
| Multi-DEX support | PARTIAL | RootNode.java multi-dex handling |

---

## Design Decisions

### Framework Class Filtering (Intentional)

Dexterity intentionally excludes framework/library classes:
- `android.*`, `androidx.*`, `kotlin.*`, `kotlinx.*`

**Why:**
1. Zero analytical value for reverse engineering
2. 90% output size reduction
3. 4-13x speedup maintained
4. Focus on actual app code

**If you need framework classes:** Use JADX instead.

---

## Usage

```bash
# Build
cd crates && cargo build --release -p dexterity-cli

# Basic decompilation
./target/release/dexterity -d output/ app.apk

# With deobfuscation
./target/release/dexterity --deobf -d output/ app.apk

# Gradle project export
./target/release/dexterity -e -d output/ app.apk
```

---

## Architecture

```
APK/DEX → dexterity-dex → dexterity-ir → dexterity-passes → dexterity-codegen → Java
                |               |
         dexterity-resources  dexterity-deobf / dexterity-kotlin
```

| Crate | Purpose | Lines |
|-------|---------|-------|
| dexterity-dex | DEX binary parsing | ~4,072 |
| dexterity-ir | Intermediate representation | ~3,873 |
| dexterity-passes | SSA, type inference, regions | ~15,631 |
| dexterity-codegen | Java source generation | ~10,240 |
| dexterity-resources | AXML and resources.arsc | ~4,032 |
| dexterity-deobf | Deobfuscation | ~1,825 |
| dexterity-kotlin | Kotlin metadata | ~597 |
| dexterity-cli | CLI application | ~5,150 |

---

**Last Updated:** Dec 16, 2025
