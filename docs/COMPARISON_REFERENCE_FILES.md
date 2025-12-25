# Reference Files for JADX vs Dexterity Comparison

Curated test files for comparing decompilation output between JADX and Dexterity. Use these files to validate quality improvements and find edge cases.

See `LLM_AGENT_GUIDE.md` for workflow and `ROADMAP.md` for current status and issues.

---

## Output Directory Structure

```
/mnt/nvme4tb/dexterity/output/
├── jadx/
│   ├── small/    (2 files)     - Baseline Android app
│   ├── medium/   (5,933 files) - RxJava, Crypto, Firebase SDKs
│   ├── large/    (8,161 files) - Real app (Dogo) with enterprise libs
│   └── badboy/   (86 files)    - Malware sample for security testing
└── dexterity/
    └── [matching structure]
```

---

## Curated Test Suite (10 Files)

These files provide maximum pattern coverage with minimal redundancy.

### Quick Reference Table

| # | File | Patterns | Complexity |
|---|------|----------|------------|
| 1 | `MainActivity.java` | Basic Android, method overrides | Low |
| 2 | `R.java` (small) | Nested classes, constants | Low |
| 3 | `Buffer.java` | I/O, loops, control flow | Medium |
| 4 | `Completable.java` | Generics, abstract class, annotations | Medium |
| 5 | `CodedInputStream.java` | Switch, byte ops, state machine | Medium |
| 6 | `Dispatcher.java` | Synchronized, threading, executors | High |
| 7 | `CipherSuite.java` | Static init, 100+ constants | High |
| 8 | `GraphRequest.java` | Generics, overloading, name collisions | High |
| 9 | `MaliciousPatterns.java` | Exceptions, reflection, lambdas | High |
| 10 | `R.java` (large) | Extreme nested classes (9,927 lines) | Edge Case |

---

## Full File Paths

### JADX Output

```bash
# 1. Baseline - Basic Activity
/mnt/nvme4tb/dexterity/output/jadx/small/sources/io/github/skylot/android/smallapp/MainActivity.java

# 2. Baseline - Nested Constants
/mnt/nvme4tb/dexterity/output/jadx/small/sources/io/github/skylot/android/smallapp/R.java

# 3. Control Flow - I/O Operations
/mnt/nvme4tb/dexterity/output/jadx/medium/sources/okio/Buffer.java

# 4. Generics - Abstract Class
/mnt/nvme4tb/dexterity/output/jadx/medium/sources/io/reactivex/Completable.java

# 5. Switch/State Machine
/mnt/nvme4tb/dexterity/output/jadx/medium/sources/com/google/crypto/tink/shaded/protobuf/CodedInputStream.java

# 6. Synchronization - Threading
/mnt/nvme4tb/dexterity/output/jadx/large/sources/okhttp3/Dispatcher.java

# 7. Static Initialization
/mnt/nvme4tb/dexterity/output/jadx/large/sources/okhttp3/CipherSuite.java

# 8. Name Collisions - Complex Generics
/mnt/nvme4tb/dexterity/output/jadx/large/sources/com/facebook/GraphRequest.java

# 9. Reflection/Exceptions
/mnt/nvme4tb/dexterity/output/jadx/badboy/sources/com/prototype/badboy/MaliciousPatterns.java

# 10. Edge Case - Extreme Nesting
/mnt/nvme4tb/dexterity/output/jadx/large/sources/app/dogo/com/dogo_android/R.java
```

### Dexterity Output (Same Relative Paths)

```bash
/mnt/nvme4tb/dexterity/output/dexterity/small/sources/io/github/skylot/android/smallapp/MainActivity.java
/mnt/nvme4tb/dexterity/output/dexterity/small/sources/io/github/skylot/android/smallapp/R.java
/mnt/nvme4tb/dexterity/output/dexterity/medium/sources/okio/Buffer.java
/mnt/nvme4tb/dexterity/output/dexterity/medium/sources/io/reactivex/Completable.java
/mnt/nvme4tb/dexterity/output/dexterity/medium/sources/com/google/crypto/tink/shaded/protobuf/CodedInputStream.java
/mnt/nvme4tb/dexterity/output/dexterity/large/sources/okhttp3/Dispatcher.java
/mnt/nvme4tb/dexterity/output/dexterity/large/sources/okhttp3/CipherSuite.java
/mnt/nvme4tb/dexterity/output/dexterity/large/sources/com/facebook/GraphRequest.java
/mnt/nvme4tb/dexterity/output/dexterity/badboy/sources/com/prototype/badboy/MaliciousPatterns.java
/mnt/nvme4tb/dexterity/output/dexterity/large/sources/app/dogo/com/dogo_android/R.java
```

---

## Pattern Coverage Matrix

| Pattern | 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 | 9 | 10 |
|---------|---|---|---|---|---|---|---|---|---|-----|
| Try/Catch/Finally | - | - | X | X | X | X | - | X | XX | - |
| Loops/Iteration | X | - | XX | X | X | X | X | X | X | - |
| Switch Statements | - | - | X | - | XX | - | - | X | X | - |
| Synchronized | - | - | - | - | - | XX | - | - | - | - |
| Inner Classes | - | XX | X | X | - | X | - | X | - | XX |
| Lambdas | - | - | - | - | - | X | - | - | XX | - |
| Generics | - | - | X | XX | X | X | - | XX | X | - |
| Static Init | - | X | - | - | - | - | XX | - | X | XX |
| Annotations | X | - | - | XX | - | X | X | X | X | - |
| Reflection | - | - | - | - | - | - | - | - | XX | - |
| Name Collisions | - | - | - | - | - | - | - | XX | - | - |

**Legend:** XX = Primary focus, X = Present, - = Not applicable

---

## File Details by Category

### Baseline (Low Complexity)

**1. MainActivity.java** (~50 lines)
- Basic Android Activity with `onCreate` override
- Simple method calls (`setContentView`, `Log.i`)
- Use for: Verifying basic decompilation correctness

**2. R.java - small** (~200 lines)
- Nested static inner classes (`R.color`, `R.drawable`, `R.id`)
- Constant integer fields
- Use for: Testing nested class handling

### Control Flow (Medium Complexity)

**3. Buffer.java** (2,273 lines)
- I/O operations with segment handling
- Complex loops and conditionals
- Use for: Testing loop reconstruction

**4. Completable.java** (1,000+ lines)
- Abstract generic class with wildcards
- `@CheckReturnValue`, `@SchedulerSupport` annotations
- Use for: Testing generic type handling

**5. CodedInputStream.java** (3,593 lines)
- Large switch statements for type dispatch
- Byte manipulation and bit operations
- Use for: Testing switch reconstruction

### Threading & Synchronization (High Complexity)

**6. Dispatcher.java** (1,400+ lines)
- `synchronized` blocks with complex threading
- `ExecutorService`, `ArrayDeque` patterns
- Use for: Testing synchronization detection

**7. CipherSuite.java** (1,700+ lines)
- 100+ static final fields for TLS cipher suites
- Static initializer with `LinkedHashMap`
- Use for: Testing static initialization order

### Edge Cases (High Complexity)

**8. GraphRequest.java** (1,493 lines)
- Renamed fields due to collisions (`f2607o`, `f2608c`)
- Complex generic method signatures
- Use for: Testing obfuscated name handling

**9. MaliciousPatterns.java** (622 lines)
- `getDeclaredMethod`, `setAccessible` reflection
- Multiple try/catch/finally blocks
- Kotlin lambdas (`detectEmulator$lambda`)
- Use for: Testing reflection and exception handling

**10. R.java - large** (9,927 lines)
- Thousands of nested static classes
- Extreme constant count
- Use for: Testing performance on large generated files

---

## Quick Comparison Commands

### Diff single file
```bash
diff -u \
  /mnt/nvme4tb/dexterity/output/jadx/large/sources/okhttp3/Dispatcher.java \
  /mnt/nvme4tb/dexterity/output/dexterity/large/sources/okhttp3/Dispatcher.java
```

### Side-by-side comparison
```bash
diff -y --width=200 \
  /mnt/nvme4tb/dexterity/output/jadx/small/sources/io/github/skylot/android/smallapp/MainActivity.java \
  /mnt/nvme4tb/dexterity/output/dexterity/small/sources/io/github/skylot/android/smallapp/MainActivity.java
```

### Line count comparison
```bash
wc -l /mnt/nvme4tb/dexterity/output/{jadx,dexterity}/large/sources/okhttp3/Dispatcher.java
```

---

## Additional Files by Pattern

### More Exception Handling
- `large/sources/com/facebook/GraphRequest.java` - Network exceptions
- `badboy/sources/com/prototype/badboy/*.java` - Anti-debug patterns

### More Generics
- `medium/sources/io/reactivex/Observable.java` (3,817 lines)
- `medium/sources/io/reactivex/Flowable.java` (4,464 lines)

### More Static Initialization
- `large/sources/app/dogo/com/dogo_android/R.java` (9,927 lines)

### More I/O Operations
- `large/sources/okhttp3/HttpUrl.java` (1,723 lines) - URL parsing
- `medium/sources/com/google/crypto/tink/shaded/protobuf/BinaryWriter.java` (3,493 lines)
