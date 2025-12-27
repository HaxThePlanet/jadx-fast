package i.b.m0.e.e;

import i.b.r;
import i.b.t0.e;
import i.b.w;
import i.b.y;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: ObservableWindowBoundarySupplier.java */
/* loaded from: classes3.dex */
public final class i4<T, B> extends a<T, r<T>> {

    final Callable<? extends w<B>> b;
    final int c;

    static final class b<T, B> extends AtomicInteger implements y<T>, i.b.j0.b, Runnable {

        static final i4.a<Object, Object> a = null;
        static final Object b = null;
        private static final long serialVersionUID = 2233020065421370272L;
        final AtomicReference<i4.a<T, B>> boundaryObserver = new AtomicReference<>();
        final int capacityHint;
        volatile boolean done;
        final y<? super r<T>> downstream;
        final i.b.m0.j.c errors = new c();
        final Callable<? extends w<B>> other;
        final i.b.m0.f.a<Object> queue = new a<>();
        final AtomicBoolean stopWindows = new AtomicBoolean();
        i.b.j0.b upstream;
        e<T> window;
        final AtomicInteger windows = new AtomicInteger(1);
        static {
            i4.b.a = new i4.a(null);
            i4.b.b = new Object();
        }

        b(y<? super r<T>> yVar, int i, Callable<? extends w<B>> callable) {
            super();
            this.downstream = yVar;
            this.capacityHint = i;
            AtomicReference atomicReference = new AtomicReference();
            AtomicInteger atomicInteger = new AtomicInteger(1);
            i.b.m0.f.a aVar = new a();
            i.b.m0.j.c cVar = new c();
            AtomicBoolean atomicBoolean = new AtomicBoolean();
            this.other = callable;
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        void a() {
            final i.b.m0.e.e.i4.a aVar = i4.b.a;
            Object andSet = this.boundaryObserver.getAndSet(aVar);
            if (andSet != null && andSet != i4.b.a) {
                andSet.dispose();
            }
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        void b() {
            int andGet;
            Object poll;
            AtomicReference boundaryObserver2 = null;
            if (getAndIncrement() != 0) {
                return;
            }
            andGet = 1;
            Object obj = null;
            while (this.windows.get() == 0) {
                poll = this.queue.poll();
                int r9 = poll == null ? andGet : 0;
                if (boundaryObserver2 != null) {
                }
            }
            this.queue.clear();
            this.window = obj;
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        void c() {
            this.upstream.dispose();
            this.done = true;
            b();
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        void d(Throwable th) {
            this.upstream.dispose();
            if (this.errors.a(th)) {
                boolean z = true;
                this.done = z;
                b();
            } else {
                a.t(th);
            }
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        public void dispose() {
            if (this.stopWindows.compareAndSet(false, true)) {
                a();
                if (this.windows.decrementAndGet() == 0) {
                    this.upstream.dispose();
                }
            }
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        void e(i4.a<T, B> aVar) {
            this.boundaryObserver.compareAndSet(aVar, null);
            this.queue.offer(i4.b.b);
            b();
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        public boolean isDisposed() {
            return this.stopWindows.get();
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        public void onComplete() {
            a();
            this.done = true;
            b();
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        public void onError(Throwable th) {
            a();
            if (this.errors.a(th)) {
                boolean z = true;
                this.done = z;
                b();
            } else {
                a.t(th);
            }
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        public void onNext(T t) {
            this.queue.offer(t);
            b();
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        public void onSubscribe(i.b.j0.b bVar) {
            if (c.validate(this.upstream, bVar)) {
                this.upstream = bVar;
                this.downstream.onSubscribe(this);
                this.queue.offer(i4.b.b);
                b();
            }
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        public void run() {
            if (this.windows.decrementAndGet() == 0) {
                this.upstream.dispose();
            }
        }
    }

    static final class a<T, B> extends i.b.o0.c<B> {

        final i4.b<T, B> b;
        boolean c;
        a(i4.b<T, B> bVar) {
            super();
            this.b = bVar;
        }

        @Override // i.b.o0.c
        public void onComplete() {
            if (this.c) {
                return;
            }
            this.c = true;
            this.b.c();
        }

        @Override // i.b.o0.c
        public void onError(Throwable th) {
            if (this.c) {
                a.t(th);
                return;
            }
            this.c = true;
            this.b.d(th);
        }

        @Override // i.b.o0.c
        public void onNext(B b) {
            if (this.c) {
                return;
            }
            this.c = true;
            dispose();
            this.b.e(this);
        }
    }
    public i4(w<T> wVar, Callable<? extends w<B>> callable, int i) {
        super(wVar);
        this.b = callable;
        this.c = i;
    }

    @Override // i.b.m0.e.e.a
    public void subscribeActual(y<? super r<T>> yVar) {
        this.a.subscribe(new i4.b(yVar, this.c, this.b));
    }
}
