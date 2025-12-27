package i.b.m0.e.b;

import i.b.h;
import i.b.k;
import i.b.l0.n;
import i.b.m0.i.g;
import i.b.m0.j.d;
import i.b.p;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: FlowableFlatMapMaybe.java */
/* loaded from: classes3.dex */
public final class l<T, R> extends a<T, R> {

    final n<? super T, ? extends p<? extends R>> c;
    final boolean v;
    final int w;

    static final class a<T, R> extends AtomicInteger implements k<T>, m.c.c {

        private static final long serialVersionUID = 8600231336733376951L;
        final AtomicInteger active = new AtomicInteger(1);
        volatile boolean cancelled;
        final boolean delayErrors;
        final m.c.b<? super R> downstream;
        final i.b.m0.j.c errors = new c();
        final n<? super T, ? extends p<? extends R>> mapper;
        final int maxConcurrency;
        final AtomicReference<i.b.m0.f.c<R>> queue = new AtomicReference<>();
        final AtomicLong requested = new AtomicLong();
        final i.b.j0.a set = new a();
        m.c.c upstream;
        a(m.c.b<? super R> bVar, n<? super T, ? extends p<? extends R>> nVar, boolean z, int i) {
            super();
            this.downstream = bVar;
            this.mapper = nVar;
            this.delayErrors = z;
            this.maxConcurrency = i;
            AtomicLong atomicLong = new AtomicLong();
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
                d();
            }
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        public void cancel() {
            this.cancelled = true;
            this.upstream.cancel();
            this.set.dispose();
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        void d() {
            int andGet;
            int cmp;
            Object obj;
            long l3;
            int cmp2;
            Object poll;
            final Object obj2 = this;
            andGet = 1;
            while (/* condition */) {
                andGet = 0;
                while (l3 != l) {
                    int r14 = andGet;
                    Object obj5 = obj2.queue.get();
                    int r16 = andGet;
                }
                if (obj2.addAndGet(-andGet) == 0) {
                    return;
                }
                long l = obj2.requested.get();
                long l2 = 0L;
                int i4 = l2;
                int r6 = andGet;
                r14 = andGet;
                obj5 = obj2.queue.get();
                r16 = andGet;
            }
            a();
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        i.b.m0.f.c<R> e() {
            Object obj = this.queue.get();
            while (obj != null) {
                i.b.m0.f.c cVar = new c(h.b());
                if (this.queue.compareAndSet(null, cVar)) {
                    return cVar;
                }
                obj = this.queue.get();
            }
            return obj;
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        void f(l.a.a<T, R> a.a) {
            int i = 1;
            boolean compareAndSet;
            int decrementAndGet2;
            this.set.c(a.a);
            long l = 1L;
            final int i3 = Integer.MAX_VALUE;
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
                    if (this.maxConcurrency != Integer.MAX_VALUE) {
                        this.upstream.request(l);
                    }
                    if (decrementAndGet() == 0) {
                        return;
                    }
                    d();
                } else {
                    this.active.decrementAndGet();
                    if (this.maxConcurrency != Integer.MAX_VALUE) {
                        this.upstream.request(l);
                    }
                    b();
                }
            }
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        void g(l.a.a<T, R> a.a, Throwable th) {
            i.b.j0.a set2;
            int i = 2147483647;
            this.set.c(a.a);
            if (this.errors.a(th)) {
                if (!this.delayErrors) {
                    this.upstream.cancel();
                    this.set.dispose();
                } else {
                    i = Integer.MAX_VALUE;
                    if (this.maxConcurrency != Integer.MAX_VALUE) {
                        this.upstream.request(1L);
                    }
                }
                this.active.decrementAndGet();
                b();
            } else {
                a.t(th);
            }
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        void h(l.a.a<T, R> a.a, R r) {
            int cmp = 1;
            i.b.j0.a set2;
            boolean compareAndSet;
            int i = 0;
            int i2 = 2147483647;
            this.set.c(a.a);
            if (get() == 0) {
                i = 0;
                i = 1;
                if (compareAndSet(i, i)) {
                    int decrementAndGet = this.active.decrementAndGet();
                    if (decrementAndGet == 0) {
                    }
                    long l2 = this.requested.get();
                    long l = 0L;
                    if (l2 != l) {
                        this.downstream.onNext(r);
                        Object obj = this.queue.get();
                        if (i != 0 && obj != null && obj.isEmpty()) {
                            Throwable th = this.errors.b();
                            if (th != null) {
                                this.downstream.onError(th);
                            } else {
                                this.downstream.onComplete();
                            }
                            return;
                        }
                        AtomicLong atomicLong = 1;
                        d.d(this.requested, atomicLong);
                        i2 = Integer.MAX_VALUE;
                        if (this.maxConcurrency != Integer.MAX_VALUE) {
                            this.upstream.request(atomicLong);
                        }
                    } else {
                        i.b.m0.f.c cVar = e();
                        synchronized (cVar) {
                            try {
                                cVar.offer(r);
                            } catch (Throwable th) {
                            }
                        }
                    }
                    if (decrementAndGet() == 0) {
                        return;
                    }
                } else {
                    i.b.m0.f.c cVar2 = e();
                    synchronized (cVar2) {
                        try {
                            cVar2.offer(th);
                        } catch (Throwable th) {
                        }
                    }
                    this.active.decrementAndGet();
                    if (getAndIncrement() != 0) {
                        return;
                    }
                }
            }
            d();
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
                this.upstream.cancel();
                onError(th);
                return;
            }
            this.active.getAndIncrement();
            i.b.m0.e.b.l.a.a aVar = new l.a.a(this);
            if (!this.cancelled) {
                if (this.set.b(aVar)) {
                    apply.b(aVar);
                }
            }
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        public void onSubscribe(m.c.c cVar) {
            if (g.validate(this.upstream, cVar)) {
                this.upstream = cVar;
                this.downstream.onSubscribe(this);
                int i = Integer.MAX_VALUE;
                if (this.maxConcurrency == Integer.MAX_VALUE) {
                    cVar.request(Long.MAX_VALUE);
                } else {
                    cVar.request((long)maxConcurrency2);
                }
            }
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        public void request(long j) {
            if (g.validate(j)) {
                d.a(this.requested, j);
                b();
            }
        }
    }
    public l(h<T> hVar, n<? super T, ? extends p<? extends R>> nVar, boolean z, int i) {
        super(hVar);
        this.c = nVar;
        this.v = z;
        this.w = i;
    }

    @Override // i.b.m0.e.b.a
    protected void c0(m.c.b<? super R> bVar) {
        this.b.b0(new l.a(bVar, this.c, this.v, this.w));
    }
}
