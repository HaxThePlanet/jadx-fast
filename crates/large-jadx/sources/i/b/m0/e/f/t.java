package i.b.m0.e.f;

import i.b.a0;
import i.b.d0;
import i.b.g0;
import i.b.j0.b;
import i.b.l0.f;
import io.reactivex.exceptions.a;

/* compiled from: SingleDoOnSuccess.java */
/* loaded from: classes3.dex */
public final class t<T> extends a0<T> {

    final g0<T> a;
    final f<? super T> b;

    final class a implements d0<T> {

        final d0<? super T> a;
        final /* synthetic */ t b;
        a(d0 d0Var) {
            this.b = tVar;
            super();
            this.a = d0Var;
        }

        public void onError(Throwable th) {
            this.a.onError(th);
        }

        public void onSubscribe(b bVar) {
            this.a.onSubscribe(bVar);
        }

        public void onSuccess(T t) {
            try {
                this.b.b.accept(t);
            } catch (Throwable th) {
                a.b(th);
                this.a.onError(th);
                return;
            }
            this.a.onSuccess(th);
        }
    }
    public t(g0<T> g0Var, f<? super T> fVar) {
        super();
        this.a = g0Var;
        this.b = fVar;
    }

    @Override // i.b.a0
    protected void subscribeActual(d0<? super T> d0Var) {
        this.a.subscribe(new t.a(this, d0Var));
    }
}
