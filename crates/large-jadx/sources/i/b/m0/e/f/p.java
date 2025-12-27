package i.b.m0.e.f;

import i.b.a0;
import i.b.d0;
import i.b.g0;
import i.b.j0.b;
import i.b.m0.a.c;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: SingleDoOnDispose.java */
/* loaded from: classes3.dex */
public final class p<T> extends a0<T> {

    final g0<T> a;
    final i.b.l0.a b;

    static final class a<T> extends AtomicReference<i.b.l0.a> implements d0<T>, b {

        private static final long serialVersionUID = -8583764624474935784L;
        final d0<? super T> downstream;
        b upstream;
        a(d0<? super T> d0Var, i.b.l0.a aVar) {
            super();
            this.downstream = d0Var;
            lazySet(aVar);
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public void dispose() {
            Object andSet = getAndSet(null);
            if (andSet != null) {
                try {
                    andSet.run();
                } catch (Throwable th) {
                    a.b(th);
                    a.t(th);
                }
                this.upstream.dispose();
            }
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public boolean isDisposed() {
            return this.upstream.isDisposed();
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public void onError(Throwable th) {
            this.downstream.onError(th);
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public void onSubscribe(b bVar) {
            if (c.validate(this.upstream, bVar)) {
                this.upstream = bVar;
                this.downstream.onSubscribe(this);
            }
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public void onSuccess(T t) {
            this.downstream.onSuccess(t);
        }
    }
    public p(g0<T> g0Var, i.b.l0.a aVar) {
        super();
        this.a = g0Var;
        this.b = aVar;
    }

    @Override // i.b.a0
    protected void subscribeActual(d0<? super T> d0Var) {
        this.a.subscribe(new p.a(d0Var, this.b));
    }
}
