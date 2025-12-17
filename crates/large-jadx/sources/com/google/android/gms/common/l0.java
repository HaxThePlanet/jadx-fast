package com.google.android.gms.common;

import android.util.Log;
import com.google.android.gms.common.internal.r;
import com.google.android.gms.common.util.a;
import com.google.android.gms.common.util.j;
import java.security.MessageDigest;
import java.util.concurrent.Callable;

/* loaded from: classes2.dex */
class l0 {

    private static final com.google.android.gms.common.l0 d;
    final boolean a;
    final String b;
    final Throwable c;
    static {
        final int i2 = 0;
        l0 l0Var = new l0(1, i2, i2);
        l0.d = l0Var;
    }

    l0(boolean z, String string2, Throwable throwable3) {
        super();
        this.a = z;
        this.b = string2;
        this.c = throwable3;
    }

    static com.google.android.gms.common.l0 b() {
        return l0.d;
    }

    static com.google.android.gms.common.l0 c(Callable<String> callable) {
        k0 k0Var = new k0(callable, 0);
        return k0Var;
    }

    static com.google.android.gms.common.l0 d(String string) {
        l0 l0Var = new l0(0, string, 0);
        return l0Var;
    }

    static com.google.android.gms.common.l0 e(String string, Throwable throwable2) {
        l0 l0Var = new l0(0, string, throwable2);
        return l0Var;
    }

    static String g(String string, com.google.android.gms.common.x x2, boolean z3, boolean z4) {
        String obj6;
        final int i = 1;
        obj6 = i != z4 ? "not allowed" : "debug cert rejected";
        Object[] arr = new Object[5];
        arr[i] = string;
        MessageDigest obj3 = a.b("SHA-1");
        r.j(obj3);
        arr[2] = j.a(obj3.digest(x2.n()));
        arr[3] = Boolean.valueOf(z3);
        arr[4] = "12451000.false";
        return String.format("%s: pkg=%s, sha1=%s, atk=%s, ver=%s", arr);
    }

    String a() {
        return this.b;
    }

    final void f() {
        boolean loggable;
        String str;
        str = "GoogleCertificatesRslt";
        if (!this.a && Log.isLoggable(str, 3) && this.c != null) {
            str = "GoogleCertificatesRslt";
            if (Log.isLoggable(str, 3)) {
                if (this.c != null) {
                    Log.d(str, a(), this.c);
                }
                Log.d(str, a());
            }
        }
    }
}
