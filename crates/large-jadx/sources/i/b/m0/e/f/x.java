package i.b.m0.e.f;

import i.b.a0;
import i.b.d0;
import i.b.g0;
import i.b.j0.b;
import i.b.l0.n;
import i.b.m0.a.c;
import i.b.m0.b.b;
import io.reactivex.exceptions.a;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes3.dex */
public final class x<T, R>  extends a0<R> {

    final g0<? extends T> a;
    final n<? super T, ? extends g0<? extends R>> b;

    static final class a extends AtomicReference<b> implements d0<T>, b {

        private static final long serialVersionUID = 3258103020495908596L;
        final d0<? super R> downstream;
        final n<? super T, ? extends g0<? extends R>> mapper;
        a(d0<? super R> d0, n<? super T, ? extends g0<? extends R>> n2) {
            super();
            this.downstream = d0;
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
            d0 downstream;
            try {
                final Object obj3 = this.mapper.apply(t);
                b.e(obj3, "The single returned by the mapper is null");
                if (!isDisposed()) {
                }
                aVar = new x.a.a(this, this.downstream);
                (g0)obj3.subscribe(aVar);
                a.b(t);
                this.downstream.onError(t);
            }
        }
    }
    public x(g0<? extends T> g0, n<? super T, ? extends g0<? extends R>> n2) {
        super();
        this.b = n2;
        this.a = g0;
    }

    protected void subscribeActual(d0<? super R> d0) {
        x.a aVar = new x.a(d0, this.b);
        this.a.subscribe(aVar);
    }
}
