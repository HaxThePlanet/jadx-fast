package com.google.android.gms.internal.firebase-auth-api;

import java.security.Provider;
import javax.crypto.Cipher;

/* loaded from: classes2.dex */
public final class nc implements com.google.android.gms.internal.firebase-auth-api.sc<Cipher> {
    @Override // com.google.android.gms.internal.firebase-auth-api.sc
    public final Object a(String string, Provider provider2) {
        Cipher obj1;
        if (provider2 == null) {
            obj1 = Cipher.getInstance(string);
        } else {
            obj1 = Cipher.getInstance(string, provider2);
        }
        return obj1;
    }
}
