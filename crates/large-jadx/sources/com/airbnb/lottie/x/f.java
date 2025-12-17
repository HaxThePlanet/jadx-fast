package com.airbnb.lottie.x;

import android.graphics.Color;
import com.airbnb.lottie.x.k0.c;
import com.airbnb.lottie.x.k0.c.b;

/* loaded from: classes.dex */
public class f implements com.airbnb.lottie.x.j0<Integer> {

    public static final com.airbnb.lottie.x.f a;
    static {
        f fVar = new f();
        f.a = fVar;
    }

    @Override // com.airbnb.lottie.x.j0
    public Object a(c c, float f2) {
        return b(c, f2);
    }

    @Override // com.airbnb.lottie.x.j0
    public Integer b(c c, float f2) {
        double d;
        double d2;
        double d3;
        double d4;
        long cmp;
        int obj11;
        int obj12;
        obj12 = c.w() == c.b.BEGIN_ARRAY ? 1 : 0;
        if (obj12 != null) {
            c.c();
        }
        d = c.m();
        d2 = c.m();
        d3 = c.m();
        cmp = 4607182418800017408L;
        if (c.w() == c.b.NUMBER) {
            d4 = c.m();
        } else {
            d4 = cmp;
        }
        if (obj12 != null) {
            c.f();
        }
        obj11 = 4643176031446892544L;
        d *= obj11;
        d2 *= obj11;
        d3 *= obj11;
        if (Double.compare(d, cmp) <= 0 && Double.compare(d2, cmp) <= 0 && Double.compare(d3, cmp) <= 0 && Double.compare(d4, cmp) <= 0) {
            if (Double.compare(d2, cmp) <= 0) {
                if (Double.compare(d3, cmp) <= 0) {
                    obj11 = 4643176031446892544L;
                    d *= obj11;
                    d2 *= obj11;
                    d3 *= obj11;
                    if (Double.compare(d4, cmp) <= 0) {
                        d4 *= obj11;
                    }
                }
            }
        }
        return Integer.valueOf(Color.argb((int)d4, (int)d, (int)d2, (int)d3));
    }
}
