//! Sample integration tests to verify the framework works
//!
//! These are minimal tests to ensure the end-to-end pipeline is functional.

use crate::integration_test_framework::{IntegrationTestHelper, CodeAssertions, tools_status};

#[test]
fn test_simple_class() {
    let status = tools_status();
    if !status.can_run_tests() {
        eprintln!("SKIPPED: {}", status.skip_reason());
        return;
    }

    let helper = IntegrationTestHelper::new("simple_class");
    let source = r#"
public class TestCls {
    public int getValue() {
        return 42;
    }
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .contains("class TestCls")
        .contains("getValue")
        .contains("return 42");
}

#[test]
fn test_field_initialization() {
    let status = tools_status();
    if !status.can_run_tests() {
        eprintln!("SKIPPED: {}", status.skip_reason());
        return;
    }

    let helper = IntegrationTestHelper::new("field_init");
    let source = r#"
public class TestCls {
    private int x = 10;
    private String name = "hello";

    public int getX() {
        return x;
    }
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .contains("class TestCls")
        .contains("int x")
        .contains("getX");
}

#[test]
fn test_while_loop() {
    let status = tools_status();
    if !status.can_run_tests() {
        eprintln!("SKIPPED: {}", status.skip_reason());
        return;
    }

    let helper = IntegrationTestHelper::new("while_loop");
    let source = r#"
public class TestCls {
    public int sumTo(int n) {
        int sum = 0;
        int i = 0;
        while (i < n) {
            sum += i;
            i++;
        }
        return sum;
    }
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .contains("class TestCls")
        .contains("sumTo")
        .contains("while");
}

#[test]
fn test_if_else() {
    let status = tools_status();
    if !status.can_run_tests() {
        eprintln!("SKIPPED: {}", status.skip_reason());
        return;
    }

    let helper = IntegrationTestHelper::new("if_else");
    let source = r#"
public class TestCls {
    public int max(int a, int b) {
        if (a > b) {
            return a;
        } else {
            return b;
        }
    }
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .contains("class TestCls")
        .contains("max")
        .contains("if")
        .contains("return");
}

#[test]
fn test_try_catch() {
    let status = tools_status();
    if !status.can_run_tests() {
        eprintln!("SKIPPED: {}", status.skip_reason());
        return;
    }

    let helper = IntegrationTestHelper::new("try_catch");
    let source = r#"
public class TestCls {
    public int parse(String s) {
        try {
            return Integer.parseInt(s);
        } catch (NumberFormatException e) {
            return 0;
        }
    }
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .contains("class TestCls")
        .contains("parse")
        .contains("try")
        .contains("catch");
}
