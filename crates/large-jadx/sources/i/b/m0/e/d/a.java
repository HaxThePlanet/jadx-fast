package i.b.m0.e.d;

import i.b.d;
import i.b.d0;
import i.b.j0.b;
import i.b.m0.a.c;
import i.b.n;
import i.b.q;

/* loaded from: classes3.dex */
public final class a<T>  implements d0<T>, n<T>, d, b {

    final d0<? super q<T>> a;
    b b;
    public a(d0<? super q<T>> d0) {
        super();
        this.a = d0;
    }

    @Override // i.b.d0
    public void dispose() {
        this.b.dispose();
    }

    @Override // i.b.d0
    public boolean isDisposed() {
        return this.b.isDisposed();
    }

    @Override // i.b.d0
    public void onComplete() {
        this.a.onSuccess(q.a());
    }

    @Override // i.b.d0
    public void onError(Throwable throwable) {
        this.a.onSuccess(q.b(throwable));
    }

    @Override // i.b.d0
    public void onSubscribe(b b) {
        Object obj2;
        if (c.validate(this.b, b)) {
            this.b = b;
            this.a.onSubscribe(this);
        }
    }

    public void onSuccess(T t) {
        this.a.onSuccess(q.c(t));
    }
}
