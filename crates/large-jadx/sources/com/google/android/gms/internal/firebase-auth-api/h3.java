package com.google.android.gms.internal.firebase-auth-api;

import java.security.GeneralSecurityException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/* loaded from: classes2.dex */
final class h3 implements com.google.android.gms.internal.firebase-auth-api.u1 {

    private final com.google.android.gms.internal.firebase-auth-api.u2<com.google.android.gms.internal.firebase-auth-api.u1> a;
    h3(com.google.android.gms.internal.firebase-auth-api.u2 u2, com.google.android.gms.internal.firebase-auth-api.g3 g32) {
        super();
        this.a = u2;
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.u1
    public final byte[] a(byte[] bArr, byte[] b2Arr2) {
        int copyOfRange;
        int iterator;
        Throwable string;
        byte[] copyOfRange2;
        String str;
        int str2;
        copyOfRange = bArr.length;
        iterator = 5;
        if (copyOfRange > iterator) {
            iterator = this.a.d(Arrays.copyOfRange(bArr, 0, iterator)).iterator();
            if (iterator.hasNext()) {
                return (u1)(s2)iterator.next().c().a(Arrays.copyOfRange(bArr, iterator, copyOfRange), b2Arr2);
            }
        }
        Iterator iterator2 = this.a.d(x1.a).iterator();
        if (!iterator2.hasNext()) {
        } else {
            return (u1)(s2)iterator2.next().c().a(bArr, b2Arr2);
        }
        GeneralSecurityException obj8 = new GeneralSecurityException("decryption failed");
        throw obj8;
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.u1
    public final byte[] b(byte[] bArr, byte[] b2Arr2) {
        throw 0;
    }
}
