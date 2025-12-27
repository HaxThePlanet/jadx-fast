package com.airbnb.lottie.t.c;

import com.airbnb.lottie.y.g;
import com.airbnb.lottie.z.a;
import com.airbnb.lottie.z.c;
import java.util.List;

/* compiled from: FloatKeyframeAnimation.java */
/* loaded from: classes.dex */
public class c extends f<Float> {
    public c(List<a<Float>> list) {
        super(list);
    }

    @Override // com.airbnb.lottie.t.c.f
    public float p() {
        return q(b(), d());
    }

    @Override // com.airbnb.lottie.t.c.f
    float q(a<Float> aVar, float f) {
        if (aVar.b == null) {
            throw new IllegalStateException("Missing values for keyframe.");
        } else {
            if (aVar.c != null) {
                if (this.e != null) {
                    Object obj = this.e.b(aVar.g, aVar.h.floatValue(), aVar.b, aVar.c, f, e(), f());
                    if (obj != null) {
                        return obj.floatValue();
                    }
                }
                return g.k(aVar.f(), aVar.c(), f);
            }
        }
    }

    @Override // com.airbnb.lottie.t.c.f
    Float r(a<Float> aVar, float f) {
        return Float.valueOf(q(aVar, f));
    }
}
