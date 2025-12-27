package i.b.m0.e.f;

import i.b.a0;
import i.b.d0;
import i.b.g0;
import i.b.j0.b;
import i.b.m0.a.c;

/* compiled from: SingleHide.java */
/* loaded from: classes3.dex */
public final class g0<T> extends a0<T> {

    final g0<? extends T> a;

    static final class a<T> implements d0<T>, b {

        final d0<? super T> a;
        b b;
        a(d0<? super T> d0Var) {
            super();
            this.a = d0Var;
        }

        public void dispose() {
            this.b.dispose();
        }

        public boolean isDisposed() {
            return this.b.isDisposed();
        }

        public void onError(Throwable th) {
            this.a.onError(th);
        }

        public void onSubscribe(b bVar) {
            if (c.validate(this.b, bVar)) {
                this.b = bVar;
                this.a.onSubscribe(this);
            }
        }

        public void onSuccess(T t) {
            this.a.onSuccess(t);
        }
    }
    public g0(g0<? extends T> g0Var) {
        super();
        this.a = g0Var;
    }

    @Override // i.b.a0
    protected void subscribeActual(d0<? super T> d0Var) {
        this.a.subscribe(new g0.a(d0Var));
    }
}
