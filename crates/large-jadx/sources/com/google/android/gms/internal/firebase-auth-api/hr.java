package com.google.android.gms.internal.firebase-auth-api;

import java.util.List;

/* loaded from: classes2.dex */
final class hr {

    private final com.google.android.gms.internal.firebase-auth-api.gr a;
    private hr(com.google.android.gms.internal.firebase-auth-api.gr gr) {
        super();
        e.f(gr, "output");
        this.a = gr;
        gr.a = this;
    }

    public static com.google.android.gms.internal.firebase-auth-api.hr l(com.google.android.gms.internal.firebase-auth-api.gr gr) {
        com.google.android.gms.internal.firebase-auth-api.hr hrVar = gr.a;
        if (hrVar != null) {
            return hrVar;
        }
        hr hrVar2 = new hr(gr);
        return hrVar2;
    }

    public final void A(int i, List<Float> list2, boolean z3) {
        int i3;
        int floatToRawIntBits;
        int i2;
        int obj3;
        com.google.android.gms.internal.firebase-auth-api.gr obj5;
        if (z3 != null) {
            this.a.z(i, 2);
            obj5 = obj3;
            while (obj3 < list2.size()) {
                (Float)list2.get(obj3).floatValue();
                obj5 += 4;
                obj3++;
            }
            this.a.B(obj5);
            while (i3 < list2.size()) {
                this.a.s(Float.floatToRawIntBits((Float)list2.get(i3).floatValue()));
                i3++;
            }
        }
    }

    public final void B(int i, Object object2, com.google.android.gms.internal.firebase-auth-api.l0 l03) {
        final com.google.android.gms.internal.firebase-auth-api.gr grVar = this.a;
        grVar.z(i, 3);
        l03.f((y)object2, grVar.a);
        grVar.z(i, 4);
    }

    public final void C(int i, int i2) {
        this.a.v(i, i2);
    }

    public final void D(int i, List<Integer> list2, boolean z3) {
        int i2;
        int intValue;
        int i3;
        int obj3;
        com.google.android.gms.internal.firebase-auth-api.gr obj5;
        if (z3 != null) {
            this.a.z(i, 2);
            obj5 = obj3;
            while (obj3 < list2.size()) {
                obj5 += i3;
                obj3++;
            }
            this.a.B(obj5);
            while (i2 < list2.size()) {
                this.a.w((Integer)list2.get(i2).intValue());
                i2++;
            }
        }
    }

    public final void E(int i, long l2) {
        this.a.C(i, l2);
    }

    public final void F(int i, List<Long> list2, boolean z3) {
        int i2;
        long longValue;
        int i3;
        int obj4;
        com.google.android.gms.internal.firebase-auth-api.gr obj6;
        if (z3 != null) {
            this.a.z(i, 2);
            obj6 = obj4;
            while (obj4 < list2.size()) {
                obj6 += i3;
                obj4++;
            }
            this.a.B(obj6);
            while (i2 < list2.size()) {
                this.a.D((Long)list2.get(i2).longValue());
                i2++;
            }
        }
    }

    public final void G(int i, Object object2, com.google.android.gms.internal.firebase-auth-api.l0 l03) {
        this.a.x(i, (y)object2, l03);
    }

    public final void H(int i, int i2) {
        this.a.r(i, i2);
    }

    public final void I(int i, List<Integer> list2, boolean z3) {
        int i3;
        int intValue;
        int i2;
        int obj3;
        com.google.android.gms.internal.firebase-auth-api.gr obj5;
        if (z3 != null) {
            this.a.z(i, 2);
            obj5 = obj3;
            while (obj3 < list2.size()) {
                (Integer)list2.get(obj3).intValue();
                obj5 += 4;
                obj3++;
            }
            this.a.B(obj5);
            while (i3 < list2.size()) {
                this.a.s((Integer)list2.get(i3).intValue());
                i3++;
            }
        }
    }

    public final void J(int i, long l2) {
        this.a.t(i, l2);
    }

    public final void K(int i, List<Long> list2, boolean z3) {
        int i3;
        long longValue;
        int i2;
        int obj4;
        com.google.android.gms.internal.firebase-auth-api.gr obj6;
        if (z3 != null) {
            this.a.z(i, 2);
            obj6 = obj4;
            while (obj4 < list2.size()) {
                (Long)list2.get(obj4).longValue();
                obj6 += 8;
                obj4++;
            }
            this.a.B(obj6);
            while (i3 < list2.size()) {
                this.a.u((Long)list2.get(i3).longValue());
                i3++;
            }
        }
    }

    public final void a(int i, int i2) {
        this.a.A(i, obj4 ^= i3);
    }

    public final void b(int i, List<Integer> list2, boolean z3) {
        int i4;
        int size;
        int i3;
        int i2;
        int obj4;
        com.google.android.gms.internal.firebase-auth-api.gr obj6;
        if (z3 != null) {
            this.a.z(i, 2);
            obj6 = obj4;
            while (obj4 < list2.size()) {
                int intValue2 = (Integer)list2.get(obj4).intValue();
                obj6 += i3;
                obj4++;
            }
            this.a.B(obj6);
            while (i4 < list2.size()) {
                obj6 = (Integer)list2.get(i4).intValue();
                this.a.B(obj6 ^= size);
                i4++;
            }
        }
    }

    public final void c(int i, long l2) {
        this.a.C(i, obj6 ^= i2);
    }

    public final void d(int i, List<Long> list2, boolean z3) {
        int i2;
        int size;
        int i3;
        int i4;
        int obj7;
        com.google.android.gms.internal.firebase-auth-api.gr obj9;
        final int i5 = 63;
        if (z3 != null) {
            this.a.z(i, 2);
            obj9 = obj7;
            while (obj7 < list2.size()) {
                long longValue2 = (Long)list2.get(obj7).longValue();
                obj9 += i3;
                obj7++;
            }
            this.a.B(obj9);
            while (i2 < list2.size()) {
                long longValue3 = (Long)list2.get(i2).longValue();
                this.a.D(i9 ^= i4);
                i2++;
            }
        }
    }

    public final void e(int i) {
        this.a.z(i, 3);
    }

    public final void f(int i, String string2) {
        this.a.y(i, string2);
    }

    public final void g(int i, List<String> list2) {
        boolean z;
        int size2;
        int i2;
        Object size;
        com.google.android.gms.internal.firebase-auth-api.gr grVar;
        i2 = 0;
        if (list2 instanceof i) {
            while (i2 < list2.size()) {
                size = (i)list2.j(i2);
                if (size instanceof String != null) {
                } else {
                }
                this.a.p(i, (wq)size);
                i2++;
                this.a.y(i, (String)size);
            }
        }
    }

    public final void h(int i, int i2) {
        this.a.A(i, i2);
    }

    public final void i(int i, List<Integer> list2, boolean z3) {
        int i3;
        int intValue;
        int i2;
        int obj3;
        com.google.android.gms.internal.firebase-auth-api.gr obj5;
        if (z3 != null) {
            this.a.z(i, 2);
            obj5 = obj3;
            while (obj3 < list2.size()) {
                obj5 += i2;
                obj3++;
            }
            this.a.B(obj5);
            while (i3 < list2.size()) {
                this.a.B((Integer)list2.get(i3).intValue());
                i3++;
            }
        }
    }

    public final void j(int i, long l2) {
        this.a.C(i, l2);
    }

    public final void k(int i, List<Long> list2, boolean z3) {
        int i2;
        long longValue;
        int i3;
        int obj4;
        com.google.android.gms.internal.firebase-auth-api.gr obj6;
        if (z3 != null) {
            this.a.z(i, 2);
            obj6 = obj4;
            while (obj4 < list2.size()) {
                obj6 += i3;
                obj4++;
            }
            this.a.B(obj6);
            while (i2 < list2.size()) {
                this.a.D((Long)list2.get(i2).longValue());
                i2++;
            }
        }
    }

    public final void m(int i, boolean z2) {
        this.a.o(i, z2);
    }

    public final void n(int i, List<Boolean> list2, boolean z3) {
        int i3;
        boolean booleanValue;
        int i2;
        int obj3;
        com.google.android.gms.internal.firebase-auth-api.gr obj5;
        if (z3 != null) {
            this.a.z(i, 2);
            obj5 = obj3;
            while (obj3 < list2.size()) {
                (Boolean)list2.get(obj3).booleanValue();
                obj5++;
                obj3++;
            }
            this.a.B(obj5);
            while (i3 < list2.size()) {
                this.a.n((Boolean)list2.get(i3).booleanValue());
                i3++;
            }
        }
    }

    public final void o(int i, com.google.android.gms.internal.firebase-auth-api.wq wq2) {
        this.a.p(i, wq2);
    }

    public final void p(int i, List<com.google.android.gms.internal.firebase-auth-api.wq> list2) {
        int i2;
        com.google.android.gms.internal.firebase-auth-api.gr grVar;
        Object obj;
        i2 = 0;
        while (i2 < list2.size()) {
            this.a.p(i, (wq)list2.get(i2));
            i2++;
        }
    }

    public final void q(int i, double d2) {
        this.a.t(i, Double.doubleToRawLongBits(d2));
    }

    public final void r(int i, List<Double> list2, boolean z3) {
        int i2;
        long doubleToRawLongBits;
        int i3;
        int obj4;
        com.google.android.gms.internal.firebase-auth-api.gr obj6;
        if (z3 != null) {
            this.a.z(i, 2);
            obj6 = obj4;
            while (obj4 < list2.size()) {
                (Double)list2.get(obj4).doubleValue();
                obj6 += 8;
                obj4++;
            }
            this.a.B(obj6);
            while (i2 < list2.size()) {
                this.a.u(Double.doubleToRawLongBits((Double)list2.get(i2).doubleValue()));
                i2++;
            }
        }
    }

    public final void s(int i) {
        this.a.z(i, 4);
    }

    public final void t(int i, int i2) {
        this.a.v(i, i2);
    }

    public final void u(int i, List<Integer> list2, boolean z3) {
        int i2;
        int intValue;
        int i3;
        int obj3;
        com.google.android.gms.internal.firebase-auth-api.gr obj5;
        if (z3 != null) {
            this.a.z(i, 2);
            obj5 = obj3;
            while (obj3 < list2.size()) {
                obj5 += i3;
                obj3++;
            }
            this.a.B(obj5);
            while (i2 < list2.size()) {
                this.a.w((Integer)list2.get(i2).intValue());
                i2++;
            }
        }
    }

    public final void v(int i, int i2) {
        this.a.r(i, i2);
    }

    public final void w(int i, List<Integer> list2, boolean z3) {
        int i3;
        int intValue;
        int i2;
        int obj3;
        com.google.android.gms.internal.firebase-auth-api.gr obj5;
        if (z3 != null) {
            this.a.z(i, 2);
            obj5 = obj3;
            while (obj3 < list2.size()) {
                (Integer)list2.get(obj3).intValue();
                obj5 += 4;
                obj3++;
            }
            this.a.B(obj5);
            while (i3 < list2.size()) {
                this.a.s((Integer)list2.get(i3).intValue());
                i3++;
            }
        }
    }

    public final void x(int i, long l2) {
        this.a.t(i, l2);
    }

    public final void y(int i, List<Long> list2, boolean z3) {
        int i2;
        long longValue;
        int i3;
        int obj4;
        com.google.android.gms.internal.firebase-auth-api.gr obj6;
        if (z3 != null) {
            this.a.z(i, 2);
            obj6 = obj4;
            while (obj4 < list2.size()) {
                (Long)list2.get(obj4).longValue();
                obj6 += 8;
                obj4++;
            }
            this.a.B(obj6);
            while (i2 < list2.size()) {
                this.a.u((Long)list2.get(i2).longValue());
                i2++;
            }
        }
    }

    public final void z(int i, float f2) {
        this.a.r(i, Float.floatToRawIntBits(f2));
    }
}
