# Performance Benchmark: jadx-fast

## Stock JADX 1.5.3 vs jadx-fast (New Library Filters)

**Date:** 2025-12-19
**Test System:** 56-thread CPU, 100GB RAM disk (tmpfs)
**All I/O on ramdisk** for accurate CPU-bound measurements

### Spotify APK (210MB)

| Metric | Stock JADX 1.5.3 | jadx-fast | Improvement |
|--------|------------------|-----------|-------------|
| Classes processed | 293 | 130 | **-56%** |
| Java files output | 523 | 257 | -51% |
| Wall time | 12.54s | 11.92s | **-5%** |
| CPU time | 69.6s | 46.2s | **-34%** |

### Giant APK (862MB)

| Metric | Stock JADX 1.5.3 | jadx-fast | Improvement |
|--------|------------------|-----------|-------------|
| Classes processed | 2913 | 2203 | **-24%** |
| Java files output | 4594 | 3324 | -28% |
| Wall time | 12.91s | 11.26s | **-13%** |
| CPU time | 266s | 162s | **-39%** |
| Errors | 11 | 8 | -27% |

### New Filters Added

- Google Play Services (`com.google.android.gms`)
- Firebase (`com.google.firebase`)
- Guava (`com.google.common`)
- Square libs (`com.squareup`, `okhttp3`, `retrofit2`)
- Facebook SDK (all `com.facebook.*`)
- Glide, RxJava, Jackson, Apache Commons
- Logging (SLF4J, Logback, Log4j, Timber)

**Key wins:** 13% faster, 39% less CPU, outputs only app code (not library code)

---

# Performance Benchmark: jadx-fast vs dexterity

**Date:** 2025-12-20 (Updated)
**Test System:** 56-thread CPU, 100GB RAM disk (tmpfs)
**Test Dataset:** 24 APKs, 977MB total input

## Executive Summary

| Metric | jadx-fast (Java) | dexterity (Rust) | Winner |
|--------|------------------|------------------|--------|
| **Wall Clock Time** | 1:46.90 (106.9s) | 1:41.01 (101.0s) | **dexterity (+5.8%)** |
| **Peak Memory (RSS)** | 21.0 GB | 758 MB | **dexterity (28x less)** |
| **CPU Utilization** | 899% | 2563% | dexterity (2.9x more) |
| **Context Switches** | 226,692 | 34,464 | dexterity (6.6x fewer) |
| **Page Faults** | 6,095,163 | 1,687,075 | dexterity (3.6x fewer) |
| **Output Size** | 1.6 GB | 1.4 GB | Similar |
| **Java Files Generated** | 100,227 | 85,891 | jadx-fast (+17%) |

**Key Finding:** dexterity uses **28x less memory** and is **5.8% faster** than jadx-fast.

---

## Detailed Results

### jadx-fast (Java)

```
Wall clock time:           1:46.90 (106.9 seconds)
User time:                 922.88 seconds
System time:               38.61 seconds
CPU utilization:           899%
Maximum resident set size: 21,951,040 KB (21.0 GB)
Minor page faults:         6,095,163
Voluntary context switches: 226,692
Involuntary context switches: 3,297
File system outputs:       147,080 blocks
Exit status:               1 (143 decompilation errors)

Classes processed:         103,749
Output size:               1.6 GB
Java files generated:      100,227
```

### dexterity (Rust) - Updated 2025-12-20

```
Wall clock time:           1:41.01 (101.01 seconds avg over 3 runs)
User time:                 2,572.33 seconds (avg)
System time:               17.43 seconds (avg)
CPU utilization:           2,563%
Maximum resident set size: 776,205 KB (758 MB avg)
Minor page faults:         1,687,075
Voluntary context switches: 34,464
Involuntary context switches: 4,766
File system outputs:       0 blocks (pre-allocated on ramdisk)
Exit status:               0

Output size:               1.4 GB
Java files generated:      85,891

Trial breakdown:
  Run 1: 1:42.07 (102.07s), 753 MB
  Run 2: 1:38.66 (98.66s), 778 MB
  Run 3: 1:42.29 (102.29s), 744 MB
```

---

## Analysis

### Memory Efficiency

The most striking difference is memory usage:

| Tool | Peak RAM | Per-APK Avg |
|------|----------|-------------|
| jadx-fast | 21.0 GB | 875 MB/APK |
| dexterity | 758 MB | 32 MB/APK |

dexterity's Rust implementation achieves **28x lower memory footprint** while processing the same workload. This has significant implications for:
- Processing large APKs that would exhaust available RAM
- Running on memory-constrained systems
- Concurrent decompilation jobs

### CPU Utilization

| Tool | User Time | System Time | CPU % |
|------|-----------|-------------|-------|
| jadx-fast | 922.88s | 38.61s | 899% |
| dexterity | 2,572.33s | 17.43s | 2,563% |

dexterity uses **2.8x more CPU time** but achieves faster wall-clock performance. This indicates:
- Better parallelization (uses more cores effectively)
- Less I/O blocking (lower system time)
- More compute-bound workload

### Thread Efficiency

| Metric | jadx-fast | dexterity |
|--------|-----------|-----------|
| Voluntary context switches | 226,692 | 34,464 |
| Involuntary context switches | 3,297 | 4,766 |
| Page faults | 6,095,163 | 1,687,075 |

dexterity shows:
- **6.6x fewer voluntary context switches** - better thread coordination
- **3.6x fewer page faults** - better memory locality

### Output Comparison

| Metric | jadx-fast | dexterity |
|--------|-----------|-----------|
| Output size | 1.6 GB | 1.4 GB |
| Java files | 100,227 | 85,891 |
| Errors | 143 | 0 |

jadx-fast produces 17% more Java files, likely due to:
- Different handling of inner/anonymous classes
- More complete decompilation coverage (also has 143 errors)

---

## Test Configuration

### Commands Used

**jadx-fast:**
```bash
/mnt/nvme4tb/jadx-fast/build/jadx/bin/jadx \
  --threads-count 56 \
  --no-debug-info \
  --no-inline-anonymous \
  --no-inline-methods \
  -d /mnt/ramdisk/benchmark-output-jadx \
  /mnt/ramdisk/benchmark-apks/*.apk
```

**dexterity:** (default settings - auto-detects physical cores)
```bash
/mnt/nvme4tb/dexterity/crates/target/release/dexterity \
  -d /mnt/ramdisk/benchmark-output-dexterity \
  /mnt/ramdisk/benchmark-apks/*.apk
```

### APKs Tested (24 total, 977 MB)

| APK | Size |
|-----|------|
| com.microsoft.appmanager | 109 MB |
| com.azure.authenticator | 103 MB |
| com.raonsecure.mobile.security (v1.7.9) | 95 MB |
| com.kaspersky.safekids | 87 MB |
| com.raonsecure.mobile.security (v1.7.6) | 87 MB |
| com.autoclickrepeater.free | 71 MB |
| com.kaspersky.kes | 57 MB |
| com.teamviewer.quicksupport | 48 MB |
| com.canwin.apps.agentaux | 46 MB |
| credo | 43 MB |
| com.anydesk.* (5 versions) | 25-26 MB each |
| ru.vipnet.client | 25 MB |
| Other smaller APKs | 7-24 MB |

---

## Conclusions

1. **Memory is the differentiator**: dexterity's 28x lower memory usage is the standout metric. This enables processing massive APKs that would crash jadx-fast.

2. **Speed advantage confirmed**: dexterity is now **5.8% faster** (101s vs 107s) with default settings.

3. **dexterity is more efficient**: Lower context switches (6.6x fewer) and page faults (3.6x fewer) indicate better-designed concurrency and memory access patterns.

4. **Coverage differs**: jadx-fast generates ~17% more Java files, suggesting more complete but error-prone decompilation (143 errors vs 0).

5. **Recommendation**: dexterity is now the better choice for most use cases - faster, dramatically less memory, and zero errors.

---

*Generated by Claude Code benchmark suite*
*Last updated: 2025-12-20*
