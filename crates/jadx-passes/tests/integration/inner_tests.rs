//! Inner integration tests
//! Ported from jadx-core/src/test/java/jadx/tests/integration/inner/

mod integration_test_framework;
use integration_test_framework::{IntegrationTestHelper, CodeAssertions};

#[test]
fn anonymous_class_test() {
    let helper = IntegrationTestHelper::new("anonymous_class_test");
    let source = r#"
public class TestCls {
public int test() {
String[] files = new File("a").list(new FilenameFilter() {
@Override
public boolean accept(File dir, String name) {
return name.equals("a");
}
});
return files.length;
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .does_not_contain("synthetic")
        .does_not_contain("this")
        .does_not_contain("null")
        .does_not_contain("AnonymousClass_")
        .does_not_contain("class AnonymousClass");
}

#[test]
fn anonymous_class_test_no_inline() {
    let helper = IntegrationTestHelper::new("anonymous_class_test_no_inline");
    let source = r#"
public class TestCls {
public int test() {
String[] files = new File("a").list(new FilenameFilter() {
@Override
public boolean accept(File dir, String name) {
return name.equals("a");
}
});
return files.length;
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .contains("class AnonymousClass1 implements FilenameFilter {")
        .contains_one("new AnonymousClass1()");
}

#[test]
fn anonymous_class10_test() {
    let helper = IntegrationTestHelper::new("anonymous_class10_test");
    let source = r#"
public class TestCls {
public A test() {
Random random = new Random();
int a2 = random.nextInt();
return new A(this, a2, a2 + 3, 4, 5, random.nextDouble()) {
@Override
public void m() {
System.out.println(1);
}
};
public abstract class A {
public A(TestCls a1, int a2, int a3, int a4, int a5, double a6) {
public abstract void m();
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .contains_one("return new A(this, a2, a2 + 3, 4, 5, random.nextDouble()) {")
        .does_not_contain("synthetic");
}

#[test]
fn anonymous_class11_test() {
    let helper = IntegrationTestHelper::new("anonymous_class11_test");
    let source = r#"
public class TestCls {
public void test() {
final int a = new Random().nextInt();
final long l = new Random().nextLong();
func(new A(l) {
@Override
public void m() {
System.out.println(a);
}
});
System.out.println("a" + a);
print(a);
print2(1, a);
print3(1, l);
public abstract class A {
public A(long l) {
public abstract void m();
private void func(A a) {
private void print(int a) {
private void print2(int i, int a) {
private void print3(int i, long l) {
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .contains_one("print(a);")
        .does_not_contain("synthetic");
}

#[test]
fn anonymous_class12_test() {
    let helper = IntegrationTestHelper::new("anonymous_class12_test");
    let source = r#"
public class TestCls {
public abstract static class BasicAbstract {
public abstract void doSomething();
}
public BasicAbstract outer;
public BasicAbstract inner;
public void test() {
outer = new BasicAbstract() {
@Override
public void doSomething() {
inner = new BasicAbstract() {
inner = null;
};
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    // TODO: Add assertions
}

#[test]
fn anonymous_class13_test() {
    let helper = IntegrationTestHelper::new("anonymous_class13_test");
    let source = r#"
public class TestCls {
public void test() {
new TestCls() {
};
}
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    // TODO: Add assertions
}

#[test]
fn anonymous_class14_test() {
    let helper = IntegrationTestHelper::new("anonymous_class14_test");
    // TODO: Extract test source
    let source = r#"
public class TestCls {
    // Add test code here
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .contains_one("private TestCls(")
        .contains_one("private TestCls() {");
}

#[test]
fn anonymous_class15_test() {
    let helper = IntegrationTestHelper::new("anonymous_class15_test");
    let source = r#"
public class TestCls {
public Thread test(Runnable run) {
return new Thread(run) {
@Override
public void run() {
System.out.println("run");
super.run();
}
};
public Thread test2(Runnable run) {
{
setName("run");
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .count_string(2, "return new Thread(run) {");
}

#[test]
fn anonymous_class16_test() {
    let helper = IntegrationTestHelper::new("anonymous_class16_test");
    let source = r#"
public class TestCls {
public Something test() {
Something a = new Something() {
{
put("a", "b");
}
};
a.put("c", "d");
return a;
public class Something {
public void put(Object o, Object o2) {
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .does_not_contain("r0")
        .does_not_contain("AnonymousClass1 r0 = ");
}

#[test]
fn anonymous_class17_test() {
    let helper = IntegrationTestHelper::new("anonymous_class17_test");
    let source = r#"
public class TestCls {
@SuppressWarnings({ "checkstyle:InnerAssignment", "Convert2Lambda" })
public void test(boolean a, boolean b) {
String v;
if (a && (v = get(b)) != null) {
use(new Runnable() {
@Override
public void run() {
System.out.println(v);
}
});
public String get(boolean a) {
return a ? "str" : null;
public void use(Runnable r) {
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .contains_one("if (a && (v = get(b)) != null) {");
}

#[test]
fn anonymous_class18_test() {
    let helper = IntegrationTestHelper::new("anonymous_class18_test");
    let source = r#"
public class TestCls {
public interface Job {
void executeJob();
}
public void start() {
runJob(new Job() {
@Override
public void executeJob() {
doSomething();
});
private void doSomething() {
public static void runJob(Job job) {
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .does_not_contain("AnonymousClass1.this")
        .does_not_contain("class AnonymousClass1")
        .does_not_contain("TestAnonymousClass18$TestCls.runJob(");
}

#[test]
fn anonymous_class18_test_no_inline() {
    let helper = IntegrationTestHelper::new("anonymous_class18_test_no_inline");
    let source = r#"
public class TestCls {
public interface Job {
void executeJob();
}
public void start() {
runJob(new Job() {
@Override
public void executeJob() {
doSomething();
});
private void doSomething() {
public static void runJob(Job job) {
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    // TODO: Add assertions
}

#[test]
fn anonymous_class19_test() {
    let helper = IntegrationTestHelper::new("anonymous_class19_test");
    let source = r#"
public class TestCls {
public void test(boolean a, boolean b) {
boolean c = a && b;
use(new Runnable() {
@Override
public void run() {
System.out.println(a + " && " + b + " = " + c);
}
});
public void use(Runnable r) {
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    // TODO: Add assertions
}

#[test]
fn anonymous_class19_test_smali() {
    let helper = IntegrationTestHelper::new("anonymous_class19_test_smali");
    let source = r#"
public class TestCls {
public void test(boolean a, boolean b) {
boolean c = a && b;
use(new Runnable() {
@Override
public void run() {
System.out.println(a + " && " + b + " = " + c);
}
});
public void use(Runnable r) {
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    // TODO: Add assertions
}

#[test]
fn anonymous_class2_test() {
    let helper = IntegrationTestHelper::new("anonymous_class2_test");
    let source = r#"
public class TestCls {
public int f;
public Runnable test() {
return new Runnable() {
@Override
public void run() {
f = 1;
}
};
public Runnable test2() {
@SuppressWarnings("unused")
Object obj = Inner.this;
public Runnable test3() {
final int i = f + 2;
f = i;
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .contains("f = 1;")
        .contains("f = i;")
        .contains("Inner.this;")
        .does_not_contain("synthetic")
        .does_not_contain("AnonymousClass_")
        .does_not_contain("Inner obj = ;");
}

#[test]
fn anonymous_class20_test() {
    let helper = IntegrationTestHelper::new("anonymous_class20_test");
    // TODO: Extract test source
    let source = r#"
public class TestCls {
    // Add test code here
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .contains_one("new TestAnonymousClass20$Test$Cls();");
}

#[test]
fn anonymous_class21_test() {
    let helper = IntegrationTestHelper::new("anonymous_class21_test");
    let source = r#"
public class TestCls {
public void test() {
String str = "str";
new Thread(new Runnable() {
@Override
public void run() {
System.out.println(str);
}
}).start();
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .contains_one("System.out.println(str);");
}

#[test]
fn anonymous_class22_test() {
    let helper = IntegrationTestHelper::new("anonymous_class22_test");
    let source = r#"
public class TestCls {
public static Parent test(Class<?> cls) {
final AnotherClass another = new AnotherClass();
return new Parent() {
@Override
public String func() {
return another.toString();
}
};
return "";
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .contains_one("return another.toString();")
        .does_not_contain("AnotherClass.this");
}

#[test]
fn anonymous_class3_test() {
    let helper = IntegrationTestHelper::new("anonymous_class3_test");
    let source = r#"
public class TestCls {
private int f;
public double d;
public void test() {
new Thread() {
@Override
public void run() {
int a = f--;
p(a);
f += 2;
f *= 2;
a = ++f;
d /= 3;
}
public void p(int a) {
}.start();
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .does_not_contain("AnonymousClass_");
}

#[test]
fn anonymous_class4_test() {
    let helper = IntegrationTestHelper::new("anonymous_class4_test");
    let source = r#"
public class TestCls {
@SuppressWarnings("unused")
private int f;
private double d;
public void test() {
new Thread() {
{
f = 1;
}
@Override
public void run() {
d = 7.5;
}.start();
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .contains_one("f = 1;")
        .contains_one("d = 7.5");
}

#[test]
fn anonymous_class6_test() {
    let helper = IntegrationTestHelper::new("anonymous_class6_test");
    let source = r#"
public class TestCls {
public Runnable test(final double d) {
return new Runnable() {
public void run() {
System.out.println(d);
}
};
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    // TODO: Add assertions
}

#[test]
fn anonymous_class7_test() {
    let helper = IntegrationTestHelper::new("anonymous_class7_test");
    let source = r#"
public class TestCls {
public static Runnable test(final double d) {
return new Runnable() {
public void run() {
System.out.println(d);
}
};
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    // TODO: Add assertions
}

#[test]
fn anonymous_class8_test() {
    let helper = IntegrationTestHelper::new("anonymous_class8_test");
    let source = r#"
public class TestCls {
public final double d = Math.abs(4);
public Runnable test() {
return new Runnable() {
public void run() {
System.out.println(d);
}
};
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    // TODO: Add assertions
}

#[test]
fn anonymous_class9_test() {
    let helper = IntegrationTestHelper::new("anonymous_class9_test");
    let source = r#"
public class TestCls {
public Callable<String> c = new Callable<String>() {
@Override
public String call() throws Exception {
return "str";
}
};
public Runnable test() {
return new FutureTask<String>(this.c) {
public void run() {
System.out.println(6);
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    // TODO: Add assertions
}

#[test]
fn incorrect_anonymous_class_test() {
    let helper = IntegrationTestHelper::new("incorrect_anonymous_class_test");
    let source = r#"
public class TestCls {
public final class 1 {
public void invoke() {
new 1(); // cause infinite self inline
}
public void test() {
new 1();
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .contains_one("public final class AnonymousClass1 {")
        .count_string(2, "new AnonymousClass1();");
}

#[test]
fn inner2_samples_test() {
    let helper = IntegrationTestHelper::new("inner2_samples_test");
    // TODO: Extract test source
    let source = r#"
public class TestCls {
    // Add test code here
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .does_not_contain("synthetic")
        .does_not_contain("access$");
}

#[test]
fn inner_class_test() {
    let helper = IntegrationTestHelper::new("inner_class_test");
    let source = r#"
public class TestCls {
public class Inner {
public class Inner2 extends Thread {
}
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    // TODO: Add assertions
}

#[test]
fn inner_class2_test() {
    let helper = IntegrationTestHelper::new("inner_class2_test");
    let source = r#"
public class TestCls {
@Override
public void run() {
System.err.println("Test timed out");
}
public void test() {
new Timer().schedule(new TerminateTask(), 1000L);
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .contains("new Timer().schedule(new TerminateTask(), 1000L);")
        .does_not_contain("synthetic")
        .does_not_contain("this")
        .does_not_contain("null")
        .does_not_contain("AnonymousClass");
}

#[test]
fn inner_class3_test() {
    let helper = IntegrationTestHelper::new("inner_class3_test");
    let source = r#"
public class TestCls {
private String c;
private void setC(String c) {
this.c = c;
}
public class C {
public String c() {
setC("c");
return c;
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .does_not_contain("synthetic")
        .does_not_contain("access$")
        .does_not_contain("x0");
}

#[test]
fn inner_class4_test() {
    let helper = IntegrationTestHelper::new("inner_class4_test");
    let source = r#"
public class TestCls {
public class C {
public String c;
private C() {
this.c = "c";
}
public String test() {
return new C().c;
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .contains_one("return new C().c;");
}

#[test]
fn inner_class5_test() {
    let helper = IntegrationTestHelper::new("inner_class5_test");
    let source = r#"
public class TestCls {
private String i0;
public class A {
protected String a;
public A() {
a = "";
}
public String a() {
return "";
public class I0 {
private String i1;
public class I1 {
private String i2;
public I1() {
TestCls.this.i0 = "i0";
I0.this.i0 = "i1";
I0.this.i1 = "i2";
i0 = "i0";
i1 = "i1";
i2 = "i2";
public String i() {
String result = TestCls.this.i0 + I0.this.i0 + I0.this.i1 + i0 + i1 + i2;
A a = new A() {
TestCls.this.i0 = "i1";
I0.this.i0 = "i2";
I0.this.i1 = "i3";
I1.this.i0 = "i1";
I1.this.i1 = "i2";
I1.this.i2 = "i3";
a = "a";
return TestCls.this.i0 + I0.this.i0 + I0.this.i1 + I1.this.i0 + I1.this.i1 + I1.this.i2 + a;
};
return result + a.a();
public I0() {
TestCls.this.i0 = "i-";
String result = TestCls.this.i0 + i0 + i1;
return result + new I1().i();
public void check() throws Exception {
assertThat(new I0().i()).isEqualTo("i-i0i1i0i1i2i0i1i2i1i2i3i1i2i3a");
assertThat(i0).isEqualTo("i1");
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    // TODO: Add assertions
}

#[test]
fn inner_class_fake_synthetic_constructor_test() {
    let helper = IntegrationTestHelper::new("inner_class_fake_synthetic_constructor_test");
    // TODO: Extract test source
    let source = r#"
public class TestCls {
    // Add test code here
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .contains_one("TestCls(String a) {");
}

#[test]
fn inner_class_synthetic_constructor_test() {
    let helper = IntegrationTestHelper::new("inner_class_synthetic_constructor_test");
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
fn inner_class_synthetic_rename_test() {
    let helper = IntegrationTestHelper::new("inner_class_synthetic_rename_test");
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
fn inner_constructor_call_test() {
    let helper = IntegrationTestHelper::new("inner_constructor_call_test");
    let source = r#"
public class TestCls {
@SuppressWarnings("InnerClassMayBeStatic")
public class A {
public class AA {
public void test() {
}
A a = new A();
A.AA aa = a.new AA();
aa.test();
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .contains_one("A.AA aa = a.new AA();");
}

#[test]
fn nested_anonymous_class_test() {
    let helper = IntegrationTestHelper::new("nested_anonymous_class_test");
    let source = r#"
public class TestCls {
public void test() {
use(new Callable<Runnable>() {
@Override
public Runnable call() {
return new Runnable() {
public void run() {
System.out.println("run");
}
};
});
public void testLambda() {
use(() -> () -> System.out.println("lambda"));
public void use(Callable<Runnable> r) {
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    // TODO: Add assertions
}

#[test]
fn nested_anonymous_class_test_smali() {
    let helper = IntegrationTestHelper::new("nested_anonymous_class_test_smali");
    let source = r#"
public class TestCls {
public void test() {
use(new Callable<Runnable>() {
@Override
public Runnable call() {
return new Runnable() {
public void run() {
System.out.println("run");
}
};
});
public void testLambda() {
use(() -> () -> System.out.println("lambda"));
public void use(Callable<Runnable> r) {
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    // TODO: Add assertions
}

#[test]
fn outer_constructor_call_test() {
    let helper = IntegrationTestHelper::new("outer_constructor_call_test");
    let source = r#"
public class TestCls {
private TestCls(Inner inner) {
System.out.println(inner);
}
private class Inner {
private TestCls test() {
return new TestCls(this);
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .contains_one("class Inner {")
        .contains_one("return new TestOuterConstructorCall$TestCls(this);");
}

#[test]
fn replace_consts_in_annotations_test() {
    let helper = IntegrationTestHelper::new("replace_consts_in_annotations_test");
    let source = r#"
public class TestCls {
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface A {
int i();
float f();
}
@A(i = -1, f = C.FLOAT_CONST)
public static final float FLOAT_CONST = 3.14f;
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    // TODO: Add assertions
}

#[test]
fn replace_consts_in_annotations2_test() {
    let helper = IntegrationTestHelper::new("replace_consts_in_annotations2_test");
    let source = r#"
public class TestCls {
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface A {
int[] value();
}
@A(C.INT_CONST)
public static final int INT_CONST = 23412342;
@A({ C.INT_CONST, C2.INT_CONST })
public static final int INT_CONST = 34563456;
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .contains_one("@A(C.INT_CONST)")
        .contains_one("@A({C.INT_CONST}")
        .contains_one("@A({C.INT_CONST, C2.INT_CONST})")
        .contains_one("23412342")
        .contains_one("34563456");
}

#[test]
fn synthetic_mth_rename_test() {
    let helper = IntegrationTestHelper::new("synthetic_mth_rename_test");
    // TODO: Extract test source
    let source = r#"
public class TestCls {
    // Add test code here
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .contains_one("public String call(Runnable... p) {")
        .does_not_contain("synthetic");
}
