package i.b.m0.e.c;

import i.b.d0;
import i.b.g0;
import i.b.j0.b;
import i.b.l;
import i.b.m0.a.c;
import i.b.n;

/* compiled from: MaybeFromSingle.java */
/* loaded from: classes3.dex */
public final class k<T> extends l<T> {

    final g0<T> a;

    static final class a<T> implements d0<T>, b {

        final n<? super T> a;
        b b;
        a(n<? super T> nVar) {
            super();
            this.a = nVar;
        }

        public void dispose() {
            this.b.dispose();
            this.b = c.DISPOSED;
        }

        public boolean isDisposed() {
            return this.b.isDisposed();
        }

        public void onError(Throwable th) {
            this.b = c.DISPOSED;
            this.a.onError(th);
        }

        public void onSubscribe(b bVar) {
            if (c.validate(this.b, bVar)) {
                this.b = bVar;
                this.a.onSubscribe(this);
            }
        }

        public void onSuccess(T t) {
            this.b = c.DISPOSED;
            this.a.onSuccess(t);
        }
    }
    public k(g0<T> g0Var) {
        super();
        this.a = g0Var;
    }

    @Override // i.b.l
    protected void w(n<? super T> nVar) {
        this.a.subscribe(new k.a(nVar));
    }
}
