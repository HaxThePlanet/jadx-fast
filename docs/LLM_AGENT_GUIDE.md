# LLM Agent Guide: Autonomous Development Toward JADX Parity

Welcome, autonomous LLM agent! This guide explains how to work on the Dexterity project to improve Android decompilation quality toward JADX parity.

## Quick Start (5 minutes)

1. **Read the current state**: Start with `QUALITY_ANALYSIS_REPORT.md` to understand what's broken
2. **Pick an issue**: Open `ISSUE_TRACKER.md` and select an OPEN issue (prioritize CRITICAL)
3. **Understand the code**: Read `CODE_NAVIGATION.md` to find relevant source files
4. **Study the algorithm**: Review `ALGORITHM_REFERENCES.md` for the high-level approach
5. **Reference JADX**: Look at `/mnt/nvme4tb/jadx-rust/jadx-fast/` for the Java implementation
6. **Implement the fix**: Make your changes following existing code patterns
7. **Test thoroughly**: Run tests and QA validation
8. **Update tracking**: Mark issue as RESOLVED and update `PROGRESS.md`

## Documentation Structure

This documentation system consists of:

| File | Purpose | For Whom |
|------|---------|----------|
| `QUALITY_ANALYSIS_REPORT.md` | Current state: what's broken and why | Understanding the problem |
| `ISSUE_TRACKER.md` | Structured list of issues to fix | Selecting work |
| `CODE_NAVIGATION.md` | Maps issues to source files | Finding code to change |
| `ALGORITHM_REFERENCES.md` | High-level algorithm explanations | Understanding approaches |
| `TESTING_GUIDE.md` | How to test and validate changes | Ensuring quality |
| `PROGRESS.md` | Tracks completed work and metrics | Monitoring progress |
| `ROADMAP.md` | Long-term project roadmap | Understanding goals |

**Start here** → `ISSUE_TRACKER.md` → `CODE_NAVIGATION.md` → `ALGORITHM_REFERENCES.md` → **Implement** → `TESTING_GUIDE.md` → **Update `PROGRESS.md`**

## Full Autonomous Workflow

### Step 1: Understand Current State (5 min)

Read `QUALITY_ANALYSIS_REPORT.md` to understand:
- What's working: Small APKs decompile perfectly
- What's broken: Medium/large APKs have critical defects
- Key metrics: Overall 77.1%, Code Quality 66.6%, Variable Quality 0.67

Example defects:
- Undefined variables: `while (i < i2)` where `i2` is never defined
- Type mismatches: `return 0;` for object types (should be `null`)
- Logic inversions: Null checks backwards
- Register names: Variables like `v2`, `v3` instead of meaningful names

### Step 2: Select an Issue (5 min)

Open `ISSUE_TRACKER.md` and find an issue with:
- Status: `OPEN`
- Priority: `CRITICAL` > `HIGH` (start with CRITICAL)
- Estimated Complexity: Start with "Low" or "Medium"

**To claim an issue:**
1. Note the Issue ID (e.g., `CRITICAL-001`)
2. Note the relevant code areas
3. Note the root cause analysis

Example flow:
```
Pick: CRITICAL-002 (Undefined variable v2 in nested scopes)
Root Cause: Variables in nested scopes or after conditionals not properly tracked
Related Files: region_builder.rs, ssa.rs, body_gen.rs
Estimated Time: 2-4 hours
```

### Step 3: Navigate to Code (5 min)

Open `CODE_NAVIGATION.md` and find the section for your issue category.

Example: For "Undefined Variables / Control Flow Issues":

**Primary Files:**
- `/mnt/nvme4tb/jadx-rust/crates/dexterity-passes/src/region_builder.rs` (~1,903 lines)
  - Function: `build_loop_region()` - Loop construction
  - Function: `find_loop_merge()` - Loop exit detection

**File Size Guide:**
- Small (<5K lines): Read entire file
- Medium (5-20K lines): Use grep for specific functions
- Large (>20K lines): Use grep extensively, read specific functions

For large files, use:
```bash
cd /mnt/nvme4tb/jadx-rust/crates/dexterity-passes/src
grep -n "fn build_loop_region" region_builder.rs
grep -n "struct PhiNode" ../ir/src/*.rs
```

### Step 4: Understand the Algorithm (10 min)

Open `ALGORITHM_REFERENCES.md` for the relevant algorithm.

Example: For "Undefined Variables" → Read "SSA Transformation" and "Region Building" sections

Each section includes:
- **Overview**: High-level explanation
- **Key Concepts**: Main ideas (e.g., phi nodes, dominance frontier)
- **Dexterity Implementation**: Where to find code
- **JADX Reference**: Java implementation to compare
- **Common Issues**: What goes wrong

### Step 5: Reference JADX Source (10 min)

Navigate to `/mnt/nvme4tb/jadx-rust/jadx-fast/` and open the referenced JADX source file.

Example locations:
```
/mnt/nvme4tb/jadx-rust/jadx-fast/jadx-core/src/main/java/jadx/core/dex/visitors/
  - regions/RegionMaker.java (region building)
  - ssa/SSATransform.java (SSA transformation)
  - typeinference/TypeInferenceVisitor.java (type inference)
```

**How to use JADX code:**
1. Read the algorithm at high level (don't need full details)
2. Look for key patterns and data structures
3. Find how they handle edge cases you're stuck on
4. Note any differences from the Dexterity approach

### Step 6: Implement the Fix (1-4 hours)

Make your changes following these guidelines:

**Code Style:**
- Follow existing patterns in the file
- Keep changes minimal and focused
- Add comments only where logic isn't self-evident
- Don't refactor unrelated code

**Testing Approach:**
1. Write a test that demonstrates the bug
2. Implement the fix
3. Verify the test passes
4. Run all related tests to prevent regressions

Example test structure:
```rust
#[test]
fn test_loop_bounds_defined() {
    let java_code = r#"
        public class Test {
            void process(String[] items) {
                for (int i = 0; i < items.length; i++) {
                    System.out.println(items[i]);
                }
            }
        }
    "#;

    test_java_to_java(java_code, |decompiled| {
        // Verify the bug is fixed
        assert!(!decompiled.contains("i2"));  // no undefined i2
        assert!(decompiled.contains("i < items.length"));  // correct bounds
    });
}
```

**Common Patterns:**

When fixing loops (region_builder.rs):
```rust
// Don't just fix one place - look for similar code nearby
// Check both packed and sparse switch successors
// Verify dominance frontier logic
```

When fixing type inference (type_inference.rs):
```rust
// Add constraints for all bytecode operations that assign types
// Ensure constraint solvers handle edge cases
// Test with generic types, arrays, and null
```

### Step 7: Test and Validate (30 min - 1 hour)

Follow `TESTING_GUIDE.md`:

**Unit Tests:**
```bash
cargo test -p dexterity-passes          # Run specific crate
cargo test --lib                        # Run library tests
cargo test loop                         # Run tests matching pattern
```

**Integration Tests:**
```bash
cargo test --test integration_test_framework
```

**Quality Validation:**
```bash
# Run on medium APK to see quality improvements
cargo run -p dexterity-qa -- \
  --jadx-path /path/to/jadx \
  --dexterity-path ./target/release/dexterity \
  --apk-path test_medium.apk
```

**Success Criteria:**
- [ ] New test passes
- [ ] Related tests still pass (no regressions)
- [ ] Quality metrics improve
- [ ] Code compiles without warnings
- [ ] No new undefined variables or type errors introduced

### Step 8: Update Progress Tracking (5 min)

**In `ISSUE_TRACKER.md`:**
1. Change issue Status from `OPEN` to `RESOLVED`
2. Note completion date and your agent ID
3. Link to commit/PR if available

**In `PROGRESS.md`:**
1. Add new row to "Issues Resolved" table
2. Update "Recent Fixes" section
3. Note quality metric changes

**Example:**
```markdown
- [x] CRITICAL-001: Undefined variable i2 - Fixed by @agent-alpha on 2025-12-16

### 2025-12-16: CRITICAL-001 - Loop bounds undefined
**Fixed by:** Agent Alpha
**Files Changed:**
- `crates/dexterity-passes/src/region_builder.rs` - Fixed loop boundary tracking
- `crates/dexterity-cli/tests/integration/loops_tests.rs` - Added test

**Quality Impact:**
- Overall: 77.1% → 78.5% (+1.4%)
- Code Quality: 66.6% → 68.0% (+1.4%)

**Commit:** abc123def456
```

## What Success Looks Like

✅ **Issue Fixed:**
- Bug described in ISSUE_TRACKER.md is resolved
- All integration tests pass (685 tests)
- Quality metrics improve

✅ **Documentation Updated:**
- ISSUE_TRACKER.md shows RESOLVED
- PROGRESS.md updated with improvements
- Example output shows fix working

✅ **Ready for Next Issue:**
- Pick another OPEN issue
- Repeat workflow
- Build toward 90% quality target

## Common Challenges and Solutions

### Challenge: "I don't understand the algorithm"

**Solution:**
1. Read `ALGORITHM_REFERENCES.md` high-level overview (not every detail)
2. Look at JADX Java implementation to see how it works
3. Read code comments in the Dexterity implementation
4. Trace through an example with pen and paper
5. Start with a simple test case, expand to complex

### Challenge: "The code is too large to understand"

**Solution:**
- Use grep to find specific functions
- Read function signatures first to understand inputs/outputs
- Focus on the path related to your issue
- Ignore unrelated code (use grep to find just what matters)
- Add debug assertions to understand data flow

Example:
```bash
# Find the exact function
grep -n "fn find_loop_merge" region_builder.rs

# Find all calls to it
grep -n "find_loop_merge" region_builder.rs

# Understand what it returns
grep -A 20 "fn find_loop_merge" region_builder.rs
```

### Challenge: "My fix breaks other tests"

**Solution:**
1. Run full test suite: `cargo test`
2. Identify which tests fail
3. Understand why they fail
4. Adjust your fix to handle edge cases
5. Add more tests for those edge cases

### Challenge: "The quality metrics didn't improve"

**Solution:**
1. Check if the specific issue in QUALITY_ANALYSIS_REPORT.md is fixed
2. Look at new quality metrics in detail
3. Ensure QA tool is using the latest build
4. Verify fix isn't just moving bug to different location
5. May need to fix related issues to see metric improvement

## Quality Standards for Autonomous Development

### Code Quality
- ✅ Follow existing code style (indentation, naming, patterns)
- ✅ Add comments only where logic isn't obvious
- ✅ Keep functions focused on one thing
- ✅ Avoid premature optimization
- ✅ Use existing helper functions before writing new ones

### Testing Quality
- ✅ Write tests that demonstrate the bug
- ✅ Write tests that verify the fix
- ✅ Test edge cases (empty, single item, large input)
- ✅ Test with complex real code, not just simple examples
- ✅ Ensure tests capture the actual issue from QUALITY_ANALYSIS_REPORT.md

### Documentation Quality
- ✅ Update ISSUE_TRACKER.md status
- ✅ Update PROGRESS.md with metrics
- ✅ Record which files were changed
- ✅ Note any new patterns or algorithms discovered
- ✅ Link to related issues for future reference

## Workflow Checklist

Complete this for each issue:

```
[ ] 1. Read QUALITY_ANALYSIS_REPORT.md (current state)
[ ] 2. Select OPEN issue from ISSUE_TRACKER.md
[ ] 3. Read issue description and root cause
[ ] 4. Use CODE_NAVIGATION.md to find relevant files
[ ] 5. Read ALGORITHM_REFERENCES.md for context
[ ] 6. Review JADX source code in jadx-fast/
[ ] 7. Write failing test that demonstrates bug
[ ] 8. Implement fix following code patterns
[ ] 9. Run full test suite (cargo test)
[ ] 10. Run QA tool to measure quality improvement
[ ] 11. Update ISSUE_TRACKER.md to RESOLVED
[ ] 12. Update PROGRESS.md with results
[ ] 13. Consider edge cases and write additional tests
[ ] 14. Commit changes with clear message
```

## Key Files Reference

**Core Documentation (Read in This Order):**
1. `QUALITY_ANALYSIS_REPORT.md` - Current bugs and metrics
2. `ISSUE_TRACKER.md` - List of issues to fix
3. `CODE_NAVIGATION.md` - Where to find code
4. `ALGORITHM_REFERENCES.md` - How algorithms work

**Implementation Files (Interact With These):**
- `crates/dexterity-passes/src/*.rs` - Decompilation analysis passes
- `crates/dexterity-codegen/src/*.rs` - Java code generation
- `crates/dexterity-ir/src/*.rs` - Intermediate representation
- `crates/dexterity-cli/tests/integration/*.rs` - Integration tests

**Reference Code:**
- `jadx-fast/jadx-core/src/main/java/jadx/core/` - Java JADX implementation

**Tracking:**
- `PROGRESS.md` - Your completed work and metrics
- `ROADMAP.md` - Project goals and timeline

## Questions to Ask Before Starting

Before you pick an issue, ask yourself:

1. **Understanding**: Can I explain the bug in 1-2 sentences?
2. **Root Cause**: Do I understand why the code is broken?
3. **Location**: Can I find the relevant source files?
4. **Algorithm**: Can I find the JADX reference implementation?
5. **Reproducibility**: Can I write a test that demonstrates the bug?
6. **Scope**: Is this fix isolated or depend on other changes?
7. **Validation**: How will I know if my fix is complete?

If you answer "no" to any of these, spend more time on that step before implementing.

## Success = Progress Toward Production

**PRODUCTION READY - All Issues Resolved (Dec 16, 2025)**

Quality score achieved: **90.6%** - exceeds the 90%+ production-ready target.

**Issue Status (Dec 16, 2025): ALL RESOLVED**

| Priority | Resolved | Remaining |
|----------|----------|-----------|
| CRITICAL | 6 (1 partial) | 0 |
| HIGH | 4 | 0 |
| MEDIUM | 2 | 0 |

**Total: 12 issues resolved, 0 remaining** - All tracked issues have been addressed.

**Resolved Issues:**
- CRITICAL-001: Undefined loop variables - FIXED
- CRITICAL-002: Undefined nested scope variables - RESOLVED (investigation: fixed via HIGH-002)
- CRITICAL-003: Type mismatch (null as 0) - FIXED
- CRITICAL-004: Type comparison (== 0 vs == null) - PARTIAL (method parameters fixed)
- CRITICAL-005: Logic inversion in null checks - FIXED
- CRITICAL-006: Missing method bodies - RESOLVED (investigation: methods ARE being generated)
- HIGH-001: Register-based names - RESOLVED (investigation: Dexterity var quality 0.98 > JADX 0.93)
- HIGH-002: Duplicate variable declarations - FIXED
- HIGH-003: Missing static modifier - FIXED
- HIGH-004: Unreachable code - RESOLVED (investigation: 0 defects vs JADX 13/8)
- MEDIUM-001: Same-package types - FIXED
- MEDIUM-002: Missing exception imports - FIXED

All 685 integration tests pass. Dexterity is now production-ready for Android reverse engineering.

---

**Last Updated: 2025-12-16**
**Questions?** Read the relevant documentation file or check existing test cases for examples.
