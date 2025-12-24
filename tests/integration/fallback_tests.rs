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
    let source = r#"
public class TestCls {
    public static void test() {
        int x = 1;
        int y = 2;
        int z = x + y;
        return;
    }
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .contains("test()")
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
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .contains("test(")
        .contains("while")
        .contains("return");
}
