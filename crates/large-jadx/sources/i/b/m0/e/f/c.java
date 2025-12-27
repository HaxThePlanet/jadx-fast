package i.b.m0.e.f;

import i.b.a0;
import i.b.d0;
import i.b.g0;
import i.b.j0.b;
import i.b.l0.d;
import io.reactivex.exceptions.a;

/* compiled from: SingleContains.java */
/* loaded from: classes3.dex */
public final class c<T> extends a0<Boolean> {

    final g0<T> a;
    final Object b;
    final d<Object, Object> c;

    final class a implements d0<T> {

        private final d0<? super Boolean> a;
        final /* synthetic */ c b;
        a(d0 d0Var) {
            this.b = cVar;
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
            } catch (Throwable th) {
                a.b(th);
                this.a.onError(th);
                return;
            }
            this.a.onSuccess(Boolean.valueOf(cVar.c.a(t, cVar.b)));
        }
    }
    public c(g0<T> g0Var, Object object, d<Object, Object> dVar) {
        super();
        this.a = g0Var;
        this.b = object;
        this.c = dVar;
    }

    @Override // i.b.a0
    protected void subscribeActual(d0<? super Boolean> d0Var) {
        this.a.subscribe(new c.a(this, d0Var));
    }
}
