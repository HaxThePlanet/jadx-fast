package i.b.m0.e.e;

import i.b.j0.b;
import i.b.m0.a.c;
import i.b.o0.e;
import i.b.w;
import i.b.y;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes3.dex */
public final class x2<T>  extends i.b.m0.e.e.a<T, T> {

    final w<?> b;
    final boolean c;

    static abstract class c extends AtomicReference<T> implements y<T>, b {

        private static final long serialVersionUID = -3517602651313910099L;
        final y<? super T> downstream;
        final AtomicReference<b> other;
        final w<?> sampler;
        b upstream;
        c(y<? super T> y, w<?> w2) {
            super();
            AtomicReference atomicReference = new AtomicReference();
            this.other = atomicReference;
            this.downstream = y;
            this.sampler = w2;
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public void a() {
            this.upstream.dispose();
            b();
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
        public void d(Throwable throwable) {
            this.upstream.dispose();
            this.downstream.onError(throwable);
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public void dispose() {
            c.dispose(this.other);
            this.upstream.dispose();
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        abstract void e();

        @Override // java.util.concurrent.atomic.AtomicReference
        boolean f(b b) {
            return c.setOnce(this.other, b);
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public boolean isDisposed() {
            int i;
            i = this.other.get() == c.DISPOSED ? 1 : 0;
            return i;
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public void onComplete() {
            c.dispose(this.other);
            b();
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public void onError(Throwable throwable) {
            c.dispose(this.other);
            this.downstream.onError(throwable);
        }

        public void onNext(T t) {
            lazySet(t);
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public void onSubscribe(b b) {
            boolean dVar;
            Object obj2;
            this.upstream = b;
            this.downstream.onSubscribe(this);
            if (c.validate(this.upstream, b) && this.other.get() == null) {
                this.upstream = b;
                this.downstream.onSubscribe(this);
                if (this.other.get() == null) {
                    dVar = new x2.d(this);
                    this.sampler.subscribe(dVar);
                }
            }
        }
    }

    static final class d implements y<Object> {

        final i.b.m0.e.e.x2.c<T> a;
        d(i.b.m0.e.e.x2.c<T> x2$c) {
            super();
            this.a = c;
        }

        @Override // i.b.y
        public void onComplete() {
            this.a.a();
        }

        @Override // i.b.y
        public void onError(Throwable throwable) {
            this.a.d(throwable);
        }

        @Override // i.b.y
        public void onNext(Object object) {
            this.a.e();
        }

        @Override // i.b.y
        public void onSubscribe(b b) {
            this.a.f(b);
        }
    }

    static final class a extends i.b.m0.e.e.x2.c<T> {

        private static final long serialVersionUID = -3029755663834015785L;
        volatile boolean done;
        final AtomicInteger wip;
        a(y<? super T> y, w<?> w2) {
            super(y, w2);
            AtomicInteger obj1 = new AtomicInteger();
            this.wip = obj1;
        }

        @Override // i.b.m0.e.e.x2$c
        void b() {
            int andIncrement;
            this.done = true;
            if (this.wip.getAndIncrement() == 0) {
                c();
                this.downstream.onComplete();
            }
        }

        @Override // i.b.m0.e.e.x2$c
        void e() {
            int decrementAndGet;
            if (this.wip.getAndIncrement() == 0) {
            }
        }
    }

    static final class b extends i.b.m0.e.e.x2.c<T> {

        private static final long serialVersionUID = -3029755663834015785L;
        b(y<? super T> y, w<?> w2) {
            super(y, w2);
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
    public x2(w<T> w, w<?> w2, boolean z3) {
        super(w);
        this.b = w2;
        this.c = z3;
    }

    public void subscribeActual(y<? super T> y) {
        i.b.m0.e.e.x2.c aVar;
        w wVar;
        w obj4;
        e eVar = new e(y);
        if (this.c) {
            aVar = new x2.a(eVar, this.b);
            this.a.subscribe(aVar);
        } else {
            aVar = new x2.b(eVar, this.b);
            this.a.subscribe(aVar);
        }
    }
}
