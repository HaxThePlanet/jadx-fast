package com.google.android.gms.internal.measurement;

import java.lang.reflect.Method;

/* loaded from: classes2.dex */
final class p9 implements com.google.android.gms.internal.measurement.ka {

    private static final com.google.android.gms.internal.measurement.w9 b;
    private final com.google.android.gms.internal.measurement.w9 a;
    static {
        n9 n9Var = new n9();
        p9.b = n9Var;
    }

    public p9() {
        Object invoke;
        com.google.android.gms.internal.measurement.w9[] arr = new w9[2];
        int i2 = 0;
        arr[i2] = s8.c();
        invoke = Class.forName("com.google.protobuf.DescriptorMessageInfoFactory").getDeclaredMethod("getInstance", new Class[i2]).invoke(0, new Object[i2]);
        arr[1] = invoke;
        o9 o9Var = new o9(arr);
        super();
        d9.f(o9Var, "messageInfoFactory");
        this.a = o9Var;
    }

    private static boolean a(com.google.android.gms.internal.measurement.u9 u9) {
        final int i = 1;
        if (u9.zzc() == i) {
            return i;
        }
        return 0;
    }

    public final <T> com.google.android.gms.internal.measurement.ja<T> c(Class<T> class) {
        boolean z;
        Class cls;
        com.google.android.gms.internal.measurement.da daVar;
        com.google.android.gms.internal.measurement.l9 l9Var;
        com.google.android.gms.internal.measurement.xa xaVar;
        int i;
        com.google.android.gms.internal.measurement.s9 s9Var;
        com.google.android.gms.internal.measurement.ba obj10;
        Class<com.google.android.gms.internal.measurement.w8> obj = w8.class;
        la.g(class);
        final com.google.android.gms.internal.measurement.u9 u9Var = this.a.a(class);
        if (u9Var.zzb() && obj.isAssignableFrom(class)) {
            if (obj.isAssignableFrom(class)) {
                return ca.j(la.b(), m8.b(), u9Var.zza());
            }
            return ca.j(la.b0(), m8.a(), u9Var.zza());
        }
        if (obj.isAssignableFrom(class)) {
            if (p9.a(u9Var)) {
                obj10 = ba.F(class, u9Var, ea.b(), l9.d(), la.b(), m8.b(), t9.b());
            } else {
                obj10 = ba.F(class, u9Var, ea.b(), l9.d(), la.b(), 0, t9.b());
            }
        } else {
            if (p9.a(u9Var)) {
                obj10 = ba.F(class, u9Var, ea.a(), l9.c(), la.b0(), m8.a(), t9.a());
            } else {
                obj10 = ba.F(class, u9Var, ea.a(), l9.c(), la.a(), 0, t9.a());
            }
        }
        return obj10;
    }
}
