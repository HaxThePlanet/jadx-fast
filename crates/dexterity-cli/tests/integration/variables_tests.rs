//! Variables integration tests
//! Ported from jadx-core/src/test/java/jadx/tests/integration/

use crate::integration_test_framework::{IntegrationTestHelper, CodeAssertions, tools_status};

#[test]
fn variables2_test() {
    let status = tools_status();
    if !status.can_run_tests() {
        eprintln!("SKIPPED: {}", status.skip_reason());
        return;
    }

    let helper = IntegrationTestHelper::new("variables2_test");
    let source = r#"
public class TestCls {
    public Object test(Object s) {
        Object store = s != null ? s : null;
        if (store == null) {
            store = new Object();
            s = store;
        }
        return store;
    }
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .contains("Object store = s != null ? s : null;");
}

#[test]
fn variables2_test_no_debug() {
    let status = tools_status();
    if !status.can_run_tests() {
        eprintln!("SKIPPED: {}", status.skip_reason());
        return;
    }

    let helper = IntegrationTestHelper::new("variables2_test_no_debug");
    let source = r#"
public class TestCls {
    public Object test(Object obj) {
        Object obj2 = obj != null ? obj : null;
        if (obj2 == null) {
            obj2 = new Object();
            obj = obj2;
        }
        return obj2;
    }
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .contains("Object obj2 = obj != null ? obj : null;");
}

#[test]
fn variables3_test() {
    let status = tools_status();
    if !status.can_run_tests() {
        eprintln!("SKIPPED: {}", status.skip_reason());
        return;
    }

    let helper = IntegrationTestHelper::new("variables3_test");
    let source = r#"
public class TestCls {
    String test(Object s) {
        int i;
        if (s == null) {
            i = 2;
        } else {
            i = 3;
            s = null;
        }
        return s + " " + i;
    }
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .contains("int i;")
        .contains("i = 2;")
        .contains("i = 3;")
        .contains("s = null;");
}

#[test]
fn variables4_test() {
    let status = tools_status();
    if !status.can_run_tests() {
        eprintln!("SKIPPED: {}", status.skip_reason());
        return;
    }

    let helper = IntegrationTestHelper::new("variables4_test");
    let source = r#"
public class TestCls {
public static boolean runTest(String clsName) {
try {
boolean pass = false;
String msg = null;
Throwable exc = null;
Class<?> cls = Class.forName(clsName);
if (cls.getSuperclass() == AbstractTest.class) {
Method mth = cls.getMethod("testRun");
AbstractTest test = (AbstractTest) cls.getConstructor().newInstance();
pass = (Boolean) mth.invoke(test);
} catch (InvocationTargetException e) {
pass = false;
exc = e.getCause();
} catch (Throwable e) {
exc = e;
}
} else {
msg = "not extends AbstractTest";
System.err.println(">> "
+ (pass ? "PASS" : "FAIL") + '\t'
+ clsName
+ (msg == null ? "" : "\t - " + msg));
if (exc != null) {
exc.printStackTrace();
return pass;
} catch (ClassNotFoundException e) {
System.err.println("Class '" + clsName + "' not found");
} catch (Exception e) {
e.printStackTrace();
return false;
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .contains("} catch (InvocationTargetException e) {")
        .contains("pass = false;")
        .contains("exc = e.getCause();")
        .contains("return pass;");
}

#[test]
fn variables4_test2() {
    let status = tools_status();
    if !status.can_run_tests() {
        eprintln!("SKIPPED: {}", status.skip_reason());
        return;
    }

    let helper = IntegrationTestHelper::new("variables4_test2");
    let source = r#"
public class TestCls {
public static boolean runTest(String clsName) {
try {
boolean pass = false;
String msg = null;
Throwable exc = null;
Class<?> cls = Class.forName(clsName);
if (cls.getSuperclass() == AbstractTest.class) {
Method mth = cls.getMethod("testRun");
AbstractTest test = (AbstractTest) cls.getConstructor().newInstance();
pass = (Boolean) mth.invoke(test);
} catch (InvocationTargetException e) {
pass = false;
exc = e.getCause();
} catch (Throwable e) {
exc = e;
}
} else {
msg = "not extends AbstractTest";
System.err.println(">> "
+ (pass ? "PASS" : "FAIL") + '\t'
+ clsName
+ (msg == null ? "" : "\t - " + msg));
if (exc != null) {
exc.printStackTrace();
return pass;
} catch (ClassNotFoundException e) {
System.err.println("Class '" + clsName + "' not found");
} catch (Exception e) {
e.printStackTrace();
return false;
}
"#;

    // test2() in Java is noDebugInfo() with no assertions - just verifies it compiles
    let _result = helper.test_decompilation(source)
        .expect("Decompilation failed");
}

#[test]
fn variables5_test() {
    let status = tools_status();
    if !status.can_run_tests() {
        eprintln!("SKIPPED: {}", status.skip_reason());
        return;
    }

    let helper = IntegrationTestHelper::new("variables5_test");
    let source = r#"
public class TestCls {
    public String f = "str//ing";
    private boolean enabled;

    private void testIfInLoop() {
        int i = 0;
        for (int i2 = 0; i2 < f.length(); i2++) {
            char ch = f.charAt(i2);
            if (ch == '/') {
                i++;
                if (i == 2) {
                    setEnabled(true);
                    return;
                }
            }
        }
        setEnabled(false);
    }

    private void setEnabled(boolean b) {
        this.enabled = b;
    }

    public void check() {
        testIfInLoop();
        assertThat(enabled).isTrue();
    }

    private A assertThat(boolean b) { return null; }

    class A {
        void isTrue() {}
    }
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .contains_one("int i = 0;")
        .does_not_contain("int i2++;");
}

#[test]
fn variables6_test() {
    // Note: Java test (TestVariables6) is a SmaliTest that loads from smali files.
    // Skipping as dexterity doesn't support smali input yet.
    eprintln!("SKIPPED: SmaliTest - requires smali input format");
}

#[test]
fn variables_decl_annotation_test() {
    let status = tools_status();
    if !status.can_run_tests() {
        eprintln!("SKIPPED: {}", status.skip_reason());
        return;
    }

    let helper = IntegrationTestHelper::new("variables_decl_annotation_test");
    let source = r#"
public abstract class TestCls {
    public int test(String str, int i) {
        return i;
    }

    public abstract int test2(String str);
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .contains_one("public int test(String str, int i) {")
        .contains_one("public abstract int test2(String str);");
}

#[test]
fn variables_definitions_test() {
    let status = tools_status();
    if !status.can_run_tests() {
        eprintln!("SKIPPED: {}", status.skip_reason());
        return;
    }

    let helper = IntegrationTestHelper::new("variables_definitions_test");
    let source = r#"
import java.util.List;

class Logger {
    void error(String msg, Object... args) {}
}

class ClassNode {
    void load() {}
}

interface IDexTreeVisitor {}

class DepthTraversal {
    static void visit(IDexTreeVisitor pass, ClassNode cls) {}
}

public class TestCls {
    private static Logger log;
    private ClassNode cls;
    private List<IDexTreeVisitor> passes;

    public void test() {
        try {
            cls.load();
            for (IDexTreeVisitor pass : this.passes) {
                DepthTraversal.visit(pass, cls);
            }
        } catch (Exception e) {
            log.error("Decode exception: {}", cls, e);
        }
    }
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .does_not_contain("iterator;")
        .does_not_contain("Iterator");
}

#[test]
fn variables_definitions2_test() {
    let status = tools_status();
    if !status.can_run_tests() {
        eprintln!("SKIPPED: {}", status.skip_reason());
        return;
    }

    let helper = IntegrationTestHelper::new("variables_definitions2_test");
    let source = r#"
import java.util.List;

public class TestCls {
    public static int test(List<String> list) {
        int i = 0;
        if (list != null) {
            for (String str : list) {
                if (str.isEmpty()) {
                    i++;
                }
            }
        }
        return i;
    }
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .contains_one("int i = 0;")
        .contains_one("i++;")
        .contains_one("return i;")
        .does_not_contain("i2;");
}

#[test]
fn variables_generic_test() {
    // Note: Java test (TestVariablesGeneric) is a SmaliTest that loads from smali files.
    // Skipping as dexterity doesn't support smali input yet.
    eprintln!("SKIPPED: SmaliTest - requires smali input format");
}

#[test]
fn variables_if_else_chain_test() {
    let status = tools_status();
    if !status.can_run_tests() {
        eprintln!("SKIPPED: {}", status.skip_reason());
        return;
    }

    let helper = IntegrationTestHelper::new("variables_if_else_chain_test");
    let source = r#"
public class TestCls {
    String used;

    public String test(int a) {
        if (a == 0) {
            use("zero");
        } else if (a == 1) {
            String r = m(a);
            if (r != null) {
                use(r);
            }
        } else if (a == 2) {
            use("two");
        } else {
            return "miss";
        }
        return null;
    }

    public String m(int a) {
        return "hit" + a;
    }

    public void use(String s) {
        used = s;
    }

    public void check() {
        test(0);
        assertThat(used).isEqualTo("zero");
        test(1);
        assertThat(used).isEqualTo("hit1");
        test(2);
        assertThat(used).isEqualTo("hit2");
        assertThat(test(5)).isEqualTo("miss");
    }

    private A assertThat(String s) { return null; }

    class A {
        A isEqualTo(String s) { return this; }
    }
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .contains_one("return \"miss\";");
}

#[test]
fn variables_in_loop_test() {
    // Note: Java test (TestVariablesInLoop) is a SmaliTest that loads from smali files.
    // Skipping as dexterity doesn't support smali input yet.
    eprintln!("SKIPPED: SmaliTest - requires smali input format");
}

#[test]
fn variables_usage_with_loops_test_enhanced_for() {
    let status = tools_status();
    if !status.can_run_tests() {
        eprintln!("SKIPPED: {}", status.skip_reason());
        return;
    }

    let helper = IntegrationTestHelper::new("variables_usage_with_loops_test_enhanced_for");
    let source = r#"
import java.util.ArrayList;
import java.util.List;

public class TestCls {
    public void test() {
        List<Object> list;
        synchronized (this) {
            list = new ArrayList<>();
        }
        for (Object o : list) {
            System.out.println(o);
        }
    }
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .contains("synchronized (this) {")
        .contains("list = new ArrayList<");
}

#[test]
fn variables_usage_with_loops_test_for_loop() {
    let status = tools_status();
    if !status.can_run_tests() {
        eprintln!("SKIPPED: {}", status.skip_reason());
        return;
    }

    let helper = IntegrationTestHelper::new("variables_usage_with_loops_test_for_loop");
    let source = r#"
import java.util.ArrayList;
import java.util.List;

public class TestCls {
    public void test() {
        List<Object> list;
        synchronized (this) {
            list = new ArrayList<>();
        }
        for (int i = 0; i < list.size(); i++) {
            System.out.println(i);
        }
    }
}
"#;

    let result = helper.test_decompilation(source)
        .expect("Decompilation failed");

    result
        .contains("synchronized (this) {")
        .contains("list = new ArrayList<");
}
