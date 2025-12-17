package com.google.zxing.f;

import com.google.zxing.a;
import com.google.zxing.c;
import com.google.zxing.e;
import com.google.zxing.f.b.a;
import com.google.zxing.f.b.c;
import com.google.zxing.g.b;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Map;

/* loaded from: classes2.dex */
public final class a implements e {
    private static b b(String string, a a2, int i3, int i4, Charset charset5, int i6, int i7) {
        if (a2 != a.AZTEC) {
        } else {
            return a.c(c.d(string.getBytes(charset5), i6, i7), i3, i4);
        }
        IllegalArgumentException obj1 = new IllegalArgumentException("Can only encode AZTEC, but got ".concat(String.valueOf(a2)));
        throw obj1;
    }

    private static b c(a a, int i2, int i3) {
        int i;
        int i4;
        int i5;
        boolean z;
        int obj11;
        b obj9 = a.a();
        if (obj9 == null) {
        } else {
            final int i6 = obj9.f();
            final int i7 = obj9.e();
            int obj10 = Math.max(i2, i6);
            obj11 = Math.max(i3, i7);
            int i9 = Math.min(obj10 / i6, obj11 / i7);
            i15 /= 2;
            b bVar = new b(obj10, obj11);
            obj10 = 0;
            obj11 = obj10;
            while (obj11 < i7) {
                i4 = obj10;
                i5 = i13;
                while (i4 < i6) {
                    if (obj9.d(i4, obj11)) {
                    }
                    i4++;
                    i5 += i9;
                    bVar.h(i5, i, i9, i9);
                }
                obj11++;
                i += i9;
                if (obj9.d(i4, obj11)) {
                }
                i4++;
                i5 += i9;
                bVar.h(i5, i, i9, i9);
            }
            return bVar;
        }
        obj9 = new IllegalStateException();
        throw obj9;
    }

    public b a(String string, a a2, int i3, int i4, Map<c, ?> map5) {
        Charset forName;
        int int2;
        int int;
        c aZTEC_LAYERS;
        boolean key;
        String obj15;
        forName = StandardCharsets.ISO_8859_1;
        int2 = 33;
        int = 0;
        c cHARACTER_SET = c.CHARACTER_SET;
        if (map5 != null && map5.containsKey(cHARACTER_SET)) {
            cHARACTER_SET = c.CHARACTER_SET;
            if (map5.containsKey(cHARACTER_SET)) {
                forName = Charset.forName(map5.get(cHARACTER_SET).toString());
            }
            c eRROR_CORRECTION = c.ERROR_CORRECTION;
            if (map5.containsKey(eRROR_CORRECTION)) {
                int2 = Integer.parseInt(map5.get(eRROR_CORRECTION).toString());
            }
            aZTEC_LAYERS = c.AZTEC_LAYERS;
            if (map5.containsKey(aZTEC_LAYERS)) {
                int = Integer.parseInt(map5.get(aZTEC_LAYERS).toString());
            }
        }
        return a.b(string, a2, i3, i4, forName, int2, int);
    }
}
