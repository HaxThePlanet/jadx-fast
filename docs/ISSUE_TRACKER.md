# Issue Tracker

**Status:** 5 P1 Issues Open (Dec 20, 2025) - All P0 Fixed

## Open Issues - P1 High (Wrong Semantics)

### NEW-008: Malformed Synchronized Blocks
**Priority:** P1 - WRONG SEMANTICS
**Scope:** 10+ methods - Statements outside sync that should be inside

### NEW-009: Missing Imports
**Priority:** P1 - WRONG SEMANTICS
**Scope:** Many files - `Function1`, `List` used without import

### NEW-010: Boolean vs Null Comparisons
**Priority:** P1 - WRONG SEMANTICS
**Scope:** Multiple - `isClosed() == null` where boolean

### NEW-011: Parameter/Field Mismatch
**Priority:** P1 - WRONG SEMANTICS
**Scope:** 30+ methods - Wrong parameter assigned to field

### NEW-012: Constructor Result Discarded
**Priority:** P1 - WRONG SEMANTICS
**Scope:** 20+ methods - `new Foo(...)` result not assigned

---

## Previously Fixed

| ID | Bug | Fixed |
|----|-----|-------|
| BUG-001 to BUG-012 | Original P0/P1 bugs | Dec 20, 2025 |
| NEW-001 | Static final = null + reassign | Dec 20, 2025 |
| NEW-002 | Undefined/uninitialized variables | Dec 20, 2025 |
| NEW-003 | throw non-Throwable validation | Dec 20, 2025 |
| NEW-004 | Variable type confusion | Dec 20, 2025 |
| NEW-005 | Kotlin INSTANCE (NOT A BUG) | Dec 20, 2025 |
| NEW-006 | Enum wrong types / backwards search | Dec 20, 2025 |
| NEW-007 | Unreachable code after return | Dec 20, 2025 |
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
