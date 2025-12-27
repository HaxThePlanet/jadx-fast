package i.b.m0.e.e;

import i.b.j0.b;
import i.b.m0.c.i;
import i.b.m0.c.j;
import i.b.p;
import i.b.p0.a;
import i.b.r;
import i.b.w;
import i.b.y;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: ObservableMergeWithMaybe.java */
/* loaded from: classes3.dex */
public final class z1<T> extends a<T, T> {

    final p<? extends T> b;

    static final class a<T> extends AtomicInteger implements y<T>, b {

        private static final long serialVersionUID = -4592979584110982903L;
        volatile boolean disposed;
        final y<? super T> downstream;
        final i.b.m0.j.c error = new c();
        final AtomicReference<b> mainDisposable = new AtomicReference<>();
        volatile boolean mainDone;
        final z1.a.a<T> otherObserver = new z1$a$a<>();
        volatile int otherState;
        volatile i<T> queue;
        T singleItem;
        a(y<? super T> yVar) {
            super();
            this.downstream = yVar;
            AtomicReference atomicReference = new AtomicReference();
            i.b.m0.e.e.z1.a.a aVar = new z1.a.a(this);
            i.b.m0.j.c cVar = new c();
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
            int otherState2;
            Object poll;
            andGet = 1;
            poll = null;
            while (this.disposed) {
                otherState2 = 2;
                int r8 = this.queue == null ? andGet : 0;
                if (andGet != 0) {
                }
            }
            this.singleItem = poll;
            this.queue = poll;
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        i<T> c() {
            i queue2;
            if (this.queue == null) {
                this.queue = new c(r.bufferSize());
            }
            return queue2;
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        void d() {
            this.otherState = 2;
            a();
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        public void dispose() {
            this.disposed = true;
            c.dispose(this.mainDisposable);
            c.dispose(this.otherObserver);
            if (getAndIncrement() == 0) {
                i iVar = null;
                this.queue = iVar;
                this.singleItem = iVar;
            }
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        void e(Throwable th) {
            if (this.error.a(th)) {
                c.dispose(this.mainDisposable);
                a();
            } else {
                a.t(th);
            }
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        void f(T t) {
            final int i2 = 1;
            if (!compareAndSet(0, i2)) {
                this.singleItem = t;
                this.otherState = i2;
                if (getAndIncrement() != 0) {
                    return;
                }
            } else {
                this.downstream.onNext(t);
                int andIncrement = 2;
                this.otherState = andIncrement;
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
        public void onError(Throwable th) {
            if (this.error.a(th)) {
                c.dispose(this.otherObserver);
                a();
            } else {
                a.t(th);
            }
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        public void onNext(T t) {
            if (compareAndSet(0, 1)) {
                this.downstream.onNext(t);
                if (decrementAndGet() == 0) {
                    return;
                }
            } else {
                c().offer(t);
                if (getAndIncrement() != 0) {
                    return;
                }
            }
            b();
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        public void onSubscribe(b bVar) {
            c.setOnce(this.mainDisposable, bVar);
        }
    }
    public z1(r<T> rVar, p<? extends T> pVar) {
        super(rVar);
        this.b = pVar;
    }

    @Override // i.b.m0.e.e.a
    protected void subscribeActual(y<? super T> yVar) {
        i.b.m0.e.e.z1.a aVar = new z1.a(yVar);
        yVar.onSubscribe(aVar);
        this.a.subscribe(aVar);
        this.b.b(aVar.otherObserver);
    }
}
