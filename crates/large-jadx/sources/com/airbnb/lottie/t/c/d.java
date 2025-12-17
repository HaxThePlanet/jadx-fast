package com.airbnb.lottie.t.c;

import com.airbnb.lottie.v.k.c;
import com.airbnb.lottie.z.a;
import java.util.List;

/* loaded from: classes.dex */
public class d extends com.airbnb.lottie.t.c.f<c> {

    private final c i;
    public d(List<a<c>> list) {
        int i;
        super(list);
        Object obj3 = obj3.b;
        if ((c)obj3 == null) {
        } else {
            i = (c)obj3.c();
        }
        obj3 = new c(new float[i], new int[i]);
        this.i = obj3;
    }

    @Override // com.airbnb.lottie.t.c.f
    Object i(a a, float f2) {
        return p(a, f2);
    }

    c p(a<c> a, float f2) {
        this.i.d((c)a.b, (c)a.c, f2);
        return this.i;
    }
}
