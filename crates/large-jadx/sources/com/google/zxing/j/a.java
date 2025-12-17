package com.google.zxing.j;

import com.google.zxing.a;
import com.google.zxing.c;
import com.google.zxing.e;
import com.google.zxing.g.b;
import com.google.zxing.j.b.a;
import com.google.zxing.j.b.c;
import com.google.zxing.j.b.d;
import com.google.zxing.j.b.e;
import java.lang.reflect.Array;
import java.nio.charset.Charset;
import java.util.Map;

/* loaded from: classes2.dex */
public final class a implements e {
    private static b b(byte[][] bArrArr, int i2) {
        int i4;
        int i;
        Object obj;
        int i3;
        int length;
        final int i5 = 0;
        int i9 = i2 * 2;
        b bVar = new b(length2 += i9, length3 += i9);
        bVar.b();
        int i10 = 1;
        i8 -= i10;
        i = i5;
        for (Object obj : bArrArr) {
            i3 = i5;
            while (i3 < obj3.length) {
                if (obj[i3] == i10) {
                }
                i3++;
                bVar.g(i3 + i2, i4);
            }
            i4--;
            if (obj[i3] == i10) {
            }
            i3++;
            bVar.g(i3 + i2, i4);
        }
        return bVar;
    }

    private static b c(e e, String string2, int i3, int i4, int i5, int i6) {
        int i;
        int i7;
        int i2;
        byte[][] obj4;
        byte[][] obj5;
        int obj7;
        e.e(string2, i3);
        final int obj6 = 1;
        obj5 = e.f().b(obj6, 4);
        int i9 = 0;
        i = i5 > i4 ? obj6 : i9;
        i2 = bArr2.length < obj5.length ? obj6 : i9;
        if (i != i2) {
            obj5 = a.d(obj5);
            i7 = obj6;
        } else {
            i7 = i9;
        }
        i5 /= length2;
        if (i4 /= length < obj8) {
        } else {
            obj7 = obj8;
        }
        if (obj7 > obj6 && i7 != 0) {
            if (i7 != 0) {
                obj4 = a.d(e.f().b(obj7, obj7 << 2));
            }
            return a.b(obj4, i6);
        }
        return a.b(obj5, i6);
    }

    private static byte[][] d(byte[][] bArrArr) {
        int i2;
        int[] iArr;
        int i;
        int length;
        byte b;
        final int i3 = 0;
        iArr = new int[2];
        final int i6 = 1;
        iArr[i6] = bArrArr.length;
        iArr[i3] = obj.length;
        Object instance = Array.newInstance(byte.class, iArr);
        i2 = i3;
        for (Object obj4 : bArrArr) {
            i = i3;
            while (i < obj3.length) {
                (byte[][])instance[i][i5 -= i6] = obj4[i];
                i++;
            }
            instance[i][iArr] = obj4[i];
            i++;
        }
        return instance;
    }

    public b a(String string, a a2, int i3, int i4, Map<c, ?> map5) {
        int int;
        c cHARACTER_SET;
        c pDF417_COMPACT;
        Enum pDF417_COMPACTION;
        c pDF417_DIMENSIONS;
        boolean key2;
        boolean key;
        int i;
        int i2;
        int obj9;
        Charset obj12;
        if (a2 != a.PDF_417) {
        } else {
            e eVar = new e();
            obj9 = 30;
            int = 2;
            pDF417_COMPACT = c.PDF417_COMPACT;
            if (map5 != null && map5.containsKey(pDF417_COMPACT)) {
                pDF417_COMPACT = c.PDF417_COMPACT;
                if (map5.containsKey(pDF417_COMPACT)) {
                    eVar.h(Boolean.valueOf(map5.get(pDF417_COMPACT).toString()).booleanValue());
                }
                pDF417_COMPACTION = c.PDF417_COMPACTION;
                if (map5.containsKey(pDF417_COMPACTION)) {
                    eVar.i(c.valueOf(map5.get(pDF417_COMPACTION).toString()));
                }
                pDF417_DIMENSIONS = c.PDF417_DIMENSIONS;
                if (map5.containsKey(pDF417_DIMENSIONS)) {
                    Object obj3 = map5.get(pDF417_DIMENSIONS);
                    eVar.j((d)obj3.a(), obj3.c(), obj3.b(), obj3.d());
                }
                c mARGIN = c.MARGIN;
                if (map5.containsKey(mARGIN)) {
                    obj9 = Integer.parseInt(map5.get(mARGIN).toString());
                }
                c eRROR_CORRECTION = c.ERROR_CORRECTION;
                if (map5.containsKey(eRROR_CORRECTION)) {
                    int = Integer.parseInt(map5.get(eRROR_CORRECTION).toString());
                }
                cHARACTER_SET = c.CHARACTER_SET;
                if (map5.containsKey(cHARACTER_SET)) {
                    eVar.k(Charset.forName(map5.get(cHARACTER_SET).toString()));
                }
            }
            return a.c(eVar, string, int, i3, i4, obj9);
        }
        IllegalArgumentException obj8 = new IllegalArgumentException("Can only encode PDF_417, but got ".concat(String.valueOf(a2)));
        throw obj8;
    }
}
