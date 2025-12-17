package i.b.m0.e.b;

import i.b.h;
import i.b.m0.c.h;
import i.b.m0.i.e;
import m.c.b;

/* loaded from: classes3.dex */
public final class u<T>  extends h<T> implements h<T> {

    private final T b;
    public u(T t) {
        super();
        this.b = t;
    }

    protected void c0(b<? super T> b) {
        e eVar = new e(b, this.b);
        b.onSubscribe(eVar);
    }

    public T call() {
        return this.b;
    }
}
