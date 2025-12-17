package com.airbnb.lottie.t.c;

import com.airbnb.lottie.v.b;
import com.airbnb.lottie.z.a;
import java.util.List;

/* loaded from: classes.dex */
public class n extends com.airbnb.lottie.t.c.f<b> {
    public n(List<a<b>> list) {
        super(list);
    }

    @Override // com.airbnb.lottie.t.c.f
    Object i(a a, float f2) {
        return p(a, f2);
    }

    b p(a<b> a, float f2) {
        int obj3;
        obj3 = a.c;
        if (Float.compare(f2, i) == 0 && obj3 == null) {
            obj3 = a.c;
            if (obj3 == null) {
            }
            return (b)obj3;
        }
        return (b)a.b;
    }
}
