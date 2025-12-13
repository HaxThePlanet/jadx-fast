//! Annotations integration tests
//! Ported from jadx-core/src/test/java/jadx/tests/integration/annotations/

mod integration_test_framework;
use integration_test_framework::{IntegrationTestHelper, CodeAssertions};

#[test]
fn annotations_test() {
    let helper = IntegrationTestHelper::new("annotations_test");
    let source = r#"
public class TestCls {
private @interface A {
int a();
}
@A(a = -1)
public void methodA1() {
@A(a = -253)
public void methodA2() {
@A(a = -11253)
public void methodA3() {
private @interface V {
boolean value();
@V(false)
public void methodV() {
private @interface D {
float value() default 1.1f;
@D
public void methodD() {
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .contains_one("@A(a = -1)")
        .contains_one("@A(a = -253)")
        .contains_one("@A(a = -11253)")
        .contains_one("@V(false)")
        .contains_one("@D")
        .contains_one("int a();")
        .contains_one("float value() default 1.1f;")
        .does_not_contain("@A(a = 255)")
        .does_not_contain("@D()");
}

#[test]
fn annotations2_test() {
    let helper = IntegrationTestHelper::new("annotations2_test");
    let source = r#"
public class TestCls {
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface A {
int i();
float f();
}
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .contains("@Target({ElementType.TYPE})")
        .contains("@Retention(RetentionPolicy.RUNTIME)")
        .contains("public @interface A {")
        .contains("float f();")
        .contains("int i();");
}

#[test]
fn annotations_mix_test() {
    let helper = IntegrationTestHelper::new("annotations_mix_test");
    let source = r#"
public class TestCls {
public boolean test() throws Exception {
Class<?> cls = TestCls.class;
new Thread();
Method err = cls.getMethod("error");
assertThat(err.getExceptionTypes().length > 0).isTrue();
assertThat(err.getExceptionTypes()[0]).isSameAs(Exception.class);
Method d = cls.getMethod("depr", String[].class);
assertThat(d.getAnnotations().length > 0).isTrue();
assertThat(d.getAnnotations()[0].annotationType()).isSameAs(Deprecated.class);
Method ma = cls.getMethod("test", String[].class);
assertThat(ma.getAnnotations().length > 0).isTrue();
MyAnnotation a = (MyAnnotation) ma.getAnnotations()[0];
assertThat(a.num()).isEqualTo(7);
assertThat(a.state()).isSameAs(TERMINATED);
return true;
}
@Deprecated
public int a;
public void error() throws Exception {
throw new Exception("error");
public static Object depr(String[] a) {
return Arrays.asList(a);
@MyAnnotation(
name = "b",
num = 7,
cls = Exception.class,
doubles = { 0.0, 1.1 },
value = 9.87f,
simple = @SimpleAnnotation(false)
)
public static Object test(String[] a) {
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface MyAnnotation {
String name() default "a";
String str() default "str";
int num();
float value();
double[] doubles();
Class<?> cls();
SimpleAnnotation simple();
Thread.State state() default Thread.State.TERMINATED;
public @interface SimpleAnnotation {
boolean value();
public void check() throws Exception {
test();
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .does_not_contain("int i = false;");
}

#[test]
fn annotations_mix_test_no_debug() {
    let helper = IntegrationTestHelper::new("annotations_mix_test_no_debug");
    let source = r#"
public class TestCls {
public boolean test() throws Exception {
Class<?> cls = TestCls.class;
new Thread();
Method err = cls.getMethod("error");
assertThat(err.getExceptionTypes().length > 0).isTrue();
assertThat(err.getExceptionTypes()[0]).isSameAs(Exception.class);
Method d = cls.getMethod("depr", String[].class);
assertThat(d.getAnnotations().length > 0).isTrue();
assertThat(d.getAnnotations()[0].annotationType()).isSameAs(Deprecated.class);
Method ma = cls.getMethod("test", String[].class);
assertThat(ma.getAnnotations().length > 0).isTrue();
MyAnnotation a = (MyAnnotation) ma.getAnnotations()[0];
assertThat(a.num()).isEqualTo(7);
assertThat(a.state()).isSameAs(TERMINATED);
return true;
}
@Deprecated
public int a;
public void error() throws Exception {
throw new Exception("error");
public static Object depr(String[] a) {
return Arrays.asList(a);
@MyAnnotation(
name = "b",
num = 7,
cls = Exception.class,
doubles = { 0.0, 1.1 },
value = 9.87f,
simple = @SimpleAnnotation(false)
)
public static Object test(String[] a) {
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface MyAnnotation {
String name() default "a";
String str() default "str";
int num();
float value();
double[] doubles();
Class<?> cls();
SimpleAnnotation simple();
Thread.State state() default Thread.State.TERMINATED;
public @interface SimpleAnnotation {
boolean value();
public void check() throws Exception {
test();
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    // TODO: Add assertions
}

#[test]
fn annotations_mix_test_declaration() {
    let helper = IntegrationTestHelper::new("annotations_mix_test_declaration");
    let source = r#"
public class TestCls {
public boolean test() throws Exception {
Class<?> cls = TestCls.class;
new Thread();
Method err = cls.getMethod("error");
assertThat(err.getExceptionTypes().length > 0).isTrue();
assertThat(err.getExceptionTypes()[0]).isSameAs(Exception.class);
Method d = cls.getMethod("depr", String[].class);
assertThat(d.getAnnotations().length > 0).isTrue();
assertThat(d.getAnnotations()[0].annotationType()).isSameAs(Deprecated.class);
Method ma = cls.getMethod("test", String[].class);
assertThat(ma.getAnnotations().length > 0).isTrue();
MyAnnotation a = (MyAnnotation) ma.getAnnotations()[0];
assertThat(a.num()).isEqualTo(7);
assertThat(a.state()).isSameAs(TERMINATED);
return true;
}
@Deprecated
public int a;
public void error() throws Exception {
throw new Exception("error");
public static Object depr(String[] a) {
return Arrays.asList(a);
@MyAnnotation(
name = "b",
num = 7,
cls = Exception.class,
doubles = { 0.0, 1.1 },
value = 9.87f,
simple = @SimpleAnnotation(false)
)
public static Object test(String[] a) {
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface MyAnnotation {
String name() default "a";
String str() default "str";
int num();
float value();
double[] doubles();
Class<?> cls();
SimpleAnnotation simple();
Thread.State state() default Thread.State.TERMINATED;
public @interface SimpleAnnotation {
boolean value();
public void check() throws Exception {
test();
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .contains("new Thread();")
        .does_not_contain("Thread thread = new Thread();");
}

#[test]
fn annotations_rename_test() {
    let helper = IntegrationTestHelper::new("annotations_rename_test");
    let source = r#"
public class TestCls {
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface A {
int x();
}
@A(x = 5)
void test() {
public void check() throws NoSuchMethodException {
Method test = TestCls.class.getDeclaredMethod("test");
A annotation = test.getAnnotation(A.class);
assertThat(annotation.x()).isEqualTo(5);
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .contains("public @interface ")
        .does_not_contain("(x = 5)");
}

#[test]
fn annotations_rename_def_test() {
    let helper = IntegrationTestHelper::new("annotations_rename_def_test");
    let source = r#"
public class TestCls {
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface A {
int value();
}
@A(5)
void test() {
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .contains("public @interface ")
        .does_not_contain("int value();")
        .does_not_contain("(5)");
}

#[test]
fn annotations_usage_test() {
    let helper = IntegrationTestHelper::new("annotations_usage_test");
    let source = r#"
public class TestCls {
@Target({ ElementType.TYPE, ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
public @interface A {
Class<?> c();
}
@A(c = TestCls.class)
@A(c = B.class)
public String field;
void test() {
void test2(@A(c = B.class) Integer value) {
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .count_string(3, "@A(c = B.class)");
}

#[test]
fn param_annotations_test() {
    let helper = IntegrationTestHelper::new("param_annotations_test");
    let source = r#"
public class TestCls {
@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
public static @interface A {
int i() default 7;
}
void test1(@A int i) {
void test2(int i, @A int j) {
void test3(@A(i = 5) int i) {
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    // TODO: Add assertions
}
