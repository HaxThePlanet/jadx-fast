# Roadmap

**Current Status:** Production Ready (Dec 20, 2025) - All P0/P1 bugs fixed
**See:** [QUALITY_STATUS.md](QUALITY_STATUS.md) for current quality grades

## Remaining Work

### P2 - Medium Priority

| Issue | Description | Status |
|-------|-------------|--------|
| Variable naming in complex methods | str2, str3, i2-i9 instead of semantic names | Open |
| Self-reference simplification | `Flowable.empty()` → `empty()` for same-class calls | **FIXED Dec 20** |

### P3 - Low Priority (Cosmetic)

| Issue | Description | Status |
|-------|-------------|--------|
| Empty else blocks | Remove empty `else {}` blocks | Cosmetic |
| Code verbosity | ~10-15% more verbose than JADX in some files | Cosmetic |

## Future Enhancements

### Input Format Support

| Format | Status |
|--------|--------|
| APK, DEX, JAR, AAR, AAB | Supported |
| XAPK, APKM | Supported |
| APKS (App Bundle split) | Not implemented |
| Smali assembly | Not planned |
| .class files | Not planned |

### Kotlin Parity (Currently 72%)

- Type variance annotations (`in`/`out`)
- Suspend function detection
- Inline class unwrapping
- Property delegation patterns

### Performance Optimizations

- Further memory reduction for huge APKs
- Startup time optimization
- Incremental decompilation

## Not Planned

- GUI application
- IDE plugins
- Web interface

---

For current quality status, see [QUALITY_STATUS.md](QUALITY_STATUS.md).
For known issues, see [KNOWN_ISSUES.md](KNOWN_ISSUES.md).
For development history, see [CHANGELOG.md](CHANGELOG.md).
