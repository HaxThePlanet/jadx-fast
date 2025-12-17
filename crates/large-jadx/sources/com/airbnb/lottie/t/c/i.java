package com.airbnb.lottie.t.c;

import android.graphics.PathMeasure;
import android.graphics.PointF;
import com.airbnb.lottie.z.a;
import com.airbnb.lottie.z.c;
import java.util.List;

/* loaded from: classes.dex */
public class i extends com.airbnb.lottie.t.c.f<PointF> {

    private final PointF i;
    private final float[] j;
    private final PathMeasure k;
    private com.airbnb.lottie.t.c.h l;
    public i(List<? extends a<PointF>> list) {
        super(list);
        PointF obj1 = new PointF();
        this.i = obj1;
        this.j = new float[2];
        obj1 = new PathMeasure();
        this.k = obj1;
    }

    @Override // com.airbnb.lottie.t.c.f
    public Object i(a a, float f2) {
        return p(a, f2);
    }

    public PointF p(a<PointF> a, float f2) {
        float f4;
        float floatValue;
        Object obj2;
        Object obj;
        float f;
        float f5;
        float f3;
        Object obj11;
        Object obj3 = a;
        android.graphics.Path path = (h)obj3.j();
        if (path == null) {
            return (PointF)a.b;
        }
        c cVar = this.e;
        obj11 = cVar.b(obj3.g, obj3.h.floatValue(), obj3.b, obj3.c, e(), f2, f());
        if (cVar != null && (PointF)obj11 != null) {
            obj11 = cVar.b(obj3.g, obj3.h.floatValue(), obj3.b, obj3.c, e(), f2, f());
            if ((PointF)(PointF)obj11 != null) {
                return (PointF)(PointF)obj11;
            }
        }
        int i3 = 0;
        if (this.l != obj3) {
            this.k.setPath(path, i3);
            this.l = obj3;
        }
        obj11 = this.k;
        obj11.getPosTan(f2 *= length, this.j, 0);
        float[] obj12 = this.j;
        this.i.set(obj12[i3], obj12[1]);
        return this.i;
    }
}
