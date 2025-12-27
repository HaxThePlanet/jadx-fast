package m.b.a.a.b;

import java.lang.ref.SoftReference;
import java.util.StringTokenizer;
import org.mp4parser.aspectj.lang.b;

/* compiled from: SignatureImpl.java */
/* loaded from: classes3.dex */
abstract class f implements b {

    private static boolean h = true;
    int a = -1;
    String b;
    String c;
    Class d;
    f.a e;
    private String f;
    java.lang.ClassLoader g = null;

    private interface a {
        void a(int i, String str);

        String get(int i);
    }

    private static final class b implements f.a {

        private SoftReference a;
        private String[] b() {
            return (String[])this.a.get();
        }

        private String[] c() {
            String[] strArr = new String[3];
            this.a = new SoftReference(strArr);
            return strArr;
        }

        public void a(int i, String str) {
            String[] strArr;
            if (b() == null) {
                strArr = c();
            }
            strArr[i] = str;
        }

        public String get(int i) {
            final String[] strArr = b();
            if (strArr == null) {
                return null;
            }
            return strArr[i];
        }
    }
    f(int i, String str, Class cls) {
        super();
        this.a = i;
        this.b = str;
        this.d = cls;
    }

    private java.lang.ClassLoader h() {
        if (this.g == null) {
            this.g = getClass().getClassLoader();
        }
        return this.g;
    }

    int b(int i) {
        return Integer.parseInt(c(i), 16);
    }

    String c(int i) {
        int indexOf;
        int i2 = 0;
        int i3;
        final int i5 = 45;
        indexOf = this.f.indexOf(i5);
        i2 = 0;
        i3 = i3 - 1;
        while (i3 > 0) {
            i2 = indexOf + 1;
            indexOf = this.f.indexOf(i5, i2);
            i3 = i3 - 1;
        }
        int i4 = -1;
        if (this.f == -1) {
            indexOf = this.f.length();
        }
        return this.f.substring(i2, indexOf);
    }

    Class d(int i) {
        return b.b(c(i), h());
    }

    Class[] e(int i) {
        int i2 = 0;
        final StringTokenizer stringTokenizer = new StringTokenizer(c(i), ":");
        int countTokens = stringTokenizer.countTokens();
        Class[] arr = new Class[countTokens];
        i2 = 0;
        while (i2 < countTokens) {
            arr[i2] = b.b(stringTokenizer.nextToken(), h());
            i2 = i2 + 1;
        }
        return arr;
    }

    public Class f() {
        if (this.d == null) {
            this.d = d(2);
        }
        return this.d;
    }

    public String g() {
        if (this.c == null) {
            this.c = f().getName();
        }
        return this.c;
    }

    public int i() {
        if (this.a == -1) {
            this.a = b(0);
        }
        return this.a;
    }

    public String j() {
        if (this.b == null) {
            this.b = c(1);
        }
        return this.b;
    }

    String k(h hVar) {
        int i = 0;
        String str;
        if (!f.h || this.e == null) {
            i = 0;
        } else {
            try {
                this.e = new f.b();
            } catch (Throwable unused) {
                f.h = false;
            }
        }
        if (f.h == 0) {
            str = a(hVar);
        }
        if (f.h) {
            this.e.a(hVar.f, str);
        }
        return str;
    }

    @Override // java.lang.Object
    public final String toString() {
        return k(h.h);
    }


    protected abstract String a(h hVar);
}
