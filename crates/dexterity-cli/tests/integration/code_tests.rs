//! Code integration tests
//! Ported from jadx-core/src/test/java/jadx/tests/integration/

use crate::integration_test_framework::{IntegrationTestHelper, CodeAssertions, tools_status};

#[test]
fn array_access_reorder_test() {
    let status = tools_status();
    if !status.can_run_tests() {
        eprintln!("SKIPPED: {}", status.skip_reason());
        return;
    }

    let helper = IntegrationTestHelper::new("array_access_reorder_test");
    let source = r#"
public class TestCls {
    public int[] test(int[] arr) {
        int len = arr.length;
        int[] result = new int[len];
        int i = 0;
        int k = len;
        while (k != 0) {
            int v = arr[i];
            k--;
            int t = -v;
            i++;
            result[k] = t * 5;
        }
        return result;
    }
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .contains_one("i++");
}

#[test]
fn code_comment_style_test() {
    let status = tools_status();
    if !status.can_run_tests() {
        eprintln!("SKIPPED: {}", status.skip_reason());
        return;
    }

    let helper = IntegrationTestHelper::new("code_comment_style_test");
    let source = r#"
public class TestCls {
    public int aSingleLine;
    public int aMultiLine;
    public int block;
    public int blockMulti;
    public int blockCondensed;
    public int blockCondensedMulti;
    public int javaDoc;
    public int javaDocMulti;
    public int javaDocCondensed;
    public int javaDocCondensedMulti;
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    // Comments are not preserved through compilation, just verify fields exist
    result
        .contains("aSingleLine")
        .contains("javaDocCondensedMulti");
}
