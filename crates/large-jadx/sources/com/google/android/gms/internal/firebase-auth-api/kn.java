package com.google.android.gms.internal.firebase-auth-api;

import android.app.Activity;
import com.google.android.gms.common.util.e;
import com.google.android.gms.common.util.h;
import com.google.firebase.auth.PhoneAuthProvider.OnVerificationStateChangedCallbacks;
import d.e.a;
import java.util.Map;
import java.util.concurrent.Executor;

/* loaded from: classes2.dex */
public final class kn {

    private static final Map<String, com.google.android.gms.internal.firebase-auth-api.jn> a;
    static {
        a aVar = new a();
        kn.a = aVar;
    }

    public static PhoneAuthProvider.OnVerificationStateChangedCallbacks a(String string, PhoneAuthProvider.OnVerificationStateChangedCallbacks phoneAuthProvider$OnVerificationStateChangedCallbacks2, com.google.android.gms.internal.firebase-auth-api.an an3) {
        kn.e(string, an3);
        in obj2 = new in(onVerificationStateChangedCallbacks2, string);
        return obj2;
    }

    static void b(String string) {
        kn.a.remove(string);
    }

    public static void c() {
        kn.a.clear();
    }

    public static boolean d(String string, PhoneAuthProvider.OnVerificationStateChangedCallbacks phoneAuthProvider$OnVerificationStateChangedCallbacks2, Activity activity3, Executor executor4) {
        Map map = kn.a;
        final int i = 0;
        final int i2 = 0;
        Object obj = map.get(string);
        com.google.android.gms.internal.firebase-auth-api.an anVar = obj.a;
        if (map.containsKey(string) && Long.compare(i3, i4) < 0 && anVar != null) {
            obj = map.get(string);
            if (Long.compare(i3, i4) < 0) {
                anVar = obj.a;
                if (anVar != null) {
                    anVar.f(onVerificationStateChangedCallbacks2, activity3, executor4, string);
                }
                return 1;
            }
            kn.e(string, i2);
            return i;
        }
        kn.e(string, i2);
        return i;
    }

    private static void e(String string, com.google.android.gms.internal.firebase-auth-api.an an2) {
        jn jnVar = new jn(an2, h.b().currentTimeMillis(), obj3);
        kn.a.put(string, jnVar);
    }
}
