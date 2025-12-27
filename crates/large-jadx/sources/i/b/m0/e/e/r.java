package i.b.m0.e.e;

import i.b.m0.a.c;
import i.b.m0.a.d;
import i.b.p0.a;
import i.b.w;
import i.b.y;
import java.util.concurrent.Callable;

/* compiled from: ObservableCollect.java */
/* loaded from: classes3.dex */
public final class r<T, U> extends a<T, U> {

    final Callable<? extends U> b;
    final i.b.l0.b<? super U, ? super T> c;

    static final class a<T, U> implements y<T>, i.b.j0.b {

        final y<? super U> a;
        final i.b.l0.b<? super U, ? super T> b;
        final U c;
        i.b.j0.b v;
        boolean w;
        a(y<? super U> yVar, U u, i.b.l0.b<? super U, ? super T> bVar) {
            super();
            this.a = yVar;
            this.b = bVar;
            this.c = u;
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
            this.a.onNext(this.c);
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
                this.b.a(this.c, t);
            } catch (Throwable th) {
                this.v.dispose();
                onError(th);
            }
        }

        public void onSubscribe(i.b.j0.b bVar) {
            if (c.validate(this.v, bVar)) {
                this.v = bVar;
                this.a.onSubscribe(this);
            }
        }
    }
    public r(w<T> wVar, Callable<? extends U> callable, i.b.l0.b<? super U, ? super T> bVar) {
        super(wVar);
        this.b = callable;
        this.c = bVar;
    }

    @Override // i.b.m0.e.e.a
    protected void subscribeActual(y<? super U> yVar) {
        try {
            Object call = this.b.call();
            b.e(call, "The initialSupplier returned a null value");
        } catch (Throwable th) {
            d.error(th, yVar);
            return;
        }
        this.a.subscribe(new r.a(yVar, call, this.c));
    }
}
