package i.b.m0.e.e;

import i.b.l0.n;
import i.b.p;
import i.b.r;
import i.b.w;
import i.b.y;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: ObservableFlatMapMaybe.java */
/* loaded from: classes3.dex */
public final class y0<T, R> extends a<T, R> {

    final n<? super T, ? extends p<? extends R>> b;
    final boolean c;

    static final class a<T, R> extends AtomicInteger implements y<T>, i.b.j0.b {

        private static final long serialVersionUID = 8600231336733376951L;
        final AtomicInteger active = new AtomicInteger(1);
        volatile boolean cancelled;
        final boolean delayErrors;
        final y<? super R> downstream;
        final i.b.m0.j.c errors = new c();
        final n<? super T, ? extends p<? extends R>> mapper;
        final AtomicReference<i.b.m0.f.c<R>> queue = new AtomicReference<>();
        final i.b.j0.a set = new a();
        i.b.j0.b upstream;
        a(y<? super R> yVar, n<? super T, ? extends p<? extends R>> nVar, boolean z) {
            super();
            this.downstream = yVar;
            this.mapper = nVar;
            this.delayErrors = z;
            i.b.j0.a aVar = new a();
            i.b.m0.j.c cVar = new c();
            AtomicInteger atomicInteger = new AtomicInteger(1);
            AtomicReference atomicReference = new AtomicReference();
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        void a() {
            Object obj = this.queue.get();
            if (obj != null) {
                obj.clear();
            }
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        void b() {
            if (getAndIncrement() == 0) {
                c();
            }
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        void c() {
            int andGet;
            Object poll = null;
            andGet = 1;
            while (this.cancelled) {
                andGet = 0;
                int r5 = this.active.get() == 0 ? andGet : 0;
                Object obj2 = this.queue.get();
                if (andGet != 0) {
                }
            }
            a();
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        i.b.m0.f.c<R> d() {
            Object obj = this.queue.get();
            while (obj != null) {
                i.b.m0.f.c cVar = new c(r.bufferSize());
                if (this.queue.compareAndSet(null, cVar)) {
                    return cVar;
                }
                obj = this.queue.get();
            }
            return obj;
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        public void dispose() {
            this.cancelled = true;
            this.upstream.dispose();
            this.set.dispose();
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        void e(y0.a.a<T, R> a.a) {
            i.b.j0.a set2;
            boolean compareAndSet;
            int i = 0;
            this.set.c(a.a);
            if (get() == 0) {
                i = 0;
                i = 1;
                if (compareAndSet(i, i)) {
                    if (this.active.decrementAndGet() == 0) {
                    }
                    Object obj = this.queue.get();
                    if (i != 0) {
                        if (obj == null || obj.isEmpty()) {
                            Throwable th = this.errors.b();
                            if (th != null) {
                                this.downstream.onError(th);
                            } else {
                                this.downstream.onComplete();
                            }
                        }
                        return;
                    }
                    if (decrementAndGet() == 0) {
                        return;
                    }
                    c();
                } else {
                    this.active.decrementAndGet();
                    b();
                }
            }
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        void f(y0.a.a<T, R> a.a, Throwable th) {
            this.set.c(a.a);
            if (this.errors.a(th)) {
                if (!this.delayErrors) {
                    this.upstream.dispose();
                    this.set.dispose();
                }
                this.active.decrementAndGet();
                b();
            } else {
                a.t(th);
            }
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        void g(y0.a.a<T, R> a.a, R r) {
            i.b.j0.a set2;
            boolean compareAndSet;
            int i = 0;
            this.set.c(a.a);
            if (get() == 0) {
                i = 0;
                i = 1;
                if (compareAndSet(i, i)) {
                    this.downstream.onNext(r);
                    if (this.active.decrementAndGet() == 0) {
                    }
                    Object obj = this.queue.get();
                    if (i != 0) {
                        if (obj == null || obj.isEmpty()) {
                            Throwable th = this.errors.b();
                            if (th != null) {
                                this.downstream.onError(th);
                            } else {
                                this.downstream.onComplete();
                            }
                        }
                        return;
                    }
                    if (decrementAndGet() == 0) {
                        return;
                    }
                } else {
                    i.b.m0.f.c cVar = d();
                    synchronized (cVar) {
                        try {
                            cVar.offer(r);
                        } catch (Throwable th) {
                        }
                    }
                    this.active.decrementAndGet();
                    if (getAndIncrement() != 0) {
                        return;
                    }
                }
            }
            c();
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        public boolean isDisposed() {
            return this.cancelled;
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        public void onComplete() {
            this.active.decrementAndGet();
            b();
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        public void onError(Throwable th) {
            boolean delayErrors2;
            this.active.decrementAndGet();
            if (this.errors.a(th)) {
                if (!this.delayErrors) {
                    this.set.dispose();
                }
                b();
            } else {
                a.t(th);
            }
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        public void onNext(T t) {
            try {
                final Object apply = this.mapper.apply(t);
                b.e(apply, "The mapper returned a null MaybeSource");
            } catch (Throwable th) {
                a.b(th);
                this.upstream.dispose();
                onError(th);
                return;
            }
            this.active.getAndIncrement();
            i.b.m0.e.e.y0.a.a aVar = new y0.a.a(this);
            if (!this.cancelled) {
                if (this.set.b(aVar)) {
                    apply.b(aVar);
                }
            }
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        public void onSubscribe(i.b.j0.b bVar) {
            if (c.validate(this.upstream, bVar)) {
                this.upstream = bVar;
                this.downstream.onSubscribe(this);
            }
        }
    }
    public y0(w<T> wVar, n<? super T, ? extends p<? extends R>> nVar, boolean z) {
        super(wVar);
        this.b = nVar;
        this.c = z;
    }

    @Override // i.b.m0.e.e.a
    protected void subscribeActual(y<? super R> yVar) {
        this.a.subscribe(new y0.a(yVar, this.b, this.c));
    }
}
