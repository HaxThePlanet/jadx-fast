package com.google.android.gms.internal.firebase-auth-api;

import java.security.GeneralSecurityException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/* loaded from: classes2.dex */
final class b5 implements com.google.android.gms.internal.firebase-auth-api.z1 {

    private final com.google.android.gms.internal.firebase-auth-api.u2<com.google.android.gms.internal.firebase-auth-api.z1> a;
    public b5(com.google.android.gms.internal.firebase-auth-api.u2<com.google.android.gms.internal.firebase-auth-api.z1> u2) {
        super();
        this.a = u2;
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.z1
    public final byte[] a(byte[] bArr, byte[] b2Arr2) {
        int iterator;
        Throwable string;
        byte[] copyOfRange;
        String str2;
        int str;
        int obj9;
        obj9 = bArr.length;
        final int i = 0;
        iterator = 5;
        if (obj9 > iterator) {
            iterator = this.a.d(Arrays.copyOfRange(bArr, 0, iterator)).iterator();
            if (iterator.hasNext()) {
                return (z1)(s2)iterator.next().c().a(Arrays.copyOfRange(bArr, iterator, obj9), i);
            }
        }
        obj9 = this.a.d(x1.a).iterator();
        if (!obj9.hasNext()) {
        } else {
            return (z1)(s2)obj9.next().c().a(bArr, i);
        }
        GeneralSecurityException obj8 = new GeneralSecurityException("decryption failed");
        throw obj8;
    }
}
