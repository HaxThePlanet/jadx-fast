package i.b.m0.e.c;

import i.b.j0.b;
import i.b.m0.a.c;
import i.b.n;
import i.b.p;

/* compiled from: MaybeIsEmpty.java */
/* loaded from: classes3.dex */
public final class l<T> extends a<T, Boolean> {

    static final class a<T> implements n<T>, b {

        final n<? super Boolean> a;
        b b;
        a(n<? super Boolean> nVar) {
            super();
            this.a = nVar;
        }

        public void dispose() {
            this.b.dispose();
        }

        public boolean isDisposed() {
            return this.b.isDisposed();
        }

        public void onComplete() {
            this.a.onSuccess(Boolean.TRUE);
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
            this.a.onSuccess(Boolean.FALSE);
        }
    }
    public l(p<T> pVar) {
        super(pVar);
    }

    @Override // i.b.m0.e.c.a
    protected void w(n<? super Boolean> nVar) {
        this.a.b(new l.a(nVar));
    }
}
