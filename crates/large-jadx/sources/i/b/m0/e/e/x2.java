package i.b.m0.e.e;

import i.b.j0.b;
import i.b.m0.a.c;
import i.b.o0.e;
import i.b.w;
import i.b.y;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: ObservableSampleWithObservable.java */
/* loaded from: classes3.dex */
public final class x2<T> extends a<T, T> {

    final w<?> b;
    final boolean c;

    static abstract class c<T> extends AtomicReference<T> implements y<T>, b {

        private static final long serialVersionUID = -3517602651313910099L;
        final y<? super T> downstream;
        final AtomicReference<b> other = new AtomicReference<>();
        final w<?> sampler;
        b upstream;
        c(y<? super T> yVar, w<?> wVar) {
            super();
            final AtomicReference atomicReference = new AtomicReference();
            this.downstream = yVar;
            this.sampler = wVar;
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public void a() {
            this.upstream.dispose();
            b();
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        void c() {
            Object andSet = getAndSet(null);
            if (andSet != null) {
                this.downstream.onNext(andSet);
            }
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public void d(Throwable th) {
            this.upstream.dispose();
            this.downstream.onError(th);
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public void dispose() {
            c.dispose(this.other);
            this.upstream.dispose();
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        boolean f(b bVar) {
            return c.setOnce(this.other, bVar);
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public boolean isDisposed() {
            boolean z = true;
            int r0 = this.other.get() == c.DISPOSED ? 1 : 0;
            return (this.other.get() == c.DISPOSED ? 1 : 0);
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public void onComplete() {
            c.dispose(this.other);
            b();
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public void onError(Throwable th) {
            c.dispose(this.other);
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
                if (this.other.get() == null) {
                    this.sampler.subscribe(new x2.d(this));
                }
            }
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        abstract void b();

        @Override // java.util.concurrent.atomic.AtomicReference
        abstract void e();
    }

    static final class d<T> implements y<Object> {

        final x2.c<T> a;
        d(x2.c<T> cVar) {
            super();
            this.a = cVar;
        }

        public void onComplete() {
            this.a.a();
        }

        public void onError(Throwable th) {
            this.a.d(th);
        }

        public void onNext(Object object) {
            this.a.e();
        }

        public void onSubscribe(b bVar) {
            this.a.f(bVar);
        }
    }

    static final class a<T> extends x2.c<T> {

        private static final long serialVersionUID = -3029755663834015785L;
        volatile boolean done;
        final AtomicInteger wip = new AtomicInteger();
        a(y<? super T> yVar, w<?> wVar) {
            super(yVar, wVar);
            final AtomicInteger atomicInteger = new AtomicInteger();
        }

        @Override // i.b.m0.e.e.x2$c
        void b() {
            this.done = true;
            if (this.wip.getAndIncrement() == 0) {
                c();
                this.downstream.onComplete();
            }
        }

        @Override // i.b.m0.e.e.x2$c
        void e() {
            if (this.wip.getAndIncrement() == 0) {
                c();
                while (this.done) {
                    if (this.wip.decrementAndGet() == 0) {
                        return;
                    }
                    c();
                }
                this.downstream.onComplete();
                return;
            }
        }
    }

    static final class b<T> extends x2.c<T> {

        private static final long serialVersionUID = -3029755663834015785L;
        b(y<? super T> yVar, w<?> wVar) {
            super(yVar, wVar);
        }

        @Override // i.b.m0.e.e.x2$c
        void b() {
            this.downstream.onComplete();
        }

        @Override // i.b.m0.e.e.x2$c
        void e() {
            c();
        }
    }
    public x2(w<T> wVar, w<?> wVar2, boolean z) {
        super(wVar);
        this.b = wVar2;
        this.c = z;
    }

    @Override // i.b.m0.e.e.a
    public void subscribeActual(y<? super T> yVar) {
        final e eVar = new e(yVar);
        if (this.c) {
            this.a.subscribe(new x2.a(eVar, this.b));
        } else {
            this.a.subscribe(new x2.b(eVar, this.b));
        }
    }
}
