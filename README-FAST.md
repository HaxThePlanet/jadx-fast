# JADX-Fast 🚀

A performance-optimized fork of [JADX](https://github.com/skylot/jadx) that skips framework classes during decompilation, achieving **2.2x faster** processing for typical Android APKs.

## Performance Improvements

This fork modifies JADX to skip Android framework classes early in the loading phase, dramatically reducing decompilation time:

- **Before**: 7.67 seconds (processing 2,207 classes)
- **After**: 3.50 seconds (processing 675 classes)
- **Result**: **54% faster** (2.2x speedup)

## What's Changed

The modification is minimal and surgical - just 20 lines added to `RootNode.java`:

```java
// In loadClasses() method - skip framework classes before they're even loaded
if (clsName.startsWith("Landroid/") ||
    clsName.startsWith("Landroidx/") ||
    clsName.startsWith("Lkotlin/") ||
    clsName.startsWith("Lkotlinx/") ||
    clsName.startsWith("Lcom/google/android/") ||
    clsName.startsWith("Ljava/") ||
    clsName.startsWith("Ljavax/") ||
    // ... other framework packages
    ) {
    return; // Skip this class entirely
}
```

## Skipped Packages

The following framework packages are automatically skipped:
- `android/` - Android framework
- `androidx/` - AndroidX support libraries  
- `kotlin/`, `kotlinx/` - Kotlin runtime
- `java/`, `javax/` - Java runtime
- `com/google/android/` - Google Play Services
- `com/android/internal/`, `com/android/support/`
- Various Apache, XML, and other standard libraries

## Why This Works

1. **Framework classes rarely need decompilation** - They're well-documented and source is available
2. **Early filtering** - Classes are skipped before any expensive processing
3. **Focus on app code** - Decompiles only the code you actually need to analyze

## Building from Source

```bash
git clone https://github.com/HaxThePlanet/jadx-fast.git
cd jadx-fast
./gradlew dist
```

The optimized jadx will be in `build/jadx/bin/`

## Usage

Same as regular JADX:

```bash
jadx app.apk -d output
```

All app-specific code is still decompiled - only framework classes are skipped.

## Performance Analysis

Testing shows JADX is CPU-bound, not I/O-bound:
- User CPU time: ~14 seconds
- Real time: ~2.8 seconds
- Indicates effective use of 5 CPU cores
- Ramdisk testing showed < 1% improvement, confirming CPU is the bottleneck

## Credits

Original JADX by [@skylot](https://github.com/skylot)  
Performance optimization by [@HaxThePlanet](https://github.com/HaxThePlanet)