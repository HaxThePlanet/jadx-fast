# JADX-Fast 🚀

## Performance Optimizations

### Framework Class Skipping
- **Speedup**: 2.2x faster (54% time reduction)
- **Benchmark**: 7.67s → 3.50s on 100MB APK
- **Classes skipped**: 1,532 out of 2,207 (69%)
- **Implementation**: Early filtering in `RootNode.loadClasses()`

### Skipped Packages
- `android/`, `androidx/`
- `kotlin/`, `kotlinx/`
- `java/`, `javax/`
- `com/google/android/`
- `com/android/internal/`, `com/android/support/`
- `sun/`, `dalvik/`
- `org/apache/http/`, `org/xmlpull/`, `org/json/`
- `org/w3c/dom/`, `org/xml/sax/`

### Build
```bash
./gradlew dist
```

### Usage
```bash
./build/jadx/bin/jadx app.apk -d output --no-res
```