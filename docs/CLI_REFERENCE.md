# CLI Reference

Dexterity is a drop-in replacement for JADX. Same CLI arguments, same output structure.

## Basic Usage

```bash
# Build
cd crates
cargo build --release -p dexterity-cli

# Decompile an APK
./target/release/dexterity -d output/ app.apk

# With deobfuscation
./target/release/dexterity --deobf -d output/ app.apk

# Export as Gradle project
./target/release/dexterity -e -d output/ app.apk
```

## Input/Output

| Flag | Description |
|------|-------------|
| `<input>` | Input file(s): APK, DEX, JAR, AAR, AAB, XAPK, APKM |
| `-d, --output-dir` | Output directory |
| `--output-dir-src` | Output directory for sources only |
| `--output-dir-res` | Output directory for resources only |
| `-r, --no-res` | Skip resources decompilation |
| `-s, --no-src` | Skip sources decompilation |
| `--include-framework` | Include framework classes (android.*, androidx.*, kotlin.*, kotlinx.*) |
| `--single-class` | Decompile single class by name |

## Deobfuscation

| Flag | Description |
|------|-------------|
| `--deobf` | Enable deobfuscation |
| `--deobf-min` | Minimum name length to keep (default: 3) |
| `--deobf-max` | Maximum name length (default: 64) |
| `--mappings-path` | Path to ProGuard mappings file |
| `--deobf-cfg-file` | Path to JOBF aliases file |
| `--deobf-cfg-file-mode` | File mode: `read`, `save`, `read-or-save` |
| `--deobf-whitelist` | Package pattern to skip (repeatable) |

Note: `--deobf-min` and `--deobf-max` apply to all names including local variables.

## Export

| Flag | Description |
|------|-------------|
| `-e, --export-gradle` | Export as Gradle project |
| `--export-gradle-type` | Gradle project type |

## Code Generation

| Flag | Description |
|------|-------------|
| `--no-imports` | Disable import statements |
| `--no-debug-info` | Disable debug info in output |
| `--no-inline-anonymous` | Disable anonymous class inlining |
| `--no-inline-methods` | Disable method inlining |
| `--no-move-inner-classes` | Keep inner classes in separate files |
| `--no-kotlin-metadata` | Disable Kotlin metadata parsing |
| `--escape-unicode` | Escape unicode characters in strings |
| `--respect-bytecode-access-modifiers` | Use original access modifiers |
| `--no-replace-consts` | Disable R.* resource field resolution |
| `-f, --fallback` | Set decompilation mode to fallback (raw instruction dump) |

### Resource Resolution

By default, resource IDs like `0x7f040001` are replaced with `R.layout.activity_main`. Use `--no-replace-consts` to show raw hex IDs.

## Performance

| Flag | Description |
|------|-------------|
| `-j, --threads-count` | Number of threads (default: all cores) |

### THP Optimization

For best performance on high-core systems, enable Transparent Huge Pages:

```bash
MALLOC_CONF="metadata_thp:always,thp:always" ./target/release/dexterity -d output/ app.apk
```

## Output Control

| Flag | Description |
|------|-------------|
| `-v, --verbose` | Verbose output |
| `-q, --quiet` | Quiet mode |
| `--log-level` | Log level: `quiet`, `progress`, `info`, `debug` |

## Examples

```bash
# Basic decompilation
./target/release/dexterity -d output/ app.apk

# Include framework classes (larger output)
./target/release/dexterity --include-framework -d output/ app.apk

# Deobfuscate short names
./target/release/dexterity --deobf --deobf-min 2 -d output/ app.apk

# Use ProGuard mapping
./target/release/dexterity --mappings-path mapping.txt -d output/ app.apk

# Single-threaded for debugging
./target/release/dexterity -j 1 -d output/ app.apk

# Gradle project export
./target/release/dexterity -e -d output/ app.apk
```
