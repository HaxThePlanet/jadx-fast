package com.google.android.gms.internal.firebase-auth-api;

import java.util.Arrays;

/* loaded from: classes2.dex */
final class fd extends com.google.android.gms.internal.firebase-auth-api.dc {
    fd(byte[] bArr, int i2) {
        super(bArr, i2);
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.dc
    final int b() {
        return 24;
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.dc
    final int[] c(int[] iArr, int i2) {
        int length = iArr.length;
        int i4 = 1;
        int i15 = 6;
        final int i17 = 0;
        if (length != i15) {
        } else {
            int i = 16;
            final int[] iArr3 = new int[i];
            int[] iArr2 = new int[i];
            dc.f(iArr2, this.a);
            final int i20 = 12;
            iArr2[i20] = iArr[i17];
            int i19 = 13;
            iArr2[i19] = iArr[i4];
            final int i21 = 14;
            iArr2[i21] = iArr[2];
            final int i22 = 15;
            iArr2[i22] = iArr[3];
            dc.g(iArr2);
            final int i23 = 4;
            iArr2[i23] = iArr2[i20];
            final int i24 = 5;
            iArr2[i24] = iArr2[i19];
            iArr2[i15] = iArr2[i21];
            iArr2[7] = iArr2[i22];
            dc.f(iArr3, Arrays.copyOf(iArr2, 8));
            iArr3[i20] = i2;
            iArr3[i19] = i17;
            iArr3[i21] = iArr[i23];
            iArr3[i22] = iArr[i24];
            return iArr3;
        }
        Object[] obj13 = new Object[i4];
        obj13[i17] = Integer.valueOf(length *= 32);
        IllegalArgumentException obj12 = new IllegalArgumentException(String.format("XChaCha20 uses 192-bit nonces, but got a %d-bit nonce", obj13));
        throw obj12;
    }
}
