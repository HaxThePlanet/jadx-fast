package i.b.m0.e.e;

import i.b.m0.a.d;
import i.b.w;
import i.b.y;
import java.util.concurrent.Callable;

/* compiled from: ObservableScanSeed.java */
/* loaded from: classes3.dex */
public final class a3<T, R> extends a<T, R> {

    final i.b.l0.c<R, ? super T, R> b;
    final Callable<R> c;

    static final class a<T, R> implements y<T>, i.b.j0.b {

        final y<? super R> a;
        final i.b.l0.c<R, ? super T, R> b;
        R c;
        i.b.j0.b v;
        boolean w;
        a(y<? super R> yVar, i.b.l0.c<R, ? super T, R> cVar, R r) {
            super();
            this.a = yVar;
            this.b = cVar;
            this.c = r;
        }

        public void dispose() {
            this.v.dispose();
        }

        public boolean isDisposed() {
            return this.v.isDisposed();
        }

        public void onComplete() {
            if (this.w) {
                return;
            }
            this.w = true;
            this.a.onComplete();
        }

        public void onError(Throwable th) {
            if (this.w) {
                a.t(th);
                return;
            }
            this.w = true;
            this.a.onError(th);
        }

        public void onNext(T t) {
            if (this.w) {
                return;
            }
            try {
                final Object apply = this.b.apply(this.c, t);
                b.e(apply, "The accumulator returned a null value");
            } catch (Throwable th) {
                a.b(th);
                this.v.dispose();
                onError(th);
                return;
            }
            this.c = apply;
            this.a.onNext(apply);
        }

        public void onSubscribe(i.b.j0.b bVar) {
            if (c.validate(this.v, bVar)) {
                this.v = bVar;
                this.a.onSubscribe(this);
                this.a.onNext(this.c);
            }
        }
    }
    public a3(w<T> wVar, Callable<R> callable, i.b.l0.c<R, ? super T, R> cVar) {
        super(wVar);
        this.b = cVar;
        this.c = callable;
    }

    @Override // i.b.m0.e.e.a
    public void subscribeActual(y<? super R> yVar) {
        try {
            Object call = this.c.call();
            b.e(call, "The seed supplied is null");
        } catch (Throwable th) {
            a.b(th);
            d.error(th, yVar);
            return;
        }
        this.a.subscribe(new a3.a(yVar, this.b, call));
    }
}
