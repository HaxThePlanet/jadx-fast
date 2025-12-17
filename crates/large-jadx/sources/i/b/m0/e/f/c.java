package i.b.m0.e.f;

import i.b.a0;
import i.b.d0;
import i.b.g0;
import i.b.j0.b;
import i.b.l0.d;
import io.reactivex.exceptions.a;

/* loaded from: classes3.dex */
public final class c<T>  extends a0<Boolean> {

    final g0<T> a;
    final Object b;
    final d<Object, Object> c;

    final class a implements d0<T> {

        private final d0<? super Boolean> a;
        final i.b.m0.e.f.c b;
        a(i.b.m0.e.f.c c, d0 d02) {
            this.b = c;
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
                i.b.m0.e.f.c cVar = this.b;
                this.a.onSuccess(Boolean.valueOf(cVar.c.a(t, cVar.b)));
                a.b(t);
                this.a.onError(t);
            }
        }
    }
    public c(g0<T> g0, Object object2, d<Object, Object> d3) {
        super();
        this.a = g0;
        this.b = object2;
        this.c = d3;
    }

    protected void subscribeActual(d0<? super Boolean> d0) {
        c.a aVar = new c.a(this, d0);
        this.a.subscribe(aVar);
    }
}
