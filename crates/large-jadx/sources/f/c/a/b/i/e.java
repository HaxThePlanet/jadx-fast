package f.c.a.b.i;

import f.c.a.b.d;
import java.util.Arrays;
import java.util.Objects;

/* loaded from: classes.dex */
final class e extends f.c.a.b.i.p {

    private final String a;
    private final byte[] b;
    private final d c;

    static class a {
    }

    static final class b extends f.c.a.b.i.p.a {

        private String a;
        private byte[] b;
        private d c;
        @Override // f.c.a.b.i.p$a
        public f.c.a.b.i.p a() {
            Object stringBuilder;
            Object stringBuilder2;
            String string;
            if (this.a == null) {
                stringBuilder = new StringBuilder();
                stringBuilder.append("");
                stringBuilder.append(" backendName");
                string = stringBuilder.toString();
            }
            if (this.c == null) {
                stringBuilder2 = new StringBuilder();
                stringBuilder2.append(string);
                stringBuilder2.append(" priority");
                string = stringBuilder2.toString();
            }
            if (!string.isEmpty()) {
            } else {
                e eVar = new e(this.a, this.b, this.c, 0);
                return eVar;
            }
            StringBuilder stringBuilder3 = new StringBuilder();
            stringBuilder3.append("Missing required properties:");
            stringBuilder3.append(string);
            IllegalStateException illegalStateException = new IllegalStateException(stringBuilder3.toString());
            throw illegalStateException;
        }

        @Override // f.c.a.b.i.p$a
        public f.c.a.b.i.p.a b(String string) {
            Objects.requireNonNull(string, "Null backendName");
            this.a = string;
            return this;
        }

        @Override // f.c.a.b.i.p$a
        public f.c.a.b.i.p.a c(byte[] bArr) {
            this.b = bArr;
            return this;
        }

        @Override // f.c.a.b.i.p$a
        public f.c.a.b.i.p.a d(d d) {
            Objects.requireNonNull(d, "Null priority");
            this.c = d;
            return this;
        }
    }
    private e(String string, byte[] b2Arr2, d d3) {
        super();
        this.a = string;
        this.b = b2Arr2;
        this.c = d3;
    }

    e(String string, byte[] b2Arr2, d d3, f.c.a.b.i.e.a e$a4) {
        super(string, b2Arr2, d3);
    }

    @Override // f.c.a.b.i.p
    public String b() {
        return this.a;
    }

    @Override // f.c.a.b.i.p
    public byte[] c() {
        return this.b;
    }

    @Override // f.c.a.b.i.p
    public d d() {
        return this.c;
    }

    @Override // f.c.a.b.i.p
    public boolean equals(Object object) {
        int i;
        boolean equals;
        String str;
        Object obj5;
        if (object == this) {
            return 1;
        }
        final int i2 = 0;
        if (object instanceof p) {
            if (this.a.equals((p)object.b())) {
                if (object instanceof e) {
                    str = obj.b;
                } else {
                    str = object.c();
                }
                if (Arrays.equals(this.b, str) && this.c.equals(object.d())) {
                    if (this.c.equals(object.d())) {
                    } else {
                        i = i2;
                    }
                } else {
                }
            } else {
            }
            return i;
        }
        return i2;
    }

    @Override // f.c.a.b.i.p
    public int hashCode() {
        int i7 = 1000003;
        return i5 ^= i8;
    }
}
