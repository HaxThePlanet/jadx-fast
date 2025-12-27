package f.c.a.b.i.a0.j;

/* compiled from: AutoValue_EventStoreConfig.java */
/* loaded from: classes.dex */
final class f0 extends j0 {

    private final long b;
    private final int c;
    private final int d;
    private final long e;
    private final int f;

    static class a {
    }

    static final class b extends j0.a {

        private Long a;
        private Integer b;
        private Integer c;
        private Long d;
        private Integer e;
        b() {
            super();
        }

        @Override // f.c.a.b.i.a0.j.j0$a
        j0 a() {
            String str;
            str = "";
            if (this.a == null) {
                StringBuilder stringBuilder5 = new StringBuilder();
                String str6 = " maxStorageSizeInBytes";
                str = str + str6;
            }
            if (this.b == null) {
                StringBuilder stringBuilder = new StringBuilder();
                String str2 = " loadBatchSize";
                str = str + str2;
            }
            if (this.c == null) {
                StringBuilder stringBuilder4 = new StringBuilder();
                String str5 = " criticalSectionEnterTimeoutMs";
                str = str + str5;
            }
            if (this.d == null) {
                StringBuilder stringBuilder2 = new StringBuilder();
                String str3 = " eventCleanUpAge";
                str = str + str3;
            }
            if (this.e == null) {
                StringBuilder stringBuilder3 = new StringBuilder();
                String str4 = " maxBlobByteSizePerRow";
                str = str + str4;
            }
            if (!str.isEmpty()) {
                StringBuilder stringBuilder6 = new StringBuilder();
                String str7 = "Missing required properties:";
                r1 = str7 + str;
                throw new IllegalStateException(r1);
            } else {
                f0 f0Var = new f0(this.a.longValue(), i, this.b.intValue(), this.c.intValue(), this.d.longValue(), aVar, this.e.intValue(), 0);
                return f0Var;
            }
        }

        @Override // f.c.a.b.i.a0.j.j0$a
        j0.a b(int i) {
            this.c = Integer.valueOf(i);
            return this;
        }

        @Override // f.c.a.b.i.a0.j.j0$a
        j0.a c(long j) {
            this.d = Long.valueOf(j);
            return this;
        }

        @Override // f.c.a.b.i.a0.j.j0$a
        j0.a d(int i) {
            this.b = Integer.valueOf(i);
            return this;
        }

        @Override // f.c.a.b.i.a0.j.j0$a
        j0.a e(int i) {
            this.e = Integer.valueOf(i);
            return this;
        }

        @Override // f.c.a.b.i.a0.j.j0$a
        j0.a f(long j) {
            this.a = Long.valueOf(j);
            return this;
        }
    }
    /* synthetic */ f0(long j, int i, int i2, long j2, int i3, f0.a aVar) {
        this(j, r2, i, i2, j2, r6, i3);
    }

    @Override // f.c.a.b.i.a0.j.j0
    int b() {
        return this.d;
    }

    @Override // f.c.a.b.i.a0.j.j0
    long c() {
        return this.e;
    }

    @Override // f.c.a.b.i.a0.j.j0
    int d() {
        return this.c;
    }

    @Override // f.c.a.b.i.a0.j.j0
    int e() {
        return this.f;
    }

    @Override // f.c.a.b.i.a0.j.j0
    public boolean equals(Object object) {
        boolean z = true;
        int cmp;
        long l;
        long l2;
        int i2;
        z = true;
        if (object == this) {
            return true;
        }
        final int i = 0;
        if (object instanceof j0) {
            l2 = object.f();
            if (this.b == l2) {
                if (this.c == object.d()) {
                    if (this.d == object.b()) {
                        l2 = object.c();
                        if (this.e == l2) {
                            if (this.f != object.e()) {
                            }
                        }
                    }
                }
            }
            return z;
        }
        return false;
    }

    @Override // f.c.a.b.i.a0.j.j0
    long f() {
        return this.b;
    }

    @Override // f.c.a.b.i.a0.j.j0
    public int hashCode() {
        int i13 = 32;
        int i11 = 1000003;
        return (int)(l ^ (l >>> i13)) ^ i11 * i11 ^ this.c * i11 ^ this.d * i11 ^ (int)(l5 >>> i13) ^ l5 * i11 ^ this.f;
    }

    @Override // f.c.a.b.i.a0.j.j0
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        String str2 = "EventStoreConfig{maxStorageSizeInBytes=";
        String str3 = ", loadBatchSize=";
        String str4 = ", criticalSectionEnterTimeoutMs=";
        String str5 = ", eventCleanUpAge=";
        String str6 = ", maxBlobByteSizePerRow=";
        String str7 = "}";
        str = str2 + this.b + str3 + this.c + str4 + this.d + str5 + this.e + str6 + this.f + str7;
        return str;
    }

    private f0(long j, int i, int i2, long j2, int i3) {
        super();
        this.b = j;
        this.c = i;
        this.d = i2;
        this.e = j2;
        this.f = i3;
    }
}
