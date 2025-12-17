package com.google.android.gms.measurement.internal;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;

/* loaded from: classes2.dex */
public final class o4 implements Callable {

    public final com.google.android.gms.measurement.internal.t4 a;
    public final String b;
    public o4(com.google.android.gms.measurement.internal.t4 t4, String string2) {
        super();
        this.a = t4;
        this.b = string2;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        Long valueOf;
        String str;
        com.google.android.gms.measurement.internal.t4 t4Var = this.a;
        String str3 = this.b;
        com.google.android.gms.measurement.internal.g5 g5Var = t4Var.b.U().T(str3);
        HashMap hashMap = new HashMap();
        hashMap.put("platform", "android");
        hashMap.put("package_name", str3);
        t4Var.a.z().q();
        hashMap.put("gmp_version", Long.valueOf(46000));
        String str2 = g5Var.h0();
        if (g5Var != null && str2 != null) {
            str2 = g5Var.h0();
            if (str2 != null) {
                hashMap.put("app_version", str2);
            }
            String str4 = "app_version_int";
            hashMap.put(str4, Long.valueOf(g5Var.M()));
            hashMap.put("dynamite_version", Long.valueOf(g5Var.V()));
        }
        return hashMap;
    }
}
