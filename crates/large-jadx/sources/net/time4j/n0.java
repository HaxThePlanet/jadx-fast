package net.time4j;

import net.time4j.engine.v;
import net.time4j.f1.c;
import net.time4j.i1.f;

/* loaded from: classes3.dex */
public enum n0 implements v {

    SECONDS(4607182418800017408, true),
    NANOSECONDS(4472406533629990549, /* unknown */);

    private final double length;

    static class a {

        static final int[] a;
        static {
            int[] iArr = new int[values.length];
            n0.a.a = iArr;
            iArr[n0.SECONDS.ordinal()] = 1;
            n0.a.a[n0.NANOSECONDS.ordinal()] = 2;
        }
    }
    @Override // java.lang.Enum
    public long between(net.time4j.b0 b0, net.time4j.b0 b02) {
        int i;
        net.time4j.b0 obj6;
        net.time4j.b0 obj7;
        b0.W(b0);
        b0.W(b02);
        int i2 = n0.a.a[ordinal()];
        if (i2 != 1) {
            if (i2 != 2) {
            } else {
                f uTC = f.UTC;
                long l3 = b02.f(uTC);
                long l5 = b0.f(uTC);
                obj7 -= obj6;
                return c.f(c.i(c.m(l3, obj2), l3), l3);
            }
            obj6 = new UnsupportedOperationException();
            throw obj6;
        }
        f uTC2 = f.UTC;
        l4 -= l6;
        int cmp = Long.compare(i, i6);
        int i7 = 1;
        if (cmp < 0) {
            if (b02.a() > b0.a()) {
                i += i7;
            }
        } else {
            if (cmp > 0 && b02.a() < b0.a()) {
                if (b02.a() < b0.a()) {
                    i -= i7;
                }
            }
        }
        return i;
    }

    @Override // java.lang.Enum
    public double getLength() {
        return this.length;
    }

    @Override // java.lang.Enum
    public boolean isCalendrical() {
        return 0;
    }
}
