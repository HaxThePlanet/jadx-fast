package com.airbnb.lottie.t.c;

import com.airbnb.lottie.y.g;
import com.airbnb.lottie.z.a;
import com.airbnb.lottie.z.c;
import java.util.List;

/* loaded from: classes.dex */
public class c extends com.airbnb.lottie.t.c.f<Float> {
    public c(List<a<Float>> list) {
        super(list);
    }

    @Override // com.airbnb.lottie.t.c.f
    Object i(a a, float f2) {
        return r(a, f2);
    }

    @Override // com.airbnb.lottie.t.c.f
    public float p() {
        return q(b(), d());
    }

    float q(a<Float> a, float f2) {
        Object obj3;
        float f;
        float floatValue;
        Object obj;
        Object obj2;
        float f5;
        float f3;
        float f4;
        if (a.b == null) {
        } else {
            if (a.c == null) {
            } else {
                final c cVar = this.e;
                obj3 = cVar.b(a.g, a.h.floatValue(), a.b, a.c, f2, e(), f());
                if (cVar != null && (Float)obj3 != null) {
                    obj3 = cVar.b(a.g, a.h.floatValue(), a.b, a.c, f2, e(), f());
                    if ((Float)(Float)obj3 != null) {
                        return (Float)(Float)obj3.floatValue();
                    }
                }
                return g.k(a.f(), a.c(), f2);
            }
        }
        IllegalStateException obj10 = new IllegalStateException("Missing values for keyframe.");
        throw obj10;
    }

    Float r(a<Float> a, float f2) {
        return Float.valueOf(q(a, f2));
    }
}
