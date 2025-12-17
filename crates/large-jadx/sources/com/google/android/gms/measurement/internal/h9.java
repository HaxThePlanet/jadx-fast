package com.google.android.gms.measurement.internal;

import android.os.Handler;
import com.google.android.gms.common.util.e;

/* loaded from: classes2.dex */
final class h9 {

    private com.google.android.gms.measurement.internal.g9 a;
    final com.google.android.gms.measurement.internal.m9 b;
    h9(com.google.android.gms.measurement.internal.m9 m9) {
        this.b = m9;
        super();
    }

    final void a(long l) {
        final Object obj = this;
        super(obj, m9Var.a.c().currentTimeMillis(), obj3, l, obj5);
        this.a = g9Var2;
        m9.o(this.b).postDelayed(this.a, 2000);
    }

    final void b() {
        Object g9Var2;
        com.google.android.gms.measurement.internal.g9 g9Var;
        this.b.h();
        if (this.a != null) {
            m9.o(this.b).removeCallbacks(this.a);
        }
        g4Var.q.a(false);
    }
}
