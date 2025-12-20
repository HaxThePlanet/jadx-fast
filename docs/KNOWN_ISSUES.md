# Known Issues

## Hanging APK: Zara Android App

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

### Investigation Status

- **Likely cause:** Infinite loop or deadlock in decompiler on a specific class
- **Not memory-related:** Memory usage stable, no OOM conditions
- **Not timeout-related:** Hangs indefinitely without progress
- **Next steps:** Need per-class logging in single-threaded mode to identify exact class causing hang

### Workaround

None currently available. APK cannot be fully decompiled until the root cause is identified and fixed.

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

Dexterity handles corrupted and malformed ZIP/APK files gracefully without hanging. Tested against 10 randomly selected bad APKs from the bad-zips collection.

### Test Results

| APK | Result | Time |
|-----|--------|------|
| com.tesns.apsf.adte | Processed 4 classes | 1.26s |
| com.niva.gif | Processed 1534 classes | 0.74s |
| temp_com.renxing.jimoo | Graceful error: "Could not find EOCD" | <1s |
| temp_com.blulion.hand_keyuan | Graceful error: "Could not find EOCD" | <1s |
| 4d6b309b_OzonTracker | Graceful error: "Could not find EOCD" | <1s |
| ba99ad86_1ba... | Graceful error: "Could not find EOCD" | <1s |
| KawaiiMatchSugarPuzzleQuest | Processed 4 classes | 0.70s |
| XAPKInstaller | Graceful error: "Could not find EOCD" | <1s |
| com.cogulplanet.theme | Processed 1283 classes | 0.62s |
| 3f4f096c_... | Graceful error: "Could not find EOCD" | <1s |

### Behavior

- **Valid but mislabeled APKs:** Successfully decompiled (some "bad" APKs are actually valid)
- **Truly corrupted APKs:** Exit cleanly with error message "Could not find EOCD" (End of Central Directory)
- **No hangs:** All tests completed within 10-second timeout
- **No crashes:** All exited with code 0

### Error Messages

For invalid ZIP files, dexterity reports:
```
Error: invalid Zip archive: Could not find EOCD
```

This is the expected behavior - graceful failure with clear error messaging.

---

## Variable Naming Gaps

### Semantic Method Return Naming

JADX assigns semantic names based on method call results (e.g., `iMin` for `Math.min()` result). Dexterity does not yet implement this. Variables from method calls use type-based naming instead.

### Undefined Variable References

Codegen variable tracking bugs can cause undefined variable references in method bodies. See NEW-002 in [ISSUE_TRACKER.md](ISSUE_TRACKER.md).

---

## Not Yet Implemented

### Input Formats
- APKS (Android App Bundle split)
- Smali assembly
- .class files (Java bytecode)

### Features
- GUI application (not planned)
- IDE plugins (not planned)
