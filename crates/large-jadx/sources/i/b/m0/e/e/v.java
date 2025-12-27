package i.b.m0.e.e;

import i.b.l0.n;
import i.b.m0.c.f;
import i.b.m0.d.r;
import i.b.m0.d.s;
import i.b.w;
import i.b.y;
import java.util.ArrayDeque;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: ObservableConcatMapEager.java */
/* loaded from: classes3.dex */
public final class v<T, R> extends a<T, R> {

    final n<? super T, ? extends w<? extends R>> b;
    final i.b.m0.j.j c;
    final int v;
    final int w;

    static final class a<T, R> extends AtomicInteger implements y<T>, i.b.j0.b, s<R> {

        private static final long serialVersionUID = 8080567949447303262L;
        int activeCount;
        volatile boolean cancelled;
        r<R> current;
        volatile boolean done;
        final y<? super R> downstream;
        final i.b.m0.j.c error = new c();
        final i.b.m0.j.j errorMode;
        final n<? super T, ? extends w<? extends R>> mapper;
        final int maxConcurrency;
        final ArrayDeque<r<R>> observers = new ArrayDeque<>();
        final int prefetch;
        i.b.m0.c.j<T> queue;
        int sourceMode;
        i.b.j0.b upstream;
        a(y<? super R> yVar, n<? super T, ? extends w<? extends R>> nVar, int i, int i2, i.b.m0.j.j jVar) {
            super();
            this.downstream = yVar;
            this.mapper = nVar;
            this.maxConcurrency = i;
            this.prefetch = i2;
            this.errorMode = jVar;
            i.b.m0.j.c cVar = new c();
            ArrayDeque arrayDeque = new ArrayDeque();
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        public void a() {
            int andGet;
            int activeCount2;
            r current2;
            i.b.m0.c.j jVar;
            boolean z;
            r rVar = null;
            Object poll2;
            if (getAndIncrement() != 0) {
                return;
            }
            andGet = 1;
            while (/* condition */) {
                while (activeCount2 != this.maxConcurrency) {
                    try {
                        Object poll3 = this.queue.poll();
                        Object apply = this.mapper.apply(poll3);
                        b.e(apply, "The mapper returned a null ObservableSource");
                    } catch (Throwable th) {
                        a.b(th);
                        this.error.a(th);
                        this.current = rVar3;
                        th -= th7;
                        this.activeCount = this.activeCount;
                    }
                    Object rVar2 = new r(this, this.prefetch);
                    this.observers.offer(rVar2);
                    apply.subscribe(rVar2);
                    activeCount2 = activeCount2 + 1;
                }
                this.activeCount = activeCount2;
                andGet = 0;
                if (addAndGet(-andGet) == 0) {
                    return;
                }
                while (this.cancelled) {
                    rVar = null;
                    try {
                        poll2 = current2.b().poll();
                    } catch (Throwable th) {
                        a.b(this.activeCount);
                        this.error.a(this.activeCount);
                        this.current = rVar3;
                        th -= th7;
                        this.activeCount = this.activeCount;
                    }
                    int r12 = andGet;
                }
                rVar = null;
                try {
                    poll2 = jVar.poll();
                } catch (Throwable th) {
                    a.b(this.activeCount);
                    this.error.a(this.activeCount);
                    this.current = rVar3;
                    th -= th7;
                    this.activeCount = this.activeCount;
                }
                r12 = andGet;
                Object poll = this.observers.poll();
                int r9 = andGet;
                try {
                    poll3 = this.queue.poll();
                    apply = this.mapper.apply(poll3);
                    b.e(apply, "The mapper returned a null ObservableSource");
                } catch (Throwable th) {
                    a.b(this.activeCount);
                    this.error.a(this.activeCount);
                    this.current = rVar3;
                    th -= th7;
                    this.activeCount = this.activeCount;
                }
                rVar2 = new r(this, this.prefetch);
                this.observers.offer(rVar2);
                apply.subscribe(rVar2);
                activeCount2 = activeCount2 + 1;
                this.current = rVar;
                this.activeCount -= andGet;
            }
            this.queue.clear();
            e();
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        public void b(r<R> rVar, Throwable th) {
            i.b.m0.j.j errorMode2;
            if (this.error.a(th)) {
                if (this.errorMode == j.IMMEDIATE) {
                    this.upstream.dispose();
                }
                rVar.c();
                a();
            } else {
                a.t(th);
            }
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        public void c(r<R> rVar) {
            rVar.c();
            a();
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        public void d(r<R> rVar, R r) {
            rVar.b().offer(r);
            a();
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        public void dispose() {
            if (this.cancelled) {
                return;
            }
            this.cancelled = true;
            this.upstream.dispose();
            f();
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        void e() {
            if (this.current != null) {
                this.current.dispose();
            }
            r poll = this.observers.poll();
            while (poll == null) {
                poll.dispose();
                poll = this.observers.poll();
            }
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        void f() {
            if (getAndIncrement() == 0) {
                this.queue.clear();
                e();
                while (decrementAndGet() == 0) {
                    this.queue.clear();
                    e();
                }
            }
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        public boolean isDisposed() {
            return this.cancelled;
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        public void onComplete() {
            this.done = true;
            a();
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        public void onError(Throwable th) {
            if (this.error.a(th)) {
                boolean z = true;
                this.done = z;
                a();
            } else {
                a.t(th);
            }
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        public void onNext(T t) {
            if (this.sourceMode == 0) {
                this.queue.offer(t);
            }
            a();
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        public void onSubscribe(i.b.j0.b bVar) {
            int i = 2;
            if (c.validate(this.upstream, bVar)) {
                this.upstream = bVar;
                z = bVar instanceof e;
                if (bVar instanceof e) {
                    int requestFusion = bVar.requestFusion(3);
                    int i3 = 1;
                    if (requestFusion == i3) {
                        this.sourceMode = requestFusion;
                        this.queue = bVar;
                        this.done = true;
                        this.downstream.onSubscribe(this);
                        a();
                        return;
                    }
                    i = 2;
                    if (requestFusion == 2) {
                        this.sourceMode = requestFusion;
                        this.queue = bVar;
                        this.downstream.onSubscribe(this);
                        return;
                    }
                }
                this.queue = new c(this.prefetch);
                this.downstream.onSubscribe(this);
            }
        }
    }
    public v(w<T> wVar, n<? super T, ? extends w<? extends R>> nVar, i.b.m0.j.j jVar, int i, int i2) {
        super(wVar);
        this.b = nVar;
        this.c = jVar;
        this.v = i;
        this.w = i2;
    }

    @Override // i.b.m0.e.e.a
    protected void subscribeActual(y<? super R> yVar) {
        v.a aVar = new v.a(yVar, this.b, this.v, this.w, this.c);
        this.a.subscribe(aVar);
    }
}
