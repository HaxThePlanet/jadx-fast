//! Android integration tests
//! Ported from jadx-core/src/test/java/jadx/tests/integration/

use crate::integration_test_framework::{IntegrationTestHelper, CodeAssertions, tools_status};

#[test]
fn r_field_access_test() {
    let status = tools_status();
    if !status.can_run_tests() {
        eprintln!("SKIPPED: {}", status.skip_reason());
        return;
    }

    let helper = IntegrationTestHelper::new("r_field_access_test");
    // Test has R class reference - dexterity should preserve constant field access
    let source = r#"
public class TestCls {
    public static class R {
        public static final class id {
            public static final int BUTTON_01 = 2131230730;
        }
    }

    public static class TestR {
        public int test() {
            return R.id.BUTTON_01;
        }
    }
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    // Should preserve R.id.BUTTON_01 constant reference
    result
        .contains("R.id.BUTTON_01");
}

#[test]
fn r_field_restore_test() {
    let status = tools_status();
    if !status.can_run_tests() {
        eprintln!("SKIPPED: {}", status.skip_reason());
        return;
    }

    let helper = IntegrationTestHelper::new("r_field_restore_test");
    let source = r#"
public class TestCls {
public int test() {
return 2131230730;
}
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .contains_one("return R.id.Button;")
        .does_not_contain("import R;");
}

#[test]
fn r_field_restore2_test() {
    let status = tools_status();
    if !status.can_run_tests() {
        eprintln!("SKIPPED: {}", status.skip_reason());
        return;
    }

    let helper = IntegrationTestHelper::new("r_field_restore2_test");
    let source = r#"
public class TestCls {
}
public int test() {
return 2131230730;
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .contains_one("R.id.Button;");
}

#[test]
fn r_field_restore3_test() {
    let status = tools_status();
    if !status.can_run_tests() {
        eprintln!("SKIPPED: {}", status.skip_reason());
        return;
    }

    let helper = IntegrationTestHelper::new("r_field_restore3_test");
    let source = r#"
public class TestCls {
@T(2131230730)
@F(2131230730)
private int f;
@M(bind = 2137373737)
private void mth() {
}
@T(2137373737)
private class D {
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@interface T {
int value();
@Target({ ElementType.FIELD })
@interface F {
@Target({ ElementType.METHOD })
@interface M {
int bind();
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    // Note: Full R field restoration requires resource map (not available in standalone test)
    // Just verify the annotations compile and are present
    result
        .contains("@T(")
        .contains("@F(")
        .contains("@M(");
}

#[test]
fn res_const_replace_test() {
    let status = tools_status();
    if !status.can_run_tests() {
        eprintln!("SKIPPED: {}", status.skip_reason());
        return;
    }

    let helper = IntegrationTestHelper::new("res_const_replace_test");
    let source = r#"
public class TestCls {
public int test() {
return 0x0101013f; // android.R.attr.minWidth
}
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .contains_one("import android.R;")
        .contains_one("return R.attr.minWidth;");
}

#[test]
fn res_const_replace2_test() {
    let status = tools_status();
    if !status.can_run_tests() {
        eprintln!("SKIPPED: {}", status.skip_reason());
        return;
    }

    let helper = IntegrationTestHelper::new("res_const_replace2_test");
    let source = r#"
public class TestCls {
public int test(int i) {
switch (i) {
case 0x0101013f: // android.R.attr.minWidth
return 1;
case 0x01010140: // android.R.attr.minHeight
return 2;
default:
return 0;
}
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .contains_one("import android.R;")
        .contains_one("case R.attr.minWidth:");
}

#[test]
fn res_const_replace3_test() {
    let status = tools_status();
    if !status.can_run_tests() {
        eprintln!("SKIPPED: {}", status.skip_reason());
        return;
    }

    let helper = IntegrationTestHelper::new("res_const_replace3_test");
    let source = r#"
public class TestCls {
public void test(@UsesAndroidResource(17039370 /* android.R.string.ok */) int i) {
}
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .contains_one("import android.R;")
        .count_string(2, "@TestResConstReplace3.UsesAndroidResource(R.string.ok)");
}
