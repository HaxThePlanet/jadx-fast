package com.google.android.gms.internal.firebase-auth-api;

import java.security.KeyPairGenerator;
import java.security.Provider;

/* loaded from: classes2.dex */
public final class qc implements com.google.android.gms.internal.firebase-auth-api.sc<KeyPairGenerator> {
    @Override // com.google.android.gms.internal.firebase-auth-api.sc
    public final Object a(String string, Provider provider2) {
        KeyPairGenerator obj1;
        if (provider2 == null) {
            obj1 = KeyPairGenerator.getInstance(string);
        } else {
            obj1 = KeyPairGenerator.getInstance(string, provider2);
        }
        return obj1;
    }
}
