//! Enums integration tests
//! Ported from jadx-core/src/test/java/jadx/tests/integration/enums/

mod integration_test_framework;
use integration_test_framework::{IntegrationTestHelper, CodeAssertions};

#[test]
fn enum_obfuscated_test() {
    let helper = IntegrationTestHelper::new("enum_obfuscated_test");
    // TODO: Extract test source
    let source = r#"
public class TestCls {
    // Add test code here
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .contains_one("int getNum() {")
        .does_not_contain("$VLS")
        .does_not_contain("vo(")
        .does_not_contain("vs(");
}

#[test]
fn enum_uses_other_enum_test_smali() {
    let helper = IntegrationTestHelper::new("enum_uses_other_enum_test_smali");
    let source = r#"
public class TestCls {
public enum VType {
INT(1),
OTHER_INT(INT);
private final int type;
VType(int type) {
this.type = type;
}
VType(VType refType) {
this(refType.type);
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    // TODO: Add assertions
}

#[test]
fn enum_with_const_inlining_test() {
    let helper = IntegrationTestHelper::new("enum_with_const_inlining_test");
    // TODO: Extract test source
    let source = r#"
public class TestCls {
    // Add test code here
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .contains_one("E42,");
}

#[test]
fn enum_with_fields_test() {
    let helper = IntegrationTestHelper::new("enum_with_fields_test");
    let source = r#"
public class TestCls {
public enum SearchTimeout {
DISABLED(0), TWO_SECONDS(2), FIVE_SECONDS(5);
public static final SearchTimeout DEFAULT = DISABLED;
public static final SearchTimeout MAX = FIVE_SECONDS;
public final int sec;
SearchTimeout(int val) {
this.sec = val;
}
public void check() {
assertThat(SearchTimeout.DISABLED.sec).isEqualTo(0);
assertThat(SearchTimeout.DEFAULT.sec).isEqualTo(0);
assertThat(SearchTimeout.TWO_SECONDS.sec).isEqualTo(2);
assertThat(SearchTimeout.MAX.sec).isEqualTo(5);
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    // TODO: Add assertions
}

#[test]
fn enum_with_fields_test2() {
    let helper = IntegrationTestHelper::new("enum_with_fields_test2");
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
fn enums_test() {
    let helper = IntegrationTestHelper::new("enums_test");
    let source = r#"
public class TestCls {
public enum EmptyEnum {
}
@SuppressWarnings("NoWhitespaceBefore")
public enum EmptyEnum2 {
;
public static void mth() {
public enum Direction {
NORTH,
SOUTH,
EAST,
WEST
public enum Singleton {
INSTANCE;
public String test() {
return "";
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    // TODO: Add assertions
}

#[test]
fn enums10_test() {
    let helper = IntegrationTestHelper::new("enums10_test");
    // TODO: Extract test source
    let source = r#"
public class TestCls {
    // Add test code here
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .contains_one("enum TestEnums10 {")
        .does_not_contain("Failed to restore enum class")
        .count_string(4, "Fake field");
}

#[test]
fn enums2_test() {
    let helper = IntegrationTestHelper::new("enums2_test");
    let source = r#"
public class TestCls {
public enum Operation {
PLUS {
@Override
public int apply(int x, int y) {
return x + y;
}
},
MINUS {
return x - y;
};
public abstract int apply(int x, int y);
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    // TODO: Add assertions
}

#[test]
fn enums2a_test() {
    let helper = IntegrationTestHelper::new("enums2a_test");
    let source = r#"
public class TestCls {
public interface IOps {
double apply(double x, double y);
}
public enum DoubleOperations implements IOps {
TIMES("*") {
@Override
public double apply(double x, double y) {
return x * y;
},
DIVIDE("/") {
return x / y;
};
private final String op;
DoubleOperations(String op) {
this.op = op;
public String getOp() {
return op;
public void check() {
assertThat(TIMES.getOp()).isEqualTo("*");
assertThat(DIVIDE.getOp()).isEqualTo("/");
assertThat(TIMES.apply(2, 3)).isEqualTo(6);
assertThat(DIVIDE.apply(10, 5)).isEqualTo(2);
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    // TODO: Add assertions
}

#[test]
fn enums3_test() {
    let helper = IntegrationTestHelper::new("enums3_test");
    let source = r#"
public class TestCls {
private static int three = 3;
public enum Numbers {
ONE(1), TWO(2), THREE(three), FOUR(three + 1);
private final int num;
Numbers(int n) {
this.num = n;
}
public int getNum() {
return num;
public void check() {
assertThat(Numbers.ONE.getNum()).isEqualTo(1);
assertThat(Numbers.THREE.getNum()).isEqualTo(3);
assertThat(Numbers.FOUR.getNum()).isEqualTo(4);
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .contains_one("ONE(1)")
        .contains_one("Numbers(int n) {");
}

#[test]
fn enums4_test() {
    let helper = IntegrationTestHelper::new("enums4_test");
    let source = r#"
public class TestCls {
public enum ResType {
CODE(".dex", ".class"),
MANIFEST("AndroidManifest.xml"),
XML(".xml"),
ARSC(".arsc"),
FONT(".ttf"),
IMG(".png", ".gif", ".jpg"),
LIB(".so"),
UNKNOWN;
private final String[] exts;
ResType(String... extensions) {
this.exts = extensions;
}
public String[] getExts() {
return exts;
public void check() {
assertThat(ResType.CODE.getExts()).containsExactly(new String[] { ".dex", ".class" });
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .contains_one("ResType(String... extensions) {");
}

#[test]
fn enums5_test() {
    let helper = IntegrationTestHelper::new("enums5_test");
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
fn enums6_test() {
    let helper = IntegrationTestHelper::new("enums6_test");
    let source = r#"
public class TestCls {
public enum Numbers {
ZERO,
ONE(1);
private final int n;
Numbers() {
this(0);
}
Numbers(int n) {
this.n = n;
public int getN() {
return n;
public void check() {
assertThat(TestCls.Numbers.ZERO.getN()).isEqualTo(0);
assertThat(TestCls.Numbers.ONE.getN()).isEqualTo(1);
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .contains_one("ZERO,")
        .contains_one("Numbers() {")
        .contains_one("ONE(1);");
}

#[test]
fn enums7_test() {
    let helper = IntegrationTestHelper::new("enums7_test");
    let source = r#"
public class TestCls {
public enum Numbers {
ZERO,
ONE;
private final int n;
Numbers() {
this.n = this.name().equals("ZERO") ? 0 : 1;
}
public int getN() {
return n;
public void check() {
assertThat(Numbers.ZERO.getN()).isEqualTo(0);
assertThat(Numbers.ONE.getN()).isEqualTo(1);
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .contains_one("ZERO,")
        .contains_one("ONE;")
        .contains_one("Numbers() {");
}

#[test]
fn enums8_test() {
    let helper = IntegrationTestHelper::new("enums8_test");
    // TODO: Extract test source
    let source = r#"
public class TestCls {
    // Add test code here
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .contains_one("enum TestEnums8");
}

#[test]
fn enums9_test() {
    let helper = IntegrationTestHelper::new("enums9_test");
    let source = r#"
public class TestCls {
public enum Types {
INT,
FLOAT,
LONG,
DOUBLE,
OBJECT,
ARRAY;
private static Set<Types> primitives = EnumSet.of(INT, FLOAT, LONG, DOUBLE);
public static List<Types> references = new ArrayList<>();
static {
references.add(OBJECT);
references.add(ARRAY);
}
public static Set<Types> getPrimitives() {
return primitives;
public void check() {
assertThat(Types.getPrimitives()).contains(Types.INT);
assertThat(Types.references).hasSize(2);
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .does_not_contain("EnumSet.of((Enum) INT,");
}

#[test]
fn enums_interface_test() {
    let helper = IntegrationTestHelper::new("enums_interface_test");
    let source = r#"
public class TestCls {
public enum Operation implements IOperation {
PLUS {
@Override
public int apply(int x, int y) {
return x + y;
}
},
MINUS {
return x - y;
public interface IOperation {
int apply(int x, int y);
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    // TODO: Add assertions
}

#[test]
fn enums_with_assert_test() {
    let helper = IntegrationTestHelper::new("enums_with_assert_test");
    let source = r#"
public class TestCls {
public enum Numbers {
ONE(1), TWO(2), THREE(3);
private final int num;
Numbers(int n) {
this.num = n;
}
public int getNum() {
assert num > 0;
return num;
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .contains_one("ONE(1)")
        .does_not_contain("Failed to restore enum class");
}

#[test]
fn enums_with_assert_test_n_y_i() {
    let helper = IntegrationTestHelper::new("enums_with_assert_test_n_y_i");
    let source = r#"
public class TestCls {
public enum Numbers {
ONE(1), TWO(2), THREE(3);
private final int num;
Numbers(int n) {
this.num = n;
}
public int getNum() {
assert num > 0;
return num;
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .contains_one("assert num > 0;")
        .does_not_contain("$assertionsDisabled")
        .does_not_contain("throw new AssertionError()");
}

#[test]
fn enums_with_consts_test() {
    let helper = IntegrationTestHelper::new("enums_with_consts_test");
    let source = r#"
public class TestCls {
public static final int C1 = 1;
public static final int C2 = 2;
public static final int C4 = 4;
public static final String S = "NORTH";
public enum Direction {
NORTH,
SOUTH,
EAST,
WEST
}
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    // TODO: Add assertions
}

#[test]
fn enums_with_custom_init_test() {
    let helper = IntegrationTestHelper::new("enums_with_custom_init_test");
    // TODO: Extract test source
    let source = r#"
public class TestCls {
    // Add test code here
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .does_not_contain("new TestEnumsWithCustomInit$TestCls(");
}

#[test]
fn enums_with_static_fields_test() {
    let helper = IntegrationTestHelper::new("enums_with_static_fields_test");
    // TODO: Extract test source
    let source = r#"
public class TestCls {
    // Add test code here
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .does_not_contain(" sA")
        .does_not_contain(" sC")
        .does_not_contain("private TestEnumsWithStaticFields(String str) {");
}

#[test]
fn inner_enums_test() {
    let helper = IntegrationTestHelper::new("inner_enums_test");
    let source = r#"
public class TestCls {
public enum Numbers {
ONE((byte) 1, NumString.ONE), TWO((byte) 2, NumString.TWO);
private final byte num;
private final NumString str;
public enum NumString {
ONE("one"), TWO("two");
private final String name;
NumString(String name) {
this.name = name;
}
public String getName() {
return name;
Numbers(byte n, NumString str) {
this.num = n;
this.str = str;
public int getNum() {
return num;
public NumString getNumStr() {
return str;
return str.getName();
public void check() {
assertThat(Numbers.ONE.getNum()).isEqualTo(1);
assertThat(Numbers.ONE.getNumStr()).isEqualTo(Numbers.NumString.ONE);
assertThat(Numbers.ONE.getName()).isEqualTo("one");
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .contains_one("ONE((byte) 1, NumString.ONE)");
}

#[test]
fn switch_over_enum_test() {
    let helper = IntegrationTestHelper::new("switch_over_enum_test");
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
fn switch_over_enum_test_smali_direct() {
    let helper = IntegrationTestHelper::new("switch_over_enum_test_smali_direct");
    // TODO: Extract test source
    let source = r#"
public class TestCls {
    // Add test code here
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .contains_one("switch (v) {")
        .contains_one("case ONE:");
}

#[test]
fn switch_over_enum2_test() {
    let helper = IntegrationTestHelper::new("switch_over_enum2_test");
    // TODO: Extract test source
    let source = r#"
public class TestCls {
    // Add test code here
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .count_string(1, "synthetic")
        .count_string(2, "switch (c) {")
        .count_string(2, "case ONE:")
        .count_string(2, "case DOG:");
}
