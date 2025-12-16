//! Arrays integration tests
//! Ported from jadx-core/src/test/java/jadx/tests/integration/

use crate::integration_test_framework::{IntegrationTestHelper, CodeAssertions, tools_status};

#[test]
fn array_fill_test() {
    let status = tools_status();
    if !status.can_run_tests() {
        eprintln!("SKIPPED: {}", status.skip_reason());
        return;
    }

    let helper = IntegrationTestHelper::new("array_fill_test");
    let source = r#"
public class TestCls {
public String[] method() {
return new String[] { "1", "2", "3" };
}
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    // TODO: Add assertions
}

#[test]
fn array_fill2_test() {
    let status = tools_status();
    if !status.can_run_tests() {
        eprintln!("SKIPPED: {}", status.skip_reason());
        return;
    }

    let helper = IntegrationTestHelper::new("array_fill2_test");
    let source = r#"
public class TestCls {
public int[] test(int a) {
return new int[] { 1, a + 1, 2 };
}
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .contains("return new int[]{1, a + 1, 2};");
}

#[test]
fn array_fill4_test() {
    let status = tools_status();
    if !status.can_run_tests() {
        eprintln!("SKIPPED: {}", status.skip_reason());
        return;
    }

    let helper = IntegrationTestHelper::new("array_fill4_test");
    let source = r#"
public class TestCls {
// replaced constant break filled array creation
private static final int ARRAY_SIZE = 4;
public long[] test() {
return new long[] { 0, 1, Long.MAX_VALUE, Long.MIN_VALUE + 1 };
}
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .contains_one("return new long[]{0, 1, ")
        .does_not_contain("new long[ARRAY_SIZE];");
}

#[test]
fn array_fill_const_replace_test() {
    let status = tools_status();
    if !status.can_run_tests() {
        eprintln!("SKIPPED: {}", status.skip_reason());
        return;
    }

    let helper = IntegrationTestHelper::new("array_fill_const_replace_test");
    let source = r#"
public class TestCls {
public static final int CONST_INT = 0xffff;
public int[] test() {
return new int[] { 127, 129, CONST_INT };
}
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .contains_one(" int CONST_INT = 65535;")
        .contains_one("return new int[]{127, 129, CONST_INT};");
}

#[test]
fn array_fill_negative_test() {
    let status = tools_status();
    if !status.can_run_tests() {
        eprintln!("SKIPPED: {}", status.skip_reason());
        return;
    }

    let helper = IntegrationTestHelper::new("array_fill_negative_test");
    let source = r#"
public class TestCls {
public int[] test() {
int[] arr = new int[3];
arr[0] = 1;
arr[1] = arr[0] + 1;
arr[2] = arr[1] + 1;
return arr;
}
public void check() {
assertThat(test()).isEqualTo(new int[] { 1, 2, 3 });
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .contains_one("int[] arr = new int[3];")
        .contains_one("arr[1] = arr[0] + 1;")
        .does_not_contain("int[] arr = {1, ");
}

#[test]
fn array_fill_with_move_test() {
    let status = tools_status();
    if !status.can_run_tests() {
        eprintln!("SKIPPED: {}", status.skip_reason());
        return;
    }

    let helper = IntegrationTestHelper::new("array_fill_with_move_test");
    // TODO: Extract test source
    let source = r#"
public class TestCls {
    // Add test code here
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .contains("return new long[]{0, 1}")
        .does_not_contain("// fill-array-data instruction")
        .does_not_contain("arr[0] = 0;");
}

#[test]
fn array_init_test() {
    let status = tools_status();
    if !status.can_run_tests() {
        eprintln!("SKIPPED: {}", status.skip_reason());
        return;
    }

    let helper = IntegrationTestHelper::new("array_init_test");
    let source = r#"
public class TestCls {
byte[] bytes;
@SuppressWarnings("unused")
public void test() {
byte[] arr = new byte[] { 10, 20, 30 };
}
public void test2() {
bytes = new byte[] { 10, 20, 30 };
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .contains("= {10, 20, 30};")
        .contains("this.bytes = new byte[]{10, 20, 30};");
}

#[test]
fn array_init_field_test() {
    let status = tools_status();
    if !status.can_run_tests() {
        eprintln!("SKIPPED: {}", status.skip_reason());
        return;
    }

    let helper = IntegrationTestHelper::new("array_init_field_test");
    let source = r#"
public class TestCls {
static byte[] a = new byte[] { 10, 20, 30 };
byte[] b = new byte[] { 40, 50, 60 };
}
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .contains_one("static byte[] a = {10, 20, 30};")
        .contains_one("byte[] b = {40, 50, 60};");
}

#[test]
fn array_init_field2_test() {
    let status = tools_status();
    if !status.can_run_tests() {
        eprintln!("SKIPPED: {}", status.skip_reason());
        return;
    }

    let helper = IntegrationTestHelper::new("array_init_field2_test");
    // TODO: Extract test source
    let source = r#"
public class TestCls {
    // Add test code here
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .contains_one("static long[] myArr = {1282979400, 0, 0};");
}

#[test]
fn arrays_test() {
    let status = tools_status();
    if !status.can_run_tests() {
        eprintln!("SKIPPED: {}", status.skip_reason());
        return;
    }

    let helper = IntegrationTestHelper::new("arrays_test");
    let source = r#"
public class TestCls {
public int test1(int i) {
int[] a = new int[] { 1, 2, 3, 5 };
return a[i];
}
public int test2(int i) {
int[][] a = new int[i][i + 1];
return a.length;
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .contains_one("return new int[]{1, 2, 3, 5}[i];");
}

#[test]
fn arrays2_test() {
    let status = tools_status();
    if !status.can_run_tests() {
        eprintln!("SKIPPED: {}", status.skip_reason());
        return;
    }

    let helper = IntegrationTestHelper::new("arrays2_test");
    let source = r#"
public class TestCls {
private static Object test4(int type) {
if (type == 1) {
return new int[] { 1, 2 };
} else if (type == 2) {
return new float[] { 1, 2 };
} else if (type == 3) {
return new short[] { 1, 2 };
} else if (type == 4) {
return new byte[] { 1, 2 };
} else {
return null;
}
public void check() {
assertThat(test4(4)).isInstanceOf(byte[].class);
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .contains_one("new int[]{1, 2}");
}

#[test]
fn arrays3_test() {
    let status = tools_status();
    if !status.can_run_tests() {
        eprintln!("SKIPPED: {}", status.skip_reason());
        return;
    }

    let helper = IntegrationTestHelper::new("arrays3_test");
    let source = r#"
public class TestCls {
private Object test(byte[] bArr) {
return new Object[] { bArr };
}
public void check() {
byte[] inputArr = { 1, 2 };
Object result = test(inputArr);
assertThat(result).isInstanceOf(Object[].class);
assertThat(((Object[]) result)[0]).isEqualTo(inputArr);
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .contains_one("return new Object[]{bArr};");
}

#[test]
fn arrays3_test_no_debug() {
    let status = tools_status();
    if !status.can_run_tests() {
        eprintln!("SKIPPED: {}", status.skip_reason());
        return;
    }

    let helper = IntegrationTestHelper::new("arrays3_test_no_debug");
    let source = r#"
public class TestCls {
private Object test(byte[] bArr) {
return new Object[] { bArr };
}
public void check() {
byte[] inputArr = { 1, 2 };
Object result = test(inputArr);
assertThat(result).isInstanceOf(Object[].class);
assertThat(((Object[]) result)[0]).isEqualTo(inputArr);
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .contains_one("return new Object[]{bArr};");
}

#[test]
fn arrays4_test_array_type_inference() {
    let status = tools_status();
    if !status.can_run_tests() {
        eprintln!("SKIPPED: {}", status.skip_reason());
        return;
    }

    let helper = IntegrationTestHelper::new("arrays4_test_array_type_inference");
    let source = r#"
public class TestCls {
char[] payload;
public TestCls(byte[] bytes) {
char[] a = toChars(bytes);
this.payload = new char[a.length];
System.arraycopy(a, 0, this.payload, 0, bytes.length);
}
private static char[] toChars(byte[] bArr) {
return new char[bArr.length];
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .contains_one("char[] chars = toChars(bArr);");
}

#[test]
fn fill_array_data_test() {
    let status = tools_status();
    if !status.can_run_tests() {
        eprintln!("SKIPPED: {}", status.skip_reason());
        return;
    }

    let helper = IntegrationTestHelper::new("fill_array_data_test");
    // TODO: Extract test source
    let source = r#"
public class TestCls {
    // Add test code here
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .contains("jArr[0] = 1;")
        .contains("jArr[1] = 2;");
}

#[test]
fn multi_dim_array_fill_test() {
    let status = tools_status();
    if !status.can_run_tests() {
        eprintln!("SKIPPED: {}", status.skip_reason());
        return;
    }

    let helper = IntegrationTestHelper::new("multi_dim_array_fill_test");
    let source = r#"
public class TestCls {
public static Obj test(int a, int b) {
return new Obj(
new int[][] { { 1 }, { 2 }, { 3 }, { 4, 5 }, new int[0] },
new int[] { a, a, a, a, b });
}
public Obj(int[][] ints, int[] ints2) {
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    // TODO: Add assertions
}
