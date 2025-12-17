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

/* loaded from: classes3.dex */
public final class w2<T>  extends i.b.m0.e.e.a<T, T> {

    final long b;
    final TimeUnit c;
    final z v;
    final boolean w;

    static abstract class c extends AtomicReference<T> implements y<T>, b, Runnable {

        private static final long serialVersionUID = -3517602651313910099L;
        final y<? super T> downstream;
        final long period;
        final z scheduler;
        final AtomicReference<b> timer;
        final TimeUnit unit;
        b upstream;
        c(y<? super T> y, long l2, TimeUnit timeUnit3, z z4) {
            super();
            AtomicReference atomicReference = new AtomicReference();
            this.timer = atomicReference;
            this.downstream = y;
            this.period = l2;
            this.unit = z4;
            this.scheduler = obj6;
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        void a() {
            c.dispose(this.timer);
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        abstract void b();

        @Override // java.util.concurrent.atomic.AtomicReference
        void c() {
            y downstream;
            Object andSet = getAndSet(0);
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
        public void onError(Throwable throwable) {
            a();
            this.downstream.onError(throwable);
        }

        public void onNext(T t) {
            lazySet(t);
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public void onSubscribe(b b) {
            boolean validate;
            Object obj;
            long l;
            long period;
            TimeUnit unit;
            b obj8;
            if (c.validate(this.upstream, b)) {
                this.upstream = b;
                this.downstream.onSubscribe(this);
                period = this.period;
                c.replace(this.timer, this.scheduler.e(this, period, obj3, period));
            }
        }
    }

    static final class a extends i.b.m0.e.e.w2.c<T> {

        private static final long serialVersionUID = -7139995637533111443L;
        final AtomicInteger wip;
        a(y<? super T> y, long l2, TimeUnit timeUnit3, z z4) {
            super(y, l2, timeUnit3, z4, obj5);
            AtomicInteger obj1 = new AtomicInteger(1);
            this.wip = obj1;
        }

        @Override // i.b.m0.e.e.w2$c
        void b() {
            int decrementAndGet;
            c();
            if (this.wip.decrementAndGet() == 0) {
                this.downstream.onComplete();
            }
        }

        @Override // i.b.m0.e.e.w2$c
        public void run() {
            int incrementAndGet;
            c();
            if (this.wip.incrementAndGet() == 2 && this.wip.decrementAndGet() == 0) {
                c();
                if (this.wip.decrementAndGet() == 0) {
                    this.downstream.onComplete();
                }
            }
        }
    }

    static final class b extends i.b.m0.e.e.w2.c<T> {

        private static final long serialVersionUID = -7139995637533111443L;
        b(y<? super T> y, long l2, TimeUnit timeUnit3, z z4) {
            super(y, l2, timeUnit3, z4, obj5);
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
    public w2(w<T> w, long l2, TimeUnit timeUnit3, z z4, boolean z5) {
        super(w);
        this.b = l2;
        this.c = z4;
        this.v = z5;
        this.w = obj6;
    }

    public void subscribeActual(y<? super T> y) {
        i.b.m0.e.e.w2.c cVar;
        long l;
        TimeUnit time;
        z zVar;
        i.b.m0.e.e.w2.c aVar;
        w obj8;
        e eVar = new e(y);
        if (this.w) {
            super(eVar, this.b, obj3, this.c, this.v);
            this.a.subscribe(aVar);
        } else {
            super(eVar, this.b, obj3, this.c, this.v);
            this.a.subscribe(aVar);
        }
    }
}
