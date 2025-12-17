package i.b.m0.e.f;

import i.b.a0;
import i.b.d0;
import i.b.g0;
import i.b.j0.b;
import i.b.l0.f;
import io.reactivex.exceptions.a;

/* loaded from: classes3.dex */
public final class t<T>  extends a0<T> {

    final g0<T> a;
    final f<? super T> b;

    final class a implements d0<T> {

        final d0<? super T> a;
        final i.b.m0.e.f.t b;
        a(i.b.m0.e.f.t t, d0 d02) {
            this.b = t;
            super();
            this.a = d02;
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
                tVar.b.accept(t);
                this.a.onSuccess(t);
                a.b(t);
                this.a.onError(t);
            }
        }
    }
    public t(g0<T> g0, f<? super T> f2) {
        super();
        this.a = g0;
        this.b = f2;
    }

    protected void subscribeActual(d0<? super T> d0) {
        t.a aVar = new t.a(this, d0);
        this.a.subscribe(aVar);
    }
}
