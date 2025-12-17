package com.google.android.gms.common;

import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.RemoteException;
import android.os.StrictMode;
import android.util.Log;
import com.google.android.gms.common.internal.r;
import com.google.android.gms.common.internal.y0;
import com.google.android.gms.common.internal.z0;
import com.google.android.gms.dynamic.b;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.dynamite.DynamiteModule.LoadingException;

/* loaded from: classes2.dex */
final class b0 {

    static final com.google.android.gms.common.z a;
    static final com.google.android.gms.common.z b;
    private static volatile z0 c;
    private static final Object d;
    private static Context e;
    static {
        t tVar = new t(x.p2("0\u0082\u0005È0\u0082\u0003° \u0003\u0002\u0001\u0002\u0002\u0014\u0010\u008ae\u0008sù/\u008eQí"));
        u uVar = new u(x.p2("0\u0082\u0006\u00040\u0082\u0003ì \u0003\u0002\u0001\u0002\u0002\u0014\u0003£²­×árÊkì"));
        v vVar = new v(x.p2("0\u0082\u0004C0\u0082\u0003+ \u0003\u0002\u0001\u0002\u0002\t\u0000Âà\u0087FdJ0\u008d0"));
        b0.a = vVar;
        w wVar = new w(x.p2("0\u0082\u0004¨0\u0082\u0003\u0090 \u0003\u0002\u0001\u0002\u0002\t\u0000Õ\u0085¸l}ÓNõ0"));
        b0.b = wVar;
        Object object = new Object();
        b0.d = object;
    }

    static void a(Context context) {
        final Class<com.google.android.gms.common.b0> obj = b0.class;
        synchronized (obj) {
            if (context != null) {
                b0.e = context.getApplicationContext();
            }
            try {
                Log.w("GoogleCertificates", "GoogleCertificates has been initialized already");
                throw context;
            }
        }
    }

    static com.google.android.gms.common.l0 b(String string, boolean z2, boolean z3, boolean z4) {
        com.google.android.gms.common.l0 obj8;
        String obj9;
        int obj10;
        obj10 = "Failed to get Google certificates from remote";
        final String obj11 = "GoogleCertificates";
        r.j(b0.e);
        b0.f();
        super(string, z2, 0, b.p2(b0.e), 0);
        obj8 = b0.c.z0(c0Var);
        if (obj8.j2()) {
            obj8 = l0.b();
        } else {
            if (obj8.zzb() == null) {
                obj9 = obj10;
            }
            if (obj8.k2() == 4) {
                obj8 = new PackageManager.NameNotFoundException();
                obj8 = l0.e(obj9, obj8);
            } else {
                obj8 = l0.d(obj9);
            }
        }
        StrictMode.setThreadPolicy(StrictMode.allowThreadDiskReads());
        return obj8;
    }

    static com.google.android.gms.common.l0 c(String string, com.google.android.gms.common.x x2, boolean z3, boolean z4) {
        StrictMode.setThreadPolicy(StrictMode.allowThreadDiskReads());
        return b0.g(string, x2, z3, z4);
    }

    static boolean d() {
        Throwable th;
        b0.f();
        StrictMode.setThreadPolicy(StrictMode.allowThreadDiskReads());
        return b0.c.d();
    }

    static final String e(boolean z, String string2, com.google.android.gms.common.x x3) {
        int i;
        boolean z2;
        final int i2 = 0;
        if (!z && l0Var.a) {
            if (l0Var.a) {
            } else {
                i = i2;
            }
        } else {
        }
        return l0.g(string2, x3, z, i);
    }

    private static void f() {
        z0 z0Var;
        String str;
        String str2;
        if (b0.c != null) {
        }
        r.j(b0.e);
        Object obj = b0.d;
        synchronized (obj) {
            b0.c = y0.m(DynamiteModule.e(b0.e, DynamiteModule.c, "com.google.android.gms.googlecertificates").d("com.google.android.gms.common.GoogleCertificatesImpl"));
        }
    }

    private static com.google.android.gms.common.l0 g(String string, com.google.android.gms.common.x x2, boolean z3, boolean z4) {
        final String str = "Failed to get Google certificates from remote";
        final String str2 = "GoogleCertificates";
        b0.f();
        r.j(b0.e);
        h0 h0Var = new h0(string, x2, z3, z4);
        if (b0.c.S0(h0Var, b.p2(b0.e.getPackageManager()))) {
            return l0.b();
        }
        s obj7 = new s(z3, string, x2);
        return l0.c(obj7);
    }
}
