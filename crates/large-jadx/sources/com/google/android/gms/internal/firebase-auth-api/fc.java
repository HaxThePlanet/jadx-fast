package com.google.android.gms.internal.firebase-auth-api;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.security.GeneralSecurityException;
import javax.crypto.AEADBadTagException;

/* loaded from: classes2.dex */
abstract class fc implements com.google.android.gms.internal.firebase-auth-api.u1 {

    private final com.google.android.gms.internal.firebase-auth-api.dc a;
    private final com.google.android.gms.internal.firebase-auth-api.dc b;
    public fc(byte[] bArr) {
        super();
        this.a = c(bArr, 1);
        this.b = c(bArr, 0);
    }

    private final byte[] d(ByteBuffer byteBuffer, byte[] b2Arr2) {
        int i;
        int i2;
        int i5 = 16;
        if (byteBuffer.remaining() < i3 += i5) {
        } else {
            int position = byteBuffer.position();
            byte[] bArr = new byte[i5];
            byteBuffer.position(limit += -16);
            byteBuffer.get(bArr);
            byteBuffer.position(position);
            byteBuffer.limit(limit2 += -16);
            byte[] bArr2 = new byte[this.a.b()];
            byteBuffer.get(bArr2);
            byte[] bArr3 = new byte[32];
            this.b.d(bArr2, 0).get(bArr3);
            int length = b2Arr2.length;
            int i11 = length & 15;
            i = i11 == 0 ? length : i12 - i11;
            int remaining2 = byteBuffer.remaining();
            int i13 = remaining2 % 16;
            i2 = i13 == 0 ? remaining2 : i16 - i13;
            i2 += i;
            final ByteOrder lITTLE_ENDIAN = ByteOrder.LITTLE_ENDIAN;
            ByteBuffer order = ByteBuffer.allocate(i15 + 16).order(lITTLE_ENDIAN);
            order.put(b2Arr2);
            order.position(i);
            order.put(byteBuffer);
            order.position(i15);
            order.putLong((long)length);
            order.putLong((long)remaining2);
            if (!bc.b(wc.a(bArr3, order.array()), bArr)) {
            } else {
                byteBuffer.position(position);
                return this.a.h(byteBuffer);
            }
            GeneralSecurityException obj10 = new GeneralSecurityException("invalid MAC");
            throw obj10;
        }
        obj10 = new GeneralSecurityException("ciphertext too short");
        throw obj10;
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.u1
    public final byte[] a(byte[] bArr, byte[] b2Arr2) {
        return d(ByteBuffer.wrap(bArr), b2Arr2);
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.u1
    public final byte[] b(byte[] bArr, byte[] b2Arr2) {
        throw 0;
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.u1
    abstract com.google.android.gms.internal.firebase-auth-api.dc c(byte[] bArr, int i2);
}
