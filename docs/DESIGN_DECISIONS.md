# Design Decisions

## Framework & Library Filtering (Default Behavior)

By default, Dexterity **skips framework and common library classes** for faster output and smaller size.

### Why Filter?

1. **Performance:** 3.6-81x faster decompilation
2. **Output Size:** 50-95% smaller output
3. **Focus:** App code is what you usually want to analyze
4. **Stability:** Framework classes are well-documented and rarely need decompilation

### Framework Packages Skipped

| Package | Description |
|---------|-------------|
| `android.*` | Android framework |
| `androidx.*` | AndroidX support libraries |
| `kotlin.*` | Kotlin stdlib |
| `kotlinx.*` | Kotlin extensions |
| `java.*` | Java stdlib |
| `javax.*` | Java extensions |

### Library Packages Skipped

| Package | Description |
|---------|-------------|
| `com.google.android.gms.*` | Google Play Services |
| `com.google.firebase.*` | Firebase |
| `com.google.common.*` | Guava |
| `com.squareup.*` | Square libraries |
| `okhttp3.*` | OkHttp |
| `retrofit2.*` | Retrofit |
| `com.facebook.*` | Facebook SDK |
| `com.bumptech.glide.*` | Glide image loading |
| `io.reactivex.*` | RxJava |
| `rx.*` | RxJava legacy |
| `com.fasterxml.jackson.*` | Jackson JSON |
| `org.apache.commons.*` | Apache Commons |
| `org.slf4j.*` | SLF4J logging |
| `ch.qos.logback.*` | Logback |
| `timber.*` | Timber logging |

### What's Included by Default

- All app classes (`com.yourapp.*`)
- Resources, manifests, XML
- Custom libraries not in the filter list

### Including Framework/Library Classes

Use the `--include-framework` flag:

```bash
./target/release/dexterity --include-framework -d output/ app.apk
```

### File Count Impact

Example with badboy.apk:

| Mode | Files | Size |
|------|-------|------|
| Default (filtered) | 84 | 2.6 MB |
| With `--include-framework` | 6,323 | 69 MB |

---

## Compose UI Complexity Detection

Dexterity matches JADX's handling of extremely complex Kotlin Compose UI methods.

### Problem

Kotlin Compose generates extremely complex bytecode for UI methods. Decompiling these produces thousands of lines of unreadable code.

### Solution

Methods meeting any of these criteria are detected as "too complex":
- >2000 instructions
- Compose-specific patterns (e.g., `@Composable` annotations)
- Excessive lambda nesting

### Output

Complex methods emit a clean 7-line stub matching JADX:

```java
public static final void Greeting(...) {
    /*
        Method decompilation skipped: too complex
        Reason: instructions count: 3779
        To view this dump add '--show-bad-code' option
    */
    throw new UnsupportedOperationException("Method not decompiled: MainActivityKt.Greeting()");
}
```

### Impact

- `MainActivityKt.Greeting()`: 939 lines of garbage -> 7-line stub
- Helper methods and simpler lambdas still decompile correctly
- Matches JADX behavior exactly

---

## Code Optimizations

Dexterity applies various code optimizations to produce readable Java:

### Increment/Decrement Patterns
```java
// Before: i = i + 1;
// After: i++;

// Before: i = i - 1;
// After: i--;

// Before: i = i + 5;
// After: i += 5;
```

### Special Numeric Values
```java
// Before: 2147483647
// After: Integer.MAX_VALUE

// Before: 0.0f / 0.0f
// After: Float.NaN
```

### Bitwise to Logical Conversion
```java
// Before: a & b (when both are boolean)
// After: a && b
```

### Condition Simplification
```java
// Before: !(a < b)
// After: a >= b
```

### Traditional For Loop Generation
```java
// Before: int i = 0; while (i < n) { ...; i++; }
// After: for (int i = 0; i < n; i++) { ... }
```

---

## Asset DEX File Handling

Dexterity attempts to parse **all `.dex` files** in an APK, including those in the `assets/` folder.

### Rationale

1. **Dynamic Code Loading:** Some apps legitimately load DEX files from assets at runtime using `DexClassLoader`
2. **Forensic Value:** Warnings about fake/corrupted DEX files inform analysts of obfuscation attempts
3. **Complete Analysis:** No DEX file is silently skipped

### Behavior

- Valid DEX files in assets are decompiled normally
- Invalid/fake DEX files log a warning and continue
- All files (valid or not) are extracted to `resources/assets/` for inspection

### Example Warning

```
WARN Failed to process assets/classes.dex: Unexpected end of data at offset 0, needed 112 bytes
```

This warning indicates the file is fake (e.g., contains JPEG data or stub text instead of DEX bytecode). See ROADMAP.md for details on specific APKs with fake DEX files.

---

## Resource Resolution

By default, resource IDs are resolved to their symbolic names:

```java
// Before: setContentView(0x7f040001);
// After: setContentView(R.layout.activity_main);
```

Use `--no-replace-consts` to disable this and show raw hex IDs.
