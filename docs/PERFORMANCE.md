# Dexterity Performance Analysis & Optimization Guide

This document catalogs performance bottlenecks identified in the Dexterity decompiler for high-core-count systems (56+ cores). The goal is to achieve near-linear scaling without sacrificing output quality.

**Current State**: Scales well to ~16 cores, diminishing returns beyond
**Target State**: Linear scaling to 56+ cores
**Analysis Date**: 2025-12-17

---

## Table of Contents

1. [Executive Summary](#executive-summary)
2. [Architecture Overview](#architecture-overview)
3. [P0 Critical Bottlenecks](#p0-critical-bottlenecks)
4. [P1 High Priority Bottlenecks](#p1-high-priority-bottlenecks)
5. [P2 Medium Priority Bottlenecks](#p2-medium-priority-bottlenecks)
6. [P3 Low Priority Bottlenecks](#p3-low-priority-bottlenecks)
7. [Quick Wins Summary](#quick-wins-summary)
8. [Profiling Guide](#profiling-guide)
9. [Implementation Status](#implementation-status)

---

## Executive Summary

### Top 3 Scaling Blockers

| Rank | Issue | Location | Impact |
|------|-------|----------|--------|
| 1 | GlobalFieldPool RwLock write contention | `dex_info.rs:93` | All threads serialize on field lookups |
| 2 | res_names HashMap cloned per class | `main.rs:1457` | Thousands of allocations in parallel loop |
| 3 | Progress bar Mutex contention | `main.rs:1522` | Every class update hits indicatif lock |

### Estimated Gains from Quick Wins

| Fix | Estimated Improvement |
|-----|----------------------|
| RwLock → DashMap in GlobalFieldPool | 10-20% |
| Arc wrap for res_names | 5-10% |
| Batch progress bar updates | 5-15% |
| BTreeMap → FxHashMap in block_split | 2-5% |
| Increase memory checkpoint interval | 1-3% |

---

## Architecture Overview

### Parallelism Infrastructure

Dexterity uses **Rayon** for parallelism with work-stealing scheduling:

```
┌─────────────────────────────────────────────────────────────────┐
│                        SEQUENTIAL PHASES                         │
├─────────────────────────────────────────────────────────────────┤
│ 1. DEX File Extraction (ZIP read)                               │
│ 2. DEX Header Parsing                                           │
│ 3. Deobfuscation Prepass (deterministic alias generation)       │
│ 4. Class Hierarchy Building                                     │
│ 5. Kotlin Metadata Prepass                                      │
│ 6. Inner Class Map Building                                     │
└─────────────────────────────────────────────────────────────────┘
                              │
                              ▼
┌─────────────────────────────────────────────────────────────────┐
│                        PARALLEL PHASES                           │
├─────────────────────────────────────────────────────────────────┤
│ 1. String Pre-loading (100K chunks, DashMap cache)              │
│ 2. Directory Pre-creation (parallel mkdir)                      │
│ 3. Class Processing (main workload - N threads)                 │
│    └─ Per-class: Parse → SSA → Type Infer → Simplify → Codegen │
└─────────────────────────────────────────────────────────────────┘
```

### Shared State Patterns

| Pattern | Usage | Scaling |
|---------|-------|---------|
| `Arc<T>` (immutable) | ClassHierarchy, inner_class_map | Excellent |
| `DashMap` (lock-free) | AliasRegistry, string cache | Good |
| `RwLock<HashMap>` | GlobalFieldPool | **Poor** - write contention |
| `AtomicUsize` | Counters | Good with Relaxed ordering |
| Clone per iteration | res_names HashMap | **Poor** - allocation overhead |

---

## P0 Critical Bottlenecks

These create serialization points that prevent scaling beyond 16 cores.

### P0-1: GlobalFieldPool RwLock Write Contention

**Location**: `crates/dexterity-codegen/src/dex_info.rs:93-99`

**Problem**: Every field lookup acquires a WRITE lock for deduplication:

```rust
// Current implementation - ALL threads serialize here
pub fn get_or_cache(&self, field: FieldInfo) -> FieldInfo {
    let mut pool = self.fields.write();  // WRITE LOCK - blocks all readers
    if let Some(existing) = pool.get(&key) {
        existing.clone()
    } else {
        pool.insert(key, field.clone());
        field
    }
}
```

**Impact**:
- All 56 threads contend on single RwLock
- Write lock blocks ALL readers, creating global serialization
- Called for every field reference during code generation

**Solution**: Replace `RwLock<HashMap>` with `DashMap`:

```rust
// Proposed fix
pub struct GlobalFieldPool {
    fields: DashMap<FieldKey, FieldInfo>,  // Lock-free concurrent access
}

pub fn get_or_cache(&self, field: FieldInfo) -> FieldInfo {
    let key = FieldKey::from(&field);
    self.fields.entry(key).or_insert_with(|| field.clone()).clone()
}
```

**Estimated Gain**: 10-20%

---

### P0-2: res_names HashMap Clone Per Class

**Location**: `crates/dexterity-cli/src/main.rs:1457`

**Problem**: Full HashMap cloned for every class in the parallel loop:

```rust
// Inside par_iter().for_each()
let config = ClassConfig {
    res_names: res_names.clone(),  // CLONES ENTIRE HASHMAP
    // ... other fields
};
```

**Impact**:
- HashMap may contain thousands of resource name mappings
- Cloned once per outer class (potentially 50K+ times)
- Causes excessive allocation and cache thrashing

**Solution**: Wrap in `Arc<HashMap>`:

```rust
// Before parallel loop
let res_names = Arc::new(res_names);

// Inside par_iter().for_each()
let config = ClassConfig {
    res_names: Arc::clone(&res_names),  // Just bumps refcount
    // ...
};
```

**Estimated Gain**: 5-10%

---

### P0-3: Progress Bar Mutex Contention

**Location**: `crates/dexterity-cli/src/main.rs:1522-1523`

**Problem**: `indicatif` progress bar uses internal Mutex, called per-class:

```rust
// Called by all 56 threads for every class
if let Some(pb) = progress_ref {
    pb.inc(1);  // indicatif uses Mutex internally
}
```

**Impact**:
- Every class update contends on indicatif's internal lock
- With 50K classes, this creates 50K lock acquisitions
- Serializes otherwise parallel work

**Solution**: Batch updates using thread-local counter:

```rust
// Option 1: Batch updates
thread_local! {
    static LOCAL_COUNT: Cell<usize> = Cell::new(0);
}

// Only update progress bar every N classes
LOCAL_COUNT.with(|c| {
    let count = c.get() + 1;
    c.set(count);
    if count % 100 == 0 {
        if let Some(pb) = progress_ref {
            pb.inc(100);
        }
    }
});

// Option 2: Disable progress bar in high-perf mode
// Use --no-progress flag
```

**Estimated Gain**: 5-15%

---

## P1 High Priority Bottlenecks

Major throughput limiters that reduce overall efficiency.

### P1-1: SSA Instruction Block Cloning - FIXED (Dec 2025)

**Location**: `crates/dexterity-passes/src/ssa.rs`

**Problem**: Every block's instructions were being cloned during SSA transformation:

```rust
// OLD: transform_to_ssa() cloned 500K+ instruction vectors
SsaBlock {
    instructions: block.instructions.clone(),  // CLONE per block - 7-10GB allocations!
    successors: block.successors.clone(),
    predecessors: block.predecessors.clone(),
}
```

**Impact**:
- O(N) memory allocation where N = instruction count
- Large APKs with 500K+ instructions caused 7-10 GB allocation pressure
- Ran once per method, creating significant overhead
- Bottleneck preventing superlinear scaling at 4-8 cores

**Solution**: Use `transform_to_ssa_owned()` to move instructions without cloning:

```rust
// NEW: transform_to_ssa_owned() moves instructions - zero allocation overhead
// Instructions are moved from CFG blocks to SSA blocks instead of cloned
```

**Results**:
- **19.8% faster at 8 cores** (15.04s vs 18.75s)
- **Superlinear scaling restored** (101% efficiency at 4-8 cores)
- **7-10 GB allocation pressure eliminated**
- All 685 integration tests passing

**Status**: FIXED - Dec 2025

---

### P1-2: Type Inference 5000 Variable Limit

**Location**: `crates/dexterity-passes/src/type_inference.rs:336,398`

**Problem**: Hard limit causes panic on complex methods:

```rust
fn fresh_var(&mut self) -> TypeVar {
    const VARS_PROCESS_LIMIT: u32 = 5000;
    if self.next_var >= VARS_PROCESS_LIMIT {
        panic!("Type inference variable limit exceeded");
    }
    // ...
}
```

**Impact**:
- Large obfuscated methods hit this limit
- Causes complete abort instead of graceful degradation
- Common in heavily obfuscated APKs

**Solution**: Implement variable pooling or incremental resolution:

```rust
// Option 1: Increase limit with fallback
const VARS_SOFT_LIMIT: u32 = 5000;
const VARS_HARD_LIMIT: u32 = 50000;

if self.next_var >= VARS_SOFT_LIMIT {
    // Switch to simplified type inference
}

// Option 2: Reuse type variables for identical constraints
```

**Estimated Gain**: Prevents crashes on complex methods

---

### P1-3: BTreeMap in Block Splitting (O(log N) vs O(1))

**Location**: `crates/dexterity-passes/src/block_split.rs:121,147,171`

**Problem**: Uses BTreeMap/BTreeSet when HashMap would suffice:

```rust
let mut leaders = BTreeSet::new();
let mut offset_to_idx: BTreeMap<u32, usize> = BTreeMap::new();
let mut offset_to_block: BTreeMap<u32, u32> = BTreeMap::new();
```

**Impact**:
- O(log N) per insertion vs O(1) for HashMap
- Hundreds of insertions per method
- Order only needed for final iteration

**Solution**: Use FxHashMap, convert to sorted only when needed:

```rust
use rustc_hash::FxHashSet;

let mut leaders = FxHashSet::default();
let mut offset_to_idx: FxHashMap<u32, usize> = FxHashMap::default();

// Only sort when iteration order matters
let mut sorted_leaders: Vec<_> = leaders.into_iter().collect();
sorted_leaders.sort_unstable();
```

**Estimated Gain**: 2-5%

---

### P1-4: Sequential DEX File Processing

**Location**: `crates/dexterity-cli/src/main.rs:412-431`

**Problem**: Multi-DEX APKs processed one DEX at a time:

```rust
for (dex_idx, dex_name) in dex_file_names.iter().enumerate() {
    // Process DEX sequentially - 55 cores sit idle
    match process_dex_bytes(...) { ... }
}
```

**Impact**:
- Only affects multi-DEX APKs (common for large apps)
- 55 cores idle during DEX parsing phase
- Can add seconds to processing time

**Solution**: Parallel DEX extraction with deferred merge:

```rust
let dex_results: Vec<_> = dex_file_names
    .par_iter()
    .enumerate()
    .map(|(idx, name)| process_dex_bytes(idx, name, ...))
    .collect();

// Merge results sequentially (fast)
for result in dex_results { ... }
```

**Estimated Gain**: Significant for multi-DEX APKs

---

### P1-5: Memory Checkpoint Logging Every 100 Classes

**Location**: `crates/dexterity-cli/src/main.rs:1346-1349`

**Problem**: Debug logging blocks parallel execution:

```rust
let pc = processed_count.fetch_add(1, std::sync::atomic::Ordering::Relaxed);
if pc % 100 == 0 {
    let mem = get_mem_mb();
    eprintln!("MEM[class {}]: {} MB", pc, mem);  // SYSCALL - blocks thread
}
```

**Impact**:
- `eprintln!()` is a syscall that blocks the thread
- Happens every 100 classes
- Creates unnecessary serialization

**Solution**: Increase interval or make async:

```rust
// Option 1: Increase interval
if pc % 10000 == 0 { ... }

// Option 2: Disable in release mode
#[cfg(debug_assertions)]
if pc % 100 == 0 { ... }

// Option 3: Use async logging
```

**Estimated Gain**: 1-3%

---

## P2 Medium Priority Bottlenecks

### P2-1: Unbuffered File Writes

**Location**: `crates/dexterity-cli/src/main.rs:1517`

**Problem**: Each file write is an unbuffered syscall:

```rust
std::fs::write(&out_path, java_code)  // Syscall per class
```

**Impact**: 50K classes = 50K syscalls, filesystem lock contention

**Solution**: Use `BufWriter` or batch writes

---

### P2-2: DEX Data Copied Instead of Memory-Mapped

**Location**: `crates/dexterity-cli/src/main.rs:1046`

**Problem**: `from_slice()` copies DEX bytes instead of memory-mapping

**Impact**: Extra 10-50MB allocation per DEX file

**Solution**: Memory-map ZIP-extracted DEX or use zero-copy

---

### P2-3: Sequential Deobfuscation Prepass

**Location**: `crates/dexterity-cli/src/deobf.rs:94-304`

**Problem**: Single-threaded sort + alias generation blocks parallelism

**Impact**: 100-500ms blocking all 56 cores

**Solution**: Parallel extraction + sequential deterministic merge

---

### P2-4: HashMap Capacity Explosion in ExprGen Pool

**Location**: `crates/dexterity-codegen/src/expr_gen.rs:363-439`

**Problem**: `HashMap::clear()` retains capacity, pools bloat from large methods

**Impact**: 100GB+ memory on pathological APKs

**Note**: Partially mitigated with MAX_POOLED_CAPACITY threshold

---

### P2-5: Recursive Type Variable Resolution

**Location**: `crates/dexterity-passes/src/type_inference.rs:471-506`

**Problem**: Unbounded recursion for nested generic types

**Impact**: Stack overflow on deeply nested generics

**Solution**: Iterative worklist or memoization

---

### P2-6: String Formatting in Hot Loops

**Locations**:
- `crates/dexterity-codegen/src/expr_gen.rs:195-287` - `format!()` per literal
- `crates/dexterity-passes/src/region_builder.rs:189` - `format!("loop_{}")` per break

**Impact**: Heap allocation per formatted string

**Solution**: Use `write!` directly to CodeWriter

---

### P2-7: DashMap Insert Contention During String Preload

**Location**: `crates/dexterity-cli/src/main.rs:1107-1114`

**Problem**: All threads racing to populate string cache simultaneously

**Impact**: Cache-line bouncing during warmup phase

**Solution**: Partition preload by thread, reduce chunk overlap

---

## P3 Low Priority Bottlenecks

### P3-1: Dominance Frontier O(N²) Worst Case
- **Location**: `crates/dexterity-passes/src/ssa.rs:175-198`
- **Fix**: Pre-allocate frontier sets with capacity hints

### P3-2: Multiple Parallel HashMaps in BodyGenContext
- **Location**: `crates/dexterity-codegen/src/body_gen.rs:80-127`
- **Fix**: Unified variable info struct

### P3-3: No String Interning for Variable Names
- **Location**: `crates/dexterity-codegen/src/expr_gen.rs:50-72`
- **Fix**: Use `string_cache` or `lasso` crate

### P3-4: Inner Class Map Built Sequentially
- **Location**: `crates/dexterity-cli/src/main.rs:1249-1264`
- **Fix**: Parallel extraction + merge pattern

### P3-5: Atomic Counter Per-Class Increment
- **Location**: `crates/dexterity-cli/src/main.rs:1346`
- **Fix**: Thread-local counters, merge at end

---

## Quick Wins Summary

Recommended attack order for maximum impact with minimum effort:

| Priority | Change | File | Line | Est. Gain | Status |
|----------|--------|------|------|-----------|--------|
| 1 | RwLock → DashMap in GlobalFieldPool | dex_info.rs | 65 | 10-20% | **DONE** |
| 2 | Arc wrap for res_names | main.rs | 1457 | 5-10% | **DONE** |
| 3 | Batch progress bar updates | main.rs | 1522 | 5-15% | TODO |
| 4 | BTreeMap → FxHashMap in block_split | block_split.rs | 121 | 2-5% | **DONE** |
| 5 | Increase memory checkpoint interval | main.rs | 1347 | 1-3% | **DONE** |
| 6 | SSA instruction cloning elimination | ssa.rs | - | **19.8%** | **DONE** |

---

## Profiling Guide

### Using perf

```bash
# Record CPU profile
perf record -g --call-graph dwarf ./target/release/dexterity -i large.apk -o out/

# Generate flamegraph
perf script | stackcollapse-perf.pl | flamegraph.pl > flamegraph.svg
```

### Using cargo-flamegraph

```bash
cargo install flamegraph
cargo flamegraph --bin dexterity -- -i large.apk -o out/
```

### Key Metrics to Watch

- **Lock contention**: Look for `parking_lot::*` or `std::sync::*` in hot paths
- **Allocation pressure**: Look for `alloc::*` frames
- **Cache misses**: Use `perf stat -e cache-misses`
- **Thread scaling**: Compare runtime with 1, 8, 16, 32, 56 threads

### Testing Scaling

```bash
# Test with different thread counts
for threads in 1 8 16 32 56; do
    RAYON_NUM_THREADS=$threads time ./target/release/dexterity -i test.apk -o out/
done
```

---

## Implementation Status

| Issue | Status | PR/Commit |
|-------|--------|-----------|
| P0-1: GlobalFieldPool DashMap | DONE | 2025-12-17 |
| P0-2: res_names Arc wrap | DONE | 2025-12-17 |
| P0-3: Progress bar batching | TODO | - |
| P1-1: SSA instruction cloning | **DONE** | 2025-12-17 - transform_to_ssa_owned() |
| P1-2: Type var limit | TODO | - |
| P1-3: BTreeMap → FxHashMap | DONE | 2025-12-17 |
| P1-4: Parallel DEX processing | TODO | - |
| P1-5: Memory checkpoint interval | DONE | 2025-12-17 (100 → 1000) |

## Benchmark Results (2025-12-17)

**Test APK**: large.apk (52MB, 17666 classes across 3 DEX files)
**Hardware**: 56-core machine, ramdisk I/O

| Version | Time | CPU% | Notes |
|---------|------|------|-------|
| Baseline | 5.26s | 4014% | Before optimizations |
| **After optimizations** | **4.94s** | **4049%** | 6% faster, better parallelization |

**Improvements achieved**:
- 6% wall-clock speedup (5.26s → 4.94s)
- Better CPU utilization (4014% → 4049%)
- Reduced lock contention with DashMap
- Eliminated per-class HashMap cloning
- O(1) vs O(log N) in block splitting hot path

## SSA Optimization Benchmark (Dec 2025)

**Test APK**: HoYoverse APK (11MB) on RAM disk
**Fix**: SSA instruction cloning eliminated via `transform_to_ssa_owned()`

| Cores | Before | After | Improvement | Efficiency |
|-------|--------|-------|-------------|------------|
| 1 | 121.14s | 121.14s | - | 100% |
| 4 | 31.65s | 29.84s | 5.7% faster | **101%** (superlinear) |
| 8 | 18.75s | **15.04s** | **19.8% faster** | **101%** (superlinear) |
| 16 | 8.51s | 8.11s | 4.7% faster | 93% |
| 24 | 6.56s | 6.14s | 6.4% faster | 82% |
| 32 | 5.79s | 5.51s | 4.8% faster | 69% |

**Key findings**:
- **19.8% faster at 8 cores** - the sweet spot for most systems
- **Superlinear scaling restored** at 4-8 cores (101% efficiency)
- **7-10 GB allocation pressure eliminated** - no more instruction vector cloning
- All 685 integration tests passing

---

## References

- [Rayon Documentation](https://docs.rs/rayon/latest/rayon/)
- [DashMap Documentation](https://docs.rs/dashmap/latest/dashmap/)
- [parking_lot Documentation](https://docs.rs/parking_lot/latest/parking_lot/)
- [Rust Performance Book](https://nnethercote.github.io/perf-book/)
