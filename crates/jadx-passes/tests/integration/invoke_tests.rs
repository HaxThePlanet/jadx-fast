//! Invoke integration tests
//! Ported from jadx-core/src/test/java/jadx/tests/integration/invoke/

mod integration_test_framework;
use integration_test_framework::{IntegrationTestHelper, CodeAssertions};

#[test]
fn cast_in_overloaded_accessor_test() {
    let helper = IntegrationTestHelper::new("cast_in_overloaded_accessor_test");
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
fn cast_in_overloaded_invoke_test() {
    let helper = IntegrationTestHelper::new("cast_in_overloaded_invoke_test");
    let source = r#"
public class TestCls {
int c = 0;
public void test() {
call(new ArrayList<>());
call((List<String>) new ArrayList<String>());
}
public void test2(Object obj) {
if (obj instanceof String) {
call((String) obj);
public void test3() {
call((String) null);
call((List<String>) null);
call((ArrayList<String>) null);
public void call(String str) {
c += 1;
public void call(List<String> list) {
c += 10;
public void call(ArrayList<String> list) {
c += 100;
public void check() {
test();
assertThat(c).isEqualTo(10 + 100);
c = 0;
test2("str");
assertThat(c).isEqualTo(1);
test3();
assertThat(c).isEqualTo(111);
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .contains_one("call(new ArrayList<>());")
        .contains_one("call((List<String>) new ArrayList());")
        .contains_one("call((String) obj);");
}

#[test]
fn cast_in_overloaded_invoke_test_n_y_i() {
    let helper = IntegrationTestHelper::new("cast_in_overloaded_invoke_test_n_y_i");
    let source = r#"
public class TestCls {
int c = 0;
public void test() {
call(new ArrayList<>());
call((List<String>) new ArrayList<String>());
}
public void test2(Object obj) {
if (obj instanceof String) {
call((String) obj);
public void test3() {
call((String) null);
call((List<String>) null);
call((ArrayList<String>) null);
public void call(String str) {
c += 1;
public void call(List<String> list) {
c += 10;
public void call(ArrayList<String> list) {
c += 100;
public void check() {
test();
assertThat(c).isEqualTo(10 + 100);
c = 0;
test2("str");
assertThat(c).isEqualTo(1);
test3();
assertThat(c).isEqualTo(111);
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .contains_one("call((List<String>) new ArrayList<String>());");
}

#[test]
fn cast_in_overloaded_invoke2_test() {
    let helper = IntegrationTestHelper::new("cast_in_overloaded_invoke2_test");
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
fn cast_in_overloaded_invoke3_test() {
    let helper = IntegrationTestHelper::new("cast_in_overloaded_invoke3_test");
    let source = r#"
public class TestCls {
public void test() {
OuterCls.call((String) null);
}
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .contains_one("OuterCls.call((String) null);");
}

#[test]
fn cast_in_overloaded_invoke4_test() {
    let helper = IntegrationTestHelper::new("cast_in_overloaded_invoke4_test");
    let source = r#"
public class TestCls {
public String test(String str) {
return str.replace('\n', ' ');
}
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .contains_one("return str.replace('\\\\n', ' ');");
}

#[test]
fn constructor_with_moves_test() {
    let helper = IntegrationTestHelper::new("constructor_with_moves_test");
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
fn hierarchy_overloaded_invoke_test() {
    let helper = IntegrationTestHelper::new("hierarchy_overloaded_invoke_test");
    let source = r#"
public class TestCls {
static int c = 0;
B b = new B();
public interface I {
default void call(String str) {
c += 1;
}
public void call(List<String> list) {
c += 10;
public void call(ArrayList<String> list) {
c += 100;
public void test() {
b.call(new ArrayList<>());
b.call((List<String>) new ArrayList<String>());
public void test2(Object obj) {
if (obj instanceof String) {
b.call((String) obj);
public void test3() {
b.call((String) null);
b.call((List<String>) null);
b.call((ArrayList<String>) null);
public void test4() {
((I) b).call(null);
((A) b).call((String) null);
((A) b).call((List<String>) null);
public void check() {
test();
assertThat(c).isEqualTo(10 + 100);
c = 0;
test2("str");
assertThat(c).isEqualTo(1);
test3();
assertThat(c).isEqualTo(111);
test4();
assertThat(c).isEqualTo(12);
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .contains_one("b.call(new ArrayList<>());")
        .contains_one("b.call((List<String>) new ArrayList());")
        .contains_one("b.call((String) obj);");
}

#[test]
fn inherited_static_invoke_test() {
    let helper = IntegrationTestHelper::new("inherited_static_invoke_test");
    let source = r#"
public class TestCls {
public static int a() {
return 1;
}
public int test() {
return B.a(); // not A.a()
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .contains_one("return B.a();");
}

#[test]
fn invoke1_test() {
    let helper = IntegrationTestHelper::new("invoke1_test");
    let source = r#"
public class TestCls {
private A is;
public C test(int start) throws IOException {
int id = is.readInt32();
String name = is.readString16Fixed(128);
long typeStringsOffset = start + is.readInt32();
long keyStringsOffset = start + is.readInt32();
String[] types = null;
if (typeStringsOffset != 0) {
types = strs();
}
String[] keys = null;
if (keyStringsOffset != 0) {
keys = strs();
C pkg = new C(id, name, types, keys);
if (id == 0x7F) {
is.readInt32();
return pkg;
private String[] strs() {
return new String[0];
private static final class C {
public C(int id, String name, String[] types, String[] keys) {
private final class A {
public int readInt32() {
return 0;
public String readString16Fixed(int i) {
return null;
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .contains_one("C pkg = new C(id, name, types, keys);");
}

#[test]
fn invoke_in_catch_test() {
    let helper = IntegrationTestHelper::new("invoke_in_catch_test");
    let source = r#"
public class TestCls {
private static final String TAG = "TAG";
public void test(int[] a, int b) {
try {
exc();
} catch (IOException e) {
if (b == 1) {
log(TAG, "Error: {}", e.getMessage());
}
private static void log(String tag, String str, String... args) {
private void exc() throws IOException {
throw new IOException();
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    // TODO: Add assertions
}

#[test]
fn invoke_with_wide_vars_test() {
    let helper = IntegrationTestHelper::new("invoke_with_wide_vars_test");
    let source = r#"
public class TestCls {
public long test1() {
return call(1, 2L);
}
public long test2() {
return rangeCall(1L, 2, 3.0d, (byte) 4);
private long call(int a, long b) {
return 0L;
private long rangeCall(long a, int b, double c, byte d) {
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .contains_one("return call(1, 2L);")
        .contains_one("return rangeCall(1L, 2, 3.0d, (byte) 4);");
}

#[test]
fn overloaded_method_invoke_test() {
    let helper = IntegrationTestHelper::new("overloaded_method_invoke_test");
    let source = r#"
public class TestCls {
int c;
public void method(Throwable th, int a) {
c++;
if (th != null) {
c += 100;
}
c += a;
public void method(Exception e, int a) {
c += 1000;
if (e != null) {
c += 10000;
public void test(Throwable th, Exception e) {
method(e, 10);
method(th, 100);
method((Throwable) e, 1000);
method((Exception) th, 10000);
public void check() {
test(null, new Exception());
assertThat(c).isEqualTo(23212);
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .contains_one("public void test(Throwable th, Exception e) {")
        .contains_one("method(e, 10);")
        .contains_one("method(th, 100);")
        .contains_one("method((Throwable) e, 1000);")
        .contains_one("method((Exception) th, 10000);")
        .does_not_contain("(Exception) e");
}

#[test]
fn overloaded_method_invoke2_test() {
    let helper = IntegrationTestHelper::new("overloaded_method_invoke2_test");
    // TODO: Extract test source
    let source = r#"
public class TestCls {
    // Add test code here
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .contains_one("c.add(i);")
        .does_not_contain("(Container)");
}

#[test]
fn polymorphic_invoke_test_smali() {
    let helper = IntegrationTestHelper::new("polymorphic_invoke_test_smali");
    let source = r#"
public class TestCls {
public String func(int a, int c) {
return String.valueOf(a + c);
}
public String test() {
try {
MethodType methodType = MethodType.methodType(String.class, Integer.TYPE, Integer.TYPE);
MethodHandle methodHandle = MethodHandles.lookup().findVirtual(TestCls.class, "func", methodType);
return (String) methodHandle.invoke(this, 1, 2);
} catch (Throwable e) {
fail("", e);
return null;
public void check() {
assertThat(test()).isEqualTo("3");
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .contains_one("String ret = (String) methodHandle.invoke(this, 10, 20);");
}

#[test]
fn raw_custom_invoke_test() {
    let helper = IntegrationTestHelper::new("raw_custom_invoke_test");
    let source = r#"
public class TestCls {
public static String func(int a, double b) {
return String.valueOf(a + b);
}
private static CallSite staticBootstrap(MethodHandles.Lookup lookup, String name, MethodType type) {
try {
return new ConstantCallSite(lookup.findStatic(lookup.lookupClass(), name, type));
} catch (NoSuchMethodException | IllegalAccessException e) {
throw new RuntimeException(e);
public String test() {
return (String) staticBootstrap(MethodHandles.lookup(), "func",
MethodType.methodType(String.class, Integer.TYPE, Double.TYPE))
.dynamicInvoker().invoke(1, 2.0d);
} catch (Throwable e) {
fail("", e);
return null;
public void check() {
assertThat(test()).isEqualTo("3.0");
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    // TODO: Add assertions
}

#[test]
fn raw_custom_invoke_test_smali() {
    let helper = IntegrationTestHelper::new("raw_custom_invoke_test_smali");
    let source = r#"
public class TestCls {
public static String func(int a, double b) {
return String.valueOf(a + b);
}
private static CallSite staticBootstrap(MethodHandles.Lookup lookup, String name, MethodType type) {
try {
return new ConstantCallSite(lookup.findStatic(lookup.lookupClass(), name, type));
} catch (NoSuchMethodException | IllegalAccessException e) {
throw new RuntimeException(e);
public String test() {
return (String) staticBootstrap(MethodHandles.lookup(), "func",
MethodType.methodType(String.class, Integer.TYPE, Double.TYPE))
.dynamicInvoker().invoke(1, 2.0d);
} catch (Throwable e) {
fail("", e);
return null;
public void check() {
assertThat(test()).isEqualTo("3.0");
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    // TODO: Add assertions
}

#[test]
fn super_invoke_test() {
    let helper = IntegrationTestHelper::new("super_invoke_test");
    // TODO: Extract test source
    let source = r#"
public class TestCls {
    // Add test code here
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .count_string(2, "return super.a() + 2;");
}

#[test]
fn super_invoke_unknown_test() {
    let helper = IntegrationTestHelper::new("super_invoke_unknown_test");
    let source = r#"
public class TestCls {
public int doSomething() {
return 0;
}
@Override
return super.doSomething();
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .contains_one("return super.doSomething();");
}

#[test]
fn super_invoke_unknown_test_top_cls() {
    let helper = IntegrationTestHelper::new("super_invoke_unknown_test_top_cls");
    let source = r#"
public class TestCls {
public int doSomething() {
return 0;
}
@Override
return super.doSomething();
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .contains_one("return super.doSomething();");
}

#[test]
fn super_invoke_with_generics_test() {
    let helper = IntegrationTestHelper::new("super_invoke_with_generics_test");
    let source = r#"
public class TestCls {
public A(T t) {
System.out.println("t" + t);
}
public A(V v) {
System.out.println("v" + v);
public B(String s) {
super(s);
public B(Exception e) {
super(e);
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .contains_one("super(e);")
        .contains_one("super(s);");
}

#[test]
fn var_arg_test() {
    let helper = IntegrationTestHelper::new("var_arg_test");
    let source = r#"
public class TestCls {
public void test1(int... a) {
}
public void test2(int i, Object... a) {
public void test3(int[] a) {
public void call() {
test1(1, 2);
test2(3, "1", 7);
test3(new int[] { 5, 8 });
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    // TODO: Add assertions
}

#[test]
fn var_arg2_test() {
    let helper = IntegrationTestHelper::new("var_arg2_test");
    let source = r#"
public class TestCls {
protected static boolean b1;
protected static final boolean IS_VALID = b1 && isValid("test");
private static boolean isValid(String... string) {
return false;
}
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    // TODO: Add assertions
}
