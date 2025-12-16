//! Usethis integration tests
//! Ported from jadx-core/src/test/java/jadx/tests/integration/

use crate::integration_test_framework::{IntegrationTestHelper, CodeAssertions, tools_status};

#[test]
fn dont_inline_this_test() {
    let status = tools_status();
    if !status.can_run_tests() {
        eprintln!("SKIPPED: {}", status.skip_reason());
        return;
    }

    let helper = IntegrationTestHelper::new("dont_inline_this_test");
    let source = r#"
public class TestCls {
public int field = new Random().nextInt();
public TestCls test() {
TestCls res;
if (field == 7) {
res = this;
System.out.println();
} else {
res = new TestCls();
}
res.method();
return res;
private void method() {
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .contains_one("TestDontInlineThis$TestCls res")
        .contains_one("res = this;")
        .contains_one("res = new TestDontInlineThis$TestCls();");
}

#[test]
fn inline_this_test() {
    let status = tools_status();
    if !status.can_run_tests() {
        eprintln!("SKIPPED: {}", status.skip_reason());
        return;
    }

    let helper = IntegrationTestHelper::new("inline_this_test");
    let source = r#"
public class TestCls {
public int field;
public void test() {
TestCls something = this;
something.method();
something.field = 123;
}
private void method() {
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .contains_one("this.field = 123;")
        .contains_one("method();")
        .does_not_contain("something")
        .does_not_contain("something.method()")
        .does_not_contain("something.field")
        .does_not_contain("= this");
}

#[test]
fn inline_this2_test() {
    let status = tools_status();
    if !status.can_run_tests() {
        eprintln!("SKIPPED: {}", status.skip_reason());
        return;
    }

    let helper = IntegrationTestHelper::new("inline_this2_test");
    let source = r#"
public class TestCls {
public int field;
public void test() {
TestCls thisVar = this;
if (Objects.isNull(thisVar)) {
System.out.println("null");
}
thisVar.method();
thisVar.field = 123;
private void method() {
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .contains_one("if (Objects.isNull(this)) {")
        .contains_one("this.field = 123;")
        .contains_one("method();")
        .does_not_contain("thisVar")
        .does_not_contain("thisVar.method()")
        .does_not_contain("thisVar.field")
        .does_not_contain("= this");
}

#[test]
fn redundant_this_test() {
    let status = tools_status();
    if !status.can_run_tests() {
        eprintln!("SKIPPED: {}", status.skip_reason());
        return;
    }

    let helper = IntegrationTestHelper::new("redundant_this_test");
    let source = r#"
public class TestCls {
public int field1 = 1;
public int field2 = 2;
public boolean f1() {
return false;
}
public int method() {
f1();
return field1;
public void method2(int field2) {
this.field2 = field2;
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .contains("this.field2 = field2;")
        .does_not_contain("this.f1();")
        .does_not_contain("return this.field1;");
}
