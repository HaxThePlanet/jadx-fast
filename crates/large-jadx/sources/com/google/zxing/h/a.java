package com.google.zxing.h;

import com.google.zxing.a;
import com.google.zxing.c;
import com.google.zxing.e;
import com.google.zxing.g.b;
import com.google.zxing.h.b.e;
import com.google.zxing.h.b.i;
import com.google.zxing.h.b.j;
import com.google.zxing.h.b.k;
import com.google.zxing.h.b.l;
import com.google.zxing.k.c.b;
import java.util.Map;

/* loaded from: classes2.dex */
public final class a implements e {
    private static b b(b b, int i2, int i3) {
        int i5;
        int i4;
        b bVar;
        int i6;
        byte b2;
        int i;
        int obj11;
        int obj12;
        final int i7 = b.e();
        final int i8 = b.d();
        int i9 = Math.max(i2, i7);
        int i11 = Math.max(i3, i8);
        int i14 = Math.min(i9 / i7, i11 / i8);
        i10 /= 2;
        i12 /= 2;
        int i18 = 0;
        if (i3 >= i8) {
            if (i2 < i7) {
                bVar = new b(i7, i8);
                i4 = i5;
            } else {
                bVar = new b(i2, i3);
            }
        } else {
        }
        bVar.b();
        obj11 = i18;
        while (obj11 < i8) {
            i6 = i5;
            obj12 = i18;
            while (obj12 < i7) {
                if (b.b(obj12, obj11) == 1) {
                }
                obj12++;
                i6 += i14;
                bVar.h(i6, i4, i14, i14);
            }
            obj11++;
            i4 += i14;
            if (b.b(obj12, obj11) == 1) {
            }
            obj12++;
            i6 += i14;
            bVar.h(i6, i4, i14, i14);
        }
        return bVar;
    }

    private static b c(e e, k k2, int i3, int i4) {
        int i7;
        int i5;
        int i6;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        int i;
        int i2;
        b bVar = new b(k2.j(), k2.i());
        int i16 = 0;
        i5 = i7;
        while (i7 < k2.g()) {
            i10 = 1;
            if (i7 % i18 == 0) {
            }
            i12 = i9;
            while (i9 < k2.h()) {
                if (i9 % i21 == 0) {
                }
                bVar.g(i12, i5, e.e(i9, i7));
                i12 += i10;
                int i23 = k2.d;
                if (i9 % i23 == i23 -= i10) {
                }
                i9++;
                if (i7 % 2 == 0) {
                } else {
                }
                i = i16;
                bVar.g(i12, i5, i);
                i12++;
                i = i10;
                bVar.g(i12, i5, i10);
                i12++;
            }
            i5++;
            int i19 = k2.e;
            if (i7 % i19 == i19 -= i10) {
            }
            i7++;
            i11 = i6;
            while (i6 < k2.j()) {
                bVar.g(i11, i5, i10);
                i11 += i10;
                i6++;
            }
            i5++;
            bVar.g(i11, i5, i10);
            i11 += i10;
            i6++;
            if (i9 % i21 == 0) {
            }
            bVar.g(i12, i5, e.e(i9, i7));
            i12 += i10;
            i23 = k2.d;
            if (i9 % i23 == i23 -= i10) {
            }
            i9++;
            if (i7 % 2 == 0) {
            } else {
            }
            i = i16;
            bVar.g(i12, i5, i);
            i12++;
            i = i10;
            bVar.g(i12, i5, i10);
            i12++;
            i11 = i8;
            while (i8 < k2.j()) {
                if (i8 % 2 == 0) {
                } else {
                }
                i = i16;
                bVar.g(i11, i5, i);
                i11 += i10;
                i8++;
                i = i10;
            }
            i5++;
            if (i8 % 2 == 0) {
            } else {
            }
            i = i16;
            bVar.g(i11, i5, i);
            i11 += i10;
            i8++;
            i = i10;
        }
        return a.b(bVar, i3, i4);
    }

    public b a(String string, a a2, int i3, int i4, Map<c, ?> map5) {
        int i2;
        int i;
        c mAX_SIZE;
        Object obj5;
        int obj8;
        if (string.isEmpty()) {
        } else {
            if (a2 != a.DATA_MATRIX) {
            } else {
                if (i3 < 0) {
                } else {
                    if (i4 < 0) {
                    } else {
                        obj5 = l.FORCE_NONE;
                        i2 = 0;
                        if (map5 != null) {
                            Object obj = map5.get(c.DATA_MATRIX_SHAPE);
                            if ((l)obj != null) {
                                obj5 = obj;
                            }
                            if ((b)map5.get(c.MIN_SIZE) != null) {
                            } else {
                                i = i2;
                            }
                            if ((b)map5.get(c.MAX_SIZE) != null) {
                            } else {
                                obj8 = i2;
                            }
                            i2 = i;
                        } else {
                            obj8 = i2;
                        }
                        String obj4 = j.b(string, obj5, i2, obj8);
                        obj5 = k.l(obj4.length(), obj5, i2, obj8, true);
                        obj8 = new e(i.c(obj4, obj5), obj5.h(), obj5.g());
                        obj8.h();
                        return a.c(obj8, obj5, i3, i4);
                    }
                }
                obj5 = new StringBuilder("Requested dimensions can't be negative: ");
                obj5.append(i3);
                obj5.append('x');
                obj5.append(i4);
                obj4 = new IllegalArgumentException(obj5.toString());
                throw obj4;
            }
            obj4 = new IllegalArgumentException("Can only encode DATA_MATRIX, but got ".concat(String.valueOf(a2)));
            throw obj4;
        }
        obj4 = new IllegalArgumentException("Found empty contents");
        throw obj4;
    }
}
