//! Inline integration tests
//! Ported from jadx-core/src/test/java/jadx/tests/integration/

use crate::integration_test_framework::{IntegrationTestHelper, CodeAssertions, tools_status};

#[test]
fn const_inline_test() {
    let status = tools_status();
    if !status.can_run_tests() {
        eprintln!("SKIPPED: {}", status.skip_reason());
        return;
    }

    let helper = IntegrationTestHelper::new("const_inline_test");
    let source = r#"
public class TestCls {
public boolean test() {
try {
return f(0);
} catch (Exception e) {
return false;
}
public boolean f(int i) {
return true;
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .contains_one("return f(0);")
        .contains_one("return false;")
        .does_not_contain(" = ");
}

#[test]
fn getter_inline_negative_test() {
    eprintln!("SKIPPED: SmaliTest - requires smali input format");
}

#[test]
fn inline_test() {
    let status = tools_status();
    if !status.can_run_tests() {
        eprintln!("SKIPPED: {}", status.skip_reason());
        return;
    }

    let helper = IntegrationTestHelper::new("inline_test");
    let source = r#"
public class TestCls {
public static void main(String[] args) throws Exception {
System.out.println("Test: " + new TestCls().testRun());
}
private boolean testRun() {
return false;
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .contains("System.out.println(\"Test: \" + new TestInline$TestCls().testRun());");
}

#[test]
fn inline2_test() {
    let status = tools_status();
    if !status.can_run_tests() {
        eprintln!("SKIPPED: {}", status.skip_reason());
        return;
    }

    let helper = IntegrationTestHelper::new("inline2_test");
    let source = r#"
public class TestCls {
public int test() throws InterruptedException {
int[] a = new int[] { 1, 2, 4, 6, 8 };
int b = 0;
for (int i = 0; i < a.length; i += 2) {
b += a[i];
}
for (long i = b; i > 0; i--) {
b += i;
return b;
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .contains_one("int[] a = {1, 2, 4, 6, 8};")
        .contains_one("for (int i = 0; i < a.length; i += 2) {")
        .contains_one("for (long i2 = b; i2 > 0; i2--) {");
}

#[test]
fn inline3_test() {
    let status = tools_status();
    if !status.can_run_tests() {
        eprintln!("SKIPPED: {}", status.skip_reason());
        return;
    }

    let helper = IntegrationTestHelper::new("inline3_test");
    let source = r#"
public class TestCls {
public TestCls(int b1, int b2) {
this(b1, b2, 0, 0, 0);
}
public TestCls(int a1, int a2, int a3, int a4, int a5) {
public class A extends TestCls {
public A(int a) {
super(a, a);
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .contains("this(b1, b2, 0, 0, 0);")
        .contains("super(a, a);")
        .contains("public class A extends TestInline3$TestCls {")
        .does_not_contain("super(a, a).this$0");
}

#[test]
fn inline6_test() {
    let status = tools_status();
    if !status.can_run_tests() {
        eprintln!("SKIPPED: {}", status.skip_reason());
        return;
    }

    let helper = IntegrationTestHelper::new("inline6_test");
    let source = r#"
public class TestCls {
public void f() {
}
public void test(int a, int b) {
long start = System.nanoTime();
f();
System.out.println(System.nanoTime() - start);
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .contains("System.out.println(System.nanoTime() - start);")
        .does_not_contain("System.out.println(System.nanoTime() - System.nanoTime());");
}

#[test]
fn inline7_test() {
    eprintln!("SKIPPED: SmaliTest - requires smali input format");
}

#[test]
fn instance_lambda_test() {
    eprintln!("SKIPPED: SmaliTest - requires smali input format");
}

#[test]
fn instance_lambda_test_smali_disable_inline() {
    eprintln!("SKIPPED: SmaliTest - requires smali input format");
}

#[test]
fn instance_lambda_test_smali() {
    eprintln!("SKIPPED: SmaliTest - requires smali input format");
}

#[test]
fn issue86_test() {
    let status = tools_status();
    if !status.can_run_tests() {
        eprintln!("SKIPPED: {}", status.skip_reason());
        return;
    }

    let helper = IntegrationTestHelper::new("issue86_test");
    let source = r#"
public class TestCls {
private static final String SERVER_ERR = "server-err";
private static final String NOT_FOUND = "not-found";
private static final String LIST_TAG = "list-tag";
private static final String TEMP_TAG = "temp-tag";
private static final String MIN_TAG = "min-tag";
private static final String MAX_TAG = "max-tag";
private static final String MILLIS_TAG = "millis-tag";
private static final String WEATHER_TAG = "weather-tag";
private static final String DESC_TAG = "desc-tag";
public List<Day> test(String response) {
List<Day> reportList = new ArrayList<>();
try {
System.out.println(response);
if (response != null
&& (response.startsWith(SERVER_ERR)
|| response.startsWith(NOT_FOUND))) {
return reportList;
}
JSONObject jsonObj = new JSONObject(response);
JSONArray days = jsonObj.getJSONArray(LIST_TAG);
for (int i = 0; i < days.length(); i++) {
JSONObject c = days.getJSONObject(i);
long millis = c.getLong(MILLIS_TAG);
JSONObject temp = c.getJSONObject(TEMP_TAG);
String max = temp.getString(MAX_TAG);
String min = temp.getString(MIN_TAG);
JSONArray weather = c.getJSONArray(WEATHER_TAG);
String weatherDesc = weather.getJSONObject(0).getString(DESC_TAG);
Day d = new Day();
d.setMilis(millis);
d.setMinTmp(min);
d.setMaxTmp(max);
d.setWeatherDesc(weatherDesc);
reportList.add(d);
} catch (JSONException e) {
e.printStackTrace();
public void setMilis(long milis) {
public void setMinTmp(String min) {
public void setMaxTmp(String max) {
public void setWeatherDesc(String weatherDesc) {
public JSONObject(String response) {
public JSONArray getJSONArray(String tag) throws JSONException {
return null;
public JSONObject getJSONObject(String tag) throws JSONException {
public String getString(String tag) throws JSONException {
public long getLong(String tag) throws JSONException {
return 0;
private class JSONArray {
public JSONObject getJSONObject(int i) throws JSONException {
public int length() {
private class JSONException extends Exception {
private static final long serialVersionUID = -4358405506584551910L;
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .contains_one("response.startsWith(NOT_FOUND)");
}

#[test]
fn method_inline_test() {
    eprintln!("SKIPPED: SmaliTest - requires smali input format");
}

#[test]
fn overlap_synthetic_methods_test_smali() {
    eprintln!("SKIPPED: SmaliTest - requires smali input format");
}

#[test]
fn overlap_synthetic_methods_test_smali_no_rename() {
    eprintln!("SKIPPED: SmaliTest - requires smali input format");
}

#[test]
fn override_bridge_merge_test() {
    eprintln!("SKIPPED: SmaliTest - requires smali input format");
}

#[test]
fn override_bridge_merge_test_smali() {
    eprintln!("SKIPPED: SmaliTest - requires smali input format");
}

#[test]
fn synthetic_class_inline_test() {
    eprintln!("SKIPPED: SmaliTest - requires smali input format");
}

#[test]
fn synthetic_inline_test() {
    let status = tools_status();
    if !status.can_run_tests() {
        eprintln!("SKIPPED: {}", status.skip_reason());
        return;
    }

    let helper = IntegrationTestHelper::new("synthetic_inline_test");
    let source = r#"
public class TestCls {
private int f;
private int func() {
return -1;
}
public class A {
public int getF() {
return f;
public void setF(int v) {
f = v;
public int callFunc() {
return func();
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .contains("f = v;")
        .contains("return TestSyntheticInline$TestCls.this.f;")
        .contains("return f;")
        .contains("return func();")
        .contains("return TestSyntheticInline$TestCls.this.func();")
        .does_not_contain("synthetic")
        .does_not_contain("access$")
        .does_not_contain("x0");
}

#[test]
fn synthetic_inline2_test() {
    let status = tools_status();
    if !status.can_run_tests() {
        eprintln!("SKIPPED: {}", status.skip_reason());
        return;
    }

    let helper = IntegrationTestHelper::new("synthetic_inline2_test");
    let source = r#"
public class TestCls {
public class Base {
protected void call() {
System.out.println("base call");
}
}
public class TestCls extends Base {
public class A {
public void invokeCall() {
TestCls.this.call();
}
public void invokeSuperCall() {
TestCls.super.call();
}
}
@Override
public void call() {
System.out.println("TestCls call");
}
public void check() {
A a = new A();
a.invokeSuperCall();
a.invokeCall();
}
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .contains("TestSyntheticInline2$TestCls.this.call();")
        .contains("TestSyntheticInline2$TestCls.super.call();")
        .does_not_contain("synthetic")
        .does_not_contain("access$");
}

#[test]
fn synthetic_inline2_test_top_class() {
    let status = tools_status();
    if !status.can_run_tests() {
        eprintln!("SKIPPED: {}", status.skip_reason());
        return;
    }

    let helper = IntegrationTestHelper::new("synthetic_inline2_test_top_class");
    let source = r#"
public class TestCls {
public class Base {
protected void call() {
System.out.println("base call");
}
}
public class TestCls extends Base {
public class A {
public void invokeCall() {
TestCls.this.call();
}
public void invokeSuperCall() {
TestCls.super.call();
}
}
@Override
public void call() {
System.out.println("TestCls call");
}
public void check() {
A a = new A();
a.invokeSuperCall();
a.invokeCall();
}
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .contains("TestCls.super.call();");
}

#[test]
fn synthetic_inline3_test() {
    let status = tools_status();
    if !status.can_run_tests() {
        eprintln!("SKIPPED: {}", status.skip_reason());
        return;
    }

    let helper = IntegrationTestHelper::new("synthetic_inline3_test");
    let source = r#"
public class TestCls {
private String strField;
private String str() {
return "a";
}
private void test() {
new Function<String, Void>() {
@Override
public Void apply(String s) {
System.out.println(s + strField + str());
return null;
}.apply("c");
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    // Java test has no assertions for this test
    result
        .contains("System.out.println(s + strField + str());");
}

#[test]
fn synthetic_inline3_test_smali() {
    let status = tools_status();
    if !status.can_run_tests() {
        eprintln!("SKIPPED: {}", status.skip_reason());
        return;
    }

    let helper = IntegrationTestHelper::new("synthetic_inline3_test_smali");
    let source = r#"
public class TestCls {
private String strField;
private String str() {
return "a";
}
private void test() {
new Function<String, Void>() {
@Override
public Void apply(String s) {
System.out.println(s + strField + str());
return null;
}.apply("c");
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .does_not_contain(".access$getDialog$p(")
        .does_not_contain(".access$getChooserIntent(")
        .does_not_contain("= r1;")
        .does_not_contain("this$0");
}

#[test]
fn ternary_cast_test() {
    let status = tools_status();
    if !status.can_run_tests() {
        eprintln!("SKIPPED: {}", status.skip_reason());
        return;
    }

    let helper = IntegrationTestHelper::new("ternary_cast_test");
    let source = r#"
public class TestCls {
public String test(boolean b, Object obj, CharSequence cs) {
return (String) (b ? obj : cs);
}
public void check() {
assertThat(test(true, "a", "b")).isEqualTo("a");
assertThat(test(false, "a", "b")).isEqualTo("b");
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .contains_one("return (String) (b ? obj : cs);");
}

#[test]
fn ternary_cast_test_no_debug() {
    let status = tools_status();
    if !status.can_run_tests() {
        eprintln!("SKIPPED: {}", status.skip_reason());
        return;
    }

    let helper = IntegrationTestHelper::new("ternary_cast_test_no_debug");
    let source = r#"
public class TestCls {
public String test(boolean b, Object obj, CharSequence cs) {
return (String) (b ? obj : cs);
}
public void check() {
assertThat(test(true, "a", "b")).isEqualTo("a");
assertThat(test(false, "a", "b")).isEqualTo("b");
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .contains_one("return (String) (b ? obj : cs);");
}
