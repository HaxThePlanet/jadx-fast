package i.b.m0.e.e;

import i.b.j0.b;
import i.b.l0.n;
import i.b.m0.a.c;
import i.b.m0.a.d;
import i.b.m0.b.b;
import i.b.m0.j.c;
import i.b.m0.j.l;
import i.b.r;
import i.b.t0.b;
import i.b.t0.d;
import i.b.w;
import i.b.y;
import io.reactivex.exceptions.a;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes3.dex */
public final class r2<T>  extends i.b.m0.e.e.a<T, T> {

    final n<? super r<Object>, ? extends w<?>> b;

    static final class a extends AtomicInteger implements y<T>, b {

        private static final long serialVersionUID = 802743776666017014L;
        volatile boolean active;
        final y<? super T> downstream;
        final c error;
        final i.b.m0.e.e.r2.a.a<T> inner;
        final d<Object> signaller;
        final w<T> source;
        final AtomicReference<b> upstream;
        final AtomicInteger wip;
        a(y<? super T> y, d<Object> d2, w<T> w3) {
            super();
            this.downstream = y;
            this.signaller = d2;
            this.source = w3;
            AtomicInteger obj1 = new AtomicInteger();
            this.wip = obj1;
            obj1 = new c();
            this.error = obj1;
            obj1 = new r2.a.a(this);
            this.inner = obj1;
            obj1 = new AtomicReference();
            this.upstream = obj1;
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        void a() {
            c.dispose(this.upstream);
            l.a(this.downstream, this, this.error);
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        void b(Throwable throwable) {
            c.dispose(this.upstream);
            l.c(this.downstream, throwable, this, this.error);
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        void c() {
            d();
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        void d() {
            int decrementAndGet;
            boolean active;
            if (this.wip.getAndIncrement() == 0) {
            }
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        public void dispose() {
            c.dispose(this.upstream);
            c.dispose(this.inner);
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        public boolean isDisposed() {
            return c.isDisposed((b)this.upstream.get());
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        public void onComplete() {
            c.replace(this.upstream, 0);
            int i = 0;
            this.active = i;
            this.signaller.onNext(Integer.valueOf(i));
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        public void onError(Throwable throwable) {
            c.dispose(this.inner);
            l.c(this.downstream, throwable, this, this.error);
        }

        public void onNext(T t) {
            l.e(this.downstream, t, this, this.error);
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        public void onSubscribe(b b) {
            c.setOnce(this.upstream, b);
        }
    }
    public r2(w<T> w, n<? super r<Object>, ? extends w<?>> n2) {
        super(w);
        this.b = n2;
    }

    protected void subscribeActual(y<? super T> y) {
        d dVar = b.e().c();
        Object apply = this.b.apply(dVar);
        b.e(apply, "The handler returned a null ObservableSource");
        r2.a aVar = new r2.a(y, dVar, this.a);
        y.onSubscribe(aVar);
        (w)apply.subscribe(aVar.inner);
        aVar.d();
    }
}
