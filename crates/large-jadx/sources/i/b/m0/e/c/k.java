package i.b.m0.e.c;

import i.b.d0;
import i.b.g0;
import i.b.j0.b;
import i.b.l;
import i.b.m0.a.c;
import i.b.n;

/* loaded from: classes3.dex */
public final class k<T>  extends l<T> {

    final g0<T> a;

    static final class a implements d0<T>, b {

        final n<? super T> a;
        b b;
        a(n<? super T> n) {
            super();
            this.a = n;
        }

        @Override // i.b.d0
        public void dispose() {
            this.b.dispose();
            this.b = c.DISPOSED;
        }

        @Override // i.b.d0
        public boolean isDisposed() {
            return this.b.isDisposed();
        }

        @Override // i.b.d0
        public void onError(Throwable throwable) {
            this.b = c.DISPOSED;
            this.a.onError(throwable);
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
            this.b = c.DISPOSED;
            this.a.onSuccess(t);
        }
    }
    public k(g0<T> g0) {
        super();
        this.a = g0;
    }

    protected void w(n<? super T> n) {
        k.a aVar = new k.a(n);
        this.a.subscribe(aVar);
    }
}
