package kotlin.i0.z.e.m0.e.a0.b;

import kotlin.d0.d.n;

/* loaded from: classes3.dex */
public final class i {
    public static final byte[] a(String[] stringArr) {
        int i8;
        int i5;
        int length;
        int i2;
        int i6;
        Object obj;
        int i;
        int i7;
        int i3;
        int i4;
        byte b;
        n.f(stringArr, "strings");
        final int i9 = 0;
        i5 = i8;
        while (i8 < stringArr.length) {
            i5 += length;
            i8++;
        }
        byte[] bArr = new byte[i5];
        i6 = i2;
        while (i2 < stringArr.length) {
            obj = stringArr[i2];
            i2++;
            length4--;
            if (i >= 0) {
            }
            i7 = i9;
            i4 = i6 + 1;
            bArr[i6] = (byte)charAt;
            while (i7 == i) {
                i7 = i3;
                i6 = i4;
                i4 = i6 + 1;
                bArr[i6] = (byte)charAt;
            }
            i7 = i3;
            i6 = i4;
            i6 = i4;
        }
        return bArr;
    }
}
