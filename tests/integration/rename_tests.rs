//! Rename integration tests
//! Ported from jadx-core/src/test/java/jadx/tests/integration/

use crate::integration_test_framework::{IntegrationTestHelper, CodeAssertions, tools_status};

#[test]
fn anonymous_inline_test() {
    let status = tools_status();
    if !status.can_run_tests() {
        eprintln!("SKIPPED: {}", status.skip_reason());
        return;
    }

    let helper = IntegrationTestHelper::new("anonymous_inline_test");
    let source = r#"
public class TestCls {
public Runnable test() {
return new Runnable() {
@Override
public void run() {
System.out.println("run");
}
};
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .contains_one("return new Runnable() {")
        .does_not_contain("AnonymousClass1");
}

#[test]
fn const_replace_test() {
    let status = tools_status();
    if !status.can_run_tests() {
        eprintln!("SKIPPED: {}", status.skip_reason());
        return;
    }

    let helper = IntegrationTestHelper::new("const_replace_test");
    let source = r#"
public class TestCls {
public static final String CONST = "SOME_CONST";
public String test() {
return CONST;
}
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .contains_one("return CONST;");
}

#[test]
fn field_rename_format_test() {
    let status = tools_status();
    if !status.can_run_tests() {
        eprintln!("SKIPPED: {}", status.skip_reason());
        return;
    }

    let helper = IntegrationTestHelper::new("field_rename_format_test");
    let source = r#"
public class TestCls {
private static final long serialVersionUID = -2619335455376089892L;
@SerializedName("id")
private int b;
@SerializedName("title")
private String c;
@SerializedName("images")
private List<String> d;
@SerializedName("authors")
private List<String> e;
@SerializedName("description")
private String f;
}
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .contains_one("private int id;")
        .contains_one("private List<String> authors;");
}

#[test]
fn field_with_generic_rename_test() {
    let status = tools_status();
    if !status.can_run_tests() {
        eprintln!("SKIPPED: {}", status.skip_reason());
        return;
    }

    let helper = IntegrationTestHelper::new("field_with_generic_rename_test");
    let source = r#"
public class TestCls {
List<String> list;
}
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .contains_one("List<String> list;");
}

#[test]
fn rename_enum_test() {
    let status = tools_status();
    if !status.can_run_tests() {
        eprintln!("SKIPPED: {}", status.skip_reason());
        return;
    }

    let helper = IntegrationTestHelper::new("rename_enum_test");
    let source = r#"
public class TestCls {
public enum A implements Runnable {
ONE {
@Override
public void run() {
System.out.println("ONE");
}
},
TWO {
@Override
public void run() {
System.out.println("TWO");
}
};
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .contains_one("public enum A ")
        .contains_one("ONE {");
}

#[test]
fn user_renames_test() {
    let status = tools_status();
    if !status.can_run_tests() {
        eprintln!("SKIPPED: {}", status.skip_reason());
        return;
    }

    let helper = IntegrationTestHelper::new("user_renames_test");
    let source = r#"
public class TestCls {
private int intField = 5;
public static class A {
}
public int test(int x) {
int y = x + "test".length();
System.out.println(y);
int z = y + 1;
System.out.println(z);
return z;
}
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .contains_one("private int intField")
        .contains_one("public static class A {")
        .contains_one("public int test(int x) {")
        .contains_one("int y = x + \"test\".length();")
        .contains_one("int z = y + 1;")
        .contains_one("return z;");
}

#[test]
fn using_source_file_name_test_never_use_source_name() {
    let status = tools_status();
    if !status.can_run_tests() {
        eprintln!("SKIPPED: {}", status.skip_reason());
        return;
    }

    eprintln!("SKIPPED: SmaliTest - requires smali input format");
}

#[test]
fn using_source_file_name_test_if_better_use_source_name() {
    let status = tools_status();
    if !status.can_run_tests() {
        eprintln!("SKIPPED: {}", status.skip_reason());
        return;
    }

    eprintln!("SKIPPED: SmaliTest - requires smali input format");
}

#[test]
fn using_source_file_name_test_always_use_source_name() {
    let status = tools_status();
    if !status.can_run_tests() {
        eprintln!("SKIPPED: {}", status.skip_reason());
        return;
    }

    eprintln!("SKIPPED: SmaliTest - requires smali input format");
}

#[test]
fn using_source_file_name_test_never_use_source_name_with_deobf() {
    let status = tools_status();
    if !status.can_run_tests() {
        eprintln!("SKIPPED: {}", status.skip_reason());
        return;
    }

    eprintln!("SKIPPED: SmaliTest - requires smali input format");
}

#[test]
fn using_source_file_name_test_if_better_use_source_name_with_deobf() {
    let status = tools_status();
    if !status.can_run_tests() {
        eprintln!("SKIPPED: {}", status.skip_reason());
        return;
    }

    eprintln!("SKIPPED: SmaliTest - requires smali input format");
}

#[test]
fn using_source_file_name_test_always_use_source_name_with_deobf() {
    let status = tools_status();
    if !status.can_run_tests() {
        eprintln!("SKIPPED: {}", status.skip_reason());
        return;
    }

    eprintln!("SKIPPED: SmaliTest - requires smali input format");
}

#[test]
fn using_source_file_name_test_deprecated_dont_use_source_name() {
    let status = tools_status();
    if !status.can_run_tests() {
        eprintln!("SKIPPED: {}", status.skip_reason());
        return;
    }

    eprintln!("SKIPPED: SmaliTest - requires smali input format");
}

#[test]
fn using_source_file_name_test_deprecated_use_source_name() {
    let status = tools_status();
    if !status.can_run_tests() {
        eprintln!("SKIPPED: {}", status.skip_reason());
        return;
    }

    eprintln!("SKIPPED: SmaliTest - requires smali input format");
}

#[test]
fn using_source_file_name_test_deprecated_dont_use_source_name_with_deobf() {
    let status = tools_status();
    if !status.can_run_tests() {
        eprintln!("SKIPPED: {}", status.skip_reason());
        return;
    }

    eprintln!("SKIPPED: SmaliTest - requires smali input format");
}

#[test]
fn using_source_file_name_test_deprecated_use_source_name_with_deobf() {
    let status = tools_status();
    if !status.can_run_tests() {
        eprintln!("SKIPPED: {}", status.skip_reason());
        return;
    }

    eprintln!("SKIPPED: SmaliTest - requires smali input format");
}
