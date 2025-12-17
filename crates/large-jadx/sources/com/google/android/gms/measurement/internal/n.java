package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.os.Handler;
import com.google.android.gms.common.internal.r;
import com.google.android.gms.common.util.e;
import com.google.android.gms.internal.measurement.a1;

/* loaded from: classes2.dex */
abstract class n {

    private static volatile Handler d;
    private final com.google.android.gms.measurement.internal.x5 a;
    private final Runnable b;
    private volatile long c;
    n(com.google.android.gms.measurement.internal.x5 x5) {
        super();
        r.j(x5);
        this.a = x5;
        m mVar = new m(this, x5);
        this.b = mVar;
    }

    static void a(com.google.android.gms.measurement.internal.n n, long l2) {
        n.c = 0;
    }

    private final Handler f() {
        Handler a1Var;
        android.os.Looper mainLooper;
        if (n.d != null) {
            return n.d;
        }
        Class<com.google.android.gms.measurement.internal.n> obj = n.class;
        synchronized (obj) {
            a1Var = new a1(this.a.f().getMainLooper());
            n.d = a1Var;
            return n.d;
        }
    }

    final void b() {
        this.c = 0;
        f().removeCallbacks(this.b);
    }

    public abstract void c();

    public final void d(long l) {
        int postDelayed;
        Runnable runnable;
        int obj3;
        long obj4;
        b();
        this.c = this.a.c().currentTimeMillis();
        if (Long.compare(l, i) >= 0 && !f().postDelayed(this.b, l)) {
            this.c = this.a.c().currentTimeMillis();
            if (!f().postDelayed(this.b, l)) {
                this.a.b().r().b("Failed to schedule delayed post. time", Long.valueOf(l));
            }
        }
    }

    public final boolean e() {
        if (Long.compare(l, i3) != 0) {
            return 1;
        }
        return 0;
    }
}
