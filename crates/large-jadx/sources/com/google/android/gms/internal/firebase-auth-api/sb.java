package com.google.android.gms.internal.firebase-auth-api;

import java.security.GeneralSecurityException;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* loaded from: classes2.dex */
public final class sb implements com.google.android.gms.internal.firebase-auth-api.uc {

    private static final java.lang.ThreadLocal<Cipher> d;
    private final SecretKeySpec a;
    private final int b;
    private final int c;
    static {
        rb rbVar = new rb();
        sb.d = rbVar;
    }

    public sb(byte[] bArr, int i2) {
        super();
        ed.b(bArr.length);
        SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, "AES");
        this.a = secretKeySpec;
        int obj3 = (Cipher)sb.d.get().getBlockSize();
        this.c = obj3;
        if (i2 < 12) {
        } else {
            if (i2 > obj3) {
            } else {
                this.b = i2;
            }
        }
        obj3 = new GeneralSecurityException("invalid IV size");
        throw obj3;
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.uc
    public final byte[] a(byte[] bArr) {
        int length = bArr.length;
        int i2 = this.b;
        if (length < i2) {
        } else {
            byte[] bArr3 = new byte[i2];
            int i3 = 0;
            System.arraycopy(bArr, i3, bArr3, i3, i2);
            final int i6 = this.b;
            length -= i6;
            byte[] bArr2 = new byte[i];
            Object obj = sb.d.get();
            byte[] bArr4 = new byte[this.c];
            System.arraycopy(bArr3, i3, bArr4, i3, this.b);
            IvParameterSpec ivParameterSpec = new IvParameterSpec(bArr4);
            (Cipher)obj.init(2, this.a, ivParameterSpec);
            if (obj.doFinal(bArr, i6, i, bArr2, 0) != i) {
            } else {
                return bArr2;
            }
            GeneralSecurityException obj11 = new GeneralSecurityException("stored output's length does not match input's length");
            throw obj11;
        }
        obj11 = new GeneralSecurityException("ciphertext too short");
        throw obj11;
    }
}
