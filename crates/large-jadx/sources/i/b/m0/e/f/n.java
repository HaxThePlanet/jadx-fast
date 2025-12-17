package i.b.m0.e.f;

import i.b.a0;
import i.b.d0;
import i.b.g0;
import i.b.j0.b;
import i.b.l0.a;
import i.b.m0.a.c;
import i.b.p0.a;
import io.reactivex.exceptions.a;

/* loaded from: classes3.dex */
public final class n<T>  extends a0<T> {

    final g0<T> a;
    final a b;

    static final class a implements d0<T>, b {

        final d0<? super T> a;
        final a b;
        b c;
        a(d0<? super T> d0, a a2) {
            super();
            this.a = d0;
            this.b = a2;
        }

        private void a() {
            a aVar;
            try {
                this.b.run();
                a.b(th);
                a.t(th);
            }
        }

        @Override // i.b.d0
        public void dispose() {
            this.c.dispose();
        }

        @Override // i.b.d0
        public boolean isDisposed() {
            return this.c.isDisposed();
        }

        @Override // i.b.d0
        public void onError(Throwable throwable) {
            this.a.onError(throwable);
            a();
        }

        @Override // i.b.d0
        public void onSubscribe(b b) {
            Object obj2;
            if (c.validate(this.c, b)) {
                this.c = b;
                this.a.onSubscribe(this);
            }
        }

        public void onSuccess(T t) {
            this.a.onSuccess(t);
            a();
        }
    }
    public n(g0<T> g0, a a2) {
        super();
        this.a = g0;
        this.b = a2;
    }

    protected void subscribeActual(d0<? super T> d0) {
        n.a aVar = new n.a(d0, this.b);
        this.a.subscribe(aVar);
    }
}
