package i.b.m0.e.e;

import i.b.f;
import i.b.j0.a;
import i.b.j0.b;
import i.b.l0.n;
import i.b.m0.a.c;
import i.b.m0.b.b;
import i.b.m0.d.b;
import i.b.m0.j.c;
import i.b.p0.a;
import i.b.w;
import i.b.y;
import io.reactivex.exceptions.a;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes3.dex */
public final class w0<T>  extends i.b.m0.e.e.a<T, T> {

    final n<? super T, ? extends f> b;
    final boolean c;

    static final class a extends b<T> implements y<T> {

        private static final long serialVersionUID = 8443155186132538303L;
        final boolean delayErrors;
        volatile boolean disposed;
        final y<? super T> downstream;
        final c errors;
        final n<? super T, ? extends f> mapper;
        final a set;
        b upstream;
        a(y<? super T> y, n<? super T, ? extends f> n2, boolean z3) {
            super();
            this.downstream = y;
            this.mapper = n2;
            this.delayErrors = z3;
            c obj1 = new c();
            this.errors = obj1;
            obj1 = new a();
            this.set = obj1;
            lazySet(1);
        }

        void a(i.b.m0.e.e.w0.a.a<T> w0$a.a) {
            this.set.c(a.a);
            onComplete();
        }

        void b(i.b.m0.e.e.w0.a.a<T> w0$a.a, Throwable throwable2) {
            this.set.c(a.a);
            onError(throwable2);
        }

        @Override // i.b.m0.d.b
        public void clear() {
        }

        @Override // i.b.m0.d.b
        public void dispose() {
            this.disposed = true;
            this.upstream.dispose();
            this.set.dispose();
        }

        @Override // i.b.m0.d.b
        public boolean isDisposed() {
            return this.upstream.isDisposed();
        }

        @Override // i.b.m0.d.b
        public boolean isEmpty() {
            return 1;
        }

        @Override // i.b.m0.d.b
        public void onComplete() {
            int decrementAndGet;
            y downstream;
            if (decrementAndGet() == 0) {
                decrementAndGet = this.errors.b();
                if (decrementAndGet != null) {
                    this.downstream.onError(decrementAndGet);
                } else {
                    this.downstream.onComplete();
                }
            }
        }

        @Override // i.b.m0.d.b
        public void onError(Throwable throwable) {
            boolean downstream;
            Throwable obj2;
            if (this.errors.a(throwable)) {
                if (this.delayErrors) {
                    if (decrementAndGet() == 0) {
                        this.downstream.onError(this.errors.b());
                    }
                } else {
                    dispose();
                    if (getAndSet(0) > 0) {
                        this.downstream.onError(this.errors.b());
                    }
                }
            } else {
                a.t(throwable);
            }
        }

        public void onNext(T t) {
            boolean disposed;
            try {
                final Object obj3 = this.mapper.apply(t);
                b.e(obj3, "The mapper returned a null CompletableSource");
                getAndIncrement();
                w0.a.a aVar = new w0.a.a(this);
                if (!this.disposed && this.set.b(aVar)) {
                }
                if (this.set.b(aVar)) {
                }
                (f)obj3.b(aVar);
                a.b(t);
                this.upstream.dispose();
                onError(t);
            }
        }

        @Override // i.b.m0.d.b
        public void onSubscribe(b b) {
            Object obj2;
            if (c.validate(this.upstream, b)) {
                this.upstream = b;
                this.downstream.onSubscribe(this);
            }
        }

        public T poll() {
            return 0;
        }

        @Override // i.b.m0.d.b
        public int requestFusion(int i) {
            return i &= 2;
        }
    }
    public w0(w<T> w, n<? super T, ? extends f> n2, boolean z3) {
        super(w);
        this.b = n2;
        this.c = z3;
    }

    protected void subscribeActual(y<? super T> y) {
        w0.a aVar = new w0.a(y, this.b, this.c);
        this.a.subscribe(aVar);
    }
}
