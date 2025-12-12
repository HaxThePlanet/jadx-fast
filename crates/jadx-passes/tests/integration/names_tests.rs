//! Names integration tests
//! Ported from jadx-core/src/test/java/jadx/tests/integration/names/

mod integration_test_framework;
use integration_test_framework::{IntegrationTestHelper, CodeAssertions};

#[test]
fn case_sensitive_checks_test() {
    let helper = IntegrationTestHelper::new("case_sensitive_checks_test");
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
fn case_sensitive_checks_test_case_sensitive_f_s() {
    let helper = IntegrationTestHelper::new("case_sensitive_checks_test_case_sensitive_f_s");
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
fn case_sensitive_checks_test_with_deobfuscation() {
    let helper = IntegrationTestHelper::new("case_sensitive_checks_test_with_deobfuscation");
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
fn class_name_with_invalid_char_test() {
    let helper = IntegrationTestHelper::new("class_name_with_invalid_char_test");
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
fn class_name_with_invalid_char_test_with_deobfuscation() {
    let helper = IntegrationTestHelper::new("class_name_with_invalid_char_test_with_deobfuscation");
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
fn class_names_collision_test() {
    let helper = IntegrationTestHelper::new("class_names_collision_test");
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
fn class_names_collision2_test() {
    let helper = IntegrationTestHelper::new("class_names_collision2_test");
    let source = r#"
public class TestCls {
static class List {
public static List getList() {
return null;
}
protected List list = List.getList();
protected void clearList(java.util.List l) {
l.clear();
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    // TODO: Add assertions
}

#[test]
fn collision_with_java_lang_classes_test1() {
    let helper = IntegrationTestHelper::new("collision_with_java_lang_classes_test1");
    let source = r#"
public class TestCls {
public static void main(String[] args) {
java.lang.System.out.println("Hello world");
}
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .contains_one("java.lang.System.out.println");
}

#[test]
fn collision_with_java_lang_classes_test2() {
    let helper = IntegrationTestHelper::new("collision_with_java_lang_classes_test2");
    let source = r#"
public class TestCls {
public void doSomething() {
System.doSomething();
java.lang.System.out.println("Hello World");
}
public static void doSomething() {
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .contains_one("java.lang.System.out.println");
}

#[test]
fn collision_with_java_lang_classes_test3() {
    let helper = IntegrationTestHelper::new("collision_with_java_lang_classes_test3");
    // TODO: Extract test source
    let source = r#"
public class TestCls {
    // Add test code here
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .contains_one("java.lang.System.out.println");
}

#[test]
fn constructor_arg_names_test() {
    let helper = IntegrationTestHelper::new("constructor_arg_names_test");
    let source = r#"
public class TestCls {
private static String STR = "static field";
private final String str;
private final String store;
public TestCls(String str, String STR) {
this.str = str;
this.store = STR;
}
public TestCls() {
this.str = "a";
public void check() {
assertThat(new TestCls("a", "b").store).isEqualTo("b");
assertThat(new TestCls().store).isEqualTo(STR);
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .contains_one("this.str = str;")
        .contains_one("this.store = STR2;")
        .contains_one("this.store = STR;");
}

#[test]
fn def_pkg_rename_test() {
    let helper = IntegrationTestHelper::new("def_pkg_rename_test");
    // TODO: Extract test source
    let source = r#"
public class TestCls {
    // Add test code here
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .contains_one("package defpackage;")
        .contains_one("import defpackage.A;")
        .contains_one("public A a;");
}

#[test]
fn def_pkg_rename_test_no_imports() {
    let helper = IntegrationTestHelper::new("def_pkg_rename_test_no_imports");
    // TODO: Extract test source
    let source = r#"
public class TestCls {
    // Add test code here
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .contains_one("package defpackage;")
        .contains_one("public defpackage.A a;")
        .does_not_contain("import");
}

#[test]
fn def_pkg_rename_test_deobf() {
    let helper = IntegrationTestHelper::new("def_pkg_rename_test_deobf");
    // TODO: Extract test source
    let source = r#"
public class TestCls {
    // Add test code here
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .contains_one("import p000.C0000A;")
        .contains_one("public C0000A f0a;");
}

#[test]
fn def_pkg_rename_test_rename_disabled() {
    let helper = IntegrationTestHelper::new("def_pkg_rename_test_rename_disabled");
    // TODO: Extract test source
    let source = r#"
public class TestCls {
    // Add test code here
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .contains_one("// default package")
        .contains_one("public A a;")
        .does_not_contain("import");
}

#[test]
fn duplicate_var_names_test() {
    let helper = IntegrationTestHelper::new("duplicate_var_names_test");
    let source = r#"
public class TestCls {
public String mth(A a) {
return null;
}
@Override
public String toString() {
return "1";
public A test(A a) {
return new A() {
public String mth(A innerA) {
return a + "." + innerA;
};
public void check() {
String str = test(new A()).mth(new A() {
return "2";
});
assertThat(str).isEqualTo("1.2");
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .does_not_contain("AnonymousClass1");
}

#[test]
fn duplicated_names_test() {
    let helper = IntegrationTestHelper::new("duplicated_names_test");
    let source = r#"
public class TestCls {
public Object fieldName;
public String fieldName;
public Object run() {
return this.fieldName;
}
public String run() {
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    // TODO: Add assertions
}

#[test]
fn duplicated_names_test_with_deobf() {
    let helper = IntegrationTestHelper::new("duplicated_names_test_with_deobf");
    let source = r#"
public class TestCls {
public Object fieldName;
public String fieldName;
public Object run() {
return this.fieldName;
}
public String run() {
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    // TODO: Add assertions
}

#[test]
fn field_collide_with_package_test() {
    let helper = IntegrationTestHelper::new("field_collide_with_package_test");
    // TODO: Extract test source
    let source = r#"
public class TestCls {
    // Add test code here
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .contains("second.A")
        .does_not_contain("public second.A second;");
}

#[test]
fn field_collide_with_package_test_without_imports() {
    let helper = IntegrationTestHelper::new("field_collide_with_package_test_without_imports");
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
fn field_collide_with_package_test_with_deobfuscation() {
    let helper = IntegrationTestHelper::new("field_collide_with_package_test_with_deobfuscation");
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
fn local_var_collide_with_package_test() {
    let helper = IntegrationTestHelper::new("local_var_collide_with_package_test");
    // TODO: Extract test source
    let source = r#"
public class TestCls {
    // Add test code here
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .contains("second.A.call();")
        .does_not_contain("Second second = new Second();");
}

#[test]
fn local_var_collide_with_package_test_no_debug() {
    let helper = IntegrationTestHelper::new("local_var_collide_with_package_test_no_debug");
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
fn local_var_collide_with_package_test_without_imports() {
    let helper = IntegrationTestHelper::new("local_var_collide_with_package_test_without_imports");
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
fn local_var_collide_with_package_test_with_deobfuscation() {
    let helper = IntegrationTestHelper::new("local_var_collide_with_package_test_with_deobfuscation");
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
fn name_assign2_test() {
    let helper = IntegrationTestHelper::new("name_assign2_test");
    let source = r#"
public class TestCls {
public static void test(MethodNode mth, int regNum, LiveVarAnalysis la) {
List<BlockNode> blocks = mth.getBasicBlocks();
int blocksCount = blocks.size();
BitSet hasPhi = new BitSet(blocksCount);
BitSet processed = new BitSet(blocksCount);
Deque<BlockNode> workList = new ArrayDeque<>();
BitSet assignBlocks = la.getAssignBlocks(regNum);
for (int id = assignBlocks.nextSetBit(0); id >= 0; id = assignBlocks.nextSetBit(id + 1)) {
processed.set(id);
workList.add(blocks.get(id));
}
while (!workList.isEmpty()) {
BlockNode block = workList.pop();
BitSet domFrontier = block.getDomFrontier();
for (int id = domFrontier.nextSetBit(0); id >= 0; id = domFrontier.nextSetBit(id + 1)) {
if (!hasPhi.get(id) && la.isLive(id, regNum)) {
BlockNode df = blocks.get(id);
addPhi(df, regNum);
hasPhi.set(id);
if (!processed.get(id)) {
workList.add(df);
private static void addPhi(BlockNode df, int regNum) {
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .does_not_contain("int id;");
}

#[test]
fn reserved_class_names_test() {
    let helper = IntegrationTestHelper::new("reserved_class_names_test");
    // TODO: Extract test source
    let source = r#"
public class TestCls {
    // Add test code here
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .does_not_contain("public class do");
}

#[test]
fn reserved_names_test() {
    let helper = IntegrationTestHelper::new("reserved_names_test");
    let source = r#"
public class TestCls {
public String do; // reserved name
public String 0f; // invalid identifier
public String try() {
return this.do;
}
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .does_not_contain("public String do;");
}

#[test]
fn reserved_package_names_test() {
    let helper = IntegrationTestHelper::new("reserved_package_names_test");
    // TODO: Extract test source
    let source = r#"
public class TestCls {
    // Add test code here
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .does_not_contain("package do.if;");
}

#[test]
fn reserved_package_names_test_deobf() {
    let helper = IntegrationTestHelper::new("reserved_package_names_test_deobf");
    // TODO: Extract test source
    let source = r#"
public class TestCls {
    // Add test code here
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .does_not_contain("package do.if;");
}

#[test]
fn reserved_package_names_test_rename_disabled() {
    let helper = IntegrationTestHelper::new("reserved_package_names_test_rename_disabled");
    // TODO: Extract test source
    let source = r#"
public class TestCls {
    // Add test code here
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .contains("package do.if;");
}

#[test]
fn same_methods_names_test() {
    let helper = IntegrationTestHelper::new("same_methods_names_test");
    // TODO: Extract test source
    let source = r#"
public class TestCls {
    // Add test code here
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .contains_one("new Bug().Bug();");
}
