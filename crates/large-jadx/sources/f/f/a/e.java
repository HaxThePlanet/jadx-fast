package f.f.a;

/* compiled from: Request.java */
/* loaded from: classes2.dex */
public final class e {

    private final c a;
    private final String b;
    private final b c;
    private final Object d;

    static class a {
    }

    public static class b {

        private c a;
        private String b = "GET";
        private b.b c = new b$b();
        private f d;
        private Object e;
        public b() {
            super();
            f.f.a.b.b bVar = new b.b();
        }

        static /* synthetic */ c a(e.b bVar) {
            return bVar.a;
        }

        static /* synthetic */ String b(e.b bVar) {
            return bVar.b;
        }

        static /* synthetic */ b.b c(e.b bVar) {
            return bVar.c;
        }

        static /* synthetic */ f d(e.b bVar) {
            return bVar.d;
        }

        static /* synthetic */ Object e(e.b bVar) {
            return bVar.e;
        }

        public e f() {
            if (this.a == null) {
                throw new IllegalStateException("url == null");
            } else {
                return new e(this, null);
            }
        }

        public e.b g(String str, String str2) {
            this.c.f(str, str2);
            return this;
        }

        public e.b h(c cVar) {
            if (cVar == null) {
                throw new IllegalArgumentException("url == null");
            } else {
                this.a = cVar;
                return this;
            }
        }
    }
    /* synthetic */ e(e.b bVar, e.a aVar) {
        this(bVar);
    }

    public b a() {
        return this.c;
    }

    public c b() {
        return this.a;
    }

    public String toString() {
        String str6 = null;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Request{method=");
        stringBuilder.append(this.b);
        stringBuilder.append(", url=");
        stringBuilder.append(this.a);
        stringBuilder.append(", tag=");
        if (this.d == this) {
            int i2 = 0;
        }
        stringBuilder.append(str6);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }

    private e(e.b bVar) {
        Object obj;
        super();
        this.a = bVar.a;
        this.b = bVar.b;
        this.c = bVar.c.c();
        bVar.d;
        if (bVar.e != null) {
            obj = bVar.e;
        } else {
            obj = this;
        }
        this.d = obj;
    }
}
