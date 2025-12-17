package com.google.android.gms.internal.firebase-auth-api;

import java.lang.reflect.Method;

/* loaded from: classes2.dex */
final class q implements com.google.android.gms.internal.firebase-auth-api.m0 {

    private static final com.google.android.gms.internal.firebase-auth-api.w b;
    private final com.google.android.gms.internal.firebase-auth-api.w a;
    static {
        o oVar = new o();
        q.b = oVar;
    }

    public q() {
        Object invoke;
        com.google.android.gms.internal.firebase-auth-api.w[] arr = new w[2];
        int i2 = 0;
        arr[i2] = tr.c();
        invoke = Class.forName("com.google.protobuf.DescriptorMessageInfoFactory").getDeclaredMethod("getInstance", new Class[i2]).invoke(0, new Object[i2]);
        arr[1] = invoke;
        p pVar = new p(arr);
        super();
        e.f(pVar, "messageInfoFactory");
        this.a = pVar;
    }

    private static boolean a(com.google.android.gms.internal.firebase-auth-api.v v) {
        final int i = 1;
        if (v.zzc() == i) {
            return i;
        }
        return 0;
    }

    public final <T> com.google.android.gms.internal.firebase-auth-api.l0<T> c(Class<T> class) {
        boolean z;
        Class cls;
        com.google.android.gms.internal.firebase-auth-api.e0 e0Var;
        com.google.android.gms.internal.firebase-auth-api.m mVar;
        com.google.android.gms.internal.firebase-auth-api.y0 y0Var;
        int i;
        com.google.android.gms.internal.firebase-auth-api.t tVar;
        com.google.android.gms.internal.firebase-auth-api.c0 obj10;
        Class<com.google.android.gms.internal.firebase-auth-api.xr> obj = xr.class;
        n0.g(class);
        final com.google.android.gms.internal.firebase-auth-api.v vVar = this.a.a(class);
        if (vVar.zzb() && obj.isAssignableFrom(class)) {
            if (obj.isAssignableFrom(class)) {
                return d0.k(n0.b(), or.b(), vVar.zza());
            }
            return d0.k(n0.b0(), or.a(), vVar.zza());
        }
        if (obj.isAssignableFrom(class)) {
            if (q.a(vVar)) {
                obj10 = c0.K(class, vVar, f0.b(), m.e(), n0.b(), or.b(), u.b());
            } else {
                obj10 = c0.K(class, vVar, f0.b(), m.e(), n0.b(), 0, u.b());
            }
        } else {
            if (q.a(vVar)) {
                obj10 = c0.K(class, vVar, f0.a(), m.d(), n0.b0(), or.a(), u.a());
            } else {
                obj10 = c0.K(class, vVar, f0.a(), m.d(), n0.a(), 0, u.a());
            }
        }
        return obj10;
    }
}
