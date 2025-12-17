package com.google.android.gms.internal.firebase-auth-api;

import java.security.GeneralSecurityException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/* loaded from: classes2.dex */
final class t4 implements com.google.android.gms.internal.firebase-auth-api.y1 {

    private final com.google.android.gms.internal.firebase-auth-api.u2<com.google.android.gms.internal.firebase-auth-api.y1> a;
    public t4(com.google.android.gms.internal.firebase-auth-api.u2<com.google.android.gms.internal.firebase-auth-api.y1> u2) {
        super();
        this.a = u2;
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.y1
    public final byte[] a(byte[] bArr, byte[] b2Arr2) {
        int copyOfRange2;
        int iterator;
        Throwable string;
        byte[] copyOfRange;
        String str;
        int str2;
        copyOfRange2 = bArr.length;
        iterator = 5;
        if (copyOfRange2 > iterator) {
            iterator = this.a.d(Arrays.copyOfRange(bArr, 0, iterator)).iterator();
            if (iterator.hasNext()) {
                return (y1)(s2)iterator.next().c().a(Arrays.copyOfRange(bArr, iterator, copyOfRange2), b2Arr2);
            }
        }
        Iterator iterator2 = this.a.d(x1.a).iterator();
        if (!iterator2.hasNext()) {
        } else {
            return (y1)(s2)iterator2.next().c().a(bArr, b2Arr2);
        }
        GeneralSecurityException obj8 = new GeneralSecurityException("decryption failed");
        throw obj8;
    }
}
