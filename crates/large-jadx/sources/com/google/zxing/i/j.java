package com.google.zxing.i;

import com.google.zxing.FormatException;
import com.google.zxing.a;
import com.google.zxing.c;
import com.google.zxing.g.b;
import java.util.Map;

/* loaded from: classes2.dex */
public final class j extends com.google.zxing.i.q {
    public b a(String string, a a2, int i3, int i4, Map<c, ?> map5) {
        if (a2 != a.EAN_13) {
        } else {
            return super.a(string, a2, i3, i4, map5);
        }
        IllegalArgumentException obj2 = new IllegalArgumentException("Can only encode EAN_13, but got ".concat(String.valueOf(a2)));
        throw obj2;
    }

    @Override // com.google.zxing.i.q
    public boolean[] c(String string) {
        boolean z;
        int i4;
        int stringBuilder;
        int[] iArr;
        int i5;
        int i2;
        int i3;
        int i;
        int digit;
        int[][] arr;
        Object obj11;
        int length = string.length();
        int i8 = 12;
        if (length != i8) {
            if (length != 13) {
            } else {
                if (!p.a(string)) {
                } else {
                    int i6 = 0;
                    final int i10 = 10;
                    boolean[] zArr = new boolean[95];
                    final int i13 = 1;
                    i12 += i6;
                    i3 = i13;
                    while (i3 <= 6) {
                        if (i16 &= i13 == i13) {
                        }
                        i5 += i;
                        i3++;
                        digit += 10;
                    }
                    i5 += i7;
                    i4 = 7;
                    while (i4 <= i8) {
                        i2 += iArr;
                        i4++;
                    }
                    n.b(zArr, i2, p.a, i13);
                    return zArr;
                }
                obj11 = new IllegalArgumentException("Contents do not pass checksum");
                throw obj11;
            }
            obj11 = new IllegalArgumentException("Requested contents should be 12 or 13 digits long, but got ".concat(String.valueOf(length)));
            throw obj11;
        }
        stringBuilder = new StringBuilder();
        stringBuilder.append(string);
        stringBuilder.append(p.b(string));
        obj11 = stringBuilder.toString();
    }
}
