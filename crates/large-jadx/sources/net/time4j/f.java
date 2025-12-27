package net.time4j;

import net.time4j.engine.i0;
import net.time4j.engine.k0;
import net.time4j.engine.m;
import net.time4j.engine.q;

/* compiled from: CalendarUnit.java */
/* loaded from: classes3.dex */
public enum f implements v {

    CENTURIES,
    DAYS,
    DECADES,
    MILLENNIA,
    MONTHS,
    QUARTERS,
    WEEKS,
    YEARS;

    private final v co;
    private final v eof;
    private final v joda;
    private final v kld;
    private final v nvd;
    private final v ui;

    static class i {

        static final /* synthetic */ int[] a;
        static {
            int[] iArr = new int[f.values().length];
            f.i.a = iArr;
            try {
                iArr[f.WEEKS.ordinal()] = 1;
            } catch (java.lang.NoSuchFieldError unused) {
                return;
            }
            try {
                f.i.a[f.DAYS.ordinal()] = 2;
            } catch (java.lang.NoSuchFieldError unused) {
                return;
            }
            try {
                f.i.a[f.MILLENNIA.ordinal()] = 3;
            } catch (java.lang.NoSuchFieldError unused) {
                return;
            }
            try {
                f.i.a[f.CENTURIES.ordinal()] = 4;
            } catch (java.lang.NoSuchFieldError unused) {
                return;
            }
            try {
                f.i.a[f.DECADES.ordinal()] = 5;
            } catch (java.lang.NoSuchFieldError unused) {
                return;
            }
            try {
                f.i.a[f.YEARS.ordinal()] = 6;
            } catch (java.lang.NoSuchFieldError unused) {
                return;
            }
            try {
                f.i.a[f.QUARTERS.ordinal()] = 7;
            } catch (java.lang.NoSuchFieldError unused) {
                return;
            }
            try {
                f.i.a[f.MONTHS.ordinal()] = 8;
            } catch (java.lang.NoSuchFieldError unused) {
                return;
            }
        }
    }

    static class j<T extends q<T>> implements k0<T> {

        private final f a;
        private final int b;
        j() {
            this(fVar, 0);
        }

        private static long e(g0 g0Var, g0 g0Var2) {
            if (g0Var.m() == g0Var2.m()) {
                return (long)(g0Var2.D0() - g0Var.D0());
            }
            return g0Var2.E0() - g0Var.E0();
        }

        private long f(g0 g0Var, g0 g0Var2) {
            long l;
            int cmp;
            int cmp2;
            long l2;
            int i;
            int i2 = 6;
            int i3;
            int i4;
            l = g0Var2.F0() - g0Var.F0();
            l2 = 0L;
            final long l6 = 1L;
            i2 = 5;
            if (this.b == 5 || !(this.b == 2 && this.b != 6)) {
                l = l - 1L;
            } else {
                net.time4j.f mONTHS2 = f.MONTHS;
                long r0 = l > l2 ? l - l6 : l + l6;
            }
            return (l > l2 ? l - l6 : l + l6);
        }

        public T c(T t, long j) {
            final net.time4j.engine.p pVar = g0.F;
            return t.G(pVar, g0.u0(this.a, (g0)t.p(pVar), j, this.b));
        }

        public long d(T t, T t2) {
            Object obj = null;
            Object obj2;
            long l;
            net.time4j.engine.p pVar;
            int i2 = 1;
            net.time4j.engine.p pVar2 = g0.F;
            obj2 = t.p(pVar2);
            obj = t2.p(pVar2);
            int ordinal = this.a.ordinal();
            switch (f.i.a[ordinal]) {
                case 1:
                    long l2 = 7L;
                    l = (f.j.e(obj2, obj)) / 7L;
                    break;
                case 2:
                    l = f.j.e(obj2, obj);
                    break;
                case 3:
                    l2 = 12000L;
                    l = (this.f(obj2, obj)) / 12000L;
                    break;
                case 4:
                    l2 = 1200L;
                    l = (this.f(obj2, obj)) / 1200L;
                    break;
                case 5:
                    l2 = 120L;
                    l = (this.f(obj2, obj)) / 120L;
                    break;
                case 6:
                    l2 = 12L;
                    l = (this.f(obj2, obj)) / 12L;
                    break;
                case 7:
                    l2 = 3L;
                    l = (this.f(obj2, obj)) / 3L;
                    break;
                case 8:
                    l = f(obj2, obj);
                    break;
                default:
                    throw new UnsupportedOperationException(this.a.name());
            }
            if (l != 0) {
                pVar = h0.G;
                if (t.v(pVar) && this.a.v(h0.G)) {
                    i2 = 1;
                    if (this.a != f.DAYS) {
                        if ((g0)obj2.M(l, this.a).O(obj) != 0) {
                        }
                    }
                    if (i2 != 0) {
                        Object obj3 = t.p(h0.G);
                        Object obj4 = t2.p(h0.G);
                        long l3 = 1L;
                        if (l <= 0 || !obj3.z0(obj4)) {
                            if (l < 0 && obj3.A0(obj4)) {
                                l = l + 1L;
                            }
                        } else {
                            l = l - 1L;
                        }
                    }
                }
            }
            return l;
        }

        j(int i) {
            super();
            this.a = fVar;
            this.b = i;
        }
    }

    enum a extends f {
        @Override // net.time4j.f
        public double getLength() {
            return 4764073672128331776L;
        }

        @Override // net.time4j.f
        public char getSymbol() {
            return 73;
        }
    }

    enum b extends f {
        @Override // net.time4j.f
        public double getLength() {
            return 4748908380121202688L;
        }

        @Override // net.time4j.f
        public char getSymbol() {
            return 67;
        }
    }

    enum c extends f {
        @Override // net.time4j.f
        public double getLength() {
            return 4734073986739077120L;
        }

        @Override // net.time4j.f
        public char getSymbol() {
            return 69;
        }
    }

    enum d extends f {
        @Override // net.time4j.f
        public double getLength() {
            return 4719236215029628928L;
        }

        @Override // net.time4j.f
        public char getSymbol() {
            return 89;
        }
    }

    enum e extends f {
        @Override // net.time4j.f
        public double getLength() {
            return 4710229015774887936L;
        }

        @Override // net.time4j.f
        public char getSymbol() {
            return 81;
        }
    }

    enum f extends f {
        @Override // net.time4j.f
        public double getLength() {
            return 4702901747880820736L;
        }

        @Override // net.time4j.f
        public char getSymbol() {
            return 77;
        }
    }

    enum g extends f {
        @Override // net.time4j.f
        public double getLength() {
            return 4693442404533927936L;
        }

        @Override // net.time4j.f
        public char getSymbol() {
            return 87;
        }
    }

    enum h extends f {
        @Override // net.time4j.f
        public double getLength() {
            return 4680673776000565248L;
        }

        @Override // net.time4j.f
        public char getSymbol() {
            return 68;
        }
    }
    public static v weekBasedYears() {
        return w0.a;
    }

    @Override // java.lang.Enum
    public v atEndOfMonth() {
        int i2 = f.i.a[ordinal()];
        int i = 1;
        if (f.i.a == 1) {
            StringBuilder stringBuilder = new StringBuilder();
            String str = "Original unit is not month-based: ";
            String name = name();
            r1 = str + name;
            throw new UnsupportedOperationException(r1);
        } else {
            i = 2;
            if (f.i.a != 2) {
                return this.eof;
            }
        }
    }

    @Override // java.lang.Enum
    public <T extends i0<? super f, T>> long between(T t, T t2) {
        return t.N(t2, this);
    }

    @Override // java.lang.Enum
    public v keepingEndOfMonth() {
        int i2 = f.i.a[ordinal()];
        int i = 1;
        if (f.i.a == 1) {
            StringBuilder stringBuilder = new StringBuilder();
            String str = "Original unit is not month-based: ";
            String name = name();
            r1 = str + name;
            throw new UnsupportedOperationException(r1);
        } else {
            i = 2;
            if (f.i.a != 2) {
                return this.kld;
            }
        }
    }

    @Override // java.lang.Enum
    public v nextValidDate() {
        int i2 = f.i.a[ordinal()];
        int i = 1;
        if (f.i.a != 1 && f.i.a != 2) {
            return this.nvd;
        }
        return this;
    }

    @Override // java.lang.Enum
    public v unlessInvalid() {
        int i2 = f.i.a[ordinal()];
        int i = 1;
        if (f.i.a != 1 && f.i.a != 2) {
            return this.ui;
        }
        return this;
    }

    @Override // java.lang.Enum
    public v withCarryOver() {
        int i2 = f.i.a[ordinal()];
        int i = 1;
        if (f.i.a != 1 && f.i.a != 2) {
            return this.co;
        }
        return this;
    }

    @Override // java.lang.Enum
    public v withJodaMetric() {
        int i2 = f.i.a[ordinal()];
        int i = 1;
        if (f.i.a != 1 && f.i.a != 2) {
            return this.joda;
        }
        return this;
    }

    @Override // java.lang.Enum
    public abstract /* synthetic */ double getLength();

    @Override // java.lang.Enum
    public abstract /* synthetic */ char getSymbol();

    @Override // java.lang.Enum
    public boolean isCalendrical() {
        return true;
    }
}
