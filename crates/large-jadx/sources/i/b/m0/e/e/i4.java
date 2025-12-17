package i.b.m0.e.e;

import i.b.j0.b;
import i.b.m0.a.c;
import i.b.m0.b.b;
import i.b.m0.f.a;
import i.b.m0.j.c;
import i.b.o0.c;
import i.b.p0.a;
import i.b.r;
import i.b.t0.e;
import i.b.w;
import i.b.y;
import io.reactivex.exceptions.a;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes3.dex */
public final class i4<T, B>  extends i.b.m0.e.e.a<T, r<T>> {

    final Callable<? extends w<B>> b;
    final int c;

    static final class b extends AtomicInteger implements y<T>, b, Runnable {

        static final i.b.m0.e.e.i4.a<Object, Object> a = null;
        static final Object b = null;
        private static final long serialVersionUID = 2233020065421370272L;
        final AtomicReference<i.b.m0.e.e.i4.a<T, B>> boundaryObserver;
        final int capacityHint;
        volatile boolean done;
        final y<? super r<T>> downstream;
        final c errors;
        final Callable<? extends w<B>> other;
        final a<Object> queue;
        final AtomicBoolean stopWindows;
        b upstream;
        e<T> window;
        final AtomicInteger windows;
        static {
            i4.a aVar = new i4.a(0);
            i4.b.a = aVar;
            Object object = new Object();
            i4.b.b = object;
        }

        b(y<? super r<T>> y, int i2, Callable<? extends w<B>> callable3) {
            super();
            this.downstream = y;
            this.capacityHint = i2;
            AtomicReference obj1 = new AtomicReference();
            this.boundaryObserver = obj1;
            obj1 = new AtomicInteger(1);
            this.windows = obj1;
            obj1 = new a();
            this.queue = obj1;
            obj1 = new c();
            this.errors = obj1;
            obj1 = new AtomicBoolean();
            this.stopWindows = obj1;
            this.other = callable3;
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        void a() {
            final i.b.m0.e.e.i4.a aVar = i4.b.a;
            Object andSet = this.boundaryObserver.getAndSet(aVar);
            if ((b)andSet != null && (b)andSet != aVar) {
                if ((b)andSet != aVar) {
                    (b)andSet.dispose();
                }
            }
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        void b() {
            int andGet;
            Throwable window;
            int compareAndSet;
            boolean done;
            Object aVar;
            int boundaryObserver;
            if (getAndIncrement() != 0) {
            }
            y downstream = this.downstream;
            a queue = this.queue;
            final c errors = this.errors;
            final int i = 1;
            andGet = i;
            compareAndSet = 0;
            while (this.windows.get() == 0) {
                window = this.window;
                done = this.done;
                aVar = queue.poll();
                if (aVar == null) {
                } else {
                }
                boundaryObserver = 0;
                if (aVar != i4.b.b) {
                } else {
                }
                if (window != null) {
                }
                window = e.f(this.capacityHint, this);
                this.window = window;
                this.windows.getAndIncrement();
                done = this.other.call();
                b.e(done, "The other Callable returned a null ObservableSource");
                aVar = new i4.a(this);
                if (!this.stopWindows.get() && this.boundaryObserver.compareAndSet(compareAndSet, aVar)) {
                }
                compareAndSet = 0;
                window = e.f(this.capacityHint, this);
                this.window = window;
                this.windows.getAndIncrement();
                done = this.other.call();
                b.e((w)done, "The other Callable returned a null ObservableSource");
                aVar = new i4.a(this);
                if (this.boundaryObserver.compareAndSet(compareAndSet, aVar)) {
                }
                (w)done.subscribe(aVar);
                downstream.onNext(window);
                this.window = compareAndSet;
                window.onComplete();
                window.onNext(aVar);
                boundaryObserver = i;
            }
            queue.clear();
            this.window = compareAndSet;
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        void c() {
            this.upstream.dispose();
            this.done = true;
            b();
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        void d(Throwable throwable) {
            int obj2;
            this.upstream.dispose();
            if (this.errors.a(throwable)) {
                this.done = true;
                b();
            } else {
                a.t(throwable);
            }
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        public void dispose() {
            boolean decrementAndGet;
            a();
            if (this.stopWindows.compareAndSet(false, true) && this.windows.decrementAndGet() == 0) {
                a();
                if (this.windows.decrementAndGet() == 0) {
                    this.upstream.dispose();
                }
            }
        }

        void e(i.b.m0.e.e.i4.a<T, B> i4$a) {
            this.boundaryObserver.compareAndSet(a, 0);
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
        public void onError(Throwable throwable) {
            int obj2;
            a();
            if (this.errors.a(throwable)) {
                this.done = true;
                b();
            } else {
                a.t(throwable);
            }
        }

        public void onNext(T t) {
            this.queue.offer(t);
            b();
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        public void onSubscribe(b b) {
            boolean validate;
            Object obj2;
            if (c.validate(this.upstream, b)) {
                this.upstream = b;
                this.downstream.onSubscribe(this);
                this.queue.offer(i4.b.b);
                b();
            }
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        public void run() {
            int decrementAndGet;
            if (this.windows.decrementAndGet() == 0) {
                this.upstream.dispose();
            }
        }
    }

    static final class a extends c<B> {

        final i.b.m0.e.e.i4.b<T, B> b;
        boolean c;
        a(i.b.m0.e.e.i4.b<T, B> i4$b) {
            super();
            this.b = b;
        }

        @Override // i.b.o0.c
        public void onComplete() {
            if (this.c) {
            }
            this.c = true;
            this.b.c();
        }

        @Override // i.b.o0.c
        public void onError(Throwable throwable) {
            if (this.c) {
                a.t(throwable);
            }
            this.c = true;
            this.b.d(throwable);
        }

        public void onNext(B b) {
            if (this.c) {
            }
            this.c = true;
            dispose();
            this.b.e(this);
        }
    }
    public i4(w<T> w, Callable<? extends w<B>> callable2, int i3) {
        super(w);
        this.b = callable2;
        this.c = i3;
    }

    public void subscribeActual(y<? super r<T>> y) {
        i4.b bVar = new i4.b(y, this.c, this.b);
        this.a.subscribe(bVar);
    }
}
