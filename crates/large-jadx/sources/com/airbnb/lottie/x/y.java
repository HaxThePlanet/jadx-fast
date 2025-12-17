package com.airbnb.lottie.x;

import android.graphics.PointF;
import com.airbnb.lottie.x.k0.c;
import com.airbnb.lottie.x.k0.c.b;

/* loaded from: classes.dex */
public class y implements com.airbnb.lottie.x.j0<PointF> {

    public static final com.airbnb.lottie.x.y a;
    static {
        y yVar = new y();
        y.a = yVar;
    }

    @Override // com.airbnb.lottie.x.j0
    public Object a(c c, float f2) {
        return b(c, f2);
    }

    @Override // com.airbnb.lottie.x.j0
    public PointF b(c c, float f2) {
        float obj6;
        c.b bVar = c.w();
        if (bVar == c.b.BEGIN_ARRAY) {
            return p.e(c, f2);
        }
        if (bVar == c.b.BEGIN_OBJECT) {
            return p.e(c, f2);
        }
        if (bVar != c.b.NUMBER) {
        } else {
            PointF pointF = new PointF(f *= f2, f3 *= f2);
            while (c.j() != 0) {
                c.H();
            }
            return pointF;
        }
        obj6 = new StringBuilder();
        obj6.append("Cannot convert json to point. Next token is ");
        obj6.append(bVar);
        IllegalArgumentException obj5 = new IllegalArgumentException(obj6.toString());
        throw obj5;
    }
}
