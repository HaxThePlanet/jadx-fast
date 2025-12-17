package com.google.android.gms.measurement.internal;

import android.os.Bundle;

/* loaded from: classes2.dex */
public final class f9 implements Runnable {

    public final com.google.android.gms.measurement.internal.g9 a;
    public f9(com.google.android.gms.measurement.internal.g9 g9) {
        super();
        this.a = g9;
    }

    @Override // java.lang.Runnable
    public final void run() {
        boolean z2;
        boolean z;
        int i;
        int i2;
        com.google.android.gms.measurement.internal.b3 b3Var;
        com.google.android.gms.measurement.internal.g9 g9Var = this.a;
        final com.google.android.gms.measurement.internal.h9 h9Var = g9Var.c;
        long l = g9Var.b;
        h9Var.b.h();
        m9Var2.a.b().q().a("Application going to the background");
        i = 1;
        g4Var.q.a(i);
        Bundle bundle = new Bundle();
        if (!m9Var4.a.z().D()) {
            m9Var5.e.b(l);
            i2 = 0;
            if (m9Var6.a.z().B(0, c3.g0)) {
                com.google.android.gms.measurement.internal.k9 k9Var2 = m9Var8.e;
                k9Var2.b = l;
                bundle.putLong("_et", l - l3);
                ia.x(m9Var9.a.K().t(i), bundle, i);
            } else {
                i = i2;
            }
            m9Var7.e.d(i2, i, l);
        }
        m9Var10.a.I().v("auto", "_ab", g9Var.a, obj6);
    }
}
