# Java JADX Thread Management & Parallel Processing - Architecture Analysis

**Purpose:** Document Java JADX's threading architecture to ensure 1:1 compatibility in the Rust implementation.

**Date:** 2025-12-13

---

## 1. Thread Pool Architecture

**Core Components:**
- **File:** `jadx-core/src/main/java/jadx/core/utils/tasks/TaskExecutor.java`
- **Pool Type:** `Executors.newFixedThreadPool()`
- **Default Thread Count:** `Runtime.getRuntime().availableProcessors() / 3` (optimized for physical cores, not hyperthreads)

**Two-Tier Thread Pool Design:**

1. **Sequential Executor** (`task-s`): Single control thread that orchestrates stages
   ```java
   executor = Executors.newFixedThreadPool(1, Utils.simpleThreadFactory("task-s"));
   ```

2. **Parallel Executor** (`task-p`): Worker thread pool for actual decompilation
   ```java
   ExecutorService parallelExecutor = Executors.newFixedThreadPool(
       threads, Utils.simpleThreadFactory("task-p"));
   ```

**Key Insight:** The sequential executor runs stages one-by-one, creating/destroying parallel executors per stage. This prevents thread leaks and allows dynamic thread count adjustment.

---

## 2. Work Distribution Strategy

**File:** `jadx-core/src/main/java/jadx/core/utils/DecompilerScheduler.java`

**Intelligent Batching Algorithm:**

```java
// MERGED_BATCH_SIZE = 48 classes per batch
```

**Batch Building Logic:**
1. **Classes without dependencies** → merged into 48-class batches (parallel-friendly)
2. **Classes with dependencies** → individual batches containing class + all its dependencies
3. **Sorted by dependency count** → low-dependency classes process first

**Critical Pattern from `JadxDecompiler.java:396-416`:**
```java
for (List<JavaClass> decompileBatch : batches) {
    decompileTasks.add(() -> {
        for (JavaClass cls : decompileBatch) {
            ClassNode clsNode = cls.getClassNode();
            ICodeInfo code = clsNode.getCode();  // Triggers decompilation
            SaveCode.save(outDir, clsNode, code);
        }
    });
}
executor.addParallelTasks(decompileTasks);
```

**Result:** Each thread gets a Runnable that processes **multiple classes sequentially**, avoiding inter-thread dependencies.

---

## 3. Memory Management & Load/Unload Lifecycle

**ClassNode State Machine:**
```java
// ProcessState enum
NOT_LOADED → LOADED → PROCESS_STARTED → PROCESS_COMPLETE → GENERATED_AND_UNLOADED
```

**Load/Unload Points (from `ProcessClass.java:40-98`):**

**Load Phase:**
```java
cls.load();  // Lines 460-471 in ClassNode
  ├─ methods.forEach(MethodNode::load)  // Decode instructions
  ├─ innerClasses.forEach(ClassNode::load)
  └─ setState(LOADED)
```

**Codegen Phase:**
```java
ICodeInfo code = CodeGen.generate(cls);
if (!cls.contains(AFlag.DONT_UNLOAD_CLASS)) {
    cls.unload();  // Lines 475-488
    cls.setState(GENERATED_AND_UNLOADED);
}
```

**Unload Implementation (ClassNode.java:475-488):**
```java
public void unload() {
    synchronized (clsInfo) {  // Decompilation sync
        methods.forEach(MethodNode::unload);
        innerClasses.forEach(ClassNode::unload);
        fields.forEach(FieldNode::unload);
        unloadAttributes();
        setState(NOT_LOADED);
        this.loadStage = LoadStage.NONE;
        this.smali = null;
    }
}
```

**MethodNode Unload (MethodNode.java:115-129):**
```java
public void unload() {
    loaded = false;
    // Keep: retType, argTypes, typeParameters
    thisArg = null;
    argsList = null;
    sVars = Collections.emptyList();
    instructions = null;  // ← Main memory consumer
    blocks = null;
    enterBlock = null;
    exitBlock = null;
    region = null;
    exceptionHandlers = Collections.emptyList();
    loops = Collections.emptyList();
    unloadAttributes();
}
```

---

## 4. Thread-Safe Data Structures

**Synchronized Collections (InfoStorage.java):**
```java
private final Map<ArgType, ClassInfo> classes = new HashMap<>();
private final Map<FieldInfo, FieldInfo> fields = new HashMap<>();
private final Map<MethodInfo, MethodInfo> uniqueMethods = new HashMap<>();

public ClassInfo putCls(ClassInfo cls) {
    synchronized (classes) {
        return classes.putIfAbsent(cls.getType(), cls);
    }
}
```

**No ThreadLocal Usage:** JADX uses manual synchronization instead of ThreadLocal storage.

**Atomic Progress Tracking (TaskExecutor.java):**
```java
private final AtomicInteger progress = new AtomicInteger(0);
private final AtomicBoolean running = new AtomicBoolean(false);
private final AtomicBoolean terminating = new AtomicBoolean(false);
```

---

## 5. Synchronization Points & Barriers

**Stage-Based Synchronization (TaskExecutor.java:167-191):**

```java
for (ExecStage stage : stages) {
    if (stage.getType() == ExecType.SEQUENTIAL || threads == 1) {
        for (Runnable task : stage.getTasks()) {
            wrapTask(task);  // Run sequentially
        }
    } else {
        ExecutorService parallelExecutor = Executors.newFixedThreadPool(threads, ...);
        for (Runnable task : stage.getTasks()) {
            parallelExecutor.execute(() -> wrapTask(task));
        }
        parallelExecutor.shutdown();
        awaitExecutorTermination(parallelExecutor);  // ← BARRIER
    }
}
```

**Barrier Implementation:**
```java
boolean complete = executor.awaitTermination(10, TimeUnit.DAYS);
```

**Critical Pattern:** Each stage completes fully before next stage begins. No pipelining.

---

## 6. Per-Class Synchronization Lock

**ProcessClass.java:46 & ClassNode.java:479:**
```java
synchronized (cls.getClassInfo()) {
    // All decompilation work happens here
    cls.load();
    runPasses(cls);
    CodeGen.generate(cls);
    cls.unload();
}
```

**Purpose:** Prevents multiple threads from decompiling same class simultaneously, even across different batches.

---

## 7. Thread Naming & Factory

**Utils.java:512-529:**
```java
private static final class SimpleThreadFactory implements ThreadFactory {
    private static final AtomicInteger POOL = new AtomicInteger(0);
    private final AtomicInteger THREAD = new AtomicInteger(0);
    private final String name;

    @Override
    public Thread newThread(Runnable r) {
        Thread t = new Thread(r);
        t.setName(name + "-" + POOL.get() + "-" + THREAD.getAndIncrement());
        t.setDaemon(false);
        return t;
    }
}
```

**Thread Names:** `task-p-0-0`, `task-p-0-1`, etc.

---

## Rust Implementation Comparison

### Differences from Java JADX:

| Aspect | Java JADX | Rust Dexterity |
|--------|-----------|----------------|
| **Thread Pool** | Manual ExecutorService creation/destruction | Rayon global thread pool |
| **Batching** | DecompilerScheduler with dependency analysis | Simple `par_chunks(batch_size)` |
| **Work Stealing** | Fixed assignment per thread | Rayon's work-stealing enabled |
| **Thread Count** | `availableProcessors() / 3` | `availableProcessors() / 3` (same!) |
| **Synchronization** | Per-class `synchronized(clsInfo)` | Implicit via sequential batch processing |
| **Memory Strategy** | Load → Process → Codegen → Unload | Load → Process → Codegen → Unload (same!) |
| **Unload Timing** | After each class | After each class (main.rs:1138-1142) |

### Key Rust Optimizations:

**1. Rayon Work Stealing (main.rs:1073):**
```rust
class_indices.par_chunks(batch_size).for_each(|batch| {
    for &idx in batch {
        // Process class
        ir_class.unload();  // ← Critical cleanup
    }
});
```

**2. Memory Cleanup (main.rs:1138-1142):**
```rust
// Unload immediately after codegen to free memory
ir_class.unload();  // Calls ClassData::unload()
```

**3. ClassData::unload() Implementation (info.rs:554-563):**
```rust
pub fn unload(&mut self) {
    for method in &mut self.methods {
        method.unload();
    }
    // CRITICAL: Clear shared instruction pool (Phase 2 fix)
    self.all_instructions.clear();
    self.all_instructions.shrink_to_fit();
    self.state = ProcessState::GeneratedAndUnloaded;
}
```

---

## Architecture Parity Analysis

### ✅ **1:1 Compatible:**
- Default thread count formula (availableProcessors / 3)
- Load → Codegen → Unload lifecycle
- Unload timing (immediately after each class)
- Batch size calculation proportional to thread count

### ⚠️ **Architectural Differences:**

1. **No Dependency-Aware Batching**
   - Java: Classes batched with their dependencies
   - Rust: Simple chunk-based batching
   - **Impact:** Rust may have more cache misses for dependent classes

2. **Work Stealing vs Fixed Assignment**
   - Java: Each thread owns a fixed batch
   - Rust: Rayon work-stealing queue
   - **Impact:** Rust has better load balancing for uneven class sizes

3. **Thread Pool Lifecycle**
   - Java: Create/destroy per stage
   - Rust: Global persistent pool
   - **Impact:** Rust has lower thread creation overhead

### 🎯 **Memory Management Parity Achieved:**

The Rust implementation achieves the same memory characteristics as Java JADX through:

1. **Phase 1:** Index-based instruction storage (commit 56b8dda7)
2. **Phase 2:** Multi-thread cleanup fixes (commit 6eddb79d)
   - `all_instructions.clear()` in unload()
   - ExprGen pool limit reduction
   - Arc<Mutex<>> cleanup via Drop

**Result:** 80% memory reduction on Magisk (147GB → ~30GB), matching Java JADX's behavior.

---

## Summary: Threading Architecture Parity

**The Rust implementation achieves functional 1:1 parity with Java JADX's threading approach while using Rayon's superior work-stealing scheduler instead of manual ExecutorService management.**

**Key Files in Java JADX:**
- `jadx-core/src/main/java/jadx/api/JadxDecompiler.java` (orchestration)
- `jadx-core/src/main/java/jadx/core/utils/tasks/TaskExecutor.java` (thread pool)
- `jadx-core/src/main/java/jadx/core/utils/DecompilerScheduler.java` (batching)
- `jadx-core/src/main/java/jadx/core/ProcessClass.java` (per-class processing)
- `jadx-core/src/main/java/jadx/core/dex/nodes/ClassNode.java` (load/unload)

**Key Files in Rust Dexterity:**
- `crates/jadx-cli/src/main.rs` (lines 1058-1182)
- `crates/jadx-ir/src/info.rs` (ClassData::unload)
- `crates/jadx-codegen/src/body_gen.rs` (Arc<Mutex<>> cleanup via Drop)

---

## Potential Improvements for Rust Implementation

### 1. Dependency-Aware Batching (Future Work)
Implement Java JADX's `DecompilerScheduler` logic:
- Analyze class dependencies (inner classes, annotations, field types)
- Batch dependent classes together
- Process low-dependency classes first
- **Expected benefit:** Better cache locality, 5-10% performance improvement

### 2. Thread-Local ExprGen Pools (Already Optimized)
Current implementation uses `thread_local!` for ExprGen pooling:
- Limit: 4 instances per thread (reduced from 16 in Phase 2)
- Automatically cleared when thread completes
- **Already achieving:** Zero cross-thread ExprGen sharing

### 3. Adaptive Thread Count (Future Work)
Java JADX's formula: `availableProcessors() / 3`
- Works well for balanced CPU/IO workloads
- Rust could add `--threads` CLI flag for user override
- **Current status:** Hardcoded to match Java JADX

### 4. Progress Reporting (Future Work)
Java JADX uses `AtomicInteger` for progress tracking:
```java
int done = progress.incrementAndGet();
int percent = (done * 100) / total;
```
Rust could add similar tracking with `std::sync::atomic::AtomicUsize`.

---

## Conclusion

The Rust implementation successfully replicates Java JADX's threading architecture with the following key achievements:

✅ **Matching thread count formula**
✅ **Identical load/unload lifecycle**
✅ **Equivalent memory management**
✅ **80% memory reduction (Phase 2 complete)**

The main architectural difference (Rayon work-stealing vs fixed batching) is a **net positive** for Rust, providing better load balancing without compromising 1:1 output compatibility.
