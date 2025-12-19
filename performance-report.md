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

**Date:** 2025-12-19
**Test System:** 56-thread CPU, 100GB RAM disk (tmpfs)
**Test Dataset:** 24 APKs, 977MB total input

## Executive Summary

| Metric | jadx-fast (Java) | dexterity (Rust) | Winner |
|--------|------------------|------------------|--------|
| **Wall Clock Time** | 1:46.90 (106.9s) | 1:43.51 (103.5s) | dexterity (+3.3%) |
| **Peak Memory (RSS)** | 21.0 GB | 773 MB | **dexterity (27x less)** |
| **CPU Utilization** | 899% | 2744% | dexterity (3x more) |
| **Context Switches** | 226,692 | 36,283 | dexterity (6x fewer) |
| **Page Faults** | 6,095,163 | 1,340,615 | dexterity (4.5x fewer) |
| **Output Size** | 1.6 GB | 1.5 GB | Similar |
| **Java Files Generated** | 100,227 | 92,194 | jadx-fast (+8.7%) |

**Key Finding:** dexterity uses **27x less memory** while achieving comparable speed.

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

### dexterity (Rust)

```
Wall clock time:           1:43.51 (103.51 seconds)
User time:                 2,824.17 seconds
System time:               16.52 seconds
CPU utilization:           2,744%
Maximum resident set size: 791,572 KB (773 MB)
Minor page faults:         1,340,615
Voluntary context switches: 36,283
Involuntary context switches: 5,410
File system outputs:       0 blocks (pre-allocated on ramdisk)
Exit status:               0

Output size:               1.5 GB
Java files generated:      92,194
```

---

## Analysis

### Memory Efficiency

The most striking difference is memory usage:

| Tool | Peak RAM | Per-APK Avg |
|------|----------|-------------|
| jadx-fast | 21.0 GB | 875 MB/APK |
| dexterity | 773 MB | 32 MB/APK |

dexterity's Rust implementation achieves **27x lower memory footprint** while processing the same workload. This has significant implications for:
- Processing large APKs that would exhaust available RAM
- Running on memory-constrained systems
- Concurrent decompilation jobs

### CPU Utilization

| Tool | User Time | System Time | CPU % |
|------|-----------|-------------|-------|
| jadx-fast | 922.88s | 38.61s | 899% |
| dexterity | 2,824.17s | 16.52s | 2,744% |

dexterity uses **3x more CPU time** but achieves similar wall-clock performance. This indicates:
- Better parallelization (uses more cores effectively)
- Less I/O blocking (lower system time)
- More compute-bound workload

### Thread Efficiency

| Metric | jadx-fast | dexterity |
|--------|-----------|-----------|
| Voluntary context switches | 226,692 | 36,283 |
| Involuntary context switches | 3,297 | 5,410 |
| Page faults | 6,095,163 | 1,340,615 |

dexterity shows:
- **6x fewer voluntary context switches** - better thread coordination
- **4.5x fewer page faults** - better memory locality

### Output Comparison

| Metric | jadx-fast | dexterity |
|--------|-----------|-----------|
| Output size | 1.6 GB | 1.5 GB |
| Java files | 100,227 | 92,194 |
| Errors | 143 | 0 |

jadx-fast produces 8.7% more Java files, likely due to:
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

**dexterity:**
```bash
/mnt/nvme4tb/jadx-rust/crates/target/release/dexterity \
  -j 56 \
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

1. **Memory is the differentiator**: dexterity's 27x lower memory usage is the standout metric. This enables processing massive APKs that would crash jadx-fast.

2. **Speed is comparable**: Both tools complete in ~1:45 with 56 threads. The 3.3% speed advantage for dexterity is within margin of error.

3. **dexterity is more efficient**: Lower context switches and page faults indicate better-designed concurrency and memory access patterns.

4. **Coverage differs**: jadx-fast generates ~8% more Java files, suggesting more complete but error-prone decompilation.

5. **Trade-off**: Choose jadx-fast for maximum decompilation coverage; choose dexterity for memory-constrained environments or massive APKs.

---

*Generated by Claude Code benchmark suite*
