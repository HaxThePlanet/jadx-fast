package i.b.m0.e.f;

import i.b.a0;
import i.b.d0;
import i.b.g0;
import i.b.j0.b;
import i.b.m0.a.c;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: SingleDoFinally.java */
/* loaded from: classes3.dex */
public final class o<T> extends a0<T> {

    final g0<T> a;
    final i.b.l0.a b;

    static final class a<T> extends AtomicInteger implements d0<T>, b {

        private static final long serialVersionUID = 4109457741734051389L;
        final d0<? super T> downstream;
        final i.b.l0.a onFinally;
        b upstream;
        a(d0<? super T> d0Var, i.b.l0.a aVar) {
            super();
            this.downstream = d0Var;
            this.onFinally = aVar;
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        void a() {
            if (compareAndSet(0, 1)) {
                try {
                    this.onFinally.run();
                } catch (Throwable th) {
                    a.b(th);
                    a.t(th);
                }
            }
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        public void dispose() {
            this.upstream.dispose();
            a();
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        public boolean isDisposed() {
            return this.upstream.isDisposed();
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        public void onError(Throwable th) {
            this.downstream.onError(th);
            a();
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        public void onSubscribe(b bVar) {
            if (c.validate(this.upstream, bVar)) {
                this.upstream = bVar;
                this.downstream.onSubscribe(this);
            }
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        public void onSuccess(T t) {
            this.downstream.onSuccess(t);
            a();
        }
    }
    public o(g0<T> g0Var, i.b.l0.a aVar) {
        super();
        this.a = g0Var;
        this.b = aVar;
    }

    @Override // i.b.a0
    protected void subscribeActual(d0<? super T> d0Var) {
        this.a.subscribe(new o.a(d0Var, this.b));
    }
}
