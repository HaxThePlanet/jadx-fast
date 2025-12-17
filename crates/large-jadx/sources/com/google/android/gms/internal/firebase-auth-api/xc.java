package com.google.android.gms.internal.firebase-auth-api;

import java.security.InvalidAlgorithmParameterException;
import java.util.Arrays;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

/* loaded from: classes2.dex */
public final class xc implements com.google.android.gms.internal.firebase-auth-api.c6 {

    private final SecretKey a;
    private final byte[] b;
    private final byte[] c;
    public xc(byte[] bArr) {
        super();
        ed.b(bArr.length);
        SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, "AES");
        this.a = secretKeySpec;
        Cipher obj3 = xc.b();
        obj3.init(1, secretKeySpec);
        obj3 = ac.b(obj3.doFinal(new byte[16]));
        this.b = obj3;
        this.c = ac.b(obj3);
    }

    private static Cipher b() {
        return (Cipher)mc.e.a("AES/ECB/NoPadding");
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.c6
    public final byte[] a(byte[] bArr, int i2) {
        byte[] bArr2;
        byte[] bArr3;
        byte[] doFinal;
        int i3;
        int i;
        final int i4 = 16;
        if (i2 > i4) {
        } else {
            final Cipher cipher = xc.b();
            int i7 = 1;
            cipher.init(i7, this.a);
            int length = bArr.length;
            int i8 = Math.max(i7, (int)ceil);
            final int i14 = 0;
            if (i8 * 16 == length) {
                bArr2 = bc.e(bArr, i5 *= i4, this.b, i14, i4);
            } else {
                bArr2 = bc.d(ac.a(Arrays.copyOfRange(bArr, i12 *= i4, length)), this.c);
            }
            doFinal = new byte[i4];
            i3 = i14;
            while (i3 < i8 + -1) {
                doFinal = cipher.doFinal(bc.e(doFinal, i14, bArr, i3 * 16, i4));
                i3++;
            }
            return Arrays.copyOf(cipher.doFinal(bc.d(bArr2, doFinal)), i2);
        }
        InvalidAlgorithmParameterException obj9 = new InvalidAlgorithmParameterException("outputLength too large, max is 16 bytes");
        throw obj9;
    }
}
