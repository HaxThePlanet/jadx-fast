package com.airbnb.lottie.t.c;

import com.airbnb.lottie.y.g;
import com.airbnb.lottie.z.a;
import com.airbnb.lottie.z.c;
import com.airbnb.lottie.z.d;
import java.util.List;

/* compiled from: ScaleKeyframeAnimation.java */
/* loaded from: classes.dex */
public class k extends f<d> {

    private final d i = new d();
    public k(List<a<d>> list) {
        super(list);
        final d dVar = new d();
    }

    @Override // com.airbnb.lottie.t.c.f
    public d p(a<d> aVar, float f) {
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
                this.i.d(g.k(obj.b(), obj2.b(), f), g.k(obj.c(), obj2.c(), f));
                return this.i;
            }
        }
    }
}
