package i.b.m0.e.e;

import i.b.j0.b;
import i.b.l0.n;
import i.b.m0.a.c;
import i.b.m0.b.b;
import i.b.m0.c.f;
import i.b.m0.c.j;
import i.b.m0.f.c;
import i.b.m0.j.c;
import i.b.m0.j.j;
import i.b.o0.e;
import i.b.p0.a;
import i.b.w;
import i.b.y;
import io.reactivex.exceptions.a;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes3.dex */
public final class u<T, U>  extends i.b.m0.e.e.a<T, U> {

    final n<? super T, ? extends w<? extends U>> b;
    final int c;
    final j v;

    static final class a extends AtomicInteger implements y<T>, b {

        private static final long serialVersionUID = -6951100001833242599L;
        volatile boolean active;
        final int bufferSize;
        volatile boolean cancelled;
        volatile boolean done;
        final y<? super R> downstream;
        final c error;
        final n<? super T, ? extends w<? extends R>> mapper;
        final i.b.m0.e.e.u.a.a<R> observer;
        j<T> queue;
        int sourceMode;
        final boolean tillTheEnd;
        b upstream;
        a(y<? super R> y, n<? super T, ? extends w<? extends R>> n2, int i3, boolean z4) {
            super();
            this.downstream = y;
            this.mapper = n2;
            this.bufferSize = i3;
            this.tillTheEnd = z4;
            c obj2 = new c();
            this.error = obj2;
            obj2 = new u.a.a(y, this);
            this.observer = obj2;
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        void a() {
            Throwable decrementAndGet;
            boolean tillTheEnd;
            boolean active;
            boolean cancelled;
            boolean poll;
            int i;
            if (getAndIncrement() != 0) {
            }
            y downstream = this.downstream;
            j queue = this.queue;
            final c error = this.error;
            while (!this.active) {
                cancelled = 1;
                poll = queue.poll();
                if (poll == null) {
                } else {
                }
                i = 0;
                active = this.mapper.apply(poll);
                b.e(active, "The mapper returned a null ObservableSource");
                this.active = cancelled;
                (w)active.subscribe(this.observer);
                decrementAndGet = (Callable)active.call();
                if (decrementAndGet != null && !this.cancelled) {
                }
                if (!this.cancelled) {
                }
                downstream.onNext(decrementAndGet);
                i = cancelled;
            }
            queue.clear();
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
            boolean bufferSize;
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
                obj3 = new c(this.bufferSize);
                this.queue = obj3;
                this.downstream.onSubscribe(this);
            }
        }
    }

    static final class b extends AtomicInteger implements y<T>, b {

        private static final long serialVersionUID = 8828587559905699186L;
        volatile boolean active;
        final int bufferSize;
        volatile boolean disposed;
        volatile boolean done;
        final y<? super U> downstream;
        int fusionMode;
        final i.b.m0.e.e.u.b.a<U> inner;
        final n<? super T, ? extends w<? extends U>> mapper;
        j<T> queue;
        b upstream;
        b(y<? super U> y, n<? super T, ? extends w<? extends U>> n2, int i3) {
            super();
            this.downstream = y;
            this.mapper = n2;
            this.bufferSize = i3;
            u.b.a obj2 = new u.b.a(y, this);
            this.inner = obj2;
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        void a() {
            int decrementAndGet;
            boolean active;
            Object downstream;
            int i;
            int i2;
            if (getAndIncrement() != 0) {
            }
            while (this.disposed) {
                downstream = this.queue.poll();
                i = 1;
                if (downstream == null) {
                } else {
                }
                i2 = 0;
                if (i2 == 0) {
                }
                active = this.mapper.apply(downstream);
                b.e(active, "The mapper returned a null ObservableSource");
                this.active = i;
                (w)active.subscribe(this.inner);
                i2 = i;
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
            int andIncrement;
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
            }
            this.done = true;
            a();
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        public void onError(Throwable throwable) {
            if (this.done) {
                a.t(throwable);
            }
            this.done = true;
            dispose();
            this.downstream.onError(throwable);
        }

        public void onNext(T t) {
            int fusionMode;
            if (this.done) {
            }
            if (this.fusionMode == 0) {
                this.queue.offer(t);
            }
            a();
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        public void onSubscribe(b b) {
            boolean bufferSize;
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
                        this.fusionMode = requestFusion;
                        this.queue = b;
                        this.done = i3;
                        this.downstream.onSubscribe(this);
                        a();
                    }
                    if (requestFusion == 2) {
                        this.fusionMode = requestFusion;
                        this.queue = b;
                        this.downstream.onSubscribe(this);
                    }
                }
                obj3 = new c(this.bufferSize);
                this.queue = obj3;
                this.downstream.onSubscribe(this);
            }
        }
    }
    public u(w<T> w, n<? super T, ? extends w<? extends U>> n2, int i3, j j4) {
        super(w);
        this.b = n2;
        this.v = j4;
        this.c = Math.max(8, i3);
    }

    public void subscribeActual(y<? super U> y) {
        Object eVar;
        AtomicInteger bVar;
        n nVar;
        int i;
        int i2;
        j eND;
        Object obj7;
        if (y2.b(this.a, y, this.b)) {
        }
        if (this.v == j.IMMEDIATE) {
            eVar = new e(y);
            bVar = new u.b(eVar, this.b, this.c);
            this.a.subscribe(bVar);
        } else {
            i2 = this.v == j.END ? 1 : 0;
            bVar = new u.a(y, this.b, this.c, i2);
            this.a.subscribe(bVar);
        }
    }
}
