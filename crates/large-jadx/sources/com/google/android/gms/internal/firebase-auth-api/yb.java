package com.google.android.gms.internal.firebase-auth-api;

import java.security.GeneralSecurityException;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* loaded from: classes2.dex */
public final class yb implements com.google.android.gms.internal.firebase-auth-api.u1 {

    private static final java.lang.ThreadLocal<Cipher> b;
    private final SecretKey a;
    static {
        wb wbVar = new wb();
        yb.b = wbVar;
    }

    public yb(byte[] bArr) {
        super();
        ed.b(bArr.length);
        SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, "AES");
        this.a = secretKeySpec;
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.u1
    public final byte[] a(byte[] bArr, byte[] b2Arr2) {
        Object gCMParameterSpec;
        int length;
        boolean z;
        int i;
        int length2 = bArr.length;
        if (length2 < 28) {
        } else {
            int i4 = 0;
            final int i5 = 12;
            if (dd.b() && dd.a() <= 19) {
                if (dd.a() <= 19) {
                    gCMParameterSpec = new IvParameterSpec(bArr, i4, i5);
                } else {
                    gCMParameterSpec = new GCMParameterSpec(128, bArr, i4, i5);
                }
            } else {
            }
            java.lang.ThreadLocal threadLocal = yb.b;
            (Cipher)threadLocal.get().init(2, this.a, gCMParameterSpec);
            if (b2Arr2.length != 0) {
                (Cipher)threadLocal.get().updateAAD(b2Arr2);
            }
            return (Cipher)threadLocal.get().doFinal(bArr, i5, length2 += -12);
        }
        GeneralSecurityException obj8 = new GeneralSecurityException("ciphertext too short");
        throw obj8;
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.u1
    public final byte[] b(byte[] bArr, byte[] b2Arr2) {
        throw 0;
    }
}
