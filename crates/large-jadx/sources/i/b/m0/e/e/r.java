package i.b.m0.e.e;

import i.b.j0.b;
import i.b.l0.b;
import i.b.m0.a.c;
import i.b.m0.a.d;
import i.b.m0.b.b;
import i.b.p0.a;
import i.b.w;
import i.b.y;
import java.util.concurrent.Callable;

/* loaded from: classes3.dex */
public final class r<T, U>  extends i.b.m0.e.e.a<T, U> {

    final Callable<? extends U> b;
    final b<? super U, ? super T> c;

    static final class a implements y<T>, b {

        final y<? super U> a;
        final b<? super U, ? super T> b;
        final U c;
        b v;
        boolean w;
        a(y<? super U> y, U u2, b<? super U, ? super T> b3) {
            super();
            this.a = y;
            this.b = b3;
            this.c = u2;
        }

        @Override // i.b.y
        public void dispose() {
            this.v.dispose();
        }

        @Override // i.b.y
        public boolean isDisposed() {
            return this.v.isDisposed();
        }

        @Override // i.b.y
        public void onComplete() {
            if (this.w) {
            }
            this.w = true;
            this.a.onNext(this.c);
            this.a.onComplete();
        }

        @Override // i.b.y
        public void onError(Throwable throwable) {
            if (this.w) {
                a.t(throwable);
            }
            this.w = true;
            this.a.onError(throwable);
        }

        public void onNext(T t) {
            b bVar;
            Object obj3;
            if (this.w) {
            }
            this.b.a(this.c, t);
        }

        @Override // i.b.y
        public void onSubscribe(b b) {
            Object obj2;
            if (c.validate(this.v, b)) {
                this.v = b;
                this.a.onSubscribe(this);
            }
        }
    }
    public r(w<T> w, Callable<? extends U> callable2, b<? super U, ? super T> b3) {
        super(w);
        this.b = callable2;
        this.c = b3;
    }

    protected void subscribeActual(y<? super U> y) {
        try {
            Object call = this.b.call();
            b.e(call, "The initialSupplier returned a null value");
            r.a aVar = new r.a(y, call, this.c);
            this.a.subscribe(aVar);
            d.error(th, y);
        }
    }
}
