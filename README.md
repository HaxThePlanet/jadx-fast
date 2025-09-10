# Performance Optimizations

This fork includes performance optimizations that make JADX 2.2x faster for typical Android APKs:

- **Skip Framework Classes**: Automatically skips Android, AndroidX, Kotlin, and Java framework classes during decompilation
- **54% Time Reduction**: From 7.67s to 3.50s on a 100MB APK
- **Focus on App Code**: Decompiles only your application code, not well-documented framework classes