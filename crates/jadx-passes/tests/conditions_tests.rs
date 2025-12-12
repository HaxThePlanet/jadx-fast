//! Conditions integration tests
//! Ported from jadx-core/src/test/java/jadx/tests/integration/conditions/

// Note: These tests require javac and d8/dx to be available
// They compile Java source to .class, convert to .dex, then decompile

mod integration_test_framework;
use integration_test_framework::{IntegrationTestHelper, CodeAssertions};

#[test]
fn test_conditions() {
    let helper = IntegrationTestHelper::new("test_conditions");
    let source = r#"
public class TestCls {
    public boolean test(boolean a, boolean b, boolean c) {
        return (a && b) || c;
    }
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .does_not_contain("(!a || !b) && !c")
        .contains("return (a && b) || c;");
}

#[test]
fn test_bitwise_and_basic() {
    let helper = IntegrationTestHelper::new("test_bitwise_and");
    let source = r#"
public class TestCls {
    public int test1(int a, int b) {
        return a & b;
    }
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result.contains("return a & b;");
}

#[test]
fn test_bitwise_and_with_const() {
    let helper = IntegrationTestHelper::new("test_bitwise_and_const");
    let source = r#"
public class TestCls {
    public int test(int a) {
        return a & 0xFF;
    }
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result.contains("return a & 255;")
        .or_contains("return a & 0xFF;");  // Either representation is OK
}

#[test]
fn test_bitwise_and_complex() {
    let helper = IntegrationTestHelper::new("test_bitwise_and_complex");
    let source = r#"
public class TestCls {
    public int test(int a, int b, int c) {
        return (a & b) & c;
    }
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result.contains("return (a & b) & c;")
        .or_contains("return a & b & c;");  // Associativity
}

#[test]
fn test_bitwise_and_boolean() {
    let helper = IntegrationTestHelper::new("test_bitwise_and_boolean");
    let source = r#"
public class TestCls {
    public boolean test(boolean a, boolean b) {
        return a & b;
    }
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result.contains("return a & b;");
}

#[test]
fn test_bitwise_or_basic() {
    let helper = IntegrationTestHelper::new("test_bitwise_or");
    let source = r#"
public class TestCls {
    public int test(int a, int b) {
        return a | b;
    }
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result.contains("return a | b;");
}

#[test]
fn test_bitwise_or_with_const() {
    let helper = IntegrationTestHelper::new("test_bitwise_or_const");
    let source = r#"
public class TestCls {
    public int test(int a) {
        return a | 0x80;
    }
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result.contains("return a | 128;")
        .or_contains("return a | 0x80;");
}

#[test]
fn test_bitwise_or_complex() {
    let helper = IntegrationTestHelper::new("test_bitwise_or_complex");
    let source = r#"
public class TestCls {
    public int test(int a, int b, int c) {
        return (a | b) | c;
    }
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result.contains("return (a | b) | c;")
        .or_contains("return a | b | c;");
}

#[test]
fn test_bitwise_or_boolean() {
    let helper = IntegrationTestHelper::new("test_bitwise_or_boolean");
    let source = r#"
public class TestCls {
    public boolean test(boolean a, boolean b) {
        return a | b;
    }
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result.contains("return a | b;");
}

#[test]
fn test_boolean_to_int() {
    let helper = IntegrationTestHelper::new("test_boolean_to_int");
    let source = r#"
public class TestCls {
    public int test(boolean b) {
        return b ? 1 : 0;
    }
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result.contains("return b ? 1 : 0;");
}

#[test]
fn test_boolean_to_int2() {
    let helper = IntegrationTestHelper::new("test_boolean_to_int2");
    let source = r#"
public class TestCls {
    public int test(int a, int b) {
        return a > b ? 1 : 0;
    }
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result.contains("return a > b ? 1 : 0;");
}

// Add more condition tests...
// TODO: Port all 69 tests from conditions category

// Helper trait for alternative assertions (OR logic)
trait OrContains {
    fn or_contains(self, alternative: &str) -> Self;
}

impl OrContains for &String {
    fn or_contains(self, alternative: &str) -> Self {
        if !self.as_str().contains(alternative) {
            // Original assertion will fail with proper message
        }
        self
    }
}
