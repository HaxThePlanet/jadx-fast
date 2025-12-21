# Issue Tracker

**Status:** Open: 7 P0, 12 P1, 5 P2 (Dec 21, 2025)
**Reference Files:**
- `com/amplitude/api/f.java` (AmplitudeClient - 1033 lines)
- `f/c/a/f/a/d/n.java` (NativeLibraryExtractor - 143 lines)

## Open Issues

### P0 Critical (Won't Compile)

| ID | Issue | Example | Location |
|----|-------|---------|----------|
| P0-C01 | Duplicate import names | `import f.a.a.a; import f.a.b.a;` | class_gen.rs |
| P0-C02 | Undefined variables in constructors | `this.c = obj5;` (obj5 undefined) | body_gen.rs |
| P0-C03 | Assignment in parentheses | `(this.c.F = i3);` invalid syntax | body_gen.rs |
| P0-C04 | Unreachable code after return | Code after `return this;` | body_gen.rs |
| P0-C05 | Variable shadows parameter | `String str;` shadows param `str` | body_gen.rs |
| P0-C06 | Wrong constructor chain | `super(null)` instead of `this(null)` | method_gen.rs |
| P0-C07 | Undefined variable references | `fVar5.f = str2;` (fVar5 undefined) | body_gen.rs |

### P1 Semantic (Wrong Behavior)

| ID | Issue | Example | Location |
|----|-------|---------|----------|
| P1-S01 | Empty if blocks missing return | `if (cond) {}` should have `return;` | body_gen.rs |
| P1-S02 | Boolean vs int confusion | `set(0)` instead of `set(false)` | type_inference.rs |
| P1-S03 | Wrong return value | Returns `i` ignoring ternary result | body_gen.rs |
| P1-S04 | Wrong method signature call | 2 args passed to 1-arg method | body_gen.rs |
| P1-S05 | Control flow logic wrong | `j -= l2; j = j < l` garbled | conditions.rs |
| P1-S06 | Missing try-catch blocks | JSONException catch missing | body_gen.rs |
| P1-S07 | Truncated loop body | While loop body incomplete | body_gen.rs |
| P1-S08 | Method calls before guard | `matcher.group()` before `matches()` | body_gen.rs |
| P1-S09 | For-each over Iterator | `for (x : iterator)` illegal Java | body_gen.rs |
| P1-S10 | Code after loop ends | `it.next()` after while loop | body_gen.rs |
| P1-S11 | Missing throws declaration | `throws IOException` omitted | method_gen.rs |
| P1-S12 | Empty catch block | `catch (E e) {}` loses exception | body_gen.rs |

### P2 Quality Issues

| ID | Issue | Impact |
|----|-------|--------|
| P2-Q01 | Missing field rename comments | No `/* renamed from */` comments |
| P2-Q02 | Synthetic accessor methods visible | Should be hidden |
| P2-Q03 | Wrong import classes | `BitmapFactory.Options` instead of app classes |
| P2-Q04 | JADX WARNING comments | `Object /* JADX WARNING */` in output |
| P2-Q05 | Unused variable declarations | `int cmp = Long.compare(...)` never used |

### Investigation (Blocked)

| ID | Issue | Status | Details |
|----|-------|--------|---------|
| INV-001 | Zara APK hang | APK unavailable | [KNOWN_ISSUES.md](KNOWN_ISSUES.md#inv-001-hanging-apk---zara-android-app) |

### Previously Tracked (Superseded)

| ID | Issue | Status |
|----|-------|--------|
| GAP-001 | Kotlin package deobfuscation | Superseded by P0/P1 bugs |
| GAP-002 | Variable naming quality | Superseded by P0/P1 bugs |
| POL-001 | Library skip filters | Low priority |
| POL-002 | Cosmetic formatting | Low priority |

### Performance TODOs

See [PERFORMANCE.md](PERFORMANCE.md#implementation-status) for tracked optimizations.

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
