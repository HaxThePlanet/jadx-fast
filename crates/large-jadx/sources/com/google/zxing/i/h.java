package com.google.zxing.i;

import com.google.zxing.a;
import com.google.zxing.c;
import com.google.zxing.g.b;
import java.util.Map;

/* loaded from: classes2.dex */
public class h extends com.google.zxing.i.n {
    private static int f(boolean[] zArr, int i2, int[] i3Arr3) {
        int i4;
        int i;
        int i3;
        int obj6;
        final int i5 = 0;
        i4 = i5;
        while (i4 < i3Arr3.length) {
            if (i3Arr3[i4] != 0) {
            } else {
            }
            i = i5;
            zArr[obj6] = i;
            i4++;
            obj6 = i3;
            i = 1;
        }
        return 9;
    }

    private static int g(String string, int i2) {
        int i5;
        int i;
        int i4;
        int i3;
        String str;
        final int i6 = 1;
        length -= i6;
        i = 0;
        i4 = i6;
        while (i5 >= 0) {
            i += i3;
            if (i4 += i6 > i2) {
            }
            i5--;
            i4 = i6;
        }
        return i %= 47;
    }

    private static void h(int i, int[] i2Arr2) {
        int i3;
        int i4;
        int i2;
        final int i5 = 0;
        i3 = i5;
        while (i3 < 9) {
            if (i8 &= i == 0) {
            }
            i2Arr2[i3] = i2;
            i3++;
            i2 = i5;
        }
    }

    public b a(String string, a a2, int i3, int i4, Map<c, ?> map5) {
        if (a2 != a.CODE_93) {
        } else {
            return super.a(string, a2, i3, i4, map5);
        }
        IllegalArgumentException obj2 = new IllegalArgumentException("Can only encode CODE_93, but got ".concat(String.valueOf(a2)));
        throw obj2;
    }

    @Override // com.google.zxing.i.n
    public boolean[] c(String string) {
        int i2;
        int i3;
        int i;
        int[] iArr;
        int length = string.length();
        if (length > 80) {
        } else {
            int i8 = 9;
            final int[] iArr2 = new int[i8];
            int i9 = 1;
            final int i15 = 47;
            h.h(g.a[i15], iArr2);
            boolean[] zArr = new boolean[i12 += i9];
            i3 = h.f(zArr, 0, iArr2);
            String str2 = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%abcd*";
            while (i2 < length) {
                h.h(g.a[str2.indexOf(string.charAt(i2))], iArr2);
                i3 += i;
                i2++;
                str2 = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%abcd*";
            }
            int i5 = h.g(string, 20);
            int[] iArr4 = g.a;
            h.h(iArr4[i5], iArr2);
            i3 += i21;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(string);
            stringBuilder.append(str2.charAt(i5));
            h.h(iArr4[h.g(stringBuilder.toString(), 15)], iArr2);
            i16 += obj10;
            h.h(iArr4[i15], iArr2);
            zArr[i17 += obj10] = i9;
            return zArr;
        }
        IllegalArgumentException obj10 = new IllegalArgumentException("Requested contents should be less than 80 digits long, but got ".concat(String.valueOf(length)));
        throw obj10;
    }
}
