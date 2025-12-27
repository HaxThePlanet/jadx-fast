package f.c.a.b.i;

import f.c.a.b.d;
import java.util.Arrays;
import java.util.Objects;

/* compiled from: AutoValue_TransportContext.java */
/* loaded from: classes.dex */
final class e extends p {

    private final String a;
    private final byte[] b;
    private final d c;

    static class a {
    }

    static final class b extends p.a {

        private String a;
        private byte[] b;
        private d c;
        b() {
            super();
        }

        @Override // f.c.a.b.i.p$a
        public p a() {
            String str2;
            str2 = "";
            if (this.a == null) {
                StringBuilder stringBuilder = new StringBuilder();
                String str3 = " backendName";
                str2 = str2 + str3;
            }
            if (this.c == null) {
                StringBuilder stringBuilder2 = new StringBuilder();
                String str4 = " priority";
                str2 = str2 + str4;
            }
            if (!str2.isEmpty()) {
                StringBuilder stringBuilder3 = new StringBuilder();
                String str6 = "Missing required properties:";
                r1 = str6 + str2;
                throw new IllegalStateException(r1);
            } else {
                return new e(this.a, this.b, this.c, null);
            }
        }

        @Override // f.c.a.b.i.p$a
        public p.a b(String str) {
            Objects.requireNonNull(str, "Null backendName");
            this.a = str;
            return this;
        }

        @Override // f.c.a.b.i.p$a
        public p.a c(byte[] bArr) {
            this.b = bArr;
            return this;
        }

        @Override // f.c.a.b.i.p$a
        public p.a d(d dVar) {
            Objects.requireNonNull(dVar, "Null priority");
            this.c = dVar;
            return this;
        }
    }
    /* synthetic */ e(String str, byte[] bArr, d dVar, e.a aVar) {
        this(str, bArr, dVar);
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
        boolean z = true;
        boolean equals;
        String str;
        byte[] bArr;
        boolean equals2;
        z = true;
        if (object == this) {
            return true;
        }
        final int i = 0;
        if (object instanceof p) {
            if (this.a.equals(object.b())) {
                if (object instanceof e) {
                } else {
                    bArr = object.c();
                }
                if (Arrays.equals(this.b, bArr)) {
                    if (!(this.c.equals(object.d()))) {
                    }
                }
            }
            return z;
        }
        return false;
    }

    @Override // f.c.a.b.i.p
    public int hashCode() {
        int i7 = 1000003;
        return (this.a.hashCode() ^ i7) * i7 ^ Arrays.hashCode(this.b) * i7 ^ this.c.hashCode();
    }

    private e(String str, byte[] bArr, d dVar) {
        super();
        this.a = str;
        this.b = bArr;
        this.c = dVar;
    }
}
