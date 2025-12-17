package i.b.m0.e.c;

import i.b.j0.b;
import i.b.l0.n;
import i.b.m0.a.c;
import i.b.m0.b.b;
import i.b.n;
import i.b.p;
import io.reactivex.exceptions.a;

/* loaded from: classes3.dex */
public final class o<T, R>  extends i.b.m0.e.c.a<T, R> {

    final n<? super T, ? extends R> b;

    static final class a implements n<T>, b {

        final n<? super R> a;
        final n<? super T, ? extends R> b;
        b c;
        a(n<? super R> n, n<? super T, ? extends R> n2) {
            super();
            this.a = n;
            this.b = n2;
        }

        @Override // i.b.n
        public void dispose() {
            this.c = c.DISPOSED;
            this.c.dispose();
        }

        @Override // i.b.n
        public boolean isDisposed() {
            return this.c.isDisposed();
        }

        @Override // i.b.n
        public void onComplete() {
            this.a.onComplete();
        }

        @Override // i.b.n
        public void onError(Throwable throwable) {
            this.a.onError(throwable);
        }

        @Override // i.b.n
        public void onSubscribe(b b) {
            Object obj2;
            if (c.validate(this.c, b)) {
                this.c = b;
                this.a.onSubscribe(this);
            }
        }

        public void onSuccess(T t) {
            try {
                final Object obj2 = this.b.apply(t);
                b.e(obj2, "The mapper returned a null item");
                this.a.onSuccess(obj2);
                a.b(t);
                this.a.onError(t);
            }
        }
    }
    public o(p<T> p, n<? super T, ? extends R> n2) {
        super(p);
        this.b = n2;
    }

    protected void w(n<? super R> n) {
        o.a aVar = new o.a(n, this.b);
        this.a.b(aVar);
    }
}
