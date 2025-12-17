package com.google.zxing.k;

import com.google.zxing.a;
import com.google.zxing.c;
import com.google.zxing.e;
import com.google.zxing.g.b;
import com.google.zxing.k.b.a;
import com.google.zxing.k.c.b;
import com.google.zxing.k.c.c;
import com.google.zxing.k.c.f;
import java.util.Map;

/* loaded from: classes2.dex */
public final class a implements e {
    private static b b(f f, int i2, int i3, int i4) {
        int i6;
        int i;
        int i5;
        byte b;
        int obj11;
        b obj9 = f.a();
        if (obj9 == null) {
        } else {
            final int i7 = obj9.e();
            final int i8 = obj9.d();
            final int i9 = 1;
            i4 <<= i9;
            int i10 = i7 + obj12;
            obj12 += i8;
            int obj10 = Math.max(i2, i10);
            obj11 = Math.max(i3, obj12);
            int obj12 = Math.min(obj10 / i10, obj11 / obj12);
            i16 /= 2;
            b bVar = new b(obj10, obj11);
            obj10 = 0;
            obj11 = obj10;
            while (obj11 < i8) {
                i = obj10;
                i5 = i14;
                while (i < i7) {
                    if (obj9.b(i, obj11) == i9) {
                    }
                    i++;
                    i5 += obj12;
                    bVar.h(i5, i6, obj12, obj12);
                }
                obj11++;
                i6 += obj12;
                if (obj9.b(i, obj11) == i9) {
                }
                i++;
                i5 += obj12;
                bVar.h(i5, i6, obj12, obj12);
            }
            return bVar;
        }
        obj9 = new IllegalStateException();
        throw obj9;
    }

    public b a(String string, a a2, int i3, int i4, Map<c, ?> map5) {
        int int;
        c mARGIN;
        boolean key;
        a obj5;
        if (string.isEmpty()) {
        } else {
            if (a2 != a.QR_CODE) {
            } else {
                if (i3 < 0) {
                } else {
                    if (i4 < 0) {
                    } else {
                        obj5 = a.L;
                        int = 4;
                        c eRROR_CORRECTION = c.ERROR_CORRECTION;
                        if (map5 != null && map5.containsKey(eRROR_CORRECTION)) {
                            eRROR_CORRECTION = c.ERROR_CORRECTION;
                            if (map5.containsKey(eRROR_CORRECTION)) {
                                obj5 = a.valueOf(map5.get(eRROR_CORRECTION).toString());
                            }
                            mARGIN = c.MARGIN;
                            if (map5.containsKey(mARGIN)) {
                                int = Integer.parseInt(map5.get(mARGIN).toString());
                            }
                        }
                        return a.b(c.n(string, obj5, map5), i3, i4, int);
                    }
                }
                obj5 = new StringBuilder("Requested dimensions are too small: ");
                obj5.append(i3);
                obj5.append('x');
                obj5.append(i4);
                IllegalArgumentException obj4 = new IllegalArgumentException(obj5.toString());
                throw obj4;
            }
            obj4 = new IllegalArgumentException("Can only encode QR_CODE, but got ".concat(String.valueOf(a2)));
            throw obj4;
        }
        obj4 = new IllegalArgumentException("Found empty contents");
        throw obj4;
    }
}
