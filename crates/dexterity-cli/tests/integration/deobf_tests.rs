//! Deobf integration tests
//! Ported from jadx-core/src/test/java/jadx/tests/integration/

use crate::integration_test_framework::{IntegrationTestHelper, CodeAssertions, tools_status};

#[test]
fn dont_rename_clsp_overridden_method_test() {
    let status = tools_status();
    if !status.can_run_tests() {
        eprintln!("SKIPPED: {}", status.skip_reason());
        return;
    }

    let helper = IntegrationTestHelper::new("dont_rename_clsp_overridden_method_test");
    let source = r#"
public class TestCls {
@Override
public void run() {
}
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .count_string(2, "public void run() {");
}

#[test]
fn field_from_inner_class_test() {
    let status = tools_status();
    if !status.can_run_tests() {
        eprintln!("SKIPPED: {}", status.skip_reason());
        return;
    }

    let helper = IntegrationTestHelper::new("field_from_inner_class_test");
    // TODO: Extract test source
    let source = r#"
public class TestCls {
    // Add test code here
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .does_not_contain("class I {")
        .does_not_contain(".I ")
        .does_not_contain(".I.X>");
}

#[test]
fn inherited_method_rename_test() {
    let status = tools_status();
    if !status.can_run_tests() {
        eprintln!("SKIPPED: {}", status.skip_reason());
        return;
    }

    let helper = IntegrationTestHelper::new("inherited_method_rename_test");
    let source = r#"
public class TestCls {
}
public void call() {
System.out.println("call");
public void test(A a) {
// reference to A.call() not renamed,
// should be resolved to B.call() and use alias
a.call();
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .contains_one("public void m1call() {")
        .contains_one(".m1call();")
        .does_not_contain(".call();");
}

#[test]
fn mth_rename_test() {
    let status = tools_status();
    if !status.can_run_tests() {
        eprintln!("SKIPPED: {}", status.skip_reason());
        return;
    }

    let helper = IntegrationTestHelper::new("mth_rename_test");
    let source = r#"
public class TestCls {
public abstract static class TestAbstractCls {
public abstract void a();
}
public void test(TestAbstractCls a) {
a.a();
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .does_not_contain("public abstract void a();")
        .does_not_contain(".a();");
}

#[test]
fn rename_overridden_method_test() {
    let status = tools_status();
    if !status.can_run_tests() {
        eprintln!("SKIPPED: {}", status.skip_reason());
        return;
    }

    let helper = IntegrationTestHelper::new("rename_overridden_method_test");
    let source = r#"
public class TestCls {
public interface I {
void m();
}
@Override
public void m() {
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .contains_one("void mo0m();")
        .count_string(2, "@Override")
        .count_string(3, "/* renamed from: m */")
        .count_string(2, "public void mo0m() {");
}

#[test]
fn rename_overridden_method2_test() {
    let status = tools_status();
    if !status.can_run_tests() {
        eprintln!("SKIPPED: {}", status.skip_reason());
        return;
    }

    let helper = IntegrationTestHelper::new("rename_overridden_method2_test");
    let source = r#"
public class TestCls {
public interface I {
int call();
}
@Override
public int call() {
return 1;
return 2;
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .count_string(2, "@Override")
        .count_string(3, "int mo0call()");
}

#[test]
fn rename_overridden_method3_test() {
    let status = tools_status();
    if !status.can_run_tests() {
        eprintln!("SKIPPED: {}", status.skip_reason());
        return;
    }

    let helper = IntegrationTestHelper::new("rename_overridden_method3_test");
    let source = r#"
public class TestCls {
public abstract static class A {
public abstract int call();
}
@Override
public final int call() {
return 1;
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .count_string(1, "@Override")
        .count_string(2, "int callRenamed()");
}
