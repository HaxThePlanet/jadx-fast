package i.b.m0.e.b;

import i.b.a0;
import i.b.d0;
import i.b.h;
import i.b.j0.b;
import i.b.k;
import i.b.m0.a.d;
import i.b.m0.b.b;
import i.b.m0.c.b;
import i.b.m0.i.g;
import i.b.m0.j.b;
import i.b.p0.a;
import io.reactivex.exceptions.a;
import java.util.Collection;
import java.util.concurrent.Callable;
import m.c.c;

/* loaded from: classes3.dex */
public final class n0<T, U extends Collection<? super T>>  extends a0<U> implements b<U> {

    final h<T> a;
    final Callable<U> b;

    static final class a implements k<T>, b {

        final d0<? super U> a;
        c b;
        U c;
        a(d0<? super U> d0, U u2) {
            super();
            this.a = d0;
            this.c = u2;
        }

        @Override // i.b.k
        public void dispose() {
            this.b.cancel();
            this.b = g.CANCELLED;
        }

        @Override // i.b.k
        public boolean isDisposed() {
            int i;
            i = this.b == g.CANCELLED ? 1 : 0;
            return i;
        }

        @Override // i.b.k
        public void onComplete() {
            this.b = g.CANCELLED;
            this.a.onSuccess(this.c);
        }

        @Override // i.b.k
        public void onError(Throwable throwable) {
            this.c = 0;
            this.b = g.CANCELLED;
            this.a.onError(throwable);
        }

        public void onNext(T t) {
            this.c.add(t);
        }

        @Override // i.b.k
        public void onSubscribe(c c) {
            boolean validate;
            if (g.validate(this.b, c)) {
                this.b = c;
                this.a.onSubscribe(this);
                c.request(Long.MAX_VALUE);
            }
        }
    }
    public n0(h<T> h) {
        super(h, b.asCallable());
    }

    public n0(h<T> h, Callable<U> callable2) {
        super();
        this.a = h;
        this.b = callable2;
    }

    public h<U> c() {
        m0 m0Var = new m0(this.a, this.b);
        return a.l(m0Var);
    }

    protected void subscribeActual(d0<? super U> d0) {
        try {
            Object call = this.b.call();
            b.e(call, "The collectionSupplier returned a null collection. Null values are generally not allowed in 2.x operators and sources.");
            n0.a aVar = new n0.a(d0, (Collection)call);
            this.a.b0(aVar);
            a.b(th);
            d.error(th, d0);
        }
    }
}
