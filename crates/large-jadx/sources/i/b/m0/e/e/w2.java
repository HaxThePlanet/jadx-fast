package i.b.m0.e.e;

import i.b.j0.b;
import i.b.m0.a.c;
import i.b.o0.e;
import i.b.w;
import i.b.y;
import i.b.z;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: ObservableSampleTimed.java */
/* loaded from: classes3.dex */
public final class w2<T> extends a<T, T> {

    final long b;
    final TimeUnit c;
    final z v;
    final boolean w;

    static abstract class c<T> extends AtomicReference<T> implements y<T>, b, Runnable {

        private static final long serialVersionUID = -3517602651313910099L;
        final y<? super T> downstream;
        final long period;
        final z scheduler;
        final AtomicReference<b> timer = new AtomicReference<>();
        final TimeUnit unit;
        b upstream;
        c(y<? super T> yVar, long j, TimeUnit timeUnit, z zVar) {
            super();
            final AtomicReference atomicReference = new AtomicReference();
            this.downstream = yVar;
            this.period = j;
            this.unit = timeUnit;
            this.scheduler = zVar;
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        void a() {
            c.dispose(this.timer);
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        void c() {
            Object andSet = getAndSet(null);
            if (andSet != null) {
                this.downstream.onNext(andSet);
            }
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public void dispose() {
            a();
            this.upstream.dispose();
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public boolean isDisposed() {
            return this.upstream.isDisposed();
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public void onComplete() {
            a();
            b();
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public void onError(Throwable th) {
            a();
            this.downstream.onError(th);
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public void onNext(T t) {
            lazySet(t);
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public void onSubscribe(b bVar) {
            if (c.validate(this.upstream, bVar)) {
                this.upstream = bVar;
                this.downstream.onSubscribe(this);
                c.replace(this.timer, this.scheduler.e(this, period2, this.period, this.unit));
            }
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        abstract void b();
    }

    static final class a<T> extends w2.c<T> {

        private static final long serialVersionUID = -7139995637533111443L;
        final AtomicInteger wip = new AtomicInteger(1);
        a(y<? super T> yVar, long j, TimeUnit timeUnit, z zVar) {
            super(yVar, j, r3, timeUnit, zVar);
            final AtomicInteger atomicInteger = new AtomicInteger(1);
        }

        @Override // i.b.m0.e.e.w2$c
        void b() {
            c();
            if (this.wip.decrementAndGet() == 0) {
                this.downstream.onComplete();
            }
        }

        @Override // i.b.m0.e.e.w2$c
        public void run() {
            if (this.wip.incrementAndGet() == 2) {
                c();
                if (this.wip.decrementAndGet() == 0) {
                    this.downstream.onComplete();
                }
            }
        }
    }

    static final class b<T> extends w2.c<T> {

        private static final long serialVersionUID = -7139995637533111443L;
        b(y<? super T> yVar, long j, TimeUnit timeUnit, z zVar) {
            super(yVar, j, r3, timeUnit, zVar);
        }

        @Override // i.b.m0.e.e.w2$c
        void b() {
            this.downstream.onComplete();
        }

        @Override // i.b.m0.e.e.w2$c
        public void run() {
            c();
        }
    }
    public w2(w<T> wVar, long j, TimeUnit timeUnit, z zVar, boolean z) {
        super(wVar);
        this.b = j;
        this.c = timeUnit;
        this.v = zVar;
        this.w = z;
    }

    @Override // i.b.m0.e.e.a
    public void subscribeActual(y<? super T> yVar) {
        final e eVar = new e(yVar);
        if (this.w) {
            w2.a aVar = new w2.a(eVar, this.b, timeUnit2, this.c, this.v);
            this.a.subscribe(aVar);
        } else {
            w2.b bVar = new w2.b(eVar, this.b, timeUnit2, this.c, this.v);
            this.a.subscribe(bVar);
        }
    }
}
