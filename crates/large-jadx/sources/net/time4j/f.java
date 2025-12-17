package net.time4j;

import net.time4j.engine.i0;
import net.time4j.engine.k0;
import net.time4j.engine.m;
import net.time4j.engine.q;

/* loaded from: classes3.dex */
public enum f implements net.time4j.v {

    MILLENNIA,
    CENTURIES,
    DECADES,
    YEARS,
    QUARTERS,
    MONTHS,
    WEEKS,
    DAYS;

    private final net.time4j.v co;
    private final net.time4j.v eof;
    private final net.time4j.v joda;
    private final net.time4j.v kld;
    private final net.time4j.v nvd;
    private final net.time4j.v ui;

    static class i {

        static final int[] a;
        static {
            int[] iArr = new int[values.length];
            f.i.a = iArr;
            iArr[f.WEEKS.ordinal()] = 1;
            f.i.a[f.DAYS.ordinal()] = 2;
            f.i.a[f.MILLENNIA.ordinal()] = 3;
            f.i.a[f.CENTURIES.ordinal()] = 4;
            f.i.a[f.DECADES.ordinal()] = 5;
            f.i.a[f.YEARS.ordinal()] = 6;
            f.i.a[f.QUARTERS.ordinal()] = 7;
            f.i.a[f.MONTHS.ordinal()] = 8;
        }
    }

    static class j implements k0<T> {

        private final net.time4j.f a;
        private final int b;
        j(net.time4j.f f) {
            super(f, 0);
        }

        j(net.time4j.f f, int i2) {
            super();
            this.a = f;
            this.b = i2;
        }

        private static long e(net.time4j.g0 g0, net.time4j.g0 g02) {
            if (g0.m() == g02.m()) {
                return (long)obj3;
            }
            return l -= obj2;
        }

        private long f(net.time4j.g0 g0, net.time4j.g0 g02) {
            int i;
            int cmp;
            int cmp2;
            int i2;
            int mONTHS;
            int obj9;
            int obj10;
            l -= l2;
            cmp = this.b;
            cmp2 = 0;
            final int i3 = 1;
            if (cmp != 5 && cmp != 2) {
                if (cmp != 2) {
                    if (cmp == 6) {
                        mONTHS = f.MONTHS;
                        cmp2 = Long.compare(i, cmp2);
                        i = cmp2 > 0 ? i - i3 : i + i3;
                    } else {
                        cmp = Long.compare(i, cmp2);
                        if (cmp > 0 && g02.q() < g0.q()) {
                            if (g02.q() < g0.q()) {
                            } else {
                                if (cmp < 0 && g02.q() > g0.q()) {
                                    if (g02.q() > g0.q()) {
                                    }
                                }
                            }
                        } else {
                        }
                    }
                } else {
                }
            } else {
            }
            return i;
        }

        @Override // net.time4j.engine.k0
        public long a(Object object, Object object2) {
            return d((q)object, (q)object2);
        }

        @Override // net.time4j.engine.k0
        public Object b(Object object, long l2) {
            return c((q)object, l2);
        }

        public T c(T t, long l2) {
            final net.time4j.engine.p pVar = g0.F;
            return t.G(pVar, g0.u0(this.a, (g0)t.p(pVar), l2, obj7));
        }

        public long d(T t, T t2) {
            Object obj2;
            Object obj;
            int i;
            int i3;
            net.time4j.engine.p pVar;
            boolean z;
            net.time4j.f dAYS;
            int i4;
            Object obj10;
            Object obj11;
            net.time4j.engine.p pVar2 = g0.F;
            obj = t.p(pVar2);
            obj2 = t2.p(pVar2);
            int ordinal = this.a.ordinal();
            switch (i5) {
                case 1:
                    l3 /= i3;
                    break;
                case 2:
                    i = f.j.e(obj, obj2);
                    break;
                case 3:
                    l5 /= i3;
                    break;
                case 4:
                    l2 /= i3;
                    break;
                case 5:
                    l6 /= i3;
                    break;
                case 6:
                    l4 /= i3;
                    break;
                case 7:
                    l /= i3;
                    break;
                case 8:
                    i = f(obj, obj2);
                    break;
                default:
                    obj10 = new UnsupportedOperationException(this.a.name());
                    throw obj10;
            }
            int cmp = Long.compare(i, i6);
            pVar = h0.G;
            if (cmp != 0 && t.v(pVar) && t2.v(pVar)) {
                pVar = h0.G;
                if (t.v(pVar)) {
                    if (t2.v(pVar)) {
                        z = this.a;
                        i4 = 1;
                        if (z == f.DAYS) {
                        } else {
                            if ((g0)obj.M(i, ordinal).O(obj2) == 0) {
                            } else {
                                i4 = obj2;
                            }
                        }
                        if (i4 != 0) {
                            obj10 = t.p(pVar);
                            obj11 = t2.p(pVar);
                            obj2 = 1;
                            if (cmp > 0 && (h0)obj10.z0((h0)obj11)) {
                                if (obj10.z0(obj11)) {
                                    i -= obj2;
                                } else {
                                    if (cmp < 0 && obj10.A0(obj11)) {
                                        if (obj10.A0(obj11)) {
                                            i += obj2;
                                        }
                                    }
                                }
                            } else {
                            }
                        }
                    }
                }
            }
            return i;
        }
    }

    static enum a extends net.time4j.f {
        @Override // net.time4j.f
        public double getLength() {
            return 4764073672128331776L;
        }

        @Override // net.time4j.f
        public char getSymbol() {
            return 73;
        }
    }

    static enum b extends net.time4j.f {
        @Override // net.time4j.f
        public double getLength() {
            return 4748908380121202688L;
        }

        @Override // net.time4j.f
        public char getSymbol() {
            return 67;
        }
    }

    static enum c extends net.time4j.f {
        @Override // net.time4j.f
        public double getLength() {
            return 4734073986739077120L;
        }

        @Override // net.time4j.f
        public char getSymbol() {
            return 69;
        }
    }

    static enum d extends net.time4j.f {
        @Override // net.time4j.f
        public double getLength() {
            return 4719236215029628928L;
        }

        @Override // net.time4j.f
        public char getSymbol() {
            return 89;
        }
    }

    static enum e extends net.time4j.f {
        @Override // net.time4j.f
        public double getLength() {
            return 4710229015774887936L;
        }

        @Override // net.time4j.f
        public char getSymbol() {
            return 81;
        }
    }

    static enum f extends net.time4j.f {
        @Override // net.time4j.f
        public double getLength() {
            return 4702901747880820736L;
        }

        @Override // net.time4j.f
        public char getSymbol() {
            return 77;
        }
    }

    static enum g extends net.time4j.f {
        @Override // net.time4j.f
        public double getLength() {
            return 4693442404533927936L;
        }

        @Override // net.time4j.f
        public char getSymbol() {
            return 87;
        }
    }

    static enum h extends net.time4j.f {
        @Override // net.time4j.f
        public double getLength() {
            return 4680673776000565248L;
        }

        @Override // net.time4j.f
        public char getSymbol() {
            return 68;
        }
    }
    public static net.time4j.v weekBasedYears() {
        return w0.a;
    }

    @Override // java.lang.Enum
    public net.time4j.v atEndOfMonth() {
        int i;
        int i2 = f.i.a[ordinal()];
        if (i2 == 1) {
        } else {
            if (i2 == 2) {
            } else {
                return this.eof;
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Original unit is not month-based: ");
        stringBuilder.append(name());
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException(stringBuilder.toString());
        throw unsupportedOperationException;
    }

    public <T extends i0<? super net.time4j.f, T>> long between(T t, T t2) {
        return t.N(t2, this);
    }

    @Override // java.lang.Enum
    public abstract double getLength();

    @Override // java.lang.Enum
    public abstract char getSymbol();

    @Override // java.lang.Enum
    public boolean isCalendrical() {
        return 1;
    }

    @Override // java.lang.Enum
    public net.time4j.v keepingEndOfMonth() {
        int i;
        int i2 = f.i.a[ordinal()];
        if (i2 == 1) {
        } else {
            if (i2 == 2) {
            } else {
                return this.kld;
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Original unit is not month-based: ");
        stringBuilder.append(name());
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException(stringBuilder.toString());
        throw unsupportedOperationException;
    }

    @Override // java.lang.Enum
    public net.time4j.v nextValidDate() {
        int i;
        int i2 = f.i.a[ordinal()];
        if (i2 != 1 && i2 != 2) {
            if (i2 != 2) {
                return this.nvd;
            }
        }
        return this;
    }

    @Override // java.lang.Enum
    public net.time4j.v unlessInvalid() {
        int i;
        int i2 = f.i.a[ordinal()];
        if (i2 != 1 && i2 != 2) {
            if (i2 != 2) {
                return this.ui;
            }
        }
        return this;
    }

    @Override // java.lang.Enum
    public net.time4j.v withCarryOver() {
        int i;
        int i2 = f.i.a[ordinal()];
        if (i2 != 1 && i2 != 2) {
            if (i2 != 2) {
                return this.co;
            }
        }
        return this;
    }

    @Override // java.lang.Enum
    public net.time4j.v withJodaMetric() {
        int i;
        int i2 = f.i.a[ordinal()];
        if (i2 != 1 && i2 != 2) {
            if (i2 != 2) {
                return this.joda;
            }
        }
        return this;
    }
}
