package i.b.m0.e.f;

import i.b.a0;
import i.b.d0;
import i.b.j0.c;

/* compiled from: SingleJust.java */
/* loaded from: classes3.dex */
public final class i0<T> extends a0<T> {

    final T a;
    public i0(T t) {
        super();
        this.a = t;
    }

    @Override // i.b.a0
    protected void subscribeActual(d0<? super T> d0Var) {
        d0Var.onSubscribe(c.a());
        d0Var.onSuccess(this.a);
    }
}
