package i.b.m0.e.e;

import i.b.j0.b;
import i.b.m0.a.c;
import i.b.m0.a.g;
import i.b.m0.j.k;
import i.b.p0.a;
import i.b.r;
import i.b.w;
import i.b.y;
import i.b.z;
import i.b.z.c;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: ObservableTimeoutTimed.java */
/* loaded from: classes3.dex */
public final class z3<T> extends a<T, T> {

    final long b;
    final TimeUnit c;
    final z v;
    final w<? extends T> w;

    interface d {
        void a(long j);
    }

    static final class e implements Runnable {

        final z3.d a;
        final long b;
        e(long j, z3.d dVar) {
            super();
            this.b = j;
            this.a = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.a.a(this.b);
        }
    }

    static final class a<T> implements y<T> {

        final y<? super T> a;
        final AtomicReference<b> b;
        a(y<? super T> yVar, AtomicReference<b> atomicReference) {
            super();
            this.a = yVar;
            this.b = atomicReference;
        }

        public void onComplete() {
            this.a.onComplete();
        }

        public void onError(Throwable th) {
            this.a.onError(th);
        }

        public void onNext(T t) {
            this.a.onNext(t);
        }

        public void onSubscribe(b bVar) {
            c.replace(this.b, bVar);
        }
    }

    static final class b<T> extends AtomicReference<b> implements y<T>, b, z3.d {

        private static final long serialVersionUID = 3764492702657003550L;
        final y<? super T> downstream;
        w<? extends T> fallback;
        final AtomicLong index = new AtomicLong();
        final g task = new g();
        final long timeout;
        final TimeUnit unit;
        final AtomicReference<b> upstream = new AtomicReference<>();
        final z.c worker;
        b(y<? super T> yVar, long j, TimeUnit timeUnit, z.c cVar, w<? extends T> wVar) {
            super();
            this.downstream = yVar;
            this.timeout = j;
            this.unit = timeUnit;
            this.worker = cVar;
            this.fallback = wVar;
            g gVar = new g();
            AtomicLong atomicLong = new AtomicLong();
            AtomicReference atomicReference = new AtomicReference();
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public void a(long j) {
            if (this.index.compareAndSet(j, Long.MAX_VALUE)) {
                c.dispose(this.upstream);
                this.fallback = null;
                this.fallback.subscribe(new z3.a(this.downstream, this));
                this.worker.dispose();
            }
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        void c(long j) {
            this.task.a(this.worker.c(new z3.e(j, r6, this), this.timeout, this.unit));
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public void dispose() {
            c.dispose(this.upstream);
            c.dispose(this);
            this.worker.dispose();
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
                this.worker.dispose();
            }
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public void onError(Throwable th) {
            final long l = Long.MAX_VALUE;
            final long andSet = this.index.getAndSet(l);
            if (andSet != Long.MAX_VALUE) {
                this.task.dispose();
                this.downstream.onError(th);
                this.worker.dispose();
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
                    (b)this.task.get().dispose();
                    this.downstream.onNext(t);
                    c(l2);
                }
            }
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public void onSubscribe(b bVar) {
            c.setOnce(this.upstream, bVar);
        }
    }

    static final class c<T> extends AtomicLong implements y<T>, b, z3.d {

        private static final long serialVersionUID = 3764492702657003550L;
        final y<? super T> downstream;
        final g task = new g();
        final long timeout;
        final TimeUnit unit;
        final AtomicReference<b> upstream = new AtomicReference<>();
        final z.c worker;
        c(y<? super T> yVar, long j, TimeUnit timeUnit, z.c cVar) {
            super();
            this.downstream = yVar;
            this.timeout = j;
            this.unit = timeUnit;
            this.worker = cVar;
            g gVar = new g();
            AtomicReference atomicReference = new AtomicReference();
        }

        @Override // java.util.concurrent.atomic.AtomicLong
        public void a(long j) {
            long l = Long.MAX_VALUE;
            if (compareAndSet(j, l)) {
                c.dispose(this.upstream);
                this.downstream.onError(new TimeoutException(k.d(this.timeout, this.unit)));
                this.worker.dispose();
            }
        }

        @Override // java.util.concurrent.atomic.AtomicLong
        void c(long j) {
            this.task.a(this.worker.c(new z3.e(j, r6, this), this.timeout, this.unit));
        }

        @Override // java.util.concurrent.atomic.AtomicLong
        public void dispose() {
            c.dispose(this.upstream);
            this.worker.dispose();
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
                this.worker.dispose();
            }
        }

        @Override // java.util.concurrent.atomic.AtomicLong
        public void onError(Throwable th) {
            long l = Long.MAX_VALUE;
            final long andSet = getAndSet(l);
            if (andSet != Long.MAX_VALUE) {
                this.task.dispose();
                this.downstream.onError(th);
                this.worker.dispose();
            } else {
                a.t(th);
            }
        }

        @Override // java.util.concurrent.atomic.AtomicLong
        public void onNext(T t) {
            long l = get();
            if (l != 9223372036854775807L) {
                long l4 = 1L + l;
                if (compareAndSet(l, l4)) {
                    (b)this.task.get().dispose();
                    this.downstream.onNext(t);
                    c(l4);
                }
            }
        }

        @Override // java.util.concurrent.atomic.AtomicLong
        public void onSubscribe(b bVar) {
            c.setOnce(this.upstream, bVar);
        }
    }
    public z3(r<T> rVar, long j, TimeUnit timeUnit, z zVar, w<? extends T> wVar) {
        super(rVar);
        this.b = j;
        this.c = timeUnit;
        this.v = zVar;
        this.w = wVar;
    }

    @Override // i.b.m0.e.e.a
    protected void subscribeActual(y<? super T> yVar) {
        final long l2 = 0L;
        if (this.w == null) {
            z3.c cVar = new z3.c(yVar, this.b, timeUnit2, this.c, this.v.a());
            yVar.onSubscribe(cVar);
            cVar.c(l2);
            this.a.subscribe(cVar);
        } else {
            z3.b bVar = new z3.b(yVar, this.b, timeUnit2, this.c, this.v.a(), this.w);
            yVar.onSubscribe(bVar);
            bVar.c(l2);
            this.a.subscribe(bVar);
        }
    }
}
