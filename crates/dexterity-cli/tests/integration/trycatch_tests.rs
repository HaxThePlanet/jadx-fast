//! Trycatch integration tests
//! Ported from jadx-core/src/test/java/jadx/tests/integration/

use crate::integration_test_framework::{IntegrationTestHelper, CodeAssertions, tools_status};

#[test]
fn empty_catch_test() {
    let status = tools_status();
    if !status.can_run_tests() {
        eprintln!("SKIPPED: {}", status.skip_reason());
        return;
    }

    let helper = IntegrationTestHelper::new("empty_catch_test");
    // Tests empty catch blocks in enum switch map generation
    // Source adapted from jadx-core/src/test/smali/trycatch/TestEmptyCatch.smali
    let source = r#"
enum Access {
    QUERY, MODIFY, MODIFY_CONST, MODIFY_GETTER_SETTER, CONVERT_ACCESSOR_TO_DATA
}

public class TestCls {
    private static final int[] switchMap;

    static {
        switchMap = new int[Access.values().length];
        try {
            switchMap[Access.QUERY.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            switchMap[Access.MODIFY.ordinal()] = 2;
        } catch (NoSuchFieldError unused) {
        }
        try {
            switchMap[Access.MODIFY_CONST.ordinal()] = 3;
        } catch (NoSuchFieldError unused) {
        }
        try {
            switchMap[Access.MODIFY_GETTER_SETTER.ordinal()] = 4;
        } catch (NoSuchFieldError unused) {
        }
        try {
            switchMap[Access.CONVERT_ACCESSOR_TO_DATA.ordinal()] = 5;
        } catch (NoSuchFieldError unused) {
        }
    }
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .contains("try {")
        .contains("} catch (")
        .contains("NoSuchFieldError");
}

#[test]
fn empty_finally_test() {
    let status = tools_status();
    if !status.can_run_tests() {
        eprintln!("SKIPPED: {}", status.skip_reason());
        return;
    }

    let helper = IntegrationTestHelper::new("empty_finally_test");
    let source = r#"
public class TestCls {
public void test(FileInputStream f1) {
try {
f1.close();
} catch (IOException e) {
// do nothing
} finally {
// ignore
}
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    // TODO: Add assertions
}

#[test]
fn finally_test() {
    let status = tools_status();
    if !status.can_run_tests() {
        eprintln!("SKIPPED: {}", status.skip_reason());
        return;
    }

    let helper = IntegrationTestHelper::new("finally_test");
    let source = r#"
public class TestCls {
private static final String DISPLAY_NAME = "name";
String test(Context context, Object uri) {
Cursor cursor = null;
try {
String[] projection = { DISPLAY_NAME };
cursor = context.query(uri, projection);
int columnIndex = cursor.getColumnIndexOrThrow(DISPLAY_NAME);
cursor.moveToFirst();
return cursor.getString(columnIndex);
} finally {
if (cursor != null) {
cursor.close();
}
private class Context {
public Cursor query(Object o, String[] s) {
return null;
private class Cursor {
public void close() {
public void moveToFirst() {
public int getColumnIndexOrThrow(String s) {
return 0;
public String getString(int i) {
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    // TODO: Add assertions
}

#[test]
fn finally2_test() {
    let status = tools_status();
    if !status.can_run_tests() {
        eprintln!("SKIPPED: {}", status.skip_reason());
        return;
    }

    let helper = IntegrationTestHelper::new("finally2_test");
    let source = r#"
public class TestCls {
public Result test(byte[] data) throws IOException {
InputStream inputStream = null;
try {
inputStream = getInputStream(data);
decode(inputStream);
return new Result(400);
} finally {
closeQuietly(inputStream);
}
public static final class Result {
private final int mCode;
public Result(int code) {
mCode = code;
public int getCode() {
return mCode;
private InputStream getInputStream(byte[] data) throws IOException {
return new ByteArrayInputStream(data);
private int decode(InputStream inputStream) throws IOException {
return inputStream.available();
private void closeQuietly(InputStream is) {
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .contains_one("decode(inputStream);")
        .contains_one("return new Result(400);")
        .does_not_contain("result =");
}

#[test]
fn finally3_test() {
    let status = tools_status();
    if !status.can_run_tests() {
        eprintln!("SKIPPED: {}", status.skip_reason());
        return;
    }

    let helper = IntegrationTestHelper::new("finally3_test");
    let source = r#"
public class TestCls {
public byte[] bytes;
public byte[] test() throws Exception {
InputStream inputStream = null;
try {
if (bytes == null) {
if (!validate()) {
return null;
}
inputStream = getInputStream();
bytes = read(inputStream);
return convert(bytes);
} finally {
close(inputStream);
private byte[] convert(byte[] bytes) throws Exception {
return new byte[0];
private boolean validate() throws Exception {
return false;
private InputStream getInputStream() throws Exception {
return new ByteArrayInputStream(new byte[] {});
private byte[] read(InputStream in) throws Exception {
return new byte[] {};
private static void close(InputStream is) {
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    // TODO: Add assertions
}

#[test]
fn finally3_test2_no_debug() {
    let status = tools_status();
    if !status.can_run_tests() {
        eprintln!("SKIPPED: {}", status.skip_reason());
        return;
    }

    let helper = IntegrationTestHelper::new("finally3_test2_no_debug");
    let source = r#"
public class TestCls {
public byte[] bytes;
public byte[] test() throws Exception {
InputStream inputStream = null;
try {
if (bytes == null) {
if (!validate()) {
return null;
}
inputStream = getInputStream();
bytes = read(inputStream);
return convert(bytes);
} finally {
close(inputStream);
private byte[] convert(byte[] bytes) throws Exception {
return new byte[0];
private boolean validate() throws Exception {
return false;
private InputStream getInputStream() throws Exception {
return new ByteArrayInputStream(new byte[] {});
private byte[] read(InputStream in) throws Exception {
return new byte[] {};
private static void close(InputStream is) {
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    // TODO: Add assertions
}

#[test]
fn finally3_test_smali() {
    let status = tools_status();
    if !status.can_run_tests() {
        eprintln!("SKIPPED: {}", status.skip_reason());
        return;
    }

    let helper = IntegrationTestHelper::new("finally3_test_smali");
    let source = r#"
public class TestCls {
public byte[] bytes;
public byte[] test() throws Exception {
InputStream inputStream = null;
try {
if (bytes == null) {
if (!validate()) {
return null;
}
inputStream = getInputStream();
bytes = read(inputStream);
return convert(bytes);
} finally {
close(inputStream);
private byte[] convert(byte[] bytes) throws Exception {
return new byte[0];
private boolean validate() throws Exception {
return false;
private InputStream getInputStream() throws Exception {
return new ByteArrayInputStream(new byte[] {});
private byte[] read(InputStream in) throws Exception {
return new byte[] {};
private static void close(InputStream is) {
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .does_not_contain("Type inference failed");
}

#[test]
fn finally_extract_test() {
    let status = tools_status();
    if !status.can_run_tests() {
        eprintln!("SKIPPED: {}", status.skip_reason());
        return;
    }

    let helper = IntegrationTestHelper::new("finally_extract_test");
    let source = r#"
public class TestCls {
private int result = 0;
public String test() {
boolean success = false;
try {
String value = call();
result++;
success = true;
return value;
} finally {
if (!success) {
result -= 2;
}
private String call() {
return "call";
public void check() {
test();
assertThat(result).isEqualTo(1);
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    // TODO: Add assertions
}

#[test]
fn finally_extract_test_no_debug() {
    let status = tools_status();
    if !status.can_run_tests() {
        eprintln!("SKIPPED: {}", status.skip_reason());
        return;
    }

    let helper = IntegrationTestHelper::new("finally_extract_test_no_debug");
    let source = r#"
public class TestCls {
private int result = 0;
public String test() {
boolean success = false;
try {
String value = call();
result++;
success = true;
return value;
} finally {
if (!success) {
result -= 2;
}
private String call() {
return "call";
public void check() {
test();
assertThat(result).isEqualTo(1);
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .contains_one("this.result++;");
}

#[test]
fn inline_in_catch_test() {
    let status = tools_status();
    if !status.can_run_tests() {
        eprintln!("SKIPPED: {}", status.skip_reason());
        return;
    }

    let helper = IntegrationTestHelper::new("inline_in_catch_test");
    let source = r#"
public class TestCls {
private File dir;
public int test() {
File output = null;
try {
output = File.createTempFile("f", "a", dir);
if (!output.exists()) {
return 1;
}
return 0;
} catch (Exception e) {
if (output != null) {
output.delete();
return 2;
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .contains_one("File output = null;")
        .contains_one("return 0;");
}

#[test]
fn loop_in_try_catch_test() {
    let status = tools_status();
    if !status.can_run_tests() {
        eprintln!("SKIPPED: {}", status.skip_reason());
        return;
    }

    let helper = IntegrationTestHelper::new("loop_in_try_catch_test");
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
fn multi_exception_catch_test() {
    let status = tools_status();
    if !status.can_run_tests() {
        eprintln!("SKIPPED: {}", status.skip_reason());
        return;
    }

    let helper = IntegrationTestHelper::new("multi_exception_catch_test");
    let source = r#"
public class TestCls {
public void test() {
try {
System.out.println("Test");
} catch (ProviderException | DateTimeException e) {
throw new RuntimeException(e);
}
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .contains_one("try {")
        .contains_one("} catch (ProviderException | DateTimeException e) {")
        .contains_one("throw new RuntimeException(e);")
        .does_not_contain("RuntimeException e;");
}

#[test]
fn multi_exception_catch2_test() {
    let status = tools_status();
    if !status.can_run_tests() {
        eprintln!("SKIPPED: {}", status.skip_reason());
        return;
    }

    let helper = IntegrationTestHelper::new("multi_exception_catch2_test");
    let source = r#"
public class TestCls {
public void test(Constructor<?> constructor) {
try {
constructor.newInstance();
} catch (IllegalAccessException | InstantiationException | InvocationTargetException e) {
e.printStackTrace();
}
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    // TODO: Add assertions
}

#[test]
fn multi_exception_catch2_test_no_debug() {
    let status = tools_status();
    if !status.can_run_tests() {
        eprintln!("SKIPPED: {}", status.skip_reason());
        return;
    }

    let helper = IntegrationTestHelper::new("multi_exception_catch2_test_no_debug");
    let source = r#"
public class TestCls {
public void test(Constructor<?> constructor) {
try {
constructor.newInstance();
} catch (IllegalAccessException | InstantiationException | InvocationTargetException e) {
e.printStackTrace();
}
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    // TODO: Add assertions
}

#[test]
fn multi_exception_catch_same_jump_test() {
    let status = tools_status();
    if !status.can_run_tests() {
        eprintln!("SKIPPED: {}", status.skip_reason());
        return;
    }

    let helper = IntegrationTestHelper::new("multi_exception_catch_same_jump_test");
    let source = r#"
public class TestCls {
public void test() {
try {
System.out.println("Test");
} catch (ProviderException | DateTimeException e) {
throw new RuntimeException(e);
}
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .contains_one("try {")
        .contains_one("} catch (ProviderException | DateTimeException e) {")
        .contains_one("throw new RuntimeException(e);")
        .does_not_contain("RuntimeException e;");
}

#[test]
fn nested_try_catch_test() {
    let status = tools_status();
    if !status.can_run_tests() {
        eprintln!("SKIPPED: {}", status.skip_reason());
        return;
    }

    let helper = IntegrationTestHelper::new("nested_try_catch_test");
    let source = r#"
public class TestCls {
public void test() {
try {
Thread.sleep(1L);
Thread.sleep(2L);
} catch (InterruptedException ignored) {
System.out.println(2);
}
} catch (Exception ignored) {
System.out.println(1);
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .contains("try {")
        .contains("Thread.sleep(1L);")
        .contains("Thread.sleep(2L);")
        .contains("} catch (InterruptedException e) {")
        .contains("} catch (Exception e2) {")
        .does_not_contain("return");
}

#[test]
fn nested_try_catch4_test() {
    let status = tools_status();
    if !status.can_run_tests() {
        eprintln!("SKIPPED: {}", status.skip_reason());
        return;
    }

    let helper = IntegrationTestHelper::new("nested_try_catch4_test");
    // TODO: Extract test source
    let source = r#"
public class TestCls {
    // Add test code here
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .does_not_contain("?? ");
}

#[test]
fn nested_try_catch5_test() {
    let status = tools_status();
    if !status.can_run_tests() {
        eprintln!("SKIPPED: {}", status.skip_reason());
        return;
    }

    let helper = IntegrationTestHelper::new("nested_try_catch5_test");
    // TODO: Extract test source
    let source = r#"
public class TestCls {
    // Add test code here
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .does_not_contain("?? ")
        .count_string(3, "throw ");
}

#[test]
fn try_catch_test() {
    let status = tools_status();
    if !status.can_run_tests() {
        eprintln!("SKIPPED: {}", status.skip_reason());
        return;
    }

    let helper = IntegrationTestHelper::new("try_catch_test");
    let source = r#"
public class TestCls {
public void f() {
try {
Thread.sleep(50L);
} catch (InterruptedException e) {
// ignore
}
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .contains("try {")
        .contains("Thread.sleep(50L);")
        .contains("} catch (InterruptedException e) {")
        .does_not_contain("return");
}

#[test]
fn try_catch10_test() {
    let status = tools_status();
    if !status.can_run_tests() {
        eprintln!("SKIPPED: {}", status.skip_reason());
        return;
    }

    let helper = IntegrationTestHelper::new("try_catch10_test");
    // TODO: Extract test source
    let source = r#"
public class TestCls {
    // Add test code here
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .count_string(3, "return false;");
}

#[test]
fn try_catch2_test() {
    let status = tools_status();
    if !status.can_run_tests() {
        eprintln!("SKIPPED: {}", status.skip_reason());
        return;
    }

    let helper = IntegrationTestHelper::new("try_catch2_test");
    let source = r#"
public class TestCls {
private static final Object OBJ = new Object();
public static boolean test() {
try {
synchronized (OBJ) {
OBJ.wait(5L);
}
return true;
} catch (InterruptedException e) {
return false;
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    // TODO: Add assertions
}

#[test]
fn try_catch6_test() {
    let status = tools_status();
    if !status.can_run_tests() {
        eprintln!("SKIPPED: {}", status.skip_reason());
        return;
    }

    let helper = IntegrationTestHelper::new("try_catch6_test");
    let source = r#"
public class TestCls {
private static boolean test(Object obj) {
boolean res = false;
while (true) {
try {
res = exc(obj);
return res;
} catch (IOException e) {
res = true;
} catch (Throwable e) {
if (obj == null) {
obj = new Object();
}
private static boolean exc(Object obj) throws IOException {
throw new IOException();
return true;
public void check() {
assertThat(test(new Object())).isTrue();
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    // TODO: Add assertions
}

#[test]
fn try_catch6_test_no_debug() {
    let status = tools_status();
    if !status.can_run_tests() {
        eprintln!("SKIPPED: {}", status.skip_reason());
        return;
    }

    let helper = IntegrationTestHelper::new("try_catch6_test_no_debug");
    let source = r#"
public class TestCls {
private static boolean test(Object obj) {
boolean res = false;
while (true) {
try {
res = exc(obj);
return res;
} catch (IOException e) {
res = true;
} catch (Throwable e) {
if (obj == null) {
obj = new Object();
}
private static boolean exc(Object obj) throws IOException {
throw new IOException();
return true;
public void check() {
assertThat(test(new Object())).isTrue();
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .contains_one("try {");
}

#[test]
fn try_catch7_test() {
    let status = tools_status();
    if !status.can_run_tests() {
        eprintln!("SKIPPED: {}", status.skip_reason());
        return;
    }

    let helper = IntegrationTestHelper::new("try_catch7_test");
    let source = r#"
public class TestCls {
public Exception test() {
Exception e = new Exception();
try {
Thread.sleep(50);
} catch (Exception ex) {
e = ex;
}
e.printStackTrace();
return e;
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    // TODO: Add assertions
}

#[test]
fn try_catch7_test_no_debug() {
    let status = tools_status();
    if !status.can_run_tests() {
        eprintln!("SKIPPED: {}", status.skip_reason());
        return;
    }

    let helper = IntegrationTestHelper::new("try_catch7_test_no_debug");
    let source = r#"
public class TestCls {
public Exception test() {
Exception e = new Exception();
try {
Thread.sleep(50);
} catch (Exception ex) {
e = ex;
}
e.printStackTrace();
return e;
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    // TODO: Add assertions
}

#[test]
fn try_catch8_test() {
    let status = tools_status();
    if !status.can_run_tests() {
        eprintln!("SKIPPED: {}", status.skip_reason());
        return;
    }

    let helper = IntegrationTestHelper::new("try_catch8_test");
    let source = r#"
public class TestCls {
static class MyException extends Exception {
private static final long serialVersionUID = 7963400419047287279L;
MyException() {
}
MyException(String msg, Throwable cause) {
super(msg, cause);
MyException e = null;
public void test() {
synchronized (this) {
try {
throw new MyException();
} catch (MyException myExc) {
this.e = myExc;
} catch (Exception ex) {
this.e = new MyException("MyExc", ex);
public void check() {
test();
assertThat(e).isInstanceOf(MyException.class);
assertThat(e.getMessage()).isNull();
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    // TODO: Add assertions
}

#[test]
fn try_catch8_test_no_debug() {
    let status = tools_status();
    if !status.can_run_tests() {
        eprintln!("SKIPPED: {}", status.skip_reason());
        return;
    }

    let helper = IntegrationTestHelper::new("try_catch8_test_no_debug");
    let source = r#"
public class TestCls {
static class MyException extends Exception {
private static final long serialVersionUID = 7963400419047287279L;
MyException() {
}
MyException(String msg, Throwable cause) {
super(msg, cause);
MyException e = null;
public void test() {
synchronized (this) {
try {
throw new MyException();
} catch (MyException myExc) {
this.e = myExc;
} catch (Exception ex) {
this.e = new MyException("MyExc", ex);
public void check() {
test();
assertThat(e).isInstanceOf(MyException.class);
assertThat(e.getMessage()).isNull();
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .contains_one("synchronized (this) {")
        .contains_one("throw new MyException();");
}

#[test]
fn try_catch_finally_test() {
    let status = tools_status();
    if !status.can_run_tests() {
        eprintln!("SKIPPED: {}", status.skip_reason());
        return;
    }

    let helper = IntegrationTestHelper::new("try_catch_finally_test");
    let source = r#"
public class TestCls {
public boolean f;
@SuppressWarnings("ConstantConditions")
private boolean test(Object obj) {
this.f = false;
try {
exc(obj);
} catch (Exception e) {
e.printStackTrace();
} finally {
this.f = true;
}
return this.f;
private static boolean exc(Object obj) throws Exception {
if (obj == null) {
throw new Exception("test");
return (obj instanceof String);
public void check() {
assertThat(test("a")).isTrue();
assertThat(test(null)).isTrue();
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .contains_one("this.f = false;")
        .contains_one("exc(obj);");
}

#[test]
fn try_catch_finally_test_without_finally() {
    let status = tools_status();
    if !status.can_run_tests() {
        eprintln!("SKIPPED: {}", status.skip_reason());
        return;
    }

    let helper = IntegrationTestHelper::new("try_catch_finally_test_without_finally");
    let source = r#"
public class TestCls {
public boolean f;
@SuppressWarnings("ConstantConditions")
private boolean test(Object obj) {
this.f = false;
try {
exc(obj);
} catch (Exception e) {
e.printStackTrace();
} finally {
this.f = true;
}
return this.f;
private static boolean exc(Object obj) throws Exception {
if (obj == null) {
throw new Exception("test");
return (obj instanceof String);
public void check() {
assertThat(test("a")).isTrue();
assertThat(test(null)).isTrue();
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .contains_one("exc(obj);");
}

#[test]
fn try_catch_finally10_test() {
    let status = tools_status();
    if !status.can_run_tests() {
        eprintln!("SKIPPED: {}", status.skip_reason());
        return;
    }

    let helper = IntegrationTestHelper::new("try_catch_finally10_test");
    // TODO: Extract test source
    let source = r#"
public class TestCls {
    // Add test code here
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .does_not_contain("boolean z = null;");
}

#[test]
fn try_catch_finally11_test() {
    let status = tools_status();
    if !status.can_run_tests() {
        eprintln!("SKIPPED: {}", status.skip_reason());
        return;
    }

    let helper = IntegrationTestHelper::new("try_catch_finally11_test");
    let source = r#"
public class TestCls {
private int count = 0;
public void test(List<Object> list) {
try {
call1();
} finally {
for (Object item : list) {
call2(item);
}
private void call1() {
count += 100;
private void call2(Object item) {
count++;
public void check() {
TestCls t = new TestCls();
t.test(Arrays.asList("1", "2"));
assertThat(t.count).isEqualTo(102);
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    // TODO: Add assertions
}

#[test]
fn try_catch_finally12_test() {
    let status = tools_status();
    if !status.can_run_tests() {
        eprintln!("SKIPPED: {}", status.skip_reason());
        return;
    }

    let helper = IntegrationTestHelper::new("try_catch_finally12_test");
    let source = r#"
public class TestCls {
private StringBuilder sb;
public void test1(int excType) {
try {
call(excType);
} catch (NullPointerException e) {
sb.append("-catch");
}
sb.append("-out");
} finally {
sb.append("-finally");
public void test2(int excType) {
public void test3(int excType) {
public void call(int excType) {
sb.append("call");
switch (excType) {
case 1:
sb.append("-npe");
throw new NullPointerException();
case 2:
sb.append("-iae");
throw new IllegalArgumentException();
public String runTest(int testNumber, int excType) {
sb = new StringBuilder();
switch (testNumber) {
test1(excType);
break;
test2(excType);
case 3:
test3(excType);
} catch (IllegalArgumentException e) {
assertThat(excType).isEqualTo(2);
return sb.toString();
public void check() {
assertThat(runTest(1, 0)).isEqualTo("call-out-finally");
assertThat(runTest(1, 1)).isEqualTo("call-npe-catch-out-finally");
assertThat(runTest(1, 2)).isEqualTo("call-iae-finally");
assertThat(runTest(2, 0)).isEqualTo("call-finally");
assertThat(runTest(2, 1)).isEqualTo("call-npe-catch-finally");
assertThat(runTest(2, 2)).isEqualTo("call-iae-finally");
assertThat(runTest(3, 0)).isEqualTo("call-finally");
assertThat(runTest(3, 1)).isEqualTo("call-npe-catch-finally");
assertThat(runTest(3, 2)).isEqualTo("call-iae-finally");
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    // TODO: Add assertions
}

#[test]
fn try_catch_finally12_test_without_finally() {
    let status = tools_status();
    if !status.can_run_tests() {
        eprintln!("SKIPPED: {}", status.skip_reason());
        return;
    }

    let helper = IntegrationTestHelper::new("try_catch_finally12_test_without_finally");
    let source = r#"
public class TestCls {
private StringBuilder sb;
public void test1(int excType) {
try {
call(excType);
} catch (NullPointerException e) {
sb.append("-catch");
}
sb.append("-out");
} finally {
sb.append("-finally");
public void test2(int excType) {
public void test3(int excType) {
public void call(int excType) {
sb.append("call");
switch (excType) {
case 1:
sb.append("-npe");
throw new NullPointerException();
case 2:
sb.append("-iae");
throw new IllegalArgumentException();
public String runTest(int testNumber, int excType) {
sb = new StringBuilder();
switch (testNumber) {
test1(excType);
break;
test2(excType);
case 3:
test3(excType);
} catch (IllegalArgumentException e) {
assertThat(excType).isEqualTo(2);
return sb.toString();
public void check() {
assertThat(runTest(1, 0)).isEqualTo("call-out-finally");
assertThat(runTest(1, 1)).isEqualTo("call-npe-catch-out-finally");
assertThat(runTest(1, 2)).isEqualTo("call-iae-finally");
assertThat(runTest(2, 0)).isEqualTo("call-finally");
assertThat(runTest(2, 1)).isEqualTo("call-npe-catch-finally");
assertThat(runTest(2, 2)).isEqualTo("call-iae-finally");
assertThat(runTest(3, 0)).isEqualTo("call-finally");
assertThat(runTest(3, 1)).isEqualTo("call-npe-catch-finally");
assertThat(runTest(3, 2)).isEqualTo("call-iae-finally");
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    // TODO: Add assertions
}

#[test]
fn try_catch_finally15_test() {
    let status = tools_status();
    if !status.can_run_tests() {
        eprintln!("SKIPPED: {}", status.skip_reason());
        return;
    }

    let helper = IntegrationTestHelper::new("try_catch_finally15_test");
    // TODO: Extract test source
    let source = r#"
public class TestCls {
    // Add test code here
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .contains_one("this.zza.transact(i, parcel, parcelObtain, 0);")
        .does_not_contain("parcel = Parcel.obtain();");
}

#[test]
fn try_catch_finally2_test() {
    let status = tools_status();
    if !status.can_run_tests() {
        eprintln!("SKIPPED: {}", status.skip_reason());
        return;
    }

    let helper = IntegrationTestHelper::new("try_catch_finally2_test");
    let source = r#"
public class TestCls {
private ClspClass[] classes;
public void test(OutputStream output) throws IOException {
DataOutputStream out = new DataOutputStream(output);
try {
out.writeByte(1);
out.writeInt(classes.length);
for (ClspClass cls : classes) {
writeString(out, cls.getName());
}
ArgType[] parents = cls.getParents();
out.writeByte(parents.length);
for (ArgType parent : parents) {
out.writeInt(parent.getObject().hashCode());
} finally {
out.close();
private void writeString(DataOutputStream out, String name) {
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    // TODO: Add assertions
}

#[test]
fn try_catch_finally3_test() {
    let status = tools_status();
    if !status.can_run_tests() {
        eprintln!("SKIPPED: {}", status.skip_reason());
        return;
    }

    let helper = IntegrationTestHelper::new("try_catch_finally3_test");
    let source = r#"
public class TestCls {
private static final Logger LOG = LoggerFactory.getLogger(TestCls.class);
public static void test(ClassNode cls, List<IDexTreeVisitor> passes) {
try {
cls.load();
for (IDexTreeVisitor visitor : passes) {
DepthTraversal.visit(visitor, cls);
}
} catch (Exception e) {
LOG.error("Class process exception: {}", cls, e);
} finally {
cls.unload();
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .contains_one("for (IDexTreeVisitor visitor : passes) {")
        .contains_one("} catch (Exception e) {")
        .contains_one("} finally {")
        .contains_one("cls.unload();");
}

#[test]
fn try_catch_finally4_test() {
    let status = tools_status();
    if !status.can_run_tests() {
        eprintln!("SKIPPED: {}", status.skip_reason());
        return;
    }

    let helper = IntegrationTestHelper::new("try_catch_finally4_test");
    let source = r#"
public class TestCls {
public void test() throws IOException {
File file = File.createTempFile("test", "txt");
OutputStream outputStream = new FileOutputStream(file);
try {
outputStream.write(1);
} finally {
outputStream.close();
file.delete();
} catch (IOException ignored) {
}
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .contains_one("OutputStream outputStream = new FileOutputStream(file);")
        .contains_one("outputStream.write(1);");
}

#[test]
fn try_catch_finally5_test() {
    let status = tools_status();
    if !status.can_run_tests() {
        eprintln!("SKIPPED: {}", status.skip_reason());
        return;
    }

    let helper = IntegrationTestHelper::new("try_catch_finally5_test");
    let source = r#"
public class TestCls {
public <E> List<E> test(A a, B<E> b) {
C c = p(a);
if (c == null) {
return null;
}
D d = b.f(c);
try {
if (!d.first()) {
List<E> list = new ArrayList<>();
do {
list.add(b.load(d));
} while (d.toNext());
return list;
} finally {
d.close();
private C p(A a) {
return (C) a;
private interface A {
private interface B<T> {
D f(C c);
T load(D d);
private interface C {
private interface D {
boolean first();
boolean toNext();
void close();
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    // TODO: Add assertions
}

#[test]
fn try_catch_finally6_test() {
    let status = tools_status();
    if !status.can_run_tests() {
        eprintln!("SKIPPED: {}", status.skip_reason());
        return;
    }

    let helper = IntegrationTestHelper::new("try_catch_finally6_test");
    let source = r#"
public class TestCls {
public static void test() throws IOException {
InputStream is = null;
try {
call();
is = new FileInputStream("1.txt");
} finally {
if (is != null) {
is.close();
}
private static void call() {
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    // TODO: Add assertions
}

#[test]
fn try_catch_finally6_test_no_debug() {
    let status = tools_status();
    if !status.can_run_tests() {
        eprintln!("SKIPPED: {}", status.skip_reason());
        return;
    }

    let helper = IntegrationTestHelper::new("try_catch_finally6_test_no_debug");
    let source = r#"
public class TestCls {
public static void test() throws IOException {
InputStream is = null;
try {
call();
is = new FileInputStream("1.txt");
} finally {
if (is != null) {
is.close();
}
private static void call() {
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .contains_one("if (0 != 0) {");
}

#[test]
fn try_catch_finally7_test() {
    let status = tools_status();
    if !status.can_run_tests() {
        eprintln!("SKIPPED: {}", status.skip_reason());
        return;
    }

    let helper = IntegrationTestHelper::new("try_catch_finally7_test");
    let source = r#"
public class TestCls {
private int f = 0;
private boolean test(Object obj) {
boolean res;
try {
res = exc(obj);
} catch (Exception e) {
res = false;
} finally {
f++;
}
return res;
private boolean exc(Object obj) throws Exception {
if ("r".equals(obj)) {
throw new AssertionError();
return true;
public void check() {
f = 0;
assertThat(test(null)).isTrue();
assertThat(f).isEqualTo(1);
test("r");
} catch (AssertionError e) {
// pass
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .contains("try {")
        .contains("exc(obj);")
        .contains("} catch (Exception e) {")
        .does_not_contain("throw th;")
        .does_not_contain("throw th;");
}

#[test]
fn try_catch_finally7_test_no_debug() {
    let status = tools_status();
    if !status.can_run_tests() {
        eprintln!("SKIPPED: {}", status.skip_reason());
        return;
    }

    let helper = IntegrationTestHelper::new("try_catch_finally7_test_no_debug");
    let source = r#"
public class TestCls {
private int f = 0;
private boolean test(Object obj) {
boolean res;
try {
res = exc(obj);
} catch (Exception e) {
res = false;
} finally {
f++;
}
return res;
private boolean exc(Object obj) throws Exception {
if ("r".equals(obj)) {
throw new AssertionError();
return true;
public void check() {
f = 0;
assertThat(test(null)).isTrue();
assertThat(f).isEqualTo(1);
test("r");
} catch (AssertionError e) {
// pass
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .does_not_contain("throw th;");
}

#[test]
fn try_catch_finally8_test2() {
    let status = tools_status();
    if !status.can_run_tests() {
        eprintln!("SKIPPED: {}", status.skip_reason());
        return;
    }

    let helper = IntegrationTestHelper::new("try_catch_finally8_test2");
    let source = r#"
public class TestCls {
public Object test(Object obj) {
File file = new File("r");
FileOutputStream output = null;
try {
output = new FileOutputStream(file);
if (obj.equals("a")) {
return new Object();
} else {
return null;
}
} catch (IOException e) {
System.out.println("Exception");
} finally {
if (output != null) {
output.close();
// Ignored
file.delete();
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .contains("output = new FileOutputStream(file);");
}

#[test]
fn try_catch_finally9_test() {
    let status = tools_status();
    if !status.can_run_tests() {
        eprintln!("SKIPPED: {}", status.skip_reason());
        return;
    }

    let helper = IntegrationTestHelper::new("try_catch_finally9_test");
    let source = r#"
public class TestCls {
public String test() throws IOException {
InputStream input = null;
try {
input = this.getClass().getResourceAsStream("resource");
Scanner scanner = new Scanner(input).useDelimiter("\\A");
return scanner.hasNext() ? scanner.next() : "";
} finally {
if (input != null) {
input.close();
}
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .does_not_contain("JADX INFO: finally extract failed");
}

#[test]
fn try_catch_in_if_test() {
    let status = tools_status();
    if !status.can_run_tests() {
        eprintln!("SKIPPED: {}", status.skip_reason());
        return;
    }

    let helper = IntegrationTestHelper::new("try_catch_in_if_test");
    let source = r#"
public class TestCls {
private String test(String name, String value) {
if (value != null) {
try {
int key;
if (value.startsWith("0x")) {
value = value.substring(2);
key = Integer.parseInt(value, 16);
} else {
key = Integer.parseInt(value);
}
return name + '=' + key;
} catch (NumberFormatException e) {
return "Failed to parse number";
System.out.println("?");
return null;
public void check() {
assertThat(test("n", null)).isNull();
assertThat(test("n", "7")).isEqualTo("n=7");
assertThat(test("n", "0x" + Integer.toHexString(77))).isEqualTo("n=77");
assertThat(test("n", "abc")).isEqualTo("Failed to parse number");
assertThat(test("n", "0xabX")).isEqualTo("Failed to parse number");
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .contains_one("try {")
        .contains_one("} catch (NumberFormatException e) {");
}

#[test]
fn try_catch_last_insn_test() {
    let status = tools_status();
    if !status.can_run_tests() {
        eprintln!("SKIPPED: {}", status.skip_reason());
        return;
    }

    let helper = IntegrationTestHelper::new("try_catch_last_insn_test");
    // TODO: Extract test source
    let source = r#"
public class TestCls {
    // Add test code here
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .contains_one("return call();");
}

#[test]
fn try_catch_multi_exception_test() {
    let status = tools_status();
    if !status.can_run_tests() {
        eprintln!("SKIPPED: {}", status.skip_reason());
        return;
    }

    let helper = IntegrationTestHelper::new("try_catch_multi_exception_test");
    let source = r#"
public class TestCls {
public void test() {
try {
System.out.println("Test");
} catch (ProviderException | DateTimeException e) {
throw new RuntimeException(e);
}
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    // TODO: Add assertions
}

#[test]
fn try_catch_multi_exception2_test() {
    let status = tools_status();
    if !status.can_run_tests() {
        eprintln!("SKIPPED: {}", status.skip_reason());
        return;
    }

    let helper = IntegrationTestHelper::new("try_catch_multi_exception2_test");
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
fn try_catch_no_move_exc_test() {
    let status = tools_status();
    if !status.can_run_tests() {
        eprintln!("SKIPPED: {}", status.skip_reason());
        return;
    }

    let helper = IntegrationTestHelper::new("try_catch_no_move_exc_test");
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
fn try_catch_no_move_exc2_test() {
    let status = tools_status();
    if !status.can_run_tests() {
        eprintln!("SKIPPED: {}", status.skip_reason());
        return;
    }

    let helper = IntegrationTestHelper::new("try_catch_no_move_exc2_test");
    // TODO: Extract test source
    let source = r#"
public class TestCls {
    // Add test code here
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .contains_one("try {");
}

#[test]
fn try_catch_start_on_move_test() {
    let status = tools_status();
    if !status.can_run_tests() {
        eprintln!("SKIPPED: {}", status.skip_reason());
        return;
    }

    let helper = IntegrationTestHelper::new("try_catch_start_on_move_test");
    // TODO: Extract test source
    let source = r#"
public class TestCls {
    // Add test code here
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .contains_one("try {")
        .contains_one("} catch (Exception e) {");
}

#[test]
fn try_with_empty_catch_test() {
    let status = tools_status();
    if !status.can_run_tests() {
        eprintln!("SKIPPED: {}", status.skip_reason());
        return;
    }

    let helper = IntegrationTestHelper::new("try_with_empty_catch_test");
    // TODO: Extract test source
    let source = r#"
public class TestCls {
    // Add test code here
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .contains_one("try {")
        .contains_one("if (");
}

#[test]
fn try_with_empty_catch_triple_test() {
    let status = tools_status();
    if !status.can_run_tests() {
        eprintln!("SKIPPED: {}", status.skip_reason());
        return;
    }

    let helper = IntegrationTestHelper::new("try_with_empty_catch_triple_test");
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
fn unreachable_catch_test() {
    let status = tools_status();
    if !status.can_run_tests() {
        eprintln!("SKIPPED: {}", status.skip_reason());
        return;
    }

    let helper = IntegrationTestHelper::new("unreachable_catch_test");
    // TODO: Extract test source
    let source = r#"
public class TestCls {
    // Add test code here
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .contains("IOException")
        .contains("Collections.unmodifiableMap");
}

#[test]
fn multi_exception_catch_test_2() {
    let status = tools_status();
    if !status.can_run_tests() {
        eprintln!("SKIPPED: {}", status.skip_reason());
        return;
    }

    let helper = IntegrationTestHelper::new("multi_exception_catch_test");
    // Tests multi-catch syntax (catch (Type1 | Type2 e))
    // CLAUDE.md documents multi-catch as implemented - this validates that feature
    let source = r#"
import java.time.DateTimeException;
import javax.security.auth.login.CredentialException;

public class TestCls {
    public void test() {
        try {
            System.out.println("Test");
        } catch (CredentialException | DateTimeException e) {
            throw new RuntimeException(e);
        }
    }
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .contains("try {")
        .contains("} catch (")
        .contains(" | ")
        .contains("throw new RuntimeException(e);");
}

#[test]
fn try_catch_basic_test() {
    let status = tools_status();
    if !status.can_run_tests() {
        eprintln!("SKIPPED: {}", status.skip_reason());
        return;
    }

    let helper = IntegrationTestHelper::new("try_catch_basic_test");
    // Foundation test for basic try-catch functionality
    let source = r#"
public class TestCls {
    public void f() {
        try {
            Thread.sleep(50L);
        } catch (InterruptedException e) {
            // ignore
        }
    }
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .contains("try {")
        .contains("Thread.sleep(50L);")
        .contains("} catch (InterruptedException e) {");
}

#[test]
fn nested_try_catch_test_2() {
    let status = tools_status();
    if !status.can_run_tests() {
        eprintln!("SKIPPED: {}", status.skip_reason());
        return;
    }

    let helper = IntegrationTestHelper::new("nested_try_catch_test");
    // Tests nested try-catch blocks
    let source = r#"
public class TestCls {
    public void test() {
        try {
            call();
        } catch (Exception e) {
            try {
                handleError(e);
            } catch (Exception ex) {
                System.err.println("Error handling failed");
            }
        }
    }

    private void call() throws Exception {}
    private void handleError(Exception e) throws Exception {}
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .count_string(2, "try {")
        .count_string(2, "} catch (Exception");
}

#[test]
fn unreachable_catch2_test() {
    let status = tools_status();
    if !status.can_run_tests() {
        eprintln!("SKIPPED: {}", status.skip_reason());
        return;
    }

    let helper = IntegrationTestHelper::new("unreachable_catch2_test");
    // TODO: Extract test source
    let source = r#"
public class TestCls {
    // Add test code here
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .does_not_contain("break;");
}
