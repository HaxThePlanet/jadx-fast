package i.b.m0.e.e;

import i.b.j0.b;
import i.b.l0.n;
import i.b.m0.a.c;
import i.b.m0.b.b;
import i.b.m0.c.f;
import i.b.m0.c.j;
import i.b.m0.d.r;
import i.b.m0.d.s;
import i.b.m0.f.c;
import i.b.m0.j.c;
import i.b.m0.j.j;
import i.b.p0.a;
import i.b.w;
import i.b.y;
import io.reactivex.exceptions.a;
import java.util.ArrayDeque;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes3.dex */
public final class v<T, R>  extends i.b.m0.e.e.a<T, R> {

    final n<? super T, ? extends w<? extends R>> b;
    final j c;
    final int v;
    final int w;

    static final class a extends AtomicInteger implements y<T>, b, s<R> {

        private static final long serialVersionUID = 8080567949447303262L;
        int activeCount;
        volatile boolean cancelled;
        r<R> current;
        volatile boolean done;
        final y<? super R> downstream;
        final c error;
        final j errorMode;
        final n<? super T, ? extends w<? extends R>> mapper;
        final int maxConcurrency;
        final ArrayDeque<r<R>> observers;
        final int prefetch;
        j<T> queue;
        int sourceMode;
        b upstream;
        a(y<? super R> y, n<? super T, ? extends w<? extends R>> n2, int i3, int i4, j j5) {
            super();
            this.downstream = y;
            this.mapper = n2;
            this.maxConcurrency = i3;
            this.prefetch = i4;
            this.errorMode = j5;
            c obj1 = new c();
            this.error = obj1;
            obj1 = new ArrayDeque();
            this.observers = obj1;
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        public void a() {
            Object queue;
            int andGet;
            Throwable current;
            int activeCount;
            Object iMMEDIATE2;
            Object bOUNDARY;
            c error;
            Object iMMEDIATE3;
            int maxConcurrency;
            Object rVar;
            int prefetch;
            r rVar2;
            Object iMMEDIATE;
            Object poll;
            int i;
            if (getAndIncrement() != 0) {
            }
            queue = this.queue;
            ArrayDeque observers = this.observers;
            final y downstream = this.downstream;
            final j errorMode = this.errorMode;
            final int i2 = 1;
            andGet = i2;
            while (/* condition */) {
                while (activeCount != this.maxConcurrency) {
                    maxConcurrency = queue.poll();
                    error = this.mapper.apply(maxConcurrency);
                    b.e(error, "The mapper returned a null ObservableSource");
                    rVar = new r(this, this.prefetch);
                    observers.offer(rVar);
                    (w)error.subscribe(rVar);
                    activeCount++;
                }
                this.activeCount = activeCount;
                error = 0;
                activeCount = this.activeCount;
                while (this.cancelled) {
                    poll = current.b().poll();
                    if (poll == null) {
                    } else {
                    }
                    i = error;
                    downstream.onNext(poll);
                    i = i2;
                }
                poll = rVar.poll();
                if (poll == null) {
                } else {
                }
                i = error;
                downstream.onNext(poll);
                this.current = 0;
                this.activeCount = activeCount2 -= i2;
                i = i2;
                rVar = observers.poll();
                if ((r)rVar == null) {
                } else {
                }
                prefetch = error;
                if (prefetch == 0) {
                }
                current = rVar;
                this.current = (r)rVar;
                prefetch = i2;
                maxConcurrency = queue.poll();
                error = this.mapper.apply(maxConcurrency);
                b.e(error, "The mapper returned a null ObservableSource");
                rVar = new r(this, this.prefetch);
                observers.offer(rVar);
                (w)error.subscribe(rVar);
                activeCount++;
            }
            queue.clear();
            e();
        }

        public void b(r<R> r, Throwable throwable2) {
            j iMMEDIATE;
            Object obj3;
            if (this.error.a(throwable2)) {
                if (this.errorMode == j.IMMEDIATE) {
                    this.upstream.dispose();
                }
                r.c();
                a();
            } else {
                a.t(throwable2);
            }
        }

        public void c(r<R> r) {
            r.c();
            a();
        }

        public void d(r<R> r, R r2) {
            r.b().offer(r2);
            a();
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        public void dispose() {
            if (this.cancelled) {
            }
            this.cancelled = true;
            this.upstream.dispose();
            f();
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        void e() {
            r current;
            current = this.current;
            if (current != null) {
                current.dispose();
            }
            current = this.observers.poll();
            while ((r)current == null) {
                (r)current.dispose();
                current = this.observers.poll();
            }
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        void f() {
            int decrementAndGet;
            if (getAndIncrement() == 0) {
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
        public void onError(Throwable throwable) {
            int obj2;
            if (this.error.a(throwable)) {
                this.done = true;
                a();
            } else {
                a.t(throwable);
            }
        }

        public void onNext(T t) {
            int sourceMode;
            if (this.sourceMode == 0) {
                this.queue.offer(t);
            }
            a();
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        public void onSubscribe(b b) {
            boolean validate;
            boolean requestFusion;
            int i;
            Object obj3;
            this.upstream = b;
            requestFusion = (e)b.requestFusion(3);
            int i3 = 1;
            if (c.validate(this.upstream, b) && b instanceof e && requestFusion == i3) {
                this.upstream = b;
                if (b instanceof e) {
                    requestFusion = (e)b.requestFusion(3);
                    i3 = 1;
                    if (requestFusion == i3) {
                        this.sourceMode = requestFusion;
                        this.queue = b;
                        this.done = i3;
                        this.downstream.onSubscribe(this);
                        a();
                    }
                    if (requestFusion == 2) {
                        this.sourceMode = requestFusion;
                        this.queue = b;
                        this.downstream.onSubscribe(this);
                    }
                }
                obj3 = new c(this.prefetch);
                this.queue = obj3;
                this.downstream.onSubscribe(this);
            }
        }
    }
    public v(w<T> w, n<? super T, ? extends w<? extends R>> n2, j j3, int i4, int i5) {
        super(w);
        this.b = n2;
        this.c = j3;
        this.v = i4;
        this.w = i5;
    }

    protected void subscribeActual(y<? super R> y) {
        super(y, this.b, this.v, this.w, this.c);
        this.a.subscribe(aVar2);
    }
}
