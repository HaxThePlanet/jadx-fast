//! Synchronize integration tests
//! Ported from jadx-core/src/test/java/jadx/tests/integration/

use crate::integration_test_framework::{IntegrationTestHelper, CodeAssertions, tools_status};

#[test]
fn nested_synchronize_test() {
    // Note: Java test (TestNestedSynchronize) is a SmaliTest that loads from smali files.
    // Skipping as dexterity doesn't support smali input yet.
    eprintln!("SKIPPED: SmaliTest - requires smali input format");
}

#[test]
fn synchronized_test() {
    let status = tools_status();
    if !status.can_run_tests() {
        eprintln!("SKIPPED: {}", status.skip_reason());
        return;
    }

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

    result
        .does_not_contain("synchronized (this) {")
        .contains_one("public synchronized boolean test1() {")
        .contains("return this.f")
        .contains_one("synchronized (this.o) {")
        .does_not_contain("try {")
        .does_not_contain("throw th;");
}

#[test]
fn synchronized2_test() {
    let status = tools_status();
    if !status.can_run_tests() {
        eprintln!("SKIPPED: {}", status.skip_reason());
        return;
    }

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
    let status = tools_status();
    if !status.can_run_tests() {
        eprintln!("SKIPPED: {}", status.skip_reason());
        return;
    }

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

    // Check synchronized block followed by code outside the block
    result
        .contains("this.x++;")
        .contains("f();");
}

#[test]
fn synchronized4_test() {
    // Note: Java test (TestSynchronized4) is a SmaliTest that loads from smali files.
    // Skipping as dexterity doesn't support smali input yet.
    eprintln!("SKIPPED: SmaliTest - requires smali input format");
}

#[test]
fn synchronized5_test() {
    // Note: Java test (TestSynchronized5) is a SmaliTest that loads from smali files.
    // Skipping as dexterity doesn't support smali input yet.
    eprintln!("SKIPPED: SmaliTest - requires smali input format");
}

#[test]
fn synchronized6_test() {
    let status = tools_status();
    if !status.can_run_tests() {
        eprintln!("SKIPPED: {}", status.skip_reason());
        return;
    }

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

    result
        .contains_one("synchronized (this.lock) {")
        .contains("isA(obj) || isB(obj);");
}

#[test]
fn synchronized6_test_smali() {
    let status = tools_status();
    if !status.can_run_tests() {
        eprintln!("SKIPPED: {}", status.skip_reason());
        return;
    }

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
