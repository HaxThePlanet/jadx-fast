package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.r;
import com.google.android.gms.internal.measurement.i1;

/* loaded from: classes2.dex */
final class b8 implements Runnable {

    final com.google.android.gms.measurement.internal.na a;
    final i1 b;
    final com.google.android.gms.measurement.internal.w8 c;
    b8(com.google.android.gms.measurement.internal.w8 w8, com.google.android.gms.measurement.internal.na na2, i1 i13) {
        this.c = w8;
        this.a = na2;
        this.b = i13;
        super();
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.google.android.gms.measurement.internal.b5 b5Var;
        int i;
        Object g3Var;
        Object w8Var;
        Object str;
        i = 0;
        if (!w8Var5.a.F().q().k()) {
            w8Var10.a.b().x().a("Analytics storage consent denied; will not get app instance id");
            w8Var11.a.I().C(i);
            g4Var3.g.b(i);
            b5Var = w8Var4.a;
        } else {
            try {
                g3Var = w8.H(this.c);
                if (g3Var == null) {
                } else {
                }
                w8Var9.a.b().r().a("Failed to get app instance id");
                b5Var = w8Var3.a;
                r.j(this.a);
                i = g3Var.R(this.a);
                if (i != null) {
                }
                w8Var7.a.I().C(i);
                g4Var2.g.b(i);
                w8.N(this.c);
                b5Var = w8Var2.a;
                str = this.c;
                str = str.a;
                str = str.b();
                str = str.r();
                str.b(th, th2);
                Throwable th = this.c;
                th = th.a;
                Throwable th2 = this.c;
                th2 = th2.a;
                th2 = th2.N();
                str = this.b;
                th2.I(str, obj1);
                throw th;
            } catch (Throwable th) {
            }
        }
        b5Var.N().I(this.b, i);
    }
}
