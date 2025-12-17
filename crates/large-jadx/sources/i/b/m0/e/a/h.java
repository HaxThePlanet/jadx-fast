package i.b.m0.e.a;

import i.b.b;
import i.b.d;
import i.b.d0;
import i.b.g0;
import i.b.j0.b;

/* loaded from: classes3.dex */
public final class h<T>  extends b {

    final g0<T> a;

    static final class a implements d0<T> {

        final d a;
        a(d d) {
            super();
            this.a = d;
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
            this.a.onComplete();
        }
    }
    public h(g0<T> g0) {
        super();
        this.a = g0;
    }

    @Override // i.b.b
    protected void x(d d) {
        h.a aVar = new h.a(d);
        this.a.subscribe(aVar);
    }
}
