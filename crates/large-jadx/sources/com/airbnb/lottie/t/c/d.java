package com.airbnb.lottie.t.c;

import com.airbnb.lottie.v.k.c;
import com.airbnb.lottie.z.a;
import java.util.List;

/* compiled from: GradientColorKeyframeAnimation.java */
/* loaded from: classes.dex */
public class d extends f<c> {

    private final c i = new c();
    public d(List<a<c>> list) {
        int i = 0;
        super(list);
        i = 0;
        if (obj != null) {
            i = obj.c();
        }
        c cVar = new c(new float[i], new int[i]);
    }

    @Override // com.airbnb.lottie.t.c.f
    c p(a<c> aVar, float f) {
        this.i.d((c)aVar.b, (c)aVar.c, f);
        return this.i;
    }
}
