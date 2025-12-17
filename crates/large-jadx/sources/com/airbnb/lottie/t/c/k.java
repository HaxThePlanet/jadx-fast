package com.airbnb.lottie.t.c;

import com.airbnb.lottie.y.g;
import com.airbnb.lottie.z.a;
import com.airbnb.lottie.z.c;
import com.airbnb.lottie.z.d;
import java.util.List;

/* loaded from: classes.dex */
public class k extends com.airbnb.lottie.t.c.f<d> {

    private final d i;
    public k(List<a<d>> list) {
        super(list);
        d obj1 = new d();
        this.i = obj1;
    }

    @Override // com.airbnb.lottie.t.c.f
    public Object i(a a, float f2) {
        return p(a, f2);
    }

    public d p(a<d> a, float f2) {
        Object obj3;
        float f5;
        float floatValue;
        Object obj2;
        Object obj;
        float f4;
        float f3;
        float f;
        Object obj11;
        Object obj4 = a.b;
        if (obj4 == null) {
        } else {
            obj3 = a.c;
            if (obj3 == null) {
            } else {
                c cVar = this.e;
                obj11 = cVar.b(a.g, a.h.floatValue(), (d)obj4, (d)obj3, f2, e(), f());
                if (cVar != null && (d)obj11 != null) {
                    obj11 = cVar.b(a.g, a.h.floatValue(), obj4, obj3, f2, e(), f());
                    if ((d)(d)obj11 != null) {
                        return (d)(d)obj11;
                    }
                }
                this.i.d(g.k(obj4.b(), obj3.b(), f2), g.k(obj4.c(), obj3.c(), f2));
                return this.i;
            }
        }
        obj11 = new IllegalStateException("Missing values for keyframe.");
        throw obj11;
    }
}
