package com.google.zxing.i;

import com.google.zxing.a;
import com.google.zxing.c;
import com.google.zxing.g.b;
import java.util.Map;

/* loaded from: classes2.dex */
public final class f extends com.google.zxing.i.n {
    private static void f(int i, int[] i2Arr2) {
        int i4;
        int i2;
        int i3;
        i4 = 0;
        while (i4 < 9) {
            if (i7 &= i == 0) {
            } else {
            }
            i3 = 2;
            i2Arr2[i4] = i3;
            i4++;
        }
    }

    private static String g(String string) {
        int i;
        String charAt;
        int i3;
        int i2;
        int i4;
        StringBuilder stringBuilder = new StringBuilder();
        i = 0;
        while (i < string.length()) {
            charAt = string.charAt(i);
            stringBuilder.append("%U");
            i++;
            i3 = 32;
            stringBuilder.append(charAt);
            stringBuilder.append("%V");
            stringBuilder.append("%W");
            i2 = 37;
            i4 = 47;
            stringBuilder.append(i4);
            stringBuilder.append((char)i8);
            stringBuilder.append(i2);
            stringBuilder.append((char)i12);
            stringBuilder.append('+');
            stringBuilder.append((char)i10);
            stringBuilder.append(i2);
            stringBuilder.append((char)i14);
            stringBuilder.append((char)i16);
            stringBuilder.append(i2);
            stringBuilder.append((char)i18);
            stringBuilder.append((char)i20);
            stringBuilder.append(i2);
            stringBuilder.append((char)i22);
            stringBuilder.append('$');
            stringBuilder.append((char)i6);
        }
        return stringBuilder.toString();
    }

    public b a(String string, a a2, int i3, int i4, Map<c, ?> map5) {
        if (a2 != a.CODE_39) {
        } else {
            return super.a(string, a2, i3, i4, map5);
        }
        IllegalArgumentException obj2 = new IllegalArgumentException("Can only encode CODE_39, but got ".concat(String.valueOf(a2)));
        throw obj2;
    }

    @Override // com.google.zxing.i.n
    public boolean[] c(String string) {
        int length;
        int i4;
        int i7;
        String str;
        int indexOf;
        int i6;
        int i3;
        int i;
        int[] iArr;
        int i5;
        int i2;
        int[] iArr2;
        String obj13;
        length = string.length();
        String str3 = "Requested contents should be less than 80 digits long, but got ";
        int i9 = 80;
        if (length > i9) {
        } else {
            final int i10 = 0;
            i4 = i10;
            str = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%";
            while (i4 < length) {
                i4++;
                str = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%";
            }
            int i8 = 9;
            int[] iArr3 = new int[i8];
            i7 = length + 25;
            i6 = i10;
            while (i6 < length) {
                f.f(e.a[str.indexOf(obj13.charAt(i6))], iArr3);
                i3 = i10;
                while (i3 < i8) {
                    i7 += iArr;
                    i3++;
                }
                i6++;
                i7 += iArr;
                i3++;
            }
            boolean[] zArr = new boolean[i7];
            int i11 = 148;
            f.f(i11, iArr3);
            int i12 = 1;
            int i13 = n.b(zArr, i10, iArr3, i12);
            int[] iArr4 = new int[i12];
            iArr4[i10] = i12;
            i13 += i16;
            i5 = i10;
            while (i5 < length) {
                f.f(e.a[str.indexOf(obj13.charAt(i5))], iArr3);
                i += i18;
                i14 += i2;
                i5++;
            }
            f.f(i11, iArr3);
            n.b(zArr, i, iArr3, i12);
            return zArr;
        }
        obj13 = new IllegalArgumentException(str3.concat(String.valueOf(length)));
        throw obj13;
    }
}
