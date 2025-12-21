# Issue Tracker

**Status:** All P0 + P1 Fixed (Dec 21, 2025) | Open: 1 Investigation, 2 Gaps, 2 Polish

## Open Issues

### Investigation (Blocked)

| ID | Issue | Status | Details |
|----|-------|--------|---------|
| INV-001 | Zara APK hang | APK unavailable for testing | [KNOWN_ISSUES.md](KNOWN_ISSUES.md#hanging-apk-zara-android-app) |

### P2 Quality Gaps

| ID | Issue | Impact | Details |
|----|-------|--------|---------|
| GAP-001 | Kotlin package deobfuscation | ~854 files appear "missing" due to obfuscated paths | [GRADE_SUMMARY.md](../qa_reports/GRADE_SUMMARY.md#large-apk-854-missing---actually-path-differences) |
| GAP-002 | Variable naming quality | 0.70-0.81 vs JADX 0.93 | Type-based naming gap |

### P3 Polish

| ID | Issue | Action |
|----|-------|--------|
| POL-001 | Add library skip filters | appsflyer, revenuecat, zendesk SDKs |
| POL-002 | Cosmetic formatting | Whitespace, parentheses, FQN vs simple names (~5%) |

### Performance TODOs

See [PERFORMANCE.md](PERFORMANCE.md#implementation-status) for tracked optimizations (P0-3 remaining, P1-2/P1-4 open).

---

## Fixed Issues (Dec 21, 2025)

### P1 Semantic Issues

| ID | Bug | Fix |
|----|-----|-----|
| NEW-008 | Malformed synchronized blocks | ACC_DECLARED_SYNCHRONIZED flag handling |
| NEW-009 | Missing imports | ConstClass, InstanceGet/Put, InvokeCustom collection |
| NEW-010 | Boolean vs null comparisons | Method name heuristics (is*, has*, can*) |
| NEW-011 | Parameter/field mismatch | SSA version 0 fallback for params |
| NEW-012 | Constructor result discarded | Assign to variable on tracking failure |

### P0 Compilation Errors

| ID | Bug | Fix |
|----|-----|-----|
| NEW-001 | Static final = null + reassign | Track final field initialization |
| NEW-002 | Undefined/uninitialized variables | PHI node constant tracking |
| NEW-003 | throw non-Throwable validation | Emit `throw null;` with warning |
| NEW-004 | Variable type confusion | Require exact class match for naming |
| NEW-006 | Enum wrong value types | Backwards search for register values |
| NEW-007 | Unreachable code after return | Dead code elimination |

### Previously Fixed (Dec 20, 2025)

| ID | Bug | Fixed |
|----|-----|-------|
| BUG-001 to BUG-012 | Original P0/P1 bugs | Dec 20, 2025 |
| P2-001 | JADX parity for variable naming | Dec 20, 2025 |

---

## Bug Report Template

```markdown
**Priority:** P0/P1/P2/P3
**Category:** Codegen / Control Flow / Type System / Variable Naming

**APK:** [name]
**Class:** [fully qualified]
**Method:** [if applicable]

**JADX Output (correct):**
[code]

**Dexterity Output (wrong):**
[code]

**Description:**
[explanation]
```
