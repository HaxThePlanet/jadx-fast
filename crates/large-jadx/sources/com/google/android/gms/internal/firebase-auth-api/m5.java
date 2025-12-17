package com.google.android.gms.internal.firebase-auth-api;

import android.util.Log;
import java.security.GeneralSecurityException;
import java.security.InvalidKeyException;
import java.security.KeyStore;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.GCMParameterSpec;

/* loaded from: classes2.dex */
public final class m5 implements com.google.android.gms.internal.firebase-auth-api.u1 {

    private static final String b = "m5";
    private final SecretKey a;
    static {
    }

    m5(String string, KeyStore keyStore2) {
        String obj3;
        super();
        java.security.Key obj4 = keyStore2.getKey(string, 0);
        this.a = (SecretKey)obj4;
        if (obj4 == null) {
            obj3 = String.valueOf(string);
            String str = "Keystore cannot load the key with ID: ";
            if (obj3.length() != 0) {
                obj3 = str.concat(obj3);
            } else {
                obj3 = new String(str);
            }
            obj4 = new InvalidKeyException(obj3);
            throw obj4;
        }
    }

    private static void c() {
        Thread.sleep((long)i2);
    }

    private final byte[] d(byte[] bArr, byte[] b2Arr2) {
        int length = bArr.length;
        if (length < 28) {
        } else {
            final int i6 = 12;
            GCMParameterSpec gCMParameterSpec = new GCMParameterSpec(128, bArr, 0, i6);
            Cipher instance = Cipher.getInstance("AES/GCM/NoPadding");
            instance.init(2, this.a, gCMParameterSpec);
            instance.updateAAD(b2Arr2);
            return instance.doFinal(bArr, i6, length += -12);
        }
        GeneralSecurityException obj7 = new GeneralSecurityException("ciphertext too short");
        throw obj7;
    }

    private final byte[] e(byte[] bArr, byte[] b2Arr2) {
        final int length = bArr.length;
        if (length > 2147483619) {
        } else {
            final byte[] bArr4 = new byte[length + 28];
            final Cipher instance = Cipher.getInstance("AES/GCM/NoPadding");
            instance.init(1, this.a);
            instance.updateAAD(b2Arr2);
            instance.doFinal(bArr, 0, length, bArr4, 12);
            int i4 = 0;
            System.arraycopy(instance.getIV(), i4, bArr4, i4, 12);
            return bArr4;
        }
        GeneralSecurityException obj9 = new GeneralSecurityException("plaintext too long");
        throw obj9;
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.u1
    public final byte[] a(byte[] bArr, byte[] b2Arr2) {
        try {
            return d(bArr, b2Arr2);
            Log.w(m5.b, "encountered a potentially transient KeyStore error, will wait and retry", th);
            m5.c();
            bArr = d(bArr, b2Arr2);
            return bArr;
        }
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.u1
    public final byte[] b(byte[] bArr, byte[] b2Arr2) {
        try {
            return e(bArr, b2Arr2);
            Log.w(m5.b, "encountered a potentially transient KeyStore error, will wait and retry", th);
            m5.c();
            bArr = e(bArr, b2Arr2);
            return bArr;
        }
    }
}
