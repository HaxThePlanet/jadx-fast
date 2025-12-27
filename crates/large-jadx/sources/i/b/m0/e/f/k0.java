package i.b.m0.e.f;

import i.b.a0;
import i.b.d0;
import i.b.g0;
import i.b.l0.n;
import io.reactivex.exceptions.a;

/* compiled from: SingleMap.java */
/* loaded from: classes3.dex */
public final class k0<T, R> extends a0<R> {

    final g0<? extends T> a;
    final n<? super T, ? extends R> b;

    static final class a<T, R> implements d0<T> {

        final d0<? super R> a;
        final n<? super T, ? extends R> b;
        a(d0<? super R> d0Var, n<? super T, ? extends R> nVar) {
            super();
            this.a = d0Var;
            this.b = nVar;
        }

        public void onError(Throwable th) {
            this.a.onError(th);
        }

        public void onSubscribe(i.b.j0.b bVar) {
            this.a.onSubscribe(bVar);
        }

        public void onSuccess(T t) {
            try {
                final Object apply = this.b.apply(t);
                b.e(apply, "The mapper function returned a null value.");
            } catch (Throwable th) {
                a.b(th);
                onError(th);
                return;
            }
            this.a.onSuccess(apply);
        }
    }
    public k0(g0<? extends T> g0Var, n<? super T, ? extends R> nVar) {
        super();
        this.a = g0Var;
        this.b = nVar;
    }

    @Override // i.b.a0
    protected void subscribeActual(d0<? super R> d0Var) {
        this.a.subscribe(new k0.a(d0Var, this.b));
    }
}
