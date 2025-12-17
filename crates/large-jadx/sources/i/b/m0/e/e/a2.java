package i.b.m0.e.e;

import i.b.g0;
import i.b.j0.b;
import i.b.m0.a.c;
import i.b.m0.c.i;
import i.b.m0.c.j;
import i.b.m0.f.c;
import i.b.m0.j.c;
import i.b.p0.a;
import i.b.r;
import i.b.w;
import i.b.y;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes3.dex */
public final class a2<T>  extends i.b.m0.e.e.a<T, T> {

    final g0<? extends T> b;

    static final class a extends AtomicInteger implements y<T>, b {

        private static final long serialVersionUID = -4592979584110982903L;
        volatile boolean disposed;
        final y<? super T> downstream;
        final c error;
        final AtomicReference<b> mainDisposable;
        volatile boolean mainDone;
        final i.b.m0.e.e.a2.a.a<T> otherObserver;
        volatile int otherState;
        volatile i<T> queue;
        T singleItem;
        a(y<? super T> y) {
            super();
            this.downstream = y;
            AtomicReference obj1 = new AtomicReference();
            this.mainDisposable = obj1;
            obj1 = new a2.a.a(this);
            this.otherObserver = obj1;
            obj1 = new c();
            this.error = obj1;
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        void a() {
            if (getAndIncrement() == 0) {
                b();
            }
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        void b() {
            int andGet;
            int otherState;
            int i2;
            int i;
            boolean mainDone;
            int poll;
            int i3;
            final y downstream = this.downstream;
            int i4 = 1;
            andGet = i4;
            i2 = 0;
            while (this.disposed) {
                i = 2;
                if (this.otherState == i4) {
                }
                i queue = this.queue;
                if (queue != null) {
                } else {
                }
                poll = i2;
                if (poll == 0) {
                } else {
                }
                i3 = 0;
                downstream.onNext(poll);
                i2 = 0;
                i3 = i4;
                poll = queue.poll();
                this.singleItem = i2;
                this.otherState = i;
                downstream.onNext(this.singleItem);
                otherState = i;
            }
            this.singleItem = i2;
            this.queue = i2;
        }

        i<T> c() {
            i cVar;
            int bufferSize;
            if (this.queue == null) {
                cVar = new c(r.bufferSize());
                this.queue = cVar;
            }
            return cVar;
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        void d(Throwable throwable) {
            Object obj2;
            if (this.error.a(throwable)) {
                c.dispose(this.mainDisposable);
                a();
            } else {
                a.t(throwable);
            }
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        public void dispose() {
            int andIncrement;
            this.disposed = true;
            c.dispose(this.mainDisposable);
            c.dispose(this.otherObserver);
            if (getAndIncrement() == 0) {
                andIncrement = 0;
                this.queue = andIncrement;
                this.singleItem = andIncrement;
            }
        }

        void e(T t) {
            y compareAndSet;
            int obj3;
            final int i2 = 1;
            if (compareAndSet(0, i2)) {
                this.downstream.onNext(t);
                this.otherState = 2;
            } else {
                this.singleItem = t;
                this.otherState = i2;
                if (getAndIncrement() != 0) {
                }
            }
            b();
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        public boolean isDisposed() {
            return c.isDisposed((b)this.mainDisposable.get());
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        public void onComplete() {
            this.mainDone = true;
            a();
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        public void onError(Throwable throwable) {
            Object obj2;
            if (this.error.a(throwable)) {
                c.dispose(this.otherObserver);
                a();
            } else {
                a.t(throwable);
            }
        }

        public void onNext(T t) {
            Object downstream;
            int obj3;
            if (compareAndSet(0, 1)) {
                this.downstream.onNext(t);
                if (decrementAndGet() == 0) {
                }
            } else {
                c().offer(t);
                if (getAndIncrement() != 0) {
                }
            }
            b();
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        public void onSubscribe(b b) {
            c.setOnce(this.mainDisposable, b);
        }
    }
    public a2(r<T> r, g0<? extends T> g02) {
        super(r);
        this.b = g02;
    }

    protected void subscribeActual(y<? super T> y) {
        a2.a aVar = new a2.a(y);
        y.onSubscribe(aVar);
        this.a.subscribe(aVar);
        this.b.subscribe(aVar.otherObserver);
    }
}
