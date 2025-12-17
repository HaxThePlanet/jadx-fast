package i.b.m0.e.e;

import i.b.r;
import i.b.w;
import i.b.y;

/* loaded from: classes3.dex */
public final class g1<T>  extends r<T> {

    final w<T> a;
    public g1(w<T> w) {
        super();
        this.a = w;
    }

    protected void subscribeActual(y<? super T> y) {
        this.a.subscribe(y);
    }
}
