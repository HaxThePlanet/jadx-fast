package i.b.m0.e.f;

import i.b.a0;
import i.b.d0;
import i.b.g0;
import i.b.j0.b;
import i.b.m0.a.c;

/* compiled from: SingleDoAfterTerminate.java */
/* loaded from: classes3.dex */
public final class n<T> extends a0<T> {

    final g0<T> a;
    final i.b.l0.a b;

    static final class a<T> implements d0<T>, b {

        final d0<? super T> a;
        final i.b.l0.a b;
        b c;
        a(d0<? super T> d0Var, i.b.l0.a aVar) {
            super();
            this.a = d0Var;
            this.b = aVar;
        }

        private void a() {
            try {
                this.b.run();
            } catch (Throwable th) {
                a.b(th);
                a.t(th);
            }
        }

        public void dispose() {
            this.c.dispose();
        }

        public boolean isDisposed() {
            return this.c.isDisposed();
        }

        public void onError(Throwable th) {
            this.a.onError(th);
            a();
        }

        public void onSubscribe(b bVar) {
            if (c.validate(this.c, bVar)) {
                this.c = bVar;
                this.a.onSubscribe(this);
            }
        }

        public void onSuccess(T t) {
            this.a.onSuccess(t);
            a();
        }
    }
    public n(g0<T> g0Var, i.b.l0.a aVar) {
        super();
        this.a = g0Var;
        this.b = aVar;
    }

    @Override // i.b.a0
    protected void subscribeActual(d0<? super T> d0Var) {
        this.a.subscribe(new n.a(d0Var, this.b));
    }
}
