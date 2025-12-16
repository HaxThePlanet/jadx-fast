//! Code integration tests
//! Ported from jadx-core/src/test/java/jadx/tests/integration/code/

mod integration_test_framework;
use integration_test_framework::{IntegrationTestHelper, CodeAssertions};

#[test]
fn array_access_reorder_test() {
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
public void check() {
assertThat(test(new int[] { 1, 2, 3 })).isEqualTo(new int[] { -15, -10, -5 });
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .contains_one("i++");
}

#[test]
fn code_comment_style_test() {
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
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .contains_one("// Test line comment")
        .contains_one("/* Test condensed block comment */");
}
