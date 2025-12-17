package com.airbnb.lottie.t.c;

import com.airbnb.lottie.y.g;
import com.airbnb.lottie.z.a;
import com.airbnb.lottie.z.c;
import java.util.List;

/* loaded from: classes.dex */
public class e extends com.airbnb.lottie.t.c.f<Integer> {
    public e(List<a<Integer>> list) {
        super(list);
    }

    @Override // com.airbnb.lottie.t.c.f
    Object i(a a, float f2) {
        return r(a, f2);
    }

    @Override // com.airbnb.lottie.t.c.f
    public int p() {
        return q(b(), d());
    }

    int q(a<Integer> a, float f2) {
        Object obj2;
        float f5;
        float floatValue;
        Object obj;
        Object obj3;
        float f3;
        float f4;
        float f;
        if (a.b == null) {
        } else {
            if (a.c == null) {
            } else {
                final c cVar = this.e;
                obj2 = cVar.b(a.g, a.h.floatValue(), a.b, a.c, f2, e(), f());
                if (cVar != null && (Integer)obj2 != null) {
                    obj2 = cVar.b(a.g, a.h.floatValue(), a.b, a.c, f2, e(), f());
                    if ((Integer)(Integer)obj2 != null) {
                        return (Integer)(Integer)obj2.intValue();
                    }
                }
                return g.l(a.g(), a.d(), f2);
            }
        }
        IllegalStateException obj10 = new IllegalStateException("Missing values for keyframe.");
        throw obj10;
    }

    Integer r(a<Integer> a, float f2) {
        return Integer.valueOf(q(a, f2));
    }
}
