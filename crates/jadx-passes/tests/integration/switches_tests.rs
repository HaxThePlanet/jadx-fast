//! Switches integration tests
//! Ported from jadx-core/src/test/java/jadx/tests/integration/switches/

mod integration_test_framework;
use integration_test_framework::{IntegrationTestHelper, CodeAssertions};

#[test]
fn switch_test() {
    let helper = IntegrationTestHelper::new("switch_test");
    let source = r#"
public class TestCls {
public String test(String str) {
int len = str.length();
StringBuilder sb = new StringBuilder(len);
for (int i = 0; i < len; i++) {
char c = str.charAt(i);
switch (c) {
case '.':
case '/':
sb.append('_');
break;
case ']':
sb.append('A');
case '?':
default:
sb.append(c);
}
return sb.toString();
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .contains("case '/':")
        .contains_one("i++")
        .count_string(4, "break;");
}

#[test]
fn switch2_test() {
    let helper = IntegrationTestHelper::new("switch2_test");
    let source = r#"
public class TestCls {
boolean isLongtouchable;
boolean isMultiTouchZoom;
boolean isCanZoomIn;
boolean isCanZoomOut;
boolean isScrolling;
float multiTouchZoomOldDist;
public void test(int action) {
switch (action & 255) {
case 0:
this.isLongtouchable = true;
break;
case 1:
case 6:
if (this.isMultiTouchZoom) {
this.isMultiTouchZoom = false;
}
case 2:
float dist = multiTouchZoomOldDist;
if (Math.abs(dist - this.multiTouchZoomOldDist) > 10.0f) {
float scale = dist / this.multiTouchZoomOldDist;
if ((scale > 1.0f && this.isCanZoomIn) || (scale < 1.0f && this.isCanZoomOut)) {
this.multiTouchZoomOldDist = dist;
return;
case 5:
this.multiTouchZoomOldDist = action;
if (this.multiTouchZoomOldDist > 10.0f) {
this.isMultiTouchZoom = true;
this.isLongtouchable = false;
if (this.isScrolling && action == 1) {
this.isScrolling = false;
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .count_string(4, "break;")
        .count_string(2, "return;")
        .count_string(4, "return;");
}

#[test]
fn switch3_test() {
    let helper = IntegrationTestHelper::new("switch3_test");
    let source = r#"
public class TestCls {
private int i;
void test(int a) {
switch (a) {
case 1:
i = 1;
return;
case 2:
case 3:
i = 2;
default:
i = 4;
break;
}
i = 5;
public void check() {
test(1);
assertThat(i).isEqualTo(1);
test(2);
assertThat(i).isEqualTo(2);
test(3);
test(4);
assertThat(i).isEqualTo(5);
test(10);
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .count_string(3, "break;")
        .count_string(0, "return;");
}

#[test]
fn switch4_test() {
    let helper = IntegrationTestHelper::new("switch4_test");
    let source = r#"
public class TestCls {
@SuppressWarnings({ "FallThrough", "unused" })
private static int parse(char[] ch, int off, int len) {
int num = ch[off + len - 1] - '0';
switch (len) {
case 4:
num += (ch[off++] - '0') * 1000;
case 3:
num += (ch[off++] - '0') * 100;
case 2:
num += (ch[off] - '0') * 10;
}
return num;
public void check() {
assertThat(parse("123".toCharArray(), 0, 3)).isEqualTo(123);
assertThat(parse("a=1234".toCharArray(), 2, 4)).isEqualTo(1234);
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .contains_one("switch (")
        .does_not_contain("break")
        .count_string(3, "case ");
}

#[test]
fn switch_break_test() {
    let helper = IntegrationTestHelper::new("switch_break_test");
    let source = r#"
public class TestCls {
public String test(int a) {
String s = "";
loop: while (a > 0) {
switch (a % 4) {
case 1:
s += "1";
break;
case 3:
case 4:
s += "4";
case 5:
s += "+";
break loop;
}
s += "-";
a--;
return s;
public void check() {
assertThat(test(9)).isEqualTo("1--4--1--4--1-");
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .contains("switch (a % 4) {")
        .does_not_contain("default:")
        .count_string(4, "case ")
        .count_string(2, "break;");
}

#[test]
fn switch_continue_test() {
    let helper = IntegrationTestHelper::new("switch_continue_test");
    let source = r#"
public class TestCls {
public String test(int a) {
String s = "";
while (a > 0) {
switch (a % 4) {
case 1:
s += "1";
break;
case 3:
case 4:
s += "4";
case 5:
a -= 2;
continue;
}
s += "-";
a--;
return s;
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .contains("switch (a % 4) {")
        .contains_one("a -= 2;")
        .contains_one("continue;")
        .count_string(4, "case ")
        .count_string(2, "break;");
}

#[test]
fn switch_fall_through_test() {
    let helper = IntegrationTestHelper::new("switch_fall_through_test");
    let source = r#"
public class TestCls {
public int r;
@SuppressWarnings("fallthrough")
public void test(int a) {
int i = 10;
switch (a) {
case 1:
i = 1000;
// fallthrough
case 2:
r = i;
break;
default:
r = -1;
}
r *= 2;
System.out.println("in: " + a + ", out: " + r);
public int testWrap(int a) {
r = 0;
test(a);
return r;
public void check() {
assertThat(testWrap(1)).isEqualTo(2000);
assertThat(testWrap(2)).isEqualTo(20);
assertThat(testWrap(0)).isEqualTo(-2);
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .contains_one("switch (a) {")
        .contains_one("r = i;")
        .contains_one("r = -1;")
        .count_string(2, "break;");
}

#[test]
fn switch_in_loop_test() {
    let helper = IntegrationTestHelper::new("switch_in_loop_test");
    let source = r#"
public class TestCls {
public int test(int k) {
int a = 0;
while (true) {
switch (k) {
case 0:
return a;
default:
a++;
k >>= 1;
}
public void check() {
assertThat(test(1)).isEqualTo(1);
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .contains_one("switch (k) {")
        .contains_one("case 0:")
        .contains_one("return a;")
        .contains_one("default:")
        .contains_one("a++;")
        .contains_one("k >>= 1;");
}

#[test]
fn switch_in_loop2_test() {
    let helper = IntegrationTestHelper::new("switch_in_loop2_test");
    let source = r#"
public class TestCls {
public boolean test() {
while (true) {
switch (call()) {
case 0:
return false;
case 1:
return true;
}
private int call() {
return 0;
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    // TODO: Add assertions
}

#[test]
fn switch_in_loop3_test() {
    let helper = IntegrationTestHelper::new("switch_in_loop3_test");
    let source = r#"
public class TestCls {
public int test(int k) {
int a = 0;
while (true) {
int x = 0; // keep this: force to generate the necessary CFG
switch (k) {
case 0:
return a;
default:
a++;
k >>= 1;
}
public void check() {
assertThat(test(1)).isEqualTo(1);
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    // TODO: Add assertions
}

#[test]
fn switch_in_loop5_test() {
    let helper = IntegrationTestHelper::new("switch_in_loop5_test");
    let source = r#"
public class TestCls {
private static int test(int r) {
int i;
while (true) {
switch (r) {
case 42:
i = 32;
break;
case 52:
i = 42;
default:
System.out.println("Default switch case");
return 1;
}
r = i;
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .contains_one("default:")
        .contains_one("System.out.println(");
}

#[test]
fn switch_labels_test() {
    let helper = IntegrationTestHelper::new("switch_labels_test");
    let source = r#"
public class TestCls {
public static final int CONST_ABC = 0xABC;
public static final int CONST_CDE = 0xCDE;
private static final int CONST_CDE_PRIVATE = 0xCDE;
public int f1(int arg0) {
switch (arg0) {
case CONST_CDE_PRIVATE:
return CONST_ABC;
}
return 0;
public static int f1(int arg0) {
case CONST_ABC:
return CONST_CDE;
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .contains("case CONST_ABC")
        .contains("return CONST_CDE;")
        .contains(".CONST_ABC;")
        .does_not_contain("case CONST_CDE_PRIVATE");
}

#[test]
fn switch_labels_test_with_disabled_const_replace() {
    let helper = IntegrationTestHelper::new("switch_labels_test_with_disabled_const_replace");
    let source = r#"
public class TestCls {
public static final int CONST_ABC = 0xABC;
public static final int CONST_CDE = 0xCDE;
private static final int CONST_CDE_PRIVATE = 0xCDE;
public int f1(int arg0) {
switch (arg0) {
case CONST_CDE_PRIVATE:
return CONST_ABC;
}
return 0;
public static int f1(int arg0) {
case CONST_ABC:
return CONST_CDE;
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .contains("case 2748")
        .contains("return 3294;")
        .does_not_contain("case CONST_ABC")
        .does_not_contain("return CONST_CDE;")
        .does_not_contain("case CONST_CDE_PRIVATE")
        .does_not_contain(".CONST_ABC;");
}

#[test]
fn switch_no_default_test() {
    let helper = IntegrationTestHelper::new("switch_no_default_test");
    let source = r#"
public class TestCls {
public void test(int a) {
String s = null;
switch (a) {
case 1:
s = "1";
break;
case 2:
s = "2";
case 3:
s = "3";
case 4:
s = "4";
}
System.out.println(s);
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .contains_one("System.out.println(s);")
        .count_string(4, "break;");
}

#[test]
fn switch_over_strings_test() {
    let helper = IntegrationTestHelper::new("switch_over_strings_test");
    let source = r#"
public class TestCls {
public int test(String str) {
switch (str) {
case "frewhyh":
return 1;
case "phgafkp":
return 2;
case "test":
case "test2":
return 3;
case "other":
return 4;
default:
return 0;
}
public void check() {
assertThat(test("frewhyh")).isEqualTo(1);
assertThat(test("phgafkp")).isEqualTo(2);
assertThat(test("test")).isEqualTo(3);
assertThat(test("test2")).isEqualTo(3);
assertThat(test("other")).isEqualTo(4);
assertThat(test("unknown")).isEqualTo(0);
assertThat(test("ucguedt")).isEqualTo(0);
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .does_not_contain("case -603257287:")
        .does_not_contain("c = ")
        .count_string(5, "return ");
}

#[test]
fn switch_over_strings2_test() {
    let helper = IntegrationTestHelper::new("switch_over_strings2_test");
    let source = r#"
public class TestCls {
public int test(String str) {
switch (str) {
case "branch1":
case "branch2":
return 1;
case "branch3":
case "branch4":
default:
return 0;
}
public void check() {
assertThat(test("branch1")).isEqualTo(1);
assertThat(test("branch2")).isEqualTo(1);
assertThat(test("branch3")).isEqualTo(0);
assertThat(test("branch4")).isEqualTo(0);
assertThat(test("other")).isEqualTo(0);
assertThat(test("other2")).isEqualTo(0);
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .count_string(4, "case ")
        .count_string(1, "default:")
        .count_string(2, "return ");
}

#[test]
fn switch_return_from_case_test() {
    let helper = IntegrationTestHelper::new("switch_return_from_case_test");
    let source = r#"
public class TestCls {
public void test(int a) {
if (a > 1000) {
return;
}
String s = null;
switch (a % 10) {
case 1:
s = "1";
break;
case 2:
s = "2";
case 3:
case 4:
s = "4";
case 5:
case 6:
if (s == null) {
s = "5";
System.out.println(s);
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .contains("switch (a % 10) {")
        .count_string(5, "case ")
        .count_string(3, "break;");
}

#[test]
fn switch_return_from_case2_test() {
    let helper = IntegrationTestHelper::new("switch_return_from_case2_test");
    let source = r#"
public class TestCls {
public boolean test(int a) {
switch (a % 4) {
case 2:
case 3:
if (a == 2) {
return true;
}
return false;
public void check() {
assertThat(test(2)).isTrue();
assertThat(test(3)).isTrue();
assertThat(test(15)).isTrue();
assertThat(test(1)).isFalse();
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .contains("switch (a % 4) {");
}

#[test]
fn switch_simple_test() {
    let helper = IntegrationTestHelper::new("switch_simple_test");
    let source = r#"
public class TestCls {
public void test(int a) {
String s = null;
switch (a % 4) {
case 1:
s = "1";
break;
case 2:
s = "2";
case 3:
s = "3";
case 4:
s = "4";
default:
System.out.println("Not Reach");
}
System.out.println(s);
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    // TODO: Add assertions
}

#[test]
fn switch_with_fall_through_case_test() {
    let helper = IntegrationTestHelper::new("switch_with_fall_through_case_test");
    let source = r#"
public class TestCls {
public String test(int a, boolean b, boolean c) {
String str = "";
switch (a % 4) {
case 1:
str += ">";
if (a == 5 && b) {
if (c) {
str += "1";
} else {
str += "!c";
}
break;
// fallthrough
case 2:
if (b) {
str += "2";
case 3:
default:
str += "default";
str += ";";
return str;
public void check() {
assertThat(test(5, true, true)).isEqualTo(">1;");
assertThat(test(1, true, true)).isEqualTo(">2;");
assertThat(test(3, true, true)).isEqualTo(";");
assertThat(test(0, true, true)).isEqualTo("default;");
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    // TODO: Add assertions
}

#[test]
fn switch_with_fall_through_case2_test() {
    let helper = IntegrationTestHelper::new("switch_with_fall_through_case2_test");
    let source = r#"
public class TestCls {
public String test(int a, boolean b, boolean c) {
String str = "";
if (a > 0) {
switch (a % 4) {
case 1:
str += ">";
if (a == 5 && b) {
if (c) {
str += "1";
} else {
str += "!c";
}
break;
case 2:
if (b) {
str += "2";
case 3:
default:
str += "default";
str += "+";
if (b && c) {
str += "-";
return str;
public void check() {
assertThat(test(5, true, true)).isEqualTo(">1+-");
assertThat(test(1, true, true)).isEqualTo(">2+-");
assertThat(test(3, true, true)).isEqualTo("+-");
assertThat(test(16, true, true)).isEqualTo("default+-");
assertThat(test(-1, true, true)).isEqualTo("-");
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    // TODO: Add assertions
}

#[test]
fn switch_with_throw_test() {
    let helper = IntegrationTestHelper::new("switch_with_throw_test");
    let source = r#"
public class TestCls {
public int test(int i) {
if (i != 0) {
switch (i % 4) {
case 1:
throw new IllegalStateException("1");
case 2:
throw new IllegalStateException("2");
default:
throw new IllegalStateException("Other");
}
System.out.println("0");
return -1;
public void check() {
assertThat(test(0)).isEqualTo(-1);
assertThat(catchThrowable(() -> test(1)))
.isInstanceOf(IllegalStateException.class)
.hasMessageContaining("1");
assertThat(catchThrowable(() -> test(3)))
.hasMessageContaining("Other");
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    // TODO: Add assertions
}

#[test]
fn switch_with_try_catch_test() {
    let helper = IntegrationTestHelper::new("switch_with_try_catch_test");
    let source = r#"
public class TestCls {
void test(int a) {
switch (a) {
case 0:
try {
exc();
return;
} catch (Exception e) {
e.printStackTrace();
}
// no break;
case 1:
break;
case 2:
case 3:
if (a == 10) {
System.out.println(a);
private void exc() throws Exception {
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .count_string(3, "break;")
        .count_string(4, "return;");
}
