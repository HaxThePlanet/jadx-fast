package i.b.m0.e.f;

import i.b.a0;
import i.b.d0;
import i.b.g0;
import i.b.j0.b;
import i.b.l0.f;
import i.b.m0.a.c;

/* compiled from: SingleDoAfterSuccess.java */
/* loaded from: classes3.dex */
public final class m<T> extends a0<T> {

    final g0<T> a;
    final f<? super T> b;

    static final class a<T> implements d0<T>, b {

        final d0<? super T> a;
        final f<? super T> b;
        b c;
        a(d0<? super T> d0Var, f<? super T> fVar) {
            super();
            this.a = d0Var;
            this.b = fVar;
        }

        public void dispose() {
            this.c.dispose();
        }

        public boolean isDisposed() {
            return this.c.isDisposed();
        }

        public void onError(Throwable th) {
            this.a.onError(th);
        }

        public void onSubscribe(b bVar) {
            if (c.validate(this.c, bVar)) {
                this.c = bVar;
                this.a.onSubscribe(this);
            }
        }

        public void onSuccess(T t) {
            this.a.onSuccess(t);
            try {
                this.b.accept(t);
            } catch (Throwable th) {
                a.b(th);
                a.t(th);
            }
        }
    }
    public m(g0<T> g0Var, f<? super T> fVar) {
        super();
        this.a = g0Var;
        this.b = fVar;
    }

    @Override // i.b.a0
    protected void subscribeActual(d0<? super T> d0Var) {
        this.a.subscribe(new m.a(d0Var, this.b));
    }
}
