package com.airbnb.lottie.t.c;

import com.airbnb.lottie.y.g;
import com.airbnb.lottie.z.a;
import com.airbnb.lottie.z.c;
import java.util.List;

/* compiled from: IntegerKeyframeAnimation.java */
/* loaded from: classes.dex */
public class e extends f<Integer> {
    public e(List<a<Integer>> list) {
        super(list);
    }

    @Override // com.airbnb.lottie.t.c.f
    public int p() {
        return q(b(), d());
    }

    @Override // com.airbnb.lottie.t.c.f
    int q(a<Integer> aVar, float f) {
        if (aVar.b == null) {
            throw new IllegalStateException("Missing values for keyframe.");
        } else {
            if (aVar.c != null) {
                if (this.e != null) {
                    Object obj = this.e.b(aVar.g, aVar.h.floatValue(), aVar.b, aVar.c, f, e(), f());
                    if (obj != null) {
                        return obj.intValue();
                    }
                }
                return g.l(aVar.g(), aVar.d(), f);
            }
        }
    }

    @Override // com.airbnb.lottie.t.c.f
    Integer r(a<Integer> aVar, float f) {
        return Integer.valueOf(q(aVar, f));
    }
}
