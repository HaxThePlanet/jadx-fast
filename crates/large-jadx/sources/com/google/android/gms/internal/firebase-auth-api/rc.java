package com.google.android.gms.internal.firebase-auth-api;

import java.security.Provider;
import javax.crypto.Mac;

/* loaded from: classes2.dex */
public final class rc implements com.google.android.gms.internal.firebase-auth-api.sc<Mac> {
    @Override // com.google.android.gms.internal.firebase-auth-api.sc
    public final Object a(String string, Provider provider2) {
        Mac obj1;
        if (provider2 == null) {
            obj1 = Mac.getInstance(string);
        } else {
            obj1 = Mac.getInstance(string, provider2);
        }
        return obj1;
    }
}
