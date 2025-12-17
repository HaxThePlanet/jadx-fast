package com.google.android.exoplayer2.l2.v;

import android.util.SparseArray;
import com.google.android.exoplayer2.i1;
import com.google.android.exoplayer2.i1.b;
import com.google.android.exoplayer2.util.d0;
import com.google.android.exoplayer2.util.j;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public final class k implements com.google.android.exoplayer2.l2.v.e0.c {

    private final int a;
    private final List<i1> b;
    public k(int i, List<i1> list2) {
        super();
        this.a = i;
        this.b = list2;
    }

    private com.google.android.exoplayer2.l2.v.a0 c(com.google.android.exoplayer2.l2.v.e0.b e0$b) {
        a0 a0Var = new a0(e(b));
        return a0Var;
    }

    private com.google.android.exoplayer2.l2.v.g0 d(com.google.android.exoplayer2.l2.v.e0.b e0$b) {
        g0 g0Var = new g0(e(b));
        return g0Var;
    }

    private List<i1> e(com.google.android.exoplayer2.l2.v.e0.b e0$b) {
        int i3;
        int i6;
        int i4;
        int i8;
        i1 i1Var;
        int i;
        i1.b bVar;
        int i5;
        int i7;
        String str;
        byte b2;
        int i2;
        List obj13;
        if (f(32)) {
            return this.b;
        }
        d0 d0Var = new d0(b.d);
        obj13 = this.b;
        while (d0Var.a() > 0) {
            if (d0Var.x() == 134) {
            }
            d0Var.I(i13 += i12);
            obj13 = new ArrayList();
            i6 = 0;
            i8 = i6;
            while (i8 < i11 &= 31) {
                int i15 = d0Var.x();
                i7 = 1;
                if (i15 & 128 != 0) {
                } else {
                }
                i5 = i6;
                if (i5 != 0) {
                } else {
                }
                str = "application/cea-608";
                i = i7;
                d0Var.J(i7);
                i2 = 0;
                if (i5 != 0) {
                }
                bVar = new i1.b();
                bVar.e0(str);
                bVar.V(d0Var.u(3));
                bVar.F(i);
                bVar.T(i2);
                obj13.add(bVar.E());
                i8++;
                if (b2 & 64 != 0) {
                } else {
                }
                i7 = i6;
                i2 = j.b(i7);
                i15 &= 63;
                str = "application/cea-708";
                i5 = i7;
            }
            i15 = d0Var.x();
            i7 = 1;
            if (i15 & 128 != 0) {
            } else {
            }
            i5 = i6;
            if (i5 != 0) {
            } else {
            }
            str = "application/cea-608";
            i = i7;
            d0Var.J(i7);
            i2 = 0;
            if (i5 != 0) {
            }
            bVar = new i1.b();
            bVar.e0(str);
            bVar.V(d0Var.u(3));
            bVar.F(i);
            bVar.T(i2);
            obj13.add(bVar.E());
            i8++;
            if (b2 & 64 != 0) {
            } else {
            }
            i7 = i6;
            i2 = j.b(i7);
            i15 &= 63;
            str = "application/cea-708";
            i5 = i7;
        }
        return obj13;
    }

    private boolean f(int i) {
        int obj2;
        obj2 = i &= i2 != 0 ? 1 : 0;
        return obj2;
    }

    @Override // com.google.android.exoplayer2.l2.v.e0$c
    public com.google.android.exoplayer2.l2.v.e0 a(int i, com.google.android.exoplayer2.l2.v.e0.b e0$b2) {
        boolean i3;
        boolean i4;
        int i5;
        int i2;
        com.google.android.exoplayer2.l2.v.x xVar;
        com.google.android.exoplayer2.l2.v.q obj5;
        Object obj6;
        i3 = 2;
        i4 = 4;
        xVar = 0;
        if (i != i3 && i != 3 && i != i4 && i != 21 && i != 27 && i != 36 && i != 89 && i != 138 && i != 172 && i != 257 && i != 129 && i != 130) {
            if (i != 3) {
                i4 = 4;
                if (i != i4) {
                    if (i != 21) {
                        xVar = 0;
                        if (i != 27) {
                            if (i != 36) {
                                if (i != 89) {
                                    if (i != 138) {
                                        if (i != 172) {
                                            if (i != 257) {
                                                if (i != 129) {
                                                    if (i != 130) {
                                                        if (i != 134) {
                                                            if (i != 135) {
                                                                switch (i) {
                                                                    case 15:
                                                                        obj5 = new j(0, b2.b);
                                                                        xVar = new x(obj5);
                                                                        return xVar;
                                                                    case 16:
                                                                        p pVar = new p(d(b2));
                                                                        obj5 = new x(pVar);
                                                                        return obj5;
                                                                    case 17:
                                                                        obj5 = new t(b2.b);
                                                                        xVar = new x(obj5);
                                                                        return xVar;
                                                                    default:
                                                                        return xVar;
                                                                }
                                                            }
                                                        } else {
                                                            if (f(16)) {
                                                            } else {
                                                                obj5 = new w("application/x-scte35");
                                                                xVar = new z(obj5);
                                                            }
                                                        }
                                                        return xVar;
                                                    }
                                                    if (!f(64)) {
                                                        return xVar;
                                                    }
                                                }
                                                f fVar = new f(b2.b);
                                                obj5 = new x(fVar);
                                                return obj5;
                                            }
                                            obj6 = new w("application/vnd.dvb.ait");
                                            obj5 = new z(obj6);
                                            return obj5;
                                        }
                                        h hVar = new h(b2.b);
                                        obj5 = new x(hVar);
                                        return obj5;
                                    }
                                    l lVar = new l(b2.b);
                                    obj5 = new x(lVar);
                                    return obj5;
                                }
                                m mVar = new m(b2.c);
                                obj5 = new x(mVar);
                                return obj5;
                            }
                            r rVar = new r(c(b2));
                            obj5 = new x(rVar);
                            return obj5;
                        }
                        if (f(i4)) {
                        } else {
                            obj5 = new q(c(b2), f(1), f(8));
                            xVar = new x(obj5);
                        }
                        return xVar;
                    }
                    obj6 = new s();
                    obj5 = new x(obj6);
                    return obj5;
                }
            }
            u uVar = new u(b2.b);
            obj5 = new x(uVar);
            return obj5;
        }
        o oVar = new o(d(b2));
        obj5 = new x(oVar);
        return obj5;
    }

    public SparseArray<com.google.android.exoplayer2.l2.v.e0> b() {
        SparseArray sparseArray = new SparseArray();
        return sparseArray;
    }
}
