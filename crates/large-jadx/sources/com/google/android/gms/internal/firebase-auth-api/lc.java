package com.google.android.gms.internal.firebase-auth-api;

import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import java.util.Arrays;

/* loaded from: classes2.dex */
public final class lc implements com.google.android.gms.internal.firebase-auth-api.u1 {

    private final com.google.android.gms.internal.firebase-auth-api.uc a;
    private final com.google.android.gms.internal.firebase-auth-api.q2 b;
    private final int c;
    public lc(com.google.android.gms.internal.firebase-auth-api.uc uc, com.google.android.gms.internal.firebase-auth-api.q2 q22, int i3) {
        super();
        this.a = uc;
        this.b = q22;
        this.c = i3;
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.u1
    public final byte[] a(byte[] bArr, byte[] b2Arr2) {
        int length = bArr.length;
        int i2 = this.c;
        if (length < i2) {
        } else {
            final int i4 = 0;
            byte[] copyOfRange = Arrays.copyOfRange(bArr, i4, length - i2);
            int i = 8;
            byte[][] bArr2 = new byte[3];
            bArr2[i4] = b2Arr2;
            bArr2[1] = copyOfRange;
            bArr2[2] = Arrays.copyOf(ByteBuffer.allocate(i).putLong(l *= i9).array(), i);
            this.b.a(Arrays.copyOfRange(bArr, length - i5, length), bc.c(bArr2));
            return this.a.a(copyOfRange);
        }
        GeneralSecurityException obj9 = new GeneralSecurityException("ciphertext too short");
        throw obj9;
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.u1
    public final byte[] b(byte[] bArr, byte[] b2Arr2) {
        throw 0;
    }
}
