package com.airbnb.lottie.t.c;

import com.airbnb.lottie.z.a;
import com.airbnb.lottie.z.c;
import java.util.Collections;

/* loaded from: classes.dex */
public class p<K, A>  extends com.airbnb.lottie.t.c.a<K, A> {

    private final A i;
    public p(c<A> c) {
        super(c, 0);
    }

    public p(c<A> c, A a2) {
        super(Collections.emptyList());
        n(c);
        this.i = a2;
    }

    @Override // com.airbnb.lottie.t.c.a
    float c() {
        return 1065353216;
    }

    public A h() {
        final Object obj3 = this.i;
        return this.e.b(0, 0, obj3, obj3, f(), f(), f());
    }

    A i(a<K> a, float f2) {
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
}
