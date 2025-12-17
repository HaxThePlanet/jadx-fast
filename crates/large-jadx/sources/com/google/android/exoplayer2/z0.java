package com.google.android.exoplayer2;

import android.os.SystemClock;
import com.google.android.exoplayer2.util.p0;
import f.c.c.b.d;

/* loaded from: classes.dex */
public final class z0 implements com.google.android.exoplayer2.k1 {

    private final float a;
    private final float b;
    private final long c;
    private final float d;
    private final long e;
    private final long f;
    private final float g;
    private long h;
    private long i;
    private long j;
    private long k;
    private long l;
    private long m;
    private float n;
    private float o;
    private float p;
    private long q;
    private long r;
    private long s;

    static class a {
    }

    public static final class b {

        private float a = 0.97f;
        private float b = 1.03f;
        private long c = 1000;
        private float d = 0.0000001f;
        private long e;
        private long f;
        private float g = 0.999f;
        public b() {
            super();
            int i = 1064849900;
            int i2 = 1065604874;
            int i3 = 1000;
            int i4 = 869711765;
            this.e = w0.d(20);
            this.f = w0.d(500);
            int i7 = 1065336439;
        }

        public com.google.android.exoplayer2.z0 a() {
            super(this.a, this.b, this.c, obj4, this.d, this.e, obj7, this.f, obj9, this.g, 0);
            return z0Var2;
        }
    }
    private z0(float f, float f2, long l3, float f4, long l5, long l6, float f7) {
        super();
        this.a = f;
        this.b = f2;
        this.c = l3;
        this.d = l5;
        this.e = l6;
        this.f = obj8;
        this.g = obj10;
        final long obj3 = -9223372036854775807L;
        this.h = obj3;
        this.i = obj3;
        this.k = obj3;
        this.l = obj3;
        this.o = f;
        this.n = f2;
        this.p = 1065353216;
        this.q = obj3;
        this.j = obj3;
        this.m = obj3;
        this.r = obj3;
        this.s = obj3;
    }

    z0(float f, float f2, long l3, float f4, long l5, long l6, float f7, com.google.android.exoplayer2.z0.a z0$a8) {
        super(f, f2, l3, f4, l5, l6, f7, a8, obj9, obj10);
    }

    private void f(long l) {
        int i2;
        int i;
        int cmp;
        int i3;
        long l2;
        long obj11;
        int obj12;
        final int i10 = l3 + i8;
        i = 1065353216;
        if (Long.compare(l4, i10) > 0) {
            obj11 = (float)obj11;
            obj11 = new long[3];
            this.m = d.a(i10, this.j, l6 -= cmp);
        } else {
            obj11 = p0.q(l - l7, obj5, this.m);
            this.m = obj11;
            i2 = this.l;
            if (Long.compare(i2, l10) != 0 && Long.compare(obj11, i2) > 0) {
                if (Long.compare(obj11, i2) > 0) {
                    this.m = i2;
                }
            }
        }
    }

    private void g() {
        long l;
        int cmp3;
        int cmp2;
        int cmp;
        final long l2 = -9223372036854775807L;
        if (Long.compare(l, l2) != 0) {
            long l4 = this.i;
            if (Long.compare(l4, l2) != 0) {
                l = l4;
            }
            long l5 = this.k;
            if (Long.compare(l5, l2) != 0 && Long.compare(l, l5) < 0) {
                if (Long.compare(l, l5) < 0) {
                    l = l5;
                }
            }
            cmp3 = this.l;
            if (Long.compare(cmp3, l2) != 0 && Long.compare(l, cmp3) > 0) {
                if (Long.compare(l, cmp3) > 0) {
                    l = cmp3;
                }
            }
        } else {
            l = l2;
        }
        if (Long.compare(l3, l) == 0) {
        }
        this.j = l;
        this.m = l;
        this.r = l2;
        this.s = l2;
        this.q = l2;
    }

    private static long h(long l, long l2, float f3) {
        return (long)obj0;
    }

    private void i(long l, long l2) {
        int cmp;
        int obj3;
        long obj5;
        l -= obj5;
        obj5 = this.r;
        if (Long.compare(obj5, l3) == 0) {
            this.r = obj3;
            this.s = 0;
        } else {
            obj5 = Math.max(obj3, l2);
            this.r = obj5;
            this.s = z0.h(this.s, obj6, Math.abs(obj3 -= obj5));
        }
    }

    @Override // com.google.android.exoplayer2.k1
    public void a(com.google.android.exoplayer2.m1.f m1$f) {
        float f2;
        float obj4;
        this.h = w0.d(f.a);
        this.k = w0.d(f.b);
        this.l = w0.d(f.c);
        final int i = -8388609;
        if (Float.compare(f2, i) != 0) {
        } else {
            f2 = this.a;
        }
        this.o = f2;
        if (Float.compare(obj4, i) != 0) {
        } else {
            obj4 = this.b;
        }
        this.n = obj4;
        g();
    }

    @Override // com.google.android.exoplayer2.k1
    public float b(long l, long l2) {
        long l3;
        float obj5;
        float obj6;
        int obj7;
        l3 = -9223372036854775807L;
        final int i = 1065353216;
        if (Long.compare(l4, l3) == 0) {
            return i;
        }
        i(l, l2);
        if (Long.compare(obj7, l3) != 0 && Long.compare(obj7, l3) < 0) {
            if (Long.compare(obj7, l3) < 0) {
                return this.p;
            }
        }
        this.q = SystemClock.elapsedRealtime();
        f(l);
        l -= obj7;
        if (Long.compare(obj7, l6) < 0) {
            this.p = i;
        } else {
            this.p = p0.o(obj7 += i, this.o, this.n);
        }
        return this.p;
    }

    @Override // com.google.android.exoplayer2.k1
    public long c() {
        return this.m;
    }

    @Override // com.google.android.exoplayer2.k1
    public void d() {
        int cmp;
        long l = this.m;
        final long l2 = -9223372036854775807L;
        if (Long.compare(l, l2) == 0) {
        }
        l += l3;
        this.m = cmp;
        long l4 = this.l;
        if (Long.compare(l4, l2) != 0 && Long.compare(cmp, l4) > 0) {
            if (Long.compare(cmp, l4) > 0) {
                this.m = l4;
            }
        }
        this.q = l2;
    }

    @Override // com.google.android.exoplayer2.k1
    public void e(long l) {
        this.i = l;
        g();
    }
}
