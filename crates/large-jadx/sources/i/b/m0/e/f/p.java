package i.b.m0.e.f;

import i.b.a0;
import i.b.d0;
import i.b.g0;
import i.b.j0.b;
import i.b.l0.a;
import i.b.m0.a.c;
import i.b.p0.a;
import io.reactivex.exceptions.a;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes3.dex */
public final class p<T>  extends a0<T> {

    final g0<T> a;
    final a b;

    static final class a extends AtomicReference<a> implements d0<T>, b {

        private static final long serialVersionUID = -8583764624474935784L;
        final d0<? super T> downstream;
        b upstream;
        a(d0<? super T> d0, a a2) {
            super();
            this.downstream = d0;
            lazySet(a2);
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public void dispose() {
            Object andSet;
            andSet = getAndSet(0);
            if ((a)andSet != null) {
                (a)andSet.run();
                this.upstream.dispose();
            }
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public boolean isDisposed() {
            return this.upstream.isDisposed();
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public void onError(Throwable throwable) {
            this.downstream.onError(throwable);
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public void onSubscribe(b b) {
            Object obj2;
            if (c.validate(this.upstream, b)) {
                this.upstream = b;
                this.downstream.onSubscribe(this);
            }
        }

        public void onSuccess(T t) {
            this.downstream.onSuccess(t);
        }
    }
    public p(g0<T> g0, a a2) {
        super();
        this.a = g0;
        this.b = a2;
    }

    protected void subscribeActual(d0<? super T> d0) {
        p.a aVar = new p.a(d0, this.b);
        this.a.subscribe(aVar);
    }
}
