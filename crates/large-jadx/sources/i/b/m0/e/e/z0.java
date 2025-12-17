package i.b.m0.e.e;

import i.b.g0;
import i.b.j0.a;
import i.b.j0.b;
import i.b.l0.n;
import i.b.m0.a.c;
import i.b.m0.b.b;
import i.b.m0.f.c;
import i.b.m0.j.c;
import i.b.p0.a;
import i.b.r;
import i.b.w;
import i.b.y;
import io.reactivex.exceptions.a;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes3.dex */
public final class z0<T, R>  extends i.b.m0.e.e.a<T, R> {

    final n<? super T, ? extends g0<? extends R>> b;
    final boolean c;

    static final class a extends AtomicInteger implements y<T>, b {

        private static final long serialVersionUID = 8600231336733376951L;
        final AtomicInteger active;
        volatile boolean cancelled;
        final boolean delayErrors;
        final y<? super R> downstream;
        final c errors;
        final n<? super T, ? extends g0<? extends R>> mapper;
        final AtomicReference<c<R>> queue;
        final a set;
        b upstream;
        a(y<? super R> y, n<? super T, ? extends g0<? extends R>> n2, boolean z3) {
            super();
            this.downstream = y;
            this.mapper = n2;
            this.delayErrors = z3;
            a obj1 = new a();
            this.set = obj1;
            obj1 = new c();
            this.errors = obj1;
            obj1 = new AtomicInteger(1);
            this.active = obj1;
            obj1 = new AtomicReference();
            this.queue = obj1;
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        void a() {
            Object obj = this.queue.get();
            if ((c)obj != null) {
                (c)obj.clear();
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
            int i;
            boolean delayErrors;
            int i2;
            int poll;
            final y downstream = this.downstream;
            final int i3 = 1;
            andGet = i3;
            while (this.cancelled) {
                if (this.active.get() == 0) {
                } else {
                }
                i = i2;
                Object obj = this.queue.get();
                if ((c)obj != null) {
                } else {
                }
                poll = 0;
                if (poll == 0) {
                }
                downstream.onNext(poll);
                i2 = i3;
                poll = (c)obj.poll();
                i = i3;
            }
            a();
        }

        c<R> d() {
            Object obj = this.queue.get();
            while ((c)obj != null) {
                c cVar = new c(r.bufferSize());
                obj = this.queue.get();
            }
            return (c)(c)obj;
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        public void dispose() {
            this.cancelled = true;
            this.upstream.dispose();
            this.set.dispose();
        }

        void e(i.b.m0.e.e.z0.a.a<T, R> z0$a.a, Throwable throwable2) {
            boolean obj2;
            this.set.c(a.a);
            if (this.errors.a(throwable2)) {
                if (!this.delayErrors) {
                    this.upstream.dispose();
                    this.set.dispose();
                }
                this.active.decrementAndGet();
                b();
            } else {
                a.t(throwable2);
            }
        }

        void f(i.b.m0.e.e.z0.a.a<T, R> z0$a.a, R r2) {
            int set;
            y compareAndSet;
            int obj3;
            Object obj4;
            this.set.c(a.a);
            set = 1;
            if (get() == 0 && compareAndSet(0, set)) {
                set = 1;
                if (compareAndSet(0, set)) {
                    this.downstream.onNext(r2);
                    if (this.active.decrementAndGet() == 0) {
                        obj3 = set;
                    }
                    obj4 = this.queue.get();
                    if (obj3 != null) {
                        if ((c)obj4 != null) {
                            if ((c)obj4.isEmpty()) {
                                obj3 = this.errors.b();
                                if (obj3 != null) {
                                    this.downstream.onError(obj3);
                                } else {
                                    this.downstream.onComplete();
                                }
                            }
                        } else {
                        }
                    }
                    if (decrementAndGet() == 0) {
                    }
                } else {
                    obj3 = d();
                    obj3.offer(r2);
                    this.active.decrementAndGet();
                    synchronized (obj3) {
                        obj3 = d();
                        obj3.offer(r2);
                        this.active.decrementAndGet();
                    }
                }
            } else {
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
        public void onError(Throwable throwable) {
            boolean obj2;
            this.active.decrementAndGet();
            if (this.errors.a(throwable)) {
                if (!this.delayErrors) {
                    this.set.dispose();
                }
                b();
            } else {
                a.t(throwable);
            }
        }

        public void onNext(T t) {
            boolean cancelled;
            try {
                final Object obj3 = this.mapper.apply(t);
                b.e(obj3, "The mapper returned a null SingleSource");
                this.active.getAndIncrement();
                z0.a.a aVar = new z0.a.a(this);
                if (!this.cancelled && this.set.b(aVar)) {
                }
                if (this.set.b(aVar)) {
                }
                (g0)obj3.subscribe(aVar);
                a.b(t);
                this.upstream.dispose();
                onError(t);
            }
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        public void onSubscribe(b b) {
            Object obj2;
            if (c.validate(this.upstream, b)) {
                this.upstream = b;
                this.downstream.onSubscribe(this);
            }
        }
    }
    public z0(w<T> w, n<? super T, ? extends g0<? extends R>> n2, boolean z3) {
        super(w);
        this.b = n2;
        this.c = z3;
    }

    protected void subscribeActual(y<? super R> y) {
        z0.a aVar = new z0.a(y, this.b, this.c);
        this.a.subscribe(aVar);
    }
}
