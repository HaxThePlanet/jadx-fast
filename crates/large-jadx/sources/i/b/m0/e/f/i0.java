package i.b.m0.e.f;

import i.b.a0;
import i.b.d0;
import i.b.j0.c;

/* loaded from: classes3.dex */
public final class i0<T>  extends a0<T> {

    final T a;
    public i0(T t) {
        super();
        this.a = t;
    }

    protected void subscribeActual(d0<? super T> d0) {
        d0.onSubscribe(c.a());
        d0.onSuccess(this.a);
    }
}
