package net.time4j;

import net.time4j.engine.v;
import net.time4j.f1.c;
import net.time4j.i1.f;

/* compiled from: SI.java */
/* loaded from: classes3.dex */
public enum n0 implements v {

    NANOSECONDS,
    SECONDS;

    private final double length;

    static class a {

        static final /* synthetic */ int[] a;
        static {
            int[] iArr = new int[n0.values().length];
            n0.a.a = iArr;
            try {
                iArr[n0.SECONDS.ordinal()] = 1;
            } catch (java.lang.NoSuchFieldError unused) {
                return;
            }
            try {
                n0.a.a[n0.NANOSECONDS.ordinal()] = 2;
            } catch (java.lang.NoSuchFieldError unused) {
                return;
            }
        }
    }
    @Override // java.lang.Enum
    public long between(b0 b0Var, b0 b0Var2) {
        long l;
        b0.W(b0Var);
        b0.W(b0Var2);
        int i3 = n0.a.a[ordinal()];
        if (n0.a.a != 1 && n0.a.a == 2) {
            f uTC2 = f.UTC;
            long l4 = b0Var2.f(uTC2);
            long l7 = b0Var.f(uTC2);
            int i10 = b0Var2.a() - b0Var.a();
            return c.f(c.i(c.m(l4, l7), 1000000000L), (long)i10);
        }
        f uTC22 = f.UTC;
        l = b0Var2.f(uTC22) - b0Var.f(uTC22);
        long l9 = 1L;
        if (l < 0) {
            if (b0Var2.a() > b0Var.a()) {
                l = l + 1L;
            }
        } else {
            if (l > 0) {
                if (b0Var2.a() < b0Var.a()) {
                    l = l - 1L;
                }
            }
        }
        return l;
    }

    @Override // java.lang.Enum
    public double getLength() {
        return this.length;
    }

    @Override // java.lang.Enum
    public boolean isCalendrical() {
        return false;
    }
}
