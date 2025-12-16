//! Fallback integration tests
//! Ported from jadx-core/src/test/java/jadx/tests/integration/

use crate::integration_test_framework::{IntegrationTestHelper, CodeAssertions, tools_status};

#[test]
fn fallback_many_nops_test() {
    let status = tools_status();
    if !status.can_run_tests() {
        eprintln!("SKIPPED: {}", status.skip_reason());
        return;
    }

    let helper = IntegrationTestHelper::new("fallback_many_nops_test");
    // TODO: Extract test source
    let source = r#"
public class TestCls {
    // Add test code here
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .contains("public static void test() {")
        .contains_one("return")
        .does_not_contain("Method dump skipped");
}

#[test]
fn fallback_mode_test() {
    let status = tools_status();
    if !status.can_run_tests() {
        eprintln!("SKIPPED: {}", status.skip_reason());
        return;
    }

    let helper = IntegrationTestHelper::new("fallback_mode_test");
    let source = r#"
public class TestCls {
public int test(int a) {
while (a < 10) {
a++;
}
return a;
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .contains("public int test(int r2) {")
        .contains_one("r1 = this;")
        .contains_one("L0:")
        .contains_one("L7:")
        .contains_one("int r2 = r2 + 1")
        .does_not_contain("throw new UnsupportedOperationException");
}
