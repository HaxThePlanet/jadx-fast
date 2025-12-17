package i.b.m0.e.e;

import i.b.a0;
import i.b.d0;
import i.b.j0.b;
import i.b.m0.a.c;
import i.b.m0.a.d;
import i.b.m0.b.a;
import i.b.m0.b.b;
import i.b.m0.c.d;
import i.b.p0.a;
import i.b.r;
import i.b.w;
import i.b.y;
import io.reactivex.exceptions.a;
import java.util.Collection;
import java.util.concurrent.Callable;

/* loaded from: classes3.dex */
public final class c4<T, U extends Collection<? super T>>  extends a0<U> implements d<U> {

    final w<T> a;
    final Callable<U> b;

    static final class a implements y<T>, b {

        final d0<? super U> a;
        U b;
        b c;
        a(d0<? super U> d0, U u2) {
            super();
            this.a = d0;
            this.b = u2;
        }

        @Override // i.b.y
        public void dispose() {
            this.c.dispose();
        }

        @Override // i.b.y
        public boolean isDisposed() {
            return this.c.isDisposed();
        }

        @Override // i.b.y
        public void onComplete() {
            this.b = 0;
            this.a.onSuccess(this.b);
        }

        @Override // i.b.y
        public void onError(Throwable throwable) {
            this.b = 0;
            this.a.onError(throwable);
        }

        public void onNext(T t) {
            this.b.add(t);
        }

        @Override // i.b.y
        public void onSubscribe(b b) {
            Object obj2;
            if (c.validate(this.c, b)) {
                this.c = b;
                this.a.onSubscribe(this);
            }
        }
    }
    public c4(w<T> w, int i2) {
        super();
        this.a = w;
        this.b = a.e(i2);
    }

    public c4(w<T> w, Callable<U> callable2) {
        super();
        this.a = w;
        this.b = callable2;
    }

    public r<U> a() {
        b4 b4Var = new b4(this.a, this.b);
        return a.n(b4Var);
    }

    public void subscribeActual(d0<? super U> d0) {
        try {
            Object call = this.b.call();
            b.e(call, "The collectionSupplier returned a null collection. Null values are generally not allowed in 2.x operators and sources.");
            c4.a aVar = new c4.a(d0, (Collection)call);
            this.a.subscribe(aVar);
            a.b(th);
            d.error(th, d0);
        }
    }
}
