package i.b.m0.e.e;

import i.b.l0.n;
import i.b.m0.j.l;
import i.b.r;
import i.b.w;
import i.b.y;
import io.reactivex.exceptions.a;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: ObservableRetryWhen.java */
/* loaded from: classes3.dex */
public final class v2<T> extends a<T, T> {

    final n<? super r<Throwable>, ? extends w<?>> b;

    static final class a<T> extends AtomicInteger implements y<T>, i.b.j0.b {

        private static final long serialVersionUID = 802743776666017014L;
        volatile boolean active;
        final y<? super T> downstream;
        final i.b.m0.j.c error = new c();
        final v2.a.a<T> inner = new v2$a$a<>();
        final i.b.t0.d<Throwable> signaller;
        final w<T> source;
        final AtomicReference<i.b.j0.b> upstream = new AtomicReference<>();
        final AtomicInteger wip = new AtomicInteger();
        a(y<? super T> yVar, i.b.t0.d<Throwable> dVar, w<T> wVar) {
            super();
            this.downstream = yVar;
            this.signaller = dVar;
            this.source = wVar;
            AtomicInteger atomicInteger = new AtomicInteger();
            i.b.m0.j.c cVar = new c();
            i.b.m0.e.e.v2.a.a aVar = new v2.a.a(this);
            AtomicReference atomicReference = new AtomicReference();
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        void a() {
            c.dispose(this.upstream);
            l.a(this.downstream, this, this.error);
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        void b(Throwable th) {
            c.dispose(this.upstream);
            l.c(this.downstream, th, this, this.error);
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        void c() {
            d();
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        void d() {
            if (this.wip.getAndIncrement() == 0) {
                while (isDisposed()) {
                    if (this.wip.decrementAndGet() == 0) {
                        return;
                    }
                }
                return;
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
            c.dispose(this.inner);
            l.a(this.downstream, this, this.error);
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        public void onError(Throwable th) {
            c.replace(this.upstream, null);
            this.active = false;
            this.signaller.onNext(th);
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        public void onNext(T t) {
            l.e(this.downstream, t, this, this.error);
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        public void onSubscribe(i.b.j0.b bVar) {
            c.replace(this.upstream, bVar);
        }
    }
    public v2(w<T> wVar, n<? super r<Throwable>, ? extends w<?>> nVar) {
        super(wVar);
        this.b = nVar;
    }

    @Override // i.b.m0.e.e.a
    protected void subscribeActual(y<? super T> yVar) {
        i.b.t0.d dVar = b.e().c();
        try {
            Object apply = this.b.apply(dVar);
            b.e(apply, "The handler returned a null ObservableSource");
        } catch (Throwable th) {
            a.b(th);
            d.error(th, yVar);
            return;
        }
        i.b.m0.e.e.v2.a aVar = new v2.a(yVar, dVar, this.a);
        yVar.onSubscribe(aVar);
        apply.subscribe(aVar.inner);
        aVar.d();
    }
}
