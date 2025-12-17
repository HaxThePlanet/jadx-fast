package i.b.m0.e.d;

import i.b.d0;
import i.b.g0;
import i.b.j0.b;
import i.b.l0.n;
import i.b.m0.a.c;
import i.b.m0.b.b;
import i.b.r;
import i.b.w;
import i.b.y;
import io.reactivex.exceptions.a;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes3.dex */
public final class j<T, R>  extends r<R> {

    final g0<T> a;
    final n<? super T, ? extends w<? extends R>> b;

    static final class a extends AtomicReference<b> implements y<R>, d0<T>, b {

        private static final long serialVersionUID = -8948264376121066672L;
        final y<? super R> downstream;
        final n<? super T, ? extends w<? extends R>> mapper;
        a(y<? super R> y, n<? super T, ? extends w<? extends R>> n2) {
            super();
            this.downstream = y;
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
        public void onComplete() {
            this.downstream.onComplete();
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public void onError(Throwable throwable) {
            this.downstream.onError(throwable);
        }

        public void onNext(R r) {
            this.downstream.onNext(r);
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public void onSubscribe(b b) {
            c.replace(this, b);
        }

        public void onSuccess(T t) {
            try {
                final Object obj2 = this.mapper.apply(t);
                b.e(obj2, "The mapper returned a null Publisher");
                (w)obj2.subscribe(this);
                a.b(t);
                this.downstream.onError(t);
            }
        }
    }
    public j(g0<T> g0, n<? super T, ? extends w<? extends R>> n2) {
        super();
        this.a = g0;
        this.b = n2;
    }

    protected void subscribeActual(y<? super R> y) {
        j.a aVar = new j.a(y, this.b);
        y.onSubscribe(aVar);
        this.a.subscribe(aVar);
    }
}
