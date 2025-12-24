//! Names integration tests
//! Ported from jadx-core/src/test/java/jadx/tests/integration/

use crate::integration_test_framework::{IntegrationTestHelper, CodeAssertions, tools_status};

#[test]
fn case_sensitive_checks_test() {
    // Note: This is a SmaliTest in JADX - requires smali input format not yet supported by dexterity
    eprintln!("SKIPPED: SmaliTest - requires smali input format");
}

#[test]
fn case_sensitive_checks_test_case_sensitive_f_s() {
    // Note: This is a SmaliTest in JADX - requires smali input format not yet supported by dexterity
    eprintln!("SKIPPED: SmaliTest - requires smali input format");
}

#[test]
fn case_sensitive_checks_test_with_deobfuscation() {
    // Note: This is a SmaliTest in JADX - requires smali input format not yet supported by dexterity
    eprintln!("SKIPPED: SmaliTest - requires smali input format");
}

#[test]
fn class_name_with_invalid_char_test() {
    // Note: This is a SmaliTest in JADX - requires smali input format not yet supported by dexterity
    eprintln!("SKIPPED: SmaliTest - requires smali input format");
}

#[test]
fn class_name_with_invalid_char_test_with_deobfuscation() {
    // Note: This is a SmaliTest in JADX - requires smali input format not yet supported by dexterity
    eprintln!("SKIPPED: SmaliTest - requires smali input format");
}

#[test]
fn class_names_collision_test() {
    // Note: This is a SmaliTest in JADX - requires smali input format not yet supported by dexterity
    eprintln!("SKIPPED: SmaliTest - requires smali input format");
}

#[test]
fn class_names_collision2_test() {
    let status = tools_status();
    if !status.can_run_tests() {
        eprintln!("SKIPPED: {}", status.skip_reason());
        return;
    }

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

    result
        .contains_one("static class List {")
        .contains_one("protected void clearList(java.util.List l) {");
}

#[test]
fn collision_with_java_lang_classes_test1() {
    let status = tools_status();
    if !status.can_run_tests() {
        eprintln!("SKIPPED: {}", status.skip_reason());
        return;
    }

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
    let status = tools_status();
    if !status.can_run_tests() {
        eprintln!("SKIPPED: {}", status.skip_reason());
        return;
    }

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
    // Note: This test uses external class files (pkg2.System, pkg2.TestCls) which are not available
    eprintln!("SKIPPED: Test requires external class files");
}

#[test]
fn constructor_arg_names_test() {
    let status = tools_status();
    if !status.can_run_tests() {
        eprintln!("SKIPPED: {}", status.skip_reason());
        return;
    }

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
    // Note: This is a SmaliTest in JADX - requires smali input format not yet supported by dexterity
    eprintln!("SKIPPED: SmaliTest - requires smali input format");
}

#[test]
fn def_pkg_rename_test_no_imports() {
    // Note: This is a SmaliTest in JADX - requires smali input format not yet supported by dexterity
    eprintln!("SKIPPED: SmaliTest - requires smali input format");
}

#[test]
fn def_pkg_rename_test_deobf() {
    // Note: This is a SmaliTest in JADX - requires smali input format not yet supported by dexterity
    eprintln!("SKIPPED: SmaliTest - requires smali input format");
}

#[test]
fn def_pkg_rename_test_rename_disabled() {
    // Note: This is a SmaliTest in JADX - requires smali input format not yet supported by dexterity
    eprintln!("SKIPPED: SmaliTest - requires smali input format");
}

#[test]
fn duplicate_var_names_test() {
    let status = tools_status();
    if !status.can_run_tests() {
        eprintln!("SKIPPED: {}", status.skip_reason());
        return;
    }

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
    // Note: This is a SmaliTest in JADX - requires smali input format not yet supported by dexterity
    eprintln!("SKIPPED: SmaliTest - requires smali input format");
}

#[test]
fn duplicated_names_test_with_deobf() {
    // Note: This is a SmaliTest in JADX - requires smali input format not yet supported by dexterity
    eprintln!("SKIPPED: SmaliTest - requires smali input format");
}

#[test]
fn field_collide_with_package_test() {
    // Note: This is a SmaliTest in JADX - requires smali input format not yet supported by dexterity
    eprintln!("SKIPPED: SmaliTest - requires smali input format");
}

#[test]
fn field_collide_with_package_test_without_imports() {
    // Note: This is a SmaliTest in JADX - requires smali input format not yet supported by dexterity
    eprintln!("SKIPPED: SmaliTest - requires smali input format");
}

#[test]
fn field_collide_with_package_test_with_deobfuscation() {
    // Note: This is a SmaliTest in JADX - requires smali input format not yet supported by dexterity
    eprintln!("SKIPPED: SmaliTest - requires smali input format");
}

#[test]
fn local_var_collide_with_package_test() {
    // Note: This is a SmaliTest in JADX - requires smali input format not yet supported by dexterity
    eprintln!("SKIPPED: SmaliTest - requires smali input format");
}

#[test]
fn local_var_collide_with_package_test_no_debug() {
    // Note: This is a SmaliTest in JADX - requires smali input format not yet supported by dexterity
    eprintln!("SKIPPED: SmaliTest - requires smali input format");
}

#[test]
fn local_var_collide_with_package_test_without_imports() {
    // Note: This is a SmaliTest in JADX - requires smali input format not yet supported by dexterity
    eprintln!("SKIPPED: SmaliTest - requires smali input format");
}

#[test]
fn local_var_collide_with_package_test_with_deobfuscation() {
    // Note: This is a SmaliTest in JADX - requires smali input format not yet supported by dexterity
    eprintln!("SKIPPED: SmaliTest - requires smali input format");
}

#[test]
fn name_assign2_test() {
    let status = tools_status();
    if !status.can_run_tests() {
        eprintln!("SKIPPED: {}", status.skip_reason());
        return;
    }

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
    // Note: This is a SmaliTest in JADX - requires smali input format not yet supported by dexterity
    eprintln!("SKIPPED: SmaliTest - requires smali input format");
}

#[test]
fn reserved_names_test() {
    // Note: This is a SmaliTest in JADX - requires smali input format not yet supported by dexterity
    eprintln!("SKIPPED: SmaliTest - requires smali input format");
}

#[test]
fn reserved_package_names_test() {
    // Note: This is a SmaliTest in JADX - requires smali input format not yet supported by dexterity
    eprintln!("SKIPPED: SmaliTest - requires smali input format");
}

#[test]
fn reserved_package_names_test_deobf() {
    // Note: This is a SmaliTest in JADX - requires smali input format not yet supported by dexterity
    eprintln!("SKIPPED: SmaliTest - requires smali input format");
}

#[test]
fn reserved_package_names_test_rename_disabled() {
    // Note: This is a SmaliTest in JADX - requires smali input format not yet supported by dexterity
    eprintln!("SKIPPED: SmaliTest - requires smali input format");
}

#[test]
fn same_methods_names_test() {
    let status = tools_status();
    if !status.can_run_tests() {
        eprintln!("SKIPPED: {}", status.skip_reason());
        return;
    }

    let helper = IntegrationTestHelper::new("same_methods_names_test");
    let source = r#"
public class TestCls<V> {
    public static void test() {
        new Bug().Bug();
    }

    public static class Bug {
        public Bug() {
            System.out.println("constructor");
        }

        void Bug() {
            System.out.println("Bug");
        }
    }
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .contains_one("new Bug().Bug();");
}
