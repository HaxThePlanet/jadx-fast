package com.google.zxing.i;

import com.google.zxing.a;
import com.google.zxing.c;
import com.google.zxing.e;
import com.google.zxing.g.b;
import java.util.Map;

/* loaded from: classes2.dex */
public abstract class n implements e {
    protected static int b(boolean[] zArr, int i2, int[] i3Arr3, boolean z4) {
        int i;
        int i4;
        int i6;
        int i5;
        int i3;
        int obj8;
        boolean obj10;
        final int i7 = 0;
        i4 = i;
        while (i < i3Arr3.length) {
            i6 = i3Arr3[i];
            i5 = i7;
            while (i5 < i6) {
                zArr[obj8] = obj10;
                i5++;
                obj8 = i3;
            }
            i4 += i6;
            obj10 ^= 1;
            i++;
            zArr[obj8] = obj10;
            i5++;
            obj8 = i3;
        }
        return i4;
    }

    private static b e(boolean[] zArr, int i2, int i3, int i4) {
        int i5;
        int i;
        boolean z;
        final int length = zArr.length;
        i4 += length;
        int obj6 = Math.max(i2, obj8);
        final int obj7 = Math.max(1, i3);
        int obj8 = obj6 / obj8;
        i8 /= 2;
        b bVar = new b(obj6, obj7);
        obj6 = 0;
        i = obj6;
        while (i < length) {
            if (zArr[i]) {
            }
            i++;
            i5 += obj8;
            bVar.h(i5, obj6, obj8, obj7);
        }
        return bVar;
    }

    public b a(String string, a a2, int i3, int i4, Map<c, ?> map5) {
        c mARGIN;
        boolean key;
        int obj4;
        if (string.isEmpty()) {
        } else {
            if (i3 < 0) {
            } else {
                if (i4 < 0) {
                } else {
                    obj4 = d();
                    mARGIN = c.MARGIN;
                    if (map5 != null && map5.containsKey(mARGIN)) {
                        mARGIN = c.MARGIN;
                        if (map5.containsKey(mARGIN)) {
                            obj4 = Integer.parseInt(map5.get(mARGIN).toString());
                        }
                    }
                    return n.e(c(string), i3, i4, obj4);
                }
            }
            obj4 = new StringBuilder("Negative size is not allowed. Input: ");
            obj4.append(i3);
            obj4.append('x');
            obj4.append(i4);
            IllegalArgumentException obj3 = new IllegalArgumentException(obj4.toString());
            throw obj3;
        }
        obj3 = new IllegalArgumentException("Found empty contents");
        throw obj3;
    }

    @Override // com.google.zxing.e
    public abstract boolean[] c(String string);

    @Override // com.google.zxing.e
    public int d() {
        return 10;
    }
}
