package com.google.android.gms.internal.firebase-auth-api;

import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;

/* loaded from: classes2.dex */
public final class ad implements com.google.android.gms.internal.firebase-auth-api.q2 {

    private final com.google.android.gms.internal.firebase-auth-api.c6 a;
    private final int b;
    public ad(com.google.android.gms.internal.firebase-auth-api.c6 c6, int i2) {
        super();
        this.a = c6;
        this.b = i2;
        if (i2 < 10) {
        } else {
            c6.a(new byte[0], i2);
        }
        InvalidAlgorithmParameterException obj2 = new InvalidAlgorithmParameterException("tag size too small, need at least 10 bytes");
        throw obj2;
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.q2
    public final void a(byte[] bArr, byte[] b2Arr2) {
        if (!bc.b(this.a.a(b2Arr2, this.b), bArr)) {
        } else {
        }
        GeneralSecurityException obj3 = new GeneralSecurityException("invalid MAC");
        throw obj3;
    }
}
