package m.b.a.a.b;

import java.lang.ref.SoftReference;
import java.util.StringTokenizer;
import org.mp4parser.aspectj.lang.b;

/* loaded from: classes3.dex */
abstract class f implements b {

    private static boolean h = true;
    int a = -1;
    String b;
    String c;
    Class d;
    m.b.a.a.b.f.a e;
    private String f;
    java.lang.ClassLoader g = null;

    private interface a {
        public abstract void a(int i, String string2);

        public abstract String get(int i);
    }

    private static final class b implements m.b.a.a.b.f.a {

        private SoftReference a;
        private String[] b() {
            return (String[])this.a.get();
        }

        private String[] c() {
            String[] strArr = new String[3];
            SoftReference softReference = new SoftReference(strArr);
            this.a = softReference;
            return strArr;
        }

        @Override // m.b.a.a.b.f$a
        public void a(int i, String string2) {
            String[] strArr;
            if (b() == null) {
                strArr = c();
            }
            strArr[i] = string2;
        }

        @Override // m.b.a.a.b.f$a
        public String get(int i) {
            final String[] strArr = b();
            if (strArr == null) {
                return null;
            }
            return strArr[i];
        }
    }
    static {
    }

    f(int i, String string2, Class class3) {
        super();
        int i2 = -1;
        int i3 = 0;
        this.a = i;
        this.b = string2;
        this.d = class3;
    }

    private java.lang.ClassLoader h() {
        java.lang.ClassLoader classLoader;
        if (this.g == null) {
            this.g = getClass().getClassLoader();
        }
        return this.g;
    }

    @Override // org.mp4parser.aspectj.lang.b
    protected abstract String a(m.b.a.a.b.h h);

    @Override // org.mp4parser.aspectj.lang.b
    int b(int i) {
        return Integer.parseInt(c(i), 16);
    }

    @Override // org.mp4parser.aspectj.lang.b
    String c(int i) {
        int indexOf;
        int i3;
        int i2;
        int obj5;
        final int i4 = 45;
        indexOf = this.f.indexOf(i4);
        i3 = 0;
        while (obj5 > 0) {
            indexOf = this.f.indexOf(i4, indexOf + 1);
            obj5 = i2;
        }
        if (indexOf == -1) {
            indexOf = this.f.length();
        }
        return this.f.substring(i3, indexOf);
    }

    @Override // org.mp4parser.aspectj.lang.b
    Class d(int i) {
        return b.b(c(i), h());
    }

    @Override // org.mp4parser.aspectj.lang.b
    Class[] e(int i) {
        int i2;
        Class cls2;
        java.lang.ClassLoader cls;
        StringTokenizer stringTokenizer = new StringTokenizer(c(i), ":");
        int obj6 = stringTokenizer.countTokens();
        Class[] arr = new Class[obj6];
        i2 = 0;
        while (i2 < obj6) {
            arr[i2] = b.b(stringTokenizer.nextToken(), h());
            i2++;
        }
        return arr;
    }

    @Override // org.mp4parser.aspectj.lang.b
    public Class f() {
        Class cls;
        if (this.d == null) {
            this.d = d(2);
        }
        return this.d;
    }

    @Override // org.mp4parser.aspectj.lang.b
    public String g() {
        String name;
        if (this.c == null) {
            this.c = f().getName();
        }
        return this.c;
    }

    @Override // org.mp4parser.aspectj.lang.b
    public int i() {
        int i;
        if (this.a == -1) {
            this.a = b(0);
        }
        return this.a;
    }

    @Override // org.mp4parser.aspectj.lang.b
    public String j() {
        String str;
        if (this.b == null) {
            this.b = c(1);
        }
        return this.b;
    }

    @Override // org.mp4parser.aspectj.lang.b
    String k(m.b.a.a.b.h h) {
        int i;
        boolean bVar;
        int i2;
        boolean z;
        Object obj3;
        if (f.h) {
            m.b.a.a.b.f.a aVar = this.e;
            if (aVar == null) {
                bVar = new f.b();
                this.e = bVar;
                i = 0;
            } else {
                i = aVar.get(h.f);
            }
        } else {
        }
        if (i == 0) {
            i = a(h);
        }
        try {
            if (f.h) {
            }
            this.e.a(h.f, i);
            return i;
        }
    }

    @Override // org.mp4parser.aspectj.lang.b
    public final String toString() {
        return k(h.h);
    }
}
