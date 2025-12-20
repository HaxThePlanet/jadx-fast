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

## Decompilation Mode

| Flag | Description |
|------|-------------|
| `-m, --decompilation-mode` | Mode: `auto`, `restructure`, `simple`, `fallback` (default: auto) |
| `-f, --fallback` | Shortcut for `--decompilation-mode fallback` (raw instruction dump) |
| `--show-bad-code` | Show incorrectly decompiled code instead of stub |
| `--type-update-limit` | Type inference iteration limit (default: 10) |

## Code Generation

| Flag | Description |
|------|-------------|
| `--no-imports` | Disable import statements |
| `--no-debug-info` | Disable debug info in output |
| `--add-debug-lines` | Add comments with debug line numbers |
| `--no-inline-anonymous` | Disable anonymous class inlining |
| `--no-inline-methods` | Disable method inlining |
| `--no-move-inner-classes` | Keep inner classes in separate files |
| `--no-inline-kotlin-lambda` | Disable Kotlin lambda inlining |
| `--no-finally` | Don't extract finally blocks |
| `--no-kotlin-metadata` | Disable Kotlin metadata parsing |
| `--no-restore-switch-over-string` | Don't restore switch over string |
| `--escape-unicode` | Escape unicode characters in strings |
| `--respect-bytecode-access-modifiers` | Use original access modifiers |
| `--no-replace-consts` | Disable R.* resource field resolution |
| `--integer-format` | Integer display: `auto`, `decimal`, `hexadecimal` (default: auto) |
| `--comments-level` | Comment verbosity: `none`, `error`, `warn`, `info`, `debug` (default: info) |

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

## Advanced Deobfuscation

| Flag | Description |
|------|-------------|
| `--mappings-mode` | Mappings file handling: `read`, `read-and-autosave-every-change`, `read-and-autosave-before-closing`, `ignore` |
| `--deobf-res-name-source` | Resource name source: `auto`, `resources`, `code` (default: auto) |
| `--use-source-name-as-class-name-alias` | Use source file name: `always`, `if-better`, `never` |
| `--source-name-repeat-limit` | Max source name repeats before renaming (default: 10) |
| `--rename-flags` | Rename modes: `case`, `valid`, `printable`, `none`, `all` (default: all) |
| `--fs-case-sensitive` | Treat filesystem as case sensitive |

## Kotlin Options

| Flag | Description |
|------|-------------|
| `--use-kotlin-methods-for-var-names` | Use Kotlin param names: `disable`, `apply`, `apply-and-hide` |

## Debug Options

| Flag | Description |
|------|-------------|
| `--cfg` | Save control flow graph to dot file |
| `--raw-cfg` | Save raw control flow graph |
| `--single-class-output` | Output file/dir for single class mode |
| `--output-format` | Output format: `java`, `json` (default: java) |

## LLM Post-Processing (Experimental)

| Flag | Description |
|------|-------------|
| `--llm-add-comments` | Add LLM-generated comments to decompiled code |
| `--llm-backend` | LLM backend: `auto`, `anthropic`, `ollama` |
| `--llm-model` | LLM model override |

## Not Yet Implemented

| Flag | Description |
|------|-------------|
| `--enable-knox-vision` | Knox Vision integration (stub) |
| `--knox-vision-path` | Path to Knox Vision tool (stub) |

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

# Show bad code instead of stubs
./target/release/dexterity --show-bad-code -d output/ app.apk

# Fallback mode (raw instructions)
./target/release/dexterity -f -d output/ app.apk
```
