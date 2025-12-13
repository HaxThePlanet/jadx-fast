# Testing Parallel Decompilation

## Verification Steps

### 1. Check Thread Configuration

```bash
# Check configured thread count
./target/release/dexterity --help | grep -A2 threads

# System CPU count
nproc
```

### 2. Monitor CPU Usage During Decompilation

Run decompilation in one terminal:
```bash
# Use all available cores
./target/release/dexterity -d output/ your-app.apk --threads $(nproc)
```

Monitor in another terminal:
```bash
# Watch CPU usage
top -p $(pgrep dexterity) -d 0.5

# Or use htop for visual representation
htop -p $(pgrep dexterity)
```

### 3. Interpreting Results

**CPU Usage Indicators:**
- `100%` = Using 1 core
- `200%` = Using 2 cores (BEFORE fix)
- `800%` = Using 8 cores (AFTER fix on 8-core system)
- `11,200%` = Using 112 cores (AFTER fix on 112-core system)

**If parallelism is working:**
- ✅ CPU usage should be > 200% (more than 2 cores)
- ✅ CPU usage should scale with thread count
- ✅ On 8-core system: expect 600-800% CPU usage
- ✅ On 112-core system: expect up to 11,200% CPU usage

**If parallelism is NOT working:**
- ❌ CPU usage stuck at ~200% (only 2 cores)
- ❌ No scaling with increased thread count

### 4. Performance Comparison

Before fix (sequential chunks):
```bash
time ./target/release/dexterity-old -d output-old/ app.apk --threads 8
# Expected: ~2x speedup (using 2 cores)
```

After fix (parallel processing):
```bash
time ./target/release/dexterity -d output-new/ app.apk --threads 8
# Expected: ~8x speedup (using 8 cores)
```

**Speedup calculation:**
```
Speedup = Time(old) / Time(new)

8-core system:
- Before: ~2x speedup
- After: ~8x speedup
- Improvement: 4x faster!
```

### 5. Thread Count Scaling Test

Test with different thread counts to verify scaling:

```bash
# 1 thread (baseline)
time ./target/release/dexterity -d output/ app.apk --threads 1

# 2 threads
time ./target/release/dexterity -d output/ app.apk --threads 2

# 4 threads
time ./target/release/dexterity -d output/ app.apk --threads 4

# 8 threads
time ./target/release/dexterity -d output/ app.apk --threads 8

# All cores
time ./target/release/dexterity -d output/ app.apk --threads $(nproc)
```

**Expected results:**
- Time should decrease as thread count increases
- Speedup should be roughly linear up to physical core count
- Diminishing returns after physical cores (due to hyperthreading)

## Example Output

### Before Fix (Only 2 cores)
```
$ top -p $(pgrep dexterity)
PID   USER    PR  NI  VIRT   RES  %CPU  %MEM  TIME+  COMMAND
12345 user    20   0  1.5g   800m 198.0  2.0  0:45.2 dexterity
                                  ^^^^
                                  Only ~2 cores!
```

### After Fix (All 8 cores)
```
$ top -p $(pgrep dexterity)
PID   USER    PR  NI  VIRT   RES  %CPU  %MEM  TIME+  COMMAND
12345 user    20   0  1.5g   800m 795.0  2.0  0:10.8 dexterity
                                  ^^^^
                                  Using ~8 cores!
```

### Performance Improvement
```
Before: 45.2 seconds (2 cores)
After:  10.8 seconds (8 cores)
Speedup: 4.2x faster!
```

## Automated Test Script

```bash
#!/bin/bash
# Save as: scripts/test_parallelism.sh

APK="$1"
if [ -z "$APK" ]; then
    echo "Usage: $0 <path-to-apk>"
    exit 1
fi

THREADS=$(nproc)
echo "Testing parallelism with $THREADS threads..."
echo ""

# Start decompilation in background
./target/release/dexterity -d /tmp/parallel_test "$APK" --threads $THREADS &
PID=$!

echo "Monitoring CPU usage (will stop automatically)..."
echo ""

# Monitor for 5 seconds
for i in {1..10}; do
    CPU=$(ps -p $PID -o %cpu= 2>/dev/null || echo "0")
    THREADS_ACTIVE=$(ps -p $PID -o nlwp= 2>/dev/null || echo "0")
    echo "CPU: ${CPU}% | Active threads: ${THREADS_ACTIVE}"
    sleep 0.5
done

wait $PID

echo ""
echo "Expected CPU usage: > 200% (more than 2 cores)"
echo "If you see ~200%, parallelism is NOT working."
echo "If you see 600-800% on 8-core system, parallelism IS working!"
```

## Troubleshooting

### CPU stays at ~200%
**Problem:** Parallelism not working
**Fix:** Verify rayon thread pool configuration in main.rs

### CPU usage very low (< 100%)
**Problem:** I/O bound, not CPU bound
**Possible causes:**
- Slow disk I/O
- Small APK (not enough classes to parallelize)
- Memory constraints

### Threads not scaling
**Check:** `rayon::current_num_threads()` matches `--threads` argument

## Verification Checklist

- [ ] CPU usage > 200% (more than 2 cores)
- [ ] CPU usage scales with thread count
- [ ] Performance improves with more threads
- [ ] All cores utilized on large APKs
- [ ] No regressions in output quality

## Success Criteria

✅ **Parallelism is working if:**
1. CPU usage > 200% (using more than 2 cores)
2. Time decreases with increased thread count
3. On 8-core system: 600-800% CPU usage
4. On large APK: significantly faster than before

---

**Status:** Ready for testing
**Expected improvement:** 4-56x faster on multi-core systems
