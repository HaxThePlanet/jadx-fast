package i.b.m0.e.f;

import i.b.a0;
import i.b.d0;
import i.b.g0;
import i.b.j0.b;
import i.b.l0.a;
import i.b.m0.a.c;
import i.b.p0.a;
import io.reactivex.exceptions.a;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes3.dex */
public final class o<T>  extends a0<T> {

    final g0<T> a;
    final a b;

    static final class a extends AtomicInteger implements d0<T>, b {

        private static final long serialVersionUID = 4109457741734051389L;
        final d0<? super T> downstream;
        final a onFinally;
        b upstream;
        a(d0<? super T> d0, a a2) {
            super();
            this.downstream = d0;
            this.onFinally = a2;
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        void a() {
            boolean compareAndSet;
            if (compareAndSet(0, 1)) {
                this.onFinally.run();
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
        public void onError(Throwable throwable) {
            this.downstream.onError(throwable);
            a();
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        public void onSubscribe(b b) {
            Object obj2;
            if (c.validate(this.upstream, b)) {
                this.upstream = b;
                this.downstream.onSubscribe(this);
            }
        }

        public void onSuccess(T t) {
            this.downstream.onSuccess(t);
            a();
        }
    }
    public o(g0<T> g0, a a2) {
        super();
        this.a = g0;
        this.b = a2;
    }

    protected void subscribeActual(d0<? super T> d0) {
        o.a aVar = new o.a(d0, this.b);
        this.a.subscribe(aVar);
    }
}
