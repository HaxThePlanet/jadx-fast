package i.b.m0.e.a;

import i.b.d;
import i.b.d0;
import i.b.g0;

/* compiled from: CompletableFromSingle.java */
/* loaded from: classes3.dex */
public final class h<T> extends i.b.b {

    final g0<T> a;

    static final class a<T> implements d0<T> {

        final d a;
        a(d dVar) {
            super();
            this.a = dVar;
        }

        public void onError(Throwable th) {
            this.a.onError(th);
        }

        public void onSubscribe(i.b.j0.b bVar) {
            this.a.onSubscribe(bVar);
        }

        public void onSuccess(T t) {
            this.a.onComplete();
        }
    }
    public h(g0<T> g0Var) {
        super();
        this.a = g0Var;
    }

    @Override // i.b.b
    protected void x(d dVar) {
        this.a.subscribe(new h.a(dVar));
    }
}
