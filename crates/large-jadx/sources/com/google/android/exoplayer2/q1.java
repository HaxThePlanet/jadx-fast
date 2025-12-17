package com.google.android.exoplayer2;

import android.os.Handler;
import com.google.android.exoplayer2.j2.h1;
import com.google.android.exoplayer2.n2.n;
import com.google.android.exoplayer2.n2.o;
import com.google.android.exoplayer2.source.w;
import com.google.android.exoplayer2.source.x;
import com.google.android.exoplayer2.source.y.a;
import com.google.android.exoplayer2.upstream.f;
import com.google.android.exoplayer2.util.g;
import com.google.common.collect.v;
import com.google.common.collect.v.a;

/* loaded from: classes.dex */
final class q1 {

    private final com.google.android.exoplayer2.g2.b a;
    private final com.google.android.exoplayer2.g2.c b;
    private final h1 c;
    private final Handler d;
    private long e;
    private int f;
    private boolean g;
    private com.google.android.exoplayer2.o1 h;
    private com.google.android.exoplayer2.o1 i;
    private com.google.android.exoplayer2.o1 j;
    private int k;
    private Object l;
    private long m;
    public q1(h1 h1, Handler handler2) {
        super();
        this.c = h1;
        this.d = handler2;
        g2.b obj1 = new g2.b();
        this.a = obj1;
        obj1 = new g2.c();
        this.b = obj1;
    }

    private static y.a B(com.google.android.exoplayer2.g2 g2, Object object2, long l3, long l4, com.google.android.exoplayer2.g2.b g2$b5) {
        g2.h(object2, obj12);
        final int i = obj12.e(l3);
        if (i == -1) {
            y.a obj8 = new y.a(object2, b5, obj11, obj12.d(l3));
            return obj8;
        }
        super(object2, i, obj12.j(i), b5, obj5);
        return obj6;
    }

    private long C(com.google.android.exoplayer2.g2 g2, Object object2) {
        Object obj;
        com.google.android.exoplayer2.o1 o1Var2;
        com.google.android.exoplayer2.o1 o1Var;
        com.google.android.exoplayer2.g2.b equals;
        com.google.android.exoplayer2.g2.b bVar;
        int i = bVar3.c;
        obj = this.l;
        int i2 = -1;
        obj = g2.b(obj);
        if (obj != null && obj != i2 && bVar4.c == i) {
            obj = g2.b(obj);
            if (obj != i2) {
                if (bVar4.c == i) {
                    return this.m;
                }
            }
        }
        o1Var2 = this.h;
        while (o1Var2 != null) {
            o1Var2 = o1Var2.j();
        }
        o1Var = this.h;
        while (o1Var != null) {
            equals = g2.b(o1Var.b);
            o1Var = o1Var.j();
        }
        long l = this.e;
        this.e = i3 += l;
        if (this.h == null) {
            this.l = object2;
            this.m = l;
        }
        return l;
    }

    private boolean E(com.google.android.exoplayer2.g2 g2) {
        com.google.android.exoplayer2.o1 o1Var;
        int i4;
        com.google.android.exoplayer2.g2 g2Var;
        int i;
        int i3;
        com.google.android.exoplayer2.g2.c cVar;
        int i2;
        boolean z;
        o1Var = this.h;
        if (o1Var == null) {
            return 1;
        }
        i = i4;
        while (/* condition */) {
            while (o1Var.j() != null) {
                if (!p1Var.g) {
                }
                o1Var = o1Var.j();
            }
            i4 = o1Var.j();
            if (i != -1) {
                break;
            }
            if (g2.b(i4.b) != i) {
                break;
            } else {
            }
            o1Var = i4;
            i = g2.d(i, this.a, this.b, this.f, this.g);
            if (!p1Var.g) {
            }
            o1Var = o1Var.j();
        }
        o1Var.f = q(g2, o1Var.f);
        return z2 ^ 1;
    }

    private boolean c(long l, long l2) {
        int obj3;
        if (Long.compare(l, l3) != 0) {
            if (Long.compare(l, obj5) == 0) {
                obj3 = 1;
            } else {
                obj3 = 0;
            }
        } else {
        }
        return obj3;
    }

    private boolean d(com.google.android.exoplayer2.p1 p1, com.google.android.exoplayer2.p1 p12) {
        Object obj5;
        Object obj6;
        if (Long.compare(l, l2) == 0 && p1.a.equals(p12.a)) {
            obj5 = p1.a.equals(p12.a) ? 1 : 0;
        } else {
        }
        return obj5;
    }

    private com.google.android.exoplayer2.p1 g(com.google.android.exoplayer2.t1 t1) {
        return this.j(t1.a, t1.b, t1.c, obj4);
    }

    private com.google.android.exoplayer2.p1 h(com.google.android.exoplayer2.g2 g2, com.google.android.exoplayer2.o1 o12, long l3) {
        int i6;
        long longValue;
        Object first;
        Object bVar;
        int longValue2;
        int cmp;
        int i5;
        long l;
        long equals;
        int i;
        int i4;
        int i2;
        int i3;
        final Object obj16 = this;
        final com.google.android.exoplayer2.g2 g2Var10 = g2;
        com.google.android.exoplayer2.p1 p1Var7 = obj17.f;
        i4 = i7 - l3;
        final int i27 = -1;
        final int i28 = 0;
        boolean z3 = obj16.g;
        i3 = 0;
        i6 = g2.d(g2Var10.b(aVar.a), obj16.a, obj16.b, obj16.f, z3);
        if (p1Var7.g && i6 == i27) {
            z3 = obj16.g;
            i3 = 0;
            i6 = g2.d(g2Var10.b(aVar.a), obj16.a, obj16.b, obj16.f, z3);
            if (i6 == i27) {
                return i28;
            }
            int i18 = bVar6.c;
            first = bVar7.b;
            l = aVar2.d;
            if (cVar3.o == i6) {
                android.util.Pair pair = g2.k(obj16.b, obj16.a, i18, -9223372036854775807L, z3);
                if (pair == null) {
                    return i28;
                }
                i6 = o12.j();
                if (i6 != null && i6.b.equals(pair.first)) {
                    if (i6.b.equals(first)) {
                        l = i6.d;
                    } else {
                        obj16.e = i25 += l;
                    }
                } else {
                }
                i2 = longValue2;
                i3 = -9223372036854775807L;
            } else {
                i2 = i3;
            }
            com.google.android.exoplayer2.g2.b bVar11 = obj16.a;
            return this.j(g2, q1.B(g2, first, i2, i18, l), i3, l);
        }
        y.a aVar4 = p1Var7.a;
        g2Var10.h(aVar4.a, obj16.a);
        i5 = aVar4.b;
        int i9 = obj16.a.a(i5);
        if (aVar4.b() && i9 == i27) {
            i5 = aVar4.b;
            i9 = obj16.a.a(i5);
            if (i9 == i27) {
                return i28;
            }
            i = obj16.a.k(i5, aVar4.c);
            if (i < i9) {
                return this.k(g2, aVar4.a, i5, i, p1Var7.c, i4);
            }
            cmp = obj16.a;
            android.util.Pair pair2 = g2.k(obj16.b, cmp, cmp.c, -9223372036854775807L, obj5);
            if (Long.compare(longValue, l5) == 0 && pair2 == null) {
                cmp = obj16.a;
                pair2 = g2.k(obj16.b, cmp, cmp.c, -9223372036854775807L, obj5);
                if (pair2 == null) {
                    return i28;
                }
                longValue = (Long)pair2.second.longValue();
            }
            int i20 = aVar4.b;
            Object obj15 = aVar4.a;
            return this.l(g2, obj15, Math.max(obj16.m(g2Var10, aVar4.a, i20), i20), obj15, p1Var7.c);
        }
        int i23 = obj16.a.j(aVar4.e);
        if (i23 == obj16.a.a(aVar4.e)) {
            return this.l(g2, aVar4.a, obj16.m(g2Var10, aVar4.a, aVar4.e), i23, p1Var7.e);
        }
        return this.k(g2, aVar4.a, aVar4.e, i23, p1Var7.e, i4);
    }

    private com.google.android.exoplayer2.p1 j(com.google.android.exoplayer2.g2 g2, y.a y$a2, long l3, long l4) {
        Object obj = a2;
        com.google.android.exoplayer2.g2 g2Var = g2;
        g2.h(obj.a, obj7.a);
        if (a2.b()) {
            return this.k(g2, obj.a, obj.b, obj.c, l3, obj8);
        }
        return this.l(g2, obj.a, obj17, obj6, l3);
    }

    private com.google.android.exoplayer2.p1 k(com.google.android.exoplayer2.g2 g2, Object object2, int i3, int i4, long l5, long l6) {
        int i;
        int cmp;
        int i5;
        int i2;
        final Object obj = this;
        int i11 = i4;
        long l = obj25;
        super(object2, i3, i11, l, obj6);
        int i10 = aVar3.c;
        final long l4 = g2.h(aVar3.a, obj.a).b(aVar3.b, i10);
        int i8 = 0;
        if (i11 == obj.a.j(i3)) {
            i2 = obj.a.g();
        } else {
            i2 = i8;
        }
        final int i13 = aVar3.b;
        if (Long.compare(l4, l7) != 0 && Long.compare(i2, l4) >= 0) {
            if (Long.compare(i2, l4) >= 0) {
                i5 = cmp;
            } else {
                i5 = i2;
            }
        } else {
        }
        super(aVar3, i5, i2, l5, i13, -9223372036854775807L, obj8, l4, obj10, obj.a.p(i13), 0, 0, 0);
        return p1Var2;
    }

    private com.google.android.exoplayer2.p1 l(com.google.android.exoplayer2.g2 g2, Object object2, long l3, long l4, long l5) {
        int i;
        int cmp;
        int cmp2;
        long l;
        int i3;
        boolean z;
        int i2;
        long l2;
        long l6;
        final Object obj = this;
        com.google.android.exoplayer2.g2 g2Var = g2;
        Object obj2 = object2;
        l = l3;
        g2Var.h(obj2, obj.a);
        i3 = obj.a.d(l);
        y.a aVar = new y.a(obj2, obj27, obj9, i3);
        boolean z2 = obj.r(aVar);
        i = -1;
        if (i3 != i && obj.a.p(i3)) {
            i2 = obj.a.p(i3) ? 1 : 0;
        } else {
        }
        long l8 = -9223372036854775807L;
        if (i3 != i) {
            l2 = i3;
        } else {
            l2 = l8;
        }
        if (Long.compare(l2, l8) != 0) {
            if (Long.compare(l2, i3) == 0) {
                l6 = i3;
            } else {
                l6 = l2;
            }
        } else {
        }
        if (Long.compare(l6, l8) != 0 && Long.compare(l, l6) >= 0) {
            if (Long.compare(l, l6) >= 0) {
                l = Math.max(0, obj4);
            }
        }
        super(aVar, l, obj9, l5, obj11, l2, obj13, l6, obj15, i2, z2, obj.t(g2Var, aVar), obj.s(g2Var, aVar, z2));
        return p1Var;
    }

    private long m(com.google.android.exoplayer2.g2 g2, Object object2, int i3) {
        g2.h(object2, this.a);
        long obj3 = this.a.f(i3);
        if (Long.compare(obj3, l) == 0) {
            return obj3.d;
        }
        return obj3 += l2;
    }

    private boolean r(y.a y$a) {
        boolean z;
        Object obj2;
        if (!a.b() && a.e == -1) {
            obj2 = a.e == -1 ? 1 : 0;
        } else {
        }
        return obj2;
    }

    private boolean s(com.google.android.exoplayer2.g2 g2, y.a y$a2, boolean z3) {
        com.google.android.exoplayer2.g2.c cVar;
        com.google.android.exoplayer2.g2.b bVar;
        com.google.android.exoplayer2.g2.c cVar2;
        int i;
        boolean z;
        int obj7;
        final int i2 = g2.b(a2.a);
        if (!obj8.i && g2.r(i2, this.a, this.b, this.f, this.g) && z3) {
            if (g2.r(i2, this.a, this.b, this.f, this.g)) {
                obj7 = z3 ? 1 : 0;
            } else {
            }
        } else {
        }
        return obj7;
    }

    private boolean t(com.google.android.exoplayer2.g2 g2, y.a y$a2) {
        int i;
        if (!r(a2)) {
            return 0;
        }
        if (obj4.p == g2.b(a2.a)) {
            i = 1;
        }
        return i;
    }

    private void v(v.a v$a, y.a y$a2) {
        this.c.I1(a.e(), a2);
    }

    private void x() {
        Object h1Var;
        com.google.android.exoplayer2.o1 o1Var;
        y.a aVar;
        Object obj;
        com.google.android.exoplayer2.g0 g0Var;
        if (this.c != null) {
            h1Var = v.s();
            o1Var = this.h;
            while (o1Var != null) {
                h1Var.d(p1Var2.a);
                o1Var = o1Var.j();
            }
            com.google.android.exoplayer2.o1 o1Var2 = this.i;
            aVar = o1Var2 == null ? 0 : p1Var.a;
            g0Var = new g0(this, h1Var, aVar);
            this.d.post(g0Var);
        }
    }

    public y.a A(com.google.android.exoplayer2.g2 g2, Object object2, long l3) {
        return q1.B(g2, object2, l3, obj3, C(g2, object2));
    }

    public boolean D() {
        com.google.android.exoplayer2.o1 cmp;
        int i;
        int i2;
        long l;
        cmp = this.j;
        if (cmp != null) {
            if (!p1Var2.i && cmp.q() && Long.compare(l2, l) != 0 && this.k < 100) {
                if (cmp.q()) {
                    if (Long.compare(l2, l) != 0) {
                        if (this.k < 100) {
                            i = 1;
                        } else {
                            i = 0;
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

    public boolean F(com.google.android.exoplayer2.g2 g2, long l2, long l3) {
        com.google.android.exoplayer2.o1 o1Var;
        int i;
        com.google.android.exoplayer2.p1 p1Var2;
        int i2;
        boolean z;
        long l;
        com.google.android.exoplayer2.p1 p1Var;
        long l4;
        com.google.android.exoplayer2.o1 o1Var2;
        long obj9;
        com.google.android.exoplayer2.o1 obj11;
        o1Var = this.h;
        i = 0;
        i2 = 1;
        while (o1Var != null) {
            com.google.android.exoplayer2.p1 p1Var3 = o1Var.f;
            p1Var = h(g2, i, l2);
            p1Var2 = p1Var;
            p1Var = p1Var2.a(p1Var3.c);
            o1Var.f = p1Var;
            i = o1Var;
            o1Var = o1Var2;
            i2 = 1;
            p1Var2 = q(g2, p1Var3);
        }
        return i2;
    }

    public boolean G(com.google.android.exoplayer2.g2 g2, int i2) {
        this.f = i2;
        return E(g2);
    }

    public boolean H(com.google.android.exoplayer2.g2 g2, boolean z2) {
        this.g = z2;
        return E(g2);
    }

    public com.google.android.exoplayer2.o1 a() {
        com.google.android.exoplayer2.o1 o1Var;
        int i2;
        int i;
        o1Var = this.h;
        i = 0;
        if (o1Var == null) {
            return i;
        }
        if (o1Var == this.i) {
            this.i = o1Var.j();
        }
        this.h.t();
        i3--;
        this.k = i2;
        if (i2 == 0) {
            this.j = i;
            com.google.android.exoplayer2.o1 o1Var3 = this.h;
            this.l = o1Var3.b;
            this.m = aVar.d;
        }
        this.h = this.h.j();
        x();
        return this.h;
    }

    public com.google.android.exoplayer2.o1 b() {
        com.google.android.exoplayer2.o1 o1Var;
        int i;
        o1Var = this.i;
        if (o1Var != null && o1Var.j() != null) {
            i = o1Var.j() != null ? 1 : 0;
        } else {
        }
        g.f(i);
        this.i = this.i.j();
        x();
        return this.i;
    }

    public void e() {
        com.google.android.exoplayer2.o1 o1Var;
        if (this.k == 0) {
        }
        o1Var = this.h;
        g.h(o1Var);
        this.l = o1Var.b;
        this.m = aVar.d;
        while (o1Var != null) {
            o1Var.t();
            o1Var = o1Var.j();
        }
        int i2 = 0;
        this.h = i2;
        this.j = i2;
        this.i = i2;
        this.k = 0;
        x();
    }

    public com.google.android.exoplayer2.o1 f(com.google.android.exoplayer2.a2[] a2Arr, n n2, f f3, com.google.android.exoplayer2.s1 s14, com.google.android.exoplayer2.p1 p15, o o6) {
        int i;
        long cmp;
        final Object obj = this;
        Object obj2 = p15;
        com.google.android.exoplayer2.o1 o1Var = obj.j;
        if (o1Var == null) {
            if (obj2.a.b() && Long.compare(i, l3) != 0) {
                if (Long.compare(i, l3) != 0) {
                } else {
                    i = 0;
                }
            } else {
            }
        } else {
            i5 -= cmp;
        }
        super(a2Arr, i, obj4, n2, f3, s14, p15, o6);
        com.google.android.exoplayer2.o1 o1Var3 = obj.j;
        if (o1Var3 != null) {
            o1Var3.w(o1Var5);
        } else {
            obj.h = o1Var5;
            obj.i = o1Var5;
        }
        obj.l = 0;
        obj.j = o1Var5;
        obj.k = i3++;
        x();
        return o1Var5;
    }

    public com.google.android.exoplayer2.o1 i() {
        return this.j;
    }

    public com.google.android.exoplayer2.p1 n(long l, com.google.android.exoplayer2.t1 t12) {
        com.google.android.exoplayer2.p1 obj2;
        Object obj4;
        final com.google.android.exoplayer2.o1 o1Var = this.j;
        if (o1Var == null) {
            obj2 = g(obj4);
        } else {
            obj2 = h(obj4.a, o1Var, l);
        }
        return obj2;
    }

    public com.google.android.exoplayer2.o1 o() {
        return this.h;
    }

    public com.google.android.exoplayer2.o1 p() {
        return this.i;
    }

    public com.google.android.exoplayer2.p1 q(com.google.android.exoplayer2.g2 g2, com.google.android.exoplayer2.p1 p12) {
        boolean z;
        com.google.android.exoplayer2.g2.b cmp;
        boolean z2;
        int i;
        int i2;
        long l;
        int i3;
        long l2;
        long l3;
        final Object obj = this;
        com.google.android.exoplayer2.g2 g2Var = g2;
        Object obj2 = p12;
        y.a aVar2 = obj2.a;
        final boolean z6 = obj.r(aVar2);
        g2Var.h(aVar3.a, obj.a);
        i2 = -1;
        l = -9223372036854775807L;
        if (!aVar2.b()) {
            z = aVar2.e;
            if (z == i2) {
                l2 = l;
            } else {
                l2 = obj.a.f(z);
            }
        } else {
        }
        if (aVar2.b()) {
            l = obj.a.b(aVar2.b, aVar2.c);
            l3 = l;
        } else {
        }
        if (aVar2.b()) {
            z2 = obj.a.p(aVar2.b);
        } else {
            i = aVar2.e;
            if (i != i2 && obj.a.p(i)) {
                z2 = obj.a.p(i) ? 1 : 0;
            } else {
            }
        }
        long l6 = obj2.b;
        super(aVar2, l6, l6, obj2.c, i3, l2, obj8, l3, obj10, z2, z6, obj.t(g2Var, aVar2), obj.s(g2Var, aVar2, z6));
        return p1Var2;
    }

    public boolean u(w w) {
        Object o1Var;
        int obj2;
        o1Var = this.j;
        if (o1Var != null && o1Var.a == w) {
            obj2 = o1Var.a == w ? 1 : 0;
        } else {
        }
        return obj2;
    }

    public void w(v.a v$a, y.a y$a2) {
        v(a, a2);
    }

    public void y(long l) {
        final com.google.android.exoplayer2.o1 o1Var = this.j;
        if (o1Var != null) {
            o1Var.s(l);
        }
    }

    public boolean z(com.google.android.exoplayer2.o1 o1) {
        int i;
        int i2;
        boolean equals;
        com.google.android.exoplayer2.o1 obj4;
        int i3 = 1;
        i = 0;
        i2 = o1 != null ? i3 : i;
        g.f(i2);
        if (o1.equals(this.j)) {
            return i;
        }
        this.j = o1;
        while (obj4.j() != null) {
            obj4 = obj4.j();
            if (obj4 == this.i) {
            }
            obj4.t();
            this.k = i5 -= i3;
            this.i = this.h;
            i = i3;
        }
        this.j.w(0);
        x();
        return i;
    }
}
