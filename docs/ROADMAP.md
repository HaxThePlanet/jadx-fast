# Roadmap

**Status:** All P0 + P1 Fixed, Kotlin 100% (Dec 21, 2025)
**See:** [QUALITY_STATUS.md](QUALITY_STATUS.md) for grades | [ISSUE_TRACKER.md](ISSUE_TRACKER.md) for issues

---

## Open Work

### P2 Quality Gaps

| ID | Issue | Impact |
|----|-------|--------|
| GAP-001 | Kotlin package deobfuscation | ~854 files appear under obfuscated paths |
| GAP-002 | Variable naming quality | 0.70-0.81 vs JADX 0.93 |

### P3 Polish

| ID | Issue | Action |
|----|-------|--------|
| POL-001 | Library skip filters | appsflyer, revenuecat, zendesk |
| POL-002 | Cosmetic formatting | Whitespace, parentheses (~5%) |

### Performance TODOs

See [PERFORMANCE.md](PERFORMANCE.md#implementation-status) for P0-3/P1-2/P1-4 open items.

### Future Features

- APKS (App Bundle split) input format
- Memory reduction, startup optimization

---

## Completed

### Kotlin Metadata (Dec 20-21, 2025) - 100% JADX Parity

- BitEncoding decoder (UTF-8 + 8-to-7 modes)
- StringTableTypes for d2 string resolution
- 68 predefined Kotlin strings
- All function modifiers: suspend/inline/infix/operator/tailrec
- Extension function receiver_type
- Type variance (`<in T>`, `<out T>`)
- Data/sealed/value class detection

### Bug Fixes (Dec 21, 2025)

- **P0 (6):** Static final init, undefined vars, throw validation, type confusion, enum values, dead code
- **P1 (5):** Synchronized blocks, imports, boolean comparisons, param/field, constructor result

See [ISSUE_TRACKER.md](ISSUE_TRACKER.md#fixed-issues-dec-21-2025) for details.
