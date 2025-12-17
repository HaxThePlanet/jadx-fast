package i.b.m0.e.f;

import i.b.a0;
import i.b.d0;
import i.b.g0;
import i.b.j0.b;
import i.b.m0.a.c;

/* loaded from: classes3.dex */
public final class l<T>  extends a0<T> {

    final g0<T> a;

    static final class a implements d0<T>, b {

        d0<? super T> a;
        b b;
        a(d0<? super T> d0) {
            super();
            this.a = d0;
        }

        @Override // i.b.d0
        public void dispose() {
            this.a = 0;
            this.b.dispose();
            this.b = c.DISPOSED;
        }

        @Override // i.b.d0
        public boolean isDisposed() {
            return this.b.isDisposed();
        }

        @Override // i.b.d0
        public void onError(Throwable throwable) {
            int i;
            this.b = c.DISPOSED;
            d0 d0Var = this.a;
            if (d0Var != null) {
                this.a = 0;
                d0Var.onError(throwable);
            }
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
            int i;
            this.b = c.DISPOSED;
            d0 d0Var = this.a;
            if (d0Var != null) {
                this.a = 0;
                d0Var.onSuccess(t);
            }
        }
    }
    public l(g0<T> g0) {
        super();
        this.a = g0;
    }

    protected void subscribeActual(d0<? super T> d0) {
        l.a aVar = new l.a(d0);
        this.a.subscribe(aVar);
    }
}
