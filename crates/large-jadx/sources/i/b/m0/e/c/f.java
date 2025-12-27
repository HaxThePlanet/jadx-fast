package i.b.m0.e.c;

import i.b.d0;
import i.b.g0;
import i.b.j0.b;
import i.b.l;
import i.b.l0.o;
import i.b.m0.a.c;
import i.b.n;
import io.reactivex.exceptions.a;

/* compiled from: MaybeFilterSingle.java */
/* loaded from: classes3.dex */
public final class f<T> extends l<T> {

    final g0<T> a;
    final o<? super T> b;

    static final class a<T> implements d0<T>, b {

        final n<? super T> a;
        final o<? super T> b;
        b c;
        a(n<? super T> nVar, o<? super T> oVar) {
            super();
            this.a = nVar;
            this.b = oVar;
        }

        public void dispose() {
            this.c = c.DISPOSED;
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
            try {
            } catch (Throwable th) {
                a.b(th);
                this.a.onError(th);
                return;
            }
            if (this.b.test(t)) {
                this.a.onSuccess(th);
            } else {
                this.a.onComplete();
            }
        }
    }
    public f(g0<T> g0Var, o<? super T> oVar) {
        super();
        this.a = g0Var;
        this.b = oVar;
    }

    @Override // i.b.l
    protected void w(n<? super T> nVar) {
        this.a.subscribe(new f.a(nVar, this.b));
    }
}
