package com.airbnb.lottie.t.c;

import com.airbnb.lottie.y.b;
import com.airbnb.lottie.y.g;
import com.airbnb.lottie.z.a;
import com.airbnb.lottie.z.c;
import java.util.List;

/* loaded from: classes.dex */
public class b extends com.airbnb.lottie.t.c.f<Integer> {
    public b(List<a<Integer>> list) {
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

    public int q(a<Integer> a, float f2) {
        Object obj;
        float f;
        float floatValue;
        Integer valueOf2;
        Integer valueOf;
        float f5;
        float f4;
        float f3;
        Object obj11;
        Object obj2 = a.b;
        if (obj2 == null) {
        } else {
            if (a.c == null) {
            } else {
                int intValue = (Integer)obj2.intValue();
                int intValue2 = (Integer)a.c.intValue();
                c cVar = this.e;
                obj11 = cVar.b(a.g, a.h.floatValue(), Integer.valueOf(intValue), Integer.valueOf(intValue2), f2, e(), f());
                if (cVar != null && (Integer)obj11 != null) {
                    obj11 = cVar.b(a.g, a.h.floatValue(), Integer.valueOf(intValue), Integer.valueOf(intValue2), f2, e(), f());
                    if ((Integer)(Integer)obj11 != null) {
                        return (Integer)(Integer)obj11.intValue();
                    }
                }
                return b.c(g.c(f2, 0, 1065353216), intValue, intValue2);
            }
        }
        obj11 = new IllegalStateException("Missing values for keyframe.");
        throw obj11;
    }

    Integer r(a<Integer> a, float f2) {
        return Integer.valueOf(q(a, f2));
    }
}
