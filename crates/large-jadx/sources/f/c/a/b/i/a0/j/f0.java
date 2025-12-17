package f.c.a.b.i.a0.j;

/* loaded from: classes.dex */
final class f0 extends f.c.a.b.i.a0.j.j0 {

    private final long b;
    private final int c;
    private final int d;
    private final long e;
    private final int f;

    static class a {
    }

    static final class b extends f.c.a.b.i.a0.j.j0.a {

        private Long a;
        private Integer b;
        private Integer c;
        private Long d;
        private Integer e;
        @Override // f.c.a.b.i.a0.j.j0$a
        f.c.a.b.i.a0.j.j0 a() {
            Object stringBuilder5;
            Object stringBuilder4;
            Object stringBuilder2;
            Object stringBuilder3;
            Object stringBuilder;
            String string;
            if (this.a == null) {
                stringBuilder5 = new StringBuilder();
                stringBuilder5.append("");
                stringBuilder5.append(" maxStorageSizeInBytes");
                string = stringBuilder5.toString();
            }
            if (this.b == null) {
                stringBuilder4 = new StringBuilder();
                stringBuilder4.append(string);
                stringBuilder4.append(" loadBatchSize");
                string = stringBuilder4.toString();
            }
            if (this.c == null) {
                stringBuilder2 = new StringBuilder();
                stringBuilder2.append(string);
                stringBuilder2.append(" criticalSectionEnterTimeoutMs");
                string = stringBuilder2.toString();
            }
            if (this.d == null) {
                stringBuilder3 = new StringBuilder();
                stringBuilder3.append(string);
                stringBuilder3.append(" eventCleanUpAge");
                string = stringBuilder3.toString();
            }
            if (this.e == null) {
                stringBuilder = new StringBuilder();
                stringBuilder.append(string);
                stringBuilder.append(" maxBlobByteSizePerRow");
                string = stringBuilder.toString();
            }
            if (!string.isEmpty()) {
            } else {
                super(this.a.longValue(), obj4, this.b.intValue(), this.c.intValue(), this.d.longValue(), obj8, this.e.intValue(), 0);
                return f0Var;
            }
            StringBuilder stringBuilder6 = new StringBuilder();
            stringBuilder6.append("Missing required properties:");
            stringBuilder6.append(string);
            IllegalStateException illegalStateException = new IllegalStateException(stringBuilder6.toString());
            throw illegalStateException;
        }

        @Override // f.c.a.b.i.a0.j.j0$a
        f.c.a.b.i.a0.j.j0.a b(int i) {
            this.c = Integer.valueOf(i);
            return this;
        }

        @Override // f.c.a.b.i.a0.j.j0$a
        f.c.a.b.i.a0.j.j0.a c(long l) {
            this.d = Long.valueOf(l);
            return this;
        }

        @Override // f.c.a.b.i.a0.j.j0$a
        f.c.a.b.i.a0.j.j0.a d(int i) {
            this.b = Integer.valueOf(i);
            return this;
        }

        @Override // f.c.a.b.i.a0.j.j0$a
        f.c.a.b.i.a0.j.j0.a e(int i) {
            this.e = Integer.valueOf(i);
            return this;
        }

        @Override // f.c.a.b.i.a0.j.j0$a
        f.c.a.b.i.a0.j.j0.a f(long l) {
            this.a = Long.valueOf(l);
            return this;
        }
    }
    private f0(long l, int i2, int i3, long l4, int i5) {
        super();
        this.b = l;
        this.c = i3;
        this.d = l4;
        this.e = i5;
        this.f = obj7;
    }

    f0(long l, int i2, int i3, long l4, int i5, f.c.a.b.i.a0.j.f0.a f0$a6) {
        super(l, i2, i3, l4, i5, a6, obj7);
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
        int i;
        int cmp;
        long l;
        long l2;
        Object obj8;
        if (object == this) {
            return 1;
        }
        final int i2 = 0;
        if (object instanceof j0) {
            if (Long.compare(l, l2) == 0 && this.c == object.d() && this.d == object.b() && Long.compare(l, l2) == 0 && this.f == object.e()) {
                if (this.c == object.d()) {
                    if (this.d == object.b()) {
                        if (Long.compare(l, l2) == 0) {
                            if (this.f == object.e()) {
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

    @Override // f.c.a.b.i.a0.j.j0
    long f() {
        return this.b;
    }

    @Override // f.c.a.b.i.a0.j.j0
    public int hashCode() {
        long l = this.b;
        int i14 = 32;
        int i12 = 1000003;
        long l2 = this.e;
        return i10 ^= i13;
    }

    @Override // f.c.a.b.i.a0.j.j0
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("EventStoreConfig{maxStorageSizeInBytes=");
        stringBuilder.append(this.b);
        stringBuilder.append(", loadBatchSize=");
        stringBuilder.append(this.c);
        stringBuilder.append(", criticalSectionEnterTimeoutMs=");
        stringBuilder.append(this.d);
        stringBuilder.append(", eventCleanUpAge=");
        stringBuilder.append(this.e);
        stringBuilder.append(", maxBlobByteSizePerRow=");
        stringBuilder.append(this.f);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}
