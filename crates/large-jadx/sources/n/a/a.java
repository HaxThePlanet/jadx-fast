package n.a;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.List;
import java.util.Objects;

/* compiled from: Timber.java */
/* loaded from: classes3.dex */
public final class a {

    private static final a.b[] a;
    private static final List<a.b> b = new ArrayList<>();
    static volatile a.b[] c;
    private static final a.b d = new a$a();

    public static abstract class b {

        final java.lang.ThreadLocal<String> a = new ThreadLocal<>();
        public b() {
            super();
            final java.lang.ThreadLocal threadLocal = new ThreadLocal();
        }

        private String g(Throwable th) throws java.io.FileNotFoundException {
            final StringWriter stringWriter = new StringWriter(256);
            PrintWriter printWriter = new PrintWriter(stringWriter, false);
            th.printStackTrace(printWriter);
            printWriter.flush();
            return stringWriter.toString();
        }

        private void n(int i, Throwable th, String str, Object... objectArr) {
            boolean z;
            final String str2 = h();
            if (!l(str2, i)) {
                return;
            }
            if (str != null && str.length() == 0) {
                int i2 = 0;
            }
            if (str == null) {
                if (th == null) {
                    return;
                }
                str = g(th);
            } else {
                if (objectArr != null && objectArr.length > 0) {
                    str = f(str, objectArr);
                }
                if (th != null) {
                    StringBuilder stringBuilder = new StringBuilder();
                    String str4 = "\n";
                    String str5 = g(th);
                    str = str + str4 + str5;
                }
            }
            m(i, str2, str, th);
        }

        public void a(String str, Object... objectArr) {
            n(3, null, str, objectArr);
        }

        public void b(Throwable th) {
            n(3, th, null, new Object[0]);
        }

        public void c(String str, Object... objectArr) {
            n(6, null, str, objectArr);
        }

        public void d(Throwable th) {
            n(6, th, null, new Object[0]);
        }

        public void e(Throwable th, String str, Object... objectArr) {
            n(6, th, str, objectArr);
        }

        protected String f(String str, Object[] objectArr) {
            return String.format(str, objectArr);
        }

        String h() {
            Object obj = this.a.get();
            if (obj != null) {
                this.a.remove();
            }
            return obj;
        }

        public void i(String str, Object... objectArr) {
            n(4, null, str, objectArr);
        }

        public void j(Throwable th) {
            n(4, th, null, new Object[0]);
        }

        protected boolean l(String str, int i) {
            return k(i);
        }

        public void o(String str, Object... objectArr) {
            n(5, null, str, objectArr);
        }

        public void p(Throwable th) {
            n(5, th, null, new Object[0]);
        }

        public void q(Throwable th, String str, Object... objectArr) {
            n(5, th, str, objectArr);
        }

        @Deprecated
        protected boolean k(int i) {
            return true;
        }

        protected abstract void m(int i, String str, String str2, Throwable th);
    }

    static class a extends a.b {
        a() {
            super();
        }

        @Override // n.a.a$b
        public void a(String str, Object... objectArr) {
            int i = 0;
            final n.a.a.b[] objArr = a.c;
            i = 0;
            for (n.a.a.b bVar : objArr) {
                bVar.a(str, objectArr);
            }
        }

        @Override // n.a.a$b
        public void b(Throwable th) {
            int i = 0;
            final n.a.a.b[] objArr = a.c;
            i = 0;
            for (n.a.a.b bVar : objArr) {
                bVar.b(th);
            }
        }

        @Override // n.a.a$b
        public void c(String str, Object... objectArr) {
            int i = 0;
            final n.a.a.b[] objArr = a.c;
            i = 0;
            for (n.a.a.b bVar : objArr) {
                bVar.c(str, objectArr);
            }
        }

        @Override // n.a.a$b
        public void d(Throwable th) {
            int i = 0;
            final n.a.a.b[] objArr = a.c;
            i = 0;
            for (n.a.a.b bVar : objArr) {
                bVar.d(th);
            }
        }

        @Override // n.a.a$b
        public void e(Throwable th, String str, Object... objectArr) {
            int i = 0;
            final n.a.a.b[] objArr = a.c;
            i = 0;
            for (n.a.a.b bVar : objArr) {
                bVar.e(th, str, objectArr);
            }
        }

        @Override // n.a.a$b
        public void i(String str, Object... objectArr) {
            int i = 0;
            final n.a.a.b[] objArr = a.c;
            i = 0;
            for (n.a.a.b bVar : objArr) {
                bVar.i(str, objectArr);
            }
        }

        @Override // n.a.a$b
        public void j(Throwable th) {
            int i = 0;
            final n.a.a.b[] objArr = a.c;
            i = 0;
            for (n.a.a.b bVar : objArr) {
                bVar.j(th);
            }
        }

        @Override // n.a.a$b
        protected void m(int i, String str, String str2, Throwable th) {
            throw new AssertionError("Missing override for log method.");
        }

        @Override // n.a.a$b
        public void o(String str, Object... objectArr) {
            int i = 0;
            final n.a.a.b[] objArr = a.c;
            i = 0;
            for (n.a.a.b bVar : objArr) {
                bVar.o(str, objectArr);
            }
        }

        @Override // n.a.a$b
        public void p(Throwable th) {
            int i = 0;
            final n.a.a.b[] objArr = a.c;
            i = 0;
            for (n.a.a.b bVar : objArr) {
                bVar.p(th);
            }
        }

        @Override // n.a.a$b
        public void q(Throwable th, String str, Object... objectArr) {
            int i = 0;
            final n.a.a.b[] objArr = a.c;
            i = 0;
            for (n.a.a.b bVar : objArr) {
                bVar.q(th, str, objectArr);
            }
        }
    }
    static {
        n.a.a.b[] arr = new a.b[0];
        a.a = arr;
        a.c = arr;
    }

    public static void a(String str, Object... objectArr) {
        a.d.a(str, objectArr);
    }

    public static void b(Throwable th) {
        a.d.b(th);
    }

    public static void c(String str, Object... objectArr) {
        a.d.c(str, objectArr);
    }

    public static void d(Throwable th) {
        a.d.d(th);
    }

    public static void e(Throwable th, String str, Object... objectArr) {
        a.d.e(th, str, objectArr);
    }

    public static void f(String str, Object... objectArr) {
        a.d.i(str, objectArr);
    }

    public static void g(Throwable th) {
        a.d.j(th);
    }

    public static void h(a.b bVar) {
        Objects.requireNonNull(bVar, "tree == null");
        if (bVar == a.d) {
            throw new IllegalArgumentException("Cannot plant Timber into itself.");
        } else {
            List list = a.b;
            synchronized (list) {
                try {
                    list.add(bVar);
                    a.c = (a.b[])list.toArray(new a.b[list.size()]);
                    return;
                } catch (Throwable th) {
                }
                /* Dexterity WARN: Type inference failed for thrown value */
                throw (Throwable) th;
            }
        }
    }

    public static void i(String str, Object... objectArr) {
        a.d.o(str, objectArr);
    }

    public static void j(Throwable th) {
        a.d.p(th);
    }

    public static void k(Throwable th, String str, Object... objectArr) {
        a.d.q(th, str, objectArr);
    }
}
