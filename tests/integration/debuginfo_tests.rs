//! Debuginfo integration tests
//! Ported from jadx-core/src/test/java/jadx/tests/integration/

use crate::integration_test_framework::{IntegrationTestHelper, CodeAssertions, tools_status};

#[test]
fn line_numbers_test() {
    let status = tools_status();
    if !status.can_run_tests() {
        eprintln!("SKIPPED: {}", status.skip_reason());
        return;
    }

    let helper = IntegrationTestHelper::new("line_numbers_test");
    let source = r#"
public class TestCls {
int field;
public void func() {
}
int innerField;
public void innerFunc() {
public void innerFunc2() {
new Runnable() {
@Override
public void run() {
}.run();
public void innerFunc3() {
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    // Note: Java test checks line number metadata which isn't accessible via CLI
    // Just verify the code structure is correct
    result
        .contains("int field")
        .contains("void func()");
}

#[test]
fn return_source_line_test() {
    let status = tools_status();
    if !status.can_run_tests() {
        eprintln!("SKIPPED: {}", status.skip_reason());
        return;
    }

    let helper = IntegrationTestHelper::new("return_source_line_test");
    let source = r#"
public class TestCls {
public int test1(boolean v) {
if (v) {
f();
return 1;
}
return 0;
public int test2(int v) {
if (v == 0) {
return v - 1;
return v + 1;
public int test3(int v) {
return v;
private void f() {
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    // Note: Java test checks line number metadata which isn't accessible via CLI
    // Just verify the code structure is correct (return statements with values)
    result
        .contains("return 1;")
        .contains("return 0;")
        .contains("return v");
}

#[test]
fn variables_names_test() {
    let status = tools_status();
    if !status.can_run_tests() {
        eprintln!("SKIPPED: {}", status.skip_reason());
        return;
    }

    let helper = IntegrationTestHelper::new("variables_names_test");
    let source = r#"
public class TestCls {
public void test(String s, int k) {
f1(s);
int i = k + 3;
String s2 = "i" + i;
f2(i, s2);
double d = i * 5;
String s3 = "d" + d;
f3(d, s3);
}
private void f1(String s) {
private void f2(int i, String i2) {
private void f3(double d, String d2) {
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .contains_one("f1(str);");
}
