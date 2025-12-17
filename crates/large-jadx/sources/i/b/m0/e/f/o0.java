package i.b.m0.e.f;

import i.b.a0;
import i.b.d0;
import i.b.g0;
import i.b.j0.b;
import i.b.l0.n;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.a;

/* loaded from: classes3.dex */
public final class o0<T>  extends a0<T> {

    final g0<? extends T> a;
    final n<? super Throwable, ? extends T> b;
    final T c;

    final class a implements d0<T> {

        private final d0<? super T> a;
        final i.b.m0.e.f.o0 b;
        a(i.b.m0.e.f.o0 o0, d0 d02) {
            this.b = o0;
            super();
            this.a = d02;
        }

        @Override // i.b.d0
        public void onError(Throwable throwable) {
            Object apply;
            i.b.m0.e.f.o0 o0Var = this.b;
            n nVar = o0Var.b;
            if (nVar != null) {
                apply = nVar.apply(throwable);
            } else {
                apply = o0Var.c;
            }
            if (apply == null) {
                NullPointerException nullPointerException = new NullPointerException("Value supplied was null");
                nullPointerException.initCause(throwable);
                this.a.onError(nullPointerException);
            }
            try {
                this.a.onSuccess(apply);
            }
        }

        @Override // i.b.d0
        public void onSubscribe(b b) {
            this.a.onSubscribe(b);
        }

        public void onSuccess(T t) {
            this.a.onSuccess(t);
        }
    }
    public o0(g0<? extends T> g0, n<? super Throwable, ? extends T> n2, T t3) {
        super();
        this.a = g0;
        this.b = n2;
        this.c = t3;
    }

    protected void subscribeActual(d0<? super T> d0) {
        o0.a aVar = new o0.a(this, d0);
        this.a.subscribe(aVar);
    }
}
