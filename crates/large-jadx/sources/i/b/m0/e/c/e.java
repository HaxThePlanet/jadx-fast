package i.b.m0.e.c;

import i.b.j0.b;
import i.b.l0.o;
import i.b.m0.a.c;
import i.b.n;
import i.b.p;
import io.reactivex.exceptions.a;

/* loaded from: classes3.dex */
public final class e<T>  extends i.b.m0.e.c.a<T, T> {

    final o<? super T> b;

    static final class a implements n<T>, b {

        final n<? super T> a;
        final o<? super T> b;
        b c;
        a(n<? super T> n, o<? super T> o2) {
            super();
            this.a = n;
            this.b = o2;
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
            n test;
            Object obj2;
            try {
                if (this.b.test(t)) {
                } else {
                }
                this.a.onSuccess(t);
                this.a.onComplete();
                a.b(t);
                this.a.onError(t);
            }
        }
    }
    public e(p<T> p, o<? super T> o2) {
        super(p);
        this.b = o2;
    }

    protected void w(n<? super T> n) {
        e.a aVar = new e.a(n, this.b);
        this.a.b(aVar);
    }
}
