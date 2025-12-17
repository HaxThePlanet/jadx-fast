package i.b.m0.e.f;

import i.b.a0;
import i.b.d0;
import i.b.g0;
import i.b.j0.b;
import i.b.l0.n;
import i.b.m0.b.b;
import io.reactivex.exceptions.a;

/* loaded from: classes3.dex */
public final class k0<T, R>  extends a0<R> {

    final g0<? extends T> a;
    final n<? super T, ? extends R> b;

    static final class a implements d0<T> {

        final d0<? super R> a;
        final n<? super T, ? extends R> b;
        a(d0<? super R> d0, n<? super T, ? extends R> n2) {
            super();
            this.a = d0;
            this.b = n2;
        }

        @Override // i.b.d0
        public void onError(Throwable throwable) {
            this.a.onError(throwable);
        }

        @Override // i.b.d0
        public void onSubscribe(b b) {
            this.a.onSubscribe(b);
        }

        public void onSuccess(T t) {
            try {
                final Object obj2 = this.b.apply(t);
                b.e(obj2, "The mapper function returned a null value.");
                this.a.onSuccess(obj2);
                a.b(t);
                onError(t);
            }
        }
    }
    public k0(g0<? extends T> g0, n<? super T, ? extends R> n2) {
        super();
        this.a = g0;
        this.b = n2;
    }

    protected void subscribeActual(d0<? super R> d0) {
        k0.a aVar = new k0.a(d0, this.b);
        this.a.subscribe(aVar);
    }
}
