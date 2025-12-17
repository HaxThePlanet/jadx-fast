package com.google.android.gms.internal.firebase-auth-api;

import java.util.Arrays;

/* loaded from: classes2.dex */
final class wc {
    static byte[] a(byte[] bArr, byte[] b2Arr2) {
        int i14;
        int i5;
        int i18;
        int i6;
        int i16;
        int i15;
        int i8;
        int i3;
        int i7;
        int i2;
        int i;
        int i13;
        int i17;
        long l;
        int i11;
        int i12;
        int i10;
        int i9;
        int i4;
        byte[] bArr2 = bArr;
        Object obj = b2Arr2;
        if (bArr2.length != 32) {
        } else {
            int i30 = 0;
            long l2 = wc.b(bArr2, i30, i30);
            l4 &= i78;
            int i79 = 6;
            l5 &= i99;
            l6 &= i115;
            l7 &= i126;
            int i127 = 5;
            int i138 = i89 * i127;
            int i142 = i102 * i127;
            int i145 = i122 * i127;
            byte[] bArr4 = new byte[17];
            i6 = i30;
            i = i2;
            int length2 = obj.length;
            int i55 = 16;
            i13 = 67108863;
            i17 = 26;
            while (i6 < length2) {
                i15 = Math.min(i55, length2 -= i6);
                System.arraycopy(obj, i6, bArr4, i30, i15);
                bArr4[i15] = 1;
                if (i15 != i55) {
                }
                i += l13;
                i16 = 3;
                i3 += l;
                int i68 = 6;
                i8 += l14;
                i7 += l15;
                i2 += i57;
                i61 += i174;
                i179 += i184;
                i189 += i196;
                i201 += i191;
                i167 += i149;
                i2 = i168 & i13;
                i63 += i151;
                i = i64 & i13;
                i3 = i152 + i65;
                i6 += 16;
                i5 = i16;
                i7 = i12;
                i8 = i10;
                i14 = 17;
                i18 = 2;
                length2 = obj.length;
                i55 = 16;
                i13 = 67108863;
                i17 = 26;
                Arrays.fill(bArr4, i15++, i14, i30);
            }
            i8 += i40;
            int i41 = i153 & i13;
            i7 += i70;
            int i71 = i158 & i13;
            i2 += i76;
            int i77 = i161 & i13;
            i += i82;
            int i83 = i169 & i13;
            i90 += i103;
            i127 += i83;
            i104 += i91;
            i116 += i41;
            i134 += i71;
            i140 += i143;
            int i66 = i141 >> i20;
            int i31 = ~i66;
            i92 |= i107;
            i108 |= i119;
            i120 |= i137;
            long l8 = 4294967295L;
            i87 += l9;
            int i47 = 20;
            int i48 = 32;
            i97 += i130;
            i113 += i132;
            byte[] bArr3 = new byte[16];
            wc.d(bArr3, i88 & l8, obj5);
            wc.d(bArr3, i98 & l8, obj5);
            int i23 = 8;
            wc.d(bArr3, i114 & l8, obj5);
            i32 |= i67;
            wc.d(bArr3, i28 &= l8, i33);
            return bArr3;
        }
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException("The key length in bytes must be 32.");
        throw illegalArgumentException;
    }

    private static long b(byte[] bArr, int i2, int i3) {
        return obj2 &= i;
    }

    private static long c(byte[] bArr, int i2) {
        return obj2 &= l;
    }

    private static void d(byte[] bArr, long l2, int i3) {
        int i;
        int i2;
        byte b;
        int obj5;
        i = 0;
        while (i < 4) {
            bArr[obj7 + i] = (byte)i8;
            i++;
            obj5 >>= i2;
        }
    }
}
