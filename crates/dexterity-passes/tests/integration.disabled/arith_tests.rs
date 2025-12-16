//! Arith integration tests
//! Ported from jadx-core/src/test/java/jadx/tests/integration/arith/

mod integration_test_framework;
use integration_test_framework::{IntegrationTestHelper, CodeAssertions};

#[test]
fn arith_test() {
    let helper = IntegrationTestHelper::new("arith_test");
    let source = r#"
public class TestCls {
public static final int F = 7;
public int test(int a) {
a += 2;
use(a);
return a;
}
public int test2(int a) {
a++;
private static void use(int i) {
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    // TODO: Add assertions
}

#[test]
fn arith_test_no_debug() {
    let helper = IntegrationTestHelper::new("arith_test_no_debug");
    let source = r#"
public class TestCls {
public static final int F = 7;
public int test(int a) {
a += 2;
use(a);
return a;
}
public int test2(int a) {
a++;
private static void use(int i) {
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    // TODO: Add assertions
}

#[test]
fn arith2_test() {
    let helper = IntegrationTestHelper::new("arith2_test");
    let source = r#"
public class TestCls {
public int test1(int a) {
return (a + 2) * 3;
}
public int test2(int a, int b, int c) {
return a + b + c;
public boolean test3(boolean a, boolean b, boolean c) {
return a | b | c;
public boolean test4(boolean a, boolean b, boolean c) {
return a & b & c;
public int substract(int a, int b, int c) {
return a - (b - c);
public int divide(int a, int b, int c) {
return a / (b / c);
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .contains("return (a + 2) * 3;")
        .contains("return a + b + c;")
        .contains("return a | b | c;")
        .contains("return a & b & c;")
        .contains("return a - (b - c);")
        .contains("return a / (b / c);")
        .does_not_contain("a + 2 * 3")
        .does_not_contain("return (a + b) + c;")
        .does_not_contain("return (a | b) | c;")
        .does_not_contain("return (a & b) & c;")
        .does_not_contain("return a - b - c;")
        .does_not_contain("return a / b / c;");
}

#[test]
fn arith3_test() {
    let helper = IntegrationTestHelper::new("arith3_test");
    let source = r#"
public class TestCls {
public int vp;
public void test(byte[] buffer) {
int n = ((buffer[3] & 255) + 4) + ((buffer[2] & 15) << 8);
while (n + 4 < buffer.length) {
int p = (buffer[n + 2] & 255) + ((buffer[n + 1] & 31) << 8);
int len = (buffer[n + 4] & 255) + ((buffer[n + 3] & 15) << 8);
int c = buffer[n] & 255;
switch (c) {
case 27:
this.vp = p;
break;
}
n += len + 5;
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    // TODO: Add assertions
}

#[test]
fn arith3_test_no_debug() {
    let helper = IntegrationTestHelper::new("arith3_test_no_debug");
    let source = r#"
public class TestCls {
public int vp;
public void test(byte[] buffer) {
int n = ((buffer[3] & 255) + 4) + ((buffer[2] & 15) << 8);
while (n + 4 < buffer.length) {
int p = (buffer[n + 2] & 255) + ((buffer[n + 1] & 31) << 8);
int len = (buffer[n + 4] & 255) + ((buffer[n + 3] & 15) << 8);
int c = buffer[n] & 255;
switch (c) {
case 27:
this.vp = p;
break;
}
n += len + 5;
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .contains_one("while (");
}

#[test]
fn arith4_test() {
    let helper = IntegrationTestHelper::new("arith4_test");
    let source = r#"
public class TestCls {
public static byte test(byte b) {
int k = b & 7;
return (byte) (((b & 255) >>> (8 - k)) | (b << k));
}
public static int test2(String str) {
int k = 'a' | str.charAt(0);
return (1 - k) & (1 + k);
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .contains_one("int k = b & 7;")
        .contains_one("& 255");
}

#[test]
fn arith4_test_no_debug() {
    let helper = IntegrationTestHelper::new("arith4_test_no_debug");
    let source = r#"
public class TestCls {
public static byte test(byte b) {
int k = b & 7;
return (byte) (((b & 255) >>> (8 - k)) | (b << k));
}
public static int test2(String str) {
int k = 'a' | str.charAt(0);
return (1 - k) & (1 + k);
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .contains_one("& 255");
}

#[test]
fn arith_const_test() {
    let helper = IntegrationTestHelper::new("arith_const_test");
    // TODO: Extract test source
    let source = r#"
public class TestCls {
    // Add test code here
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .contains_one("return i + CONST_INT;");
}

#[test]
fn arith_not_test() {
    let helper = IntegrationTestHelper::new("arith_not_test");
    let source = r#"
public class TestCls {
public int test1(int a) {
return ~a;
}
public long test2(long b) {
return ~b;
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .contains("return ~a;")
        .contains("return ~b;")
        .does_not_contain("^");
}

#[test]
fn field_increment_test() {
    let helper = IntegrationTestHelper::new("field_increment_test");
    let source = r#"
public class TestCls {
public int instanceField = 1;
public static int staticField = 1;
public static String result = "";
public void method() {
instanceField++;
}
public void method2() {
staticField--;
public void method3(String s) {
result += s + '_';
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .contains("instanceField++;")
        .contains("staticField--;")
        .contains("result += s + '_';");
}

#[test]
fn field_increment2_test() {
    let helper = IntegrationTestHelper::new("field_increment2_test");
    let source = r#"
public class TestCls {
int f = 5;
}
public A a;
public void test1(int n) {
this.a.f = this.a.f + n;
public void test2(int n) {
this.a.f *= n;
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .contains("this.a.f += n;")
        .contains("this.a.f *= n;");
}

#[test]
fn field_increment3_test() {
    let helper = IntegrationTestHelper::new("field_increment3_test");
    let source = r#"
public class TestCls {
static int tileX;
static int tileY;
static Vector2 targetPos = new Vector2();
static Vector2 directVect = new Vector2();
static Vector2 newPos = new Vector2();
public static void test() {
Random rd = new Random();
int direction = rd.nextInt(7);
switch (direction) {
case 0:
targetPos.x = ((tileX + 1) * 55) + 55;
targetPos.y = ((tileY + 1) * 35) + 35;
break;
case 2:
targetPos.y = ((tileY - 1) * 35) + 35;
case 4:
targetPos.x = ((tileX - 1) * 55) + 55;
case 6:
default:
}
directVect.x = targetPos.x - newPos.x;
directVect.y = targetPos.y - newPos.y;
float hPos = (float) Math.sqrt((directVect.x * directVect.x) + (directVect.y * directVect.y));
directVect.x /= hPos;
directVect.y /= hPos;
static class Vector2 {
public float x;
public float y;
public Vector2() {
this.x = 0.0f;
this.y = 0.0f;
public boolean equals(Vector2 other) {
return (this.x == other.x && this.y == other.y);
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .contains("directVect.x = targetPos.x - newPos.x;");
}

#[test]
fn numbers_format_test() {
    let helper = IntegrationTestHelper::new("numbers_format_test");
    let source = r#"
public class TestCls {
private Object obj;
public void test() {
obj = new byte[] { 0, -1, -0xA, (byte) 0xff, Byte.MIN_VALUE, Byte.MAX_VALUE };
obj = new short[] { 0, -1, -0xA, (short) 0xffff, Short.MIN_VALUE, Short.MAX_VALUE };
obj = new int[] { 0, -1, -0xA, 0xffff_ffff, Integer.MIN_VALUE, Integer.MAX_VALUE };
obj = new long[] { 0, -1, -0xA, 0xffff_ffff_ffff_ffffL, Long.MIN_VALUE, Long.MAX_VALUE };
}
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .contains_one("new byte[]{0, -1, -10, -1, -128, 127}")
        .contains_one("new short[]{0, -1, -10, -1, Short.MIN_VALUE, Short.MAX_VALUE}")
        .contains_one("new int[]{0, -1, -10, -1, Integer.MIN_VALUE, Integer.MAX_VALUE}")
        .contains_one("new long[]{0, -1, -10, -1, Long.MIN_VALUE, Long.MAX_VALUE}");
}

#[test]
fn numbers_format_test_decimal_format() {
    let helper = IntegrationTestHelper::new("numbers_format_test_decimal_format");
    let source = r#"
public class TestCls {
private Object obj;
public void test() {
obj = new byte[] { 0, -1, -0xA, (byte) 0xff, Byte.MIN_VALUE, Byte.MAX_VALUE };
obj = new short[] { 0, -1, -0xA, (short) 0xffff, Short.MIN_VALUE, Short.MAX_VALUE };
obj = new int[] { 0, -1, -0xA, 0xffff_ffff, Integer.MIN_VALUE, Integer.MAX_VALUE };
obj = new long[] { 0, -1, -0xA, 0xffff_ffff_ffff_ffffL, Long.MIN_VALUE, Long.MAX_VALUE };
}
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .contains_one("new byte[]{0, -1, -10, -1, -128, 127}")
        .contains_one("new short[]{0, -1, -10, -1, -32768, 32767}")
        .contains_one("new int[]{0, -1, -10, -1, -2147483648, 2147483647}")
        .contains_one("new long[]{0, -1, -10, -1, -9223372036854775808L, 9223372036854775807L}");
}

#[test]
fn numbers_format_test_hex_format() {
    let helper = IntegrationTestHelper::new("numbers_format_test_hex_format");
    let source = r#"
public class TestCls {
private Object obj;
public void test() {
obj = new byte[] { 0, -1, -0xA, (byte) 0xff, Byte.MIN_VALUE, Byte.MAX_VALUE };
obj = new short[] { 0, -1, -0xA, (short) 0xffff, Short.MIN_VALUE, Short.MAX_VALUE };
obj = new int[] { 0, -1, -0xA, 0xffff_ffff, Integer.MIN_VALUE, Integer.MAX_VALUE };
obj = new long[] { 0, -1, -0xA, 0xffff_ffff_ffff_ffffL, Long.MIN_VALUE, Long.MAX_VALUE };
}
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .contains_one("new byte[]{0x0, (byte) 0xff, (byte) 0xf6, (byte) 0xff, (byte) 0x80, 0x7f}")
        .contains_one("new short[]{0x0, (short) 0xffff, (short) 0xfff6, (short) 0xffff, (short) 0x8000, 0x7fff}")
        .contains_one("new int[]{0x0, (int) 0xffffffff, (int) 0xfffffff6, (int) 0xffffffff, (int) 0x80000000, 0x7fffffff}");
}

#[test]
fn special_values_test() {
    let helper = IntegrationTestHelper::new("special_values_test");
    let source = r#"
public class TestCls {
public void test() {
shorts(Short.MIN_VALUE, Short.MAX_VALUE);
ints(Integer.MIN_VALUE, Integer.MAX_VALUE);
longs(Long.MIN_VALUE, Long.MAX_VALUE);
floats(Float.NaN, Float.NEGATIVE_INFINITY, Float.POSITIVE_INFINITY,
Float.MIN_VALUE, Float.MAX_VALUE, Float.MIN_NORMAL);
doubles(Double.NaN, Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY,
Double.MIN_VALUE, Double.MAX_VALUE, Double.MIN_NORMAL);
}
private void shorts(short... v) {
private void ints(int... v) {
private void longs(long... v) {
private void floats(float... v) {
private void doubles(double... v) {
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .contains_one("Short.MIN_VALUE, Short.MAX_VALUE")
        .contains_one("Integer.MIN_VALUE, Integer.MAX_VALUE")
        .contains_one("Long.MIN_VALUE, Long.MAX_VALUE");
}

#[test]
fn special_values2_test() {
    let helper = IntegrationTestHelper::new("special_values2_test");
    let source = r#"
public class TestCls {
private static int compareUnsigned(final int x, final int y) {
return Integer.compare(x + Integer.MIN_VALUE, y + Integer.MIN_VALUE);
}
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .count_string(2, "Integer.MIN_VALUE");
}

#[test]
fn xor_test() {
    let helper = IntegrationTestHelper::new("xor_test");
    let source = r#"
public class TestCls {
public boolean test1() {
return test() ^ true;
}
public boolean test2(boolean v) {
return v ^ true;
public boolean test() {
return true;
public void check() {
assertThat(test1()).isFalse();
assertThat(test2(true)).isFalse();
assertThat(test2(false)).isTrue();
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .contains_one("return !test();")
        .contains_one("return !v;");
}

#[test]
fn xor_smali() {
    let helper = IntegrationTestHelper::new("xor_smali");
    let source = r#"
public class TestCls {
public boolean test1() {
return test() ^ true;
}
public boolean test2(boolean v) {
return v ^ true;
public boolean test() {
return true;
public void check() {
assertThat(test1()).isFalse();
assertThat(test2(true)).isFalse();
assertThat(test2(false)).isTrue();
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .contains_one("return !test();")
        .contains_one("return test();");
}
