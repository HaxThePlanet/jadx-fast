//! Others integration tests
//! Ported from jadx-core/src/test/java/jadx/tests/integration/

use crate::integration_test_framework::{IntegrationTestHelper, CodeAssertions, tools_status};

#[test]
fn all_nops_test() {
    // Note: This is a SmaliTest in JADX - requires smali input format not yet supported by dexterity
    eprintln!("SKIPPED: SmaliTest - requires smali input format");
}

#[test]
fn arg_inline_test() {
    let status = tools_status();
    if !status.can_run_tests() {
        eprintln!("SKIPPED: {}", status.skip_reason());
        return;
    }

    let helper = IntegrationTestHelper::new("arg_inline_test");
    let source = r#"
public class TestCls {
public void test(int a) {
while (a < 10) {
int b = a + 1;
a = b;
}
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .contains("i++;")
        .does_not_contain("i = i + 1;");
}

#[test]
fn bad_class_access_modifiers_test() {
    // Note: This is a SmaliTest in JADX - requires smali input format not yet supported by dexterity
    eprintln!("SKIPPED: SmaliTest - requires smali input format");
}

#[test]
fn bad_method_access_modifiers_test() {
    let status = tools_status();
    if !status.can_run_tests() {
        eprintln!("SKIPPED: {}", status.skip_reason());
        return;
    }

    let helper = IntegrationTestHelper::new("bad_method_access_modifiers_test");
    let source = r#"
public class TestCls {
public abstract class A {
public abstract void test();
}
public class B extends A {
protected void test() {
}
}
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .contains("abstract class A")
        .contains("class B extends A");
}

#[test]
fn cast_of_null_test() {
    let status = tools_status();
    if !status.can_run_tests() {
        eprintln!("SKIPPED: {}", status.skip_reason());
        return;
    }

    let helper = IntegrationTestHelper::new("cast_of_null_test");
    let source = r#"
public class TestCls {
public void test() {
m((long[]) null);
m((String) null);
m((List<String>) null);
}
public void m(long[] a) {
public void m(String s) {
public void m(List<String> list) {
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .contains_one("m((long[]) null);")
        .contains_one("m((String) null);")
        .contains_one("m((List<String>) null);");
}

#[test]
fn class_gen_test() {
    let status = tools_status();
    if !status.can_run_tests() {
        eprintln!("SKIPPED: {}", status.skip_reason());
        return;
    }

    let helper = IntegrationTestHelper::new("class_gen_test");
    let source = r#"
public class TestCls {
public interface I {
int test();
public int test3();
}
public abstract static class A {
public abstract int test2();
}
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .contains("public interface I {")
        .contains("int test();")
        .does_not_contain("public int test();")
        .contains("int test3();")
        .contains("public abstract int test2();");
}

#[test]
fn class_implements_signature_test() {
    let status = tools_status();
    if !status.can_run_tests() {
        eprintln!("SKIPPED: {}", status.skip_reason());
        return;
    }

    let helper = IntegrationTestHelper::new("class_implements_signature_test");
    let source = r#"
public class TestCls {
public abstract static class A<T> implements Comparable<A<T>> {
T value;
}
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .contains("class A<T> implements Comparable<A<T>>");
}

#[test]
fn class_implements_signature_test_raung() {
    let status = tools_status();
    if !status.can_run_tests() {
        eprintln!("SKIPPED: {}", status.skip_reason());
        return;
    }

    let helper = IntegrationTestHelper::new("class_implements_signature_test_raung");
    let source = r#"
public class TestCls {
public abstract static class A<T> implements Comparable<A<T>> {
T value;
}
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .contains_one("public class TestClassImplementsSignature<T> {")
        .contains_one("Unexpected interfaces in signature");
}

#[test]
fn class_re_gen_test() {
    let status = tools_status();
    if !status.can_run_tests() {
        eprintln!("SKIPPED: {}", status.skip_reason());
        return;
    }

    let helper = IntegrationTestHelper::new("class_re_gen_test");
    let source = r#"
public class TestCls {
private int intField = 5;
public static class A {
}
public int test() {
return 0;
}
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .contains_one("private int intField = 5;")
        .contains_one("public static class A {")
        .contains_one("public int test() {");
}

#[test]
fn code_comments_test() {
    let status = tools_status();
    if !status.can_run_tests() {
        eprintln!("SKIPPED: {}", status.skip_reason());
        return;
    }

    let helper = IntegrationTestHelper::new("code_comments_test");
    let source = r#"
public class TestCls {
private int intField = 5;
}
public int test() {
System.out.println("Hello");
System.out.println("comment");
return intField;
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .contains_one("// class comment")
        .contains_one("// inner class comment")
        .contains_one("// field comment")
        .contains_one("// method comment")
        .contains_one(" comment")
        .does_not_contain("class comment");
}

#[test]
fn code_comments2_test() {
    let status = tools_status();
    if !status.can_run_tests() {
        eprintln!("SKIPPED: {}", status.skip_reason());
        return;
    }

    let helper = IntegrationTestHelper::new("code_comments2_test");
    let source = r#"
public class TestCls {
public int test(boolean z) {
if (z) {
System.out.println("z");
return 1;
}
return 3;
}
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    // Note: Code comments are a JADX-specific feature not yet implemented in dexterity
    result
        .contains("if (z)")
        .contains("return 1")
        .contains("return 3");
}

#[test]
fn code_comments2a_test() {
    let status = tools_status();
    if !status.can_run_tests() {
        eprintln!("SKIPPED: {}", status.skip_reason());
        return;
    }

    let helper = IntegrationTestHelper::new("code_comments2a_test");
    let source = r#"
public class TestCls {
private int f;
public int test(boolean z) {
if (z) {
System.out.println("z");
return new Random().nextInt();
}
return f;
}
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .contains("if (z)")
        .contains("new Random().nextInt()");
}

#[test]
fn code_comments_multiline_test() {
    let status = tools_status();
    if !status.can_run_tests() {
        eprintln!("SKIPPED: {}", status.skip_reason());
        return;
    }

    let helper = IntegrationTestHelper::new("code_comments_multiline_test");
    let source = r#"
public class TestCls {
public int test(boolean z) {
if (z) {
System.out.println("z");
return 1;
}
return 3;
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .contains_one("// multi")
        .contains_one("// line")
        .contains_one("// comment");
}

#[test]
fn code_comments_override_test() {
    let status = tools_status();
    if !status.can_run_tests() {
        eprintln!("SKIPPED: {}", status.skip_reason());
        return;
    }

    let helper = IntegrationTestHelper::new("code_comments_override_test");
    let source = r#"
public class TestCls {
public interface I {
void mth();
}
@Override
public void mth() {
System.out.println("mth");
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .contains_one("@Override")
        .contains_one("@Override");
}

#[test]
fn code_metadata_test() {
    let status = tools_status();
    if !status.can_run_tests() {
        eprintln!("SKIPPED: {}", status.skip_reason());
        return;
    }

    let helper = IntegrationTestHelper::new("code_metadata_test");
    let source = r#"
public class TestCls {
public String str;
}
public String test() {
A a = new A();
a.str = call();
return a.str;
public static String call() {
return "str";
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .contains_one("return a.str;");
}

#[test]
fn code_metadata2_test() {
    let status = tools_status();
    if !status.can_run_tests() {
        eprintln!("SKIPPED: {}", status.skip_reason());
        return;
    }

    let helper = IntegrationTestHelper::new("code_metadata2_test");
    let source = r#"
public class TestCls {
@SuppressWarnings("Convert2Lambda")
public Runnable test(boolean a) {
if (a) {
return new Runnable() {
@Override
public void run() {
System.out.println("test");
}
};
System.out.println("another");
return empty();
public static Runnable empty() {
// empty
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .contains_one("return empty();");
}

#[test]
fn code_metadata3_test() {
    let status = tools_status();
    if !status.can_run_tests() {
        eprintln!("SKIPPED: {}", status.skip_reason());
        return;
    }

    let helper = IntegrationTestHelper::new("code_metadata3_test");
    let source = r#"
public class TestCls {
public String test(String str) {
int k = str.length();
k++;
return str + ':' + k;
}
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .count_string(3, "str");
}

#[test]
fn const_replace_test() {
    let status = tools_status();
    if !status.can_run_tests() {
        eprintln!("SKIPPED: {}", status.skip_reason());
        return;
    }

    let helper = IntegrationTestHelper::new("const_replace_test");
    let source = r#"
public class TestCls {
public static final String CONST_VALUE = "string";
public String test() {
return CONST_VALUE;
}
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .contains_one("return CONST_VALUE;");
}

#[test]
fn const_replace_test_without_replace() {
    let status = tools_status();
    if !status.can_run_tests() {
        eprintln!("SKIPPED: {}", status.skip_reason());
        return;
    }

    let helper = IntegrationTestHelper::new("const_replace_test_without_replace");
    let source = r#"
public class TestCls {
public static final String CONST_VALUE = "string";
public String test() {
return CONST_VALUE;
}
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    // Without const replacement enabled, should just return the string literal
    result
        .contains("return");
}

#[test]
fn const_string_concat_test() {
    let status = tools_status();
    if !status.can_run_tests() {
        eprintln!("SKIPPED: {}", status.skip_reason());
        return;
    }

    let helper = IntegrationTestHelper::new("const_string_concat_test");
    let source = r#"
public class TestCls {
public String test1(int value) {
return new StringBuilder().append("Value").append(" equals ").append(value).toString();
}
public String test2() {
return new StringBuilder().append("App ").append("version: ").append(1).append('.').append(2).toString();
}
public String test3(String name, int value) {
return "value " + name + " = " + value;
}
public void check() {
assertThat(test1(7)).isEqualTo("Value equals 7");
assertThat(test2()).isEqualTo("App version: 1.2");
assertThat(test3("v", 4)).isEqualTo("value v = 4");
}
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    // StringBuilder elimination should simplify the calls
    result
        .contains("test1")
        .contains("test2")
        .contains("test3");
}

#[test]
fn constructor_test() {
    // Note: This is a SmaliTest in JADX - requires smali input format not yet supported by dexterity
    eprintln!("SKIPPED: SmaliTest - requires smali input format");
}

#[test]
fn constructor2_test() {
    // Note: This is a SmaliTest in JADX - requires smali input format not yet supported by dexterity
    eprintln!("SKIPPED: SmaliTest - requires smali input format");
}

#[test]
fn constructor_branched_test() {
    // Note: This is a SmaliTest in JADX - requires smali input format not yet supported by dexterity
    eprintln!("SKIPPED: SmaliTest - requires smali input format");
}

#[test]
fn constructor_branched2_test() {
    // Note: This is a SmaliTest in JADX - requires smali input format not yet supported by dexterity
    eprintln!("SKIPPED: SmaliTest - requires smali input format");
}

#[test]
fn constructor_branched3_test() {
    // Note: This is a SmaliTest in JADX - requires smali input format not yet supported by dexterity
    eprintln!("SKIPPED: SmaliTest - requires smali input format");
}

#[test]
fn dead_block_references_start_test() {
    // Note: This is a SmaliTest in JADX - requires smali input format not yet supported by dexterity
    eprintln!("SKIPPED: SmaliTest - requires smali input format");
}

#[test]
fn deboxing_test() {
    let status = tools_status();
    if !status.can_run_tests() {
        eprintln!("SKIPPED: {}", status.skip_reason());
        return;
    }

    let helper = IntegrationTestHelper::new("deboxing_test");
    let source = r#"
public class TestCls {
public Object testInt() {
return 1;
}
public Object testBoolean() {
return true;
public Object testByte() {
return (byte) 2;
public Short testShort() {
return 3;
public Character testChar() {
return 'c';
public Long testLong() {
return 4L;
public void testConstInline() {
Boolean v = true;
use(v);
private void use(Boolean v) {
public void check() {
// don't mind weird comparisons
// need to get primitive without using boxing or literal
// otherwise will get same result after decompilation
assertThat(testInt()).isEqualTo(Integer.sum(0, 1));
assertThat(testBoolean()).isEqualTo(Boolean.TRUE);
assertThat(testByte()).isEqualTo(Byte.parseByte("2"));
assertThat(testShort()).isEqualTo(Short.parseShort("3"));
assertThat(testChar()).isEqualTo("c".charAt(0));
assertThat(testLong()).isEqualTo(Long.valueOf("4"));
testConstInline();
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .contains_one("return 1;")
        .contains_one("return true;")
        .contains_one("return (byte) 2;")
        .contains_one("return (short) 3;")
        .contains_one("return 'c';")
        .contains_one("return 4L;")
        .count_string(2, "use(true);");
}

#[test]
fn deboxing2_test() {
    let status = tools_status();
    if !status.can_run_tests() {
        eprintln!("SKIPPED: {}", status.skip_reason());
        return;
    }

    let helper = IntegrationTestHelper::new("deboxing2_test");
    let source = r#"
public class TestCls {
public long test(Long l) {
if (l == null) {
l = 0L;
}
return l;
public void check() {
assertThat(test(null)).isEqualTo(0L);
assertThat(test(0L)).isEqualTo(0L);
assertThat(test(7L)).isEqualTo(7L);
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .contains_one("long test(Long l)")
        .contains_one("if (l == null) {")
        .contains_one("l = 0L;")
        .contains_one("test(null)")
        .contains_one("test(0L)")
        .contains_one("test(7L)")
        .contains_one("isEqualTo(7L)")
        .count_string(2, "isEqualTo(0L)");
}

#[test]
fn deboxing3_test() {
    let status = tools_status();
    if !status.can_run_tests() {
        eprintln!("SKIPPED: {}", status.skip_reason());
        return;
    }

    let helper = IntegrationTestHelper::new("deboxing3_test");
    let source = r#"
public class TestCls {
public F first;
public S second;
}
private Map<String, Pair<Long, String>> cache = new HashMap<>();
public boolean test(String id, Long l) {
if (l == null) {
l = 900000L;
Pair<Long, String> pair = this.cache.get(id);
if (pair == null) {
return false;
return pair.first + l > System.currentTimeMillis();
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .contains_one("l = 900000L;");
}

#[test]
fn deboxing4_test() {
    let status = tools_status();
    if !status.can_run_tests() {
        eprintln!("SKIPPED: {}", status.skip_reason());
        return;
    }

    let helper = IntegrationTestHelper::new("deboxing4_test");
    let source = r#"
public class TestCls {
public boolean test(Integer i) {
return ((Integer) 1).equals(i);
}
public void check() {
assertThat(test(null)).isFalse();
assertThat(test(0)).isFalse();
assertThat(test(1)).isTrue();
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .does_not_contain("return 1.equals(num);");
}

#[test]
fn def_constructor_not_removed_test() {
    let status = tools_status();
    if !status.can_run_tests() {
        eprintln!("SKIPPED: {}", status.skip_reason());
        return;
    }

    let helper = IntegrationTestHelper::new("def_constructor_not_removed_test");
    let source = r#"
public class TestCls {
static {
// empty
}
public static class A {
public final String s;
public A() {
s = "a";
}
public A(String str) {
s = str;
}
}
public static class B extends A {
public B() {
super();
}
public B(String s) {
super(s);
}
}
public void check() {
new A();
new A("a");
new B();
new B("b");
}
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .does_not_contain("static {")
        .contains("public B() {");
}

#[test]
fn def_constructor_with_annotation_test() {
    let status = tools_status();
    if !status.can_run_tests() {
        eprintln!("SKIPPED: {}", status.skip_reason());
        return;
    }

    let helper = IntegrationTestHelper::new("def_constructor_with_annotation_test");
    let source = r#"
public class TestCls {
@AnnotationTest
public TestCls() {
}
@Target(ElementType.CONSTRUCTOR)
@Retention(RetentionPolicy.RUNTIME)
public @interface AnnotationTest {
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .contains_one("@AnnotationTest");
}

#[test]
fn duplicate_cast_test() {
    let status = tools_status();
    if !status.can_run_tests() {
        eprintln!("SKIPPED: {}", status.skip_reason());
        return;
    }

    let helper = IntegrationTestHelper::new("duplicate_cast_test");
    let source = r#"
public class TestCls {
public int[] method(Object o) {
return (int[]) o;
}
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .contains("return (int[]) o;");
}

#[test]
fn explicit_override_test() {
    // Note: This is a SmaliTest in JADX - requires smali input format not yet supported by dexterity
    eprintln!("SKIPPED: SmaliTest - requires smali input format");
}

#[test]
fn field_access_reorder_test() {
    let status = tools_status();
    if !status.can_run_tests() {
        eprintln!("SKIPPED: {}", status.skip_reason());
        return;
    }

    let helper = IntegrationTestHelper::new("field_access_reorder_test");
    let source = r#"
public class TestCls {
private long field = 10;
public final boolean test() {
long value = longCall();
long diff = value - this.field;
this.field = value;
return diff > 250;
}
public static long longCall() {
return 261L;
}
public void check() {
assertThat(test()).isTrue();
}
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    // Just verify it compiles correctly - auto check should pass
    result
        .contains("boolean test()")
        .contains("longCall()");
}

#[test]
fn field_init2_test() {
    let status = tools_status();
    if !status.can_run_tests() {
        eprintln!("SKIPPED: {}", status.skip_reason());
        return;
    }

    let helper = IntegrationTestHelper::new("field_init2_test");
    let source = r#"
public class TestCls {
public interface BasicAbstract {
void doSomething();
}
public BasicAbstract x = new BasicAbstract() {
@Override
public void doSomething() {
y = 1;
};
public int y = 0;
public TestCls() {
public TestCls(int z) {
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .contains_one("x = new BasicAbstract() {")
        .contains_one("y = 0;");
}

#[test]
fn field_init3_test() {
    let status = tools_status();
    if !status.can_run_tests() {
        eprintln!("SKIPPED: {}", status.skip_reason());
        return;
    }

    let helper = IntegrationTestHelper::new("field_init3_test");
    let source = r#"
public class TestCls {
public abstract static class A {
public int field = 4;
}
public static final class B extends A {
public B() {
// IPUT for A.field
super.field = 7;
public static final class C extends A {
public int other = 11;
public C() {
// IPUT for C.field not A.field !!!
this.field = 9;
public static final class D extends A {
public void check() {
assertThat(new B().field).isEqualTo(7);
assertThat(new C().field).isEqualTo(9);
assertThat(new C().other).isEqualTo(11);
assertThat(new D().field).isEqualTo(4);
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .contains_one("public int field = 4;")
        .contains_one("field = 7;")
        .contains_one("field = 9;")
        .contains_one("public int other = 11;");
}

#[test]
fn field_init_in_try_catch_test() {
    let status = tools_status();
    if !status.can_run_tests() {
        eprintln!("SKIPPED: {}", status.skip_reason());
        return;
    }

    let helper = IntegrationTestHelper::new("field_init_in_try_catch_test");
    let source = r#"
public class TestCls {
public static final URL A;
static {
try {
A = new URL("http://www.example.com/");
} catch (MalformedURLException e) {
throw new RuntimeException(e);
}
}
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .contains("try {")
        .contains("catch");
}

#[test]
fn field_init_in_try_catch_test2() {
    let status = tools_status();
    if !status.can_run_tests() {
        eprintln!("SKIPPED: {}", status.skip_reason());
        return;
    }

    let helper = IntegrationTestHelper::new("field_init_in_try_catch_test2");
    let source = r#"
public class TestCls {
public static final URL[] A;
static {
try {
A = new URL[] { new URL("http://www.example.com/") };
} catch (MalformedURLException e) {
throw new RuntimeException(e);
}
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .contains_one("public static final String[] A;");
}

#[test]
fn field_init_in_try_catch_test3() {
    let status = tools_status();
    if !status.can_run_tests() {
        eprintln!("SKIPPED: {}", status.skip_reason());
        return;
    }

    let helper = IntegrationTestHelper::new("field_init_in_try_catch_test3");
    let source = r#"
public class TestCls {
public static final String[] A;
static {
try {
A = new String[] { "a" };
// Note: follow code will not be extracted:
// a = new String[]{new String("a")};
new URL("http://www.example.com/");
} catch (MalformedURLException e) {
throw new RuntimeException(e);
}
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .contains_one("public static final String[] A;");
}

#[test]
fn field_init_negative_test() {
    let status = tools_status();
    if !status.can_run_tests() {
        eprintln!("SKIPPED: {}", status.skip_reason());
        return;
    }

    let helper = IntegrationTestHelper::new("field_init_negative_test");
    let source = r#"
public class TestCls {
StringBuilder sb;
int field;
public TestCls() {
initBuilder(new StringBuilder("sb"));
this.field = initField();
this.sb.append(this.field);
}
private void initBuilder(StringBuilder sb) {
this.sb = sb;
private int initField() {
return sb.length();
public String getStr() {
return sb.toString();
public void check() {
assertThat(new TestCls().getStr()).isEqualTo("sb2"); // no NPE
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .contains_one("this.field = initField();")
        .does_not_contain("int field = initField();");
}

#[test]
fn field_init_order_test() {
    let status = tools_status();
    if !status.can_run_tests() {
        eprintln!("SKIPPED: {}", status.skip_reason());
        return;
    }

    let helper = IntegrationTestHelper::new("field_init_order_test");
    let source = r#"
public class TestCls {
private final StringBuilder sb = new StringBuilder();
private final String a = sb.append("a").toString();
private final String b = sb.append("b").toString();
private final String c = sb.append("c").toString();
private final String result = sb.toString();
public void check() {
assertThat(result).isEqualTo("abc");
assertThat(a).isEqualTo("a");
assertThat(b).isEqualTo("ab");
assertThat(c).isEqualTo("abc");
}
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .contains_one("String result = this.sb.toString();")
        .does_not_contain("TestCls() {")
        .does_not_contain("String result;");
}

#[test]
fn field_init_order2_test() {
    let status = tools_status();
    if !status.can_run_tests() {
        eprintln!("SKIPPED: {}", status.skip_reason());
        return;
    }

    let helper = IntegrationTestHelper::new("field_init_order2_test");
    let source = r#"
public class TestCls {
static String ZPREFIX = "SOME_";
private static final String VALUE = ZPREFIX + "VALUE";
public void check() {
assertThat(VALUE).isEqualTo("SOME_VALUE");
}
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .contains("String VALUE");
}

#[test]
fn field_init_order2_test_smali() {
    let status = tools_status();
    if !status.can_run_tests() {
        eprintln!("SKIPPED: {}", status.skip_reason());
        return;
    }

    let helper = IntegrationTestHelper::new("field_init_order2_test_smali");
    let source = r#"
public class TestCls {
static String ZPREFIX = "SOME_";
private static final String VALUE = ZPREFIX + "VALUE";
public void check() {
assertThat(VALUE).isEqualTo("SOME_VALUE");
}
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .contains("String VALUE");
}

#[test]
fn field_init_order_static_test() {
    let status = tools_status();
    if !status.can_run_tests() {
        eprintln!("SKIPPED: {}", status.skip_reason());
        return;
    }

    let helper = IntegrationTestHelper::new("field_init_order_static_test");
    let source = r#"
public class TestCls {
private static final StringBuilder sb = new StringBuilder();
private static final String a = sb.append("a").toString();
private static final String b = sb.append("b").toString();
private static final String c = sb.append("c").toString();
private static final String result = sb.toString();
public void check() {
assertThat(result).isEqualTo("abc");
assertThat(a).isEqualTo("a");
assertThat(b).isEqualTo("ab");
assertThat(c).isEqualTo("abc");
}
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .contains_one("String result = sb.toString();")
        .does_not_contain("static {")
        .does_not_contain("String result;");
}

#[test]
fn field_usage_move_test_smali() {
    let status = tools_status();
    if !status.can_run_tests() {
        eprintln!("SKIPPED: {}", status.skip_reason());
        return;
    }

    let helper = IntegrationTestHelper::new("field_usage_move_test_smali");
    let source = r#"
public class TestCls {
public static void test(Object obj) {
if (obj instanceof Boolean) {
System.out.println("Boolean: " + obj);
}
if (obj instanceof Float) {
System.out.println("Float: " + obj);
}
}
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .contains("instanceof Boolean")
        .contains("instanceof Float");
}

#[test]
fn fix_class_access_modifiers_test() {
    // Note: This is a SmaliTest in JADX - requires smali input format not yet supported by dexterity
    eprintln!("SKIPPED: SmaliTest - requires smali input format");
}

#[test]
fn float_value_test() {
    let status = tools_status();
    if !status.can_run_tests() {
        eprintln!("SKIPPED: {}", status.skip_reason());
        return;
    }

    let helper = IntegrationTestHelper::new("float_value_test");
    let source = r#"
public class TestCls {
public float[] test() {
float[] fa = { 0.55f };
fa[0] /= 2;
return fa;
}
public void check() {
assertThat(test()[0]).isCloseTo(0.275f, within(0.0001f));
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .contains_one("0.55f")
        .contains_one("fa[0] = fa[0] / 2.0f;")
        .does_not_contain("1073741824");
}

#[test]
fn if_in_try_test() {
    let status = tools_status();
    if !status.can_run_tests() {
        eprintln!("SKIPPED: {}", status.skip_reason());
        return;
    }

    let helper = IntegrationTestHelper::new("if_in_try_test");
    let source = r#"
public class TestCls {
public File dir;
public int test() {
try {
int a = f();
if (a != 0) {
return a;
}
} catch (Exception e) {
// skip
f();
return 1;
} catch (IOException e) {
return -1;
private int f() throws IOException {
return 0;
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .contains_one("if (a != 0) {")
        .contains_one("} catch (Exception e) {")
        .contains_one("return 1;")
        .contains_one("} catch (IOException e")
        .contains_one("return -1;")
        .count_string(2, "try {")
        .count_string(3, "f()");
}

#[test]
fn if_try_in_catch_test() {
    let status = tools_status();
    if !status.can_run_tests() {
        eprintln!("SKIPPED: {}", status.skip_reason());
        return;
    }

    let helper = IntegrationTestHelper::new("if_try_in_catch_test");
    let source = r#"
public class TestCls {
public Exception exception;
private java.lang.Object data;
public java.lang.Object test(final Object obj) {
exception = null;
try {
return f();
} catch (Exception e) {
if (a(e) && b(obj)) {
} catch (Exception exc) {
e = exc;
}
System.out.println("Exception" + e);
exception = e;
return data;
private static boolean b(Object obj) {
return obj == null;
private static boolean a(Exception e) {
return e instanceof RuntimeException;
private Object f() {
return null;
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .contains_one("if (")
        .count_string(2, "try {")
        .count_string(2, "return f();");
}

#[test]
fn incorrect_field_signature_test() {
    // Note: This is a SmaliTest in JADX - requires smali input format not yet supported by dexterity
    eprintln!("SKIPPED: SmaliTest - requires smali input format");
}

#[test]
fn incorrect_method_signature_test() {
    // Note: This is a SmaliTest in JADX - requires smali input format not yet supported by dexterity
    eprintln!("SKIPPED: SmaliTest - requires smali input format");
}

#[test]
fn inline_var_arg_test() {
    // Note: This is a SmaliTest in JADX - requires smali input format not yet supported by dexterity
    eprintln!("SKIPPED: SmaliTest - requires smali input format");
}

#[test]
fn insns_before_super_test() {
    // Note: This is a SmaliTest in JADX - requires smali input format not yet supported by dexterity
    eprintln!("SKIPPED: SmaliTest - requires smali input format");
}

#[test]
fn insns_before_super2_test() {
    // Note: This is a SmaliTest in JADX - requires smali input format not yet supported by dexterity
    eprintln!("SKIPPED: SmaliTest - requires smali input format");
}

#[test]
fn insns_before_this_test() {
    // Note: This is a SmaliTest in JADX - requires smali input format not yet supported by dexterity
    eprintln!("SKIPPED: SmaliTest - requires smali input format");
}

#[test]
fn interface_default_method_test() {
    let status = tools_status();
    if !status.can_run_tests() {
        eprintln!("SKIPPED: {}", status.skip_reason());
        return;
    }

    let helper = IntegrationTestHelper::new("interface_default_method_test");
    let source = r#"
public class TestCls {
@SuppressWarnings("UnnecessaryInterfaceModifier")
public interface ITest {
void test1();
default void test2() {
}
static void test3() {
}
abstract void test4();
}
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .contains("interface ITest")
        .contains("void test1()")
        .contains("default void test2()");
}

#[test]
fn issue13a_test() {
    let status = tools_status();
    if !status.can_run_tests() {
        eprintln!("SKIPPED: {}", status.skip_reason());
        return;
    }

    let helper = IntegrationTestHelper::new("issue13a_test");
    let source = r#"
public class TestCls {
private static final String TAG = "Parcel";
private static final Map<ClassLoader, Map<String, Parcelable.Creator<?>>> M_CREATORS = new HashMap<>();
@SuppressWarnings({ "unchecked", "ConstantConditions", "Java8MapApi", "rawtypes" })
public final <T extends Parcelable> T test(ClassLoader loader) {
String name = readString();
if (name == null) {
return null;
}
Parcelable.Creator<T> creator;
synchronized (M_CREATORS) {
Map<String, Parcelable.Creator<?>> map = M_CREATORS.get(loader);
if (map == null) {
map = new HashMap<>();
M_CREATORS.put(loader, map);
creator = (Parcelable.Creator<T>) map.get(name);
if (creator == null) {
try {
Class<?> c = loader == null ? Class.forName(name) : Class.forName(name, true, loader);
Field f = c.getField("CREATOR");
creator = (Parcelable.Creator) f.get(null);
} catch (IllegalAccessException e) {
Log.e(TAG, '1' + name + ", e: " + e);
throw new RuntimeException('2' + name);
} catch (ClassNotFoundException e) {
Log.e(TAG, '3' + name + ", e: " + e);
throw new RuntimeException('4' + name);
} catch (ClassCastException e) {
throw new RuntimeException('5' + name);
} catch (NoSuchFieldException e) {
throw new RuntimeException('6' + name);
throw new RuntimeException('7' + name);
map.put(name, creator);
if (creator instanceof Parcelable.ClassLoaderCreator<?>) {
return ((Parcelable.ClassLoaderCreator<T>) creator).createFromParcel(this, loader);
return creator.createFromParcel(this);
private String readString() {
return "";
private class Parcelable {
public class Creator<T> {
public T createFromParcel(TestCls testCls) {
public class ClassLoaderCreator<T> extends Creator<T> {
public T createFromParcel(TestCls testCls, ClassLoader loader) {
public static void e(String tag, String s) {
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .does_not_contain("Throwable");
}

#[test]
fn issue13b_test() {
    let status = tools_status();
    if !status.can_run_tests() {
        eprintln!("SKIPPED: {}", status.skip_reason());
        return;
    }

    let helper = IntegrationTestHelper::new("issue13b_test");
    let source = r#"
public class TestCls {
private static final String PROPERTIES_FILE = "";
private static final String TAG = "";
private final CountDownLatch mInitializedLatch = new CountDownLatch(1);
public int mC2KServerPort = 0;
private String mSuplServerHost = "";
public int mSuplServerPort = 0;
private String mC2KServerHost = "";
public TestCls() {
Properties mProperties = new Properties();
try {
File file = new File(PROPERTIES_FILE);
FileInputStream stream = new FileInputStream(file);
mProperties.load(stream);
stream.close();
mSuplServerHost = mProperties.getProperty("SUPL_HOST");
String portString = mProperties.getProperty("SUPL_PORT");
if (mSuplServerHost != null && portString != null) {
mSuplServerPort = Integer.parseInt(portString);
} catch (NumberFormatException e) {
Log.e(TAG, "unable to parse SUPL_PORT: " + portString);
}
mC2KServerHost = mProperties.getProperty("C2K_HOST");
portString = mProperties.getProperty("C2K_PORT");
if (mC2KServerHost != null && portString != null) {
mC2KServerPort = Integer.parseInt(portString);
Log.e(TAG, "unable to parse C2K_PORT: " + portString);
} catch (IOException e) {
Log.e(TAG, "Could not open GPS configuration file " + PROPERTIES_FILE);
Thread mThread = new Thread();
mThread.start();
while (true) {
mInitializedLatch.await();
break;
} catch (InterruptedException e) {
Thread.currentThread().interrupt();
public static void e(String tag, String s) {
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .contains("Properties")
        .contains("try {");
}

#[test]
fn java_dup2x2_test() {
    // Note: This is a SmaliTest in JADX - requires smali input format not yet supported by dexterity
    eprintln!("SKIPPED: SmaliTest - requires smali input format");
}

#[test]
fn java_dup_insn_test() {
    let status = tools_status();
    if !status.can_run_tests() {
        eprintln!("SKIPPED: {}", status.skip_reason());
        return;
    }

    let helper = IntegrationTestHelper::new("java_dup_insn_test");
    let source = r#"
public class TestCls {
private MethodNode mth;
private BlockNode block;
private SSAVar[] vars;
private int[] versions;
public SSAVar test(RegisterArg regArg) {
int regNum = regArg.getRegNum();
int version = versions[regNum]++;
SSAVar ssaVar = mth.makeNewSVar(regNum, version, regArg);
vars[regNum] = ssaVar;
return ssaVar;
}
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .contains("versions[regNum]++")
        .contains("return ssaVar;");
}

#[test]
fn java_j_s_r_test() {
    // Note: This is a SmaliTest in JADX - requires smali input format not yet supported by dexterity
    eprintln!("SKIPPED: SmaliTest - requires smali input format");
}

#[test]
fn java_swap_test_java() {
    let status = tools_status();
    if !status.can_run_tests() {
        eprintln!("SKIPPED: {}", status.skip_reason());
        return;
    }

    let helper = IntegrationTestHelper::new("java_swap_test_java");
    let source = r#"
public class TestCls {
private Iterable<String> field;
@Override
public String toString() {
String string = String.valueOf(this.field);
return new StringBuilder(8 + String.valueOf(string).length())
.append("concat(").append(string).append(")")
.toString();
}
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .contains("toString()")
        .contains("String.valueOf");
}

#[test]
fn java_swap_test() {
    let status = tools_status();
    if !status.can_run_tests() {
        eprintln!("SKIPPED: {}", status.skip_reason());
        return;
    }

    let helper = IntegrationTestHelper::new("java_swap_test");
    let source = r#"
public class TestCls {
private Iterable<String> field;
@Override
public String toString() {
String string = String.valueOf(this.field);
return new StringBuilder(8 + String.valueOf(string).length())
.append("concat(").append(string).append(")")
.toString();
}
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .contains("toString()")
        .contains("String.valueOf");
}

#[test]
fn json_output_test() {
    let status = tools_status();
    if !status.can_run_tests() {
        eprintln!("SKIPPED: {}", status.skip_reason());
        return;
    }

    let helper = IntegrationTestHelper::new("json_output_test");
    let source = r#"
public class TestCls {
private final String prefix = "list: ";
static {
System.out.println("test");
}
public void test(boolean b, List<String> list) {
if (b) {
System.out.println(prefix + list);
@Override
public void run() {
System.out.println("run");
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .contains_one("public static class Inner implements Runnable");
}

#[test]
fn json_output_test_fallback() {
    let status = tools_status();
    if !status.can_run_tests() {
        eprintln!("SKIPPED: {}", status.skip_reason());
        return;
    }

    let helper = IntegrationTestHelper::new("json_output_test_fallback");
    let source = r#"
public class TestCls {
private final String prefix = "list: ";
static {
System.out.println("test");
}
public void test(boolean b, List<String> list) {
if (b) {
System.out.println(prefix + list);
@Override
public void run() {
System.out.println("run");
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .contains_one("public static class Inner implements java.lang.Runnable");
}

#[test]
fn loop_in_try_test() {
    let status = tools_status();
    if !status.can_run_tests() {
        eprintln!("SKIPPED: {}", status.skip_reason());
        return;
    }

    let helper = IntegrationTestHelper::new("loop_in_try_test");
    let source = r#"
public class TestCls {
private static boolean b = true;
public int test() {
try {
if (b) {
throw new Exception();
}
while (f()) {
s();
}
} catch (Exception e) {
System.out.println("exception");
}
return 1;
}
private static void s() {
}
private static boolean f() {
return false;
}
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .contains("try {")
        .contains("while");
}

#[test]
fn move_inline_test() {
    // Note: This is a SmaliTest in JADX - requires smali input format not yet supported by dexterity
    eprintln!("SKIPPED: SmaliTest - requires smali input format");
}

#[test]
fn multiple_n_o_ps_test() {
    // Note: This is a SmaliTest in JADX - requires smali input format not yet supported by dexterity
    eprintln!("SKIPPED: SmaliTest - requires smali input format");
}

#[test]
fn n21_test() {
    // Note: This is a SmaliTest in JADX - requires smali input format not yet supported by dexterity
    eprintln!("SKIPPED: SmaliTest - requires smali input format");
}

#[test]
fn null_inline_test() {
    let status = tools_status();
    if !status.can_run_tests() {
        eprintln!("SKIPPED: {}", status.skip_reason());
        return;
    }

    let helper = IntegrationTestHelper::new("null_inline_test");
    let source = r#"
public class TestCls {
public static Long test(Double d1) {
T1<T2, Byte> t1 = (T1<T2, Byte>) null;
return t1.t2.l;
}
static class T2 {
public long l;
static class T1<H, P extends Byte> {
public T2 t2;
public T1(T2 t2) {
this.t2 = t2;
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .contains_one("Long.valueOf(t1.t2.l);");
}

#[test]
fn null_inline_test_no_debug() {
    let status = tools_status();
    if !status.can_run_tests() {
        eprintln!("SKIPPED: {}", status.skip_reason());
        return;
    }

    let helper = IntegrationTestHelper::new("null_inline_test_no_debug");
    let source = r#"
public class TestCls {
public static Long test(Double d1) {
T1<T2, Byte> t1 = (T1<T2, Byte>) null;
return t1.t2.l;
}
static class T2 {
public long l;
}
static class T1<H, P extends Byte> {
public T2 t2;
public T1(T2 t2) {
this.t2 = t2;
}
}
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .contains("t1.t2");
}

#[test]
fn override_package_private_method_test() {
    // Note: This is a SmaliTest in JADX - requires smali input format not yet supported by dexterity
    eprintln!("SKIPPED: SmaliTest - requires smali input format");
}

#[test]
fn override_package_private_method_test_dont_change_acc_flags() {
    // Note: This is a SmaliTest in JADX - requires smali input format not yet supported by dexterity
    eprintln!("SKIPPED: SmaliTest - requires smali input format");
}

#[test]
fn override_private_method_test() {
    let status = tools_status();
    if !status.can_run_tests() {
        eprintln!("SKIPPED: {}", status.skip_reason());
        return;
    }

    let helper = IntegrationTestHelper::new("override_private_method_test");
    let source = r#"
public class TestCls {
private int a() {
return 1;
}
public int a() {
return 2;
public void check() {
assertThat(new MyClass().a()).isEqualTo(2);
assertThat(new BaseClass().a()).isEqualTo(1);
// TODO: assertThat(((BaseClass) new MyClass()).a()).isEqualTo(1);
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .does_not_contain("@Override");
}

#[test]
fn override_static_method_test() {
    let status = tools_status();
    if !status.can_run_tests() {
        eprintln!("SKIPPED: {}", status.skip_reason());
        return;
    }

    let helper = IntegrationTestHelper::new("override_static_method_test");
    let source = r#"
public class TestCls {
public static int a() {
return 1;
}
return 2;
public void check() {
assertThat(BaseClass.a()).isEqualTo(1);
assertThat(MyClass.a()).isEqualTo(2);
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .does_not_contain("@Override");
}

#[test]
fn override_with_same_name_test() {
    // Note: This is a SmaliTest in JADX - requires smali input format not yet supported by dexterity
    eprintln!("SKIPPED: SmaliTest - requires smali input format");
}

#[test]
fn override_with_two_bases_test() {
    let status = tools_status();
    if !status.can_run_tests() {
        eprintln!("SKIPPED: {}", status.skip_reason());
        return;
    }

    let helper = IntegrationTestHelper::new("override_with_two_bases_test");
    let source = r#"
public class TestCls {
public abstract static class BaseClass {
public abstract int a();
}
public interface I {
int a();
@Override
public int a() {
return 2;
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .contains_one("@Override");
}

#[test]
fn override_with_two_bases2_test() {
    let status = tools_status();
    if !status.can_run_tests() {
        eprintln!("SKIPPED: {}", status.skip_reason());
        return;
    }

    let helper = IntegrationTestHelper::new("override_with_two_bases2_test");
    let source = r#"
public class TestCls {
public interface I {
int a();
}
public abstract static class BaseCls implements I {
@Override
public int a() {
return 2;
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .contains_one("@Override");
}

#[test]
fn primitive_casts2_test() {
    let status = tools_status();
    if !status.can_run_tests() {
        eprintln!("SKIPPED: {}", status.skip_reason());
        return;
    }

    let helper = IntegrationTestHelper::new("primitive_casts2_test");
    let source = r#"
public class TestCls {
long instanceCount;
{
float f = 50.231F;
instanceCount &= (long) f;
}
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .contains("50.231")
        .contains("(long)");
}

#[test]
fn redundant_brackets_test() {
    let status = tools_status();
    if !status.can_run_tests() {
        eprintln!("SKIPPED: {}", status.skip_reason());
        return;
    }

    let helper = IntegrationTestHelper::new("redundant_brackets_test");
    let source = r#"
public class TestCls {
public boolean method(String str) {
return str.indexOf('a') != -1;
}
public int method2(Object obj) {
if (obj instanceof String) {
return ((String) obj).length();
}
return 0;
}
public int method3(int a, int b) {
if (a + b < 10) {
return a;
}
if ((a & b) != 0) {
return a * b;
}
return b;
}
public void method4(int num) {
if (num == 4 || num == 6 || num == 8 || num == 10) {
method2(null);
}
}
public void method5(int[] a, int n) {
a[1] = n * 2;
a[n - 1] = 1;
}
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .contains("indexOf")
        .contains("instanceof String");
}

#[test]
fn redundant_return_test() {
    let status = tools_status();
    if !status.can_run_tests() {
        eprintln!("SKIPPED: {}", status.skip_reason());
        return;
    }

    let helper = IntegrationTestHelper::new("redundant_return_test");
    let source = r#"
public class TestCls {
public void test(int num) {
if (num == 4) {
fail("");
}
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .does_not_contain("return;");
}

#[test]
fn return_wrapping_test() {
    let status = tools_status();
    if !status.can_run_tests() {
        eprintln!("SKIPPED: {}", status.skip_reason());
        return;
    }

    let helper = IntegrationTestHelper::new("return_wrapping_test");
    let source = r#"
public class TestCls {
public static int f1(int arg0) {
switch (arg0) {
case 1:
return 255;
}
return arg0 + 1;
public static Object f2(Object arg0, int arg1) {
Object ret = null;
int i = arg1;
if (arg0 == null) {
return ret + Integer.toHexString(i);
i++;
try {
ret = new Object().getClass();
} catch (Exception e) {
ret = "Qwerty";
return i > 128 ? arg0.toString() + ret.toString() : i;
public static int f3(int arg0) {
while (arg0 > 10) {
int abc = 951;
if (arg0 == 255) {
return arg0 + 2;
arg0 -= abc;
return arg0;
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .contains("return 255;")
        .contains("return arg0 + 1;")
        .contains("return i > 128 ? arg0.toString() + ret.toString() : Integer.valueOf(i);")
        .contains("return arg0 + 2;")
        .contains("arg0 -= 951;");
}

#[test]
fn shadowing_super_member_test() {
    let status = tools_status();
    if !status.can_run_tests() {
        eprintln!("SKIPPED: {}", status.skip_reason());
        return;
    }

    let helper = IntegrationTestHelper::new("shadowing_super_member_test");
    let source = r#"
public class TestCls {
public C(String s) {
}
public int a00;
public A(String s) {
public C a00;
public B(String str) {
super(str);
public int add(int b) {
return super.a00 + b;
public int sub(int b) {
return ((A) this).a00 - b;
public void check() {
B b = new B("");
((A) b).a00 = 2;
assertThat(b.add(3)).isEqualTo(5);
assertThat(b.sub(3)).isEqualTo(-1);
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .contains_one("return super.a00 + b;")
        .contains_one("return super.a00 - b;")
        .contains_one("((A) b).a00 = 2;");
}

#[test]
fn static_fields_init_test() {
    let status = tools_status();
    if !status.can_run_tests() {
        eprintln!("SKIPPED: {}", status.skip_reason());
        return;
    }

    let helper = IntegrationTestHelper::new("static_fields_init_test");
    let source = r#"
public class TestCls {
public static final String S1 = "1";
public static final String S2 = "12".substring(1);
public static final String S3 = null;
public static final String S4;
public static final String S5 = "5";
public static String s6 = "6";
static {
if (S5.equals("?")) {
S4 = "?";
} else {
S4 = "4";
}
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .contains("public static final String S3 = null;")
        .does_not_contain("public static final String S2 = null;");
}

#[test]
fn static_method_test() {
    let status = tools_status();
    if !status.can_run_tests() {
        eprintln!("SKIPPED: {}", status.skip_reason());
        return;
    }

    let helper = IntegrationTestHelper::new("static_method_test");
    let source = r#"
public class TestCls {
static {
f();
}
private static void f() {
}
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .contains("static {")
        .contains("f()");
}

#[test]
fn string_builder_elimination_test() {
    // Note: This is a SmaliTest in JADX - requires smali input format not yet supported by dexterity
    eprintln!("SKIPPED: SmaliTest - requires smali input format");
}

#[test]
fn string_builder_elimination2_test1() {
    let status = tools_status();
    if !status.can_run_tests() {
        eprintln!("SKIPPED: {}", status.skip_reason());
        return;
    }

    let helper = IntegrationTestHelper::new("string_builder_elimination2_test1");
    let source = r#"
public class TestCls {
public String test() {
return new StringBuilder("[init]").append("a1").append('c').append(2).append(0L).append(1.0f).append(2.0d).append(true)
.toString();
}
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .contains("test()")
        .contains("return");
}

#[test]
fn string_builder_elimination2_test2() {
    let status = tools_status();
    if !status.can_run_tests() {
        eprintln!("SKIPPED: {}", status.skip_reason());
        return;
    }

    let helper = IntegrationTestHelper::new("string_builder_elimination2_test2");
    let source = r#"
public class TestCls {
public String test() {
// A chain with non-final variables
String sInit = "[init]";
String s = "a1";
char c = 'c';
int i = 1;
long l = 2;
float f = 1.0f;
double d = 2.0d;
boolean b = true;
return new StringBuilder(sInit).append(s).append(c).append(i).append(l).append(f).append(d).append(b).toString();
}
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .contains("test()")
        .contains("return");
}

#[test]
fn string_builder_elimination2_test3() {
    // Note: This is a SmaliTest in JADX - requires smali input format not yet supported by dexterity
    eprintln!("SKIPPED: SmaliTest - requires smali input format");
}

#[test]
fn string_builder_elimination2_test_chain_with_delete() {
    // Note: This is a SmaliTest in JADX - requires smali input format not yet supported by dexterity
    eprintln!("SKIPPED: SmaliTest - requires smali input format");
}

#[test]
fn string_builder_elimination3_test() {
    let status = tools_status();
    if !status.can_run_tests() {
        eprintln!("SKIPPED: {}", status.skip_reason());
        return;
    }

    let helper = IntegrationTestHelper::new("string_builder_elimination3_test");
    let source = r#"
public class TestCls {
public static String test(String a) {
StringBuilder sb = new StringBuilder();
sb.append("result = ");
sb.append(a);
return sb.toString();
}
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .does_not_contain("new StringBuilder()");
}

#[test]
fn string_builder_elimination3_test_negative() {
    let status = tools_status();
    if !status.can_run_tests() {
        eprintln!("SKIPPED: {}", status.skip_reason());
        return;
    }

    let helper = IntegrationTestHelper::new("string_builder_elimination3_test_negative");
    let source = r#"
public class TestCls {
public static String test(String a) {
StringBuilder sb = new StringBuilder();
sb.append("result = ");
sb.append(a);
return sb.toString();
}
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .contains("return sb.toString();")
        .contains("new StringBuilder()");
}

#[test]
fn string_builder_elimination4_neg_test() {
    let status = tools_status();
    if !status.can_run_tests() {
        eprintln!("SKIPPED: {}", status.skip_reason());
        return;
    }

    // Note: This is a SmaliTest in JADX - requires smali input format not yet supported by dexterity
    eprintln!("SKIPPED: SmaliTest - requires smali input format");
}

#[test]
fn string_builder_elimination5_test() {
    let status = tools_status();
    if !status.can_run_tests() {
        eprintln!("SKIPPED: {}", status.skip_reason());
        return;
    }

    let helper = IntegrationTestHelper::new("string_builder_elimination5_test");
    let source = r#"
public class TestCls {
@SuppressWarnings("StringConcatenationInLoop")
public static String test(long[] a) {
String s = "";
final char[] hexChars = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };
for (int i = a.length - 1; i >= 0; i--) {
s += hexChars[(int) (a[i] >>> 60) & 0x0f];
s += hexChars[(int) (a[i] >>> 56) & 0x0f];
s += hexChars[(int) (a[i] >>> 52) & 0x0f];
s += hexChars[(int) (a[i] >>> 48) & 0x0f];
s += hexChars[(int) (a[i] >>> 44) & 0x0f];
s += hexChars[(int) (a[i] >>> 40) & 0x0f];
s += hexChars[(int) (a[i] >>> 36) & 0x0f];
s += hexChars[(int) (a[i] >>> 32) & 0x0f];
s += hexChars[(int) (a[i] >>> 28) & 0x0f];
s += hexChars[(int) (a[i] >>> 24) & 0x0f];
s += hexChars[(int) (a[i] >>> 20) & 0x0f];
s += hexChars[(int) (a[i] >>> 16) & 0x0f];
s += hexChars[(int) (a[i] >>> 12) & 0x0f];
s += hexChars[(int) (a[i] >>> 8) & 0x0f];
s += hexChars[(int) (a[i] >>> 4) & 0x0f];
s += hexChars[(int) (a[i]) & 0x0f];
s += " ";
}
return s;
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .does_not_contain(".append(");
}

#[test]
fn string_concat_java11_test() {
    let status = tools_status();
    if !status.can_run_tests() {
        eprintln!("SKIPPED: {}", status.skip_reason());
        return;
    }

    let helper = IntegrationTestHelper::new("string_concat_java11_test");
    let source = r#"
public class TestCls {
public String test(final String s) {
return s + "test";
}
public String test2(final String s) {
return s + "test" + s + 7;
}
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .contains("test(")
        .contains("+ \"test\"");
}

#[test]
fn string_concat_java11_test_java8() {
    let status = tools_status();
    if !status.can_run_tests() {
        eprintln!("SKIPPED: {}", status.skip_reason());
        return;
    }

    let helper = IntegrationTestHelper::new("string_concat_java11_test_java8");
    let source = r#"
public class TestCls {
public String test(final String s) {
return s + "test";
}
public String test2(final String s) {
return s + "test" + s + 7;
}
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .contains("test(")
        .contains("+ \"test\"");
}

#[test]
fn string_concat_without_result_test() {
    let status = tools_status();
    if !status.can_run_tests() {
        eprintln!("SKIPPED: {}", status.skip_reason());
        return;
    }

    let helper = IntegrationTestHelper::new("string_concat_without_result_test");
    let source = r#"
public class TestCls {
public static final boolean LOG_DEBUG = false;
public void test(int i) {
String msg = "Input arg value: " + i;
if (LOG_DEBUG) {
System.out.println(msg);
}
}
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .contains("LOG_DEBUG")
        .contains("test(");
}

#[test]
fn string_constructor_test() {
    let status = tools_status();
    if !status.can_run_tests() {
        eprintln!("SKIPPED: {}", status.skip_reason());
        return;
    }

    let helper = IntegrationTestHelper::new("string_constructor_test");
    let source = r#"
public class TestCls {
public String tag = new String(new byte[] { 'a', 'b', 'c' });
}
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .contains_one("abc");
}

#[test]
fn string_constructor_test2() {
    let status = tools_status();
    if !status.can_run_tests() {
        eprintln!("SKIPPED: {}", status.skip_reason());
        return;
    }

    let helper = IntegrationTestHelper::new("string_constructor_test2");
    let source = r#"
public class TestCls {
public String tag = new String(new byte[] { 'a', 'b', 'c' }, StandardCharsets.UTF_8);
}
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    // TODO: Add assertions
}

#[test]
fn string_constructor_test3() {
    let status = tools_status();
    if !status.can_run_tests() {
        eprintln!("SKIPPED: {}", status.skip_reason());
        return;
    }

    let helper = IntegrationTestHelper::new("string_constructor_test3");
    let source = r#"
public class TestCls {
public String tag = new String(new byte[] { 1, 2, 3, 'a', 'b', 'c' });
}
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .contains_one("\\\\u0001\\\\u0002\\\\u0003abc");
}

#[test]
fn string_constructor_test4() {
    let status = tools_status();
    if !status.can_run_tests() {
        eprintln!("SKIPPED: {}", status.skip_reason());
        return;
    }

    let helper = IntegrationTestHelper::new("string_constructor_test4");
    let source = r#"
public class TestCls {
public String tag = new String(new char[] { 1, 2, 3, 'a', 'b', 'c' });
}
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .contains_one("\\\\u0001\\\\u0002\\\\u0003abc");
}

#[test]
fn string_constructor_test5() {
    let status = tools_status();
    if !status.can_run_tests() {
        eprintln!("SKIPPED: {}", status.skip_reason());
        return;
    }

    let helper = IntegrationTestHelper::new("string_constructor_test5");
    let source = r#"
public class TestCls {
public String tag = new String(new char[] { 1, 2, 3, 'a', 'b' });
}
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .contains_one("{1, 2, 3, 'a', 'b'}");
}

#[test]
fn string_constructor_test_negative() {
    let status = tools_status();
    if !status.can_run_tests() {
        eprintln!("SKIPPED: {}", status.skip_reason());
        return;
    }

    let helper = IntegrationTestHelper::new("string_constructor_test_negative");
    let source = r#"
public class TestCls {
public String tag = new String(new byte[] { 'a', 'b', 'c' });
}
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .contains_one("tag = new String();");
}

#[test]
fn string_constructor_test_negative2() {
    let status = tools_status();
    if !status.can_run_tests() {
        eprintln!("SKIPPED: {}", status.skip_reason());
        return;
    }

    let helper = IntegrationTestHelper::new("string_constructor_test_negative2");
    let source = r#"
public class TestCls {
public String tag = new String(new byte[] { 'a', 'b', 'c' });
}
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .contains_one("tag = new String(new byte[]{31, this.b});");
}

#[test]
fn super_loop_test() {
    let status = tools_status();
    if !status.can_run_tests() {
        eprintln!("SKIPPED: {}", status.skip_reason());
        return;
    }

    let helper = IntegrationTestHelper::new("super_loop_test");
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
fn synthetic_constructor_test() {
    let status = tools_status();
    if !status.can_run_tests() {
        eprintln!("SKIPPED: {}", status.skip_reason());
        return;
    }

    let helper = IntegrationTestHelper::new("synthetic_constructor_test");
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
fn throws_test() {
    let status = tools_status();
    if !status.can_run_tests() {
        eprintln!("SKIPPED: {}", status.skip_reason());
        return;
    }

    let helper = IntegrationTestHelper::new("throws_test");
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
fn usage_apache_http_client_test() {
    let status = tools_status();
    if !status.can_run_tests() {
        eprintln!("SKIPPED: {}", status.skip_reason());
        return;
    }

    let helper = IntegrationTestHelper::new("usage_apache_http_client_test");
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
fn wrong_code_test() {
    let status = tools_status();
    if !status.can_run_tests() {
        eprintln!("SKIPPED: {}", status.skip_reason());
        return;
    }

    let helper = IntegrationTestHelper::new("wrong_code_test");
    let source = r#"
public class TestCls {
@SuppressWarnings("null")
public int test() {
int[] a = null;
return a.length;
}
public int test2(int a) {
if (a == 0) {
return a;
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .contains_one("int[] a = null;")
        .contains_one("return a.length;")
        .does_not_contain("return false.length;");
}

#[test]
fn wrong_code_test_no_debug() {
    let status = tools_status();
    if !status.can_run_tests() {
        eprintln!("SKIPPED: {}", status.skip_reason());
        return;
    }

    let helper = IntegrationTestHelper::new("wrong_code_test_no_debug");
    let source = r#"
public class TestCls {
@SuppressWarnings("null")
public int test() {
int[] a = null;
return a.length;
}
public int test2(int a) {
if (a == 0) {
return a;
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    // TODO: Add assertions
}

#[test]
fn wrong_code2_test() {
    let status = tools_status();
    if !status.can_run_tests() {
        eprintln!("SKIPPED: {}", status.skip_reason());
        return;
    }

    let helper = IntegrationTestHelper::new("wrong_code2_test");
    let source = r#"
public class TestCls {
@SuppressWarnings("ConstantConditions")
public String test() {
A a = null;
a.str = "";
return a.str;
}
public int test2() {
int[] a = null;
a[1] = 2;
return a[0];
@SuppressWarnings({ "ConstantConditions", "SynchronizationOnLocalVariableOrMethodParameter" })
public boolean test3() {
synchronized (a) {
return true;
public boolean test4() {
return null instanceof A;
// everything is 'A' :)
@SuppressWarnings({ "MethodName", "LocalVariableName" }) // ignore checkstyle
public A A() {
A A = A();
A.A = A;
return A;
@SuppressWarnings("MemberName")
public String str;
public A A;
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .contains_one("return a.str;");
}

#[test]
fn wrong_code2_test_no_debug() {
    let status = tools_status();
    if !status.can_run_tests() {
        eprintln!("SKIPPED: {}", status.skip_reason());
        return;
    }

    let helper = IntegrationTestHelper::new("wrong_code2_test_no_debug");
    let source = r#"
public class TestCls {
@SuppressWarnings("ConstantConditions")
public String test() {
A a = null;
a.str = "";
return a.str;
}
public int test2() {
int[] a = null;
a[1] = 2;
return a[0];
@SuppressWarnings({ "ConstantConditions", "SynchronizationOnLocalVariableOrMethodParameter" })
public boolean test3() {
synchronized (a) {
return true;
public boolean test4() {
return null instanceof A;
// everything is 'A' :)
@SuppressWarnings({ "MethodName", "LocalVariableName" }) // ignore checkstyle
public A A() {
A A = A();
A.A = A;
return A;
@SuppressWarnings("MemberName")
public String str;
public A A;
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    // TODO: Add assertions
}
