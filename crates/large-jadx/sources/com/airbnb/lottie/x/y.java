package com.airbnb.lottie.x;

import android.graphics.PointF;
import com.airbnb.lottie.x.k0.c;
import com.airbnb.lottie.x.k0.c.b;

/* compiled from: PointFParser.java */
/* loaded from: classes.dex */
public class y implements j0<PointF> {

    public static final y a = new y();

    private y() {
        super();
    }

    public PointF b(c cVar, float f) {
        c.b bVar = cVar.w();
        if (bVar == c.b.BEGIN_ARRAY) {
            return p.e(cVar, f);
        }
        if (bVar == c.b.BEGIN_OBJECT) {
            return p.e(cVar, f);
        }
        if (bVar != c.b.NUMBER) {
            StringBuilder stringBuilder = new StringBuilder();
            String str = "Cannot convert json to point. Next token is ";
            f = str + bVar;
            throw new IllegalArgumentException(f);
        } else {
            while (cVar.j()) {
                cVar.H();
            }
            return new PointF((float)cVar.m() * f, (float)cVar.m() * f);
        }
    }
}
