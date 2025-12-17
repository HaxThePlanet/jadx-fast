package com.google.zxing.i;

import com.google.zxing.FormatException;
import com.google.zxing.a;
import com.google.zxing.c;
import com.google.zxing.g.b;
import java.util.Map;

/* loaded from: classes2.dex */
public final class k extends com.google.zxing.i.q {
    public b a(String string, a a2, int i3, int i4, Map<c, ?> map5) {
        if (a2 != a.EAN_8) {
        } else {
            return super.a(string, a2, i3, i4, map5);
        }
        IllegalArgumentException obj2 = new IllegalArgumentException("Can only encode EAN_8, but got ".concat(String.valueOf(a2)));
        throw obj2;
    }

    @Override // com.google.zxing.i.q
    public boolean[] c(String string) {
        int i6;
        StringBuilder stringBuilder;
        int i4;
        int i7;
        int i;
        int i2;
        int[] iArr;
        int i5;
        int i3;
        int[][] arr;
        Object obj9;
        int length = string.length();
        int i9 = 7;
        if (length != i9) {
            if (length != 8) {
            } else {
                if (!p.a(string)) {
                } else {
                    boolean[] zArr = new boolean[67];
                    int i11 = 0;
                    final int i13 = 1;
                    i10 += i11;
                    i2 = i11;
                    int i14 = 10;
                    while (i2 <= 3) {
                        i4 += i5;
                        i2++;
                        i14 = 10;
                    }
                    try {
                        i4 += i12;
                        i = 4;
                        while (i <= i9) {
                            i7 += iArr;
                            i++;
                        }
                        i7 += iArr;
                        i++;
                        n.b(zArr, i7, p.a, i13);
                        return zArr;
                        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(string);
                        throw illegalArgumentException;
                    } catch (com.google.zxing.FormatException format) {
                    }
                }
                obj9 = new IllegalArgumentException("Contents do not pass checksum");
                throw obj9;
            }
            obj9 = new IllegalArgumentException("Requested contents should be 8 digits long, but got ".concat(String.valueOf(length)));
            throw obj9;
        }
        stringBuilder = new StringBuilder();
        stringBuilder.append(string);
        stringBuilder.append(p.b(string));
        obj9 = stringBuilder.toString();
    }
}
