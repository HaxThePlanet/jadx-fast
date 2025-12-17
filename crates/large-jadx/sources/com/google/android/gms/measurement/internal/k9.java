package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import com.google.android.gms.common.util.e;
import com.google.android.gms.internal.measurement.bd;

/* loaded from: classes2.dex */
final class k9 {

    protected long a;
    protected long b;
    private final com.google.android.gms.measurement.internal.n c;
    final com.google.android.gms.measurement.internal.m9 d;
    public k9(com.google.android.gms.measurement.internal.m9 m9) {
        this.d = m9;
        super();
        j9 j9Var = new j9(this, m9.a);
        this.c = j9Var;
        long l = m9.a.c().a();
        this.a = l;
        this.b = l;
    }

    final void a() {
        this.c.b();
        int i = 0;
        this.a = i;
        this.b = i;
    }

    final void b(long l) {
        this.c.b();
    }

    final void c(long l) {
        this.d.h();
        this.c.b();
        this.a = l;
        this.b = l;
    }

    public final boolean d(boolean z, boolean z2, long l3) {
        com.google.android.gms.measurement.internal.b4 b4Var;
        int i;
        boolean str4;
        boolean str;
        Object b3Var;
        Object str3;
        long currentTimeMillis;
        String str2;
        int obj7;
        com.google.android.gms.measurement.internal.i7 obj8;
        this.d.h();
        this.d.i();
        bd.b();
        final int i3 = 0;
        if (m9Var3.a.z().B(i3, c3.j0)) {
            if (m9Var5.a.o()) {
                g4Var2.o.b(m9Var11.a.c().currentTimeMillis());
            }
        } else {
            g4Var.o.b(m9Var10.a.c().currentTimeMillis());
        }
        i = l3 - l;
        if (z == 0 && Long.compare(i, currentTimeMillis) >= 0) {
            if (Long.compare(i, currentTimeMillis) >= 0) {
            }
            obj7.a.b().v().b("Screen exposed for less than 1000 ms. Event not sent. time", Long.valueOf(i));
            return 0;
        }
        if (z2 == null) {
            i = l3 - l2;
            this.b = l3;
        }
        obj7.a.b().v().b("Recording user engagement, ms", Long.valueOf(i));
        obj7 = new Bundle();
        obj7.putLong("_et", i);
        int i4 = 1;
        ia.x(m9Var12.a.K().t(z4 ^= i4), obj7, i4);
        str3 = c3.U;
        if (!m9Var8.a.z().B(i3, str3) && z2 != null) {
            if (z2 != null) {
                obj7.putLong("_fr", 1);
            }
        }
        if (m9Var9.a.z().B(i3, str3)) {
            if (z2 == null) {
                obj8.a.I().u("auto", "_e", obj7);
            }
        } else {
        }
        this.a = l3;
        this.c.b();
        this.c.d(3600000);
        return i4;
    }
}
