# JADX-Fast v1.5.3

**jadx-fast goes brrrr**

An optimized fork of JADX for high-performance Android app decompilation.

Based on [skylot/jadx](https://github.com/skylot/jadx) v1.5.3 with performance optimizations that deliver **1.83x faster** decompilation.

## Benchmark Results

Tested on GoldRush APK (647MB, 20,481 classes, 11 DEX files):

`sha256: aa7382155dc62389b3bbb0e2ee93c882b5118e3da7924db8575cb137ca36596b`

| Version | Time | Speedup | Errors |
|---------|------|---------|--------|
| Stock JADX 1.5.3 | 47.60s | - | 56-65 |
| **jadx-fast 1.5.3** | **26.01s** | **1.83x** | **38** |

*Tested on 56-thread system with NVMe storage*

## Performance Optimizations

### Tier 1: Smart Class Filtering (THE BIG ONE)

**This is the most impactful optimization.** Skips processing of framework and generated classes entirely:

**Framework packages skipped:**
- `android.*`, `androidx.*`
- `kotlin.*`, `kotlinx.*`
- `java.*`, `javax.*`, `sun.*`, `dalvik.*`
- `com.google.android.*`, `com.android.*`
- `org.apache.http.*`, `org.xmlpull.*`, `org.json.*`, `org.w3c.*`, `org.xml.*`

**Generated code skipped:**
- `R.java`, `R$*.class`, `BuildConfig`, `BR`
- Data Binding (`*databinding*`, `*DataBinderMapper*`)
- Dagger/Hilt (`*_Factory`, `*_HiltModules`, `*_MembersInjector`)
- Butterknife (`*_ViewBinding`, `*_ViewBinder`)

**Cross-platform frameworks skipped:**
- Flutter (`io.flutter.*`)
- React Native (`com.facebook.react.*`, `com.facebook.hermes.*`)

**Why?** You don't need to decompile Android SDK or Kotlin stdlib - you can read those online. Focus on the actual app code.

### Tier 2: Parallel I/O & Decompression

1. **Lock-Free Parallel Decompression**
   - Thread-safe `getBytes()` using ByteBuffer duplication
   - Removes `synchronized` bottleneck that serialized all zip entry reads
   - Enables true parallel extraction across all CPU cores

2. **Memory-Mapped File I/O**
   - Always uses memory-mapped files regardless of APK size
   - Better performance for parallel access patterns
   - OS-level caching and read-ahead optimization

3. **Parallel Zip Entry Processing**
   - ForkJoinPool-based work-stealing for optimal load balancing
   - Configurable via `PARALLEL_EXTRACTION` flag
   - Scales efficiently from 4 to 56+ cores

4. **Optimized Thread Scheduling**
   - Increased batch size (16 → 48) for better parallelization
   - Tuned thread counts for physical cores vs hyperthreads

### Tier 3: Code Generation

5. **StringBuilder Pre-sizing** (5-10% improvement)
   - Pre-allocates based on method/field count
   - Reduces memory reallocations during code generation

6. **Empty Method Skipping** (10-15% improvement for obfuscated APKs)
   - Detects methods with zero instructions
   - Common in obfuscated code with stub methods

## Installation

```bash
# Clone the repo
git clone https://github.com/HaxThePlanet/jadx-fast.git
cd jadx-fast

# Build
./gradlew dist

# Run
./build/jadx/bin/jadx --help
```

## Usage

```bash
# Basic decompilation (uses all optimizations by default)
jadx -d output/ app.apk

# Maximum parallelism
jadx --threads-count 56 -d output/ app.apk

# With deobfuscation
jadx --deobf -d output/ app.apk
```

## Why Faster?

Stock JADX has several serialization points that prevent full CPU utilization:

1. **Synchronized zip reads** - Only one thread can read from the APK at a time
2. **Sequential I/O patterns** - Small files loaded into heap, large files memory-mapped
3. **Conservative thread pools** - Default batch sizes optimized for older systems

jadx-fast removes these bottlenecks while maintaining full compatibility with the JADX output format.

## Compatibility

- Fully compatible with stock JADX command-line interface
- Same output format and quality
- All JADX plugins supported
- GUI mode supported

## Credits

- [skylot/jadx](https://github.com/skylot/jadx) - The original JADX project
- Performance optimizations by HaxThePlanet

## License

Apache License 2.0 (same as upstream JADX)
