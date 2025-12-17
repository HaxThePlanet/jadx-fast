package com.google.android.gms.internal.firebase-auth-api;

import java.security.GeneralSecurityException;
import java.util.Map;

/* loaded from: classes2.dex */
public final class f2 {
    public static com.google.android.gms.internal.firebase-auth-api.e2 a(String string) {
        String obj3;
        if (!c3.k().containsKey(string)) {
            final String str = "cannot find key template: ";
            if (string.length() != 0) {
                obj3 = str.concat(string);
            } else {
                obj3 = new String(str);
            }
            GeneralSecurityException generalSecurityException = new GeneralSecurityException(obj3);
            throw generalSecurityException;
        }
        return (e2)c3.k().get(string);
    }
}
