package i.b.m0.e.e;

import i.b.j0.b;
import i.b.m0.a.c;
import i.b.m0.f.a;
import i.b.m0.j.c;
import i.b.o0.c;
import i.b.p0.a;
import i.b.r;
import i.b.t0.e;
import i.b.w;
import i.b.y;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes3.dex */
public final class g4<T, B>  extends i.b.m0.e.e.a<T, r<T>> {

    final w<B> b;
    final int c;

    static final class b extends AtomicInteger implements y<T>, b, Runnable {

        static final Object a = null;
        private static final long serialVersionUID = 2233020065421370272L;
        final i.b.m0.e.e.g4.a<T, B> boundaryObserver;
        final int capacityHint;
        volatile boolean done;
        final y<? super r<T>> downstream;
        final c errors;
        final a<Object> queue;
        final AtomicBoolean stopWindows;
        final AtomicReference<b> upstream;
        e<T> window;
        final AtomicInteger windows;
        static {
            Object object = new Object();
            g4.b.a = object;
        }

        b(y<? super r<T>> y, int i2) {
            super();
            this.downstream = y;
            this.capacityHint = i2;
            g4.a obj1 = new g4.a(this);
            this.boundaryObserver = obj1;
            obj1 = new AtomicReference();
            this.upstream = obj1;
            obj1 = new AtomicInteger(1);
            this.windows = obj1;
            obj1 = new a();
            this.queue = obj1;
            obj1 = new c();
            this.errors = obj1;
            obj1 = new AtomicBoolean();
            this.stopWindows = obj1;
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        void a() {
            int andGet;
            e window;
            int windows;
            boolean done;
            Object poll;
            int i;
            if (getAndIncrement() != 0) {
            }
            y downstream = this.downstream;
            a queue = this.queue;
            final c errors = this.errors;
            final int i2 = 1;
            andGet = i2;
            windows = 0;
            while (this.windows.get() == 0) {
                window = this.window;
                done = this.done;
                poll = queue.poll();
                if (poll == null) {
                } else {
                }
                i = 0;
                if (poll != g4.b.a) {
                } else {
                }
                if (window != null) {
                }
                if (!this.stopWindows.get()) {
                }
                windows = 0;
                window = e.f(this.capacityHint, this);
                this.window = window;
                this.windows.getAndIncrement();
                downstream.onNext(window);
                this.window = windows;
                window.onComplete();
                window.onNext(poll);
                i = i2;
            }
            queue.clear();
            this.window = windows;
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        void b() {
            c.dispose(this.upstream);
            this.done = true;
            a();
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        void c(Throwable throwable) {
            int obj2;
            c.dispose(this.upstream);
            if (this.errors.a(throwable)) {
                this.done = true;
                a();
            } else {
                a.t(throwable);
            }
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        void d() {
            this.queue.offer(g4.b.a);
            a();
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        public void dispose() {
            boolean decrementAndGet;
            this.boundaryObserver.dispose();
            if (this.stopWindows.compareAndSet(false, true) && this.windows.decrementAndGet() == 0) {
                this.boundaryObserver.dispose();
                if (this.windows.decrementAndGet() == 0) {
                    c.dispose(this.upstream);
                }
            }
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        public boolean isDisposed() {
            return this.stopWindows.get();
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        public void onComplete() {
            this.boundaryObserver.dispose();
            this.done = true;
            a();
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        public void onError(Throwable throwable) {
            int obj2;
            this.boundaryObserver.dispose();
            if (this.errors.a(throwable)) {
                this.done = true;
                a();
            } else {
                a.t(throwable);
            }
        }

        public void onNext(T t) {
            this.queue.offer(t);
            a();
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        public void onSubscribe(b b) {
            if (c.setOnce(this.upstream, b)) {
                d();
            }
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        public void run() {
            int decrementAndGet;
            if (this.windows.decrementAndGet() == 0) {
                c.dispose(this.upstream);
            }
        }
    }

    static final class a extends c<B> {

        final i.b.m0.e.e.g4.b<T, B> b;
        boolean c;
        a(i.b.m0.e.e.g4.b<T, B> g4$b) {
            super();
            this.b = b;
        }

        @Override // i.b.o0.c
        public void onComplete() {
            if (this.c) {
            }
            this.c = true;
            this.b.b();
        }

        @Override // i.b.o0.c
        public void onError(Throwable throwable) {
            if (this.c) {
                a.t(throwable);
            }
            this.c = true;
            this.b.c(throwable);
        }

        public void onNext(B b) {
            if (this.c) {
            }
            this.b.d();
        }
    }
    public g4(w<T> w, w<B> w2, int i3) {
        super(w);
        this.b = w2;
        this.c = i3;
    }

    public void subscribeActual(y<? super r<T>> y) {
        g4.b bVar = new g4.b(y, this.c);
        y.onSubscribe(bVar);
        this.b.subscribe(bVar.boundaryObserver);
        this.a.subscribe(bVar);
    }
}
