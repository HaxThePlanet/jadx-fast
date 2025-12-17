package i.b.m0.e.f;

import i.b.a0;
import i.b.d0;
import i.b.m0.e.d.a;
import i.b.q;

/* loaded from: classes3.dex */
public final class l0<T>  extends a0<q<T>> {

    final a0<T> a;
    public l0(a0<T> a0) {
        super();
        this.a = a0;
    }

    protected void subscribeActual(d0<? super q<T>> d0) {
        a aVar = new a(d0);
        this.a.subscribe(aVar);
    }
}
