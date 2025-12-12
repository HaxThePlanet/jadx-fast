//! Types integration tests
//! Ported from jadx-core/src/test/java/jadx/tests/integration/types/

mod integration_test_framework;
use integration_test_framework::{IntegrationTestHelper, CodeAssertions};

#[test]
fn array_types_test() {
    let helper = IntegrationTestHelper::new("array_types_test");
    let source = r#"
public class TestCls {
public void test() {
Exception e = new Exception();
System.out.println(e);
use(new Object[] { e });
}
public void use(Object[] arr) {
public void check() {
test();
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .contains_one("use(new Object[]{e});");
}

#[test]
fn array_types_test_no_debug() {
    let helper = IntegrationTestHelper::new("array_types_test_no_debug");
    let source = r#"
public class TestCls {
public void test() {
Exception e = new Exception();
System.out.println(e);
use(new Object[] { e });
}
public void use(Object[] arr) {
public void check() {
test();
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .contains_one("use(new Object[]{exc});");
}

#[test]
fn const_inline_test() {
    let helper = IntegrationTestHelper::new("const_inline_test");
    // TODO: Extract test source
    let source = r#"
public class TestCls {
    // Add test code here
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .contains_one("list = null;")
        .contains_one("str = null;");
}

#[test]
fn const_type_inference_test() {
    let helper = IntegrationTestHelper::new("const_type_inference_test");
    let source = r#"
public class TestCls {
private final int a;
public TestCls() {
this(0);
}
public TestCls(int a) {
this.a = a;
public boolean equals(Object obj) {
if (obj == this) {
return true;
if (obj != null) {
if (getClass() == obj.getClass()) {
TestCls other = (TestCls) obj;
return this.a == other.a;
return false;
public void check() {
TestCls seven = new TestCls(7);
assertThat(seven).isEqualTo(seven);
assertThat(seven).isNotEqualTo(null);
TestCls six = new TestCls(6);
assertThat(six).isNotEqualTo(seven);
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .contains_one("obj == this");
}

#[test]
fn const_type_inference_test2() {
    let helper = IntegrationTestHelper::new("const_type_inference_test2");
    let source = r#"
public class TestCls {
private final int a;
public TestCls() {
this(0);
}
public TestCls(int a) {
this.a = a;
public boolean equals(Object obj) {
if (obj == this) {
return true;
if (obj != null) {
if (getClass() == obj.getClass()) {
TestCls other = (TestCls) obj;
return this.a == other.a;
return false;
public void check() {
TestCls seven = new TestCls(7);
assertThat(seven).isEqualTo(seven);
assertThat(seven).isNotEqualTo(null);
TestCls six = new TestCls(6);
assertThat(six).isNotEqualTo(seven);
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    // TODO: Add assertions
}

#[test]
fn field_access_test() {
    let helper = IntegrationTestHelper::new("field_access_test");
    let source = r#"
public class TestCls {
private String field;
static <T extends TestCls> T testPut(T t) {
((TestCls) t).field = "";
return t;
}
static <T extends TestCls> T testGet(T t) {
System.out.println(((TestCls) t).field);
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .does_not_contain("t.field");
}

#[test]
fn field_cast_test() {
    let helper = IntegrationTestHelper::new("field_cast_test");
    let source = r#"
public class TestCls {
public boolean publicField;
boolean packagePrivateField;
protected boolean protectedField;
private boolean privateField;
}
public void test() {
((A) this).publicField = false;
((A) this).protectedField = false;
((A) this).packagePrivateField = false;
((A) this).privateField = false; // cast to 'A' needed only here
public void test(B b) {
((A) b).publicField = false;
((A) b).protectedField = false;
((A) b).packagePrivateField = false;
((A) b).privateField = false; // cast to 'A' needed only here
public <T extends B> void test(T t) {
((A) t).publicField = false;
((A) t).protectedField = false;
((A) t).packagePrivateField = false;
((A) t).privateField = false; // cast to 'A' needed only here
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .contains_one("((A) this)")
        .contains_one("((A) b)")
        .contains_one("((A) t)")
        .does_not_contain("unused =")
        .does_not_contain("access modifiers changed");
}

#[test]
fn generics_test() {
    let helper = IntegrationTestHelper::new("generics_test");
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
fn generics_test2() {
    let helper = IntegrationTestHelper::new("generics_test2");
    // TODO: Extract test source
    let source = r#"
public class TestCls {
    // Add test code here
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .contains_one("TestCls<T> data(T t) {");
}

#[test]
fn generics2_test() {
    let helper = IntegrationTestHelper::new("generics2_test");
    // TODO: Extract test source
    let source = r#"
public class TestCls {
    // Add test code here
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .contains_one("for (Map.Entry<Integer, String> entry : map.entrySet()) {")
        .contains_one("useInt(entry.getKey().intValue());")
        .contains_one("entry.getValue().trim();");
}

#[test]
fn generics3_test() {
    let helper = IntegrationTestHelper::new("generics3_test");
    let source = r#"
public class TestCls {
public static void test() {
List<String> classes = getClasses();
Collections.sort(classes);
int passed = 0;
for (String cls : classes) {
if (runTest(cls)) {
passed++;
}
int failed = classes.size() - passed;
System.out.println("failed: " + failed);
private static boolean runTest(String clsName) {
return false;
private static List<String> getClasses() {
return new ArrayList<>();
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .contains_one("List<String> classes")
        .contains_one("for (String cls : classes) {")
        .contains_one("List<String> classes");
}

#[test]
fn generics3_test_no_debug() {
    let helper = IntegrationTestHelper::new("generics3_test_no_debug");
    let source = r#"
public class TestCls {
public static void test() {
List<String> classes = getClasses();
Collections.sort(classes);
int passed = 0;
for (String cls : classes) {
if (runTest(cls)) {
passed++;
}
int failed = classes.size() - passed;
System.out.println("failed: " + failed);
private static boolean runTest(String clsName) {
return false;
private static List<String> getClasses() {
return new ArrayList<>();
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .contains_one("List<String> classes");
}

#[test]
fn generics4_test() {
    let helper = IntegrationTestHelper::new("generics4_test");
    let source = r#"
public class TestCls {
public void overload(IList<? super T> list) {
}
public void overload(T t) {
public interface IList<T> {
void list(T t);
@Override
public void list(Object o) {
public Inner<Object> test() {
Inner<Object> inner = new Inner<>();
inner.overload(new ObjIList());
return inner;
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .contains_one("public static class ObjIList implements IList<Object> {")
        .contains_one("Inner<Object> inner = new Inner<>();")
        .contains_one("inner.overload((IList<? super Object>) new ObjIList());")
        .contains_one("inner.overload(new ObjIList());");
}

#[test]
fn generics4_test_omit_cast() {
    let helper = IntegrationTestHelper::new("generics4_test_omit_cast");
    let source = r#"
public class TestCls {
public void overload(IList<? super T> list) {
}
public void overload(T t) {
public interface IList<T> {
void list(T t);
@Override
public void list(Object o) {
public Inner<Object> test() {
Inner<Object> inner = new Inner<>();
inner.overload(new ObjIList());
return inner;
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .contains_one("inner.overload(new ObjIList());");
}

#[test]
fn generics5_test() {
    let helper = IntegrationTestHelper::new("generics5_test");
    let source = r#"
public class TestCls {
private InheritableThreadLocal<Map<String, String>> inheritableThreadLocal;
public void test(String key, String val) {
if (key == null) {
throw new IllegalArgumentException("key cannot be null");
}
Map<String, String> map = this.inheritableThreadLocal.get();
if (map == null) {
map = new HashMap<>();
this.inheritableThreadLocal.set(map);
map.put(key, val);
public void remove(String key) {
if (map != null) {
map.remove(key);
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .count_string(2, "Map<String, String> map = this.inheritableThreadLocal.get();");
}

#[test]
fn generics6_test() {
    let helper = IntegrationTestHelper::new("generics6_test");
    // TODO: Extract test source
    let source = r#"
public class TestCls {
    // Add test code here
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .contains_one("Entry<K, V> entry = get(k);")
        .does_not_contain("Entry entry = get(k);");
}

#[test]
fn generics7_test() {
    let helper = IntegrationTestHelper::new("generics7_test");
    // TODO: Extract test source
    let source = r#"
public class TestCls {
    // Add test code here
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .contains_one("T t = (T) objArr[i];");
}

#[test]
fn generics8_test() {
    let helper = IntegrationTestHelper::new("generics8_test");
    // TODO: Extract test source
    let source = r#"
public class TestCls {
    // Add test code here
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .contains_one("S s = get();")
        .contains_one("s.i1();")
        .contains_one("s.i2();");
}

#[test]
fn generics_in_full_inner_cls_test() {
    let helper = IntegrationTestHelper::new("generics_in_full_inner_cls_test");
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
fn generics_in_full_inner_cls_test_with_deobf() {
    let helper = IntegrationTestHelper::new("generics_in_full_inner_cls_test_with_deobf");
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
fn generics_in_full_inner_cls_test_with_full_names() {
    let helper = IntegrationTestHelper::new("generics_in_full_inner_cls_test_with_full_names");
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
fn interfaces_cast_test() {
    let helper = IntegrationTestHelper::new("interfaces_cast_test");
    let source = r#"
public class TestCls {
public Runnable test(Closeable obj) throws IOException {
return (Runnable) obj;
}
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .contains_one("return (Runnable) closeable;");
}

#[test]
fn primitive_conversion_test() {
    let helper = IntegrationTestHelper::new("primitive_conversion_test");
    // TODO: Extract test source
    let source = r#"
public class TestCls {
    // Add test code here
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .contains_one("putByte(j, z ? (byte) 1 : (byte) 0);")
        .does_not_contain("putByte(j, z);");
}

#[test]
fn primitive_conversion2_test() {
    let helper = IntegrationTestHelper::new("primitive_conversion2_test");
    // TODO: Extract test source
    let source = r#"
public class TestCls {
    // Add test code here
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .contains_one("boolean z2 = !convertedPrice2.code.equals(itemCurrency.code);")
        .contains_one("(z2 ? 1 : 0) | 2")
        .contains_one("if (z2 && currency != null) {")
        .contains_one("i = 1;")
        .does_not_contain("z2 == 0")
        .does_not_contain("z2 | 2");
}

#[test]
fn primitives_in_if_test() {
    let helper = IntegrationTestHelper::new("primitives_in_if_test");
    let source = r#"
public class TestCls {
public boolean test(String str) {
short sh = Short.parseShort(str);
int i = Integer.parseInt(str);
System.out.println(sh + " vs " + i);
return sh == i;
}
public void check() {
assertThat(test("1")).isTrue();
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .contains_one("short sh = Short.parseShort(str);")
        .contains_one("int i = Integer.parseInt(str);")
        .contains_one("return sh == i;");
}

#[test]
fn primitives_in_if_test2() {
    let helper = IntegrationTestHelper::new("primitives_in_if_test2");
    let source = r#"
public class TestCls {
public boolean test(String str) {
short sh = Short.parseShort(str);
int i = Integer.parseInt(str);
System.out.println(sh + " vs " + i);
return sh == i;
}
public void check() {
assertThat(test("1")).isTrue();
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .contains_one("short s = Short.parseShort(str);");
}

#[test]
fn type_inheritance_test() {
    let helper = IntegrationTestHelper::new("type_inheritance_test");
    let source = r#"
public class TestCls {
public interface IRoot {
}
public interface IBase extends IRoot {
public void b() {
public static void test(boolean z) {
IBase impl;
if (z) {
impl = new A();
} else {
B b = new B();
b.b();
impl = b; // this move is removed in no-debug byte-code
useBase(impl);
useRoot(impl);
private static void useRoot(IRoot root) {
private static void useBase(IBase base) {
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .contains_one("IBase impl;")
        .contains_one("impl = new A();")
        .contains_one("B b = new B();")
        .contains_one("impl = b;");
}

#[test]
fn type_inheritance_test_no_debug() {
    let helper = IntegrationTestHelper::new("type_inheritance_test_no_debug");
    let source = r#"
public class TestCls {
public interface IRoot {
}
public interface IBase extends IRoot {
public void b() {
public static void test(boolean z) {
IBase impl;
if (z) {
impl = new A();
} else {
B b = new B();
b.b();
impl = b; // this move is removed in no-debug byte-code
useBase(impl);
useRoot(impl);
private static void useRoot(IRoot root) {
private static void useBase(IBase base) {
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    // TODO: Add assertions
}

#[test]
fn type_resolver_test() {
    let helper = IntegrationTestHelper::new("type_resolver_test");
    let source = r#"
public class TestCls {
public TestCls(int b1, int b2) {
// test 'this' move and constructor invocation on moved register
this(b1, b2, 0, 0, 0);
}
public TestCls(int a1, int a2, int a3, int a4, int a5) {
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .contains("this(b1, b2, 0, 0, 0);")
        .does_not_contain("= this;");
}

#[test]
fn type_resolver10_test() {
    let helper = IntegrationTestHelper::new("type_resolver10_test");
    // TODO: Extract test source
    let source = r#"
public class TestCls {
    // Add test code here
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .contains_one("Object test(String str, String str2)")
        .does_not_contain("Object obj2 = 0;");
}

#[test]
fn type_resolver11_test() {
    let helper = IntegrationTestHelper::new("type_resolver11_test");
    let source = r#"
public class TestCls {
public Void test(Object... objects) {
int val = (Integer) objects[0];
String str = (String) objects[1];
call(str, str, val, val);
return null;
}
private void call(String a, String b, int... val) {
private boolean test2(String s1, String... args) {
String str = Arrays.toString(args);
return s1.length() + str.length() > 0;
public void check() {
test(1, "str");
assertThat(test2("1", "2", "34")).isTrue();
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .contains_one("(Integer) objects[0]")
        .contains_one("String str = (String) objects[1];");
}

#[test]
fn type_resolver11_test_no_debug() {
    let helper = IntegrationTestHelper::new("type_resolver11_test_no_debug");
    let source = r#"
public class TestCls {
public Void test(Object... objects) {
int val = (Integer) objects[0];
String str = (String) objects[1];
call(str, str, val, val);
return null;
}
private void call(String a, String b, int... val) {
private boolean test2(String s1, String... args) {
String str = Arrays.toString(args);
return s1.length() + str.length() > 0;
public void check() {
test(1, "str");
assertThat(test2("1", "2", "34")).isTrue();
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .contains_one("(Integer) objArr[0]")
        .contains_one("String str = (String) objArr[1];");
}

#[test]
fn type_resolver12_test() {
    let helper = IntegrationTestHelper::new("type_resolver12_test");
    // TODO: Extract test source
    let source = r#"
public class TestCls {
    // Add test code here
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .contains_one("T obj = this.ref.get();");
}

#[test]
fn type_resolver12_test_no_debug() {
    let helper = IntegrationTestHelper::new("type_resolver12_test_no_debug");
    // TODO: Extract test source
    let source = r#"
public class TestCls {
    // Add test code here
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .contains_one("T t = this.ref.get();")
        .does_not_contain("Object obj");
}

#[test]
fn type_resolver13_test() {
    let helper = IntegrationTestHelper::new("type_resolver13_test");
    let source = r#"
public class TestCls {
private static final Set<?> CONST = new HashSet<>();
private Map<Set<?>, List<?>> map = new HashMap<>();
@SuppressWarnings("unchecked")
public <T> List<T> test(Set<T> type) {
List<?> obj = this.map.get(type == null ? CONST : type);
if (obj != null) {
return (List<T>) obj;
}
return null;
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .contains_one("public <T> List<T> test(Set<T> type) {")
        .contains_one("return (List<T>) obj;");
}

#[test]
fn type_resolver14_test() {
    let helper = IntegrationTestHelper::new("type_resolver14_test");
    // TODO: Extract test source
    let source = r#"
public class TestCls {
    // Add test code here
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .does_not_contain("? r2");
}

#[test]
fn type_resolver15_test() {
    let helper = IntegrationTestHelper::new("type_resolver15_test");
    let source = r#"
public class TestCls {
private void test(boolean z) {
useInt(z ? 0 : 8);
useInt(!z ? 1 : 0); // replaced with xor in smali test
}
private void useInt(int i) {
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .contains_one("useInt(!z ? 1 : 0);")
        .contains_one("useInt(z ? 0 : 8);");
}

#[test]
fn type_resolver15_test_smali() {
    let helper = IntegrationTestHelper::new("type_resolver15_test_smali");
    let source = r#"
public class TestCls {
private void test(boolean z) {
useInt(z ? 0 : 8);
useInt(!z ? 1 : 0); // replaced with xor in smali test
}
private void useInt(int i) {
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .contains_one("useInt(z ? 0 : 8);")
        .contains_one("useInt(!z ? 1 : 0);");
}

#[test]
fn type_resolver16_test() {
    let helper = IntegrationTestHelper::new("type_resolver16_test");
    let source = r#"
public class TestCls {
public final <T, K> List<T> test(List<? extends T> list,
Set<? extends T> set, Function<? super T, ? extends K> function) {
if (set != null) {
List<? extends T> union = list != null ? union(list, set, function) : null;
if (union != null) {
list = union;
}
return list != null ? (List<T>) list : emptyList();
public static <T, K> List<T> union(
Collection<? extends T> collection,
Iterable<? extends T> iterable,
Function<? super T, ? extends K> function) {
return null;
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .contains_one("(List<T>) listUnion");
}

#[test]
fn type_resolver16_test_smali() {
    let helper = IntegrationTestHelper::new("type_resolver16_test_smali");
    let source = r#"
public class TestCls {
public final <T, K> List<T> test(List<? extends T> list,
Set<? extends T> set, Function<? super T, ? extends K> function) {
if (set != null) {
List<? extends T> union = list != null ? union(list, set, function) : null;
if (union != null) {
list = union;
}
return list != null ? (List<T>) list : emptyList();
public static <T, K> List<T> union(
Collection<? extends T> collection,
Iterable<? extends T> iterable,
Function<? super T, ? extends K> function) {
return null;
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .contains_one("(List<T>) listUnion");
}

#[test]
fn type_resolver17_test() {
    let helper = IntegrationTestHelper::new("type_resolver17_test");
    // TODO: Extract test source
    let source = r#"
public class TestCls {
    // Add test code here
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .contains_one("Cursor cursorQuery = null;")
        .does_not_contain("(AutoCloseable autoCloseable = ");
}

#[test]
fn type_resolver18_test() {
    let helper = IntegrationTestHelper::new("type_resolver18_test");
    // TODO: Extract test source
    let source = r#"
public class TestCls {
    // Add test code here
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .contains_one("((Closeable) t).close();");
}

#[test]
fn type_resolver19_test() {
    let helper = IntegrationTestHelper::new("type_resolver19_test");
    let source = r#"
public class TestCls {
public static int[] test(byte[] bArr) {
int[] iArr = new int[bArr.length];
for (int i = 0; i < bArr.length; i++) {
iArr[i] = bArr[i];
}
return iArr;
public static int[] test2(byte[] bArr) {
int i2 = bArr[i];
if (i2 < 0) {
i2 = (int) ((long) i2 & 0xFFFF_FFFFL);
iArr[i] = i2;
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .contains_one("iArr[i] = bArr[i];")
        .contains_one("iArr[i] = i2;");
}

#[test]
fn type_resolver2_test() {
    let helper = IntegrationTestHelper::new("type_resolver2_test");
    let source = r#"
public class TestCls {
public static boolean test(Object obj) throws IOException {
if (obj != null) {
return true;
}
throw new IOException();
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .contains_one("if (obj != null) {");
}

#[test]
fn type_resolver20_test_smali() {
    let helper = IntegrationTestHelper::new("type_resolver20_test_smali");
    let source = r#"
public class TestCls {
public interface Sequence<T> {
Iterator<T> iterator();
}
public static <T extends Comparable<? super T>> T max(Sequence<? extends T> seq) {
Iterator<? extends T> it = seq.iterator();
if (!it.hasNext()) {
return null;
T t = it.next();
while (it.hasNext()) {
T next = it.next();
if (t.compareTo(next) < 0) {
t = next;
return t;
private final List<T> list;
@SafeVarargs
public ArraySeq(T... arr) {
this.list = Arrays.asList(arr);
@Override
public Iterator<T> iterator() {
return list.iterator();
public void check() {
assertThat(max(new ArraySeq<>(2, 5, 3, 4))).isEqualTo(5);
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .contains_one("T next = it.next();")
        .contains_one("T next2 = it.next();");
}

#[test]
fn type_resolver21_test() {
    let helper = IntegrationTestHelper::new("type_resolver21_test");
    // TODO: Extract test source
    let source = r#"
public class TestCls {
    // Add test code here
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .contains_one("Object[] arr = (Object[]) objectArray;");
}

#[test]
fn type_resolver24_test_smali() {
    let helper = IntegrationTestHelper::new("type_resolver24_test_smali");
    let source = r#"
public class TestCls {
public void test() {
((T1) null).foo1();
((T2) null).foo2();
}
static class T1 {
public void foo1() {
static class T2 {
public void foo2() {
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .contains_one("((T1) null).foo1();")
        .contains_one("((T2) null).foo2();")
        .does_not_contain("T1 ")
        .does_not_contain("T2 ");
}

#[test]
fn type_resolver25_test_smali() {
    let helper = IntegrationTestHelper::new("type_resolver25_test_smali");
    // TODO: Extract test source
    let source = r#"
public class TestCls {
    // Add test code here
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .contains_one("t = obj;")
        .contains_one("t = (T) obj;");
}

#[test]
fn type_resolver3_test() {
    let helper = IntegrationTestHelper::new("type_resolver3_test");
    let source = r#"
public class TestCls {
public int test(String s1, String s2) {
int cmp = s2.compareTo(s1);
if (cmp != 0) {
return cmp;
}
return s1.length() == s2.length() ? 0 : s1.length() < s2.length() ? -1 : 1;
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    // TODO: Add assertions
}

#[test]
fn type_resolver3_test2() {
    let helper = IntegrationTestHelper::new("type_resolver3_test2");
    let source = r#"
public class TestCls {
public int test(String s1, String s2) {
int cmp = s2.compareTo(s1);
if (cmp != 0) {
return cmp;
}
return s1.length() == s2.length() ? 0 : s1.length() < s2.length() ? -1 : 1;
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    // TODO: Add assertions
}

#[test]
fn type_resolver4_test() {
    let helper = IntegrationTestHelper::new("type_resolver4_test");
    let source = r#"
public class TestCls {
private static String test(byte[] strArray, int offset) {
int len = strArray.length;
int start = offset + f(strArray, offset);
int end = start;
while (end + 1 < len && (strArray[end] != 0 || strArray[end + 1] != 0)) {
end += 2;
}
byte[] arr = Arrays.copyOfRange(strArray, start, end);
return new String(arr);
private static int f(byte[] strArray, int offset) {
return 0;
public void check() {
String test = test(("1234" + "utfstr\0\0" + "4567").getBytes(), 4);
assertThat(test).isEqualTo("utfstr");
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .contains_one("(strArray[end] != 0 || strArray[end + 1] != 0)");
}

#[test]
fn type_resolver4_test2() {
    let helper = IntegrationTestHelper::new("type_resolver4_test2");
    let source = r#"
public class TestCls {
private static String test(byte[] strArray, int offset) {
int len = strArray.length;
int start = offset + f(strArray, offset);
int end = start;
while (end + 1 < len && (strArray[end] != 0 || strArray[end + 1] != 0)) {
end += 2;
}
byte[] arr = Arrays.copyOfRange(strArray, start, end);
return new String(arr);
private static int f(byte[] strArray, int offset) {
return 0;
public void check() {
String test = test(("1234" + "utfstr\0\0" + "4567").getBytes(), 4);
assertThat(test).isEqualTo("utfstr");
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    // TODO: Add assertions
}

#[test]
fn type_resolver5_test() {
    let helper = IntegrationTestHelper::new("type_resolver5_test");
    // TODO: Extract test source
    let source = r#"
public class TestCls {
    // Add test code here
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .does_not_contain("Object string2")
        .does_not_contain("r1v2");
}

#[test]
fn type_resolver6_test() {
    let helper = IntegrationTestHelper::new("type_resolver6_test");
    let source = r#"
public class TestCls {
public final Object obj;
public TestCls(boolean b) {
this.obj = b ? this : makeObj();
}
public Object makeObj() {
return new Object();
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .contains_one("this.obj = b ? this : makeObj();");
}

#[test]
fn type_resolver6_test_no_debug() {
    let helper = IntegrationTestHelper::new("type_resolver6_test_no_debug");
    let source = r#"
public class TestCls {
public final Object obj;
public TestCls(boolean b) {
this.obj = b ? this : makeObj();
}
public Object makeObj() {
return new Object();
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    // TODO: Add assertions
}

#[test]
fn type_resolver6a_test() {
    let helper = IntegrationTestHelper::new("type_resolver6a_test");
    // TODO: Extract test source
    let source = r#"
public class TestCls {
    // Add test code here
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .contains_one("this.runnable = b ? this : makeRunnable();");
}

#[test]
fn type_resolver6a_test_no_debug() {
    let helper = IntegrationTestHelper::new("type_resolver6a_test_no_debug");
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
fn type_resolver7_test() {
    let helper = IntegrationTestHelper::new("type_resolver7_test");
    let source = r#"
public class TestCls {
public void test(boolean a, boolean b) {
Object obj = null;
if (a) {
use(b ? (Exception) getObj() : (Exception) obj);
} else {
Runnable r = (Runnable) obj;
if (b) {
r = (Runnable) getObj();
}
use(r);
private Object getObj() {
return null;
private void use(Exception e) {
private void use(Runnable r) {
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .contains_one("use(b ? (Exception) getObj() : null);")
        .contains_one("use(b ? (Exception) getObj() : (Exception) null);");
}

#[test]
fn type_resolver7_test_no_debug() {
    let helper = IntegrationTestHelper::new("type_resolver7_test_no_debug");
    let source = r#"
public class TestCls {
public void test(boolean a, boolean b) {
Object obj = null;
if (a) {
use(b ? (Exception) getObj() : (Exception) obj);
} else {
Runnable r = (Runnable) obj;
if (b) {
r = (Runnable) getObj();
}
use(r);
private Object getObj() {
return null;
private void use(Exception e) {
private void use(Runnable r) {
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    // TODO: Add assertions
}

#[test]
fn type_resolver9_test() {
    let helper = IntegrationTestHelper::new("type_resolver9_test");
    let source = r#"
public class TestCls {
public int test(byte b) {
return 16777216 * b;
}
public int test2(byte[] array, int offset) {
return array[offset] * 128 + (array[offset + 1] & 0xFF);
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .contains_one("return 16777216 * b;")
        .does_not_contain("Byte.MIN_VALUE");
}

#[test]
fn type_resolver9_test_no_debug() {
    let helper = IntegrationTestHelper::new("type_resolver9_test_no_debug");
    let source = r#"
public class TestCls {
public int test(byte b) {
return 16777216 * b;
}
public int test2(byte[] array, int offset) {
return array[offset] * 128 + (array[offset + 1] & 0xFF);
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    // TODO: Add assertions
}

#[test]
fn generics_basic_test() {
    let helper = IntegrationTestHelper::new("generics_basic_test");
    // Tests basic generic type preservation
    let source = r#"
public class TestCls<T> {
    public T data;

    public TestCls<T> data(T t) {
        this.data = t;
        return this;
    }
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .contains("<T>")
        .contains("TestCls<T> data(T t)");
}

#[test]
fn primitive_conversion_test() {
    let helper = IntegrationTestHelper::new("primitive_conversion_test");
    // Tests type inference for primitive widening and narrowing
    let source = r#"
public class TestCls {
    public void test(byte b) {
        int i = b;  // Widening conversion
        System.out.println(i);
    }

    public void test2(int i) {
        byte b = (byte) i;  // Narrowing conversion (explicit cast)
        System.out.println(b);
    }
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .contains("int i = b;")
        .contains("byte b = (byte)");
}
