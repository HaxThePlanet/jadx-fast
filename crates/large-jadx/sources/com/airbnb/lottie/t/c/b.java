package com.airbnb.lottie.t.c;

import com.airbnb.lottie.y.b;
import com.airbnb.lottie.y.g;
import com.airbnb.lottie.z.a;
import com.airbnb.lottie.z.c;
import java.util.List;

/* compiled from: ColorKeyframeAnimation.java */
/* loaded from: classes.dex */
public class b extends f<Integer> {
    public b(List<a<Integer>> list) {
        super(list);
    }

    @Override // com.airbnb.lottie.t.c.f
    public int p() {
        return q(b(), d());
    }

    @Override // com.airbnb.lottie.t.c.f
    public int q(a<Integer> aVar, float f) {
        if (aVar.b == null) {
            throw new IllegalStateException("Missing values for keyframe.");
        } else {
            if (aVar.c != null) {
                int value2 = obj3.intValue();
                int value3 = (Integer)aVar.c.intValue();
                if (this.e != null) {
                    Object obj2 = this.e.b(aVar.g, aVar.h.floatValue(), Integer.valueOf(value2), Integer.valueOf(value3), f, e(), f());
                    if (obj2 != null) {
                        return obj2.intValue();
                    }
                }
                return b.c(g.c(f, 0.0f, 1f), value2, value3);
            }
        }
    }

    @Override // com.airbnb.lottie.t.c.f
    Integer r(a<Integer> aVar, float f) {
        return Integer.valueOf(q(aVar, f));
    }
}
