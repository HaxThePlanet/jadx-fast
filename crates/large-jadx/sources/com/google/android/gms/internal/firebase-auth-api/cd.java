package com.google.android.gms.internal.firebase-auth-api;

import java.security.SecureRandom;

/* loaded from: classes2.dex */
public final class cd {

    private static final java.lang.ThreadLocal<SecureRandom> a;
    static {
        bd bdVar = new bd();
        cd.a = bdVar;
    }

    public static byte[] a(int i) {
        final byte[] obj1 = new byte[i];
        (SecureRandom)cd.a.get().nextBytes(obj1);
        return obj1;
    }
}
