package i.b.m0.e.d;

import i.b.d;
import i.b.d0;
import i.b.j0.b;
import i.b.m0.a.c;
import i.b.n;
import i.b.q;

/* compiled from: MaterializeSingleObserver.java */
/* loaded from: classes3.dex */
public final class a<T> implements d0<T>, n<T>, d, b {

    final d0<? super q<T>> a;
    b b;
    public a(d0<? super q<T>> d0Var) {
        super();
        this.a = d0Var;
    }

    public void dispose() {
        this.b.dispose();
    }

    public boolean isDisposed() {
        return this.b.isDisposed();
    }

    public void onComplete() {
        this.a.onSuccess(q.a());
    }

    public void onError(Throwable th) {
        this.a.onSuccess(q.b(th));
    }

    public void onSubscribe(b bVar) {
        if (c.validate(this.b, bVar)) {
            this.b = bVar;
            this.a.onSubscribe(this);
        }
    }

    public void onSuccess(T t) {
        this.a.onSuccess(q.c(t));
    }
}
