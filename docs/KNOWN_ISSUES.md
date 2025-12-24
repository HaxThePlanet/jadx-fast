# Known Issues

**See also:** [ROADMAP.md](ROADMAP.md) for open work and [QUALITY_STATUS.md](QUALITY_STATUS.md) for current status.

---

## f.java Audit Results (Dec 22-24, 2025)

**Status:** 3 P0 BUGS REMAIN after Dec 24 audit (P0-LOOP-VAR, P0-BOOL-CHAIN reopened, P0-WRONG-RETURN new)

A comprehensive comparison of all 151 f.java files between JADX and Dexterity outputs revealed issues that have since been fixed.

| Metric | Count |
|--------|-------|
| Identical files | 7 (4.6%) |
| Different files | 130 (86.1%) |
| Missing (filtered) | 14 (by design) |

### Critical Issues from f.java Audit - ALL FIXED (Dec 24, 2025)

| ID | Issue | Difficulty | Impact | Status |
|----|-------|------------|--------|--------|
| ~~P0-CFG01~~ | ~~Try-catch exception variable scope~~ | HARD | Code in wrong block | ✅ **FIXED** |
| ~~P0-CFG02~~ | ~~Empty if-body for early returns~~ | MEDIUM | Missing return statements | ✅ **FIXED** Dec 22 |
| ~~P0-CFG03~~ | ~~Undefined variables in expressions~~ | HARD | Broken arithmetic | ✅ **FIXED** Dec 23 |
| ~~P0-TYPE01~~ | ~~Double literals as raw long bits~~ | EASY | Wrong values | ✅ **FIXED** Dec 22 |
| ~~P0-CFG04~~ | ~~Complex boolean expressions~~ | MEDIUM | Garbled code | ✅ **FIXED** Dec 22 |
| ~~P1-CFG05~~ | ~~Variables outside exception scope~~ | MEDIUM | Scope issues | ✅ **FIXED** Dec 22 |
| ~~P1-CFG06~~ | ~~Missing if-else branch bodies~~ | MEDIUM | Logic lost | ✅ **FIXED** Dec 22 |
| ~~P1-CFG07~~ | ~~Switch case undefined variables~~ | HARD | Broken switch | ✅ **FIXED** Dec 22-23 |
| ~~P1-ENUM01~~ | ~~Enum reconstruction failures~~ | MEDIUM | Invalid Java | ✅ **FIXED** Dec 22 |

### Example Files

- `io/grpc/j1/f.java` - try-catch and control flow bugs
- `net/time4j/f.java` - enum, switch, double literal bugs
- `com/geetest/sdk/f.java` - boolean expression and branch bugs

All P0 bugs from the f.java audit have been resolved (Dec 24, 2025).

**Note:** Three P0 bugs discovered from badboy APK testing (Dec 24 audit):

| Bug | Status | Issue |
|-----|--------|-------|
| **P0-LOOP-VAR** | ❌ OPEN | For-each body missing `new File(str)` - uses undefined `file` |
| **P0-BOOL-CHAIN** | ❌ REOPENED | Return logic inverted - returns `z=false` when should return `true` |
| **P0-WRONG-RETURN** | ❌ NEW | Methods return `int i` instead of `boolean` |

**Affected file:** `MaliciousPatterns.java` - 12+ compilation errors in isRooted(), checkMagisk(), checkSuBinary(), checkBusybox(), detectEmulator$lambda$1()

See [ROADMAP.md](ROADMAP.md) for details on all 3 P0 bugs.

---

## INV-001: Hanging APK - Zara Android App

**APK:** `419955240b7c62b61832a62f6e8c28650a19830f0f75ff3c2abe290ecb158484.apk`
**Package:** `com.inditex.zara` v16.0.2 (versionCode 26001213)
**Size:** 45 MB
**Issue:** Dexterity hangs during decompilation on DEX file 2 (classes2.dex)

### Symptoms

- Processes first 3 DEX files successfully
- Hangs indefinitely during processing of classes2.dex around class index 1000-2000
- Memory usage stable at ~9.6 GB (not an OOM issue)
- Occurs in both single-threaded (`-j 1`) and multi-threaded modes
- Process must be killed with SIGTERM (exit 124) or OOM killer (exit 137)

### APK Details

```
DEX files: 4 (classes.dex, classes2.dex, classes3.dex, classes4.dex)
Total classes: ~40,000
Resource XMLs: 2,949
Raw files: 360
SDK: targetSdkVersion 35, minSdkVersion 26
```

### Reproduction

```bash
# Single-threaded mode (easier to debug)
timeout 120 ./target/release/dexterity -j 1 -d /tmp/output \
  419955240b7c62b61832a62f6e8c28650a19830f0f75ff3c2abe290ecb158484.apk

# Multi-threaded mode
timeout 120 ./target/release/dexterity -d /tmp/output \
  419955240b7c62b61832a62f6e8c28650a19830f0f75ff3c2abe290ecb158484.apk
```

### Observed Behavior

```
DEX 0 (classes.dex): 8,832 classes processed successfully in 2.39s
DEX 1 (classes2.dex): First 1,000 classes processed
DEX 1 (classes2.dex): Hangs between class 1000-2000
Process becomes unresponsive, timeout required
```

### Investigation Status (Dec 20, 2025)

- **Name generation loops verified safe:** All variable/parameter naming loops match JADX exactly (unbounded `while` loops that are guaranteed to terminate since the set is finite and suffix increments)
- **Large APK testing passed:** Successfully decompiled 647MB APK with 47,674 classes across 12 DEX files in 20.29s with 0 errors
- **Existing safety limits:** Region builder has 20× block count iteration budget, SSA has 10× block count + 1000 limit
- **Not memory-related:** Memory usage stable, no OOM conditions
- **Likely cause:** Complex control flow in a specific class triggering edge case in CFG reconstruction or region building
- **APK not available for testing:** The specific Zara APK (hash `419955240b...`) was not found in test directories

### Workaround

If you encounter this APK:
1. Use `--single-class` to skip problematic classes
2. Use `--include-framework=false` (default) to reduce class count
3. Try with `-j 1` for easier debugging with per-class logging

### Technical Details

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

---

## Expected Warning: Fake DEX Files in badboy.apk

**APK:** `badboy.apk` / `badboy-x86.apk`
**Issue:** Warnings about corrupted DEX files in assets folder

### Symptoms

When decompiling badboy.apk, dexterity logs these warnings:
```
WARN Failed to process assets/classes.dex: Unexpected end of data at offset 0, needed 112 bytes
WARN Failed to process assets/payload.dex: Unexpected end of data at offset 0, needed 112 bytes
```

### Explanation

These warnings are **expected and informational**. The files are intentionally fake:

| File | Size | Actual Content | Purpose |
|------|------|----------------|---------|
| `assets/classes.dex` | 10 bytes | JPEG image header (`FFD8 FFE0...`) | Obfuscation/misdirection |
| `assets/payload.dex` | 4 bytes | ASCII text `dex\n` | Placeholder stub |

### Why This Happens

Some APKs include fake DEX files in the assets folder as an **anti-reverse-engineering technique**:
- Files named `.dex` trick automated tools into attempting DEX parsing
- The actual content is garbage data, JPEG headers, or minimal stubs
- Goal: Confuse reverse engineers and waste analysis time

### Dexterity's Behavior

Dexterity **intentionally attempts to parse all `.dex` files** regardless of location because:
1. Some apps legitimately load DEX files from assets at runtime (dynamic code loading)
2. Warnings inform analysts that these "DEX files" are fake/corrupted
3. Processing continues successfully after logging the warning
4. The fake files are still extracted to `resources/assets/` for manual inspection

### Not a Bug

This behavior is by design. The warnings provide useful forensic information to reverse engineers analyzing obfuscated or potentially malicious APKs.

---

## Bad ZIP Files - Graceful Handling Verified

**Status:** PASS (Dec 20, 2025)
**Test Set:** `/mnt/apkzoo/bad-zips/` (2,203 malformed APK files)

### Summary

Dexterity handles corrupted and malformed ZIP/APK files gracefully. Tested against 50 randomly selected APKs from the bad-zips collection.

### Test Results (n=50)

| Category | Count | Percentage |
|----------|-------|------------|
| Valid (decompilable) | 14 | 28% |
| Invalid (graceful error) | 34 | 68% |
| Timeout (>15s) | 2 | 4% |

### ZIP Trick Resilience

Many "bad" APKs use ZIP parsing tricks for anti-RE purposes. Dexterity successfully handles:

| Trick Type | Example | Result |
|------------|---------|--------|
| **APKM bundles** | Nested split APKs | ✅ Decompiled (1,000-8,000+ classes) |
| **Bad magic number** | Central directory corruption | ✅ Decompiled 1,334 classes |
| **Corrupt extra fields** | Malformed ZIP64 extensions | ✅ Graceful error |
| **Missing EOCD** | Truncated/fake ZIP | ✅ Graceful error |
| **Fake .apk extension** | Non-ZIP files renamed | ✅ Graceful error |

### Behavior

- **ZIP-tricked APKs:** Successfully decompiled when underlying DEX is valid
- **Truly corrupted APKs:** Exit cleanly with "Could not find EOCD" error
- **96% complete without hanging:** 48/50 finished within 15-second timeout
- **All exits clean:** No crashes, graceful error handling

### Known Timeout Cases

2 APKs caused timeout (>15s). These may indicate edge cases to investigate:
- `93fe587a5a60a380d9a2d5f335d3e17a86c2c0d8_Bad_ZIP_file__File_is_not_a_zip_file.apk`
- `com.joym.legendhero.samsung_v25.0.0_code220_Bad_ZIP_file__File_is_not_a_zip_file.apk`

### Error Messages

For invalid ZIP files, dexterity reports:
```
Error: invalid Zip archive: Could not find EOCD
```

This is the expected behavior - graceful failure with clear error messaging.

---

## GAP-002: Variable Naming Gaps - FIXED

**Status:** FIXED (Dec 21, 2025)

Previously, Dexterity variable naming quality was 0.70-0.81 vs JADX 0.93. This has been addressed with:

- **OBJ_ALIAS exact matching** - Changed from contains() to exact FQN matching
- **GOOD_VAR_NAMES set** - 13 mappings (JADX has 5): size, length, list, map, next, prev, current, key, value, entries, keys, values
- **toString() handling** - Returns declaring class name (e.g., Pattern.toString() -> "pattern")
- **Type+method fallback** - make_type_method_name() (e.g., Pattern.compile() -> "patternCompile")

These fixes were applied Dec 21, 2025.

### Undefined Variable References (Fixed)

Previously, codegen variable tracking bugs caused undefined variable references. Fixed as NEW-002 - PHI variables now get constant initializers.

---

## Not Yet Implemented

### Input Formats
- APKS (Android App Bundle split)
- Smali assembly
- .class files (Java bytecode)

### Features
- GUI application (not planned)
- IDE plugins (not planned)
