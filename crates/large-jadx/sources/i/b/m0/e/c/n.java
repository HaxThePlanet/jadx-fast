package i.b.m0.e.c;

import i.b.j0.c;
import i.b.l;
import i.b.m0.c.h;
import i.b.n;

/* compiled from: MaybeJust.java */
/* loaded from: classes3.dex */
public final class n<T> extends l<T> implements h<T> {

    final T a;
    public n(T t) {
        super();
        this.a = t;
    }

    @Override // i.b.l
    public T call() {
        return this.a;
    }

    @Override // i.b.l
    protected void w(n<? super T> nVar) {
        nVar.onSubscribe(c.a());
        nVar.onSuccess(this.a);
    }
}
