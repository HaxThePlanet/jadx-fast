# Testing and Validation Guide

How to test fixes and validate quality improvements toward JADX parity.

See `LLM_AGENT_GUIDE.md` for workflow and `ISSUE_TRACKER.md` for issues.

---

## Testing Strategy

### 1. Unit Tests (Individual Functions)

Test specific functions in isolation.

**Run all unit tests:**
```bash
cd /mnt/nvme4tb/jadx-rust
cargo test --lib
```

**Run tests in specific crate:**
```bash
cargo test -p dexterity-passes
cargo test -p dexterity-codegen
cargo test -p dexterity-ir
```

**Run specific test:**
```bash
cargo test type_inference  # All tests with "type_inference" in name
cargo test --test ssa      # Specific test file
```

**Check test output with verbose mode:**
```bash
cargo test -- --nocapture --test-threads=1
```

### 2. Integration Tests (Full Pipeline)

Test Java source → bytecode → decompilation → Java output.

**Location:** `/mnt/nvme4tb/jadx-rust/crates/dexterity-cli/tests/integration/`

**Test Categories:**
- `android_tests.rs` - Android-specific features
- `annotations_tests.rs` - Annotation handling
- `arith_tests.rs` - Arithmetic operations
- `arrays_tests.rs` - Array operations
- `conditions_tests.rs` - Conditional statements
- `debuginfo_tests.rs` - Debug information
- `deobf_tests.rs` - Deobfuscation
- `enums_tests.rs` - Enum handling
- `generics_tests.rs` - Generic types
- `inline_tests.rs` - Inlining
- `inner_tests.rs` - Inner classes
- `invoke_tests.rs` - Method invocations
- `java8_tests.rs` - Java 8 features (lambdas, etc.)
- `loops_tests.rs` - Loop constructs
- `names_tests.rs` - Variable naming
- `others_tests.rs` - Miscellaneous tests
- `rename_tests.rs` - Renaming tests
- `switches_tests.rs` - Switch statements
- `synchronize_tests.rs` - Synchronized blocks
- `trycatch_tests.rs` - Exception handling
- `types_tests.rs` - Type inference
- `variables_tests.rs` - Variable handling

**Golden Tests Location:** `crates/dexterity-cli/tests/golden_tests.rs` (363 lines)

**Run all integration tests:**
```bash
cargo test --test integration_test_framework
```

**Run specific integration test file:**
```bash
cargo test --test loops_tests
cargo test --test types_tests
```

**Run specific test function:**
```bash
cargo test loops_tests::test_for_loop
cargo test --test switches_tests test_switch_with_default
```

### 3. Full Test Suite

Run everything to ensure no regressions.

```bash
cargo test
```

**Expected output:**
```
test result: ok. X passed; 0 failed; 0 ignored; 0 measured; 0 filtered out
```

All integration tests should pass (685 tests).

---

## Writing Tests

When fixing an issue, add a test case that demonstrates the bug and validates the fix.

### Test Structure

Integration tests use common framework:

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
        // Assertions about decompiled code
        assert!(!decompiled.contains("i2"), "Should not have undefined variable i2");
        assert!(decompiled.contains("for"), "Should have for loop");
        assert!(decompiled.contains("items.length"), "Should reference array length");
    });
}
```

### Test Framework Functions

**Main function:**
```rust
fn test_java_to_java<F>(java_source: &str, assertions: F)
where
    F: Fn(&str) + Send + 'static,
```

Process: Java source → Compile to class → Compile to DEX → Decompile → Check assertions

**Other useful functions:**
- `compile_java(source)` - Compile Java to bytecode
- `dex_compile(classes)` - Compile to DEX
- `decompile_dex(dex)` - Decompile to Java

### Test Examples

**Testing loops (from `loops_tests.rs`):**
```rust
#[test]
fn test_for_loop_with_field_bounds() {
    let java_code = r#"
        public class Test {
            private int[] items;

            void iterate() {
                for (int i = 0; i < this.items.length; i++) {
                    System.out.println(items[i]);
                }
            }
        }
    "#;

    test_java_to_java(java_code, |decompiled| {
        // Should not have undefined bounds variable
        assert!(!decompiled.contains("i2"), "Loop bounds variable undefined");
        assert!(decompiled.contains("items.length"), "Should reference field bounds");
        // Should compile without errors
    });
}
```

**Testing type inference:**
```rust
#[test]
fn test_return_type_mismatch() {
    let java_code = r#"
        public class Test {
            List<String> getItems() {
                return new ArrayList();
            }
        }
    "#;

    test_java_to_java(java_code, |decompiled| {
        // Return type should match method signature
        assert!(decompiled.contains("return"), "Should have return statement");
        assert!(!decompiled.contains("return 0;"), "Should not return 0 for object type");
        assert!(!decompiled.contains("return null;"), "Should return ArrayList, not null");
    });
}
```

**Testing variable names:**
```rust
#[test]
fn test_variable_names_meaningful() {
    let java_code = r#"
        public class Test {
            void process(String buffer, int count) {
                byte[] data = new byte[count];
                // Use variables
            }
        }
    "#;

    test_java_to_java(java_code, |decompiled| {
        // Variable names should be meaningful, not register-based
        assert!(decompiled.contains("buffer"), "Should preserve parameter name");
        assert!(decompiled.contains("data") || decompiled.contains("bArr"),
                "Should have meaningful array name or type prefix");
        // Check for bad register names
        assert!(!decompiled.contains("v2 =") && !decompiled.contains("v3 ="),
                "Should not have register-based variable names");
    });
}
```

### Test Checklist

Before marking an issue RESOLVED:

- [ ] **Bug Test**: Write test that fails before fix, passes after
- [ ] **Edge Cases**: Test with complex inputs
- [ ] **Regression**: All existing tests still pass
- [ ] **Quality**: Validate with metrics tools
- [ ] **Real Code**: Test on actual APK if possible

---

## Quality Metrics Validation

### Automated QA Tool

Build and run the QA tool to measure improvements:

```bash
# Build QA tool (release mode for speed)
cargo build --release -p dexterity-qa

# Run comparison on test APK
./target/release/dexterity-qa \
  --jadx-path /path/to/java-jadx \
  --dexterity-path ./target/release/dexterity \
  --apk-path test_medium.apk \
  --detailed
```

**Output includes:**
- Overall quality score
- Code quality metric
- Variable quality metric
- Specific defect counts

### Expected Metric Improvements

After fixing issues, track these metrics:

| Issue | Before | After | Improvement |
|-------|--------|-------|-------------|
| CRITICAL-001 (Undefined vars) | 77.1% | **95.5%+** | **+18%** |
| CRITICAL-003 (Type mismatches) | 77.1% | **95.5%+** | **+18%** |
| HIGH-001 (Var names) | 0.67 | **0.99+** | **+0.32** |
| HIGH-002 (Duplicate vars) | varies | **resolved** | **100%** |

**Achieved metrics (Dec 17 QA re-run):**
- Overall Quality: 77.1% → **95.5%+** ✅ ACHIEVED
- Defect Score: 69.7% → **96.5%** ✅ ACHIEVED
- Variable Quality: 0.67 → **0.99+** ✅ ACHIEVED

### Manual Quality Check

For critical issues, manually verify the fix:

**Checklist:**
- [ ] Does decompiled code compile?
- [ ] Does decompiled code run?
- [ ] Does decompiled code match expected logic?
- [ ] Are variable names readable?
- [ ] Is code properly formatted?

Example:
```bash
# Extract decompiled code
dexterity -d output/ test.apk

# Compile extracted code to verify
javac output/com/example/**/*.java

# Check compilation success
echo $?  # 0 = success, non-zero = error
```

---

## Performance Considerations

### Build Speed

**Debug build (faster, for testing):**
```bash
cargo build
```

**Release build (slower, optimized):**
```bash
cargo build --release
```

**For testing, debug build is sufficient unless performance testing needed.**

### Test Execution Time

**Quick sanity check (1 minute):**
```bash
cargo test type_inference  # Just type inference tests
```

**Full test suite (5-10 minutes):**
```bash
cargo test  # Everything
```

**Specific integration tests (2-3 minutes):**
```bash
cargo test --test loops_tests
```

---

## Common Test Issues and Solutions

### Issue: Test Compiles but Fails

**Problem:** Test executable ran but assertions failed

**Solution:**
1. Use `--nocapture` to see println output
2. Check assertion messages
3. Print decompiled code to see actual output

```bash
cargo test test_loop_bounds_defined -- --nocapture
```

### Issue: Test Code Won't Compile

**Problem:** Java code in test has syntax errors

**Solution:**
1. Test simpler Java first
2. Check Java syntax carefully
3. Use minimal example
4. Verify javac can compile it standalone

### Issue: DEX Compilation Fails

**Problem:** Java compiles but DEX compilation fails

**Solution:**
1. Verify Java version compatibility
2. Check Android SDK installed (d8/dx required)
3. Use simpler Java features
4. Check test framework for specific requirements

### Issue: All Tests Suddenly Fail

**Problem:** Change broke something global

**Solution:**
1. Run with `--test-threads=1` to see which test fails first
2. Revert last change and re-test
3. Check for changed interfaces used by multiple tests
4. Look for global state modifications

---

## Regression Testing Strategy

When you fix one issue, ensure you don't break others:

### Three-Level Testing

**Level 1: Related Tests (2 minutes)**
```bash
# If fixing loop code, test loops
cargo test loops

# If fixing type inference, test type inference
cargo test type_inference

# If fixing SSA, test SSA
cargo test ssa
```

**Level 2: Integration Tests (3-5 minutes)**
```bash
# Run all integration tests
cargo test --test integration_test_framework
```

**Level 3: Full Suite (10 minutes)**
```bash
# Everything
cargo test
```

### Regression Detection

If a test that previously passed now fails:

1. **Identify the test:**
   ```bash
   cargo test 2>&1 | grep "FAILED"
   ```

2. **Run it in isolation:**
   ```bash
   cargo test test_name -- --nocapture
   ```

3. **Understand why it fails:**
   - Is it a real regression (your code broke it)?
   - Or was it already broken?

4. **Fix or revert:**
   - If you caused it, fix your code
   - If pre-existing, note in issue tracker

---

## Continuous Integration

For future CI/CD setup:

**Suggested test tiers:**
1. **Smoke tests** (1 minute): Quick sanity check
2. **Unit tests** (5 minutes): All Rust unit tests
3. **Integration tests** (10 minutes): All integration tests
4. **Quality metrics** (variable): QA tool on test APKs
5. **Nightly build** (1+ hour): Full suite on many APKs

---

## Test Results Reference

### Current Test Status

**Expected passing:** 685 integration tests + unit tests across all crates

**Test files:**
- `crates/dexterity-cli/tests/integration/android_tests.rs` - Android-specific features
- `crates/dexterity-cli/tests/integration/annotations_tests.rs` - Annotations
- `crates/dexterity-cli/tests/integration/arith_tests.rs` - Arithmetic
- `crates/dexterity-cli/tests/integration/arrays_tests.rs` - Arrays
- `crates/dexterity-cli/tests/integration/conditions_tests.rs` - Conditionals
- `crates/dexterity-cli/tests/integration/debuginfo_tests.rs` - Debug info
- `crates/dexterity-cli/tests/integration/deobf_tests.rs` - Deobfuscation
- `crates/dexterity-cli/tests/integration/enums_tests.rs` - Enums
- `crates/dexterity-cli/tests/integration/generics_tests.rs` - Generics
- `crates/dexterity-cli/tests/integration/inline_tests.rs` - Inlining
- `crates/dexterity-cli/tests/integration/inner_tests.rs` - Inner classes
- `crates/dexterity-cli/tests/integration/invoke_tests.rs` - Method invocations
- `crates/dexterity-cli/tests/integration/java8_tests.rs` - Java 8 features
- `crates/dexterity-cli/tests/integration/loops_tests.rs` - Loops
- `crates/dexterity-cli/tests/integration/names_tests.rs` - Variable names
- `crates/dexterity-cli/tests/integration/others_tests.rs` - Miscellaneous
- `crates/dexterity-cli/tests/integration/rename_tests.rs` - Renaming
- `crates/dexterity-cli/tests/integration/switches_tests.rs` - Switches
- `crates/dexterity-cli/tests/integration/synchronize_tests.rs` - Synchronized blocks
- `crates/dexterity-cli/tests/integration/trycatch_tests.rs` - Exception handling
- `crates/dexterity-cli/tests/integration/types_tests.rs` - Type inference
- `crates/dexterity-cli/tests/integration/variables_tests.rs` - Variable handling
- `crates/dexterity-cli/tests/golden_tests.rs` - Golden reference

### Running Specific Test Categories

```bash
# Arithmetic operations
cargo test arith

# Exception handling
cargo test trycatch || cargo test try_catch

# Switch statements
cargo test switch

# Loop constructs
cargo test loop

# SSA transformation
cargo test ssa

# Type inference
cargo test type_infer

# Generics
cargo test generic

# Golden reference (comprehensive)
cargo test golden
```

---

## Success Metrics

Your fix is successful when:

✅ **Test Coverage**
- [ ] New test written and passing
- [ ] Related tests still passing
- [ ] Full test suite still passes (685 integration tests)

✅ **Quality Metrics**
- [ ] Overall quality improved
- [ ] Code quality metric improved or stable
- [ ] No new defects introduced

✅ **Code Quality**
- [ ] Follows existing code patterns
- [ ] No compiler warnings
- [ ] No clippy warnings (if applicable)

✅ **Documentation**
- [ ] ISSUE_TRACKER.md updated to RESOLVED
- [ ] PROGRESS.md updated with metrics
- [ ] Commit message clear and concise

---

## Debugging Tests

### Increase Verbosity

```bash
# Show all output
cargo test -- --nocapture

# Run single-threaded to see errors in order
cargo test -- --test-threads=1 --nocapture

# Run with detailed output
RUST_LOG=debug cargo test --lib -- --nocapture
```

### Temporary Debug Code

Add prints to understand test failure:

```rust
#[test]
fn test_example() {
    let decompiled = decompile(...);

    eprintln!("DECOMPILED:\n{}", decompiled);  // Visible with --nocapture

    assert!(decompiled.contains("expected_string"));
}
```

### Generate Actual vs Expected Files

Save outputs for comparison:

```rust
#[test]
fn test_with_file_output() {
    let decompiled = decompile(...);

    std::fs::write("/tmp/actual.java", &decompiled)
        .expect("Failed to write actual output");

    // Compare manually or with diff
}
```

Then compare:
```bash
diff /tmp/expected.java /tmp/actual.java
```

---

## Reference Test APKs

The `apks/` directory contains reference APKs for benchmarking and quality testing. These APKs are critical for validating decompilation quality and performance.

### APK Files

| APK | Size | Description |
|-----|------|-------------|
| `small.apk` | 9.7 KB | Minimal test APK - fast iteration, basic feature validation |
| `medium.apk` | 10.4 MB | Mid-size app - comprehensive testing, ~13K classes |
| `large.apk` | 51.6 MB | Large production app - stress testing, ~18K classes |
| `badboy.apk` | 23.8 MB | Comprehensive test APK - full feature validation |
| `badboy-x86.apk` | 23.6 MB | x86 architecture APK - architecture compatibility testing |

### Decompilation Output Structure

After running both decompilers, outputs are organized as:

```
output/
├── dexterity/           # Dexterity (Rust) output
│   ├── small/
│   │   ├── sources/     # Decompiled Java source files
│   │   └── resources/   # Extracted resources (AndroidManifest.xml, etc.)
│   ├── medium/
│   │   ├── sources/
│   │   └── resources/
│   ├── large/
│   │   ├── sources/
│   │   └── resources/
│   └── badboy-x86/
│       ├── sources/
│       └── resources/
│
└── jadx/                # JADX (Java) output - reference implementation
    ├── small/
    │   ├── sources/
    │   └── resources/
    ├── medium/
    │   ├── sources/
    │   └── resources/
    ├── large/
    │   ├── sources/
    │   └── resources/
    └── badboy-x86/
        ├── sources/
        └── resources/
```

### Decompilation Commands

**Build Dexterity (56 cores):**
```bash
cd /mnt/nvme4tb/jadx-rust/crates
cargo build --release -j 56
```

**Run Dexterity on APK:**
```bash
./target/release/dexterity -d output/dexterity/small apks/small.apk
./target/release/dexterity -d output/dexterity/medium apks/medium.apk
./target/release/dexterity -d output/dexterity/large apks/large.apk
```

**Run JADX on APK:**
```bash
jadx -d output/jadx/small apks/small.apk
jadx -d output/jadx/medium apks/medium.apk
jadx -d output/jadx/large apks/large.apk
```

### Performance Benchmarks (56-core system)

| APK | Dexterity | JADX | Speedup |
|-----|-----------|------|---------|
| small.apk | 0.01s | 2.1s | **165x** |
| medium.apk | 5.5s | 18s | **3.3x** |
| large.apk | 8.0s | 19s | **2.4x** |

### Output Statistics

| APK | Dexterity Java Files | JADX Java Files |
|-----|---------------------|-----------------|
| small | 1 | 2 |
| medium | 6,032 | 10,074 |
| large | 9,624 | 12,822 |

**Note:** File count differences are due to:
- Dexterity filters framework classes (android.*, androidx.*, kotlin.*, kotlinx.*) by design
- JADX includes all classes including framework stubs

### Quality Comparison

Use the QA tool to compare outputs:

```bash
# Build QA tool
cargo build --release -p dexterity-qa

# Compare outputs for an APK
./target/release/dexterity-qa \
  --jadx-path output/jadx/medium/sources \
  --dexterity-path output/dexterity/medium/sources \
  --detailed
```

See `qa_reports/` in the project root for pre-generated comparison reports:
- `qa_reports/small.md` - Small APK quality report
- `qa_reports/medium.md` - Medium APK quality report
- `qa_reports/large.md` - Large APK quality report
- `qa_reports/COMPARISON_REPORT.md` - Overall comparison summary

---

**Last Updated: 2025-12-17**
**For workflow, see: `LLM_AGENT_GUIDE.md`**
**For issues, see: `ISSUE_TRACKER.md`**
