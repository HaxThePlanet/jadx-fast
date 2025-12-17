package i.b.m0.e.f;

import i.b.d0;
import i.b.g0;
import i.b.j0.b;
import i.b.m0.a.c;
import i.b.m0.d.l;
import i.b.r;
import i.b.y;

/* loaded from: classes3.dex */
public final class v0<T>  extends r<T> {

    final g0<? extends T> a;

    static final class a extends l<T> implements d0<T> {

        private static final long serialVersionUID = 3786543492451018833L;
        b upstream;
        a(y<? super T> y) {
            super(y);
        }

        @Override // i.b.m0.d.l
        public void dispose() {
            super.dispose();
            this.upstream.dispose();
        }

        @Override // i.b.m0.d.l
        public void onError(Throwable throwable) {
            c(throwable);
        }

        @Override // i.b.m0.d.l
        public void onSubscribe(b b) {
            Object obj2;
            if (c.validate(this.upstream, b)) {
                this.upstream = b;
                this.downstream.onSubscribe(this);
            }
        }

        public void onSuccess(T t) {
            b(t);
        }
    }
    public v0(g0<? extends T> g0) {
        super();
        this.a = g0;
    }

    public static <T> d0<T> c(y<? super T> y) {
        v0.a aVar = new v0.a(y);
        return aVar;
    }

    public void subscribeActual(y<? super T> y) {
        this.a.subscribe(v0.c(y));
    }
}
