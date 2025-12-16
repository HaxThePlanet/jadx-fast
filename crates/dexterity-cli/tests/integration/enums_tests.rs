//! Enums integration tests
//! Ported from jadx-core/src/test/java/jadx/tests/integration/

use crate::integration_test_framework::{IntegrationTestHelper, CodeAssertions, tools_status};

#[test]
fn enum_obfuscated_test() {
    // Note: Java test (TestEnumObfuscated) is a SmaliTest that loads from smali files.
    // Skipping as dexterity doesn't support smali input yet.
    eprintln!("SKIPPED: SmaliTest - requires smali input format");
}

#[test]
fn enum_uses_other_enum_test_smali() {
    let status = tools_status();
    if !status.can_run_tests() {
        eprintln!("SKIPPED: {}", status.skip_reason());
        return;
    }

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
    }
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .contains_one("OTHER_INT(INT);")
        .does_not_contain("static {");
}

#[test]
fn enum_with_const_inlining_test() {
    // Note: Java test (TestEnumWithConstInlining) is a SmaliTest that loads from smali files.
    // Skipping as dexterity doesn't support smali input yet.
    eprintln!("SKIPPED: SmaliTest - requires smali input format");
}

#[test]
fn enum_with_fields_test() {
    let status = tools_status();
    if !status.can_run_tests() {
        eprintln!("SKIPPED: {}", status.skip_reason());
        return;
    }

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
    }

    public void check() {
        assertThat(SearchTimeout.DISABLED.sec).isEqualTo(0);
        assertThat(SearchTimeout.DEFAULT.sec).isEqualTo(0);
        assertThat(SearchTimeout.TWO_SECONDS.sec).isEqualTo(2);
        assertThat(SearchTimeout.MAX.sec).isEqualTo(5);
    }

    private void assertThat(int i) {}
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .contains("DISABLED(0)")
        .contains("TWO_SECONDS(2)")
        .contains("FIVE_SECONDS(5)");
}

#[test]
fn enum_with_fields_test2() {
    // Note: Java test (TestEnumWithFields) test2 is a SmaliTest that loads from smali files.
    // Skipping as dexterity doesn't support smali input yet.
    eprintln!("SKIPPED: SmaliTest - requires smali input format");
}

#[test]
fn enums_test() {
    let status = tools_status();
    if !status.can_run_tests() {
        eprintln!("SKIPPED: {}", status.skip_reason());
        return;
    }

    let helper = IntegrationTestHelper::new("enums_test");
    let source = r#"
public class TestCls {
    public enum EmptyEnum {
    }

    @SuppressWarnings("NoWhitespaceBefore")
    public enum EmptyEnum2 {
        ;
        public static void mth() {}
    }

    public enum Direction {
        NORTH,
        SOUTH,
        EAST,
        WEST
    }

    public enum Singleton {
        INSTANCE;
        public String test() {
            return "";
        }
    }
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .contains("public enum EmptyEnum {")
        .contains("public enum Direction {")
        .contains("NORTH,")
        .contains("SOUTH,")
        .contains("EAST,")
        .contains("WEST");
}

#[test]
fn enums10_test() {
    // Note: Java test (TestEnums10) is a SmaliTest that loads from smali files.
    // Skipping as dexterity doesn't support smali input yet.
    eprintln!("SKIPPED: SmaliTest - requires smali input format");
}

#[test]
fn enums2_test() {
    let status = tools_status();
    if !status.can_run_tests() {
        eprintln!("SKIPPED: {}", status.skip_reason());
        return;
    }

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
            @Override
            public int apply(int x, int y) {
                return x - y;
            }
        };

        public abstract int apply(int x, int y);
    }
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .contains("public enum Operation {")
        .contains("PLUS {")
        .contains("MINUS {")
        .contains("public abstract int apply(int");
}

#[test]
fn enums2a_test() {
    let status = tools_status();
    if !status.can_run_tests() {
        eprintln!("SKIPPED: {}", status.skip_reason());
        return;
    }

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
            }
        },
        DIVIDE("/") {
            @Override
            public double apply(double x, double y) {
                return x / y;
            }
        };

        private final String op;

        DoubleOperations(String op) {
            this.op = op;
        }

        public String getOp() {
            return op;
        }
    }

    public void check() {
        assertThat(TIMES.getOp()).isEqualTo("*");
        assertThat(DIVIDE.getOp()).isEqualTo("/");
        assertThat(TIMES.apply(2, 3)).isEqualTo(6);
        assertThat(DIVIDE.apply(10, 5)).isEqualTo(2);
    }

    private void assertThat(Object o) {}
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .contains_one("TIMES(\"*\") {")
        .contains_one("DIVIDE(\"/\")");
}

#[test]
fn enums3_test() {
    let status = tools_status();
    if !status.can_run_tests() {
        eprintln!("SKIPPED: {}", status.skip_reason());
        return;
    }

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
        }
    }

    public void check() {
        assertThat(Numbers.ONE.getNum()).isEqualTo(1);
        assertThat(Numbers.THREE.getNum()).isEqualTo(3);
        assertThat(Numbers.FOUR.getNum()).isEqualTo(4);
    }

    private void assertThat(int i) {}
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
    let status = tools_status();
    if !status.can_run_tests() {
        eprintln!("SKIPPED: {}", status.skip_reason());
        return;
    }

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
        }
    }

    public void check() {
        assertThat(ResType.CODE.getExts()).containsExactly(new String[] { ".dex", ".class" });
    }

    private A assertThat(String[] arr) { return null; }

    class A {
        void containsExactly(String[] expected) {}
    }
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .contains_one("ResType(String... extensions) {");
}

#[test]
fn enums5_test() {
    // Note: Java test (TestEnums5) is a SmaliTest that loads from smali files.
    // Skipping as dexterity doesn't support smali input yet.
    eprintln!("SKIPPED: SmaliTest - requires smali input format");
}

#[test]
fn enums6_test() {
    let status = tools_status();
    if !status.can_run_tests() {
        eprintln!("SKIPPED: {}", status.skip_reason());
        return;
    }

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
        }

        public int getN() {
            return n;
        }
    }

    public void check() {
        assertThat(TestCls.Numbers.ZERO.getN()).isEqualTo(0);
        assertThat(TestCls.Numbers.ONE.getN()).isEqualTo(1);
    }

    private void assertThat(int i) {}
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
    let status = tools_status();
    if !status.can_run_tests() {
        eprintln!("SKIPPED: {}", status.skip_reason());
        return;
    }

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
        }
    }

    public void check() {
        assertThat(Numbers.ZERO.getN()).isEqualTo(0);
        assertThat(Numbers.ONE.getN()).isEqualTo(1);
    }

    private void assertThat(int i) {}
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
    // Note: Java test (TestEnums8) is a SmaliTest that loads from smali files.
    // Skipping as dexterity doesn't support smali input yet.
    eprintln!("SKIPPED: SmaliTest - requires smali input format");
}

#[test]
fn enums9_test() {
    let status = tools_status();
    if !status.can_run_tests() {
        eprintln!("SKIPPED: {}", status.skip_reason());
        return;
    }

    let helper = IntegrationTestHelper::new("enums9_test");
    let source = r#"
import java.util.*;

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
        }
    }

    public void check() {
        assertThat(Types.getPrimitives()).contains(Types.INT);
        assertThat(Types.references).hasSize(2);
    }

    private A assertThat(Object o) { return null; }

    class A {
        void contains(Object o) {}
        void hasSize(int s) {}
    }
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .does_not_contain("EnumSet.of((Enum) INT,");
}

#[test]
fn enums_interface_test() {
    let status = tools_status();
    if !status.can_run_tests() {
        eprintln!("SKIPPED: {}", status.skip_reason());
        return;
    }

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
            @Override
            public int apply(int x, int y) {
                return x - y;
            }
        };

        public abstract int apply(int x, int y);
    }

    public interface IOperation {
        int apply(int x, int y);
    }
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .contains("public enum Operation implements IOperation {")
        .contains("PLUS {")
        .contains("MINUS {");
}

#[test]
fn enums_with_assert_test() {
    let status = tools_status();
    if !status.can_run_tests() {
        eprintln!("SKIPPED: {}", status.skip_reason());
        return;
    }

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
    }
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
    let status = tools_status();
    if !status.can_run_tests() {
        eprintln!("SKIPPED: {}", status.skip_reason());
        return;
    }

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
    }
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
    let status = tools_status();
    if !status.can_run_tests() {
        eprintln!("SKIPPED: {}", status.skip_reason());
        return;
    }

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

    result
        .contains("public enum Direction {")
        .contains("NORTH,")
        .contains("SOUTH,")
        .contains("EAST,")
        .contains("WEST");
}

#[test]
fn enums_with_custom_init_test() {
    let status = tools_status();
    if !status.can_run_tests() {
        eprintln!("SKIPPED: {}", status.skip_reason());
        return;
    }

    let helper = IntegrationTestHelper::new("enums_with_custom_init_test");
    let source = r#"
import java.util.HashMap;
import java.util.Map;

public class TestCls {
    public enum Type {
        ONE("I"),
        TWO("II"),
        THREE("III");

        public static final Map<String, Type> MAP = new HashMap<>();

        static {
            for (Type value : values()) {
                MAP.put(value.toString(), value);
            }
        }

        private final String str;

        Type(String str) {
            this.str = str;
        }

        public String toString() {
            return str;
        }
    }
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .contains_one("ONE(\"I\"),")
        .does_not_contain("new TestCls$Type(");
}

#[test]
fn enums_with_static_fields_test() {
    // Note: Java test (TestEnumsWithStaticFields) is a SmaliTest that loads from smali files.
    // Skipping as dexterity doesn't support smali input yet.
    eprintln!("SKIPPED: SmaliTest - requires smali input format");
}

#[test]
fn inner_enums_test() {
    let status = tools_status();
    if !status.can_run_tests() {
        eprintln!("SKIPPED: {}", status.skip_reason());
        return;
    }

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
            }
        }

        Numbers(byte n, NumString str) {
            this.num = n;
            this.str = str;
        }

        public int getNum() {
            return num;
        }

        public NumString getNumStr() {
            return str;
        }

        public String getName() {
            return str.getName();
        }
    }

    public void check() {
        assertThat(Numbers.ONE.getNum()).isEqualTo(1);
        assertThat(Numbers.ONE.getNumStr()).isEqualTo(Numbers.NumString.ONE);
        assertThat(Numbers.ONE.getName()).isEqualTo("one");
    }

    private A assertThat(Object o) { return null; }

    class A {
        A isEqualTo(Object o) { return this; }
    }
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .contains_one("ONE((byte) 1, NumString.ONE)");
}

#[test]
fn switch_over_enum_test() {
    let status = tools_status();
    if !status.can_run_tests() {
        eprintln!("SKIPPED: {}", status.skip_reason());
        return;
    }

    let helper = IntegrationTestHelper::new("switch_over_enum_test");
    let source = r#"
public class TestCls {
    public enum Count {
        ONE, TWO, THREE
    }

    public int testEnum(Count c) {
        switch (c) {
            case ONE:
                return 1;
            case TWO:
                return 2;
        }
        return 0;
    }
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .contains("switch (c) {")
        .contains("case ONE:")
        .contains("case TWO:");
}

#[test]
fn switch_over_enum_test_smali_direct() {
    // Note: Java test (TestSwitchOverEnum.testSmaliDirect) is a SmaliTest that loads from smali files.
    // Tests Java 21 compiler behavior that omits remapping array.
    // Skipping as dexterity doesn't support smali input yet.
    eprintln!("SKIPPED: SmaliTest - requires smali input format");
}

#[test]
fn switch_over_enum2_test() {
    let status = tools_status();
    if !status.can_run_tests() {
        eprintln!("SKIPPED: {}", status.skip_reason());
        return;
    }

    let helper = IntegrationTestHelper::new("switch_over_enum2_test");
    let source = r#"
public class TestCls {
    public enum Count {
        ONE, TWO, THREE
    }

    public enum Animal {
        CAT, DOG
    }

    public int testEnum(Count c, Animal a) {
        int result = 0;
        switch (c) {
            case ONE:
                result = 1;
                break;
            case TWO:
                result = 2;
                break;
        }
        switch (a) {
            case CAT:
                result += 10;
                break;
            case DOG:
                result += 20;
                break;
        }
        return result;
    }
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .contains("switch (c) {")
        .contains("case ONE:")
        .contains("switch (a) {")
        .contains("case CAT:")
        .contains("case DOG:");
}
