package com.google.android.gms.internal.measurement;

import java.util.List;

/* loaded from: classes2.dex */
final class f8 {

    private final com.google.android.gms.internal.measurement.e8 a;
    private f8(com.google.android.gms.internal.measurement.e8 e8) {
        super();
        d9.f(e8, "output");
        this.a = e8;
        e8.a = this;
    }

    public static com.google.android.gms.internal.measurement.f8 l(com.google.android.gms.internal.measurement.e8 e8) {
        com.google.android.gms.internal.measurement.f8 f8Var = e8.a;
        if (f8Var != null) {
            return f8Var;
        }
        f8 f8Var2 = new f8(e8);
        return f8Var2;
    }

    public final void A(int i, List<Float> list2, boolean z3) {
        int i2;
        int floatToRawIntBits;
        int i3;
        int obj3;
        com.google.android.gms.internal.measurement.e8 obj5;
        if (z3 != null) {
            this.a.s(i, 2);
            obj5 = obj3;
            while (obj3 < list2.size()) {
                (Float)list2.get(obj3).floatValue();
                obj5 += 4;
                obj3++;
            }
            this.a.u(obj5);
            while (i2 < list2.size()) {
                this.a.l(Float.floatToRawIntBits((Float)list2.get(i2).floatValue()));
                i2++;
            }
        }
    }

    public final void B(int i, Object object2, com.google.android.gms.internal.measurement.ja ja3) {
        final com.google.android.gms.internal.measurement.e8 e8Var = this.a;
        e8Var.s(i, 3);
        ja3.i((y9)object2, e8Var.a);
        e8Var.s(i, 4);
    }

    public final void C(int i, int i2) {
        this.a.o(i, i2);
    }

    public final void D(int i, List<Integer> list2, boolean z3) {
        int i3;
        int intValue;
        int i2;
        int obj3;
        com.google.android.gms.internal.measurement.e8 obj5;
        if (z3 != null) {
            this.a.s(i, 2);
            obj5 = obj3;
            while (obj3 < list2.size()) {
                obj5 += i2;
                obj3++;
            }
            this.a.u(obj5);
            while (i3 < list2.size()) {
                this.a.p((Integer)list2.get(i3).intValue());
                i3++;
            }
        }
    }

    public final void E(int i, long l2) {
        this.a.v(i, l2);
    }

    public final void F(int i, List<Long> list2, boolean z3) {
        int i3;
        long longValue;
        int i2;
        int obj4;
        com.google.android.gms.internal.measurement.e8 obj6;
        if (z3 != null) {
            this.a.s(i, 2);
            obj6 = obj4;
            while (obj4 < list2.size()) {
                obj6 += i2;
                obj4++;
            }
            this.a.u(obj6);
            while (i3 < list2.size()) {
                this.a.w((Long)list2.get(i3).longValue());
                i3++;
            }
        }
    }

    public final void G(int i, Object object2, com.google.android.gms.internal.measurement.ja ja3) {
        int i2;
        final com.google.android.gms.internal.measurement.e8 e8Var = this.a;
        (d8)e8Var.u(obj4 |= 2);
        Object obj4 = object2;
        if ((k7)obj4.g() == -1) {
            obj4.i(ja3.d(obj4));
        }
        e8Var.u(i2);
        ja3.i((y9)object2, e8Var.a);
    }

    public final void H(int i, int i2) {
        this.a.k(i, i2);
    }

    public final void I(int i, List<Integer> list2, boolean z3) {
        int i3;
        int intValue;
        int i2;
        int obj3;
        com.google.android.gms.internal.measurement.e8 obj5;
        if (z3 != null) {
            this.a.s(i, 2);
            obj5 = obj3;
            while (obj3 < list2.size()) {
                (Integer)list2.get(obj3).intValue();
                obj5 += 4;
                obj3++;
            }
            this.a.u(obj5);
            while (i3 < list2.size()) {
                this.a.l((Integer)list2.get(i3).intValue());
                i3++;
            }
        }
    }

    public final void J(int i, long l2) {
        this.a.m(i, l2);
    }

    public final void K(int i, List<Long> list2, boolean z3) {
        int i3;
        long longValue;
        int i2;
        int obj4;
        com.google.android.gms.internal.measurement.e8 obj6;
        if (z3 != null) {
            this.a.s(i, 2);
            obj6 = obj4;
            while (obj4 < list2.size()) {
                (Long)list2.get(obj4).longValue();
                obj6 += 8;
                obj4++;
            }
            this.a.u(obj6);
            while (i3 < list2.size()) {
                this.a.n((Long)list2.get(i3).longValue());
                i3++;
            }
        }
    }

    public final void a(int i, int i2) {
        this.a.t(i, obj4 ^= i3);
    }

    public final void b(int i, List<Integer> list2, boolean z3) {
        int i2;
        int size;
        int i3;
        int i4;
        int obj4;
        com.google.android.gms.internal.measurement.e8 obj6;
        if (z3 != null) {
            this.a.s(i, 2);
            obj6 = obj4;
            while (obj4 < list2.size()) {
                int intValue2 = (Integer)list2.get(obj4).intValue();
                obj6 += i3;
                obj4++;
            }
            this.a.u(obj6);
            while (i2 < list2.size()) {
                obj6 = (Integer)list2.get(i2).intValue();
                this.a.u(obj6 ^= size);
                i2++;
            }
        }
    }

    public final void c(int i, long l2) {
        this.a.v(i, obj6 ^= i2);
    }

    public final void d(int i, List<Long> list2, boolean z3) {
        int i4;
        int size;
        int i2;
        int i3;
        int obj7;
        com.google.android.gms.internal.measurement.e8 obj9;
        final int i5 = 63;
        if (z3 != null) {
            this.a.s(i, 2);
            obj9 = obj7;
            while (obj7 < list2.size()) {
                long longValue2 = (Long)list2.get(obj7).longValue();
                obj9 += i2;
                obj7++;
            }
            this.a.u(obj9);
            while (i4 < list2.size()) {
                long longValue3 = (Long)list2.get(i4).longValue();
                this.a.w(i9 ^= i3);
                i4++;
            }
        }
    }

    @Deprecated
    public final void e(int i) {
        this.a.s(i, 3);
    }

    public final void f(int i, String string2) {
        this.a.r(i, string2);
    }

    public final void g(int i, List<String> list2) {
        boolean z;
        int size2;
        int i2;
        Object size;
        com.google.android.gms.internal.measurement.e8 e8Var;
        i2 = 0;
        if (list2 instanceof h9) {
            while (i2 < list2.size()) {
                size = (h9)list2.j(i2);
                if (size instanceof String != null) {
                } else {
                }
                this.a.j(i, (x7)size);
                i2++;
                this.a.r(i, (String)size);
            }
        }
    }

    public final void h(int i, int i2) {
        this.a.t(i, i2);
    }

    public final void i(int i, List<Integer> list2, boolean z3) {
        int i2;
        int intValue;
        int i3;
        int obj3;
        com.google.android.gms.internal.measurement.e8 obj5;
        if (z3 != null) {
            this.a.s(i, 2);
            obj5 = obj3;
            while (obj3 < list2.size()) {
                obj5 += i3;
                obj3++;
            }
            this.a.u(obj5);
            while (i2 < list2.size()) {
                this.a.u((Integer)list2.get(i2).intValue());
                i2++;
            }
        }
    }

    public final void j(int i, long l2) {
        this.a.v(i, l2);
    }

    public final void k(int i, List<Long> list2, boolean z3) {
        int i2;
        long longValue;
        int i3;
        int obj4;
        com.google.android.gms.internal.measurement.e8 obj6;
        if (z3 != null) {
            this.a.s(i, 2);
            obj6 = obj4;
            while (obj4 < list2.size()) {
                obj6 += i3;
                obj4++;
            }
            this.a.u(obj6);
            while (i2 < list2.size()) {
                this.a.w((Long)list2.get(i2).longValue());
                i2++;
            }
        }
    }

    public final void m(int i, boolean z2) {
        this.a.i(i, z2);
    }

    public final void n(int i, List<Boolean> list2, boolean z3) {
        int i3;
        boolean booleanValue;
        int i2;
        int obj3;
        com.google.android.gms.internal.measurement.e8 obj5;
        if (z3 != null) {
            this.a.s(i, 2);
            obj5 = obj3;
            while (obj3 < list2.size()) {
                (Boolean)list2.get(obj3).booleanValue();
                obj5++;
                obj3++;
            }
            this.a.u(obj5);
            while (i3 < list2.size()) {
                this.a.h((Boolean)list2.get(i3).booleanValue());
                i3++;
            }
        }
    }

    public final void o(int i, com.google.android.gms.internal.measurement.x7 x72) {
        this.a.j(i, x72);
    }

    public final void p(int i, List<com.google.android.gms.internal.measurement.x7> list2) {
        int i2;
        com.google.android.gms.internal.measurement.e8 e8Var;
        Object obj;
        i2 = 0;
        while (i2 < list2.size()) {
            this.a.j(i, (x7)list2.get(i2));
            i2++;
        }
    }

    public final void q(int i, double d2) {
        this.a.m(i, Double.doubleToRawLongBits(d2));
    }

    public final void r(int i, List<Double> list2, boolean z3) {
        int i3;
        long doubleToRawLongBits;
        int i2;
        int obj4;
        com.google.android.gms.internal.measurement.e8 obj6;
        if (z3 != null) {
            this.a.s(i, 2);
            obj6 = obj4;
            while (obj4 < list2.size()) {
                (Double)list2.get(obj4).doubleValue();
                obj6 += 8;
                obj4++;
            }
            this.a.u(obj6);
            while (i3 < list2.size()) {
                this.a.n(Double.doubleToRawLongBits((Double)list2.get(i3).doubleValue()));
                i3++;
            }
        }
    }

    @Deprecated
    public final void s(int i) {
        this.a.s(i, 4);
    }

    public final void t(int i, int i2) {
        this.a.o(i, i2);
    }

    public final void u(int i, List<Integer> list2, boolean z3) {
        int i2;
        int intValue;
        int i3;
        int obj3;
        com.google.android.gms.internal.measurement.e8 obj5;
        if (z3 != null) {
            this.a.s(i, 2);
            obj5 = obj3;
            while (obj3 < list2.size()) {
                obj5 += i3;
                obj3++;
            }
            this.a.u(obj5);
            while (i2 < list2.size()) {
                this.a.p((Integer)list2.get(i2).intValue());
                i2++;
            }
        }
    }

    public final void v(int i, int i2) {
        this.a.k(i, i2);
    }

    public final void w(int i, List<Integer> list2, boolean z3) {
        int i3;
        int intValue;
        int i2;
        int obj3;
        com.google.android.gms.internal.measurement.e8 obj5;
        if (z3 != null) {
            this.a.s(i, 2);
            obj5 = obj3;
            while (obj3 < list2.size()) {
                (Integer)list2.get(obj3).intValue();
                obj5 += 4;
                obj3++;
            }
            this.a.u(obj5);
            while (i3 < list2.size()) {
                this.a.l((Integer)list2.get(i3).intValue());
                i3++;
            }
        }
    }

    public final void x(int i, long l2) {
        this.a.m(i, l2);
    }

    public final void y(int i, List<Long> list2, boolean z3) {
        int i2;
        long longValue;
        int i3;
        int obj4;
        com.google.android.gms.internal.measurement.e8 obj6;
        if (z3 != null) {
            this.a.s(i, 2);
            obj6 = obj4;
            while (obj4 < list2.size()) {
                (Long)list2.get(obj4).longValue();
                obj6 += 8;
                obj4++;
            }
            this.a.u(obj6);
            while (i2 < list2.size()) {
                this.a.n((Long)list2.get(i2).longValue());
                i2++;
            }
        }
    }

    public final void z(int i, float f2) {
        this.a.k(i, Float.floatToRawIntBits(f2));
    }
}
