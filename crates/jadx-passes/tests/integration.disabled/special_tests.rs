//! Special integration tests
//! Ported from jadx-core/src/test/java/jadx/tests/integration/special/

mod integration_test_framework;
use integration_test_framework::{IntegrationTestHelper, CodeAssertions};

#[test]
fn package_info_support_test() {
    let helper = IntegrationTestHelper::new("package_info_support_test");
    // TODO: Extract test source
    let source = r#"
public class TestCls {
    // Add test code here
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    // TODO: Add assertions
}
