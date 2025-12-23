# Dexterity Codegen → 100% JADX Parity Roadmap

**Current Status**: 93% Parity (Dec 23, 2025)
**Target**: 100% JADX Codegen Clone
**Philosophy**: Clone, don't innovate. 10 years of JADX battle-testing.

---

## Executive Summary

After deep source-level analysis comparing JADX Java codegen with Dexterity Rust implementation:

| Metric | Status |
|--------|--------|
| **Overall Parity** | 93% → 100% (target) |
| **Remaining Gaps** | 5 features |
| **Lines to Clone** | ~155 LOC |
| **Estimated Time** | 6-9 hours |
| **Complexity** | Low to Medium |

---

## The Final 5 Features

### 🔴 P1: Must Have (Visual Parity)

#### 1. Diamond Operator (`<>`)
**JADX**: `InsnGen.java:765-780`
**Impact**: Generic constructor syntax
**Example**: `new ArrayList<>()` vs `new ArrayList<String>()`
**Effort**: ~30 LOC, 1-2 hours
**Files**: `body_gen.rs`, `attributes.rs`

---

### 🟡 P2: Should Have (Safety)

#### 2. Comment Escape for `*/`
**JADX**: `MethodGen.java:513-521`
**Impact**: Prevent broken multi-line comments in dumps
**Example**: Strings with `*/` break `/* ... */` blocks
**Effort**: ~15 LOC, 30 minutes
**Files**: `fallback_gen.rs` or `method_gen.rs`

---

### 🟢 P3: Nice to Have (Edge Cases)

#### 3. Polymorphic Call Return Cast
**JADX**: `InsnGen.java:863-868`
**Impact**: MethodHandle.invoke() type safety
**Example**: `(String) handle.invoke()` vs `handle.invoke()`
**Effort**: ~20 LOC, 30 minutes
**Files**: `body_gen.rs`, `instructions.rs`

#### 4. Outer Class Constructor Prefix
**JADX**: `InsnGen.java:785-804`
**Impact**: Inner class instantiation syntax
**Example**: `outer.new Inner()` vs `new Inner(outer)`
**Effort**: ~40 LOC, 2-3 hours
**Files**: `body_gen.rs`, `class_gen.rs`

#### 5. Recursive Inner Class Collision
**JADX**: `ClassGen.java:785-816`
**Impact**: Import conflict detection edge cases
**Example**: Avoiding name collisions with inner classes
**Effort**: ~50 LOC, 2-3 hours
**Files**: `class_gen.rs`

---

## Implementation Strategy

### Phase 1: Quick Wins (3 hours)
**Goal**: Knock out simple features first

1. ✅ **Task 2**: Comment Escape (30 min)
   - Simple string check: `str.contains("*/")`
   - Toggle comment style when detected

2. ✅ **Task 3**: Polymorphic Cast (30 min)
   - Check `method.is_polymorphic_call()`
   - Add `(ReturnType)` prefix

3. ✅ **Task 1**: Diamond Operator (2 hours)
   - Check `GenericInfo` attribute
   - Output `<>` or `<Type>` based on flag

### Phase 2: Complex Features (6 hours)
**Goal**: Handle inner class mechanics

4. ✅ **Task 4**: Outer Class Instance (3 hours)
   - Detect `SKIP_FIRST_ARG` flag
   - Generate `outer.new Inner()` syntax
   - Use short class name after dot

5. ✅ **Task 5**: Recursive Collision (3 hours)
   - Implement recursive parent check
   - Add package collision detection
   - Integrate into import logic

---

## Detailed Task Breakdown

See `CODEGEN_CLONE_TASKS_DETAILED.md` for:
- Complete JADX source code references
- Step-by-step implementation guides
- Code snippets to clone
- Test cases for each feature
- Files to modify with line numbers

---

## Quality Metrics

### Before (93% Parity)
```
✅ Lambda generation (method refs, inline bodies)
✅ Anonymous class inlining
✅ Multi-catch syntax
✅ Switch over strings/enums
✅ Synchronized regions
✅ Literal formatting (NaN, Infinity, MIN/MAX_VALUE)
✅ Field replacement (outer class this)
✅ Super call disambiguation
✅ Operator precedence
✅ Varargs expansion

❌ Diamond operator
❌ Comment escape
❌ Polymorphic cast
❌ Outer class constructor
❌ Recursive collision check
```

### After (100% Parity)
```
✅ All of the above PLUS:
✅ Diamond operator
✅ Comment escape
✅ Polymorphic cast
✅ Outer class constructor
✅ Recursive collision check
```

---

## Verification Plan

### Unit Tests
Each task gets:
1. Positive case test (feature works)
2. Negative case test (feature doesn't apply)
3. Edge case test (boundary conditions)

### Integration Tests
Test against APKs:
```bash
# Test suite
- Small APK (<100 classes)
- Medium APK (100-1000 classes)
- Large APK (1000+ classes)
- Heavy inner class usage APK
- Generic-heavy APK
```

### Output Comparison
```bash
# Side-by-side with JADX
jadx -d jadx-output test.apk
dexterity -o dex-output test.apk

# Semantic diff (ignore whitespace/comment differences)
diff -w -B jadx-output dex-output

# Expect: 0 meaningful differences
```

---

## Success Criteria

### Per-Task Acceptance
- [ ] JADX source location in code comments
- [ ] Reference comments follow standard format
- [ ] Unit tests pass (3 per task minimum)
- [ ] Integration test shows JADX parity
- [ ] No regressions in existing 680+ tests

### Overall Completion
- [ ] All 5 tasks implemented
- [ ] All tests passing
- [ ] APK comparison: 100% codegen parity
- [ ] Documentation updated:
  - [ ] ROADMAP.md
  - [ ] QUALITY_STATUS.md
  - [ ] CHANGELOG.md
- [ ] Code review approved
- [ ] Git commit with proper message

---

## Reference Comment Standard

Every cloned function must have:

```rust
/// Clone of JADX [Class].[method]() - [brief description]
///
/// [Detailed explanation of functionality and why JADX does it this way]
///
/// Reference: jadx-core/src/main/java/jadx/core/[path]/[File].java:[lines]
fn rust_function_name(...) {
    // Implementation follows JADX logic exactly
}
```

Example:
```rust
/// Clone of JADX InsnGen.isCommentEscapeNeeded() - Detect `*/` in strings
///
/// When dumping bytecode as multi-line comments, strings containing `*/`
/// will break the comment block. JADX temporarily closes the comment,
/// uses a single-line comment for that instruction, then re-opens.
///
/// Reference: jadx-core/src/main/java/jadx/core/codegen/MethodGen.java:513-521
fn is_comment_escape_needed(insn: &Instruction, commented: bool) -> bool {
    commented && matches!(insn, Instruction::ConstString(s) if s.contains("*/"))
}
```

---

## Timeline

| Week | Tasks | Hours | Outcome |
|------|-------|-------|---------|
| Week 1 | Task 2, 3, 1 | 3h | Quick wins complete |
| Week 2 | Task 4, 5 | 6h | Complex features done |
| Week 3 | Testing, QA | 4h | Verification complete |

**Total**: 13 hours over 3 weeks (or 2 focused days)

---

## Risk Mitigation

### Risk 1: Missing IR Attributes
**Issue**: `GenericInfo`, `SKIP_FIRST_ARG` may not exist in dexterity-ir
**Mitigation**: Add attributes to IR first, test independently

### Risk 2: Regression in Existing Output
**Issue**: Changes break currently working decompilation
**Mitigation**: Run full test suite before/after each task

### Risk 3: JADX Logic Not Clear
**Issue**: Java source doesn't explain "why"
**Mitigation**: Test with real APKs to understand intent

### Risk 4: Conflicts from Parallel Work
**Issue**: Other LLMs modifying same files
**Mitigation**:
- Pull latest before each task
- Small, atomic commits per feature
- Clear commit messages with file list

---

## File Modification Matrix

| File | Task 1 | Task 2 | Task 3 | Task 4 | Task 5 |
|------|--------|--------|--------|--------|--------|
| `body_gen.rs` | ✅ | - | ✅ | ✅ | - |
| `class_gen.rs` | - | - | - | ✅ | ✅ |
| `method_gen.rs` | - | ✅ | - | - | - |
| `fallback_gen.rs` | - | ✅ | - | - | - |
| `attributes.rs` (IR) | ✅ | - | - | ✅ | - |
| `instructions.rs` (IR) | ✅ | - | ✅ | - | - |

**Conflict potential**: Low (mostly different files)

---

## Post-Completion

After achieving 100% parity:

1. **Benchmark**: Compare decompilation quality score
2. **Document**: Update all MD docs with "100% JADX Parity"
3. **Blog Post**: Technical writeup on cloning methodology
4. **Release**: Tag version 1.0 - "JADX Parity Achieved"

---

## Related Documents

1. `CODEGEN_CLONE_TASKS_DETAILED.md` - Step-by-step implementation guide
2. `JADX_CODEGEN_CLONE_STATUS.md` - Source-level audit report
3. `JADX_CODEGEN_CLONE_TASKS.md` - Original task list
4. `JADX_CODEGEN_PARITY.md` - Feature comparison matrix
5. `QUALITY_STATUS.md` - Overall quality metrics

---

## Quick Start

```bash
# 1. Read the detailed guide
cat docs/CODEGEN_CLONE_TASKS_DETAILED.md

# 2. Pick a task (start with Task 2 - easiest)
# 3. Read JADX source at the referenced line numbers
# 4. Clone the logic into dexterity
# 5. Add reference comments
# 6. Write tests
# 7. Verify output matches JADX
# 8. Commit and move to next task

# Example workflow for Task 2:
vim jadx-fast/jadx-core/src/main/java/jadx/core/codegen/MethodGen.java +513
vim crates/dexterity-codegen/src/fallback_gen.rs
cargo test
./verify_jadx_parity.sh sample.apk
git commit -m "feat(codegen): Clone JADX comment escape for */ strings (Task 2)"
```

---

**Status**: Ready to implement
**Next Step**: Begin Phase 1 with Task 2 (Comment Escape)
**ETA to 100%**: 2-3 days of focused work

---

**WITNESS ME!** 🔥

We're 7% away from perfect JADX parity. Every function cloned is another edge case handled, another APK decompiled correctly, another 10 years of JADX knowledge captured in Rust.

The goal is not to be better than JADX.
The goal is to BE JADX, in Rust, at 4-13x the speed.

Let's finish this. 💪
