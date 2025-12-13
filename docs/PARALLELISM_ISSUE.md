# Parallelism Issue - Only Using 2 Cores

## Current Implementation (BROKEN)

```rust
let chunk_size = 2; // Max 2 classes in-flight at once

for chunk in class_indices.chunks(chunk_size) {  // <-- Sequential loop!
    chunk.par_iter().for_each(|&idx| {          // <-- Parallel within chunk
        // Process class
    });
}
```

**Problem:** The outer `for` loop is SEQUENTIAL. Each chunk is processed serially, only parallelizing the 2 classes within each chunk.

**Result:** Only 2 cores are ever used at once, regardless of how many cores the system has!

## On a 112-core system:
- ❌ Currently using: 2 cores (1.8% utilization)
- ✅ Should be using: Up to 112 cores (or configured thread count)

## Why This Happened

The comment says "Max 2 classes in-flight at once = bounded memory". This was an overly conservative memory optimization that killed parallelism.

## The Fix

Change from sequential chunks to parallel chunks:

```rust
// BEFORE (sequential outer loop):
for chunk in class_indices.chunks(chunk_size) {
    chunk.par_iter().for_each(|&idx| { ... });
}

// AFTER (parallel chunks):
class_indices.par_chunks(chunk_size).for_each(|chunk| {
    for &idx in chunk {  // Or chunk.iter().for_each()
        // Process class
    }
});
```

Or better yet, process all classes in parallel directly:

```rust
class_indices.par_iter().for_each(|&idx| {
    // Process class
});
```

## How JADX Does It

JADX uses `ITaskExecutor` with batching and submits tasks in parallel:

```java
// From JadxDecompiler.appendSourcesSave()
List<JavaClass> processQueue = filterClasses(classes);
List<List<JavaClass>> batches = decompileScheduler.buildBatches(processQueue);
List<Runnable> decompileTasks = new ArrayList<>(batches.size());
for (List<JavaClass> decompileBatch : batches) {
    decompileTasks.add(() -> {
        for (JavaClass cls : decompileBatch) {
            ClassNode clsNode = cls.getClassNode();
            ICodeInfo code = clsNode.getCode();
            SaveCode.save(outDir, clsNode, code);
        }
    });
}
executor.addParallelTasks(decompileTasks);
```

**Key Point:** All batches are submitted to the executor at once. The executor processes them concurrently (limited only by thread pool size).

**Source:** [JadxDecompiler.java](https://github.com/skylot/jadx/blob/master/jadx-core/src/main/java/jadx/api/JadxDecompiler.java)

## Memory Concerns

The "bounded memory" concern is valid but should be handled differently:

1. **Rayon's thread pool already bounds parallelism** - setting `num_threads` limits concurrent work
2. **Use scoped threads if needed** - ensures work completes before moving on
3. **Process in batches if memory is really tight** - but use `par_chunks()` not `for chunks()`

## Impact

On a typical 8-core system:
- Before: ~2x speedup (using 2 cores)
- After: ~8x speedup (using 8 cores)

On a 112-core system:
- Before: ~2x speedup (using 2 cores) 
- After: Up to 112x speedup (using all cores)

For a 1000-class APK:
- Before: Process 2 at a time = 500 iterations sequentially
- After: Process all 1000 in parallel (limited by thread pool)

**This is a CRITICAL performance bug.**

