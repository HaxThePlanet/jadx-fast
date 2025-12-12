//! Rename integration tests
//! Ported from jadx-core/src/test/java/jadx/tests/integration/rename/

mod integration_test_framework;
use integration_test_framework::{IntegrationTestHelper, CodeAssertions};

#[test]
fn anonymous_inline_test() {
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

    // TODO: Add assertions
}

#[test]
fn const_replace_test() {
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

    // TODO: Add assertions
}

#[test]
fn field_rename_format_test() {
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
    let helper = IntegrationTestHelper::new("field_with_generic_rename_test");
    let source = r#"
public class TestCls {
List<String> list;
}
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    // TODO: Add assertions
}

#[test]
fn rename_enum_test() {
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
System.out.println("TWO");
};
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    // TODO: Add assertions
}

#[test]
fn user_renames_test() {
    let helper = IntegrationTestHelper::new("user_renames_test");
    let source = r#"
public class TestCls {
private int intField = 5;
}
public int test(int x) {
int y = x + "test".length();
System.out.println(y);
int z = y + 1;
System.out.println(z);
return z;
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    // TODO: Add assertions
}

#[test]
fn using_source_file_name_test_never_use_source_name() {
    let helper = IntegrationTestHelper::new("using_source_file_name_test_never_use_source_name");
    // TODO: Extract test source
    let source = r#"
public class TestCls {
    // Add test code here
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    // TODO: Add assertions
}

#[test]
fn using_source_file_name_test_if_better_use_source_name() {
    let helper = IntegrationTestHelper::new("using_source_file_name_test_if_better_use_source_name");
    // TODO: Extract test source
    let source = r#"
public class TestCls {
    // Add test code here
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    // TODO: Add assertions
}

#[test]
fn using_source_file_name_test_always_use_source_name() {
    let helper = IntegrationTestHelper::new("using_source_file_name_test_always_use_source_name");
    // TODO: Extract test source
    let source = r#"
public class TestCls {
    // Add test code here
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    // TODO: Add assertions
}

#[test]
fn using_source_file_name_test_never_use_source_name_with_deobf() {
    let helper = IntegrationTestHelper::new("using_source_file_name_test_never_use_source_name_with_deobf");
    // TODO: Extract test source
    let source = r#"
public class TestCls {
    // Add test code here
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    // TODO: Add assertions
}

#[test]
fn using_source_file_name_test_if_better_use_source_name_with_deobf() {
    let helper = IntegrationTestHelper::new("using_source_file_name_test_if_better_use_source_name_with_deobf");
    // TODO: Extract test source
    let source = r#"
public class TestCls {
    // Add test code here
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    // TODO: Add assertions
}

#[test]
fn using_source_file_name_test_always_use_source_name_with_deobf() {
    let helper = IntegrationTestHelper::new("using_source_file_name_test_always_use_source_name_with_deobf");
    // TODO: Extract test source
    let source = r#"
public class TestCls {
    // Add test code here
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    // TODO: Add assertions
}

#[test]
fn using_source_file_name_test_deprecated_dont_use_source_name() {
    let helper = IntegrationTestHelper::new("using_source_file_name_test_deprecated_dont_use_source_name");
    // TODO: Extract test source
    let source = r#"
public class TestCls {
    // Add test code here
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    // TODO: Add assertions
}

#[test]
fn using_source_file_name_test_deprecated_use_source_name() {
    let helper = IntegrationTestHelper::new("using_source_file_name_test_deprecated_use_source_name");
    // TODO: Extract test source
    let source = r#"
public class TestCls {
    // Add test code here
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    // TODO: Add assertions
}

#[test]
fn using_source_file_name_test_deprecated_dont_use_source_name_with_deobf() {
    let helper = IntegrationTestHelper::new("using_source_file_name_test_deprecated_dont_use_source_name_with_deobf");
    // TODO: Extract test source
    let source = r#"
public class TestCls {
    // Add test code here
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    // TODO: Add assertions
}

#[test]
fn using_source_file_name_test_deprecated_use_source_name_with_deobf() {
    let helper = IntegrationTestHelper::new("using_source_file_name_test_deprecated_use_source_name_with_deobf");
    // TODO: Extract test source
    let source = r#"
public class TestCls {
    // Add test code here
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .contains_one("class a {")
        .contains_one("/* compiled from: a.java */");
}
