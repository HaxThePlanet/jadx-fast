package com.airbnb.lottie.x;

import android.graphics.Color;
import com.airbnb.lottie.x.k0.c;
import com.airbnb.lottie.x.k0.c.b;

/* compiled from: ColorParser.java */
/* loaded from: classes.dex */
public class f implements j0<Integer> {

    public static final f a = new f();

    private f() {
        super();
    }

    public Integer b(c cVar, float f) {
        double d;
        double d2;
        double d3;
        double d4;
        int i = 1;
        f = cVar.w() == c.b.BEGIN_ARRAY ? 1 : 0;
        if (i != 0) {
            cVar.c();
        }
        d = cVar.m();
        d2 = cVar.m();
        d3 = cVar.m();
        double d5 = 1d;
        if (cVar.w() == c.b.NUMBER) {
            d4 = cVar.m();
        } else {
            long l = d5;
        }
        if (i != 0) {
            cVar.f();
        }
        if (d <= d5) {
            if (d2 <= d5) {
                if (d3 <= d5) {
                    double d6 = 255d;
                    d = d * d6;
                    d2 = d2 * d6;
                    d3 = d3 * d6;
                    if (d4 <= d5) {
                        d4 = d4 * d6;
                    }
                }
            }
        }
        return Integer.valueOf(Color.argb((int)d4, (int)d, (int)d2, (int)d3));
    }
}
