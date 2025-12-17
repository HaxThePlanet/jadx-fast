package i.b.m0.e.e;

import i.b.m0.c.h;
import i.b.r;
import i.b.y;

/* loaded from: classes3.dex */
public final class r1<T>  extends r<T> implements h<T> {

    private final T a;
    public r1(T t) {
        super();
        this.a = t;
    }

    public T call() {
        return this.a;
    }

    protected void subscribeActual(y<? super T> y) {
        y2.a aVar = new y2.a(y, this.a);
        y.onSubscribe(aVar);
        aVar.run();
    }
}
