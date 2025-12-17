package com.google.android.gms.internal.firebase-auth-api;

/* loaded from: classes2.dex */
final class cc extends com.google.android.gms.internal.firebase-auth-api.dc {
    cc(byte[] bArr, int i2) {
        super(bArr, i2);
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.dc
    final int b() {
        return 12;
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.dc
    final int[] c(int[] iArr, int i2) {
        int length = iArr.length;
        final int i4 = 0;
        final int i5 = 3;
        if (length != i5) {
        } else {
            int[] iArr2 = new int[16];
            dc.f(iArr2, this.a);
            System.arraycopy(iArr, i4, iArr2, 13, i5);
            return iArr2;
        }
        Object[] obj6 = new Object[1];
        obj6[i4] = Integer.valueOf(length *= 32);
        IllegalArgumentException obj5 = new IllegalArgumentException(String.format("ChaCha20 uses 96-bit nonces, but got a %d-bit nonce", obj6));
        throw obj5;
    }
}
