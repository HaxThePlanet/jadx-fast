package i.b.m0.e.c;

import i.b.j0.b;
import i.b.l0.o;
import i.b.m0.a.c;
import i.b.n;
import i.b.p;
import io.reactivex.exceptions.a;

/* compiled from: MaybeFilter.java */
/* loaded from: classes3.dex */
public final class e<T> extends a<T, T> {

    final o<? super T> b;

    static final class a<T> implements n<T>, b {

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

        public void onComplete() {
            this.a.onComplete();
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
    public e(p<T> pVar, o<? super T> oVar) {
        super(pVar);
        this.b = oVar;
    }

    @Override // i.b.m0.e.c.a
    protected void w(n<? super T> nVar) {
        this.a.b(new e.a(nVar, this.b));
    }
}
