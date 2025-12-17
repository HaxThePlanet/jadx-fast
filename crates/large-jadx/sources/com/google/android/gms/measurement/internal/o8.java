package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.r;
import com.google.android.gms.internal.measurement.i1;
import java.util.ArrayList;

/* loaded from: classes2.dex */
final class o8 implements Runnable {

    final String a;
    final String b;
    final com.google.android.gms.measurement.internal.na c;
    final i1 v;
    final com.google.android.gms.measurement.internal.w8 w;
    o8(com.google.android.gms.measurement.internal.w8 w8, String string2, String string3, com.google.android.gms.measurement.internal.na na4, i1 i15) {
        this.w = w8;
        this.a = string2;
        this.b = string3;
        this.c = na4;
        this.v = i15;
        super();
    }

    @Override // java.lang.Runnable
    public final void run() {
        ArrayList arrayList;
        com.google.android.gms.measurement.internal.b5 b5Var;
        String str2;
        String str;
        Object naVar;
        String str3;
        arrayList = new ArrayList();
        com.google.android.gms.measurement.internal.g3 g3Var = w8.H(this.w);
        if (g3Var == null) {
            w8Var4.a.b().r().c("Failed to get conditional properties; not connected to service", this.a, this.b);
            b5Var = w8Var5.a;
        } else {
            r.j(this.c);
            arrayList = ia.u(g3Var.s0(this.a, this.b, this.c));
            w8.N(this.w);
            b5Var = w8Var3.a;
        }
        b5Var.N().D(this.v, arrayList);
    }
}
