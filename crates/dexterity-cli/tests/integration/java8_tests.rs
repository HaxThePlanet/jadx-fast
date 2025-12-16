//! Java8 integration tests
//! Ported from jadx-core/src/test/java/jadx/tests/integration/

use crate::integration_test_framework::{IntegrationTestHelper, CodeAssertions, tools_status};

#[test]
fn lambda_args_test() {
    let status = tools_status();
    if !status.can_run_tests() {
        eprintln!("SKIPPED: {}", status.skip_reason());
        return;
    }

    let helper = IntegrationTestHelper::new("lambda_args_test");
    let source = r#"
public class TestCls {
public void test1() {
call1(a -> -a);
}
public void test2() {
call2((a, b) -> a - b);
private void call1(Function<Integer, Integer> func) {
private void call2(BiFunction<Integer, Integer, Integer> func) {
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .contains_one("call1(a ->")
        .contains_one("call2((a, b) ->");
}

#[test]
fn lambda_constructor_test() {
    let status = tools_status();
    if !status.can_run_tests() {
        eprintln!("SKIPPED: {}", status.skip_reason());
        return;
    }

    let helper = IntegrationTestHelper::new("lambda_constructor_test");
    let source = r#"
public class TestCls {
public Supplier<Exception> test() {
return RuntimeException::new;
}
public void check() throws Exception {
assertThat(test().get()).isInstanceOf(RuntimeException.class);
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .contains_one("return RuntimeException::new;");
}

#[test]
fn lambda_constructor_test_fallback() {
    let status = tools_status();
    if !status.can_run_tests() {
        eprintln!("SKIPPED: {}", status.skip_reason());
        return;
    }

    let helper = IntegrationTestHelper::new("lambda_constructor_test_fallback");
    let source = r#"
public class TestCls {
public Supplier<Exception> test() {
return RuntimeException::new;
}
public void check() throws Exception {
assertThat(test().get()).isInstanceOf(RuntimeException.class);
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .contains_one("r0 = java.lang.RuntimeException::new")
        .contains_one("return r0");
}

#[test]
fn lambda_in_array_test() {
    let status = tools_status();
    if !status.can_run_tests() {
        eprintln!("SKIPPED: {}", status.skip_reason());
        return;
    }

    let helper = IntegrationTestHelper::new("lambda_in_array_test");
    let source = r#"
public class TestCls {
public List<Function<String, Integer>> test() {
return Arrays.asList(this::call1, this::call2);
}
private Integer call1(String s) {
return null;
private Integer call2(String s) {
public void check() throws Exception {
assertThat(test()).hasSize(2);
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .contains_one("return Arrays.asList(this::call1, this::call2);");
}

#[test]
fn lambda_instance_test() {
    let status = tools_status();
    if !status.can_run_tests() {
        eprintln!("SKIPPED: {}", status.skip_reason());
        return;
    }

    let helper = IntegrationTestHelper::new("lambda_instance_test");
    let source = r#"
public class TestCls {
public Function<String, Integer> test() {
return str -> this.call(str);
}
public Function<String, Integer> testMthRef() {
return this::call;
public Integer call(String str) {
return Integer.parseInt(str);
public Function<Integer, String> test2() {
return num -> num.toString();
public Function<Integer, String> testMthRef2() {
return Object::toString;
public void check() throws Exception {
assertThat(test().apply("11")).isEqualTo(11);
assertThat(testMthRef().apply("7")).isEqualTo(7);
assertThat(test2().apply(15)).isEqualTo("15");
assertThat(testMthRef2().apply(13)).isEqualTo("13");
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .contains_one("return Object::toString;")
        .contains_one("return this::call;")
        .does_not_contain("lambda$")
        .does_not_contain("renamed");
}

#[test]
fn lambda_instance_test_no_debug() {
    let status = tools_status();
    if !status.can_run_tests() {
        eprintln!("SKIPPED: {}", status.skip_reason());
        return;
    }

    let helper = IntegrationTestHelper::new("lambda_instance_test_no_debug");
    let source = r#"
public class TestCls {
public Function<String, Integer> test() {
return str -> this.call(str);
}
public Function<String, Integer> testMthRef() {
return this::call;
public Integer call(String str) {
return Integer.parseInt(str);
public Function<Integer, String> test2() {
return num -> num.toString();
public Function<Integer, String> testMthRef2() {
return Object::toString;
public void check() throws Exception {
assertThat(test().apply("11")).isEqualTo(11);
assertThat(testMthRef().apply("7")).isEqualTo(7);
assertThat(test2().apply(15)).isEqualTo("15");
assertThat(testMthRef2().apply(13)).isEqualTo("13");
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    // TODO: Add assertions
}

#[test]
fn lambda_instance_test_fallback() {
    let status = tools_status();
    if !status.can_run_tests() {
        eprintln!("SKIPPED: {}", status.skip_reason());
        return;
    }

    let helper = IntegrationTestHelper::new("lambda_instance_test_fallback");
    let source = r#"
public class TestCls {
public Function<String, Integer> test() {
return str -> this.call(str);
}
public Function<String, Integer> testMthRef() {
return this::call;
public Integer call(String str) {
return Integer.parseInt(str);
public Function<Integer, String> test2() {
return num -> num.toString();
public Function<Integer, String> testMthRef2() {
return Object::toString;
public void check() throws Exception {
assertThat(test().apply("11")).isEqualTo(11);
assertThat(testMthRef().apply("7")).isEqualTo(7);
assertThat(test2().apply(15)).isEqualTo("15");
assertThat(testMthRef2().apply(13)).isEqualTo("13");
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    // TODO: Add assertions
}

#[test]
fn lambda_instance2_test() {
    let status = tools_status();
    if !status.can_run_tests() {
        eprintln!("SKIPPED: {}", status.skip_reason());
        return;
    }

    let helper = IntegrationTestHelper::new("lambda_instance2_test");
    let source = r#"
public class TestCls {
private String field;
public Runnable test(String str, int i) {
return () -> call(str, i);
}
public void call(String str, int i) {
field = str + '=' + i;
public void check() throws Exception {
field = "";
test("num", 7).run();
assertThat(field).isEqualTo("num=7");
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .contains_one("call(str, i)")
        .does_not_contain("lambda$");
}

#[test]
fn lambda_instance3_test() {
    let status = tools_status();
    if !status.can_run_tests() {
        eprintln!("SKIPPED: {}", status.skip_reason());
        return;
    }

    let helper = IntegrationTestHelper::new("lambda_instance3_test");
    // TODO: Extract test source
    let source = r#"
public class TestCls {
    // Add test code here
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .contains_one("return (TestCls) lazyOf::get;")
        .contains_one("Memoized)")
        .does_not_contain("this::get");
}

#[test]
fn lambda_instance3_test_raung() {
    let status = tools_status();
    if !status.can_run_tests() {
        eprintln!("SKIPPED: {}", status.skip_reason());
        return;
    }

    let helper = IntegrationTestHelper::new("lambda_instance3_test_raung");
    // TODO: Extract test source
    let source = r#"
public class TestCls {
    // Add test code here
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .contains_one(" lazyOf::get")
        .does_not_contain("this::get");
}

#[test]
fn lambda_return_test_no_debug() {
    let status = tools_status();
    if !status.can_run_tests() {
        eprintln!("SKIPPED: {}", status.skip_reason());
        return;
    }

    let helper = IntegrationTestHelper::new("lambda_return_test_no_debug");
    let source = r#"
public class TestCls {
interface Function0<R> {
R apply();
}
public long l;
public T2(long l) {
this.l = l;
public void w() {
public Byte test(Byte b1) {
Function0<Void> f1 = () -> {
new T2(94L).w();
return null;
};
f1.apply();
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    // TODO: Add assertions
}

#[test]
fn lambda_static_test() {
    let status = tools_status();
    if !status.can_run_tests() {
        eprintln!("SKIPPED: {}", status.skip_reason());
        return;
    }

    let helper = IntegrationTestHelper::new("lambda_static_test");
    let source = r#"
public class TestCls {
public Callable<String> test1() {
return () -> "test";
}
public Callable<String> test2(String str) {
return () -> str;
public Function<String, Integer> test3(String a) {
return (b) -> Integer.parseInt(a) - Integer.parseInt(b);
public Function<String, Integer> test4() {
return Integer::parseInt;
@SuppressWarnings("Convert2MethodRef")
public Function<String, Integer> test4a() {
return s -> Integer.parseInt(s);
public Function<String, Integer> test5() {
String str = Integer.toString(3);
return (s) -> Integer.parseInt(str) - Integer.parseInt(s);
public void check() throws Exception {
assertThat(test1().call()).isEqualTo("test");
assertThat(test2("a").call()).isEqualTo("a");
assertThat(test3("3").apply("1")).isEqualTo(2);
assertThat(test4().apply("5")).isEqualTo(5);
assertThat(test4a().apply("7")).isEqualTo(7);
assertThat(test5().apply("1")).isEqualTo(2);
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .contains_one("return Integer::parseInt;")
        .does_not_contain("lambda$")
        .does_not_contain("renamed");
}

#[test]
fn lambda_static_test_no_debug() {
    let status = tools_status();
    if !status.can_run_tests() {
        eprintln!("SKIPPED: {}", status.skip_reason());
        return;
    }

    let helper = IntegrationTestHelper::new("lambda_static_test_no_debug");
    let source = r#"
public class TestCls {
public Callable<String> test1() {
return () -> "test";
}
public Callable<String> test2(String str) {
return () -> str;
public Function<String, Integer> test3(String a) {
return (b) -> Integer.parseInt(a) - Integer.parseInt(b);
public Function<String, Integer> test4() {
return Integer::parseInt;
@SuppressWarnings("Convert2MethodRef")
public Function<String, Integer> test4a() {
return s -> Integer.parseInt(s);
public Function<String, Integer> test5() {
String str = Integer.toString(3);
return (s) -> Integer.parseInt(str) - Integer.parseInt(s);
public void check() throws Exception {
assertThat(test1().call()).isEqualTo("test");
assertThat(test2("a").call()).isEqualTo("a");
assertThat(test3("3").apply("1")).isEqualTo(2);
assertThat(test4().apply("5")).isEqualTo(5);
assertThat(test4a().apply("7")).isEqualTo(7);
assertThat(test5().apply("1")).isEqualTo(2);
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    // TODO: Add assertions
}

#[test]
fn lambda_static_test_fallback() {
    let status = tools_status();
    if !status.can_run_tests() {
        eprintln!("SKIPPED: {}", status.skip_reason());
        return;
    }

    let helper = IntegrationTestHelper::new("lambda_static_test_fallback");
    let source = r#"
public class TestCls {
public Callable<String> test1() {
return () -> "test";
}
public Callable<String> test2(String str) {
return () -> str;
public Function<String, Integer> test3(String a) {
return (b) -> Integer.parseInt(a) - Integer.parseInt(b);
public Function<String, Integer> test4() {
return Integer::parseInt;
@SuppressWarnings("Convert2MethodRef")
public Function<String, Integer> test4a() {
return s -> Integer.parseInt(s);
public Function<String, Integer> test5() {
String str = Integer.toString(3);
return (s) -> Integer.parseInt(str) - Integer.parseInt(s);
public void check() throws Exception {
assertThat(test1().call()).isEqualTo("test");
assertThat(test2("a").call()).isEqualTo("a");
assertThat(test3("3").apply("1")).isEqualTo(2);
assertThat(test4().apply("5")).isEqualTo(5);
assertThat(test4a().apply("7")).isEqualTo(7);
assertThat(test5().apply("1")).isEqualTo(2);
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    // TODO: Add assertions
}
