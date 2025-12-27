package i.b.m0.e.e;

import i.b.j0.b;
import i.b.r;
import i.b.t0.e;
import i.b.w;
import i.b.y;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: ObservableWindowBoundary.java */
/* loaded from: classes3.dex */
public final class g4<T, B> extends a<T, r<T>> {

    final w<B> b;
    final int c;

    static final class b<T, B> extends AtomicInteger implements y<T>, b, Runnable {

        static final Object a = null;
        private static final long serialVersionUID = 2233020065421370272L;
        final g4.a<T, B> boundaryObserver = new g4$a<>();
        final int capacityHint;
        volatile boolean done;
        final y<? super r<T>> downstream;
        final i.b.m0.j.c errors = new c();
        final i.b.m0.f.a<Object> queue = new a<>();
        final AtomicBoolean stopWindows = new AtomicBoolean();
        final AtomicReference<b> upstream = new AtomicReference<>();
        e<T> window;
        final AtomicInteger windows = new AtomicInteger(1);
        static {
            g4.b.a = new Object();
        }

        b(y<? super r<T>> yVar, int i) {
            super();
            this.downstream = yVar;
            this.capacityHint = i;
            i.b.m0.e.e.g4.a aVar = new g4.a(this);
            AtomicReference atomicReference = new AtomicReference();
            AtomicInteger atomicInteger = new AtomicInteger(1);
            i.b.m0.f.a aVar2 = new a();
            i.b.m0.j.c cVar = new c();
            AtomicBoolean atomicBoolean = new AtomicBoolean();
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        void a() {
            int andGet;
            Object poll;
            if (getAndIncrement() != 0) {
                return;
            }
            andGet = 1;
            AtomicInteger windows2 = null;
            while (this.windows.get() == 0) {
                poll = this.queue.poll();
                int r9 = poll == null ? andGet : 0;
                if (andGet != 0) {
                }
            }
            this.queue.clear();
            this.window = windows2;
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        void b() {
            c.dispose(this.upstream);
            this.done = true;
            a();
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        void c(Throwable th) {
            c.dispose(this.upstream);
            if (this.errors.a(th)) {
                boolean z = true;
                this.done = z;
                a();
            } else {
                a.t(th);
            }
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        void d() {
            this.queue.offer(g4.b.a);
            a();
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        public void dispose() {
            if (this.stopWindows.compareAndSet(false, true)) {
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
        public void onError(Throwable th) {
            this.boundaryObserver.dispose();
            if (this.errors.a(th)) {
                boolean z = true;
                this.done = z;
                a();
            } else {
                a.t(th);
            }
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        public void onNext(T t) {
            this.queue.offer(t);
            a();
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        public void onSubscribe(b bVar) {
            if (c.setOnce(this.upstream, bVar)) {
                d();
            }
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        public void run() {
            if (this.windows.decrementAndGet() == 0) {
                c.dispose(this.upstream);
            }
        }
    }

    static final class a<T, B> extends i.b.o0.c<B> {

        final g4.b<T, B> b;
        boolean c;
        a(g4.b<T, B> bVar) {
            super();
            this.b = bVar;
        }

        @Override // i.b.o0.c
        public void onComplete() {
            if (this.c) {
                return;
            }
            this.c = true;
            this.b.b();
        }

        @Override // i.b.o0.c
        public void onError(Throwable th) {
            if (this.c) {
                a.t(th);
                return;
            }
            this.c = true;
            this.b.c(th);
        }

        @Override // i.b.o0.c
        public void onNext(B b) {
            if (this.c) {
                return;
            }
            this.b.d();
        }
    }
    public g4(w<T> wVar, w<B> wVar2, int i) {
        super(wVar);
        this.b = wVar2;
        this.c = i;
    }

    @Override // i.b.m0.e.e.a
    public void subscribeActual(y<? super r<T>> yVar) {
        final i.b.m0.e.e.g4.b bVar = new g4.b(yVar, this.c);
        yVar.onSubscribe(bVar);
        this.b.subscribe(bVar.boundaryObserver);
        this.a.subscribe(bVar);
    }
}
