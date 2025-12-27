package i.b.m0.e.e;

import i.b.l0.n;
import i.b.m0.a.c;
import i.b.m0.a.g;
import i.b.r;
import i.b.w;
import i.b.y;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: ObservableTimeout.java */
/* loaded from: classes3.dex */
public final class y3<T, U, V> extends a<T, T> {

    final w<U> b;
    final n<? super T, ? extends w<V>> c;
    final w<? extends T> v;

    static final class a extends AtomicReference<i.b.j0.b> implements y<Object>, i.b.j0.b {

        private static final long serialVersionUID = 8708641127342403073L;
        final long idx;
        final y3.d parent;
        a(long j, y3.d dVar) {
            super();
            this.idx = j;
            this.parent = dVar;
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public void dispose() {
            c.dispose(this);
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public boolean isDisposed() {
            return c.isDisposed((b)get());
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public void onComplete() {
            dISPOSED2 = c.DISPOSED;
            if (get() != c.DISPOSED) {
                lazySet(c.DISPOSED);
                this.parent.a(this.idx);
            }
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public void onError(Throwable th) {
            c dISPOSED2 = c.DISPOSED;
            if (get() != c.DISPOSED) {
                lazySet(c.DISPOSED);
                this.parent.b(this.idx, th);
            } else {
                a.t(th);
            }
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public void onNext(Object object) {
            Object obj = get();
            dISPOSED2 = c.DISPOSED;
            if (obj != c.DISPOSED) {
                obj.dispose();
                lazySet(c.DISPOSED);
                this.parent.a(this.idx);
            }
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public void onSubscribe(i.b.j0.b bVar) {
            c.setOnce(this, bVar);
        }
    }

    interface d extends z3.d {
        void b(long j, Throwable th);
    }

    static final class b<T> extends AtomicReference<i.b.j0.b> implements y<T>, i.b.j0.b, y3.d {

        private static final long serialVersionUID = -7508389464265974549L;
        final y<? super T> downstream;
        w<? extends T> fallback;
        final AtomicLong index = new AtomicLong();
        final n<? super T, ? extends w<?>> itemTimeoutIndicator;
        final g task = new g();
        final AtomicReference<i.b.j0.b> upstream = new AtomicReference<>();
        b(y<? super T> yVar, n<? super T, ? extends w<?>> nVar, w<? extends T> wVar) {
            super();
            this.downstream = yVar;
            this.itemTimeoutIndicator = nVar;
            g gVar = new g();
            this.fallback = wVar;
            AtomicLong atomicLong = new AtomicLong();
            AtomicReference atomicReference = new AtomicReference();
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public void a(long j) {
            if (this.index.compareAndSet(j, Long.MAX_VALUE)) {
                c.dispose(this.upstream);
                this.fallback = null;
                this.fallback.subscribe(new z3.a(this.downstream, this));
            }
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public void b(long j, Throwable th) {
            if (this.index.compareAndSet(j, Long.MAX_VALUE)) {
                c.dispose(this);
                this.downstream.onError(th);
            } else {
                a.t(th);
            }
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        void c(w<?> wVar) {
            if (wVar != null) {
                i.b.m0.e.e.y3.a aVar = new y3.a(0L, r2, this);
                if (this.task.a(aVar)) {
                    wVar.subscribe(aVar);
                }
            }
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public void dispose() {
            c.dispose(this.upstream);
            c.dispose(this);
            this.task.dispose();
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public boolean isDisposed() {
            return c.isDisposed((b)get());
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public void onComplete() {
            final long l = Long.MAX_VALUE;
            final long andSet = this.index.getAndSet(l);
            if (andSet != Long.MAX_VALUE) {
                this.task.dispose();
                this.downstream.onComplete();
                this.task.dispose();
            }
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public void onError(Throwable th) {
            final long l = Long.MAX_VALUE;
            final long andSet = this.index.getAndSet(l);
            if (andSet != Long.MAX_VALUE) {
                this.task.dispose();
                this.downstream.onError(th);
                this.task.dispose();
            } else {
                a.t(th);
            }
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public void onNext(T t) {
            long l = this.index.get();
            if (l != 9223372036854775807L) {
                l2 = 1L + l;
                if (this.index.compareAndSet(l, l2)) {
                    Object obj = this.task.get();
                    if (obj != null) {
                        obj.dispose();
                    }
                    this.downstream.onNext(t);
                    try {
                        Object apply = this.itemTimeoutIndicator.apply(t);
                        b.e(apply, "The itemTimeoutIndicator returned a null ObservableSource.");
                    } catch (Throwable th) {
                        a.b(th);
                        AtomicReference downstream2 = this.upstream.get();
                        downstream2.dispose();
                        downstream2.getAndSet(l4);
                        downstream2.onError(th);
                    }
                    i.b.m0.e.e.y3.a aVar = new y3.a(l2, dVar, this);
                    if (this.task.a(aVar)) {
                        apply.subscribe(aVar);
                    }
                }
                return;
            }
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public void onSubscribe(i.b.j0.b bVar) {
            c.setOnce(this.upstream, bVar);
        }
    }

    static final class c<T> extends AtomicLong implements y<T>, i.b.j0.b, y3.d {

        private static final long serialVersionUID = 3764492702657003550L;
        final y<? super T> downstream;
        final n<? super T, ? extends w<?>> itemTimeoutIndicator;
        final g task = new g();
        final AtomicReference<i.b.j0.b> upstream = new AtomicReference<>();
        c(y<? super T> yVar, n<? super T, ? extends w<?>> nVar) {
            super();
            this.downstream = yVar;
            this.itemTimeoutIndicator = nVar;
            g gVar = new g();
            AtomicReference atomicReference = new AtomicReference();
        }

        @Override // java.util.concurrent.atomic.AtomicLong
        public void a(long j) {
            if (compareAndSet(j, Long.MAX_VALUE)) {
                c.dispose(this.upstream);
                this.downstream.onError(new TimeoutException());
            }
        }

        @Override // java.util.concurrent.atomic.AtomicLong
        public void b(long j, Throwable th) {
            if (compareAndSet(j, Long.MAX_VALUE)) {
                c.dispose(this.upstream);
                this.downstream.onError(th);
            } else {
                a.t(th);
            }
        }

        @Override // java.util.concurrent.atomic.AtomicLong
        void c(w<?> wVar) {
            if (wVar != null) {
                i.b.m0.e.e.y3.a aVar = new y3.a(0L, r2, this);
                if (this.task.a(aVar)) {
                    wVar.subscribe(aVar);
                }
            }
        }

        @Override // java.util.concurrent.atomic.AtomicLong
        public void dispose() {
            c.dispose(this.upstream);
            this.task.dispose();
        }

        @Override // java.util.concurrent.atomic.AtomicLong
        public boolean isDisposed() {
            return c.isDisposed((b)this.upstream.get());
        }

        @Override // java.util.concurrent.atomic.AtomicLong
        public void onComplete() {
            long l = Long.MAX_VALUE;
            final long andSet = getAndSet(l);
            if (andSet != Long.MAX_VALUE) {
                this.task.dispose();
                this.downstream.onComplete();
            }
        }

        @Override // java.util.concurrent.atomic.AtomicLong
        public void onError(Throwable th) {
            long l = Long.MAX_VALUE;
            final long andSet = getAndSet(l);
            if (andSet != Long.MAX_VALUE) {
                this.task.dispose();
                this.downstream.onError(th);
            } else {
                a.t(th);
            }
        }

        @Override // java.util.concurrent.atomic.AtomicLong
        public void onNext(T t) {
            long l = get();
            if (l != 9223372036854775807L) {
                long l5 = 1L + l;
                if (compareAndSet(l, l5)) {
                    Object obj = this.task.get();
                    if (obj != null) {
                        obj.dispose();
                    }
                    this.downstream.onNext(t);
                    try {
                        Object apply = this.itemTimeoutIndicator.apply(t);
                        b.e(apply, "The itemTimeoutIndicator returned a null ObservableSource.");
                    } catch (Throwable th) {
                        a.b(th);
                        AtomicReference downstream2 = this.upstream.get();
                        downstream2.dispose();
                        getAndSet(l3);
                        downstream2.onError(th);
                    }
                    i.b.m0.e.e.y3.a aVar = new y3.a(l5, dVar, this);
                    if (this.task.a(aVar)) {
                        apply.subscribe(aVar);
                    }
                }
                return;
            }
        }

        @Override // java.util.concurrent.atomic.AtomicLong
        public void onSubscribe(i.b.j0.b bVar) {
            c.setOnce(this.upstream, bVar);
        }
    }
    public y3(r<T> rVar, w<U> wVar, n<? super T, ? extends w<V>> nVar, w<? extends T> wVar2) {
        super(rVar);
        this.b = wVar;
        this.c = nVar;
        this.v = wVar2;
    }

    @Override // i.b.m0.e.e.a
    protected void subscribeActual(y<? super T> yVar) {
        if (this.v == null) {
            i.b.m0.e.e.y3.c cVar = new y3.c(yVar, this.c);
            yVar.onSubscribe(cVar);
            cVar.c(this.b);
            this.a.subscribe(cVar);
        } else {
            i.b.m0.e.e.y3.b bVar = new y3.b(yVar, this.c, this.v);
            yVar.onSubscribe(bVar);
            bVar.c(this.b);
            this.a.subscribe(bVar);
        }
    }
}
