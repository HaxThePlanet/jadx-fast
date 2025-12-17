package i.b.m0.e.c;

import i.b.j0.b;
import i.b.m0.a.c;
import i.b.n;
import i.b.p;

/* loaded from: classes3.dex */
public final class l<T>  extends i.b.m0.e.c.a<T, Boolean> {

    static final class a implements n<T>, b {

        final n<? super Boolean> a;
        b b;
        a(n<? super Boolean> n) {
            super();
            this.a = n;
        }

        @Override // i.b.n
        public void dispose() {
            this.b.dispose();
        }

        @Override // i.b.n
        public boolean isDisposed() {
            return this.b.isDisposed();
        }

        @Override // i.b.n
        public void onComplete() {
            this.a.onSuccess(Boolean.TRUE);
        }

        @Override // i.b.n
        public void onError(Throwable throwable) {
            this.a.onError(throwable);
        }

        @Override // i.b.n
        public void onSubscribe(b b) {
            Object obj2;
            if (c.validate(this.b, b)) {
                this.b = b;
                this.a.onSubscribe(this);
            }
        }

        public void onSuccess(T t) {
            this.a.onSuccess(Boolean.FALSE);
        }
    }
    public l(p<T> p) {
        super(p);
    }

    protected void w(n<? super Boolean> n) {
        l.a aVar = new l.a(n);
        this.a.b(aVar);
    }
}
