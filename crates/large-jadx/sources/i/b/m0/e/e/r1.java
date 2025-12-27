package i.b.m0.e.e;

import i.b.m0.c.h;
import i.b.r;
import i.b.y;

/* compiled from: ObservableJust.java */
/* loaded from: classes3.dex */
public final class r1<T> extends r<T> implements h<T> {

    private final T a;
    public r1(T t) {
        super();
        this.a = t;
    }

    @Override // i.b.r
    public T call() {
        return this.a;
    }

    @Override // i.b.r
    protected void subscribeActual(y<? super T> yVar) {
        final i.b.m0.e.e.y2.a aVar = new y2.a(yVar, this.a);
        yVar.onSubscribe(aVar);
        aVar.run();
    }
}
