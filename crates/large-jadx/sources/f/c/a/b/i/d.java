package f.c.a.b.i;

import f.c.a.b.b;
import f.c.a.b.c;
import f.c.a.b.e;
import java.util.Objects;

/* compiled from: AutoValue_SendRequest.java */
/* loaded from: classes.dex */
final class d extends o {

    private final p a;
    private final String b;
    private final c<?> c;
    private final e<?, byte[]> d;
    private final b e;

    static class a {
    }

    static final class b extends o.a {

        private p a;
        private String b;
        private c<?> c;
        private e<?, byte[]> d;
        private b e;
        b() {
            super();
        }

        @Override // f.c.a.b.i.o$a
        public o a() {
            String str2;
            str2 = "";
            if (this.a == null) {
                StringBuilder stringBuilder5 = new StringBuilder();
                String str7 = " transportContext";
                str2 = str2 + str7;
            }
            if (this.b == null) {
                StringBuilder stringBuilder = new StringBuilder();
                String str3 = " transportName";
                str2 = str2 + str3;
            }
            if (this.c == null) {
                StringBuilder stringBuilder4 = new StringBuilder();
                String str6 = " event";
                str2 = str2 + str6;
            }
            if (this.d == null) {
                StringBuilder stringBuilder2 = new StringBuilder();
                String str4 = " transformer";
                str2 = str2 + str4;
            }
            if (this.e == null) {
                StringBuilder stringBuilder3 = new StringBuilder();
                String str5 = " encoding";
                str2 = str2 + str5;
            }
            if (!str2.isEmpty()) {
                StringBuilder stringBuilder6 = new StringBuilder();
                String str8 = "Missing required properties:";
                r1 = str8 + str2;
                throw new IllegalStateException(r1);
            } else {
                d dVar = new d(this.a, this.b, this.c, this.d, this.e, null);
                return dVar;
            }
        }

        @Override // f.c.a.b.i.o$a
        o.a b(b bVar) {
            Objects.requireNonNull(bVar, "Null encoding");
            this.e = bVar;
            return this;
        }

        @Override // f.c.a.b.i.o$a
        o.a c(c<?> cVar) {
            Objects.requireNonNull(cVar, "Null event");
            this.c = cVar;
            return this;
        }

        @Override // f.c.a.b.i.o$a
        o.a d(e<?, byte[]> eVar) {
            Objects.requireNonNull(eVar, "Null transformer");
            this.d = eVar;
            return this;
        }

        @Override // f.c.a.b.i.o$a
        public o.a e(p pVar) {
            Objects.requireNonNull(pVar, "Null transportContext");
            this.a = pVar;
            return this;
        }

        @Override // f.c.a.b.i.o$a
        public o.a f(String str) {
            Objects.requireNonNull(str, "Null transportName");
            this.b = str;
            return this;
        }
    }
    /* synthetic */ d(p pVar, String str, c cVar, e eVar, b bVar, d.a aVar) {
        this(pVar, str, cVar, eVar, bVar);
    }

    @Override // f.c.a.b.i.o
    public b b() {
        return this.e;
    }

    @Override // f.c.a.b.i.o
    c<?> c() {
        return this.c;
    }

    @Override // f.c.a.b.i.o
    e<?, byte[]> e() {
        return this.d;
    }

    @Override // f.c.a.b.i.o
    public boolean equals(Object object) {
        boolean z = true;
        boolean equals;
        f.c.a.b.i.p pVar;
        boolean equals2;
        z = true;
        if (object == this) {
            return true;
        }
        final int i = 0;
        if (object instanceof o) {
            if (this.a.equals(object.f())) {
                if (this.b.equals(object.g())) {
                    if (this.c.equals(object.c())) {
                        if (this.d.equals(object.e())) {
                            if (!(this.e.equals(object.b()))) {
                            }
                        }
                    }
                }
            }
            return z;
        }
        return false;
    }

    @Override // f.c.a.b.i.o
    public p f() {
        return this.a;
    }

    @Override // f.c.a.b.i.o
    public String g() {
        return this.b;
    }

    @Override // f.c.a.b.i.o
    public int hashCode() {
        int i11 = 1000003;
        return (this.a.hashCode() ^ i11) * i11 ^ this.b.hashCode() * i11 ^ this.c.hashCode() * i11 ^ this.d.hashCode() * i11 ^ this.e.hashCode();
    }

    @Override // f.c.a.b.i.o
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        String str2 = "SendRequest{transportContext=";
        String str3 = ", transportName=";
        String str5 = ", event=";
        String str6 = ", transformer=";
        String str7 = ", encoding=";
        String str8 = "}";
        str = str2 + this.a + str3 + this.b + str5 + this.c + str6 + this.d + str7 + this.e + str8;
        return str;
    }

    private d(p pVar, String str, c<?> cVar, e<?, byte[]> eVar, b bVar) {
        super();
        this.a = pVar;
        this.b = str;
        this.c = cVar;
        this.d = eVar;
        this.e = bVar;
    }
}
