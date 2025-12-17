package com.google.android.play.core.internal;

import java.security.cert.X509Certificate;

/* loaded from: classes2.dex */
final class u1 extends com.google.android.play.core.internal.v1 {

    private final byte[] zza;
    public u1(X509Certificate x509Certificate, byte[] b2Arr2) {
        super(x509Certificate);
        this.zza = b2Arr2;
    }

    @Override // com.google.android.play.core.internal.v1
    public final byte[] getEncoded() {
        return this.zza;
    }
}
