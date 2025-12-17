package com.google.android.gms.internal.firebase-auth-api;

import java.security.KeyFactory;
import java.security.Provider;

/* loaded from: classes2.dex */
public final class pc implements com.google.android.gms.internal.firebase-auth-api.sc<KeyFactory> {
    @Override // com.google.android.gms.internal.firebase-auth-api.sc
    public final Object a(String string, Provider provider2) {
        KeyFactory obj1;
        if (provider2 == null) {
            obj1 = KeyFactory.getInstance(string);
        } else {
            obj1 = KeyFactory.getInstance(string, provider2);
        }
        return obj1;
    }
}
