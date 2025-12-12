//! Synchronize integration tests
//! Ported from jadx-core/src/test/java/jadx/tests/integration/synchronize/

mod integration_test_framework;
use integration_test_framework::{IntegrationTestHelper, CodeAssertions};

#[test]
fn nested_synchronize_test() {
    let helper = IntegrationTestHelper::new("nested_synchronize_test");
    // TODO: Extract test source
    let source = r#"
public class TestCls {
    // Add test code here
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .count_string(2, "synchronized");
}

#[test]
fn synchronized_test() {
    let helper = IntegrationTestHelper::new("synchronized_test");
    let source = r#"
public class TestCls {
public boolean f = false;
public final Object o = new Object();
public int i = 7;
public synchronized boolean test1() {
return this.f;
}
public int test2() {
synchronized (this.o) {
return this.i;
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    // TODO: Add assertions
}

#[test]
fn synchronized2_test() {
    let helper = IntegrationTestHelper::new("synchronized2_test");
    let source = r#"
public class TestCls {
private static synchronized boolean test(Object obj) {
return obj.toString() != null;
}
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .contains("private static synchronized boolean test(Object obj) {")
        .contains("obj.toString() != null;")
        .does_not_contain("synchronized (");
}

#[test]
fn synchronized3_test() {
    let helper = IntegrationTestHelper::new("synchronized3_test");
    let source = r#"
public class TestCls {
private int x;
public void f() {
}
public void test() {
while (true) {
synchronized (this) {
if (x == 0) {
throw new IllegalStateException();
x++;
if (x == 10) {
break;
this.x++;
f();
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    // TODO: Add assertions
}

#[test]
fn synchronized4_test() {
    let helper = IntegrationTestHelper::new("synchronized4_test");
    // TODO: Extract test source
    let source = r#"
public class TestCls {
    // Add test code here
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .contains_one("synchronized (this.obj) {")
        .contains_one("return call(this.obj, i);")
        .contains_one("return getField() == null;");
}

#[test]
fn synchronized5_test() {
    let helper = IntegrationTestHelper::new("synchronized5_test");
    // TODO: Extract test source
    let source = r#"
public class TestCls {
    // Add test code here
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .contains("1 != 0")
        .contains("System.gc();");
}

#[test]
fn synchronized6_test() {
    let helper = IntegrationTestHelper::new("synchronized6_test");
    let source = r#"
public class TestCls {
private final Object lock = new Object();
private boolean test(Object obj) {
synchronized (this.lock) {
return isA(obj) || isB(obj);
}
private boolean isA(Object obj) {
return false;
private boolean isB(Object obj) {
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    // TODO: Add assertions
}

#[test]
fn synchronized6_test_smali() {
    let helper = IntegrationTestHelper::new("synchronized6_test_smali");
    let source = r#"
public class TestCls {
private final Object lock = new Object();
private boolean test(Object obj) {
synchronized (this.lock) {
return isA(obj) || isB(obj);
}
private boolean isA(Object obj) {
return false;
private boolean isB(Object obj) {
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .contains_one("synchronized (this.lock) {")
        .contains_one("return isA(obj) || isB(obj);");
}
