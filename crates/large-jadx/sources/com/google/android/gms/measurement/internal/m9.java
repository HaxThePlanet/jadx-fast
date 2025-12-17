package com.google.android.gms.measurement.internal;

import android.os.Handler;
import android.os.Looper;
import com.google.android.gms.common.util.e;
import com.google.android.gms.internal.measurement.a1;

/* loaded from: classes2.dex */
public final class m9 extends com.google.android.gms.measurement.internal.f4 {

    private Handler c;
    protected final com.google.android.gms.measurement.internal.l9 d;
    protected final com.google.android.gms.measurement.internal.k9 e;
    protected final com.google.android.gms.measurement.internal.h9 f;
    m9(com.google.android.gms.measurement.internal.b5 b5) {
        super(b5);
        l9 obj1 = new l9(this);
        this.d = obj1;
        obj1 = new k9(this);
        this.e = obj1;
        obj1 = new h9(this);
        this.f = obj1;
    }

    static Handler o(com.google.android.gms.measurement.internal.m9 m9) {
        return m9.c;
    }

    static void p(com.google.android.gms.measurement.internal.m9 m9) {
        m9.s();
    }

    static void q(com.google.android.gms.measurement.internal.m9 m9, long l2) {
        Object obj3;
        m9.h();
        m9.s();
        m9.a.b().v().b("Activity paused, time", Long.valueOf(l2));
        m9.f.a(l2);
        if (m9.a.z().D()) {
            m9.e.b(l2);
        }
    }

    static void r(com.google.android.gms.measurement.internal.m9 m9, long l2) {
        boolean z;
        m9.h();
        m9.s();
        m9.a.b().v().b("Activity resumed, time", Long.valueOf(l2));
        if (!m9.a.z().D()) {
            if (g4Var.q.b()) {
                m9.e.c(l2);
            }
        } else {
        }
        m9.f.b();
        final com.google.android.gms.measurement.internal.l9 obj3 = m9.d;
        obj3.a.h();
        if (!obj4.a.o()) {
        }
        obj3.b(obj4.a.c().currentTimeMillis(), obj5);
    }

    private final void s() {
        Handler a1Var;
        Looper mainLooper;
        h();
        if (this.c == null) {
            a1Var = new a1(Looper.getMainLooper());
            this.c = a1Var;
        }
    }

    @Override // com.google.android.gms.measurement.internal.f4
    protected final boolean n() {
        return 0;
    }
}
