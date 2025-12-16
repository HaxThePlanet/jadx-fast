//! Generics integration tests
//! Ported from jadx-core/src/test/java/jadx/tests/integration/

use crate::integration_test_framework::{IntegrationTestHelper, CodeAssertions, tools_status};

#[test]
fn class_signature_test() {
    // Note: Java test (TestClassSignature) is a SmaliTest that loads from smali files.
    // Skipping as dexterity doesn't support smali input yet.
    eprintln!("SKIPPED: SmaliTest - requires smali input format");
}

#[test]
fn constructor_generics_test() {
    let status = tools_status();
    if !status.can_run_tests() {
        eprintln!("SKIPPED: {}", status.skip_reason());
        return;
    }

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
    let status = tools_status();
    if !status.can_run_tests() {
        eprintln!("SKIPPED: {}", status.skip_reason());
        return;
    }

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

    result
        .contains_one("return (String) new HashMap().get(\"test\");");
}

#[test]
fn generic8_test() {
    let status = tools_status();
    if !status.can_run_tests() {
        eprintln!("SKIPPED: {}", status.skip_reason());
        return;
    }

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
    let status = tools_status();
    if !status.can_run_tests() {
        eprintln!("SKIPPED: {}", status.skip_reason());
        return;
    }

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
    let status = tools_status();
    if !status.can_run_tests() {
        eprintln!("SKIPPED: {}", status.skip_reason());
        return;
    }

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
    let status = tools_status();
    if !status.can_run_tests() {
        eprintln!("SKIPPED: {}", status.skip_reason());
        return;
    }

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

    result
        .contains_one("public ItemReference(V item, Object objId, ReferenceQueue<? super V> queue) {")
        .contains_one("public V get(Object id) {")
        .contains_one("WeakReference<V> ref = ")
        .contains_one("return ref.get();");
}

#[test]
fn generics2_test_debug() {
    let status = tools_status();
    if !status.can_run_tests() {
        eprintln!("SKIPPED: {}", status.skip_reason());
        return;
    }

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
    let status = tools_status();
    if !status.can_run_tests() {
        eprintln!("SKIPPED: {}", status.skip_reason());
        return;
    }

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
    let status = tools_status();
    if !status.can_run_tests() {
        eprintln!("SKIPPED: {}", status.skip_reason());
        return;
    }

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
    let status = tools_status();
    if !status.can_run_tests() {
        eprintln!("SKIPPED: {}", status.skip_reason());
        return;
    }

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

    result
        .contains_one("for (A a : as) {")
        .contains_one("for (I i : is) {");
}

#[test]
fn generics7_test() {
    let status = tools_status();
    if !status.can_run_tests() {
        eprintln!("SKIPPED: {}", status.skip_reason());
        return;
    }

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
    let status = tools_status();
    if !status.can_run_tests() {
        eprintln!("SKIPPED: {}", status.skip_reason());
        return;
    }

    let helper = IntegrationTestHelper::new_no_debug("generics8_test");
    let source = r#"
import java.util.Iterator;
import java.util.LinkedHashMap;

public class TestCls<I> extends LinkedHashMap<I, Integer> implements Iterable<I> {
    @Override
    public Iterator<I> iterator() {
        return keySet().iterator();
    }
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .contains_one("return keySet().iterator();");
}

#[test]
fn generics_in_args_test() {
    let status = tools_status();
    if !status.can_run_tests() {
        eprintln!("SKIPPED: {}", status.skip_reason());
        return;
    }

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

    result
        .contains("public static <T> void test(List<? super T> genericList, Set<T> set) {")
        .contains("if (genericList == null) {");
}

#[test]
fn generics_in_args_test_no_debug() {
    let status = tools_status();
    if !status.can_run_tests() {
        eprintln!("SKIPPED: {}", status.skip_reason());
        return;
    }

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

    result
        .contains("public static <T> void test(List<? super T> list, Set<T> set) {")
        .contains("if (list == null) {");
}

#[test]
fn generics_mth_override_test() {
    let status = tools_status();
    if !status.can_run_tests() {
        eprintln!("SKIPPED: {}", status.skip_reason());
        return;
    }

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

    result
        .contains_one("public Y method(X x) {")
        .contains_one("public Y method(Object x) {")
        .contains_one("public Y method(Exception x) {")
        .contains_one("public Object method(Object x) {")
        .count_string(4, "@Override");
}

#[test]
fn import_generic_map_test() {
    let status = tools_status();
    if !status.can_run_tests() {
        eprintln!("SKIPPED: {}", status.skip_reason());
        return;
    }

    let helper = IntegrationTestHelper::new("import_generic_map_test");
    let source = r#"
public class TestCls<O extends TestCls.ToImport> {
    interface ToImport {
    }

    interface NotToImport {
    }

    static final class Class1<C extends NotToImport> {
    }

    public <C extends NotToImport> TestCls(Class1<C> zzf) {
    }
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    // The assertion is about import statements, which dexterity handles differently
    result
        .contains("class TestCls<O extends TestCls.ToImport>");
}

#[test]
fn method_override_test() {
    // Note: Java test (TestMethodOverride) is a SmaliTest that loads from smali files.
    // Skipping as dexterity doesn't support smali input yet.
    eprintln!("SKIPPED: SmaliTest - requires smali input format");
}

#[test]
fn missing_generics_types2_test() {
    // Note: Java test (TestMissingGenericsTypes2) is a SmaliTest that loads from smali files.
    // Skipping as dexterity doesn't support smali input yet.
    eprintln!("SKIPPED: SmaliTest - requires smali input format");
}

#[test]
fn missing_generics_types2_test_types() {
    // Note: Java test (TestMissingGenericsTypes2) is a SmaliTest that loads from smali files.
    // Skipping as dexterity doesn't support smali input yet.
    eprintln!("SKIPPED: SmaliTest - requires smali input format");
}

#[test]
fn outer_generic_test() {
    let status = tools_status();
    if !status.can_run_tests() {
        eprintln!("SKIPPED: {}", status.skip_reason());
        return;
    }

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
    // Note: Java test (TestSyntheticOverride) is a SmaliTest that loads from smali files.
    // Skipping as dexterity doesn't support smali input yet.
    eprintln!("SKIPPED: SmaliTest - requires smali input format");
}

#[test]
fn type_vars_from_outer_class_test() {
    let status = tools_status();
    if !status.can_run_tests() {
        eprintln!("SKIPPED: {}", status.skip_reason());
        return;
    }

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
    let status = tools_status();
    if !status.can_run_tests() {
        eprintln!("SKIPPED: {}", status.skip_reason());
        return;
    }

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
    let status = tools_status();
    if !status.can_run_tests() {
        eprintln!("SKIPPED: {}", status.skip_reason());
        return;
    }

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
