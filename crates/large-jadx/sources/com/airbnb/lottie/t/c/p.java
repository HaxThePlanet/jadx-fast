package com.airbnb.lottie.t.c;

import com.airbnb.lottie.z.a;
import com.airbnb.lottie.z.c;
import java.util.Collections;

/* compiled from: ValueCallbackKeyframeAnimation.java */
/* loaded from: classes.dex */
public class p<K, A> extends a<K, A> {

    private final A i;
    public p(c<A> cVar) {
        this(cVar, null);
    }

    @Override // com.airbnb.lottie.t.c.a
    public A h() {
        return this.e.b(0.0f, 0.0f, obj, this.i, f(), f(), f());
    }

    @Override // com.airbnb.lottie.t.c.a
    A i(a<K> aVar, float f) {
        return h();
    }

    @Override // com.airbnb.lottie.t.c.a
    public void k() {
        if (this.e != null) {
            super.k();
        }
    }

    @Override // com.airbnb.lottie.t.c.a
    public void m(float f) {
        this.d = f;
    }

    public p(c<A> cVar, A a) {
        super(Collections.emptyList());
        n(cVar);
        this.i = a;
    }

    @Override // com.airbnb.lottie.t.c.a
    float c() {
        return 1065353216;
    }
}
