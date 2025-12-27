package i.b.m0.e.f;

import i.b.d0;
import i.b.g0;
import i.b.j0.b;
import i.b.m0.a.c;
import i.b.m0.d.l;
import i.b.r;
import i.b.y;

/* compiled from: SingleToObservable.java */
/* loaded from: classes3.dex */
public final class v0<T> extends r<T> {

    final g0<? extends T> a;

    static final class a<T> extends l<T> implements d0<T> {

        private static final long serialVersionUID = 3786543492451018833L;
        b upstream;
        a(y<? super T> yVar) {
            super(yVar);
        }

        @Override // i.b.m0.d.l
        public void dispose() {
            super.dispose();
            this.upstream.dispose();
        }

        @Override // i.b.m0.d.l
        public void onError(Throwable th) {
            c(th);
        }

        @Override // i.b.m0.d.l
        public void onSubscribe(b bVar) {
            if (c.validate(this.upstream, bVar)) {
                this.upstream = bVar;
                this.downstream.onSubscribe(this);
            }
        }

        @Override // i.b.m0.d.l
        public void onSuccess(T t) {
            b(t);
        }
    }
    public v0(g0<? extends T> g0Var) {
        super();
        this.a = g0Var;
    }

    public static <T> d0<T> c(y<? super T> yVar) {
        return new v0.a(yVar);
    }

    @Override // i.b.r
    public void subscribeActual(y<? super T> yVar) {
        this.a.subscribe(v0.c(yVar));
    }
}
