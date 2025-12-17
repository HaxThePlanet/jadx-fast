package n.a;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/* loaded from: classes3.dex */
public final class a {

    private static final n.a.a.b[] a;
    private static final List<n.a.a.b> b;
    static volatile n.a.a.b[] c;
    private static final n.a.a.b d;

    public static abstract class b {

        final java.lang.ThreadLocal<String> a;
        public b() {
            super();
            ThreadLocal threadLocal = new ThreadLocal();
            this.a = threadLocal;
        }

        private String g(Throwable throwable) {
            StringWriter stringWriter = new StringWriter(256);
            PrintWriter printWriter = new PrintWriter(stringWriter, 0);
            throwable.printStackTrace(printWriter);
            printWriter.flush();
            return stringWriter.toString();
        }

        private void n(int i, Throwable throwable2, String string3, Object... object4Arr4) {
            boolean length;
            int obj5;
            Object[] obj6;
            final String str = h();
            if (!l(str, i)) {
            }
            if (string3 != null && string3.length() == 0) {
                if (string3.length() == 0) {
                    obj5 = 0;
                }
            }
            if (obj5 == null) {
                if (throwable2 == null) {
                }
                obj5 = g(throwable2);
            } else {
                if (object4Arr4 != null && object4Arr4.length > 0) {
                    if (object4Arr4.length > 0) {
                        obj5 = f(obj5, object4Arr4);
                    }
                }
                if (throwable2 != null) {
                    obj6 = new StringBuilder();
                    obj6.append(obj5);
                    obj6.append("\n");
                    obj6.append(g(throwable2));
                    obj5 = obj6.toString();
                }
            }
            m(i, str, obj5, throwable2);
        }

        public void a(String string, Object... object2Arr2) {
            n(3, 0, string, object2Arr2);
        }

        public void b(Throwable throwable) {
            n(3, throwable, 0, new Object[0]);
        }

        public void c(String string, Object... object2Arr2) {
            n(6, 0, string, object2Arr2);
        }

        public void d(Throwable throwable) {
            n(6, throwable, 0, new Object[0]);
        }

        public void e(Throwable throwable, String string2, Object... object3Arr3) {
            n(6, throwable, string2, object3Arr3);
        }

        protected String f(String string, Object[] object2Arr2) {
            return String.format(string, object2Arr2);
        }

        String h() {
            java.lang.ThreadLocal threadLocal;
            Object obj = this.a.get();
            if ((String)obj != null) {
                this.a.remove();
            }
            return (String)obj;
        }

        public void i(String string, Object... object2Arr2) {
            n(4, 0, string, object2Arr2);
        }

        public void j(Throwable throwable) {
            n(4, throwable, 0, new Object[0]);
        }

        @Deprecated
        protected boolean k(int i) {
            return 1;
        }

        protected boolean l(String string, int i2) {
            return k(i2);
        }

        protected abstract void m(int i, String string2, String string3, Throwable throwable4);

        public void o(String string, Object... object2Arr2) {
            n(5, 0, string, object2Arr2);
        }

        public void p(Throwable throwable) {
            n(5, throwable, 0, new Object[0]);
        }

        public void q(Throwable throwable, String string2, Object... object3Arr3) {
            n(5, throwable, string2, object3Arr3);
        }
    }

    static class a extends n.a.a.b {
        @Override // n.a.a$b
        public void a(String string, Object... object2Arr2) {
            int i;
            n.a.a.b bVar;
            final n.a.a.b[] objArr = a.c;
            i = 0;
            while (i < objArr.length) {
                objArr[i].a(string, object2Arr2);
                i++;
            }
        }

        @Override // n.a.a$b
        public void b(Throwable throwable) {
            int i;
            n.a.a.b bVar;
            final n.a.a.b[] objArr = a.c;
            i = 0;
            while (i < objArr.length) {
                objArr[i].b(throwable);
                i++;
            }
        }

        @Override // n.a.a$b
        public void c(String string, Object... object2Arr2) {
            int i;
            n.a.a.b bVar;
            final n.a.a.b[] objArr = a.c;
            i = 0;
            while (i < objArr.length) {
                objArr[i].c(string, object2Arr2);
                i++;
            }
        }

        @Override // n.a.a$b
        public void d(Throwable throwable) {
            int i;
            n.a.a.b bVar;
            final n.a.a.b[] objArr = a.c;
            i = 0;
            while (i < objArr.length) {
                objArr[i].d(throwable);
                i++;
            }
        }

        @Override // n.a.a$b
        public void e(Throwable throwable, String string2, Object... object3Arr3) {
            int i;
            n.a.a.b bVar;
            final n.a.a.b[] objArr = a.c;
            i = 0;
            while (i < objArr.length) {
                objArr[i].e(throwable, string2, object3Arr3);
                i++;
            }
        }

        @Override // n.a.a$b
        public void i(String string, Object... object2Arr2) {
            int i;
            n.a.a.b bVar;
            final n.a.a.b[] objArr = a.c;
            i = 0;
            while (i < objArr.length) {
                objArr[i].i(string, object2Arr2);
                i++;
            }
        }

        @Override // n.a.a$b
        public void j(Throwable throwable) {
            int i;
            n.a.a.b bVar;
            final n.a.a.b[] objArr = a.c;
            i = 0;
            while (i < objArr.length) {
                objArr[i].j(throwable);
                i++;
            }
        }

        @Override // n.a.a$b
        protected void m(int i, String string2, String string3, Throwable throwable4) {
            AssertionError obj1 = new AssertionError("Missing override for log method.");
            throw obj1;
        }

        @Override // n.a.a$b
        public void o(String string, Object... object2Arr2) {
            int i;
            n.a.a.b bVar;
            final n.a.a.b[] objArr = a.c;
            i = 0;
            while (i < objArr.length) {
                objArr[i].o(string, object2Arr2);
                i++;
            }
        }

        @Override // n.a.a$b
        public void p(Throwable throwable) {
            int i;
            n.a.a.b bVar;
            final n.a.a.b[] objArr = a.c;
            i = 0;
            while (i < objArr.length) {
                objArr[i].p(throwable);
                i++;
            }
        }

        @Override // n.a.a$b
        public void q(Throwable throwable, String string2, Object... object3Arr3) {
            int i;
            n.a.a.b bVar;
            final n.a.a.b[] objArr = a.c;
            i = 0;
            while (i < objArr.length) {
                objArr[i].q(throwable, string2, object3Arr3);
                i++;
            }
        }
    }
    static {
        n.a.a.b[] arr = new a.b[0];
        a.a = arr;
        ArrayList arrayList = new ArrayList();
        a.b = arrayList;
        a.c = arr;
        a.a aVar = new a.a();
        a.d = aVar;
    }

    public static void a(String string, Object... object2Arr2) {
        a.d.a(string, object2Arr2);
    }

    public static void b(Throwable throwable) {
        a.d.b(throwable);
    }

    public static void c(String string, Object... object2Arr2) {
        a.d.c(string, object2Arr2);
    }

    public static void d(Throwable throwable) {
        a.d.d(throwable);
    }

    public static void e(Throwable throwable, String string2, Object... object3Arr3) {
        a.d.e(throwable, string2, object3Arr3);
    }

    public static void f(String string, Object... object2Arr2) {
        a.d.i(string, object2Arr2);
    }

    public static void g(Throwable throwable) {
        a.d.j(throwable);
    }

    public static void h(n.a.a.b a$b) {
        Objects.requireNonNull(b, "tree == null");
        if (b == a.d) {
        } else {
            List list = a.b;
            list.add(b);
            a.c = (a.b[])list.toArray(new a.b[list.size()]);
            return;
            synchronized (list) {
                list = a.b;
                list.add(b);
                a.c = (a.b[])list.toArray(new a.b[list.size()]);
            }
        }
        IllegalArgumentException obj1 = new IllegalArgumentException("Cannot plant Timber into itself.");
        throw obj1;
    }

    public static void i(String string, Object... object2Arr2) {
        a.d.o(string, object2Arr2);
    }

    public static void j(Throwable throwable) {
        a.d.p(throwable);
    }

    public static void k(Throwable throwable, String string2, Object... object3Arr3) {
        a.d.q(throwable, string2, object3Arr3);
    }
}
