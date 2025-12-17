package i.b.m0.e.f;

import i.b.a0;
import i.b.d0;
import i.b.j0.b;
import i.b.l;
import i.b.l0.n;
import i.b.m0.a.c;
import i.b.m0.b.b;
import i.b.n;
import i.b.q;
import io.reactivex.exceptions.a;

/* loaded from: classes3.dex */
public final class k<T, R>  extends l<R> {

    final a0<T> a;
    final n<? super T, q<R>> b;

    static final class a implements d0<T>, b {

        final n<? super R> a;
        final n<? super T, q<R>> b;
        b c;
        a(n<? super R> n, n<? super T, q<R>> n2) {
            super();
            this.a = n;
            this.b = n2;
        }

        @Override // i.b.d0
        public void dispose() {
            this.c.dispose();
        }

        @Override // i.b.d0
        public boolean isDisposed() {
            return this.c.isDisposed();
        }

        @Override // i.b.d0
        public void onError(Throwable throwable) {
            this.a.onError(throwable);
        }

        @Override // i.b.d0
        public void onSubscribe(b b) {
            Object obj2;
            if (c.validate(this.c, b)) {
                this.c = b;
                this.a.onSubscribe(this);
            }
        }

        public void onSuccess(T t) {
            n nVar;
            Object obj2;
            try {
                obj2 = this.b.apply(t);
                b.e(obj2, "The selector returned a null Notification");
                if ((q)obj2.h()) {
                } else {
                }
                this.a.onSuccess(obj2.e());
                if (obj2.f()) {
                } else {
                }
                this.a.onComplete();
                this.a.onError(obj2.d());
                a.b(t);
                this.a.onError(t);
            }
        }
    }
    public k(a0<T> a0, n<? super T, q<R>> n2) {
        super();
        this.a = a0;
        this.b = n2;
    }

    protected void w(n<? super R> n) {
        k.a aVar = new k.a(n, this.b);
        this.a.subscribe(aVar);
    }
}
