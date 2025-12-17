package com.google.android.gms.internal.firebase-auth-api;

import java.security.GeneralSecurityException;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* loaded from: classes2.dex */
public final class n4 implements com.google.android.gms.internal.firebase-auth-api.u1 {

    private static final java.lang.ThreadLocal<Cipher> b;
    private final SecretKey a;
    static {
        m4 m4Var = new m4();
        n4.b = m4Var;
    }

    public n4(byte[] bArr) {
        super();
        ed.b(bArr.length);
        SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, "AES");
        this.a = secretKeySpec;
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.u1
    public final byte[] a(byte[] bArr, byte[] b2Arr2) {
        GCMParameterSpec gCMParameterSpec;
        int length;
        if (bArr.length < 28) {
        } else {
            int i4 = 12;
            Class.forName("javax.crypto.spec.GCMParameterSpec");
            gCMParameterSpec = new GCMParameterSpec(128, bArr, 0, i4);
            java.lang.ThreadLocal threadLocal = n4.b;
            (Cipher)threadLocal.get().init(2, this.a, gCMParameterSpec);
            if (b2Arr2.length != 0) {
                (Cipher)threadLocal.get().updateAAD(b2Arr2);
            }
            return (Cipher)threadLocal.get().doFinal(bArr, i4, length3 += -12);
        }
        try {
            GeneralSecurityException obj7 = new GeneralSecurityException("ciphertext too short");
            throw obj7;
        }
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.u1
    public final byte[] b(byte[] bArr, byte[] b2Arr2) {
        throw 0;
    }
}
