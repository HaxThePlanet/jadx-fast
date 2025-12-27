package i.b.m0.e.c;

import i.b.a0;
import i.b.d0;
import i.b.j0.b;
import i.b.l;
import i.b.n;
import i.b.p;
import i.b.p0.a;

/* compiled from: MaybeIsEmptySingle.java */
/* loaded from: classes3.dex */
public final class m<T> extends a0<Boolean> implements i.b.m0.c.c {

    final p<T> a;

    static final class a<T> implements n<T>, b {

        final d0<? super Boolean> a;
        b b;
        a(d0<? super Boolean> d0Var) {
            super();
            this.a = d0Var;
        }

        public void dispose() {
            this.b.dispose();
            this.b = c.DISPOSED;
        }

        public boolean isDisposed() {
            return this.b.isDisposed();
        }

        public void onComplete() {
            this.b = c.DISPOSED;
            this.a.onSuccess(Boolean.TRUE);
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
            this.a.onSuccess(Boolean.FALSE);
        }
    }
    public m(p<T> pVar) {
        super();
        this.a = pVar;
    }

    @Override // i.b.a0
    public l<Boolean> b() {
        return a.m(new l(this.a));
    }

    @Override // i.b.a0
    protected void subscribeActual(d0<? super Boolean> d0Var) {
        this.a.b(new m.a(d0Var));
    }
}
