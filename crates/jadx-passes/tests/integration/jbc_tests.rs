//! Jbc integration tests
//! Ported from jadx-core/src/test/java/jadx/tests/integration/jbc/

mod integration_test_framework;
use integration_test_framework::{IntegrationTestHelper, CodeAssertions};

#[test]
fn stack_convert_test_raung() {
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
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .contains_one("Integer.parseInt(num)");
}
