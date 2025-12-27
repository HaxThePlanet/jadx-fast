package i.b.m0.e.e;

import i.b.l0.n;
import i.b.m0.c.f;
import i.b.o0.e;
import i.b.w;
import i.b.y;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: ObservableConcatMap.java */
/* loaded from: classes3.dex */
public final class u<T, U> extends a<T, U> {

    final n<? super T, ? extends w<? extends U>> b;
    final int c;
    final i.b.m0.j.j v;

    static final class a<T, R> extends AtomicInteger implements y<T>, i.b.j0.b {

        private static final long serialVersionUID = -6951100001833242599L;
        volatile boolean active;
        final int bufferSize;
        volatile boolean cancelled;
        volatile boolean done;
        final y<? super R> downstream;
        final i.b.m0.j.c error = new c();
        final n<? super T, ? extends w<? extends R>> mapper;
        final u.a.a<R> observer = new u$a$a<>();
        i.b.m0.c.j<T> queue;
        int sourceMode;
        final boolean tillTheEnd;
        i.b.j0.b upstream;
        a(y<? super R> yVar, n<? super T, ? extends w<? extends R>> nVar, int i, boolean z) {
            super();
            this.downstream = yVar;
            this.mapper = nVar;
            this.bufferSize = i;
            this.tillTheEnd = z;
            i.b.m0.j.c cVar = new c();
            i.b.m0.e.e.u.a.a aVar = new u.a.a(yVar, this);
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        void a() {
            boolean cancelled2 = true;
            Object poll;
            if (getAndIncrement() != 0) {
                return;
            }
            while (!this.active) {
                cancelled2 = true;
                try {
                    poll = this.queue.poll();
                } catch (Throwable th) {
                    a.b(th);
                    this.cancelled = upstream22;
                    this.upstream.dispose();
                    th.clear();
                    obj2.a(th);
                    th = obj2.b();
                    obj.onError(th);
                    return;
                }
                boolean r6 = poll == null ? cancelled2 : 0;
                if (cancelled2) {
                }
            }
            this.queue.clear();
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        public void dispose() {
            this.cancelled = true;
            this.upstream.dispose();
            this.observer.a();
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
                this.queue = new c(this.bufferSize);
                this.downstream.onSubscribe(this);
            }
        }
    }

    static final class b<T, U> extends AtomicInteger implements y<T>, i.b.j0.b {

        private static final long serialVersionUID = 8828587559905699186L;
        volatile boolean active;
        final int bufferSize;
        volatile boolean disposed;
        volatile boolean done;
        final y<? super U> downstream;
        int fusionMode;
        final u.b.a<U> inner = new u$b$a<>();
        final n<? super T, ? extends w<? extends U>> mapper;
        i.b.m0.c.j<T> queue;
        i.b.j0.b upstream;
        b(y<? super U> yVar, n<? super T, ? extends w<? extends U>> nVar, int i) {
            super();
            this.downstream = yVar;
            this.mapper = nVar;
            this.bufferSize = i;
            final i.b.m0.e.e.u.b.a aVar = new u.b.a(yVar, this);
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        void a() {
            Object poll;
            boolean z;
            int i;
            if (getAndIncrement() != 0) {
                return;
            }
            while (this.disposed) {
                if (decrementAndGet() == 0) {
                    return;
                }
                try {
                    poll = this.queue.poll();
                } catch (Throwable th) {
                    a.b(th);
                    dispose();
                    this.queue.clear();
                    this.queue.onError(th);
                    return;
                }
                z = true;
                boolean r3 = this.queue == null ? z : 0;
            }
            this.queue.clear();
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        void b() {
            this.active = false;
            a();
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        public void dispose() {
            this.disposed = true;
            this.inner.a();
            this.upstream.dispose();
            if (getAndIncrement() == 0) {
                this.queue.clear();
            }
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        public boolean isDisposed() {
            return this.disposed;
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        public void onComplete() {
            if (this.done) {
                return;
            }
            this.done = true;
            a();
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        public void onError(Throwable th) {
            if (this.done) {
                a.t(th);
                return;
            }
            this.done = true;
            dispose();
            this.downstream.onError(th);
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        public void onNext(T t) {
            if (this.done) {
                return;
            }
            if (this.fusionMode == 0) {
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
                        this.fusionMode = requestFusion;
                        this.queue = bVar;
                        this.done = true;
                        this.downstream.onSubscribe(this);
                        a();
                        return;
                    }
                    i = 2;
                    if (requestFusion == 2) {
                        this.fusionMode = requestFusion;
                        this.queue = bVar;
                        this.downstream.onSubscribe(this);
                        return;
                    }
                }
                this.queue = new c(this.bufferSize);
                this.downstream.onSubscribe(this);
            }
        }
    }
    public u(w<T> wVar, n<? super T, ? extends w<? extends U>> nVar, int i, i.b.m0.j.j jVar) {
        super(wVar);
        this.b = nVar;
        this.v = jVar;
        this.c = Math.max(8, i);
    }

    @Override // i.b.m0.e.e.a
    public void subscribeActual(y<? super U> yVar) {
        boolean z = false;
        if (y2.b(this.a, yVar, this.b)) {
            return;
        }
        if (this.v == j.IMMEDIATE) {
            this.a.subscribe(new u.b(new e(yVar), this.b, this.c));
        } else {
            int r4 = this.v == j.END ? 1 : 0;
            u.a aVar = new u.a(yVar, this.b, this.c, (this.v == j.END ? 1 : 0));
            this.a.subscribe(aVar);
        }
    }
}
