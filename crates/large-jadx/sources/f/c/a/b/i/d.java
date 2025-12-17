package f.c.a.b.i;

import f.c.a.b.b;
import f.c.a.b.c;
import f.c.a.b.e;
import java.util.Objects;

/* loaded from: classes.dex */
final class d extends f.c.a.b.i.o {

    private final f.c.a.b.i.p a;
    private final String b;
    private final c<?> c;
    private final e<?, byte[]> d;
    private final b e;

    static class a {
    }

    static final class b extends f.c.a.b.i.o.a {

        private f.c.a.b.i.p a;
        private String b;
        private c<?> c;
        private e<?, byte[]> d;
        private b e;
        @Override // f.c.a.b.i.o$a
        public f.c.a.b.i.o a() {
            Object stringBuilder2;
            Object stringBuilder;
            Object stringBuilder4;
            Object stringBuilder5;
            Object stringBuilder3;
            String string;
            if (this.a == null) {
                stringBuilder2 = new StringBuilder();
                stringBuilder2.append("");
                stringBuilder2.append(" transportContext");
                string = stringBuilder2.toString();
            }
            if (this.b == null) {
                stringBuilder = new StringBuilder();
                stringBuilder.append(string);
                stringBuilder.append(" transportName");
                string = stringBuilder.toString();
            }
            if (this.c == null) {
                stringBuilder4 = new StringBuilder();
                stringBuilder4.append(string);
                stringBuilder4.append(" event");
                string = stringBuilder4.toString();
            }
            if (this.d == null) {
                stringBuilder5 = new StringBuilder();
                stringBuilder5.append(string);
                stringBuilder5.append(" transformer");
                string = stringBuilder5.toString();
            }
            if (this.e == null) {
                stringBuilder3 = new StringBuilder();
                stringBuilder3.append(string);
                stringBuilder3.append(" encoding");
                string = stringBuilder3.toString();
            }
            if (!string.isEmpty()) {
            } else {
                super(this.a, this.b, this.c, this.d, this.e, 0);
                return dVar;
            }
            StringBuilder stringBuilder6 = new StringBuilder();
            stringBuilder6.append("Missing required properties:");
            stringBuilder6.append(string);
            IllegalStateException illegalStateException = new IllegalStateException(stringBuilder6.toString());
            throw illegalStateException;
        }

        @Override // f.c.a.b.i.o$a
        f.c.a.b.i.o.a b(b b) {
            Objects.requireNonNull(b, "Null encoding");
            this.e = b;
            return this;
        }

        f.c.a.b.i.o.a c(c<?> c) {
            Objects.requireNonNull(c, "Null event");
            this.c = c;
            return this;
        }

        f.c.a.b.i.o.a d(e<?, byte[]> e) {
            Objects.requireNonNull(e, "Null transformer");
            this.d = e;
            return this;
        }

        @Override // f.c.a.b.i.o$a
        public f.c.a.b.i.o.a e(f.c.a.b.i.p p) {
            Objects.requireNonNull(p, "Null transportContext");
            this.a = p;
            return this;
        }

        @Override // f.c.a.b.i.o$a
        public f.c.a.b.i.o.a f(String string) {
            Objects.requireNonNull(string, "Null transportName");
            this.b = string;
            return this;
        }
    }
    private d(f.c.a.b.i.p p, String string2, c<?> c3, e<?, byte[]> e4, b b5) {
        super();
        this.a = p;
        this.b = string2;
        this.c = c3;
        this.d = e4;
        this.e = b5;
    }

    d(f.c.a.b.i.p p, String string2, c c3, e e4, b b5, f.c.a.b.i.d.a d$a6) {
        super(p, string2, c3, e4, b5);
    }

    @Override // f.c.a.b.i.o
    public b b() {
        return this.e;
    }

    c<?> c() {
        return this.c;
    }

    e<?, byte[]> e() {
        return this.d;
    }

    @Override // f.c.a.b.i.o
    public boolean equals(Object object) {
        int i;
        boolean equals;
        Object pVar;
        Object obj5;
        if (object == this) {
            return 1;
        }
        final int i2 = 0;
        if (object instanceof o) {
            if (this.a.equals((o)object.f()) && this.b.equals(object.g()) && this.c.equals(object.c()) && this.d.equals(object.e()) && this.e.equals(object.b())) {
                if (this.b.equals(object.g())) {
                    if (this.c.equals(object.c())) {
                        if (this.d.equals(object.e())) {
                            if (this.e.equals(object.b())) {
                            } else {
                                i = i2;
                            }
                        } else {
                        }
                    } else {
                    }
                } else {
                }
            } else {
            }
            return i;
        }
        return i2;
    }

    @Override // f.c.a.b.i.o
    public f.c.a.b.i.p f() {
        return this.a;
    }

    @Override // f.c.a.b.i.o
    public String g() {
        return this.b;
    }

    @Override // f.c.a.b.i.o
    public int hashCode() {
        int i11 = 1000003;
        return i9 ^= i12;
    }

    @Override // f.c.a.b.i.o
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("SendRequest{transportContext=");
        stringBuilder.append(this.a);
        stringBuilder.append(", transportName=");
        stringBuilder.append(this.b);
        stringBuilder.append(", event=");
        stringBuilder.append(this.c);
        stringBuilder.append(", transformer=");
        stringBuilder.append(this.d);
        stringBuilder.append(", encoding=");
        stringBuilder.append(this.e);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}
