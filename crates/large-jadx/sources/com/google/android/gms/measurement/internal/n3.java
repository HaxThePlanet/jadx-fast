package com.google.android.gms.measurement.internal;

import android.util.Log;

/* loaded from: classes2.dex */
final class n3 implements Runnable {

    final int a;
    final String b;
    final Object c;
    final Object v;
    final Object w;
    final com.google.android.gms.measurement.internal.q3 x;
    n3(com.google.android.gms.measurement.internal.q3 q3, int i2, String string3, Object object4, Object object5, Object object6) {
        this.x = q3;
        this.a = i2;
        this.b = string3;
        this.c = object4;
        this.v = object5;
        this.w = object6;
        super();
    }

    @Override // java.lang.Runnable
    public final void run() {
        char c;
        int cmp;
        String substring;
        int i;
        int length;
        com.google.android.gms.measurement.internal.g4 g4Var = q3Var.a.F();
        if (g4Var.n() && q3.o(this.x) == 0) {
            if (q3.o(this.x) == 0) {
                if (q3Var3.a.z().H()) {
                    c = this.x;
                    c.a.d();
                    q3.E(c, 'C');
                } else {
                    c = this.x;
                    c.a.d();
                    q3.E(c, 'c');
                }
            }
            int i4 = 0;
            if (Long.compare(l, i4) < 0) {
                cmp = this.x;
                cmp.a.z().q();
                q3.D(cmp, 46000);
            }
            String str6 = q3.A(true, this.b, this.c, this.v, this.w);
            StringBuilder stringBuilder = new StringBuilder(length2 += 24);
            stringBuilder.append("2");
            stringBuilder.append("01VDIWEA?".charAt(this.a));
            stringBuilder.append(q3.o(this.x));
            stringBuilder.append(q3.p(this.x));
            stringBuilder.append(":");
            stringBuilder.append(str6);
            int i5 = 1024;
            if (stringBuilder.toString().length() > i5) {
                substring = this.b.substring(0, i5);
            }
            com.google.android.gms.measurement.internal.d4 d4Var = g4Var.d;
            if (d4Var != null) {
                d4Var.b(substring, 1);
            }
        }
        Log.println(6, this.x.C(), "Persisted config not initialized. Not logging error/warn");
    }
}
