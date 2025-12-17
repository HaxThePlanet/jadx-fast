package i.b.m0.e.e;

import i.b.j0.b;
import i.b.l0.c;
import i.b.m0.a.c;
import i.b.m0.a.d;
import i.b.m0.b.b;
import i.b.p0.a;
import i.b.w;
import i.b.y;
import io.reactivex.exceptions.a;
import java.util.concurrent.Callable;

/* loaded from: classes3.dex */
public final class a3<T, R>  extends i.b.m0.e.e.a<T, R> {

    final c<R, ? super T, R> b;
    final Callable<R> c;

    static final class a implements y<T>, b {

        final y<? super R> a;
        final c<R, ? super T, R> b;
        R c;
        b v;
        boolean w;
        a(y<? super R> y, c<R, ? super T, R> c2, R r3) {
            super();
            this.a = y;
            this.b = c2;
            this.c = r3;
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
            if (this.w) {
            }
            final Object obj3 = this.b.apply(this.c, t);
            b.e(obj3, "The accumulator returned a null value");
            this.c = obj3;
            this.a.onNext(obj3);
        }

        @Override // i.b.y
        public void onSubscribe(b b) {
            boolean validate;
            Object obj2;
            if (c.validate(this.v, b)) {
                this.v = b;
                this.a.onSubscribe(this);
                this.a.onNext(this.c);
            }
        }
    }
    public a3(w<T> w, Callable<R> callable2, c<R, ? super T, R> c3) {
        super(w);
        this.b = c3;
        this.c = callable2;
    }

    public void subscribeActual(y<? super R> y) {
        try {
            Object call = this.c.call();
            b.e(call, "The seed supplied is null");
            a3.a aVar = new a3.a(y, this.b, call);
            this.a.subscribe(aVar);
            a.b(th);
            d.error(th, y);
        }
    }
}
