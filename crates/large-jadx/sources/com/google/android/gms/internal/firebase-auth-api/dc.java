package com.google.android.gms.internal.firebase-auth-api;

import com.google.firebase.perf.R.attr;
import com.google.firebase.perf.R.styleable;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.IntBuffer;
import java.security.GeneralSecurityException;
import java.security.InvalidKeyException;

/* loaded from: classes2.dex */
abstract class dc implements com.google.android.gms.internal.firebase-auth-api.uc {

    private static final int[] c;
    int[] a;
    private final int b;
    static {
        byte[] bArr = new byte[16];
        bArr = new byte[]{101, 120, 112, 97, 110, 100, 32, 51, 50, 45, 98, 121, 116, 101, 32, 107};
        dc.c = dc.i(bArr);
    }

    dc(byte[] bArr, int i2) {
        super();
        if (bArr.length != 32) {
        } else {
            this.a = dc.i(bArr);
            this.b = i2;
        }
        InvalidKeyException obj3 = new InvalidKeyException("The key length in bytes must be 32.");
        throw obj3;
    }

    static void e(int[] iArr, int i2, int i3, int i4, int i5) {
        i += i15;
        iArr[i2] = i6;
        i6 ^= i16;
        i8 |= i17;
        iArr[i5] = i9;
        i18 += i9;
        iArr[i4] = i19;
        i10 ^= i19;
        i12 |= i20;
        iArr[i3] = i13;
        i21 += i13;
        iArr[i2] = i22;
        obj3 ^= i22;
        obj3 |= i14;
        iArr[i5] = obj3;
        obj6 += obj3;
        iArr[i4] = obj6;
        obj3 ^= obj6;
        iArr[i3] = obj3 |= obj5;
    }

    static void f(int[] iArr, int[] i2Arr2) {
        int[] iArr2 = dc.c;
        final int i2 = 0;
        System.arraycopy(iArr2, i2, iArr, i2, iArr2.length);
        System.arraycopy(i2Arr2, i2, iArr, iArr2.length, 8);
    }

    static void g(int[] iArr) {
        int i13;
        int i11;
        int i9;
        int i14;
        int i7;
        int i10;
        int i12;
        int i5;
        int i;
        int i2;
        int i3;
        int i4;
        int i6;
        int i8;
        final int[] iArr2 = iArr;
        final int i15 = 0;
        i13 = i15;
        int i16 = 10;
        while (i13 < i16) {
            i14 = 8;
            i7 = 12;
            dc.e(iArr2, i15, 4, i14, i7);
            i10 = 1;
            i12 = 5;
            i = 13;
            dc.e(iArr2, i10, i12, 9, i);
            i2 = 2;
            i3 = 6;
            i4 = 14;
            dc.e(iArr2, i2, i3, i16, i4);
            i6 = 3;
            i8 = 7;
            int i18 = 11;
            i5 = 15;
            dc.e(iArr2, i6, i8, i18, i5);
            dc.e(iArr2, i15, i12, i16, i5);
            dc.e(iArr2, i10, i3, i18, i7);
            dc.e(iArr2, i2, i8, i14, i);
            dc.e(iArr2, i6, 4, 9, i4);
            i13++;
            i16 = 10;
        }
    }

    static int[] i(byte[] bArr) {
        IntBuffer obj1 = ByteBuffer.wrap(bArr).order(ByteOrder.LITTLE_ENDIAN).asIntBuffer();
        int[] iArr = new int[obj1.remaining()];
        obj1.get(iArr);
        return iArr;
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.uc
    public final byte[] a(byte[] bArr) {
        return h(ByteBuffer.wrap(bArr));
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.uc
    abstract int b();

    @Override // com.google.android.gms.internal.firebase-auth-api.uc
    abstract int[] c(int[] iArr, int i2);

    @Override // com.google.android.gms.internal.firebase-auth-api.uc
    final ByteBuffer d(byte[] bArr, int i2) {
        int i3;
        int i;
        int i4;
        int[] obj5 = c(dc.i(bArr), i2);
        Object obj6 = obj5.clone();
        dc.g((int[])obj6);
        final int i5 = 0;
        i3 = i5;
        int i6 = 16;
        while (i3 < i6) {
            obj5[i3] = i7 += i4;
            i3++;
            i6 = 16;
        }
        obj6 = ByteBuffer.allocate(64).order(ByteOrder.LITTLE_ENDIAN);
        obj6.asIntBuffer().put(obj5, i5, i6);
        return obj6;
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.uc
    final byte[] h(ByteBuffer byteBuffer) {
        int i;
        ByteBuffer byteBuffer2;
        int i3;
        int i2;
        if (byteBuffer.remaining() < b()) {
        } else {
            byte[] bArr = new byte[b()];
            byteBuffer.get(bArr);
            ByteBuffer allocate = ByteBuffer.allocate(byteBuffer.remaining());
            final int remaining3 = byteBuffer.remaining();
            i6++;
            i = 0;
            while (i < i7) {
                byteBuffer2 = d(bArr, i8 += i);
                if (i == i7 + -1) {
                } else {
                }
                bc.a(allocate, byteBuffer, byteBuffer2, 64);
                i++;
                bc.a(allocate, byteBuffer, byteBuffer2, remaining3 % 64);
            }
            return allocate.array();
        }
        GeneralSecurityException obj9 = new GeneralSecurityException("ciphertext too short");
        throw obj9;
    }
}
