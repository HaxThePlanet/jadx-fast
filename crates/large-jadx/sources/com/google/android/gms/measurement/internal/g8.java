package com.google.android.gms.measurement.internal;

import com.google.android.gms.internal.measurement.i1;

/* loaded from: classes2.dex */
final class g8 implements Runnable {

    final com.google.android.gms.measurement.internal.u a;
    final String b;
    final i1 c;
    final com.google.android.gms.measurement.internal.w8 v;
    g8(com.google.android.gms.measurement.internal.w8 w8, com.google.android.gms.measurement.internal.u u2, String string3, i1 i14) {
        this.v = w8;
        this.a = u2;
        this.b = string3;
        this.c = i14;
        super();
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i;
        com.google.android.gms.measurement.internal.b5 b5Var;
        Object str;
        String str2;
        i = 0;
        com.google.android.gms.measurement.internal.g3 g3Var = w8.H(this.v);
        if (g3Var == null) {
            try {
                w8Var4.a.b().r().a("Discarding data. Failed to send event to service to bundle");
                b5Var = w8Var5.a;
                b5Var.N().F(this.c, i);
                i = g3Var.f0(this.a, this.b);
                w8.N(this.v);
                b5Var = w8Var3.a;
                com.google.android.gms.measurement.internal.w8 w8Var6 = this.v;
                w8Var6 = w8Var6.a;
                w8Var6 = w8Var6.b();
                w8Var6 = w8Var6.r();
                str2 = "Failed to send event to the service to bundle";
                w8Var6.b(str2, th);
                Throwable th = this.v;
                th = th.a;
                w8Var6 = this.v;
                w8Var6 = w8Var6.a;
                w8Var6 = w8Var6.N();
                str2 = this.c;
                w8Var6.F(str2, obj0);
                throw th;
            } catch (Throwable th) {
            }
        } else {
        }
    }
}
