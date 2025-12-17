package f.f.a;

/* loaded from: classes2.dex */
public final class e {

    private final f.f.a.c a;
    private final String b;
    private final f.f.a.b c;
    private final Object d;

    static class a {
    }

    public static class b {

        private f.f.a.c a;
        private String b;
        private f.f.a.b.b c;
        private f.f.a.f d;
        private Object e;
        public b() {
            super();
            this.b = "GET";
            b.b bVar = new b.b();
            this.c = bVar;
        }

        static f.f.a.c a(f.f.a.e.b e$b) {
            return b.a;
        }

        static String b(f.f.a.e.b e$b) {
            return b.b;
        }

        static f.f.a.b.b c(f.f.a.e.b e$b) {
            return b.c;
        }

        static f.f.a.f d(f.f.a.e.b e$b) {
            return b.d;
        }

        static Object e(f.f.a.e.b e$b) {
            return b.e;
        }

        public f.f.a.e f() {
            if (this.a == null) {
            } else {
                e eVar = new e(this, 0);
                return eVar;
            }
            IllegalStateException illegalStateException = new IllegalStateException("url == null");
            throw illegalStateException;
        }

        public f.f.a.e.b g(String string, String string2) {
            this.c.f(string, string2);
            return this;
        }

        public f.f.a.e.b h(f.f.a.c c) {
            if (c == null) {
            } else {
                this.a = c;
                return this;
            }
            IllegalArgumentException obj2 = new IllegalArgumentException("url == null");
            throw obj2;
        }
    }
    private e(f.f.a.e.b e$b) {
        Object obj2;
        super();
        this.a = e.b.a(b);
        this.b = e.b.b(b);
        this.c = e.b.c(b).c();
        e.b.d(b);
        if (e.b.e(b) != null) {
            obj2 = e.b.e(b);
        } else {
            obj2 = this;
        }
        this.d = obj2;
    }

    e(f.f.a.e.b e$b, f.f.a.e.a e$a2) {
        super(b);
    }

    public f.f.a.b a() {
        return this.c;
    }

    public f.f.a.c b() {
        return this.a;
    }

    public String toString() {
        Object obj;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Request{method=");
        stringBuilder.append(this.b);
        stringBuilder.append(", url=");
        stringBuilder.append(this.a);
        stringBuilder.append(", tag=");
        if (this.d != this) {
        } else {
            obj = 0;
        }
        stringBuilder.append(obj);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
