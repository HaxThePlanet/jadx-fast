# Issue Tracker

**Status:** Open: 0 P0, 11 P1, 3 P2 | Phase 1 + Phase 2 + Phase 3 Complete (Dec 21, 2025)
**Reference Files:**
- `com/amplitude/api/f.java` (AmplitudeClient - 1033 lines)
- `f/c/a/f/a/d/n.java` (NativeLibraryExtractor - 143 lines)

## Open Issues

### P0 Critical (Won't Compile)

| ID | Issue | Example | Location |
|----|-------|---------|----------|
| ~~P0-C01~~ | ~~Duplicate import names~~ | **FIXED** - Filter conflicting simple names | class_gen.rs |
| ~~P0-C02~~ | ~~Undefined variables in constructors~~ | **FIXED** - Wide type register offset | body_gen.rs |
| ~~P0-C03~~ | ~~Assignment in parentheses~~ | **FIXED** - Remove unnecessary parens | body_gen.rs |
| ~~P0-C04~~ | ~~Unreachable code after return~~ | **FIXED** - Skip code after throw/return | body_gen.rs |
| ~~P0-C05~~ | ~~Variable shadows parameter~~ | **FIXED** - Register param names | body_gen.rs |
| ~~P0-C06~~ | ~~Wrong constructor chain~~ | **FIXED** - Normalize class type format | body_gen.rs |
| ~~P0-C07~~ | ~~Undefined variable references~~ | **FIXED** - Use write_arg_inline() for inlined exprs | body_gen.rs |

### P1 Semantic (Wrong Behavior)

| ID | Issue | Example | Location |
|----|-------|---------|----------|
| ~~P1-S01~~ | ~~Empty if blocks missing return~~ | **FIXED** - is_empty_region() fix | body_gen.rs |
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
| ~~P2-Q04~~ | ~~JADX WARNING comments~~ | **FIXED** - Changed to Dexterity branding |
| P2-Q05 | Unused variable declarations | `int cmp = Long.compare(...)` never used |

### Investigation (Blocked)

| ID | Issue | Status | Details |
|----|-------|--------|---------|
| INV-001 | Zara APK hang | APK unavailable | [KNOWN_ISSUES.md](KNOWN_ISSUES.md#inv-001-hanging-apk---zara-android-app) |

### Previously Tracked (Completed or Superseded)

| ID | Issue | Status |
|----|-------|--------|
| ~~GAP-001~~ | ~~Kotlin package deobfuscation~~ | **FIXED** - get_aliased_class_name() + extract_and_register_package_alias() |
| ~~GAP-002~~ | ~~Variable naming quality~~ | **FIXED** - OBJ_ALIAS exact matching, GOOD_VAR_NAMES, toString(), type+method fallback |
| POL-001 | Library skip filters | Low priority |
| POL-002 | Cosmetic formatting | Low priority |

### Performance TODOs

See [PERFORMANCE.md](PERFORMANCE.md#implementation-status) for tracked optimizations.

---

## Fixed Issues (Dec 21, 2025)

### Phase 2: Boolean Expression Simplification (Dec 21 PM)

| ID | Bug | Fix |
|----|-----|-----|
| COND-001 | Short-circuit OR not detected | Added MergeMode::Or with can_merge() and merge() logic |
| COND-002 | OR type 2 pattern missing | Detect when both conditions branch to same "true" target |
| COND-003 | Cross-branch block inclusion | Added barrier parameter to collect_branch_blocks_with_barrier() |
| COND-004 | Wrong then/else for merged OR | Fixed then_block/else_block assignment in MergedCondition::merge() |

**Files changed:** `conditionals.rs`, `region_builder.rs`

### Phase 1: Static Field Inline Initialization (Dec 21 PM)

| ID | Bug | Fix |
|----|-----|-----|
| INIT-001 | Static field inline init | NewInstance variant in FieldValue for `new ClassName()` patterns |
| INIT-002 | new-instance pattern detection | extract_field_init.rs detects new-instance + invoke-direct + sput-object |
| INIT-003 | Empty static initializers | method_gen.rs skips `static {}` blocks with only return-void |
| INIT-004 | NewInstance rendering | class_gen.rs renders `new ClassName()` for static field initializers |

**Files changed:** `info.rs`, `extract_field_init.rs`, `class_gen.rs`, `method_gen.rs`

### Latest Fixes (Dec 21 PM)

| ID | Bug | Fix |
|----|-----|-----|
| P0-C04 | Unreachable code after return | emitted_exit tracking in generate_block() |
| P1-S01 | Empty if blocks missing return | Enhanced is_empty_region_with_ctx() recursion |
| VAR-001 | OBJ_ALIAS exact matching | Changed from contains() to exact FQN matching |
| VAR-002 | GOOD_VAR_NAMES set | Added "list" and "map" to direct-use names (13 total) |
| VAR-003 | toString() handling | Returns declaring class name (e.g., Pattern.toString() -> "pattern") |
| VAR-004 | Type+method fallback | make_type_method_name() (e.g., Pattern.compile() -> "patternCompile") |
| PKG-001 | Kotlin package deobfuscation | get_aliased_class_name() + extract_and_register_package_alias() |
| BRAND-001 | Dexterity branding | Changed JADX -> Dexterity in all warning comments |

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
