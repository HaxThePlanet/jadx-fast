# Dexterity Performance Optimization Plan

This document outlines future performance optimization opportunities identified through profiling on high-core-count NUMA systems.

## User Context

- **Target APKs**: Multi-DEX (2-8 DEX files) - large apps like Spotify, Facebook
- **Hardware**: Dual socket / Threadripper / EPYC (NUMA system)
- **Approach**: Profile first, then optimize

## Current State Summary

Based on exploration of the codebase:
- **Architecture**: Rayon work-stealing with per-class parallelization
- **Current performance**: ~4.3s for 862MB APK (56 physical cores)
- **Memory**: 773MB peak (27x better than JADX's 21GB)
- **Key files**: `crates/dexterity-cli/src/main.rs`, `crates/dexterity-codegen/src/dex_info.rs`

---

## PHASE 1: PROFILING

### 1.1 Wall Clock Baseline

```bash
# Get baseline timing with detailed stats
/usr/bin/time -v ./target/release/dexterity -d /tmp/out /path/to/multi-dex.apk 2>&1 | tee baseline.txt

# Key metrics to capture:
# - Elapsed (wall clock) time
# - Maximum resident set size (peak memory)
# - Voluntary/involuntary context switches
# - File system inputs/outputs
```

### 1.2 CPU Profiling (Where is time spent?)

```bash
# Sampling profiler - low overhead, identifies hot functions
perf record -g --call-graph dwarf -F 997 ./target/release/dexterity -d /tmp/out /path/to/apk
perf report --no-children --sort=dso,symbol

# Flamegraph visualization
perf script | stackcollapse-perf.pl | flamegraph.pl > flame.svg
```

### 1.3 NUMA Analysis (Critical for dual-socket systems)

```bash
# Check NUMA topology
numactl --hardware

# Run with NUMA stats
numastat -p $(pgrep dexterity)

# Test NUMA binding - compare these two:
numactl --interleave=all ./target/release/dexterity -d /tmp/out1 /path/to/apk
numactl --membind=0 --cpunodebind=0 ./target/release/dexterity -d /tmp/out2 /path/to/apk

# Check cross-node traffic (high = bad)
perf stat -e node-loads,node-stores,node-load-misses,node-store-misses ./target/release/dexterity ...
```

### 1.4 Lock Contention Analysis

```bash
# Check for lock contention
perf lock record ./target/release/dexterity -d /tmp/out /path/to/apk
perf lock report

# Alternative: use flamegraph with off-CPU time
perf record -g -e sched:sched_switch ./target/release/dexterity ...
```

### 1.5 I/O Analysis

```bash
# Check I/O patterns
strace -c ./target/release/dexterity -d /tmp/out /path/to/apk

# Detailed I/O timing
perf stat -e block:block_rq_issue,block:block_rq_complete ./target/release/dexterity ...

# iotop during run (in separate terminal)
iotop -p $(pgrep dexterity)
```

### 1.6 Allocation Profiling

```bash
# Use heaptrack for allocation analysis
heaptrack ./target/release/dexterity -d /tmp/out /path/to/apk
heaptrack_gui heaptrack.dexterity.*.zst

# Alternative: jemalloc's built-in profiling
MALLOC_CONF=prof:true,prof_prefix:jeprof ./target/release/dexterity ...
jeprof --svg ./target/release/dexterity jeprof.*.heap > alloc.svg
```

---

## Top Performance Optimization Ideas

### P0: HIGH IMPACT - Parallel Improvements

#### 1. Parallel DEX Parsing for Multi-DEX APKs

**Current**: DEX files parsed sequentially (one at a time)
**Location**: `main.rs` lines 425-461
**Opportunity**: Modern APKs have 2-8 DEX files. Parsing in parallel could yield 2-4x speedup for this phase.

**Implementation**:
- Create independent `DexReader` instances per DEX file
- Parse all DEX files in parallel using `rayon::par_iter`
- Merge class lists after parallel parsing

**Estimated impact**: 5-15% overall speedup for multi-DEX APKs

#### 2. Parallel Deobfuscation Prepass

**Current**: Sequential for deterministic alias numbering
**Location**: `crates/dexterity-cli/src/deobf.rs` lines 94-300
**Opportunity**: Can parallelize while maintaining determinism using:
- Pre-sort classes alphabetically
- Use `AtomicUsize` for alias counters
- Hash-based partition (classes A-M on thread 1, N-Z on thread 2)

**Estimated impact**: 3-8% for obfuscated APKs with many renamed symbols

#### 3. Parallel Inner Class Processing

**Current**: Inner classes converted inline with outer class
**Location**: `main.rs` lines 1480-1520
**Opportunity**: Large outer classes with 10+ inner classes could benefit from parallel inner class conversion

**Implementation**: Use `rayon::join()` for outer + inner conversion

**Estimated impact**: 2-5% for apps with complex inner class hierarchies

### P1: MEDIUM IMPACT - I/O Optimizations

#### 4. Async/Buffered File Writing

**Current**: Synchronous `std::fs::write()` per class
**Location**: `main.rs` line 1556
**Opportunity**: Use double-buffering or async I/O:
- Thread-local write buffers (64KB-256KB)
- Batch small files into single syscall
- Consider `io_uring` on Linux for async I/O

**Estimated impact**: 3-10% depending on storage speed (bigger impact on NVMe)

#### 5. Memory-Mapped Output

**Current**: File writes via standard fs API
**Opportunity**: Pre-allocate output file with `mmap` + `memcpy`
- Avoids kernel buffer copying
- Better for large output files (>1MB classes)

**Estimated impact**: 2-5% for large codebases

### P2: MEDIUM IMPACT - Memory & Cache Optimizations

#### 6. Arena Allocation for IR

**Current**: Individual heap allocations via jemalloc
**Location**: Throughout `dexterity-ir` crate
**Opportunity**: Use typed arenas (`typed-arena` crate) for:
- Method nodes
- Instruction nodes
- Type descriptors
- Bulk free after codegen (single `drop`)

**Estimated impact**: 5-10% reduction in allocation overhead

#### 7. Lock-Free Method Cache

**Current**: `DashMap<u32, Option<Arc<MethodInfo>>>` with per-shard locks
**Location**: `dex_info.rs` lines 309-572
**Opportunity**: Replace with lock-free concurrent cache:
- `crossbeam-skiplist` or `flurry` (Java ConcurrentHashMap port)
- Better scaling at 56+ cores where DashMap shards may contend

**Estimated impact**: 2-5% at high core counts

#### 8. String Interning Pool

**Current**: Each string duplicated per occurrence
**Opportunity**: Global string interning for:
- Type descriptors (`Ljava/lang/String;`)
- Method names
- Field names
- Use `string-interner` crate with concurrent access

**Estimated impact**: 10-20% memory reduction, 2-5% speed improvement

### P3: ALGORITHMIC OPTIMIZATIONS

#### 9. Lazy Instruction Loading (Already Partial)

**Current**: Instructions loaded on-demand per method
**Location**: `converter.rs` - `load_method_instructions()`
**Opportunity**: Stream instructions directly to codegen without intermediate storage
- Avoid IR materialization for simple methods
- Direct bytecode -> Java code path for trivial getters/setters

**Estimated impact**: 5-10% for apps with many simple methods

#### 10. Code Generation Streaming

**Current**: Build full Java string in memory, then write
**Opportunity**: Stream code directly to file:
- `BufWriter` with 64KB buffer
- Write method-by-method instead of class-at-once
- Reduces peak memory per thread

**Estimated impact**: 2-5% memory, 1-3% speed

### P4: SCALING OPTIMIZATIONS (56+ cores)

#### 11. NUMA-Aware Thread Pinning

**Current**: Rayon distributes work across all cores uniformly
**Opportunity**: For NUMA systems (dual-socket, AMD Threadripper):
- Pin threads to NUMA nodes
- Allocate DEX data near processing threads
- Use `hwloc` crate for topology detection

**Estimated impact**: 10-30% on NUMA systems (minimal on single-socket)

#### 12. Batch Size Tuning

**Current**: Work-stealing with default granularity
**Opportunity**: Tune rayon's `min_len` for `par_iter`:

```rust
class_indices.par_iter()
    .with_min_len(4)  // Process at least 4 classes per steal
    .for_each(...)
```

- Reduces work-stealing overhead for small APKs
- Better cache locality

**Estimated impact**: 1-5% depending on APK size

#### 13. Thread Pool Per-NUMA Zone

**Current**: Single global rayon pool
**Opportunity**: Create separate thread pools per NUMA zone:
- Each zone processes its assigned DEX files
- Minimizes cross-socket memory access

**Estimated impact**: 15-25% on dual-socket systems

---

## Quick Wins (Easy to Implement)

1. **Increase file write buffer size** - Change `BufWriter` default from 8KB to 64KB
2. **Pre-size output vectors** - Avoid reallocations in hot paths
3. **Const-evaluate regex patterns** - Use `lazy_static` or `once_cell` for compiled patterns
4. **Profile-guided optimization (PGO)** - Build with instrumentation, then optimize based on real workloads

---

## Measurement Strategy

Before implementing, benchmark with:

```bash
# Wall clock time
/usr/bin/time -v ./target/release/dexterity -d /tmp/out /path/to/apk

# CPU profiling
perf record -g ./target/release/dexterity ...
perf report

# Memory profiling
heaptrack ./target/release/dexterity ...

# Lock contention
perf lock record ./target/release/dexterity ...
```

---

## Recommended Priority Order (After Profiling)

**For NUMA dual-socket + multi-DEX workloads:**

1. **NUMA awareness** - Likely biggest win for dual-socket; profile first to confirm cross-node traffic
2. **Parallel DEX parsing** - Major win for multi-DEX APKs (2-8 DEX files)
3. **Arena allocation** - Reduces allocation overhead, improves cache locality
4. **Async file writing** - Better I/O pipelining on NVMe
5. **String interning** - Memory + cache efficiency

**Profiling will reveal which is actually the bottleneck:**
- High cross-node misses -> NUMA awareness first
- Hot functions in DEX parsing -> Parallel DEX parsing first
- High allocation overhead -> Arena allocation first
- I/O wait time -> Async file writing first

---

## Files to Modify

| Optimization | Primary Files |
|--------------|---------------|
| Parallel DEX parsing | `main.rs`, `converter.rs` |
| Parallel deobfuscation | `deobf.rs` |
| Async file writing | `main.rs` |
| Arena allocation | `dexterity-ir/src/*.rs` |
| String interning | `dex_info.rs`, `dexterity-ir/src/types.rs` |
| NUMA awareness | `main.rs`, new `numa.rs` module |

---

## Completed Optimizations

- [x] **String interning with Arc<str>** (2025-12-19) - FieldInfo/MethodInfo fields and AliasRegistry values use Arc<str> instead of String, reducing clone costs from ~50ns to ~1ns
- [x] **Physical core count default** (2025-12-19) - Use `num_cpus::get_physical()` instead of `get()` for ~7% speedup
- [x] **Transparent Huge Pages** (2025-12-17) - 8.8% improvement at 56 cores
- [x] **SSA instruction cloning elimination** (2025-12-17) - 19.8% faster at 8 cores
- [x] **GlobalFieldPool DashMap** (2025-12-17) - 10-20% improvement
- [x] **BTreeMap -> Vec in CFG** (2025-12-17) - 2-5% improvement
- [x] **Jemalloc background threads** (2025-12-17) - 5-15% improvement

### Latest Benchmark Results (Dec 2025)

| Metric | Dexterity | JADX | Advantage |
|--------|-----------|------|-----------|
| Time | 14.58s | 21.74s | **1.49x faster** |
| Memory | 574MB | 8.4GB | **14.6x more efficient** |

**Key achievement**: 14.6x memory efficiency makes Dexterity ideal for memory-constrained environments and CI/CD pipelines.

See [PERFORMANCE.md](PERFORMANCE.md) for detailed benchmark results.
