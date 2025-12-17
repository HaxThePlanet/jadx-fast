package com.google.zxing.i;

import com.google.zxing.FormatException;
import com.google.zxing.a;
import com.google.zxing.c;
import com.google.zxing.g.b;
import java.util.Map;

/* loaded from: classes2.dex */
public final class s extends com.google.zxing.i.q {
    public b a(String string, a a2, int i3, int i4, Map<c, ?> map5) {
        if (a2 != a.UPC_E) {
        } else {
            return super.a(string, a2, i3, i4, map5);
        }
        IllegalArgumentException obj2 = new IllegalArgumentException("Can only encode UPC_E, but got ".concat(String.valueOf(a2)));
        throw obj2;
    }

    @Override // com.google.zxing.i.q
    public boolean[] c(String string) {
        boolean z;
        int stringBuilder;
        int i3;
        int i2;
        int i;
        int digit;
        int[][] arr;
        Object obj10;
        int length = string.length();
        int i5 = 7;
        if (length != i5) {
            if (length != 8) {
            } else {
                if (!p.a(string)) {
                } else {
                    int i4 = 0;
                    final int i8 = 10;
                    int digit3 = Character.digit(obj10.charAt(i4), i8);
                    final int i9 = 1;
                    if (digit3 != 0) {
                        if (digit3 != i9) {
                        } else {
                        }
                        try {
                            obj10 = new IllegalArgumentException("Number system must be 0 or 1");
                            throw obj10;
                            boolean[] zArr = new boolean[51];
                            i10 += i4;
                            i2 = i9;
                            while (i2 <= 6) {
                                if (i13 &= i9 == i9) {
                                }
                                i3 += i;
                                i2++;
                                digit += 10;
                            }
                            if (i13 &= i9 == i9) {
                            }
                            digit += 10;
                            i3 += i;
                            i2++;
                            n.b(zArr, i3, p.c, i4);
                            return zArr;
                            IllegalArgumentException illegalArgumentException = new IllegalArgumentException(string);
                            throw illegalArgumentException;
                        } catch (com.google.zxing.FormatException format) {
                        }
                    }
                }
                obj10 = new IllegalArgumentException("Contents do not pass checksum");
                throw obj10;
            }
            obj10 = new IllegalArgumentException("Requested contents should be 8 digits long, but got ".concat(String.valueOf(length)));
            throw obj10;
        }
        stringBuilder = new StringBuilder();
        stringBuilder.append(string);
        stringBuilder.append(p.b(r.c(string)));
        obj10 = stringBuilder.toString();
    }
}
