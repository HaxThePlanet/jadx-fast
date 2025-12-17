package i.b.m0.e.f;

import i.b.d0;
import i.b.g0;
import i.b.j0.b;
import i.b.l;
import i.b.l0.n;
import i.b.m0.a.c;
import i.b.m0.b.b;
import i.b.n;
import i.b.p;
import io.reactivex.exceptions.a;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes3.dex */
public final class b0<T, R>  extends l<R> {

    final g0<? extends T> a;
    final n<? super T, ? extends p<? extends R>> b;

    static final class a implements n<R> {

        final AtomicReference<b> a;
        final n<? super R> b;
        a(AtomicReference<b> atomicReference, n<? super R> n2) {
            super();
            this.a = atomicReference;
            this.b = n2;
        }

        @Override // i.b.n
        public void onComplete() {
            this.b.onComplete();
        }

        @Override // i.b.n
        public void onError(Throwable throwable) {
            this.b.onError(throwable);
        }

        @Override // i.b.n
        public void onSubscribe(b b) {
            c.replace(this.a, b);
        }

        public void onSuccess(R r) {
            this.b.onSuccess(r);
        }
    }

    static final class b extends AtomicReference<b> implements d0<T>, b {

        private static final long serialVersionUID = -5843758257109742742L;
        final n<? super R> downstream;
        final n<? super T, ? extends p<? extends R>> mapper;
        b(n<? super R> n, n<? super T, ? extends p<? extends R>> n2) {
            super();
            this.downstream = n;
            this.mapper = n2;
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public void dispose() {
            c.dispose(this);
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public boolean isDisposed() {
            return c.isDisposed((b)get());
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public void onError(Throwable throwable) {
            this.downstream.onError(throwable);
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public void onSubscribe(b b) {
            boolean obj1;
            if (c.setOnce(this, b)) {
                this.downstream.onSubscribe(this);
            }
        }

        public void onSuccess(T t) {
            boolean aVar;
            n downstream;
            try {
                final Object obj3 = this.mapper.apply(t);
                b.e(obj3, "The mapper returned a null MaybeSource");
                if (!isDisposed()) {
                }
                aVar = new b0.a(this, this.downstream);
                (p)obj3.b(aVar);
                a.b(t);
                onError(t);
            }
        }
    }
    public b0(g0<? extends T> g0, n<? super T, ? extends p<? extends R>> n2) {
        super();
        this.b = n2;
        this.a = g0;
    }

    protected void w(n<? super R> n) {
        b0.b bVar = new b0.b(n, this.b);
        this.a.subscribe(bVar);
    }
}
