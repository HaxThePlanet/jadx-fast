package i.b.m0.e.c;

import i.b.m0.a.c;
import i.b.p;
import io.reactivex.exceptions.a;

/* compiled from: MaybeMap.java */
/* loaded from: classes3.dex */
public final class o<T, R> extends a<T, R> {

    final i.b.l0.n<? super T, ? extends R> b;

    static final class a<T, R> implements i.b.n<T>, i.b.j0.b {

        final i.b.n<? super R> a;
        final i.b.l0.n<? super T, ? extends R> b;
        i.b.j0.b c;
        a(i.b.n<? super R> nVar, i.b.l0.n<? super T, ? extends R> nVar2) {
            super();
            this.a = nVar;
            this.b = nVar2;
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

        public void onSubscribe(i.b.j0.b bVar) {
            if (c.validate(this.c, bVar)) {
                this.c = bVar;
                this.a.onSubscribe(this);
            }
        }

        public void onSuccess(T t) {
            try {
                final Object apply = this.b.apply(t);
                b.e(apply, "The mapper returned a null item");
            } catch (Throwable th) {
                a.b(th);
                this.a.onError(th);
                return;
            }
            this.a.onSuccess(apply);
        }
    }
    public o(p<T> pVar, i.b.l0.n<? super T, ? extends R> nVar) {
        super(pVar);
        this.b = nVar;
    }

    @Override // i.b.m0.e.c.a
    protected void w(i.b.n<? super R> nVar) {
        this.a.b(new o.a(nVar, this.b));
    }
}
