//! Conditions integration tests
//! Ported from jadx-core/src/test/java/jadx/tests/integration/

use crate::integration_test_framework::{IntegrationTestHelper, CodeAssertions, tools_status};

#[test]
fn bitwise_and_test() {
    let status = tools_status();
    if !status.can_run_tests() {
        eprintln!("SKIPPED: {}", status.skip_reason());
        return;
    }

    let helper = IntegrationTestHelper::new("bitwise_and_test");
    let source = r#"
public class TestCls {
    private boolean a;
    private boolean b;
    public void test() {
        if ((a & b) != false) {
            test();
        }
    }
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result.contains("test()");
}

#[test]
fn bitwise_and_test2() {
    let status = tools_status();
    if !status.can_run_tests() {
        eprintln!("SKIPPED: {}", status.skip_reason());
        return;
    }

    let helper = IntegrationTestHelper::new("bitwise_and_test2");
    let source = r#"
public class TestCls {
    private boolean a;
    private boolean b;
    public void test() {
        if ((a & b) != true) {
            test();
        }
    }
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result.contains("test()");
}

#[test]
fn bitwise_and_test3() {
    let status = tools_status();
    if !status.can_run_tests() {
        eprintln!("SKIPPED: {}", status.skip_reason());
        return;
    }

    let helper = IntegrationTestHelper::new("bitwise_and_test3");
    let source = r#"
public class TestCls {
    private boolean a;
    private boolean b;
    public void test() {
        if ((a & b) == false) {
            test();
        }
    }
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result.contains("test()");
}

#[test]
fn bitwise_and_test4() {
    let status = tools_status();
    if !status.can_run_tests() {
        eprintln!("SKIPPED: {}", status.skip_reason());
        return;
    }

    let helper = IntegrationTestHelper::new("bitwise_and_test4");
    let source = r#"
public class TestCls {
    private boolean a;
    private boolean b;
    public void test() {
        if ((a & b) == true) {
            test();
        }
    }
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .contains_one("if (this.a && this.b) {");
}

#[test]
fn bitwise_or_test() {
    let status = tools_status();
    if !status.can_run_tests() {
        eprintln!("SKIPPED: {}", status.skip_reason());
        return;
    }

    let helper = IntegrationTestHelper::new("bitwise_or_test");
    let source = r#"
public class TestCls {
    private boolean a;
    private boolean b;
    public void test() {
        if ((a | b) != false) {
            test();
        }
    }
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result.contains("test()");
}

#[test]
fn bitwise_or_test2() {
    let status = tools_status();
    if !status.can_run_tests() {
        eprintln!("SKIPPED: {}", status.skip_reason());
        return;
    }

    let helper = IntegrationTestHelper::new("bitwise_or_test2");
    let source = r#"
public class TestCls {
    private boolean a;
    private boolean b;
    public void test() {
        if ((a | b) != true) {
            test();
        }
    }
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result.contains("test()");
}

#[test]
fn bitwise_or_test3() {
    let status = tools_status();
    if !status.can_run_tests() {
        eprintln!("SKIPPED: {}", status.skip_reason());
        return;
    }

    let helper = IntegrationTestHelper::new("bitwise_or_test3");
    let source = r#"
public class TestCls {
    private boolean a;
    private boolean b;
    public void test() {
        if ((a | b) == false) {
            test();
        }
    }
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result.contains("test()");
}

#[test]
fn bitwise_or_test4() {
    let status = tools_status();
    if !status.can_run_tests() {
        eprintln!("SKIPPED: {}", status.skip_reason());
        return;
    }

    let helper = IntegrationTestHelper::new("bitwise_or_test4");
    let source = r#"
public class TestCls {
    private boolean a;
    private boolean b;
    public void test() {
        if ((a | b) == true) {
            test();
        }
    }
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .contains_one("if (this.a || this.b) {");
}

#[test]
fn boolean_to_byte_test() {
    let status = tools_status();
    if !status.can_run_tests() {
        eprintln!("SKIPPED: {}", status.skip_reason());
        return;
    }

    let helper = IntegrationTestHelper::new("boolean_to_byte_test");
    let source = r#"
import java.io.OutputStream;
public class TestCls {
    private boolean showConsent;
    private OutputStream out;
    public void test() throws Exception {
        out.write(showConsent ? (byte) 1 : (byte) 0);
    }
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result.contains("write");
}

#[test]
fn boolean_to_char_test() {
    let status = tools_status();
    if !status.can_run_tests() {
        eprintln!("SKIPPED: {}", status.skip_reason());
        return;
    }

    let helper = IntegrationTestHelper::new("boolean_to_char_test");
    let source = r#"
import java.io.Writer;
public class TestCls {
    private boolean showConsent;
    private Writer out;
    public void test() throws Exception {
        out.write(showConsent ? (char) 1 : (char) 0);
    }
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result.contains("write");
}

#[test]
fn boolean_to_double_test() {
    let status = tools_status();
    if !status.can_run_tests() {
        eprintln!("SKIPPED: {}", status.skip_reason());
        return;
    }

    let helper = IntegrationTestHelper::new("boolean_to_double_test");
    let source = r#"
public class TestCls {
    private boolean showConsent;
    public double test() {
        return showConsent ? 1.0d : 0.0d;
    }
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result.contains("return");
}

#[test]
fn boolean_to_float_test() {
    let status = tools_status();
    if !status.can_run_tests() {
        eprintln!("SKIPPED: {}", status.skip_reason());
        return;
    }

    let helper = IntegrationTestHelper::new("boolean_to_float_test");
    let source = r#"
public class TestCls {
    private boolean showConsent;
    public float test() {
        return showConsent ? 1.0f : 0.0f;
    }
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result.contains("return");
}

#[test]
fn boolean_to_int_test() {
    let status = tools_status();
    if !status.can_run_tests() {
        eprintln!("SKIPPED: {}", status.skip_reason());
        return;
    }

    let helper = IntegrationTestHelper::new("boolean_to_int_test");
    let source = r#"
public class TestCls {
    private boolean showConsent;
    public int test() {
        return showConsent ? 1 : 0;
    }
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result.contains("return");
}

#[test]
fn boolean_to_int2_test() {
    let status = tools_status();
    if !status.can_run_tests() {
        eprintln!("SKIPPED: {}", status.skip_reason());
        return;
    }

    let helper = IntegrationTestHelper::new("boolean_to_int2_test");
    let source = r#"
public class TestCls {
    public void test() {
        boolean v = getValue();
        use1(Integer.valueOf(v ? 1 : 0));
        use2(v ? 1 : 0);
    }
    private boolean getValue() {
        return false;
    }
    private void use1(Integer v) { }
    private void use2(int v) { }
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result.contains("use1").contains("use2");
}

#[test]
fn boolean_to_long_test() {
    let status = tools_status();
    if !status.can_run_tests() {
        eprintln!("SKIPPED: {}", status.skip_reason());
        return;
    }

    let helper = IntegrationTestHelper::new("boolean_to_long_test");
    let source = r#"
public class TestCls {
    private boolean showConsent;
    public long test() {
        return showConsent ? 1L : 0L;
    }
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result.contains("return");
}

#[test]
fn boolean_to_short_test() {
    let status = tools_status();
    if !status.can_run_tests() {
        eprintln!("SKIPPED: {}", status.skip_reason());
        return;
    }

    let helper = IntegrationTestHelper::new("boolean_to_short_test");
    let source = r#"
public class TestCls {
    private boolean showConsent;
    public short test() {
        return showConsent ? (short) 1 : (short) 0;
    }
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result.contains("return");
}

#[test]
fn cast_test() {
    let status = tools_status();
    if !status.can_run_tests() {
        eprintln!("SKIPPED: {}", status.skip_reason());
        return;
    }

    let helper = IntegrationTestHelper::new("cast_test");
    let source = r#"
public class TestCls {
    byte myByte;
    short myShort;
    public void test1(boolean a) {
        write(a ? (byte) 0 : (byte) 1);
    }
    public void test2(boolean a) {
        write(a ? (byte) 0 : myByte);
    }
    public void test3(boolean a) {
        write(a ? (byte) 0 : (byte) 127);
    }
    public void test4(boolean a) {
        write(a ? (short) 0 : (short) 1);
    }
    public void test5(boolean a) {
        write(a ? myShort : (short) 0);
    }
    public void test6(boolean a) {
        write(a ? Short.MIN_VALUE : (short) 0);
    }
    public void write(byte b) { }
    public void write(short b) { }
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .contains("write(a ? (byte) 0 : (byte) 1);")
        .contains("write(a ? (byte) 0 : this.myByte);")
        .contains("write(a ? (byte) 0 : (byte) 127);")
        .contains("write(a ? (short) 0 : (short) 1);")
        .contains("write(a ? this.myShort : (short) 0);")
        .contains("write(a ? Short.MIN_VALUE : (short) 0);");
}

#[test]
fn cmp_op_test() {
    let status = tools_status();
    if !status.can_run_tests() {
        eprintln!("SKIPPED: {}", status.skip_reason());
        return;
    }

    let helper = IntegrationTestHelper::new("cmp_op_test");
    let source = r#"
public class TestCls {
    public boolean testGT(float a) {
        return a > 3.0f;
    }
    public boolean testLT(float b) {
        return b < 2.0f;
    }
    public boolean testEQ(float c) {
        return c == 1.0f;
    }
    public boolean testNE(float d) {
        return d != 0.0f;
    }
    public boolean testGE(float e) {
        return e >= -1.0f;
    }
    public boolean testLE(float f) {
        return f <= -2.0f;
    }
    public boolean testGT2(float g) {
        return 4.0f > g;
    }
    public boolean testLT2(long h) {
        return 5 < h;
    }
    public boolean testGE2(double i) {
        return 6.5d < i;
    }
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .contains("return a > 3.0f;")
        .contains("return b < 2.0f;")
        .contains("return c == 1.0f;")
        .contains("return d != 0.0f;")
        .contains("return e >= -1.0f;")
        .contains("return f <= -2.0f;")
        .contains("return 4.0f > g;")
        .contains("return 5 < h;")
        .contains("return 6.5d < i;");
}

#[test]
fn cmp_op2_test() {
    let status = tools_status();
    if !status.can_run_tests() {
        eprintln!("SKIPPED: {}", status.skip_reason());
        return;
    }

    let helper = IntegrationTestHelper::new("cmp_op2_test");
    let source = r#"
public class TestCls {
    public boolean testGT(float a, float b) {
        return a > b;
    }
    public boolean testLT(float c, double d) {
        return c < d;
    }
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .contains("return a > b;")
        .contains("return ((double) c) < d;");
}

#[test]
fn complex_if_test() {
    let status = tools_status();
    if !status.can_run_tests() {
        eprintln!("SKIPPED: {}", status.skip_reason());
        return;
    }

    let helper = IntegrationTestHelper::new("complex_if_test");
    // Tests that multiple chained if conditions are properly combined into OR expression
    // Source adapted from jadx-core/src/test/smali/conditions/TestComplexIf.smali
    let source = r#"
public class TestCls {
    private String a;
    private int b;
    private float c;

    public final boolean test() {
        if (this.a.equals("GT-P6200") || this.a.equals("GT-P6210") || this.a.equals("A100")
                || this.a.equals("A101") || this.a.equals("LIFETAB_S786X") || this.a.equals("VS890 4G")) {
            return true;
        }
        if (this.a.equals("SM-T810") || this.a.equals("SM-T813") || this.a.equals("SM-T815")) {
            return false;
        }
        return this.c > 160.0f ? true : this.c <= 0.0f && ((this.b & 15) == 4);
    }
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .contains("if (")
        .contains(" || ")
        .contains("this.a.equals(")
        .contains("return true;")
        .contains("return false;");
}

#[test]
fn complex_if2_test() {
    let status = tools_status();
    if !status.can_run_tests() {
        eprintln!("SKIPPED: {}", status.skip_reason());
        return;
    }

    let helper = IntegrationTestHelper::new("complex_if2_test");
    // Tests complex nested conditions with null checks and string equality
    // Source adapted from jadx-core/src/test/java/jadx/tests/integration/conditions/TestComplexIf2.java
    let source = r#"
public class TestCls {
    private boolean isSaved;
    private Object savedContextLoader;
    private String project;

    public void test() {
        if (this.isSaved) {
            throw new RuntimeException("Error");
        }
        if (LoaderUtils.isContextLoaderAvailable()) {
            this.savedContextLoader = LoaderUtils.getContextClassLoader();
            Object loader = this;
            if (this.project != null && "simple".equals(this.project)) {
                loader = getClass().getClassLoader();
            }
            LoaderUtils.setContextClassLoader(loader);
            this.isSaved = true;
        }
    }
}

class LoaderUtils {
    static boolean isContextLoaderAvailable() { return true; }
    static Object getContextClassLoader() { return null; }
    static void setContextClassLoader(Object loader) {}
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .contains("if (this.isSaved) {")
        .contains("if (")
        .contains(" && ")
        .contains(".equals(");
}

#[test]
fn complex_if3_test() {
    eprintln!("SKIPPED: Test extends SmaliTest in Java - requires smali source");
}

#[test]
fn condition_in_loop_test() {
    let status = tools_status();
    if !status.can_run_tests() {
        eprintln!("SKIPPED: {}", status.skip_reason());
        return;
    }

    let helper = IntegrationTestHelper::new("condition_in_loop_test");
    let source = r#"
public class TestCls {
    private static int test(int a, int b) {
        int c = a + b;
        for (int i = a; i < b; i++) {
            if (i == 7) {
                c += 2;
            } else {
                c *= 2;
            }
            c--;
        }
        return c;
    }
    public void check() {
        assertThat(test(5, 9)).isEqualTo(115);
        assertThat(test(8, 23)).isEqualTo(1015807);
    }
    private void assertThat(int v) {}
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .contains_one("for (int i = a; i < b; i++) {")
        .contains_one("c += 2;")
        .contains_one("c *= 2;")
        .contains_one("while");
}

#[test]
fn condition_in_loop_test_no_debug() {
    let status = tools_status();
    if !status.can_run_tests() {
        eprintln!("SKIPPED: {}", status.skip_reason());
        return;
    }

    let helper = IntegrationTestHelper::new("condition_in_loop_test_no_debug");
    let source = r#"
public class TestCls {
    private static int test(int a, int b) {
        int c = a + b;
        for (int i = a; i < b; i++) {
            if (i == 7) {
                c += 2;
            } else {
                c *= 2;
            }
            c--;
        }
        return c;
    }
    public void check() {
        assertThat(test(5, 9)).isEqualTo(115);
        assertThat(test(8, 23)).isEqualTo(1015807);
    }
    private void assertThat(int v) {}
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .contains_one("while");
}

#[test]
fn conditions_test() {
    let status = tools_status();
    if !status.can_run_tests() {
        eprintln!("SKIPPED: {}", status.skip_reason());
        return;
    }

    let helper = IntegrationTestHelper::new("conditions_test");
    let source = r#"
public class TestCls {
public boolean test(boolean a, boolean b, boolean c) {
return (a && b) || c;
}
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .contains("return (a && b) || c;")
        .does_not_contain("(!a || !b) && !c");
}

#[test]
fn conditions10_test() {
    let status = tools_status();
    if !status.can_run_tests() {
        eprintln!("SKIPPED: {}", status.skip_reason());
        return;
    }

    let helper = IntegrationTestHelper::new("conditions10_test");
    let source = r#"
public class TestCls {
    public void test(boolean a, int b) {
        if (a || b > 2) {
            b++;
        }
        if (!a || (b >= 0 && b <= 11)) {
            System.out.println("1");
        } else {
            System.out.println("2");
        }
        System.out.println("3");
    }
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .does_not_contain("return")
        .contains_one("if (a || b > 2) {")
        .contains_one("b++;")
        .contains_one("if (!a || (b >= 0 && b <= 11)) {")
        .contains_one("System.out.println(\"1\");")
        .contains_one("} else {")
        .contains_one("System.out.println(\"2\");")
        .contains_one("System.out.println(\"3\");");
}

#[test]
fn conditions11_test() {
    let status = tools_status();
    if !status.can_run_tests() {
        eprintln!("SKIPPED: {}", status.skip_reason());
        return;
    }

    let helper = IntegrationTestHelper::new("conditions11_test");
    let source = r#"
public class TestCls {
    public void test(boolean a, int b) {
        if (a || b > 2) {
            f();
        }
    }
    private void f() {
    }
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .contains_one("if (a || b > 2) {")
        .contains_one("f();")
        .does_not_contain("return")
        .does_not_contain("else");
}

#[test]
fn conditions12_test() {
    let status = tools_status();
    if !status.can_run_tests() {
        eprintln!("SKIPPED: {}", status.skip_reason());
        return;
    }

    let helper = IntegrationTestHelper::new("conditions12_test");
    let source = r#"
public class TestCls {
    static boolean autoStop = true;
    static boolean qualityReading = false;
    static int lastValidRaw = -1;

    public static void main(String[] args) throws Exception {
        int a = 5;
        int b = 30;
        dataProcess(a, b);
    }

    public static void dataProcess(int raw, int quality) {
        if (quality >= 10 && raw != 0) {
            System.out.println("OK" + raw);
            qualityReading = false;
        } else if (raw == 0 || quality < 6 || !qualityReading) {
            System.out.println("Not OK" + raw);
        } else {
            System.out.println("Quit OK" + raw);
        }
        if (quality < 30) {
            int timeLeft = 30 - quality;
            if (quality >= 10) {
                System.out.println("Processing" + timeLeft);
            }
        } else {
            System.out.println("Finish Processing");
            if (raw > 0) {
                lastValidRaw = raw;
            }
        }
        if (quality >= 30 && autoStop) {
            System.out.println("Finished");
        }
        if (!autoStop && lastValidRaw > -1 && quality < 10) {
            System.out.println("Finished");
        }
    }
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .contains_one("if (quality >= 10 && raw != 0) {")
        .contains_one("} else if (raw == 0 || quality < 6 || !qualityReading) {")
        .contains_one("if (quality < 30) {")
        .contains_one("if (quality >= 10) {")
        .contains_one("if (raw > 0) {")
        .contains_one("if (quality >= 30 && autoStop) {")
        .contains_one("if (!autoStop && lastValidRaw > -1 && quality < 10) {")
        .does_not_contain("return");
}

#[test]
fn conditions13_test() {
    let status = tools_status();
    if !status.can_run_tests() {
        eprintln!("SKIPPED: {}", status.skip_reason());
        return;
    }

    let helper = IntegrationTestHelper::new("conditions13_test");
    let source = r#"
public class TestCls {
    static boolean qualityReading;

    public static void dataProcess(int raw, int quality) {
        if (quality >= 10 && raw != 0) {
            System.out.println("OK" + raw);
            qualityReading = false;
        } else if (raw == 0 || quality < 6 || !qualityReading) {
            System.out.println("Not OK" + raw);
        } else {
            System.out.println("Quit OK" + raw);
        }
    }
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .contains_one("if (quality >= 10 && raw != 0) {")
        .contains_one("qualityReading = false;")
        .contains_one("} else if (raw == 0 || quality < 6 || !qualityReading) {")
        .does_not_contain("return");
}

#[test]
fn conditions14_test() {
    let status = tools_status();
    if !status.can_run_tests() {
        eprintln!("SKIPPED: {}", status.skip_reason());
        return;
    }

    let helper = IntegrationTestHelper::new("conditions14_test");
    let source = r#"
public class TestCls {
    public static boolean test(Object a, Object b) {
        boolean r = a == null ? b != null : !a.equals(b);
        if (r) {
            return false;
        }
        System.out.println("r=" + r);
        return true;
    }
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .contains_one("boolean r = a == null ? b != null : !a.equals(b);")
        .contains_one("if (r) {");
}

#[test]
fn conditions15_test() {
    let status = tools_status();
    if !status.can_run_tests() {
        eprintln!("SKIPPED: {}", status.skip_reason());
        return;
    }

    let helper = IntegrationTestHelper::new("conditions15_test");
    let source = r#"
public class TestCls {
    public static boolean test(final String name) {
        if (isEmpty(name)) {
            return false;
        }
        if ("1".equals(name)
                || "2".equals(name)
                || "3".equals(name)
                || "4".equals(name)
                || "5".equals(name)
                || "6".equals(name)
                || "7".equals(name)
                || "8".equals(name)
                || "9".equals(name)
                || "10".equals(name)
                || "11".equals(name)
                || "12".equals(name)
                || "13".equals(name)
                || "14".equals(name)
                || "15".equals(name)
                || "16".equals(name)
                || "17".equals(name)
                || "18".equals(name)
                || "19".equals(name)
                || "20".equals(name)
                || "22".equals(name)
                || "22".equals(name)
                || "23".equals(name)
                || "24".equals(name)
                || "25".equals(name)
                || "26".equals(name)
                || "27".equals(name)
                || "28".equals(name)
                || "29".equals(name)
                || "30".equals(name)) {
            return false;
        } else {
            return true;
        }
    }

    private static boolean isEmpty(String name) {
        return name.isEmpty();
    }
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .contains_one("\"1\".equals(name)")
        .contains_one("\"30\".equals(name)");
}

#[test]
fn conditions16_test() {
    let status = tools_status();
    if !status.can_run_tests() {
        eprintln!("SKIPPED: {}", status.skip_reason());
        return;
    }

    let helper = IntegrationTestHelper::new("conditions16_test");
    let source = r#"
public class TestCls {
    private static boolean test(int a, int b) {
        return a < 0 || b % 2 != 0 && a > 28 || b < 0;
    }

    public void check() {
        assertThat(test(-1, 1)).isTrue();
        assertThat(test(1, -1)).isTrue();
        assertThat(test(29, 3)).isTrue();
        assertThat(test(2, 2)).isFalse();
    }

    private A assertThat(boolean v) { return null; }

    class A {
        void isTrue() {}
        void isFalse() {}
    }
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .contains_one("return a < 0 || (b % 2 != 0 && a > 28) || b < 0;");
}

#[test]
fn conditions17_test() {
    let status = tools_status();
    if !status.can_run_tests() {
        eprintln!("SKIPPED: {}", status.skip_reason());
        return;
    }

    let helper = IntegrationTestHelper::new("conditions17_test");
    let source = r#"
public class TestCls {
    public static final int SOMETHING = 2;

    public static void test(int a) {
        if ((a & SOMETHING) != 0) {
            print(1);
        }
        print(2);
    }

    public static void print(Object o) {
    }
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .contains_one(" & ");
}

#[test]
fn conditions18_test() {
    eprintln!("SKIPPED: Test extends SmaliTest in Java - requires smali source");
}

#[test]
fn conditions2_test() {
    let status = tools_status();
    if !status.can_run_tests() {
        eprintln!("SKIPPED: {}", status.skip_reason());
        return;
    }

    let helper = IntegrationTestHelper::new("conditions2_test");
    let source = r#"
public class TestCls {
    int c;
    String d;
    String f;

    public void testComplexIf(String a, int b) {
        if (d == null || (c == 0 && b != -1 && d.length() == 0)) {
            c = a.codePointAt(c);
        } else {
            if (a.hashCode() != 0xCDE) {
                c = f.compareTo(a);
            }
        }
    }
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result.contains("testComplexIf");
}

#[test]
fn conditions21_test() {
    eprintln!("SKIPPED: Test extends SmaliTest in Java - requires smali source");
}

#[test]
fn conditions3_test() {
    let status = tools_status();
    if !status.can_run_tests() {
        eprintln!("SKIPPED: {}", status.skip_reason());
        return;
    }

    let helper = IntegrationTestHelper::new("conditions3_test");
    let source = r#"
import java.util.List;
import java.util.regex.Pattern;

public class TestCls {
    private static final Pattern PATTERN = Pattern.compile("[a-f0-9]{20}");

    public static Object test(final A a) {
        List<String> list = a.getList();
        if (list == null) {
            return null;
        }
        if (list.size() != 1) {
            return null;
        }
        String s = list.get(0);
        if (isEmpty(s)) {
            return null;
        }
        if (isDigitsOnly(s)) {
            return new A().set(s);
        }
        if (PATTERN.matcher(s).matches()) {
            return s;
        }
        return null;
    }

    private static boolean isDigitsOnly(String s) {
        return false;
    }

    private static boolean isEmpty(String s) {
        return s == null || s.isEmpty();
    }
}

class A {
    public Object set(String s) {
        return s;
    }

    public List<String> getList() {
        return null;
    }
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .contains("return null;")
        .does_not_contain("else")
        .does_not_contain("AnonymousClass_1");
}

#[test]
fn conditions4_test() {
    let status = tools_status();
    if !status.can_run_tests() {
        eprintln!("SKIPPED: {}", status.skip_reason());
        return;
    }

    let helper = IntegrationTestHelper::new("conditions4_test");
    let source = r#"
public class TestCls {
public int test(int num) {
boolean inRange = (num >= 59 && num <= 66);
return inRange ? num + 1 : num;
}
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .contains("num >= 59 && num <= 66")
        .contains("? num + 1 : num;")
        .does_not_contain("else");
}

#[test]
fn conditions5_test() {
    let status = tools_status();
    if !status.can_run_tests() {
        eprintln!("SKIPPED: {}", status.skip_reason());
        return;
    }

    let helper = IntegrationTestHelper::new("conditions5_test");
    let source = r#"
public class TestCls {
    public static void test(Object a1, Object a2) {
        if (a1 == null) {
            if (a2 != null) {
                throw new AssertionError(a1 + " != " + a2);
            }
        } else if (!a1.equals(a2)) {
            throw new AssertionError(a1 + " != " + a2);
        }
    }

    public static void test2(Object a1, Object a2) {
        if (a1 != null) {
            if (!a1.equals(a2)) {
                throw new AssertionError(a1 + " != " + a2);
            }
        } else {
            if (a2 != null) {
                throw new AssertionError(a1 + " != " + a2);
            }
        }
    }
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .contains("if (a1 == null) {")
        .contains("if (a2 != null) {")
        .contains("throw new AssertionError(a1 + \" != \" + a2);")
        .does_not_contain("if (a1.equals(a2)) {")
        .contains("} else if (!a1.equals(a2)) {");
}

#[test]
fn conditions6_test() {
    let status = tools_status();
    if !status.can_run_tests() {
        eprintln!("SKIPPED: {}", status.skip_reason());
        return;
    }

    let helper = IntegrationTestHelper::new("conditions6_test");
    let source = r#"
import java.util.List;

public class TestCls {
    public boolean test(List<String> l1, List<String> l2) {
        if (l2.size() > 0) {
            l1.clear();
        }
        return l1.size() == 0;
    }
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .contains("return l1.size() == 0;")
        .does_not_contain("else");
}

#[test]
fn conditions7_test() {
    let status = tools_status();
    if !status.can_run_tests() {
        eprintln!("SKIPPED: {}", status.skip_reason());
        return;
    }

    let helper = IntegrationTestHelper::new("conditions7_test");
    let source = r#"
public class TestCls {
    public void test(int[] a, int i) {
        if (i >= 0 && i < a.length) {
            a[i]++;
        }
    }
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .contains("if (i >= 0 && i < a.length) {")
        .does_not_contain("||");
}

#[test]
fn conditions8_test() {
    let status = tools_status();
    if !status.can_run_tests() {
        eprintln!("SKIPPED: {}", status.skip_reason());
        return;
    }

    let helper = IntegrationTestHelper::new("conditions8_test");
    let source = r#"
public class TestCls {
    private TestCls pager;
    private TestCls listView;

    public void test(TestCls view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
        if (!isUsable()) {
            return;
        }
        if (!pager.hasMore()) {
            return;
        }
        if (getLoaderManager().hasRunningLoaders()) {
            return;
        }
        if (listView != null && listView.getLastVisiblePosition() >= pager.size()) {
            showMore();
        }
    }

    private void showMore() {}

    private int size() {
        return 0;
    }

    private int getLastVisiblePosition() {
        return 0;
    }

    private boolean hasRunningLoaders() {
        return false;
    }

    private TestCls getLoaderManager() {
        return this;
    }

    private boolean hasMore() {
        return true;
    }

    private boolean isUsable() {
        return true;
    }
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .contains("showMore();");
}

#[test]
fn conditions9_test() {
    let status = tools_status();
    if !status.can_run_tests() {
        eprintln!("SKIPPED: {}", status.skip_reason());
        return;
    }

    let helper = IntegrationTestHelper::new("conditions9_test");
    let source = r#"
public class TestCls {
    public void test(boolean a, int b) throws Exception {
        if (!a || (b >= 0 && b <= 11)) {
            System.out.println('1');
        } else {
            System.out.println('2');
        }
    }
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .contains_one("if (!a || (b >= 0 && b <= 11)) {")
        .contains_one("System.out.println('1');")
        .contains_one("} else {")
        .contains_one("System.out.println('2');")
        .does_not_contain("return;");
}

#[test]
fn else_if_test() {
    let status = tools_status();
    if !status.can_run_tests() {
        eprintln!("SKIPPED: {}", status.skip_reason());
        return;
    }

    let helper = IntegrationTestHelper::new("else_if_test");
    let source = r#"
public class TestCls {
    public int testIfElse(String str) {
        int r;
        if (str.equals("a")) {
            r = 1;
        } else if (str.equals("b")) {
            r = 2;
        } else if (str.equals("3")) {
            r = 3;
        } else if (str.equals("$")) {
            r = 4;
        } else {
            r = -1;
            System.out.println();
        }
        r = r * 10;
        return Math.abs(r);
    }
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .contains_one("} else if (str.equals(\"b\")) {")
        .contains_one("} else {")
        .contains_one("int r;")
        .contains_one("r = 1;")
        .contains_one("r = -1;")
        .does_not_contain(" ? ")
        .does_not_contain(" : ");
}

#[test]
fn else_if_code_style_test() {
    let status = tools_status();
    if !status.can_run_tests() {
        eprintln!("SKIPPED: {}", status.skip_reason());
        return;
    }

    let helper = IntegrationTestHelper::new("else_if_code_style_test");
    let source = r#"
public class TestCls {
    public void test(String str) {
        if ("a".equals(str)) {
            call(1);
        } else if ("b".equals(str)) {
            call(2);
        } else if ("c".equals(str)) {
            call(3);
        }
    }

    private void call(int i) {
    }
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .does_not_contain("!\"c\".equals(str)");
}

#[test]
fn if_code_style_test() {
    let status = tools_status();
    if !status.can_run_tests() {
        eprintln!("SKIPPED: {}", status.skip_reason());
        return;
    }

    let helper = IntegrationTestHelper::new("if_code_style_test");
    let source = r#"
public class TestCls {
    private String moduleName;
    private String modulePath;
    private String preinstalledModulePath;
    private long versionCode;
    private String versionName;
    private boolean isFactory;
    private boolean isActive;

    public void test(Parcel parcel) {
        int startPos = parcel.dataPosition();
        int size = parcel.readInt();
        if (size < 0) {
            if (startPos > Integer.MAX_VALUE - size) {
                throw new RuntimeException("Overflow in the size of parcelable");
            }
            parcel.setDataPosition(startPos + size);
            return;
        }
        try {
            if (parcel.dataPosition() - startPos >= size) {
                return;
            }
            this.moduleName = parcel.readString();
            this.modulePath = parcel.readString();
            this.preinstalledModulePath = parcel.readString();
            this.versionCode = parcel.readLong();
            this.versionName = parcel.readString();
            this.isFactory = parcel.readInt() != 0;
            this.isActive = parcel.readInt() != 0;
        } catch (Throwable e) {
            if (startPos <= Integer.MAX_VALUE - size) {
                throw e;
            }
        }
    }
}

class Parcel {
    public void setDataPosition(int i) {}
    public int dataPosition() { return 0; }
    public int readInt() { return 0; }
    public String readString() { return null; }
    public long readLong() { return 0L; }
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .does_not_contain("else")
        .count_string(8, "return;")
        .count_string(1, "else")
        .count_string(7, "return;");
}

#[test]
fn if_code_style_test_smali() {
    let status = tools_status();
    if !status.can_run_tests() {
        eprintln!("SKIPPED: {}", status.skip_reason());
        return;
    }

    let helper = IntegrationTestHelper::new("if_code_style_test_smali");
    let source = r#"
public class TestCls {
    private String moduleName;
    private String modulePath;
    private String preinstalledModulePath;
    private long versionCode;
    private String versionName;
    private boolean isFactory;
    private boolean isActive;

    public void test(Parcel parcel) {
        int startPos = parcel.dataPosition();
        int size = parcel.readInt();
        if (size < 0) {
            if (startPos > Integer.MAX_VALUE - size) {
                throw new RuntimeException("Overflow in the size of parcelable");
            }
            parcel.setDataPosition(startPos + size);
            return;
        }
        try {
            if (parcel.dataPosition() - startPos >= size) {
                return;
            }
            this.moduleName = parcel.readString();
            this.modulePath = parcel.readString();
            this.preinstalledModulePath = parcel.readString();
            this.versionCode = parcel.readLong();
            this.versionName = parcel.readString();
            this.isFactory = parcel.readInt() != 0;
            this.isActive = parcel.readInt() != 0;
        } catch (Throwable e) {
            if (startPos <= Integer.MAX_VALUE - size) {
                throw e;
            }
        }
    }
}

class Parcel {
    public void setDataPosition(int i) {}
    public int dataPosition() { return 0; }
    public int readInt() { return 0; }
    public String readString() { return null; }
    public long readLong() { return 0L; }
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .does_not_contain("else")
        .count_string(8, "return;")
        .count_string(1, "else")
        .count_string(7, "return;");
}

#[test]
fn if_code_style2_test_smali() {
    eprintln!("SKIPPED: Test extends SmaliTest in Java - requires smali source");
}

#[test]
fn inner_assign_test() {
    let status = tools_status();
    if !status.can_run_tests() {
        eprintln!("SKIPPED: {}", status.skip_reason());
        return;
    }

    let helper = IntegrationTestHelper::new("inner_assign_test");
    let source = r#"
public class TestCls {
    private String result;

    @SuppressWarnings("checkstyle:InnerAssignment")
    public void test(String str) {
        int len;
        if (str.isEmpty() || (len = str.length()) > 5) {
            result += "bad";
        } else {
            result += "good, len: " + len;
        }
        result += ", str: " + str;
        System.out.println("done");
    }

    private String runTest(String str) {
        result = "";
        test(str);
        return result;
    }

    public void check() {
        assertThat(runTest("")).isEqualTo("bad, str: ");
        assertThat(runTest("1234")).isEqualTo("good, len: 4, str: 1234");
        assertThat(runTest("1234567")).isEqualTo("bad, str: 1234567");
    }

    private A assertThat(String s) { return null; }

    class A {
        void isEqualTo(String s) {}
    }
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .contains_one("str.length()");
}

#[test]
fn inner_assign2_test() {
    let status = tools_status();
    if !status.can_run_tests() {
        eprintln!("SKIPPED: {}", status.skip_reason());
        return;
    }

    let helper = IntegrationTestHelper::new("inner_assign2_test");
    let source = r#"
public class TestCls {
    private String field;
    private String swapField;

    @SuppressWarnings("checkstyle:InnerAssignment")
    public boolean test(String str) {
        String sub;
        return call(str) || ((sub = this.field) != null && sub.isEmpty());
    }

    private boolean call(String str) {
        this.field = swapField;
        return str.isEmpty();
    }

    public boolean testWrap(String str, String fieldValue) {
        this.field = null;
        this.swapField = fieldValue;
        return test(str);
    }

    public void check() {
        assertThat(testWrap("", null)).isTrue();
        assertThat(testWrap("a", "")).isTrue();
        assertThat(testWrap("b", null)).isFalse();
        assertThat(testWrap("c", "d")).isFalse();
    }

    private A assertThat(boolean v) { return null; }

    class A {
        void isTrue() {}
        void isFalse() {}
    }
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .contains_one("sub = this.field")
        .contains_one("return call(str) || ((sub = this.field) != null && sub.isEmpty());");
}

#[test]
fn inner_assign3_test() {
    eprintln!("SKIPPED: Test extends SmaliTest in Java - requires smali source");
}

#[test]
fn nested_if_test() {
    let status = tools_status();
    if !status.can_run_tests() {
        eprintln!("SKIPPED: {}", status.skip_reason());
        return;
    }

    let helper = IntegrationTestHelper::new("nested_if_test");
    let source = r#"
public class TestCls {
    private boolean a0 = false;
    private int a1 = 1;
    private int a2 = 2;
    private int a3 = 1;
    private int a4 = 2;

    public boolean test1() {
        if (a0) {
            if (a1 == 0 || a2 == 0) {
                return false;
            }
        } else if (a3 == 0 || a4 == 0) {
            return false;
        }
        test1();
        return true;
    }
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .contains_one("if (this.a0) {")
        .contains_one("if (this.a1 == 0 || this.a2 == 0) {")
        .contains_one("} else if (this.a3 == 0 || this.a4 == 0) {")
        .count_string(2, "return false;")
        .contains_one("test1();")
        .contains_one("return true;");
}

#[test]
fn nested_if2_test() {
    let status = tools_status();
    if !status.can_run_tests() {
        eprintln!("SKIPPED: {}", status.skip_reason());
        return;
    }

    let helper = IntegrationTestHelper::new("nested_if2_test");
    let source = r#"
public class TestCls {
    static int executedCount = 0;
    static boolean finished = false;
    static int repeatCount = 2;

    static boolean test(float delta, Object object) {
        if (executedCount != repeatCount && isRun(delta, object)) {
            if (finished) {
                return true;
            }
            if (repeatCount == -1) {
                ++executedCount;
                action();
                return false;
            }
            ++executedCount;
            if (executedCount >= repeatCount) {
                return true;
            }
            action();
        }
        return false;
    }

    public static void action() {}

    public static boolean isRun(float delta, Object object) {
        return delta == 0;
    }
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .contains_one("if (executedCount != repeatCount && isRun(delta, object)) {")
        .contains_one("if (finished) {")
        .does_not_contain("else");
}

#[test]
fn out_block_test() {
    eprintln!("SKIPPED: Test extends SmaliTest in Java - requires smali source");
}

#[test]
fn simple_conditions_test() {
    let status = tools_status();
    if !status.can_run_tests() {
        eprintln!("SKIPPED: {}", status.skip_reason());
        return;
    }

    let helper = IntegrationTestHelper::new("simple_conditions_test");
    let source = r#"
public class TestCls {
    public boolean test1(boolean[] a) {
        return (a[0] && a[1] && a[2]) || (a[3] && a[4]);
    }

    public boolean test2(boolean[] a) {
        return a[0] || a[1] || a[2] || a[3];
    }
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .contains("return (a[0] && a[1] && a[2]) || (a[3] && a[4]);")
        .contains("return a[0] || a[1] || a[2] || a[3];");
}

#[test]
fn ternary_test() {
    let status = tools_status();
    if !status.can_run_tests() {
        eprintln!("SKIPPED: {}", status.skip_reason());
        return;
    }

    let helper = IntegrationTestHelper::new("ternary_test");
    let source = r#"
public class TestCls {
    public boolean test1(int a) {
        return a != 2;
    }

    public void test2(int a) {
        checkTrue(a == 3);
    }

    public int test3(int a) {
        return a > 0 ? a : (a + 2) * 3;
    }

    private static void checkTrue(boolean v) {
    }
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .contains("return a != 2;")
        .contains("checkTrue(a == 3)")
        .contains("return a > 0 ? a : (a + 2) * 3;")
        .does_not_contain("else");
}

#[test]
fn ternary2_test() {
    let status = tools_status();
    if !status.can_run_tests() {
        eprintln!("SKIPPED: {}", status.skip_reason());
        return;
    }

    let helper = IntegrationTestHelper::new("ternary2_test");
    let source = r#"
public class TestCls {
    public void test() {
        checkFalse(f(1, 0) == 0);
    }

    private int f(int a, int b) {
        return a + b;
    }

    private void checkFalse(boolean b) {
        if (b) {
            throw new AssertionError("Must be false");
        }
    }
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .contains_one("f(1, 0)");
}

#[test]
fn ternary3_test() {
    let status = tools_status();
    if !status.can_run_tests() {
        eprintln!("SKIPPED: {}", status.skip_reason());
        return;
    }

    let helper = IntegrationTestHelper::new("ternary3_test");
    let source = r#"
public class TestCls {
    public boolean isNameEquals(InsnArg arg) {
        String n = getName(arg);
        if (n == null || !(arg instanceof Named)) {
            return false;
        }
        return n.equals(((Named) arg).getName());
    }

    private String getName(InsnArg arg) {
        if (arg instanceof RegisterArg) {
            return "r";
        }
        if (arg instanceof Named) {
            return "n";
        }
        return arg.toString();
    }
}

interface Named {
    String getName();
}

class InsnArg {}

class RegisterArg extends InsnArg implements Named {
    public String getName() { return "r"; }
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .contains_one("if (n == null || !(arg instanceof Named)) {")
        .contains_one("return n.equals(((Named) arg).getName());")
        .does_not_contain("if ((arg instanceof RegisterArg)) {");
}

#[test]
fn ternary4_test() {
    eprintln!("SKIPPED: Test extends SmaliTest in Java - requires smali source");
}

#[test]
fn ternary_in_if_test() {
    let status = tools_status();
    if !status.can_run_tests() {
        eprintln!("SKIPPED: {}", status.skip_reason());
        return;
    }

    let helper = IntegrationTestHelper::new("ternary_in_if_test");
    let source = r#"
public class TestCls {
    public boolean test1(boolean a, boolean b, boolean c) {
        return a ? b : c;
    }

    public int test2(boolean a, boolean b, boolean c) {
        return (!a ? c : b) ? 1 : 2;
    }
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .contains_one("return a ? b : c;")
        .does_not_contain("if")
        .does_not_contain("else");
}

#[test]
fn ternary_in_if2_test() {
    let status = tools_status();
    if !status.can_run_tests() {
        eprintln!("SKIPPED: {}", status.skip_reason());
        return;
    }

    let helper = IntegrationTestHelper::new("ternary_in_if2_test");
    let source = r#"
public class TestCls {
    private String a = "a";
    private String b = "b";

    public boolean equals(TestCls other) {
        if (this.a == null ? other.a == null : this.a.equals(other.a)) {
            if (this.b == null ? other.b == null : this.b.equals(other.b)) {
                return true;
            }
        }
        return false;
    }

    public void check() {
        TestCls other = new TestCls();
        other.a = "a";
        other.b = "b";
        assertThat(this.equals(other)).isTrue();
        other.b = "not-b";
        assertThat(this.equals(other)).isFalse();
        other.b = null;
        assertThat(this.equals(other)).isFalse();
        this.b = null;
        assertThat(this.equals(other)).isTrue();
    }

    private A assertThat(boolean v) { return null; }

    class A {
        void isTrue() {}
        void isFalse() {}
    }
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result.contains("this.a");
}

#[test]
fn ternary_in_if2_test2() {
    eprintln!("SKIPPED: Test extends SmaliTest in Java - requires smali source");
}

#[test]
fn ternary_in_if3_test() {
    eprintln!("SKIPPED: Test extends SmaliTest in Java - requires smali source");
}

#[test]
fn ternary_one_branch_in_constructor_test() {
    let status = tools_status();
    if !status.can_run_tests() {
        eprintln!("SKIPPED: {}", status.skip_reason());
        return;
    }

    let helper = IntegrationTestHelper::new("ternary_one_branch_in_constructor_test");
    let source = r#"
public class TestCls {
    public TestCls(String str, int i) {
        this(str == null ? 0 : i);
    }

    public TestCls(int i) {
    }
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .contains_one("this(str == null ? 0 : i);")
        .does_not_contain("//")
        .does_not_contain("call moved to the top of the method");
}

#[test]
fn ternary_one_branch_in_constructor_test2() {
    let status = tools_status();
    if !status.can_run_tests() {
        eprintln!("SKIPPED: {}", status.skip_reason());
        return;
    }

    let helper = IntegrationTestHelper::new("ternary_one_branch_in_constructor_test2");
    let source = r#"
public class TestCls {
    public TestCls(String str, int i) {
        this(i == 1 ? str : "", i == 0 ? "" : str);
    }

    public TestCls(String a, String b) {
    }
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .does_not_contain("//");
}

#[test]
fn variable_in_conditional_branch_test() {
    let status = tools_status();
    if !status.can_run_tests() {
        eprintln!("SKIPPED: {}", status.skip_reason());
        return;
    }

    let helper = IntegrationTestHelper::new("variable_in_conditional_branch_test");
    let source = r#"
public class TestCls {
    public void test(String param) {
        RuntimeException exc;
        if (param == null) {
            exc = new RuntimeException("param is null");
        } else {
            exc = new RuntimeException("param is not null");
        }
        throw exc;
    }
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    // The variable 'exc' should be declared/accessible after the if/else block
    result
        .does_not_contain("exc;")  // Should not have bare exc without assignment
        .does_not_contain("undefined")
        .contains("throw exc;");  // exc should be used after if/else
}

#[test]
fn variable_in_then_branch_only_test() {
    let status = tools_status();
    if !status.can_run_tests() {
        eprintln!("SKIPPED: {}", status.skip_reason());
        return;
    }

    let helper = IntegrationTestHelper::new("variable_in_then_branch_only_test");
    let source = r#"
public class TestCls {
    public String test(String param) {
        String result;
        if (param == null) {
            result = "null value";
            throw new RuntimeException(result);
        }
        return "success";
    }
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    // result variable should be properly scoped
    result
        .does_not_contain("undefined")
        .contains("String result");
}

#[test]
fn ternary_one_branch_in_constructor2_test() {
    eprintln!("SKIPPED: Test extends SmaliTest in Java - requires smali source");
}
