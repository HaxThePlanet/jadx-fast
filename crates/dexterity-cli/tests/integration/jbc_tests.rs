//! Jbc integration tests
//! Ported from jadx-core/src/test/java/jadx/tests/integration/

use crate::integration_test_framework::{IntegrationTestHelper, CodeAssertions, tools_status};

#[test]
fn stack_convert_test_raung() {
    let status = tools_status();
    if !status.can_run_tests() {
        eprintln!("SKIPPED: {}", status.skip_reason());
        return;
    }

    let helper = IntegrationTestHelper::new("stack_convert_test_raung");
    let source = r#"
public class TestCls {
    public int parseIntDefault(String num, int defaultNum) {
        try {
            int defaultNum2 = Integer.parseInt(num);
            return defaultNum2;
        } catch (NumberFormatException e) {
            System.out.println("Before println");
            e.printStackTrace();
            return defaultNum;
        }
    }
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .contains_one("Integer.parseInt(num)");
}
