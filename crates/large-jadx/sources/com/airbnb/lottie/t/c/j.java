package com.airbnb.lottie.t.c;

import android.graphics.PointF;
import com.airbnb.lottie.z.a;
import com.airbnb.lottie.z.c;
import java.util.List;

/* loaded from: classes.dex */
public class j extends com.airbnb.lottie.t.c.f<PointF> {

    private final PointF i;
    public j(List<a<PointF>> list) {
        super(list);
        PointF obj1 = new PointF();
        this.i = obj1;
    }

    @Override // com.airbnb.lottie.t.c.f
    public Object i(a a, float f2) {
        return p(a, f2);
    }

    @Override // com.airbnb.lottie.t.c.f
    protected Object j(a a, float f2, float f3, float f4) {
        return q(a, f2, f3, f4);
    }

    public PointF p(a<PointF> a, float f2) {
        return q(a, f2, f2, f2);
    }

    protected PointF q(a<PointF> a, float f2, float f3, float f4) {
        Object obj;
        float f7;
        float floatValue;
        Object obj2;
        Object obj3;
        float f;
        float f6;
        float f5;
        Object obj11;
        Object obj4 = a.b;
        if (obj4 == null) {
        } else {
            obj = a.c;
            if (obj == null) {
            } else {
                c cVar = this.e;
                obj11 = cVar.b(a.g, a.h.floatValue(), (PointF)obj4, (PointF)obj, f2, e(), f());
                if (cVar != null && (PointF)obj11 != null) {
                    obj11 = cVar.b(a.g, a.h.floatValue(), obj4, obj, f2, e(), f());
                    if ((PointF)(PointF)obj11 != null) {
                        return (PointF)(PointF)obj11;
                    }
                }
                float obj12 = obj4.x;
                float obj13 = obj4.y;
                this.i.set(obj12 += obj13, obj13 += obj14);
                return this.i;
            }
        }
        obj11 = new IllegalStateException("Missing values for keyframe.");
        throw obj11;
    }
}
