package i.b.m0.e.b;

import i.b.h;
import i.b.k;
import i.b.l0.n;
import i.b.m0.b.b;
import i.b.m0.c.f;
import i.b.m0.c.j;
import i.b.m0.f.b;
import i.b.m0.i.f;
import i.b.m0.i.g;
import i.b.m0.j.c;
import i.b.m0.j.j;
import i.b.p0.a;
import io.reactivex.exceptions.a;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import m.c.a;
import m.c.b;
import m.c.c;

/* loaded from: classes3.dex */
public final class b<T, R>  extends i.b.m0.e.b.a<T, R> {

    final n<? super T, ? extends a<? extends R>> c;
    final int v;
    final j w;

    static class a {

        static final int[] a;
        static {
            int[] iArr = new int[values.length];
            b.a.a = iArr;
            iArr[j.BOUNDARY.ordinal()] = 1;
            b.a.a[j.END.ordinal()] = 2;
        }
    }

    interface f {
        public abstract void a(Throwable throwable);

        public abstract void b(T t);

        public abstract void d();
    }

    static final class g implements c {

        final b<? super T> a;
        final T b;
        boolean c;
        g(T t, b<? super T> b2) {
            super();
            this.b = t;
            this.a = b2;
        }

        @Override // m.c.c
        public void cancel() {
        }

        @Override // m.c.c
        public void request(long l) {
            int obj3;
            Object obj4;
            if (Long.compare(l, i) > 0 && !this.c) {
                if (!this.c) {
                    this.c = true;
                    obj3 = this.a;
                    obj3.onNext(this.b);
                    obj3.onComplete();
                }
            }
        }
    }

    static abstract class b extends AtomicInteger implements k<T>, i.b.m0.e.b.b.f<R>, c {

        private static final long serialVersionUID = -3511336836796789179L;
        volatile boolean active;
        volatile boolean cancelled;
        int consumed;
        volatile boolean done;
        final c errors;
        final i.b.m0.e.b.b.e<R> inner;
        final int limit;
        final n<? super T, ? extends a<? extends R>> mapper;
        final int prefetch;
        j<T> queue;
        int sourceMode;
        c upstream;
        b(n<? super T, ? extends a<? extends R>> n, int i2) {
            super();
            this.mapper = n;
            this.prefetch = i2;
            this.limit = i2 -= obj1;
            b.e obj1 = new b.e(this);
            this.inner = obj1;
            obj1 = new c();
            this.errors = obj1;
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        public final void d() {
            this.active = false;
            e();
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        abstract void e();

        @Override // java.util.concurrent.atomic.AtomicInteger
        abstract void f();

        @Override // java.util.concurrent.atomic.AtomicInteger
        public final void onComplete() {
            this.done = true;
            e();
        }

        public final void onNext(T t) {
            int sourceMode;
            Object obj3;
            if (this.sourceMode != 2 && !this.queue.offer(t)) {
                if (!this.queue.offer(t)) {
                    this.upstream.cancel();
                    obj3 = new IllegalStateException("Queue full?!");
                    onError(obj3);
                }
            }
            e();
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        public final void onSubscribe(c c) {
            boolean validate;
            boolean z;
            int requestFusion;
            int i;
            this.upstream = c;
            z = c;
            requestFusion = (g)z.requestFusion(7);
            int i3 = 1;
            if (g.validate(this.upstream, c) && c instanceof g && requestFusion == i3) {
                this.upstream = c;
                if (c instanceof g) {
                    z = c;
                    requestFusion = (g)z.requestFusion(7);
                    i3 = 1;
                    if (requestFusion == i3) {
                        this.sourceMode = requestFusion;
                        this.queue = z;
                        this.done = i3;
                        f();
                        e();
                    }
                    if (requestFusion == 2) {
                        this.sourceMode = requestFusion;
                        this.queue = z;
                        f();
                        c.request((long)prefetch2);
                    }
                }
                requestFusion = this.prefetch;
                b bVar = new b(requestFusion);
                this.queue = bVar;
                f();
                c.request((long)prefetch);
            }
        }
    }

    static final class e extends f implements k<R> {

        private static final long serialVersionUID = 897683679971470653L;
        final i.b.m0.e.b.b.f<R> parent;
        long produced;
        e(i.b.m0.e.b.b.f<R> b$f) {
            super(0);
            this.parent = f;
        }

        @Override // i.b.m0.i.f
        public void onComplete() {
            long produced = this.produced;
            final int i = 0;
            if (Long.compare(produced, i) != 0) {
                this.produced = i;
                f(produced);
            }
            this.parent.d();
        }

        @Override // i.b.m0.i.f
        public void onError(Throwable throwable) {
            long produced = this.produced;
            final int i = 0;
            if (Long.compare(produced, i) != 0) {
                this.produced = i;
                f(produced);
            }
            this.parent.a(throwable);
        }

        public void onNext(R r) {
            this.produced = produced += i2;
            this.parent.b(r);
        }

        @Override // i.b.m0.i.f
        public void onSubscribe(c c) {
            g(c);
        }
    }

    static final class c extends i.b.m0.e.b.b.b<T, R> {

        private static final long serialVersionUID = -2945777694260521066L;
        final b<? super R> downstream;
        final boolean veryEnd;
        c(b<? super R> b, n<? super T, ? extends a<? extends R>> n2, int i3, boolean z4) {
            super(n2, i3);
            this.downstream = b;
            this.veryEnd = z4;
        }

        @Override // i.b.m0.e.b.b$b
        public void a(Throwable throwable) {
            boolean obj2;
            if (this.errors.a(throwable)) {
                if (!this.veryEnd) {
                    this.upstream.cancel();
                    this.done = true;
                }
                this.active = false;
                e();
            } else {
                a.t(throwable);
            }
        }

        public void b(R r) {
            this.downstream.onNext(r);
        }

        @Override // i.b.m0.e.b.b$b
        public void cancel() {
            boolean cancelled;
            if (!this.cancelled) {
                this.cancelled = true;
                this.inner.cancel();
                this.upstream.cancel();
            }
        }

        @Override // i.b.m0.e.b.b$b
        void e() {
            int decrementAndGet;
            Object downstream;
            Object veryEnd;
            int sourceMode;
            int gVar;
            int i;
            int limit;
            if (getAndIncrement() == 0) {
            }
        }

        @Override // i.b.m0.e.b.b$b
        void f() {
            this.downstream.onSubscribe(this);
        }

        @Override // i.b.m0.e.b.b$b
        public void onError(Throwable throwable) {
            int obj2;
            if (this.errors.a(throwable)) {
                this.done = true;
                e();
            } else {
                a.t(throwable);
            }
        }

        @Override // i.b.m0.e.b.b$b
        public void request(long l) {
            this.inner.request(l);
        }
    }

    static final class d extends i.b.m0.e.b.b.b<T, R> {

        private static final long serialVersionUID = 7898995095634264146L;
        final b<? super R> downstream;
        final AtomicInteger wip;
        d(b<? super R> b, n<? super T, ? extends a<? extends R>> n2, int i3) {
            super(n2, i3);
            this.downstream = b;
            AtomicInteger obj1 = new AtomicInteger();
            this.wip = obj1;
        }

        @Override // i.b.m0.e.b.b$b
        public void a(Throwable throwable) {
            boolean z;
            Throwable obj2;
            if (this.errors.a(throwable)) {
                this.upstream.cancel();
                if (getAndIncrement() == 0) {
                    this.downstream.onError(this.errors.b());
                }
            } else {
                a.t(throwable);
            }
        }

        public void b(R r) {
            int i;
            int i2;
            boolean compareAndSet;
            Object obj4;
            i = 0;
            i2 = 1;
            this.downstream.onNext(r);
            if (get() == 0 && compareAndSet(i, i2) && compareAndSet(i2, i)) {
                i = 0;
                i2 = 1;
                if (compareAndSet(i, i2)) {
                    this.downstream.onNext(r);
                    if (compareAndSet(i2, i)) {
                    }
                    this.downstream.onError(this.errors.b());
                }
            }
        }

        @Override // i.b.m0.e.b.b$b
        public void cancel() {
            boolean cancelled;
            if (!this.cancelled) {
                this.cancelled = true;
                this.inner.cancel();
                this.upstream.cancel();
            }
        }

        @Override // i.b.m0.e.b.b$b
        void e() {
            int decrementAndGet;
            c compareAndSet;
            int sourceMode;
            int gVar;
            int i;
            int upstream;
            long l;
            if (this.wip.getAndIncrement() == 0) {
            }
        }

        @Override // i.b.m0.e.b.b$b
        void f() {
            this.downstream.onSubscribe(this);
        }

        @Override // i.b.m0.e.b.b$b
        public void onError(Throwable throwable) {
            boolean z;
            Throwable obj2;
            if (this.errors.a(throwable)) {
                this.inner.cancel();
                if (getAndIncrement() == 0) {
                    this.downstream.onError(this.errors.b());
                }
            } else {
                a.t(throwable);
            }
        }

        @Override // i.b.m0.e.b.b$b
        public void request(long l) {
            this.inner.request(l);
        }
    }
    public b(h<T> h, n<? super T, ? extends a<? extends R>> n2, int i3, j j4) {
        super(h);
        this.c = n2;
        this.v = i3;
        this.w = j4;
    }

    public static <T, R> b<T> g0(b<? super R> b, n<? super T, ? extends a<? extends R>> n2, int i3, j j4) {
        int obj5 = b.a.a[j4.ordinal()];
        int i = 1;
        if (obj5 != i && obj5 != 2) {
            if (obj5 != 2) {
                obj5 = new b.d(b, n2, i3);
                return obj5;
            }
            obj5 = new b.c(b, n2, i3, i);
            return obj5;
        }
        obj5 = new b.c(b, n2, i3, 0);
        return obj5;
    }

    protected void c0(b<? super R> b) {
        if (i0.b(this.b, b, this.c)) {
        }
        this.b.a(b.g0(b, this.c, this.v, this.w));
    }
}
