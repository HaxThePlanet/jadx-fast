package i.b.m0.e.d;

import i.b.b;
import i.b.d;
import i.b.f;
import i.b.j0.b;
import i.b.l0.n;
import i.b.m0.a.c;
import i.b.m0.b.b;
import i.b.m0.c.f;
import i.b.m0.c.j;
import i.b.m0.f.c;
import i.b.m0.j.c;
import i.b.m0.j.j;
import i.b.m0.j.k;
import i.b.p0.a;
import i.b.r;
import i.b.y;
import io.reactivex.exceptions.a;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes3.dex */
public final class c<T>  extends b {

    final r<T> a;
    final n<? super T, ? extends f> b;
    final j c;
    final int v;

    static final class a extends AtomicInteger implements y<T>, b {

        private static final long serialVersionUID = 3610901111000061034L;
        volatile boolean active;
        volatile boolean disposed;
        volatile boolean done;
        final d downstream;
        final j errorMode;
        final c errors;
        final i.b.m0.e.d.c.a.a inner;
        final n<? super T, ? extends f> mapper;
        final int prefetch;
        j<T> queue;
        b upstream;
        a(d d, n<? super T, ? extends f> n2, j j3, int i4) {
            super();
            this.downstream = d;
            this.mapper = n2;
            this.errorMode = j3;
            this.prefetch = i4;
            c obj1 = new c();
            this.errors = obj1;
            obj1 = new c.a.a(this);
            this.inner = obj1;
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        void a() {
            Object downstream;
            Object errorMode;
            j decrementAndGet;
            Object bOUNDARY;
            boolean active;
            boolean z;
            int apply;
            int i;
            if (getAndIncrement() != 0) {
            }
            c errors = this.errors;
            while (this.disposed) {
                z = 1;
                apply = 0;
                Object poll = this.queue.poll();
                if (poll != null) {
                } else {
                }
                i = z;
                if (i == 0) {
                }
                this.active = z;
                apply.b(this.inner);
                b.e(this.mapper.apply(poll), "The mapper returned a null CompletableSource");
                i = 0;
            }
            this.queue.clear();
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        void b() {
            this.active = false;
            a();
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        void c(Throwable throwable) {
            Object iMMEDIATE;
            Throwable obj2;
            if (this.errors.a(throwable)) {
                if (this.errorMode == j.IMMEDIATE) {
                    this.disposed = true;
                    this.upstream.dispose();
                    obj2 = this.errors.b();
                    if (obj2 != k.a) {
                        this.downstream.onError(obj2);
                    }
                    if (getAndIncrement() == 0) {
                        this.queue.clear();
                    }
                } else {
                    this.active = false;
                    a();
                }
            } else {
                a.t(throwable);
            }
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        public void dispose() {
            int andIncrement;
            this.disposed = true;
            this.upstream.dispose();
            this.inner.a();
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
            this.done = true;
            a();
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        public void onError(Throwable throwable) {
            Object iMMEDIATE;
            int i;
            Throwable obj3;
            if (this.errors.a(throwable)) {
                i = 1;
                if (this.errorMode == j.IMMEDIATE) {
                    this.disposed = i;
                    this.inner.a();
                    obj3 = this.errors.b();
                    if (obj3 != k.a) {
                        this.downstream.onError(obj3);
                    }
                    if (getAndIncrement() == 0) {
                        this.queue.clear();
                    }
                } else {
                    this.done = i;
                    a();
                }
            } else {
                a.t(throwable);
            }
        }

        public void onNext(T t) {
            j queue;
            if (t != null) {
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
                        this.queue = b;
                        this.done = i3;
                        this.downstream.onSubscribe(this);
                        a();
                    }
                    if (requestFusion == 2) {
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
    public c(r<T> r, n<? super T, ? extends f> n2, j j3, int i4) {
        super();
        this.a = r;
        this.b = n2;
        this.c = j3;
        this.v = i4;
    }

    @Override // i.b.b
    protected void x(d d) {
        boolean z;
        Object aVar;
        n nVar;
        j jVar;
        int i;
        if (!i.a(this.a, this.b, d)) {
            aVar = new c.a(d, this.b, this.c, this.v);
            this.a.subscribe(aVar);
        }
    }
}
