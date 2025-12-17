package com.google.android.gms.internal.firebase-auth-api;

import java.security.Provider;
import javax.crypto.KeyAgreement;

/* loaded from: classes2.dex */
public final class oc implements com.google.android.gms.internal.firebase-auth-api.sc<KeyAgreement> {
    @Override // com.google.android.gms.internal.firebase-auth-api.sc
    public final Object a(String string, Provider provider2) {
        KeyAgreement obj1;
        if (provider2 == null) {
            obj1 = KeyAgreement.getInstance(string);
        } else {
            obj1 = KeyAgreement.getInstance(string, provider2);
        }
        return obj1;
    }
}
