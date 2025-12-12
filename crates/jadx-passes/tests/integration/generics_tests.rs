//! Generics integration tests
//! Ported from jadx-core/src/test/java/jadx/tests/integration/generics/

mod integration_test_framework;
use integration_test_framework::{IntegrationTestHelper, CodeAssertions};

#[test]
fn class_signature_test() {
    let helper = IntegrationTestHelper::new("class_signature_test");
    // TODO: Extract test source
    let source = r#"
public class TestCls {
    // Add test code here
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .contains_one("Incorrect class signature")
        .does_not_contain("StackOverflowError");
}

#[test]
fn constructor_generics_test() {
    let helper = IntegrationTestHelper::new("constructor_generics_test");
    let source = r#"
public class TestCls {
public String test() {
Map<String, String> map = new HashMap<>();
return map.get("test");
}
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .contains_one("Map<String, String> map = new HashMap<>();");
}

#[test]
fn constructor_generics_test_no_debug() {
    let helper = IntegrationTestHelper::new("constructor_generics_test_no_debug");
    let source = r#"
public class TestCls {
public String test() {
Map<String, String> map = new HashMap<>();
return map.get("test");
}
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    // TODO: Add assertions
}

#[test]
fn generic8_test() {
    let helper = IntegrationTestHelper::new("generic8_test");
    let source = r#"
public class TestCls {
@SuppressWarnings("InnerClassMayBeStatic")
public class TestNumber<T extends Integer> {
private final T n;
public TestNumber(T n) {
this.n = n;
}
public boolean isEven() {
return n.intValue() % 2 == 0;
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .contains_one("public TestNumber(T n");
}

#[test]
fn generic_fields_test() {
    let helper = IntegrationTestHelper::new("generic_fields_test");
    let source = r#"
public class TestCls {
Value<Amount> price;
}
T value;
String cur;
int val;
public String test(Summary summary) {
Amount amount = summary.price.value;
return amount.val + " " + amount.cur;
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .contains_one("Amount amount =")
        .does_not_contain("T t = ");
}

#[test]
fn generics_test() {
    let helper = IntegrationTestHelper::new("generics_test");
    let source = r#"
public class TestCls {
class A {
}
public static void mthWildcard(List<?> list) {
public static void mthExtends(List<? extends A> list) {
public static void mthSuper(List<? super A> list) {
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .contains("mthWildcard(List<?> list)")
        .contains("mthExtends(List<? extends A> list)")
        .contains("mthSuper(List<? super A> list)");
}

#[test]
fn generics2_test() {
    let helper = IntegrationTestHelper::new("generics2_test");
    let source = r#"
public class TestCls {
public Object id;
public ItemReference(V item, Object objId, ReferenceQueue<? super V> queue) {
super(item, queue);
this.id = objId;
}
private Map<Object, ItemReference<V>> items;
public V get(Object id) {
WeakReference<V> ref = this.items.get(id);
if (ref != null) {
return ref.get();
return null;
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    // TODO: Add assertions
}

#[test]
fn generics2_test_debug() {
    let helper = IntegrationTestHelper::new("generics2_test_debug");
    let source = r#"
public class TestCls {
public Object id;
public ItemReference(V item, Object objId, ReferenceQueue<? super V> queue) {
super(item, queue);
this.id = objId;
}
private Map<Object, ItemReference<V>> items;
public V get(Object id) {
WeakReference<V> ref = this.items.get(id);
if (ref != null) {
return ref.get();
return null;
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .contains_one("ItemReference<V> itemReference = this.items.get(obj);")
        .contains_one("return itemReference.get();");
}

#[test]
fn generics3_test() {
    let helper = IntegrationTestHelper::new("generics3_test");
    let source = r#"
public class TestCls {
public static void mthExtendsArray(List<? extends byte[]> list) {
}
public static void mthSuperArray(List<? super int[]> list) {
public static void mthSuperInteger(List<? super Integer> list) {
public static void mthExtendsString(List<? super String> list) {
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .contains("mthExtendsArray(List<? extends byte[]> list)")
        .contains("mthSuperArray(List<? super int[]> list)")
        .contains("mthSuperInteger(List<? super Integer> list)")
        .contains("mthExtendsString(List<? super String> list)");
}

#[test]
fn generics4_test() {
    let helper = IntegrationTestHelper::new("generics4_test");
    let source = r#"
public class TestCls {
public static Class<?> method(int i) {
Class<?>[] a = new Class<?>[0];
return a[a.length - i];
}
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .contains("Class<?>[] a =")
        .does_not_contain("Class[] a =");
}

#[test]
fn generics6_test() {
    let helper = IntegrationTestHelper::new("generics6_test");
    let source = r#"
public class TestCls {
public void test1(Collection<? extends A> as) {
for (A a : as) {
a.f();
}
public void test2(Collection<? extends A> is) {
for (I i : is) {
i.f();
private interface I {
void f();
private class A implements I {
public void f() {
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    // TODO: Add assertions
}

#[test]
fn generics7_test() {
    let helper = IntegrationTestHelper::new("generics7_test");
    let source = r#"
public class TestCls {
public void test() {
declare(String.class);
}
public <T> T declare(Class<T> cls) {
return null;
public void declare(Object cls) {
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .contains("declare(String.class);");
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
        .contains_one("return keySet().iterator();");
}

#[test]
fn generics_in_args_test() {
    let helper = IntegrationTestHelper::new("generics_in_args_test");
    let source = r#"
public class TestCls {
public static <T> void test(List<? super T> genericList, Set<T> set) {
if (genericList == null) {
throw new RuntimeException("list is null");
}
if (set == null) {
throw new RuntimeException("set is null");
genericList.clear();
use(genericList);
set.clear();
private static void use(List<?> l) {
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    // TODO: Add assertions
}

#[test]
fn generics_in_args_test_no_debug() {
    let helper = IntegrationTestHelper::new("generics_in_args_test_no_debug");
    let source = r#"
public class TestCls {
public static <T> void test(List<? super T> genericList, Set<T> set) {
if (genericList == null) {
throw new RuntimeException("list is null");
}
if (set == null) {
throw new RuntimeException("set is null");
genericList.clear();
use(genericList);
set.clear();
private static void use(List<?> l) {
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    // TODO: Add assertions
}

#[test]
fn generics_mth_override_test() {
    let helper = IntegrationTestHelper::new("generics_mth_override_test");
    let source = r#"
public class TestCls {
public interface I<X, Y> {
Y method(X x);
}
@Override
public Y method(X x) {
return null;
public Y method(Object x) {
public Y method(Exception x) {
@SuppressWarnings("unchecked")
public Object method(Object x) {
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    // TODO: Add assertions
}

#[test]
fn import_generic_map_test() {
    let helper = IntegrationTestHelper::new("import_generic_map_test");
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
fn method_override_test() {
    let helper = IntegrationTestHelper::new("method_override_test");
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
fn missing_generics_types2_test() {
    let helper = IntegrationTestHelper::new("missing_generics_types2_test");
    // TODO: Extract test source
    let source = r#"
public class TestCls {
    // Add test code here
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .contains_one("for (String s : l) {")
        .contains_one("Iterator<String> it = ")
        .does_not_contain("Iterator i")
        .does_not_contain("Iterator i");
}

#[test]
fn missing_generics_types2_test_types() {
    let helper = IntegrationTestHelper::new("missing_generics_types2_test_types");
    // TODO: Extract test source
    let source = r#"
public class TestCls {
    // Add test code here
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .contains_one("Iterator<String> it = ")
        .does_not_contain("Iterator i");
}

#[test]
fn outer_generic_test() {
    let helper = IntegrationTestHelper::new("outer_generic_test");
    let source = r#"
public class TestCls {
public class B<V> {
}
public class C {
public class E {
public void test1() {
A<String> a = new A<>();
use(a);
A<String>.B<Exception> b = a.new B<Exception>();
use(b);
A<String>.C c = a.new C();
use(c);
use(new A<Set<String>>().new C());
public void test2() {
D d = new D();
D.E e = d.new E();
use(e);
public void test3() {
use(A.class);
use(A.B.class);
use(A.C.class);
private void use(Object obj) {
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .contains_one("A<String> a = new A<>();")
        .contains_one("A<String>.B<Exception> b = a.new B<Exception>();")
        .contains_one("A<String>.C c = a.new C();")
        .contains_one("use(new A<Set<String>>().new C());")
        .contains_one("D.E e = d.new E();");
}

#[test]
fn synthetic_override_test() {
    let helper = IntegrationTestHelper::new("synthetic_override_test");
    // TODO: Extract test source
    let source = r#"
public class TestCls {
    // Add test code here
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .contains_one("invoke(String str)")
        .contains_one("invoke2(String str)");
}

#[test]
fn type_vars_from_outer_class_test() {
    let helper = IntegrationTestHelper::new("type_vars_from_outer_class_test");
    let source = r#"
public class TestCls {
public interface I<X> {
Map.Entry<X, X> entry();
}
public class Inner implements I<Y> {
@Override
public Map.Entry<Y, Y> entry() {
return null;
public Inner getInner() {
private Outer<String> outer;
public void test() {
Outer<String>.Inner inner = this.outer.getInner();
use(inner, inner);
Map.Entry<String, String> entry = inner.entry();
use(entry.getKey(), entry.getValue());
public void test2() {
// force interface virtual call
I<String> base = this.outer.getInner();
use(base, base);
Map.Entry<String, String> entry = base.entry();
public void use(Object a, Object b) {
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .does_not_contain("Outer<Y>.Inner inner")
        .does_not_contain("Object entry = ")
        .count_string(2, "Outer<String>.Inner inner = this.outer.getInner();")
        .count_string(2, "Map.Entry<String, String> entry = ");
}

#[test]
fn type_vars_from_super_class_test() {
    let helper = IntegrationTestHelper::new("type_vars_from_super_class_test");
    let source = r#"
public class TestCls {
}
public B call() {
return null;
public Object test() {
String str = call();
Objects.nonNull(str);
return str;
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .contains_one("= call();")
        .does_not_contain("(String)");
}

#[test]
fn usage_in_generics_test() {
    let helper = IntegrationTestHelper::new("usage_in_generics_test");
    let source = r#"
public class TestCls {
}
public List<? extends A> list;
public <T extends A> T test() {
return null;
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .contains_one("public <T extends A> T test() {");
}
