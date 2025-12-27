package com.airbnb.lottie.t.c;

import android.graphics.PointF;
import com.airbnb.lottie.z.a;
import com.airbnb.lottie.z.c;
import java.util.List;

/* compiled from: PointKeyframeAnimation.java */
/* loaded from: classes.dex */
public class j extends f<PointF> {

    private final PointF i = new PointF();
    public j(List<a<PointF>> list) {
        super(list);
        final PointF pointF = new PointF();
    }

    @Override // com.airbnb.lottie.t.c.f
    public PointF p(a<PointF> aVar, float f) {
        return q(aVar, f, f, f);
    }

    @Override // com.airbnb.lottie.t.c.f
    protected PointF q(a<PointF> aVar, float f, float f2, float f3) {
        if (aVar.b == null) {
            throw new IllegalStateException("Missing values for keyframe.");
        } else {
            if (aVar.c != null) {
                if (this.e != null) {
                    Object obj3 = this.e.b(aVar.g, aVar.h.floatValue(), obj, obj2, f, e(), f());
                    if (obj3 != null) {
                        return obj3;
                    }
                }
                this.i.set(f12 + (f2 * (obj2.x - f12)), f15 + (f3 * (obj2.y - f15)));
                return this.i;
            }
        }
    }
}
