package com.google.android.gms.internal.firebase-auth-api;

import java.security.GeneralSecurityException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/* loaded from: classes2.dex */
final class a6 implements com.google.android.gms.internal.firebase-auth-api.q2 {

    private final com.google.android.gms.internal.firebase-auth-api.u2<com.google.android.gms.internal.firebase-auth-api.q2> a;
    private final byte[] b;
    a6(com.google.android.gms.internal.firebase-auth-api.u2 u2, com.google.android.gms.internal.firebase-auth-api.z5 z52) {
        super();
        byte[] obj3 = new byte[1];
        final int i = 0;
        obj3[i] = i;
        this.b = obj3;
        this.a = u2;
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.q2
    public final void a(byte[] bArr, byte[] b2Arr2) {
        byte[] copyOf;
        Logger logger;
        Level iNFO;
        String str;
        StringBuilder str2;
        int length = bArr.length;
        int i = 5;
        if (length <= i) {
        } else {
            byte[] copyOfRange = Arrays.copyOfRange(bArr, i, length);
            Iterator iterator2 = this.a.d(Arrays.copyOf(bArr, i)).iterator();
            Object next4 = iterator2.next();
            if (iterator2.hasNext() && (s2)next4.b().equals(hb.zzc)) {
                next4 = iterator2.next();
                if ((s2)next4.b().equals(hb.zzc)) {
                    byte[][] bArr3 = new byte[2];
                    (q2)next4.c().a(copyOfRange, bc.c(b2Arr2, this.b));
                }
                (q2)next4.c().a(copyOfRange, b2Arr2);
            }
            Iterator iterator = this.a.d(x1.a).iterator();
            if (!iterator.hasNext()) {
            } else {
                (q2)(s2)iterator.next().c().a(bArr, b2Arr2);
            }
            GeneralSecurityException obj8 = new GeneralSecurityException("invalid MAC");
            throw obj8;
        }
        obj8 = new GeneralSecurityException("tag too short");
        throw obj8;
    }
}
