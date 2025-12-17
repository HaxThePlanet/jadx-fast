package com.google.android.gms.internal.firebase-auth-api;

import java.util.Arrays;

/* loaded from: classes2.dex */
final class ac {
    static byte[] a(byte[] bArr) {
        int length = bArr.length;
        int i = 16;
        if (length >= i) {
        } else {
            byte[] obj2 = Arrays.copyOf(bArr, i);
            obj2[length] = -128;
            return obj2;
        }
        obj2 = new IllegalArgumentException("x must be smaller than a block.");
        throw obj2;
    }

    static byte[] b(byte[] bArr) {
        int i2;
        int i;
        byte b;
        int i3 = 16;
        if (bArr.length != i3) {
        } else {
            byte[] bArr2 = new byte[i3];
            final int i4 = 0;
            i2 = i4;
            i = 15;
            while (i2 < i3) {
                byte b4 = bArr[i2];
                b = (byte)i10;
                bArr2[i2] = b;
                if (i2 < i) {
                }
                i2++;
                i = 15;
                bArr2[i2] = (byte)i8;
            }
            bArr2[i] = (byte)obj6;
            return bArr2;
        }
        IllegalArgumentException obj6 = new IllegalArgumentException("value must be a block.");
        throw obj6;
    }
}
