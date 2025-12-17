package com.google.android.gms.internal.firebase-auth-api;

import java.security.interfaces.ECPublicKey;
import java.security.spec.ECParameterSpec;

/* loaded from: classes2.dex */
public final class ic implements com.google.android.gms.internal.firebase-auth-api.a2 {
    public ic(ECPublicKey eCPublicKey, byte[] b2Arr2, String string3, int i4, com.google.android.gms.internal.firebase-auth-api.gc gc5) {
        super();
        kc.d(eCPublicKey.getW(), eCPublicKey.getParams().getCurve());
    }
}
