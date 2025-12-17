package i.b.m0.e.f;

import i.b.a0;
import i.b.d0;
import i.b.g0;
import i.b.j0.b;
import i.b.l0.f;
import i.b.m0.a.d;
import i.b.p0.a;
import io.reactivex.exceptions.a;

/* loaded from: classes3.dex */
public final class s<T>  extends a0<T> {

    final g0<T> a;
    final f<? super b> b;

    static final class a implements d0<T> {

        final d0<? super T> a;
        final f<? super b> b;
        boolean c;
        a(d0<? super T> d0, f<? super b> f2) {
            super();
            this.a = d0;
            this.b = f2;
        }

        @Override // i.b.d0
        public void onError(Throwable throwable) {
            if (this.c) {
                a.t(throwable);
            }
            this.a.onError(throwable);
        }

        @Override // i.b.d0
        public void onSubscribe(b b) {
            try {
                this.b.accept(b);
                this.a.onSubscribe(b);
                a.b(th);
                this.c = true;
                b.dispose();
                b = this.a;
                d.error(th, b);
            }
        }

        public void onSuccess(T t) {
            if (this.c) {
            }
            this.a.onSuccess(t);
        }
    }
    public s(g0<T> g0, f<? super b> f2) {
        super();
        this.a = g0;
        this.b = f2;
    }

    protected void subscribeActual(d0<? super T> d0) {
        s.a aVar = new s.a(d0, this.b);
        this.a.subscribe(aVar);
    }
}
