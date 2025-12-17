package com.google.android.gms.measurement.internal;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.common.util.e;
import com.google.android.gms.internal.measurement.rc;

/* loaded from: classes2.dex */
final class l9 {

    final com.google.android.gms.measurement.internal.m9 a;
    l9(com.google.android.gms.measurement.internal.m9 m9) {
        this.a = m9;
        super();
    }

    final void a() {
        boolean currentTimeMillis;
        long currentTimeMillis2;
        int i;
        this.a.h();
        g4Var2.l.a(true);
        ActivityManager.RunningAppProcessInfo runningAppProcessInfo = new ActivityManager.RunningAppProcessInfo();
        ActivityManager.getMyMemoryState(runningAppProcessInfo);
        if (m9Var2.a.F().v(m9Var6.a.c().currentTimeMillis()) && runningAppProcessInfo.importance == 100) {
            g4Var2.l.a(true);
            runningAppProcessInfo = new ActivityManager.RunningAppProcessInfo();
            ActivityManager.getMyMemoryState(runningAppProcessInfo);
            if (runningAppProcessInfo.importance == 100) {
                currentTimeMillis2 = "Detected application was in foreground";
                m9Var4.a.b().v().a(currentTimeMillis2);
                c(m9Var5.a.c().currentTimeMillis(), currentTimeMillis2);
            }
        }
    }

    final void b(long l, boolean z2) {
        boolean z;
        int i;
        this.a.h();
        m9.p(this.a);
        if (m9Var3.a.F().v(l)) {
            g4Var2.l.a(true);
        }
        g4Var3.o.b(l);
        if (g4Var4.l.b()) {
            c(l, z2);
        }
    }

    final void c(long l, boolean z2) {
        boolean z;
        com.google.android.gms.measurement.internal.b3 empty;
        Object b3Var;
        int str3;
        Object str2;
        String str;
        long bundle;
        String obj12;
        this.a.h();
        if (!m9Var2.a.o()) {
        }
        g4Var.o.b(l);
        String str4 = "Session started, time";
        m9Var8.a.b().v().b(str4, Long.valueOf(m9Var4.a.c().a()));
        Long valueOf2 = Long.valueOf(l / i);
        m9Var6.a.I().N("auto", "_sid", valueOf2, l);
        com.google.android.gms.measurement.internal.z3 z3Var = g4Var2.l;
        z3Var.a(false);
        Bundle bundle2 = new Bundle();
        bundle2.putLong("_sid", valueOf2.longValue());
        b3Var = c3.e0;
        str3 = 0;
        if (m9Var5.a.z().B(str3, b3Var) && obj12 != null) {
            if (obj12 != null) {
                bundle2.putLong("_aib", 1);
            }
        }
        String str8 = "_s";
        obj12.a.I().v("auto", str8, l, obj7);
        rc.b();
        obj12 = obj12.t.a();
        if (obj12.a.z().B(str3, c3.i0) && !TextUtils.isEmpty(obj12)) {
            obj12 = obj12.t.a();
            if (!TextUtils.isEmpty(obj12)) {
                bundle = new Bundle();
                bundle.putString("_ffr", obj12);
                obj12.a.I().v("auto", "_ssr", l, str8);
            }
        }
    }
}
