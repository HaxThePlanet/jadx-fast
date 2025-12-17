package i.b.m0.e.f;

import i.b.a0;
import i.b.d0;
import i.b.g0;

/* loaded from: classes3.dex */
public final class f0<T>  extends a0<T> {

    final g0<T> a;
    public f0(g0<T> g0) {
        super();
        this.a = g0;
    }

    protected void subscribeActual(d0<? super T> d0) {
        this.a.subscribe(d0);
    }
}
