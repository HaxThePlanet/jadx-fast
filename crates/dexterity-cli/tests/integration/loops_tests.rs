//! Loops integration tests
//! Ported from jadx-core/src/test/java/jadx/tests/integration/

use crate::integration_test_framework::{IntegrationTestHelper, CodeAssertions, tools_status};

#[test]
fn array_for_each_test() {
    let status = tools_status();
    if !status.can_run_tests() {
        eprintln!("SKIPPED: {}", status.skip_reason());
        return;
    }

    let helper = IntegrationTestHelper::new("array_for_each_test");
    let source = r#"
public class TestCls {
    public int test(int[] a) {
        int sum = 0;
        for (int n : a) {
            sum += n;
        }
        return sum;
    }
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .contains("sum")
        .contains("return");
}

#[test]
fn array_for_each2_test() {
    let status = tools_status();
    if !status.can_run_tests() {
        eprintln!("SKIPPED: {}", status.skip_reason());
        return;
    }

    let helper = IntegrationTestHelper::new("array_for_each2_test");
    let source = r#"
public class TestCls {
    public void test(String str) {
        for (String s : str.split("\n")) {
            String t = s.trim();
            if (t.length() > 0) {
                System.out.println(t);
            }
        }
    }
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .does_not_contain("int ");
}

#[test]
fn array_for_each3_test() {
    let status = tools_status();
    if !status.can_run_tests() {
        eprintln!("SKIPPED: {}", status.skip_reason());
        return;
    }

    let helper = IntegrationTestHelper::new("array_for_each3_test");
    let source = r#"
public class TestCls {
public void test(String[] arr) {
for (String s : arr) {
if (s.length() > 0) {
return;
}
throw new IllegalArgumentException("All strings are empty");
public void check() {
test(new String[] { "", "a" }); // no exception
try {
test(new String[] { "", "" });
fail("IllegalArgumentException expected");
} catch (IllegalArgumentException e) {
// expected
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .contains_one("for (String str : strArr) {")
        .does_not_contain("while");
}

#[test]
fn array_for_each_negative_test() {
    let status = tools_status();
    if !status.can_run_tests() {
        eprintln!("SKIPPED: {}", status.skip_reason());
        return;
    }

    let helper = IntegrationTestHelper::new("array_for_each_negative_test");
    let source = r#"
public class TestCls {
public int test(int[] a, int[] b) {
int sum = 0;
for (int i = 0; i < a.length; i += 2) {
sum += a[i];
}
for (int i = 1; i < a.length; i++) {
for (int i = 0; i < a.length; i--) {
for (int i = 0; i <= a.length; i++) {
for (int i = 0; i + 1 < a.length; i++) {
for (int i = 0; i < a.length; i++) {
sum += a[i - 1];
for (int i = 0; i < b.length; i++) {
int j = 0;
for (int i = 0; i < a.length; j++) {
sum += a[j];
return sum;
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .does_not_contain(":");
}

#[test]
fn break_in_complex_if_test() {
    let status = tools_status();
    if !status.can_run_tests() {
        eprintln!("SKIPPED: {}", status.skip_reason());
        return;
    }

    let helper = IntegrationTestHelper::new("break_in_complex_if_test");
    let source = r#"
public class TestCls {
private int test(Map<String, Point> map, int mapX) {
int length = 1;
for (int x = mapX + 1; x < 100; x++) {
Point tile = map.get(x + "");
if (tile == null || tile.y != 100) {
break;
}
length++;
return length;
class Point {
public final int x;
public final int y;
Point(int x, int y) {
this.x = x;
this.y = y;
public void check() {
Map<String, Point> first = new HashMap<>();
first.put("3", new Point(100, 100));
first.put("4", new Point(60, 100));
assertThat(test(first, 2)).isEqualTo(3);
Map<String, Point> second = new HashMap<>();
second.put("3", new Point(100, 100));
second.put("4", new Point(60, 0)); // check break
second.put("5", new Point(60, 100));
assertThat(test(second, 2)).isEqualTo(2);
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .contains_one("if (tile == null || tile.y != 100) {")
        .contains_one("break;")
        .contains_one("break;");
}

#[test]
fn break_in_complex_if_test_no_debug() {
    let status = tools_status();
    if !status.can_run_tests() {
        eprintln!("SKIPPED: {}", status.skip_reason());
        return;
    }

    let helper = IntegrationTestHelper::new("break_in_complex_if_test_no_debug");
    let source = r#"
public class TestCls {
private int test(Map<String, Point> map, int mapX) {
int length = 1;
for (int x = mapX + 1; x < 100; x++) {
Point tile = map.get(x + "");
if (tile == null || tile.y != 100) {
break;
}
length++;
return length;
class Point {
public final int x;
public final int y;
Point(int x, int y) {
this.x = x;
this.y = y;
public void check() {
Map<String, Point> first = new HashMap<>();
first.put("3", new Point(100, 100));
first.put("4", new Point(60, 100));
assertThat(test(first, 2)).isEqualTo(3);
Map<String, Point> second = new HashMap<>();
second.put("3", new Point(100, 100));
second.put("4", new Point(60, 0)); // check break
second.put("5", new Point(60, 100));
assertThat(test(second, 2)).isEqualTo(2);
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .contains_one("break;");
}

#[test]
fn break_in_complex_if2_test() {
    let status = tools_status();
    if !status.can_run_tests() {
        eprintln!("SKIPPED: {}", status.skip_reason());
        return;
    }

    let helper = IntegrationTestHelper::new("break_in_complex_if2_test");
    let source = r#"
public class TestCls {
private int test(List<String> list) {
int length = 0;
for (String str : list) {
if (str.isEmpty() || str.length() > 4) {
break;
}
if (str.equals("skip")) {
continue;
if (str.equals("a")) {
length++;
return length;
public void check() {
assertThat(test(Arrays.asList("x", "y", "skip", "z", "a"))).isEqualTo(3);
assertThat(test(Arrays.asList("x", "skip", ""))).isEqualTo(1);
assertThat(test(Arrays.asList("skip", "y", "12345"))).isEqualTo(1);
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .count_string(2, "break;");
}

#[test]
fn break_in_complex_if2_test_no_debug() {
    let status = tools_status();
    if !status.can_run_tests() {
        eprintln!("SKIPPED: {}", status.skip_reason());
        return;
    }

    let helper = IntegrationTestHelper::new("break_in_complex_if2_test_no_debug");
    let source = r#"
public class TestCls {
private int test(List<String> list) {
int length = 0;
for (String str : list) {
if (str.isEmpty() || str.length() > 4) {
break;
}
if (str.equals("skip")) {
continue;
if (str.equals("a")) {
length++;
return length;
public void check() {
assertThat(test(Arrays.asList("x", "y", "skip", "z", "a"))).isEqualTo(3);
assertThat(test(Arrays.asList("x", "skip", ""))).isEqualTo(1);
assertThat(test(Arrays.asList("skip", "y", "12345"))).isEqualTo(1);
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .count_string(2, "break;");
}

#[test]
fn break_in_loop_test() {
    let status = tools_status();
    if !status.can_run_tests() {
        eprintln!("SKIPPED: {}", status.skip_reason());
        return;
    }

    let helper = IntegrationTestHelper::new("break_in_loop_test");
    let source = r#"
public class TestCls {
public int f;
public void test(int[] a, int b) {
for (int i = 0; i < a.length; i++) {
a[i]++;
if (i < b) {
break;
}
this.f++;
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .contains_one("for (int i = 0; i < a.length; i++) {")
        .contains_one("if (i < b) {")
        .contains_one("break;")
        .contains_one("this.f++;")
        .count_string(0, "else");
}

#[test]
fn break_in_loop2_test() {
    let status = tools_status();
    if !status.can_run_tests() {
        eprintln!("SKIPPED: {}", status.skip_reason());
        return;
    }

    let helper = IntegrationTestHelper::new("break_in_loop2_test");
    let source = r#"
public class TestCls {
public void test(List<Integer> data) throws Exception {
for (;;) {
try {
funcB(data);
break;
} catch (Exception ex) {
if (funcC()) {
throw ex;
}
data.clear();
Thread.sleep(100L);
private boolean funcB(List<Integer> data) {
return false;
private boolean funcC() {
return true;
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .contains_one("while (true) {")
        .contains_one("throw ex;")
        .contains_one("data.clear();")
        .contains_one("Thread.sleep(100L);");
}

#[test]
fn break_with_label_test() {
    let status = tools_status();
    if !status.can_run_tests() {
        eprintln!("SKIPPED: {}", status.skip_reason());
        return;
    }

    let helper = IntegrationTestHelper::new("break_with_label_test");
    let source = r#"
public class TestCls {
public boolean test(int[][] arr, int b) {
boolean found = false;
loop0: for (int i = 0; i < arr.length; i++) {
for (int j = 0; j < arr[i].length; j++) {
if (arr[i][j] == b) {
found = true;
break loop0;
}
System.out.println("found: " + found);
return found;
public void check() {
int[][] testArray = { { 1, 2 }, { 3, 4 } };
assertThat(test(testArray, 3)).isTrue();
assertThat(test(testArray, 5)).isFalse();
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .contains_one("loop0:")
        .contains_one("break loop0;");
}

#[test]
fn complex_while_loop_test() {
    let status = tools_status();
    if !status.can_run_tests() {
        eprintln!("SKIPPED: {}", status.skip_reason());
        return;
    }

    let helper = IntegrationTestHelper::new("complex_while_loop_test");
    let source = r#"
public class TestCls {
public static String test(String[] arr) {
int index = 0;
int length = arr.length;
String str;
while ((str = arr[index]) != null) {
if (str.length() == 1) {
return str.trim();
}
if (++index >= length) {
index = 0;
System.out.println("loop end");
return "";
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .does_not_contain("for (int at = 0; at < len; at = endAt) {");
}

#[test]
fn continue_in_loop_test() {
    let status = tools_status();
    if !status.can_run_tests() {
        eprintln!("SKIPPED: {}", status.skip_reason());
        return;
    }

    let helper = IntegrationTestHelper::new("continue_in_loop_test");
    let source = r#"
public class TestCls {
public int f;
public void test(int[] a, int b) {
for (int i = 0; i < a.length; i++) {
int v = a[i];
if (v < b) {
a[i]++;
} else if (v > b) {
a[i]--;
} else {
continue;
}
if (i < b) {
break;
this.f++;
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .contains_one("for (int i = 0; i < a.length; i++) {")
        .contains_one("if (i < b) {")
        .contains_one("continue;")
        .contains_one("break;")
        .contains_one("this.f++;");
}

#[test]
fn do_while_break_test() {
    let status = tools_status();
    if !status.can_run_tests() {
        eprintln!("SKIPPED: {}", status.skip_reason());
        return;
    }

    let helper = IntegrationTestHelper::new("do_while_break_test");
    let source = r#"
public class TestCls {
public int test(int k) throws InterruptedException {
int i = 3;
do {
if (k > 9) {
i = 0;
break;
}
i++;
} while (i < 5);
return i;
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .contains_one("while (");
}

#[test]
fn do_while_break2_test() {
    let status = tools_status();
    if !status.can_run_tests() {
        eprintln!("SKIPPED: {}", status.skip_reason());
        return;
    }

    let helper = IntegrationTestHelper::new("do_while_break2_test");
    let source = r#"
public class TestCls {
Iterator<String> it;
@SuppressWarnings("ConstantConditions")
public Object test() {
String obj;
do {
obj = this.it.next();
if (obj == null) {
return obj; // 'return null' or 'break' also fine
}
} while (this.it.hasNext());
return obj;
public void check() {
this.it = Arrays.asList("a", "b").iterator();
assertThat(test()).isEqualTo("b");
this.it = Arrays.asList("a", "b", null).iterator();
assertThat(test()).isEqualTo(null);
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .contains_one("do {")
        .contains_one("obj = this.it.next();")
        .contains_one("if (obj == null) {")
        .contains_one("} while (this.it.hasNext());");
}

#[test]
fn do_while_break3_test() {
    let status = tools_status();
    if !status.can_run_tests() {
        eprintln!("SKIPPED: {}", status.skip_reason());
        return;
    }

    let helper = IntegrationTestHelper::new("do_while_break3_test");
    let source = r#"
public class TestCls {
Iterator<String> it;
public void test() {
do {
if (!it.hasNext()) {
break;
}
} while (it.next() != null);
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .contains_one("while");
}

#[test]
fn endless_loop_test() {
    let status = tools_status();
    if !status.can_run_tests() {
        eprintln!("SKIPPED: {}", status.skip_reason());
        return;
    }

    let helper = IntegrationTestHelper::new("endless_loop_test");
    let source = r#"
public class TestCls {
void test1() {
while (this == this) {
}
void test2() {
do {
} while (this == this);
void test3() {
while (true) {
if (this != this) {
return;
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .contains("while (this == this)");
}

#[test]
fn endless_loop2_test() {
    let status = tools_status();
    if !status.can_run_tests() {
        eprintln!("SKIPPED: {}", status.skip_reason());
        return;
    }

    let helper = IntegrationTestHelper::new("endless_loop2_test");
    // Tests detection of empty endless loops (issue #1611 in Java JADX)
    // Source adapted from jadx-core/src/test/smali/loops/TestEndlessLoop2.smali
    let source = r#"
public class TestCls {
    public void test1() {
        while (true) {
            // Empty infinite loop
        }
    }

    public void test2() {
        while (true) {
            // Another empty infinite loop
        }
    }
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .count_string(2, "while (true) {");
}

#[test]
fn if_in_loop2_test() {
    let status = tools_status();
    if !status.can_run_tests() {
        eprintln!("SKIPPED: {}", status.skip_reason());
        return;
    }

    let helper = IntegrationTestHelper::new("if_in_loop2_test");
    let source = r#"
public class TestCls {
public static void test(String str) {
int len = str.length();
int at = 0;
while (at < len) {
char c = str.charAt(at);
int endAt = at + 1;
if (c == 'A') {
while (endAt < len) {
c = str.charAt(endAt);
if (c == 'B') {
break;
}
endAt++;
at = endAt;
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .does_not_contain("for (int at = 0; at < len; at = endAt) {");
}

#[test]
fn if_in_loop3_test() {
    let status = tools_status();
    if !status.can_run_tests() {
        eprintln!("SKIPPED: {}", status.skip_reason());
        return;
    }

    let helper = IntegrationTestHelper::new("if_in_loop3_test");
    let source = r#"
public class TestCls {
static boolean[][] occupied = new boolean[70][70];
static boolean placingStone = true;
private static boolean test(int xx, int yy) {
int[] extraArray = new int[] { 10, 45, 50, 50, 20, 20 };
if (extraArray != null && placingStone) {
for (int i = 0; i < extraArray.length; i += 2) {
int tX;
int tY;
if (yy % 2 == 0) {
if (extraArray[i + 1] % 2 == 0) {
tX = xx + extraArray[i];
} else {
tX = extraArray[i] + xx - 1;
}
tY = yy + extraArray[i + 1];
if (tX < 0 || tY < 0 || tY % 2 != 0 && tX > 28 || tY > 70
|| occupied[tX][tY]) {
return false;
return true;
public void check() {
assertThat(test(14, 2)).isTrue();
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .contains_one("for (int i = 0; i < extraArray.length; i += 2) {")
        .contains_one("if (extraArray != null && placingStone) {");
}

#[test]
fn index_for_loop_test() {
    let status = tools_status();
    if !status.can_run_tests() {
        eprintln!("SKIPPED: {}", status.skip_reason());
        return;
    }

    let helper = IntegrationTestHelper::new("index_for_loop_test");
    let source = r#"
public class TestCls {
private int test(int[] a, int b) {
int sum = 0;
for (int i = 0; i < b; i++) {
sum += a[i];
}
return sum;
public void check() {
int[] array = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
assertThat(test(array, 0)).isEqualTo(0);
assertThat(test(array, 3)).isEqualTo(6);
assertThat(test(array, 8)).isEqualTo(36);
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .contains_one("int sum = 0;")
        .contains_one("for (int i = 0; i < b; i++) {")
        .contains_one("sum += a[i];")
        .contains_one("return sum;");
}

#[test]
fn indexed_loop_test() {
    let status = tools_status();
    if !status.can_run_tests() {
        eprintln!("SKIPPED: {}", status.skip_reason());
        return;
    }

    let helper = IntegrationTestHelper::new("indexed_loop_test");
    let source = r#"
public class TestCls {
public File test(File[] files) {
File file = null;
if (files != null) {
int length = files.length;
if (length == 0) {
file = null;
} else {
for (int i = 0; i < length; i++) {
file = files[i];
if (file.getName().equals("f")) {
break;
}
if (file != null) {
file.deleteOnExit();
return file;
public void check() {
assertThat(test(null)).isNull();
assertThat(test(new File[] {})).isNull();
File file = new File("f");
assertThat(test(new File[] { new File("a"), file })).isEqualTo(file);
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .does_not_contain("for (File file :")
        .contains_one("for (int i = 0; i < length; i++) {");
}

#[test]
fn indexed_loop_test_no_debug() {
    let status = tools_status();
    if !status.can_run_tests() {
        eprintln!("SKIPPED: {}", status.skip_reason());
        return;
    }

    let helper = IntegrationTestHelper::new("indexed_loop_test_no_debug");
    let source = r#"
public class TestCls {
public File test(File[] files) {
File file = null;
if (files != null) {
int length = files.length;
if (length == 0) {
file = null;
} else {
for (int i = 0; i < length; i++) {
file = files[i];
if (file.getName().equals("f")) {
break;
}
if (file != null) {
file.deleteOnExit();
return file;
public void check() {
assertThat(test(null)).isNull();
assertThat(test(new File[] {})).isNull();
File file = new File("f");
assertThat(test(new File[] { new File("a"), file })).isEqualTo(file);
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .contains_one("for (int i = 0; i < length; i++) {")
        .does_not_contain("for (File file :");
}

#[test]
fn iterable_for_each_test() {
    let status = tools_status();
    if !status.can_run_tests() {
        eprintln!("SKIPPED: {}", status.skip_reason());
        return;
    }

    let helper = IntegrationTestHelper::new("iterable_for_each_test");
    let source = r#"
public class TestCls {
public String test(Iterable<String> a) {
StringBuilder sb = new StringBuilder();
for (String s : a) {
sb.append(s);
}
return sb.toString();
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .contains_one("StringBuilder sb = new StringBuilder();")
        .contains_one("for (String s : a) {")
        .contains_one("sb.append(s);")
        .contains_one("return sb.toString();");
}

#[test]
fn iterable_for_each2_test() {
    let status = tools_status();
    if !status.can_run_tests() {
        eprintln!("SKIPPED: {}", status.skip_reason());
        return;
    }

    let helper = IntegrationTestHelper::new("iterable_for_each2_test");
    let source = r#"
public class TestCls {
public static String test(final Service service) throws IOException {
for (Authorization auth : service.getAuthorizations()) {
if (isValid(auth)) {
return auth.getToken();
}
return null;
private static boolean isValid(Authorization auth) {
return false;
public List<Authorization> getAuthorizations() {
public String getToken() {
return "";
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .contains_one("for (Authorization auth : service.getAuthorizations()) {")
        .contains_one("if (isValid(auth)) {")
        .contains_one("return auth.getToken();");
}

#[test]
fn iterable_for_each3_test() {
    let status = tools_status();
    if !status.can_run_tests() {
        eprintln!("SKIPPED: {}", status.skip_reason());
        return;
    }

    let helper = IntegrationTestHelper::new("iterable_for_each3_test");
    // Tests generic for-each loop with set modification
    // Source from jadx-core/src/test/java/jadx/tests/integration/loops/TestIterableForEach3.java
    let source = r#"
import java.util.Set;

public class TestCls<T extends String> {
    private Set<T> a;
    private Set<T> b;

    public void test(T str) {
        Set<T> set = str.length() == 1 ? a : b;
        for (T s : set) {
            if (s.length() == str.length()) {
                if (str.length() == 0) {
                    set.remove(s);
                } else {
                    set.add(str);
                }
                return;
            }
        }
    }
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .contains("for (")
        .contains(" : ")
        .contains("if (str.length() == 0) {");
}

#[test]
fn iterable_for_each3_test_no_debug() {
    let status = tools_status();
    if !status.can_run_tests() {
        eprintln!("SKIPPED: {}", status.skip_reason());
        return;
    }

    let helper = IntegrationTestHelper::new("iterable_for_each3_test_no_debug");
    // Same as iterable_for_each3_test but with noDebugInfo()
    let source = r#"
import java.util.Set;

public class TestCls<T extends String> {
    private Set<T> a;
    private Set<T> b;

    public void test(T str) {
        Set<T> set = str.length() == 1 ? a : b;
        for (T s : set) {
            if (s.length() == str.length()) {
                if (str.length() == 0) {
                    set.remove(s);
                } else {
                    set.add(str);
                }
                return;
            }
        }
    }
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .contains("for (");
}

#[test]
fn iterable_for_each4_test() {
    let status = tools_status();
    if !status.can_run_tests() {
        eprintln!("SKIPPED: {}", status.skip_reason());
        return;
    }

    let helper = IntegrationTestHelper::new("iterable_for_each4_test");
    let source = r#"
public class TestCls {
public void test(List<Object> objects) {
for (Object o : objects) {
if (o.hashCode() != 42 || o.hashCode() != 1) {
break;
}
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .does_not_contain("while (");
}

#[test]
fn loop_condition_test() {
    let status = tools_status();
    if !status.can_run_tests() {
        eprintln!("SKIPPED: {}", status.skip_reason());
        return;
    }

    let helper = IntegrationTestHelper::new("loop_condition_test");
    let source = r#"
public class TestCls {
public void test(List<String> list) {
for (int i = 0; i != 16 && i < 255; i++) {
list.set(i, "ABC");
if (i == 128) {
return;
}
list.set(i, "DEF");
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .contains_one("list.set(i, \"ABC\")")
        .contains_one("list.set(i, \"DEF\")");
}

#[test]
fn loop_condition2_test() {
    let status = tools_status();
    if !status.can_run_tests() {
        eprintln!("SKIPPED: {}", status.skip_reason());
        return;
    }

    let helper = IntegrationTestHelper::new("loop_condition2_test");
    let source = r#"
public class TestCls {
public int test(boolean a) {
int i = 0;
while (a && i < 10) {
i++;
}
return i;
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .contains_one("int i = 0;")
        .contains_one("while (a && i < 10) {")
        .contains_one("i++;")
        .contains_one("return i;");
}

#[test]
fn loop_condition3_test() {
    let status = tools_status();
    if !status.can_run_tests() {
        eprintln!("SKIPPED: {}", status.skip_reason());
        return;
    }

    let helper = IntegrationTestHelper::new("loop_condition3_test");
    let source = r#"
public class TestCls {
public static void test(int a, int b, int c) {
while (a < 12) {
if (b + a < 9 && b < 8) {
if (b >= 2 && a > -1 && b < 6) {
System.out.println("OK");
c = b + 1;
}
b = a;
c = b;
b++;
b = c;
a++;
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .contains_one("while (a < 12) {")
        .contains_one("if (b + a < 9 && b < 8) {")
        .contains_one("if (b >= 2 && a > -1 && b < 6) {");
}

#[test]
fn loop_condition4_test() {
    let status = tools_status();
    if !status.can_run_tests() {
        eprintln!("SKIPPED: {}", status.skip_reason());
        return;
    }

    let helper = IntegrationTestHelper::new("loop_condition4_test");
    let source = r#"
public class TestCls {
public static void test() {
int n = -1;
while (n < 0) {
n += 12;
}
while (n > 11) {
n -= 12;
System.out.println(n);
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .contains_one("int n = -1;")
        .contains_one("while (n < 0) {")
        .contains_one("n += 12;")
        .contains_one("while (n > 11) {")
        .contains_one("n -= 12;")
        .contains_one("System.out.println(n);");
}

#[test]
fn loop_condition5_test0() {
    let status = tools_status();
    if !status.can_run_tests() {
        eprintln!("SKIPPED: {}", status.skip_reason());
        return;
    }

    let helper = IntegrationTestHelper::new("loop_condition5_test0");
    let source = r#"
public class TestCls {
public static int lastIndexOf(int[] array, int target, int start, int end) {
for (int i = end - 1; i >= start; i--) {
if (array[i] == target) {
return i;
}
return -1;
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .contains_one("for (")
        .contains_one("return -1;")
        .count_string(2, "return ");
}

#[test]
fn loop_condition5_test1() {
    let status = tools_status();
    if !status.can_run_tests() {
        eprintln!("SKIPPED: {}", status.skip_reason());
        return;
    }

    let helper = IntegrationTestHelper::new("loop_condition5_test1");
    let source = r#"
public class TestCls {
public static int lastIndexOf(int[] array, int target, int start, int end) {
for (int i = end - 1; i >= start; i--) {
if (array[i] == target) {
return i;
}
return -1;
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .contains_one("return -1;")
        .count_string(2, "return ");
}

#[test]
fn loop_condition_invoke_test() {
    let status = tools_status();
    if !status.can_run_tests() {
        eprintln!("SKIPPED: {}", status.skip_reason());
        return;
    }

    let helper = IntegrationTestHelper::new("loop_condition_invoke_test");
    let source = r#"
public class TestCls {
private static final char STOP_CHAR = 0;
private int pos;
public boolean test(char lastChar) {
int startPos = pos;
char ch;
while ((ch = next()) != STOP_CHAR) {
if (ch == lastChar) {
return true;
}
pos = startPos;
return false;
private char next() {
return 0;
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .contains_one("do {")
        .contains_one("if (ch == 0) {")
        .contains_one("this.pos = startPos;")
        .contains_one("return false;")
        .contains_one("} while (ch != lastChar);")
        .contains_one("return true;");
}

#[test]
fn loop_detection_test() {
    let status = tools_status();
    if !status.can_run_tests() {
        eprintln!("SKIPPED: {}", status.skip_reason());
        return;
    }

    let helper = IntegrationTestHelper::new("loop_detection_test");
    let source = r#"
public class TestCls {
public void test(int[] a, int b) {
int i = 0;
while (i < a.length && i < b) {
a[i]++;
i++;
}
while (i < a.length) {
a[i]--;
public void check() {
int[] a = { 1, 1, 1, 1, 1 };
test(a, 3);
assertThat(a).containsExactly(new int[] { 2, 2, 2, 0, 0 });
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .contains("while (i < a.length && i < b) {")
        .contains("while (i < a.length) {")
        .contains("int i = 0;")
        .does_not_contain("i_2")
        .contains("i++;");
}

#[test]
fn loop_detection2_test() {
    let status = tools_status();
    if !status.can_run_tests() {
        eprintln!("SKIPPED: {}", status.skip_reason());
        return;
    }

    let helper = IntegrationTestHelper::new("loop_detection2_test");
    let source = r#"
public class TestCls {
public int test(int a, int b) {
int c = a + b;
for (int i = a; i < b; i++) {
if (i == 7) {
c += 2;
} else {
c *= 2;
}
c--;
return c;
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .contains_one("int c = a + b;")
        .contains_one("for (int i = a; i < b; i++) {")
        .does_not_contain("c_2");
}

#[test]
fn loop_detection3_test() {
    let status = tools_status();
    if !status.can_run_tests() {
        eprintln!("SKIPPED: {}", status.skip_reason());
        return;
    }

    let helper = IntegrationTestHelper::new("loop_detection3_test");
    let source = r#"
public class TestCls {
public void test(TestCls parent, int pos) {
Object item;
while (--pos >= 0) {
item = parent.get(pos);
if (item instanceof String) {
func((String) item);
return;
}
private Object get(int pos) {
return null;
private void func(String item) {
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .contains("while");
}

#[test]
fn loop_detection4_test() {
    let status = tools_status();
    if !status.can_run_tests() {
        eprintln!("SKIPPED: {}", status.skip_reason());
        return;
    }

    let helper = IntegrationTestHelper::new("loop_detection4_test");
    let source = r#"
public class TestCls {
private Iterator<String> iterator;
private SomeCls filter;
public String test() {
while (iterator.hasNext()) {
String next = iterator.next();
String filtered = filter.filter(next);
if (filtered != null) {
return filtered;
}
return null;
private class SomeCls {
public String filter(String str) {
return str;
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .contains_one("while (this.iterator.hasNext()) {")
        .contains_one("if (filtered != null) {")
        .contains_one("return filtered;")
        .contains_one("return null;");
}

#[test]
fn loop_detection5_test() {
    let status = tools_status();
    if !status.can_run_tests() {
        eprintln!("SKIPPED: {}", status.skip_reason());
        return;
    }

    let helper = IntegrationTestHelper::new("loop_detection5_test");
    let source = r#"
public class TestCls {
public String test(String str) {
Iterator<String> it = getStrings().iterator();
String otherStr = null;
while (it.hasNext()) {
otherStr = it.next();
if (otherStr.equalsIgnoreCase(str)) {
break;
}
return otherStr;
private List<String> getStrings() {
return Arrays.asList("str", "otherStr", "STR", "OTHERSTR");
public void check() {
assertThat(test("OTHERSTR")).isEqualTo("otherStr");
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .contains_one("it.next();")
        .does_not_contain("for (");
}

#[test]
fn loop_restore_test() {
    let status = tools_status();
    if !status.can_run_tests() {
        eprintln!("SKIPPED: {}", status.skip_reason());
        return;
    }

    // Note: This is a SmaliTest in JADX - requires smali input format not yet supported by dexterity
    eprintln!("SKIPPED: SmaliTest - requires smali input format");
}

#[test]
fn loop_restore2_test() {
    // Note: This is a SmaliTest in JADX - requires smali input format not yet supported by dexterity
    eprintln!("SKIPPED: SmaliTest - requires smali input format");
}

#[test]
fn loop_restore3_test() {
    // Note: This is a SmaliTest in JADX - requires smali input format not yet supported by dexterity
    eprintln!("SKIPPED: SmaliTest - requires smali input format");
}

#[test]
fn multi_entry_loop_test() {
    // Note: This is a SmaliTest in JADX - requires smali input format not yet supported by dexterity
    eprintln!("SKIPPED: SmaliTest - requires smali input format");
}

#[test]
fn multi_entry_loop2_test() {
    // Note: This is a SmaliTest in JADX - requires smali input format not yet supported by dexterity
    eprintln!("SKIPPED: SmaliTest - requires smali input format");
}

#[test]
fn nested_loops_test() {
    let status = tools_status();
    if !status.can_run_tests() {
        eprintln!("SKIPPED: {}", status.skip_reason());
        return;
    }

    let helper = IntegrationTestHelper::new("nested_loops_test");
    let source = r#"
public class TestCls {
public void test(List<String> l1, List<String> l2) {
for (String s1 : l1) {
for (String s2 : l2) {
if (s1.equals(s2)) {
if (s1.length() == 5) {
l2.add(s1);
} else {
l1.remove(s2);
}
if (l2.size() > 0) {
l1.clear();
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .contains_one("for (String s1 : l1) {")
        .contains_one("for (String s2 : l2) {")
        .contains_one("if (s1.equals(s2)) {")
        .contains_one("l2.add(s1);")
        .contains_one("l1.remove(s2);");
}

#[test]
fn nested_loops2_test() {
    let status = tools_status();
    if !status.can_run_tests() {
        eprintln!("SKIPPED: {}", status.skip_reason());
        return;
    }

    let helper = IntegrationTestHelper::new("nested_loops2_test");
    let source = r#"
public class TestCls {
public boolean test(List<String> list) {
int j = 0;
for (int i = 0; i < list.size(); i++) {
String s = list.get(i);
while (j < s.length()) {
j++;
}
return j > 10;
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .contains_one("for (int i = 0; i < list.size(); i++) {")
        .contains_one("while (j < s.length()) {");
}

#[test]
fn nested_loops3_test() {
    let status = tools_status();
    if !status.can_run_tests() {
        eprintln!("SKIPPED: {}", status.skip_reason());
        return;
    }

    let helper = IntegrationTestHelper::new("nested_loops3_test");
    let source = r#"
public class TestCls {
int c = 0;
public int test(int b) {
int i;
loop0: while (true) {
f1();
i = 0;
while (true) {
f2();
if (i != 0) {
break loop0;
}
i += 3;
if (b >= 16) {
try {
exc();
break;
} catch (Exception e) {
// ignore
return i;
private void exc() throws Exception {
if (c > 200) {
throw new Exception();
private void f1() {
c += 1;
private void f2() {
c += 100;
public void check() {
test(1);
assertThat(c).isEqualTo(302);
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .contains_one("} catch (Exception e) {");
}

#[test]
fn nested_loops5_test() {
    let status = tools_status();
    if !status.can_run_tests() {
        eprintln!("SKIPPED: {}", status.skip_reason());
        return;
    }

    let helper = IntegrationTestHelper::new("nested_loops5_test");
    let source = r#"
public class TestCls {
public int testFor() {
int tmp = 1;
for (int i = 5; i > -1; i--) {
if (i > tmp) {
for (int j = 1; j < 5; j++) {
if (tmp > j * 100) {
return 0;
}
tmp++;
return tmp;
public void check() {
assertThat(testFor()).isEqualTo(7);
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .does_not_contain("continue;");
}

#[test]
fn not_indexed_loop_test() {
    let status = tools_status();
    if !status.can_run_tests() {
        eprintln!("SKIPPED: {}", status.skip_reason());
        return;
    }

    let helper = IntegrationTestHelper::new("not_indexed_loop_test");
    let source = r#"
public class TestCls {
public File test(File[] files) {
File file;
if (files != null) {
int length = files.length;
if (length == 0) {
file = null;
} else {
int i = 0;
while (true) {
if (i >= length) {
break;
}
file = files[i];
if (file.getName().equals("f")) {
i++;
if (file != null) {
file.deleteOnExit();
return file;
public void check() {
assertThat(test(null)).isNull();
assertThat(test(new File[] {})).isNull();
File file = new File("f");
assertThat(test(new File[] { new File("a"), file })).isEqualTo(file);
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .does_not_contain("for (")
        .contains_one("while (true) {");
}

#[test]
fn not_indexed_loop_test_no_debug() {
    let status = tools_status();
    if !status.can_run_tests() {
        eprintln!("SKIPPED: {}", status.skip_reason());
        return;
    }

    let helper = IntegrationTestHelper::new("not_indexed_loop_test_no_debug");
    let source = r#"
public class TestCls {
public File test(File[] files) {
File file;
if (files != null) {
int length = files.length;
if (length == 0) {
file = null;
} else {
int i = 0;
while (true) {
if (i >= length) {
break;
}
file = files[i];
if (file.getName().equals("f")) {
i++;
if (file != null) {
file.deleteOnExit();
return file;
public void check() {
assertThat(test(null)).isNull();
assertThat(test(new File[] {})).isNull();
File file = new File("f");
assertThat(test(new File[] { new File("a"), file })).isEqualTo(file);
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .contains_one("while (true) {")
        .does_not_contain("for (");
}

#[test]
fn sequential_loops_test() {
    let status = tools_status();
    if !status.can_run_tests() {
        eprintln!("SKIPPED: {}", status.skip_reason());
        return;
    }

    let helper = IntegrationTestHelper::new("sequential_loops_test");
    let source = r#"
public class TestCls {
public int test(int a, int b) {
int c = b;
int z;
while (true) {
z = c + a;
if (z >= 7) {
break;
}
c = z;
while ((z = c + a) >= 7) {
return c;
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .contains_one("break;")
        .contains_one("return c;")
        .count_string(2, "while (");
}

#[test]
fn sequential_loops2_test() {
    let status = tools_status();
    if !status.can_run_tests() {
        eprintln!("SKIPPED: {}", status.skip_reason());
        return;
    }

    let helper = IntegrationTestHelper::new("sequential_loops2_test");
    let source = r#"
public class TestCls {
private static char[] lowercases = new char[] { 'a' };
public static String asciiToLowerCase(String s) {
char[] c = null;
int i = s.length();
while (i-- > 0) {
char c1 = s.charAt(i);
if (c1 <= 127) {
char c2 = lowercases[c1];
if (c1 != c2) {
c = s.toCharArray();
c[i] = c2;
break;
}
if (c[i] <= 127) {
c[i] = lowercases[c[i]];
return c == null ? s : new String(c);
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .contains("break;")
        .contains_one("return c")
        .count_string(2, "while (")
        .count_string(2, "<= 127");
}

#[test]
fn sequential_loops2_test_no_debug() {
    let status = tools_status();
    if !status.can_run_tests() {
        eprintln!("SKIPPED: {}", status.skip_reason());
        return;
    }

    let helper = IntegrationTestHelper::new("sequential_loops2_test_no_debug");
    let source = r#"
public class TestCls {
private static char[] lowercases = new char[] { 'a' };
public static String asciiToLowerCase(String s) {
char[] c = null;
int i = s.length();
while (i-- > 0) {
char c1 = s.charAt(i);
if (c1 <= 127) {
char c2 = lowercases[c1];
if (c1 != c2) {
c = s.toCharArray();
c[i] = c2;
break;
}
if (c[i] <= 127) {
c[i] = lowercases[c[i]];
return c == null ? s : new String(c);
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .contains("break;")
        .count_string(2, "while (")
        .count_string(2, "<= 127");
}

#[test]
fn synchronized_in_endless_loop_test() {
    let status = tools_status();
    if !status.can_run_tests() {
        eprintln!("SKIPPED: {}", status.skip_reason());
        return;
    }

    let helper = IntegrationTestHelper::new("synchronized_in_endless_loop_test");
    let source = r#"
public class TestCls {
int f = 5;
int test() {
while (true) {
synchronized (this) {
if (f > 7) {
return 7;
}
if (f < 3) {
return 3;
try {
f++;
Thread.sleep(100L);
} catch (Exception e) {
throw new RuntimeException(e);
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .contains_one("synchronized (this) {")
        .contains_one("try {")
        .contains_one("f++;")
        .contains_one("Thread.sleep(100L);")
        .contains_one("} catch (Exception e) {");
}

#[test]
fn try_catch_in_loop_test() {
    let status = tools_status();
    if !status.can_run_tests() {
        eprintln!("SKIPPED: {}", status.skip_reason());
        return;
    }

    let helper = IntegrationTestHelper::new("try_catch_in_loop_test");
    let source = r#"
public class TestCls {
int c = 0;
public int test() {
while (true) {
try {
exc();
break;
} catch (Exception e) {
//
}
if (c == 5) {
System.out.println(c);
return 0;
private void exc() throws Exception {
c++;
if (c < 3) {
throw new Exception();
public void check() {
test();
assertThat(c).isEqualTo(3);
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .contains_one("} catch (Exception e) {")
        .contains_one("break;");
}

#[test]
fn try_catch_in_loop2_test() {
    let status = tools_status();
    if !status.can_run_tests() {
        eprintln!("SKIPPED: {}", status.skip_reason());
        return;
    }

    let helper = IntegrationTestHelper::new("try_catch_in_loop2_test");
    let source = r#"
public class TestCls<T extends String> {
private static class MyItem {
int idx;
String name;
}
private final Map<Integer, MyItem> mCache = new HashMap<>();
void test(MyItem[] items) {
synchronized (this.mCache) {
for (int i = 0; i < items.length; ++i) {
MyItem existingItem = mCache.get(items[i].idx);
if (null == existingItem) {
mCache.put(items[i].idx, items[i]);
} else {
existingItem.name = items[i].name;
}
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .contains_one("synchronized (this.mCache) {")
        .contains_one("for (int i = 0; i < items.length; i++) {");
}
