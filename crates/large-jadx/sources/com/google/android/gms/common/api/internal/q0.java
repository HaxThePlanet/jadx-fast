package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.b;
import com.google.android.gms.common.internal.c;
import com.google.android.gms.common.internal.e;
import com.google.android.gms.common.internal.o;
import com.google.android.gms.common.internal.s;
import com.google.android.gms.common.internal.t;
import com.google.android.gms.common.util.b;
import com.google.android.gms.tasks.e;
import com.google.android.gms.tasks.j;

/* loaded from: classes2.dex */
final class q0<T>  implements e<T> {

    private final com.google.android.gms.common.api.internal.g a;
    private final int b;
    private final com.google.android.gms.common.api.internal.c<?> c;
    private final long d;
    q0(com.google.android.gms.common.api.internal.g g, int i2, com.google.android.gms.common.api.internal.c<?> c3, long l4, String string5, String string6) {
        super();
        this.a = g;
        this.b = i2;
        this.c = c3;
        this.d = l4;
    }

    static <T> com.google.android.gms.common.api.internal.q0<T> a(com.google.android.gms.common.api.internal.g g, int i2, com.google.android.gms.common.api.internal.c<?> c3) {
        boolean z;
        long currentTimeMillis;
        com.google.android.gms.common.api.internal.i0 i0Var;
        com.google.android.gms.common.api.a.f fVar;
        boolean connectionInfo;
        int i = 0;
        if (!g.x()) {
            return i;
        }
        t tVar = s.b().a();
        if (tVar != null) {
            if (!tVar.l2()) {
                return i;
            }
            z = tVar.m2();
            i0Var = g.s(c3);
            if (i0Var != null && !fVar2 instanceof c) {
                if (!fVar2 instanceof c) {
                    return i;
                }
                fVar = i0Var.v();
                e eVar = q0.b(i0Var, fVar, i2);
                if ((c)fVar.hasConnectionInfo() && !fVar.isConnecting() && eVar == null) {
                    if (!fVar.isConnecting()) {
                        eVar = q0.b(i0Var, fVar, i2);
                        if (eVar == null) {
                            return i;
                        }
                        i0Var.I();
                        z = eVar.n2();
                    }
                }
            }
        } else {
            z = 1;
        }
        if (z) {
            currentTimeMillis = System.currentTimeMillis();
        } else {
            currentTimeMillis = 0;
        }
        super(g, i2, c3, currentTimeMillis, obj6, 0, 0);
        return q0Var2;
    }

    private static e b(com.google.android.gms.common.api.internal.i0<?> i0, c<?> c2, int i3) {
        boolean z;
        int obj2;
        int obj4;
        final e obj3 = c2.getTelemetryConfiguration();
        if (obj3 != null && obj3.m2()) {
            if (obj3.m2()) {
                z = obj3.k2();
                if (z == null) {
                    z = obj3.l2();
                    if (z == null) {
                        if (i0.H() < obj3.j2()) {
                            return obj3;
                        }
                    } else {
                        if (b.b(z, i3)) {
                        } else {
                        }
                    }
                } else {
                    if (!b.b(z, i3)) {
                    } else {
                    }
                }
            }
        }
        return null;
    }

    public final void onComplete(j<T> j) {
        t tVar;
        boolean z;
        com.google.android.gms.common.api.internal.i0 i0Var;
        com.google.android.gms.common.api.internal.c cVar;
        com.google.android.gms.common.api.a.f cmp;
        o oVar;
        int i4;
        com.google.android.gms.common.api.internal.g gVar2;
        int i9;
        int i2;
        int currentTimeMillis;
        o oVar2;
        int i10;
        int i3;
        int i7;
        com.google.android.gms.common.api.internal.g gVar;
        int i13;
        o connectionInfo;
        int i8;
        int i11;
        int i5;
        long l;
        int i12;
        String str;
        int i6;
        int i;
        int gCoreServiceId;
        final Object obj = this;
        if (!obj.a.x()) {
        }
        tVar = s.b().a();
        if (tVar != null && tVar.l2()) {
            if (tVar.l2()) {
            }
        }
        i0Var = obj.a.s(obj.c);
        if (i0Var != null) {
            if (!fVar instanceof c) {
            } else {
                cmp = i0Var.v();
                i2 = 0;
                currentTimeMillis = 0;
                i4 = Long.compare(l3, i2) > 0 ? i9 : currentTimeMillis;
                if (tVar != null) {
                    i4 &= z3;
                    gVar = tVar.k2();
                    tVar = tVar.n2();
                    i0Var = q0.b(i0Var, cmp, obj.b);
                    if (cmp.hasConnectionInfo() && !cmp.isConnecting() && i0Var == null) {
                        if (!cmp.isConnecting()) {
                            i0Var = q0.b(i0Var, cmp, obj.b);
                            if (i0Var == null) {
                            }
                            if (i0Var.n2() && Long.compare(l2, i2) > 0) {
                                if (Long.compare(l2, i2) > 0) {
                                } else {
                                    i9 = currentTimeMillis;
                                }
                            } else {
                            }
                            gVar = i0Var.j2();
                            i4 = i9;
                        }
                    }
                    i0Var = i7;
                    cVar = gVar;
                } else {
                    tVar = currentTimeMillis;
                    cVar = i10;
                    i0Var = i7;
                }
                int i15 = -1;
                if (j.isSuccessful()) {
                    i8 = i13;
                } else {
                    if (j.isCanceled()) {
                        i8 = i15;
                        i13 = i10;
                    } else {
                    }
                }
                if (i4 != 0) {
                    i5 = i2;
                    i12 = currentTimeMillis;
                } else {
                    i12 = i5;
                }
                super(obj.b, i13, i8, i5, obj14, i12, obj16, 0, 0, (c)cmp.getGCoreServiceId());
                obj.a.C(oVar, tVar, (long)i0Var, i12);
            }
        }
    }
}
