package i.b.m0.e.c;

import i.b.j0.c;
import i.b.l;
import i.b.m0.c.h;
import i.b.n;

/* loaded from: classes3.dex */
public final class n<T>  extends l<T> implements h<T> {

    final T a;
    public n(T t) {
        super();
        this.a = t;
    }

    public T call() {
        return this.a;
    }

    protected void w(n<? super T> n) {
        n.onSubscribe(c.a());
        n.onSuccess(this.a);
    }
}
