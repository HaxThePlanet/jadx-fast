package i.b.m0.e.e;

import i.b.j0.b;
import i.b.m0.a.g;
import i.b.p0.a;
import i.b.r;
import i.b.w;
import i.b.y;

/* loaded from: classes3.dex */
public final class g0<T, U>  extends r<T> {

    final w<? extends T> a;
    final w<U> b;

    final class a implements y<U> {

        final g a;
        final y<? super T> b;
        boolean c;
        final i.b.m0.e.e.g0 v;
        a(i.b.m0.e.e.g0 g0, g g2, y y3) {
            this.v = g0;
            super();
            this.a = g2;
            this.b = y3;
        }

        @Override // i.b.y
        public void onComplete() {
            if (this.c) {
            }
            this.c = true;
            g0.a.a aVar = new g0.a.a(this);
            g0Var.a.subscribe(aVar);
        }

        @Override // i.b.y
        public void onError(Throwable throwable) {
            if (this.c) {
                a.t(throwable);
            }
            this.c = true;
            this.b.onError(throwable);
        }

        public void onNext(U u) {
            onComplete();
        }

        @Override // i.b.y
        public void onSubscribe(b b) {
            this.a.b(b);
        }
    }
    public g0(w<? extends T> w, w<U> w2) {
        super();
        this.a = w;
        this.b = w2;
    }

    public void subscribeActual(y<? super T> y) {
        g gVar = new g();
        y.onSubscribe(gVar);
        g0.a aVar = new g0.a(this, gVar, y);
        this.b.subscribe(aVar);
    }
}
